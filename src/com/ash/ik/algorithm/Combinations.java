package com.ash.ik.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 4, k = 2 Output: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ] Example 2:
 * <p>
 * Input: n = 1, k = 1 Output: [[1]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 20 1 <= k <= n
 */
public class Combinations {

    //Time Complexity: O(N * C(n,k))
    //space complexity: O(K * C(n,k))
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rslt = new ArrayList<List<Integer>>();
        dfs(new Stack<Integer>(), 1, n, k, rslt);
        return rslt;
    }

    // backtracking

    /**
     * In this approach, we are using the power of DFS to recursively iterate through the range to generate all possible
     * combinations. The iteration steps of the DFS approach is similar to the second approach we discussed above. Here
     * we iterate until we get a set consisting of K elements and store that subset in our resultant vector and then we
     * backtrack and remove the previous element inserted in our temporary vector and consider further elements from the
     * range which are not considered. This way all combinations are generated.
     */
    private void dfs(Stack<Integer> path, int index, int n, int k, List<List<Integer>> rslt) {
        // ending case
        if (k == 0) {
            List<Integer> list = new ArrayList<Integer>(path);
            rslt.add(list);
            return;
        }
        // recursion case
        for (int i = index; i <= n; i++) {
            path.push(i);
            dfs(path, i + 1, n, k - 1, rslt);
            path.pop();
        }
    }

    //Inclusion and Exclusion
    public List<List<Integer>> combineInEx(int n, int k) {
        List<List<Integer>> rslt = new ArrayList<>();
        List<Integer> slate = new ArrayList<>();
        inclusionAndExclusion(n, k, 0, 0, slate, rslt);
        return rslt;
    }

    private void inclusionAndExclusion(int n, int k, int nidx, int kidx, List<Integer> slate,
        List<List<Integer>> rslt) {
        if (k == kidx) {
            rslt.add(new ArrayList(slate));
            return;
        }

        if (nidx >= n) {
            return;
        }
        slate.add(nidx + 1);
        inclusionAndExclusion(n, k, nidx + 1, kidx + 1, slate, rslt);
        slate.remove(slate.size() - 1);
        inclusionAndExclusion(n, k, nidx + 1, kidx, slate, rslt);
    }

    private int combinationsCount(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        } else {
            return combinationsCount(n - 1, k - 1) + combinationsCount(n - 1, k);
        }
    }

    private int combinationsSimpleRecursive(int n, int k) {
        if (k == 0 || k == n) {

        } else {
            return combinationsCount(n - 1, k - 1) + combinationsCount(n - 1, k);
        }

        return 0;
    }

    public static void main(String[] args) {
        Combinations o = new Combinations();
        List<List<Integer>> list = o.combine(4, 2);
        list.forEach(System.out::println);

        System.out.println(o.combinationsCount(4, 2));

        List<List<Integer>> list1 = o.combineInEx(4, 2);

        list1.forEach(System.out::println);
    }
}
