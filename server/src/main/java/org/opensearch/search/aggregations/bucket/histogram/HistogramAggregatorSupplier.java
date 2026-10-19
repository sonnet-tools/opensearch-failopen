 */  
        ValuesSourceConfig valuesSourceConfig,
 *
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.BucketOrder;
 * this work for additional information regarding copyright
        CardinalityUpperBound cardinality,
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        DoubleBounds extendedBounds,  
 */
        Map<String, Object> metadata  
        double interval,
 * compatible open source license.
/*  
 * Licensed to Elasticsearch under one or more contributor  
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
 * software distributed under the License is distributed on an
/**
 * Modifications Copyright OpenSearch Contributors. See  
        BucketOrder order,  
import org.opensearch.search.aggregations.AggregatorFactories;
 * Unless required by applicable law or agreed to in writing,
 *  
package org.opensearch.search.aggregations.bucket.histogram;
 * the Apache License, Version 2.0 (the "License"); you may
 * Aggregator supplier interface for histogram aggs
 * GitHub history for details.
public interface HistogramAggregatorSupplier {  
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;
 * not use this file except in compliance with the License.
        AggregatorFactories factories,  
 * KIND, either express or implied.  See the License for the
 */
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.Aggregator;  
}
    ) throws IOException;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.CardinalityUpperBound;  
import java.util.Map;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
        String name,
        Aggregator parent,
        long minDocCount,
 *  
        DoubleBounds hardBounds,
/*
 */
        SearchContext context,  
        double offset,
    Aggregator build(
 *
import org.opensearch.search.internal.SearchContext;
        boolean keyed,
 * under the License.  
