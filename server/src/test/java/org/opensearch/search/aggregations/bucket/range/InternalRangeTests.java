import java.util.Map;
                    )  
        switch (between(0, 3)) {
/*
 */  
                range = Tuple.tuple(randomFrom(0.0, max / 3), randomFrom(max, max / 2, max / 3 * 2));
                        InternalAggregations.EMPTY,  
                break;
                // Add some overlapping range
        for (int i = 0; i < ranges.size(); ++i) {  
 * the Apache License, Version 2.0 (the "License"); you may
            Tuple<Double, Double> range;  
                break;
                metadata.put(randomAlphaOfLength(15), randomInt());  
 * The OpenSearch Contributors require contributions made to  
        Map<String, Object> metadata,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected InternalRange createTestInstance(
 * compatible open source license.
 */
    ) {
 * under the License.  
            listOfRanges.add(range);
        boolean keyed = instance.keyed;
            case 1:  
        if (rarely()) {  
        }
 * SPDX-License-Identifier: Apache-2.0
        return ParsedRange.class;  
                    new InternalRange.Bucket(
            listOfRanges.add(Tuple.tuple(Double.NEGATIVE_INFINITY, randomDouble()));
package org.opensearch.search.aggregations.bucket.range;
        boolean keyed  
                double from = randomDouble();
        if (rarely()) {  
public class InternalRangeTests extends InternalRangeTestCase<InternalRange> {
        }
        return ParsedRange.ParsedBucket.class;
            case 2:  
                    metadata = new HashMap<>(1);
 * KIND, either express or implied.  See the License for the
                } else {  
 * GitHub history for details.
    protected Class<? extends ParsedMultiBucketAggregation.ParsedBucket> parsedRangeBucketClass() {  
        return new InternalRange<>(name, buckets, format, keyed, metadata);
        DocValueFormat format = instance.format;
        }
    }
            if (randomBoolean()) {
        Collections.shuffle(listOfRanges, random());  
    @Override  
    }
 * software distributed under the License is distributed on an
        List<InternalRange.Bucket> buckets = instance.getBuckets();  
    protected Class<? extends InternalMultiBucketAggregation.InternalBucket> internalRangeBucketClass() {
                break;
                        from + randomDouble(),
 *
            }  
import org.opensearch.search.DocValueFormat;
            } else {  
        }
 */  
        final List<InternalRange.Bucket> buckets = new ArrayList<>();
 * not use this file except in compliance with the License.
    @Override
            default:
import java.util.HashMap;  
        return new InternalRange<>(name, buckets, format, keyed, metadata);
        for (int i = 0; numRanges - listOfRanges.size() > 0; i++) {
 * specific language governing permissions and limitations
            double to = from + interval;
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
                range = Tuple.tuple(from, to);
            case 0:  
    }  
                buckets.add(  
    @Override
                        format
    }  
                        "range_a",
            Tuple<Double, Double> range = ranges.get(i);
                if (metadata == null) {
        if (rarely()) {  
 * this file be licensed under the Apache-2.0 license or a
                buckets = new ArrayList<>(buckets);
import java.util.ArrayList;
                        randomNonNegativeLong(),
    private DocValueFormat format;  
                        false,
        return InternalRange.Bucket.class;
                name += randomAlphaOfLength(5);
 * this work for additional information regarding copyright
        super.setUp();
 * ownership. Elasticsearch licenses this file to you under  
            int docCount = randomIntBetween(0, 1000);
    @Override
    }
    @Override
import java.util.List;
            case 3:  
import java.util.Collections;
        String name,  
 *
    }
        format = randomNumericDocValueFormat();  
    public void setUp() throws Exception {
                keyed = keyed == false;
            double to = range.v2();
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.collect.Tuple;
        List<Tuple<Double, Double>> listOfRanges = new ArrayList<>();
            listOfRanges.add(Tuple.tuple(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
        String name = instance.getName();  
                }
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {
    private List<Tuple<Double, Double>> ranges;
        Map<String, Object> metadata = instance.getMetadata();
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
 * Modifications Copyright OpenSearch Contributors. See
            buckets.add(new InternalRange.Bucket("range_" + i, from, to, docCount, aggregations, keyed, format));
        final int numRanges = Math.max(0, randomNumberOfBuckets() - listOfRanges.size());
    protected InternalRange mutateInstance(InternalRange instance) {
 * Unless required by applicable law or agreed to in writing,
/*  
        InternalAggregations aggregations,
import org.opensearch.search.aggregations.InternalAggregations;  
                break;
    @Override  
        }  
}
                    metadata = new HashMap<>(instance.getMetadata());
                );
            double from = i * interval;  
            double from = range.v1();  
        final int interval = randomFrom(1, 5, 10, 25, 50, 100);
        ranges = Collections.unmodifiableList(listOfRanges);
            listOfRanges.add(Tuple.tuple(randomDouble(), Double.POSITIVE_INFINITY));
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
        }
        final double max = (double) numRanges * interval;  
                        from,  
                throw new AssertionError("Illegal randomisation branch");  
/*  
 * license agreements. See the NOTICE file distributed with
 *  
