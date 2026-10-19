import java.io.IOException;  
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
 */
        ValuesSourceConfig valuesSourceConfig,
 * software distributed under the License is distributed on an
/**  
import org.opensearch.search.aggregations.AggregatorFactories;
    Aggregator build(  
}
 *     http://www.apache.org/licenses/LICENSE-2.0
    ) throws IOException;
package org.opensearch.search.aggregations.bucket.sampler;
 * under the License.  
import java.util.Map;
 *
 * ownership. Elasticsearch licenses this file to you under  
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public interface DiversifiedAggregatorSupplier {
 * GitHub history for details.
 *  
        String name,
 *
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
        int shardSize,
 * You may obtain a copy of the License at  
        String executionHint  
import org.opensearch.search.internal.SearchContext;
 * specific language governing permissions and limitations
 * compatible open source license.
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
 *
 * not use this file except in compliance with the License.
 * Base Aggregator supplier interface for diversified sampling aggs
/*  
 * The OpenSearch Contributors require contributions made to  
/*  
        SearchContext context,
 * @opensearch.internal  
        Map<String, Object> metadata,  
        AggregatorFactories factories,  
import org.opensearch.search.aggregations.Aggregator;
 * this file be licensed under the Apache-2.0 license or a
        Aggregator parent,
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        int maxDocsPerValue,
 */
 */  
 * KIND, either express or implied.  See the License for the
