import dw.spring4.restful.model.t_user_info;
import dw.spring4.restful.until.SerializeUtil;
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
import java.sql.Date;
import java.util.List;


public class RedisTest {
    private static SessionFactory sf;
    private StringRedisTemplate redisTemplate;
    private ApplicationContext ac;


    @Before
    public void setUp() throws Exception {

/*
        ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
        sf = new Configuration().configure().buildSessionFactory(srb.buildServiceRegistry());
*/
        Configuration cfg = new Configuration().configure();
        sf = cfg.buildSessionFactory(new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry());


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
        export.create(false, true);

    }


    @Test
    public void testRedRedis1() {
        ac = new ClassPathXmlApplicationContext("rest-servlet.xml");
        redisTemplate = (StringRedisTemplate) ac.getBean("redisTemplate");
        HibernateTemplate hibernateTemplate = (HibernateTemplate) ac.getBean("hibernateTemplate");
        final List<t_user_info> list = hibernateTemplate.loadAll(t_user_info.class);
        redisTemplate.execute(new RedisCallback<Object>() {

            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();

                byte[] key = serializer.serialize("huqiliang");
                byte[] value =serializer.serialize(list.toString());
                redisConnection.setNX(key,value);
              //  redisTemplate.opsForHash().put("t_user_info","huqiliang",list.toString());
                byte[] value1 = redisConnection.get(key);
                String name = serializer.deserialize(value1);
        /*        try {
                    ObjectMapper objectMapper=new ObjectMapper();


                    TuiList tuilist=objectMapper.readValue(name, TuiList.class);
                    list=tuilist.getTuilist();
                }catch (Exception e){
                        e.printStackTrace();
                }*/

                System.out.println(name);
                return null;
            }
        });
       // }
        System.out.println("测试成功");
    }

    @Test
    public void testRedRedis2() {
        ac = new ClassPathXmlApplicationContext("rest-servlet.xml");
        redisTemplate = (StringRedisTemplate) ac.getBean("redisTemplate");

        final RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
        byte[] key = serializer.serialize("huqiliang");
        final Long pwdLogSize=redisTemplate.opsForValue().size("huqiliang");
        List<Object> pwdLogList=redisTemplate.executePipelined(new RedisCallback<String>() {

            public String doInRedis(RedisConnection conn)
                    throws DataAccessException {
                for (int i=0 ;i<pwdLogSize ;i++) {
                    byte[] listName  = serializer.serialize("huqiliang");
                    conn.rPop(listName);
                }
                return null;
            }
        }, serializer);

    }

    @Test
    public  void testRedRedis3() {
        ac = new ClassPathXmlApplicationContext("rest-servlet.xml");
        redisTemplate = (StringRedisTemplate) ac.getBean("redisTemplate");
       final HibernateTemplate hibernateTemplate = (HibernateTemplate) ac.getBean("hibernateTemplate");
        final long timeInterval = 1000;//定时任务时间间隔
        Runnable runnable=new Runnable() {
            public void run() {
                while (true){
                    final List<t_user_info> tuilist = hibernateTemplate.loadAll(t_user_info.class);
                    redisTemplate.execute(new RedisCallback<Object>() {

                        public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {

                            redisConnection.setNX("tuilist".getBytes(), SerializeUtil.serialize(tuilist));

                            return null;
                        }
                    });
                    try {
                        Thread.sleep(timeInterval);


                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }


                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();


    }



    @Test
    public void testRedRedis4() {
        ac = new ClassPathXmlApplicationContext("rest-servlet.xml");
        redisTemplate = (StringRedisTemplate) ac.getBean("redisTemplate");
        HibernateTemplate hibernateTemplate = (HibernateTemplate) ac.getBean("hibernateTemplate");

       List<t_user_info> ll=(List<t_user_info>)redisTemplate.execute(new RedisCallback<Object>() {

            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] value = redisConnection.get("tuilist".getBytes());
                List<t_user_info> tuilist = (List<t_user_info>) SerializeUtil.unserialize(value);
                return tuilist;
            }

        });


    }
/*
    public static void  main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("rest-servlet.xml");
        final StringRedisTemplate redisTemplate = (StringRedisTemplate) ac.getBean("redisTemplate");
        final HibernateTemplate hibernateTemplate = (HibernateTemplate) ac.getBean("hibernateTemplate");
        final long timeInterval = 10000;//定时任务时间间隔
        Runnable runnable=new Runnable() {
            public void run() {
                while (true){
                    final List<t_user_info> tuilist = hibernateTemplate.loadAll(t_user_info.class);
                    redisTemplate.execute(new RedisCallback<Object>() {

                        public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {

                            redisConnection.setNX("tuilist".getBytes(), SerializeUtil.serialize(tuilist));
                            return null;
                        }
                    });
                    try {
                        Thread.sleep(timeInterval);


                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }


                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

    }*/





}