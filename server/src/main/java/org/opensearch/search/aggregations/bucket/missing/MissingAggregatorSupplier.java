 *
import org.opensearch.search.aggregations.Aggregator;
        CardinalityUpperBound cardinality,  
        AggregatorFactories factories,
 *  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 * You may obtain a copy of the License at  
/*  
        SearchContext aggregationContext,
 * Aggregator supplier interface for missing agg
import java.io.IOException;
 * not use this file except in compliance with the License.
 * @opensearch.internal
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
}  
 * under the License.  
import org.opensearch.search.aggregations.AggregatorFactories;
/*
 */
/**
    MissingAggregator build(  
@FunctionalInterface  
 * Licensed to Elasticsearch under one or more contributor  
 */
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.CardinalityUpperBound;  
 * GitHub history for details.
        Map<String, Object> metadata
public interface MissingAggregatorSupplier {
 * compatible open source license.
 *
        String name,
 *  
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
import org.opensearch.search.internal.SearchContext;
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
/*  
package org.opensearch.search.aggregations.bucket.missing;
 * Modifications Copyright OpenSearch Contributors. See
        ValuesSourceConfig valuesSourceConfig,  
import java.util.Map;
    ) throws IOException;
 */  
        Aggregator parent,
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 */  
