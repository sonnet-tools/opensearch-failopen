        int numShards = getNumShards("test").numPrimaries;  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
            .setQuery(QueryBuilders.matchQuery("field1", "the quick brown").operator(Operator.OR))  
                    .setRescoreQueryWeight(-1f),  
                    assertThat(rescored.getHits().getHits()[1].getScore(), equalTo(2.0f * primaryWeight * 5.0f * secondaryWeight));
        );
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)  
        ).setScoreMode(QueryRescoreMode.Total);
            assertThirdHit(searchResponse, hasId("3"));
                        functionScoreQuery(matchAllQuery(), ScoreFunctionBuilders.weightFactorFunction(100)).boostMode(  
        assertThat(response.getHits().getMaxScore(), equalTo(response.getHits().getHits()[0].getScore()));
            )  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasScore;
            () -> client().prepareSearch()
                .setRescorer(
 * compatible open source license.
            client().admin().indices().prepareCreate("test").setMapping(mapping).setSettings(builder.put("index.number_of_shards", 1))  
        refresh();
        );
                    assertThat(rescored.getHits().getHits()[0].getScore(), equalTo(3.0f * primaryWeight * 7.0f * secondaryWeight));
            .setRescorer(
        // no dummy docs since merges can change scores while we run queries.  
            }
                    ).setRescoreQueryWeight(1.0f),
            .setFrom(0)
        assertThirdHit(searchResponse, hasId("1"));  
                }  
