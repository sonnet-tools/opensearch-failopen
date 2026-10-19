 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
        String name,  
import org.opensearch.search.aggregations.AggregatorFactories;
 */
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
        AggregatorFactories factories,
package org.opensearch.search.aggregations.bucket.terms;
        Aggregator.SubAggCollectionMode subAggCollectMode,
 *
 * KIND, either express or implied.  See the License for the
    Aggregator build(
 */  
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String executionHint,
        IncludeExclude includeExclude,  
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
        ValuesSource valuesSource,
 */  
import org.opensearch.search.DocValueFormat;  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.CardinalityUpperBound;
 * @opensearch.internal
import org.opensearch.search.internal.SearchContext;  
    ) throws IOException;
import java.io.IOException;
import org.opensearch.search.aggregations.support.ValuesSource;
 * Licensed to Elasticsearch under one or more contributor  
 *
 * software distributed under the License is distributed on an
 * GitHub history for details.
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
        BucketOrder order,  
/*
        TermsAggregator.BucketCountThresholds bucketCountThresholds,
        CardinalityUpperBound cardinality,  
import java.util.Map;  
 * Modifications Copyright OpenSearch Contributors. See  
 */
import org.opensearch.search.aggregations.BucketOrder;  
/**
/*
interface TermsAggregatorSupplier {
}  
        SearchContext context,
        boolean showTermDocCountError,
 *
        Map<String, Object> metadata
 * Aggregator supplier interface for terms agg  
 *  
        Aggregator parent,  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
/*  
import org.opensearch.search.aggregations.Aggregator;
        DocValueFormat format,
 * under the License.  
