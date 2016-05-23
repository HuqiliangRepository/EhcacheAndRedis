package com.huqiliang.proxy.tank;

import com.huqiliang.proxy.interf.Moveable;

import java.util.Random;

/**
 * Created by root on 4/26/16.
 */
public class tank1 implements Moveable {
    public void move() {

        long start = System.currentTimeMillis();
        try {
            System.out.println("坦克移动.......");
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        // System.out.println("运行总时间:" + (start-end));

    }

    public void stop() {
        System.out.println("坦克停止运行");

    }
}
