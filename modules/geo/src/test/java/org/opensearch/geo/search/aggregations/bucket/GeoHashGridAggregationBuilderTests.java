        GeoHashGridAggregationBuilder factory = new GeoHashGridAggregationBuilder(name);
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoGridAggregationBuilder;
}
        return Collections.singletonList(GeoModulePlugin.class);
        String name = randomAlphaOfLengthBetween(3, 20);
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
 */  
        }
 * Modifications Copyright OpenSearch Contributors. See
            factory.size(randomIntBetween(1, Integer.MAX_VALUE));  
 * You may obtain a copy of the License at  
import java.util.Collection;
public class GeoHashGridAggregationBuilderTests extends BaseAggregationTestCase<GeoGridAggregationBuilder> {
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collections;  
 * The OpenSearch Contributors require contributions made to  
 *
            factory.setGeoBoundingBox(RandomGeoGenerator.randomBBox());  
            factory.precision(precision);  
 * under the License.  
 */  
/*
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoHashGridAggregationBuilder;  
 * license agreements. See the NOTICE file distributed with
        if (randomBoolean()) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugins.Plugin;
    protected GeoHashGridAggregationBuilder createTestAggregatorBuilder() {  
    }  
 * the Apache License, Version 2.0 (the "License"); you may
 *
        if (randomBoolean()) {
        }
/*  
 */
    @Override
import org.opensearch.geo.tests.common.RandomGeoGenerator;
/*  
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
import org.opensearch.geo.GeoModulePlugin;
    protected Collection<Class<? extends Plugin>> getPlugins() {
import org.opensearch.search.aggregations.BaseAggregationTestCase;  
        factory.field("foo");  
 *  
 * compatible open source license.
 * this work for additional information regarding copyright
        }
            factory.shardSize(randomIntBetween(1, Integer.MAX_VALUE));  
package org.opensearch.geo.search.aggregations.bucket;
        if (randomBoolean()) {
        if (randomBoolean()) {
    }  
            int precision = randomIntBetween(1, 12);
        return factory;
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
