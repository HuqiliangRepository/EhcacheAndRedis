import com.huqiliang.Iterator.Cat;
import com.huqiliang.interfaces.Collection;
import com.huqiliang.interfaces.Iterator;
import com.huqiliang.man.LinkList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.huqiliang.man.ArrayList;


/** 
* ArrayList Tester. 
* 
* @author <Authors name> 
* @since <pre>Apr 21, 2016</pre> 
* @version 1.0 
*/ 
public class ArrayListTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: add(Object o) 
* 
*/ 
@Test
public void testAdd() throws Exception { 
//TODO: Test goes here...
    //Collection c=new ArrayList();
    Collection c=new LinkList();
    for (int i = 0; i <15 ; i++) {

        c.add(new Cat(i, "cat" + i));
    }
    System.out.println(c.size());

    Iterator it=c.iterator();
    while (it.hasNext()){
        Cat cat=(Cat)it.next();
        System.out.println(cat.toString());
    }


} 



} 
