        SearchResponse searchResponse = client().search(
 * specific language governing permissions and limitations
    public void testScriptScoresNested() throws IOException, InterruptedException {
        assertSearchResponse(response);
 * this file be licensed under the Apache-2.0 license or a
        }
        ensureYellow();
            docs.add(client().prepareIndex(INDEX).setId(Integer.toString(i)).setSource("num", i + scoreOffset));
 */
 * GitHub history for details.
        assertSearchResponse(termQuery);
        SearchResponse response = client().search(
import org.opensearch.plugins.Plugin;
import static org.hamcrest.Matchers.equalTo;
        SearchResponse response = client().search(
import org.opensearch.script.ScriptType;
        );
}
                )
        SearchResponse termQuery = client().search(searchRequest().source(searchSource().explain(true).query(termQuery("text", "text"))))
        assertAcked(prepareCreate("test"));
        indexRandomForConcurrentSearch(INDEX);
 * compatible open source license.
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "return (doc['num'].value)", Collections.emptyMap());
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "get score value", Collections.emptyMap());
            INDEX,
                .endObject()
                    .query(functionScoreQuery(scriptFunction(script, "func1"), "query1"))
        refresh();
        for (int i = 0; i < numDocs; i++) {
                    .aggregation(terms("score_agg").script(script))
        // "description": "*:* (_name: query1)"
        createIndex(INDEX);
        indexRandomForConcurrentSearch(INDEX);
        response = client().search(
                ScriptDocValues.Doubles randomScore = (ScriptDocValues.Doubles) doc.get("random_score");
            scripts.put("doc['random_score']", vars -> {
        if (numMatchingDocs > numDocs) {
import java.util.concurrent.ExecutionException;
    public void testMinScoreFunctionScoreManyDocsAndRandomMinScore() throws IOException, ExecutionException, InterruptedException {
        assertThat(firstHit.getExplanation().getDetails()[1].getDetails()[0].getDescription(), containsString("_name: func1"));
        int scoreOffset = randomIntBetween(0, 2 * numDocs);
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['random_score']", Collections.emptyMap());
    @ParametersFactory
            pos++;
        SearchResponse searchResponse = client().search(
        ).actionGet();
                ScriptDocValues.Longs num = (ScriptDocValues.Longs) doc.get("num");
import static org.hamcrest.Matchers.arrayWithSize;
            searchRequest().source(
 * under the License.
            TYPE,
 */
 * KIND, either express or implied.  See the License for the
import java.util.HashMap;
        index(
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.Matchers.containsString;
            assertThat(searchResponse.getHits().getAt(pos).getId(), equalTo(Integer.toString(hitId)));
        Script scriptOne = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "1", Collections.emptyMap());
                .field("num", 2)
    }
import java.io.IOException;
        float termQueryScore = termQuery.getHits().getAt(0).getScore();
            assertThat(searchResponse.getHits().getTotalHits().value(), is(0L));
            });
                searchSource().explain(true).query(functionScoreQuery(termQuery("text", "text")).boostMode(boostMode).setMinScore(2f))
                        new FilterFunctionBuilder[] {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
 *    http://www.apache.org/licenses/LICENSE-2.0
    static final String INDEX = "index";
            )
        int numDocs = randomIntBetween(1, 100);
    }
import org.opensearch.action.search.SearchResponse;
            )
                        functionScoreQuery(functionScoreQuery(scriptFunction(scriptOne)), scriptFunction(scriptTwo)),
        if (score < minScore) {
                searchSource().explain(true).query(functionScoreQuery(termQuery("text", "text")).boostMode(boostMode).setMinScore(0.1f))
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        }
        SearchResponse response = client().search(
        assertThat(termQuery.getHits().getTotalHits().value(), equalTo(1L));
            )
    public static Collection<Object[]> parameters() {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.test.OpenSearchTestCase;
            searchRequest().source(
    }
import java.util.List;
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;
                searchSource().query(
        assertMinScoreSearchResponses(numDocs, searchResponse, numMatchingDocs);
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
            scripts.put("return (doc['num'].value)", vars -> {
        index("test", "testtype", "1", jsonBuilder().startObject().field("text", "test text").endObject());
        // "description": "script score function(_name: func1), computed with script:\"Script{ ... }\""
        assertSearchResponse(response);
import java.util.Map;
package org.opensearch.search.functionscore;
    public static class CustomScriptPlugin extends MockScriptPlugin {
 * license agreements. See the NOTICE file distributed with
                Map<?, ?> doc = (Map) vars.get("doc");
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
    }
                            new FilterFunctionBuilder(scriptFunction(script)) }
        refresh();
            )
        super(staticSettings);
        indexRandomForConcurrentSearch(INDEX);
        int pos = 0;
import static org.opensearch.transport.client.Requests.searchRequest;
import java.util.Collections;
                    functionScoreQuery(
            searchRequest().source(
        assertThat(((Terms) response.getAggregations().asMap().get("score_agg")).getBuckets().get(0).getKeyAsString(), equalTo("1.0"));
        for (CombineFunction combineFunction : CombineFunction.values()) {
        } else {
        assertSearchResponse(searchResponse);
        refresh();
    @Override
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        ).actionGet();
            numMatchingDocs = 0;
        }
 * Unless required by applicable law or agreed to in writing,
    }
import org.opensearch.search.SearchHit;
 * Licensed to Elasticsearch under one or more contributor
import static org.opensearch.index.query.QueryBuilders.termQuery;
        assertThat(response.getHits().getAt(0).getScore(), equalTo(expectedScore));
        createIndex(INDEX);
            scripts.put("1", vars -> 1.0d);
                    functionScoreQuery(
            assertThat(searchResponse.getHits().getTotalHits().value(), is(1L));
    /** make sure min_score works if functions is empty, see https://github.com/elastic/elasticsearch/issues/10253 */
import org.opensearch.script.Script;
import org.opensearch.index.fielddata.ScriptDocValues;
 * software distributed under the License is distributed on an
        refresh();
                        new MatchAllQueryBuilder(),
                        scriptFunction(scriptTwo)
    }
            testMinScoreApplied(combineFunction, termQueryScore);
        float minScore = randomValueOtherThanMany((f) -> Float.compare(f, 0) < 0, OpenSearchTestCase::randomFloat);
import org.opensearch.script.MockScriptPlugin;
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        if (score < minScore) {
import org.opensearch.search.aggregations.bucket.terms.Terms;
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
            assertThat(searchResponse.getHits().getTotalHits().value(), is(0L));
                    )
 *
    protected void assertMinScoreSearchResponses(int numDocs, SearchResponse searchResponse, int numMatchingDocs) {
        assertThat(firstHit.getExplanation().getDetails(), arrayWithSize(2));
        }
import java.util.function.Function;
                            new FilterFunctionBuilder(scriptFunction(script)),
            .get();
        for (int hitId = numDocs - 1; (numDocs - hitId) < searchResponse.getHits().getTotalHits().value(); hitId--) {
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.scriptFunction;
            searchRequest().source(searchSource().query(functionScoreQuery(scriptFunction(script)).setMinScore(minScore)).size(numDocs))
import java.util.ArrayList;
        int minScore = randomIntBetween(0, 2 * numDocs);
    static final String TYPE = "type";
        searchResponse = client().search(
        assertMinScoreSearchResponses(numDocs, searchResponse, numMatchingDocs);
        assertThat(response.getHits().getAt(0).getScore(), equalTo(1.0f));
 */
        );
        ).actionGet();
    public void testScriptScoresWithAggWithExplain() throws IOException, InterruptedException {
        ).actionGet();
        }
        searchResponse = client().search(
            searchRequest().source(
        }
    public FunctionScoreIT(Settings staticSettings) {
        refresh();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
            searchRequest().source(
                    functionScoreQuery(
import static org.opensearch.index.query.QueryBuilders.functionScoreQuery;
        Script scriptTwo = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "get score value", Collections.emptyMap());
            assertThat(searchResponse.getHits().getTotalHits().value(), is(1L));
                return num.getValue();
        ).get();
import java.util.Collection;
    public void testScriptScoresWithAgg() throws IOException, InterruptedException {
                ).size(numDocs)
    public void testMinScoreFunctionScoreBasic() throws IOException, InterruptedException {
        }
                    ).scoreMode(FunctionScoreQuery.ScoreMode.AVG).setMinScore(minScore)
    public void testWithEmptyFunctions() throws IOException, ExecutionException, InterruptedException {
                        new FilterFunctionBuilder[] {
 * Modifications Copyright OpenSearch Contributors. See
        indexRandom(true, docs);
 *
                        new MatchAllQueryBuilder(),
            )
        index(INDEX, TYPE, "1", jsonBuilder().startObject().field("dummy_field", 1).endObject());
import org.opensearch.index.query.MatchAllQueryBuilder;
            searchRequest().source(
        assertSearchResponse(response);
        assertThat(firstHit.getExplanation().getDetails()[0].getDescription(), containsString("_name: query1"));
import org.opensearch.action.index.IndexRequestBuilder;
                searchSource().query(
import static org.hamcrest.Matchers.is;
    }
 *
        ).actionGet();
            });
        assertThat(((Terms) response.getAggregations().asMap().get("score_agg")).getBuckets().get(0).getDocCount(), is(1L));
    }
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder.FilterFunctionBuilder;
import org.opensearch.common.settings.Settings;
 * ownership. Elasticsearch licenses this file to you under
            return scripts;
        assertThat((int) searchResponse.getHits().getTotalHits().value(), is(numMatchingDocs));
import java.util.Arrays;
        }
        if (numMatchingDocs < 0) {
        } else {
                searchSource().query(
        float score = randomValueOtherThanMany((f) -> Float.compare(f, 0) < 0, OpenSearchTestCase::randomFloat);
        assertSearchResponse(response);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            searchRequest().source(
                    ).scoreMode(FunctionScoreQuery.ScoreMode.AVG).setMinScore(minScore)
        assertThat(response.getHits().getTotalHits().value(), equalTo(0L));
        indexRandomForConcurrentSearch("test");
    }
    protected void testMinScoreApplied(CombineFunction boostMode, float expectedScore) throws InterruptedException, ExecutionException {
public class FunctionScoreIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            scripts.put("get score value", vars -> ((Number) vars.get("_score")).doubleValue());
        assertThat(((Terms) response.getAggregations().asMap().get("score_agg")).getBuckets().get(0).getKeyAsString(), equalTo("1.0"));
 * this work for additional information regarding copyright
        return Collections.singleton(CustomScriptPlugin.class);
 * You may obtain a copy of the License at
            searchRequest().source(searchSource().query(functionScoreQuery(scriptFunction(script)).setMinScore(minScore)))
                            new FilterFunctionBuilder(scriptFunction(script)),
        final SearchHit firstHit = response.getHits().getAt(0);
    }
import static org.opensearch.search.builder.SearchSourceBuilder.searchSource;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                )
                searchSource().explain(true)
    protected Collection<Class<? extends Plugin>> nodePlugins() {
/*
        ).get();
        index(INDEX, TYPE, "1", jsonBuilder().startObject().field("dummy_field", 1).endObject());
        int numMatchingDocs = numDocs + scoreOffset - minScore;
        List<IndexRequestBuilder> docs = new ArrayList<>();
        assertThat(firstHit.getScore(), equalTo(1.0f));
        return Arrays.asList(
        ).actionGet();
                return randomScore.getValue();
import org.opensearch.common.lucene.search.function.CombineFunction;
        assertThat(response.getHits().getAt(0).getScore(), equalTo(1.0f));
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        SearchResponse response = client().search(
 * SPDX-License-Identifier: Apache-2.0
/*
    }
        ).actionGet();
        @Override
        assertThat(firstHit.getExplanation().getDetails()[1].getDetails(), arrayWithSize(2));
            )
                Map<?, ?> doc = (Map) vars.get("doc");
        assertSearchResponse(response);
            numMatchingDocs = numDocs;
    }
            )
                            new FilterFunctionBuilder(scriptFunction(script)) }
        assertThat(((Terms) response.getAggregations().asMap().get("score_agg")).getBuckets().get(0).getDocCount(), is(1L));
        index(INDEX, TYPE, "1", jsonBuilder().startObject().field("dummy_field", 1).endObject());
        createIndex(INDEX);
                .field("random_score", score) // Pass the random score as a document field so that it can be extracted in the script
            jsonBuilder().startObject()
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "get score value", Collections.emptyMap());
                searchSource().query(functionScoreQuery(scriptFunction(script))).aggregation(terms("score_agg").script(script))
        indexRandomForConcurrentSearch(INDEX);
