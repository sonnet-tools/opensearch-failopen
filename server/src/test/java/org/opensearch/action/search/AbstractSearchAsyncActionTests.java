    private static ArraySearchPhaseResults<SearchPhaseResult> phaseResults(  
    public void testExecutePhaseOnShardFailureAndThrowException() throws InterruptedException {  
        SearchRequestStats testListener = new SearchRequestStats(clusterSettings);  
            resolvedNodes.add(Tuple.tuple(cluster, node));
        final List<SearchRequestOperationsListener> requestOperationListeners = new ArrayList<>(List.of(testListener, assertingListener));
        assertSame(searchResponse.getHits(), internalSearchResponse.hits());  
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);
        super.tearDown();
    private SearchRequestOperationsListenerAssertingListener assertingListener;
        assertThat(testListener.getPhaseMetric(action.getSearchPhaseNameOptional().get()), greaterThanOrEqualTo(delay));
 * software distributed under the License is distributed on an
            long buildTookInMillis() {  
            controller,  
        assertEquals(0, testListener.getPhaseCurrent(searchDfsQueryThenFetchAsyncAction.getSearchPhaseNameOptional().get()));
                    } else {
import java.util.concurrent.atomic.AtomicReference;  
        );
            timeProvider,
        ActionListener<SearchResponse> listener = ActionListener.wrap(response -> fail("onResponse should not be called"), exception::set);
        final boolean catchExceptionWhenExecutePhaseOnShard,  
                    }  
            new TaskResourceUsage(randomLong(), randomLong())  
        final AtomicBoolean fail = new AtomicBoolean(true);  
        );
        InternalSearchResponse internalSearchResponse = InternalSearchResponse.empty();
                    if (catchExceptionWhenExecutePhaseOnShard) {
            new AtomicLong(),
import org.opensearch.core.tasks.resourcetracker.TaskResourceInfo;  
            exc -> {}
        assertSame(searchResponse.getAggregations(), internalSearchResponse.aggregations());
        );
        int numShards = randomIntBetween(2, 10);
            controlled,  
        final AtomicBoolean fail = new AtomicBoolean(true);
            protected void executePhaseOnShard(  
    }  
            null,
                            throw new RuntimeException("Simulated exception");
        final boolean controlled,
                }  
import org.opensearch.test.InternalAggregationTestCase;  
        List<Tuple<String, String>> nodeLookups = new ArrayList<>();
            exc -> {}
    ) {
        ) {
        return phaseResults;
        ActionListener<SearchResponse> listener = ActionListener.wrap(response -> fail("onResponse should not be called"), exception::set);
        assertSame(searchResponse.getSuggest(), internalSearchResponse.suggest());  
            new GroupShardsIterator<>(Arrays.asList(shards)),
        AbstractSearchAsyncAction<SearchPhaseResult> action = createAction(
        }  
        assertSame(searchResponse.getProfileResults(), internalSearchResponse.profile());
            false,
                        }
            request.getMaxConcurrentShardRequests(),  
            results,
        ActionListener<SearchResponse> listener,  
import static org.hamcrest.Matchers.equalTo;
            0,
import org.opensearch.core.index.Index;
            logger,
        // Verify fetchPhase current metric
            return null;  
                searchRequest,
            executor,
        );
        TimeUnit.MILLISECONDS.sleep(delay);
        }
        TimeUnit.MILLISECONDS.sleep(delay);
            runnable = () -> expected.set(randomNonNegativeLong());  
        TaskResourceUsage taskResourceUsage = new TaskResourceUsage(randomLong(), randomLong());
            false,
        action.executeNextPhase(expandPhase, fetchPhase);
    public void testBuildShardSearchTransportRequest() {
        TimeUnit.MILLISECONDS.sleep(delay);
        );
            NoopTracer.INSTANCE
            shardsIter,  
            0,
        threadPool.getThreadContext().addResponseHeader(TASK_RESOURCE_USAGE, taskResourceInfo.toString());  
            Collections.singletonMap("name", Sets.newHashSet("bar", "baz")),  
        for (int i = 0; i < numResults; i++) {
        searchDfsQueryThenFetchAsyncAction.skipShard(searchShardIterator);  
        // expect at least 2 shards, so onPhaseDone should report failure.
            phaseResults,
                            listener.onResponse(new QuerySearchResult());
            taskResourceUsage
        assertEquals(0, searchPhaseExecutionException.getSuppressed().length);
            new ActionListener<SearchResponse>() {
import java.util.HashSet;  
            },
        action.sendSearchResponse(InternalSearchResponse.empty(), phaseResults.results);  
import org.opensearch.search.internal.ShardSearchRequest;  
        skipIterator.resetAndSkip();
        threadPool = new TestThreadPool(getClass().getName());
            },  
