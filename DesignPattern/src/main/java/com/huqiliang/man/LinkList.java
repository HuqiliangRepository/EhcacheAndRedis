package com.huqiliang.man;

/**
 * Created by root on 4/21/16.
 */
import com.huqiliang.interfaces.Collection;
import com.huqiliang.interfaces.Iterator;

public class LinkList implements Collection {
    Node head=null;
    Node tail=null;
    int index;

    public void add(Object o){
        Node n=new Node(o,null);
        if (head == null) {
            head=n;
            tail=n;
        }
        tail.setNext(n);
        tail=n;
        index++;

    }
    public int size(){
        return index;

    }

    public Iterator iterator() {
        return null;
    }
    private class LinkListIterator implements  Iterator{
        int count=0;
        Node node=null;
        public Object next() {

            if (count == 0) {
                count++;
                node=head;
                return head.getData();
            }else {
                node.setNext(node.getNext());
                count++;
                return node.getData();

            }



        }

        public boolean hasNext() {
            if (count >= index) {
                return false;
            }else return true;

        }
    }
}
