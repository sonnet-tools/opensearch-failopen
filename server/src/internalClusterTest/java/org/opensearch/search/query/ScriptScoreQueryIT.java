        // The per-doc path (newInstance) returns a fixed score of 2.0.
import org.opensearch.script.ScriptContext;
    /**
        refresh();
        indexRandomForConcurrentSearch("bulk-test-fallback");
    public void testBulkScoringFallbackWhenReturnsNull() throws Exception {
            // Set search.allow_expensive_queries to "true" => success
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSecondHit;
        QueryBuilder boolQuery = boolQuery().should(matchQuery("field1", "text1")).should(matchQuery("field1", "text10"));
        public ScriptEngine getScriptEngine(Settings settings, Collection<ScriptContext<?>> contexts) {
        public long cost() {
import org.opensearch.script.ScriptEngine;
import org.opensearch.index.fielddata.ScriptDocValues;
            }
        refresh();
            this.subQueryBulkScorer = subQueryBulkScorer;
        public BulkScorer bulkScorer(LeafReaderContext context, BulkScorer subQueryBulkScorer, ScoreMode subQueryScoreMode, float boost)
        assertOrderedSearchHits(resp, "10", "1");
            SearchResponse resp = client().prepareSearch("test-index")
        assertSecondHit(resp, hasScore(0.8f));
    private static class BulkScoringLeafFactoryImpl implements ScoreScript.BulkScoringLeafFactory {
        refresh();
    }
                e.getCause().getMessage()
 * specific language governing permissions and limitations
import java.util.Collections;
            .get();
import static org.opensearch.index.query.QueryBuilders.termQuery;
            }
    public void testScriptScoreNotExistingQuery() throws Exception {
 * The OpenSearch Contributors require contributions made to
        client().prepareIndex("bulk-test-index").setId("2").setSource("field1", "foo").get();
    }
        assertNotNull(resp.getHits().getHits()[0].getExplanation());
        assertNoFailures(baseResp);
public class ScriptScoreQueryIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        QueryBuilder scriptScoreQuery = scriptScoreQuery(idsQuery, script);
            if (useBulk == false) {
            .get();
            prepareCreate("bulk-test-minscore").setSettings(Settings.builder().put("index.number_of_shards", 1))
            );
        indexRandomForConcurrentSearch("test-index");
            int docCount = 10;
        );
        assertAcked(
        @Override
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", false));
                public double execute(ExplanationHolder explanation) {
import static org.opensearch.index.query.QueryBuilders.matchQuery;
                boolean useBulk = "bulk_score".equals(source);
            assertEquals(
import org.opensearch.index.query.QueryBuilder;
 * KIND, either express or implied.  See the License for the
        params.put("param1", 0.1);
import java.util.Set;
                .setMapping("field1", "type=date", "field2", "type=double")
        QueryBuilder idsQuery = idsQuery().addIds("2");
            return (T) factory;
        Script script = new Script(ScriptType.INLINE, BulkScoringScriptEngine.NAME, "bulk_score", Collections.emptyMap());
                throw new IllegalArgumentException("Unsupported context: " + context.name);
    }
     * <p>
    }
                "[script score] queries cannot be executed when 'search.allow_expensive_queries' is set to false.",
        refresh();
    public void testBulkScoringBypassedWithMinScore() throws Exception {
            refresh();
        refresh();
        @Override
     * The base score is intentionally independent of the (segment-local) docId. With concurrent
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        SearchResponse resp = client().prepareSearch("bulk-test-minscore")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        }
                .get();
        @Override
        @Override
            prepareCreate("bulk-test-explain").setSettings(Settings.builder().put("index.number_of_shards", 1))
        return Arrays.asList(CustomScriptPlugin.class, BulkScoringScriptPlugin.class);
        assertNoFailures(resp);
        indexRandomForConcurrentSearch("bulk-test-boost");
            .setExplain(true)
        }
        private final BulkScorer subQueryBulkScorer;
        assertNoFailures(resp);
        resp = client().prepareSearch("test-index")
        public static final String NAME = "bulk_test";
    /**
        SearchResponse resp = client().prepareSearch("test-index2").setQuery(scriptScoreQuery(rangeQB, script)).get();
            .get();
 */
