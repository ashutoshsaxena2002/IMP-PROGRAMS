package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.DesignPattern.BehaviouralPattern;

// When we want Object to follow specific steps for particular tasks in all  classed but the internal implementations of those steps
// might differ in respective classes.
abstract class PaymentFlow{
    public abstract void validateRequest();
    public abstract void calculateFees();
    public abstract void payAmount();

    // The above function are declared as abstract as their implementation might differ in different sub-classes but below
    // function "sendMoney()"  is declared as final so that it can not be over-ridden
    // to indicate that the sendMoney functionality will follow all  these 3 abstract function steps which internally might differ
    // but all the 3 functions are executed positively

    public final void sendMoney(){
        this.validateRequest();
        this.calculateFees();
        this.payAmount();
    }
}
class PayToFriend extends PaymentFlow{

    @Override
    public void validateRequest() {
        System.out.println("VALIDATING REQUEST WHILE PAYING TO FRIEND");
    }

    @Override
    public void calculateFees() {
        System.out.println("CALCULATING FEES WHILE PAYING TO FRIEND");
    }

    @Override
    public void payAmount() {
        System.out.println("PAYING AMOUNT TO FRIEND");
    }
}
class PayToMerchant extends PaymentFlow{

    @Override
    public void validateRequest() {
        System.out.println("VALIDATING REQUEST WHILE PAYING TO MERCHANT");
    }

    @Override
    public void calculateFees() {
        System.out.println("CALCULATING FEES WHILE PAYING TO MERCHANT");
    }

    @Override
    public void payAmount() {
        System.out.println("PAYING AMOUNT TO MERCHANT");
    }
}


public class TemplateDeignPattern {

    public static void main(String [] args){
        PaymentFlow paymentFlowToFriend=new PayToFriend();
        PaymentFlow paymentFlowToMerchant=new PayToMerchant();

        paymentFlowToFriend.sendMoney();
        System.out.println("_____________________________________________");
        paymentFlowToMerchant.sendMoney();
    }

}
