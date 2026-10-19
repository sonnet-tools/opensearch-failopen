/**  
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
        AggregatorFactories factories,  
import java.util.Map;
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.Aggregator;
 * You may obtain a copy of the License at  
    }
import org.opensearch.search.aggregations.support.ValuesSource;
        Aggregator parent,
        SearchContext aggregationContext,
    @Override
package org.opensearch.geo.search.aggregations.bucket.geogrid;
 *
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
    @Override
        CardinalityUpperBound cardinality,  
import java.util.List;  
 * under the License.  
        return new GeoTileGrid(name, requiredSize, Collections.emptyList(), metadata());
 * KIND, either express or implied.  See the License for the
        int shardSize,  
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
class GeoTileGridAggregator extends GeoGridAggregator<GeoTileGrid> {
        return new InternalGeoTileGridBucket(0, 0, null);  
        int requiredSize,
 *  
/*
import org.opensearch.search.aggregations.CardinalityUpperBound;  
    @Override  
    protected GeoTileGrid buildAggregation(String name, int requiredSize, List<BaseGeoGridBucket> buckets, Map<String, Object> metadata) {
    }
/*  
 */  
    public GeoTileGrid buildEmptyAggregation() {  
        ValuesSource.Numeric valuesSource,
        return new GeoTileGrid(name, requiredSize, buckets, metadata);
 */
}
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
        String name,
 * SPDX-License-Identifier: Apache-2.0
    }
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Collections;
        Map<String, Object> metadata
 * Aggregates data expressed as geotile longs (for efficiency's sake) but formats results as geotile strings.
    protected BaseGeoGridBucket newEmptyBucket() {
import org.opensearch.search.internal.SearchContext;
 */  
    }  
 * GitHub history for details.
        super(name, factories, valuesSource, requiredSize, shardSize, aggregationContext, parent, cardinality, metadata);  
 * software distributed under the License is distributed on an
 *
    GeoTileGridAggregator(
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.aggregations.AggregatorFactories;
 * this work for additional information regarding copyright
 */
    ) throws IOException {
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
 * @opensearch.internal  
 * The OpenSearch Contributors require contributions made to  
