package com.lsw.leetcode;

/**
 * 61. 旋转链表
 */
public class RotateRight {
    public static void main(String[] args) {
//        1->2->3->4->5->NULL
//        ListNode node = new ListNode(1);
//        ListNode start = node;
//        node.next = new ListNode(2);
//        node = node.next;
//        node.next = new ListNode(3);
//        node = node.next;
//        node.next = new ListNode(4);
//        node = node.next;
//        node.next = new ListNode(5);
//        node = node.next;
//        node.next = null;
        ListNode node = new ListNode(0);
        ListNode start = node;
        node.next = new ListNode(1);
        node = node.next;
        node.next = new ListNode(2);
        node = node.next;
        node.next = null;
//        while (start != null) {
//            System.out.println(start.val + " -> ");
//            start = start.next;
//        }
        ListNode re = rotateRight(start, 4);
        while (re != null) {
            System.out.println(re.val + " -> ");
            re = re.next;
        }
    }
    public static ListNode rotateRight(ListNode head, int k) {
        int count = 0;
        ListNode lHead = new ListNode(-1);
        ListNode lp = lHead;
        ListNode rp = head;

        while (rp != null){
            count++;
            lp.next = new ListNode(rp.val);
            lp = lp.next;
            if (rp.next == null) {
                rp.next = lHead.next;
                break;
            }
            rp = rp.next;
        }
        lp.next = head;
        if (count == 0) {
            return head;
        }

        lHead = lHead.next;
//        if (count < k){
            // 循环
            for (int i = 0; i < count - (k%count); i++) {
                lHead = lHead.next;
            }
            //lhead 为 正确头
            lp = lHead;
            for (int i = 0; i < count - 1; i++) {
                lp = lp.next;
            }
            lp.next = null;
        return lHead;
    }
}
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}
