package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.Iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafe {
    public static void main (String [] args){
        List<Integer> list=new CopyOnWriteArrayList<>(Arrays.asList(1,2,3,4));// we can use CopyOnWriteArrayList
        // class to modify array while iterating

        Iterator<Integer> iterator= list.iterator();

        while (iterator.hasNext()){
            Integer value=iterator.next();
            if(value==2) {
                list.add(5);// We can add here but iterator will not see this value in this loop,
                // when we will iterate the list in other loop then we will see  the value
            }
            System.out.println(value);
        }

        System.out.println("_______________________");

        iterator=list.iterator();
        while (iterator.hasNext()){
            Integer value=iterator.next();
            System.out.println(value);
        }
    }
}
