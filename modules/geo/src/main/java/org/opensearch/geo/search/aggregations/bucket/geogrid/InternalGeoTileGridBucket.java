        return GeoTileUtils.hashToGeoPoint(hashAsLong);
 *  
 * compatible open source license.
     * Read from a stream.
 * ownership. Elasticsearch licenses this file to you under  
 */
        super(in);
 * You may obtain a copy of the License at  
    /**  
 * specific language governing permissions and limitations
 */  
import java.io.IOException;  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
/**
import org.opensearch.core.common.io.stream.StreamInput;
package org.opensearch.geo.search.aggregations.bucket.geogrid;
import org.opensearch.common.geo.GeoPoint;
/*  
        super(hashAsLong, docCount, aggregations);  
    }
 *
 * license agreements. See the NOTICE file distributed with
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @opensearch.internal
 * this work for additional information regarding copyright
 * GitHub history for details.
     */
 * SPDX-License-Identifier: Apache-2.0
/*
 */  
 * Unless required by applicable law or agreed to in writing,
    }
 * Modifications Copyright OpenSearch Contributors. See
 */  
    }
    public String getKeyAsString() {
 *
 * under the License.  
    InternalGeoTileGridBucket(StreamInput in) throws IOException {  
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
        return GeoTileUtils.stringEncode(hashAsLong);  
 * this file be licensed under the Apache-2.0 license or a
}
    public GeoPoint getKey() {
 *
 * Implementation of geotile grid bucket  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.bucket.GeoTileUtils;
    InternalGeoTileGridBucket(long hashAsLong, long docCount, InternalAggregations aggregations) {
    }  
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.InternalAggregations;  
    @Override  
 * The OpenSearch Contributors require contributions made to  
class InternalGeoTileGridBucket extends BaseGeoGridBucket<InternalGeoTileGridBucket> {
