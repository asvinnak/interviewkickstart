package com.ash.ik.sorting;

import java.io.IOException;
import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] s) throws IOException {
        InsertionSort o = new InsertionSort();
        int[] a = { 5, 9, 7, 3, 2, 10 };
        a = o.insertionSortRecursive(a, a.length-1);
        System.out.println(Arrays.toString(a));

        int[] b = { 5, 9, 7, 3, 2, 10 };
        b = o.insertionSortIterative(b);
        System.out.println(Arrays.toString(b));
    }

    private int[] insertionSortIterative(int[] b) {

        int n = b.length;

        int val, idx;
        for (int i = 1; i < n; i++) {
            val = b[i];
            idx = i;
            while (idx > 0 && b[idx - 1] > val) {
                b[idx] = b[idx - 1];
                idx = idx - 1;
            }
            b[idx] = val;
        }

        return b;
    }

    private int[] insertionSortRecursive(int[] a, int n) {

        if (n == 0) {
            return a;
        }
        insertionSortRecursive(a, n - 1);

        int val = a[n];
        while (n > 0 && a[n-1] > val){
            a[n] = a[n-1];
            n= n-1;
        }
        a[n] = val;
        return a;
    }
}
