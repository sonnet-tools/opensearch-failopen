        }
            sumRepeat += value;
                )
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder[] {
        }
        SearchResponse resp = client().prepareSearch("test")
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        SearchHit firstHit = resp.getHits().getAt(0);  
        Script script = new Script(ScriptType.INLINE, NAME, "log(doc['index'].value + (factor * _score))", params);  
        return Arrays.asList(
import static org.opensearch.script.MockScriptPlugin.NAME;
package org.opensearch.search.functionscore;
            .setQuery(functionScoreQuery(matchAllQuery(), randomFunction().seed(seed).setField(SeqNoFieldMapper.NAME)))
            )  
        for (int i = 0; i < docCount; i++) {  
import org.opensearch.action.search.SearchResponse;  
        }
        indexRandomForConcurrentSearch("test");
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
                final SearchHit[] currentHits = searchResponse.getHits().getHits();
                logger.info("percentile_25: {}", i);  
    }
    @ParametersFactory
            Double index = ((Number) ((ScriptDocValues<?>) doc.get("index")).get(0)).doubleValue();
        index("test", "type", "1", jsonBuilder().startObject().endObject());
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                logger.info("median: {}", i);
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.randomFunction;
    }
import static org.opensearch.index.query.QueryBuilders.functionScoreQuery;
            client().prepareIndex("test")
        refresh();
        // "description": "*:* (_name: query1)"
        assertThat(firstHit.getExplanation().getDetails()[1].getDetails(), arrayWithSize(2));
import org.apache.lucene.util.ArrayUtil;
        script = new Script(ScriptType.INLINE, NAME, "log(doc['index'].value + (factor * _score.intValue()))", params);
                )  
                    assertThat(hits.length, equalTo(searchResponse.getHits().getHits().length));  
        logger.info("max repeat: {}", maxRepeat);  
        int count = 10000;
            .setQuery(
            index("test", "type", "" + i, jsonBuilder().startObject().field("foo", i).endObject());
        script = new Script(ScriptType.INLINE, NAME, "log(doc['index'].value + (factor * _score.longValue()))", params);
        // Test for accessing _score.intValue()  
                    // for tie-breaking we have to resort here since if the score is  
            String preference = randomRealisticUnicodeOfLengthBetween(1, 10); // at least one char!!  
            .setExplain(true)
                )
                    .setPreference(preference)
                .setId("" + i)  
            String id = randomRealisticUnicodeOfCodepointLengthBetween(1, 50);  
 * this file be licensed under the Apache-2.0 license or a
            .get();  
