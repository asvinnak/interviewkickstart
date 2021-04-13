package com.ash.ik.tree;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Input:
 * pre-order[3,9,20,15,7]
 * Inorder [9,3,15,20,7]
 *
 * O/p:
 *
 *        3
 *       / \
 *      9   20
 *         / \
 *        15  7
 *
 * The basic idea is here:
 * Say we have 2 arrays, PRE and IN.
 * Preorder traversing implies that PRE[0] is the root node.
 * Then we can find this PRE[0] in IN, say it's IN[5].
 * Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the
 * right side.
 * Recursively doing this on subarrays, we can build a tree out of it :)
 */
public class CreateBTFromPreOrderAndInorder {


    public static BTreeNode convertIntoBT(int[] preorder, int[] inorder) {

        Map<Integer, Integer> map= new HashMap();
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return makeTree(preorder, inorder, map, 0, 0,inorder.length-1);
    }

    private static BTreeNode makeTree(int[] preorder, int[] inorder, Map<Integer, Integer> map, int prestart, int inStart,
     int inEnd   ) {

        if(prestart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        int rootValue = preorder[prestart];
        int rootIdx = map.get(rootValue);

        BTreeNode root= new BTreeNode(rootValue);


        root.left = makeTree(preorder, inorder, map, prestart+1, inStart, rootIdx - 1);
        root.right = makeTree(preorder, inorder, map, prestart + rootIdx -inStart+1, rootIdx+1, inEnd);

        return root;
    }

    public static void main(String[] args) {

        int[] preorder= {3,9,20,15,7};
        int[] inorder= {9,3,15,20,7};

        BTreeNode root = convertIntoBT(preorder, inorder);

       System.out.println(root);
    }



}

