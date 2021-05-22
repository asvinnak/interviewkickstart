package com.ash.ik.arrays;

import java.util.Arrays;

public class DetermineMinMovesToSortArray {

    public static int minMovesToSort(int[] arr) {

        int[] expected= Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);

        int count= arr.length;
        int j=0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == expected[j]) {
                j++;
                count --;
            }

        }

        return count;
    }

    public static int minMovesToSort2(int[] arr) {

        int n= arr.length;
        int[] minarray= new int[arr.length];
        minarray[n-1] = arr[n-1];
       for(int i=n-2; i>=0; i--) {
           minarray[i] = Math.min(arr[i], arr[i+1]);
       }

        int count= 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != minarray[i]) {
                count++;
            }
        }

        return count;
    }



    public static void main(String[] args) {
        int[] a= new int[] {1,3,2};
        System.out.println(minMovesToSort(a));
        System.out.println(minMovesToSort2(a));

        int[] b= new int[] {5,1,3,2};
        System.out.println(minMovesToSort(b));
        System.out.println(minMovesToSort2(b));
    }


}
