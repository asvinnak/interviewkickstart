package com.ash.ik.arrays;

public class ReverseLL {



    public ListNode reverseRecursive(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode prev = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }

    public ListNode reverLLIterative(ListNode head) {

        ListNode prev = null;
        ListNode nextNode = null;
        while(head.next != null) {
            nextNode = head.next;
            head.next = prev;
            prev= head;
            head = nextNode;
        }

        return prev;

    }




    public static void main(String[] args) {

        ReverseLL o= new ReverseLL();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        o.reverseRecursive(root);
    }


}


