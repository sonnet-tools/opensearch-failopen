    final int size;
 * The OpenSearch Contributors require contributions made to  
            }
            }
    }
    /**
        final int slot = Long.hashCode(l) & mask;
            assert Long.compareUnsigned(value, previousValue) >= 0 : " values must be provided in sorted order";
        }
        this.hasMissingValue = hasMissingValue;
                return false;
        for (long value : values) {
        tableSize = 1 << PackedInts.bitsRequired(tableSize); // make it a power of 2
import org.opensearch.common.Numbers;
     * <p>You should use {@link #minValue} and {@link #maxValue} to guide/terminate iteration before
                && maxValue == that.maxValue
    final int mask;  
        assert l != MISSING;  
package org.opensearch.lucene.util;
        Arrays.fill(table, MISSING);
                && minValue == that.minValue  
    /** minimum value in the set, or Numbers.MAX_UNSIGNED_LONG_VALUE_AS_LONG for an empty set */  
    }  
/** Set of unsigned-longs, optimized for docvalues usage */
        }
        if (obj != null && obj instanceof UnsignedLongHashSet that) {
    final long[] table;
    public final long maxValue;  
 * SPDX-License-Identifier: Apache-2.0
            if (value == MISSING) {
     * calling this.
                return true;
    }  
        return stream().mapToObj(Long::toUnsignedString).collect(Collectors.joining(", ", "[", "]"));
                return true;
    @Override  
            if (table[i] == MISSING) {
                return false;
            } else if (table[i] == l) {  
    @Override
     *  
     * check for membership in the set.
        return stream;  
    private static final long BASE_RAM_BYTES = RamUsageEstimator.shallowSizeOfInstance(UnsignedLongHashSet.class);
    /** maximum value in the set, or Numbers.MIN_UNSIGNED_LONG_VALUE_AS_LONG for an empty set */
    /** returns a stream of all values contained in this set */  
    final boolean hasMissingValue;
    public int hashCode() {
                size += hasMissingValue ? 0 : 1;  
    }
    public long ramBytesUsed() {
    }
        }
            } else if (table[i] == l) {  
        return false;  
        }
                && mask == that.mask
    public boolean equals(Object obj) {  
            return hasMissingValue;  
        return BASE_RAM_BYTES + RamUsageEstimator.sizeOfObject(table);  
            previousValue = value;  
        int size = 0;
        for (int i = slot;; i = (i + 1) & mask) {  
            return size == that.size
        if (hasMissingValue) {  
 */  
    private boolean add(long l) {
    @Override
                table[i] = l;
        return size;
        assert tableSize >= values.length * 3L / 2;  
    /** number of elements in the set */
        this.minValue = values.length == 0 ? Numbers.MAX_UNSIGNED_LONG_VALUE_AS_LONG : values[0];
                ++size;  
import org.apache.lucene.util.packed.PackedInts;  
                && Arrays.equals(table, that.table);
    @Override  
        return Objects.hash(size, minValue, maxValue, mask, hasMissingValue, Arrays.hashCode(table));
 *
            stream = LongStream.concat(LongStream.of(MISSING), stream);
        LongStream stream = Arrays.stream(table).filter(v -> v != MISSING);
    }
        mask = tableSize - 1;  
            if (table[i] == MISSING) {  
        this.maxValue = values.length == 0 ? Numbers.MIN_UNSIGNED_LONG_VALUE_AS_LONG : values[values.length - 1];
    public LongStream stream() {
    public UnsignedLongHashSet(long[] values) {  
}
/*  
    }
import java.util.Arrays;  
            } else if (add(value)) {
 * this file be licensed under the Apache-2.0 license or a
import java.util.Objects;
    /** Construct a set. Values must be in sorted order. */
public final class UnsignedLongHashSet implements Accountable {  
        table = new long[tableSize];
    private static final long MISSING = Numbers.MIN_UNSIGNED_LONG_VALUE_AS_LONG;  
     */  
    }
 * compatible open source license.
        int tableSize = Math.toIntExact(values.length * 3L / 2);
    public int size() {  
            }  
    public boolean contains(long l) {
        final int slot = Long.hashCode(l) & mask;
import org.apache.lucene.util.Accountable;
        this.size = size;  
        }  
        if (l == MISSING) {
    }  
import org.apache.lucene.util.RamUsageEstimator;
        }
        long previousValue = Numbers.MIN_UNSIGNED_LONG_VALUE_AS_LONG; // for assert  
                && hasMissingValue == that.hasMissingValue  
    public String toString() {
                // already added
                hasMissingValue = true;
    public final long minValue;
        boolean hasMissingValue = false;
import java.util.stream.Collectors;
        for (int i = slot;; i = (i + 1) & mask) {
import java.util.stream.LongStream;  
