                } else {
                        searchRequestOperationsListener.onPhaseEnd(new MockSearchPhaseContext(1, request, this), null);
            this.node = node;
        AbstractSearchAsyncAction<TestSearchPhaseResult> asyncAction = new AbstractSearchAsyncAction<TestSearchPhaseResult>(
import java.util.HashSet;  
import java.util.Set;  
                ids.add(testSearchPhaseResult.getContextId());
        assertEquals(numShards, numRequests.get());
            }
        AtomicInteger contextIdGenerator = new AtomicInteger(0);
        SearchTransportService transportService = new SearchTransportService(null, null);
        latch.await();
            new OriginalIndices(new String[] { "idx" }, SearchRequest.DEFAULT_INDICES_OPTIONS),
        assertEquals(shardsIter.size(), searchResponse.getSuccessfulShards());
        executor.shutdown();
        AtomicReference<Exception> failure = new AtomicReference<>();  
    @After
            request,
                    connection.getNode()
            (cluster, node) -> {
            if (shardFailures[i] == null) {
                return lookup.get(node);
            started.add(routing);  
            List.of(assertingListener),
            protected void executePhaseOnShard(
            Collections.emptyMap(),
        );  
/*
            started.addAll(initializing);  
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
                return lookup.get(node);
            transportService,
                seenShard.computeIfAbsent(shard.getShardId(), (i) -> {  
                });
            LogManager.getLogger()
                    }  
                    new ShardSearchContextId(UUIDs.randomBase64UUID(), contextIdGenerator.incrementAndGet()),
                        new ShardSearchContextId(UUIDs.randomBase64UUID(), contextIdGenerator.incrementAndGet()),  
        asyncAction.start();
                RecoverySource.EmptyStoreRecoverySource.INSTANCE,
import static org.opensearch.common.util.concurrent.ConcurrentCollections.newConcurrentSet;
                };
                super.executeNext(runnable, originalThread);
            new TransportSearchAction.SearchTimeProvider(0, 0, () -> 0),
                        assertTrue(searchPhaseDidRun.compareAndSet(false, true));
        asyncAction.start();
        assertingListener.assertFinished();  
            super(InternalSearchResponse.empty(), null, 0, 0, 0, 0L, ShardSearchFailure.EMPTY_ARRAY, Clusters.EMPTY, null);
            (e) -> { throw new AssertionError("unexpected", e); }  
                    listener.onResponse(testSearchPhaseResult);  
            replicaNode
                    try {
                routing = ShardRouting.newUnassigned(
                    }
        }  
            protected SearchPhase getNextPhase(SearchPhaseResults<TestSearchPhaseResult> results, SearchPhaseContext context) {
        executor.shutdown();
            @Override  
        DiscoveryNode replicaNode
            null,
        OriginalIndices originalIndices,
        ActionListener<SearchResponse> responseListener = ActionListener.wrap(
 * the Apache License, Version 2.0 (the "License"); you may
        SearchTransportService transportService = new SearchTransportService(null, null) {
                    ids.add(testSearchPhaseResult.getContextId());  
import org.opensearch.search.SearchPhaseResult;  
                    routing = routing.initialize(replicaNode.getId(), i + "r", 0);  
package org.opensearch.action.search;
                        throw new RuntimeException("boom");
        Map<String, Transport.Connection> lookup = new HashMap<>();
                }).start();
        };
        SearchRequest request = new SearchRequest();
            }
        }  
        latch.await();
            executor,  
            protected SearchPhase getNextPhase(SearchPhaseResults<TestSearchPhaseResult> results, SearchPhaseContext context) {  
            throw new UnsupportedOperationException();
        for (SearchShardIterator iter : shardsIter) {  
            new SearchRequestContext(searchRequestOperationsListener, request, () -> null),
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        CountDownLatch latch = new CountDownLatch(numShardAttempts);
            logger,  
            shardsIter,  
            assertTrue(nodeToContextMap.get(primaryNode).toString(), nodeToContextMap.get(primaryNode).isEmpty());  
                return new SearchPhase("test") {
                    if (shardFailures[shard.getShardId().id()]) {  
            ) {
        assertTrue(searchPhaseDidRun.get());
    public void testFanOutAndFail() throws InterruptedException {
        }
        );
        };
            new SearchRequestContext(searchRequestOperationsListener, request, () -> null),
    }  
            protected void executeNext(Runnable runnable, Thread originalThread) {
            transportService,
            Collections.emptyMap(),
            new TransportSearchAction.SearchTimeProvider(0, 0, () -> 0),
 * The OpenSearch Contributors require contributions made to  
        GroupShardsIterator<SearchShardIterator> shardsIter = getShardsIter(
                return new SearchPhase("test") {  
        lookup.put(primaryNode.getId(), new MockConnection(primaryNode));
            ) {
                    public void run() {
        assertEquals(0, searchResponse.getFailedShards());
            doReplicas,  
import org.opensearch.core.index.Index;
            @Override
                assert cluster == null : "cluster was not null: " + cluster;
        assertTrue(searchPhaseDidRun.get());  
import org.opensearch.core.common.io.stream.StreamOutput;  
            LogManager.getLogger()  
import org.opensearch.cluster.routing.UnassignedInfo;
        AbstractSearchAsyncAction<TestSearchPhaseResult> asyncAction = new AbstractSearchAsyncAction<TestSearchPhaseResult>(
            protected void executePhaseOnShard(
                        awaitInitialRequests.await();  
 */
                    public void run() {
                seenShard.computeIfAbsent(shard.getShardId(), (i) -> {
                    Transport.Connection connection = getConnection(null, shard.getNodeId());
        );
            }  
    }
 * under the License.  
        public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options)  
        };  
                SearchShardIterator shardIt,
        for (SearchShardIterator it : shardsIter) {
            searchResponse -> { throw new AssertionError("unexpected response"); },
                }).start();
            "idx",  
