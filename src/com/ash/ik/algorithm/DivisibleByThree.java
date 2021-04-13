package com.ash.ik.algorithm;

/**
 * 23
 * <p>
 * 03, 21, 24, 27,30, 33, 36
 */
public class DivisibleByThree {

    static int cnt= 0;
    static int divisible(String num) {
        int n = num.length();

        // add up all the
        // digits of num
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            sum += (int) (num.charAt(i));
        }

        // if num is already is
        // divisible by 3 then
        // no digits are to be
        // removed
        if (sum % 3 == 0) {
            cnt++;
        }




        // traverse through the number
        // and find out if any number
        // on removal makes the sum
        // divisible by 3
        for (int i = 0; i < n; i++) {
            if (sum % 3 == (num.charAt(i) - '0') % 3) {
                return 1;
            }
        }

        // if there are two numbers
        // then it is not possible
        // to remove two digits.
        if (n == 2) {
            return -1;
        }

        // Otherwise we can always
        // make a number multiple
        // of 2 by removing 2 digits.
        return 2;
    }

    public static void main(String[] args) {

        String num = "1234";
        System.out.println(divisible(num));
    }
}
