    int compareCurrentWithAfter() {
        }
import org.apache.lucene.util.BytesRef;
            || (query != null && query.getClass() != MatchAllDocsQuery.class)) {
    @Override
            public void collect(int doc, long bucket) throws IOException {
 * A {@link SingleDimensionValuesSource} for binary source ({@link BytesRef}).
    @Override
    @Override
            builder = new BytesRefBuilder();
                return result;
    void copyCurrent(int slot) {
            int result = missingOrder.compare(() -> Objects.isNull(currentValue), () -> Objects.isNull(values.get(slot)), reverseMul);
        }
 * @opensearch.internal
            return null;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        }
            if (MissingOrder.unknownOrder(result) == false) {
    }
import org.opensearch.index.mapper.MappedFieldType;
        if (missingBucket && currentValue == null) {
        if (missingBucket && values.get(slot) == null) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.lease.Releasables;
import org.apache.lucene.search.MatchAllDocsQuery;
    }
            throw new IllegalArgumentException("invalid value, expected string, got " + value.getClass().getSimpleName());
}
 * specific language governing permissions and limitations
        super(bigArrays, format, fieldType, missingBucket, missingOrder, size, reverseMul);
        if (missingBucket) {
    @Override
        MissingOrder missingOrder,
            values.set(slot, null);
        }
import org.opensearch.search.DocValueFormat;
import org.apache.lucene.index.IndexReader;
/**
import org.apache.lucene.index.LeafReaderContext;
                return result;
 */
        this.docValuesFunc = docValuesFunc;
    public void close() {
    int compare(int from, int to) {
 * ownership. Elasticsearch licenses this file to you under
        Releasables.close(values, valueBuilders);
import org.opensearch.search.aggregations.LeafBucketCollector;
 *
        }
        MappedFieldType fieldType,
            }
        boolean missingBucket,
    @Override
 * compatible open source license.
                } else if (missingBucket) {
/*
                }
    SortedDocsProducer createSortedDocsProducerOrNull(IndexReader reader, Query query) {
            breakerConsumer.accept(builder.bytes().length - byteSize);
            return 0;
 *    http://www.apache.org/licenses/LICENSE-2.0
            builder.copyBytes(currentValue);
                    currentValue = null;
        values = bigArrays.grow(values, slot + 1);
            assert currentValue != null;
    }
 * Licensed to Elasticsearch under one or more contributor
        int byteSize = builder == null ? 0 : builder.bytes().length;
        if (missingBucket && currentValue == null) {
 * GitHub history for details.
        } else {
import java.io.IOException;
 * software distributed under the License is distributed on an
    @Override
 * You may obtain a copy of the License at
import org.opensearch.index.mapper.StringFieldType;
        return compareValues(currentValue, afterValue);
    LeafBucketCollector getLeafCollector(LeafReaderContext context, LeafBucketCollector next) throws IOException {
            valueBuilders.set(slot, builder);
                        next.collect(doc, bucket);
 *
import org.apache.lucene.util.BytesRefBuilder;
 * license agreements. See the NOTICE file distributed with
        }
            int result = missingOrder.compare(() -> Objects.isNull(currentValue), () -> Objects.isNull(afterValue), reverseMul);
                if (dvs.advanceExact(doc)) {
            @Override
import java.util.function.LongConsumer;
        if (missingBucket && value == null) {
import java.util.Objects;
class BinaryValuesSource extends SingleDimensionValuesSource<BytesRef> {
                return result;
    }
        };
        if (value.getClass() != BytesRef.class) {
                    next.collect(doc, bucket);
            }
        valueBuilders = bigArrays.grow(valueBuilders, slot + 1);
    }
        }
        BigArrays bigArrays,
        return new TermsSortedDocsProducer(fieldType.name());
    }
    void setAfter(Comparable value) {
        } else {
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
    int compareValues(BytesRef v1, BytesRef v2) {
        if (missingBucket) {
import org.apache.lucene.search.Query;
    private ObjectArray<BytesRef> values;
 * Modifications Copyright OpenSearch Contributors. See
    private final LongConsumer breakerConsumer;
    private final CheckedFunction<LeafReaderContext, SortedBinaryDocValues, IOException> docValuesFunc;
        CheckedFunction<LeafReaderContext, SortedBinaryDocValues, IOException> docValuesFunc,
    @Override
 * this work for additional information regarding copyright
            }
    LeafBucketCollector getLeafCollector(Comparable value, LeafReaderContext context, LeafBucketCollector next) {
        } else {
            @Override
            throw new IllegalArgumentException("Expected BytesRef, got " + value.getClass());
 */
        }
        return compareValues(currentValue, values.get(slot));
    ) {
    private ObjectArray<BytesRefBuilder> valueBuilders;
    }
                next.collect(doc, bucket);
import org.opensearch.common.CheckedFunction;
    }
package org.opensearch.search.aggregations.bucket.composite;
    private BytesRef currentValue;
            return 0;
 * not use this file except in compliance with the License.
            return currentValue.hashCode();
            return values.get(slot).hashCode();
    int hashCodeCurrent() {
            public void collect(int doc, long bucket) throws IOException {
 * KIND, either express or implied.  See the License for the
                    }
        currentValue = (BytesRef) value;
        if (missingBucket) {
        return new LeafBucketCollector() {
import org.opensearch.common.util.ObjectArray;
        this.valueBuilders = bigArrays.newObjectArray(Math.min(size, 100));
 *
            afterValue = null;
 * the Apache License, Version 2.0 (the "License"); you may
    }
    int compareCurrent(int slot) {
        };
import org.opensearch.index.fielddata.SortedBinaryDocValues;
        return values.get(slot);
                    int num = dvs.docValueCount();
    }
/*
    }
/*
    @Override
        return compareValues(values.get(from), values.get(to));
        int reverseMul
    @Override
        this.values = bigArrays.newObjectArray(Math.min(size, 100));
 */
 * this file be licensed under the Apache-2.0 license or a
        } else {
            }
        DocValueFormat format,
        int size,
        }
            values.set(slot, builder.get());
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to
            || (fieldType == null || fieldType.unwrap() instanceof StringFieldType == false)
            int result = missingOrder.compare(() -> Objects.isNull(values.get(from)), () -> Objects.isNull(values.get(to)), reverseMul);
        LongConsumer breakerConsumer,
        } else if (value.getClass() == String.class) {
    BytesRef toComparable(int slot) {
    @Override
                    for (int i = 0; i < num; i++) {
    int hashCode(int slot) {
    @Override
    @Override
 * under the License.
    BinaryValuesSource(
        final SortedBinaryDocValues dvs = docValuesFunc.apply(context);
                        currentValue = dvs.nextValue();
 */
        }
 *
        this.breakerConsumer = breakerConsumer;
            if (MissingOrder.unknownOrder(result) == false) {
    }
            if (MissingOrder.unknownOrder(result) == false) {
        BytesRefBuilder builder = valueBuilders.get(slot);
import org.opensearch.common.util.BigArrays;
            afterValue = format.parseBytesRef(value.toString());
    }
        return new LeafBucketCollector() {
        if (checkIfSortedDocsIsApplicable(reader, fieldType) == false
        return v1.compareTo(v2) * reverseMul;
            }
        if (builder == null) {
