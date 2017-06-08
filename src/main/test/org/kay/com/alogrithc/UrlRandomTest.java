/*
 * Copyright 2017-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
			String url = randomTest.generate();
			if (i % 100000 == 0) {
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
			String url = randomTest.generate();
			if (i % 100000 == 0) {
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
	public void test2() {
		UrlRandom randomTest = new UrlRandom(500);

		long startTime = System.currentTimeMillis();
		for (int i = 1000000; i > 0; i--) {
			String url = randomTest.generate();
			if (i % 100000 == 0) {
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
