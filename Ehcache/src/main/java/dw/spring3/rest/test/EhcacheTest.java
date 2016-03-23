
package dw.spring3.rest.test;

import dw.spring3.rest.bean.t_user_info;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    public void testEhcache() {
     /*   Session session=sf.openSession();
        session.beginTransaction();
        BigInteger bigInteger = BigInteger.valueOf(991);
        t_user_info tui=(t_user_info)session.load(t_user_info.class,bigInteger);
        System.out.print(tui.getAccount_name());

        t_user_info tui1=(t_user_info)session.load(t_user_info.class,bigInteger);
        System.out.print(tui1.getAccount_name());
        session.getTransaction().commit();
        session.close();*/
        System.out.print(t_user_info.class.getClassLoader().getResource("ehcache.xml").getPath());
    }

    @Test
    public void testEhcache1() {
        Session session = sf.openSession();
        session.beginTransaction();
        BigInteger bigInteger = BigInteger.valueOf(991);
        t_user_info tui = (t_user_info) session.load(t_user_info.class, bigInteger);
        System.out.println(tui.getAccount_name());
        session.getTransaction().commit();
        session.close();

        Session session2 = sf.openSession();
        session2.beginTransaction();
        BigInteger bigInteger1 = BigInteger.valueOf(991);
        t_user_info tui1 = (t_user_info) session2.load(t_user_info.class, bigInteger1);
        System.out.println(tui1.getAccount_name());
        session2.getTransaction().commit();
        session2.close();
    }

    @Test
    public void testQueryEhcache() {
        Session session = sf.openSession();
        session.beginTransaction();
        BigInteger bigInteger = BigInteger.valueOf(991);
        List<t_user_info> tui = (List<t_user_info>) session.createQuery("from t_user_info as tui where tui.user_id=991").setCacheable(true).list();
        List<t_user_info> tui1 = (List<t_user_info>) session.createQuery("from t_user_info as tui where tui.user_id=991").setCacheable(true).list();
        session.getTransaction().commit();
        session.close();

    }


}