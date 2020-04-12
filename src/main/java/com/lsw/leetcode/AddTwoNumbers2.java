package com.lsw.leetcode;

public class AddTwoNumbers2 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        node1.next = new ListNode(2);
//        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(3);
        node2.next = new ListNode(7);
//        ListNode node2 = new ListNode(5);
//        node2.next = new ListNode(6);
//        node2.next.next = new ListNode(4);
        ListNode node = addTwoNumbers(node1, node2);
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode pointer = null;
        int t = 0;
        while (l1 != null && l2 != null) {
            int total = l1.val + l2.val + t;
            if (l3 == null) {
                l3 = new ListNode(total%10);
                pointer = l3;
            } else {
                l3.next = new ListNode(total%10);
                l3 = l3.next;
            }
            t = total/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int l1Total = l1.val + t;
            l3.next = new ListNode(l1Total%10);
            l3 = l3.next;
            l1 = l1.next;
            t = l1Total/10;
        }
        while (l2 != null) {
            int l2Total = l2.val + t;
            l3.next = new ListNode(l2Total%10);
            l3 = l3.next;
            l2 = l2.next;
            t = l2Total/10;
        }
        while (t != 0) {
            l3.next = new ListNode(t%10);
            t = t/10;
            l3 = l3.next;
        }
        return pointer;
    }
}
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}
