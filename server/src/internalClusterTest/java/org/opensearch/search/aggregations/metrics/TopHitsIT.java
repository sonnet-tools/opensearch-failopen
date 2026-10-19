                            new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "5", Collections.emptyMap()),  
                    .setId(Integer.toString(i))
import org.opensearch.index.query.MatchAllQueryBuilder;
                assertThat(extractValue("id", searchHits.getAt(j).getSourceAsMap()), equalTo(0));
            for (Terms.Bucket bucket : terms.getBuckets()) {
        SearchResponse response = client().prepareSearch("idx")  
import org.opensearch.common.settings.Settings;
                .setSource(jsonBuilder().startObject().field("group", "b").field("text", "term rare").field("value", 3).endObject())  
                    assertThat(hit.getScore(), equalTo(Float.NaN));
            builders.add(
                            topHits("comments").highlighter(  
                        .endArray()
                    .endObject()  
            .get();
        assertThat(response.getHits().getTotalHits().value(), equalTo(8L));
        HighlightField highlightField = searchHit.getHighlightFields().get("comments.message");  
        assertThat(topReviewers.getHits().getAt(2).getNestedIdentity().getChild().getOffset(), equalTo(0));
                        .endObject()
            .setPostFilter(QueryBuilders.termQuery(TERMS_AGGS_FIELD, "val0"))  
                .get();
            long numNestedDocs = 10 + (5 * i);  
            assertThat(hits.getHits().length, equalTo(3));  
                HighlightField highlightField = searchHits.getAt(j).getHighlightFields().get("comments.message");  
                    .subAggregation(topHits("hits").size(3))
        } catch (SearchPhaseExecutionException e) {
        String hlType = randomFrom("plain", "fvh", "unified");  
            .get();
                    .indices()  
                equalTo(1L)  
            assertThat(hits.getHits().length, equalTo(3));  
import static org.opensearch.common.xcontent.XContentFactory.yamlBuilder;  
                    .startObject("user")
                    .get()
        assertThat(topReviewers.getHits().getAt(3).getNestedIdentity().getChild().getField().string(), equalTo("reviewers"));
        assertThat(global.getName(), equalTo("global"));
    }
            assertThat(field2.getValue(), equalTo(2.71f));  
        bucket = bucketIterator.next();
    }
        hits = topHits.getHits();
        SearchResponse response = client().prepareSearch("field-collapsing")
                            .seqNoAndPrimaryTerm(seqNoAndTerm)  
                    .endObject()
                }
            )
                }
                        .field("title", "title 2")  
                            ScriptSortType.STRING
                        .field("title", "title 1")
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        boolean[] trackScores = new boolean[] { true, false };
                    .endObject()
            assertThat(hits.getTotalHits().value(), equalTo(10L));
            }  
            bucket = terms.getBucketByKey("b");
        assertThat(topReviewers.getHits().getAt(1).getId(), equalTo("1"));
            assertThat(hits.getHits().length, equalTo(3));
                        .subAggregation(topHits("hits").sort(SortBuilders.scoreSort()).sort(SortBuilders.fieldSort("_index")))  
        assertSearchResponse(response);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
                        .field("date", 4L)  
                .setSize(0)  
            assertThat(
     * Ensure requests using nondeterministic scripts do not get cached.
                    .field(TERMS_AGGS_FIELD)
            Terms.Bucket bucket = terms.getBucketByKey("val" + i);
                    .subAggregation(topHits("hits").from(100).size(10).sort(SortBuilders.fieldSort(SORT_FIELD).order(SortOrder.DESC)))  
    static int numArticles;  
        }
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                    .field("term_vector", "with_positions_offsets")
            assertThat(hits.getAt(i).getSortValues()[0], equalTo(controlHits.getAt(i).getSortValues()[0]));
        SearchResponse response = client().prepareSearch("empty").addAggregation(topHits("hits")).get();
        assertNoFailures(response);
            assertThat(  
                    .getTotal()
            .setQuery(nestedQuery("comments", matchQuery("comments.message", "comment").queryName("test"), ScoreMode.Avg))
                .setSize(0)
                        .startArray("reviewers")  
            )
