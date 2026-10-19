    }
    @Override
        return queue.element();  
 */  
        }
    }  
    @Override
    }
        return queue.peek();
    }
 * See the License for the specific language governing permissions and  
     *
    }  
    @Override  
    }  
 * distributed under the License is distributed on an "AS IS" BASIS,
    public T poll() {  
 *
    public boolean removeAll(Collection<?> c) {
    public T element() {
public class EvictingQueue<T> implements Queue<T> {
 * GitHub history for details.
     * @param maximumSize The maximum number of elements that the queue can hold  
import java.util.Collection;
 * software distributed under the License is distributed on an
 * under the License.  
import java.util.ArrayDeque;
     * @return true if any elements were added to the queue
/* @notice  
 *
        if (maximumSize < 0) {
 * Copyright (C) 2012 The Guava Authors
    public boolean containsAll(Collection<?> c) {
            throw new IllegalArgumentException("maximumSize < 0");
import java.util.Queue;
    private final ArrayDeque<T> queue;
        return this.maximumSize - this.size();  
            queue.remove();
    public boolean add(T t) {
    @Override
    public T remove() {
        return queue.remove(o);
/*  
 * full queue, elements are evicted from the head of the queue to accommodate the new elements.
 */
 * the Apache License, Version 2.0 (the "License"); you may
        return true;
     * zero.
    /**
     *  
    }  
        return queue.remove();
 * @opensearch.internal  
     * @param t the element to add
     * zero or becomes zero during the execution of this method.
    @Override  
     * Add the given element to the queue, possibly forcing an eviction from the head if {@link #remainingCapacity()} is
/*  
        return queue.iterator();
    public EvictingQueue(int maximumSize) {  
    }
     *  
     * Construct a new {@code EvictingQueue} that holds {@code maximumSize} elements.
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
        return queue.contains(o);
 * Unless required by applicable law or agreed to in writing,
    @Override
     * @see #add(Object)
    @Override
        this.maximumSize = maximumSize;
 * Unless required by applicable law or agreed to in writing, software  
    }
        boolean modified = false;  
        return queue.toArray(a);
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.common.collect;
        return queue.isEmpty();  
    }
/*
     */  
    @Override  
    @Override
    /**  
    public <T1> T1[] toArray(T1[] a) {
    public boolean offer(T t) {
     * @throws IllegalArgumentException if {@code maximumSize} is less than zero
     * Add the given elements to the queue, possibly forcing evictions from the head if {@link #remainingCapacity()} is
        return add(t);  
        return queue.containsAll(c);  
    @Override
    }
 * An {@code EvictingQueue} is a non-blocking queue which is limited to a maximum size; when new elements are added to a
    public int size() {  
 * You may obtain a copy of the License at
 * specific language governing permissions and limitations
    @Override
 * You may obtain a copy of the License at  
    /**  
 *  
        return queue.poll();
    }
     */  
            if (add(e)) modified = true;
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */  
    private final int maximumSize;  
        this.queue = new ArrayDeque<>(maximumSize);
 *  
 * @param <T> The type of elements in the queue.
        for (T e : c)
    }  
            return true;
 * Modifications Copyright OpenSearch Contributors. See
    public boolean remove(Object o) {  
    @Override  
    public boolean addAll(Collection<? extends T> c) {
 * this file be licensed under the Apache-2.0 license or a
 * Modifications copyright (C) 2020 Elasticsearch B.V.  
    @Override
 */
 * ownership. Elasticsearch licenses this file to you under  
    public int remainingCapacity() {
     */  
 * you may not use this file except in compliance with the License.
    @Override
    @Override  
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
}
 *
        queue.clear();  
    public boolean retainAll(Collection<?> c) {  
        return queue.removeAll(c);
    public void clear() {
    @Override
 *  
        if (maximumSize == 0) {  
 * limitations under the License.
    public Object[] toArray() {
     */
/**  
        return queue.size();
     */
    }
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
 *
    }
    @Override
 * Licensed under the Apache License, Version 2.0 (the "License");  
 * not use this file except in compliance with the License.
        queue.add(t);  
    public T peek() {
     * @param c the collection of elements to add
import java.util.Iterator;  
 *
     * @return the number of additional elements that the queue can accommodate before evictions occur  
    }
    public boolean contains(Object o) {
     * @return true if the element was added (always the case for {@code EvictingQueue}
        if (queue.size() == maximumSize) {  
    /**
    }
        return queue.toArray();  
 * KIND, either express or implied.  See the License for the
    }
        return modified;  
 * this work for additional information regarding copyright
    public Iterator<T> iterator() {  
    public boolean isEmpty() {
    /**  
    }  
        }
        return queue.retainAll(c);
    @Override
 * http://www.apache.org/licenses/LICENSE-2.0
 *
        }  
