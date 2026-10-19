    private int indexRandomNumbers(String analyzer, int shards, boolean dummyDocs) throws Exception {
        Arrays.sort(hits, searchHitsComparator);
        client().admin().indices().prepareRefresh("test").get();
        assertThat(searchResponse.getHits().getHits()[2].getId(), equalTo("2"));
                jsonBuilder().startObject()
        );
                }
                } else if ("multiply".equals(scoreMode)) {
                )
        assertAcked(prepareCreate("test"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSecondHit;
                    ).setQueryWeight(0.0f).setRescoreQueryWeight(1.0f),
import org.opensearch.index.query.QueryBuilder;
        searchResponse = client().prepareSearch()
import org.opensearch.index.query.QueryBuilders;
        QueryRescorerBuilder sevenIsBetter = new QueryRescorerBuilder(
        refresh();
        assertEquals(4, request.get().getHits().getHits().length);
                    .setRescoreQueryWeight(2.0f),
        client().prepareIndex("test").setId("2").setSource("field1", "lexington avenue boston massachusetts road").get();
            functionScoreQuery(termQuery("field1", English.intToEnglish(8)), ScoreFunctionBuilders.weightFactorFunction(1000.0f)).boostMode(
        int numShards = getNumShards("test").numPrimaries;
            assertFirstHit(searchResponse, hasScore(100.f));
                searchResponse = client().prepareSearch()
    }
        SearchHits rightHits = rescored.getHits();
        int numDocs = randomIntBetween(100, 150);
            .startObject("properties")
            .setFrom(0)
                    );
        assertAcked(
                .get()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            int resultSize = numDocs;
    }
                        equalTo(0.4f)
        indexRandomForConcurrentSearch("test");
            QueryRescorerBuilder innerRescoreQuery = new QueryRescorerBuilder(matchQuery("field1", "the quick brown").boost(4.0f))
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            .setFrom(0)
                    assertFirstHit(rescored, hasId(String.valueOf(i + 1)));
                    .addRescorer(outerRescoreQuery.windowSize(10))
                    assertThat(rescored.getHits().getHits()[3].getScore(), equalTo((0.2f * primaryWeight) / 2.0f));
            .setRescorer(
                    rescoreWindow
        // Now, rescore only top 2 hits w/ proximity:
        );
        client().prepareIndex("test").setId("3").setSource("field1", "massachusetts").get();
import static org.hamcrest.Matchers.containsString;
        client().prepareIndex("test").setId("2").setSource("field1", "the quick lazy huge brown fox jumps over the tree").get();
    public void testMultipleRescores() throws Exception {
        client().prepareIndex("test").setId("2").setSource("field1", "the quick lazy huge brown fox jumps over the tree ").get();
                        // no weight - so we basically use the same score as the actual query
            assertHitCount(searchResponse, 3);
            assertEquivalent(query, plain, rescored);
                .addSort(SortBuilders.scoreSort())
        settings.put(SETTING_NUMBER_OF_SHARDS, 1);
            .setQuery(QueryBuilders.matchQuery("field1", "lexington avenue massachusetts").operator(Operator.OR))
        client().prepareIndex("test").setId("6").setSource("field1", "massachusetts avenue lexington massachusetts").get();
            .get();
            .setFrom(0)
                assertSecondHit(searchResponse, hasId("2"));
            .get();
import static org.opensearch.index.query.QueryBuilders.matchQuery;
 * GitHub history for details.
            .startObject()
                        functionScoreQuery(matchAllQuery(), ScoreFunctionBuilders.weightFactorFunction(100)).boostMode(
            }
            .setRescorer(
            .get();
        assertNoFailures(rescored);
    @ParametersFactory
                    .endObject()
        );
            assertThat("query: " + query, hits[i].getScore(), equalTo(rHits[i].getScore()));
                2
                    assertThat(explanation.getDetails()[0].getDetails()[0].getDescription(), equalTo(descriptionModes[innerMode]));
        }
            .setRescorer(new QueryRescorerBuilder(matchPhraseQuery("field1", "the quick brown").slop(3)), 5)
        createIndex("test");
/*
            .get();
        assertThat(searchResponse.getHits().getHits()[1].getId(), equalTo("3"));
        for (int i = 0; i < hits.length; i++) {
                    .endObject()
        assertSecondHit(response, hasId("8"));
        super(staticSettings);
            assertFirstHit(searchResponse, hasMatchedQueries(matchedQueries));
                } else {
    // and shard id are equal during merging shard results.
        assertSecondHit(searchResponse, hasId("6"));
        Builder builder = Settings.builder().put(indexSettings());
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            .setFrom(0)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFirstHit;
        }
                        .should(functionScoreQuery(termQuery("field1", intToEnglish[1]), weightFactorFunction(7.0f)).boostMode(REPLACE))
 * Licensed to Elasticsearch under one or more contributor
            .get();
        indexRandomForConcurrentSearch("test");
    public void testEnforceWindowSize() throws InterruptedException {
import org.opensearch.action.search.SearchRequestBuilder;
    // The rescore uses the docId as tie, while regular search uses the slot the hit is in as a tie if score
        client().prepareIndex("test").setId("1").setSource("field1", "lexington massachusetts avenue").get();
                QueryRescorerBuilder outerRescoreQuery = new QueryRescorerBuilder(matchQuery("field1", "the quick brown").boost(4.0f))
                .setPreference("test") // ensure we hit the same shards for tie-breaking
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                CombineFunction.REPLACE
            .setRescorer(new QueryRescorerBuilder(matchPhraseQuery("field1", "the quick brown")), 5)
        SearchHits leftHits = plain.getHits();
        client().prepareIndex("test").setId("9").setSource("field1", "1st street boston massachussetts").get();
            .field("analyzer", "whitespace")
                .setSearchType(SearchType.QUERY_THEN_FETCH)
        assertThat(searchResponse.getHits().getMaxScore(), equalTo(searchResponse.getHits().getHits()[0].getScore()));
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.index.query.QueryBuilders.constantScoreQuery;
    }
        int iters = scaledRandomIntBetween(10, 20);
            for (int i = 0; i < numDocs - 4; i++) {
            // check equivalence
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
        Builder builder = Settings.builder();
        ).setScoreMode(QueryRescoreMode.Total);
        XContentBuilder mapping = XContentFactory.jsonBuilder()
                    assertSecondHit(rescored, hasId(String.valueOf(i + 2)));
        }
            .addSort(SortBuilders.scoreSort())
 */
                    functionScoreQuery(termQuery("field1", intToEnglish[0]), weightFactorFunction(2.0f)).boostMode(REPLACE)
                .addRescorer(new QueryRescorerBuilder(matchAllQuery()), 50)
        client().prepareIndex("test").setId("1").setSource("field1", "the quick brown fox").get();
        SearchHit[] hits = leftHits.getHits();
            .get();
        assertHitCount(searchResponse, 3);
                    .endObject()
                QueryRescorerBuilder rescoreQuery = new QueryRescorerBuilder(
        refresh();
import org.opensearch.search.rescore.QueryRescoreMode;
 * SPDX-License-Identifier: Apache-2.0
        searchResponse = client().prepareSearch()
    }
            final String[] matchedQueries = { "hello-world" };
                    new QueryRescorerBuilder(
            .setSource("field1", "quick huge brown", "field2", "the quick lazy huge brown fox jumps over the tree")
            .setRescorer(
        request.setFrom(1);
                    assertSecondHit(rescored, hasId(String.valueOf(i)));
        searchResponse = client().prepareSearch()
                    .endObject()
import org.opensearch.common.lucene.search.function.CombineFunction;
        assertThat(searchResponse.getHits().getHits().length, equalTo(4));
    public void testFromSize() throws Exception {
            .field("analyzer", "whitespace")
            .addRescorer(new QueryRescorerBuilder(matchAllQuery()).setRescoreQueryWeight(100.0f), 50)
                    assertThat(rescored.getHits().getHits()[1].getScore(), equalTo(3.0f * primaryWeight));
        assertThirdHit(searchResponse, hasId("3"));
        int numDocs = indexRandomNumbers("whitespace", -1, false);
                    assertThat(explanation.getDescription(), equalTo(descriptionModes[outerMode]));
        String[] scoreModes = new String[] { "max", "min", "avg", "total", "multiply", "" };
        for (int i = 0; i < numDocs; i++) {
 * not use this file except in compliance with the License.
                    assertThat(rescored.getHits().getHits()[2].getScore(), equalTo(5.0f * primaryWeight));
        request.addRescorer(eightIsGreat, numDocs).addRescorer(sevenIsBetter, numDocs);
            .setSize(5)
    }
        Exception exc = expectThrows(
                20
            .get();
        );
                SearchResponse rescored = client().prepareSearch()
                new QueryRescorerBuilder(matchPhraseQuery("field1", "lexington avenue massachusetts").slop(3)).setQueryWeight(0.6f)
        SearchHit[] rHits = rightHits.getHits();
        assertFirstHit(searchResponse, hasId("3"));
    // Tests a rescorer that penalizes the scores:
            .setRescorer(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertThirdHit;
 * this file be licensed under the Apache-2.0 license or a
            assertSecondHit(searchResponse, hasId("2"));
                .boostMode(CombineFunction.REPLACE)
        float primaryWeight = 1.1f;
        for (int i = 0; i < iters; i++) {
            }
            .setId("3")
 *
                assertThat(searchResponse.getHits().getAt(i).getExplanation().isMatch(), equalTo(true));
                    new QueryRescorerBuilder(matchPhraseQuery("field1", "the quick brown").slop(2).boost(4.0f)).setQueryWeight(0.5f)
            .setQuery(QueryBuilders.matchQuery("field1", "massachusetts"))
        assertHitCount(searchResponse, 4);
            builder.put(SETTING_NUMBER_OF_SHARDS, shards);
        assertAcked(prepareCreate("test").setSettings(settings));
            .startObject()
        assertFirstHit(searchResponse, hasId("2"));
import static org.opensearch.index.query.QueryBuilders.matchPhraseQuery;
                assertHitCount(rescored, 4);
            if (cmp == 0) {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
                .setSize(randomIntBetween(2, 10))
    public void testRescorerMadeScoresWorse() throws Exception {
        final int iters = scaledRandomIntBetween(50, 100);
        client().admin().indices().prepareRefresh("test").get();
                    .startObject("field1")
        client().prepareIndex("test").setId("7").setSource("field1", "bosten street san franciso california").get();
                    .setSize(10)
        response = request.setSize(1).clearRescorers().addRescorer(eightIsGreat, numDocs).addRescorer(sevenIsBetter, 1).get();
    public void testRescorePhrase() throws Exception {
    }
        SearchResponse searchResponse = client().prepareSearch()
        SearchRequestBuilder request = client().prepareSearch();
            .startObject("field1")
import org.opensearch.common.settings.Settings.Builder;
            assertThat("query: " + query, hits[i].getId(), equalTo(rHits[i].getId()));
            assertThirdHit(searchResponse, hasId("3"));
        assertFirstHit(response, hasId("7"));
            prepareCreate("test").setMapping(
            .setSize(5)
                    numDocsWith100AsAScore += 1;
                    .endObject()
                    .setRescoreQueryWeight(0.4f);
        // Now, penalizing rescore (nothing matches the rescore query):
                .setQuery(QueryBuilders.matchQuery("field1", "the quick brown").operator(Operator.OR))
            .setQuery(QueryBuilders.matchQuery("field1", "massachusetts").operator(Operator.OR))
    public void testSmallRescoreWindow() throws Exception {
        String[] descriptionModes = new String[] { "max of:", "min of:", "avg of:", "sum of:", "product of:", "sum of:" };
 * under the License.
import org.opensearch.common.xcontent.XContentFactory;
                    .startObject("field1")
            .setFrom(0)
                    ).setRescoreQueryWeight(1.0f),
 */
import org.opensearch.search.sort.SortBuilders;
        assertThat(searchResponse.getHits().getMaxScore(), equalTo(searchResponse.getHits().getHits()[0].getScore()));
            )
        response = request.setSize(2).get();
            .field("type", "text")
        assertThat(searchResponse.getHits().getHits().length, equalTo(5));
                .addRescorer(new QueryRescorerBuilder(matchAllQuery()), 50)
                    5
                .setQuery(QueryBuilders.matchQuery("field1", "the quick brown").operator(Operator.OR).queryName("hello-world"))
        assertSecondHit(searchResponse, hasId("6"));
                3
        assertThat(searchResponse.getHits().getMaxScore(), equalTo(searchResponse.getHits().getHits()[0].getScore()));
                    assertThirdHit(rescored, hasId(String.valueOf(i + 2)));
                    English.intToEnglish(i + 3) };
    public void testRescorePhaseWithInvalidSort() throws Exception {
                for (int j = 0; j < 3; j++) {
import static org.hamcrest.Matchers.greaterThan;
        assertSecondHit(searchResponse, hasId("3"));
        ).setScoreMode(QueryRescoreMode.Total);
                if ("total".equals(scoreMode) || "".equals(scoreMode)) {
import org.opensearch.search.SearchHits;
                    assertFirstHit(rescored, hasId(String.valueOf(i + 1)));
            }
            .setRescorer(
            .setSize(5)
 */
                .get();
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.matchQuery("field1", query).operator(Operator.OR))
        assertThat(exc.getCause().getMessage(), containsString("Cannot use [sort] option in conjunction with [rescore]."));
        assertFirstHit(searchResponse, hasId("1"));
                        .setRescoreQueryWeight(0.0f),
        client().prepareIndex("test").setId("1").setSource("field1", "massachusetts avenue boston massachusetts").get();
import org.apache.lucene.search.Explanation;
        assertFourthHit(searchResponse, hasId("2"));
            .setSize(5)
            } else {
            .setQuery(QueryBuilders.matchQuery("field1", "massachusetts").operator(Operator.OR))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.core.xcontent.XContentBuilder;
        assertFourthHit(searchResponse, hasId("2"));
            .endObject();
 * Unless required by applicable law or agreed to in writing,
        request.clearRescorers().addRescorer(ninetyIsGood, numDocs).addRescorer(oneToo, 10);
                } else if ("min".equals(scoreMode)) {
            int cmp = Float.compare(hit2.getScore(), hit1.getScore());
 * software distributed under the License is distributed on an
                    assertFirstHit(rescored, hasId(String.valueOf(i + 2)));
        assertThat(searchResponse.getHits().getMaxScore(), equalTo(searchResponse.getHits().getHits()[0].getScore()));
                    .should(functionScoreQuery(termQuery("field1", intToEnglish[3]), weightFactorFunction(0.2f)).boostMode(REPLACE));
                5
        refresh();
                new QueryRescorerBuilder(matchPhraseQuery("field1", "lexington avenue massachusetts").slop(3)).setQueryWeight(0.6f)
                    .setQueryWeight(0.5f)
        refresh();
                    .setQuery(query)
            assertFirstHit(searchResponse, hasId("1"));
            .setRescorer(
                    assertThat(searchResponse.getHits().getAt(i).getExplanation().getDescription(), equalTo("sum of:"));
            .endObject()
        }
 * KIND, either express or implied.  See the License for the
        assertAcked(
import org.opensearch.search.rescore.QueryRescorerBuilder;
            String intToEnglish = English.intToEnglish(between(0, numDocs - 1));
    }
        );
        // First set the rescore window large enough that both rescores take effect
        client().prepareIndex("test").setId("6").setSource("field1", "massachusetts avenue lexington massachusetts").get();
        assertSecondHit(searchResponse, hasId("2"));
        );
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        client().prepareIndex("test").setId("1").setSource("field1", "lexington massachusetts avenue").get();
        assertAcked(
                .addSort(SortBuilders.fieldSort("number"))
        }
            assertThirdHit(searchResponse, hasId("3"));
        client().admin().indices().prepareRefresh("test").get();
        }
        indexRandomForConcurrentSearch("test");
        }
        // Now, rescore only top 3 hits w/ proximity:
                    assertThat(rescored.getHits().getHits()[3].getScore(), equalTo(0.0f * secondaryWeight));
        for (int i = 0; i < 5; i++) {
        searchResponse = client().prepareSearch()
            .setQuery(QueryBuilders.matchQuery("field1", "the quick brown").operator(Operator.OR))
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                    assertThat(rescored.getHits().getHits()[2].getScore(), equalTo(5.0f * primaryWeight));
            ).setSettings(Settings.builder().put(indexSettings()).put("index.number_of_shards", 1))
            )
            }
                new QueryRescorerBuilder(matchPhraseQuery("field1", "quick brown").slop(2).boost(4.0f)).setRescoreQueryWeight(2),
        );
                new QueryRescorerBuilder(matchPhraseQuery("field1", "lexington avenue massachusetts").slop(3)).setQueryWeight(0.6f)
        assertThirdHit(searchResponse, hasId("3"));
            // we cannot assert that they are equal since some shards might not have docs at all
    // This comparator uses a custom tie in case the scores are equal, so that both regular hits and rescored hits
                );
                    boolQuery().should(
import org.opensearch.action.index.IndexRequestBuilder;
import java.util.Comparator;
                if (!"".equals(scoreMode)) {
            .setQuery(QueryBuilders.matchQuery("field1", "massachusetts"))
                        .setRescoreQueryWeight(0.4f),
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            .endObject()
        }
                assertHitCount(searchResponse, 3);
        }
 *
        client().prepareIndex("test").setId("1").setSource("field1", "the quick brown fox").get();
        assertFirstHit(searchResponse, hasId("3"));
 * this work for additional information regarding copyright
                innerRescoreQuery.setScoreMode(QueryRescoreMode.fromString(scoreModes[innerMode]));
        assertFirstHit(response, hasId("91"));
                    assertThat(rescored.getHits().getHits()[3].getScore(), equalTo(0.2f * primaryWeight + 0.0f * secondaryWeight));
        indexRandom(true, dummyDocs, docs);
                assertThat(rescored.getHits().getMaxScore(), equalTo(rescored.getHits().getHits()[0].getScore()));
        );
            Exception.class,
            .get();
