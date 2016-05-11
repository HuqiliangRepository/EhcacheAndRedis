import dw.spring4.restful.dao.impl.tUserInfoDaoImpl;
import dw.spring4.restful.dao.tUserInfoDao;
import dw.spring4.restful.model.t_user_info;
import dw.spring4.restful.until.SerializeUtil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.orm.hibernate4.HibernateTemplate;



import java.util.List;


public class RedisTest {

    private StringRedisTemplate redisTemplate;
    private ApplicationContext ac;
    private static tUserInfoDao tufmock;

    @Before
    public void setUp() throws Exception {


        /*一下这段代码都是mock代码，是用于mock对象初始化，创建mock对象，当mock对象调用未实现的方法或者对象时mock对象会返回制定的数据值给使用者*/
        ac = new ClassPathXmlApplicationContext("rest-servlet.xml");/*这里是获取spring上下文引用对象*/
        HibernateTemplate hibernateTemplate = (HibernateTemplate) ac.getBean("hibernateTemplate");/*这里是调用hibernatetemplte模板对象*/
        t_user_info tui = hibernateTemplate.get(t_user_info.class, "991".toString());/*这里是模板对象掉用数据库查询方法*/

        tufmock = mock(tUserInfoDaoImpl.class);/*这里是创建一个mock对象用于调用未实现类的方法*/
        when(tufmock.getuser("991".toString())).thenReturn(tui);/*这里是指当mock对象调用未实现类方法的时候，因该返回什么样的值*/
    }
    @After
    public void tearDown() throws Exception {


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
    public  void testRedRedis3() {
        ac = new ClassPathXmlApplicationContext("rest-servlet.xml");
        redisTemplate = (StringRedisTemplate) ac.getBean("redisTemplate");
       final HibernateTemplate hibernateTemplate = (HibernateTemplate) ac.getBean("hibernateTemplate");
                    final List<t_user_info> tuilist = hibernateTemplate.loadAll(t_user_info.class);
                    redisTemplate.execute(new RedisCallback<Object>() {

                        public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {

                            redisConnection.setNX("huqiliang".getBytes(), SerializeUtil.serialize(tuilist));

                            return null;
                        }
                    });


    }



    @Test
    public void testRedRedis4() {
        ac = new ClassPathXmlApplicationContext("rest-servlet.xml");
        redisTemplate = (StringRedisTemplate) ac.getBean("redisTemplate");
       List<t_user_info> ll=(List<t_user_info>)redisTemplate.execute(new RedisCallback<Object>() {

            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] value = redisConnection.get("huqiliang".getBytes());
                List<t_user_info> tuilist = (List<t_user_info>) SerializeUtil.unserialize(value);
                System.out.println(value.length);
                System.out.println(tuilist.toString());
                return tuilist;
            }

        });


    }


    @Test
    public void testMockGetUser() {


        String user_id = "991";
        t_user_info tuimock = tufmock.getuser(user_id);/*这里是调用mock对象调用为实现类的方法*/
        System.out.println("市场名称" + tuimock.getAccount_name());
        System.out.println("市场联系电话:" + tuimock.getContact_telephone());
        org.junit.Assert.assertNotNull(tuimock);
        org.junit.Assert.assertEquals(user_id, tuimock.getUser_id());


    }

    @Test
    public void testRedRedis5() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("rest-servlet.xml");
        final StringRedisTemplate redisTemplate = (StringRedisTemplate) ac.getBean("redisTemplate");
        final HibernateTemplate hibernateTemplate = (HibernateTemplate) ac.getBean("hibernateTemplate");

        final List<t_user_info> tuilist = hibernateTemplate.loadAll(t_user_info.class);
        redisTemplate.execute(new RedisCallback<Object>() {

            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {

                redisConnection.setNX("tuilist".getBytes(), SerializeUtil.serialize(tuilist));

                return null;
            }
        });


        redisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] value = redisConnection.get("tuilist".getBytes());
                List<t_user_info> tuilist = (List<t_user_info>) SerializeUtil.unserialize(value);
                System.out.println(tuilist);
                for (int i = 0; i < tuilist.size(); i++) {
                    t_user_info tui = tuilist.get(i);
                    System.out.println(tui.getAccount_name());

                }
                return tuilist;
            }
        });

    }

}