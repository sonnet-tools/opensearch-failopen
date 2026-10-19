import org.apache.lucene.search.Query;  
                subAggregationResults,  
/**
 * software distributed under the License is distributed on an
package org.opensearch.join.aggregations;
import org.opensearch.search.aggregations.support.ValuesSource;
    }  
        AggregatorFactories factories,
/*
            owningBucketOrds,
 */
        String name,  
import org.opensearch.search.aggregations.bucket.BucketsAggregator;  
    }
import org.opensearch.search.aggregations.InternalAggregation;
import org.opensearch.search.internal.SearchContext;
 */
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
    @Override
}
        SearchContext context,
 * SPDX-License-Identifier: Apache-2.0
        ValuesSource.Bytes.WithOrdinals valuesSource,  
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                bucketDocCount(owningBucketOrd),
 */  
    static final ParseField TYPE_FIELD = new ParseField("type");  
        return new InternalParent(name, 0, buildEmptySubAggregations(), metadata());
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.Aggregator;
        CardinalityUpperBound cardinality,
    public ChildrenToParentAggregator(
        Query parentFilter,
            (owningBucketOrd, subAggregationResults) -> new InternalParent(  
import org.opensearch.search.aggregations.CardinalityUpperBound;
        );  
    }  
 * under the License.  
import java.util.Map;
 *  
        return buildAggregationsForSingleBucket(
public class ChildrenToParentAggregator extends ParentJoinAggregator {
 *
                metadata()
                name,
    public InternalAggregation buildEmptyAggregation() {
            )
import org.opensearch.core.ParseField;
        super(name, factories, context, parent, childFilter, parentFilter, valuesSource, maxOrd, cardinality, metadata);
 *
        long maxOrd,
    @Override  
 * Unless required by applicable law or agreed to in writing,
        Map<String, Object> metadata  
 * Modifications Copyright OpenSearch Contributors. See  
/*  
 * A {@link BucketsAggregator} which resolves to the matching parent documents.
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
 * compatible open source license.
 * not use this file except in compliance with the License.
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
    ) throws IOException {
        Aggregator parent,  
import org.opensearch.search.aggregations.AggregatorFactories;  
 * this work for additional information regarding copyright
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {  
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
        Query childFilter,
 */  
