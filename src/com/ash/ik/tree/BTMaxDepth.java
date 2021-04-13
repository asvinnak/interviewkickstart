package com.ash.ik.tree;

public class BTMaxDepth {

    static int maxDepth = 0;

    static int maxDepth(BTreeNode root, int depth) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            maxDepth = Math.max(maxDepth, depth + 1);
        }

        maxDepth(root.left, depth + 1);
        maxDepth(root.right, depth + 1);

        return maxDepth;
    }
    public static void main(String[] args) {
        BTreeNode root = new BTreeNode(1);
        root.left = new BTreeNode(2);
        root.right = new BTreeNode(3);
        root.left.left = new BTreeNode(4);
        root.left.right = new BTreeNode(5);
        root.right.left = new BTreeNode(6);

        System.out.println(maxDepth(root, 0));
    }
}
