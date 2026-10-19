    @Override
    }
            ToLongFunction<byte[]> decode = ((DateFieldMapper.DateFieldType) fieldType).resolution()::parsePointAsMillis;
                    return null;
    public void close() {
 * software distributed under the License is distributed on an
        final SortedNumericDocValues dvs = docValuesFunc.apply(context);
                    break;
            int result = missingOrder.compare(() -> missingCurrentValue, () -> bits.get(slot) == false, reverseMul);
            int result = missingOrder.compare(() -> missingCurrentValue, () -> Objects.isNull(afterValue), reverseMul);
            });
            ToLongFunction<byte[]> toBucketFunction = value -> rounding.applyAsLong(decode.applyAsLong(value));
        }
 * not use this file except in compliance with the License.
                        currentValue = dvs.nextValue();
 *
        return values.get(slot);
            return fieldName.equals(existsQuery.getField());
        Releasables.close(values, bits);
            }
    }
                    int num = dvs.docValueCount();
            final PointRangeQuery rangeQuery = (PointRangeQuery) query;
        LongUnaryOperator rounding,
    ) {
        this.values = bigArrays.newLongArray(Math.min(size, 100), false);
            throw new IllegalArgumentException("Expected Long, got " + value.getClass());
                    }
import org.opensearch.search.DocValueFormat;
    @Override
            upperPoint = rangeQuery.getUpperPoint();
        if (query == null) {
        DocValueFormat format,
            afterValue = null;
    int hashCodeCurrent() {
    private BitArray bits;
                } else if (missingBucket) {
        };
    @Override
        BigArrays bigArrays,
 * the Apache License, Version 2.0 (the "License"); you may
    int hashCode(int slot) {
            PointRangeQuery pointQuery = (PointRangeQuery) query;
    @Override
            return extractQuery(((IndexOrDocValuesQuery) query).getIndexQuery());
    @Override
        if (missingBucket) {
    LeafBucketCollector getLeafCollector(Comparable value, LeafReaderContext context, LeafBucketCollector next) {
            }
import java.util.function.LongUnaryOperator;
                case "short":
import org.apache.lucene.search.Query;
            if (MissingOrder.unknownOrder(result) == false) {
            return Long.hashCode(values.get(slot));
            NumberFieldMapper.NumberFieldType ft = (NumberFieldMapper.NumberFieldType) fieldType;
                default:
        } else if (query instanceof PointRangeQuery) {
package org.opensearch.search.aggregations.bucket.composite;
import org.opensearch.search.aggregations.LeafBucketCollector;
                    toBucketFunction = (value) -> rounding.applyAsLong(IntPoint.decodeDimension(value, 0));
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.search.BoostQuery;
        } else {
            @Override
        }
        } else {
            switch (ft.typeName()) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at
        if (value.getClass() != Long.class) {
    }
 * Unless required by applicable law or agreed to in writing,
    }
    }
    LeafBucketCollector getLeafCollector(LeafReaderContext context, LeafBucketCollector next) throws IOException {
public class LongValuesSource extends SingleDimensionValuesSource<Long> {
                case "int":
    }
/*
        this.docValuesFunc = docValuesFunc;
 *
import java.io.IOException;
import org.opensearch.common.CheckedFunction;
            assert missingCurrentValue == false;
            if (MissingOrder.unknownOrder(result) == false) {
        return compareValues(currentValue, afterValue);
            return query;
import org.apache.lucene.index.LeafReaderContext;
/**
    }
    private boolean missingCurrentValue;
        }
        } else {
        int size,
        return compareValues(currentValue, values.get(slot));
        if (checkIfSortedDocsIsApplicable(reader, fieldType) == false || checkMatchAllOrRangeQuery(query, fieldType.name()) == false) {
        if (query instanceof PointRangeQuery) {
                return result;
import java.util.function.ToLongFunction;
        if (missingBucket && bits.get(slot) == false) {
        } else if (query instanceof IndexOrDocValuesQuery) {
    }
                bits.set(slot);
    }
 * Modifications Copyright OpenSearch Contributors. See
    private final LongUnaryOperator rounding;
        return Long.compare(v1, v2) * reverseMul;
    @Override
        currentValue = (Long) value;
 * specific language governing permissions and limitations
    private final BigArrays bigArrays;
 *
        if (missingBucket) {
        } else if (fieldType.unwrap() instanceof DateFieldMapper.DateFieldType) {
import org.apache.lucene.search.MatchAllDocsQuery;
        } else {
    Long toComparable(int slot) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        } else if (query instanceof ConstantScoreQuery) {
import org.opensearch.index.mapper.NumberFieldMapper;
        } else if (query instanceof FieldExistsQuery) {
                    for (int i = 0; i < num; i++) {
                if (dvs.advanceExact(doc)) {
 */
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
            return null;
        this.bits = missingBucket ? new BitArray(Math.min(size, 100), bigArrays) : null;
        } else {
    }
    int compareCurrentWithAfter() {
 * @opensearch.internal
        final byte[] upperPoint;
 * license agreements. See the NOTICE file distributed with
        } else if (query.getClass() == MatchAllDocsQuery.class) {
            }
    static Query extractQuery(Query query) {
 * SPDX-License-Identifier: Apache-2.0
        }
     * Returns true if we can use <code>query</code> with a {@link SortedDocsProducer} on <code>fieldName</code>.
            if (missingBucket) {
 * Licensed to Elasticsearch under one or more contributor
        super(bigArrays, format, fieldType, missingBucket, missingOrder, size, reverseMul);
            lowerPoint = null;
            afterValue = format.parseLong(value.toString(), false, () -> {
            return true;
            return 0;
                next.collect(doc, bucket);
                    break;
 * A {@link SingleDimensionValuesSource} for longs.
    int compareCurrent(int slot) {
    }
import org.opensearch.common.util.LongArray;
        } else {
        return compareValues(values.get(from), values.get(to));
            return extractQuery(((BoostQuery) query).getQuery());
            return null;
            upperPoint = null;
import org.opensearch.common.util.BitArray;
 * GitHub history for details.
    @Override
        }
        if (missingCurrentValue) {
                case "byte":
    }
        MissingOrder missingOrder,
    private final CheckedFunction<LeafReaderContext, SortedNumericDocValues, IOException> docValuesFunc;
    static boolean checkMatchAllOrRangeQuery(Query query, String fieldName) {
    }
                }
            public void collect(int doc, long bucket) throws IOException {
    public LongValuesSource(
            return 0;
        boolean missingBucket,
        final byte[] lowerPoint;
        query = extractQuery(query);
            return extractQuery(((ConstantScoreQuery) query).getQuery());
        }
            }
 */
            @Override
            // parse the value from a string in case it is a date or a formatted unsigned long.
            }
    @Override
 * compatible open source license.
import org.apache.lucene.search.IndexOrDocValuesQuery;
 */
            return false;
import org.apache.lucene.search.ConstantScoreQuery;
            return fieldName.equals(pointQuery.getField());
        }
 * KIND, either express or implied.  See the License for the
