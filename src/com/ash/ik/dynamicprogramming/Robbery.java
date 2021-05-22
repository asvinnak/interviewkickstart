package com.ash.ik.dynamicprogramming;

/**
 * Robbery
 *
 *
 *
 * There are n houses built in a line, each of which contains some value in it. A thief is going to steal the maximal
 * value in these houses, but he cannot steal in two adjacent houses because the owner of a stolen house will tell
 * his two neighbors on the left and right side. What is the maximal stolen value?
 *
 * For example, if there are four houses with values [6, 1, 2, 7], the maximal stolen value is 13, when the first and
 * fourth houses are stolen.
 *
 *
 *
 * Example One
 *
 * Input: values = [6, 1, 2, 7]
 *
 * Output: 13
 *
 * Steal from the first and the last house.
 *
 *
 *
 * Example Two
 *
 * Input: values = [1, 2, 4, 5, 1]
 *
 * Output: 7
 *
 * Steal from the second and the fourth house.
 */
public class Robbery {

    static int maxStolenValue(int[] values) {

        if(values.length == 0){
            return 0;
        }

        if(values.length == 1) {
            return values[0];
        }

        int[] dp= new int[values.length];

        for(int i=0; i<values.length; i++) {
            dp[i] = values[i] + Math.max(i-2 < 0 ? 0 : dp[i-2], i-3 < 0 ? 0 : dp[i-3]);
        }

        return Math.max(dp[values.length-1],dp[values.length-2]);

    }


    public static void main(String[] args) {
            Robbery o = new Robbery();
            int[] arr = {1,2,4,5,1};

            System.out.println(o.maxStolenValue(arr));

    }


}
