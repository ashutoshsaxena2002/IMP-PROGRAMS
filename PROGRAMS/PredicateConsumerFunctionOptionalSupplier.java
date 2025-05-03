package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredicateConsumerFunctionOptionalSupplier {

    public static void main(String [] args){
        Function<String,String> f1=(s)->s.concat("TOSH");
        Function<String,Integer> f2=(s)->s.length();
        System.out.println(f1.apply("ASHU"));
        System.out.println(f1.andThen(f2).apply("ASHU"));

        Predicate<Integer> predicate=(e)->e%2==0;
        Integer [] list={1,2,3,4,5,6,7,8,9,10};
        Supplier<List<Integer>> supplier1=()-> Arrays.asList(list).stream().filter(predicate).toList();
        Supplier<Integer> supplier2=()-> Arrays.asList(list).stream().filter(predicate).reduce(0,(a,b)->a+b);
        System.out.println(supplier1.get()+"____"+supplier2.get());

        System.out.println(Optional.of(supplier1.get()));// gives null pointer exception when list is pass as null
        System.out.println(Optional.ofNullable(supplier1.get()));// does not give null pointer exception but gives empty optional when list is pass as null
        System.out.println(Optional.of(supplier1.get()).isEmpty());
        System.out.println(Optional.of(supplier1.get()).isPresent());
        System.out.println(Optional.ofNullable(supplier1.get()).get().stream().filter(predicate).reduce(0,(a,b)->a+b));
        System.out.println(Optional.ofNullable(null).orElseGet(supplier2));
        System.out.println(Optional.ofNullable(null).orElse(Arrays.stream(list).toList()));

        Comparator<Integer> comparator=(k1,k2)->k2.compareTo(k1);

        Map<Integer,String> hashMap=new TreeMap<>(comparator);
        hashMap.put(1,"ASHU");
        hashMap.put(10,"ABHI");
        hashMap.put(5,"ANISH");
        hashMap.put(13,"CHIT");


        for(Integer i:hashMap.keySet()){
            System.out.println(hashMap.get(i));
        }


    }

}
