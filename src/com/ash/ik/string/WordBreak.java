package com.ash.ik.string;

// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be
// segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not
// contain duplicate words.

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

// For example, given
// s = "leetcode",
// dict = ["leet", "code"].
public class WordBreak {

    private boolean wordBreak(Set<String> dict, String leetcode) throws IOException {

        if (dict == null || dict.size() == 0) {
            throw new IOException("Dictonary is empty");
        }

        if (leetcode == null || leetcode.length() == 1) {
            return false;
        }

        boolean[] flag = new boolean[leetcode.length() + 1];
        flag[0] = true;

        for (int i = 1; i <= leetcode.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (flag[j] && dict.contains(leetcode.substring(j, i))) {
                    flag[i] = true;
                    break;
                }
            }
        }

        return flag[flag.length - 1];
    }

    public static void main(String[] args) throws IOException {
        WordBreak o = new WordBreak();
        Set<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("code");
        System.out.println(o.wordBreak(dict, "leetcode"));
    }
}