import org.opensearch.script.Script;
    }
            .setQuery(scriptScoreQuery(termQuery("field1", "foo"), script).setMinScore(1.5f))
                return null;
        params.put("param1", 0.1);
        refresh();
        indexRandomForConcurrentSearch("test-index");
        assertAcked(
        // When minScore is set, ScriptScoreQuery bypasses bulk scoring and uses per-doc ScriptScorer.
        for (var hit : resp.getHits().getHits()) {
    public void testRewrittenQuery() throws Exception {
    }
import org.apache.lucene.search.Scorable;
        SearchResponse resp = client().prepareSearch("test-index").setQuery(scriptScoreQuery(matchQuery("field1", "text0"), script)).get();
    }
 *
            prepareCreate("bulk-test-index").setSettings(Settings.builder().put("index.number_of_shards", 1))
                }
            };
                    currentScore[0] = BASE_SCORE * boost;
        float boost = 3.0f;
            .setQuery(scriptScoreQuery(termQuery("field1", "foo"), script).boost(boost))
        assertEquals(2.0f, resp.getHits().getHits()[0].getScore(), 0.001f);
        for (int i = 1; i <= docCount; i++) {
        SearchResponse resp = client().prepareSearch("test-index").setQuery(scriptScoreQuery).setProfile(true).get();
        private final SearchLookup lookup;
    public void testBulkScoringWithBoost() throws Exception {
        assertNoFailures(resp);
            return new BulkScoringScriptEngine();
        // path (newInstance → execute() returns 2.0). Verify explain returns the per-doc score.
    public void testScriptScoreBoolQuery() throws Exception {
        refresh();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertOrderedSearchHits;
import java.util.function.Function;
        params.put("param1", 0.1);
            prepareCreate("test-index2").setSettings(Settings.builder().put("index.number_of_shards", 1))
        public Set<ScriptContext<?>> getSupportedContexts() {
        // Query with boost — score should be base * boost
            this.lookup = lookup;
            .setQuery(scriptScoreQuery(termQuery("field1", "foo"), script))
     * then assigns each document a score of BASE_SCORE * boost.
        Map<String, Object> params = new HashMap<>();
                }
import org.opensearch.common.settings.Settings;
        refresh();
        assertEquals(3, resp.getHits().getTotalHits().value());
        client().prepareIndex("bulk-test-minscore").setId("2").setSource("field1", "foo").get();
import org.opensearch.OpenSearchException;
            scripts.put("doc['field2'].value * param1", vars -> {
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
            Map<String, Object> params = new HashMap<>();
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            ScoreScript.Factory factory = (Map<String, Object> p, SearchLookup lookup, IndexSearcher indexSearcher) -> {
            return subQueryBulkScorer.cost();
            .get();
package org.opensearch.search.query;
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor
        }
import java.util.Arrays;
        Map<String, Object> params = new HashMap<>();
                .setMapping("field1", "type=text")
            };
        Map<String, Object> params = new HashMap<>();
            assertEquals(2.0f, hit.getScore(), 0.001f);
import org.opensearch.index.query.RangeQueryBuilder;
                client().prepareIndex("test-index").setId("" + i).setSource("field1", "text" + (i % 2), "field2", i).get();
            return false;
        }
            return new ScoreScript(params, lookup, indexSearcher, ctx) {
 *
        assertEquals(1, resp.getHits().getTotalHits().value());
    public void testDisallowExpensiveQueries() throws Exception {
                public void setScorer(Scorable scorer) {}
                @Override
        assertAcked(
        assertEquals(2, resp.getHits().getTotalHits().value());
        }
        );
            assertNoFailures(resp);
import static org.opensearch.index.query.QueryBuilders.scriptScoreQuery;
        public boolean needs_score() {
        private final float boost;
        assertOrderedSearchHits(resp, "10", "8", "6");
    }
        assertEquals(1, resp.getHits().getTotalHits().value());
    // 2) score is calculated based on a script with params
     * A simple bulk scorer that drives the sub-query's bulk scorer to discover matched docs,
import java.util.Map;
        indexRandomForConcurrentSearch("bulk-test-minscore");
                () -> client().prepareSearch("test-index").setQuery(scriptScoreQuery(matchQuery("field1", "text0"), script)).get()
        );
        // Issue 18446 arises because of null Scorer returned from ScorerSupplier.
        params.put("param1", 0.1);
            Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['field2'].value * param1", params);
        assertNoFailures(resp);
        SimpleBulkScorer(BulkScorer subQueryBulkScorer, float boost) {
    }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        }
        public String getType() {
        SearchResponse resp = client().prepareSearch("bulk-test-boost")
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        assertNoFailures(resp);
        assertThirdHit(resp, hasScore(0.6f));
        );
        Script script = new Script(ScriptType.INLINE, BulkScoringScriptEngine.NAME, "bulk_score", Collections.emptyMap());
 * this file be licensed under the Apache-2.0 license or a
}
        assertAcked(prepareCreate("test-index").setMapping("field1", "type=text", "field2", "type=double"));
            prepareCreate("bulk-test-fallback").setSettings(Settings.builder().put("index.number_of_shards", 1))
    public static class BulkScoringScriptPlugin extends Plugin implements ScriptPlugin {
                .setMapping("field1", "type=text")
        private static final float BASE_SCORE = 1.0f;
    public static class CustomScriptPlugin extends MockScriptPlugin {
    // test that script_score works as expected:
            return subQueryBulkScorer.score(new LeafCollector() {
        client().prepareIndex("bulk-test-fallback").setId("1").setSource("field1", "foo").get();
import static org.opensearch.index.query.QueryBuilders.boolQuery;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                public void collect(int doc) throws IOException {
    private static class SimpleBulkScorer extends BulkScorer {
        client().prepareIndex("bulk-test-index").setId("1").setSource("field1", "foo").get();
                return new BulkScoringLeafFactoryImpl(p, lookup, indexSearcher, useBulk);
        assertSecondHit(resp, hasScore(0.1f));
            params.put("param1", 0.1);
import java.util.HashMap;
            }, acceptDocs, min, max);
 * ownership. Elasticsearch licenses this file to you under
        }
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasScore;
                Double param1 = (Double) vars.get("param1");
import java.util.Collection;
    public void testScriptScore() throws Exception {
import org.apache.lucene.search.BulkScorer;
        @Override
    // ===== Bulk Scoring Script Plugin =====
            this.indexSearcher = indexSearcher;
        assertNoFailures(resp);
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['field2'].value * param1", params);
        Script script = new Script(ScriptType.INLINE, BulkScoringScriptEngine.NAME, "bulk_score", Collections.emptyMap());
            return scripts;
        assertNoFailures(resp);
        }
import org.opensearch.action.search.SearchResponse;
 * not use this file except in compliance with the License.
        assertNoFailures(resp);
 *
/*
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    }
        assertEquals(1, baseResp.getHits().getTotalHits().value());
            .setQuery(scriptScoreQuery(matchQuery("field1", "text0"), script).setMinScore(0.6f))
    }
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                .setQuery(scriptScoreQuery(matchQuery("field1", "text0"), script))
            ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
            // Set search.allow_expensive_queries to "false" => assert failure
            .get();
        // to make sure we test the intended code path
            return Set.of(ScoreScript.CONTEXT);
        public <T> T compile(String name, String source, ScriptContext<T> context, Map<String, String> params) {
                @Override
    public void testBulkScoringExplainUsesPerDocPath() throws Exception {
            return new SimpleBulkScorer(subQueryBulkScorer, boost);
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
 * You may obtain a copy of the License at
        Script script = new Script(ScriptType.INLINE, BulkScoringScriptEngine.NAME, "bulk_score", Collections.emptyMap());
                }
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        SearchResponse resp = client().prepareSearch("bulk-test-index")
        assertOrderedSearchHits(resp, "3", "2", "1");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFirstHit;
        int docCount = 10;
        assertEquals(baseScore * boost, resp.getHits().getHits()[0].getScore(), 0.001f);
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        @Override
     * segment-local docId of the real doc non-deterministically, so a docId-derived score would
            resp = client().prepareSearch("test-index").setQuery(scriptScoreQuery(matchQuery("field1", "text0"), script)).get();
    }
                .setMapping("field1", "type=text")
import org.apache.lucene.search.LeafCollector;
    }
/*
        @Override
        RangeQueryBuilder rangeQB = new RangeQueryBuilder("field1").from("2019-01-01"); // the query should be rewritten to from:null
    // test case added for issue https://github.com/opensearch-project/OpenSearch/issues/18446
        assertAcked(
     * Source "fallback_score": bulkScorer() returns null, falling back to per-doc scoring with score = 2.0.
            Scorable scorable = new Scorable() {
 */
        }
    // 1) only matched docs retrieved
            client().prepareIndex("test-index").setId("" + i).setSource("field1", "text" + i, "field2", i).get();
        client().prepareIndex("bulk-test-explain").setId("1").setSource("field1", "foo").get();
            client().prepareIndex("test-index").setId("" + i).setSource("field1", "text" + (i % 2), "field2", i).get();
            ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        public ScoreScript newInstance(LeafReaderContext ctx) throws IOException {
        assertAcked(prepareCreate("test-index").setMapping("field2", "type=double"));
    @ParametersFactory
        client().prepareIndex("test-index2").setId("1").setSource("field1", "2019-09-01", "field2", 1).get();
    public static Collection<Object[]> parameters() {
 * the Apache License, Version 2.0 (the "License"); you may
        }
        }
            });
    // test that when the internal query is rewritten script_score works well
        refresh();
        );
        client().prepareIndex("test-index2").setId("3").setSource("field1", "2019-11-01", "field2", 3).get();
                .setMapping("field1", "type=text")
            indexRandomForConcurrentSearch("test-index");
