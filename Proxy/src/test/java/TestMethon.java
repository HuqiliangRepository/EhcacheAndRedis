import java.lang.reflect.Method;

/**
 * Created by root on 5/3/16.
 */
public class TestMethon {
    public static void main(String[] args) {
        Method[] methods=com.huqiliang.proxy.interf.Moveable.class.getMethods();
        for (Method m:methods) {
            System.out.println(m.getName());
        }
    }
}
