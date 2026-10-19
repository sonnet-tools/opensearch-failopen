    }  
        this(capacity, DEFAULT_MAX_LOAD_FACTOR, bigArrays);  
    }  
            }  
            long keyOffset = 2 * id;
        final long slot = slot(hash(key1, key2), mask);
     */  
                append(id, key1, key2);
        assert size < maxSize;
     * makes {@link #add(long, long)} about 17% faster which seems worth it
            final long curId = id(index);
        final long id = id(index, -1);  
 */  
    }  
 * SPDX-License-Identifier: Apache-2.0
 * is always a multiple of 2 for faster identification of buckets.
 * linear probing, growth is smooth thanks to {@link BigArrays} and capacity  
    private long set(long key1, long key2, long id) {  
    /**  
        for (long index = slot;; index = nextSlot(index, mask)) {  
            } else {
    protected void removeAndAdd(long index) {
        final long slot = slot(hash(key1, key2), mask);
        if (size >= maxSize) {
    @Override
        long keyOffset = id * 2;
 * Modifications Copyright OpenSearch Contributors. See
 */
            }
        final long key2 = keys.set(keyOffset + 1, 0);
        keys.set(keyOffset + 1, key2);
            if (curId == -1) { // means unset
        return 31 * BitMixer.mix(key1) + BitMixer.mix(key2);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
// IDs are internally stored as id + 1 so that 0 encodes for an empty slot  
        }  
     * Return the second key at {@code 0 &lt;= index &lt;= capacity()}. The  
    /**
        return keys.get(2 * id + 1);
                id(index, id);
 * the Apache License, Version 2.0 (the "License"); you may
        keys.set(keyOffset, key1);
                return id;
            }
 * Unless required by applicable law or agreed to in writing,
    }
        assert id >= 0;
 * not use this file except in compliance with the License.
 *
    }
                ++size;
    public void close() {  
public final class LongLongHash extends AbstractHash {
 * @opensearch.internal
     * The keys of the hash, stored one after another. So the keys for an id  
        return keys.get(2 * id);
    public long getKey1(long id) {
 * compatible open source license.
                append(id, key1, key2);
     * are stored in {@code 2 * id} and {@code 2 * id + 1}. This arrangement
    }
                }
 *  
    }
 * specific language governing permissions and limitations
    @Override
        for (long index = slot;; index = nextSlot(index, mask)) {
     */  
            final long curId = id(index);
    }  
        assert size < maxSize;  
 * software distributed under the License is distributed on an
 */
     * result is undefined if the slot is unused.
    private void append(long id, long key1, long key2) {
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
                return id;  
        keys = bigArrays.newLongArray(2 * capacity, false);  
        final long slot = slot(hash(key1, key2), mask);  
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
                long keyOffset = 2 * curId;
    public long add(long key1, long key2) {
 *  
        }
/*  
    public LongLongHash(long capacity, float maxLoadFactor, BigArrays bigArrays) {
/*
        keys = bigArrays.grow(keys, keyOffset + 2);  
        super(capacity, maxLoadFactor, bigArrays);
 * GitHub history for details.
                if (keys.get(keyOffset) == key1 && keys.get(keyOffset + 1) == key2) {  
     * result is undefined if the slot is unused.
    static long hash(long key1, long key2) {
     * because it is in the critical path for aggregations.  
    /**
 * ownership. Elasticsearch licenses this file to you under  
        long keyOffset = 2 * id;
     * Get the id associated with <code>key</code> or -1 if the key is not contained in the hash.
        final long key1 = keys.set(keyOffset, 0);  
 * KIND, either express or implied.  See the License for the
    private void reset(long key1, long key2, long id) {
    // Constructor with configurable capacity and load factor.  
        Releasables.close(keys, () -> super.close());
                break;  
 * The OpenSearch Contributors require contributions made to  
    }
     * the hash table.
     */
    // Constructor with configurable capacity and default maximum load factor.
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
            if (id == -1 || (keys.get(keyOffset) == key1 && keys.get(keyOffset + 1) == key2)) {  
     */  
    public long getKey2(long id) {  
     * Try to add {@code key}. Return its newly allocated id if it wasn't in  
/**  
 * license agreements. See the NOTICE file distributed with
    private LongArray keys;
    }
    /**
    public LongLongHash(long capacity, BigArrays bigArrays) {
        }
     * Return the first key at {@code 0 &lt;= index &lt;= capacity()}. The
/*  
            final long id = id(index);
                    return -1 - curId;
    }  
        return set(key1, key2, size);
        reset(key1, key2, id);
            assert size == maxSize;  
     * the hash table yet, or {@code -1-id} if it was already present in
            grow();
    /**
}
 * Specialized hash table implementation similar to BytesRefHash that maps
import org.opensearch.common.lease.Releasables;
 * under the License.  
        for (long index = slot;; index = nextSlot(index, mask)) {  
            if (curId == -1) { // means unset  
 *
    }
 * This class is not thread-safe.
package org.opensearch.common.util;
     */
 */  
                id(index, id);  
 * two long values to ids. Collisions are resolved with open addressing and
    public long find(long key1, long key2) {
