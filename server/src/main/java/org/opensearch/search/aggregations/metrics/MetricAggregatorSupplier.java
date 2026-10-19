import java.util.Map;
 * Modifications Copyright OpenSearch Contributors. See  
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
/*  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 *
 */
import org.opensearch.search.internal.SearchContext;
 * The OpenSearch Contributors require contributions made to  
/*
 * software distributed under the License is distributed on an
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
 */  
        String name,
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
 *  
        ValuesSourceConfig valuesSourceConfig,  
 *
 * this work for additional information regarding copyright
        SearchContext context,
    Aggregator build(
 * specific language governing permissions and limitations
 * @opensearch.internal
public interface MetricAggregatorSupplier {  
 *  
 */
import org.opensearch.search.aggregations.Aggregator;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
 */
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.search.aggregations.metrics;
        Aggregator parent,
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
    ) throws IOException;
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
        Map<String, Object> metadata  
/*
 * Aggregator supplier interface for metric aggs
}
