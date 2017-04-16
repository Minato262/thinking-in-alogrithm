package org.kay.com.structure.linked;

/**
 * @author kay
 * @version v0.0.1
 */
public class CLLNode {

    private transient int data;
    private transient CLLNode previous;
    private transient CLLNode next;

    public CLLNode(int data) {this.data = data;}

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public CLLNode getPrevious() {
        return previous;
    }

    public void setPrevious(CLLNode previous) {
        this.previous = previous;
    }

    public CLLNode getNext() {
        return next;
    }

    public void setNext(CLLNode next) {
        this.next = next;
    }
}
