package com.ash.ik.tree;

import java.util.List;

/**
 *            10
 *       12         15
 *   25     30   36
 *
 *
 *   head 25<->12<->30<->10<->36<->15 tail
 */
public class ConvertBSTToDoubleLL {

    static BTreeNode BTtoLL(BTreeNode root) {
        if (root == null) {
            return null;
        }

        BTreeNode dummy = new BTreeNode();
        BTreeNode tail = dfs(root, dummy);
        BTreeNode head = dummy.right;
        head.left = tail;
        tail.right = head;

        return head;
    }

    static BTreeNode dfs(BTreeNode current, BTreeNode prev) {

        if (current.left != null) {
            prev = dfs(current.left, prev);
        }

        current.left = prev;
        prev.right = current;
        prev = current;

        if (current.right != null) {
            prev = dfs(current.right, prev);
        }

        return prev;
    }

    public static void main(String[] args) {
        BTreeNode root = new BTreeNode(4);
        root.left = new BTreeNode(2);
        root.right = new BTreeNode(5);
        root.left.left = new BTreeNode(1);
        root.left.right = new BTreeNode(3);

        BTreeNode treeNode = ConvertBSTToDoubleLL.BTtoLL(root);


    }
}
