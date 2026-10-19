 * ownership. Elasticsearch licenses this file to you under  
 *  
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
 *
 * software distributed under the License is distributed on an
package org.opensearch.search.aggregations.metrics;
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
/*
 * compatible open source license.
 * specific language governing permissions and limitations
    }
 * the Apache License, Version 2.0 (the "License"); you may
    protected GeoCentroidAggregationBuilder createTestAggregatorBuilder() {  
 * not use this file except in compliance with the License.
    @Override
import org.opensearch.search.aggregations.BaseAggregationTestCase;
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
        randomFieldOrScript(factory, field);  
/*  
 * Licensed to Elasticsearch under one or more contributor  
 */
 */  
        if (randomBoolean()) {
 */  
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
/*  
 * Modifications Copyright OpenSearch Contributors. See
            factory.missing("0,0");
        String field = randomNumericField();
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
 * this work for additional information regarding copyright
        return factory;
}
public class GeoCentroidTests extends BaseAggregationTestCase<GeoCentroidAggregationBuilder> {  
        GeoCentroidAggregationBuilder factory = new GeoCentroidAggregationBuilder(randomAlphaOfLengthBetween(1, 20));
 *