import static org.hamcrest.Matchers.greaterThan;
/*
                QueryRescorerBuilder outerRescoreQuery = new QueryRescorerBuilder(matchQuery("field1", "the quick brown").boost(4.0f))
                        searchResponse.getHits().getAt(i).getExplanation().getDetails()[1].getDetails()[1].getValue(),
            if (cmp == 0) {
                .get();
            .setQuery(QueryBuilders.matchQuery("field1", "massachusetts"))  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
        super(staticSettings);  
    // forces QUERY_THEN_FETCH because of https://github.com/elastic/elasticsearch/issues/4829
                    new QueryRescorerBuilder(
    }
                new QueryRescorerBuilder(matchPhraseQuery("field1", "lexington avenue massachusetts").slop(3)).setQueryWeight(0.6f)
        assertSecondHit(searchResponse, hasId("3"));
                        functionScoreQuery(termQuery("field1", intToEnglish[0]), weightFactorFunction(5.0f)).boostMode(REPLACE)  
                    .endObject()  
        for (int i = 0; i < hits.length; i++) {
                    functionScoreQuery(termQuery("field1", intToEnglish[0]), weightFactorFunction(2.0f)).boostMode(REPLACE)
                assertThat(rescored.getHits().getMaxScore(), equalTo(rescored.getHits().getHits()[0].getScore()));  
                if (i == 2) {
        assertFirstHit(searchResponse, hasId("2"));
                    .endObject()
        for (int i = 0; i < 5; i++) {
                .boostMode(CombineFunction.REPLACE)
        assertNoFailures(rescored);
        for (int i = 0; i < iters; i++) {
                    assertThat(rescored.getHits().getHits()[2].getScore(), equalTo(2.0f * primaryWeight));
            .addRescorer(new QueryRescorerBuilder(matchAllQuery()).setRescoreQueryWeight(100.0f), 50)
                    .setFrom(0)
    private static void assertEquivalent(String query, SearchResponse plain, SearchResponse rescored) {  
import org.opensearch.search.rescore.QueryRescoreMode;
        searchResponse = client().prepareSearch()  
            int cmp = Float.compare(hit2.getScore(), hit1.getScore());  
        for (int j = 0; j < iters; j++) {
            }
                    assertFirstHit(rescored, hasId(String.valueOf(i + 1)));
import static org.hamcrest.Matchers.equalTo;
            for (int i = 0; i < numDocs - 4; i++) {  
                        .should(functionScoreQuery(termQuery("field1", intToEnglish[3]), weightFactorFunction(0.0f)).boostMode(REPLACE))  
                )  
            assertThirdHit(searchResponse, hasMatchedQueries(matchedQueries));
                .setPreference("test") // ensure we hit the same shards for tie-breaking
                    .setQuery(query)  
                CombineFunction.REPLACE
                if (!"".equals(scoreMode)) {
                CombineFunction.REPLACE
            .get();
                new QueryRescorerBuilder(matchPhraseQuery("field1", "lexington avenue massachusetts").slop(3)).setQueryWeight(0.6f)
            .field("analyzer", "whitespace")
        assertSecondHit(searchResponse, hasId("2"));
                    .setExplain(true)  
                assertThat(searchResponse.getHits().getAt(i).getExplanation().getDetails().length, equalTo(2));
    public void testFromSize() throws Exception {
                    assertThat(  
        // Make sure non-zero from works:  
        String[] descriptionModes = new String[] { "max of:", "min of:", "avg of:", "sum of:", "product of:", "sum of:" };  
        client().admin().indices().prepareRefresh("test").get();
            client().prepareIndex("test").setId("" + i).setSource("number", 0).get();  
        for (int i = 0; i < iters; i++) {  
            .field("analyzer", "whitespace")
        indexRandomForConcurrentSearch("test");
        assertHitCount(searchResponse, 3);
        assertThat(searchResponse.getHits().getMaxScore(), equalTo(searchResponse.getHits().getHits()[0].getScore()));  
        for (int i = 0; i < hits.length; i++) {
 * SPDX-License-Identifier: Apache-2.0
                    assertSecondHit(rescored, hasId(String.valueOf(i + 2)));  
        request.setSize(4);  
                .setQuery(QueryBuilders.matchQuery("field1", query).operator(Operator.OR))
                3
        client().prepareIndex("test").setId("3").setSource("field1", "massachusetts").get();
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i));
            .setQuery(QueryBuilders.matchQuery("field1", "massachusetts"))
    // are sorted equally. This is fine since tests only care about the fact the scores should be equal, not ordering.
        ensureGreen();
 * specific language governing permissions and limitations
        indexRandomForConcurrentSearch("test");
                5
            )
            .setQuery(QueryBuilders.matchQuery("field1", "massachusetts"))
            } else {  
                jsonBuilder().startObject()  
            .setFrom(0)  
            int resultSize = numDocs;  
            SearchResponse plain = client().prepareSearch()  
            builder.put(SETTING_NUMBER_OF_SHARDS, shards);
            )
                    assertThat(rescored.getHits().getHits()[0].getScore(), equalTo(5.0f * primaryWeight));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertThat("query: " + query, hits[i].getId(), equalTo(rHits[i].getId()));  
/*  
        assertThirdHit(searchResponse, hasId("3"));
                    English.intToEnglish(i + 2),
            .setSize(5)  
        assertFourthHit(searchResponse, hasId("1"));
        Arrays.sort(rHits, searchHitsComparator);
 * not use this file except in compliance with the License.
 *
                    assertThat(rescored.getHits().getHits()[2].getScore(), equalTo(5.0f * primaryWeight));
        SearchHit[] hits = leftHits.getHits();
import org.opensearch.common.lucene.search.function.CombineFunction;  
            for (int i = 0; i < searchResponse.getHits().getHits().length; i++) {
        assertThat(searchResponse.getHits().getHits().length, equalTo(4));
                .setRescorer(
                new QueryRescorerBuilder(matchPhraseQuery("field1", "lexington avenue massachusetts").slop(3)).setQueryWeight(0.6f)
            .setTrackScores(true)  
            .setFrom(0)
    private int indexRandomNumbers(String analyzer) throws Exception {
    }
                    outerRescoreQuery.setScoreMode(QueryRescoreMode.fromString(scoreModes[outerMode]));
 * the Apache License, Version 2.0 (the "License"); you may
        assertFirstHit(searchResponse, hasId("3"));
                    assertThat(rescored.getHits().getHits()[2].getScore(), equalTo(5.0f * primaryWeight));  
            .setRescorer(  
                .setRescorer(
                    rescoreWindow  
                CombineFunction.REPLACE  
        assertAcked(  
        for (int i = 0; i < 5; i++) {  
        SearchRequestBuilder request = client().prepareSearch();
        client().prepareIndex("test").setId("12").setSource("field1", "3st street boston massachusetts").get();
        // Only top 2 hits were re-ordered:
                }
                    .startObject("properties")  
                    assertThat(rescored.getHits().getHits()[3].getScore(), equalTo(0.0f * secondaryWeight));  
        client().admin().indices().prepareRefresh("test").get();
        searchResponse = client().prepareSearch()  
        }
        assertFirstHit(response, hasId("7"));
            assertThat(searchResponse.getHits().getMaxScore(), equalTo(searchResponse.getHits().getHits()[0].getScore()));
            .setQuery(QueryBuilders.matchQuery("field1", "massachusetts").operator(Operator.OR))
        assertSecondHit(searchResponse, hasId("2"));
            .endObject()
        client().prepareIndex("test").setId("6").setSource("field1", "massachusetts avenue lexington massachusetts").get();
                }
            SearchResponse searchResponse = client().prepareSearch()
        client().prepareIndex("test").setId("1").setSource("field1", "massachusetts avenue boston massachusetts").get();
                    assertThat(searchResponse.getHits().getAt(i).getExplanation().getDetails()[1].getValue(), equalTo(0.5f));
        Builder builder = Settings.builder();  
            .setSource("field1", "quick huge brown", "field2", "the quick lazy huge brown fox jumps over the tree")
        assertSecondHit(searchResponse, hasId("6"));
        request.clearRescorers().addRescorer(ninetyIsGood, numDocs).addRescorer(oneToo, 10);  
 */
        assertSecondHit(searchResponse, hasId("2"));  
        );
                assertSecondHit(searchResponse, hasId("2"));
        );  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        searchResponse = client().prepareSearch()
            .endObject()
                .addRescorer(new QueryRescorerBuilder(matchAllQuery()), 50)
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        for (int innerMode = 0; innerMode < scoreModes.length; innerMode++) {
                    assertThirdHit(rescored, hasId(String.valueOf(i + 2)));  
            () -> client().prepareSearch()  
import static org.hamcrest.Matchers.notNullValue;
                2
                    );
                    assertThat(
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
        assertThat(searchResponse.getHits().getMaxScore(), greaterThan(searchResponse.getHits().getHits()[0].getScore()));  
        assertHitCount(searchResponse, 3);
        }  
        }
    // The rescore uses the docId as tie, while regular search uses the slot the hit is in as a tie if score
            )
        Builder builder = Settings.builder().put(indexSettings());
        int numDocs = randomIntBetween(100, 150);
            functionScoreQuery(queryStringQuery("*ninety*"), ScoreFunctionBuilders.weightFactorFunction(1000.0f)).boostMode(  
                assertThat(searchResponse.getHits().getAt(i).getExplanation().getDetails()[0].isMatch(), equalTo(true));  
            .get();  
            .endObject();
                    assertSecondHit(rescored, hasId(String.valueOf(i)));
        XContentBuilder mapping = XContentFactory.jsonBuilder()
                .setFrom(0)
                    .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
            QueryRescorerBuilder innerRescoreQuery = new QueryRescorerBuilder(matchQuery("field1", "the quick brown").boost(4.0f))
import org.apache.lucene.search.Explanation;  
        assertThirdHit(searchResponse, hasId("1"));
            assertHitCount(searchResponse, 3);
    private int indexRandomNumbers(String analyzer, int shards, boolean dummyDocs) throws Exception {  
            .get();
                    .field("analyzer", "whitespace")
            .endObject();  
import static org.opensearch.index.query.QueryBuilders.matchPhraseQuery;
        SearchResponse searchResponse = client().prepareSearch()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
        // Now use one rescore to drag the number we're looking for into the window of another
            assertThat("query: " + query, hits[i].getScore(), equalTo(rHits[i].getScore()));  
import org.opensearch.action.search.SearchRequestBuilder;  
        // First set the rescore window large enough that both rescores take effect
            .setRescorer(
        assertFourthHit(searchResponse, hasId("2"));  
    public void testRescorePhrase() throws Exception {
            }
            .get();  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        int numDocs = indexRandomNumbers("keyword", 1, true);
 */  
        );
                        equalTo(0.5f)
                    assertThat(explanation.getDetails()[0].getDetails()[0].getDescription(), equalTo(descriptionModes[innerMode]));
        client().prepareIndex("test").setId("2").setSource("field1", "lexington avenue boston massachusetts road").get();
            SearchResponse searchResponse = client().prepareSearch()
        assertAcked(
 * license agreements. See the NOTICE file distributed with
        assertNoFailures(plain);
                    .addRescorer(outerRescoreQuery.windowSize(10))
 *    http://www.apache.org/licenses/LICENSE-2.0
                jsonBuilder().startObject()
import static org.opensearch.index.query.QueryBuilders.matchQuery;
        settings.put(SETTING_NUMBER_OF_SHARDS, 1);  
                    );  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;  
        assertFirstHit(searchResponse, hasId("6"));  
        assertThirdHit(searchResponse, hasId("3"));  
        assertThirdHit(searchResponse, hasId("1"));
        SearchResponse searchResponse = client().prepareSearch()
import org.opensearch.search.sort.SortBuilders;
        assertFirstHit(searchResponse, hasId("3"));
import static org.opensearch.index.query.QueryBuilders.termQuery;
            ).setSettings(builder)
        client().prepareIndex("test").setId("10").setSource("field1", "1st street boston massachusetts").get();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    }
        assertAcked(prepareCreate("test"));
                .get()
        }
                    ).setQueryWeight(0.0f).setRescoreQueryWeight(1.0f),  
                .addSort(SortBuilders.fieldSort("number"))
        client().prepareIndex("test").setId("3").setSource("field1", "boston avenue lexington massachusetts").get();
                .setExplain(true)
                    assertFirstHit(rescored, hasId(String.valueOf(i + 1)));
    }
        client().prepareIndex("test").setId("7").setSource("field1", "bosten street san franciso california").get();  
                3
                    .endObject()
        assertThat(leftHits.getTotalHits().value(), equalTo(rightHits.getTotalHits().value()));
    public void testEquivalence() throws Exception {
    }
                20
