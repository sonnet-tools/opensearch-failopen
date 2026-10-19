        assertEquals(2, partialResults.size());  
 * The OpenSearch Contributors require contributions made to  
        }  
                assertFalse(hit.getRating().isPresent());
 * KIND, either express or implied.  See the License for the
        assertEquals(2, filterUnratedDocuments(amsterdamQueryQuality.getHitsAndRatings()).size());
    }  
            if (id.equals("berlin") || id.equals("amsterdam5")) {
        RatedRequest amsterdamRequest = new RatedRequest("amsterdam_query", amsterdamRatedDocs, testQuery);
        rankEvalRequest.indicesOptions(IndicesOptions.fromParameters(null, "true", null, "false", SearchRequest.DEFAULT_INDICES_OPTIONS));
import org.opensearch.index.rankeval.EvalQueryQuality;
    }
     */
        PrecisionAtK metric = new PrecisionAtK(1, false, 10);  
        amsterdamRatedDocs.addAll(createRelevant("index2", "amsterdam0"));  
        client().performRequest(new Request("POST", "/index2/_close"));  
        Map<String, EvalQueryQuality> partialResults = response.getPartialResults();
        int i = 0;
import org.opensearch.index.rankeval.EvaluationMetric;  
import org.opensearch.index.rankeval.RecallAtK;
     */  
import java.util.ArrayList;  
import java.util.stream.Collectors;
 */  
    public void testMetrics() throws IOException {  
        berlin.setJsonEntity("{\"text\":\"berlin\"}");  
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
        EvalQueryQuality amsterdamQueryQuality = partialResults.get("amsterdam_query");
 */
 *
import org.opensearch.action.support.IndicesOptions;
            }
import org.opensearch.index.rankeval.MeanReciprocalRank;
import java.util.function.Supplier;
        return Stream.of(docs).map(s -> new RatedDocument(indexName, s, 1)).collect(Collectors.toList());
package org.opensearch.client;
        assertEquals(7, hitsAndRatings.size());
            String index = i == 0 ? "index2" : "index";
        assertEquals(6, filterUnratedDocuments(berlinQueryQuality.getHitsAndRatings()).size());
        assertEquals(expectedPrecision, response.getMetricScore(), Double.MIN_VALUE);
     * calculation where all unlabeled documents are treated as not relevant.
 * compatible open source license.
                assertFalse(hit.getRating().isPresent());
        return specifications;  
    private static List<RatedDocument> createRelevant(String indexName, String... docs) {  
        }  
