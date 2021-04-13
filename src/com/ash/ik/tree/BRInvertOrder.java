package com.ash.ik.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BRInvertOrder {

    public static BTreeNode invertOrder(BTreeNode root) {

        if(root == null) {
            return null;
        }

        BTreeNode left= invertOrder(root.left);
        BTreeNode right = invertOrder(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    public static void print(BTreeNode node) {

        if (node == null) {
            return;
        }

        Queue<BTreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {

            BTreeNode n = queue.poll();
            System.out.print(n.v);

            if (n.left != null) {
                queue.add(n.left);
            }
            if (n.right != null) {
                queue.add(n.right);
            }
        }
    }

    public static void main(String[] args) {
        BTreeNode root = new BTreeNode(1);
        root.left = new BTreeNode(2);
        root.right = new BTreeNode(3);
        root.left.left = new BTreeNode(4);
        root.left.right = new BTreeNode(5);
        root.right.left = new BTreeNode(6);
        root.right.right = new BTreeNode(7);
        root.left.left.right = new BTreeNode(8);
        root.right.left.right = new BTreeNode(9);

        print(root);
        System.out.println();
        root = invertOrder(root);
        print(root);
    }
}
