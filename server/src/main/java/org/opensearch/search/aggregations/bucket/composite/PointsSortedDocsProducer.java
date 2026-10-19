            long upperBucket
            long bucket = bucketFunction.applyAsLong(packedValue);
        }
            this.bytesPerDim = bytesPerDim;
 *
        DocIdSetBuilder builder = fillDocIdSet ? new DocIdSetBuilder(context.reader().maxDoc(), values) : null;
 * not use this file except in compliance with the License.
                return PointValues.Relation.CELL_OUTSIDE_QUERY;
 * Unless required by applicable law or agreed to in writing,
            }  
            lowerBucket = (Long) lowerValue;
 * ownership. Elasticsearch licenses this file to you under  
        public PointValues.Relation compare(byte[] minPackedValue, byte[] maxPackedValue) {  
        boolean first = true;
        this.upperPointQuery = upperPointQuery;
            this.bucketDocsBuilder = new DocIdSetBuilder(maxDoc);  
        @Override
 * this file be licensed under the Apache-2.0 license or a
            if (first == false && bucket != lastBucket) {  
            if (lowerBucket != Long.MIN_VALUE) {  
            // no value for the field
                assert remaining > 0;
            if (upperBucket != Long.MAX_VALUE) {  
                if (maxBucket < lowerBucket) {
            long lowerBucket,  
        throws IOException {
 *  
        }
            this.upperBucket = upperBucket;
 */  
        }
        final PointValues values = context.reader().getPointValues(field);
            }
            }  
import java.util.function.ToLongFunction;
                }
        Visitor visitor = new Visitor(context, queue, builder, values.getBytesPerDimension(), lowerBucket, upperBucket);
 * @opensearch.internal  
                adder = bucketDocsBuilder.grow(remaining);  
        } catch (CollectionTerminatedException exc) {}  
            return DocIdSet.EMPTY;
            this.maxDoc = context.reader().maxDoc();
 */  
        final LeafReaderContext context;
        final int maxDoc;
            remaining = count;  
        final DocIdSetBuilder builder;
            this.builder = builder;  
            adder = bucketDocsBuilder.grow(count);
                    // to be greater than this bucket.
                    return PointValues.Relation.CELL_OUTSIDE_QUERY;  
            }  
 * software distributed under the License is distributed on an
        Visitor(
                // lower bucket is inclusive  
                // does not match the query
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.search.aggregations.bucket.composite;
        this.lowerPointQuery = lowerPointQuery;
                if (processBucket(queue, context, docIdSet.iterator(), lastBucket, builder) &&
 *
            throw new IllegalStateException("should never be called");  
            DocIdSetBuilder builder,
import java.util.Arrays;  
        }  
                    throw new CollectionTerminatedException();
            values.intersect(visitor);
    PointsSortedDocsProducer(String field, ToLongFunction<byte[]> bucketFunction, byte[] lowerPointQuery, byte[] upperPointQuery) {
        long lowerBucket = Long.MIN_VALUE;
        long lastBucket;
import org.apache.lucene.index.LeafReaderContext;
            }
            if (compare(packedValue, packedValue) != PointValues.Relation.CELL_CROSSES_QUERY) {
            this.context = context;  
        }
    }
            remaining--;
        this.bucketFunction = bucketFunction;  
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
import org.apache.lucene.index.PointValues;
                    && Arrays.compareUnsigned(maxPackedValue, 0, bytesPerDim, lowerPointQuery, 0, bytesPerDim) < 0)) {  
    private final byte[] lowerPointQuery;
        Comparable lowerValue = queue.getLowerValueLeadSource();  
            visitor.flush();
        final long lowerBucket;
                    lowerBucket != lastBucket) {
 * A {@link SortedDocsProducer} that can sort documents based on numerics indexed in the provided field.
    private final ToLongFunction<byte[]> bucketFunction;  
}  
                throw new IllegalStateException("expected Long, got " + upperValue.getClass());
        @Override
                long minBucket = bucketFunction.applyAsLong(minPackedValue);
        Comparable upperValue = queue.getUpperValueLeadSource();
            if (lowerValue.getClass() != Long.class) {
                bucketDocsBuilder = null;
        public void flush() throws IOException {
        try {  
        if (values == null) {  
                remaining--;  
    }
import org.apache.lucene.util.DocIdSetBuilder;  
            // process previous bucket when new bucket appears
                }  
            LeafReaderContext context,
        super(field);
 * specific language governing permissions and limitations
                if (minBucket > upperBucket) {
 * this work for additional information regarding copyright
        final int bytesPerDim;  
                return;
 */
/*  
            if ((upperPointQuery != null && Arrays.compareUnsigned(minPackedValue, 0, bytesPerDim, upperPointQuery, 0, bytesPerDim) > 0)
                final DocIdSet docIdSet = bucketDocsBuilder.build();
                || (lowerPointQuery != null
            adder.add(docID);
        }
            first = false;  
        public void visit(int docID) throws IOException {
class PointsSortedDocsProducer extends SortedDocsProducer {
            }
                long maxBucket = bucketFunction.applyAsLong(maxPackedValue);
            }
            int bytesPerDim,
        ) {
                bucketDocsBuilder = new DocIdSetBuilder(maxDoc);
/**  
            this.lowerBucket = lowerBucket;
        public void grow(int count) {
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
import org.apache.lucene.search.CollectionTerminatedException;  
    }  
    @Override
        if (upperValue != null) {  
        DocIdSetBuilder.BulkAdder adder;
        if (lowerValue != null) {
import org.apache.lucene.search.DocIdSet;
/*
import java.io.IOException;
 */
 * The OpenSearch Contributors require contributions made to  
        final CompositeValuesCollectorQueue queue;  
/*  
            // check the current bounds
        long upperBucket = Long.MAX_VALUE;
 *
        DocIdSetBuilder bucketDocsBuilder;
    DocIdSet processLeaf(Query query, CompositeValuesCollectorQueue queue, LeafReaderContext context, boolean fillDocIdSet)  
            if (first == false) {
    private final byte[] upperPointQuery;
                final DocIdSet docIdSet = bucketDocsBuilder.build();  
        public void visit(int docID, byte[] packedValue) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
        int remaining;  
 * GitHub history for details.
                processBucket(queue, context, docIdSet.iterator(), lastBucket, builder);
            lastBucket = bucket;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
                throw new IllegalStateException("expected Long, got " + lowerValue.getClass());  
        @Override  
            upperBucket = (Long) upperValue;
            CompositeValuesCollectorQueue queue,  
                    // this bucket does not have any competitive composite buckets,
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return fillDocIdSet ? builder.build() : DocIdSet.EMPTY;
                    return PointValues.Relation.CELL_OUTSIDE_QUERY;  
import org.apache.lucene.search.Query;
 * Modifications Copyright OpenSearch Contributors. See
            if (upperValue.getClass() != Long.class) {
            this.queue = queue;
        final long upperBucket;
            }
            return PointValues.Relation.CELL_CROSSES_QUERY;
        }  
    private class Visitor implements PointValues.IntersectVisitor {
                    // we can early terminate the collection because the remaining buckets are guaranteed  
        }
        }  
