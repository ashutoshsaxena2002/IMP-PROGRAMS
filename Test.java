package com.one97.OBCCPanel.practice.paypal.Graphs;


import java.util.Arrays;
import java.util.function.Function;

public class
Test {


    public static  Integer [][] getParcelsTriangle (int numRows){

        Integer [][] triangle=new Integer[numRows][];
        triangle[0]=new Integer[]{1};

        for(int i=1;i<numRows;i++){
            int length=i+1;
            Integer [] embeddedTriangle=new Integer[length];

            for(int j=0;j<length/2;j++){
                if(j==0){
                    embeddedTriangle[j]=triangle[i-1][0];
                }
                else{
                    embeddedTriangle[j]=triangle[i - 1][j]+triangle[i-1][j-1];
                }
            }

            for (int j=length/2;j<length;j++){
                if(j==length-1){
                    embeddedTriangle[j]=triangle[i-1][triangle[i-1].length-1];
                }
                else{
                    embeddedTriangle[j]=triangle[i - 1][j]+triangle[i-1][j-1];
                }
            }
            triangle[i]=embeddedTriangle;
        }
        return triangle;

    }



    public static void main(String[] args) {

        Integer [][] triangle=getParcelsTriangle(7);

        for(int i=0;i<triangle.length;i++){
            System.out.println(Arrays.toString(triangle[i]));
        }

    }
}
