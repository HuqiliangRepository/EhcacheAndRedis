package com.huqiliang.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by huqiliang on 16-2-16.
 */
public class vector {


    public static void main(String[] args){


        Vector vc=new Vector();
        vc.add(0,"add");
        vc.add(1,"这是一个vector测试");
        vc.add(2,"测试vector内容");
        vc.add(3,"你是一个大傻比");
        for (int i = 0; i <vc.size() ; i++) {


            System.out.println("输出vector当中的内容：" + vc.get(i));
        }

        Vector data=new Vector();
        List list=new ArrayList();
        list.add("输出list当中的内容1");
        list.add("输出list当中的内容2");
        list.add("输出list当中的内容3");
        list.add("输出list当中的内容4");
        list.add("输出list当中的内容5");
        data.add(list);
        data.add("输出vector当中的内容6");
        data.add("输出vector当中的内容7");
        for (int i = 0; i <data.size() ; i++) {
            if (data.get(i) instanceof List) {
                List l=(List)(data.get(i));
                for (int j = 0; j <list.size() ; j++) {
                        System.out.println("输出List当中地vector的内容"+l.get(j));
                }

            }else {
                System.out.println("输出vector-------当中地内容："+data.get(i));
            }

        }

    }
}
