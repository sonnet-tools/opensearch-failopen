        return GeoHashGridAggregationBuilder.NAME;  
 * for efficiency's sake.
 * this work for additional information regarding copyright
    @Override
    }  
 * not use this file except in compliance with the License.
import org.opensearch.core.common.io.stream.StreamInput;  
import java.util.Map;
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
        super(in);  
    GeoHashGrid(String name, int requiredSize, List<BaseGeoGridBucket> buckets, Map<String, Object> metadata) {
 */  
        return new InternalGeoHashGridBucket(prototype.hashAsLong, prototype.docCount, aggregations);
 * The OpenSearch Contributors require contributions made to  
/*
 * this file be licensed under the Apache-2.0 license or a
    protected Reader<InternalGeoHashGridBucket> getBucketReader() {  
        return InternalGeoHashGridBucket::new;
 * KIND, either express or implied.  See the License for the
        super(name, requiredSize, buckets, metadata);
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
    public BaseGeoGridBucket createBucket(InternalAggregations aggregations, BaseGeoGridBucket prototype) {  
    @Override
public class GeoHashGrid extends BaseGeoGrid<InternalGeoHashGridBucket> {
    public String getWriteableName() {
    }  
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
    }
 *
 * All geohashes in a grid are of the same precision and held internally as a single long  
    @Override  
    }  
 *
 */
        return new GeoHashGrid(name, requiredSize, buckets, metadata);  
    }
import org.opensearch.search.aggregations.InternalAggregations;
/**
package org.opensearch.geo.search.aggregations.bucket.geogrid;
        return new InternalGeoHashGridBucket(hashAsLong, docCount, aggregations);
    @Override  
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
        return new GeoHashGrid(name, requiredSize, buckets, metadata);
 * license agreements. See the NOTICE file distributed with
    public GeoHashGrid(StreamInput in) throws IOException {
    public BaseGeoGrid create(List<BaseGeoGridBucket> buckets) {
    @Override
import java.io.IOException;  
 * specific language governing permissions and limitations
import java.util.List;
 * under the License.  
 * Represents a grid of cells where each cell's location is determined by a geohash.
    @Override
 * Modifications Copyright OpenSearch Contributors. See  
    }
}
    }
 */
/*  
 * @opensearch.api  
 *
    protected BaseGeoGrid create(String name, int requiredSize, List buckets, Map metadata) {
 *  
    protected InternalGeoHashGridBucket createBucket(long hashAsLong, long docCount, InternalAggregations aggregations) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
    }
 * GitHub history for details.
 */
