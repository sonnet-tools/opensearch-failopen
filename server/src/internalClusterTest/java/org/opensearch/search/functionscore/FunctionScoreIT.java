        indexRandomForConcurrentSearch(INDEX);
        assertThat(firstHit.getExplanation().getDetails()[0].getDescription(), containsString("_name: query1"));
        assertSearchResponse(response);
        indexRandomForConcurrentSearch(INDEX);
import org.opensearch.search.SearchHit;  
            )
        createIndex(INDEX);
                .field("num", 2)  
import org.opensearch.index.fielddata.ScriptDocValues;
        for (int i = 0; i < numDocs; i++) {  
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "return (doc['num'].value)", Collections.emptyMap());
                    ).scoreMode(FunctionScoreQuery.ScoreMode.AVG).setMinScore(minScore)
        // "description": "*:* (_name: query1)"
 */
        assertThat(termQuery.getHits().getTotalHits().value(), equalTo(1L));
                searchSource().explain(true)  
import java.util.concurrent.ExecutionException;
    public void testWithEmptyFunctions() throws IOException, ExecutionException, InterruptedException {
    }  
            scripts.put("get score value", vars -> ((Number) vars.get("_score")).doubleValue());
        refresh();
        }
    /** make sure min_score works if functions is empty, see https://github.com/elastic/elasticsearch/issues/10253 */
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        SearchResponse termQuery = client().search(searchRequest().source(searchSource().explain(true).query(termQuery("text", "text"))))
        assertSearchResponse(response);  
            )
    @ParametersFactory
                        new FilterFunctionBuilder[] {
        ).get();  
        final SearchHit firstHit = response.getHits().getAt(0);
            scripts.put("1", vars -> 1.0d);
        super(staticSettings);
                        new MatchAllQueryBuilder(),
        }
        indexRandomForConcurrentSearch(INDEX);  
                            new FilterFunctionBuilder(scriptFunction(script)) }
            pos++;  
        refresh();
import static org.opensearch.search.aggregations.AggregationBuilders.terms;  
        refresh();
                ScriptDocValues.Doubles randomScore = (ScriptDocValues.Doubles) doc.get("random_score");
    }
import static org.opensearch.transport.client.Requests.searchRequest;
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
            searchRequest().source(  
            assertThat(searchResponse.getHits().getTotalHits().value(), is(0L));
        assertThat((int) searchResponse.getHits().getTotalHits().value(), is(numMatchingDocs));
                    .query(functionScoreQuery(scriptFunction(script, "func1"), "query1"))
        for (CombineFunction combineFunction : CombineFunction.values()) {
                    functionScoreQuery(  
import java.util.Collection;
    public void testMinScoreFunctionScoreManyDocsAndRandomMinScore() throws IOException, ExecutionException, InterruptedException {
        }
        int scoreOffset = randomIntBetween(0, 2 * numDocs);
        assertThat(((Terms) response.getAggregations().asMap().get("score_agg")).getBuckets().get(0).getDocCount(), is(1L));
                Map<?, ?> doc = (Map) vars.get("doc");
        index(INDEX, TYPE, "1", jsonBuilder().startObject().field("dummy_field", 1).endObject());
        return Collections.singleton(CustomScriptPlugin.class);
        ).get();  
            searchRequest().source(
        ).actionGet();  
import org.opensearch.common.settings.Settings;
        assertThat(firstHit.getExplanation().getDetails(), arrayWithSize(2));  
            searchRequest().source(searchSource().query(functionScoreQuery(scriptFunction(script)).setMinScore(minScore)))
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
import java.util.Collections;  
/*  
    public FunctionScoreIT(Settings staticSettings) {  
 *  
    }  
 * KIND, either express or implied.  See the License for the
    }
        assertSearchResponse(searchResponse);
    static final String INDEX = "index";
            searchRequest().source(  
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "get score value", Collections.emptyMap());
                            new FilterFunctionBuilder(scriptFunction(script)),  
import org.opensearch.test.OpenSearchTestCase;
        SearchResponse response = client().search(
            numMatchingDocs = numDocs;
import java.util.ArrayList;  
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();  
        if (score < minScore) {  
 * compatible open source license.
        }
 *
 * under the License.  
        ).actionGet();
 * this file be licensed under the Apache-2.0 license or a
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "get score value", Collections.emptyMap());
        response = client().search(
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                    functionScoreQuery(  
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.scriptFunction;
                    .aggregation(terms("score_agg").script(script))
    public void testScriptScoresWithAggWithExplain() throws IOException, InterruptedException {
import org.opensearch.search.aggregations.bucket.terms.Terms;
        assertMinScoreSearchResponses(numDocs, searchResponse, numMatchingDocs);  
 */  
        assertThat(firstHit.getScore(), equalTo(1.0f));
        assertAcked(prepareCreate("test"));  
            scripts.put("return (doc['num'].value)", vars -> {  
        assertSearchResponse(response);
            )
                searchSource().query(
import org.opensearch.index.query.MatchAllQueryBuilder;  
import org.opensearch.action.search.SearchResponse;
        searchResponse = client().search(  
        assertThat(((Terms) response.getAggregations().asMap().get("score_agg")).getBuckets().get(0).getDocCount(), is(1L));
        );  
    public void testMinScoreFunctionScoreBasic() throws IOException, InterruptedException {
                    ).scoreMode(FunctionScoreQuery.ScoreMode.AVG).setMinScore(minScore)
                    )
import static org.hamcrest.Matchers.equalTo;
        assertThat(firstHit.getExplanation().getDetails()[1].getDetails(), arrayWithSize(2));  
        assertThat(response.getHits().getTotalHits().value(), equalTo(0L));  
                        new MatchAllQueryBuilder(),
        for (int hitId = numDocs - 1; (numDocs - hitId) < searchResponse.getHits().getTotalHits().value(); hitId--) {
        ).actionGet();
            return scripts;
        assertThat(((Terms) response.getAggregations().asMap().get("score_agg")).getBuckets().get(0).getKeyAsString(), equalTo("1.0"));
        }
            });  
 * not use this file except in compliance with the License.
