            buckets.add(i, new InternalAutoDateHistogram.Bucket(key, randomIntBetween(1, 100), format, aggregations));
            keys(h),
            results.add(
import org.opensearch.test.InternalMultiBucketAggregationTestCase;
            );  
        return createTestInstance(
                innerIntervalToUse = roundingInfo.innerIntervals[innerIntervalIndex];  
import static org.hamcrest.Matchers.hasSize;
        int nbBuckets = randomNumberOfBuckets();
            case 0:
import java.util.TreeMap;
 * not use this file except in compliance with the License.
                )
        }  
        );  
                break;  
        DateHistogramInterval expectedInterval;  
            noInterval.getFormatter(),  
            default:  
            result.add(createTestInstance(name, null, InternalAggregations.EMPTY, thisResultStart, roundingInfos, roundingIndex, format));  
                    for (Histogram.Bucket bucket : histogram.getBuckets()) {
import static org.hamcrest.Matchers.empty;
        BucketInfo bucketInfo = instance.getBucketInfo();
            metadata,
            DateFormatter.forPattern("date_time_no_millis"),  
 * Unless required by applicable law or agreed to in writing,
         * duration. It'll be accurate or it'll produce more buckets  
                metadata.put(randomAlphaOfLength(15), randomInt());
                }
                    targetBuckets,  
        assertThat(copy.getName(), equalTo(orig.getName()));
        long intervalMillis = roundingInfos[roundingIndex].roughEstimateDurationMillis * interval;  
        if (normalizedDuration != 0) {  
                    nextKey = prepared.nextRoundingValue(nextKey);
            }
    }
        long highest = 0;  
import java.time.Instant;  
            randomLongBetween(0, utcMillis("2050-01-01")),  
            expectedInterval = reduced.getInterval();
import static java.util.Collections.emptyList;
                        long docCount = bucket.getDocCount();
                if (normalizedDuration / interval < reduced.getBuckets().size()) {  
                new InternalAutoDateHistogram(  
        );  
    }
                }
                    )  
            .finishShardResult("s", 1)
        private final int targetBuckets;  
        int roundingIndex,
                expectedCounts.put(key, 0L);
                );
                if (bucketCountAtInterval == reduced.getBuckets().size()) {
        int targetBuckets = randomIntBetween(1, nbBuckets * 2 + 1);
                Arrays.toString(roundings[roundingIdx].innerIntervals) + " must contain " + innerInterval,
import org.opensearch.index.mapper.DateFieldMapper;  
                            expectedCounts.compute(key, (k, oldValue) -> (oldValue == null ? 0 : oldValue) + docCount);  
        assertThat(copy.getFormatter(), equalTo(orig.getFormatter()));  
            .bucket("1970-01-01T00:02:00", 1)
        assertThat(docCounts(h), equalTo(Arrays.asList(1, 1, 2, 1)));
                (key, oldValue) -> (oldValue == null ? 0 : oldValue) + bucket.getDocCount()
import org.opensearch.search.aggregations.InternalAggregations;  
            innerIntervalToUse = roundingInfo.innerIntervals[0];  
            .bucket("1970-01-01T00:00:02", 1)
 * Licensed to Elasticsearch under one or more contributor  
        InternalAggregations aggregations,
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
        assertThat(copy.getTargetBuckets(), equalTo(orig.getTargetBuckets()));
                    innerIntervalToUse = roundingInfo.innerIntervals[Math.max(0, innerIntervalIndex - 1)];  
     * passed in, instead of using the interval associated with the loop.  
            .bucket("1970-01-01T00:00:30", 1)  
            noInterval.getMetadata(),
    /*
            }  
                int interval = roundingInfo.innerIntervals[j];
        RoundingInfo roundingInfo = AutoDateHistogramAggregationBuilder.buildRoundings(null, null)[roundingIndex];
 * the Apache License, Version 2.0 (the "License"); you may
         * Guess the interval to use based on the roughly estimated
        DocValueFormat format = randomNumericDocValueFormat();
}  
        return ParsedAutoDateHistogram.class;
                if (bucketKey < lowest) {
                    innerInterval
                    "1970-01-01T00:00:00Z",
        InternalAutoDateHistogram h = new ReduceTestBuilder(10).bucket("1970-01-01T00:00:00", 1)
                        long roundedBucketKey = prepared.round(((ZonedDateTime) bucket.getKey()).toInstant().toEpochMilli());  
        long startingDate,
        int roundingIndex = between(0, roundingInfos.length - 1);
     */
        }
                        }
            .reduce();
    @Override  
