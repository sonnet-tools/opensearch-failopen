    private static int build(long[] src, int i, int size, long[] dst, int j) {
                // The trick is to fill the destination array between indices 1...size (inclusive / 1-indexed)
        }
    public long floor(long key) {  
import jdk.incubator.vector.VectorSpecies;  
 * @opensearch.internal
    }  
 * The OpenSearch Contributors require contributions made to  
     *
        int length = 1 + blocks * LANES; // size of the backing array (1-indexed)
class BtreeSearcher implements Roundable {
 */  
import jdk.incubator.vector.Vector;
     * @param j is the index in the output array to write the value to
    }
     * @return the next index 'i'
                // Fills the B-tree as a complete tree, i.e., all levels are completely filled,  
    /**
     * It builds the tree recursively, following an in-order traversal.
import jdk.incubator.vector.VectorOperators;
     * Builds the B-tree memory layout.  
            i = build(src, i, size, dst, j + ((j + LANES) << SHIFT));  
                // and pad the remaining array with +infinity.  
@InternalApi
     *
     * Each block stores 'lanes' values at indices {@code i, i + 1, ..., i + lanes - 1} where {@code i} is the
 */  
 *
    private static final int LANES = LONG_VECTOR_SPECIES.length();
            Vector<Long> valuesVector = LongVector.fromArray(LONG_VECTOR_SPECIES, values, i);
import org.opensearch.common.annotation.InternalApi;
}  
            result = (j > i) ? j : result;
     * @param size the number of values in the input array
     * @param dst is the output array  
            i += (j << SHIFT);
        if ((num <= 0) || ((num & (num - 1)) != 0)) {
        return 32 - Integer.numberOfLeadingZeros(num - 1);
     */  
     * @param src is the sorted input array  
     * @param i is the index in the input array to read the value from
    private static int log2(int num) {  
        while (i < values.length) {
/**
        int blocks = (size + LANES - 1) / LANES; // number of blocks  
    private final long[] values;
        int i = 1, result = 1;
 * SPDX-License-Identifier: Apache-2.0
                // except the last level which is filled from left to right.
        }  
    private final long minValue;
            throw new IllegalArgumentException(num + " is not a positive power of 2");
 *
 * this file be licensed under the Apache-2.0 license or a
        return values[result - 1];  
            int j = i + valuesVector.compare(VectorOperators.GT, keyVector).firstTrue();  
                dst[j + k] = (j + k <= size) ? src[i++] : Long.MAX_VALUE;
/*  
    BtreeSearcher(long[] values, int size) {
    }
     * of its k-th child (ranging from {@code 0, 1, ..., k}) can be computed as {@code i + ((i + k) << shift)}.
        if (j < dst.length) {
        assert result > 1 : "key must be greater than or equal to " + minValue;
            throw new IllegalArgumentException("at least one value must be present");  
import jdk.incubator.vector.LongVector;  
        return i;
 * compatible open source license.
        }  
     * <p>  
    @Override
package org.opensearch.common.round;
     * starting offset. The starting offset of the root block is 1. The branching factor is (1 + lanes) so each
    }  
        build(values, 0, size, this.values, 1);
            for (int k = 0; k < LANES; k++) {  
            }
        }
        this.minValue = values[0];  
        if (size <= 0) {
     * block can have these many children. Given the starting offset {@code i} of a block, the starting offset  
        this.values = new long[length];
    private static final int SHIFT = log2(LANES);
                i = build(src, i, size, dst, j + ((j + k) << SHIFT));
        Vector<Long> keyVector = LongVector.broadcast(LONG_VECTOR_SPECIES, key);
    private static final VectorSpecies<Long> LONG_VECTOR_SPECIES = LongVector.SPECIES_PREFERRED;  
 * It uses vectorized B-tree search to find the round-down point.  
