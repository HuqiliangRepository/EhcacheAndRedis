package com.huqiliang.redis;

import com.huqiliang.model.t_user_info;
import com.huqiliang.until.SerializeUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.List;

/**
 * Created by root on 4/6/16.
 */
public class Main {
    public static void main(String[] args) {
       String filepath=System.getProperty("user.dir");
        System.out.println("输出当前路径:"+filepath);
        ApplicationContext context = new ClassPathXmlApplicationContext("file:/root/mavenproject/jartest/target/classes/rest-servlet.xml");


        final HibernateTemplate hibernateTemplate = (HibernateTemplate) context.getBean("hibernateTemplate");
        final StringRedisTemplate redisTemplate = (StringRedisTemplate) context.getBean("redisTemplate");
        final long timeInterval = 10000;//定时任务时间间隔
        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {
                    final List<t_user_info> tuilist = hibernateTemplate.loadAll(t_user_info.class);
                    redisTemplate.execute(new RedisCallback<Object>() {

                        public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {

                            redisConnection.setNX("tuilist".getBytes(), SerializeUtil.serialize(tuilist));

                            return null;
                        }
                    });
                    try {
                        Thread.sleep(timeInterval);


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("Hello World!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
