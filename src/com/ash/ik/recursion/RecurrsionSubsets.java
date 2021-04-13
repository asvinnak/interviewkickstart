package com.ash.ik.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecurrsionSubsets {

    public static List<String> driver(int[] input) {
        List<String> result = new ArrayList<>();
        helper(input, 0, new StringBuilder(), result);
        return result;
    }

    private static void helper(int[] input, int idx, StringBuilder soFar, List<String> result) {

        //base case:
        if (idx == input.length) {
            result.add(soFar.toString());
        } else {

            //exclusion
            helper(input, idx + 1, soFar, result);

            //inclusion
            soFar.append(input[idx]);
            helper(input, idx + 1, soFar, result);
            soFar.deleteCharAt(soFar.length() - 1);
        }
    }

    static String[] generate_all_subsets(String s) {

        List<String> result = new ArrayList();
        if (s == null || s.length() == 0) {
            result.add("");
        } else {
            helper(s, 0, new StringBuilder(), result);
        }
        return result.toArray(new String[result.size()]);
    }

    static void helper(String s, int idx, StringBuilder soFar, List<String> result) {

        if (idx == s.length()) {
            result.add(soFar.toString());
        } else {
            //exclude
            helper(s, idx + 1, soFar, result);

            //Include
            soFar.append(s.charAt(idx));
            helper(s, idx + 1, soFar, result);
            soFar.deleteCharAt(soFar.length() - 1);
        }
    }

    public static void main(String[] args) {

        String[] result = generate_all_subsets("xy");
        System.out.println(Arrays.deepToString(result));
        int[] input = { 1, 2, 3 };
        driver(input).forEach(System.out::println);
    }
}
