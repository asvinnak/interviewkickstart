package com.ash.ik.arrays;

import java.util.Arrays;

public class MergeTwoArrays {

    public int[] mergeTwoSortedArrays(int[] a1, int[] a2) {
        int[] result = new int[a1.length+a2.length];

        int p1 = 0;
        int p2 = 0;
        int i = 0;
        int prev = Integer.MIN_VALUE;

        while (p1 < a1.length && p2 < a2.length) {

            if (a1[p1] == a2[p2] && a1[p1] != prev) {
                result[i] = a1[p1];
                prev = a1[p1];
                p1++;
                p2++;
                i++;
            } else if (a1[p1] < a2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] one = { 2, 3, 3, 5, 5, 6, 7, 7, 8, 12 };
        int[] two = { 5, 5, 6, 8, 8, 9, 10, 10, 12 };

        MergeTwoArrays o = new MergeTwoArrays();

        int[] res= o.mergeTwoSortedArrays(one, two);

        System.out.println(Arrays.toString(res));
    }
}
