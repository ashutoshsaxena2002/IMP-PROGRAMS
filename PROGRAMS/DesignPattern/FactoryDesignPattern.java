package com.one97.OBCCPanel.practice.paypal.Graphs.DesignPatterns;

interface DeveloperData{
    Integer getSalary();
}

class WebDeveloper implements DeveloperData{

    @Override
    public Integer getSalary() {
        return 100;
    }
}

class AndroidDeveloper implements DeveloperData{

    @Override
    public Integer getSalary() {
        return 200;
    }
}

class DeveloperFactory{
    public static DeveloperData getDeveloperType(String developerType){
        DeveloperData developerData=null;
        if(developerType.equals("WEB")){
            developerData=new WebDeveloper();
        }
        else if(developerType.equals("ANDROID")){
            developerData=new AndroidDeveloper();
        }
        return developerData;
    }
}


public class FactoryDesignPattern {
    public static void main(String [] args){
        DeveloperData developerData1=DeveloperFactory.getDeveloperType("WEB");
        DeveloperData developerData2=DeveloperFactory.getDeveloperType("ANDROID");
       // DeveloperData developerData3=DeveloperFactory.getDeveloperType("TEST");

        System.out.println(developerData1.getSalary()+"___"+developerData2.getSalary());
    }
}
