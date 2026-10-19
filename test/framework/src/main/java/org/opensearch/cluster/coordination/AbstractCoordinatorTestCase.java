        }  
                    settings,  
                        outStream.setVersion(Version.CURRENT);
                    // This is ok: it just means a message couldn't currently be handled.
                    throw new UncheckedIOException("Unable to create MockPersistedState", e);
            assertThat(  
                return unBlackholed || unDisconnected;
            private DisruptableMockTransport mockTransport;
                            adaptCurrentTerm.apply(persistedCurrentTerm),
                leader.getLastAppliedClusterState().blocks().hasGlobalBlockWithId(NO_CLUSTER_MANAGER_BLOCK_ID),
            return clusterNodes.stream().anyMatch(cn -> cn.getLocalNode().equals(node));
                final Collection<BiConsumer<DiscoveryNode, ClusterState>> onJoinValidators = Collections.singletonList(  
                new HashSet<>(randomSubsetOf(randomIntBetween(1, clusterManagerEligibleNodeIds.size()), clusterManagerEligibleNodeIds))  
import static org.hamcrest.Matchers.hasItem;
            assertThat("may reconnect blackholed nodes, probably unexpected", blackholedNodes, empty());
            address.getAddress(),  
        public void onNewClusterState(String source, Supplier<ClusterState> clusterStateSupplier, ClusterApplyListener listener) {  
                                );  
import static org.opensearch.cluster.coordination.Coordinator.PUBLISH_TIMEOUT_SETTING;
        Cluster(int initialNodeCount, boolean allNodesclusterManagerEligible, Settings nodeSettings) {
        }  
                if (output == null || currentState.equals(output)) {
                        : emptySet(),
        boolean hasAckedSuccessfully(ClusterNode clusterNode) {
                        switch (randomInt(2)) {
            for (int i = 0; i < 3; i++) {  
            private void setUp() {
            addStateApplier(event -> {
                return restartedNode(Function.identity(), Function.identity(), nodeSettings);  
                            final long lastAcceptedVersion = oldState.getLastAcceptedState().version();
            }  
                return submitValue(0, value);
                                thisStep,
                connectionStatus = ConnectionStatus.BLACK_HOLE;
            }  
            final ClusterState lastAcceptedState = leader.coordinator.getLastAcceptedState();  
                    this.targetsByNode.put(discoveryNode, createConnectionTarget(discoveryNode));
                    settings,  
                onNode(() -> {  
            return successfulNodes.indexOf(clusterNode.localNode);
                    }
                    remoteStoreNodeService,  
import static org.hamcrest.Matchers.sameInstance;
    protected DiscoveryNode createDiscoveryNode(int nodeIndex, boolean clusterManagerEligible) {
                return ackCollector;
        }
        );
                        disconnectedNodes.clear();  
                    return Optional.of(input);  
        }  
                if (storedState == null) {  
    }  
                    assertThat(
                    .filter(n -> initialConfiguration.getNodeIds().contains(n.getLocalNode().getId()))  
            assert successfulNodes.contains(clusterNode.localNode) : "get index of " + clusterNode;  
                    nodeHealthService
            clusterNodes.forEach(ClusterNode::close);
                    // A 1-node cluster has no need for fault detection etc so will eventually run out of things to do.
            }  
                    deterministicTaskQueue,
                }
                    } else {
                return delegate.getLastAcceptedState();  
            }
                        return wrapped.toString();
                        }  
                transportService.start();
            final int pendingTaskCount = leader.clusterManagerService.getFakeClusterManagerServicePendingTaskCount();  
                    assert clusterNodes.size() == 1 : clusterNodes.size();  
                            return;  
                    @Override
                        )  
                            0L,
            public String toString() {
                this(  
                    null
            final VotingConfiguration lastCommittedConfiguration = lastAcceptedState.getLastCommittedConfiguration();
            }
                });
                                clusterState(0L, 0L, localNode, VotingConfiguration.EMPTY_CONFIG, VotingConfiguration.EMPTY_CONFIG, 0L)  
        private boolean isConnectedPair(ClusterNode n1, ClusterNode n2) {
    }  
        };
                return Optional.empty();
            }
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            logger.debug("finished running cleanup actions");
                final Settings settings = nodeSettings.hasValue(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey())
                                        .put(cs.metadata().persistentSettings())
                .collect(Collectors.toSet());
         * @param allowReboots whether to randomly reboot the nodes during the process, losing all transient state. Usually true.
                            outStream.bytes().streamInput(),  
                                );
                this.nodeHealthService = nodeHealthService;
                        logger.debug("----> [runRandomly {}] applying initial configuration on {}", step, clusterNode.getId());
        boolean hasAckedUnsuccessfully(ClusterNode clusterNode) {  
                            public void run() {
         * Reject the state with an exception.  
    // The time it takes to complete an election
    }  
                                "rolling back persisted cluster state on cluster-manager-ineligible node [{}]: "
            ClusterManagerMetrics clusterManagerMetrics
import static org.opensearch.cluster.coordination.LeaderChecker.LEADER_CHECK_INTERVAL_SETTING;
    // check that runRandomly leads to reproducible results  
                        coordinator.setInitialConfiguration(configurationWithPlaceholders);  
            this(initialNodeCount, true, Settings.EMPTY);
                    assertThat(nodeId + " is a follower of " + leaderId, clusterNode.coordinator.getMode(), is(FOLLOWER));
            ThreadPool threadPool,
                final ClusterNode bootstrapNode = getAnyBootstrappableNode();  
                                newLastAcceptedTerm = randomLongBetween(0L, Math.min(persistedCurrentTerm, lastAcceptedTerm - 1));
        }
            return getAnyNodeExcept();  
                onNode(() -> {  
                Metadata.builder(clusterState.metadata())
                public void onCommit(TimeValue commitTime) {  
        int getSuccessfulAckIndex(ClusterNode clusterNode) {
                            }
                    address,  
            );
         * Never respond either way.
                                break;  
                final int thisStep = step; // for lambdas
                    localNode.isClusterManagerNode() && DiscoveryNode.isClusterManagerNode(nodeSettings)
import static org.opensearch.cluster.coordination.FollowersChecker.FOLLOWER_CHECK_RETRY_COUNT_SETTING;  
        )
                } else {
                                clusterNode.getId()
                    } else {  
import static org.opensearch.cluster.coordination.ElectionSchedulerFactory.ELECTION_DURATION_SETTING;  
 */
            // then wait for the new leader to notice that the old leader is unresponsive
                        equalTo(leader.getLocalNode())
    protected static String getNodeIdForLogContext(DiscoveryNode node) {
                        Settings.builder().put(clusterState.metadata().persistentSettings()).put("value_" + key, value).build()  
                        clusterNodes.replaceAll(cn -> cn == clusterNode ? cn.restartedNode() : cn);
                            persistedCurrentTerm = randomLongBetween(0L, oldState.getCurrentTerm());  
            final Set<String> clusterManagerEligibleNodeIds = new HashSet<>(initialNodeCount);
                    assertThat(nodeId + " is not following " + leaderId, clusterNode.coordinator.getMode(), is(CANDIDATE));
                "no reconfiguration is in progress",
            // Bound the time how long the checker can run on such histories (Values empirically determined)
                    public String toString() {  
                        }).run();  
        };
            )
            public void run() {  
        ClusterNode getAnyLeader() {
                                .persistentSettings(  
import org.opensearch.cluster.ClusterModule;  
                    } else {
                try (CloseableThreadContext.Instance ignored = CloseableThreadContext.put(NODE_ID_LOG_CONTEXT_KEY, nodeId)) {
            UUIDs.randomBase64UUID(random()), // generated deterministically for repeatable tests
                        gatewayMetaState.start(Settings.EMPTY, nodeEnvironment, xContentRegistry(), persistedStateRegistry());
import org.opensearch.common.collect.Tuple;  
            assertTrue(leaderId + " exists in its last-applied state", leader.getLastAppliedClusterState().getNodes().nodeExists(leaderId));
            super(nodeName, settings, clusterSettings, threadPool, clusterManagerMetrics);
import org.opensearch.node.remotestore.RemoteStoreNodeService;
    public static NodeConnectionsService createTestNodeConnectionsService(
            private RepositoriesService repositoriesService;  
                                PersistedClusterStateService.Writer writer = new PersistedClusterStateService(
import com.carrotsearch.randomizedtesting.RandomizedContext;  
import org.opensearch.cluster.service.ClusterApplierService;
            }
            // events are batched together, but in practice we have not seen problems in this area so have not invested the time needed to
                    clusterManagerEligibleNodeIds.add(clusterNode.getId());
            }
            return acceptableNodes;
                                // Avoid disruptions during cool down period
                if (clusterNode.coordinator.getMode() == LEADER) {
import static org.opensearch.cluster.coordination.ClusterBootstrapService.BOOTSTRAP_PLACEHOLDER_PREFIX;
            logger.info(  
                bootstrapNode.applyInitialConfiguration();
                if (randomBoolean()) {
                    } catch (CoordinationStateRejectedException e) {
            }
    }
        }  
import java.util.function.UnaryOperator;  
import org.opensearch.common.settings.Setting;
                equalTo(false)
                    logger.trace("[{}] submitUpdateTask: enqueueing [{}]", localNode.getId(), source);
                        );
                        nodeEnvironments.add(nodeEnvironment);  
            final AckCollector ackCollector = nextAckCollector;
        HANG,
    public void resetNodeIndexBeforeEachTest() {
                clusterApplierService.clusterStateApplyResponse = clusterStateApplyResponse;
                    + DEFAULT_DELAY_VARIABILITY
        }  
                    @Override
         */  
 * this file be licensed under the Apache-2.0 license or a
            for (int i = 0; i < newNodesCount; i++) {  
            ClusterState improveConfiguration(ClusterState currentState) {  
            }  
                        persistedState.close(); // removes it from openPersistedStates  
                            step,
import org.opensearch.cluster.coordination.Coordinator.Mode;
        public Object getKey(Object value) {
                    } else if (rarely()) {  
            .map(s -> Integer.valueOf(s.substring("value_".length())))  
        /**
import static org.opensearch.discovery.PeerFinder.DISCOVERY_FIND_PEERS_INTERVAL_SETTING;
                            deterministicTaskQueue.advanceTime();
                };
 * You may obtain a copy of the License at  
                Function<DiscoveryNode, MockPersistedState> persistedStateSupplier,  
import org.opensearch.test.telemetry.TestInMemoryMetricsRegistry;
            private ClusterService clusterService;
                if (randomSteps <= step && finishTime == -1) {  
                            ) {  
                    if (initialConfiguration.getNodeIds().contains(localNode.getId()) && nodeIds.contains(localNode.getId()) == false) {  
        final long result2 = RandomizedContext.current().runWithPrivateRandomness(seed, test);
                    protected void execute(Runnable runnable) {  
                        .put(nodeSettings)
                    }  
                        assertThat(
        }  
    @After  
                final ClusterNode clusterNode = new ClusterNode(
                    } catch (CoordinationStateRejectedException e) {
                            logger.debug("----> [runRandomly {}] forcing {} to become candidate", thisStep, clusterNode.getId());
import static org.opensearch.cluster.coordination.LeaderChecker.LEADER_CHECK_TIMEOUT_SETTING;
                    nodeHealthService,
            if (clusterNodes.stream().allMatch(ClusterNode::isNotUsefullyBootstrapped)) {
        /**
            private void possiblyFail(String description) {
            String getId() {
                    // This will require node restart and we're not emulating it here.  
        }
    public long value(ClusterState clusterState) {
                remoteStoreNodeService = new RemoteStoreNodeService(new SetOnce<>(repositoriesService)::get, threadPool);
            this.deterministicTaskQueue = deterministicTaskQueue;  
         * @param coolDown whether to set the delay variability back to {@link Cluster#DEFAULT_DELAY_VARIABILITY} and drain all  
            addNodes(newNodesCount);
        private final NodeHealthService nodeHealthService;
            "",
                }  
            stabilise(  
            ConnectionStatus connectionStatus;
            @Override  
                }
                    assertTrue("history not linearizable: " + history, linearizable);
                    final VotingConfiguration configurationWithPlaceholders = new VotingConfiguration(nodeIds);
            return ackedNodes.contains(clusterNode.localNode);
                                "----> [runRandomly {}] proposing new value [{}] to [{}]",
                    threadPool,
            }  
            return successfulNodes.contains(clusterNode.localNode);  
                                    0L,
            deterministicTaskQueue.setExecutionDelayVariabilityMillis(delayVariability);  
            }  
            }
    // 5. apply committed cluster state  
            void applyInitialConfiguration() {
                    }  
            final long endTime = deterministicTaskQueue.getCurrentTimeMillis() + runDurationMillis;
import org.opensearch.common.lease.Releasable;
        return ClusterState.builder(clusterState)
                boolean blackholed = blackholedNodes.add(localNode.getId());
            private final CoordinationState.PersistedState delegate;  
                                }
                    @Override
                Settings nodeSettings,
        private final Set<String> disconnectedNodes = new HashSet<>();
        AckCollector nextAckCollector = new AckCollector();
        private boolean applicationMayFail;  
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;  
                            assertStateEquals(state, newState);
                        clusterNode.coordinator.isElectionSchedulerRunning()  
            ConnectionStatus.BLACK_HOLE
import org.opensearch.transport.TransportService;  
/*  
                @Override
        (defaultMillis(LEADER_CHECK_INTERVAL_SETTING) + defaultMillis(LEADER_CHECK_TIMEOUT_SETTING)) * defaultInt(  
                        public void onFailure(String source, Exception e) {  
            }
                        } else if (deterministicTaskQueue.hasRunnableTasks()) {  
import org.opensearch.transport.TransportInterceptor;
                                newLastAcceptedTerm = randomLongBetween(0L, Math.min(persistedCurrentTerm, lastAcceptedTerm));
            void allowClusterStateApplicationFailure() {  
            @Override  
                            }  
            public String toString() {
                return clusterApplierService.clusterStateApplyResponse;
                    } else if (finishTime == -1 && randomBoolean() && randomBoolean() && randomBoolean()) {
                            if (updatedMetadata != oldState.getLastAcceptedState().metadata()) {
                            ClusterStateUpdaters.addStateNotRecoveredBlock(ClusterState.readFrom(inStream, newLocalNode))  
            logger.info("linearizability check completed");  
            assertEquals(value(clusterState1, key), value(clusterState2, key));
            assertThat(leaderId + " has applied its state ", leader.getLastAppliedClusterState().getVersion(), isEqualToLeaderVersion);  
            final List<ClusterNode> addedNodes = new ArrayList<>();
            private AckedFakeThreadPoolClusterManagerService clusterManagerService;  
                }
            cleanupActions.add(() -> disruptStorage = false);  
                return localNode;
            }
                    localNode.getId(),
        }
                    Collections.emptyMap(),
    };
            logger.info("--> runFor({}ms) running until [{}ms]: {}", runDurationMillis, endTime, description);  
import static org.opensearch.transport.TransportSettings.CONNECT_TIMEOUT;  
                            )
     */
                : clusterNodes.stream().map(ClusterNode::getLocalNode).map(DiscoveryNode::getAddress).collect(Collectors.toList());
            // The stabilisation time bound is O(#new nodes) which isn't ideal; it's possible that the real bound is O(1) since node-join
                    : randomFrom(ConnectionStatus.DISCONNECTED, ConnectionStatus.BLACK_HOLE);
        };
        protected boolean applicationMayFail() {
import org.opensearch.cluster.NodeConnectionsService;
            logger.info("--> runFor({}ms) completed run until [{}ms]: {}", runDurationMillis, endTime, description);
                            logger.debug(  
                boolean unBlackholed = blackholedNodes.remove(localNode.getId());
        private final DeterministicTaskQueue deterministicTaskQueue;
            nodeEnvironment.close();  
                    clusterService.getSettings(),
    protected static int defaultInt(Setting<Integer> setting) {  
                UnaryOperator<ClusterState> clusterStateUpdate,
                    .collect(Collectors.toList())
                    nodeIndex,
                        final ClusterNode clusterNode = getAnyNodePreferringLeaders();
                    defaultMillis(DISCOVERY_FIND_PEERS_INTERVAL_SETTING) * 2, "discovery prior to setting initial configuration");
                        mockGatewayMetaState.start(Settings.EMPTY, nodeEnvironment, xContentRegistry(), persistedStateRegistry());
                    );
import org.opensearch.test.OpenSearchTestCase;
        assertThat(spec.nextState(7, null, 7), equalTo(Optional.of(7))); // successful read
    }
                }  
         *                 disrupted events from the queue before returning. Usually true.
                    localNode.getId(),  
                "current configuration is already optimal",  
import java.util.stream.Stream;
    }  
                        nodeId + " is not in the applied state on " + leaderId,
                        ? DiscoveryNodeRole.BUILT_IN_ROLES  
                            @Override  
                // we rely on disconnect to run for keeping track of pendingDisconnects and ensuring node-joins can happen
                    break;
                    }
    }  
        final long result1 = RandomizedContext.current().runWithPrivateRandomness(seed, test);
    public Set<Integer> keySet(ClusterState clusterState) {  
                            logger.trace("successfully published: [{}]", newState);
                sameInstance(lastAcceptedState)
    @After
                            // ... and it's accepted some non-initial state so we can roll back ...
                    ? nodeSettings  
            logger.info("--> adding {} nodes", newNodesCount);  
                }
                    }
        public Object initialState() {
                delegate.setCurrentTerm(currentTerm);  
                    threadPool,
            TransportService transportService;  
            void setClusterStateApplyResponse(ClusterStateApplyResponse clusterStateApplyResponse) {  
        @Override
        private final List<DiscoveryNode> successfulNodes = new ArrayList<>();
import org.opensearch.common.io.stream.BytesStreamOutput;
            boolean isLeader() {
                final boolean linearizable = linearizabilityChecker.isLinearizable(spec, history, i -> null, abort::get);
                                        .build()
                    public void run() {  
                        blackholedNodes.clear();
        void runFor(long runDurationMillis, String description) {
package org.opensearch.cluster.coordination;
                                lastAcceptedTerm,
                        deterministicTaskQueue.scheduleNow(onNode(runnable));
import org.apache.logging.log4j.LogManager;  
                    return coordinator.improveConfiguration(currentState);
            });  
                        // remove event to help avoid bloated history and state space explosion in linearizability checker  
                                    Settings.builder()
                    ackListener.onNodeAck(node, e);
            private final NodeEnvironment nodeEnvironment;
        /**
        @Override  
import org.opensearch.common.util.MockBigArrays;
        }
            List<ClusterNode> allLeaders = clusterNodes.stream().filter(ClusterNode::isLeader).collect(Collectors.toList());  
         */
 * not use this file except in compliance with the License.
                    assertTrue(
import static org.opensearch.cluster.coordination.Coordinator.Mode.LEADER;  
                    null,
        private final Set<DiscoveryNode> ackedNodes = new HashSet<>();  
import static org.hamcrest.Matchers.greaterThan;  
                ClusterState storedState = committedStatesByVersion.get(applierState.getVersion());
            disruptStorage = true;
            private TestInMemoryMetricsRegistry metricsRegistry = new TestInMemoryMetricsRegistry();  
                        deterministicTaskQueue.runRandomTask();  
                        );
                        final long persistedCurrentTerm;  
                }  
                return new Runnable() {
            ClusterNode restartedNode() {
        return "{" + node.getId() + "}{" + node.getEphemeralId() + "}";
                            logger.trace("no longer cluster-manager: [{}]", source);
                    // history is completed with null, simulating timeout, which assumes that write went through
import org.opensearch.cluster.node.DiscoveryNodes;  
            runRandomly(true, true, EXTREME_DELAY_VARIABILITY);
            // then wait for the new leader to commit a state without the old leader
        public void onNodeAck(DiscoveryNode node, Exception e) {
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.opensearch.common.util.MockPageCacheRecycler;  
                            clusterState(
        assertThat(spec.nextState(7, null, 42), equalTo(Optional.empty()));
                }  
                    throw new AssertionError("unexpected", e);
                    // followup reconfiguration  
                    assertThat(
                            case 0:
    private static final int ELECTION_RETRIES = 10;
                                newVotingConfiguration,
    protected TransportInterceptor getTransportInterceptor(DiscoveryNode localNode, ThreadPool threadPool) {  
    // Pinging all peers twice should be enough to discover all nodes  
                        public ClusterState execute(ClusterState currentState) {
                            );
                    ackCollector.onCommit(commitTime);
            Settings.builder().put(NODE_NAME_SETTING.getKey(), "deterministic-task-queue").build(),  
    // Updating the cluster state involves up to 7 delays:
            for (final ClusterNode clusterNode : clusterNodes) {
                    threadPool  
            }
                cluster.stabilise();
                initialConfiguration
    }
        public void onCommit(TimeValue commitTime) {}
                    );  
                    case SUCCEED:  
                    public void onNoLongerClusterManager(String source) {
            );  
                            new NamedWriteableRegistry(ClusterModule.getNamedWriteables())
                possiblyFail("before writing term of " + currentTerm);
                        .build(); // suppress auto-bootstrap
import org.opensearch.cluster.service.ClusterService;  
            random()
            final int keyRange = randomSteps / 50; // for randomized writes and reads  
                    }
            ClusterSettings clusterSettings,
                final String nodeId = clusterNode.getId();  
            clusterNodes = new ArrayList<>(initialNodeCount);  
            } else {
        }
            }
                return localNode.toString();  
                    nodeHealthService  
            }  
                    nodeIndex,
                    protected Optional<DisruptableMockTransport> getDisruptableMockTransport(TransportAddress address) {
        assertThat(spec.nextState(7, 42, 7), equalTo(Optional.of(42))); // successful write 42 returns previous value 7  
            }
                            // ... then we might not have reliably persisted the cluster state, so emulate a rollback
        for (NodeEnvironment nodeEnvironment : nodeEnvironments) {
                            final long newValue = randomLong();
    @Before
                    @Override  
public class AbstractCoordinatorTestCase extends OpenSearchTestCase {  
                        "Election scheduler should stop after cluster has stabilised",
 */  
        return clusterState.metadata().persistentSettings().getAsLong("value_" + key, 0L);  
import java.util.function.Function;
                        public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {  
                        clusterNode.onNode(() -> {  
                            .map(cn -> cn.mockTransport)  
        class ClusterNode {
    protected ElectionStrategy getElectionStrategy() {
                        @Override
                if (clusterNode.getLocalNode().isClusterManagerNode()) {  
                connectedNodeIds + " should be a quorum of " + lastCommittedConfiguration,  
                                newValue
import org.opensearch.gateway.ClusterStateUpdaters;
                return afterRunRandomly ^ afterStabilisation;  
                    if (oldState.nodeEnvironment != null) {
                    + newNodesCount * 2 * DEFAULT_CLUSTER_STATE_UPDATE_DELAY
                    );
import org.junit.After;  
            deterministicTaskQueue.setExecutionDelayVariabilityMillis(DEFAULT_DELAY_VARIABILITY);
 * under the License.  
                        nodeId + " is not a missing vote for  " + leaderId,
import org.opensearch.test.disruption.DisruptableMockTransport;  
        @Override
            assertTrue(leaderId + " has been bootstrapped", leader.coordinator.isInitialConfigurationSet());  
                onNode(() -> {  
import static org.opensearch.gateway.GatewayService.STATE_NOT_RECOVERED_BLOCK;
        }
            + 4 * DEFAULT_DELAY_VARIABILITY  
                return blackholed;  
                    }
            if (blackholedNodes.contains(sender.getId()) || blackholedNodes.contains(destination.getId())) {  
                        clusterNode.getLastAppliedClusterState().blocks().hasGlobalBlockWithId(NO_CLUSTER_MANAGER_BLOCK_ID),
import java.io.UncheckedIOException;
                        final int key = randomIntBetween(0, keyRange);
                if (abort.get() == false) {  
import org.opensearch.gateway.PersistedClusterStateService;
                coordinator.start();  
            }
            return 0L;  
                        history.remove(eventId);
            return ((Tuple) value).v1();
                    Stream.generate(() -> BOOTSTRAP_PLACEHOLDER_PREFIX + UUIDs.randomBase64UUID(random()))
        boolean nodeExists(DiscoveryNode node) {
                            "----> [runRandomly {}] running until [{}ms] with delay variability of [{}ms]",  
        final VotingConfiguration initialConfiguration;
                    coordinator  
            public PersistedStateStats getStats() {
    // 3. receive PublishResponse
            public void connectToNodes(DiscoveryNodes discoveryNodes, Runnable onCompletion) {  
                    final long submittedTerm = coordinator.getCurrentTerm();
                                    + "but now currentTerm={}, lastAcceptedTerm={}, lastAcceptedVersion={}",
            cleanupActions.add(disconnectedNodes::clear);
    public void closeNodeEnvironmentsAfterEachTest() {
            }  
                return persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL);
                                    xContentRegistry(),
import static java.util.Collections.singleton;  
                }
                    settings,
                        // See #61711 for a particular instance where having unhealthy nodes while cooling down can be problematic.
        );
        nextNodeIndex.set(0);  
                ClusterNode clusterNode = getAnyNode();
                    assertThat(nodeId + " did not change term", clusterNode.coordinator.getCurrentTerm(), is(leaderTerm));
        private List<TransportAddress> provideSeedHosts(SeedHostsProvider.HostsResolver ignored) {
    public void testRepeatableTests() throws Exception {
            DeterministicTaskQueue deterministicTaskQueue,  
            assert filteredNodes.isEmpty() == false;
                return getLocalNode().isClusterManagerNode() == false || coordinator.isInitialConfigurationSet() == false;  
                        nodeEnvironment = null;
        void addNodesAndStabilise(int newNodesCount) {
    }
                    MockPersistedState oldState = (MockPersistedState) persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL);
            }
                            logger.debug(() -> new ParameterizedMessage("failed to publish: [{}]", source), e);
                    null,
                } catch (IOException e) {
import java.util.Collection;
            return unsuccessfulNodes.contains(clusterNode.localNode);
                    }
            );
                connectionStatus = ConnectionStatus.DISCONNECTED;  
import static org.opensearch.cluster.coordination.FollowersChecker.FOLLOWER_CHECK_INTERVAL_SETTING;
            nextAckCollector = new AckCollector();  
            private CoordinationState.PersistedState getPersistedState() {
                            + " to stale version "  
                        nodeIds.add(localNode.getId());
                    throw new UncheckedIOException("Unable to create MockPersistedState", e);
                );
            );
                transportService = mockTransport.createTransportService(
                        clusterNode.onNode(() -> {
                } else {
            }
                return null;
    }
            }
import org.opensearch.cluster.coordination.PersistedStateRegistry.PersistedStateType;
                    // Commit a new cluster state with the new node(s). Might be split into multiple commits, and each might need a
                    .build()
                        nodeId + " has no STATE_NOT_RECOVERED_BLOCK",  
            };
                                newLastAcceptedVersion = randomNonNegativeLong();  
            final long leaderTerm = leader.coordinator.getCurrentTerm();
import org.opensearch.discovery.DiscoveryModule;
                    } else if (rarely()) {
                assert disconnected || unBlackholed == false;
                            nodeId + " has the same applied state as " + leaderId,
        }  
            }
                        if (updatedMetadata != oldState.getLastAcceptedState().metadata() || updatedTerm != oldState.getCurrentTerm()) {  
        private void updateCommittedStates() {
            DiscoveryNode getLocalNode() {  
        DisruptableClusterApplierService(
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
            assertThat(
                        assertTrue(  
                            case 1:
            } else {  
            }  
                lastAcceptedState.getLastCommittedConfiguration(),
        return value(clusterState, 0);
 *
                                newLastAcceptedVersion
                            }
                        BytesStreamOutput outStream = new BytesStreamOutput();  
                            + oldClusterState.version()
                final long afterRunRandomly = value(cluster.getAnyNode().getLastAppliedClusterState());  
        }
                                randomBoolean() ? emptySet() : singleton(randomAlphaOfLength(10))  
                    if (rarely()) {
                leaderId + " has no STATE_NOT_RECOVERED_BLOCK",
                clusterService.setNodeConnectionsService(nodeConnectionsService);
import java.util.function.Consumer;  
            Settings settings,
    }
                lastCommittedConfiguration.getNodeIds(),
                PersistedStateRegistry persistedStateRegistry,
                if (output == null || currentState.equals(output)) {
         * @param delayVariability the delay variability to use while running randomly. Usually {@link Cluster#EXTREME_DELAY_VARIABILITY}.
                            );  
                                    logger.debug("----> [runRandomly {}] disconnecting {}", step, clusterNode.getId());
import org.opensearch.common.settings.Settings;
                    ackCollector.onNodeAck(node, e);
            }
            private DisruptableClusterApplierService clusterApplierService;
            String nodeName,
        }
                            final long lastAcceptedTerm = oldState.getLastAcceptedState().term();
 *     http://www.apache.org/licenses/LICENSE-2.0
                    transportService  
                                    nodeEnvironment,  
        }
                    emptySet(),
                            new ParameterizedMessage("failed to set initial configuration to {}", configurationWithPlaceholders),
                synchronized (coordinator.mutex) {
                                )
                repositoriesService = new RepositoriesService(  
                        nodeEnvironment = oldState.nodeEnvironment;  
                    this::getPersistedState,  
            Version.CURRENT
                delegate.setLastAcceptedState(clusterState);  
        return clusterState.metadata()
        logger.info("Second run with seed [{}]", seed);  
            ) {
                        randomSubsetOf(initialConfiguration.getNodeIds().size(), nodeIdsWithPlaceholders)  
            @Override
        protected PrioritizedOpenSearchThreadPoolExecutor createThreadPoolExecutor() {
            assertThat(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        AckedFakeThreadPoolClusterManagerService(  
                        nodeId + " has NO_CLUSTER_MANAGER_BLOCK",  
                        // reboot random node
        ThreadPool threadPool,
            long finishTime = -1;  
            public void setCurrentTerm(long currentTerm) {
                                .build()  
 * SPDX-License-Identifier: Apache-2.0
                        return clusterNodes.stream()
    }
                if (deterministicTaskQueue.hasDeferredTasks() == false) {
            List<ClusterNode> acceptableNodes = this.clusterNodes.stream()
        boolean hasAcked(ClusterNode clusterNode) {
            ClusterState getLastAppliedClusterState() {
                Function<Metadata, Metadata> adaptGlobalMetadata,
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            }
                        }  
        for (int key : keySet(clusterState1)) {
        }
        // If leader just blackholed, need to wait for this to be detected
 * ownership. Elasticsearch licenses this file to you under  
        }  
import static org.opensearch.node.Node.NODE_NAME_SETTING;
                }
                    allNodesClusterManagerEligible || i == 0 || randomBoolean(),
        private List<TransportAddress> seedHostsList;
                assertConsistentStates();
                        final int key = randomIntBetween(0, keyRange);  
    public void resetPortCounterBeforeEachTest() {
                    case FAIL:  
                    assertThat(
                        mockGatewayMetaState = new MockGatewayMetaState(localNode, bigArrays);
                                break;  
                    } else if (allowReboots && rarely()) {  
                        // remove event to help avoid bloated history and state space explosion in linearizability checker
        void blackholeConnectionsFrom(ClusterNode sender, ClusterNode destination) {
                    assertTrue(nodeId + " has been bootstrapped", clusterNode.coordinator.isInitialConfigurationSet());  
            } else if (nodeExists(sender) && nodeExists(destination)) {  
import org.opensearch.repositories.RepositoriesService;
                            );
                    // In the real-life IOError might be thrown, for example if state fsync fails.
                    return clusterNode;  
                clusterNodes.add(clusterNode);
            + defaultMillis(PUBLISH_TIMEOUT_SETTING) + DEFAULT_ELECTION_DELAY  
                                    deterministicTaskQueue::getCurrentTimeMillis
    public void assertAllPersistedStatesClosed() {  
                } finally {
    private final SequentialSpec spec = new LinearizabilityChecker.KeyedSpec() {
                            clusterNode.submitSetAutoShrinkVotingConfiguration(autoShrinkVotingConfiguration);
                    .filter(n -> n.getLocalNode().isClusterManagerNode())
            }  
                    logger.trace("closing");
import org.opensearch.monitor.StatusInfo;  
    // 1. submit the task to the cluster-manager service
                                    logger.debug("----> [runRandomly {}] blackholing {}", step, clusterNode.getId());
    public void testRegisterSpecConsistency() {
                            nodeId + " is in its own latest applied state",
                        // reads do not change state
                } catch (CoordinationStateRejectedException | UncheckedIOException ignored) {
                            synchronized (clusterNode.coordinator.mutex) {  
        }  
                        leader.getLastAppliedClusterState().getNodes().nodeExists(nodeId)
                        // ignore result
            boolean disconnect() {
            final int randomSteps = scaledRandomIntBetween(10, 10000);
                }  
                        clusterNodes.forEach(cn -> deterministicTaskQueue.scheduleNow(cn.onNode(new Runnable() {
                    @Override
                        nodeEnvironment = newNodeEnvironment();
                    } else {
        List<ClusterNode> addNodes(int newNodesCount) {
                    nodeSettings,
                    settings,
                }  
                        wrapped.run();
                                clusterNode.coordinator.becomeCandidate("runRandomly");
import static org.hamcrest.Matchers.is;  
        }  
            return randomFrom(  
                super.onNewClusterState(source, clusterStateSupplier, listener);  
                // The first pinging discovers the cluster-manager
        }  
                                clusterNode.getId()
                            && randomBoolean()) {
            int step = 0;
                coordinator.setNodeConnectionsService(nodeConnectionsService);
import org.opensearch.cluster.ClusterState;
                possiblyFail("before writing last-accepted state of term=" + clusterState.term() + ", version=" + clusterState.version());
                for (final DiscoveryNode discoveryNode : discoveryNodes) {  
import org.opensearch.core.common.transport.TransportAddress;
        class MockPersistedState implements CoordinationState.PersistedState {
            }
                return disconnected;
                                newLocalNode,
            return randomFrom(filteredNodes);  
            }
                boolean disconnected = disconnectedNodes.add(localNode.getId());  
                } catch (IOException e) {  
            seedHostsList = emptyList();
                            clusterNode.getLastAppliedClusterState().getVersion(),  
            } else {
                boolean success = false;  
                            && newLocalNode.isClusterManagerNode()) == false
            return n1 == n2
                            .filter(transport -> transport.getLocalNode().getAddress().equals(address))
                deterministicTaskQueue.getExecutionDelayVariabilityMillis(),  
            }
                                    + "previously currentTerm={}, lastAcceptedTerm={}, lastAcceptedVersion={} "  
                            final VotingConfiguration newVotingConfiguration = new VotingConfiguration(
                        nodeId + " has correct cluster-manager",
        logger.info("First run with seed [{}]", seed);
        int size() {
            while (deterministicTaskQueue.getCurrentTimeMillis() < endTime) {
        }
                        nullValue()  
                return new ClusterNode(
import static org.hamcrest.Matchers.empty;
                clusterApplierService = new DisruptableClusterApplierService(  
                    }
        private final ConnectionStatus preferredUnknownNodeConnectionStatus = randomFrom(
            for (final ClusterNode clusterNode : clusterNodes) {
                        final ClusterState oldClusterState = event.previousState();
                        // instead, complete history when checking for linearizability
    protected final List<NodeEnvironment> nodeEnvironments = new ArrayList<>();
                        clusterNode.onNode(() -> {
                            case 2:
                        );  
            );
        }  
                clusterManagerEligibleNodeIds,  
                        final Metadata updatedMetadata = adaptGlobalMetadata.apply(oldState.getLastAcceptedState().metadata());
import java.util.Set;
                            final long newLastAcceptedTerm;
                        clusterNode.getLastAppliedClusterState().nodes().getClusterManagerNode(),
                try {  
            logger.info("--> start of safety phase of at least [{}] steps with delay variability of [{}ms]", randomSteps, delayVariability);
            this.applicationMayFail = true;
        static final long DEFAULT_DELAY_VARIABILITY = 100L;
            MockPersistedState(DiscoveryNode localNode) {
        @Override
            assertThat("may reconnect disconnected nodes, probably unexpected", disconnectedNodes, empty());  
                assert blackholed || unDisconnected == false;
                        public void onNoLongerClusterManager(String source) {  
                    public void onFailure(String source, Exception e) {
                connectionStatus = ConnectionStatus.BLACK_HOLE_REQUESTS_ONLY;
import static java.util.Collections.emptySet;
                    // apply cluster state, but don't notify listener  
            final Settings nodeSettings;
import org.opensearch.cluster.metadata.Metadata;  
                        }).run();
import java.util.ArrayList;
                    );
    }
            // Large histories can be problematic and have the linearizability checker run OOM
                        isEqualToLeaderVersion
                            clusterManagerService.nextAckCollector = ackCollector;
                        .build(),
                        history.respond(eventId, value(newState, key));  
        final long seed = randomLong();  
        }
            private final DiscoveryNode localNode;  
                return clusterApplierService.state();
}
                    coordinator.close();  
                transportService.acceptIncomingRequests();
        }  
                        final ClusterNode clusterNode = getAnyNode();  
                }  
                try {  
            }
                            assertNotNull("State not committed : " + newState.toString(), state);  
                }
            List<ClusterNode> filteredNodes = getAllNodesExcept(clusterNodes);
            private RemoteStoreNodeService remoteStoreNodeService;
            }  
                final long afterStabilisation = value(cluster.getAnyNode().getLastAppliedClusterState());
                );
        }
import static org.opensearch.cluster.coordination.Coordinator.Mode.CANDIDATE;
            List<BiConsumer<DiscoveryNode, ClusterState>> extraJoinValidators = new ArrayList<>();
                : new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());  
        List<ClusterNode> getAllNodesExcept(ClusterNode... clusterNodes) {  
import static org.opensearch.monitor.StatusInfo.Status.HEALTHY;  
                    "test_node",
    }
                } catch (IOException e) {
                    NoopTracer.INSTANCE  
            logger.debug("running {} cleanup actions", cleanupActions.size());
                );
                            final Metadata updatedMetadata = adaptGlobalMetadata.apply(oldState.getLastAcceptedState().metadata());  
                clusterApplierService.allowClusterStateApplicationFailure();
                        clusterNode.getLastAppliedClusterState().blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK),
        resetPortCounter();  
        private boolean disruptStorage;  
            void onDisconnectEventFrom(ClusterNode clusterNode) {  
            blackholedConnections.add(Tuple.tuple(sender.getId(), destination.getId()));
                    for (final ClusterNode clusterNode : clusterNodes) {
                        final int newValue = randomInt();
            private boolean isNotUsefullyBootstrapped() {
                        .putList(  
            public TestInMemoryMetricsRegistry getMetricsRegistry() {  
    public static final long DEFAULT_ELECTION_DELAY
    public static final long DEFAULT_STABILISATION_TIME =
import java.util.Arrays;  
                        final boolean autoShrinkVotingConfiguration = randomBoolean();
                        leader.coordinator.missingJoinVoteFrom(clusterNode.getLocalNode())
                                    newLastAcceptedTerm == lastAcceptedTerm ? lastAcceptedVersion - 1 : Long.MAX_VALUE
                                if (finishTime == -1 && clusterNode.blackhole()) {  
            assertThat("leaders", allLeaders, not(empty()));
    /**
import org.opensearch.cluster.routing.allocation.AllocationService;
            blackholedConnections.clear();  
                        // in this case, we know for sure that event was not processed by the system and will not change history  
                }
                            taskListener.onNoLongerClusterManager(source);
                onCompletion.run();  
                    }  
            logger.info("checking linearizability of history with size {}: {}", history.size(), history);
                        delegate = new InMemoryPersistedState(  
            ) {
                successfulNodes.add(node);
                .map(ClusterNode::getId)
                            ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING.get(Settings.EMPTY)
import org.opensearch.cluster.ClusterManagerMetrics;
                }
                            if (lastAcceptedVersion == 0L) {
import java.util.Map;  
    public ClusterState setValue(ClusterState clusterState, int key, long value) {
                    @Override
                        delegate = gatewayMetaState.getPersistedState();  
                                newLastAcceptedVersion,
 * Licensed to Elasticsearch under one or more contributor  
            }
import org.opensearch.discovery.SeedHostsProvider;
    public void assertStateEquals(ClusterState clusterState1, ClusterState clusterState2) {  
            void submitSetAutoShrinkVotingConfiguration(final boolean autoShrinkVotingConfiguration) {  
                final ClusterNode clusterNode = new ClusterNode(nextNodeIndex.getAndIncrement(), true, Settings.EMPTY, nodeHealthService);
                        logger.debug("ignoring benign exception thrown when stabilising", e);
                    assertThat(nodeId + " has the same term as " + leaderId, clusterNode.coordinator.getCurrentTerm(), is(leaderTerm));
                "leader " + leader.getLocalNode() + " should be part of voting configuration " + lastCommittedConfiguration,
                    cs -> ClusterState.builder(cs)  
            if (clusterStateApplyResponse == ClusterStateApplyResponse.HANG) {
            try {
                        final ClusterNode clusterNode = getAnyNode();
                // history is completed with null, simulating timeout, which assumes that read went through
                    return Optional.of(currentState);  
                int nodeIndex,
                            logger.trace(
                // just update targetsByNode to ensure disconnect runs for these nodes
/*
                    }
            } else {  
                    new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)  
                                newLastAcceptedTerm,  
            }
        final List<ClusterNode> clusterNodes;
         * Apply the state (default)
    }  
            AckCollector submitValue(final int key, final long value) {
                    super.onNewClusterState(source, clusterStateSupplier, (source1, e) -> {
            + (defaultMillis(FOLLOWER_CHECK_INTERVAL_SETTING) + defaultMillis(FOLLOWER_CHECK_TIMEOUT_SETTING)) * defaultInt(
    }  
                            persistedCurrentTerm = oldState.getCurrentTerm();
        assertThat(spec.nextState(7, 42, null), equalTo(Optional.of(42))); // write 42 times out
                            assertThat(currentState.term(), greaterThanOrEqualTo(submittedTerm));  
    /**
                );
            Set<String> forbiddenIds = Arrays.stream(clusterNodes).map(ClusterNode::getId).collect(Collectors.toSet());
 * GitHub history for details.
import java.util.HashMap;  
import org.opensearch.cluster.OpenSearchAllocationTestCase;
                    clusterManagerService.submitStateUpdateTask(source, new ClusterStateUpdateTask() {  
        void runRandomly() {  
            final ClusterNode leader = getAnyLeader();  
                    new ClusterManagerMetrics(metricsRegistry),
                    if (success == false) {
            assertThat(  
            final Matcher<Long> isEqualToLeaderVersion = equalTo(leader.coordinator.getLastAcceptedState().getVersion());  
            updateCommittedStates();
        void allowClusterStateApplicationFailure() {  
                try {  
            final AtomicBoolean abort = new AtomicBoolean();  
                        leader.getLastAppliedClusterState().getNodes().nodeExists(nodeId)  
import static org.opensearch.cluster.coordination.ElectionSchedulerFactory.ELECTION_INITIAL_TIMEOUT_SETTING;
                return submitUpdateTask("new value [" + value + "]", cs -> setValue(cs, key, value), new ClusterStateTaskListener() {
        }  
                            ClusterStateUpdaters.addStateNotRecoveredBlock(
                    ? preferredUnknownNodeConnectionStatus
            boolean heal() {  
                final Runnable wrapped = onNodeLog(localNode, runnable);  
                        logger.debug("----> [runRandomly {}] reducing delay variability and running until [{}ms]", step, finishTime);  
                                newValue,  
                        .metadata(
                        @Override
            Consumer<Runnable> onTaskAvailableToRun
                    public void onFailure(String source, Exception e) {  
            assertTrue(
                defaultMillis(DISCOVERY_FIND_PEERS_INTERVAL_SETTING)
            }  
                return localNode.getId();  
                    persistedStateRegistry,
                                persistedCurrentTerm,  
            // then wait for a follower to be promoted to leader  
import static org.opensearch.cluster.coordination.NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID;
                                    updatedTerm,
        ClusterNode getAnyNodePreferringLeaders() {
                "stabilisation requires default delay variability (and proper cleanup of raised variability)",
            ClusterNode(  
        @Override
            final ScheduledThreadPoolExecutor scheduler = Scheduler.initScheduler(Settings.EMPTY);  
            ) {
                        break;
 * compatible open source license.
            }
        return NOOP_TRANSPORT_INTERCEPTOR;
                    clusterSettings,  
                .collect(Collectors.toList());
        @Nullable // null means construct a list from all the current nodes  
            .build();
                    @Override
            bootstrapIfNecessary();
            String nodeName,  
                assertFalse(nodeId + " should not have an active publication", clusterNode.coordinator.publicationInProgress());
                    assertFalse(
                    UUIDs.randomBase64UUID(random()), // generated deterministically for repeatable tests  
import static java.util.Collections.emptyList;
        }  
            }  
                    }  
import org.opensearch.core.common.io.stream.StreamInput;
            clusterManagerEligible ? DiscoveryNodeRole.BUILT_IN_ROLES : emptySet(),  
            for (int i = 0; i < initialNodeCount; i++) {
                    threadPool,
                gatewayService.start();
                    Collections.emptyMap(),
                            + newClusterState.version();
            private final Logger logger = LogManager.getLogger(ClusterNode.class);
                clusterManagerService.setClusterStatePublisher(coordinator);
        return new Runnable() {
    static class AckCollector implements ClusterStatePublisher.AckListener {
                ClusterStateTaskListener taskListener  
                clusterManagerService = new AckedFakeThreadPoolClusterManagerService(
        }
            );
import org.apache.logging.log4j.Logger;
        void setEmptySeedHostsList() {  
                }
            } else if (disconnectedNodes.contains(sender.getId()) || disconnectedNodes.contains(destination.getId())) {
                }).run();  
import org.opensearch.common.settings.ClusterSettings;  
                );  
            address,
                    });
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                            final long newLastAcceptedVersion;
                        );
                    }  
                    // initial configuration should not have a place holder for local node
                Matchers.hasItem(leader.getLocalNode().getId())  
                        @Override
                        }
                        clusterNode.coordinator.invariant();
            .collect(Collectors.toSet());
                initialNodeCount,
                    clusterService.stop();  
                            deterministicTaskQueue.getExecutionDelayVariabilityMillis()  
    }  
                        clusterNode.close();
                        logger.debug("----> [runRandomly {}] rebooting [{}]", thisStep, clusterNode.getId());  
            public long getCurrentTerm() {  
        return setting.get(Settings.EMPTY).millis() + DEFAULT_DELAY_VARIABILITY;  
        }
                Function<Metadata, Metadata> adaptGlobalMetadata,  
                                // Avoid disruptions during cool down period
                logger.trace("starting up [{}]", localNode);  
                unsuccessfulNodes.add(node);
        void runRandomly(boolean allowReboots, boolean coolDown, long delayVariability) {
                        logger.info(  
            assertTrue("duplicate ack from " + node, ackedNodes.add(node));  
                leaderId + " has no NO_CLUSTER_MANAGER_BLOCK",  
        ClusterNode getAnyBootstrappableNode() {
                                newLastAcceptedVersion = randomLongBetween(  
        public Object getValue(Object value) {  
            }  
                    }  
                        (oldState.getLastAcceptedState().nodes().getLocalNode().isClusterManagerNode()  
        }
            cleanupActions.add(blackholedNodes::clear);
                                thisStep,  
                    logger.trace("simulating IO exception [{}]", description);
                    updateCommittedStates();
                        }).run();
                    );
 * specific language governing permissions and limitations
        }
import org.opensearch.cluster.service.FakeThreadPoolClusterManagerService;
import java.util.stream.Collectors;
     */
import org.opensearch.Version;
    protected final AtomicInteger nextNodeIndex = new AtomicInteger();
                        // adapt cluster state to new localNode instance and add blocks  
                                    ClusterState.builder(oldState.getLastAcceptedState()).metadata(updatedMetadata).build()  
        @Override
        private final Set<String> blackholedNodes = new HashSet<>();
    @Before
                addedNodes.add(clusterNode);
                    try {
                || (getConnectionStatus(n1.getLocalNode(), n2.getLocalNode()) == ConnectionStatus.CONNECTED  
                    @Override  
        }
                    assertThat(  
                    createDiscoveryNode(nodeIndex, clusterManagerEligible),
                    if (finishTime == -1 && randomBoolean() && randomBoolean() && randomBoolean()) {
                                if (finishTime == -1 && clusterNode.disconnect()) {  
            Collections.emptyMap(),
                    : Settings.builder()
                            logger.debug(
                    success = true;  
                        );
                return nodeId + ": " + runnable.toString();
            while (finishTime == -1 || deterministicTaskQueue.getCurrentTimeMillis() <= finishTime) {
                    localNode.getId(),
                                break;  
    // 4. send ApplyCommitRequest
import static org.opensearch.cluster.coordination.CoordinationStateTestCluster.clusterState;  
                    );
    class Cluster implements Releasable {
        void clearBlackholedConnections() {
                coordinator = new Coordinator(
                    onNodeLog(localNode, this::setUp).run();
import org.junit.Before;
                final ThreadPool threadPool = deterministicTaskQueue.getThreadPool(this::onNode);  
                assertThat("must add nodes to a cluster before closing them", clusterNodes, hasItem(ClusterNode.this));
            private final int nodeIndex;
                    )
        return new NodeConnectionsService(settings, threadPool, transportService) {
                    clusterService,
            private MockGatewayMetaState mockGatewayMetaState;  
                        .forEach(nodeIdsWithPlaceholders::add);
         */
                assertTrue("must use a fresh PersistedState", openPersistedStates.add(persistedState));
import java.io.IOException;  
    enum ClusterStateApplyResponse {
                    Collections.emptyMap(),
import org.hamcrest.Matchers;
            boolean blackhole() {
import org.opensearch.cluster.coordination.AbstractCoordinatorTestCase.Cluster.ClusterNode;  
                NodeHealthService nodeHealthService
        final TransportAddress address = buildNewFakeTransportAddress();  
        assertThat(spec.initialState(), equalTo(0L));
                                oldState.getLastAcceptedState().writeTo(outStream);
                    }
                    final Set<String> nodeIdsWithPlaceholders = new HashSet<>(initialConfiguration.getNodeIds());
                        nodeId + " has no NO_CLUSTER_MANAGER_BLOCK",
                ? BigArrays.NON_RECYCLING_INSTANCE
                                newVotingConfiguration,  
                    finishTime = deterministicTaskQueue.getLatestDeferredExecutionTime();  
            }  
                    assertThat(nodeId + " is still the leader", clusterNode.coordinator.getMode(), is(LEADER));
                    Version.CURRENT
                step++;  
                        final ClusterNode clusterNode = getAnyNodePreferringLeaders();  
import static org.opensearch.cluster.coordination.AbstractCoordinatorTestCase.Cluster.DEFAULT_DELAY_VARIABILITY;
                    }
        private ConnectionStatus getConnectionStatus(DiscoveryNode sender, DiscoveryNode destination) {
        public Optional<Object> nextState(Object currentState, Object input, Object output) {
        }  
            resetNodeIndexBeforeEachTest();  
                );
                final int eventId = history.invoke(new Tuple<>(key, value));  
                        final ClusterNode clusterNode = getAnyNode();  
        }  
            return this.applicationMayFail;  
            "node" + nodeIndex,  
            final Set<String> connectedNodeIds = clusterNodes.stream()
                clusterService = new ClusterService(settings, clusterSettings, clusterManagerService, clusterApplierService);
        ) {
                    Randomness.get(),
    // 6. receive ApplyCommitResponse
                        // Heal all nodes BEFORE finishTime is set so it can take into account any pending disruption that
                    ackListener.onCommit(commitTime);
                    // transportService.stop(); // does blocking stuff :/
            }
import org.opensearch.common.SetOnce;
                            deterministicTaskQueue.runRandomTask();
            .stream()
import java.util.function.BiConsumer;
                .filter(n -> isConnectedPair(leader, n))  
                        } else {
    }  
                                autoShrinkVotingConfiguration,
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            @Override
                                if (clusterNode.heal()) {  
        Cluster(int initialNodeCount, boolean allNodesClusterManagerEligible, Settings nodeSettings, NodeHealthService nodeHealthService) {
                    writableRegistry(),  
                            ).writeTo(outStream);  
import org.opensearch.cluster.coordination.LinearizabilityChecker.SequentialSpec;
                    nodeSettings,
            return connectionStatus;
                }
                            clusterNode.getLastAppliedClusterState().getNodes().nodeExists(nodeId)
                    nextNodeIndex.getAndIncrement(),  
                }
                        // would prevent the cluster to reach a stable state after cooling down. Additionally, avoid any new disruptions  
import static org.opensearch.cluster.coordination.Coordinator.Mode.FOLLOWER;
            // perhaps there is an election collision requiring another publication (which times out) and a term bump
            public ClusterState getLastAcceptedState() {
                            finishTime,
            ClusterStateApplyResponse getClusterStateApplyResponse() {
import org.opensearch.cluster.node.DiscoveryNodeRole;
                                oldState.getCurrentTerm(),  
                }
            final List<Runnable> cleanupActions = new ArrayList<>();  
            ClusterNode restartedNode(  
import org.opensearch.cluster.node.DiscoveryNode;
            } else {
 * license agreements. See the NOTICE file distributed with
        void bootstrapIfNecessary() {  
                try {
            public void close() {  
        void stabilise() {
            final String leaderId = leader.getId();
            assertThat(leader.getLastAppliedClusterState().getNodes().getSize(), equalTo(connectedNodeIds.size()));
                Function<Long, Long> adaptCurrentTerm,
                                lastAcceptedVersion,
import static org.hamcrest.Matchers.equalTo;
                    clusterManagerService,
import java.util.Optional;
            return addedNodes;
/*
                final GatewayService gatewayService = new GatewayService(  
                                }
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(
            }
            if (input == null) {  
        }
                lessThanOrEqualTo(DEFAULT_DELAY_VARIABILITY)
            }
         */  
                    );
                this.nodeSettings = nodeSettings;
            Coordinator coordinator;
                            } else {  
            cleanupActions.forEach(Runnable::run);  
        ClusterStateApplyResponse clusterStateApplyResponse = ClusterStateApplyResponse.SUCCEED;
        @Override  
import static org.opensearch.cluster.coordination.ElectionSchedulerFactory.ELECTION_BACK_OFF_TIME_SETTING;
                    nodeSettings,
            .keySet()  
                        equalTo(false)
                clusterNode.coordinator.invariant();  
                            // ... and we're feeling lucky ...
import org.opensearch.gateway.GatewayService;
                        assert oldClusterState.version() <= newClusterState.version() : "updating cluster state from version "
            return new MockSinglePrioritizingExecutor(nodeName, deterministicTaskQueue, threadPool);
            ClusterNode(int nodeIndex, boolean clusterManagerEligible, Settings nodeSettings, NodeHealthService nodeHealthService) {
                        @Override
                deterministicTaskQueue.advanceTime();
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {  
                    if (coolDown) {
            @Override
                        history.remove(eventId);
import java.util.Collections;
                this.localNode = localNode;  
    protected final Set<Cluster.MockPersistedState> openPersistedStates = new HashSet<>();  
                            && (oldState.getLastAcceptedState().term() > 0L || oldState.getLastAcceptedState().version() > 0L)  
        assertEquals(clusterState1.version(), clusterState2.version());
        private final Set<Tuple<String, String>> blackholedConnections = new HashSet<>();  
                        clusterNode.coordinator.getLastAcceptedState().getVersion(),  
            + DEFAULT_CLUSTER_STATE_UPDATE_DELAY;
        void stabilise(long stabilisationDurationMillis) {  
import static org.opensearch.cluster.coordination.Reconfigurator.CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION;  
            );  
            super(nodeName, serviceName, threadPool, onTaskAvailableToRun);  
                runFor(defaultMillis(CONNECT_TIMEOUT) + // may be in a prior connection attempt which has been blackholed
                    newLocalNode,  
                            } else {
                switch (clusterStateApplyResponse) {
                            logger.debug("----> [runRandomly {}] reading value from [{}]", thisStep, clusterNode.getId());  
                                newLocalNode,
            .persistentSettings()
     * Responses that time out are modeled by returning null. Successful writes return the previous value of the register.  
                    (s, p, r) -> {},
                persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, persistedState);
                        }
                    "test",
     * How to behave with a new cluster state  
                }
                    threadPool,
import org.opensearch.gateway.MockGatewayMetaState;  
                            clusterNode.submitValue(key, newValue);  
        }
                    address.getAddress(),
import static org.opensearch.transport.TransportService.NOOP_TRANSPORT_INTERCEPTOR;
                        }  
            }
                        if (clusterNodes.contains(ClusterNode.this) == false) {
            final PersistedStateRegistry persistedStateRegistry;
        }
        ClusterNode getAnyNodeExcept(ClusterNode... clusterNodes) {  
            assertThat(
    }
                    assertThat(  
        private final Map<Long, ClusterState> committedStatesByVersion = new HashMap<>();
        private final List<DiscoveryNode> unsuccessfulNodes = new ArrayList<>();
                ClusterState applierState = clusterNode.coordinator.getApplierState();
                        logger.info("successfully set initial configuration to {}", configurationWithPlaceholders);
                }
import org.opensearch.env.NodeEnvironment;  
                        final ClusterNode clusterNode = getAnyNode();
            }
            }  
            return getAnyNode();  
            // Then wait for an election to be scheduled; we allow enough time for retries to allow for collisions
                "--> creating cluster of {} nodes (cluster-manager-eligible nodes: {}) with initial configuration {}",
import org.opensearch.common.util.concurrent.PrioritizedOpenSearchThreadPoolExecutor;
import org.opensearch.monitor.NodeHealthService;
import java.util.concurrent.Callable;  
        @Override  
                }).run();
            boolean isCandidate() {
        static final long EXTREME_DELAY_VARIABILITY = 10000L;
import org.opensearch.common.unit.TimeValue;  
            try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {
        final String nodeId = getNodeIdForLogContext(node);  
                    });  
            }  
                persistedStateRegistry = persistedStateRegistry();  
            void readValue(int key) {
                    assertFalse(
                    );
                            isEqualToLeaderVersion
            .metadata(  
                    .persistentSettings(
import static org.opensearch.cluster.coordination.FollowersChecker.FOLLOWER_CHECK_TIMEOUT_SETTING;
                connectionStatus = ConnectionStatus.CONNECTED;
                DiscoveryNode localNode,
                    }  
                                newLastAcceptedTerm,
            }  
            ThreadPool threadPool,  
                if (disruptStorage && rarely()) {  
            void close() {
                        if (deterministicTaskQueue.hasDeferredTasks() && randomBoolean()) {
                assertThat("setting initial configuration may fail with disconnected nodes", disconnectedNodes, empty());
            }
                    nodeHealthService  
                return Optional.empty();
                        }  
                            e
    }
            runFor((pendingTaskCount + 1) * DEFAULT_CLUSTER_STATE_UPDATE_DELAY, "draining task queue");
        }
                submitUpdateTask(
                String source,
                                cn.transportService.disconnectFromNode(clusterNode.getLocalNode());
                    clusterService.close();
                    settings,
                assertThat("setting initial configuration may fail with blackholed nodes", blackholedNodes, empty());  
            } finally {  
            // null input is read, non-null is write
import static org.hamcrest.Matchers.nullValue;  
 * the Apache License, Version 2.0 (the "License"); you may
                return coordinator.getMode() == CANDIDATE;  
                    && getConnectionStatus(n2.getLocalNode(), n1.getLocalNode()) == ConnectionStatus.CONNECTED)
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
            + DEFAULT_ELECTION_DELAY
                    allocationService,
            return seedHostsList != null  
    public static final String NODE_ID_LOG_CONTEXT_KEY = "nodeId";
                        return Cluster.this.getConnectionStatus(getLocalNode(), destination);  
        private final BigArrays bigArrays;
                        }
                                }
                clusterService.start();
                });  
                    threadPool,
                            ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(),
                            }
    }  
            return ((Tuple) value).v2();
        private final Function<DiscoveryNode, MockPersistedState> defaultPersistedStateSupplier = MockPersistedState::new;
                final int eventId = history.invoke(new Tuple<>(key, null));
        assertEquals(keySet(clusterState1), keySet(clusterState2));  
        }
            return new ClusterStatePublisher.AckListener() {
                        if ( // node is cluster-manager-ineligible either before or after the restart ...
        Cluster(int initialNodeCount) {  
            @Override
                }
                        clusterNode.getLastAppliedClusterState().nodes().getClusterManagerNode(),  
                }
                Settings nodeSettings  
                lastCommittedConfiguration.hasQuorum(connectedNodeIds)
            // investigate this more closely.  
                if (history.size() > 300) {
                    address.address().getHostString(),
            MockPersistedState(  
        = defaultMillis(DISCOVERY_FIND_PEERS_INTERVAL_SETTING) * 2
                    defaultPersistedStateSupplier,  
                        // to happen in this phase.
                        })));  
        assertEquals(result1, result2);
import org.opensearch.common.Randomness;  
            // Allow two round-trip for pre-voting and voting
                            public String toString() {  
            bigArrays = usually()
import java.util.concurrent.atomic.AtomicBoolean;  
        assertThat(spec.nextState(7, null, null), equalTo(Optional.of(7))); // read times out  
                    try {
                    (source, e) -> {}  
                            updateCommittedStates();
                    } else if (rarely()) {
                            taskListener.clusterStateProcessed(source, oldState, newState);  
                    protected ConnectionStatus getConnectionStatus(DiscoveryNode destination) {
            }
import org.opensearch.common.UUIDs;
                assertTrue(openPersistedStates.remove(this));
                        logger.debug(
                    Cluster.this::provideSeedHosts,
            @Override  
                    && (n1.nodeHealthService.getHealth().getStatus() == HEALTHY && n2.nodeHealthService.getHealth().getStatus() == HEALTHY);
import org.opensearch.test.disruption.DisruptableMockTransport.ConnectionStatus;
    protected static long defaultMillis(Setting<TimeValue> setting) {
                final MockPersistedState persistedState = persistedStateSupplier.apply(localNode);
            )  
                    }  
                        equalTo(false)  
                                    new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
        private void assertConsistentStates() {
            );
    }
                    }
import java.util.function.Supplier;
            }
                transportService.disconnectFromNode(clusterNode.localNode);
                    @Override
                        clusterNode.getLastAppliedClusterState().blocks().hasGlobalBlockWithId(NO_CLUSTER_MANAGER_BLOCK_ID),
                final DiscoveryNode newLocalNode = new DiscoveryNode(  
                    clusterSettings,
                .filter(n -> forbiddenIds.contains(n.getId()) == false)  
 * software distributed under the License is distributed on an
        @Override  
                logger.info("setting initial configuration not required");  
import org.apache.logging.log4j.message.ParameterizedMessage;
                NodeConnectionsService nodeConnectionsService = createTestNodeConnectionsService(  
import org.opensearch.common.Nullable;
                    "set cluster-manager nodes failure tolerance [" + autoShrinkVotingConfiguration + "]",
            + DEFAULT_CLUSTER_STATE_UPDATE_DELAY;  
            }
            assertThat(
                        )
                        clusterNode.onNode(() -> {
     * Simple register model. Writes are modeled by providing an integer input. Reads are modeled by providing null as input.
                );
                            Metadata.builder(cs.metadata())
import java.util.HashSet;
        }
                                        .put(CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION.getKey(), autoShrinkVotingConfiguration)  
                );
                    final Set<String> nodeIds = new HashSet<>(
                        delegate = new InMemoryPersistedState(
                        );  
        }  
                    @Override
                final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                                ClusterState.builder(oldState.getLastAcceptedState()).metadata(updatedMetadata).build().writeTo(outStream);
                connectionStatus = usually()  
                FOLLOWER_CHECK_RETRY_COUNT_SETTING  
        }
    static class DisruptableClusterApplierService extends ClusterApplierService {
            for (final ClusterNode clusterNode : clusterNodes) {  
                }
            }
                        }  
                            taskListener.onFailure(source, e);
    }
        assertEquals(clusterState1.term(), clusterState2.term());
                    );  
                return delegate.getCurrentTerm();
        Settings settings,  
                    case HANG:
    public long value(ClusterState clusterState, int key) {
        /**  
 * The OpenSearch Contributors require contributions made to  
                    throw new UncheckedIOException(new IOException("simulated IO exception [" + description + ']'));
        );
                    clusterApplierService,
                        clusterNode.applyInitialConfiguration();
                while (deterministicTaskQueue.hasRunnableTasks()) {
                                ).createWriter()
                    runnable.run();
                @Override
        TransportService transportService
import org.hamcrest.Matcher;
                try {
import static org.hamcrest.Matchers.not;
        return setting.get(Settings.EMPTY);
                }).run();
import org.apache.logging.log4j.CloseableThreadContext;
                        nodeId + " has the same accepted state as " + leaderId,
 * this work for additional information regarding copyright
        }
                    localNode.getName(),
                                "----> [runRandomly {}] setting auto-shrink configuration to {} on {}",
import static org.opensearch.cluster.coordination.LeaderChecker.LEADER_CHECK_RETRY_COUNT_SETTING;  
                        nodeId + " has no cluster-manager",
                    scheduler.schedule(() -> abort.set(true), 10, TimeUnit.SECONDS);  
                    assertFalse(  
                            }
                            }
        private final String nodeName;  
            AckCollector submitValue(final long value) {
                boolean unDisconnected = disconnectedNodes.remove(localNode.getId());
                    allocationService,
            @Override
            address.address().getHostString(),
        @Override
                boolean unBlackholed = blackholedNodes.remove(localNode.getId());
            private NodeHealthService nodeHealthService;
                if (clusterNode == leader) {  
                    runnable -> deterministicTaskQueue.scheduleNow(onNode(runnable))  
                        );
                );
    // 7. apply committed state on cluster-manager (last one to apply cluster state)
            );
                            return clusterStateUpdate.apply(currentState);
        }  
        }
            }
 * Modifications Copyright OpenSearch Contributors. See  
    static class AckedFakeThreadPoolClusterManagerService extends FakeThreadPoolClusterManagerService {
                leader.improveConfiguration(lastAcceptedState),
                    } else if (rarely()) {
            + defaultMillis(ELECTION_INITIAL_TIMEOUT_SETTING) * ELECTION_RETRIES + defaultMillis(ELECTION_BACK_OFF_TIME_SETTING)  
import org.opensearch.threadpool.Scheduler;  
                boolean unDisconnected = disconnectedNodes.remove(localNode.getId());  
    // 2. send PublishRequest  
                    );  
            Runnable onNode(Runnable runnable) {
 *
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
                        final ClusterNode clusterNode = getAnyNodePreferringLeaders();
            .filter(s -> s.startsWith("value_"))
            return clusterNodes.size();  
                final TransportAddress address = randomBoolean() ? buildNewFakeTransportAddress() : localNode.getAddress();
 * Unless required by applicable law or agreed to in writing,
            } else if (blackholedConnections.contains(Tuple.tuple(sender.getId(), destination.getId()))) {
                ThreadPool.terminate(scheduler, 1, TimeUnit.SECONDS);
            clusterNodes.addAll(addedNodes);
        nodeEnvironments.clear();
                        .limit((Math.max(initialConfiguration.getNodeIds().size(), 2) - 1) / 2)  
                    // transportService.close(); // does blocking stuff :/
                            try (
        assertThat(openPersistedStates, empty());
                    }  
import org.opensearch.cluster.ClusterStateUpdateTask;  
                );  
                    a -> localNode,  
                    continue;  
        }  
                        delegate = mockGatewayMetaState.getPersistedState();  
        ClusterNode getAnyNode() {
            this.nodeHealthService = nodeHealthService;  
                final AckCollector ackCollector = new AckCollector();
                            ClusterState state = committedStatesByVersion.get(newState.version());
                        deterministicTaskQueue.setExecutionDelayVariabilityMillis(DEFAULT_DELAY_VARIABILITY);
                assert unBlackholed == false || unDisconnected == false;  
import org.opensearch.OpenSearchException;  
                DiscoveryNode newLocalNode,
                return coordinator.getMode() == LEADER;
            @Override  
            assertThat(initialNodeCount, greaterThan(0));  
        return ElectionStrategy.DEFAULT_INSTANCE;
                * ELECTION_RETRIES * (ELECTION_RETRIES - 1) / 2 + defaultMillis(ELECTION_DURATION_SETTING) * ELECTION_RETRIES
                final AllocationService allocationService = OpenSearchAllocationTestCase.createAllocationService(Settings.EMPTY);  
            this(initialNodeCount, allNodesclusterManagerEligible, nodeSettings, () -> new StatusInfo(HEALTHY, "healthy-info"));
        FAIL,
                    getElectionStrategy(),  
            ) {  
            }  
                equalTo(false)
                    committedStatesByVersion.put(applierState.getVersion(), applierState);
                        final ClusterState newClusterState = event.state();  
                Function<Long, Long> adaptCurrentTerm
                            clusterNode.readValue(key);
                return metricsRegistry;
                submitUpdateTask("read value", cs -> ClusterState.builder(cs).build(), new ClusterStateTaskListener() {  
            );
                };  
            // Then a commit of the new leader's first cluster state
import java.util.concurrent.TimeUnit;
        public void close() {
                            logger.trace("ignoring runnable {} from node {} as node has been removed from cluster", runnable, localNode);
        ) {  
                        throw new OpenSearchException("simulated cluster state applier failure");
                            @Override
                equalTo(lastAcceptedState.getLastAcceptedConfiguration())  
                        }).run();
                    transportService,  
            AckCollector submitUpdateTask(  
            if (e == null) {
import java.util.List;
            public void setLastAcceptedState(ClusterState clusterState) {
                }
                        nodeEnvironment = null;
 */
                        history.respond(eventId, value(oldState, key));
                this.nodeIndex = nodeIndex;
                        StreamInput inStream = new NamedWriteableAwareStreamInput(
                        final long updatedTerm = adaptCurrentTerm.apply(oldState.getCurrentTerm());
 * KIND, either express or implied.  See the License for the
                                    logger.debug("----> [runRandomly {}] healing {}", step, clusterNode.getId());
                    transportService,
                    (dn, cs) -> extraJoinValidators.forEach(validator -> validator.accept(dn, cs))
            LEADER_CHECK_RETRY_COUNT_SETTING
import java.util.concurrent.atomic.AtomicInteger;
                        }
            );
                    onJoinValidators,  
                if (clusterNode.coordinator.getMode() == Mode.LEADER || clusterNode.coordinator.getMode() == Mode.FOLLOWER) {  
                        // do not remove event from history, the write might still take place
            initialConfiguration = new VotingConfiguration(
import org.opensearch.cluster.ClusterStateTaskListener;
                            );  
            runFor(stabilisationDurationMillis, "stabilising");
                        final MockGatewayMetaState gatewayMetaState = new MockGatewayMetaState(newLocalNode, bigArrays);
import org.opensearch.common.util.BigArrays;
                                return "disconnect from " + clusterNode.getLocalNode() + " after shutdown";
            ConnectionStatus.DISCONNECTED,  
            @Override
                coordinator.startInitialJoin();  
import org.opensearch.cluster.coordination.LinearizabilityChecker.History;  
                public void onNodeAck(DiscoveryNode node, Exception e) {  
                mockTransport = new DisruptableMockTransport(localNode, logger, deterministicTaskQueue) {
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
                    clusterService,  
        private final History history = new History();  
            String serviceName,
                if (isConnectedPair(leader, clusterNode)) {  
                            .findAny();
                cluster.runRandomly();
import org.opensearch.threadpool.ThreadPool;
                leader.getLastAppliedClusterState().blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK),  
        @Override  
                );
    }
            return randomFrom(allLeaders);
                    assertThat(
            this.nodeName = nodeName;
                    assertEquals("expected " + applierState + " but got " + storedState, value(applierState), value(storedState));  
        return new DiscoveryNode(
            stabilise(DEFAULT_STABILISATION_TIME);  
                );
        private final LinearizabilityChecker linearizabilityChecker = new LinearizabilityChecker();
                                writer.writeFullStateAndCommit(
                    );
                    getTransportInterceptor(localNode, threadPool),
        protected ClusterStatePublisher.AckListener wrapAckListener(ClusterStatePublisher.AckListener ackListener) {
                    delegate.close();  
            }
                    node -> new MockPersistedState(newLocalNode, persistedStateRegistry, adaptGlobalMetadata, adaptCurrentTerm),
    public static final long DEFAULT_CLUSTER_STATE_UPDATE_DELAY = 7 * DEFAULT_DELAY_VARIABILITY;  
                    // One message delay to send a join  
                        nodeIds.remove(nodeIds.iterator().next());
    public static Runnable onNodeLog(DiscoveryNode node, Runnable runnable) {
        SUCCEED,  
                clusterNodes.stream()
 *  
                    coordinator.stop();
            assertFalse("stabilisation requires stable storage", disruptStorage);  
                    if (clusterNode.getClusterStateApplyResponse() == ClusterStateApplyResponse.SUCCEED) {  
                                    bigArrays,
                ? seedHostsList
                        equalTo(true)
                        nodeId + " is in the latest applied state on " + leaderId,  
        final Callable<Long> test = () -> {
                );  
    ) {  
