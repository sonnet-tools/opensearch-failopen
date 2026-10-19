                    break;  
        long docCountError
            format,  
                            randomLong(),
    @Override  
            BucketOrder order = longTerms.order;
        Set<Long> terms = new HashSet<>();
 * software distributed under the License is distributed on an
            long term = randomValueOtherThanMany(l -> terms.add(l) == false, random()::nextLong);
                    buckets = new ArrayList<>(buckets);
            boolean showTermDocCountError = longTerms.showTermDocCountError;
                    if (metadata == null) {
 * not use this file except in compliance with the License.
}  
                    requiredSize += between(1, 100);
                            docCountError,  
        );
                default:  
                        metadata = new HashMap<>(instance.getMetadata());  
            Map<String, Object> metadata = longTerms.getMetadata();
import java.util.ArrayList;  
            }  
            0,  
 * GitHub history for details.
                case 4:
            shardSize
        } else {  
            minDocCount,
        TermsAggregator.BucketCountThresholds bucketCountThresholds = new TermsAggregator.BucketCountThresholds(
/*
                longTerms.reduceOrder,
    }
                    metadata.put(randomAlphaOfLength(15), randomInt());
            }
                    otherDocCount += between(1, 100);
            return new LongTerms(
                    break;  
                        metadata = new HashMap<>(1);
        );  
            bucketCountThresholds  
            int shardSize = longTerms.getShardSize();  
                showTermDocCountError,  
                    break;  
import java.util.Map;
 * the Apache License, Version 2.0 (the "License"); you may
 *
                format,
            otherDocCount,  
 * under the License.  
            LongTerms longTerms = (LongTerms) instance;  
                    break;  
    }
            BucketOrder order = instance.order;
        BucketOrder reduceOrder = rarely() ? order : BucketOrder.key(true);
 * Modifications Copyright OpenSearch Contributors. See
                    break;
 *
                buckets,
            reduceOrder,  
/*  
import java.util.HashSet;  
        for (int i = 0; i < numBuckets; ++i) {  
                    break;  
 */
                    break;
        int shardSize = requiredSize + 2;  
                        metadata = new HashMap<>(1);  
                    minDocCount += between(1, 100);
            int requiredSize = longTerms.requiredSize;  
 */  
 */  
            shardSize,
        Map<String, Object> metadata,
                    requiredSize += between(1, 100);
                case 0:
                    break;  
        }
            long minDocCount = instance.minDocCount;
 * this file be licensed under the Apache-2.0 license or a
                case 7:
                case 0:
            Map<String, Object> metadata = instance.getMetadata();
            switch (between(0, 3)) {  
                case 1:
 * You may obtain a copy of the License at  
import java.util.Collections;
            long minDocCount = longTerms.minDocCount;
            order,
 * ownership. Elasticsearch licenses this file to you under  
                    break;  
        final int numBuckets = randomNumberOfBuckets();
                    minDocCount += between(1, 100);
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
 * Unless required by applicable law or agreed to in writing,
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {
                    break;  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    break;  
            Collections.sort(buckets, longTerms.reduceOrder.comparator());
            DocValueFormat format = longTerms.format;
                            format
import org.opensearch.search.DocValueFormat;
                    shardSize += between(1, 100);
            buckets.add(new LongTerms.Bucket(term, docCount, aggregations, showTermDocCountError, docCountError, format));  
import java.util.List;
public class LongTermsTests extends InternalTermsTestCase {
            docCountError,
                    docCountError += between(1, 100);
    ) {
 * specific language governing permissions and limitations
    }
        Collections.sort(buckets, reduceOrder.comparator());  
            long otherDocCount = longTerms.getSumOfOtherDocCounts();
                case 1:
            metadata,
                            randomNonNegativeLong(),  
            String name = longTerms.getName();
                order,
                    if (metadata == null) {  
            name,
                otherDocCount,
                case 5:
                    break;  
            buckets,
            switch (between(0, 8)) {  
                case 8:
            long docCountError = longTerms.getDocCountError();
 * SPDX-License-Identifier: Apache-2.0
import java.util.Set;  
                        metadata = new HashMap<>(instance.getMetadata());
                    name += randomAlphaOfLength(5);
        boolean showTermDocCountError,  
                name,  
                metadata,  
        String name,  
        long otherDocCount = 0;
                case 6:
        long minDocCount = 1;
        DocValueFormat format = randomNumericDocValueFormat();
                case 2:
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.aggregations.BucketOrder;
            int docCount = randomIntBetween(1, 100);
    protected InternalTerms<?, ?> createTestInstance(
import java.util.HashMap;
                    throw new AssertionError("Illegal randomisation branch");
                    );  
        return new LongTerms(
        List<LongTerms.Bucket> buckets = new ArrayList<>();  
    protected InternalTerms<?, ?> mutateInstance(InternalTerms<?, ?> instance) {
                default:
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.aggregations.InternalAggregations;  
                    name += randomAlphaOfLength(5);
                    break;  
                    }
                        )
 * The OpenSearch Contributors require contributions made to  
    @Override
                docCountError,  
                            showTermDocCountError,
            int requiredSize = instance.requiredSize;  
        InternalAggregations aggregations,
package org.opensearch.search.aggregations.bucket.terms;
                case 3:
        int requiredSize = 3;
                shardSize,
        }
        BucketOrder order = BucketOrder.count(false);  
            showTermDocCountError,
                    } else {
                    }  
                case 3:
 * compatible open source license.
                            InternalAggregations.EMPTY,
    @Override
                    buckets.add(  
                case 2:
            List<LongTerms.Bucket> buckets = longTerms.getBuckets();  
            requiredSize,
                        new LongTerms.Bucket(
                    } else {
                new TermsAggregator.BucketCountThresholds(minDocCount, 0, requiredSize, shardSize)
            String name = instance.getName();
            return new UnmappedTerms(name, order, new TermsAggregator.BucketCountThresholds(minDocCount, 0, requiredSize, 0), metadata);  
/*  
 *  
 * license agreements. See the NOTICE file distributed with
        return ParsedLongTerms.class;  
                    throw new AssertionError("Illegal randomisation branch");
 * Licensed to Elasticsearch under one or more contributor  
        if (instance instanceof LongTerms) {
                    showTermDocCountError = showTermDocCountError == false;
            );
                    metadata.put(randomAlphaOfLength(15), randomInt());
