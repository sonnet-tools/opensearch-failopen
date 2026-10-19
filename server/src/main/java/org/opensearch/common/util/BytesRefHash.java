    private long size;
     * | Fingerprint                    | Ordinal                        |
    private final BigArrays bigArrays;
     * | 32 bits                        | 32 bits                        |
     * <p>
     *
    public long add(final BytesRef key) {
        this.hasher = hasher;
     */
     */
     * Appends the key in the keys' and offsets' tables.
    }
    /**
        }
     * It is used to speed up reinserts when doubling the capacity.
    public BytesRefHash(final long initialCapacity, final BigArrays bigArrays) {
     *   offsets[ordinal] = starting offset (inclusive)
    private final BytesRef scratch = new BytesRef();
 */
     * Underlying byte array to store the keys.
    /**
     * Reinserts the hash table value for an existing key stored at the given ordinal.
    /**
     *
 * @opensearch.internal
    public void close() {
     * Reusable BytesRef to read keys.
    private LongArray offsets;
     * Adds the given key to the hash table and returns its ordinal.
     * Using the 64-bit hash value, up to 32 least significant bits (LSB) are used to identify the
        offsets.set(0, 0);
     * can be identified quickly using bitmasks, thus avoiding expensive modulo or integer division.
    @FunctionalInterface
    @Override
    private static final long MAX_CAPACITY = 1L << 32;
     * Terminology:
     * Returns the key associated with the given ordinal.
        keys = bigArrays.grow(keys, end);
     */
            } else if (((value & MASK_FINGERPRINT) == fingerprint) && key.bytesEquals(get(ordinal = (value & MASK_ORDINAL), scratch))) {
        // Ensure that the hash table doesn't grow too large.
     * Calculates the hash of a {@link BytesRef} key.
 *
     */
package org.opensearch.common.util;
    }
     * <p>
    public long size() {
 * It uses a compact byte-packing strategy to encode the ordinal and fingerprint information
        final long start = offsets.get(ordinal);
    public BytesRef get(final long ordinal, final BytesRef dest) {
 * this file be licensed under the Apache-2.0 license or a
    private final float loadFactor;
     * Beware that the content of the {@link BytesRef} may become invalid as soon as {@link #close()} is called
     * |--------------------------------|--------------------------------|
                }
 * GitHub history for details.
                return;
                table.set(idx, (hash & MASK_FINGERPRINT) | ordinal);
        this.loadFactor = loadFactor;
            if ((value = table.get(idx)) == -1) {
            }
        return dest;
 * SPDX-License-Identifier: Apache-2.0
 * This class is not thread-safe.
 * not use this file except in compliance with the License.
 *
     * <p>
 *
     * <p>
        final long fingerprint = hash & MASK_FINGERPRINT;
                final long val = fingerprint | size;
        this(initialCapacity, loadFactor, DEFAULT_HASHER, bigArrays);
     * Total entropy bits = 32 + log2(capacity)
/**
        capacity = Numbers.nextPowerOfTwo((long) (initialCapacity / loadFactor));
     *
     * home slot in the hash table, and an additional 32 bits are used to identify the fingerprint.
import org.opensearch.core.common.util.ByteArray;
     * Current size of the hash table.
        table.fill(0, capacity, -1);
        assert capacity < MAX_CAPACITY : "hash table already at the max capacity";
    /**
     */
public final class BytesRefHash implements Releasable {
        capacity <<= 1;
     *
        table.fill(0, capacity, -1);
                    growAndInsert(hash, val);
        table = bigArrays.grow(table, capacity);
 * the Apache License, Version 2.0 (the "License"); you may
        hashes.set(size, hash);
    }
import org.opensearch.common.lease.Releasables;
    private long capacity;
    public BytesRefHash(final BigArrays bigArrays) {
     */
        offsets = bigArrays.grow(offsets, size + 2);
 * under the License.
    private void growAndInsert(final long hash, final long value) {
     * <pre>
     */
 * license agreements. See the NOTICE file distributed with
        this.bigArrays = bigArrays;
    public BytesRefHash(final long initialCapacity, final float loadFactor, final Hasher hasher, final BigArrays bigArrays) {
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under
     * Terminology: <code>table[index] = value = (fingerprint | ordinal)</code>
     * Linear probing starts from the home slot, until a match or an empty slot is found.
    }
    private ByteArray keys;
    /**
            if (table.get(idx) == -1) {
     * |================================|================================|
    /**
    private static final long DEFAULT_INITIAL_CAPACITY = 32;
     * Pre-computed hashes of the stored keys.
    /**
        }
 * Specialized hash table implementation that maps a {@link BytesRef} key to a long ordinal.
     * Each hash table value (64-bit) uses the following byte packing strategy:
     * Maximum load factor after which the capacity is doubled.
 * The OpenSearch Contributors require contributions made to
     */
     * <pre>
     * The result is undefined for an unused ordinal.
        for (long idx = hash & mask;; idx = (idx + 1) & mask) {
/*
    /**
        offsets.set(size + 1, end);
    /**
    }
    public long find(final BytesRef key) {
        final long fingerprint = hash & MASK_FINGERPRINT;
            if ((value = table.get(idx)) == -1) {
        keys.get(start, length, dest);
     */
     */
     * The fingerprint further increases the entropy and reduces the number of false lookups in the
    private static final long MASK_ORDINAL = 0x00000000FFFFFFFFL;  // extract ordinal
     * </pre>
 */
    private static final Hasher DEFAULT_HASHER = key -> T1ha1.hash(key.bytes, key.offset, key.length);
     * Returns the number of mappings in this hash table.
     * Current capacity of the hash table. This must be a power of two so that the hash table slot
     * <p>
        keys.set(start, key.bytes, key.offset, key.length);
    private final Hasher hasher;
                return -1;
     * <p>
    /**
        assert capacity <= MAX_CAPACITY : "required capacity too large";
 * You may obtain a copy of the License at
@InternalApi
        Releasables.close(table, offsets, keys, hashes);
 * software distributed under the License is distributed on an
    /**
    }
 */
     * <p>
        offsets = bigArrays.newLongArray(initialCapacity + 1, false);
    public interface Hasher {
        table = bigArrays.newLongArray(capacity, false);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private void reinsert(final long ordinal, final long hash) {
        final long end = start + key.length;
        size = 0;
    /**
    /**
                return append(key, hash);
    }
            }
    /**
     *   offsets[ordinal + 1] = ending offset (exclusive)
    private LongArray hashes;
        final long start = offsets.get(size);
/*
        table.set(hash & mask, value);
     * </pre>
     * Terminology: <code>keys[start...end] = key</code>
    /**
        this(initialCapacity, DEFAULT_LOAD_FACTOR, DEFAULT_HASHER, bigArrays);
        for (long idx = hash & mask, value, ordinal;; idx = (idx + 1) & mask) {
    }
import org.apache.lucene.util.BytesRef;
/*
     * Utility class to allocate recyclable arrays.
     * Size threshold after which the hash table needs to be doubled in capacity.
     * Hasher calculates the hash of a {@link BytesRef} key.
        grow = (long) (capacity * loadFactor);
     */
 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
        final int length = (int) (offsets.get(ordinal + 1) - start);
     * <p>
        long hash(BytesRef key);
        return size;
    private long grow;
     * <p>
    /**
 */
            reinsert(ordinal, hashes.get(ordinal));
        assert initialCapacity > 0 : "initial capacity must be greater than 0";
 * Modifications Copyright OpenSearch Contributors. See
        final long hash = hasher.hash(key);
    private long mask;
    private static final long MASK_FINGERPRINT = 0xFFFFFFFF00000000L;  // extract fingerprint
     * Values are first checked using their fingerprint (to reduce false positives), then verified
    }
import org.opensearch.common.annotation.InternalApi;
     */
     *
     */
    private LongArray table;
     *
    }
            }
                    table.set(idx, val);
     * in the keys' table using an equality check.
     */
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, DEFAULT_HASHER, bigArrays);
    /**
    }
        grow = (long) (capacity * loadFactor);
 * Licensed to Elasticsearch under one or more contributor
    private static final float DEFAULT_LOAD_FACTOR = 0.6f;
    }
        }
     * Underlying array to store the starting offsets of keys.
 * in the hash table value. It makes lookups faster by short-circuiting expensive equality checks
    private long append(final BytesRef key, final long hash) {
        mask = capacity - 1;
        hashes = bigArrays.grow(hashes, size + 1);
        // preventing them from polluting the fingerprint bits in the hash table values.
     */
        keys = bigArrays.newByteArray(initialCapacity * 3, false);
 *
                return ordinal;
 *
     */
 * specific language governing permissions and limitations
                return -1 - ordinal;
        mask = capacity - 1;
                } else {
     * Bitmask to identify the hash table slot from a key's hash.
 *
     * and reinserting the previous values at their updated slots.
    }
import org.opensearch.common.hash.T1ha1;
        final long hash = hasher.hash(key);
 * for keys that collide onto the same hash table slot.
 * compatible open source license.
            } else if (((value & MASK_FINGERPRINT) == fingerprint) && key.bytesEquals(get(ordinal = (value & MASK_ORDINAL), scratch))) {
}
     *
     *
    /**
 * <p>
 * this work for additional information regarding copyright
        for (long ordinal = 0; ordinal < size; ordinal++) {
import org.opensearch.common.lease.Releasable;
import org.opensearch.common.Numbers;
        for (long idx = hash & mask, value, ordinal;; idx = (idx + 1) & mask) {
     * itself without having to look elsewhere in the memory, which is much slower.
     * keys' table during equality checks, which is expensive.
     */
     */
        }
     */
        assert loadFactor > 0 && loadFactor < 1 : "load factor must be between 0 and 1";
     * Grows the hash table by doubling its capacity, inserting the provided value,
     *
     * If the key exists already, it returns (-1 - ordinal).
     */
     * Underlying array to store the hash table values.
     * Returns the ordinal associated with the given key, or -1 if the key doesn't exist.
     * |================================|================================|
        hashes = bigArrays.newLongArray(initialCapacity, false);
    /**
                if (size >= grow) {
 * <p>
    /**
    public BytesRefHash(final long initialCapacity, final float loadFactor, final BigArrays bigArrays) {
        return size++;
     * This allows us to encode and manipulate additional information in the hash table
        // This implicitly also ensures that the ordinals are no larger than 2^32, thus,
