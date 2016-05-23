package com.huqiliang.proxy.tank;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by root on 5/3/16.
 */
public interface InvocationHandler {
    public void Invoke(Object o,Method m) throws InvocationTargetException, IllegalAccessException;
}
