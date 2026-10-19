                "Aggregation ["
import java.io.IOException;  
        SearchContext searchContext,
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.aggregations.CardinalityUpperBound;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
        QueryShardContext queryShardContext,  
            throw new AggregationExecutionException(
                    + "sub-aggregation ["
                    + name  
 */
    ) throws IOException {
    }
 * this work for additional information regarding copyright
 */
    }
        CardinalityUpperBound cardinality,  
 * GitHub history for details.
    @Override
        return true;  
 * @opensearch.internal  
        }  
    @Override
        }  
        Map<String, Object> metadata
/**  
                    + "]. Global aggregations can only be defined as top level aggregations"
public class GlobalAggregatorFactory extends AggregatorFactory {
import org.opensearch.search.aggregations.AggregationExecutionException;
 * not use this file except in compliance with the License.
 *
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.aggregations.AggregatorFactory;
 * license agreements. See the NOTICE file distributed with
        Aggregator parent,
        if (cardinality != CardinalityUpperBound.ONE) {
                    + parent.name()  
 *
 * the Apache License, Version 2.0 (the "License"); you may
/*  
        Map<String, Object> metadata  
 * software distributed under the License is distributed on an
            throw new AggregationExecutionException("Aggregation [" + name() + "] must have cardinality 1 but was [" + cardinality + "]");
            );
 */  
}
 * this file be licensed under the Apache-2.0 license or a
        AggregatorFactories.Builder subFactories,
        if (parent != null) {  
        AggregatorFactory parent,
                    + "] cannot have a global "
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.Aggregator;  
package org.opensearch.search.aggregations.bucket.global;
    protected boolean supportsConcurrentSegmentSearch() {
/*  
/*
 */  
 * Aggregation Factory for global agg
    ) throws IOException {
import java.util.Map;
 *  
    }  
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.aggregations.AggregatorFactories;
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.internal.SearchContext;
        String name,
 * under the License.  
        return new GlobalAggregator(name, factories, searchContext, metadata);
        super(name, queryShardContext, parent, subFactories, metadata);
    public Aggregator createInternal(  
    public GlobalAggregatorFactory(
 * You may obtain a copy of the License at  
import org.opensearch.index.query.QueryShardContext;
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
