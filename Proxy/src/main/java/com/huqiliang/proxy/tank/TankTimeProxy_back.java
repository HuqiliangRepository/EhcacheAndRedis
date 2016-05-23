package com.huqiliang.proxy.tank;

import com.huqiliang.proxy.interf.Moveable;

/**
 * Created by root on 4/26/16.
 */
public class TankTimeProxy_back implements Moveable {
    Moveable tk1;

    public TankTimeProxy_back(Moveable tk1) {
        this.tk1 = tk1;
    }

    public void move() {
        long start=System.currentTimeMillis();
        System.out.println("方法开始时间..........."+start);

        tk1.move();
        long end=System.currentTimeMillis();
        System.out.println("方法开始时间..........."+end);
        System.out.println("运行总时间:" + (end - start));

    }

    public void stop() {

        long start=System.currentTimeMillis();
        System.out.println("方法开始时间..........."+start);

     //   tk1.stop();
        long end=System.currentTimeMillis();
        System.out.println("方法开始时间..........."+end);
        System.out.println("运行总时间:" + (end - start));
    }
}
