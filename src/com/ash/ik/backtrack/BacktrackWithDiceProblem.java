package com.ash.ik.backtrack;

/**
 * Time Complexity: O(m * n * x) where m is number of faces, n is number of dice and x is given sum.
 *
 *
 */

public class BacktrackWithDiceProblem {

    public static void driver(int numOfDices) {
        helper(numOfDices, 5, 0, new StringBuilder());
        Counter counter = new Counter();
        helper(numOfDices, 5, 0, counter);
        System.out.println(counter.cnt);
    }

    private static void helper(int numOfDices, int targetSum, int runningSum, StringBuilder sb) {

        if(runningSum > targetSum) {
            return;
        }

        if(runningSum + numOfDices * 1 > targetSum) return; // 1is min dice value :  guarantee to exceed
        if(runningSum + numOfDices * 6 < targetSum) return; // 6is max dice value :  never reach targetsum

        if (numOfDices == 0) {
            if (runningSum == targetSum) {
                System.out.println(sb.toString());
            }
        } else {
            for (int i = 1; i <= 6; i++) {
                sb.append(i);
                //inclusive
                helper(numOfDices-1, targetSum, runningSum + i, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        driver(2);
    }

    static void helper1(int n, int tsum, int runingSum, StringBuilder soFar) {

        if(runingSum > tsum) {
            return;
        }

        if(runingSum + n * 1 > tsum ) return;

        if(runingSum + n * 6 < tsum) return;

        if(runingSum == tsum) {
            System.out.println(soFar.toString());
        } else {

            for(int i=1; i<=6; i++) {
                soFar.append(i);
                helper1(n-1, tsum, runingSum+i, soFar);
                soFar.deleteCharAt(soFar.length() - 1);
            }
        }

    }

    static void helper(int n, int tsum, int runingSum, Counter counter) {

        if(runingSum > tsum) {
            return;
        }

        if(runingSum + n * 1 > tsum ) return;

        if(runingSum + n * 6 < tsum) return;

        if(runingSum == tsum) {
            counter.cnt +=1;
        } else {

            for(int i=1; i<=6; i++) {
                helper(n-1, tsum, runingSum+i, counter);
            }
        }

    }


    static class Counter {
        int cnt;

        Counter() {
            cnt= 0;
        }
    }


}
