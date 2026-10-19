/*
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 * Aggregation Factory for date_range agg
import org.opensearch.search.aggregations.AggregatorFactories;
 *
            metadata
 *
}  
 * KIND, either express or implied.  See the License for the
    protected boolean supportsConcurrentSegmentSearch() {  
    }  
        QueryShardContext queryShardContext,
    ) throws IOException {
    @Override
/*  
 * ownership. Elasticsearch licenses this file to you under  
 */  
            config,  
        Map<String, Object> metadata
        InternalRange.Factory<?, ?> rangeFactory,  
            keyed,
            parent,
            subFactoriesBuilder,  
 * You may obtain a copy of the License at  
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
        AggregatorFactory parent,
 */  
            name,
 */
/**  
 * not use this file except in compliance with the License.
/*  
import java.io.IOException;  
        ValuesSourceConfig config,  
 * this file be licensed under the Apache-2.0 license or a
            queryShardContext,
    }
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
        String name,
package org.opensearch.search.aggregations.bucket.range;
        AggregatorFactories.Builder subFactoriesBuilder,  
 *  
 *
import org.opensearch.search.aggregations.AggregatorFactory;  
 * Modifications Copyright OpenSearch Contributors. See
public class DateRangeAggregatorFactory extends AbstractRangeAggregatorFactory<RangeAggregator.Range> {
        super(  
import org.opensearch.index.query.QueryShardContext;
        return true;
import java.util.Map;
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @opensearch.internal  
            ranges,
        RangeAggregator.Range[] ranges,
        );
 * compatible open source license.
 */
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
            DateRangeAggregationBuilder.REGISTRY_KEY,
 * under the License.  
            rangeFactory,  
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
        boolean keyed,
    public DateRangeAggregatorFactory(
