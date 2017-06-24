package org.kay.com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kay
 * @version v0.0.1
 */
public final class ResultWrap1 {

    private Map<String, Object> map = new HashMap<>();

    public <T> T get(String name) {
        return (T) map.get(name);
    }
}