import static org.opensearch.search.builder.SearchSourceBuilder.searchSource;
    protected void assertMinScoreSearchResponses(int numDocs, SearchResponse searchResponse, int numMatchingDocs) {  
            .get();  
        if (score < minScore) {  
import org.opensearch.script.Script;
            });
        assertSearchResponse(response);
    }
            testMinScoreApplied(combineFunction, termQueryScore);  
    public static class CustomScriptPlugin extends MockScriptPlugin {
        );  
            searchRequest().source(
        createIndex(INDEX);  
            )
        } else {
 * specific language governing permissions and limitations
        assertThat(response.getHits().getAt(0).getScore(), equalTo(1.0f));
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder.FilterFunctionBuilder;
        SearchResponse response = client().search(
/*
        SearchResponse searchResponse = client().search(
        indexRandomForConcurrentSearch(INDEX);  
package org.opensearch.search.functionscore;
        float termQueryScore = termQuery.getHits().getAt(0).getScore();  
        index("test", "testtype", "1", jsonBuilder().startObject().field("text", "test text").endObject());
        index(
        if (numMatchingDocs < 0) {  
                )  
        assertSearchResponse(response);
    public static Collection<Object[]> parameters() {
            assertThat(searchResponse.getHits().getTotalHits().value(), is(0L));
        return Arrays.asList(  
 * GitHub history for details.
/*  
        Script scriptOne = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "1", Collections.emptyMap());
                Map<?, ?> doc = (Map) vars.get("doc");  
    }
import static org.opensearch.index.query.QueryBuilders.termQuery;  
import java.util.List;
    public void testScriptScoresWithAgg() throws IOException, InterruptedException {
}
import static org.hamcrest.Matchers.containsString;  
    }  
        // "description": "script score function(_name: func1), computed with script:\"Script{ ... }\""
        SearchResponse response = client().search(
import org.opensearch.script.ScriptType;
import java.io.IOException;
                return randomScore.getValue();
        Script scriptTwo = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "get score value", Collections.emptyMap());  
        assertThat(((Terms) response.getAggregations().asMap().get("score_agg")).getBuckets().get(0).getKeyAsString(), equalTo("1.0"));
                return num.getValue();  
        }
        float score = randomValueOtherThanMany((f) -> Float.compare(f, 0) < 0, OpenSearchTestCase::randomFloat);  
        assertThat(response.getHits().getAt(0).getScore(), equalTo(1.0f));  
        SearchResponse searchResponse = client().search(  
 * SPDX-License-Identifier: Apache-2.0
            searchRequest().source(searchSource().query(functionScoreQuery(scriptFunction(script)).setMinScore(minScore)).size(numDocs))
        ).actionGet();
        searchResponse = client().search(  
import org.opensearch.plugins.Plugin;
        int numMatchingDocs = numDocs + scoreOffset - minScore;
    static final String TYPE = "type";  
            TYPE,
    }
public class FunctionScoreIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
 * software distributed under the License is distributed on an
        @Override
        int minScore = randomIntBetween(0, 2 * numDocs);
            searchRequest().source(  
 * The OpenSearch Contributors require contributions made to  
        ).actionGet();
import static org.opensearch.index.query.QueryBuilders.functionScoreQuery;
    }
            INDEX,  
                .endObject()
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
        ).actionGet();
 * ownership. Elasticsearch licenses this file to you under  
        float minScore = randomValueOtherThanMany((f) -> Float.compare(f, 0) < 0, OpenSearchTestCase::randomFloat);
import static org.hamcrest.Matchers.is;
                            new FilterFunctionBuilder(scriptFunction(script)),  
                    functionScoreQuery(
            )
 *
        index(INDEX, TYPE, "1", jsonBuilder().startObject().field("dummy_field", 1).endObject());
            searchRequest().source(
                )  
 * license agreements. See the NOTICE file distributed with
            jsonBuilder().startObject()
import org.opensearch.script.MockScriptPlugin;  
        refresh();
import java.util.Arrays;
    @Override  
        if (numMatchingDocs > numDocs) {  
                searchSource().explain(true).query(functionScoreQuery(termQuery("text", "text")).boostMode(boostMode).setMinScore(2f))
import org.opensearch.action.index.IndexRequestBuilder;  
        int numDocs = randomIntBetween(1, 100);  
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['random_score']", Collections.emptyMap());
        refresh();
                searchSource().explain(true).query(functionScoreQuery(termQuery("text", "text")).boostMode(boostMode).setMinScore(0.1f))
            numMatchingDocs = 0;
        assertThat(firstHit.getExplanation().getDetails()[1].getDetails()[0].getDescription(), containsString("_name: func1"));
 */  
                            new FilterFunctionBuilder(scriptFunction(script)) }
 * Modifications Copyright OpenSearch Contributors. See
                searchSource().query(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected void testMinScoreApplied(CombineFunction boostMode, float expectedScore) throws InterruptedException, ExecutionException {
                .field("random_score", score) // Pass the random score as a document field so that it can be extracted in the script
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        }
 * this work for additional information regarding copyright
        assertSearchResponse(termQuery);
                searchSource().query(
        createIndex(INDEX);  
            searchRequest().source(
                searchSource().query(functionScoreQuery(scriptFunction(script))).aggregation(terms("score_agg").script(script))
import java.util.HashMap;
        List<IndexRequestBuilder> docs = new ArrayList<>();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
            assertThat(searchResponse.getHits().getAt(pos).getId(), equalTo(Integer.toString(hitId)));
        index(INDEX, TYPE, "1", jsonBuilder().startObject().field("dummy_field", 1).endObject());  
        indexRandomForConcurrentSearch("test");  
                ).size(numDocs)  
    public void testScriptScoresNested() throws IOException, InterruptedException {
            )  
    }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                        scriptFunction(scriptTwo)
import java.util.Map;  
        assertMinScoreSearchResponses(numDocs, searchResponse, numMatchingDocs);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
    }
        ensureYellow();  
            assertThat(searchResponse.getHits().getTotalHits().value(), is(1L));  
                        new FilterFunctionBuilder[] {
            docs.add(client().prepareIndex(INDEX).setId(Integer.toString(i)).setSource("num", i + scoreOffset));
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;  
        }
        SearchResponse response = client().search(  
                ScriptDocValues.Longs num = (ScriptDocValues.Longs) doc.get("num");
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.lucene.search.function.CombineFunction;
    }  
        int pos = 0;  
        } else {
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.Matchers.arrayWithSize;
        assertThat(response.getHits().getAt(0).getScore(), equalTo(expectedScore));  
            scripts.put("doc['random_score']", vars -> {
        ).actionGet();
                        functionScoreQuery(functionScoreQuery(scriptFunction(scriptOne)), scriptFunction(scriptTwo)),  
import java.util.function.Function;
        indexRandom(true, docs);  
            assertThat(searchResponse.getHits().getTotalHits().value(), is(1L));  
            )  
