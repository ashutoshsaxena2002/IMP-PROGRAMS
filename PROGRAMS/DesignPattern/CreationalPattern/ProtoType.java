package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS.DesignPattern.CreationalPattern;


// It is used when we have a heavy or expensive object and we have make some changes in that object and then use it
// so we make the clone of the object and then use it.

interface CloneObject {
     CloneObject clone();
}

class Teacher implements CloneObject{

    private Integer teacherId;
    private String name;
    private String email;


    Teacher(Integer teacherId, String name, String email) {
        this.teacherId = teacherId;
        this.name = name;
        this.email = email;
    }

    public void setId(Integer teacherId){
        this.teacherId=teacherId;
    }


    @Override
    public CloneObject clone() {
        return new Teacher(this.teacherId, this.name,this.email);
    }

    public String toString(){
        return this.teacherId+"_"+this.name+"_"+this.email;
    }
}

class Student implements CloneObject{

    private Integer rollNo;
    private String name;
    private String email;

    Student(Integer rollNo, String name, String email) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
    }

    public void setId(Integer rollNo){
        this.rollNo=rollNo;
    }

    public String toString(){
        return this.rollNo+"_"+this.name+"_"+this.email;
    }

    @Override
    public CloneObject clone() {
        return new Student(this.rollNo, this.name,this.email);
    }
}
public class ProtoType {

    public static void main(String[] args) {
        Teacher teacher=new Teacher(678,"NISHANT","nishant@gmail.com");
        Student student=new Student(456,"ASHU","ashu@gmail.com");


        Teacher clonedTeacher=(Teacher) teacher.clone();
        Student clonedStudent=(Student) student.clone();

        clonedStudent.setId(901);
        clonedTeacher.setId(900);
        System.out.println(student.toString());
        System.out.println(teacher.toString());
        System.out.println(clonedStudent.toString());
        System.out.println(clonedTeacher.toString());


    }

}
