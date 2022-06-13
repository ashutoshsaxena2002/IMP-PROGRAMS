package com.one97.OBCCPanel.practice.paypal.Graphs;

public class AnonymousFunction {

    public  void show(){
        System.out.println("hi , this is normal function");
    }

    public static void main(String args[]){

        AnonymousFunction anonymousFunction=new AnonymousFunction(){
          @Override
          public void show(){
              System.out.println("this is anonymous function");
          }
        };
      anonymousFunction.show();

    }

}
