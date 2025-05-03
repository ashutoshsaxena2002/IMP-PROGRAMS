package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.DesignPattern.StructuralPattern;

interface UserData{
    String getData();
}

class UserDataImpl implements UserData{

    @Override
    public String getData() {
        return "THIS IS USER DATA";
    }
}

class UserProxyLayer implements UserData{
    private UserData userData;
    UserProxyLayer(){
        this.userData=new UserDataImpl();
    }


    @Override
    public String getData() {
        System.out.println("THIS IS ACCESSED THROUGH PROXY LAYER");
        return userData.getData();
    }
}

public class ProxyDesignPattern {
    public static void main(String [] args){
        UserData userData=new UserDataImpl();
        System.out.println(userData.getData());

        UserData userData1=new UserProxyLayer();
        System.out.println(userData1.getData());

    }
}
