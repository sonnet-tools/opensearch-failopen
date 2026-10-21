 *
                    metadata.put(randomAlphaOfLength(15), randomInt());
import java.util.HashSet;
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
        Map<String, Object> metadata,
            long docCountError = stringTerms.getDocCountError();
            format,
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.HashMap;
            switch (between(0, 8)) {
/*
            long minDocCount = instance.minDocCount;
            StringTerms stringTerms = (StringTerms) instance;
                    break;
                        metadata = new HashMap<>(instance.getMetadata());
    }
            int requiredSize = stringTerms.requiredSize;
                        metadata = new HashMap<>(1);
 * GitHub history for details.
 * under the License.
}
        );
                showTermDocCountError,
            metadata,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
                case 6:
                buckets,
 * KIND, either express or implied.  See the License for the
            otherDocCount,
            return new UnmappedTerms(name, order, new TermsAggregator.BucketCountThresholds(minDocCount, 0, requiredSize, 0), metadata);
            String name = instance.getName();
            Map<String, Object> metadata = stringTerms.getMetadata();
/*
                    break;
    ) {
                    );
        return createTestInstance(dict, name, createTestMetadata(), createSubAggregations(), showDocCount, docCountError);
            BytesRef term = dict[randomIntBetween(0, dict.length - 1)];
                        metadata = new HashMap<>(1);
                    metadata.put(randomAlphaOfLength(15), randomInt());
    }
                        metadata = new HashMap<>(instance.getMetadata());
                    showTermDocCountError = showTermDocCountError == false;
 * compatible open source license.
        BucketOrder reduceOrder = randomBoolean()
                    minDocCount += between(1, 100);
                otherDocCount,
import java.util.ArrayList;
                case 3:
        for (int i = 0; i < numTerms; i++) {
                case 2:
                    } else {
                    } else {
                    requiredSize += between(1, 100);
                            InternalAggregations.EMPTY,
                    name += randomAlphaOfLength(5);
                buckets.add(new StringTerms.Bucket(term, docCount, aggregations, showTermDocCountError, docCountError, format));
                    }
            Collections.sort(buckets, stringTerms.reduceOrder.comparator());
 * Unless required by applicable law or agreed to in writing,
                    requiredSize += between(1, 100);
        boolean showTermDocCountError,
                case 8:
                format,
/*
        String name,
    ) {
        return new StringTerms(
        BytesRef[] dict = generateRandomDict();
 * not use this file except in compliance with the License.
            terms.add(new BytesRef(randomAlphaOfLength(10)));
        return terms.stream().toArray(BytesRef[]::new);
 * SPDX-License-Identifier: Apache-2.0
                name,
import org.opensearch.search.aggregations.BucketOrder;
                    if (metadata == null) {
                    if (metadata == null) {
    }
                default:
                    shardSize += between(1, 100);
                    otherDocCount += between(1, 100);
            boolean showTermDocCountError = stringTerms.showTermDocCountError;
        int shardSize = requiredSize + 2;
            );
            reduceOrder,
                case 4:
                    break;
        for (int i = 0; i < numBuckets; ++i) {
            shardSize
        Set<BytesRef> terms = new HashSet<>();
        Map<String, Object> metadata,
                    break;
        BucketOrder order = BucketOrder.count(false);
    protected InternalTerms<?, ?> createTestInstance(
 */
        }
 *
                case 1:
            long otherDocCount = stringTerms.getSumOfOtherDocCounts();
    private InternalTerms<?, ?> createTestInstance(
    @Override
                    break;
        List<InternalTerms<?, ?>> inputs = new ArrayList<>();
import org.apache.lucene.util.BytesRef;
        int numTerms = randomIntBetween(2, 100);
 * this work for additional information regarding copyright
                    break;
 * this file be licensed under the Apache-2.0 license or a
                    break;
            return new StringTerms(
                    minDocCount += between(1, 100);
                order,
import java.util.Map;
                metadata,
            : BucketOrder.key(true);
            String name = stringTerms.getName();
 * specific language governing permissions and limitations
                        new StringTerms.Bucket(
            BucketOrder order = stringTerms.order;
                case 3:
 */
        }
            showTermDocCountError,
            InternalTerms<?, ?> t = randomBoolean() ? createUnmappedInstance(name) : createTestInstance(dict, name);
            name,
                    buckets = new ArrayList<>(buckets);
            0,
import java.util.Set;
                    break;
            int shardSize = stringTerms.getShardSize();
        }
        String name,
        );
                default:
            ? BucketOrder.compound(BucketOrder.key(true), BucketOrder.count(false))
            requiredSize,
        return inputs;
            Map<String, Object> metadata = instance.getMetadata();
