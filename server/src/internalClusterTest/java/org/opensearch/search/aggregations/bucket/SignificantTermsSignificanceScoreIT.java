        SearchResponse r;
     * Make sure that a request using a deterministic script or not using a script get cached.
        } else {
import org.opensearch.index.query.QueryBuilder;
                    )
        assertThat(
        String type = randomBoolean() ? "text" : "long";
                .addAggregation(
import org.opensearch.search.aggregations.AggregationBuilder;
                .setMapping("text", "type=keyword", CLASS_FIELD, "type=keyword")
            + "{"
import org.opensearch.search.aggregations.Aggregation;
            client().admin()
            + "\"score\":0.75,"
                )
                );
            "A\ta",
        );
    public void testReduceFromSeveralShards() throws IOException, ExecutionException, InterruptedException {
        SearchRequestBuilder request;
 * Modifications Copyright OpenSearch Contributors. See
            SignificantTerms.Bucket classBBucket = classBBucketIterator.next();
                .setSize(0)
        SearchResponse response = request.get();
        }
        SearchRequestBuilder request1;
        ensureGreen();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            "B\ta b" };
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),
            for (SignificantTerms.Bucket bucket : sigTerms.getBuckets()) {
            .subAggregation(subAgg);
        SharedSignificantTermsTestMethods.index01Docs(type, settings, this);
        assertSearchResponse(response);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        useSigText = randomBoolean();
                    filter("0", QueryBuilders.termQuery(CLASS_FIELD, "0")).subAggregation(
        );
        double score01Background = sigTerms0.getBucketByKey("1").getSignificanceScore();
        // Make sure we are starting with a clear cache
 *
            client().admin()
                            .minDocCount(1)
            }
        }
    }
                .setRequestCache(true)
        // The purpose of this test is to validate that the aggregation results do not change with shard count.
        indexEqualTestData();
            + "}"
        );
            + "\"bg_count\":7,"
    }
                .setRequestCache(true)
import org.opensearch.search.aggregations.bucket.terms.heuristic.ChiSquare;
    }
                            .backgroundFilter(QueryBuilders.termQuery(CLASS_FIELD, "0"))
        @Override
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            r = client().prepareSearch("cache_test_idx")
            response2.getAggregations().asMap().get("sig_terms").toString()
 */
                        .subAggregation(
                .indices()
        }
            "A\tb",
