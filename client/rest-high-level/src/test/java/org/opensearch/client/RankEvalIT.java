            RankEvalSpec spec = new RankEvalSpec(specifications, metricSupplier.get());
public class RankEvalIT extends OpenSearchRestHighLevelClientTestCase {
import org.opensearch.index.rankeval.RankEvalResponse;
    public void testMetrics() throws IOException {
        specifications.add(berlinRequest);
        EvalQueryQuality amsterdamQueryQuality = partialResults.get("amsterdam_query");
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
        Map<String, EvalQueryQuality> partialResults = response.getPartialResults();
import java.util.function.Supplier;
        return specifications;
import org.opensearch.index.rankeval.EvalQueryQuality;
        }
import java.io.IOException;
        double expectedPrecision = (1.0 / 7.0 + 5.0 / 7.0) / 2.0;
    public void indexDocuments() throws IOException {
/*
        Request berlin = new Request("PUT", "/index/_doc/berlin");
 * SPDX-License-Identifier: Apache-2.0
        }
import java.util.Arrays;
        List<RatedDocument> amsterdamRatedDocs = createRelevant("index", "amsterdam1", "amsterdam2", "amsterdam3", "amsterdam4");
        rankEvalRequest.indicesOptions(IndicesOptions.fromParameters(null, "true", null, "false", SearchRequest.DEFAULT_INDICES_OPTIONS));
 *
        // the expected Prec@ for the first query is 5/7 and the expected Prec@ for the second is 1/7, divided by 2 to get the average
        List<RatedRequest> specifications = createTestEvaluationSpec();
 * You may obtain a copy of the License at
import org.opensearch.index.query.MatchAllQueryBuilder;
            PrecisionAtK::new,
            amsterdam.setJsonEntity("{\"text\":\"amsterdam\"}");
        SearchSourceBuilder testQuery = new SearchSourceBuilder();
    @Before
        assertEquals(2, filterUnratedDocuments(amsterdamQueryQuality.getHitsAndRatings()).size());
    /**
import org.opensearch.index.rankeval.RankEvalRequest;
        assertEquals(6, filterUnratedDocuments(berlinQueryQuality.getHitsAndRatings()).size());
        testQuery.query(new MatchAllQueryBuilder());
            String index = i == 0 ? "index2" : "index";
        for (RatedSearchHit hit : hitsAndRatings) {
            RankEvalResponse response = execute(rankEvalRequest, highLevelClient()::rankEval, highLevelClient()::rankEvalAsync);
 * GitHub history for details.
            String id = hit.getSearchHit().getId();
import java.util.List;
 * license agreements. See the NOTICE file distributed with
            }
    /**
            String id = hit.getSearchHit().getId();
package org.opensearch.client;
                assertEquals(1, hit.getRating().getAsInt());
        RankEvalRequest rankEvalRequest = new RankEvalRequest(spec, new String[] { "index", "index2" });
            } else {
            }
 * The OpenSearch Contributors require contributions made to
        assertEquals(expectedPrecision, response.getMetricScore(), Double.MIN_VALUE);
import org.opensearch.index.rankeval.PrecisionAtK;
    }
import java.util.ArrayList;
        return Stream.of(docs).map(s -> new RatedDocument(indexName, s, 1)).collect(Collectors.toList());
        client().performRequest(new Request("POST", "/_refresh"));
        PrecisionAtK metric = new PrecisionAtK(1, false, 10);
        RatedRequest amsterdamRequest = new RatedRequest("amsterdam_query", amsterdamRatedDocs, testQuery);
 * KIND, either express or implied.  See the License for the
                assertFalse(hit.getRating().isPresent());
            DiscountedCumulativeGain::new,
            // add another index to test basic multi index support
        RankEvalResponse response = execute(rankEvalRequest, highLevelClient()::rankEval, highLevelClient()::rankEvalAsync);
/*
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
import java.util.Map;
import org.opensearch.index.rankeval.RankEvalSpec;
     */
 */
import java.util.stream.Collectors;
        EvalQueryQuality berlinQueryQuality = partialResults.get("berlin_query");
import org.opensearch.index.rankeval.RatedSearchHit;
import static org.opensearch.index.rankeval.EvaluationMetric.filterUnratedDocuments;
        berlin.setJsonEntity("{\"text\":\"berlin\"}");
     */
     * Test case checks that the default metrics are registered and usable
 * compatible open source license.
    }
import org.junit.Before;
            } else {
import java.util.stream.Stream;
            if (id.equals("berlin")) {
 * Licensed to Elasticsearch under one or more contributor
            assertEquals(expectedScores[i], response.getMetricScore(), DOUBLE_DELTA);
            client().performRequest(amsterdam);
 */
        }
        assertEquals(7, hitsAndRatings.size());
 *
import org.opensearch.index.rankeval.MeanReciprocalRank;
}
        List<RatedRequest> specifications = createTestEvaluationSpec();
