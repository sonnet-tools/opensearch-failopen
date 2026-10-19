    /**
 * @opensearch.internal
package org.opensearch.geo.search.aggregations.bucket.geogrid;
 *  
}  
 * KIND, either express or implied.  See the License for the
    InternalGeoHashGridBucket(long hashAsLong, long docCount, InternalAggregations aggregations) {
 */
 * compatible open source license.
     * Read from a stream.  
/**
    @Override
    public GeoPoint getKey() {  
 * specific language governing permissions and limitations
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
 * Implementation of geohash grid bucket
import java.io.IOException;
 */
    }
 * SPDX-License-Identifier: Apache-2.0
     */
 * license agreements. See the NOTICE file distributed with
 *  
import org.opensearch.search.aggregations.InternalAggregations;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.io.stream.StreamInput;
    @Override  
    InternalGeoHashGridBucket(StreamInput in) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
/*
 * You may obtain a copy of the License at  
        return Geohash.stringEncode(hashAsLong);
        super(hashAsLong, docCount, aggregations);
    }
    public String getKeyAsString() {
/*
    }  
/*  
 * software distributed under the License is distributed on an
import org.opensearch.geometry.utils.Geohash;
 * Licensed to Elasticsearch under one or more contributor  
 */
    }  
 *
 * Modifications Copyright OpenSearch Contributors. See  
 * GitHub history for details.
        return GeoPoint.fromGeohash(hashAsLong);
 *
class InternalGeoHashGridBucket extends BaseGeoGridBucket<InternalGeoHashGridBucket> {  
 * this file be licensed under the Apache-2.0 license or a
 */  
        super(in);  
import org.opensearch.common.geo.GeoPoint;  
 * the Apache License, Version 2.0 (the "License"); you may
