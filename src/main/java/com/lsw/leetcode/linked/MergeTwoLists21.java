package com.lsw.leetcode.linked;

/**
 * 合并两个有序链表 21
 */
public class MergeTwoLists21 {
    public static void main(String[] args) {
        // 1->2->4, 1->3->4
        ListNode l1Head = new ListNode(0);
        ListNode l1 = l1Head;
        l1Head.next = new ListNode(1);
        l1Head.next.next = new ListNode(2);
        l1Head.next.next.next = new ListNode(4);

        ListNode l2Head = new ListNode(0);
        ListNode l2 = l2Head;
        l2Head.next = new ListNode(1);
        l2Head.next.next = new ListNode(3);
        l2Head.next.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(l1.next, l2.next);
        while (listNode != null) {
            System.out.println(listNode.val + " -> ");
            listNode = listNode.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode first = new ListNode(0);
        ListNode head = first;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
                head = head.next;
            } else if (l1.val > l2.val) {
                head.next = l2;
                l2 = l2.next;
                head = head.next;
            } else {
                head.next = l1;
                l1 = l1.next;
                head.next.next = l2;
                l2 = l2.next;
                head = head.next.next;
            }
        }
        while (l1!=null) {
            head.next = l1;
            head = head.next;
            l1 = l1.next;
        }
        while (l2!=null) {
            head.next = l2;
            head = head.next;
            l2 = l2.next;
        }
        return first.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
