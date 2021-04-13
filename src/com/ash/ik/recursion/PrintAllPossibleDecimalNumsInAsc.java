package com.ash.ik.recursion;

public class PrintAllPossibleDecimalNumsInAsc {

    public static void driver(int n) {

        helper(n, new StringBuilder());
    }

    private static void helper(int n, StringBuilder soFar) {

        //base case
        if (n == 0) {
            //print
            System.out.println(soFar.toString());
        } else {
            for (int i = 0; i <= 9; i++) {
                soFar.append(i);
                helper(n - 1, soFar);
                soFar.deleteCharAt(soFar.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        driver(2);
    }
}