import org.opensearch.common.settings.Settings.Builder;
            .startObject("properties")
                    Explanation explanation = searchResponse.getHits().getAt(j).getExplanation();
            .setQuery(QueryBuilders.matchQuery("field1", "the quick brown").operator(Operator.OR))
                .get();
                    .startObject("field1")
                .setTrackScores(true)  
import org.opensearch.common.xcontent.XContentFactory;  
        client().prepareIndex("test")  
        refresh();  
                searchResponse = client().prepareSearch()
                    .setRescoreQueryWeight(2.0f),
 * You may obtain a copy of the License at  
        assertEquals(4, request.get().getHits().getHits().length);  
        }
        assertNotNull(exc.getCause());
            final String[] matchedQueries = { "hello-world" };
                    assertThat(explanation.getDescription(), equalTo(descriptionModes[outerMode]));  
            .endObject()
                    new QueryRescorerBuilder(constantScoreQuery(matchPhraseQuery("field1", intToEnglish).slop(3))).setQueryWeight(1.0f)
                .get()
                    assertSecondHit(rescored, hasId(String.valueOf(i + 1)));
                    .endObject()
        Builder settings = Settings.builder();
        );  
import org.opensearch.search.SearchHit;  
            assertHitCount(searchResponse, 3);  
                    assertThat(rescored.getHits().getHits()[1].getScore(), equalTo(2.0f * primaryWeight + 5.0f * secondaryWeight));  
            .endObject()
        client().admin().indices().prepareRefresh("test").get();
            .setRescorer(new QueryRescorerBuilder(matchPhraseQuery("field1", "the quick brown").slop(3)), 5)
        client().prepareIndex("test").setId("2").setSource("field1", "the quick lazy huge brown fox jumps over the tree ").get();
        assertThat(searchResponse.getHits().getMaxScore(), equalTo(searchResponse.getHits().getHits()[0].getScore()));  
                    .startObject("field1")
            String query = intToEnglish.split(" ")[0];  
                assertHitCount(rescored, 4);
        }  
        QueryRescorerBuilder ninetyIsGood = new QueryRescorerBuilder(
        client().prepareIndex("test").setId("1").setSource("field1", "lexington massachusetts avenue").get();
                new QueryRescorerBuilder(matchPhraseQuery("field1", "lexington avenue massachusetts").slop(3)).setQueryWeight(1.0f)
                    rescoreQuery.setScoreMode(QueryRescoreMode.fromString(scoreMode));
        client().prepareIndex("test").setId("3").setSource("field1", "massachusetts").get();  
        assertThat(searchResponse.getHits().getMaxScore(), equalTo(searchResponse.getHits().getHits()[0].getScore()));  
 * Licensed to Elasticsearch under one or more contributor  
        response = request.setSize(1).clearRescorers().addRescorer(eightIsGreat, numDocs).addRescorer(sevenIsBetter, 1).get();  
    public QueryRescorerIT(Settings staticSettings) {
            )
        assertFirstHit(searchResponse, hasId("3"));
                    .field("type", "text")  
    // Tests a rescore window smaller than number of hits:
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
        assertFirstHit(searchResponse, hasId("3"));  
import org.opensearch.index.query.Operator;
        }
                if (!"".equals(scoreModes[outerMode])) {  
import org.opensearch.action.search.SearchResponse;
        assertSecondHit(searchResponse, hasId("6"));
            .setSource("field1", "quick huge brown", "field2", "the quick lazy huge brown fox jumps over the tree")
                .setTrackScores(true)  
        searchResponse = client().prepareSearch()
            String intToEnglish = English.intToEnglish(between(0, numDocs - 1));
                }
        assertThat(searchResponse.getHits().getMaxScore(), equalTo(searchResponse.getHits().getHits()[0].getScore()));  
        refresh();
        assertThat(searchResponse.getHits().getHits().length, equalTo(5));
        Builder builder = Settings.builder();
