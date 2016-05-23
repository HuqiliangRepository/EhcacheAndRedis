package com.huqiliang.proxy.tank;

import com.huqiliang.proxy.interf.Moveable;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;


/**
 * Created by root on 4/27/16.
 */
public class proxy {
    public static Object newProxyInstance(Class interf,InvocationHandler h) throws Exception {


        String methodstr = "";
        String format = "\n";
        Method[] methods = interf.getMethods();
        for (Method m : methods) {
            methodstr += "public void " + m.getName() + "()" + "{" + format +

                    "try{"+format+
                    "Method md="+interf.getName()+".class.getMethod(\""+m.getName()+"\");"+format+
                    "    h.Invoke(this,md);" + format +
                    "}"+format+
                    "catch(Exception e) {"+format+
                    "e.printStackTrace();"+format+
                    "}"+format+

                    "}";
        }

        String src = "package com.huqiliang.proxy.tank;" + format +
                "import com.huqiliang.proxy.interf.Moveable;" + format +
                "import java.lang.reflect.Method;"+format+
                "public class TankTimeProxy implements " + interf.getName() + " {" + format +
                "com.huqiliang.proxy.tank.InvocationHandler h;"+format+
                "public TankTimeProxy(InvocationHandler h) {" + format +
                "    this.h = h;" + format +
                "}" + format +
                methodstr + format +
                "}";


        String filename = System.getProperty("user.dir") + "/src/main/java/com/huqiliang/proxy/tank/TankTimeProxy.java";
        System.out.println(System.getProperty("user.dir"));

        try {
            File f = new File(filename);
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(filename);
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        System.out.println(javaCompiler.getClass().getName());
        StandardJavaFileManager filemgr = javaCompiler.getStandardFileManager(null, null, null);

        Iterable units = filemgr.getJavaFileObjects(filename);
        JavaCompiler.CompilationTask t = javaCompiler.getTask(null, filemgr, null, null, null, units);
        t.call();
        try {
            filemgr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        URL[] urls = new URL[]{new URL("file:/" + System.getProperty("user.dir") + "/src")};
        URLClassLoader ul = new URLClassLoader(urls);

        Class c = ul.loadClass("com.huqiliang.proxy.tank.TankTimeProxy");
        System.out.println(c);

        Constructor constructor = c.getConstructor(InvocationHandler.class);
        Object o = constructor.newInstance(h);
        //   moveable.move();

        return o;

    }
}
