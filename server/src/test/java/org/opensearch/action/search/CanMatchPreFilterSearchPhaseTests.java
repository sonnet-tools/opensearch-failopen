                    }
    /*
        assertFalse(result.get().get(1).skip()); // never skip the failure
                        assert cluster == null : "cluster was not null: " + cluster;
import java.util.concurrent.ConcurrentHashMap;
            ClusterState.EMPTY_STATE,
                listener,
                fail("can_match should not be sent to skipped shard groups");
                        shardIds.add(request.shardId());
                    latch.countDown();
        };
                ) {
                new Thread(
                }
                NoopTracer.INSTANCE
                (iter) -> new SearchPhase("test") {
        canMatchPhase.start();
    }
                        responseListener,
            );
                        } else {
        shardsIter.get(1).resetAndSkip();
            Collections.emptyMap(),
import org.opensearch.Version;
        );
                searchRequestContext,
                shardsIts,
        searchRequest.allowPartialSearchResults(true);
    private static final class SearchDfsQueryAsyncAction extends AbstractSearchAsyncAction<DfsSearchResult> {
                public void run() throws IOException {
                randomIntBetween(2, 20),
            },
import org.opensearch.search.builder.SearchSourceBuilder;
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
                return new WrappingSearchAsyncActionPhase(
        final GroupShardsIterator<SearchShardIterator> shardsIter = SearchAsyncActionTests.getShardsIter(
        Map<String, Transport.Connection> lookup = new ConcurrentHashMap<>();
            Collections.emptyMap(),
        );
                ClusterState.EMPTY_STATE,
        lookup.put("node2", new SearchAsyncActionTests.MockConnection(replicaNode));
            primaryNode,
                    searchTransportService,
            timeProvider,
                    result.set(iter);
                        minMax = new MinAndMax<>(min, max);
            task.getProgressListener(),
            (iter) -> new SearchPhase("test") {
            NoopTracer.INSTANCE
        }
        CanMatchPreFilterSearchPhase canMatchPhase = new CanMatchPreFilterSearchPhase(
        final SearchTransportService searchTransportService = new SearchTransportService(null, null) {
            replicaNode
                }
            Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY)),
                public void run() throws IOException {
                List.of(assertingListener),
            for (SearchShardIterator i : result.get()) {
            Set<ShardId> shardToSkip = new HashSet<>();
            ) {
    public void testSkippedShardGroupsAreNotSentToCanMatch() throws InterruptedException {
                listener.onResponse(new SearchService.CanMatchResponse(true, null));
public class CanMatchPreFilterSearchPhaseTests extends OpenSearchTestCase {
                assertEquals(shardToSkip.contains(i.shardId()), i.skip());
            LogManager.getLogger()
                public void run() throws IOException {
            null,
                                listener.onResponse(new SearchPhaseResult() {
import org.opensearch.test.InternalAggregationTestCase;
            SearchResponse.Clusters.EMPTY,
                numShards,
            replicaNode
        );
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
                assertThat(i.shardId().id(), equalTo(shardId++));
            }
                },
import org.opensearch.core.index.shard.ShardId;
        );
        final SearchRequest searchRequest = new SearchRequest();
            shardsIter,
            int numShards = randomIntBetween(2, 20);
import org.opensearch.transport.Transport;
    }
                randomBoolean(),
            final SearchActionListener<DfsSearchResult> listener
        lookup.put("node2", new SearchAsyncActionTests.MockConnection(replicaNode));
                        result.set(iter);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        lookup.put("node2", new SearchAsyncActionTests.MockConnection(replicaNode));
                        Collections.emptyMap(),
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
        for (SortOrder order : SortOrder.values()) {
            List.of(assertingListener),
import org.opensearch.cluster.ClusterState;
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
        final boolean shard1 = randomBoolean();
        assertTrue(result.get().get(0).skip());
                new SearchRequestContext(searchRequestOperationsListener, searchRequest, () -> null),
            ClusterState.EMPTY_STATE,
                            return new WrappingSearchAsyncActionPhase(this) {
            List<MinAndMax<?>> minAndMaxes = new ArrayList<>();
            public void sendCanMatch(
                        }
            4096,
        );
import org.opensearch.action.OriginalIndices;
                    final MinAndMax<?> minMax;
                @Override
            final ActionListener<SearchResponse> listener,
                primaryNode,
        );
                    latch.countDown();
        );
                    @Override
        }
            () -> null
                Transport.Connection connection,
                        aliasFilters,
            assertThat(result.get().size(), equalTo(numShards));
        assertingListener = new SearchRequestOperationsListenerAssertingListener();
                SearchTask task,
 * Modifications Copyright OpenSearch Contributors. See
            0,
            }
                Collections.emptyMap(),
                .boxed()
        }
            shardsIter,
            primaryNode,
                .toArray(ShardId[]::new);
            NoopTracer.INSTANCE
            final SearchRequestOperationsListener searchRequestOperationsListener = new SearchRequestOperationsListener.CompositeListener(
                new Thread(
            LogManager.getLogger()
        searchRequest.allowPartialSearchResults(true);
            (clusterAlias, node) -> lookup.get(node),
        SearchTransportService searchTransportService = new SearchTransportService(null, null) {
            final Map<String, Float> concreteIndexBoosts,
            "idx",
import org.apache.lucene.util.BytesRef;
import org.opensearch.core.common.breaker.CircuitBreaker;
            int pos = 0;
        CanMatchPreFilterSearchPhase canMatchPhase = new CanMatchPreFilterSearchPhase(
                ShardSearchRequest request,
            for (SearchShardIterator i : result.get()) {
 * ownership. Elasticsearch licenses this file to you under
            System::nanoTime
                        new ArraySearchPhaseResults<>(iter.size()),
                        Long max = randomLongBetween(min, Long.MAX_VALUE);
                canMatchShardIds.add(request.shardId().id());
        canMatchPhase.start();
                    }
                clusters,
 *
            controller,
        lookup.put("node1", new SearchAsyncActionTests.MockConnection(primaryNode));
                    new AbstractSearchAsyncAction<SearchPhaseResult>("test", logger, transportService, (cluster, node) -> {
        final TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(
                assertEquals(shardToSkip.contains(i.shardId()), i.skip());
                request.getMaxConcurrentShardRequests(),
                SearchTask task,
            exc -> {}
            public void sendCanMatch(
            CanMatchPreFilterSearchPhase canMatchPhase = new CanMatchPreFilterSearchPhase(
            new OriginalIndices(new String[] { "idx" }, SearchRequest.DEFAULT_INDICES_OPTIONS),
import org.opensearch.search.SearchShardTarget;
                primaryNode,
        );
            public void sendCanMatch(
            searchRequest.source(new SearchSourceBuilder().sort(SortBuilders.fieldSort("timestamp").order(order)));
                );
        SearchTransportService searchTransportService = new SearchTransportService(null, null) {
                @Override
            OpenSearchExecutors.newDirectExecutorService(),
                    latch.countDown();
                searchTransportService,
        Map<String, AliasFilter> aliasFilters = Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY));
            return new SearchPhase("last") {
                NoopTracer.INSTANCE
            final SearchShardIterator shardIt,
            CountDownLatch latch = new CountDownLatch(1);
            null,
                    Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY)),
            SearchResponse.Clusters.EMPTY,
            assertEquals(1, result.get().get(1).shardId().id());
                task,
        searchRequest.allowPartialSearchResults(true);
            @Override
            primaryNode,
        latch.await();
                .map(shardIds::get)
            final Map<String, AliasFilter> aliasFilter,
            );
        final TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(
            assertTrue(result.get().get(1).skip());
            ) {
                    null,
            randomBoolean(),
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
            };
        DiscoveryNode replicaNode = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);
            Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY)),
                        @Override
                        searchRequest,
            final DfsSearchResult response = new DfsSearchResult(shardIt.getSearchContextId(), shard, null);
        );
                                listener.onFailure(new Exception("failure"));
                SearchResponse.Clusters.EMPTY,
            List.of(assertingListener),
        CountDownLatch latch = new CountDownLatch(1);
        DiscoveryNode replicaNode = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);
                        searchRequestOperationsListener.onPhaseEnd(new MockSearchPhaseContext(1, searchRequest, this), null);
            System.nanoTime(),
            searchTransportService,
                null,
                    shardsIter,
        SearchTransportService searchTransportService = new SearchTransportService(null, null) {
            primaryNode,
            timeProvider,
        final SearchRequest searchRequest = new SearchRequest();
                LogManager.getLogger()
            new SearchRequestContext(searchRequestOperationsListener, searchRequest, () -> null),
        CountDownLatch latch = new CountDownLatch(1);
        @Override
 */
                    logger,