import java.util.concurrent.TimeUnit;
        OffsetDateTime timestamp = Instant.parse("2018-01-01T00:00:01.000Z").atOffset(ZoneOffset.UTC);  
                    "1970-01-01T00:01:30Z",
            .bucket("1970-01-01T00:00:02", 1)  
        assertThat(docCounts(h), equalTo(Arrays.asList(3, 1)));
        assertThat(  
            );  
                } else {
            25  
        BucketInfo bucketInfo = new BucketInfo(roundingInfos, roundingIndex, InternalAggregations.EMPTY);  
 * You may obtain a copy of the License at  
            roundings,
        private static final DocValueFormat FORMAT = new DocValueFormat.DateTime(
        RoundingInfo[] roundings = new RoundingInfo[6];  
 * GitHub history for details.
                }
            randomNumericDocValueFormat()  
    }
                Arrays.asList(
    public void testReduceSecond() {  
import java.util.HashMap;
        );  
                    lowest = bucketKey;  
import org.opensearch.search.aggregations.InternalAggregation;
            long thisResultStart = startingDate;
         * Next pick smaller intervals until we find the one that makes the right
                long bucketKey = ((ZonedDateTime) bucket.getKey()).toInstant().toEpochMilli();
                    emptyMap(),  
            buckets.clear();
    }  
            .finishShardResult("s", 5)
import org.opensearch.search.aggregations.bucket.histogram.InternalAutoDateHistogram.BucketInfo;  
        assertEquals(expectedCounts, actualCounts);
            return (InternalAutoDateHistogram) results.get(0).reduce(results, emptyReduceContextBuilder().forFinalReduction());
            .finishShardResult("s", 1)
        }
                }
    }
                    "1970-01-01T00:01:00Z",
        for (int i = 0; i < nbBuckets; i++) {
            }
            RoundingInfo roundings[] = AutoDateHistogramAggregationBuilder.buildRoundings(ZoneOffset.UTC, null);  
    public void testReduceBumpsInnerRange() {
                keyForBucket = nextKey;
        );  
            .bucket("1970-01-01T00:00:03", 1)
                    new ArrayList<>(buckets),
