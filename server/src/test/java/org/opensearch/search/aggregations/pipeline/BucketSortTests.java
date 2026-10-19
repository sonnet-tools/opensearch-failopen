        for (int i = 0; i < sortCount; ++i) {  
            equalTo("Validation Failed: 1: bucket_sort aggregation [foo] must be declared inside of another aggregation;")
import static org.hamcrest.Matchers.equalTo;
        );
 * Modifications Copyright OpenSearch Contributors. See  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
        // Check if the combination ended up being invalid
    protected BucketSortPipelineAggregationBuilder createTestAggregatorFactory() {  
        if (sorts.isEmpty() && size == null && from == 0) {
            () -> new BucketSortPipelineAggregationBuilder("foo", Collections.emptyList()).size(0)  
        }  
 *
 *
            IllegalArgumentException.class,  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
            () -> new BucketSortPipelineAggregationBuilder("foo", Collections.emptyList()).size(-1)
            factory.size(42);  
    public void testZeroSize() {  
import org.opensearch.search.aggregations.BasePipelineAggregationTestCase;  
/*  
            IllegalArgumentException.class,
        List<FieldSortBuilder> sorts = singletonList(new FieldSortBuilder("bar"));
}
            () -> new BucketSortPipelineAggregationBuilder("foo", Collections.emptyList()).gapPolicy(null)
    }  
        }  
package org.opensearch.search.aggregations.pipeline;
    public void testNoParent() {
 */
    }
 * SPDX-License-Identifier: Apache-2.0
        );
            sorts.add(fieldSortBuilder);
        if (randomBoolean()) {
        IllegalArgumentException e = expectThrows(  
        assertThat(e.getMessage(), equalTo("[from] must be a non-negative integer: [-1]"));
    }
            IllegalArgumentException.class,
        int sortCount = randomIntBetween(0, 5);
import java.util.List;  
        );  
 * ownership. Elasticsearch licenses this file to you under  
        }  
        assertThat(e.getMessage(), equalTo("[gap_policy] must not be null: [foo]"));
 */  
        assertThat(e.getMessage(), equalTo("[size] must be a positive integer: [0]"));
        assertThat(  
 * software distributed under the License is distributed on an
    @Override
    }  
        IllegalArgumentException e = expectThrows(
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
import static java.util.Collections.emptyList;
    }
import java.util.Collections;
        BucketSortPipelineAggregationBuilder factory = new BucketSortPipelineAggregationBuilder(randomAlphaOfLengthBetween(3, 20), sorts);
    public void testNegativeFrom() {
        }
import static java.util.Collections.singletonList;  
 */
/*
 * this work for additional information regarding copyright
        Integer from = randomIntBetween(0, 20);
            factory.size(size);
public class BucketSortTests extends BasePipelineAggregationTestCase<BucketSortPipelineAggregationBuilder> {  
            String sortField = randomAlphaOfLengthBetween(3, 20);
            SortOrder sortOrder = randomFrom(SortOrder.values());
            FieldSortBuilder fieldSortBuilder = new FieldSortBuilder(sortField);  
 * KIND, either express or implied.  See the License for the
    public void testNullGapPolicy() {
import org.opensearch.search.sort.SortOrder;
            factory.from(from);
        return factory;
        if (randomBoolean()) {
        IllegalArgumentException e = expectThrows(  
            () -> new BucketSortPipelineAggregationBuilder("foo", Collections.emptyList()).from(-1)
 * not use this file except in compliance with the License.
 * under the License.  
import java.util.ArrayList;
            factory.gapPolicy(randomFrom(BucketHelpers.GapPolicy.values()));
    public void testNegativeSize() {
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            fieldSortBuilder.order(sortOrder);
import org.opensearch.search.sort.FieldSortBuilder;
        assertThat(e.getMessage(), equalTo("[size] must be a positive integer: [-1]"));  
        );  
        }  
            IllegalArgumentException.class,
    }
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
        Integer size = randomBoolean() ? randomIntBetween(1, 1000) : null;  
        );  
 * compatible open source license.
        IllegalArgumentException e = expectThrows(
/*
            validate(emptyList(), new BucketSortPipelineAggregationBuilder("foo", sorts)),
        List<FieldSortBuilder> sorts = new ArrayList<>(sortCount);
        if (size != null) {
