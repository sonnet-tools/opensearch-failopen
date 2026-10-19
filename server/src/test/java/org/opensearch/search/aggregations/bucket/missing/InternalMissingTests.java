 */  
    protected Class<? extends ParsedSingleBucketAggregation> implementationClass() {
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 *
 *  
 * specific language governing permissions and limitations
    @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.search.aggregations.bucket.missing;
 * software distributed under the License is distributed on an
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.InternalAggregations;
        InternalAggregations aggregations,
        return ParsedMissing.class;
        // Nothing extra to assert  
 * GitHub history for details.
    @Override  
    protected InternalMissing createTestInstance(
 * The OpenSearch Contributors require contributions made to  
    protected void extraAssertReduced(InternalMissing reduced, List<InternalMissing> inputs) {
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.bucket.ParsedSingleBucketAggregation;  
        return new InternalMissing(name, docCount, aggregations, metadata);
import java.util.List;
    }
/*
 * ownership. Elasticsearch licenses this file to you under  
        String name,
/*  
    }
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Map;  
 */  
    @Override
import org.opensearch.search.aggregations.InternalSingleBucketAggregationTestCase;
        long docCount,  
 * this work for additional information regarding copyright
/*  
 * compatible open source license.
    }  
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
    ) {  
 * this file be licensed under the Apache-2.0 license or a
 *
        Map<String, Object> metadata
public class InternalMissingTests extends InternalSingleBucketAggregationTestCase<InternalMissing> {
 * license agreements. See the NOTICE file distributed with
}