package org.opensearch.search.functionscore;
        client().prepareIndex("test").setId("6").setSource("field1", "massachusetts avenue lexington massachusetts").get();
            }
                .get();  
        assertThat(searchResponse.getHits().getHits().length, equalTo(5));
    private static final Comparator<SearchHit> searchHitsComparator = new Comparator<SearchHit>() {  
        SearchResponse response = request.get();
                    assertFirstHit(rescored, hasId(String.valueOf(i + 1)));
    };
                .setSearchType(SearchType.QUERY_THEN_FETCH)  
        assertHitCount(searchResponse, 4);
        settings.put(SETTING_NUMBER_OF_REPLICAS, 0);
        client().admin().indices().prepareRefresh("test").get();
            .setSize(5)
                    assertThat(rescored.getHits().getHits()[3].getScore(), equalTo((0.2f * primaryWeight) / 2.0f));
        // this
                    assertFirstHit(rescored, hasId(String.valueOf(i + 2)));  
                    .setRescoreQueryWeight(0.4f);
                )
            .setSize(5)
        );  
 * under the License.  
        SearchHit[] rHits = rightHits.getHits();
                    .field("type", "text")
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)  
        // Now, penalizing rescore (nothing matches the rescore query):
            SearchResponse searchResponse = client().prepareSearch()
        assertThat(searchResponse.getHits().getMaxScore(), equalTo(searchResponse.getHits().getHits()[0].getScore()));
                .get();
            .setRescorer(
        assertFourthHit(searchResponse, hasId("2"));  
                )  
                .setSize(resultSize)
import org.apache.lucene.tests.util.English;
        exc = expectThrows(
        for (SearchHit hit : resp.getHits().getHits()) {
        request.setFrom(1);
            .endObject();
    }
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));
import org.opensearch.index.query.QueryBuilders;
            .get();  
            .get();
                    assertSecondHit(rescored, hasId(String.valueOf(i)));
        client().admin().indices().prepareRefresh("test").get();  
        refresh();
                    .should(functionScoreQuery(termQuery("field1", intToEnglish[2]), weightFactorFunction(5.0f)).boostMode(REPLACE))
                    .field("type", "text")  
            }
