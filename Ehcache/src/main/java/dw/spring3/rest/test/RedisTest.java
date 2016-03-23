package dw.spring3.rest.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import dw.spring3.rest.bean.t_user_info;
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
import org.codehaus.jackson.map.ObjectMapper;
import java.util.List;
import java.util.ListIterator;


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
        list = hibernateTemplate.loadAll(t_user_info.class);
/*        final String str = JSON.toJSONString(list);
        System.out.println(str);
        JSONArray jsonArray = JSONArray.parseArray(str);

        ListIterator li = jsonArray.listIterator();
        while (li.hasNext()) {

            System.out.println(li.next().toString());

        }
        System.out.println(jsonArray);*/


        for (int i = 0; i < 100; i++) {


        redisTemplate.execute(new RedisCallback<Object>() {

            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {


                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();

                byte[] key = serializer.serialize("huqiliang");
                byte[] value =serializer.serialize(list.toString());
                redisConnection.setNX(key,value);
                byte[] value1 = redisConnection.get(key);
                String name = serializer.deserialize(value1);
                try {
                    ObjectMapper objectMapper=new ObjectMapper();
                    list=objectMapper.readValue(name,t_user_info.class);
                }catch (Exception e){
                        e.printStackTrace();
                }




                System.out.println(name);
                return null;
            }
        });
        }
        System.out.println("测试成功�?");
    }


}