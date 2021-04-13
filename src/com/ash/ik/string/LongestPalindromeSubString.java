package com.ash.ik.string;

import java.io.IOException;

/**
 * Find the longest palindrome * Example Input: "greatpopmalayalampeople" * output: "The biggest palindrome in given
 * string is : malayalam *
 */
public class LongestPalindromeSubString {

    private String longestPalindrome(String s) throws IOException {

        if (s == null) {
            throw new IOException("Input is empty");
        }

        String longPalindrome = "";
        String palindrome = "";
        for (int i = 0; i < s.length(); i++) {
            palindrome = findPalindrome(s, i, i);
            longPalindrome = palindrome.length() > longPalindrome.length() ? palindrome : longPalindrome;
            palindrome = findPalindrome(s, i, i + 1);
            longPalindrome = palindrome.length() > longPalindrome.length() ? palindrome : longPalindrome;
        }

        return longPalindrome;
    }

    private String findPalindrome(String s, int left, int right) {
        if (left > right) {
            return null;
        }

        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return s.substring(L + 1, R);
    }

    public static void main(String[] args) throws IOException {
        LongestPalindromeSubString o = new LongestPalindromeSubString();
        String str = "greatpopmalayalamcrew";
        String str1 = "forgeeksskeegfor";
        String str2 = "formalayalamfor";
        System.out.println("Length is: " + o.longestPalindrome(str));
        System.out.println("Length is: " + o.longestPalindrome(str1));
        System.out.println("Length is: " + o.longestPalindrome(str2));
    }
}
