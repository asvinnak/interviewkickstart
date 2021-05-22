package com.ash.ik.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * We have a set of items: the i-th item has value values[i] and label labels[i].
 * <p>
 * Then, we choose a subset S of these items, such that:
 * <p>
 * |S| <= num_wanted For every label L, the number of items in S with label L is <= use_limit. Return the largest
 * possible sum of the subset S.
 * <p>
 * Input: values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1 Output: 9 Explanation: The subset
 * chosen is the first, third, and fifth item.
 * <p>
 * Input: values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit = 2 Output: 12 Explanation: The subset
 * chosen is the first, second, and third item.
 */
//RC: O(N logN) iterating n items and removing all items
//SC: O(N) sotring N items in priority heap
public class LargestValuesFromLables {

    static class Item {

        int value;

        int lable;

        public Item(int v, int l) {
            value = v;
            lable = l;
        }
    }

    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {

        List<Item> items = new ArrayList();
        for (int i = 0; i < values.length; i++) {
            items.add(new Item(values[i], labels[i]));
        }

        PriorityQueue<Item> pq = new PriorityQueue<>((Item p1, Item p2) -> p2.value - p1.value); //O(N)
        pq.addAll(items);

        int largest = 0;
        Map<Integer, Integer> labelUsedCnt = new HashMap<>();
        while (!pq.isEmpty() && num_wanted > 0) { //O N LogN

            Item item = pq.poll();
            if (!labelUsedCnt.containsKey(item.lable) || labelUsedCnt.get(item.lable) < use_limit) {
                largest += item.value;
                labelUsedCnt.put(item.lable, labelUsedCnt.getOrDefault(item.lable, 0) + 1);
                num_wanted--;
            }
        }

        return largest;
    }

    public static void main(String[] args) {
        int[] v = { 5, 4, 3, 2, 1 };
        int[] l = { 1, 3, 3, 3, 2 };
        int num = 3;
        int limit= 2;
        LargestValuesFromLables o = new LargestValuesFromLables();
        System.out.println(o.largestValsFromLabels(v, l, num, limit));
    }
}
