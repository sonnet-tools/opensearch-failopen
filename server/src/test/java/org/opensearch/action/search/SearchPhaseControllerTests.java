    }
        FieldDoc[] fieldDocs = new FieldDoc[nDocs];
    public void testMerge() {
            NetworkTime networkTime = mergedProfile.getNetworkTime();
        }
            QueryProfileShardResult queryResult = queryResults.get(0);
                ),
                exc -> {}
    }
        if (searchRequest.source() == null
                        maxScore = scoreDoc.score;
                for (int i = 0; i < optionSize; i++) {
            );
        int expectedNumResults = randomIntBetween(1, 100);
     * {@link SearchPhaseController#reducedQueryPhase} does,
 * ownership. Elasticsearch licenses this file to you under
    public void testPartialReduce() throws Exception {
        assertAggReduction(request);
                        j,
    /**
        boolean useConstantScore
            useConstantScore
    private static AtomicArray<SearchPhaseResult> generateQueryResultsWithIntLongSortedField(
        }
            request,
            List<Suggest.Suggestion<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>>> suggestions =
import static java.util.Collections.emptyMap;
            );
        assertEquals(0, reduce.sortedTopDocs.scoreDocs[0].doc);
            threads[i] = new Thread(() -> {
            fixedExecutor,
        int queryResultSize = randomBoolean() ? 0 : randomIntBetween(1, nShards * 2);
            threads[index] = new Thread(() -> {
                numTotalReducePhases = 2;
        int nShards,
        int batchedReduceSize = randomIntBetween(2, expectedNumResults - 1);
        int searchHitsSize,
            querySearchResult.profileResults(profileShardResult);
import org.opensearch.threadpool.TestThreadPool;
            public ReduceContext forFinalReduction() {
                }
        for (int shardIndex = 0; shardIndex < nShards; shardIndex++) {
        assertNull(reduce.sortedTopDocs.collapseField);
        });
                    new SearchShardTarget("node", new ShardId("a", "b", index), null, OriginalIndices.NONE),
                ),
        int nShards = 2;
 * You may obtain a copy of the License at
            float score = useConstantScore ? 1.0F : Math.abs(randomFloat());
        consumerTestCase(0);
                TermSuggestion.Entry entry = new TermSuggestion.Entry(new Text("entry"), 0, 10);
            null
            fetchSearchResult.hits(new SearchHits(hits, new TotalHits(hits.length, Relation.EQUAL_TO), maxScore));
                        );
        assertNull(reduce.sortedTopDocs.collapseValues);
            TopDocs topDocs = queryResult.consumeTopDocs().topDocs;
        for (int shardIndex = 0; shardIndex < nShards; shardIndex++) {
        }
        while (numEmptyResponses > 0) {
    }
            expectedNumResults,
            circuitBreaker.shouldBreak.set(true);
            result.setSearchShardTarget(new SearchShardTarget("node", new ShardId("a", "b", shardId), null, OriginalIndices.NONE));
            }
        return results;
    public void testConsumerOnlyHits() throws Exception {
            fixedExecutor,
        return new TopFieldDocs(new TotalHits(fieldDocs.length, TotalHits.Relation.EQUAL_TO), fieldDocs, sortFields);
            FetchProfileShardResult fetchProfileShardResult = new FetchProfileShardResult(Arrays.asList(fetchPhase));
                TermSuggestion termSuggestion = new TermSuggestion("term", 1, SortBy.SCORE);
                suggestion.addTerm(completionEntry);
                new ProfileResult(
                    Collections.emptyMap(),
        DocValueFormat[] docValueFormats = { DocValueFormat.RAW };
                request,
        }
import org.apache.lucene.search.SortField;
                Stream<CompletionSuggestion.Entry> stream = s.getEntries().stream();
import org.junit.After;
                assertEquals(0, reductions.size());
            request.setBatchedReduceSize(bufferSize);
            );
        assertNull(reduce.sortedTopDocs.sortFields);
    }
            assertNotNull("Query profile results should be preserved", queryResults);
        SearchRequest request = getAggregationSearchRequestWithBatchedReduceSize(batchedReduceSize);
            assertEquals(shouldFailPartial, hasConsumedFailure.get());
                termSuggestion.addTerm(entry);
            request,
            String clusterAlias = randomBoolean() ? null : "remote";
        assertTrue(reduce.sortedTopDocs.isSortedByField);
        int expectedNumResults = randomIntBetween(1, 100);
        assertNull("Merged profiles should be null when queryProfiles is null", mergedProfiles);
                null
    }
        assertEquals(1, reduce.sortedTopDocs.scoreDocs.length);
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(
            float maxScore = -1F;
                new NetworkTime(2L, 3L)
            new SearchShardTarget("node", new ShardId("a", "b", 0), null, OriginalIndices.NONE),
        }
        SortField[] sortFields = { new SortedNumericSortField("field", SortField.Type.LONG, true) };
            from = first.get().queryResult().from();
    private static TopFieldDocs getFloatTopFieldDocs(int nDocs, boolean useConstantScore) {
            ProfileResult mainQuery = queryProfileResults.get(0);
                randomIntBetween(50, 100),
    }
import org.opensearch.test.InternalAggregationTestCase;
                null
        assertEquals(max.get(), reduce.sortedTopDocs.scoreDocs[0].score, 0.0f);
    public void testSortIntFieldDocsMerge() {
        AtomicArray<SearchPhaseResult> results = generateQueryResults(nShards, suggestions, queryResultSize, false);
        assertEquals(12, reduce.totalHits.value());
            allocated += bytes;
        int queryResultSize = randomBoolean() ? 0 : randomIntBetween(1, nShards * 2);
     * Test to verify merge shard results with SortField.Type.Int, document type Integer
                return InternalAggregation.ReduceContext.forPartialReduction(
            ScoreDoc[] docs = new ScoreDoc[3];
 * The OpenSearch Contributors require contributions made to
    private static ShardSearchRequest createMockShardSearchRequest() {
                    "LoadDocValues",
    public void testConsumerConcurrently() throws Exception {
            }
            QuerySearchResult queryResult = result.queryResult();
            int number = randomIntBetween(1, 1000);
            consumer.consumeResult(result, latch::countDown);
                numTotalReducePhases = 1;
                new ProfileResult(
    }
import org.opensearch.search.internal.ShardSearchContextId;
            shardTargets.add(shardTarget);
                CompletionSuggestion completionSuggestion = new CompletionSuggestion("completion", 1, false);
                null
            expectedNumResults,
            assertEquals(reduce.aggregations, finalAggsListener.get());
    public void testCancellationDoesNotMaskCircuitBreakerException() throws Exception {
            Object[] values = { randomFrom(collapseValues) };
            QuerySearchResult result = new QuerySearchResult(
                    QuerySearchResult result = new QuerySearchResult(
import org.apache.lucene.search.grouping.CollapseTopFieldDocs;
                }
        if (shouldFail) {
        assertNull(reduce.sortedTopDocs.sortFields);
        // Test that the caller properly handles null queryProfiles
            float maxScore = 0;
            request,
            assertEquals("Should have query children", 2, mainQuery.getProfiledChildren().size());
            );
                            if (doc.score > maxScore) {
        for (int shardIndex = 0; shardIndex < nShards; shardIndex++) {
        }
                shardSuggestion.add(suggestion);
                public void onQueryResult(int shardIndex) {
        assertEquals(max.get(), reduce.sortedTopDocs.scoreDocs[0].score, 0.0f);
        assertNull(reduce.sortedTopDocs.collapseValues);
        if (first.isPresent()) {
        assertEquals(0, reduce.totalHits.value());
                    "TermsAggregator",
    }
                        assertEquals(
    }
 *
import org.apache.lucene.search.FieldDoc;
                topDocs = getLongTopFieldDocs(nDocs, useConstantScore);
        SearchRequest request = randomSearchRequest();
        AtomicInteger max = new AtomicInteger();
                for (int j = 0; j < numOptions; j++) {
                    Collections.emptyMap(),
    ) {
        List<SearchShardTarget> shardTargets = new ArrayList<>();
        for (int i = 0; i < expectedNumResults; i++) {
            );
                    if (!mergedProfile.getFetchProfileResult().getFetchProfileResults().isEmpty()) {
        SearchRequest request = randomSearchRequest();
                new ShardSearchContextId("", shardIndex),
    public void testSortIntFloatDoubleFieldDocsMerge() {
                new ShardId("", "", shardIndex),
        for (SearchPhaseResult result : results.asList()) {
            SearchRequest request = randomSearchRequest();
        List<CompletionSuggestion> suggestions,
        );
        AtomicArray<SearchPhaseResult> results = generateQueryResultsWithIntSortedField(nShards, suggestions, queryResultSize, false);
                assertSame(searchPhaseResult.getSearchShardTarget(), hit.getShard());
                new ShardSearchContextId("", i),
    public void cleanup() {
import org.opensearch.search.profile.NetworkTime;
        if (numShards > bufferSize) {
            float maxScore = 0;
            threadPool.getThreadContext()
                if (suggestion instanceof CompletionSuggestion) {
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
        List<CompletionSuggestion> suggestions = new ArrayList<>();
 * software distributed under the License is distributed on an
                    entry.addOption(new TermSuggestion.Entry.Option(new Text("option"), randomInt(), score));
            List<ProfileResult> queryChildren = Arrays.asList(
            request,
        int bufferSize = randomIntBetween(2, 200);
            }
                OriginalIndices.NONE
            assertNull(reduce.sortedTopDocs.sortFields);
        float maxScore = 0;
                            queryResult.getCollectorResult().getName()
            int shardId = 2 + numEmptyResponses;
                    Collections.emptyList()
                        assertEquals("Fetch phase should be FetchPhase", "FetchPhase", fetchProfile.getQueryName());
                );
                    () -> PipelineTree.EMPTY
        for (int i = 0; i < 10; i++) {
            request.source(new SearchSourceBuilder().size(randomIntBetween(1, 10)));
        consumeShardLevelQueryPhaseResultsAsync(expectedNumResults, consumer);
        result.aggregations(aggs);
            nShards,
                public void onFinalReduce(List<SearchShard> shards, TotalHits totalHits, InternalAggregations aggs, int reducePhase) {
            }
            ProfileResult fetchPhase = fetchProfile.getFetchProfileResults().get(0);
        assertEquals(expectedNumResults, reduce.totalHits.value());
import org.opensearch.search.internal.ShardSearchRequest;
                Collections.singletonList(new InternalMax("test", (double) number, DocValueFormat.RAW, Collections.emptyMap()))
        FieldDoc[] fieldDocs = new FieldDoc[nDocs];
                randomIntBetween(40, 80),
                assertEquals("Should have profiles for all shards", nShards, mergedResponse.profileResults.getShardResults().size());
        result = new QuerySearchResult(
            );
                Collections.emptyMap(),
        boolean useConstantScore = randomBoolean();
        assertEquals(expectedNumResults, reduce.totalHits.value());
    }
            CollectorResult collectorResult = new CollectorResult("TotalHitCountCollector", "counting hits", 50L, collectorChildren);
        List<CompletionSuggestion> suggestions = new ArrayList<>();
                        new TopDocsAndMaxScore(
        } else {
            result.suggest(new Suggest(suggestions));
        AssertingCircuitBreaker(String name) {
                throw new CircuitBreakingException(label, getDurability());
import org.opensearch.search.aggregations.metrics.InternalMax;
        List<TopDocs> topDocsList = new ArrayList<>();
        assertNotEquals(-1, reduce.sortedTopDocs.scoreDocs[0].shardIndex);
            assertNotNull("Fetch profile should be merged", fetchProfile);
                fetchResults.asList(),
        SearchPhaseController.ReducedQueryPhase reduce = consumer.reduce();
                max.updateAndGet(prev -> Math.max(prev, number));
import static org.hamcrest.Matchers.instanceOf;
        float maxScore = 0;
            fieldDocs[i] = new FieldDoc(i, score, new Integer[] { randomInt() });
                )
            if (mergedResponse.profileResults != null) {
                collectorResult
    }
import static org.hamcrest.Matchers.equalTo;
            consumer.consumeResult(result, latch::countDown);
                        Collections.singletonList(new InternalMax("test", (double) number, DocValueFormat.RAW, Collections.emptyMap()))
            threads[index].start();
    public void testReduceTopNWithFromOffset() throws Exception {
                circuitBreaker.shouldBreak.set(true);
            assertEquals("Should have one main query", 1, queryProfileResults.size());
        int queryResultSize = randomBoolean() ? 0 : randomIntBetween(1, nShards * 2);
            () -> {
    private static List<CompletionSuggestion> reducedSuggest(AtomicArray<SearchPhaseResult> results) {
        assertEquals("field", reduce.sortedTopDocs.collapseField);
        BytesRef b = new BytesRef("b");
            numEmptyResponses--;
     * Test to verify merge shard results with different SortField.Type.
            int number = randomIntBetween(1, 1000);
            size = first.get().queryResult().size();
    private static int getTotalQueryHits(AtomicArray<SearchPhaseResult> results) {
        for (int shardIndex = 0; shardIndex < nShards; shardIndex++) {
        assertFalse(reduce.sortedTopDocs.isSortedByField);
        int batchedReduceSize = randomIntBetween(2, expectedNumResults - 1);
                randomIntBetween(20, 40),
                    Collections.emptyMap(),
            SearchProgressListener.NOOP,
        int resultCount = 0;
        request.setBatchedReduceSize(bufferSize);
            new DocValueFormat[0]
                fetchProfileShardResult,
    }
                new CollectorResult("SimpleTopScoreDocCollector", "collecting docs", 30L, Collections.emptyList())
                Collections.emptyMap(),
        List<NamedWriteableRegistry.Entry> entries = new ArrayList<>(new SearchModule(Settings.EMPTY, emptyList()).getNamedWriteables());
                    finalAggsListener.set(aggs);
        ScoreDoc[] sortedDocs = SearchPhaseController.sortDocs(ignoreFrom, topDocsList, from, size, Collections.emptyList()).scoreDocs;
                }
            max.updateAndGet(prev -> Math.max(prev, number));
            result.topDocs(new TopDocsAndMaxScore(Lucene.EMPTY_TOP_DOCS, Float.NaN), new DocValueFormat[0]);
            suggestions.add(new CompletionSuggestion(randomAlphaOfLength(randomIntBetween(1, 5)), randomIntBetween(1, 20), false));
                            "LoadStoredFields",
                SearchPhaseResult searchPhaseResult = fetchResults.get(hit.getShard().getShardId().id());
            } else {
                for (int i = 0; i < nDocs; i++) {
        result.setShardIndex(1);
        }
            super(name);
            };
                    result.aggregations(aggs);
    public void testMergeFetchProfiles() {
                                maxScore = doc.score;
                collectorChildren
        consumeShardLevelQueryPhaseResultsAsync(expectedNumResults, consumer);
                int optionSize = randomIntBetween(1, suggestion.getSize());
                new TopDocsAndMaxScore(
                    Collections.emptyMap(),
            assertEquals(0, reductions.size());
            result.from(5);
            return allocated;
                    assertEquals(numReduceListener.incrementAndGet(), reducePhase);
import java.util.Collections;
                aggChildren
        latch.await();
    }
                }
        assertEquals(sortedDocs.length, sortedDocs2.length);
                }
public class SearchPhaseControllerTests extends OpenSearchTestCase {
                    Collections.emptyList()
            // Add fetch profile data
                    Collections.emptyMap(),
            CompletionSuggestion completion = reduce.suggest.getSuggestion("completion");
import org.apache.lucene.util.BytesRef;
                new ProfileResult(
                CompletionSuggestion suggestion = new CompletionSuggestion(
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(
        searchPhaseController = new SearchPhaseController(writableRegistry(), s -> new InternalAggregation.ReduceContextBuilder() {
        );
            exc -> {}
            ProfileResult fetchPhase = new ProfileResult(
        }
            for (Suggest.Suggestion s : reducedQueryPhase.suggest) {
import org.opensearch.search.query.QuerySearchResult;
        for (int i = 0; i < expectedNumResults; i++) {
import org.opensearch.search.internal.AliasFilter;
            float maxScore = 0;
    private static TopFieldDocs getDoubleTopFieldDocs(int nDocs, boolean useConstantScore) {
                topDocs = getFloatTopFieldDocs(nDocs, useConstantScore);
        return queryResults;
            FieldDoc[] fieldDocs = { new FieldDoc(0, Float.NaN, values) };
    }
        assertEquals(a, ((FieldDoc) reduce.sortedTopDocs.scoreDocs[0]).fields[0]);
        List<CompletionSuggestion> suggestions = new ArrayList<>();
                aggResults,
        int expectedNumResults = randomIntBetween(1, 100);
            SearchPhaseController.setShardIndex(topDocs, result.getShardIndex());
            ProfileResult aggProfile = new ProfileResult(
                reducedQueryPhase,
import org.opensearch.search.internal.InternalSearchResponse;
            for (SearchHit hit : mergedResponse.hits().getHits()) {
        }
        // Set network timing
    private static class AssertingCircuitBreaker extends NoopCircuitBreaker {
        int expectedNumResults = randomIntBetween(30, 100);
                    number
                return InternalAggregation.ReduceContext.forFinalReduction(
        assertEquals(b, ((FieldDoc) reduce.sortedTopDocs.scoreDocs[1]).fields[0]);
        );
                }
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(
            );
            result.setShardIndex(shardId);
                        );
                    null
            consumer.consumeResult(result, latch::countDown);
            r -> InternalAggregationTestCase.emptyReduceContextBuilder()
            SearchShardTarget shardTarget = new SearchShardTarget("", new ShardId("", "", shardIndex), clusterAlias, OriginalIndices.NONE);
                nShards,
            return allocated;
                progressListener,
    private static void consumeShardLevelQueryPhaseResultsAsync(int expectedNumResults, QueryPhaseResultConsumer consumer)
        }
                    suggestion.getName(),
                        ),
        request.setOutboundNetworkTime(randomIntBetween(1, 5));
                        new DocValueFormat[0]
            expectedNumResults,
        public long addWithoutBreaking(long bytes) {
            );
    public void testProgressListener() throws Exception {
            );
        );
        result.setShardIndex(0);
                    max.updateAndGet(prev -> Math.max(prev, number));
            result.topDocs(new TopDocsAndMaxScore(topDocs, Float.NaN), docValueFormats);
            new ShardSearchContextId("", 1),
            final TopDocs topDocs;
        return resultCount;
                Collections.emptyMap(),
            int nDocs = randomIntBetween(0, searchHitsSize);
            QuerySearchResult result = new QuerySearchResult(
            List<CollectorResult> collectorChildren = Arrays.asList(
            SearchProgressListener.NOOP,
            assertEquals("First fetch child should be LoadStoredFields", "LoadStoredFields", fetchChildren.get(0).getQueryName());
            int id = i;
            QuerySearchResult result = new QuerySearchResult(
                    result.setShardIndex(id);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        }
                fetchChildren
            ProfileShardResult queryProfile = new ProfileShardResult(
                ),
        ScoreDoc[] scoreDocs = reduce.sortedTopDocs.scoreDocs;
            10,
        assertAggReduction(request);
        int nShards,
        result.setShardIndex(2);
            latch.await();
        long randomSeed = randomLong();
            } else {
    private AtomicArray<SearchPhaseResult> generateSeededQueryResults(
 * license agreements. See the NOTICE file distributed with
                new ShardSearchContextId("", i),
            empty.setShardIndex(2 + numEmptyResponses);
                null
                    "loading _source",
import org.opensearch.search.aggregations.InternalAggregation;
                    BigArrays.NON_RECYCLING_INSTANCE,
            final TopDocs topDocs;
                        number
import org.apache.lucene.search.TotalHits;
                    int score = numOptions - j;
            assertNotNull("Merged profile should exist for shard " + shardId, mergedProfile);
    }
                Collections.emptyMap(),
        SearchRequest request = randomSearchRequest();
        assertNull(reduce.sortedTopDocs.collapseField);
                clusterAlias,
        }
        int searchHitsSize,
        if (numEmptyResponses == 0) {
                    s -> new ArrayList<>()
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
import org.opensearch.search.profile.SearchProfileShardResults;
        assertTrue(reduce.sortedTopDocs.isSortedByField);
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
                    ),
    }
        int expectedNumResults = randomIntBetween(20, 200);
        int nShards = randomIntBetween(1, 20);
    }
    /**
     */
                        assertSame(searchPhaseResult.getSearchShardTarget(), option.getHit().getShard());
            request,
                    randomIntBetween(25, 50),
                new SearchPhaseController.TopDocsStats(trackTotalHits),
                "fetch documents",
        }
import org.opensearch.search.profile.ProfileResult;
        int nShards = randomIntBetween(1, 20);
            if (i % 2 == 0) {
        SearchPhaseController.ReducedQueryPhase reduce = consumer.reduce();
                        assertEquals(
        for (SearchPhaseResult result : results.asList()) {
            request.source(new SearchSourceBuilder().aggregation(AggregationBuilders.avg("foo")));
                        }
            );
            ProfileResult aggProfile = new ProfileResult(
        Optional<SearchPhaseResult> first = results.asList().stream().findFirst();
            ProfileResult mainQuery = new ProfileResult(
        SortField[] sortFields = { new SortedNumericSortField("field", SortField.Type.DOUBLE, true) };
                );
    }
        for (int i = 0; i < nDocs; i++) {
import org.opensearch.common.UUIDs;
                assertEquals(1, consumer.getNumReducePhases());
        } else {
 * under the License.
    }
    }
            result = QuerySearchResult.nullInstance();
        List<CompletionSuggestion> suggestions = new ArrayList<>();
            querySearchResult.topDocs(new TopDocsAndMaxScore(topDocs, maxScore), null);
            List<SearchHit> searchHits = new ArrayList<>();
        request.setBatchedReduceSize(randomIntBetween(2, 4));
        for (int i = 0; i < nDocs; i++) {
    }
        aggs = InternalAggregations.from(singletonList(new InternalMax("test", 2.0D, DocValueFormat.RAW, emptyMap())));
                result.size(1);
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
        int bufferSize = randomIntBetween(2, 200);
                    randomIntBetween(5, 15),
import org.opensearch.search.profile.query.CollectorResult;
        }
                "BooleanQuery",
                for (Map.Entry<String, ProfileShardResult> entry : mergedResponse.profileResults.getShardResults().entrySet()) {
        assertEquals(max.get(), reduce.maxScore, 0.0f);
    private static AtomicArray<SearchPhaseResult> generateQueryResultsWithIntSortedField(
                );
            QuerySearchResult result = new QuerySearchResult(
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
                @Override
    }
        SortField[] sortFields = { new SortedNumericSortField("field", SortField.Type.FLOAT, true) };
                QuerySearchResult result = new QuerySearchResult(
            QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(
        int searchHitsSize,
        }
import static org.hamcrest.Matchers.containsString;
import java.util.ArrayList;
                    Collections.emptyMap(),
                result.aggregations(aggs);
            NetworkTime networkTime = new NetworkTime(5L, 10L);
                for (int j = 0; j < numOptions; j++) {
            assertEquals(0, reductions.size());
        for (int i = 0; i < expectedNumResults; i++) {
 *
                    InternalAggregations aggs = InternalAggregations.from(
        for (int shardIndex = 0; shardIndex < nShards; shardIndex++) {
            for (Suggest.Suggestion<?> suggestion : mergedSuggest) {
                        new SearchShardTarget("node", new ShardId("a", "b", id), null, OriginalIndices.NONE),
                    Collections.emptyMap(),
        long seed,
            }
                    consumer.consumeResult(result, latch::countDown);
        );
                );
                randomIntBetween(5, 15), // rewrite time
        assertNull(reduce.sortedTopDocs.sortFields);
        assertEquals(92.0f, scoreDocs[3].score, 0.0f);
        request.source(new SearchSourceBuilder().aggregation(AggregationBuilders.avg("foo")));
                Collections.emptyMap(),
import org.opensearch.core.common.breaker.CircuitBreaker;
    private void consumerTestCase(int numEmptyResponses) throws Exception {
import java.util.concurrent.atomic.AtomicReference;
                assertEquals(1, reductions.size());
            AggregationProfileShardResult aggResults = new AggregationProfileShardResult(Arrays.asList(aggProfile));
        int partialReduceMethodCallCount = expectedNumResults / batchedReduceSize;
            );
        int accumulatedLength = Math.min(queryResultSize, getTotalQueryHits(results));
        assertThat(circuitBreaker.allocated, equalTo(0L));
            }
        }
        int from = 0, size = 0;
                true
    public void testConsumerSortByField() throws Exception {
        );
            nShards,
        if (numEmptyResponses > 0) {
            assertEquals(0, numQueryFailureListener.get());
            fixedExecutor,
        assertEquals("field", reduce.sortedTopDocs.sortFields[0].getField());
import static java.util.Collections.singletonList;
        }
        BytesRef a = new BytesRef("a");
    /**
            AtomicInteger max = new AtomicInteger();
            result.setShardIndex(i);
        assertAggReduction(request);
                new ShardSearchContextId("", i),
    }
        assertEquals(expectedNumResults, reduce.totalHits.value());
        float maxScore = 0;
                }
                Arrays.asList(queryShardResult),
     * meaning that the returned query results can be fed directly to {@link SearchPhaseController#sortDocs}
                suggestions.add(phraseSuggestion);
            float score = useConstantScore ? 1.0F : Math.abs(randomFloat());
        }
        float maxScore = 0;
            @Override
                new ProfileResult("TermQuery", "field:value", Collections.emptyMap(), Collections.emptyMap(), 15L, Collections.emptyList()),
                    maxScoreCompletion = Math.max(maxScoreCompletion, score);
                    CompletionSuggestion.Entry.Option option = new CompletionSuggestion.Entry.Option(
                List<Suggest.Suggestion<CompletionSuggestion.Entry>> suggests = groupedSuggestion.computeIfAbsent(
            Suggest suggestResult = mergedResponse.suggest();
            request,
        SearchProfileShardResults queryProfiles = new SearchProfileShardResults(queryProfileMap);
        CountDownLatch latch = new CountDownLatch(expectedNumResults);
                    "loading _source",
        int maxSuggestSize = 0;
     */
            }
            result.size(5);
        @Override
        final int numTotalReducePhases;
        AtomicInteger checkCount = new AtomicInteger(expectedNumResults + partialReduceMethodCallCount);
            float score = useConstantScore ? 1.0F : Math.abs(randomFloat());
        return new TopFieldDocs(new TotalHits(fieldDocs.length, TotalHits.Relation.EQUAL_TO), fieldDocs, sortFields);
                    Collections.singletonList(new InternalMax("test", (double) number, DocValueFormat.RAW, Collections.emptyMap()))
        List<CompletionSuggestion> suggestions,
            );
            if (searchHitsSize == 0) {
            testReduceCase(false);
    private static AtomicArray<SearchPhaseResult> generateQueryResults(
        return request;
        for (int i = 0; i < nDocs; i++) {
                    );
        result.aggregations(aggs);
            new SearchShardTarget("node", new ShardId("a", "b", 0), null, OriginalIndices.NONE),
            .runWithPrivateRandomness(seed, () -> generateQueryResults(nShards, suggestions, searchHitsSize, useConstantScore));
        result.aggregations(aggs);
        assertAggReduction(request);
        return results;
        request.setBatchedReduceSize(bufferSize);
        SearchRequest request = randomSearchRequest();
        int nShards = randomIntBetween(1, 20);
                InternalAggregations aggs = InternalAggregations.from(
        );
        AtomicInteger max = new AtomicInteger();
            // Create empty fetch profile (will be replaced by merge)
        int queryResultSize = randomBoolean() ? 0 : randomIntBetween(1, nShards * 2);
            suggestions.add(new CompletionSuggestion(randomAlphaOfLength(randomIntBetween(1, 5)), randomIntBetween(1, 20), false));
            result.setShardIndex(i);
            null
    ) {
        throws InterruptedException {
        assertNull(reduce.sortedTopDocs.collapseValues);
        int nShards,
import org.opensearch.search.aggregations.InternalAggregation.ReduceContext;
            fixedExecutor,
                InternalAggregations aggs = InternalAggregations.from(
        assertEquals(0, reduce.sortedTopDocs.scoreDocs.length);
        }
                aggChildren
        aggs = InternalAggregations.from(singletonList(new InternalMax("test", 3.0D, DocValueFormat.RAW, emptyMap())));
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
            assertEquals("Inbound network time should be from query phase", 5L, networkTime.getInboundNetworkTime());
     * Test to verify merge shard results with SortField.Type.Float, document type Float
        BytesRef c = new BytesRef("c");
    }
            }
            fieldDocs[i] = new FieldDoc(i, score, new Long[] { randomLong() });
        boolean shouldFailPartial = shouldFail && randomBoolean();
            }
            max.updateAndGet(prev -> Math.max(prev, number));
        );
                    Collections.emptyMap(),
            expectedNumResults,
                "FetchPhase",
        for (Suggest.Suggestion<?> suggestion : reducedCompletionSuggestions) {
            result.setShardIndex(i);
                new ProfileResult(
    public void testConsumer() throws Exception {
        performSortDocs(results, queryResultSize);
                    Collections.emptyList()
}
        List<SearchPhaseResult> fetchResults = new ArrayList<>();
        assertEquals(SortField.Type.STRING, reduce.sortedTopDocs.sortFields[0].getType());
            result.setShardIndex(i);
                    numQueryResultListener.incrementAndGet();
        InternalAggregations aggs = InternalAggregations.from(singletonList(new InternalMax("test", 1.0D, DocValueFormat.RAW, emptyMap())));
        }
            QueryProfileShardResult queryShardResult = new QueryProfileShardResult(
        assertEquals(maxScoreCompletion, reduce.sortedTopDocs.scoreDocs[0].score, 0f);
                threads[i].start();
                );
            assertFalse(reduce.sortedTopDocs.isSortedByField);
                searchShardTarget,
        } else {
            request,
                emptyFetchResults,
                new DocValueFormat[0]
 * this file be licensed under the Apache-2.0 license or a
            } else {
        SortField[] sortFields = { new SortField("field", SortField.Type.INT, true) };
            } else {
        assertNull(reduce.sortedTopDocs.collapseField);
            consumer.consumeResult(result, latch::countDown);
    }
            new TopDocsAndMaxScore(new TopDocs(new TotalHits(0, TotalHits.Relation.EQUAL_TO), new ScoreDoc[0]), Float.NaN),
                    new DocValueFormat[0]
            ProfileResult aggProfile = aggResult.getProfileResults().get(0);
        return groupedSuggestion.values().stream().map(completionSuggestion::reduce).collect(Collectors.toList());
        }
    ) {
            );
    }
            assertThat(exc.getMessage(), containsString("<reduce_aggs>"));
            suggestions.add(new CompletionSuggestion(randomAlphaOfLength(randomIntBetween(1, 5)), size, false));
        AtomicInteger checkCount = new AtomicInteger(expectedNumResults + partialReduceMethodCallCount);
            fixedExecutor,
    /**
        assertAggReduction(request);
                @Override
        FieldDoc[] fieldDocs = new FieldDoc[nDocs];
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(
import org.opensearch.search.aggregations.InternalAggregations;
        return results;
        request.setBatchedReduceSize(bufferSize);
        consumeShardLevelQueryPhaseResultsAsync(expectedNumResults, consumer);
            TopDocs topDocs = shardResult.queryResult().topDocs().topDocs;
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.search.profile.aggregation.AggregationProfileShardResult;
    @After
                assertEquals(mergedResponse.hits.getTotalHits().relation(), Relation.EQUAL_TO);
        for (int i = 0; i < results.length(); i++) {
                        Collections.emptyMap()
                reductions.add(false);
                null
                    false
            }
                    Collections.emptyMap(),
        AtomicArray<SearchPhaseResult> fetchResults = new AtomicArray<>(nShards);
                int number = randomIntBetween(1, 1000);
import java.util.Optional;
                    entry.addOption(option);
        );
                assertThat(suggestion, instanceOf(CompletionSuggestion.class));
        }
            fixedExecutor,
            SearchProgressListener progressListener = new SearchProgressListener() {
        boolean useConstantScore
        int bufferSize = randomIntBetween(2, 200);
        boolean useConstantScore
            List<QueryProfileShardResult> queryResults = mergedProfile.getQueryProfileResults();
    ) throws Exception {
            assertEquals(1, term.getEntries().size());
            assertThat(reductions.size(), greaterThanOrEqualTo(1));
            );
        for (int i = 0; i < results.length(); i++) {
            assertEquals("Should have collector children", 1, queryResult.getCollectorResult().getProfiledChildren().size());
            QuerySearchResult empty = QuerySearchResult.nullInstance();
    @Override
            max.updateAndGet(prev -> Math.max(prev, number));
                )
        AssertingCircuitBreaker circuitBreaker = new AssertingCircuitBreaker(CircuitBreaker.REQUEST);
        int from = 0, size = 0;
                new SearchShardTarget("node", new ShardId("a", "b", i), null, OriginalIndices.NONE),
        assertNull(reduce.sortedTopDocs.collapseField);
                expectedNumResults,
            FetchSearchResult fetchResult = new FetchSearchResult(new ShardSearchContextId("", shardIndex), shardTarget);
    private static SearchRequest randomSearchRequest() {
            List<CompletionSuggestion> shardSuggestion = new ArrayList<>();
        for (int i = 0; i < expectedNumResults; i++) {
        request.setBatchedReduceSize(bufferSize);
                        assertEquals("Should have 2 query children", 2, queryResult.getQueryResults().get(0).getProfiledChildren().size());
            QuerySearchResult queryResult = result.queryResult();
                "FetchPhase",
            }
                    assertNotNull("Network time should be preserved", mergedProfile.getNetworkTime());
            assertEquals(maxScorePhrase, phrase.getEntries().get(0).getOptions().get(0).getScore(), 0f);
            from = first.get().queryResult().from();
        int bufferSize = randomIntBetween(2, 200);
                    entry.addOption(new PhraseSuggestion.Entry.Option(new Text("option"), new Text("option"), score));
                    "LoadStoredFields",
                    "loading doc values",
            List<ProfileResult> queryChildren = Arrays.asList(
        }
        Map<String, ProfileShardResult> queryProfileMap = new HashMap<>();
        AtomicBoolean hasConsumedFailure = new AtomicBoolean();
        int queryResultSize = randomBoolean() ? 0 : randomIntBetween(1, nShards * 2);
        // This simulates what happens in buildResponse when shardResults is null
                );
            List<ProfileResult> aggChildren = Arrays.asList(
                Collections.emptyMap(),
            expectedNumResults,
            : SearchRequest.subSearchRequest(new SearchRequest(), Strings.EMPTY_ARRAY, "remote", 0, randomBoolean());
        assertEquals(1, reduce.sortedTopDocs.sortFields.length);
            "test",
                new SearchShardTarget("node", new ShardId("a", "b", i), null, OriginalIndices.NONE),
                            }
        }
        }
                0,
            );
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;
    private static AtomicArray<SearchPhaseResult> generateFetchResults(int nShards, ScoreDoc[] mergedSearchDocs, Suggest mergedSuggest) {
        performSortDocs(results, queryResultSize);
                    Collections.emptyMap(),
                "BooleanQuery",
        Map<String, List<Suggest.Suggestion<CompletionSuggestion.Entry>>> groupedSuggestion = new HashMap<>();
            );
    }
        SearchRequest request = randomSearchRequest();
        return fetchResults;
        int numShards = 3 + numEmptyResponses;
        assertNull(reduce.sortedTopDocs.sortFields);
            ProfileShardResult fetchProfileResult = new ProfileShardResult(
                new SearchShardTarget("node", new ShardId("a", "b", i), null, OriginalIndices.NONE),
import org.opensearch.search.SearchModule;
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
            maxScore = Math.max(score, maxScore);
            fetchResults.set(shardIndex, fetchSearchResult);
                    40L,
/*
            assertEquals(reduce.totalHits, totalHitsListener.get());
                topDocs = getIntTopFieldDocs(nDocs, useConstantScore);
    public void testConsumerOnlyAggs() throws Exception {
    }
        assertEquals(expectedNumResults, reduce.totalHits.value());
            }
        AtomicInteger max = new AtomicInteger();
            SearchPhaseController.ReducedQueryPhase reduce = consumer.reduce();
        }
            circuitBreaker,
        }
                new ShardSearchContextId("", i),
            );
                        new ShardSearchContextId("", id),
                assertEquals(false, reductions.get(0));
            assertEquals(1, reduce.sortedTopDocs.scoreDocs.length);
        return new TopFieldDocs(new TotalHits(fieldDocs.length, TotalHits.Relation.EQUAL_TO), fieldDocs, sortFields);
                    completionSuggestion.getSize(),
                20L, // rewrite time
            SearchShardTarget shardTarget = new SearchShardTarget(
            }
        boolean useConstantScore
            InternalMax internalMax = (InternalMax) reduce.aggregations.asList().get(0);
    public void testPartialReduceWithFailure() throws Exception {
import org.opensearch.common.settings.Settings;
                new NoopCircuitBreaker(CircuitBreaker.REQUEST),
            SearchShardTarget shardTarget = shardTargets.get(shardIndex);
        boolean useConstantScore
    // Helper method to create a mock ShardSearchRequest for testing
                    "BooleanQuery",
            QuerySearchResult querySearchResult = new QuerySearchResult(
        result.topDocs(
        if (randomBoolean()) {
        for (int i = 0; i < results.length(); i++) {
            result.setShardIndex(i);
            assertEquals("Should have aggregation children", 1, aggProfile.getProfiledChildren().size());
                    List<CompletionSuggestion.Entry.Option> options = suggestionResult.getEntries().get(0).getOptions();
        assertEquals(93.0f, scoreDocs[2].score, 0.0f);
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
            for (int j = 0; j < docs.length; j++) {
        }
                    CompletionSuggestion suggestionResult = suggestResult.getSuggestion(suggestion.getName());
            assertAggReduction(request);
                    }
        SearchRequest request = new SearchRequest();
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
        assertEquals(91.0f, scoreDocs[4].score, 0.0f);
        assertEquals(max.get(), reduce.maxScore, 0.0f);
    }
                    result.topDocs(
        Object[] collapseValues = new Object[] { a, b, c };
        fixedExecutor.shutdownNow();
            fetchSearchResult.profileResults(fetchProfileResult);
        }
                queryChildren
                null
        request.setBatchedReduceSize(bufferSize);
                int numOptions = randomIntBetween(1, 10);
            fetchResults.add(fetchResult);
import org.opensearch.search.profile.query.QueryProfileShardResult;
        return new NamedWriteableRegistry(entries);
        assertEquals(Math.min(expectedNumResults, size), reduce.sortedTopDocs.scoreDocs.length);
            assertEquals("Outbound network time should be from query phase", 10L, networkTime.getOutboundNetworkTime());
            topDocsList.add(topDocs);
                    "LoadDocValues",
            new DocValueFormat[0]
                public void onQueryFailure(int shardIndex, SearchShardTarget shardTarget, Exception exc) {
        }
        int queryResultSize = randomBoolean() ? 0 : randomIntBetween(1, nShards * 2);
        }
                new NetworkTime(randomIntBetween(1, 3), randomIntBetween(1, 3))
            maxScore = Math.max(score, maxScore);
                int numOptions = randomIntBetween(1, 10);
                Collections.emptyMap(),
        return randomBoolean()
            InternalAggregations aggs = InternalAggregations.from(
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        for (SearchPhaseResult entry : results.asList()) {
                suggestions.add(completionSuggestion);
                            "Collector should be TotalHitCountCollector",
            size = first.get().queryResult().size();
                "main query",
                    Collections.emptyMap(),
                    Collections.emptyList()
            }
                    Collections.emptyMap(),
        int nShards,
    }
                        assertEquals("Should have 2 fetch children", 2, fetchProfile.getProfiledChildren().size());
 * Modifications Copyright OpenSearch Contributors. See
                    randomIntBetween(3, 10),
    /**
            int suggestSize = 0;
                topDocs = Lucene.EMPTY_TOP_DOCS;
                    assertThat(options.size(), equalTo(suggestion.getEntries().get(0).getOptions().size()));
            resultCount += (int) topDocs.totalHits.value();
                        assertEquals(
        int nShards = randomIntBetween(1, 20);
        // To make it deterministic, we can count the number of times the partialReduce and reduce are called
        int nShards = randomIntBetween(1, 20);
        assertEquals(1, reduce.sortedTopDocs.scoreDocs.length);
                    int score = numOptions - j;
                new ArrayList<>(),
                aggResults,
        latch.await();
        latch.await();
        if (first.isPresent()) {
                    for (CompletionSuggestion.Entry.Option option : options) {
/*
        int expectedNumResults = randomIntBetween(20, 200);
        );
 * the Apache License, Version 2.0 (the "License"); you may
            assertEquals("Main query time should be preserved", 100L, mainQuery.getTime());
                35L,
                public void onPartialReduce(List<SearchShard> shards, TotalHits totalHits, InternalAggregations aggs, int reducePhase) {
        int expectedNumResults = randomIntBetween(1, 100);
            suggestions.add(new CompletionSuggestion(randomAlphaOfLength(randomIntBetween(1, 5)), randomIntBetween(1, 20), false));
                completionSuggestion.addTerm(entry);
 * compatible open source license.
            CompletionSuggestion.Entry.Option option = completion.getOptions().get(0);
        latch.await();
                    "BooleanQuery",
            allocated += bytes;
                    numQueryFailureListener.incrementAndGet();
                    assertThat(shardIndex, lessThan(expectedNumResults));
                    maxScorePhrase = Math.max(maxScorePhrase, score);
            suggestions.add(new CompletionSuggestion(randomAlphaOfLength(randomIntBetween(1, 5)), randomIntBetween(1, 20), false));
            );
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
                InternalAggregationTestCase.emptyReduceContextBuilder(),
                    randomIntBetween(15, 30),
                )
                CompletionSuggestion.Entry entry = new CompletionSuggestion.Entry(new Text("entry"), 0, 10);
                QuerySearchResult result = new QuerySearchResult(
 * KIND, either express or implied.  See the License for the
        }
            threads[i].join();
            int number = randomIntBetween(1, 1000);
                    "TermQuery",
        );
        request.setBatchedReduceSize(bufferSize);
                    result.size(1);
                        maxScoreValue -= dec;
                    for (CompletionSuggestion.Entry.Option option : ((CompletionSuggestion) suggestion).getOptions()) {
                    Collections.emptyMap(),
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;
        if (shouldFailPartial) {
            int size = randomIntBetween(1, 20);
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(
            AtomicReference<InternalAggregations> finalAggsListener = new AtomicReference<>();
            suggestions,
import java.util.List;
        for (int i = 0; i < expectedNumResults; i++) {
                            "First fetch child should be LoadStoredFields",
            );
        assertEquals(numTotalReducePhases, reduce.numReducePhases);
    public void testConsumerSuggestions() throws Exception {
        return request;
            AtomicInteger numQueryFailureListener = new AtomicInteger();
            () -> {
        InternalMax max = (InternalMax) reduce.aggregations.asList().get(0);
                new SearchShardTarget("node", new ShardId("a", "b", i), null, OriginalIndices.NONE),
            {
        }
            SearchProgressListener.NOOP,
                        SearchPhaseResult searchPhaseResult = fetchResults.get(option.getHit().getShard().getShardId().id());
        performSortDocs(results, queryResultSize);
                suggestion.setShardIndex(shardIndex);
                    b -> {},
                OriginalIndices.NONE
                    Collections.emptyList()
                Collections.emptyMap(),
    }
        int queryResultSize = randomBoolean() ? 0 : randomIntBetween(1, nShards * 2);
        assertEquals(3, reduce.sortedTopDocs.scoreDocs.length);
            writableRegistry(),
package org.opensearch.action.search;
                    ProfileShardResult mergedProfile = entry.getValue();
     */
                    Collections.emptyList()
                new ProfileResult(
        Thread[] threads = new Thread[expectedNumResults];
        consumer.consumeResult(result, latch::countDown);
            // Verify profile merging worked correctly (when profiles are present)
                    new TopDocsAndMaxScore(
 * GitHub history for details.
        );
            List<ProfileResult> fetchChildren = Arrays.asList(
            maxScore = Math.max(score, maxScore);
        {
            }
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(
import org.opensearch.action.OriginalIndices;
            new ShardSearchContextId("", 1),
        List<TopDocs> topDocsList = new ArrayList<>();
                suggestSize += stream.collect(Collectors.summingInt(e -> e.getOptions().size()));
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
            request,
                new TopDocsAndMaxScore(new TopDocs(new TotalHits(3, TotalHits.Relation.EQUAL_TO), docs), docs[0].score),
            assertThat(mergedResponse.hits().getHits().length, equalTo(reducedQueryPhase.sortedTopDocs.scoreDocs.length - suggestSize));
        );
            SearchPhaseController.setShardIndex(topDocs, result.getShardIndex());
            fetchResult.profileResults(fetchProfileResult);
        topDocsList = new ArrayList<>();
                )
        }
        assertEquals("Should have profiles for all shards", nShards, mergedProfiles.getShardResults().size());
                "GlobalAggregator",
        CompletionSuggestion completionSuggestion = new CompletionSuggestion(null, -1, randomBoolean());
            topDocsList.add(topDocs);
        SortField[] sortFields = { new SortField("field", SortField.Type.STRING) };
        int expectedNumResults = randomIntBetween(10, 100);
            ProfileResult mainQuery = new ProfileResult(
                threads[i] = new Thread(() -> {
                Arrays.asList(mainQuery),
            OpenSearchExecutors.daemonThreadFactory("test"),
                        );
            result.size(0);
                new DocValueFormat[0]
import org.opensearch.common.util.BigArrays;
            TopDocs topDocs = queryResult.consumeTopDocs().topDocs;
                    Collections.emptyList()
                            "BooleanQuery",
    private OpenSearchThreadPoolExecutor fixedExecutor;
                "global agg",
        assertAggReduction(request);
            );
import org.opensearch.search.builder.SearchSourceBuilder;
import org.opensearch.core.common.text.Text;
            TermSuggestion term = reduce.suggest.getSuggestion("term");
                new ShardSearchContextId("", i),
                final CompletionSuggestion.Entry completionEntry = new CompletionSuggestion.Entry(new Text(""), 0, 5);
                    float score = useConstantScore ? 1.0F : Math.abs(randomFloat());
        AssertingCircuitBreaker circuitBreaker = new AssertingCircuitBreaker(CircuitBreaker.REQUEST);
                    null
                    }
    @Before
                    searchHits.add(new SearchHit(scoreDoc.doc, "", Collections.emptyMap(), Collections.emptyMap()));
                topDocs = getDoubleTopFieldDocs(nDocs, useConstantScore);
        assertEquals(1, reduce.sortedTopDocs.scoreDocs.length);
        CountDownLatch latch = new CountDownLatch(expectedNumResults);
    public void testSortIntLongFieldDocsMerge() {
        AtomicArray<SearchPhaseResult> results = generateQueryResultsWithFloatSortedField(nShards, suggestions, queryResultSize, false);
 * not use this file except in compliance with the License.
            exc -> {},
        request.source(new SearchSourceBuilder().aggregation(AggregationBuilders.avg("foo")).size(0));
            circuitBreaker,
            final TopDocs topDocs = getFloatTopFieldDocs(nDocs, useConstantScore);
            exc -> {}
        SearchPhaseController.ReducedQueryPhase reduce = consumer.reduce();
        for (int i = 0; i < 4; i++) {
                createMockShardSearchRequest()
        AssertingCircuitBreaker circuitBreaker = new AssertingCircuitBreaker(CircuitBreaker.REQUEST);
import static java.util.Collections.emptyList;
            exc -> {}
                    Collections.emptyList()
        for (int trackTotalHits : new int[] { SearchContext.TRACK_TOTAL_HITS_DISABLED, SearchContext.TRACK_TOTAL_HITS_ACCURATE }) {
        );
            InternalSearchResponse mergedResponse = searchPhaseController.merge(
            assertEquals("Should have one aggregation profile", 1, aggResult.getProfileResults().size());
        for (int i = 0; i < results.length(); i++) {
            querySearchResult.setShardIndex(shardIndex);
                "counting hits",
                }
                    BigArrays.NON_RECYCLING_INSTANCE,
                networkTime
            expectedNumResults,
            AtomicReference<TotalHits> totalHitsListener = new AtomicReference<>();
                result.aggregations(aggs);
            || searchRequest.source().aggregations() == null
            );
                    }
        assertEquals(max.get(), ((FieldDoc) reduce.sortedTopDocs.scoreDocs[0]).fields[0]);
    private static SearchRequest getAggregationSearchRequestWithBatchedReduceSize(int batchedReduceSize) {
            assertEquals(1, term.getEntries().get(0).getOptions().size());
            result.topDocs(
                Collections.emptyMap(),
            assertEquals(sortedDocs[i].score, sortedDocs2[i].score, 0.0f);
                docs[j] = new ScoreDoc(0, score--);
            assertEquals(1, completion.getSize());
     * Test to verify merge shard results with different SortField.Type.
            result.topDocs(new TopDocsAndMaxScore(topDocs, Float.NaN), docValueFormats);
                new ProfileResult(
 * this work for additional information regarding copyright
            float maxScore = 0;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                "fetch documents",
            results.get(i).queryResult().topDocs(new TopDocsAndMaxScore(topDocs, maxScore), new DocValueFormat[1]);
        consumerTestCase(randomIntBetween(1, 5));
            assertEquals("Second fetch child should be LoadDocValues", "LoadDocValues", fetchChildren.get(1).getQueryName());
            assertEquals(sortedDocs[i].shardIndex, sortedDocs2[i].shardIndex);
            // Generate fresh query results for each iteration since profiles get consumed
    }
                ),
                    float dec = randomIntBetween(0, optionSize);
                        if (doc.shardIndex == shardIndex) {
import org.opensearch.search.SearchHits;
     * Note that <code>shardIndex</code> is already set to the generated completion suggestions to simulate what
            querySearchResult.suggest(new Suggest(new ArrayList<>(shardSuggestion)));
                );
                    int number = randomIntBetween(1, 1000);
                    Collections.emptyMap(),
            if (trackTotalHits == SearchContext.TRACK_TOTAL_HITS_DISABLED) {
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(
        consumer.close();
        SearchRequest request = randomSearchRequest();
                    8L,
            SearchProgressListener.NOOP,
            result.topDocs(
import org.opensearch.core.common.Strings;
        results = generateSeededQueryResults(randomSeed, nShards, Collections.emptyList(), queryResultSize, useConstantScore);
        }
            null
            assertEquals(maxScoreTerm, term.getEntries().get(0).getOptions().get(0).getScore(), 0f);
        SearchRequest request = getAggregationSearchRequestWithBatchedReduceSize(batchedReduceSize);
            Collections.emptyList(),
        List<CompletionSuggestion> suggestions = new ArrayList<>();
            1,
            {
        AtomicArray<SearchPhaseResult> results = generateQueryResults(nShards, suggestions, searchHitsSize, false);
                new ArrayList<>();
                    new TopDocsAndMaxScore(new TopDocs(new TotalHits(0, Relation.EQUAL_TO), Lucene.EMPTY_SCORE_DOCS), Float.NaN),
        request.source(new SearchSourceBuilder().aggregation(AggregationBuilders.avg("foo")));
            consumer.consumeResult(result, latch::countDown);
            results.get(i).queryResult().topDocs(new TopDocsAndMaxScore(topDocs, maxScore), new DocValueFormat[1]);
        SearchProfileShardResults mergedProfiles = searchPhaseController.mergeFetchProfiles(queryProfiles, fetchResults);
            QuerySearchResult result = new QuerySearchResult(
                    "field:value",
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
            expectedNumResults,
        SearchPhaseController.ReducedQueryPhase reduce = consumer.reduce();
    public void setup() {
                    assertEquals(numReduceListener.incrementAndGet(), reducePhase);
        int nShards = randomIntBetween(1, 20);
                    new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(0, number) }),
        assertEquals(95.0f, scoreDocs[0].score, 0.0f);
            AtomicInteger numReduceListener = new AtomicInteger();
            );
        assertEquals(5, scoreDocs.length);
import org.opensearch.search.SearchShardTarget;
            SearchPhaseController.ReducedQueryPhase reducedQueryPhase = searchPhaseController.reducedQueryPhase(
            assertEquals("Should have fetch children", 2, fetchPhase.getProfiledChildren().size());
        List<CompletionSuggestion> suggestions,
        assertEquals(c, ((FieldDoc) reduce.sortedTopDocs.scoreDocs[2]).fields[0]);
            String shardId = shardTargets.get(shardIndex).toString();
    }
            if (i % 2 == 0) {
                            number
            }
                60L,
        }
            ? new SearchRequest()
            CircuitBreakingException exc = expectThrows(CircuitBreakingException.class, () -> consumer.reduce());
                    maxScore = Math.max(score, maxScore);
        SearchRequest request = getAggregationSearchRequestWithBatchedReduceSize(batchedReduceSize);
            String clusterAlias = randomBoolean() ? null : "remote";
        assertThat(sortedDocs.length, equalTo(accumulatedLength));
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopFieldDocs;
            if (shouldBreak.get()) {
                            "TotalHitCountCollector",
            // Create aggregation profile
            List<ProfileResult> aggChildren = Arrays.asList(
        for (int bufferSize : new int[] { expectedNumResults, expectedNumResults / 2, expectedNumResults / 4, 2 }) {
            assert bytes >= 0 : bytes + " is less than 0";
            assertNotNull("Collector result should be preserved", queryResult.getCollectorResult());
        assertThrows(CircuitBreakingException.class, () -> consumer.reduce());
                "node_" + shardIndex,
            empty.setSearchShardTarget(new SearchShardTarget("node", new ShardId("a", "b", shardId), null, OriginalIndices.NONE));
        int score = 100;
                    int score = numOptions - j;
    protected NamedWriteableRegistry writableRegistry() {
    public void testCancellationWithoutCircuitBreaker() throws Exception {
     * number of search hits and randomly generated completion suggestions based on the name and size of the provided ones.
            maxSuggestSize += size;
        CountDownLatch latch = new CountDownLatch(expectedNumResults);
     * Generate random query results received from the provided number of shards, including the provided
            assertThat(suggestSize, lessThanOrEqualTo(maxSuggestSize));
                        score,
        fixedExecutor = OpenSearchExecutors.newFixed(
            assertEquals(1, phrase.getEntries().get(0).getOptions().size());
                    "terms on field",
        fetchResults.add(fetchResult);
                    if (dec <= maxScoreValue) {
        assertEquals(numTotalReducePhases, reductions.size());
                );
            4,
                    null,
            AtomicArray<SearchPhaseResult> fetchResults = generateFetchResults(
                    Collections.emptyMap(),
import org.opensearch.search.DocValueFormat;
        SearchPhaseController.ReducedQueryPhase reduce = consumer.reduce();
        result.topDocs(
    }
            assertEquals("Aggregation name should be preserved", "GlobalAggregator", aggProfile.getQueryName());
                suggests.add((CompletionSuggestion) suggestion);
            TopDocs topDocs = new TopFieldDocs(new TotalHits(1, Relation.EQUAL_TO), fieldDocs, sortFields);
                int id = i;
            assertEquals(expectedNumResults, reduce.totalHits.value());
 */
            );
        terminate(threadPool);
                    new ShardSearchContextId(UUIDs.randomBase64UUID(), index),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            result.topDocs(
            // Add query profile data
    }
            AtomicInteger numQueryResultListener = new AtomicInteger();
            List<ProfileResult> fetchChildren = fetchPhase.getProfiledChildren();
    }
                )
        }
                )
            SearchHit[] hits = searchHits.toArray(new SearchHit[0]);
import org.opensearch.common.util.concurrent.AtomicArray;
                    Collections.emptyMap(),
                    maxScoreTerm = Math.max(maxScoreTerm, score);
        int nShards,
        for (int i = 0; i < expectedNumResults; i++) {
            assertEquals("Query rewrite time should be preserved", 20L, queryResult.getRewriteTime());
        int searchHitsSize,
import org.opensearch.search.suggest.Suggest;
    private static void performSortDocs(AtomicArray<SearchPhaseResult> results, int queryResultSize) {
        int nShards,
    public void testSortDocsIsIdempotent() throws Exception {
        // The exception is only thrown during the call to reduce which will happen once all shard level
            new DocValueFormat[0]
        int partialReduceMethodCallCount = expectedNumResults / batchedReduceSize;
        List<CompletionSuggestion> suggestions,
            FieldDoc[] fieldDocs = { new FieldDoc(0, Float.NaN, new Object[] { number }) };
            result.size(1);
            assertEquals(1, phrase.getEntries().size());
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
        }
        assertEquals(94.0f, scoreDocs[1].score, 0.0f);
        List<CompletionSuggestion> suggestions,
                float maxScoreValue = randomIntBetween(suggestion.getSize(), (int) Float.MAX_VALUE);
        latch.await();
import org.opensearch.search.aggregations.AggregationBuilders;
            float score = useConstantScore ? 1.0F : Math.abs(randomFloat());
            exc -> {}
        latch.await();
                    assertNotNull(suggestionResult);
        assertNull(reduce.sortedTopDocs.collapseValues);
        // The caller should handle null queryProfiles and not call mergeFetchProfiles
                new AggregationProfileShardResult(Collections.emptyList()), // no agg results in fetch
                }
            false
    public void testConsumerWithEmptyResponse() throws Exception {
        assertEquals(1, reduce.sortedTopDocs.sortFields.length);
                Arrays.asList(queryShardResult),
                        ScoreDoc doc = option.getDoc();
import org.apache.lucene.search.SortedNumericSortField;
            SearchShardTarget searchShardTarget = new SearchShardTarget(
        int maxScorePhrase = -1;
            FetchProfileShardResult fetchProfileShardResult = new FetchProfileShardResult(Arrays.asList(fetchPhase));
                Collections.emptyMap(),
        assertFalse(reduce.sortedTopDocs.isSortedByField);
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(
    public void testSortDocs() {
        latch.await();
            consumer.consumeResult(result, latch::countDown);
                result.size(1);
            } else {
            new TopDocsAndMaxScore(new TopDocs(new TotalHits(0, TotalHits.Relation.EQUAL_TO), new ScoreDoc[0]), Float.NaN),
    private void testReduceCase(boolean shouldFail) throws Exception {
    public void testSortFloatFieldDocsMerge() {
import org.opensearch.search.suggest.phrase.PhraseSuggestion;
        int searchHitsSize,
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
                    completionEntry.addOption(
            assertEquals("Second fetch child time should be correct", 8L, fetchChildren.get(1).getTime());
                    );
            new ShardSearchContextId("", 0),
            threads[i].start();
import org.opensearch.search.SearchHit;
import org.opensearch.search.suggest.SortBy;
                    "terms on field",
        InternalMax internalMax = (InternalMax) reduce.aggregations.asList().get(0);
        long beforeCompletedTasks = fixedExecutor.getCompletedTaskCount();
            Thread[] threads = new Thread[expectedNumResults];
            assertNotNull("Aggregation profile should be preserved", aggResult);
            FetchSearchResult fetchSearchResult = new FetchSearchResult(new ShardSearchContextId("", shardIndex), shardTarget);
                new SearchShardTarget("node", new ShardId("a", "b", i), null, OriginalIndices.NONE),
        request.setBatchedReduceSize(batchedReduceSize);
        @Override
                new NetworkTime(randomIntBetween(2, 8), randomIntBetween(3, 10))
            SearchProgressListener.NOOP,
        Optional<SearchPhaseResult> first = results.asList().stream().findFirst();
            });
        AtomicInteger max = new AtomicInteger();
        // making sure circuit breaker trips first
 * specific language governing permissions and limitations
        assertEquals(3.0D, max.getValue(), 0.0D);
                collectorResult
        private final AtomicBoolean shouldBreak = new AtomicBoolean(false);
            {
        SortField[] sortFields = { new SortedNumericSortField("field", SortField.Type.INT, true) };
            };
import org.opensearch.search.suggest.term.TermSuggestion;
        boolean useConstantScore
                });
        );
        AtomicArray<SearchPhaseResult> results = generateQueryResultsWithFloatDoubleSortedField(
        request.setBatchedReduceSize(bufferSize);
 * Licensed to Elasticsearch under one or more contributor
            assertEquals("Should have one fetch profile result", 1, fetchProfile.getFetchProfileResults().size());
            AtomicArray<SearchPhaseResult> queryResults = generateQueryResults(nShards, suggestions, queryResultSize, false);
        }
            assertEquals(max.get(), reduce.maxScore, 0.0f);
        {
        request.source(new SearchSourceBuilder().aggregation(AggregationBuilders.avg("foo")).size(0));
            exc -> {}
            queryResultSize,
                        ProfileResult fetchProfile = mergedProfile.getFetchProfileResult().getFetchProfileResults().get(0);
            consumer.consumeResult(empty, latch::countDown);
        );
            CollectorResult collectorResult = new CollectorResult(
                new TopDocsAndMaxScore(new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[0]), number),
            int suggestionSize = suggestion.getEntries().get(0).getOptions().size();
            }
import org.opensearch.search.fetch.FetchSearchResult;
        CountDownLatch latch = new CountDownLatch(numShards);
            SearchProgressListener.NOOP,
            FetchProfileShardResult emptyFetchResults = new FetchProfileShardResult(Collections.emptyList());
        CountDownLatch latch = new CountDownLatch(expectedNumResults);
        int maxScoreTerm = -1;
                emptyFetchResults,
            );
            assertEquals(max.get(), internalMax.getValue(), 0.0D);
                }
        List<CompletionSuggestion> suggestions = new ArrayList<>();
    }
                    }
        );
        for (int i = 0; i < expectedNumResults; i++) {
                );
                    assertThat(shardIndex, lessThan(expectedNumResults));
            accumulatedLength += suggestionSize;
import org.apache.lucene.search.TopDocs;
        SearchProfileShardResults mergedProfiles = null != null ? searchPhaseController.mergeFetchProfiles(null, fetchResults) : null;
            );
            QuerySearchResult result = new QuerySearchResult(
                100L,
                result.setShardIndex(id);
import org.junit.Before;
        return new TopFieldDocs(new TotalHits(fieldDocs.length, TotalHits.Relation.EQUAL_TO), fieldDocs, sortFields);
            );
        assertNotNull("Merged profiles should not be null", mergedProfiles);
