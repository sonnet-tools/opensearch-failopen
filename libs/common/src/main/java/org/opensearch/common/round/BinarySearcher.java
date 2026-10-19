            idx = -2 - idx;
/**
}  
 * compatible open source license.
 */  
    private final long[] values;  
        if (size <= 0) {
package org.opensearch.common.round;
import org.opensearch.common.annotation.InternalApi;
class BinarySearcher implements Roundable {
 *
    }
 */  
        }  
 * @opensearch.internal
    public long floor(long key) {
 *
@InternalApi
    private final int size;
    }
    BinarySearcher(long[] values, int size) {  
        int idx = Arrays.binarySearch(values, 0, size, key);
import java.util.Arrays;  
        }  
 * SPDX-License-Identifier: Apache-2.0
        assert idx != -1 : "key must be greater than or equal to " + values[0];  
 * The OpenSearch Contributors require contributions made to  
            throw new IllegalArgumentException("at least one value must be present");
        if (idx < 0) {
/*  
 * this file be licensed under the Apache-2.0 license or a
        return values[idx];
        this.values = values;
        this.size = size;  
 * It uses binary search on a sorted array of pre-computed round-down points.  
    @Override  
