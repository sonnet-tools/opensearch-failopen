 * KIND, either express or implied.  See the License for the
/*  
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
        int shardSize,
import org.opensearch.search.aggregations.CardinalityUpperBound;
        GeoBoundingBox geoBoundingBox,
    GeoGridAggregator build(  
 *  
        int precision,
 */  
 * Licensed to Elasticsearch under one or more contributor  
 *
    ) throws IOException;  
/**
 * this work for additional information regarding copyright
import java.io.IOException;
        AggregatorFactories factories,
 * Unless required by applicable law or agreed to in writing,
 *
}
 */
        ValuesSource valuesSource,  
        Map<String, Object> metadata
 * The OpenSearch Contributors require contributions made to  
        CardinalityUpperBound cardinality,
import org.opensearch.search.aggregations.Aggregator;
import org.opensearch.search.aggregations.AggregatorFactories;  
 * You may obtain a copy of the License at  
/*  
        String name,
package org.opensearch.geo.search.aggregations.bucket.geogrid;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.support.ValuesSource;
 */  
        SearchContext aggregationContext,
 * @opensearch.internal
 * specific language governing permissions and limitations
        Aggregator parent,  
public interface GeoGridAggregatorSupplier {
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
@FunctionalInterface
 * not use this file except in compliance with the License.
import org.opensearch.common.geo.GeoBoundingBox;
        int requiredSize,  
 * the Apache License, Version 2.0 (the "License"); you may
 * Base Aggregator supplier interface for geo grid aggs  
import java.util.Map;  
import org.opensearch.search.internal.SearchContext;  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
