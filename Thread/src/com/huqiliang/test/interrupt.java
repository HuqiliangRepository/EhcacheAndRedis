package com.huqiliang.test;

/**
 * Created by huqiliang on 16-2-17.
 */
public class interrupt {

    public static void main(String[] args){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <10 ; i++) {


                    System.out.println("线程准备休息了sleep-----");
                    try {
                         Thread.sleep(500);
                    }catch (InterruptedException e){
                        System.out.println("线程捕获interrupted异常");
                      //  e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        thread.interrupt();
        thread.interrupt();


    }
}
