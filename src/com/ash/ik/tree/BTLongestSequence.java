package com.ash.ik.tree;

public class BTLongestSequence {

    //SC: O(N)
    //TC: O(N)
        public static int findLongestSequence(BTreeNode root) {

            int[] max= new int[1];

            dfs(root, 0, 0, max);
            return max[0];
        }

    private static void dfs(BTreeNode root, int cnt, int t, int[] max) {

            if(root == null) {
                return;
            } else if(root.v == t) {
                    cnt++;
            } else {
                cnt=1;
            }

            max[0] = Math.max(max[0], cnt);
            dfs(root.left, cnt, root.v+1, max);
            dfs(root.right, cnt, root.v+1, max);

    }
}