import org.opensearch.index.rankeval.DiscountedCumulativeGain;
                assertFalse(hit.getRating().isPresent());
 * ownership. Elasticsearch licenses this file to you under
        response = execute(rankEvalRequest, highLevelClient()::rankEval, highLevelClient()::rankEvalAsync);
    private static List<RatedRequest> createTestEvaluationSpec() {
        specifications.add(amsterdamRequest);
        List<Supplier<EvaluationMetric>> metrics = Arrays.asList(
    public void testRankEvalRequest() throws IOException {
     * calculation where all unlabeled documents are treated as not relevant.
            () -> new ExpectedReciprocalRank(1)
import org.opensearch.index.rankeval.RatedDocument;
import org.opensearch.index.rankeval.ExpectedReciprocalRank;
import org.opensearch.index.rankeval.RecallAtK;
import org.opensearch.action.search.SearchRequest;
            i++;
 * Modifications Copyright OpenSearch Contributors. See
 *
        );
import org.opensearch.index.rankeval.EvaluationMetric;
    private static List<RatedDocument> createRelevant(String indexName, String... docs) {
            RecallAtK::new,
        // now try this when test2 is closed
                assertEquals(1, hit.getRating().getAsInt());
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
        RankEvalSpec spec = new RankEvalSpec(specifications, metric);
            if (id.equals("berlin") || id.equals("amsterdam5")) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.rankeval.RatedRequest;
        client().performRequest(new Request("POST", "/index2/_close"));
    }
        for (int i = 0; i < 6; i++) {
    }
        for (RatedSearchHit hit : hitsAndRatings) {
 * not use this file except in compliance with the License.
        List<RatedSearchHit> hitsAndRatings = amsterdamQueryQuality.getHitsAndRatings();
            RankEvalRequest rankEvalRequest = new RankEvalRequest(spec, new String[] { "index", "index2" });
 * under the License.
        RatedRequest berlinRequest = new RatedRequest("berlin_query", createRelevant("index", "berlin"), testQuery);
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
     * Test cases retrieves all six documents indexed above and checks the Prec@10
            Request amsterdam = new Request("PUT", "/" + index + "/_doc/amsterdam" + i);
import org.opensearch.action.support.IndicesOptions;
        assertEquals(2, partialResults.size());
            MeanReciprocalRank::new,
 */
        List<RatedRequest> specifications = new ArrayList<>();
        for (Supplier<EvaluationMetric> metricSupplier : metrics) {
        assertEquals(7, hitsAndRatings.size());
        amsterdamRatedDocs.addAll(createRelevant("index2", "amsterdam0"));
        client().performRequest(berlin);
        hitsAndRatings = berlinQueryQuality.getHitsAndRatings();
        int i = 0;
        double expectedScores[] = new double[] { 0.4285714285714286, 1.0, 0.75, 1.6408962261063627, 0.4407738095238095 };
        }
import org.opensearch.search.builder.SearchSourceBuilder;
