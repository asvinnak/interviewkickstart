package com.ash.ik.tree;

public class KthSmallestElement {

    static int kth_smallest_element(BTreeNode root, int k) {

        if(root == null) {
            return 0;
        }
        int n = size(root);
        int[] arr = new int[n];
        IntWrapper iw = new IntWrapper(0);
        getArrayFromBST(root, arr, iw);

        return arr[k-1];
    }


    static class IntWrapper {
        int v;

        IntWrapper(int val) {
            v = val;
        }
    }

    static void getArrayFromBST(BTreeNode root, int[] arr, IntWrapper iw) {

        if(root == null) {
            return;
        }

        getArrayFromBST(root.left, arr, iw);

        arr[iw.v] = root.v;
        iw.v += 1;

        getArrayFromBST(root.right, arr, iw);
    }



    static int size(BTreeNode root) {

        if(root == null) {
            return 0;
        }


        return 1 + size(root.left) + size(root.right);

    }

    public static void main(String[] args) {
        BTreeNode root= new BTreeNode(3);
        root.left= new BTreeNode(2);
        root.left.left = new BTreeNode(1);
        root.right = new BTreeNode(4);
        root.right.left = new BTreeNode(1);

        System.out.println(kth_smallest_element(root, 4));
    }
}
