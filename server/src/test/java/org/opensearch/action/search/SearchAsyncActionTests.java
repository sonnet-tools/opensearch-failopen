 *
import org.opensearch.search.internal.InternalSearchResponse;
                SearchActionListener<TestSearchPhaseResult> listener
        int numShards = 10;
                }
                        assertTrue(searchPhaseDidRun.compareAndSet(false, true));
            true,
                    @Override
import org.opensearch.transport.Transport;
        GroupShardsIterator<SearchShardIterator> shardsIter = getShardsIter(
            ) {
                        connection.getNode()
        Map<String, Transport.Connection> lookup = new HashMap<>();
            (cluster, node) -> {
        ExecutorService executor = Executors.newFixedThreadPool(randomIntBetween(1, Runtime.getRuntime().availableProcessors()));
            request.getMaxConcurrentShardRequests(),
            executor,
 * The OpenSearch Contributors require contributions made to
        lookup.put(replicaNode.getId(), new MockConnection(replicaNode));
                        listener.onResponse(testSearchPhaseResult);
            protected SearchPhase getNextPhase(SearchPhaseResults<TestSearchPhaseResult> results, SearchPhaseContext context) {
        assertTrue(searchPhaseDidRun.get());
                    if (shardIt.remaining() > 0) {
    @Override
import org.opensearch.core.index.shard.ShardId;
 *
            @Override
            assertTrue(nodeToContextMap.get(primaryNode).toString(), nodeToContextMap.get(primaryNode).isEmpty());
            primaryNode,
            @Override
            started.addAll(initializing);
        lookup.put(replicaNode.getId(), new MockConnection(replicaNode));
import org.opensearch.core.action.ActionListener;
            assertTrue(nodeToContextMap.get(replicaNode).toString(), nodeToContextMap.get(replicaNode).isEmpty());
        assertingListener.assertFinished();
                    TestSearchPhaseResult testSearchPhaseResult = new TestSearchPhaseResult(
                    listener.onResponse(testSearchPhaseResult);
                        throw new AssertionError(e);
        public void close() {
import org.junit.After;
            Collections.emptyMap(),
        if (nodeToContextMap.containsKey(primaryNode)) {
 */
        ExecutorService executor = Executors.newFixedThreadPool(randomIntBetween(1, Runtime.getRuntime().availableProcessors()));
    }
            routing = routing.initialize(primaryNode.getId(), i + "p", 0);
        }
        public boolean isClosed() {
                    if (shardFailures[shard.getShardId().id()]) {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.routing.GroupShardsIterator;
            }
            Collections.emptyMap(),
                        }
        awaitInitialRequests.countDown();
                    } else {
                    numRequests.incrementAndGet(); // only count this once per shard copy
            aliasFilters,
            ClusterState.EMPTY_STATE,
        }
        AtomicBoolean searchPhaseDidRun = new AtomicBoolean(false);
        if (nodeToContextMap.containsKey(primaryNode)) {
                        connection.getNode()
                new SearchRequestOperationsListener.CompositeListener(List.of(assertingListener), LogManager.getLogger()),
                    public void run() {
        } else {
            }
        request.allowPartialSearchResults(false);
            ClusterState.EMPTY_STATE,
        @Override
import static org.hamcrest.Matchers.containsString;
            "idx",
                } else {
            request.getMaxConcurrentShardRequests(),
        assertEquals(shardsIter.size() - 1, numFreedContext.get());
                };
    }
        GroupShardsIterator<SearchShardIterator> shardsIter = getShardsIter(
        assertNotNull(failure.get());
        MockConnection(DiscoveryNode node) {
            List.of(assertingListener),
                new Thread(() -> {
            }
        ) {
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
                        new ShardSearchContextId(UUIDs.randomBase64UUID(), contextIdGenerator.incrementAndGet()),
            primaryNode,
            new ArraySearchPhaseResults<>(shardsIter.size()),
            logger,
            }
            ClusterState.EMPTY_STATE,
        DiscoveryNode primaryNode,
        int numConcurrent = randomIntBetween(1, 5);
            request,
    public void tearDown() throws Exception {
            SearchResponse.Clusters.EMPTY,
            numShardAttempts += it.remaining();
 * Modifications Copyright OpenSearch Contributors. See
        lookup.put(replicaNode.getId(), new MockConnection(replicaNode));
import org.opensearch.search.SearchPhaseResult;
        AtomicInteger contextIdGenerator = new AtomicInteger(0);
    ) {
            }
            },
                if (randomBoolean()) {
                request,
                if (shard.getShardId().id() == 0) {
            numShards,
    public void testFanOutAndFail() throws InterruptedException {
        );
        AtomicInteger numFreedContext = new AtomicInteger();
        latch.await();
import static org.opensearch.common.util.concurrent.ConcurrentCollections.newConcurrentMap;
        };
            transportService,
                if (randomBoolean()) {
    public static class TestSearchPhaseResult extends SearchPhaseResult {
                    new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foobar")
            new SearchRequestContext(
                });
            throw new UnsupportedOperationException();
            protected void executePhaseOnShard(
                        started.add(routing);
                throw new AssertionError("unexpected", e);
        }
import java.util.concurrent.Executors;
                    }
    @After
        // for the sake of this test we place the replica on the same node. ie. this is not a mistake since we limit per node now
            Collections.emptyMap(),
                SearchShardTarget shard,
        request.setMaxConcurrentShardRequests(randomIntBetween(1, 100));
 * software distributed under the License is distributed on an
            responseListener,
        }
import org.opensearch.action.OriginalIndices;
            null,
                    routing = routing.initialize(replicaNode.getId(), i + "r", 0);
        SearchRequest request = new SearchRequest();
        Map<String, AliasFilter> aliasFilters = Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY));
        lookup.put(primaryNode.getId(), new MockConnection(primaryNode));
                    }
                iter.resetAndSkip();
            },
            new ArraySearchPhaseResults<>(shardsIter.size()),
            }
                SearchShardIterator shardIt,
 * ownership. Elasticsearch licenses this file to you under
            List.of(assertingListener),
            logger,
                assertTrue(nodeToContextMap.get(connection.getNode()).remove(contextId));
                );
        assertFalse(nodeToContextMap.isEmpty());
                    @Override
        TestSearchPhaseResult(ShardSearchContextId contextId, DiscoveryNode node) {
        int numSkipped = 0;
                }).start();
                        new ShardSearchContextId(UUIDs.randomBase64UUID(), contextIdGenerator.incrementAndGet()),
        assertEquals(numShards, numRequests.get());
            }
            shardsIter,
            "idx",
                    testSearchPhaseResult = new TestSearchPhaseResult(
                SearchShardIterator shardIt,
        request.allowPartialSearchResults(true);
                return new SearchPhase("test") {
        Map<String, Transport.Connection> lookup = new HashMap<>();
import org.opensearch.cluster.routing.RecoverySource;
            null,
                });
                SearchActionListener<TestSearchPhaseResult> listener
    }
                };
        assertEquals(shardsIter.size(), searchResponse.getSuccessfulShards());
        AbstractSearchAsyncAction<TestSearchPhaseResult> asyncAction = new AbstractSearchAsyncAction<TestSearchPhaseResult>(
import java.io.IOException;
            SearchResponse.Clusters.EMPTY,
                    }
            assertTrue(nodeToContextMap.get(replicaNode).toString(), nodeToContextMap.get(replicaNode).isEmpty());
            aliasFilters,
        Map<String, AliasFilter> aliasFilters = Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY));
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
        SearchTransportService transportService = new SearchTransportService(null, null) {
                    }
