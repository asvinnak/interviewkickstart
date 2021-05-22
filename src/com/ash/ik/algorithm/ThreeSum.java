package com.ash.ik.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result= new ArrayList();

        Arrays.sort(nums);
        int diff;
        int t= 0;
        int l, h;
        for(int i=0; i<nums.length-2; i++) {
            if(i == 0 || i > 0 && nums[i] != nums[i-1]) {
                diff = t - nums[i];
                l = i+1;
                h = nums.length - 1;
                while(l < h) {
                    if(diff == nums[l] + nums[h]) {
                        result.add(Arrays.asList(nums[i], nums[l], nums[h]));

                        while(
                            l < h && nums[l] == nums[l+1]) {
                            l++;
                        }

                        while( l < h && nums[h] == nums[h-1]) {
                            h--;
                        }

                        l++;
                        h--;
                    }
                    else if(nums[l] + nums[h] > diff) {
                        h--;
                    } else {
                        l++;
                    }
                }
            }
        }

        return result;
    }
}
