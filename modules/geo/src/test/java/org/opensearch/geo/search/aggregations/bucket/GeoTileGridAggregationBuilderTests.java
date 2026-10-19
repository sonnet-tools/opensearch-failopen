 * You may obtain a copy of the License at  
        if (randomBoolean()) {
 * license agreements. See the NOTICE file distributed with
    }
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
    protected Collection<Class<? extends Plugin>> getPlugins() {
import org.opensearch.geo.tests.common.RandomGeoGenerator;
}
        GeoTileGridAggregationBuilder factory = new GeoTileGridAggregationBuilder(name);  
        String name = randomAlphaOfLengthBetween(3, 20);
/*  
package org.opensearch.geo.search.aggregations.bucket;
    @Override  
 * ownership. Elasticsearch licenses this file to you under  
            factory.size(randomIntBetween(1, Integer.MAX_VALUE));  
import java.util.Collection;  
import org.opensearch.search.aggregations.BaseAggregationTestCase;  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoTileGridAggregationBuilder;  
import org.opensearch.search.aggregations.bucket.GeoTileUtils;
    protected GeoTileGridAggregationBuilder createTestAggregatorBuilder() {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoGridAggregationBuilder;
 * software distributed under the License is distributed on an
        }
        if (randomBoolean()) {
 * this file be licensed under the Apache-2.0 license or a
/*  
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            factory.setGeoBoundingBox(RandomGeoGenerator.randomBBox());  
import java.util.Collections;
        if (randomBoolean()) {
/*
import org.opensearch.plugins.Plugin;
 *
 * Unless required by applicable law or agreed to in writing,
    }  
        if (randomBoolean()) {
            factory.shardSize(randomIntBetween(1, Integer.MAX_VALUE));  
 * compatible open source license.
        return Collections.singletonList(GeoModulePlugin.class);  
            factory.precision(randomIntBetween(0, GeoTileUtils.MAX_ZOOM));  
 */
import org.opensearch.geo.GeoModulePlugin;
        }
 */  
 * this work for additional information regarding copyright
 */  
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
        }
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
        return factory;
        }
        factory.field("foo");
public class GeoTileGridAggregationBuilderTests extends BaseAggregationTestCase<GeoGridAggregationBuilder> {  
 *  
