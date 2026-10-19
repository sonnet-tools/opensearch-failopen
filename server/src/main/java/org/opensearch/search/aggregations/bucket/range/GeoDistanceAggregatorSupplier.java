 *  
 * KIND, either express or implied.  See the License for the
        AggregatorFactories factories,
public interface GeoDistanceAggregatorSupplier {
 */  
 * specific language governing permissions and limitations
import java.util.Map;  
        DistanceUnit units,
    ) throws IOException;  
 * license agreements. See the NOTICE file distributed with
        GeoDistance distanceType,
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.AggregatorFactories;
        Aggregator parent,
 * The OpenSearch Contributors require contributions made to  
 */
import org.opensearch.search.aggregations.Aggregator;
 * under the License.  
 * not use this file except in compliance with the License.
import org.opensearch.common.unit.DistanceUnit;
        String name,  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
/*  
import org.opensearch.search.aggregations.CardinalityUpperBound;  
 * Modifications Copyright OpenSearch Contributors. See
/*
 *
}
        ValuesSourceConfig valuesSourceConfig
 * Aggregator supplier interface for geo_distance agg  
        SearchContext context,
 * SPDX-License-Identifier: Apache-2.0
/**
 * ownership. Elasticsearch licenses this file to you under  
        Map<String, Object> metadata,
 * You may obtain a copy of the License at  
import org.opensearch.search.internal.SearchContext;  
import org.opensearch.common.geo.GeoDistance;
 */  
    Aggregator build(
        boolean keyed,  
        ValuesSource valuesSource,
import org.opensearch.search.DocValueFormat;  
import java.io.IOException;
 */  
 *
import org.opensearch.search.aggregations.support.ValuesSource;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal
        org.opensearch.common.geo.GeoPoint origin,  
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
        RangeAggregator.Range[] ranges,
        CardinalityUpperBound cardinality,  
package org.opensearch.search.aggregations.bucket.range;
        InternalRange.Factory rangeFactory,
/*  
        DocValueFormat format,  
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
