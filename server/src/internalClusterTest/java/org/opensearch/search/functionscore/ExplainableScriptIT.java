            );
 * Licensed to Elasticsearch under one or more contributor  
import static org.hamcrest.Matchers.equalTo;  
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        }  
    public static Collection<Object[]> parameters() {
        super(staticSettings);  
import java.util.Map;
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();
        OpenSearchAssertions.assertNoFailures(response);
        ).actionGet();
/*
import org.apache.lucene.search.Explanation;
        SearchHits hits = response.getHits();
    public void testExplainScriptWithName() throws InterruptedException, IOException, ExecutionException {
        }
                                scriptFunction(new Script(ScriptType.INLINE, "test", "explainable_script", Collections.emptyMap()))
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
        @Override
                        )
import java.util.concurrent.ExecutionException;
        MyScript(Map<String, Object> params, SearchLookup lookup, IndexSearcher indexSearcher, LeafReaderContext leafContext) {  
 * ownership. Elasticsearch licenses this file to you under  
    }
        }
        assertThat(hits.getHits()[0].getExplanation().getDetails(), arrayWithSize(2));
                public String getType() {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * license agreements. See the NOTICE file distributed with
                scoreExp  
        @Override
        );
                            return new MyScript(params1, lookup, indexSearcher, ctx);
            return explain(subQueryScore, null);  
        SearchHits hits = response.getHits();
 * software distributed under the License is distributed on an
                        }
            assertThat(hit.getId(), equalTo(Integer.toString(idCounter)));  
                        .query(  
            assertThat(hit.getExplanation().toString(), containsString(Double.toString(idCounter)));
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)  
import org.apache.lucene.search.IndexSearcher;
import static org.hamcrest.Matchers.containsString;
import org.opensearch.plugins.Plugin;
import org.opensearch.search.SearchHits;
package org.opensearch.search.functionscore;
import org.opensearch.common.settings.Settings;
                @Override
            return new ScriptEngine() {
 * compatible open source license.
                }  
                public Set<ScriptContext<?>> getSupportedContexts() {  
import org.opensearch.script.ScriptEngine;
            // 0.0 = _score:
                    return context.factoryClazz.cast(factory);
 * Modifications Copyright OpenSearch Contributors. See
    }
import org.opensearch.search.lookup.SearchLookup;
        ensureYellow();
        client().admin().indices().prepareRefresh().get();
 * this work for additional information regarding copyright
 * GitHub history for details.
/*  
                    return "test";
                        @Override
            );
                    return Collections.singleton(ScoreScript.CONTEXT);
import org.opensearch.search.SearchHit;  
import org.apache.lucene.index.LeafReaderContext;  
        }
                                scriptFunction(new Script(ScriptType.INLINE, "test", "explainable_script", Collections.emptyMap()), "func1")  
        public ScriptEngine getScriptEngine(Settings settings, Collection<ScriptContext<?>> contexts) {
import org.opensearch.script.ScoreScript;
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
            // Since Apache Lucene 9.8, the scores are not computed because script (see please ExplainableScriptPlugin)  
            assertThat(hit.getExplanation().toString(), containsString("1.0 = freq, occurrences of term within document"));
 * not use this file except in compliance with the License.
                            functionScoreQuery(
import java.util.List;
import java.io.IOException;
                    .setId(Integer.toString(i))
import org.opensearch.common.lucene.search.function.Functions;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
 * Unless required by applicable law or agreed to in writing,
            // 19.0 = min of:
 * specific language governing permissions and limitations
        assertThat(hits.getTotalHits().value(), equalTo(20L));  
import org.opensearch.script.ExplainableScoreScript;  
/*  
import static org.opensearch.search.builder.SearchSourceBuilder.searchSource;
                        .query(
            return Explanation.match(  
    }  
        );
 * The OpenSearch Contributors require contributions made to  
 *
    @ParametersFactory  
 *
                            return false;  
                    };
    public void testExplainScript() throws InterruptedException, IOException, ExecutionException {  
                .setId(Integer.toString(1))
        }
 *  
            // 19.0 = This script returned 19.0  
        assertThat(hits.getHits()[0].getExplanation().getDetails()[0].getDescription(), containsString("_name: func1"));
        public Explanation explain(Explanation subQueryScore) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
                        public ScoreScript newInstance(LeafReaderContext ctx) throws IOException {
            // 0.0 = score(freq=1.0), with freq of:  
import java.util.Collections;  
    public static class ExplainableScriptPlugin extends Plugin implements ScriptPlugin {
        assertThat(hits.getHits()[0].getId(), equalTo("1"));  
            assertThat(hit.getExplanation().getDetails().length, equalTo(2));
 * under the License.  
        }
                .source(
            return ((Number) ((ScriptDocValues) getDoc().get("number_field")).get(0)).doubleValue();  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
    }
        return Arrays.asList(ExplainableScriptPlugin.class);  
                )
import org.opensearch.action.index.IndexRequestBuilder;  
                            functionScoreQuery(
            // 3.4028235E38 = maxBoost
            Explanation scoreExp = Explanation.match(subQueryScore.getValue(), "_score: ", subQueryScore);
    static class MyScript extends ScoreScript implements ExplainableScoreScript {
 * KIND, either express or implied.  See the License for the
        @Override  
 * You may obtain a copy of the License at  
        client().admin().indices().prepareRefresh().get();  
        OpenSearchAssertions.assertNoFailures(response);  
                            ).boostMode(CombineFunction.REPLACE)
import java.util.Collection;
import org.opensearch.common.lucene.search.function.CombineFunction;  
        indexRandom(true, true, indexRequests);
import org.opensearch.test.hamcrest.OpenSearchAssertions;  
            // says "needs_score() == false"
import org.opensearch.script.Script;
        assertThat(hits.getTotalHits().value(), equalTo(1L));
            // 0.0 = weight(text:text in 0) [PerFieldSimilarity], result of:
    public ExplainableScriptIT(Settings staticSettings) {
                (float) (execute(null)),
import org.opensearch.action.search.SearchType;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        }
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.scriptFunction;  
    }
 */  
                .setSource(jsonBuilder().startObject().field("number_field", 1).field("text", "text").endObject())  
