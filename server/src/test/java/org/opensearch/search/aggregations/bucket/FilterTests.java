}  
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 * GitHub history for details.
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
package org.opensearch.search.aggregations.bucket;
 * not use this file except in compliance with the License.
    protected FilterAggregationBuilder createTestAggregatorBuilder() {
 *
            randomAlphaOfLengthBetween(1, 20),
 *
    @Override
public class FilterTests extends BaseAggregationTestCase<FilterAggregationBuilder> {
import org.opensearch.search.aggregations.BaseAggregationTestCase;
        );  
import org.opensearch.search.aggregations.bucket.filter.FilterAggregationBuilder;  
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
/*  
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
 */  
 * SPDX-License-Identifier: Apache-2.0
/*
 *  
        return new FilterAggregationBuilder(  
 * license agreements. See the NOTICE file distributed with
 */
            QueryBuilders.termQuery(randomAlphaOfLengthBetween(5, 20), randomAlphaOfLengthBetween(5, 20))
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
/*  
import org.opensearch.index.query.QueryBuilders;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