import java.io.IOException;
            SearchResponse.Clusters.EMPTY,
            (clusterAlias, node) -> lookup.get(node),
import static org.hamcrest.Matchers.equalTo;
            replicaNode
                        Long min = randomLong();
                boolean throwException = request.shardId().id() != 0;
        latch.await();
                if (throwException && randomBoolean()) {
 * You may obtain a copy of the License at
                    synchronized (shardIds) {
        );
                (iter) -> new SearchPhase("test") {
                indexRoutings,
                Collections.emptyMap(),
                nodeIdToConnection,
                Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY)),
                SearchResponse.Clusters.EMPTY,
        );
        final ExecutorService executor = Executors.newFixedThreadPool(randomIntBetween(1, Runtime.getRuntime().availableProcessors()));
        } else {
import java.util.ArrayList;
    public void testFilterShards() throws InterruptedException {
        private final SearchRequestOperationsListener listener;
        super.setUp();
        }
                "logs",
            OpenSearchExecutors.newDirectExecutorService(),
        SearchTransportService searchTransportService = new SearchTransportService(null, null) {
            SearchRequestContext searchRequestContext
            public void sendCanMatch(
                Transport.Connection connection,
        DiscoveryNode replicaNode = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);
            (clusterAlias, node) -> lookup.get(node),
            executor,
                @Override
import java.util.Collections;
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
                    ActionListener<SearchService.CanMatchResponse> listener
                        latch.countDown();
            GroupShardsIterator<SearchShardIterator> shardsIter = SearchAsyncActionTests.getShardsIter(
        lookup.put("node_2", new SearchAsyncActionTests.MockConnection(replicaNode));
            final BiFunction<String, String, Transport.Connection> nodeIdToConnection,
        );
            searchTransportService,
            );
            ) {
            System.nanoTime(),
        executor.shutdown();
            ) {
            searchTransportService,
            ClusterState.EMPTY_STATE,
                .sorted(Comparator.comparing(minAndMaxes::get, MinAndMax.getComparator(order)).thenComparing(shardIds::get))
            }
            randomBoolean(),
            null,
