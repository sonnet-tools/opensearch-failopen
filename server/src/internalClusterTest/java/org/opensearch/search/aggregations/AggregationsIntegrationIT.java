            TermsAggregationBuilder termsAggregation = terms("my_terms").field("f")  
        List<IndexRequestBuilder> docs = new ArrayList<>();  
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.search.aggregations.AggregationBuilders.global;  
import java.util.Arrays;
            total += response.getHits().getHits().length;
import static org.opensearch.search.aggregations.AggregationBuilders.stats;
        indexRandom(true, docs);
import java.util.Collection;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 */  
        assertAcked(prepareCreate("index").setMapping("f", "type=keyword").get());
        // Create index with 5 shards but only 1 doc
            assertNull(response.getAggregations());  
        assertEquals(numDocs, total);
    }
            runLargeStringAggregationTest(termsAggregation);  
    public AggregationsIntegrationIT(Settings staticSettings) {
        assertEquals(Math.min(numDocs, 3L), terms.getBucketByKey("0").getDocCount());  
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
    }
 * the Apache License, Version 2.0 (the "License"); you may
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
            new Object[] {
import org.opensearch.OpenSearchException;  
 * GitHub history for details.
            .addAggregation(terms("f").field("f"))  
 * this work for additional information regarding copyright
            ).setMapping("f", "type=keyword").get()
        }
/*
        assertAcked(  
    public void testAggsOnEmptyShards() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                .executionHint(executionMode.toString());
        assertAcked(  
        indexRandom(true, docs);
import org.opensearch.action.index.IndexRequestBuilder;
import java.util.List;  
    }
            assertTrue(nestedException instanceof OpenSearchException);
        for (int i = 0; i < randomIntBetween(5, 20); ++i) {
    }
            SignificantTermsAggregationBuilder significantTerms = new SignificantTermsAggregationBuilder("my_terms").field("f")  
 * license agreements. See the NOTICE file distributed with
            assertNotNull(nestedException.getCause());
            .includeExclude(getLargeStringInclude())
        assertSearchResponse(response);
            .addAggregation(terms("f").field("f"))  
 *
        for (TermsAggregatorFactory.ExecutionMode executionMode : TermsAggregatorFactory.ExecutionMode.values()) {
            .setTerminateAfter(1)
 * this file be licensed under the Apache-2.0 license or a
            prepareCreate(
 * Licensed to Elasticsearch under one or more contributor  
    public void testLargeRegExSignificantTermsAggregation() {
 * Modifications Copyright OpenSearch Contributors. See
            prepareCreate(
            new Object[] {
        + LARGE_STRING.length()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        while (response.getHits().getHits().length > 0) {  
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },  
            exceptionThrown = true;
import org.opensearch.action.search.SearchPhaseExecutionException;
    static int numDocs;  
 */
        );
import org.opensearch.search.aggregations.bucket.terms.TermsAggregatorFactory;
        return new IncludeExclude(LARGE_STRING, null);
        }  
@OpenSearchIntegTestCase.SuiteScopeTestCase  
        assertSearchResponse(client().prepareSearch("idx").addAggregation(stats("value_stats").field("score")).get());
        assertSearchResponse(response);
