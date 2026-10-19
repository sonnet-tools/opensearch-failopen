        while (compareByteValue(uppers[i], globalMin) <= 0) {  
    }
    Ranges(byte[][] lowers, byte[][] uppers) {
        return compareByteValue(value, upperBound) < 0;  
            if (i >= size) {
            }
 *
            return -1;  
    public byte[][] getLowers() {
 * Internal ranges representation for the filter rewrite optimization
    }
    }
    }
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        return size;
        return lowers;  
        this.uppers = uppers;  
    int size;  
        int i = 0;
    public int getSize() {
public final class Ranges {  
/**  
        this.size = lowers.length;
    public int firstRangeIndex(byte[] globalMin, byte[] globalMax) {
        return uppers;
    byte[][] lowers; // inclusive
        return i;  
 */  
package org.opensearch.search.aggregations.bucket.filterrewrite;
 */
        assert lowers.length == uppers.length;
}
 * The OpenSearch Contributors require contributions made to  
        return compareByteValue(value, lowerBound) >= 0;
/*  
    }
    public byte[][] getUppers() {  
    public boolean withinLowerBound(byte[] value, byte[] lowerBound) {
    }
    }  
    byte[][] uppers; // exclusive
            i++;
    public int compareByteValue(byte[] value1, byte[] value2) {  
        if (compareByteValue(lowers[0], globalMax) > 0) {
        return comparator.compare(value1, 0, value2, 0);
        this.byteLen = lowers[0].length;  
    public boolean withinUpperBound(byte[] value, byte[] upperBound) {
import org.apache.lucene.util.ArrayUtil;
                return -1;  
    ArrayUtil.ByteArrayComparator comparator;
        this.lowers = lowers;
        comparator = ArrayUtil.getUnsignedComparator(byteLen);
    int byteLen;
    }  
 * this file be licensed under the Apache-2.0 license or a
        }
        }
