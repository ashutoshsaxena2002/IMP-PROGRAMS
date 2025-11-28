package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.DesignPattern.BehaviouralPattern;

import java.util.LinkedList;
import java.util.List;
// In this Object known as Observer maintain a list of dependents(Observer)
// and notifies observer if any state changes in Observable

interface Observer{
    void update(int state);
    public Integer getState();
}

class ObserverA implements Observer{
    private Integer observerAState;
    @Override
    public void update(int state) {
      this.observerAState=state;
    }
    @Override
    public Integer getState(){
        return this.observerAState;
    }

}
class ObserverB implements Observer{
    private Integer observerBState;
    @Override
    public void update(int state) {
       this.observerBState=state;
    }
    @Override
    public Integer getState(){
        return this.observerBState;
    }
}

interface Observable{
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}

class ObservableImpl implements Observable{

    private final static List<Observer> observers=new LinkedList<>();
    private Integer commonState;// This is common state variable whose state change need to be notified across
    // ObserverA and ObserverB state variable

    void setCommonState(Integer commonState){
        this.commonState = commonState;
        notifyObserver();
    }

    public Integer getCommonState(){
        return this.commonState;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer:observers){
            observer.update(this.commonState);
        }
    }
}


public class ObserverDesignPattern {
    public static void main(String[] args) {

        Observer observerA=new ObserverA();
        Observer observerB=new ObserverB();
        ObservableImpl observableImpl=new ObservableImpl();

        observableImpl.addObserver(observerA);
        observableImpl.addObserver(observerB);

        System.out.println("Common State:"+observableImpl.getCommonState());
        System.out.println("Observer A:"+observerA.getState());
        System.out.println("Observer B:"+observerB.getState());

        // now set the common state we will see Observer A and Observer B will automatically update
        observableImpl.setCommonState(67);
        System.out.println("Common State:"+observableImpl.getCommonState());
        System.out.println("Observer A:"+observerA.getState());
        System.out.println("Observer B:"+observerB.getState());

        // nor remover ObserverB from Observable list and then update the list then we will see ObserverB state will not get updated
        observableImpl.removeObserver(observerB);
        observableImpl.setCommonState(90);
        System.out.println("Common State:"+observableImpl.getCommonState());
        System.out.println("Observer A:"+observerA.getState());
        System.out.println("Observer B:"+observerB.getState());
    }
}
