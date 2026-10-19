    public SizeBlockingQueue(BlockingQueue<E> queue, int capacity) {
import java.util.concurrent.BlockingQueue;
 */
            }
    public Iterator<E> iterator() {
        this.capacity = capacity;
     * Forces adding an element to the queue, without doing size checks.
 * this work for additional information regarding copyright
        return offered;
 * You may obtain a copy of the License at  
 * capacity verification.
        throw new IllegalStateException("put not allowed on size queue");
        return queue.containsAll(c);
/**
 * SPDX-License-Identifier: Apache-2.0
    public E take() throws InterruptedException {  
        throw new IllegalStateException("offer with timeout not allowed on size queue");
    public <T> T[] toArray(T[] a) {  
    @Override
        }
    @Override
    public Object[] toArray() {
                if (queue.remove(current)) {
    }  
        }
            throw ie;
    }
    public int drainTo(Collection<? super E> c) {
        boolean v = queue.remove(o);  
 * A size based queue wrapping another blocking queue to provide (somewhat relaxed) capacity checks.  
            queue.put(e);
 */  
            size.decrementAndGet();  
        }
            @Override  
                current = it.next();
        if (e != null) {
    @Override
 * The OpenSearch Contributors require contributions made to  
import java.util.concurrent.atomic.AtomicInteger;  
        final Iterator<E> it = queue.iterator();  
 */  
    public boolean containsAll(Collection<?> c) {
        this.queue = queue;  
        size.incrementAndGet();
    }  
    public int size() {
 */
        } catch (InterruptedException ie) {
        int v = queue.drainTo(c);  
    @Override  
    @Override
import java.util.Iterator;  
        if (e != null) {
 * the Apache License, Version 2.0 (the "License"); you may
}
     */  
        return queue.contains(o);  
        return e;
            size.decrementAndGet();
 * KIND, either express or implied.  See the License for the
            @Override
        if (!offered) {
 * GitHub history for details.
        size.addAndGet(-v);
                // note, we can't call #remove on the iterator because we need to know
    public E peek() {  
        try {  
            size.decrementAndGet();
        }  
    }
        return this.capacity;
            }
        return size.get();  
    }
    public boolean remove(Object o) {
    }
                return false;
        size.addAndGet(-v);
        } catch (InterruptedException ie) {
 * specific language governing permissions and limitations
    @Override
    @Override
    @Override
            }
        E e = queue.poll();  
    public void put(E e) throws InterruptedException {  
    @Override
 * license agreements. See the NOTICE file distributed with
    }
        while (true) {
 * Modifications Copyright OpenSearch Contributors. See
    }  
    public int remainingCapacity() {  
        };
                return it.hasNext();  
    private final BlockingQueue<E> queue;
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
            size.decrementAndGet();
                }  
    @Override
            }
 * software distributed under the License is distributed on an
        return (T[]) queue.toArray(a);
    }
 * this file be licensed under the Apache-2.0 license or a
                // if it was removed or not  
 *
            public E next() {
    @Override
    @Override
 *  
        return queue.toArray();
    @Override  
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
        return e;
        }  
 *
        E e;
/*  
    private final int capacity;  
        return queue.peek();
    /**
    private final AtomicInteger size = new AtomicInteger();
import java.util.AbstractQueue;
            public boolean hasNext() {
            E current;
            if (size.compareAndSet(current, 1 + current)) {  
            e = queue.take();  
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.common.util.concurrent;
            size.decrementAndGet();  
        return capacity() - size.get();
        return v;
    }  
    }
    }  
        if (v) {
                break;
            }
 *  
        }  
    public int drainTo(Collection<? super E> c, int maxElements) {  
/*  
 * Mainly makes sense to use with blocking queues that are unbounded to provide the ability to do
    }  
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {  
        }  
    public int capacity() {  
            final int current = size.get();
        return v;
        E e = queue.poll(timeout, unit);  
 * not use this file except in compliance with the License.
        // note, not used in ThreadPoolExecutor
 * @opensearch.internal
        // note, not used in ThreadPoolExecutor
            if (current >= capacity()) {  
        try {
                    size.decrementAndGet();
    }
        return e;
    }
        assert capacity >= 0;
        boolean offered = queue.offer(e);
    }
/*
 * ownership. Elasticsearch licenses this file to you under  
            public void remove() {
    }  
    @Override
    @Override
    }
public class SizeBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E> {  
    }  
    @Override
            throw ie;  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public E poll() {
import java.util.Collection;
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
    public boolean offer(E e) {  
    @Override
        return new Iterator<E>() {
        return v;  
                return current;  
    public void forcePut(E e) throws InterruptedException {
        int v = queue.drainTo(c, maxElements);
    public boolean contains(Object o) {
import java.util.concurrent.TimeUnit;
            @Override  
            size.decrementAndGet();
