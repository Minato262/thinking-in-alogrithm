package org.kay.com.structure.linked;

/**
 * @author kay
 * @version v0.0.1
 */
public class CircularList {

    public int getListLength(CLLNode headNode) {
        int length = 0;
        CLLNode currentNode = headNode;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
            if (currentNode == headNode) {
                break;
            }
        }
        return length;
    }

    public void printCircularListData(CLLNode headNode) {
        CLLNode cllNode = headNode;
        while (cllNode != null) {
            System.out.println(cllNode.getData() + "->");
            cllNode = cllNode.getNext();
            if (cllNode == headNode) {
                break;
            }
        }
        System.out.println("(" + cllNode.getData() + ")headNode");
    }

    public void insertAtEndInCLL(CLLNode headNode, CLLNode nodeToInsert) {
        CLLNode currentNode = headNode;
        while (currentNode.getNext() != headNode) {
            currentNode.setNext(currentNode.getNext());
        }
        nodeToInsert.setNext(nodeToInsert);
        if (headNode == null) {
            headNode = nodeToInsert;
        }
        else {
            nodeToInsert.setNext(headNode);
            currentNode.setNext(nodeToInsert);
        }
    }

    public void insertAtBeginInCLL(CLLNode headNode, CLLNode nodeToInsert) {
        CLLNode currentNode = headNode;
        while (currentNode.getNext() != headNode) {
            currentNode.setNext(currentNode.getNext());
        }
        nodeToInsert.setNext(nodeToInsert);
        if (headNode == null) {
            headNode = nodeToInsert;
        }
        else {
            nodeToInsert.setNext(headNode);
            currentNode.setNext(nodeToInsert);
            headNode = nodeToInsert;
        }
    }

    public void deleteLastNodeFromCLL(CLLNode head) {
        CLLNode temp = head;
        CLLNode currentNode = head;
        if (head == null) {
            System.out.println("List Empty!");
            return;
        }
        while (currentNode.getNext() != head) {
            temp = currentNode;
            currentNode = currentNode.getNext();
        }
        temp.setNext(head);
        currentNode = null;
        return;
    }

    public void deleteFrontNodeFromCLL(CLLNode head) {
        CLLNode temp = head;
        CLLNode current = head;
        if (head == null) {
            System.out.println("List Empty!");
            return;
        }
        while (current.getNext() != head) {
            current.setNext(current.getNext());
        }
        current.setNext(head.getNext());
        head = head.getNext();
        temp = null;
        return;
    }
}