import java.util.concurrent.atomic.AtomicBoolean;
                    12L,
                return checkCount.decrementAndGet() <= 0;
            );
        assertFalse(reduce.sortedTopDocs.isSortedByField);
                    }
            SearchProgressListener.NOOP,
        assertFalse(reduce.sortedTopDocs.isSortedByField);
    private static TopFieldDocs getLongTopFieldDocs(int nDocs, boolean useConstantScore) {
            }
        assertEquals(100.f, reduce.maxScore, 0.0f);
            assertNotNull("Network time should be preserved", networkTime);
    }
        assertAggReduction(request);
            FetchProfileShardResult fetchProfile = mergedProfile.getFetchProfileResult();
            }
    }
            assertEquals(maxScoreCompletion, option.getScore(), 0f);
        int bufferSize = randomIntBetween(2, 200);
            for (Suggest.Suggestion<?> suggestion : entry.queryResult().suggest()) {
                "main query",
            new TopDocsAndMaxScore(new TopDocs(new TotalHits(0, TotalHits.Relation.EQUAL_TO), new ScoreDoc[0]), Float.NaN),
        for (int shardIndex = 0; shardIndex < nShards; shardIndex++) {
        threadPool = new TestThreadPool(SearchPhaseControllerTests.class.getName());
        assertNull(reduce.sortedTopDocs.collapseValues);
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
            final TopDocs topDocs = getIntTopFieldDocs(nDocs, useConstantScore);
                PhraseSuggestion phraseSuggestion = new PhraseSuggestion("phrase", 1);
            for (ScoreDoc scoreDoc : mergedSearchDocs) {
        }
import com.carrotsearch.randomizedtesting.RandomizedContext;
                Collections.emptyList(), // no query results in fetch
                reducedQueryPhase.suggest
        ScoreDoc[] sortedDocs = SearchPhaseController.sortDocs(true, topDocsList, from, size, reducedCompletionSuggestions).scoreDocs;
    }
                fetchResults::get
 *    http://www.apache.org/licenses/LICENSE-2.0
            int nDocs = randomIntBetween(0, searchHitsSize);
            exc -> {}
            QuerySearchResult queryResult = result.queryResult();
    ) {
     * Few shards with Int and few shards with Long
        FieldDoc[] fieldDocs = new FieldDoc[nDocs];
import java.util.stream.Collectors;
        result.topDocs(
    }
                    );
        request.source(new SearchSourceBuilder().size(5).from(5));
        int batchedReduceSize = randomIntBetween(2, expectedNumResults - 1);
        int expectedNumResults = randomIntBetween(1, 100);
                false,
            request,
        int maxScoreCompletion = -1;
        for (SearchPhaseResult result : results.asList()) {
            int nDocs = randomIntBetween(0, searchHitsSize);
                consumer.consumeResult(result, latch::countDown);
                        new Text("option"),
                        QueryProfileShardResult queryResult = mergedProfile.getQueryProfileResults().get(0);
        result = new QuerySearchResult(
        SearchPhaseController searchPhaseController = new SearchPhaseController(
        );
                    new SearchShardTarget("node", new ShardId("a", "b", id), null, OriginalIndices.NONE),
            }
                        new CompletionSuggestion.Entry.Option(i, new Text(""), maxScoreValue, Collections.emptyMap())
        InternalMax internalMax = (InternalMax) reduce.aggregations.asList().get(0);
        List<SearchPhaseResult> fetchResults = new ArrayList<>();
                    }
        assertEquals(max.get(), internalMax.getValue(), 0.0D);
                new ShardId("index", "uuid", shardIndex),
            fixedExecutor,
            }
                for (int j = 0; j < numOptions; j++) {
            fixedExecutor,
            exc -> {}
            result.size(1);
import org.apache.lucene.search.TotalHits.Relation;
                phraseSuggestion.addTerm(entry);
                        ProfileResult aggProfile = mergedProfile.getAggregationProfileResults().getProfileResults().get(0);
                    if (!mergedProfile.getAggregationProfileResults().getProfileResults().isEmpty()) {
            SearchProgressListener.NOOP,
     * Few shards with Float and few shards with Double
        {
            String shardId = shardTargets.get(shardIndex).toString();
            );
            ProfileShardResult mergedProfile = mergedProfiles.getShardResults().get(shardId);
            queryResults.set(shardIndex, querySearchResult);
            assertNull(reduce.sortedTopDocs.collapseValues);
                Arrays.asList(mainQuery),
                    "must clauses",
            assertEquals("Should have one query profile result", 1, queryResults.size());
            exc -> hasConsumedFailure.set(true)
        );
     */
            QueryProfileShardResult queryShardResult = new QueryProfileShardResult(
        List<CompletionSuggestion> reducedCompletionSuggestions = reducedSuggest(results);
                new CollectorResult("SimpleTopScoreDocCollector", "collecting docs", randomIntBetween(20, 40), Collections.emptyList())
            fixedExecutor,
        int bufferSize = randomIntBetween(2, 200);
        request.setInboundNetworkTime(randomIntBetween(1, 5));
            ProfileShardResult profileShardResult = new ProfileShardResult(
import java.util.Arrays;
            new SearchShardTarget("node", new ShardId("a", "b", 0), null, OriginalIndices.NONE),
                }
            );
        for (int i = 0; i < 10; i++) {
 * SPDX-License-Identifier: Apache-2.0
                new SearchShardTarget("node", new ShardId("a", "b", i), null, OriginalIndices.NONE),
 * Unless required by applicable law or agreed to in writing,
            assertEquals(1, completion.getOptions().size());
                return checkCount.decrementAndGet() <= 0;
        ShardSearchRequest request = new ShardSearchRequest(new ShardId("test", "test", 0), System.currentTimeMillis(), AliasFilter.EMPTY);
            for (int i = 0; i < expectedNumResults; i++) {
                if (scoreDoc.shardIndex == shardIndex) {
        int size = randomIntBetween(1, 10);
                    "loading doc values",
            topDocsList.add(topDocs);
        SearchPhaseController.ReducedQueryPhase reduce = consumer.reduce();
            assertEquals(max.get(), reduce.sortedTopDocs.scoreDocs[0].score, 0.0f);
                "",
import java.util.stream.Stream;
                ScoreDoc[] scoreDocs = new ScoreDoc[nDocs];
            expectedNumResults,
            numTotalReducePhases = 1;
        }
                    if (!mergedProfile.getQueryProfileResults().isEmpty()) {
        int expectedNumResults = randomIntBetween(20, 200);
            result.size(size);
                fixedExecutor,
                result.topDocs(
            CountDownLatch latch = new CountDownLatch(expectedNumResults);
                        assertNotNull(option.getHit());
            results.get(i).queryResult().topDocs(new TopDocsAndMaxScore(topDocs, maxScore), new DocValueFormat[1]);
                queryChildren
            assertEquals("Collector name should be preserved", "TotalHitCountCollector", queryResult.getCollectorResult().getName());
        QuerySearchResult result = new QuerySearchResult(
    private static TopFieldDocs getIntTopFieldDocs(int nDocs, boolean useConstantScore) {
        Thread[] threads = new Thread[expectedNumResults];
                new DocValueFormat[0]
        CountDownLatch latch = new CountDownLatch(4);
            results.get(i).queryResult().topDocs(new TopDocsAndMaxScore(topDocs, maxScore), new DocValueFormat[1]);
            || searchRequest.source().aggregations().getAggregatorFactories().isEmpty()) {
        for (int i = 0; i < expectedNumResults; i++) {
                    "LoadStoredFields",
                            "Main query should be BooleanQuery",
        assertEquals(max.get(), reduce.maxScore, 0.0f);
                result.topDocs(
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(
    public void testMergeFetchProfilesWithNullQueryProfiles() {
                    25L,
        }
            SearchPhaseController.setShardIndex(topDocs, result.getShardIndex());
            }
                new ProfileResult(
                PhraseSuggestion.Entry entry = new PhraseSuggestion.Entry(new Text("entry"), 0, 10);
        circuitBreaker.shouldBreak.set(true);
                    }
    ) {
        // Create some fetch results (though they won't be used since queryProfiles is null)
        }
        }
            numEmptyResponses--;
        // Create a minimal mock ShardSearchRequest with network timing
        }
            suggestions.add(new CompletionSuggestion(randomAlphaOfLength(randomIntBetween(1, 5)), randomIntBetween(1, 20), false));
                int numOptions = randomIntBetween(1, 10);
            int shardId = 2 + numEmptyResponses;
            request,
            fixedExecutor,
                    completionSuggestion.getName(),
        latch.await();
        private volatile long allocated;
        }
        for (int i = 0; i < sortedDocs.length; i++) {
                    "TermsAggregator",
                reducedQueryPhase.sortedTopDocs.scoreDocs,
    }
    private SearchPhaseController searchPhaseController;
            // When there aren't any aggregations we don't perform any aggregation reductions.
            if (bufferSize == 2) {
            });
import org.opensearch.core.common.breaker.CircuitBreakingException;
            assert topDocs.totalHits.relation() == Relation.EQUAL_TO;
            );
    }
            3 + numEmptyResponses,
            final int index = i;
                            fetchProfile.getProfiledChildren().get(0).getQueryName()
        }
                Collections.emptyList(), // no query results in fetch
            fieldDocs[i] = new FieldDoc(i, score, new Double[] { randomDouble() });
            );
                    new ShardSearchContextId("", id),
            PhraseSuggestion phrase = reduce.suggest.getSuggestion("phrase");
        assertFalse(reduce.sortedTopDocs.isSortedByField);
                    Collections.singletonList(new InternalMax("test", 0d, DocValueFormat.RAW, Collections.emptyMap()))
                );
                "TotalHitCountCollector",
        // 4*3 results = 12 we get result 5 to 10 here with from=5 and size=5
                new ArrayList<>(),
                queryResults.asList(),
            queryProfileMap.put(shardId, queryProfile);
        performSortDocs(results, queryResultSize);
        assertArrayEquals(collapseValues, reduce.sortedTopDocs.collapseValues);
        }
            float maxScore = 0;
                "global agg",
        }
        consumer.consumeResult(result, latch::countDown);
        }
            List<ProfileResult> fetchChildren = Arrays.asList(
                true,
                new ShardSearchContextId("", i),
                int nDocs = randomIntBetween(0, searchHitsSize);
            for (int i = 0; i < expectedNumResults; i++) {
                            "LoadDocValues",
            assertNull(reduce.sortedTopDocs.collapseField);
        SearchRequest request = randomSearchRequest();
            assertEquals("Fetch phase name should be correct", "FetchPhase", fetchPhase.getQueryName());
import org.opensearch.search.internal.SearchContext;
            }
        );
        }
                            new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(0, number) }),
                consumer.consumeResult(result, latch::countDown);
            threads[i].join();
        consumer.consumeResult(result, latch::countDown);
                    randomIntBetween(10, 20),
                threads[i].join();
        AtomicArray<SearchPhaseResult> results = generateQueryResultsWithIntLongSortedField(nShards, suggestions, queryResultSize, false);
            AggregationProfileShardResult aggResult = mergedProfile.getAggregationProfileResults();
                        null
                "GlobalAggregator",
            querySearchResult.size(searchHitsSize);
                suggestions.add(termSuggestion);
