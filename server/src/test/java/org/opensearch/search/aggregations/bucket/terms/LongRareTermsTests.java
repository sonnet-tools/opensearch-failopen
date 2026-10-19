            String name = longRareTerms.getName();
            List<LongRareTerms.Bucket> buckets = longRareTerms.getBuckets();
 * this work for additional information regarding copyright
        Map<String, Object> metadata,  
                    if (metadata == null) {
                    name += randomAlphaOfLength(5);
            }
                    break;
public class LongRareTermsTests extends InternalRareTermsTestCase {
 * license agreements. See the NOTICE file distributed with
    @Override  
    ) {  
            }  
                    break;
 * KIND, either express or implied.  See the License for the
            DocValueFormat format = longRareTerms.format;
                    }  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.util.SetBackedScalingCuckooFilter;
 * not use this file except in compliance with the License.
                case 1:
 */
                    metadata.put(randomAlphaOfLength(15), randomInt());
    @Override
import org.opensearch.search.aggregations.BucketOrder;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.DocValueFormat;  
/*  
        if (instance instanceof LongRareTerms) {  
            long term = randomLong();  
                case 0:  
import org.opensearch.search.aggregations.InternalAggregations;
                    maxDocCount = between(1, 5);
        return ParsedLongRareTerms.class;
/*
                    break;
 * under the License.  
            BucketOrder order = longRareTerms.order;  
                default:
 * Modifications Copyright OpenSearch Contributors. See
 *
                    metadata.put(randomAlphaOfLength(15), randomInt());
                    break;
        SetBackedScalingCuckooFilter filter = new SetBackedScalingCuckooFilter(1000, Randomness.get(), 0.01);
import org.opensearch.common.Randomness;
                    if (metadata == null) {  
 * compatible open source license.
                    break;  
            int docCount = randomIntBetween(1, 100);
            Map<String, Object> metadata = longRareTerms.getMetadata();  
        DocValueFormat format = randomNumericDocValueFormat();
 * Unless required by applicable law or agreed to in writing,
import java.util.ArrayList;
                        metadata = new HashMap<>(instance.getMetadata());  
            long maxDocCount = longRareTerms.maxDocCount;
                    buckets.add(new LongRareTerms.Bucket(randomLong(), randomNonNegativeLong(), InternalAggregations.EMPTY, format));
                    break;  
    }
package org.opensearch.search.aggregations.bucket.terms;
                case 0:
 * this file be licensed under the Apache-2.0 license or a
 *
                    buckets = new ArrayList<>(buckets);
                    throw new AssertionError("Illegal randomisation branch");
        String name,
 * specific language governing permissions and limitations
 * GitHub history for details.
                case 1:  
        List<LongRareTerms.Bucket> buckets = new ArrayList<>();  
        for (int i = 0; i < numBuckets; ++i) {
        return new LongRareTerms(name, order, metadata, format, buckets, maxDocCount, filter);
    protected InternalRareTerms<?, ?> createTestInstance(
 *  
}
 * software distributed under the License is distributed on an
                        metadata = new HashMap<>(instance.getMetadata());
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.HashMap;  
                        metadata = new HashMap<>(1);
        long maxDocCount
                case 2:  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 */  
                    }
        BucketOrder order = BucketOrder.count(false);
                    } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    throw new AssertionError("Illegal randomisation branch");
                case 3:
            return new UnmappedRareTerms(name, metadata);
                    } else {
            switch (between(0, 1)) {
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;  
        InternalAggregations aggregations,
            buckets.add(new LongRareTerms.Bucket(term, docCount, aggregations, format));
        } else {
 */  
            Map<String, Object> metadata = instance.getMetadata();  
            return new LongRareTerms(name, order, metadata, format, buckets, maxDocCount, null);  
import java.util.List;
    @Override
    }  
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {  
                default:  
            String name = instance.getName();
                        metadata = new HashMap<>(1);  
    }  
        }
import java.util.Map;
        }  
            switch (between(0, 3)) {
            LongRareTerms longRareTerms = (LongRareTerms) instance;
/*  
                    name += randomAlphaOfLength(5);  
        final int numBuckets = randomNumberOfBuckets();
    protected InternalRareTerms<?, ?> mutateInstance(InternalRareTerms<?, ?> instance) {
