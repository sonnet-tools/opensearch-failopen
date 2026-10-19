        return true;  
    }
 * specific language governing permissions and limitations
        SearchContext context,
    }
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
        double precision,  
    @Override
 * under the License.  
/**
        this.maxDocCount = maxDocCount;
        this.format = format;
        return filter;
             * But the RareTerms agg _must_ execute in breadth first since it relies on  
             * and we are not able to generate this score while replaying deferred documents.
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (subAgg.scoreMode().needsScores()) {
/*
/*  
                    + "], and also has a scoring child agg ["
                    + "] is the child of the nested agg ["  
             * Terms agg would force the collect mode to depth_first here, because
 * The OpenSearch Contributors require contributions made to  
                    + "].  This combination is not supported because "
import org.opensearch.search.aggregations.bucket.nested.NestedAggregator;  
 * this file be licensed under the Apache-2.0 license or a
    }
        String nestedAgg = descendsFromNestedAggregator(parent);
 * Base class to Aggregate all docs that contain rare terms
            parent = parent.parent();
        // We seed the rng with the ShardID so results are deterministic and don't change randomly
        String scoringAgg = subAggsNeedScore();
import java.util.Random;
    private String subAggsNeedScore() {  
import org.opensearch.search.aggregations.BucketOrder;
             */
        SetBackedScalingCuckooFilter filter = new SetBackedScalingCuckooFilter(10000, new Random(filterSeed), precision);
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
    public DeferringBucketCollector getDeferringCollector() {
    ) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
    protected boolean shouldDefer(Aggregator aggregator) {
    protected final long maxDocCount;
package org.opensearch.search.aggregations.bucket.terms;
        this.precision = precision;  
        this.filterSeed = context.indexShard().shardId().hashCode();  
            if (parent.getClass() == NestedAggregator.class) {
        long maxDocCount,
        return deferringCollector;  
        Map<String, Object> metadata,
/*  
import org.opensearch.search.internal.SearchContext;
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @opensearch.internal
public abstract class AbstractRareTermsAggregator extends DeferableBucketAggregator {  
             *
        }
import org.opensearch.search.DocValueFormat;
                return subAgg.name();  
        DocValueFormat format
 * You may obtain a copy of the License at  
    private final double precision;
        AggregatorFactories factories,
             * deferring execution, so we just have to throw up our hands and refuse
 * Unless required by applicable law or agreed to in writing,
    protected final DocValueFormat format;  
 */  
                "RareTerms agg ["
import org.opensearch.search.aggregations.AggregatorFactories;
    }
import java.util.Map;
    static final BucketOrder ORDER = BucketOrder.compound(BucketOrder.count(true), BucketOrder.key(true)); // sort by count ascending
import org.opensearch.search.aggregations.bucket.DeferringBucketCollector;
    protected MergingBucketsDeferringCollector deferringCollector;  
 *  
        if (scoringAgg != null && nestedAgg != null) {  
import java.io.IOException;  
            throw new IllegalStateException(  
        return null;
            /*
        filter.registerBreaker(this::addRequestCircuitBreakerBytes);  
        Aggregator parent,  
 *
 * not use this file except in compliance with the License.
        deferringCollector = new MergingBucketsDeferringCollector(context, descendsFromGlobalAggregator(parent()));
 */  
            );  
 * KIND, either express or implied.  See the License for the
        return null;  
                    + name()
                    + scoringAgg  
        }  
                    + "it requires executing in [depth_first] mode, which the RareTerms agg cannot do."
import org.opensearch.search.aggregations.bucket.DeferableBucketAggregator;  
        super(name, factories, context, parent, metadata);  
 *
 * Modifications Copyright OpenSearch Contributors. See
    protected SetBackedScalingCuckooFilter newFilter() {
 *  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.aggregations.Aggregator;  
    @Override  
        while (parent != null) {
    }
    AbstractRareTermsAggregator(
                return parent.name();  
 * SPDX-License-Identifier: Apache-2.0
            }
 * Licensed to Elasticsearch under one or more contributor  
             * we need to access the score of nested documents in a sub-aggregation  
        }
    }
    private final int filterSeed;
                    + nestedAgg
        String name,  
import org.opensearch.common.util.SetBackedScalingCuckooFilter;
 */
        for (Aggregator subAgg : subAggregators) {
    private String descendsFromNestedAggregator(Aggregator parent) {  
 * GitHub history for details.
import org.opensearch.search.aggregations.bucket.MergingBucketsDeferringCollector;
}  
