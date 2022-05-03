package com.one97.OBCCPanel.practice.Problems.kanpsack;

import java.util.Arrays;

/* This is knapsack recursive approach, Here we use a matrix mat[][] for storing result*/
public class KnapSackMemoize {
    private static Integer mat[][]=new Integer[1000][1000];
    private KnapSackMemoize(){
        for(Integer ar[]:mat){
            Arrays.fill(ar, -1);
        }
    }

    private static Integer knapSack(Integer val[], Integer wt[], Integer w, Integer n){
        if(n==0 || w==0){
            return 0;
        }
        if(mat[n][w]!=-1){
            return mat[n][w];
        }

        if(w>=wt[n-1]){
           mat[n][w]=Math.max(val[n-1]+(knapSack(val,wt,w-wt[n-1],n-1)),(knapSack(val,wt,w,n-1)));
        }
        else if(w<wt[n-1]){
           mat[n][w]= knapSack(val,wt,w,n-1);
        }
        return mat[n][w];
    }

    public static void main(String args[]){
        KnapSackMemoize knapSackMemoize=new KnapSackMemoize();
        Integer val[] = { 60, 100, 120 };
        Integer wt[] = { 10, 20, 30 };
        Integer w = 50;
        System.out.println("SOLUTION:"+knapSack(val,wt,w,val.length));
    }
}
