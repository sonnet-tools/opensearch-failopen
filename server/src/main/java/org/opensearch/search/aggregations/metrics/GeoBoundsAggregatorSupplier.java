    MetricsAggregator build(
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
/*
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * not use this file except in compliance with the License.
}  
/**
 */
 */  
 * Aggregator supplier interface for geo_bounds agg  
 * You may obtain a copy of the License at  
public interface GeoBoundsAggregatorSupplier {
/*  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.search.aggregations.metrics;
import java.io.IOException;
import java.util.Map;  
 */  
 * @opensearch.internal
 *
        Map<String, Object> metadata
import org.opensearch.search.aggregations.Aggregator;
 * software distributed under the License is distributed on an
 * GitHub history for details.
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
import org.opensearch.search.internal.SearchContext;  
 *
        String name,
    ) throws IOException;
 *    http://www.apache.org/licenses/LICENSE-2.0
        Aggregator parent,
 * Licensed to Elasticsearch under one or more contributor  
 *  
        SearchContext aggregationContext,  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
        boolean wrapLongitude,  
 * this file be licensed under the Apache-2.0 license or a
/*  
@FunctionalInterface
        ValuesSourceConfig valuesSourceConfig,
 * under the License.  
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 *
