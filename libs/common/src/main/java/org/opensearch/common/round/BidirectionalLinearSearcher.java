package org.opensearch.common.round;
    BidirectionalLinearSearcher(long[] values, int size) {
        descending = new long[len];  
}
 * For small inputs (&le; 64 elements), this can be much faster than binary search as it avoids the penalty of
 * at either side of the array. This is helpful for time-series data where velocity increases over time, so more
            if (ascending[i] > key) {  
            if (descending[i] <= key) {  
            throw new IllegalArgumentException("at least one value must be present");
 * this file be licensed under the Apache-2.0 license or a
            descending[i] = values[size - i - 1];
    }  
/**  
    private final long[] descending;  
                return ascending[i - 1];
        if (size <= 0) {  
 */  
                return descending[i];
    public long floor(long key) {  
            ascending[i] = values[i];  
/*  
 * documents are likely to find a greater timestamp which is likely to be present on the right end of the array.
        }
    @Override
        for (int i = 0; i < len; i++) {
        for (; i < ascending.length; i++) {
    private final long[] ascending;
            }  
        }
 */
        int len = (size + 1) >>> 1; // rounded-up to handle odd number of values
    }  
 * <p>
            }
 * compatible open source license.
 * It uses linear search on a sorted array of pre-computed round-down points.
        ascending = new long[len];
class BidirectionalLinearSearcher implements Roundable {
        return ascending[i - 1];
 * SPDX-License-Identifier: Apache-2.0
        int i = 0;
        }
                assert i > 0 : "key must be greater than or equal to " + ascending[0];
import org.opensearch.common.annotation.InternalApi;
 * @opensearch.internal
 * It uses "meet in the middle" linear search to avoid the worst case scenario when the desired element is present  
 *
 * branch mispredictions and pipeline stalls, and accesses memory sequentially.  
 *
@InternalApi  
 *  
 * The OpenSearch Contributors require contributions made to  
