        bucketOrds = LongKeyedBucketOrds.build(context.bigArrays(), cardinality);  
                spare.docCount = bucketDocCount(ordsEnum.ord());
/**  
 *
            topBucketsPerOrd[ordIdx] = new BaseGeoGridBucket[ordered.size()];
import org.opensearch.search.aggregations.Aggregator;
        }
            results[ordIdx] = buildAggregation(name, requiredSize, Arrays.asList(topBucketsPerOrd[ordIdx]), metadata());  
     * This method is used to return a re-usable instance of the bucket when building  
    protected abstract T buildAggregation(String name, int requiredSize, List<BaseGeoGridBucket> buckets, Map<String, Object> metadata);  
import org.opensearch.common.lease.Releasables;  
    }  
    public BaseGeoGrid buildEmptyAggregation() {  
import org.opensearch.search.aggregations.CardinalityUpperBound;  
        this.valuesSource = valuesSource;  
        return results;
 * The OpenSearch Contributors require contributions made to  
        Aggregator parent,
    protected final ValuesSource.Numeric valuesSource;  
                topBucketsPerOrd[ordIdx][i] = ordered.pop();  
                        }
 */
                            }  
     * @return a new {@link BaseGeoGridBucket} implementation with empty parameters
                    }  
                // need a special function to keep the source bucket
        AggregatorFactories factories,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                                bucketOrdinal = -1 - bucketOrdinal;
                                collectExistingBucket(sub, doc, bucketOrdinal);  
     * the aggregation.
            @Override  
import java.util.Map;
import org.opensearch.search.internal.SearchContext;
                        if (previous != val || i == 0) {
                // up-to-date so it can get the appropriate key  
    @Override
import org.opensearch.search.aggregations.InternalAggregation;
    public ScoreMode scoreMode() {
        Map<String, Object> metadata  
 * Aggregates data expressed as longs (for efficiency's sake) but formats results as aggregation-specific strings.
    protected final int shardSize;
        String name,
                            previous = val;
 * KIND, either express or implied.  See the License for the
        for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
import org.opensearch.search.aggregations.LeafBucketCollectorBase;  
            }
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {  
 * You may obtain a copy of the License at  
        super(name, factories, aggregationContext, parent, CardinalityUpperBound.MANY, metadata);
import org.opensearch.search.aggregations.bucket.BucketsAggregator;
import java.util.Collections;
        int shardSize,
            int size = (int) Math.min(bucketOrds.bucketsInOrd(owningBucketOrds[ordIdx]), shardSize);
        return buildAggregation(name, requiredSize, Collections.emptyList(), metadata());
 * Unless required by applicable law or agreed to in writing,
import java.util.Arrays;
    protected GeoGridAggregator(  
    /**
    }
    }  
            while (ordsEnum.next()) {  
    }
                }  
            }
        Releasables.close(bucketOrds);  
import java.io.IOException;  
/*
                        final long val = values.nextValue();
                spare.hashAsLong = ordsEnum.value();
 *  
        };  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
        int requiredSize,
 * SPDX-License-Identifier: Apache-2.0
                    for (int i = 0; i < valuesCount; ++i) {  
 *
import org.opensearch.search.aggregations.support.ValuesSource;  
        this.requiredSize = requiredSize;
                                collectBucket(sub, doc, bucketOrdinal);
 * @opensearch.api  
 */
 * ownership. Elasticsearch licenses this file to you under  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
            LongKeyedBucketOrds.BucketOrdsEnum ordsEnum = bucketOrds.ordsEnum(owningBucketOrds[ordIdx]);
    @Override
        InternalAggregation[] results = new InternalAggregation[owningBucketOrds.length];
            return ScoreMode.COMPLETE;  
                    long previous = Long.MAX_VALUE;
            public void collect(int doc, long owningBucketOrd) throws IOException {
            BucketPriorityQueue<BaseGeoGridBucket> ordered = new BucketPriorityQueue<>(size);  
/*
                    final int valuesCount = values.docValueCount();  
                            if (bucketOrdinal < 0) { // already seen
            BaseGeoGridBucket spare = null;
                spare = ordered.insertWithOverflow(spare);
        SearchContext aggregationContext,  
import org.apache.lucene.index.LeafReaderContext;  
                }
    }
        SortedNumericDocValues values = valuesSource.longValues(ctx);
        BaseGeoGridBucket[][] topBucketsPerOrd = new BaseGeoGridBucket[owningBucketOrds.length][];
                            } else {
            for (int i = ordered.size() - 1; i >= 0; --i) {
 * not use this file except in compliance with the License.
    @Override  
    @Override  
        return new LeafBucketCollectorBase(sub, null) {
        for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {  
 *
import org.opensearch.search.aggregations.bucket.terms.LongKeyedBucketOrds;
 */
        ValuesSource.Numeric valuesSource,  
import org.opensearch.search.aggregations.AggregatorFactories;
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See  
    public void doClose() {
 * compatible open source license.
    protected abstract BaseGeoGridBucket newEmptyBucket();
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
    protected final LongKeyedBucketOrds bucketOrds;
    }
                if (spare == null) {
                            long bucketOrdinal = bucketOrds.add(owningBucketOrd, val);  
        }
}
import java.util.List;  
 * this work for additional information regarding copyright
                spare.bucketOrd = ordsEnum.ord();  
                    spare = newEmptyBucket();
        buildSubAggsForAllBuckets(topBucketsPerOrd, b -> b.bucketOrd, (b, aggs) -> b.aggregations = aggs);  
        if (valuesSource != null && valuesSource.needsScores()) {
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.search.ScoreMode;
    protected final int requiredSize;
     */  
                if (values.advanceExact(doc)) {
public abstract class GeoGridAggregator<T extends BaseGeoGrid> extends BucketsAggregator {
package org.opensearch.geo.search.aggregations.bucket.geogrid;
    ) throws IOException {
import org.apache.lucene.index.SortedNumericDocValues;
            }
 * this file be licensed under the Apache-2.0 license or a
/*  
import org.opensearch.search.aggregations.LeafBucketCollector;
        this.shardSize = shardSize;
 * software distributed under the License is distributed on an
        return super.scoreMode();
        CardinalityUpperBound cardinality,
        }
 */  
 * license agreements. See the NOTICE file distributed with
