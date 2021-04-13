package com.ash.ik.tree;

public class TopDown {

    static BTreeNode flipUpsideDown(BTreeNode root){
        if(root == null || root.left == null){
            //Initially if the input comes as root == null or input dont have children, return itself.
            //subsequent cases, where this works is at the leaf node.left is null.
            return root;
        }

        BTreeNode oldLeft = root.left;
        BTreeNode oldRight = root.right;

        BTreeNode flipped = flipUpsideDown(oldLeft);

        oldLeft.left = oldRight;
        oldLeft.right = root;

        root.left = null;
        root.right = null;

        return flipped;
    }

    public static void main(String[] args) {
        BTreeNode root = new BTreeNode(1);
        root.left = new BTreeNode(2);
        root.right = new BTreeNode(3);
        root.left.left = new BTreeNode(4);
        root.left.right = new BTreeNode(5);
        root.left.left.left = new BTreeNode(6);
        root.left.left.right = new BTreeNode(7);

        BTreeNode flipNode = TopDown.flipUpsideDown(root);
    }
    
}
