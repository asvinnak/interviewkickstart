package com.ash.ik.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an integer array arr of size n, find all magic triplets in it.
 * <p>
 * Magic triplet is a group of three numbers whose sum is zero.
 * <p>
 * Note that magic triplets may or may not be made of consecutive numbers in arr.
 * <p>
 * <p>
 * <p>
 * Example One
 * <p>
 * Input: arr = [10, 3, -4, 1, -6, 9]
 * <p>
 * <p>
 * <p>
 * Output: [“10,-4,-6”, “3,-4,1”]
 * <p>
 * <p>
 * <p>
 * Example Two
 * <p>
 * Input: arr = [12, 34, -46]
 * <p>
 * <p>
 * <p>
 * Output: [“12,-46,34”]
 * <p>
 * <p>
 * <p>
 * Example Three
 * <p>
 * Input: arr = [0, 0, 0];
 * <p>
 * <p>
 * <p>
 * Output: [“0,0,0”]
 * <p>
 * <p>
 * <p>
 * Example Four
 * <p>
 * Input: arr = [-2, 2, 0 -2, 2];
 * <p>
 * <p>
 * Output: [“2,-2,0”]
 * <p>
 * <p>
 * <p>
 * Notes
 * <p>
 * Input Parameters: Function has one argument: array of integers arr.
 * <p>
 * <p>
 * <p>
 * Output: Function must return an array of strings. Each string (if any) in the array must represent a unique magic
 * triplet and strictly follow this format: “1,2,-3” (no whitespace, one comma between numbers).
 * <p>
 * Order of the strings in the array is insignificant. Order of the integers in any string is also insignificant. For
 * example, if [“1,2,-3”, “1,-1,0”] is a correct answer, then [“0,1,-1”, “1,-3,2”] is also a correct answer.
 * <p>
 * Triplets that only differ by order of numbers are considered duplicates, and duplicates must not be returned. For
 * example, if “1,2,-3” is a part of an answer, then “1,-3,2”, “-3,2,1” or any permutation of the same numbers may not
 * appear in the same answer (though any one of them may appear instead of “1,2,-3”).
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 2000 -1000 <= any element of arr <= 1000 arr may contain duplicate numbers. arr is not necessarily sorted.
 * <p>
 * <p>
 * Custom Input
 * <p>
 * Custom Input Format: First line of input contains integer n.
 * <p>
 * Next n lines each contain an element of arr.
 * <p>
 * For example, custom input for arr = [10, 3, -4, 1, -6, 9] would be:
 * <p>
 * 6
 * <p>
 * 10
 * <p>
 * 3
 * <p>
 * -4
 * <p>
 * 1
 * <p>
 * -6
 * <p>
 * 9
 * <p>
 * <p>
 * <p>
 * Custom Output Format: Output must contain as many lines as there are strings in the answer. Each line (if any) must
 * contain a string representing a unique magic triplet.
 * <p>
 * For the sample input described above, one correct output is:
 * <p>
 * 10,-4,-6
 * <p>
 * 3,-4,1
 * <p>
 * another example of a correct output for that input is:
 * <p>
 * 1,3,-4
 * <p>
 * -4,-6,10
 */
public class ThreeSum {

    private static String[] threeSum(int[] arr) {

        if (arr == null || arr.length == 0) {
            return new String[0];
        }

        Arrays.sort(arr);

        Set<String> result = new HashSet<>();

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        result.add(new StringBuilder("" + arr[i]).append(",").append("" + arr[j]).append(",")
                            .append("" + arr[k]).toString());
                    }
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }

    private static String[] threeSumGoodApproach(int[] arr) {

        if (arr == null || arr.length == 0) {
            return new String[0];
        }

        Arrays.sort(arr);

        Set<String> result = new HashSet<>();
        int l, h, sum, t;
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            l = i + 1;
            h = arr.length - 1;
            t = -arr[i];
            while (l < h) {
                sum = arr[l] + arr[h];
                if (sum == t) {
                    result.add(new StringBuilder("" + arr[i]).append(",").append("" + arr[l]).append(",")
                        .append("" + arr[h]).toString());
                    l++;
                    h--;

                    while (l <  h && arr[l] == arr[l - 1]) {
                        l++;
                    }
                    while (l < h && arr[h] == arr[h + 1]) {
                        h--;
                    }
                } else if (sum < t) {
                    l++;
                } else {
                    h--;
                }
            }
        }

        return result.toArray(new String[result.size()]);
    }

    //Approach 2

    public static List<Integer> merge_sort(List<Integer> arr) {
        int n = arr.size();
        int left = 0, right = n - 1;
        split(arr, left, right);
        return arr;
    }

    public static void split(List<Integer> arr, int l, int h) {
        // divide the array into blocks of size [1,2,4,8,..]
        for (int blocks = 1; blocks <= h - l; blocks = 2 * blocks) {
            // for blocks = 1, i = 0, 2, 4, 6, 8 and so on
            // for each block we split the array into sub arrays and merge them
            /* note that each of these subarrays will always be sorted as we are
             building the array from smaller subarrays to larger subarrays*/
            for (int i = l; i < h; i += 2 * blocks) {
                int left = i;
                int mid = Math.min(i + blocks - 1, h);
                int right = Math.min(i + 2 * blocks - 1, h);
                merge(arr, left, mid, right);
            }
        }
    }

    /*function to merge 2 sorted arrays*/
    public static void merge(List<Integer> arr, int left, int mid, int right) {
        int[] l = new int[mid - left + 1];
        //copies the integers to array l from arr
        for (int i = 0; i < mid - left + 1; i++) {
            l[i] = arr.get(left + i);
        }
        int[] r = new int[right - mid];
        //copies the integers to array r from arr
        for (int i = 0; i < right - mid; i++) {
            r[i] = arr.get(mid + i + 1);
        }
        int i = 0, j = 0, k = left;
        //merges arrays l and r back to arr
        while (i < l.length && j < r.length) {
            if (l[i] < r[j]) {
                arr.set(k, l[i]);
                i++;
            } else {
                arr.set(k, r[j]);
                j++;
            }
            k++;
        }
        //merges remaining elements of arrays l and r
        while (i < l.length) {
            arr.set(k++, l[i++]);
        }
        while (j < r.length) {
            arr.set(k++, r[j++]);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 3, -4, 1, -6, 9 };
        String[] result = threeSum(arr);
        System.out.println(Arrays.deepToString(result));
    }

    // -6, -4, 1, 3, 9, 10
}
