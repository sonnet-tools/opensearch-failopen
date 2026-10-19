        DateHistogramAggregationBuilder daily = new DateHistogramAggregationBuilder("daily");
        duelSearch(searchRequest, CCSDuelIT::assertHits);
 * not use this file except in compliance with the License.
    }
import org.apache.lucene.tests.util.TimeUnits;
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        duelSearch(searchRequest, response -> assertHits(response, 10));
        searchRequest.source(sourceBuilder);
        sourceBuilder.sort("creationDate", SortOrder.DESC);
 * compatible open source license.
        assumeMultiClusterSetup();
        duelSearch(searchRequest, CCSDuelIT::assertHits);
        sourceBuilder.aggregation(new MaxBucketPipelineAggregationBuilder("biggest_day", "daily._count"));
import org.opensearch.search.suggest.completion.CompletionSuggestionBuilder;
    public void testHasParentWithInnerHit() throws Exception {
    }
 * You may obtain a copy of the License at
        return true;
    public void testTermsAggsWithProfile() throws Exception {
import org.opensearch.index.query.TermsQueryBuilder;
import org.junit.AfterClass;
            assertThat(tags.getEntries().size(), greaterThan(0));
        return true;
        latch.await();
 *
            assertMultiClusterSearchResponse(response);
        sourceBuilder.size(50);
        assertTrue(bulkProcessor.awaitClose(30, TimeUnit.SECONDS));
        duelSearch(searchRequest, response -> {
        sourceBuilder.size(0);
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "xml"));
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/40005")
        }
        assertTrue(response.isAcknowledged());
            "creationDate", date,
        SearchRequest searchRequest = initSearchRequest();
 *
                "\"suggest\":{\"type\":\"completion\"}," +
        SearchRequest searchRequest = initSearchRequest();
        SearchRequest searchRequest = initSearchRequest();
import static org.hamcrest.CoreMatchers.instanceOf;
        topHits.from(10);
    public void testSortByField() throws Exception  {
            assertEquals(1, response.getHits().getHits()[0].getFields().size());
        SearchRequest searchRequest = initSearchRequest();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        sourceBuilder.size(0);
    }
        sourceBuilder.query(new TermQueryBuilder("_index", onlyRemote ? REMOTE_INDEX_NAME : INDEX_NAME));
    }
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "php"));
        }
                assertThat(entry.getValue(), instanceOf(Number.class));
                }
        sourceBuilder.size(0);
        sourceBuilder.aggregation(new MaxBucketPipelineAggregationBuilder("most_voted", "daily>votes"));
            "type", type,
        sourceBuilder.size(0);
import org.opensearch.action.index.IndexResponse;
            assertEquals(3, minimizeRoundtripsSearchResponse.getNumReducePhases());
    protected boolean preserveDataStreamsUponCompletion() {
            assertThat(response.getSuggest().getSuggestion("ruby").getEntries().size(), greaterThan(0));
import org.opensearch.search.suggest.phrase.PhraseSuggestion;
        assumeMultiClusterSetup();
            assertEquals(1, fanOutSearchResponse.getNumReducePhases());
            "user", "user" + randomIntBetween(1, 10),
        sourceBuilder.fetchSource(new String[]{"tags"}, Strings.EMPTY_ARRAY);
        assertNull(response.getSuggest());
        createIndexRequest.mapping("{\"properties\":{" +
        if (exception1.get() != null && exception2.get() != null) {
        duelSearch(searchRequest, CCSDuelIT::assertHits);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        searchRequest.source(sourceBuilder);
        rescorerBuilder.setScoreMode(QueryRescoreMode.Multiply);
import java.util.concurrent.TimeUnit;
        duelSearch(searchRequest, response -> {
        HasChildQueryBuilder query = new HasChildQueryBuilder("answer", rangeQueryBuilder, ScoreMode.Total);
        indexRequest.source("tags", new String[]{"java", "sql", "html", "jax-ws"});
        sourceBuilder.highlighter(new HighlightBuilder().field("tags"));
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.action.support.WriteRequest;
        for (int i = 0; i < numAnswers; i++) {
                    multiBucketsAggregation.getBuckets().size(), greaterThan(0));
        tags.showTermDocCountError(true);
        searchRequest.source(sourceBuilder);
            assertThat(response.getSuggest().getSuggestion("python").getEntries().size(), greaterThan(0));
        assertThat(searchResponse.getTotalShards(), greaterThan(1));
        assumeMultiClusterSetup();
    }
        //verify that the order in which documents are returned when they all have the same score is the same
        AtomicReference<Exception> exception1 = new AtomicReference<>();
        assumeMultiClusterSetup();
            if (aggregation instanceof MultiBucketsAggregation) {
                throw new AssertionError("one of the two requests returned an exception", exception1.get());
    }
 * This test class executes twice, first against the remote cluster, and then against another cluster that has the remote cluster
        daily.subAggregation(new DerivativePipelineAggregationBuilder("derivative", "_count"));
        assumeMultiClusterSetup();
        searchRequest.source(sourceBuilder);
                @Override
        CreateIndexRequest createEmptyIndexRequest = new CreateIndexRequest(INDEX_NAME + "_empty");
        }
            super(restClient, (client) -> {}, Collections.emptyList());
        assertEquals(0, refreshResponse.getFailedShards());
        });
        indexRequest.id(id);
        TermsAggregationBuilder tags = new TermsAggregationBuilder("tags").userValueTypeHint(ValueType.STRING);
    }
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
import org.opensearch.client.RestClient;
    }
        super.initClient();
        searchRequest.source(sourceBuilder);
    }
                NotEqualMessageBuilder message = new NotEqualMessageBuilder();
        }
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
import org.opensearch.search.rescore.QueryRescorerBuilder;
 * the Apache License, Version 2.0 (the "License"); you may
            }
