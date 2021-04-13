package com.ash.ik.sorting;

import java.util.Arrays;

/**
 * Merge One Sorted Array Into Another Merge One Sorted Array Into Another
 * <p>
 * <p>
 * <p>
 * Given two arrays:
 * <p>
 * 1) arr1 of size n, which contains n positive integers sorted in the ascending order.
 * <p>
 * 2) arr2 of size (2*n) (twice the size of first), which contains n positive integers sorted in the ascending order in
 * its first half. Second half of this array arr2 is empty. (Empty elements are marked by 0).
 * <p>
 * Write a function that takes these two arrays, and merges the first one into second one, resulting in an increasingly
 * sorted array of (2*n) positive integers.
 * <p>
 * <p>
 * <p>
 * Example
 * <p>
 * Input:
 * <p>
 * n = 3
 * <p>
 * arr1 = [1 3 5]
 * <p>
 * arr2 = [2 4 6 0 0 0]
 * <p>
 * <p>
 * <p>
 * Output: arr2 = [1 2 3 4 5 6]
 * <p>
 * <p>
 * <p>
 * Notes
 * <p>
 * Input Parameters: There are two arguments. First one is an integer array denoting arr1 and second one is also an
 * integer array denoting arr2.
 * <p>
 * <p>
 * <p>
 * Output: You don't have to return anything. You just need to modify the given array arr2.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^5 1 <= arr1[i] <= 2 * 10^9 1 <= arr2[i] <= 2 * 10^9 (for the first half) arr2[i] = 0 (for the second
 * half) You can use only constant extra space. 0 denotes an empty space.
 * <p>
 * <p>
 * Custom Input
 * <p>
 * Input Format: The first line of input should contain an integer n, denoting size of input array arr1. In next n
 * lines, ith line should contain an integer arr1[i], denoting value at index i of arr1.
 * <p>
 * In next line, there should be an integer (2*n), denoting size of input array arr2. In next (2*n) lines, ith line
 * should contain an integer arr2[i], denoting value at index i of arr2.
 * <p>
 * If n = 3, arr1 = [1, 3, 5] and arr2 = [2, 4, 6, 0, 0, 0], then input should be:
 * <p>
 * 3
 * <p>
 * 1
 * <p>
 * 3
 * <p>
 * 5
 * <p>
 * 6
 * <p>
 * 2
 * <p>
 * 4
 * <p>
 * 6
 * <p>
 * 0
 * <p>
 * 0
 * <p>
 * 0
 * <p>
 * <p>
 * <p>
 * Output Format: There will (2*n) lines of output, where ith line contains an integer arr2[i], denoting value at index
 * i of arr2. For input n = 3, arr1 = [1, 3, 5] and arr2 = [2, 4, 6, 0, 0, 0], output will be:
 * <p>
 * 1
 * <p>
 * 2
 * <p>
 * 3
 * <p>
 * 4
 * <p>
 * 5
 * <p>
 * 6
 */
public class MergeOneSortedArrayIntoAnother {

    /*
     * Complete the merger_first_into_second function below.
     */
    static void merger_first_into_second(int[] arr1, int[] arr2) {

        int p1 = arr1.length - 1;
        int p2 = arr2.length - arr1.length - 1;
        int n = arr2.length - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (arr1[p1] > arr2[p2]) {
                arr2[n] = arr1[p1];
                p1--;
            } else {
                arr2[n] = arr2[p2];
                p2--;
            }
            n--;
        }

        while (p1 >= 0) {
            arr2[n] = arr1[p1];
            p1--;
            n--;
        }

        while (p1 != p2 && p2 >= 0) {
            arr2[n] = arr2[p2];
            p2--;
            n--;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 4, 5, 6 };
        int[] arr2 = { 1, 2, 3, 0, 0, 0 };

        int[] arr3 = { 1, 10, 11, 12, 13 };
        int[] arr4 = { 2, 3, 4, 13, 15, 0, 0, 0, 0, 0 };

        merger_first_into_second(arr3, arr4);

        System.out.println(Arrays.toString(arr4));
    }

    /**
     *
     * We are allowed to use only constant extra space. We can start merging from the end.
     *
     * We could first create empty space at the beginning instead of the end by copying arr2[i] to arr2[n + i] for i
     * from 0 to n - 1, and then start merging from the beginning, but this would add one more loop unnecessarily.
     *
     *
     *
     * Time Complexity:
     *
     * O(n) as we are traversing through the arr1 and arr2 only once.
     *
     *
     *
     * Auxiliary Space Used:
     *
     * O(1).
     *
     *
     *
     * Space Complexity:
     *
     * O(n) due to input size.
     *
     * void merger_first_into_second(vector<int>& arr1, vector<int>& arr2) {
     *     int n = arr1.size();
     * 	// Start merging from the end.
     * 	int last1 = n - 1;
     * 	int last2 = n - 1;
     * 	int last = n + n - 1;
     * 	// At least one element reamining.
     * 	while (last >= 0)
     *        {
     * 		// If no elements remaining in arr1.
     * 		if (last1 < 0)
     *        {
     *             // Think about the case when arr1 = [4, 5, 6] arr2 = [1, 2, 3, 0, 0, 0].
     *             // Once last1 = -1, arr2 will be [1, 2, 3, 4, 5, 6]. So, we can stop here.
     *             break;
     *        }
     * 		// If no elements remaining in arr2.
     * 		else if (last2 < 0)
     *        {
     * 			arr2[last--] = arr1[last1--];
     *        }
     * 		// Priority to larger element, as we are merging from the end.
     * 		else if (arr1[last1] <= arr2[last2])
     *        {
     * 			arr2[last--] = arr2[last2--];
     *        }
     * 		else
     *        {
     * 			arr2[last--] = arr1[last1--];
     *        }
     *    }
     */

}
