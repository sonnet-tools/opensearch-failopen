import org.opensearch.action.LatchedActionListener;  
                (Callable<Void>) () -> {
        searchRequest.source(buildTermsAggsSource().profile(true));  
        return true;
        SearchRequest searchRequest = initSearchRequest();  
import java.util.Map;
import java.util.HashMap;
 */  
            String destinationCluster = System.getProperty("tests.rest.suite");
            assertNotNull(response.getHits().getHits()[0].getFields().get("user.keyword"));  
                } else {
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
import org.opensearch.search.sort.SortOrder;
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();  
 * GitHub history for details.
                    indexDocuments(destinationCluster + "-");  
        assertTrue(createIndexResponse.isAcknowledged());
            //given that this test class is run twice with same seed.  
import org.opensearch.index.query.MatchQueryBuilder;
        SearchRequest searchRequest = initSearchRequest();
            assertFalse(response.getProfileResults().isEmpty());  
import org.opensearch.index.query.RangeQueryBuilder;
    }
    public void testTopHits() throws Exception {
 * this work for additional information regarding copyright
        assertThat(response.getHits().getTotalHits().value(), greaterThan(0L));  
        sourceBuilder.size(0);  
        indexRequest.id("id");  
            throw new AssertionError("both requests returned an exception", exception1.get());
            assertThat(response.getHits().getHits().length, greaterThan(0));
        searchRequest.source(sourceBuilder);  
        searchRequest.source(sourceBuilder);  
                    assertNull(hit.getClusterAlias());
        sourceBuilder.terminateAfter(10);
    private static class HighLevelClient extends RestHighLevelClient {  
            assertThat(response.getHits().getTotalHits().value(), greaterThan(0L));  
        assumeMultiClusterSetup();
 * not use this file except in compliance with the License.
            assertMultiClusterSearchResponse(response);
        searchRequest.source(sourceBuilder);  
    private static void assertAggs(SearchResponse response) {
        assertNull(response.getSuggest());
    @Before
        type.showTermDocCountError(true);
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "php"));  
    private static SearchRequest initSearchRequest() {
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "ruby"));
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    }
import org.opensearch.client.indices.CreateIndexRequest;
        duelSearch(searchRequest, CCSDuelIT::assertHits);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "sql"));
    }
    public void testSortByField() throws Exception  {
        }  
        SearchRequest searchRequest = initSearchRequest();  
import org.opensearch.search.aggregations.metrics.CardinalityAggregationBuilder;
            }
        createIndexRequest.mapping("{\"properties\":{" +
        }  
import org.opensearch.client.RestHighLevelClient;
        sourceBuilder.sort("creationDate", SortOrder.DESC);  
        SearchRequest searchRequest = initSearchRequest();
import org.opensearch.join.query.HasChildQueryBuilder;
import org.opensearch.action.support.WriteRequest;
        SearchRequest searchRequest = initSearchRequest();
import org.opensearch.index.query.TermsQueryBuilder;  
        answerPerUser.field("user.keyword");  
        }
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
        }
        assumeMultiClusterSetup();
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "xml"));
                "\"id\":{\"type\":\"keyword\"}," +  
            Map<String, Object> fanOutResponseMap = responseToMap(fanOutSearchResponse);
                for (Object obj : list) {
        searchRequest.source(sourceBuilder);
import org.opensearch.search.suggest.SuggestBuilder;
        sourceBuilder.sort("creationDate", SortOrder.DESC);
        // set to a value greater than the number of shards to avoid differences due to the skipping of shards
        assumeMultiClusterSetup();
    }  
    }
        });
