    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {
            }
        String name = instance.getName();
 */  
        for (InternalAdjacencyMatrix.InternalBucket bucket : reduced.getBuckets()) {
                    );
                        bucket.getKeyAsString(),  
                if (bucket.getDocCount() > 0) {
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
/*  
        }
        final Map<String, Long> expectedCounts = new TreeMap<>();
    @Override  
                name += randomAlphaOfLength(5);
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
                break;
import org.opensearch.search.aggregations.InternalAggregations;
        keys = new ArrayList<>();
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
                    metadata = new HashMap<>(instance.getMetadata());
            for (int j = i + 1; j < filters.length; j++) {
            case 0:  
 */  
                    keys.add(filters[j] + "&" + filters[i]);  
import java.util.ArrayList;
        switch (between(0, 2)) {
    @Override
        // InternalAdjacencyMatrix represents the upper triangular matrix:  
                );
        return new InternalAdjacencyMatrix(name, buckets, metadata);
            case 1:  
                break;
        // 3 filters generates 6 buckets
        final Map<String, Long> actualCounts = new TreeMap<>();  
                buckets.add(
    protected void assertReduced(InternalAdjacencyMatrix reduced, List<InternalAdjacencyMatrix> inputs) {  
    }  
                break;
/*
    protected int maxNumberOfBuckets() {
        for (int i = 0; i < filters.length; i++) {  
                throw new AssertionError("Illegal randomisation branch");  
                if (metadata == null) {
        String[] filters = new String[numFilters];
 * You may obtain a copy of the License at  
            }
            String key = keys.get(i);
            keys.add(filters[i]);
 * not use this file except in compliance with the License.
 *
                        (key, oldValue) -> (oldValue == null ? 0 : oldValue) + bucket.getDocCount()
import org.opensearch.test.InternalMultiBucketAggregationTestCase;  
                } else {
        }  
    @Override
                }  
            actualCounts.compute(bucket.getKeyAsString(), (key, oldValue) -> (oldValue == null ? 0 : oldValue) + bucket.getDocCount());
 * compatible open source license.
    }  
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
import java.util.List;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                buckets = new ArrayList<>(buckets);
package org.opensearch.search.aggregations.bucket.adjacency;
        final List<InternalAdjacencyMatrix.InternalBucket> buckets = new ArrayList<>();
                }
        return 10;
        }
 */
 * GitHub history for details.
                    metadata = new HashMap<>(1);
        int numFilters = randomIntBetween(2, 4);
    }  
 * under the License.  
            int docCount = randomIntBetween(0, 1000);
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
            buckets.add(new InternalAdjacencyMatrix.InternalBucket(key, docCount, aggregations));  
        }  
        Map<String, Object> metadata = instance.getMetadata();
    protected InternalAdjacencyMatrix mutateInstance(InternalAdjacencyMatrix instance) {
                if (filters[i].compareTo(filters[j]) <= 0) {  
                }
 * this work for additional information regarding copyright
        super.setUp();
        return ParsedAdjacencyMatrix.class;  
        assertEquals(expectedCounts, actualCounts);
import java.util.HashMap;  
    }
import java.util.TreeMap;  
            default:
    protected InternalAdjacencyMatrix createTestInstance(String name, Map<String, Object> metadata, InternalAggregations aggregations) {
public class InternalAdjacencyMatrixTests extends InternalMultiBucketAggregationTestCase<InternalAdjacencyMatrix> {
 *
        // 4 filters generates 10 buckets  
                    expectedCounts.compute(
                } else {  
    public void setUp() throws Exception {  
                    keys.add(filters[i] + "&" + filters[j]);
            case 2:  
        List<InternalAdjacencyMatrix.InternalBucket> buckets = instance.getBuckets();  
        for (InternalAdjacencyMatrix input : inputs) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        return new InternalAdjacencyMatrix(name, buckets, metadata);
    @Override  
    private List<String> keys;
 * Modifications Copyright OpenSearch Contributors. See
        }
            filters[i] = randomAlphaOfLength(5);
        for (int i = 0; i < numFilters; i++) {  
import java.util.Map;
        // 2 filters (matrix of 2x2) generates 3 buckets
                    new InternalAdjacencyMatrix.InternalBucket(randomAlphaOfLength(10), randomNonNegativeLong(), InternalAggregations.EMPTY)  
    @Override  
 *  
            for (InternalAdjacencyMatrix.InternalBucket bucket : input.getBuckets()) {  
                metadata.put(randomAlphaOfLength(15), randomInt());  
/*  
    }
    }
        }
        for (int i = 0; i < keys.size(); ++i) {  
 * Unless required by applicable law or agreed to in writing,
}
    @Override
