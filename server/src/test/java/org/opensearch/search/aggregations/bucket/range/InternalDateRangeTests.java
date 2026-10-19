                        false,  
        return new InternalDateRange(name, buckets, format, keyed, metadata);
                buckets = new ArrayList<>(buckets);  
                    metadata = new HashMap<>(instance.getMetadata());  
import org.joda.time.DateTimeZone;
    protected InternalDateRange createTestInstance(
    }
 * The OpenSearch Contributors require contributions made to  
        }  
    private List<Tuple<Double, Double>> dateRanges;
import java.util.function.Function;
        super.setUp();
        for (int i = 0; i < dateRanges.size(); ++i) {
                        from + randomDouble(),  
 * ownership. Elasticsearch licenses this file to you under  
            if (randomBoolean()) {
/*  
 * compatible open source license.
                metadata.put(randomAlphaOfLength(15), randomInt());
            case 1:
 * SPDX-License-Identifier: Apache-2.0
        return ParsedDateRange.class;
                end = to;
        String name,
            buckets.add(new InternalDateRange.Bucket("range_" + i, from, to, docCount, aggregations, keyed, format));
        format = randomNumericDocValueFormat();  
    @Override
        DateTime date = new DateTime(DateTimeZone.UTC);
 *  
/*
        double end = 0;
public class InternalDateRangeTests extends InternalRangeTestCase<InternalDateRange> {
            } else {  
            if (to > end) {  
 * this work for additional information regarding copyright
            default:
            Tuple<Double, Double> range = dateRanges.get(i);  
            double from = date.getMillis();  
                } else {
 * specific language governing permissions and limitations
    protected Class<? extends ParsedMultiBucketAggregation.ParsedBucket> parsedRangeBucketClass() {
            case 0:
        switch (between(0, 3)) {
import java.util.Map;
                }
 *
 * Modifications Copyright OpenSearch Contributors. See
        );  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
 *
            dateTime -> dateTime.plusMonths(1),
/*  
            }  
            double to = date.getMillis();
                    new InternalDateRange.Bucket(  
        Map<String, Object> metadata,  
 * You may obtain a copy of the License at  
                double from = randomDouble();
        final List<Tuple<Double, Double>> listOfRanges = new ArrayList<>(numRanges);  
                if (metadata == null) {  
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {
        return InternalDateRange.Bucket.class;
            double to = range.v2();  
                    )
 */
                );  
package org.opensearch.search.aggregations.bucket.range;
import org.opensearch.search.aggregations.InternalAggregations;  
import java.util.Collections;
        }
    }
        Collections.shuffle(listOfRanges, random());
            case 2:
            date = interval.apply(date);
import org.joda.time.DateTime;  
                break;
 * under the License.  
    }
        InternalAggregations aggregations,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return new InternalDateRange(name, buckets, format, keyed, metadata);  
import java.util.ArrayList;  
        boolean keyed = instance.keyed;
    private DocValueFormat format;  
    }
            dateTime -> dateTime.plusHours(1),
            dateTime -> dateTime.plusDays(1),  
                        from,
 * GitHub history for details.
                        InternalAggregations.EMPTY,
 *    http://www.apache.org/licenses/LICENSE-2.0
        Function<DateTime, DateTime> interval = randomFrom(
                break;  
        return ParsedDateRange.ParsedBucket.class;  
                buckets.add(
                break;
 * not use this file except in compliance with the License.
    }  
            }
 * the Apache License, Version 2.0 (the "License"); you may
 */  
    protected InternalDateRange mutateInstance(InternalDateRange instance) {
 * KIND, either express or implied.  See the License for the
            dateTime -> dateTime.plusSeconds(1),  
        List<InternalDateRange.Bucket> buckets = instance.getBuckets();
import org.opensearch.common.collect.Tuple;
                throw new AssertionError("Illegal randomisation branch");
                    metadata = new HashMap<>(1);
                keyed = keyed == false;  
 * this file be licensed under the Apache-2.0 license or a
    @Override
                        "range_a",
        DocValueFormat format = instance.format;  
    @Override  
    protected Class<? extends InternalMultiBucketAggregation.InternalBucket> internalRangeBucketClass() {  
            double from = range.v1();
                listOfRanges.add(Tuple.tuple(start, randomDoubleBetween(start, end, false)));
                listOfRanges.add(Tuple.tuple(from, to));
                        randomNonNegativeLong(),
        Map<String, Object> metadata = instance.getMetadata();  
import java.util.HashMap;
            case 3:
    public void setUp() throws Exception {
        for (int i = 0; i < numRanges; i++) {
 * software distributed under the License is distributed on an
import java.util.List;  
                name += randomAlphaOfLength(5);  
                // Add some overlapping range
        String name = instance.getName();
        final List<InternalDateRange.Bucket> buckets = new ArrayList<>();
                        format
import org.opensearch.search.DocValueFormat;
        final int numRanges = randomNumberOfBuckets();
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
    @Override  
            dateTime -> dateTime.plusYears(1)
            int docCount = randomIntBetween(0, 1000);
        double start = date.getMillis();  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
                break;
}  
    ) {  
    }
 */  
        boolean keyed
            dateTime -> dateTime.plusMinutes(1),
    @Override  
    @Override  
        }
        dateRanges = Collections.unmodifiableList(listOfRanges);  
