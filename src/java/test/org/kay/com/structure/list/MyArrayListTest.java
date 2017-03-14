package org.kay.com.structure.list;

import org.junit.jupiter.api.Test;

/**
 * {@link MyArrayList} Test.
 *
 * @author kay
 * @version v0.0.1
 */
public class MyArrayListTest {

    @Test
    public void IndexOutOfBoundsTest(){
        new MyArrayList<>(-1);
    }
}
