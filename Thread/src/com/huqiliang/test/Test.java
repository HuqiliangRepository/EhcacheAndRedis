package com.huqiliang.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Created by root on 16-2-15.
 */
public class Test {

public static  void main(String[] args) throws InterruptedException{
    final Lock lock=new ReentrantLock();
    lock.lock();
    Thread thread=new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                lock.lockInterruptibly();

               // lock.lock();
                System.out.println("使用lock控制线程同步");


            }catch (InterruptedException e) {

                System.out.println("interrupted-----线程异常发生");
            }
        }
    });
    thread.start();
    thread.interrupt();
    Thread.sleep(1);



}


}
