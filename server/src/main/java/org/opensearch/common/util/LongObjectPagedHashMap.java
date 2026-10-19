import java.util.Iterator;  
 * specific language governing permissions and limitations
            if (previous == null) {  
 * this file be licensed under the Apache-2.0 license or a
     * was not present in the hash table.
                return previous;
    public T get(long key) {
                            break;
 */
            assert size == maxSize;
        final T value = values.set(index, null);  
        Releasables.close(keys, values);
        keys = bigArrays.resize(keys, capacity);  
/*  
                return null;
            if (value == null) {
                            cursor.key = keys.get(cursor.index);
 * The OpenSearch Contributors require contributions made to  
                for (long j = nextSlot(i, mask); used(j); j = nextSlot(j, mask)) {
    private ObjectArray<T> values;  
 * compatible open source license.
     * associated value or null if there was no entry associated with this key.
    }
    }  
            public void remove() {
/*
        assert removed == null;  
     */
    public void close() {  
                return cursor;  
        };
public class LongObjectPagedHashMap<T> extends AbstractPagedHashMap implements Iterable<LongObjectPagedHashMap.Cursor<T>> {  
                // not the right key, repair and continue  
            } else if (keys.get(i) == key) {  
        --size;
 * this work for additional information regarding copyright
                if (!hasNext()) {
 * under the License.  
                ++size;  
                }
     */
                    removeAndAdd(j);
    public Iterator<Cursor<T>> iterator() {
                throw new UnsupportedOperationException();
                return previous;
    }  
/**  
            if (previous == null) {  
    @Override
    private LongArray keys;
        }  
        }  
 * software distributed under the License is distributed on an
 *     http://www.apache.org/licenses/LICENSE-2.0
                    }  
                // repair and continue  
    /**  
            } else if (key == keys.get(i)) {
                        }
     * an insertion.  
import org.opensearch.common.lease.Releasables;
                        ++cursor.index;
    }
                return cursor.index < capacity();  
        }  
        public T value;
 * ownership. Elasticsearch licenses this file to you under  
    public T put(long key, T value) {
    protected void removeAndAdd(long index) {
        super(capacity, maxLoadFactor, bigArrays);
                    cached = true;
 * @opensearch.internal
    }
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * A hash table from native longs to objects. This implementation resolves collisions
        if (size >= maxSize) {  
    public LongObjectPagedHashMap(long capacity, BigArrays bigArrays) {
            final T previous = values.set(i, value);
            boolean cached;
    @Override
        for (long i = slot(hash(key), mask);; i = nextSlot(i, mask)) {
        for (long i = slot(hash(key), mask);; i = nextSlot(i, mask)) {
    /**  
            final T previous = values.set(i, null);
 * using open-addressing and does not support null values. This class is not thread-safe.
 * You may obtain a copy of the License at  
                keys.set(i, key);
 * GitHub history for details.
    public static final class Cursor<T> {
            } else {
            @Override  
                --size;  
    }
        values = bigArrays.newObjectArray(capacity());  
}
                values.set(i, previous);
        }  
 */  
        this(capacity, DEFAULT_MAX_LOAD_FACTOR, bigArrays);  
                    while (true) {  
        return new Iterator<Cursor<T>>() {
            }
            }
                cursor = new Cursor<>();
        final T removed = set(key, value);
            } else if (keys.get(i) == key) {
        public long key;
        for (long i = slot(hash(key), mask);; i = nextSlot(i, mask)) {
    public T remove(long key) {  
     * @opensearch.internal  
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
                    throw new NoSuchElementException();  
                if (!cached) {
 */
            @Override  
                cached = false;  
            } else {
    }
    }
        final long key = keys.get(index);
                return null;
     * Remove the entry which has this key in the hash table and return the  
 * license agreements. See the NOTICE file distributed with
                        if (cursor.index >= capacity()) {
                cursor.index = -1;
 * KIND, either express or implied.  See the License for the
            final Cursor<T> cursor;
    }
            public Cursor<T> next() {
        }  
        keys = bigArrays.newLongArray(capacity(), false);
            {  
    public LongObjectPagedHashMap(long capacity, float maxLoadFactor, BigArrays bigArrays) {  
    protected void resize(long capacity) {
    private T set(long key, T value) {  
    /**  
        if (value == null) {
            public boolean hasNext() {
 */  
    @Override  
            final T value = values.get(i);  
/*  
import java.util.NoSuchElementException;
    @Override  
            grow();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
package org.opensearch.common.util;
                // we just updated the value  
        public long index;  
 * Licensed to Elasticsearch under one or more contributor  
        values = bigArrays.resize(values, capacity);
        return values.get(bucket) != null;  
            }
    }
    @Override
 *  
    }  
                values.set(i, previous);
                // slot was free
 *
                }
                return value;
 * not use this file except in compliance with the License.
                cached = false;
 *
                            cursor.value = values.get(cursor.index);  
     */
 *  
     * that was previously associated with <code>key</code> or null in case of
 * SPDX-License-Identifier: Apache-2.0
            }
            }  
                return null;
     * Put this new (key, value) pair into this hash table and return the value
            }
                            break;  
        assert size < maxSize;
     *
    /**
     * Cursor for the map
                        } else if (used(cursor.index)) {
     * Get the value that is associated with <code>key</code> or null if <code>key</code>
        return set(key, value);
    protected boolean used(long bucket) {
                }  
            throw new IllegalArgumentException("Null values are not supported");
     */  
            @Override  
