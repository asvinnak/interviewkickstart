package com.ash.ik.string;

import java.io.IOException;
import java.util.Arrays;

public class StringReverse {

    private String reverse(String s) {

        if (s == null) {
            return null;
        }

        int len = s.length();
        char[] ch = new char[s.length()];
        for (int i = 0, j = len - 1; i < len / 2; i++, j--) {
            ch[i] = s.charAt(j);
            ch[j] = s.charAt(i);
        }

        return String.valueOf(ch);
    }

    private int[] numberReverse(int[] num) {
        int l = num.length;
        for (int i = 0, j = l - 1; i < l / 2; i++, j--) {
            num[i] = num[i] - num[j]; // 1 - 3 = -2
            num[j] = num[j] + num[i]; // 3 + (-2) = 1
            num[i] = num[j] - num[i]; // 1 - (-2) = 3
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        StringReverse o = new StringReverse();
        System.out.println(o.reverse("Aswani"));

        int[] a = new int[] { 1, 2, 3 };
        int[] result = o.numberReverse(a);

        System.out.println(Arrays.toString(result));
    }
}
