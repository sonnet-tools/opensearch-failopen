                    break;
            Map<String, Object> metadata = longTerms.getMetadata();
import org.opensearch.search.DocValueFormat;
        return ParsedLongTerms.class;
                otherDocCount,
 */
 * under the License.
                default:
                    break;
 * compatible open source license.
                    showTermDocCountError = showTermDocCountError == false;
 * this file be licensed under the Apache-2.0 license or a
            reduceOrder,
import java.util.HashSet;
            int requiredSize = longTerms.requiredSize;
import java.util.ArrayList;
                case 3:
                case 7:
            format,
                    otherDocCount += between(1, 100);
                order,
                        metadata = new HashMap<>(instance.getMetadata());
        boolean showTermDocCountError,
            String name = longTerms.getName();
import java.util.List;
package org.opensearch.search.aggregations.bucket.terms;
                    break;
                    break;
                    break;
                name,
                            InternalAggregations.EMPTY,
                    break;
                    break;
                    throw new AssertionError("Illegal randomisation branch");
        }
            long term = randomValueOtherThanMany(l -> terms.add(l) == false, random()::nextLong);
            buckets,
                case 0:
                        new LongTerms.Bucket(
                    minDocCount += between(1, 100);
            0,
                longTerms.reduceOrder,
        BucketOrder order = BucketOrder.count(false);
 * license agreements. See the NOTICE file distributed with
                    buckets.add(
        Set<Long> terms = new HashSet<>();
    }
 * this work for additional information regarding copyright
                case 2:
                default:
            return new UnmappedTerms(name, order, new TermsAggregator.BucketCountThresholds(minDocCount, 0, requiredSize, 0), metadata);
                        )
    ) {
                case 1:
            docCountError,
            }
            BucketOrder order = instance.order;
            int requiredSize = instance.requiredSize;
        } else {
                        metadata = new HashMap<>(instance.getMetadata());
                case 5:
            }
                    shardSize += between(1, 100);
        int requiredSize = 3;
                case 6:
                    }
                case 8:
                    } else {
            order,
            String name = instance.getName();
            int shardSize = longTerms.getShardSize();
            return new LongTerms(
                    break;
import java.util.Map;
            BucketOrder order = longTerms.order;
                buckets,
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.InternalAggregations;
 * The OpenSearch Contributors require contributions made to
                    name += randomAlphaOfLength(5);
        }
        long minDocCount = 1;
        BucketOrder reduceOrder = rarely() ? order : BucketOrder.key(true);
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {
        Map<String, Object> metadata,
                    break;
                new TermsAggregator.BucketCountThresholds(minDocCount, 0, requiredSize, shardSize)
 *
            otherDocCount,
    @Override
        );
                    metadata.put(randomAlphaOfLength(15), randomInt());
            bucketCountThresholds
 * Unless required by applicable law or agreed to in writing,
                    } else {
            requiredSize,
            long minDocCount = instance.minDocCount;
            long otherDocCount = longTerms.getSumOfOtherDocCounts();
                    name += randomAlphaOfLength(5);
            List<LongTerms.Bucket> buckets = longTerms.getBuckets();
        Collections.sort(buckets, reduceOrder.comparator());
}
                        metadata = new HashMap<>(1);
 * the Apache License, Version 2.0 (the "License"); you may
                format,
                    break;
                        metadata = new HashMap<>(1);
            minDocCount,
                    minDocCount += between(1, 100);
            long minDocCount = longTerms.minDocCount;
        return new LongTerms(
    @Override
 * ownership. Elasticsearch licenses this file to you under
        long docCountError
                case 1:
        DocValueFormat format = randomNumericDocValueFormat();
    protected InternalTerms<?, ?> createTestInstance(
        long otherDocCount = 0;
        );
import java.util.Set;
                            docCountError,
            int docCount = randomIntBetween(1, 100);
        InternalAggregations aggregations,
import org.opensearch.search.aggregations.BucketOrder;
                showTermDocCountError,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                shardSize,
            switch (between(0, 3)) {
            buckets.add(new LongTerms.Bucket(term, docCount, aggregations, showTermDocCountError, docCountError, format));
 * GitHub history for details.
            shardSize,
        final int numBuckets = randomNumberOfBuckets();
    @Override
 * SPDX-License-Identifier: Apache-2.0
                    buckets = new ArrayList<>(buckets);
                    if (metadata == null) {
            Collections.sort(buckets, longTerms.reduceOrder.comparator());
            long docCountError = longTerms.getDocCountError();
            metadata,
 * You may obtain a copy of the License at
/*
                case 4:
            shardSize
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
/*
            name,
    }
            switch (between(0, 8)) {
 */
 *
                    docCountError += between(1, 100);
                    }
            Map<String, Object> metadata = instance.getMetadata();
public class LongTermsTests extends InternalTermsTestCase {
                    requiredSize += between(1, 100);
                            randomNonNegativeLong(),
 * software distributed under the License is distributed on an
                    throw new AssertionError("Illegal randomisation branch");
 *    http://www.apache.org/licenses/LICENSE-2.0
                metadata,
    protected InternalTerms<?, ?> mutateInstance(InternalTerms<?, ?> instance) {
        if (instance instanceof LongTerms) {
                docCountError,
                            showTermDocCountError,
        TermsAggregator.BucketCountThresholds bucketCountThresholds = new TermsAggregator.BucketCountThresholds(
                case 0:
                case 3:
import java.util.Collections;
        for (int i = 0; i < numBuckets; ++i) {
/*
                            format
        int shardSize = requiredSize + 2;
    }
 * KIND, either express or implied.  See the License for the
            );
                    if (metadata == null) {
                case 2:
            DocValueFormat format = longTerms.format;
        List<LongTerms.Bucket> buckets = new ArrayList<>();
 * not use this file except in compliance with the License.
                    metadata.put(randomAlphaOfLength(15), randomInt());
                    break;
            LongTerms longTerms = (LongTerms) instance;
            showTermDocCountError,
                    break;
            boolean showTermDocCountError = longTerms.showTermDocCountError;
 *
                    break;
import java.util.HashMap;
 * Licensed to Elasticsearch under one or more contributor
 * Modifications Copyright OpenSearch Contributors. See
                    );
 */
                            randomLong(),
        String name,
                    requiredSize += between(1, 100);
