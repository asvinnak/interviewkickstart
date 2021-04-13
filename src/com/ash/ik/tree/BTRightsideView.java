package com.ash.ik.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 *
 *              1
 *            2     3
 *         5            4
 *      6
 *
 *
 *      o/p:
 *
 *      1,3,4,6
 */

public class BTRightsideView {



    public static List<Integer> getRightSideViewOfBT(BTreeNode root) {

        List<Integer> result = new ArrayList<>();
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

            result.add(temp.get(temp.size() - 1));

        }

        return result;
    }

}
