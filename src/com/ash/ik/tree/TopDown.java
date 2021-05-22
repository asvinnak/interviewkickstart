package com.ash.ik.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TopDown {

    static BTreeNode flipUpsideDown(BTreeNode root){
        if(root == null || root.left == null){
            //Initially if the input comes as root == null or input dont have children, return itself.
            //subsequent cases, where this works is at the leaf node.left is null.
            return root;
        }

        BTreeNode oldLeft = root.left;
        BTreeNode oldRight = root.right;

        BTreeNode flipped = flipUpsideDown(oldLeft);

        oldLeft.left = oldRight;
        oldLeft.right = root;

        root.left = null;
        root.right = null;

        return flipped;
    }

    public static void printLevelOrder(BTreeNode root)
    {
        // Base Case
        if(root==null)
            return ;

        // Create an empty queue for level order traversal
        Queue<BTreeNode> q=new LinkedList<>();
        // Enqueue Root and initialize height
        q.add(root);
        while(true)
        {
            // nodeCount (queue size) indicates number
            // of nodes at current lelvel.
            int nodeCount = q.size();
            if (nodeCount == 0)
                break;

            // Dequeue all nodes of current level and
            // Enqueue all nodes of next level
            while (nodeCount > 0)
            {
                BTreeNode node = q.remove();
                System.out.print(node.v+" ");
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                nodeCount--;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BTreeNode root = new BTreeNode(1);
        root.left = new BTreeNode(2);
        root.right = new BTreeNode(3);
        root.left.left = new BTreeNode(4);
        root.left.right = new BTreeNode(5);
        root.left.left.left = new BTreeNode(6);
        root.left.left.right = new BTreeNode(7);

        printLevelOrder(root);
        BTreeNode flipNode = TopDown.flipUpsideDown(root);
        printLevelOrder(flipNode);
    }
    
}