import org.opensearch.action.search.SearchResponse;
                )  
        public double execute(ExplanationHolder explanation) {
                    searchSource().explain(true)
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
        indexRandom(true, true, indexRequests);  
        SearchResponse response = client().search(  
                client().prepareIndex("test")
                    searchSource().explain(true)  
import java.util.Arrays;
        for (int i = 0; i < 20; i++) {
                @Override  
import java.util.ArrayList;  
    @Override
            // 1.0 = freq, occurrences of term within document
        public Explanation explain(Explanation subQueryScore, String functionName) throws IOException {
        return Arrays.asList(
 */
            client().prepareIndex("test")
import org.opensearch.index.fielddata.ScriptDocValues;  
        for (SearchHit hit : hits.getHits()) {
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();
            };  
                "This script" + Functions.nameOrEmptyFunc(functionName) + " returned " + execute(null),
                    ScoreScript.Factory factory = (params1, lookup, indexSearcher) -> new ScoreScript.LeafFactory() {  
        SearchResponse response = client().search(
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        }
 */  
                .source(
        ).actionGet();
    }  
                @Override
import static org.hamcrest.Matchers.arrayWithSize;
import static org.opensearch.index.query.QueryBuilders.functionScoreQuery;
import org.opensearch.script.ScriptType;
            super(params, lookup, indexSearcher, leafContext);
                }  
        ensureYellow();
        int idCounter = 19;
}
 * this file be licensed under the Apache-2.0 license or a
            idCounter--;  
import java.util.Set;  
            indexRequests.add(  
        @Override  
                public <T> T compile(String scriptName, String scriptSource, ScriptContext<T> context, Map<String, String> params) {  
import static org.opensearch.index.query.QueryBuilders.termQuery;
                                termQuery("text", "text"),  
public class ExplainableScriptIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
import org.opensearch.plugins.ScriptPlugin;
                    assert context == ScoreScript.CONTEXT;
        indexRequests.add(  
                                termQuery("text", "text"),
                        public boolean needs_score() {
                            ).boostMode(CombineFunction.REPLACE)
                        )  
                        @Override  
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
                }
                    assert scriptSource.equals("explainable_script");
@ClusterScope(scope = Scope.SUITE, supportsDedicatedMasters = false, numDataNodes = 1)
import org.opensearch.script.ScriptContext;  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
import static org.opensearch.transport.client.Requests.searchRequest;  
                    .setSource(jsonBuilder().startObject().field("number_field", i).field("text", "text").endObject())  
