        final TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(  
 * this file be licensed under the Apache-2.0 license or a
                } else {
                }
                SearchTask task,
                            } else {
import java.util.concurrent.ConcurrentHashMap;  
                OpenSearchExecutors.newDirectExecutorService(),
                    ClusterState.EMPTY_STATE,
            LogManager.getLogger()  
        latch.await();
                logger,
        searchRequest.allowPartialSearchResults(true);
            OpenSearchExecutors.newDirectExecutorService(),  
                ).start();
                searchRequest,
import org.opensearch.search.builder.SearchSourceBuilder;
        );
 * SPDX-License-Identifier: Apache-2.0
                ShardSearchRequest request,
            null,
        lookup.put("node_1", new SearchAsyncActionTests.MockConnection(primaryNode));
        lookup.put("node2", new SearchAsyncActionTests.MockConnection(replicaNode));
                        ClusterState.EMPTY_STATE,
        searchRequest.allowPartialSearchResults(true);
            SearchResponse.Clusters.EMPTY,  
                        if (canMatch == false) {  
        lookup.put("node1", new SearchAsyncActionTests.MockConnection(primaryNode));  
                    shardsIter,  
                fail("can_match should not be sent to skipped shard groups");
    @After
                SearchResponse.Clusters.EMPTY,  
            null,  
    @Before
                        NoopTracer.INSTANCE
                        new ArraySearchPhaseResults<>(iter.size()),  
                new OriginalIndices(new String[] { "logs" }, SearchRequest.DEFAULT_INDICES_OPTIONS),
                    searchRequestOperationsListener.onPhaseEnd(new MockSearchPhaseContext(1, searchRequest, this), null);
        final SearchRequestOperationsListener searchRequestOperationsListener = new SearchRequestOperationsListener.CompositeListener(
                public void sendCanMatch(
        assertFalse(result.get().get(1).skip());
            canMatchPhase.start();
                public void sendCanMatch(  
            executor,
            0,
        CountDownLatch latch = new CountDownLatch(1);  
 * You may obtain a copy of the License at  
/*
import java.util.Collections;  
            final TransportSearchAction.SearchTimeProvider timeProvider,  
            ClusterState.EMPTY_STATE,  
                nodeIdToConnection,
                searchTransportService,
            0,
            ClusterState.EMPTY_STATE,
                Transport.Connection connection,  
 */  
                    ActionListener<SearchService.CanMatchResponse> listener
                timeProvider,
            LogManager.getLogger()
            public void sendCanMatch(
            }  
    private static final class SearchDfsQueryAsyncAction extends AbstractSearchAsyncAction<DfsSearchResult> {
            );  
                        Long min = randomLong();
            searchTransportService,
            }
            r -> InternalAggregationTestCase.emptyReduceContextBuilder()
                shardsIter,  
            AtomicReference<GroupShardsIterator<SearchShardIterator>> result = new AtomicReference<>();
import org.opensearch.search.sort.MinAndMax;  
            randomBoolean(),  
                                    latch.countDown();
            replicaNode  
            System.nanoTime(),
            OpenSearchExecutors.newDirectExecutorService(),
import org.opensearch.search.sort.SortOrder;
            "idx",
        searchRequest.allowPartialSearchResults(true);  
import java.util.concurrent.CountDownLatch;
            Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY)),
            );
                        responseListener,
                ) {  
            List<ShardId> shardIds = new ArrayList<>();
                Transport.Connection connection,  
        );
            new OriginalIndices(new String[] { "idx" }, SearchRequest.DEFAULT_INDICES_OPTIONS),  
            2,
                LogManager.getLogger()  
        GroupShardsIterator<SearchShardIterator> shardsIter = SearchAsyncActionTests.getShardsIter(
                clusterState,
                }
            canMatchPhase.start();  
                "logs",
            searchRequest.allowPartialSearchResults(true);  
 *
        AtomicReference<GroupShardsIterator<SearchShardIterator>> result = new AtomicReference<>();
