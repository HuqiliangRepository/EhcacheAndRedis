package dw.spring3.rest.test;

import com.alibaba.fastjson.JSON;
import dw.spring3.rest.bean.t_user_info;
import org.hibernate.Session;
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

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;


public class RedisTest {
    private static SessionFactory sf;
    private StringRedisTemplate redisTemplate;
    private ApplicationContext ac;
    private List<t_user_info> list;
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

      //  redisTemplate=null;
      //  ac=null;
     //   list.clear();
      //  list=null;
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
            public Objects doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();

                byte[] key=serializer.serialize("huqiliang");
                byte[] name=serializer.serialize(str);
                redisConnection.setNX(key,name);
                return null;
            }
        });


    }

    @Test
    public void testRedRedis1(){
        ac =  new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
        redisTemplate=(StringRedisTemplate)ac.getBean("redisTemplate");
        HibernateTemplate hibernateTemplate=(HibernateTemplate)ac.getBean("hibernateTemplate");
        list =  hibernateTemplate.loadAll(t_user_info.class);

        String str= JSON.toJSONString(list);

        System.out.println(str);
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();

                byte[] key = serializer.serialize("huqiliang");
                byte[] value = redisConnection.get(key);

                String name = serializer.deserialize(value);

                System.out.println();
                return null;
            }
        });
        System.out.println("���Գɹ���");

    }


}