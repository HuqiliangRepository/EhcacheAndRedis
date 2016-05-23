package com.huqiliang.proxy.abstractFactory;

/**
 * Created by root on 5/9/16.
 */
public class Test {
    public static void main(String[] args) {

        Car car=new Car();
        car.move();
        AK47 ak47=new AK47();
        ak47.shout();
        Apple apple=new Apple();
        apple.prinatName();
    }

}
