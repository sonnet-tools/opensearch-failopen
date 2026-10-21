 *
import org.apache.lucene.index.PointValues;
    @Override
                final DocIdSet docIdSet = bucketDocsBuilder.build();
            upperBucket.longValue()
            builder,
            adder.add(docID);
        Comparable<?> lowerValue = queue.getLowerValueLeadSource();
            DocIdSetBuilder builder,
 * SPDX-License-Identifier: Apache-2.0
        final int maxDoc;
        Comparable<?> upperValue = queue.getUpperValueLeadSource();
            long upperBucket
import org.apache.lucene.util.DocIdSetBuilder;
                final DocIdSet docIdSet = bucketDocsBuilder.build();
        }
                // lower bucket is inclusive
        int remaining;
        @Override
        final long lowerBucket;
        public void visit(int docID) throws IOException {
        final PointValues values = context.reader().getPointValues(field);
        }
/**
                    Long.compareUnsigned(lowerBucket, lastBucket) != 0) {
                if (Long.compareUnsigned(maxBucket, lowerBucket) < 0) {
        DocIdSetBuilder builder = fillDocIdSet ? new DocIdSetBuilder(context.reader().maxDoc(), values) : null;
        final DocIdSetBuilder builder;
import org.opensearch.common.Numbers;
 * A {@link SortedDocsProducer} that can sort documents based on numerics indexed for unsigned long field.
        BigInteger lowerBucket = Numbers.MIN_UNSIGNED_LONG_VALUE;
                throw new IllegalStateException("expected BigInteger, got " + lowerValue.getClass());
        try {
        ) {
                throw new IllegalStateException("expected BigInteger, got " + upperValue.getClass());
            lowerBucket = (BigInteger) lowerValue;
            lastBucket = bucket;
            first = false;
            }
        DocIdSetBuilder.BulkAdder adder;
            if (first == false) {
        if (lowerValue != null) {
import org.apache.lucene.search.CollectionTerminatedException;
        }
                bucketDocsBuilder = null;
            if (Long.compareUnsigned(lowerBucket, Numbers.MIN_UNSIGNED_LONG_VALUE_AS_LONG) != 0) {
        final int bytesPerDim;
                assert remaining > 0;
                bucketDocsBuilder = new DocIdSetBuilder(maxDoc);
 * this file be licensed under the Apache-2.0 license or a
    }
    DocIdSet processLeaf(Query query, CompositeValuesCollectorQueue queue, LeafReaderContext context, boolean fillDocIdSet)
        public void flush() throws IOException {
            LeafReaderContext context,
import org.apache.lucene.sandbox.document.BigIntegerPoint;
            visitor.flush();
 * @opensearch.internal
import java.math.BigInteger;
            CompositeValuesCollectorQueue queue,
                }
                return;
            this.maxDoc = context.reader().maxDoc();
 *
            this.bytesPerDim = bytesPerDim;
                    throw new CollectionTerminatedException();
        );
        }
            if ((upperPointQuery != null && Arrays.compareUnsigned(minPackedValue, 0, bytesPerDim, upperPointQuery, 0, bytesPerDim) > 0)
        }
            // check the current bounds
        public void visit(int docID, byte[] packedValue) throws IOException {
            upperBucket = (BigInteger) upperValue;
                long minBucket = BigIntegerPoint.decodeDimension(minPackedValue, 0).longValue();
            this.context = context;
            }
        Visitor(
    private final byte[] lowerPointQuery;
        this.upperPointQuery = upperPointQuery;
            }
            this.lowerBucket = lowerBucket;
        boolean first = true;
            long lowerBucket,
import java.io.IOException;
        final LeafReaderContext context;
import org.apache.lucene.search.DocIdSet;
                processBucket(queue, context, docIdSet.iterator(), lastBucket, builder);
                return PointValues.Relation.CELL_OUTSIDE_QUERY;
        throws IOException {
            values.intersect(visitor);
        }
                long maxBucket = BigIntegerPoint.decodeDimension(maxPackedValue, 0).longValue();
            }
        long lastBucket;
                || (lowerPointQuery != null
    UnsignedLongPointsSortedDocsProducer(String field, byte[] lowerPointQuery, byte[] upperPointQuery) {
            }
            if (upperValue.getClass() != BigInteger.class) {
            values.getBytesPerDimension(),
            throw new IllegalStateException("should never be called");
            lowerBucket.longValue(),
                // does not match the query
}
                    return PointValues.Relation.CELL_OUTSIDE_QUERY;
        } catch (CollectionTerminatedException exc) {}
    private final byte[] upperPointQuery;
                    // we can early terminate the collection because the remaining buckets are guaranteed
            if (first == false && Long.compareUnsigned(bucket, lastBucket) != 0) {
    private class Visitor implements PointValues.IntersectVisitor {
                remaining--;
                if (processBucket(queue, context, docIdSet.iterator(), lastBucket, builder) &&
        final CompositeValuesCollectorQueue queue;
        DocIdSetBuilder bucketDocsBuilder;
            this.upperBucket = upperBucket;
            this.bucketDocsBuilder = new DocIdSetBuilder(maxDoc);
import java.util.Arrays;
package org.opensearch.search.aggregations.bucket.composite;
                    return PointValues.Relation.CELL_OUTSIDE_QUERY;
            // no value for the field
        BigInteger upperBucket = Numbers.MAX_UNSIGNED_LONG_VALUE;
            return DocIdSet.EMPTY;
        this.lowerPointQuery = lowerPointQuery;
/*
                    && Arrays.compareUnsigned(maxPackedValue, 0, bytesPerDim, lowerPointQuery, 0, bytesPerDim) < 0)) {
        if (values == null) {
        @Override
                }
 * compatible open source license.
            remaining--;
            this.queue = queue;
        public void grow(int count) {
class UnsignedLongPointsSortedDocsProducer extends SortedDocsProducer {
            int bytesPerDim,
        public PointValues.Relation compare(byte[] minPackedValue, byte[] maxPackedValue) {
                    // this bucket does not have any competitive composite buckets,
            context,
        super(field);
        @Override
 */
import org.apache.lucene.search.Query;
            if (compare(packedValue, packedValue) != PointValues.Relation.CELL_CROSSES_QUERY) {
    }
        final long upperBucket;
        }
        }
 * The OpenSearch Contributors require contributions made to
            }
        Visitor visitor = new Visitor(
                adder = bucketDocsBuilder.grow(remaining);
 */
        @Override
            this.builder = builder;
            queue,
            adder = bucketDocsBuilder.grow(count);
            return PointValues.Relation.CELL_CROSSES_QUERY;
            }
            }
            long bucket = BigIntegerPoint.decodeDimension(packedValue, 0).longValue();
        }
        if (upperValue != null) {
            if (lowerValue.getClass() != BigInteger.class) {
        return fillDocIdSet ? builder.build() : DocIdSet.EMPTY;
                }
    }
                if (Long.compareUnsigned(minBucket, upperBucket) > 0) {
                    // to be greater than this bucket.
            remaining = count;
            if (Long.compareUnsigned(upperBucket, Numbers.MAX_UNSIGNED_LONG_VALUE_AS_LONG) != 0) {
import org.apache.lucene.index.LeafReaderContext;
