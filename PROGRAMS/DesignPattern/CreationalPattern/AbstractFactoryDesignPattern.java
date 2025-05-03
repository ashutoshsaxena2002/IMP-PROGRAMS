package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.DesignPattern.CreationalPattern;

interface CoderData{
    Integer getSalary();
}

class JavaDeveloper implements CoderData{

    @Override
    public Integer getSalary() {
        return 400;
    }
}

class PythonDeveloper implements CoderData{
    @Override
    public Integer getSalary() {
        return 700;
    }
}

abstract class AbstractCoderFactory{
    abstract CoderData getCoderType();
}

class JavaCoderFactory extends AbstractCoderFactory{

    @Override
    CoderData getCoderType() {
        return new JavaDeveloper();
    }
}


class PythonCoderFactory extends AbstractCoderFactory{
    @Override
    CoderData getCoderType() {
        return new PythonDeveloper();
    }
}

class CoderFactory{
    public static CoderData getCoderType(AbstractCoderFactory abstractCoderFactory){
        return abstractCoderFactory.getCoderType();
    }
}



public class AbstractFactoryDesignPattern {
    public static void main(String [] args){
      CoderData coderData1=CoderFactory.getCoderType(new JavaCoderFactory());
      CoderData coderData2=CoderFactory.getCoderType(new PythonCoderFactory());
      System.out.println(coderData1.getSalary()+"___"+coderData2.getSalary());
    }
}
