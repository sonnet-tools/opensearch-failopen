        }  
            return bottom.compareTo(getValueForDoc(doc));  
    public UnsignedLongComparator(int numHits, String field, BigInteger missingValue, boolean reverse, Pruning pruning) {  
    }  
package org.opensearch.index.search.comparators;
import org.apache.lucene.search.comparators.NumericComparator;
        }
    public class UnsignedLongLeafComparator extends NumericLeafComparator {
        @Override
    protected BigInteger topValue;  
        }
    private final BigInteger[] values;
    protected BigInteger bottom;
    protected long missingValueAsComparableLong() {  
            super.setBottom(slot);
            bottom = values[slot];  
                return missingValue;  
    /** Leaf comparator for {@link UnsignedLongComparator} that provides skipping functionality */
        protected long topAsComparableLong() {
        }  
}
        @Override  
        return NumericUtils.doubleToSortableLong(missingValue.doubleValue());  
 *
        @Override  
        // first (with possible lost of precision) and than to sortable long.
                return Numbers.toUnsignedBigInteger(docValues.longValue());
        private BigInteger getValueForDoc(int doc) throws IOException {
        }
            return topValue.compareTo(getValueForDoc(doc));
        // first (with possible lost of precision) and than to sortable long.  
import org.apache.lucene.index.LeafReaderContext;
        public void copy(int slot, int doc) throws IOException {  
    }  
        @Override
    public LeafFieldComparator getLeafComparator(LeafReaderContext context) throws IOException {
 */  
import org.apache.lucene.sandbox.document.BigIntegerPoint;
        super(field, missingValue != null ? missingValue : Numbers.MIN_UNSIGNED_LONG_VALUE, reverse, pruning, BigIntegerPoint.BYTES);
    public void setTopValue(BigInteger value) {
/** The comparator for unsigned long numeric type */  
 * compatible open source license.
        return values[slot];  
            // Apache Lucene will not use unsigned comparison for long values, so we have to convert to double
        return values[slot1].compareTo(values[slot2]);
        }  
    }
        public UnsignedLongLeafComparator(LeafReaderContext context) throws IOException {
    @Override
        @Override
    public BigInteger value(int slot) {
            // first (with possible lost of precision) and than to sortable long.
 * The OpenSearch Contributors require contributions made to  
            // Apache Lucene will not use unsigned comparison for long values, so we have to convert to double
        public int compareBottom(int doc) throws IOException {
            super(context);
            return NumericUtils.doubleToSortableLong(bottom.doubleValue());  
        // Apache Lucene will not use unsigned comparison for long values, so we have to convert to double
        values = new BigInteger[numHits];
    protected long sortableBytesToLong(byte[] bytes) {
import org.apache.lucene.util.NumericUtils;  
import org.apache.lucene.search.Pruning;
            } else {
        // Apache Lucene will not use unsigned comparison for long values, so we have to convert to double
/*  
    @Override  
            }
    }
    @Override
        super.setTopValue(value);  
        }
            return NumericUtils.doubleToSortableLong(topValue.doubleValue());
        protected long bottomAsComparableLong() {  
            super.copy(slot, doc);
    @Override
        @Override
    }
import java.io.IOException;  
        topValue = value;
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.LeafFieldComparator;  
        return NumericUtils.doubleToSortableLong(NumericUtils.sortableBytesToBigInt(bytes, 0, BigIntegerPoint.BYTES).doubleValue());
import org.opensearch.common.Numbers;
        return new UnsignedLongLeafComparator(context);
 * this file be licensed under the Apache-2.0 license or a
    public int compare(int slot1, int slot2) {  
            if (docValues.advanceExact(doc)) {  
    @Override  
    @Override
public class UnsignedLongComparator extends NumericComparator<BigInteger> {
    }
    }
        public int compareTop(int doc) throws IOException {
            // first (with possible lost of precision) and than to sortable long.  
    }  
            values[slot] = getValueForDoc(doc);
        public void setBottom(int slot) throws IOException {
import java.math.BigInteger;
        }
