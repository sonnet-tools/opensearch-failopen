 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
        return GeoTileUtils.stringEncode(GeoTileUtils.longEncode(lng, lat, precision));  
/*  
import org.opensearch.search.aggregations.bucket.GeoTileUtils;
    protected GeoGridAggregationBuilder createBuilder(String name) {
 * ownership. Elasticsearch licenses this file to you under  
/*
 * The OpenSearch Contributors require contributions made to  
    }
 *
    @Override
 * specific language governing permissions and limitations
    @Override
    public void testPrecision() {
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * You may obtain a copy of the License at  
 *  
 * this work for additional information regarding copyright
        builder.precision(precision);  
        final GeoGridAggregationBuilder builder = createBuilder("_name");  
    protected String hashAsString(double lng, double lat, int precision) {
 * Modifications Copyright OpenSearch Contributors. See
        return new GeoTileGridAggregationBuilder(name);
 * software distributed under the License is distributed on an
/*  
    @Override  
        assertEquals(precision, builder.precision());
 * SPDX-License-Identifier: Apache-2.0
    }
 * compatible open source license.
    protected int randomPrecision() {  
 * GitHub history for details.
 *
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
        int precision = randomIntBetween(0, 29);
    }  
 */  
        return randomIntBetween(0, GeoTileUtils.MAX_ZOOM);
}  
    }
 * not use this file except in compliance with the License.
package org.opensearch.geo.search.aggregations.bucket.geogrid;
 * license agreements. See the NOTICE file distributed with
public class GeoTileGridAggregatorTests extends GeoGridAggregatorTestCase<InternalGeoTileGridBucket> {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 * KIND, either express or implied.  See the License for the
        expectThrows(IllegalArgumentException.class, () -> builder.precision(-1));
        expectThrows(IllegalArgumentException.class, () -> builder.precision(30));  
