package com.ash.ik.string;

/**
 * Example 1:
 *
 * Input: source = "abc", target = "abcbc"
 * Output: 2
 * Explanation: The target "abcbc" can be formed by "abc" and "bc", which are subsequences of source "abc".
 * Example 2:
 *
 * Input: source = "abc", target = "acdbc"
 * Output: -1
 * Explanation: The target string cannot be constructed from the subsequences of source string due to the character
 * "d" in target string.
 * Example 3:
 *
 * Input: source = "xyz", target = "xzyxz"
 * Output: 3
 * Explanation: The target string can be constructed as follows "xz" + "y" + "xz".
 */
public class ShortestWayToFormString {
    public int shortestWay(String source, String target) {

        int subsequence= 0;
        String remining= target;

        while(remining.length() > 0) {
            StringBuilder sb= new StringBuilder();
            int i= 0;
            int j=0;

            while(i < source.length() && j<remining.length()) {
                if(source.charAt(i++) == remining.charAt(j)) {
                    sb.append(remining.charAt(j));
                    j++;
                }
                if(sb.length() == 0) {
                    return -1;
                }
                subsequence++;
                remining = remining.substring(sb.length());
            }
        }
        return subsequence;
    }

}
