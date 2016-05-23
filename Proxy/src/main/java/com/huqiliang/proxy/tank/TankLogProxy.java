package com.huqiliang.proxy.tank;

import com.huqiliang.proxy.interf.Moveable;

/**
 * Created by root on 4/26/16.
 */
public class TankLogProxy implements Moveable {
    Moveable tk1;

    public TankLogProxy(Moveable tk1) {
        this.tk1 = tk1;
    }

    public void move() {
        System.out.println("记录方法日志开始.......");

        tk1.move();
        long end=System.currentTimeMillis();
        System.out.println("记录方法日志结束.......");
    }

    public void stop() {

    }
}
