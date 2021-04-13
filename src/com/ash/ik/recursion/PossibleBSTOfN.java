package com.ash.ik.recursion;

import javax.annotation.PostConstruct;

public class PossibleBSTOfN {


    static long how_many_BSTs(int n) {

        return helper(n);

    }

    //Recursive
    static int helper(int n) {
        //base condition
        if(n == 0 || n==1 ) {
            return 1;
        }
        int bstCnt=0;
        int right= 0;
        for(int left=0; left<n; left++) {
            right = n-1 - left;
            bstCnt += helper(left) * helper(right);
        }
        return bstCnt;
    }

    //Iterative
    private static int driver(int n) {

        if(n==0 || n==1) {
            return 1;

         }
        int[] arr= new int[n+1];

        arr[0] = 1;
        arr[1] = 1;


        int tot= 0;
        for(int i=2; i<=n; i++) {
            arr[i] = 0;
            for(int j=0; j<i; j++) {
                arr[i] = arr[i] + arr[j] * arr[i-j-1];
            }

        }

        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(how_many_BSTs(3));
    }

}