import org.opensearch.plugins.Plugin;
    public ScriptScoreQueryIT(Settings staticSettings) {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                ScriptDocValues.Doubles field2Values = (ScriptDocValues.Doubles) doc.get("field2");
                OpenSearchException.class,
                public float score() {
                    collector.collect(doc);
        SearchResponse baseResp = client().prepareSearch("bulk-test-boost")
        }
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", true));
                @Override
    }
    // 3) min score applied
        indexRandomForConcurrentSearch("bulk-test-explain");
import org.apache.lucene.search.ScoreMode;
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
import static org.opensearch.index.query.QueryBuilders.idsQuery;
        // Use a term filter to match only our specific doc, avoiding random docs from indexRandomForConcurrentSearch
        // "fallback_score" source triggers null from bulkScorer() → falls back to per-doc scoring (returns 2.0)
        // As a result, we have to set profile to true to force the usage of scorer() instead of bulkScorer(),
 * under the License.
                    return 2.0;
        indexRandomForConcurrentSearch("test-index");
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['field2'].value * param1", params);
        @SuppressWarnings("unchecked")
        }
                .setMapping("field1", "type=text")
     */
     */
        }
import org.opensearch.plugins.ScriptPlugin;
        for (var hit : resp.getHits().getHits()) {
        assertFirstHit(resp, hasScore(1.0f));
            for (int i = 1; i <= docCount; i++) {
 * software distributed under the License is distributed on an
                @Override
            collector.setScorer(scorable);
 * Modifications Copyright OpenSearch Contributors. See
        indexRandomForConcurrentSearch("bulk-test-index");
    public void testBulkScoringProducesCorrectScores() throws Exception {
        SearchResponse resp = client().prepareSearch("bulk-test-explain")
    public static class BulkScoringScriptEngine implements ScriptEngine {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertThirdHit;
        assertAcked(prepareCreate("test-index").setMapping("field1", "type=text", "field2", "type=double"));
        // applying min score
            prepareCreate("bulk-test-boost").setSettings(Settings.builder().put("index.number_of_shards", 1))
        BulkScoringLeafFactoryImpl(Map<String, Object> params, SearchLookup lookup, IndexSearcher indexSearcher, boolean useBulk) {
        return Arrays.asList(
            .get();
            );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        client().prepareIndex("test-index2").setId("2").setSource("field1", "2019-10-01", "field2", 2).get();
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", (String) null));
        assertAcked(
import org.apache.lucene.index.LeafReaderContext;
        public int score(LeafCollector collector, Bits acceptDocs, int min, int max) throws IOException {
import org.opensearch.script.MockScriptPlugin;
 * compatible open source license.
     * <p>
            this.params = params;
 * this work for additional information regarding copyright
        client().prepareIndex("test-index").setId("1").setSource("field2", 1).get();
        client().prepareIndex("bulk-test-boost").setId("1").setSource("field1", "foo").get();
        @Override
        client().prepareIndex("bulk-test-minscore").setId("1").setSource("field1", "foo").get();
            this.boost = boost;
    }
        } finally {
            this.useBulk = useBulk;
            assertAcked(prepareCreate("test-index").setMapping("field1", "type=text", "field2", "type=double"));
                    return currentScore[0];
        assertAcked(
 * license agreements. See the NOTICE file distributed with
            return NAME;
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['field2'].value * param1", params);
        for (int i = 1; i <= docCount; i++) {
            final float[] currentScore = new float[1];
                return field2Values.getValue() * param1;
        @Override
import org.opensearch.script.ScriptType;
import org.opensearch.search.lookup.SearchLookup;
        // The bulk scorer produces score = 1.0 * boost, but explain always uses the per-doc
            if (context.equals(ScoreScript.CONTEXT) == false) {
        @Override
     * segment search, the bogus docs indexed by {@code indexRandomForConcurrentSearch} shift the
     * A minimal script engine that produces a {@link ScoreScript.BulkScoringLeafFactory}.
        private final Map<String, Object> params;
/*
    @Override
        private final IndexSearcher indexSearcher;
        assertNoFailures(resp);
                Map<?, ?> doc = (Map) vars.get("doc");
        client().prepareIndex("bulk-test-index").setId("3").setSource("field1", "foo").get();
    // ===== BulkScoringLeafFactory integration tests =====
        super(staticSettings);
import org.apache.lucene.search.IndexSearcher;
        }
        assertTrue(resp.getHits().getHits()[0].getExplanation().getDescription().contains("script score function, computed with script:"));
        indexRandomForConcurrentSearch("test-index2");
    }
        assertEquals(1, resp.getHits().getTotalHits().value());
        );
        Map<String, Object> params = new HashMap<>();
        try {
    }
        SearchResponse resp = client().prepareSearch("bulk-test-fallback")
            .setQuery(scriptScoreQuery(termQuery("field1", "foo"), script))
import java.io.IOException;
        SearchResponse resp = client().prepareSearch("test-index").setQuery(scriptScoreQuery(boolQuery, script)).get();
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['field2'].value * param1", params);
            .setQuery(scriptScoreQuery(termQuery("field1", "foo"), script))
        int docCount = 10;
     * make assertions on absolute score values flaky.
     * Source "bulk_score": bulk scorer assigns score = 1.0 * boost (docId-independent).
        assertOrderedSearchHits(resp, "10", "8", "6", "4", "2");
 * SPDX-License-Identifier: Apache-2.0
            OpenSearchException e = expectThrows(
 * Unless required by applicable law or agreed to in writing,
        assertFirstHit(resp, hasScore(1.0f));
import org.apache.lucene.util.Bits;
        assertNoFailures(resp);
        // However, Lucene prefers bulkScorer() instead of scorer() which doesn't trigger NPE as stated in issue 18446.
        float baseScore = baseResp.getHits().getHits()[0].getScore();
 */
            .get();
            throws IOException {
            // Execute with search.allow_expensive_queries = null => default value = true => success
        }
            };
        Script script = new Script(ScriptType.INLINE, BulkScoringScriptEngine.NAME, "fallback_score", Collections.emptyMap());
            assertTrue("Score should be positive from bulk scorer, got: " + hit.getScore(), hit.getScore() > 0f);
            .setQuery(scriptScoreQuery(termQuery("field1", "foo"), script))
import org.opensearch.script.ScoreScript;
        private final boolean useBulk;
        );
            }
            assertNoFailures(resp);
            updateSettingsRequest = new ClusterUpdateSettingsRequest();
