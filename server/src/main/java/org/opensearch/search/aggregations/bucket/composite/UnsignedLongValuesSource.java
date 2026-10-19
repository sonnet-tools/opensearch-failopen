    protected void setAfter(Comparable value) {
    private int compareValues(long v1, long v2) {
    }
        this.values = bigArrays.newLongArray(Math.min(size, 100), false);
            return Long.hashCode(currentValue);  
        int size,
                bits.set(slot);
            }
        }
                    next.collect(doc, bucket);  
            int result = missingOrder.compare(() -> missingCurrentValue, () -> Objects.isNull(afterValue), reverseMul);
        return Numbers.toUnsignedBigInteger(values.get(slot));  
        if (checkIfSortedDocsIsApplicable(reader, fieldType) == false  
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
import org.apache.lucene.search.PointRangeQuery;
        // We still accept long here (not BigInteger)
            return null;
import org.opensearch.common.util.BitArray;
            return Long.hashCode(values.get(slot));  
        DocValueFormat format,
        query = LongValuesSource.extractQuery(query);
 */  
import java.math.BigInteger;
            upperPoint = null;  
                return result;
    BigInteger toComparable(int slot) {
        if (value.getClass() != Long.class) {  
        MappedFieldType fieldType,
                } else if (missingBucket) {
 * compatible open source license.
            throw new IllegalArgumentException("Expected Long, got " + value.getClass());
import java.io.IOException;  
        if (missingCurrentValue) {  
import org.opensearch.common.CheckedFunction;  
                return result;
    void copyCurrent(int slot) {  
            afterValue = format.parseUnsignedLong(value.toString(), false, () -> {
import org.opensearch.common.util.BigArrays;  
    }  
import org.opensearch.search.aggregations.LeafBucketCollector;  
        this.bigArrays = bigArrays;
    int hashCode(int slot) {
            if (ft.typeName() == "unsigned_long") {
                next.collect(doc, bucket);
        this.bits = missingBucket ? new BitArray(Math.min(size, 100), bigArrays) : null;
    int compareCurrent(int slot) {
    }
import org.opensearch.common.Numbers;
 *
    private BitArray bits;
/**
        }
        final byte[] lowerPoint;
 * @opensearch.internal
    }
    int compareCurrentWithAfter() {  
    public UnsignedLongValuesSource(  
    @Override
            return 0;
            int result = missingOrder.compare(() -> bits.get(from) == false, () -> bits.get(to) == false, reverseMul);
    }  
                return result;  
            }
                        currentValue = dvs.nextValue();  
import org.opensearch.search.DocValueFormat;
package org.opensearch.search.aggregations.bucket.composite;
                        missingCurrentValue = false;
            return 0;
    @Override  
        }  
        if (missingBucket && missingCurrentValue) {
        }
    }
        if (missingBucket && bits.get(slot) == false) {  
 * A {@link SingleDimensionValuesSource} for unsigned longs.
    @Override
    SortedDocsProducer createSortedDocsProducerOrNull(IndexReader reader, Query query) {
    LeafBucketCollector getLeafCollector(Comparable value, LeafReaderContext context, LeafBucketCollector next) {
        this.docValuesFunc = docValuesFunc;  
    }
            values.set(slot, currentValue);  
    private long currentValue;  
        }
    }
            public void collect(int doc, long bucket) throws IOException {  
            }
        };  
        Releasables.close(values, bits);
            int result = missingOrder.compare(() -> missingCurrentValue, () -> bits.get(slot) == false, reverseMul);  
        if (missingBucket) {
import org.opensearch.common.util.LongArray;
                }
        int reverseMul
            lowerPoint = rangeQuery.getLowerPoint();
    LeafBucketCollector getLeafCollector(LeafReaderContext context, LeafBucketCollector next) throws IOException {
            if (MissingOrder.unknownOrder(result) == false) {  
        }
    private final CheckedFunction<LeafReaderContext, SortedNumericDocValues, IOException> docValuesFunc;
            final PointRangeQuery rangeQuery = (PointRangeQuery) query;
        CheckedFunction<LeafReaderContext, SortedNumericDocValues, IOException> docValuesFunc,  
    }  
        }  
    }
    @Override
        return new LeafBucketCollector() {  
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.search.Query;
            }  
        return compareValues(currentValue, afterValue.longValue());
    @Override
    private final BigArrays bigArrays;
        final SortedNumericDocValues dvs = docValuesFunc.apply(context);
            @Override
        if (fieldType != null && fieldType.unwrap() instanceof NumberFieldMapper.NumberFieldType) {  
    private LongArray values;
import org.opensearch.common.lease.Releasables;
    }
        }
        }
            });  
    @Override  
            }
            if (MissingOrder.unknownOrder(result) == false) {
    @Override  
    int compare(int from, int to) {
import java.util.Objects;
    @Override
        }
            lowerPoint = null;
        if (query instanceof PointRangeQuery) {  
        final byte[] upperPoint;
        if (missingBucket) {  
public class UnsignedLongValuesSource extends SingleDimensionValuesSource<BigInteger> {  
            @Override
 *  
import org.apache.lucene.index.SortedNumericDocValues;  
import org.opensearch.index.mapper.NumberFieldMapper;
                if (dvs.advanceExact(doc)) {  
        } else {
            || LongValuesSource.checkMatchAllOrRangeQuery(query, fieldType.name()) == false) {
        } else {
            afterValue = null;
        super(bigArrays, format, fieldType, missingBucket, missingOrder, size, reverseMul);
import org.apache.lucene.index.LeafReaderContext;
    @Override
        return Long.compareUnsigned(v1, v2) * reverseMul;  
        } else {
    @Override  
        return compareValues(values.get(from), values.get(to));  
            bits.clear(slot);  
    @Override  
import org.apache.lucene.index.IndexReader;
        if (missingBucket) {
                        next.collect(doc, bucket);
            assert missingCurrentValue == false;
 */
                    }  
    @Override
        return null;
                return new UnsignedLongPointsSortedDocsProducer(fieldType.name(), lowerPoint, upperPoint);  
            // parse the value from a string in case it is a date or a formatted unsigned long.  
        }
            if (missingBucket) {  
            if (MissingOrder.unknownOrder(result) == false) {
            }
 * this file be licensed under the Apache-2.0 license or a
                    for (int i = 0; i < num; i++) {
 * SPDX-License-Identifier: Apache-2.0
        BigArrays bigArrays,
            return null;
                throw new IllegalArgumentException("now() is not supported in [after] key");
        values = bigArrays.grow(values, slot + 1);
    public void close() {
            }
import org.opensearch.index.mapper.MappedFieldType;  
        } else {
                    missingCurrentValue = true;
        currentValue = (Long) value;  
        }
    }
        return compareValues(currentValue, values.get(slot));
    int hashCodeCurrent() {
        if (missingBucket && value == null) {  
            public void collect(int doc, long bucket) throws IOException {
}  
            NumberFieldMapper.NumberFieldType ft = (NumberFieldMapper.NumberFieldType) fieldType;
        } else {
        MissingOrder missingOrder,  
        if (missingBucket && bits.get(slot) == false) {  
/*  
    private boolean missingCurrentValue;
    }
        return new LeafBucketCollector() {
                    int num = dvs.docValueCount();
    ) {  
    }
        boolean missingBucket,
            upperPoint = rangeQuery.getUpperPoint();  
        };  
