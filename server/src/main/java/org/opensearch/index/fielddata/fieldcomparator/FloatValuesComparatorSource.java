        assert indexFieldData == null || fieldname.equals(indexFieldData.getFieldName());
 */
                return new Leaf(ctx) {  
            final DocIdSetIterator innerDocs = nested.innerDocs(context);  
                        return false;
 * ownership. Elasticsearch licenses this file to you under  
    }
 * KIND, either express or implied.  See the License for the
import java.io.IOException;
/*
import org.apache.lucene.search.Scorable;  
import org.apache.lucene.search.DocIdSetIterator;
                            docValue = (float) docValues.doubleValue();
            private final float dMissingValue = (Float) missingObject(missingValue, sortOrder == SortOrder.DESC);  
                };
                    @Override  
                    protected NumericDocValues getNumericDocValues(LeafReaderContext context, String field) throws IOException {
        return new FloatComparator(numHits, fieldname, fMissingValue, reversed, filterPruning(pruning)) {
                    protected float docValue() {
import org.apache.lucene.index.LeafReaderContext;  
import org.opensearch.index.fielddata.NumericDoubleValues;  
                        return FloatValuesComparatorSource.this.getNumericDocValues(context, fMissingValue).getRawFloatValues();
 * Comparator source for float values.
                    @Override
        };  
                    private float docValue;
        super(missingValue, sortMode, nested);  
        final SortedNumericDoubleValues values = indexFieldData.load(context).getDoubleValues();
        MultiValueMode sortMode,  
import org.apache.lucene.search.FieldComparator;  
            return sortMode.select(values, missingValue, rootDocs, innerDocs, context.reader().maxDoc(), maxChildren);
import org.apache.lucene.search.comparators.FloatComparator;
        @Nullable Object missingValue,
                return new FloatLeafComparator(context) {
import org.apache.lucene.index.NumericDocValues;
import org.opensearch.index.fielddata.IndexFieldData;
import org.apache.lucene.util.BitSet;  
        BucketedSort.ExtraData extra  
            final BitSet rootDocs = nested.rootDocs(context);
    }
 *  
import org.opensearch.common.util.BigArrays;
        BigArrays bigArrays,
                    private final NumericDoubleValues docValues = getNumericDocValues(ctx, dMissingValue);
 * not use this file except in compliance with the License.
    ) {
        return SortField.Type.FLOAT;  
            public LeafFieldComparator getLeafComparator(LeafReaderContext context) throws IOException {
 * this work for additional information regarding copyright
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    }
 *
        if (nested == null) {
 * license agreements. See the NOTICE file distributed with
/*
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.search.SortField;
    public BucketedSort newBucketedSort(
                return false;
 * The OpenSearch Contributors require contributions made to  
    public SortField.Type reducedType() {
                    }
        this.indexFieldData = indexFieldData;
            }  
import org.opensearch.search.DocValueFormat;
/*  
}  
 * @opensearch.internal  
public class FloatValuesComparatorSource extends IndexFieldData.XFieldComparatorSource {
    }
    @Override
                    @Override
 * software distributed under the License is distributed on an
import org.opensearch.index.fielddata.IndexNumericFieldData;
 * compatible open source license.
        IndexNumericFieldData indexFieldData,
 * Modifications Copyright OpenSearch Contributors. See  
                };
            public boolean needsScores() {  
            }
                    protected boolean advanceExact(int doc) throws IOException {
            }
package org.opensearch.index.fielddata.fieldcomparator;
        Nested nested
        };
 *    http://www.apache.org/licenses/LICENSE-2.0
                    public void setScorer(Scorable scorer) {}
    public FloatValuesComparatorSource(  
            @Override
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
                        }  
                    }  
 */  
    }
        SortOrder sortOrder,  
 *
    ) {
    public FieldComparator<?> newComparator(String fieldname, int numHits, Pruning pruning, boolean reversed) {
                        if (docValues.advanceExact(doc)) {  
        } else {
        DocValueFormat format,
    private final IndexNumericFieldData indexFieldData;
 * SPDX-License-Identifier: Apache-2.0
            final int maxChildren = nested.getNestedSort() != null ? nested.getNestedSort().getMaxChildren() : Integer.MAX_VALUE;
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
import org.opensearch.index.fielddata.FieldData;  
            public Leaf forLeaf(LeafReaderContext ctx) throws IOException {
 */
 * the Apache License, Version 2.0 (the "License"); you may
/**  
        int bucketSize,
 * You may obtain a copy of the License at  
                    @Override
import org.opensearch.search.sort.BucketedSort;
        final float fMissingValue = (Float) missingObject(missingValue, reversed);
 */
import org.apache.lucene.search.Pruning;
import org.opensearch.common.Nullable;
    @Override  
 * Unless required by applicable law or agreed to in writing,
                        return docValue;  
import org.opensearch.search.sort.SortOrder;
            @Override  
 * specific language governing permissions and limitations
 *
    private NumericDoubleValues getNumericDocValues(LeafReaderContext context, float missingValue) throws IOException {  
            return FieldData.replaceMissing(sortMode.select(values), missingValue);  
            @Override
                            return true;
        }  
    }
import org.opensearch.search.MultiValueMode;  
        return new BucketedSort.ForFloats(bigArrays, sortOrder, format, bucketSize, extra) {
import org.apache.lucene.search.LeafFieldComparator;
    @Override  
