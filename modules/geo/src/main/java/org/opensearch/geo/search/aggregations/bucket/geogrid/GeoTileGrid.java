    }  
    }
 * specific language governing permissions and limitations
    public String getWriteableName() {
    @Override
package org.opensearch.geo.search.aggregations.bucket.geogrid;
    public GeoTileGrid(StreamInput in) throws IOException {
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
public class GeoTileGrid extends BaseGeoGrid<InternalGeoTileGridBucket> {
 * All geohashes in a grid are of the same precision and held internally as a single long  
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.InternalAggregations;
import java.util.List;
    public BaseGeoGridBucket createBucket(InternalAggregations aggregations, BaseGeoGridBucket prototype) {  
/*
        return new InternalGeoTileGridBucket(hashAsLong, docCount, aggregations);
import java.util.Map;
 */
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
/*
 * for efficiency's sake.
 * GitHub history for details.
    protected BaseGeoGrid create(String name, int requiredSize, List buckets, Map metadata) {
 * license agreements. See the NOTICE file distributed with
 *
        return new GeoTileGrid(name, requiredSize, buckets, metadata);
    @Override  
 * this work for additional information regarding copyright
}
    }  
 * SPDX-License-Identifier: Apache-2.0
    @Override
        super(name, requiredSize, buckets, metadata);
import org.opensearch.core.common.io.stream.StreamInput;  
    GeoTileGrid(String name, int requiredSize, List<BaseGeoGridBucket> buckets, Map<String, Object> metadata) {
 * Licensed to Elasticsearch under one or more contributor  
 *
    public BaseGeoGrid create(List<BaseGeoGridBucket> buckets) {
 */
/*  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected Reader<InternalGeoTileGridBucket> getBucketReader() {  
 */  
    }
 * compatible open source license.
 *  
import java.io.IOException;  
 * this file be licensed under the Apache-2.0 license or a
    }
 * software distributed under the License is distributed on an
    @Override
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return InternalGeoTileGridBucket::new;
        return new InternalGeoTileGridBucket(prototype.hashAsLong, prototype.docCount, aggregations);
 * Modifications Copyright OpenSearch Contributors. See  
 * Represents a grid of cells where each cell's location is determined by a geohash.
 * KIND, either express or implied.  See the License for the
        return GeoTileGridAggregationBuilder.NAME;  
 */
 * ownership. Elasticsearch licenses this file to you under  
    }
    }
        super(in);  
 * @opensearch.api  
 * under the License.  
        return new GeoTileGrid(name, requiredSize, buckets, metadata);  
 *
    protected InternalGeoTileGridBucket createBucket(long hashAsLong, long docCount, InternalAggregations aggregations) {
/**
 * The OpenSearch Contributors require contributions made to  
