        private final NodeHealthService nodeHealthService;
                connectionStatus = usually()
            }
                    null,
import static org.opensearch.cluster.coordination.FollowersChecker.FOLLOWER_CHECK_TIMEOUT_SETTING;
                        clusterNode.getLastAppliedClusterState().nodes().getClusterManagerNode(),
        assertThat(spec.nextState(7, 42, 7), equalTo(Optional.of(42))); // successful write 42 returns previous value 7
            // Then wait for an election to be scheduled; we allow enough time for retries to allow for collisions
import org.opensearch.cluster.service.FakeThreadPoolClusterManagerService;
                clusterService.start();
        int getSuccessfulAckIndex(ClusterNode clusterNode) {
                onNode(() -> {
                    persistedStateRegistry,
import org.hamcrest.Matcher;
                final long afterRunRandomly = value(cluster.getAnyNode().getLastAppliedClusterState());
                    assertThat(
        );
                    + newNodesCount * 2 * DEFAULT_CLUSTER_STATE_UPDATE_DELAY
                        break;
        final Callable<Long> test = () -> {
import java.util.concurrent.TimeUnit;
                                // Avoid disruptions during cool down period
            ClusterNode(
                    assertThat(nodeId + " is still the leader", clusterNode.coordinator.getMode(), is(LEADER));
                        logger.info("successfully set initial configuration to {}", configurationWithPlaceholders);
        );
                assert unBlackholed == false || unDisconnected == false;
         */
                ClusterState applierState = clusterNode.coordinator.getApplierState();
                            logger.trace("no longer cluster-manager: [{}]", source);
        }
            .map(s -> Integer.valueOf(s.substring("value_".length())))
            ClusterManagerMetrics clusterManagerMetrics
        boolean hasAckedUnsuccessfully(ClusterNode clusterNode) {
                    }
            final long leaderTerm = leader.coordinator.getCurrentTerm();
        }
                }
            @Override
    @Before
                            }
            clusterNodes.forEach(ClusterNode::close);
                    nodeSettings,
 * under the License.
                    );
                clusterManagerService = new AckedFakeThreadPoolClusterManagerService(
        }
                        // remove event to help avoid bloated history and state space explosion in linearizability checker
            // investigate this more closely.
                Metadata.builder(clusterState.metadata())
import static org.opensearch.cluster.coordination.Coordinator.Mode.CANDIDATE;
                    threadPool
                    emptySet(),
                        public ClusterState execute(ClusterState currentState) {
            }
    ) {
                submitUpdateTask("read value", cs -> ClusterState.builder(cs).build(), new ClusterStateTaskListener() {
        }
                                );
        assertThat(spec.nextState(7, null, 7), equalTo(Optional.of(7))); // successful read
                            return clusterStateUpdate.apply(currentState);
                            } else {
            AckCollector submitValue(final long value) {
    }
            final Set<String> connectedNodeIds = clusterNodes.stream()
            if (e == null) {
                }
            );
                public void onNodeAck(DiscoveryNode node, Exception e) {
                    case SUCCEED:
 */
    }
                        } else if (deterministicTaskQueue.hasRunnableTasks()) {
                        final int key = randomIntBetween(0, keyRange);
                String source,
                    // Commit a new cluster state with the new node(s). Might be split into multiple commits, and each might need a
            final AtomicBoolean abort = new AtomicBoolean();
            logger.info("--> runFor({}ms) running until [{}ms]: {}", runDurationMillis, endTime, description);
                }
import org.opensearch.node.remotestore.RemoteStoreNodeService;
            final PersistedStateRegistry persistedStateRegistry;
                    .filter(n -> n.getLocalNode().isClusterManagerNode())
                .filter(n -> isConnectedPair(leader, n))
            }
    }
                                writer.writeFullStateAndCommit(
            private TestInMemoryMetricsRegistry metricsRegistry = new TestInMemoryMetricsRegistry();
                );
import org.junit.After;
    }
        Settings settings,
                            ClusterStateUpdaters.addStateNotRecoveredBlock(
            + (defaultMillis(FOLLOWER_CHECK_INTERVAL_SETTING) + defaultMillis(FOLLOWER_CHECK_TIMEOUT_SETTING)) * defaultInt(
                bootstrapNode.applyInitialConfiguration();
    }
                                PersistedClusterStateService.Writer writer = new PersistedClusterStateService(
import static org.opensearch.cluster.coordination.Coordinator.Mode.LEADER;
                    clusterManagerService,
            }
            ) {
        }
                    } catch (CoordinationStateRejectedException e) {
            }
        }
                        final ClusterNode clusterNode = getAnyNode();
            updateCommittedStates();
    public long value(ClusterState clusterState, int key) {
                            clusterNode.submitSetAutoShrinkVotingConfiguration(autoShrinkVotingConfiguration);
            private void setUp() {
            address.getAddress(),
            logger.debug("running {} cleanup actions", cleanupActions.size());
            // then wait for the new leader to commit a state without the old leader
                leader.improveConfiguration(lastAcceptedState),
        @Override
            assertThat(initialNodeCount, greaterThan(0));
                    }
        private final List<DiscoveryNode> unsuccessfulNodes = new ArrayList<>();
                this.localNode = localNode;
            cleanupActions.add(disconnectedNodes::clear);
import java.util.stream.Stream;
import org.opensearch.common.Nullable;
                }
         * Never respond either way.
            private CoordinationState.PersistedState getPersistedState() {
import org.opensearch.threadpool.Scheduler;
            ConnectionStatus.DISCONNECTED,
                Function<Metadata, Metadata> adaptGlobalMetadata,
                        clusterNode.coordinator.invariant();
        ) {
        }
        private final Set<String> disconnectedNodes = new HashSet<>();
                                newLastAcceptedVersion
    static class AckedFakeThreadPoolClusterManagerService extends FakeThreadPoolClusterManagerService {
            logger.info("--> start of safety phase of at least [{}] steps with delay variability of [{}ms]", randomSteps, delayVariability);
                    );
        void setEmptySeedHostsList() {
            assertTrue(leaderId + " exists in its last-applied state", leader.getLastAppliedClusterState().getNodes().nodeExists(leaderId));
                }