import org.junit.After;
            searchTransportService,
 */
        final boolean shard2 = randomBoolean();
            Set<ShardId> shardToSkip = new HashSet<>();
                Transport.Connection connection,
            randomBoolean(),
                Collections.emptyMap(),
            System::nanoTime
                new ArraySearchPhaseResults<>(shardsIts.size()),
                    }
            2,
            this.listener = searchRequestContext.getSearchRequestOperationsListener();
        final boolean shard1 = randomBoolean();
import java.util.Map;
                    }).start();
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
            searchRequest,
            System.nanoTime(),
            NoopTracer.INSTANCE
    public void testFilterWithFailure() throws InterruptedException {
                    () -> listener.onResponse(new SearchService.CanMatchResponse(request.shardId().id() == 0 ? shard1 : shard2, null))
            (clusterAlias, node) -> lookup.get(node),
        final SearchRequest searchRequest = new SearchRequest();
                ShardSearchRequest request,
        );
            SearchTransportService searchTransportService = new SearchTransportService(null, null) {
            searchRequest,
                            final SearchShardTarget shard,
                ShardSearchRequest request,
                        super.run();
        DiscoveryNode replicaNode = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);
        CanMatchPreFilterSearchPhase canMatchPhase = new CanMatchPreFilterSearchPhase(
        );
                        }
                    } else {
import java.util.concurrent.Executors;
        };
        AtomicReference<GroupShardsIterator<SearchShardIterator>> result = new AtomicReference<>();
        final OriginalIndices originalIndices = new OriginalIndices(new String[] { "idx" }, SearchRequest.DEFAULT_INDICES_OPTIONS);
            assertFalse(result.get().get(0).skip());
        shardsIter.get(0).resetAndSkip();
