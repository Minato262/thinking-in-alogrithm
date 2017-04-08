package org.kay.com.structure.array;

import org.kay.com.structure.map.Map;

/**
 * @author kay
 * @version v0.0.1
 */
public class ResultBody<V> {
    private String message;
    private String code;
    private V data;
    private transient Map param;

    public ResultBody(Map param) {
        this.param = param;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public Map getParam() {
        return param;
    }

    public void setParam(Map param) {
        this.param = param;
    }
}