import org.opensearch.cluster.routing.UnassignedInfo;
            primaryNode,
import org.opensearch.transport.TransportException;
        GroupShardsIterator<SearchShardIterator> shardsIter = getShardsIter(
                new ShardId(new Index(index, "_na_"), i),
            (e) -> { throw new AssertionError("unexpected", e); }
                () -> null
            request.getMaxConcurrentShardRequests(),
            randomBoolean(),
        AbstractSearchAsyncAction<TestSearchPhaseResult> asyncAction = new AbstractSearchAsyncAction<TestSearchPhaseResult>(
            request,
            started.add(routing);
        } else {
            (cluster, node) -> {
            aliasFilters,
            Collections.emptyMap(),
                request,
        boolean doReplicas,
                        assertingListener.onPhaseEnd(new MockSearchPhaseContext(1, request, this), null);
            }
            new ArraySearchPhaseResults<>(shardsIter.size()),
            super(InternalSearchResponse.empty(), null, 0, 0, 0, 0L, ShardSearchFailure.EMPTY_ARRAY, Clusters.EMPTY, null);
 */
                    } catch (InterruptedException e) {
        final SearchRequestOperationsListener searchRequestOperationsListener = new SearchRequestOperationsListener.CompositeListener(
        assertFalse(nodeToContextMap.isEmpty());
                return new SearchPhase("test") {
            SearchResponse.Clusters.EMPTY,
                final TestSearchPhaseResult testSearchPhaseResult;
    }
            response -> {},
                return new SearchPhase("test") {
            ClusterState.EMPTY_STATE,
        AtomicInteger numFreedContext = new AtomicInteger();
            }
            protected SearchPhase getNextPhase(SearchPhaseResults<TestSearchPhaseResult> results, SearchPhaseContext context) {
                    if (randomBoolean()) {
 * this file be licensed under the Apache-2.0 license or a
            public void sendFreeContext(Transport.Connection connection, ShardSearchContextId contextId, OriginalIndices originalIndices) {
        Map<ShardId, Boolean> seenShard = new ConcurrentHashMap<>();
        SearchRequest request = new SearchRequest();
        final CountDownLatch latch = new CountDownLatch(numShards);
        assertTrue(nodeToContextMap.toString(), nodeToContextMap.containsKey(primaryNode) || nodeToContextMap.containsKey(replicaNode));
        executor.shutdown();
                    try {
                assertTrue("shard: " + shard.getShardId() + " has been queried twice", response.queried.add(shard.getShardId()));
            request,
            @Override
        latch.await();
        public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options)
 * the Apache License, Version 2.0 (the "License"); you may
                    }
            (cluster, node) -> {
        int numShards = randomIntBetween(5, 10);
        );
                }
                SearchShardIterator shardIt,
                    TestSearchPhaseResult testSearchPhaseResult = new TestSearchPhaseResult(
                    );
        AtomicInteger contextIdGenerator = new AtomicInteger(0);
            Collections.emptyMap(),
        assertThat(numFailReplicas.get(), greaterThanOrEqualTo(1));
            request.getMaxConcurrentShardRequests(),
        AtomicInteger numRequests = new AtomicInteger(0);
        SearchRequest request = new SearchRequest();
        @Override
 * Licensed to Elasticsearch under one or more contributor
            ShardRouting routing = ShardRouting.newUnassigned(
        // for the sake of this test we place the replica on the same node. ie. this is not a mistake since we limit per node now
            new OriginalIndices(new String[] { "idx" }, SearchRequest.DEFAULT_INDICES_OPTIONS),
}
        CountDownLatch latch = new CountDownLatch(numShardAttempts);
            }
        AtomicInteger numRequests = new AtomicInteger(0);
            @Override
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(0, searchResponse.getFailedShards());
            (cluster, node) -> {
                });
import java.util.HashMap;
        latch.await();
import org.opensearch.search.internal.ShardSearchContextId;
        ActionListener<SearchResponse> responseListener = ActionListener.wrap(
import java.util.Collections;
                numSkipped++;
                        initializing.add(routing);
            null,
            LogManager.getLogger()
 * not use this file except in compliance with the License.
            },
            if (iter.shardId().id() % 2 == 0) {
            public void sendFreeContext(Transport.Connection connection, ShardSearchContextId contextId, OriginalIndices originalIndices) {
                SearchShardTarget shard,
            list.add(new SearchShardIterator(null, new ShardId(new Index(index, "_na_"), i), started, originalIndices));
                        new ShardSearchContextId(UUIDs.randomBase64UUID(), contextIdGenerator.incrementAndGet()),
        SearchTransportService transportService = new SearchTransportService(null, null) {
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
                    );
                    public void run() {
                        responseListener.onResponse(response);
    }
            }
                latch.countDown();
                );
 *
 * You may obtain a copy of the License at
                    return Boolean.TRUE;
        }
                        routing.started();
            shardsIter,
        assertNotNull(response.get());
            this.contextId = contextId;
            replicaNode
            responseListener,
            new TransportSearchAction.SearchTimeProvider(0, 0, () -> 0),
                    return Boolean.TRUE;
    @Before
                super.executeNext(runnable, originalThread);
        }
            new SearchRequestContext(searchRequestOperationsListener, request, () -> null),
        assertEquals(shardsIter.size() - numSkipped, numRequests.get());
                    new Thread(() -> listener.onResponse(testSearchPhaseResult)).start();
            shardsIter,
                        numFailReplicas.incrementAndGet();
        int numShards,
        latch.await();
            },
                SearchShardTarget shard,
        }
        assertingListener = new SearchRequestOperationsListenerAssertingListener();
    public static final class MockConnection implements Transport.Connection {
            @Override
            new ArraySearchPhaseResults<>(shardsIter.size()),
        SearchTransportService transportService = new SearchTransportService(null, null);
        request.allowPartialSearchResults(true);
        }
            transportService,
            }
                    listener.onResponse(testSearchPhaseResult);
                SearchActionListener<TestSearchPhaseResult> listener
        for (SearchShardIterator iter : shardsIter) {
                seenShard.computeIfAbsent(shard.getShardId(), (i) -> {
        }
            protected void executeNext(Runnable runnable, Thread originalThread) {
        int numShardAttempts = 0;
        request.setMaxConcurrentShardRequests(numConcurrent);
                latch.countDown();
        Map<ShardId, Boolean> seenShard = new ConcurrentHashMap<>();
        Map<String, Transport.Connection> lookup = new HashMap<>();
                    }
/*
        );
                assert cluster == null : "cluster was not null: " + cluster;
            TestSearchResponse response = new TestSearchResponse();
 * Unless required by applicable law or agreed to in writing,
        for (SearchShardIterator it : shardsIter) {
                SearchShardIterator shardIt,
            routing.started();
                return lookup.get(node);
        };
        public void writeTo(StreamOutput out) throws IOException {
            Collections.emptyMap(),
        AbstractSearchAsyncAction<TestSearchPhaseResult> asyncAction = new AbstractSearchAsyncAction<TestSearchPhaseResult>(
import java.util.List;
        public void addCloseListener(ActionListener<Void> listener) {
                        searchRequestOperationsListener.onPhaseEnd(new MockSearchPhaseContext(1, request, this), null);
import org.opensearch.common.UUIDs;
        Map<ShardId, Boolean> seenShard = new ConcurrentHashMap<>();
            "test",
                        searchRequestOperationsListener.onPhaseEnd(new MockSearchPhaseContext(1, request, this), null);
            if (shardFailures[i] == null) {
                } else {
                ids.add(testSearchPhaseResult.getContextId());
        public DiscoveryNode getNode() {
import java.util.Set;
        final SearchRequestOperationsListener searchRequestOperationsListener = new SearchRequestOperationsListener.CompositeListener(
                return lookup.get(node);
            primaryNode,
        AbstractSearchAsyncAction<TestSearchPhaseResult> asyncAction = new AbstractSearchAsyncAction<TestSearchPhaseResult>(
            ArrayList<ShardRouting> initializing = new ArrayList<>();
            replicaNode
        );
/*
            @Override
        final SearchRequestOperationsListener searchRequestOperationsListener = new SearchRequestOperationsListener.CompositeListener(
            ) {
            }
        AtomicBoolean searchPhaseDidRun = new AtomicBoolean(false);
            }
    static GroupShardsIterator<SearchShardIterator> getShardsIter(
            );
import java.util.concurrent.CountDownLatch;
 * KIND, either express or implied.  See the License for the
            exc -> {
                SearchShardTarget shard,
            @Override
                Set<ShardSearchContextId> ids = nodeToContextMap.computeIfAbsent(connection.getNode(), (n) -> newConcurrentSet());
                new SearchRequestOperationsListener.CompositeListener(List.of(assertingListener), LogManager.getLogger()),
            transportService,
 * this work for additional information regarding copyright
            ),
                true,
                routing = ShardRouting.newUnassigned(
import org.opensearch.cluster.node.DiscoveryNode;
                TestSearchPhaseResult testSearchPhaseResult = new TestSearchPhaseResult(
            TestSearchResponse response = new TestSearchResponse();
                    connection.getNode()
            @Override
    }
        int numShards = randomIntBetween(5, 10);
                    false,
        Map<String, AliasFilter> aliasFilters = Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY));
        AtomicInteger contextIdGenerator = new AtomicInteger(0);
            doReplicas,
        );
            request.getMaxConcurrentShardRequests(),
        }
                        listener.onFailure(new RuntimeException());
                super.executeNext(runnable, originalThread);
            }
            SearchResponse.Clusters.EMPTY,
            },
import java.util.concurrent.ConcurrentHashMap;
            protected SearchPhase getNextPhase(SearchPhaseResults<TestSearchPhaseResult> results, SearchPhaseContext context) {
                        listener.onResponse(testSearchPhaseResult);
                assert cluster == null : "cluster was not null: " + cluster;
            Collections.shuffle(started, random());
                        connection.getNode()
            }
                    @Override
        SearchResponse searchResponse = asyncAction.buildSearchResponse(null, asyncAction.buildShardFailures(), null, null);
                };
            logger,
        boolean doReplicas = randomBoolean();
            executor,
        @Override
        for (int i = 0; i < shardFailures.length; i++) {
                failure.set(exc);
            new ArraySearchPhaseResults<>(shardsIter.size()),
        String index,
        };
        TestSearchResponse() {
                    }
            null,
            }
    @Override
            NoopTracer.INSTANCE
            protected void executeNext(Runnable runnable, Thread originalThread) {
                    return Boolean.TRUE;
                Transport.Connection connection = getConnection(null, shard.getNodeId());
                SearchShardTarget shard,
                    );
            new SearchRequestContext(searchRequestOperationsListener, request, () -> null),
            shardsIter,
        assertTrue(searchPhaseDidRun.get());
                        assertTrue(searchPhaseDidRun.compareAndSet(false, true));
        Map<DiscoveryNode, Set<ShardSearchContextId>> nodeToContextMap = newConcurrentMap();
            randomBoolean(),
 * compatible open source license.
        @Override
                }
                }).start();
            responseListener,
        Map<DiscoveryNode, Set<ShardSearchContextId>> nodeToContextMap = newConcurrentMap();
            new TransportSearchAction.SearchTimeProvider(0, 0, () -> 0),
            protected SearchPhase getNextPhase(SearchPhaseResults<TestSearchPhaseResult> results, SearchPhaseContext context) {
        AtomicReference<TestSearchResponse> response = new AtomicReference<>();
                    Transport.Connection connection = getConnection(null, shard.getNodeId());
    public void testAllowPartialResults() throws InterruptedException {
            searchResponse -> response.set((TestSearchResponse) searchResponse),
                        new ShardSearchContextId(UUIDs.randomBase64UUID(), contextIdGenerator.incrementAndGet()),
        CountDownLatch awaitInitialRequests = new CountDownLatch(1);
                } else {
                super.executeNext(runnable, originalThread);
        AtomicInteger numFailReplicas = new AtomicInteger(0);
            @Override
import org.opensearch.transport.TransportRequest;
            Collections.emptyMap(),
            (e) -> { throw new AssertionError("unexpected", e); }
        AbstractSearchAsyncAction<TestSearchPhaseResult> asyncAction = new AbstractSearchAsyncAction<TestSearchPhaseResult>(
    public void setUp() throws Exception {
        final Set<ShardId> queried = new HashSet<>();
            response -> {},
            replicaNode
                numFreedContext.incrementAndGet();
        lookup.put(primaryNode.getId(), new MockConnection(primaryNode));
        lookup.put(primaryNode.getId(), new MockConnection(primaryNode));
    }
                    numRequests.incrementAndGet(); // only count this once per replica
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            aliasFilters,
                RecoverySource.EmptyStoreRecoverySource.INSTANCE,
        Map<String, Transport.Connection> lookup = new HashMap<>();
            protected void executeNext(Runnable runnable, Thread originalThread) {
        Map<String, AliasFilter> aliasFilters = Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY));
                assertTrue("shard: " + shard.getShardId() + " has been queried twice", response.queried.add(shard.getShardId()));
        request.allowPartialSearchResults(true);
                        connection.getNode()
                            sendReleaseSearchContext(result.getContextId(), new MockConnection(result.node), OriginalIndices.NONE);
        );
                    public void run() {
                    Transport.Connection connection = getConnection(null, shard.getNodeId());
                () -> null
                }).start();
            Collections.emptyMap(),
            null,
                    Transport.Connection connection = getConnection(null, shard.getNodeId());
                    TestSearchPhaseResult testSearchPhaseResult = new TestSearchPhaseResult(
            new OriginalIndices(new String[] { "idx" }, SearchRequest.DEFAULT_INDICES_OPTIONS),
import org.opensearch.Version;
            aliasFilters,
 * GitHub history for details.
            NoopTracer.INSTANCE
    public void testFanOutAndCollect() throws InterruptedException {
                    } else {
        ) {
import java.util.ArrayList;
            "test",
            (e) -> { throw new AssertionError("unexpected", e); }
                    testSearchPhaseResult = new TestSearchPhaseResult(null, connection.getNode());
            @Override
import org.opensearch.search.SearchShardTarget;
        SearchRequest request = new SearchRequest();
            (cluster, node) -> {
            return node;
        GroupShardsIterator<SearchShardIterator> shardsIter = getShardsIter(
                    public void run() {
        assertThat(failure.get().getCause().getMessage(), containsString("boom"));
                        awaitInitialRequests.await();
            NoopTracer.INSTANCE
        DiscoveryNode replicaNode = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);
                }
                new Thread(() -> {
                    new ShardSearchContextId(UUIDs.randomBase64UUID(), contextIdGenerator.incrementAndGet()),
            ),
        OriginalIndices originalIndices,
                SearchActionListener<TestSearchPhaseResult> listener
        AtomicBoolean searchPhaseDidRun = new AtomicBoolean(false);
        DiscoveryNode replicaNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
            new SearchRequestContext(searchRequestOperationsListener, request, () -> null),
/*
        );
        assertEquals(numSkipped, searchResponse.getSkippedShards());
        GroupShardsIterator<SearchShardIterator> shardsIter = getShardsIter(
                    @Override
                };
            ) {
                super.executeNext(runnable, originalThread);
        );
            protected void executePhaseOnShard(
        @Override
 * under the License.
            "idx",
            throws TransportException {
                if (failure && doReplicas) {
import org.opensearch.transport.TransportRequestOptions;
        AtomicInteger contextIdGenerator = new AtomicInteger(0);
        lookup.put(primaryNode.getId(), new MockConnection(primaryNode));
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
        int numConcurrent = randomIntBetween(1, 5);
                    }
        ) {
import org.opensearch.core.common.io.stream.StreamOutput;
        assertEquals(shardsIter.size(), numFreedContext.get());
            @Override
            replicaNode
            this.node = node;
        latch.await();
        ActionListener<SearchResponse> responseListener = ActionListener.wrap(
                assertTrue(nodeToContextMap.containsKey(connection.getNode()));
 * SPDX-License-Identifier: Apache-2.0
                latch.countDown();
            numShards,
    private SearchRequestOperationsListenerAssertingListener assertingListener;
        AtomicInteger contextIdGenerator = new AtomicInteger(0);
            List.of(assertingListener),
                    RecoverySource.PeerRecoverySource.INSTANCE,
                    } else {
        request.allowPartialSearchResults(true);
        super.setUp();
            protected void executePhaseOnShard(
            numShards,
            }
            NoopTracer.INSTANCE
            "test",
            new OriginalIndices(new String[] { "idx" }, SearchRequest.DEFAULT_INDICES_OPTIONS),
        asyncAction.start();
            request,
            protected void executePhaseOnShard(
 */
        ArrayList<SearchShardIterator> list = new ArrayList<>();
        }
            }
                        listener.onFailure(new RuntimeException());
                latch.countDown();
            new OriginalIndices(new String[] { "idx" }, SearchRequest.DEFAULT_INDICES_OPTIONS),
                        throw new RuntimeException("boom");
        asyncAction.start();
                        for (int i = 0; i < results.getNumShards(); i++) {
        ActionListener<SearchResponse> responseListener = ActionListener.wrap(
            response -> {},
                    public void run() {
        };
            new TransportSearchAction.SearchTimeProvider(0, 0, () -> 0),
    }
                    }
            @Override
            this.node = node;
            protected void executePhaseOnShard(
        asyncAction.start();
            LogManager.getLogger()
                            assertEquals(result.node.getId(), result.getSearchShardTarget().getNodeId());
                assert cluster == null : "cluster was not null: " + cluster;
        }
                    Set<ShardSearchContextId> ids = nodeToContextMap.computeIfAbsent(connection.getNode(), (n) -> newConcurrentSet());
        request.setMaxConcurrentShardRequests(numConcurrent);
        ) {
        @Override
        CountDownLatch latch = new CountDownLatch(numShardAttempts);
            null,
        executor.shutdown();
        final DiscoveryNode node;
        ActionListener<SearchResponse> responseListener = ActionListener.wrap(
        assertTrue(searchPhaseDidRun.get());
    }
            new TransportSearchAction.SearchTimeProvider(0, 0, () -> 0),
        SearchTransportService transportService = new SearchTransportService(null, null);
        };
        DiscoveryNode replicaNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
            new TransportSearchAction.SearchTimeProvider(0, 0, () -> 0),
            LogManager.getLogger()
        Map<String, AliasFilter> aliasFilters = Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY));
                    unassigned.add(routing); // unused yet
                return new SearchPhase("test") {
                shardFailures[i] = failure;
        DiscoveryNode replicaNode = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
import java.util.concurrent.ExecutorService;
        );
            protected SearchPhase getNextPhase(SearchPhaseResults<TestSearchPhaseResult> results, SearchPhaseContext context) {
        );
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
            (e) -> {
                        assertTrue(searchPhaseDidRun.compareAndSet(false, true));
        asyncAction.start();
            SearchResponse.Clusters.EMPTY,
        int numShards = randomIntBetween(2, 10);
            request,
            NoopTracer.INSTANCE
                    numRequests.incrementAndGet(); // only count this once per shard copy
import org.opensearch.core.common.Strings;
        return new GroupShardsIterator<>(list);
            "test",
    }
                SearchActionListener<TestSearchPhaseResult> listener
                } else {
            return false;
import java.util.concurrent.atomic.AtomicReference;
        ) {
        DiscoveryNode replicaNode = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);
