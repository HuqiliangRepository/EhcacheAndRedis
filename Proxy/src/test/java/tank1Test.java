import com.huqiliang.proxy.interf.Moveable;
import com.huqiliang.proxy.tank.TankTimeProxy_back;
import com.huqiliang.proxy.tank.TimeTankHandler;
import com.huqiliang.proxy.tank.proxy;
import com.huqiliang.proxy.tank.tank1;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* tank1 Tester. 
* 
* @author <Authors name> 
* @since <pre>Apr 26, 2016</pre> 
* @version 1.0 
*/ 
public class tank1Test { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: move() 
* 
*/ 
@Test
public void testMove() throws Exception { 
//TODO: Test goes here...
   tank1 t1=new tank1();
   TimeTankHandler tth=new TimeTankHandler(t1);
    Moveable m= (Moveable) proxy.newProxyInstance(Moveable.class,tth);

    m.move();
} 


} 
