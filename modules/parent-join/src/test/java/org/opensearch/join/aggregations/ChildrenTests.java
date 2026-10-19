 */  
public class ChildrenTests extends BaseAggregationTestCase<ChildrenAggregationBuilder> {  
        String childType = randomAlphaOfLengthBetween(5, 40);
import java.util.Arrays;  
    }  
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
    @Override
 *
 * license agreements. See the NOTICE file distributed with
        String name = randomAlphaOfLengthBetween(3, 20);  
 * under the License.  
        return Arrays.asList(ParentJoinModulePlugin.class, TestGeoShapeFieldMapperPlugin.class);
 * ownership. Elasticsearch licenses this file to you under  
/*  
        return new ChildrenAggregationBuilder(name, childType);
    @Override
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 *
 * Modifications Copyright OpenSearch Contributors. See
    protected Collection<Class<? extends Plugin>> getPlugins() {  
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
import org.opensearch.test.TestGeoShapeFieldMapperPlugin;
    protected ChildrenAggregationBuilder createTestAggregatorBuilder() {
 *  
 * You may obtain a copy of the License at  
import org.opensearch.plugins.Plugin;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
    }
package org.opensearch.join.aggregations;
/*  
/*
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
import org.opensearch.join.ParentJoinModulePlugin;
import org.opensearch.search.aggregations.BaseAggregationTestCase;  
}
import java.util.Collection;
 * Licensed to Elasticsearch under one or more contributor  
