package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface CallingTime{
    int times() default 2;
}
class Student{
    private Integer id;
    private String name;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    @CallingTime(times = 3)
    private void privateFunction(String s){
        System.out.println("THIS IS PRIVATE FUNCTION ACCESS THROUGH REFLECTION:"+s);
    }
}

public class ReflectionImplementation {
    public static void main(String [] args) throws IllegalAccessException, InvocationTargetException {

        Student student=new Student(1,"ASHUTOSH");
        System.out.println(student.getId());
        Field [] fields=student.getClass().getDeclaredFields();
        for(Field field:fields){
            if(field.getName().equals("id")){
                field.setAccessible(true);
                field.set(student,2);
            }
        }
        System.out.println(student.getId());

        Method [] methods=student.getClass().getDeclaredMethods();
        for(Method method:methods){
            if(method.getName().equals("privateFunction") && method.isAnnotationPresent(CallingTime.class)){
               CallingTime callingTime=method.getAnnotation(CallingTime.class);
               for(int i=0;i< callingTime.times();i++) {
                   method.setAccessible(true);
                   method.invoke(student, "ASHUTOSH");
               }
            }
        }


    }
}
