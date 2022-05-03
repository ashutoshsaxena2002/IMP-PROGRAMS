package com.one97.OBCCPanel.practice.Problems.subsetSum;

public class SubsetSumRecursive {

    private static Boolean subsetSum(Integer val[],Integer sum,Integer n){
        if(n==0 && sum==0){
            return true;
        }
        if(n==0 && sum!=0){
            return false;
        }

        if(sum>=val[n-1]){
          return subsetSum(val,sum-val[n-1],n-1) || subsetSum(val,sum,n-1);
        }
        else if(sum<val[n-1]){
            return subsetSum(val,sum,n-1);
        }
        return false;
    }

    public static void main(String args[]){
        Integer val[] = { 2,3,7,90,10 };
        Integer w = 101;
        System.out.println("SOLUTION:"+subsetSum(val,w,val.length));
    }
}
