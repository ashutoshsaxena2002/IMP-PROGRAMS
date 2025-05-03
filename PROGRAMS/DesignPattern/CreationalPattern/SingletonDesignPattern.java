package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.DesignPattern;


class Singleton{

    private static volatile Singleton singleton;
    private String s;
    private Singleton (String s){
        this.s=s;
    }
    public String gets(){
        return this.s;
    }

    public static Singleton getInstance(String s){
        if(singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton=new Singleton(s);
                }
            }
        }
        return singleton;
    }
}

public class SingletonDesignPattern {
    public static void main(String [] args){
        Singleton s1=Singleton.getInstance("TEST1");
        Singleton s2=Singleton.getInstance("TEST2");

        System.out.println(s1.gets()+"___"+s2.gets());
    }
}
