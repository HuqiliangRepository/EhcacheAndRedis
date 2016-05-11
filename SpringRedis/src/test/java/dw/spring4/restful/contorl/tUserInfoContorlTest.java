package dw.spring4.restful.contorl;

import dw.spring4.restful.service.tUserInfoService;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by root on 4/19/16.
 */
public class tUserInfoContorlTest extends TestCase {
    private ApplicationContext ac;

    @Before
    public void setUp() throws Exception {
        ac = new ClassPathXmlApplicationContext("rest-servlet.xml");

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetAll() throws Exception {
        tUserInfoService tis = (tUserInfoService) ac.getBean("tUserInfoService");
        tis.getAll();

    }
}