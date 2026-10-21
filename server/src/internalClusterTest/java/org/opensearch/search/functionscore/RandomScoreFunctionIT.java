        // Test for accessing _score.doubleValue()
        assertNoFailures(resp);
                functionScoreQuery(
            return Math.log(index + (factor * score));
        final String functionName = "func1";
import static org.opensearch.script.MockScriptPlugin.NAME;
        createIndex("test");
            scripts.put(
import java.util.Map;
    public void testScoreRange() throws Exception {
        int percentile25 = (filled / 4);
                .get()
        indexRandomForConcurrentSearch("test");
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                        new FunctionScoreQueryBuilder.FilterFunctionBuilder(fieldValueFactorFunction("index").factor(2)),
import org.opensearch.script.Script;
                    return cmp == 0 ? o1.getId().compareTo(o2.getId()) : cmp;
 * You may obtain a copy of the License at
        indexRandomForConcurrentSearch("test");
                .setId("" + i)
        assertNoFailures(resp);
            sum += i * matrix[i];
import org.opensearch.script.ScriptType;
                flush();
                    assertThat(hits, nullValue());
                "index",
        script = new Script(ScriptType.INLINE, NAME, "log(doc['index'].value + (factor * _score.longValue()))", params);
 * ownership. Elasticsearch licenses this file to you under
    public RandomScoreFunctionIT(Settings staticSettings) {
    }
            .get();
        assertAcked(
import static org.hamcrest.Matchers.nullValue;
        createIndex("test");
import org.opensearch.action.search.SearchResponse;
                functionScoreQuery(
                        new FunctionScoreQueryBuilder.FilterFunctionBuilder(scriptFunction(script)) }
        int outerIters = scaledRandomIntBetween(10, 20);
        assertNoFailures(resp);
        params.put("factor", randomIntBetween(2, 4));
            )
        assertNoFailures(
            .get();
 * not use this file except in compliance with the License.
                        new FunctionScoreQueryBuilder.FilterFunctionBuilder(scriptFunction(script)) }
 * SPDX-License-Identifier: Apache-2.0
                    for (int j = 0; j < hitCount; j++) {
        flush();
        int docCount = randomIntBetween(100, 200);
            .get();
        );
                int numDocsToChange = randomIntBetween(20, 50);
            .setExplain(true)
                });
                logger.info("percentile_25: {}", i);
            .setQuery(
            while (preference.startsWith("_")) {
        flush();
        assertEquals(1, resp.getHits().getTotalHits().value());
        for (int i = 0; i < count; i++) {
import static org.hamcrest.Matchers.equalTo;
        createIndex("test");
    }
    }
import org.opensearch.common.settings.Settings;
            }
        for (int i = 0; i < matrix.length; i++) {
        assertThat(firstHit.getScore(), greaterThan(1f));
                        new FunctionScoreQueryBuilder.FilterFunctionBuilder(fieldValueFactorFunction("index").factor(2)),
    }
        flushAndRefresh();
                filled++;
                logger.info("percentile_75: {}", i);
import java.util.function.Function;
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder[] {
            Map<?, ?> doc = (Map) vars.get("doc");
        resp = client().prepareSearch("test")
        firstHit = resp.getHits().getAt(0);
            )
import static org.hamcrest.Matchers.greaterThan;
        assertNoFailures(resp);
import org.opensearch.search.SearchHit;
            client().prepareIndex("test")
        for (int i = 0; i < iters; ++i) {
import org.apache.lucene.util.ArrayUtil;
        Map<String, Object> params = new HashMap<>();
        );
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
                .setSize(docCount)
                    matchQuery("body", "foo"),
    }
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                final SearchHit[] currentHits = searchResponse.getHits().getHits();
        }
        indexRandomForConcurrentSearch("test");
                if (i == 0) {
            .setQuery(
 * compatible open source license.
                ArrayUtil.timSort(currentHits, (o1, o2) -> {
        script = new Script(ScriptType.INLINE, NAME, "log(doc['index'].value + (factor * _score.intValue()))", params);
        assertEquals(0, resp.getHits().getTotalHits().value());
        return Arrays.asList(CustomScriptPlugin.class);
                    CoreMatchers.equalTo(0)
        logger.info("mean: {}", sum / (double) count);
        // Test for accessing _score
        SearchHit firstHit = resp.getHits().getAt(0);
        }
        int docCount = randomIntBetween(100, 200);
            matrix[Integer.valueOf(searchResponse.getHits().getAt(0).getId())]++;
                )
 */
                vars -> scoringScript(vars, ScoreAccessor::doubleValue)
        ensureGreen();
import org.hamcrest.CoreMatchers;
        createIndex("test");
import java.util.Arrays;
        @Override
        int filled = 0;
 *
        int percentile75 = percentile50 + percentile25;
        final int docCount = randomIntBetween(100, 200);
                // randomly change some docs to get them in different segments
            }
import org.opensearch.index.mapper.SeqNoFieldMapper;
            .get();
        index("test", "type", "1", jsonBuilder().startObject().endObject());
        indexRandomForConcurrentSearch("test");
                // we add 1 to the index field to make sure that the scripts below never compute log(0)
                        new FunctionScoreQueryBuilder.FilterFunctionBuilder(scriptFunction(script)) }
