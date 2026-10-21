            case 2:
 *
 * license agreements. See the NOTICE file distributed with
            roundings,
    protected void assertReduced(InternalAutoDateHistogram reduced, List<InternalAutoDateHistogram> inputs) {
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
        );
import java.util.List;
        for (Histogram.Bucket bucket : reduced.getBuckets()) {
                    }
        }
        InternalAutoDateHistogram h = new ReduceTestBuilder(10).bucket("1970-01-01T00:00:00", 1)
        assertThat(copy.getInterval(), equalTo(orig.getInterval()));
            .bucket("1970-01-01T00:02:00", 1)
            .bucket("1970-01-01T00:00:04", 1)
        assertThat(copy.getName(), equalTo(orig.getName()));
            .bucket("1970-01-01T00:00:30", 1)
                // Iterate through the input buckets, and for each bucket, determine if it's inside
        ZoneId timeZone = ZoneOffset.UTC;
                    "1970-01-01T00:00:30Z",
        assertThat(docCounts(h), equalTo(Arrays.asList(3, 1)));
 * ownership. Elasticsearch licenses this file to you under
            noInterval.getFormatter(),
            .bucket("1970-01-01T00:00:02", 1)
        long key = prepared.round(min);
    private int getBucketCount(long min, long max, Rounding.Prepared prepared, int interval) {
 * this file be licensed under the Apache-2.0 license or a
            aggregations,
                    roundingIdx = i;
            .finishShardResult("s", 1)
            for (int i = 0; i < interval; i++) {
import org.opensearch.index.mapper.DateFieldMapper;
            .finishShardResult("s", 1)
            thisResultStart += usually() ? 0 : randomFrom(TimeUnit.MINUTES, TimeUnit.HOURS, TimeUnit.DAYS).toMillis(between(1, 10000));
                if (roundings[i].unitAbbreviation.equals(whichRounding)) {
 * Licensed to Elasticsearch under one or more contributor
            long thisResultStart = startingDate;
            .bucket("1970-01-01T00:00:02", 1)
        return DateFormatter.forPattern("date_optional_time").parseMillis(time);
            roundingInfos,
            DateFieldMapper.Resolution.MILLISECONDS
import java.util.concurrent.TimeUnit;
package org.opensearch.search.aggregations.bucket.histogram;
    protected InternalAutoDateHistogram createTestInstance(
        roundings[0] = new RoundingInfo(Rounding.DateTimeUnit.SECOND_OF_MINUTE, timeZone, 1000L, "s", 1000);
                long nextKey = keyForBucket;
                }
        return h.getBuckets().stream().map(b -> (int) b.getDocCount()).collect(toList());
            noInterval.getName(),
                if (bucketKey > highest) {
        assertThat(reduced.getInterval(), equalTo(expectedInterval));
        }
                new InternalAutoDateHistogram(
import java.util.Map;
            .reduce();
import java.time.ZoneOffset;
        assertThat(copy.getFormatter(), equalTo(orig.getFormatter()));
        List<InternalAutoDateHistogram> result = new ArrayList<>(size);
            do {
            equalTo(
        RoundingInfo roundingInfo = AutoDateHistogramAggregationBuilder.buildRoundings(null, null)[roundingIndex];
        RoundingInfo[] roundingInfos = AutoDateHistogramAggregationBuilder.buildRoundings(null, null);
                throw new AssertionError("Illegal randomisation branch");
        int nbBuckets = randomNumberOfBuckets();
         * Next pick smaller intervals until we find the one that makes the right
        List<InternalAutoDateHistogram.Bucket> buckets = instance.getBuckets();
        );
    private static long utcMillis(String time) {
            keys(h),
        assertThat(keys(h), equalTo(Arrays.asList("1970-01-01T00:00:00Z", "1970-01-01T00:00:05Z")));
            equalTo(Arrays.asList("1970-01-01T00:00:01Z", "1970-01-01T00:00:02Z", "1970-01-01T00:00:03Z", "1970-01-01T00:00:04Z"))
    protected InternalAutoDateHistogram createTestInstance(String name, Map<String, Object> metadata, InternalAggregations aggregations) {
                    )
                        InternalAggregations.EMPTY
                }
            .finishShardResult("s", 5)
            .reduce();
 *
        if (totalBucketConut > 0) {
        long normalizedDuration = (highest - lowest) / roundingInfo.getRoughEstimateDurationMillis();
                        }
        assertThat(docCounts(h), equalTo(Arrays.asList(3, 1)));
            .finishShardResult("s", 1)
/*
        }
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {
        assertThat(docCounts(h), equalTo(Arrays.asList(1, 2, 1, 0, 1)));
                    for (Histogram.Bucket bucket : histogram.getBuckets()) {
        InternalAutoDateHistogram orig = new InternalAutoDateHistogram(
    public void testReduceBumpsRounding() {
                keyForBucket = nextKey;
 */
            for (int i = 0; i < roundings.length; i++) {
        int result = InternalAutoDateHistogram.getAppropriateRounding(
            BucketInfo bucketInfo = new BucketInfo(roundings, roundingIdx, InternalAggregations.EMPTY);
        private final List<InternalAggregation> results = new ArrayList<>();
            .bucket("1970-01-01T00:01:00", 1)
         * duration. It'll be accurate or it'll produce more buckets
            long keyForBucket = prepared.round(lowest);
        Map<String, Object> metadata,
        if (totalBucketConut == 0) {
        for (InternalAutoDateHistogram histogram : inputs) {
            buckets.add(new InternalAutoDateHistogram.Bucket(utcMillis(key), docCount, FORMAT, InternalAggregations.EMPTY));
        InternalAutoDateHistogram h = new ReduceTestBuilder(2).bucket("1970-01-01T00:00:01", 1)
                    innerInterval
        roundings[2] = new RoundingInfo(Rounding.DateTimeUnit.HOUR_OF_DAY, timeZone, 60 * 60 * 1000L, "h", 1, 3, 12);
 * Unless required by applicable law or agreed to in writing,
                (key, oldValue) -> (oldValue == null ? 0 : oldValue) + bucket.getDocCount()
        DocValueFormat format
            .reduce();
            }
            keys(h),
        // to increment the rounding (because the bug was that the function would not use the innerIntervals
            .bucket("1970-01-01T00:00:00", 1)
        // pick out the actual reduced values to the make the assertion more readable
 * KIND, either express or implied.  See the License for the
            RoundingInfo roundings[] = AutoDateHistogramAggregationBuilder.buildRoundings(ZoneOffset.UTC, null);
        BucketInfo bucketInfo = new BucketInfo(roundingInfos, roundingIndex, InternalAggregations.EMPTY);
            expectedInterval = new DateHistogramInterval(innerIntervalToUse + roundingInfo.unitAbbreviation);
        return new InternalAutoDateHistogram(name, buckets, targetBuckets, bucketInfo, format, metadata, 1);
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.search.aggregations.InternalAggregation;
 */
     * passed in, instead of using the interval associated with the loop.
        InternalAutoDateHistogram reduce() {
                    "1970-01-01T00:00:00Z",
    }
                    new InternalAutoDateHistogram.Bucket(
            actualCounts.compute(
    }
            int roundingIdx = -1;
/*
                        long roundedBucketKey = prepared.round(((ZonedDateTime) bucket.getKey()).toInstant().toEpochMilli());
            }
import org.opensearch.search.aggregations.InternalAggregations;
    }
public class InternalAutoDateHistogramTests extends InternalMultiBucketAggregationTestCase<InternalAutoDateHistogram> {
            .bucket("1970-01-01T00:00:30", 1)
    ) {
        long lowest = Long.MAX_VALUE;
            default:
        assertThat(copy.getTargetBuckets(), equalTo(orig.getTargetBuckets()));
 * GitHub history for details.
        InternalAutoDateHistogram h = new ReduceTestBuilder(2).bucket("1970-01-01T00:00:01", 1)
        int innerIntervalIndex = 0;
            .bucket("1970-01-01T00:00:02", 1)
import java.util.Arrays;
        String name = instance.getName();
                } else {
        assertThat(
        for (int i = 0; i < size; i++) {
                break;
        for (int i = 0; i < nbBuckets; i++) {
 * under the License.
                name += randomAlphaOfLength(5);
        /*
            for (Histogram.Bucket bucket : histogram.getBuckets()) {
import java.util.ArrayList;
         */
                metadata.put(randomAlphaOfLength(15), randomInt());
        private static final DocValueFormat FORMAT = new DocValueFormat.DateTime(
                if (normalizedDuration / interval < reduced.getBuckets().size()) {
        );
    }
        }
            .bucket("1970-01-01T00:01:00", 1)
    @Override
            } while (++innerIntervalIndex < roundingInfo.innerIntervals.length);
        );
        Rounding.Prepared prepared = totalBucketConut > 0 ? roundingInfo.rounding.prepare(lowest, highest) : null;
    }
                    targetBuckets,
                    innerIntervalIndex = j;
            name,
            DateFormatter.forPattern("date_time_no_millis"),
                    metadata = new HashMap<>(1);
                break;
        assertEquals(expectedCounts, actualCounts);
        ReduceTestBuilder(int targetBuckets) {
        }
            case 3:
        } else {
        int bucketCount = 0;
                    lowest = bucketKey;
    }
        // We want to pass a roundingIdx of zero, because in order to reproduce this bug, we need the function
        return h.getBuckets().stream().map(InternalAutoDateHistogram.Bucket::getKeyAsString).collect(toList());
        roundings[1] = new RoundingInfo(Rounding.DateTimeUnit.MINUTES_OF_HOUR, timeZone, 60 * 1000L, "m", 1, 5, 10, 30);
                int roundingIdx = bucketInfo.roundingIdx == bucketInfo.roundingInfos.length - 1 ? 0 : bucketInfo.roundingIdx + 1;
import org.opensearch.search.aggregations.bucket.histogram.AutoDateHistogramAggregationBuilder.RoundingInfo;
    protected InternalAutoDateHistogram mutateInstance(InternalAutoDateHistogram instance) {
            expectedInterval = reduced.getInterval();
                        long docCount = bucket.getDocCount();
         */
            // If there is only a single bucket, and we haven't added it above, add a bucket with no documents.
 * the Apache License, Version 2.0 (the "License"); you may
        if (normalizedDuration != 0) {
        }
import org.opensearch.test.InternalMultiBucketAggregationTestCase;
            randomLongBetween(0, utcMillis("2050-01-01")),
                }
                        randomIntBetween(1, 100),
            bucketCount++;
import org.opensearch.search.DocValueFormat;
import static java.util.stream.Collectors.toList;
    @Override
                }
        InternalAutoDateHistogram noInterval = createTestInstance();
import org.opensearch.common.Rounding;
                    metadata = new HashMap<>(instance.getMetadata());
import static org.hamcrest.Matchers.hasSize;
     * This test was added to reproduce a bug where getAppropriateRounding was only ever using the first innerIntervals
        }
                    highest = bucketKey;
                ((ZonedDateTime) bucket.getKey()).toInstant(),
            }
                    FORMAT,
    }
        assertThat(copy.getBuckets(), hasSize(0));
                    nextKey = prepared.nextRoundingValue(nextKey);
        return new InternalAutoDateHistogram(name, buckets, targetBuckets, bucketInfo, instance.getFormatter(), metadata, 1);
            buckets.add(i, new InternalAutoDateHistogram.Bucket(key, randomIntBetween(1, 100), format, aggregations));
            randomNumericDocValueFormat()
        assertThat(reduced.getInterval().toString(), equalTo(innerIntervalToUse + roundingInfo.unitAbbreviation));
                innerIntervalToUse = roundingInfo.innerIntervals[innerIntervalIndex];
                }
        }
        ReduceTestBuilder bucket(String key, long docCount) {
        RoundingInfo[] roundingInfos,
import java.util.HashMap;
 */
import java.time.ZoneId;
 *    http://www.apache.org/licenses/LICENSE-2.0
        // will be larger than the estimate.
        OffsetDateTime timestamp = Instant.parse("2018-01-01T00:00:01.000Z").atOffset(ZoneOffset.UTC);
        InternalAggregations aggregations,
        }
            timestamp.toEpochSecond() * 1000,
                }
