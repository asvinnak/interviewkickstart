package com.ash.ik.tree;

public class IsSubtree {


    public boolean isSubtree(BTreeNode s, BTreeNode t) {
        String tree1 = preorder(s, true);
        String tree2 = preorder(t, true);
        return tree1.indexOf(tree2) >= 0;
    }
    public String preorder(BTreeNode t, boolean left) {
        if (t == null) {
            if (left)
                return "lnull";
            else
                return "rnull";
        }
        return "#"+t.v + " " +preorder(t.left, true)+" " +preorder(t.right, false);
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        IsSubtree tree = new IsSubtree();
        BTreeNode T = new BTreeNode('a');
        T.left = new BTreeNode('b');
        T.right = new BTreeNode('d');
        T.left.left = new BTreeNode('c');
        T.right.right = new BTreeNode('e');

        BTreeNode S = new BTreeNode('a');
        S.left = new BTreeNode('b');
        S.right = new BTreeNode('d');
        S.left.left = new BTreeNode('c');

        BTreeNode t1 = new BTreeNode('z');
        t1.left = new BTreeNode('x');
        t1.right = new BTreeNode('e');
        t1.left.left = new BTreeNode('a');
        t1.left.right = new BTreeNode('b');
        t1.right.right = new BTreeNode('k');
        t1.left.left.left = new BTreeNode('c');

        BTreeNode s1 = new BTreeNode('x');
        s1.left = new BTreeNode('a');
        s1.right = new BTreeNode('b');
        s1.left.left = new BTreeNode('c');

        if (tree.isSubtree(T, S)) {
            System.out.println("Yes, S is a subtree of T");
        } else {
            System.out.println("No, S is not a subtree of T");
        }

        if (tree.isSubtree(t1, s1)) {
            System.out.println("Yes, S1 is a subtree of T1");
        } else {
            System.out.println("No, S1 is not a subtree of T1");
        }
    }
}
