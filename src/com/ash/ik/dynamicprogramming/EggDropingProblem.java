package com.ash.ik.dynamicprogramming;

/**
 *
 * Find minimum tries to find on which floor egg breaks
 *    6 floors and 2 eggs
 *
 *    when 1 egg and N floors = N tries
 *    When N eggs and 1 floor = 1 try
 *
 *      1   2   3   4   5   6
 *   1  1   2   3   4   5   6
 *
 *   2  1   2   2   3   3   3
 *
 *
 *   Formula:  i = eggs  j= floors
 *   if(i > j) {
 *       //get from previous row and col value
 *       dp[i][j] = dp[i-1][j]
 *   }
 *   else {
 *       currenteggdropedfloor + min ( max ([remaining floors to try when egg breaks ar current floor][remaining
 *       eggss], [remaining j-K floors to try when agg doesn't break ar current floor][eggs (none of them break]
 *       ))
 *       1 + min(max(dp[k-1][i-1), dp[j-k][i]);
 *   }
 *
 *
 *
 */
public class EggDropingProblem {



    public int findMinPossibleTriesOnEggBreakFromFloors(int floors, int eggs) {

        int[][] dp = new int[eggs+1][floors+1];

        //when 1 egg and N floors = N tries
        for(int i=0; i<=floors; i++) {
            dp[1][i] = i;
        }

        int c= 0;
        for(int e=2; e<=eggs; e++) {
            for (int f = 1; f <= floors; f++) {
                dp[e][f] = Integer.MAX_VALUE;
                for(int k=1; k<=f; k++) {
                    // If eggs are morethan floors. set from previous row and col
                    if (e > f) {
                        dp[e][f] = dp[e - 1][f];
                    } else {
                        dp[e][f]= Math.min(1 + Math.max(dp[e-1][k-1], dp[e][f-k]), dp[e][f]);
                    }
                }
            }
        }
        return dp[eggs][floors];
    }


    public int superEggDropRecursiveMemo(int eggs, int floors) {
        int[][] dp = new int[eggs+1][floors+1];

        //when 1 egg and N floors = N tries
        for(int i=0; i<=floors; i++) {
            dp[1][i] = i;
        }

        return solve(eggs, floors, dp);
        //return solveWithBinarySearch(eggs, floors, dp);

    }

    int solve(int eggs,int floors,int[][] dp)
    {
        if(dp[eggs][floors]!=-1)
            return dp[eggs][floors];
        else if(eggs==0 || floors==0)
            return dp[eggs][floors]=0;
        else if(floors==1)
            return dp[eggs][floors]=1;
        else if(eggs==1)
            return dp[eggs][floors]=floors;
        else
        {
            int minn=Integer.MAX_VALUE;
            for(int f=1;f<=floors;f++)              //Linear search
            {
                int x=Math.max(solve(eggs,floors-f,dp),solve(eggs-1,f-1,dp));
                minn=Math.min(minn,x+1);
            }
            dp[eggs][floors]=minn;
        }
        return dp[eggs][floors];
    }

    int solveWithBinarySearch(int eggs,int floors, int[][] dp)
    {
        if(dp[eggs][floors]!=-1)
            return dp[eggs][floors];
        else if(eggs==0 || floors==0)
            return dp[eggs][floors]=0;
        else if(floors==1)
            return dp[eggs][floors]=1;
        else if(eggs==1)
            return dp[eggs][floors]=floors;
        else
        {
            int l=1,h=floors;
            int minn=Integer.MAX_VALUE;
            while(l<=h)                         // Using Binary Search to find the threshold floor
            {
                int mid=l+(h-l)/2;
                int a=solveWithBinarySearch(eggs-1,mid-1,dp);
                int b=solveWithBinarySearch(eggs,floors-mid,dp);
                int x=Math.max(a,b);
                minn=Math.min(minn,x+1);
                if(a>b)
                    h=mid-1;
                else
                    l=mid+1;
            }
            dp[eggs][floors]=minn;
        }
        return dp[eggs][floors];
    }

}
