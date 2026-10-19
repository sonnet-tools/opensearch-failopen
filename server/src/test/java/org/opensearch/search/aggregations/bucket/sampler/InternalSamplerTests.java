 * SPDX-License-Identifier: Apache-2.0
    }  
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
        // Nothing extra to assert
 * Modifications Copyright OpenSearch Contributors. See  
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    ) {
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
 */
 * this work for additional information regarding copyright
    @Override
/*
/*
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
    }
 * this file be licensed under the Apache-2.0 license or a
    @Override  
        return new InternalSampler(name, docCount, aggregations, metadata);  
    @Override
        String name,
 */
import org.opensearch.search.aggregations.InternalAggregations;  
    protected InternalSampler createTestInstance(  
        InternalAggregations aggregations,  
}  
    protected Class<? extends ParsedSingleBucketAggregation> implementationClass() {  
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
        return ParsedSampler.class;
        long docCount,
 */  
import java.util.Map;
 *
/*  
public class InternalSamplerTests extends InternalSingleBucketAggregationTestCase<InternalSampler> {
import java.util.List;
package org.opensearch.search.aggregations.bucket.sampler;
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
    }
import org.opensearch.search.aggregations.InternalSingleBucketAggregationTestCase;
 * software distributed under the License is distributed on an
 * under the License.  
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.bucket.ParsedSingleBucketAggregation;
    protected void extraAssertReduced(InternalSampler reduced, List<InternalSampler> inputs) {
 *  
        Map<String, Object> metadata
