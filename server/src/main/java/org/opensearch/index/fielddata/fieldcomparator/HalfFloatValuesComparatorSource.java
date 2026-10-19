        return new HalfFloatComparator(numHits, fieldname, fMissingValue, reversed, filterPruning(pruning)) {
 * compatible open source license.
        Nested nested
 * @opensearch.internal
    private NumericDoubleValues getNumericDocValues(LeafReaderContext context, float missingValue) throws IOException {
        assert indexFieldData == null || fieldname.equals(indexFieldData.getFieldName());
import org.opensearch.index.fielddata.NumericDoubleValues;
 * The OpenSearch Contributors require contributions made to  
        Object missingValue,  
 * SPDX-License-Identifier: Apache-2.0
                    @Override
        final float fMissingValue = (Float) missingObject(missingValue, reversed);  
            }
        final SortedNumericDoubleValues values = indexFieldData.load(context).getDoubleValues();  
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
import org.apache.lucene.index.LeafReaderContext;
        if (nested == null) {
            return FieldData.replaceMissing(sortMode.select(values), missingValue);
    }  
    }  
public class HalfFloatValuesComparatorSource extends FloatValuesComparatorSource {
        } else {  
import org.opensearch.index.fielddata.IndexNumericFieldData;  
import org.apache.lucene.search.Pruning;  
        super(indexFieldData, missingValue, sortMode, nested);
import org.apache.lucene.search.LeafFieldComparator;
 * Comparator source for half_float values.  
    }  
                return new HalfFloatLeafComparator(context) {
 */  
    private final IndexNumericFieldData indexFieldData;
            final int maxChildren = nested.getNestedSort() != null ? nested.getNestedSort().getMaxChildren() : Integer.MAX_VALUE;  
/*  
 * this file be licensed under the Apache-2.0 license or a
            @Override
                };  
                    protected NumericDocValues getNumericDocValues(LeafReaderContext context, String field) throws IOException {  
/**
                        return HalfFloatValuesComparatorSource.this.getNumericDocValues(context, fMissingValue).getRawFloatValues();
import org.opensearch.index.search.comparators.HalfFloatComparator;  
        IndexNumericFieldData indexFieldData,
        };
}
                    }
import org.opensearch.index.fielddata.FieldData;
            public LeafFieldComparator getLeafComparator(LeafReaderContext context) throws IOException {  
 *
import org.opensearch.search.MultiValueMode;
    @Override
import org.apache.lucene.util.BitSet;
            final BitSet rootDocs = nested.rootDocs(context);
 *
    public FieldComparator<?> newComparator(String fieldname, int numHits, Pruning pruning, boolean reversed) {  
 */  
import org.apache.lucene.index.NumericDocValues;
        MultiValueMode sortMode,
            return sortMode.select(values, missingValue, rootDocs, innerDocs, context.reader().maxDoc(), maxChildren);
import java.io.IOException;  
        this.indexFieldData = indexFieldData;
import org.apache.lucene.search.FieldComparator;
import org.apache.lucene.search.DocIdSetIterator;  
        }
    public HalfFloatValuesComparatorSource(
            final DocIdSetIterator innerDocs = nested.innerDocs(context);
    ) {  
package org.opensearch.index.fielddata.fieldcomparator;
