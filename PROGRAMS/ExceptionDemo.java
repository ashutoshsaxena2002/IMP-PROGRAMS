package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS;

public class ExceptionDemo {

    public static Integer TestFunction(){
        try {
            System.out.println("TRY BLOCK");
            int s=34/0;
            return 1;
        }
        catch (Exception e){
            System.out.println("CATCH BLOCK");
            return 2;
        }
        finally {
            System.out.println("FINALLY BLOCK");
            return 3;
        }
    }

    public static void main(String [] args){
        System.out.println(TestFunction());
    }
}