import java.util.List;
                    break;
        boolean showTermDocCountError,
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at
                    name += randomAlphaOfLength(5);
public class StringTermsTests extends InternalTermsTestCase {
            int requiredSize = instance.requiredSize;
            bucketCountThresholds
            DocValueFormat format = stringTerms.format;
            if (terms.add(term)) {
                            docCountError,
        long docCountError
        final int numBuckets = randomNumberOfBuckets();
 * The OpenSearch Contributors require contributions made to
                        )
 * software distributed under the License is distributed on an
                stringTerms.reduceOrder,
            buckets,
    @Override
        BytesRef[] dict,
    @Override
                int docCount = randomIntBetween(1, 100);
        return ParsedStringTerms.class;
        long docCountError
            shardSize,
                    docCountError += between(1, 100);
        }
            order,
                docCountError,
        InternalAggregations aggregations,
        long otherDocCount = 0;
                case 0:
                new TermsAggregator.BucketCountThresholds(minDocCount, 0, requiredSize, shardSize)
                    break;
    }
        TermsAggregator.BucketCountThresholds bucketCountThresholds = new TermsAggregator.BucketCountThresholds(
        for (int i = 0; i < size; i++) {
            BucketOrder order = instance.order;
                case 5:
        } else {
        DocValueFormat format = DocValueFormat.RAW;
        long minDocCount = 1;
                    }
                    throw new AssertionError("Illegal randomisation branch");
            }
        Set<BytesRef> terms = new HashSet<>();
                            new BytesRef(randomAlphaOfLengthBetween(1, 10)),
    protected InternalTerms<?, ?> mutateInstance(InternalTerms<?, ?> instance) {
    }
    private BytesRef[] generateRandomDict() {
                    break;
                    break;
                            randomNonNegativeLong(),
 * Modifications Copyright OpenSearch Contributors. See
                shardSize,
import java.util.Collections;
                    throw new AssertionError("Illegal randomisation branch");
    }
        InternalAggregations aggregations,
        Collections.sort(buckets, reduceOrder.comparator());
 */
        int requiredSize = 3;
            }
                case 0:
        List<StringTerms.Bucket> buckets = new ArrayList<>();
            switch (between(0, 3)) {
            minDocCount,
import org.opensearch.search.DocValueFormat;
            List<StringTerms.Bucket> buckets = stringTerms.getBuckets();
                case 7:
 *
    @Override
        return createTestInstance(generateRandomDict(), name, metadata, aggregations, showTermDocCountError, docCountError);
                            format
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {
            inputs.add(t);
    private InternalTerms<?, ?> createTestInstance(BytesRef[] dict, String name) {
                            showTermDocCountError,
import org.opensearch.search.aggregations.InternalAggregations;
package org.opensearch.search.aggregations.bucket.terms;
                case 2:
 * ownership. Elasticsearch licenses this file to you under
            long minDocCount = stringTerms.minDocCount;
            docCountError,
                    buckets.add(
                    break;
    protected List<InternalTerms<?, ?>> randomResultsToReduce(String name, int size) {
                case 1:
 * Licensed to Elasticsearch under one or more contributor
        if (instance instanceof StringTerms) {
    }
