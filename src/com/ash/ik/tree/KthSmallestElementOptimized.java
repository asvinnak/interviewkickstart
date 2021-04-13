package com.ash.ik.tree;

public class KthSmallestElementOptimized {

    static int kth_smallest_element(BTreeNode root, int k) {

        if (root == null) {
            return 0;
        }
        // Initialize Array with K elements only
        int[] a = new int[k];
        IntWrapper iw = new IntWrapper(0);
        findKElementInArray(root, a, k, iw);
        return a[k - 1];
    }

    private static void findKElementInArray(BTreeNode root, int[] a, int k, IntWrapper iw) {
        if (root == null) {
            return;
        }
        findKElementInArray(root.left, a, k, iw);
        // once you travelled k elements in Tree return immediate.
        if (iw.count == k) {
            return;
        }
        a[iw.count] = root.v;
        iw.count += 1;
        findKElementInArray(root.right, a, k, iw);
    }

    static class IntWrapper {

        int count;

        public IntWrapper(int v) {
            count = v;
        }
    }

    static int kth_smallest_elementSpaceOptimized(BTreeNode root, int k) {

        if (root == null) {
            return 0;
        }
        int[] a = new int[1];
        IntWrapper iw = new IntWrapper(0);
        findKElementInArrayEvenBetterSpaceOptimized(root, k, a, iw);
        return a[0];
    }

    private static void findKElementInArrayEvenBetterSpaceOptimized(BTreeNode root, int k, int[] a, IntWrapper iw) {
        if (root == null) {
            return;
        }
        findKElementInArrayEvenBetterSpaceOptimized(root.left, k, a, iw);
        // once you travelled k elements in Tree return immediate.
        if (iw.count == k) {
            a[0] = root.v;
            return;
        }

        iw.count += 1;
        findKElementInArrayEvenBetterSpaceOptimized(root.right, k, a, iw);
    }

    public static void main(String[] args) {
        BTreeNode root = new BTreeNode(3);
        root.left = new BTreeNode(2);
        root.left.left = new BTreeNode(1);
        root.right = new BTreeNode(4);
        root.right.left = new BTreeNode(1);

        System.out.println(kth_smallest_element(root, 4));
        System.out.println(kth_smallest_elementSpaceOptimized(root, 4));
    }
}
