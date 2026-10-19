            }
                    QuerySearchResult result = new QuerySearchResult(
                )
        // 4*3 results = 12 we get result 5 to 10 here with from=5 and size=5
            expectedNumResults,
                new SearchShardTarget("node", new ShardId("a", "b", i), null, OriginalIndices.NONE),
            fixedExecutor,  
        SearchPhaseController searchPhaseController = new SearchPhaseController(
    }  
            assertAggReduction(request);
            List<CollectorResult> collectorChildren = Arrays.asList(  
                int nDocs = randomIntBetween(0, searchHitsSize);  
    /**
                20L, // rewrite time
                OriginalIndices.NONE  
                            number
            for (SearchHit hit : mergedResponse.hits().getHits()) {
                    false
import org.opensearch.search.internal.InternalSearchResponse;  
            fixedExecutor,  
import java.util.concurrent.atomic.AtomicInteger;
            queryResultSize,
            useConstantScore  
    }  
                }
                    Collections.singletonList(new InternalMax("test", (double) number, DocValueFormat.RAW, Collections.emptyMap()))  
                threads[i].start();
                    Collections.emptyMap(),
     * Few shards with Int and few shards with Long  
        int searchHitsSize,
        result.topDocs(
        if (numEmptyResponses == 0) {
        assertEquals(max.get(), reduce.sortedTopDocs.scoreDocs[0].score, 0.0f);
            }
                circuitBreaker.shouldBreak.set(true);
            for (Suggest.Suggestion<?> suggestion : entry.queryResult().suggest()) {  
        latch.await();
    }  
            int id = i;
                    Collections.emptyMap(),
        assertEquals(b, ((FieldDoc) reduce.sortedTopDocs.scoreDocs[1]).fields[0]);
                    "BooleanQuery",
    }
                        number
 * under the License.  
            );  
            SearchPhaseController.ReducedQueryPhase reducedQueryPhase = searchPhaseController.reducedQueryPhase(
            new DocValueFormat[0]
        AtomicInteger max = new AtomicInteger();
        for (int i = 0; i < nDocs; i++) {  
            assertNotNull("Collector result should be preserved", queryResult.getCollectorResult());
            }
                    randomIntBetween(5, 15),  
            request,
        Thread[] threads = new Thread[expectedNumResults];
        assertEquals(3, reduce.suggest.size());
        int batchedReduceSize = randomIntBetween(2, expectedNumResults - 1);
        } else {
        assertNull(reduce.sortedTopDocs.collapseField);
                    ProfileShardResult mergedProfile = entry.getValue();
            threads[i].start();
            assertEquals(max.get(), reduce.sortedTopDocs.scoreDocs[0].score, 0.0f);
                        new Text("option"),  
            request,  
        assertAggReduction(request);  
        request.setBatchedReduceSize(randomIntBetween(2, 4));
                        null
                true
    private static List<CompletionSuggestion> reducedSuggest(AtomicArray<SearchPhaseResult> results) {  
        assertEquals(max.get(), reduce.sortedTopDocs.scoreDocs[0].score, 0.0f);  
        QuerySearchResult result = new QuerySearchResult(
    private ThreadPool threadPool;  
            exc -> {},
        Optional<SearchPhaseResult> first = results.asList().stream().findFirst();  
import org.opensearch.search.internal.AliasFilter;
    }  
                    if (dec <= maxScoreValue) {
                            "LoadStoredFields",  
                searchShardTarget,
        consumer.close();
            float score = useConstantScore ? 1.0F : Math.abs(randomFloat());
    private void consumerTestCase(int numEmptyResponses) throws Exception {  
            SearchProgressListener.NOOP,
            "test",
            int nDocs = randomIntBetween(0, searchHitsSize);
        AtomicArray<SearchPhaseResult> fetchResults = new AtomicArray<>(nShards);
        // Set network timing  
                false,  
        for (int shardIndex = 0; shardIndex < nShards; shardIndex++) {
        List<CompletionSuggestion> suggestions = new ArrayList<>();
            float maxScore = 0;
    }  
        boolean ignoreFrom = randomBoolean();
            QuerySearchResult result = new QuerySearchResult(
                final CompletionSuggestion.Entry completionEntry = new CompletionSuggestion.Entry(new Text(""), 0, 5);
        AtomicArray<SearchPhaseResult> results = generateQueryResults(nShards, suggestions, searchHitsSize, false);
            assertEquals("Second fetch child should be LoadDocValues", "LoadDocValues", fetchChildren.get(1).getQueryName());
            public ReduceContext forPartialReduction() {
            assertEquals("Should have one query profile result", 1, queryResults.size());
            SearchProgressListener.NOOP,  
        } else {
import org.opensearch.search.suggest.phrase.PhraseSuggestion;
        int resultCount = 0;  
                consumer.consumeResult(result, latch::countDown);
        int nShards,  
                aggChildren
            );
import org.opensearch.search.aggregations.AggregationBuilders;  
                expectedNumResults,  
                new ProfileResult(  
        consumeShardLevelQueryPhaseResultsAsync(expectedNumResults, consumer);
                    Collections.emptyMap(),  
                new NetworkTime(randomIntBetween(2, 8), randomIntBetween(3, 10))
                        ProfileResult fetchProfile = mergedProfile.getFetchProfileResult().getFetchProfileResults().get(0);
    private OpenSearchThreadPoolExecutor fixedExecutor;
        int searchHitsSize,  
        return queryResults;
            querySearchResult.setShardIndex(shardIndex);
        );
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(
import org.apache.lucene.search.TotalHits.Relation;
        assertEquals(3, reduce.sortedTopDocs.scoreDocs.length);
                collectorResult  
        }
        // Test that the caller properly handles null queryProfiles
        int expectedNumResults = randomIntBetween(1, 100);  
import org.apache.lucene.search.TotalHits;  
            int size = randomIntBetween(1, 20);
            for (int j = 0; j < docs.length; j++) {
    private static TopFieldDocs getLongTopFieldDocs(int nDocs, boolean useConstantScore) {
        }
            AtomicReference<InternalAggregations> finalAggsListener = new AtomicReference<>();
        SearchRequest request = randomSearchRequest();
            testReduceCase(true);
            max.updateAndGet(prev -> Math.max(prev, number));
        assertArrayEquals(collapseValues, reduce.sortedTopDocs.collapseValues);
                new TopDocsAndMaxScore(
            );
            int shardId = 2 + numEmptyResponses;  
            assertNotNull("Fetch profile should be merged", fetchProfile);  
                new SearchShardTarget("node", new ShardId("a", "b", i), null, OriginalIndices.NONE),  
            AtomicInteger max = new AtomicInteger();  
        }
                new SearchShardTarget("node", new ShardId("a", "b", i), null, OriginalIndices.NONE),
                float maxScoreValue = randomIntBetween(suggestion.getSize(), (int) Float.MAX_VALUE);
import org.apache.lucene.search.SortField;
            if (shouldBreak.get()) {  
public class SearchPhaseControllerTests extends OpenSearchTestCase {
            TopDocs topDocs = queryResult.consumeTopDocs().topDocs;  
                progressListener,
        boolean shouldFailPartial = shouldFail && randomBoolean();
        boolean useConstantScore
            );  
}
            AtomicInteger numReduceListener = new AtomicInteger();  
                        assertEquals("Fetch phase should be FetchPhase", "FetchPhase", fetchProfile.getQueryName());
        }
        consumer.consumeResult(result, latch::countDown);  
                numTotalReducePhases = 2;
            result.size(5);  
                aggResults,
                for (int i = 0; i < nDocs; i++) {
        assertFalse(reduce.sortedTopDocs.isSortedByField);
import org.opensearch.search.aggregations.metrics.InternalMax;
                new DocValueFormat[0]  
            String shardId = shardTargets.get(shardIndex).toString();
    }  
            consumer.consumeResult(result, latch::countDown);
        }
                assertThat(suggestion, instanceOf(CompletionSuggestion.class));
        );  
                    new TopDocsAndMaxScore(
                result.topDocs(  
 */  
        assertTrue(reduce.sortedTopDocs.isSortedByField);  
        searchPhaseController = new SearchPhaseController(writableRegistry(), s -> new InternalAggregation.ReduceContextBuilder() {
            assertNotNull("Query profile results should be preserved", queryResults);  
            List<ProfileResult> aggChildren = Arrays.asList(
                );  
            Suggest suggestResult = mergedResponse.suggest();
                    if (!mergedProfile.getFetchProfileResult().getFetchProfileResults().isEmpty()) {  
        performSortDocs(results, queryResultSize);
        request.setInboundNetworkTime(randomIntBetween(1, 5));
            for (int i = 0; i < expectedNumResults; i++) {  
import org.opensearch.search.aggregations.InternalAggregation.ReduceContext;
            InternalSearchResponse mergedResponse = searchPhaseController.merge(
    public void testProgressListener() throws Exception {
            randomSeed,
            result.size(size);
        latch.await();  
                    suggestion.getName(),
        int nShards,
            request,  
            FetchProfileShardResult fetchProfileShardResult = new FetchProfileShardResult(Arrays.asList(fetchPhase));  
                nShards,
            );
                    Collections.emptyList()
                new AggregationProfileShardResult(Collections.emptyList()), // no agg results in fetch  
                if (suggestion.getEntries().get(0).getOptions().size() > 0) {
                    BigArrays.NON_RECYCLING_INSTANCE,
        for (int i = 0; i < expectedNumResults; i++) {  
            int nDocs = randomIntBetween(0, searchHitsSize);
        float maxScore = 0;
                    "field:value",
            3 + numEmptyResponses,
                "FetchPhase",
        // Create a minimal mock ShardSearchRequest with network timing
                    new TopDocsAndMaxScore(new TopDocs(new TotalHits(0, Relation.EQUAL_TO), Lucene.EMPTY_SCORE_DOCS), Float.NaN),
            SearchHit[] hits = searchHits.toArray(new SearchHit[0]);
        consumerTestCase(randomIntBetween(1, 5));  
        int batchedReduceSize = randomIntBetween(2, expectedNumResults - 1);
        List<TopDocs> topDocsList = new ArrayList<>();  
        int from = 0, size = 0;
        for (int i = 0; i < results.length(); i++) {  
            threads[i].join();
                    );  
        BytesRef a = new BytesRef("a");
        fetchResults.add(fetchResult);
                suggestions.add(phraseSuggestion);
            assertNotNull("Aggregation profile should be preserved", aggResult);
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),  
            } else {
                    numQueryResultListener.incrementAndGet();
    }  
    }  
            fixedExecutor,
    }  
        request.setBatchedReduceSize(bufferSize);
                    if (scoreDoc.score > maxScore) {
                    Collections.emptyMap(),  
            results.get(i).queryResult().topDocs(new TopDocsAndMaxScore(topDocs, maxScore), new DocValueFormat[1]);  
    public void testMergeFetchProfilesWithNullQueryProfiles() {  
            result.aggregations(aggs);  
import org.opensearch.test.OpenSearchTestCase;
            if (i % 2 == 0) {
                reductions.add(true);
            assertEquals(sortedDocs[i].doc, sortedDocs2[i].doc);
        }  
            QuerySearchResult querySearchResult = new QuerySearchResult(
        for (int shardIndex = 0; shardIndex < nShards; shardIndex++) {  
        SearchRequest request = randomSearchRequest();  
        for (int i = 0; i < expectedNumResults; i++) {
            // Create aggregation profile  
                    "BooleanQuery",  
        for (SearchPhaseResult entry : results.asList()) {
            for (ScoreDoc scoreDoc : mergedSearchDocs) {
        assertEquals(a, ((FieldDoc) reduce.sortedTopDocs.scoreDocs[0]).fields[0]);  
            float maxScore = 0;
        List<CompletionSuggestion> suggestions = new ArrayList<>();
            fixedExecutor,
        assertEquals(94.0f, scoreDocs[1].score, 0.0f);  
 *  
        List<CompletionSuggestion> suggestions,
import org.opensearch.core.common.breaker.CircuitBreakingException;  
        assertNull(reduce.sortedTopDocs.sortFields);
            size = first.get().queryResult().size();
                return checkCount.decrementAndGet() <= 0;
        for (int i = 0; i < results.length(); i++) {
        boolean useConstantScore  
        }
        Map<String, ProfileShardResult> queryProfileMap = new HashMap<>();
                ScoreDoc[] scoreDocs = new ScoreDoc[nDocs];
            resultCount += (int) topDocs.totalHits.value();
            result.suggest(new Suggest(suggestions));  
            int nDocs = randomIntBetween(0, searchHitsSize);  
            FetchProfileShardResult emptyFetchResults = new FetchProfileShardResult(Collections.emptyList());
        int nShards = randomIntBetween(1, 20);  
            QueryProfileShardResult queryShardResult = new QueryProfileShardResult(
        SearchProfileShardResults mergedProfiles = null != null ? searchPhaseController.mergeFetchProfiles(null, fetchResults) : null;
            AtomicInteger numQueryResultListener = new AtomicInteger();
        assertNull(reduce.sortedTopDocs.collapseValues);
        latch.await();  
            FetchProfileShardResult emptyFetchResults = new FetchProfileShardResult(Collections.emptyList());
        }
                new ProfileResult(  
    public void testSortDocsIsIdempotent() throws Exception {
    private SearchPhaseController searchPhaseController;
        assertNull(reduce.sortedTopDocs.collapseValues);
                        SearchPhaseResult searchPhaseResult = fetchResults.get(option.getHit().getShard().getShardId().id());  
            from = first.get().queryResult().from();  
                    Collections.emptyMap(),  
    private void testReduceCase(boolean shouldFail) throws Exception {
                int number = randomIntBetween(1, 1000);  
                    totalHitsListener.set(totalHits);
            // Generate fresh query results for each iteration since profiles get consumed  
            assert topDocs.totalHits.relation() == Relation.EQUAL_TO;  
            assertThat(reductions.size(), equalTo(0));  
    private static AtomicArray<SearchPhaseResult> generateQueryResults(
        return new TopFieldDocs(new TotalHits(fieldDocs.length, TotalHits.Relation.EQUAL_TO), fieldDocs, sortFields);
            List<ProfileResult> queryChildren = Arrays.asList(
                        assertSame(searchPhaseResult.getSearchShardTarget(), option.getHit().getShard());
                )
            assertEquals(expectedNumResults, numQueryResultListener.get());
        assertAggReduction(request);
            expectedNumResults,  
            result.topDocs(
        // making sure circuit breaker trips first
            SearchProgressListener progressListener = new SearchProgressListener() {  
                TermSuggestion termSuggestion = new TermSuggestion("term", 1, SortBy.SCORE);
        int nShards,
            );
                    assertThat(shardIndex, lessThan(expectedNumResults));  
                    searchHits.add(new SearchHit(scoreDoc.doc, "", Collections.emptyMap(), Collections.emptyMap()));
                    }  
                List<Suggest.Suggestion<CompletionSuggestion.Entry>> suggests = groupedSuggestion.computeIfAbsent(
                suggestSize += stream.collect(Collectors.summingInt(e -> e.getOptions().size()));  
        SearchRequest request = getAggregationSearchRequestWithBatchedReduceSize(batchedReduceSize);  
            List<ProfileResult> aggChildren = Arrays.asList(
            circuitBreaker,
        AtomicArray<SearchPhaseResult> results = generateQueryResults(nShards, suggestions, queryResultSize, false);
                return InternalAggregation.ReduceContext.forFinalReduction(  
            result.topDocs(
            assertEquals(1, term.getEntries().get(0).getOptions().size());  
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(
            float score = useConstantScore ? 1.0F : Math.abs(randomFloat());
            suggestions,
        result.topDocs(  
            AtomicInteger numQueryFailureListener = new AtomicInteger();
        while (numEmptyResponses > 0) {
        for (int i = 0; i < results.length(); i++) {  
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(
                    "LoadDocValues",  
        if (randomBoolean()) {  
            TopDocs topDocs = queryResult.consumeTopDocs().topDocs;  
                    randomIntBetween(10, 20),
                    Collections.emptyMap(),
                    randomIntBetween(3, 10),
        }
        for (int i = 0; i < expectedNumResults; i++) {  
            assertThat(suggestSize, lessThanOrEqualTo(maxSuggestSize));
        List<TopDocs> topDocsList = new ArrayList<>();  
        int maxScoreCompletion = -1;
        );
                throw new CircuitBreakingException(label, getDurability());
     * Test to verify merge shard results with different SortField.Type.
                assertEquals(1, reductions.size());
            );
    private static AtomicArray<SearchPhaseResult> generateQueryResultsWithFloatDoubleSortedField(
import org.apache.lucene.search.SortedNumericSortField;  
                PhraseSuggestion phraseSuggestion = new PhraseSuggestion("phrase", 1);
        }  
        }
        for (int i = 0; i < 10; i++) {  
                for (Map.Entry<String, ProfileShardResult> entry : mergedResponse.profileResults.getShardResults().entrySet()) {  
                    result.setShardIndex(id);  
                Collections.emptyMap(),  
    private static TopFieldDocs getIntTopFieldDocs(int nDocs, boolean useConstantScore) {
            );
    private static AtomicArray<SearchPhaseResult> generateQueryResultsWithIntSortedField(  
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(  
            consumer.consumeResult(empty, latch::countDown);  
            CompletionSuggestion.Entry.Option option = completion.getOptions().get(0);
            );
        assertEquals(numTotalReducePhases, reductions.size());
            );
                    Collections.emptyList()  
     */  
import org.opensearch.search.suggest.SortBy;
            result.size(0);  
import static java.util.Collections.emptyMap;
                new ProfileResult(  
        for (int trackTotalHits : new int[] { SearchContext.TRACK_TOTAL_HITS_DISABLED, SearchContext.TRACK_TOTAL_HITS_ACCURATE }) {
            consumer.consumeResult(result, latch::countDown);  
                    Collections.emptyList()
import org.opensearch.common.util.BigArrays;  
        Object[] collapseValues = new Object[] { a, b, c };
        return results;
        SearchRequest request = randomSearchRequest();
        SearchRequest request = getAggregationSearchRequestWithBatchedReduceSize(batchedReduceSize);
                suggests.add((CompletionSuggestion) suggestion);
                    float dec = randomIntBetween(0, optionSize);  
        assertEquals("field", reduce.sortedTopDocs.collapseField);
        );
                    for (CompletionSuggestion.Entry.Option option : options) {
            String shardId = shardTargets.get(shardIndex).toString();  
                topDocs = getFloatTopFieldDocs(nDocs, useConstantScore);
        }
    ) throws Exception {
        if (searchRequest.source() == null
    private static TopFieldDocs getFloatTopFieldDocs(int nDocs, boolean useConstantScore) {
        SearchRequest request = randomSearchRequest();
            fixedExecutor,
        CountDownLatch latch = new CountDownLatch(expectedNumResults);  
                            }  
            );
            QueryProfileShardResult queryShardResult = new QueryProfileShardResult(  
                        score,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            TermSuggestion term = reduce.suggest.getSuggestion("term");
        for (SearchPhaseResult result : results.asList()) {
            ProfileResult aggProfile = new ProfileResult(
                    completionSuggestion.getSize(),
                new ShardSearchContextId("", shardIndex),  
            consumer.consumeResult(result, latch::countDown);
            CircuitBreakingException exc = expectThrows(CircuitBreakingException.class, () -> consumer.reduce());
import org.opensearch.search.SearchModule;  
                });  
                    randomIntBetween(25, 50),
                fixedExecutor,
            }  
            CountDownLatch latch = new CountDownLatch(expectedNumResults);
        if (shouldFail) {  
                    Collections.emptyMap(),
            numTotalReducePhases = 1;  
                    List<CompletionSuggestion.Entry.Option> options = suggestionResult.getEntries().get(0).getOptions();
        assertNull(reduce.sortedTopDocs.collapseValues);
            assertEquals(sortedDocs[i].shardIndex, sortedDocs2[i].shardIndex);  
            );
import org.opensearch.search.suggest.term.TermSuggestion;
        CountDownLatch latch = new CountDownLatch(expectedNumResults);
        assertNull(reduce.sortedTopDocs.collapseField);  
                null
        consumer.consumeResult(result, latch::countDown);
import org.opensearch.search.profile.fetch.FetchProfileShardResult;  
        }  
            });  
    public void testReduceTopNWithFromOffset() throws Exception {
        SearchRequest request = new SearchRequest();
    }
                        new CompletionSuggestion.Entry.Option(i, new Text(""), maxScoreValue, Collections.emptyMap())
            @Override  
                "fetch documents",
        CountDownLatch latch = new CountDownLatch(expectedNumResults);
        assertEquals(c, ((FieldDoc) reduce.sortedTopDocs.scoreDocs[2]).fields[0]);
                null
                        Collections.emptyMap()
            circuitBreaker.shouldBreak.set(true);
        }
        InternalMax max = (InternalMax) reduce.aggregations.asList().get(0);
            List<ProfileResult> fetchChildren = fetchPhase.getProfiledChildren();
        }
            ProfileResult fetchPhase = fetchProfile.getFetchProfileResults().get(0);  
            );
            exc -> {}
        SearchPhaseController.ReducedQueryPhase reduce = consumer.reduce();
                reducedQueryPhase.sortedTopDocs.scoreDocs,
            fixedExecutor,
        }
    }
            float maxScore = 0;  
            assertEquals(sortedDocs[i].score, sortedDocs2[i].score, 0.0f);
        int size = randomIntBetween(1, 10);
        }
    ) {  
                queryChildren
            circuitBreaker,
            shardTargets.add(shardTarget);
            result.topDocs(
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
                    consumer.consumeResult(result, latch::countDown);
            Collections.emptyList(),
            }
        AtomicArray<SearchPhaseResult> results = generateQueryResults(nShards, suggestions, searchHitsSize, false);  
        assertFalse(reduce.sortedTopDocs.isSortedByField);
        assertEquals(expectedNumResults, reduce.totalHits.value());
                    BigArrays.NON_RECYCLING_INSTANCE,
    public void testMerge() {
        int bufferSize = randomIntBetween(2, 200);
                            "LoadDocValues",
        }
        private final AtomicBoolean shouldBreak = new AtomicBoolean(false);
                CompletionSuggestion suggestion = new CompletionSuggestion(
    }
            empty.setShardIndex(2 + numEmptyResponses);
                new ProfileResult(
            );  
                null
        return request;  
                        assertEquals(
import org.opensearch.search.internal.ShardSearchContextId;
            // Create empty fetch profile (will be replaced by merge)  
            TopDocs topDocs = new CollapseTopFieldDocs("field", new TotalHits(1, Relation.EQUAL_TO), fieldDocs, sortFields, values);
import org.apache.lucene.search.grouping.CollapseTopFieldDocs;
    public void testConsumerWithEmptyResponse() throws Exception {
        if (first.isPresent()) {
        assertNull(reduce.sortedTopDocs.collapseField);
        );  
        int bufferSize = randomIntBetween(2, 200);
        AssertingCircuitBreaker circuitBreaker = new AssertingCircuitBreaker(CircuitBreaker.REQUEST);
    public void testSortIntLongFieldDocsMerge() {
        List<CompletionSuggestion> suggestions,
                Collections.emptyMap(),
    public void testPartialReduce() throws Exception {
            );
        result.aggregations(aggs);
        assertEquals(maxScoreCompletion, reduce.sortedTopDocs.scoreDocs[0].score, 0f);  
            assertEquals("Should have collector children", 1, queryResult.getCollectorResult().getProfiledChildren().size());
        assertEquals(1, reduce.sortedTopDocs.sortFields.length);
        int nShards = randomIntBetween(1, 20);  
            new SearchShardTarget("node", new ShardId("a", "b", 0), null, OriginalIndices.NONE),  
    public void testCancellationDoesNotMaskCircuitBreakerException() throws Exception {
    /**
                        new TopDocsAndMaxScore(
                        );
        assertNull(reduce.sortedTopDocs.sortFields);  
                    maxScorePhrase = Math.max(maxScorePhrase, score);  
            max.updateAndGet(prev -> Math.max(prev, number));
        {  
                public void onFinalReduce(List<SearchShard> shards, TotalHits totalHits, InternalAggregations aggs, int reducePhase) {
        }
import static java.util.Collections.emptyList;
                ),
        SearchRequest request = getAggregationSearchRequestWithBatchedReduceSize(batchedReduceSize);
                new ProfileResult(
            SearchShardTarget shardTarget = new SearchShardTarget(
            SearchProgressListener.NOOP,
            List<SearchHit> searchHits = new ArrayList<>();
                    Collections.emptyList()  
                    float score = useConstantScore ? 1.0F : Math.abs(randomFloat());  
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
            );  
            assertNotNull("Network time should be preserved", networkTime);  
        ScoreDoc[] sortedDocs2 = SearchPhaseController.sortDocs(ignoreFrom, topDocsList, from, size, Collections.emptyList()).scoreDocs;
                }
import org.opensearch.search.fetch.FetchSearchResult;
        }
                    Collections.emptyList()  
        assertThat(sortedDocs.length, equalTo(accumulatedLength));
        int maxScorePhrase = -1;
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
                        ScoreDoc doc = option.getDoc();
            SearchProgressListener.NOOP,
        for (int i = 0; i < 10; i++) {  
            SearchRequest request = randomSearchRequest();
    @Before
                    CompletionSuggestion suggestionResult = suggestResult.getSuggestion(suggestion.getName());  
package org.opensearch.action.search;
        AtomicArray<SearchPhaseResult> results = generateQueryResults(nShards, suggestions, searchHitsSize, false);
                result.size(1);
        CountDownLatch latch = new CountDownLatch(expectedNumResults);
            fieldDocs[i] = new FieldDoc(i, score, new Double[] { randomDouble() });
            from = first.get().queryResult().from();  
    }  
        assertAggReduction(request);
                CompletionSuggestion completionSuggestion = new CompletionSuggestion("completion", 1, false);
        assertEquals(1, reduce.sortedTopDocs.scoreDocs.length);
import org.opensearch.threadpool.TestThreadPool;
            .runWithPrivateRandomness(seed, () -> generateQueryResults(nShards, suggestions, searchHitsSize, useConstantScore));
                new ProfileResult(  
        AtomicInteger max = new AtomicInteger();
        );  
            AggregationProfileShardResult aggResults = new AggregationProfileShardResult(Arrays.asList(aggProfile));
import org.opensearch.search.SearchHit;
import org.opensearch.search.aggregations.InternalAggregations;  
        );
        int queryResultSize = randomBoolean() ? 0 : randomIntBetween(1, nShards * 2);
import java.util.Collections;  
        FieldDoc[] fieldDocs = new FieldDoc[nDocs];  
        }  
        return fetchResults;
import org.junit.After;
                "global agg",
        assertEquals("Should have profiles for all shards", nShards, mergedProfiles.getShardResults().size());  
                emptyFetchResults,  
                            new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(0, number) }),  
            maxSuggestSize += size;  
    public void testCancellationWithoutCircuitBreaker() throws Exception {  
        assertEquals(Math.min(expectedNumResults, size), reduce.sortedTopDocs.scoreDocs.length);  
    private static AtomicArray<SearchPhaseResult> generateQueryResultsWithFloatSortedField(
        CountDownLatch latch = new CountDownLatch(numShards);
            int suggestionSize = suggestion.getEntries().get(0).getOptions().size();  
                    int score = numOptions - j;
    private static void consumeShardLevelQueryPhaseResultsAsync(int expectedNumResults, QueryPhaseResultConsumer consumer)  
        request.source(new SearchSourceBuilder().aggregation(AggregationBuilders.avg("foo")));
                Arrays.asList(mainQuery),
                for (int i = 0; i < optionSize; i++) {
                for (int j = 0; j < numOptions; j++) {
        terminate(threadPool);  
            assertEquals("Should have aggregation children", 1, aggProfile.getProfiledChildren().size());  
        assertNull(reduce.sortedTopDocs.collapseValues);  
    @After  
                topDocs = getIntTopFieldDocs(nDocs, useConstantScore);
            assertEquals("Fetch phase time should be correct", 35L, fetchPhase.getTime());
                    "must clauses",
            querySearchResult.profileResults(profileShardResult);
            SearchShardTarget shardTarget = new SearchShardTarget("", new ShardId("", "", shardIndex), clusterAlias, OriginalIndices.NONE);
        int nShards,  
                ),
                fetchChildren  
                0,
                );
                    Collections.emptyMap(),  
                        if (doc.shardIndex == shardIndex) {
        for (int i = 0; i < expectedNumResults; i++) {
                }
        {  
     */
        return randomBoolean()
                    for (CompletionSuggestion.Entry.Option option : ((CompletionSuggestion) suggestion).getOptions()) {  
        assertNotEquals(-1, reduce.sortedTopDocs.scoreDocs[0].shardIndex);
                        QueryProfileShardResult queryResult = mergedProfile.getQueryProfileResults().get(0);
                            queryResult.getCollectorResult().getName()
                    new ShardSearchContextId("", id),  
            List<ProfileResult> fetchChildren = Arrays.asList(  
            QuerySearchResult result = new QuerySearchResult(  
            }  
            exc -> {},
                assertNull(mergedResponse.hits.getTotalHits());  
            exc -> {}
            maxScore = Math.max(score, maxScore);  
        List<CompletionSuggestion> suggestions = new ArrayList<>();
                    "TermsAggregator",  
        AssertingCircuitBreaker(String name) {
            request,
                }
                    Collections.emptyMap(),
    ) {
        assertFalse(reduce.sortedTopDocs.isSortedByField);
                    result.topDocs(
        );
        );
        SortField[] sortFields = { new SortedNumericSortField("field", SortField.Type.LONG, true) };
        SortField[] sortFields = { new SortField("field", SortField.Type.INT, true) };  
        boolean useConstantScore
            if (searchHitsSize == 0) {  
            ProfileShardResult profileShardResult = new ProfileShardResult(  
    private static SearchRequest getAggregationSearchRequestWithBatchedReduceSize(int batchedReduceSize) {
                for (int j = 0; j < numOptions; j++) {
            List<Suggest.Suggestion<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>>> suggestions =
        AtomicInteger checkCount = new AtomicInteger(expectedNumResults + partialReduceMethodCallCount);  
import org.opensearch.search.SearchPhaseResult;
    private static SearchRequest randomSearchRequest() {
                suggestions.add(termSuggestion);
            super(name);  
                Collections.emptyMap(),
        latch.await();  
                    Collections.singletonList(new InternalMax("test", 0d, DocValueFormat.RAW, Collections.emptyMap()))
                    );
            fetchResults.set(shardIndex, fetchSearchResult);
    }
                            searchHits.add(new SearchHit(doc.doc, "", Collections.emptyMap(), Collections.emptyMap()));  
        float maxScore = 0;
            assertThat(reductions.size(), greaterThanOrEqualTo(1));
            );  
        for (int i = 0; i < randomIntBetween(1, 5); i++) {  
 * software distributed under the License is distributed on an
            max.updateAndGet(prev -> Math.max(prev, number));
                    "must clauses",
            String clusterAlias = randomBoolean() ? null : "remote";
            // When there aren't any aggregations we don't perform any aggregation reductions.
        BytesRef b = new BytesRef("b");  
                    "TermQuery",
        assertEquals(12, reduce.totalHits.value());
        performSortDocs(results, queryResultSize);
     * meaning that the returned query results can be fed directly to {@link SearchPhaseController#sortDocs}  
                queryResults.asList(),  
            List<ProfileResult> queryProfileResults = queryResult.getQueryResults();  
                        new ShardSearchContextId("", id),  
                    InternalAggregations aggs = InternalAggregations.from(
        for (SearchPhaseResult shardResult : results.asList()) {
        SortField[] sortFields = { new SortedNumericSortField("field", SortField.Type.FLOAT, true) };
import org.opensearch.core.common.breaker.CircuitBreaker;
                            fetchProfile.getProfiledChildren().get(1).getQueryName()  
        SearchPhaseController.ReducedQueryPhase reduce = consumer.reduce();  
                Arrays.asList(queryShardResult),
            );
            }  
        return request;  
            assertEquals(max.get(), internalMax.getValue(), 0.0D);
            QuerySearchResult queryResult = result.queryResult();
        result.setShardIndex(2);
import java.util.concurrent.CountDownLatch;  
            assertNotNull("Merged profile should exist for shard " + shardId, mergedProfile);  
                max.updateAndGet(prev -> Math.max(prev, number));
    private static int getTotalQueryHits(AtomicArray<SearchPhaseResult> results) {
        }
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(
                    8L,
                new ProfileResult(  
import java.util.concurrent.atomic.AtomicReference;  
    public void setup() {  
                aggChildren  
            QuerySearchResult queryResult = result.queryResult();  
                createMockShardSearchRequest()
            new ShardSearchContextId("", 1),  
    // Helper method to create a mock ShardSearchRequest for testing
                            if (doc.score > maxScore) {
                );
            }
                    "loading _source",  
        assertEquals(expectedNumResults, reduce.totalHits.value());
            fetchSearchResult.profileResults(fetchProfileResult);  
                    completionSuggestion.getName(),  
 * The OpenSearch Contributors require contributions made to  
import java.util.Map;  
        for (int i = 0; i < results.length(); i++) {
        result.aggregations(aggs);
        request.setBatchedReduceSize(bufferSize);
import org.apache.lucene.util.BytesRef;  
                    Collections.emptyMap(),
        int expectedNumResults = randomIntBetween(20, 200);
        assertEquals("field", reduce.sortedTopDocs.sortFields[0].getField());
            SearchProgressListener.NOOP,
                );  
        }  
        request.setBatchedReduceSize(bufferSize);
    public void testConsumerSuggestions() throws Exception {
            );  
        if (numEmptyResponses > 0) {
 *
                networkTime
                emptyFetchResults,  
            // Add query profile data
        return RandomizedContext.current()  
            assertFalse(reduce.sortedTopDocs.isSortedByField);  
            assertNull(reduce.sortedTopDocs.sortFields);
            nShards,  
 * specific language governing permissions and limitations
            expectedNumResults,  
                true,
        assertFalse(reduce.sortedTopDocs.isSortedByField);
        int nShards = randomIntBetween(1, 20);
        {  
                    Collections.emptyMap(),  
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
                new SearchPhaseController.TopDocsStats(trackTotalHits),  
            };  
        consumerTestCase(0);
                assertThat(mergedResponse.hits.getTotalHits().value(), equalTo(0L));
        assertAggReduction(request);
                "BooleanQuery",
        // results have arrived
                new ArrayList<>();
            ProfileResult fetchPhase = new ProfileResult(  
            QuerySearchResult result = new QuerySearchResult(  
        ScoreDoc[] sortedDocs = SearchPhaseController.sortDocs(true, topDocsList, from, size, reducedCompletionSuggestions).scoreDocs;
            float score = useConstantScore ? 1.0F : Math.abs(randomFloat());
        assertNotNull("Merged profiles should not be null", mergedProfiles);
        int nShards,
                new ShardSearchContextId("", i),
                int numOptions = randomIntBetween(1, 10);  
                TermSuggestion.Entry entry = new TermSuggestion.Entry(new Text("entry"), 0, 10);
    }  
        List<CompletionSuggestion> suggestions,
        }  
        }
        List<CompletionSuggestion> suggestions,  
import static java.util.Collections.singletonList;  
        request.source(new SearchSourceBuilder().aggregation(AggregationBuilders.avg("foo")).size(0));
        AtomicInteger max = new AtomicInteger();  
        AtomicArray<SearchPhaseResult> results = generateQueryResultsWithFloatDoubleSortedField(
        InternalMax internalMax = (InternalMax) reduce.aggregations.asList().get(0);
            SearchShardTarget searchShardTarget = new SearchShardTarget(
        int nShards = randomIntBetween(1, 20);
            assertEquals("First fetch child should be LoadStoredFields", "LoadStoredFields", fetchChildren.get(0).getQueryName());  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
                }  
            threadPool.getThreadContext()
        fixedExecutor.shutdownNow();
                suggestion.addTerm(completionEntry);
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(
    }
        int bufferSize = randomIntBetween(2, 200);
            FieldDoc[] fieldDocs = { new FieldDoc(0, Float.NaN, new Object[] { number }) };  
            || searchRequest.source().aggregations().getAggregatorFactories().isEmpty()) {
            int shardId = 2 + numEmptyResponses;  
                    );
                    int score = numOptions - j;
        long randomSeed = randomLong();
        for (int shardIndex = 0; shardIndex < nShards; shardIndex++) {  
        float maxScore = 0;
        SearchPhaseController.ReducedQueryPhase reduce = consumer.reduce();  
import org.opensearch.search.profile.ProfileShardResult;  
                exc -> {}
                    Collections.emptyMap(),
                null  
                result.aggregations(aggs);
            new SearchShardTarget("node", new ShardId("a", "b", 0), null, OriginalIndices.NONE),
            suggestions.add(new CompletionSuggestion(randomAlphaOfLength(randomIntBetween(1, 5)), randomIntBetween(1, 20), false));  
        assertEquals(0, reduce.sortedTopDocs.scoreDocs.length);
            assertEquals("Should have query children", 2, mainQuery.getProfiledChildren().size());
import org.opensearch.core.common.Strings;
            List<QueryProfileShardResult> queryResults = mergedProfile.getQueryProfileResults();
    }
                return checkCount.decrementAndGet() <= 0;
            }
                    int score = numOptions - j;
            topDocsList.add(topDocs);
 * Modifications Copyright OpenSearch Contributors. See
            InternalMax internalMax = (InternalMax) reduce.aggregations.asList().get(0);  
        }  
                if (suggestion instanceof CompletionSuggestion) {
                aggResults,
            request,
                OriginalIndices.NONE
        request.source(new SearchSourceBuilder().size(5).from(5));  
            threads[i].join();
                    new SearchShardTarget("node", new ShardId("a", "b", id), null, OriginalIndices.NONE),
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertNull(reduce.sortedTopDocs.collapseField);
            SearchProgressListener.NOOP,
            float maxScore = 0;
                InternalAggregations aggs = InternalAggregations.from(
            }  
                numTotalReducePhases = 1;
            suggestions.add(new CompletionSuggestion(randomAlphaOfLength(randomIntBetween(1, 5)), randomIntBetween(1, 20), false));
import static org.hamcrest.Matchers.equalTo;
        assertNull(reduce.sortedTopDocs.sortFields);
            QuerySearchResult result = new QuerySearchResult(
        } else {
            expectedNumResults,
        }
                    }
            assertEquals(maxScorePhrase, phrase.getEntries().get(0).getOptions().get(0).getScore(), 0f);
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),  
            assertEquals(1, completion.getOptions().size());  
    public void testSortIntFloatDoubleFieldDocsMerge() {
            result.setShardIndex(i);
        InternalAggregations aggs = InternalAggregations.from(singletonList(new InternalMax("test", 1.0D, DocValueFormat.RAW, emptyMap())));
 * the Apache License, Version 2.0 (the "License"); you may
                    "LoadStoredFields",
                    ),
import org.opensearch.common.util.concurrent.AtomicArray;
    ) {
     */  
            querySearchResult.size(searchHitsSize);  
            {  
        for (int i = 0; i < expectedNumResults; i++) {
        latch.await();  
            queryResults.set(shardIndex, querySearchResult);  
        boolean useConstantScore = randomBoolean();  
        }
            fixedExecutor,
            result.topDocs(new TopDocsAndMaxScore(topDocs, Float.NaN), docValueFormats);
            false  
    }
        float maxScore = 0;
        assertEquals(1, reduce.sortedTopDocs.scoreDocs.length);
            null
        assertEquals(expectedNumResults, reduce.totalHits.value());  
        AssertingCircuitBreaker circuitBreaker = new AssertingCircuitBreaker(CircuitBreaker.REQUEST);
                    "loading doc values",
                    "LoadStoredFields",
        int bufferSize = randomIntBetween(2, 3);  
import java.util.List;
                    new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(0, number) }),  
        int expectedNumResults = randomIntBetween(1, 100);  
            fixedExecutor,  
                assertEquals(1, consumer.getNumReducePhases());
            fieldDocs[i] = new FieldDoc(i, score, new Integer[] { randomInt() });
    private static TopFieldDocs getDoubleTopFieldDocs(int nDocs, boolean useConstantScore) {
    }
                fetchChildren
            ProfileShardResult fetchProfileResult = new ProfileShardResult(
        DocValueFormat[] docValueFormats = { DocValueFormat.RAW };  
        assertAggReduction(request);
    public void testConsumerOnlyHits() throws Exception {
            SearchPhaseController.setShardIndex(topDocs, result.getShardIndex());
import org.apache.lucene.search.TopDocs;
                        maxScoreValue -= dec;
            assertEquals(1, completion.getSize());
            queryProfileMap.put(shardId, queryProfile);
                Collections.emptyList(), // no query results in fetch  
                completionSuggestion.addTerm(entry);  
                result.setShardIndex(index);
        int bufferSize = randomIntBetween(2, 200);
        List<SearchPhaseResult> fetchResults = new ArrayList<>();
        int nShards = 2;  
    }
            QuerySearchResult empty = QuerySearchResult.nullInstance();
        result.setShardIndex(0);  
    public void testConsumerOnlyAggs() throws Exception {
        request.setBatchedReduceSize(bufferSize);  
                    "terms on field",
            nShards,  
    /**
                        assertEquals("Should have 2 query children", 2, queryResult.getQueryResults().get(0).getProfiledChildren().size());
            new DocValueFormat[0]  
     * Few shards with Float and few shards with Double
                new DocValueFormat[0]
        performSortDocs(results, queryResultSize);
            result.size(1);  
        for (int i = 0; i < expectedNumResults; i++) {
        request.setBatchedReduceSize(batchedReduceSize);
import org.opensearch.search.aggregations.InternalAggregation;
            new TopDocsAndMaxScore(new TopDocs(new TotalHits(0, TotalHits.Relation.EQUAL_TO), new ScoreDoc[0]), Float.NaN),
        }  
 * this work for additional information regarding copyright
        List<CompletionSuggestion> suggestions,
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(
            );
            NetworkTime networkTime = new NetworkTime(5L, 10L);
            consumer.consumeResult(result, latch::countDown);
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
        result.topDocs(
        List<CompletionSuggestion> reducedCompletionSuggestions = reducedSuggest(results);
            }
            assertEquals("Outbound network time should be from query phase", 10L, networkTime.getOutboundNetworkTime());
     * number of search hits and randomly generated completion suggestions based on the name and size of the provided ones.  
    }
                        assertEquals("Aggregation should be GlobalAggregator", "GlobalAggregator", aggProfile.getQueryName());
                    entry.addOption(new TermSuggestion.Entry.Option(new Text("option"), randomInt(), score));
        AtomicArray<SearchPhaseResult> results = generateSeededQueryResults(
        for (int i = 0; i < 4; i++) {  
            suggestions.add(new CompletionSuggestion(randomAlphaOfLength(randomIntBetween(1, 5)), randomIntBetween(1, 20), false));
        int nShards = randomIntBetween(1, 20);  
                    40L,
                null  
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;  
    ) {
        }
                public void onQueryResult(int shardIndex) {
        }
            querySearchResult.suggest(new Suggest(new ArrayList<>(shardSuggestion)));
import org.junit.Before;
        assertNull(reduce.sortedTopDocs.sortFields);
            request,
                int numOptions = randomIntBetween(1, 10);  
            ProfileResult mainQuery = new ProfileResult(  
                    Collections.emptyList()
    public void cleanup() {
            float maxScore = -1F;  
            request.setBatchedReduceSize(bufferSize);  
    /**  
            exc -> {}
            new SearchShardTarget("node", new ShardId("a", "b", 0), null, OriginalIndices.NONE),
                    null
            );  
        for (int i = 0; i < randomIntBetween(1, 5); i++) {  
                        assertEquals(
            assertNull(reduce.sortedTopDocs.collapseValues);  
import java.util.concurrent.CopyOnWriteArrayList;
        boolean useConstantScore
            {  
                    Collections.emptyMap(),
        int numShards = 3 + numEmptyResponses;
                    int number = randomIntBetween(1, 1000);  
        }
 * compatible open source license.
            for (CompletionSuggestion completionSuggestion : suggestions) {
            threads[i] = new Thread(() -> {
                    maxScoreCompletion = Math.max(maxScoreCompletion, score);  
                            "BooleanQuery",
/*
        int nShards,  
import org.opensearch.common.lucene.Lucene;  
            expectedNumResults,
            if (trackTotalHits == SearchContext.TRACK_TOTAL_HITS_DISABLED) {
            ProfileResult mainQuery = queryProfileResults.get(0);
            CompletionSuggestion completion = reduce.suggest.getSuggestion("completion");
        assertEquals(100.f, reduce.maxScore, 0.0f);  
    private static AtomicArray<SearchPhaseResult> generateFetchResults(int nShards, ScoreDoc[] mergedSearchDocs, Suggest mergedSuggest) {  
        }  
            ProfileResult mainQuery = new ProfileResult(
     * Note that <code>shardIndex</code> is already set to the generated completion suggestions to simulate what
                new ShardSearchContextId("", i),  
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(
    public void testConsumerFieldCollapsing() throws Exception {
            result.setShardIndex(i);
                    null,
                Arrays.asList(queryShardResult),
            maxScore = Math.max(score, maxScore);  
            if (i % 2 == 0) {
            QuerySearchResult result = new QuerySearchResult(
            maxScore = Math.max(score, maxScore);  
                assertEquals(mergedResponse.hits.getTotalHits().relation(), Relation.EQUAL_TO);  
        return new TopFieldDocs(new TotalHits(fieldDocs.length, TotalHits.Relation.EQUAL_TO), fieldDocs, sortFields);
            result = QuerySearchResult.nullInstance();
            result.size(1);
                topDocs = getLongTopFieldDocs(nDocs, useConstantScore);
    }
import org.opensearch.search.DocValueFormat;  
import org.opensearch.search.internal.ShardSearchRequest;  
        assertNull(reduce.sortedTopDocs.collapseValues);
        assertEquals(93.0f, scoreDocs[2].score, 0.0f);
            assertEquals(1, reduce.sortedTopDocs.scoreDocs.length);
        consumeShardLevelQueryPhaseResultsAsync(expectedNumResults, consumer);
        List<SearchPhaseResult> fetchResults = new ArrayList<>();
        return resultCount;  
            exc -> {}  
    private void assertAggReduction(SearchRequest searchRequest) {
            fieldDocs[i] = new FieldDoc(i, score, new Long[] { randomLong() });
            assertEquals(1, term.getEntries().size());
            topDocsList.add(topDocs);
        SearchRequest request = randomSearchRequest();
            QuerySearchResult queryResult = result.queryResult();
                    );
            assertEquals("Should have fetch children", 2, fetchPhase.getProfiledChildren().size());  
                    numQueryFailureListener.incrementAndGet();
            TopDocs topDocs = queryResult.consumeTopDocs().topDocs;
import org.opensearch.search.profile.ProfileResult;
                    max.updateAndGet(prev -> Math.max(prev, number));
                int numOptions = randomIntBetween(1, 10);  
        int expectedNumResults = randomIntBetween(20, 200);  
                        }
            Object[] values = { randomFrom(collapseValues) };  
    private AtomicArray<SearchPhaseResult> generateSeededQueryResults(
                    "loading _source",
            ProfileResult aggProfile = new ProfileResult(  
        long seed,  
                Collections.emptyMap(),
        }
        for (int i = 0; i < nDocs; i++) {  
                int id = i;
                        ProfileResult aggProfile = mergedProfile.getAggregationProfileResults().getProfileResults().get(0);
            SearchProgressListener.NOOP,
            SearchShardTarget shardTarget = shardTargets.get(shardIndex);
                return InternalAggregation.ReduceContext.forPartialReduction(  
import org.opensearch.search.suggest.Suggest;
                        );  
                randomIntBetween(30, 60),
            int number = randomIntBetween(1, 1000);
 * GitHub history for details.
            FetchSearchResult fetchSearchResult = new FetchSearchResult(new ShardSearchContextId("", shardIndex), shardTarget);  
        }
        for (SearchPhaseResult result : results.asList()) {
            new ShardSearchContextId("", 1),
            fetchResults.add(fetchResult);  
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),  
            assert bytes >= 0 : bytes + " is less than 0";
        );
            latch.await();  
    }  
    }  
    }
                InternalAggregations aggs = InternalAggregations.from(
            } else {
            expectedNumResults,
     * Test to verify merge shard results with SortField.Type.Int, document type Integer  
    public void testPartialReduceWithFailure() throws Exception {
            TopDocs topDocs = shardResult.queryResult().topDocs().topDocs;
                            "Collector should be TotalHitCountCollector",  
            int suggestSize = 0;  
            suggestions.add(new CompletionSuggestion(randomAlphaOfLength(randomIntBetween(1, 5)), randomIntBetween(1, 20), false));
import org.opensearch.action.OriginalIndices;
            } else {  
    private static void performSortDocs(AtomicArray<SearchPhaseResult> results, int queryResultSize) {
            circuitBreaker,
        AtomicArray<SearchPhaseResult> results = generateQueryResultsWithIntSortedField(nShards, suggestions, queryResultSize, false);  
            : SearchRequest.subSearchRequest(new SearchRequest(), Strings.EMPTY_ARRAY, "remote", 0, randomBoolean());
        }
                Arrays.asList(mainQuery),  
        int size = randomIntBetween(5, 10);  
            assertEquals(maxScoreTerm, term.getEntries().get(0).getOptions().get(0).getScore(), 0f);
    public void testSortDocs() {  
                @Override
        CountDownLatch latch = new CountDownLatch(4);
        CompletionSuggestion completionSuggestion = new CompletionSuggestion(null, -1, randomBoolean());
import static org.hamcrest.Matchers.instanceOf;
                            "Main query should be BooleanQuery",  
                "GlobalAggregator",
            assertEquals(0, numQueryFailureListener.get());  
        int partialReduceMethodCallCount = expectedNumResults / batchedReduceSize;  
                }
        request.setBatchedReduceSize(bufferSize);
            ProfileShardResult queryProfile = new ProfileShardResult(  
            results.get(i).queryResult().topDocs(new TopDocsAndMaxScore(topDocs, maxScore), new DocValueFormat[1]);
            } else {  
                }
        circuitBreaker.shouldBreak.set(true);
                    finalAggsListener.set(aggs);  
    protected NamedWriteableRegistry writableRegistry() {  
            if (mergedResponse.profileResults != null) {  
                InternalAggregationTestCase.emptyReduceContextBuilder(),  
import org.apache.lucene.search.TopFieldDocs;
        result = new QuerySearchResult(
    private List<Boolean> reductions;  
                new NetworkTime(2L, 3L)
    }
        assertEquals(numTotalReducePhases, reduce.numReducePhases);
        int queryResultSize = randomBoolean() ? 0 : randomIntBetween(1, nShards * 2);
                    25L,
            {  
            AggregationProfileShardResult aggResults = new AggregationProfileShardResult(Arrays.asList(aggProfile));
        }
                            fetchProfile.getProfiledChildren().get(0).getQueryName()
    }
        }
        FieldDoc[] fieldDocs = new FieldDoc[nDocs];  
        int queryResultSize = randomBoolean() ? 0 : randomIntBetween(1, nShards * 2);
        result.setShardIndex(1);
        SearchRequest request = randomSearchRequest();
                @Override
                new DocValueFormat[0]  
                60L,
 */
                    result.size(1);
            AtomicArray<SearchPhaseResult> queryResults = generateQueryResults(nShards, suggestions, queryResultSize, false);
            );
            }
        threadPool = new TestThreadPool(SearchPhaseControllerTests.class.getName());
    /**
        }
                    assertThat(options.size(), equalTo(suggestion.getEntries().get(0).getOptions().size()));  
    private static AtomicArray<SearchPhaseResult> generateQueryResultsWithIntLongSortedField(
import java.util.HashMap;
        int expectedNumResults = randomIntBetween(1, 100);  
        int searchHitsSize,
        SearchPhaseController.ReducedQueryPhase reduce = consumer.reduce();
            FieldDoc[] fieldDocs = { new FieldDoc(0, Float.NaN, values) };
        Optional<SearchPhaseResult> first = results.asList().stream().findFirst();  
                        );  
                termSuggestion.addTerm(entry);  
        aggs = InternalAggregations.from(singletonList(new InternalMax("test", 2.0D, DocValueFormat.RAW, emptyMap())));
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
        AtomicBoolean hasConsumedFailure = new AtomicBoolean();  
        final int numTotalReducePhases;
import org.opensearch.search.suggest.completion.CompletionSuggestion;  
                    if (!mergedProfile.getAggregationProfileResults().getProfileResults().isEmpty()) {  
        int nShards = randomIntBetween(1, 20);  
                    PipelineTree.EMPTY
import static org.hamcrest.Matchers.containsString;
            FetchProfileShardResult fetchProfile = mergedProfile.getFetchProfileResult();
                    assertNotNull("Network time should be preserved", mergedProfile.getNetworkTime());
            fetchResult.profileResults(fetchProfileResult);
                    Collections.emptyMap(),
        SearchRequest request = new SearchRequest();
import org.opensearch.search.profile.aggregation.AggregationProfileShardResult;
        CountDownLatch latch = new CountDownLatch(expectedNumResults);
    }
                    number
                new ShardId("", "", shardIndex),
                    completionEntry.addOption(  
        assertEquals(3.0D, max.getValue(), 0.0D);
    }  
            SearchProgressListener.NOOP,  
    }
            QuerySearchResult result = new QuerySearchResult(
import org.opensearch.search.SearchShardTarget;
        assertEquals(0, reduce.totalHits.value());  
                null,
        }
            OpenSearchExecutors.daemonThreadFactory("test"),
        SortField[] sortFields = { new SortedNumericSortField("field", SortField.Type.INT, true) };
                suggestion.setShardIndex(shardIndex);
                topDocs = getDoubleTopFieldDocs(nDocs, useConstantScore);
    public void testConsumerSortByField() throws Exception {  
            results.get(i).queryResult().topDocs(new TopDocsAndMaxScore(topDocs, maxScore), new DocValueFormat[1]);  
                "GlobalAggregator",  
                    Collections.emptyList()  
            }
                        new DocValueFormat[0]  
                PhraseSuggestion.Entry entry = new PhraseSuggestion.Entry(new Text("entry"), 0, 10);
        assertNull(reduce.sortedTopDocs.sortFields);  
            );
                    null,
            for (Suggest.Suggestion<?> suggestion : mergedSuggest) {
        return results;
    }
        private volatile long allocated;  
            }  
                    maxScoreTerm = Math.max(maxScoreTerm, score);  
                    "loading doc values",
            PhraseSuggestion phrase = reduce.suggest.getSuggestion("phrase");
        AtomicArray<SearchPhaseResult> results = generateQueryResultsWithFloatSortedField(nShards, suggestions, queryResultSize, false);
                if (scoreDoc.shardIndex == shardIndex) {  
    }
            public ReduceContext forFinalReduction() {
                "TotalHitCountCollector",  
                    assertEquals(numReduceListener.incrementAndGet(), reducePhase);  
                    () -> PipelineTree.EMPTY  
                Collections.emptyMap(),  
            QueryProfileShardResult queryResult = queryResults.get(0);  
            ProfileShardResult mergedProfile = mergedProfiles.getShardResults().get(shardId);
        );  
        List<CompletionSuggestion> suggestions = new ArrayList<>();
                new ShardSearchContextId("", i),  
    }
        for (int i = 0; i < expectedNumResults; i++) {
                "global agg",
                        j,
        assertEquals(95.0f, scoreDocs[0].score, 0.0f);
import java.util.stream.Stream;
        );
            expectedNumResults,  
                )  
        }  
        performSortDocs(results, queryResultSize);
                    }
import org.opensearch.search.profile.SearchProfileShardResults;
            FetchProfileShardResult fetchProfileShardResult = new FetchProfileShardResult(Arrays.asList(fetchPhase));
                randomIntBetween(50, 100),
            result.size(size);  
                new ShardSearchContextId("", i),
                new CollectorResult("SimpleTopScoreDocCollector", "collecting docs", randomIntBetween(20, 40), Collections.emptyList())  
            AtomicReference<TotalHits> totalHitsListener = new AtomicReference<>();
                new SearchShardTarget("node", new ShardId("a", "b", i), null, OriginalIndices.NONE),
            );
    }  
        }
            ? new SearchRequest()  
            final TopDocs topDocs;  
        throws InterruptedException {
                result.size(1);  
        int partialReduceMethodCallCount = expectedNumResults / batchedReduceSize;
        int bufferSize = randomIntBetween(2, 200);
            assertEquals(expectedNumResults, reduce.totalHits.value());
    @Override
                    Collections.emptyMap(),  
    ) {
        return new TopFieldDocs(new TotalHits(fieldDocs.length, TotalHits.Relation.EQUAL_TO), fieldDocs, sortFields);
        }
        assertEquals(1, reduce.sortedTopDocs.sortFields.length);
        // The exception is only thrown during the call to reduce which will happen once all shard level  
import org.apache.lucene.search.FieldDoc;  
        results = generateSeededQueryResults(randomSeed, nShards, Collections.emptyList(), queryResultSize, useConstantScore);  
                    "TermsAggregator",
import org.opensearch.search.internal.SearchContext;
                )  
                public void onPartialReduce(List<SearchShard> shards, TotalHits totalHits, InternalAggregations aggs, int reducePhase) {
                assertEquals("Should have profiles for all shards", nShards, mergedResponse.profileResults.getShardResults().size());
            consumer.consumeResult(result, latch::countDown);
            assertThat(exc.getMessage(), containsString("<reduce_aggs>"));  
        int queryResultSize = randomBoolean() ? 0 : randomIntBetween(1, nShards * 2);
     */
            });
/*  
                threads[i] = new Thread(() -> {
                new ProfileResult("TermQuery", "field:value", Collections.emptyMap(), Collections.emptyMap(), 15L, Collections.emptyList()),
        );  
            SearchProgressListener.NOOP,
        assertEquals(max.get(), reduce.maxScore, 0.0f);  
            }
            InternalAggregations aggs = InternalAggregations.from(  
        // The caller should handle null queryProfiles and not call mergeFetchProfiles  
        for (int shardIndex = 0; shardIndex < nShards; shardIndex++) {  
 */  
            r -> InternalAggregationTestCase.emptyReduceContextBuilder()
        reductions = new CopyOnWriteArrayList<>();
            SearchPhaseController.setShardIndex(topDocs, result.getShardIndex());  
            new ShardSearchContextId("", 0),
        assertAggReduction(request);
    }  
            List<CollectorResult> collectorChildren = Arrays.asList(
                );
            null
            || searchRequest.source().aggregations() == null  
            );
            assertEquals(1, phrase.getEntries().get(0).getOptions().size());  
                collectorChildren  
import org.opensearch.search.query.QuerySearchResult;  
            new TopDocsAndMaxScore(new TopDocs(new TotalHits(0, TotalHits.Relation.EQUAL_TO), new ScoreDoc[0]), Float.NaN),
                    Collections.emptyList()  
    public void testConsumer() throws Exception {
                        assertEquals("Should have 2 fetch children", 2, fetchProfile.getProfiledChildren().size());  
     * {@link SearchPhaseController#reducedQueryPhase} does,
        InternalMax internalMax = (InternalMax) reduce.aggregations.asList().get(0);  
            request,  
                new ProfileResult(
        );  
                ),
            null  
import java.util.stream.Collectors;
                    new DocValueFormat[0]
            if (shouldFailPartial == false) {
        DocValueFormat[] docValueFormats = { DocValueFormat.RAW };
        request.source(new SearchSourceBuilder().aggregation(AggregationBuilders.avg("foo")).size(0));  
                new ProfileResult(
import java.util.concurrent.atomic.AtomicBoolean;
                    assertEquals(numReduceListener.incrementAndGet(), reducePhase);
            expectedNumResults,
        int queryResultSize = randomBoolean() ? 0 : randomIntBetween(1, nShards * 2);
            result.topDocs(new TopDocsAndMaxScore(Lucene.EMPTY_TOP_DOCS, Float.NaN), new DocValueFormat[0]);
                new NetworkTime(randomIntBetween(1, 3), randomIntBetween(1, 3))  
            maxScore = Math.max(score, maxScore);  
            );
                result.aggregations(aggs);
import org.opensearch.search.builder.SearchSourceBuilder;  
        long beforeCompletedTasks = fixedExecutor.getCompletedTaskCount();
import org.opensearch.search.profile.query.CollectorResult;
        result.aggregations(aggs);  
            querySearchResult.topDocs(new TopDocsAndMaxScore(topDocs, maxScore), null);
        FieldDoc[] fieldDocs = new FieldDoc[nDocs];  
                Collections.singletonList(new InternalMax("test", (double) number, DocValueFormat.RAW, Collections.emptyMap()))
 * Licensed to Elasticsearch under one or more contributor  
        int searchHitsSize,
                    );  
                        assertNotNull(option.getHit());
import org.opensearch.threadpool.ThreadPool;  
            }
                "node_" + shardIndex,
                fetchProfileShardResult,
            );  
            AggregationProfileShardResult aggResult = mergedProfile.getAggregationProfileResults();
                                maxScore = doc.score;
            );
                new SearchShardTarget("node", new ShardId("a", "b", i), null, OriginalIndices.NONE),
        request.setBatchedReduceSize(bufferSize);  
                            queryResult.getQueryResults().get(0).getQueryName()
            float score = useConstantScore ? 1.0F : Math.abs(randomFloat());
                ),
        if (first.isPresent()) {
                "fetch documents",
        int batchedReduceSize = randomIntBetween(2, expectedNumResults - 1);  
    }  
            final TopDocs topDocs;
            10,  
        int queryResultSize = randomBoolean() ? 0 : randomIntBetween(1, nShards * 2);  
        CountDownLatch latch = new CountDownLatch(expectedNumResults);
            assertThat(mergedResponse.hits().getHits().length, equalTo(reducedQueryPhase.sortedTopDocs.scoreDocs.length - suggestSize));  
            new TopDocsAndMaxScore(new TopDocs(new TotalHits(0, TotalHits.Relation.EQUAL_TO), new ScoreDoc[0]), Float.NaN),  
            List<CompletionSuggestion> shardSuggestion = new ArrayList<>();  
        }  
            exc -> hasConsumedFailure.set(true)  
        AtomicInteger checkCount = new AtomicInteger(expectedNumResults + partialReduceMethodCallCount);
                )  
        List<CompletionSuggestion> suggestions,
            exc -> {}
            );  
                );  
        SearchRequest request = randomSearchRequest();
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
        );
            testReduceCase(false);
            ProfileResult fetchPhase = new ProfileResult(
            suggestions.add(new CompletionSuggestion(randomAlphaOfLength(randomIntBetween(1, 5)), randomIntBetween(1, 20), false));
                new SearchShardTarget("node", new ShardId("a", "b", i), null, OriginalIndices.NONE),
                QuerySearchResult result = new QuerySearchResult(
                    new ShardSearchContextId(UUIDs.randomBase64UUID(), index),
        int maxScoreTerm = -1;  
            );
            exc -> {}
            result.setShardIndex(i);
                    }
                            "First fetch child should be LoadStoredFields",
        if (numShards > bufferSize) {
            CollectorResult collectorResult = new CollectorResult(
        }  
        List<CompletionSuggestion> suggestions = new ArrayList<>();  
            fetchSearchResult.hits(new SearchHits(hits, new TotalHits(hits.length, Relation.EQUAL_TO), maxScore));  
        return groupedSuggestion.values().stream().map(completionSuggestion::reduce).collect(Collectors.toList());  
        assertEquals(0, reduce.sortedTopDocs.scoreDocs[0].doc);
                shardSuggestion.add(suggestion);  
        assertEquals(92.0f, scoreDocs[3].score, 0.0f);
                request,
                }  
        int score = 100;
                        new SearchShardTarget("node", new ShardId("a", "b", id), null, OriginalIndices.NONE),
        int expectedNumResults = randomIntBetween(20, 200);
            request,  
            );
    }  
            request,  
                threads[i].join();
        int searchHitsSize,  
            }
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
                assertEquals(false, reductions.get(0));  
            return allocated;
        AtomicInteger max = new AtomicInteger();  
                        );
            () -> {  
                reductions.add(false);
import org.opensearch.core.index.shard.ShardId;
                randomIntBetween(20, 40),
            final int index = i;
        int queryResultSize = randomBoolean() ? 0 : randomIntBetween(1, nShards * 2);
                topDocs = new TopDocs(new TotalHits(scoreDocs.length, TotalHits.Relation.EQUAL_TO), scoreDocs);
                new ArrayList<>(),
            assertEquals(1, phrase.getEntries().size());
            NetworkTime networkTime = mergedProfile.getNetworkTime();
        );
            );
        boolean useConstantScore  
                fetchResults::get  
        // This simulates what happens in buildResponse when shardResults is null
                fetchResults.asList(),
        }
        assertNull("Merged profiles should be null when queryProfiles is null", mergedProfiles);
        }
    }  
        consumer.consumeResult(result, latch::countDown);
                            "TotalHitCountCollector",
            ProfileResult aggProfile = aggResult.getProfileResults().get(0);
        assertNull(reduce.sortedTopDocs.collapseValues);
                    Collections.emptyMap(),
            int nDocs = randomIntBetween(0, searchHitsSize);
            assertEquals(0, reductions.size());
                );  
            for (int i = 0; i < expectedNumResults; i++) {  
        request.setOutboundNetworkTime(randomIntBetween(1, 5));
 * SPDX-License-Identifier: Apache-2.0
            4,
        );
            results.get(i).queryResult().topDocs(new TopDocsAndMaxScore(topDocs, maxScore), new DocValueFormat[1]);  
                    "terms on field",
                    null
    }  
        }
        assertEquals(91.0f, scoreDocs[4].score, 0.0f);  
        assertThat(circuitBreaker.allocated, equalTo(0L));  
 *
            int number = randomIntBetween(1, 1000);  
        SearchPhaseController.ReducedQueryPhase reduce = consumer.reduce();
            String clusterAlias = randomBoolean() ? null : "remote";
                    randomIntBetween(15, 30),
    public void testSortFloatFieldDocsMerge() {
            request,
        SearchPhaseController.ReducedQueryPhase reduce = consumer.reduce();  
        int expectedNumResults = randomIntBetween(1, 100);
        for (int i = 0; i < sortedDocs.length; i++) {
        assertEquals("field", reduce.sortedTopDocs.sortFields[0].getField());
                "main query",
            }
            result.setShardIndex(i);
            queryResultSize,
            threads[index].start();
        Thread[] threads = new Thread[expectedNumResults];  
            exc -> {}
                        maxScore = scoreDoc.score;  
        assertEquals(max.get(), internalMax.getValue(), 0.0D);  
            assertEquals("Should have one main query", 1, queryProfileResults.size());
import org.opensearch.common.UUIDs;
        for (int shardIndex = 0; shardIndex < nShards; shardIndex++) {  
            ProfileShardResult fetchProfileResult = new ProfileShardResult(
            writableRegistry(),  
        assertEquals(max.get(), reduce.maxScore, 0.0f);
                    }
                    maxScore = Math.max(score, maxScore);
                    Collections.emptyMap(),  
    private static class AssertingCircuitBreaker extends NoopCircuitBreaker {  
        assertEquals(sortedDocs.length, sortedDocs2.length);  
        public double addEstimateBytesAndMaybeBreak(long bytes, String label) throws CircuitBreakingException {
                new TopDocsAndMaxScore(new TopDocs(new TotalHits(3, TotalHits.Relation.EQUAL_TO), docs), docs[0].score),
        }
        FetchSearchResult fetchResult = new FetchSearchResult();  
            final TopDocs topDocs;  
            empty.setSearchShardTarget(new SearchShardTarget("node", new ShardId("a", "b", shardId), null, OriginalIndices.NONE));
            // Create empty fetch profile (will be replaced by merge)
    }
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(
                    new SearchShardTarget("node", new ShardId("a", "b", index), null, OriginalIndices.NONE),  
        consumeShardLevelQueryPhaseResultsAsync(expectedNumResults, consumer);
            assertEquals("Main query name should be preserved", "BooleanQuery", mainQuery.getQueryName());  
        ScoreDoc[] sortedDocs = SearchPhaseController.sortDocs(ignoreFrom, topDocsList, from, size, Collections.emptyList()).scoreDocs;
                    12L,
        }
                }
import org.opensearch.core.tasks.TaskCancelledException;
            fieldDocs[i] = new FieldDoc(i, score, new Float[] { randomFloat() });
                new CollectorResult("SimpleTopScoreDocCollector", "collecting docs", 30L, Collections.emptyList())
                "BooleanQuery",  
                    }
                Collections.emptyMap(),
 * You may obtain a copy of the License at  
        assertEquals(max.get(), reduce.maxScore, 0.0f);
                "",  
            expectedNumResults,
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
                    entry.addOption(option);
        for (int shardIndex = 0; shardIndex < nShards; shardIndex++) {
            ScoreDoc[] docs = new ScoreDoc[3];  
                    Collections.emptyList()
                        assertEquals("Should have 1 aggregation child", 1, aggProfile.getProfiledChildren().size());  
            }
        AtomicArray<SearchPhaseResult> queryResults = new AtomicArray<>(nShards);
            SearchPhaseController.ReducedQueryPhase phase = consumer.reduce();  
            assertEquals(maxScoreCompletion, option.getScore(), 0f);
        assertNull(reduce.sortedTopDocs.collapseField);  
            consumer.consumeResult(result, latch::countDown);  
        // To make it deterministic, we can count the number of times the partialReduce and reduce are called
        }  
                    new DocValueFormat[0]  
                    assertThat(shardIndex, lessThan(expectedNumResults));  
 * not use this file except in compliance with the License.
            1,
            );
                new ShardSearchContextId("", i),
        int expectedNumResults = randomIntBetween(30, 100);  
        for (int i = 0; i < expectedNumResults; i++) {  
        );
                Collections.emptyList(), // no query results in fetch
        FieldDoc[] fieldDocs = new FieldDoc[nDocs];  
                topDocs = Lucene.EMPTY_TOP_DOCS;
        assertNull(reduce.sortedTopDocs.collapseField);
                docs[j] = new ScoreDoc(0, score--);
                queryChildren  
            allocated += bytes;  
    public void testMergeFetchProfiles() {
                        Collections.singletonList(new InternalMax("test", (double) number, DocValueFormat.RAW, Collections.emptyMap()))  
        SearchPhaseController.ReducedQueryPhase reduce = consumer.reduce();
                for (int j = 0; j < numOptions; j++) {
            assertEquals("Fetch phase name should be correct", "FetchPhase", fetchPhase.getQueryName());
    public void testConsumerConcurrently() throws Exception {  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
        request.source(new SearchSourceBuilder().aggregation(AggregationBuilders.avg("foo")));  
        assertEquals(SortField.Type.STRING, reduce.sortedTopDocs.sortFields[0].getType());  
            if (bufferSize == 2) {  
            for (Suggest.Suggestion s : reducedQueryPhase.suggest) {
                        assertEquals(  
     */
            );
        @Override  
                }  
                Collections.emptyMap(),  
        SortField[] sortFields = { new SortedNumericSortField("field", SortField.Type.DOUBLE, true) };
        latch.await();
        for (int i = 0; i < nDocs; i++) {  
                Collections.emptyMap(),
                "main query",
            result.setShardIndex(shardId);
        int nShards = randomIntBetween(1, 20);
            float maxScore = 0;
        assertAggReduction(request);  
        latch.await();
                    if (!mergedProfile.getQueryProfileResults().isEmpty()) {  
                    scoreDocs[i] = new ScoreDoc(i, score);
        });
        boolean useConstantScore  
            assertEquals("Query rewrite time should be preserved", 20L, queryResult.getRewriteTime());
import org.opensearch.search.profile.NetworkTime;
        latch.await();
            assertEquals(0, reductions.size());
                new ShardId("index", "uuid", shardIndex),  
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
                consumer.consumeResult(result, latch::countDown);
                );
            assertEquals("Second fetch child time should be correct", 8L, fetchChildren.get(1).getTime());  
                Stream<CompletionSuggestion.Entry> stream = s.getEntries().stream();
            threads[index] = new Thread(() -> {  
            assertEquals("First fetch child time should be correct", 12L, fetchChildren.get(0).getTime());
                );
import java.util.ArrayList;
        return new NamedWriteableRegistry(entries);
            // Add fetch profile data
        }  
            request,  
        for (int i = 0; i < nDocs; i++) {  
            }
import org.opensearch.common.settings.Settings;
            int number = randomIntBetween(1, 1000);
                result.setShardIndex(id);  
            result.topDocs(new TopDocsAndMaxScore(topDocs, Float.NaN), docValueFormats);
            };  
        assertThrows(CircuitBreakingException.class, () -> consumer.reduce());
import com.carrotsearch.randomizedtesting.RandomizedContext;
                randomIntBetween(5, 15), // rewrite time
            result.setShardIndex(i);
                )
                public void onQueryFailure(int shardIndex, SearchShardTarget shardTarget, Exception exc) {
            result.from(5);
 * Unless required by applicable law or agreed to in writing,
            suggestions.add(new CompletionSuggestion(randomAlphaOfLength(randomIntBetween(1, 5)), size, false));
        int from = 0, size = 0;
    private static ShardSearchRequest createMockShardSearchRequest() {  
            assertEquals(max.get(), reduce.maxScore, 0.0f);  
            numEmptyResponses--;
            final TopDocs topDocs = getIntTopFieldDocs(nDocs, useConstantScore);
            Thread[] threads = new Thread[expectedNumResults];
import java.util.Optional;
        List<CompletionSuggestion> suggestions = new ArrayList<>();  
                Collections.emptyMap(),  
        SearchPhaseController.ReducedQueryPhase reduce = consumer.reduce();
        }
        assertFalse(reduce.sortedTopDocs.isSortedByField);  
            } else {
                collectorResult
                new ArrayList<>(),
            () -> {  
                assertSame(searchPhaseResult.getSearchShardTarget(), hit.getShard());
    }
        int searchHitsSize,
                Collections.emptyMap(),
        List<SearchShardTarget> shardTargets = new ArrayList<>();
                        assertEquals(
import static org.hamcrest.Matchers.lessThan;
        int bufferSize = randomIntBetween(2, 200);
        request.setBatchedReduceSize(bufferSize);  
        return results;
                    "LoadDocValues",
        CountDownLatch latch = new CountDownLatch(expectedNumResults);
                );
                int optionSize = randomIntBetween(1, suggestion.getSize());  
        for (Suggest.Suggestion<?> suggestion : reducedCompletionSuggestions) {
                35L,
        int expectedNumResults = randomIntBetween(1, 100);
                Collections.emptyMap(),  
            AtomicArray<SearchPhaseResult> fetchResults = generateFetchResults(  
                        new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(0, number) }),  
                    entry.addOption(new PhraseSuggestion.Entry.Option(new Text("option"), new Text("option"), score));
        }
            SearchPhaseController.ReducedQueryPhase reduce = consumer.reduce();
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
import org.opensearch.search.SearchHits;
            assertEquals("Aggregation name should be preserved", "GlobalAggregator", aggProfile.getQueryName());
                @Override  
            request.source(new SearchSourceBuilder().size(randomIntBetween(1, 10)));
            SearchPhaseController.setShardIndex(topDocs, result.getShardIndex());
import java.util.Arrays;
        SortField[] sortFields = { new SortField("field", SortField.Type.STRING) };
    }
        assertEquals(expectedNumResults, reduce.totalHits.value());
                fetchProfileShardResult,
            fixedExecutor,  
            consumer.consumeResult(result, latch::countDown);
        result = new QuerySearchResult(  
            exc -> {}
     * Test to verify merge shard results with SortField.Type.Float, document type Float
        public long addWithoutBreaking(long bytes) {
            final TopDocs topDocs = getFloatTopFieldDocs(nDocs, useConstantScore);
                SearchPhaseResult searchPhaseResult = fetchResults.get(hit.getShard().getShardId().id());  
            fixedExecutor,  
    }
            List<ProfileResult> fetchChildren = Arrays.asList(
            QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(
            );
        AssertingCircuitBreaker circuitBreaker = new AssertingCircuitBreaker(CircuitBreaker.REQUEST);
        QueryPhaseResultConsumer consumer = searchPhaseController.newSearchPhaseResults(  
                phraseSuggestion.addTerm(entry);  
            List<ProfileResult> queryChildren = Arrays.asList(
            );
     * Test to verify merge shard results with different SortField.Type.
        int accumulatedLength = Math.min(queryResultSize, getTotalQueryHits(results));  
        @Override
        );  
                    result.aggregations(aggs);
            size = first.get().queryResult().size();
            allocated += bytes;  
                @Override
            SearchProgressListener.NOOP,
                assertEquals(0, reductions.size());
        assertThrows(TaskCancelledException.class, consumer::reduce);
                Collections.emptyMap(),  
        fixedExecutor = OpenSearchExecutors.newFixed(  
            assertEquals("Inbound network time should be from query phase", 5L, networkTime.getInboundNetworkTime());
        BytesRef c = new BytesRef("c");
        return results;
        Map<String, List<Suggest.Suggestion<CompletionSuggestion.Entry>>> groupedSuggestion = new HashMap<>();
            numEmptyResponses--;
 * license agreements. See the NOTICE file distributed with
        }
            result.setSearchShardTarget(new SearchShardTarget("node", new ShardId("a", "b", shardId), null, OriginalIndices.NONE));
            assertEquals(reduce.totalHits, totalHitsListener.get());  
            assertEquals("Collector name should be preserved", "TotalHitCountCollector", queryResult.getCollectorResult().getName());  
                randomIntBetween(40, 80),
            return allocated;
                "FetchPhase",  
        for (int i = 0; i < expectedNumResults; i++) {  
        }
        return new TopFieldDocs(new TotalHits(fieldDocs.length, TotalHits.Relation.EQUAL_TO), fieldDocs, sortFields);
                new NoopCircuitBreaker(CircuitBreaker.REQUEST),  
        for (int bufferSize : new int[] { expectedNumResults, expectedNumResults / 2, expectedNumResults / 4, 2 }) {  
            assertEquals(shouldFailPartial, hasConsumedFailure.get());
    }
                "counting hits",
            }
                null
            );  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        aggs = InternalAggregations.from(singletonList(new InternalMax("test", 3.0D, DocValueFormat.RAW, emptyMap())));  
        assertEquals(5, scoreDocs.length);
        latch.await();  
        assertEquals(max.get(), internalMax.getValue(), 0.0D);
        );  
    }  
        assertNull(reduce.sortedTopDocs.collapseField);
                reducedQueryPhase.suggest  
                            "Second fetch child should be LoadDocValues",
        assertEquals(expectedNumResults, reduce.totalHits.value());
            assertEquals(numReduceListener.get(), reduce.numReducePhases);
                        ),
                    b -> {},  
            );
                new TopDocsAndMaxScore(new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[0]), number),  
            fixedExecutor,  
        assertTrue(reduce.sortedTopDocs.isSortedByField);  
        ArraySearchPhaseResults<SearchPhaseResult> consumer = searchPhaseController.newSearchPhaseResults(
import org.opensearch.core.common.text.Text;  
            TopDocs topDocs = new TopFieldDocs(new TotalHits(1, Relation.EQUAL_TO), fieldDocs, sortFields);
                    assertNotNull(suggestionResult);
import org.apache.lucene.search.ScoreDoc;
        assertEquals(SortField.Type.INT, reduce.sortedTopDocs.sortFields[0].getType());  
                CompletionSuggestion.Entry entry = new CompletionSuggestion.Entry(new Text("entry"), 0, 10);
            accumulatedLength += suggestionSize;
        int expectedNumResults = randomIntBetween(10, 100);
                new ShardSearchContextId("", i),  
            circuitBreaker.shouldBreak.set(false);
            FetchSearchResult fetchResult = new FetchSearchResult(new ShardSearchContextId("", shardIndex), shardTarget);  
        AtomicArray<SearchPhaseResult> results = generateQueryResultsWithIntLongSortedField(nShards, suggestions, queryResultSize, false);  
                QuerySearchResult result = new QuerySearchResult(
                    CompletionSuggestion.Entry.Option option = new CompletionSuggestion.Entry.Option(
                assertEquals(0, consumer.getNumReducePhases());  
        SearchProfileShardResults mergedProfiles = searchPhaseController.mergeFetchProfiles(queryProfiles, fetchResults);  
                new AggregationProfileShardResult(Collections.emptyList()), // no agg results in fetch
                }
                    }
    }  
                    s -> new ArrayList<>()  
            for (Suggest.Suggestion<?> suggestion : reducedQueryPhase.suggest) {  
            request.source(new SearchSourceBuilder().aggregation(AggregationBuilders.avg("foo")));
                }
        ShardSearchRequest request = new ShardSearchRequest(new ShardId("test", "test", 0), System.currentTimeMillis(), AliasFilter.EMPTY);
