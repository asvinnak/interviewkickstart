package com.ash.ik.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSum {

    public List<List<Integer>> twoSum(int[] a, int t) {

        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(a);

        int start = 0;
        int end = a.length - 1;

        while (start < end) {
            if (a[start] + a[end] == t) {
                output.add(Arrays.asList(a[start], a[end]));
            }
            if (a[start] + a[end] > t) {
                end--;
            } else {
                start++;
            }
        }

        return output;
    }

    static boolean findSum(int[] a, int t) {

        if(a == null) {
            return false;
        }

        HashMap<Integer, Integer> map= new HashMap<>();
        int diff = 0;
        for(int i=0; i<a.length; i++) {
            diff = t - a[i];

            if(map.containsKey(diff)) {
                return true;
            }
            map.put(a[i], diff);
        }

        return false;
    }

    static boolean findSum1(int[] a, int t) {

        if(a == null) {
            return false;
        }

        HashMap<Integer, Integer> map= new HashMap<>();
        int diff = 0;
        for(int i=0; i<a.length; i++) {
            diff = t - a[i];

            if(map.containsKey(a[i])) {
                return true;
            }
            map.put(diff, a[i]);
        }

        return false;
    }

    static List<List<Integer>> twoSum1(int[] a, int t) {

        List<List<Integer>> result= null;
        if(a == null) {
            return result;
        }

        HashMap<Integer, Integer> map= new HashMap<>();
        int diff = 0;
        for(int i=0; i<a.length; i++) {
            diff = t - a[i];

            if(map.containsKey(diff)) {
                result.add(Arrays.asList(map.get(diff), a[i]));
            }
            map.put(a[i], diff);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = { 4, 6, 2, 1, 10, 4, 5, 6, 3, 8, 7 };
        TwoSum o = new TwoSum();
        o.twoSum(a, 8).forEach(System.out::print);
        //o.twoSum(a, 8).forEach(System.out::print);

        int[] b = { 4, 6, 2, 1, 10, 9, 7 };

        System.out.println(findSum(a, 8));
        System.out.println(findSum1(a, 8));
    }
}
