package com.ash.ik.arrays;

// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

// For example,
// Given [100, 4, 200, 1, 3, 2],
// The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

// Your algorithm should run in O(n) complexity.

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {

        int count= 0 ;

        int left=0, right=0, sum=0;
        Map<Integer, Integer>  map= new HashMap();

        for(int n : nums) {

            if(!map.containsKey(n)){

                left = map.containsKey(n-1) ? map.get(n-1) : 0;
                right = map.containsKey(n+1) ? map.get(n+1) : 0;

                sum = left + right + 1;
                count = Math.max(count, sum);
                map.put(n, sum);

                map.put(n-left, sum);
                map.put(n+right, sum);

            }
            else {
                continue;
            }

        }


        return count;
    }

    public static void main(String[] args) {

        LongestConsecutive o = new LongestConsecutive();
        int[] a= {100, 4, 200, 1, 3, 2};
        System.out.println(o.longestConsecutive(a));
    }

}
