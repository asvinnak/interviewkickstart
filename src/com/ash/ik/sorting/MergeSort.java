package com.ash.ik.sorting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    int[] a;

    public static void main(String[] s) throws IOException {
        MergeSort o = new MergeSort();
        o.a = new int[] { 5, 9, 7, 3, 2, 10 };
        o.a = o.mergeSort(o.a);
        System.out.println(Arrays.toString(o.a));
    }

    private int[] mergeSort(int[] a) {
        if (a.length <= 1) {
            return a;
        }

        mergeSortRecursive(a, 0, a.length - 1);

        return a;
    }

    private void mergeSortRecursive(int[] a, int start, int end) {

        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSortRecursive(a, start, mid);
        mergeSortRecursive(a, mid + 1, end);

        combine(a, start, mid, end);
    }

    private void combine(int[] a, int start, int mid, int end) {

        int[] aux = Arrays.copyOf(a, a.length);

        int i = start;
        int j = mid + 1;
        int k = start;

        while (i <= mid && j <= end) {

            if (aux[i] <= aux[j]) {
                a[k] = aux[i];
                i++;
            } else {
                a[k] = aux[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            a[k] = aux[i];
            i++;
            k++;
        }

        while (j <= end) {
            a[k] = aux[j];
            j++;
            k++;
        }
    }
}