import org.opensearch.test.OpenSearchTestCase;
            new OriginalIndices(new String[] { "idx" }, SearchRequest.DEFAULT_INDICES_OPTIONS),
        final SearchRequestOperationsListener searchRequestOperationsListener = new SearchRequestOperationsListener.CompositeListener(
            Collections.emptyMap(),
            SearchResponse.Clusters clusters,
            0,
                    new Thread(() -> listener.onResponse(new SearchService.CanMatchResponse(canMatch, minMax))).start();
/*
        );
                ShardSearchRequest request,
            );
     */
        shardsIter.get(0).resetAndSkip();
        );
                    (clusterAlias, node) -> lookup.get(node),
                            if (randomBoolean()) {
            }
                ).start();
                SearchTask task,
    }
                    }
        lookup.put("node1", new SearchAsyncActionTests.MockConnection(primaryNode));
                ActionListener<SearchService.CanMatchResponse> listener
            logger,
import org.junit.Before;
                searchRequest,
                timeProvider,
                ActionListener<SearchService.CanMatchResponse> listener
            Collections.emptyMap(),
                assertEquals(expected[pos++], i.shardId());
            listener.innerOnResponse(response);
    @After
            0,
        );
    }
                    searchRequest,
                                    latch.countDown();
        CountDownLatch latch = new CountDownLatch(1);
        );
            (iter) -> new SearchPhase("test") {
                            listener.onFailure(new NullPointerException());
                shardsIter,
import org.opensearch.search.internal.ShardSearchRequest;
        final SearchRequest searchRequest = new SearchRequest();
            0,
        final TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(
                new OriginalIndices(new String[] { "logs" }, SearchRequest.DEFAULT_INDICES_OPTIONS),
            ClusterState.EMPTY_STATE,
            Collections.emptyMap(),
                }
            NoopTracer.INSTANCE
            @Override
        assertTrue(result.get().get(1).skip());
            "idx",
            System::nanoTime
        latch.await();
            writableRegistry(),
            null,
            final SearchPhaseController searchPhaseController,
            SearchResponse.Clusters.EMPTY,
                public void run() throws IOException {
            List.of(assertingListener),
            new OriginalIndices(new String[] { "idx" }, SearchRequest.DEFAULT_INDICES_OPTIONS),
                            final SearchActionListener<SearchPhaseResult> listener
 * KIND, either express or implied.  See the License for the
        assertEquals(0, result.get().get(0).shardId().id());
                null,
                        @Override
import org.opensearch.search.internal.AliasFilter;
        lookup.put("node1", new SearchAsyncActionTests.MockConnection(primaryNode));
        };
    private SearchRequestOperationsListenerAssertingListener assertingListener;
 * GitHub history for details.
            System::nanoTime
                timeProvider,
                    task,
                        result.set(iter);
            },
                        protected SearchPhase getNextPhase(SearchPhaseResults<SearchPhaseResult> results, SearchPhaseContext context) {
            System.nanoTime(),
                        latch.countDown();
                }
            ClusterState.EMPTY_STATE,
        latch.await();
        final boolean shard2 = randomBoolean();
                        protected void executePhaseOnShard(
            Collections.emptyMap(),
                ActionListener<SearchService.CanMatchResponse> listener
            Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY)),
                    () -> listener.onResponse(new SearchService.CanMatchResponse(request.shardId().id() == 0 ? shard1 : shard2, null))
                ShardSearchRequest request,
                timeProvider,
                            shardToSkip.add(request.shardId());
