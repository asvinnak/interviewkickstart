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

    public void rotate1(int[] nums, int k) {

        if(nums == null || nums.length < 2){
            return;
        }

        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

    }

    private void reverse(int[] nums, int i, int j){
        int tmp = 0;
        while(i < j){
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {

        int[] nums = new int[] {1,2,3,4,5,6,7};

        RotateArray o = new RotateArray();
        o.rotate(nums, 3);


    }

}