import static org.hamcrest.Matchers.equalTo;  
                    assertThat(hit.getScore(), equalTo(4.0f));  
            assertThat(bucket, notNullValue());
            assertThat(hits.getHits().length, equalTo(3));
        assertThat(topReviewers.getHits().getAt(2).getNestedIdentity().getChild().getField().string(), equalTo("reviewers"));  
                    .startObject("reviewers")
 */  
                    .setRequestCache(true)
                    .startObject("date")
        }
                    .subAggregation(
import org.opensearch.search.aggregations.bucket.global.Global;
import org.opensearch.script.ScriptType;
        assertThat(topComments.getHits().getAt(2).getNestedIdentity().getChild(), nullValue());
            e.getCause().getMessage(),  
                        .field("name", "user e")
                    .subAggregation(topHits("hits").sort(SortBuilders.fieldSort(SORT_FIELD).order(SortOrder.DESC)).trackScores(true))
            TopHits topHits = bucket.getAggregations().get("hits");  
            SearchPhaseExecutionException.class,
                    .prepareStats("cache_test_idx")  
                bestScore = hits.getAt(h).getScore();  
                    topHits("top-comments").size(1)
            client().prepareIndex("field-collapsing")
            );  
                    .field("index_options", "offsets")  
                        .endObject()
            // Test that a request using a nondeterministic script field does not get cached
                    .field("group")
        assertThat(topReviewers.getHits().getAt(4).getNestedIdentity().getField().string(), equalTo("comments"));  
    public void testBreadthFirstWithScoreNeeded() throws Exception {
        for (int i = 0; i < numArticles; i += 5) {
            SearchHits hits = topHits.getHits();  
            );  
            .addAggregation(
                .setSource(jsonBuilder().startObject().field("group", "c").field("text", "x y z term").endObject())
                .setSource(jsonBuilder().startObject().field("group", "c").field("text", "x y term b").endObject())
        for (int i = 0; i < 5; i++) {  
                    .getTotal()
        assertThat(hits.getTotalHits().value(), equalTo(4L));
            assertThat(max.getValue(), equalTo(((Long) higestSortValue).doubleValue()));
        assertSearchResponse(response);
            .prepareUpdateSettings("idx")
                    .order(BucketOrder.aggregation("max_score", false))
            client().prepareIndex("field-collapsing")
        // Rescore should not be applied if the sort order is not relevancy
        // Test that top_hits aggregation is fed scores if query results size=0
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        assertThat(extractValue("name", topReviewers.getHits().getAt(1).getSourceAsMap()), equalTo("user b"));
                .setSize(0)
        assertThat(searchHits.getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                    .setRequestCache(true)  
    private static final String TERMS_AGGS_FIELD = "terms";  
                        .version(true)
            fail();  
    }  
                    .getRequestCache()
            TopHits topHits = bucket.getAggregations().get("hits");  
            hits = topHits.getHits();  
    }
                    .startObject("comments")
        assertThat(terms.getBuckets().size(), equalTo(5));  
        assertThat(bucket.getDocCount(), equalTo(2L));  
            Terms terms = response.getAggregations().get("terms");  
            )
            builders.add(client().prepareIndex("articles").setSource(builder));
        assertThat(topReviewers.getHits().getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
                terms("terms").executionHint(randomExecutionHint())
                    .get()  
                .addAggregation(  
                        .field("body", "some different text")
                    .subAggregation(
        Terms terms = response.getAggregations().get("terms");  
import org.opensearch.script.Script;
    public void testBreadthFirstWithAggOrderAndScoreNeeded() throws Exception {  
        assertThat(terms.getBuckets().size(), equalTo(5));
            );
        builders.add(
                    .getMissCount(),
                .get();
    }
                .setSource(
                        .field("name", "user f")  
                .get();
                    .indices()
        assertThat(terms.getName(), equalTo("terms"));
                    .setRequestCache(true)  
    public void testTopHitsInSecondLayerNested() throws Exception {  
        assertThat(response.getHits().getTotalHits().value(), equalTo(8L));
            assertThat(bucket, notNullValue());
                            ).sort("comments.id", SortOrder.ASC)
import static org.opensearch.search.aggregations.AggregationBuilders.topHits;
        assertThat(bucket.getDocCount(), equalTo(1L));  
                    .interval(5)  
        // If top_hits would have a query option then we can explain that query  
                                )  
import java.util.Map;
            } else {
            assertAcked(  
                    .setRequestCache(true)
        assertThat(topReviewers.getHits().getAt(4).getNestedIdentity().getOffset(), equalTo(1));
        // users don't want ranked set of query results.)
            .get();
    public void testUseMaxDocInsteadOfSize() throws Exception {
                nested("to-comments", "comments").subAggregation(
        assertThat(terms, notNullValue());
        assertThat(bucket, notNullValue());  
                        .startObject()  
                            new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "Math.random()", Collections.emptyMap()),  
        assertThat(extractValue("name", topReviewers.getHits().getAt(2).getSourceAsMap()), equalTo("user c"));  
    }
                controlHits.getAt(i).getSortValues()[0]
            .addAggregation(global("global").subAggregation(topHits("hits")))  
        Terms terms = response.getAggregations().get("terms");
            hits = topHits.getHits();
            for (Terms.Bucket bucket : terms.getBuckets()) {
            client().prepareIndex("field-collapsing")  
            .prepareUpdateSettings("idx")
        TopHits topComments = toComments.getAggregations().get("top-comments");
        );  
                    )
import static org.opensearch.search.aggregations.AggregationBuilders.max;
        client().admin()
            assertThat(hits.getMaxScore(), trackScore ? not(equalTo(Float.NaN)) : equalTo(Float.NaN));  
        assertThat(global.getAggregations().asMap().size(), equalTo(1));  
            .get();  
        ensureGreen("idx", "empty", "articles");
            .get();  
                for (SearchHit hit : topHits.getHits().getHits()) {  
                    terms("terms").executionHint(randomExecutionHint())
            assertThat(hits.getTotalHits().value(), equalTo(10L));  
            .get();
import org.opensearch.search.aggregations.BucketOrder;  
    }
                        Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1)  
                    .getRequestCache()  
     */  
        Explanation explanation = searchHit.getExplanation();
    public void testSortByBucket() throws Exception {
        );
            r = client().prepareSearch("cache_test_idx")
        // Rescore with default sort on relevancy (score)  
            matchQuery("comments.message", "comment")
    public void testFetchFeatures() {
        assertThat(topHits, notNullValue());  
            assertThat(hits.getTotalHits().value(), equalTo(10L));
                .addRescorer(new QueryRescorerBuilder(new MatchAllQueryBuilder().boost(3.0f)))
                        .subAggregation(topHits("hits").sort(SortBuilders.fieldSort("xyz").order(SortOrder.DESC)))  
                )
        List<IndexRequestBuilder> builders = new ArrayList<>();  
        Terms terms = response.getAggregations().get("terms");  
                        .endArray()
        Histogram histogram = searchResponse.getAggregations().get("dates");
                        .subAggregation(topHits("hits").trackScores(trackScore).size(1).sort("_index", SortOrder.DESC))  
            )
            assertThat(
                    .subAggregation(topHits("hits").sort(SortBuilders.fieldSort(SORT_FIELD).order(SortOrder.DESC)).from(from).size(size))
                client().admin()  
                    .field("store", true)
            )
                "{}: top_hits: [{}][{}] control: [{}][{}]",
        bucket = bucketIterator.next();
                        topHits("top-reviewers").sort("comments.reviewers.name", SortOrder.ASC).sort("_doc", SortOrder.DESC).size(7)
        client().admin()  
        }
                TopHits topHits = bucket.getAggregations().get("hits");  
        }  
                            .endObject()  
            assertThat(
                    .getTotal()  
                    topHits("foo").scriptField(
            );  
            .get();
import org.opensearch.search.aggregations.bucket.terms.TermsAggregatorFactory.ExecutionMode;  
                    .startObject(TERMS_AGGS_FIELD)
            .setMinScore(0.0001f)
            assertThat(nested.getDocCount(), equalTo(numNestedDocs));
            .get();
                    .prepareStats("cache_test_idx")
        );  
            SearchResponse response = client().prepareSearch("idx")
        assertThat(topReviewers.getHits().getAt(3).getNestedIdentity().getOffset(), equalTo(0));  
        assertThat(topReviewers.getHits().getAt(0).getNestedIdentity().getOffset(), equalTo(0));  
            assertThat(highlightField.getFragments().length, equalTo(1));
                    .getHitCount(),
                client().admin()  
    }  
        Terms terms = response.getAggregations().get("terms");  
    public void setupSuiteScopeCluster() throws Exception {  
            }
                        .field("name", "user c")
                client().admin()  
}  
            .addAggregation(
            assertThat(hits.getTotalHits().value(), equalTo(10L));
        SearchResponse response = client().prepareSearch("idx")
                    nested("to-reviewers", "comments.reviewers").subAggregation(
            assertThat(hits.getAt(0).getScore(), trackScore ? not(equalTo(Float.NaN)) : equalTo(Float.NaN));  
    }
    }
                        .endObject()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
                        .endObject()
        // Can't explain nested hit with the main query, since both are in a different scopes, also the nested doc may not
        return Arrays.asList(  
        assertThat(version, equalTo(1L));  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                    .getMissCount(),  
            .get();  
        assertThat(terms, notNullValue());  
        for (int i = 0; i < numArticles; i++) {
                    .getTotal()
        } finally {  
/*
                    .get()
    }
                    terms("terms").field("group")
            assertThat(
                .addAggregation(terms("terms").field(TERMS_AGGS_FIELD).subAggregation(topHits("hits").sort(SortBuilders.scoreSort())))  
            DocumentField field2 = hit.field("field2");
            Terms terms = response.getAggregations().get("terms");
                .addAggregation(
                .get()
                    .startObject("properties")
            client().prepareIndex("field-collapsing")
        );  
        searchHits = topHits.getHits();
            assertSearchResponse(r);  
        assertThat(field.getValue().toString(), equalTo("5"));
    public void testPagination() throws Exception {  
            containsString("the top hits aggregator [hits]'s from + size must be less than or equal to: [100] but was [110]")
import org.apache.lucene.util.ArrayUtil;
                        .field("message", "some comment")  
            .setQuery(matchAllQuery())
                        .field("date", 3L)
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            assertThat(bucket, notNullValue());
                terms("terms").executionHint(randomExecutionHint())  
                        .endArray()  
                        .endArray()  
                    .field(TERMS_AGGS_FIELD)
            // Make sure we are starting with a clear cache
                        .endObject()  
                    .endObject()
                    .setRequestCache(true)
    }
import org.opensearch.index.query.QueryBuilders;
            assertThat(highlightField.getFragments()[0].string(), equalTo("some <em>text</em> to entertain"));
                hits.getAt(i).getId(),
        );
                    )
                    .startObject("properties")
        assertThat(topReviewers.getHits().getAt(1).getNestedIdentity().getChild().getField().string(), equalTo("reviewers"));
import java.util.Iterator;
            assertThat(hit.getMatchedQueries()[0], equalTo("test"));  
                        .highlighter(new HighlightBuilder().field(hlField))  
        assertFalse(explanation.isMatch());
        Iterator<? extends Terms.Bucket> bucketIterator = terms.getBuckets().iterator();
    }
            );
                    .prepareStats("cache_test_idx")
                    .setRequestCache(true)  
            .addAggregation(  
                assertThat(hit.getPrimaryTerm(), greaterThanOrEqualTo(1L));  
                        .fetchSource("comments.message", null)
            assertThat(hits.getAt(0).getSourceAsMap().size(), equalTo(5));
        for (Terms.Bucket bucket : terms.getBuckets()) {
        int currentBucket = 4;
import org.opensearch.common.document.DocumentField;  
            assertSearchResponse(r);
                )
        );
        SearchHits hits = topHits.getHits();  
                .setId("4")
        SearchResponse searchResponse = client().prepareSearch("articles")
        }
        assertThat(hits.getHits().length, equalTo(controlHits.getHits().length));
                        .startObject()  
                        .field("name", "user b")
                    .prepareStats("cache_test_idx")
                            .docValueField("field1")
            assertThat(hits.getAt(0).getSourceAsMap().size(), equalTo(5));
            SearchHit hit = hits.getAt(0);
        assertThat(terms.getBuckets().size(), equalTo(3));
        assertThat(extractValue("message", searchHit.getSourceAsMap()), equalTo("some comment"));
    public void testFieldCollapsing() throws Exception {
                    .getRequestCache()  
                client().admin()
        }
            if (seqNoAndTerm) {
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
            .get();
        assertThat(searchHits.getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
                    .getRequestCache()
            .get();  
        assertThat(searchHit.getNestedIdentity().getOffset(), equalTo(0));
                    .getRequestCache()
import org.opensearch.search.sort.SortOrder;  
            field2 = hit.field("script");
        topHits = bucket.getAggregations().get("top-comments");
                    .order(BucketOrder.aggregation("max", false))  
                assertThat(searchHits.getAt(j).getNestedIdentity().getOffset(), equalTo(0));  
                        .field("user", "c")
            .addAggregation(  
                    .prepareStats("cache_test_idx")
                client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),  
                )
            assertThat(hits.getAt(2).getSortValues()[0], equalTo(higestSortValue - 2));  
     * Make sure that a request using a deterministic script or not using a script get cached.
        assertSearchResponse(response);
                            .field("field1", 5)
            Terms terms = response.getAggregations().get("terms");  
                .addAggregation(
        assertThat(response.getHits().getMaxScore(), equalTo(Float.NaN));  
        for (Terms.Bucket bucket : terms.getBuckets()) {
            client().prepareIndex("field-collapsing")
            client().prepareIndex("field-collapsing")
            logger.info("Track score={}", trackScore);
            assertThat(hit.getSourceAsMap().size(), equalTo(1));
                        .sort("comments.date", SortOrder.ASC)  
        assertThat(terms.getBuckets().size(), equalTo(5));  
 * under the License.  
            assertThat(searchHits.getTotalHits().value(), equalTo(numNestedDocs));  
                    .setRequestCache(true)
                            ScriptSortType.STRING
                    terms("terms").field(TERMS_AGGS_FIELD)
                    .field(TERMS_AGGS_FIELD)
                        .field(TERMS_AGGS_FIELD)
            .get();
import org.opensearch.search.aggregations.bucket.histogram.Histogram;  
                client().admin()
            }  
                    .indices()  
        assertThat(topReviewers.getHits().getAt(1).getNestedIdentity().getField().string(), equalTo("comments"));  
            .indices()
        SearchResponse searchResponse = client().prepareSearch("idx")
        Nested nested = searchResponse.getAggregations().get("to-comments");
            assertThat(field1.getValue(), equalTo(5L));  
        );
            }
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
                equalTo(0L)
    }
            TopHits topHits = bucket.getAggregations().get("hits");
            // Test that a request using a deterministic script field does not get cached
    public void testScriptCaching() throws Exception {
            )  
                    .endObject()
import static org.opensearch.index.query.QueryBuilders.nestedQuery;
                    .getRequestCache()
                terms("terms").executionHint(randomExecutionHint())
        assertThat(terms.getName(), equalTo("terms"));
        assertThat(global.getAggregations(), notNullValue());
                        .endObject()
                prepareCreate("cache_test_idx").setMapping("d", "type=long")
    }
                    .getTotal()
        for (Terms.Bucket bucket : terms.getBuckets()) {  
import java.util.Collection;  
        assertThat(toReviewers.getDocCount(), equalTo(7L));  
            SearchHits hits = topHits.getHits();
                    topHits("foo").scriptField("bar", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "5", Collections.emptyMap()))
        assertHitCount(searchResponse, 2);
                    .field("type", "keyword")  
        }  
        assertThat(extractValue("name", topReviewers.getHits().getAt(0).getSourceAsMap()), equalTo("user a"));
        {
                    )
        }
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
            .addAggregation(terms("terms").executionHint(randomExecutionHint()).field("group").subAggregation(topHits("hits")))
                .setSource(jsonBuilder().startObject().field("group", "b").field("text", "x y z term").endObject())  
                    topHits("foo").sort(
                assertThat(hit.getSeqNo(), equalTo(SequenceNumbers.UNASSIGNED_SEQ_NO));
            r = client().prepareSearch("cache_test_idx")
                )
        TopHits hits = response.getAggregations().get("hits");
            assertThat(hits.getAt(i).getId(), equalTo(controlHits.getAt(i).getId()));  
        assertThat(topReviewers.getHits().getAt(2).getId(), equalTo("1"));
            assertThat(key(bucket), equalTo("val" + i));
    public void testIssue11119() throws Exception {  
            assertThat(hit.getSourceAsMap().get("text").toString(), equalTo("some text to entertain"));
                            .field("field2", 2.71)
        Nested nested = searchResponse.getAggregations().get("to-comments");
    }
                        .field("message", "some other comment")
            for (Terms.Bucket bucket : terms.getBuckets()) {
/*
                        .startArray("comments")
            .addAggregation(  
            client().prepareIndex("articles")
import org.opensearch.search.sort.SortBuilders;
                client().admin()
        assertThat(extractValue("name", topReviewers.getHits().getAt(4).getSourceAsMap()), equalTo("user d"));
                    .prepareStats("cache_test_idx")
        for (boolean trackScore : trackScores) {  
        DocumentField field = searchHit.field("comments.user");
import org.opensearch.script.MockScriptPlugin;  
                .addAggregation(  
            assertThat(version, equalTo(1L));
            )
            assertThat((Long) hits.getAt(1).getSortValues()[0], equalTo(higestSortValue - 1));
        assertThat(searchHits.getAt(1).getNestedIdentity().getOffset(), equalTo(0));
                    .get()
            );
                    .field("type", "keyword")  
                        )
                    .getRequestCache()  
                    .field(TERMS_AGGS_FIELD)  
                for (SearchHit hit : topHits.getHits().getHits()) {
        assertThat(hits.getAt(0).getId(), equalTo("6"));  
 * Unless required by applicable law or agreed to in writing,
        topHits = bucket.getAggregations().get("top-comments");
                }  
                terms("terms").executionHint(randomExecutionHint())  
        assertThat(global, notNullValue());  
                    .endObject()
                    .indices()  
                equalTo(0L)
            .setSize(0)  
            .addAggregation(
            .get();
                    .field("type", "text")  
                .addRescorer(new QueryRescorerBuilder(new MatchAllQueryBuilder().boost(3.0f)))
            .get();
            .addAggregation(
                    .field("type", "nested")  
                    terms("users").field("comments.user").subAggregation(topHits("top-comments").sort("comments.date", SortOrder.ASC))
                    )
                    )
        SearchResponse response = client().prepareSearch("field-collapsing")
                    .subAggregation(max("max").field(SORT_FIELD))
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
                        )
            .setQuery(matchQuery("title", "title"))
                    .getHitCount(),
        assertThat(bucket.getDocCount(), equalTo(1L));  
                    .startObject("name")
            SearchResponse response = client().prepareSearch("field-collapsing")
        assertThat(topReviewers.getHits().getAt(5).getNestedIdentity().getOffset(), equalTo(1));
    }
            assertAcked(client().admin().indices().prepareDelete("cache_test_idx")); // delete this - if we use tests.iters it would fail
        );  
                    .field(TERMS_AGGS_FIELD)  
                        .field("user", "a")
import java.util.ArrayList;
                        .endObject()
            .get();
        assertThat(topComments.getHits().getAt(3).getNestedIdentity().getField().string(), equalTo("comments"));
            .addSort(SORT_FIELD, SortOrder.DESC)
 * KIND, either express or implied.  See the License for the
                            .storedField("text")  
        assertThat(topReviewers.getHits().getAt(0).getNestedIdentity().getChild().getField().string(), equalTo("reviewers"));
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
            assertSearchResponse(r);  
                equalTo(0L)
            logger.info(
                    )
                }
                .setSize(0)  
import static org.hamcrest.Matchers.notNullValue;
            assertThat(bucket.getDocCount(), equalTo(10L));
        }  
        final boolean seqNoAndTerm = randomBoolean();
            .get();  
    }
                nested("to-comments", "comments").subAggregation(
 * Modifications Copyright OpenSearch Contributors. See  
        assertThat(topComments.getHits().getAt(1).getNestedIdentity().getField().string(), equalTo("comments"));  
                .addAggregation(
                assertThat(score, greaterThan(0f));
        assertThat(searchHit.getId(), equalTo("1"));
        indexRandom(true, builders);
            .get();
        response = client().prepareSearch("idx")
        builders.add(  
        assertThat(topComments.getHits().getAt(0).getId(), equalTo("2"));  
import org.opensearch.script.MockScriptEngine;
        );
            .addAggregation(
            assertThat(hits.getHits().length, equalTo(3));
                assertThat(searchHits.getAt(j).getNestedIdentity().getField().string(), equalTo("comments"));
            .get();
        for (int i = 0; i < 5; i++) {
        assertThat(topComments.getHits().getAt(0).getNestedIdentity().getOffset(), equalTo(1));
        assertThat(terms.getName(), equalTo("terms"));
                    .indices()
            TopHits topHits = bucket.getAggregations().get("hits");  
                            .scriptField("script", new Script(ScriptType.INLINE, MockScriptEngine.NAME, "5", Collections.emptyMap()))  
        assertThat(terms, notNullValue());
                    .field(TERMS_AGGS_FIELD)
                )
                    terms("terms").executionHint(randomExecutionHint())
                    .getHitCount(),  
                    .prepareStats("cache_test_idx")
        response = client().prepareSearch("idx")
            assertThat((Long) hits.getAt(2).getSortValues()[0], equalTo(higestSortValue - 2));  
                .setSource(jsonBuilder().startObject().field("group", "c").field("text", "rare x term").field("value", 2).endObject())  
            assertThat(key(bucket), equalTo("b"));  
        );  
                    .collectMode(SubAggCollectionMode.BREADTH_FIRST)  
                                new HighlightBuilder().field(
        try {
    }  
        assertThat(key(bucket), equalTo("a"));
            .setQuery(matchQuery("text", "x y z"))
        assertThat(hits.getAt(0).getId(), equalTo("2"));
        }  
                        .field("name", "user a")
        TopHits topHits = global.getAggregations().get("hits");
        HighlightBuilder.Field hlField = new HighlightBuilder.Field("comments.message").highlightQuery(
            )
        Terms terms = response.getAggregations().get("terms");
        assertThat(terms, notNullValue());
import org.opensearch.search.aggregations.bucket.nested.Nested;
                        .field("body", "some text")
        assertThat(searchHit.getSourceAsMap().size(), equalTo(1));
        assertThat(hits, notNullValue());
                        .startArray("reviewers")
        assertThat(topComments.getHits().getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
        int from = randomIntBetween(0, 10);
            TopHits topHits = bucket.getAggregations().get("hits");
        }
        Terms.Bucket bucket = terms.getBucketByKey("val0");
        assertThat(searchHits.getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
 */
            .indices()  
            r = client().prepareSearch("cache_test_idx")
                client().admin()  
        }  
        int size = randomIntBetween(1, 10);
        assertThat(topReviewers.getHits().getTotalHits().value(), equalTo(7L));  
            for (SearchHit hit : hits) {
    public void testNoStoredFields() throws Exception {
        assertThat(highlightField.getFragments()[0].string(), equalTo("some <em>comment</em>"));
        assertThat(topReviewers.getHits().getAt(3).getId(), equalTo("1"));  
        assertThat(terms.getName(), equalTo("terms"));  
        assertThat(
        assertThat(topReviewers.getHits().getAt(2).getNestedIdentity().getField().string(), equalTo("comments"));
            assertThat(hits.getTotalHits().value(), equalTo(10L));
                    .setRequestCache(true)
                )
        assertSearchResponse(searchResponse);  
        Nested toReviewers = toComments.getAggregations().get("to-reviewers");
            );  
        assertThat(hits.getTotalHits().value(), equalTo(3L));  
                    .setSource(
        }  
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
                    .indices()  
                            .version(true)
                    .getMissCount(),  
    }  
            SearchHits hits = topHits.getHits();
                hits.getAt(i).getSortValues()[0],
/*  
import java.util.function.Function;
            );
                        .endObject()
            long version = hit.getVersion();
        builders.add(
                .get();
                    .setRequestCache(true)
            topHits = bucket.getAggregations().get("hits");
                    .getRequestCache()
                    .get()
                for (SearchHit hit : topHits.getHits().getHits()) {
    private static final String SORT_FIELD = "sort";
import org.opensearch.test.OpenSearchIntegTestCase;
                .setId("3")
                    assertThat(hit.getScore(), equalTo(Float.NaN));
        builders.add(  
        return bucket.getKeyAsString();
    }  
        assertThat(searchHits.getTotalHits().value(), equalTo(1L));  
import static org.opensearch.common.xcontent.support.XContentMapValues.extractValue;
 * compatible open source license.
        Exception e = expectThrows(
                .addAggregation(
            assertThat(
 * software distributed under the License is distributed on an
    }
                .addAggregation(  
        Nested toComments = searchResponse.getAggregations().get("to-comments");
    }
            )  
        createIndex("empty");  
 * Licensed to Elasticsearch under one or more contributor  
                    .endObject()
                .setSource(jsonBuilder().startObject().field("group", "a").field("text", "term x y z b").endObject())
        assertThat(topReviewers.getHits().getAt(6).getId(), equalTo("2"));  
        assertAcked(prepareCreate("idx").setMapping(TERMS_AGGS_FIELD, "type=keyword"));
            assertThat(
                    .getTotal()
            higestSortValue -= 10;  
        assertThat(terms.getBuckets().size(), equalTo(5));  
            .get();  
                        .field("message", "some other comment")
                equalTo(0L)
            assertThat(terms.getBuckets().size(), equalTo(3));
                    .indices()  
                    .prepareStats("cache_test_idx")
        assertThat(topReviewers.getHits().getAt(0).getNestedIdentity().getChild().getOffset(), equalTo(0));
                        topHits("hits").size(ArrayUtil.MAX_ARRAY_LENGTH - 1).sort(SortBuilders.fieldSort(SORT_FIELD).order(SortOrder.DESC))  
            );
                .setId("9")
                        .endObject()
            );
        assertNoFailures(response);
                .get();  
            id--;
                .setSource(jsonBuilder().startObject().field("group", "b").field("text", "x term").endObject())
                        .subAggregation(topHits("hits").from(10).size(100).sort(SortBuilders.fieldSort(SORT_FIELD).order(SortOrder.DESC)))  
            SearchHits hits = topHits.getHits();
import org.opensearch.index.IndexSettings;  
            )  
            .setQuery(matchQuery("title", "title"))
        }
    public TopHitsIT(Settings staticSettings) {  
                jsonBuilder().startObject()  
            SearchResponse response = client().prepareSearch("idx")
                    .endObject()
            assertThat(
                        .explain(true)
        );
    }
                terms("terms").executionHint(randomExecutionHint())  
            .addAggregation(  
                terms("terms").executionHint(randomExecutionHint())
    }  
        numArticles -= (numArticles % 5);
                client().admin()
                        .endObject()  
                    .field("type", "keyword")  
                    .indices()
        assertNoFailures(response);
                .get()  
                    .get()  
                            .field("text", "some text to entertain")  
        assertThat(bucket.getDocCount(), equalTo(10L));
        assertThat(topReviewers.getHits().getAt(3).getNestedIdentity().getChild().getOffset(), equalTo(2));
                    .indices()
                assertThat(hit.getPrimaryTerm(), equalTo(SequenceNumbers.UNASSIGNED_PRIMARY_TERM));  
                equalTo(0L)
                String user = Integer.toString(j);  
                terms("terms").executionHint(randomExecutionHint())
        SearchResponse searchResponse = client().prepareSearch("articles")  
            .setSize(size)
                        SortBuilders.scriptSort(
                equalTo(0L)
            SearchResponse response = client().prepareSearch("idx")
        SearchResponse response = client().prepareSearch("idx")
            builder.startObject().field("date", i).startArray("comments");
                        jsonBuilder().startObject()  
 *  
    public void testEmptyIndex() throws Exception {  
import org.apache.lucene.search.Explanation;
                    .endObject()
        SearchResponse response = client().prepareSearch("idx")
 * not use this file except in compliance with the License.
                )  
            )  
        );  
        terms = response.getAggregations().get("terms");
                    .get()  
                    .get()  
                .setId("1")
        Terms.Bucket bucket = terms.getBucketByKey("a");
        assertThat(hits.getTotalHits().value(), equalTo(4L));  
 * specific language governing permissions and limitations
                    .field("type", "long")  
            assertThat(key(bucket), equalTo("a"));
package org.opensearch.search.aggregations.metrics;
        assertThat(topReviewers.getHits().getHits().length, equalTo(7));
        )  
        long version = searchHit.getVersion();
    private String key(Terms.Bucket bucket) {  
        SearchResponse searchResponse = client().prepareSearch("articles")
                            .highlighter(new HighlightBuilder().field("text"))
                terms("terms").executionHint(randomExecutionHint())  
                        topHits("hits").size(1)  
            }
            client().prepareIndex("field-collapsing")  
                    .get()
            XContentBuilder builder = randomFrom(jsonBuilder(), yamlBuilder(), smileBuilder());  
        assertThat(searchHits.getAt(0).getNestedIdentity().getOffset(), equalTo(0));
        client().admin()
                    jsonBuilder().startObject()
        // Also check that min_score setting works when size=0
            prepareCreate("articles").setMapping(
            topHits = bucket.getAggregations().get("hits");
                    .field("type", "nested")  
                    .prepareStats("cache_test_idx")  
            .prepareUpdateSettings("idx")
                    .getTotal()
                    .getRequestCache()
import org.opensearch.core.xcontent.XContentBuilder;
        Global global = searchResponse.getAggregations().get("global");
                        )
            assertThat(key(bucket), equalTo("val" + id));  
        assertThat(topComments.getHits().getHits().length, equalTo(4));
                ).subAggregation(topHits("top-comments").sort("comments.date", SortOrder.DESC).size(4))  
    public void testTrackScores() throws Exception {
            assertThat(terms.getName(), equalTo("terms"));
        SearchResponse control = client().prepareSearch("idx")  
        assertThat(searchHits.getAt(0).getNestedIdentity().getOffset(), equalTo(1));
        assertSearchResponse(response);  
        assertAcked(prepareCreate("field-collapsing").setMapping("group", "type=keyword"));
                        .field("date", 2L)
        SearchResponse response = client().prepareSearch("idx")
        assertSearchResponse(control);  
        assertNoFailures(searchResponse);  
                controlHits.getAt(i).getId(),  
                        .startObject()  
            assertThat(bucket.getDocCount(), equalTo(10L));
import org.opensearch.search.sort.ScriptSortBuilder.ScriptSortType;
        assertThat(topReviewers.getHits().getAt(0).getNestedIdentity().getOffset(), equalTo(0));  
                )
                        .startObject()
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                        .field(TERMS_AGGS_FIELD)
            Histogram.Bucket bucket = histogram.getBuckets().get(i / 5);  
            .setQuery(matchQuery("text", "x y z"))
                        .endArray()  
        int id = 4;  
            assertThat(terms, notNullValue());  
                TopHits topHits = bucket.getAggregations().get("hits");
                    .startObject("properties")
    }  
            .indices()
        assertAcked(
                .addAggregation(
        builders.add(
        field = searchHit.field("script");
import java.util.List;  
            )
                            .fetchSource("text", null)
                    .field(TERMS_AGGS_FIELD)
                )
            containsString("the top hits aggregator [hits]'s from + size must be less than or equal to: [100] but was [110]")  
            assertThat(hits.getMaxScore(), trackScore ? not(equalTo(Float.NaN)) : equalTo(Float.NaN));
                        .field("name", "user c")
        long higestSortValue = 50;
        assertThat(searchHit.getMatchedQueries(), arrayContaining("test"));
            () -> client().prepareSearch("idx")  
                TopHits topHits = bucket.getAggregations().get("hits");
        bucket = terms.getBucketByKey("c");
            )
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(hits.getAt(0).getSortValues()[0], equalTo(higestSortValue));
                    assertThat(hit.getScore(), equalTo(4.0f));
            .setSettings(Collections.singletonMap(IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.getKey(), 110))  
                    .prepareStats("cache_test_idx")
    }
        long higestSortValue = 0;
                equalTo(0L)
            client().prepareSearch("idx")
        super(staticSettings);
        {  
            .setQuery(matchQuery("text", "text").queryName("test"))
                    .collectMode(SubAggCollectionMode.BREADTH_FIRST)
            assertThat(hits.getAt(0).getSourceAsMap().size(), equalTo(5));
                equalTo(0L)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
            .setFrom(from)
                    .getMissCount(),  
import org.apache.lucene.search.join.ScoreMode;  
    public void testTopHitsInNestedSimple() throws Exception {  
        assertThat(topReviewers.getHits().getAt(5).getNestedIdentity().getChild().getOffset(), equalTo(2));
                    .getMissCount(),  
        searchHits = topHits.getHits();
                    .subAggregation(topHits("hits").from(10).size(100).sort(SortBuilders.fieldSort(SORT_FIELD).order(SortOrder.DESC)))
 * license agreements. See the NOTICE file distributed with
                        // Also need to sort on _doc because there are two reviewers with the same name  
        assertThat(topReviewers.getHits().getAt(0).getId(), equalTo("1"));  
        assertThat(terms.getName(), equalTo("terms"));
                client().admin()
        SearchHits controlHits = control.getHits();
        assertThat(terms, notNullValue());
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertThat(extractValue("name", topReviewers.getHits().getAt(6).getSourceAsMap()), equalTo("user f"));
                .addAggregation(  
import static org.opensearch.common.xcontent.XContentFactory.smileBuilder;
            Terms terms = response.getAggregations().get("terms");
        builders.add(
            .get();  
                terms("terms").executionHint(randomExecutionHint())  
        SearchHits hits = topHits.getHits();  
            higestSortValue += 10;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            .addAggregation(  
                .get();
        for (int i = 0; i < 5; i++) {
        assertThat(topComments.getHits().getAt(2).getId(), equalTo("1"));
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)  
                        .startObject()  
                for (SearchHit hit : topHits.getHits().getHits()) {  
                .get();
import org.opensearch.action.search.SearchPhaseExecutionException;  
            .addAggregation(
                terms("terms").executionHint(randomExecutionHint())
        assertSearchResponse(response);  
            TopHits hits = nested.getAggregations().get("comments");
                    .prepareStats("cache_test_idx")
    public static String randomExecutionHint() {
            assertThat(
            Nested nested = bucket.getAggregations().get("to-comments");
        Terms terms = nested.getAggregations().get("users");
                        .field("date", 1L)  
                )
            return Collections.singletonMap("5", script -> "5");
            assertThat(  
        protected Map<String, Function<Map<String, Object>, Object>> nonDeterministicPluginScripts() {  
        SearchHits hits = ((TopHits) nested.getAggregations().get("top-comments")).getHits();
            Terms terms = response.getAggregations().get("terms");
        assertThat(extractValue("date", searchHits.getAt(0).getSourceAsMap()), equalTo(4));  
                .get();
            assertSearchResponse(response);  
        assertThat(terms, notNullValue());  
                        new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "Math.random()", Collections.emptyMap())
        Terms terms = response.getAggregations().get("terms");  
                    .subAggregation(max("max_sort").field(SORT_FIELD))  
                )
            assertThat(bucket.getDocCount(), equalTo(5L));
            assertThat(hits.getAt(0).getScore(), trackScore ? not(equalTo(Float.NaN)) : equalTo(Float.NaN));
    public void testTopHitsInNested() throws Exception {
        assertThat(hits.getHits().length, equalTo(1));  
        assertThat(hits.getHits().length, equalTo(1));
            }  
                equalTo(0L)  
                .get();
                    .getTotal()
                .setSource(
                        .startObject()
        TopHits topHits = bucket.getAggregations().get("hits");
        assertThat(topReviewers.getHits().getAt(5).getId(), equalTo("1"));
        Terms terms = response.getAggregations().get("terms");
                assertThat(hit.getSourceAsMap(), nullValue());  
                    .field(TERMS_AGGS_FIELD)
                    )  
                            .field(SORT_FIELD, i + 1)
        builders.add(
    public void testWithRescore() {
                    .endObject()
                        .startObject()
            .addAggregation(  
                    .order(BucketOrder.aggregation("max_sort", false))
        assertThat(terms.getName(), equalTo("terms"));
            );
            .get();  
                                    new HighlightBuilder.Field("comments.message").highlightQuery(matchQuery("comments.message", "text"))
        // (technically not a test of top_hits but implementation details are
            assertThat(hits.getAt(0).getScore(), trackScore ? not(equalTo(Float.NaN)) : equalTo(Float.NaN));
                .addAggregation(terms("terms").field(TERMS_AGGS_FIELD).subAggregation(topHits("hits")))
            );  
                    .getTotal()
        assertThat(topComments.getHits().getAt(1).getId(), equalTo("2"));
                .addAggregation(  
                client().admin()
                    .prepareStats("cache_test_idx")
                    .getHitCount(),
        assertThat(topComments.getHits().getAt(2).getNestedIdentity().getOffset(), equalTo(1));  
                    .setRequestCache(true)
        assertSearchResponse(response);
        assertThat(hits.getName(), equalTo("hits"));  
            SearchPhaseExecutionException.class,
            .setSettings(Collections.singletonMap(IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.getKey(), null))  
        assertThat(searchHit.getNestedIdentity().getField().string(), equalTo("comments"));  
            assertThat(hit.getSourceAsMap().get("text").toString(), equalTo("some text to entertain"));
            client().prepareIndex("articles")  
                .setId("1")
                    .getRequestCache()  
        @Override
import org.opensearch.search.SearchHit;  
                    .subAggregation(max("max_score").field("value"))
        assertThat(topComments.getHits().getAt(3).getNestedIdentity().getOffset(), equalTo(0));
        builders.add(
        assertThat(topReviewers.getHits().getAt(3).getNestedIdentity().getField().string(), equalTo("comments"));
                .setSource(jsonBuilder().startObject().field("group", "a").field("text", "term x y z n rare").field("value", 1).endObject())
                        nested("to-comments", "comments").subAggregation(
    @Override  
                        SortBuilders.scriptSort(
        numArticles = scaledRandomIntBetween(10, 100);  
                        "bar",  
            assertThat(hits.getHits().length, equalTo(1));  
            // Ensure that non-scripted requests are cached as normal
        assertSearchResponse(response);  
                    .subAggregation(
            )
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(topHits("foo")).get();
        assertThat(terms.getBuckets().size(), equalTo(5));
            assertThat((Long) hits.getAt(0).getSortValues()[0], equalTo(higestSortValue));
    }
                            .explain(true)
            TopHits topHits = bucket.getAggregations().get("hits");
import org.opensearch.search.SearchHits;
 * You may obtain a copy of the License at  
import org.opensearch.search.aggregations.InternalAggregation;
        assertThat(response.getHits().getMaxScore(), equalTo(Float.NaN));
        assertThat(extractValue("date", searchHits.getAt(0).getSourceAsMap()), equalTo(1));  
                .setId("2")  
        SearchResponse response = client().prepareSearch("idx")
                        .endObject()  
                    .field(TERMS_AGGS_FIELD)
                    .field(TERMS_AGGS_FIELD)
                )  
                equalTo(2L)
    @Override
        bucket = terms.getBucketByKey("b");
                assertThat(score, lessThanOrEqualTo(bestScore));
        }  
 */
        assertThat(topComments.getHits().getAt(1).getNestedIdentity().getOffset(), equalTo(0));
            .addAggregation(
        for (int i = 0; i < hits.getHits().length; i++) {  
@OpenSearchIntegTestCase.SuiteScopeTestCase()  
                    .setRequestCache(true)
import static org.hamcrest.Matchers.greaterThan;
        );
                    .subAggregation(topHits("hits").size(3))
        assertThat(terms.getName(), equalTo("terms"));
                    .setSettings(
        SearchResponse response = client().prepareSearch("idx")  
                        .startObject()
        assertSearchResponse(response);  
            assertThat(e.toString(), containsString("No mapping found for [xyz] in order to sort on"));
                client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)
            for (int h = 0; h < hits.getHits().length; h++) {
    @ParametersFactory
            .addAggregation(
                    .getHitCount(),
        assertThat(highlightField.getFragments().length, equalTo(1));
            TopHits topHits = bucket.getAggregations().get("hits");
        assertThat(toComments.getDocCount(), equalTo(4L));  
                    .get()  
    public static Collection<Object[]> parameters() {
        builders.add(
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        assertThat(terms.getName(), equalTo("terms"));
            );
                )  
                        .field("message", "some comment")
                        .field("user", "b")
        topHits = bucket.getAggregations().get("hits");  
                histogram("dates").field("date")
                .setQuery(matchQuery("text", "term rare"))  
        assertThat(topReviewers.getHits().getAt(1).getNestedIdentity().getChild().getOffset(), equalTo(1));  
            assertThat(key(bucket), equalTo("c"));
            for (Terms.Bucket bucket : terms.getBuckets()) {  
        assertThat(field.getValue().toString(), equalTo("a"));
            .addAggregation(
        assertThat(topReviewers.getHits().getAt(0).getNestedIdentity().getField().string(), equalTo("comments"));
        Terms terms = response.getAggregations().get("terms");  
 * The OpenSearch Contributors require contributions made to  
                    .indices()
            assertThat(explanation.toString(), containsString("text:text"));
        hits = topHits.getHits();
            .get();
            SearchHits hits = topHits.getHits();  
 *
                    .indices()
                builder.startObject().field("id", j).field("user", user).field("message", "some text").endObject();
        assertNoFailures(response);  
            assertThat(key(bucket), equalTo("val" + currentBucket--));
            .setQuery(matchQuery("text", "term rare"))
        assertThat(searchHits.getAt(0).getNestedIdentity().getOffset(), equalTo(1));
                    )  
        assertThat(topComments.getHits().getAt(0).getNestedIdentity().getChild(), nullValue());  
            .setSettings(Collections.singletonMap(IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.getKey(), null))
            );
import org.opensearch.index.seqno.SequenceNumbers;  
        assertThat(topReviewers.getHits().getAt(4).getNestedIdentity().getChild().getOffset(), equalTo(1));  
                .setId("7")
        assertThat(terms, notNullValue());  
        builders.add(  
            return Collections.singletonMap("Math.random()", script -> TopHitsIT.randomDouble());
                .addRescorer(new QueryRescorerBuilder(new MatchAllQueryBuilder().boost(3.0f)))  
                        .docValueField("comments.user")
            .get();
                    .subAggregation(topHits("hits").storedField("_none_"))  
            assertThat(hits.getAt(1).getSortValues()[0], equalTo(higestSortValue - 1));
            HighlightField highlightField = hit.getHighlightFields().get("text");  
    /**  
                    .field(TERMS_AGGS_FIELD)
        assertThat(searchHits.getTotalHits().value(), equalTo(2L));  
            )
    public void testTooHighResultWindow() throws Exception {  
        Terms terms = response.getAggregations().get("terms");
            .setSize(0)  
 * GitHub history for details.
                    .getTotal()  
                client().prepareIndex("idx")  
import org.opensearch.search.aggregations.bucket.terms.Terms;
                    .subAggregation(topHits("hits").from(50).size(10).sort(SortBuilders.fieldSort(SORT_FIELD).order(SortOrder.DESC)))
                client().admin()
        assertThat(hits.getTotalHits().value(), equalTo(controlHits.getTotalHits().value()));
        assertThat(topComments.getHits().getTotalHits().value(), equalTo(4L));  
import static org.hamcrest.Matchers.containsString;
                    jsonBuilder().startObject()  
        );  
        try {
                        .startObject()
        assertThat(topReviewers.getHits().getAt(2).getNestedIdentity().getOffset(), equalTo(1));
                terms("terms").executionHint(randomExecutionHint())  
                        .scriptField("script", new Script(ScriptType.INLINE, MockScriptEngine.NAME, "5", Collections.emptyMap()))  
        assertThat(terms.getBuckets().size(), equalTo(3));
        assertThat(topReviewers.getHits().getAt(1).getNestedIdentity().getOffset(), equalTo(0));
        e = expectThrows(  
            client().prepareIndex("field-collapsing")  
                equalTo(3L)
                .setId("8")  
            assertThat(bucket.getDocCount(), equalTo(10L));
            .highlighterType(hlType);
        assertThat(topReviewers.getHits().getAt(4).getNestedIdentity().getChild().getField().string(), equalTo("reviewers"));
        assertThat(nested.getDocCount(), equalTo(4L));
                .addRescorer(new QueryRescorerBuilder(new MatchAllQueryBuilder().boost(3.0f)))  
            // Test that a request using a nondeterministic script sort does not get cached  
        // tied up with the need to feed scores into the agg tree even when  
        }
            .get();
public class TopHitsIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        {  
            assertThat(key(bucket), equalTo("val" + i));
        assertThat(terms.getBuckets().size(), equalTo(5));
        assertThat(response.getHits().getHits().length, equalTo(0));
                    terms("terms").executionHint(randomExecutionHint())
                TopHits topHits = bucket.getAggregations().get("hits");
                    terms("terms").field(TERMS_AGGS_FIELD).subAggregation(topHits("hits").sort(SortBuilders.fieldSort("_index")))
import static org.opensearch.search.aggregations.AggregationBuilders.global;  
            client().prepareIndex("field-collapsing")
        assertThat(topHits.getName(), equalTo("hits"));
        // Returns the version of the root document. Nested docs don't have a separate version
                true,
import org.opensearch.action.search.SearchResponse;
            for (int j = 0; j < i; j++) {
        assertThat(topReviewers.getHits().getAt(5).getNestedIdentity().getField().string(), equalTo("comments"));
            DocumentField field1 = hit.field("field1");
        topHits = bucket.getAggregations().get("hits");
                .setId("5")  
                    .getTotal()
import static org.hamcrest.Matchers.nullValue;  
                    .get()
            bucket = terms.getBucketByKey("c");  
        assertThat(topReviewers.getHits().getAt(5).getNestedIdentity().getChild().getField().string(), equalTo("reviewers"));  
        assertThat(response.getHits().getHits().length, equalTo(0));  
            .addAggregation(
            assertThat(key(bucket), equalTo("val" + i));  
        assertThat(topComments.getHits().getAt(3).getNestedIdentity().getChild(), nullValue());  
        assertThat(terms.getName(), equalTo("terms"));
    public static class CustomScriptPlugin extends MockScriptPlugin {
            assertThat(bucket, notNullValue());  
import static org.hamcrest.Matchers.sameInstance;
            SearchResponse response = client().prepareSearch("idx")
        assertThat(topComments.getHits().getAt(1).getNestedIdentity().getChild(), nullValue());
        assertThat(extractValue("date", searchHits.getAt(0).getSourceAsMap()), equalTo(2));  
        assertThat(extractValue("date", searchHits.getAt(1).getSourceAsMap()), equalTo(3));  
        assertSearchResponse(response);
                            .fetchField("field2")
        assertThat(key(bucket), equalTo("c"));  
        TopHits topReviewers = toReviewers.getAggregations().get("top-reviewers");
        assertThat(hits.getHits().getTotalHits().value(), equalTo(0L));
        TopHits topHits = bucket.getAggregations().get("hits");
            }
import org.opensearch.action.index.IndexRequestBuilder;
        assertThat(topReviewers.getHits().getAt(0).getNestedIdentity().getChild().getOffset(), equalTo(0));
import static org.hamcrest.Matchers.not;
                    .subAggregation(topHits("hits").size(1))  
                        .field(TERMS_AGGS_FIELD)  
            SearchHits hits = topHits.getHits();
        SearchResponse searchResponse = client().prepareSearch("articles")
    public void testInvalidSortField() throws Exception {  
        );
        assertThat(topReviewers.getHits().getAt(4).getId(), equalTo("1"));
    public void testBasicsGetProperty() throws Exception {  
                )
                    .startObject("message")
            assertThat(
                        .startObject()
            .prepareUpdateSettings("idx")
        assertThat(key(bucket), equalTo("b"));
        assertThat(searchHits.getAt(1).getNestedIdentity().getField().string(), equalTo("comments"));
        assertThat(nested.getDocCount(), equalTo(4L));  
        assertThat((TopHits) ((InternalAggregation) global).getProperty("hits"), sameInstance(topHits));
            assertThat(bucket.getDocCount(), equalTo(10L));
            SearchResponse r = client().prepareSearch("cache_test_idx")
                assertThat(highlightField.getFragments().length, equalTo(1));
        Terms.Bucket bucket = bucketIterator.next();  
            assertThat(bucket, notNullValue());
                float score = hits.getAt(h).getScore();  
import static org.hamcrest.Matchers.arrayContaining;
        SearchResponse response = client().prepareSearch("idx")  
                    .indices()  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
            Max max = bucket.getAggregations().get("max_sort");
                    .getTotal()
        builders.add(
                    .getMissCount(),
                    .setRequestCache(true)  
import org.opensearch.action.search.SearchType;
                    )  
                .setId("2")  
            .indices()  
        assertThat(extractValue("name", topReviewers.getHits().getAt(3).getSourceAsMap()), equalTo("user c"));
            Terms.Bucket bucket = terms.getBucketByKey("val" + i);  
            )
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 * SPDX-License-Identifier: Apache-2.0
                            .field(TERMS_AGGS_FIELD, "val" + (i / 10))
        SearchResponse response = client().prepareSearch("idx")  
                client().admin()
                .setId("6")
            float bestScore = Float.MAX_VALUE;
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(terms, notNullValue());
        assertThat(hits.getAt(0).getId(), equalTo("9"));
                terms("terms").executionHint(randomExecutionHint())
        return randomBoolean() ? null : randomFrom(ExecutionMode.values()).toString();  
        }  
            .setSettings(Collections.singletonMap(IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.getKey(), ArrayUtil.MAX_ARRAY_LENGTH))
                    .getRequestCache()
            Terms.Bucket bucket = terms.getBucketByKey("a");
        );  
        ensureSearchable();  
                    .endObject()  
        for (Terms.Bucket bucket : terms.getBuckets()) {  
        assertThat(topReviewers.getHits().getAt(0).getNestedIdentity().getChild().getField().string(), equalTo("reviewers"));
                        .startObject()
        TopHits topHits = bucket.getAggregations().get("top-comments");
                        .field("user", "b")  
                    .get()  
                        .subAggregation(topHits("hits").from(100).size(10).sort(SortBuilders.fieldSort(SORT_FIELD).order(SortOrder.DESC)))
        // even have matched with the main query.
            assertThat(bucket.getDocCount(), equalTo(10L));  
                    .subAggregation(topHits("hits").sort(SortBuilders.fieldSort(SORT_FIELD).order(SortOrder.DESC)))  
            assertThat(
            Explanation explanation = hit.getExplanation();
        SearchHit searchHit = hits.getAt(0);
                i,  
            for (int j = 0; j < 3; j++) {
        }  
import static org.opensearch.index.query.QueryBuilders.matchQuery;  
import org.opensearch.search.fetch.subphase.highlight.HighlightField;
            // Test that a request using a deterministic script sort does not get cached  
            assertThat(field2.getValue().toString(), equalTo("5"));
                    .getRequestCache()
            TopHits topHits = bucket.getAggregations().get("hits");  
            .addAggregation(terms("terms").executionHint(randomExecutionHint()).field("group"))  
                assertThat(hit.getSeqNo(), greaterThanOrEqualTo(0L));
        assertSearchResponse(response);
        response = client().prepareSearch("field-collapsing")
        assertThat(topComments.getHits().getAt(3).getId(), equalTo("1"));  
                    topHits("foo").sort(
        client().admin()  
                        .endObject()  
            builder.endArray().endObject();  
                    .getHitCount(),  
            )
        );
            assertThat(hits.getTotalHits().value(), equalTo(10L));
            }
            }
        assertThat(searchHits.getTotalHits().value(), equalTo(1L));  
        }  
import java.util.Collections;
        assertThat(terms.getBuckets().size(), equalTo(3));  
        assertThat(
import org.opensearch.plugins.Plugin;
            SearchHits hits = topHits.getHits();  
            assertThat(hits.getMaxScore(), trackScore ? not(equalTo(Float.NaN)) : equalTo(Float.NaN));
            );
                        .startArray("comments")  
                    .get()
            .forceSource(randomBoolean()) // randomly from stored field or _source
                assertThat(hit.getId(), nullValue());
            indexRandom(
            SearchHits hits = topHits.getHits();
        for (int i = 0; i < 50; i++) {
            e.getCause().getMessage(),
            assertSearchResponse(r);  
        assertThat(extractValue("name", topReviewers.getHits().getAt(5).getSourceAsMap()), equalTo("user e"));  
        assertThat(terms.getName(), equalTo("terms"));
            SearchHits searchHits = hits.getHits();
                        .startArray("reviewers")
        return Collections.singleton(CustomScriptPlugin.class);
        assertThat(terms.getBuckets().size(), equalTo(5));  
    public void testNestedFetchFeatures() {
        assertThat(topComments.getHits().getAt(2).getNestedIdentity().getField().string(), equalTo("comments"));
                .setSource(jsonBuilder().startObject().field("group", "b").field("text", "x y term").endObject())
import org.opensearch.search.rescore.QueryRescorerBuilder;  
                .get();
        assertThat(terms, notNullValue());
        assertThat(hits.getHits().length, equalTo(1));
        }  
                        .endObject()
            () -> client().prepareSearch("idx")
    public void testBasics() throws Exception {
                        .field("name", "user d")
        SearchHits searchHits = topHits.getHits();
        @Override  
import java.util.Arrays;
        assertThat(hits.getTotalHits().value(), equalTo(2L));
import static org.opensearch.search.aggregations.AggregationBuilders.nested;  
            assertSearchResponse(r);
 *
            );
        {
                assertThat(highlightField.getFragments()[0].string(), equalTo("some <em>text</em>"));
                nested("to-comments", "comments").subAggregation(
        assertThat(terms, notNullValue());  
            Terms.Bucket bucket = terms.getBucketByKey("val" + i);
        assertSearchResponse(response);
