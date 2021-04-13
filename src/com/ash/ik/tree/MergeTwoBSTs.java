package com.ash.ik.tree;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Merge Two BSTs
 * <p>
 * <p>
 * <p>
 * Merge two Binary Search Trees (each may contain duplicates) into one height balanced BST. Number of nodes in the
 * resulting tree must be equal to the sum of the numbers of nodes of the two given trees.
 * <p>
 * <p>
 * <p>
 * If a value is present in both given trees (n1 and n2 times) the resulting tree must include it n1 + n2 times.
 * <p>
 * <p>
 * <p>
 * Example One
 * <p>
 * Input:
 * <p>
 * and
 * <p>
 * <p>
 * <p>
 * Output:
 */
public class MergeTwoBSTs {

    public static BTreeNode mergeTwoBSTs(BTreeNode root1, BTreeNode root2) {
        // Write your code here.

        int l1 = findSize(root1);
        int l2 = findSize(root1);

        int[] a1 = new int[l1];
        int[] a2 = new int[l2];
        final AtomicInteger count = new AtomicInteger(0);
        converBSTToArray(root1, a1, count);

        final AtomicInteger count1 = new AtomicInteger(0);
        converBSTToArray(root2, a2, count1);

        int[] r = merge(a1, a2);

        return constructBST(r, 0, r.length - 1);
    }

    private static BTreeNode constructBST(int[] r, int s, int e) {

        if (s > e) {
            return null;
        }

        int mid = s + (e - s) / 2;
        BTreeNode node = new BTreeNode(r[mid]);
        node.left = constructBST(r, s, mid - 1);
        node.right = constructBST(r, mid + 1, e);

        return node;
    }

    private static int findSize(BTreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + findSize(root.left) + findSize((root.right));
    }

    private static int[] merge(int[] a1, int[] a2) {
        int l1 = 0;
        int l2 = 0;

        int[] t = new int[a1.length + a2.length];
        int k = 0;

        while (l1 < a1.length && l2 < a2.length) {

            if (a1[l1] <= a2[l2]) {
                t[k] = a1[l1];
                l1++;
            } else {
                t[k] = a2[l2];
                l2++;
            }
            k++;
        }

        while (l1 < a1.length) {
            t[k] = a1[l1];
            l1++;
            k++;
        }

        while (l2 < a2.length) {
            t[k] = a2[l2];
            l2++;
            k++;
        }

        return t;
    }

    private static void converBSTToArray(BTreeNode root, int[] list, AtomicInteger cnt) {

        if (root == null) {
            return;
        }

        if (root.left != null) {
            converBSTToArray(root.left, list, cnt);
        }

        int idx = cnt.getAndIncrement();
        list[idx] = root.v;

        if (root.right != null) {
            converBSTToArray(root.right, list, cnt);
        }
    }

    public static void main(String[] args) {
        BTreeNode root1 = new BTreeNode(2);
        root1.left = new BTreeNode(1);
        root1.right = new BTreeNode(3);

        BTreeNode root2 = new BTreeNode(7);
        root2.left = new BTreeNode(6);
        root2.right = new BTreeNode(8);

        BTreeNode result = mergeTwoBSTs(root1, root2);

        System.out.println(result);
    }


}
