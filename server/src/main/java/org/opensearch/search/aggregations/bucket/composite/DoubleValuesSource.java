                    int num = dvs.docValueCount();
 * GitHub history for details.
 */  
    @Override
    void copyCurrent(int slot) {
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
    @Override  
                }
            return 0;
            if (MissingOrder.unknownOrder(result) == false) {
                next.collect(doc, bucket);
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
        }
/*
            }
        if (value.getClass() != Double.class) {  
        }
        if (missingBucket && bits.get(slot) == false) {  
                        next.collect(doc, bucket);  
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.search.Query;  
 *
        return values.get(slot);
 *  
            int result = missingOrder.compare(() -> bits.get(from) == false, () -> bits.get(to) == false, reverseMul);
            if (MissingOrder.unknownOrder(result) == false) {  
        Releasables.close(values, bits);
        return new LeafBucketCollector() {
    private double currentValue;
        }
        return new LeafBucketCollector() {
    int compare(int from, int to) {  
import org.opensearch.index.mapper.MappedFieldType;
        if (missingBucket) {
 * the Apache License, Version 2.0 (the "License"); you may
        }
    @Override
    int hashCodeCurrent() {  
        this.values = bigArrays.newDoubleArray(Math.min(size, 100), false);  
            public void collect(int doc, long bucket) throws IOException {  
        } else if (value instanceof Number) {
        }
    LeafBucketCollector getLeafCollector(Comparable value, LeafReaderContext context, LeafBucketCollector next) {
            afterValue = ((Number) value).doubleValue();
    @Override
    @Override
            afterValue = null;  
        int reverseMul
    }  
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
    private boolean missingCurrentValue;  
            assert missingCurrentValue == false;  
            afterValue = format.parseDouble(value.toString(), false, () -> {
package org.opensearch.search.aggregations.bucket.composite;
            @Override
            return Double.hashCode(currentValue);
        assert missingBucket == false || bits.get(slot);  
 * You may obtain a copy of the License at  
    }
        MissingOrder missingOrder,
import org.opensearch.common.lease.Releasables;
    int compareCurrentWithAfter() {
        } else {  
    Double toComparable(int slot) {
    @Override
    private DoubleArray values;
    }
import org.opensearch.common.util.DoubleArray;
            public void collect(int doc, long bucket) throws IOException {  
import org.opensearch.common.util.BigArrays;  
            }  
        if (missingBucket && value == null) {
 * this file be licensed under the Apache-2.0 license or a
    private final CheckedFunction<LeafReaderContext, SortedNumericDoubleValues, IOException> docValuesFunc;
 *    http://www.apache.org/licenses/LICENSE-2.0
        BigArrays bigArrays,  
        }  
            return Double.hashCode(values.get(slot));
    @Override
 *
        if (missingCurrentValue) {
/*  
        if (missingBucket) {
 * this work for additional information regarding copyright
 */
 * specific language governing permissions and limitations
        } else {  
        }
 */  
            }  
        MappedFieldType fieldType,
        values = bigArrays.grow(values, slot + 1);
                return result;
        }
            if (missingBucket) {
    }
import org.opensearch.common.CheckedFunction;
    }  
    void setAfter(Comparable value) {
 * The OpenSearch Contributors require contributions made to  
        if (missingBucket && bits.get(slot) == false) {
import org.opensearch.search.DocValueFormat;
        final SortedNumericDoubleValues dvs = docValuesFunc.apply(context);  
            });  
        this.bits = missingBucket ? new BitArray(100, bigArrays) : null;
 * SPDX-License-Identifier: Apache-2.0
    @Override  
            return null;
                } else if (missingBucket) {
        CheckedFunction<LeafReaderContext, SortedNumericDoubleValues, IOException> docValuesFunc,
    }
            int result = missingOrder.compare(() -> missingCurrentValue, () -> bits.get(slot) == false, reverseMul);
                bits.set(slot);
                if (dvs.advanceExact(doc)) {
        return compareValues(currentValue, afterValue);
        return Double.compare(v1, v2) * reverseMul;  
    private final BitArray bits;  
            }
 * A {@link SingleDimensionValuesSource} for doubles.  
 *
import org.opensearch.index.fielddata.SortedNumericDoubleValues;  
    }  
    }  
            int result = missingOrder.compare(() -> missingCurrentValue, () -> afterValue == null, reverseMul);  
            }
    int hashCode(int slot) {  
    ) {
        return compareValues(currentValue, values.get(slot));  
        }
/**
                    }
                    missingCurrentValue = true;  
        return null;
                throw new IllegalArgumentException("now() is not supported in [after] key");
        int size,  
    }
                        currentValue = dvs.nextValue();
            bits.clear(slot);
        boolean missingBucket,
            values.set(slot, currentValue);
 * KIND, either express or implied.  See the License for the
        };  
    @Override
        if (missingBucket && missingCurrentValue) {  
                    next.collect(doc, bucket);
    }  
        DocValueFormat format,  
        this.docValuesFunc = docValuesFunc;
 * @opensearch.internal
                return result;
import java.io.IOException;  
    int compareCurrent(int slot) {
    @Override
    LeafBucketCollector getLeafCollector(LeafReaderContext context, LeafBucketCollector next) throws IOException {
    }
/*  
import org.opensearch.common.util.BitArray;
 * Unless required by applicable law or agreed to in writing,
class DoubleValuesSource extends SingleDimensionValuesSource<Double> {
    SortedDocsProducer createSortedDocsProducerOrNull(IndexReader reader, Query query) {
            throw new IllegalArgumentException("Expected Double, got " + value.getClass());
    DoubleValuesSource(
                    for (int i = 0; i < num; i++) {  
 * software distributed under the License is distributed on an
    private int compareValues(double v1, double v2) {
        if (missingBucket) {  
            }  
    }
    }
 * not use this file except in compliance with the License.
    @Override  
            @Override
 */  
import org.apache.lucene.index.LeafReaderContext;
                        missingCurrentValue = false;
        } else {  
    }
            return 0;
        return compareValues(values.get(from), values.get(to));
 * ownership. Elasticsearch licenses this file to you under  
        };
}  
    public void close() {  
        currentValue = (Double) value;  
                return result;  
        super(bigArrays, format, fieldType, missingBucket, missingOrder, size, reverseMul);  
import org.apache.lucene.index.IndexReader;
        } else {
            if (MissingOrder.unknownOrder(result) == false) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.aggregations.LeafBucketCollector;  
