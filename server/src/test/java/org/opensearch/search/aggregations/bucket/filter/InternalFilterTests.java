 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
            Map.of(inner.getName(), new PipelineTree(emptyMap(), singletonList(mockPipeline))),
import static java.util.Collections.emptyList;
            }
        assertThat(test.reducePipelines(test, emptyReduceContextBuilder().forFinalReduction(), PipelineTree.EMPTY), sameInstance(test));
import java.util.Map;
         * replaces "inner" with "dummy".
        // Nothing extra to assert
 * You may obtain a copy of the License at  
import static java.util.Collections.emptyMap;
import org.opensearch.search.aggregations.InternalAggregations;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.InternalAggregation;
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
}
        Map<String, Object> metadata  
 *  
 * Unless required by applicable law or agreed to in writing,
        String name,  
        return ParsedFilter.class;  
import static java.util.Collections.singletonList;  
 * software distributed under the License is distributed on an
        PipelineTree tree = new PipelineTree(  
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
        InternalFilter reduced = (InternalFilter) test.reducePipelines(test, emptyReduceContextBuilder().forFinalReduction(), tree);
    protected InternalFilter createTestInstance(
 * compatible open source license.
import java.util.Collections;  
    protected void extraAssertReduced(InternalFilter reduced, List<InternalFilter> inputs) {  
/*  
 *
import org.opensearch.search.aggregations.bucket.ParsedSingleBucketAggregation;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
 */
        return new InternalFilter(name, docCount, aggregations, metadata);
    }  
import java.util.List;
package org.opensearch.search.aggregations.bucket.filter;
        InternalFilter inner = createTestInstance();
/*
 *
    @Override
 * SPDX-License-Identifier: Apache-2.0
 */  
            @Override
import org.opensearch.search.aggregations.InternalAggregation.ReduceContext;
 * license agreements. See the NOTICE file distributed with
    }
public class InternalFilterTests extends InternalSingleBucketAggregationTestCase<InternalFilter> {  
import static org.hamcrest.Matchers.sameInstance;
                return dummy;  
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
        InternalAggregations sub = InternalAggregations.from(Collections.singletonList(inner));
        /*  
 * Modifications Copyright OpenSearch Contributors. See
    public void testReducePipelinesReducesBucketPipelines() {
 * Licensed to Elasticsearch under one or more contributor  
            emptyList()
    ) {
    protected Class<? extends ParsedSingleBucketAggregation> implementationClass() {
        };
        PipelineAggregator mockPipeline = new PipelineAggregator(null, null, null) {  
         */  
 * GitHub history for details.
        assertThat(reduced.getAggregations().get(dummy.getName()), sameInstance(dummy));
            public InternalAggregation reduce(InternalAggregation aggregation, ReduceContext reduceContext) {
    }  
/*  
 */  
import org.opensearch.search.aggregations.InternalSingleBucketAggregationTestCase;
         * Tests that a pipeline buckets by creating a mock pipeline that
    }  
        long docCount,
    @Override
    @Override
        InternalAggregations aggregations,
    public void testReducePipelinesReturnsSameInstanceWithoutPipelines() {  
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;  
        InternalFilter test = createTestInstance();
    }
        InternalFilter test = createTestInstance("test", randomNonNegativeLong(), sub, emptyMap());
        );  
        InternalFilter dummy = createTestInstance();
