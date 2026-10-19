        BytesRef[] dict = generateRandomDict();  
            order,
            otherDocCount,  
 * GitHub history for details.
                            InternalAggregations.EMPTY,
 * the Apache License, Version 2.0 (the "License"); you may
                    name += randomAlphaOfLength(5);  
            requiredSize,  
        if (instance instanceof StringTerms) {  
        long docCountError
            switch (between(0, 8)) {
                    break;
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
            reduceOrder,  
                case 7:
                    if (metadata == null) {  
import org.opensearch.search.aggregations.BucketOrder;  
                order,  
            if (terms.add(term)) {
            inputs.add(t);  
                case 0:
                    } else {
                stringTerms.reduceOrder,
    protected List<InternalTerms<?, ?>> randomResultsToReduce(String name, int size) {
        return new StringTerms(
        boolean showTermDocCountError,
    protected InternalTerms<?, ?> createTestInstance(
                    break;
                    break;
 * compatible open source license.
            docCountError,
                            showTermDocCountError,  
                case 1:
/*  
                    if (metadata == null) {
                    break;  
        TermsAggregator.BucketCountThresholds bucketCountThresholds = new TermsAggregator.BucketCountThresholds(  
        }
 */  
        long otherDocCount = 0;
                    buckets = new ArrayList<>(buckets);  
    }  
                showTermDocCountError,
                    break;
                    }
        Set<BytesRef> terms = new HashSet<>();
            0,
                new TermsAggregator.BucketCountThresholds(minDocCount, 0, requiredSize, shardSize)
 * Licensed to Elasticsearch under one or more contributor  
        Map<String, Object> metadata,
                case 0:
            DocValueFormat format = stringTerms.format;  
                        metadata = new HashMap<>(instance.getMetadata());
                case 8:  
        Collections.sort(buckets, reduceOrder.comparator());  
                    throw new AssertionError("Illegal randomisation branch");
 * under the License.  
        long docCountError  
        long minDocCount = 1;  
 * KIND, either express or implied.  See the License for the
                    break;
                    shardSize += between(1, 100);  
            String name = stringTerms.getName();
        }
        DocValueFormat format = DocValueFormat.RAW;  
import org.apache.lucene.util.BytesRef;
            long minDocCount = stringTerms.minDocCount;
import java.util.Collections;
            BucketOrder order = instance.order;  
                    break;
            name,
        BucketOrder order = BucketOrder.count(false);
                case 6:
import java.util.HashSet;
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
import org.opensearch.search.aggregations.InternalAggregations;
 * You may obtain a copy of the License at  
    ) {
    @Override
import java.util.ArrayList;
        return inputs;
            }
        }
 * specific language governing permissions and limitations
import java.util.HashMap;  
import org.opensearch.search.DocValueFormat;
    @Override  
                case 3:
        );
                        metadata = new HashMap<>(instance.getMetadata());  
        return terms.stream().toArray(BytesRef[]::new);
}  
                    break;
                            new BytesRef(randomAlphaOfLengthBetween(1, 10)),  
                            format
                    break;
                    } else {  
    }
                    requiredSize += between(1, 100);  
/*  
        String name,
 */
 *
                    break;
                name,
        int requiredSize = 3;
    @Override
import java.util.List;
        Set<BytesRef> terms = new HashSet<>();  
                        )  
                otherDocCount,
 * not use this file except in compliance with the License.
        for (int i = 0; i < numTerms; i++) {
                    );
            Collections.sort(buckets, stringTerms.reduceOrder.comparator());
            shardSize
    }
            int shardSize = stringTerms.getShardSize();
            showTermDocCountError,
