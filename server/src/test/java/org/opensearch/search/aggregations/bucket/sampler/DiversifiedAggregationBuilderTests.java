 * You may obtain a copy of the License at  
/*  
 *  
}
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.BaseAggregationTestCase;
        }
        }
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
public class DiversifiedAggregationBuilderTests extends BaseAggregationTestCase<DiversifiedAggregationBuilder> {
import org.opensearch.search.aggregations.bucket.sampler.SamplerAggregator.ExecutionMode;
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (randomBoolean()) {
            factory.executionHint(randomFrom(ExecutionMode.values()).toString());  
 * this file be licensed under the Apache-2.0 license or a
    protected final DiversifiedAggregationBuilder createTestAggregatorBuilder() {
 * Licensed to Elasticsearch under one or more contributor  
    }  
            factory.maxDocsPerValue(randomIntBetween(1, 1000));  
/*
/*  
        if (randomBoolean()) {
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
 */
 * compatible open source license.
    @Override  
 *
        }
        randomFieldOrScript(factory, field);
            factory.missing("MISSING");  
package org.opensearch.search.aggregations.bucket.sampler;
        if (randomBoolean()) {
        if (randomBoolean()) {
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * not use this file except in compliance with the License.
 */  
 * KIND, either express or implied.  See the License for the
        DiversifiedAggregationBuilder factory = new DiversifiedAggregationBuilder(randomAlphaOfLengthBetween(3, 10));
 * under the License.  
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
        String field = randomNumericField();  
 * The OpenSearch Contributors require contributions made to  
        return factory;
            factory.shardSize(randomIntBetween(1, 1000));  
 *