import org.apache.logging.log4j.LogManager;  
import org.opensearch.transport.TransportRequest;  
                        connection.getNode()
        SearchResponse searchResponse = asyncAction.buildSearchResponse(null, asyncAction.buildShardFailures(), null, null);  
        request.allowPartialSearchResults(true);  
                shardFailures[i] = failure;  
                boolean failure = randomBoolean();
                if (randomBoolean()) {
        );
            shardsIter,  
            }
            }
                        listener.onFailure(new RuntimeException());
                    new Thread(() -> listener.onResponse(testSearchPhaseResult)).start();
            Collections.emptyMap(),
        SearchRequest request = new SearchRequest();
                final TestSearchPhaseResult testSearchPhaseResult;  
                numFreedContext.incrementAndGet();  
            );  
                };
/*
            ),
            this.contextId = contextId;  
                assertTrue(nodeToContextMap.containsKey(connection.getNode()));  
            new OriginalIndices(new String[] { "idx" }, SearchRequest.DEFAULT_INDICES_OPTIONS),
 *    http://www.apache.org/licenses/LICENSE-2.0
                        new ShardSearchContextId(UUIDs.randomBase64UUID(), contextIdGenerator.incrementAndGet()),
        String index,  
                        listener.onResponse(testSearchPhaseResult);  
                    TestSearchPhaseResult testSearchPhaseResult = new TestSearchPhaseResult(
                        started.add(routing);  
 * license agreements. See the NOTICE file distributed with
                    }  
        ) {
            new TransportSearchAction.SearchTimeProvider(0, 0, () -> 0),
            null,  
        }
                    @Override  
            "test",  
        boolean doReplicas,  
        assertNotNull(failure.get());  
                if (failure && doReplicas) {
            primaryNode,
            primaryNode,
import org.opensearch.core.common.Strings;
        return new GroupShardsIterator<>(list);  
        ) {  
        );  
                    testSearchPhaseResult = new TestSearchPhaseResult(
                    public void run() {
        AtomicReference<TestSearchResponse> response = new AtomicReference<>();
        SearchRequest request = new SearchRequest();
import org.opensearch.cluster.ClusterState;  
                latch.countDown();
            replicaNode
            transportService,
            },
                    numRequests.incrementAndGet(); // only count this once per shard copy  
            return node;
                return lookup.get(node);
                SearchShardTarget shard,
        lookup.put(primaryNode.getId(), new MockConnection(primaryNode));
                return lookup.get(node);
        shardFailures[randomIntBetween(0, shardFailures.length - 1)] = false;
            new TransportSearchAction.SearchTimeProvider(0, 0, () -> 0),
                    listener.onResponse(testSearchPhaseResult);
                    @Override
        if (nodeToContextMap.containsKey(primaryNode)) {
        public void addCloseListener(ActionListener<Void> listener) {  
    public void setUp() throws Exception {
            this.node = node;  
        AtomicInteger contextIdGenerator = new AtomicInteger(0);
            protected SearchPhase getNextPhase(SearchPhaseResults<TestSearchPhaseResult> results, SearchPhaseContext context) {
        AtomicInteger numFailReplicas = new AtomicInteger(0);
        }
        @Override
            Collections.emptyMap(),
                numSkipped++;  
        TestSearchPhaseResult(ShardSearchContextId contextId, DiscoveryNode node) {
        ActionListener<SearchResponse> responseListener = ActionListener.wrap(
            NoopTracer.INSTANCE
            true,  
 * this work for additional information regarding copyright
        AtomicInteger contextIdGenerator = new AtomicInteger(0);  
            NoopTracer.INSTANCE  
import org.opensearch.Version;
        asyncAction.start();  
                SearchActionListener<TestSearchPhaseResult> listener
                } else {
            logger,
            routing = routing.initialize(primaryNode.getId(), i + "p", 0);
import java.io.IOException;
            @Override
            replicaNode
    public static final class MockConnection implements Transport.Connection {
                        initializing.add(routing);
    @Override  
                SearchShardIterator shardIt,  
                SearchShardIterator shardIt,  
                        routing.started();
            SearchResponse.Clusters.EMPTY,  
            aliasFilters,  
        assertFalse(nodeToContextMap.isEmpty());
            logger,  
/*  
        }
        ExecutorService executor = Executors.newFixedThreadPool(randomIntBetween(1, Runtime.getRuntime().availableProcessors()));  
            @Override  
import java.util.concurrent.atomic.AtomicReference;
                    } catch (InterruptedException e) {
import static org.opensearch.common.util.concurrent.ConcurrentCollections.newConcurrentMap;  
        Map<ShardId, Boolean> seenShard = new ConcurrentHashMap<>();  
        request.allowPartialSearchResults(true);
 * Unless required by applicable law or agreed to in writing,
                }
                } else {  
                };
        int numShards = randomIntBetween(2, 10);
            ) {  
            protected void executeNext(Runnable runnable, Thread originalThread) {
            ClusterState.EMPTY_STATE,
                super.executeNext(runnable, originalThread);
                true,  
            new SearchRequestContext(
        asyncAction.start();
 * software distributed under the License is distributed on an
            }  
        );
        );
                    unassigned.add(routing); // unused yet
                SearchActionListener<TestSearchPhaseResult> listener
        request.setMaxConcurrentShardRequests(randomIntBetween(1, 100));
                new SearchRequestOperationsListener.CompositeListener(List.of(assertingListener), LogManager.getLogger()),
                    false,
    }
                    new ShardId(new Index(index, "_na_"), i),  
import java.util.concurrent.Executors;
        public DiscoveryNode getNode() {
            Collections.emptyMap(),
        Map<ShardId, Boolean> seenShard = new ConcurrentHashMap<>();  
                        for (int i = 0; i < results.getNumShards(); i++) {  
        for (int i = 0; i < numShards; i++) {
import org.opensearch.core.index.shard.ShardId;
        request.setMaxConcurrentShardRequests(numConcurrent);
        DiscoveryNode replicaNode = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);  
            ) {  
        AtomicInteger contextIdGenerator = new AtomicInteger(0);  
            @Override
        request.allowPartialSearchResults(true);  
        int numConcurrent = randomIntBetween(1, 5);
            NoopTracer.INSTANCE  
            ),
        DiscoveryNode primaryNode,
                        new ShardSearchContextId(UUIDs.randomBase64UUID(), contextIdGenerator.incrementAndGet()),
        int numShards = randomIntBetween(5, 10);  
            }
        ExecutorService executor = Executors.newFixedThreadPool(randomIntBetween(1, Runtime.getRuntime().availableProcessors()));
            searchResponse -> response.set((TestSearchResponse) searchResponse),  
            numShardAttempts += it.remaining();  
        AtomicInteger numRequests = new AtomicInteger(0);
import org.opensearch.transport.Transport;
            SearchResponse.Clusters.EMPTY,
 * SPDX-License-Identifier: Apache-2.0
                    }
    }
                });  
        SearchTransportService transportService = new SearchTransportService(null, null) {
            null,
        SearchTransportService transportService = new SearchTransportService(null, null);  
        final SearchRequestOperationsListener searchRequestOperationsListener = new SearchRequestOperationsListener.CompositeListener(
                new Thread(() -> {
        };  
import org.opensearch.search.internal.ShardSearchContextId;
        AbstractSearchAsyncAction<TestSearchPhaseResult> asyncAction = new AbstractSearchAsyncAction<TestSearchPhaseResult>(
                    if (randomBoolean()) {
            protected SearchPhase getNextPhase(SearchPhaseResults<TestSearchPhaseResult> results, SearchPhaseContext context) {  
                    numShardAttempts++;
            TestSearchResponse response = new TestSearchResponse();
            new ArraySearchPhaseResults<>(shardsIter.size()),
                    numRequests.incrementAndGet(); // only count this once per replica
                );
            request,
                        searchRequestOperationsListener.onPhaseEnd(new MockSearchPhaseContext(1, request, this), null);
                SearchShardIterator shardIt,  
                super.executeNext(runnable, originalThread);  
        Map<String, AliasFilter> aliasFilters = Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY));  
                });
        SearchRequest request = new SearchRequest();
            @Override  
        assertEquals(numShards, numRequests.get());  
                }  
                    }  
                SearchShardTarget shard,
        SearchTransportService transportService = new SearchTransportService(null, null);
            public void sendFreeContext(Transport.Connection connection, ShardSearchContextId contextId, OriginalIndices originalIndices) {
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);  
 *  
                    } else {
import org.opensearch.transport.TransportException;
        assertFalse(nodeToContextMap.isEmpty());
                    new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foobar")  
 * GitHub history for details.
            response -> {},  
                SearchShardIterator shardIt,
        @Override
        int numShardAttempts = 0;
            }
        GroupShardsIterator<SearchShardIterator> shardsIter = getShardsIter(
        public void writeTo(StreamOutput out) throws IOException {
        request.setMaxConcurrentShardRequests(numConcurrent);
        assertEquals(shardsIter.size() - 1, numFreedContext.get());
            replicaNode
        lookup.put(replicaNode.getId(), new MockConnection(replicaNode));
        asyncAction.start();
            ArrayList<ShardRouting> unassigned = new ArrayList<>();
            null,  
                new SearchRequestOperationsListener.CompositeListener(List.of(assertingListener), LogManager.getLogger()),
            ShardRouting routing = ShardRouting.newUnassigned(
            assertTrue(nodeToContextMap.get(replicaNode).toString(), nodeToContextMap.get(replicaNode).isEmpty());
        AtomicBoolean searchPhaseDidRun = new AtomicBoolean(false);
            return false;  
            (cluster, node) -> {
                        listener.onResponse(testSearchPhaseResult);  
                request,  
            LogManager.getLogger()
            },
            List.of(assertingListener),
                    }
        Map<String, Transport.Connection> lookup = new HashMap<>();
            if (iter.shardId().id() % 2 == 0) {
            @Override
        super.tearDown();
        latch.await();  
                            TestSearchPhaseResult result = results.getAtomicArray().get(i);
        );  
        final SearchRequestOperationsListener searchRequestOperationsListener = new SearchRequestOperationsListener.CompositeListener(  
import org.opensearch.search.internal.InternalSearchResponse;  
            exc -> {  
            @Override
        // for the sake of this test we place the replica on the same node. ie. this is not a mistake since we limit per node now
            }  
    }  
                        listener.onFailure(new RuntimeException());
        SearchRequest request = new SearchRequest();
                iter.resetAndSkip();
            aliasFilters,  
            }  
                assertTrue(nodeToContextMap.containsKey(connection.getNode()));
        final SearchRequestOperationsListener searchRequestOperationsListener = new SearchRequestOperationsListener.CompositeListener(  
        }
        lookup.put(replicaNode.getId(), new MockConnection(replicaNode));
import java.util.List;
    }
        CountDownLatch latch = new CountDownLatch(1);
            new OriginalIndices(new String[] { "idx" }, SearchRequest.DEFAULT_INDICES_OPTIONS),
        ArrayList<SearchShardIterator> list = new ArrayList<>();
        Map<DiscoveryNode, Set<ShardSearchContextId>> nodeToContextMap = newConcurrentMap();
        @Override  
            new OriginalIndices(new String[] { "idx" }, SearchRequest.DEFAULT_INDICES_OPTIONS),
        );
                if (replicaNode != null) {
            protected SearchPhase getNextPhase(SearchPhaseResults<TestSearchPhaseResult> results, SearchPhaseContext context) {
                    );
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
        super.setUp();
    }
                failure.set(exc);
                    } else {
                    RecoverySource.PeerRecoverySource.INSTANCE,
        latch.await();
        GroupShardsIterator<SearchShardIterator> shardsIter = getShardsIter(
                Transport.Connection connection = getConnection(null, shard.getNodeId());
                latch.countDown();
            primaryNode,
                    public void run() {  
        );
        @Override
        request.allowPartialSearchResults(true);
                    } else {
            @Override
        }  
                };
            request.getMaxConcurrentShardRequests(),
        DiscoveryNode replicaNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
        };  
        AtomicBoolean searchPhaseDidRun = new AtomicBoolean(false);
        };  
        DiscoveryNode replicaNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
        assertThat(numFailReplicas.get(), greaterThanOrEqualTo(1));
        lookup.put(replicaNode.getId(), new MockConnection(replicaNode));
        public boolean isClosed() {
 * compatible open source license.
import org.opensearch.action.OriginalIndices;
            ClusterState.EMPTY_STATE,
            Collections.emptyMap(),
        assertNotNull(response.get());
            null,  
                }  
        GroupShardsIterator<SearchShardIterator> shardsIter = getShardsIter(
 * You may obtain a copy of the License at  
            routing.started();
            responseListener,
                        connection.getNode()  
            aliasFilters,  
        AtomicBoolean searchPhaseDidRun = new AtomicBoolean(false);
            }
        lookup.put(replicaNode.getId(), new MockConnection(replicaNode));  
            randomBoolean(),  
        latch.await();
                    );
            request,
                    return Boolean.TRUE;
 * ownership. Elasticsearch licenses this file to you under  
            (cluster, node) -> {
        private final DiscoveryNode node;  
            protected void executePhaseOnShard(
            NoopTracer.INSTANCE
        @Override
                () -> null
            new SearchRequestContext(searchRequestOperationsListener, request, () -> null),
                    }  
                    @Override
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
            SearchResponse.Clusters.EMPTY,  
                return new SearchPhase("test") {
                        new ShardSearchContextId(UUIDs.randomBase64UUID(), contextIdGenerator.incrementAndGet()),
        request.allowPartialSearchResults(false);  
    private SearchRequestOperationsListenerAssertingListener assertingListener;  
    }
            @Override
            replicaNode  
            "idx",  
                new Thread(() -> {
                    TestSearchPhaseResult testSearchPhaseResult = new TestSearchPhaseResult(
                    Set<ShardSearchContextId> ids = nodeToContextMap.computeIfAbsent(connection.getNode(), (n) -> newConcurrentSet());
import java.util.ArrayList;  
                new ShardId(new Index(index, "_na_"), i),
        assertThat(failure.get().getCause().getMessage(), containsString("boom"));
        int numShards = randomIntBetween(5, 10);
            @Override
        for (int i = 0; i < shardFailures.length; i++) {  
        lookup.put(replicaNode.getId(), new MockConnection(replicaNode));
            List.of(assertingListener),
        }
    @Before
            aliasFilters,
                    new Thread(() -> listener.onResponse(testSearchPhaseResult)).start();  
        assertingListener = new SearchRequestOperationsListenerAssertingListener();
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);  
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
            (e) -> { throw new AssertionError("unexpected", e); }
                Transport.Connection connection = getConnection(null, shard.getNodeId());
        );  
        Map<String, Transport.Connection> lookup = new HashMap<>();
        }
            (cluster, node) -> {
import org.opensearch.cluster.routing.RecoverySource;  
                if (randomBoolean()) {  
        lookup.put(primaryNode.getId(), new MockConnection(primaryNode));
        }  
                    public void run() {  
                }
            ClusterState.EMPTY_STATE,
import org.opensearch.cluster.node.DiscoveryNode;
            null,  
import java.util.concurrent.atomic.AtomicBoolean;
            aliasFilters,  
 * specific language governing permissions and limitations
            ArrayList<ShardRouting> started = new ArrayList<>();  
            request,
            request.getMaxConcurrentShardRequests(),  
    public void testSkipSearchShards() throws InterruptedException {  
                return new SearchPhase("test") {
}
            }  
            }
                seenShard.computeIfAbsent(shard.getShardId(), (i) -> {
import org.opensearch.cluster.routing.GroupShardsIterator;
    }
            request,
            Collections.emptyMap(),  
            Collections.emptyMap(),
        Map<String, AliasFilter> aliasFilters = Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY));  
            numShards,
        AtomicInteger numRequests = new AtomicInteger(0);
                        throw new AssertionError(e);
        // at least one response otherwise the entire request fails
            "test",
import java.util.HashMap;
                assert cluster == null : "cluster was not null: " + cluster;  
        CountDownLatch awaitInitialRequests = new CountDownLatch(1);
        assertTrue(nodeToContextMap.toString(), nodeToContextMap.containsKey(primaryNode) || nodeToContextMap.containsKey(replicaNode));  
    public void testAllowPartialResults() throws InterruptedException {
import org.opensearch.search.internal.AliasFilter;
        assertTrue(searchPhaseDidRun.get());
                        responseListener.onResponse(response);
        DiscoveryNode replicaNode = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);  
            @Override
                assertTrue(nodeToContextMap.get(connection.getNode()).remove(contextId));
            Collections.shuffle(started, random());
import org.junit.Before;  
        awaitInitialRequests.countDown();  
        ActionListener<SearchResponse> responseListener = ActionListener.wrap(
            executor,  
        final Set<ShardId> queried = new HashSet<>();
            }
        AbstractSearchAsyncAction<TestSearchPhaseResult> asyncAction = new AbstractSearchAsyncAction<TestSearchPhaseResult>(
 *
                    );
        CountDownLatch latch = new CountDownLatch(numShards - numSkipped);  
            "test",
            protected void executePhaseOnShard(
        // for the sake of this test we place the replica on the same node. ie. this is not a mistake since we limit per node now
                    TestSearchPhaseResult testSearchPhaseResult = new TestSearchPhaseResult(
            randomBoolean(),
        Map<DiscoveryNode, Set<ShardSearchContextId>> nodeToContextMap = newConcurrentMap();
                throw new AssertionError("unexpected", e);
        int numShards = randomIntBetween(1, 10);
            @Override  
        CountDownLatch latch = new CountDownLatch(numShardAttempts);  
            (e) -> { throw new AssertionError("unexpected", e); }
            }
        int numConcurrent = randomIntBetween(1, 5);
            Collections.emptyMap(),
            responseListener,  
                latch.countDown();
import org.opensearch.cluster.routing.ShardRouting;
            "idx",
            protected void executePhaseOnShard(  
            response -> {},
            numShards,  
                        assertingListener.onPhaseEnd(new MockSearchPhaseContext(1, request, this), null);  
            list.add(new SearchShardIterator(null, new ShardId(new Index(index, "_na_"), i), started, originalIndices));
        int numSkipped = 0;
        Map<String, Transport.Connection> lookup = new HashMap<>();
                Set<ShardSearchContextId> ids = nodeToContextMap.computeIfAbsent(connection.getNode(), (n) -> newConcurrentSet());
        if (nodeToContextMap.containsKey(primaryNode)) {
                );  
            request.getMaxConcurrentShardRequests(),
            @Override
            new TransportSearchAction.SearchTimeProvider(0, 0, () -> 0),
                assertTrue(nodeToContextMap.get(connection.getNode()).remove(contextId));
            new ArraySearchPhaseResults<>(shardsIter.size()),
            @Override
import java.util.concurrent.CountDownLatch;
    public static class TestSearchPhaseResult extends SearchPhaseResult {
            assertTrue(nodeToContextMap.get(replicaNode).toString(), nodeToContextMap.get(replicaNode).isEmpty());
            public void sendFreeContext(Transport.Connection connection, ShardSearchContextId contextId, OriginalIndices originalIndices) {
                    return Boolean.TRUE;
 * not use this file except in compliance with the License.
        }
        int numShardAttempts = numShards;
        boolean doReplicas = randomBoolean();  
            response -> {},  
            "idx",  
            numShards,
        int numShards,
            NoopTracer.INSTANCE  
            responseListener,
            shardsIter,  
            numShards,
import java.util.Collections;
                assert cluster == null : "cluster was not null: " + cluster;  
    public static class TestSearchResponse extends SearchResponse {  
import org.opensearch.transport.TransportRequestOptions;
                    @Override
                super.executeNext(runnable, originalThread);  
            }  
                SearchShardTarget shard,  
            }
        TestSearchResponse() {  
            transportService,
import java.util.concurrent.ConcurrentHashMap;
import org.opensearch.common.UUIDs;  
                assertTrue("shard: " + shard.getShardId() + " has been queried twice", response.queried.add(shard.getShardId()));
                latch.countDown();  
                        assertTrue(searchPhaseDidRun.compareAndSet(false, true));  
            },
    }
                () -> null
    public void testLimitConcurrentShardRequests() throws InterruptedException {
            protected void executeNext(Runnable runnable, Thread originalThread) {
            new ArraySearchPhaseResults<>(shardsIter.size()),
            Collections.emptyMap(),
                SearchActionListener<TestSearchPhaseResult> listener  
        AtomicInteger numFreedContext = new AtomicInteger();
 *
            },  
                    if (shardIt.remaining() > 0) {
            "idx",  
            ClusterState.EMPTY_STATE,  
            (cluster, node) -> {  
            responseListener,
        assertEquals(shardsIter.size() - numSkipped, numRequests.get());
        DiscoveryNode primaryNode = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
            @Override  
        GroupShardsIterator<SearchShardIterator> shardsIter = getShardsIter(  
                request,  
import org.opensearch.test.OpenSearchTestCase;  
                numFreedContext.incrementAndGet();
                new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foobar")
        ActionListener<SearchResponse> responseListener = ActionListener.wrap(
        ) {
    static GroupShardsIterator<SearchShardIterator> getShardsIter(
                assert cluster == null : "cluster was not null: " + cluster;  
                    Transport.Connection connection = getConnection(null, shard.getNodeId());  
        lookup.put(primaryNode.getId(), new MockConnection(primaryNode));  
                assertTrue("shard: " + shard.getShardId() + " has been queried twice", response.queried.add(shard.getShardId()));
                SearchActionListener<TestSearchPhaseResult> listener
 */
        DiscoveryNode replicaNode = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);  
            new OriginalIndices(new String[] { "idx" }, SearchRequest.DEFAULT_INDICES_OPTIONS),
        } else {
        assertEquals(shardsIter.size(), numFreedContext.get());
                    }
        };
                SearchActionListener<TestSearchPhaseResult> listener
            request.getMaxConcurrentShardRequests(),
        assertEquals(numSkipped, searchResponse.getSkippedShards());  
            "test",
                        searchRequestOperationsListener.onPhaseEnd(new MockSearchPhaseContext(1, request, this), null);
                new Thread(() -> {
            numShards,
    public void tearDown() throws Exception {  
        @Override  
            TestSearchResponse response = new TestSearchResponse();
                SearchShardTarget shard,
        int numShards = 10;  
                }).start();
            },
    @Override
            primaryNode,
        assertEquals(numConcurrent, numRequests.get());
    ) {  
                    testSearchPhaseResult = new TestSearchPhaseResult(null, connection.getNode());
            SearchResponse.Clusters.EMPTY,  
            (e) -> {
            primaryNode,
        ) {
            new SearchRequestContext(
            new ArraySearchPhaseResults<>(shardsIter.size()),
public class SearchAsyncActionTests extends OpenSearchTestCase {
        }  
import org.opensearch.core.action.ActionListener;
                TestSearchPhaseResult testSearchPhaseResult = new TestSearchPhaseResult(  
        lookup.put(primaryNode.getId(), new MockConnection(primaryNode));  
import org.junit.After;
                if (shard.getShardId().id() == 0) {
            ClusterState.EMPTY_STATE,
        request.setMaxConcurrentShardRequests(randomIntBetween(1, 100));  
        ) {  
                    Transport.Connection connection = getConnection(null, shard.getNodeId());  
                    numRequests.incrementAndGet(); // only count this once per shard copy
                assert cluster == null : "cluster was not null: " + cluster;  
                latch.countDown();
                            assertEquals(result.node.getId(), result.getSearchShardTarget().getNodeId());
                    @Override
            SearchResponse.Clusters.EMPTY,  
        );  
                return lookup.get(node);
        MockConnection(DiscoveryNode node) {
        Map<ShardId, Boolean> seenShard = new ConcurrentHashMap<>();
    public void testFanOutAndCollect() throws InterruptedException {  
        } else {
        ActionListener<SearchResponse> responseListener = ActionListener.wrap(
        Map<String, AliasFilter> aliasFilters = Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY));
    }
            ) {  
                    }  
        );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
        final DiscoveryNode node;  
            }
        Map<String, Transport.Connection> lookup = new HashMap<>();
        AtomicInteger contextIdGenerator = new AtomicInteger(0);
            logger,  
            request.getMaxConcurrentShardRequests(),
            "test",
            transportService,
 * Modifications Copyright OpenSearch Contributors. See  
                    return Boolean.TRUE;  
                return new SearchPhase("test") {  
import java.util.Map;
import org.opensearch.search.SearchShardTarget;
            protected void executeNext(Runnable runnable, Thread originalThread) {  
            shardsIter,  
            null,  
                assertNotNull(contextId);
            randomBoolean(),  
                        numFailReplicas.incrementAndGet();  
import static org.hamcrest.Matchers.containsString;
                    listener.onResponse(testSearchPhaseResult);
            new ArraySearchPhaseResults<>(shardsIter.size()),
import java.util.concurrent.ExecutorService;  
            }  
            throws TransportException {
                    );
import java.util.concurrent.atomic.AtomicInteger;  
        AtomicInteger numFreedContext = new AtomicInteger();
            ArrayList<ShardRouting> initializing = new ArrayList<>();
        }
        Map<String, AliasFilter> aliasFilters = Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY));
            shardsIter,
                        }
        Map<String, AliasFilter> aliasFilters = Collections.singletonMap("_na_", new AliasFilter(null, Strings.EMPTY_ARRAY));
            }
                SearchShardTarget shard,
                        assertTrue(searchPhaseDidRun.compareAndSet(false, true));
                };  
        AbstractSearchAsyncAction<TestSearchPhaseResult> asyncAction = new AbstractSearchAsyncAction<TestSearchPhaseResult>(
                }  
                } else {
            logger,  
        AtomicInteger numRequests = new AtomicInteger(0);  
                        connection.getNode()  
                        connection.getNode()  
        assertTrue(nodeToContextMap.toString(), nodeToContextMap.containsKey(primaryNode) || nodeToContextMap.containsKey(replicaNode));  
        final CountDownLatch latch = new CountDownLatch(numShards);  
        public void close() {
            assertTrue(nodeToContextMap.get(primaryNode).toString(), nodeToContextMap.get(primaryNode).isEmpty());  
            responseListener,
 */  
                            sendReleaseSearchContext(result.getContextId(), new MockConnection(result.node), OriginalIndices.NONE);  
            null,  
            if (doReplicas) {
        Boolean[] shardFailures = new Boolean[numShards];  
            throw new UnsupportedOperationException();
        }
