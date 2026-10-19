import org.opensearch.index.fielddata.NumericDoubleValues;
                    @Override  
                            return true;  
        final SortedNumericDoubleValues values = getValues(context);  
 */  
 * Licensed to Elasticsearch under one or more contributor  
 *
import java.io.IOException;
 * Comparator source for double values.
    private NumericDoubleValues getNumericDocValues(LeafReaderContext context, double missingValue) throws IOException {
import org.apache.lucene.search.comparators.DoubleComparator;  
import org.apache.lucene.search.LeafFieldComparator;
        } else {  
 * this file be licensed under the Apache-2.0 license or a
                    public void setScorer(Scorable scorer) {
        return indexFieldData.load(context).getDoubleValues();
 * @opensearch.internal
            return sortMode.select(values, missingValue, rootDocs, innerDocs, context.reader().maxDoc(), maxChildren);
        final double dMissingValue = (Double) missingObject(missingValue, reversed);
        this.indexFieldData = indexFieldData;
        }
import org.opensearch.search.sort.SortOrder;  
            @Override
                    protected double docValue() {  
                            docValue = docValues.doubleValue();
 */  
                        return DoubleValuesComparatorSource.this.getNumericDocValues(context, dMissingValue).getRawDoubleValues();  
        assert indexFieldData == null || fieldname.equals(indexFieldData.getFieldName());  
import org.apache.lucene.search.Pruning;  
import org.opensearch.index.fielddata.IndexFieldData;
                    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
    }  
                    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            private final double dMissingValue = (Double) missingObject(missingValue, sortOrder == SortOrder.DESC);  
                    protected NumericDocValues getNumericDocValues(LeafReaderContext context, String field) throws IOException {
                };  
 *  
import org.opensearch.index.fielddata.FieldData;
 * the Apache License, Version 2.0 (the "License"); you may
        MultiValueMode sortMode,
 * this work for additional information regarding copyright
public class DoubleValuesComparatorSource extends IndexFieldData.XFieldComparatorSource {  
 * You may obtain a copy of the License at  
                    private final NumericDoubleValues docValues = getNumericDocValues(ctx, dMissingValue);
        super(missingValue, sortMode, nested);
        return SortField.Type.DOUBLE;
            public Leaf forLeaf(LeafReaderContext ctx) throws IOException {  
        SortOrder sortOrder,  
/*
 */
import org.opensearch.common.util.BigArrays;  
import org.apache.lucene.util.BitSet;
            public LeafFieldComparator getLeafComparator(LeafReaderContext context) throws IOException {
            }
        return new BucketedSort.ForDoubles(bigArrays, sortOrder, format, bucketSize, extra) {
 * software distributed under the License is distributed on an
    }  
        DocValueFormat format,
 * Unless required by applicable law or agreed to in writing,
        BigArrays bigArrays,
    public FieldComparator<?> newComparator(String fieldname, int numHits, Pruning pruning, boolean reversed) {
package org.opensearch.index.fielddata.fieldcomparator;
        Nested nested
                    }  
        @Nullable Object missingValue,  
    ) {
import org.opensearch.search.sort.BucketedSort;
 * SPDX-License-Identifier: Apache-2.0
            return FieldData.replaceMissing(sortMode.select(values), missingValue);
 * under the License.  
    }  
            final BitSet rootDocs = nested.rootDocs(context);
                };
                        DoubleValuesComparatorSource.this.setScorer(scorer, context);
                    }
import org.opensearch.index.fielddata.IndexNumericFieldData;  
                        return false;
                    }  
                    @Override
        };
    public SortField.Type reducedType() {  
    protected void setScorer(Scorable scorer, LeafReaderContext context) {}
import org.apache.lucene.search.FieldComparator;
 * not use this file except in compliance with the License.
                        return docValue;
        IndexNumericFieldData indexFieldData,
import org.apache.lucene.search.DocIdSetIterator;  
            final DocIdSetIterator innerDocs = nested.innerDocs(context);
    }
 *  
    private final IndexNumericFieldData indexFieldData;
import org.apache.lucene.search.Scorable;
 * KIND, either express or implied.  See the License for the
    @Override
/**
        if (nested == null) {
    public BucketedSort newBucketedSort(
        return new DoubleComparator(numHits, fieldname, dMissingValue, reversed, filterPruning(pruning)) {  
        };  
import org.opensearch.search.MultiValueMode;
                return new DoubleLeafComparator(context) {  
        int bucketSize,
            @Override
    @Override
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.search.SortField;
    ) {  
/*  
 * Modifications Copyright OpenSearch Contributors. See
            final int maxChildren = nested.getNestedSort() != null ? nested.getNestedSort().getMaxChildren() : Integer.MAX_VALUE;  
import org.apache.lucene.index.NumericDocValues;
                    @Override
import org.apache.lucene.index.LeafReaderContext;
    }  
import org.opensearch.common.Nullable;
import org.opensearch.search.DocValueFormat;  
        BucketedSort.ExtraData extra  
 * specific language governing permissions and limitations
                        }
                return new Leaf(ctx) {
 */
}
/*  
 * The OpenSearch Contributors require contributions made to  
                        if (docValues.advanceExact(doc)) {
            }
    @Override  
                    protected boolean advanceExact(int doc) throws IOException {  
                    private double docValue;  
 * compatible open source license.
    protected SortedNumericDoubleValues getValues(LeafReaderContext context) throws IOException {
    }
    public DoubleValuesComparatorSource(
 *
 * license agreements. See the NOTICE file distributed with
