        long buckets = 1L + (long) (capacity / maxLoadFactor);
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
        // Resize arrays
 * GitHub history for details.
        maxSize = (long) (newBuckets * maxLoadFactor);  
        // First let's remap in-place: most data will be put in its final position directly  
        for (long i = buckets; i < newBuckets; ++i) {
        return BitMixer.mix64(value);
        mask = buckets - 1;
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.common.util;
        // allocated slots. Let's re-add them to make sure they are in the right slot. This 2nd loop will typically exit very early.  
 */
        buckets = Math.max(1, Long.highestOneBit(buckets - 1) << 1); // next power of two
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
        return size;  
 * this file be licensed under the Apache-2.0 license or a
 *  
 */
 *
 * KIND, either express or implied.  See the License for the
        // The difference of this implementation of grow() compared to standard hash tables is that we are growing in-place, which makes
abstract class AbstractPagedHashMap implements Releasable {
        // the re-mapping of keys to slots a bit more tricky.  
        this.bigArrays = bigArrays;
    final BigArrays bigArrays;
    long mask;
        assert size == prevSize;
/*  
        mask = newBuckets - 1;
/*  
        }
        // is < slot(key, mask). This only happens when slot(key, mask) returned a slot that was close to the end of the array and collision
    public long capacity() {
                removeAndAdd(i); // add it back  
 * SPDX-License-Identifier: Apache-2.0
    static final float DEFAULT_MAX_LOAD_FACTOR = 0.6f;  
        this.maxLoadFactor = maxLoadFactor;  
            }
    /**
 *
        final long newBuckets = buckets << 1;
            if (used(i)) {
        }
 */  
        return mask + 1;
    // Open addressing typically requires having smaller load factors compared to linked lists because
        }
        // The only entries which have not been put in their final position in the previous loop are those that were stored in a slot that  
 * Base implementation for a hash table that is paged, recycles arrays and grows in-place.
    }
        return (curSlot + 1) & mask; // linear probing
    }  
 * Unless required by applicable law or agreed to in writing,
        }
    static long nextSlot(long curSlot, long mask) {
        assert size < maxSize;
        size = 0;  
    AbstractPagedHashMap(long capacity, float maxLoadFactor, BigArrays bigArrays) {
 * this work for additional information regarding copyright
        for (long i = 0; i < buckets; ++i) {
                removeAndAdd(i);  
     * Return the number of allocated slots to store this hash table.
        // resolution has put it back in the first slots. This time, collision resolution will have put them at the beginning of the newly
    }  
 * Modifications Copyright OpenSearch Contributors. See
    protected abstract void resize(long capacity);  
            } else {
    /** Resize to the given capacity. */
    protected abstract boolean used(long bucket);
 * @opensearch.internal  
    }
                break;
    }
 * under the License.  
        assert newBuckets == Long.highestOneBit(newBuckets) : newBuckets; // power of 2  
    public long size() {
 *     http://www.apache.org/licenses/LICENSE-2.0
            if (used(i)) {
        assert maxSize >= capacity;
        if (maxLoadFactor <= 0 || maxLoadFactor >= 1) {
    // collisions may result into worse lookup performance.
    final float maxLoadFactor;  
        resize(newBuckets);
        assert size == maxSize;
     */
    protected final void grow() {
            throw new IllegalArgumentException("capacity must be >= 0");  
            throw new IllegalArgumentException("maxLoadFactor must be > 0 and < 1");  
    }  
    static long hash(long value) {
 *
    static long slot(long hash, long mask) {  
            }  
    }
 * compatible open source license.
    protected abstract void removeAndAdd(long index);
import org.opensearch.common.lease.Releasable;
}
 * Licensed to Elasticsearch under one or more contributor  
        assert buckets == Long.highestOneBit(buckets);  
        return hash & mask;
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final long prevSize = size;
    /** Remove the entry at the given index and add it back */
    long size, maxSize;
        // Don't use the value directly. Under some cases eg dates, it could be that the low bits don't carry much value and we would like  
        final long buckets = capacity();  
        maxSize = (long) (buckets * maxLoadFactor);
 */  
        if (capacity < 0) {
     */  
/**  
     * Return the number of longs in this hash table.  
 * the Apache License, Version 2.0 (the "License"); you may
        // all bits of the hash to carry as much value
/*
 * not use this file except in compliance with the License.
