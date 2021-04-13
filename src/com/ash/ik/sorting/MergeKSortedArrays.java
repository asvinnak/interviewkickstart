package com.ash.ik.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Merge K sorted arrays This is a popular Facebook problem.
 * <p>
 * Given K sorted arrays arr, of size N each, merge them into a new array res, such that res is a sorted array.
 * <p>
 * Assume N is very large compared to K. N may not even be known. The arrays could be just sorted streams, for instance,
 * timestamp streams.
 * <p>
 * All arrays might be sorted in increasing manner or decreasing manner. Sort all of them in the manner they appear in
 * input.
 * <p>
 * Repeats are allowed. Negative numbers and zeros are allowed. Assume all arrays are sorted in the same order. Preserve
 * that sort order in output. It is possible to find out the sort order from at least one of the arrays.
 * <p>
 * <p>
 * Example
 * <p>
 * Input:
 * <p>
 * K = 3, N = 4
 * <p>
 * arr = [[1, 3, 5, 7],
 * <p>
 * [2, 4, 6, 8],
 * <p>
 * [0, 9, 10, 11]]
 * <p>
 * <p>
 * <p>
 * Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
 * <p>
 * <p>
 * <p>
 * A solution which dumps all elements from all arrays into one massive heap, and then extracts the elements one by one
 * into a sorted output may pass, but is not acceptable. These issues should go away when we have a more nuanced
 * backend.
 * <p>
 * <p>
 * <p>
 * Notes
 * <p>
 * Input Format: There is only one argument: 2D Integer array arr.
 * <p>
 * Here, arr[i][j] denotes value at index j of ith input array, 0-based indexing. So, arr is K * N size array.
 * <p>
 * <p>
 * <p>
 * Output: Return an integer array res, containing all elements from all individual input arrays combined.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= N <= 500 1 <= K <= 500 -10^6 <= arr[i][j] <= 10^6, for all valid i,j
 * <p>
 * <p>
 * Custom Input
 * <p>
 * Input Format: The first line of input should contain an integer K. The second line should contain an integer N,
 * denoting size of each input array. In next K lines, ith line should contain N space separated integers, denoting
 * content of ith array of K input arrays, where jth element in this ith line is nothing but arr[i][j], i.e. value at
 * index j of ith array, 0-based indexing.
 * <p>
 * If K = 3, N = 4 and arr = [
 * <p>
 * [1, 3, 5, 7],
 * <p>
 * [2, 4, 6, 8],
 * <p>
 * [0, 9, 10, 11]
 * <p>
 * ], then input should be:
 * <p>
 * 3
 * <p>
 * 4
 * <p>
 * 1 3 5 7
 * <p>
 * 2 4 6 8
 * <p>
 * 0 9 10 11
 * <p>
 * <p>
 * <p>
 * Output Format: There will be (N*K) lines of output, where ith line contains an integer res[i], denoting value at
 * index i of res.
 * <p>
 * Here, res is the result array returned by the solution.
 * <p>
 * For input K = 3, N = 4 and arr = [
 * <p>
 * [1, 3, 5, 7],
 * <p>
 * [2, 4, 6, 8],
 * <p>
 * [0, 9, 10, 11]
 * <p>
 * ], output will be:
 * <p>
 * 0
 * <p>
 * 1
 * <p>
 * 2
 * <p>
 * 3
 * <p>
 * 4
 * <p>
 * 5
 * <p>
 * 6
 * <p>
 * 7
 * <p>
 * 8
 * <p>
 * 9
 * <p>
 * 10
 * <p>
 * 11
 */
public class MergeKSortedArrays {

    static int[] mergeArrays(int[][] arr) {

        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int k = arr.length;
        int n = arr[0].length;
        int[] finalSortedArray = new int[k * n];

        boolean ascendingOrder = findAscSortedOrder(arr);

        int[] indices = new int[k];
        int curr_indice = 0;

        int minORmax;
        int maxORminIdx = Integer.MIN_VALUE;
        int l = 0;
        int[] curr_arr;
        while (!findIndicesExhausted(indices, n)) {
            minORmax = ascendingOrder ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                curr_arr = arr[i];
                curr_indice = indices[i];

                if (curr_indice == n) {
                    continue;
                }

                if (ascendingOrder && minORmax > curr_arr[curr_indice] || !ascendingOrder && minORmax < curr_arr[curr_indice]) {
                    minORmax = curr_arr[curr_indice];
                    maxORminIdx = i;
                }
            }
            finalSortedArray[l++] = minORmax;
            indices[maxORminIdx]++;
        }

        return finalSortedArray;
    }

    private static boolean findIndicesExhausted(int[] indices, int n) {

        for (int idx : indices) {
            if (idx < n) {
                return false;
            }
        }

        return true;
    }

    static boolean findAscSortedOrder(int[][] arr) {
        int[] a;
        for (int i = 0; i < arr.length; i++) {
            a = arr[i];
            if (a[0] < a[a.length - 1]) {
                return true;
            } else if (a[0] > a[a.length - 1]) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // int[][] input = { { 9, 9, 9, 9 }, { 9, 9, 9, 9 }, { 9, 9, 9, 9 }, { 9, 9, 9, 10 }, { 9, 9, 9, 9 },
        //     { 9, 9, 9, 9 } };
        // int[][] input = { { 25, 20, 20, 18, 18, 18, 12, 7 }, { 25, 25, 21, 19, 19, 11, 2, 2 },
        //     { 21, 17, 14, 13, 13, 10, 8, 3 } };
        int[][] input = { { 6, 10, 15 }, { 7, 9, 18 } };
        int[] out = MergeKSortedArrays.mergeArrays(input);
        System.out.println(Arrays.toString(out));
    }
}