import static org.hamcrest.Matchers.notNullValue;
                .setRescoreQueryWeight(0.4f);
            .startObject("properties")
            .setId("3")
            }
        assertThat(searchResponse.getHits().getHits().length, equalTo(5));
                assertThat(searchResponse.getHits().getAt(j).getExplanation().getDescription(), equalTo(descriptionModes[innerMode]));
        request.addRescorer(new QueryRescorerBuilder(matchAllQuery()), 50);
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                    .setRescorer(rescoreQuery, 50)
        client().admin().indices().prepareRefresh("test").get();
        assertThat(leftHits.getHits().length, equalTo(rightHits.getHits().length));
            .startObject("field1")
        int numDocs = indexRandomNumbers("keyword");
                .setFrom(0)
                    Explanation explanation = searchResponse.getHits().getAt(j).getExplanation();
        return Arrays.asList(
        }
    public static Collection<Object[]> parameters() {
                    assertThat(searchResponse.getHits().getAt(i).getExplanation().getDetails()[1].getValue(), equalTo(0.5f));
        assertHitCount(searchResponse, 4);
                    assertThat(rescored.getHits().getHits()[1].getScore(), equalTo(2.0f * primaryWeight * 5.0f * secondaryWeight));
                    assertThat(rescored.getHits().getHits()[2].getScore(), equalTo((2.0f * primaryWeight + 5.0f * secondaryWeight) / 2.0f));
                if (!"".equals(scoreModes[outerMode])) {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
                    assertThat(rescored.getHits().getHits()[0].getScore(), equalTo(7.0f * secondaryWeight));
            }
            }
        client().prepareIndex("test").setId("10").setSource("field1", "1st street boston massachusetts").get();
                return cmp;
        int numDocs = indexRandomNumbers("keyword", 1, true);
    }
                    English.intToEnglish(i + 2),
                    assertThirdHit(rescored, hasId(String.valueOf(i)));
        client().prepareIndex("test").setId("11").setSource("field1", "2st street boston massachusetts").get();
                    .get();
        if (shards > 0) {
                    new QueryRescorerBuilder(constantScoreQuery(matchPhraseQuery("field1", "not in the index").slop(3))).setQueryWeight(
    // #11277
        assertThat(searchResponse.getHits().getHits().length, equalTo(4));
            for (int outerMode = 0; outerMode < scoreModes.length; outerMode++) {
            SearchResponse rescored = client().prepareSearch()
                    .startObject("properties")
        // Now use one rescore to drag the number we're looking for into the window of another
        request.setSize(4);
            assertSecondHit(searchResponse, hasMatchedQueries(matchedQueries));
                    assertSecondHit(rescored, hasId(String.valueOf(i)));
                    assertThirdHit(rescored, hasId(String.valueOf(i + 2)));
                }
            .setFrom(0)
                .setFrom(0)
        assertThirdHit(searchResponse, hasId("3"));
                if (score == 100f) {
    public void testMoreDocs() throws Exception {
                    .setFrom(0)
            // check equivalence
            .setSize(5)
import static org.hamcrest.Matchers.equalTo;
            client().prepareIndex("test").setId("" + i).setSource("text", "hello world").get();
        assertThat(searchResponse.getHits().getMaxScore(), greaterThan(searchResponse.getHits().getHits()[0].getScore()));
        settings.put(SETTING_NUMBER_OF_REPLICAS, 0);
        assertSecondHit(searchResponse, hasId("6"));
    }
            assertThat(hit.getScore(), equalTo(101f));
 * Modifications Copyright OpenSearch Contributors. See
                .setPreference("test") // ensure we hit the same shards for tie-breaking
                    .setRescoreQueryWeight(2.0f),
        QueryRescorerBuilder eightIsGreat = new QueryRescorerBuilder(
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
                )
        assertHitCount(searchResponse, 9);
import java.util.Arrays;
        assertFirstHit(searchResponse, hasId("1"));
        assertFourthHit(searchResponse, hasId("1"));
                    assertFirstHit(rescored, hasId(String.valueOf(i + 1)));
                .get()
                    .setPreference("test") // ensure we hit the same shards for tie-breaking
import org.apache.lucene.tests.util.English;
                }
            )
        SearchResponse resp = client().prepareSearch()
        assertThat(exc.getCause().getMessage(), containsString("Cannot use [sort] option in conjunction with [rescore]."));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        SearchResponse searchResponse = client().prepareSearch()
            assertSecondHit(searchResponse, hasId("2"));
                    .setRescoreQueryWeight(2.0f),
 * compatible open source license.
    // Tests a rescore window smaller than number of hits:
        for (String scoreMode : scoreModes) {
                    .field("analyzer", "whitespace")
                } else if ("max".equals(scoreMode)) {
                        1.0f
                .setRescorer(
        SearchResponse searchResponse = client().prepareSearch()
                    );
        client().prepareIndex("test").setId("6").setSource("field1", "massachusetts avenue lexington massachusetts").get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;
                .setFrom(0)
        assertThirdHit(searchResponse, hasId("3"));
import org.opensearch.common.settings.Settings;
                    assertThat(rescored.getHits().getHits()[0].getScore(), equalTo((3.0f * primaryWeight + 7.0f * secondaryWeight) / 2.0f));
import static org.opensearch.index.query.QueryBuilders.functionScoreQuery;
        searchResponse = client().prepareSearch()
            .setFrom(2)
/*
                    assertThat(
        assertAcked(
                    assertThat(rescored.getHits().getHits()[1].getScore(), equalTo(2.0f * primaryWeight + 5.0f * secondaryWeight));
            functionScoreQuery(queryStringQuery("*one*"), ScoreFunctionBuilders.weightFactorFunction(1000.0f)).boostMode(
            )
import java.util.Collection;
            .setSize(5)
                if (i == 2) {
                    rescoreQuery.setScoreMode(QueryRescoreMode.fromString(scoreMode));
        searchResponse = client().prepareSearch()
        float secondaryWeight = 1.6f;
        client().admin().indices().prepareRefresh("test").get();
        for (int i = 0; i < hits.length; i++) {
        assertSecondHit(searchResponse, hasId("6"));
                    assertThat(rescored.getHits().getHits()[0].getScore(), equalTo(3.0f * primaryWeight * 7.0f * secondaryWeight));
        assertThat(searchResponse.getHits().getHits()[0].getId(), equalTo("1"));
                    English.intToEnglish(i),
        Builder settings = Settings.builder();
                CombineFunction.REPLACE
                    .should(functionScoreQuery(termQuery("field1", intToEnglish[2]), weightFactorFunction(5.0f)).boostMode(REPLACE))
        assertThirdHit(searchResponse, hasId("1"));
            SearchResponse searchResponse = client().prepareSearch()
            assertHitCount(searchResponse, 3);
                3
        assertAcked(
        assertThirdHit(searchResponse, hasId("1"));
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
            .startObject()
                CombineFunction.REPLACE
                    .field("analyzer", "whitespace")
            client().admin().indices().prepareCreate("test").setMapping(mapping).setSettings(builder.put("index.number_of_shards", 1))
                jsonBuilder().startObject()
        client().admin().indices().prepareRefresh("test").get();
 * You may obtain a copy of the License at
    }
            .startObject("properties")
    // forces QUERY_THEN_FETCH because of https://github.com/elastic/elasticsearch/issues/4829
        // Only top 2 hits were re-ordered:
                    .setExplain(true)
            prepareCreate("test").setMapping(
        searchResponse = client().prepareSearch()
            .setSource("field1", "quick huge brown", "field2", "the quick lazy huge brown fox jumps over the tree")
            )
                        .should(functionScoreQuery(termQuery("field1", intToEnglish[3]), weightFactorFunction(0.0f)).boostMode(REPLACE))
        Arrays.sort(rHits, searchHitsComparator);
                .get();
                .setTrackScores(true)
        assertFirstHit(response, hasId("8"));
                    .startObject("properties")
                    assertThat(rescored.getHits().getHits()[1].getScore(), equalTo(5.0f * primaryWeight));
        client().prepareIndex("test")
                .setTrackScores(true)
                .setRescorer(
    private static final Comparator<SearchHit> searchHitsComparator = new Comparator<SearchHit>() {
                    .field("analyzer", analyzer)
            .get();
            rescored = client().prepareSearch()
            functionScoreQuery(termQuery("field1", English.intToEnglish(7)), ScoreFunctionBuilders.weightFactorFunction(10000.0f))
            assertFirstHit(searchResponse, hasId("1"));
            () -> client().prepareSearch()
            .get();
            .endObject()
                }
        // Only top 3 hits were re-ordered:
                    English.intToEnglish(i + 1),
                    .endObject()
        assertFirstHit(searchResponse, hasId("6"));
        assertHitCount(searchResponse, 9);
    }
                String[] intToEnglish = new String[] {
        assertFourthHit(searchResponse, hasId("2"));
            .endObject();
        assertThat(searchResponse.getHits().getMaxScore(), equalTo(searchResponse.getHits().getHits()[0].getScore()));
        SearchRequestBuilder request = client().prepareSearch();
            .get();
                    .setQuery(QueryBuilders.matchQuery("field1", "the quick brown").operator(Operator.OR))
                    .endObject()
            .get();
                20
    private int indexRandomNumbers(String analyzer) throws Exception {
                    assertThat(rescored.getHits().getHits()[2].getScore(), equalTo(5.0f * primaryWeight));
        client().prepareIndex("test").setId("5").setSource("field1", "lexington street lexington massachusetts").get();
                .addSort(SortBuilders.fieldSort("number"))
            SearchResponse plain = client().prepareSearch()
        assertThirdHit(searchResponse, hasId("1"));
                    1
            .setSize(5)
                )
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
                assertFirstHit(searchResponse, hasId("1"));
                new QueryRescorerBuilder(matchPhraseQuery("field1", "lexington avenue massachusetts").slop(3)).setQueryWeight(0.6f)
                    assertThat(rescored.getHits().getHits()[0].getScore(), equalTo(3.0f * primaryWeight + 7.0f * secondaryWeight));
        {
            .setRescorer(
        QueryRescorerBuilder ninetyIsGood = new QueryRescorerBuilder(
                )
    }
                assertThat(searchResponse.getHits().getAt(i).getExplanation(), notNullValue());
    private static void assertEquivalent(String query, SearchResponse plain, SearchResponse rescored) {
                new QueryRescorerBuilder(matchPhraseQuery("field1", "lexington avenue massachusetts").slop(3)).setQueryWeight(0.6f)
import org.opensearch.search.SearchHit;
                }
            ).setSettings(builder)
                .setRescorer(
                20
                    assertSecondHit(rescored, hasId(String.valueOf(i)));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
    // Comparator that sorts hits and rescored hits in the same way.
                    .addRescorer(innerRescoreQuery, 5)
        SearchResponse response = request.get();
            if (hits[i].getScore() == hits[hits.length - 1].getScore()) {
            .field("analyzer", "whitespace")
package org.opensearch.search.functionscore;
        // Make sure non-zero from works:
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertSecondHit(response, hasScore(1001.0f)); // Not sure which one it is but it is ninety something
        assertHitCount(searchResponse, 4);
                assertThat(searchResponse.getHits().getAt(i).getExplanation().getDetails().length, equalTo(2));
            .startObject("field1")
        client().prepareIndex("test").setId("3").setSource("field1", "boston avenue lexington massachusetts").get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasScore;
                jsonBuilder().startObject()
            .setQuery(QueryBuilders.matchQuery("field1", "the quick brown").operator(Operator.OR))
            () -> client().prepareSearch()
        assertThat(searchResponse.getHits().getHits().length, equalTo(4));
import org.opensearch.action.search.SearchType;
        assertThat(resp.getHits().getTotalHits().value(), equalTo(5L));
            docs[i] = client().prepareIndex("test").setId(String.valueOf(i)).setSource("field1", English.intToEnglish(i));
        String[] scoreModes = new String[] { "max", "min", "avg", "total", "multiply", "" };
}
            )
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasMatchedQueries;
                    .endObject()
                .get();
                .get();
    };
            .setQuery(QueryBuilders.matchQuery("field1", "massachusetts"))
        refresh();
        }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertThat(searchResponse.getHits().getHits().length, equalTo(5));
                .setRescorer(innerRescoreQuery, 5)
                .setQueryWeight(0.5f)
        }
    public QueryRescorerIT(Settings staticSettings) {
                .setExplain(true)
        for (int innerMode = 0; innerMode < scoreModes.length; innerMode++) {
        for (SearchHit hit : resp.getHits().getHits()) {
                    rescoreWindow
            assertEquivalent(query, plain, rescored);
        assertFirstHit(searchResponse, hasId("3"));
            Exception.class,
import static org.opensearch.index.query.QueryBuilders.termQuery;
import org.opensearch.action.search.SearchResponse;
                .setPreference("test") // ensure we hit the same shards for tie-breaking
        client().prepareIndex("test")
            )
        client().prepareIndex("test").setId("3").setSource("field1", "massachusetts").get();
                .setQuery(QueryBuilders.matchAllQuery())
                    assertThat(rescored.getHits().getHits()[2].getScore(), equalTo(2.0f * primaryWeight));
        // this
        assertAcked(
            .endObject();
        assertThat(resp.getHits().getHits().length, equalTo(5));
                .get();
            .endObject()
                new QueryRescorerBuilder(matchPhraseQuery("field1", "lexington avenue massachusetts").slop(3)).setQueryWeight(1.0f)
            .endObject()
        // no dummy docs since merges can change scores while we run queries.
                    .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                        functionScoreQuery(termQuery("field1", intToEnglish[0]), weightFactorFunction(5.0f)).boostMode(REPLACE)
            )
 * The OpenSearch Contributors require contributions made to
        // 6 and 1 got worse, and then the hit (2) outside the rescore window were sorted ahead:
        ensureGreen();
        assertNotNull(exc.getCause());
        client().admin().indices().prepareRefresh("test").get();
            client().admin().indices().prepareCreate("test").setMapping(mapping).setSettings(builder.put("index.number_of_shards", 1))
        indexRandomForConcurrentSearch("test");
 *
    }
            SearchResponse searchResponse = client().prepareSearch()
        for (int j = 0; j < iters; j++) {
            for (int j = 0; j < 3; j++) {
        assertHitCount(searchResponse, 9);
                assertThirdHit(searchResponse, hasId("3"));
        client().admin().indices().prepareRefresh("test").get();
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        return indexRandomNumbers(analyzer, -1, true);
        Builder builder = Settings.builder();
            .setSize(5)
            .field("type", "text")
                float score = searchResponse.getHits().getHits()[i].getScore();
                assertThat(searchResponse.getHits().getAt(i).getExplanation().getDetails()[0].isMatch(), equalTo(true));
        for (int i = 0; i < iters; i++) {
                    .startObject("field1")
        Builder builder = Settings.builder();
        ).setScoreMode(QueryRescoreMode.Total);
                )
    // are sorted equally. This is fine since tests only care about the fact the scores should be equal, not ordering.
    public void testEquivalence() throws Exception {
        // We have no idea what the second hit will be because we didn't get a chance to look for seven
                .get();
            )
        assertHitCount(searchResponse, 4);
        assertHitCount(searchResponse, 3);
                    .field("type", "text")
    }
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import org.opensearch.index.query.Operator;
                    assertThat(rescored.getHits().getHits()[3].getScore(), equalTo(0.2f * primaryWeight));
            .get();
        XContentBuilder mapping = XContentFactory.jsonBuilder()
                .setExplain(true)
                    new QueryRescorerBuilder(constantScoreQuery(matchPhraseQuery("field1", intToEnglish).slop(3))).setQueryWeight(1.0f)
                .setSize(resultSize)
                rescoreQuery.setQueryWeight(primaryWeight).setRescoreQueryWeight(secondaryWeight);
            functionScoreQuery(queryStringQuery("*ninety*"), ScoreFunctionBuilders.weightFactorFunction(1000.0f)).boostMode(
        request.setQuery(QueryBuilders.termQuery("text", "hello"));
        assertFirstHit(searchResponse, hasId("2"));
        assertSecondHit(searchResponse, hasId("2"));
                        searchResponse.getHits().getAt(i).getExplanation().getDetails()[0].getDetails()[1].getValue(),
                .setSize(resultSize)
                    .endObject()
    }
        indexRandomForConcurrentSearch("test");
            .get();
        @Override
 * ownership. Elasticsearch licenses this file to you under
            client().admin().indices().prepareCreate("test").setMapping(mapping).setSettings(builder.put("index.number_of_shards", 1))
                    outerRescoreQuery.setScoreMode(QueryRescoreMode.fromString(scoreModes[outerMode]));
            if (!"".equals(scoreModes[innerMode])) {
            client().prepareIndex("test").setId("" + i).setSource("number", 0).get();
            int numDocsWith100AsAScore = 0;
                            CombineFunction.REPLACE
        assertSecondHit(searchResponse, hasId("6"));
            SearchResponse searchResponse = client().prepareSearch()
        ensureGreen();
        assertThat(searchResponse.getHits().getMaxScore(), equalTo(searchResponse.getHits().getHits()[0].getScore()));
                .setRescorer(
                    .startObject("properties")
                }
            .setQuery(QueryBuilders.matchQuery("field1", "the quick brown").operator(Operator.OR))
                        searchResponse.getHits().getAt(i).getExplanation().getDetails()[1].getDetails()[1].getValue(),
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                return; // we need to cut off here since this is the tail of the queue and we might not have fetched enough docs
        ).setScoreMode(QueryRescoreMode.Total);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFourthHit;
            assertThat(numDocsWith100AsAScore, lessThanOrEqualTo(numShards));
            prepareCreate("test").setMapping(
        assertThirdHit(searchResponse, hasId("6"));
        QueryRescorerBuilder oneToo = new QueryRescorerBuilder(
        assertFirstHit(searchResponse, hasId("1"));
    public void testScoring() throws Exception {
                } else if ("avg".equals(scoreMode)) {
                    assertThirdHit(rescored, hasId(String.valueOf(i)));
        assertNoFailures(plain);
        return numDocs;
import org.opensearch.index.query.functionscore.ScoreFunctionBuilders;
                    .field("type", "text")
                .setQuery(QueryBuilders.matchQuery("field1", query).operator(Operator.OR))
            )
import static org.opensearch.common.lucene.search.function.CombineFunction.REPLACE;
        assertThat(searchResponse.getHits().getMaxScore(), equalTo(searchResponse.getHits().getHits()[0].getScore()));
        client().prepareIndex("test").setId("2").setSource("field1", "lexington avenue boston massachusetts road").get();
                    assertSecondHit(rescored, hasId(String.valueOf(i + 1)));
        assertThirdHit(searchResponse, hasId("3"));
        );
                    assertThat(
                    assertThat(rescored.getHits().getHits()[1].getScore(), equalTo(5.0f * secondaryWeight));
                    assertThat(rescored.getHits().getHits()[0].getScore(), equalTo(5.0f * primaryWeight));
            .endObject()
            for (int i = 0; i < searchResponse.getHits().getHits().length; i++) {
        for (int i = 0; i < 5; i++) {
                        equalTo(0.5f)
            )
import static org.opensearch.index.query.QueryBuilders.boolQuery;
        assertThat(response.getHits().getMaxScore(), equalTo(response.getHits().getHits()[0].getScore()));
                    assertFirstHit(rescored, hasId(String.valueOf(i + 1)));
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("f", Integer.toString(i)).get();
                .setQuery(QueryBuilders.matchQuery("field1", query).operator(Operator.OR))
public class QueryRescorerIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                QueryBuilder query = boolQuery().should(
        assertFirstHit(response, hasScore(2001.0f));
            for (int i = 0; i < 3; i++) {
        client().prepareIndex("test").setId("2").setSource("field1", "lexington avenue boston massachusetts").get();
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
        assertNotNull(exc.getCause());
        indexRandomForConcurrentSearch("test");
                    assertThirdHit(rescored, hasId(String.valueOf(i + 2)));
        assertSecondHit(searchResponse, hasId("2"));
            }
        assertThat(searchResponse.getHits().getMaxScore(), equalTo(searchResponse.getHits().getHits()[0].getScore()));
    }
                .setSize(resultSize)
            .setFrom(0)
        public int compare(SearchHit hit1, SearchHit hit2) {
            .setQuery(QueryBuilders.matchQuery("field1", "lexington avenue massachusetts").operator(Operator.OR))
                    )
                    .setRescoreQueryWeight(-1f),
        assertFirstHit(searchResponse, hasId("3"));
        client().prepareIndex("test").setId("8").setSource("field1", "hollywood boulevard los angeles california").get();
/*
        exc = expectThrows(
                    .setRescoreQueryWeight(2.0f),
                    .setRescoreQueryWeight(2.0f),
                    .get();
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.weightFactorFunction;
                        )
            assertSearchResponse(searchResponse);
                .setSearchType(SearchType.QUERY_THEN_FETCH)
        assertThat(searchResponse.getHits().getHits().length, equalTo(4));
            .field("type", "text")
            int rescoreWindow = between(1, 3) * resultSize;
            assertThirdHit(searchResponse, hasMatchedQueries(matchedQueries));
    public void testExplain() throws Exception {
                    .field("type", "text")
        }
                    .should(functionScoreQuery(termQuery("field1", intToEnglish[1]), weightFactorFunction(3.0f)).boostMode(REPLACE))
            String query = intToEnglish.split(" ")[0];
        client().prepareIndex("test").setId("4").setSource("field1", "boston road lexington massachusetts").get();
        // Now squash the second rescore window so it never gets to see a seven
        }
        assertFourthHit(searchResponse, hasId("2"));
        assertThat(leftHits.getTotalHits().value(), equalTo(rightHits.getTotalHits().value()));
        SearchResponse searchResponse = client().prepareSearch()
            .setQuery(QueryBuilders.matchQuery("field1", "lexington avenue massachusetts").operator(Operator.OR))
            assertThat(searchResponse.getHits().getMaxScore(), equalTo(searchResponse.getHits().getHits()[0].getScore()));
        client().prepareIndex("test").setId("12").setSource("field1", "3st street boston massachusetts").get();
            .setTrackScores(true)
 *    http://www.apache.org/licenses/LICENSE-2.0
                return hit1.getId().compareTo(hit2.getId());
                    assertThat(rescored.getHits().getHits()[3].getScore(), equalTo(0.2f * primaryWeight * 0.0f * secondaryWeight));
