package com.one97.OBCCPanel.practice.paypal.Graphs.PROGRAMS;




class CustomExceptionDemo extends RuntimeException{
    CustomExceptionDemo(String message){
        super(message);
    }
}



public class CustomException {


    public static Integer divide1(Integer a,Integer b) throws CustomExceptionDemo{
        //This is  Checked Exception Way as function is  throwing  exception
        // in declaration and also  throwing same exception in between the implementation
        if(b==0){
            throw new CustomExceptionDemo("DENOMINATOR IS ZERO from divide1");
        }
        return a/b;
    }

    public static Integer divide2(Integer a,Integer b) {
        //This is  UN-Checked Exception Way as function is not throwing any exception
        // in declaration but throwing exception in between the implementation
        if(b==0){
            throw new CustomExceptionDemo("DENOMINATOR IS ZERO from divide2");
        }
        return a/b;
    }



    public static void main(String [] args){
       try {
           System.out.println(divide1(4,0));
       }
       catch (CustomExceptionDemo unCheckedException){
           System.out.println(unCheckedException.getMessage());
       }

        try {
            System.out.println(divide2(4,0));
        }
        catch (CustomExceptionDemo unCheckedException){
            System.out.println(unCheckedException.getMessage());
        }
    }

}
