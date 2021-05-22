package com.ash.ik.tree;

////Count number of unique-subtrees which has same value

/**
 *
 *
 *
 *          5
 *         / \
 *        1   5
 *       / \   \
 *      5   5   5
 *
 *
 *
 *  o/p : 4
 *
 *  by default all leaf nodes are unique because there are no childs + parent value is equal to all childs is also
 *  unique it self in that subtree
 *
 *
 *
 */
public class CountUniqueSubTrees {
    static class Node
    {
        int data;
        Node left, right;

        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    class Count
    {
        int count = 0;
    }

    //TC: O(N)
    //SC: O(N)

    Node root;
    Count ct = new Count();

    // This function increments count by number of single
    // valued subtrees under root. It returns true if subtree
    // under root is Singly, else false.
    boolean countSingleRec(Node node, Count c)
    {
        // Return false to indicate NULL
        if (node == null)
            return true;

        // Recursively count in left and right subtrees also
        boolean left = countSingleRec(node.left, c);
        boolean right = countSingleRec(node.right, c);

        // If any of the subtrees is not singly, then this
        // cannot be singly.
        if (left == false || right == false)
            return false;

        // If left subtree is singly and non-empty, but data
        // doesn't match
        if (node.left != null && node.data != node.left.data)
            return false;

        // Same for right subtree
        if (node.right != null && node.data != node.right.data)
            return false;

        // If none of the above conditions is true, then
        // tree rooted under root is single valued, increment
        // count and return true.
        c.count++;
        return true;
    }

    // This function mainly calls countSingleRec()
    // after initializing count as 0
    int countSingle()
    {
        return countSingle(root);
    }

    int countSingle(Node node)
    {
        // Recursive function to count
        countSingleRec(node, ct);
        return ct.count;
    }
    public static void main(String args[])
    {
           /* Let us construct the below tree
                5
              /   \
            4      5
          /  \      \
         4    4      5 */
        CountUniqueSubTrees tree = new CountUniqueSubTrees();
        Node t = new Node(5);
        t.left = new Node(4);
        t.right = new Node(5);
        t.left.left = new Node(4);
        t.left.right = new Node(4);
        t.right.right = new Node(5);

        System.out.println("The count of single valued sub trees is : "
            + tree.countSingle());


    }


}
