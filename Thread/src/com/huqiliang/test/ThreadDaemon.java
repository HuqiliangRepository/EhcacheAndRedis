package com.huqiliang.test;

/**
 * Created by huqiliang on 16-2-21.
 */
public class ThreadDaemon extends Thread{

    @Override
    public void run() {
        System.out.println("输出当前运行的线程名字:"+Thread.currentThread().getName()+"#begin");
        try {

            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("输出当前运行的线程名字:"+Thread.currentThread().getName()+"#end");
    }
}
class TestThreadDaemon{
    public static void main(String[] arts){
        System.out.println("开始线程测试方法");
        Thread t1=new ThreadDaemon();
        t1.setDaemon(true);
        t1.start();
        System.out.println("结束线程测试方法");

    }




}