import org.opensearch.common.lease.Releasable;
                assertFalse(nodeId + " should not have an active publication", clusterNode.coordinator.publicationInProgress());
     * Responses that time out are modeled by returning null. Successful writes return the previous value of the register.
                        // in this case, we know for sure that event was not processed by the system and will not change history
                            taskListener.onFailure(source, e);
                        blackholedNodes.clear();
                return submitUpdateTask("new value [" + value + "]", cs -> setValue(cs, key, value), new ClusterStateTaskListener() {
                    });
                persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, persistedState);
                transportService.start();
                        clusterNode.applyInitialConfiguration();
            }
        return new NodeConnectionsService(settings, threadPool, transportService) {
            ClusterNode restartedNode(
                            clusterNode.readValue(key);
                connectionStatus = ConnectionStatus.BLACK_HOLE_REQUESTS_ONLY;
                        .putList(
        assertThat(spec.nextState(7, null, 42), equalTo(Optional.empty()));
        Cluster(int initialNodeCount, boolean allNodesClusterManagerEligible, Settings nodeSettings, NodeHealthService nodeHealthService) {
import org.opensearch.Version;
            } else {
import static org.opensearch.cluster.coordination.LeaderChecker.LEADER_CHECK_TIMEOUT_SETTING;
                initialConfiguration
                            "----> [runRandomly {}] running until [{}ms] with delay variability of [{}ms]",
                    @Override
            ClusterState improveConfiguration(ClusterState currentState) {
                                    logger.debug("----> [runRandomly {}] healing {}", step, clusterNode.getId());
            return this.applicationMayFail;
        }
                        nodeEnvironment = newNodeEnvironment();
                lastAcceptedState.getLastCommittedConfiguration(),
                        gatewayMetaState.start(Settings.EMPTY, nodeEnvironment, xContentRegistry(), persistedStateRegistry());
                            return;
                final boolean linearizable = linearizabilityChecker.isLinearizable(spec, history, i -> null, abort::get);
                            if (updatedMetadata != oldState.getLastAcceptedState().metadata()) {
                        nodeEnvironment = oldState.nodeEnvironment;
                    new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
            assertThat("leaders", allLeaders, not(empty()));
            void close() {
            assertThat(
                            clusterState(
                        nodeId + " has NO_CLUSTER_MANAGER_BLOCK",
                }
                            logger.debug("----> [runRandomly {}] reading value from [{}]", thisStep, clusterNode.getId());
            @Override
            private void possiblyFail(String description) {
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
                        clusterNode.coordinator.isElectionSchedulerRunning()
    protected static long defaultMillis(Setting<TimeValue> setting) {
            assertThat(
        ClusterNode getAnyNodeExcept(ClusterNode... clusterNodes) {
            // null input is read, non-null is write
                    assertThat(nodeId + " is not following " + leaderId, clusterNode.coordinator.getMode(), is(CANDIDATE));
            private DisruptableClusterApplierService clusterApplierService;
                                newVotingConfiguration,
                            updateCommittedStates();
                        nodeId + " has the same accepted state as " + leaderId,
            );
import org.opensearch.cluster.service.ClusterService;
                        }
            .build();
                "--> creating cluster of {} nodes (cluster-manager-eligible nodes: {}) with initial configuration {}",
                                "rolling back persisted cluster state on cluster-manager-ineligible node [{}]: "
import static org.opensearch.cluster.coordination.ElectionSchedulerFactory.ELECTION_INITIAL_TIMEOUT_SETTING;
                    }
                            logger.trace("successfully published: [{}]", newState);
                        // do not remove event from history, the write might still take place
                try {
            .persistentSettings()
                FOLLOWER_CHECK_RETRY_COUNT_SETTING
    }
            private final NodeEnvironment nodeEnvironment;
                return unBlackholed || unDisconnected;
            clusterNodes = new ArrayList<>(initialNodeCount);
                            && randomBoolean()) {
import org.opensearch.cluster.node.DiscoveryNode;
            final ScheduledThreadPoolExecutor scheduler = Scheduler.initScheduler(Settings.EMPTY);
                for (final DiscoveryNode discoveryNode : discoveryNodes) {
        }
                            synchronized (clusterNode.coordinator.mutex) {
import java.util.function.Consumer;
            runRandomly(true, true, EXTREME_DELAY_VARIABILITY);
        ClusterNode getAnyNodePreferringLeaders() {
                    allNodesClusterManagerEligible || i == 0 || randomBoolean(),
                    case HANG:
                    @Override
                logger.info("setting initial configuration not required");
    }
                return submitValue(0, value);
                    Stream.generate(() -> BOOTSTRAP_PLACEHOLDER_PREFIX + UUIDs.randomBase64UUID(random()))
                                        .put(cs.metadata().persistentSettings())
                    .persistentSettings(
                    public void onNoLongerClusterManager(String source) {
            void allowClusterStateApplicationFailure() {
            private DisruptableMockTransport mockTransport;
                        delegate = mockGatewayMetaState.getPersistedState();
                return null;
                        coordinator.setInitialConfiguration(configurationWithPlaceholders);
                    settings,
                    localNode.isClusterManagerNode() && DiscoveryNode.isClusterManagerNode(nodeSettings)
        private void updateCommittedStates() {
                        clusterNode.getLastAppliedClusterState().blocks().hasGlobalBlockWithId(NO_CLUSTER_MANAGER_BLOCK_ID),
    // The time it takes to complete an election
        };
            logger.debug("finished running cleanup actions");
            );
            blackholedConnections.clear();
                    this::getPersistedState,
            }
                        @Override
    public void testRepeatableTests() throws Exception {
                            finishTime,
            );
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                    protected void execute(Runnable runnable) {
    class Cluster implements Releasable {
 * not use this file except in compliance with the License.
        }
            cleanupActions.forEach(Runnable::run);
            return clusterNodes.size();
                                    deterministicTaskQueue::getCurrentTimeMillis
        List<ClusterNode> getAllNodesExcept(ClusterNode... clusterNodes) {
                        nodeId + " has no cluster-manager",
                        equalTo(true)
            }
                        if (deterministicTaskQueue.hasDeferredTasks() && randomBoolean()) {
                            taskListener.onNoLongerClusterManager(source);
                coordinator = new Coordinator(
                    (s, p, r) -> {},
                if (deterministicTaskQueue.hasDeferredTasks() == false) {
                        }
                        final ClusterNode clusterNode = getAnyNodePreferringLeaders();
                    assertThat(nodeId + " has the same term as " + leaderId, clusterNode.coordinator.getCurrentTerm(), is(leaderTerm));
                    @Override
     */
                                if (finishTime == -1 && clusterNode.blackhole()) {
 * KIND, either express or implied.  See the License for the
            }
                connectedNodeIds + " should be a quorum of " + lastCommittedConfiguration,
                    nodeHealthService
import org.opensearch.common.unit.TimeValue;
                    }
        return "{" + node.getId() + "}{" + node.getEphemeralId() + "}";
                return coordinator.getMode() == LEADER;
                    clusterSettings,
import java.util.Set;
import org.opensearch.cluster.coordination.LinearizabilityChecker.History;
            final VotingConfiguration lastCommittedConfiguration = lastAcceptedState.getLastCommittedConfiguration();
                        equalTo(false)
         */
                            );
                cluster.runRandomly();
            }
        private void assertConsistentStates() {
                    Version.CURRENT
                    }
                assertThat("setting initial configuration may fail with blackholed nodes", blackholedNodes, empty());
        @Override
import org.opensearch.cluster.ClusterState;
    }
            }
            void submitSetAutoShrinkVotingConfiguration(final boolean autoShrinkVotingConfiguration) {
                super.onNewClusterState(source, clusterStateSupplier, listener);
                        disconnectedNodes.clear();
                    }
import org.opensearch.cluster.coordination.Coordinator.Mode;
import static org.opensearch.discovery.PeerFinder.DISCOVERY_FIND_PEERS_INTERVAL_SETTING;
                                newLastAcceptedVersion = randomLongBetween(
            .filter(s -> s.startsWith("value_"))
        final VotingConfiguration initialConfiguration;
                mockTransport = new DisruptableMockTransport(localNode, logger, deterministicTaskQueue) {
                coordinator.startInitialJoin();
                clusterManagerService.setClusterStatePublisher(coordinator);
                        mockGatewayMetaState.start(Settings.EMPTY, nodeEnvironment, xContentRegistry(), persistedStateRegistry());
    protected static String getNodeIdForLogContext(DiscoveryNode node) {
            return successfulNodes.indexOf(clusterNode.localNode);
                    // initial configuration should not have a place holder for local node
                    break;
                    runnable -> deterministicTaskQueue.scheduleNow(onNode(runnable))
        return new DiscoveryNode(
                    } else {
            private AckedFakeThreadPoolClusterManagerService clusterManagerService;
            if (clusterStateApplyResponse == ClusterStateApplyResponse.HANG) {
import org.opensearch.gateway.GatewayService;
                    logger.trace("closing");
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
                        clusterNodes.replaceAll(cn -> cn == clusterNode ? cn.restartedNode() : cn);
                    onJoinValidators,
        return setting.get(Settings.EMPTY);
                    throw new UncheckedIOException("Unable to create MockPersistedState", e);
                            logger.debug("----> [runRandomly {}] forcing {} to become candidate", thisStep, clusterNode.getId());
                lastCommittedConfiguration.hasQuorum(connectedNodeIds)
                                randomBoolean() ? emptySet() : singleton(randomAlphaOfLength(10))
        }
            return n1 == n2
        }
                persistedStateRegistry = persistedStateRegistry();
            );
        AckCollector nextAckCollector = new AckCollector();
        void runFor(long runDurationMillis, String description) {
                    }
    }
public class AbstractCoordinatorTestCase extends OpenSearchTestCase {
        }
                                lastAcceptedTerm,
        @Override
                    Collections.emptyMap(),
            disruptStorage = true;
                    settings,
                    // One message delay to send a join
     * Simple register model. Writes are modeled by providing an integer input. Reads are modeled by providing null as input.
                    for (final ClusterNode clusterNode : clusterNodes) {
    static class AckCollector implements ClusterStatePublisher.AckListener {
                        deterministicTaskQueue.scheduleNow(onNode(runnable));
                return persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL);
        ClusterNode getAnyBootstrappableNode() {
import org.opensearch.common.UUIDs;
            logger.info("--> runFor({}ms) completed run until [{}ms]: {}", runDurationMillis, endTime, description);
    // 4. send ApplyCommitRequest
            }
    public void testRegisterSpecConsistency() {
            return 0L;
                );
        ) {
            public String toString() {
                            // ... then we might not have reliably persisted the cluster state, so emulate a rollback
                        .metadata(
import static java.util.Collections.emptySet;
 * compatible open source license.
                            clusterNode.getLastAppliedClusterState().getVersion(),
                        // Heal all nodes BEFORE finishTime is set so it can take into account any pending disruption that
                                    nodeEnvironment,
                    allocationService,
                    assertThat(
                        final ClusterNode clusterNode = getAnyNode();
            Coordinator coordinator;
            }
                equalTo(false)
                Function<Long, Long> adaptCurrentTerm,
                this.nodeSettings = nodeSettings;
            bigArrays = usually()
                }
            Settings.builder().put(NODE_NAME_SETTING.getKey(), "deterministic-task-queue").build(),
            try (Cluster cluster = new Cluster(randomIntBetween(1, 5))) {
                    protected Optional<DisruptableMockTransport> getDisruptableMockTransport(TransportAddress address) {
import static org.opensearch.monitor.StatusInfo.Status.HEALTHY;
import static org.hamcrest.Matchers.sameInstance;
import org.opensearch.monitor.StatusInfo;
import java.util.Collections;
    }
            private RepositoriesService repositoriesService;
                        nodeId + " has no STATE_NOT_RECOVERED_BLOCK",
                    // followup reconfiguration
                    logger.trace("[{}] submitUpdateTask: enqueueing [{}]", localNode.getId(), source);
                "leader " + leader.getLocalNode() + " should be part of voting configuration " + lastCommittedConfiguration,
            deterministicTaskQueue.setExecutionDelayVariabilityMillis(DEFAULT_DELAY_VARIABILITY);
import org.opensearch.cluster.service.ClusterApplierService;
                    if (rarely()) {
                    NoopTracer.INSTANCE
                    if (coolDown) {
                                }
                        }
import static org.opensearch.cluster.coordination.LeaderChecker.LEADER_CHECK_INTERVAL_SETTING;
                return restartedNode(Function.identity(), Function.identity(), nodeSettings);
                        final long persistedCurrentTerm;
    }
        static final long EXTREME_DELAY_VARIABILITY = 10000L;
            for (int i = 0; i < 3; i++) {
                });
                final ClusterNode bootstrapNode = getAnyBootstrappableNode();
            clusterNodes.addAll(addedNodes);
                NodeHealthService nodeHealthService
                            logger.trace(
            @Override
                                        .put(CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION.getKey(), autoShrinkVotingConfiguration)
                    assertFalse(
                if (clusterNode.getLocalNode().isClusterManagerNode()) {
                    createDiscoveryNode(nodeIndex, clusterManagerEligible),
            }
                "current configuration is already optimal",
                    assertThat(
                        (oldState.getLastAcceptedState().nodes().getLocalNode().isClusterManagerNode()
                            deterministicTaskQueue.advanceTime();
                return delegate.getCurrentTerm();
        (defaultMillis(LEADER_CHECK_INTERVAL_SETTING) + defaultMillis(LEADER_CHECK_TIMEOUT_SETTING)) * defaultInt(
            }
                onCompletion.run();
        nodeEnvironments.clear();
                        history.remove(eventId);
            TransportService transportService;
            private final CoordinationState.PersistedState delegate;
                boolean unBlackholed = blackholedNodes.remove(localNode.getId());
        void runRandomly() {
            });
import org.opensearch.cluster.ClusterStateTaskListener;
                    if (clusterNode.getClusterStateApplyResponse() == ClusterStateApplyResponse.SUCCEED) {
                assertThat("must add nodes to a cluster before closing them", clusterNodes, hasItem(ClusterNode.this));
            // Allow two round-trip for pre-voting and voting
                    nodeIndex,
                return Optional.empty();
            return getAnyNode();
                boolean blackholed = blackholedNodes.add(localNode.getId());
                clusterNodes.stream()
                    nodeIndex,
                ? BigArrays.NON_RECYCLING_INSTANCE
                        nodeId + " has no NO_CLUSTER_MANAGER_BLOCK",
                logger.trace("starting up [{}]", localNode);
        }
                synchronized (coordinator.mutex) {
        /**
        void clearBlackholedConnections() {
                                ClusterState.builder(oldState.getLastAcceptedState()).metadata(updatedMetadata).build().writeTo(outStream);
                }
                    threadPool,
                                        .build()
                            );
                    ? preferredUnknownNodeConnectionStatus
                repositoriesService = new RepositoriesService(
            private final Logger logger = LogManager.getLogger(ClusterNode.class);
                    return coordinator.improveConfiguration(currentState);
            "node" + nodeIndex,
                clusterNode.coordinator.invariant();
            assertThat(
    // 1. submit the task to the cluster-manager service
                assertConsistentStates();
import org.opensearch.discovery.SeedHostsProvider;
            bootstrapIfNecessary();
                        nodeId + " is not a missing vote for  " + leaderId,
            final String leaderId = leader.getId();
        }
                deterministicTaskQueue.advanceTime();
                }
                            }
        private final String nodeName;
import org.opensearch.cluster.coordination.AbstractCoordinatorTestCase.Cluster.ClusterNode;
                if (history.size() > 300) {
                        equalTo(false)
                        // See #61711 for a particular instance where having unhealthy nodes while cooling down can be problematic.
 * software distributed under the License is distributed on an
                step++;
            address.address().getHostString(),
                    @Override
                        final int newValue = randomInt();
import org.opensearch.common.settings.Setting;
                        final ClusterNode clusterNode = getAnyNodePreferringLeaders();
                    case FAIL:
                }
                    address,
                            + newClusterState.version();
                        delegate = new InMemoryPersistedState(
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(
                    .build()
                    settings,
                return localNode.toString();
            List<ClusterNode> filteredNodes = getAllNodesExcept(clusterNodes);
            // Large histories can be problematic and have the linearizability checker run OOM
            );
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.gateway.PersistedClusterStateService;
                            );
        assertEquals(keySet(clusterState1), keySet(clusterState2));
                } else {
                    // transportService.stop(); // does blocking stuff :/
                        );
                            taskListener.clusterStateProcessed(source, oldState, newState);
                        nodeId + " is in the latest applied state on " + leaderId,
                            public void run() {
                boolean success = false;
            deterministicTaskQueue.setExecutionDelayVariabilityMillis(delayVariability);
    }
import java.util.function.UnaryOperator;
                }
                deterministicTaskQueue.getExecutionDelayVariabilityMillis(),
import java.util.Map;
                    .collect(Collectors.toList())
                try {
            }
                    finishTime = deterministicTaskQueue.getLatestDeferredExecutionTime();
         * Reject the state with an exception.
            String nodeName,
                                    logger.debug("----> [runRandomly {}] disconnecting {}", step, clusterNode.getId());
            if (input == null) {
                        mockGatewayMetaState = new MockGatewayMetaState(localNode, bigArrays);
    }
            }
import org.opensearch.common.Randomness;
        resetPortCounter();
                boolean disconnected = disconnectedNodes.add(localNode.getId());
        }
                                if (finishTime == -1 && clusterNode.disconnect()) {
                    writableRegistry(),
        ClusterNode getAnyLeader() {
                            nodeId + " is in its own latest applied state",
                    @Override
            ) {
        }
            stabilise(
            runFor(stabilisationDurationMillis, "stabilising");
        private final History history = new History();
                    super.onNewClusterState(source, clusterStateSupplier, (source1, e) -> {
            this(initialNodeCount, allNodesclusterManagerEligible, nodeSettings, () -> new StatusInfo(HEALTHY, "healthy-info"));
                                )
                        // remove event to help avoid bloated history and state space explosion in linearizability checker
 * this file be licensed under the Apache-2.0 license or a
                clusterManagerEligibleNodeIds,
                            final long lastAcceptedVersion = oldState.getLastAcceptedState().version();
                        logger.debug("ignoring benign exception thrown when stabilising", e);
                    assertThat(
        Cluster(int initialNodeCount, boolean allNodesclusterManagerEligible, Settings nodeSettings) {
        static final long DEFAULT_DELAY_VARIABILITY = 100L;
            .keySet()
            ThreadPool threadPool,
        boolean nodeExists(DiscoveryNode node) {
 */
            + DEFAULT_ELECTION_DELAY
                                newLastAcceptedVersion,
import org.opensearch.repositories.RepositoriesService;
        private final Function<DiscoveryNode, MockPersistedState> defaultPersistedStateSupplier = MockPersistedState::new;
        private boolean applicationMayFail;
                final int thisStep = step; // for lambdas
                    && (n1.nodeHealthService.getHealth().getStatus() == HEALTHY && n2.nodeHealthService.getHealth().getStatus() == HEALTHY);
            private RemoteStoreNodeService remoteStoreNodeService;
            }
            assertThat(
                .filter(n -> forbiddenIds.contains(n.getId()) == false)
        void stabilise(long stabilisationDurationMillis) {
                };
                        );
                                thisStep,
                transportService.acceptIncomingRequests();
                    assertTrue(nodeId + " has been bootstrapped", clusterNode.coordinator.isInitialConfigurationSet());
            List<ClusterNode> allLeaders = clusterNodes.stream().filter(ClusterNode::isLeader).collect(Collectors.toList());
                Settings nodeSettings,
            public void setLastAcceptedState(ClusterState clusterState) {
                            @Override
            @Override
                    } else {
            addNodes(newNodesCount);
                try {
                                    0L,
    @Before
import static org.hamcrest.Matchers.greaterThan;
            }
                            final long newValue = randomLong();
 * The OpenSearch Contributors require contributions made to
            return successfulNodes.contains(clusterNode.localNode);
                lessThanOrEqualTo(DEFAULT_DELAY_VARIABILITY)
}
                        @Override
            }
                            final long lastAcceptedTerm = oldState.getLastAcceptedState().term();
import org.opensearch.env.NodeEnvironment;
            assertThat(leader.getLastAppliedClusterState().getNodes().getSize(), equalTo(connectedNodeIds.size()));
            private final int nodeIndex;
                final TransportAddress address = randomBoolean() ? buildNewFakeTransportAddress() : localNode.getAddress();
                            nodeId + " has the same applied state as " + leaderId,
            return ((Tuple) value).v1();
                    }
        }
    }
                        // instead, complete history when checking for linearizability
            String getId() {
import org.opensearch.cluster.ClusterManagerMetrics;
        protected PrioritizedOpenSearchThreadPoolExecutor createThreadPoolExecutor() {
/*
            return ackedNodes.contains(clusterNode.localNode);
                defaultMillis(DISCOVERY_FIND_PEERS_INTERVAL_SETTING)
                    coordinator.stop();
                try {
            }
                        nodeId + " has correct cluster-manager",
                        clusterNode.onNode(() -> {
                            final VotingConfiguration newVotingConfiguration = new VotingConfiguration(
import static org.opensearch.cluster.coordination.ElectionSchedulerFactory.ELECTION_BACK_OFF_TIME_SETTING;
        return NOOP_TRANSPORT_INTERCEPTOR;
        }
                    );
            logger.info("checking linearizability of history with size {}: {}", history.size(), history);
import static org.opensearch.cluster.coordination.ElectionSchedulerFactory.ELECTION_DURATION_SETTING;
            "",
                    remoteStoreNodeService,
                    settings,
                                    updatedTerm,
                final ThreadPool threadPool = deterministicTaskQueue.getThreadPool(this::onNode);
            final Set<String> clusterManagerEligibleNodeIds = new HashSet<>(initialNodeCount);
            );
                        final long updatedTerm = adaptCurrentTerm.apply(oldState.getCurrentTerm());
        public void onCommit(TimeValue commitTime) {}
                        StreamInput inStream = new NamedWriteableAwareStreamInput(
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                };
    public static final long DEFAULT_CLUSTER_STATE_UPDATE_DELAY = 7 * DEFAULT_DELAY_VARIABILITY;
    public static final long DEFAULT_ELECTION_DELAY
                        BytesStreamOutput outStream = new BytesStreamOutput();
            super(nodeName, settings, clusterSettings, threadPool, clusterManagerMetrics);
                        logger.info(
        for (int key : keySet(clusterState1)) {
                                persistedCurrentTerm,
        void allowClusterStateApplicationFailure() {
                            clusterNode.submitValue(key, newValue);
                    }
                    committedStatesByVersion.put(applierState.getVersion(), applierState);
                            && newLocalNode.isClusterManagerNode()) == false
    // 5. apply committed cluster state
                            logger.trace("ignoring runnable {} from node {} as node has been removed from cluster", runnable, localNode);
     */
        }
            final List<ClusterNode> addedNodes = new ArrayList<>();
    }
                    }
                            if (lastAcceptedVersion == 0L) {
                        nodeIds.add(localNode.getId());
                        wrapped.run();
                    throw new UncheckedIOException("Unable to create MockPersistedState", e);
            )
            + 4 * DEFAULT_DELAY_VARIABILITY
                    logger.trace("simulating IO exception [{}]", description);
                assertThat("setting initial configuration may fail with disconnected nodes", disconnectedNodes, empty());
            }
                    assertTrue("history not linearizable: " + history, linearizable);
            return ((Tuple) value).v2();
                final long afterStabilisation = value(cluster.getAnyNode().getLastAppliedClusterState());
        private final BigArrays bigArrays;
 * You may obtain a copy of the License at
                        );
                this.nodeIndex = nodeIndex;
                    );
                        return clusterNodes.stream()
                while (deterministicTaskQueue.hasRunnableTasks()) {
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.cluster.coordination.LinearizabilityChecker.SequentialSpec;
import java.util.Optional;
        return clusterState.metadata().persistentSettings().getAsLong("value_" + key, 0L);
        private boolean disruptStorage;
                            clusterManagerService.nextAckCollector = ackCollector;
                    );
                                    xContentRegistry(),
        }
                        outStream.setVersion(Version.CURRENT);
        @Nullable // null means construct a list from all the current nodes
                                oldState.getCurrentTerm(),
        int size() {
            }
                }
            // perhaps there is an election collision requiring another publication (which times out) and a term bump
                delegate.setLastAcceptedState(clusterState);
    }
        @Override
            final ClusterState lastAcceptedState = leader.coordinator.getLastAcceptedState();
        }
import org.opensearch.transport.TransportInterceptor;
         * Apply the state (default)
            }
                new HashSet<>(randomSubsetOf(randomIntBetween(1, clusterManagerEligibleNodeIds.size()), clusterManagerEligibleNodeIds))
                        logger.debug("----> [runRandomly {}] rebooting [{}]", thisStep, clusterNode.getId());
        final long seed = randomLong();
                            Metadata.builder(cs.metadata())
                }
                onNode(() -> {
import org.opensearch.test.OpenSearchTestCase;
                }
                    nextNodeIndex.getAndIncrement(),
                    deterministicTaskQueue,
                cluster.stabilise();
        }
        };
            UUIDs.randomBase64UUID(random()), // generated deterministically for repeatable tests
                "no reconfiguration is in progress",
            nextAckCollector = new AckCollector();
        public Object getKey(Object value) {
                    }
                clusterNodes.add(clusterNode);
            }
            cleanupActions.add(() -> disruptStorage = false);
                if (storedState == null) {
            }
                final int eventId = history.invoke(new Tuple<>(key, value));
                sameInstance(lastAcceptedState)
