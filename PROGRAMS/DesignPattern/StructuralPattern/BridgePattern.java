package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.DesignPattern.StructuralPattern;


//Abstraction (Remote) --------------------> Implementor (Device)
//             ↑                                            ↑
//RefinedAbstraction                          ConcreteImplementor

//The Bridge design pattern is a structural
//design pattern that decouples an abstraction
//from its implementation, allowing the two to vary independently.

interface Device{
    void turnOn();
    void turnOff();
    void setVolume(int Volume);
}

class Tv implements Device{

    @Override
    public void turnOn() {
        System.out.println("TV turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("TV turned of");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("TV volume is set to "+ volume);
    }
}

class Radio implements  Device{

    @Override
    public void turnOn() {
        System.out.println("Radio turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Radio turned off");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("TV volume is set to "+ volume);
    }
}


abstract class Remote{
    abstract void turnOn();
    abstract void turnOff();
    abstract void setVolume(int Volume);
}

class BasicRemote extends Remote{

    private Device device;

    BasicRemote(Device device){
        this.device=device;
    }

    @Override
    void turnOn() {
        System.out.println("BASIC REMOTE FEATURES WHILE STARTING");
        device.turnOn();
    }

    @Override
    void turnOff() {
        System.out.println("BASIC REMOTE FEATURES WHILE CLOSING");
        device.turnOff();
    }

    @Override
    void setVolume(int volume) {
        System.out.println("BASIC REMOTE FEATURES WHILE VOLUME CHANGE");
        device.setVolume(volume);
    }
}

class AdvancedRemote extends Remote{

    private Device device;

    AdvancedRemote(Device device){
        this.device=device;
    }

    @Override
    void turnOn() {
        System.out.println("ADVANCED REMOTE FEATURES WHILE STARTING");
        device.turnOn();
    }

    @Override
    void turnOff() {
        System.out.println("ADVANCED REMOTE FEATURES WHILE CLOSING");
        device.turnOff();
    }

    @Override
    void setVolume(int volume) {
        System.out.println("ADVANCED REMOTE FEATURES WHILE VOLUME CHANGE");
        device.setVolume(volume);
    }
}


// Here if we want to add new functionality in remote we can add it in abstract remote class  and then implement it
// and also if we want to add any new type of remote to be used in any other device then we can add it's corresponding functionality
// in abstract remote class and implement it's functionality

public class BridgePattern {
    public static  void main(String [] args){
        Remote basicRemoteTV=new BasicRemote(new Tv());
        basicRemoteTV.turnOn();
        basicRemoteTV.setVolume(5);
        basicRemoteTV.turnOff();

        System.out.println("____________________________________");

        Remote basicRemoteRadio=new BasicRemote(new Radio());
        basicRemoteRadio.turnOn();
        basicRemoteRadio.setVolume(78);
        basicRemoteRadio.turnOff();

        System.out.println("____________________________________");

        Remote advancedRemoteTv=new AdvancedRemote(new Tv());
        advancedRemoteTv.turnOn();
        advancedRemoteTv.setVolume(89);
        advancedRemoteTv.turnOff();

        System.out.println("____________________________________");

        Remote advancedRemoteRadio=new AdvancedRemote(new Radio());
        advancedRemoteRadio.turnOn();
        advancedRemoteRadio.setVolume(9);
        advancedRemoteRadio.turnOff();

    }
}
