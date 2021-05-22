package com.ash.ik.arrays;

public class FibonacciSeries {

    static int fabonacci(int n) {
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i % 3] = dp[(i - 1) % 3] + dp[(i - 2) % 3];
        }
        return dp[n % 3];
    }

    static int fabonacci1(int n) {
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i ] = dp[i - 1] + dp[i - 2];
        }
        return dp[n-1];
    }

    static int[] cache= new int[31];
    public static int fib(int N) {

        if(cache[N] > 0) {
            return cache[N];
        }
        if(N < 2) {
            return N;
        }
        cache[N] = fib(N-1) + fib(N-2);
        return cache[N];

    }

    public static void main(String[] args) {
        System.out.println( fabonacci1(5));
           System.out.println( fabonacci(5));
        System.out.println( fib(5));
    }
}