import org.opensearch.core.index.shard.ShardId;
        DiscoveryNode replicaNode = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);
                NoopTracer.INSTANCE
            logger,  
                AbstractSearchAsyncAction<? extends SearchPhaseResult> action = new SearchDfsQueryAsyncAction(  
            2,
            List.of(assertingListener),  
                Collections.emptyMap(),
            for (SearchShardIterator i : result.get()) {  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.cluster.routing.GroupShardsIterator;
            int shardId = 0;
                boolean throwException = request.shardId().id() != 0;
            @Override
        final SearchRequestOperationsListener searchRequestOperationsListener = new SearchRequestOperationsListener.CompositeListener(
                @Override
import org.opensearch.search.internal.ShardSearchRequest;
            (clusterAlias, node) -> lookup.get(node),  
                null,
                listener,
            new SearchRequestContext(searchRequestOperationsListener, searchRequest, () -> null),
                    final MinAndMax<?> minMax;
                        latch.countDown();  
            SearchResponse.Clusters.EMPTY,  
            final Map<String, Float> concreteIndexBoosts,
            randomBoolean(),
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
            "idx",  
            Collections.emptyMap(),
            SearchResponse.Clusters.EMPTY,  
        };
    }  
                public void run() throws IOException {  
            (clusterAlias, node) -> lookup.get(node),  
                Transport.Connection connection,  
            replicaNode
        Map<String, Transport.Connection> lookup = new ConcurrentHashMap<>();  
            originalIndices,
                    if (request.shardId().id() == numShards - 1) {
                        searchRequest,  
                public void run() throws IOException {  
                SearchTask task,  
                        }
        );
import static org.hamcrest.CoreMatchers.is;  
import java.io.IOException;
                ActionListener<SearchService.CanMatchResponse> listener  
            (e) -> { throw new AssertionError("unexpected", e); }
                assertEquals(expected[pos++], i.shardId());  
        );  
    }  
                    executor,
            2,
                                listener.onResponse(new SearchPhaseResult() {
    }  
        @Override
            SearchResponse.Clusters clusters,  
public class CanMatchPreFilterSearchPhaseTests extends OpenSearchTestCase {
            final SearchRequest searchRequest = new SearchRequest();  
            final SearchRequest request,  
                @Override  
 * under the License.  
        DiscoveryNode replicaNode = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);
 * Unless required by applicable law or agreed to in writing,
            System.nanoTime(),
            primaryNode,
        shardsIter.get(0).resetAndSkip();
        assertTrue(result.get().get(0).skip());
        canMatchPhase.start();
            },
                ) {
            final QueryPhaseResultConsumer queryPhaseResultConsumer,
                ClusterState.EMPTY_STATE,  
            List.of(assertingListener),
                @Override
                (clusterAlias, node) -> lookup.get(node),
    private SearchRequestOperationsListenerAssertingListener assertingListener;
                SearchTask task,  
            searchRequest,
 * the Apache License, Version 2.0 (the "License"); you may
                Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY)),
        final TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(
        SearchTransportService searchTransportService = new SearchTransportService(null, null) {  
                    @Override  
            List<ShardId> shardIds = new ArrayList<>();  
            System::nanoTime  
 * GitHub history for details.
import org.opensearch.cluster.ClusterState;
        } else if (shard1 == false && shard2 == false) {  
            searchRequest.source(new SearchSourceBuilder().sort(SortBuilders.fieldSort("timestamp").order(order)));
                    SearchTask task,  
        final DiscoveryNode replicaNode = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);  
            (iter) -> {
        GroupShardsIterator<SearchShardIterator> shardsIter = SearchAsyncActionTests.getShardsIter(
                indexRoutings,
            List.of(assertingListener),  
            assertEquals(1, result.get().get(1).shardId().id());
            null,
                        Long max = randomLongBetween(min, Long.MAX_VALUE);  
        };  
            ) {
                    }  
                    ) {
        );
            Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY)),
            replicaNode
            final Map<String, AliasFilter> aliasFilter,  
        protected void executePhaseOnShard(
            final SearchTransportService searchTransportService,
            searchTransportService,
        canMatchPhase.start();
import org.junit.Before;
                    result.set(iter);
                Transport.Connection connection,
        final DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
            replicaNode
 *    http://www.apache.org/licenses/LICENSE-2.0
            timeProvider,
        assertingListener = new SearchRequestOperationsListenerAssertingListener();
        );  
import org.opensearch.transport.Transport;  
        Map<String, AliasFilter> aliasFilters = Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY));
