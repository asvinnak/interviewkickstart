package com.ash.ik.tree;

public class BTreeNode {

    int v;

    BTreeNode left;

    BTreeNode right;

    BTreeNode(){}

    BTreeNode(int x) {
        v = x;
        left = null;
        right = null;
    }
}
