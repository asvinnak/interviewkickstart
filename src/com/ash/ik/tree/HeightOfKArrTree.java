package com.ash.ik.tree;

import java.util.Vector;

/**
 * Height Of K-Ary Tree
 *
 *
 *
 * Given a k-ary tree, find the height of that tree: number of edges in the longest path from the root to any node.
 *
 * A k-ary tree is a rooted tree in which each node has no more than k children.
 *
 *
 *
 * Example
 *
 * Input is a 3-ary tree:
 *
 *              1
 *            /  |  \
 *           2   3   5
 *                    \
 *                     4
 *
 *
 * Output: 2
 *
 * The longest path from the root is 1 -> 5 -> 4. It has two edges.
 */
public class HeightOfKArrTree {

    static class VTreeNode {

        Vector<VTreeNode> children = new Vector<VTreeNode>(0);

        VTreeNode() {
            children.clear();
        }
    }

    static int find_height(VTreeNode root) {

        if (root == null) {
            return 0;
        }

        Vector<VTreeNode> children = root.children;

        int max = 0;
        for (VTreeNode node : children) {
            max = Math.max(max, find_height(node));
        }

        return max + 1;
    }
}
