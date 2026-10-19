        // set to 0 as empty buckets need to be added to fill the holes.
                    metadata = new HashMap<>(instance.getMetadata());
            if (emptyBucketInfo.bounds != null) {
        Rounding rounding = Rounding.builder(TimeValue.timeValueMillis(1)).build();  
                buckets = new ArrayList<>(buckets);  
import org.opensearch.common.unit.TimeValue;
        LongBounds bounds,
        Rounding rounding = Rounding.builder(TimeValue.timeValueMillis(1)).build();
            bounds
        long now = System.currentTimeMillis();  
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;
        return new InternalDateHistogram(name, buckets, order, minDocCount, offset, emptyBucketInfo, format, keyed, metadata);
                    new InternalDateHistogram.Bucket(
        InternalDateHistogram reduced = (InternalDateHistogram) histogram.reduce(  
public class InternalDateHistogramTests extends InternalMultiBucketAggregationTestCase<InternalDateHistogram> {
    @Override
 *
    }
        for (int i = 0; i < nbBuckets; i++) {
        List<InternalDateHistogram.Bucket> buckets = new ArrayList<>(nbBuckets);
    @Override
                break;
        );
            format,
        InternalDateHistogram histogram = createHistogram(List.of(), rounding, new LongBounds(min, max), 0);
            LongBounds extendedBounds = null;
 * ownership. Elasticsearch licenses this file to you under  
        int nbBuckets = randomNumberOfBuckets();  
        long min = ZonedDateTime.parse("2020-01-01T00:00:00Z").toInstant().toEpochMilli();
 */  
            new MultiBucketConsumerService.MultiBucketConsumer(maxBuckets, breaker),  
            false,
    public void testEmptyExtendedBoundsRespectMaxBuckets() {  
    private InternalDateHistogram.Bucket createBucket(long key) {
        if (minDocCount == 0) {
 * license agreements. See the NOTICE file distributed with
        InternalDateHistogram.EmptyBucketInfo emptyBucketInfo = instance.emptyBucketInfo;
            () -> histogram.reduce(List.of(histogram), createReduceContext(12, Mockito.mock(CircuitBreaker.class)))
            }
 * under the License.  
        expectThrows(
        switch (between(0, 5)) {
                    nextKey += intervalMillis;
            }
        assertEquals(expectedCounts, actualCounts);
        }
        }
            if (frequently()) {  
    private InternalAggregation.ReduceContext createReduceContext(int maxBuckets, CircuitBreaker breaker) {
 * specific language governing permissions and limitations
    }  
        for (Histogram histogram : inputs) {
    }  
            );  
        List<InternalDateHistogram.Bucket> buckets = instance.getBuckets();
        }  
    protected void assertReduced(InternalDateHistogram reduced, List<InternalDateHistogram> inputs) {  
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
            expectedCounts.entrySet().removeIf(doubleLongEntry -> doubleLongEntry.getValue() < minDocCount);
                }
        for (Histogram.Bucket bucket : reduced.getBuckets()) {
                        InternalAggregations.EMPTY
                if (emptyBucketInfo.bounds != null) {  
 * GitHub history for details.
            randomAlphaOfLength(5),
        Rounding rounding = Rounding.builder(TimeValue.timeValueMillis(intervalMillis)).build();
            InternalAggregations.EMPTY,  
 * KIND, either express or implied.  See the License for the
            minDocCount = randomIntBetween(1, 10);  
            default:
        InternalDateHistogram histogram = createHistogram(List.of(), rounding, new LongBounds(Long.MAX_VALUE - 2, Long.MAX_VALUE), 1);
    @Override
                }
    public void testOneSidedExtendedBoundsRespectMaxBuckets() {
    }
                if (metadata == null) {
        expectThrows(
                    (key, oldValue) -> (oldValue == null ? 0 : oldValue) + bucket.getDocCount()  
            bucketInfo,  
    private long baseMillis;  
            case 2:
        }
    private DocValueFormat format;
import org.opensearch.core.common.breaker.CircuitBreakingException;
                name += randomAlphaOfLength(5);  
                emptyBucketInfo = null;
        BucketOrder order = BucketOrder.key(randomBoolean());
        expectThrows(CircuitBreakingException.class, () -> histogram.reduce(List.of(histogram), createReduceContext(2000, breaker)));  
                minBound = prepared.round(emptyBucketInfo.bounds.getMin());  
            }  
    public void testCircuitBreakerCheckedWhileAddingEmptyBuckets() {  
    private long minDocCount;
            case 1:
            MultiBucketConsumerService.TooManyBucketsException.class,
            case 3:
                }
                break;
                maxBound = prepared.round(emptyBucketInfo.bounds.getMax());
    }
    protected InternalDateHistogram mutateInstance(InternalDateHistogram instance) {
                if (expectedCounts.isEmpty() && minBound <= maxBound) {
                );
 * The OpenSearch Contributors require contributions made to  
            MultiBucketConsumerService.TooManyBucketsException.class,  
            if (expectedCounts.isEmpty() == false) {  
                while (nextKey < expectedCounts.lastKey()) {
import static org.opensearch.common.unit.TimeValue.timeValueHours;  
import java.time.ZonedDateTime;  
            PipelineAggregator.PipelineTree.EMPTY
 * this file be licensed under the Apache-2.0 license or a
                    }  
        intervalMillis = randomFrom(timeValueSeconds(interval), timeValueMinutes(interval), timeValueHours(interval)).getMillis();
        return new InternalDateHistogram(name, buckets, order, minDocCount, 0L, emptyBucketInfo, format, keyed, metadata);  
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {  
    }  
        return new InternalDateHistogram.Bucket(key, 1, false, format, InternalAggregations.EMPTY);
            IllegalArgumentException.class,
            () -> minBoundHistogram.reduce(List.of(minBoundHistogram), createReduceContext(10, Mockito.mock(CircuitBreaker.class)))  
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
                }
                        keyed,
    ) {  
            }
        List<InternalDateHistogram.Bucket> buckets = List.of(createBucket(0));  
        );
            0,
                    while (expectedCounts.lastKey() < maxBound) {
import java.util.Map;
    }  
        TreeMap<Long, Long> expectedCounts = new TreeMap<>();
                );  
import java.util.ArrayList;
 */
}
    private long intervalMillis;