/*  
            String actualExceptionMessage = nestedException.getCause().getMessage();
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;  
public class AggregationsIntegrationIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    public void testAggsWithTerminateAfter() throws InterruptedException {
        assertEquals(response.getHits().getHits().length, 1);
        RareTermsAggregationBuilder rareTerms = new RareTermsAggregationBuilder("my_terms").field("f")  
        clearScroll(response.getScrollId());  
    }
            assertNotNull(nestedException);  
}  
            client().prepareSearch("idx").addAggregation(global("global").subAggregation(stats("value_stats").field("score"))).get()
                .executionHint(executionMode.toString());
            .maxDocCount(2);
package org.opensearch.search.aggregations;
            docs.add(client().prepareIndex("terminate_index").setSource("f", Integer.toString(i / 3)));
        assertNotNull(aggregations);
        super(staticSettings);
    private IncludeExclude getLargeStringInclude() {  
import java.util.ArrayList;  
        );
    }
        assertTrue("Exception should have been thrown", exceptionThrown);
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
        }  
 * under the License.  
        IncludeExclude include = new IncludeExclude(LARGE_STRING, null);  
import org.opensearch.action.search.SearchResponse;  
        );
    public void testLargeRegExRareTermsAggregation() {
        } catch (SearchPhaseExecutionException ex) {  
        for (int i = 0; i < numDocs; ++i) {
            assertSearchResponse(response);
    @Override
            .get();
        for (SignificantTermsAggregatorFactory.ExecutionMode executionMode : SignificantTermsAggregatorFactory.ExecutionMode.values()) {
        SearchResponse response = client().prepareSearch("terminate_index")  
import org.opensearch.action.support.WriteRequest;
import org.opensearch.common.settings.Settings;  
            .setSize(2)
        List<IndexRequestBuilder> docs = new ArrayList<>();  
 * Unless required by applicable law or agreed to in writing,
            .get();
        final int size = randomIntBetween(1, 4);
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.bucket.terms.SignificantTermsAggregatorFactory;
import org.opensearch.search.aggregations.bucket.terms.RareTermsAggregationBuilder;  
    }  
                "idx",
            assertTrue(actualExceptionMessage.startsWith(LARGE_STRING_EXCEPTION_MESSAGE));
            ).setMapping("score", "type=integer")
import org.opensearch.search.aggregations.bucket.terms.SignificantTermsAggregationBuilder;
import org.opensearch.cluster.metadata.IndexMetadata;
        boolean exceptionThrown = false;
            new Object[] {  
        );
        numDocs = randomIntBetween(1, 20);
            .setScroll(TimeValue.timeValueMinutes(1))
        }  
    public void setupSuiteScopeCluster() throws Exception {  
            response = client().prepareSearchScroll(response.getScrollId()).setScroll(TimeValue.timeValueMinutes(1)).get();
            docs.add(client().prepareIndex("index").setSource("f", Integer.toString(i / 3)));
            assertTrue(nestedException.getCause() instanceof IllegalArgumentException);  
    private void runLargeStringAggregationTest(AggregationBuilder aggregation) {
import org.opensearch.test.OpenSearchIntegTestCase;  
        Aggregations aggregations = response.getAggregations();  
        client().prepareIndex("idx").setId("1").setSource("score", "5").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();  
 * You may obtain a copy of the License at  
            .setSize(size)
        return Arrays.asList(
 *
    private static final String LARGE_STRING = "a".repeat(2000);
 * The OpenSearch Contributors require contributions made to  
            client().prepareSearch("index").addAggregation(aggregation).get();
    }
        }
        // Validate non-global agg does not throw an exception
        runLargeStringAggregationTest(rareTerms);  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        SearchResponse response = client().prepareSearch("index")  
    private static final String LARGE_STRING_EXCEPTION_MESSAGE = "The length of regex ["  
 *  
 */  
    public void testScroll() {
 * software distributed under the License is distributed on an
 * compatible open source license.
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
import org.opensearch.search.aggregations.bucket.terms.Terms;  
        // currently this only supports "map" as an execution hint
import org.opensearch.common.unit.TimeValue;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        Terms terms = aggregations.get("f");
    }  
        + "] used in the request has exceeded the allowed maximum";
        // Validate global agg does not throw an exception
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 5).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
    }  
    public void testLargeRegExTermsAggregation() {
                "terminate_index",
        int total = response.getHits().getHits().length;
            Throwable nestedException = ex.getCause();
        }
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        assertSearchResponse(  
    public static Collection<Object[]> parameters() {  
    @ParametersFactory
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
        assertTrue(response.isTerminatedEarly());  
                .includeExclude(getLargeStringInclude())
                .includeExclude(getLargeStringInclude())
        try {
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
 * ownership. Elasticsearch licenses this file to you under  
            runLargeStringAggregationTest(significantTerms);  
/*  
