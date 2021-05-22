package com.ash.ik.dynamicprogramming;

import java.io.IOException;

/**
 * There are n stairs, a person standing at the bottom wants to reach the top. He can climb a certain number of steps at
 * once. For instance, the person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person
 * can reach the top.
 * <p>
 * Solve the problem for the general case i.e. for n stairs, and different kinds of steps that can be taken (e.g.
 * instead of only 1 or 2 steps, it could be 2, 3 and 5 steps at a time).
 * <p>
 * <p>
 * <p>
 * Example One
 * <p>
 * Input: n=1, steps=[1, 2]
 * <p>
 * Output: 1
 * <p>
 * Only one way to reach: [{1}]
 * <p>
 * <p>
 * <p>
 * Example Two
 * <p>
 * Input: n=2, steps=[1, 2]
 * <p>
 * Output: 2
 * <p>
 * Two ways to reach: [{1, 1}, {2}]
 */
public class ClimbingNStairs {

    /**
     * Num of ways to climb stairs with n steps at a time for N stairs
     */
    static long countWaysToClimb(int[] steps, int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int j = 1; j <= n; j++) {
            for (int step = 0; step < steps.length; step++) {
                if (steps[step] > j) {
                    continue;
                }
                dp[j] = dp[j]    + dp[j - steps[step]];
            }
        }
        return dp[n];
    }



    /**
     * number of ways to climb stairs with 1 or 2 at a time with N stairs
     */
    static long climbStairs(int n) {
        return helper(n);
    }

    static long helper(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return helper(n - 1) + helper(n - 2);
    }

    public static int climbStairsDpArroach(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) throws IOException {
        int[] steps = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(countWaysToClimb(steps, 8));
        System.out.println(climbStairsDpArroach(8));
        System.out.println(climbStairs(8));
    }
}
