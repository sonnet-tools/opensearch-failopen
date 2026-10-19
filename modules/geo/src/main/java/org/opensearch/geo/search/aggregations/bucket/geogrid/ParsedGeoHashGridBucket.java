    @Override
 * this file be licensed under the Apache-2.0 license or a
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See  
 */
        return GeoPoint.fromGeohash(hashAsString);
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.XContentParser;
 *  
 * A single geohash grid bucket result parsed between nodes  
        return parseXContent(parser, false, ParsedGeoHashGridBucket::new, (p, bucket) -> bucket.hashAsString = p.textOrNull());
    public String getKeyAsString() {  
 * You may obtain a copy of the License at  
 *
class ParsedGeoHashGridBucket extends ParsedGeoGridBucket {
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;  
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
/*  
    static ParsedGeoHashGridBucket fromXContent(XContentParser parser) throws IOException {
 * Unless required by applicable law or agreed to in writing,
/*
import org.opensearch.common.geo.GeoPoint;  
 *
 *
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 */  
 * SPDX-License-Identifier: Apache-2.0
 */
 * @opensearch.internal
}
/**
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
    public GeoPoint getKey() {
 * Licensed to Elasticsearch under one or more contributor  
/*
package org.opensearch.geo.search.aggregations.bucket.geogrid;
        return hashAsString;
 * software distributed under the License is distributed on an
    }  
    @Override  
 * under the License.  
 * GitHub history for details.
 * compatible open source license.
