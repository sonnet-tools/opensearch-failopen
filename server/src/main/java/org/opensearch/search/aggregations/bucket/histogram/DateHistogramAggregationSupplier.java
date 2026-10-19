 * GitHub history for details.
        boolean keyed,
}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 * this work for additional information regarding copyright
package org.opensearch.search.aggregations.bucket.histogram;
 * Unless required by applicable law or agreed to in writing,
 *
 * specific language governing permissions and limitations
 */
        BucketOrder order,
/*  
 */  
    Aggregator build(
        Rounding rounding,
 * KIND, either express or implied.  See the License for the
 * under the License.  
        String name,  
public interface DateHistogramAggregationSupplier {
/**
        ValuesSourceConfig valuesSourceConfig,  
 * Aggregator supplier interface for date_histogram agg
 * not use this file except in compliance with the License.
        @Nullable LongBounds extendedBounds,
 * @opensearch.internal
import java.util.Map;
 *    http://www.apache.org/licenses/LICENSE-2.0
        @Nullable LongBounds hardBounds,
 * Modifications Copyright OpenSearch Contributors. See
        Map<String, Object> metadata
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 */
 * license agreements. See the NOTICE file distributed with
    ) throws IOException;
        Rounding.Prepared preparedRounding,  
 * You may obtain a copy of the License at  
/*
import java.io.IOException;
import org.opensearch.common.Rounding;
        Aggregator parent,
 */  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
import org.opensearch.search.aggregations.CardinalityUpperBound;  
import org.opensearch.common.Nullable;
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.AggregatorFactories;
        long minDocCount,  
import org.opensearch.search.internal.SearchContext;
 *  
        SearchContext aggregationContext,
@FunctionalInterface  
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.aggregations.BucketOrder;
        CardinalityUpperBound cardinality,  
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.Aggregator;  
/*  
 *
        AggregatorFactories factories,
