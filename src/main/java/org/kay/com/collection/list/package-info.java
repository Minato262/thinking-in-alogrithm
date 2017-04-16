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

/**
 * <p>线性表是最基本、最简单、也是最常用的一种数据结构。
 * 线性表中数据元素之间的关系是一对一的关系，即除了第一个和最后一个数据元素之外，其它数据元素都是首尾相接的
 * （注意，这句话只适用大部分线性表，而不是全部。比如，循环链表逻辑层次上也是一种线性表（存储层次上属于链式存储），
 * 但是把最后一个数据元素的尾指针指向了哨位结点）。
 * 我们说“线性”和“非线性”，只在逻辑层次上讨论，而不考虑存储层次，
 * 所以双向链表和循环链表依旧是线性表。
 * 在数据结构逻辑层次上细分，线性表可分为一般线性表和受限线性表。
 * 一般线性表也就是我们通常所说的“线性表”，可以自由的删除或添加结点。受限线性表主要包括栈和队列，受限表示对结点的
 * 操作受限制。因此，线性表这种数据结构在实际应用中是广泛采用的一种数据结构</p>
 *
 * @author kay
 * @version v0.0.1
 */
package org.kay.com.collection.list;