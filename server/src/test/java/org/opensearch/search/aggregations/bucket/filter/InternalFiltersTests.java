            Map.of(inner.getName(), new PipelineTree(emptyMap(), singletonList(mockPipeline))),
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
/*
        };  
                buckets = new ArrayList<>(buckets);  
            @Override
        InternalFilters inner = createTestInstance();  
            }  
 */
        InternalFilters test = createTestInstance();
import java.util.Map;
        super.setUp();
        return new InternalFilters(name, buckets, keyed, metadata);  
import java.util.List;
                return dummy;
        return new InternalFilters(name, buckets, keyed, metadata);
 *
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;  
            } else {  
         */
                keys.add(randomAlphaOfLength(5));
 * Unless required by applicable law or agreed to in writing,
            public InternalAggregation reduce(InternalAggregation aggregation, ReduceContext reduceContext) {  
 * specific language governing permissions and limitations
                }  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
    @Override  
        for (InternalFilters.InternalBucket bucket : reduced.getBuckets()) {  
    protected InternalFilters mutateInstance(InternalFilters instance) {  
            int docCount = randomIntBetween(0, 1000);  
    @Override
import java.util.HashMap;  
    public void setUp() throws Exception {
                    (key, oldValue) -> (oldValue == null ? 0 : oldValue) + bucket.getDocCount()
 * under the License.  
            emptyList()  
 */  
        }
 * KIND, either express or implied.  See the License for the
    }  
                );
                name += randomAlphaOfLength(5);  
        for (int i = 0; i < keys.size(); ++i) {
    }
        switch (between(0, 2)) {
        /*
        assertEquals(expectedCounts, actualCounts);  
            case 0:
            String key = keys.get(i);
import static org.hamcrest.Matchers.sameInstance;
/*  
 * GitHub history for details.
/*  
        final Map<String, Long> expectedCounts = new TreeMap<>();
    protected InternalFilters createTestInstance(String name, Map<String, Object> metadata, InternalAggregations aggregations) {
import org.opensearch.test.InternalMultiBucketAggregationTestCase;
import static java.util.Collections.emptyMap;  
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
            assertThat(bucket.getAggregations().get(dummy.getName()), sameInstance(dummy));
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
        );
                    metadata = new HashMap<>(instance.getMetadata());
        for (InternalFilters.InternalBucket bucket : reduced.getBuckets()) {  
        final List<InternalFilters.InternalBucket> buckets = new ArrayList<>();  
         * replaces "inner" with "dummy".  
                metadata.put(randomAlphaOfLength(15), randomInt());
            if (keyed) {
import static java.util.Collections.emptyList;
    }
    private boolean keyed;  
 */  
        PipelineTree tree = new PipelineTree(
                break;
        }
 * the Apache License, Version 2.0 (the "License"); you may
            }
                // this is what the FiltersAggregationBuilder ctor does when not providing KeyedFilter
public class InternalFiltersTests extends InternalMultiBucketAggregationTestCase<InternalFilters> {
        int numBuckets = randomNumberOfBuckets();
            buckets.add(new InternalFilters.InternalBucket(key, docCount, aggregations, keyed));
        final Map<String, Long> actualCounts = new TreeMap<>();
 * not use this file except in compliance with the License.
    }
        InternalFilters dummy = createTestInstance();
    }  
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {
            actualCounts.compute(bucket.getKeyAsString(), (key, oldValue) -> (oldValue == null ? 0 : oldValue) + bucket.getDocCount());
    }
 * You may obtain a copy of the License at  
import org.opensearch.search.aggregations.InternalAggregation.ReduceContext;
import java.util.TreeMap;  
        InternalAggregations sub = InternalAggregations.from(Collections.singletonList(inner));
    @Override  
package org.opensearch.search.aggregations.bucket.filter;
import org.opensearch.search.aggregations.InternalAggregation;
 *  
 * this work for additional information regarding copyright
        PipelineAggregator mockPipeline = new PipelineAggregator(null, null, null) {
 * ownership. Elasticsearch licenses this file to you under  
                if (metadata == null) {
        }  
 *
        String name = instance.getName();
        }
        InternalFilters test = createTestInstance("test", emptyMap(), sub);  
import java.util.Collections;
                    bucket.getKeyAsString(),  
    protected void assertReduced(InternalFilters reduced, List<InternalFilters> inputs) {
import java.util.ArrayList;
    @Override
                expectedCounts.compute(
    public void testReducePipelinesReturnsSameInstanceWithoutPipelines() {
import org.opensearch.search.aggregations.bucket.filter.InternalFilters.InternalBucket;
                break;
    public void testReducePipelinesReducesBucketPipelines() {  
 * The OpenSearch Contributors require contributions made to  
        InternalFilters reduced = (InternalFilters) test.reducePipelines(test, emptyReduceContextBuilder().forFinalReduction(), tree);
                buckets.add(new InternalFilters.InternalBucket("test", randomIntBetween(0, 1000), InternalAggregations.EMPTY, keyed));
    private List<String> keys;
        return ParsedFilters.class;
            default:
        for (int i = 0; i < numBuckets; i++) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                keys.add(String.valueOf(i));
 * compatible open source license.
        keyed = randomBoolean();  
        }
 * software distributed under the License is distributed on an
            }  
            for (InternalFilters.InternalBucket bucket : input.getBuckets()) {
        keys = new ArrayList<>();
                    metadata = new HashMap<>(1);  
import org.opensearch.search.aggregations.InternalAggregations;  
         * Tests that a pipeline buckets by creating a mock pipeline that
        List<InternalBucket> buckets = instance.getBuckets();
        for (InternalFilters input : inputs) {  
            case 2:  
            case 1:
                } else {
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Object> metadata = instance.getMetadata();  
    @Override  
    }
        assertThat(test.reducePipelines(test, emptyReduceContextBuilder().forFinalReduction(), PipelineTree.EMPTY), sameInstance(test));  
}
import static java.util.Collections.singletonList;
        }
 * Licensed to Elasticsearch under one or more contributor  
                break;
