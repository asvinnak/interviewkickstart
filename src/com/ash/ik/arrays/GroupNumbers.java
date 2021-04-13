package com.ash.ik.arrays;

import java.util.Arrays;

/**
 * You are given an integer array arr of size n. Group and rearrange them (in-place) into evens and odds in such a way
 * that group of all even integers appears on the left side and group of all odd integers appears on the right side.
 * <p>
 * <p>
 * <p>
 * Example
 * <p>
 * Input: [1, 2, 3, 4]
 * <p>
 * <p>
 * <p>
 * Output: [4, 2, 1, 3]
 * <p>
 * <p>
 * <p>
 * Order does not matter. Other valid solutions are:
 * <p>
 * [2, 4, 1, 3]
 * <p>
 * [2, 4, 3, 1]
 * <p>
 * [4, 2, 3, 1]
 * <p>
 * <p>
 * <p>
 * Notes
 * <p>
 * Input Parameters: There is only one argument: Integer array arr.
 * <p>
 * <p>
 * <p>
 * Output: Return the same integer array, with evens on left side and odds on the right side.
 * <p>
 * There is no need to preserve order within odds or within evens.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^5 arr contains only positive integers. arr may contain duplicate numbers. Solution with linear time
 * complexity and constant auxiliary space is expected.
 * <p>
 * <p>
 * Custom Input
 * <p>
 * Input Format: The first line of input should contain an integer n, denoting size of input array arr. In next n lines,
 * ith line should contain an integer arr[i], denoting a value at index i of arr.
 * <p>
 * If n = 4 and arr = [1, 2, 3, 4], then input should be:
 * <p>
 * 4
 * <p>
 * 1
 * <p>
 * 2
 * <p>
 * 3
 * <p>
 * 4
 * <p>
 * <p>
 * <p>
 * Output Format: There will be n lines of output, where ith line contains an integer res[i], denoting value at index i
 * of res.
 * <p>
 * Here, res is the result array returned by solution function.
 * <p>
 * For input n = 4 and arr = [1, 2, 3, 4], output will be:
 * <p>
 * 4
 * <p>
 * 2
 * <p>
 * 1
 * <p>
 * 3
 */
public class GroupNumbers {

    private static int[] solve(int[] arr) {

        if (arr == null || arr.length == 0) {
            return arr;
        }

        int tmp;
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {

            if (arr[l] % 2 != 0 && arr[r] % 2 == 0) {
                tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
                l++;
                r--;
            } else if (arr[l] % 2 != 0) {
                r--;
            } else {
                l++;
            }
        }

        return arr;
    }

    public static int[] lomuto(int[] arr) {

        int small = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                swap(arr, i, small);
                small++;
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int index1, int index2) {

        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] arr) {
        int[] a = new int[] { 1, 2, 5, 8, 8, 12 };
        int[] b = lomuto(a);
        System.out.println(Arrays.toString(b));
    }
}