import org.opensearch.index.query.RangeQueryBuilder;
        sourceBuilder.scriptField("parent", new Script(ScriptType.INLINE, "painless", "doc['join#question']", Collections.emptyMap()));
            }
        CountDownLatch latch = new CountDownLatch(2);
import org.opensearch.search.aggregations.metrics.TopHitsAggregationBuilder;
        assertEquals(numShards, refreshResponse.getSuccessfulShards());
            assertNull(response.getAggregations());
        });
    private static SearchRequest initSearchRequest() {
        suggestBuilder.addSuggestion("java", new CompletionSuggestionBuilder("suggest").size(20).text("jav"));
        assertEquals(0, response.getHits().getHits().length);
 */
    }
    }
        SearchRequest searchRequest = initSearchRequest();
        tags.size(100);
        assumeMultiClusterSetup();
        Map<String, Object> profile = (Map<String, Object>) responseMap.get("profile");
            }
        // set to a value greater than the number of shards to avoid differences due to the skipping of shards
    @Override
            SearchResponse minimizeRoundtripsSearchResponse = minimizeRoundtripsResponse.get();
                @Override
            }
        answers.subAggregation(answerPerUser);
        tags.size(10);
            restHighLevelClient = new HighLevelClient(client());
        Collections.shuffle(indices, random());
import org.opensearch.search.aggregations.BucketOrder;
        });
        assertEquals(201, indexResponse.status().getStatus());
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        SearchRequest searchRequest = initSearchRequest();
 * against the multi cluster setup only, which is required for testing cross-cluster search.
        });
            }
        searchRequest.source(sourceBuilder);
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "ruby"));
        creation.field("creationDate");
        responseMap.remove("num_reduce_phases");
import org.opensearch.client.indices.CreateIndexRequest;
        SearchRequest searchRequest = initSearchRequest();
        answerPerUser.size(30);
        assumeMultiClusterSetup();
package org.opensearch.search;
 * <code>minimizeRoundTrips</code> is set to either <code>true</code> or <code>false</code>. In fact the execution differs depending on
                List<Object> list = (List<Object>) entry.getValue();
        duelSearch(searchRequest, response -> {
        SearchRequest searchRequest = initSearchRequest();
        });
            indexRequest.routing(questionId);
        answers.subAggregation(answerPerQuestion);
import static org.hamcrest.CoreMatchers.equalTo;
            joinField.put("parent", questionId);
        duelSearch(searchRequest, CCSDuelIT::assertHits);
 * such parameter, hence we want to verify that results are the same in both scenarios.
        TermsAggregationBuilder tags = new TermsAggregationBuilder("tags").userValueTypeHint(ValueType.STRING);
        searchRequest.source(sourceBuilder);
            assertMultiClusterSearchResponse(response);
import org.opensearch.search.builder.SearchSourceBuilder;
        answerPerQuestion.field("questionId.keyword");
        assumeMultiClusterSetup();
            assertHits(response);
    }
                @Override
        boolean onlyRemote = randomBoolean();
            if (exception1.get() != null) {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            throw new AssertionError("both requests returned an exception", exception1.get());
        sourceBuilder.sort("user.keyword", SortOrder.ASC);
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
        creation.subAggregation(tags);
        sourceBuilder.size(20);
    }
        duelSearch(searchRequest, CCSDuelIT::assertHits);
            List<Map<String, Object>> shards = (List<Map<String, Object>>) profile.get("shards");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //this index with a single document is used to test partial failures
        searchRequest.source(sourceBuilder);
        }
                    assertNull(hit.getClusterAlias());
            assertHits(response);
