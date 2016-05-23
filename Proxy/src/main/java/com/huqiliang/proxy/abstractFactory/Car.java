package com.huqiliang.proxy.abstractFactory;

import com.huqiliang.proxy.interf.Moveable;

/**
 * Created by root on 5/9/16.
 */
public class Car implements Moveable{

    public Car() {
    }

    public void move() {
        System.out.println("汽车开始移动......");
    }
}
