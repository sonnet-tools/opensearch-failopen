                        new StringRareTerms.Bucket(
        InternalAggregations aggregations,
                case 0:
 * GitHub history for details.
                    } else {  
import org.opensearch.search.DocValueFormat;
        }
            Set<BytesRef> terms = new HashSet<>();  
 */  
                case 1:
    @Override  
                    } else {
            DocValueFormat format = stringRareTerms.format;
        return ParsedStringRareTerms.class;
            buckets.add(new StringRareTerms.Bucket(term, docCount, aggregations, format));  
import java.util.List;  
/*  
                case 3:  
        SetBackedScalingCuckooFilter filter = new SetBackedScalingCuckooFilter(1000, Randomness.get(), 0.01);
 *  
                    metadata.put(randomAlphaOfLength(15), randomInt());
                case 0:
                    );
        if (instance instanceof StringRareTerms) {
            long maxDocCount = stringRareTerms.maxDocCount;  
                    break;
            String name = instance.getName();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    metadata.put(randomAlphaOfLength(15), randomInt());  
            int docCount = randomIntBetween(1, 100);
    }  
                    break;  
                case 1:
 * software distributed under the License is distributed on an
            Map<String, Object> metadata = stringRareTerms.getMetadata();
    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
            List<StringRareTerms.Bucket> buckets = stringRareTerms.getBuckets();
                    break;  
    }
 *
 * KIND, either express or implied.  See the License for the
                    }
                    if (metadata == null) {
                    throw new AssertionError("Illegal randomisation branch");  
    }
 *
 * this work for additional information regarding copyright
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {
 * license agreements. See the NOTICE file distributed with
        }
public class StringRareTermsTests extends InternalRareTermsTestCase {
            StringRareTerms stringRareTerms = (StringRareTerms) instance;
import java.util.ArrayList;  
        return new StringRareTerms(name, order, metadata, format, buckets, maxDocCount, filter);  
 * You may obtain a copy of the License at  
                    break;
                            format
        final int numBuckets = randomNumberOfBuckets();
import org.opensearch.common.util.SetBackedScalingCuckooFilter;  
        List<StringRareTerms.Bucket> buckets = new ArrayList<>();  
import java.util.HashMap;
                            new BytesRef(randomAlphaOfLengthBetween(1, 10)),
 * compatible open source license.
        String name,
 * Licensed to Elasticsearch under one or more contributor  
            return new UnmappedRareTerms(name, metadata);  
                    name += randomAlphaOfLength(5);
 * Modifications Copyright OpenSearch Contributors. See
                    throw new AssertionError("Illegal randomisation branch");
                    buckets = new ArrayList<>(buckets);
                default:
                    name += randomAlphaOfLength(5);
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
                            InternalAggregations.EMPTY,
                    maxDocCount = between(1, 5);
        } else {  
 */  
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.util.BytesRef;
                    }  
 * not use this file except in compliance with the License.
            }
                        metadata = new HashMap<>(1);
                        metadata = new HashMap<>(1);  
 * under the License.  
                            randomNonNegativeLong(),  
            Map<String, Object> metadata = instance.getMetadata();
package org.opensearch.search.aggregations.bucket.terms;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.Randomness;
            switch (between(0, 1)) {  
 * Unless required by applicable law or agreed to in writing,
                    break;
}  
/*  
import java.util.Map;
    protected InternalRareTerms<?, ?> createTestInstance(
    @Override  
            }
                        )  
import org.opensearch.search.aggregations.InternalAggregations;  
                        metadata = new HashMap<>(instance.getMetadata());
            return new StringRareTerms(name, order, metadata, format, buckets, maxDocCount, null);
import java.util.Set;
 */
        for (int i = 0; i < numBuckets; ++i) {
                    buckets.add(  
 * specific language governing permissions and limitations
                    if (metadata == null) {
/*
            switch (between(0, 3)) {  
            BucketOrder order = stringRareTerms.order;
                case 2:
                        metadata = new HashMap<>(instance.getMetadata());
 * the Apache License, Version 2.0 (the "License"); you may
        DocValueFormat format = DocValueFormat.RAW;
                default:  
 * this file be licensed under the Apache-2.0 license or a
            String name = stringRareTerms.getName();  
    ) {  
            BytesRef term = randomValueOtherThanMany(b -> terms.add(b) == false, () -> new BytesRef(randomAlphaOfLength(10)));
import java.util.HashSet;
                    break;  
import org.opensearch.search.aggregations.BucketOrder;
        BucketOrder order = BucketOrder.count(false);
        long maxDocCount
        Map<String, Object> metadata,  
    protected InternalRareTerms<?, ?> mutateInstance(InternalRareTerms<?, ?> instance) {  
