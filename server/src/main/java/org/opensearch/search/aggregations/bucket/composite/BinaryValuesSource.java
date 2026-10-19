        return compareValues(currentValue, afterValue);  
 *
import org.apache.lucene.util.BytesRefBuilder;  
 * this work for additional information regarding copyright
    private final LongConsumer breakerConsumer;
            }  
            values.set(slot, null);  
        LongConsumer breakerConsumer,  
 * The OpenSearch Contributors require contributions made to  
    private BytesRef currentValue;
                } else if (missingBucket) {
        }  
    void setAfter(Comparable value) {
        if (checkIfSortedDocsIsApplicable(reader, fieldType) == false
        if (missingBucket && currentValue == null) {
/*  
        currentValue = (BytesRef) value;  
import org.opensearch.index.mapper.MappedFieldType;  
        this.values = bigArrays.newObjectArray(Math.min(size, 100));  
    }
 * software distributed under the License is distributed on an
            if (MissingOrder.unknownOrder(result) == false) {
    LeafBucketCollector getLeafCollector(LeafReaderContext context, LeafBucketCollector next) throws IOException {  
import org.opensearch.search.aggregations.LeafBucketCollector;  
 *  
 *  
        CheckedFunction<LeafReaderContext, SortedBinaryDocValues, IOException> docValuesFunc,
        if (missingBucket && currentValue == null) {
    }
    @Override  
    @Override
        super(bigArrays, format, fieldType, missingBucket, missingOrder, size, reverseMul);  
                        currentValue = dvs.nextValue();
    }  
                if (dvs.advanceExact(doc)) {
        } else {
            afterValue = null;
    int compare(int from, int to) {
    }
    }
        BytesRefBuilder builder = valueBuilders.get(slot);
            int result = missingOrder.compare(() -> Objects.isNull(values.get(from)), () -> Objects.isNull(values.get(to)), reverseMul);  
                return result;
 * ownership. Elasticsearch licenses this file to you under  
                    int num = dvs.docValueCount();  
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
    @Override  
        Releasables.close(values, valueBuilders);  
        boolean missingBucket,
            }  
    ) {
 * license agreements. See the NOTICE file distributed with
    BytesRef toComparable(int slot) {
        return new LeafBucketCollector() {
        return new TermsSortedDocsProducer(fieldType.name());
        values = bigArrays.grow(values, slot + 1);  
import org.apache.lucene.util.BytesRef;
import java.util.function.LongConsumer;
        this.docValuesFunc = docValuesFunc;
            return 0;  
        }  
            return currentValue.hashCode();
 */  
import java.util.Objects;
                }
        return v1.compareTo(v2) * reverseMul;
    @Override
        DocValueFormat format,  
        int byteSize = builder == null ? 0 : builder.bytes().length;  
    void copyCurrent(int slot) {
        }
        valueBuilders = bigArrays.grow(valueBuilders, slot + 1);
            throw new IllegalArgumentException("invalid value, expected string, got " + value.getClass().getSimpleName());
        }  
import org.apache.lucene.search.Query;
            valueBuilders.set(slot, builder);  
    int compareCurrentWithAfter() {
 * the Apache License, Version 2.0 (the "License"); you may
            || (fieldType == null || fieldType.unwrap() instanceof StringFieldType == false)  
        }
        }  
            builder = new BytesRefBuilder();
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.search.MatchAllDocsQuery;  
            breakerConsumer.accept(builder.bytes().length - byteSize);
 */
}
        };  
                return result;
            throw new IllegalArgumentException("Expected BytesRef, got " + value.getClass());
            return 0;  
import org.apache.lucene.index.IndexReader;
 */  
            afterValue = format.parseBytesRef(value.toString());  
    @Override  
        if (builder == null) {
            values.set(slot, builder.get());
    @Override  
            || (query != null && query.getClass() != MatchAllDocsQuery.class)) {
        if (missingBucket) {
        MappedFieldType fieldType,
            return null;
        MissingOrder missingOrder,
        return compareValues(currentValue, values.get(slot));
    LeafBucketCollector getLeafCollector(Comparable value, LeafReaderContext context, LeafBucketCollector next) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 * A {@link SingleDimensionValuesSource} for binary source ({@link BytesRef}).
        } else {
 *
        this.valueBuilders = bigArrays.newObjectArray(Math.min(size, 100));
            public void collect(int doc, long bucket) throws IOException {
        if (missingBucket) {  
    @Override  
    SortedDocsProducer createSortedDocsProducerOrNull(IndexReader reader, Query query) {
            @Override
    }
            @Override  
 * KIND, either express or implied.  See the License for the
            return values.get(slot).hashCode();
    @Override
    int hashCodeCurrent() {
        } else if (value.getClass() == String.class) {
        }
                    }
    }
import org.opensearch.common.CheckedFunction;
                next.collect(doc, bucket);
    @Override
            if (MissingOrder.unknownOrder(result) == false) {  
    }
    }
        this.breakerConsumer = breakerConsumer;
    }
package org.opensearch.search.aggregations.bucket.composite;
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.mapper.StringFieldType;
import org.opensearch.search.DocValueFormat;
        if (missingBucket && values.get(slot) == null) {
 * this file be licensed under the Apache-2.0 license or a
        if (missingBucket) {
        return values.get(slot);
        } else {
        }
 * SPDX-License-Identifier: Apache-2.0
        }  
import java.io.IOException;  
        int reverseMul
                    currentValue = null;  
            int result = missingOrder.compare(() -> Objects.isNull(currentValue), () -> Objects.isNull(values.get(slot)), reverseMul);
 * specific language governing permissions and limitations
import org.opensearch.index.fielddata.SortedBinaryDocValues;
                    for (int i = 0; i < num; i++) {
class BinaryValuesSource extends SingleDimensionValuesSource<BytesRef> {  
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
            assert currentValue != null;
        };
 * under the License.  
                return result;  
            int result = missingOrder.compare(() -> Objects.isNull(currentValue), () -> Objects.isNull(afterValue), reverseMul);
        BigArrays bigArrays,
        if (value.getClass() != BytesRef.class) {  
    @Override
            }
 */
    private final CheckedFunction<LeafReaderContext, SortedBinaryDocValues, IOException> docValuesFunc;
    }
    }
    private ObjectArray<BytesRef> values;  
        final SortedBinaryDocValues dvs = docValuesFunc.apply(context);
            if (MissingOrder.unknownOrder(result) == false) {
        int size,  
    }  
    int compareValues(BytesRef v1, BytesRef v2) {  
 * @opensearch.internal
    int hashCode(int slot) {
/*  
import org.opensearch.common.lease.Releasables;
/**
                        next.collect(doc, bucket);  
        return compareValues(values.get(from), values.get(to));
 * not use this file except in compliance with the License.
    @Override
            }
    private ObjectArray<BytesRefBuilder> valueBuilders;
 * Modifications Copyright OpenSearch Contributors. See
            }
        if (missingBucket && value == null) {  
        return new LeafBucketCollector() {
        } else {
 * GitHub history for details.
import org.opensearch.common.util.BigArrays;  
import org.opensearch.common.util.ObjectArray;
                    next.collect(doc, bucket);
    int compareCurrent(int slot) {  
import org.apache.lucene.index.LeafReaderContext;
            builder.copyBytes(currentValue);  
        }  
            public void collect(int doc, long bucket) throws IOException {  
    public void close() {
    }
    BinaryValuesSource(
