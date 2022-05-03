package com.one97.OBCCPanel.practice.Problems.subsetSum;

import java.util.Arrays;

public class SubsetSumMemoize {

    private static Boolean mat[][]=new Boolean[1000][1000];
    private SubsetSumMemoize(){
        for(Boolean ar[]:mat){
            Arrays.fill(ar,null);
        }
    }

    private static Boolean subsetSum(Integer n,Integer sum,Integer val[]){
        if(n==0 && sum==0){
            return true;
        }
        if(n==0 && sum!=0){
            return false;
        }
        if(mat[n][sum]!=null){
            return mat[n][sum];
        }

        if(sum>=val[n-1]){
            mat[n][sum]=subsetSum(n-1,sum-val[n-1],val) || subsetSum(n-1,sum,val);
        }
        else if(sum<val[n-1]){
            mat[n][sum]=subsetSum(n-1,sum,val);
        }
        return mat[n][sum];
    }

    public static void  main(String args[]){
        SubsetSumMemoize subsetSumMemoize=new SubsetSumMemoize();
        Integer val[] = { 2 ,5 ,1 ,6, 7};
        Integer w = 4;
        System.out.println("SOLUTION:"+subsetSum(val.length,w,val));
    }
}
