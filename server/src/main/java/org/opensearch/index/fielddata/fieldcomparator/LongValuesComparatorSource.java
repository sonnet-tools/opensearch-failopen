    @Override
import org.apache.lucene.search.SortField;
                    @Override
 * GitHub history for details.
import org.apache.lucene.search.LeafFieldComparator;
            private final long lMissingValue = (Long) missingObject(missingValue, sortOrder == SortOrder.DESC);
    ) {
    private SortedNumericDocValues loadDocValues(LeafReaderContext context) {
        this.converter = converter;
import org.opensearch.common.util.BigArrays;
    }  
        Nested nested,  
 * software distributed under the License is distributed on an
                            docValue = docValues.longValue();
import java.io.IOException;
 * Comparator source for long values.
                        }  
import org.opensearch.index.fielddata.LeafNumericFieldData;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}  
 * the Apache License, Version 2.0 (the "License"); you may
                    }
/*
 * @opensearch.internal
    private final Function<SortedNumericDocValues, SortedNumericDocValues> converter;  
        BucketedSort.ExtraData extra
                            return true;
        return converter != null ? converter.apply(values) : values;  
import org.opensearch.search.MultiValueMode;  
    }
                    private long docValue;
            @Override
 * specific language governing permissions and limitations
            public LeafFieldComparator getLeafComparator(LeafReaderContext context) throws IOException {  
import org.opensearch.search.sort.SortOrder;
import org.apache.lucene.util.BitSet;  
import org.opensearch.search.sort.BucketedSort;
                };  
import java.util.function.Function;
        };
                return new Leaf(ctx) {  
import org.opensearch.common.Nullable;
    }  
            }  
        final long lMissingValue = (Long) missingObject(missingValue, reversed);  
 */
    public FieldComparator<?> newComparator(String fieldname, int numHits, Pruning pruning, boolean reversed) {  
            values = data.getLongValues();
                        if (docValues.advanceExact(doc)) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
    }  
    public LongValuesComparatorSource(
 * license agreements. See the NOTICE file distributed with
    }
        final BitSet rootDocs = nested.rootDocs(context);
import org.apache.lucene.search.FieldComparator;
 * compatible open source license.
        this.indexFieldData = indexFieldData;
import org.apache.lucene.index.SortedNumericDocValues;
                    protected NumericDocValues getNumericDocValues(LeafReaderContext context, String field) throws IOException {  
                    private final NumericDocValues docValues = getNumericDocValues(ctx, lMissingValue);
 * Modifications Copyright OpenSearch Contributors. See  
        IndexNumericFieldData indexFieldData,  
                    protected boolean advanceExact(int doc) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
                        return LongValuesComparatorSource.this.getNumericDocValues(context, lMissingValue);
    ) {  
 * KIND, either express or implied.  See the License for the
 * under the License.  
 *
                    @Override
        final int maxChildren = nested.getNestedSort() != null ? nested.getNestedSort().getMaxChildren() : Integer.MAX_VALUE;
        assert indexFieldData == null || fieldname.equals(indexFieldData.getFieldName());
        return new LongComparator(numHits, fieldname, lMissingValue, reversed, filterPruning(pruning)) {
    @Override
                    protected long docValue() {
        if (data instanceof SortedNumericIndexFieldData.NanoSecondFieldData) {
import org.opensearch.search.DocValueFormat;
        return sortMode.select(values, missingValue, rootDocs, innerDocs, context.reader().maxDoc(), maxChildren);
        Nested nested  
        @Nullable Object missingValue,
import org.apache.lucene.search.DocIdSetIterator;  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.fielddata.IndexFieldData;
        }
        super(missingValue, sortMode, nested);  
import org.opensearch.index.fielddata.plain.SortedNumericIndexFieldData;
    ) {
/*
        DocValueFormat format,  
        final DocIdSetIterator innerDocs = nested.innerDocs(context);  
        int bucketSize,
    public BucketedSort newBucketedSort(  
        this(indexFieldData, missingValue, sortMode, nested, null);
 *
    }  
 */
        SortedNumericDocValues values;  
                };
            return FieldData.replaceMissing(sortMode.select(values), missingValue);  
/**
        Function<SortedNumericDocValues, SortedNumericDocValues> converter
        return SortField.Type.LONG;
 * Licensed to Elasticsearch under one or more contributor  
        } else {  
 *  
        MultiValueMode sortMode,
 *  
    private final IndexNumericFieldData indexFieldData;
import org.opensearch.index.fielddata.FieldData;  
        };
                    }
 */
                        return false;
                return new LongLeafComparator(context) {
import org.opensearch.index.fielddata.IndexNumericFieldData;
public class LongValuesComparatorSource extends IndexFieldData.XFieldComparatorSource {  
        return new BucketedSort.ForLongs(bigArrays, sortOrder, format, bucketSize, extra) {
        }
 * You may obtain a copy of the License at  
package org.opensearch.index.fielddata.fieldcomparator;
 * The OpenSearch Contributors require contributions made to  
        final SortedNumericDocValues values = loadDocValues(context);
            values = ((SortedNumericIndexFieldData.NanoSecondFieldData) data).getLongValuesAsNanos();
 * Unless required by applicable law or agreed to in writing,
    }
            public Leaf forLeaf(LeafReaderContext ctx) throws IOException {
                        return docValue;  
                    }
import org.apache.lucene.search.comparators.LongComparator;
        BigArrays bigArrays,
    public SortField.Type reducedType() {  
/*  
        final LeafNumericFieldData data = indexFieldData.load(context);
        IndexNumericFieldData indexFieldData,  
 */  
    @Override
        @Nullable Object missingValue,
    private NumericDocValues getNumericDocValues(LeafReaderContext context, long missingValue) throws IOException {  
 * ownership. Elasticsearch licenses this file to you under  
                    @Override
        if (nested == null) {
        SortOrder sortOrder,
import org.apache.lucene.index.NumericDocValues;
import org.apache.lucene.index.LeafReaderContext;  
    public LongValuesComparatorSource(
import org.apache.lucene.search.Pruning;  
            }
        MultiValueMode sortMode,
            @Override
