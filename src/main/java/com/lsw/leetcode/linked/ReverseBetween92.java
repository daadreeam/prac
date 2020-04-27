package com.lsw.leetcode.linked;

public class ReverseBetween92 {


    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n || head.next == null) {
            return head;
        }

        ListNode start = null;
        ListNode end = null;
        ListNode inStart = null;
        ListNode inEnd = null;
        ListNode p = head;

        ListNode pre = null;

        int count = 1;

        while(p != null) {
            if(count == m-1) {
                start = p;
            }
            if(count == n+1) {
                end = p;
            }

            if(count >= m && count <= n ) { // 边界
                if(count == m) {
                    inStart = p;
                }
                if(count == n) {
                    inEnd = p;
                }

                ListNode next = p.next;
                p.next = pre;
                pre = p;
                p = next;
            } else{
                p = p.next;
            }

            count ++;
        }

        if(start == null ) {
            head = inEnd;
        } else {
            // 循环结束
            start.next = inEnd;
        }

        inStart.next = end;

        // p2==null
        return head;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
