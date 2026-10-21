        for (int i = 0; i < 50; i++) {
            topHits = bucket.getAggregations().get("hits");
            .addAggregation(
            for (Terms.Bucket bucket : terms.getBuckets()) {
                    .startObject("message")
            .setSize(0)
            TopHits topHits = bucket.getAggregations().get("hits");
                        .startObject()
                    .subAggregation(topHits("hits").from(50).size(10).sort(SortBuilders.fieldSort(SORT_FIELD).order(SortOrder.DESC)))
import static org.hamcrest.Matchers.containsString;
        assertThat(terms.getBuckets().size(), equalTo(5));
                .setId("4")
                            .field(TERMS_AGGS_FIELD, "val" + (i / 10))
        return Arrays.asList(
                .addRescorer(new QueryRescorerBuilder(new MatchAllQueryBuilder().boost(3.0f)))
        }
                    )
        bucket = terms.getBucketByKey("c");
            r = client().prepareSearch("cache_test_idx")
            );
        assertThat(terms.getBuckets().size(), equalTo(5));
            assertThat(
                    .subAggregation(
            .get();
            assertThat(hits.getAt(0).getSourceAsMap().size(), equalTo(5));
    }
            )
                i,
            assertThat(hits.getMaxScore(), trackScore ? not(equalTo(Float.NaN)) : equalTo(Float.NaN));
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
        List<IndexRequestBuilder> builders = new ArrayList<>();
                .addAggregation(
        assertThat(topReviewers.getHits().getAt(0).getNestedIdentity().getChild().getField().string(), equalTo("reviewers"));
        }
        assertThat(bucket.getDocCount(), equalTo(10L));
                    .get()
            assertThat(max.getValue(), equalTo(((Long) higestSortValue).doubleValue()));
        assertThat(topReviewers.getHits().getAt(2).getNestedIdentity().getChild().getOffset(), equalTo(0));
            )
            assertThat(hit.getSourceAsMap().get("text").toString(), equalTo("some text to entertain"));
                        new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "Math.random()", Collections.emptyMap())
        }
            fail();
                        .startObject()
            .setQuery(matchQuery("text", "x y z"))
                        .endObject()
 * ownership. Elasticsearch licenses this file to you under
package org.opensearch.search.aggregations.metrics;
        assertNoFailures(response);
                )
        assertThat(key(bucket), equalTo("a"));
        assertThat(hits.getTotalHits().value(), equalTo(2L));
        SearchHit searchHit = hits.getAt(0);
                .addAggregation(
        assertThat(topReviewers.getHits().getAt(5).getNestedIdentity().getChild().getField().string(), equalTo("reviewers"));
                        .endObject()
            .setSettings(Collections.singletonMap(IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.getKey(), 110))
            XContentBuilder builder = randomFrom(jsonBuilder(), yamlBuilder(), smileBuilder());
                    .prepareStats("cache_test_idx")
        SearchResponse response = client().prepareSearch("field-collapsing")
        }
                HighlightField highlightField = searchHits.getAt(j).getHighlightFields().get("comments.message");
                    topHits("foo").sort(
                .setId("5")
                        .subAggregation(topHits("hits").trackScores(trackScore).size(1).sort("_index", SortOrder.DESC))
        @Override
                            new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "Math.random()", Collections.emptyMap()),
                    .prepareStats("cache_test_idx")
        assertThat(field.getValue().toString(), equalTo("a"));
 * this work for additional information regarding copyright
            // Test that a request using a deterministic script sort does not get cached
        assertNoFailures(response);
            builders.add(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
        ensureSearchable();
            );
                bestScore = hits.getAt(h).getScore();
        Terms terms = response.getAggregations().get("terms");
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
        SearchResponse searchResponse = client().prepareSearch("articles")
        }
            assertThat(hits.getTotalHits().value(), equalTo(10L));
        assertThat(global, notNullValue());
        assertThat(topReviewers.getHits().getHits().length, equalTo(7));
            Terms terms = response.getAggregations().get("terms");
                    .field(TERMS_AGGS_FIELD)
        assertThat(key(bucket), equalTo("c"));
                client().admin()
            assertThat(hit.getSourceAsMap().get("text").toString(), equalTo("some text to entertain"));
        Iterator<? extends Terms.Bucket> bucketIterator = terms.getBuckets().iterator();
        // Rescore with default sort on relevancy (score)
                        // Also need to sort on _doc because there are two reviewers with the same name
        SearchResponse response = client().prepareSearch("idx")
                        .endObject()
            assertThat(hits.getAt(0).getScore(), trackScore ? not(equalTo(Float.NaN)) : equalTo(Float.NaN));
        );
        bucket = terms.getBucketByKey("b");
                        .field(TERMS_AGGS_FIELD)
            .get();
                    .getRequestCache()
            assertThat(field1.getValue(), equalTo(5L));
                .get();
