        InternalHistogram histogram = createHistogram(List.of(), 1, 0, 10);
            InternalAggregations.EMPTY
    // issue 26787
    }
        switch (between(0, 4)) {
        // and offset in all randomly created aggs as part of the same test run. This is particularly important when minDocCount is
import java.util.ArrayList;
import org.opensearch.core.common.breaker.CircuitBreaker;
}
        interval = randomIntBetween(1, 3);
        expectThrows(IllegalArgumentException.class, () -> histogram.nextKey(minBound));
    }
import org.opensearch.search.aggregations.BucketOrder;
                expectedCounts.put(minBound, 0L);
                throw new AssertionError("Illegal randomisation branch");
    public void testNaNDoesNotBypassMaxBuckets() {
 * GitHub history for details.
        expectThrows(
import org.opensearch.test.InternalMultiBucketAggregationTestCase;
    private int minDocCount;
            emptyBucketInfo = new InternalHistogram.EmptyBucketInfo(interval, offset, minBound, maxBound, InternalAggregations.EMPTY);
        InternalHistogram.EmptyBucketInfo bucketInfo = new InternalHistogram.EmptyBucketInfo(
        Mockito.verify(breaker, Mockito.times(1)).addEstimateBytesAndMaybeBreak(0, "allocated_buckets");
 * SPDX-License-Identifier: Apache-2.0
        );
                        randomNonNegativeLong(),
        String name = instance.getName();
        }
                    new InternalHistogram.Bucket(
                buckets = new ArrayList<>(buckets);
 *
            null,
        } else {
import org.opensearch.search.aggregations.InternalAggregation;
            IllegalArgumentException.class,
                    metadata = new HashMap<>(1);
import org.opensearch.test.InternalAggregationTestCase;
import java.util.TreeMap;
        CircuitBreaker breaker = Mockito.mock(CircuitBreaker.class);
/*
            1,
        return new InternalHistogram(name, buckets, order, minDocCount, emptyBucketInfo, format, keyed, metadata);
import org.opensearch.search.aggregations.InternalAggregations;
    }
    }
        InternalHistogram reduced = (InternalHistogram) histogram.reduce(
    private InternalHistogram.EmptyBucketInfo emptyBucketInfo;
    }
/*
            1,
                    nextKey += interval;
        // HistogramFactory#nextKey is used by pipeline aggregations and must be guarded too
        assertEquals(expectedCounts, actualCounts);
            case 1:
            minBound,
import org.mockito.Mockito;
        return new InternalHistogram(randomAlphaOfLength(5), buckets, BucketOrder.key(true), 0, bucketInfo, format, false, null);
        return ParsedHistogram.class;
            emptyBucketInfo = null;
                        InternalAggregations.EMPTY
            Double.POSITIVE_INFINITY,
    private DocValueFormat format;
        BucketOrder order = instance.getOrder();
        InternalHistogram.Bucket b = buckets.get(buckets.size() - 1);
 *    http://www.apache.org/licenses/LICENSE-2.0
                break;
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {
    private int interval;
        expectThrows(
        );
            MultiBucketConsumerService.TooManyBucketsException.class,
                while (expectedCounts.lastKey() < maxBound) {
 * under the License.
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
                break;
            new MultiBucketConsumerService.MultiBucketConsumer(maxBuckets, breaker),
        double minBound,
        for (Histogram.Bucket bucket : reduced.getBuckets()) {
 * not use this file except in compliance with the License.
    }
 */
    }
    public void testSparseBucketsRespectMaxBucketsWithoutExtendedBounds() {
 * The OpenSearch Contributors require contributions made to
        expectThrows(
                        keyed,
                minDocCount += between(1, 10);
                    (key, oldValue) -> (oldValue == null ? 0 : oldValue) + bucket.getDocCount()
                    )
                break;
        }
        );
import org.apache.lucene.tests.util.TestUtil;
        return Math.floor((key - offset) / interval) * interval + offset;
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
        final double base = round(randomInt(50) - 30);
    protected InternalHistogram createTestInstance(String name, Map<String, Object> metadata, InternalAggregations aggregations) {
import org.opensearch.search.aggregations.MultiBucketConsumerService;
    @Override
        List<InternalHistogram.Bucket> buckets = instance.getBuckets();
        for (Histogram histogram : inputs) {
    }
    }
                while (minBound < expectedCounts.firstKey()) {
                        format,
        List<InternalHistogram.Bucket> buckets,
        expectThrows(
        Map<String, Object> metadata = instance.getMetadata();
                );
            expectedCounts.entrySet().removeIf(doubleLongEntry -> doubleLongEntry.getValue() < minDocCount);
    }
