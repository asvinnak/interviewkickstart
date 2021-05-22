package com.ash.ik.dynamicprogramming;

public class CutIronRodForMaxProfit {

    /**
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     */
    public static int getMaxProfit(int cuts, int[] prices) {

        int[] dp = new int[cuts + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= cuts; i++) {
            for (int cut = 0; cut < i; cut++) {
                dp[i] = Math.max(dp[i], prices[cut] + dp[i - cut - 1]);
            }
        }

        return dp[cuts];
    }

    //Recursive
    static int getMaxProfit(int n, int[] prices, int[] memoize) {

        if (n == 0) {
            return 0;
        }

        if (memoize[n] != -1) {
            return memoize[n];
        }

        int result = -1;

        for (int cut = 0; cut < n; cut++) {

            result = Math.max(result, prices[cut] + getMaxProfit(n - cut - 1, prices, memoize));
        }

        memoize[n] = result;

        return result;
    }

    public static void main(String[] args) {

        int prices[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
        int cuts = prices.length;
        System.out.println("org:" + getMaxProfit(cuts, prices));
        int[] memo = new int[cuts + 1];
        System.out.println("memoize:" + getMaxProfit(cuts, prices, memo));
    }
}
