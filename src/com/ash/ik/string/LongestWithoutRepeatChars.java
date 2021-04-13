package com.ash.ik.string;

import java.io.IOException;

public class LongestWithoutRepeatChars {




    public int lengthOfLongestSubstring(String s) {

        int L=0;
        int R= 0;
        String word= "";
        int longest= Integer.MIN_VALUE;
        char[] ch= s.toCharArray();

        while(L <= R && R < s.length()) {
            if(word.lastIndexOf(ch[R]) != -1 ) {
                longest = Math.max(longest, R - L);
                while( L < R) {
                    if(ch[L] == ch[R]) {
                        L++;
                        break;
                    }
                    L++;
                }
                word= s.substring(L, R) + ch[R];
            } else {
                word= word + ch[R];
            }
            R++;
        }

        longest = Math.max(longest, R - L);

        return longest;

    }

    public static void main(String[] args) throws IOException {
        LongestWithoutRepeatChars o =new LongestWithoutRepeatChars();
       System.out.println(o.lengthOfLongestSubstring("aswnixabhj"));
    }

}
