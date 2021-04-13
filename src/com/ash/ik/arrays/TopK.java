package com.ash.ik.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * Top K You are given an array of integers, arr, of size n, which is analogous to a continuous stream of integers
 * input. Your task is to find K largest elements from a given stream of numbers.
 * <p>
 * By definition, we don't know the size of the input stream. Hence, produce K largest elements seen so far, at any
 * given time. For repeated numbers, return them only once.
 * <p>
 * If there are less than K distinct elements in arr, return all of them.
 * <p>
 * Don't rely on size of input array arr. Feel free to use built-in functions if you need a specific data-structure. ﻿
 * <p>
 * Example One
 * <p>
 * Input: arr = [1, 5, 4, 4, 2]; K = 2
 * <p>
 * <p>
 * <p>
 * Output: [4, 5]
 * <p>
 * <p>
 * <p>
 * Example Two
 * <p>
 * Input: arr = [1, 5, 1, 5, 1]; K = 3
 * <p>
 * <p>
 * <p>
 * Output: [5, 1]
 * <p>
 * <p>
 * <p>
 * Notes
 * <p>
 * Input Parameters: There is only one argument: Integer array arr.
 * <p>
 * <p>
 * <p>
 * Output: Return an integer array res, containing K largest elements. If there are less than K unique elements, return
 * all of them. Order of elements in res does not matter.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^5 1 <= K <= 10^5 arr may contain duplicate numbers. arr may or may not be sorted
 */
public class TopK {

    static int[] topK(int[] arr, int k) {

        Set<Integer> set = new HashSet<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        for (int i = 0; i < arr.length; i++) {
            if (pq.isEmpty() || pq.size() < k && !set.contains(arr[i]) || arr[i] > pq.peek() && !set.contains(
                arr[i])) {
                if (pq.size() == k) {

                    set.remove(pq.poll());
                }
                pq.add(arr[i]);
                set.add(arr[i]);
            }
        }


        int[] out = new int[set.size()];
        Object[] res = set.toArray();
        for (int j = 0; j < res.length; j++) {
            out[j] = (int) res[j];
        }

        return out;
    }

    public static int[] topKOptimized(int[] arr, int k) {
        TreeSet<Integer> tree = new TreeSet<>();
        for(int i=0;i<arr.length;i++){
            tree.add(arr[i]);
            if(tree.size()>k){
                tree.pollFirst();
            }
        }

        int[] result = new int[tree.size()];
        int ptr = 0;

        for(int i:tree){
            result[ptr++]=i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[] { 1, 5, 4, 4, 2 };
        int[] b = new int[] { 1, 5, 1, 5, 1 };
        int[] c = new int[] { 5, 4, 3, 5, 6, 6, 9, 2, 5, 1, 1, 6, 9, 5, 10, 5, 5, 10, 15 };
        int[] d = new int[] { 5, 6, 1, 4, 1, 8, 2, 4, 1, 7, 9, 3, 2, 1, 2 };
        int[] e = new int[] { 2, 7, 6, 1, 7, 8, 10, 3, 10, 7, 1, 10, 6, 5, 4 };
        int k = 2;

        int[] r = topK(a, 2);
        //int[] r1 = topK(b, 3);
        int[] r2 = topK(e, 4);
        //System.out.println(Arrays.toString(r));
        //System.out.println(Arrays.toString(r1));
        System.out.println(Arrays.toString(r2));
    }
}
