package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.DesignPattern.StructuralPattern;

//The Adapter design pattern is a structural design pattern that
//allows incompatible classes to work together
//by converting one class's interface into another interface that clients expect

// This is interface which has method which gives weight only in kgs. This is Adptee
interface WeighingMachine{
    Integer getWeightInKgs();
}

class WeighingMachineImpl implements WeighingMachine{

    @Override
    public Integer getWeightInKgs() {
        return 55;
    }
}

// Now there comes the requirement where we want weight in pounds

interface WeighingMachineAdapter {
    Integer getWeightsInPounds();
}
// This act as bridge
class WeighingMachineAdapterImpl implements WeighingMachineAdapter{

    private WeighingMachine weighingMachine;

    public WeighingMachineAdapterImpl(WeighingMachine weighingMachine){
        this.weighingMachine=weighingMachine;
    }

    @Override
    public Integer getWeightsInPounds() {
        return weighingMachine.getWeightInKgs()*2;
    }
}

public class AdapterDesignPattern {

    // This FDesign pattern act as a bridge between 2 incompatible interfaces


    public static void main(String [] args){
         WeighingMachine weighingMachine=new WeighingMachineImpl();
         WeighingMachineAdapter weighingMachineAdapter=new WeighingMachineAdapterImpl(weighingMachine);
         System.out.println(weighingMachine.getWeightInKgs());
         System.out.println(weighingMachineAdapter.getWeightsInPounds());
    }

}
