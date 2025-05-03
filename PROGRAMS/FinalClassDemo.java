package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS;


import java.util.HashMap;

final class FinalClass{
    private final NormalClass normalClass;
    private final HashMap<String,String> hashMap;
    private final String name;

    FinalClass(NormalClass normalClass,HashMap<String,String> hashMap,String name){
        this.normalClass=new NormalClass(normalClass.getS());// THIS IS DEEP COPY
        this.hashMap=new HashMap<>(hashMap);// THIS IS DEEP COPY
        //this.hashMap=hashMap;//THIS IS SHALLOW COPY
        //this.normalClass=normalClass;//THIS IS SHALLOW COPY
        this.name=name;
    }

    public NormalClass getNormalClass() {
        return normalClass;
    }

    public HashMap<String, String> getHashMap() {
        return hashMap;
    }

    public String getName() {
        return name;
    }
}

class NormalClass{
    private String s;
    NormalClass(String s){
        this.s=s;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
public class FinalClassDemo {
    public static void main(String [] args){

        NormalClass normalClass=new NormalClass("TEST1");
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("1","RAHUL");
        FinalClass finalClass=new FinalClass(normalClass,hashMap,"ASHUTOSH");

        System.out.println(finalClass.getNormalClass().getS()+"___"+finalClass.getName()+"____"+finalClass.getHashMap());
        normalClass.setS("TEST2");
        hashMap.put("2","VIVEK");
        System.out.println(finalClass.getNormalClass().getS()+"___"+finalClass.getName()+"____"+finalClass.getHashMap());



    }
}
