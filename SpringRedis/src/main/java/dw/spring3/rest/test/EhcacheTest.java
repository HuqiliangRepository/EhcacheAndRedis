package dw.spring3.rest.test;
import com.alibaba.fastjson.JSON;
import dw.spring3.rest.bean.t_user_info;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.orm.hibernate4.HibernateTemplate;


import java.math.BigInteger;
import java.util.List;



public class EhcacheTest {
    private static SessionFactory sf;

    @Before
    public void setUp() throws Exception {

/*
        ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
        sf = new Configuration().configure().buildSessionFactory(srb.buildServiceRegistry());
*/
        Configuration cfg= new Configuration().configure();
        sf = cfg.buildSessionFactory(new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry());

    }

    @After
    public void tearDown() throws Exception {

        sf.close();
    }

    @Test
    public void testSchemaExport() {
       /* new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);*/
        Configuration cfg= new Configuration().configure();
        SchemaExport export= new SchemaExport(cfg);
        export.create(false,true);

    }



    @Test
    public void testRedis(){


        ApplicationContext ac =  new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
        final  StringRedisTemplate redisTemplate=(StringRedisTemplate)ac.getBean("redisTemplate");
        Session session=sf.openSession();
        session.beginTransaction();
        BigInteger bigInteger = BigInteger.valueOf(991);
        final t_user_info tui=(t_user_info)session.load(t_user_info.class,bigInteger);
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
    /*            redisConnection.set(redisTemplate.getStringSerializer().serialize("t_user_info.id"+tui.getUser_id()),

                        redisTemplate.getStringSerializer().serialize("t_user_info.name"+tui.getAccount_name()));*/
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] key=serializer.serialize("userId:"+tui.getUser_id().toString());
                byte[] name=serializer.serialize("username:"+tui.getAccount_name().toString());
                redisConnection.setNX(key,name);
                return null;
            }
        });
        System.out.print(tui.getAccount_name());

        t_user_info tui1=(t_user_info)session.load(t_user_info.class,bigInteger);
        System.out.print(tui1.getAccount_name());
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testEhcache1(){
        Session session=sf.openSession();
        session.beginTransaction();
        BigInteger bigInteger = BigInteger.valueOf(991);
        t_user_info tui=(t_user_info)session.load(t_user_info.class,bigInteger);
        System.out.println(tui.getAccount_name());
        session.getTransaction().commit();
        session.close();

        Session session2=sf.openSession();
        session2.beginTransaction();
        BigInteger bigInteger1 = BigInteger.valueOf(991);
        t_user_info tui1=(t_user_info)session2.load(t_user_info.class,bigInteger1);
        System.out.println(tui1.getAccount_name());
        session2.getTransaction().commit();
        session2.close();
    }
    @Test
    public void testQueryEhcache(){
        Session session=sf.openSession();
        session.beginTransaction();
        BigInteger bigInteger = BigInteger.valueOf(991);
        List<t_user_info> tui=(List<t_user_info>)session.createQuery("from t_user_info as tui where tui.user_id=991").setCacheable(true).list();
        List<t_user_info> tui1=(List<t_user_info>)session.createQuery("from t_user_info as tui where tui.user_id=991").setCacheable(true).list();
        session.getTransaction().commit();
        session.close();

    }

    @Test
    public void testRedis1(){
        ApplicationContext ac =  new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
        final  StringRedisTemplate redisTemplate=(StringRedisTemplate)ac.getBean("redisTemplate");
         HibernateTemplate hibernateTemplate=(HibernateTemplate)ac.getBean("hibernateTemplate");
        final List<t_user_info> list =  hibernateTemplate.loadAll(t_user_info.class);
        final String str= JSON.toJSONString(list);
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();

                    byte[] key=serializer.serialize("huqiliang");
                    byte[] name=serializer.serialize(str);
                    redisConnection.setNX(key,name);

                return null;
            }
        });


    }

    @Test
    public boolean testRedRedis1(){
        ApplicationContext ac =  new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
        final  StringRedisTemplate redisTemplate=(StringRedisTemplate)ac.getBean("redisTemplate");
        HibernateTemplate hibernateTemplate=(HibernateTemplate)ac.getBean("hibernateTemplate");
        final List<t_user_info> list =  hibernateTemplate.loadAll(t_user_info.class);
        String str= JSON.toJSONString(list);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                     RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                     byte[] key=serializer.serialize("huqiliang");
                     byte[] value = connection.get(key);
                     serializer.deserialize(value);

             return true;
            }
        }, false, true);
        System.out.println("≤‚ ‘≥…π¶¡À");
        return result;

    }


}