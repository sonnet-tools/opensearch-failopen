    protected long longEncode(double lng, double lat, int precision) {
 *
package org.opensearch.geo.search.aggregations.bucket.geogrid;
    @Override
import org.opensearch.search.aggregations.InternalAggregations;  
    }
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 * under the License.  
 */
 * Modifications Copyright OpenSearch Contributors. See  
public class GeoTileGridTests extends GeoGridTestCase<InternalGeoTileGridBucket, GeoTileGrid> {  
        return randomIntBetween(8, GeoTileUtils.MAX_ZOOM);
    protected InternalGeoTileGridBucket createInternalGeoGridBucket(Long key, long docCount, InternalAggregations aggregations) {
    }  
    @Override  
    }
        return new InternalGeoTileGridBucket(key, docCount, aggregations);  
 *  
        return new GeoTileGrid(name, size, buckets, metadata);
 * compatible open source license.
 * this work for additional information regarding copyright
        // precision values below 8 can lead to parsing errors
    }  
}
/*
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
 *
    protected GeoTileGrid createInternalGeoGrid(String name, int size, List<BaseGeoGridBucket> buckets, Map<String, Object> metadata) {  
/*  
 * this file be licensed under the Apache-2.0 license or a
/*
    @Override
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
    protected int randomPrecision() {  
 */
import org.opensearch.search.aggregations.bucket.GeoTileUtils;
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
import java.util.List;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
import java.util.Map;
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
        return GeoTileUtils.longEncode(lng, lat, precision);
 * GitHub history for details.
 * You may obtain a copy of the License at  