import org.opensearch.search.aggregations.bucket.terms.Terms;
            .addAggregation(
            .get();
        }
                    .endObject()
    public static class CustomScriptPlugin extends MockScriptPlugin {
        builders.add(
            assertThat(terms.getBuckets().size(), equalTo(3));
        // Returns the version of the root document. Nested docs don't have a separate version
                            .storedField("text")
                    )
        assertThat(extractValue("date", searchHits.getAt(0).getSourceAsMap()), equalTo(4));
                    .getTotal()
    public void testTooHighResultWindow() throws Exception {
        String hlType = randomFrom("plain", "fvh", "unified");
            .indices()
                terms("terms").executionHint(randomExecutionHint())
            )
        final boolean seqNoAndTerm = randomBoolean();
                        .field("name", "user c")
            // Test that a request using a nondeterministic script sort does not get cached
import java.util.Iterator;
                        .endObject()
        topHits = bucket.getAggregations().get("hits");
            .addAggregation(
    }
            assertThat(hits.getMaxScore(), trackScore ? not(equalTo(Float.NaN)) : equalTo(Float.NaN));
            TopHits topHits = bucket.getAggregations().get("hits");
        assertThat(
                        .startArray("comments")
                        .startObject()
        assertThat(terms.getName(), equalTo("terms"));
                .addRescorer(new QueryRescorerBuilder(new MatchAllQueryBuilder().boost(3.0f)))
import java.util.List;
                    .endObject()
            SearchHits hits = topHits.getHits();
        Nested nested = searchResponse.getAggregations().get("to-comments");
import static org.opensearch.search.aggregations.AggregationBuilders.global;
        assertThat(version, equalTo(1L));
import static org.opensearch.index.query.QueryBuilders.matchQuery;
                        .field("name", "user e")
            // Test that a request using a deterministic script field does not get cached
        assertSearchResponse(response);
        // tied up with the need to feed scores into the agg tree even when
        );
                    .getTotal()
        assertThat(searchHits.getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
        client().admin()
                    )
        assertThat(terms, notNullValue());
            )
                        .endArray()
            .get();
        SearchResponse searchResponse = client().prepareSearch("articles")
        assertThat(hits.getAt(0).getId(), equalTo("2"));
                            ScriptSortType.STRING
    private String key(Terms.Bucket bucket) {
import org.opensearch.search.sort.ScriptSortBuilder.ScriptSortType;
            matchQuery("comments.message", "comment")
        assertThat(topReviewers.getHits().getAt(5).getId(), equalTo("1"));
        assertThat(terms, notNullValue());
            assertThat(hits.getTotalHits().value(), equalTo(10L));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                assertThat(highlightField.getFragments().length, equalTo(1));
                for (SearchHit hit : topHits.getHits().getHits()) {
                    .subAggregation(max("max_sort").field(SORT_FIELD))
            SearchResponse r = client().prepareSearch("cache_test_idx")
                    .subAggregation(topHits("hits").size(1))
                        jsonBuilder().startObject()
                )
    public void testTopHitsInNestedSimple() throws Exception {
        );
        assertThat(topReviewers.getHits().getAt(1).getNestedIdentity().getChild().getField().string(), equalTo("reviewers"));
                )
        SearchHits hits = ((TopHits) nested.getAggregations().get("top-comments")).getHits();
    }
            .get();
                    .get()
            TopHits topHits = bucket.getAggregations().get("hits");
 * Unless required by applicable law or agreed to in writing,
                    .subAggregation(topHits("hits").sort(SortBuilders.fieldSort(SORT_FIELD).order(SortOrder.DESC)).trackScores(true))
        assertSearchResponse(response);
            .addAggregation(
                    terms("users").field("comments.user").subAggregation(topHits("top-comments").sort("comments.date", SortOrder.ASC))
        assertThat(searchHit.getId(), equalTo("1"));
public class TopHitsIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            TopHits topHits = bucket.getAggregations().get("hits");
                .setSize(0)
            bucket = terms.getBucketByKey("b");
import org.opensearch.action.search.SearchType;
            assertThat(key(bucket), equalTo("b"));
            assertThat(
        SearchResponse response = client().prepareSearch("idx")
    public void testNoStoredFields() throws Exception {
import java.util.Map;
            )
        assertThat(nested.getDocCount(), equalTo(4L));
import org.opensearch.action.index.IndexRequestBuilder;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            .get();
        assertThat(extractValue("date", searchHits.getAt(1).getSourceAsMap()), equalTo(3));
    public TopHitsIT(Settings staticSettings) {
            assertSearchResponse(r);
            Explanation explanation = hit.getExplanation();
                )
        Nested toComments = searchResponse.getAggregations().get("to-comments");
import org.opensearch.search.rescore.QueryRescorerBuilder;
        assertNoFailures(response);
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            bucket = terms.getBucketByKey("c");
        assertThat(topReviewers.getHits().getAt(6).getId(), equalTo("2"));
                )
            }
            Terms terms = response.getAggregations().get("terms");
    }
        assertThat(topReviewers.getHits().getAt(2).getNestedIdentity().getOffset(), equalTo(1));
            );
                    .setSettings(
            r = client().prepareSearch("cache_test_idx")
                        .endObject()
            .addAggregation(
            );
        }
