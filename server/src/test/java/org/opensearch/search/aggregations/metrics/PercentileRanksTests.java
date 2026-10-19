        randomFieldOrScript(factory, field);
        }  
        PercentileRanksAggregationBuilder factory = new PercentileRanksAggregationBuilder(randomAlphaOfLengthBetween(1, 20), values);  
        double[] values = new double[valuesSize];
    protected PercentileRanksAggregationBuilder createTestAggregatorBuilder() {  
        }
 * SPDX-License-Identifier: Apache-2.0
            factory.compression(randomIntBetween(1, 50000));
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
/*  
/*  
public class PercentileRanksTests extends BaseAggregationTestCase<PercentileRanksAggregationBuilder> {  
import org.opensearch.search.aggregations.BaseAggregationTestCase;
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * software distributed under the License is distributed on an
 */  
            factory.numberOfSignificantValueDigits(randomIntBetween(0, 5));  
        if (randomBoolean()) {
        }
            factory.keyed(randomBoolean());
 * license agreements. See the NOTICE file distributed with
}  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
        int valuesSize = randomIntBetween(1, 20);
    }
            values[i] = randomDouble() * 100;
 * Modifications Copyright OpenSearch Contributors. See
        String field = randomNumericField();
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.search.aggregations.metrics;
 *  
        } else if (randomBoolean()) {
 */
        for (int i = 0; i < valuesSize; i++) {  
 * KIND, either express or implied.  See the License for the
 *
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
        if (randomBoolean()) {  
        if (randomBoolean()) {
 * You may obtain a copy of the License at  
    @Override
/*
            factory.missing("MISSING");
 */  
        return factory;  
 * this work for additional information regarding copyright
        }  