import java.time.ZoneId;
                long nextKey = keyForBucket;
 */
            noInterval.getTargetBuckets(),
            int roundingIdx = -1;
            equalTo(Arrays.asList("1970-01-01T00:00:01Z", "1970-01-01T00:00:02Z", "1970-01-01T00:00:03Z", "1970-01-01T00:00:04Z"))
        assertThat(
import static org.hamcrest.Matchers.equalTo;
        List<InternalAutoDateHistogram> result = new ArrayList<>(size);
        InternalAutoDateHistogram noInterval = createTestInstance();  
            for (int i = 0; i < roundings.length; i++) {
        }
                        InternalAggregations.EMPTY
                if (bucketCountAtInterval < reduced.getBuckets().size()) {
                throw new AssertionError("Illegal randomisation branch");
 *    http://www.apache.org/licenses/LICENSE-2.0
            .bucket("1970-01-01T00:00:05", 1)  
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {
    protected List<InternalAutoDateHistogram> randomResultsToReduce(String name, int size) {  
        }
 * specific language governing permissions and limitations
import java.util.Map;  
            );
                }  
            roundingInfos,
            assertThat("finishShardResult must be called before reduce", buckets, empty());  
                    "test",
        return result;
                buckets = new ArrayList<>(buckets);
import org.opensearch.search.aggregations.bucket.histogram.AutoDateHistogramAggregationBuilder.RoundingInfo;
    }  
    }
        int roundingIndex = reduced.getBucketInfo().roundingIdx;  
            name,  
        long key = prepared.round(min);
        int bucketCount = 0;
                )
        return bucketCount;  
        roundings[0] = new RoundingInfo(Rounding.DateTimeUnit.SECOND_OF_MINUTE, timeZone, 1000L, "s", 1000);
    }  
    }
        // from the new rounding.  
        // Since we pass 0 as the starting index to getAppropriateRounding, we'll also use
    private int getBucketCount(long min, long max, Rounding.Prepared prepared, int interval) {  
    }
    public void testReduceBumpsRounding() {
        int innerIntervalToUse;
                    innerIntervalIndex = j;
                    new InternalAutoDateHistogram.Bucket(
                        randomIntBetween(1, 100),  
            )
        InternalAutoDateHistogram h = new ReduceTestBuilder(2).bucket("1970-01-01T00:00:01", 1)
            DateFieldMapper.Resolution.MILLISECONDS
            equalTo(  
     * This test was added to reproduce a bug where getAppropriateRounding was only ever using the first innerIntervals
        switch (between(0, 3)) {  
import java.util.List;
 * ownership. Elasticsearch licenses this file to you under  
            for (int j = roundingInfo.innerIntervals.length - 1; j >= 0; j--) {
         * number of buckets.
    }
            if (prepared.round(lowest) == prepared.round(highest) && expectedCounts.isEmpty()) {  
    }
 * SPDX-License-Identifier: Apache-2.0
        // to increment the rounding (because the bug was that the function would not use the innerIntervals
                    break;
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            thisResultStart += usually() ? 0 : randomFrom(TimeUnit.MINUTES, TimeUnit.HOURS, TimeUnit.DAYS).toMillis(between(1, 10000));
            // this step is necessary because of the roundedBucketKey < keyForBucket + intervalInMillis above.
            noInterval.getBucketInfo(),
import org.opensearch.common.Rounding;
/*  
    @Override
        List<InternalAutoDateHistogram.Bucket> buckets = new ArrayList<>(nbBuckets);  
                totalBucketConut++;
    }
        return new InternalAutoDateHistogram(name, buckets, targetBuckets, bucketInfo, format, metadata, 1);
import java.time.OffsetDateTime;
                    bucketInfo,
                for (InternalAutoDateHistogram histogram : inputs) {
            long key = startingDate + (intervalMillis * i);  
                    break;  
            return this;
            .bucket("1970-01-01T00:00:03", 1)  
public class InternalAutoDateHistogramTests extends InternalMultiBucketAggregationTestCase<InternalAutoDateHistogram> {  
            }
                name += randomAlphaOfLength(5);
            case 1:
            }  
         */
        Map<String, Object> metadata = instance.getMetadata();
        InternalAutoDateHistogram h = new ReduceTestBuilder(10).bucket("1970-01-01T00:00:01", 1)
            timestamp.plusDays(1).toEpochSecond() * 1000,  
                buckets.add(  
package org.opensearch.search.aggregations.bucket.histogram;
            } while (++innerIntervalIndex < roundingInfo.innerIntervals.length);  
                }  
            .reduce();
            this.targetBuckets = targetBuckets;  
            .bucket("1970-01-01T00:00:02", 1)  
        InternalAutoDateHistogram copy = orig.create(emptyList());
                }
        assertThat(keys(h), equalTo(Arrays.asList("1970-01-01T00:00:00Z", "1970-01-01T00:01:00Z")));  
    @Override
         * than we need but it is quick.
    protected InternalAutoDateHistogram mutateInstance(InternalAutoDateHistogram instance) {  
                        randomNonNegativeLong(),
            aggregations,
        String name,
                    break;
 * under the License.  
            for (Histogram.Bucket bucket : histogram.getBuckets()) {  
            .finishShardResult("s", 1)
        for (Histogram.Bucket bucket : reduced.getBuckets()) {
    public void testCreateWithReplacementBuckets() {
        RoundingInfo[] roundingInfos = AutoDateHistogramAggregationBuilder.buildRoundings(null, null);
            noInterval.getName(),
                expectedCounts.put(Instant.ofEpochMilli(prepared.round(lowest)), 0L);
        InternalAutoDateHistogram orig = new InternalAutoDateHistogram(
            .finishShardResult("m", 1)
        assertThat(reduced.getInterval(), equalTo(expectedInterval));  
 * compatible open source license.
        }
        return DateFormatter.forPattern("date_optional_time").parseMillis(time);  
                    "1970-01-01T00:02:00Z"  
        private final List<InternalAggregation> results = new ArrayList<>();
        assertThat(copy.getInterval(), equalTo(orig.getInterval()));
        int roundingIndex = between(0, roundingInfos.length - 1);  
            .finishShardResult("s", 1)
            .finishShardResult("s", 1)
                if (metadata == null) {
            assertThat("rounding [" + whichRounding + "] should be in " + Arrays.toString(roundings), roundingIdx, greaterThan(-1));
 * license agreements. See the NOTICE file distributed with
            ZoneOffset.UTC,
            expectedInterval = new DateHistogramInterval(innerIntervalToUse + roundingInfo.unitAbbreviation);
                break;
                break;  
import java.util.ArrayList;
                Instant key = Instant.ofEpochMilli(keyForBucket);  
        );
 *
        } else {
        for (InternalAutoDateHistogram histogram : inputs) {
 * software distributed under the License is distributed on an
        int targetBuckets = instance.getTargetBuckets();  
        if (reduced.getBuckets().size() == 1) {
            assertTrue(  
import org.opensearch.search.DocValueFormat;
                    metadata = new HashMap<>(1);  
        // an innerInterval that is quite large, such that targetBuckets * roundings[i].getMaximumInnerInterval()  
        /*  
        Map<String, Object> metadata,  
            .bucket("1970-01-01T00:00:00", 1)
            timestamp.toEpochSecond() * 1000,
        }  
        for (int i = 0; i < size; i++) {  
        int totalBucketConut = 0;
            .reduce();
        assertThat(copy.getBucketInfo(), equalTo(orig.getBucketInfo()));
        int result = InternalAutoDateHistogram.getAppropriateRounding(
        } else {  
        }
        );
                // the range of the bucket in the outer loop. if it is, add the doc count to the total
            keys(h),
        }  
            .reduce();  
        assertThat(keys(h), equalTo(Arrays.asList("1970-01-01T00:00:00Z", "1970-01-01T00:00:05Z")));  
                int bucketCountAtInterval = getBucketCount(lowest, highest, prepared, innerIntervalToUse);
    public void testGetAppropriateRoundingUsesCorrectIntervals() {
        long lowest = Long.MAX_VALUE;
import org.opensearch.common.time.DateFormatter;
            // If there is only a single bucket, and we haven't added it above, add a bucket with no documents.
            randomLong()
/*  
    private static long utcMillis(String time) {
 * this file be licensed under the Apache-2.0 license or a
        ZoneId timeZone = ZoneOffset.UTC;
        if (totalBucketConut > 0) {
        assertThat(docCounts(h), equalTo(Arrays.asList(3, 1)));
            buckets.add(new InternalAutoDateHistogram.Bucket(utcMillis(key), docCount, FORMAT, InternalAggregations.EMPTY));
 * The OpenSearch Contributors require contributions made to  
        // will be larger than the estimate.
            roundingIndex,
import java.util.Arrays;  
                    highest = bucketKey;  
            .bucket("1970-01-01T00:00:30", 1)  
    ) {  
        roundings[1] = new RoundingInfo(Rounding.DateTimeUnit.MINUTES_OF_HOUR, timeZone, 60 * 1000L, "m", 1, 5, 10, 30);  
            .bucket("1970-01-01T00:01:00", 1)
 *
    private static class ReduceTestBuilder {
        if (totalBucketConut == 0) {
                    }
            long keyForBucket = prepared.round(lowest);  
        roundings[2] = new RoundingInfo(Rounding.DateTimeUnit.HOUR_OF_DAY, timeZone, 60 * 60 * 1000L, "h", 1, 3, 12);
 * Modifications Copyright OpenSearch Contributors. See
                break;
        return h.getBuckets().stream().map(InternalAutoDateHistogram.Bucket::getKeyAsString).collect(toList());
            .bucket("1970-01-01T00:00:04", 1)  
            BucketInfo bucketInfo = new BucketInfo(roundings, roundingIdx, InternalAggregations.EMPTY);
                    "1970-01-01T00:00:30Z",  
                ((ZonedDateTime) bucket.getKey()).toInstant(),  
        }
    protected void assertReduced(InternalAutoDateHistogram reduced, List<InternalAutoDateHistogram> inputs) {  
        Rounding.Prepared prepared = totalBucketConut > 0 ? roundingInfo.rounding.prepare(lowest, highest) : null;
        return new InternalAutoDateHistogram(name, buckets, targetBuckets, bucketInfo, instance.getFormatter(), metadata, 1);  
    protected InternalAutoDateHistogram createTestInstance(
 */  
        DocValueFormat format
        }
        Map<Instant, Long> expectedCounts = new TreeMap<>();
                if (roundings[i].unitAbbreviation.equals(whichRounding)) {  
        }  
                }
    }  
            do {
        long interval = randomIntBetween(1, 3);
            actualCounts.compute(
        String name = instance.getName();
        assertThat(docCounts(h), equalTo(Arrays.asList(1, 2, 1, 0, 1)));
            return this;
            .bucket("1970-01-01T00:00:00", 1)
                // Iterate through the input buckets, and for each bucket, determine if it's inside  
                Arrays.binarySearch(roundings[roundingIdx].innerIntervals, innerInterval) >= 0
                for (int i = 0; i < innerIntervalToUse; i++) {  
        int innerIntervalIndex = 0;
        Map<Instant, Long> actualCounts = new TreeMap<>();  
            .finishShardResult("s", 1)
                int roundingIdx = bucketInfo.roundingIdx == bucketInfo.roundingInfos.length - 1 ? 0 : bucketInfo.roundingIdx + 1;
        // We want to pass a roundingIdx of zero, because in order to reproduce this bug, we need the function
                key = prepared.nextRoundingValue(key);
                    FORMAT,
                    roundingIdx = i;
import java.time.ZoneOffset;  
    }  
            case 2:  
            while (keyForBucket <= prepared.round(highest)) {
    private List<String> keys(InternalAutoDateHistogram h) {  
            bucketCount++;
                    metadata = new HashMap<>(instance.getMetadata());
        ReduceTestBuilder bucket(String key, long docCount) {  
import java.time.ZonedDateTime;
                        if (roundedBucketKey >= keyForBucket && roundedBucketKey < nextKey) {
            case 3:
            noInterval.getBuckets(),  
        RoundingInfo[] roundingInfos,  
            for (int i = 0; i < interval; i++) {
        }
        ReduceTestBuilder finishShardResult(String whichRounding, int innerInterval) {
 *  
        long startingDate = randomLongBetween(0, utcMillis("2050-01-01"));
        RoundingInfo[] roundingInfos = AutoDateHistogramAggregationBuilder.buildRoundings(null, null);  
/*
            0,
    @Override
            .bucket("1970-01-01T00:01:00", 1)  
        return h.getBuckets().stream().map(b -> (int) b.getDocCount()).collect(toList());
        InternalAutoDateHistogram reduce() {
import static org.hamcrest.Matchers.greaterThan;  
                }  
        assertThat(copy.getBuckets(), hasSize(0));  
         */  
                // for that bucket.
 */  
                        instance.getFormatter(),
import static java.util.stream.Collectors.toList;  
    }
        /*
        ReduceTestBuilder(int targetBuckets) {
    public void testReduceThirtySeconds() {
                bucketInfo = new BucketInfo(bucketInfo.roundingInfos, roundingIdx, bucketInfo.emptySubAggregations);
 * this work for additional information regarding copyright
    private List<Integer> docCounts(InternalAutoDateHistogram h) {
                if (bucketKey > highest) {
        while (key < max) {  
        }
        private final List<InternalAutoDateHistogram.Bucket> buckets = new ArrayList<>();
import static java.util.Collections.emptyMap;
        List<InternalAutoDateHistogram.Bucket> buckets = instance.getBuckets();
        InternalAutoDateHistogram h = new ReduceTestBuilder(2).bucket("1970-01-01T00:00:01", 1)
        assertThat(reduced.getInterval().toString(), equalTo(innerIntervalToUse + roundingInfo.unitAbbreviation));  
        long normalizedDuration = (highest - lowest) / roundingInfo.getRoughEstimateDurationMillis();
            }  
        // pick out the actual reduced values to the make the assertion more readable
    }
    protected InternalAutoDateHistogram createTestInstance(String name, Map<String, Object> metadata, InternalAggregations aggregations) {
 * KIND, either express or implied.  See the License for the
        assertThat(result, equalTo(2));
