package com.ash.ik.dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakCount {

    public static int wordBreakCount1(List<String> dictionary, String txt) {
        // Write your code here

        int L=0;
        int R=0;

        int n= txt.length();
        StringBuilder word= new StringBuilder();
        int i=0;
        String formedWord= "";
        Set<String> ways= new HashSet();
        while(R<n) {
            if(R==n) {
                ways.add(formedWord);
            }
            if(dictionary.contains(word.toString())) {
                formedWord = formedWord + word.toString() + " ";
                word= new StringBuilder();
                L = R;
            }
            word.append(txt.charAt(i));
            R++;
        }

        return ways.size();

    }
    public static int wordBreakCount(List<String> dictionary, String txt) {

        Set<String> set= new HashSet<>();
        int maxLength= 0;
        for(String s: dictionary) {
            set.add(s);
            maxLength= Math.max(maxLength, s.length());
        }

       return wordBreakCountLogic(set, maxLength, txt);


    }

    private static int wordBreakCountLogic(Set<String> set, int maxLength, String txt) {
        int n= txt.length();
        int[] dp= new int[n+1];
        dp[0] = 1;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<=n && (j-i) <= maxLength; j++) {
                String word= txt.substring(i, j);
                if(set.contains(word)) {
                    dp[j] += dp[i];
                    dp[j] = dp[j]%1000000007;
                }
            }
        }

        return dp[n];

    }

    public static void main(String[] args) {
        List<String> dict= Arrays.asList("kick", "start", "kickstart", "is", "awe", "some", "awesome");
        System.out.println(wordBreakCount(dict, "kickstartisawesome"));

        List<String> dict1= Arrays.asList("aswani", "kumar", "vinnakota", "aswanikumar", "kumarvinnakota");
        System.out.println(wordBreakCount(dict1, "aswanikumarvinnakota"));
    }
}
