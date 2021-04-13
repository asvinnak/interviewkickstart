package com.ash.ik.algorithm;

public class MinimizeCashFlowSplitwise {

    public void minimizeCashFlow(int[][] graph) {
        //Get the net cashflow = all credits - all debits
        int[] amount = new int[graph.length];
        for (int p = 0; p < graph.length; p++) {
            for (int r = 0; r < graph[0].length; r++) {
                amount[p] += graph[r][p] - graph[p][r];
            }
        }
        minCashflow(amount);
    }

    private void minCashflow(int[] amount) {
        int maxCredit= getMaxCashflow(amount);
        int maxDebit= getMinCashflow(amount);
        if(amount[maxCredit] == 0  && amount[maxDebit] == 0) {
            return;
        }
        int minAmount = Math.min(amount[maxCredit], -amount[maxDebit]);
        amount[maxCredit] = amount[maxCredit] - minAmount;
        amount[maxDebit] = amount[maxDebit] + minAmount;
        System.out.println("person "+ maxDebit +" has to pay "+ minAmount +" to "+ maxCredit);
        minCashflow(amount);
    }

    private int getMaxCashflow(int[] amount) {
        int maxCredit = 0;

        for (int i = 1; i < amount.length; i++) {
            if(amount[i] > amount[maxCredit]) {
                maxCredit = i;
            }
        }
        return maxCredit;
    }

    private int getMinCashflow(int[] amount) {
        int minDebit = 0;

        for (int i = 1; i < amount.length; i++) {
            if(amount[i] < minDebit) {
                minDebit = i;
            }
        }
        return minDebit;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][] { { 0, 1000, 2000 }, { 0, 0, 5000 }, { 0, 0, 0 } };

        MinimizeCashFlowSplitwise o = new MinimizeCashFlowSplitwise();
        o.minimizeCashFlow(graph);
    }
}