import java.util.Arrays;
                );
    @Override
            null,
        double bucketInterval,
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
 */
        Mockito.when(breaker.addEstimateBytesAndMaybeBreak(0, "allocated_buckets")).thenThrow(CircuitBreakingException.class);
        List<InternalHistogram.Bucket> newBuckets = new ArrayList<>(buckets.size());
            Arrays.asList(newHistogram, histogram2),
        expectThrows(
        }
                    metadata = new HashMap<>(instance.getMetadata());
        return new InternalHistogram.Bucket(key, 1, false, format, InternalAggregations.EMPTY);
            () -> histogram.reduce(List.of(histogram), createReduceContext(10, Mockito.mock(CircuitBreaker.class)))
 * software distributed under the License is distributed on an
            case 0:
    private double round(double key) {
    private InternalHistogram createHistogram(
            newBuckets.addAll(buckets.subList(0, buckets.size() - 1));
            MultiBucketConsumerService.TooManyBucketsException.class,
                }
        }
    @Override
            double minBound = round(emptyBucketInfo.minBound);
    @Override
        List<InternalHistogram.Bucket> buckets = histogram.getBuckets();
                double maxBound = round(emptyBucketInfo.maxBound);
        InternalHistogram minBoundHistogram = createHistogram(buckets, 1, -10, Double.NEGATIVE_INFINITY);
            default:
    }
import java.util.HashMap;
                while (nextKey < expectedCounts.lastKey()) {
                break;
                final int docCount = TestUtil.nextInt(random(), 1, 50);
                    expectedCounts.put(expectedCounts.lastKey() + interval, 0L);
            () -> histogram.reduce(List.of(histogram), createReduceContext(10, Mockito.mock(CircuitBreaker.class)))
        newBuckets.add(new InternalHistogram.Bucket(Double.NaN, b.docCount, keyed, b.format, b.aggregations));
        );
 * Modifications Copyright OpenSearch Contributors. See
                }
            MultiBucketConsumerService.TooManyBucketsException.class,