import java.util.HashMap;
        ArraySearchPhaseResults<SearchPhaseResult> consumer = searchPhaseController.newSearchPhaseResults(
                Collections.emptyMap(),
                    );
            for (Suggest.Suggestion<?> suggestion : reducedQueryPhase.suggest) {
    }
import org.opensearch.common.lucene.Lucene;
        SearchPhaseController.ReducedQueryPhase reduce = consumer.reduce();
            final TopDocs topDocs;
        assertEquals(max.get(), internalMax.getValue(), 0.0D);
                    new DocValueFormat[0]
    public void testConsumerFieldCollapsing() throws Exception {
            fixedExecutor,
            TopDocs topDocs = queryResult.consumeTopDocs().topDocs;
                new ProfileResult(
            ProfileResult fetchPhase = new ProfileResult(
                    "must clauses",
        }
import org.opensearch.search.profile.ProfileShardResult;
            );
                    Collections.emptyMap(),
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(
        SearchRequest request = new SearchRequest();
        AtomicArray<SearchPhaseResult> results = generateQueryResults(nShards, suggestions, searchHitsSize, false);
            );
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
                    Collections.emptyMap(),
            SearchProgressListener.NOOP,
        for (int i = 0; i < nDocs; i++) {
            ProfileShardResult fetchProfileResult = new ProfileShardResult(
        return results;
        reductions = new CopyOnWriteArrayList<>();
            SearchProgressListener.NOOP,
        List<CompletionSuggestion> suggestions,
            }
        latch.await();
            assertEquals(expectedNumResults, numQueryResultListener.get());
            expectedNumResults,
            SearchPhaseController.ReducedQueryPhase phase = consumer.reduce();
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
            // Create empty fetch profile (will be replaced by merge)
        assertEquals(SortField.Type.INT, reduce.sortedTopDocs.sortFields[0].getType());
        AtomicArray<SearchPhaseResult> results = generateQueryResults(nShards, suggestions, searchHitsSize, false);
                assertThat(mergedResponse.hits.getTotalHits().value(), equalTo(0L));
            exc -> {}
        public double addEstimateBytesAndMaybeBreak(long bytes, String label) throws CircuitBreakingException {
        CountDownLatch latch = new CountDownLatch(expectedNumResults);
import org.opensearch.core.tasks.TaskCancelledException;
        for (int i = 0; i < expectedNumResults; i++) {
            consumer.consumeResult(result, latch::countDown);
                        );
        AtomicArray<SearchPhaseResult> results = generateQueryResults(nShards, suggestions, searchHitsSize, false);
            fieldDocs[i] = new FieldDoc(i, score, new Float[] { randomFloat() });
        performSortDocs(results, queryResultSize);
        return RandomizedContext.current()
        SearchPhaseController.ReducedQueryPhase reduce = consumer.reduce();
import static org.hamcrest.Matchers.lessThan;
/*
                assertEquals(0, consumer.getNumReducePhases());
        int nShards = randomIntBetween(1, 20);
        assertNull(reduce.sortedTopDocs.collapseField);
        CountDownLatch latch = new CountDownLatch(expectedNumResults);
        DocValueFormat[] docValueFormats = { DocValueFormat.RAW };
            int nDocs = randomIntBetween(0, searchHitsSize);
                assertNull(mergedResponse.hits.getTotalHits());
        }
            result.setShardIndex(i);
        ScoreDoc[] sortedDocs2 = SearchPhaseController.sortDocs(ignoreFrom, topDocsList, from, size, Collections.emptyList()).scoreDocs;
            TopDocs topDocs = new CollapseTopFieldDocs("field", new TotalHits(1, Relation.EQUAL_TO), fieldDocs, sortFields, values);
            );
    private void assertAggReduction(SearchRequest searchRequest) {
        boolean ignoreFrom = randomBoolean();
                    totalHitsListener.set(totalHits);
            randomSeed,
        assertNull(reduce.sortedTopDocs.collapseField);
                }
    }
            request,
        CountDownLatch latch = new CountDownLatch(expectedNumResults);
        assertNull(reduce.sortedTopDocs.collapseValues);
        int searchHitsSize,
        AtomicArray<SearchPhaseResult> results = generateSeededQueryResults(
                            "Second fetch child should be LoadDocValues",
import org.opensearch.core.index.shard.ShardId;
        }
import java.util.concurrent.CountDownLatch;
                randomIntBetween(30, 60),
        FetchSearchResult fetchResult = new FetchSearchResult();
                Collections.emptyMap(),
            testReduceCase(true);
            List<CollectorResult> collectorChildren = Arrays.asList(
    }
            );
        // results have arrived
                if (suggestion.getEntries().get(0).getOptions().size() > 0) {
                new ProfileResult(
    private ThreadPool threadPool;
            result.aggregations(aggs);
            public ReduceContext forPartialReduction() {
            assertEquals(sortedDocs[i].doc, sortedDocs2[i].doc);
                @Override
                result.setShardIndex(index);
        assertEquals(3, reduce.suggest.size());
            );
                    null,
    private static AtomicArray<SearchPhaseResult> generateQueryResultsWithFloatSortedField(
                null,
        for (SearchPhaseResult shardResult : results.asList()) {
                topDocs = new TopDocs(new TotalHits(scoreDocs.length, TotalHits.Relation.EQUAL_TO), scoreDocs);
        assertEquals("field", reduce.sortedTopDocs.sortFields[0].getField());
                    scoreDocs[i] = new ScoreDoc(i, score);
    }
                        assertEquals(
 *
        assertEquals(expectedNumResults, reduce.totalHits.value());
                            queryResult.getQueryResults().get(0).getQueryName()
                @Override
            circuitBreaker.shouldBreak.set(false);
    private List<Boolean> reductions;
                            fetchProfile.getProfiledChildren().get(1).getQueryName()
            assertEquals(searchRequest.isFinalReduce(), reductions.get(reductions.size() - 1));
        AtomicArray<SearchPhaseResult> queryResults = new AtomicArray<>(nShards);
                fetchProfileShardResult,
            FetchProfileShardResult emptyFetchResults = new FetchProfileShardResult(Collections.emptyList());
    }
        }
        assertNull(reduce.sortedTopDocs.sortFields);
            );
        }
                reductions.add(true);
            queryResultSize,
        int bufferSize = randomIntBetween(2, 3);
import java.util.concurrent.CopyOnWriteArrayList;
            );
import org.opensearch.search.suggest.completion.CompletionSuggestion;
                            searchHits.add(new SearchHit(doc.doc, "", Collections.emptyMap(), Collections.emptyMap()));
                fetchChildren
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        );
                    if (scoreDoc.score > maxScore) {
            assertEquals(numReduceListener.get(), reduce.numReducePhases);
 */
     */
            circuitBreaker,
            maxScore = Math.max(score, maxScore);
            assertEquals("First fetch child time should be correct", 12L, fetchChildren.get(0).getTime());
            List<ProfileResult> queryProfileResults = queryResult.getQueryResults();
 */
            for (CompletionSuggestion completionSuggestion : suggestions) {
            exc -> {},
                }
            assertThat(reductions.size(), equalTo(0));
        }
                        assertEquals("Should have 1 aggregation child", 1, aggProfile.getProfiledChildren().size());
                        assertEquals("Aggregation should be GlobalAggregator", "GlobalAggregator", aggProfile.getQueryName());
import org.opensearch.test.OpenSearchTestCase;
            result.size(size);
            SearchProgressListener.NOOP,
    private static AtomicArray<SearchPhaseResult> generateQueryResultsWithFloatDoubleSortedField(
                    );
            AggregationProfileShardResult aggResults = new AggregationProfileShardResult(Arrays.asList(aggProfile));
                new AggregationProfileShardResult(Collections.emptyList()), // no agg results in fetch
                        new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(0, number) }),
                    Collections.emptyList()
            if (shouldFailPartial == false) {
import org.opensearch.search.SearchPhaseResult;
import org.opensearch.search.profile.fetch.FetchProfileShardResult;
                    PipelineTree.EMPTY
        int size = randomIntBetween(5, 10);
        assertThrows(TaskCancelledException.class, consumer::reduce);
            assertEquals("Main query name should be preserved", "BooleanQuery", mainQuery.getQueryName());
            assertEquals("Fetch phase time should be correct", 35L, fetchPhase.getTime());
