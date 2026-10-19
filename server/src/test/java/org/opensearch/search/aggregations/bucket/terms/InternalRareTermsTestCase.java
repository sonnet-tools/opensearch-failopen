import org.opensearch.test.InternalMultiBucketAggregationTestCase;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
import org.junit.Before;  
 *  
    protected void assertReduced(InternalRareTerms<?, ?> reduced, List<InternalRareTerms<?, ?>> inputs) {  
import java.util.Map;
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
    @Override  
        assertEquals(expectedReducedCounts, reducedCounts);  
package org.opensearch.search.aggregations.bucket.terms;
    private long maxDocCount;
import org.opensearch.search.aggregations.InternalAggregations;
 * license agreements. See the NOTICE file distributed with
    private static Map<Object, Long> toCounts(Stream<? extends RareTerms.Bucket> buckets) {  
        long maxDocCount  
 * The OpenSearch Contributors require contributions made to  
        Map<Object, Long> expectedReducedCounts = new HashMap<>(totalCounts);
    }  
 * compatible open source license.
    }
/*
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
    );
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
import java.util.List;  
 */  
    protected abstract InternalRareTerms<?, ?> createTestInstance(
 * specific language governing permissions and limitations
        Map<String, Object> metadata,
        InternalAggregations aggregations  
import java.util.stream.Stream;  
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
import java.util.HashMap;
public abstract class InternalRareTermsTestCase extends InternalMultiBucketAggregationTestCase<InternalRareTerms<?, ?>> {
    protected final InternalRareTerms<?, ?> createTestInstance(  
}  
    @Before  
    public void init() {
        return buckets.collect(Collectors.toMap(RareTerms.Bucket::getKey, RareTerms.Bucket::getDocCount, Long::sum));
        return createTestInstance(name, metadata, aggregations, maxDocCount);
    }
        InternalAggregations aggregations,
    }  
/*  
import java.util.stream.Collectors;
        Map<String, Object> metadata,
    @Override
 *
        Map<Object, Long> totalCounts = toCounts(inputs.stream().map(RareTerms::getBuckets).flatMap(List::stream));
    }  
 */
        maxDocCount = randomIntBetween(1, 5);
 * GitHub history for details.
        Map<Object, Long> reducedCounts = toCounts(reduced.getBuckets().stream());
 * You may obtain a copy of the License at  
    @Override
 *
        return new UnmappedRareTerms(name, metadata);
 * under the License.  
    ) {
        String name,  
        String name,
        expectedReducedCounts.keySet().retainAll(reducedCounts.keySet());
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
    protected InternalRareTerms<?, ?> createUnmappedInstance(String name, Map<String, Object> metadata) {
