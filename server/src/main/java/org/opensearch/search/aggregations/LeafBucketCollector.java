 * Unless required by applicable law or agreed to in writing,
                return colls[0];  
 * this work for additional information regarding copyright
     * particular owning bucket. The {@code terms} aggregation, for example,
    @Override
 * Per-leaf bucket collector.
/*  
     * return rangeCount * owningBucketOrd + matchingRange(value);
import org.apache.lucene.index.DocValuesSkipper;
     *
     * <strong>make</strong> new ordinals. So their implementation generally
    /**
    public void collect(int doc) throws IOException {
     * <p>
    }
    }
                return new LeafBucketCollector() {
     * Some bucket aggregations "know" how many ordinals each owning ordinal  
        // helping the performance: when the super call inlines, calls to #collect(int, long) become monomorphic.
    }
                return NO_OP_COLLECTOR;
        public void collect(int doc, long bucket) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     *
    public void collect(DocIdStream stream) throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
    @ExperimentalApi
    public static LeafBucketCollector wrap(Iterable<LeafBucketCollector> collectors) {
        // helping the performance: when the super call inlines, calls to #collect(int, long) become monomorphic.
import java.util.stream.StreamSupport;
 */  
 * specific language governing permissions and limitations
 *
     * }</pre>  
    }
     * max} is guaranteed to be greater than {@code min}.  
     * <p>Note: The provided {@link DocIdStream} may be reused across calls and should be consumed immediately.
 * GitHub history for details.
     * Other aggregations don't know how many buckets will fall into any  
                            c.setScorer(s);
 * You may obtain a copy of the License at  
    }  
/**  
    @Override  
 * @opensearch.internal  
     * Like collect(int), it is guaranteed that doc IDs get collected in order, ie. doc IDs are collected in order within a DocIdStream, and if
    @Override
                    @Override
        }
package org.opensearch.search.aggregations;
     * uses {@link LongKeyedBucketOrds} which amounts to a hash lookup.
     * needs so they can map "densely". The {@code range} aggregation, for
            .filter(c -> c != NO_OP_COLLECTOR);  
}
        final Stream<LeafBucketCollector> actualCollectors = StreamSupport.stream(collectors.spliterator(), false)
        @Override
                    }  
 *
                };  
    public void collectRange(int min, int max) throws IOException {
     * @see #collect(int,long)
        @Override
public abstract class LeafBucketCollector implements LeafCollector {
        // no-op by default
 * Licensed to Elasticsearch under one or more contributor  
    public void setScorer(Scorable scorer) throws IOException {
        stream.forEach((doc) -> collect(doc, owningBucketOrd));  
     * <p>The default implementation calls {@code stream.forEach(doc -> collect(doc, owningBucketOrd))}.  
     * <p>The default implementation calls {@link #collect(DocIdStream)} on a {@link DocIdStream} that
    public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {  
     * <p>Extending this method is typically useful to take advantage of pre-aggregated data exposed
                        }  
 *  
        collect(stream, 0);
        collect(doc, 0);
     *
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
     * <p>It is legal for callers to mix calls to {@link #collect(DocIdStream, long)} and {@link #collect(int, long)}.
/*
/*  
 * The OpenSearch Contributors require contributions made to  
                    @Override
import java.io.IOException;
import org.apache.lucene.search.LeafCollector;  
 * not use this file except in compliance with the License.
    /**
     * <pre>{@code
 * SPDX-License-Identifier: Apache-2.0
            case 0:  
                    public void setScorer(Scorable s) throws IOException {
                    public void collect(int doc, long bucket) throws IOException {  
            // no-op  
     * looks kind of like  
     * <p>Note: The provided DocIdStream typically only holds a small subset of query matches. This method may be called multiple times per segment.  
     *  
 */
    }  
    @Override  
                            c.collect(doc, bucket);
            collect(docId, 0);  
     */  
     *
        }
     * collectBucket(doc, myBucketOrd);  
        public void setScorer(Scorable arg0) throws IOException {  
     * called twice, all doc IDs from the second DocIdStream will be greater than all doc IDs from the first DocIdStream.
     *  
import org.opensearch.search.aggregations.bucket.terms.LongKeyedBucketOrds;  
 */
     * <pre>{@code  
    };
        for (int docId = min; docId < max; docId++) {
     * <p>
    public abstract void collect(int doc, long owningBucketOrd) throws IOException;
        final LeafBucketCollector[] colls = actualCollectors.toArray(size -> new LeafBucketCollector[size]);
                        for (LeafBucketCollector c : colls) {
     */
        // Different aggregator implementations should override this method even if to just delegate to super for  
     *
     * something along the lines of  
        }
     */  
import java.util.stream.Stream;  
    /**
            // no-op
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
     * Bulk-collect doc IDs within {@code owningBucketOrd}.
 * license agreements. See the NOTICE file distributed with
     * Collect the given {@code doc} in the bucket owned by
import org.apache.lucene.search.Scorable;
     * <p>Bucket aggregations have more trouble because their job is to
     * in a {@link DocValuesSkipper}.  
     * long myBucketOrd = mapOwningBucketAndValueToMyOrd(owningBucketOrd, loadValueFromDoc(doc));
 */  
import org.opensearch.common.annotation.ExperimentalApi;
        switch (colls.length) {
            case 1:
     * matches the given range.  
     * The implementation of this method metric aggregations is generally
 * under the License.  
     * array[owningBucketOrd] += loadValueFromDoc(doc)
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
        // Different aggregator implementations should override this method even if to just delegate to super for
     * {@code owningBucketOrd}.  
     * example, can perform this mapping with something like:
     * Collect a range of doc IDs, between {@code min} inclusive and {@code max} exclusive. {@code
import org.apache.lucene.search.DocIdStream;
     * <pre>{@code
                        for (LeafBucketCollector c : colls) {  
                    }
     * }</pre>
 * Modifications Copyright OpenSearch Contributors. See
 *
                        }
     * }</pre>
            default:
    public static final LeafBucketCollector NO_OP_COLLECTOR = new LeafBucketCollector() {
