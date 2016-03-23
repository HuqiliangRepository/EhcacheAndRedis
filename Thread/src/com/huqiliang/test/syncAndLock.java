package com.huqiliang.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by huqiliang on 16-2-18.
 */
public class syncAndLock {
    private int value=0;
    Lock lock=new ReentrantLock();
    public synchronized void addValueSync(){
        this.value++;
        System.out.println("addValueSync线程输出"+Thread.currentThread().getName()+"计算的和"+value);


    }
    public void addValueLock(){
        try {
            lock.lock();
            value++;
            System.out.println("addValueLock线程输出"+Thread.currentThread().getName()+"计算的和"+value);
        }finally {
            lock.unlock();

        }
    }

}
class Test_synAndLock{
    public static void main(String[] args){
    final syncAndLock sl=new syncAndLock();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <10 ; i++) {
                    sl.addValueSync();
                    try {
                        Thread.sleep(20);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i <20 ; i++) {

                    sl.addValueLock();
                    try {
                        Thread.sleep(10);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

            }
        });
        t1.start();
        t2.start();
    }


}
