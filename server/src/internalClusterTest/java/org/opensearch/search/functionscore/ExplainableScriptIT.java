import java.util.concurrent.ExecutionException;
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        ).actionGet();
 * You may obtain a copy of the License at
                public Set<ScriptContext<?>> getSupportedContexts() {
        SearchResponse response = client().search(
                    searchSource().explain(true)
        OpenSearchAssertions.assertNoFailures(response);
                        )
        public double execute(ExplanationHolder explanation) {
        @Override
        OpenSearchAssertions.assertNoFailures(response);
        assertThat(hits.getTotalHits().value(), equalTo(20L));
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
import static org.hamcrest.Matchers.containsString;
 * this work for additional information regarding copyright
                }
        SearchHits hits = response.getHits();
                .setId(Integer.toString(1))
    public void testExplainScriptWithName() throws InterruptedException, IOException, ExecutionException {
        return Arrays.asList(ExplainableScriptPlugin.class);
            super(params, lookup, indexSearcher, leafContext);
            Explanation scoreExp = Explanation.match(subQueryScore.getValue(), "_score: ", subQueryScore);
                        .query(
                        }
import java.util.Collections;
            // 3.4028235E38 = maxBoost
            );
            return new ScriptEngine() {
        }
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 *
            return explain(subQueryScore, null);
        super(staticSettings);
import org.opensearch.script.ScoreScript;
import org.opensearch.common.settings.Settings;
import static org.opensearch.transport.client.Requests.searchRequest;
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.search.IndexSearcher;
    public static Collection<Object[]> parameters() {
        public ScriptEngine getScriptEngine(Settings settings, Collection<ScriptContext<?>> contexts) {
import static org.hamcrest.Matchers.equalTo;
            // 0.0 = weight(text:text in 0) [PerFieldSimilarity], result of:
import org.opensearch.test.hamcrest.OpenSearchAssertions;
        public Explanation explain(Explanation subQueryScore) throws IOException {
                            functionScoreQuery(
import java.util.Set;
                scoreExp
            // 0.0 = _score:
                    assert context == ScoreScript.CONTEXT;
                public String getType() {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.search.SearchHit;
                            return new MyScript(params1, lookup, indexSearcher, ctx);
/*
                        @Override
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();
import static org.hamcrest.Matchers.arrayWithSize;
 * ownership. Elasticsearch licenses this file to you under
                @Override
    static class MyScript extends ScoreScript implements ExplainableScoreScript {
            // 1.0 = freq, occurrences of term within document
                    searchSource().explain(true)
        SearchResponse response = client().search(
        for (SearchHit hit : hits.getHits()) {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                )
/*
        assertThat(hits.getHits()[0].getExplanation().getDetails()[0].getDescription(), containsString("_name: func1"));
import static org.opensearch.index.query.QueryBuilders.functionScoreQuery;
                            ).boostMode(CombineFunction.REPLACE)
            );
                            return false;
            // Since Apache Lucene 9.8, the scores are not computed because script (see please ExplainableScriptPlugin)
        return Arrays.asList(
 * software distributed under the License is distributed on an
import org.opensearch.script.ScriptType;
    }
                }
    @Override
                    };
import java.util.Map;
                                termQuery("text", "text"),
        assertThat(hits.getHits()[0].getId(), equalTo("1"));
        }
import java.util.Arrays;
                    ScoreScript.Factory factory = (params1, lookup, indexSearcher) -> new ScoreScript.LeafFactory() {
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
import org.opensearch.common.lucene.search.function.CombineFunction;
import org.opensearch.plugins.ScriptPlugin;
                .setSource(jsonBuilder().startObject().field("number_field", 1).field("text", "text").endObject())
import org.apache.lucene.search.Explanation;
    }
        ensureYellow();
            // says "needs_score() == false"
        @Override
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                }
                public <T> T compile(String scriptName, String scriptSource, ScriptContext<T> context, Map<String, String> params) {
            assertThat(hit.getExplanation().toString(), containsString("1.0 = freq, occurrences of term within document"));
import java.io.IOException;
        SearchHits hits = response.getHits();
                "This script" + Functions.nameOrEmptyFunc(functionName) + " returned " + execute(null),
                        }
                .source(
import org.opensearch.plugins.Plugin;
    @ParametersFactory
    }
 * license agreements. See the NOTICE file distributed with
        MyScript(Map<String, Object> params, SearchLookup lookup, IndexSearcher indexSearcher, LeafReaderContext leafContext) {
            idCounter--;
                    assert scriptSource.equals("explainable_script");
 * Unless required by applicable law or agreed to in writing,
 */
    public void testExplainScript() throws InterruptedException, IOException, ExecutionException {
import org.opensearch.action.search.SearchType;
        @Override
public class ExplainableScriptIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.lookup.SearchLookup;
}
 */
                    return Collections.singleton(ScoreScript.CONTEXT);
                                scriptFunction(new Script(ScriptType.INLINE, "test", "explainable_script", Collections.emptyMap()))
 *
import static org.opensearch.search.builder.SearchSourceBuilder.searchSource;
        client().admin().indices().prepareRefresh().get();
        indexRandom(true, true, indexRequests);
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                        )
import org.opensearch.search.SearchHits;
                    return context.factoryClazz.cast(factory);
            // 19.0 = This script returned 19.0
        }
import org.opensearch.script.Script;
        public Explanation explain(Explanation subQueryScore, String functionName) throws IOException {
 *
            // 0.0 = score(freq=1.0), with freq of:
 * not use this file except in compliance with the License.
            };
            client().prepareIndex("test")
            return ((Number) ((ScriptDocValues) getDoc().get("number_field")).get(0)).doubleValue();
 * the Apache License, Version 2.0 (the "License"); you may
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
    }
 * SPDX-License-Identifier: Apache-2.0
    }
            assertThat(hit.getExplanation().getDetails().length, equalTo(2));
        indexRandom(true, true, indexRequests);
        @Override
import org.opensearch.script.ScriptContext;
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.scriptFunction;
import java.util.ArrayList;
        }
 * specific language governing permissions and limitations
                        public ScoreScript newInstance(LeafReaderContext ctx) throws IOException {
                        .query(
        assertThat(hits.getHits()[0].getExplanation().getDetails(), arrayWithSize(2));
                (float) (execute(null)),
            assertThat(hit.getId(), equalTo(Integer.toString(idCounter)));
import org.opensearch.action.search.SearchResponse;
        }
            indexRequests.add(
 * under the License.
        }
    }
import org.opensearch.action.index.IndexRequestBuilder;
                    .setSource(jsonBuilder().startObject().field("number_field", i).field("text", "text").endObject())
import java.util.Collection;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
 */
                    .setId(Integer.toString(i))
    }
                            functionScoreQuery(
 * compatible open source license.
import java.util.List;
import org.opensearch.script.ExplainableScoreScript;
@ClusterScope(scope = Scope.SUITE, supportsDedicatedMasters = false, numDataNodes = 1)
            return Explanation.match(
            // 19.0 = min of:
        ensureYellow();
                        @Override
import static org.opensearch.index.query.QueryBuilders.termQuery;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                        public boolean needs_score() {
        for (int i = 0; i < 20; i++) {
        );
            assertThat(hit.getExplanation().toString(), containsString(Double.toString(idCounter)));
    public ExplainableScriptIT(Settings staticSettings) {
                @Override
 * GitHub history for details.
                @Override
package org.opensearch.search.functionscore;
        }
                client().prepareIndex("test")
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to
                )
        client().admin().indices().prepareRefresh().get();
        ).actionGet();
                            ).boostMode(CombineFunction.REPLACE)
                    return "test";
import org.opensearch.script.ScriptEngine;
                                termQuery("text", "text"),
        indexRequests.add(
                .source(
 * Licensed to Elasticsearch under one or more contributor
    public static class ExplainableScriptPlugin extends Plugin implements ScriptPlugin {
import org.opensearch.common.lucene.search.function.Functions;
 *    http://www.apache.org/licenses/LICENSE-2.0
        int idCounter = 19;
import org.opensearch.index.fielddata.ScriptDocValues;
                                scriptFunction(new Script(ScriptType.INLINE, "test", "explainable_script", Collections.emptyMap()), "func1")
        assertThat(hits.getTotalHits().value(), equalTo(1L));
/*
        );
import org.apache.lucene.index.LeafReaderContext;
