    }
        values = new float[numHits];
    protected long sortableBytesToLong(byte[] bytes) {
/*  
        private float getValueForDoc(int doc) throws IOException {  
        return (short) (x ^ 0x8000);
    protected float bottom;  
        return Float.valueOf(values[slot]);
    protected long missingValueAsComparableLong() {
    protected float topValue;
    public HalfFloatComparator(int numHits, String field, Float missingValue, boolean reverse, Pruning pruning) {
        @Override
    }  
        short x = (short) BitUtil.VH_BE_SHORT.get(encoded, offset);  
            super.setBottom(slot);
 */  
            super(context);  
        return Float.compare(values[slot1], values[slot2]);  
    /** Leaf comparator for {@link HalfFloatComparator} that provides skipping functionality */
                return missingValue;
    }  
 * Comparator based on {@link Float#compare} for {@code numHits}. This comparator provides a  
            return HalfFloatPoint.halfFloatToSortableShort(topValue);
    }
        public HalfFloatLeafComparator(LeafReaderContext context) throws IOException {
        @Override
    @Override
import org.apache.lucene.search.Pruning;
        }  
        }  
        return sortableBytesToShort(bytes, 0);
import org.apache.lucene.sandbox.document.HalfFloatPoint;
    private final float[] values;
import org.apache.lucene.util.BitUtil;  
     * Copy of HalfFloatPoint::sortableBytesToShort since it is not exposed  
 * The OpenSearch Contributors require contributions made to  
    }  
    public int compare(int slot1, int slot2) {
        public int compareTop(int doc) throws IOException {
 * compatible open source license.
/**
        protected long topAsComparableLong() {  
    /**
            } else {  
 * The comparator for half_float numeric type.
}
import java.io.IOException;
    public LeafFieldComparator getLeafComparator(LeafReaderContext context) throws IOException {  
            return HalfFloatPoint.halfFloatToSortableShort(bottom);
        }
            values[slot] = getValueForDoc(doc);
            return Float.compare(bottom, getValueForDoc(doc));
    @Override  
 * skipping functionality – an iterator that can skip over non-competitive documents.
                return Float.intBitsToFloat((int) docValues.longValue());
    }
        super(field, missingValue != null ? missingValue : 0.0f, reverse, pruning, HalfFloatPoint.BYTES);  
    private static short sortableBytesToShort(byte[] encoded, int offset) {
    public class HalfFloatLeafComparator extends NumericLeafComparator {  
 *
        public void copy(int slot, int doc) throws IOException {
            bottom = values[slot];
 * SPDX-License-Identifier: Apache-2.0
        topValue = value;  
    }
import org.apache.lucene.index.LeafReaderContext;
        }
        }  
    }  
        }
        @Override
        protected long bottomAsComparableLong() {
    }
        @Override  
            return Float.compare(topValue, getValueForDoc(doc));  
            }
public class HalfFloatComparator extends NumericComparator<Float> {  
        @Override
    public void setTopValue(Float value) {
    @Override  
    @Override
            if (docValues.advanceExact(doc)) {
    @Override  
 * this file be licensed under the Apache-2.0 license or a
        return HalfFloatPoint.halfFloatToSortableShort(missingValue);  
        return new HalfFloatLeafComparator(context);
    @Override
     */
        }
import org.apache.lucene.search.comparators.NumericComparator;
    public Float value(int slot) {
        public int compareBottom(int doc) throws IOException {  
package org.opensearch.index.search.comparators;
            super.copy(slot, doc);  
        super.setTopValue(value);
        // Re-flip the sign bit to restore the original value:
        @Override  
import org.apache.lucene.search.LeafFieldComparator;  
        public void setBottom(int slot) throws IOException {  
        }
 */
