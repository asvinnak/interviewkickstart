package com.ash.ik.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class HasPathSum {

    //TC: O(n)
    //SC: O(n)
    public static boolean hasPathSum(BTreeNode root, int target) {

        if (root == null) {
            return false;
        }

        target = target - root.v;

        if (root.left == null || root.right == null) {
            if (target == 0) {
                return true;
            }
        }

            boolean flag = false;

        if (root.left != null) {
            flag = hasPathSum(root.left, target);
        }
        if (!flag && root.right != null) {
            flag = hasPathSum(root.right, target);
        }

        return flag;
    }

    //TC: O(n log(n))
    //SC: O(n log(n))
    public static List<List<Integer>> getSumPaths(BTreeNode root, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        helper(root, target, new Stack<Integer>(), result);

        return result;
    }

    public static void helper(BTreeNode root, int target, Stack<Integer> slate, List<List<Integer>> result) {

        target = target - root.v;
        slate.push(root.v);

        if(root.left == null && root.right == null) {
            if(target == 0) {
                result.add(new ArrayList<>(slate));
            }
        }

        if(root.left != null) {
            helper(root, target, slate, result);
        }

        if(root.right != null) {
            helper(root, target, slate, result);
        }

        slate.pop();

    }

    public static void main(String args[])
    {
        int sum = 21;

        /* Constructed binary tree is
              10
             /  \
           8     2
          / \   /
         3   5 2
        */

        BTreeNode tree = new BTreeNode(10);
        tree.left = new BTreeNode(8);
        tree.right = new BTreeNode(2);
        tree.left.left = new BTreeNode(3);
        tree.left.right = new BTreeNode(5);
        tree.right.left = new BTreeNode(2);

        if (hasPathSum(tree, sum))
            System.out.println(
                "There is a root to leaf path with sum "
                    + sum);
        else
            System.out.println(
                "There is no root to leaf path with sum "
                    + sum);
    }

}
