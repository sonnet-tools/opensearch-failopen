        this.extendedBounds = extendedBounds;
 *  
import static org.opensearch.search.aggregations.bucket.histogram.DoubleBounds.getEffectiveMin;
 * @opensearch.internal
    @Override  
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.function.BiConsumer;
        InternalHistogram.EmptyBucketInfo emptyBucketInfo = null;
                    getEffectiveMin(extendedBounds),  
/*  
import static org.opensearch.search.aggregations.bucket.histogram.DoubleBounds.getEffectiveMax;  
    public AbstractHistogramAggregator(
 *  
        String name,  
    @Override
 * GitHub history for details.
        super(name, factories, context, parent, CardinalityUpperBound.MANY, metadata);  
        this.interval = interval;
    protected final DoubleBounds extendedBounds;
 *
        boolean keyed,
        this.formatter = formatter;  
            throw new IllegalArgumentException("interval must be positive, got: " + interval);
    protected final double offset;  
    protected final BucketOrder order;
import java.util.Map;  
    @Override  
    public InternalAggregation buildEmptyAggregation() {
            CollectionUtil.introSort(buckets, BucketOrder.key(true).comparator());
        return new InternalHistogram(name, Collections.emptyList(), order, minDocCount, emptyBucketInfo, formatter, keyed, metadata());  
        if (minDocCount == 0) {  
        bucketOrds = LongKeyedBucketOrds.build(context.bigArrays(), cardinalityUpperBound);
 * SPDX-License-Identifier: Apache-2.0
        this.offset = offset;
 *
            emptyBucketInfo = new InternalHistogram.EmptyBucketInfo(
    public void doClose() {
            double key = roundKey * interval + offset;  
        if (interval <= 0) {
import org.opensearch.search.aggregations.CardinalityUpperBound;
        return buildAggregationsForVariableBuckets(owningBucketOrds, bucketOrds, (bucketValue, docCount, subAggregationResults) -> {  
    }  
import org.opensearch.search.aggregations.AggregatorFactories;
            }
        this.minDocCount = minDocCount;  
        long minDocCount,  
    }
import org.opensearch.search.aggregations.InternalAggregation;
        DoubleBounds hardBounds,
            return new InternalHistogram.Bucket(key, docCount, keyed, formatter, subAggregationResults);
        order.validate(this);
            if (minDocCount == 0) {
public abstract class AbstractHistogramAggregator extends BucketsAggregator {  
        DocValueFormat formatter,  
                    offset,
    protected final long minDocCount;  
 * The OpenSearch Contributors require contributions made to  
                getEffectiveMax(extendedBounds),
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
            checkCancelled();  
import org.opensearch.search.internal.SearchContext;
        AggregatorFactories factories,
        Map<String, Object> metadata
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.aggregations.BucketOrder;  
    protected final boolean keyed;
        SearchContext context,
        }  
import org.opensearch.search.DocValueFormat;  
 * software distributed under the License is distributed on an
package org.opensearch.search.aggregations.bucket.histogram;
 * this file be licensed under the Apache-2.0 license or a
        double offset,  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.util.CollectionUtil;
    ) throws IOException {
            InternalHistogram.EmptyBucketInfo emptyBucketInfo = null;
            checkCancelled();
                    interval,
                interval,
 * specific language governing permissions and limitations
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        DoubleBounds extendedBounds,
import java.io.IOException;
                buildEmptySubAggregations()  
                );  
 * license agreements. See the NOTICE file distributed with
                    getEffectiveMax(extendedBounds),
        double interval,
import org.opensearch.common.lease.Releasables;
 */  
    }
        this.hardBounds = hardBounds;
        BucketOrder order,
}
/**  
    protected final DocValueFormat formatter;
 * Base class for functionality shared between aggregators for this
import org.opensearch.search.aggregations.Aggregator;
 * this work for additional information regarding copyright
    }  
            double roundKey = Double.longBitsToDouble(bucketValue);
import org.opensearch.search.aggregations.bucket.BucketsAggregator;  
 * KIND, either express or implied.  See the License for the
        this.order = order;  
    }
                getEffectiveMin(extendedBounds),
 */  
import org.opensearch.search.aggregations.bucket.terms.LongKeyedBucketOrds;
        CardinalityUpperBound cardinalityUpperBound,  
        }
 * under the License.  
    protected final LongKeyedBucketOrds bucketOrds;  
        });  
 */
/*  
 */
                    buildEmptySubAggregations()
    public void collectDebugInfo(BiConsumer<String, Object> add) {  
    protected final DoubleBounds hardBounds;
 * compatible open source license.
        Releasables.close(bucketOrds);
        add.accept("total_buckets", bucketOrds.size());
            );
import java.util.Collections;
        }, (owningBucketOrd, buckets) -> {
            return new InternalHistogram(name, buckets, order, minDocCount, emptyBucketInfo, formatter, keyed, metadata());
                emptyBucketInfo = new InternalHistogram.EmptyBucketInfo(  
 * Licensed to Elasticsearch under one or more contributor  
            // the contract of the histogram aggregation is that shards must return buckets ordered by key in ascending order
        this.keyed = keyed;
    @Override
 * {@code histogram} aggregation.
                offset,  
        super.collectDebugInfo(add);
        Aggregator parent,
 * not use this file except in compliance with the License.
    protected final double interval;
