package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.DesignPattern.StructuralPattern;

// The Flyweight pattern is used to reduce memory
// usage by sharing objects instead of creating new ones every time.
//Flyweight ← ConcreteFlyweight
//       ↑
//FlyweightFactory
//       ↑
//Client

//eg:
// Java Example: Tree Rendering in a Game
//
//Games often have thousands of trees.
//Only color & texture are shared.
//Position is unique.

import java.util.HashMap;
import java.util.Map;

class TreeType{
    private String name;
    private String colour;
    private String texture;

    TreeType(String name,String colour,String texture){
        this.name=name;
        this.colour=colour;
        this.texture=texture;
    }

    void draw(Integer x,Integer y){
        System.out.println(this.name+"_"+this.colour+"_"+this.texture+"_ AT CO-ORDINATES: "+x+":"+y);
    }
}

class TreeFactory{
    private static Map<String,TreeType> treeTypes=new HashMap<>();

    public static TreeType getTreeTypes(String name,String colour,String texture){
        String key=name+"_"+colour+"_"+texture;
        if(!treeTypes.containsKey(key)){
            treeTypes.put(key,new TreeType(name,colour,texture));
        }
        return treeTypes.get(key);
    }
}

class Tree{
    private Integer x;
    private Integer y;
    private TreeType treeType;

    Tree(Integer x,Integer y,TreeType treeType){
        this.x=x;
        this.y=y;
        this.treeType=treeType;
    }

    void draw(){
        this.treeType.draw(this.x,this.y);
    }
}

public class FlyWeightDesignPattern {
    public static void main(String [] args){
        TreeType treeType1=TreeFactory.getTreeTypes("OAK","YELLOW","ROUGH");
        TreeType treeType2=TreeFactory.getTreeTypes("PALM","RED","SMOOTH");
        TreeType treeType3=TreeFactory.getTreeTypes("BANYAN","GREEN","SIMPLE");
        Tree tree1=new Tree(3,4,treeType1);
        Tree tree2=new Tree(6,23,treeType2);
        Tree tree3=new Tree(8,56,treeType3);
        Tree tree4=new Tree(9,78,treeType1);


        tree1.draw();
        tree2.draw();
        tree3.draw();
        tree4.draw();

    }
}
//
//Notice:
//Only 2 objects of TreeType are created.
//But 3 trees are drawn.
//Memory savings achieved.