import org.opensearch.search.aggregations.MultiBucketConsumerService;  
            actualCounts.compute(  
                    expectedCounts.putIfAbsent(nextKey, 0L);  
        );
        CircuitBreaker breaker = Mockito.mock(CircuitBreaker.class);
        Rounding rounding = Rounding.builder(TimeValue.timeValueMillis(1)).build();
            MultiBucketConsumerService.TooManyBucketsException.class,
                expectedCounts.compute(
                        expectedCounts.put(expectedCounts.lastKey() + intervalMillis, 0L);
    }
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
        );
        return ParsedDateHistogram.class;
            emptyBucketInfo = new InternalDateHistogram.EmptyBucketInfo(rounding, InternalAggregations.EMPTY, extendedBounds);  
        super.setUp();  
        Rounding rounding = Rounding.builder(Rounding.DateTimeUnit.MONTH_OF_YEAR).timeZone(ZoneOffset.UTC).build();
        InternalDateHistogram histogram = createHistogram(List.of(), rounding, new LongBounds(0L, 1024L), 0);
    public void setUp() throws Exception {
                break;
 * Licensed to Elasticsearch under one or more contributor  
            if (randomBoolean()) {
                );
                    expectedCounts.put(minBound, 0L);  
/*
 */  
import java.time.ZoneOffset;
import static org.opensearch.common.unit.TimeValue.timeValueMinutes;
            null,
                buckets.add(
import org.opensearch.search.aggregations.InternalAggregation;
        long minDocCount = instance.getMinDocCount();  
            MultiBucketConsumerService.TooManyBucketsException.class,
            () -> histogram.reduce(List.of(histogram), createReduceContext(10, Mockito.mock(CircuitBreaker.class)))  
 * Modifications Copyright OpenSearch Contributors. See
        );  
        Rounding rounding = Rounding.builder(TimeValue.timeValueMillis(1)).build();
                        expectedCounts.put(expectedCounts.firstKey() - intervalMillis, 0L);
    public void testBucketKeyOverflowFails() {  
        // and base in all randomly created aggs as part of the same test run. This is particularly important when minDocCount is
        if (randomBoolean()) {
                minDocCount += between(1, 10);  
        InternalDateHistogram histogram = createHistogram(List.of(), rounding, new LongBounds(0L, 10L), 0);
    }
        Map<String, Object> metadata = instance.getMetadata();  
 * the Apache License, Version 2.0 (the "License"); you may
        long interval = randomIntBetween(1, 3);  
import org.opensearch.search.aggregations.BucketOrder;  
            createReduceContext(13, Mockito.mock(CircuitBreaker.class))
import org.mockito.Mockito;
            minDocCount = 0;  
        );
    private boolean keyed;  
                ((ZonedDateTime) bucket.getKey()).toInstant().toEpochMilli(),
        BucketOrder order = instance.getOrder();
                break;
        Rounding rounding = Rounding.builder(TimeValue.timeValueMillis(1)).build();  
import org.opensearch.search.DocValueFormat;
                metadata.put(randomAlphaOfLength(15), randomInt());  
                        format,  
                    }  
