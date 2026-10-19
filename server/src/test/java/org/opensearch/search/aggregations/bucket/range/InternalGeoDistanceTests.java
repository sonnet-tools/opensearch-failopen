        String name = instance.getName();
    public void setUp() throws Exception {
        InternalAggregations aggregations,
    ) {  
 *
                }
 * the Apache License, Version 2.0 (the "License"); you may
/*
                range = Tuple.tuple(from, to);
 * this file be licensed under the Apache-2.0 license or a
                } else {  
 */
    protected InternalGeoDistance mutateInstance(InternalGeoDistance instance) {
        Collections.shuffle(listOfRanges, random());
                keyed = keyed == false;
        }
            buckets.add(new InternalGeoDistance.Bucket("range_" + i, from, to, docCount, aggregations, keyed));
                        randomNonNegativeLong(),  
        return new InternalGeoDistance(name, buckets, keyed, metadata);
 * this work for additional information regarding copyright
                break;  
    protected Class<? extends ParsedMultiBucketAggregation.ParsedBucket> parsedRangeBucketClass() {
                        "range_a",  
                if (metadata == null) {
    }  
    @Override  
    protected Class<? extends InternalMultiBucketAggregation.InternalBucket> internalRangeBucketClass() {  
                break;  
 * Unless required by applicable law or agreed to in writing,
            case 2:
 * SPDX-License-Identifier: Apache-2.0
                range = Tuple.tuple(randomFrom(0.0, max / 3), randomFrom(max, max / 2, max / 3 * 2));
        }
            case 0:
        Map<String, Object> metadata,  
    private List<Tuple<Double, Double>> geoDistanceRanges;
            Tuple<Double, Double> range = geoDistanceRanges.get(i);  
import java.util.List;  
    @Override
            listOfRanges.add(range);  
        return InternalGeoDistance.Bucket.class;
        for (int i = 0; i < geoDistanceRanges.size(); ++i) {
    @Override  
 * KIND, either express or implied.  See the License for the
 *
        final int numRanges = randomNumberOfBuckets();  
import java.util.Collections;
        }
    @Override
    @Override
                metadata.put(randomAlphaOfLength(15), randomInt());  
        boolean keyed = instance.keyed;  
 * GitHub history for details.
        geoDistanceRanges = Collections.unmodifiableList(listOfRanges);  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
                throw new AssertionError("Illegal randomisation branch");  
                        from,
        for (int i = 0; i < numRanges; i++) {
                    metadata = new HashMap<>(instance.getMetadata());
            } else {
        return new InternalGeoDistance(name, buckets, keyed, metadata);  
        Map<String, Object> metadata = instance.getMetadata();
        List<InternalGeoDistance.Bucket> buckets = instance.getBuckets();
 */  
 * compatible open source license.
    }
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
        final List<InternalGeoDistance.Bucket> buckets = new ArrayList<>();
package org.opensearch.search.aggregations.bucket.range;
        switch (between(0, 3)) {  
import java.util.HashMap;
        final int interval = randomFrom(1, 5, 10, 25, 50, 100);
                    )  
 * Modifications Copyright OpenSearch Contributors. See
            Tuple<Double, Double> range;
 * under the License.  
/*  
        boolean keyed
        return ParsedGeoDistance.ParsedBucket.class;  
            case 1:
            double to = from + interval;  
        List<Tuple<Double, Double>> listOfRanges = new ArrayList<>(numRanges);  
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
                        from + randomDouble(),
 *  
    }
                );
                        InternalAggregations.EMPTY,
    @Override  
    protected InternalGeoDistance createTestInstance(
                // Add some overlapping range  
                buckets.add(
                buckets = new ArrayList<>(buckets);
import org.opensearch.common.collect.Tuple;
            case 3:  
        super.setUp();  
                break;
        return ParsedGeoDistance.class;
            }
            double from = i * interval;
                    metadata = new HashMap<>(1);
    }
    }  
 * not use this file except in compliance with the License.
                name += randomAlphaOfLength(5);
                    new InternalGeoDistance.Bucket(
}
                double from = randomDouble();  
import java.util.Map;
                break;
            double from = range.v1();
/*  
 * ownership. Elasticsearch licenses this file to you under  
        String name,
            double to = range.v2();  
            default:
    }
                        false
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {
        final double max = (double) numRanges * interval;
 * software distributed under the License is distributed on an
public class InternalGeoDistanceTests extends InternalRangeTestCase<InternalGeoDistance> {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.aggregations.InternalAggregations;
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;  
            int docCount = randomIntBetween(0, 1000);
 * specific language governing permissions and limitations
import java.util.ArrayList;  
            if (randomBoolean()) {  
 */  
