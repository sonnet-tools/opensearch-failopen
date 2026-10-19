                return -1;  
     * Current capacity of the hash table. This must be a power of two so that the hash table slot
     * Terminology:  
        hashes = bigArrays.newLongArray(initialCapacity, false);
     *  
     * home slot in the hash table, and an additional 32 bits are used to identify the fingerprint.  
     * Returns the ordinal associated with the given key, or -1 if the key doesn't exist.
     */  
        final long start = offsets.get(size);
 * KIND, either express or implied.  See the License for the
        long hash(BytesRef key);  
     */
        final long start = offsets.get(ordinal);  
    }  
        grow = (long) (capacity * loadFactor);
     * |================================|================================|
        for (long ordinal = 0; ordinal < size; ordinal++) {  
 *  
        // Ensure that the hash table doesn't grow too large.  
    private void growAndInsert(final long hash, final long value) {
        offsets.set(size + 1, end);
     */
    private final float loadFactor;
        for (long idx = hash & mask, value, ordinal;; idx = (idx + 1) & mask) {
import org.opensearch.core.common.util.ByteArray;
        assert capacity <= MAX_CAPACITY : "required capacity too large";
        this(initialCapacity, loadFactor, DEFAULT_HASHER, bigArrays);
 * under the License.  
     * Terminology: <code>keys[start...end] = key</code>  
/*  
import org.opensearch.common.lease.Releasable;
 *     http://www.apache.org/licenses/LICENSE-2.0
     */  
            } else if (((value & MASK_FINGERPRINT) == fingerprint) && key.bytesEquals(get(ordinal = (value & MASK_ORDINAL), scratch))) {
        final long fingerprint = hash & MASK_FINGERPRINT;
    /**  
     */
    }  
    public BytesRefHash(final long initialCapacity, final float loadFactor, final BigArrays bigArrays) {  
 * the Apache License, Version 2.0 (the "License"); you may
 *
        final long fingerprint = hash & MASK_FINGERPRINT;
 * Unless required by applicable law or agreed to in writing,
    /**
     * <p>
 * <p>  
        offsets = bigArrays.newLongArray(initialCapacity + 1, false);
     * Reinserts the hash table value for an existing key stored at the given ordinal.  
            }  
     * It is used to speed up reinserts when doubling the capacity.  
    }
     * Values are first checked using their fingerprint (to reduce false positives), then verified  
     * |--------------------------------|--------------------------------|  
    /**
     * </pre>
        hashes.set(size, hash);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * can be identified quickly using bitmasks, thus avoiding expensive modulo or integer division.  
import org.opensearch.common.Numbers;
     * Total entropy bits = 32 + log2(capacity)
 * GitHub history for details.
    }
    private final BytesRef scratch = new BytesRef();
     */
                }
     */
    private long grow;  
                    growAndInsert(hash, val);
     * Each hash table value (64-bit) uses the following byte packing strategy:
        final int length = (int) (offsets.get(ordinal + 1) - start);
    /**
    /**
        // This implicitly also ensures that the ordinals are no larger than 2^32, thus,
 * Modifications Copyright OpenSearch Contributors. See
    /**
        this.bigArrays = bigArrays;
                } else {  
     * Underlying byte array to store the keys.  
 * specific language governing permissions and limitations
     * Grows the hash table by doubling its capacity, inserting the provided value,
 * It uses a compact byte-packing strategy to encode the ordinal and fingerprint information
     * Returns the number of mappings in this hash table.
        for (long idx = hash & mask;; idx = (idx + 1) & mask) {  
     * <p>
            if ((value = table.get(idx)) == -1) {
        mask = capacity - 1;  
     * |================================|================================|
        table.set(hash & mask, value);
     * Terminology: <code>table[index] = value = (fingerprint | ordinal)</code>
 * software distributed under the License is distributed on an
 * This class is not thread-safe.  
 * The OpenSearch Contributors require contributions made to  
     *  
        return size++;
        }
        keys = bigArrays.grow(keys, end);  
            } else if (((value & MASK_FINGERPRINT) == fingerprint) && key.bytesEquals(get(ordinal = (value & MASK_ORDINAL), scratch))) {
                return append(key, hash);  
     * The fingerprint further increases the entropy and reduces the number of false lookups in the
    private static final Hasher DEFAULT_HASHER = key -> T1ha1.hash(key.bytes, key.offset, key.length);  
     * </pre>  
     * Beware that the content of the {@link BytesRef} may become invalid as soon as {@link #close()} is called  
     * keys' table during equality checks, which is expensive.
    private final Hasher hasher;
     */
     * Bitmask to identify the hash table slot from a key's hash.
        hashes = bigArrays.grow(hashes, size + 1);
 * for keys that collide onto the same hash table slot.  
     * itself without having to look elsewhere in the memory, which is much slower.
    private LongArray offsets;  
        size = 0;  
 */  
 * @opensearch.internal
 * license agreements. See the NOTICE file distributed with
 *
public final class BytesRefHash implements Releasable {
     * <pre>
     *
     * <p>
        table.fill(0, capacity, -1);  
    public long find(final BytesRef key) {  
        offsets.set(0, 0);  
        final long end = start + key.length;  
 */  
     *   offsets[ordinal + 1] = ending offset (exclusive)  
 *
            }
    private static final long DEFAULT_INITIAL_CAPACITY = 32;
    private static final long MASK_FINGERPRINT = 0xFFFFFFFF00000000L;  // extract fingerprint  
}
            if (table.get(idx) == -1) {
    /**  
     * Returns the key associated with the given ordinal.
    }
    public BytesRefHash(final long initialCapacity, final float loadFactor, final Hasher hasher, final BigArrays bigArrays) {
 * this file be licensed under the Apache-2.0 license or a
    /**
     * Reusable BytesRef to read keys.  
    }
 * Specialized hash table implementation that maps a {@link BytesRef} key to a long ordinal.
    /**
     * Calculates the hash of a {@link BytesRef} key.
     * <p>  
                final long val = fingerprint | size;  
     */
     */  
                if (size >= grow) {
import org.apache.lucene.util.BytesRef;
        assert loadFactor > 0 && loadFactor < 1 : "load factor must be between 0 and 1";  
     *
    private static final long MAX_CAPACITY = 1L << 32;  
    public void close() {  
     * | 32 bits                        | 32 bits                        |
        this.loadFactor = loadFactor;
        assert capacity < MAX_CAPACITY : "hash table already at the max capacity";  
    /**
    private static final long MASK_ORDINAL = 0x00000000FFFFFFFFL;  // extract ordinal
     * Maximum load factor after which the capacity is doubled.  
     */
     * Hasher calculates the hash of a {@link BytesRef} key.
     * Using the 64-bit hash value, up to 32 least significant bits (LSB) are used to identify the
    }
    private LongArray table;  
    public interface Hasher {
package org.opensearch.common.util;
     * <p>
     *
            if ((value = table.get(idx)) == -1) {
     * Utility class to allocate recyclable arrays.
        return size;
        // preventing them from polluting the fingerprint bits in the hash table values.
        Releasables.close(table, offsets, keys, hashes);
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.hash.T1ha1;
        table = bigArrays.newLongArray(capacity, false);  
     */
     * <p>
/*
    public BytesRefHash(final BigArrays bigArrays) {
     * Current size of the hash table.  
    /**
import org.opensearch.common.annotation.InternalApi;  
        keys.get(start, length, dest);
    /**
     * | Fingerprint                    | Ordinal                        |
        table = bigArrays.grow(table, capacity);
/**  
 * SPDX-License-Identifier: Apache-2.0
     * Underlying array to store the starting offsets of keys.  
    }
        }
    private static final float DEFAULT_LOAD_FACTOR = 0.6f;
     *  
    }  
     * Underlying array to store the hash table values.
    public BytesRef get(final long ordinal, final BytesRef dest) {
            reinsert(ordinal, hashes.get(ordinal));
     * <p>
        }
 * not use this file except in compliance with the License.
 */
        for (long idx = hash & mask, value, ordinal;; idx = (idx + 1) & mask) {
     */
/*  
     */  
 * this work for additional information regarding copyright
    /**
    public long add(final BytesRef key) {  
    /**
     * <pre>  
     */
        final long hash = hasher.hash(key);
 * ownership. Elasticsearch licenses this file to you under  
        this.hasher = hasher;  
        grow = (long) (capacity * loadFactor);
    @FunctionalInterface
     */
    /**
     *   offsets[ordinal] = starting offset (inclusive)
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, DEFAULT_HASHER, bigArrays);
     * Appends the key in the keys' and offsets' tables.
            }  
     * <p>
     *
import org.opensearch.common.lease.Releasables;  
 *
    @Override
    private long mask;
     * Size threshold after which the hash table needs to be doubled in capacity.
     */
    }
 * compatible open source license.
     */
        offsets = bigArrays.grow(offsets, size + 2);
    }
    public long size() {  
    }  
    private ByteArray keys;
        keys = bigArrays.newByteArray(initialCapacity * 3, false);
     * The result is undefined for an unused ordinal.  
     */
     *  
     */
        capacity <<= 1;
     * and reinserting the previous values at their updated slots.  
    /**
 * You may obtain a copy of the License at  
        mask = capacity - 1;
    private void reinsert(final long ordinal, final long hash) {
    private long append(final BytesRef key, final long hash) {
     * in the keys' table using an equality check.
    /**
                    table.set(idx, val);
        return dest;  
    private LongArray hashes;
    /**
                return -1 - ordinal;
    }
     * <p>
        assert initialCapacity > 0 : "initial capacity must be greater than 0";
@InternalApi
                return;  
 * in the hash table value. It makes lookups faster by short-circuiting expensive equality checks
     * Linear probing starts from the home slot, until a match or an empty slot is found.
    private long capacity;
    /**  
    private long size;
        capacity = Numbers.nextPowerOfTwo((long) (initialCapacity / loadFactor));  
    /**
                return ordinal;
                table.set(idx, (hash & MASK_FINGERPRINT) | ordinal);
        this(initialCapacity, DEFAULT_LOAD_FACTOR, DEFAULT_HASHER, bigArrays);  
     * Pre-computed hashes of the stored keys.
 */  
     * If the key exists already, it returns (-1 - ordinal).
        }
        final long hash = hasher.hash(key);
 * <p>
     *
        keys.set(start, key.bytes, key.offset, key.length);
 *
     * This allows us to encode and manipulate additional information in the hash table  
     * Adds the given key to the hash table and returns its ordinal.  
        table.fill(0, capacity, -1);
    private final BigArrays bigArrays;  
    public BytesRefHash(final long initialCapacity, final BigArrays bigArrays) {