import java.util.HashMap;
        } else {
                break;
    private InternalDateHistogram.EmptyBucketInfo emptyBucketInfo;
            long minBound = -1;
                    while (minBound < expectedCounts.firstKey()) {
            case 0:
            rounding,
                extendedBounds = new LongBounds(min, max);
            // rarely leave some holes to be filled up with empty buckets in case minDocCount is set to 0
        Map<Long, Long> actualCounts = new TreeMap<>();
    protected InternalDateHistogram createTestInstance(String name, Map<String, Object> metadata, InternalAggregations aggregations) {
        );
            List.of(histogram),
        assertEquals(13, reduced.getBuckets().size());
    @Override
        return InternalAggregation.ReduceContext.forFinalReduction(  
            for (Histogram.Bucket bucket : histogram.getBuckets()) {  
    }
            case 5:  
        long startingDate = baseMillis - intervalMillis * randomNumberOfBuckets();  
import org.opensearch.test.InternalMultiBucketAggregationTestCase;  
            }
                Long nextKey = expectedCounts.firstKey();
        format = randomNumericDocValueFormat();
        } else {  
            buckets,
    @Override
        }
                (key, oldValue) -> (oldValue == null ? 0 : oldValue) + bucket.getDocCount()
        List<InternalDateHistogram.Bucket> buckets,
        InternalDateHistogram maxBoundHistogram = createHistogram(buckets, rounding, new LongBounds(null, 10L), 0);
        // in order for reduction to work properly (and be realistic) we need to use the same interval, minDocCount, emptyBucketInfo  
/*  
        expectThrows(
 * You may obtain a copy of the License at  
        long max = ZonedDateTime.parse("2021-01-01T00:00:00Z").toInstant().toEpochMilli();  
 *
            null  
        InternalDateHistogram histogram = createHistogram(List.of(createBucket(0), createBucket(100)), rounding, null, 0);
                        randomNonNegativeLong(),  
            emptyBucketInfo = null;
 *  
        String name = instance.getName();  
        return new InternalDateHistogram(  
        // HistogramFactory#nextKey is used by pipeline aggregations and must be guarded too
            () -> histogram.reduce(List.of(histogram), createReduceContext(10, Mockito.mock(CircuitBreaker.class)))
                    ((ZonedDateTime) bucket.getKey()).toInstant().toEpochMilli(),
        InternalDateHistogram.EmptyBucketInfo bucketInfo = new InternalDateHistogram.EmptyBucketInfo(
        baseMillis = rounding.prepare(now, now).round(now);
 * compatible open source license.
    private InternalDateHistogram createHistogram(
                    emptyBucketInfo.bounds.getMin(),  
                break;
        );  
        expectThrows(  
    }  
        keyed = randomBoolean();
        // avoid having different random instance start from exactly the same base
import org.opensearch.common.Rounding;
                long min = baseMillis - intervalMillis * randomNumberOfBuckets();
    public void testSparseBucketsRespectMaxBucketsWithoutExtendedBounds() {
                long key = startingDate + intervalMillis * i;
                    emptyBucketInfo.bounds.getMax()
/*  
            long maxBound = -1;  
            case 4:  
    }
            null,
        long histogramOffset
 * Unless required by applicable law or agreed to in writing,
            () -> histogram.reduce(List.of(histogram), createReduceContext(10, Mockito.mock(CircuitBreaker.class)))  
import java.util.List;  
                Rounding.Prepared prepared = emptyBucketInfo.rounding.prepare(
        Rounding rounding,  
            histogramOffset,
    public void testCalendarIntervalExactBucketLimit() {  
            BucketOrder.key(true),  
import org.opensearch.core.common.breaker.CircuitBreaker;  
                // empty buckets won't be added before the first bucket and/or after the last one
        );  
                // it's ok if min and max are outside the range of the generated buckets, that will just mean that  
        InternalDateHistogram minBoundHistogram = createHistogram(buckets, rounding, new LongBounds(-10L, null), 0);
                        randomIntBetween(1, 100),
            () -> maxBoundHistogram.reduce(List.of(maxBoundHistogram), createReduceContext(10, Mockito.mock(CircuitBreaker.class)))
                long max = baseMillis + randomNumberOfBuckets() * intervalMillis;  
            MultiBucketConsumerService.TooManyBucketsException.class,
import org.opensearch.search.aggregations.InternalAggregations;
        Mockito.verify(breaker, Mockito.times(1)).addEstimateBytesAndMaybeBreak(0, "allocated_buckets");
        Mockito.when(breaker.addEstimateBytesAndMaybeBreak(0, "allocated_buckets")).thenThrow(CircuitBreakingException.class);
                } else {  
                offset += between(1, 20);
                    )
package org.opensearch.search.aggregations.bucket.histogram;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
                    metadata = new HashMap<>(1);
        expectThrows(  
                order = BucketOrder.count(randomBoolean());  
        long offset = instance.getOffset();
    }
        expectThrows(IllegalArgumentException.class, () -> histogram.nextKey(Long.MAX_VALUE));  
    }
        );
 * not use this file except in compliance with the License.
        expectThrows(
                throw new AssertionError("Illegal randomisation branch");  
import java.util.TreeMap;
                buckets.add(new InternalDateHistogram.Bucket(key, randomIntBetween(1, 100), keyed, format, aggregations));
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
