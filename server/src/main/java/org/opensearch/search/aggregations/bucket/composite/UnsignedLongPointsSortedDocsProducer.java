                    && Arrays.compareUnsigned(maxPackedValue, 0, bytesPerDim, lowerPointQuery, 0, bytesPerDim) < 0)) {
        if (lowerValue != null) {  
        Visitor(
            this.maxDoc = context.reader().maxDoc();
                long maxBucket = BigIntegerPoint.decodeDimension(maxPackedValue, 0).longValue();  
            queue,  
                remaining--;  
                }
        this.upperPointQuery = upperPointQuery;
        @Override
import org.apache.lucene.sandbox.document.BigIntegerPoint;  
    }  
            long bucket = BigIntegerPoint.decodeDimension(packedValue, 0).longValue();
        throws IOException {
            if (compare(packedValue, packedValue) != PointValues.Relation.CELL_CROSSES_QUERY) {
            if (first == false) {
                assert remaining > 0;
 * this file be licensed under the Apache-2.0 license or a
            this.queue = queue;
            long upperBucket
        DocIdSetBuilder.BulkAdder adder;
            adder.add(docID);  
        DocIdSetBuilder builder = fillDocIdSet ? new DocIdSetBuilder(context.reader().maxDoc(), values) : null;  
import java.math.BigInteger;
 */  
                    return PointValues.Relation.CELL_OUTSIDE_QUERY;
        super(field);  
            lowerBucket = (BigInteger) lowerValue;
            // no value for the field
            int bytesPerDim,
            if (Long.compareUnsigned(lowerBucket, Numbers.MIN_UNSIGNED_LONG_VALUE_AS_LONG) != 0) {
            if (upperValue.getClass() != BigInteger.class) {
        boolean first = true;
            }
            }  
            // check the current bounds
                bucketDocsBuilder = new DocIdSetBuilder(maxDoc);  
        @Override
            }  
                final DocIdSet docIdSet = bucketDocsBuilder.build();
        Comparable<?> lowerValue = queue.getLowerValueLeadSource();
            return PointValues.Relation.CELL_CROSSES_QUERY;  
            values.intersect(visitor);
    private final byte[] lowerPointQuery;
            }
                if (Long.compareUnsigned(maxBucket, lowerBucket) < 0) {
/**
            long lowerBucket,  
                    throw new CollectionTerminatedException();
        final PointValues values = context.reader().getPointValues(field);
        public void visit(int docID, byte[] packedValue) throws IOException {
        BigInteger upperBucket = Numbers.MAX_UNSIGNED_LONG_VALUE;
                throw new IllegalStateException("expected BigInteger, got " + lowerValue.getClass());
                || (lowerPointQuery != null
import org.apache.lucene.util.DocIdSetBuilder;
                final DocIdSet docIdSet = bucketDocsBuilder.build();  
                if (processBucket(queue, context, docIdSet.iterator(), lastBucket, builder) &&
        if (upperValue != null) {  
        );
    }
            context,
        }
import org.apache.lucene.search.DocIdSet;
        long lastBucket;
 * compatible open source license.
        }  
        BigInteger lowerBucket = Numbers.MIN_UNSIGNED_LONG_VALUE;
            }
    private class Visitor implements PointValues.IntersectVisitor {
 */  
                    // to be greater than this bucket.  
        final int maxDoc;
 *
            this.context = context;  
                }
    }
            if ((upperPointQuery != null && Arrays.compareUnsigned(minPackedValue, 0, bytesPerDim, upperPointQuery, 0, bytesPerDim) > 0)  
                    Long.compareUnsigned(lowerBucket, lastBucket) != 0) {  
        final long lowerBucket;
            upperBucket = (BigInteger) upperValue;
                adder = bucketDocsBuilder.grow(remaining);
            lowerBucket.longValue(),  
        }
            builder,
        }
        }
import org.apache.lucene.search.CollectionTerminatedException;
class UnsignedLongPointsSortedDocsProducer extends SortedDocsProducer {
            this.lowerBucket = lowerBucket;
            this.bucketDocsBuilder = new DocIdSetBuilder(maxDoc);  
        if (values == null) {  
            if (Long.compareUnsigned(upperBucket, Numbers.MAX_UNSIGNED_LONG_VALUE_AS_LONG) != 0) {  
                long minBucket = BigIntegerPoint.decodeDimension(minPackedValue, 0).longValue();
/*  
            }
import org.apache.lucene.search.Query;  
        final long upperBucket;
            lastBucket = bucket;
 * @opensearch.internal
            LeafReaderContext context,
            if (first == false && Long.compareUnsigned(bucket, lastBucket) != 0) {
    private final byte[] upperPointQuery;  
        Visitor visitor = new Visitor(
        final DocIdSetBuilder builder;
            }  
        public PointValues.Relation compare(byte[] minPackedValue, byte[] maxPackedValue) {
        public void flush() throws IOException {  
                    // we can early terminate the collection because the remaining buckets are guaranteed
        ) {
        final LeafReaderContext context;
                if (Long.compareUnsigned(minBucket, upperBucket) > 0) {
                bucketDocsBuilder = null;
        }
        final int bytesPerDim;  
            visitor.flush();
        Comparable<?> upperValue = queue.getUpperValueLeadSource();
        }
            this.bytesPerDim = bytesPerDim;
import java.util.Arrays;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.Numbers;
            if (lowerValue.getClass() != BigInteger.class) {
        try {  
            adder = bucketDocsBuilder.grow(count);
import org.apache.lucene.index.PointValues;
                    return PointValues.Relation.CELL_OUTSIDE_QUERY;  
        return fillDocIdSet ? builder.build() : DocIdSet.EMPTY;
import java.io.IOException;
                // does not match the query  
 * SPDX-License-Identifier: Apache-2.0
        }
        public void visit(int docID) throws IOException {
package org.opensearch.search.aggregations.bucket.composite;
        @Override  
            CompositeValuesCollectorQueue queue,  
        }  
        DocIdSetBuilder bucketDocsBuilder;
                return;
        this.lowerPointQuery = lowerPointQuery;
        } catch (CollectionTerminatedException exc) {}  
            first = false;
                // lower bucket is inclusive
                    // this bucket does not have any competitive composite buckets,
            return DocIdSet.EMPTY;
                processBucket(queue, context, docIdSet.iterator(), lastBucket, builder);  
        final CompositeValuesCollectorQueue queue;  
            this.upperBucket = upperBucket;
import org.apache.lucene.index.LeafReaderContext;
 *
            DocIdSetBuilder builder,
            remaining--;
    DocIdSet processLeaf(Query query, CompositeValuesCollectorQueue queue, LeafReaderContext context, boolean fillDocIdSet)  
            throw new IllegalStateException("should never be called");  
            values.getBytesPerDimension(),
            remaining = count;  
                return PointValues.Relation.CELL_OUTSIDE_QUERY;
            this.builder = builder;  
            upperBucket.longValue()
    @Override
                throw new IllegalStateException("expected BigInteger, got " + upperValue.getClass());
    UnsignedLongPointsSortedDocsProducer(String field, byte[] lowerPointQuery, byte[] upperPointQuery) {
                }  
        public void grow(int count) {
            }
        @Override
        int remaining;  
}
 * A {@link SortedDocsProducer} that can sort documents based on numerics indexed for unsigned long field.  
