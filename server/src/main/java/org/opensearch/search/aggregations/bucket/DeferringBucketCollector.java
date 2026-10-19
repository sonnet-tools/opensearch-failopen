            return in.scoreMode();
        @Override
 *
     */  
        @Override
     * been collected directly.
    }  
        @Override  
            throw new IllegalStateException(
        public LeafBucketCollector getLeafCollector(LeafReaderContext ctx) throws IOException {
        @Override
        public Aggregator resolveSortPath(PathElement next, Iterator<PathElement> path) {
    /** Sole constructor. */
 * compatible open source license.
        @Override
            throw new IllegalStateException(
            return in.parent();
        public void postCollection() throws IOException {  
 *
        }
        public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {  
            return in.buildEmptyAggregation();  
     * Wrap the provided aggregator so that it behaves (almost) as if it had
                "Deferred collectors cannot be collected directly. They must be collected through the recording wrapper."  
 * ownership. Elasticsearch licenses this file to you under  
/*  
            throw new IllegalStateException(  
        @Override  
package org.opensearch.search.aggregations.bucket;
        }  
        }
        @Override  
/*  
    public Aggregator wrap(final Aggregator in) {
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.InternalAggregation;
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
        @Override
        WrappedAggregator(Aggregator in) {
 * license agreements. See the NOTICE file distributed with
        public Aggregator parent() {  
 */
    /**
}
import java.util.Iterator;  
        @Override
    protected class WrappedAggregator extends Aggregator {
        }
            );
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.index.LeafReaderContext;
            );  
public abstract class DeferringBucketCollector extends BucketCollector {
        }
        public String name() {
        }  
        public void preCollection() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.BucketCollector;
     * Replay the deferred hits on the selected buckets.
            this.in = in;
 * GitHub history for details.
            );
 * not use this file except in compliance with the License.
 * allows to replay a subset of the collected buckets.
/**
        @Override  
        @Override
import java.io.IOException;
            return in.resolveSortPath(next, path);
        public InternalAggregation buildEmptyAggregation() {
        }
            return in.name();
 */  
            return in.context();  
        public Aggregator subAggregator(String name) {
        }  
import org.opensearch.search.aggregations.support.AggregationPath.PathElement;
        private Aggregator in;
        }
        public void close() {
import org.apache.lucene.search.ScoreMode;
    public abstract void setDeferredCollector(Iterable<BucketCollector> deferredCollectors);
     * @opensearch.internal
    /**
 * this work for additional information regarding copyright
     */  
    /** Set the deferred collectors. */
        public BucketComparator bucketComparator(String key, SortOrder order) {  
/*
 */  
import org.opensearch.search.aggregations.Aggregator;  
    }  
    public DeferringBucketCollector() {}
        public ScoreMode scoreMode() {  
 * KIND, either express or implied.  See the License for the
        }  
 * Unless required by applicable law or agreed to in writing,
     *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * A wrapped aggregator  
    /**  
import org.opensearch.search.internal.SearchContext;
    public abstract void prepareSelectedBuckets(long... selectedBuckets) throws IOException;
        }
 * You may obtain a copy of the License at  
        public SearchContext context() {
 * under the License.  
 */
        }
        }
        return new WrappedAggregator(in);
            return in.buildAggregations(owningBucketOrds);
            throw new UnsupportedOperationException("Can't sort on deferred aggregations");
        @Override
import org.opensearch.search.sort.SortOrder;  
 * The OpenSearch Contributors require contributions made to  
 *
 *  
 * A {@link BucketCollector} that records collected doc IDs and buckets and  
 * @opensearch.internal  
            in.close();  
import org.opensearch.search.aggregations.LeafBucketCollector;  
 * SPDX-License-Identifier: Apache-2.0
                "Deferred collectors cannot be collected directly. They must be collected through the recording wrapper."
        }  
 * software distributed under the License is distributed on an
                "Deferred collectors cannot be collected directly. They must be collected through the recording wrapper."
            return in.subAggregator(name);
