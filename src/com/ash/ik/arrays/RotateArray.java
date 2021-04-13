package com.ash.ik.arrays;

import java.util.Arrays;

public class RotateArray {

    public void rotate(int[] nums, int k) {

        for(int i=0; i<k; i++) {
            int temp = nums[nums.length - 1];
            for(int j= nums.length - 1; j>0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }

        System.out.println(Arrays.toString(nums));
    }

    /**
     *
     *
     * void rotate(vector<int>& nums, int k) {
     * 	    int n = nums.size();
     * 	    k = k % n;
     * 	    reverse(nums, 0, n - k - 1);
     * 	    reverse(nums, n - k, n - 1);
     * 	    reverse(nums, 0, n - 1);
     *     }
     *     void reverse(vector<int>& nums, int a, int b) {
     *         int temp;
     *         for(int i = a; i < (b + a + 1) / 2; i++) {
     * 	        temp = nums[i];
     * 	        nums[i] = nums[a + b - i];
     * 	        nums[a + b - i] = temp;
     *         }
     *     }
     *
     * @param args
     */

    public static void main(String[] args) {

        int[] nums = new int[] {1,2,3,4,5,6,7};

        RotateArray o = new RotateArray();
        o.rotate(nums, 3);


    }

}
