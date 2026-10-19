                name,  
import org.apache.lucene.index.LeafReaderContext;  
    public InternalAggregation buildEmptyAggregation() {  
        super(name, subFactories, aggregationContext, null, CardinalityUpperBound.ONE, metadata);
 * under the License.  
    public GlobalAggregator(String name, AggregatorFactories subFactories, SearchContext aggregationContext, Map<String, Object> metadata)
import org.opensearch.search.aggregations.InternalAggregation;  
import java.util.Map;
import java.io.IOException;
 *  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 */
    @Override  
import org.opensearch.search.aggregations.bucket.SingleBucketAggregator;
import org.opensearch.search.aggregations.bucket.BucketsAggregator;  
/*
 * software distributed under the License is distributed on an
        assert owningBucketOrds.length == 1 && owningBucketOrds[0] == 0 : "global aggregator can only be a top level aggregator";
                assert bucket == 0 : "global aggregator can only be a top level aggregator";  
            owningBucketOrds,
                subAggregationResults,
        throw new UnsupportedOperationException(
 *
        };  
            "global aggregations cannot serve as sub-aggregations, hence should never be called on #buildEmptyAggregations"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                metadata()  
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
/**
        );
    @Override
/*  
    @Override
/*
 * KIND, either express or implied.  See the License for the
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
                collectBucket(sub, doc, bucket);
            (owningBucketOrd, subAggregationResults) -> new InternalGlobal(
    }
    }
 * license agreements. See the NOTICE file distributed with
        return buildAggregationsForSingleBucket(  
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.LeafBucketCollector;
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.search.aggregations.bucket.global;
 * You may obtain a copy of the License at  
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
            }
 *
import org.opensearch.search.aggregations.AggregatorFactories;
        );  
 * Licensed to Elasticsearch under one or more contributor  
 * Aggregate all docs from the global search scope.
    }  
 * @opensearch.internal
                bucketDocCount(owningBucketOrd),
            public void collect(int doc, long bucket) throws IOException {
import org.opensearch.search.aggregations.CardinalityUpperBound;
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
            @Override
 *  
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.search.internal.SearchContext;
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
}
public class GlobalAggregator extends BucketsAggregator implements SingleBucketAggregator {  
 * this file be licensed under the Apache-2.0 license or a
    }
 */
        return new LeafBucketCollectorBase(sub, null) {  
 */
 * GitHub history for details.
        throws IOException {  
            )
