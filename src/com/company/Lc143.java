package com.company;

/*
 * 143. Reorder List
 *
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 */

import com.company.data.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class Lc143 implements Answer{
    @Override
    public int getIndex() {
        return 143;
    }

    public void reorderList(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        ListNode prev = new ListNode(0);
        ListNode cur = prev;
        while(head != null) {
            deque.add(head);
            head = head.next;
        }

        while(!deque.isEmpty()) {
            cur.next = deque.pollFirst();
            cur = cur.next;
            if(!deque.isEmpty()) {
                cur.next = deque.pollLast();
                cur = cur.next;
            }
        }
        cur.next = null;
    }
}
