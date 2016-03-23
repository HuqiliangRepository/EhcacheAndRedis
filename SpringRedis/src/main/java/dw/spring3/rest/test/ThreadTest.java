package dw.spring3.rest.test;

import java.beans.IntrospectionException;

/**
 * Created by root on 16-2-13.
 */

class ThreadDemo extends Thread {

   @Override
    public void run() {

       System.out.println("这是一个多线程地程序：开始");
       try {
           Thread.sleep(1000);
           System.out.println("休眠结束");

       }catch (InterruptedException e){

           e.printStackTrace();
       }
       System.out.println("这是一个多线程程序");



   }

}



class Test{

    public static void test1(){

        System.out.println("测试1：开始");
        Thread t1=new ThreadDemo();
        t1.start();
        System.out.print("测试1:结束");

    }
    public static  void test2(){
        System.out.print("测试2:开始");
        Thread t1=new ThreadDemo();
        t1.run();
        System.out.println("测试2:结束");
    }


    public static void main(String[] args){
        test1();
    try {
        Thread.sleep(5000);

    }catch (InterruptedException e){
        e.printStackTrace();
    }

        System.out.println();
        test2();

    }



}




