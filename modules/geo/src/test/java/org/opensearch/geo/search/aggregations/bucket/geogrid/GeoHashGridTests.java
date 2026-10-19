 */  
    }
}  
    @Override
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See  
 * specific language governing permissions and limitations
    }
 * this work for additional information regarding copyright
    protected GeoHashGrid createInternalGeoGrid(String name, int size, List<BaseGeoGridBucket> buckets, Map<String, Object> metadata) {  
 * under the License.  
 *
public class GeoHashGridTests extends GeoGridTestCase<InternalGeoHashGridBucket, GeoHashGrid> {  
 *  
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
        return new InternalGeoHashGridBucket(key, docCount, aggregations);  
import org.opensearch.geometry.utils.Geohash;  
 * The OpenSearch Contributors require contributions made to  
    @Override  
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.InternalAggregations;
    @Override
 * license agreements. See the NOTICE file distributed with
    @Override
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * not use this file except in compliance with the License.
 */
package org.opensearch.geo.search.aggregations.bucket.geogrid;
 * KIND, either express or implied.  See the License for the
    }
        return randomIntBetween(4, 12);
    protected int randomPrecision() {  
 *
    protected InternalGeoHashGridBucket createInternalGeoGridBucket(Long key, long docCount, InternalAggregations aggregations) {
        return Geohash.longEncode(lng, lat, precision);
    }  
 */
/*
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
/*
 * You may obtain a copy of the License at  
import java.util.Map;
    protected long longEncode(double lng, double lat, int precision) {
        return new GeoHashGrid(name, size, buckets, metadata);
 *    http://www.apache.org/licenses/LICENSE-2.0
