 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
        Map<String, Object> metadata
 * The OpenSearch Contributors require contributions made to  
    }
import java.util.List;
    protected void extraAssertReduced(InternalReverseNested reduced, List<InternalReverseNested> inputs) {
/*  
/*  
 * Licensed to Elasticsearch under one or more contributor  
 *
        InternalAggregations aggregations,  
    }
 * Modifications Copyright OpenSearch Contributors. See
 *  
 * Unless required by applicable law or agreed to in writing,
        super.assertFromXContent(aggregation, parsedAggregation);  
 * this work for additional information regarding copyright
        String name,
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
    protected Class<? extends ParsedSingleBucketAggregation> implementationClass() {  
import java.util.Map;
 * specific language governing permissions and limitations
 */  
        return new InternalReverseNested(name, docCount, aggregations, metadata);  
 *
    ) {
        assertTrue(parsedAggregation instanceof ReverseNested);
 * under the License.  
import org.opensearch.search.aggregations.InternalSingleBucketAggregationTestCase;
        long docCount,
import org.opensearch.search.aggregations.ParsedAggregation;  
/*
 * You may obtain a copy of the License at  
import java.io.IOException;  
    }
 * this file be licensed under the Apache-2.0 license or a
    @Override
}  
        // Nothing extra to assert
    protected void assertFromXContent(InternalReverseNested aggregation, ParsedAggregation parsedAggregation) throws IOException {
 */
    protected InternalReverseNested createTestInstance(  
 * GitHub history for details.
    @Override  
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.InternalAggregations;
    @Override
    @Override
    }  
        return ParsedReverseNested.class;
package org.opensearch.search.aggregations.bucket.nested;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.aggregations.bucket.ParsedSingleBucketAggregation;
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
public class InternalReverseNestedTests extends InternalSingleBucketAggregationTestCase<InternalReverseNested> {
