                        format,
 * The OpenSearch Contributors require contributions made to  
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {
        for (Histogram.Bucket bucket : reduced.getBuckets()) {
        expectThrows(CircuitBreakingException.class, () -> histogram.reduce(List.of(histogram), createReduceContext(2000, breaker)));
            MultiBucketConsumerService.TooManyBucketsException.class,  
        InternalHistogram reduced = (InternalHistogram) histogram.reduce(
        InternalHistogram histogram2 = createTestInstance();  
 * not use this file except in compliance with the License.
            if (expectedCounts.isEmpty() && emptyBucketInfo.minBound <= emptyBucketInfo.maxBound) {  
        assertEquals(expectedCounts, actualCounts);
        List<InternalHistogram.Bucket> buckets,
            Double.POSITIVE_INFINITY,
import org.opensearch.search.DocValueFormat;
            new MultiBucketConsumerService.MultiBucketConsumer(maxBuckets, breaker),  
        double bucketInterval,
 * specific language governing permissions and limitations
        switch (between(0, 4)) {
            MultiBucketConsumerService.TooManyBucketsException.class,  
 * KIND, either express or implied.  See the License for the
            () -> maxBoundHistogram.reduce(List.of(maxBoundHistogram), createReduceContext(10, Mockito.mock(CircuitBreaker.class)))
                break;
    protected InternalHistogram mutateInstance(InternalHistogram instance) {
    }
                Double nextKey = expectedCounts.firstKey();
        InternalHistogram histogram = createHistogram(List.of(), 1, minBound, Math.nextUp(minBound));
            // it's ok if minBound and maxBound are outside the range of the generated buckets, that will just mean that
            emptyBucketInfo = new InternalHistogram.EmptyBucketInfo(interval, offset, minBound, maxBound, InternalAggregations.EMPTY);  
            case 2:  
            int maxBound = randomNumberOfBuckets() * interval + randomIntBetween(0, 10);
                );
    @Override
            }  
            int minBound = randomInt(50) - 30;
        InternalHistogram maxBoundHistogram = createHistogram(buckets, 1, Double.POSITIVE_INFINITY, 10);  
                }  
    private DocValueFormat format;
            return;  
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;  
    public void testExactBucketLimit() {
    protected void assertReduced(InternalHistogram reduced, List<InternalHistogram> inputs) {  
        long minDocCount = instance.getMinDocCount();
                buckets.add(new InternalHistogram.Bucket(base + i * interval, docCount, keyed, format, aggregations));
        // HistogramFactory#nextKey is used by pipeline aggregations and must be guarded too
    }
            () -> histogram.reduce(List.of(histogram), createReduceContext(10, Mockito.mock(CircuitBreaker.class)))
 * software distributed under the License is distributed on an
        Map<String, Object> metadata = instance.getMetadata();  
            1,
        InternalHistogram.EmptyBucketInfo bucketInfo = new InternalHistogram.EmptyBucketInfo(  
        return ParsedHistogram.class;  
            Double.NEGATIVE_INFINITY
        } else {  
        );
        }
                    new InternalHistogram.Bucket(  
        final int numBuckets = randomNumberOfBuckets();
        super.setUp();
        String name = instance.getName();
        }
            for (Histogram.Bucket bucket : histogram.getBuckets()) {  
        if (buckets == null || buckets.isEmpty()) {
                    expectedCounts.putIfAbsent(nextKey, 0L);  
            createReduceContext(10, Mockito.mock(CircuitBreaker.class))
                buckets = new ArrayList<>(buckets);
                        randomNonNegativeLong(),
 * under the License.  
                while (nextKey < expectedCounts.lastKey()) {
        expectThrows(
    @Override
 *  
            maxBound,
    private int interval;  
    private InternalHistogram createHistogram(  
            MultiBucketConsumerService.TooManyBucketsException.class,
    }  
import org.opensearch.core.common.breaker.CircuitBreaker;
        // Set the key of one bucket to NaN. Must be the last bucket because NaN is greater than everything else.  
/*  
        List<InternalHistogram.Bucket> buckets = histogram.getBuckets();
import java.util.Arrays;  
                    )  
        );  
            default:  
    private boolean keyed;
                while (expectedCounts.lastKey() < maxBound) {
        return new InternalHistogram(randomAlphaOfLength(5), buckets, BucketOrder.key(true), 0, bucketInfo, format, false, null);
        InternalHistogram histogram = createTestInstance();
            case 1:  
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.search.aggregations.bucket.histogram;
            case 3:  
        interval = randomIntBetween(1, 3);
            0,
                break;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        offset = randomIntBetween(0, 3);
        );
 */
        if (minDocCount == 0) {
        expectThrows(  
            List.of(createBucket(0), createBucket(100), createBucket(Double.NaN)),  
        List<InternalHistogram.Bucket> buckets = new ArrayList<>();  
            () -> minBoundHistogram.reduce(List.of(minBoundHistogram), createReduceContext(10, Mockito.mock(CircuitBreaker.class)))
 * this file be licensed under the Apache-2.0 license or a
            bucketInterval,
        InternalHistogram histogram = createHistogram(List.of(), 1, 0, 1024);  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    expectedCounts.put(expectedCounts.firstKey() - interval, 0L);
        // set to 0 as empty buckets need to be added to fill the holes.  
    @Override
            () -> histogram.reduce(List.of(histogram), createReduceContext(10, Mockito.mock(CircuitBreaker.class)))  
import org.opensearch.search.aggregations.BucketOrder;
    protected InternalHistogram createTestInstance(String name, Map<String, Object> metadata, InternalAggregations aggregations) {  
                metadata.put(randomAlphaOfLength(15), randomInt());
            List.of(createBucket(0), createBucket(100)),
        InternalHistogram newHistogram = histogram.create(newBuckets);
                    metadata = new HashMap<>(1);  
            Double.NEGATIVE_INFINITY  
        return Math.floor((key - offset) / interval) * interval + offset;
                if (metadata == null) {
                    nextKey += interval;
        }
        );  
        if (buckets.size() > 1) {
 * compatible open source license.
                    metadata = new HashMap<>(instance.getMetadata());
        expectThrows(IllegalArgumentException.class, () -> histogram.nextKey(minBound));  
                while (minBound < expectedCounts.firstKey()) {  
            Arrays.asList(newHistogram, histogram2),
        BucketOrder order = instance.getOrder();
                final int docCount = TestUtil.nextInt(random(), 1, 50);
                );
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
            minDocCount = 0;
import org.opensearch.search.aggregations.MultiBucketConsumerService;
        return new InternalHistogram.Bucket(key, 1, false, format, InternalAggregations.EMPTY);
    public void setUp() throws Exception {  
    public void testCircuitBreakerCheckedWhileAddingEmptyBuckets() {  
                break;
    }
public class InternalHistogramTests extends InternalMultiBucketAggregationTestCase<InternalHistogram> {
            case 4:
    private InternalHistogram.Bucket createBucket(double key) {
        CircuitBreaker breaker = Mockito.mock(CircuitBreaker.class);
import org.opensearch.search.aggregations.InternalAggregations;
    private int offset;  
        InternalHistogram minBoundHistogram = createHistogram(buckets, 1, -10, Double.NEGATIVE_INFINITY);
    public void testEmptyExtendedBoundsRespectMaxBuckets() {  
                name += randomAlphaOfLength(5);
            }
        // in order for reduction to work properly (and be realistic) we need to use the same interval, minDocCount, emptyBucketInfo
 * Modifications Copyright OpenSearch Contributors. See
        InternalHistogram.Bucket b = buckets.get(buckets.size() - 1);
            InternalAggregations.EMPTY
        List<InternalHistogram.Bucket> buckets = List.of(createBucket(0));
        return InternalAggregation.ReduceContext.forFinalReduction(  
        double minBound,  
import java.util.ArrayList;
        );  
        );
        newHistogram.reduce(  
            () -> histogram.reduce(List.of(histogram), createReduceContext(10, Mockito.mock(CircuitBreaker.class)))
        final double base = round(randomInt(50) - 30);
        InternalHistogram histogram = createHistogram(List.of(), 1, 0, 10);
        List<InternalHistogram.Bucket> newBuckets = new ArrayList<>(buckets.size());
import org.opensearch.core.common.breaker.CircuitBreakingException;  
        double maxBound
                minDocCount += between(1, 10);
 */  
    }
    public void testSparseBucketsRespectMaxBucketsWithoutExtendedBounds() {  
    public void testNonAdvancingKeyFails() {  
            minDocCount = randomIntBetween(1, 10);
 * GitHub history for details.
    }  
            1,  
        }
            MultiBucketConsumerService.TooManyBucketsException.class,
import org.opensearch.test.InternalAggregationTestCase;
    }  
                    (Double) bucket.getKey(),
 * license agreements. See the NOTICE file distributed with
    }
        }  
    private int minDocCount;
                expectedCounts.compute(
 * You may obtain a copy of the License at  
            if (expectedCounts.isEmpty() == false) {  
            }
                    (key, oldValue) -> (oldValue == null ? 0 : oldValue) + bucket.getDocCount()  
 * the Apache License, Version 2.0 (the "License"); you may
            double minBound = round(emptyBucketInfo.minBound);
            actualCounts.compute((Double) bucket.getKey(), (key, oldValue) -> (oldValue == null ? 0 : oldValue) + bucket.getDocCount());
        Mockito.verify(breaker, Mockito.times(1)).addEstimateBytesAndMaybeBreak(0, "allocated_buckets");  
        for (Histogram histogram : inputs) {
            List.of(histogram),  
import java.util.List;
    }
/*  
    private InternalAggregation.ReduceContext createReduceContext(int maxBuckets, CircuitBreaker breaker) {
            PipelineAggregator.PipelineTree.EMPTY
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
        expectThrows(  
    }  
        // and offset in all randomly created aggs as part of the same test run. This is particularly important when minDocCount is
        }
            }
                buckets.add(
                break;
            newBuckets.addAll(buckets.subList(0, buckets.size() - 1));  
            minBound,  
 *
                    expectedCounts.put(expectedCounts.lastKey() + interval, 0L);
        expectThrows(
                throw new AssertionError("Illegal randomisation branch");
        return new InternalHistogram(name, buckets, order, minDocCount, emptyBucketInfo, format, keyed, metadata);  
        TreeMap<Double, Long> expectedCounts = new TreeMap<>();
                        randomIntBetween(1, 100),
        );  
import org.opensearch.search.aggregations.InternalAggregation;  
    // issue 26787  
    }
        InternalHistogram histogram = createHistogram(
        for (int i = 0; i < numBuckets; ++i) {
        assertEquals(10, reduced.getBuckets().size());
    public void testHandlesNaN() {
 */  
import org.opensearch.test.InternalMultiBucketAggregationTestCase;  
import java.util.TreeMap;
    public void testOneSidedExtendedBoundsRespectMaxBuckets() {  
            null,
        }  
            case 0:  
                } else {
        BucketOrder order = BucketOrder.key(randomBoolean());
import java.util.Map;  
        List<InternalHistogram.Bucket> buckets = instance.getBuckets();  
            () -> histogram.reduce(List.of(histogram), createReduceContext(10, Mockito.mock(CircuitBreaker.class)))
        InternalHistogram histogram = createHistogram(
/*
            InternalAggregationTestCase.emptyReduceContextBuilder().forPartialReduction()
import org.mockito.Mockito;  
            IllegalArgumentException.class,
    }
                }  
            expectedCounts.entrySet().removeIf(doubleLongEntry -> doubleLongEntry.getValue() < minDocCount);  
        double minBound = 1e20;
    @Override  
        );
    }
                }
        Map<Double, Long> actualCounts = new TreeMap<>();  
            // empty buckets won't be added before the first bucket and/or after the last one  
        );  
        newBuckets.add(new InternalHistogram.Bucket(Double.NaN, b.docCount, keyed, b.format, b.aggregations));  
        expectThrows(  
        } else {
    ) {
        expectThrows(
            if (frequently()) {  
    }
    public void testNaNDoesNotBypassMaxBuckets() {
            null,
                        InternalAggregations.EMPTY
    }
        );
        Mockito.when(breaker.addEstimateBytesAndMaybeBreak(0, "allocated_buckets")).thenThrow(CircuitBreakingException.class);
    }
}
        }
    private InternalHistogram.EmptyBucketInfo emptyBucketInfo;
                        keyed,  
        keyed = randomBoolean();
        InternalHistogram.EmptyBucketInfo emptyBucketInfo = instance.emptyBucketInfo;
import java.util.HashMap;
    private double round(double key) {
                }
                break;
        );  
        InternalHistogram histogram = createHistogram(List.of(), 1, 0, 9);  
                order = BucketOrder.count(randomBoolean());
            // rarely leave some holes to be filled up with empty buckets in case minDocCount is set to 0
            MultiBucketConsumerService.TooManyBucketsException.class,
        );
import org.apache.lucene.tests.util.TestUtil;
        format = randomNumericDocValueFormat();  
    }
                double maxBound = round(emptyBucketInfo.maxBound);  
        return new InternalHistogram(name, buckets, order, minDocCount, emptyBucketInfo, format, keyed, metadata);  
            emptyBucketInfo = null;
 *
 * ownership. Elasticsearch licenses this file to you under  
            Double.POSITIVE_INFINITY,
                emptyBucketInfo = null;
        if (randomBoolean()) {  
    @Override
                expectedCounts.put(minBound, 0L);
