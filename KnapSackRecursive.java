package com.one97.OBCCPanel.practice.Problems.kanpsack;

/* This is knapsack recursive approach*/
public class KnapSackRecursive {


    private  static Integer knapSack(Integer val[],Integer wt[],Integer w,Integer n){
        /*Below is the base condition. For Base Condition we have to
        * think of the lowest valid input. For the given problem n=0 and w=0 could be base
        * condition as size of array could be zero(No articles left to be kept in knapsack
        * ) OR w=0 (knapsack is full sand we can not keep anything inside it) */
        if(n==0 || w==0){
            return  0;
        }

        /*Below are the two main conditions for the approach*/

        /*Below condition is the condition when weight of articles is less than
        * the capacity left in knapsack, so we can either include it or exclude it.
        * if we include it then we have to accept its value and look in rest of the array
        * and if we exclude it and look in rest of array,
        * and finally we have to return max of both (include,exclude) condition*/
        if(w>=wt[n-1]){
            return  Math.max((val[n-1]+knapSack(val,wt,w-wt[n-1],n-1)),
                    knapSack(val,wt,w,n-1));
        }
        /*Below condition is the condition when weight of articles is more than
        * the capacity left in knapsack, so we do not have to include its value and
        * look in rest of array*/
        else  if(w<wt[n-1]){
            return knapSack(val,wt,w,n-1);
        }
        return 0;
    }

    public  static  void  main(String args[]){

        Integer val[] = { 60, 100, 120 };
        Integer wt[] = { 10, 20, 30 };
        Integer w = 50;
        System.out.println("SOLUTION:"+knapSack(val,wt,w,val.length));
    }
}
