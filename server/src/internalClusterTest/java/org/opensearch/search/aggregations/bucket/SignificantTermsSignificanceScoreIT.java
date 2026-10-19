        AggregationBuilder agg = significantTerms("significant_terms").field(TEXT_FIELD)
            request = client().prepareSearch("test")
import org.opensearch.search.aggregations.bucket.terms.heuristic.MutualInformation;
            r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(significantText("foo", "s")).get();
    static final String INDEX_NAME = "testidx";
        }
    @ParametersFactory
                .getTotal()  
        return Arrays.asList(  
        // Test that a request using a deterministic script gets cached
                .addAggregation(terms("class").field(CLASS_FIELD).subAggregation(significantTerms("sig_terms").field(TEXT_FIELD)));
                .setRequestCache(true)
            + "]"
                .prepareStats("cache_test_idx")  
                                .significanceHeuristic(scriptHeuristic)
                        significantTerms("sig_terms").field(TEXT_FIELD)
        String textMappings = "type=" + type;
 * not use this file except in compliance with the License.
        testScoresEqualForPositiveAndNegative(new ChiSquare(true, true));  
                .getRequestCache()
                        )
import java.util.ArrayList;
        } else {
                                .minDocCount(1)
                                .size(2)
            assertThat(terms.getBuckets().size(), equalTo(2));  
                    filter("0", QueryBuilders.termQuery(CLASS_FIELD, "0")).subAggregation(  
                            significantTerms("sig_terms").field(TEXT_FIELD)  
     * Ensure requests using nondeterministic scripts do not get cached.  
                .get();
     * Make sure that a request using a deterministic script or not using a script get cached.
    }  
        // bg_count for significant term agg is summed up across shards, so in this test we compare a 1 shard and 2 shard search request  
            return scripts;
            r = client().prepareSearch("cache_test_idx")  
        List<? extends SignificantTerms.Bucket> classA = sigTerms.getBuckets();
            + "\"doc_count\":4,"
        } else {
                        )
                .get()  
        );  
        assertAcked(
        }
    public void testReduceFromSeveralShards() throws IOException, ExecutionException, InterruptedException {  
    public static class TestScriptPlugin extends MockScriptPlugin implements SearchPlugin {  
            + "\"bg_count\":4"
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.script.Script;
                .addAggregation(  
            + "\"score\":0.75,"  
        assertSearchResponse(response);  
        String type = randomBoolean() ? "text" : "long";
        // valid.
import org.opensearch.action.search.SearchRequestBuilder;
    public void testBackgroundVsSeparateSet() throws Exception {
                    params.get("_superset_freq")
        );  
            + "\"doc_count\":3,"
                .get()
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        for (int i = 0; i < data.length; i++) {
                .prepareStats("cache_test_idx")
            } else {
 * Unless required by applicable law or agreed to in writing,
    }
            for (SignificantTerms.Bucket bucket : sigTerms.getBuckets()) {
        String type = randomBoolean() ? "text" : "long";  
        double score11SeparateSets = sigTerms1.getBucketByKey("1").getSignificanceScore();
        if (randomBoolean()) {
import org.opensearch.index.query.QueryBuilders;  
        SignificantTerms sigTerms1 = ((SignificantTerms) (classes.getBucketByKey("1").getAggregations().asMap().get("sig_terms")));
        assertSearchResponse(response);  
                .addAggregation(
        assertThat(
    }  
            + "\"doc_count\":3,"
            request = client().prepareSearch(INDEX_NAME)  
     */
            prepareCreate("cache_test_idx").setMapping("d", "type=long")
        String[] cat2v2 = { "constant", "duo" };
        for (Terms.Bucket classBucket : classes.getBuckets()) {  
                ) + longValue(params.get("_superset_size"))) / factor;
        boolean useSigText = randomBoolean();  
                .setRequestCache(true)
                .setRequestCache(true)
            request = client().prepareSearch(INDEX_NAME)  
            + "\"key\":\"0\","  
            // significant_terms on legacy fieldData=true too.
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        SignificantTerms sigTerms = aggregations.get("mySignificantTerms");
                            .significanceHeuristic(significanceHeuristicExpectingSeparateSets)
        if (useSigText) {
        }
            client().admin()  
     * A simple test that adds a sub-aggregation to a significant terms aggregation,  
    private ScriptHeuristic getScriptSignificanceHeuristic() throws IOException {
            "B\td",
import org.opensearch.script.MockScriptPlugin;
    }
                    )  
 * SPDX-License-Identifier: Apache-2.0
                .prepareStats("cache_test_idx")
import org.opensearch.action.index.IndexRequestBuilder;  
        for (SignificantTerms.Bucket bucket : sigTerms) {
        responseBuilder.startObject();
        );
                    filter("1", QueryBuilders.termQuery(CLASS_FIELD, "1")).subAggregation(
                .getRequestCache()
        } else {
                            significantText("mySignificantTerms", "text").significanceHeuristic(heuristic)
    }
        if ("text".equals(type) && randomBoolean()) {  
                .get()
            .shardSize(1000)  
            r = client().prepareSearch("cache_test_idx")
        sigTerms1 = (SignificantTerms) ((InternalFilter) aggs.get("1")).getAggregations().getAsMap().get("sig_terms");
 * The OpenSearch Contributors require contributions made to  
        SharedSignificantTermsTestMethods.aggregateAndCheckFromSeveralShards(this);
                .addAggregation(significantTerms("foo").field("s").significanceHeuristic(scriptHeuristic))
        );
public class SignificantTermsSignificanceScoreIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
        }  
import java.util.Map;
        String settings = "{\"index.number_of_shards\": 1, \"index.number_of_replicas\": 0}";  
 */
        // We use a custom routing strategy here to ensure that each shard will have at least 1 bucket.
import static org.opensearch.search.aggregations.AggregationBuilders.significantText;
        assertSearchResponse(response);
            assertThat(classABucket.getKey(), equalTo(classBBucket.getKey()));  
        }  
        } else {
                .addAggregation(
    // compute significance score by
                        )  
                        .subAggregation(  
            request2 = client().prepareSearch(INDEX_NAME)
                .get();
                    terms("class").field(CLASS_FIELD)
        SearchRequestBuilder request;
        assertThat(classes.getBuckets().size(), equalTo(2));
 * specific language governing permissions and limitations
        indexEqualTestData();
            new Script(ScriptType.INLINE, "mockscript", "Math.random()", Collections.emptyMap())
                .addAggregation(  
                .getTotal()
            response2.getAggregations().asMap().get("sig_terms").toString()
            script = new Script(ScriptType.INLINE, "mockscript", "script_with_params", params);  
        SearchRequestBuilder request;  
        }
import org.opensearch.index.query.TermQueryBuilder;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
                .getRequestCache()
    static final String TEXT_FIELD = "text";  
            + "\"doc_count\":4,"  
 *
            SignificantTerms.Bucket classBBucket = classBBucketIterator.next();
    }
    }
        for (int i = 0; i < 50; i++) {
                .getTotal()
            + "\"key\":"  
        assertThat(score00Background, equalTo(score00SeparateSets));  
    }  
import org.opensearch.plugins.Plugin;
                    terms("class").field(CLASS_FIELD).subAggregation(significantTerms("sig_terms").field(TEXT_FIELD).minDocCount(1))
        XContentBuilder responseBuilder = XContentFactory.jsonBuilder();
import org.opensearch.search.aggregations.bucket.filter.InternalFilter;
                .getHitCount(),
 * KIND, either express or implied.  See the License for the
            + "\"sig_terms\":{"
            if (randNum == 2) {  
                "script_no_params",
        );  
                double factor = ((Number) params.get("param")).doubleValue();
    // both should yield exact same result
        }
                .setSize(0)