import org.opensearch.plugins.Plugin;  
    public void testSeedAndNameReportedInExplain() throws Exception {
        );
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder[] {  
 */
        createIndex("test");  
                "type=text",  
        int iters = scaledRandomIntBetween(10, 20);  
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {  
        resp = client().prepareSearch("test").setQuery(functionScoreQuery(matchAllQuery(), randomFunction())).get();
        int percentile50 = filled / 2;
            assertNoFailures(searchResponse);
                final int hitCount = searchResponse.getHits().getHits().length;  
import static org.hamcrest.Matchers.containsString;
import org.opensearch.index.mapper.SeqNoFieldMapper;  
    }  
        index("test", "type", "1", jsonBuilder().startObject().endObject());
import java.util.function.Function;
    }
        // Test for accessing _score
        }
        SearchHit firstHit = resp.getHits().getAt(0);  
        logger.info("avg repeat: {}", sumRepeat / (double) filled);
            int innerIters = scaledRandomIntBetween(2, 5);
                        new FunctionScoreQueryBuilder.FilterFunctionBuilder(fieldValueFactorFunction("index").factor(2)),
        @Override
        assertEquals(0, resp.getHits().getTotalHits().value());  
        createIndex("test");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
 * Unless required by applicable law or agreed to in writing,
            .setQuery(functionScoreQuery(matchAllQuery(), randomFunction().seed(1234).setField(SeqNoFieldMapper.NAME)))
        for (int i = 0; i < count; i++) {  
            index("test", "type", "" + i, jsonBuilder().startObject().endObject());
    }  
        script = new Script(ScriptType.INLINE, NAME, "log(doc['index'].value + (factor * _score.doubleValue()))", params);
            .setQuery(  
        int percentile25 = (filled / 4);
                "type=" + randomFrom("short", "float", "long", "integer", "double")
        assertNoFailures(resp);  
        SearchResponse resp = client().prepareSearch("test")
        int maxRepeat = 0;
            percentile25--;
                }
        assertThat(firstHit.getExplanation().getDetails()[0].getDescription().toString(), containsString("_name: " + queryName));  
                    for (int j = 0; j < hitCount; j++) {
                "index",
        ensureGreen();
            for (SearchHit hit : searchResponse.getHits().getHits()) {
        firstHit = resp.getHits().getAt(0);
        flush();  
        firstHit = resp.getHits().getAt(0);  
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder[] {  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .setQuery(  
        assertNoFailures(resp);
                .get();
 * not use this file except in compliance with the License.
                functionScoreQuery(
            int value = matrix[i];
        int docCount = randomIntBetween(100, 200);
 * compatible open source license.
        ensureGreen();  
                        new FunctionScoreQueryBuilder.FilterFunctionBuilder(fieldValueFactorFunction("index").factor(2)),
        SearchResponse resp = client().prepareSearch("test")  
        ensureGreen();  
                } else {
        ensureGreen();
        }
                    )  
                while (numDocsToChange > 0) {  
/*
                    functionScoreQuery(  
            if (value > 0) {
        assertAcked(prepareCreate("test"));  
        }
                functionScoreQuery(
    public static Collection<Object[]> parameters() {  
            percentile75--;  
            Integer factor = (Integer) vars.get("factor");  
                        randomFunction().seed(randomRealisticUnicodeOfLengthBetween(10, 20)).setField(SeqNoFieldMapper.NAME)
        createIndex("test");  
        SearchResponse resp = client().prepareSearch("test")
import org.opensearch.search.SearchHit;
            client().prepareSearch()
            index("test", "type", id, jsonBuilder().startObject().endObject());
            )
    }  
                SearchResponse searchResponse = client().prepareSearch()
        return Arrays.asList(CustomScriptPlugin.class);  
import static org.hamcrest.Matchers.nullValue;  
        indexRandomForConcurrentSearch("test");
            }  
        assertThat(firstHit.getScore(), greaterThan(1f));
                        new FunctionScoreQueryBuilder.FilterFunctionBuilder(fieldValueFactorFunction("index").factor(2)),  
    }  
            );
 * Modifications Copyright OpenSearch Contributors. See  
        ensureGreen(); // make sure we are done otherwise preference could change?
        // Test for accessing _score.doubleValue()  
                    matchQuery("body", "foo"),
                    matchQuery("body", "foo"),
    }
        flush();
 * software distributed under the License is distributed on an
        }
        assertEquals(1, resp.getHits().getTotalHits().value());
                );
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder[] {
                .setQuery(functionScoreQuery(matchAllQuery(), randomFunction()))  
                assertThat(hit.getScore(), allOf(greaterThanOrEqualTo(0.0f), lessThanOrEqualTo(1.0f)));  
 * under the License.  
import org.opensearch.script.Script;  
                    .setQuery(functionScoreQuery(matchAllQuery(), randomFunction().seed(seed).setField("foo")))
                )  
import org.opensearch.script.MockScriptPlugin;
        assertNoFailures(
    public void testScoreRange() throws Exception {  
                }
        for (int i = 0; i < matrix.length; i++) {
            client().prepareSearch()  
            .get();
                preference = randomRealisticUnicodeOfLengthBetween(1, 10);  
                if (i == 0) {
        assertNoFailures(resp);
                .get()
            }  
                )
                .setSource("body", randomFrom(Arrays.asList("foo", "bar", "baz")), "index", i + 1)
                functionScoreQuery(
                        matchAllQuery(),
        logger.info("mean: {}", sum / (double) count);  
        );  
import org.opensearch.index.query.functionscore.RandomScoreFunctionBuilder;
                logger.info("percentile_75: {}", i);
                .get();  
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        assertNoFailures(resp);
        assertAcked(  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Arrays;  
                        assertThat("" + j, currentHits[j].getId(), equalTo(hits[j].getId()));  
import org.hamcrest.CoreMatchers;
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.fieldValueFactorFunction;
            .get();  
                functionScoreQuery(  
            prepareCreate("test").setMapping(
        );  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
        script = new Script(ScriptType.INLINE, NAME, "log(doc['index'].value + (factor * _score.floatValue()))", params);  
        int outerIters = scaledRandomIntBetween(10, 20);  
                assertThat(
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
        );
 *  
    }  
import java.util.HashMap;
 * the Apache License, Version 2.0 (the "License"); you may
        SearchHit firstHit = resp.getHits().getAt(0);  
        flush();  
                )  
import static org.hamcrest.Matchers.greaterThan;  
import java.util.Collection;
                filled++;
                functionScoreQuery(  
            matrix[Integer.valueOf(searchResponse.getHits().getAt(0).getId())]++;  
        refresh();
            for (int i = 0; i < innerIters; i++) {
        final int docCount = randomIntBetween(100, 200);
    public void checkDistribution() throws Exception {  
import static org.hamcrest.Matchers.allOf;
        int seed = 12345678;
 *
        flush();  
                    // identical we rely on collection order which might change.
        indexRandomForConcurrentSearch("test");
            }
        }
                        new FunctionScoreQueryBuilder.FilterFunctionBuilder(fieldValueFactorFunction("index").factor(2)),
        createIndex("test");  
        }
        for (int o = 0; o < outerIters; o++) {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
                    --numDocsToChange;  
                        new FunctionScoreQueryBuilder.FilterFunctionBuilder(scriptFunction(script)) }
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
    public void testConsistentHitsWithSameSeed() throws Exception {
                    matchAllQuery().queryName(queryName),
import static org.opensearch.index.query.QueryBuilders.matchQuery;  
                    }
            )
            if (percentile50 == 0) {  
        assertNoFailures(
        assertThat(firstHit.getScore(), greaterThan(1f));
}
            return scripts;
        firstHit = resp.getHits().getAt(0);
                        new FunctionScoreQueryBuilder.FilterFunctionBuilder(scriptFunction(script)) }
        for (int i = 0; i < docCount; i++) {
                    int doc = randomInt(docCount - 1);// watch out this is inclusive the max values!
            }
            }
            return Math.log(index + (factor * score));
                .setQuery(functionScoreQuery(matchAllQuery(), randomFunction().seed(randomInt()).setField(SeqNoFieldMapper.NAME)))  
    }
    public void testScoreAccessWithinScript() throws Exception {
 * this work for additional information regarding copyright
import static org.hamcrest.Matchers.arrayWithSize;  
        indexRandomForConcurrentSearch("test");  
        assertNoFailures(resp);  
    public void testSeedReportedInExplain() throws Exception {
                .setSize(docCount) // get all docs otherwise we are prone to tie-breaking
import org.opensearch.index.fielddata.ScriptDocValues;
            Double score = scoring.apply((ScoreAccessor) vars.get("_score")).doubleValue();
        // "description": "random score function (seed: 12345678, field: _seq_no, _name: func1)"
        Map<String, Object> params = new HashMap<>();
import org.opensearch.script.ScoreAccessor;
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;
 * ownership. Elasticsearch licenses this file to you under  
                refresh();  
        assertNoFailures(resp);
        }  
        ensureGreen();
            while (preference.startsWith("_")) {
            .get();  
        resp = client().prepareSearch("test")
            .setQuery(
        final String functionName = "func1";  
        flushAndRefresh();  
                    searchResponse.getShardFailures().length,  
        resp = client().prepareSearch("test")
 * GitHub history for details.
        resp = client().prepareSearch("test")  
        int docCount = randomIntBetween(100, 200);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
            percentile50--;
        assertNoFailures(  
            }
                ArrayUtil.timSort(currentHits, (o1, o2) -> {
        params.put("factor", randomIntBetween(2, 4));  
                .get()
                "body",
        }
                // randomly change some docs to get them in different segments
                .setSize(docCount) // get all docs otherwise we are prone to tie-breaking  
                        new FunctionScoreQueryBuilder.FilterFunctionBuilder(fieldValueFactorFunction("index").factor(2)),  
                    int cmp = Float.compare(o1.getScore(), o2.getScore());
        refresh();
        static Double scoringScript(Map<String, Object> vars, Function<ScoreAccessor, Number> scoring) {
                .setSize(docCount)
            )  
    public void testSeeds() throws Exception {
                    assertThat(hits, nullValue());  
                    CoreMatchers.equalTo(0)
            sum += i * matrix[i];
                });
/*
            .get();
        refresh();  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
                        new FunctionScoreQueryBuilder.FilterFunctionBuilder(scriptFunction(script)) }
            scripts.put("log(doc['index'].value + (factor * _score.longValue()))", vars -> scoringScript(vars, ScoreAccessor::longValue));
            } else if (percentile75 == 0) {
        int docCount = randomIntBetween(100, 200);  
                    matchQuery("body", "foo"),
            Map<?, ?> doc = (Map) vars.get("doc");  
 */
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                continue;  
        createIndex("test");
        }
        assertThat(firstHit.getScore(), greaterThan(1f));
        assertEquals(0, resp.getHits().getTotalHits().value());
        super(staticSettings);
        refresh();
        // all random scores should be in range [0.0, 1.0]
            .setExplain(true)
            if (matrix[i] == 0) {
            scripts.put("log(doc['index'].value + (factor * _score.intValue()))", vars -> scoringScript(vars, ScoreAccessor::intValue));
            .setQuery(
        for (int i = 0; i < docCount; i++) {  
        resp = client().prepareSearch("test")
        // Test for accessing _score.floatValue()
    @Override
            final int seed = randomInt();
                        new FunctionScoreQueryBuilder.FilterFunctionBuilder(scriptFunction(script)) }  
                    hits = currentHits;
                    randomFunction(functionName).seed(seed).setField(SeqNoFieldMapper.NAME)
                    .setSize(docCount) // get all docs otherwise we are prone to tie-breaking  
        int sumRepeat = 0;
 */  
 * KIND, either express or implied.  See the License for the
                "log(doc['index'].value + (factor * _score.doubleValue()))",
                .setSize(docCount) // get all docs otherwise we are prone to tie-breaking
        int sum = 0;
                    "Failures " + Arrays.toString(searchResponse.getShardFailures()),
        int percentile75 = percentile50 + percentile25;  
                    return cmp == 0 ? o1.getId().compareTo(o2.getId()) : cmp;  
    public RandomScoreFunctionIT(Settings staticSettings) {
            SearchHit[] hits = null;  
                    .get();  
        int[] matrix = new int[count];
            client().prepareSearch()
                    matchQuery("body", "foo"),  
        );
 *
                functionScoreQuery(  
                vars -> scoringScript(vars, ScoreAccessor::doubleValue)  
        flush();
                        assertThat("" + j, currentHits[j].getScore(), equalTo(hits[j].getScore()));
                        new FunctionScoreQueryBuilder.FilterFunctionBuilder(scriptFunction(script)) }
            scripts.put("log(doc['index'].value + (factor * _score.floatValue()))", vars -> scoringScript(vars, ScoreAccessor::floatValue));  
    }
        firstHit = resp.getHits().getAt(0);
        int filled = 0;  
                flush();
                    matchQuery("body", "foo"),
            } else if (percentile25 == 0) {
import java.util.Map;  
        assertThat(firstHit.getExplanation().getDetails()[1].getDetails()[0].getDescription().toString(), containsString("seed: " + seed));  
 * You may obtain a copy of the License at  
            .get();
            scripts.put(
import org.opensearch.script.ScriptType;
                .get();
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        assertThat(firstHit.getExplanation().toString(), containsString("" + seed));
            .setQuery(
        createIndex("test");
                int numDocsToChange = randomIntBetween(20, 50);
        assertThat(firstHit.getExplanation().getDetails(), arrayWithSize(2));
                .setQuery(functionScoreQuery(matchAllQuery(), new RandomScoreFunctionBuilder()))  
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.scriptFunction;  
        for (int i = 0; i < matrix.length; i++) {  
/*  
        int seed = 12345678;  
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder[] {
            SearchResponse searchResponse = client().prepareSearch()
            )  
    public void testNoDocs() throws Exception {  
                .get()
            )
        assertEquals(1, resp.getHits().getTotalHits().value());
            scripts.put("log(doc['index'].value + (factor * _score))", vars -> scoringScript(vars, ScoreAccessor::doubleValue));  
            .get();
    public static class CustomScriptPlugin extends MockScriptPlugin {  
                .setQuery(functionScoreQuery(matchAllQuery(), randomFunction().seed(randomLong()).setField(SeqNoFieldMapper.NAME)))
        logger.info("distribution: {}", filled / (double) count);
        assertNoFailures(resp);
        final String queryName = "query1";
                .setQuery(
                    index("test", "type", "" + doc, jsonBuilder().startObject().field("foo", doc).endObject());
            )
 * The OpenSearch Contributors require contributions made to  
        for (int i = 0; i < count; i++) {  
        assertNoFailures(resp);
        assertThat(firstHit.getScore(), greaterThan(1f));
            maxRepeat = Math.max(maxRepeat, value);  
            // randomPreference should not start with '_' (reserved for known preference types (e.g. _shards, _primary)
 * specific language governing permissions and limitations
            index("test", "type", "" + i, jsonBuilder().startObject().endObject());
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
        for (int i = 0; i < iters; ++i) {
        refresh();
        assertNoFailures(resp);
        for (int i = 0; i < docCount; i++) {
        indexRandomForConcurrentSearch("test");
                )
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.common.settings.Settings;
                // we add 1 to the index field to make sure that the scripts below never compute log(0)
        // Test for accessing _score.longValue()
        assertThat(firstHit.getScore(), greaterThan(1f));  
            .get();  
            SearchResponse searchResponse = client().prepareSearch()
    }
        ensureGreen();
public class RandomScoreFunctionIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        indexRandomForConcurrentSearch("test");
