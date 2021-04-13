package com.ash.ik.tree;

import java.util.ArrayList;
import java.util.List;

public class FindCommonNodesFromTwoBST { 
    
    
    public List<Integer> findCommonNodesFromTwoBST(BTreeNode root1, BTreeNode root2) {
        if(root1 ==  null || root2 == null) {
            return new ArrayList<>();
        }
        List<Integer> slate= new ArrayList<>();
        helper(root1, root2, slate);
        return slate;
    }

    private void helper(BTreeNode root1, BTreeNode root2, List<Integer> slate) {
        if(root1 == null || root2 == null || root1.v != root2.v) {
            return;
        }
        helper(root1.left, root2.left, slate);
        if(root1.v == root2.v) {
            slate.add(root1.v);
        }
        helper(root1.right, root2.right, slate);
    }

    /**
     *root1
     *
     *              500
     *      400              600
     *   350   450        550    650
     *
     *
     *
     *root2
     *                 500
     *         400              600
     *     350     450      560     650
     * 100
     *
     *o/p : 350, 400, 450, 500, 600, 650
     */
    public static void main(String[] args) {
        BTreeNode root1 = new BTreeNode(500);
        root1.left = new BTreeNode(400);
        root1.right = new BTreeNode(600);
        root1.left.left = new BTreeNode(350);
        root1.left.right = new BTreeNode(450);
        root1.right.left = new BTreeNode(550);
        root1.right.right = new BTreeNode(650);

        BTreeNode root2 = new BTreeNode(500);
        root2.left = new BTreeNode(400);
        root2.right = new BTreeNode(600);
        root2.left.left = new BTreeNode(350);
        root2.left.right = new BTreeNode(450);
        root2.right.left = new BTreeNode(560);
        root2.right.right = new BTreeNode(650);

        root2.left.left.left = new BTreeNode(100);


        FindCommonNodesFromTwoBST o = new FindCommonNodesFromTwoBST();
        o.findCommonNodesFromTwoBST(root1, root2).forEach(System.out::println);
    }
}
