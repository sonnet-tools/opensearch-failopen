        Rounding rounding = Rounding.builder(TimeValue.timeValueMillis(1)).build();
        }
        baseMillis = rounding.prepare(now, now).round(now);
                minDocCount += between(1, 10);
                    (key, oldValue) -> (oldValue == null ? 0 : oldValue) + bucket.getDocCount()
    }
        Rounding rounding = Rounding.builder(TimeValue.timeValueMillis(1)).build();
                // empty buckets won't be added before the first bucket and/or after the last one
                    nextKey += intervalMillis;
        expectThrows(CircuitBreakingException.class, () -> histogram.reduce(List.of(histogram), createReduceContext(2000, breaker)));
/*
 */
    private DocValueFormat format;
                long key = startingDate + intervalMillis * i;
 * this work for additional information regarding copyright
            randomAlphaOfLength(5),
    }
        Rounding rounding = Rounding.builder(Rounding.DateTimeUnit.MONTH_OF_YEAR).timeZone(ZoneOffset.UTC).build();
            InternalAggregations.EMPTY,
    public void testCircuitBreakerCheckedWhileAddingEmptyBuckets() {
    }
                    emptyBucketInfo.bounds.getMin(),
 *
        expectThrows(
        // set to 0 as empty buckets need to be added to fill the holes.
            emptyBucketInfo = new InternalDateHistogram.EmptyBucketInfo(rounding, InternalAggregations.EMPTY, extendedBounds);
 */
                long max = baseMillis + randomNumberOfBuckets() * intervalMillis;
    public void testBucketKeyOverflowFails() {
 * compatible open source license.
    }
                    }
    public void testSparseBucketsRespectMaxBucketsWithoutExtendedBounds() {
                );
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;
        BucketOrder order = instance.getOrder();
            IllegalArgumentException.class,
            long minBound = -1;
            }
    private long intervalMillis;
        }
                break;
        List<InternalDateHistogram.Bucket> buckets,
        expectThrows(
    private long minDocCount;
            rounding,
        Mockito.when(breaker.addEstimateBytesAndMaybeBreak(0, "allocated_buckets")).thenThrow(CircuitBreakingException.class);
            bounds
import static org.opensearch.common.unit.TimeValue.timeValueMinutes;
            if (randomBoolean()) {
        // in order for reduction to work properly (and be realistic) we need to use the same interval, minDocCount, emptyBucketInfo
        for (Histogram.Bucket bucket : reduced.getBuckets()) {
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {
        Map<String, Object> metadata = instance.getMetadata();
        Rounding rounding = Rounding.builder(TimeValue.timeValueMillis(1)).build();
                    }
 * this file be licensed under the Apache-2.0 license or a
        InternalDateHistogram histogram = createHistogram(List.of(), rounding, new LongBounds(0L, 1024L), 0);
            () -> minBoundHistogram.reduce(List.of(minBoundHistogram), createReduceContext(10, Mockito.mock(CircuitBreaker.class)))
                    while (expectedCounts.lastKey() < maxBound) {
            actualCounts.compute(
        InternalDateHistogram reduced = (InternalDateHistogram) histogram.reduce(
        List<InternalDateHistogram.Bucket> buckets = List.of(createBucket(0));
        intervalMillis = randomFrom(timeValueSeconds(interval), timeValueMinutes(interval), timeValueHours(interval)).getMillis();
    }
        if (randomBoolean()) {
    public void testCalendarIntervalExactBucketLimit() {
                } else {
 */
            MultiBucketConsumerService.TooManyBucketsException.class,
            MultiBucketConsumerService.TooManyBucketsException.class,
                    metadata = new HashMap<>(instance.getMetadata());
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
import java.util.List;
                break;
        // HistogramFactory#nextKey is used by pipeline aggregations and must be guarded too
                        randomNonNegativeLong(),
        long max = ZonedDateTime.parse("2021-01-01T00:00:00Z").toInstant().toEpochMilli();
        Rounding rounding = Rounding.builder(TimeValue.timeValueMillis(intervalMillis)).build();
    public void testOneSidedExtendedBoundsRespectMaxBuckets() {
 * license agreements. See the NOTICE file distributed with
        // avoid having different random instance start from exactly the same base
            () -> maxBoundHistogram.reduce(List.of(maxBoundHistogram), createReduceContext(10, Mockito.mock(CircuitBreaker.class)))
    }
        InternalDateHistogram histogram = createHistogram(List.of(), rounding, new LongBounds(min, max), 0);
        );
                        expectedCounts.put(expectedCounts.firstKey() - intervalMillis, 0L);
            List.of(histogram),
        );
        InternalDateHistogram maxBoundHistogram = createHistogram(buckets, rounding, new LongBounds(null, 10L), 0);
                expectedCounts.compute(
                    expectedCounts.putIfAbsent(nextKey, 0L);
            null,
        }
        List<InternalDateHistogram.Bucket> buckets = instance.getBuckets();
                        expectedCounts.put(expectedCounts.lastKey() + intervalMillis, 0L);
            }
    ) {
            null
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
    protected InternalDateHistogram mutateInstance(InternalDateHistogram instance) {
import org.opensearch.search.aggregations.InternalAggregation;
 * software distributed under the License is distributed on an
import org.mockito.Mockito;
 *
                long min = baseMillis - intervalMillis * randomNumberOfBuckets();
        switch (between(0, 5)) {
                    while (minBound < expectedCounts.firstKey()) {
                );
}
import org.opensearch.search.aggregations.MultiBucketConsumerService;
            MultiBucketConsumerService.TooManyBucketsException.class,
            MultiBucketConsumerService.TooManyBucketsException.class,
        List<InternalDateHistogram.Bucket> buckets = new ArrayList<>(nbBuckets);
        Rounding rounding = Rounding.builder(TimeValue.timeValueMillis(1)).build();
package org.opensearch.search.aggregations.bucket.histogram;
        return new InternalDateHistogram.Bucket(key, 1, false, format, InternalAggregations.EMPTY);
        );
        );
        return new InternalDateHistogram(name, buckets, order, minDocCount, 0L, emptyBucketInfo, format, keyed, metadata);
import org.opensearch.search.aggregations.BucketOrder;
            case 5:
                break;
        expectThrows(
        expectThrows(IllegalArgumentException.class, () -> histogram.nextKey(Long.MAX_VALUE));
        }
                    )
    }
    private boolean keyed;
            MultiBucketConsumerService.TooManyBucketsException.class,
    }
 * SPDX-License-Identifier: Apache-2.0
        super.setUp();
                }
            minDocCount = randomIntBetween(1, 10);
                }
        }
        InternalDateHistogram histogram = createHistogram(List.of(), rounding, new LongBounds(0L, 10L), 0);
                    expectedCounts.put(minBound, 0L);
            long maxBound = -1;
        InternalDateHistogram minBoundHistogram = createHistogram(buckets, rounding, new LongBounds(-10L, null), 0);
        return new InternalDateHistogram(name, buckets, order, minDocCount, offset, emptyBucketInfo, format, keyed, metadata);
            if (frequently()) {
                break;
        assertEquals(13, reduced.getBuckets().size());
                offset += between(1, 20);
            emptyBucketInfo = null;
            () -> histogram.reduce(List.of(histogram), createReduceContext(10, Mockito.mock(CircuitBreaker.class)))
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor
    }
                Long nextKey = expectedCounts.firstKey();
            }
            false,
            for (Histogram.Bucket bucket : histogram.getBuckets()) {
import org.opensearch.common.unit.TimeValue;
    private InternalDateHistogram.EmptyBucketInfo emptyBucketInfo;
                buckets = new ArrayList<>(buckets);
                break;
        );
        int nbBuckets = randomNumberOfBuckets();
            case 3:
                metadata.put(randomAlphaOfLength(15), randomInt());
            0,
            }
    private long baseMillis;
            () -> histogram.reduce(List.of(histogram), createReduceContext(10, Mockito.mock(CircuitBreaker.class)))
                }
                while (nextKey < expectedCounts.lastKey()) {
import org.opensearch.common.Rounding;
        keyed = randomBoolean();
        expectThrows(
                        randomIntBetween(1, 100),
            expectedCounts.entrySet().removeIf(doubleLongEntry -> doubleLongEntry.getValue() < minDocCount);
            case 4:
import org.opensearch.search.aggregations.InternalAggregations;
        }
                extendedBounds = new LongBounds(min, max);
                Rounding.Prepared prepared = emptyBucketInfo.rounding.prepare(
            bucketInfo,
        );
    }
