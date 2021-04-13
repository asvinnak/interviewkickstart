package com.ash.ik.arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementInArray {

    public int findKthLargestElement(int[] a, int k) {

        return quickSelectHelper(a, k, 0, a.length - 1);
    }

    private int quickSelectHelper(int[] a, int k, int start, int end) {
        if (start >= end) {
            return a[k-1];
        }

        int randomIdx = new Random().nextInt((end - start) + 1) + start;

        swap(a, randomIdx, start);

        int pivot = a[start];
        int p1 = start;
        int p2 = start;

        while (p2 <= end) {
            if (a[p2] < pivot) {
                p1++;
                swap(a, p2, p1);
            }
            p2++;
        }

        swap(a, start, p1);

        // for largest element
        int position = a.length - k;

        //for smallest element
        //position = k - 1;

        if (position == p1) {
            return a[a.length - k];
        } else if (position < p1) {
            return quickSelectHelper(a, k, start, p1 - 1);
        } else {
            return quickSelectHelper(a, k, p1 + 1, end);
        }
    }

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq= new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0; i<nums.length; i++) {
            pq.add(nums[i]);
        }


        int i= 0;
        //int x = nums.length - k;
        while( i < k -1) {
            //System.out.println(pq.peek());
            pq.poll();
            i++;
        }

        return pq.poll();

    }

    public int findKthLargestSpaceOptimization(int[] nums, int k) {

        PriorityQueue<Integer> pq= new PriorityQueue<>(k, Comparator.reverseOrder());

        for(int i=0; i<nums.length; i++) {
            if(i < k || nums[i] > pq.peek()) {
                pq.offer(nums[i]);
            }
        }

        while(k>1) {
            pq.poll();
            k--;
        }


        return pq.peek();
    }

    private void swap(int[] a, int s, int t) {
        int tmp = a[s];
        a[s] = a[t];
        a[t] = tmp;
    }

    public static void main(String[] args) {
        KthLargestElementInArray o = new KthLargestElementInArray();

        int[] a = { 3, 2, 1, 5, 6, 4 };
        int k = 2;

        //System.out.println(o.findKthLargestElement(a, k));
        System.out.println(o.findKthLargest(a, k));
        System.out.println(o.findKthLargestSpaceOptimization(a, k));
    }
}
