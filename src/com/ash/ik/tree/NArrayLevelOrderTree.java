package com.ash.ik.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NArrayLevelOrderTree {

    public static List<List<Integer>> getNArrayLelevelOrderTraversal(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> temp;

        while (!queue.isEmpty()) {
            temp = new ArrayList<>();
            int qsize = queue.size();

            for (int i = 0; i < qsize; i++) {
                TreeNode node = queue.remove();
                temp.add(node.v);

                if(node.children != null) {
                    queue.addAll(node.children);
                }
            }

            result.add(temp);
        }

        return result;
    }
}
