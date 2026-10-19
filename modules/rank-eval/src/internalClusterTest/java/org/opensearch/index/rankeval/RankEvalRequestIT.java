    }
        assertEquals(6, details.getRetrieved());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Map.Entry;
        SearchSourceBuilder brokenQuery = new SearchSourceBuilder();
        // the expected Prec@ for the first query is 4/6 and the expected Prec@ for the
import java.util.ArrayList;
 *
        client().prepareIndex(TEST_INDEX).setId("6").setSource("id", 6, "text", "amsterdam", "population", 851573).get();
                    }
                for (RatedSearchHit hit : hitsAndRatings) {
        // if we look only at top 3 documente, the expected P@3 for the first query is
     * This test assumes we are using the same ratings as in {@link DiscountedCumulativeGainTests#testDCGAt()}.
        testQuery.query(new MatchAllQueryBuilder());
        );
        for (Entry<String, EvalQueryQuality> entry : entrySet) {
        }
        client().prepareIndex(TEST_INDEX)
        for (String doc : docs) {
    private static final int RELEVANT_RATING_1 = 1;
        assertEquals(DiscountedCumulativeGainTests.EXPECTED_DCG, response.getMetricScore(), 10E-14);
        testQuery.sort("id");
        // test that ignore_unavailable=true works but returns one result less
        request.indicesOptions(IndicesOptions.fromParameters("none", null, null, "false", SearchRequest.DEFAULT_INDICES_OPTIONS));
        super(staticSettings);
        PrecisionAtK metric = new PrecisionAtK(1, false, 10);
        assertEquals(0, details.getRetrieved());
        RankEvalSpec task = new RankEvalSpec(specifications, metric);
 * under the License.
                    }
            client(),
                }
        RankEvalResponse response = client().execute(RankEvalAction.INSTANCE, builder.request()).actionGet();
            .get();
     */
        assertEquals(5, details.getRelevantRetrieved());
        MeanReciprocalRank metric = new MeanReciprocalRank(1, 10);
     * test that running a bad query (e.g. one that will target a non existing
        metric = new PrecisionAtK(1, false, 3);
        request.setRankEvalSpec(task);
        List<RatedDocument> ratedDocs = Arrays.asList(
                List<RatedSearchHit> hitsAndRatings = quality.getHitsAndRatings();
        brokenQuery.query(QueryBuilders.termQuery("population", "noStringOnNumericFields"));
    public void testIndicesOptions() {
 */
     * test that multiple indices work, setting indices Options is possible and works as expected
/*
    public static Collection<Object[]> parameters() {
    public RankEvalRequestIT(Settings staticSettings) {
        details = (PrecisionAtK.Detail) response.getPartialResults().get("amsterdam_query").getMetricDetails();
                }
    }
                        assertEquals(RELEVANT_RATING_1, hit.getRating().getAsInt());
        double expectedMRR = (1.0 + 1.0 / 5.0) / 2.0;
        assertEquals(1, response.getFailures().size());
        assertEquals(expectedMRR, response.getMetricScore(), 0.0);
        );
            new RankEvalRequest(task, new String[] { TEST_INDEX })
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * Licensed to Elasticsearch under one or more contributor
        List<RatedRequest> specifications = new ArrayList<>();
        builder = new RankEvalRequestBuilder(client(), RankEvalAction.INSTANCE, new RankEvalRequest(task, new String[] { TEST_INDEX }));
import org.opensearch.index.query.MatchAllQueryBuilder;
        RatedRequest amsterdamRequest = new RatedRequest("amsterdam_query", createRelevant("2", "3", "4", "5"), testQuery);
        String indexToUse = randomBoolean() ? TEST_INDEX : INDEX_ALIAS;
        assertEquals(7, details.getRetrieved());
 *
    /**
    private static List<RatedDocument> createRelevant(String... docs) {
        response = client().execute(RankEvalAction.INSTANCE, request).actionGet();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        );
import org.opensearch.index.rankeval.PrecisionAtK.Detail;
        RankEvalRequest request = new RankEvalRequest(task, new String[] { TEST_INDEX, "test2" });
            new RatedDocument(TEST_INDEX, "2", 2),
        ensureGreen();
 * software distributed under the License is distributed on an
        request.indicesOptions(IndicesOptions.fromParameters(null, null, "false", "false", SearchRequest.DEFAULT_INDICES_OPTIONS));
        RankEvalSpec task = new RankEvalSpec(specifications, new PrecisionAtK());
        // 2/3 and the expected Prec@ for the second is 1/3, divided by 2 to get the average
        builder = new RankEvalRequestBuilder(client(), RankEvalAction.INSTANCE, new RankEvalRequest(task, new String[] { TEST_INDEX }));
    @Override
                        assertFalse(hit.getRating().isPresent());
        response = client().execute(RankEvalAction.INSTANCE, request).actionGet();
import java.util.Set;
     * first one that labels 4 out of the 6 documents as relevant, the second one with only one relevant document.
        assertEquals(2, entrySet.size());
 * license agreements. See the NOTICE file distributed with
        relevantDocs.add(new RatedDocument("test2", "7", RELEVANT_RATING_1));
    @ParametersFactory
}
    private static final String INDEX_ALIAS = "alias0";
 */
        RankEvalSpec task = new RankEvalSpec(specifications, new PrecisionAtK());
            new RankEvalRequest(task, new String[] { TEST_INDEX })
        refresh();
     * See details in that test case for how the expected values are calculated
import static org.opensearch.index.rankeval.EvaluationMetric.filterUnratedDocuments;
        task = new RankEvalSpec(specifications, metric);
        assertEquals(expectedPrecision, response.getMetricScore(), Double.MIN_VALUE);
        assertEquals("java.lang.NumberFormatException: For input string: \"noStringOnNumericFields\"", rootCauses[0].getCause().toString());
            .setId("1")
        // test expand_wildcards
                    String id = hit.getSearchHit().getId();
            client(),
            new RankEvalRequest(task, new String[] { TEST_INDEX })
        amsterdamRequest.addSummaryFields(Arrays.asList(new String[] { "text", "title" }));
                assertEquals(5, filterUnratedDocuments(quality.getHitsAndRatings()).size());
        request.indicesOptions(IndicesOptions.fromParameters(null, "true", null, "false", SearchRequest.DEFAULT_INDICES_OPTIONS));
        assertEquals(expectedMRR, response.getMetricScore(), 0.0);
        RankEvalRequestBuilder builder = new RankEvalRequestBuilder(
        RatedRequest amsterdamRequest = new RatedRequest("amsterdam_query", createRelevant("2", "3", "4", "5"), amsterdamQuery);
        details = (PrecisionAtK.Detail) response.getPartialResults().get("amsterdam_query").getMetricDetails();
        RankEvalResponse response = client().execute(RankEvalAction.INSTANCE, request).actionGet();
        return Arrays.asList(
        builder.setRankEvalSpec(task);
                    } else {
        response = client().execute(RankEvalAction.INSTANCE, request).actionGet();
            new RatedDocument(TEST_INDEX, "4", 0),
            EvalQueryQuality quality = entry.getValue();
        return Arrays.asList(RankEvalModulePlugin.class);
import java.util.Arrays;
        RankEvalResponse response = client().execute(RankEvalAction.INSTANCE, builder.request().indices(indexToUse)).actionGet();
        // test that a different window size k affects the result
        request.indicesOptions(IndicesOptions.fromParameters("closed", null, null, "false", SearchRequest.DEFAULT_INDICES_OPTIONS));
        RankEvalSpec task = new RankEvalSpec(specifications, metric);
        details = (PrecisionAtK.Detail) response.getPartialResults().get("amsterdam_query").getMetricDetails();
        // dividing by 2 to get the average
        client().prepareIndex(TEST_INDEX).setId("4").setSource("id", 4, "text", "amsterdam", "population", 851573).get();
            if (entry.getKey() == "amsterdam_query") {
 * Modifications Copyright OpenSearch Contributors. See
        metric = new DiscountedCumulativeGain(false, null, 3);
        assertAcked(client().admin().indices().prepareAliases().addAliasAction(AliasActions.add().index(TEST_INDEX).alias(INDEX_ALIAS)));
 */
        RankEvalRequestBuilder builder = new RankEvalRequestBuilder(client(), RankEvalAction.INSTANCE, new RankEvalRequest());
import org.opensearch.action.search.SearchRequest;
        metric = new MeanReciprocalRank(1, 3);
        SearchSourceBuilder amsterdamQuery = new SearchSourceBuilder();
import java.util.Collection;
                assertEquals(2, filterUnratedDocuments(quality.getHitsAndRatings()).size());
        testQuery.sort("id");
        List<RatedDocument> relevantDocs = createRelevant("2", "3", "4", "5", "6");
        client().prepareIndex("test2").setId("7").setSource("id", 7, "text", "amsterdam", "population", 851573).get();
package org.opensearch.index.rankeval;
                    String id = hit.getSearchHit().getId();
        List<RatedDocument> relevant = new ArrayList<>();
import org.opensearch.action.support.IndicesOptions;
import org.opensearch.OpenSearchException;
        testQuery.sort("id");
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        berlinRequest.addSummaryFields(Arrays.asList(new String[] { "text", "title" }));
import org.opensearch.plugins.Plugin;
            RankEvalAction.INSTANCE,
        OpenSearchException[] rootCauses = OpenSearchException.guessRootCauses(response.getFailures().get("broken_query"));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            new RatedDocument(TEST_INDEX, "6", 2)
        assertTrue(client().admin().indices().prepareClose("test2").get().isAcknowledged());
            RankEvalAction.INSTANCE,
    public void testBadQuery() {
    }
        assertEquals(1, response.getFailures().size());
            }
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
                    if (id.equals("1")) {
public class RankEvalRequestIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    }
    @Before
        Set<Entry<String, EvalQueryQuality>> entrySet = response.getPartialResults().entrySet();
            new RatedDocument(TEST_INDEX, "5", 1),
        // the reciprocal rank for the berlin_query is 1/1
        testQuery.query(new MatchAllQueryBuilder());
        assertThat(response.getFailures().get("amsterdam_query"), instanceOf(IllegalArgumentException.class));
        response = client().execute(RankEvalAction.INSTANCE, request).actionGet();
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
        assertEquals(1, response.getFailures().size());
        // the expected reciprocal rank for the amsterdam_query is 1/5
/*
            client(),
    public void testPrecisionAtRequest() {
import org.junit.Before;
        List<RatedRequest> specifications = new ArrayList<>();
 *
import org.opensearch.search.builder.SearchSourceBuilder;
        amsterdamQuery.query(new MatchAllQueryBuilder());
    public void testMRRRequest() {
        request = new RankEvalRequest(task, new String[] { "bad*" });
        // test that ignore_unavailable=false or default settings throw an IndexClosedException
                    if (id.equals("1") || id.equals("6")) {
 * You may obtain a copy of the License at
            new RatedDocument(TEST_INDEX, "1", 3),
        specifications.add(amsterdamRequest);
 * The OpenSearch Contributors require contributions made to
        // set up an alias that can also be used in tests
        request.indicesOptions(IndicesOptions.fromParameters("open", null, null, "false", SearchRequest.DEFAULT_INDICES_OPTIONS));
    }
    }
     */
    /**
 * SPDX-License-Identifier: Apache-2.0
        RankEvalResponse response = client().execute(RankEvalAction.INSTANCE, builder.request()).actionGet();
    private static final String TEST_INDEX = "test";
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                assertEquals(6, hitsAndRatings.size());
        builder.setRankEvalSpec(task);
import org.opensearch.indices.IndexClosedException;
        DiscountedCumulativeGain metric = new DiscountedCumulativeGain(false, null, 10);
        assertEquals(6, details.getRelevantRetrieved());
        List<RatedRequest> specifications = new ArrayList<>();
    public void setup() {
        specifications.add(amsterdamRequest);
        specifications.add(brokenRequest);
        assertEquals(expectedPrecision, response.getMetricScore(), Double.MIN_VALUE);
        specifications.add(new RatedRequest("amsterdam_query", createRelevant("5"), testQuery));
        List<RatedRequest> specifications = new ArrayList<>();
        SearchSourceBuilder testQuery = new SearchSourceBuilder();
        request = new RankEvalRequest(task, new String[] { "tes*" });
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                for (RatedSearchHit hit : hitsAndRatings) {
        double expectedPrecision = (1.0 / 6.0 + 4.0 / 6.0) / 2.0;
    /**
     * field) will produce an error in the response
            if (entry.getKey() == "berlin_query") {
        response = client().execute(RankEvalAction.INSTANCE, request).actionGet();
import static org.hamcrest.Matchers.instanceOf;
        builder = new RankEvalRequestBuilder(client(), RankEvalAction.INSTANCE, new RankEvalRequest(task, new String[] { TEST_INDEX }));
 * specific language governing permissions and limitations
        }
        response = client().execute(RankEvalAction.INSTANCE, request).actionGet();
        // test allow_no_indices
        return relevant;
        task = new RankEvalSpec(specifications, metric);
        // limiting to top 3 results, the amsterdam_query has no relevant document in it
        // test that a different window size k affects the result
 * GitHub history for details.
        );
            }
            new RatedDocument(TEST_INDEX, "3", 3),
        response = client().execute(RankEvalAction.INSTANCE, builder.request()).actionGet();
 * the Apache License, Version 2.0 (the "License"); you may
        RatedRequest brokenRequest = new RatedRequest("broken_query", createRelevant("1"), brokenQuery);
            relevant.add(new RatedDocument("test", doc, RELEVANT_RATING_1));
        // dividing by 2 to get the average
        createIndex(TEST_INDEX);
 * Unless required by applicable law or agreed to in writing,
     */
        assertEquals(0, details.getRetrieved());
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        expectedPrecision = (1.0 / 3.0 + 2.0 / 3.0) / 2.0;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.query.QueryBuilders;
        assertTrue(client().admin().indices().prepareClose("test2").get().isAcknowledged());
        response = client().execute(RankEvalAction.INSTANCE, builder.request()).actionGet();
     * Test cases retrieves all six documents indexed above. The first part checks the Prec@10 calculation where
        specifications.add(new RatedRequest("amsterdam_query", relevantDocs, amsterdamQuery));
        assertEquals(6, details.getRetrieved());
            .setSource("id", 1, "text", "berlin", "title", "Berlin, Germany", "population", 3670622)
        assertEquals(1, response.getFailures().size());
        SearchSourceBuilder testQuery = new SearchSourceBuilder();
        SearchSourceBuilder testQuery = new SearchSourceBuilder();
        // test that a different window size k affects the result
        specifications.add(new RatedRequest("berlin_query", createRelevant("1"), testQuery));
            RankEvalAction.INSTANCE,
import org.opensearch.common.settings.Settings;
        // the expected reciprocal rank for the berlin_query is 1/1
                    } else {
import java.util.List;
/*
 * not use this file except in compliance with the License.
    public void testDCGRequest() {
        client().prepareIndex(TEST_INDEX).setId("5").setSource("id", 5, "text", "amsterdam", "population", 851573).get();
        Detail details = (PrecisionAtK.Detail) response.getPartialResults().get("amsterdam_query").getMetricDetails();
        assertEquals(5, details.getRelevantRetrieved());
 * this work for additional information regarding copyright
        assertThat(response.getFailures().get("amsterdam_query"), instanceOf(IndexNotFoundException.class));
        details = (PrecisionAtK.Detail) response.getPartialResults().get("amsterdam_query").getMetricDetails();
                assertEquals(6, hitsAndRatings.size());
        RankEvalRequestBuilder builder = new RankEvalRequestBuilder(
 * KIND, either express or implied.  See the License for the
        RankEvalRequestBuilder builder = new RankEvalRequestBuilder(
        // second is 1/6, divided by 2 to get the average
                        assertEquals(RELEVANT_RATING_1, hit.getRating().getAsInt());
    /**
 * ownership. Elasticsearch licenses this file to you under
        response = client().execute(RankEvalAction.INSTANCE, request).actionGet();
        client().prepareIndex(TEST_INDEX).setId("3").setSource("id", 3, "text", "amsterdam", "population", 851573).get();
     * all unlabeled docs are treated as "unrelevant". We average Prec@ metric across two search use cases, the
        assertEquals(12.39278926071437, response.getMetricScore(), 10E-14);
                        assertFalse(hit.getRating().isPresent());
        client().prepareIndex(TEST_INDEX).setId("2").setSource("id", 2, "text", "amsterdam", "population", 851573).get();
        assertThat(response.getFailures().get("amsterdam_query"), instanceOf(IndexClosedException.class));
     */
import org.opensearch.index.IndexNotFoundException;
        request.indicesOptions(IndicesOptions.fromParameters(null, "false", null, "false", SearchRequest.DEFAULT_INDICES_OPTIONS));
                List<RatedSearchHit> hitsAndRatings = quality.getHitsAndRatings();
        SearchSourceBuilder amsterdamQuery = new SearchSourceBuilder().query(new MatchAllQueryBuilder());
        RankEvalSpec task = new RankEvalSpec(specifications, metric);
        RatedRequest berlinRequest = new RatedRequest("berlin_query", createRelevant("1"), testQuery);
        specifications.add(new RatedRequest("amsterdam_query", ratedDocs, testQuery));
        task = new RankEvalSpec(specifications, metric);
    }
        // add another index for testing closed indices etc...
        List<RatedRequest> specifications = new ArrayList<>();
        RankEvalResponse response = client().execute(RankEvalAction.INSTANCE, builder.request()).actionGet();
        testQuery.query(new MatchAllQueryBuilder());
        response = client().execute(RankEvalAction.INSTANCE, builder.request()).actionGet();
    }
        expectedMRR = 1.0 / 2.0;
    }
        );
        request.indicesOptions(IndicesOptions.fromParameters(null, null, "true", "false", SearchRequest.DEFAULT_INDICES_OPTIONS));
        specifications.add(berlinRequest);
 * compatible open source license.