import org.opensearch.test.InternalAggregationTestCase;
        final TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(
        canMatchPhase.start();
                                }  
            searchRequest,
        DiscoveryNode replicaNode = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);
    }
                searchTransportService,  
                    latch.countDown();  
            super(  
                        @Override  
                assertFalse(i.skip());
            GroupShardsIterator<SearchShardIterator> shardsIter = SearchAsyncActionTests.getShardsIter(
                    Transport.Connection connection,
            ClusterState.EMPTY_STATE,
            CanMatchPreFilterSearchPhase canMatchPhase = new CanMatchPreFilterSearchPhase(
            },
                aliasFilter,
                listener.onResponse(new SearchService.CanMatchResponse(true, null));
                }
            final SearchShardIterator shardIt,
        assertEquals(shard1, !result.get().get(0).skip());
                    }  
            shardsIter,
                        minMax = new MinAndMax<>(min, max);
            response.setShardIndex(shard.getShardId().getId());
            );  
                new ArraySearchPhaseResults<>(shardsIts.size()),  
                assertEquals(shardToSkip.contains(i.shardId()), i.skip());
        final boolean shard2 = randomBoolean();
                            shardToSkip.add(request.shardId());
        );
            public void sendCanMatch(  
    public void testInvalidSortShards() throws InterruptedException {
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
                        protected SearchPhase getNextPhase(SearchPhaseResults<SearchPhaseResult> results, SearchPhaseContext context) {
        Map<String, Transport.Connection> lookup = new ConcurrentHashMap<>();
                    Long max = min == null ? null : randomLongBetween(min, Long.MAX_VALUE);
        CountDownLatch latch = new CountDownLatch(1);
        Map<String, Transport.Connection> lookup = new ConcurrentHashMap<>();
                numShards,
        CountDownLatch latch = new CountDownLatch(1);
        CanMatchPreFilterSearchPhase canMatchPhase = new CanMatchPreFilterSearchPhase(
                    controller,
            null,
            assertFalse(result.get().get(0).skip());
            };  
    public void testAllSkippedShardGroupsAreNotSentToCanMatch() throws InterruptedException {
                assertThat(i.shardId().id(), equalTo(shardId++));
                @Override
            searchRequest,
                replicaNode
            null,
        CanMatchPreFilterSearchPhase canMatchPhase = new CanMatchPreFilterSearchPhase(  
            NoopTracer.INSTANCE
        canMatchPhase.start();  
                        searchRequestOperationsListener.onPhaseEnd(new MockSearchPhaseContext(1, searchRequest, this), null);
            final SearchRequest searchRequest = new SearchRequest();
            SearchResponse.Clusters.EMPTY,
        }
                SearchTask task,
        );
                    public void run() {  
        DiscoveryNode replicaNode = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);
                            shardToSkip.add(request.shardId());
            }
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);  
                ShardSearchRequest request,
                logger,  
import org.opensearch.core.action.ActionListener;  
            Collections.emptyMap(),  
                        @Override
            ClusterState.EMPTY_STATE,  
        Map<String, Transport.Connection> lookup = new ConcurrentHashMap<>();
                randomBoolean(),  
            primaryNode,
import java.util.ArrayList;
        CountDownLatch latch = new CountDownLatch(1);  
            () -> null
                null,  
                public void run() throws IOException {  
                        iter,
        };  
        protected SearchPhase getNextPhase(SearchPhaseResults<DfsSearchResult> results, SearchPhaseContext context) {  
        for (SortOrder order : SortOrder.values()) {  
        final CountDownLatch latch = new CountDownLatch(1);
        CanMatchPreFilterSearchPhase canMatchPhase = new CanMatchPreFilterSearchPhase(
import java.util.concurrent.Executors;
                        Collections.emptyMap(),  
            ClusterState.EMPTY_STATE,  
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
 */
        final CanMatchPreFilterSearchPhase canMatchPhase = new CanMatchPreFilterSearchPhase(  
                .map(shardIds::get)  
            assertEquals(shard1, !result.get().get(0).skip());  
            LogManager.getLogger()
                    searchRequestOperationsListener.onPhaseEnd(new MockSearchPhaseContext(1, searchRequest, this), null);
        AtomicReference<GroupShardsIterator<SearchShardIterator>> result = new AtomicReference<>();  
            }
                assertEquals(shardToSkip.contains(i.shardId()), i.skip());
            }  
        assertingListener.assertFinished();  
        assertTrue(result.get().get(0).skip());
        };  
        if (shard1 && shard2) {
                    new AbstractSearchAsyncAction<SearchPhaseResult>("test", logger, transportService, (cluster, node) -> {
                new Thread(
            List<MinAndMax<?>> minAndMaxes = new ArrayList<>();
                                public void run() {
                .sorted(Comparator.comparing(minAndMaxes::get, MinAndMax.getComparator(order)).thenComparing(shardIds::get))
     * when subjected to max concurrent search requests. This test is a test for that situation.
        final boolean shard2 = randomBoolean();
        SearchTransportService searchTransportService = new SearchTransportService(null, null) {  
            int numShards = randomIntBetween(2, 20);
            new OriginalIndices(new String[] { "idx" }, SearchRequest.DEFAULT_INDICES_OPTIONS),  
        assertThat(canMatchShardIds, equalTo(List.of(1)));  
        );  
        );
            final SearchPhaseController searchPhaseController,  
            NoopTracer.INSTANCE
                }  
 * software distributed under the License is distributed on an
            final SearchShardTarget shard,  
            NoopTracer.INSTANCE
            primaryNode,
                                @Override  
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
            null,  
            System.nanoTime(),
            searchRequest.allowPartialSearchResults(true);
     */
            "idx",
                Collections.emptyMap(),
        DiscoveryNode replicaNode = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);  
            SearchResponse.Clusters.EMPTY,
            },
                    Long min = rarely() ? null : randomLong();  
                    @Override
            searchTransportService,
        lookup.put("node1", new SearchAsyncActionTests.MockConnection(primaryNode));
            primaryNode,  
            System::nanoTime
                Transport.Connection connection,
            randomBoolean(),
        latch.await();  
            public void sendCanMatch(
        List<Integer> canMatchShardIds = Collections.synchronizedList(new ArrayList<>());  
        DiscoveryNode replicaNode = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);
                ClusterState.EMPTY_STATE,
            null,  
    }  
            task.getProgressListener(),  
                    Transport.Connection connection,
        );
        );
            shardsIter,  
            searchRequest,
                LogManager.getLogger()
            };  
            Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY)),  
                        assert cluster == null : "cluster was not null: " + cluster;
        searchRequest.allowPartialSearchResults(true);
            assertThat(result.get().size(), equalTo(numShards));
            logger,
            public void sendCanMatch(  
            CanMatchPreFilterSearchPhase canMatchPhase = new CanMatchPreFilterSearchPhase(  
import org.opensearch.Version;  
        };
        DiscoveryNode replicaNode = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);
        final ExecutorService executor = Executors.newFixedThreadPool(randomIntBetween(1, Runtime.getRuntime().availableProcessors()));
            final ClusterState clusterState,
        );  
                        latch.countDown();
                (iter) -> new SearchPhase("test") {
            }  
        QueryPhaseResultConsumer resultConsumer = new QueryPhaseResultConsumer(
                Collections.emptyMap(),  
        Map<String, Transport.Connection> lookup = new ConcurrentHashMap<>();  
            null,  
                .boxed()
                concreteIndexBoosts,  
                }
                    MinAndMax<?> minMax = min == null ? null : new MinAndMax<>(min, max);
                searchTransportService,
            Collections.emptyMap(),
            final SearchRequestOperationsListener searchRequestOperationsListener = new SearchRequestOperationsListener.CompositeListener(
        AtomicReference<GroupShardsIterator<SearchShardIterator>> result = new AtomicReference<>();
            },  
