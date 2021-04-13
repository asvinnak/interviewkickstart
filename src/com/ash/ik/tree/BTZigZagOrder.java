package com.ash.ik.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTZigZagOrder {

    public static List<List<Integer>> getLelevelOrderTraversal(BTreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<BTreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> temp;
        boolean flip = false;
        while (!queue.isEmpty()) {
            temp = new ArrayList<>();
            int qsize = queue.size();

            for (int i = 0; i < qsize; i++) {
                BTreeNode node = queue.remove();
                temp.add(node.v);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if(flip) {
                Collections.reverse(temp);
            }

            result.add(temp);
            flip = !flip;
        }

        return result;
    }

}
