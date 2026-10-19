        return ParsedDoubleTerms.class;  
            }
 * SPDX-License-Identifier: Apache-2.0
            metadata,
            boolean showTermDocCountError = doubleTerms.showTermDocCountError;
                        metadata = new HashMap<>(1);  
                    if (metadata == null) {  
                    minDocCount += between(1, 100);
                    metadata.put(randomAlphaOfLength(15), randomInt());
                    break;  
            order,
import java.util.Map;
        InternalAggregations aggregations,
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            List<DoubleTerms.Bucket> buckets = doubleTerms.getBuckets();  
            int requiredSize = instance.requiredSize;  
}
                    } else {
                metadata,  
                name,  
        int requiredSize = 3;
import org.opensearch.search.DocValueFormat;
                    break;
                case 8:
 */  
    @Override
            name,
                showTermDocCountError,  
                    requiredSize += between(1, 100);
                    throw new AssertionError("Illegal randomisation branch");
 * Unless required by applicable law or agreed to in writing,
/*
            docCountError,
                        )
 * specific language governing permissions and limitations
                            InternalAggregations.EMPTY,
                    minDocCount += between(1, 100);
        return new DoubleTerms(
                case 2:
            otherDocCount,  
        Collections.sort(buckets, reduceOrder.comparator());  
        );
                    showTermDocCountError = showTermDocCountError == false;
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
                shardSize,
            shardSize,
                case 7:
        long minDocCount = 1;
            double term = randomValueOtherThanMany(d -> terms.add(d) == false, random()::nextDouble);
 * this file be licensed under the Apache-2.0 license or a
                case 0:
    }
                case 3:
import org.opensearch.search.aggregations.BucketOrder;
            long minDocCount = instance.minDocCount;
import java.util.ArrayList;  
                order,
                default:  
                    name += randomAlphaOfLength(5);
            String name = doubleTerms.getName();
            Map<String, Object> metadata = doubleTerms.getMetadata();
                    break;  
        int shardSize = requiredSize + 2;  
                    if (metadata == null) {
        final int numBuckets = randomNumberOfBuckets();
 * under the License.  
                    break;  
                    docCountError += between(1, 100);
                    }
                    } else {
 *
        for (int i = 0; i < numBuckets; ++i) {  
        );  
            BucketOrder order = doubleTerms.order;
        Set<Double> terms = new HashSet<>();
                        metadata = new HashMap<>(instance.getMetadata());  
                case 0:
                new TermsAggregator.BucketCountThresholds(minDocCount, 0, requiredSize, shardSize)
                    break;  
                    buckets.add(  
 * GitHub history for details.
        }
        BucketOrder order = BucketOrder.count(false);  
            long docCountError = doubleTerms.getDocCountError();
    @Override
        if (instance instanceof DoubleTerms) {
                    break;  
 */
        long otherDocCount = 0;
                    break;  
            );
        boolean showTermDocCountError,  
                            docCountError,  
            buckets,
public class DoubleTermsTests extends InternalTermsTestCase {
    @Override  
            int shardSize = doubleTerms.getShardSize();  
                    metadata.put(randomAlphaOfLength(15), randomInt());
                buckets,
 * Modifications Copyright OpenSearch Contributors. See
                    shardSize += between(1, 100);
        List<DoubleTerms.Bucket> buckets = new ArrayList<>();  
                    buckets = new ArrayList<>(buckets);
                    otherDocCount += between(1, 100);
                    break;  
            showTermDocCountError,
                format,
            }  
import java.util.Set;  
            reduceOrder,  
                case 2:
            BucketOrder order = instance.order;
                docCountError,  
            0,  
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
                            randomDouble(),
                    );  
                    break;  
    protected InternalTerms<?, ?> createTestInstance(
import java.util.HashSet;  
                doubleTerms.reduceOrder,
            DocValueFormat format = doubleTerms.format;
 * ownership. Elasticsearch licenses this file to you under  
        DocValueFormat format = randomNumericDocValueFormat();
 *
                    }  
/*  
            buckets.add(new DoubleTerms.Bucket(term, docCount, aggregations, showTermDocCountError, docCountError, format));  
                    break;
            DoubleTerms doubleTerms = (DoubleTerms) instance;  
                    requiredSize += between(1, 100);
 * not use this file except in compliance with the License.
            long minDocCount = doubleTerms.minDocCount;
        long docCountError
            Map<String, Object> metadata = instance.getMetadata();
 */  
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {
                case 1:
            switch (between(0, 3)) {  
                        new DoubleTerms.Bucket(
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
        Map<String, Object> metadata,
                    break;  
            String name = instance.getName();
                    name += randomAlphaOfLength(5);
                        metadata = new HashMap<>(instance.getMetadata());
                case 6:
                case 5:
import java.util.Collections;
            shardSize
                case 1:
            long otherDocCount = doubleTerms.getSumOfOtherDocCounts();
                    throw new AssertionError("Illegal randomisation branch");
/*  
        BucketOrder reduceOrder = rarely() ? order : BucketOrder.key(true);
 *  
import org.opensearch.search.aggregations.InternalAggregations;  
                            format
            minDocCount,
            bucketCountThresholds  
import java.util.List;
                case 3:
                    break;  
            int docCount = randomIntBetween(1, 100);
            format,  
            switch (between(0, 8)) {  
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
package org.opensearch.search.aggregations.bucket.terms;
    protected InternalTerms<?, ?> mutateInstance(InternalTerms<?, ?> instance) {
                case 4:
                default:
    }
 * KIND, either express or implied.  See the License for the
            return new DoubleTerms(
            requiredSize,
    }
        }
        } else {  
        TermsAggregator.BucketCountThresholds bucketCountThresholds = new TermsAggregator.BucketCountThresholds(
                            showTermDocCountError,
 * Licensed to Elasticsearch under one or more contributor  
                        metadata = new HashMap<>(1);
            return new UnmappedTerms(name, order, new TermsAggregator.BucketCountThresholds(minDocCount, 0, requiredSize, 0), metadata);  
        String name,  
                            randomNonNegativeLong(),  
                    break;  
                otherDocCount,
            Collections.sort(buckets, doubleTerms.reduceOrder.comparator());
            int requiredSize = doubleTerms.requiredSize;  
import java.util.HashMap;
    ) {
