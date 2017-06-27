package org.kay.com.test.asyn;

/**
 * @author kay
 * @version v0.0.1
 */
public final class Result<V> {

    private int i;

    private V data;

    public Result(int i, V data) {
        this.i = i;
        this.data = data;
    }

    public int getInt() {
        return this.i;
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public String toString() {
        return "{" + "i=" + i + "data=" + data + "}";
    }
}
