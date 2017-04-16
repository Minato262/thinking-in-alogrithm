package org.kay.com.structure;

import org.junit.Test;
import org.kay.com.structure.linked.DLLLinked;
import org.kay.com.structure.linked.DLLNode;

/**
 * {@link DLLLinked} Test.
 *
 * @author kay
 * @version v0.0.1
 */
public class DLLLinkedTest {

    @Test
    public void test() {
        DLLLinked linked = new DLLLinked();
        linked.insertDLL(new DLLNode(1), new DLLNode(2), 1);
        linked.deleteDLLNode(new DLLNode(1), 1);
    }
}
