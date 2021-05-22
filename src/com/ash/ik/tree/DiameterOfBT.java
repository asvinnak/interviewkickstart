package com.ash.ik.tree;

//Findout longest path of diameter between nodes in tree, this may or may not pass through root

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *      1
 *     /  \
 *   2     3
 *  / \
 *4    5
 * <p>
 * /p [4,2,1,3]  or [5,2,1,3]
 * <p>
 * longest path of diameter is 3
 */
public class DiameterOfBT {

    //TC: O(N)
    //SC: O(N)

    public static int findMaxDiameterOfAnyTwoBTNodes(BTreeNode root) {

        //initialize
        int[] maxDiameter = { 0 };

        //edgecase
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        //recursive
        getSubDiameter(root, maxDiameter);

        //return max diameter
        return maxDiameter[0];
    }

    public static int getSubDiameter(BTreeNode node, int[] maxDiameter) {

        // base case (leaf)
        if (node.left == null && node.right == null) {
            return 0;
        }

        //recursive case
        int leftCnt = 0;
        int rightCnt = 0;
        int myDiameter = 0;

        if (node.left != null) {
            leftCnt = getSubDiameter(node.left, maxDiameter) + 1;
        }

        if (node.right != null) {
            rightCnt = getSubDiameter(node.right, maxDiameter) + 1;
        }

        myDiameter = leftCnt + rightCnt;

        if (myDiameter > maxDiameter[0]) {
            maxDiameter[0] = myDiameter;
        }

        return Math.max(leftCnt, rightCnt);
    }

    static int findHeightOfChildren(TreeNode root, int maxHeight) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height= 1;
        int childSize = 0;
        while(!queue.isEmpty()) {
            height= 0;
            TreeNode node = queue.poll();
            int size = node.children.size();
            List<TreeNode> childern = node.children;
            for(int i=0; i<size; i++) {
                height += 1 - size;
                queue.add(childern.get(i));
            }

            if(maxHeight < height) {
                maxHeight = height;
            }

        }

        return height;




    }
}
