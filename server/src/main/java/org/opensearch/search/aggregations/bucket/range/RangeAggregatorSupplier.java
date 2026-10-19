        SearchContext context,
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.CardinalityUpperBound;  
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
        Aggregator parent,
/*
/**
 */
        ValuesSourceConfig config
import org.opensearch.search.aggregations.support.ValuesSource;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 */  
import org.opensearch.search.internal.SearchContext;  
 * this work for additional information regarding copyright
        ValuesSource.Numeric valuesSource,
        Map<String, Object> metadata,
 * compatible open source license.
import java.io.IOException;
 *
        CardinalityUpperBound cardinality,  
import java.util.Map;  
 * GitHub history for details.
 */  
 *  
package org.opensearch.search.aggregations.bucket.range;
}
 * @opensearch.internal
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.aggregations.AggregatorFactories;
import org.opensearch.search.aggregations.Aggregator;
 * SPDX-License-Identifier: Apache-2.0
        RangeAggregator.Range[] ranges,
    Aggregator build(
 *
 * Modifications Copyright OpenSearch Contributors. See  
        AggregatorFactories factories,
/*
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.DocValueFormat;  
        String name,  
    ) throws IOException;  
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
        DocValueFormat format,  
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
public interface RangeAggregatorSupplier {
 * Base Aggregator supplier interface for range aggs  
        boolean keyed,  
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
 */
        InternalRange.Factory rangeFactory,
