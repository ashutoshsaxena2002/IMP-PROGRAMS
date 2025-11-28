package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.DesignPattern.CreationalPattern;

import java.util.LinkedList;
import java.util.List;

abstract class EmployeeBuilder{
    private String name;
    private String employeeId;
    protected String departments;
    protected List<String> skills;

    public void setName(String name){
        this.name=name;
    }
    public void setEmployeeId(String employeeId){
        this.employeeId=employeeId;
    }
    public abstract void setDepartment();
    public abstract void setSkills();

    public Employee buildEmployee(){
        return new Employee(this);
    }

    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getDepartments() {
        return departments;
    }

    public List<String> getSkills() {
        return skills;
    }
}


class HrDepartmentEmployee extends EmployeeBuilder{

    @Override
    public void setDepartment() {
        this.departments="HR";
    }

    @Override
    public void setSkills() {
        List<String> skills=new LinkedList<>();
        skills.add("Communication ka chutiyapa");
        skills.add("Rangoli making");
        skills.add("employee ka chitya katana");
        this.skills=skills;
    }
}

class EngineeringDepartmentEmployee extends EmployeeBuilder{

    @Override
    public void setDepartment() {
        this.departments="Engineering";
    }

    @Override
    public void setSkills() {
        List<String> skills=new LinkedList<>();
        skills.add("JAVA");
        skills.add("Python");
        skills.add("Microservice");
        this.skills=skills;
    }
}

class Employee{
    private String name;
    private String employeeId;
    private String departments;
    private List<String> skills;

    Employee(EmployeeBuilder employeeBuilder){
        this.name=employeeBuilder.getName();
        this.employeeId=employeeBuilder.getEmployeeId();
        this.departments=employeeBuilder.getDepartments();
        this.skills=employeeBuilder.getSkills();
    }

    public String toString(){
        return this.employeeId+"_"+this.name+"_"+this.departments+"_"+this.skills.toString();
    }

}


public class BuilderPattern {

    // This pattern is used when we want to create object step by step

    public static void main(String [] args){

        EmployeeBuilder hrEmployeeBuilder=new HrDepartmentEmployee();
        EmployeeBuilder engineeringEmployeeBuilder=new EngineeringDepartmentEmployee();

        hrEmployeeBuilder.setName("ASHU");
        hrEmployeeBuilder.setEmployeeId("123");
        hrEmployeeBuilder.setSkills();
        hrEmployeeBuilder.setDepartment();

        engineeringEmployeeBuilder.setEmployeeId("567");
        engineeringEmployeeBuilder.setName("Nishant");
        engineeringEmployeeBuilder.setSkills();
        engineeringEmployeeBuilder.setDepartment();

        Employee employee1= hrEmployeeBuilder.buildEmployee();
        Employee employee2=engineeringEmployeeBuilder.buildEmployee();

        System.out.println(employee1.toString());
        System.out.println(employee2.toString());

    }
}
