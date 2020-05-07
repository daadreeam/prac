package com.lsw.leetcode.linked;

import javafx.util.Pair;

public class ReverseKGroup25 {

    public static void main(String[] args) {
        ReverseKGroup25 reverseKGroup25 = new ReverseKGroup25();
        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
        ListNode listNode1 = reverseKGroup25.reverseKGroup(listNode, 2);
        while (listNode1 != null) {
            System.out.print(listNode1.val + " -> ");
            listNode1 = listNode1.next;
        }

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) {
            return head;
        }
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode pre = h;
        while(head != null){
            int count = 0;
            while(head != null && count < k){
                count++;
                head = head.next;
            }
            if(count == k){
                ListNode next = head;
                Pair<ListNode, ListNode> pair = reverse(pre.next, head);
                pre.next = pair.getKey();
                pair.getValue().next = head;

                pre = pair.getValue();
                // 此时head已经是指向下一个了
            } else {
                // do nothing
                break;
            }

        }
        return h.next;
    }

    public Pair<ListNode, ListNode> reverse(ListNode head, ListNode stop){
        ListNode end = head;
        ListNode re = new ListNode(0);
        while(head!=null && head != stop){
            ListNode tmp = re.next;
            ListNode next = head.next;
            head.next = tmp;
            re.next = head;

            head = next;
        }
        end.next = null;
        return new Pair<ListNode, ListNode>(re.next, end);
    }
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

}