import org.opensearch.action.search.SearchRequest;
            Request amsterdam = new Request("PUT", "/" + index + "/_doc/amsterdam" + i);
            assertEquals(expectedScores[i], response.getMetricScore(), DOUBLE_DELTA);
        for (RatedSearchHit hit : hitsAndRatings) {
        Request berlin = new Request("PUT", "/index/_doc/berlin");
        double expectedScores[] = new double[] { 0.4285714285714286, 1.0, 0.75, 1.6408962261063627, 0.4407738095238095 };  
        List<Supplier<EvaluationMetric>> metrics = Arrays.asList(
            DiscountedCumulativeGain::new,  
import java.util.Arrays;
        for (RatedSearchHit hit : hitsAndRatings) {
        assertEquals(7, hitsAndRatings.size());
        client().performRequest(new Request("POST", "/_refresh"));  
        }  
        EvalQueryQuality berlinQueryQuality = partialResults.get("berlin_query");
    }
import org.opensearch.index.rankeval.RankEvalRequest;
        RankEvalResponse response = execute(rankEvalRequest, highLevelClient()::rankEval, highLevelClient()::rankEvalAsync);
        client().performRequest(berlin);
/*
 * SPDX-License-Identifier: Apache-2.0
            String id = hit.getSearchHit().getId();  
    private static List<RatedRequest> createTestEvaluationSpec() {
import org.opensearch.index.rankeval.RatedDocument;
import org.opensearch.index.rankeval.RatedSearchHit;  
import java.util.List;
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
            () -> new ExpectedReciprocalRank(1)
    }
     * Test case checks that the default metrics are registered and usable
import java.util.Map;  
import org.opensearch.index.rankeval.ExpectedReciprocalRank;
    public void testRankEvalRequest() throws IOException {
import org.opensearch.index.rankeval.RankEvalSpec;  
            amsterdam.setJsonEntity("{\"text\":\"amsterdam\"}");  
        hitsAndRatings = berlinQueryQuality.getHitsAndRatings();  
 *
        RankEvalSpec spec = new RankEvalSpec(specifications, metric);
import org.opensearch.index.query.MatchAllQueryBuilder;  
/*  
import org.opensearch.index.rankeval.PrecisionAtK;  
        List<RatedRequest> specifications = new ArrayList<>();  
        SearchSourceBuilder testQuery = new SearchSourceBuilder();  
 * license agreements. See the NOTICE file distributed with
        // the expected Prec@ for the first query is 5/7 and the expected Prec@ for the second is 1/7, divided by 2 to get the average
    public void indexDocuments() throws IOException {
        double expectedPrecision = (1.0 / 7.0 + 5.0 / 7.0) / 2.0;  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.rankeval.RatedRequest;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
    /**  
        List<RatedSearchHit> hitsAndRatings = amsterdamQueryQuality.getHitsAndRatings();  
 * You may obtain a copy of the License at  
        specifications.add(berlinRequest);
            RankEvalSpec spec = new RankEvalSpec(specifications, metricSupplier.get());  
            MeanReciprocalRank::new,
        RatedRequest berlinRequest = new RatedRequest("berlin_query", createRelevant("index", "berlin"), testQuery);
     * Test cases retrieves all six documents indexed above and checks the Prec@10
import org.opensearch.index.rankeval.RankEvalResponse;
import org.opensearch.index.rankeval.DiscountedCumulativeGain;
import java.io.IOException;
 * GitHub history for details.
                assertEquals(1, hit.getRating().getAsInt());
        List<RatedRequest> specifications = createTestEvaluationSpec();
 *  
            if (id.equals("berlin")) {
    @Before  
}  
            PrecisionAtK::new,  
        for (Supplier<EvaluationMetric> metricSupplier : metrics) {
import org.opensearch.search.builder.SearchSourceBuilder;
        // now try this when test2 is closed
 * specific language governing permissions and limitations
import java.util.stream.Stream;  
            RankEvalRequest rankEvalRequest = new RankEvalRequest(spec, new String[] { "index", "index2" });
public class RankEvalIT extends OpenSearchRestHighLevelClientTestCase {
            } else {  
            String id = hit.getSearchHit().getId();  
/*  
    /**  
            i++;
        );
            } else {  
            client().performRequest(amsterdam);
            RecallAtK::new,
import org.junit.Before;  
 * under the License.  
        specifications.add(amsterdamRequest);
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        List<RatedRequest> specifications = createTestEvaluationSpec();
        for (int i = 0; i < 6; i++) {
            RankEvalResponse response = execute(rankEvalRequest, highLevelClient()::rankEval, highLevelClient()::rankEvalAsync);  
        response = execute(rankEvalRequest, highLevelClient()::rankEval, highLevelClient()::rankEvalAsync);
        testQuery.query(new MatchAllQueryBuilder());
 * Modifications Copyright OpenSearch Contributors. See
        List<RatedDocument> amsterdamRatedDocs = createRelevant("index", "amsterdam1", "amsterdam2", "amsterdam3", "amsterdam4");
        }
        RankEvalRequest rankEvalRequest = new RankEvalRequest(spec, new String[] { "index", "index2" });  
import static org.opensearch.index.rankeval.EvaluationMetric.filterUnratedDocuments;
            // add another index to test basic multi index support  
 */  
            }
 * this work for additional information regarding copyright
                assertEquals(1, hit.getRating().getAsInt());
