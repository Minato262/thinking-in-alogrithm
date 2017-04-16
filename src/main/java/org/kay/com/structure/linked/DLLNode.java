package org.kay.com.structure.linked;

/**
 * @author kay
 * @version v0.0.1
 */
public class DLLNode {
    private transient int data;
    private transient DLLNode previous;
    private transient DLLNode next;

    public DLLNode(int data) {this.data = data;}

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DLLNode getPrevious() {
        return previous;
    }

    public void setPrevious(DLLNode previous) {
        this.previous = previous;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }
}