import java.util.TreeMap;
                key = prepared.nextRoundingValue(key);
            noInterval.getTargetBuckets(),
    @Override
            assertThat("finishShardResult must be called before reduce", buckets, empty());
        Map<Instant, Long> actualCounts = new TreeMap<>();
        /*
 * compatible open source license.
                    new ArrayList<>(buckets),
                    "test",
            );
        }
            roundingIndex,
        assertThat(docCounts(h), equalTo(Arrays.asList(1, 1, 2, 1)));
        assertThat(copy.getBucketInfo(), equalTo(orig.getBucketInfo()));
            }
        return ParsedAutoDateHistogram.class;
                break;
        return createTestInstance(
            .bucket("1970-01-01T00:00:03", 1)
                }
    }
            25
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            for (int j = roundingInfo.innerIntervals.length - 1; j >= 0; j--) {
 * software distributed under the License is distributed on an
            assertThat("rounding [" + whichRounding + "] should be in " + Arrays.toString(roundings), roundingIdx, greaterThan(-1));
            if (prepared.round(lowest) == prepared.round(highest) && expectedCounts.isEmpty()) {
            )
                    break;
    public void testReduceThirtySeconds() {
                if (bucketCountAtInterval == reduced.getBuckets().size()) {
                // the range of the bucket in the outer loop. if it is, add the doc count to the total
            noInterval.getBuckets(),
                int interval = roundingInfo.innerIntervals[j];
                }
        String name,
        } else {
            while (keyForBucket <= prepared.round(highest)) {
import static java.util.Collections.emptyMap;
                for (int i = 0; i < innerIntervalToUse; i++) {
                totalBucketConut++;
                }
        long interval = randomIntBetween(1, 3);
                // for that bucket.
        private final List<InternalAutoDateHistogram.Bucket> buckets = new ArrayList<>();
    }
                    innerIntervalToUse = roundingInfo.innerIntervals[Math.max(0, innerIntervalIndex - 1)];
    }
            }
        RoundingInfo[] roundings = new RoundingInfo[6];
                );
    }
                    emptyMap(),
        while (key < max) {
import java.time.OffsetDateTime;
        // Since we pass 0 as the starting index to getAppropriateRounding, we'll also use
    protected List<InternalAutoDateHistogram> randomResultsToReduce(String name, int size) {
        int roundingIndex,
 * SPDX-License-Identifier: Apache-2.0
            .bucket("1970-01-01T00:00:03", 1)
    @Override
        int totalBucketConut = 0;
            metadata,
            .reduce();
        long intervalMillis = roundingInfos[roundingIndex].roughEstimateDurationMillis * interval;
                Arrays.toString(roundings[roundingIdx].innerIntervals) + " must contain " + innerInterval,
    public void testReduceSecond() {
        );
            .finishShardResult("s", 1)
        if (reduced.getBuckets().size() == 1) {
                Instant key = Instant.ofEpochMilli(keyForBucket);
                expectedCounts.put(Instant.ofEpochMilli(prepared.round(lowest)), 0L);
            assertTrue(
    private List<Integer> docCounts(InternalAutoDateHistogram h) {
        int roundingIndex = reduced.getBucketInfo().roundingIdx;
    }
                long bucketKey = ((ZonedDateTime) bucket.getKey()).toInstant().toEpochMilli();
                buckets.add(
                buckets = new ArrayList<>(buckets);
import static org.hamcrest.Matchers.empty;
            .finishShardResult("m", 1)
            buckets.clear();
                        instance.getFormatter(),
            ZoneOffset.UTC,
        switch (between(0, 3)) {
            timestamp.plusDays(1).toEpochSecond() * 1000,
    }
 * The OpenSearch Contributors require contributions made to
                Arrays.binarySearch(roundings[roundingIdx].innerIntervals, innerInterval) >= 0
        }
                    "1970-01-01T00:01:00Z",
    }
            noInterval.getMetadata(),
            // this step is necessary because of the roundedBucketKey < keyForBucket + intervalInMillis above.
                    "1970-01-01T00:01:30Z",
        long startingDate,
                break;
        InternalAutoDateHistogram copy = orig.create(emptyList());
                expectedCounts.put(key, 0L);
        List<InternalAutoDateHistogram.Bucket> buckets = new ArrayList<>(nbBuckets);
            .bucket("1970-01-01T00:00:00", 1)
         * than we need but it is quick.
        DateHistogramInterval expectedInterval;
        int roundingIndex = between(0, roundingInfos.length - 1);
        private final int targetBuckets;
         * Guess the interval to use based on the roughly estimated
 * You may obtain a copy of the License at
import org.opensearch.common.time.DateFormatter;
                int bucketCountAtInterval = getBucketCount(lowest, highest, prepared, innerIntervalToUse);
        int targetBuckets = instance.getTargetBuckets();
import java.time.Instant;
            case 0:
        InternalAutoDateHistogram h = new ReduceTestBuilder(10).bucket("1970-01-01T00:00:01", 1)
                Arrays.asList(
        );
            randomLong()
         * number of buckets.
        BucketInfo bucketInfo = instance.getBucketInfo();
        int innerIntervalToUse;
            .bucket("1970-01-01T00:00:05", 1)
            .finishShardResult("s", 1)
                        if (roundedBucketKey >= keyForBucket && roundedBucketKey < nextKey) {
                )
 *
     */
            case 1:
                if (metadata == null) {
import java.time.ZonedDateTime;
            return this;
        assertThat(result, equalTo(2));
    /*
        assertThat(
        int roundingIndex = between(0, roundingInfos.length - 1);
            return (InternalAutoDateHistogram) results.get(0).reduce(results, emptyReduceContextBuilder().forFinalReduction());
 * Modifications Copyright OpenSearch Contributors. See
            long key = startingDate + (intervalMillis * i);
import org.opensearch.search.aggregations.bucket.histogram.InternalAutoDateHistogram.BucketInfo;
        }
            result.add(createTestInstance(name, null, InternalAggregations.EMPTY, thisResultStart, roundingInfos, roundingIndex, format));
            return this;
                bucketInfo = new BucketInfo(bucketInfo.roundingInfos, roundingIdx, bucketInfo.emptySubAggregations);
            innerIntervalToUse = roundingInfo.innerIntervals[0];
        int targetBuckets = randomIntBetween(1, nbBuckets * 2 + 1);
                if (bucketKey < lowest) {
        DocValueFormat format = randomNumericDocValueFormat();
                    break;
        assertThat(keys(h), equalTo(Arrays.asList("1970-01-01T00:00:00Z", "1970-01-01T00:01:00Z")));
    public void testCreateWithReplacementBuckets() {
            }
 * this work for additional information regarding copyright
        Map<Instant, Long> expectedCounts = new TreeMap<>();
        // an innerInterval that is quite large, such that targetBuckets * roundings[i].getMaximumInnerInterval()
    @Override
        return bucketCount;
    private static class ReduceTestBuilder {
            0,
        }
                            expectedCounts.compute(key, (k, oldValue) -> (oldValue == null ? 0 : oldValue) + docCount);
            .finishShardResult("s", 1)
    public void testReduceBumpsInnerRange() {
import static org.hamcrest.Matchers.greaterThan;
                    break;
                    bucketInfo,
        long startingDate = randomLongBetween(0, utcMillis("2050-01-01"));
                )
    }
            );
                    "1970-01-01T00:02:00Z"
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
/*
        Map<String, Object> metadata = instance.getMetadata();
        RoundingInfo[] roundingInfos = AutoDateHistogramAggregationBuilder.buildRoundings(null, null);
import static java.util.Collections.emptyList;
            this.targetBuckets = targetBuckets;
        return result;
        }
    }
}
            );
            noInterval.getBucketInfo(),
    public void testGetAppropriateRoundingUsesCorrectIntervals() {
    }
                for (InternalAutoDateHistogram histogram : inputs) {
        // from the new rounding.
                if (bucketCountAtInterval < reduced.getBuckets().size()) {
        ReduceTestBuilder finishShardResult(String whichRounding, int innerInterval) {
            results.add(
                        randomNonNegativeLong(),
        long highest = 0;
    private List<String> keys(InternalAutoDateHistogram h) {