import static org.hamcrest.Matchers.equalTo;
            "B\td",  
        SharedSignificantTermsTestMethods.index01Docs(type, settings, this);  
            client().admin()
                .get()  
                .indices()  
import java.util.HashMap;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import java.util.concurrent.ExecutionException;  
            + "\"bg_count\":7,"
            "A\ta",
import org.opensearch.test.search.aggregations.bucket.SharedSignificantTermsTestMethods;
            prepareCreate(INDEX_NAME).setSettings(settings, MediaTypeRegistry.JSON)
            + "\"buckets\":["
            assertThat(classABucket.getSignificanceScore(), closeTo(classBBucket.getSignificanceScore(), 1.e-5));
                .getHitCount(),
            + "\"key\":"
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.index.query.QueryBuilder;
            equalTo(0L)
            client().admin()
    public SignificantTermsSignificanceScoreIT(Settings staticSettings) {  
            params.put("param", randomIntBetween(1, 100));
        String type = randomBoolean() ? "text" : "long";
                .get();  
                            significantTerms("mySignificantTerms").field(TEXT_FIELD)  
        }
            StringTerms terms = bucket.getAggregations().get("class");
        public Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
    }
            + "{"  
        indexRequestBuilderList.add(client().prepareIndex(INDEX_NAME).setId("2").setSource(TEXT_FIELD, cat1v2, CLASS_FIELD, "1"));
        }  
                                .shardSize(2)  
                .get()
            );  
        testBackgroundVsSeparateSet(new ChiSquare(true, true), new ChiSquare(true, false), type);  
            prepareCreate("test").setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))  
    public void testBackgroundVsSeparateSet(
        assertAcked(
import java.util.Collection;  
    @Override  
import java.util.function.Function;
        }  
        SharedSignificantTermsTestMethods.index01Docs(type, settings, this);  
                .indices()
        super(staticSettings);
 * this work for additional information regarding copyright
            }  
                .get()
            equalTo(0L)  
                .getTotal()  
    public void testPopularTermManyDeletedDocs() throws Exception {
        if (useSigText) {
            indexRequestBuilderList.add(client().prepareIndex(INDEX_NAME).setId("1").setSource(TEXT_FIELD, text, CLASS_FIELD, "1"));  
                .indices()
        final boolean useSigText = randomBoolean() && type.equals("text");
        indexRandom(true, false, indexRequestBuilders);
        double score10Background = sigTerms1.getBucketByKey("0").getSignificanceScore();
            client().admin()  
        assertThat(
        assertThat(
        String[] gb = { "0", "1" };
            "B\tc",  
        if ("text".equals(type) && randomBoolean()) {
                );
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
                .setSize(0)  
                .addAggregation(
                        )  
        if (randomBoolean()) {
            scripts.put(
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        assertThat(responseBuilder.toString(), equalTo(result));  
    public void testScoresEqualForPositiveAndNegative() throws Exception {  
                );  
    }
                .getRequestCache()  
        SearchResponse response1 = request1.get();
        // The purpose of this test is to validate that the aggregation results do not change with shard count.
import static org.hamcrest.Matchers.closeTo;  
                .addAggregation(
        } else {
                );
        SearchResponse r;
import org.opensearch.common.settings.Settings;  
import org.opensearch.plugins.SearchPlugin;  
            + "{"
        assertThat(  
                .addAggregation(significantText("foo", "s").significanceHeuristic(scriptHeuristic))
            true,  
import org.opensearch.search.aggregations.bucket.terms.Terms;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
        // Now create some holes in the index with selective deletes caused by updates.
        String settings = "{\"index.number_of_shards\": 1, \"index.number_of_replicas\": 0}";
                .indices()
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            script = new Script(ScriptType.INLINE, "mockscript", "script_no_params", Collections.emptyMap());
                .indices()
            .executionHint(randomExecutionHint())  
        assertThat(classes.getBuckets().size(), equalTo(2));
                        .subAggregation(
import org.opensearch.search.aggregations.Aggregations;  
                        .subAggregation(
            request = client().prepareSearch("test")  
        indexRandomFrequencies01(type);
        Iterator<SignificantTerms.Bucket> classBBucketIterator = sigTerms.iterator();
            equalTo(0L)
                .prepareStats("cache_test_idx")  
                .prepareStats("cache_test_idx")
                .getHitCount(),  
        );
        Script script;
        assertSearchResponse(r);
        }
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();  
        testScoresEqualForPositiveAndNegative(new MutualInformation(true, true));
                        )  
        request.get();  
        if (type.equals("text")) {  
                            .backgroundFilter(QueryBuilders.termQuery(CLASS_FIELD, "0"))
                            .significanceHeuristic(significanceHeuristicExpectingSeparateSets)  
                );
        SearchResponse response = client().prepareSearch("test").setQuery(query).addAggregation(agg).get();
    }
            SignificantTerms sigTerms = classBucket.getAggregations().get("mySignificantTerms");  
                    terms("class").field(CLASS_FIELD)
        SearchResponse response1 = request.get();  
        assertSearchResponse(r);
                .get()
                client().prepareIndex(INDEX_NAME).setSource(TEXT_FIELD, text, CLASS_FIELD, randomBoolean() ? "one" : "zero")  
                                .size(1000)
        assertSearchResponse(response);
        );
    ) throws Exception {  
            assertTrue(aggs.containsKey("sig_terms"));
 * GitHub history for details.
        assertThat(score10Background, equalTo(score10SeparateSets));
            "B\td",
            + "},"  
        String[] cat1v2 = { "constant", "uno" };  
        } else {  
    /**
        assertThat(  
        settings = "{\"index.number_of_shards\": 2, \"index.number_of_replicas\": 0}";
            .significanceHeuristic(new ChiSquare(true, true))
        String settings = "{\"index.number_of_shards\": 1, \"index.number_of_replicas\": 0}";
import java.util.Iterator;  
                .indices()
        assertSearchResponse(r);
            + "}"
                    bucket.getSignificanceScore(),  
        indexRequestBuilderList.add(client().prepareIndex(INDEX_NAME).setId("1").setSource(TEXT_FIELD, cat1v1, CLASS_FIELD, "1"));
                .addAggregation(
        assertSearchResponse(response1);
 */
            r = client().prepareSearch("cache_test_idx")
        if (useSigText) {
        SearchResponse response = request.get();
            "A\tb",
            scripts.put("script_with_params", params -> {
        createIndex("idx_unmapped");  
        String[] cat1v1 = { "constant", "one" };
        double score11Background = sigTerms1.getBucketByKey("1").getSignificanceScore();  
        if (randomBoolean()) {  
        classes.toXContent(responseBuilder, ToXContent.EMPTY_PARAMS);  
                    terms("class").field("class")
                                .shardSize(1000)
        String result = "{\"class\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,"  
                            significantText("sig_terms", TEXT_FIELD).minDocCount(1)  
        );  
                )
        assertThat(sigTerms0.getBuckets().size(), equalTo(2));
    public void testScriptScore() throws ExecutionException, InterruptedException, IOException {
import org.opensearch.core.xcontent.ToXContent;  
        ScriptHeuristic scriptHeuristic = new ScriptHeuristic(  
                );  
        scriptHeuristic = getScriptSignificanceHeuristic();  
                .prepareStats("cache_test_idx")  
 * software distributed under the License is distributed on an
        }
                .getRequestCache()
        double score10SeparateSets = sigTerms1.getBucketByKey("0").getSignificanceScore();  
    // 2. filter buckets and set the background to the other class and set is_background false  
        assertThat(
     */
        }
        } else {
                .addAggregation(
        assertThat(  
                assertThat(
                .setMapping("text", "type=keyword", CLASS_FIELD, "type=keyword")  
            Map<String, Aggregation> aggs = classBucket.getAggregations().asMap();
                    is((double) bucket.getSubsetDf() + bucket.getSubsetSize() + bucket.getSupersetDf() + bucket.getSupersetSize())
            String term = agg.iterator().next().getKeyAsString();
            String[] text = new String[1];
        double score01SeparateSets = sigTerms0.getBucketByKey("1").getSignificanceScore();  
                                .significanceHeuristic(significanceHeuristicExpectingSuperset)
import org.opensearch.script.ScriptType;  
                    filter("0", QueryBuilders.termQuery(CLASS_FIELD, "0")).subAggregation(
        indexRandom(true, false, indexRequestBuilderList);
import static org.opensearch.search.aggregations.AggregationBuilders.terms;  
                                .size(2)
            request = client().prepareSearch(INDEX_NAME)
            SignificantTerms agg = (SignificantTerms) aggs.get("sig_terms");  
            textMappings += ",fielddata=true";
            "B\tc",
        StringTerms classes = response.getAggregations().get("class");  
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE)
                                .executionHint(randomExecutionHint())
            + (type.equals("long") ? "0," : "\"0\",")
            Map<String, Object> params = new HashMap<>();
        // Ensure that non-scripted requests are cached as normal
    public void testScriptCaching() throws Exception {
            });  
                                .minDocCount(1)  
        );
        SearchRequestBuilder request = client().prepareSearch(INDEX_NAME)
            .minDocCount(1)
            + "{"
        StringTerms classes = response1.getAggregations().get("class");
        SearchRequestBuilder request2;
import static org.hamcrest.Matchers.is;  
            + "\"sig_terms\":{"
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
                .addAggregation(terms("class").field(CLASS_FIELD).subAggregation(significantText("sig_terms", TEXT_FIELD)));
        double score01Background = sigTerms0.getBucketByKey("1").getSignificanceScore();  
                .setRequestCache(true)  
 * the Apache License, Version 2.0 (the "License"); you may
    }
 *
            r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(significantTerms("foo").field("s")).get();  
        if (useSigText) {  
    static final String CLASS_FIELD = "class";
        indexRequestBuilderList.clear();  
            client().admin()
        } else {
                .get();  
        );  
import org.opensearch.search.aggregations.bucket.terms.heuristic.GND;
    private void indexEqualTestData() throws ExecutionException, InterruptedException {
        StringTerms classes = response.getAggregations().get("class");
                .setRequestCache(true)
    public void testXContentResponse() throws Exception {  
        return randomBoolean() ? null : randomFrom(SignificantTermsAggregatorFactory.ExecutionMode.values()).toString();  
            .size(1000)
    }
            assertThat(agg.getBuckets().size(), equalTo(1));
                ) + longValue(params.get("_superset_size"))
            + "\"buckets\":["
                            .significanceHeuristic(significanceHeuristicExpectingSeparateSets)
                params -> longValue(params.get("_subset_freq")) + longValue(params.get("_subset_size")) + longValue(  
            "B\td",
                .getMissCount(),
                .setRequestCache(true)  
        // This is the scenario that caused this issue https://github.com/elastic/elasticsearch/issues/7951
 * under the License.  
            equalTo(0L)  
            int randNum = randomInt(2);
                .getMissCount(),
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
            String classTerm = classBucket.getKeyAsString();  
            .subAggregation(subAgg);
        String type = randomBoolean() ? "text" : "long";
        // Make sure we are starting with a clear cache
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        indexRandom(true, indexRequestBuilderList);  
                            .minDocCount(1)
    }
        }
                .addAggregation(significantTerms("foo").field("s").significanceHeuristic(scriptHeuristic))
/*
        // check that results for both classes are the same with exclude negatives = false and classes are routing ids
        assertAcked(prepareCreate(INDEX_NAME).setMapping(TEXT_FIELD, textMappings, CLASS_FIELD, "type=keyword"));  
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
        // Test that a request using a nondeterministic script does not get cached
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();  
                .getHitCount(),
                                .executionHint(randomExecutionHint())
                                .minDocCount(1)  
            + "\"doc_count\":3,"  
        AggregationBuilder subAgg = terms("class").field(CLASS_FIELD);
                );
        }
            indexRequestBuilders.add(client().prepareIndex("test").setId("" + i).setSource("class", parts[0], "text", parts[1]));  
            "B\tc",
                    terms("class").field(CLASS_FIELD)
                .get()
                                .size(1000)
 * license agreements. See the NOTICE file distributed with
            request1 = client().prepareSearch(INDEX_NAME)
                .getMissCount(),
        indexRequestBuilderList.add(client().prepareIndex(INDEX_NAME).setId("3").setSource(TEXT_FIELD, cat2v1, CLASS_FIELD, "2"));  
        ensureGreen();
            .addAggregation((significantTerms("sig_terms").field(TEXT_FIELD)));
            "A\ta",
        SharedSignificantTermsTestMethods.index01Docs(type, settings, this);
    public String randomExecutionHint() {
        );
                                .significanceHeuristic(significanceHeuristicExpectingSuperset)
        indexRequestBuilderList.add(client().prepareIndex(INDEX_NAME).setId("4").setSource(TEXT_FIELD, cat2v2, CLASS_FIELD, "2"));
            return ((ScriptHeuristic.LongAccessor) value).longValue();
 * Licensed to Elasticsearch under one or more contributor  
 */  
            equalTo(2L)  
        List<IndexRequestBuilder> indexRequestBuilderList = new ArrayList<>();  
                text = gb;
        SearchResponse response2 = request2.get();
        double score00SeparateSets = sigTerms0.getBucketByKey("0").getSignificanceScore();
                .getTotal()  
        Aggregations aggregations = classBuckets.next().getAggregations();
            + "\"buckets\":["
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            }
            client().admin()  
                    params.get("_superset_freq")
import org.opensearch.search.aggregations.bucket.terms.SignificantTermsAggregatorFactory;  
            indexRequestBuilderList.add(
        }
        assertAcked(  
        // If there are no buckets collected for a shard, then that will affect the scoring and bg_count and our assertion will not be  
            text = text == cat1v2 ? cat1v1 : cat1v2;
        protected Map<String, Function<Map<String, Object>, Object>> nonDeterministicPluginScripts() {
            request2 = client().prepareSearch(INDEX_NAME)  
                                .minDocCount(1)
 * Modifications Copyright OpenSearch Contributors. See  
        // from which they are taken so need to make sure this doesn't happen.
        );
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
            equalTo(0L)
            + "\"doc_count\":4,"  
import org.opensearch.search.aggregations.bucket.terms.heuristic.ScriptHeuristic;  
        assertThat(classA.size(), greaterThan(0));  
    }
        for (int i = 0; i < randomInt(20); i++) {  
            client().admin()
import org.opensearch.action.search.SearchResponse;
        if (useSigText) {
    }
            "A\tb",
                        .subAggregation(
        SharedSignificantTermsTestMethods.index01DocsWithRouting(type, settings, this);
                .addAggregation(  
                                .shardSize(2)
        testBackgroundVsSeparateSet(new MutualInformation(true, true), new MutualInformation(true, false), type);
        return new ScriptHeuristic(script);
                            significantText("mySignificantTerms", TEXT_FIELD).significanceHeuristic(scriptHeuristic)
                text[0] = gb[randNum];  
                .getTotal()
        SearchResponse response = request.get();  
                );  
                )  
        String data[] = {  
        indexEqualTestData();
        testBackgroundVsSeparateSet(new GND(true), new GND(false), type);
                            .backgroundFilter(QueryBuilders.termQuery(CLASS_FIELD, "0"))
        SearchRequestBuilder request;
            return scripts;
                                .significanceHeuristic(heuristic)
        assertThat(score11Background, equalTo(score11SeparateSets));  
/*  
            client().admin()
                        .subAggregation(
                .addAggregation(significantText("foo", "s").significanceHeuristic(scriptHeuristic))
            "B\tc",  
    public void testScoresEqualForPositiveAndNegative(SignificanceHeuristic heuristic) throws Exception {  
        String type
                .getMissCount(),
            + "}]}}]}}";
                        .subAggregation(  
            r = client().prepareSearch("cache_test_idx")  
        String[] text = cat1v1;
        for (Terms.Bucket classBucket : ((Terms) response.getAggregations().get("class")).getBuckets()) {
                .prepareStats("cache_test_idx")
    public static Collection<Object[]> parameters() {
            + "}"  
        useSigText = randomBoolean();
import java.io.IOException;  
import java.util.Collections;
        }
        String settings = "{\"index.number_of_shards\": 1, \"index.number_of_replicas\": 0}";  
        SearchResponse response = request.get();
            "A\tb",  
                    )
                .addAggregation(terms("class").field(CLASS_FIELD).subAggregation(significantText("sig_terms", TEXT_FIELD).minDocCount(1)));  
        private static long longValue(Object value) {
                        significantTerms("sig_terms").field(TEXT_FIELD)  
        assertThat(sigTerms.getBuckets().size(), equalTo(2));
            "B\td",
import java.util.List;
            assertTrue(term.equals(classTerm));
import org.opensearch.search.aggregations.AggregationBuilder;
            );
        double score00Background = sigTerms0.getBucketByKey("0").getSignificanceScore();
        }
    // 1. terms agg on class and significant terms
import org.opensearch.search.aggregations.bucket.terms.heuristic.ChiSquare;  
        SignificantTerms sigTerms0 = ((SignificantTerms) (classes.getBucketByKey("0").getAggregations().asMap().get("sig_terms")));  
                .prepareStats("cache_test_idx")  
    private void indexRandomFrequencies01(String type) throws ExecutionException, InterruptedException {
import org.opensearch.common.xcontent.XContentFactory;
    }
            response1.getAggregations().asMap().get("sig_terms").toString(),  
                .get()
        }  
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),
                .setRequestCache(true)  
import org.opensearch.core.xcontent.XContentBuilder;
                    )
        );
        // Scoring algorithms throw exceptions if term docFreqs exceed the reported size of the index  
 * You may obtain a copy of the License at  
}  
                );  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
package org.opensearch.search.aggregations.bucket;
            "B\ta b" };
                        significantText("sig_terms", TEXT_FIELD).minDocCount(1)  
    public void testSubAggregations() throws Exception {  
        responseBuilder.endObject();
        @Override
import static org.hamcrest.Matchers.greaterThan;
                .setRequestCache(true)
            "A\tc d",  
            + "\"bg_count\":5"
        SearchRequestBuilder request1;  
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)
import static org.opensearch.search.aggregations.AggregationBuilders.significantTerms;
    }
                .setSize(0)  
                .indices()
        );
        @Override
        sigTerms0 = (SignificantTerms) ((InternalFilter) aggs.get("0")).getAggregations().getAsMap().get("sig_terms");
            .setQuery(new TermQueryBuilder(CLASS_FIELD, "0"))  
        indexRandom(true, false, indexRequestBuilderList);
        assertSearchResponse(response);
            // Use significant_text on text fields but occasionally run with alternative of
        Aggregations aggs = response2.getAggregations();
                .addAggregation(
                .addAggregation(  
    }  
                    terms("class").field("class")
                return factor * (longValue(params.get("_subset_freq")) + longValue(params.get("_subset_size")) + longValue(  
            + "\"key\":\"1\","
                .getRequestCache()
            + "\"score\":0.39999999999999997,"
                .setMapping("text", "type=text,fielddata=true", "class", "type=keyword")
        } else {
            request = client().prepareSearch(INDEX_NAME)  
import static org.opensearch.search.aggregations.AggregationBuilders.filter;  
            request = client().prepareSearch(INDEX_NAME)  
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest("*")).get());
 * this file be licensed under the Apache-2.0 license or a
                .getTotal()
        String[] cat2v1 = { "constant", "two" };
/*
            request1 = client().prepareSearch(INDEX_NAME)
        QueryBuilder query = QueryBuilders.termsQuery(TEXT_FIELD, "a", "b");  
            String[] parts = data[i].split("\t");
        }
            + "\"bg_count\":7,"  
                            .significanceHeuristic(significanceHeuristicExpectingSeparateSets)  
 * compatible open source license.
                        significantText("sig_terms", TEXT_FIELD).minDocCount(1)
        indexRandom(
import java.util.Arrays;
            scripts.put("Math.random()", vars -> SignificantTermsSignificanceScoreIT.randomDouble());
 *  
        for (SignificantTerms.Bucket classABucket : classA) {
                    )
                    filter("1", QueryBuilders.termQuery(CLASS_FIELD, "1")).subAggregation(  
                .getTotal()  
            equalTo(1L)
                    terms("class").field(CLASS_FIELD)
                            significantTerms("mySignificantTerms").field("text")  
                );
    /**
                            .minDocCount(1)
        assertThat(score01Background, equalTo(score01SeparateSets));
    public void testConsistencyWithDifferentShardCounts() throws Exception {
                        )
        SignificantTerms sigTerms = response.getAggregations().get("significant_terms");
                                .minDocCount(1)
            + (type.equals("long") ? "1," : "\"1\",")
                                .shardSize(1000)  
                            .backgroundFilter(QueryBuilders.termQuery(CLASS_FIELD, "1"))
                .setSize(0)
        ScriptHeuristic scriptHeuristic = getScriptSignificanceHeuristic();
import org.opensearch.test.OpenSearchIntegTestCase;
        );
            request = client().prepareSearch(INDEX_NAME)
            equalTo(0L)  
                .getRequestCache()  
import org.opensearch.search.aggregations.bucket.terms.SignificantTerms;
                .getRequestCache()  
        SignificanceHeuristic significanceHeuristicExpectingSuperset,  
        assertEquals(
            + "{"
                .indices()
        SignificanceHeuristic significanceHeuristicExpectingSeparateSets,
        Iterator<? extends Terms.Bucket> classBuckets = classes.getBuckets().iterator();
import org.opensearch.search.aggregations.Aggregation;
        } else {
     * to help check that sub-aggregation collection is handled correctly.
        SearchResponse response2 = request.get();  
                );
        List<IndexRequestBuilder> indexRequestBuilderList = new ArrayList<>();
                            .backgroundFilter(QueryBuilders.termQuery(CLASS_FIELD, "1"))  
        assertThat(  
        return Arrays.asList(TestScriptPlugin.class);
        SearchRequestBuilder request;
