        ) {
        final boolean catchExceptionWhenExecutePhaseOnShard,
            resultConsumer,
    private ExpandSearchPhase createExpandSearchPhase() {
            new TaskResourceUsage(randomLong(), randomLong()),
        assertThat(exception.get(), instanceOf(SearchPhaseExecutionException.class));
        ActionListener<SearchResponse> listener = ActionListener.wrap(response -> fail("onResponse should not be called"), exception::set);
            controlled,
        for (int i = 0; i < numFailures; i++) {
        assertSame(searchResponse.getAggregations(), internalSearchResponse.aggregations());
        assertSame(searchResponse.getAggregations(), internalSearchResponse.aggregations());
        action.skipShard(searchShardIterator);
 *
            @Override
        long delay = (randomIntBetween(1, 5));
        assertSame(searchResponse.getHits(), internalSearchResponse.hits());
        SearchPhaseExecutionException searchPhaseExecutionException = (SearchPhaseExecutionException) exception.get();
            .mapToObj(i -> new SearchShardIterator(null, new ShardId(index, i), List.of("n1", "n2", "n3"), null, null, null))
    }
        final SearchShardIterator... shards
        TimeUnit.MILLISECONDS.sleep(delay);
import org.opensearch.common.util.set.Sets;
    public void testOnPhaseFailureAndVerifyListeners() {
        final AtomicBoolean fail = new AtomicBoolean(true);
            System.nanoTime(),
        final Index index = new Index("test", UUID.randomUUID().toString());
    public void testShardNotAvailableWithDisallowPartialFailures() {
        assertEquals(1, testListener.getPhaseCurrent(action.getSearchPhaseNameOptional().get()));
import org.opensearch.threadpool.ThreadPool;
    public void testOnPhaseListenersWithQueryAndThenFetchType() throws InterruptedException {
                            throw new RuntimeException("Simulated exception");
                @Override
            phaseResults,
            long buildTookInMillis() {
            false,
            ),
        skipIterator.resetAndSkip();
            String resultClusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);
        InternalSearchResponse internalSearchResponse = InternalSearchResponse.empty();
            SearchResponse.Clusters.EMPTY,
            shardsIter.size(),
        AbstractSearchAsyncAction<SearchPhaseResult> action = createAction(
            controller,
        ArraySearchPhaseResults<SearchPhaseResult> phaseResults = new ArraySearchPhaseResults<>(numResults + numFailures);
    }
            timeProvider = new TransportSearchAction.SearchTimeProvider(0, 0, expected::get);
            false,
                return super.buildTookInMillis();
        final ArraySearchPhaseResults<SearchPhaseResult> queryResult = new ArraySearchPhaseResults<>(shards.length);
        ) {
import java.util.concurrent.TimeUnit;
import org.opensearch.common.settings.Settings;
 */
        assertSame(searchResponse.getAggregations(), internalSearchResponse.aggregations());
            new ShardId(new Index("name", "foo"), 1),
import org.opensearch.cluster.ClusterState;
            null,
import org.opensearch.action.OriginalIndices;
            listener,
            greaterThanOrEqualTo(delay)
            new TaskResourceUsage(randomLong(), randomLong())
                searchRequest,
import org.opensearch.search.internal.InternalSearchResponse;
        AbstractSearchAsyncAction<SearchPhaseResult> action = createAction(
        action.start();
            @Override
    private final Set<ShardSearchContextId> releasedContexts = new CopyOnWriteArraySet<>();
            );
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(1);
        assertThat(exception.get(), instanceOf(SearchPhaseExecutionException.class));
 * GitHub history for details.
        List<SearchRequestOperationsListener> searchRequestOperationsListeners
        searchDfsQueryThenFetchAsyncAction.start();
        assertEquals(requestIds, releasedContexts);
 * SPDX-License-Identifier: Apache-2.0
    private FetchSearchPhase createFetchSearchPhase() {
    public void testBuildSearchResponse() {
        SearchTask task = new SearchTask(0, "n/a", "n/a", () -> "test", null, Collections.emptyMap());
        action.skipShard(skipIterator);
            .mapToObj(i -> new SearchShardIterator(null, new ShardId(index, i), List.of("n1", "n2", "n3"), null, null, null))
                } else {
            r -> InternalAggregationTestCase.emptyReduceContextBuilder()
        TaskResourceUsage taskResourceUsage = new TaskResourceUsage(randomLong(), randomLong());
        assertEquals(0, searchPhaseExecutionException.shardFailures().length);
                    mockSearchPhaseContext.sendSearchResponse(searchResponse, null);
        SearchPhaseController controller = new SearchPhaseController(
        final TaskResourceUsage resourceUsage,
            .setParentTaskId(randomLong())
import java.util.ArrayList;
    ) {
        TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(
        assertSame(searchResponse.getSuggest(), internalSearchResponse.suggest());
        assertThat(testListener.getPhaseMetric(action.getSearchPhaseNameOptional().get()), greaterThanOrEqualTo(delay));
            1,
            results,
            false,
        action.onPhaseDone(); /* finish phase since we don't have response being sent */
            new TaskResourceUsage(randomLong(), randomLong()),
    public void testOnShardFailurePhaseDoneFailure() throws InterruptedException {
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(randomBoolean());
            SearchPhaseResult phaseResult = new PhaseResult(contextId);
        AtomicReference<Exception> exception = new AtomicReference<>();
            false,
        runTestTook(true);
                    listener.onFailure(new ShardNotFoundException(shardIt.shardId()));
            catchExceptionWhenExecutePhaseOnShard,
            @Override
public class AbstractSearchAsyncActionTests extends OpenSearchTestCase {
    }
 * not use this file except in compliance with the License.
            Collections.singletonMap("foo", 2.0f),
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(randomBoolean()).preference("_shards:1,3");
            resourceUsage,
        );
            writableRegistry(),
            exc -> {}
        );
        assertThat(exception.get(), instanceOf(SearchPhaseExecutionException.class));
        assertEquals(0, searchPhaseExecutionException.getSuppressed().length);
 * software distributed under the License is distributed on an
        int numShards = randomIntBetween(2, 10);
        long delay = (randomIntBetween(1, 5));
        final SearchShardIterator[] shards = IntStream.range(0, 5 + randomInt(10))
            null,
        SearchPhaseController controller = new SearchPhaseController(
        final AtomicLong expected = new AtomicLong();
        InternalSearchResponse internalSearchResponse = InternalSearchResponse.empty();
        if (controlled) {
            new AtomicLong(),
                i,
import java.util.Collections;
            NoopTracer.INSTANCE
            logger,
                        try {
        assertThat(testListener.getPhaseMetric(expandPhase.getSearchPhaseNameOptional().get()), greaterThanOrEqualTo(delay));
import org.opensearch.common.settings.ClusterSettings;
        int numShards = randomIntBetween(2, 10);
            this.contextId = contextId;
            listener,
            false,
            timeProvider,
        // expect at least 2 shards, so onPhaseDone should report failure.
            phaseResults,
    }
            null,
            results,
        assertEquals(0, searchPhaseExecutionException.getSuppressed().length);
    }
            System::nanoTime
        SearchRequestStats testListener = new SearchRequestStats(clusterSettings);
                }
                    try {
                new SearchRequestOperationsListener.CompositeListener(searchRequestOperationsListeners, logger),
        assertSame(searchResponse.getSuggest(), internalSearchResponse.suggest());
        assertEquals(1, testListener.getPhaseTotal(expandPhase.getSearchPhaseNameOptional().get()));
            null,
            executor,
        );
        AtomicReference<Exception> exception = new AtomicReference<>();
            timeProvider,
            mockSearchPhaseContext.getRequest(),
            0,
        assertTrue(latch.await(1, TimeUnit.SECONDS));
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                public void onFailure(Exception e) {
        final ArraySearchPhaseResults<SearchPhaseResult> queryResult = new ArraySearchPhaseResults<>(10);
    public void testSendSearchResponseDisallowPartialFailures() {
            writableRegistry(),
                }
                    }
        ActionListener<SearchResponse> listener = ActionListener.wrap(response -> fail("onResponse should not be called"), exception::set);
    private SearchRequestOperationsListenerAssertingListener assertingListener;
            phaseResult.setSearchShardTarget(new SearchShardTarget(resultNodeId, resultShardId, resultClusterAlias, OriginalIndices.NONE));
            .mapToObj(i -> new SearchShardIterator(null, new ShardId(index, i), List.of("n1", "n2", "n3"), null, null, null))
            new TaskResourceUsage(randomLong(), randomLong())
            listener,
        action.onShardFailure(
        final Index index = new Index("test", UUID.randomUUID().toString());
        searchRequest.setMaxConcurrentShardRequests(1);
            new AtomicLong(),
            taskResourceUsage
            null,
    @Before
import java.util.Set;
        ArraySearchPhaseResults<SearchPhaseResult> phaseResults = phaseResults(requestIds, nodeLookups, 0);
    }
            false,
            new SearchRequestContext(
/*
        AtomicReference<Exception> exception = new AtomicReference<>();
 * this work for additional information regarding copyright
        final List<SearchRequestOperationsListener> requestOperationListeners = new ArrayList<>(List.of(testListener, assertingListener));
        action.sendSearchResponse(InternalSearchResponse.empty(), phaseResults.results);
import org.opensearch.transport.Transport;
            NoopTracer.INSTANCE
        assertThat(searchResponse.getSuccessfulShards(), equalTo(0));
                () -> null
        assertEquals(1, testListener.getPhaseCurrent(action.getSearchPhaseNameOptional().get()));
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
    public void setUp() throws Exception {
            queryResult,
            true,
            .toArray(SearchShardIterator[]::new);
        // Verify fetchPhase current metric
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(false);
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);
        // skip one to avoid the "all shards failed" failure.
            searchRequest,
import java.util.stream.IntStream;
        action.onPhaseDone();
            @Override
    private void runTestTook(final boolean controlled) {
 *
 * specific language governing permissions and limitations
    }
        assertSame(searchResponse.getHits(), internalSearchResponse.hits());
        SearchQueryThenFetchAsyncAction action = createSearchQueryThenFetchAsyncAction(requestOperationListeners);
            false,
        QueryPhaseResultConsumer results = controller.newSearchPhaseResults(
        List<Tuple<String, String>> nodeLookups,
            new ArraySearchPhaseResults<>(10),
        assertEquals(1, testListener.getPhaseTotal(action.getSearchPhaseNameOptional().get()));
        ShardId shardId = new ShardId(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLength(10), randomInt());
    @Override
        return phaseResults;
 * Unless required by applicable law or agreed to in writing,
                @Override
        int numResults = randomIntBetween(1, 10);
        assertTrue(resourceUsages.get(0).contains(Long.toString(taskResourceUsage.getMemoryInBytes())));
        );
        return new ExpandSearchPhase(mockSearchPhaseContext, internalSearchResponse, null);
        SearchResponse searchResponse = action.buildSearchResponse(internalSearchResponse, action.buildShardFailures(), null, null);
        action.skipShard(skipIterator);
import java.util.concurrent.atomic.AtomicReference;
        final AtomicLong expected,
        SearchDfsQueryThenFetchAsyncAction searchDfsQueryThenFetchAsyncAction = createSearchDfsQueryThenFetchAsyncAction(
        assertEquals(new MatchAllQueryBuilder(), shardSearchTransportRequest.getAliasFilter().getQueryBuilder());
            ),
import org.opensearch.test.InternalAggregationTestCase;
            searchRequest,
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertSame(searchResponse.getSuggest(), internalSearchResponse.suggest());
    private AbstractSearchAsyncAction<SearchPhaseResult> createAction(
        searchDfsQueryThenFetchAsyncAction.executeNextPhase(searchDfsQueryThenFetchAsyncAction, fetchPhase);
            0,
                            assertThat(e, instanceOf(SearchPhaseExecutionException.class));
            0,
            false,
import java.util.List;
            System.nanoTime(),
            .build();
        Set<ShardSearchContextId> contextIds,
    public void tearDown() throws Exception {
            System::nanoTime
            new TaskResourceUsage(randomLong(), randomLong())
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);
import org.opensearch.common.UUIDs;
            timeProvider = new TransportSearchAction.SearchTimeProvider(0, System.nanoTime(), System::nanoTime);
                @Override
            null,
            @Override
        ); /* finalizing the fetch phase since we do adhoc phase lifecycle calls */
            }
        assertingListener.assertFinished();
        AtomicReference<Exception> exception = new AtomicReference<>();
                OriginalIndices originalIndices
    public void testOnPhaseFailure() {
            }
        );
        assertArrayEquals(new String[] { "name", "name1" }, shardSearchTransportRequest.indices());
    }
        SearchShardIterator skipIterator = new SearchShardIterator(null, null, Collections.emptyList(), null);
/*
        );
        delay = delay * 10;
        );
        ArraySearchPhaseResults<SearchPhaseResult> phaseResults = new ArraySearchPhaseResults<>(10);
        );
        final boolean controlled,
        threadPool.getThreadContext().addResponseHeader(TASK_RESOURCE_USAGE, taskResourceInfo.toString());
            (searchResponse, scrollId) -> new SearchPhase("test") {
    }
        return new FetchSearchPhase(
            executor,
        assertThat(
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);
            phaseResult.setShardIndex(i);
import java.util.concurrent.Executors;
        final CountDownLatch latch = new CountDownLatch(1);
    @After
            searchRequest,
        final boolean controlled,
        super.tearDown();
        final AtomicLong expected = new AtomicLong();
            false,
        QueryPhaseResultConsumer resultConsumer = new QueryPhaseResultConsumer(
        SearchPhaseController controller = new SearchPhaseController(
                        }
            expected,
    public void testOnShardSuccessPhaseDoneFailure() throws InterruptedException {
            listener,
    ) {
            new OriginalIndices(new String[] { "name", "name1" }, IndicesOptions.strictExpand())
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);
        assertEquals(0, testListener.getPhaseCurrent(expandPhase.getSearchPhaseNameOptional().get()));
import java.util.UUID;
    }
            task,
        final TransportSearchAction.SearchTimeProvider timeProvider;
        AtomicReference<Exception> exception = new AtomicReference<>();
            .toArray(SearchShardIterator[]::new);
import org.opensearch.core.tasks.resourcetracker.TaskResourceInfo;
        return new SearchDfsQueryThenFetchAsyncAction(
            }
            controller,
                final SearchShardIterator shardIt,
            String failureNodeId = randomAlphaOfLengthBetween(5, 10);
import org.opensearch.search.query.QuerySearchResult;
        action.start();
import org.opensearch.threadpool.TestThreadPool;
        ArraySearchPhaseResults<SearchPhaseResult> phaseResults = new ArraySearchPhaseResults<>(numShards);
            false,
    }
    }
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);
                    if (fail.compareAndExchange(true, false)) {
        action.start();
            shardsIter.size(),
        // Verify queryPhase total, current and latency metrics
        searchShardIterator.resetAndSkip();
            SearchProgressListener.NOOP,
            mockSearchPhaseContext,
import java.util.concurrent.atomic.AtomicBoolean;
        assertSame(searchResponse.getProfileResults(), internalSearchResponse.profile());
import org.opensearch.index.query.MatchAllQueryBuilder;
            new SearchRequestContext(
                        throw new RuntimeException("Simulated exception");
        SearchShardIterator skipIterator = new SearchShardIterator(null, null, Collections.emptyList(), null);
            request.getMaxConcurrentShardRequests(),
                @Override
            searchRequest,
        );
        ActionListener<SearchResponse> listener = ActionListener.wrap(response -> {}, exception::set);
import java.util.concurrent.CopyOnWriteArraySet;
        searchDfsQueryThenFetchAsyncAction.onPhaseFailure(
            executor,
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(false)
        GroupShardsIterator<SearchShardIterator> shardsIter = new GroupShardsIterator<>(List.of(shards));
            null,
            null,
                @Override
import java.util.Arrays;
        SearchShardIterator searchShardIterator = new SearchShardIterator(null, shardId, Collections.emptyList(), OriginalIndices.NONE);
        List<Tuple<String, String>> nodeLookups = new ArrayList<>();
        InternalSearchResponse internalSearchResponse = InternalSearchResponse.empty();
                    } else {
import org.apache.logging.log4j.LogManager;
    private final List<Tuple<String, String>> resolvedNodes = new ArrayList<>();
        assertEquals(0, searchPhaseExecutionException.getSuppressed().length);
            public void run() {
package org.opensearch.action.search;
            @Override
        assertArrayEquals(new String[] { "name", "name1" }, shardSearchTransportRequest.indices());
        }
            false,
    private static ArraySearchPhaseResults<SearchPhaseResult> phaseResults(
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(false);
 *
        Executor executor = OpenSearchExecutors.newDirectExecutorService();
import org.opensearch.search.SearchPhaseResult;
                        }
        AbstractSearchAsyncAction<SearchPhaseResult> action = createAction(
            }
        assertEquals(IndicesOptions.strictExpand(), shardSearchTransportRequest.indicesOptions());
        assertEquals(0, testListener.getPhaseCurrent(fetchPhase.getSearchPhaseNameOptional().get()));
        ArraySearchPhaseResults<SearchPhaseResult> phaseResults = new ArraySearchPhaseResults<>(numShards);
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
                    executor.submit(() -> latch.countDown());
            new TaskResourceUsage(randomLong(), randomLong())
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(true);
        action.run();
        );
            ShardSearchFailure[] buildShardFailures() {
        assertEquals(nodeLookups, resolvedNodes);
 * under the License.
        action.onPhaseFailure(new SearchPhase("test") {
                    if (fail.compareAndExchange(true, false)) {
        );
import org.opensearch.core.action.ActionListener;
            writableRegistry(),
                public void onResponse(SearchResponse response) {}
        assertSame(searchResponse.getHits(), internalSearchResponse.hits());
        executor = Executors.newFixedThreadPool(1);
        searchShardIterator.resetAndSkip();
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(0, testListener.getPhaseTotal(fetchPhase.getSearchPhaseNameOptional().get()));
            Collections.singletonMap("foo", new AliasFilter(new MatchAllQueryBuilder())),
        assertEquals(0, testListener.getPhaseCurrent(action.getSearchPhaseNameOptional().get()));
        action.onPhaseFailure(new SearchPhase("test") {
    }
        skipIterator.resetAndSkip();
            new IllegalArgumentException()
        assertEquals(2.0f, shardSearchTransportRequest.indexBoost(), 0.0f);
                searchRequest,
        assertEquals(1, testListener.getPhaseCurrent(fetchPhase.getSearchPhaseNameOptional().get()));
        final AtomicBoolean fail = new AtomicBoolean(true);
        final ArraySearchPhaseResults<SearchPhaseResult> queryResult = new ArraySearchPhaseResults<>(shards.length);
import org.opensearch.core.tasks.resourcetracker.TaskResourceUsage;
                request,
        assertSame(searchResponse.getProfileResults(), internalSearchResponse.profile());
import org.opensearch.core.index.shard.ShardId;
            action.onShardFailure(
        assertNotNull(resourceUsages);
            controller,
        innerTestExecutePhaseOnShardFailure(false);
    ) {
                public void onFailure(Exception e) {
            null,
            searchRequest,
            String resultNodeId = randomAlphaOfLengthBetween(5, 10);
 * ownership. Elasticsearch licenses this file to you under
        ShardId shardId = new ShardId(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLength(10), randomInt());
        ThreadPool.terminate(threadPool, 5, TimeUnit.SECONDS);
            new SearchShardTarget("node", new ShardId("index", "index-uuid", 0), null, OriginalIndices.NONE),
        ActionListener<SearchResponse> listener,
        // Validate no exception is thrown
            .setNodeId(randomAlphaOfLengthBetween(1, 5))
    private ExecutorService executor;
            logger,
        assertEquals(0, testListener.getPhaseTotal(action.getSearchPhaseNameOptional().get()));
            phaseResults,
        );
        );
            public void sendSearchResponse(InternalSearchResponse internalSearchResponse, AtomicArray<SearchPhaseResult> queryResults) {
        ArraySearchPhaseResults<SearchPhaseResult> results,
            new SearchRequestContext(
        assertSame(searchResponse.getProfileResults(), internalSearchResponse.profile());
        assertEquals(1, testListener.getPhaseCurrent(searchDfsQueryThenFetchAsyncAction.getSearchPhaseNameOptional().get()));
            new SearchShardIterator(null, null, Collections.emptyList(), null)
import org.opensearch.search.SearchShardTarget;
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
            ClusterState.EMPTY_STATE,
        assertEquals(0, testListener.getPhaseCurrent(searchDfsQueryThenFetchAsyncAction.getSearchPhaseNameOptional().get()));
import java.util.concurrent.atomic.AtomicLong;
            new SearchRequest(),
import static org.hamcrest.Matchers.equalTo;
        Set<ShardSearchContextId> requestIds = new HashSet<>();
            false,
        SearchResponse searchResponse = action.buildSearchResponse(internalSearchResponse, action.buildShardFailures(), null, null);
            phaseResults.consumeResult(phaseResult, () -> {});
import org.opensearch.common.util.concurrent.AtomicArray;
        SearchShardIterator shards = new SearchShardIterator(null, null, Collections.emptyList(), null);
            null,
        for (ShardSearchFailure shardSearchFailure : searchPhaseExecutionException.shardFailures()) {
            // with a controlled clock, we can assert the exact took time
            ) {
            listener,
        SearchResponse searchResponse = action.buildSearchResponse(internalSearchResponse, action.buildShardFailures(), null, null);
            searchRequest,
        assertEquals("_shards:1,3", shardSearchTransportRequest.preference());
            OpenSearchExecutors.newDirectExecutorService(),
        action.run();
        // Verify queryPhase current metric
        // Verify fetchPhase total, current and latency metrics
        action.executeNextPhase(action, fetchPhase);
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        final AtomicBoolean fail = new AtomicBoolean(true);
 * You may obtain a copy of the License at
            shardsIter,
        assertEquals(nodeLookups, resolvedNodes);
        action.executeNextPhase(action, createFetchSearchPhase());
                releasedContexts.add(contextId);
            null,
import org.opensearch.cluster.routing.GroupShardsIterator;
            testListener.getPhaseMetric(searchDfsQueryThenFetchAsyncAction.getSearchPhaseNameOptional().get()),
    public void testExecutePhaseOnShardFailureAndThrowException() throws InterruptedException {
    private SearchDfsQueryThenFetchAsyncAction createSearchDfsQueryThenFetchAsyncAction(
        assertEquals(1, testListener.getPhaseCurrent(expandPhase.getSearchPhaseNameOptional().get()));
    public void testTookWithControlledClock() {
import java.util.function.BiFunction;
import java.util.concurrent.CountDownLatch;
        );
            new ActionListener<SearchResponse>() {
        assertEquals(0, testListener.getPhaseCurrent(action.getSearchPhaseNameOptional().get()));
    ThreadPool threadPool;
            nodeIdToConnection,
            public void run() {
                @Override
            null,
        SearchShardIterator searchShardIterator = new SearchShardIterator(null, shardId, Collections.emptyList(), OriginalIndices.NONE);
 * Licensed to Elasticsearch under one or more contributor
        searchDfsQueryThenFetchAsyncAction.start();
 * compatible open source license.
            },
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertTrue(resourceUsages.get(0).contains(Long.toString(taskResourceUsage.getCpuTimeInNanos())));
        TimeUnit.MILLISECONDS.sleep(delay);
            ) {
    @Override
 * The OpenSearch Contributors require contributions made to
    }
    }
        );
        executor.shutdown();
 * KIND, either express or implied.  See the License for the
    }
            requestOperationListeners
        }
    }
            }
            false,
            new ActionListener<SearchResponse>() {
        innerTestExecutePhaseOnShardFailure(true);
        SearchResponse searchResponse = action.buildSearchResponse(internalSearchResponse, action.buildShardFailures(), null, null);
            };
        PhaseResult(ShardSearchContextId contextId) {
        SearchResponse searchResponse = action.buildSearchResponse(internalSearchResponse, action.buildShardFailures(), null, null);
        Set<ShardSearchContextId> requestIds = new HashSet<>();
        ShardId shardId = new ShardId(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLength(10), randomInt());
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            assertThat(actual, greaterThanOrEqualTo(TimeUnit.NANOSECONDS.toMillis(expected.get())));
                long elapsed = spinForAtLeastNMilliseconds(randomIntBetween(1, 10));
                }
                runnable.run();
                final SearchShardTarget shard,
        SearchTask task = new SearchTask(0, "n/a", "n/a", () -> "test", null, Collections.emptyMap());
            shards
        assertEquals(0, searchPhaseExecutionException.shardFailures().length);
        );
            new AtomicLong(),
        assertSame(searchResponse.getSuggest(), internalSearchResponse.suggest());
            expected,
            }
            phaseResults,
        SearchQueryThenFetchAsyncAction action = createSearchQueryThenFetchAsyncAction(requestOperationListeners);
            .setTaskId(randomLong())
        assertThat(testListener.getPhaseMetric(fetchPhase.getSearchPhaseNameOptional().get()), greaterThanOrEqualTo(delay));
            new AtomicLong(),
    ) {
        );
            logger,
        AbstractSearchAsyncAction<SearchPhaseResult> action = createAction(
        SearchRequest request,
        return new SearchQueryThenFetchAsyncAction(
                    }
    }
import org.opensearch.search.internal.ShardSearchContextId;
            queryResult,
                new SearchShardTarget(failureNodeId, failureShardId, failureClusterAlias, OriginalIndices.NONE),
        TaskResourceInfo taskResourceInfo = new TaskResourceInfo.Builder().setTaskResourceUsage(resourceUsage)
        FetchSearchPhase fetchPhase = createFetchSearchPhase();
        );
        );
import org.junit.Before;
                return ShardSearchFailure.EMPTY_ARRAY;
            new AtomicLong(),
            ShardSearchContextId contextId = new ShardSearchContextId(UUIDs.randomBase64UUID(), randomNonNegativeLong());
            listener,
        AtomicReference<Exception> exception = new AtomicReference<>();
 *    http://www.apache.org/licenses/LICENSE-2.0
            new ActionListener<SearchResponse>() {
        assertSame(searchResponse.getSuggest(), internalSearchResponse.suggest());
            writableRegistry(),
 * Modifications Copyright OpenSearch Contributors. See
        GroupShardsIterator<SearchShardIterator> shardsIter = new GroupShardsIterator<>(List.of(shards));
                public void run() {
            }
        assertEquals(1, testListener.getPhaseTotal(searchDfsQueryThenFetchAsyncAction.getSearchPhaseNameOptional().get()));
        );
        );
        assertingListener = new SearchRequestOperationsListenerAssertingListener();
    ) {
import org.opensearch.action.support.IndicesOptions;
                }
                Transport.Connection connection,
            assertThat(actual, equalTo(TimeUnit.NANOSECONDS.toMillis(expected.get())));
            String failureClusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);
    private static final class PhaseResult extends SearchPhaseResult {
        Executor executor = OpenSearchExecutors.newDirectExecutorService();
        AbstractSearchAsyncAction<SearchPhaseResult> action = createAction(
            fetchPhase,
        searchDfsQueryThenFetchAsyncAction.onPhaseFailure(new SearchPhase("test") {
        assertTrue(latch.await(1, TimeUnit.SECONDS));
            resultConsumer,
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        searchDfsQueryThenFetchAsyncAction.skipShard(searchShardIterator);
 * license agreements. See the NOTICE file distributed with
        };
        }
    }
            listener,
            .toArray(SearchShardIterator[]::new);
            requestOperationListeners
 */
        return createAction(
        SearchRequestStats testListener = new SearchRequestStats(clusterSettings);
    public void testOnPhaseListenersWithDfsType() throws InterruptedException {
                start();
        }, "message", null);
            new TaskResourceUsage(randomLong(), randomLong())
                @Override
        assertEquals(clusterAlias, shardSearchTransportRequest.getClusterAlias());
                public void onFailure(Exception e) {
        ShardSearchRequest shardSearchTransportRequest = action.buildShardSearchRequest(iterator);
import java.util.HashSet;
            ),
            false,
        action.sendSearchResponse(InternalSearchResponse.empty(), phaseResults.results);
import java.util.concurrent.ExecutorService;
        ActionListener<SearchResponse> listener = ActionListener.wrap(response -> fail("onResponse should not be called"), exception::set);
        InternalSearchResponse internalSearchResponse = InternalSearchResponse.empty();
        threadPool = new TestThreadPool(getClass().getName());
            request,
            new AtomicLong(),
            "test",
        assertEquals("test", searchPhaseExecutionException.getPhaseName());
                            listener.onFailure(e);
        final long actual = action.buildTookInMillis();
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            null,
 */
        }, "message", null);
                public void onResponse(SearchResponse response) {
import org.opensearch.core.common.breaker.CircuitBreaker;
    public void testShardNotAvailableWithIgnoreUnavailable() {
            null,
            searchRequest,
        );
                return null;
        action.skipShard(searchShardIterator);
            NoopTracer.INSTANCE
            searchRequest,
        TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(
        SearchShardIterator shards = new SearchShardIterator(null, null, Collections.emptyList(), null);
        SearchRequestStats testListener = new SearchRequestStats(clusterSettings);
            null,
            ShardId resultShardId = new ShardId("index", "index-uuid", i);
        action.executeNextPhase(expandPhase, fetchPhase);
            phaseResults,
                        listener.onResponse(new QuerySearchResult());
import java.util.EnumSet;
        final TaskResourceUsage resourceUsage
            null,
                }
        } else {
                    if (catchExceptionWhenExecutePhaseOnShard) {
        List<Tuple<String, String>> nodeLookups = new ArrayList<>();
            shards
            },
        final List<SearchRequestOperationsListener> requestOperationListeners = List.of(testListener, assertingListener);
import static org.hamcrest.Matchers.instanceOf;
        action.executeNextPhase(fetchPhase, expandPhase);
            queryResult,
import org.opensearch.search.internal.AliasFilter;
        assertEquals(1, testListener.getPhaseCurrent(fetchPhase.getSearchPhaseNameOptional().get()));
            new AtomicLong(),
            null,
            protected void executePhaseOnShard(
            SearchResponse.Clusters.EMPTY,
        final CountDownLatch latch = new CountDownLatch(1);
            new TaskResourceUsage(randomLong(), randomLong()),
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
                final SearchActionListener<SearchPhaseResult> listener
                    } finally {
        );
            listener,
        );
import java.util.concurrent.Executor;
            shards
        ActionListener<SearchResponse> listener = ActionListener.wrap(response -> fail("onResponse should not be called"), exception::set);
        assertEquals(1, testListener.getPhaseCurrent(searchDfsQueryThenFetchAsyncAction.getSearchPhaseNameOptional().get()));
        searchRequest.setMaxConcurrentShardRequests(5);
            }
                new IllegalArgumentException()
        super.setUp();
        final CountDownLatch latch = new CountDownLatch(1);
    }
        );
                new SearchRequestOperationsListener.CompositeListener(List.of(assertingListener), LogManager.getLogger()),
        assertTrue(latch.await(1, TimeUnit.SECONDS));
    }
        AbstractSearchAsyncAction<SearchPhaseResult> action = createAction(
        String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);
            public void run() {
            new ArraySearchPhaseResults<>(10),
            return null;
        List<String> resourceUsages = threadPool.getThreadContext().getResponseHeaders().get(TASK_RESOURCE_USAGE);
    }
        assertEquals(requestIds, releasedContexts);
        TimeUnit.MILLISECONDS.sleep(delay);
        searchShardIterator.resetAndSkip();
    private AbstractSearchAsyncAction<SearchPhaseResult> createAction(
        assertThat(searchResponse.getSuccessfulShards(), equalTo(shards.length));
        }, "message", null);
        // skip one to avoid the "all shards failed" failure.
            protected SearchPhase getNextPhase(final SearchPhaseResults<SearchPhaseResult> results, SearchPhaseContext context) {
            searchRequest,
            new AtomicLong(),
                () -> null
        AbstractSearchAsyncAction<SearchPhaseResult> action = createAction(
            // with a real clock, the best we can say is that it took as long as we spun for
        );
            ShardId failureShardId = new ShardId("index", "index-uuid", i);
                        // We end up here only when onPhaseDone() is called (causing NPE) and
            clusterAlias,
        ArraySearchPhaseResults<SearchPhaseResult> phaseResults = phaseResults(requestIds, nodeLookups, numFailures);
            @Override
    }
            null,
            timeProvider,
    private SearchQueryThenFetchAsyncAction createSearchQueryThenFetchAsyncAction(
            new TaskResourceUsage(0, 0)
            controller,
                        executor.submit(() -> latch.countDown());
        FetchSearchPhase fetchPhase = createFetchSearchPhase();
            exc -> {}
            assertThat(shardSearchFailure.getCause(), instanceOf(IllegalArgumentException.class));
            },
            null,
        for (int i = 0; i < numResults; i++) {
        final SearchShardIterator[] shards = IntStream.range(0, 2 + randomInt(3))
        List<SearchRequestOperationsListener> searchRequestOperationsListeners
        action.executeNextPhase(action, fetchPhase);
            controlled,
        AbstractSearchAsyncAction<SearchPhaseResult> action = createAction(
                        if (fail.compareAndExchange(true, false)) {
        QueryPhaseResultConsumer resultConsumer = new QueryPhaseResultConsumer(
import static org.opensearch.tasks.TaskResourceTrackingService.TASK_RESOURCE_USAGE;
            }
            searchRequest,
        assertEquals("message", searchPhaseExecutionException.getMessage());
        SearchRequest searchRequest = new SearchRequest().allowPartialSearchResults(false);
                        }
            results,
        FetchSearchPhase fetchPhase = createFetchSearchPhase();
            .indicesOptions(new IndicesOptions(EnumSet.of(IndicesOptions.Option.IGNORE_UNAVAILABLE), IndicesOptions.WildcardStates.NONE));
            Collections.singletonMap("name", Sets.newHashSet("bar", "baz")),
    }
        assertEquals(0, testListener.getPhaseTotal(action.getSearchPhaseNameOptional().get()));
                            throw new RuntimeException("Simulated exception");
                () -> null
    }
            shardsIter,
    public void testBuildShardSearchTransportRequest() {
            executor,
            resolvedNodes.add(Tuple.tuple(cluster, node));
            nodeLookups.add(Tuple.tuple(resultClusterAlias, resultNodeId));
                if (failExecutePhaseOnShard) {
    private void innerTestExecutePhaseOnShardFailure(boolean catchExceptionWhenExecutePhaseOnShard) throws InterruptedException {
    public void testBuildSearchResponseAllowPartialFailures() {
            r -> InternalAggregationTestCase.emptyReduceContextBuilder()
        assertEquals("Partial shards failure (" + (numShards - 1) + " shards unavailable)", searchPhaseExecutionException.getMessage());
            new AtomicLong(),
        assertSame(searchResponse.getProfileResults(), internalSearchResponse.profile());
    public void testExecutePhaseOnShardFailure() throws InterruptedException {
                            executor.submit(() -> latch.countDown());
        TimeUnit.MILLISECONDS.sleep(delay);
        searchRequest.setMaxConcurrentShardRequests(1);
        action.run();
import org.opensearch.search.internal.ShardSearchRequest;
            "Something went wrong",
                expected.set(elapsed);
        AbstractSearchAsyncAction<SearchPhaseResult> action = createAction(
                }
            task.getProgressListener(),
        action.onPhaseFailure(new SearchPhase("test") {
        final AtomicLong expected,
        ActionListener<SearchResponse> listener,
            false,
        assertSame(searchResponse.getHits(), internalSearchResponse.hits());
            writableRegistry(),
    }
 * the Apache License, Version 2.0 (the "License"); you may
                public void onResponse(SearchResponse response) {
        assertSame(searchResponse.getProfileResults(), internalSearchResponse.profile());
    }
            .setAction(randomAlphaOfLengthBetween(1, 5))
import org.opensearch.index.shard.ShardNotFoundException;
}
        SearchDfsQueryThenFetchAsyncAction searchDfsQueryThenFetchAsyncAction = createSearchDfsQueryThenFetchAsyncAction(
            public void sendReleaseSearchContext(
        SearchShardIterator iterator = new SearchShardIterator(
            task,
                        } catch (Exception e) {
        ExpandSearchPhase expandPhase = createExpandSearchPhase();
        SearchPhaseExecutionException searchPhaseExecutionException = (SearchPhaseExecutionException) exception.get();
        assertArrayEquals(new String[] { "bar", "baz" }, shardSearchTransportRequest.indexRoutings());
        ArraySearchPhaseResults<SearchPhaseResult> results,
            searchRequest,
        if (controlled) {
            request,
                    }
        return new AbstractSearchAsyncAction<SearchPhaseResult>(
                        } finally {
import org.opensearch.core.index.Index;
                        try {
        final Index index = new Index("test", UUID.randomUUID().toString());
        assertEquals(1, resourceUsages.size());
            new TaskResourceUsage(randomLong(), randomLong())
        assertSame(searchResponse.getAggregations(), internalSearchResponse.aggregations());
        ActionListener<SearchResponse> listener = ActionListener.wrap(response -> fail("onResponse should not be called"), exception::set);
        };
                            listener.onResponse(new QuerySearchResult());
        }, "message", null);
            r -> InternalAggregationTestCase.emptyReduceContextBuilder()
            @Override
            expected,
        MockSearchPhaseContext mockSearchPhaseContext = new MockSearchPhaseContext(1);
        SearchShardIterator searchShardIterator = new SearchShardIterator(null, shardId, Collections.emptyList(), OriginalIndices.NONE);
        SearchRequest request,
        assertTrue(executor.awaitTermination(1, TimeUnit.SECONDS));
                }
            searchRequest,
                        // ending up in the onPhaseFailure() callback
        AbstractSearchAsyncAction<SearchPhaseResult> action = createAction(
        };
        InternalSearchResponse internalSearchResponse = InternalSearchResponse.empty();
    }
        final Runnable runnable;
        InternalSearchResponse internalSearchResponse = new InternalSearchResponse(null, null, null, null, false, null, 1);
            searchRequest,
        SearchPhaseExecutionException searchPhaseExecutionException = (SearchPhaseExecutionException) exception.get();
        final ArraySearchPhaseResults<SearchPhaseResult> queryResult = new ArraySearchPhaseResults<>(shards.length);
        }
        int numFailures
        runTestTook(false);
import org.opensearch.common.collect.Tuple;
        }
            @Override
            @Override
        assertEquals(numFailures, searchPhaseExecutionException.shardFailures().length);
            }
            exc -> {}
        }
                ShardSearchContextId contextId,
        assertEquals(0, testListener.getPhaseCurrent(action.getSearchPhaseNameOptional().get()));
        int numFailures = randomIntBetween(1, 5);
            null
        BiFunction<String, String, Transport.Connection> nodeIdToConnection = (cluster, node) -> {
            queryResult,
            runnable = () -> {
            Collections.emptyList(),
            contextIds.add(contextId);
import org.junit.After;
        assertSame(searchResponse.getAggregations(), internalSearchResponse.aggregations());
            new GroupShardsIterator<>(Arrays.asList(shards)),
        assertSame(searchResponse.getHits(), internalSearchResponse.hits());
        } else {
        final SearchShardIterator[] shards = IntStream.range(0, 5 + randomInt(10))
            task.getProgressListener(),
            null,
    public void testTookWithRealClock() {
            SearchResponse.Clusters.EMPTY,
        final boolean failExecutePhaseOnShard,
            false,
        final List<SearchRequestOperationsListener> requestOperationListeners = new ArrayList<>(List.of(testListener, assertingListener));
            public void run() {
        AbstractSearchAsyncAction<SearchPhaseResult> action = createAction(
                new SearchRequestOperationsListener.CompositeListener(searchRequestOperationsListeners, logger),
        assertEquals("test", searchPhaseExecutionException.getPhaseName());
                    }
        assertEquals(0, testListener.getPhaseCurrent(fetchPhase.getSearchPhaseNameOptional().get()));
            executor,
            searchRequest,
        assertEquals(1, testListener.getPhaseTotal(fetchPhase.getSearchPhaseNameOptional().get()));
/*
        assertThat(searchResponse.getSuccessfulShards(), equalTo(shards.length));
import org.opensearch.test.OpenSearchTestCase;
        );
            runnable = () -> expected.set(randomNonNegativeLong());
