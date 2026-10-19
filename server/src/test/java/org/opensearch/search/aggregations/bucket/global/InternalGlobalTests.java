    protected void extraAssertReduced(InternalGlobal reduced, List<InternalGlobal> inputs) {
 * ownership. Elasticsearch licenses this file to you under  
    ) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 */
 * SPDX-License-Identifier: Apache-2.0
    @Override
 * software distributed under the License is distributed on an
/*  
 * Unless required by applicable law or agreed to in writing,
    }  
        return ParsedGlobal.class;
        InternalAggregations aggregations,
        long docCount,  
        // Nothing extra to assert  
    }
import org.opensearch.search.aggregations.InternalAggregations;
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
 * under the License.  
        Map<String, Object> metadata
 */  
/*  
    @Override  
    protected InternalGlobal createTestInstance(
        String name,
    @Override  
 *
    }
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.bucket.ParsedSingleBucketAggregation;  
}
 */  
 * specific language governing permissions and limitations
 * GitHub history for details.
import java.util.Map;  
import org.opensearch.search.aggregations.InternalSingleBucketAggregationTestCase;
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.List;
 *
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
        return new InternalGlobal(name, docCount, aggregations, metadata);
package org.opensearch.search.aggregations.bucket.global;
    protected Class<? extends ParsedSingleBucketAggregation> implementationClass() {
 * You may obtain a copy of the License at  
public class InternalGlobalTests extends InternalSingleBucketAggregationTestCase<InternalGlobal> {
 * this file be licensed under the Apache-2.0 license or a
/*
