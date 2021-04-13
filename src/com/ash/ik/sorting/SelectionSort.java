package com.ash.ik.sorting;

import java.io.IOException;
import java.util.Arrays;

public class SelectionSort {

    public int[] selectionSort(int[] a) {
        int n = a.length;
        int min;
        int minIdx = 0;

        for (int i = 0; i < n; i++) {
            min = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (a[j] < min) {
                    min = a[j];
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                swap(a, i, minIdx);
            }
        }
        return a;
    }

    private void swap(int[] a, int s, int d) {
        int t = a[s];
        a[s] = a[d];
        a[d] = t;
    }

    public static void main(String[] s) throws IOException {
        SelectionSort o = new SelectionSort();
        int[] a = { 5, 9, 7, 3, 2, 10 };
        a = o.selectionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
