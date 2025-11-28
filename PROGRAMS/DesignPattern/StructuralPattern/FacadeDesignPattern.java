package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.DesignPattern.StructuralPattern;

//
//Client → Facade → SubsystemA
//                  SubsystemB
//                  SubsystemC
//Think about ordering food on Zomato/Swiggy:
//You add items to cart
//You pay
//Delivery is arranged
//Restaurant receives order
//Tracking starts
//But YOU see only one interface, the app.
//Internally there are dozens of systems—payment, restaurants, delivery, tracking.
//The app acts as a Facade.


class DvdPlayer {

    void on(){
        System.out.println("DVD PLAYER IS ON");
    }

    void play(){
        System.out.println("DVD PLAYER IS PLAYING");
    }

    void stop(){
        System.out.println("DVD PLAYER IS OFF");
    }
}

class Projector {
    void on(){
        System.out.println("PROJECTOR IS ON");
    }

    void project(){
        System.out.println("PROJECTOR IS PROJECTING");
    }

    void stop(){
        System.out.println("PROJECTOR IS OFF");
    }
}

class SoundSystem {
    void on(){
        System.out.println("SOUND SYSTEM PLAYER IS ON");
    }

    void setVolume(Integer volume){
        System.out.println("SOUND SYSTEM VOLUME IS SET TO:"+volume);
    }

    void stop(){
        System.out.println("SOUND SYSTEM IS OFF");
    }
}

class Movie{
    private DvdPlayer dvdPlayer;
    private Projector projector;
    private SoundSystem soundSystem;

    Movie(DvdPlayer dvdPlayer,Projector projector,SoundSystem soundSystem){
        this.dvdPlayer=dvdPlayer;
        this.projector=projector;
        this.soundSystem=soundSystem;
    }

    void startMovie(){
        dvdPlayer.on();
        dvdPlayer.play();
        projector.on();
        projector.project();
        soundSystem.on();
        soundSystem.setVolume(45);
    }


    void stopMovie(){
        dvdPlayer.stop();
        projector.stop();
        soundSystem.stop();
    }
}

public class FacadeDesignPattern {
    public static void main(String [] args){
        Movie movie=new Movie(new DvdPlayer(),new Projector(),new SoundSystem());
        movie.startMovie();
        movie.stopMovie();
    }
}
