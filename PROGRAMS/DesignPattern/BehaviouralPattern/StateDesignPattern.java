package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.DesignPattern.BehaviouralPattern;

// It allows the object to alter it's behaviour when internal state changes

interface VendingState{
    void insertCash(VendingMachine vendingMachine);
    void dispenseCash(VendingMachine vendingMachine);
}

class VendingMachine{
    private VendingState vendingState;

    public VendingState getVendingState(){
        return this.vendingState;
    }
    public void setVendingState(VendingState vendingState){
        this.vendingState=vendingState;
    }
}

class DispenseCashClass implements VendingState{

    @Override
    public void insertCash(VendingMachine vendingMachine) {
        System.out.println("THIS IS DISPENSE CASH CLASS SO WE NEED CHANGE STATE OF VENDING MACHINE");
        vendingMachine.setVendingState(new InsertCashClass());
        vendingMachine.getVendingState().insertCash(vendingMachine);
    }

    @Override
    public void dispenseCash(VendingMachine vendingMachine) {
        System.out.println("CASH IS GETTING DISPENSED");
    }
}


class InsertCashClass implements VendingState{

    @Override
    public void insertCash(VendingMachine vendingMachine) {
        System.out.println("CASH IS GETTING INSERTED");
    }

    @Override
    public void dispenseCash(VendingMachine vendingMachine) {
        System.out.println("THIS IS INSERT CASH CLASS SO WE NEED CHANGE STATE OF VENDING MACHINE");
        vendingMachine.setVendingState(new DispenseCashClass());
        vendingMachine.getVendingState().dispenseCash(vendingMachine);
    }
}


public class StateDesignPattern {
    public static void main(String [] args){
        VendingMachine vendingMachine=new VendingMachine();
        VendingState vendingState1=new DispenseCashClass();
        vendingState1.dispenseCash(vendingMachine);
        vendingState1.insertCash(vendingMachine);
        System.out.println("________________________________");
        VendingState vendingState2=new InsertCashClass();
        vendingState2.dispenseCash(vendingMachine);
        vendingState2.insertCash(vendingMachine);
    }
}