import org.opensearch.core.common.breaker.CircuitBreakingException;
            if (emptyBucketInfo.bounds != null) {
            histogramOffset,
                );
 * the Apache License, Version 2.0 (the "License"); you may
                    metadata = new HashMap<>(1);
 * not use this file except in compliance with the License.
 *
                    emptyBucketInfo.bounds.getMax()
        return InternalAggregation.ReduceContext.forFinalReduction(
        );
    @Override
        return new InternalDateHistogram(
                        InternalAggregations.EMPTY
        } else {
import java.util.HashMap;
                    ((ZonedDateTime) bucket.getKey()).toInstant().toEpochMilli(),
    private InternalDateHistogram createHistogram(
        LongBounds bounds,
                emptyBucketInfo = null;
        InternalDateHistogram histogram = createHistogram(List.of(createBucket(0), createBucket(100)), rounding, null, 0);
                minBound = prepared.round(emptyBucketInfo.bounds.getMin());
    }
 * You may obtain a copy of the License at
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                // it's ok if min and max are outside the range of the generated buckets, that will just mean that
                buckets.add(new InternalDateHistogram.Bucket(key, randomIntBetween(1, 100), keyed, format, aggregations));
        assertEquals(expectedCounts, actualCounts);
import org.opensearch.test.InternalMultiBucketAggregationTestCase;
        Rounding rounding,
import org.opensearch.search.DocValueFormat;
        } else {
            BucketOrder.key(true),
 * Modifications Copyright OpenSearch Contributors. See
            case 2:
        if (minDocCount == 0) {
            default:
                buckets.add(
        format = randomNumericDocValueFormat();
        long offset = instance.getOffset();
                if (metadata == null) {
        InternalDateHistogram.EmptyBucketInfo emptyBucketInfo = instance.emptyBucketInfo;
import java.util.ArrayList;
        long startingDate = baseMillis - intervalMillis * randomNumberOfBuckets();
            () -> histogram.reduce(List.of(histogram), createReduceContext(12, Mockito.mock(CircuitBreaker.class)))
                if (emptyBucketInfo.bounds != null) {
        Mockito.verify(breaker, Mockito.times(1)).addEstimateBytesAndMaybeBreak(0, "allocated_buckets");
                order = BucketOrder.count(randomBoolean());
            }
    @Override
        TreeMap<Long, Long> expectedCounts = new TreeMap<>();
                    new InternalDateHistogram.Bucket(
        for (Histogram histogram : inputs) {
    protected InternalDateHistogram createTestInstance(String name, Map<String, Object> metadata, InternalAggregations aggregations) {
    private InternalDateHistogram.Bucket createBucket(long key) {
            case 0:
                }
                ((ZonedDateTime) bucket.getKey()).toInstant().toEpochMilli(),
            buckets,
        );
 * specific language governing permissions and limitations
                maxBound = prepared.round(emptyBucketInfo.bounds.getMax());
                name += randomAlphaOfLength(5);
            // rarely leave some holes to be filled up with empty buckets in case minDocCount is set to 0
        // and base in all randomly created aggs as part of the same test run. This is particularly important when minDocCount is
 * The OpenSearch Contributors require contributions made to
    }
public class InternalDateHistogramTests extends InternalMultiBucketAggregationTestCase<InternalDateHistogram> {
        Map<Long, Long> actualCounts = new TreeMap<>();
    @Override
    @Override
        );
            format,
import java.util.Map;
                        format,
        long minDocCount = instance.getMinDocCount();
import java.time.ZoneOffset;
import static org.opensearch.common.unit.TimeValue.timeValueHours;
        expectThrows(
 *    http://www.apache.org/licenses/LICENSE-2.0
                break;
        );
        String name = instance.getName();
import java.util.TreeMap;
    protected void assertReduced(InternalDateHistogram reduced, List<InternalDateHistogram> inputs) {
                if (expectedCounts.isEmpty() && minBound <= maxBound) {
 * KIND, either express or implied.  See the License for the
    @Override
 * ownership. Elasticsearch licenses this file to you under
                (key, oldValue) -> (oldValue == null ? 0 : oldValue) + bucket.getDocCount()
/*
/*
        Rounding rounding = Rounding.builder(TimeValue.timeValueMillis(1)).build();
 * GitHub history for details.
        long interval = randomIntBetween(1, 3);
        InternalDateHistogram histogram = createHistogram(List.of(), rounding, new LongBounds(Long.MAX_VALUE - 2, Long.MAX_VALUE), 1);
            minDocCount = 0;
    }
        expectThrows(
        long now = System.currentTimeMillis();
import org.opensearch.core.common.breaker.CircuitBreaker;
            () -> histogram.reduce(List.of(histogram), createReduceContext(10, Mockito.mock(CircuitBreaker.class)))
            LongBounds extendedBounds = null;
    }
            if (expectedCounts.isEmpty() == false) {
            new MultiBucketConsumerService.MultiBucketConsumer(maxBuckets, breaker),
                throw new AssertionError("Illegal randomisation branch");
        InternalDateHistogram.EmptyBucketInfo bucketInfo = new InternalDateHistogram.EmptyBucketInfo(
        BucketOrder order = BucketOrder.key(randomBoolean());
        CircuitBreaker breaker = Mockito.mock(CircuitBreaker.class);
        long histogramOffset
    private InternalAggregation.ReduceContext createReduceContext(int maxBuckets, CircuitBreaker breaker) {
            case 1:
        for (int i = 0; i < nbBuckets; i++) {
            PipelineAggregator.PipelineTree.EMPTY
            );
    public void setUp() throws Exception {
            null,
            createReduceContext(13, Mockito.mock(CircuitBreaker.class))
                        keyed,
        long min = ZonedDateTime.parse("2020-01-01T00:00:00Z").toInstant().toEpochMilli();
import java.time.ZonedDateTime;
    public void testEmptyExtendedBoundsRespectMaxBuckets() {
        return ParsedDateHistogram.class;
 * under the License.
