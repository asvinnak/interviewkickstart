package com.ash.ik.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecompositionOfPalindrome {


    static String[] generate_palindromic_decompositions(String s) {
        List<String> results = new ArrayList<>();

        generate(s.toCharArray(), 0, new char[2 * s.length()], 0, results);

        return results.toArray(new String[results.size()]);
    }

    static void generate(char[] s, int pos, char[] out, int j, List<String> results) {
        if (pos == s.length) {
            results.add(new String(out, 0, j - 1));
            return;
        }

        for (int i = pos; i < s.length; i++) {
            int lengthOfCharAdded = i - pos;
            out[j + lengthOfCharAdded] = s[i];
            if (isPalindrome(s, pos, i)) {
                out[j + (i - pos) + 1] = '|';
                generate(s, pos + lengthOfCharAdded + 1, out, j + lengthOfCharAdded + 2 /* 1 for | and 1 for next char*/, results);
            }
        }
    }

    static boolean isPalindrome(char[] arr, int lo, int hi) {
        while (lo < hi) {
            if (arr[lo] != arr[hi]) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generate_palindromic_decompositions("abracadabra")));
    }
    //O/P: [a|b|r|a|c|a|d|a|b|r|a, a|b|r|a|c|ada|b|r|a, a|b|r|aca|d|a|b|r|a]


}
