package com.ash.ik.arrays;

import java.util.Stack;

/**
 *      0   1   2   3
 * 0  [ 0,  0,  1,  0 ]
 * <p>
 * 1 [ 0,  0,  1,  0 ]
 * <p>
 * 2 [ 0,  0,  0,  0 ]
 * <p>
 * 3 [ 0,  0,  1,  0 ]
 */
public class FindCelebrity {

    // Person with 2 is celebrity
    static int MATRIX[][] = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };

    public int findCelebrity(int n) {

        int candidate = 0;

        for (int i = 0; i < n; i++) {

            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) {
                return -1;
            }
        }

        return candidate;
    }

    public boolean knows(int a, int b) {

        if (MATRIX[a][b] == 1) {
            return true;
        }

        return false;
    }

    //using 2 pointers, A & B. A starts from starting point and B from end.
    public int findCelebrity2(int n) {
        //Initialize two pointers

        int a = 0; //start
        int b = n - 1; //end

        while (a < b) {
            if (knows(a, b)) {
                a++;
            } else {
                b--;
            }
        }


        // Check if a is knows by anybody or oters doesn't know a

        for (int i = 0; i < n; i++) {
            if (i != a && (knows(a, i) || !knows(i, a))) {
                return -1;
            }
        }

        return a;
    }

    //using stack

    public int findCelebrityUsingStack(int n) {
        Stack<Integer> stack = new Stack<>();
        int c;
        //push everything into stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            // get top2 and check A knows B
            int a = stack.pop();
            int b = stack.pop();
            if (knows(a, b)) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }

        int celebrity = stack.pop();
        for (int i = 0; i < n; i++) {
            if (i != celebrity && (knows(celebrity, i) || !knows(i, celebrity))) {
                return -1;
            }
        }

        return celebrity;
    }

    public static void main(String[] args) {
        FindCelebrity o = new FindCelebrity();
        System.out.println(o.findCelebrity(4));

        System.out.println(o.findCelebrity2(4));

        System.out.println(o.findCelebrityUsingStack(4));
    }
}
