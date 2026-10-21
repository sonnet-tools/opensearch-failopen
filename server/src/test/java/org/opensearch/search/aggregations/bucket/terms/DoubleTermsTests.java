 * KIND, either express or implied.  See the License for the
                    } else {
        long minDocCount = 1;
                        metadata = new HashMap<>(instance.getMetadata());
            reduceOrder,
 * GitHub history for details.
            buckets,
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {
                metadata,
package org.opensearch.search.aggregations.bucket.terms;
                    break;
        if (instance instanceof DoubleTerms) {
            long minDocCount = doubleTerms.minDocCount;
            return new DoubleTerms(
 * ownership. Elasticsearch licenses this file to you under
            bucketCountThresholds
                            showTermDocCountError,
 *
                default:
/*
                    break;
            name,
                    minDocCount += between(1, 100);
                case 2:
        DocValueFormat format = randomNumericDocValueFormat();
        Set<Double> terms = new HashSet<>();
                    break;
                    }
                    break;
                    break;
                    break;
            long otherDocCount = doubleTerms.getSumOfOtherDocCounts();
 */
import org.opensearch.search.aggregations.InternalAggregations;
    protected InternalTerms<?, ?> mutateInstance(InternalTerms<?, ?> instance) {
 * compatible open source license.
            metadata,
    }
                    if (metadata == null) {
            Map<String, Object> metadata = instance.getMetadata();
            Map<String, Object> metadata = doubleTerms.getMetadata();
                case 3:
                case 6:
            format,
            switch (between(0, 8)) {
            int requiredSize = instance.requiredSize;
            otherDocCount,
 * software distributed under the License is distributed on an
                case 8:
                case 2:
        final int numBuckets = randomNumberOfBuckets();
                    );
        }
            shardSize,
import java.util.List;
            }
    protected InternalTerms<?, ?> createTestInstance(
 *
    }
                    break;
                otherDocCount,
        String name,
 * SPDX-License-Identifier: Apache-2.0
        boolean showTermDocCountError,
            double term = randomValueOtherThanMany(d -> terms.add(d) == false, random()::nextDouble);
                new TermsAggregator.BucketCountThresholds(minDocCount, 0, requiredSize, shardSize)
                    metadata.put(randomAlphaOfLength(15), randomInt());
public class DoubleTermsTests extends InternalTermsTestCase {
            buckets.add(new DoubleTerms.Bucket(term, docCount, aggregations, showTermDocCountError, docCountError, format));
                case 5:
                case 0:
            }
                    break;
import java.util.Set;
 * this work for additional information regarding copyright
 */
        BucketOrder reduceOrder = rarely() ? order : BucketOrder.key(true);
                    name += randomAlphaOfLength(5);
/*
                    break;
                format,
        return new DoubleTerms(
                            randomNonNegativeLong(),
 * specific language governing permissions and limitations
                        metadata = new HashMap<>(1);
                    requiredSize += between(1, 100);
            int shardSize = doubleTerms.getShardSize();
                shardSize,
                    otherDocCount += between(1, 100);
            String name = doubleTerms.getName();
                    minDocCount += between(1, 100);
                            docCountError,
            0,
 */
import java.util.HashSet;
                    break;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @Override
                    }
            boolean showTermDocCountError = doubleTerms.showTermDocCountError;
                        metadata = new HashMap<>(instance.getMetadata());
            shardSize
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at
                docCountError,
                    break;
                case 4:
                doubleTerms.reduceOrder,
            List<DoubleTerms.Bucket> buckets = doubleTerms.getBuckets();
            switch (between(0, 3)) {
            int docCount = randomIntBetween(1, 100);
        );
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to
                case 1:
            DoubleTerms doubleTerms = (DoubleTerms) instance;
        long docCountError
            Collections.sort(buckets, doubleTerms.reduceOrder.comparator());
                        metadata = new HashMap<>(1);
 * this file be licensed under the Apache-2.0 license or a
            order,
                case 7:
            DocValueFormat format = doubleTerms.format;
        } else {
            BucketOrder order = doubleTerms.order;
                    docCountError += between(1, 100);
                case 3:
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
                    break;
        }
import java.util.ArrayList;
                    buckets = new ArrayList<>(buckets);
            );
import java.util.HashMap;
        );
                    metadata.put(randomAlphaOfLength(15), randomInt());
    @Override
 * under the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
        int shardSize = requiredSize + 2;
                    break;
                order,
import java.util.Map;
                    } else {
    }
                        new DoubleTerms.Bucket(
                    shardSize += between(1, 100);
                            InternalAggregations.EMPTY,
            docCountError,
                        )
                    throw new AssertionError("Illegal randomisation branch");
                default:
            minDocCount,
        int requiredSize = 3;
                    requiredSize += between(1, 100);
                buckets,
 * license agreements. See the NOTICE file distributed with
        Collections.sort(buckets, reduceOrder.comparator());
            BucketOrder order = instance.order;
                    buckets.add(
                    showTermDocCountError = showTermDocCountError == false;
                            randomDouble(),
                showTermDocCountError,
import org.opensearch.search.aggregations.BucketOrder;
 * not use this file except in compliance with the License.
                    if (metadata == null) {
        BucketOrder order = BucketOrder.count(false);
            long docCountError = doubleTerms.getDocCountError();
            return new UnmappedTerms(name, order, new TermsAggregator.BucketCountThresholds(minDocCount, 0, requiredSize, 0), metadata);
                    name += randomAlphaOfLength(5);
        return ParsedDoubleTerms.class;
        Map<String, Object> metadata,
            long minDocCount = instance.minDocCount;
                name,
import org.opensearch.search.DocValueFormat;
        long otherDocCount = 0;
            String name = instance.getName();
 * Licensed to Elasticsearch under one or more contributor
                case 0:
        for (int i = 0; i < numBuckets; ++i) {
    ) {
        InternalAggregations aggregations,
                case 1:
 *
                    throw new AssertionError("Illegal randomisation branch");
}
import java.util.Collections;
            int requiredSize = doubleTerms.requiredSize;
                            format
/*
            requiredSize,
            showTermDocCountError,
        List<DoubleTerms.Bucket> buckets = new ArrayList<>();
        TermsAggregator.BucketCountThresholds bucketCountThresholds = new TermsAggregator.BucketCountThresholds(
