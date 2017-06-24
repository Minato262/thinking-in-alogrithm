package org.kay.com.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kay
 * @version v0.0.1
 */
public class AysnTest {

    @Test
    public void test() {
        Map map = new HashMap<>();
        map.put("1", "String");
        map.put("2", 1);
        map.put("3", 1L);

        Object obj = new Result<>(1);
        Result result = (Result) obj;
        System.out.println(result.getInt());
        System.out.println(map);
    }
}
