package com.ash.ik.dynamicprogramming;

public class CutIronRodForMaxProfit {

        public static int getMaxProfit(int[] cuts, int[] prices) {

            int[] dp= new int[cuts.length+1];

            dp[0] = 0;
            dp[1] = 1;

            for(int i=2; i<cuts.length; i++) {
                int result= -1;
                for(int cut=0; cut<i; i++) {
                    result = Math.max(result, dp[cut] + dp[i-cut]);
                }
                dp[i] = result;
            }

            return dp[cuts.length];

        }

        //Recursive

        static int maxProfit(int len, int[] prices, int[] memoize) {

            if(len == 0) {
                return 0;
            }

            if(memoize[len] != -1) {
                return memoize[len];
            }

            int result= -1;

            for(int cut=0; cut<len; cut++) {

                result = Math.max(result, prices[cut] + maxProfit(len-cut, prices, memoize));

            }

            memoize[len] = result;

            return result;

        }


}