import static org.hamcrest.Matchers.closeTo;
                    is((double) bucket.getSubsetDf() + bucket.getSubsetSize() + bucket.getSupersetDf() + bucket.getSupersetSize())
    /**
            .addAggregation((significantTerms("sig_terms").field(TEXT_FIELD)));
 * GitHub history for details.
                            .backgroundFilter(QueryBuilders.termQuery(CLASS_FIELD, "1"))
                                .shardSize(1000)
                .indices()
            indexRequestBuilders.add(client().prepareIndex("test").setId("" + i).setSource("class", parts[0], "text", parts[1]));
        for (Terms.Bucket classBucket : classes.getBuckets()) {
                params -> longValue(params.get("_subset_freq")) + longValue(params.get("_subset_size")) + longValue(
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        }
                        )
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.action.search.SearchRequestBuilder;
    public void testScriptScore() throws ExecutionException, InterruptedException, IOException {
        assertThat(score10Background, equalTo(score10SeparateSets));
        SearchResponse response = request.get();
            + "\"doc_count\":4,"
            + (type.equals("long") ? "1," : "\"1\",")
        assertSearchResponse(r);
    /**
        Aggregations aggregations = classBuckets.next().getAggregations();
    }
        if (randomBoolean()) {
        XContentBuilder responseBuilder = XContentFactory.jsonBuilder();
                                .minDocCount(1)
            client().admin()
                .get();
                                .minDocCount(1)
        indexRequestBuilderList.add(client().prepareIndex(INDEX_NAME).setId("4").setSource(TEXT_FIELD, cat2v2, CLASS_FIELD, "2"));
        @Override
        String[] text = cat1v1;
                .get()
    public SignificantTermsSignificanceScoreIT(Settings staticSettings) {
        Script script;
            + "\"bg_count\":4"
        SearchRequestBuilder request;
        if (useSigText) {
    static final String CLASS_FIELD = "class";
        SignificanceHeuristic significanceHeuristicExpectingSuperset,
        );
            textMappings += ",fielddata=true";
        } else {
        double score01SeparateSets = sigTerms0.getBucketByKey("1").getSignificanceScore();
        AggregationBuilder agg = significantTerms("significant_terms").field(TEXT_FIELD)
            + "]"
            client().admin()
import org.opensearch.search.aggregations.bucket.terms.SignificantTermsAggregatorFactory;
                    terms("class").field("class")
            "A\tb",
                double factor = ((Number) params.get("param")).doubleValue();
        String[] cat1v1 = { "constant", "one" };
        );
import java.util.function.Function;
        scriptHeuristic = getScriptSignificanceHeuristic();
        }
import org.opensearch.index.query.QueryBuilders;
import org.opensearch.script.ScriptType;
        } else {
            r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(significantTerms("foo").field("s")).get();
            assertTrue(term.equals(classTerm));
    // both should yield exact same result
            "B\td",
        );
                .prepareStats("cache_test_idx")
        indexRandom(true, false, indexRequestBuilderList);
        assertThat(responseBuilder.toString(), equalTo(result));
            }
        final boolean useSigText = randomBoolean() && type.equals("text");
        SearchResponse response1 = request1.get();
        );
 * KIND, either express or implied.  See the License for the
    }
                .getTotal()
                .get()
                                .size(1000)
        String[] gb = { "0", "1" };
            client().admin()
 * this file be licensed under the Apache-2.0 license or a
        String type
            StringTerms terms = bucket.getAggregations().get("class");
            equalTo(0L)
                .getTotal()
                "script_no_params",
        indexRequestBuilderList.clear();
                                .size(2)
            .executionHint(randomExecutionHint())
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)
                .indices()
        indexRandom(true, false, indexRequestBuilderList);
                .get();
            .setQuery(new TermQueryBuilder(CLASS_FIELD, "0"))
                    filter("0", QueryBuilders.termQuery(CLASS_FIELD, "0")).subAggregation(
            );
            prepareCreate("cache_test_idx").setMapping("d", "type=long")
    public void testXContentResponse() throws Exception {
        SearchRequestBuilder request;
                                .significanceHeuristic(scriptHeuristic)
        settings = "{\"index.number_of_shards\": 2, \"index.number_of_replicas\": 0}";
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest("*")).get());
                assertThat(
                text = gb;
        return Arrays.asList(
                .get()
        String[] cat2v1 = { "constant", "two" };
        assertThat(
            + "\"key\":"
            scripts.put("script_with_params", params -> {
                                .executionHint(randomExecutionHint())
        SignificantTerms sigTerms = response.getAggregations().get("significant_terms");
    public void testScriptCaching() throws Exception {
                .get();
                .indices()
                                .significanceHeuristic(heuristic)
                    terms("class").field(CLASS_FIELD).subAggregation(significantTerms("sig_terms").field(TEXT_FIELD).minDocCount(1))
            script = new Script(ScriptType.INLINE, "mockscript", "script_with_params", params);
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
                .addAggregation(
            + "\"doc_count\":3,"
                .getRequestCache()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // valid.
        if (useSigText) {
            String[] text = new String[1];
        private static long longValue(Object value) {
        }
        if (useSigText) {
import java.util.Collection;
        assertThat(score00Background, equalTo(score00SeparateSets));
            request = client().prepareSearch(INDEX_NAME)
                .prepareStats("cache_test_idx")
            return scripts;
                .getHitCount(),
            "B\td",
package org.opensearch.search.aggregations.bucket;
                .getRequestCache()
            request = client().prepareSearch("test")
    static final String TEXT_FIELD = "text";
import static org.opensearch.search.aggregations.AggregationBuilders.significantText;
                );
                                .minDocCount(1)
        assertSearchResponse(response);
        super(staticSettings);
        classes.toXContent(responseBuilder, ToXContent.EMPTY_PARAMS);
        }
    }
import org.opensearch.search.aggregations.bucket.filter.InternalFilter;
     * Ensure requests using nondeterministic scripts do not get cached.
 * compatible open source license.
 * software distributed under the License is distributed on an
        indexRequestBuilderList.add(client().prepareIndex(INDEX_NAME).setId("2").setSource(TEXT_FIELD, cat1v2, CLASS_FIELD, "1"));
public class SignificantTermsSignificanceScoreIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                                .significanceHeuristic(significanceHeuristicExpectingSuperset)
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
import org.opensearch.script.MockScriptPlugin;
            + "}"
        }
    static final String INDEX_NAME = "testidx";
        }
                );
        for (int i = 0; i < data.length; i++) {
            + (type.equals("long") ? "0," : "\"0\",")
                                .shardSize(2)
        SharedSignificantTermsTestMethods.index01Docs(type, settings, this);
                .addAggregation(significantText("foo", "s").significanceHeuristic(scriptHeuristic))
            assertThat(classABucket.getSignificanceScore(), closeTo(classBBucket.getSignificanceScore(), 1.e-5));
                    params.get("_superset_freq")
     * to help check that sub-aggregation collection is handled correctly.
                            significantText("mySignificantTerms", TEXT_FIELD).significanceHeuristic(scriptHeuristic)
            + "}]}}]}}";
    private void indexRandomFrequencies01(String type) throws ExecutionException, InterruptedException {
        // from which they are taken so need to make sure this doesn't happen.
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                );
                    )
    private void indexEqualTestData() throws ExecutionException, InterruptedException {
import org.opensearch.core.xcontent.MediaTypeRegistry;
                );
        List<IndexRequestBuilder> indexRequestBuilderList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
        List<? extends SignificantTerms.Bucket> classA = sigTerms.getBuckets();
                );
        request.get();
 *
                    filter("1", QueryBuilders.termQuery(CLASS_FIELD, "1")).subAggregation(
                    terms("class").field(CLASS_FIELD)
                    terms("class").field(CLASS_FIELD)
                .getRequestCache()
        StringTerms classes = response.getAggregations().get("class");
        assertThat(
            assertTrue(aggs.containsKey("sig_terms"));
            scripts.put(
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            request = client().prepareSearch(INDEX_NAME)
            "B\tc",
import org.opensearch.search.aggregations.bucket.terms.Terms;
            assertThat(terms.getBuckets().size(), equalTo(2));
 * this work for additional information regarding copyright
        assertSearchResponse(response);
import java.util.List;
 * under the License.
            + "\"doc_count\":3,"
        assertSearchResponse(response1);
                .prepareStats("cache_test_idx")
        // Now create some holes in the index with selective deletes caused by updates.
                return factor * (longValue(params.get("_subset_freq")) + longValue(params.get("_subset_size")) + longValue(
        }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        indexRandom(
                            .significanceHeuristic(significanceHeuristicExpectingSeparateSets)
            request1 = client().prepareSearch(INDEX_NAME)
        sigTerms1 = (SignificantTerms) ((InternalFilter) aggs.get("1")).getAggregations().getAsMap().get("sig_terms");
            true,
                .get()
        if ("text".equals(type) && randomBoolean()) {
    public static Collection<Object[]> parameters() {
        assertThat(score01Background, equalTo(score01SeparateSets));
        );
                .indices()
                );
        return new ScriptHeuristic(script);
                .get()
                .getRequestCache()
            + "\"bg_count\":5"
                        significantText("sig_terms", TEXT_FIELD).minDocCount(1)
        );
                );
                .prepareStats("cache_test_idx")
        String settings = "{\"index.number_of_shards\": 1, \"index.number_of_replicas\": 0}";
        boolean useSigText = randomBoolean();
        // This is the scenario that caused this issue https://github.com/elastic/elasticsearch/issues/7951
    public void testConsistencyWithDifferentShardCounts() throws Exception {
        SignificantTerms sigTerms1 = ((SignificantTerms) (classes.getBucketByKey("1").getAggregations().asMap().get("sig_terms")));
        assertThat(classes.getBuckets().size(), equalTo(2));
                                .size(2)
import org.opensearch.action.index.IndexRequestBuilder;
            indexRequestBuilderList.add(
        }
        indexRandom(true, indexRequestBuilderList);
import java.util.ArrayList;
            + "\"doc_count\":4,"
                                .minDocCount(1)
                            .significanceHeuristic(significanceHeuristicExpectingSeparateSets)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
                .getTotal()
            + "{"
        responseBuilder.endObject();
        }
                .get()
                .getHitCount(),
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
        StringTerms classes = response1.getAggregations().get("class");
        assertThat(score11Background, equalTo(score11SeparateSets));
    public void testBackgroundVsSeparateSet() throws Exception {
    }
            } else {
            .minDocCount(1)
            });
                    params.get("_superset_freq")
            + "\"sig_terms\":{"
        } else {
                .getTotal()
            SignificantTerms agg = (SignificantTerms) aggs.get("sig_terms");
        if (useSigText) {
        testScoresEqualForPositiveAndNegative(new ChiSquare(true, true));
 */
