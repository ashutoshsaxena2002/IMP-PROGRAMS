package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.Iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*Why no ConcurrentModificationException?
You are not using an iterator here!
The exception ConcurrentModificationException is thrown only when you modify a collection directly
while using an explicit iterator (or enhanced for-loop internally using an iterator).

You are using a classic for-loop with an index (i), so the ArrayList’s
internal modCount (which the iterator checks to detect concurrent modification) is not checked in your code.

 */
public class NormalIteration {
    public static void main(String [] args){
        List<Integer> list=new ArrayList<>(Arrays.asList(1,2,3));

        for(int i=0;i<list.size();i++){
            if(list.get(i)==2){
                list.remove(list.get(i));
            }
                System.out.println(list.get(i));

        }
    }
}

