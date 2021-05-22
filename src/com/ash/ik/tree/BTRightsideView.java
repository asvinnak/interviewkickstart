package com.ash.ik.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 *
 *              1
 *            2     3
 *         5            4
 *      6
 *
 *
 *      o/p:
 *
 *      1,3,4,6
 */

public class BTRightsideView {



    public static List<Integer> getRightSideViewOfBT(BTreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<BTreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> temp;
        boolean flip = false;
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

            result.add(temp.get(temp.size() - 1));

        }

        return result;
    }


    public List<Integer> rightSideView(BTreeNode root) {
        ArrayList list = new ArrayList();
        rightSideView(root, 0, list);

        return list;
    }

    public void rightSideView(BTreeNode root, int level, ArrayList list) {
        if(root == null) return;

        if(list.size() == level) {
            System.out.print(root.v);
            list.add(root.v);
        }

        rightSideView(root.right, level + 1, list);
        rightSideView(root.left, level + 1, list);
    }

    public static void main(String[] args) {

        BTreeNode tree = new BTreeNode(1);
        tree.left = new BTreeNode(2);
        tree.right = new BTreeNode(3);
        tree.left.left = new BTreeNode(4);
        tree.left.right = new BTreeNode(5);
        tree.right.left = new BTreeNode(6);
        tree.right.right = new BTreeNode(7);
        tree.right.left.right = new BTreeNode(8);

        BTRightsideView o =new BTRightsideView();
        o.rightSideView(tree);
    }

}
