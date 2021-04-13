package com.ash.ik.sorting;

import java.io.IOException;
import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] s) throws IOException {
        BubbleSort o = new BubbleSort();
        int[] a = { 5, 9, 7, 3, 2, 10 };
        a = o.bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    private int[] bubbleSort(int[] a) {

        int n = a.length;

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j, j - 1);
                }
            }
        }

        return a;
    }

    private void swap(int[] a, int s, int d) {
        int t = a[s];
        a[s] = a[d];
        a[d] = t;
    }
}
