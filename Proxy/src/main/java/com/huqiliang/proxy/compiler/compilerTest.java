package com.huqiliang.proxy.compiler;

import com.huqiliang.proxy.interf.Moveable;
import com.huqiliang.proxy.tank.tank1;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by root on 4/27/16.
 */
public class compilerTest {

    public static void main(String[] args) {

        String format = "\n";
        String src = "package com.huqiliang.proxy.tank;" +format+
                     "import com.huqiliang.proxy.interf.Moveable;"+format+
                "public class TankTimeProxy implements Moveable {" +format+
                "    Moveable tk1;" +format+

                "public TankTimeProxy(Moveable tk1) {" +format+
                "    this.tk1 = tk1;" +format+
                "}" +format+

                "public void move() {" +format+
                "    long start=System.currentTimeMillis();" +format+
                "    System.out.println(\"方法开始时间...........\"+start);" +format+

                "    tk1.move();" +format+
                "    long end=System.currentTimeMillis();" +format+
                "    System.out.println(\"方法开始时间...........\"+end);" +format+
                "    System.out.println(\"运行总时间:\" + (end - start));" +format+

                "}" +format+
                "}";


        String filename = System.getProperty("user.dir") + "/src/main/java/com/huqiliang/proxy/tank/TankTimeProxy.java";
        System.out.println(System.getProperty("user.dir"));

        try {
            File f=new File(filename);
            FileWriter fw =new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(filename);
        JavaCompiler javaCompiler= ToolProvider.getSystemJavaCompiler();
        System.out.println(javaCompiler.getClass().getName());
        StandardJavaFileManager filemgr=javaCompiler.getStandardFileManager(null,null,null);

        Iterable units=filemgr.getJavaFileObjects(filename);
        JavaCompiler.CompilationTask t=javaCompiler.getTask(null,filemgr,null,null, null,units);
        t.call();
        try {
            filemgr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            URL[] urls=new URL[]{ new URL("file:/"+System.getProperty("user.dir") + "/src") };
            URLClassLoader ul=new URLClassLoader(urls);
            try {
                Class c=ul.loadClass("com.huqiliang.proxy.tank.TankTimeProxy");
                System.out.println(c);
                try {
                    Constructor constructor=c.getConstructor(Moveable.class);
                    Moveable moveable= (Moveable) constructor.newInstance(new tank1());
                    moveable.move();


                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }



}

