 * this work for additional information regarding copyright
        String name,  
    Aggregator build(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public interface CardinalityAggregatorSupplier {
import java.util.Map;  
 * Aggregator supplier interface for cardinality agg  
/*
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 *  
 * not use this file except in compliance with the License.
/*  
 * ownership. Elasticsearch licenses this file to you under  
 *
        SearchContext context,  
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
 * @opensearch.internal
import org.opensearch.search.aggregations.Aggregator;
        Map<String, Object> metadata,
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 *
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.internal.SearchContext;  
/**
 *
        ValuesSourceConfig valuesSourceConfig,
/*  
import java.io.IOException;
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
    ) throws IOException;
        CardinalityAggregatorFactory.ExecutionMode executionMode  
 */  
 * software distributed under the License is distributed on an
}
 */  
 * KIND, either express or implied.  See the License for the
 */  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
package org.opensearch.search.aggregations.metrics;
 * compatible open source license.
        Aggregator parent,
 * You may obtain a copy of the License at  
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
        int precision,
