package org.kay.com.alogrithc;

import org.junit.Test;
import org.kay.com.algorithm.UrlRandom;

import static java.lang.System.out;

/**
 * @author kay
 * @version v0.0.1
 */
public class UrlRandomTest {

    @Test
    public void test() {
        UrlRandom randomTest = new UrlRandom();

        long startTime = System.currentTimeMillis();
        for (int i = 1000000; i > 0; i--) {
            final String url = randomTest.generate();
            if (i % 100000 == 0){
                out.println(url);
            }
        }
        long endTime = System.currentTimeMillis();
        out.println("内外耗时：" + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 1000000; i > 0; i--) {
            randomTest.generate();
        }
        endTime = System.currentTimeMillis();
        out.println("内外耗时：" + (endTime - startTime) + "ms");
    }

    @Test
    public void test1() {
        UrlRandom randomTest = new UrlRandom(100);

        long startTime = System.currentTimeMillis();
        for (int i = 1000000; i > 0; i--) {
            final String url = randomTest.generate();
            if (i % 100000 == 0){
                out.println(url);
            }
        }
        long endTime = System.currentTimeMillis();
        out.println("内外耗时：" + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 1000000; i > 0; i--) {
            randomTest.generate();
        }
        endTime = System.currentTimeMillis();
        out.println("内外耗时：" + (endTime - startTime) + "ms");
    }

    @Test
    public void test5() {
        UrlRandom randomTest = new UrlRandom(500);

        long startTime = System.currentTimeMillis();
        for (int i = 1000000; i > 0; i--) {
            final String url = randomTest.generate();
            if (i % 100000 == 0){
                out.println(url);
            }
        }
        long endTime = System.currentTimeMillis();
        out.println("内外耗时：" + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 1000000; i > 0; i--) {
            randomTest.generate();
        }
        endTime = System.currentTimeMillis();
        out.println("内外耗时：" + (endTime - startTime) + "ms");
    }

}
