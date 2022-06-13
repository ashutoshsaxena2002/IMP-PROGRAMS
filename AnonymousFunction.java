package com.one97.OBCCPanel.practice.paypal.Graphs;

class c1{
    public  void show(){
        System.out.println("hi , this is normal function");
    }
}

public class AnonymousFunction{



    public static void main(String args[]){

        c1 c1=new c1(){
          @Override
          public void show(){
              System.out.println("this is anonymous function");
          }
        };
      c1.show();

    }

}
