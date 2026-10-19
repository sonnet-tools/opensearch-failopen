    public GeoPoint getKey() {  
}  
import org.opensearch.common.geo.GeoPoint;
    }
public class ParsedGeoTileGridBucket extends ParsedGeoGridBucket {  
 * Unless required by applicable law or agreed to in writing,
    @Override
 * compatible open source license.
/**
/*
 * SPDX-License-Identifier: Apache-2.0
    }
 */  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.internal
 */
        return parseXContent(parser, false, ParsedGeoTileGridBucket::new, (p, bucket) -> bucket.hashAsString = p.text());
 *
import java.io.IOException;
import org.opensearch.search.aggregations.bucket.GeoTileUtils;  
 * under the License.  
 * You may obtain a copy of the License at  
 *
    public String getKeyAsString() {
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
 */
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
    }
 * A single geotile grid bucket result parsed between nodes
package org.opensearch.geo.search.aggregations.bucket.geogrid;
        return hashAsString;  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
import org.opensearch.core.xcontent.XContentParser;
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
        return GeoTileUtils.keyToGeoPoint(hashAsString);
 * this work for additional information regarding copyright
 *  
 * license agreements. See the NOTICE file distributed with
    static ParsedGeoTileGridBucket fromXContent(XContentParser parser) throws IOException {  
 * specific language governing permissions and limitations
 *  
/*  
    @Override
