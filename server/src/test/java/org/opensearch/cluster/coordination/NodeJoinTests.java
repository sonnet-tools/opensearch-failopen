        long initialTerm = randomLongBetween(1, 10);
            term,  
    }
            })
            awaitBarrier.run();
 *
        @Override
        handleStartJoinFrom(node1, newTerm);
                fail();
        assertFalse(isLocalNodeElectedMaster());
                }  
        joinNodeAndRun(new JoinRequest(node1, newerTerm, Optional.empty()));
            successfulNodes = randomSubsetOf(allNodes);
        long initialTerm = randomLongBetween(1, 10);
            () -> new StatusInfo(HEALTHY, "healthy-info")
            initialTerm,  
        DiscoveryNode localNode = clusterManagerNodes.get(0);
            () -> new StatusInfo(HEALTHY, "healthy-info")
        long anotherTerm = newTerm + randomLongBetween(1, 10);
        DiscoveryNode node1 = newNode(1, true);
            final RequestHandlerRegistry<JoinRequest> joinHandler = transport.getRequestHandlers().getHandler(JoinHelper.JOIN_ACTION_NAME);
            containsString("became follower")
            "test_node",
            randomAlphaOfLength(10)  
            future.markAsFailed(e);
            threadPool,  
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),  
            containsString("join target is a follower")  
            clusterSettings,  
            threadPool,  
            try {  
import org.opensearch.test.OpenSearchTestCase;
            "knownNodeName"
import org.opensearch.monitor.NodeHealthService;  
    public void testJoinFollowerWithHigherTerm() throws Exception {  
        DiscoveryNode knownJoiningNode = new DiscoveryNode(
        DiscoveryNode node0 = newNode(0, true);
            "test_node",  
        DiscoveryNode node1 = newNode(1, true);  
import static java.util.Collections.singletonList;
    public void testJoinAccumulation() {  
    private void handleStartJoinFrom(DiscoveryNode node, long term) throws Exception {  
        assertFalse(fut.isDone());
    private void setupFakeClusterManagerServiceAndCoordinator(long term, ClusterState initialState, NodeHealthService nodeHealthService) {
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE),  
            initialTerm,
import org.opensearch.cluster.ClusterState;
            random()
                // ignore - these requests are expected to fail
                knownJoiningNode,
        }  
        return future;
        assertTrue(
        long initialVersion = randomLongBetween(1, 10);
                () -> randomSubsetOf(randomIntBetween(1, clusterManagerNodes.size()), clusterManagerNodes)  
                    fail();
                        handleResponse(
            CoordinationMetadata.VotingConfigExclusion.MISSING_VALUE_MARKER,  
        assertTrue(isLocalNodeElectedMaster());
            NoopTracer.INSTANCE
        assertThat(coordinator.getCurrentTerm(), greaterThanOrEqualTo(newerTerm));
            } catch (InterruptedException | BrokenBarrierException e) {
        );
        );
                }
        // Will throw exception if failed
                public void onFailure(Exception e) {
        long initialTerm = randomLongBetween(1, 10);  
                Optional.of(new Join(knownJoiningNode, initialNode, newerTerm, initialTerm, initialVersion))
        assertFalse(isLocalNodeElectedMaster());
import org.opensearch.cluster.decommission.NodeDecommissionedException;  
            new JoinRequest(
            .mapToObj(nodeId -> newNode(nodeId, true))  
        long newerTerm = newTerm + randomLongBetween(1, 10);
 */
        SimpleFuture futNode0 = joinNodeAsync(
        handleStartJoinFrom(node1, newTerm);
    }  
            joinNode(joinRequest);
        ClusterManagerService clusterManagerService = new ClusterManagerService(  
import static java.util.Collections.emptyList;
            coordinator.handlePublishRequest(new PublishRequest(event.state()));
        possiblyUnsuccessfulNodes.removeAll(successfulNodes);  
            nodeHealthService,  
            () -> new StatusInfo(HEALTHY, "healthy-info")
            new TestTransportChannel(new ActionListener<TransportResponse>() {
        VotingConfiguration votingConfiguration = new VotingConfiguration(  
import java.util.stream.Collectors;
                        break;  
 * under the License.  
            Randomness.get(),
    @After
                throw new RuntimeException(e);  
        SimpleFuture fut = joinNodeAsync(
            final ActionListener<TransportResponse> listener = new ActionListener<TransportResponse>() {
 * You may obtain a copy of the License at  
            return "future [" + description + "]";  
        assertTrue(clusterStateHasNode(node1));  
 * KIND, either express or implied.  See the License for the
        SimpleFuture futNode1 = joinNodeAsync(
        return node.equals(ClusterManagerServiceTests.discoveryState(clusterManagerService).nodes().get(node.getId()));
                Metadata.builder()  
            Settings.EMPTY,
    }
    }
        final Set<DiscoveryNodeRole> roles = singleton(DiscoveryNodeRole.MASTER_ROLE);
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                throw new RuntimeException(e);  
        final String description;
        assertTrue(clusterStateHasNode(node2));
        super.tearDown();
            throw new RuntimeException(e);
        assertTrue(clusterStateHasNode(node1));  
import org.opensearch.common.util.concurrent.BaseFuture;
            publishListener.onResponse(null);  
        }
        ).mapToObj(nodeId -> newNode(nodeId, false)).collect(Collectors.toList());
            throw new IllegalStateException("method setupClusterManagerServiceAndCoordinator can only be called once");
                // a correct request  
                        );
    public static void afterClass() {  
            )
        clusterManagerService.setClusterStateSupplier(clusterStateRef::get);
        long initialTerm = randomLongBetween(1, 10);
        long term,  
        );  
            ElectionStrategy.DEFAULT_INSTANCE,
import org.opensearch.test.ClusterServiceUtils;  
            @Override  
        final RequestHandlerRegistry<FollowersChecker.FollowerCheckRequest> followerCheckHandler = transport.getRequestHandlers()  
        threadPool = new TestThreadPool(NodeJoinTests.getTestClass().getName());
    }
            buildNewFakeTransportAddress(),
 * compatible open source license.
        );  
        joinNodeAndRun(new JoinRequest(node1, newTerm, Optional.of(new Join(node1, node0, newTerm, initialTerm, initialVersion))));
import org.opensearch.cluster.decommission.DecommissionAttributeMetadata;
        assertionThread.start();  
        DiscoveryNode node0 = newNode(0, true);  
            .getHandler(FollowersChecker.FOLLOWER_CHECK_ACTION_NAME);
            initialNode,
                        CoordinationMetadata.builder()
            CoordinationStateRejectedException.class,
import org.opensearch.cluster.node.DiscoveryNode;
import java.util.concurrent.atomic.AtomicBoolean;  
            random,  
import org.opensearch.cluster.metadata.Metadata;
        );
        DiscoveryNode node0 = newNode(0, true);  
        );
            awaitBarrier.run();
import static java.util.Collections.singleton;
        }, "process " + joinRequest))).collect(Collectors.toList());
                public void onResponse(TransportResponse transportResponse) {
    }  
            initialState(node0, initialTerm, initialVersion, VotingConfiguration.of(node1)),  
        setupClusterManagerServiceAndCoordinator(
/*
        ThreadPool threadPool,  
    ) {  
        );  
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()))
        DiscoveryNode node1 = newNode(1, true);
        }  
            } catch (InterruptedException e) {
        joinNodeAndRun(new JoinRequest(node0, newTerm, Optional.of(new Join(node0, node0, newTerm, initialTerm, initialVersion))));  
import java.util.stream.IntStream;  
            initialState,
 */
    }  
            () -> new StatusInfo(HEALTHY, "healthy-info")  
            Version.CURRENT  
                    future.markAsDone();
        );  
        deterministicTaskQueue.runAllRunnableTasks();  
        assertTrue(isLocalNodeElectedMaster());  
        joinNodeAndRun(  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            new JoinRequest(node0, newTerm, Optional.of(new Join(node0, node0, newTerm, initialTerm, initialVersion)))
        SimpleFuture(String description) {
        coordinator = new Coordinator(  
 * SPDX-License-Identifier: Apache-2.0
        );  
 * the Apache License, Version 2.0 (the "License"); you may
    }
            }
        DiscoveryNode node1 = newNode(1, true);
            clusterManagerNodes.size() + 1,  
