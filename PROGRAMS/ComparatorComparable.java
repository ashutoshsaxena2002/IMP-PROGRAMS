package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS;


import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Worker implements Comparable<Worker>{
    private Integer id;
    private String name;

    public Worker(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Worker worker) {
        return this.getId().compareTo(worker.getId());
    }
}

class SortByName implements Comparator<Worker>{

    @Override
    public int compare(Worker o1, Worker o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

public class ComparatorComparable {

    public static void main(String [] args){
        Worker worker1=new Worker(19,"BHARAT");
        Worker worker2=new Worker(1,"ZAKIR");
        Worker worker3=new Worker(34,"ASHU");

        List<Worker> workers=new LinkedList<>();
        workers.add(worker1);
        workers.add(worker2);
        workers.add(worker3);

        Collections.sort(workers);

        for(Worker worker:workers){
            System.out.println(worker.getId()+"___"+ worker.getName());
        }

        System.out.println("_____________________________________________");
        Collections.sort(workers,new SortByName());

        for(Worker worker:workers){
            System.out.println(worker.getId()+"___"+ worker.getName());
        }

    }

}
