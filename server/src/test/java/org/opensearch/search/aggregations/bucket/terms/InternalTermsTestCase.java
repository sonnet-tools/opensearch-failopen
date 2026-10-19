            ? -1
/*  
            .map(Terms::getBuckets)  
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
            .mapToLong(Terms.Bucket::getDocCount)  
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.search.aggregations.bucket.terms;
    @Override
    protected InternalTerms<?, ?> createUnmappedInstance(String name, Map<String, Object> metadata) {
 * software distributed under the License is distributed on an
        final long reducedTotalDocCount = reduced.getSumOfOtherDocCounts() + reduced.getBuckets()
import java.util.HashMap;
    protected long docCountError;  
    protected boolean showDocCount;
/*  
            fail("Missed term: " + missingTerm + " from " + reducedCounts);
        return createTestInstance(name, metadata, aggregations, showDocCount, docCountError);
 *
        Map<Object, Long> evictedTerms = new HashMap<>(totalCounts);  
        final int requiredSize = inputs.get(0).requiredSize;
import java.util.stream.Stream;
        Optional<Entry<Object, Long>> missingTerm = evictedTerms.entrySet().stream().filter(e -> e.getValue() > minFinalcount).findAny();
    }  
    protected void assertReduced(InternalTerms<?, ?> reduced, List<InternalTerms<?, ?>> inputs) {
    @Override  
 *
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.aggregations.InternalAggregations;
 * Modifications Copyright OpenSearch Contributors. See
        String name,
            : reduced.getBuckets().get(reduced.getBuckets().size() - 1).getDocCount();
        InternalAggregations aggregations,
 * under the License.  
 *  
 * compatible open source license.
    }  
import org.opensearch.test.InternalMultiBucketAggregationTestCase;
/*
    private static Map<Object, Long> toCounts(Stream<? extends Terms.Bucket> buckets) {
    );
 * Unless required by applicable law or agreed to in writing,
        Map<Object, Long> expectedReducedCounts = new HashMap<>(totalCounts);
        }
    @Override  
 */  
import static org.hamcrest.Matchers.equalTo;
 * this work for additional information regarding copyright
 */
        for (InternalTerms<?, ?> terms : inputs) {
    @Before
 */  
        final long minFinalcount = reduced.getBuckets().isEmpty()  
    protected abstract InternalTerms<?, ?> createTestInstance(
        Map<Object, Long> totalCounts = toCounts(inputs.stream().map(Terms::getBuckets).flatMap(List::stream));
import java.util.List;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            .sum();
import java.util.Optional;  
    }
 * specific language governing permissions and limitations
        assertEquals(expectedTotalDocCount, reducedTotalDocCount);
        showDocCount = randomBoolean();
import java.util.Map.Entry;
            assertThat(reduced.order, equalTo(terms.order));
        assertEquals(expectedReducedCounts, reducedCounts);
import java.util.stream.Collectors;
        evictedTerms.keySet().removeAll(reducedCounts.keySet());
        return buckets.collect(Collectors.toMap(Terms.Bucket::getKey, Terms.Bucket::getDocCount, Long::sum));  
import java.util.Map;
 * You may obtain a copy of the License at  
            .mapToLong(Terms.Bucket::getDocCount)
 * license agreements. See the NOTICE file distributed with
        InternalTerms<?, ?> testInstance = createTestInstance(name, metadata);
        if (missingTerm.isPresent()) {  
    public void init() {  
import org.junit.Before;  
        assertEquals(reducedCounts.size() == requiredSize, totalCounts.size() >= requiredSize);  
            assertThat(reduced.reduceOrder, equalTo(terms.order));  
    }
        boolean showTermDocCountError,
    protected InternalTerms<?, ?> createTestInstance(String name, Map<String, Object> metadata, InternalAggregations aggregations) {  
        expectedReducedCounts.keySet().retainAll(reducedCounts.keySet());  
}
            .sum();  
public abstract class InternalTermsTestCase extends InternalMultiBucketAggregationTestCase<InternalTerms<?, ?>> {  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
    }
        Map<Object, Long> reducedCounts = toCounts(reduced.getBuckets().stream());  
            .stream()
        final long expectedTotalDocCount = inputs.stream()
 * ownership. Elasticsearch licenses this file to you under  
        }
        long docCountError  
        return new UnmappedTerms(name, testInstance.order, testInstance.bucketCountThresholds, metadata);  
        Map<String, Object> metadata,  
 * the Apache License, Version 2.0 (the "License"); you may
            .flatMap(List::stream)
        docCountError = showDocCount ? randomInt(1000) : -1;