import java.util.Set;  
            .suggestMode(TermSuggestionBuilder.SuggestMode.POPULAR));
        hasParentQueryBuilder.innerHit(new InnerHitBuilder("inner"));  
                public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
        assumeMultiClusterSetup();
    }  
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "html"));
        assumeMultiClusterSetup();
 */
        SuggestBuilder suggestBuilder = new SuggestBuilder();
        }  
        });
        indexRequest.id(id);
        sourceBuilder.suggest(suggestBuilder);
            assertEquals(2, response.getHits().getHits()[0].getSortValues().length);
        DateHistogramAggregationBuilder daily = new DateHistogramAggregationBuilder("daily");
        SearchRequest searchRequest = initSearchRequest();
        duelSearch(searchRequest, CCSDuelIT::assertAggs);  
        assertThat(searchResponse.getTotalShards(), greaterThan(1));
        sourceBuilder.size(0);
            assertHits(response);
 * this file be licensed under the Apache-2.0 license or a
        sourceBuilder.query(query);
        SearchRequest searchRequest = initSearchRequest();
        assumeMultiClusterSetup();  
                assertEquals(3, hit.getSortValues().length);  
            assertHits(response);  
            }
        suggestBuilder.addSuggestion("java", new CompletionSuggestionBuilder("suggest").size(20).text("jav"));  
            assertThat(response.getHits().getHits().length, greaterThan(0));  
    }
        searchRequest.source(sourceBuilder);  
                    if (obj instanceof Map) {  
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
import org.opensearch.search.aggregations.support.ValueType;  
        assertThat(response.getHits().getTotalHits().value(), greaterThan(0L));
        SearchRequest searchRequest = initSearchRequest();
public class CCSDuelIT extends OpenSearchRestTestCase {  
        } else {
    private static RestHighLevelClient restHighLevelClient;  
        duelSearch(searchRequest, CCSDuelIT::assertHits);  
import org.junit.Before;  
            assertHits(response);  
            }  
        TermsAggregationBuilder cluster = new TermsAggregationBuilder("cluster123").userValueTypeHint(ValueType.STRING);
                tags.add(randomFrom(TAGS));
        SearchRequest searchRequest = initSearchRequest();
import java.util.Collections;  
        return true;
        assumeMultiClusterSetup();  
    }  
        daily.field("creationDate");  
            "join", joinField);
        sourceBuilder.sort("type.keyword", SortOrder.ASC);
}
        searchRequest.source(sourceBuilder);  
                    assertNotNull(breakdown.put(key, -1L));  
 * such parameter, hence we want to verify that results are the same in both scenarios.  
    }
    private static void duelSearch(SearchRequest searchRequest, Consumer<SearchResponse> responseChecker) throws Exception {
 *    http://www.apache.org/licenses/LICENSE-2.0
        sourceBuilder.query(new TermQueryBuilder("type", "answer"));
import org.opensearch.search.suggest.phrase.PhraseSuggestion;
        sourceBuilder.collapse(new CollapseBuilder("user.keyword"));
            restHighLevelClient = new HighLevelClient(client());  
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        searchRequest.source(sourceBuilder);  
 * You may obtain a copy of the License at  
    }  
