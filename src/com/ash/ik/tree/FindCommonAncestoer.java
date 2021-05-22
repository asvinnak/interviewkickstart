package com.ash.ik.tree;

import java.util.List;

/**
 * Example
 *
 * Input: a=8, b=9.
 *
 *
 *
 * ﻿
 *
 * Output: LCA(8, 9)=5
 *
 *
 *                  1
 *           2              3
 *       4      5       6       7
 *          8      9
 *
 *
 * There are three shared parents of 8 and 9 in this tree: 5, 2, 1. Of those three, the farthest from the root is 5.
 */
public class FindCommonAncestoer {

    static int lca(BTreeNode head, BTreeNode a, BTreeNode b)
    {
        BTreeNode n = helper(head, a, b);
        return n.v;
    }

    static BTreeNode helper(BTreeNode head, BTreeNode a, BTreeNode b) {

        if(head == null) {
            return null;
        }

        if(head.v == a.v || head.v == b.v) {
            return head;
        }
        BTreeNode left = helper(head.left, a, b);
        BTreeNode right= helper(head.right, a, b);

        if(left != null && right != null) {
            return head;
        }

        return left != null ? left : right;
    }



    public static void main(String[] args) {
        BTreeNode root = new BTreeNode(1);
        root.left = new BTreeNode(2);
        root.right = new BTreeNode(3);
        root.left.left = new BTreeNode(4);
        root.left.right = new BTreeNode(5);
        root.right.left = new BTreeNode(6);
        root.right.right = new BTreeNode(7);
        root.left.right.left = new BTreeNode(8);
        root.left.right.right = new BTreeNode(9);

        BTreeNode a = new BTreeNode(8);

        BTreeNode b = new BTreeNode(9);

       System.out.println(FindCommonAncestoer.lca(root, a, b));


    }
    
}
