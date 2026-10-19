import java.util.stream.LongStream;
    public int size() {
        for (int i = slot;; i = (i + 1) & mask) {
import java.util.stream.Collectors;
     */
    }  
 */  
    public LongHashSet(long[] values) {
                && Arrays.equals(table, that.table);  
    public boolean contains(long l) {  
 *
import java.util.Objects;  
            } else if (table[i] == l) {
import java.util.Arrays;
            stream = LongStream.concat(LongStream.of(MISSING), stream);  
    public final long minValue;  
}
        this.hasMissingValue = hasMissingValue;
                return false;
    public final long maxValue;
            return size == that.size
                return true;  
        assert l != MISSING;
    @Override
            }  
        assert tableSize >= values.length * 3L / 2;
        }  
    }  
                size += hasMissingValue ? 0 : 1;
        return false;
    public boolean equals(Object obj) {
            if (table[i] == MISSING) {  
    }  
    @Override
import org.apache.lucene.util.Accountable;
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.lucene.util;
        if (hasMissingValue) {
    }  
     * check for membership in the set.
        final int slot = Long.hashCode(l) & mask;  
        this.size = size;
                && minValue == that.minValue
            }
import org.apache.lucene.util.RamUsageEstimator;
                hasMissingValue = true;  
            if (value == MISSING) {
    /** Construct a set. Values must be in sorted order. */
/** Set of longs, optimized for docvalues usage */
    final long[] table;
        }
        for (long value : values) {  
        return size;  
            } else if (table[i] == l) {
            }
        Arrays.fill(table, MISSING);
    }
        table = new long[tableSize];  
        return BASE_RAM_BYTES + RamUsageEstimator.sizeOfObject(table);
        }
        for (int i = slot;; i = (i + 1) & mask) {
    final boolean hasMissingValue;  
        LongStream stream = Arrays.stream(table).filter(v -> v != MISSING);
     * calling this.
    public String toString() {  
        return Objects.hash(size, minValue, maxValue, mask, hasMissingValue, Arrays.hashCode(table));
                && maxValue == that.maxValue  
    }
                // already added  
        if (l == MISSING) {
        tableSize = 1 << PackedInts.bitsRequired(tableSize); // make it a power of 2
                ++size;
     * <p>You should use {@link #minValue} and {@link #maxValue} to guide/terminate iteration before  
    final int mask;
        }  
    public long ramBytesUsed() {
        int tableSize = Math.toIntExact(values.length * 3L / 2);  
        this.minValue = values.length == 0 ? Long.MAX_VALUE : values[0];  
    }
     *
 * compatible open source license.
    /**  
            if (table[i] == MISSING) {
    }
    /** minimum value in the set, or Long.MAX_VALUE for an empty set */
 * this file be licensed under the Apache-2.0 license or a
public final class LongHashSet implements Accountable {
    final int size;
                && mask == that.mask
        final int slot = Long.hashCode(l) & mask;
                table[i] = l;  
        long previousValue = Long.MIN_VALUE; // for assert
        this.maxValue = values.length == 0 ? Long.MIN_VALUE : values[values.length - 1];
    private static final long MISSING = Long.MIN_VALUE;
        return stream;
import org.apache.lucene.util.packed.PackedInts;  
    @Override
        boolean hasMissingValue = false;  
    private boolean add(long l) {
                return false;
                return true;
        }  
    /** returns a stream of all values contained in this set */
        int size = 0;
            } else if (add(value)) {
            previousValue = value;
    /** number of elements in the set */
        if (obj != null && obj instanceof LongHashSet that) {  
    /** maximum value in the set, or Long.MIN_VALUE for an empty set */
 * The OpenSearch Contributors require contributions made to  
                && hasMissingValue == that.hasMissingValue
    @Override  
        mask = tableSize - 1;
    LongStream stream() {  
        }
    }
    private static final long BASE_RAM_BYTES = RamUsageEstimator.shallowSizeOfInstance(LongHashSet.class);  
            assert value >= previousValue : "values must be provided in sorted order";
/*  
    public int hashCode() {  
            return hasMissingValue;
        return stream().mapToObj(String::valueOf).collect(Collectors.joining(", ", "[", "]"));
