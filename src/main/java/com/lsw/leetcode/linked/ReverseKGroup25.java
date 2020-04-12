package com.lsw.leetcode.linked;

public class ReverseKGroup25 {

    public static void main(String[] args) {

    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        // 1->2->4, 1->3->4
        ListNode l1Head = new ListNode(0);
        ListNode l1 = l1Head;
        l1Head.next = new ListNode(1);
        l1Head.next.next = new ListNode(2);
        l1Head.next.next.next = new ListNode(4);

        return null;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}



