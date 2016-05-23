package com.huqiliang.man;

/**
 * Created by root on 4/21/16.
 */
import com.huqiliang.interfaces.Collection;
import com.huqiliang.interfaces.Iterator;

public class ArrayList implements Collection{
    Object[] objects=new Object[10];

    int index=0;
    public void add(Object o){

        if ( index== objects.length) {

            Object[] newobjects=new Object[objects.length*2];
            System.arraycopy(objects,0,newobjects,0,objects.length);
            objects=newobjects;
        }
        objects[index]=o;
        index++;
    }
    public int size(){

        return index;
    }

    public Iterator iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator{

        private int count=0;

        public Object next() {

          Object o= objects[count];
            count++;
            return o;
        }

        public boolean hasNext() {
            if (count>=index) {
                return false;
            }else return true;

        }
    }

}