package org.opensearch.action.search;
        int numShardAttempts = numShards;
            null,
            randomBoolean(),
            primaryNode,
import org.junit.Before;
        DiscoveryNode replicaNode
        AtomicInteger numRequests = new AtomicInteger(0);
            if (doReplicas) {
                new Thread(() -> {
                if (replicaNode != null) {
        lookup.put(primaryNode.getId(), new MockConnection(primaryNode));
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                    new ShardId(new Index(index, "_na_"), i),
            replicaNode
    public static class TestSearchResponse extends SearchResponse {
            assertTrue(nodeToContextMap.get(primaryNode).toString(), nodeToContextMap.get(primaryNode).isEmpty());
            responseListener,
            ) {
                Transport.Connection connection = getConnection(null, shard.getNodeId());
                assert cluster == null : "cluster was not null: " + cluster;
            logger,
            "idx",
            "test",
                    ids.add(testSearchPhaseResult.getContextId());
                latch.countDown();
import java.util.Map;
        );
        SearchTransportService transportService = new SearchTransportService(null, null);
        for (int i = 0; i < numShards; i++) {
                return lookup.get(node);
        CountDownLatch latch = new CountDownLatch(numShards - numSkipped);
        }
            transportService,
            new OriginalIndices(new String[] { "idx" }, SearchRequest.DEFAULT_INDICES_OPTIONS),
                assertTrue(nodeToContextMap.get(connection.getNode()).remove(contextId));
            ) {
            Collections.emptyMap(),
        // at least one response otherwise the entire request fails
import java.util.HashSet;
                    );
import java.util.concurrent.atomic.AtomicBoolean;
        }
        lookup.put(replicaNode.getId(), new MockConnection(replicaNode));
        };
        lookup.put(replicaNode.getId(), new MockConnection(replicaNode));
        request.setMaxConcurrentShardRequests(randomIntBetween(1, 100));
import org.apache.logging.log4j.LogManager;
            new SearchRequestContext(
            responseListener,
                            TestSearchPhaseResult result = results.getAtomicArray().get(i);
        Boolean[] shardFailures = new Boolean[numShards];
                }
                return lookup.get(node);
                return new SearchPhase("test") {
        assertEquals(numConcurrent, numRequests.get());
            shardsIter,
        ActionListener<SearchResponse> responseListener = ActionListener.wrap(
        private final DiscoveryNode node;
 * specific language governing permissions and limitations
                assert cluster == null : "cluster was not null: " + cluster;
            transportService,
    public void testLimitConcurrentShardRequests() throws InterruptedException {
            @Override
            @Override
        CountDownLatch latch = new CountDownLatch(1);
            protected void executeNext(Runnable runnable, Thread originalThread) {
        );
                        searchRequestOperationsListener.onPhaseEnd(new MockSearchPhaseContext(1, request, this), null);
        AtomicReference<Exception> failure = new AtomicReference<>();
                SearchShardIterator shardIt,
                return lookup.get(node);
                seenShard.computeIfAbsent(shard.getShardId(), (i) -> {
public class SearchAsyncActionTests extends OpenSearchTestCase {
import org.opensearch.cluster.ClusterState;
                    new Thread(() -> listener.onResponse(testSearchPhaseResult)).start();
        int numShards = randomIntBetween(1, 10);
            numShards,
import static org.opensearch.common.util.concurrent.ConcurrentCollections.newConcurrentSet;
        shardFailures[randomIntBetween(0, shardFailures.length - 1)] = false;
import org.opensearch.cluster.routing.ShardRouting;
            "idx",
        assertTrue(nodeToContextMap.toString(), nodeToContextMap.containsKey(primaryNode) || nodeToContextMap.containsKey(replicaNode));
import org.opensearch.search.internal.AliasFilter;
                numFreedContext.incrementAndGet();
        Map<String, Transport.Connection> lookup = new HashMap<>();
        super.tearDown();
                new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foobar")
                boolean failure = randomBoolean();
                    numShardAttempts++;
                seenShard.computeIfAbsent(shard.getShardId(), (i) -> {
        }
            ArrayList<ShardRouting> unassigned = new ArrayList<>();
            ArrayList<ShardRouting> started = new ArrayList<>();
            throw new UnsupportedOperationException();
            numShards,
        );
                };
                assertTrue(nodeToContextMap.containsKey(connection.getNode()));
                    listener.onResponse(testSearchPhaseResult);
                    @Override
            searchResponse -> { throw new AssertionError("unexpected response"); },
        assertEquals(numShards, numRequests.get());
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            @Override
        SearchRequest request = new SearchRequest();
            Collections.emptyMap(),
            null,
        };
    public void testSkipSearchShards() throws InterruptedException {
            @Override
                assertNotNull(contextId);
            ClusterState.EMPTY_STATE,
import org.opensearch.core.index.Index;
        asyncAction.start();
            }
            }
import java.util.concurrent.atomic.AtomicInteger;
            logger,
