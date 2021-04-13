package com.ash.ik.tree;

import java.util.Queue;
import java.util.Stack;

/**
 *
 *              1
 *
 *         2           3
 *
 *     4        5
 *
 *
 *
 *
 *
 * (a) Inorder (Left, Root, Right) : 4 2 5 1 3
 * (b) Preorder (Root, Left, Right) : 1 2 4 5 3
 * (c) Postorder (Left, Right, Root) : 4 5 2 3 1
 */

public class BSTTraversal {

    static class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Stack<TreeNode> stack= new Stack<>();

     BSTTraversal(TreeNode root) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    boolean hasNext() { return stack.isEmpty() ? false : true; }

    int next() {

        TreeNode node = stack.pop();

        TreeNode nodeToAdd = node.right;

        while(nodeToAdd != null) {
            stack.push(nodeToAdd);
            nodeToAdd = nodeToAdd.left;
        }
        return node.val;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        BSTTraversal o = new BSTTraversal(root);
        while(o.hasNext()) {
            System.out.println(o.next() + " ");
        }
    }
}