import org.opensearch.core.action.ActionListener;
        final TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(
            );
            (iter) -> new SearchPhase("test") {
        assertThat(result.get(), is(nullValue()));
                Transport.Connection connection,
                        latch.countDown();
                        ClusterState.EMPTY_STATE,
            Collections.emptyMap(),
            "idx",
        assertThat(canMatchShardIds, equalTo(List.of(1)));
            timeProvider,
                    listener.onPhaseEnd(context, null);
                            }
 */
        lookup.put("node2", new SearchAsyncActionTests.MockConnection(replicaNode));
            null,
                    }
        ActionListener<SearchResponse> responseListener = ActionListener.wrap(
            "idx",
 * Unless required by applicable law or agreed to in writing,
    public void tearDown() throws Exception {
/*
        );
            System::nanoTime
        final SearchRequestOperationsListener searchRequestOperationsListener = new SearchRequestOperationsListener.CompositeListener(
                        }
            SearchResponse.Clusters.EMPTY,
                    result.set(iter);
            0,
                        SearchResponse.Clusters.EMPTY,
                searchRequest,
            "idx",
            (iter) -> {
                        new SearchRequestContext(searchRequestOperationsListener, searchRequest, () -> null),
                    public void run() {
            null,
            final Logger logger,
                ActionListener<SearchService.CanMatchResponse> listener
            latch.await();
            @Override
                    @Override
                }
            },
            2,
 * The OpenSearch Contributors require contributions made to
            NoopTracer.INSTANCE
            replicaNode
            GroupShardsIterator<SearchShardIterator> shardsIter = SearchAsyncActionTests.getShardsIter(
                    throw new IllegalArgumentException("boom");
        lookup.put("node1", new SearchAsyncActionTests.MockConnection(primaryNode));
        );
                    ClusterState.EMPTY_STATE,
                    @Override
                SearchPhaseName.DFS_PRE_QUERY.getName(),
                ClusterState.EMPTY_STATE,
                List.of(assertingListener),
                ).start();
        lookup.put("node2", new SearchAsyncActionTests.MockConnection(replicaNode));
            replicaNode
            timeProvider,
            logger,
 * not use this file except in compliance with the License.
            shardsIter,
            assertEquals(0, result.get().get(0).shardId().id());
            searchRequestContext,
                Transport.Connection connection,
            ) {
                        shardIds.add(request.shardId());
                }
        lookup.put("node1", new SearchAsyncActionTests.MockConnection(primaryNode));
            final Map<String, Set<String>> indexRoutings,
        );
        lookup.put("node2", new SearchAsyncActionTests.MockConnection(replicaNode));
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
            searchRequest,
                SearchTask task,
            shardsIter.size(),
                    searchRequestOperationsListener.onPhaseEnd(new MockSearchPhaseContext(1, searchRequest, this), null);
import org.opensearch.search.sort.MinAndMax;
        final TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(
            },
                    result.set(iter);
        );
                new SearchRequestContext(searchRequestOperationsListener, searchRequest, () -> null),
            searchRequest.source(new SearchSourceBuilder().sort(SortBuilders.fieldSort("timestamp").order(order)));
            final SearchTransportService searchTransportService,
        super.tearDown();
            final SearchShardTarget shard,
        searchRequest.allowPartialSearchResults(true);
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(shard1, !result.get().get(0).skip());
        latch.await();
        final SearchRequestOperationsListener searchRequestOperationsListener = new SearchRequestOperationsListener.CompositeListener(
            for (SearchShardIterator i : result.get()) {
            final ClusterState clusterState,
                searchTransportService,
                new OriginalIndices(new String[] { "logs" }, SearchRequest.DEFAULT_INDICES_OPTIONS),
                };
            2,
        canMatchPhase.start();
        lookup.put("node2", new SearchAsyncActionTests.MockConnection(replicaNode));
                    ShardSearchRequest request,
            searchRequest,
        GroupShardsIterator<SearchShardIterator> shardsIter = SearchAsyncActionTests.getShardsIter(
    }
            Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY)),
        Map<String, Transport.Connection> lookup = new ConcurrentHashMap<>();
            Collections.emptyMap(),
                assertFalse(i.skip());
            @Override
 *
            logger,
        );
            latch.await();
                        Collections.emptyMap(),
        GroupShardsIterator<SearchShardIterator> shardsIter = SearchAsyncActionTests.getShardsIter(
import org.opensearch.cluster.node.DiscoveryNode;
            (iter) -> {
                    searchRequestContext
            (iter) -> new SearchPhase("test") {
        final SearchRequestOperationsListener searchRequestOperationsListener = new SearchRequestOperationsListener.CompositeListener(
                                });
                request,
                );
            @Override
            searchRequest.allowPartialSearchResults(true);
            LogManager.getLogger()
            primaryNode,
            (e) -> { throw new AssertionError("unexpected", e); }
                    searchRequestOperationsListener.onPhaseEnd(new MockSearchPhaseContext(1, searchRequest, this), null);
            new SearchRequestContext(searchRequestOperationsListener, searchRequest, () -> null),
            SearchTransportService searchTransportService = new SearchTransportService(null, null) {
    public void testInvalidSortShards() throws InterruptedException {
            "idx",
            ClusterState.EMPTY_STATE,
        ExecutorService executor = OpenSearchExecutors.newDirectExecutorService();
            final TransportSearchAction.SearchTimeProvider timeProvider,
            0,
                logger,
                            final SearchShardIterator shardIt,
            r -> InternalAggregationTestCase.emptyReduceContextBuilder()
                        if (throwException == false) {
            replicaNode
                "logs",
            2,
        };
        }
            null,
            };
            shardsIter,
                (clusterAlias, node) -> lookup.get(node),
        final DiscoveryNode replicaNode = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);
            primaryNode,
            System::nanoTime
        );
            randomBoolean(),
                    Collections.emptyMap(),
            List.of(assertingListener),
        final boolean shard1 = randomBoolean();
                public void sendCanMatch(
            null,
                        if (canMatch == false) {
import java.util.Set;
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
    public void testSortShards() throws InterruptedException {
            (clusterAlias, node) -> lookup.get(node),
/*
            0,
        final TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(
                Transport.Connection connection,
            null,
    public void testAsyncAction() throws InterruptedException {
            timeProvider,
                (clusterAlias, node) -> lookup.get(node),
        searchRequest.allowPartialSearchResults(true);
            searchRequest,
                    timeProvider,
        ) {
import java.util.stream.IntStream;
                    resultConsumer,
                        }
                            listener.onResponse(new SearchService.CanMatchResponse(shard1, null));
            CanMatchPreFilterSearchPhase canMatchPhase = new CanMatchPreFilterSearchPhase(
        searchRequest.allowPartialSearchResults(true);
                shardsIter,
            final QueryPhaseResultConsumer queryPhaseResultConsumer,
    }
        @Override
        QueryPhaseResultConsumer resultConsumer = new QueryPhaseResultConsumer(
        SearchRequestContext searchRequestContext = new SearchRequestContext(
            assertEquals(shard2, !result.get().get(1).skip());
            logger,
            null,
                    Long max = min == null ? null : randomLongBetween(min, Long.MAX_VALUE);
                ) {
        latch.await();
        lookup.put("node1", new SearchAsyncActionTests.MockConnection(primaryNode));
                    result.set(iter);
            searchRequest,
                            } else {
                    }
        AtomicReference<GroupShardsIterator<SearchShardIterator>> result = new AtomicReference<>();
import java.util.function.BiFunction;
                                @Override
        assertFalse(result.get().get(1).skip());
            response -> {},
                    ActionListener<SearchService.CanMatchResponse> listener
                listener.onResponse(new SearchService.CanMatchResponse(randomBoolean(), null));
            new SearchRequestContext(searchRequestOperationsListener, searchRequest, () -> null),
            },
                        minAndMaxes.add(minMax);
 * Licensed to Elasticsearch under one or more contributor
            response.setShardIndex(shard.getShardId().getId());
        CountDownLatch latch = new CountDownLatch(1);
 * software distributed under the License is distributed on an
            canMatchPhase.start();
                    searchRequestOperationsListener.onPhaseEnd(new MockSearchPhaseContext(1, searchRequest, this), null);
            new OriginalIndices(new String[] { "idx" }, SearchRequest.DEFAULT_INDICES_OPTIONS),
            shardsIter,
            List<ShardId> shardIds = new ArrayList<>();
        AtomicReference<GroupShardsIterator<SearchShardIterator>> result = new AtomicReference<>();
        final CanMatchPreFilterSearchPhase canMatchPhase = new CanMatchPreFilterSearchPhase(
                    boolean canMatch = frequently();
            new SearchRequestContext(searchRequestOperationsListener, searchRequest, () -> null),
                Collections.emptyMap(),
            OpenSearchExecutors.newDirectExecutorService(),
                        ) {
        };
 * the Apache License, Version 2.0 (the "License"); you may
            AtomicReference<GroupShardsIterator<SearchShardIterator>> result = new AtomicReference<>();
                        }
                        new TransportSearchAction.SearchTimeProvider(0, 0, () -> 0),
        final DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
            List.of(assertingListener),
            AtomicReference<GroupShardsIterator<SearchShardIterator>> result = new AtomicReference<>();
            int shardId = 0;
        AtomicReference<GroupShardsIterator<SearchShardIterator>> result = new AtomicReference<>();
            }
        for (SortOrder order : SortOrder.values()) {
            };
                SearchTask task,
        final TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
 *
                            shardToSkip.add(request.shardId());
                        null,
                OpenSearchExecutors.newDirectExecutorService(),
                replicaNode
            );
    }
import java.util.Comparator;
                clusterState,
        CanMatchPreFilterSearchPhase canMatchPhase = new CanMatchPreFilterSearchPhase(
        canMatchPhase.start();
            NoopTracer.INSTANCE
                        return lookup.get(node);
                concreteIndexBoosts,
    }
                }
                ActionListener<SearchService.CanMatchResponse> listener
            System.nanoTime(),
        Map<String, Transport.Connection> lookup = new ConcurrentHashMap<>();
            final GroupShardsIterator<SearchShardIterator> shardsIts,
            System.nanoTime(),
        final TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(
        protected void executePhaseOnShard(
                OpenSearchExecutors.newDirectExecutorService(),
                @Override
                }
                logger,
        final CountDownLatch latch = new CountDownLatch(1);
                    ) {
                    MinAndMax<?> minMax = min == null ? null : new MinAndMax<>(min, max);
                    new Thread(() -> {
 * compatible open source license.
        } else if (shard1 == false && shard2 == false) {
    }
                        randomIntBetween(1, 32),
                    synchronized (shardIds) {
        Map<String, Transport.Connection> lookup = new ConcurrentHashMap<>();
                        searchRequestOperationsListener.onPhaseEnd(new MockSearchPhaseContext(1, searchRequest, this), null);
    }
                @Override
        SearchDfsQueryAsyncAction(
                Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY)),
                    },
                                public void run() {
        final SearchRequest searchRequest = new SearchRequest();
                    SearchResponse.Clusters.EMPTY,
            new OriginalIndices(new String[] { "idx" }, SearchRequest.DEFAULT_INDICES_OPTIONS),
import org.opensearch.search.SearchPhaseResult;
                                }
                LogManager.getLogger()
        lookup.put("node1", new SearchAsyncActionTests.MockConnection(primaryNode));
            System::nanoTime
        SearchTransportService searchTransportService = new SearchTransportService(null, null) {
            CountDownLatch latch = new CountDownLatch(1);
    public void testAllSkippedShardGroupsAreNotSentToCanMatch() throws InterruptedException {
                @Override
        assertingListener.assertFinished();
        );
            SearchResponse.Clusters.EMPTY,
                } else {
                AbstractSearchAsyncAction<? extends SearchPhaseResult> action = new SearchDfsQueryAsyncAction(
import java.util.concurrent.CountDownLatch;
     * when subjected to max concurrent search requests. This test is a test for that situation.
                searchTransportService,
    }
            (clusterAlias, node) -> lookup.get(node),
import static org.hamcrest.CoreMatchers.is;
                return new WrappingSearchAsyncActionPhase(action) {
            canMatchPhase.start();
import java.util.List;
            super(
                        minMax = new MinAndMax<>(new BytesRef("bar"), new BytesRef("baz"));
        GroupShardsIterator<SearchShardIterator> shardsIter = SearchAsyncActionTests.getShardsIter(
            public void sendCanMatch(
            shardsIter,
                null,
            System.nanoTime(),
        DiscoveryNode replicaNode = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);
            LogManager.getLogger()
            new SearchRequestOperationsListener.CompositeListener(List.of(assertingListener), LogManager.getLogger()),
            null,
        final Map<String, Transport.Connection> lookup = new ConcurrentHashMap<>();
        canMatchPhase.start();
     * In cases that a query coordinating node held all the shards for a query, the can match phase would recurse and end in stack overflow
                @Override
                    public void run() {
            executor,
            originalIndices,
        final SearchRequestOperationsListener searchRequestOperationsListener = new SearchRequestOperationsListener.CompositeListener(
            },
    public void setUp() throws Exception {
                            };
    @Before
        DiscoveryNode replicaNode = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);
                replicaNode
        Map<String, Transport.Connection> lookup = new ConcurrentHashMap<>();
import java.util.concurrent.ExecutorService;
                    SearchTask task,
            List<ShardId> shardIds = new ArrayList<>();
import org.opensearch.core.common.Strings;
                    new Thread(() -> listener.onResponse(new SearchService.CanMatchResponse(canMatch, minMax))).start();
            OpenSearchExecutors.newDirectExecutorService(),
        CountDownLatch latch = new CountDownLatch(1);
        SearchTransportService transportService = new SearchTransportService(null, null);
                    Long min = rarely() ? null : randomLong();
                NoopTracer.INSTANCE
            final SearchRequest request,
        );
import org.opensearch.search.sort.SortBuilders;
        GroupShardsIterator<SearchShardIterator> shardsIter = SearchAsyncActionTests.getShardsIter(
            OpenSearchExecutors.newDirectExecutorService(),
            final Executor executor,
        );
            searchRequest.allowPartialSearchResults(true);
            Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY)),
            Collections.emptyMap(),
            Collections.emptyMap(),
                    Transport.Connection connection,
import org.opensearch.cluster.routing.GroupShardsIterator;
                aliasFilter,
                    Transport.Connection connection,
        List<Integer> canMatchShardIds = Collections.synchronizedList(new ArrayList<>());
        DiscoveryNode replicaNode = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);
        protected SearchPhase getNextPhase(SearchPhaseResults<DfsSearchResult> results, SearchPhaseContext context) {
            randomBoolean(),
        SearchTask task = new SearchTask(0, "n/a", "n/a", () -> "test", null, Collections.emptyMap());
 * this file be licensed under the Apache-2.0 license or a
}
            Collections.emptyMap(),
            );
            System.nanoTime(),
                randomBoolean(),
            @Override
 * this work for additional information regarding copyright
            Collections.emptyMap(),
            new SearchRequestContext(searchRequestOperationsListener, searchRequest, () -> null),
                    searchRequestOperationsListener.onPhaseEnd(new MockSearchPhaseContext(1, searchRequest, this), null);
            final SearchTask task,
                },
            logger,
            }
import org.apache.logging.log4j.Logger;
            LogManager.getLogger()
            public void sendCanMatch(
            0,
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicReference;
        Map<String, Transport.Connection> lookup = new ConcurrentHashMap<>();
        };
            }
import java.util.concurrent.Executor;
            }
        ) {
                    Collections.emptyMap(),
            assertEquals(shard1, !result.get().get(0).skip());
import org.opensearch.search.dfs.DfsSearchResult;
            }
        CanMatchPreFilterSearchPhase canMatchPhase = new CanMatchPreFilterSearchPhase(
        assertTrue(result.get().get(0).skip());
 * under the License.
                public void run() throws IOException {
                executor,
                        NoopTracer.INSTANCE
                    }
        canMatchPhase.start();
        lookup.put("node_1", new SearchAsyncActionTests.MockConnection(primaryNode));
            timeProvider,
 * SPDX-License-Identifier: Apache-2.0
            searchTransportService,
import static org.hamcrest.CoreMatchers.nullValue;
                    ShardSearchRequest request,
                    boolean canMatch = frequently();
                SearchTask task,
            final SearchRequest searchRequest = new SearchRequest();
            searchTransportService,
            logger,
    public void testLotsOfShards() throws InterruptedException {
            Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY)),
                logger,
                        if (canMatch == false) {
        );
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
        assertEquals(1, result.get().get(1).shardId().id());
        SearchPhaseController controller = new SearchPhaseController(
package org.opensearch.action.search;
                    executor,
            final SearchRequestOperationsListener searchRequestOperationsListener = new SearchRequestOperationsListener.CompositeListener(
                ActionListener<SearchService.CanMatchResponse> listener
            ) {
                        iter,
import org.apache.logging.log4j.LogManager;
import org.opensearch.search.sort.SortOrder;
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        }
                    controller,
            writableRegistry(),
        Map<String, Transport.Connection> lookup = new ConcurrentHashMap<>();
        );
                    public void run() {
            ShardId[] expected = IntStream.range(0, shardIds.size())
                public void sendCanMatch(
                        executor,
            2,
            null,
                ShardSearchRequest request,
                    if (request.shardId().id() == numShards - 1) {
        final SearchRequest searchRequest = new SearchRequest();
            searchRequest,
        GroupShardsIterator<SearchShardIterator> shardsIter = SearchAsyncActionTests.getShardsIter(
import org.opensearch.search.SearchService;
            randomBoolean(),
        if (shard1 && shard2) {
            final SearchRequest searchRequest = new SearchRequest();
                    SearchTask task,
            System::nanoTime
            searchRequest,
                null,
                    latch.countDown();
        AtomicReference<GroupShardsIterator<SearchShardIterator>> result = new AtomicReference<>();
