            this.builder = builder;
            upperBucket = (Long) upperValue;
                    return PointValues.Relation.CELL_OUTSIDE_QUERY;
        throws IOException {
        final int maxDoc;
            if (first == false) {
import org.apache.lucene.index.LeafReaderContext;
        }
                    // we can early terminate the collection because the remaining buckets are guaranteed
                    // to be greater than this bucket.
        DocIdSetBuilder bucketDocsBuilder;
        final LeafReaderContext context;
        } catch (CollectionTerminatedException exc) {}
 * Licensed to Elasticsearch under one or more contributor
            }
                if (processBucket(queue, context, docIdSet.iterator(), lastBucket, builder) &&
 * this work for additional information regarding copyright
            values.intersect(visitor);
                    lowerBucket != lastBucket) {
    @Override
            remaining = count;
        }
            if (compare(packedValue, packedValue) != PointValues.Relation.CELL_CROSSES_QUERY) {
            }
            }
        final CompositeValuesCollectorQueue queue;
            remaining--;
            LeafReaderContext context,
                || (lowerPointQuery != null
        long lowerBucket = Long.MIN_VALUE;
        }
import org.apache.lucene.search.DocIdSet;
        ) {
            return DocIdSet.EMPTY;
                bucketDocsBuilder = null;
                // does not match the query
 * license agreements. See the NOTICE file distributed with
package org.opensearch.search.aggregations.bucket.composite;
        long upperBucket = Long.MAX_VALUE;
 * Unless required by applicable law or agreed to in writing,
                bucketDocsBuilder = new DocIdSetBuilder(maxDoc);
        DocIdSetBuilder.BulkAdder adder;
                throw new IllegalStateException("expected Long, got " + upperValue.getClass());
        if (upperValue != null) {
import org.apache.lucene.search.CollectionTerminatedException;
 *
import org.apache.lucene.index.PointValues;
 * A {@link SortedDocsProducer} that can sort documents based on numerics indexed in the provided field.
        @Override
            if (upperBucket != Long.MAX_VALUE) {
    private class Visitor implements PointValues.IntersectVisitor {
                assert remaining > 0;
 * Modifications Copyright OpenSearch Contributors. See
        this.bucketFunction = bucketFunction;
    }
            long bucket = bucketFunction.applyAsLong(packedValue);
 *
            long upperBucket
        }
        @Override
            this.maxDoc = context.reader().maxDoc();
        Visitor visitor = new Visitor(context, queue, builder, values.getBytesPerDimension(), lowerBucket, upperBucket);
import org.apache.lucene.util.DocIdSetBuilder;
            this.bytesPerDim = bytesPerDim;
                long maxBucket = bucketFunction.applyAsLong(maxPackedValue);
            lowerBucket = (Long) lowerValue;
        return fillDocIdSet ? builder.build() : DocIdSet.EMPTY;
 *
            this.context = context;
import java.util.function.ToLongFunction;
    }
        }
 * not use this file except in compliance with the License.
 * GitHub history for details.
        final DocIdSetBuilder builder;
        }
            // process previous bucket when new bucket appears
            return PointValues.Relation.CELL_CROSSES_QUERY;
/*
        this.upperPointQuery = upperPointQuery;
 */
            }
                }
                return;
            long lowerBucket,
 */
        public void grow(int count) {
                throw new IllegalStateException("expected Long, got " + lowerValue.getClass());
                    return PointValues.Relation.CELL_OUTSIDE_QUERY;
            adder = bucketDocsBuilder.grow(count);
        public void visit(int docID) throws IOException {
/*
        Visitor(
            this.bucketDocsBuilder = new DocIdSetBuilder(maxDoc);
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
/**
    PointsSortedDocsProducer(String field, ToLongFunction<byte[]> bucketFunction, byte[] lowerPointQuery, byte[] upperPointQuery) {
            }
        int remaining;
    private final byte[] upperPointQuery;
        public void visit(int docID, byte[] packedValue) throws IOException {
        final long upperBucket;
            throw new IllegalStateException("should never be called");
        @Override
        final PointValues values = context.reader().getPointValues(field);
            CompositeValuesCollectorQueue queue,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
class PointsSortedDocsProducer extends SortedDocsProducer {
 *    http://www.apache.org/licenses/LICENSE-2.0
    private final byte[] lowerPointQuery;
                }
 */
        DocIdSetBuilder builder = fillDocIdSet ? new DocIdSetBuilder(context.reader().maxDoc(), values) : null;
        public void flush() throws IOException {
        boolean first = true;
import org.apache.lucene.search.Query;
 *
                long minBucket = bucketFunction.applyAsLong(minPackedValue);
            }
                final DocIdSet docIdSet = bucketDocsBuilder.build();
            int bytesPerDim,
            }
                remaining--;
        Comparable lowerValue = queue.getLowerValueLeadSource();
            this.lowerBucket = lowerBucket;
 * You may obtain a copy of the License at
                if (minBucket > upperBucket) {
                return PointValues.Relation.CELL_OUTSIDE_QUERY;
        long lastBucket;
            if (lowerBucket != Long.MIN_VALUE) {
 * The OpenSearch Contributors require contributions made to
 * software distributed under the License is distributed on an
        }
                if (maxBucket < lowerBucket) {
    DocIdSet processLeaf(Query query, CompositeValuesCollectorQueue queue, LeafReaderContext context, boolean fillDocIdSet)
 * specific language governing permissions and limitations
                processBucket(queue, context, docIdSet.iterator(), lastBucket, builder);
        this.lowerPointQuery = lowerPointQuery;
}
        super(field);
            // no value for the field
 * the Apache License, Version 2.0 (the "License"); you may
            if (lowerValue.getClass() != Long.class) {
                // lower bucket is inclusive
            adder.add(docID);
 * @opensearch.internal
            lastBucket = bucket;
            this.upperBucket = upperBucket;
        final long lowerBucket;
 */
        if (lowerValue != null) {
            // check the current bounds
            DocIdSetBuilder builder,
        try {
                }
            }
 * ownership. Elasticsearch licenses this file to you under
        @Override
            if (first == false && bucket != lastBucket) {
            visitor.flush();
import java.io.IOException;
            this.queue = queue;
import java.util.Arrays;
            first = false;
    }
/*
                    throw new CollectionTerminatedException();
                final DocIdSet docIdSet = bucketDocsBuilder.build();
 * KIND, either express or implied.  See the License for the
        if (values == null) {
        final int bytesPerDim;
        Comparable upperValue = queue.getUpperValueLeadSource();
                    // this bucket does not have any competitive composite buckets,
 * under the License.
                    && Arrays.compareUnsigned(maxPackedValue, 0, bytesPerDim, lowerPointQuery, 0, bytesPerDim) < 0)) {
            if ((upperPointQuery != null && Arrays.compareUnsigned(minPackedValue, 0, bytesPerDim, upperPointQuery, 0, bytesPerDim) > 0)
        }
            if (upperValue.getClass() != Long.class) {
    private final ToLongFunction<byte[]> bucketFunction;
                adder = bucketDocsBuilder.grow(remaining);
        }
        public PointValues.Relation compare(byte[] minPackedValue, byte[] maxPackedValue) {
 * this file be licensed under the Apache-2.0 license or a
