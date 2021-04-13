package com.ash.ik.tree;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPathsOfTree {




    /*
        Complete the function below
        Input: root of the input tree
        Output: A list of integer lists denoting the node values of the paths of the tree
    */
    static List<List<Integer>> allPathsOfABinaryTree(BTreeNode root) {

        List<List<Integer>> result= new ArrayList<>();
        if(root == null) {
            return result;
        }
        helper(root, new ArrayList<Integer>(), result);
        return result;
    }

    static void helper(BTreeNode root, List<Integer> slate, List<List<Integer>> result) {

        slate.add(root.v);
        if(root.left == null && root.right == null) {
            result.add(new ArrayList(slate));
            slate.remove(slate.size() - 1);
            return;
        }

        if(root.left != null) {
            helper(root.left, slate, result);
        }

        if(root.right != null) {
            helper(root.right, slate, result);
        }

        slate.remove(slate.size() - 1);

    }

    public static void main(String[] args) {
        BTreeNode root = new BTreeNode(1);
        root.left = new BTreeNode(2);
        root.right = new BTreeNode(3);
        root.left.left = new BTreeNode(4);
        root.left.right = new BTreeNode(5);
        root.right.left = new BTreeNode(6);
        root.right.right = new BTreeNode(7);
        List<List<Integer>> levels = PrintAllPathsOfTree.allPathsOfABinaryTree(root);

        levels.forEach(System.out::println);
    }
}