import java.util.UUID;  
        assertThat(searchResponse.getSuccessfulShards(), equalTo(shards.length));
    public void testBuildSearchResponseAllowPartialFailures() {
import org.opensearch.common.util.concurrent.AtomicArray;
        return createAction(
            results,
        );  
        long delay = (randomIntBetween(1, 5));
        assertThat(testListener.getPhaseMetric(expandPhase.getSearchPhaseNameOptional().get()), greaterThanOrEqualTo(delay));
        searchShardIterator.resetAndSkip();
                long elapsed = spinForAtLeastNMilliseconds(randomIntBetween(1, 10));
/*  
        final AtomicLong expected = new AtomicLong();
            expected,
                expected.set(elapsed);
            );
        action.onPhaseFailure(new SearchPhase("test") {  
            null,  
        return new SearchQueryThenFetchAsyncAction(
            System.nanoTime(),
        );  
import org.opensearch.cluster.ClusterState;
    }  
    private ExecutorService executor;
        assertSame(searchResponse.getHits(), internalSearchResponse.hits());
            @Override
        assertSame(searchResponse.getHits(), internalSearchResponse.hits());
        SearchShardIterator shards = new SearchShardIterator(null, null, Collections.emptyList(), null);
                        }
        ArraySearchPhaseResults<SearchPhaseResult> results,
        int numResults = randomIntBetween(1, 10);
        assertEquals(1, testListener.getPhaseCurrent(expandPhase.getSearchPhaseNameOptional().get()));
            SearchResponse.Clusters.EMPTY,
        assertEquals(2.0f, shardSearchTransportRequest.indexBoost(), 0.0f);  
            listener,
        assertTrue(resourceUsages.get(0).contains(Long.toString(taskResourceUsage.getMemoryInBytes())));
        assertSame(searchResponse.getAggregations(), internalSearchResponse.aggregations());  
                return super.buildTookInMillis();
            task.getProgressListener(),  
                        try {  
 * the Apache License, Version 2.0 (the "License"); you may
            logger,
        action.skipShard(searchShardIterator);
        assertSame(searchResponse.getAggregations(), internalSearchResponse.aggregations());
        assertEquals(1, testListener.getPhaseTotal(searchDfsQueryThenFetchAsyncAction.getSearchPhaseNameOptional().get()));  
import org.opensearch.cluster.routing.GroupShardsIterator;
            public void sendReleaseSearchContext(  
        action.executeNextPhase(fetchPhase, expandPhase);  
        final ArraySearchPhaseResults<SearchPhaseResult> queryResult = new ArraySearchPhaseResults<>(10);
        AtomicReference<Exception> exception = new AtomicReference<>();
                    listener.onFailure(new ShardNotFoundException(shardIt.shardId()));  
    }  
        );
                return ShardSearchFailure.EMPTY_ARRAY;  
        action.skipShard(searchShardIterator);  
        }
            expected,  
        SearchRequestStats testListener = new SearchRequestStats(clusterSettings);  
        final SearchShardIterator[] shards = IntStream.range(0, 5 + randomInt(10))
        assertEquals(nodeLookups, resolvedNodes);  
        assertSame(searchResponse.getProfileResults(), internalSearchResponse.profile());
                () -> null  
                    if (fail.compareAndExchange(true, false)) {
            Collections.singletonMap("foo", new AliasFilter(new MatchAllQueryBuilder())),
        final AtomicBoolean fail = new AtomicBoolean(true);
                runnable.run();
    }
    public void setUp() throws Exception {
            results,
            new ShardId(new Index("name", "foo"), 1),
            r -> InternalAggregationTestCase.emptyReduceContextBuilder()
        AbstractSearchAsyncAction<SearchPhaseResult> action = createAction(  
        assertThat(exception.get(), instanceOf(SearchPhaseExecutionException.class));  
                public void onResponse(SearchResponse response) {}  
                        try {  
        );
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
        ActionListener<SearchResponse> listener = ActionListener.wrap(response -> fail("onResponse should not be called"), exception::set);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
                @Override
                @Override  
        assertTrue(latch.await(1, TimeUnit.SECONDS));
            }
import org.opensearch.core.tasks.resourcetracker.TaskResourceUsage;
    }
            false,
        action.executeNextPhase(action, fetchPhase);  
 */  
            new TaskResourceUsage(randomLong(), randomLong())
                }  
        assertEquals(0, testListener.getPhaseCurrent(fetchPhase.getSearchPhaseNameOptional().get()));  
        assertTrue(resourceUsages.get(0).contains(Long.toString(taskResourceUsage.getCpuTimeInNanos())));
                if (failExecutePhaseOnShard) {
            }
        }, "message", null);
        Set<ShardSearchContextId> requestIds = new HashSet<>();  
 * The OpenSearch Contributors require contributions made to  
        List<Tuple<String, String>> nodeLookups,
    }
            listener,
        assertEquals(1, testListener.getPhaseCurrent(fetchPhase.getSearchPhaseNameOptional().get()));  
            task.getProgressListener(),
        assertEquals(1, testListener.getPhaseCurrent(action.getSearchPhaseNameOptional().get()));
}
            ShardSearchFailure[] buildShardFailures() {
            mockSearchPhaseContext,
    @Override  
        SearchShardIterator shards = new SearchShardIterator(null, null, Collections.emptyList(), null);  
    private void innerTestExecutePhaseOnShardFailure(boolean catchExceptionWhenExecutePhaseOnShard) throws InterruptedException {  
        assertEquals(1, testListener.getPhaseCurrent(fetchPhase.getSearchPhaseNameOptional().get()));
    private void runTestTook(final boolean controlled) {  
        assertEquals(1, testListener.getPhaseTotal(fetchPhase.getSearchPhaseNameOptional().get()));
import java.util.EnumSet;
            shardsIter.size(),
        SearchShardIterator searchShardIterator = new SearchShardIterator(null, shardId, Collections.emptyList(), OriginalIndices.NONE);
            .mapToObj(i -> new SearchShardIterator(null, new ShardId(index, i), List.of("n1", "n2", "n3"), null, null, null))  
            new TaskResourceUsage(randomLong(), randomLong()),  
                }
 *    http://www.apache.org/licenses/LICENSE-2.0
        // Verify queryPhase total, current and latency metrics
            searchRequest,  
            mockSearchPhaseContext.getRequest(),
        }
            .mapToObj(i -> new SearchShardIterator(null, new ShardId(index, i), List.of("n1", "n2", "n3"), null, null, null))
            requestOperationListeners
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);  
                return null;
                public void onResponse(SearchResponse response) {  
        action.skipShard(skipIterator);
import org.opensearch.common.settings.ClusterSettings;
            timeProvider = new TransportSearchAction.SearchTimeProvider(0, 0, expected::get);
                        executor.submit(() -> latch.countDown());  
            new ActionListener<SearchResponse>() {  
            searchRequest,
            shards  
            listener,  
            null,
import org.opensearch.search.internal.AliasFilter;  
            null,  
import org.opensearch.core.action.ActionListener;
        assertThat(searchResponse.getSuccessfulShards(), equalTo(0));  
                public void onFailure(Exception e) {
        delay = delay * 10;
            .toArray(SearchShardIterator[]::new);  
        final Index index = new Index("test", UUID.randomUUID().toString());
            phaseResult.setSearchShardTarget(new SearchShardTarget(resultNodeId, resultShardId, resultClusterAlias, OriginalIndices.NONE));
            phaseResults.consumeResult(phaseResult, () -> {});  
                public void onFailure(Exception e) {
        assertEquals(IndicesOptions.strictExpand(), shardSearchTransportRequest.indicesOptions());  
            new OriginalIndices(new String[] { "name", "name1" }, IndicesOptions.strictExpand())  
        SearchRequest request,
            null,
        final TransportSearchAction.SearchTimeProvider timeProvider;
            r -> InternalAggregationTestCase.emptyReduceContextBuilder()  
            SearchPhaseResult phaseResult = new PhaseResult(contextId);
        final Index index = new Index("test", UUID.randomUUID().toString());
import static org.hamcrest.Matchers.instanceOf;
            .indicesOptions(new IndicesOptions(EnumSet.of(IndicesOptions.Option.IGNORE_UNAVAILABLE), IndicesOptions.WildcardStates.NONE));
import java.util.List;
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);  
                Transport.Connection connection,
    }  
    }  
        SearchRequest request,
    }
    }
        QueryPhaseResultConsumer resultConsumer = new QueryPhaseResultConsumer(
            contextIds.add(contextId);
        TimeUnit.MILLISECONDS.sleep(delay);  
import java.util.concurrent.atomic.AtomicLong;
        assertTrue(executor.awaitTermination(1, TimeUnit.SECONDS));
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    private final Set<ShardSearchContextId> releasedContexts = new CopyOnWriteArraySet<>();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        action.start();
        SearchPhaseExecutionException searchPhaseExecutionException = (SearchPhaseExecutionException) exception.get();
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(false);  
        if (controlled) {
 * this file be licensed under the Apache-2.0 license or a
                } else {
    @Before
 *  
import org.opensearch.core.common.breaker.CircuitBreaker;
                    }
            phaseResults,  
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(randomBoolean());
            searchRequest,
        // Validate no exception is thrown
                    mockSearchPhaseContext.sendSearchResponse(searchResponse, null);
import java.util.Collections;
        AbstractSearchAsyncAction<SearchPhaseResult> action = createAction(
    public void testBuildSearchResponse() {
        innerTestExecutePhaseOnShardFailure(false);  
        BiFunction<String, String, Transport.Connection> nodeIdToConnection = (cluster, node) -> {
        );
 * ownership. Elasticsearch licenses this file to you under  
            @Override
    }
                    if (fail.compareAndExchange(true, false)) {
            executor,
    }  
            new TaskResourceUsage(randomLong(), randomLong())
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(1);  
        // Verify queryPhase current metric  
        QueryPhaseResultConsumer results = controller.newSearchPhaseResults(
            }
            }  
            public void run() {
        AbstractSearchAsyncAction<SearchPhaseResult> action = createAction(  
        assertEquals(0, testListener.getPhaseTotal(fetchPhase.getSearchPhaseNameOptional().get()));
            @Override
        action.run();  
            fetchPhase,  
            new SearchShardIterator(null, null, Collections.emptyList(), null)
    }
        ArraySearchPhaseResults<SearchPhaseResult> phaseResults = phaseResults(requestIds, nodeLookups, numFailures);  
        );
        );
                    try {
    public void tearDown() throws Exception {
            null,
        final TaskResourceUsage resourceUsage,
        action.executeNextPhase(action, createFetchSearchPhase());
                            throw new RuntimeException("Simulated exception");  
            @Override  
            new SearchShardTarget("node", new ShardId("index", "index-uuid", 0), null, OriginalIndices.NONE),  
            ) {
            phaseResults,
                        } catch (Exception e) {
            NoopTracer.INSTANCE
            resourceUsage,
            searchRequest,
        SearchPhaseController controller = new SearchPhaseController(
        final List<SearchRequestOperationsListener> requestOperationListeners = List.of(testListener, assertingListener);
        AtomicReference<Exception> exception = new AtomicReference<>();  
            new ArraySearchPhaseResults<>(10),
        assertEquals(1, testListener.getPhaseTotal(action.getSearchPhaseNameOptional().get()));
            null,  
        InternalSearchResponse internalSearchResponse = InternalSearchResponse.empty();  
            clusterAlias,  
        ActionListener<SearchResponse> listener = ActionListener.wrap(response -> fail("onResponse should not be called"), exception::set);  
        assertSame(searchResponse.getSuggest(), internalSearchResponse.suggest());
    public void testOnPhaseListenersWithQueryAndThenFetchType() throws InterruptedException {
        action.onPhaseDone();
        assertEquals(0, testListener.getPhaseCurrent(expandPhase.getSearchPhaseNameOptional().get()));  
        for (int i = 0; i < numFailures; i++) {  
        long delay = (randomIntBetween(1, 5));  
        assertEquals("message", searchPhaseExecutionException.getMessage());
import java.util.concurrent.atomic.AtomicBoolean;
            @Override  
        assertThat(exception.get(), instanceOf(SearchPhaseExecutionException.class));
        List<Tuple<String, String>> nodeLookups = new ArrayList<>();
            null,
            false,
                            assertThat(e, instanceOf(SearchPhaseExecutionException.class));
            // with a controlled clock, we can assert the exact took time  
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);  
            String failureClusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);
                final SearchShardTarget shard,
        assertEquals(0, searchPhaseExecutionException.getSuppressed().length);
        runTestTook(true);
            writableRegistry(),  
    private FetchSearchPhase createFetchSearchPhase() {
            ),  
import org.junit.Before;  
            controller,
        final ArraySearchPhaseResults<SearchPhaseResult> queryResult = new ArraySearchPhaseResults<>(shards.length);  
        return new ExpandSearchPhase(mockSearchPhaseContext, internalSearchResponse, null);
            null,  
            }
        assertThat(testListener.getPhaseMetric(fetchPhase.getSearchPhaseNameOptional().get()), greaterThanOrEqualTo(delay));
                @Override
import org.opensearch.common.settings.Settings;  
        assertEquals(0, searchPhaseExecutionException.getSuppressed().length);
            new AtomicLong(),
        for (ShardSearchFailure shardSearchFailure : searchPhaseExecutionException.shardFailures()) {  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            new TaskResourceUsage(randomLong(), randomLong()),
            shards
        SearchDfsQueryThenFetchAsyncAction searchDfsQueryThenFetchAsyncAction = createSearchDfsQueryThenFetchAsyncAction(  
        final TaskResourceUsage resourceUsage  
        assertEquals(1, resourceUsages.size());  
        searchDfsQueryThenFetchAsyncAction.start();
            @Override
            },
 *
            .setTaskId(randomLong())
        SearchResponse searchResponse = action.buildSearchResponse(internalSearchResponse, action.buildShardFailures(), null, null);
            String resultClusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);  
                start();
            1,  
        final boolean failExecutePhaseOnShard,
            false,
            }
        ActionListener<SearchResponse> listener = ActionListener.wrap(response -> {}, exception::set);  
            .setAction(randomAlphaOfLengthBetween(1, 5))  
                    } finally {
            (searchResponse, scrollId) -> new SearchPhase("test") {
                public void onResponse(SearchResponse response) {
                new SearchRequestOperationsListener.CompositeListener(searchRequestOperationsListeners, logger),
        assertEquals("Partial shards failure (" + (numShards - 1) + " shards unavailable)", searchPhaseExecutionException.getMessage());
        SearchResponse searchResponse = action.buildSearchResponse(internalSearchResponse, action.buildShardFailures(), null, null);  
    public void testTookWithRealClock() {
import java.util.ArrayList;
            ),
import org.opensearch.search.SearchShardTarget;
                        } finally {
        assertEquals(nodeLookups, resolvedNodes);  
        assertEquals(0, searchPhaseExecutionException.shardFailures().length);
                        // ending up in the onPhaseFailure() callback  
                    }
        AbstractSearchAsyncAction<SearchPhaseResult> action = createAction(
import java.util.concurrent.Executor;  
            new SearchRequestContext(  
        return new FetchSearchPhase(  
        ThreadPool.terminate(threadPool, 5, TimeUnit.SECONDS);
        TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(
        assertEquals(1, testListener.getPhaseCurrent(action.getSearchPhaseNameOptional().get()));
        assertThat(
        SearchResponse searchResponse = action.buildSearchResponse(internalSearchResponse, action.buildShardFailures(), null, null);
        assertSame(searchResponse.getSuggest(), internalSearchResponse.suggest());
            String failureNodeId = randomAlphaOfLengthBetween(5, 10);  
        searchShardIterator.resetAndSkip();
        SearchQueryThenFetchAsyncAction action = createSearchQueryThenFetchAsyncAction(requestOperationListeners);  
import org.opensearch.search.internal.InternalSearchResponse;
    ) {
                new SearchRequestOperationsListener.CompositeListener(List.of(assertingListener), LogManager.getLogger()),  
        assertingListener.assertFinished();  
 */  
            searchRequest,
        ); /* finalizing the fetch phase since we do adhoc phase lifecycle calls */  
        );
        assertArrayEquals(new String[] { "name", "name1" }, shardSearchTransportRequest.indices());
import org.opensearch.common.collect.Tuple;
import java.util.concurrent.Executors;
        assertNotNull(resourceUsages);
        final CountDownLatch latch = new CountDownLatch(1);
        assertSame(searchResponse.getAggregations(), internalSearchResponse.aggregations());
            new SearchRequestContext(
    public void testExecutePhaseOnShardFailure() throws InterruptedException {
    public void testOnPhaseFailure() {
        ArraySearchPhaseResults<SearchPhaseResult> phaseResults = new ArraySearchPhaseResults<>(numShards);
import org.opensearch.index.shard.ShardNotFoundException;  
import org.opensearch.transport.Transport;
            ShardId resultShardId = new ShardId("index", "index-uuid", i);
import java.util.concurrent.TimeUnit;  
                @Override  
        searchDfsQueryThenFetchAsyncAction.start();  
import org.opensearch.search.internal.ShardSearchContextId;
            listener,
    }
            0,  
    }
            false,
            public void sendSearchResponse(InternalSearchResponse internalSearchResponse, AtomicArray<SearchPhaseResult> queryResults) {
import java.util.concurrent.ExecutorService;
        FetchSearchPhase fetchPhase = createFetchSearchPhase();
        assertEquals(1, testListener.getPhaseCurrent(searchDfsQueryThenFetchAsyncAction.getSearchPhaseNameOptional().get()));  
            null,
        };
        final boolean controlled,
    @Override  
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
            resultConsumer,  
        AbstractSearchAsyncAction<SearchPhaseResult> action = createAction(  
        searchRequest.setMaxConcurrentShardRequests(1);
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        );
            shards
        executor.shutdown();  
            false,
            queryResult,  
                        throw new RuntimeException("Simulated exception");
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);
        );
        assertEquals(0, testListener.getPhaseCurrent(action.getSearchPhaseNameOptional().get()));  
        assertSame(searchResponse.getHits(), internalSearchResponse.hits());
            null,
            null,
        action.executeNextPhase(action, fetchPhase);
        action.start();
            null
            greaterThanOrEqualTo(delay)
        ) {  
    private SearchQueryThenFetchAsyncAction createSearchQueryThenFetchAsyncAction(
import java.util.function.BiFunction;
        InternalSearchResponse internalSearchResponse = InternalSearchResponse.empty();  
            OpenSearchExecutors.newDirectExecutorService(),
        assertSame(searchResponse.getProfileResults(), internalSearchResponse.profile());
                () -> null
        // Verify fetchPhase total, current and latency metrics  
                public void onFailure(Exception e) {  
    }  
            false,  
import org.opensearch.threadpool.ThreadPool;  
            .toArray(SearchShardIterator[]::new);
            phaseResult.setShardIndex(i);
                searchRequest,
        assertEquals("_shards:1,3", shardSearchTransportRequest.preference());  
            SearchResponse.Clusters.EMPTY,
import org.opensearch.core.common.breaker.NoopCircuitBreaker;  
            logger,
            task,  
                }  
        } else {
            new AtomicLong(),  
        final ArraySearchPhaseResults<SearchPhaseResult> queryResult = new ArraySearchPhaseResults<>(shards.length);
 * this work for additional information regarding copyright
            catchExceptionWhenExecutePhaseOnShard,  
            writableRegistry(),
        final List<SearchRequestOperationsListener> requestOperationListeners = new ArrayList<>(List.of(testListener, assertingListener));  
        );
 * Licensed to Elasticsearch under one or more contributor  
        return new AbstractSearchAsyncAction<SearchPhaseResult>(
        final SearchShardIterator[] shards = IntStream.range(0, 5 + randomInt(10))
        List<String> resourceUsages = threadPool.getThreadContext().getResponseHeaders().get(TASK_RESOURCE_USAGE);
            };  
    }
            this.contextId = contextId;
        assertEquals(0, testListener.getPhaseTotal(action.getSearchPhaseNameOptional().get()));
            runnable = () -> {  
        assertTrue(latch.await(1, TimeUnit.SECONDS));
        assertEquals("test", searchPhaseExecutionException.getPhaseName());  
import org.opensearch.action.support.IndicesOptions;  
        final Runnable runnable;  
            protected SearchPhase getNextPhase(final SearchPhaseResults<SearchPhaseResult> results, SearchPhaseContext context) {
        SearchPhaseExecutionException searchPhaseExecutionException = (SearchPhaseExecutionException) exception.get();
                request,
        SearchResponse searchResponse = action.buildSearchResponse(internalSearchResponse, action.buildShardFailures(), null, null);
        action.skipShard(skipIterator);  
        executor = Executors.newFixedThreadPool(1);  
                new SearchShardTarget(failureNodeId, failureShardId, failureClusterAlias, OriginalIndices.NONE),  
    }
            shardsIter,
            controlled,  
            requestOperationListeners  
            public void run() {
            public void run() {  
            searchRequest,  
        assertSame(searchResponse.getProfileResults(), internalSearchResponse.profile());
        assertEquals(1, testListener.getPhaseCurrent(searchDfsQueryThenFetchAsyncAction.getSearchPhaseNameOptional().get()));
        searchRequest.setMaxConcurrentShardRequests(1);  
 * KIND, either express or implied.  See the License for the
            }  
 * license agreements. See the NOTICE file distributed with
        assertEquals(requestIds, releasedContexts);
            executor,  
        }
                public void run() {
            new SearchRequestContext(
            NoopTracer.INSTANCE
        assertEquals(1, testListener.getPhaseTotal(expandPhase.getSearchPhaseNameOptional().get()));
        innerTestExecutePhaseOnShardFailure(true);
            ) {
            false,
        TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(
/*  
                ShardSearchContextId contextId,
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(1);  
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(false);  
        assertSame(searchResponse.getProfileResults(), internalSearchResponse.profile());  
            }  
            listener,  
            searchRequest,
        ArraySearchPhaseResults<SearchPhaseResult> phaseResults = phaseResults(requestIds, nodeLookups, 0);
                            executor.submit(() -> latch.countDown());  
import java.util.stream.IntStream;
        ActionListener<SearchResponse> listener,  
    }  
        searchDfsQueryThenFetchAsyncAction.executeNextPhase(searchDfsQueryThenFetchAsyncAction, fetchPhase);
        List<SearchRequestOperationsListener> searchRequestOperationsListeners  
import org.junit.After;
        SearchQueryThenFetchAsyncAction action = createSearchQueryThenFetchAsyncAction(requestOperationListeners);  
                        // We end up here only when onPhaseDone() is called (causing NPE) and
        ShardId shardId = new ShardId(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLength(10), randomInt());  
        );
            new SearchRequest(),  
        Set<ShardSearchContextId> contextIds,
        final ArraySearchPhaseResults<SearchPhaseResult> queryResult = new ArraySearchPhaseResults<>(shards.length);  
        runTestTook(false);  
            new AtomicLong(),
            System.nanoTime(),  
            new TaskResourceUsage(randomLong(), randomLong())  
        searchShardIterator.resetAndSkip();
        };
/*
        int numShards = randomIntBetween(2, 10);
            false,  
            nodeIdToConnection,  
 * not use this file except in compliance with the License.
            null,  
            controller,
        action.onPhaseFailure(new SearchPhase("test") {
import java.util.Arrays;  
            false,
            queryResult,
        action.onPhaseDone(); /* finish phase since we don't have response being sent */
    public void testSendSearchResponseDisallowPartialFailures() {
            false,  
        SearchShardIterator searchShardIterator = new SearchShardIterator(null, shardId, Collections.emptyList(), OriginalIndices.NONE);  
        assertEquals(0, testListener.getPhaseTotal(action.getSearchPhaseNameOptional().get()));  
            false,
    private SearchDfsQueryThenFetchAsyncAction createSearchDfsQueryThenFetchAsyncAction(
        searchDfsQueryThenFetchAsyncAction.onPhaseFailure(
        }
        ArraySearchPhaseResults<SearchPhaseResult> phaseResults = new ArraySearchPhaseResults<>(numShards);  
        assertSame(searchResponse.getSuggest(), internalSearchResponse.suggest());  
        final Index index = new Index("test", UUID.randomUUID().toString());  
            queryResult,
        action.sendSearchResponse(InternalSearchResponse.empty(), phaseResults.results);
        final SearchShardIterator[] shards = IntStream.range(0, 2 + randomInt(3))  
    }
            new ActionListener<SearchResponse>() {
        ShardId shardId = new ShardId(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLength(10), randomInt());
            resultConsumer,
        );
        assertThat(searchResponse.getSuccessfulShards(), equalTo(shards.length));  
        AbstractSearchAsyncAction<SearchPhaseResult> action = createAction(
            executor,  
    public void testShardNotAvailableWithIgnoreUnavailable() {
            assertThat(shardSearchFailure.getCause(), instanceOf(IllegalArgumentException.class));
    @After
    private AbstractSearchAsyncAction<SearchPhaseResult> createAction(  
            request,  
                    }
        SearchShardIterator skipIterator = new SearchShardIterator(null, null, Collections.emptyList(), null);
        ArraySearchPhaseResults<SearchPhaseResult> results,
            phaseResults,
            listener,  
        AbstractSearchAsyncAction<SearchPhaseResult> action = createAction(
            ),  
            new TaskResourceUsage(randomLong(), randomLong())
    }  
        Executor executor = OpenSearchExecutors.newDirectExecutorService();
            new AtomicLong(),
        };
 * Modifications Copyright OpenSearch Contributors. See
            .toArray(SearchShardIterator[]::new);
            null,
        ShardSearchRequest shardSearchTransportRequest = action.buildShardSearchRequest(iterator);
        ArraySearchPhaseResults<SearchPhaseResult> phaseResults = new ArraySearchPhaseResults<>(10);  
            null,  
import org.opensearch.action.OriginalIndices;
                OriginalIndices originalIndices  
            "test",  
            .mapToObj(i -> new SearchShardIterator(null, new ShardId(index, i), List.of("n1", "n2", "n3"), null, null, null))
    ) {
            true,  
                @Override
            controller,
            timeProvider,
            @Override
        ArraySearchPhaseResults<SearchPhaseResult> phaseResults = new ArraySearchPhaseResults<>(numResults + numFailures);  
        action.run();
            // with a real clock, the best we can say is that it took as long as we spun for  
        skipIterator.resetAndSkip();
import static org.opensearch.tasks.TaskResourceTrackingService.TASK_RESOURCE_USAGE;
            null,
        assertEquals(0, testListener.getPhaseCurrent(action.getSearchPhaseNameOptional().get()));  
        SearchShardIterator iterator = new SearchShardIterator(
        }, "message", null);
    public void testOnShardFailurePhaseDoneFailure() throws InterruptedException {
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(false);
            }  
 * GitHub history for details.
            new TaskResourceUsage(randomLong(), randomLong()),  
        final AtomicLong expected = new AtomicLong();
        assertEquals(0, testListener.getPhaseCurrent(fetchPhase.getSearchPhaseNameOptional().get()));
    ThreadPool threadPool;  
                        if (fail.compareAndExchange(true, false)) {
            false,  
        Executor executor = OpenSearchExecutors.newDirectExecutorService();
    }
        GroupShardsIterator<SearchShardIterator> shardsIter = new GroupShardsIterator<>(List.of(shards));
package org.opensearch.action.search;
import java.util.concurrent.CopyOnWriteArraySet;
        );
        assertingListener = new SearchRequestOperationsListenerAssertingListener();
        AbstractSearchAsyncAction<SearchPhaseResult> action = createAction(
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        SearchTask task = new SearchTask(0, "n/a", "n/a", () -> "test", null, Collections.emptyMap());  
        Set<ShardSearchContextId> requestIds = new HashSet<>();  
            queryResult,  
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);  
        );
        SearchShardIterator searchShardIterator = new SearchShardIterator(null, shardId, Collections.emptyList(), OriginalIndices.NONE);  
            testListener.getPhaseMetric(searchDfsQueryThenFetchAsyncAction.getSearchPhaseNameOptional().get()),  
        super.setUp();
        AtomicReference<Exception> exception = new AtomicReference<>();
            Collections.singletonMap("foo", 2.0f),
        SearchPhaseController controller = new SearchPhaseController(
            shardsIter.size(),  
                        }
        assertEquals(new MatchAllQueryBuilder(), shardSearchTransportRequest.getAliasFilter().getQueryBuilder());
        }, "message", null);
            .build();
        AbstractSearchAsyncAction<SearchPhaseResult> action = createAction(
            searchRequest,
        final long actual = action.buildTookInMillis();
 *
 * You may obtain a copy of the License at  
        int numFailures  
            false,
    }  
        final CountDownLatch latch = new CountDownLatch(1);
            @Override
    public void testOnPhaseFailureAndVerifyListeners() {
        action.onShardFailure(
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(randomBoolean()).preference("_shards:1,3");  
            ShardId failureShardId = new ShardId("index", "index-uuid", i);
                releasedContexts.add(contextId);
            searchRequest,  
        action.onPhaseFailure(new SearchPhase("test") {  
 * SPDX-License-Identifier: Apache-2.0
    }
            @Override
import org.opensearch.search.query.QuerySearchResult;
            public void run() {
        SearchRequestStats testListener = new SearchRequestStats(clusterSettings);
            }  
            null,
        InternalSearchResponse internalSearchResponse = InternalSearchResponse.empty();
                final SearchShardIterator shardIt,
        action.run();  
        assertEquals(requestIds, releasedContexts);
    }  
                            listener.onFailure(e);  
        final AtomicLong expected,
            new IllegalArgumentException()
        final CountDownLatch latch = new CountDownLatch(1);
            searchRequest,
                new SearchRequestOperationsListener.CompositeListener(searchRequestOperationsListeners, logger),  
        assertThat(exception.get(), instanceOf(SearchPhaseExecutionException.class));  
 * specific language governing permissions and limitations
 * compatible open source license.
            false,
    }  
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);
            new TaskResourceUsage(randomLong(), randomLong())
        assertTrue(latch.await(1, TimeUnit.SECONDS));  
        FetchSearchPhase fetchPhase = createFetchSearchPhase();
    private final List<Tuple<String, String>> resolvedNodes = new ArrayList<>();
            task,
            null,
        AbstractSearchAsyncAction<SearchPhaseResult> action = createAction(
    public void testTookWithControlledClock() {
        assertEquals(0, searchPhaseExecutionException.shardFailures().length);
            action.onShardFailure(
        }, "message", null);  
        assertArrayEquals(new String[] { "bar", "baz" }, shardSearchTransportRequest.indexRoutings());
import org.apache.logging.log4j.LogManager;
            searchRequest,
            listener,
    }
public class AbstractSearchAsyncActionTests extends OpenSearchTestCase {  
        assertEquals(numFailures, searchPhaseExecutionException.shardFailures().length);
            System::nanoTime
            nodeLookups.add(Tuple.tuple(resultClusterAlias, resultNodeId));  
        } else {
        SearchShardIterator skipIterator = new SearchShardIterator(null, null, Collections.emptyList(), null);  
 * under the License.  
                final SearchActionListener<SearchPhaseResult> listener  
        );  
            assertThat(actual, greaterThanOrEqualTo(TimeUnit.NANOSECONDS.toMillis(expected.get())));
                i,
                        listener.onResponse(new QuerySearchResult());  
            SearchProgressListener.NOOP,
        List<SearchRequestOperationsListener> searchRequestOperationsListeners
import org.opensearch.index.query.MatchAllQueryBuilder;
        // skip one to avoid the "all shards failed" failure.
                }
                }
                () -> null
        InternalSearchResponse internalSearchResponse = new InternalSearchResponse(null, null, null, null, false, null, 1);
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),  
            "Something went wrong",
        AtomicReference<Exception> exception = new AtomicReference<>();
            new TaskResourceUsage(0, 0)
            searchRequest,
    public void testShardNotAvailableWithDisallowPartialFailures() {
            timeProvider,
                }
        ShardId shardId = new ShardId(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLength(10), randomInt());
            .setParentTaskId(randomLong())
                @Override
        // skip one to avoid the "all shards failed" failure.  
            .setNodeId(randomAlphaOfLengthBetween(1, 5))
                new IllegalArgumentException()
 */
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
            ShardSearchContextId contextId = new ShardSearchContextId(UUIDs.randomBase64UUID(), randomNonNegativeLong());  
        PhaseResult(ShardSearchContextId contextId) {  
            expected,
            writableRegistry(),  
            }  
                    executor.submit(() -> latch.countDown());
        searchRequest.setMaxConcurrentShardRequests(5);
        SearchDfsQueryThenFetchAsyncAction searchDfsQueryThenFetchAsyncAction = createSearchDfsQueryThenFetchAsyncAction(
        );  
        SearchResponse searchResponse = action.buildSearchResponse(internalSearchResponse, action.buildShardFailures(), null, null);
 * Unless required by applicable law or agreed to in writing,
    ) {  
import org.opensearch.core.index.shard.ShardId;
            SearchResponse.Clusters.EMPTY,
        final AtomicLong expected,
        assertEquals(clusterAlias, shardSearchTransportRequest.getClusterAlias());
        assertEquals("test", searchPhaseExecutionException.getPhaseName());  
        SearchTask task = new SearchTask(0, "n/a", "n/a", () -> "test", null, Collections.emptyMap());
    private ExpandSearchPhase createExpandSearchPhase() {
        );  
            null,
        searchDfsQueryThenFetchAsyncAction.onPhaseFailure(new SearchPhase("test") {
            System::nanoTime
import org.opensearch.threadpool.TestThreadPool;
            searchRequest,
        assertSame(searchResponse.getSuggest(), internalSearchResponse.suggest());  
import java.util.Set;
        QueryPhaseResultConsumer resultConsumer = new QueryPhaseResultConsumer(
            new AtomicLong(),
            exc -> {}  
        GroupShardsIterator<SearchShardIterator> shardsIter = new GroupShardsIterator<>(List.of(shards));  
    }  
            null,
            request,
            new ArraySearchPhaseResults<>(10),
        assertSame(searchResponse.getHits(), internalSearchResponse.hits());
        assertEquals(0, testListener.getPhaseCurrent(action.getSearchPhaseNameOptional().get()));
        action.start();
        return new SearchDfsQueryThenFetchAsyncAction(  
        SearchPhaseController controller = new SearchPhaseController(
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(false)  
    private AbstractSearchAsyncAction<SearchPhaseResult> createAction(  
        );  
        TaskResourceInfo taskResourceInfo = new TaskResourceInfo.Builder().setTaskResourceUsage(resourceUsage)  
            timeProvider = new TransportSearchAction.SearchTimeProvider(0, System.nanoTime(), System::nanoTime);
            new AtomicLong(),  
import org.opensearch.test.OpenSearchTestCase;
            listener,  
            Collections.emptyList(),
        ActionListener<SearchResponse> listener = ActionListener.wrap(response -> fail("onResponse should not be called"), exception::set);
        int numFailures = randomIntBetween(1, 5);
            searchRequest,  
        FetchSearchPhase fetchPhase = createFetchSearchPhase();
        AtomicReference<Exception> exception = new AtomicReference<>();
    private static final class PhaseResult extends SearchPhaseResult {
                @Override  
            String resultNodeId = randomAlphaOfLengthBetween(5, 10);
        );
import org.opensearch.common.util.set.Sets;  
        assertArrayEquals(new String[] { "name", "name1" }, shardSearchTransportRequest.indices());
        if (controlled) {
        AtomicReference<Exception> exception = new AtomicReference<>();  
        assertSame(searchResponse.getAggregations(), internalSearchResponse.aggregations());
        );
            executor,
            ClusterState.EMPTY_STATE,  
            new AtomicLong(),
    public void testOnShardSuccessPhaseDoneFailure() throws InterruptedException {  
            phaseResults,  
        );
            r -> InternalAggregationTestCase.emptyReduceContextBuilder()
        ExpandSearchPhase expandPhase = createExpandSearchPhase();
import org.opensearch.search.SearchPhaseResult;
            writableRegistry(),
import java.util.concurrent.CountDownLatch;
            assertThat(actual, equalTo(TimeUnit.NANOSECONDS.toMillis(expected.get())));
        final SearchShardIterator... shards  
        InternalSearchResponse internalSearchResponse = InternalSearchResponse.empty();  
import org.opensearch.common.UUIDs;  
    ) {
    public void testOnPhaseListenersWithDfsType() throws InterruptedException {  
            @Override  
        SearchPhaseExecutionException searchPhaseExecutionException = (SearchPhaseExecutionException) exception.get();  
            writableRegistry(),
            new AtomicLong(),