import org.opensearch.search.SearchService;  
            @Override
                @Override  
            new SearchRequestContext(searchRequestOperationsListener, searchRequest, () -> null),
            logger,  
            replicaNode
                    latch.countDown();  
        );  
        ) {
                    (clusterAlias, node) -> lookup.get(node),  
                        if (canMatch == false) {
                ShardSearchRequest request,
            System::nanoTime  
        ) {
                (clusterAlias, node) -> lookup.get(node),  
            0,  
            );
                request,  
                logger,
                ActionListener<SearchService.CanMatchResponse> listener
            searchRequestContext,
        final boolean shard1 = randomBoolean();
                    } else {
            replicaNode
import org.apache.logging.log4j.Logger;
            System.nanoTime(),
        GroupShardsIterator<SearchShardIterator> shardsIter = SearchAsyncActionTests.getShardsIter(
            final GroupShardsIterator<SearchShardIterator> shardsIts,
            AtomicReference<GroupShardsIterator<SearchShardIterator>> result = new AtomicReference<>();  
            4096,  
            timeProvider,
        @Override  
            searchTransportService,
                "logs",  
            response -> {},
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
 * this work for additional information regarding copyright
            List.of(assertingListener),
                OpenSearchExecutors.newDirectExecutorService(),  
                        }
                searchRequestContext,  
                            if (randomBoolean()) {
            final DfsSearchResult response = new DfsSearchResult(shardIt.getSearchContextId(), shard, null);  
    }
            primaryNode,  
                                });  
        SearchTransportService searchTransportService = new SearchTransportService(null, null) {
 * license agreements. See the NOTICE file distributed with
                    result.set(iter);
            for (SearchShardIterator i : result.get()) {  
            );
            executor,  
                            }  
            public void sendCanMatch(  
                    ActionListener<SearchService.CanMatchResponse> listener
                    Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY)),
                shardsIter,
                    () -> listener.onResponse(new SearchService.CanMatchResponse(request.shardId().id() == 0 ? shard1 : shard2, null))  
            System::nanoTime
    public void testSortShards() throws InterruptedException {
import org.apache.logging.log4j.LogManager;  
import org.opensearch.search.SearchShardTarget;
            randomBoolean(),
        for (SortOrder order : SortOrder.values()) {
            logger,
                        searchRequestOperationsListener.onPhaseEnd(new MockSearchPhaseContext(1, searchRequest, this), null);  
        searchRequest.allowPartialSearchResults(true);
import org.opensearch.search.internal.AliasFilter;
            (iter) -> new SearchPhase("test") {
                    @Override
        SearchPhaseController controller = new SearchPhaseController(
        AtomicReference<GroupShardsIterator<SearchShardIterator>> result = new AtomicReference<>();
            ) {
     * In cases that a query coordinating node held all the shards for a query, the can match phase would recurse and end in stack overflow  
        CountDownLatch latch = new CountDownLatch(1);  
        CanMatchPreFilterSearchPhase canMatchPhase = new CanMatchPreFilterSearchPhase(
            shardsIter,  
 * compatible open source license.
            ) {
            0,
        final Map<String, Transport.Connection> lookup = new ConcurrentHashMap<>();
            @Override
            final Logger logger,  
                request.getMaxConcurrentShardRequests(),
                SearchTask task,  
        );
import org.opensearch.search.sort.SortBuilders;
                    ShardSearchRequest request,  
        lookup.put("node1", new SearchAsyncActionTests.MockConnection(primaryNode));
                return new WrappingSearchAsyncActionPhase(action) {
        final SearchRequest searchRequest = new SearchRequest();
            };
import java.util.HashSet;
            null,  
                },  
        final SearchRequest searchRequest = new SearchRequest();
            CountDownLatch latch = new CountDownLatch(1);
        );
                        executor,
            latch.await();
package org.opensearch.action.search;
import java.util.Map;
                (iter) -> new SearchPhase("test") {
                    boolean canMatch = frequently();  
                    throw new IllegalArgumentException("boom");
    /*
                shardsIts,
                    latch.countDown();
                    searchRequestContext
        } else {  
            for (SearchShardIterator i : result.get()) {
import org.apache.lucene.util.BytesRef;
        super.setUp();  
        };
        lookup.put("node1", new SearchAsyncActionTests.MockConnection(primaryNode));  
                    boolean canMatch = frequently();  
    public void testFilterWithFailure() throws InterruptedException {  
        shardsIter.get(1).resetAndSkip();
        latch.await();
        final SearchRequestOperationsListener searchRequestOperationsListener = new SearchRequestOperationsListener.CompositeListener(
                randomBoolean(),
            new OriginalIndices(new String[] { "idx" }, SearchRequest.DEFAULT_INDICES_OPTIONS),
            null,
                    }
import java.util.stream.IntStream;
        lookup.put("node1", new SearchAsyncActionTests.MockConnection(primaryNode));  
 *
                Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY)),  
            @Override
        latch.await();  
                    searchRequestOperationsListener.onPhaseEnd(new MockSearchPhaseContext(1, searchRequest, this), null);  
                        super.run();
            (iter) -> new SearchPhase("test") {
                clusters,
                    SearchResponse.Clusters.EMPTY,
            new OriginalIndices(new String[] { "idx" }, SearchRequest.DEFAULT_INDICES_OPTIONS),
        final OriginalIndices originalIndices = new OriginalIndices(new String[] { "idx" }, SearchRequest.DEFAULT_INDICES_OPTIONS);
                    result.set(iter);
        );
            ClusterState.EMPTY_STATE,
                NoopTracer.INSTANCE
            searchRequest,
                ActionListener<SearchService.CanMatchResponse> listener  
                task,
                }
    public void testSkippedShardGroupsAreNotSentToCanMatch() throws InterruptedException {
        }
            0,  
                            };
import java.util.function.BiFunction;  
        latch.await();  
        GroupShardsIterator<SearchShardIterator> shardsIter = SearchAsyncActionTests.getShardsIter(
            new SearchRequestContext(searchRequestOperationsListener, searchRequest, () -> null),  
                ActionListener<SearchService.CanMatchResponse> listener
                @Override
            OpenSearchExecutors.newDirectExecutorService(),
                NoopTracer.INSTANCE  
                        return lookup.get(node);  
                    searchRequest,
        );  
import org.opensearch.core.common.breaker.NoopCircuitBreaker;  
        );
            Collections.emptyMap(),
                        aliasFilters,
            );
            timeProvider,
            new OriginalIndices(new String[] { "idx" }, SearchRequest.DEFAULT_INDICES_OPTIONS),  
        final TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(
            writableRegistry(),  
            CountDownLatch latch = new CountDownLatch(1);  
import java.util.List;  
            ShardId[] expected = IntStream.range(0, shardIds.size())  
        }
                primaryNode,
            searchRequest.source(new SearchSourceBuilder().sort(SortBuilders.fieldSort("timestamp").order(order)));
        lookup.put("node_2", new SearchAsyncActionTests.MockConnection(replicaNode));
            0,
                    }
            searchTransportService,
        CanMatchPreFilterSearchPhase canMatchPhase = new CanMatchPreFilterSearchPhase(  
        lookup.put("node2", new SearchAsyncActionTests.MockConnection(replicaNode));
        ActionListener<SearchResponse> responseListener = ActionListener.wrap(  
            System.nanoTime(),  
        AtomicReference<GroupShardsIterator<SearchShardIterator>> result = new AtomicReference<>();  
    public void testLotsOfShards() throws InterruptedException {  
                        }
                if (throwException && randomBoolean()) {  
            final SearchRequestOperationsListener searchRequestOperationsListener = new SearchRequestOperationsListener.CompositeListener(
        );  
        final SearchRequest searchRequest = new SearchRequest();
            final SearchActionListener<DfsSearchResult> listener
            LogManager.getLogger()  
                timeProvider,
                        minAndMaxes.add(minMax);  
        SearchTransportService searchTransportService = new SearchTransportService(null, null) {  
import java.util.concurrent.Executor;
            }
        Map<String, Transport.Connection> lookup = new ConcurrentHashMap<>();  
import java.util.concurrent.atomic.AtomicReference;
        );
            Collections.emptyMap(),  
                searchRequest,
            writableRegistry(),
        SearchTransportService searchTransportService = new SearchTransportService(null, null) {
        SearchRequestContext searchRequestContext = new SearchRequestContext(
                    new Thread(() -> {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        searchRequest.allowPartialSearchResults(true);
            Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY)),  
        Map<String, Transport.Connection> lookup = new ConcurrentHashMap<>();  
                            listener.onFailure(new NullPointerException());
            final BiFunction<String, String, Transport.Connection> nodeIdToConnection,
            }
                List.of(assertingListener),  
                ActionListener<SearchService.CanMatchResponse> listener
                    }
                        latch.countDown();
            "idx",  
        canMatchPhase.start();
import org.opensearch.test.OpenSearchTestCase;
                SearchResponse.Clusters.EMPTY,
                        protected void executePhaseOnShard(
            System::nanoTime
                    }
            Collections.emptyMap(),
 *  
            (clusterAlias, node) -> lookup.get(node),
            new NoopCircuitBreaker(CircuitBreaker.REQUEST),
                    synchronized (shardIds) {
                    latch.countDown();  
            SearchResponse.Clusters.EMPTY,  
            shardsIter,  
            List.of(assertingListener),
        SearchTransportService transportService = new SearchTransportService(null, null);
            OpenSearchExecutors.newDirectExecutorService(),  
                Transport.Connection connection,
                    searchTransportService,
                    },
                }
        executor.shutdown();
            System.nanoTime(),  
 * Modifications Copyright OpenSearch Contributors. See  
            Collections.emptyMap(),
            Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY)),  
            final SearchTask task,
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);  
                        result.set(iter);
        final SearchRequest searchRequest = new SearchRequest();
        );  
                    searchRequestOperationsListener.onPhaseEnd(new MockSearchPhaseContext(1, searchRequest, this), null);
            (clusterAlias, node) -> lookup.get(node),
            (iter) -> {
            "idx",
            (clusterAlias, node) -> lookup.get(node),
            this.listener = searchRequestContext.getSearchRequestOperationsListener();  
            searchRequest,
            (iter) -> new SearchPhase("test") {
                randomIntBetween(2, 20),
            timeProvider,
        SearchTask task = new SearchTask(0, "n/a", "n/a", () -> "test", null, Collections.emptyMap());  
        SearchDfsQueryAsyncAction(
import org.opensearch.cluster.node.DiscoveryNode;  
                    }).start();  
                        shardIds.add(request.shardId());
    }  
            GroupShardsIterator<SearchShardIterator> shardsIter = SearchAsyncActionTests.getShardsIter(
import java.util.Comparator;
            SearchTransportService searchTransportService = new SearchTransportService(null, null) {
            new SearchRequestContext(searchRequestOperationsListener, searchRequest, () -> null),
                new OriginalIndices(new String[] { "logs" }, SearchRequest.DEFAULT_INDICES_OPTIONS),  
            NoopTracer.INSTANCE
}
        assertThat(result.get(), is(nullValue()));
                        shardIds.add(request.shardId());
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
        );  
        latch.await();  
                    timeProvider,
                    task,  
            shardsIter,
        assertEquals(0, result.get().get(0).shardId().id());
            ) {
            0,
            final ActionListener<SearchResponse> listener,
            logger,
            null,
                        Collections.emptyMap(),
            "idx",
            Set<ShardId> shardToSkip = new HashSet<>();  
 */
        );
            searchTransportService,
                public void run() throws IOException {
                return new WrappingSearchAsyncActionPhase(  
        final SearchRequest searchRequest = new SearchRequest();  
            controller,
        }
        final TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(  
        final SearchRequestOperationsListener searchRequestOperationsListener = new SearchRequestOperationsListener.CompositeListener(
            ) {
    public void setUp() throws Exception {
            timeProvider,
            (clusterAlias, node) -> lookup.get(node),  
            Collections.emptyMap(),
            listener.innerOnResponse(response);
                        minMax = new MinAndMax<>(new BytesRef("bar"), new BytesRef("baz"));  
                        SearchResponse.Clusters.EMPTY,
                };
            final Map<String, Set<String>> indexRoutings,
    }
        final SearchTransportService searchTransportService = new SearchTransportService(null, null) {
            },
            Set<ShardId> shardToSkip = new HashSet<>();
    }
                        }
            assertEquals(shard2, !result.get().get(1).skip());
        assertFalse(result.get().get(1).skip()); // never skip the failure
                new SearchRequestContext(searchRequestOperationsListener, searchRequest, () -> null),
/*
                executor,
    public void tearDown() throws Exception {  
                primaryNode,  
                ActionListener<SearchService.CanMatchResponse> listener  
            logger,  
                        null,
            System::nanoTime  
            Collections.emptyMap(),
                    new Thread(() -> listener.onResponse(new SearchService.CanMatchResponse(canMatch, minMax))).start();
        ExecutorService executor = OpenSearchExecutors.newDirectExecutorService();
        lookup.put("node2", new SearchAsyncActionTests.MockConnection(replicaNode));
                canMatchShardIds.add(request.shardId().id());  
            public void sendCanMatch(
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.core.common.Strings;
            latch.await();  
                        new TransportSearchAction.SearchTimeProvider(0, 0, () -> 0),  
            shardsIter,
 * not use this file except in compliance with the License.
            @Override
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
import org.opensearch.action.OriginalIndices;
        final GroupShardsIterator<SearchShardIterator> shardsIter = SearchAsyncActionTests.getShardsIter(  
        assertEquals(1, result.get().get(1).shardId().id());  
                SearchTask task,
                ShardSearchRequest request,
        final SearchRequest searchRequest = new SearchRequest();  
        lookup.put("node2", new SearchAsyncActionTests.MockConnection(replicaNode));
                            final SearchActionListener<SearchPhaseResult> listener
            Collections.emptyMap(),
                null,
                SearchPhaseName.DFS_PRE_QUERY.getName(),
        final boolean shard1 = randomBoolean();
                    public void run() {
                            final SearchShardTarget shard,
            System.nanoTime(),  
        final TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(
            NoopTracer.INSTANCE
                        if (throwException == false) {
            shardsIter.size(),
                timeProvider,  
import org.opensearch.search.dfs.DfsSearchResult;  
            new SearchRequestContext(searchRequestOperationsListener, searchRequest, () -> null),
                                listener.onFailure(new Exception("failure"));
                            final SearchShardIterator shardIt,  
import static org.hamcrest.CoreMatchers.nullValue;
                );  
            assertEquals(0, result.get().get(0).shardId().id());
            searchRequest,
            @Override
        assertTrue(result.get().get(1).skip());  
            }
            System.nanoTime(),
                        randomIntBetween(1, 32),
        lookup.put("node2", new SearchAsyncActionTests.MockConnection(replicaNode));
import org.opensearch.core.common.breaker.CircuitBreaker;
                        }  
        private final SearchRequestOperationsListener listener;  
                @Override
        lookup.put("node2", new SearchAsyncActionTests.MockConnection(replicaNode));  
                }
                    result.set(iter);
            exc -> {}  
                        result.set(iter);
            return new SearchPhase("last") {
                        new SearchRequestContext(searchRequestOperationsListener, searchRequest, () -> null),  
                    logger,
                Collections.emptyMap(),
import java.util.Set;
 * KIND, either express or implied.  See the License for the
                    Collections.emptyMap(),
        }  
            randomBoolean(),
                    }
        super.tearDown();
        );
            final Executor executor,
            SearchTransportService searchTransportService = new SearchTransportService(null, null) {
            2,
    }  
            timeProvider,
                    SearchTask task,
                listener.onResponse(new SearchService.CanMatchResponse(randomBoolean(), null));  
        GroupShardsIterator<SearchShardIterator> shardsIter = SearchAsyncActionTests.getShardsIter(
        lookup.put("node2", new SearchAsyncActionTests.MockConnection(replicaNode));  
            null,  
/*  
                        } else {  
                new SearchRequestContext(searchRequestOperationsListener, searchRequest, () -> null),
            new SearchRequestOperationsListener.CompositeListener(List.of(assertingListener), LogManager.getLogger()),  
        }
            NoopTracer.INSTANCE  
            primaryNode,  
                    new Thread(() -> listener.onResponse(new SearchService.CanMatchResponse(canMatch, minMax))).start();
            (iter) -> new SearchPhase("test") {
                    () -> listener.onResponse(new SearchService.CanMatchResponse(request.shardId().id() == 0 ? shard1 : shard2, null))
            },
            Collections.emptyMap(),
                public void run() throws IOException {  
                .toArray(ShardId[]::new);
        );  
            OpenSearchExecutors.newDirectExecutorService(),  
        );
                    resultConsumer,  
            );
        );
        final TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(  
        lookup.put("node1", new SearchAsyncActionTests.MockConnection(primaryNode));  
    public void testAsyncAction() throws InterruptedException {
        shardsIter.get(0).resetAndSkip();  
            2,
        canMatchPhase.start();
            assertTrue(result.get().get(1).skip());
                },
        final SearchRequestOperationsListener searchRequestOperationsListener = new SearchRequestOperationsListener.CompositeListener(
                ShardSearchRequest request,
                    null,
            0,
            Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY)),
            searchRequest,
                ShardSearchRequest request,
 * Licensed to Elasticsearch under one or more contributor  
            Collections.emptyMap(),  
                new Thread(  
        );
            ) {
                            return new WrappingSearchAsyncActionPhase(this) {
            System::nanoTime
 * The OpenSearch Contributors require contributions made to  
    }  
                        ) {  
import org.opensearch.search.SearchPhaseResult;
            randomBoolean(),  
                    ShardSearchRequest request,
                );  
        final boolean shard1 = randomBoolean();  
import org.junit.After;
                null,  
                            listener.onResponse(new SearchService.CanMatchResponse(shard1, null));
                    Collections.emptyMap(),  
            LogManager.getLogger()  
import java.util.concurrent.ExecutorService;  
                    listener.onPhaseEnd(context, null);
                    synchronized (shardIds) {
            SearchRequestContext searchRequestContext
    public void testFilterShards() throws InterruptedException {  
        final TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(
            int pos = 0;  
                    public void run() {  
            System::nanoTime
                List.of(assertingListener),
 * specific language governing permissions and limitations
                ).start();
                replicaNode
        lookup.put("node1", new SearchAsyncActionTests.MockConnection(primaryNode));
