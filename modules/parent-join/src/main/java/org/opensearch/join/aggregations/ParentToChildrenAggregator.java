 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
import java.util.Map;
public class ParentToChildrenAggregator extends ParentJoinAggregator {  
    @Override
        Aggregator parent,
 */
        return new InternalChildren(name, 0, buildEmptySubAggregations(), metadata());
 * under the License.  
        Map<String, Object> metadata
        SearchContext context,
        Query childFilter,  
    @Override
        ValuesSource.Bytes.WithOrdinals valuesSource,
/*  
import org.apache.lucene.search.Query;  
        Query parentFilter,
    ) throws IOException {  
 * license agreements. See the NOTICE file distributed with
                metadata()  
import org.opensearch.search.aggregations.support.ValuesSource;  
}  
 *
    static final ParseField TYPE_FIELD = new ParseField("type");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        CardinalityUpperBound cardinality,
 */  
import org.opensearch.search.aggregations.CardinalityUpperBound;
import java.io.IOException;  
                name,  
                subAggregationResults,
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 *
 * ownership. Elasticsearch licenses this file to you under  
        AggregatorFactories factories,  
    }
 * this work for additional information regarding copyright
            )
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
    public InternalAggregation buildEmptyAggregation() {  
 * The OpenSearch Contributors require contributions made to  
    }
        );
 * compatible open source license.
 * software distributed under the License is distributed on an
                bucketDocCount(owningBucketOrd),
            (owningBucketOrd, subAggregationResults) -> new InternalChildren(
package org.opensearch.join.aggregations;
            owningBucketOrds,
 * Modifications Copyright OpenSearch Contributors. See  
    }  
        return buildAggregationsForSingleBucket(  
/*
import org.opensearch.core.ParseField;
import org.opensearch.search.internal.SearchContext;
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.AggregatorFactories;  
        long maxOrd,  
import org.opensearch.search.aggregations.InternalAggregation;
    public ParentToChildrenAggregator(
 */
        super(name, factories, context, parent, parentFilter, childFilter, valuesSource, maxOrd, cardinality, metadata);
import org.opensearch.search.aggregations.Aggregator;
 * specific language governing permissions and limitations
        String name,
 *  
/*
 * not use this file except in compliance with the License.
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
