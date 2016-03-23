package com.huqiliang.test;

/**
 * Created by huqiliang on 16-2-19.
 */
public class CallSync {
    public synchronized static void synchronizedMethon(){

        System.out.println("调用普通类的同步方法-------synchronizedMethon");
        try {
            Thread.sleep(1000);

        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    public synchronized static void generalMethon(){
        System.out.println("调用普通类的静态同步方法------generalMethon");
    }




}

class mutiThread{
   //static final CallSync cs=new CallSync();
    public static void main(String[] args){

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                //cs.synchronizedMethon();
                CallSync.synchronizedMethon();
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                //cs.generalMethon();
                CallSync.generalMethon();
            }
        });
        t1.start();
        t2.start();
    }
}