import java.util.HashSet;
        query.innerHit(new InnerHitBuilder("inner"));
    public void testFieldCollapsingOneClusterHasNoResults() throws Exception {
    }
            }
    public void testPhraseSuggester() throws Exception {
    protected boolean preserveIndicesUponCompletion() {
        QueryRescorerBuilder rescorerBuilder = new QueryRescorerBuilder(new MatchQueryBuilder("tags", "java"));
        assumeMultiClusterSetup();
        });
        tags.field("tags.keyword");
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        assumeMultiClusterSetup();
    public void testFieldCollapsingSortByScore() throws Exception {
    public void testTermSuggester() throws Exception {
        SearchRequest searchRequest = initSearchRequest();
            assertThat(response.getHits().getHits().length, greaterThan(0));
import static org.hamcrest.Matchers.greaterThan;
import com.carrotsearch.randomizedtesting.RandomizedContext;
        sourceBuilder.query(hasParentQueryBuilder);
        sourceBuilder.aggregation(tags);
                    assertEquals("my_remote_cluster", hit.getClusterAlias());
        }
 * under the License.
import org.opensearch.action.bulk.BulkProcessor;
            assertHits(response);
        assumeMultiClusterSetup();
 * Unless required by applicable law or agreed to in writing,
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    private static void assertMultiClusterSearchResponse(SearchResponse searchResponse) {
import java.util.Arrays;
        sourceBuilder.query(new TermQueryBuilder("_index", onlyRemote ? REMOTE_INDEX_NAME : INDEX_NAME));
        searchRequest.source(sourceBuilder);
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;
        sourceBuilder.suggest(suggestBuilder);
        sourceBuilder.size(25);
            assertNotNull(response.getHits().getHits()[0].getExplanation());
        duelSearch(searchRequest, response -> {
    }
        }
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "php"));
        tags.field("tags.keyword");
            }).build();
import org.junit.Before;
                for (Object obj : list) {
    private static void duelSearch(SearchRequest searchRequest, Consumer<SearchResponse> responseChecker) throws Exception {
            //we index docs with private randomness otherwise the two clusters end up with exactly the same documents
        });
    public void testRescore() throws Exception {
        });
import org.opensearch.common.settings.Settings;
        duelSearch(searchRequest, response -> {
 * Licensed to Elasticsearch under one or more contributor
            assertAggs(response);
        sourceBuilder.docValueField("user.keyword");
        type.showTermDocCountError(true);
        tags.subAggregation(tags2);
        type.order(BucketOrder.key(true));
                }
            .suggestMode(TermSuggestionBuilder.SuggestMode.POPULAR));
        SuggestBuilder suggestBuilder = new SuggestBuilder();
    public void testPipelineAggs() throws Exception {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(INDEX_NAME);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        AtomicReference<SearchResponse> minimizeRoundtripsResponse = new AtomicReference<>();
        duelSearch(searchRequest, CCSDuelIT::assertHits);
import org.opensearch.index.query.MatchQueryBuilder;
                    return null;
        duelSearch(searchRequest, CCSDuelIT::assertAggs);
import org.opensearch.common.util.io.IOUtils;
            assertNotNull(response.getHits().getHits()[0].getFields().get("parent"));
        String date = LocalDate.of(2019, 1, randomIntBetween(1, 31)).format(DateTimeFormatter.ofPattern("yyyy/MM/dd", Locale.ROOT));
        SearchRequest searchRequest = initSearchRequest();
        daily.subAggregation(new SumAggregationBuilder("votes").field("votes"));
        if (questionId != null) {
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "html"));
        assertNotNull(responseMap.put("took", -1));
        assumeTrue("must run only against the multi_cluster setup", "multi_cluster".equals(System.getProperty("tests.rest.suite")));
 */
        CreateIndexResponse response = restHighLevelClient.indices().create(createEmptyIndexRequest, RequestOptions.DEFAULT);
            if (exception2.get() != null) {
                } else {
        HasParentQueryBuilder hasParentQueryBuilder = new HasParentQueryBuilder("question", QueryBuilders.matchQuery("tags", "xml"), true);
            }
    private static void assertHits(SearchResponse response, int from) {
        sourceBuilder.sort("type.keyword", SortOrder.ASC);
        duelSearch(searchRequest, CCSDuelIT::assertAggs);
        SearchRequest searchRequest = initSearchRequest();
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.support.ValueType;
            bulkProcessor.add(buildIndexRequest(idPrefix + i, "question", null));
        });
            if (entry.getKey().equals("breakdown")) {
            if (entry.getValue() instanceof List) {
import org.opensearch.search.aggregations.metrics.CardinalityAggregationBuilder;
        restHighLevelClient = null;
            assertFalse(response.getProfileResults().isEmpty());
                } else {
                assertEquals(3, response.getHits().getHits()[0].getSortValues().length);
                MultiBucketsAggregation multiBucketsAggregation = (MultiBucketsAggregation) aggregation;
        });
        sourceBuilder.suggest(suggestBuilder);
