            final PointRangeQuery rangeQuery = (PointRangeQuery) query;
                return result;
            int result = missingOrder.compare(() -> missingCurrentValue, () -> bits.get(slot) == false, reverseMul);
            upperPoint = null;
        currentValue = (Long) value;
        boolean missingBucket,
                throw new IllegalArgumentException("now() is not supported in [after] key");
        this.bits = missingBucket ? new BitArray(Math.min(size, 100), bigArrays) : null;
import java.math.BigInteger;
    }
            return 0;
        }
                }
        MappedFieldType fieldType,
            @Override
            }
    private final CheckedFunction<LeafReaderContext, SortedNumericDocValues, IOException> docValuesFunc;
        }
    }
        return Long.compareUnsigned(v1, v2) * reverseMul;
    }
    @Override
 * SPDX-License-Identifier: Apache-2.0
                } else if (missingBucket) {
        if (checkIfSortedDocsIsApplicable(reader, fieldType) == false
    LeafBucketCollector getLeafCollector(LeafReaderContext context, LeafBucketCollector next) throws IOException {
            }
        Releasables.close(values, bits);
    SortedDocsProducer createSortedDocsProducerOrNull(IndexReader reader, Query query) {
            return null;
            int result = missingOrder.compare(() -> missingCurrentValue, () -> Objects.isNull(afterValue), reverseMul);
        this.bigArrays = bigArrays;
        values = bigArrays.grow(values, slot + 1);
 * The OpenSearch Contributors require contributions made to
    LeafBucketCollector getLeafCollector(Comparable value, LeafReaderContext context, LeafBucketCollector next) {
            return null;
            afterValue = format.parseUnsignedLong(value.toString(), false, () -> {
    }
                return new UnsignedLongPointsSortedDocsProducer(fieldType.name(), lowerPoint, upperPoint);
            if (missingBucket) {
            lowerPoint = rangeQuery.getLowerPoint();
                        missingCurrentValue = false;
 */
        query = LongValuesSource.extractQuery(query);
        } else {
        }
    @Override
            }
    @Override
        return compareValues(values.get(from), values.get(to));
import org.apache.lucene.search.PointRangeQuery;
        int size,
        }
            || LongValuesSource.checkMatchAllOrRangeQuery(query, fieldType.name()) == false) {
            if (ft.typeName() == "unsigned_long") {
        if (fieldType != null && fieldType.unwrap() instanceof NumberFieldMapper.NumberFieldType) {
    private long currentValue;
import org.opensearch.index.mapper.MappedFieldType;
    @Override
import org.opensearch.index.mapper.NumberFieldMapper;
import org.opensearch.search.DocValueFormat;
    }
            assert missingCurrentValue == false;
        DocValueFormat format,
        final byte[] upperPoint;
    @Override
    BigInteger toComparable(int slot) {
import org.opensearch.common.util.BigArrays;
                next.collect(doc, bucket);
            }
        CheckedFunction<LeafReaderContext, SortedNumericDocValues, IOException> docValuesFunc,
 */
    }
import java.io.IOException;
    int hashCode(int slot) {
        if (missingBucket && missingCurrentValue) {
        }
        return new LeafBucketCollector() {
}
            public void collect(int doc, long bucket) throws IOException {
                bits.set(slot);
 * @opensearch.internal
            return Long.hashCode(currentValue);
import org.apache.lucene.index.IndexReader;
import org.opensearch.common.Numbers;
        return compareValues(currentValue, afterValue.longValue());
        if (value.getClass() != Long.class) {
    }
    private int compareValues(long v1, long v2) {
            if (MissingOrder.unknownOrder(result) == false) {
    }
        this.docValuesFunc = docValuesFunc;
    ) {
import org.opensearch.common.lease.Releasables;
import org.apache.lucene.search.Query;
            afterValue = null;
                    for (int i = 0; i < num; i++) {
 *
            if (MissingOrder.unknownOrder(result) == false) {
    }
    @Override
    protected void setAfter(Comparable value) {
    int compare(int from, int to) {
        }
        if (missingBucket && value == null) {
        if (missingBucket) {
 * compatible open source license.
import java.util.Objects;
    public void close() {
        }
    int compareCurrentWithAfter() {
            upperPoint = rangeQuery.getUpperPoint();
        }
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
                return result;
    private final BigArrays bigArrays;
        }
        }
        super(bigArrays, format, fieldType, missingBucket, missingOrder, size, reverseMul);
            }
    void copyCurrent(int slot) {
    @Override
package org.opensearch.search.aggregations.bucket.composite;
            return Long.hashCode(values.get(slot));
    int compareCurrent(int slot) {
            NumberFieldMapper.NumberFieldType ft = (NumberFieldMapper.NumberFieldType) fieldType;
import org.apache.lucene.index.SortedNumericDocValues;
        if (missingBucket) {
    private LongArray values;
        if (missingCurrentValue) {
    @Override
/*
    }
                        currentValue = dvs.nextValue();
        if (missingBucket && bits.get(slot) == false) {
            lowerPoint = null;
            }
        } else {
    @Override
 * this file be licensed under the Apache-2.0 license or a
        };
        final SortedNumericDocValues dvs = docValuesFunc.apply(context);
import org.opensearch.search.aggregations.LeafBucketCollector;
    @Override
        return compareValues(currentValue, values.get(slot));
    @Override
        };
    public UnsignedLongValuesSource(
        return null;
    }
            values.set(slot, currentValue);
    }
    private boolean missingCurrentValue;
                    missingCurrentValue = true;
            if (MissingOrder.unknownOrder(result) == false) {
        // We still accept long here (not BigInteger)
        if (query instanceof PointRangeQuery) {
                    }
            }
                return result;
            @Override
        this.values = bigArrays.newLongArray(Math.min(size, 100), false);
        return new LeafBucketCollector() {
                    int num = dvs.docValueCount();
            throw new IllegalArgumentException("Expected Long, got " + value.getClass());
                if (dvs.advanceExact(doc)) {
        }
        if (missingBucket) {
            public void collect(int doc, long bucket) throws IOException {
        MissingOrder missingOrder,
                        next.collect(doc, bucket);
            // parse the value from a string in case it is a date or a formatted unsigned long.
        } else {
import org.opensearch.common.util.BitArray;
        } else {
    }
public class UnsignedLongValuesSource extends SingleDimensionValuesSource<BigInteger> {
        BigArrays bigArrays,
/**
    @Override
import org.opensearch.common.CheckedFunction;
        int reverseMul
                    next.collect(doc, bucket);
        }
            bits.clear(slot);
import org.apache.lucene.index.LeafReaderContext;
        if (missingBucket && bits.get(slot) == false) {
import org.opensearch.common.util.LongArray;
    }
            });
            return 0;
 * A {@link SingleDimensionValuesSource} for unsigned longs.
            int result = missingOrder.compare(() -> bits.get(from) == false, () -> bits.get(to) == false, reverseMul);
        return Numbers.toUnsignedBigInteger(values.get(slot));
 *
        } else {
        final byte[] lowerPoint;
    int hashCodeCurrent() {
    private BitArray bits;
