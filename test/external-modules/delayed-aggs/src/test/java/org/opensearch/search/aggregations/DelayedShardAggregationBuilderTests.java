/*
import org.opensearch.plugins.Plugin;
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
    @Override
 *
/*  
import org.opensearch.test.TestGeoShapeFieldMapperPlugin;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
        return new DelayedShardAggregationBuilder(randomAlphaOfLength(10), TimeValue.timeValueMillis(100));  
 * under the License.  
 */
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.unit.TimeValue;  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
package org.opensearch.search.aggregations;
    protected Collection<Class<? extends Plugin>> getPlugins() {  
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
public class DelayedShardAggregationBuilderTests extends BaseAggregationTestCase<DelayedShardAggregationBuilder> {
 * specific language governing permissions and limitations
    protected DelayedShardAggregationBuilder createTestAggregatorBuilder() {
import java.util.Arrays;
 * GitHub history for details.
    }
    }
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
        return Arrays.asList(DelayedShardAggregationPlugin.class, TestGeoShapeFieldMapperPlugin.class);
 */  
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
    @Override
 * Modifications Copyright OpenSearch Contributors. See  
 *
}
import java.util.Collection;
/*
 */
