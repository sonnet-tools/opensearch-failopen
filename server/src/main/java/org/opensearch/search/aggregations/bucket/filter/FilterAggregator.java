/*  
        CardinalityUpperBound cardinality,
        return buildAggregationsForSingleBucket(
import org.opensearch.search.internal.SearchContext;
                if (bits.get(doc)) {  
            )
    private final Supplier<Weight> filter;
        AggregatorFactories factories,
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {  
 *  
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        SearchContext context,
        super(name, factories, context, parent, cardinality, metadata);
    ) throws IOException {  
import org.opensearch.search.aggregations.AggregatorFactories;  
 *
            }  
                    collectBucket(sub, doc, bucket);
 * under the License.  
/*
        return new InternalFilter(name, 0, buildEmptySubAggregations(), metadata());
import org.opensearch.search.aggregations.bucket.BucketsAggregator;
 * not use this file except in compliance with the License.
                }
 * KIND, either express or implied.  See the License for the
        final Bits bits = Lucene.asSequentialAccessBits(ctx.reader().maxDoc(), filter.get().scorerSupplier(ctx));
        };
 * this work for additional information regarding copyright
 * compatible open source license.
        return new LeafBucketCollectorBase(sub, null) {  
            @Override
            owningBucketOrds,
    public InternalAggregation buildEmptyAggregation() {
import java.io.IOException;  
        Map<String, Object> metadata
 */  
package org.opensearch.search.aggregations.bucket.filter;
import org.apache.lucene.search.Weight;
            public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {  
import java.util.Map;
 * Licensed to Elasticsearch under one or more contributor  
    }  
import org.opensearch.search.aggregations.Aggregator;
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.filter = filter;
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
 * The OpenSearch Contributors require contributions made to  
            @Override
                subAggregationResults,  
 * Aggregate all docs that match a filter.
 * Modifications Copyright OpenSearch Contributors. See  
 * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
        Supplier<Weight> filter,  
public class FilterAggregator extends BucketsAggregator implements SingleBucketAggregator {  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.index.LeafReaderContext;  
            public void collect(int doc, long bucket) throws IOException {
 */
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.bucket.SingleBucketAggregator;  
}
    }
 * GitHub history for details.
import java.util.function.Supplier;
    @Override
import org.opensearch.common.lucene.Lucene;
 *  
 * license agreements. See the NOTICE file distributed with
    public FilterAggregator(
 * ownership. Elasticsearch licenses this file to you under  
            }
        String name,
                super.collectRange(min, max);  
        );  
            (owningBucketOrd, subAggregationResults) -> new InternalFilter(  
 */
    @Override  
import org.apache.lucene.util.Bits;  
 * You may obtain a copy of the License at  
import org.apache.lucene.search.DocIdStream;
import org.opensearch.search.aggregations.LeafBucketCollector;  
import org.opensearch.search.aggregations.InternalAggregation;
                name,
            public void collectRange(int min, int max) throws IOException {
 *
    @Override
/**
import org.opensearch.search.aggregations.CardinalityUpperBound;
                metadata()
        // no need to provide deleted docs to the filter
        Aggregator parent,  
                super.collect(stream, owningBucketOrd);
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {  
 */
                bucketDocCount(owningBucketOrd),
 * the Apache License, Version 2.0 (the "License"); you may
            @Override
/*
    }  
    }  
