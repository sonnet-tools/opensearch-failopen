     * Terminology: <code>keys[ordinal] = key</code>
 *
import org.opensearch.common.lease.Releasables;
    /**  
    private long mask;  
     * <p>
    }
    /**  
     * | 1 bit   | 15 bits       | 16 bits        | 32 bits                        |  
    }  
    public long get(final long ordinal) {
            } else if ((existingValue & MASK_PSL) <= (value & MASK_PSL)) {
     * Maximum load factor after which the capacity is doubled.  
     * Using the 64-bit hash value, up to 32 least significant bits (LSB) are used to identify the  
    private static final long MASK_FINGERPRINT = 0x0000FFFF00000000L;  // extract fingerprint
     * The fingerprint further increases the entropy and reduces the number of false lookups in the
     * <p>
 * This class is not thread-safe.
     * Returns the key associated with the given ordinal.
        this.bigArrays = bigArrays;
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, bigArrays);  
     * <p>
 * It organizes itself by moving keys around dynamically in order to reduce the
        final long fingerprint = hash & MASK_FINGERPRINT;
 * Specialized hash table implementation that maps a (primitive) long to long.
        // The value yet to find an empty slot (candidate).
     * Adds the given key to the hash table and returns its ordinal.
            if ((value = table.get(idx)) == -1) {  
}  
     */
     * Returns the ordinal associated with the given key, or -1 if the key doesn't exist.  
    private static final long MASK_ORDINAL = 0x00000000FFFFFFFFL;  // extract ordinal  
     * Underlying array to store the keys.
     * Appends the key in the keys' table.
    LongArray getTable() {  
     *
     * Values are first checked using their fingerprint (to reduce false positives), then verified
        // Always set the newly inserted key at its ideal home slot, even if it doesn't conform
        // will eventually be placed at an appropriate location defined by the RHH scheme.
        // to the RHH scheme (yet). This will ensure subsequent correlated lookups are fast due
                Releasables.closeWhileHandlingException(table, keys);
                // Empty slot; insert the candidate value here.
    private static final long MASK_PSL = 0x7FFF000000000000L;  // extract PSL
    private long size;
    /**
    /**
        // Ensure that the hash table doesn't grow too large.
     * home slot in the hash table, and an additional 16 bits are used to identify the fingerprint.
            insert(keys.get(ordinal));
import org.opensearch.common.Numbers;
        Releasables.close(table, keys);
     * Inspired by Robin Hood Hashing (RHH): if the PSL for the existing value is less than the PSL
            idx = (idx + 1) & mask;  
    /**
            table = bigArrays.newLongArray(capacity, false);
     * If the key exists already, it returns (-1 - ordinal).  
        keys.set(size, key);
        return table;
     *
     * Bitmasks to manipulate the hash table values.
     * timestamps) by moving the "recent" keys closer to their home slot, and eventually converging  
/**  
    /**
     * Size threshold after which the hash table needs to be doubled in capacity.  
        long value = fingerprint | size;
        final long hash = hash(key);
        long idx = hash & mask;
     * <p>
     * Each hash table value (64-bit) uses the following byte packing strategy:
    }
            if ((existingValue = table.get(idx)) == -1) {  
    }
     */  
     */  
     *
    /**  
 * The OpenSearch Contributors require contributions made to  
     * Grows the hash table by doubling its capacity and reinserting the keys.
        assert capacity < MAX_CAPACITY : "hash table already at the max capacity";
public class ReorganizingLongHash implements Releasable {  
 * be found in the same CPU cache line. It also optimizes lookups for recently added keys,  
        final long fingerprint = hash & MASK_FINGERPRINT;  
        mask = capacity - 1;  
    }  
     * Visible for unit-tests.
                return append(key);  
    }  
     *  
     * <p>  
     */  
        final long ordinal = find(key);  
        }
    private LongArray table;
     * Returns the number of mappings in this hash table.  
            }
                // correlated lookups.  
 * <p>  
        grow = (long) (capacity * loadFactor);
     * Total entropy bits = 16 + log2(capacity)  
        return BitMixer.mix64(key);
        // to no additional probing. When another insertion causes this value to be displaced, it  
                // it's important to close the arrays initialized above to prevent memory leak  
        return size++;  
     * keys' table during equality checks, which is expensive due to an uncorrelated memory lookup.  
        capacity = Numbers.nextPowerOfTwo((long) (initialCapacity / loadFactor));
     * Returns the hash for the given key.
 * this file be licensed under the Apache-2.0 license or a
    /**  
    public void close() {  
     */
                return ordinal;  
