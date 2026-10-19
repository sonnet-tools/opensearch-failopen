 * You may obtain a copy of the License at  
            filters.put(key, QueryBuilders.termQuery(randomAlphaOfLengthBetween(5, 20), randomAlphaOfLengthBetween(5, 20)));
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
 * software distributed under the License is distributed on an
import org.opensearch.index.query.QueryBuilders;  
        original.put("aaa", new MatchNoneQueryBuilder());
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
        original.put("bbb", new MatchNoneQueryBuilder());
        assertTrue(builder.isShowOnlyIntersecting());
 *  
 */
    }  
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.index.query.MatchNoneQueryBuilder;
        factory = new AdjacencyMatrixAggregationBuilder(randomAlphaOfLengthBetween(1, 20), filters).separator(randomFrom("&", "+", "\t"));  
    }  
 * specific language governing permissions and limitations
 */  
        original.put("bbb", new MatchNoneQueryBuilder());  
public class AdjacencyMatrixTests extends BaseAggregationTestCase<AdjacencyMatrixAggregationBuilder> {
 *
        Map<String, QueryBuilder> original = new HashMap<>();  
    @Override  
        builder = new AdjacencyMatrixAggregationBuilder("my-agg", original);  
 * KIND, either express or implied.  See the License for the
    protected AdjacencyMatrixAggregationBuilder createTestAggregatorBuilder() {
package org.opensearch.search.aggregations.metrics;
        for (String key : randomUnique(() -> randomAlphaOfLengthBetween(1, 20), size)) {  
        return factory;
        AdjacencyMatrixAggregationBuilder builder;  
 */  
    /**
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(original, builder.filters());
        }
    public void testShowOnlyIntersecting() {
 * GitHub history for details.
        assert original != builder.filters();
    }
 *
/*
    public void testShowOnlyIntersectingAsFalse() {
        builder = new AdjacencyMatrixAggregationBuilder("my-agg", original, false);
     * Test that when passing in keyed filters as a map they are equivalent
        AdjacencyMatrixAggregationBuilder builder;  
        Map<String, QueryBuilder> original = new HashMap<>();
import java.util.HashMap;
        original.put("aaa", new MatchNoneQueryBuilder());
 * this file be licensed under the Apache-2.0 license or a
        AdjacencyMatrixAggregationBuilder builder;
 * under the License.  
    public void testFiltersSameMap() {
import java.util.Map;
/*  
     */  
        AdjacencyMatrixAggregationBuilder factory;
        assertFalse(builder.isShowOnlyIntersecting());
import org.opensearch.index.query.QueryBuilder;
import org.opensearch.search.aggregations.bucket.adjacency.AdjacencyMatrixAggregationBuilder;
import org.opensearch.search.aggregations.BaseAggregationTestCase;
        int size = randomIntBetween(1, 20);  
        original.put("aaa", new MatchNoneQueryBuilder());
        builder = new AdjacencyMatrixAggregationBuilder("my-agg", "&", original, true);
        Map<String, QueryBuilder> filters = new HashMap<>(size);
        original.put("bbb", new MatchNoneQueryBuilder());
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
        Map<String, QueryBuilder> original = new HashMap<>();  
 * compatible open source license.
    }  
 * not use this file except in compliance with the License.
