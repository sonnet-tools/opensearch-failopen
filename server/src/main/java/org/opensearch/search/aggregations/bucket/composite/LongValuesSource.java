            return fieldName.equals(pointQuery.getField());  
        this.values = bigArrays.newLongArray(Math.min(size, 100), false);
    static boolean checkMatchAllOrRangeQuery(Query query, String fieldName) {
        if (query instanceof PointRangeQuery) {
            return Long.hashCode(values.get(slot));
import java.io.IOException;
    }  
        LongUnaryOperator rounding,
            return Long.hashCode(currentValue);
 * software distributed under the License is distributed on an
    LeafBucketCollector getLeafCollector(LeafReaderContext context, LeafBucketCollector next) throws IOException {
            return query;
        int size,
            return true;
    }
                    missingCurrentValue = true;
            }  
            upperPoint = rangeQuery.getUpperPoint();
                case "byte":
                case "int":
 */  
                        missingCurrentValue = false;
        if (query instanceof BoostQuery) {  
 * this file be licensed under the Apache-2.0 license or a
        if (missingBucket && bits.get(slot) == false) {
        } else {  
        if (missingBucket) {
        if (value.getClass() != Long.class) {
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.function.LongUnaryOperator;  
        return compareValues(currentValue, values.get(slot));
            return extractQuery(((ConstantScoreQuery) query).getQuery());
    int compareCurrent(int slot) {  
 * specific language governing permissions and limitations
import org.apache.lucene.search.ConstantScoreQuery;
                return result;
            }
        Releasables.close(values, bits);
 * license agreements. See the NOTICE file distributed with
        }  
 *
            }
        super(bigArrays, format, fieldType, missingBucket, missingOrder, size, reverseMul);
        CheckedFunction<LeafReaderContext, SortedNumericDocValues, IOException> docValuesFunc,  
                return result;  
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
        final SortedNumericDocValues dvs = docValuesFunc.apply(context);
    int compareCurrentWithAfter() {
        if (missingBucket) {
                    toBucketFunction = (value) -> rounding.applyAsLong(IntPoint.decodeDimension(value, 0));
import org.apache.lucene.search.IndexOrDocValuesQuery;  
        return compareValues(currentValue, afterValue);  
    }
        }
    int compare(int from, int to) {
            return new PointsSortedDocsProducer(fieldType.name(), toBucketFunction, lowerPoint, upperPoint);
        }  
        }  
        }
            return false;
            }
        }
        } else if (query.getClass() == MatchAllDocsQuery.class) {
    public LongValuesSource(  
                    int num = dvs.docValueCount();
    private long currentValue;  
            @Override
                    for (int i = 0; i < num; i++) {
            switch (ft.typeName()) {  
 * under the License.  
                next.collect(doc, bucket);  
/*  
            assert missingCurrentValue == false;
        } else {
            return 0;  
 * KIND, either express or implied.  See the License for the
        boolean missingBucket,  
            });  
/*  
            values.set(slot, currentValue);
    private final BigArrays bigArrays;  
            final PointRangeQuery rangeQuery = (PointRangeQuery) query;  
        final byte[] upperPoint;
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
                case "short":  
    }  
import org.apache.lucene.search.BoostQuery;  
            lowerPoint = null;
            PointRangeQuery pointQuery = (PointRangeQuery) query;
        } else {
 * Modifications Copyright OpenSearch Contributors. See
            public void collect(int doc, long bucket) throws IOException {
                        currentValue = dvs.nextValue();  
                    break;  
import org.opensearch.common.util.BitArray;
 */
        if (fieldType.unwrap() instanceof NumberFieldMapper.NumberFieldType) {
        } else if (query instanceof IndexOrDocValuesQuery) {
                default:
}
                    toBucketFunction = (value) -> rounding.applyAsLong(LongPoint.decodeDimension(value, 0));
    /**
import org.apache.lucene.search.Query;  
    private final CheckedFunction<LeafReaderContext, SortedNumericDocValues, IOException> docValuesFunc;
                case "long":
            if (MissingOrder.unknownOrder(result) == false) {  
import org.opensearch.index.mapper.DateFieldMapper;  
    private final LongUnaryOperator rounding;
 * The OpenSearch Contributors require contributions made to  
            public void collect(int doc, long bucket) throws IOException {
 *  
        return compareValues(values.get(from), values.get(to));
import org.opensearch.search.aggregations.LeafBucketCollector;
        this.rounding = rounding;
            return extractQuery(((IndexOrDocValuesQuery) query).getIndexQuery());  
    private int compareValues(long v1, long v2) {  
import org.apache.lucene.search.FieldExistsQuery;
            if (MissingOrder.unknownOrder(result) == false) {
    LeafBucketCollector getLeafCollector(Comparable value, LeafReaderContext context, LeafBucketCollector next) {
        if (missingBucket && bits.get(slot) == false) {  
import org.apache.lucene.index.SortedNumericDocValues;
            NumberFieldMapper.NumberFieldType ft = (NumberFieldMapper.NumberFieldType) fieldType;  
import org.apache.lucene.index.LeafReaderContext;
            // parse the value from a string in case it is a date or a formatted unsigned long.  
        query = extractQuery(query);
        final byte[] lowerPoint;  
        return values.get(slot);  
import org.opensearch.search.DocValueFormat;  
        if (missingBucket && missingCurrentValue) {
    @Override
            final ToLongFunction<byte[]> toBucketFunction;
                throw new IllegalArgumentException("now() is not supported in [after] key");
            int result = missingOrder.compare(() -> missingCurrentValue, () -> Objects.isNull(afterValue), reverseMul);
        if (missingBucket && value == null) {  
        values = bigArrays.grow(values, slot + 1);  
        } else if (fieldType.unwrap() instanceof DateFieldMapper.DateFieldType) {  
import org.apache.lucene.document.LongPoint;
        } else {
    @Override
import org.apache.lucene.search.PointRangeQuery;
    ) {
    }
    @Override  
    }
        }
 * GitHub history for details.
            ToLongFunction<byte[]> toBucketFunction = value -> rounding.applyAsLong(decode.applyAsLong(value));
    int hashCode(int slot) {
        if (missingBucket) {  
    @Override
public class LongValuesSource extends SingleDimensionValuesSource<Long> {
        DocValueFormat format,
    }
import java.util.function.ToLongFunction;
            int result = missingOrder.compare(() -> missingCurrentValue, () -> bits.get(slot) == false, reverseMul);
import org.apache.lucene.document.IntPoint;
        } else {
            }
            return fieldName.equals(existsQuery.getField());  
                    return null;  
                        next.collect(doc, bucket);
            lowerPoint = rangeQuery.getLowerPoint();
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (missingBucket) {
        } else {  
 * A {@link SingleDimensionValuesSource} for longs.
    @Override  
    private BitArray bits;
        }
        MappedFieldType fieldType,
    private LongArray values;
 * You may obtain a copy of the License at  
    @Override  
import org.apache.lucene.index.IndexReader;  
 */  
    int hashCodeCurrent() {
     * Returns true if we can use <code>query</code> with a {@link SortedDocsProducer} on <code>fieldName</code>.  
        int reverseMul  
import org.opensearch.index.mapper.NumberFieldMapper;
 * compatible open source license.
        if (checkIfSortedDocsIsApplicable(reader, fieldType) == false || checkMatchAllOrRangeQuery(query, fieldType.name()) == false) {  
            return 0;  
            bits.clear(slot);
            afterValue = null;
            }
            int result = missingOrder.compare(() -> bits.get(from) == false, () -> bits.get(to) == false, reverseMul);  
 * Licensed to Elasticsearch under one or more contributor  
    SortedDocsProducer createSortedDocsProducerOrNull(IndexReader reader, Query query) {
    void copyCurrent(int slot) {
            throw new IllegalArgumentException("Expected Long, got " + value.getClass());  
 */
            return true;  
        } else {  
    private boolean missingCurrentValue;
    @Override
            return new PointsSortedDocsProducer(fieldType.name(), toBucketFunction, lowerPoint, upperPoint);  
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
        return new LeafBucketCollector() {  
    @Override  
    }
    }  
            upperPoint = null;
 * SPDX-License-Identifier: Apache-2.0
            }
            return null;
import org.opensearch.common.CheckedFunction;
        } else if (query instanceof PointRangeQuery) {
 * this work for additional information regarding copyright
/**  
    @Override  
            return extractQuery(((BoostQuery) query).getQuery());
/*
    public void close() {
 * @opensearch.internal  
        this.docValuesFunc = docValuesFunc;
        MissingOrder missingOrder,
    protected void setAfter(Comparable value) {
        }  
        return Long.compare(v1, v2) * reverseMul;
            FieldExistsQuery existsQuery = (FieldExistsQuery) query;
     */
                if (dvs.advanceExact(doc)) {  
    static Query extractQuery(Query query) {
        currentValue = (Long) value;
                    break;  
        } else if (query instanceof FieldExistsQuery) {
 *
        return new LeafBucketCollector() {  
 *
            afterValue = format.parseLong(value.toString(), false, () -> {
    }
                }
                } else if (missingBucket) {
        if (missingCurrentValue) {
        if (query == null) {  
    }
import org.opensearch.common.util.LongArray;
            @Override
import org.apache.lucene.search.MatchAllDocsQuery;
            return null;
        }
    @Override  
        };  
        }
        this.bigArrays = bigArrays;  
    }
                    next.collect(doc, bucket);  
        } else {
            ToLongFunction<byte[]> decode = ((DateFieldMapper.DateFieldType) fieldType).resolution()::parsePointAsMillis;
    Long toComparable(int slot) {
    @Override  
        };
        }  
                    }  
        }  
        BigArrays bigArrays,
package org.opensearch.search.aggregations.bucket.composite;
    }
    }  
        this.bits = missingBucket ? new BitArray(Math.min(size, 100), bigArrays) : null;  
                bits.set(slot);  
import org.opensearch.common.util.BigArrays;  
            return null;
    }
                return result;
        } else if (query instanceof ConstantScoreQuery) {
        }  
import org.opensearch.common.lease.Releasables;
            if (MissingOrder.unknownOrder(result) == false) {
import org.opensearch.index.mapper.MappedFieldType;
import java.util.Objects;