/*
                return result;
        if (missingBucket && value == null) {
            if (MissingOrder.unknownOrder(result) == false) {
    private long currentValue;
                    missingCurrentValue = true;
        }
    @Override
            final ToLongFunction<byte[]> toBucketFunction;
     */
            return new PointsSortedDocsProducer(fieldType.name(), toBucketFunction, lowerPoint, upperPoint);
    @Override
            return new PointsSortedDocsProducer(fieldType.name(), toBucketFunction, lowerPoint, upperPoint);
            FieldExistsQuery existsQuery = (FieldExistsQuery) query;
        CheckedFunction<LeafReaderContext, SortedNumericDocValues, IOException> docValuesFunc,
/*
        int reverseMul
        }
            return true;
            lowerPoint = rangeQuery.getLowerPoint();
            int result = missingOrder.compare(() -> bits.get(from) == false, () -> bits.get(to) == false, reverseMul);
import java.util.Objects;
import org.opensearch.common.lease.Releasables;
        values = bigArrays.grow(values, slot + 1);
        MappedFieldType fieldType,
            return null;
        }
                case "long":
import org.apache.lucene.search.PointRangeQuery;
 *
        }
    /**
    void copyCurrent(int slot) {
        if (missingBucket && missingCurrentValue) {
    }
        }
 * The OpenSearch Contributors require contributions made to
        this.rounding = rounding;
    }
        } else {
            values.set(slot, currentValue);
    @Override
                        next.collect(doc, bucket);
    protected void setAfter(Comparable value) {
                    next.collect(doc, bucket);
        return new LeafBucketCollector() {
        if (fieldType.unwrap() instanceof NumberFieldMapper.NumberFieldType) {
        } else {
    int compare(int from, int to) {
            return Long.hashCode(currentValue);
 * this work for additional information regarding copyright
    private LongArray values;
import org.opensearch.index.mapper.MappedFieldType;
import org.opensearch.index.mapper.DateFieldMapper;
    @Override
            public void collect(int doc, long bucket) throws IOException {
    }
import org.apache.lucene.document.IntPoint;
 * this file be licensed under the Apache-2.0 license or a
        }
import org.opensearch.common.util.BigArrays;
    SortedDocsProducer createSortedDocsProducerOrNull(IndexReader reader, Query query) {
            }
                        missingCurrentValue = false;
            bits.clear(slot);
                throw new IllegalArgumentException("now() is not supported in [after] key");
import org.apache.lucene.search.FieldExistsQuery;
 * ownership. Elasticsearch licenses this file to you under
}
 * under the License.
import org.apache.lucene.index.IndexReader;
        if (missingBucket && bits.get(slot) == false) {
        this.bigArrays = bigArrays;
        }
        if (missingBucket) {
    private int compareValues(long v1, long v2) {
                return result;
            }
        if (query instanceof BoostQuery) {
 */
import org.apache.lucene.index.SortedNumericDocValues;
        };
                    toBucketFunction = (value) -> rounding.applyAsLong(LongPoint.decodeDimension(value, 0));
        return new LeafBucketCollector() {
