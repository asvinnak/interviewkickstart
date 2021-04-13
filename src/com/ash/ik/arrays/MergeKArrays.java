package com.ash.ik.arrays;

import java.util.Arrays;

public class MergeKArrays {

    /*
     * Complete the mergeArrays function below.
     */
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

    static boolean findAscSortedOrder2(int[][] arr) {
        int[] a;
        for (int i = 0; i < arr.length; i++) {
           for(int j=0; j<arr[0].length-1; j++) {
               if (arr[i][j] < arr[i][j+1]) {
                   return true;
               } else if (arr[i][j] > arr[i][j+1]) {
                   return false;
               }
           }
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] arr1 = { { 1, 3, 5, 7 },

            { 2, 4, 6, 8 },

            { 0, 9, 10, 11 } };

        int[] res1 = MergeKArrays.mergeArrays(arr1);

        System.out.println(Arrays.toString(res1));
    }
}
