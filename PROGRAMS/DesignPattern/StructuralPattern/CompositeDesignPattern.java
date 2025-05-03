package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.DesignPattern.StructuralPattern;


import java.util.LinkedList;
import java.util.List;

interface FileSystem{
    void getData();
}

class FileSystemImpl implements FileSystem{

    @Override
    public void getData() {
        System.out.println("THIS IS DATA");
    }
}

class DirectoryImpl implements FileSystem{

    private static List<FileSystem> fileSystems=new LinkedList<>();

    DirectoryImpl(FileSystem fileSystem){
        fileSystems.add(fileSystem);
    }

    @Override
    public void getData() {
        for(FileSystem fileSystem:fileSystems){
            fileSystem.getData();
        }
    }

}

public class CompositeDesignPattern {
    public static void main(String [] args){
        FileSystem fileSystem1=new FileSystemImpl();
        FileSystem fileSystem2=new FileSystemImpl();
        FileSystem fileSystem3=new FileSystemImpl();
        fileSystem3.getData();
        fileSystem2.getData();
        fileSystem1.getData();
        FileSystem fileSystem11=new DirectoryImpl(fileSystem1);
        FileSystem fileSystem22=new DirectoryImpl(fileSystem2);
        FileSystem fileSystem33=new DirectoryImpl(fileSystem3);
        fileSystem11.getData();

    }
}
