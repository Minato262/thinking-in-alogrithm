package org.kay.com.structure;

import org.junit.Test;
import org.kay.com.structure.linked.ListLinked;
import org.kay.com.structure.linked.ListNode;

/**
 * {@link ListLinked} Test.
 *
 * @author kay
 * @version v0.0.1
 */
public class ListLinkedTest {

    @Test
    public void test() {
        ListLinked listLinked = new ListLinked();
        ListNode node = listLinked.insertInLinkedList(new ListNode(1), new ListNode(2), 1);
        System.out.println(node);

        node = listLinked.deleteNodeFromLinkedList(new ListNode(1), 1);
        System.out.println(node);

        listLinked.deleteLinkedList(new ListNode(1));
    }
}
