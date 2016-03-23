package com.huqiliang.test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by huqiliang on 16-2-22.
 */
public class CollectionAndCollections {

    public static void main(String[] args){

        List<Integer> list=new LinkedList<Integer>();
        int array[]={5,6,73,2,8,9,10,31,1};
        for (int i = 0; i <array.length ; i++) {

            list.add(new Integer(array[i]));
        }
        Collections.sort(list);
        for (int i = 0; i <array.length ; i++) {
            System.out.println("输出排序候的数组内容"+list.get(i));
        }



    }
}
