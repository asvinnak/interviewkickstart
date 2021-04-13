package com.ash.ik.sorting;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    int[] a;

    public static void main(String[] s) throws IOException {
        QuickSort o = new QuickSort();
        o.a = new int[] { 5, 9, 7, 3, 2, 10 };
        o.a = o.quickSort(o.a);

        System.out.println(Arrays.toString(o.a));
    }

    private int[] quickSort(int[] a) {
        divideAndSolve(0, a.length - 1);
        return a;
    }

    private void divideAndSolve(int start, int end) {

        if (start >= end) {
            return;
        }

        int randomIdx = new Random().nextInt((end - start) + 1) + start;

        swap(randomIdx, start);

        int pivot = a[start];
        int p1 = start;
        int p2 = start;

        while (p2 <= end) {
            if (a[p2] < pivot) {
                p1++;
                swap(p2, p1);
            }
            p2++;
        }

        swap(start, p1);

        divideAndSolve(start, p1 - 1);
        divideAndSolve(p1 + 1, end);
    }

    private void swap(int s, int t) {
        int tmp = a[s];
        a[s] = a[t];
        a[t] = tmp;
    }
}
