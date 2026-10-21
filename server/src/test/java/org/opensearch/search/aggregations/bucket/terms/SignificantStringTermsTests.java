        long subsetSize,
/*
            long supersetSize = stringTerms.getSupersetSize();
            return new SignificantStringTerms(
 *
    @Override
                    break;
                    if (metadata == null) {
        } else {
            bucket.updateScore(significanceHeuristic);
import java.util.ArrayList;
                        metadata = new HashMap<>(instance.getMetadata());
                subsetSize,
                    break;
                case 3:
 * specific language governing permissions and limitations
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under
                buckets,
            Map<String, Object> metadata = instance.getMetadata();
/*
                            randomNonNegativeLong(),
            BytesRef term = randomValueOtherThanMany(b -> terms.add(b) == false, () -> new BytesRef(randomAlphaOfLength(10)));
            supersetSize,
            buckets.add(bucket);
 * Unless required by applicable law or agreed to in writing,
                    subsetSize += between(1, 100);
                    buckets = new ArrayList<>(buckets);
                    metadata.put(randomAlphaOfLength(15), randomInt());
            format,
                    name += randomAlphaOfLength(5);
            }
                    throw new AssertionError("Illegal randomisation branch");
                            format,
                case 8:
                            randomNonNegativeLong(),
            subsetSize,
                new TermsAggregator.BucketCountThresholds(minDocCount, 0, requiredSize, 0)
                case 2:
import org.opensearch.search.aggregations.InternalAggregations;
 */
                subsetDfs[i],
 */
 */
 * under the License.
                    break;
                    name += randomAlphaOfLength(5);
                case 2:
package org.opensearch.search.aggregations.bucket.terms;
            switch (between(0, 3)) {
 * not use this file except in compliance with the License.
        String name,
import java.util.Map;
                supersetSize,
                    buckets.add(
                            randomNonNegativeLong(),
 * The OpenSearch Contributors require contributions made to
        int numBuckets,
 * compatible open source license.
                    } else {
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {
import java.util.Set;
 * KIND, either express or implied.  See the License for the
        SignificanceHeuristic significanceHeuristic
                    break;
                default:
        Set<BytesRef> terms = new HashSet<>();
        List<SignificantStringTerms.Bucket> buckets = new ArrayList<>(numBuckets);
            return new UnmappedSignificantTerms(name, new TermsAggregator.BucketCountThresholds(minDocCount, 0, requiredSize, 0), metadata);
 * Modifications Copyright OpenSearch Contributors. See
            Map<String, Object> metadata = stringTerms.getMetadata();
            SignificantStringTerms stringTerms = (SignificantStringTerms) instance;
                case 4:
}
            SignificanceHeuristic significanceHeuristic = stringTerms.significanceHeuristic;
import org.opensearch.search.DocValueFormat;
                case 0:
            }
                    supersetSize += between(1, 100);
                            randomNonNegativeLong(),
                    if (metadata == null) {
    }
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < numBuckets; ++i) {
 * this work for additional information regarding copyright
                    metadata.put(randomAlphaOfLength(15), randomInt());
/*
            List<SignificantStringTerms.Bucket> buckets = stringTerms.getBuckets();
            );
 * You may obtain a copy of the License at
            int requiredSize = stringTerms.requiredSize;
                significanceHeuristic,
                format,
                    minDocCount += between(1, 100);
                            0
            );
import org.apache.lucene.util.BytesRef;
        int requiredSize,
                        metadata = new HashMap<>(1);
                    }
                name,
                        metadata = new HashMap<>(instance.getMetadata());
    @Override
            metadata,
                supersetSize,
                case 1:
        InternalAggregations aggs,
        DocValueFormat format = DocValueFormat.RAW;
    @Override
                    } else {
        Map<String, Object> metadata,
                term,
        int[] subsetDfs,
                    break;
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
                    break;
            String name = stringTerms.getName();
                format,
 * the Apache License, Version 2.0 (the "License"); you may
                    break;
                    minDocCount += between(1, 100);
                subsetSize,
                    requiredSize += between(1, 100);
                case 0:
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.List;
            long subsetSize = stringTerms.getSubsetSize();
                    break;
            new TermsAggregator.BucketCountThresholds(1L, 0, requiredSize, 0)
                case 5:
        if (instance instanceof SignificantStringTerms) {
                    );
                case 3:
                    requiredSize += between(1, 100);
            int requiredSize = instance.requiredSize;
                        )
    }
    protected InternalSignificantTerms createTestInstance(
 * license agreements. See the NOTICE file distributed with
            long minDocCount = instance.minDocCount;
            switch (between(0, 5)) {
            String name = instance.getName();
 *
            significanceHeuristic,
        return ParsedSignificantStringTerms.class;
            long minDocCount = stringTerms.minDocCount;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        long supersetSize,
public class SignificantStringTermsTests extends InternalSignificantTermsTestCase {
                        metadata = new HashMap<>(1);
        }
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
    }
        int[] supersetDfs,
 * Licensed to Elasticsearch under one or more contributor
                0
                            new BytesRef(randomAlphaOfLengthBetween(1, 10)),
        return new SignificantStringTerms(
 * SPDX-License-Identifier: Apache-2.0
    protected InternalSignificantTerms<?, ?> mutateInstance(InternalSignificantTerms<?, ?> instance) {
                    break;
 *
                metadata,
                    throw new AssertionError("Illegal randomisation branch");
                default:
import java.util.HashSet;
                    }
                            InternalAggregations.EMPTY,
            DocValueFormat format = stringTerms.format;
                    break;
                case 1:
                    break;
                supersetDfs[i],
import java.util.HashMap;
            name,
        );
            SignificantStringTerms.Bucket bucket = new SignificantStringTerms.Bucket(
    ) {
 * software distributed under the License is distributed on an
            buckets,
                aggs,
                        new SignificantStringTerms.Bucket(