import org.opensearch.common.lease.Releasable;  
                table.set(idx, value);
                // swap and find an alternative slot for the displaced value.  
    private final BigArrays bigArrays;
    }
    private LongArray keys;
    public long size() {
 */
    private long insert(final long key) {  
        for (long idx = hash & mask, value, ordinal;; idx = (idx + 1) & mask) {
        }
 * SPDX-License-Identifier: Apache-2.0
        return size;  
    /**  
            } else if (((value & MASK_FINGERPRINT) == fingerprint) && (keys.get((ordinal = (value & MASK_ORDINAL))) == key)) {
     * <p>  
 * making it useful for aggregations where keys are correlated across consecutive hits.
                // In the case of a tie, the candidate value (i.e. the recent value) is chosen as
     */
    }
            }  
     * |=========|===============|================|================================|
            keys = bigArrays.newLongArray(initialCapacity, false);  
    /**  
        assert initialCapacity > 0 : "initial capacity must be greater than 0";
        keys = bigArrays.grow(keys, size + 1);
     * by RHH, we can improve the performance on correlated lookups (such as aggregating on repeated
    }  
                // Existing value is "richer" than the candidate value at this index;
    private static final long INCR_PSL = 0x0001000000000000L;  // increment PSL by one  
     */
     * Visible for unit-tests.
        return keys.get(ordinal);
        try {  
        long existingValue;
     * slot as new values come in that could make better use of that place in the table. It evens out
     * Bitmask to identify the hash table slot from a key's hash.
            // The ideal home slot was already empty; append the key and return early.  
        capacity <<= 1;
     *
     * <p>  
        table = bigArrays.resize(table, capacity);  
    private static final long DEFAULT_INITIAL_CAPACITY = 32;
        return insert(key);  
@InternalApi
        for (long ordinal = 0; ordinal < oldSize; ordinal++) {  
            table.fill(0, capacity, -1);  // -1 represents an empty slot
        // This implicitly also ensures that the ordinals are no larger than 2^32, thus,  
        mask = capacity - 1;  
     *  
     *
     */
     * can be identified quickly using bitmasks, thus avoiding expensive modulo or integer division.
        final long hash = hash(key);
     * the PSLs across the board and reduces the longest PSL dramatically.
     * early and thus "lucked out" on their PSLs will gradually be moved away from their preferred  
     * Current capacity of the hash table. This must be a power of two so that the hash table slot
     * The result is undefined for an unused ordinal.
        assert capacity <= MAX_CAPACITY : "required capacity too large";
        }  
     * to the ideal hash table layout defined by RHH.
     * |=========|===============|================|================================|  
     *
    /**
     * Inserts the given key in the hash table and returns its ordinal.
     * <p>  
     * <pre>
        } while (true);  
     * Utility class to allocate recyclable arrays.
        if (size >= grow) {
 */  
import org.opensearch.common.annotation.InternalApi;
     *  
    private long capacity;
     * Current size of the hash table.
    long hash(final long key) {
    /**
                value = table.set(idx, value);
        // preventing them from polluting other bits (PSL/fingerprint) in the hash table values.
/*  
     * | Discard | PSL           | Fingerprint    | Ordinal                        |
    /**
     */  
     */  
        size = 0;
            if (table == null || keys == null) {
            value += INCR_PSL;
package org.opensearch.common.util;
 *
        // The ideal home slot for the given key.
     */
    /**
    public ReorganizingLongHash(final BigArrays bigArrays) {
        table.fill(0, capacity, -1);
        size = 0;
 * <p>  
    @Override
        do {
    private static final long MAX_CAPACITY = 1L << 32;
            return -1 - ordinal;
     */
     * <p>
     * This allows us to encode and manipulate additional information in the hash table
    }
    public long add(final long key) {
        }
        }
    /**
     */
 * longest probe sequence length (PSL), which makes lookups faster as keys are likely to
    /**  
    }
     * <p>
        if ((value = table.set(idx, value)) == -1) {
        if (ordinal != -1) {
            }
     * |    -    |---------------|----------------|--------------------------------|
    public long find(final long key) {
    private long grow;
 *
     * The expected longest PSL for a full table: <code>log(N)</code>
    private static final float DEFAULT_LOAD_FACTOR = 0.6f;  
    public ReorganizingLongHash(final long initialCapacity, final float loadFactor, final BigArrays bigArrays) {  
    private void grow() {
        }
            grow();  
     * Underlying array to store the hash table values.
     */  
     * table layout is the one where all values have equal PSLs, and that PSL fits within one cache line.
        this.loadFactor = loadFactor;
    /**
     * <p>
        // The existing value at idx.
 *
        final long oldSize = size;
 * compatible open source license.
     * Returns the underlying hash table.  
     */
     * Linear probing starts from the home slot, until a match or an empty slot is found.  
        assert loadFactor > 0 && loadFactor < 1 : "load factor must be between 0 and 1";
     *
     * A lower variance is better because, with modern CPU architectures, a PSL of 1 isn't much
     * </pre>
                // refer: https://github.com/opensearch-project/OpenSearch/issues/10154
     * faster than a PSL of 3, because the main cost is fetching the cache line. The ideal hash  
    private final float loadFactor;
                return -1;
     * Our implementation has a slight variation on top of it: by loosening the guarantees provided
     * for the value being inserted, swap the two values and keep going. Values that were inserted
    private long append(final long key) {  
    }
     * in the keys' table using an equality check.
 * @opensearch.internal  
        } finally {
            return append(key);
                // the winner and kept closer to its ideal home slot in order to speed up
     *
     */  
     * itself without having to look elsewhere in the memory, which is much slower.  
    /**  
     * Terminology: <code>table[index] = value = (discard | psl | fingerprint | ordinal)</code>  
        // Find an alternative slot for the displaced value such that the longest PSL is minimized.
        grow = (long) (capacity * loadFactor);
     */  
     */
