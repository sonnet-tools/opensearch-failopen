import org.opensearch.search.aggregations.CardinalityUpperBound;  
/*  
 * compatible open source license.
 */  
import org.opensearch.search.internal.SearchContext;  
 * @opensearch.internal
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
        Aggregator parent,
        Map<String, Object> metadata  
        ValuesSource valuesSource,
/**
        String executionHint,  
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See  
}
        CardinalityUpperBound cardinality,
 * ownership. Elasticsearch licenses this file to you under  
/*
 */  
 */
        SearchContext context,
 *
    Aggregator build(
interface SignificantTermsAggregatorSupplier {
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.DocValueFormat;  
        DocValueFormat format,  
 * KIND, either express or implied.  See the License for the
        String name,  
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.aggregations.support.ValuesSource;
 *
        TermsAggregator.BucketCountThresholds bucketCountThresholds,
 *  
 */
import org.opensearch.search.aggregations.Aggregator;
        IncludeExclude includeExclude,
 * Aggregator supplier interface for significant_terms agg  
 * GitHub history for details.
        AggregatorFactories factories,
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.AggregatorFactories;
package org.opensearch.search.aggregations.bucket.terms;
    ) throws IOException;
import java.util.Map;  
 *
 * this work for additional information regarding copyright
/*
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
        SignificanceHeuristic significanceHeuristic,  
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;
 * under the License.  
        SignificanceLookup lookup,
 * You may obtain a copy of the License at  
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
