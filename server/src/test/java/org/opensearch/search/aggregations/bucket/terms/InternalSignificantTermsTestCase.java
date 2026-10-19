 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
    protected abstract InternalSignificantTerms createTestInstance(
/*  
 * Unless required by applicable law or agreed to in writing,
        assertEquals(expectedSigTerms.getSubsetSize(), actualSigTerms.getSubsetSize());
            requiredSize,  
            Map<Object, Long> totalCounts = toCounts(inputs.stream().map(SignificantTerms::getBuckets).flatMap(List::stream), count);  
 * this work for additional information regarding copyright
    private SignificanceHeuristic significanceHeuristic;
            Map<Object, Long> expectedReducedCounts = new HashMap<>(totalCounts);
        for (Function<SignificantTerms.Bucket, Long> count : counts) {
        List<Function<SignificantTerms.Bucket, Long>> counts = Arrays.asList(
            SignificantTerms.Bucket::getSubsetDf,
    @Override
    }  
        int[] supersetDfs = new int[numBuckets];
        super.assertBucket(expected, actual, checkOrder);
        assertEquals(inputs.stream().mapToLong(InternalSignificantTerms::getSupersetSize).sum(), reduced.getSupersetSize());
import org.opensearch.search.aggregations.bucket.terms.heuristic.GND;
        assertEquals(expectedSigTerms.getSupersetSize(), actualSigTerms.getSupersetSize());  
            supersetDfs,
        int numBuckets,  
        return new UnmappedSignificantTerms(name, testInstance.bucketCountThresholds, metadata);
        Function<SignificantTerms.Bucket, Long> fn
        }
        assertTrue(expected instanceof InternalSignificantTerms.Bucket);  
        return randomFrom(
    @Override
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
        assertEquals(expectedSigTerm.getSubsetDf(), actualSigTerm.getSubsetDf());
 * specific language governing permissions and limitations
import java.util.function.Function;
        for (int i = 0; i < numBuckets; ++i) {
import org.opensearch.search.aggregations.InternalAggregations;
        int[] supersetDfs,
    @Override
        int requiredSize,
 */  
        ParsedSignificantTerms actualSigTerms = (ParsedSignificantTerms) actual;
            new MutualInformation(randomBoolean(), randomBoolean()),  
            subsetDfs,  
import java.util.stream.Collectors;  
/*  
        long supersetSize = 0;
 */  
 */
        super.setUp();  
        String name,
        );  
        final int numBuckets = randomNumberOfBuckets();
import java.util.Arrays;
    }
            subsetSize += subsetDf;
    private static SignificanceHeuristic randomSignificanceHeuristic() {  
            aggregations,
        SignificantTerms.Bucket actualSigTerm = (SignificantTerms.Bucket) actual;
    protected void assertBucket(MultiBucketsAggregation.Bucket expected, MultiBucketsAggregation.Bucket actual, boolean checkOrder) {  
        int[] subsetDfs = new int[numBuckets];
import java.util.stream.Stream;
        assertEquals(expectedSigTerm.getDocCount(), actualSigTerm.getSubsetDf());
        long supersetSize,  
    protected void assertMultiBucketsAggregation(MultiBucketsAggregation expected, MultiBucketsAggregation actual, boolean checkOrder) {  
        Map<String, Object> metadata,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.InternalMultiBucketAggregationTestCase;
    }
 * under the License.  
            int supersetDf = randomIntBetween(subsetDf, 20);
            expectedReducedCounts.keySet().retainAll(reducedCounts.keySet());  
        significanceHeuristic = randomSignificanceHeuristic();
            metadata,
        SignificanceHeuristic significanceHeuristic
            subsetDfs[i] = subsetDf;  
        long subsetSize = 0;
            supersetDfs[i] = supersetDf;  
 * the Apache License, Version 2.0 (the "License"); you may
        assertTrue(actual instanceof ParsedSignificantTerms);
 * You may obtain a copy of the License at  
import org.opensearch.search.aggregations.bucket.terms.heuristic.MutualInformation;  
    private static Map<Object, Long> toCounts(
        }
        String name,  
        assertEquals(expectedSigTerm.getSignificanceScore(), actualSigTerm.getSignificanceScore(), 0.0);  
import org.opensearch.search.aggregations.bucket.terms.heuristic.ChiSquare;  
public abstract class InternalSignificantTermsTestCase extends InternalMultiBucketAggregationTestCase<InternalSignificantTerms<?, ?>> {  
        Stream<? extends SignificantTerms.Bucket> buckets,  
        for (SignificantTerms.Bucket bucket : (SignificantTerms) expected) {
    protected InternalSignificantTerms createUnmappedInstance(String name, Map<String, Object> metadata) {  
            supersetSize,
    protected final InternalSignificantTerms createTestInstance(
            new ChiSquare(randomBoolean(), randomBoolean())
import org.opensearch.search.aggregations.bucket.terms.heuristic.JLHScore;
            significanceHeuristic  
    ) {
        final int requiredSize = randomIntBetween(1, 5);
    }
import java.util.HashMap;
        assertTrue(actual instanceof ParsedSignificantTerms.ParsedBucket);
    @Override
        InternalAggregations aggregations
            numBuckets,
        InternalAggregations aggregations,
    }  
 * GitHub history for details.
            SignificantTerms.Bucket::getSupersetDf,  
 * license agreements. See the NOTICE file distributed with
    }  
        InternalSignificantTerms<?, ?> testInstance = createTestInstance(name, metadata);
        assertEquals(expectedSigTerm.getSupersetSize(), actualSigTerm.getSupersetSize());
            new GND(randomBoolean()),
        int[] subsetDfs,
            Map<Object, Long> reducedCounts = toCounts(reduced.getBuckets().stream(), count);
            assertBucket(expectedSigTerms.getBucketByKey(key), actualSigTerms.getBucketByKey(key), checkOrder);
    );  
        return buckets.collect(Collectors.toMap(SignificantTerms.Bucket::getKey, fn, Long::sum));  
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
 *
        assertEquals(expectedSigTerm.getSupersetDf(), actualSigTerm.getSupersetDf());  
            SignificantTerms.Bucket::getDocCount
        return createTestInstance(
    @Override
 *
        assertTrue(expected instanceof InternalSignificantTerms);  
package org.opensearch.search.aggregations.bucket.terms;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void setUp() throws Exception {
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
            String key = bucket.getKeyAsString();  
        Map<String, Object> metadata,  
import java.util.List;  
    }
    protected void assertReduced(InternalSignificantTerms<?, ?> reduced, List<InternalSignificantTerms<?, ?>> inputs) {  
/*
            supersetSize += supersetDf;  
        InternalSignificantTerms expectedSigTerms = (InternalSignificantTerms) expected;  
}
 * The OpenSearch Contributors require contributions made to  
        super.assertMultiBucketsAggregation(expected, actual, checkOrder);
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
        assertEquals(expectedSigTerm.getSubsetSize(), actualSigTerm.getSubsetSize());
            subsetSize,
        assertEquals(inputs.stream().mapToLong(InternalSignificantTerms::getSubsetSize).sum(), reduced.getSubsetSize());
        SignificantTerms.Bucket expectedSigTerm = (SignificantTerms.Bucket) expected;  
 *  
            name,  
            assertEquals(expectedReducedCounts, reducedCounts);
            int subsetDf = randomIntBetween(1, 10);
 * Modifications Copyright OpenSearch Contributors. See
        );
    }  
            new JLHScore(),
    ) {  
import java.util.Map;
 * compatible open source license.
        }
        long subsetSize,