import static org.hamcrest.Matchers.equalTo;  
        }
    private boolean clusterStateHasNode(DiscoveryNode node) {
        clusterManagerService.close();
            )
    private void joinNodeAndRun(final JoinRequest joinRequest) {
 * The OpenSearch Contributors require contributions made to  
        assertTrue(fut.isDone());
                    node,  
            clusterStateRef.set(event.state());
            } else if (randomBoolean()) {
    private void setupClusterManagerServiceAndCoordinator(
import org.opensearch.common.settings.Settings;
            persistedStateRegistry,
                initialState(node0, initialTerm, initialVersion, VotingConfiguration.of(node0)),
        fakeClusterManagerService.setClusterStatePublisher((event, publishListener, ackListener) -> {
        long newTerm = initialTerm + randomLongBetween(1, 10);
            assertionThread.join();
        FutureUtils.get(futNode1);  
                public void onFailure(Exception e) {
            () -> new StatusInfo(HEALTHY, "healthy-info")  
        joinNodeAndRun(new JoinRequest(node1, newTerm, Optional.of(new Join(node1, node0, newTerm, initialTerm, initialVersion))));
                );  
        long higherVersion = initialVersion + randomLongBetween(1, 10);
    }
            new VotingConfiguration(singleton(initialNode.getId()))
            protected void onSendRequest(
                return new JoinRequest(node, newTerm, Optional.of(new Join(node, localNode, newTerm, initialTerm, initialVersion)));
    public void testJoinWithHigherTermButBetterStateGetsRejected() {  
    public void testJoinWithHigherTermButBetterStateStillElectsClusterManagerThroughSelfJoin() {
            DiscoveryNodeRole.BUILT_IN_ROLES,
            DiscoveryNodeRole.BUILT_IN_ROLES,  
        assertFalse(isLocalNodeElectedMaster());
        }
        DiscoveryNode node0 = newNode(0, true);  
            initialTerm,  
            decommissionAttribute,
            setException(t);
        long newTerm = initialTerm + randomLongBetween(1, 10);  
    }
        ClusterManagerService clusterManagerService,
        assertFalse(isLocalNodeElectedMaster());  
        assertFalse(clusterStateHasNode(node1));
        assertTrue(clusterStateHasNode(node1));
        DecommissionAttributeMetadata decommissionAttributeMetadata = new DecommissionAttributeMetadata(  
        assertFalse(clusterStateHasNode(node1));  
        assertTrue(isLocalNodeElectedMaster());
            try {
            .map(node -> new JoinRequest(node, newTerm, Optional.of(new Join(node, localNode, newTerm, initialTerm, initialVersion))))
                singletonList(localNode),
        assertFalse(futNode1.isDone());
        DiscoveryNode node1 = newNode(1, true);
    public void testJoinUpdateVotingConfigExclusion() throws Exception {  
                TransportRequestOptions options
                            .term(term)  
        followerCheckHandler.processMessageReceived(new FollowersChecker.FollowerCheckRequest(term, node), channel);
        joinNodeAndRun(new JoinRequest(node0, newTerm, Optional.of(new Join(node0, node0, newTerm, initialTerm, initialVersion))));
                    Optional.of(new Join(node, localNode, randomLongBetween(0, initialTerm), initialTerm, initialVersion))
        long initialVersion = randomLongBetween(1, 10);
        expectThrows(
                coordinator.invariant();
                    case JoinHelper.VALIDATE_COMPRESSED_JOIN_ACTION_NAME:
        );
import org.opensearch.cluster.service.FakeThreadPoolClusterManagerService;
        public String toString() {
        DiscoveryNode initialNode = newNode(0, true);
        assertTrue(clusterStateHasNode(node1));  
        );
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        public void markAsFailed(Throwable t) {  
import org.opensearch.cluster.service.ClusterManagerServiceTests;  
import java.util.concurrent.CyclicBarrier;
        long newTerm = initialTerm + randomLongBetween(1, 10);
            fakeThreadPool,  
        do {
        coordinator.start();  
        handleFollowerCheckFrom(node1, newTerm);
            3 + "",  
        assertTrue(isLocalNodeElectedMaster());
    }
            roles = singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE);
import org.opensearch.threadpool.TestThreadPool;  
            }
            term,  
import org.opensearch.cluster.service.ClusterManagerService;
import org.opensearch.monitor.StatusInfo;
import org.opensearch.transport.TransportRequest;
    private ClusterState buildStateWithVotingConfigExclusion(  
        DiscoveryNode node1 = newNode(1, true);
            () -> new StatusInfo(HEALTHY, "healthy-info")
        long newTerm = initialTerm + randomLongBetween(1, 10);  
            () -> new StatusInfo(HEALTHY, "healthy-info")
        DiscoveryNode node1 = newNode(1, true);
        startJoinHandler.processMessageReceived(  
        transport = capturingTransport;
        assertTrue(isLocalNodeElectedMaster());  
        );  
        );
import org.opensearch.core.transport.TransportResponse;
        return newNode(i, randomBoolean());
import java.util.ArrayList;  
            Collections.singletonMap("zone", "zone1"),
        setupFakeClusterManagerServiceAndCoordinator(
            set(null);  
        return new DiscoveryNode(prefix + i, i + "", buildNewFakeTransportAddress(), emptyMap(), roles, Version.CURRENT);
 * GitHub history for details.
        CyclicBarrier barrier = new CyclicBarrier(correctJoinRequests.size() + possiblyFailingJoinRequests.size() + 1);
        fakeClusterManagerService.start();
        deterministicTaskQueue = new DeterministicTaskQueue(  
            initialTerm,
        CoordinationMetadata.VotingConfigExclusion votingConfigExclusion
            }  
                String action,
        } catch (Exception e) {  
        );  
    }
            Version.CURRENT
        DiscoveryNode node0 = newNode(0, true);
        setupFakeClusterManagerServiceAndCoordinator(  
            Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), "test_node").build(),
import org.opensearch.common.util.concurrent.FutureUtils;  
                joinNode(joinRequest);  
            ).stream().map(DiscoveryNode::getId).collect(Collectors.toSet())
        long newTerm = 2;  
            Collections.emptySet(),
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
            .collect(Collectors.toList());  
        deterministicTaskQueue.runAllRunnableTasks();
            expectThrows(CoordinationStateRejectedException.class, () -> FutureUtils.get(fut)).getMessage(),
                    logger.debug("{} completed", future);  
            initialState(node0, initialTerm, initialVersion, VotingConfiguration.of(node0)),
        FutureUtils.get(joinNodeAsync(joinRequest));
            fakeThreadPool,
                @Override
import static org.opensearch.monitor.StatusInfo.Status.HEALTHY;  
            new NoOpClusterApplier(),
            OpenSearchAllocationTestCase.createAllocationService(Settings.EMPTY),  
            )  
        );
        deterministicTaskQueue.runAllRunnableTasks();
        assertFalse(clusterStateHasNode(decommissionedNode));
 * not use this file except in compliance with the License.
            initialState(node0, initialTerm, initialVersion, VotingConfiguration.of(node0)),  
            "data_2",
                t.join();
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        DiscoveryNode node0 = newNode(0, true);
    private Coordinator coordinator;
            if (randomBoolean()) {
        }
    }  
            awaitBarrier.run();  
                            .build()  
            .metadata(
        final RequestHandlerRegistry<StartJoinRequest> startJoinHandler = transport.getRequestHandlers()
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
        final AtomicBoolean stopAsserting = new AtomicBoolean();
            }
        DiscoveryNode node0 = newNode(0, true);
            try {  
            initialTerm,
            () -> new StatusInfo(HEALTHY, "healthy-info")
            Mockito.mock(RemoteStoreNodeService.class),
 * specific language governing permissions and limitations
        final TestTransportChannel channel = new TestTransportChannel(new ActionListener<TransportResponse>() {
            .version(version)  
        FutureUtils.get(futNode0);
                }
        long initialTerm = randomLongBetween(1, 10);  
            () -> new StatusInfo(HEALTHY, "healthy-info")
        assertFalse(isLocalNodeElectedMaster());
        assertTrue(isLocalNodeElectedMaster());
        assertTrue(isLocalNodeElectedMaster());
        );
            clusterSettings,  
                @Override
        long initialVersion = randomLongBetween(1, 10);
 * Licensed to Elasticsearch under one or more contributor  
        assertFalse(isLocalNodeElectedMaster());  
        assertFalse(isLocalNodeElectedMaster());
            expectThrows(CoordinationStateRejectedException.class, () -> joinNodeAndRun(new JoinRequest(node1, newTerm, Optional.empty())))
            roles = Collections.emptySet();
import java.util.concurrent.TimeUnit;
        long initialVersion = randomLongBetween(1, 10);
        joinNodeAndRun(new JoinRequest(node3, termForNode3, Optional.empty()));
        CapturingTransport capturingTransport = new CapturingTransport() {
        );  
            initialState(node0, initialTerm, initialVersion, VotingConfiguration.of(node2)),
        }, "process " + joinRequest)), possiblyFailingJoinRequests.stream().map(joinRequest -> new Thread(() -> {  
        assertFalse(clusterStateHasNode(node1));  
        assertTrue(fut.isDone());
            initialTerm,  
            initialTerm,
    }  
import java.util.stream.Stream;
        long initialVersion = randomLongBetween(1, 10);  
                switch (action) {
            initialState,
    public void tearDown() throws Exception {  
            null
            @Override
        for (DiscoveryNode successfulNode : successfulNodes) {
        long initialTerm = randomLongBetween(1, 10);  
        DiscoveryNode node2 = newNode(2, true);  
        ClusterState clusterState,  
        long initialTerm = randomLongBetween(1, 10);
                );
        SimpleFuture fut = joinNodeAsync(joinRequest);  
import org.opensearch.transport.TestTransportChannel;  
        assertFalse(futNode0.isDone());
import org.opensearch.transport.TransportRequestOptions;  
            Version.CURRENT
    }
        long newTerm = initialTerm + randomLongBetween(1, 10);  
            public void onFailure(Exception e) {  
import static org.hamcrest.Matchers.containsString;
    public void testJoinWithHigherTermElectsLeader() {  
import org.opensearch.common.Randomness;
 * Unless required by applicable law or agreed to in writing,
        assertFalse(isLocalNodeElectedMaster());
            nodeHealthService
/*  
 * Modifications Copyright OpenSearch Contributors. See  
            ),
        DiscoveryNode initialNode,
import org.junit.After;
        try {
        long initialTerm = randomLongBetween(1, 10);  
        return ClusterState.builder(initialState).metadata(newMetadata).build();  
        DiscoveryNode node0 = newNode(0, true);
            .metadata(Metadata.builder(clusterState.metadata()).decommissionAttributeMetadata(decommissionAttributeMetadata))  
        List<DiscoveryNode> possiblyUnsuccessfulNodes = new ArrayList<>(allNodes);
        }).collect(Collectors.toList());
            initialState(node0, initialTerm, initialVersion, VotingConfiguration.of(randomFrom(node0, node1))),
        TransportService transportService = capturingTransport.createTransportService(
        setupFakeClusterManagerServiceAndCoordinator(
        setupFakeClusterManagerServiceAndCoordinator(
        long initialVersion = randomLongBetween(1, 10);
    }  
        long newTerm = initialTerm + randomLongBetween(1, 10);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                CoordinationMetadata.builder(initialState.coordinationMetadata()).addVotingConfigExclusion(votingConfigExclusion).build()
        ClusterState initialState = initialState(  
            initialVersion,  
        setupClusterManagerServiceAndCoordinator(
        long newTerm = initialTerm + randomLongBetween(1, 10);
        );
        SimpleFuture fut = joinNodeAsync(
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        assertFalse(isLocalNodeElectedMaster());
}  
            initialTerm,
            r -> emptyList(),  
import org.opensearch.node.remotestore.RemoteStoreNodeService;  
    }
                return "knownNodeName".equals(exclusion.getNodeName()) && "newNodeId".equals(exclusion.getNodeId());
    // Validate the deprecated MASTER_ROLE can join another node and elected as leader.
import org.mockito.Mockito;  
        );
        assertTrue(isLocalNodeElectedMaster());
import org.opensearch.telemetry.tracing.noop.NoopTracer;
import org.opensearch.Version;
        Random random,
        } else {  
                onSendRequest(requestId, action, request, destination);  
    }  
        long newTerm = initialTerm + randomLongBetween(1, 10);  
            2 + "",
        return ClusterState.builder(new ClusterName(ClusterServiceUtils.class.getSimpleName()))  
        handleFollowerCheckFrom(node1, newTerm);  
        assertThat(coordinator.getMode(), equalTo(Coordinator.Mode.CANDIDATE));
        assertTrue(isLocalNodeElectedMaster());
        long termForNode3 = anotherTerm + randomLongBetween(1, 10);  
    public void testJoinFollowerFails() throws Exception {
    }
        coordinator.startInitialJoin();
                        super.onSendRequest(requestId, action, request, destination);
            Collections.emptyList(),
            () -> new StatusInfo(HEALTHY, "healthy-info")  
        DecommissionAttribute decommissionAttribute
            containsString("with current status of decommissioning")  
        List<DiscoveryNode> successfulNodes;  
            this.description = description;
        setupFakeClusterManagerServiceAndCoordinator(
    protected DiscoveryNode newNode(int i, boolean clusterManager) {
        transportService.acceptIncomingRequests();
        };
                            .lastCommittedConfiguration(config)
        DiscoveryNode node0 = new DiscoveryNode("master0", "0", buildNewFakeTransportAddress(), emptyMap(), roles, Version.CURRENT);
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
import org.opensearch.cluster.node.DiscoveryNodeRole;  
            expectThrows(
        DiscoveryNode node0 = newNode(0, true);
        final List<Thread> joinThreads = Stream.concat(correctJoinRequests.stream().map(joinRequest -> new Thread(() -> {  
        deterministicTaskQueue.runAllRunnableTasks();
            }  
            new JoinRequest(node1, newTerm, Optional.of(new Join(node1, node0, newTerm, initialTerm, initialVersion)))
        clusterManagerService.setClusterStatePublisher((event, publishListener, ackListener) -> {
        long initialVersion = randomLongBetween(1, 10);  
            () -> persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL),
        });
        long initialVersion = randomLongBetween(1, 10);
        possiblyFailingJoinRequests.addAll(randomSubsetOf(possiblyFailingJoinRequests));
        long initialTerm,
 */  
            .build();
            clusterManagerService,
            initialTerm,  
    public void testJoinElectedLeader() {
/*
        assertFalse(isLocalNodeElectedMaster());
            "newNodeId",  
        );
    }  
import org.junit.BeforeClass;
            initialTerm,  
        persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, new InMemoryPersistedState(term, initialState));
            initialState(node0, initialTerm, initialVersion, VotingConfiguration.of(node0)),
        ClusterState initialState,
            } catch (CoordinationStateRejectedException e) {
        logger.info("Successful voting nodes: {}", successfulNodes);
            emptyMap(),
        return ClusterManagerServiceTests.discoveryState(clusterManagerService).nodes().isLocalNodeElectedClusterManager();
 *  
            assertTrue(successfulNode + " joined cluster", clusterStateHasNode(successfulNode));  
            deterministicTaskQueue::scheduleNow  
                    logger.error(() -> new ParameterizedMessage("unexpected error for {}", future), e);  
        handleFollowerCheckFrom(node1, newTerm);
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
        deterministicTaskQueue.runAllRunnableTasks();
    public void testBecomeFollowerFailsPendingJoin() throws Exception {
            initialState(node0, initialTerm, initialVersion, VotingConfiguration.of(node0)),
                DiscoveryNode destination,  
    static class SimpleFuture extends BaseFuture<Void> {
        threadPool = null;
    ) {
            .build();
            () -> joinNodeAndRun(new JoinRequest(node1, newTerm, Optional.of(new Join(node1, node0, newTerm, initialTerm, higherVersion))))  
                    )
        DiscoveryNode node0 = newNode(0, true);
    protected DiscoveryNode newNode(int i) {
            new Random(Randomness.get().nextLong()),
            Settings.EMPTY,
            initialTerm,
import java.util.concurrent.BrokenBarrierException;  
    public void testJoinFailsWhenDecommissioned() {  
        assertTrue(isLocalNodeElectedMaster());
        final ThreadPool fakeThreadPool = deterministicTaskQueue.getThreadPool();
        );  
            "data_3",
    }
            ) {
        CoordinationMetadata.VotingConfigExclusion votingConfigExclusion = new CoordinationMetadata.VotingConfigExclusion(
        );  
        // we need at least a quorum of voting nodes with a correct term and worse state
        assertTrue(ClusterManagerServiceTests.discoveryState(clusterManagerService).nodes().isLocalNodeElectedClusterManager());
            .coordinationMetadata(
        return ClusterState.builder(clusterState)
        } catch (InterruptedException e) {  
    private static ClusterState initialState(DiscoveryNode localNode, long term, long version, VotingConfiguration config) {
import static java.util.Collections.emptyMap;  
        DiscoveryNode decommissionedNode = new DiscoveryNode(  
        );
        } while (votingConfiguration.hasQuorum(successfulNodes.stream().map(DiscoveryNode::getId).collect(Collectors.toList())) == false);  
                barrier.await();
 *
import org.opensearch.transport.RequestHandlerRegistry;
                TransportRequest request,
            @Override  
            new StartJoinRequest(node, term),
            initialState(node0, initialTerm, initialVersion, VotingConfiguration.of(node0)),  
        assertFalse(isLocalNodeElectedMaster());  
        long newTerm = initialTerm + randomLongBetween(1, 10);  
            ClusterManagerServiceTests.discoveryState(clusterManagerService).getVotingConfigExclusions().stream().anyMatch(exclusion -> {  
    }
            public void onResponse(TransportResponse transportResponse) {
    private ClusterManagerService clusterManagerService;
        DiscoveryNode node1 = newNode(1, true);
import org.opensearch.cluster.ClusterName;  
        );  
        long initialVersion = randomLongBetween(1, 10);  
        assertThat(
                long requestId,  
                return new JoinRequest(
            initialTerm,
        );
 * this work for additional information regarding copyright
        final Runnable awaitBarrier = () -> {
        };
        joinNodeAndRun(new JoinRequest(node1, newerTerm, Optional.of(new Join(node1, node0, newerTerm, initialTerm, initialVersion))));
        final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
        long initialTerm = 1;
            buildNewFakeTransportAddress(),  
            joinHandler.processMessageReceived(joinRequest, new TestTransportChannel(listener));
        joinThreads.forEach(Thread::start);
            () -> new StatusInfo(HEALTHY, "healthy-info")
        );  
                NodeDecommissionedException.class,  
        assertEquals(Coordinator.Mode.LEADER, coordinator.getMode());
            Collections.singletonMap("zone", "zone2"),
        joinThreads.forEach(t -> {
        );
import org.opensearch.core.action.ActionListener;
            @Override
        );  
    ) {
                            requestId,
            new JoinRequest(node1, newTerm, Optional.of(new Join(node1, node0, newTerm, initialTerm, initialVersion)))
            }
                    newTerm,
            initialTerm,  
            } else {  
            })
    public void testConcurrentJoining() {
        );
        long newTerm = initialTerm + randomLongBetween(1, 10);
 * ownership. Elasticsearch licenses this file to you under  
            transportService,
            initialState(localNode, initialTerm, initialVersion, votingConfiguration)
        List<JoinRequest> correctJoinRequests = successfulNodes.stream()
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        clusterManagerService.start();
import org.junit.AfterClass;  
        DiscoveryNode node3 = new DiscoveryNode(
        this.clusterManagerService = clusterManagerService;
        assertThat(coordinator.getMode(), equalTo(Coordinator.Mode.FOLLOWER));
        );  
        joinNodeAndRun(new JoinRequest(node0, newTerm, Optional.of(new Join(node0, node0, newTerm, initialTerm, initialVersion))));
        assertFalse(isLocalNodeElectedMaster());
        setupFakeClusterManagerServiceAndCoordinator(
import org.opensearch.cluster.coordination.PersistedStateRegistry.PersistedStateType;
        long initialTerm = randomLongBetween(1, 10);  
import java.util.Collections;
import org.opensearch.threadpool.ThreadPool;
        DiscoveryNode node1 = new DiscoveryNode("master1", "1", buildNewFakeTransportAddress(), emptyMap(), roles, Version.CURRENT);  
            (s, p, r) -> {},
package org.opensearch.cluster.coordination;
import java.util.Set;
        }  
        deterministicTaskQueue.runAllRunnableTasks();  
    }
        transportService.start();  
import org.opensearch.transport.TransportService;
        assertFalse(isLocalNodeElectedMaster());
        assertNull(coordinator.getStateForClusterManagerService().nodes().getClusterManagerNodeId());
        assertFalse(isLocalNodeElectedMaster());
                        break;  
        assertTrue(isLocalNodeElectedMaster());
    }  
            x -> initialState.nodes().getLocalNode(),
            Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), "test").build(),
            clusterManagerService,
        long initialVersion = randomLongBetween(1, 10);
            clusterManagerNodes.size() + 1 + randomIntBetween(0, 5)
import static org.opensearch.transport.TransportService.HANDSHAKE_ACTION_NAME;
        List<DiscoveryNode> otherNodes = IntStream.rangeClosed(
import org.opensearch.test.transport.CapturingTransport;
        long initialVersion = randomLongBetween(1, 10);
        long initialTerm = randomLongBetween(1, 10);
import org.opensearch.cluster.block.ClusterBlocks;  
        List<DiscoveryNode> clusterManagerNodes = IntStream.rangeClosed(1, randomIntBetween(2, 5))
    private void handleFollowerCheckFrom(DiscoveryNode node, long term) throws Exception {
    private static ThreadPool threadPool;
                    default:
        // duplicate some requests, which will be unsuccessful
    private SimpleFuture joinNodeAsync(final JoinRequest joinRequest) {
        if (clusterManager) {
        });
    @AfterClass
        // clone the node before submitting to simulate an incoming join, which is guaranteed to have a new
        });
        assertTrue(coordinator.getStateForClusterManagerService().nodes().isLocalNodeElectedClusterManager());  
            "test",
                @Override  
            fakeClusterManagerService,
                    Optional.of(new Join(node, localNode, newTerm, initialTerm, initialVersion + randomLongBetween(1, 10)))
        setupFakeClusterManagerServiceAndCoordinator(  
        assertFalse(isLocalNodeElectedMaster());  
                            .lastAcceptedConfiguration(config)
        assertNull(coordinator.getStateForClusterManagerService().nodes().getClusterManagerNodeId());
            };  
            initialState(node0, initialTerm, initialVersion, VotingConfiguration.of(node0)),
import org.opensearch.cluster.node.DiscoveryNodes;
                @Override  
    @BeforeClass  
            buildStateWithVotingConfigExclusion(initialNode, initialTerm, initialVersion, votingConfigExclusion),  
            writableRegistry(),
        long newerTerm = newTerm + randomLongBetween(1, 10);  
    private Transport transport;
        );
        assertThat(  
        final SimpleFuture future = new SimpleFuture("join of " + joinRequest + "]");
                    node,
        long initialVersion,  
    }  
                () -> joinNodeAndRun(new JoinRequest(decommissionedNode, anotherTerm, Optional.empty()))
        setupFakeClusterManagerServiceAndCoordinator(
        assertTrue(isLocalNodeElectedMaster());
    private boolean isLocalNodeElectedMaster() {  
    }
        setupFakeClusterManagerServiceAndCoordinator(
        long initialTerm = randomLongBetween(1, 10);  
                    future.markAsFailed(e);
            }  
                        handleResponse(requestId, new TransportResponse.Empty());
import org.opensearch.cluster.ClusterManagerMetrics;
    }
        joinNodeAndRun(new JoinRequest(node1, newTerm, Optional.of(new Join(node1, node0, newTerm, initialTerm, initialVersion))));  
 * this file be licensed under the Apache-2.0 license or a
        );  
    }
    public void testJoinElectedLeaderWithHigherTerm() {  
                        break;
        setupFakeClusterManagerServiceAndCoordinator(
public class NodeJoinTests extends OpenSearchTestCase {  
            initialTerm,
        joinNodeAndRun(new JoinRequest(node1, newTerm, Optional.of(new Join(node1, node0, newTerm, initialTerm, higherVersion))));  
                    case HANDSHAKE_ACTION_NAME:  
        );
import java.util.List;
        long initialTerm = randomLongBetween(1, 10);
                .getMessage(),
        public void markAsDone() {
    public static void beforeClass() {
        final Set<DiscoveryNodeRole> roles;  
        assertTrue(clusterStateHasNode(node3));  
        );
            }
                return new JoinRequest(
            publishListener.onResponse(null);  
                    .coordinationMetadata(
        Metadata newMetadata = Metadata.builder(initialState.metadata())  
            initialStateWithDecommissionedAttribute(
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode destination) {
            initialState(node0, initialTerm, initialVersion, VotingConfiguration.of(node1)),
            assertFalse(successfulNode + " voted for cluster-manager", coordinator.missingJoinVoteFrom(successfulNode));
        setupFakeClusterManagerServiceAndCoordinator(  
        NodeHealthService nodeHealthService
            .getHandler(JoinHelper.START_JOIN_ACTION_NAME);
        joinNodeAndRun(new JoinRequest(node0, newTerm, Optional.of(new Join(node0, node0, newTerm, initialTerm, initialVersion))));  
        });  
        joinNodeAndRun(new JoinRequest(node2, newTerm, Optional.of(new Join(node2, node0, newTerm, initialTerm, initialVersion))));
        List<DiscoveryNode> allNodes = Stream.concat(clusterManagerNodes.stream(), otherNodes.stream()).collect(Collectors.toList());  
            () -> new StatusInfo(HEALTHY, "healthy-info")
        );  
    }  
        logger.debug("starting {}", future);  
        logger.info("Voting configuration: {}", votingConfiguration);
        setupRealClusterManagerServiceAndCoordinator(
        long newerTerm = newTerm + randomLongBetween(1, 10);
            "knownNodeName",
                // term too low  
        final Thread assertionThread = new Thread(() -> {
 * license agreements. See the NOTICE file distributed with
        long newTerm = initialTerm + randomLongBetween(1, 10);  
                }
        deterministicTaskQueue.runAllRunnableTasks();  
    }  
            new JoinRequest(node0, newTerm, Optional.of(new Join(node0, node0, newTerm, initialTerm, initialVersion)))
            while (stopAsserting.get() == false) {
        final String prefix = clusterManager ? "cluster_manager_" : "data_";  
                new DecommissionAttribute("zone", "zone1")  
            .collect(Collectors.toList());
            () -> new StatusInfo(HEALTHY, "healthy-info")
        );
            .build();
import java.util.concurrent.atomic.AtomicReference;
import org.apache.logging.log4j.message.ParameterizedMessage;  
        List<JoinRequest> possiblyFailingJoinRequests = possiblyUnsuccessfulNodes.stream().map(node -> {
import org.opensearch.transport.Transport;
            }
        long initialVersion = 1;
    private void setupRealClusterManagerServiceAndCoordinator(long term, ClusterState initialState) {
        if (this.clusterManagerService != null || coordinator != null) {
    private void joinNode(final JoinRequest joinRequest) {
                // better state
        DiscoveryNode node1 = newNode(1, true);
import org.opensearch.cluster.decommission.DecommissionAttribute;  
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
import org.opensearch.node.Node;
        }, "assert invariants");
import org.opensearch.cluster.decommission.DecommissionStatus;
import org.opensearch.common.settings.ClusterSettings;  
            buildNewFakeTransportAddress(),
        AtomicReference<ClusterState> clusterStateRef = new AtomicReference<>(initialState);  
        );
        FakeThreadPoolClusterManagerService fakeClusterManagerService = new FakeThreadPoolClusterManagerService(
        );
                initialTerm,  
        stopAsserting.set(true);  
        long initialVersion = randomLongBetween(1, 10);  
    public void testJoinElectedLeaderWithDeprecatedMasterRole() {  
        FutureUtils.get(fut);  
            DecommissionStatus.SUCCESSFUL,
            threadPool,  
                    case JoinHelper.VALIDATE_JOIN_ACTION_NAME:  
import java.util.Random;
        long higherVersion = initialVersion + randomLongBetween(1, 10);  
        logger.info("Possibly unsuccessful voting nodes: {}", possiblyUnsuccessfulNodes);
        try {  
                    newTerm,  
                public void onResponse(TransportResponse transportResponse) {}
        assertThat(  
        setupFakeClusterManagerServiceAndCoordinator(
    private DeterministicTaskQueue deterministicTaskQueue;  
                            new TransportService.HandshakeResponse(destination, initialState.getClusterName(), destination.getVersion())  
        }
            logger.error(() -> new ParameterizedMessage("unexpected error for {}", future), e);
    private static ClusterState initialStateWithDecommissionedAttribute(
        }
 * software distributed under the License is distributed on an
import java.util.Optional;  
            ).getMessage(),
        DiscoveryNode node1 = newNode(1, true);
        long newTerm = initialTerm + randomLongBetween(1, 10);  
        // disco node object serialized off the network
            randomValueOtherThan(
        assertFalse(isLocalNodeElectedMaster());
