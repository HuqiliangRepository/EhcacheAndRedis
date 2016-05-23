package com.huqiliang.proxy.tank;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by root on 5/3/16.
 */
public class TimeTankHandler implements InvocationHandler {
    private Object obj;

    public TimeTankHandler(Object obj) {
        this.obj = obj;
    }




    public void Invoke(Object o,Method m) throws InvocationTargetException, IllegalAccessException {
        long start=System.currentTimeMillis();
        System.out.println("方法开始时间..........."+start);
        m.invoke(obj);
        System.out.println(obj);
        long end=System.currentTimeMillis();
        System.out.println("方法开始时间..........."+end);
        System.out.println("运行总时间:" + (end - start));

    }
}
