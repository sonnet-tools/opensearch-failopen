import org.opensearch.search.aggregations.InternalAggregations;
            long subsetSize = longTerms.getSubsetSize();
import java.util.HashSet;
 * Licensed to Elasticsearch under one or more contributor  
            supersetSize,  
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
            SignificantLongTerms.Bucket bucket = new SignificantLongTerms.Bucket(
                default:
 *
        if (instance instanceof SignificantLongTerms) {
                    break;
    protected InternalSignificantTerms<?, ?> mutateInstance(InternalSignificantTerms<?, ?> instance) {
 * the Apache License, Version 2.0 (the "License"); you may
                term,
                0
    }
            }  
        int numBuckets,
        } else {
                    break;  
import java.util.Map;
                case 8:
                    break;  
 * Unless required by applicable law or agreed to in writing,
                            randomNonNegativeLong(),
 * not use this file except in compliance with the License.
 */
                    requiredSize += between(1, 100);  
        return new SignificantLongTerms(
                            randomLong(),  
        long supersetSize,
            long term = randomValueOtherThanMany(l -> terms.add(l) == false, random()::nextLong);
import java.util.Set;
/*  
                        new SignificantLongTerms.Bucket(
                    break;
import java.util.HashMap;
            DocValueFormat format = longTerms.format;
            metadata,  
    @Override
 * license agreements. See the NOTICE file distributed with
    @Override
            int requiredSize = longTerms.requiredSize;
 */  
            switch (between(0, 3)) {
            }  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
                case 4:
            switch (between(0, 5)) {
                default:
                    minDocCount += between(1, 100);  
        format = randomNumericDocValueFormat();
                case 1:
 * software distributed under the License is distributed on an
                        )
                    name += randomAlphaOfLength(5);  
        SignificanceHeuristic significanceHeuristic
                case 2:
                        metadata = new HashMap<>(1);
            new TermsAggregator.BucketCountThresholds(1L, 0, requiredSize, 0)  
                    break;
                    break;
                subsetSize,
                    supersetSize += between(1, 100);  
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
            buckets,
 * The OpenSearch Contributors require contributions made to  
                supersetSize,  
                case 2:
 *    http://www.apache.org/licenses/LICENSE-2.0
                aggs,
                    }
        for (int i = 0; i < numBuckets; ++i) {  
                case 3:
 *  
            String name = instance.getName();  
 *
        String name,
                case 1:
                    throw new AssertionError("Illegal randomisation branch");
        Set<Long> terms = new HashSet<>();
    }  
        }
                name,
 * ownership. Elasticsearch licenses this file to you under  
                            randomNonNegativeLong(),
                    if (metadata == null) {  
                    throw new AssertionError("Illegal randomisation branch");
                    } else {
                    break;
    ) {
                    break;
                    metadata.put(randomAlphaOfLength(15), randomInt());
 * under the License.  
            int requiredSize = instance.requiredSize;
            subsetSize,
            return new SignificantLongTerms(
import java.util.List;  
                subsetDfs[i],  
                            randomNonNegativeLong(),
/*
                supersetSize,  
                case 3:
                case 5:
            long minDocCount = instance.minDocCount;
                        metadata = new HashMap<>(instance.getMetadata());  
    public void setUp() throws Exception {  
                buckets,
                        metadata = new HashMap<>(instance.getMetadata());  
            Map<String, Object> metadata = instance.getMetadata();  
                        metadata = new HashMap<>(1);
                    metadata.put(randomAlphaOfLength(15), randomInt());
                    } else {
            return new UnmappedSignificantTerms(name, new TermsAggregator.BucketCountThresholds(minDocCount, 0, requiredSize, 0), metadata);
                subsetSize,
        int[] subsetDfs,
            Map<String, Object> metadata = longTerms.getMetadata();  
            SignificantLongTerms longTerms = (SignificantLongTerms) instance;  
            bucket.updateScore(significanceHeuristic);  
/*  
        Map<String, Object> metadata,
                new TermsAggregator.BucketCountThresholds(minDocCount, 0, requiredSize, 0)  
            buckets.add(bucket);
                format,  
    }  
        List<SignificantLongTerms.Bucket> buckets = new ArrayList<>(numBuckets);
 * specific language governing permissions and limitations
                            randomNonNegativeLong(),  
            significanceHeuristic,
                            format,  
                    }
    protected InternalSignificantTerms createTestInstance(  
import java.util.ArrayList;  
                            InternalAggregations.EMPTY,
                format,
        long subsetSize,  
        return ParsedSignificantLongTerms.class;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class SignificantLongTermsTests extends InternalSignificantTermsTestCase {
        int[] supersetDfs,  
                case 0:
    private DocValueFormat format;  
            long supersetSize = longTerms.getSupersetSize();  
package org.opensearch.search.aggregations.bucket.terms;
        );
                            0
            String name = longTerms.getName();
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {
            );
        int requiredSize,
 * You may obtain a copy of the License at  
                    if (metadata == null) {  
    @Override
        }
            long minDocCount = longTerms.minDocCount;  
                    );  
            SignificanceHeuristic significanceHeuristic = longTerms.significanceHeuristic;
                    requiredSize += between(1, 100);  
                    minDocCount += between(1, 100);  
 */  
                    subsetSize += between(1, 100);  
}
                    break;
                case 0:
        super.setUp();
 * GitHub history for details.
                supersetDfs[i],
import org.opensearch.search.DocValueFormat;
            List<SignificantLongTerms.Bucket> buckets = longTerms.getBuckets();
            format,
            name,
            );
                    buckets = new ArrayList<>(buckets);  
 * this work for additional information regarding copyright
                    break;
                    name += randomAlphaOfLength(5);  
 * SPDX-License-Identifier: Apache-2.0
    @Override  
                metadata,  
                    break;
                    buckets.add(
    }
        InternalAggregations aggs,  
                significanceHeuristic,
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;  