import org.opensearch.gateway.ClusterStateUpdaters;
import static org.hamcrest.Matchers.hasItem;
    public static final long DEFAULT_STABILISATION_TIME =
                }
        final String nodeId = getNodeIdForLogContext(node);
            long finishTime = -1;
            assertTrue("duplicate ack from " + node, ackedNodes.add(node));
            int step = 0;
 * license agreements. See the NOTICE file distributed with
        private final DeterministicTaskQueue deterministicTaskQueue;
            } else {
import static org.opensearch.cluster.coordination.Coordinator.PUBLISH_TIMEOUT_SETTING;
import java.io.IOException;
            Settings settings,
import static org.opensearch.cluster.coordination.CoordinationStateTestCluster.clusterState;
        }
                    ackListener.onNodeAck(node, e);
                    onNodeLog(localNode, this::setUp).run();
                    nodeHealthService,
    // 3. receive PublishResponse
            ClusterState getLastAppliedClusterState() {
                    if (oldState.nodeEnvironment != null) {
                return disconnected;
            }
                Function<DiscoveryNode, MockPersistedState> persistedStateSupplier,
    @After
                );
            } else {
                    allocationService,
            for (final ClusterNode clusterNode : clusterNodes) {
        ClusterNode getAnyNode() {
                            case 0:
import java.util.Arrays;
                );
                    ackCollector.onCommit(commitTime);
                        nodeEnvironments.add(nodeEnvironment);
                        delegate = gatewayMetaState.getPersistedState();
                runFor(defaultMillis(CONNECT_TIMEOUT) + // may be in a prior connection attempt which has been blackholed
                UnaryOperator<ClusterState> clusterStateUpdate,
        @Override
        return ClusterState.builder(clusterState)
        assertThat(openPersistedStates, empty());
                }
                if (randomSteps <= step && finishTime == -1) {
                }
                        isEqualToLeaderVersion
            return randomFrom(allLeaders);
import static org.opensearch.gateway.GatewayService.STATE_NOT_RECOVERED_BLOCK;
        }
import org.apache.logging.log4j.message.ParameterizedMessage;
            }
                                "----> [runRandomly {}] setting auto-shrink configuration to {} on {}",
            } else if (disconnectedNodes.contains(sender.getId()) || disconnectedNodes.contains(destination.getId())) {
import org.junit.Before;
            for (int i = 0; i < newNodesCount; i++) {
            this.nodeName = nodeName;
                final AllocationService allocationService = OpenSearchAllocationTestCase.createAllocationService(Settings.EMPTY);
            String nodeName,
                            // ... and we're feeling lucky ...
                    }
            boolean disconnect() {
                    }
            cleanupActions.add(blackholedNodes::clear);
import org.opensearch.common.settings.ClusterSettings;
import static org.hamcrest.Matchers.nullValue;
                leaderId + " has no STATE_NOT_RECOVERED_BLOCK",
                    null
                if (randomBoolean()) {
            private NodeHealthService nodeHealthService;
                        clusterNode.close();
            // The stabilisation time bound is O(#new nodes) which isn't ideal; it's possible that the real bound is O(1) since node-join
                } catch (IOException e) {
        public Object getValue(Object value) {
            this.nodeHealthService = nodeHealthService;
                    clusterManagerService.submitStateUpdateTask(source, new ClusterStateUpdateTask() {
                            0L,
                boolean unDisconnected = disconnectedNodes.remove(localNode.getId());
    protected final AtomicInteger nextNodeIndex = new AtomicInteger();
                    try {
            final ClusterNode leader = getAnyLeader();
            boolean heal() {
                if (abort.get() == false) {
                }
                            deterministicTaskQueue.getExecutionDelayVariabilityMillis()
            } else {
                assertTrue("must use a fresh PersistedState", openPersistedStates.add(persistedState));
                    }
                if (output == null || currentState.equals(output)) {
                        public void onNoLongerClusterManager(String source) {
                            }
import java.util.concurrent.ScheduledThreadPoolExecutor;
import static org.opensearch.cluster.coordination.AbstractCoordinatorTestCase.Cluster.DEFAULT_DELAY_VARIABILITY;
        final long result1 = RandomizedContext.current().runWithPrivateRandomness(seed, test);
                } catch (IOException e) {
                    && getConnectionStatus(n2.getLocalNode(), n1.getLocalNode()) == ConnectionStatus.CONNECTED)
import static org.opensearch.cluster.coordination.Reconfigurator.CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION;
                        clusterNodes.forEach(cn -> deterministicTaskQueue.scheduleNow(cn.onNode(new Runnable() {
                    @Override
                // The first pinging discovers the cluster-manager
    private final SequentialSpec spec = new LinearizabilityChecker.KeyedSpec() {
    protected ElectionStrategy getElectionStrategy() {
import static org.opensearch.cluster.coordination.Coordinator.Mode.FOLLOWER;
            }
         */
            }
            }
                    coordinator
                            ClusterState state = committedStatesByVersion.get(newState.version());
            @Override
                        deterministicTaskQueue.runRandomTask();
                }
                coordinator.setNodeConnectionsService(nodeConnectionsService);
                            && (oldState.getLastAcceptedState().term() > 0L || oldState.getLastAcceptedState().version() > 0L)
        private final List<DiscoveryNode> successfulNodes = new ArrayList<>();
                        nodeEnvironment = null;
                    // apply cluster state, but don't notify listener
                    "test",
                                }
                            case 1:
                if (isConnectedPair(leader, clusterNode)) {
            private MockGatewayMetaState mockGatewayMetaState;
            // then wait for the new leader to notice that the old leader is unresponsive
                        nodeEnvironment = null;
            };
                    );
                        assertTrue(
                    localNode.getId(),
import static org.opensearch.transport.TransportSettings.CONNECT_TIMEOUT;
            public String toString() {
            for (final ClusterNode clusterNode : clusterNodes) {
                                lastAcceptedVersion,
                    delegate.close();
            return new MockSinglePrioritizingExecutor(nodeName, deterministicTaskQueue, threadPool);
import static java.util.Collections.emptyList;
            MockPersistedState(DiscoveryNode localNode) {
                                    Settings.builder()
            public void connectToNodes(DiscoveryNodes discoveryNodes, Runnable onCompletion) {
                    final Set<String> nodeIds = new HashSet<>(
                                    logger.debug("----> [runRandomly {}] blackholing {}", step, clusterNode.getId());
                    public String toString() {
        }
     * How to behave with a new cluster state
                switch (clusterStateApplyResponse) {
                        )
                clusterService.setNodeConnectionsService(nodeConnectionsService);
            }
                                // Avoid disruptions during cool down period
            // events are batched together, but in practice we have not seen problems in this area so have not invested the time needed to
                                newValue
                    try {
import org.opensearch.common.settings.Settings;
                final Collection<BiConsumer<DiscoveryNode, ClusterState>> onJoinValidators = Collections.singletonList(
                .map(ClusterNode::getId)
        }
                    @Override
                            ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(),
        ClusterStateApplyResponse clusterStateApplyResponse = ClusterStateApplyResponse.SUCCEED;
        @Override
                    ackListener.onCommit(commitTime);
        /**
                    } else {
                            outStream.bytes().streamInput(),
            assertThat(
                        nodeIds.remove(nodeIds.iterator().next());
    protected DiscoveryNode createDiscoveryNode(int nodeIndex, boolean clusterManagerEligible) {
import static java.util.Collections.singleton;
                    // transportService.close(); // does blocking stuff :/
        = defaultMillis(DISCOVERY_FIND_PEERS_INTERVAL_SETTING) * 2
import org.opensearch.cluster.node.DiscoveryNodeRole;
                                newLastAcceptedVersion = randomNonNegativeLong();
        public void onNodeAck(DiscoveryNode node, Exception e) {
            )
 * SPDX-License-Identifier: Apache-2.0
        private final ConnectionStatus preferredUnknownNodeConnectionStatus = randomFrom(
                gatewayService.start();
                        return Cluster.this.getConnectionStatus(getLocalNode(), destination);
        void addNodesAndStabilise(int newNodesCount) {
                            + " to stale version "
                    getElectionStrategy(),
                        randomSubsetOf(initialConfiguration.getNodeIds().size(), nodeIdsWithPlaceholders)
                Function<Metadata, Metadata> adaptGlobalMetadata,
            }
                        logger.debug(
                            new NamedWriteableRegistry(ClusterModule.getNamedWriteables())
import org.apache.logging.log4j.Logger;
            ConnectionStatus connectionStatus;
                        assertThat(
        AckedFakeThreadPoolClusterManagerService(
import java.util.stream.Collectors;
import static org.opensearch.cluster.coordination.FollowersChecker.FOLLOWER_CHECK_RETRY_COUNT_SETTING;
        }
            resetNodeIndexBeforeEachTest();
                    // This will require node restart and we're not emulating it here.
                        final ClusterState newClusterState = event.state();
                            deterministicTaskQueue.runRandomTask();
import org.opensearch.threadpool.ThreadPool;
        @Override
                submitUpdateTask(
                        clusterNode.getLastAppliedClusterState().nodes().getClusterManagerNode(),
            }
                        // adapt cluster state to new localNode instance and add blocks
            if (clusterNodes.stream().allMatch(ClusterNode::isNotUsefullyBootstrapped)) {
        }
    }
            clusterManagerEligible ? DiscoveryNodeRole.BUILT_IN_ROLES : emptySet(),
                            final Metadata updatedMetadata = adaptGlobalMetadata.apply(oldState.getLastAcceptedState().metadata());
        boolean hasAcked(ClusterNode clusterNode) {
                    Collections.emptyMap(),
            LEADER_CHECK_RETRY_COUNT_SETTING
                    assertFalse(
                // just update targetsByNode to ensure disconnect runs for these nodes
                    address.address().getHostString(),
                        }
                        // ignore result
    protected final Set<Cluster.MockPersistedState> openPersistedStates = new HashSet<>();
                return metricsRegistry;
                            case 2:
                        }
                            }
        assertEquals(clusterState1.version(), clusterState2.version());
                connectionStatus = ConnectionStatus.BLACK_HOLE;
         *                 disrupted events from the queue before returning. Usually true.
            ) {
                connectionStatus = ConnectionStatus.CONNECTED;
                );
        }
            addStateApplier(event -> {
                        @Override
                assert blackholed || unDisconnected == false;
                        final ClusterNode clusterNode = getAnyNode();
                clusterApplierService.allowClusterStateApplicationFailure();
        assertEquals(result1, result2);
            );
                if (clusterNode.coordinator.getMode() == LEADER) {
                    // history is completed with null, simulating timeout, which assumes that write went through
                .collect(Collectors.toSet());
            void applyInitialConfiguration() {
                });
                    return Optional.of(input);
            @Override
                    continue;
                        }).run();
import org.apache.logging.log4j.LogManager;
                        .build(),
                if (clusterNode == leader) {
                leaderId + " has no NO_CLUSTER_MANAGER_BLOCK",
                if (output == null || currentState.equals(output)) {
        }
                        @Override
                    }
        private List<TransportAddress> seedHostsList;
            } else if (nodeExists(sender) && nodeExists(destination)) {
                final ClusterNode clusterNode = new ClusterNode(nextNodeIndex.getAndIncrement(), true, Settings.EMPTY, nodeHealthService);
        HANG,
        TransportService transportService
            + DEFAULT_CLUSTER_STATE_UPDATE_DELAY;
    // 7. apply committed state on cluster-manager (last one to apply cluster state)
        logger.info("Second run with seed [{}]", seed);
                return Optional.empty();
            // then wait for a follower to be promoted to leader
import java.util.function.Supplier;
import java.util.function.BiConsumer;
                return clusterApplierService.clusterStateApplyResponse;
            assertTrue(leaderId + " has been bootstrapped", leader.coordinator.isInitialConfigurationSet());
                    throw new AssertionError("unexpected", e);
import org.opensearch.monitor.NodeHealthService;
                delegate.setCurrentTerm(currentTerm);
                } catch (IOException e) {
                connectionStatus = ConnectionStatus.DISCONNECTED;
                return new ClusterNode(
            return connectionStatus;
                    // A 1-node cluster has no need for fault detection etc so will eventually run out of things to do.
                        final int key = randomIntBetween(0, keyRange);
                    Randomness.get(),
                    if (success == false) {
            public void setCurrentTerm(long currentTerm) {
                    MockPersistedState oldState = (MockPersistedState) persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL);
                    UUIDs.randomBase64UUID(random()), // generated deterministically for repeatable tests
            address,
                if (clusterNode.coordinator.getMode() == Mode.LEADER || clusterNode.coordinator.getMode() == Mode.FOLLOWER) {
        private final LinearizabilityChecker linearizabilityChecker = new LinearizabilityChecker();
                    a -> localNode,
                final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                        } else {
            }
                        .limit((Math.max(initialConfiguration.getNodeIds().size(), 2) - 1) / 2)
            private final DiscoveryNode localNode;
                                newLastAcceptedTerm,
                        leader.coordinator.missingJoinVoteFrom(clusterNode.getLocalNode())
                    clusterService,
import org.opensearch.cluster.coordination.PersistedStateRegistry.PersistedStateType;
                    return Optional.of(currentState);
        }
        nextNodeIndex.set(0);
                Function<Long, Long> adaptCurrentTerm
            assert filteredNodes.isEmpty() == false;
                    @Override
                lastCommittedConfiguration.getNodeIds(),
import java.io.UncheckedIOException;
                );
                ? seedHostsList
            List<ClusterNode> acceptableNodes = this.clusterNodes.stream()
                    clusterService.close();
import org.opensearch.cluster.ClusterStateUpdateTask;
                        public void onFailure(String source, Exception e) {
                                newLastAcceptedTerm = randomLongBetween(0L, Math.min(persistedCurrentTerm, lastAcceptedTerm - 1));
                        }).run();
                    node -> new MockPersistedState(newLocalNode, persistedStateRegistry, adaptGlobalMetadata, adaptCurrentTerm),
                        logger.debug("----> [runRandomly {}] reducing delay variability and running until [{}ms]", step, finishTime);
    public void resetPortCounterBeforeEachTest() {
        assertEquals(clusterState1.term(), clusterState2.term());
import static org.opensearch.node.Node.NODE_NAME_SETTING;
/*
                }
                            new ParameterizedMessage("failed to set initial configuration to {}", configurationWithPlaceholders),
                                newValue,
            @Override
            if (blackholedNodes.contains(sender.getId()) || blackholedNodes.contains(destination.getId())) {
         * @param delayVariability the delay variability to use while running randomly. Usually {@link Cluster#EXTREME_DELAY_VARIABILITY}.
        }
            );
                        );
import org.opensearch.common.util.BigArrays;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                );
            ClusterNode(int nodeIndex, boolean clusterManagerEligible, Settings nodeSettings, NodeHealthService nodeHealthService) {
                        );
                    coordinator.close();
    }
                boolean unDisconnected = disconnectedNodes.remove(localNode.getId());
 * specific language governing permissions and limitations
        public void onNewClusterState(String source, Supplier<ClusterState> clusterStateSupplier, ClusterApplyListener listener) {
import static org.opensearch.cluster.coordination.FollowersChecker.FOLLOWER_CHECK_INTERVAL_SETTING;
        void runRandomly(boolean allowReboots, boolean coolDown, long delayVariability) {
                                .persistentSettings(
        @Override
        private final Set<Tuple<String, String>> blackholedConnections = new HashSet<>();
                    localNode.getName(),
                    threadPool,
            } else if (blackholedConnections.contains(Tuple.tuple(sender.getId(), destination.getId()))) {
                        .put(nodeSettings)
        return new Runnable() {
 * ownership. Elasticsearch licenses this file to you under
                    ackCollector.onNodeAck(node, e);
                    assertThat(
            }
                transportService.disconnectFromNode(clusterNode.localNode);
                    public void onFailure(String source, Exception e) {
                boolean unBlackholed = blackholedNodes.remove(localNode.getId());
                    final VotingConfiguration configurationWithPlaceholders = new VotingConfiguration(nodeIds);
                final DiscoveryNode newLocalNode = new DiscoveryNode(
                        if (updatedMetadata != oldState.getLastAcceptedState().metadata() || updatedTerm != oldState.getCurrentTerm()) {
        @Override
                    assertEquals("expected " + applierState + " but got " + storedState, value(applierState), value(storedState));
                return clusterApplierService.state();
                        .build(); // suppress auto-bootstrap
import org.apache.logging.log4j.CloseableThreadContext;
import static org.opensearch.cluster.coordination.LeaderChecker.LEADER_CHECK_RETRY_COUNT_SETTING;
                );
                    throw new UncheckedIOException(new IOException("simulated IO exception [" + description + ']'));
                    + DEFAULT_DELAY_VARIABILITY
    public static Runnable onNodeLog(DiscoveryNode node, Runnable runnable) {
            return new ClusterStatePublisher.AckListener() {
                        if ( // node is cluster-manager-ineligible either before or after the restart ...
                final Runnable wrapped = onNodeLog(localNode, runnable);
        boolean hasAckedSuccessfully(ClusterNode clusterNode) {
                    transportService
                            .filter(transport -> transport.getLocalNode().getAddress().equals(address))
    protected final List<NodeEnvironment> nodeEnvironments = new ArrayList<>();
        void blackholeConnectionsFrom(ClusterNode sender, ClusterNode destination) {
            stabilise(DEFAULT_STABILISATION_TIME);
            MockPersistedState(
                                newLocalNode,
import java.util.ArrayList;
    // 2. send PublishRequest
        }
                this.nodeHealthService = nodeHealthService;
                                thisStep,
                return delegate.getLastAcceptedState();
                        history.remove(eventId);
                                clusterNode.getId()
        private List<TransportAddress> provideSeedHosts(SeedHostsProvider.HostsResolver ignored) {
                    cs -> ClusterState.builder(cs)
import static org.hamcrest.Matchers.not;
                    runnable.run();
    @After
    // Pinging all peers twice should be enough to discover all nodes
            }
                    );
                    @Override
                        "Election scheduler should stop after cluster has stabilised",
    }
                ClusterNode clusterNode = getAnyNode();
                            e
        final long result2 = RandomizedContext.current().runWithPrivateRandomness(seed, test);
import java.util.concurrent.atomic.AtomicBoolean;
        class ClusterNode {
            Consumer<Runnable> onTaskAvailableToRun
            return unsuccessfulNodes.contains(clusterNode.localNode);
                        final boolean autoShrinkVotingConfiguration = randomBoolean();
                        if (clusterNodes.contains(ClusterNode.this) == false) {
                .collect(Collectors.toList());
 */
 * this work for additional information regarding copyright
import static org.opensearch.cluster.coordination.ClusterBootstrapService.BOOTSTRAP_PLACEHOLDER_PREFIX;
            + defaultMillis(ELECTION_INITIAL_TIMEOUT_SETTING) * ELECTION_RETRIES + defaultMillis(ELECTION_BACK_OFF_TIME_SETTING)
                return ackCollector;
import static org.opensearch.transport.TransportService.NOOP_TRANSPORT_INTERCEPTOR;
                            adaptCurrentTerm.apply(persistedCurrentTerm),
    private static final int ELECTION_RETRIES = 10;
            // Bound the time how long the checker can run on such histories (Values empirically determined)
    }
import java.util.List;
                );
                int nodeIndex,
        return setting.get(Settings.EMPTY).millis() + DEFAULT_DELAY_VARIABILITY;
                                if (clusterNode.heal()) {
                                return "disconnect from " + clusterNode.getLocalNode() + " after shutdown";
                            persistedCurrentTerm = oldState.getCurrentTerm();
                                clusterNode.getId()
                                autoShrinkVotingConfiguration,
                        leader.getLastAppliedClusterState().getNodes().nodeExists(nodeId)
        List<ClusterNode> addNodes(int newNodesCount) {
            }
                    public void onFailure(String source, Exception e) {
                    clusterService.getSettings(),
                    null,
                            + oldClusterState.version()
                    clusterApplierService,
    }
                            step,
    };
            void setClusterStateApplyResponse(ClusterStateApplyResponse clusterStateApplyResponse) {
        /**
        }
                            logger.debug(
                final MockPersistedState persistedState = persistedStateSupplier.apply(localNode);
                            .findAny();
                        persistedState.close(); // removes it from openPersistedStates
        ThreadPool threadPool,
 * GitHub history for details.
                } else {
            ClusterNode restartedNode() {
                    );
                // history is completed with null, simulating timeout, which assumes that read went through
                                clusterNode.coordinator.becomeCandidate("runRandomly");
                        clusterNode.coordinator.getLastAcceptedState().getVersion(),
            void onDisconnectEventFrom(ClusterNode clusterNode) {
            List<BiConsumer<DiscoveryNode, ClusterState>> extraJoinValidators = new ArrayList<>();
                    } catch (CoordinationStateRejectedException e) {
            return acceptableNodes;
        private final Set<String> blackholedNodes = new HashSet<>();
            }
import java.util.HashSet;
                assertTrue(openPersistedStates.remove(this));
    }
                        clusterNode.getLastAppliedClusterState().blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK),
            Collections.emptyMap(),
                        clusterNode.onNode(() -> {
    public ClusterState setValue(ClusterState clusterState, int key, long value) {
                    }
        DisruptableClusterApplierService(
    public long value(ClusterState clusterState) {
                    "test_node",
                    new ClusterManagerMetrics(metricsRegistry),
            try {
        @Override
import org.opensearch.common.io.stream.BytesStreamOutput;
            public long getCurrentTerm() {
                Matchers.hasItem(leader.getLocalNode().getId())
            assertThat(leaderId + " has applied its state ", leader.getLastAppliedClusterState().getVersion(), isEqualToLeaderVersion);
            runFor((pendingTaskCount + 1) * DEFAULT_CLUSTER_STATE_UPDATE_DELAY, "draining task queue");
            logger.info("linearizability check completed");
                                ).createWriter()
                    final Set<String> nodeIdsWithPlaceholders = new HashSet<>(initialConfiguration.getNodeIds());
 *
                    } else {
                    this.targetsByNode.put(discoveryNode, createConnectionTarget(discoveryNode));
                        deterministicTaskQueue.setExecutionDelayVariabilityMillis(DEFAULT_DELAY_VARIABILITY);
                ClusterStateTaskListener taskListener
                            }
            Set<String> forbiddenIds = Arrays.stream(clusterNodes).map(ClusterNode::getId).collect(Collectors.toSet());
            ThreadPool threadPool,
                        }).run();
    // 6. receive ApplyCommitResponse
                    transportService,
            AckCollector submitValue(final int key, final long value) {
        // If leader just blackholed, need to wait for this to be detected
                    protected ConnectionStatus getConnectionStatus(DiscoveryNode destination) {
                return blackholed;
                        }
                ClusterState storedState = committedStatesByVersion.get(applierState.getVersion());
                equalTo(false)
                    .filter(n -> initialConfiguration.getNodeIds().contains(n.getLocalNode().getId()))
                remoteStoreNodeService = new RemoteStoreNodeService(new SetOnce<>(repositoriesService)::get, threadPool);
        @Override
                );
                }
            logger.info("--> adding {} nodes", newNodesCount);
                addedNodes.add(clusterNode);
            final AckCollector ackCollector = nextAckCollector;
    protected static int defaultInt(Setting<Integer> setting) {
                );
                        history.respond(eventId, value(newState, key));
                try {
            ClusterSettings clusterSettings,
        }
                Settings nodeSettings
                        }).run();
                            ClusterStateUpdaters.addStateNotRecoveredBlock(ClusterState.readFrom(inStream, newLocalNode))
import org.opensearch.cluster.routing.allocation.AllocationService;
        void stabilise() {
                            logger.debug(
            .stream()
package org.opensearch.cluster.coordination;
 *
            }
        };
                            ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING.get(Settings.EMPTY)
        return ElectionStrategy.DEFAULT_INSTANCE;
                possiblyFail("before writing term of " + currentTerm);
                                newVotingConfiguration,
                    );
                public void onCommit(TimeValue commitTime) {
            this(initialNodeCount, true, Settings.EMPTY);
                    )
 * the Apache License, Version 2.0 (the "License"); you may
        }
                        public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                    public void run() {
                leader.getLastAppliedClusterState().blocks().hasGlobalBlockWithId(NO_CLUSTER_MANAGER_BLOCK_ID),
                }).run();
                        : emptySet(),
                    defaultPersistedStateSupplier,
import org.hamcrest.Matchers;
                                );
            final List<Runnable> cleanupActions = new ArrayList<>();
            assertFalse("stabilisation requires stable storage", disruptStorage);
        FAIL,
                                oldState.getLastAcceptedState().writeTo(outStream);
            }
                            isEqualToLeaderVersion
                    return clusterNode;
                        Settings.builder().put(clusterState.metadata().persistentSettings()).put("value_" + key, value).build()
                    if (finishTime == -1 && randomBoolean() && randomBoolean() && randomBoolean()) {
            return seedHostsList != null
                        final ClusterNode clusterNode = getAnyNodePreferringLeaders();
        public void close() {
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
            DiscoveryNode getLocalNode() {
    public static NodeConnectionsService createTestNodeConnectionsService(
                    } else if (rarely()) {
                        clusterNode.onNode(() -> {
import java.util.HashMap;
                        history.respond(eventId, value(oldState, key));
                    } else if (rarely()) {
            super(nodeName, serviceName, threadPool, onTaskAvailableToRun);
                    (dn, cs) -> extraJoinValidators.forEach(validator -> validator.accept(dn, cs))
                        final ClusterState oldClusterState = event.previousState();
                return getLocalNode().isClusterManagerNode() == false || coordinator.isInitialConfigurationSet() == false;
            final int randomSteps = scaledRandomIntBetween(10, 10000);
                    transportService,
            return getAnyNodeExcept();
                clusterApplierService = new DisruptableClusterApplierService(
                            )
                    // In the real-life IOError might be thrown, for example if state fsync fails.
                    } else if (allowReboots && rarely()) {
         * @param allowReboots whether to randomly reboot the nodes during the process, losing all transient state. Usually true.
                    assertThat(nodeId + " is a follower of " + leaderId, clusterNode.coordinator.getMode(), is(FOLLOWER));
            assertThat("may reconnect blackholed nodes, probably unexpected", blackholedNodes, empty());
         */
            }
                            } else {
                return localNode.getId();
                    : randomFrom(ConnectionStatus.DISCONNECTED, ConnectionStatus.BLACK_HOLE);
                        ? DiscoveryNodeRole.BUILT_IN_ROLES
            }
                        );
            assertTrue(
            }
                        equalTo(leader.getLocalNode())
            this.deterministicTaskQueue = deterministicTaskQueue;
        Cluster(int initialNodeCount) {
    public void assertAllPersistedStatesClosed() {
                return afterRunRandomly ^ afterStabilisation;
            .metadata(
                    updateCommittedStates();
            public void close() {
                }).run();
                    }
            public void run() {
            for (int i = 0; i < initialNodeCount; i++) {
                    if (initialConfiguration.getNodeIds().contains(localNode.getId()) && nodeIds.contains(localNode.getId()) == false) {
                assert disconnected || unBlackholed == false;
        /**
                            final long newLastAcceptedTerm;
            blackholedConnections.add(Tuple.tuple(sender.getId(), destination.getId()));
                    getTransportInterceptor(localNode, threadPool),
        return value(clusterState, 0);
                        })));
import org.opensearch.test.disruption.DisruptableMockTransport;
            }
            random()
            public PersistedStateStats getStats() {
            initialConfiguration = new VotingConfiguration(
            final int pendingTaskCount = leader.clusterManagerService.getFakeClusterManagerServicePendingTaskCount();
                @Override
                : clusterNodes.stream().map(ClusterNode::getLocalNode).map(DiscoveryNode::getAddress).collect(Collectors.toList());
                transportService = mockTransport.createTransportService(
            @Override
                    }
                        // reads do not change state
                    assertThat(
                return coordinator.getMode() == CANDIDATE;
            assertThat("may reconnect disconnected nodes, probably unexpected", disconnectedNodes, empty());
                * ELECTION_RETRIES * (ELECTION_RETRIES - 1) / 2 + defaultMillis(ELECTION_DURATION_SETTING) * ELECTION_RETRIES
                } finally {
import java.util.function.Function;
            DeterministicTaskQueue deterministicTaskQueue,
                    assertFalse(
                DiscoveryNode localNode,
            } finally {
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                    nodeSettings,
    public Set<Integer> keySet(ClusterState clusterState) {
                        nullValue()
                    clusterSettings,
            @Override
        }
                @Override
import org.opensearch.test.disruption.DisruptableMockTransport.ConnectionStatus;
            return randomFrom(filteredNodes);
                            final long newLastAcceptedVersion;
import org.opensearch.cluster.ClusterModule;
                : new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
                try (CloseableThreadContext.Instance ignored = CloseableThreadContext.put(NODE_ID_LOG_CONTEXT_KEY, nodeId)) {
import org.opensearch.transport.TransportService;
        }
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            while (finishTime == -1 || deterministicTaskQueue.getCurrentTimeMillis() <= finishTime) {
                                clusterState(0L, 0L, localNode, VotingConfiguration.EMPTY_CONFIG, VotingConfiguration.EMPTY_CONFIG, 0L)
 * Modifications Copyright OpenSearch Contributors. See
                            ).writeTo(outStream);
                    nodeSettings,
                        leader.getLastAppliedClusterState().getNodes().nodeExists(nodeId)
import org.opensearch.common.SetOnce;
            Version.CURRENT
            return randomFrom(
                    } else if (finishTime == -1 && randomBoolean() && randomBoolean() && randomBoolean()) {
                possiblyFail("before writing last-accepted state of term=" + clusterState.term() + ", version=" + clusterState.version());
    public void assertStateEquals(ClusterState clusterState1, ClusterState clusterState2) {
                        throw new OpenSearchException("simulated cluster state applier failure");
    enum ClusterStateApplyResponse {
    /**
        void bootstrapIfNecessary() {
                    clusterService,
                onNode(() -> {
            } else {
                        }
        }
                clusterApplierService.clusterStateApplyResponse = clusterStateApplyResponse;
                                    new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            boolean isLeader() {
                                    ClusterState.builder(oldState.getLastAcceptedState()).metadata(updatedMetadata).build()
                    assert clusterNodes.size() == 1 : clusterNodes.size();
                    assertTrue(
            );
                    ? nodeSettings
                    });
                    } else if (rarely()) {
                            .map(cn -> cn.mockTransport)
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            private ClusterService clusterService;
                || (getConnectionStatus(n1.getLocalNode(), n2.getLocalNode()) == ConnectionStatus.CONNECTED
        final List<ClusterNode> clusterNodes;
import static org.hamcrest.Matchers.empty;
        }
                        }
import static org.opensearch.cluster.coordination.NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID;
            }
                            assertNotNull("State not committed : " + newState.toString(), state);
import org.opensearch.core.common.io.stream.StreamInput;
                    : Settings.builder()
        private boolean isConnectedPair(ClusterNode n1, ClusterNode n2) {
 * Unless required by applicable law or agreed to in writing,
                    nodeHealthService
                }
        }
                );
            void readValue(int key) {
                                    newLastAcceptedTerm == lastAcceptedTerm ? lastAcceptedVersion - 1 : Long.MAX_VALUE
import org.opensearch.test.telemetry.TestInMemoryMetricsRegistry;
        return clusterState.metadata()
        private final Set<DiscoveryNode> ackedNodes = new HashSet<>();
            while (deterministicTaskQueue.getCurrentTimeMillis() < endTime) {
                NodeConnectionsService nodeConnectionsService = createTestNodeConnectionsService(
                    threadPool,
/*
                                newLastAcceptedTerm = randomLongBetween(0L, Math.min(persistedCurrentTerm, lastAcceptedTerm));
                            ) {
                    newLocalNode,
        class MockPersistedState implements CoordinationState.PersistedState {
                            }
                equalTo(lastAcceptedState.getLastAcceptedConfiguration())
 * Licensed to Elasticsearch under one or more contributor
        )
import org.opensearch.discovery.DiscoveryModule;
    public void resetNodeIndexBeforeEachTest() {
                initialNodeCount,
            private boolean isNotUsefullyBootstrapped() {
                            public String toString() {
                        );
                    scheduler.schedule(() -> abort.set(true), 10, TimeUnit.SECONDS);
                        nodeId + " is not in the applied state on " + leaderId,
        public Object initialState() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                                    + "previously currentTerm={}, lastAcceptedTerm={}, lastAcceptedVersion={} "
                    } else if (rarely()) {
import org.opensearch.common.util.MockBigArrays;
            }
    }
                PersistedStateRegistry persistedStateRegistry,
                        assert oldClusterState.version() <= newClusterState.version() : "updating cluster state from version "
                    address.getAddress(),
                            clusterNode.getLastAppliedClusterState().getNodes().nodeExists(nodeId)
            ClusterStateApplyResponse getClusterStateApplyResponse() {
                            assertStateEquals(state, newState);
                        // would prevent the cluster to reach a stable state after cooling down. Additionally, avoid any new disruptions
                                break;
import org.opensearch.cluster.NodeConnectionsService;
                final GatewayService gatewayService = new GatewayService(
                    clusterService.stop();
                            );
                    }
            @Override
                    assertThat(nodeId + " did not change term", clusterNode.coordinator.getCurrentTerm(), is(leaderTerm));
                            @Override
                    );
                ThreadPool.terminate(scheduler, 1, TimeUnit.SECONDS);
            ) {
            );
                    threadPool,
    public void closeNodeEnvironmentsAfterEachTest() {
                final int eventId = history.invoke(new Tuple<>(key, null));
        assertThat(spec.initialState(), equalTo(0L));
                        final ClusterNode clusterNode = getAnyNode();
                    @Override
            logger.info(
                                break;
                            logger.debug(() -> new ParameterizedMessage("failed to publish: [{}]", source), e);
                    nodeHealthService
                }
                clusterService = new ClusterService(settings, clusterSettings, clusterManagerService, clusterApplierService);
import org.opensearch.cluster.node.DiscoveryNodes;
        }
import org.opensearch.cluster.metadata.Metadata;
                    }
                        )
                }
        }
    static class DisruptableClusterApplierService extends ClusterApplierService {
                        delegate = new InMemoryPersistedState(
                    "set cluster-manager nodes failure tolerance [" + autoShrinkVotingConfiguration + "]",
                        // to happen in this phase.
        private ConnectionStatus getConnectionStatus(DiscoveryNode sender, DiscoveryNode destination) {
            final Matcher<Long> isEqualToLeaderVersion = equalTo(leader.coordinator.getLastAcceptedState().getVersion());
                    success = true;
                final Settings settings = nodeSettings.hasValue(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey())
                final String nodeId = clusterNode.getId();
                                "----> [runRandomly {}] proposing new value [{}] to [{}]",
                leader.getLastAppliedClusterState().blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK),
                if (disruptStorage && rarely()) {
                            // ... and it's accepted some non-initial state so we can roll back ...
                            persistedCurrentTerm = randomLongBetween(0L, oldState.getCurrentTerm());
            assertEquals(value(clusterState1, key), value(clusterState2, key));
                    threadPool,
                                .build()
import org.opensearch.common.util.MockPageCacheRecycler;
import static org.hamcrest.Matchers.is;
                        return wrapped.toString();
            }
        private final Map<Long, ClusterState> committedStatesByVersion = new HashMap<>();
                    Collections.emptyMap(),
                "stabilisation requires default delay variability (and proper cleanup of raised variability)",
    // Updating the cluster state involves up to 7 delays:
        logger.info("First run with seed [{}]", seed);
                        clusterNode.onNode(() -> {
        }
        }
                        clusterNode.getLastAppliedClusterState().blocks().hasGlobalBlockWithId(NO_CLUSTER_MANAGER_BLOCK_ID),
import java.util.concurrent.Callable;
            seedHostsList = emptyList();
                    localNode.getId(),
                }).run();
import java.util.Collection;
            ConnectionStatus.BLACK_HOLE
            nodeEnvironment.close();
            for (final ClusterNode clusterNode : clusterNodes) {
            boolean blackhole() {
                );
            .collect(Collectors.toSet());
                return localNode;
            }
        SUCCEED,
                this(
            final int keyRange = randomSteps / 50; // for randomized writes and reads
                    );
                        }
                // we rely on disconnect to run for keeping track of pendingDisconnects and ensuring node-joins can happen
        assertThat(spec.nextState(7, null, null), equalTo(Optional.of(7))); // read times out
            }
            + defaultMillis(PUBLISH_TIMEOUT_SETTING) + DEFAULT_ELECTION_DELAY
                                    + "but now currentTerm={}, lastAcceptedTerm={}, lastAcceptedVersion={}",
            }
            return clusterNodes.stream().anyMatch(cn -> cn.getLocalNode().equals(node));
            this.applicationMayFail = true;
import org.opensearch.core.common.transport.TransportAddress;
            }
                final AckCollector ackCollector = new AckCollector();
            Runnable onNode(Runnable runnable) {
                                newLastAcceptedTerm,
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                } catch (CoordinationStateRejectedException | UncheckedIOException ignored) {
            boolean isCandidate() {
                    defaultMillis(DISCOVERY_FIND_PEERS_INTERVAL_SETTING) * 2, "discovery prior to setting initial configuration");
                return nodeId + ": " + runnable.toString();
            // Then a commit of the new leader's first cluster state
                    localNode.getId(),
        );
            public ClusterState getLastAcceptedState() {
                                newLocalNode,
            public TestInMemoryMetricsRegistry getMetricsRegistry() {
    // check that runRandomly leads to reproducible results
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.OpenSearchException;
                unsuccessfulNodes.add(node);
                        final Metadata updatedMetadata = adaptGlobalMetadata.apply(oldState.getLastAcceptedState().metadata());
                                break;
            AckCollector submitUpdateTask(
        protected ClusterStatePublisher.AckListener wrapAckListener(ClusterStatePublisher.AckListener ackListener) {
import org.opensearch.common.collect.Tuple;
            }
            final Settings nodeSettings;
 *
                                }
    protected TransportInterceptor getTransportInterceptor(DiscoveryNode localNode, ThreadPool threadPool) {
                    (source, e) -> {}
        protected boolean applicationMayFail() {
        }
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            return addedNodes;
import com.carrotsearch.randomizedtesting.RandomizedContext;
            assert successfulNodes.contains(clusterNode.localNode) : "get index of " + clusterNode;
            final long endTime = deterministicTaskQueue.getCurrentTimeMillis() + runDurationMillis;
        for (NodeEnvironment nodeEnvironment : nodeEnvironments) {
                DiscoveryNode newLocalNode,
                    final long submittedTerm = coordinator.getCurrentTerm();
            String serviceName,
                        switch (randomInt(2)) {
import org.opensearch.gateway.MockGatewayMetaState;
            }
                        .forEach(nodeIdsWithPlaceholders::add);
        }
                        logger.debug("----> [runRandomly {}] applying initial configuration on {}", step, clusterNode.getId());
    }
         * @param coolDown whether to set the delay variability back to {@link Cluster#DEFAULT_DELAY_VARIABILITY} and drain all
    public static final String NODE_ID_LOG_CONTEXT_KEY = "nodeId";
                    settings,
import org.opensearch.common.util.concurrent.PrioritizedOpenSearchThreadPoolExecutor;
                final ClusterNode clusterNode = new ClusterNode(
            }
                            assertThat(currentState.term(), greaterThanOrEqualTo(submittedTerm));
                    clusterManagerEligibleNodeIds.add(clusterNode.getId());
                }
                }
            }
        public Optional<Object> nextState(Object currentState, Object input, Object output) {
    /**
                return new Runnable() {
                        final MockGatewayMetaState gatewayMetaState = new MockGatewayMetaState(newLocalNode, bigArrays);
            }
                        // reboot random node
                            try (
                                    bigArrays,
        final TransportAddress address = buildNewFakeTransportAddress();
            assertThat(
                                cn.transportService.disconnectFromNode(clusterNode.getLocalNode());
                coordinator.start();
            + DEFAULT_CLUSTER_STATE_UPDATE_DELAY;
                successfulNodes.add(node);
        assertThat(spec.nextState(7, 42, null), equalTo(Optional.of(42))); // write 42 times out
                    // This is ok: it just means a message couldn't currently be handled.
                    Cluster.this::provideSeedHosts,
