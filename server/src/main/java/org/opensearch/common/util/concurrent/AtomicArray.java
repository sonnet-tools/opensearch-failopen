     *  
/*  
 * specific language governing permissions and limitations
            }
                nonNullList = Collections.emptyList();  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
     * @param i the index
    /**  
    private volatile List<E> nonNullList;  
    /**
    }
     * Gets the current value at position {@code i}.  
                        list.add(e);  
        return nonNullList;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
     */
    }  
        if (nonNullList != null) { // read first, lighter, and most times it will be null...  
        if (a.length != array.length()) {
    public int length() {  
 *  
    private final AtomicReferenceArray<E> array;
        array = new AtomicReferenceArray<>(size);  
import org.opensearch.common.annotation.PublicApi;
            nonNullList = null;
        if (array.compareAndSet(i, null, value) == false) {  
     */  
        }
import java.util.List;  
                }
     * @param value the new value
 * Unless required by applicable law or agreed to in writing,
        }
    /**
            throw new IllegalStateException("index [" + i + "] has already been set");
    /**  
            if (array == null || array.length() == 0) {
    public void set(int i, E value) {
        }
        if (nonNullList != null) { // read first, lighter, and most times it will be null...  
     */
        array.set(i, value);
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
package org.opensearch.common.util.concurrent;
     * The size of the expected results, including potential null values.
 * this work for additional information regarding copyright
 *  
    /**  
 * software distributed under the License is distributed on an
                List<E> list = new ArrayList<>(array.length());
    public E[] toArray(E[] a) {  
        if (nonNullList == null) {
import org.opensearch.OpenSearchGenerationException;
import java.util.ArrayList;
                    }
     */
     * Returns the it as a non null list.
        for (int i = 0; i < array.length(); i++) {
 * compatible open source license.
    public final void setOnce(int i, E value) {
 * to get the concrete values as a list using {@link #asList()}.
     */
            nonNullList = null;
                nonNullList = list;  
    }
                    if (e != null) {
        }
 * Modifications Copyright OpenSearch Contributors. See
            } else {
}  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 * @opensearch.api
        }  
    }  
 */  
 * The OpenSearch Contributors require contributions made to  
@PublicApi(since = "1.0.0")  
            a[i] = array.get(i);
public class AtomicArray<E> {
 * You may obtain a copy of the License at  
        return array.get(i);  
        }  
    }
 * A list backed by an {@link AtomicReferenceArray} with potential null values, easily allowing
/**  
/*
     * Sets the element at position {@code i} to the given value.
    }
import java.util.Collections;
                for (int i = 0; i < array.length(); i++) {  
     *
     * Copies the content of the underlying atomic array to a normal one.
/*  
 */
 */
 * license agreements. See the NOTICE file distributed with
    public AtomicArray(int size) {
    }
 */  
 *
     * @return the current value  
     * @param i     the index
    public List<E> asList() {  
 *
                    E e = array.get(i);
 * under the License.  
    public E get(int i) {
            throw new OpenSearchGenerationException("AtomicArrays can only be copied to arrays of the same size");
 *     http://www.apache.org/licenses/LICENSE-2.0
        return a;
import java.util.concurrent.atomic.AtomicReferenceArray;
        return array.length();
 * Licensed to Elasticsearch under one or more contributor  
