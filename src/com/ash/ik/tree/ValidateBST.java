package com.ash.ik.tree;

import org.omg.PortableInterceptor.INACTIVE;

public class ValidateBST {

    static class Node {

        int v;

        Node left;

        Node right;

        Node(int v) {
            this.v = v;
            left = null;
            right = null;
        }
    }

    static boolean isBST(Node root, int min, int max) {
        if(root == null) {
            return true;
        }

        if(root.v < min || root.v > max) {
            return false;
        }

        return isBST(root.left, min, root.v) && isBST(root.right, root.v, max);
    }


    /* Driver program to test above functions */
    public static void main(String args[]) {

        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            System.out.println("IS BST");
        } else {
            System.out.println("Not a BST");
        }
    }
}
