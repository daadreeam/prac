package com.lsw.leetcode.linked;

/**
 * 206 反转链表
 */
public class ReverseList206 {

    static ListNode h;

    public static void main(String[] args) {

        // 1->2->4, 1->3->4
        ListNode l1Head = new ListNode(0);
        ListNode l1 = l1Head;
        l1Head.next = new ListNode(1);
        l1Head.next.next = new ListNode(2);
        l1Head.next.next.next = new ListNode(3);
        l1Head.next.next.next.next = new ListNode(4);
        l1Head.next.next.next.next.next = new ListNode(5);

        ListNode p = reverseList(l1.next);

        printList(p);
    }

    /**
     * 头插法版本
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = new ListNode(0);
        while (head != null) {
            // 解这种链表的题目一般都要借助到两三个辅助指针!
            ListNode next = p.next;
            ListNode hNext = head.next;

            p.next = head;
            head.next = next;

            head=hNext;
        }

        return p.next;



    }

    /**
     * 递归版本
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reverse = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reverse;
    }

    private static ListNode reverse(ListNode l1, ListNode l2){
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }


        if (l2.next == null) {
            l2.next = l1;
            l1.next = null;
            h = l1;
            return l1;
        } else {
            return reverse(l2.next, l2.next.next);
        }

    }

    private static void printList(ListNode listNode){
        while (listNode != null) {
            System.out.println(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
