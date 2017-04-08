package org.kay.com.algorithm;

import java.util.Random;

/**
 * @author kay
 * @version v0.0.1
 */
public class StringUrlRandom {

    private static char[] VALID_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
    private static Random random = new Random(System.currentTimeMillis());
    private int length = 10;

    public StringUrlRandom() {
        //
    }

    public StringUrlRandom(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    private String generate(int seed) {
        char[] sortUrl = new char[length];
        for (int i = 0; i < length; i++) {
            sortUrl[i] = VALID_CHARS[seed % VALID_CHARS.length];
            seed = random.nextInt(Integer.MAX_VALUE) % VALID_CHARS.length;
        }
        return new String(sortUrl);
    }

    /**
     * 这里的实现不考虑url，直接生成随机字符串即可，这个算法如果容量比较大的时候，
     * 性能会变低，因此要根据使用情况选择合适的长度
     *
     * @return
     */
    public String generate() {
        return generate(random.nextInt(Integer.MAX_VALUE));
    }
}
