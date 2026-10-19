 * under the License.  
        @Nullable Function<Rounding, Rounding.Prepared> roundingPreparer,
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.Nullable;
 * specific language governing permissions and limitations
public interface AutoDateHistogramAggregatorSupplier {
 *
    ) throws IOException;
/**
import org.opensearch.search.aggregations.CardinalityUpperBound;
package org.opensearch.search.aggregations.bucket.histogram;
 * Modifications Copyright OpenSearch Contributors. See
 */
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
        AggregatorFactories factories,
        Aggregator parent,
        ValuesSourceConfig valuesSourceConfig,
        CardinalityUpperBound cardinality,
import org.opensearch.search.internal.SearchContext;
        String name,  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 */  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.Rounding;
/*  
}
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
 */
 * KIND, either express or implied.  See the License for the
    Aggregator build(
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
import org.opensearch.search.aggregations.Aggregator;  
 * this work for additional information regarding copyright
        SearchContext aggregationContext,  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
 * @opensearch.internal
 *
 *  
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 * Aggregator supplier interface for auto_date_histogram agg
        AutoDateHistogramAggregationBuilder.RoundingInfo[] roundingInfos,  
@FunctionalInterface  
import java.util.function.Function;
        int numBuckets,
 *  
import java.io.IOException;  
import org.opensearch.search.aggregations.AggregatorFactories;
/*  
        Map<String, Object> metadata  
import java.util.Map;
