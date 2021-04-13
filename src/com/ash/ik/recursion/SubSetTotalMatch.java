package com.ash.ik.recursion;

public class SubSetTotalMatch {

    static boolean check_if_sum_possible(long[] arr, long k) {

        if (arr == null || arr.length == 0 || (arr.length == 1 && arr[0] < k)) {
            return false;
        }

        return helper(arr, k, 0, 0, 0);
    }

    static boolean helper(long[] arr, long k, int idx, long sum, int cnt) {

        if (cnt == 0 && idx == arr.length && sum == 0) {
            return false;
        }

        if (arr.length == idx) { // If you enable if condition it check sum at the nth level
            if (sum == k) { // If we want to find match at any level and return disable if condition above
                return true;
            }
            return false;
        }

        //include

        boolean include = helper(arr, k, idx + 1, sum + arr[idx], cnt + 1);

        //exclude
        boolean exclude = false;
        if (!include) { // If we already found match in include left level no need to traverse to right path.
            exclude = helper(arr, k, idx + 1, sum,  cnt);
        }

        return include || exclude;
    }

    public static void main(String[] args) {
        long[] arr = new long[] { 4, -3, -3, -3, -3, -12 };
        long[] arr1 = new long[] { 2, 8, -11, 5, 18 };

        long[] arr2 = new long[] { 8, 9, 10 };
        System.out.println(check_if_sum_possible(arr, -12));
        System.out.println(check_if_sum_possible(arr1, 10));
        System.out.println(check_if_sum_possible(arr2, 0));
        long[] arr3 = new long[] { 5, 6, 3, 2, 9, 11};
        System.out.println(check_if_sum_possible(arr3, 10));

    }
}
