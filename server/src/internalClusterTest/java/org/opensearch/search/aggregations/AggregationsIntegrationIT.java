            runLargeStringAggregationTest(termsAggregation);
    public void testAggsOnEmptyShards() {
            TermsAggregationBuilder termsAggregation = terms("my_terms").field("f")
    @ParametersFactory
        // Create index with 5 shards but only 1 doc
            String actualExceptionMessage = nestedException.getCause().getMessage();
    }
        runLargeStringAggregationTest(rareTerms);
    }
        numDocs = randomIntBetween(1, 20);
        }
            assertTrue(nestedException instanceof OpenSearchException);
        }
 */
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
        assertTrue(response.isTerminatedEarly());
import org.opensearch.search.aggregations.bucket.terms.RareTermsAggregationBuilder;
    }
        super(staticSettings);
                .includeExclude(getLargeStringInclude())
import org.opensearch.OpenSearchException;
        );
import static org.opensearch.search.aggregations.AggregationBuilders.stats;
@OpenSearchIntegTestCase.SuiteScopeTestCase
    private void runLargeStringAggregationTest(AggregationBuilder aggregation) {
import org.opensearch.action.search.SearchPhaseExecutionException;
 * You may obtain a copy of the License at
        List<IndexRequestBuilder> docs = new ArrayList<>();
            SignificantTermsAggregationBuilder significantTerms = new SignificantTermsAggregationBuilder("my_terms").field("f")
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        client().prepareIndex("idx").setId("1").setSource("score", "5").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertSearchResponse(response);
import org.opensearch.common.settings.Settings;
        return Arrays.asList(
    @Override
            .addAggregation(terms("f").field("f"))
        for (SignificantTermsAggregatorFactory.ExecutionMode executionMode : SignificantTermsAggregatorFactory.ExecutionMode.values()) {
            docs.add(client().prepareIndex("terminate_index").setSource("f", Integer.toString(i / 3)));
        SearchResponse response = client().prepareSearch("terminate_index")
        for (int i = 0; i < randomIntBetween(5, 20); ++i) {
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
import org.opensearch.search.aggregations.bucket.terms.TermsAggregatorFactory;
/*
/*
        clearScroll(response.getScrollId());
package org.opensearch.search.aggregations;
 *
            assertNotNull(nestedException.getCause());
import org.opensearch.search.aggregations.bucket.terms.SignificantTermsAggregatorFactory;
    private static final String LARGE_STRING = "a".repeat(2000);
    }
        assertNotNull(aggregations);
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
        // Validate non-global agg does not throw an exception
}
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            exceptionThrown = true;
        assertAcked(prepareCreate("index").setMapping("f", "type=keyword").get());
        RareTermsAggregationBuilder rareTerms = new RareTermsAggregationBuilder("my_terms").field("f")
                .includeExclude(getLargeStringInclude())
            docs.add(client().prepareIndex("index").setSource("f", Integer.toString(i / 3)));
        List<IndexRequestBuilder> docs = new ArrayList<>();
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
            ).setMapping("score", "type=integer")
        + "] used in the request has exceeded the allowed maximum";
        indexRandom(true, docs);
            ).setMapping("f", "type=keyword").get()
        }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
 * compatible open source license.
            client().prepareSearch("index").addAggregation(aggregation).get();
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
    }
 * GitHub history for details.
        // Validate global agg does not throw an exception
    public void setupSuiteScopeCluster() throws Exception {
import org.opensearch.action.support.WriteRequest;
import java.util.Arrays;
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor
        Aggregations aggregations = response.getAggregations();
    }
    }
import org.opensearch.search.aggregations.bucket.terms.Terms;
        assertAcked(
            assertNull(response.getAggregations());
            new Object[] {
 */
    public void testLargeRegExRareTermsAggregation() {
 * specific language governing permissions and limitations
        assertSearchResponse(client().prepareSearch("idx").addAggregation(stats("value_stats").field("score")).get());
        IncludeExclude include = new IncludeExclude(LARGE_STRING, null);
        for (int i = 0; i < numDocs; ++i) {
        assertAcked(
 * Unless required by applicable law or agreed to in writing,
        Terms terms = aggregations.get("f");
            runLargeStringAggregationTest(significantTerms);
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
            new Object[] {
public class AggregationsIntegrationIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        + LARGE_STRING.length()
            .setTerminateAfter(1)
    private IncludeExclude getLargeStringInclude() {
            .setScroll(TimeValue.timeValueMinutes(1))
import java.util.ArrayList;
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
 * Modifications Copyright OpenSearch Contributors. See
    public AggregationsIntegrationIT(Settings staticSettings) {
 * this work for additional information regarding copyright
    public void testScroll() {
import org.opensearch.common.unit.TimeValue;
/*
            client().prepareSearch("idx").addAggregation(global("global").subAggregation(stats("value_stats").field("score"))).get()
            .setSize(size)
 * this file be licensed under the Apache-2.0 license or a
        boolean exceptionThrown = false;
            .addAggregation(terms("f").field("f"))
        assertSearchResponse(response);
    static int numDocs;
import org.opensearch.cluster.metadata.IndexMetadata;
            .get();
    public void testLargeRegExSignificantTermsAggregation() {
        assertEquals(numDocs, total);
                .executionHint(executionMode.toString());
            total += response.getHits().getHits().length;
    public void testLargeRegExTermsAggregation() {
    public static Collection<Object[]> parameters() {
                "idx",
        );
            assertTrue(nestedException.getCause() instanceof IllegalArgumentException);
            assertNotNull(nestedException);
        }
            .maxDocCount(2);
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
 * under the License.
        return new IncludeExclude(LARGE_STRING, null);
import java.util.Collection;
        final int size = randomIntBetween(1, 4);
        assertTrue("Exception should have been thrown", exceptionThrown);
            assertSearchResponse(response);
 * not use this file except in compliance with the License.
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 5).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .includeExclude(getLargeStringInclude())
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.opensearch.action.search.SearchResponse;
 *
 * ownership. Elasticsearch licenses this file to you under
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            prepareCreate(
            Throwable nestedException = ex.getCause();
    }
 * KIND, either express or implied.  See the License for the
        assertSearchResponse(
        assertEquals(Math.min(numDocs, 3L), terms.getBucketByKey("0").getDocCount());
        while (response.getHits().getHits().length > 0) {
    public void testAggsWithTerminateAfter() throws InterruptedException {
        }
            prepareCreate(
        int total = response.getHits().getHits().length;
import static org.opensearch.search.aggregations.AggregationBuilders.global;
        );
            .setSize(2)
 * The OpenSearch Contributors require contributions made to
 *
                "terminate_index",
import java.util.List;
        // currently this only supports "map" as an execution hint
    }
                .executionHint(executionMode.toString());
        );
        try {
    }
import org.opensearch.search.aggregations.bucket.terms.SignificantTermsAggregationBuilder;
            new Object[] {
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
 * SPDX-License-Identifier: Apache-2.0
        for (TermsAggregatorFactory.ExecutionMode executionMode : TermsAggregatorFactory.ExecutionMode.values()) {
        } catch (SearchPhaseExecutionException ex) {
        SearchResponse response = client().prepareSearch("index")
    }
    private static final String LARGE_STRING_EXCEPTION_MESSAGE = "The length of regex ["
 */
            .get();
        assertEquals(response.getHits().getHits().length, 1);
            assertTrue(actualExceptionMessage.startsWith(LARGE_STRING_EXCEPTION_MESSAGE));
        }
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.index.IndexRequestBuilder;
import org.opensearch.test.OpenSearchIntegTestCase;
        indexRandom(true, docs);
            response = client().prepareSearchScroll(response.getScrollId()).setScroll(TimeValue.timeValueMinutes(1)).get();