import static org.opensearch.index.query.QueryBuilders.functionScoreQuery;
 *
                    searchResponse.getShardFailures().length,
                    int cmp = Float.compare(o1.getScore(), o2.getScore());
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder[] {
                    assertThat(hits.length, equalTo(searchResponse.getHits().getHits().length));
        );
        // "description": "*:* (_name: query1)"
        );
                .setSource("body", randomFrom(Arrays.asList("foo", "bar", "baz")), "index", i + 1)
 * The OpenSearch Contributors require contributions made to
 * GitHub history for details.
    public void testSeedReportedInExplain() throws Exception {
        index("test", "type", "1", jsonBuilder().startObject().endObject());
        assertThat(firstHit.getExplanation().getDetails()[1].getDetails()[0].getDescription().toString(), containsString("seed: " + seed));
        for (int i = 0; i < matrix.length; i++) {
        SearchResponse resp = client().prepareSearch("test")
        assertThat(firstHit.getExplanation().getDetails()[0].getDescription().toString(), containsString("_name: " + queryName));
 */
import org.opensearch.script.ScoreAccessor;
                .setQuery(functionScoreQuery(matchAllQuery(), randomFunction().seed(randomInt()).setField(SeqNoFieldMapper.NAME)))
        ensureGreen();
                        new FunctionScoreQueryBuilder.FilterFunctionBuilder(scriptFunction(script)) }
            index("test", "type", "" + i, jsonBuilder().startObject().field("foo", i).endObject());
        createIndex("test");
        refresh();
            )
        int seed = 12345678;
        }
}
import static org.hamcrest.Matchers.lessThanOrEqualTo;
    }
            .get();
    public void testConsistentHitsWithSameSeed() throws Exception {
            prepareCreate("test").setMapping(
        logger.info("avg repeat: {}", sumRepeat / (double) filled);
        int sum = 0;
            scripts.put("log(doc['index'].value + (factor * _score))", vars -> scoringScript(vars, ScoreAccessor::doubleValue));
        final String queryName = "query1";
            SearchHit[] hits = null;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
                        new FunctionScoreQueryBuilder.FilterFunctionBuilder(fieldValueFactorFunction("index").factor(2)),
        return Arrays.asList(
            } else if (percentile25 == 0) {
            .setQuery(functionScoreQuery(matchAllQuery(), randomFunction().seed(1234).setField(SeqNoFieldMapper.NAME)))
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder[] {
                functionScoreQuery(
                assertThat(hit.getScore(), allOf(greaterThanOrEqualTo(0.0f), lessThanOrEqualTo(1.0f)));
        resp = client().prepareSearch("test").setQuery(functionScoreQuery(matchAllQuery(), randomFunction())).get();
                "log(doc['index'].value + (factor * _score.doubleValue()))",
        int maxRepeat = 0;
                        new FunctionScoreQueryBuilder.FilterFunctionBuilder(scriptFunction(script)) }
        // all random scores should be in range [0.0, 1.0]
import static org.hamcrest.Matchers.allOf;
            client().prepareSearch()
        int seed = 12345678;
        );
                    .get();
        assertThat(firstHit.getScore(), greaterThan(1f));
        ensureGreen();
        refresh();
        assertNoFailures(resp);
        // Test for accessing _score.floatValue()
        Script script = new Script(ScriptType.INLINE, NAME, "log(doc['index'].value + (factor * _score))", params);
        int[] matrix = new int[count];
        SearchHit firstHit = resp.getHits().getAt(0);
        for (int i = 0; i < docCount; i++) {
            final int seed = randomInt();
        indexRandomForConcurrentSearch("test");
                .get();
        firstHit = resp.getHits().getAt(0);
        for (int i = 0; i < docCount; i++) {
        resp = client().prepareSearch("test")
        assertNoFailures(
        assertNoFailures(
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    public void checkDistribution() throws Exception {
            if (matrix[i] == 0) {
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.randomFunction;
                    "Failures " + Arrays.toString(searchResponse.getShardFailures()),
                )
                .setQuery(functionScoreQuery(matchAllQuery(), randomFunction().seed(randomLong()).setField(SeqNoFieldMapper.NAME)))
    public static Collection<Object[]> parameters() {
        assertThat(firstHit.getScore(), greaterThan(1f));
        for (int i = 0; i < docCount; i++) {
        }
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
        }
            Double score = scoring.apply((ScoreAccessor) vars.get("_score")).doubleValue();
        for (int o = 0; o < outerIters; o++) {
                preference = randomRealisticUnicodeOfLengthBetween(1, 10);
            )
            .setQuery(
                        assertThat("" + j, currentHits[j].getId(), equalTo(hits[j].getId()));
import org.opensearch.script.MockScriptPlugin;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        for (int i = 0; i < docCount; i++) {
                    // identical we rely on collection order which might change.
            assertNoFailures(searchResponse);
                functionScoreQuery(
        assertAcked(prepareCreate("test"));
        assertThat(firstHit.getExplanation().getDetails(), arrayWithSize(2));
    @Override
        super(staticSettings);
            )
                    --numDocsToChange;
/*
        refresh();
            }
            String id = randomRealisticUnicodeOfCodepointLengthBetween(1, 50);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                "type=text",
        }
                while (numDocsToChange > 0) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    functionScoreQuery(
    }
                }
            for (int i = 0; i < innerIters; i++) {
    }
                .setSize(docCount) // get all docs otherwise we are prone to tie-breaking
        indexRandomForConcurrentSearch("test");
        ensureGreen();
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            } else if (percentile75 == 0) {
import java.util.Collection;
                .setSize(docCount) // get all docs otherwise we are prone to tie-breaking
import static org.hamcrest.Matchers.containsString;
            .setQuery(
                final int hitCount = searchResponse.getHits().getHits().length;
                    matchQuery("body", "foo"),
            .setQuery(
                        randomFunction().seed(randomRealisticUnicodeOfLengthBetween(10, 20)).setField(SeqNoFieldMapper.NAME)
                }
 * this work for additional information regarding copyright
            .setExplain(true)
                    }
    }
                refresh();
            scripts.put("log(doc['index'].value + (factor * _score.intValue()))", vars -> scoringScript(vars, ScoreAccessor::intValue));
            Integer factor = (Integer) vars.get("factor");
            if (value > 0) {
            .get();
 *
            percentile50--;
            .setQuery(functionScoreQuery(matchAllQuery(), randomFunction().seed(seed).setField(SeqNoFieldMapper.NAME)))
            SearchResponse searchResponse = client().prepareSearch()
                )
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.fieldValueFactorFunction;
/*
                    int doc = randomInt(docCount - 1);// watch out this is inclusive the max values!
                .setQuery(functionScoreQuery(matchAllQuery(), randomFunction()))
            .get();
import org.opensearch.index.query.functionscore.RandomScoreFunctionBuilder;
            maxRepeat = Math.max(maxRepeat, value);
 * this file be licensed under the Apache-2.0 license or a
        // Test for accessing _score.longValue()
            Double index = ((Number) ((ScriptDocValues<?>) doc.get("index")).get(0)).doubleValue();
        assertEquals(0, resp.getHits().getTotalHits().value());
        logger.info("distribution: {}", filled / (double) count);
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.scriptFunction;
                logger.info("median: {}", i);
        resp = client().prepareSearch("test")
            index("test", "type", "" + i, jsonBuilder().startObject().endObject());
import org.opensearch.plugins.Plugin;
                assertThat(
        assertNoFailures(resp);
                        matchAllQuery(),
        // "description": "random score function (seed: 12345678, field: _seq_no, _name: func1)"
            return scripts;
                    // for tie-breaking we have to resort here since if the score is
            percentile25--;
        logger.info("max repeat: {}", maxRepeat);
import static org.hamcrest.Matchers.arrayWithSize;
                .get()
                    .setSize(docCount) // get all docs otherwise we are prone to tie-breaking
        createIndex("test");
                    matchQuery("body", "foo"),
public class RandomScoreFunctionIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        refresh();
            }
        flush();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            client().prepareSearch()
        refresh();
                    randomFunction(functionName).seed(seed).setField(SeqNoFieldMapper.NAME)
            scripts.put("log(doc['index'].value + (factor * _score.floatValue()))", vars -> scoringScript(vars, ScoreAccessor::floatValue));
                continue;
                    matchQuery("body", "foo"),
                functionScoreQuery(
                );
            )
        firstHit = resp.getHits().getAt(0);
        int sumRepeat = 0;
                    hits = currentHits;
        }
        script = new Script(ScriptType.INLINE, NAME, "log(doc['index'].value + (factor * _score.doubleValue()))", params);
            sumRepeat += value;
 * license agreements. See the NOTICE file distributed with
                    )
        ensureGreen();
            }
            }
        assertThat(firstHit.getExplanation().getDetails()[1].getDetails(), arrayWithSize(2));
    public void testSeedAndNameReportedInExplain() throws Exception {
        assertNoFailures(resp);
                    index("test", "type", "" + doc, jsonBuilder().startObject().field("foo", doc).endObject());
                        assertThat("" + j, currentHits[j].getScore(), equalTo(hits[j].getScore()));
            int innerIters = scaledRandomIntBetween(2, 5);
                )
                SearchResponse searchResponse = client().prepareSearch()
                .setQuery(
                    .setPreference(preference)
        ensureGreen();
        assertThat(firstHit.getScore(), greaterThan(1f));
        int count = 10000;
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        flush();
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder[] {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                )
        int percentile50 = filled / 2;
            .setQuery(
        script = new Script(ScriptType.INLINE, NAME, "log(doc['index'].value + (factor * _score.floatValue()))", params);
                "type=" + randomFrom("short", "float", "long", "integer", "double")
                .get()
            )
                        new FunctionScoreQueryBuilder.FilterFunctionBuilder(fieldValueFactorFunction("index").factor(2)),
                    matchQuery("body", "foo"),
/*
 */
import static org.opensearch.index.query.QueryBuilders.matchQuery;
                    matchAllQuery().queryName(queryName),
    }
        assertNoFailures(resp);
        assertEquals(1, resp.getHits().getTotalHits().value());
            if (percentile50 == 0) {
 * Unless required by applicable law or agreed to in writing,
            percentile75--;
                .setSize(docCount) // get all docs otherwise we are prone to tie-breaking
                functionScoreQuery(
                .get();
                        new FunctionScoreQueryBuilder.FilterFunctionBuilder(fieldValueFactorFunction("index").factor(2)),
                "body",
            .get();
        assertThat(firstHit.getExplanation().toString(), containsString("" + seed));
        for (int i = 0; i < count; i++) {
        SearchResponse resp = client().prepareSearch("test")
                    .setQuery(functionScoreQuery(matchAllQuery(), randomFunction().seed(seed).setField("foo")))
            String preference = randomRealisticUnicodeOfLengthBetween(1, 10); // at least one char!!
    }
                )
        resp = client().prepareSearch("test")
            index("test", "type", id, jsonBuilder().startObject().endObject());
            for (SearchHit hit : searchResponse.getHits().getHits()) {
    public void testSeeds() throws Exception {
        }
 * Licensed to Elasticsearch under one or more contributor
        }
                )
            index("test", "type", "" + i, jsonBuilder().startObject().endObject());
        int docCount = randomIntBetween(100, 200);
        static Double scoringScript(Map<String, Object> vars, Function<ScoreAccessor, Number> scoring) {
 * under the License.
    public void testScoreAccessWithinScript() throws Exception {
        }
        int iters = scaledRandomIntBetween(10, 20);
        SearchHit firstHit = resp.getHits().getAt(0);
        refresh();
        SearchResponse resp = client().prepareSearch("test")
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        flush();
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;
        ensureGreen(); // make sure we are done otherwise preference could change?
                .get();
package org.opensearch.search.functionscore;
            int value = matrix[i];
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder[] {
    public static class CustomScriptPlugin extends MockScriptPlugin {
            client().prepareSearch()
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        SearchResponse resp = client().prepareSearch("test")
        // Test for accessing _score.intValue()
    @ParametersFactory
    public void testNoDocs() throws Exception {
        assertNoFailures(resp);
            );
import org.opensearch.index.fielddata.ScriptDocValues;
                .setQuery(functionScoreQuery(matchAllQuery(), new RandomScoreFunctionBuilder()))
        }
        assertThat(firstHit.getScore(), greaterThan(1f));
            SearchResponse searchResponse = client().prepareSearch()
                } else {
            scripts.put("log(doc['index'].value + (factor * _score.longValue()))", vars -> scoringScript(vars, ScoreAccessor::longValue));
        firstHit = resp.getHits().getAt(0);
import java.util.HashMap;
            // randomPreference should not start with '_' (reserved for known preference types (e.g. _shards, _primary)