import java.util.List;
            int minBound = randomInt(50) - 30;
                } else {
 * this work for additional information regarding copyright
                if (metadata == null) {
        expectThrows(
                break;
import org.opensearch.search.DocValueFormat;
        if (randomBoolean()) {
                name += randomAlphaOfLength(5);
public class InternalHistogramTests extends InternalMultiBucketAggregationTestCase<InternalHistogram> {
        InternalHistogram histogram = createTestInstance();
            case 4:
        List<InternalHistogram.Bucket> buckets = List.of(createBucket(0));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            if (frequently()) {
        // in order for reduction to work properly (and be realistic) we need to use the same interval, minDocCount, emptyBucketInfo
        InternalHistogram.EmptyBucketInfo emptyBucketInfo = instance.emptyBucketInfo;
 * compatible open source license.
                        randomIntBetween(1, 100),
                expectedCounts.compute(
            case 3:
import java.util.Map;
        if (buckets.size() > 1) {
            case 2:
package org.opensearch.search.aggregations.bucket.histogram;
        final int numBuckets = randomNumberOfBuckets();
 * KIND, either express or implied.  See the License for the
/*
            }
        format = randomNumericDocValueFormat();
        return InternalAggregation.ReduceContext.forFinalReduction(
        double minBound = 1e20;
 * this file be licensed under the Apache-2.0 license or a
            maxBound,
        } else {
        InternalHistogram histogram = createHistogram(
    protected InternalHistogram mutateInstance(InternalHistogram instance) {
            // it's ok if minBound and maxBound are outside the range of the generated buckets, that will just mean that
        // set to 0 as empty buckets need to be added to fill the holes.
        keyed = randomBoolean();
    public void testCircuitBreakerCheckedWhileAddingEmptyBuckets() {
                    expectedCounts.put(expectedCounts.firstKey() - interval, 0L);
            Double.POSITIVE_INFINITY,
                metadata.put(randomAlphaOfLength(15), randomInt());
 * You may obtain a copy of the License at
    @Override
    private InternalAggregation.ReduceContext createReduceContext(int maxBuckets, CircuitBreaker breaker) {
    }
            }
        assertEquals(10, reduced.getBuckets().size());
        InternalHistogram histogram = createHistogram(List.of(), 1, 0, 1024);
    public void testHandlesNaN() {
 * Licensed to Elasticsearch under one or more contributor
        );
    }
            // empty buckets won't be added before the first bucket and/or after the last one
        );
        InternalHistogram histogram = createHistogram(List.of(), 1, minBound, Math.nextUp(minBound));
            List.of(histogram),
    public void testOneSidedExtendedBoundsRespectMaxBuckets() {
        }
            InternalAggregationTestCase.emptyReduceContextBuilder().forPartialReduction()
        InternalHistogram maxBoundHistogram = createHistogram(buckets, 1, Double.POSITIVE_INFINITY, 10);
            for (Histogram.Bucket bucket : histogram.getBuckets()) {
import org.opensearch.core.common.breaker.CircuitBreakingException;
                emptyBucketInfo = null;
        BucketOrder order = BucketOrder.key(randomBoolean());
        InternalHistogram histogram2 = createTestInstance();
 * Unless required by applicable law or agreed to in writing,
 *
    public void testExactBucketLimit() {
        }
                buckets.add(new InternalHistogram.Bucket(base + i * interval, docCount, keyed, format, aggregations));
                }
            Double.NEGATIVE_INFINITY
 *
 */
        Map<Double, Long> actualCounts = new TreeMap<>();
            minDocCount = 0;
        offset = randomIntBetween(0, 3);
        }
                }
        for (int i = 0; i < numBuckets; ++i) {
    }
        if (minDocCount == 0) {
        double maxBound
            () -> maxBoundHistogram.reduce(List.of(maxBoundHistogram), createReduceContext(10, Mockito.mock(CircuitBreaker.class)))
            0,
    }
        if (buckets == null || buckets.isEmpty()) {
            return;
    private boolean keyed;
    protected void assertReduced(InternalHistogram reduced, List<InternalHistogram> inputs) {
        InternalHistogram newHistogram = histogram.create(newBuckets);
        List<InternalHistogram.Bucket> buckets = new ArrayList<>();
            MultiBucketConsumerService.TooManyBucketsException.class,
    public void testNonAdvancingKeyFails() {
        // Set the key of one bucket to NaN. Must be the last bucket because NaN is greater than everything else.
            }
            () -> minBoundHistogram.reduce(List.of(minBoundHistogram), createReduceContext(10, Mockito.mock(CircuitBreaker.class)))
    }
            List.of(createBucket(0), createBucket(100), createBucket(Double.NaN)),
        );
                buckets.add(
            }
        );
            actualCounts.compute((Double) bucket.getKey(), (key, oldValue) -> (oldValue == null ? 0 : oldValue) + bucket.getDocCount());
                Double nextKey = expectedCounts.firstKey();
                order = BucketOrder.count(randomBoolean());
    private int offset;
            minDocCount = randomIntBetween(1, 10);
        TreeMap<Double, Long> expectedCounts = new TreeMap<>();
            MultiBucketConsumerService.TooManyBucketsException.class,
            List.of(createBucket(0), createBucket(100)),
        }
        return new InternalHistogram(name, buckets, order, minDocCount, emptyBucketInfo, format, keyed, metadata);
        long minDocCount = instance.getMinDocCount();
            // rarely leave some holes to be filled up with empty buckets in case minDocCount is set to 0
        newHistogram.reduce(
    public void setUp() throws Exception {
    }
        );
    public void testEmptyExtendedBoundsRespectMaxBuckets() {
        );
    ) {
            () -> histogram.reduce(List.of(histogram), createReduceContext(10, Mockito.mock(CircuitBreaker.class)))
            int maxBound = randomNumberOfBuckets() * interval + randomIntBetween(0, 10);
    private InternalHistogram.Bucket createBucket(double key) {
            bucketInterval,
        InternalHistogram histogram = createHistogram(List.of(), 1, 0, 9);
            createReduceContext(10, Mockito.mock(CircuitBreaker.class))
            () -> histogram.reduce(List.of(histogram), createReduceContext(10, Mockito.mock(CircuitBreaker.class)))
 * license agreements. See the NOTICE file distributed with
        expectThrows(CircuitBreakingException.class, () -> histogram.reduce(List.of(histogram), createReduceContext(2000, breaker)));
        );
        );
            PipelineAggregator.PipelineTree.EMPTY
            Double.NEGATIVE_INFINITY
                    (Double) bucket.getKey(),
        super.setUp();
                    expectedCounts.putIfAbsent(nextKey, 0L);
 * specific language governing permissions and limitations
        InternalHistogram histogram = createHistogram(
            if (expectedCounts.isEmpty() == false) {
            if (expectedCounts.isEmpty() && emptyBucketInfo.minBound <= emptyBucketInfo.maxBound) {