import org.opensearch.action.index.IndexRequestBuilder;
                    .setQuery(QueryBuilders.matchQuery("field1", "the quick brown").operator(Operator.OR))  
                    .addRescorer(innerRescoreQuery, 5)
            if (hits[i].getScore() == hits[hits.length - 1].getScore()) {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFirstHit;
        client().prepareIndex("test").setId("8").setSource("field1", "hollywood boulevard los angeles california").get();
                )
            .setFrom(0)  
            .field("type", "text")
            // check equivalence
                    assertThat(rescored.getHits().getHits()[3].getScore(), equalTo(0.2f * primaryWeight));
    public void testScoring() throws Exception {
            // we cannot assert that they are equal since some shards might not have docs at all  
 * this file be licensed under the Apache-2.0 license or a
                    .setPreference("test") // ensure we hit the same shards for tie-breaking  
        response = request.setSize(2).get();
                    English.intToEnglish(i + 3) };
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            .get();
import org.opensearch.common.settings.Settings;
            for (int i = 0; i < 3; i++) {
                    .startObject("properties")
    // Tests a rescorer that penalizes the scores:  
        assertNotNull(exc.getCause());
                return hit1.getId().compareTo(hit2.getId());
        client().prepareIndex("test").setId("4").setSource("field1", "boston road lexington massachusetts").get();  
            .get();
                    assertThirdHit(rescored, hasId(String.valueOf(i + 2)));  
                new QueryRescorerBuilder(matchPhraseQuery("field1", "quick brown").slop(2).boost(4.0f)).setRescoreQueryWeight(2),  
                    .endObject()
            .field("analyzer", "whitespace")  
                assertFirstHit(searchResponse, hasId("1"));  
                    assertThat(rescored.getHits().getHits()[1].getScore(), equalTo(5.0f * secondaryWeight));
        float primaryWeight = 1.1f;
        indexRandomForConcurrentSearch("test");  
            client().prepareIndex("test").setId("" + i).setSource("text", "hello world").get();
    public void testEnforceWindowSize() throws InterruptedException {
        client().admin().indices().prepareRefresh("test").get();
            .startObject("properties")
                .setRescorer(
            .setId("3")
        QueryRescorerBuilder sevenIsBetter = new QueryRescorerBuilder(
                } else if ("multiply".equals(scoreMode)) {  
        assertHitCount(searchResponse, 4);
            // check equivalence  
                .addRescorer(new QueryRescorerBuilder(matchAllQuery()), 50)
            .setFrom(0)
        assertThat(searchResponse.getHits().getMaxScore(), equalTo(searchResponse.getHits().getHits()[0].getScore()));
                rescoreQuery.setQueryWeight(primaryWeight).setRescoreQueryWeight(secondaryWeight);
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("2"));  
        SearchHits rightHits = rescored.getHits();
        // Now, rescore only top 2 hits w/ proximity:  
                    .setRescoreQueryWeight(2.0f),  
            assertSecondHit(searchResponse, hasMatchedQueries(matchedQueries));
        request.addRescorer(new QueryRescorerBuilder(matchAllQuery()), 50);
                assertThat(searchResponse.getHits().getAt(i).getExplanation(), notNullValue());  
            assertThat(hit.getScore(), equalTo(101f));  
        assertHitCount(searchResponse, 9);  
        assertHitCount(searchResponse, 9);
                innerRescoreQuery.setScoreMode(QueryRescoreMode.fromString(scoreModes[innerMode]));
        int numDocs = indexRandomNumbers("keyword");
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("f", Integer.toString(i)).get();
        // Only top 3 hits were re-ordered:
                .setPreference("test") // ensure we hit the same shards for tie-breaking
import static org.opensearch.index.query.QueryBuilders.boolQuery;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                        1.0f
        }
        client().prepareIndex("test").setId("2").setSource("field1", "lexington avenue boston massachusetts road").get();
            .startObject("properties")  
    }  
    public void testExplain() throws Exception {
                .setSearchType(SearchType.QUERY_THEN_FETCH)
    }  
                    boolQuery().should(
                    assertThat(rescored.getHits().getHits()[1].getScore(), equalTo(5.0f * primaryWeight));  
            .addSort(SortBuilders.scoreSort())
        assertFourthHit(searchResponse, hasId("2"));  
        client().admin().indices().prepareRefresh("test").get();  
            assertFirstHit(searchResponse, hasId("1"));
 * GitHub history for details.
    @ParametersFactory  
                    assertThat(rescored.getHits().getHits()[0].getScore(), equalTo(3.0f * primaryWeight + 7.0f * secondaryWeight));
        assertSecondHit(searchResponse, hasId("6"));  
                    assertThat(rescored.getHits().getHits()[0].getScore(), equalTo(7.0f * secondaryWeight));
        assertFirstHit(searchResponse, hasId("1"));
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;  
            prepareCreate("test").setMapping(
            .startObject()
                .addSort(SortBuilders.scoreSort())
        float secondaryWeight = 1.6f;  
 * software distributed under the License is distributed on an
            .get();  
                .setSize(resultSize)  
                    assertThat(rescored.getHits().getHits()[2].getScore(), equalTo((2.0f * primaryWeight + 5.0f * secondaryWeight) / 2.0f));
                new QueryRescorerBuilder(matchPhraseQuery("field1", "lexington avenue massachusetts").slop(3)).setQueryWeight(0.6f)  
                    .startObject("properties")  
    // #11277  
import java.util.Comparator;  
        }
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        client().prepareIndex("test").setId("2").setSource("field1", "lexington avenue boston massachusetts").get();  
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("3"));
                20
            assertEquivalent(query, plain, rescored);
                    1
            .setId("3")
        assertHitCount(searchResponse, 9);  
        assertThat(leftHits.getHits().length, equalTo(rightHits.getHits().length));  
        assertAcked(prepareCreate("test").setSettings(settings));
        client().prepareIndex("test").setId("6").setSource("field1", "massachusetts avenue lexington massachusetts").get();
                    assertThat(rescored.getHits().getHits()[2].getScore(), equalTo(5.0f * primaryWeight));  
            .startObject()
                    new QueryRescorerBuilder(constantScoreQuery(matchPhraseQuery("field1", "not in the index").slop(3))).setQueryWeight(  
        );
    public void testMoreDocs() throws Exception {  
            prepareCreate("test").setMapping(
        assertThirdHit(searchResponse, hasId("3"));
        ensureGreen();  
            .setRescorer(
            SearchResponse rescored = client().prepareSearch()
                assertThirdHit(searchResponse, hasId("3"));
                .setQuery(QueryBuilders.matchAllQuery())  
                20  
        client().prepareIndex("test")  
    // This comparator uses a custom tie in case the scores are equal, so that both regular hits and rescored hits
        assertAcked(  
                .setRescorer(innerRescoreQuery, 5)
        searchResponse = client().prepareSearch()  
    public void testRescorerMadeScoresWorse() throws Exception {
        request.setQuery(QueryBuilders.termQuery("text", "hello"));
            client().admin().indices().prepareCreate("test").setMapping(mapping).setSettings(builder.put("index.number_of_shards", 1))
        searchResponse = client().prepareSearch()
        assertAcked(
    }
                    .setSize(10)
                    assertFirstHit(rescored, hasId(String.valueOf(i + 1)));
                .setExplain(true)
                    assertThat(searchResponse.getHits().getAt(i).getExplanation().getDescription(), equalTo("sum of:"));
            .startObject("field1")
            .setRescorer(new QueryRescorerBuilder(matchPhraseQuery("field1", "the quick brown")), 5)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
                            CombineFunction.REPLACE
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
                    assertThat(rescored.getHits().getHits()[1].getScore(), equalTo(3.0f * primaryWeight));
            )
                );
        assertThirdHit(searchResponse, hasId("6"));  
            assertSecondHit(searchResponse, hasId("2"));  
        assertThat(exc.getCause().getMessage(), containsString("Cannot use [sort] option in conjunction with [rescore]."));
        client().prepareIndex("test").setId("1").setSource("field1", "the quick brown fox").get();
                .setFrom(0)
        assertThat(exc.getCause().getMessage(), containsString("Cannot use [sort] option in conjunction with [rescore]."));
import org.opensearch.core.xcontent.XContentBuilder;
        public int compare(SearchHit hit1, SearchHit hit2) {
                .setFrom(0)  
                .setRescoreQueryWeight(0.4f);
        assertFirstHit(response, hasId("8"));
            int rescoreWindow = between(1, 3) * resultSize;
            )
            assertThirdHit(searchResponse, hasId("3"));  
    }
                jsonBuilder().startObject()
                    assertThat(rescored.getHits().getHits()[3].getScore(), equalTo(0.2f * primaryWeight + 0.0f * secondaryWeight));
        int numDocs = indexRandomNumbers("whitespace", -1, false);
            functionScoreQuery(termQuery("field1", English.intToEnglish(8)), ScoreFunctionBuilders.weightFactorFunction(1000.0f)).boostMode(
        XContentBuilder mapping = XContentFactory.jsonBuilder()  
import java.util.Arrays;
                    .setRescoreQueryWeight(2.0f),
            if (!"".equals(scoreModes[innerMode])) {  
            prepareCreate("test").setMapping(
        {
                for (int j = 0; j < 3; j++) {
                return cmp;
                .setQuery(QueryBuilders.matchQuery("field1", query).operator(Operator.OR))  
        }
        indexRandomForConcurrentSearch("test");
            assertEquivalent(query, plain, rescored);  
        for (String scoreMode : scoreModes) {
            .field("type", "text")  
                if (score == 100f) {
        createIndex("test");  
            )  
                    .setQueryWeight(0.5f)  
                .setPreference("test") // ensure we hit the same shards for tie-breaking  
            .endObject()  
            assertSearchResponse(searchResponse);
                SearchResponse rescored = client().prepareSearch()
            .get();  
 * ownership. Elasticsearch licenses this file to you under  
        client().prepareIndex("test").setId("1").setSource("field1", "lexington massachusetts avenue").get();  
                        // no weight - so we basically use the same score as the actual query  
        assertFirstHit(searchResponse, hasId("1"));  
        assertSecondHit(response, hasScore(1001.0f)); // Not sure which one it is but it is ninety something
    }  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasMatchedQueries;
import static org.hamcrest.Matchers.containsString;  
            Exception.class,  
                    assertThirdHit(rescored, hasId(String.valueOf(i)));
                    rescoreWindow
        int iters = scaledRandomIntBetween(10, 20);
        }
        client().admin().indices().prepareRefresh("test").get();
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                    .get();
            .setRescorer(
            for (int j = 0; j < 3; j++) {  
            }  
                    .should(functionScoreQuery(termQuery("field1", intToEnglish[1]), weightFactorFunction(3.0f)).boostMode(REPLACE))
                .setQuery(QueryBuilders.matchQuery("field1", query).operator(Operator.OR))
        assertSecondHit(searchResponse, hasId("6"));
                    English.intToEnglish(i + 1),  
                } else if ("min".equals(scoreMode)) {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;  
        String[] scoreModes = new String[] { "max", "min", "avg", "total", "multiply", "" };
            )
        QueryRescorerBuilder eightIsGreat = new QueryRescorerBuilder(  
            .setSize(5)
        assertFirstHit(searchResponse, hasId("1"));
        ).setScoreMode(QueryRescoreMode.Total);  
}  
        assertThat(resp.getHits().getHits().length, equalTo(5));
                new QueryRescorerBuilder(matchPhraseQuery("field1", "lexington avenue massachusetts").slop(3)).setQueryWeight(0.6f)
                    new QueryRescorerBuilder(matchPhraseQuery("field1", "the quick brown").slop(2).boost(4.0f)).setQueryWeight(0.5f)  
        client().prepareIndex("test").setId("5").setSource("field1", "lexington street lexington massachusetts").get();
            .setQuery(QueryBuilders.matchQuery("field1", "lexington avenue massachusetts").operator(Operator.OR))  
 * this work for additional information regarding copyright
                    .endObject()  
                    assertThat(rescored.getHits().getHits()[0].getScore(), equalTo((3.0f * primaryWeight + 7.0f * secondaryWeight) / 2.0f));
        String[] scoreModes = new String[] { "max", "min", "avg", "total", "multiply", "" };
import org.opensearch.search.SearchHits;
        Builder builder = Settings.builder();
        assertFirstHit(searchResponse, hasId("2"));
                .get();  
    }
                float score = searchResponse.getHits().getHits()[i].getScore();  
        assertThat(searchResponse.getHits().getMaxScore(), equalTo(searchResponse.getHits().getHits()[0].getScore()));
        assertThat(searchResponse.getHits().getHits().length, equalTo(4));  
        client().prepareIndex("test").setId("1").setSource("field1", "the quick brown fox").get();
                assertHitCount(searchResponse, 3);
                } else if ("avg".equals(scoreMode)) {
                    .endObject()
    public void testMultipleRescores() throws Exception {
        return Arrays.asList(
                )  
        ).setScoreMode(QueryRescoreMode.Total);
            .setSize(5)  
            )
                .setSize(resultSize)
                    assertThirdHit(rescored, hasId(String.valueOf(i + 2)));
        );  
        SearchRequestBuilder request = client().prepareSearch();  
                        )
                    5
                .setQuery(QueryBuilders.matchQuery("field1", "the quick brown").operator(Operator.OR).queryName("hello-world"))  
            assertFirstHit(searchResponse, hasId("1"));
    // Comparator that sorts hits and rescored hits in the same way.
            .setRescorer(
            .startObject("field1")  
        indexRandom(true, dummyDocs, docs);
import org.opensearch.action.search.SearchType;
            client().admin().indices().prepareCreate("test").setMapping(mapping).setSettings(builder.put("index.number_of_shards", 1))
        indexRandomForConcurrentSearch("test");
                    assertThirdHit(rescored, hasId(String.valueOf(i)));
                .setSize(randomIntBetween(2, 10))  
            .setQuery(QueryBuilders.matchQuery("field1", "lexington avenue massachusetts").operator(Operator.OR))
                .setQuery(QueryBuilders.matchQuery("field1", "the quick brown").operator(Operator.OR))
    public void testRescorePhaseWithInvalidSort() throws Exception {  
                    English.intToEnglish(i),
                    .setRescorer(rescoreQuery, 50)
        // Now, rescore only top 3 hits w/ proximity:
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
 * KIND, either express or implied.  See the License for the
        SearchResponse resp = client().prepareSearch()
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                assertThat(searchResponse.getHits().getAt(j).getExplanation().getDescription(), equalTo(descriptionModes[innerMode]));
                    .field("analyzer", analyzer)  
            assertFirstHit(searchResponse, hasMatchedQueries(matchedQueries));  
        // Now squash the second rescore window so it never gets to see a seven
        @Override
import org.opensearch.index.query.functionscore.ScoreFunctionBuilders;
import static org.opensearch.index.query.QueryBuilders.functionScoreQuery;
        final int iters = scaledRandomIntBetween(50, 100);
        assertHitCount(searchResponse, 4);
                    .field("analyzer", "whitespace")
        assertThat(searchResponse.getHits().getHits().length, equalTo(5));
                        searchResponse.getHits().getAt(i).getExplanation().getDetails()[0].getDetails()[1].getValue(),  
                        equalTo(0.4f)
public class QueryRescorerIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
        client().prepareIndex("test").setId("9").setSource("field1", "1st street boston massachussetts").get();  
        }
        refresh();  
                        .setRescoreQueryWeight(0.4f),
                    .get();
            .get();  
            for (int outerMode = 0; outerMode < scoreModes.length; outerMode++) {
        assertFirstHit(response, hasScore(2001.0f));
        assertThat(searchResponse.getHits().getHits().length, equalTo(4));  
import static org.opensearch.index.query.QueryBuilders.constantScoreQuery;
            functionScoreQuery(queryStringQuery("*one*"), ScoreFunctionBuilders.weightFactorFunction(1000.0f)).boostMode(
            .get();  
    // and shard id are equal during merging shard results.  
        QueryRescorerBuilder oneToo = new QueryRescorerBuilder(
                } else if ("max".equals(scoreMode)) {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFourthHit;  
    public static Collection<Object[]> parameters() {
    }
                .get();
        assertHitCount(searchResponse, 4);
import static org.opensearch.common.lucene.search.function.CombineFunction.REPLACE;
            assertThat(numDocsWith100AsAScore, lessThanOrEqualTo(numShards));
        searchResponse = client().prepareSearch()
        ).setScoreMode(QueryRescoreMode.Total);
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.weightFactorFunction;
                    .endObject()  
                }  
        if (shards > 0) {  
        SearchResponse searchResponse = client().prepareSearch()  
            assertFirstHit(searchResponse, hasScore(100.f));  
            .setFrom(2)  
        assertAcked(  
                }
        assertThat(searchResponse.getHits().getMaxScore(), equalTo(searchResponse.getHits().getHits()[0].getScore()));
            }  
        assertThat(searchResponse.getHits().getHits().length, equalTo(4));  
                if ("total".equals(scoreMode) || "".equals(scoreMode)) {
            }
    }
            functionScoreQuery(termQuery("field1", English.intToEnglish(7)), ScoreFunctionBuilders.weightFactorFunction(10000.0f))  
 * Unless required by applicable law or agreed to in writing,
/*  
        assertThirdHit(searchResponse, hasId("3"));
import org.opensearch.index.query.QueryBuilder;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSecondHit;
            .get();  
 * The OpenSearch Contributors require contributions made to  
            .setQuery(QueryBuilders.matchQuery("field1", "the quick brown").operator(Operator.OR))
            .startObject("field1")
 */  
                } else {  
    }
            .setFrom(0)
                    .startObject("field1")
        assertThat(resp.getHits().getTotalHits().value(), equalTo(5L));  
        }
        assertFourthHit(searchResponse, hasId("2"));
            .setFrom(0)
 *
                QueryBuilder query = boolQuery().should(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertThirdHit;
        // We have no idea what the second hit will be because we didn't get a chance to look for seven
                return; // we need to cut off here since this is the tail of the queue and we might not have fetched enough docs
        Arrays.sort(hits, searchHitsComparator);  
                String[] intToEnglish = new String[] {
        assertThirdHit(searchResponse, hasId("3"));  
    }  
        request.addRescorer(eightIsGreat, numDocs).addRescorer(sevenIsBetter, numDocs);  
        assertSecondHit(response, hasId("8"));  
                assertThat(searchResponse.getHits().getAt(i).getExplanation().isMatch(), equalTo(true));
        }
        indexRandomForConcurrentSearch("test");
                    .setRescoreQueryWeight(2.0f),  
            int numDocsWith100AsAScore = 0;
        assertAcked(
                    assertThat(rescored.getHits().getHits()[3].getScore(), equalTo(0.2f * primaryWeight * 0.0f * secondaryWeight));
            assertSecondHit(searchResponse, hasId("2"));
        assertSecondHit(searchResponse, hasId("6"));
                    .endObject()
            )
                        .setRescoreQueryWeight(0.0f),
                    )
 *  
            .setSize(5)  
        client().prepareIndex("test").setId("2").setSource("field1", "the quick lazy huge brown fox jumps over the tree").get();
            .get();  
        assertFirstHit(response, hasId("91"));  
            .endObject()  
            .setSize(5)
        return numDocs;  
            .startObject()  
        SearchResponse searchResponse = client().prepareSearch()  
            Exception.class,
            .setSize(5)
                    .setRescoreQueryWeight(2.0f),  
                    .should(functionScoreQuery(termQuery("field1", intToEnglish[3]), weightFactorFunction(0.2f)).boostMode(REPLACE));  
