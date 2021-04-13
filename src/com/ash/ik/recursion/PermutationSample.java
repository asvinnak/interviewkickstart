package com.ash.ik.recursion;

public class PermutationSample {

    public static void main(String[] args) {

        char[] input = { 'H', 'A', 'T' };
        driver(input);
    }

    private static void driver(char[] input) {

        helper(input, 0, new StringBuilder());
    }

    private static void helper(char[] input, int idx, StringBuilder soFar) {
        //base case

        if (idx == input.length) {
            System.out.println(soFar.toString());
        } else {
            //Choices
            for (int i = idx; i < input.length; i++) {
                swap(input, idx, i);
                soFar.append(input[idx]);
                helper(input, idx + 1, soFar);
                soFar.deleteCharAt(soFar.length() - 1);
                swap(input, idx, i);
            }
        }
    }

    private static void swap(char[] a, int s, int t) {
        char tmp = a[t];
        a[t] = a[s];
        a[s] = tmp;
    }
}
