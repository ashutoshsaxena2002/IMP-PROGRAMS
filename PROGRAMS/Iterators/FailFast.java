package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.Iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FailFast {

    public static void main(String [] args){
        /* we can only remove the element in list or array with this concept by below method*/
        List<Integer> list=new ArrayList<>(Arrays.asList(1,2,3,4));


        list.add(8);
        Iterator<Integer> iterator=list.iterator();
        //list.add(7);//throws Structural modification exception

        while (iterator.hasNext()){
            Integer value=iterator.next();
            /* if we are going to add something here then it would throw the error*/
            if(value==2) {
                iterator.remove();
            }
            else {
                System.out.println(value);
            }
        }
    }

}

/*

Custom Functional Interface
Exception Handleing
Custom Exception Creation
Consumer and with for Each loop
Function
Supplier
Predicate
reduce
map
Optional
Stream
Functional interface
flatMap
FailSafe and FailFast Iterator

Static block
HAshMap Internal Working
Abstract class  vs Interface
Static Nested Class
Private vs public vs protected vs default


Comparator and Comparable and how to use to sort HashMap by key
Reflection
Final function And Class With deep and shallow copy concept
Thread callable ,Runnable , lock and synchronize
VolatileImplementation
ThreadPolling and ExecutorService
Completable Future
DesignPatterns
MicroServices
SpringBoot
Enscapsulation in java With Example: Refers to the concept of bundleing data in methods class
Abstraction In java with example: Refers to the concept of data hiding






 */
