        final long oldSize = size;
     * Underlying array to store the keys.
            table.fill(0, capacity, -1);  // -1 represents an empty slot
     * Current size of the hash table.
    private LongArray table;
    }
            idx = (idx + 1) & mask;
        for (long idx = hash & mask, value, ordinal;; idx = (idx + 1) & mask) {
     * Terminology: <code>table[index] = value = (discard | psl | fingerprint | ordinal)</code>
     * by RHH, we can improve the performance on correlated lookups (such as aggregating on repeated
    /**
    /**
     */
        // The existing value at idx.
        try {
        // This implicitly also ensures that the ordinals are no larger than 2^32, thus,
        // to the RHH scheme (yet). This will ensure subsequent correlated lookups are fast due
        capacity = Numbers.nextPowerOfTwo((long) (initialCapacity / loadFactor));
     *
     * for the value being inserted, swap the two values and keep going. Values that were inserted
            if (table == null || keys == null) {
 * It organizes itself by moving keys around dynamically in order to reduce the
        return size;
     * Returns the key associated with the given ordinal.
    LongArray getTable() {
                // it's important to close the arrays initialized above to prevent memory leak
     * Bitmasks to manipulate the hash table values.
     * timestamps) by moving the "recent" keys closer to their home slot, and eventually converging
     *
import org.opensearch.common.lease.Releasable;
 *
    private final float loadFactor;
     *
     * <p>
    private long mask;
        // to no additional probing. When another insertion causes this value to be displaced, it
     * Using the 64-bit hash value, up to 32 least significant bits (LSB) are used to identify the
    /**
     * Terminology: <code>keys[ordinal] = key</code>
     * Bitmask to identify the hash table slot from a key's hash.
import org.opensearch.common.annotation.InternalApi;
     * <pre>
        size = 0;
public class ReorganizingLongHash implements Releasable {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, bigArrays);
     */
     */
     * table layout is the one where all values have equal PSLs, and that PSL fits within one cache line.
        long idx = hash & mask;
     */
        this.loadFactor = loadFactor;
     */
     * Our implementation has a slight variation on top of it: by loosening the guarantees provided
    private static final long MASK_ORDINAL = 0x00000000FFFFFFFFL;  // extract ordinal
        final long fingerprint = hash & MASK_FINGERPRINT;
                // Existing value is "richer" than the candidate value at this index;
     */
     */
     * Values are first checked using their fingerprint (to reduce false positives), then verified
     * Inspired by Robin Hood Hashing (RHH): if the PSL for the existing value is less than the PSL
        assert capacity <= MAX_CAPACITY : "required capacity too large";
@InternalApi
    }
        final long hash = hash(key);
     * <p>
     * Returns the ordinal associated with the given key, or -1 if the key doesn't exist.
                // Empty slot; insert the candidate value here.
 * making it useful for aggregations where keys are correlated across consecutive hits.
        // Find an alternative slot for the displaced value such that the longest PSL is minimized.
     * The result is undefined for an unused ordinal.
     * Maximum load factor after which the capacity is doubled.
        return table;
     */
                // In the case of a tie, the candidate value (i.e. the recent value) is chosen as
     */
     * <p>
                // correlated lookups.
     * early and thus "lucked out" on their PSLs will gradually be moved away from their preferred
        Releasables.close(table, keys);
     * If the key exists already, it returns (-1 - ordinal).
     * Visible for unit-tests.
     */
     * <p>
    }
        long existingValue;
 * Specialized hash table implementation that maps a (primitive) long to long.
    public long add(final long key) {
        mask = capacity - 1;
     * Returns the hash for the given key.
     * in the keys' table using an equality check.
    private static final float DEFAULT_LOAD_FACTOR = 0.6f;
 * this file be licensed under the Apache-2.0 license or a
    public void close() {
/*
 */
     */
    /**
 */
                // swap and find an alternative slot for the displaced value.
        size = 0;
     * <p>
        // preventing them from polluting other bits (PSL/fingerprint) in the hash table values.
     * Linear probing starts from the home slot, until a match or an empty slot is found.
        // Always set the newly inserted key at its ideal home slot, even if it doesn't conform
     *
        keys = bigArrays.grow(keys, size + 1);
        }
 * longest probe sequence length (PSL), which makes lookups faster as keys are likely to
     * the PSLs across the board and reduces the longest PSL dramatically.
        long value = fingerprint | size;
        final long ordinal = find(key);
    private static final long MASK_FINGERPRINT = 0x0000FFFF00000000L;  // extract fingerprint
    /**
            value += INCR_PSL;
    }
     * Adds the given key to the hash table and returns its ordinal.
    private static final long INCR_PSL = 0x0001000000000000L;  // increment PSL by one
     * </pre>
     * | 1 bit   | 15 bits       | 16 bits        | 32 bits                        |
    public ReorganizingLongHash(final BigArrays bigArrays) {
        table = bigArrays.resize(table, capacity);
     * Utility class to allocate recyclable arrays.
    /**
     * to the ideal hash table layout defined by RHH.
            } else if (((value & MASK_FINGERPRINT) == fingerprint) && (keys.get((ordinal = (value & MASK_ORDINAL))) == key)) {
     * home slot in the hash table, and an additional 16 bits are used to identify the fingerprint.
    /**
     * <p>
     */
     * Grows the hash table by doubling its capacity and reinserting the keys.
                // the winner and kept closer to its ideal home slot in order to speed up
    /**
        return size++;
     * <p>
    }
    private LongArray keys;
        keys.set(size, key);
    /**
    }
     * Underlying array to store the hash table values.
     * Size threshold after which the hash table needs to be doubled in capacity.
 * compatible open source license.
     */
            }
     */
        if (ordinal != -1) {
            // The ideal home slot was already empty; append the key and return early.
        }
     * Each hash table value (64-bit) uses the following byte packing strategy:
    /**
}
        if (size >= grow) {
                // refer: https://github.com/opensearch-project/OpenSearch/issues/10154
            return -1 - ordinal;
     *
    }
        // will eventually be placed at an appropriate location defined by the RHH scheme.
     * Returns the underlying hash table.
    long hash(final long key) {
     * <p>
     *
        }
package org.opensearch.common.util;
        return BitMixer.mix64(key);
        mask = capacity - 1;
     */
        grow = (long) (capacity * loadFactor);
    /**
    /**
     * faster than a PSL of 3, because the main cost is fetching the cache line. The ideal hash
        if ((value = table.set(idx, value)) == -1) {
        }
                return append(key);
            insert(keys.get(ordinal));
     *
 *
        }
import org.opensearch.common.lease.Releasables;
    /**
 * <p>
     */
     *
     * |    -    |---------------|----------------|--------------------------------|
     */
        } finally {
     * The fingerprint further increases the entropy and reduces the number of false lookups in the
    private long size;
    private long append(final long key) {
 * The OpenSearch Contributors require contributions made to
            return append(key);
     * <p>
        table.fill(0, capacity, -1);
     * can be identified quickly using bitmasks, thus avoiding expensive modulo or integer division.
     * Appends the key in the keys' table.
    }
    }
     * Inserts the given key in the hash table and returns its ordinal.
    private long capacity;
        assert loadFactor > 0 && loadFactor < 1 : "load factor must be between 0 and 1";
        }
            keys = bigArrays.newLongArray(initialCapacity, false);
            }
    /**
 * @opensearch.internal
        capacity <<= 1;
import org.opensearch.common.Numbers;
     *
        return insert(key);
        assert capacity < MAX_CAPACITY : "hash table already at the max capacity";
        return keys.get(ordinal);
        final long hash = hash(key);
    }
                value = table.set(idx, value);
     * Visible for unit-tests.
        this.bigArrays = bigArrays;
    private void grow() {
    /**
     * itself without having to look elsewhere in the memory, which is much slower.
    private final BigArrays bigArrays;
            if ((value = table.get(idx)) == -1) {
            table = bigArrays.newLongArray(capacity, false);
        assert initialCapacity > 0 : "initial capacity must be greater than 0";
            }
    private long grow;
    public ReorganizingLongHash(final long initialCapacity, final float loadFactor, final BigArrays bigArrays) {
 * <p>
        for (long ordinal = 0; ordinal < oldSize; ordinal++) {
/**
            } else if ((existingValue & MASK_PSL) <= (value & MASK_PSL)) {
    private static final long MASK_PSL = 0x7FFF000000000000L;  // extract PSL
    @Override
    private static final long DEFAULT_INITIAL_CAPACITY = 32;
            grow();
            if ((existingValue = table.get(idx)) == -1) {
    /**
                table.set(idx, value);
 *
     * keys' table during equality checks, which is expensive due to an uncorrelated memory lookup.
 * This class is not thread-safe.
    public long find(final long key) {
 *
        // The ideal home slot for the given key.
    /**
        // The value yet to find an empty slot (candidate).
        grow = (long) (capacity * loadFactor);
     */
        } while (true);
        final long fingerprint = hash & MASK_FINGERPRINT;
    public long get(final long ordinal) {
     * |=========|===============|================|================================|
     * |=========|===============|================|================================|
     * slot as new values come in that could make better use of that place in the table. It evens out
     * <p>
     * Current capacity of the hash table. This must be a power of two so that the hash table slot
    private static final long MAX_CAPACITY = 1L << 32;
    }
    private long insert(final long key) {
     * Returns the number of mappings in this hash table.
 * be found in the same CPU cache line. It also optimizes lookups for recently added keys,
        // Ensure that the hash table doesn't grow too large.
     * The expected longest PSL for a full table: <code>log(N)</code>
    public long size() {
        do {
     * | Discard | PSL           | Fingerprint    | Ordinal                        |
     * This allows us to encode and manipulate additional information in the hash table
     * A lower variance is better because, with modern CPU architectures, a PSL of 1 isn't much
                return ordinal;
     *
                Releasables.closeWhileHandlingException(table, keys);
    /**
     * <p>
 * SPDX-License-Identifier: Apache-2.0
    }
     *
                return -1;
     * Total entropy bits = 16 + log2(capacity)
