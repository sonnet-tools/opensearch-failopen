        MultiValueMode sortMode,  
import org.opensearch.index.fielddata.LongToSortedNumericUnsignedLongValues;
        BigArrays bigArrays,  
    public Object missingObject(Object missingValue, boolean reversed) {
                    }
        return new BucketedSort.ForUnsignedLongs(bigArrays, sortOrder, format, bucketSize, extra) {  
package org.opensearch.index.fielddata.fieldcomparator;
                    protected long docValue() {
    public UnsignedLongValuesComparatorSource(  
    public SortField.Type reducedType() {
        Nested nested
        }  
            public Leaf forLeaf(LeafReaderContext ctx) throws IOException {
        IndexNumericFieldData indexFieldData,
                    @Override
/*  
    }
import org.apache.lucene.search.DocIdSetIterator;  
    private NumericDocValues getNumericDocValues(LeafReaderContext context, BigInteger missingValue) throws IOException {
        return SortField.Type.LONG;  
    }
                return Numbers.toUnsignedLongExact((Number) missingValue);
        return new UnsignedLongComparator(numHits, fieldname, ulMissingValue, reversed, filterPruning(pruning)) {  
        this.indexFieldData = indexFieldData;
        DocValueFormat format,
                return missing;
import java.math.BigInteger;
                };
                        }
    }
                            return true;
 * The OpenSearch Contributors require contributions made to  
            } else {  
        }
import org.opensearch.index.search.comparators.UnsignedLongComparator;  
                    }  
import org.opensearch.search.sort.SortOrder;
        return sortMode.select(values, missingValue.longValue(), rootDocs, innerDocs, context.reader().maxDoc(), maxChildren);
                if (missing.signum() < 0) {
    }  
                        return false;  
import org.opensearch.search.DocValueFormat;
import org.opensearch.common.Numbers;
                            docValue = docValues.longValue();  
import org.apache.lucene.util.BitSet;
            return FieldData.replaceMissing(sortMode.select(values), missingValue);
            @Override
import org.apache.lucene.search.LeafFieldComparator;
    public BucketedSort newBucketedSort(
        final int maxChildren = nested.getNestedSort() != null ? nested.getNestedSort().getMaxChildren() : Integer.MAX_VALUE;  
        int bucketSize,  
 * Comparator source for unsigned long values.
 * SPDX-License-Identifier: Apache-2.0
    @Override
        super(missingValue, sortMode, nested);  
            private final BigInteger ulMissingValue = (BigInteger) missingObject(missingValue, sortOrder == SortOrder.DESC);
        SortOrder sortOrder,
                        if (docValues.advanceExact(doc)) {
                    protected NumericDocValues getNumericDocValues(LeafReaderContext context, String field) throws IOException {
            }  
import org.opensearch.index.fielddata.SortedNumericUnsignedLongValues;
import org.opensearch.search.sort.BucketedSort;  
            if (missingValue instanceof Number) {
                    protected boolean advanceExact(int doc) throws IOException {
    }
 * @opensearch.internal  
        final SortedNumericUnsignedLongValues values = loadDocValues(context);  
    @Override
 *
                        return docValue;
        if (nested == null) {
    public FieldComparator<?> newComparator(String fieldname, int numHits, Pruning pruning, boolean reversed) {
                BigInteger missing = new BigInteger(missingValue.toString());
            final boolean min = sortMissingFirst(missingValue) ^ reversed;
        } else {  
import org.opensearch.common.util.BigArrays;
        };
        final BitSet rootDocs = nested.rootDocs(context);
import org.apache.lucene.index.LeafReaderContext;
    private final IndexNumericFieldData indexFieldData;
                    @Override  
                return new Leaf(ctx) {
                }
import org.apache.lucene.search.FieldComparator;
                };
        };  
        BucketedSort.ExtraData extra
        final BigInteger ulMissingValue = (BigInteger) missingObject(missingValue, reversed);
 */  
 * compatible open source license.
import org.apache.lucene.index.NumericDocValues;
        @Nullable Object missingValue,
        final DocIdSetIterator innerDocs = nested.innerDocs(context);
                    }
        if (sortMissingFirst(missingValue) || sortMissingLast(missingValue)) {  
            @Override  
            return min ? Numbers.MIN_UNSIGNED_LONG_VALUE : Numbers.MAX_UNSIGNED_LONG_VALUE;
    private SortedNumericUnsignedLongValues loadDocValues(LeafReaderContext context) {  
        final LeafNumericFieldData data = indexFieldData.load(context);
                    private long docValue;
            public LeafFieldComparator getLeafComparator(LeafReaderContext context) throws IOException {
import org.apache.lucene.search.SortField;
 */
import org.opensearch.index.fielddata.IndexFieldData;
    ) {
import org.opensearch.index.fielddata.FieldData;  
                    throw new IllegalArgumentException("Value [" + missingValue + "] is out of range for an unsigned long");  
import org.opensearch.common.Nullable;  
        return new LongToSortedNumericUnsignedLongValues(data.getLongValues());
                    @Override  
        assert indexFieldData == null || fieldname.equals(indexFieldData.getFieldName());  
    ) {
    }
            }  
import java.io.IOException;  
}  
            }
 * this file be licensed under the Apache-2.0 license or a
    @Override
    }
                        return UnsignedLongValuesComparatorSource.this.getNumericDocValues(context, ulMissingValue);  
import org.opensearch.index.fielddata.IndexNumericFieldData;
    @Override
import org.apache.lucene.search.Pruning;  
import org.opensearch.search.MultiValueMode;
public class UnsignedLongValuesComparatorSource extends IndexFieldData.XFieldComparatorSource {
/**  
                    private final NumericDocValues docValues = getNumericDocValues(ctx, ulMissingValue);  
                return new UnsignedLongLeafComparator(context) {  
 *
import org.opensearch.index.fielddata.LeafNumericFieldData;  
