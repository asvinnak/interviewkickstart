package com.ash.ik.backtrack;

//Time Complexity: O(2^n) -- For every index there can be two options ‘{‘ or ‘}’.
// So it can be said that the upperbound of time complexity is O(2^n) or it has exponential time complexity.

// Space Complexity: O(n) -- The space complexity can be reduced to O(n) if global variable or static variable is
// used to store the output string.
public class PossibleNParenthesess {


    public  static void driver(int n) {
        helper(n, n, new StringBuilder());
    }

    private static void helper(int remOpen, int remClose, StringBuilder soFar) {

        if(remOpen > remClose) return;

        if(remOpen ==0 && remClose == 0) {
            System.out.println(soFar.toString());
        } else {
            if(remOpen > 0) {
                soFar.append("(");
                helper(remOpen - 1, remClose, soFar);
                soFar.deleteCharAt(soFar.length() - 1);
            }

            if(remClose > 0) {
                soFar.append(")");
                helper(remOpen, remClose-1, soFar);
                soFar.deleteCharAt(soFar.length() - 1);
            }
        }

    }

    public static void main(String[] args) {
        driver(4);
    }

}

