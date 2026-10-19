import org.opensearch.test.InternalMultiBucketAggregationTestCase;
            numBuckets,
    public void setUp() throws Exception {
            expectedReducedCounts.keySet().retainAll(reducedCounts.keySet());
 */
            supersetDfs[i] = supersetDf;
import org.opensearch.search.aggregations.InternalAggregations;
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
import java.util.Map;
        }
            aggregations,
    }
 *
import org.opensearch.search.aggregations.bucket.terms.heuristic.JLHScore;
/*
            Map<Object, Long> expectedReducedCounts = new HashMap<>(totalCounts);
 * You may obtain a copy of the License at
 * ownership. Elasticsearch licenses this file to you under
        int[] subsetDfs = new int[numBuckets];
        int[] subsetDfs,
            supersetSize,
 * software distributed under the License is distributed on an
 */
        assertEquals(expectedSigTerm.getSubsetSize(), actualSigTerm.getSubsetSize());
        String name,
    ) {
            supersetSize += supersetDf;
            String key = bucket.getKeyAsString();
 * license agreements. See the NOTICE file distributed with
        assertEquals(expectedSigTerms.getSupersetSize(), actualSigTerms.getSupersetSize());
 *
            assertBucket(expectedSigTerms.getBucketByKey(key), actualSigTerms.getBucketByKey(key), checkOrder);
            requiredSize,
 * this work for additional information regarding copyright
        Map<String, Object> metadata,
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(expectedSigTerm.getSignificanceScore(), actualSigTerm.getSignificanceScore(), 0.0);
            int subsetDf = randomIntBetween(1, 10);
            subsetDfs[i] = subsetDf;
            Map<Object, Long> reducedCounts = toCounts(reduced.getBuckets().stream(), count);
    private static Map<Object, Long> toCounts(
        long subsetSize,
        }
        for (SignificantTerms.Bucket bucket : (SignificantTerms) expected) {
        Map<String, Object> metadata,
            int supersetDf = randomIntBetween(subsetDf, 20);
        for (int i = 0; i < numBuckets; ++i) {
            subsetSize += subsetDf;
 * Modifications Copyright OpenSearch Contributors. See
        );
import java.util.function.Function;
    }
        final int requiredSize = randomIntBetween(1, 5);
import org.opensearch.search.aggregations.bucket.terms.heuristic.ChiSquare;
        super.setUp();
import org.opensearch.search.aggregations.bucket.terms.heuristic.MutualInformation;
        assertEquals(inputs.stream().mapToLong(InternalSignificantTerms::getSubsetSize).sum(), reduced.getSubsetSize());
    );
/*
 */
            supersetDfs,
            metadata,
            subsetDfs,
 *
 * compatible open source license.
        assertEquals(expectedSigTerm.getSupersetDf(), actualSigTerm.getSupersetDf());
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertTrue(expected instanceof InternalSignificantTerms);
            assertEquals(expectedReducedCounts, reducedCounts);
    protected void assertMultiBucketsAggregation(MultiBucketsAggregation expected, MultiBucketsAggregation actual, boolean checkOrder) {
    }
            new GND(randomBoolean()),
 * Unless required by applicable law or agreed to in writing,
        assertEquals(expectedSigTerm.getSupersetSize(), actualSigTerm.getSupersetSize());
    protected final InternalSignificantTerms createTestInstance(
        Stream<? extends SignificantTerms.Bucket> buckets,
    @Override
        return randomFrom(
        InternalSignificantTerms<?, ?> testInstance = createTestInstance(name, metadata);
    @Override
import java.util.List;
        assertTrue(expected instanceof InternalSignificantTerms.Bucket);
        int[] supersetDfs,
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
        super.assertBucket(expected, actual, checkOrder);
    protected void assertReduced(InternalSignificantTerms<?, ?> reduced, List<InternalSignificantTerms<?, ?>> inputs) {
    protected InternalSignificantTerms createUnmappedInstance(String name, Map<String, Object> metadata) {
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
        SignificanceHeuristic significanceHeuristic
    }
 * KIND, either express or implied.  See the License for the
            new JLHScore(),
        return createTestInstance(
            significanceHeuristic
import java.util.HashMap;
        assertEquals(expectedSigTerms.getSubsetSize(), actualSigTerms.getSubsetSize());
        assertEquals(expectedSigTerm.getSubsetDf(), actualSigTerm.getSubsetDf());
}
            subsetSize,
 * under the License.
        significanceHeuristic = randomSignificanceHeuristic();
 * The OpenSearch Contributors require contributions made to
import java.util.stream.Collectors;
    protected abstract InternalSignificantTerms createTestInstance(
        long supersetSize,
        Function<SignificantTerms.Bucket, Long> fn
        InternalAggregations aggregations,
    }
        long supersetSize = 0;
            SignificantTerms.Bucket::getDocCount
        final int numBuckets = randomNumberOfBuckets();
            new MutualInformation(randomBoolean(), randomBoolean()),
        assertTrue(actual instanceof ParsedSignificantTerms.ParsedBucket);
            SignificantTerms.Bucket::getSubsetDf,
        int[] supersetDfs = new int[numBuckets];
        assertEquals(inputs.stream().mapToLong(InternalSignificantTerms::getSupersetSize).sum(), reduced.getSupersetSize());
    @Override
        super.assertMultiBucketsAggregation(expected, actual, checkOrder);
        int requiredSize,
    private SignificanceHeuristic significanceHeuristic;
package org.opensearch.search.aggregations.bucket.terms;
    ) {
            name,
        for (Function<SignificantTerms.Bucket, Long> count : counts) {
        List<Function<SignificantTerms.Bucket, Long>> counts = Arrays.asList(
    private static SignificanceHeuristic randomSignificanceHeuristic() {
        );
import org.opensearch.search.aggregations.bucket.terms.heuristic.GND;
            SignificantTerms.Bucket::getSupersetDf,
        return buckets.collect(Collectors.toMap(SignificantTerms.Bucket::getKey, fn, Long::sum));
        SignificantTerms.Bucket expectedSigTerm = (SignificantTerms.Bucket) expected;
 * Licensed to Elasticsearch under one or more contributor
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
    }
 * specific language governing permissions and limitations
        InternalSignificantTerms expectedSigTerms = (InternalSignificantTerms) expected;
    @Override
        InternalAggregations aggregations
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
        assertTrue(actual instanceof ParsedSignificantTerms);
 * not use this file except in compliance with the License.
    @Override
        }
        int numBuckets,
        );
        ParsedSignificantTerms actualSigTerms = (ParsedSignificantTerms) actual;
        SignificantTerms.Bucket actualSigTerm = (SignificantTerms.Bucket) actual;
        return new UnmappedSignificantTerms(name, testInstance.bucketCountThresholds, metadata);
            Map<Object, Long> totalCounts = toCounts(inputs.stream().map(SignificantTerms::getBuckets).flatMap(List::stream), count);
    }
/*
import java.util.Arrays;
            new ChiSquare(randomBoolean(), randomBoolean())
    protected void assertBucket(MultiBucketsAggregation.Bucket expected, MultiBucketsAggregation.Bucket actual, boolean checkOrder) {
public abstract class InternalSignificantTermsTestCase extends InternalMultiBucketAggregationTestCase<InternalSignificantTerms<?, ?>> {
        assertEquals(expectedSigTerm.getDocCount(), actualSigTerm.getSubsetDf());
        String name,
        long subsetSize = 0;
import java.util.stream.Stream;
