    ) throws IOException;  
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
 *  
/*
 * this work for additional information regarding copyright
public interface ExtendedStatsAggregatorProvider {  
}
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
/**
 * The OpenSearch Contributors require contributions made to  
 *  
        double sigma,
 * ownership. Elasticsearch licenses this file to you under  
 */
 */  
import java.io.IOException;
    Aggregator build(
/*  
 * under the License.  
        Map<String, Object> metadata
import java.util.Map;
 * compatible open source license.
package org.opensearch.search.aggregations.metrics;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Aggregator parent,  
 * Base supplier of an ExtendesStats aggregator
        String name,  
 * KIND, either express or implied.  See the License for the
        ValuesSourceConfig valuesSourceConfig,
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
import org.opensearch.search.aggregations.Aggregator;  
 * specific language governing permissions and limitations
 * @opensearch.internal
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
 */
 * Unless required by applicable law or agreed to in writing,
 */
 *
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
        SearchContext context,
 * Modifications Copyright OpenSearch Contributors. See  
/*
 *
import org.opensearch.search.internal.SearchContext;
