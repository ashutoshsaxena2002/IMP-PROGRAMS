package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS;


@FunctionalInterface
interface Calculator{

    Integer operate(Integer a,Integer b) ;

    default Integer multiply(Integer a,Integer b){
        return a*b;
    }

}
public class CustomFunctionalInterface{

    public static void main(String [] args){
        Calculator add=(a,b)-> a+b;
        Calculator divide=(a,b)->{
            if(b==0){
                throw new CustomExceptionDemo("DENOMINATOR IS ZERO");
            }
            return a/b;
        };

        try {
            System.out.println(add.operate(4,5));
            System.out.println(divide.operate(4,5));
            System.out.println(add.multiply(9,6));
            System.out.println(divide.operate(4,0));

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

}
