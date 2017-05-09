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
package org.kay.com.collection.set;

import org.kay.com.collection.AbstractCollection;
import org.kay.com.collection.MyIterator;

/**
 * @param <E>
 */
public class AbstractSet<E> extends AbstractCollection<E> implements MySet<E> {

    @Override
    public MyIterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
