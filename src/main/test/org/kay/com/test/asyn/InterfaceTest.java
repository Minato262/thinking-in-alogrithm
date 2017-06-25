package org.kay.com.test.asyn;

import java.util.List;
import java.util.Map;
import java.util.logging.Handler;

/**
 * @author kay
 * @version v0.0.1
 */
public interface InterfaceTest<V> {

    void setUrl(String urlName);

    void setParam(Map<String, String> param);

    void setHote(boolean isHote);

    void setHandle(Handler handle);

    List<Result<V>> createAsyn();
}