import org.opensearch.client.indices.CreateIndexResponse;
        assertTrue(createIndexResponse.isAcknowledged());
import org.opensearch.action.LatchedActionListener;
            TermSuggestion tags = response.getSuggest().getSuggestion("tags");
        SearchRequest searchRequest = initSearchRequest();
 * this work for additional information regarding copyright
                assertThat("agg " + multiBucketsAggregation.getName() + " has 0 buckets",
            assertEquals(1, response.getSuggest().size());
        SearchRequest searchRequest = initSearchRequest();
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
                public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
            Map<String, Object> fanOutResponseMap = responseToMap(fanOutSearchResponse);
        });
                replaceProfileTime((Map<String, Object>) entry.getValue());
            for (SearchHit hit : hits) {
        searchRequest.setPreFilterShardSize(128);
        FilterAggregationBuilder answers = new FilterAggregationBuilder("answers", new TermQueryBuilder("type", "answer"));
    }
        searchRequest.source(sourceBuilder);
            assertHits(response);
                "\"id\":{\"type\":\"keyword\"}," +
/*
            }
        sourceBuilder.query(termsQueryBuilder);
import java.time.format.DateTimeFormatter;
                throw new AssertionError("Didn't match expected value:\n" + message);
        assumeMultiClusterSetup();
        assertThat(response.getHits().getTotalHits().value(), greaterThan(0L));
import org.opensearch.search.rescore.QueryRescoreMode;
        searchRequest.source(sourceBuilder);
    }
        return new SearchRequest(indices.toArray(new String[0]));
        TermsAggregationBuilder tags = new TermsAggregationBuilder("tags").userValueTypeHint(ValueType.STRING);
        IndexRequest indexRequest = new IndexRequest("lookup_index");
    }
        searchRequest.source(sourceBuilder);
        sourceBuilder.aggregation(tags);
    }
    }
    }
                assertEquals(INDEX_NAME, hit.getIndex());
    }
        sourceBuilder.profile(true);
                assertEquals(3, hit.getSortValues().length);
            assertThat(response.getFailedShards(), greaterThanOrEqualTo(2));
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "ruby"));
            assertHits(response);
        sourceBuilder.aggregation(tags);
    }
        IOUtils.close(restHighLevelClient);
        SearchRequest searchRequest = initSearchRequest();
                    assertNotNull(breakdown.put(key, -1L));
        indexRequest.source("id", "id", "creationDate", "err");
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
    }
        sourceBuilder.aggregation(daily);
                }
        for (int i = 0; i < numQuestions; i++) {
            assertThat(response.getHits().getHits().length, equalTo(0));
        searchRequest.source(sourceBuilder);
import org.opensearch.join.query.HasChildQueryBuilder;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        assumeMultiClusterSetup();
                    if (obj instanceof Map) {
        daily.calendarInterval(DateHistogramInterval.DAY);
        SearchRequest searchRequest = initSearchRequest();
    public void testMatchQuery() throws Exception  {
import org.opensearch.action.search.SearchRequest;
            //given that this test class is run twice with same seed.
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
        searchRequest.source(sourceBuilder);
    public void testDateHistogram() throws Exception {
            new LatchedActionListener<>(ActionListener.wrap(minimizeRoundtripsResponse::set, exception1::set), latch));
import java.util.concurrent.Callable;
        assertEquals(0, response.getFailedShards());
 *
        int numQuestions = randomIntBetween(50, 100);
        searchRequest.source(sourceBuilder);
        Set<String> tags = new HashSet<>();
        TermsAggregationBuilder answerPerQuestion = new TermsAggregationBuilder("answer_per_question")
        sourceBuilder.sort(new ScoreSortBuilder());
            SearchHit[] hits = response.getHits().getHits();
    public void testDocValueFields() throws Exception  {
/**
        duelSearch(searchRequest, response -> {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            Map<String, Object> minimizeRoundtripsResponseMap = responseToMap(minimizeRoundtripsSearchResponse);
        TermsAggregationBuilder answerPerUser = new TermsAggregationBuilder("answer_per_user").userValueTypeHint(ValueType.STRING);
        if (questionId == null) {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.terminateAfter(10);
                }
        duelSearch(searchRequest, CCSDuelIT::assertHits);
import org.opensearch.indices.TermsLookup;
        SearchRequest searchRequest = initSearchRequest();
 * Modifications Copyright OpenSearch Contributors. See
            }
    public void testShardFailures() throws Exception {
        suggestBuilder.addSuggestion("tags", new PhraseSuggestionBuilder("tags").addCandidateGenerator(
            assertEquals(2, response.getHits().getHits()[0].getSortValues().length);
            assertThat(response.getHits().getHits().length, greaterThan(0));
        duelSearch(searchRequest, response -> {
    public void testCompletionSuggester() throws Exception {
        if (restHighLevelClient == null) {
        sourceBuilder.sort("type.keyword", SortOrder.ASC);
            "suggest", Collections.singletonMap("input", tagsArray),
                assertNotNull(entry.setValue(-1));
            String destinationCluster = System.getProperty("tests.rest.suite");
        searchRequest.setCcsMinimizeRoundtrips(true);
        assumeMultiClusterSetup();
    private static void assertAggs(SearchResponse response) {
                    assertNull(hit.getClusterAlias());
        });
    }
        SearchRequest searchRequest = initSearchRequest();
import org.opensearch.core.common.bytes.BytesReference;
        indexRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);
        duelSearch(searchRequest, response -> {
                    assertFalse(response.hasFailures());
import org.opensearch.search.suggest.term.TermSuggestionBuilder;
    }
    }
            assertEquals(1, response.getHits().getHits()[0].getSourceAsMap().size());
        }
                    throw new AssertionError("Failed to execute bulk", failure);
            assertNotNull(response.getHits().getHits()[0].getFields().get("user.keyword"));
                    assertEquals("my_remote_cluster", hit.getClusterAlias());
        duelSearch(searchRequest, response -> {
        TermsAggregationBuilder tags2 = new TermsAggregationBuilder("tags").userValueTypeHint(ValueType.STRING);
        Map<String, Object> responseMap = org.opensearch.common.xcontent.XContentHelper.convertToMap(bytesReference, false, MediaTypeRegistry.JSON).v2();
                for (String key : breakdown.keySet()) {
            SearchResponse fanOutSearchResponse = fanOutResponse.get();
            "id", id,
        searchRequest.source(sourceBuilder);
    }
        answerPerQuestion.showTermDocCountError(true);
            assertEquals(1, response.getHits().getHits()[0].getFields().size());
            }
        searchRequest.source(sourceBuilder);
            new DirectCandidateGeneratorBuilder("tags").suggestMode("always")).highlight("<em>", "</em>"));
        searchRequest.source(sourceBuilder);
        cluster.field("_index");
            responseChecker.accept(minimizeRoundtripsSearchResponse);
            "votes", randomIntBetween(0, 30),
                replaceProfileTime(shard);
            assertHits(response);
        SearchRequest searchRequest = initSearchRequest();
        duelSearch(searchRequest, response -> {
        SearchRequest searchRequest = initSearchRequest();
        duelSearch(searchRequest, CCSDuelIT::assertAggs);
    }
        return sourceBuilder;
                }
        sourceBuilder.sort("user.keyword", SortOrder.ASC);
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
        } else {
        sourceBuilder.query(query);
        suggestBuilder.addSuggestion("tags", new TermSuggestionBuilder("tags")
        assertMultiClusterSearchResponse(response);
            assertThat(response.getHits().getTotalHits().value(), greaterThan(0L));
        indexRequest.create(true);
        IndexRequest indexRequest = new IndexRequest(INDEX_NAME + "_err");
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "python"));
            RandomizedContext.current().runWithPrivateRandomness(random().nextLong() + destinationCluster.hashCode(),
        assertNotNull(response.getAggregations());
    }
            }
            assertThat(tags.getEntries().size(), greaterThan(0));
        searchRequest.source(sourceBuilder);
        duelSearch(searchRequest, response -> {
                        replaceProfileTime((Map<String, Object>) obj);
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME + "*", REMOTE_INDEX_NAME + "*");
                (Callable<Void>) () -> {
        int numTags = randomIntBetween(1, 3);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
import java.util.concurrent.CountDownLatch;
        RangeQueryBuilder rangeQueryBuilder = new RangeQueryBuilder("creationDate").gte("2019/01/01").lte("2019/01/31");
import org.opensearch.search.aggregations.pipeline.MaxBucketPipelineAggregationBuilder;
        }
        indexRequest.id("id");
        indexRequest.source(MediaTypeRegistry.JSON,
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "xml"));
import org.opensearch.test.rest.OpenSearchRestTestCase;
 * GitHub history for details.
        duelSearch(searchRequest, CCSDuelIT::assertAggs);
        SearchRequest searchRequest = initSearchRequest();
    }
                    }
        assumeMultiClusterSetup();
        duelSearch(searchRequest, CCSDuelIT::assertAggs);
    private static void indexDocuments(String idPrefix) throws IOException, InterruptedException {
import org.opensearch.search.suggest.SuggestBuilder;
import org.opensearch.search.aggregations.bucket.filter.FilterAggregationBuilder;
    @SuppressWarnings("unchecked")
        return responseMap;
import org.opensearch.action.bulk.BulkRequest;
        AtomicReference<SearchResponse> fanOutResponse = new AtomicReference<>();
        boolean onlyRemote = randomBoolean();
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    public void testTerminateAfter() throws Exception {
        sourceBuilder.suggest(suggestBuilder);
        sourceBuilder.trackTotalHitsUpTo(5);
        sourceBuilder.query(new TermQueryBuilder("type", "answer"));
    public void testPagination() throws Exception  {
    private static RestHighLevelClient restHighLevelClient;
        suggestBuilder.addSuggestion("ruby", new CompletionSuggestionBuilder("suggest").size(30).text("rub"));
        sourceBuilder.addRescorer(rescorerBuilder);
    }
            for (int i = 0; i < numTags; i++) {
        sourceBuilder.sort("creationDate", SortOrder.DESC);
import org.opensearch.search.suggest.term.TermSuggestion;
        assertNull(response.getAggregations());
 * The goal of this test is not to test correctness of CCS responses, but rather to verify that CCS returns the same responses when
        creation.calendarInterval(DateHistogramInterval.QUARTER);
import org.opensearch.core.common.Strings;
        assumeMultiClusterSetup();
        assumeMultiClusterSetup();
        RefreshResponse refreshResponse = restHighLevelClient.indices().refresh(new RefreshRequest(INDEX_NAME), RequestOptions.DEFAULT);
import java.util.Map;
            responseChecker.accept(fanOutSearchResponse);
        suggestBuilder.setGlobalText("jva hml");
        searchRequest.source(sourceBuilder);
import org.opensearch.test.NotEqualMessageBuilder;
    public void testTrackTotalHitsUpTo() throws Exception {
 */
        SearchRequest searchRequest = initSearchRequest();
    public void testFetchSource() throws Exception  {
            assertFalse(response.getHits().getHits()[0].getHighlightFields().isEmpty());
            new LatchedActionListener<>(ActionListener.wrap(fanOutResponse::set, exception2::set), latch));
        cluster.subAggregation(type);
        assumeMultiClusterSetup();
        sourceBuilder.from(10);
    public void init() throws Exception {
        DateHistogramAggregationBuilder creation = new DateHistogramAggregationBuilder("creation");
        }
        TermsAggregationBuilder type = new TermsAggregationBuilder("type").userValueTypeHint(ValueType.STRING);
        hasParentQueryBuilder.innerHit(new InnerHitBuilder("inner"));
            }
