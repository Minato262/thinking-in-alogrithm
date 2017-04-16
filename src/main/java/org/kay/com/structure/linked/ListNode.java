package org.kay.com.structure.linked;

/**
 * @author kay
 * @version v0.0.1
 */
public class ListNode {

    private final int data;
    private transient ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return this.data;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getNext() {
        return this.next;
    }
}
