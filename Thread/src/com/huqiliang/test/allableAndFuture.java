package com.huqiliang.test;

/**
 * Created by root on 16-2-15.
 */

import java.util.concurrent.*;

class callableAndFuture {
    
    //创建线程类
    public static class CallableTest implements Callable<String>{
        @Override
        public String call() throws Exception {
            int m=0;
            String s="这是一个调用callable方法的线程计数器";
            for (int i = 0; i <10 ; i++) {
                m=m+i;
                System.out.println(s+m);
            }

            return s;
        }
    }

    public static void main(String[] args){

        ExecutorService threadpool= Executors.newSingleThreadExecutor();
        //启动线程
        Future<String> future0=threadpool.submit(new CallableTest());
        Future<String> future1=threadpool.submit(new CallableTest());
        try {


            System.out.println("等待线程完成......");
            System.out.println("线程执行结束后地返回值----"+future0.get());//获得线程执行结束后地返回值
            System.out.println("线程执行结束后地返回值----"+future1.get());//获得线程执行结束后地返回值
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