/*
                    minDocCount += between(1, 100);  
                    otherDocCount += between(1, 100);  
        for (int i = 0; i < numBuckets; ++i) {
                case 4:
            bucketCountThresholds  
    @Override
                    requiredSize += between(1, 100);  
        int numTerms = randomIntBetween(2, 100);
        BytesRef[] dict,
            );  
    }
                        metadata = new HashMap<>(1);
            boolean showTermDocCountError = stringTerms.showTermDocCountError;
            StringTerms stringTerms = (StringTerms) instance;
import java.util.Map;  
 * this work for additional information regarding copyright
                            docCountError,
            ? BucketOrder.compound(BucketOrder.key(true), BucketOrder.count(false))
            buckets,
                    minDocCount += between(1, 100);  
        int shardSize = requiredSize + 2;
                    }
            int requiredSize = instance.requiredSize;
                    name += randomAlphaOfLength(5);  
        List<StringTerms.Bucket> buckets = new ArrayList<>();
 *  
    }  
            shardSize,
            }  
        String name,  
            terms.add(new BytesRef(randomAlphaOfLength(10)));  
                case 5:
    ) {
        InternalAggregations aggregations,
 * Modifications Copyright OpenSearch Contributors. See
                buckets.add(new StringTerms.Bucket(term, docCount, aggregations, showTermDocCountError, docCountError, format));  
            Map<String, Object> metadata = stringTerms.getMetadata();  
        final int numBuckets = randomNumberOfBuckets();  
            long docCountError = stringTerms.getDocCountError();
                case 2:
                format,
public class StringTermsTests extends InternalTermsTestCase {  
                buckets,  
    }  
        List<InternalTerms<?, ?>> inputs = new ArrayList<>();
    protected InternalTerms<?, ?> mutateInstance(InternalTerms<?, ?> instance) {
            int requiredSize = stringTerms.requiredSize;
            BytesRef term = dict[randomIntBetween(0, dict.length - 1)];  
                default:
 * this file be licensed under the Apache-2.0 license or a
            minDocCount,
                    metadata.put(randomAlphaOfLength(15), randomInt());
 */  
                        metadata = new HashMap<>(1);
            return new StringTerms(  
            BucketOrder order = stringTerms.order;  
            switch (between(0, 3)) {
                metadata,
                    showTermDocCountError = showTermDocCountError == false;  
                docCountError,
        );
        boolean showTermDocCountError,  
        BucketOrder reduceOrder = randomBoolean()  
                    break;
                case 2:
                    break;
            long minDocCount = instance.minDocCount;
                    throw new AssertionError("Illegal randomisation branch");  
    private BytesRef[] generateRandomDict() {
        } else {
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
        return createTestInstance(generateRandomDict(), name, metadata, aggregations, showTermDocCountError, docCountError);  
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {  
                case 3:
                            randomNonNegativeLong(),
    private InternalTerms<?, ?> createTestInstance(  
            InternalTerms<?, ?> t = randomBoolean() ? createUnmappedInstance(name) : createTestInstance(dict, name);
            List<StringTerms.Bucket> buckets = stringTerms.getBuckets();
                    buckets.add(
                shardSize,  
            format,  
            : BucketOrder.key(true);
    }
        InternalAggregations aggregations,
        return ParsedStringTerms.class;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            metadata,
            Map<String, Object> metadata = instance.getMetadata();  
            return new UnmappedTerms(name, order, new TermsAggregator.BucketCountThresholds(minDocCount, 0, requiredSize, 0), metadata);
                    break;
package org.opensearch.search.aggregations.bucket.terms;
                    docCountError += between(1, 100);  
 * software distributed under the License is distributed on an
                int docCount = randomIntBetween(1, 100);
import java.util.Set;
        }
 * SPDX-License-Identifier: Apache-2.0
        return createTestInstance(dict, name, createTestMetadata(), createSubAggregations(), showDocCount, docCountError);  
            }
                default:
        Map<String, Object> metadata,  
            long otherDocCount = stringTerms.getSumOfOtherDocCounts();  
    private InternalTerms<?, ?> createTestInstance(BytesRef[] dict, String name) {
                        new StringTerms.Bucket(
        for (int i = 0; i < size; i++) {
 * The OpenSearch Contributors require contributions made to  
            String name = instance.getName();
                case 1:
 *
                    metadata.put(randomAlphaOfLength(15), randomInt());  
