        AggregatorFactories.Builder subFactoriesBuilder,
    }
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
 */  
            metadata  
        Range[] ranges,  
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
        boolean keyed,
    @Override
}
        );
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**
        Map<String, Object> metadata  
 */  
import org.opensearch.index.query.QueryShardContext;
import java.io.IOException;
            parent,
import java.util.Map;  
 * compatible open source license.
        return true;  
            subFactoriesBuilder,
        String name,
 *    http://www.apache.org/licenses/LICENSE-2.0
        Factory<?, ?> rangeFactory,
import org.opensearch.search.aggregations.bucket.range.InternalRange.Factory;
 */  
 *
            ranges,  
            name,  
            config,
        QueryShardContext queryShardContext,  
 *  
 * Aggregation Factory for range aggregators  
 * license agreements. See the NOTICE file distributed with
    public RangeAggregatorFactory(  
 * this work for additional information regarding copyright
package org.opensearch.search.aggregations.bucket.range;
 *
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
 *
        ValuesSourceConfig config,
/*  
            rangeFactory,
    ) throws IOException {
/*
        AggregatorFactory parent,
        super(
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal
 * not use this file except in compliance with the License.
    }
 */
import org.opensearch.search.aggregations.bucket.range.RangeAggregator.Range;
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
            keyed,
import org.opensearch.search.aggregations.AggregatorFactory;  
            RangeAggregationBuilder.REGISTRY_KEY,
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * You may obtain a copy of the License at  
import org.opensearch.search.aggregations.AggregatorFactories;
            queryShardContext,  
 * SPDX-License-Identifier: Apache-2.0
    protected boolean supportsConcurrentSegmentSearch() {
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
public class RangeAggregatorFactory extends AbstractRangeAggregatorFactory<RangeAggregator.Range> {