import org.opensearch.plugins.SearchPlugin;
                ) + longValue(params.get("_superset_size"))
        assertThat(classA.size(), greaterThan(0));
            prepareCreate(INDEX_NAME).setSettings(settings, MediaTypeRegistry.JSON)
            int randNum = randomInt(2);
                )
                            significantTerms("sig_terms").field(TEXT_FIELD)
}
        assertSearchResponse(response);
    private ScriptHeuristic getScriptSignificanceHeuristic() throws IOException {
            + "\"buckets\":["
    public void testPopularTermManyDeletedDocs() throws Exception {
        SearchResponse response = client().prepareSearch("test").setQuery(query).addAggregation(agg).get();
            request = client().prepareSearch(INDEX_NAME)
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.Matchers.is;
            .significanceHeuristic(new ChiSquare(true, true))
                .addAggregation(significantText("foo", "s").significanceHeuristic(scriptHeuristic))
                .getMissCount(),
            equalTo(0L)
                .getMissCount(),
                            significantTerms("mySignificantTerms").field("text")
            client().admin()
        SignificantTerms sigTerms = aggregations.get("mySignificantTerms");
        ScriptHeuristic scriptHeuristic = getScriptSignificanceHeuristic();
        // If there are no buckets collected for a shard, then that will affect the scoring and bg_count and our assertion will not be
            if (randNum == 2) {
        for (int i = 0; i < randomInt(20); i++) {
            Map<String, Object> params = new HashMap<>();
                        )
        double score11Background = sigTerms1.getBucketByKey("1").getSignificanceScore();
        Iterator<? extends Terms.Bucket> classBuckets = classes.getBuckets().iterator();
        indexRandomFrequencies01(type);
        SearchRequestBuilder request = client().prepareSearch(INDEX_NAME)
import org.opensearch.core.xcontent.ToXContent;
    public void testScoresEqualForPositiveAndNegative(SignificanceHeuristic heuristic) throws Exception {
                .setRequestCache(true)
                );
import org.opensearch.plugins.Plugin;
        double score00SeparateSets = sigTerms0.getBucketByKey("0").getSignificanceScore();
                .getRequestCache()
            "B\tc",
        for (Terms.Bucket classBucket : ((Terms) response.getAggregations().get("class")).getBuckets()) {
                            .significanceHeuristic(significanceHeuristicExpectingSeparateSets)
            // significant_terms on legacy fieldData=true too.
            "B\td",
        );
            request = client().prepareSearch("test")
    public void testSubAggregations() throws Exception {
                    terms("class").field(CLASS_FIELD)
        Aggregations aggs = response2.getAggregations();
                            .backgroundFilter(QueryBuilders.termQuery(CLASS_FIELD, "0"))
        assertAcked(
import org.opensearch.script.Script;
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        assertEquals(
                .prepareStats("cache_test_idx")
                        .subAggregation(
        assertAcked(
 * the Apache License, Version 2.0 (the "License"); you may
                .getRequestCache()
        double score00Background = sigTerms0.getBucketByKey("0").getSignificanceScore();
                .addAggregation(
    // compute significance score by
            r = client().prepareSearch("cache_test_idx")
            prepareCreate("test").setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))
        SearchResponse response1 = request.get();
            request = client().prepareSearch(INDEX_NAME)
                            significantTerms("mySignificantTerms").field(TEXT_FIELD)
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE)
            "B\tc",
            String classTerm = classBucket.getKeyAsString();
        );
                .setRequestCache(true)
/*
 * not use this file except in compliance with the License.
            indexRequestBuilderList.add(client().prepareIndex(INDEX_NAME).setId("1").setSource(TEXT_FIELD, text, CLASS_FIELD, "1"));
        );
                .getTotal()
                .prepareStats("cache_test_idx")
                                .minDocCount(1)
                        significantTerms("sig_terms").field(TEXT_FIELD)
    public void testBackgroundVsSeparateSet(
                                .significanceHeuristic(significanceHeuristicExpectingSuperset)
        assertThat(
                                .shardSize(2)
            + "\"doc_count\":3,"
            client().admin()
        } else {
                        )
                    bucket.getSignificanceScore(),
                .setRequestCache(true)
            + "\"sig_terms\":{"
        indexRequestBuilderList.add(client().prepareIndex(INDEX_NAME).setId("1").setSource(TEXT_FIELD, cat1v1, CLASS_FIELD, "1"));
        }
        String textMappings = "type=" + type;
                .setMapping("text", "type=text,fielddata=true", "class", "type=keyword")
                        )
                .addAggregation(significantTerms("foo").field("s").significanceHeuristic(scriptHeuristic))
        assertSearchResponse(r);
        }
        String settings = "{\"index.number_of_shards\": 1, \"index.number_of_replicas\": 0}";
        } else {
            text = text == cat1v2 ? cat1v1 : cat1v2;
 * You may obtain a copy of the License at
                .getTotal()
                .getTotal()
import java.util.Arrays;
        double score10SeparateSets = sigTerms1.getBucketByKey("0").getSignificanceScore();
        String type = randomBoolean() ? "text" : "long";
                        .subAggregation(
        String settings = "{\"index.number_of_shards\": 1, \"index.number_of_replicas\": 0}";
        for (SignificantTerms.Bucket classABucket : classA) {
                .addAggregation(
                            .minDocCount(1)
        // Test that a request using a deterministic script gets cached
    }
        assertThat(sigTerms.getBuckets().size(), equalTo(2));
        return randomBoolean() ? null : randomFrom(SignificantTermsAggregatorFactory.ExecutionMode.values()).toString();
                .addAggregation(terms("class").field(CLASS_FIELD).subAggregation(significantText("sig_terms", TEXT_FIELD).minDocCount(1)));
import java.io.IOException;
                .getHitCount(),
import org.opensearch.test.search.aggregations.bucket.SharedSignificantTermsTestMethods;
                .addAggregation(significantTerms("foo").field("s").significanceHeuristic(scriptHeuristic))
        SignificanceHeuristic significanceHeuristicExpectingSeparateSets,
            // Use significant_text on text fields but occasionally run with alternative of
        assertThat(
/*
        assertSearchResponse(response);
            response1.getAggregations().asMap().get("sig_terms").toString(),
            return ((ScriptHeuristic.LongAccessor) value).longValue();
        }
import org.opensearch.search.aggregations.bucket.terms.SignificantTerms;
                .get()
        }
                .addAggregation(
        SearchResponse response = request.get();
            Map<String, Aggregation> aggs = classBucket.getAggregations().asMap();
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.ExecutionException;
        assertThat(classes.getBuckets().size(), equalTo(2));
        List<IndexRequestBuilder> indexRequestBuilderList = new ArrayList<>();
import org.opensearch.test.OpenSearchIntegTestCase;
                            significantText("mySignificantTerms", "text").significanceHeuristic(heuristic)
        assertThat(
        if (useSigText) {
/*
    public void testScoresEqualForPositiveAndNegative() throws Exception {
                .get()
        if ("text".equals(type) && randomBoolean()) {
            assertThat(classABucket.getKey(), equalTo(classBBucket.getKey()));
        SearchRequestBuilder request2;
                        )
        } else {
        if (type.equals("text")) {
                .prepareStats("cache_test_idx")
    }
                .addAggregation(terms("class").field(CLASS_FIELD).subAggregation(significantTerms("sig_terms").field(TEXT_FIELD)));
        // Ensure that non-scripted requests are cached as normal
                .addAggregation(
            + "\"key\":\"0\","
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            request1 = client().prepareSearch(INDEX_NAME)
        QueryBuilder query = QueryBuilders.termsQuery(TEXT_FIELD, "a", "b");
                .setSize(0)
            );
                .setRequestCache(true)
import java.util.Iterator;
                .getRequestCache()
                .setRequestCache(true)
     */
                        .subAggregation(
            + "\"score\":0.39999999999999997,"
            equalTo(0L)
                            significantText("sig_terms", TEXT_FIELD).minDocCount(1)
        // bg_count for significant term agg is summed up across shards, so in this test we compare a 1 shard and 2 shard search request
        }
        );
    @ParametersFactory
            + "\"bg_count\":7,"
                .setSize(0)
        String settings = "{\"index.number_of_shards\": 1, \"index.number_of_replicas\": 0}";
        }
        double score11SeparateSets = sigTerms1.getBucketByKey("1").getSignificanceScore();
                .addAggregation(terms("class").field(CLASS_FIELD).subAggregation(significantText("sig_terms", TEXT_FIELD)));
        AggregationBuilder subAgg = terms("class").field(CLASS_FIELD);
    // 2. filter buckets and set the background to the other class and set is_background false
            + "\"key\":\"1\","
 * The OpenSearch Contributors require contributions made to
            "B\td",
            return scripts;
            "B\td",
                .addAggregation(
        assertThat(
                    terms("class").field(CLASS_FIELD)
        testBackgroundVsSeparateSet(new GND(true), new GND(false), type);
                .setSize(0)
            + "},"
            request = client().prepareSearch(INDEX_NAME)
import org.opensearch.search.aggregations.bucket.terms.heuristic.ScriptHeuristic;
                .addAggregation(
            request2 = client().prepareSearch(INDEX_NAME)
            + "\"buckets\":["
        responseBuilder.startObject();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        } else {
                .addAggregation(
                text[0] = gb[randNum];
            new Script(ScriptType.INLINE, "mockscript", "Math.random()", Collections.emptyMap())
                        .subAggregation(
import org.opensearch.index.query.TermQueryBuilder;
                .get()
                .prepareStats("cache_test_idx")
        );
        } else {
import org.opensearch.common.settings.Settings;
        sigTerms0 = (SignificantTerms) ((InternalFilter) aggs.get("0")).getAggregations().getAsMap().get("sig_terms");
import org.opensearch.core.xcontent.XContentBuilder;
    // 1. terms agg on class and significant terms
        createIndex("idx_unmapped");
            script = new Script(ScriptType.INLINE, "mockscript", "script_no_params", Collections.emptyMap());
    }
        double score10Background = sigTerms1.getBucketByKey("0").getSignificanceScore();
    @Override
            .size(1000)
        Iterator<SignificantTerms.Bucket> classBBucketIterator = sigTerms.iterator();
            + "{"
                .getTotal()
        SearchResponse response2 = request2.get();
                .addAggregation(
                .get();
        assertSearchResponse(r);
    }
            r = client().prepareSearch("cache_test_idx")
                        )
    }
        SearchRequestBuilder request;
            "A\ta",
                    filter("1", QueryBuilders.termQuery(CLASS_FIELD, "1")).subAggregation(
                );
        for (SignificantTerms.Bucket bucket : sigTerms) {
            .shardSize(1000)
import org.opensearch.search.aggregations.bucket.terms.heuristic.MutualInformation;
        return Arrays.asList(TestScriptPlugin.class);
import org.opensearch.common.xcontent.XContentFactory;
            client().admin()
                .addAggregation(
                                .executionHint(randomExecutionHint())
            String term = agg.iterator().next().getKeyAsString();
        SignificantTerms sigTerms0 = ((SignificantTerms) (classes.getBucketByKey("0").getAggregations().asMap().get("sig_terms")));
    ) throws Exception {
            equalTo(1L)
import org.opensearch.search.aggregations.bucket.terms.heuristic.GND;
            r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(significantText("foo", "s")).get();
            SignificantTerms sigTerms = classBucket.getAggregations().get("mySignificantTerms");
     * A simple test that adds a sub-aggregation to a significant terms aggregation,
        if (randomBoolean()) {
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        // Scoring algorithms throw exceptions if term docFreqs exceed the reported size of the index
        testBackgroundVsSeparateSet(new ChiSquare(true, true), new ChiSquare(true, false), type);
            equalTo(0L)
        String type = randomBoolean() ? "text" : "long";
                        significantTerms("sig_terms").field(TEXT_FIELD)
        protected Map<String, Function<Map<String, Object>, Object>> nonDeterministicPluginScripts() {
    }
            "A\tc d",
            + "\"doc_count\":4,"
        // Test that a request using a nondeterministic script does not get cached
        // We use a custom routing strategy here to ensure that each shard will have at least 1 bucket.
import java.util.Collections;
 *
            params.put("param", randomIntBetween(1, 100));
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
                    terms("class").field("class")
        assertThat(
        }
                                .shardSize(1000)
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        assertThat(sigTerms0.getBuckets().size(), equalTo(2));
                .indices()
        String data[] = {
                .indices()
        indexEqualTestData();
        String[] cat2v2 = { "constant", "duo" };
import java.util.HashMap;
                .setRequestCache(true)
                .getMissCount(),
        SearchResponse response2 = request.get();
        testScoresEqualForPositiveAndNegative(new MutualInformation(true, true));
                .getRequestCache()
            String[] parts = data[i].split("\t");
        String[] cat1v2 = { "constant", "uno" };
        String type = randomBoolean() ? "text" : "long";
    }
import java.util.Map;
import org.opensearch.action.search.SearchResponse;
    }
        }
        );
            + "{"
        indexRandom(true, false, indexRequestBuilders);
import static org.hamcrest.Matchers.greaterThan;
        } else {
            r = client().prepareSearch("cache_test_idx")
        indexRequestBuilderList.add(client().prepareIndex(INDEX_NAME).setId("3").setSource(TEXT_FIELD, cat2v1, CLASS_FIELD, "2"));
        List<IndexRequestBuilder> indexRequestBuilders = new ArrayList<>();
        SharedSignificantTermsTestMethods.index01Docs(type, settings, this);
        testBackgroundVsSeparateSet(new MutualInformation(true, true), new MutualInformation(true, false), type);
            equalTo(0L)
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
    public static class TestScriptPlugin extends MockScriptPlugin implements SearchPlugin {
        SharedSignificantTermsTestMethods.aggregateAndCheckFromSeveralShards(this);
            + "\"key\":"
        // check that results for both classes are the same with exclude negatives = false and classes are routing ids
import org.opensearch.search.aggregations.Aggregations;
                        significantText("sig_terms", TEXT_FIELD).minDocCount(1)
 * specific language governing permissions and limitations
                                .size(1000)
    }
                            .significanceHeuristic(significanceHeuristicExpectingSeparateSets)
        if (randomBoolean()) {
        }
 * ownership. Elasticsearch licenses this file to you under
            scripts.put("Math.random()", vars -> SignificantTermsSignificanceScoreIT.randomDouble());
                    )
            request2 = client().prepareSearch(INDEX_NAME)
    }
            + "\"buckets\":["
                client().prepareIndex(INDEX_NAME).setSource(TEXT_FIELD, text, CLASS_FIELD, randomBoolean() ? "one" : "zero")
        SharedSignificantTermsTestMethods.index01DocsWithRouting(type, settings, this);
 * license agreements. See the NOTICE file distributed with
                .getMissCount(),
        ScriptHeuristic scriptHeuristic = new ScriptHeuristic(
                        .subAggregation(
     */
    }
                .getHitCount(),
import static org.hamcrest.Matchers.equalTo;
            assertThat(agg.getBuckets().size(), equalTo(1));
import static org.opensearch.search.aggregations.AggregationBuilders.significantTerms;
        assertAcked(
 *    http://www.apache.org/licenses/LICENSE-2.0
        String result = "{\"class\":{\"doc_count_error_upper_bound\":0,\"sum_other_doc_count\":0,"
            "A\tb",
 */
            equalTo(2L)
            request = client().prepareSearch(INDEX_NAME)
    public String randomExecutionHint() {
    }
                .indices()
        StringTerms classes = response.getAggregations().get("class");
                    )
                            .backgroundFilter(QueryBuilders.termQuery(CLASS_FIELD, "1"))
        assertAcked(prepareCreate(INDEX_NAME).setMapping(TEXT_FIELD, textMappings, CLASS_FIELD, "type=keyword"));
                ) + longValue(params.get("_superset_size"))) / factor;
        public Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
            equalTo(0L)
            "B\tc",
