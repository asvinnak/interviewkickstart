package com.ash.ik.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * int[] nums = {5,6,8,4,9,10,8,3,6,4}; int[] queries = {3,1,8};
 */
public class StockDataPrediction {

    private static List<Integer> getClosestSmaller(int[] nums, int[] queries) {

        List<Integer> result = new ArrayList<>();

        for (int q : queries) {

            int idx = q - 1;
            int left = idx - 1;
            int right = idx + 1;

            while (left >= 0 || right < nums.length) {
                if (left >= 0 && nums[left] < nums[idx]) {
                    break;
                } else if (right < nums.length && nums[right] < nums[idx]) {
                    break;
                }
                if (left >= 0) {
                    left--;
                }
                if (right < nums.length) {
                    right++;
                }
            }
            result.add(left < 0 && right >= nums.length ? -1
                : left < 0 ? right + 1 : right >= nums.length ? left + 1 : Math.min(left, right)+1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 6, 8, 4, 9, 10, 8, 3, 6, 4 };
        int[] queries = { 3, 1, 8 };
        System.out.println(getClosestSmaller(nums, queries));
    }
}
