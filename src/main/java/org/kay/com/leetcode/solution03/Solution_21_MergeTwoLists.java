package org.kay.com.leetcode.solution03;

public class Solution_21_MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode startNode = new ListNode(-1);
        ListNode curNode = startNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curNode.next = l1;
                curNode = curNode.next;
                l1 = l1.next;
            }
            else {
                curNode.next = l2;
                curNode = curNode.next;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            curNode.next = l1;
        }
        else {
            curNode.next = l2;
        }
        return startNode.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
