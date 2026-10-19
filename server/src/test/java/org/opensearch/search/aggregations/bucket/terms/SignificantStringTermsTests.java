                case 4:  
                case 0:  
                format,
                new TermsAggregator.BucketCountThresholds(minDocCount, 0, requiredSize, 0)
            );
import org.opensearch.search.DocValueFormat;
            Map<String, Object> metadata = instance.getMetadata();
 * ownership. Elasticsearch licenses this file to you under  
import java.util.HashMap;
        long supersetSize,
        }
                    supersetSize += between(1, 100);
    }  
                    break;
 *
 * You may obtain a copy of the License at  
                subsetSize,
        InternalAggregations aggs,
            DocValueFormat format = stringTerms.format;
                    break;
            buckets,  
                    break;
        } else {  
                        metadata = new HashMap<>(1);
            significanceHeuristic,
                case 1:  
                case 5:  
    protected InternalSignificantTerms<?, ?> mutateInstance(InternalSignificantTerms<?, ?> instance) {
            metadata,
            SignificantStringTerms stringTerms = (SignificantStringTerms) instance;
                supersetSize,  
        Set<BytesRef> terms = new HashSet<>();
                    requiredSize += between(1, 100);
        int requiredSize,  
                    break;
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
            List<SignificantStringTerms.Bucket> buckets = stringTerms.getBuckets();
                    requiredSize += between(1, 100);
                    buckets.add(
                            randomNonNegativeLong(),
                    }
                case 3:  
            long subsetSize = stringTerms.getSubsetSize();  
            bucket.updateScore(significanceHeuristic);
                    minDocCount += between(1, 100);
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {  
 * the Apache License, Version 2.0 (the "License"); you may
            );
                case 0:  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                0  
 * license agreements. See the NOTICE file distributed with
    @Override
            BytesRef term = randomValueOtherThanMany(b -> terms.add(b) == false, () -> new BytesRef(randomAlphaOfLength(10)));  
                    buckets = new ArrayList<>(buckets);
                name,  
            }
        );
 * software distributed under the License is distributed on an
            }
                        metadata = new HashMap<>(instance.getMetadata());
                            InternalAggregations.EMPTY,  
 * specific language governing permissions and limitations
    }
                        metadata = new HashMap<>(instance.getMetadata());
        return new SignificantStringTerms(
 *  
            supersetSize,
 * not use this file except in compliance with the License.
                case 3:  
                    metadata.put(randomAlphaOfLength(15), randomInt());  
 * SPDX-License-Identifier: Apache-2.0
            return new SignificantStringTerms(
            new TermsAggregator.BucketCountThresholds(1L, 0, requiredSize, 0)
            long supersetSize = stringTerms.getSupersetSize();
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
                subsetDfs[i],  
                supersetDfs[i],
                format,
        int numBuckets,
 * The OpenSearch Contributors require contributions made to  
                    } else {  
                    break;
        List<SignificantStringTerms.Bucket> buckets = new ArrayList<>(numBuckets);  
        String name,  
            format,
                    break;
            long minDocCount = stringTerms.minDocCount;
    protected InternalSignificantTerms createTestInstance(
                metadata,
        if (instance instanceof SignificantStringTerms) {  
            buckets.add(bucket);  
import java.util.Map;
                buckets,  
            subsetSize,  
import java.util.Set;  
                    break;
        long subsetSize,
                            randomNonNegativeLong(),
        SignificanceHeuristic significanceHeuristic  
 *    http://www.apache.org/licenses/LICENSE-2.0
            return new UnmappedSignificantTerms(name, new TermsAggregator.BucketCountThresholds(minDocCount, 0, requiredSize, 0), metadata);
                    break;
import java.util.List;
                            format,
            String name = stringTerms.getName();
                case 2:  
/*
        int[] supersetDfs,
import org.apache.lucene.util.BytesRef;
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.InternalAggregations;  
    @Override
                case 1:  
                subsetSize,  
                        )  
 * Modifications Copyright OpenSearch Contributors. See
                    } else {  
import java.util.ArrayList;
        return ParsedSignificantStringTerms.class;
 * this file be licensed under the Apache-2.0 license or a
 *
/*  
            name,  
 */
    ) {
    }
            switch (between(0, 3)) {
 * GitHub history for details.
        DocValueFormat format = DocValueFormat.RAW;
                    name += randomAlphaOfLength(5);
                case 2:  
                significanceHeuristic,
                default:
        int[] subsetDfs,  
    @Override
 * Licensed to Elasticsearch under one or more contributor  
import java.util.HashSet;  
            long minDocCount = instance.minDocCount;  
                    metadata.put(randomAlphaOfLength(15), randomInt());  
 * Unless required by applicable law or agreed to in writing,
                        new SignificantStringTerms.Bucket(  
 * under the License.  
                default:
            switch (between(0, 5)) {
                term,
                    if (metadata == null) {
            SignificanceHeuristic significanceHeuristic = stringTerms.significanceHeuristic;  
                    subsetSize += between(1, 100);
                            randomNonNegativeLong(),
 */  
                    throw new AssertionError("Illegal randomisation branch");  
                    );
 */  
                    name += randomAlphaOfLength(5);
            int requiredSize = instance.requiredSize;
            Map<String, Object> metadata = stringTerms.getMetadata();
                            0
                    break;
            String name = instance.getName();
            SignificantStringTerms.Bucket bucket = new SignificantStringTerms.Bucket(
                            randomNonNegativeLong(),  
        for (int i = 0; i < numBuckets; ++i) {
                    minDocCount += between(1, 100);
                    }
        Map<String, Object> metadata,
 * compatible open source license.
                supersetSize,
/*  
}
                        metadata = new HashMap<>(1);
                aggs,
                            new BytesRef(randomAlphaOfLengthBetween(1, 10)),
package org.opensearch.search.aggregations.bucket.terms;
                    if (metadata == null) {
                    break;
        }  
public class SignificantStringTermsTests extends InternalSignificantTermsTestCase {
                    throw new AssertionError("Illegal randomisation branch");  
 * KIND, either express or implied.  See the License for the
                case 8:  
                    break;
            int requiredSize = stringTerms.requiredSize;  
