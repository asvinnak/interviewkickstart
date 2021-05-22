package com.ash.ik.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class  MinCoinChange {

    public static int minimum_coins(List<Integer> coins, int value) {
        // Write your code here

        int[] minChange = new int[value + 1];

        minChange[0] = 0;

        for (int i = 1; i <= value; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.size(); j++) {
                if (i - coins.get(j) < 0) {
                    continue;
                }
                min = Math.min(min, minChange[i - coins.get(j)]);
            }
            minChange[i] = 1 + min;
        }

        return minChange[value];
    }

    //Bottom up Approach
    public int coinChangeBottomUp(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        Arrays.sort(coins);
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i) {
                    break;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {

        System.out.println(" Minimum coins required to change " + minimum_coins(Arrays.asList(1, 3, 5), 9));
    }


}
