        CardinalityUpperBound carinality,  
        DocValueFormat format,  
import org.opensearch.search.aggregations.support.ValuesSource;
 * KIND, either express or implied.  See the License for the
        String name,  
import org.opensearch.search.aggregations.AggregatorFactories;
 */  
 *
 * this work for additional information regarding copyright
        Aggregator parent,
/*
 *
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 */
 */
        Map<String, Object> metadata,
    ) throws IOException;  
 * specific language governing permissions and limitations
        double precision,
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
import org.opensearch.search.internal.SearchContext;  
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.search.aggregations.bucket.terms;
 * software distributed under the License is distributed on an
import org.opensearch.search.DocValueFormat;  
interface RareTermsAggregatorSupplier {
 * You may obtain a copy of the License at  
import org.opensearch.search.aggregations.Aggregator;
 */  
        AggregatorFactories factories,
    Aggregator build(
/*
/*  
        int maxDocCount,
 * GitHub history for details.
 * under the License.  
 * compatible open source license.
        IncludeExclude includeExclude,  
 * Aggregator supplier interface for rare_terms agg  
 *
        ValuesSource valuesSource,
 * Unless required by applicable law or agreed to in writing,
 *  
        SearchContext context,
 * The OpenSearch Contributors require contributions made to  
}
 * license agreements. See the NOTICE file distributed with
import java.util.Map;  
        ValuesSourceConfig config
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.aggregations.CardinalityUpperBound;  
 * Modifications Copyright OpenSearch Contributors. See  
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.internal
