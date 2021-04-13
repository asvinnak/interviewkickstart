package com.ash.ik.tree;

//Convert inout sort array into BinaryTree
//Find the mid point from sorted array and create root node out of it and repeat same for the left part of array &
// right part of array
public class SortArrayToBST {

    public static void ConvertSortArrayToBST(int[] arr) {

        makeTree(arr, 0, arr.length - 1);
    }

    private static BTreeNode makeTree(int[] arr, int s, int e) {

        if (s > e) {
            return null;
        }

        //If we hit leaf root return root with no children
        if (s == e) {
            return new BTreeNode(arr[s]);
        }

        int rootIdx = s + (e - s) / 2;

        int v = arr[rootIdx];

        //Create root root with value
        BTreeNode root = new BTreeNode(v);

        root.left = makeTree(arr, s, rootIdx - 1);
        root.right = makeTree(arr, rootIdx + 1, e);

        return root;
    }
}
