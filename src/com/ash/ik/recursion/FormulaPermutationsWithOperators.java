package com.ash.ik.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Output formula with permutations and operators, all input integers are positive and no duplicate
 * <p>
 * input: [1,2] output: ['1+2', '2+1', '1-2', '2-1', '1*2', '2*1', '1/2', '2/1']
 * <p>
 * input: [1,2,3] output: [1+2+3', '1-2-3', '1*2*3', 1/2/3', 1*2/3, '1/2*3', '2-1*3', '2*1/3', ........]
 */
public class FormulaPermutationsWithOperators {

    public static List<String> generateFormulas(int[] arr) {

        List<String> output = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return output;
        }

        helper(arr, 0, new StringBuilder(), output);
        return output;
    }

    private static void helper(int[] arr, int idx, StringBuilder sb, List<String> output) {

        if (arr.length == idx) {
            output.add(sb.toString());
            return;
        }

        for(int i=idx; i<arr.length; i++) {
            swap(arr, i, idx);
            if (idx == 0) {
                helper(arr, idx + 1, sb.append(arr[idx]), output);
                sb.deleteCharAt(sb.length() - 1);
            } else {
                helper(arr, idx + 1, sb.append("+").append(arr[idx]), output);
                sb.delete(sb.length() - 2, sb.length());
                helper(arr, idx + 1, sb.append("-").append(arr[idx]), output);
                sb.delete(sb.length() - 2, sb.length());
                helper(arr, idx + 1, sb.append("*").append(arr[idx]), output);
                sb.delete(sb.length() - 2, sb.length());
                helper(arr, idx + 1, sb.append("/").append(arr[idx]), output);
                sb.delete(sb.length() - 2, sb.length());
            }
            swap(arr, i, idx);
        }

    }

    private static void swap(int[] arr, int a, int b) {
        int t= arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    public static void main(String[] args) {
        int[] a= new int[] {1,2,3};
        List<String> result = generateFormulas(a);

        for (String s : result) {
            System.out.println(s);
        }

    }
}
