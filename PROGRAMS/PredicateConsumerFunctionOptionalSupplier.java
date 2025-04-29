package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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

        System.out.println(Optional.of(supplier1.get()));

    }

}
