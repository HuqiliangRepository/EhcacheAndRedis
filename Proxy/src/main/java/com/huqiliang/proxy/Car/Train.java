package com.huqiliang.proxy.Car;

import com.huqiliang.proxy.interf.Moveable;

/**
 * Created by root on 5/5/16.
 */
public class Train implements Moveable{

    private static Train train=new Train();
    public Train() {
    }

    public static Train getInstance(){
        return train;
    }

    public void move(){
        System.out.println("火车启动运行.........");
    }
}
