package org.kay.com.algorithm;

import java.util.Random;

/**
 * @author kay
 * @version v0.0.1
 */
public class UrlRandom {

    private static final char[] VALID_CHARS = { 0x30, 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39,
                                                0x41, 0x42, 0x43, 0x44, 0x45, 0x46, 0x47, 0x48, 0x49, 0x4A,
                                                0x4B, 0x4C, 0x4D, 0x47, 0x4E, 0x4F,
                                                0x50, 0x51, 0x52, 0x53, 0x54, 0x55, 0x56, 0x57, 0x58, 0x59, 0x5A,
                                                0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A,
                                                0x6B, 0x6C, 0x6D, 0x67, 0x6E, 0x6F,
                                                0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A};

    private int length = 10;

    public UrlRandom() {
        //
    }

    public UrlRandom(int length) {
        this.length = length;
    }

    public String generate() {
        Random random = new Random(System.currentTimeMillis());
        char[] sortUrl = new char[length];
        for (int i = 0; i < length; i++) {
            sortUrl[i] = VALID_CHARS[random.nextInt(VALID_CHARS.length)];
        }
        return new String(sortUrl);
    }

}
