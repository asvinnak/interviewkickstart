package com.ash.ik.sorting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Test {

    /*
     * Complete the 'merge_sort' function below.
     *
     * The function accepts an integer array as parameter.
     */

    private static void divideAndConqur(List<Integer> arr, int s, int e) {

        if (s >= e) {
            return;
        }

        int mid = (s + e) / 2;

        divideAndConqur(arr, s, mid);
        divideAndConqur(arr, mid + 1, e);
        merge(arr, s, mid, e);
    }

    private static void merge(List<Integer> arr, int s, int mid, int e) {
        List<Integer> aux = new ArrayList<>(arr);

        int i = s;
        int k = s;
        int j = mid + 1;

        while (i <= mid && j <= e) {
            if (aux.get(i) <= aux.get(j)) {
                arr.set(k, aux.get(i));
                i++;
            } else {
                arr.set(k, aux.get(j));
                j++;
            }
            k++;
        }

        while (i <= mid) {
            arr.set(k, aux.get(i));
            i++;
            k++;
        }

        while (j <= e) {
            arr.set(k, aux.get(j));
            j++;
            k++;
        }
    }

    public static List<Integer> merge_sort(List<Integer> arr) {
        divideAndConqur(arr, 0, arr.size() - 1);
        return arr;
    }

    public static void main(String[] s) throws IOException {

        //List<Integer> a = Arrays.asList(5, 9, 7, 3, 2, 10, 111, 6, 94, 8);
        List<Integer> a = new ArrayList<>();
        for(int i=0; i< 100000; i++) {
            a.add(new Random().nextInt(100000));
        }
        List<Integer> result = merge_sort(a);
        result.forEach(System.out::println);
    }
}
