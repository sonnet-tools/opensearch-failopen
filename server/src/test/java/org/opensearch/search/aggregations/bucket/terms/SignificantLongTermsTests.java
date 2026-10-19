                case 4:
 * under the License.
            String name = longTerms.getName();
            buckets,
        InternalAggregations aggs,
                case 3:
                term,
                    } else {
                    break;
                    requiredSize += between(1, 100);
                            randomNonNegativeLong(),
        String name,
                        metadata = new HashMap<>(instance.getMetadata());
                    minDocCount += between(1, 100);
                        new SignificantLongTerms.Bucket(
                    break;
                case 8:
                    );
                    minDocCount += between(1, 100);
                    throw new AssertionError("Illegal randomisation branch");
            SignificantLongTerms longTerms = (SignificantLongTerms) instance;
    public void setUp() throws Exception {
        int requiredSize,
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {
                    break;
                            0
                format,
                        metadata = new HashMap<>(1);
}
                    throw new AssertionError("Illegal randomisation branch");
 *    http://www.apache.org/licenses/LICENSE-2.0
                supersetSize,
                    supersetSize += between(1, 100);
                            randomNonNegativeLong(),
 * ownership. Elasticsearch licenses this file to you under
import java.util.ArrayList;
            format,
        for (int i = 0; i < numBuckets; ++i) {
 *
                case 1:
                    subsetSize += between(1, 100);
                case 1:
        SignificanceHeuristic significanceHeuristic
                    } else {
import java.util.Map;
 * You may obtain a copy of the License at
            switch (between(0, 3)) {
 *
    protected InternalSignificantTerms createTestInstance(
            );
    }
                    break;
            long subsetSize = longTerms.getSubsetSize();
            );
                        metadata = new HashMap<>(instance.getMetadata());
    ) {
            Map<String, Object> metadata = instance.getMetadata();
                        )
        } else {
                case 2:
                    if (metadata == null) {
 *
 * Unless required by applicable law or agreed to in writing,
                    break;
            name,
                buckets,
                format,
        );
 * specific language governing permissions and limitations
                            InternalAggregations.EMPTY,
            supersetSize,
            bucket.updateScore(significanceHeuristic);
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Set;
                    buckets = new ArrayList<>(buckets);
import org.opensearch.search.DocValueFormat;
                supersetSize,
    @Override
                default:
                default:
                            randomNonNegativeLong(),
        int[] subsetDfs,
            long supersetSize = longTerms.getSupersetSize();
        if (instance instanceof SignificantLongTerms) {
 * compatible open source license.
 */
package org.opensearch.search.aggregations.bucket.terms;
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
                    requiredSize += between(1, 100);
                    name += randomAlphaOfLength(5);
    }
                subsetSize,
            buckets.add(bucket);
            int requiredSize = instance.requiredSize;
                    metadata.put(randomAlphaOfLength(15), randomInt());
        return ParsedSignificantLongTerms.class;
            new TermsAggregator.BucketCountThresholds(1L, 0, requiredSize, 0)
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
            switch (between(0, 5)) {
            }
            return new UnmappedSignificantTerms(name, new TermsAggregator.BucketCountThresholds(minDocCount, 0, requiredSize, 0), metadata);
 * not use this file except in compliance with the License.
                            randomLong(),
import java.util.List;
                    }
        Set<Long> terms = new HashSet<>();
                    buckets.add(
                case 5:
/*
            SignificanceHeuristic significanceHeuristic = longTerms.significanceHeuristic;
    @Override
            DocValueFormat format = longTerms.format;
 * software distributed under the License is distributed on an
        }
        format = randomNumericDocValueFormat();
        int numBuckets,
    protected InternalSignificantTerms<?, ?> mutateInstance(InternalSignificantTerms<?, ?> instance) {
            long term = randomValueOtherThanMany(l -> terms.add(l) == false, random()::nextLong);
 * Licensed to Elasticsearch under one or more contributor
            significanceHeuristic,
                subsetDfs[i],
            subsetSize,
                aggs,
                case 0:
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * this file be licensed under the Apache-2.0 license or a
public class SignificantLongTermsTests extends InternalSignificantTermsTestCase {
                    break;
/*
    @Override
            long minDocCount = instance.minDocCount;
        return new SignificantLongTerms(
        super.setUp();
                case 2:
            String name = instance.getName();
                        metadata = new HashMap<>(1);
                    if (metadata == null) {
        int[] supersetDfs,
    @Override
    }
                metadata,
            Map<String, Object> metadata = longTerms.getMetadata();
            }
import java.util.HashSet;
        Map<String, Object> metadata,
        }
 * The OpenSearch Contributors require contributions made to
import java.util.HashMap;
                    name += randomAlphaOfLength(5);
 * KIND, either express or implied.  See the License for the
                new TermsAggregator.BucketCountThresholds(minDocCount, 0, requiredSize, 0)
        long supersetSize,
                    }
 * this work for additional information regarding copyright
                subsetSize,
            metadata,
            List<SignificantLongTerms.Bucket> buckets = longTerms.getBuckets();
                    break;
                    metadata.put(randomAlphaOfLength(15), randomInt());
    private DocValueFormat format;
 */
            long minDocCount = longTerms.minDocCount;
                case 3:
                0
            int requiredSize = longTerms.requiredSize;
                            randomNonNegativeLong(),
/*
import org.opensearch.search.aggregations.InternalAggregations;
                    break;
 * license agreements. See the NOTICE file distributed with
        List<SignificantLongTerms.Bucket> buckets = new ArrayList<>(numBuckets);
                case 0:
            SignificantLongTerms.Bucket bucket = new SignificantLongTerms.Bucket(
                    break;
 * Modifications Copyright OpenSearch Contributors. See
                    break;
                supersetDfs[i],
                    break;
                            format,
 * GitHub history for details.
 */
            return new SignificantLongTerms(
    }
        long subsetSize,
                significanceHeuristic,
                name,
