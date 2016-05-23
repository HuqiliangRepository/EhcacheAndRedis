package com.huqiliang.redis;


import com.huqiliang.model.t_user_info;
import com.huqiliang.until.SerializeUtil;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.orm.hibernate4.HibernateTemplate;



import java.util.*;


public class RedisTest {
    private static SessionFactory sf;
    private StringRedisTemplate redisTemplate;
    private ApplicationContext ac;


    @Before
    public void setUp() throws Exception {

        Configuration cfg = new Configuration().configure();
        sf = cfg.buildSessionFactory(new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry());



        /*一下这段代码都是mock代码，是用于mock对象初始化，创建mock对象，当mock对象调用未实现的方法或者对象时mock对象会返回制定的数据值给使用者*/
        ac = new ClassPathXmlApplicationContext("rest-servlet.xml");/*这里是获取spring上下文引用对象*/
        HibernateTemplate hibernateTemplate = (HibernateTemplate) ac.getBean("hibernateTemplate");/*这里是调用hibernatetemplte模板对象*/

    }
    @After
    public void tearDown() throws Exception {

        sf.close();
    }

    @Test
    public void testSchemaExport() {
       /* new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);*/
        Configuration cfg = new Configuration().configure();
        SchemaExport export = new SchemaExport(cfg);
        export.create(false, false);

    }


    @Test
    public void testRedRedis1() {
        ac = new ClassPathXmlApplicationContext("rest-servlet.xml");
        redisTemplate = (StringRedisTemplate) ac.getBean("redisTemplate");
        redisTemplate.execute(new RedisCallback<Object>() {

            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();

                byte[] key = serializer.serialize("tuilist");
                byte[] value1 = redisConnection.get(key);
                String name = serializer.deserialize(value1);


                System.out.println(name);
                return null;
            }
        });
       // }
        System.out.println("测试成功");
    }







    @Test
    public void testRedRedis4() {

        try {
            ac = new ClassPathXmlApplicationContext("rest-servlet.xml");
            redisTemplate = (StringRedisTemplate) ac.getBean("redisTemplate");
            List<t_user_info> ll=(List<t_user_info>)redisTemplate.execute(new RedisCallback<Object>() {
                public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                    byte[] value = redisConnection.get("tuilist".getBytes());
                    List<t_user_info> tuilist = (List<t_user_info>) SerializeUtil.unserialize(value);
                    System.out.println(value.length);
                    System.out.println(tuilist);
                    return null;
                }

            });
        }catch (Exception e){
            System.out.println(e);
        }



    }




}