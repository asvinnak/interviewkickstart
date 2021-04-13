package com.ash.ik.recursion;

import java.util.HashSet;
import java.util.Set;

public class PermutationsWithDuplicates {


    public static void main(String[] args) {

        int[] input = { 1,2,1,3,2 };
        driver(input);
    }

    private static void driver(int[] input) {

        helper(input, 0, new StringBuilder());
    }

    private static void helper(int[] input, int idx, StringBuilder sb) {
        //base case

        if (idx == input.length) {
            System.out.println(sb.toString());
        } else {
            //Choices
            Set<Integer> cache= new HashSet<>();
            for (int i = idx; i < input.length; i++) {
                if(cache.contains(input[i])) {
                    continue;
                }
                cache.add(input[i]);
                swap(input, idx, i);
                sb.append(input[idx]);
                helper(input, idx + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
                swap(input, idx, i);
            }
        }
    }

    private static void swap(int[] a, int s, int t) {
        int tmp = a[t];
        a[t] = a[s];
        a[s] = tmp;
    }

}
