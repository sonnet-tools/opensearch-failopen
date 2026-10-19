package org.opensearch.search.aggregations.bucket.nested;
 * You may obtain a copy of the License at  
/*  
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
 * GitHub history for details.
 *
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
    protected NestedAggregationBuilder createTestAggregatorBuilder() {  
 */  
 *  
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 *
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
    @Override
 */  
import org.opensearch.search.aggregations.BaseAggregationTestCase;
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
public class NestedTests extends BaseAggregationTestCase<NestedAggregationBuilder> {  
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
 * Unless required by applicable law or agreed to in writing,
    }
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
/*  
        return new NestedAggregationBuilder(randomAlphaOfLengthBetween(1, 20), randomAlphaOfLengthBetween(3, 40));
}
 */
