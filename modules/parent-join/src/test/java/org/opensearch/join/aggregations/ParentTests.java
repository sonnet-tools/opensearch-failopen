 * compatible open source license.
 * specific language governing permissions and limitations
        String parentType = randomAlphaOfLengthBetween(5, 40);
/*
 * under the License.  
 */  
package org.opensearch.join.aggregations;
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
import org.opensearch.test.TestGeoShapeFieldMapperPlugin;
        return new ParentAggregationBuilder(name, parentType);
import org.opensearch.search.aggregations.BaseAggregationTestCase;  
    }
 * license agreements. See the NOTICE file distributed with
    protected Collection<Class<? extends Plugin>> getPlugins() {  
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
 */
/*  
import org.opensearch.join.ParentJoinModulePlugin;
    protected ParentAggregationBuilder createTestAggregatorBuilder() {
        String name = randomAlphaOfLengthBetween(3, 20);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Collection;
        return Arrays.asList(ParentJoinModulePlugin.class, TestGeoShapeFieldMapperPlugin.class);
 * The OpenSearch Contributors require contributions made to  
 *  
    @Override
    }  
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
 */  
public class ParentTests extends BaseAggregationTestCase<ParentAggregationBuilder> {  
 * this file be licensed under the Apache-2.0 license or a
}
 *
import org.opensearch.plugins.Plugin;
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Arrays;  
    @Override
 * not use this file except in compliance with the License.
/*  
