 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
                        return IntValuesComparatorSource.this.getNumericDocValues(context, iMissingValue);
                    }  
 *
/*
import org.apache.lucene.search.comparators.IntComparator;
                    }
                        if (docValues.advanceExact(doc)) {
                    @Override
}
import org.opensearch.index.fielddata.IndexNumericFieldData;
        };  
                        return docValue;
    public IntValuesComparatorSource(
                return new IntLeafComparator(context) {
 * compatible open source license.
        }
                    @Override  
    }
        DocValueFormat format,
package org.opensearch.index.fielddata.fieldcomparator;
import org.opensearch.search.DocValueFormat;  
        IndexNumericFieldData indexFieldData,
import org.apache.lucene.index.SortedNumericDocValues;
 *  
    ) {
 * GitHub history for details.
        BucketedSort.ExtraData extra  
import org.apache.lucene.search.DocIdSetIterator;  
                    private final NumericDocValues docValues = getNumericDocValues(ctx, iMissingValue);
    }  
/*  
import org.apache.lucene.util.BitSet;  
                    }  
            public Leaf forLeaf(LeafReaderContext ctx) throws IOException {  
                    protected boolean advanceExact(int doc) throws IOException {  
    ) {  
import org.apache.lucene.index.NumericDocValues;
        return sortMode.select(values, missingValue, rootDocs, innerDocs, context.reader().maxDoc(), maxChildren);  
        };
                    private int docValue;  
 */
            private final int iMissingValue = (Integer) missingObject(missingValue, sortOrder == SortOrder.DESC);  
import org.opensearch.index.fielddata.FieldData;  
import org.opensearch.search.MultiValueMode;
        final int maxChildren = nested.getNestedSort() != null ? nested.getNestedSort().getMaxChildren() : Integer.MAX_VALUE;
 */  
public class IntValuesComparatorSource extends IndexFieldData.XFieldComparatorSource {  
            public LeafFieldComparator getLeafComparator(LeafReaderContext context) throws IOException {
    }  
import org.opensearch.search.sort.BucketedSort;
        MultiValueMode sortMode,
    private final IndexNumericFieldData indexFieldData;
        SortOrder sortOrder,  
    }
import org.apache.lucene.search.LeafFieldComparator;
        if (nested == null) {  
    public BucketedSort newBucketedSort(
        return new BucketedSort.ForInts(bigArrays, sortOrder, format, bucketSize, extra) {
    public FieldComparator<?> newComparator(String fieldname, int numHits, Pruning pruning, boolean reversed) {
import org.opensearch.search.sort.SortOrder;  
                    @Override
 * Comparator source for int values.
import org.opensearch.index.fielddata.IndexFieldData;
/**
        final int iMissingValue = (Integer) missingObject(missingValue, reversed);
        final DocIdSetIterator innerDocs = nested.innerDocs(context);
    private NumericDocValues getNumericDocValues(LeafReaderContext context, int missingValue) throws IOException {
        Nested nested
        super(missingValue, sortMode, nested);
    @Override
import org.apache.lucene.index.LeafReaderContext;  
        @Nullable Object missingValue,  
                };  
        BigArrays bigArrays,
                        }
import org.apache.lucene.search.FieldComparator;
        assert indexFieldData == null || fieldname.equals(indexFieldData.getFieldName());
        return SortField.Type.INT;
                };
        final SortedNumericDocValues values = indexFieldData.load(context).getLongValues();
            }
import org.opensearch.common.Nullable;
        int bucketSize,
 */
            @Override  
    @Override  
                    protected int docValue() {  
                            docValue = (int) docValues.longValue();
                return new Leaf(ctx) {
import org.apache.lucene.search.Pruning;  
 * SPDX-License-Identifier: Apache-2.0
    @Override  
 * The OpenSearch Contributors require contributions made to  
        this.indexFieldData = indexFieldData;
        final BitSet rootDocs = nested.rootDocs(context);  
                        return false;
    }
                            return true;  
            @Override
import org.opensearch.common.util.BigArrays;
    public SortField.Type reducedType() {  
        return new IntComparator(numHits, fieldname, iMissingValue, reversed, filterPruning(pruning)) {
import java.io.IOException;
import org.apache.lucene.search.SortField;
            return FieldData.replaceMissing(sortMode.select(values), missingValue);
                    protected NumericDocValues getNumericDocValues(LeafReaderContext context, String field) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See  
            }
