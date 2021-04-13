package com.ash.ik.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal {

    //Time Complexity : O(n)
    //Space Complexity : O(n)
    public static List<List<Integer>> getLelevelOrderTraversal(BTreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<BTreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> temp;

        while (!queue.isEmpty()) {
            temp = new ArrayList<>();
            int qsize = queue.size();

            for (int i = 0; i < qsize; i++) {
                BTreeNode node = queue.remove();
                temp.add(node.v);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result.add(temp);
        }

        return result;
    }

    public static void main(String[] args) {
        BTreeNode root = new BTreeNode(3);
        root.left = new BTreeNode(9);
        root.right = new BTreeNode(20);
        root.left.left = new BTreeNode(11);
        root.left.right = new BTreeNode(14);
        root.right.left = new BTreeNode(15);
        root.right.right = new BTreeNode(7);
        List<List<Integer>> levels = BTLevelOrderTraversal.getLelevelOrderTraversal(root);

        levels.forEach(System.out::println);
    }
}
