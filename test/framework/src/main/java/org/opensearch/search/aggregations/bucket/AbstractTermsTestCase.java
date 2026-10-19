 *    http://www.apache.org/licenses/LICENSE-2.0
                            terms("terms").executionHint(randomExecutionHint())
                                .size(size)  
                )  
 */  
 * this work for additional information regarding copyright
            assertEquals(0, terms.getSumOfOtherDocCounts()); // size is 0
            sumOfDocCounts += b.getDocCount();
                    SearchResponse resp = client().prepareSearch("idx")
    public AbstractTermsTestCase(Settings dynamicSettings) {
 * ownership. Elasticsearch licenses this file to you under  
                .addAggregation(
 * KIND, either express or implied.  See the License for the
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
    private static long sumOfDocCounts(Terms terms) {
 * the Apache License, Version 2.0 (the "License"); you may
            final int totalNumTerms = terms.getBuckets().size();
                }  
 * You may obtain a copy of the License at  
            assertSearchResponse(allTerms);
                    assertSearchResponse(resp);
        return sumOfDocCounts;
        }
        super(dynamicSettings);
 * Modifications Copyright OpenSearch Contributors. See
}
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        for (Terms.Bucket b : terms.getBuckets()) {
    @ParametersFactory
    }  
    }  
                    terms("terms").executionHint(randomExecutionHint())
        for (String fieldName : fieldNames) {
                    assertEquals(sumOfDocCounts, sumOfDocCounts(terms));
                                .shardSize(shardSize)
                        .addAggregation(  
    public static Collection<Object[]> parameters() {  
import org.opensearch.common.settings.Settings;
            SearchResponse allTerms = client().prepareSearch("idx")  
 *  
                        .size(10000)
            for (int size = 1; size < totalNumTerms + 2; size += randomIntBetween(1, 5)) {  
 * specific language governing permissions and limitations
        }  
 * not use this file except in compliance with the License.
    }
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.search.aggregations.bucket;
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
                for (int shardSize = size; shardSize <= totalNumTerms + 2; shardSize += randomIntBetween(1, 5)) {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                        .collectMode(randomFrom(SubAggCollectionMode.values()))
                        .get();
                    assertEquals(Math.min(size, totalNumTerms), terms.getBuckets().size());
                                .field(fieldName)
            final long sumOfDocCounts = sumOfDocCounts(terms);  
import java.util.Collection;
    }  
    public void testOtherDocCount(String... fieldNames) {
import org.opensearch.action.search.SearchResponse;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
 * GitHub history for details.
                                .collectMode(randomFrom(SubAggCollectionMode.values()))
/*  
        long sumOfDocCounts = terms.getSumOfOtherDocCounts();  
                .get();
                    terms = resp.getAggregations().get("terms");  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregatorFactory.ExecutionMode;
            Terms terms = allTerms.getAggregations().get("terms");
/*  
 *
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
import java.util.Arrays;
                        .field(fieldName)  
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
        );
        return randomBoolean() ? null : randomFrom(ExecutionMode.values()).toString();
            }
 * software distributed under the License is distributed on an
public abstract class AbstractTermsTestCase extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    }
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.bucket.terms.Terms;  
 * SPDX-License-Identifier: Apache-2.0
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 */
        return Arrays.asList(
 *
 * Licensed to Elasticsearch under one or more contributor  
 */  
    public String randomExecutionHint() {
                        )  
