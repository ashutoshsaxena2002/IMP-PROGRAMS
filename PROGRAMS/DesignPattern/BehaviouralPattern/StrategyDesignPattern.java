package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.DesignPattern.BehaviouralPattern;


// It helps user to define multiple algorithm for a statergy or task and use it depending on the situation

interface PayStrategy{
    void pay();
}

class Upi implements PayStrategy{

    @Override
    public void pay() {
        System.out.println("PAYING THROUGH  UPI");
    }
}

class CreditCard implements PayStrategy{

    @Override
    public void pay() {
        System.out.println("PAYING THROUGH CREDIT CARD");
    }
}


class Cash implements PayStrategy{

    @Override
    public void pay() {
        System.out.println("PAYING THROUGH CASH");
    }
}

class Order{
    private PayStrategy payStrategy;
    Order(PayStrategy payStrategy){
        this.payStrategy=payStrategy;
    }

    public void makePayment(){
        payStrategy.pay();
    }
}
public class StrategyDesignPattern {
    public static void main(String [] args){
        Order order=new Order(new CreditCard());

        order.makePayment();
    }
}
