 *
        Aggregator parent,
                if (recordingWrapper == null) {
    /**  
import java.io.IOException;
        String name,
        SearchContext context,  
        if (recordingWrapper != null) {  
                }  
 * not use this file except in compliance with the License.
 */
     * calculation of a child aggregation until a first pass is complete and a
     *
    private List<String> deferredAggregationNames;
 * the Apache License, Version 2.0 (the "License"); you may
        AggregatorFactories factories,
            add.accept("deferred_aggregators", deferredAggregationNames);
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.BucketCollector;  
     * @return true if the aggregator should be deferred until a first pass at  
        if (deferredAggregationNames != null) {
            recordingWrapper.prepareSelectedBuckets(ordsToCollect);
                collectors.add(subAggregators[i]);
    public void collectDebugInfo(BiConsumer<String, Object> add) {  
 *  
    private DeferringBucketCollector recordingWrapper;  
 * software distributed under the License is distributed on an
 */  
            collectors.add(recordingWrapper);
 * this file be licensed under the Apache-2.0 license or a
    /**
 * Unless required by applicable law or agreed to in writing,
    protected DeferableBucketAggregator(  
import org.opensearch.search.aggregations.CardinalityUpperBound;
            recordingWrapper.setDeferredCollector(deferredAggregations);  
        }
    }
/*  
    protected void beforeBuildingBuckets(long[] ordsToCollect) throws IOException {
     * set of buckets has been pruned.  
    }  
     */
    }
                deferredAggregations.add(subAggregators[i]);
        if (recordingWrapper != null) {
 */  
 * KIND, either express or implied.  See the License for the
     */
            } else {
package org.opensearch.search.aggregations.bucket;
 * The OpenSearch Contributors require contributions made to  
    @Override
import org.opensearch.search.aggregations.AggregatorFactories;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
                    deferredAggregationNames = new ArrayList<>(subAggregators.length);
import java.util.Map;
        }
        // but an alternative defer policy may be based on best docs.
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
import java.util.List;
        // Default impl is a collector that selects the best buckets
 *
 * license agreements. See the NOTICE file distributed with
 * under the License.  
        // Assumes that we're collecting MANY buckets.
import java.util.function.BiConsumer;  
        collectableSubAggregators = MultiBucketCollector.wrap(collectors);  
import org.opensearch.search.aggregations.MultiBucketCollector;
 *
    protected void doPreCollection() throws IOException {  
 * Aggregator that defers collecting docs based on some metric  
 * Licensed to Elasticsearch under one or more contributor  
    ) throws IOException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (shouldDefer(subAggregators[i])) {
     * @param aggregator the child aggregator
    }
        List<BucketCollector> collectors = new ArrayList<>(subAggregators.length);
 */  
 * You may obtain a copy of the License at  
        }
    @Override
     * This method should be overridden by subclasses that want to defer
    public DeferringBucketCollector getDeferringCollector() {  
        Map<String, Object> metadata
}  
    protected boolean shouldDefer(Aggregator aggregator) {  
        for (int i = 0; i < subAggregators.length; ++i) {  
    }  
    }
/*
/*  
        super(name, factories, context, parent, CardinalityUpperBound.MANY, metadata);
     *         collection has completed
        }  
import org.opensearch.search.aggregations.Aggregator;
import org.opensearch.search.internal.SearchContext;  
        List<BucketCollector> deferredAggregations = null;
        super.collectDebugInfo(add);
     * Wrapper that records collections. Non-null if any aggregations have  
                subAggregators[i] = recordingWrapper.wrap(subAggregators[i]);  
 * compatible open source license.
import java.util.ArrayList;  
 * GitHub history for details.
                    deferredAggregations = new ArrayList<>(subAggregators.length);
        return false;
     * been deferred.
        return new BestBucketsDeferringCollector(context(), descendsFromGlobalAggregator(parent()));  
    @Override
                    recordingWrapper = getDeferringCollector();  
/**
            }  
 * Modifications Copyright OpenSearch Contributors. See
public abstract class DeferableBucketAggregator extends BucketsAggregator {
 * @opensearch.internal
                deferredAggregationNames.add(subAggregators[i].name());
