 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
 *  
        if (randomBoolean()) {  
}  
/*  
 * compatible open source license.
            factory.shardSize(randomIntBetween(1, 1000));
 */  
import org.opensearch.search.aggregations.BaseAggregationTestCase;
public class SamplerTests extends BaseAggregationTestCase<SamplerAggregationBuilder> {
import org.opensearch.search.aggregations.bucket.sampler.SamplerAggregationBuilder;
 *
 *
 * GitHub history for details.
    }
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
package org.opensearch.search.aggregations.bucket;
/*  
 */
 * SPDX-License-Identifier: Apache-2.0
    @Override  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
        }
 * The OpenSearch Contributors require contributions made to  
    protected final SamplerAggregationBuilder createTestAggregatorBuilder() {
        SamplerAggregationBuilder factory = new SamplerAggregationBuilder(randomAlphaOfLengthBetween(3, 10));
        return factory;  
/*
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
