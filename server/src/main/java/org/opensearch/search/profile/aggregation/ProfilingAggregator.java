    @Override
    @Override  
 *
    @Override  
/**  
import java.io.IOException;  
    public Aggregator getDelegate() {
    }
}  
import org.opensearch.search.aggregations.Aggregator;  
 * An aggregator that aggregates the performance profiling of other aggregations
        }  
    }  
    @Override
    public Aggregator subAggregator(String name) {
 * You may obtain a copy of the License at  
    public SearchContext context() {  
    @Override
import org.apache.lucene.search.ScoreMode;
    }
        return delegate.scoreMode();  
        super.reset();
    public Aggregator unwrapAggregator() {  
import org.opensearch.search.sort.SortOrder;
        Timer timer = profileBreakdown.getTimer(AggregationTimingType.INITIALIZE);
import org.opensearch.search.profile.Timer;  
 * Licensed to Elasticsearch under one or more contributor  
    }  
    @Override
    public void postCollection() throws IOException {  
        }
    @Override
            timer.stop();  
    }
        Timer timer = profileBreakdown.getTimer(AggregationTimingType.BUILD_LEAF_COLLECTOR);
    }
 * under the License.  
 *
    public InternalAggregation buildEmptyAggregation() {
    @Override
/*  
            delegate.collectDebugInfo(profileBreakdown::addDebugInfo);
    }
        this.profiler = profiler;
    @Override
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.internal.SearchContext;
    }
    @Override
    public String name() {
    public ProfilingAggregator(Aggregator delegate, AggregationProfiler profiler) {  
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
        try {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.profile.ProfilingWrapper;
import org.apache.lucene.index.LeafReaderContext;
        return delegate.bucketComparator(key, order);  
    @Override
    public Aggregator parent() {
        return delegate.subAggregator(name);
        this.profileBreakdown = profiler.getQueryBreakdown(delegate);  
        timer.start();
 * this file be licensed under the Apache-2.0 license or a
    }
    @Override  
        profiler.pollLastElement();
 * this work for additional information regarding copyright
        return delegate.resolveSortPath(next, path);
    public void close() {  
        this.delegate = delegate;
    }
 */  
import org.opensearch.search.aggregations.InternalAggregation;
            delegate.preCollection();
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
            timer.stop();  
import org.opensearch.search.aggregations.LeafBucketCollector;
 */
 */
            return new ProfilingLeafBucketCollector(delegate.getLeafCollector(ctx), profileBreakdown);
    public void reset() {
        delegate.close();
package org.opensearch.search.profile.aggregation;
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        }
        } finally {  
    private AggregationProfileBreakdown profileBreakdown;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.support.AggregationPath.PathElement;  
        } finally {
    }  
            delegate.postCollection();
 *  
    @Override
public class ProfilingAggregator extends Aggregator implements ProfilingWrapper<Aggregator> {  
        try {  
        } finally {
 * ownership. Elasticsearch licenses this file to you under  
        try {  
            timer.stop();  
    private final Aggregator delegate;
    public Aggregator resolveSortPath(PathElement next, Iterator<PathElement> path) {  
        Timer timer = profileBreakdown.getTimer(AggregationTimingType.POST_COLLECTION);
        } finally {
    }  
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx) throws IOException {  
        return delegate.name();
    }
    @Override
        return delegate;
 * The OpenSearch Contributors require contributions made to  
        timer.start();
import java.util.Iterator;
/*  
        return delegate.toString();  
        }
    private final AggregationProfiler profiler;  
    public void preCollection() throws IOException {
    @Override  
            return delegate.buildAggregations(owningBucketOrds);
    public ScoreMode scoreMode() {
    }
        delegate.reset();  
 * license agreements. See the NOTICE file distributed with
        Timer timer = profileBreakdown.getTimer(AggregationTimingType.BUILD_AGGREGATION);
    @Override  
    @Override
    }
 * software distributed under the License is distributed on an
            timer.stop();
        return delegate.buildEmptyAggregation();
    }  
        timer.start();  
 * specific language governing permissions and limitations
        timer.start();
        try {  
        return delegate.parent();  
        return delegate.context();
    public String toString() {
    public BucketComparator bucketComparator(String key, SortOrder order) {
 * Modifications Copyright OpenSearch Contributors. See
        return delegate;
/*
 * not use this file except in compliance with the License.
 * compatible open source license.
    }  
