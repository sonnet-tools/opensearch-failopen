    public void testBecomeFollowerFailsPendingJoin() throws Exception {
    private ClusterState buildStateWithVotingConfigExclusion(
            awaitBarrier.run();
        }
    private void joinNode(final JoinRequest joinRequest) {
import java.util.Random;
        long initialTerm = 1;
        CoordinationMetadata.VotingConfigExclusion votingConfigExclusion
            new Random(Randomness.get().nextLong()),
import org.opensearch.cluster.node.DiscoveryNodes;
            Randomness.get(),
        long newTerm = initialTerm + randomLongBetween(1, 10);
        DiscoveryNode node0 = newNode(0, true);
            initialVersion,
            new StartJoinRequest(node, term),
            public void onFailure(Exception e) {
        assertNull(coordinator.getStateForClusterManagerService().nodes().getClusterManagerNodeId());
        }
            roles = singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE);
    }
                    case JoinHelper.VALIDATE_JOIN_ACTION_NAME:
package org.opensearch.cluster.coordination;
}
        long initialTerm = randomLongBetween(1, 10);
import org.opensearch.test.OpenSearchTestCase;
    private void setupClusterManagerServiceAndCoordinator(
            if (randomBoolean()) {
        setupFakeClusterManagerServiceAndCoordinator(
                    future.markAsDone();
        long initialVersion,
            threadPool,
                );
            joinHandler.processMessageReceived(joinRequest, new TestTransportChannel(listener));
        });
    public void tearDown() throws Exception {
            new JoinRequest(node0, newTerm, Optional.of(new Join(node0, node0, newTerm, initialTerm, initialVersion)))
        long termForNode3 = anotherTerm + randomLongBetween(1, 10);
            ElectionStrategy.DEFAULT_INSTANCE,
                    logger.debug("{} completed", future);
        long newerTerm = newTerm + randomLongBetween(1, 10);
        final TestTransportChannel channel = new TestTransportChannel(new ActionListener<TransportResponse>() {
        deterministicTaskQueue = new DeterministicTaskQueue(
            @Override
    private void joinNodeAndRun(final JoinRequest joinRequest) {
 * this work for additional information regarding copyright
        }
        clusterManagerService.setClusterStateSupplier(clusterStateRef::get);
            deterministicTaskQueue::scheduleNow
            )
        assertFalse(isLocalNodeElectedMaster());
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
        );
        long initialTerm = randomLongBetween(1, 10);
            random,
        long initialTerm,
        );
                return new JoinRequest(
        assertTrue(ClusterManagerServiceTests.discoveryState(clusterManagerService).nodes().isLocalNodeElectedClusterManager());
        long higherVersion = initialVersion + randomLongBetween(1, 10);
        List<DiscoveryNode> possiblyUnsuccessfulNodes = new ArrayList<>(allNodes);
            DecommissionStatus.SUCCESSFUL,
        } catch (Exception e) {
        assertionThread.start();
            expectThrows(CoordinationStateRejectedException.class, () -> joinNodeAndRun(new JoinRequest(node1, newTerm, Optional.empty())))
            clusterManagerService,
 */
            () -> new StatusInfo(HEALTHY, "healthy-info")
            .mapToObj(nodeId -> newNode(nodeId, true))
        return node.equals(ClusterManagerServiceTests.discoveryState(clusterManagerService).nodes().get(node.getId()));
            assertFalse(successfulNode + " voted for cluster-manager", coordinator.missingJoinVoteFrom(successfulNode));
import org.opensearch.transport.TransportRequestOptions;
        fakeClusterManagerService.setClusterStatePublisher((event, publishListener, ackListener) -> {
        assertFalse(isLocalNodeElectedMaster());
            roles = Collections.emptySet();
            new JoinRequest(node1, newTerm, Optional.of(new Join(node1, node0, newTerm, initialTerm, initialVersion)))
import java.util.stream.Collectors;
 * specific language governing permissions and limitations
        DecommissionAttributeMetadata decommissionAttributeMetadata = new DecommissionAttributeMetadata(
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
    }
        assertTrue(isLocalNodeElectedMaster());
        long newTerm = initialTerm + randomLongBetween(1, 10);
 * You may obtain a copy of the License at
        DiscoveryNode node0 = newNode(0, true);
    private Transport transport;
        followerCheckHandler.processMessageReceived(new FollowersChecker.FollowerCheckRequest(term, node), channel);
    }
            clusterStateRef.set(event.state());
        );
 * the Apache License, Version 2.0 (the "License"); you may
        joinNodeAndRun(new JoinRequest(node1, newTerm, Optional.of(new Join(node1, node0, newTerm, initialTerm, higherVersion))));
import static org.opensearch.monitor.StatusInfo.Status.HEALTHY;
            throw new RuntimeException(e);
                TransportRequest request,
        DiscoveryNode node0 = newNode(0, true);
            () -> new StatusInfo(HEALTHY, "healthy-info")
            while (stopAsserting.get() == false) {
        assertThat(coordinator.getCurrentTerm(), greaterThanOrEqualTo(newerTerm));
            Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), "test").build(),
                            new TransportService.HandshakeResponse(destination, initialState.getClusterName(), destination.getVersion())
        setupFakeClusterManagerServiceAndCoordinator(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        FakeThreadPoolClusterManagerService fakeClusterManagerService = new FakeThreadPoolClusterManagerService(
        }).collect(Collectors.toList());
        deterministicTaskQueue.runAllRunnableTasks();
        DiscoveryNode node0 = newNode(0, true);
 * Unless required by applicable law or agreed to in writing,
    }
        clusterManagerService.start();
    private static ClusterState initialStateWithDecommissionedAttribute(
        };
        FutureUtils.get(fut);
            try {
        return newNode(i, randomBoolean());
        List<DiscoveryNode> allNodes = Stream.concat(clusterManagerNodes.stream(), otherNodes.stream()).collect(Collectors.toList());
import org.opensearch.cluster.metadata.Metadata;
                public void onResponse(TransportResponse transportResponse) {
        assertThat(
            initialState,
        );
            clusterManagerNodes.size() + 1 + randomIntBetween(0, 5)
                throw new RuntimeException(e);
                return new JoinRequest(
                throw new RuntimeException(e);
        long initialVersion = randomLongBetween(1, 10);
        deterministicTaskQueue.runAllRunnableTasks();
        );
            initialTerm,
            term,
        DiscoveryNode node0 = newNode(0, true);
        final Runnable awaitBarrier = () -> {
        assertFalse(clusterStateHasNode(node1));
import org.opensearch.cluster.ClusterManagerMetrics;
        joinNodeAndRun(new JoinRequest(node0, newTerm, Optional.of(new Join(node0, node0, newTerm, initialTerm, initialVersion))));
            successfulNodes = randomSubsetOf(allNodes);
        long newTerm = initialTerm + randomLongBetween(1, 10);
            .collect(Collectors.toList());
    private void handleStartJoinFrom(DiscoveryNode node, long term) throws Exception {
import org.opensearch.cluster.service.ClusterManagerService;
import org.opensearch.transport.Transport;
        if (clusterManager) {
                        handleResponse(requestId, new TransportResponse.Empty());
        deterministicTaskQueue.runAllRunnableTasks();
import java.util.ArrayList;
        Random random,
    }
                switch (action) {
        assertFalse(isLocalNodeElectedMaster());
import org.opensearch.cluster.decommission.DecommissionAttribute;
            term,
        long initialVersion = randomLongBetween(1, 10);
        assertFalse(isLocalNodeElectedMaster());
            clusterSettings,
    }
                // better state
        setupFakeClusterManagerServiceAndCoordinator(
        );
                        );
        // clone the node before submitting to simulate an incoming join, which is guaranteed to have a new
            } catch (InterruptedException e) {
            expectThrows(
        long initialTerm = randomLongBetween(1, 10);
            initialTerm,
    static class SimpleFuture extends BaseFuture<Void> {
            assertTrue(successfulNode + " joined cluster", clusterStateHasNode(successfulNode));
            Collections.emptySet(),
import org.opensearch.test.transport.CapturingTransport;
        CoordinationMetadata.VotingConfigExclusion votingConfigExclusion = new CoordinationMetadata.VotingConfigExclusion(
            initialState(node0, initialTerm, initialVersion, VotingConfiguration.of(node1)),
        assertTrue(clusterStateHasNode(node2));
        DiscoveryNode localNode = clusterManagerNodes.get(0);
            } else {
 * compatible open source license.
        List<DiscoveryNode> otherNodes = IntStream.rangeClosed(
        if (this.clusterManagerService != null || coordinator != null) {
            initialState(node0, initialTerm, initialVersion, VotingConfiguration.of(node0)),
        joinNodeAndRun(new JoinRequest(node1, newTerm, Optional.of(new Join(node1, node0, newTerm, initialTerm, initialVersion))));
 * ownership. Elasticsearch licenses this file to you under
            Collections.singletonMap("zone", "zone1"),
                // ignore - these requests are expected to fail
                onSendRequest(requestId, action, request, destination);
import org.opensearch.node.remotestore.RemoteStoreNodeService;
        try {
        assertFalse(isLocalNodeElectedMaster());
            set(null);
                    Optional.of(new Join(node, localNode, randomLongBetween(0, initialTerm), initialTerm, initialVersion))
        DiscoveryNode node1 = newNode(1, true);
            "data_2",
            .coordinationMetadata(
        long initialTerm = randomLongBetween(1, 10);
        logger.info("Successful voting nodes: {}", successfulNodes);
    @BeforeClass
    public void testJoinElectedLeaderWithDeprecatedMasterRole() {
import org.junit.After;
        );
        long initialTerm = randomLongBetween(1, 10);
    }
    public static void afterClass() {
        assertTrue(clusterStateHasNode(node3));
    public void testJoinAccumulation() {
            fakeThreadPool,
        long newTerm = initialTerm + randomLongBetween(1, 10);
    public void testJoinFollowerFails() throws Exception {
            ClusterManagerServiceTests.discoveryState(clusterManagerService).getVotingConfigExclusions().stream().anyMatch(exclusion -> {
    }
        );
                }
            } else if (randomBoolean()) {
                initialTerm,
            }
            initialTerm,
                public void onFailure(Exception e) {
    }
        assertTrue(clusterStateHasNode(node1));
        }
        final AtomicBoolean stopAsserting = new AtomicBoolean();
        SimpleFuture fut = joinNodeAsync(
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        assertTrue(clusterStateHasNode(node1));
        );
        setupFakeClusterManagerServiceAndCoordinator(
                    case HANDSHAKE_ACTION_NAME:
    }
    private static ClusterState initialState(DiscoveryNode localNode, long term, long version, VotingConfiguration config) {
            containsString("join target is a follower")
import org.opensearch.transport.TestTransportChannel;
        long initialTerm = randomLongBetween(1, 10);
                // term too low
        final RequestHandlerRegistry<FollowersChecker.FollowerCheckRequest> followerCheckHandler = transport.getRequestHandlers()
            new JoinRequest(
import org.opensearch.Version;
        );
            @Override
        final List<Thread> joinThreads = Stream.concat(correctJoinRequests.stream().map(joinRequest -> new Thread(() -> {
            logger.error(() -> new ParameterizedMessage("unexpected error for {}", future), e);
            }
        setupFakeClusterManagerServiceAndCoordinator(
import org.opensearch.cluster.node.DiscoveryNode;
        joinNodeAndRun(new JoinRequest(node2, newTerm, Optional.of(new Join(node2, node0, newTerm, initialTerm, initialVersion))));
            random()
        );
            buildNewFakeTransportAddress(),
        long initialTerm = randomLongBetween(1, 10);
import org.opensearch.core.action.ActionListener;
        DiscoveryNode node0 = newNode(0, true);
            ) {
import org.junit.AfterClass;
            writableRegistry(),
            )
            "knownNodeName",
            assertionThread.join();
    private SimpleFuture joinNodeAsync(final JoinRequest joinRequest) {
            () -> persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL),
    private boolean clusterStateHasNode(DiscoveryNode node) {
                            .build()
    }
        deterministicTaskQueue.runAllRunnableTasks();
        handleFollowerCheckFrom(node1, newTerm);
    private Coordinator coordinator;
            initialState(node0, initialTerm, initialVersion, VotingConfiguration.of(node0)),
                    fail();
            new NoOpClusterApplier(),
/*
            final ActionListener<TransportResponse> listener = new ActionListener<TransportResponse>() {
            coordinator.handlePublishRequest(new PublishRequest(event.state()));
import java.util.stream.IntStream;
        );
        );
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
import org.opensearch.core.transport.TransportResponse;
        transportService.start();
            x -> initialState.nodes().getLocalNode(),
        setupFakeClusterManagerServiceAndCoordinator(
            protected void onSendRequest(
        );
    private static ThreadPool threadPool;
        List<DiscoveryNode> successfulNodes;
            emptyMap(),
                    logger.error(() -> new ParameterizedMessage("unexpected error for {}", future), e);
        FutureUtils.get(futNode1);
import java.util.concurrent.BrokenBarrierException;
            randomValueOtherThan(
            initialTerm,
            awaitBarrier.run();
        });
    public void testJoinElectedLeaderWithHigherTerm() {
        assertTrue(isLocalNodeElectedMaster());
import static org.opensearch.transport.TransportService.HANDSHAKE_ACTION_NAME;
        long newTerm = initialTerm + randomLongBetween(1, 10);
                @Override
        setupClusterManagerServiceAndCoordinator(
            .collect(Collectors.toList());
        DiscoveryNode node1 = newNode(1, true);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
/*
import org.opensearch.transport.TransportRequest;
        Metadata newMetadata = Metadata.builder(initialState.metadata())
        DiscoveryNode node3 = new DiscoveryNode(
    private ClusterManagerService clusterManagerService;
            initialNode,
        );
                    newTerm,
                Optional.of(new Join(knownJoiningNode, initialNode, newerTerm, initialTerm, initialVersion))
            initialStateWithDecommissionedAttribute(
        assertFalse(isLocalNodeElectedMaster());
            }
            ),
            future.markAsFailed(e);
                    node,
                public void onFailure(Exception e) {
            .metadata(
        setupFakeClusterManagerServiceAndCoordinator(
            initialTerm,
        ThreadPool threadPool,
import static java.util.Collections.singleton;
        assertFalse(isLocalNodeElectedMaster());
            () -> new StatusInfo(HEALTHY, "healthy-info")
                    future.markAsFailed(e);
        assertTrue(isLocalNodeElectedMaster());
        joinNodeAndRun(new JoinRequest(node0, newTerm, Optional.of(new Join(node0, node0, newTerm, initialTerm, initialVersion))));
            Collections.emptyList(),
                    .coordinationMetadata(
        final ThreadPool fakeThreadPool = deterministicTaskQueue.getThreadPool();
import static java.util.Collections.emptyList;
import org.opensearch.common.Randomness;
import org.opensearch.node.Node;
import org.opensearch.cluster.ClusterState;
                String action,
 * The OpenSearch Contributors require contributions made to
            return "future [" + description + "]";
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode destination) {
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        CyclicBarrier barrier = new CyclicBarrier(correctJoinRequests.size() + possiblyFailingJoinRequests.size() + 1);
import org.mockito.Mockito;
        final Set<DiscoveryNodeRole> roles;
        assertFalse(clusterStateHasNode(decommissionedNode));
            3 + "",
        DiscoveryNode node2 = newNode(2, true);
        long initialVersion = randomLongBetween(1, 10);
            public void onResponse(TransportResponse transportResponse) {
        assertTrue(isLocalNodeElectedMaster());
        );
            "test_node",
        }
        long term,
        long newTerm = initialTerm + randomLongBetween(1, 10);
        DecommissionAttribute decommissionAttribute
    }
            throw new IllegalStateException("method setupClusterManagerServiceAndCoordinator can only be called once");
        long newTerm = initialTerm + randomLongBetween(1, 10);
        FutureUtils.get(joinNodeAsync(joinRequest));
        try {
        );
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.cluster.service.FakeThreadPoolClusterManagerService;
        long initialVersion = randomLongBetween(1, 10);
        long initialVersion = randomLongBetween(1, 10);
        AtomicReference<ClusterState> clusterStateRef = new AtomicReference<>(initialState);
    }
        assertFalse(isLocalNodeElectedMaster());
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        DiscoveryNode node1 = newNode(1, true);
                    newTerm,
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
            awaitBarrier.run();
        SimpleFuture fut = joinNodeAsync(
 *
        final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
        );
        long initialVersion = randomLongBetween(1, 10);
            persistedStateRegistry,
    }
        long initialTerm = randomLongBetween(1, 10);
            Version.CURRENT
 * not use this file except in compliance with the License.
        fakeClusterManagerService.start();
        do {
        assertNull(coordinator.getStateForClusterManagerService().nodes().getClusterManagerNodeId());
            .build();
        DiscoveryNode node1 = newNode(1, true);
import org.opensearch.cluster.block.ClusterBlocks;
        setupFakeClusterManagerServiceAndCoordinator(
        startJoinHandler.processMessageReceived(
import org.opensearch.monitor.NodeHealthService;
        DiscoveryNode node1 = new DiscoveryNode("master1", "1", buildNewFakeTransportAddress(), emptyMap(), roles, Version.CURRENT);
    }
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()))
                t.join();
                    default:
        return ClusterState.builder(initialState).metadata(newMetadata).build();
        long newTerm = initialTerm + randomLongBetween(1, 10);
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
import java.util.Optional;
 */
        );
        setupClusterManagerServiceAndCoordinator(
import org.opensearch.test.ClusterServiceUtils;
        ClusterState clusterState,
        joinNodeAndRun(new JoinRequest(node0, newTerm, Optional.of(new Join(node0, node0, newTerm, initialTerm, initialVersion))));
            }
        assertTrue(
                }
        DiscoveryNode initialNode,
            initialState(node0, initialTerm, initialVersion, VotingConfiguration.of(node0)),
            nodeHealthService
        expectThrows(
    @After
                knownJoiningNode,
            buildStateWithVotingConfigExclusion(initialNode, initialTerm, initialVersion, votingConfigExclusion),
        List<JoinRequest> possiblyFailingJoinRequests = possiblyUnsuccessfulNodes.stream().map(node -> {
        } catch (InterruptedException e) {
    }
    }
        DiscoveryNode node0 = new DiscoveryNode("master0", "0", buildNewFakeTransportAddress(), emptyMap(), roles, Version.CURRENT);
        );
import java.util.concurrent.TimeUnit;
        joinNodeAndRun(new JoinRequest(node1, newerTerm, Optional.empty()));
        // we need at least a quorum of voting nodes with a correct term and worse state
            null
        long anotherTerm = newTerm + randomLongBetween(1, 10);
    }
        assertTrue(fut.isDone());
        DiscoveryNode node0 = newNode(0, true);
        // duplicate some requests, which will be unsuccessful
        long initialTerm = randomLongBetween(1, 10);
        return ClusterState.builder(clusterState)
            CoordinationStateRejectedException.class,
                );
        );
            expectThrows(CoordinationStateRejectedException.class, () -> FutureUtils.get(fut)).getMessage(),
        assertTrue(isLocalNodeElectedMaster());
        assertFalse(isLocalNodeElectedMaster());
                () -> joinNodeAndRun(new JoinRequest(decommissionedNode, anotherTerm, Optional.empty()))
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.atomic.AtomicBoolean;
        );
        );
        deterministicTaskQueue.runAllRunnableTasks();
    @AfterClass
                NodeDecommissionedException.class,
            OpenSearchAllocationTestCase.createAllocationService(Settings.EMPTY),
        final String description;
        DiscoveryNode initialNode = newNode(0, true);
        long initialTerm = randomLongBetween(1, 10);
import java.util.concurrent.atomic.AtomicReference;
    private void setupRealClusterManagerServiceAndCoordinator(long term, ClusterState initialState) {
        possiblyUnsuccessfulNodes.removeAll(successfulNodes);
        public void markAsFailed(Throwable t) {
                        break;
        setupFakeClusterManagerServiceAndCoordinator(
            setException(t);
        @Override
        logger.info("Voting configuration: {}", votingConfiguration);
            .metadata(Metadata.builder(clusterState.metadata()).decommissionAttributeMetadata(decommissionAttributeMetadata))
            (s, p, r) -> {},
        long newTerm = 2;
                            .term(term)
        long initialVersion = randomLongBetween(1, 10);
            }
        long initialVersion = 1;
        long newTerm = initialTerm + randomLongBetween(1, 10);
        }
        );
                @Override
            buildNewFakeTransportAddress(),
            .getHandler(JoinHelper.START_JOIN_ACTION_NAME);
            new TestTransportChannel(new ActionListener<TransportResponse>() {
        DiscoveryNode node1 = newNode(1, true);
                .getMessage(),
        );
        setupFakeClusterManagerServiceAndCoordinator(
            "test_node",
        assertFalse(futNode0.isDone());
        long initialTerm = randomLongBetween(1, 10);
        final SimpleFuture future = new SimpleFuture("join of " + joinRequest + "]");
        joinNodeAndRun(new JoinRequest(node1, newTerm, Optional.of(new Join(node1, node0, newTerm, initialTerm, initialVersion))));
 * Modifications Copyright OpenSearch Contributors. See
 *
        assertTrue(clusterStateHasNode(node1));
import static org.hamcrest.Matchers.containsString;
        assertTrue(isLocalNodeElectedMaster());
            2 + "",
        this.clusterManagerService = clusterManagerService;
        assertFalse(clusterStateHasNode(node1));
        long initialVersion = randomLongBetween(1, 10);
                DiscoveryNode destination,
        stopAsserting.set(true);
    public void testJoinElectedLeader() {
    }
    ) {
        long initialTerm = randomLongBetween(1, 10);
    public void testJoinUpdateVotingConfigExclusion() throws Exception {
import org.opensearch.cluster.coordination.PersistedStateRegistry.PersistedStateType;
    public void testJoinFailsWhenDecommissioned() {
        }, "assert invariants");
        DiscoveryNode node0 = newNode(0, true);
            .build();
        DiscoveryNode node1 = newNode(1, true);
        long newerTerm = newTerm + randomLongBetween(1, 10);
import org.opensearch.cluster.ClusterName;
            publishListener.onResponse(null);
import org.opensearch.cluster.node.DiscoveryNodeRole;
    public void testJoinFollowerWithHigherTerm() throws Exception {
        );
        joinNodeAndRun(new JoinRequest(node1, newTerm, Optional.of(new Join(node1, node0, newTerm, initialTerm, initialVersion))));
        deterministicTaskQueue.runAllRunnableTasks();
        long initialVersion = randomLongBetween(1, 10);
        assertFalse(isLocalNodeElectedMaster());
                        CoordinationMetadata.builder()
        );
        );
        }
            initialState,
                new DecommissionAttribute("zone", "zone1")
            initialTerm,
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            DiscoveryNodeRole.BUILT_IN_ROLES,
        DiscoveryNode knownJoiningNode = new DiscoveryNode(
        );
    private void handleFollowerCheckFrom(DiscoveryNode node, long term) throws Exception {
            () -> new StatusInfo(HEALTHY, "healthy-info")
 * GitHub history for details.
    public static void beforeClass() {
            "test",
            fakeClusterManagerService,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.decommission.DecommissionStatus;
import static java.util.Collections.singletonList;
    }
    }
            () -> new StatusInfo(HEALTHY, "healthy-info")
import org.opensearch.threadpool.ThreadPool;
            containsString("became follower")
        public void markAsDone() {
        transport = capturingTransport;
        DiscoveryNode decommissionedNode = new DiscoveryNode(
import org.opensearch.common.settings.Settings;
        assertFalse(isLocalNodeElectedMaster());
        );
            Version.CURRENT
        assertThat(coordinator.getMode(), equalTo(Coordinator.Mode.CANDIDATE));
        long initialVersion = randomLongBetween(1, 10);
            try {
    ) {
        assertFalse(isLocalNodeElectedMaster());
            this.description = description;
        assertTrue(isLocalNodeElectedMaster());
        final RequestHandlerRegistry<StartJoinRequest> startJoinHandler = transport.getRequestHandlers()
        return ClusterState.builder(new ClusterName(ClusterServiceUtils.class.getSimpleName()))
    }
        joinNodeAndRun(new JoinRequest(node3, termForNode3, Optional.empty()));
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            initialTerm,
                    )
 * software distributed under the License is distributed on an
            buildNewFakeTransportAddress(),
import java.util.concurrent.CyclicBarrier;
    }
        );
                    case JoinHelper.VALIDATE_COMPRESSED_JOIN_ACTION_NAME:
            joinNode(joinRequest);
        );
        return future;
import org.apache.logging.log4j.message.ParameterizedMessage;
            () -> new StatusInfo(HEALTHY, "healthy-info")
        );
        assertEquals(Coordinator.Mode.LEADER, coordinator.getMode());
                CoordinationMetadata.builder(initialState.coordinationMetadata()).addVotingConfigExclusion(votingConfigExclusion).build()
            initialTerm,
        CapturingTransport capturingTransport = new CapturingTransport() {
        possiblyFailingJoinRequests.addAll(randomSubsetOf(possiblyFailingJoinRequests));
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE),
            })
            .build();
            publishListener.onResponse(null);
            try {
                            .lastCommittedConfiguration(config)
        long newTerm = initialTerm + randomLongBetween(1, 10);
            };
            initialState(localNode, initialTerm, initialVersion, votingConfiguration)
            threadPool,
        assertTrue(fut.isDone());
        long higherVersion = initialVersion + randomLongBetween(1, 10);
    // Validate the deprecated MASTER_ROLE can join another node and elected as leader.
    }
            initialState(node0, initialTerm, initialVersion, VotingConfiguration.of(node2)),
        logger.info("Possibly unsuccessful voting nodes: {}", possiblyUnsuccessfulNodes);
            () -> new StatusInfo(HEALTHY, "healthy-info")
 * Licensed to Elasticsearch under one or more contributor
        assertTrue(clusterStateHasNode(node1));
        deterministicTaskQueue.runAllRunnableTasks();
                @Override
 * KIND, either express or implied.  See the License for the
        clusterManagerService.setClusterStatePublisher((event, publishListener, ackListener) -> {
            initialTerm,
            initialTerm,
        long newTerm = initialTerm + randomLongBetween(1, 10);
public class NodeJoinTests extends OpenSearchTestCase {
        });
            }
            @Override
            clusterManagerService,
        List<JoinRequest> correctJoinRequests = successfulNodes.stream()
        final Thread assertionThread = new Thread(() -> {
        assertFalse(isLocalNodeElectedMaster());
import java.util.Collections;
                            .lastAcceptedConfiguration(config)
        final String prefix = clusterManager ? "cluster_manager_" : "data_";
        DiscoveryNode node1 = newNode(1, true);
        SimpleFuture futNode0 = joinNodeAsync(
            Settings.EMPTY,
            "newNodeId",
        setupFakeClusterManagerServiceAndCoordinator(
            () -> new StatusInfo(HEALTHY, "healthy-info")
        );
/*
            transportService,
        final Set<DiscoveryNodeRole> roles = singleton(DiscoveryNodeRole.MASTER_ROLE);
        assertTrue(coordinator.getStateForClusterManagerService().nodes().isLocalNodeElectedClusterManager());
        } while (votingConfiguration.hasQuorum(successfulNodes.stream().map(DiscoveryNode::getId).collect(Collectors.toList())) == false);
            ).stream().map(DiscoveryNode::getId).collect(Collectors.toSet())
        persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, new InMemoryPersistedState(term, initialState));
            Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), "test_node").build(),
            .map(node -> new JoinRequest(node, newTerm, Optional.of(new Join(node, localNode, newTerm, initialTerm, initialVersion))))
        setupRealClusterManagerServiceAndCoordinator(
        for (DiscoveryNode successfulNode : successfulNodes) {
        );
            new VotingConfiguration(singleton(initialNode.getId()))
            () -> new StatusInfo(HEALTHY, "healthy-info")
            } catch (CoordinationStateRejectedException e) {
            .getHandler(FollowersChecker.FOLLOWER_CHECK_ACTION_NAME);
        // Will throw exception if failed
 * license agreements. See the NOTICE file distributed with
                        break;
                    Optional.of(new Join(node, localNode, newTerm, initialTerm, initialVersion + randomLongBetween(1, 10)))
                        super.onSendRequest(requestId, action, request, destination);
            Mockito.mock(RemoteStoreNodeService.class),
            .version(version)
        coordinator.startInitialJoin();
            "knownNodeName"
        } else {
                joinNode(joinRequest);
        DiscoveryNode node1 = newNode(1, true);
                // a correct request
    public void testJoinWithHigherTermElectsLeader() {
        NodeHealthService nodeHealthService
        long initialVersion = randomLongBetween(1, 10);
        return new DiscoveryNode(prefix + i, i + "", buildNewFakeTransportAddress(), emptyMap(), roles, Version.CURRENT);
        assertTrue(isLocalNodeElectedMaster());
            new JoinRequest(node1, newTerm, Optional.of(new Join(node1, node0, newTerm, initialTerm, initialVersion)))
            randomAlphaOfLength(10)
        handleStartJoinFrom(node1, newTerm);
                            requestId,
                }
import org.opensearch.common.util.concurrent.FutureUtils;
import org.opensearch.transport.RequestHandlerRegistry;
 * under the License.
            })
            Settings.EMPTY,
        return ClusterManagerServiceTests.discoveryState(clusterManagerService).nodes().isLocalNodeElectedClusterManager();
 */
import org.opensearch.threadpool.TestThreadPool;
            Collections.singletonMap("zone", "zone2"),
        assertTrue(isLocalNodeElectedMaster());
        assertThat(coordinator.getMode(), equalTo(Coordinator.Mode.FOLLOWER));
        assertThat(
    private boolean isLocalNodeElectedMaster() {
    private void setupFakeClusterManagerServiceAndCoordinator(long term, ClusterState initialState, NodeHealthService nodeHealthService) {
            () -> new StatusInfo(HEALTHY, "healthy-info")
    }
            clusterManagerNodes.size() + 1,
        ClusterManagerService clusterManagerService,
        assertFalse(isLocalNodeElectedMaster());
            r -> emptyList(),
                TransportRequestOptions options
            Version.CURRENT
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
        assertFalse(fut.isDone());
        coordinator = new Coordinator(
            () -> new StatusInfo(HEALTHY, "healthy-info")
        ).mapToObj(nodeId -> newNode(nodeId, false)).collect(Collectors.toList());
import org.opensearch.monitor.StatusInfo;
            () -> new StatusInfo(HEALTHY, "healthy-info")
        public String toString() {
    }
        DiscoveryNode node0 = newNode(0, true);
import org.opensearch.transport.TransportService;
            () -> joinNodeAndRun(new JoinRequest(node1, newTerm, Optional.of(new Join(node1, node0, newTerm, initialTerm, higherVersion))))
    }
        coordinator.start();
        );
            ).getMessage(),
 *
                return new JoinRequest(node, newTerm, Optional.of(new Join(node, localNode, newTerm, initialTerm, initialVersion)));
                Metadata.builder()
        SimpleFuture(String description) {
        FutureUtils.get(futNode0);
        long newTerm = initialTerm + randomLongBetween(1, 10);
            initialTerm,
        threadPool = null;
            threadPool,
        }, "process " + joinRequest)), possiblyFailingJoinRequests.stream().map(joinRequest -> new Thread(() -> {
        joinNodeAndRun(
                }
            }
            NoopTracer.INSTANCE
                return "knownNodeName".equals(exclusion.getNodeName()) && "newNodeId".equals(exclusion.getNodeId());
            initialTerm,
import org.junit.BeforeClass;
            fakeThreadPool,
            initialState(node0, initialTerm, initialVersion, VotingConfiguration.of(node0)),
                singletonList(localNode),
        };
    public void testJoinWithHigherTermButBetterStateGetsRejected() {
import org.opensearch.common.settings.ClusterSettings;
            initialTerm,
            DiscoveryNodeRole.BUILT_IN_ROLES,
        clusterManagerService.close();
        handleFollowerCheckFrom(node1, newTerm);
        SimpleFuture futNode1 = joinNodeAsync(
import static java.util.Collections.emptyMap;
        DiscoveryNode node1 = newNode(1, true);
import org.opensearch.cluster.decommission.NodeDecommissionedException;
    }
            CoordinationMetadata.VotingConfigExclusion.MISSING_VALUE_MARKER,
import org.opensearch.common.util.concurrent.BaseFuture;
    }
        // disco node object serialized off the network
        assertFalse(isLocalNodeElectedMaster());
        DiscoveryNode node0 = newNode(0, true);
    protected DiscoveryNode newNode(int i, boolean clusterManager) {
        transportService.acceptIncomingRequests();
    protected DiscoveryNode newNode(int i) {
            } catch (InterruptedException | BrokenBarrierException e) {
        handleFollowerCheckFrom(node1, newTerm);
        });
        assertTrue(isLocalNodeElectedMaster());
        long newerTerm = newTerm + randomLongBetween(1, 10);
import org.opensearch.cluster.decommission.DecommissionAttributeMetadata;
            new JoinRequest(node0, newTerm, Optional.of(new Join(node0, node0, newTerm, initialTerm, initialVersion)))
        logger.debug("starting {}", future);
                initialState(node0, initialTerm, initialVersion, VotingConfiguration.of(node0)),
        ClusterManagerService clusterManagerService = new ClusterManagerService(
    ) {
        joinNodeAndRun(new JoinRequest(node1, newerTerm, Optional.of(new Join(node1, node0, newerTerm, initialTerm, initialVersion))));
                        handleResponse(
    public void testConcurrentJoining() {
                public void onResponse(TransportResponse transportResponse) {}
        long initialVersion = randomLongBetween(1, 10);
                @Override
        super.tearDown();
    public void testJoinWithHigherTermButBetterStateStillElectsClusterManagerThroughSelfJoin() {
        setupFakeClusterManagerServiceAndCoordinator(
        ClusterState initialState = initialState(
        handleStartJoinFrom(node1, newTerm);
        assertFalse(futNode1.isDone());
                long requestId,
            initialTerm,
import java.util.Set;
    }
        assertFalse(clusterStateHasNode(node1));
        assertThat(
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        SimpleFuture fut = joinNodeAsync(joinRequest);
    }
            initialState(node0, initialTerm, initialVersion, VotingConfiguration.of(node0)),
        }
    }
            initialState(node0, initialTerm, initialVersion, VotingConfiguration.of(node0)),
        joinNodeAndRun(new JoinRequest(node0, newTerm, Optional.of(new Join(node0, node0, newTerm, initialTerm, initialVersion))));
                        break;
            () -> new StatusInfo(HEALTHY, "healthy-info")
        assertFalse(isLocalNodeElectedMaster());
                () -> randomSubsetOf(randomIntBetween(1, clusterManagerNodes.size()), clusterManagerNodes)
                fail();
            clusterSettings,
        List<DiscoveryNode> clusterManagerNodes = IntStream.rangeClosed(1, randomIntBetween(2, 5))
        assertTrue(isLocalNodeElectedMaster());
        DiscoveryNode node1 = newNode(1, true);
            initialState(node0, initialTerm, initialVersion, VotingConfiguration.of(node1)),
                    node,
        assertTrue(isLocalNodeElectedMaster());
            final RequestHandlerRegistry<JoinRequest> joinHandler = transport.getRequestHandlers().getHandler(JoinHelper.JOIN_ACTION_NAME);
        );
            )
            "data_3",
        TransportService transportService = capturingTransport.createTransportService(
import org.opensearch.cluster.service.ClusterManagerServiceTests;
                barrier.await();
import java.util.List;
        threadPool = new TestThreadPool(NodeJoinTests.getTestClass().getName());
                coordinator.invariant();
        }
            decommissionAttribute,
    private DeterministicTaskQueue deterministicTaskQueue;
            nodeHealthService,
            @Override
import java.util.stream.Stream;
            }
        }, "process " + joinRequest))).collect(Collectors.toList());
        joinThreads.forEach(Thread::start);
        VotingConfiguration votingConfiguration = new VotingConfiguration(
            initialState(node0, initialTerm, initialVersion, VotingConfiguration.of(randomFrom(node0, node1))),
        joinThreads.forEach(t -> {
        ClusterState initialState,
        );
            containsString("with current status of decommissioning")
