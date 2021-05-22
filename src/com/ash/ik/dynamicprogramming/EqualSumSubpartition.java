package com.ash.ik.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array s of n integers, partition it into two non-empty subsets, s1 and s2, such that the sum of all elements
 * in s1 is equal to the sum of all elements in s2. Return a boolean array of size n where i-th element is True if i-th
 * element of s belongs to s1 and False if it belongs to s2. Any valid answer will be accepted. If such partitioning is
 * not possible, return an empty array.
 * <p>
 * <p>
 * <p>
 * Example5
 * <p>
 * Input: n = 6, s = [10, -3, 7, 2, 1, 3]
 * <p>
 * Output: [True, True, False, False, False, True]
 * <p>
 * <p>
 * <p>
 * There are multiple partitionings where s1 sums up to 10 and s2 sums up to 10; they are all correct answers:
 * <p>
 * s1 = [ 10 , -3 , 3 ] and s2 = [ 7 , 2 , 1 ] (Sample output) s1 = [ 7 , 2 , 1 ] and s2 = [ 10 , -3 , 3 ] s1 = [10] and
 * s2 = [-3, 3, 7, 2, 1] s1 = [-3, 3, 7, 2, 1] and s2 = [10] s1 = [10, -3, 2, 1] and s2 = [7, 3] s1 = [7, 3] and s2 =
 * [10, -3, 2, 1]
 */
public class EqualSumSubpartition {

    public static List<Boolean> equalSubSetSumPartitionBruteForce(List<Integer> arr) {
        int sum = 0;
        for (Integer i : arr) {
            sum += arr.get(i);
        }
        if (sum % 2 != 0) {
            return new ArrayList<>();
        }
        recursive(arr, 0, sum / 2);
        return null;
    }

    private static void recursive(List<Integer> arr, int idx, int sum) {
    }

    public static boolean canEqualPartition(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }

        // if 'sum' is a an odd number, we can't have two subsets with equal sum
        if (sum % 2 != 0) {
            return false;
        }

        return canPartitionRecursive(num, sum / 2, 0);
    }

    private static boolean canPartitionRecursive(int[] num, int sum, int idx) {

        if (sum == 0) {
            return true;
        }

        if (num.length == 0 || idx >= num.length) {
            return false;
        }

        if (num[idx] <= sum) {
            if (canPartitionRecursive(num, sum - num[idx], idx + 1)) {
                return true;
            }
        }
        return canPartitionRecursive(num, sum, idx + 1);
    }

    //use memoization
    public static boolean canEqualPartitionMemoization(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }

        // if 'sum' is a an odd number, we can't have two subsets with equal sum
        if (sum % 2 != 0) {
            return false;
        }
        List<Integer> slate = new ArrayList<>();
        Boolean[][] memo = new Boolean[num.length][sum / 2 + 1];
        return canPartitionRecursiveWithMemoization(num, sum / 2, 0, memo);
    }

    private static boolean canPartitionRecursiveWithMemoization(int[] num, int sum, int idx, Boolean[][] memo) {

        if (sum == 0) {
            return true;
        }

        if (num.length == 0 || idx >= num.length) {
            return false;
        }

        if (memo[idx][sum] == null) {
            if (num[idx] <= sum) {
                if (canPartitionRecursive(num, sum - num[idx], idx + 1)) {
                    memo[idx][sum] = true;
                    return true;
                }
            }
            memo[idx][sum] = canPartitionRecursive(num, sum, idx + 1);
        }
        return memo[idx][sum];
    }

    //use DP table
    public static boolean canEqualPartitionWithDP(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }

        // if 'sum' is a an odd number, we can't have two subsets with equal sum
        if (sum % 2 != 0) {
            return false;
        }

        Boolean[][] dp = new Boolean[num.length][sum + 1];

        for (int i = 0; i < num.length; i++) {
            dp[i][0] = true;
        }

        for (int s = 1; s < sum; s++) {
            dp[0][s] = (num[0] == s ? true : false);
        }

        for (int i = 1; i < num.length; i++) {
            for (int s = 1; s <= sum; s++) {
                if(dp[i-1][s]) {
                    dp[i][s] = dp[i-1][s];
                }
                else if(s >= num[i]) {
                    dp[i][s] = dp[i-1][s-num[i]];
                }
            }
        }

        return dp[num.length-1][sum];
    }

    public static List<Integer> equalPartitionSet(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }

        // if 'sum' is a an odd number, we can't have two subsets with equal sum
        if (sum % 2 != 0) {
            return new ArrayList<>();
        }

        List<Integer> slate = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        canPartitionRecursive(num, sum / 2, 0, slate, result);
        return result;
    }

    private static void canPartitionRecursive(int[] num, int sum, int idx, List<Integer> slate, List<Integer> result) {
        if (sum == 0) {
            result.addAll(slate);
        } else if (num.length == 0 || idx >= num.length) {
            return;
        } else {
            if (num[idx] <= sum) {
                slate.add(num[idx]);
                canPartitionRecursive(num, sum - num[idx], idx + 1, slate, result);
                if (result.size() > 0) {
                    return;
                }
                slate.remove(slate.size() - 1);
            }
            canPartitionRecursive(num, sum, idx + 1, slate, result);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 5, 11, 5 };
        boolean flag = canEqualPartition(nums);
        System.out.println("Brut-force = " + flag);

        flag = canEqualPartitionMemoization(nums);
        System.out.println("Memo =" + flag);

        List<Integer> result = equalPartitionSet(nums);
        result.forEach(System.out::print);
    }
}
