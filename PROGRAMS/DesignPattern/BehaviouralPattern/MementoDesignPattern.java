package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.DesignPattern.BehaviouralPattern;


import java.util.Stack;

// The Memento pattern captures an object's internal state so it can be restored
// later without exposing its implementation details.

//Memento Pattern Components
//Originator	The object whose state you want to save/restore
//Memento	Stores the state (immutable)
//Caretaker	Holds the saved states (history)

// Memento class : This stores state;
class Memento{
    private String state;
    public Memento(String state){
        this.state = state;
    }
    public String getState(){
        return this.state;
    }
}

// Originator class: The class whose state need to be stores

class TestClass{
    private String state;

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return this.state;
    }

    // This function return the Memento class object which holds the state
    public Memento saveState(){
        return new Memento(this.state);
    }

    // This function set the state memento object state which is passed in argurement
    public void restoreState(Memento memento){
        this.state = memento.getState();
    }

}

//  CareTaker class: This stores all the history of memento class which can be used accordingly
class History{
    private Stack<Memento> mementos;

    public History(){
        this.mementos = new Stack<>();
    }

    public void save(TestClass testClass){
        this.mementos.push(testClass.saveState());
    }

    public void restorePreviousState(TestClass testClass){
        if(!mementos.isEmpty()){

            // retrieving previous state and then removing that state from stack to delete it's history
            // We will store the state in stack only if we change the state, the current state is never stored in stack
            testClass.restoreState(mementos.pop());
        }
    }
}

public class MementoDesignPattern {
    public static void main(String [] args){
        TestClass testClass = new TestClass();
        History history = new History();

        testClass.setState("STATE1");
        history.save(testClass);
        testClass.setState("STATE2");
        history.save(testClass);
        // STATE 3 WILL NOT GET STORED IN STACK AS WE ARE NOT CHANGING STATE ,
        // WE CAN REVERT TO PREVIOUS STATE BUT WE WILL STORE STATE IN STACK ONLY IF WE CREATE NEW STATE
        testClass.setState("STATE3");

        System.out.println("CURRENT STATE:"+testClass.getState());
        history.restorePreviousState(testClass);
        System.out.println("CURRENT STATE:"+testClass.getState());
        history.restorePreviousState(testClass);
        System.out.println("CURRENT STATE:"+testClass.getState());

        // Since we will be adding new state so we are saving current state in stack as history
        history.save(testClass);
        testClass.setState("STATE4");
        System.out.println("CURRENT STATE:"+testClass.getState());
        history.restorePreviousState(testClass);
        System.out.println("CURRENT STATE:"+testClass.getState());

    }
}
