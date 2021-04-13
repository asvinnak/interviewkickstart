package com.ash.ik.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Generate All Possible Expressions That Evaluate To The Given Target Value
 * <p>
 * <p>
 * <p>
 * Given a string s that consists of digits (“0”..”9”) and target, a non-negative integer, find all expressions that can
 * be built from string s that evaluate to the target.
 * <p>
 * When building expressions, you have to insert one of the following operators between each pair of consecutive
 * characters in s: “join” or “*” or “+”. For example, by inserting different operators between the two characters of
 * string “12” we can get either 12 (1 joined with 2) or 2 (1*2) or 3 (1+2).
 * <p>
 * Other operators such as “-” or “÷” are NOT supported.
 * <p>
 * Expressions that evaluate to the target but only utilize a part of s do not count: entire s has to be consumed.
 * <p>
 * Precedence of the operators is conventional: “join” has the highest precedence, “*” – medium and “+” has the lowest
 * precedence. For example, 1+2*34=(1+(2*(34)))=1+68=69.
 * <p>
 * You have to return ALL expressions that can be built from string s and evaluate to the target.
 * <p>
 * <p>
 * <p>
 * Example One
 * <p>
 * Input:
 * <p>
 * s="222", target=24.
 * <p>
 * <p>
 * <p>
 * Output:
 * <p>
 * ["22+2", "2+22"] and ["2+22", "22+2"] are both correct outputs.
 * <p>
 * 22+2=24: we inserted the “join” operator between the first two characters and the “+” operator between the last two
 * characters of s. 2+22=24: we inserted the “+” operator between the first two characters and the “join” operator
 * between the last two characters of s.
 * <p>
 * <p>
 * Example Two
 * <p>
 * Input: s="1234", target=11.
 * <p>
 * <p>
 * <p>
 * Output: ["1+2*3+4"]
 * <p>
 * <p>
 * <p>
 * Example Three
 * <p>
 * Input:
 * <p>
 * s="99", target=1.
 * <p>
 * <p>
 * <p>
 * Output:
 * <p>
 * []
 * <p>
 * <p>
 * <p>
 * Notes
 * <p>
 * Input Format: Function has two arguments: s and target.
 */

public class PossibleExpressionsOfStr {

    static String[] generate_all_expressions(String s, long t) {

        List<String> exprs = new ArrayList<>();
        helper(s, t, 0, 0, 0, new String(), exprs);
        return exprs.toArray(new String[exprs.size()]);
    }

    static void helper(String s, long t, int pos, int sum, int prev, String expr, List<String> exprs) {

        //base
        if (sum + prev  == t) {
            exprs.add(expr);
            return;
        }

        if (pos == s.length()) {
            if (sum + prev == t) {
                exprs.add(expr);
            }
            return;
        }

        int curr_val = s.charAt(pos) - '0';

        if (pos == 0) {
            helper(s, t, pos + 1, sum + prev, curr_val, expr + curr_val, exprs);
        } else {

            helper(s, t, pos + 1, sum + prev, curr_val, expr + "+" + curr_val, exprs);

            helper(s, t, pos + 1, sum + prev, -curr_val, expr + "-" + curr_val, exprs);

            helper(s, t, pos + 1, sum, prev * curr_val, expr + "*" + curr_val, exprs);
        }
    }


    ////////////////////////////////


    static void check(double sum, double previous, String remainingDigits, double target, String expr) {
        if (remainingDigits.length() == 0) {
            if (sum + previous == target) {
                System.out.println(expr + " = " + target);
            }
        } else {
            for (int i = 1; i <= remainingDigits.length(); i++) {
                double current = Double.parseDouble(remainingDigits.substring(0, i));
                String remaining = remainingDigits.substring(i);
                check(sum + previous, current, remaining, target, expr + " + " + current);
                check(sum, previous * current, remaining, target, expr + " * " + current);
                //check(sum, previous / current, remaining, target, expr + " / " + current);
                //check(sum + previous, -current, remaining, target, expr + " - " + current);
            }
        }
    }

    static void generate_expressions(String digits, double target) {
        for (int i = 1; i <= digits.length(); i++) {
            String current = digits.substring(0, i);
            check(0, Double.parseDouble(current), digits.substring(i), target, current);
        }
    }

    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(generate_all_expressions("1234", 11)));
        System.out.println(Arrays.deepToString(generate_all_expressions("222", 24)));
        generate_expressions("222", 24);


    }

    // static String[] generate_all_expressions1(String s, long t) {
    //
    //     List<String> exprs = new ArrayList<>();
    //
    //     for(int i=1; i<= s.length(); i++) {
    //         long curr = Long.parseLong(s.substring(0, i));
    //         helper(t, 0, curr, s.substring(i), ""+curr, exprs);
    //     }
    //     return exprs.toArray(new String[exprs.size()]);
    // }
    //
    // static void helper(long t, long sum, long prev, String remaining, String expr, List<String> exprs) {
    //
    //     if(remaining.length() == 0) {
    //         if(sum+prev == t) {
    //             exprs.add(expr);
    //         }
    //     }
    //     else {
    //         for(int i=1; i<= remaining.length(); i++) {
    //             long curr = Long.parseLong(remaining.substring(0, i));
    //             remaining = remaining.substring(i);
    //             helper(t, sum + prev, curr, remaining, expr + "+" + curr, exprs);
    //             helper(t, sum, prev * curr, remaining, expr + "+" + curr, exprs);
    //
    //
    //         }
    //     }
    //
    //
    // }
}
