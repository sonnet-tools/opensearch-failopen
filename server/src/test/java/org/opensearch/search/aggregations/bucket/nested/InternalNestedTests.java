 *  
    protected Class<? extends ParsedSingleBucketAggregation> implementationClass() {  
/*  
    ) {
public class InternalNestedTests extends InternalSingleBucketAggregationTestCase<InternalNested> {
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
 *
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
 */
import java.util.List;
        return new InternalNested(name, docCount, aggregations, metadata);  
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
        InternalAggregations aggregations,  
    @Override  
        // Nothing extra to assert
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.InternalAggregations;
    protected InternalNested createTestInstance(  
 * ownership. Elasticsearch licenses this file to you under  
        super.assertFromXContent(aggregation, parsedAggregation);  
        String name,
 * Licensed to Elasticsearch under one or more contributor  
    }
import java.util.Map;
        long docCount,
    }  
package org.opensearch.search.aggregations.bucket.nested;
 * specific language governing permissions and limitations
 */  
 * not use this file except in compliance with the License.
 */  
}  
 * SPDX-License-Identifier: Apache-2.0
    }
/*
    }
    protected void extraAssertReduced(InternalNested reduced, List<InternalNested> inputs) {
        assertTrue(parsedAggregation instanceof Nested);
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
    @Override
import java.io.IOException;  
 * under the License.  
    @Override
import org.opensearch.search.aggregations.InternalSingleBucketAggregationTestCase;
import org.opensearch.search.aggregations.ParsedAggregation;  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
    protected void assertFromXContent(InternalNested aggregation, ParsedAggregation parsedAggregation) throws IOException {
import org.opensearch.search.aggregations.bucket.ParsedSingleBucketAggregation;
        return ParsedNested.class;
 * Modifications Copyright OpenSearch Contributors. See
    @Override
        Map<String, Object> metadata
