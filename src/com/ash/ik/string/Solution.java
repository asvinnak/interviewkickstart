package com.ash.ik.string;

import java.util.Arrays;

public class Solution {


    public int repeatedNTimes(int[] A) {

        Arrays.sort(A);
        int maxVal = Integer.MIN_VALUE;
        int prev = Integer.MIN_VALUE;
        int cnt=1;
        int maxNum= 0;
        for(int i=0; i<A.length; i++) {
            if(A[i] == prev) {
                cnt++;
                prev = A[i];
                continue;
            }
            if(cnt  > maxVal) {
                maxNum = prev;
                maxVal = cnt;
            }
            cnt=1;
            prev = A[i];

        }

        if(cnt  > maxVal) {
            maxNum = prev;
        }

        return maxNum;

    }

    public static void main(String[] args) {
        int[] a= {9,5,3,3};

        Solution o = new Solution();
       System.out.println(o.repeatedNTimes(a));
    }
}
