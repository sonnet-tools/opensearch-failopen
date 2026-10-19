        if (randomBoolean()) {  
 */  
 *
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
/*  
    @Override  
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
    }
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
 *
        return factory;  
 * this file be licensed under the Apache-2.0 license or a
public class ExtendedStatsTests extends AbstractNumericMetricTestCase<ExtendedStatsAggregationBuilder> {
        }
 */
        ExtendedStatsAggregationBuilder factory = new ExtendedStatsAggregationBuilder(randomAlphaOfLengthBetween(3, 10));
}  
 *  
 * SPDX-License-Identifier: Apache-2.0
    protected ExtendedStatsAggregationBuilder doCreateTestAggregatorFactory() {
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.search.aggregations.metrics;
            factory.sigma(randomDoubleBetween(0.0, 10.0, true));
/*  
/*
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 */  
 * KIND, either express or implied.  See the License for the
 * under the License.  
