package com.ash.ik.backtrack;

public class BacktrackWithDiceProblem {

    public static void driver(int numOfDices) {
        helper(numOfDices, 5, 0, new StringBuilder());
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

            for(int i=0; i<6; i++) {
                soFar.append(i);
                helper1(n-1, tsum, runingSum+i, soFar);
                soFar.deleteCharAt(soFar.length() - 1);
            }
        }
    }
}
