package com.huqiliang.test;



import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.awt.*;
import java.applet.*;
import java.io.FileInputStream;
import java.net.*;


/**
 * Created by huqiliang on 16-2-21.
 */
class ThreadImp implements Runnable{


    @Override
    public void run() {
        try {
           System.out.println("开始执行线程当中run()方法当中的内容");
            Thread.sleep(1000);

            try {
                FileInputStream filesau=new FileInputStream("10kz.wav");
                AudioStream as=new AudioStream(filesau);
                AudioPlayer.player.start(as);

            }catch (Exception e){

                e.printStackTrace();
            }

            System.out.println("结束执行线程当中run()方法的运行");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}



public class JoinTest {
    public static void main(String[] args){

        Thread t=new Thread(new ThreadImp());
        t.start();
        try {
            t.join(1000);
            if (t.isAlive()) {

                System.out.println("线程程序正在运行");
            }else {
                System.out.println("线程程序已经结束");
            }
            System.out.println("join执行程序已经结束");

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
