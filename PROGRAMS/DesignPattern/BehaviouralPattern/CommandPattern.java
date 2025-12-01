package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.DesignPattern.BehaviouralPattern;


// This design pattern allows command or request to turn to object

// In simple language we create the separate classes for all the action in the Receiver

// This class is receiver which ultimately receives the command, and it has 3 actions
class Ac{
    private Integer temperature;

    // Action1
    public void turnOn(){
        System.out.println("AC IS TURNED ON");
    }

    // Action2
    public void turnOff(){
        System.out.println("AC IS TURNED OFF");
    }

    // Action3
    public void setTemperature(Integer temperature){
        this.temperature=temperature;
        System.out.println("THE TEMPERATURE IS SET TO:"+temperature);
    }
}

// Since there are 3 commands or functions in above classes so we will convert them to object by defining
// separate class for all 3 commands

interface Command{
    void execute();
}

// Object or Class for Action1
class TurnOnAC implements Command{

    private Ac ac;
    public  TurnOnAC(Ac ac) {
        this.ac=ac;
    }

    @Override
    public void execute() {
        ac.turnOn();
    }
}

// Object or Class for Action2
class TurnOfAc implements Command{

    private Ac ac;
    public  TurnOfAc(Ac ac) {
        this.ac=ac;
    }

    @Override
    public void execute() {
        ac.turnOff();
    }
}

// Object or Class for Action3
class SetTemperatureOfAc implements Command{

    private Ac ac;
    private Integer temperature;
    public  SetTemperatureOfAc(Ac ac, Integer temperature) {
        this.ac=ac;
        this.temperature=temperature;
    }

    @Override
    public void execute() {
        ac.setTemperature(this.temperature);
    }
}

// Now we have defined all Objects or classes for all commands or functions in ac class

// Now we need to define the invoker class which will invoke all commands

// Invoker class
class RemoteControl{

    public void pressButton(Command command){
        command.execute();
    }
}

public class CommandPattern {
    public  static void main(String [] args){
        Ac ac=new Ac();
        RemoteControl remoteControl=new RemoteControl();
        Command turnOnAC=new TurnOnAC(ac);
        Command turnOfAc=new TurnOfAc(ac);
        Command setTemperatureOfAc=new SetTemperatureOfAc(ac,10);

        remoteControl.pressButton(turnOnAC);
        remoteControl.pressButton(setTemperatureOfAc);
        remoteControl.pressButton(turnOfAc);
    }
}