public class CCSDuelIT extends OpenSearchRestTestCase {
        searchRequest.source(buildTermsAggsSource().profile(true));
        assertMultiClusterSearchResponse(response);
import org.opensearch.action.search.SearchResponse;
import org.opensearch.join.query.HasParentQueryBuilder;
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        tags.field("tags.keyword");
        sourceBuilder.query(QueryBuilders.matchQuery("creationDate", "err"));
        duelSearch(searchRequest, response -> {
 *    http://www.apache.org/licenses/LICENSE-2.0
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            exception1.get().addSuppressed(exception2.get());
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
@TimeoutSuite(millis = 5 * TimeUnits.MINUTE) // to account for slow as hell VMs
                Map<String, Long> breakdown = (Map<String, Long>) entry.getValue();
    public void testTermsLookup() throws Exception {
            if (entry.getKey().contains("time")) {
import org.opensearch.client.RequestOptions;
            assertMultiClusterSearchResponse(response);
        });
        searchRequest.source(sourceBuilder);
    }
            "questionId", questionId,
    private static SearchSourceBuilder buildTermsAggsSource() {
        assertEquals(2, searchResponse.getClusters().getTotal());
        int numShards = randomIntBetween(1, 5);
                tags.add(randomFrom(TAGS));
import org.opensearch.index.query.InnerHitBuilder;
    public void testProfile() throws Exception  {
        SearchRequest searchRequest = initSearchRequest();
                }
            assertHits(response, 30);
    public void testFieldCollapsingSortByField() throws Exception {
        sourceBuilder.aggregation(creation);
        searchRequest.setCcsMinimizeRoundtrips(false);
import org.opensearch.script.Script;
            assertNotNull(response.getAggregations().get("most_voted"));
        sourceBuilder.sort("creationDate", SortOrder.DESC);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
import org.opensearch.action.index.IndexRequest;
        List<Aggregation> aggregations = response.getAggregations().asList();
    @SuppressWarnings("unchecked")
        searchRequest.source(sourceBuilder);
        sourceBuilder.collapse(new CollapseBuilder("user.keyword"));
        sourceBuilder.size(0);
        restHighLevelClient.searchAsync(searchRequest, RequestOptions.DEFAULT,
        SearchRequest searchRequest = initSearchRequest();
    private static void assertHits(SearchResponse response) {
            "join", joinField);
        int numAnswers = randomIntBetween(100, 150);
    }
    }
 * this file be licensed under the Apache-2.0 license or a
        TermsQueryBuilder termsQueryBuilder = new TermsQueryBuilder("tags", new TermsLookup("lookup_index", "id", "tags"));
import java.util.function.Consumer;
        SearchRequest searchRequest = initSearchRequest();
import org.opensearch.search.aggregations.Aggregation;
        daily.field("creationDate");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
import java.util.concurrent.atomic.AtomicReference;
            bulkProcessor.add(buildIndexRequest(idPrefix + (i + 1000), "answer", idPrefix + randomIntBetween(0, numQuestions - 1)));
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "sql"));
            assertEquals(Strings.toString(MediaTypeRegistry.JSON, response, true, true), 3, response.getSuggest().size());
        tags.field("tags.keyword");
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "ruby"));
        searchRequest.source(buildTermsAggsSource());
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    public void testScriptFields() throws Exception  {
    public static void cleanupClient() throws IOException {
        SearchRequest searchRequest = initSearchRequest();
        indexRequest.id("id");
import org.opensearch.index.query.QueryBuilders;
        type.field("type.keyword");
        duelSearch(searchRequest, CCSDuelIT::assertAggs);
        Map<String, String> joinField = new HashMap<>();
        }
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "perl"));
        SearchRequest searchRequest = initSearchRequest();
            assertThat(response.getSuggest().getSuggestion("java").getEntries().size(), greaterThan(0));
        searchRequest.source(sourceBuilder);
                shard.remove("fetch");
                assertEquals(INDEX_NAME, hit.getIndex());
    private static void replaceProfileTime(Map<String, Object> map) {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        tags2.field("tags.keyword");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        assumeMultiClusterSetup();
    }
            assertEquals(1, response.getSuggest().size());
                    indexDocuments(destinationCluster + "-");
        assumeMultiClusterSetup();
    public void testCardinalityAgg() throws Exception {
                });
    }
        BytesReference bytesReference = XContentHelper.toXContent(response, MediaTypeRegistry.JSON, false);
            for (SearchHit hit : response.getHits().getHits()) {
import java.util.Locale;
        private HighLevelClient(RestClient restClient) {
import org.opensearch.search.collapse.CollapseBuilder;
                if (onlyRemote) {
                // Unconditionally remove the fetch profile to prevent flaky failures
        SuggestBuilder suggestBuilder = new SuggestBuilder();
import org.apache.lucene.search.join.ScoreMode;
    }
            if (entry.getValue() instanceof Map) {
        TermsAggregationBuilder cluster = new TermsAggregationBuilder("cluster123").userValueTypeHint(ValueType.STRING);
import java.util.Set;
        sourceBuilder.explain(true);
    private static final String INDEX_NAME = "ccs_duel_index";
import org.opensearch.script.ScriptType;
/*
        sourceBuilder.collapse(new CollapseBuilder("user.keyword"));
        assumeMultiClusterSetup();
        searchRequest.source(sourceBuilder);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        assertEquals(2, searchResponse.getClusters().getSuccessful());
        assumeMultiClusterSetup();
        assertNull(response.getSuggest());
        joinField.put("name", type);
import java.util.HashMap;
    }
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        restHighLevelClient.searchAsync(searchRequest, RequestOptions.DEFAULT,
    public void testTermsAggs() throws Exception {
import org.opensearch.search.aggregations.pipeline.DerivativePipelineAggregationBuilder;
import org.opensearch.search.sort.SortOrder;
            }
                message.compareMaps(minimizeRoundtripsResponseMap, fanOutResponseMap);
import java.time.LocalDate;
        TopHitsAggregationBuilder topHits = new TopHitsAggregationBuilder("top");
    public void testTopHits() throws Exception {
import org.opensearch.action.bulk.BulkResponse;
 * ownership. Elasticsearch licenses this file to you under
        }
    private static IndexRequest buildIndexRequest(String id, String type, String questionId) {
        assertThat(searchResponse.getSuccessfulShards(), greaterThan(1));
                public void beforeBulk(long executionId, BulkRequest request) {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            if (minimizeRoundtripsResponseMap.equals(fanOutResponseMap) == false) {
        duelSearch(searchRequest, CCSDuelIT::assertHits);
                }
            assertHits(response);
    }
        });
        assumeMultiClusterSetup();
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        assumeMultiClusterSetup();
        for (Aggregation aggregation : aggregations) {
    private static final String REMOTE_INDEX_NAME = "my_remote_cluster:" + INDEX_NAME;
    private static void assumeMultiClusterSetup() {
        SuggestBuilder suggestBuilder = new SuggestBuilder();
    private static Map<String, Object> responseToMap(SearchResponse response) throws IOException {
    }
import com.carrotsearch.randomizedtesting.annotations.TimeoutSuite;
        assumeMultiClusterSetup();
    @AfterClass
    private static final String[] TAGS = new String[] {"java", "xml", "sql", "html", "php", "ruby", "python", "perl"};
    }
            new BulkProcessor.Listener() {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            PhraseSuggestion tags = response.getSuggest().getSuggestion("tags");
        AtomicReference<Exception> exception2 = new AtomicReference<>();
        SearchRequest searchRequest = initSearchRequest();
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
        duelSearch(searchRequest, response -> {
                "\"join\":{\"type\":\"join\", \"relations\": {\"question\":\"answer\"}}}}", MediaTypeRegistry.JSON);
        searchRequest.source(sourceBuilder);
    }
    }
        indexRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);
        answerPerUser.field("user.keyword");
import org.opensearch.index.query.TermQueryBuilder;
    public void testMatchAll() throws Exception {
        sourceBuilder.from(30);
 * SPDX-License-Identifier: Apache-2.0
            for (Map<String, Object> shard : shards) {
        CardinalityAggregationBuilder tags = new CardinalityAggregationBuilder("tags").userValueTypeHint(ValueType.STRING);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    private static class HighLevelClient extends RestHighLevelClient {
        assertEquals(201, indexResponse.status().getStatus());
            assertMultiClusterSearchResponse(response);
        SearchRequest searchRequest = initSearchRequest();
        topHits.sort("id", SortOrder.ASC);
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
import org.opensearch.client.RestHighLevelClient;
            assertHits(response);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            "tags", tagsArray,
        SearchRequest searchRequest = initSearchRequest();
        tags.subAggregation(topHits);
 * KIND, either express or implied.  See the License for the
            if (response.getHits().getTotalHits().value() > 30) {
import org.opensearch.search.suggest.phrase.DirectCandidateGeneratorBuilder;
        return indexRequest;
        sourceBuilder.collapse(new CollapseBuilder("user.keyword"));
        assumeMultiClusterSetup();
        searchRequest.source(sourceBuilder);
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/40005")
        answerPerUser.showTermDocCountError(true);
            assertNull(response.getSuggest());
        duelSearch(searchRequest, response -> {
                if (onlyRemote) {
import org.opensearch.search.suggest.phrase.PhraseSuggestionBuilder;
 * registered. Given that each test gets executed against both clusters, {@link #assumeMultiClusterSetup()} needs to be used to run a test
        if (profile != null) {
        assumeMultiClusterSetup();
                public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
            assertHits(response);
        BulkProcessor bulkProcessor = BulkProcessor.builder((r, l) -> restHighLevelClient.bulkAsync(r, RequestOptions.DEFAULT, l),
import org.opensearch.core.action.ActionListener;
        sourceBuilder.aggregation(answers);
        topHits.size(10);
    public void testExplain() throws Exception  {
    }
        if (response.getHits().getTotalHits().value() > from) {
        suggestBuilder.addSuggestion("python", new CompletionSuggestionBuilder("suggest").size(10).text("pyth"));
        assertHits(response, 0);
        duelSearch(searchRequest, response -> {
/*
 */
        assumeMultiClusterSetup();
        } else {
        assumeMultiClusterSetup();
        suggestBuilder.setGlobalText("jva and hml");
        });
    }
 * specific language governing permissions and limitations
        if (questionId != null) {
        List<String> indices = Arrays.asList(INDEX_NAME, "my_remote_cluster:" + INDEX_NAME);
        topHits.sort("creationDate", SortOrder.DESC);
    public void testHasChildWithInnerHit() throws Exception {
import java.util.List;
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
    @Override
        duelSearch(searchRequest, CCSDuelIT::assertHits);
        rescorerBuilder.setRescoreQueryWeight(5);
    public void testHighlighting() throws Exception  {
    }
import java.util.Collections;
        assertThat(response.getHits().getTotalHits().value(), greaterThan(0L));
import org.opensearch.search.sort.ScoreSortBuilder;
        assumeMultiClusterSetup();
}
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "sql"));
import org.opensearch.core.xcontent.XContentHelper;
            .userValueTypeHint(ValueType.STRING);
        String[] tagsArray = tags.toArray(new String[0]);
import java.io.IOException;
        createIndexRequest.settings(Settings.builder().put("index.number_of_shards", numShards).put("index.number_of_replicas", 0));
    @Before
    public void testSortByFieldOneClusterHasNoResults() throws Exception {
 * license agreements. See the NOTICE file distributed with
        searchRequest.source(sourceBuilder);
        IndexRequest indexRequest = new IndexRequest(INDEX_NAME);
        sourceBuilder.query(QueryBuilders.matchQuery("tags", "xml"));
 * The OpenSearch Contributors require contributions made to
        sourceBuilder.aggregation(cluster);
                throw new AssertionError("one of the two requests returned an exception", exception2.get());
        tags.showTermDocCountError(true);