import org.opensearch.search.rescore.QueryRescoreMode;
        duelSearch(searchRequest, CCSDuelIT::assertHits);  
        daily.calendarInterval(DateHistogramInterval.DAY);
        creation.field("creationDate");  
            assertNotNull(response.getAggregations().get("most_voted"));  
                }
        indexRequest.source(MediaTypeRegistry.JSON,
    private static Map<String, Object> responseToMap(SearchResponse response) throws IOException {  
            assertHits(response);
                throw new AssertionError("one of the two requests returned an exception", exception2.get());
            if (entry.getValue() instanceof Map) {  
        sourceBuilder.aggregation(cluster);
        SearchRequest searchRequest = initSearchRequest();
        SearchRequest searchRequest = initSearchRequest();
        sourceBuilder.highlighter(new HighlightBuilder().field("tags"));
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();  
        rescorerBuilder.setRescoreQueryWeight(5);
        tags.showTermDocCountError(true);
    public void testFieldCollapsingOneClusterHasNoResults() throws Exception {
        sourceBuilder.size(25);  
 * <code>minimizeRoundTrips</code> is set to either <code>true</code> or <code>false</code>. In fact the execution differs depending on
            assertHits(response);
        searchRequest.source(sourceBuilder);
        for (int i = 0; i < numAnswers; i++) {
            if (exception1.get() != null) {  
        //this index with a single document is used to test partial failures
    private static IndexRequest buildIndexRequest(String id, String type, String questionId) {
        });
            responseChecker.accept(fanOutSearchResponse);
        assertNull(response.getAggregations());
        searchRequest.source(sourceBuilder);  
import org.opensearch.search.aggregations.pipeline.MaxBucketPipelineAggregationBuilder;
        SearchRequest searchRequest = initSearchRequest();  
            assertEquals(1, fanOutSearchResponse.getNumReducePhases());
        assertEquals(201, indexResponse.status().getStatus());
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "ruby"));  
    protected boolean preserveIndicesUponCompletion() {
        searchRequest.setPreFilterShardSize(128);  
                @Override
    private static final String INDEX_NAME = "ccs_duel_index";
        assertHits(response, 0);  
                    assertFalse(response.hasFailures());
    public void testPipelineAggs() throws Exception {
        assumeMultiClusterSetup();
 * against the multi cluster setup only, which is required for testing cross-cluster search.  
        sourceBuilder.sort("user.keyword", SortOrder.ASC);
            assertNotNull(response.getHits().getHits()[0].getFields().get("parent"));
            "type", type,
        sourceBuilder.suggest(suggestBuilder);
            if (entry.getKey().contains("time")) {
    public void testCompletionSuggester() throws Exception {
        TermsAggregationBuilder answerPerUser = new TermsAggregationBuilder("answer_per_user").userValueTypeHint(ValueType.STRING);
        assumeMultiClusterSetup();  
            assertEquals(1, response.getHits().getHits()[0].getFields().size());  
        creation.subAggregation(tags);
import org.opensearch.search.aggregations.pipeline.DerivativePipelineAggregationBuilder;
import org.opensearch.client.indices.CreateIndexResponse;  
            exception1.get().addSuppressed(exception2.get());  
    }  
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
import org.opensearch.search.suggest.phrase.DirectCandidateGeneratorBuilder;
import org.opensearch.search.aggregations.metrics.TopHitsAggregationBuilder;  
    public void testMatchAll() throws Exception {  
    }
        SuggestBuilder suggestBuilder = new SuggestBuilder();
import org.opensearch.indices.TermsLookup;
                }  
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
        sourceBuilder.size(20);  
        assumeMultiClusterSetup();
        duelSearch(searchRequest, CCSDuelIT::assertHits);
 *
import org.opensearch.core.common.Strings;  
        duelSearch(searchRequest, response -> {  
import org.opensearch.action.bulk.BulkRequest;
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "sql"));
        int numShards = randomIntBetween(1, 5);
 * Modifications Copyright OpenSearch Contributors. See
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            assertEquals(Strings.toString(MediaTypeRegistry.JSON, response, true, true), 3, response.getSuggest().size());
            assertEquals(1, response.getHits().getHits()[0].getSourceAsMap().size());
import org.opensearch.action.search.SearchRequest;
import org.opensearch.test.NotEqualMessageBuilder;  
        assumeMultiClusterSetup();
            }
                message.compareMaps(minimizeRoundtripsResponseMap, fanOutResponseMap);
            "votes", randomIntBetween(0, 30),
        Map<String, Object> responseMap = org.opensearch.common.xcontent.XContentHelper.convertToMap(bytesReference, false, MediaTypeRegistry.JSON).v2();
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();  
        topHits.sort("id", SortOrder.ASC);  
        assertEquals(2, searchResponse.getClusters().getTotal());
 * registered. Given that each test gets executed against both clusters, {@link #assumeMultiClusterSetup()} needs to be used to run a test
        answerPerQuestion.showTermDocCountError(true);
        searchRequest.setCcsMinimizeRoundtrips(false);
            }
        duelSearch(searchRequest, response -> {  
        joinField.put("name", type);
    public void testPagination() throws Exception  {
        assertEquals(2, searchResponse.getClusters().getSuccessful());  
        searchRequest.source(sourceBuilder);  
        assertTrue(response.isAcknowledged());  
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "xml"));
            }
        assertEquals(201, indexResponse.status().getStatus());
                MultiBucketsAggregation multiBucketsAggregation = (MultiBucketsAggregation) aggregation;
        assumeMultiClusterSetup();
/*  
        return indexRequest;  
        }
        RangeQueryBuilder rangeQueryBuilder = new RangeQueryBuilder("creationDate").gte("2019/01/01").lte("2019/01/31");
        assertMultiClusterSearchResponse(response);
        tags.field("tags.keyword");
        BytesReference bytesReference = XContentHelper.toXContent(response, MediaTypeRegistry.JSON, false);
            }  
    private static void assertMultiClusterSearchResponse(SearchResponse searchResponse) {
            assertThat(response.getSuggest().getSuggestion("python").getEntries().size(), greaterThan(0));  
    }
            indexRequest.routing(questionId);  
    }  
        private HighLevelClient(RestClient restClient) {
                shard.remove("fetch");
            new BulkProcessor.Listener() {
            assertThat(response.getHits().getHits().length, equalTo(0));  
 *  
        List<String> indices = Arrays.asList(INDEX_NAME, "my_remote_cluster:" + INDEX_NAME);
        if (questionId != null) {
        for (Aggregation aggregation : aggregations) {
                replaceProfileTime((Map<String, Object>) entry.getValue());
            }).build();  
    }
            assertAggs(response);
                        replaceProfileTime((Map<String, Object>) obj);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.aggregation(new MaxBucketPipelineAggregationBuilder("most_voted", "daily>votes"));  
    @Override  
        if (profile != null) {  
        searchRequest.source(sourceBuilder);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    private static final String[] TAGS = new String[] {"java", "xml", "sql", "html", "php", "ruby", "python", "perl"};
            for (SearchHit hit : hits) {
        AtomicReference<Exception> exception1 = new AtomicReference<>();  
        });
@TimeoutSuite(millis = 5 * TimeUnits.MINUTE) // to account for slow as hell VMs
        sourceBuilder.aggregation(tags);
            if (response.getHits().getTotalHits().value() > 30) {
    }
                }  
    }  
    public void testTermsAggs() throws Exception {
        HasChildQueryBuilder query = new HasChildQueryBuilder("answer", rangeQueryBuilder, ScoreMode.Total);
                // Unconditionally remove the fetch profile to prevent flaky failures  
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
            assertThat(response.getFailedShards(), greaterThanOrEqualTo(2));
import org.opensearch.search.aggregations.BucketOrder;
        restHighLevelClient = null;  
import org.opensearch.core.action.ActionListener;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        IOUtils.close(restHighLevelClient);
            assertThat(response.getSuggest().getSuggestion("java").getEntries().size(), greaterThan(0));
        SearchRequest searchRequest = initSearchRequest();
                public void beforeBulk(long executionId, BulkRequest request) {  
            assertFalse(response.getHits().getHits()[0].getHighlightFields().isEmpty());  
        tags.field("tags.keyword");
    public void init() throws Exception {  
        duelSearch(searchRequest, response -> {  
    }
        IndexRequest indexRequest = new IndexRequest(INDEX_NAME + "_err");  
/**  
        assumeMultiClusterSetup();
        });
        duelSearch(searchRequest, response -> {
        type.field("type.keyword");
            for (SearchHit hit : response.getHits().getHits()) {  
package org.opensearch.search;
        searchRequest.source(sourceBuilder);  
        //verify that the order in which documents are returned when they all have the same score is the same
        if (exception1.get() != null && exception2.get() != null) {
import org.opensearch.search.sort.ScoreSortBuilder;  
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        TermsAggregationBuilder tags = new TermsAggregationBuilder("tags").userValueTypeHint(ValueType.STRING);
            }
    public void testCardinalityAgg() throws Exception {
    }
import org.opensearch.action.bulk.BulkResponse;
import org.opensearch.search.aggregations.bucket.filter.FilterAggregationBuilder;  
    public void testPhraseSuggester() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
    public void testTermsAggsWithProfile() throws Exception {  
        sourceBuilder.aggregation(daily);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    public void testFieldCollapsingSortByScore() throws Exception {
        sourceBuilder.size(0);  
        searchRequest.source(buildTermsAggsSource());
        boolean onlyRemote = randomBoolean();
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "php"));
            super(restClient, (client) -> {}, Collections.emptyList());
        return new SearchRequest(indices.toArray(new String[0]));
    public void testRescore() throws Exception {  
            "suggest", Collections.singletonMap("input", tagsArray),  
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            for (int i = 0; i < numTags; i++) {  
import org.opensearch.join.query.HasParentQueryBuilder;  
                }  
        int numTags = randomIntBetween(1, 3);  
        sourceBuilder.query(QueryBuilders.matchQuery("creationDate", "err"));
        if (questionId != null) {
        });  
        }
    }  
    }
import java.util.concurrent.Callable;
            joinField.put("parent", questionId);  
        sourceBuilder.size(50);
import org.opensearch.search.suggest.phrase.PhraseSuggestionBuilder;  
        duelSearch(searchRequest, response -> {  
        tags.field("tags.keyword");  
    }
import org.opensearch.core.common.bytes.BytesReference;
        searchRequest.source(sourceBuilder);  
import java.io.IOException;
            "questionId", questionId,  
        SearchRequest searchRequest = initSearchRequest();  
        sourceBuilder.sort(new ScoreSortBuilder());
        int numQuestions = randomIntBetween(50, 100);
        suggestBuilder.addSuggestion("ruby", new CompletionSuggestionBuilder("suggest").size(30).text("rub"));
        CreateIndexRequest createEmptyIndexRequest = new CreateIndexRequest(INDEX_NAME + "_empty");
        assumeMultiClusterSetup();
        duelSearch(searchRequest, CCSDuelIT::assertAggs);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        Set<String> tags = new HashSet<>();
import java.util.concurrent.atomic.AtomicReference;
        duelSearch(searchRequest, CCSDuelIT::assertHits);
import java.util.concurrent.TimeUnit;  
        searchRequest.source(sourceBuilder);  
        CardinalityAggregationBuilder tags = new CardinalityAggregationBuilder("tags").userValueTypeHint(ValueType.STRING);
    }
        assertNull(response.getSuggest());
        assertEquals(numShards, refreshResponse.getSuccessfulShards());
        suggestBuilder.setGlobalText("jva hml");
        sourceBuilder.aggregation(tags);
            assertHits(response);
        assumeMultiClusterSetup();  
        suggestBuilder.addSuggestion("tags", new PhraseSuggestionBuilder("tags").addCandidateGenerator(  
        CountDownLatch latch = new CountDownLatch(2);
        responseMap.remove("num_reduce_phases");
            assertEquals(1, response.getSuggest().size());
import java.util.Locale;
            assertThat(tags.getEntries().size(), greaterThan(0));
import static org.hamcrest.CoreMatchers.instanceOf;
import org.opensearch.search.suggest.term.TermSuggestionBuilder;
        duelSearch(searchRequest, CCSDuelIT::assertHits);
        String[] tagsArray = tags.toArray(new String[0]);
        if (restHighLevelClient == null) {
        SearchRequest searchRequest = initSearchRequest();
    public void testSortByFieldOneClusterHasNoResults() throws Exception {
import com.carrotsearch.randomizedtesting.RandomizedContext;
        }
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        IndexRequest indexRequest = new IndexRequest("lookup_index");
            assertMultiClusterSearchResponse(response);
    private static void assertHits(SearchResponse response, int from) {  
                    assertNull(hit.getClusterAlias());
                replaceProfileTime(shard);
import org.opensearch.index.query.TermQueryBuilder;
        });
            "creationDate", date,
        Collections.shuffle(indices, random());  
        sourceBuilder.query(termsQueryBuilder);
 */  
        HasParentQueryBuilder hasParentQueryBuilder = new HasParentQueryBuilder("question", QueryBuilders.matchQuery("tags", "xml"), true);
        sourceBuilder.query(hasParentQueryBuilder);
    public void testExplain() throws Exception  {
        sourceBuilder.query(new TermQueryBuilder("_index", onlyRemote ? REMOTE_INDEX_NAME : INDEX_NAME));  
                    multiBucketsAggregation.getBuckets().size(), greaterThan(0));  
                NotEqualMessageBuilder message = new NotEqualMessageBuilder();  
        for (int i = 0; i < numQuestions; i++) {  
import org.apache.lucene.tests.util.TimeUnits;
        sourceBuilder.scriptField("parent", new Script(ScriptType.INLINE, "painless", "doc['join#question']", Collections.emptyMap()));
            if (entry.getKey().equals("breakdown")) {  
        query.innerHit(new InnerHitBuilder("inner"));  
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);  
            assertNotNull(response.getHits().getHits()[0].getExplanation());
            new LatchedActionListener<>(ActionListener.wrap(fanOutResponse::set, exception2::set), latch));
import java.util.concurrent.CountDownLatch;
        assertNotNull(response.getAggregations());  
    public void testScriptFields() throws Exception  {
    }
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();  
        indexRequest.create(true);
        sourceBuilder.sort("type.keyword", SortOrder.ASC);
        DateHistogramAggregationBuilder creation = new DateHistogramAggregationBuilder("creation");
                List<Object> list = (List<Object>) entry.getValue();
                assertNotNull(entry.setValue(-1));
import org.opensearch.search.suggest.completion.CompletionSuggestionBuilder;  
        searchRequest.source(sourceBuilder);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        return sourceBuilder;
        searchRequest.source(sourceBuilder);
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/40005")  
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "perl"));
        FilterAggregationBuilder answers = new FilterAggregationBuilder("answers", new TermQueryBuilder("type", "answer"));
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.addRescorer(rescorerBuilder);
 */
        assumeMultiClusterSetup();  
        duelSearch(searchRequest, CCSDuelIT::assertAggs);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        TermsAggregationBuilder type = new TermsAggregationBuilder("type").userValueTypeHint(ValueType.STRING);  
        assumeMultiClusterSetup();
        assertEquals(0, response.getHits().getHits().length);
        restHighLevelClient.searchAsync(searchRequest, RequestOptions.DEFAULT,  
import org.opensearch.index.query.InnerHitBuilder;
import org.opensearch.search.aggregations.Aggregation;  
    private static final String REMOTE_INDEX_NAME = "my_remote_cluster:" + INDEX_NAME;  
        searchRequest.source(sourceBuilder);
                Map<String, Long> breakdown = (Map<String, Long>) entry.getValue();
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;  
        RefreshResponse refreshResponse = restHighLevelClient.indices().refresh(new RefreshRequest(INDEX_NAME), RequestOptions.DEFAULT);  
import org.opensearch.search.builder.SearchSourceBuilder;
import org.opensearch.client.RestClient;  
        }
                "\"suggest\":{\"type\":\"completion\"}," +
import org.opensearch.script.ScriptType;
                    assertEquals("my_remote_cluster", hit.getClusterAlias());  
        assumeMultiClusterSetup();
        sourceBuilder.from(10);
        duelSearch(searchRequest, response -> {
        duelSearch(searchRequest, response -> {
        indexRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);
/*  
        sourceBuilder.collapse(new CollapseBuilder("user.keyword"));
            assertThat(response.getSuggest().getSuggestion("ruby").getEntries().size(), greaterThan(0));
        List<Aggregation> aggregations = response.getAggregations().asList();
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/40005")
        SearchRequest searchRequest = initSearchRequest();  
        duelSearch(searchRequest, CCSDuelIT::assertAggs);
        searchRequest.source(sourceBuilder);  
        daily.subAggregation(new SumAggregationBuilder("votes").field("votes"));
        duelSearch(searchRequest, response -> {
    }  
        sourceBuilder.aggregation(tags);  
        SearchRequest searchRequest = initSearchRequest();
    public void testShardFailures() throws Exception {
    private static void assertHits(SearchResponse response) {
            assertThat(tags.getEntries().size(), greaterThan(0));
        SearchRequest searchRequest = initSearchRequest();
            }
                @Override  
            responseChecker.accept(minimizeRoundtripsSearchResponse);
        assumeMultiClusterSetup();  
                if (onlyRemote) {
            "tags", tagsArray,
            assertNull(response.getSuggest());
        Map<String, String> joinField = new HashMap<>();  
    @AfterClass  
        duelSearch(searchRequest, CCSDuelIT::assertAggs);
        int numAnswers = randomIntBetween(100, 150);  
        searchRequest.source(sourceBuilder);
        topHits.size(10);
        duelSearch(searchRequest, CCSDuelIT::assertHits);  
            bulkProcessor.add(buildIndexRequest(idPrefix + i, "question", null));
        TermsAggregationBuilder answerPerQuestion = new TermsAggregationBuilder("answer_per_question")  
    }  
        sourceBuilder.aggregation(creation);  
import org.opensearch.action.search.SearchResponse;  
                assertThat(entry.getValue(), instanceOf(Number.class));  
        });
    }
        duelSearch(searchRequest, response -> {
            Map<String, Object> minimizeRoundtripsResponseMap = responseToMap(minimizeRoundtripsSearchResponse);  
                } else {
        TermsAggregationBuilder tags = new TermsAggregationBuilder("tags").userValueTypeHint(ValueType.STRING);
import org.opensearch.common.util.io.IOUtils;
                @Override
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        assertEquals(0, refreshResponse.getFailedShards());
            TermSuggestion tags = response.getSuggest().getSuggestion("tags");  
        indexRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);  
        CreateIndexResponse response = restHighLevelClient.indices().create(createEmptyIndexRequest, RequestOptions.DEFAULT);
            assertHits(response);
    }
    }
 * ownership. Elasticsearch licenses this file to you under  
    public void testTermSuggester() throws Exception {
    public void testHasParentWithInnerHit() throws Exception {
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);  
            }
        assumeMultiClusterSetup();  
            bulkProcessor.add(buildIndexRequest(idPrefix + (i + 1000), "answer", idPrefix + randomIntBetween(0, numQuestions - 1)));
import org.opensearch.search.rescore.QueryRescorerBuilder;
import org.opensearch.search.suggest.term.TermSuggestion;
import org.opensearch.action.bulk.BulkProcessor;  
    private static void assumeMultiClusterSetup() {  
        QueryRescorerBuilder rescorerBuilder = new QueryRescorerBuilder(new MatchQueryBuilder("tags", "java"));
import org.opensearch.search.collapse.CollapseBuilder;
        assertMultiClusterSearchResponse(response);
        });
        Map<String, Object> profile = (Map<String, Object>) responseMap.get("profile");
        tags.size(100);
        searchRequest.source(sourceBuilder);
    }
        duelSearch(searchRequest, CCSDuelIT::assertAggs);
        indexRequest.id("id");
import org.opensearch.index.query.QueryBuilders;  
    }
        });
                public void afterBulk(long executionId, BulkRequest request, Throwable failure) {  
import org.opensearch.action.index.IndexRequest;  
        searchRequest.setCcsMinimizeRoundtrips(true);
        SearchRequest searchRequest = initSearchRequest();
    public void testTermsLookup() throws Exception {  
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(INDEX_NAME);  
    }
        sourceBuilder.docValueField("user.keyword");  
        assumeTrue("must run only against the multi_cluster setup", "multi_cluster".equals(System.getProperty("tests.rest.suite")));
    }  
                }
        tags.subAggregation(tags2);  
        answers.subAggregation(answerPerUser);  
        sourceBuilder.collapse(new CollapseBuilder("user.keyword"));
        AtomicReference<Exception> exception2 = new AtomicReference<>();  
        assertTrue(bulkProcessor.awaitClose(30, TimeUnit.SECONDS));
        });
                    throw new AssertionError("Failed to execute bulk", failure);
    }  
        });  
import org.opensearch.client.RequestOptions;
        type.order(BucketOrder.key(true));  
    }  
        duelSearch(searchRequest, CCSDuelIT::assertHits);  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        sourceBuilder.query(new TermQueryBuilder("_index", onlyRemote ? REMOTE_INDEX_NAME : INDEX_NAME));
/*
        latch.await();  
        assumeMultiClusterSetup();
            assertEquals(1, response.getHits().getHits()[0].getFields().size());
            }
import org.opensearch.script.Script;
    }
        answerPerUser.showTermDocCountError(true);
import java.util.List;  
        cluster.field("_index");
            if (minimizeRoundtripsResponseMap.equals(fanOutResponseMap) == false) {
 * Licensed to Elasticsearch under one or more contributor  
        if (response.getHits().getTotalHits().value() > from) {  
        duelSearch(searchRequest, response -> {
    public void testMatchQuery() throws Exception  {
        assumeMultiClusterSetup();  
        BulkProcessor bulkProcessor = BulkProcessor.builder((r, l) -> restHighLevelClient.bulkAsync(r, RequestOptions.DEFAULT, l),  
        assumeMultiClusterSetup();
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        assertThat(searchResponse.getSuccessfulShards(), greaterThan(1));
        duelSearch(searchRequest, response -> assertHits(response, 10));  
    public void testDocValueFields() throws Exception  {
                "\"join\":{\"type\":\"join\", \"relations\": {\"question\":\"answer\"}}}}", MediaTypeRegistry.JSON);
        super.initClient();
        assertEquals(0, response.getFailedShards());  
        sourceBuilder.aggregation(answers);
                assertEquals(INDEX_NAME, hit.getIndex());
            new DirectCandidateGeneratorBuilder("tags").suggestMode("always")).highlight("<em>", "</em>"));
            if (entry.getValue() instanceof List) {  
        TopHitsAggregationBuilder topHits = new TopHitsAggregationBuilder("top");
        sourceBuilder.fetchSource(new String[]{"tags"}, Strings.EMPTY_ARRAY);
        searchRequest.source(sourceBuilder);
        tags.subAggregation(topHits);
    public void testTerminateAfter() throws Exception {  
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();  
                }
    @Override
 * software distributed under the License is distributed on an
        assumeMultiClusterSetup();  
import org.opensearch.common.settings.Settings;
                assertEquals(3, response.getHits().getHits()[0].getSortValues().length);  
            //we index docs with private randomness otherwise the two clusters end up with exactly the same documents
import com.carrotsearch.randomizedtesting.annotations.TimeoutSuite;
            SearchResponse minimizeRoundtripsSearchResponse = minimizeRoundtripsResponse.get();  
            assertHits(response);
        IndexRequest indexRequest = new IndexRequest(INDEX_NAME);  
        indexRequest.source("tags", new String[]{"java", "sql", "html", "jax-ws"});
    @SuppressWarnings("unchecked")
        rescorerBuilder.setScoreMode(QueryRescoreMode.Multiply);  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
        AtomicReference<SearchResponse> fanOutResponse = new AtomicReference<>();
                    }
    }
        sourceBuilder.size(0);
        searchRequest.source(sourceBuilder);  
import org.opensearch.core.xcontent.XContentHelper;  
        sourceBuilder.sort("creationDate", SortOrder.DESC);  
    private static SearchSourceBuilder buildTermsAggsSource() {
        sourceBuilder.profile(true);
        SearchRequest searchRequest = initSearchRequest();
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
                assertThat("agg " + multiBucketsAggregation.getName() + " has 0 buckets",
        SearchRequest searchRequest = initSearchRequest();  
        searchRequest.source(sourceBuilder);  
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "python"));
        suggestBuilder.addSuggestion("tags", new TermSuggestionBuilder("tags")  
        answerPerUser.size(30);
import org.junit.AfterClass;
        TermsQueryBuilder termsQueryBuilder = new TermsQueryBuilder("tags", new TermsLookup("lookup_index", "id", "tags"));
        SearchRequest searchRequest = initSearchRequest();
        sourceBuilder.trackTotalHitsUpTo(5);  
        duelSearch(searchRequest, response -> {  
        SearchRequest searchRequest = initSearchRequest();  
        return responseMap;
            if (aggregation instanceof MultiBucketsAggregation) {  
import org.opensearch.test.rest.OpenSearchRestTestCase;
    }
        duelSearch(searchRequest, response -> {
        SuggestBuilder suggestBuilder = new SuggestBuilder();
        }  
        answers.subAggregation(answerPerQuestion);
        SearchRequest searchRequest = initSearchRequest();  
        TermsAggregationBuilder tags = new TermsAggregationBuilder("tags").userValueTypeHint(ValueType.STRING);
    private static void indexDocuments(String idPrefix) throws IOException, InterruptedException {
        sourceBuilder.explain(true);  
    }  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import java.util.HashSet;
        suggestBuilder.addSuggestion("python", new CompletionSuggestionBuilder("suggest").size(10).text("pyth"));
            assertMultiClusterSearchResponse(response);
        assumeMultiClusterSetup();
            assertMultiClusterSearchResponse(response);
            }
 * This test class executes twice, first against the remote cluster, and then against another cluster that has the remote cluster
    private static void replaceProfileTime(Map<String, Object> map) {  
    }  
        SearchRequest searchRequest = initSearchRequest();
            assertEquals(1, response.getSuggest().size());
            assertHits(response);
        duelSearch(searchRequest, response -> {  
            PhraseSuggestion tags = response.getSuggest().getSuggestion("tags");  
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
                assertEquals(INDEX_NAME, hit.getIndex());
        }
        assumeMultiClusterSetup();  
        assumeMultiClusterSetup();  
                for (String key : breakdown.keySet()) {
                });
        creation.calendarInterval(DateHistogramInterval.QUARTER);
    }
            assertNull(response.getAggregations());
 * license agreements. See the NOTICE file distributed with
    }  
            "user", "user" + randomIntBetween(1, 10),
        boolean onlyRemote = randomBoolean();  
 * compatible open source license.
        cluster.subAggregation(type);
        tags.field("tags.keyword");
            "id", id,  
        assumeMultiClusterSetup();
import org.opensearch.action.index.IndexResponse;
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "ruby"));
 * under the License.  
 *
        AtomicReference<SearchResponse> minimizeRoundtripsResponse = new AtomicReference<>();
 * The goal of this test is not to test correctness of CCS responses, but rather to verify that CCS returns the same responses when
            if (exception2.get() != null) {  
        SearchRequest searchRequest = initSearchRequest();
                throw new AssertionError("Didn't match expected value:\n" + message);
        if (questionId == null) {
import static org.hamcrest.CoreMatchers.equalTo;
        duelSearch(searchRequest, CCSDuelIT::assertHits);
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME + "*", REMOTE_INDEX_NAME + "*");  
                throw new AssertionError("one of the two requests returned an exception", exception1.get());
        tags2.field("tags.keyword");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();  
        assertNotNull(responseMap.put("took", -1));  
        duelSearch(searchRequest, response -> {  
            SearchResponse fanOutSearchResponse = fanOutResponse.get();  
    }  
    public void testHasChildWithInnerHit() throws Exception {  
    }
        restHighLevelClient.searchAsync(searchRequest, RequestOptions.DEFAULT,  
            new LatchedActionListener<>(ActionListener.wrap(minimizeRoundtripsResponse::set, exception1::set), latch));
        String date = LocalDate.of(2019, 1, randomIntBetween(1, 31)).format(DateTimeFormatter.ofPattern("yyyy/MM/dd", Locale.ROOT));
    }  
            for (Map<String, Object> shard : shards) {
        sourceBuilder.size(0);
        });
            RandomizedContext.current().runWithPrivateRandomness(random().nextLong() + destinationCluster.hashCode(),
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "xml"));
        duelSearch(searchRequest, response -> {
    }
        } else {
    @SuppressWarnings("unchecked")
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        SearchRequest searchRequest = initSearchRequest();
import java.time.format.DateTimeFormatter;
                    return null;
    public void testDateHistogram() throws Exception {
        topHits.from(10);  
        sourceBuilder.sort("user.keyword", SortOrder.ASC);  
        indexRequest.source("id", "id", "creationDate", "err");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.from(30);
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            assertHits(response, 30);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();  
        SearchRequest searchRequest = initSearchRequest();  
 * Unless required by applicable law or agreed to in writing,
        topHits.sort("creationDate", SortOrder.DESC);
    public void testFieldCollapsingSortByField() throws Exception {  
            List<Map<String, Object>> shards = (List<Map<String, Object>>) profile.get("shards");
    public void testProfile() throws Exception  {  
    public static void cleanupClient() throws IOException {
            .userValueTypeHint(ValueType.STRING);
    public void testFetchSource() throws Exception  {
        suggestBuilder.setGlobalText("jva and hml");
 * KIND, either express or implied.  See the License for the
        assumeMultiClusterSetup();
    protected boolean preserveDataStreamsUponCompletion() {  
        assumeMultiClusterSetup();
        }
        sourceBuilder.suggest(suggestBuilder);
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;  
        tags.size(10);  
import static org.hamcrest.Matchers.greaterThan;  
            }
        searchRequest.source(sourceBuilder);
        tags.showTermDocCountError(true);  
        sourceBuilder.aggregation(new MaxBucketPipelineAggregationBuilder("biggest_day", "daily._count"));
import java.util.function.Consumer;
                if (onlyRemote) {
        answerPerQuestion.field("questionId.keyword");  
import java.util.Arrays;
    }
        TermsAggregationBuilder tags2 = new TermsAggregationBuilder("tags").userValueTypeHint(ValueType.STRING);
        searchRequest.source(sourceBuilder);
 * specific language governing permissions and limitations
        });
    public void testTrackTotalHitsUpTo() throws Exception {
    public void testHighlighting() throws Exception  {  
        createIndexRequest.settings(Settings.builder().put("index.number_of_shards", numShards).put("index.number_of_replicas", 0));
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;
        searchRequest.source(sourceBuilder);  
            SearchHit[] hits = response.getHits().getHits();
                }  
import org.apache.lucene.search.join.ScoreMode;  
        });  
            assertEquals(3, minimizeRoundtripsSearchResponse.getNumReducePhases());
                    assertEquals("my_remote_cluster", hit.getClusterAlias());  
        searchRequest.source(sourceBuilder);
        SearchRequest searchRequest = initSearchRequest();  
        daily.subAggregation(new DerivativePipelineAggregationBuilder("derivative", "_count"));  
import java.time.LocalDate;  
