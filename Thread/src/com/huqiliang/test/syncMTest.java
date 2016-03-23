package com.huqiliang.test;

/**
 * Created by huqiliang on 16-2-18.
 */
public class syncMTest {

    public synchronized void synchronizedMethon(){
        System.out.println("开始调用同步方法(synchronized)");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("结束调用同步方法(synchronized)");
    }
    public void generalMethon(){

        System.out.println("这是调用一个普通方法输出的结果");
    }
}

class Myclass{


    static final syncMTest st=new syncMTest();
    public static void main(String[] args){
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
               st.synchronizedMethon();
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                st.generalMethon();
            }
        });
        t1.start();
        t2.start();
    }

}
