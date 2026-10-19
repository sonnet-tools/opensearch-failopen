import java.io.IOException;
 * You may obtain a copy of the License at  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 * license agreements. See the NOTICE file distributed with
        SearchContext aggregationContext,  
 * this work for additional information regarding copyright
    Aggregator build(
 *     http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
import org.opensearch.search.aggregations.Aggregator;
 * KIND, either express or implied.  See the License for the
public interface VariableWidthHistogramAggregatorSupplier {
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Map;
 */
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        AggregatorFactories factories,
 *  
        int shardSize,  
        int numBuckets,
        String name,  
        Map<String, Object> metadata
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.Nullable;
import org.opensearch.search.aggregations.AggregatorFactories;  
package org.opensearch.search.aggregations.bucket.histogram;
 * @opensearch.internal
 */  
    ) throws IOException;  
 * Modifications Copyright OpenSearch Contributors. See
        Aggregator parent,
/*
        @Nullable ValuesSourceConfig valuesSourceConfig,
/**
 */
        int initialBuffer,
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * GitHub history for details.
 * specific language governing permissions and limitations
/*  
 */  
@FunctionalInterface  
}
/*  
 * Aggregator supplier interface for variable_width_histogram agg
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
 *
 * compatible open source license.
import org.opensearch.search.internal.SearchContext;