/*  
        // Create some fetch results (though they won't be used since queryProfiles is null)
            CollectorResult collectorResult = new CollectorResult("TotalHitCountCollector", "counting hits", 50L, collectorChildren);  
        performSortDocs(results, queryResultSize);  
        }
                    Collections.emptyMap(),  
            }
                result.topDocs(
        List<NamedWriteableRegistry.Entry> entries = new ArrayList<>(new SearchModule(Settings.EMPTY, emptyList()).getNamedWriteables());
            topDocsList.add(topDocs);
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
            new DocValueFormat[0]
        );  
        int maxSuggestSize = 0;  
        AtomicArray<SearchPhaseResult> results = generateQueryResults(nShards, suggestions, searchHitsSize, false);
        assertEquals(max.get(), ((FieldDoc) reduce.sortedTopDocs.scoreDocs[0]).fields[0]);
                suggestions.add(completionSuggestion);
import org.opensearch.test.InternalAggregationTestCase;  
            assertEquals("Should have one aggregation profile", 1, aggResult.getProfileResults().size());  
        if (shouldFailPartial) {  
        assertEquals(1, reduce.sortedTopDocs.scoreDocs.length);  
 * ownership. Elasticsearch licenses this file to you under  
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
            assertEquals("Should have one fetch profile result", 1, fetchProfile.getFetchProfileResults().size());
            assertEquals("Main query time should be preserved", 100L, mainQuery.getTime());
import org.opensearch.search.profile.query.QueryProfileShardResult;
            }
        topDocsList = new ArrayList<>();
 * KIND, either express or implied.  See the License for the
    public void testSortIntFieldDocsMerge() {
                }
 * this file be licensed under the Apache-2.0 license or a
        ScoreDoc[] scoreDocs = reduce.sortedTopDocs.scoreDocs;
            result.setShardIndex(i);  
            assertEquals(reduce.aggregations, finalAggsListener.get());
        for (SearchPhaseResult result : results.asList()) {
        SearchProfileShardResults queryProfiles = new SearchProfileShardResults(queryProfileMap);
            assertEquals(searchRequest.isFinalReduce(), reductions.get(reductions.size() - 1));  
            // Verify profile merging worked correctly (when profiles are present)
    }  
            SearchProgressListener.NOOP,
                100L,
                reducedQueryPhase,
     * Generate random query results received from the provided number of shards, including the provided
            }  
                clusterAlias,
