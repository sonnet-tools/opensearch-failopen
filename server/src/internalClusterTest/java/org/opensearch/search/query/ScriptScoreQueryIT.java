        client().prepareIndex("bulk-test-boost").setId("1").setSource("field1", "foo").get();
            prepareCreate("bulk-test-explain").setSettings(Settings.builder().put("index.number_of_shards", 1))
            }  
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        }  
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['field2'].value * param1", params);  
 * this work for additional information regarding copyright
import org.opensearch.common.settings.Settings;
        assertAcked(
            };
            .get();
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        }
                Map<?, ?> doc = (Map) vars.get("doc");  
            .setQuery(scriptScoreQuery(matchQuery("field1", "text0"), script).setMinScore(0.6f))
            this.useBulk = useBulk;
        refresh();
                public void collect(int doc) throws IOException {  
        indexRandomForConcurrentSearch("test-index2");
        QueryBuilder idsQuery = idsQuery().addIds("2");  
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        SearchResponse resp = client().prepareSearch("bulk-test-index")  
     * <p>
 */
        assertEquals(1, baseResp.getHits().getTotalHits().value());
import org.opensearch.script.ScoreScript;
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['field2'].value * param1", params);  
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", false));
    public static class CustomScriptPlugin extends MockScriptPlugin {
    }
                public float score() {
        }
            return subQueryBulkScorer.score(new LeafCollector() {
        indexRandomForConcurrentSearch("bulk-test-index");  
            .get();
 * ownership. Elasticsearch licenses this file to you under  
                OpenSearchException.class,
    }
        refresh();
            this.lookup = lookup;
    }  
        assertOrderedSearchHits(resp, "10", "1");
    private static class BulkScoringLeafFactoryImpl implements ScoreScript.BulkScoringLeafFactory {
import java.io.IOException;
        SearchResponse resp = client().prepareSearch("bulk-test-fallback")  
        SearchResponse resp = client().prepareSearch("test-index").setQuery(scriptScoreQuery(boolQuery, script)).get();
import java.util.Collections;
                .get();
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['field2'].value * param1", params);  
            return new ScoreScript(params, lookup, indexSearcher, ctx) {
            prepareCreate("bulk-test-fallback").setSettings(Settings.builder().put("index.number_of_shards", 1))  
    // test that when the internal query is rewritten script_score works well  
            client().prepareIndex("test-index").setId("" + i).setSource("field1", "text" + (i % 2), "field2", i).get();
    }
        SearchResponse resp = client().prepareSearch("test-index2").setQuery(scriptScoreQuery(rangeQB, script)).get();
        public long cost() {
 * The OpenSearch Contributors require contributions made to  
    public static class BulkScoringScriptPlugin extends Plugin implements ScriptPlugin {
                @Override  
            ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        @Override
        public int score(LeafCollector collector, Bits acceptDocs, int min, int max) throws IOException {  
            assertNoFailures(resp);  
        }
            prepareCreate("bulk-test-index").setSettings(Settings.builder().put("index.number_of_shards", 1))
            Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['field2'].value * param1", params);
        indexRandomForConcurrentSearch("bulk-test-boost");
                .setMapping("field1", "type=text")  
            });
        }
            prepareCreate("bulk-test-boost").setSettings(Settings.builder().put("index.number_of_shards", 1))
            prepareCreate("test-index2").setSettings(Settings.builder().put("index.number_of_shards", 1))  
            .setQuery(scriptScoreQuery(termQuery("field1", "foo"), script))  
            // Execute with search.allow_expensive_queries = null => default value = true => success
            prepareCreate("bulk-test-minscore").setSettings(Settings.builder().put("index.number_of_shards", 1))  
        refresh();  
            updateSettingsRequest = new ClusterUpdateSettingsRequest();
        indexRandomForConcurrentSearch("bulk-test-fallback");
            Map<String, Object> params = new HashMap<>();
import static org.opensearch.index.query.QueryBuilders.boolQuery;
import org.opensearch.index.query.RangeQueryBuilder;
import org.apache.lucene.search.Scorable;
        int docCount = 10;  
        try {
        Map<String, Object> params = new HashMap<>();
    // 2) score is calculated based on a script with params
                    collector.collect(doc);
                e.getCause().getMessage()
    public void testScriptScoreBoolQuery() throws Exception {
        SearchResponse baseResp = client().prepareSearch("bulk-test-boost")  
    /**  
        SearchResponse resp = client().prepareSearch("bulk-test-explain")
    public static Collection<Object[]> parameters() {
            indexRandomForConcurrentSearch("test-index");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertThirdHit;  
        BulkScoringLeafFactoryImpl(Map<String, Object> params, SearchLookup lookup, IndexSearcher indexSearcher, boolean useBulk) {  
        SearchResponse resp = client().prepareSearch("bulk-test-minscore")
import static org.opensearch.index.query.QueryBuilders.termQuery;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
                client().prepareIndex("test-index").setId("" + i).setSource("field1", "text" + (i % 2), "field2", i).get();
            collector.setScorer(scorable);
    // ===== BulkScoringLeafFactory integration tests =====
        assertTrue(resp.getHits().getHits()[0].getExplanation().getDescription().contains("script score function, computed with script:"));  
import org.opensearch.script.ScriptEngine;
     * Source "bulk_score": bulk scorer assigns score = 1.0 * boost (docId-independent).  
        );
import static org.opensearch.index.query.QueryBuilders.idsQuery;
        Map<String, Object> params = new HashMap<>();
        client().prepareIndex("bulk-test-explain").setId("1").setSource("field1", "foo").get();
        params.put("param1", 0.1);
            SearchResponse resp = client().prepareSearch("test-index")  
        // path (newInstance → execute() returns 2.0). Verify explain returns the per-doc score.  
            this.params = params;
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['field2'].value * param1", params);
import org.apache.lucene.search.LeafCollector;  
            .setQuery(scriptScoreQuery(termQuery("field1", "foo"), script).setMinScore(1.5f))  
    // test case added for issue https://github.com/opensearch-project/OpenSearch/issues/18446
 * this file be licensed under the Apache-2.0 license or a
        refresh();  
            );
            assertEquals(
        public boolean needs_score() {
 * software distributed under the License is distributed on an
            this.indexSearcher = indexSearcher;  
        public BulkScorer bulkScorer(LeafReaderContext context, BulkScorer subQueryBulkScorer, ScoreMode subQueryScoreMode, float boost)
            if (useBulk == false) {
import java.util.HashMap;
        public static final String NAME = "bulk_test";
        client().prepareIndex("bulk-test-index").setId("2").setSource("field1", "foo").get();  
    }
    @Override
import java.util.Arrays;
                boolean useBulk = "bulk_score".equals(source);
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", true));  
        // However, Lucene prefers bulkScorer() instead of scorer() which doesn't trigger NPE as stated in issue 18446.  
            params.put("param1", 0.1);
            resp = client().prepareSearch("test-index").setQuery(scriptScoreQuery(matchQuery("field1", "text0"), script)).get();
            client().prepareIndex("test-index").setId("" + i).setSource("field1", "text" + i, "field2", i).get();
        for (var hit : resp.getHits().getHits()) {
        indexRandomForConcurrentSearch("bulk-test-minscore");  
        }
            ScoreScript.Factory factory = (Map<String, Object> p, SearchLookup lookup, IndexSearcher indexSearcher) -> {
                }  
    public void testBulkScoringExplainUsesPerDocPath() throws Exception {
    // 1) only matched docs retrieved
                return field2Values.getValue() * param1;  
    }
        );
        @Override  
        client().prepareIndex("bulk-test-index").setId("1").setSource("field1", "foo").get();
 * Licensed to Elasticsearch under one or more contributor  
        assertOrderedSearchHits(resp, "10", "8", "6");
        refresh();
        // The bulk scorer produces score = 1.0 * boost, but explain always uses the per-doc
 *
        params.put("param1", 0.1);
        refresh();  
 * KIND, either express or implied.  See the License for the
        client().prepareIndex("bulk-test-index").setId("3").setSource("field1", "foo").get();
import org.apache.lucene.index.LeafReaderContext;  
        for (var hit : resp.getHits().getHits()) {
        assertNoFailures(resp);  
 * the Apache License, Version 2.0 (the "License"); you may
        indexRandomForConcurrentSearch("test-index");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(staticSettings);  
            .get();
            }, acceptDocs, min, max);
     * <p>
    public void testBulkScoringBypassedWithMinScore() throws Exception {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    // ===== Bulk Scoring Script Plugin =====  
            assertEquals(2.0f, hit.getScore(), 0.001f);
     * segment-local docId of the real doc non-deterministically, so a docId-derived score would
public class ScriptScoreQueryIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
        return Arrays.asList(
                () -> client().prepareSearch("test-index").setQuery(scriptScoreQuery(matchQuery("field1", "text0"), script)).get()  
                @Override
    }
            ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();  
    }  
        @Override
        public ScriptEngine getScriptEngine(Settings settings, Collection<ScriptContext<?>> contexts) {
 */  
            for (int i = 1; i <= docCount; i++) {
import org.opensearch.search.lookup.SearchLookup;
     */
                .setMapping("field1", "type=date", "field2", "type=double")
        client().prepareIndex("test-index2").setId("2").setSource("field1", "2019-10-01", "field2", 2).get();
            .setQuery(scriptScoreQuery(termQuery("field1", "foo"), script))
            };
import org.apache.lucene.util.Bits;  
        private final Map<String, Object> params;
        assertNoFailures(resp);  
import org.opensearch.script.ScriptType;  
        client().prepareIndex("test-index2").setId("1").setSource("field1", "2019-09-01", "field2", 1).get();  
     * The base score is intentionally independent of the (segment-local) docId. With concurrent  
        assertAcked(prepareCreate("test-index").setMapping("field2", "type=double"));
                Double param1 = (Double) vars.get("param1");
        // The per-doc path (newInstance) returns a fixed score of 2.0.  
        assertAcked(  
        public String getType() {
        @Override
/*  
 * compatible open source license.
        client().prepareIndex("bulk-test-fallback").setId("1").setSource("field1", "foo").get();  
     * make assertions on absolute score values flaky.  
import org.opensearch.script.Script;  
            this.boost = boost;
 * Unless required by applicable law or agreed to in writing,
        // to make sure we test the intended code path
    // test that script_score works as expected:  
    }
            .setQuery(scriptScoreQuery(termQuery("field1", "foo"), script).boost(boost))  
            throws IOException {  
    @ParametersFactory  
            }  
        assertSecondHit(resp, hasScore(0.1f));  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
        client().prepareIndex("test-index2").setId("3").setSource("field1", "2019-11-01", "field2", 3).get();
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {  
        assertEquals(3, resp.getHits().getTotalHits().value());
    public void testBulkScoringWithBoost() throws Exception {  
        }
        assertFirstHit(resp, hasScore(1.0f));
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", (String) null));  
                .setMapping("field1", "type=text")  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertOrderedSearchHits;
package org.opensearch.search.query;
        indexRandomForConcurrentSearch("test-index");
        return Arrays.asList(CustomScriptPlugin.class, BulkScoringScriptPlugin.class);
        assertEquals(1, resp.getHits().getTotalHits().value());
        SearchResponse resp = client().prepareSearch("bulk-test-boost")
        Script script = new Script(ScriptType.INLINE, BulkScoringScriptEngine.NAME, "bulk_score", Collections.emptyMap());
        assertOrderedSearchHits(resp, "10", "8", "6", "4", "2");  
        // Use a term filter to match only our specific doc, avoiding random docs from indexRandomForConcurrentSearch
    public void testBulkScoringProducesCorrectScores() throws Exception {  
        assertNoFailures(resp);
        @Override  
import java.util.Collection;  
    public void testBulkScoringFallbackWhenReturnsNull() throws Exception {
import org.opensearch.script.ScriptContext;
     * Source "fallback_score": bulkScorer() returns null, falling back to per-doc scoring with score = 2.0.
            if (context.equals(ScoreScript.CONTEXT) == false) {  
        indexRandomForConcurrentSearch("test-index");
    }  
            .get();
     */
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSecondHit;
    /**
        float baseScore = baseResp.getHits().getHits()[0].getScore();
        @Override
        for (int i = 1; i <= docCount; i++) {
            .get();
        private static final float BASE_SCORE = 1.0f;
        assertNoFailures(resp);  
            refresh();
        );  
    }
        QueryBuilder scriptScoreQuery = scriptScoreQuery(idsQuery, script);
        float boost = 3.0f;  
        // When minScore is set, ScriptScoreQuery bypasses bulk scoring and uses per-doc ScriptScorer.
                public double execute(ExplanationHolder explanation) {
import java.util.function.Function;
        refresh();
 *
            );
        private final BulkScorer subQueryBulkScorer;  
        assertNoFailures(resp);
 * not use this file except in compliance with the License.
        }  
        );
                @Override
        private final boolean useBulk;
        client().prepareIndex("bulk-test-minscore").setId("2").setSource("field1", "foo").get();
import org.opensearch.OpenSearchException;
 * specific language governing permissions and limitations
        client().prepareIndex("test-index").setId("1").setSource("field2", 1).get();
        private final float boost;
import org.opensearch.plugins.ScriptPlugin;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;  
 *  
import org.apache.lucene.search.BulkScorer;
        }
        }  
        params.put("param1", 0.1);
        int docCount = 10;  
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFirstHit;
        }  
            Scorable scorable = new Scorable() {
        params.put("param1", 0.1);
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
        assertEquals(baseScore * boost, resp.getHits().getHits()[0].getScore(), 0.001f);
/*  
            .setQuery(scriptScoreQuery(termQuery("field1", "foo"), script))
        QueryBuilder boolQuery = boolQuery().should(matchQuery("field1", "text1")).should(matchQuery("field1", "text10"));
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.index.query.QueryBuilders.matchQuery;  
        assertThirdHit(resp, hasScore(0.6f));  
        assertNoFailures(resp);
                return new BulkScoringLeafFactoryImpl(p, lookup, indexSearcher, useBulk);  
    public static class BulkScoringScriptEngine implements ScriptEngine {  
    }
     * then assigns each document a score of BASE_SCORE * boost.
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        assertEquals(1, resp.getHits().getTotalHits().value());  
            scripts.put("doc['field2'].value * param1", vars -> {
        );
        // Issue 18446 arises because of null Scorer returned from ScorerSupplier.
import org.opensearch.plugins.Plugin;
                "[script score] queries cannot be executed when 'search.allow_expensive_queries' is set to false.",  
    }  
            // Set search.allow_expensive_queries to "true" => success
                .setMapping("field1", "type=text")
        client().prepareIndex("bulk-test-minscore").setId("1").setSource("field1", "foo").get();  
     * A simple bulk scorer that drives the sub-query's bulk scorer to discover matched docs,  
        );
 * SPDX-License-Identifier: Apache-2.0
     * segment search, the bogus docs indexed by {@code indexRandomForConcurrentSearch} shift the
    private static class SimpleBulkScorer extends BulkScorer {
        @Override
                    return currentScore[0];
    }
        assertAcked(prepareCreate("test-index").setMapping("field1", "type=text", "field2", "type=double"));
        @SuppressWarnings("unchecked")
        // applying min score
            assertAcked(prepareCreate("test-index").setMapping("field1", "type=text", "field2", "type=double"));
        for (int i = 1; i <= docCount; i++) {
        Script script = new Script(ScriptType.INLINE, BulkScoringScriptEngine.NAME, "fallback_score", Collections.emptyMap());
            return new BulkScoringScriptEngine();
        assertAcked(
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        Script script = new Script(ScriptType.INLINE, BulkScoringScriptEngine.NAME, "bulk_score", Collections.emptyMap());
 * under the License.  
 * You may obtain a copy of the License at  
            return NAME;  
import org.opensearch.index.fielddata.ScriptDocValues;
import java.util.Set;
        // "fallback_score" source triggers null from bulkScorer() → falls back to per-doc scoring (returns 2.0)
        }
    // 3) min score applied  
            return (T) factory;
    public void testRewrittenQuery() throws Exception {
                }  
            .setQuery(scriptScoreQuery(termQuery("field1", "foo"), script))
        SearchResponse resp = client().prepareSearch("test-index").setQuery(scriptScoreQuery(matchQuery("field1", "text0"), script)).get();
import org.apache.lucene.search.ScoreMode;
        private final SearchLookup lookup;
        assertOrderedSearchHits(resp, "3", "2", "1");  
                ScriptDocValues.Doubles field2Values = (ScriptDocValues.Doubles) doc.get("field2");
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        RangeQueryBuilder rangeQB = new RangeQueryBuilder("field1").from("2019-01-01"); // the query should be rewritten to from:null  
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
    public void testDisallowExpensiveQueries() throws Exception {  
            assertTrue("Score should be positive from bulk scorer, got: " + hit.getScore(), hit.getScore() > 0f);  
            return Set.of(ScoreScript.CONTEXT);
                return null;
            OpenSearchException e = expectThrows(
            };
}  
        assertEquals(1, resp.getHits().getTotalHits().value());
                .setMapping("field1", "type=text")
        // Query with boost — score should be base * boost
                .setQuery(scriptScoreQuery(matchQuery("field1", "text0"), script))
        @Override
        assertNoFailures(resp);  
        assertEquals(2, resp.getHits().getTotalHits().value());  
/*
        Map<String, Object> params = new HashMap<>();  
        assertNoFailures(baseResp);  
        }
    public void testScriptScore() throws Exception {
import org.apache.lucene.search.IndexSearcher;
        assertAcked(
        @Override  
        }  
        assertNoFailures(resp);
        refresh();
import java.util.Map;  
            }
 */  
            .get();
        public ScoreScript newInstance(LeafReaderContext ctx) throws IOException {
            assertNoFailures(resp);  
        indexRandomForConcurrentSearch("bulk-test-explain");  
                @Override  
 * GitHub history for details.
        Script script = new Script(ScriptType.INLINE, BulkScoringScriptEngine.NAME, "bulk_score", Collections.emptyMap());
        assertNotNull(resp.getHits().getHits()[0].getExplanation());
import static org.opensearch.index.query.QueryBuilders.scriptScoreQuery;
            int docCount = 10;  
        assertAcked(
        assertSecondHit(resp, hasScore(0.8f));
        assertAcked(
    }
            return new SimpleBulkScorer(subQueryBulkScorer, boost);
        assertFirstHit(resp, hasScore(1.0f));
    }
        resp = client().prepareSearch("test-index")  
        );
        }  
        assertNoFailures(resp);
import org.opensearch.index.query.QueryBuilder;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasScore;
            .get();
        }
import org.opensearch.action.search.SearchResponse;  
    }  
                throw new IllegalArgumentException("Unsupported context: " + context.name);
        @Override
    public ScriptScoreQueryIT(Settings staticSettings) {
                    currentScore[0] = BASE_SCORE * boost;
        SimpleBulkScorer(BulkScorer subQueryBulkScorer, float boost) {  
            .setExplain(true)
            // Set search.allow_expensive_queries to "false" => assert failure
        assertNoFailures(resp);  
            return subQueryBulkScorer.cost();  
                public void setScorer(Scorable scorer) {}  
            final float[] currentScore = new float[1];
        } finally {
                .setMapping("field1", "type=text")
    }
import org.opensearch.script.MockScriptPlugin;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                    return 2.0;
        private final IndexSearcher indexSearcher;  
        public Set<ScriptContext<?>> getSupportedContexts() {  
        assertEquals(2.0f, resp.getHits().getHits()[0].getScore(), 0.001f);
                }  
        }  
            this.subQueryBulkScorer = subQueryBulkScorer;
     * A minimal script engine that produces a {@link ScoreScript.BulkScoringLeafFactory}.
        Map<String, Object> params = new HashMap<>();
        public <T> T compile(String name, String source, ScriptContext<T> context, Map<String, String> params) {
        SearchResponse resp = client().prepareSearch("test-index").setQuery(scriptScoreQuery).setProfile(true).get();  
            return scripts;
            return false;  
        // As a result, we have to set profile to true to force the usage of scorer() instead of bulkScorer(),
    public void testScriptScoreNotExistingQuery() throws Exception {  
 * Modifications Copyright OpenSearch Contributors. See
        refresh();
        Script script = new Script(ScriptType.INLINE, BulkScoringScriptEngine.NAME, "bulk_score", Collections.emptyMap());
        assertAcked(prepareCreate("test-index").setMapping("field1", "type=text", "field2", "type=double"));
