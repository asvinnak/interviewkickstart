package com.ash.ik.tree;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * // Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
 * //      3
 * //     /\
 * //    /  \
 * //    9   8
 * //   /\  /\
 * //  /  \/  \
 * //  4  01   7
 * //     /\
 * //    /  \
 * //    5   2
 * // return its vertical order traversal as:
 * // [
 * //   [4],
 * //   [9,5],
 * //   [3,0,1],
 * //   [8,2],
 * //
 */

public class BTVerticalLevelOrder {

    public List<List<Integer>>  verticalOrderTraversal(BTreeNode n) {

        List<List<Integer>> result = new ArrayList();
        Queue<BTreeNode> queue= new LinkedList<>();
        Queue<Integer> cols= new LinkedList<>();

        Map<Integer, List<Integer>> map = new HashMap();
        int col= 0;
        queue.add(n);
        cols.add(col);
        BTreeNode BTreeNode;
        int min=0, max=0;
        while(!queue.isEmpty()) {
            BTreeNode = queue.poll();
            col= cols.poll();
            if(map.get(col) == null) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(BTreeNode.v);
            if(BTreeNode.left != null) {
                queue.add(BTreeNode.left);
                cols.add(col-1);
                min= Math.min(min, col-1);

            }
            if(BTreeNode.right != null) {
                queue.add(BTreeNode.right);
                cols.add(col+1);
                max= Math.max(max, col+1);
            }
        }

        for(int i=min; i<=max; i++) {
            result.add(map.get(i));
        }

        return result;
    }

    public static void main(String[] args) {
        BTreeNode root = new BTreeNode(3);
        root.left = new BTreeNode(9);
        root.right = new BTreeNode(8);
        root.left.left = new BTreeNode(4);
        root.left.right = new BTreeNode(0);
        root.right.left = new BTreeNode(1);
        root.right.right = new BTreeNode(7);

        root.left.right.left = new BTreeNode(5);
        root.left.right.right = new BTreeNode(2);

        BTVerticalLevelOrder o = new BTVerticalLevelOrder();
        o.verticalOrderTraversal(root).forEach(System.out::println);
    }
}