import java.util.Collection;
 * Modifications Copyright OpenSearch Contributors. See
                    numDocsWith100AsAScore += 1;
                        .should(functionScoreQuery(termQuery("field1", intToEnglish[1]), weightFactorFunction(7.0f)).boostMode(REPLACE))
    public void testSmallRescoreWindow() throws Exception {
            rescored = client().prepareSearch()
            ).setSettings(Settings.builder().put(indexSettings()).put("index.number_of_shards", 1))
            .setQuery(QueryBuilders.matchQuery("field1", "massachusetts").operator(Operator.OR))
        client().prepareIndex("test").setId("11").setSource("field1", "2st street boston massachusetts").get();  
        Exception exc = expectThrows(
        // 6 and 1 got worse, and then the hit (2) outside the rescore window were sorted ahead:
            .field("type", "text")
import org.opensearch.search.rescore.QueryRescorerBuilder;  
        SearchHits leftHits = plain.getHits();  
                    assertSecondHit(rescored, hasId(String.valueOf(i)));  
        for (int i = 0; i < numDocs; i++) {  
        return indexRandomNumbers(analyzer, -1, true);  
                QueryRescorerBuilder rescoreQuery = new QueryRescorerBuilder(
                .addSort(SortBuilders.fieldSort("number"))
            .setQuery(QueryBuilders.matchQuery("field1", "lexington avenue massachusetts").operator(Operator.OR))
                .setQueryWeight(0.5f)  
        XContentBuilder mapping = XContentFactory.jsonBuilder()