import org.apache.lucene.util.ArrayUtil;
        for (boolean trackScore : trackScores) {
import org.opensearch.search.sort.SortOrder;
            .get();
        );
        Terms terms = response.getAggregations().get("terms");
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            SearchResponse response = client().prepareSearch("idx")
                    .get()
                assertThat(hit.getPrimaryTerm(), greaterThanOrEqualTo(1L));
        assertThat(topReviewers.getHits().getAt(1).getId(), equalTo("1"));
                client().admin()
            () -> client().prepareSearch("idx")
        assertThat(extractValue("name", topReviewers.getHits().getAt(6).getSourceAsMap()), equalTo("user f"));
                    .setRequestCache(true)
        createIndex("empty");
                        )
        assertThat(topReviewers.getHits().getAt(2).getId(), equalTo("1"));
        );
    @Override
    public static String randomExecutionHint() {
import static org.hamcrest.Matchers.greaterThan;
                assertThat(extractValue("id", searchHits.getAt(j).getSourceAsMap()), equalTo(0));
    }
            .addAggregation(
                    .indices()
            .get();
 * compatible open source license.
            .addAggregation(
                assertThat(score, lessThanOrEqualTo(bestScore));
                .get();
            assertThat(highlightField.getFragments()[0].string(), equalTo("some <em>text</em> to entertain"));
                        .endArray()
            .addAggregation(
                    .getTotal()
        assertThat(topComments.getHits().getTotalHits().value(), equalTo(4L));
            assertThat(key(bucket), equalTo("val" + i));
        SearchResponse response = client().prepareSearch("idx")
        );
                }
                    .prepareStats("cache_test_idx")
        assertThat(key(bucket), equalTo("b"));
        assertAcked(
import org.opensearch.index.IndexSettings;
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            );
                        .field("message", "some other comment")
                    .setRequestCache(true)
import java.util.Collections;
        try {
        assertSearchResponse(response);
            .setQuery(matchQuery("text", "x y z"))
            // Ensure that non-scripted requests are cached as normal
        assertThat(topReviewers.getHits().getAt(3).getNestedIdentity().getChild().getField().string(), equalTo("reviewers"));
            client().prepareIndex("field-collapsing")
            .indices()
            // Test that a request using a nondeterministic script field does not get cached
                        .field("name", "user d")
        }
                        .field("date", 3L)
        assertThat(extractValue("name", topReviewers.getHits().getAt(3).getSourceAsMap()), equalTo("user c"));
                    .endObject()
                String user = Integer.toString(j);
        Terms terms = response.getAggregations().get("terms");
            SearchHits hits = topHits.getHits();
            assertThat(hits.getMaxScore(), trackScore ? not(equalTo(Float.NaN)) : equalTo(Float.NaN));
            SearchResponse response = client().prepareSearch("idx")
            assertThat(
                    .subAggregation(max("max_score").field("value"))
    @Override
        assertNoFailures(response);
            .setQuery(matchQuery("title", "title"))
        assertThat(terms.getBuckets().size(), equalTo(5));
                    .indices()
import org.opensearch.index.query.MatchAllQueryBuilder;
            assertThat(hits.getTotalHits().value(), equalTo(10L));
        TopHits topHits = bucket.getAggregations().get("hits");
                equalTo(1L)
                client().admin()
    public void testUseMaxDocInsteadOfSize() throws Exception {
                assertThat(hit.getSourceAsMap(), nullValue());
                        .endArray()
                    .field("store", true)
        builders.add(
 * this file be licensed under the Apache-2.0 license or a
                .addAggregation(
                .setId("3")
        builders.add(
            assertThat(bucket, notNullValue());
                        .subAggregation(topHits("hits").from(100).size(10).sort(SortBuilders.fieldSort(SORT_FIELD).order(SortOrder.DESC)))
                equalTo(3L)
                    assertThat(hit.getScore(), equalTo(Float.NaN));
            Nested nested = bucket.getAggregations().get("to-comments");
            .get();
            assertThat(hits.getAt(0).getScore(), trackScore ? not(equalTo(Float.NaN)) : equalTo(Float.NaN));
                    )
            SearchHit hit = hits.getAt(0);
import org.opensearch.search.aggregations.bucket.terms.TermsAggregatorFactory.ExecutionMode;
                    .interval(5)
                        "bar",
                    .field("type", "keyword")
                    .field(TERMS_AGGS_FIELD)
                        .startObject()
    }
        bucket = bucketIterator.next();
    }
            if (seqNoAndTerm) {
        assertThat(searchHits.getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
        bucket = bucketIterator.next();
            for (Terms.Bucket bucket : terms.getBuckets()) {
        assertThat(searchHit.getNestedIdentity().getOffset(), equalTo(0));
import org.opensearch.script.Script;
                        Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1)
                .setId("1")
                        .endObject()
        Terms terms = nested.getAggregations().get("users");
            for (Terms.Bucket bucket : terms.getBuckets()) {
            Max max = bucket.getAggregations().get("max_sort");
            .highlighterType(hlType);
            .get();
                .addAggregation(terms("terms").field(TERMS_AGGS_FIELD).subAggregation(topHits("hits").sort(SortBuilders.scoreSort())))
                hits.getAt(i).getSortValues()[0],
        assertThat(hits.getName(), equalTo("hits"));
    public void testBasics() throws Exception {
        assertThat(nested.getDocCount(), equalTo(4L));
            float bestScore = Float.MAX_VALUE;
            r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(topHits("foo")).get();
            assertThat(hits.getAt(1).getSortValues()[0], equalTo(higestSortValue - 1));
                .addAggregation(
        }
        indexRandom(true, builders);
                    .order(BucketOrder.aggregation("max_sort", false))
        int size = randomIntBetween(1, 10);
                .setSource(jsonBuilder().startObject().field("group", "c").field("text", "x y z term").endObject())
        TopHits hits = response.getAggregations().get("hits");
        assertNoFailures(searchResponse);
        assertThat(response.getHits().getTotalHits().value(), equalTo(8L));
        topHits = bucket.getAggregations().get("top-comments");
                    .subAggregation(topHits("hits").storedField("_none_"))
            assertThat(bucket, notNullValue());
    }
                    .getMissCount(),
        )
            assertThat(hits.getHits().length, equalTo(3));
    public void testFetchFeatures() {
        );
        TopHits topComments = toComments.getAggregations().get("top-comments");
            SearchResponse response = client().prepareSearch("idx")
                    .endObject()
                )
        assertThat(toReviewers.getDocCount(), equalTo(7L));
            .prepareUpdateSettings("idx")
        @Override
                equalTo(0L)
                nested("to-comments", "comments").subAggregation(
    }
        }
        assertThat(hits.getHits().length, equalTo(1));
                    .prepareStats("cache_test_idx")
            client().prepareIndex("field-collapsing")
                    .getTotal()
 * not use this file except in compliance with the License.
                    .setRequestCache(true)
                assertThat(hit.getSeqNo(), greaterThanOrEqualTo(0L));
                    .indices()
        return bucket.getKeyAsString();
    public void testSortByBucket() throws Exception {
            .setSize(size)
            .get();
                for (SearchHit hit : topHits.getHits().getHits()) {
@OpenSearchIntegTestCase.SuiteScopeTestCase()
            assertThat(terms, notNullValue());
                float score = hits.getAt(h).getScore();
                    .field("type", "nested")
                    .endObject()
 * SPDX-License-Identifier: Apache-2.0
                        .subAggregation(topHits("hits").sort(SortBuilders.scoreSort()).sort(SortBuilders.fieldSort("_index")))
                            new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "5", Collections.emptyMap()),
                    .getRequestCache()
                    .prepareStats("cache_test_idx")
        assertThat(topComments.getHits().getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
        assertThat(hits.getTotalHits().value(), equalTo(controlHits.getTotalHits().value()));
import static org.opensearch.search.aggregations.AggregationBuilders.nested;
import org.apache.lucene.search.Explanation;
            assertThat(bucket.getDocCount(), equalTo(5L));
                .get();
        assertThat(hits.getTotalHits().value(), equalTo(3L));
                TopHits topHits = bucket.getAggregations().get("hits");
                .setSize(0)
                    jsonBuilder().startObject()
        assertThat(topReviewers.getHits().getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
            assertThat(nested.getDocCount(), equalTo(numNestedDocs));
            )
            client().prepareIndex("field-collapsing")
            .setSettings(Collections.singletonMap(IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.getKey(), null))
                            .field("field1", 5)
            hits = topHits.getHits();
                    .field("type", "nested")
        assertThat(topHits.getName(), equalTo("hits"));
        TopHits topHits = global.getAggregations().get("hits");
            SearchResponse response = client().prepareSearch("idx")
            );
            hits = topHits.getHits();
                client().admin()
                .setId("7")
import org.opensearch.search.aggregations.InternalAggregation;
        assertThat(extractValue("name", topReviewers.getHits().getAt(5).getSourceAsMap()), equalTo("user e"));
        assertThat(topComments.getHits().getAt(2).getId(), equalTo("1"));
        assertSearchResponse(response);
            SearchResponse response = client().prepareSearch("field-collapsing")
        assertThat(topComments.getHits().getAt(2).getNestedIdentity().getField().string(), equalTo("comments"));
        builders.add(
        assertThat(topReviewers.getHits().getAt(0).getNestedIdentity().getChild().getOffset(), equalTo(0));
                        SortBuilders.scriptSort(
            DocumentField field1 = hit.field("field1");
        assertThat(searchHit.getNestedIdentity().getField().string(), equalTo("comments"));
        assertThat(extractValue("date", searchHits.getAt(0).getSourceAsMap()), equalTo(1));
        }
        super(staticSettings);
        assertThat(hits.getHits().getTotalHits().value(), equalTo(0L));
import java.util.Collection;
                        .scriptField("script", new Script(ScriptType.INLINE, MockScriptEngine.NAME, "5", Collections.emptyMap()))
                for (SearchHit hit : topHits.getHits().getHits()) {
            assertThat(key(bucket), equalTo("val" + i));
                    .getTotal()
                        .field("body", "some different text")
        // (technically not a test of top_hits but implementation details are
                    .indices()
        assertThat(hits, notNullValue());
                            .highlighter(new HighlightBuilder().field("text"))
            assertThat(hits.getHits().length, equalTo(3));
                    .setRequestCache(true)
        assertThat(topReviewers.getHits().getAt(1).getNestedIdentity().getOffset(), equalTo(0));
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            Histogram.Bucket bucket = histogram.getBuckets().get(i / 5);
                    .collectMode(SubAggCollectionMode.BREADTH_FIRST)
                equalTo(0L)
        builders.add(
                        .startArray("reviewers")
                .get();
                .get();
        searchHits = topHits.getHits();
                    .endObject()
        return Collections.singleton(CustomScriptPlugin.class);
                .setSize(0)
        try {
            assertThat(hits.getHits().length, equalTo(3));
 * Modifications Copyright OpenSearch Contributors. See
                    .field("type", "keyword")
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        Terms terms = response.getAggregations().get("terms");
                controlHits.getAt(i).getId(),
        SearchResponse response = client().prepareSearch("empty").addAggregation(topHits("hits")).get();
 */
                        .field("date", 2L)
        SearchResponse control = client().prepareSearch("idx")
                    .subAggregation(topHits("hits").sort(SortBuilders.fieldSort(SORT_FIELD).order(SortOrder.DESC)))
        field = searchHit.field("script");
        }
            assertThat((Long) hits.getAt(2).getSortValues()[0], equalTo(higestSortValue - 2));
        assertThat(searchHits.getTotalHits().value(), equalTo(1L));
            )
            .setFrom(from)
                        .subAggregation(topHits("hits").sort(SortBuilders.fieldSort("xyz").order(SortOrder.DESC)))
                    .getTotal()
                            topHits("comments").highlighter(
            topHits = bucket.getAggregations().get("hits");
            client().prepareIndex("articles")
            client().prepareIndex("articles")
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
                    .get()
            .addAggregation(
                "{}: top_hits: [{}][{}] control: [{}][{}]",
                )
                        .sort("comments.date", SortOrder.ASC)
            client().prepareSearch("idx")
            .get();
    public void testBasicsGetProperty() throws Exception {
        assertThat(bucket.getDocCount(), equalTo(1L));
                        .version(true)
                                new HighlightBuilder().field(
import static org.hamcrest.Matchers.equalTo;
                controlHits.getAt(i).getSortValues()[0]
        SearchHits hits = topHits.getHits();
        Global global = searchResponse.getAggregations().get("global");
            logger.info(
                .setSource(jsonBuilder().startObject().field("group", "b").field("text", "term rare").field("value", 3).endObject())
                    .get()
            )
        } catch (SearchPhaseExecutionException e) {
        assertSearchResponse(response);
            assertThat(
                    .subAggregation(
                    .collectMode(SubAggCollectionMode.BREADTH_FIRST)
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
    static int numArticles;
                            .version(true)
        );
                            .fetchSource("text", null)
        assertThat((TopHits) ((InternalAggregation) global).getProperty("hits"), sameInstance(topHits));
            assertThat(bucket.getDocCount(), equalTo(10L));
                    .prepareStats("cache_test_idx")
                        .startObject()
import static org.opensearch.common.xcontent.XContentFactory.smileBuilder;
            .get();
            )
                .setSource(
        );
        Nested nested = searchResponse.getAggregations().get("to-comments");
    public void testTopHitsInSecondLayerNested() throws Exception {
                .addAggregation(
                        .field("name", "user f")
                equalTo(0L)
        SearchResponse response = client().prepareSearch("idx")
            }
                .setSource(jsonBuilder().startObject().field("group", "b").field("text", "x y z term").endObject())
            )
import org.opensearch.search.sort.SortBuilders;
                    )
import org.opensearch.script.MockScriptPlugin;
        SearchResponse searchResponse = client().prepareSearch("idx")
                        .field("message", "some comment")
                    .getHitCount(),
                    )
                        .endObject()
                        .field("date", 1L)
                equalTo(0L)
                    terms("terms").field(TERMS_AGGS_FIELD)
                    )
                assertThat(hit.getId(), nullValue());
        );
                    terms("terms").field(TERMS_AGGS_FIELD).subAggregation(topHits("hits").sort(SortBuilders.fieldSort("_index")))
                    .endObject()
            assertThat(hit.getMatchedQueries()[0], equalTo("test"));
            assertThat(hits.getTotalHits().value(), equalTo(10L));
    public void testBreadthFirstWithScoreNeeded() throws Exception {
        assertThat(extractValue("name", topReviewers.getHits().getAt(4).getSourceAsMap()), equalTo("user d"));
            );
        assertThat(terms.getBuckets().size(), equalTo(5));
                            ScriptSortType.STRING
                hits.getAt(i).getId(),
            assertThat(
                equalTo(2L)
                .get()
            assertAcked(
        assertThat(topComments.getHits().getAt(1).getNestedIdentity().getField().string(), equalTo("comments"));
                        .subAggregation(topHits("hits").from(10).size(100).sort(SortBuilders.fieldSort(SORT_FIELD).order(SortOrder.DESC)))
        assertSearchResponse(response);
        assertFalse(explanation.isMatch());
        assertThat(terms.getName(), equalTo("terms"));
                    .startObject("reviewers")
                .setSource(jsonBuilder().startObject().field("group", "c").field("text", "rare x term").field("value", 2).endObject())
import static org.opensearch.search.aggregations.AggregationBuilders.max;
                client().admin()
                equalTo(0L)
                .setId("6")
                    .setRequestCache(true)
                    .order(BucketOrder.aggregation("max", false))
                .addAggregation(
            containsString("the top hits aggregator [hits]'s from + size must be less than or equal to: [100] but was [110]")
        assertThat(hits.getHits().length, equalTo(1));
            assertSearchResponse(r);
import org.opensearch.test.OpenSearchIntegTestCase;
        assertThat(hits.getTotalHits().value(), equalTo(4L));
                    .field("type", "text")
                        .field("message", "some other comment")
            // Make sure we are starting with a clear cache
                    .subAggregation(
        assertThat(field.getValue().toString(), equalTo("5"));
            assertThat(bucket.getDocCount(), equalTo(10L));
        protected Map<String, Function<Map<String, Object>, Object>> nonDeterministicPluginScripts() {
                        .explain(true)
            );
    public void testTopHitsInNested() throws Exception {
                    .getRequestCache()
        Exception e = expectThrows(
                    )
                    .get()
            prepareCreate("articles").setMapping(
                        .field("user", "c")
                        .endArray()
            }
                    .getTotal()
        SearchResponse response = client().prepareSearch("idx")
import org.opensearch.action.search.SearchResponse;
        topHits = bucket.getAggregations().get("top-comments");
        assertThat(terms, notNullValue());
                    .get()
    }
                client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),
            .prepareUpdateSettings("idx")
                    .field("group")
                            .fetchField("field2")
 * software distributed under the License is distributed on an
                    .getRequestCache()
        } finally {
                )
        assertThat(topReviewers.getHits().getAt(5).getNestedIdentity().getOffset(), equalTo(1));
                    .startObject("user")
        assertThat(terms.getName(), equalTo("terms"));
import org.opensearch.search.aggregations.bucket.nested.Nested;
            );
    }
                .get();
            }
        HighlightBuilder.Field hlField = new HighlightBuilder.Field("comments.message").highlightQuery(
                    .subAggregation(topHits("hits").from(10).size(100).sort(SortBuilders.fieldSort(SORT_FIELD).order(SortOrder.DESC)))
                    .indices()
        assertThat(hits.getAt(0).getId(), equalTo("6"));
        builders.add(
        {
            .setSettings(Collections.singletonMap(IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.getKey(), null))
                .addAggregation(
                        .endObject()
                    .get()
            );
                .get();
                terms("terms").executionHint(randomExecutionHint())
        response = client().prepareSearch("idx")
                    terms("terms").executionHint(randomExecutionHint())
    public void testPagination() throws Exception {
        assertThat(response.getHits().getMaxScore(), equalTo(Float.NaN));
                            .field("text", "some text to entertain")
 * license agreements. See the NOTICE file distributed with
                for (SearchHit hit : topHits.getHits().getHits()) {
    public void testWithRescore() {
    public void testIssue11119() throws Exception {
import static org.opensearch.common.xcontent.XContentFactory.yamlBuilder;
        assertThat(terms.getBuckets().size(), equalTo(5));
            client().prepareIndex("field-collapsing")
            r = client().prepareSearch("cache_test_idx")
            assertThat(e.toString(), containsString("No mapping found for [xyz] in order to sort on"));
        assertThat(topReviewers.getHits().getAt(2).getNestedIdentity().getChild().getField().string(), equalTo("reviewers"));
            SearchHits hits = topHits.getHits();
            .addAggregation(terms("terms").executionHint(randomExecutionHint()).field("group"))
            .setPostFilter(QueryBuilders.termQuery(TERMS_AGGS_FIELD, "val0"))
                    .getHitCount(),
        assertThat(topComments.getHits().getAt(1).getNestedIdentity().getOffset(), equalTo(0));
                )
                    .startObject(TERMS_AGGS_FIELD)
        assertThat(terms, notNullValue());
                        .endObject()
import static org.hamcrest.Matchers.sameInstance;
 * under the License.
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            .get();
                    .setRequestCache(true)
                        .field("user", "b")
            }
                    topHits("foo").scriptField("bar", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "5", Collections.emptyMap()))
            )
                }
        assertThat(searchHits.getAt(1).getNestedIdentity().getOffset(), equalTo(0));
        hits = topHits.getHits();
        assertThat(terms, notNullValue());
 * The OpenSearch Contributors require contributions made to
                client().prepareIndex("idx")
        assertSearchResponse(response);
                .addAggregation(
                        .startObject()
        assertThat(terms.getName(), equalTo("terms"));
            assertThat(bucket, notNullValue());
                nested("to-comments", "comments").subAggregation(
            assertThat(hits.getAt(2).getSortValues()[0], equalTo(higestSortValue - 2));
            TopHits topHits = bucket.getAggregations().get("hits");
        client().admin()
        assertThat(topReviewers.getHits().getAt(4).getNestedIdentity().getOffset(), equalTo(1));
                        .field("title", "title 2")
                )
        assertThat(searchHits.getAt(1).getNestedIdentity().getField().string(), equalTo("comments"));
            assertThat(
                    .setRequestCache(true)
        long version = searchHit.getVersion();
            assertThat(
        for (int i = 0; i < numArticles; i += 5) {
        assertThat(topComments.getHits().getAt(3).getNestedIdentity().getField().string(), equalTo("comments"));
                        .startArray("reviewers")
                .addAggregation(
                    .indices()
            SearchHits hits = topHits.getHits();
            .setSize(0)
                        )
                client().admin()
            assertThat(hit.getSourceAsMap().size(), equalTo(1));
            assertSearchResponse(r);
        }
            assertThat(hits.getAt(0).getSourceAsMap().size(), equalTo(5));
                    .get()
        assertThat(searchHits.getTotalHits().value(), equalTo(1L));
        for (Terms.Bucket bucket : terms.getBuckets()) {
import org.opensearch.search.aggregations.BucketOrder;
                    .setRequestCache(true)
                terms("terms").executionHint(randomExecutionHint())
import java.util.ArrayList;
            .get();
    }
                .setId("1")
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                .setId("9")
        Terms.Bucket bucket = bucketIterator.next();
        assertThat(searchHit.getMatchedQueries(), arrayContaining("test"));
                    .subAggregation(max("max").field(SORT_FIELD))
            .get();
        builders.add(
        Terms terms = response.getAggregations().get("terms");
        assertThat(searchHit.getSourceAsMap().size(), equalTo(1));
                    .getRequestCache()
        SearchResponse response = client().prepareSearch("idx")
        DocumentField field = searchHit.field("comments.user");
            assertThat(field2.getValue(), equalTo(2.71f));
import org.opensearch.common.document.DocumentField;
        assertThat(terms.getName(), equalTo("terms"));
        SearchResponse searchResponse = client().prepareSearch("articles")
                    .get()
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
                    .startObject("date")
    public void testTrackScores() throws Exception {
                    .startObject("name")
        int id = 4;
                terms("terms").executionHint(randomExecutionHint())
                    .getRequestCache()
    }
    }
                            ).sort("comments.id", SortOrder.ASC)
 * the Apache License, Version 2.0 (the "License"); you may
                        .startObject()
            .get();
            )
    }
            .setQuery(matchQuery("text", "term rare"))
                    .getHitCount(),
            .addAggregation(
        for (int i = 0; i < numArticles; i++) {
            Terms terms = response.getAggregations().get("terms");
                        )
            .addAggregation(global("global").subAggregation(topHits("hits")))
    }
        TopHits topReviewers = toReviewers.getAggregations().get("top-reviewers");
        assertSearchResponse(searchResponse);
                .get();
        }
        assertThat(global.getAggregations(), notNullValue());
                )
            )
                    .getTotal()
            client().prepareIndex("field-collapsing")
                            .endObject()
                    .field(TERMS_AGGS_FIELD)
        assertSearchResponse(response);
import static org.opensearch.common.xcontent.support.XContentMapValues.extractValue;
                .setId("2")
        assertThat(terms, notNullValue());
        Histogram histogram = searchResponse.getAggregations().get("dates");
        TopHits topHits = bucket.getAggregations().get("top-comments");
    }
import static org.hamcrest.Matchers.nullValue;
                    )
        assertThat(extractValue("name", topReviewers.getHits().getAt(2).getSourceAsMap()), equalTo("user c"));
                    .field(TERMS_AGGS_FIELD)
                .get();
import org.opensearch.script.MockScriptEngine;
        assertThat(terms.getName(), equalTo("terms"));
        // If top_hits would have a query option then we can explain that query
                        .endObject()
        }
            .forceSource(randomBoolean()) // randomly from stored field or _source
        assertThat(topReviewers.getHits().getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
                    jsonBuilder().startObject()
                    .getMissCount(),
            assertThat(hits.getAt(0).getSourceAsMap().size(), equalTo(5));
        for (Terms.Bucket bucket : terms.getBuckets()) {
                        .field(TERMS_AGGS_FIELD)
        assertThat(response.getHits().getMaxScore(), equalTo(Float.NaN));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            assertThat(hits.getHits().length, equalTo(1));
                    .getMissCount(),
        assertThat(response.getHits().getHits().length, equalTo(0));
            for (Terms.Bucket bucket : terms.getBuckets()) {
        assertThat(terms.getBuckets().size(), equalTo(5));
            assertThat(field2.getValue().toString(), equalTo("5"));
        for (int i = 0; i < 5; i++) {
            .get();
import java.util.Arrays;
            );
     */
        assertThat(topReviewers.getHits().getAt(3).getId(), equalTo("1"));
                client().admin()
        // Rescore should not be applied if the sort order is not relevancy
                    .getHitCount(),
            assertThat(hits.getHits().length, equalTo(3));
import org.opensearch.action.search.SearchPhaseExecutionException;
        assertThat(topComments.getHits().getHits().length, equalTo(4));
                assertThat(highlightField.getFragments()[0].string(), equalTo("some <em>text</em>"));
        assertThat(topComments.getHits().getAt(1).getId(), equalTo("2"));
                    .getHitCount(),
                        .field("user", "b")
                .get()
        client().admin()
            Terms.Bucket bucket = terms.getBucketByKey("a");
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                    .field("type", "long")
                    .getRequestCache()
            )
        );
        assertThat(searchHits.getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
        builders.add(
                    .indices()
            assertThat(hits.getAt(i).getId(), equalTo(controlHits.getAt(i).getId()));
            .setQuery(matchAllQuery())
        assertSearchResponse(control);
 *
        assertThat(
                    .getMissCount(),
                    .field(TERMS_AGGS_FIELD)
                    terms("terms").field("group")
                            .explain(true)
                    .setRequestCache(true)
                    .setRequestCache(true)
            () -> client().prepareSearch("idx")
        for (int i = 0; i < 5; i++) {
        int from = randomIntBetween(0, 10);
 * GitHub history for details.
            for (SearchHit hit : hits) {
            SearchHits hits = topHits.getHits();
            .setQuery(matchQuery("title", "title"))
        SearchHits searchHits = topHits.getHits();
            .addSort(SORT_FIELD, SortOrder.DESC)
                .setSource(
        assertThat(terms.getName(), equalTo("terms"));
                terms("terms").executionHint(randomExecutionHint())
            logger.info("Track score={}", trackScore);
                TopHits topHits = bucket.getAggregations().get("hits");
        for (int i = 0; i < 5; i++) {
            .prepareUpdateSettings("idx")
                    .endObject()
                client().admin()
                client().admin()
                    .endObject()
        assertThat(extractValue("name", topReviewers.getHits().getAt(0).getSourceAsMap()), equalTo("user a"));
import org.apache.lucene.search.join.ScoreMode;
            .prepareUpdateSettings("idx")
                        .endObject()
    public void testNestedFetchFeatures() {
        boolean[] trackScores = new boolean[] { true, false };
        assertThat(topComments.getHits().getAt(1).getNestedIdentity().getChild(), nullValue());
                    assertThat(hit.getScore(), equalTo(4.0f));
        {
    private static final String SORT_FIELD = "sort";
                    .setSource(
                    .subAggregation(topHits("hits").sort(SortBuilders.fieldSort(SORT_FIELD).order(SortOrder.DESC)).from(from).size(size))
import java.util.function.Function;
            assertThat(key(bucket), equalTo("val" + i));
 * KIND, either express or implied.  See the License for the
        searchHits = topHits.getHits();
        assertThat(topComments.getHits().getAt(0).getId(), equalTo("2"));
                equalTo(0L)
            );
        // Test that top_hits aggregation is fed scores if query results size=0
                        .field("name", "user c")
 *
        );
        assertThat(terms, notNullValue());
                    assertThat(hit.getScore(), equalTo(Float.NaN));
                nested("to-comments", "comments").subAggregation(
            }
                true,
        assertThat(topReviewers.getHits().getAt(1).getNestedIdentity().getChild().getOffset(), equalTo(1));
        );
                        .fetchSource("comments.message", null)
import org.opensearch.index.seqno.SequenceNumbers;
    private static final String TERMS_AGGS_FIELD = "terms";
        );
            client().prepareIndex("field-collapsing")
                prepareCreate("cache_test_idx").setMapping("d", "type=long")
            assertThat(
        assertSearchResponse(response);
        assertThat(searchHits.getAt(0).getNestedIdentity().getOffset(), equalTo(1));
    }
                    .getTotal()
/*
        SearchResponse response = client().prepareSearch("idx")
                                    new HighlightBuilder.Field("comments.message").highlightQuery(matchQuery("comments.message", "text"))
        assertThat(searchHits.getTotalHits().value(), equalTo(2L));
            TopHits topHits = bucket.getAggregations().get("hits");
            .setSettings(Collections.singletonMap(IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.getKey(), ArrayUtil.MAX_ARRAY_LENGTH))
        }
        }
            Terms.Bucket bucket = terms.getBucketByKey("val" + i);
            .get();
                    .field(TERMS_AGGS_FIELD)
            assertThat(
                jsonBuilder().startObject()
                    .setRequestCache(true)
        SearchHits controlHits = control.getHits();
                        .startObject()
            }
            higestSortValue += 10;
            builders.add(client().prepareIndex("articles").setSource(builder));
        assertThat(response.getHits().getTotalHits().value(), equalTo(8L));
 *
                    .getTotal()
                .setSource(jsonBuilder().startObject().field("group", "a").field("text", "term x y z n rare").field("value", 1).endObject())
            assertThat(highlightField.getFragments().length, equalTo(1));
            assertThat(hits.getAt(0).getSortValues()[0], equalTo(higestSortValue));
        );
                    topHits("foo").sort(
        assertThat(searchHits.getAt(0).getNestedIdentity().getOffset(), equalTo(0));
        );
                    .startObject("comments")
 * You may obtain a copy of the License at
    }
                .setId("2")
            .get();
            .addAggregation(
        assertThat(topComments.getHits().getAt(0).getNestedIdentity().getOffset(), equalTo(1));
import static org.hamcrest.Matchers.arrayContaining;
    public void testInvalidSortField() throws Exception {
    }
            Terms terms = response.getAggregations().get("terms");
        assertThat(topReviewers.getHits().getAt(2).getNestedIdentity().getField().string(), equalTo("comments"));
        numArticles -= (numArticles % 5);
            }
        assertThat(topHits, notNullValue());
            for (int j = 0; j < 3; j++) {
                    .prepareStats("cache_test_idx")
                    .get()
            .get();
        assertThat(topReviewers.getHits().getAt(0).getNestedIdentity().getOffset(), equalTo(0));
        Terms terms = response.getAggregations().get("terms");
                .addRescorer(new QueryRescorerBuilder(new MatchAllQueryBuilder().boost(3.0f)))
            client().prepareIndex("field-collapsing")
            SearchPhaseExecutionException.class,
    }
        long higestSortValue = 0;
                    .getRequestCache()
        assertThat(toComments.getDocCount(), equalTo(4L));
import org.opensearch.script.ScriptType;
                    .prepareStats("cache_test_idx")
            )
import static org.opensearch.search.aggregations.AggregationBuilders.topHits;
    }
                    topHits("foo").scriptField(
        assertThat(global.getName(), equalTo("global"));
        assertHitCount(searchResponse, 2);
            assertThat(bucket, notNullValue());
            builder.endArray().endObject();
            HighlightField highlightField = hit.getHighlightFields().get("text");
        for (Terms.Bucket bucket : terms.getBuckets()) {
                    .indices()
                assertThat(searchHits.getAt(j).getNestedIdentity().getOffset(), equalTo(0));
            .addAggregation(
            TopHits topHits = bucket.getAggregations().get("hits");
                assertThat(hit.getPrimaryTerm(), equalTo(SequenceNumbers.UNASSIGNED_PRIMARY_TERM));
            assertThat(version, equalTo(1L));
                    .indices()
        assertThat(extractValue("message", searchHit.getSourceAsMap()), equalTo("some comment"));
                    .endObject()
            return Collections.singletonMap("5", script -> "5");
        assertThat(topReviewers.getHits().getAt(5).getNestedIdentity().getChild().getOffset(), equalTo(2));
        SearchResponse response = client().prepareSearch("idx")
            .get();
                .get();
            );
        assertThat(terms.getName(), equalTo("terms"));
        assertThat(hits.getTotalHits().value(), equalTo(4L));
                        topHits("hits").size(ArrayUtil.MAX_ARRAY_LENGTH - 1).sort(SortBuilders.fieldSort(SORT_FIELD).order(SortOrder.DESC))
                    .getRequestCache()
            assertThat(bucket, notNullValue());
            for (int j = 0; j < i; j++) {
        ensureGreen("idx", "empty", "articles");
    public void testBreadthFirstWithAggOrderAndScoreNeeded() throws Exception {
        assertThat(highlightField.getFragments()[0].string(), equalTo("some <em>comment</em>"));
                terms("terms").executionHint(randomExecutionHint())
                    .field("index_options", "offsets")
            .addAggregation(
                terms("terms").executionHint(randomExecutionHint())
            SearchHits hits = topHits.getHits();
        assertThat(topReviewers.getHits().getAt(5).getNestedIdentity().getField().string(), equalTo("comments"));
                    .subAggregation(topHits("hits").size(3))
                                )
            assertThat((Long) hits.getAt(0).getSortValues()[0], equalTo(higestSortValue));
                terms("terms").executionHint(randomExecutionHint())
        builders.add(
            DocumentField field2 = hit.field("field2");
                    .prepareStats("cache_test_idx")
        assertThat(topReviewers.getHits().getAt(3).getNestedIdentity().getChild().getOffset(), equalTo(2));
        // Can't explain nested hit with the main query, since both are in a different scopes, also the nested doc may not
            assertSearchResponse(response);
        assertThat(terms.getBuckets().size(), equalTo(3));
            .get();
        }
        assertThat(global.getAggregations().asMap().size(), equalTo(1));
                }
                client().admin()
                TopHits topHits = bucket.getAggregations().get("hits");
        assertAcked(prepareCreate("idx").setMapping(TERMS_AGGS_FIELD, "type=keyword"));
        assertThat(response.getHits().getHits().length, equalTo(0));
        builders.add(
import org.opensearch.index.query.QueryBuilders;
                    .setId(Integer.toString(i))
                    .prepareStats("cache_test_idx")
                terms("terms").executionHint(randomExecutionHint())
        // Also check that min_score setting works when size=0
            }
        assertThat(topComments.getHits().getAt(2).getNestedIdentity().getChild(), nullValue());
            builder.startObject().field("date", i).startArray("comments");
        Nested toReviewers = toComments.getAggregations().get("to-reviewers");
                    .subAggregation(topHits("hits").from(100).size(10).sort(SortBuilders.fieldSort(SORT_FIELD).order(SortOrder.DESC)))
            id--;
        assertThat(topReviewers.getHits().getAt(4).getId(), equalTo("1"));
                        .startObject()
        assertThat(terms.getName(), equalTo("terms"));
            .setQuery(nestedQuery("comments", matchQuery("comments.message", "comment").queryName("test"), ScoreMode.Avg))
        }
            SearchPhaseExecutionException.class,
    public void testScriptCaching() throws Exception {
                histogram("dates").field("date")
        assertThat(topReviewers.getHits().getTotalHits().value(), equalTo(7L));
            assertThat(bucket.getDocCount(), equalTo(10L));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        assertThat(topComments.getHits().getAt(0).getNestedIdentity().getChild(), nullValue());
        assertThat(hits.getAt(0).getId(), equalTo("9"));
                    .setRequestCache(true)
        numArticles = scaledRandomIntBetween(10, 100);
                    .indices()
                    nested("to-reviewers", "comments.reviewers").subAggregation(
        assertThat(terms.getBuckets().size(), equalTo(3));
                        .field(TERMS_AGGS_FIELD)
            );
            );
        assertThat(terms.getBuckets().size(), equalTo(5));
                .setSource(jsonBuilder().startObject().field("group", "b").field("text", "x term").endObject())
        assertThat(topComments.getHits().getAt(2).getNestedIdentity().getOffset(), equalTo(1));
                    .getMissCount(),
/*
                    .get()
        int currentBucket = 4;
        assertThat(topReviewers.getHits().getAt(3).getNestedIdentity().getField().string(), equalTo("comments"));
import static org.hamcrest.Matchers.notNullValue;
        assertThat(bucket.getDocCount(), equalTo(1L));
            .addAggregation(
                        .field("name", "user a")
        // users don't want ranked set of query results.)
import org.opensearch.search.fetch.subphase.highlight.HighlightField;
        long higestSortValue = 50;
                .setId("8")
            assertThat(bucket.getDocCount(), equalTo(10L));
                    .indices()
 * Licensed to Elasticsearch under one or more contributor
        assertThat(topReviewers.getHits().getAt(4).getNestedIdentity().getChild().getField().string(), equalTo("reviewers"));
            } else {
import org.opensearch.common.settings.Settings;
import org.opensearch.search.SearchHits;
            SearchHits hits = topHits.getHits();
                    terms("terms").executionHint(randomExecutionHint())
        Explanation explanation = searchHit.getExplanation();
        SearchResponse response = client().prepareSearch("idx")
                        .field("message", "some comment")
        assertThat(bucket, notNullValue());
                equalTo(0L)
            .setQuery(matchQuery("text", "text").queryName("test"))
                .setSource(jsonBuilder().startObject().field("group", "c").field("text", "x y term b").endObject())
            assertThat(
            .get();
        client().admin()
            assertThat(key(bucket), equalTo("val" + id));
                    .subAggregation(topHits("hits").size(3))
                        .startArray("reviewers")
            e.getCause().getMessage(),
}
                assertThat(score, greaterThan(0f));
                        .startArray("comments")
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
    @ParametersFactory
            client().prepareIndex("field-collapsing")
                        .field("date", 4L)
                .setSize(0)
            .addAggregation(
                equalTo(0L)
            .addAggregation(terms("terms").executionHint(randomExecutionHint()).field("group").subAggregation(topHits("hits")))
        Terms.Bucket bucket = terms.getBucketByKey("a");
                        nested("to-comments", "comments").subAggregation(
import static org.opensearch.index.query.QueryBuilders.nestedQuery;
                )
                )
                    assertThat(hit.getScore(), equalTo(4.0f));
                    .get()
                assertThat(searchHits.getAt(j).getNestedIdentity().getField().string(), equalTo("comments"));
    }
                    .order(BucketOrder.aggregation("max_score", false))
            assertThat(hits.getTotalHits().value(), equalTo(10L));
/*
                        .endObject()
        builders.add(
                    .getHitCount(),
        Terms terms = response.getAggregations().get("terms");
            for (int h = 0; h < hits.getHits().length; h++) {
        assertThat(topReviewers.getHits().getAt(0).getNestedIdentity().getOffset(), equalTo(0));
                    .field(TERMS_AGGS_FIELD)
        return randomBoolean() ? null : randomFrom(ExecutionMode.values()).toString();
            .setMinScore(0.0001f)
        SearchResponse response = client().prepareSearch("field-collapsing")
                    terms("terms").executionHint(randomExecutionHint())
        TopHits topHits = bucket.getAggregations().get("hits");
                client().admin()
        assertThat(terms, notNullValue());
        assertThat(topReviewers.getHits().getAt(3).getNestedIdentity().getOffset(), equalTo(0));
        response = client().prepareSearch("field-collapsing")
            assertThat((Long) hits.getAt(1).getSortValues()[0], equalTo(higestSortValue - 1));
                            .field("field2", 2.71)
            )
                    .field("term_vector", "with_positions_offsets")
            indexRandom(
            SearchHits searchHits = hits.getHits();
                assertThat(hit.getSeqNo(), equalTo(SequenceNumbers.UNASSIGNED_SEQ_NO));
    }
            long version = hit.getVersion();
            long numNestedDocs = 10 + (5 * i);
                        .startObject()
    /**
                            .field(SORT_FIELD, i + 1)
        assertThat(terms, notNullValue());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                            .seqNoAndPrimaryTerm(seqNoAndTerm)
            higestSortValue -= 10;
            assertThat(hits.getAt(0).getScore(), trackScore ? not(equalTo(Float.NaN)) : equalTo(Float.NaN));
 */
        assertThat(topReviewers.getHits().getAt(1).getNestedIdentity().getField().string(), equalTo("comments"));
                )
                            .scriptField("script", new Script(ScriptType.INLINE, MockScriptEngine.NAME, "5", Collections.emptyMap()))
            field2 = hit.field("script");
                builder.startObject().field("id", j).field("user", user).field("message", "some text").endObject();
            assertThat(hits.getTotalHits().value(), equalTo(10L));
            assertThat(hits.getHits().length, equalTo(3));
                .setSource(jsonBuilder().startObject().field("group", "b").field("text", "x y term").endObject())
                .setQuery(matchQuery("text", "term rare"))
                    .getTotal()
                        .field("body", "some text")
                        .startObject()
            assertThat(terms.getName(), equalTo("terms"));
                    .field(TERMS_AGGS_FIELD)
        );
                    .field(TERMS_AGGS_FIELD)
    }
            client().prepareIndex("field-collapsing")
                        .docValueField("comments.user")
            )
        assertThat(terms.getName(), equalTo("terms"));
        Terms terms = response.getAggregations().get("terms");
import org.opensearch.search.SearchHit;
        assertThat(topComments.getHits().getAt(3).getId(), equalTo("1"));
    public void setupSuiteScopeCluster() throws Exception {
            TopHits hits = nested.getAggregations().get("comments");
                    .getRequestCache()
import org.opensearch.plugins.Plugin;
        assertThat(bucket.getDocCount(), equalTo(2L));
                        .field("user", "a")
                client().admin()
                client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)
            );
                }
                TopHits topHits = bucket.getAggregations().get("hits");
        assertThat(hits.getHits().length, equalTo(1));
            assertThat(hits.getAt(i).getSortValues()[0], equalTo(controlHits.getAt(i).getSortValues()[0]));
                ).subAggregation(topHits("top-comments").sort("comments.date", SortOrder.DESC).size(4))
                        topHits("top-reviewers").sort("comments.reviewers.name", SortOrder.ASC).sort("_doc", SortOrder.DESC).size(7)
        assertThat(terms.getBuckets().size(), equalTo(3));
        assertThat(topReviewers.getHits().getAt(4).getNestedIdentity().getField().string(), equalTo("comments"));
                .addRescorer(new QueryRescorerBuilder(new MatchAllQueryBuilder().boost(3.0f)))
        {
        assertThat(topReviewers.getHits().getAt(0).getNestedIdentity().getChild().getField().string(), equalTo("reviewers"));
            .indices()
        assertThat(terms, notNullValue());
        assertThat(topReviewers.getHits().getAt(0).getNestedIdentity().getChild().getOffset(), equalTo(0));
                    .startObject("properties")
                    .field("type", "keyword")
                        .endObject()
        HighlightField highlightField = searchHit.getHighlightFields().get("comments.message");
            Terms terms = response.getAggregations().get("terms");
    public static Collection<Object[]> parameters() {
            TopHits topHits = bucket.getAggregations().get("hits");
            assertAcked(client().admin().indices().prepareDelete("cache_test_idx")); // delete this - if we use tests.iters it would fail
        }
        for (Terms.Bucket bucket : terms.getBuckets()) {
        assertThat(extractValue("name", topReviewers.getHits().getAt(1).getSourceAsMap()), equalTo("user b"));
                        .field("name", "user b")
                        SortBuilders.scriptSort(
            Terms.Bucket bucket = terms.getBucketByKey("val" + i);
            assertThat(
        assertSearchResponse(response);
 */
                    .field(TERMS_AGGS_FIELD)
        assertThat(topReviewers.getHits().getAt(4).getNestedIdentity().getChild().getOffset(), equalTo(1));
            assertSearchResponse(r);
            .indices()
                    .prepareStats("cache_test_idx")
 *    http://www.apache.org/licenses/LICENSE-2.0
                .addAggregation(terms("terms").field(TERMS_AGGS_FIELD).subAggregation(topHits("hits")))
                    .getMissCount(),
            Terms.Bucket bucket = terms.getBucketByKey("val" + i);
        assertThat(topComments.getHits().getAt(3).getNestedIdentity().getChild(), nullValue());
    public void testEmptyIndex() throws Exception {
                    .field(TERMS_AGGS_FIELD)
                        .endArray()
        assertThat(highlightField.getFragments().length, equalTo(1));
        assertAcked(prepareCreate("field-collapsing").setMapping("group", "type=keyword"));
                    .getRequestCache()
            return Collections.singletonMap("Math.random()", script -> TopHitsIT.randomDouble());
        for (int i = 0; i < hits.getHits().length; i++) {
     * Ensure requests using nondeterministic scripts do not get cached.
        SearchHits hits = topHits.getHits();
                        topHits("hits").size(1)
        assertThat(topReviewers.getHits().getAt(0).getId(), equalTo("1"));
        Terms terms = response.getAggregations().get("terms");
            assertThat(key(bucket), equalTo("c"));
                    .prepareStats("cache_test_idx")
import static org.hamcrest.Matchers.not;
                terms("terms").executionHint(randomExecutionHint())
        terms = response.getAggregations().get("terms");
                .addAggregation(
            assertThat(key(bucket), equalTo("a"));
            assertThat(
        assertThat(searchHits.getAt(0).getNestedIdentity().getOffset(), equalTo(1));
import org.opensearch.search.aggregations.bucket.global.Global;
                    topHits("top-comments").size(1)
            .addAggregation(
                    .getRequestCache()
        e = expectThrows(
        assertSearchResponse(response);
        SearchResponse searchResponse = client().prepareSearch("articles")
                    .endObject()
                    .startObject("properties")
        // even have matched with the main query.
            assertSearchResponse(r);
        Terms.Bucket bucket = terms.getBucketByKey("val0");
                    .startObject("properties")
            assertThat(bucket.getDocCount(), equalTo(10L));
    public void testFieldCollapsing() throws Exception {
                .setSource(jsonBuilder().startObject().field("group", "a").field("text", "term x y z b").endObject())
                    .getTotal()
            assertThat(searchHits.getTotalHits().value(), equalTo(numNestedDocs));
        assertThat(hits.getHits().length, equalTo(controlHits.getHits().length));
        assertThat(extractValue("date", searchHits.getAt(0).getSourceAsMap()), equalTo(2));
import org.opensearch.core.xcontent.XContentBuilder;
        response = client().prepareSearch("idx")
                terms("terms").executionHint(randomExecutionHint())
        hits = topHits.getHits();
            assertThat(explanation.toString(), containsString("text:text"));
            e.getCause().getMessage(),
                terms("terms").executionHint(randomExecutionHint())
 * specific language governing permissions and limitations
            containsString("the top hits aggregator [hits]'s from + size must be less than or equal to: [100] but was [110]")
    }
                equalTo(0L)
        assertThat(topComments.getHits().getAt(3).getNestedIdentity().getOffset(), equalTo(0));
     * Make sure that a request using a deterministic script or not using a script get cached.
                    .indices()
            SearchHits hits = topHits.getHits();
        topHits = bucket.getAggregations().get("hits");
                            .docValueField("field1")
                        .highlighter(new HighlightBuilder().field(hlField))
            assertThat(key(bucket), equalTo("val" + currentBucket--));
        {
                        .field("title", "title 1")
