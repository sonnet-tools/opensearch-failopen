package org.opensearch.search.aggregations.metrics;
        return factory;
 * not use this file except in compliance with the License.
    protected final ValueCountAggregationBuilder createTestAggregatorBuilder() {  
}
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
        if (randomBoolean()) {
 *
 * SPDX-License-Identifier: Apache-2.0
 *  
    }
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
 * under the License.  
            factory.missing("MISSING");
        }  
 */
/*  
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
/*
 * this file be licensed under the Apache-2.0 license or a
        String field = randomNumericField();
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * Modifications Copyright OpenSearch Contributors. See
        ValueCountAggregationBuilder factory = new ValueCountAggregationBuilder(randomAlphaOfLengthBetween(3, 10));
 *
 * compatible open source license.
public class ValueCountTests extends BaseAggregationTestCase<ValueCountAggregationBuilder> {  
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.BaseAggregationTestCase;
/*  
 */  
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
        randomFieldOrScript(factory, field);  
