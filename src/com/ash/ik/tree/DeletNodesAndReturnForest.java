package com.ash.ik.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ash.ik.tree.KthSmallestElementOptimized.IntWrapper;

/**
 * Given the root of a binary tree, each node in the tree has a distinct value.
 *
 * After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
 *
 * Return the roots of the trees in the remaining forest. You may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 * Example 2:
 *
 * Input: root = [1,2,4,null,3], to_delete = [3]
 * Output: [[1,2,4]]
 *
 */
public class DeletNodesAndReturnForest {

    public static List<BTreeNode> deleteNodes(BTreeNode root, int[] to_delete) {
        List<BTreeNode> result= new ArrayList<>();
        if(root == null) {
            return result;
        }

        Set<Integer> set= new HashSet();
        for(int i: to_delete) {
            set.add(i);
        }
        delete(root, set, result);
        if(!set.contains(root.v)) {
            result.add(root);
        }
        return result;
    }

    private static BTreeNode delete(BTreeNode root, Set<Integer> set, List<BTreeNode> result) {

        if(root==null) {
            return null;
        }

        root.left = delete(root.left, set, result);
        root.right = delete(root.right, set, result);
        //condition
        if(set.contains(root.v)) {
            if(root.left != null)
                result.add(root.left);
            if(root.right != null)
                result.add(root.right);
            return null;
        }

        return root;

    }
}
