package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.DesignPattern.BehaviouralPattern;

import java.util.LinkedList;
import java.util.List;

//The Mediator pattern defines an object that handles communication between multiple objects (colleagues), preventing them from communicating directly.
//
//        🧠 Why use it?
//
//Reduces tight coupling between classes
//
//Centralizes communication logic
//
//Easier to modify and maintain
//
//📘 Real-Life Example
//
//Chat Room
//
//Users send messages to each other
//
//Instead of each user sending messages directly, the ChatRoom (Mediator) handles message delivery
//
//This avoids complicated inter-user dependency.
interface ChatMediator{
    void sendMessage(User user,String message);
    void addUser(User user);
}

abstract class User{
    protected ChatMediator chatMediator;
    protected String name;

    public User(ChatMediator chatMediator,String name){
        this.chatMediator = chatMediator;
        this.name = name;
    }

    abstract  void sendMessage(String message);
    abstract void receiveMessage(String message);
}

class ChatMediatorImpl implements ChatMediator{

    private List<User> users;

    public  ChatMediatorImpl(){
        this.users = new LinkedList<>();
    }

    @Override
    public void sendMessage(User user, String message) {
        for(User u:users){
            if(!u.equals(user)){
                u.receiveMessage(message);
            }
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}

class UserImpl extends  User{

    public UserImpl(ChatMediator chatMediator, String name) {
        super(chatMediator, name);
    }

    @Override
    void sendMessage(String message) {
        chatMediator.sendMessage(this,message);
    }

    @Override
    void receiveMessage(String message) {
        System.out.println(this.name+":MESSAGE RECEIVED:"+message);
    }
}

public class MediatorDesignPattern {
    public static void main(String[] args) {
        ChatMediator chatMediator=new ChatMediatorImpl();
        User user1 = new UserImpl(chatMediator, "Alice");
        User user2 = new UserImpl(chatMediator, "Bob");
        User user3 = new UserImpl(chatMediator, "Charlie");
        User user4 = new UserImpl(chatMediator, "Diana");
        chatMediator.addUser(user1);
        chatMediator.addUser(user2);
        chatMediator.addUser(user3);
        chatMediator.addUser(user4);

        user1.sendMessage("Hello");
        System.out.println("_________________");
        user2.sendMessage("Bonjour");

    }
}
