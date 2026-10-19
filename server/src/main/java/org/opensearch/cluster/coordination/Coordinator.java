                        lastPublishedState = currentPublication.get().publishedState();
        );
            publishListener.onFailure(new FailedToCommitClusterStateException("publishing failed", e));
        assert Thread.holdsLock(mutex) : "Coordinator mutex not held";
        }
        preVoteCollector.update(getPreVoteResponse(), getLocalNode());
        followersChecker.clearCurrentNodes();
        @Override
                final CoordinatorPublication publication = new CoordinatorPublication(
    boolean publicationInProgress() {
        } else {
                return "scheduling of new prevoting round";
                getDiscoveredNodes().forEach(node -> {
                @Override
            public void onResponse(T t) {
    // package-visible for testing
                    logger.warn(
                                                        state.getLastCommittedConfiguration(),
                if (publicationInProgress()) {
        configuredHostsResolver.stop();
    private Optional<DiscoveryNode> lastKnownLeader;
                    nodeConnectionsService.clearPendingDisconnections();
                        CoordinatorPublication.this.toString(),
    /**
                        + votingConfiguration
            @Override
            updateMaxTermSeen(joinRequest.getTerm());
                    try {
                                    lagDetector.startLagDetector(publishRequest.getAcceptedState().version());
            }
        }
        assert leaderNode.isClusterManagerNode() : leaderNode + " became a leader but is not cluster-manager-eligible";
import java.util.Random;
import java.util.function.BiConsumer;
    private static final Logger logger = LogManager.getLogger(Coordinator.class);
                    return;
        FOLLOWER
    }
import org.opensearch.common.xcontent.XContentHelper;
            || lastAcceptedState.getVotingConfigExclusions().stream().noneMatch(vce -> vce.getNodeId().equals(nodeId));
    private void updateMaxTermSeen(final long term) {
                public void run() {
            peerFinder.setCurrentTerm(getCurrentTerm());
            logger.trace("scheduling reconfiguration");
                        new ClusterApplyListener() {
        TimeValue.timeValueMillis(1),
                assert assertPreviousStateConsistency(clusterChangedEvent);
        } catch (CoordinationStateRejectedException e) {
                                                .collect(Collectors.toList());
                assert lastKnownLeader.equals(Optional.of(leaderChecker.leader()));
            if (mode == Mode.LEADER) {
        try {
    }
                return clusterStateWithNoClusterManagerBlock(clusterState);
            if (node.isClusterManagerNode()
    }
 *
    @Override
                assert becomingClusterManager
            .map(VotingConfigExclusion::getNodeName)
                        + ", rejecting"
            if (votingConfiguration.getNodeIds().contains(getLocalNode().getId()) == false) {
            transportService,
        );
                    publishListener
                assert leaderChecker.leader() == null : leaderChecker.leader();
            } else {
        Consumer<ClusterState> updateLastSeen,
        Set<String> nodeIdsWithAbsentName = votingConfigExclusions.stream()
        }
                    } else {
                .lastCommittedConfiguration(votingConfiguration)
            PublishRequest publishRequest,
    }
        }
import org.opensearch.cluster.node.DiscoveryNode;
                        && (applierState.term() < getCurrentTerm() || applierState.version() < getLastAcceptedState().version()));
        Set<String> nodeNamesWithAbsentId = votingConfigExclusions.stream()
        );
import org.opensearch.cluster.LocalClusterUpdateTask;
    @Nullable
        if (remoteClusterStateService != null) {
        TransportService transportService,
            final ClusterState clusterState = coordinationState.get().getLastAcceptedState();
    private void setPublishTimeout(TimeValue publishTimeout) {
                logger.debug("initialized PublicationContext using class: {}", publicationContext.getClass().toString());
    ClusterState improveConfiguration(ClusterState clusterState) {
        }
    private final NoClusterManagerBlockService noClusterManagerBlockService;
    private final SeedHostsResolver configuredHostsResolver;
        if (coordinationState != null) {
                    e
 * not use this file except in compliance with the License.
            mode = Mode.FOLLOWER;
                assert clusterFormationFailureHelper.isRunning();
    private NodeConnectionsService nodeConnectionsService;
            }
            public String toString() {
        );
                joinHelper.sendJoinRequest(clusterManagerNode, getCurrentTerm(), joinWithDestination(lastJoin, clusterManagerNode, term));
            settings,
                final PublishRequest publishRequest = coordinationState.get().handleClientValue(clusterState);
                    clusterChangedEvent,
            final long currentTerm = getCurrentTerm();
            logger.debug(
 */
                && mode == Mode.FOLLOWER
                    listener.onResponse(t);
    private final Random random;
    private volatile ClusterState applierState; // the state that should be exposed to the cluster state applier
            publicationContext.sendApplyCommit(destination, applyCommit, wrapWithMutex(responseActionListener));
            if (mode == Mode.LEADER) {
        return false;
                applyListener.onResponse(null);
            if (isZen1Node(node) == false) {
import org.opensearch.common.settings.Setting;
    }
            )
    // the timeout before emitting an info log about a slow-running publication
        clusterManagerService.submitStateUpdateTask("clean-up after stepping down as cluster-manager", new LocalClusterUpdateTask() {
            if (isInitialConfigurationSet()) {
                logger.info(new ParameterizedMessage("cluster-manager node [{}] failed, restarting discovery", lastKnownLeader.get()), e);
                        if (prevotingRound != null) {
            "{}: coordinator becoming LEADER in term {} (was {}, lastKnownLeader was [{}])",
        ) {
                    );
                        new FailedToCommitClusterStateException("publication " + currentPublication.get() + " already in progress")
        ClusterStateStats clusterStateStats = clusterManagerService.getClusterStateStats();
                // a late response may arrive after the state has been locally applied, meaning that receivedJoins has already been
import org.opensearch.common.Nullable;
        protected void sendApplyCommit(
    }
                // the cluster-manager service checks if the local node is the cluster-manager node in order to fail execution of the state
import java.util.concurrent.atomic.AtomicBoolean;
                }
            )
            super(publishRequest, new ClusterStatePublisher.AckListener() {
                singleNodeDiscovery ? hostsResolver -> Collections.emptyList() : configuredHostsResolver
        // that makes
                    listener.onFailure(e);
            .getLocalNode()
                assert coordinationState.get().electionWon() == false : getLocalNode() + " is FOLLOWER so electionWon() should be false";
                            "[{}] failed publication as node is no longer cluster-manager for term {}",
 * Licensed to Elasticsearch under one or more contributor
        assert Thread.holdsLock(mutex) : "Coordinator mutex not held";
                // update early
        }
            return ClusterState.builder(clusterState).blocks(clusterBlocks).nodes(discoveryNodes).build();
                // If we haven't completely finished becoming cluster-manager then there's already a publication scheduled which will, in
            ConfiguredHostsResolver configuredHostsResolver
                        // active publication in progress: followersChecker is up-to-date with nodes that we're actively publishing to
                    foundPeers.forEach(expectedVotes::addVote);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
                final CoordinatorPublication publication = currentPublication.get();
        this.persistedStateSupplier = persistedStateSupplier;
            if (applierState.nodes().getClusterManagerNodeId() != null) {
    }
        // exclude any nodes whose ID is in the voting config exclusions list ...
        assert Thread.holdsLock(mutex) : "Coordinator mutex not held";
                );
                        + "] set to ["
        protected void startProbe(TransportAddress transportAddress) {
            this.localNodeAckEvent = localNodeAckEvent;
            synchronized (mutex) {
                    // to ensure we fail as fast as possible.
            if (singleNodeDiscovery == false) {
            if (publishRequest.getAcceptedState().term() == ZEN1_BWC_TERM
            }
                followersChecker.setCurrentNodes(publishNodes);
                );
        final Stream<String> excludedNodeIds = clusterState.getVotingConfigExclusions().stream().map(VotingConfigExclusion::getNodeId);
            TransportService transportService,
        };
            logger.debug(
        protected void onActiveClusterManagerFound(DiscoveryNode clusterManagerNode, long term) {
        joinAccumulator.close(mode);
            }
    private final ClusterBootstrapService clusterBootstrapService;
        if (restartLeaderChecker) {
                        closePrevotingAndElectionScheduler();
            return new PublishWithJoinResponse(
import org.opensearch.cluster.metadata.Metadata;
        this.singleNodeDiscovery = DiscoveryModule.isSingleNodeDiscovery(settings);
        closePrevoting();
        Random random,
            if (receivedJoinsProcessed) {
import org.opensearch.common.settings.Settings;
        }
                assert preVoteCollector.getLeader() == getLocalNode() : preVoteCollector;
                );
import org.opensearch.common.xcontent.json.JsonXContent;
        final ClusterState state = getLastAcceptedState();
            settings,
                    } else {
                .metadata(
            this::removeNode,
                    );
            final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder(currentState.coordinationMetadata())
        return true;
            peerFinder.getLastResolvedAddresses(),
    }
                throw new CoordinationStateRejectedException(
    synchronized void onNodeCommissionStatusChange(boolean localNodeCommissioned) {
                synchronized (mutex) {
            @Override
                                        }
            .filter(discoveryNode -> isZen1Node(discoveryNode) == false)
                    // This set only needs to be maintained on active cluster-manager
                }
    private final ClusterApplier clusterApplier;
            });
                handleAssociatedJoin(join);
                );
                public void onFailure(Exception e) {
            }
        synchronized (mutex) {
        synchronized (mutex) {
        logger.debug(
            coordinationState.get().getLastAcceptedTerm(),
        PersistedStateRegistry persistedStateRegistry,
/*
        }
        ActionListener<Void> publishListener,
            // The remote node did not include a join vote in its publish response. We do not persist joins, so it could be that the remote
                    }
        private void cancelTimeoutHandlers() {
    public boolean isRemotePublicationEnabled() {
    }
        this.clusterBootstrapService = new ClusterBootstrapService(
 */
    private final SetOnce<CoordinationState> coordinationState = new SetOnce<>(); // initialized on start-up (see doStart)
                }
            return true;
        // the logging much harder to follow.
                }
                    + " vs "
            return coordinationState.get().handlePublishResponse(sourceNode, publishResponse);
            this.timeoutHandler = singleNodeDiscovery ? null : transportService.getThreadPool().schedule(new Runnable() {
            this.infoTimeoutHandler = transportService.getThreadPool().schedule(new Runnable() {
                // Rare case in which we stood down as leader between starting this publication and receiving it ourselves. The publication
                                cancelTimeoutHandlers();
    PublishWithJoinResponse handlePublishRequest(PublishRequest publishRequest) {
                        + localState.metadata().clusterUUID()
import org.apache.logging.log4j.LogManager;
                synchronized (mutex) {
            joinAccumulator = new JoinHelper.FollowerJoinAccumulator();
                    nodeRemovalExecutor,
import static org.opensearch.cluster.decommission.DecommissionHelper.nodeCommissioned;
        this.remoteClusterStateService = remoteClusterStateService;
                    || activePublication
     * @param votingConfiguration The nodes that should form the initial configuration.
        synchronized (mutex) {
            }
            leaderChecker.setCurrentNodes(DiscoveryNodes.EMPTY_NODES);
                                                        state.term(),
            if (persistedStateRegistry.getPersistedState(stateType) != null
import org.opensearch.core.xcontent.MediaTypeRegistry;
                }
                        + DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey()
        synchronized (mutex) {
                mode,
        closeElectionScheduler();
                logger.warn(
    private AtomicBoolean reconfigurationTaskScheduled = new AtomicBoolean();
                onJoinValidators.forEach(a -> a.accept(getLocalNode(), publishRequest.getAcceptedState()));
    @Override
        assert getLocalNode().isClusterManagerNode() : getLocalNode() + " became a leader but is not cluster-manager-eligible";
                                                    );
    private <T> ActionListener<T> wrapWithMutex(ActionListener<T> listener) {
     */
                    synchronized (mutex) {
    }
                                                .filter(DiscoveryNode::isClusterManagerNode)
                becomeFollower("handlePublishRequest", sourceNode); // also updates preVoteCollector
            ensureTermAtLeast(getLocalNode(), join.getTerm()).ifPresent(this::handleJoin);
    }
                                                abdicateTo(clusterManagerCandidates.get(random.nextInt(clusterManagerCandidates.size())));
                // If we have already won the election then the actual join does not matter for election purposes, so swallow any exception
                }
                    if (node.equals(getLocalNode())) {
            if (lastAcceptedState.metadata().clusterUUIDCommitted()) {
                                    logIncompleteNodes(Level.WARN);
                assert becomingClusterManager || getStateForClusterManagerService().nodes().getClusterManagerNodeId() != null
                final boolean isNewJoinFromClusterManagerEligibleNode = handleJoinIgnoringExceptions(join);
import java.util.function.Supplier;
                                        if (localNodeMayWinElection(state) == false) {
        });
            return coordinationState.get().getCurrentTerm();
            // term and therefore never removed the NO_MASTER_BLOCK for this term. This logic ensures that we quickly turn a node
    }
            .collect(Collectors.toSet());
                    1.0,
                        )
                                + clusterChangedEvent.state().term()
            coordinationState.get().handleCommit(applyCommitRequest);
    }
                                localNodeAckEvent.onFailure(e);
    private void closeElectionScheduler() {
        }
            }, transportService.getThreadPool()::relativeTimeInMillis);
            followersChecker.clearCurrentNodes();
            if (mode == Mode.CANDIDATE) {
            );
            nodeHealthService,
        }
        private final PublishRequest publishRequest;
    }
                @Override
                    ackListener,
                if (mode == Mode.CANDIDATE) {
            }
                    publishListener.onFailure(
                        .equals(coordinationState.get().getLastCommittedConfiguration()) : coordinationState.get()
        closePrevoting();
                    if (mode == Mode.CANDIDATE) {
            clusterManagerService.submitStateUpdateTask("reconfigure", new ClusterStateUpdateTask(Priority.URGENT) {
                        .getLastAcceptedConfiguration()
    private final RemoteClusterStateService remoteClusterStateService;
import org.opensearch.core.common.transport.TransportAddress;
                                            }
            TransportAddressConnector transportAddressConnector,
                }
            infoTimeoutHandler.cancel();
        peerFinder.deactivate(leaderNode);
                        return improveConfiguration(currentState);
                        }
                logger.trace("onFollowerCheckRequest: rejoining cluster-manager, responding successfully to {}", followerCheckRequest);
                                                            new Join(completedNode, node, futureElectionTerm, state.term(), state.version())
        ElectionStrategy electionStrategy,
                throw new CoordinationStateRejectedException(
            }
    /**
    private final ElectionSchedulerFactory electionSchedulerFactory;
            metadataBuilder.coordinationMetadata(coordinationMetadata);
    private final ClusterFormationFailureHelper clusterFormationFailureHelper;
            this::onNodeCommissionStatusChange,
                    reconfigurationTaskScheduled.set(false);
        peerFinder.deactivate(getLocalNode());
                settings,
                );
                        stateForJoinValidation.getNodes().getMinNodeVersion()
                assert prevotingRound == null : prevotingRound;
            configuredHostsResolver
            getCurrentTerm(),
                            "node is no longer cluster-manager for term "
                                            final List<DiscoveryNode> clusterManagerCandidates = completedNodes().stream()
     * @param nodeName The name of the node, used to name the {@link java.util.concurrent.ExecutorService} of the {@link SeedHostsResolver}.
            PublicationTransportHandler.PublicationContext publicationContext,
                        }
            if (currentPublication.isPresent()) {
    private void closePrevotingAndElectionScheduler() {
    }
public class Coordinator extends AbstractLifecycleComponent implements Discovery {
            lastKnownLeader
                // if a nodes tries to send a joinRequest while it is pending disconnect, it should fail
                        clusterStateWithNoClusterManagerBlock(coordinationState.get().getLastAcceptedState())
                            }
            assert followersChecker.getKnownFollowers().equals(lagDetector.getTrackedNodes()) : followersChecker.getKnownFollowers()
        clusterSettings.addSettingsUpdateConsumer(PUBLISH_TIMEOUT_SETTING, this::setPublishTimeout);
            } else {
import org.opensearch.common.Booleans;
            // speculatively calculates the next cluster state update
            }
        ActionListener<Void> applyListener
                    // This is cleaned up to avoid stale entries which would block future reconnections
     *
            }
    private Optional<Join> lastJoin;
            }, OpenSearchExecutors.newDirectExecutorService(), transportService.getThreadPool().getThreadContext());
                        ),
    /**
 * this file be licensed under the Apache-2.0 license or a
                }
        }
                        Tags.create().addTag(FOLLOWER_NODE_ID_TAG, discoveryNode.getId()).addTag(REASON_TAG, reasonToPublish)
            if (join.getTerm() == getCurrentTerm() && missingJoinVoteFrom(join.getSourceNode())) {
    /**
        assert Thread.holdsLock(mutex) == false;
            nodeHealthService,
                getCurrentTerm(),
                }
        synchronized (mutex) {
                        + "]"
        // safely accept a join whose last-accepted term/version is ahead of ours), so store them up and process them at the end.
                    reconfigurationTaskScheduled.set(false);
            if (votingConfiguration.hasQuorum(knownNodes.stream().map(DiscoveryNode::getId).collect(Collectors.toList())) == false) {
    }
            } else {
                try {
                            clusterChangedEvent.source(),
                joinWithDestination(lastJoin, sourceNode, publishRequest.getAcceptedState().term())
                                    removePublicationAndPossiblyBecomeCandidate("clusterApplier#onNewClusterState");
                JsonXContent.jsonXContent,
    // package-visible for testing
                        false
                    final ClusterState lastPublishedState;
                        + sourceNode
                            logger.debug("skip prevoting as local node is unhealthy: [{}]", statusInfo.getInfo());
        this.leaderChecker = new LeaderChecker(
 * Modifications Copyright OpenSearch Contributors. See
            if (getCurrentTerm() != followerCheckRequest.getTerm()) {
    private Releasable electionScheduler;
        return new PreVoteResponse(
                super.startProbe(transportAddress);
                assert followersChecker.getKnownFollowers().isEmpty();
    public Coordinator(
                    synchronized (mutex) {
                        if (statusInfo.getStatus() == UNHEALTHY) {
            if (mode != Mode.CANDIDATE) {
        final String nodeId = node.getId();
                public void onResponse(Void ignore) {
                } else {
            electionScheduler.close();
        ApplyCommitRequest applyCommitRequest,
            this::setInitialConfiguration
                lastKnownLeader
import static org.opensearch.gateway.ClusterStateUpdaters.hideStateIfNotRecovered;
import java.util.function.Consumer;
                )
                            logger.trace("skip prevoting as local node may not win election: {}", lastAcceptedState.coordinationMetadata());
            // check if node has accepted a state in this term already. If not, this node has never committed a cluster state in this
                if (isNewJoinFromClusterManagerEligibleNode && establishedAsClusterManager && publicationInProgress() == false) {
                throw new CoordinationStateRejectedException("no longer leading this publication's term: " + publishRequest);
            assert Thread.holdsLock(mutex) : "Coordinator mutex not held";
    }
            + newClusterManager;
                );
            return mode == Mode.LEADER && publishRequest.getAcceptedState().term() == getCurrentTerm();
 * license agreements. See the NOTICE file distributed with
        final Set<DiscoveryNode> liveNodes = StreamSupport.stream(clusterState.nodes().spliterator(), false)
                assert joinAccumulator instanceof JoinHelper.LeaderJoinAccumulator;
            if (mode != Mode.LEADER || clusterState.term() != getCurrentTerm()) {
                public void onCommit(TimeValue commitTime) {
        }
        followersChecker.updateFastResponseState(getCurrentTerm(), mode);
/**
        preVoteCollector.update(getPreVoteResponse(), leaderNode);
                    }
        return nodeMayWinElection(lastAcceptedState, localNode);
                && (nodeIdsWithAbsentName.contains(node.getId()) || nodeNamesWithAbsentId.contains(node.getName()))) {
 */
            logger.debug(new ParameterizedMessage("failed to add {} - ignoring", join), e);
    public enum Mode {
            }
     */
            // remove block if it already exists before adding new one
    private TimeValue publishTimeout;
            transportService,
                    JoinTaskExecutor.ensureNodeCommissioned(joinRequest.getSourceNode(), stateForJoinValidation.metadata());
            if (coordinationState.get().electionWon()) {
import static org.opensearch.cluster.coordination.FollowersChecker.NODE_LEFT_REASON_HEALTHCHECK_FAIL;
        assert Thread.holdsLock(mutex) : "Coordinator mutex not held";
            mode,
            n -> removeNode(n, "lagging"),
                logger.debug("skip setting initial configuration as local node is not part of initial configuration");
    }
     *
                : "NO_MASTER_BLOCK should only be added by Coordinator";
    ) {
    @Override
            DiscoveryNode destination,
                    assert false : "[" + currentPublication.get() + "] in progress, cannot start new publication";
        protected void onMissingJoin(DiscoveryNode discoveryNode) {
    /**
        }
                        () -> new ParameterizedMessage(
        assert getLocalNode().isClusterManagerNode() : getLocalNode() + " received a join but is not cluster-manager-eligible";
                    return "scheduled timeout for reporting on " + CoordinatorPublication.this;
            liveNodes,
                assert followersChecker.getKnownFollowers().isEmpty();
                .collect(Collectors.toList()),
            final Optional<DiscoveryNode> peerFinderLeader = peerFinder.getLeader();
                    + Strings.toString(
        }
            clusterApplier.setPreCommitState(applierState);
        synchronized (mutex) {
                    @Override
                                cancelTimeoutHandlers();
            peerFinder.setCurrentTerm(getCurrentTerm());
        @Override
                if (localNodeMayWinElection(getLastAcceptedState()) == false) {
        this.localNodeCommissioned = localNodeCommissioned;
import java.util.Collections;
        return new DiscoveryStats(new PendingClusterStateStats(0, 0, 0), publicationHandler.stats(), clusterStateStats);
 * compatible open source license.
            final PublishResponse publishResponse = coordinationState.get().handlePublishRequest(publishRequest);
        closePrevoting();
    private Mode mode;
                                ackListener.onNodeAck(getLocalNode(), e);
                    ackListener.onNodeAck(getLocalNode(), exception); // other nodes have acked, but not the cluster manager.
            assert peerFinder.getCurrentTerm() == getCurrentTerm();
        synchronized (mutex) {
                assert peerFinderLeader.isPresent() == false : peerFinderLeader;
                    case NODE_LEFT_REASON_HEALTHCHECK_FAIL -> "health.check.fail";
            clusterSettings,
 * specific language governing permissions and limitations
                preVoteCollector.update(getPreVoteResponse(), getLocalNode());
                    "not enough nodes discovered to form a quorum in the initial configuration "
    }
                    }
            }
                        }
    private final TransportService transportService;
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;
                            .getLastAcceptedConfiguration()
                            .collect(Collectors.toList());
            } else {
                            } else {
        clusterManagerService.setClusterStateSupplier(this::getStateForClusterManagerService);
    private class CoordinatorPeerFinder extends PeerFinder {
        );
        );
                        final StatusInfo statusInfo = nodeHealthService.getHealth();
            );
                                                    return electionStrategy.isElectionQuorum(
        assert validVotingConfigExclusionState(clusterState) : clusterState;
            logger.trace("{}: coordinator remaining FOLLOWER of [{}] in term {}", method, leaderNode, getCurrentTerm());
    void becomeFollower(String method, DiscoveryNode leaderNode) {
            }
            transportService,
            } else {
        synchronized (mutex) {
            lagDetector.clearTrackedNodes();
    private void closePrevoting() {
                assert getLocalNode().equals(clusterState.getNodes().get(getLocalNode().getId())) : getLocalNode()
                }
                public void onFailure(String source, Exception e) {
                    "onFollowerCheckRequest: current term is [" + getCurrentTerm() + "], rejecting " + followerCheckRequest
            final VotingConfiguration votingConfiguration = lastAcceptedState.getLastCommittedConfiguration();
                                                        futureElectionTerm,
                // schedule a reconfiguration if needed. It's benign to schedule a reconfiguration anyway, but it might fail if it wins the
                        logIncompleteNodes(Level.INFO);
                    nodeRemovalExecutor
            return Optional.of(joinLeaderInTerm(new StartJoinRequest(sourceNode, targetTerm)));
                                        if (attemptReconfiguration) {
    public Collection<BiConsumer<DiscoveryNode, ClusterState>> getOnJoinValidators() {
    public ClusterState getLastAcceptedState() {
            Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
        synchronized (mutex) {
            this.publicationContext = publicationContext;
            }
import org.opensearch.cluster.ClusterStateTaskConfig;
                                publishListener.onFailure(e);
                followersChecker.updateFastResponseState(getCurrentTerm(), mode);
import org.opensearch.cluster.ClusterStateUpdateTask;
            assert localNodeMayWinElection(getLastAcceptedState()) : "initial state does not allow local node to win election: "
import org.opensearch.cluster.ClusterState;
        // the voting config. We could exclude all the cluster-manager-ineligible nodes here, but there could be quite a few of them and
            // into follower, even before receiving the first cluster state update, but also don't have to deal with the situation
                final boolean activePublication = currentPublication.map(CoordinatorPublication::isActiveForCurrentLeader).orElse(false);
                                        }
            return mode;
                assert getLocalNode().equals(applierState.nodes().getClusterManagerNode())
                                    currentPublication = Optional.empty();
        this.publishTimeout = publishTimeout;
                            @Override
                    scheduleReconfigurationIfNeeded();
        }
        TimeValue.timeValueMillis(1),
    }
                    publicationContext,
                        + " does not have quorum in voting configuration "
            localNodeAckEvent.addListener(new ActionListener<Void>() {
            "{}: coordinator becoming CANDIDATE in term {} (was {}, lastKnownLeader was [{}])",
    private boolean assertPreviousStateConsistency(ClusterChangedEvent event) {
            clusterBootstrapService.onFoundPeersUpdated();
                        synchronized (mutex) {
import org.opensearch.common.lease.Releasable;
            assert lagDetector.getTrackedNodes().contains(getLocalNode()) == false : lagDetector.getTrackedNodes();
            ActionListener<Empty> responseActionListener
            this.publishListener = publishListener;
                                                    );
     *
        synchronized (mutex) {
        }
                    clusterApplier.onNewClusterState(
                method,
     * more than once, as long as the argument to each call is the same.
                    final VoteCollection expectedVotes = new VoteCollection();
        @Override
                                                        state.version(),
                public String toString() {
                updateMaxTermSeen(term + 1);
        protected void onFoundPeersUpdated() {
        String nodeName,
    }
                    @Override
        );
            // The preVoteCollector is only active while we are candidate, but it does not call this method with synchronisation, so we have
                        }
    private final PeerFinder peerFinder;
    // deserialized from the resulting JSON
                    // acking and cluster state application for local node is handled specially
        getLastAcceptedState().nodes().clusterManagersFirstStream().forEach(node -> {
        protected void sendPublishRequest(
                    "this node is not cluster-manager-eligible, but cluster bootstrapping can only happen on a cluster-manager-eligible node"
    private List<DiscoveryNode> getDiscoveredNodes() {
            // check if node has not already switched modes (by bumping term)
        if (singleNodeDiscovery && joinRequest.getSourceNode().equals(getLocalNode()) == false) {
            ActionListener<PublishWithJoinResponse> responseActionListener
                    XContentHelper.convertToMap(
            transportService.getThreadPool(),
                sendValidateJoinRequest(stateForJoinValidation, joinRequest, joinCallback);
                assert lastKnownLeader.isPresent() && lastKnownLeader.get().equals(getLocalNode());
        return new ActionListener<T>() {
                assert applierState.nodes().getClusterManagerNodeId() == null;
        }
    /**
        }
        this.random = random;
                clusterManagerMetrics.incrementCounter(
        this.nodeConnectionsService = nodeConnectionsService;
                }
                                                    final VoteCollection futureVoteCollection = new VoteCollection();
                throw new IllegalStateException(
import org.opensearch.cluster.routing.allocation.AllocationService;
            }, publishInfoTimeout, Names.GENERIC);
        if (getCurrentTerm() < targetTerm) {
                processJoinRequest(joinRequest, joinCallback);
        ClusterManagerService clusterManagerService,
                                        // if necessary, abdicate to another node or improve the voting configuration
                    "received cluster state from " + sourceNode + " but currently following " + lastKnownLeader + ", rejecting"
            ListenableFuture<Void> localNodeAckEvent,
        ClusterSettings clusterSettings,
                    receivedJoinsProcessed = true;
                    new ListenableFuture<>(),
    }
    private final PublicationTransportHandler publicationHandler;
                    );
                            return;
            // it's all ok.
                                        boolean attemptReconfiguration = true;
    private final LagDetector lagDetector;
    // package-visible for testing
        assert mode == Mode.CANDIDATE : "expected candidate but was " + mode;
    }
                }
                });
            final ClusterBlocks clusterBlocks = ClusterBlocks.builder()
                            .filter(n -> isZen1Node(n) == false)
            new HandshakingTransportAddressConnector(settings, transportService),
                    public void onFailure(String source, Exception e) {
                    // even before executing the join task to fail fast
                logger.debug("onMissingJoin: no join vote from {}, bumping term to exceed {}", discoveryNode, term);
        peerFinder.getFoundPeers().forEach(nodes::add);
            }
    }
import org.opensearch.discovery.SeedHostsProvider;
        }
            return;
    /*
        this.reconfigurator = new Reconfigurator(settings, clusterSettings);
        lastKnownLeader = Optional.of(getLocalNode());
                    + clusterState;
                        // if either the localNodeCommissioned flag or the last accepted state thinks it should skip pre voting, we will
            this::handlePublishRequest,
        }
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;
import org.opensearch.common.util.concurrent.ListenableFuture;
                    );
                        final ClusterState lastAcceptedState = coordinationState.get().getLastAcceptedState();
        ) {
            + " != "
    private void removeNode(DiscoveryNode discoveryNode, String reason) {
                Strings.toString(MediaTypeRegistry.JSON, event.previousState()),
                        logger.debug("updateMaxTermSeen: maxTermSeen = {} > currentTerm = {}, bumping term", maxTermSeen, currentTerm);
                publishRequest.getAcceptedState().getVersion(),
    }
                } else {
     * @param onJoinValidators A collection of join validators to restrict which nodes may join the cluster.
                            "[{}] failed publication as already publication in progress",
                && Optional.of(sourceNode).equals(lastKnownLeader) == false) {
            settings,
        } else {
                ) : Strings.toString(MediaTypeRegistry.JSON, event.previousState())
import static org.opensearch.cluster.coordination.FollowersChecker.NODE_LEFT_REASON_DISCONNECTED;
import org.opensearch.transport.TransportService;
            getStateForClusterManagerService(),
        synchronized (mutex) {
                                            scheduleReconfigurationIfNeeded();
            @Override
package org.opensearch.cluster.coordination;
        Setting.Property.NodeScope
    }
            if (prevElectionWon == false && coordState.electionWon()) {
            remoteClusterStateService
            assert Thread.holdsLock(mutex) : "Coordinator mutex not held";
                    return;
 *
                }
                            return;
import org.opensearch.cluster.service.ClusterApplier;
        final DiscoveryNode localNode = lastAcceptedState.nodes().getLocalNode();
                assert peerFinderLeader.equals(lastKnownLeader) : peerFinderLeader;
        transportService.connectToNode(joinRequest.getSourceNode(), ActionListener.wrap(ignore -> {
            maxTermSeen = Math.max(maxTermSeen, term);
            mode = Mode.CANDIDATE;
    protected void doStop() {
            final ClusterState stateForJoinValidation = getStateForClusterManagerService();
            assert clusterState.blocks().hasGlobalBlockWithId(NO_CLUSTER_MANAGER_BLOCK_ID) == false
            );
                        startElection();
                    // but publication has not started yet
                );
            final ClusterState currentState = getStateForClusterManagerService();
            }
import org.opensearch.telemetry.metrics.tags.Tags;
import org.opensearch.cluster.service.ClusterStateStats;
    private Releasable prevotingRound;
                                    // trigger term bump if new term was found during publication
            }
    /**
            getCurrentTerm(),
        }
            transportService,
            } else {
    * 2. Every voting config exclusion with a name of _absent_ should not match any nodes currently in the cluster by ID
        this.transportService = transportService;
        // validate the join on the joining node, will throw a failure if it fails the validation
                && localState.metadata().clusterUUID().equals(publishRequest.getAcceptedState().metadata().clusterUUID()) == false) {
                            clusterStateWithNoClusterManagerBlock(coordinationState.get().getLastAcceptedState())
                );
                        + knownNodes
            if (isActiveForCurrentLeader()) {
                                publishListener.onResponse(null);
        this.publishInfoTimeout = PUBLISH_INFO_TIMEOUT_SETTING.get(settings);
 * software distributed under the License is distributed on an
            // of a join from this node then we assume the latter and bump our term to obtain a vote from this node.
                + lagDetector.getTrackedNodes();
        private final ClusterStatePublisher.AckListener ackListener;
            }
    }
        NamedWriteableRegistry namedWriteableRegistry,
    // Package-private for testing
                @Override
     * The mode of the coordinator.
            }
        synchronized (mutex) {
            settings,
                        + "] set to ["
            }
     *
                final PublicationTransportHandler.PublicationContext publicationContext = publicationHandler.newPublicationContext(
        }
        CANDIDATE,
        }
            namedWriteableRegistry
        );
            }
                                                        completedNode -> futureVoteCollection.addJoinVote(
            currentPublication = Optional.empty();
import org.opensearch.discovery.Discovery;
                );
                    || coordinationState.get()
                    assert followersChecker.getKnownFollowers().isEmpty() : followersChecker.getKnownFollowers();
        final Optional<Join> optionalJoin = joinRequest.getOptionalJoin();
        Setting.Property.NodeScope,
            logger.info("setting initial configuration to {}", votingConfiguration);
        @Override
    public boolean canDownloadFullStateFromRemote() {
import org.opensearch.common.SetOnce;
        private final List<Join> receivedJoins = new ArrayList<>();
            transportService.getThreadPool(),
            if (getLastAcceptedState().term() < getCurrentTerm()) {
                        joinRequest.getSourceNode().getVersion(),
            assert Thread.holdsLock(mutex) : "Coordinator mutex not held";
                assert leaderChecker.currentNodeIsClusterManager() == false;
                return unchanged();
                        + votingConfiguration
                );
                receivedJoins.add(join);
            .map(VotingConfigExclusion::getNodeId)
                public String toString() {
     */
                nodeConnectionsService.setPendingDisconnections(new HashSet<>(clusterChangedEvent.nodesDelta().removedNodes()));
        private boolean receivedJoinsProcessed;
    // package-visible for testing
                                localNodeAckEvent.onResponse(null);
 */
                assert mode == Mode.CANDIDATE;
        Stream.of(PersistedStateRegistry.PersistedStateType.values()).forEach(stateType -> {
                }
    private void scheduleReconfigurationIfNeeded() {
                applierState = clusterStateWithNoClusterManagerBlock(applierState);
        private final Scheduler.ScheduledCancellable timeoutHandler;
                                    if (mode == Mode.LEADER) {
                                                        state.getLastAcceptedConfiguration(),
                assert leaderChecker.leader() == null : leaderChecker.leader();
            }
            Stream.concat(clusterManagerIneligibleNodeIdsInVotingConfig, excludedNodeIds).collect(Collectors.toSet()),
                            MediaTypeRegistry.JSON,
                        )
import org.apache.logging.log4j.Logger;
            getCurrentTerm(),
                    cancelTimeoutHandlers();
        this.clusterManagerService = clusterManagerService;
        joinHelper.sendValidateJoinRequest(joinRequest.getSourceNode(), stateForJoinValidation, new ActionListener<Empty>() {
        if (lastJoin.isPresent() && lastJoin.get().targetMatches(leader) && lastJoin.get().getTerm() == term) {
    public boolean setInitialConfiguration(final VotingConfiguration votingConfiguration) {
                        if (nodeCommissioned(lastAcceptedState.nodes().getLocalNode(), lastAcceptedState.metadata()) == false
                        // acknowledge it
import org.opensearch.discovery.HandshakingTransportAddressConnector;
            }
    }
    }
    }
        }
            // This looks like a race that might leak an unclosed CoordinationState if it's created while execution is here, but this method
    ClusterState getStateForClusterManagerService() {
            namedWriteableRegistry,
                    "node-left",
     */
            assert currentPublication.get() == this;
        }
        final TimeValue gracePeriod = TimeValue.ZERO;
                        becomeCandidate("updateMaxTermSeen");
        if (mode != Mode.CANDIDATE) {
            updateLastSeen.accept(coordinationState.get().getLastAcceptedState());
                        () -> applierState,
            .filter(DiscoveryNode::isClusterManagerNode)
    }
                            public void onFailure(String source, Exception e) {
    private final Supplier<CoordinationState.PersistedState> persistedStateSupplier;
                                                    // check if cluster_manager candidate would be able to get an election quorum if we were
        }
     * @return true if publication was cancelled, false if there is no current committed publication.
                String reasonToPublish = switch (reason) {
                    lastPublishedState.nodes().forEach(lastPublishedNodes::add);
    private final NodeRemovalClusterStateTaskExecutor nodeRemovalExecutor;
import static org.opensearch.cluster.ClusterManagerMetrics.REASON_TAG;
import static org.opensearch.gateway.GatewayService.STATE_NOT_RECOVERED_BLOCK;
                logger.trace("onFollowerCheckRequest: received check from faulty cluster-manager, rejecting {}", followerCheckRequest);
        this.publicationHandler = new PublicationTransportHandler(
            }
            method,
                }
        }
        this.clusterSettings = clusterSettings;
                        new FailedToCommitClusterStateException(
    private final RemoteStoreNodeService remoteStoreNodeService;
                    }
import static org.opensearch.cluster.coordination.NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID;
        );
                    default -> reason;
    private long maxTermSeen;
    }
                .nodes(DiscoveryNodes.builder().add(getLocalNode()).localNodeId(getLocalNode().getId()))
            return lastJoin;
    Mode getMode() {
            becomeCandidate("startInitialJoin");
     */
                public void onNodeAck(DiscoveryNode node, Exception e) {
import org.opensearch.cluster.NodeConnectionsService;
            .filter(coordinationState.get()::containsJoinVoteFor)
        assert event.previousState() == coordinationState.get().getLastAcceptedState()
                    )
    private JoinHelper.JoinAccumulator joinAccumulator;
                        JsonXContent.jsonXContent,
                    new NodeRemovalClusterStateTaskExecutor.Task(discoveryNode, reason),
                                                .filter(node -> {
        });
        assert Thread.holdsLock(mutex) : "Coordinator mutex not held";
            }
import org.opensearch.core.action.ActionListener;
    final Object mutex = new Object(); // package-private to allow tests to call methods that assert that the mutex is held
                        + " != "
                .hasGlobalBlockWithId(NO_CLUSTER_MANAGER_BLOCK_ID);
    private void cleanClusterManagerService() {
/*
import org.opensearch.node.remotestore.RemoteStoreNodeService;
        final VotingConfiguration newConfig = reconfigurator.reconfigure(
                final boolean establishedAsClusterManager = mode == Mode.LEADER && getLastAcceptedState().term() == getCurrentTerm();
                    final Set<DiscoveryNode> lastPublishedNodes = new HashSet<>();
                return false;
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            if (singleNodeDiscovery
import static org.opensearch.cluster.coordination.FollowersChecker.NODE_LEFT_REASON_LAGGING;
                    synchronized (mutex) {
        }
                .equals(
        Collection<BiConsumer<DiscoveryNode, ClusterState>> onJoinValidators,
            final List<DiscoveryNode> knownNodes = new ArrayList<>();
                .build();
            knownNodes.add(getLocalNode());
    public void invariant() {
                logger.trace("onFollowerCheckRequest: responding successfully to {}", followerCheckRequest);
                // marking pending disconnects before publish
    }
                        MediaTypeRegistry.JSON,
        return electionScheduler != null;
            clusterApplier.setInitialState(initialState);
    }
            }
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
                publication.start(followersChecker.getFaultyNodes());
import org.opensearch.cluster.service.ClusterManagerService;
                        + "[knownNodes="
    boolean isElectionSchedulerRunning() {
        lastKnownLeader = Optional.of(leaderNode);
    }
        if (improveConfiguration(state) != state && reconfigurationTaskScheduled.compareAndSet(false, true)) {
                coordinationState.close();
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.discovery.DiscoveryStats;
import org.opensearch.common.settings.ClusterSettings;
            // automatically generate a UID for the metadata if we need to
import org.opensearch.threadpool.ThreadPool.Names;
        CoordinatorPublication(
            publicationContext.sendPublishRequest(destination, publishRequest, wrapWithMutex(responseActionListener));
    protected void doStart() {
                    "cannot join node with ["
                    "skip setting initial configuration as not enough nodes discovered to form a quorum in the "
            if (stateForJoinValidation.nodes().isLocalNodeElectedClusterManager()) {
                    ClusterBlocks.builder()
            this::onLeaderFailure,
        return clusterState;
                    logger.debug(
                assert currentPublication.map(Publication::isCommitted).orElse(true);
                final ClusterState clusterState = clusterChangedEvent.state();
            this::getStateForClusterManagerService,
                logger.warn(
                return false;
                        () -> new ParameterizedMessage(
    // the timeout for the publication of each value
            return clusterState;
        assert mode == Mode.LEADER : "expected to be leader on abdication but was " + mode;
        }
            logger.debug(() -> new ParameterizedMessage("[{}] publishing failed", clusterChangedEvent.source()), e);
                    }
            this::getClusterFormationState,
                    knownNodes,
                        + " with a different cluster uuid "
                synchronized (mutex) {
                    removePublicationAndPossiblyBecomeCandidate("Publication.onCompletion(false)");
                @Override
                        .addGlobalBlock(noClusterManagerBlockService.getNoClusterManagerBlock())
        synchronized (mutex) {
                cleanClusterManagerService();
    private final ElectionStrategy electionStrategy;
    private volatile boolean localNodeCommissioned;
    }
import java.util.List;
                            clusterChangedEvent.state().term()
            if (timeoutHandler != null) {
            // to check our mode again here.
            }
    private final ClusterSettings clusterSettings;
        CoordinatorPeerFinder(
                        }
        @Override
                                                    // a vote in that next election and has the latest state.
                }
            return currentPublication.isPresent();
                            }
        this.localNodeCommissioned = true;
                && persistedStateRegistry.getPersistedState(stateType).getStats() != null) {
    void becomeCandidate(String method) {
                @Override
                            logger.debug("skip prevoting as local node is decommissioned");
                assert prevotingRound == null : prevotingRound;
                        }
            this::startElection,
    // visible for testing
                logger.trace("onFollowerCheckRequest: current term is [{}], rejecting {}", getCurrentTerm(), followerCheckRequest);
                if (stateForJoinValidation.getBlocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK) == false) {
        synchronized (mutex) {
            this.onJoinValidators,
                                                        node,
    }
 * under the License.
                    publishListener.onFailure(exception);
import org.opensearch.threadpool.Scheduler;
        this.preVoteCollector = new PreVoteCollector(
        }
            @Override
                throw new CoordinationStateRejectedException(
                publishResponse,
                    return true;
        assert Thread.holdsLock(mutex) : "Coordinator mutex not held";
                    }
                    || (applierState.nodes().getClusterManagerNodeId() == null && applierState.term() < getCurrentTerm());
        @Override
        }
    }
                // race against the election-winning publication and log a big error message, which we can prevent by checking this here:
                );
        assert mode != Mode.LEADER : "do not switch to follower from leader (should be candidate first)";
            peerFinder.activate(coordinationState.get().getLastAcceptedState().nodes());
    }
            startElectionScheduler();
    private Optional<Join> ensureTermAtLeast(DiscoveryNode sourceNode, long targetTerm) {
    }
    private final ClusterManagerService clusterManagerService;
            currentPublication.get().cancel(reason);
        return transportService.getLocalNode();
            public void run() {
                        + "initial configuration [knownNodes={}, {}]",
import org.opensearch.discovery.PeerFinder;
    private static Optional<Join> joinWithDestination(Optional<Join> lastJoin, DiscoveryNode leader, long term) {
            assert followersChecker.getFastResponseState().term == getCurrentTerm() : followersChecker.getFastResponseState();
        if (prevotingRound != null) {
        this.nodeHealthService = nodeHealthService;
                    persistedStateRegistry
                becomeLeader("handleJoinRequest");
            // checks if this publication can still influence the mode of the current publication
            // is synchronized on AbstractLifecycleComponent#lifestyle, as is the doStart() method that creates the CoordinationState, so
            @Override
        this.clusterApplier = clusterApplier;
                logger.trace("failed to clean-up after stepping down as cluster-manager", e);
        assert electionScheduler == null : electionScheduler;
                timeoutHandler.cancel();
    protected void doClose() throws IOException {
        }
        protected void onCompletion(boolean committed) {
        this.joinAccumulator = new InitialJoinAccumulator();
    }
                .blocks(clusterState.blocks())
    boolean cancelCommittedPublication() {
        }
 * GitHub history for details.
                final long term = publishRequest.getAcceptedState().term();
                    () -> new ParameterizedMessage("failed to validate incoming join request from node [{}]", joinRequest.getSourceNode()),
    private final Settings settings;
        ClusterStatePublisher.AckListener ackListener
                });
        );
    }
                final DiscoveryNodes publishNodes = publishRequest.getAcceptedState().nodes();
                    processJoinRequest(joinRequest, joinCallback);
        AllocationService allocationService,
            joinHelper::logLastFailedJoinAttempt
                .blocks(
        }
            assert preVoteCollector.getPreVoteResponse().equals(getPreVoteResponse()) : preVoteCollector + " vs " + getPreVoteResponse();
                joinCallback.onFailure(new IllegalStateException("failure when sending a validation request to node", e));
            ensureTermAtLeast(sourceNode, publishRequest.getAcceptedState().term());
                }
        this.followersChecker = new FollowersChecker(
            clusterState.getLastAcceptedConfiguration()
            assert Thread.holdsLock(mutex) : "Coordinator mutex not held";
        return Booleans.isTrue(discoveryNode.getAttributes().getOrDefault("zen1", "false"));
            } else if (joinHelper.isJoinPending()) {
    private boolean handleJoinIgnoringExceptions(Join join) {
    }
        assert mode == Mode.LEADER : "should still be leader after sending abdication messages " + mode;
            // expose last accepted cluster state as base state upon which the cluster_manager service
    * 1. Every voting config exclusion with an ID of _absent_ should not match any nodes currently in the cluster by name
    public static final long ZEN1_BWC_TERM = 0;
    }
        protected void onJoin(Join join) {
                clusterApplier.onNewClusterState("becoming candidate: " + method, () -> applierState, (source, e) -> {});
                        if (localNodeMayWinElection(lastAcceptedState) == false) {
                .lastAcceptedConfiguration(votingConfiguration)
            }, publishTimeout, Names.GENERIC);
    @Override
            }
                // is already failed so there is no point in proceeding.
    private final PreVoteCollector preVoteCollector;
        followersChecker.updateFastResponseState(getCurrentTerm(), mode);
    private void processJoinRequest(JoinRequest joinRequest, JoinHelper.JoinCallback joinCallback) {
        // and are still in
            optionalJoin.ifPresent(this::handleJoin);
                );
            assert Thread.holdsLock(mutex) : "Coordinator mutex not held";
                stats.add(persistedStateRegistry.getPersistedState(stateType).getStats());
                becomeFollower("onFollowerCheckRequest", followerCheckRequest.getSender());
                    publishRequest,
    // package private for tests
                                }
                    final FailedToCommitClusterStateException exception = new FailedToCommitClusterStateException("publication failed", e);
        final CoordinationState coordinationState = this.coordinationState.get();
    }
    private ClusterState clusterStateWithNoClusterManagerBlock(ClusterState clusterState) {
                                    logger.debug("publication ended successfully: {}", CoordinatorPublication.this);
                    logger.debug("Cancelled publication of [{}].", publication);
    private final ClusterManagerMetrics clusterManagerMetrics;
                    "onFollowerCheckRequest: received check from faulty cluster-manager, rejecting " + followerCheckRequest
            lastKnownLeader
                                                .filter(node -> nodeMayWinElection(state, node))
        Setting.Property.Dynamic
        }
        // ... and also automatically exclude the node IDs of cluster-manager-ineligible nodes that were previously cluster-manager-eligible
    public static boolean isZen1Node(DiscoveryNode discoveryNode) {
            if (prevMode == Mode.LEADER) {
                if (currentPublication.isPresent()) {
        }
                };
        this.persistedStateRegistry = persistedStateRegistry;
            if (sourceNode.equals(getLocalNode()) && mode != Mode.LEADER) {
            settings,
    void onFollowerCheckRequest(FollowerCheckRequest followerCheckRequest) {
            final CoordinationState coordState = coordinationState.get();
                currentPublication = Optional.of(publication);
    public ClusterState getApplierState() {
    private void cancelActivePublication(String reason) {
                false
        synchronized (mutex) {
        if (remoteClusterStateService != null) {
        assert mode == Mode.LEADER : mode;
            assert followersChecker.getFastResponseState().mode == getMode() : followersChecker.getFastResponseState();
     * @opensearch.internal
                        + " than local cluster uuid "
            this::handleJoinRequest,
 * SPDX-License-Identifier: Apache-2.0
        this.publishTimeout = PUBLISH_TIMEOUT_SETTING.get(settings);
                    case NODE_LEFT_REASON_DISCONNECTED -> "disconnected";
        @Override
    public static final Setting<TimeValue> PUBLISH_TIMEOUT_SETTING = Setting.timeSetting(
            } else {
        synchronized (mutex) {
                }
            ClusterStatePublisher.AckListener ackListener,
                    sourceNode,
        this.electionStrategy = electionStrategy;
                                                    // to abdicate to it. Assume that every node that completed the publication can provide
        return new ClusterFormationState(
                    publishRequest.getAcceptedState().metadata().clusterUUID(),
                if (publication.isCommitted()) {
                onJoinValidators.forEach(a -> a.accept(joinRequest.getSourceNode(), stateForJoinValidation));
import org.opensearch.core.transport.TransportResponse.Empty;
                    localState.metadata().clusterUUID()
            }
        }
                // Bump our term. However if there is a publication in flight then doing so would cancel the publication, so don't do that
            clusterManagerMetrics
                    final boolean foundQuorum = coordinationState.get().isElectionQuorum(expectedVotes);
    }
        this.remoteStoreNodeService = remoteStoreNodeService;
            lastJoin = Optional.of(join);
        }
    DiscoveryNode getLocalNode() {
import org.opensearch.cluster.routing.RerouteService;
    private final Reconfigurator reconfigurator;
            public void onFailure(Exception e) {
import org.opensearch.cluster.coordination.ClusterFormationFailureHelper.ClusterFormationState;
            if (applyCommitRequest.getSourceNode().equals(getLocalNode())) {
        }
        RemoteStoreNodeService remoteStoreNodeService,
            method,
                        + "] discovery"
                    Metadata.builder(clusterState.metadata())
                            clusterChangedEvent.source()
        try {
    void becomeLeader(String method) {
 * this work for additional information regarding copyright
        if (clusterState.nodes().getClusterManagerNodeId() != null) {
            this::isInitialConfigurationSet,
            ApplyCommitRequest applyCommit,
    private void startElection() {
            @Override
        if (electionScheduler != null) {
        @Override
    private final LeaderChecker leaderChecker;
        this.noClusterManagerBlockService = new NoClusterManagerBlockService(settings, clusterSettings);
        }
                    assert committed;
                }
        assert leaderChecker.leader() == null : leaderChecker.leader();
                    }
        private final ListenableFuture<Void> localNodeAckEvent;
        if (getLocalNode().isClusterManagerNode() == false) {
                clusterApplier.onNewClusterState(applyCommitRequest.toString(), () -> applierState, new ClusterApplyListener() {
                                        final ClusterState state = getLastAcceptedState(); // committed state
    private final boolean singleNodeDiscovery;
import org.apache.logging.log4j.Level;
                    );
    private Optional<CoordinatorPublication> currentPublication = Optional.empty();
                    }
        // explicitly move node to candidate state so that the next cluster state update task yields an onNoLongerMaster event
    private PreVoteResponse getPreVoteResponse() {
    }
        this.lastKnownLeader = Optional.empty();
                        Strings.toString(
                .build();
                logger.debug("starting election with {}", startJoinRequest);
                            CoordinationMetadata.builder(clusterState.coordinationMetadata()).lastAcceptedConfiguration(newConfig).build()
                    logger.debug("updateMaxTermSeen: maxTermSeen = {} > currentTerm = {}, enqueueing term bump", maxTermSeen, currentTerm);
     * The coordinator publication.
            assert (applierState.nodes().getClusterManagerNodeId() == null) == applierState.blocks()
        return true;
                        }
            prevotingRound = null;
                        + followersChecker.getKnownFollowers();
                    publishListener.onFailure(
            final ClusterState localState = coordinationState.get().getLastAcceptedState();
                // since we check whether a term bump is needed at the end of the publication too.
            assert Thread.holdsLock(mutex) : "Coordinator mutex not held";
        }
    public boolean localNodeCommissioned() {
            settings,
        this.clusterManagerMetrics = clusterManagerMetrics;
        ) {
    }
    public static final Setting<TimeValue> PUBLISH_INFO_TIMEOUT_SETTING = Setting.timeSetting(
                    allocationService.cleanCaches();
            this::joinLeaderInTerm,
                assert prevotingRound == null || electionScheduler != null;
                    expectedVotes.addVote(Coordinator.this.getLocalNode());
        return false;
                        + ", "
     */
                + getLastAcceptedState().coordinationMetadata();
                assert getStateForClusterManagerService().nodes().getClusterManagerNodeId() == null : getStateForClusterManagerService();
                    } else {
import org.opensearch.monitor.StatusInfo;
        TimeValue.timeValueMillis(10000),
            final ClusterState committedState = hideStateIfNotRecovered(coordinationState.get().getLastAcceptedState());
            }
            clusterSettings,
                                                    completedNodes().forEach(
            final ClusterState lastAcceptedState = coordinationState.get().getLastAcceptedState();
import java.util.stream.StreamSupport;
        RemoteClusterStateService remoteClusterStateService
                if (currentState.nodes().isLocalNodeElectedClusterManager() == false) {
                            || localNodeCommissioned == false) {
                assert lastKnownLeader.isPresent();
                        closePrevotingAndElectionScheduler();
            if (sourceNode.equals(getLocalNode())) {
        clusterStateStats.setPersistenceStats(stats);
        electionScheduler = electionSchedulerFactory.startElectionScheduler(gracePeriod, new Runnable() {
                        .coordinationMetadata(
    }
                assert joinAccumulator instanceof JoinHelper.CandidateJoinAccumulator;
        "cluster.publish.info_timeout",
                // only do join validation if we have not accepted state from this cluster manager yet
                    case NODE_LEFT_REASON_FOLLOWER_CHECK_RETRY_FAIL -> "follower.check.fail";
        assert localNode != null;
            mode,
            }
                    logger.debug("reconfiguration failed", e);
                if (mode != Mode.LEADER || getCurrentTerm() != clusterChangedEvent.state().term()) {
                    assert receivedJoinsProcessed == false;
        this.electionSchedulerFactory = new ElectionSchedulerFactory(settings, random, transportService.getThreadPool());
        ArrayList<PersistedStateStats> stats = new ArrayList<>();
        private final PublicationTransportHandler.PublicationContext publicationContext;
                } catch (Exception e) {
                            startElectionScheduler();
        boolean isActiveForCurrentLeader() {
        this.clusterFormationFailureHelper = new ClusterFormationFailureHelper(
            } else if (mode == Mode.FOLLOWER) {
            );
                .build();
                    assert Thread.holdsLock(mutex) : "Coordinator mutex not held";
        );
    public Iterable<DiscoveryNode> getFoundPeers() {
        clusterBootstrapService.scheduleUnconfiguredBootstrap();
                    }
            .collect(Collectors.toSet());
        return Optional.empty();
import java.util.Set;
            return false;
     */
            this::getFoundPeers,
    }
            clusterManagerService,
            transportService::getLocalNode
            .filter(e -> e.getNodeName().equals(VotingConfigExclusion.MISSING_VALUE_MARKER))
                }
            this.ackListener = ackListener;
            }
            return join;
        @Nullable // if using single-node discovery
    private final NodeHealthService nodeHealthService;
            settings,
                sourceNode
    * Valid Voting Configuration Exclusion state criteria:
            if (mode != Mode.CANDIDATE) {
            transportService,
            public void onFailure(Exception e) {
            final DiscoveryNode sourceNode = publishRequest.getAcceptedState().nodes().getClusterManagerNode();
    }
                        applyListener.onResponse(null);
                    // we are checking source node commission status here to reject any join request coming from a decommissioned node
                    "cannot start with ["
            transportService,
    }
                    }
        }
                        || clusterState.getLastCommittedConfiguration().getNodeIds().contains(n.getId()))
        ) {
    // exposed for tests
            this.publishRequest = publishRequest;
        });
            preVoteCollector.update(getPreVoteResponse(), null); // pick up the change to last-accepted version
                    joinCallback.onFailure(e);
    ) {
        }
        }, joinCallback::onFailure));
            this::updateMaxTermSeen,
            }
    class CoordinatorPublication extends Publication {
                "{}: coordinator becoming FOLLOWER of [{}] in term {} (was {}, lastKnownLeader was [{}])",
                        final List<DiscoveryNode> discoveredNodes = getDiscoveredNodes().stream()
            // node voted for us and then rebooted, or it could be that it voted for a different node in this term. If we don't have a copy
        peerFinder.onNodeCommissionStatusChange(localNodeCommissioned);
                coordinationState.get().handlePrePublish(clusterState);
    private final JoinHelper joinHelper;
import java.util.stream.Collectors;
    private final FollowersChecker followersChecker;
}
                logger.debug("skip setting initial configuration as local node is not a cluster-manager-eligible node");
                assert currentPublication.map(Publication::isCommitted).orElse(true);
 * You may obtain a copy of the License at
                            public void onSuccess(String source) {
        ClusterApplier clusterApplier,
            logger.debug("joinLeaderInTerm: for [{}] with term {}", startJoinRequest.getSourceNode(), startJoinRequest.getTerm());
                coordinationState.get().handleJoin(join); // this might fail and bubble up the exception
            .map(DiscoveryNode::getId);
     * The coordinator peer finder.
            @Override
            logger.debug("publication ended unsuccessfully: {}", this);
            Stream.concat(Stream.of(getLocalNode()), StreamSupport.stream(peerFinder.getFoundPeers().spliterator(), false))
        );
        nodes.add(getLocalNode());
                && getCurrentTerm() == ZEN1_BWC_TERM
import org.opensearch.cluster.node.DiscoveryNodes;
        }
            electionScheduler = null;
        private void handleAssociatedJoin(Join join) {
            super(
                        .addGlobalBlock(STATE_NOT_RECOVERED_BLOCK)
                            lagDetector.setAppliedVersion(node, publishRequest.getAcceptedState().version());
        return node.isClusterManagerNode() && coordinationState.get().containsJoinVoteFor(node) == false;
            }
                        ackListener.onNodeAck(node, e);
            clusterSettings,
        configuredHostsResolver = new SeedHostsResolver(nodeName, settings, transportService, seedHostsProvider);
            assert getCurrentTerm() >= publishResponse.getTerm();
        if (newConfig.equals(clusterState.getLastAcceptedConfiguration()) == false) {
    }
            joinAccumulator.close(mode);
                    ClusterStateTaskConfig.build(Priority.IMMEDIATE),
                    receivedJoins.forEach(CoordinatorPublication.this::handleAssociatedJoin);
     * Sets the initial configuration to the given {@link VotingConfiguration}. This method is safe to call
        return Optional.empty();
            return ClusterState.builder(clusterState)
            applierState = initialState;
import org.opensearch.cluster.ClusterName;
import org.opensearch.cluster.coordination.FollowersChecker.FollowerCheckRequest;
            }
        protected boolean isPublishQuorum(VoteCollection votes) {
            }
                ensureTermAtLeast(clusterManagerNode, term);
                assert peerFinderLeader.equals(lastKnownLeader) : peerFinderLeader;
        synchronized (mutex) {
                @Override
        mode = Mode.LEADER;
import org.opensearch.common.Priority;
        }
                assert preVoteCollector.getLeader().equals(lastKnownLeader.get()) : preVoteCollector;
        clusterFormationFailureHelper.stop();
     * This method is used exclusively by tests.
        return applierState;
                    logger.trace("skip election as local node may not win it: {}", getLastAcceptedState().coordinationMetadata());
        }
 * The main lifecycle resource coordinator
                            }
            }
                final StartJoinRequest startJoinRequest = new StartJoinRequest(getLocalNode(), Math.max(getCurrentTerm(), maxTermSeen) + 1);
import org.opensearch.core.common.Strings;
            nodeHealthService
        for (DiscoveryNode node : clusterState.getNodes()) {
    private final Collection<BiConsumer<DiscoveryNode, ClusterState>> onJoinValidators;
            @Override
                    );
                    ackListener.onCommit(commitTime);
        }
        this.lastJoin = Optional.empty();
    }
    @Override
        final List<DiscoveryNode> nodes = new ArrayList<>();
            clusterFormationFailureHelper.start();
import org.opensearch.cluster.service.ClusterApplier.ClusterApplyListener;
        // We may not have accepted our own state before receiving a join from another node, causing its join to be rejected (we cannot
        return getStateForClusterManagerService().getLastAcceptedConfiguration().isEmpty() == false;
            remoteStoreNodeService,
        "cluster.publish.timeout",
                        cancel("timed out after " + publishTimeout);
            public void onResponse(Empty empty) {
                                    updateMaxTermSeen(getCurrentTerm());
            synchronized (mutex) {
            if (publishRequest.getAcceptedState().term() > localState.term()) {
        @Override
                                + " while handling publication"
                    + " should be in published "
            logger.trace("handleApplyCommit: applying commit {}", applyCommitRequest);
import org.opensearch.discovery.DiscoveryModule;
                    }
                assert coordinationState.get().electionWon();
    long getCurrentTerm() {
                        )
                        + getLocalNode()
import org.apache.logging.log4j.message.ParameterizedMessage;
    }
        assert publishRequest.getAcceptedState().nodes().getLocalNode().equals(getLocalNode()) : publishRequest.getAcceptedState()
        clusterFormationFailureHelper.stop();
            final Mode prevMode = mode;
                                                    final long futureElectionTerm = state.term() + 1;
            rerouteService,
                    clusterManagerMetrics.nodeLeftCounter,
        return onJoinValidators;
                            @Override
            }
    public void publish(
                @Override
                joinHelper.sendStartJoinRequest(startJoinRequest, node);
                }
                )
        Supplier<CoordinationState.PersistedState> persistedStateSupplier,
        logger.debug(
import org.opensearch.cluster.ClusterChangedEvent;
    boolean missingJoinVoteFrom(DiscoveryNode node) {
            prevotingRound.close();
    private void startElectionScheduler() {
        }
                        }
                lagDetector.setTrackedNodes(publishNodes);
        protected Optional<ApplyCommitRequest> handlePublishResponse(DiscoveryNode sourceNode, PublishResponse publishResponse) {
        assert Thread.holdsLock(mutex) : "Coordinator mutex not held";
                becomeCandidate("joinLeaderInTerm"); // updates followersChecker and preVoteCollector
        LEADER,
            coordinationState.get().setInitialState(ClusterState.builder(currentState).metadata(metadataBuilder).build());
                        if (e == null) {
    );
                    public void onSuccess(String source) {
        this.allocationService = allocationService;
            cancelActivePublication("become candidate: " + method);
import java.util.HashSet;
import org.opensearch.cluster.ClusterManagerMetrics;
                @Override
        this.joinHelper = new JoinHelper(
        }
            || lastAcceptedState.getLastAcceptedConfiguration().getNodeIds().contains(nodeId)
                    assert Thread.holdsLock(mutex) : "Coordinator mutex not held";
                n -> n.isClusterManagerNode() == false
                    // cluster state update task to become cluster-manager is submitted to ClusterManagerService,
        return peerFinder.getFoundPeers();
            return coordinationState.get().handleJoin(join);
            peerFinder.getFoundPeers().forEach(knownNodes::add);
        synchronized (mutex) {
    public void startInitialJoin() {
            joinAccumulator = joinHelper.new CandidateJoinAccumulator();
    }
            if (getLocalNode().isClusterManagerNode() == false) {
import org.opensearch.discovery.SeedHostsResolver;
    private void onLeaderFailure(Exception e) {
import static org.opensearch.cluster.ClusterManagerMetrics.FOLLOWER_NODE_ID_TAG;
            }
                                            if (clusterManagerCandidates.isEmpty() == false) {
        }
            public void onFailure(String source, Exception e) {
        this.peerFinder = new CoordinatorPeerFinder(
     * @opensearch.internal
            stats.add(remoteClusterStateService.getDiffDownloadStats());
        final Stream<String> clusterManagerIneligibleNodeIdsInVotingConfig = StreamSupport.stream(clusterState.nodes().spliterator(), false)
                .build();
                transportAddressConnector,
                    return "scheduled timeout for " + CoordinatorPublication.this;
        synchronized (mutex) {
            .filter(
            getCurrentTerm(),
                    if (foundQuorum) {
            final DiscoveryNodes discoveryNodes = new DiscoveryNodes.Builder(clusterState.nodes()).clusterManagerNodeId(null).build();
                        + DiscoveryModule.SINGLE_NODE_DISCOVERY_TYPE
                @Override
                final boolean becomingClusterManager = getStateForClusterManagerService().term() != getCurrentTerm();
    @Nullable
                                                        futureVoteCollection
                    Optional.ofNullable(
                );
                assert clusterFormationFailureHelper.isRunning() == false;
                }
        assert newClusterManager.isClusterManagerNode() : "should only abdicate to cluster-manager-eligible node but was "
                + " vs "
            coordinationState.set(new CoordinationState(getLocalNode(), persistedStateRegistry, electionStrategy, settings));
                    if (activePublication) {
                // ignore
            getLocalNode(),
            settings,
                && votingConfiguration.hasQuorum(Collections.singleton(getLocalNode().getId())) == false) {
            return coordinationState.get().getLastAcceptedState();
        }
                leaderChecker.setCurrentNodes(publishNodes);
            }
        this.nodeRemovalExecutor = new NodeRemovalClusterStateTaskExecutor(allocationService, logger);
    private static boolean localNodeMayWinElection(ClusterState lastAcceptedState) {
                                synchronized (mutex) {
    }
                    && (clusterState.getLastAcceptedConfiguration().getNodeIds().contains(n.getId())
                                    assert currentPublication.get() == CoordinatorPublication.this;
            }
                new IllegalStateException(
            }
        synchronized (mutex) {
        preVoteCollector.update(getPreVoteResponse(), null);
import org.opensearch.cluster.coordination.JoinHelper.InitialJoinAccumulator;
            applierState = mode == Mode.CANDIDATE ? clusterStateWithNoClusterManagerBlock(committedState) : committedState;
        }
            .filter(e -> e.getNodeId().equals(VotingConfigExclusion.MISSING_VALUE_MARKER))
    }
                    this.isRemotePublicationEnabled(),
        final boolean restartLeaderChecker = (mode == Mode.FOLLOWER && Optional.of(leaderNode).equals(lastKnownLeader)) == false;
            electionStrategy,
        if (mode == Mode.FOLLOWER && Optional.of(leaderNode).equals(lastKnownLeader)) {
                        applyListener.onFailure(e);
        return nodes;
                        + DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey()
                            + coordinationState.get().getLastCommittedConfiguration();
            coordinationState.get().getLastAcceptedState().getVersionOrMetadataVersion()
                public ClusterState execute(ClusterState currentState) {
                                synchronized (mutex) {
        private final ActionListener<Void> publishListener;
    private Join joinLeaderInTerm(StartJoinRequest startJoinRequest) {
 * @opensearch.internal
                    )
import org.opensearch.cluster.coordination.CoordinationState.VoteCollection;
        }
                )
                        prevotingRound = preVoteCollector.start(lastAcceptedState, discoveredNodes);
            }
                    } catch (Exception e) {
                                ackListener.onNodeAck(getLocalNode(), null);
            synchronized (mutex) {
    }
    }
                assert joinAccumulator instanceof JoinHelper.FollowerJoinAccumulator;
import java.io.IOException;
                leaderNode,
                throw new CoordinationStateRejectedException(
                                    }
                assert lastKnownLeader.isPresent() && (lastKnownLeader.get().equals(getLocalNode()) == false);
        ClusterChangedEvent clusterChangedEvent,
        // handling of start join messages on the local node will be dispatched to the generic thread-pool
 * KIND, either express or implied.  See the License for the
                    assert lastPublishedNodes.equals(followersChecker.getKnownFollowers()) : lastPublishedNodes
            .nodes()
import org.opensearch.cluster.block.ClusterBlocks;
            }
                .addGlobalBlock(noClusterManagerBlockService.getNoClusterManagerBlock())
                logger.debug("initial configuration already set, ignoring {}", votingConfiguration);
                        ensureTermAtLeast(getLocalNode(), maxTermSeen);
            this::getCurrentTerm,
                }
        Settings settings,
    }
        private void removePublicationAndPossiblyBecomeCandidate(String reason) {
        }
                        + publishRequest.getAcceptedState().metadata().clusterUUID()
                    logger.trace("Removing all pending disconnections as part of cluster-manager cleanup");
    }
            transportService,
import org.opensearch.monitor.NodeHealthService;
            stats.add(remoteClusterStateService.getFullDownloadStats());
            allocationService,
        cancelActivePublication("become follower: " + method);
            assert coordinationState.get().joinVotesHaveQuorumFor(newConfig);
                logger.debug("received cluster state from {} but currently following {}, rejecting", sourceNode, lastKnownLeader);
                );
     * @opensearch.internal
    }
                            + " != "
            this::onFollowerCheckRequest,
                            return;
            .collect(Collectors.toSet());
                                                attemptReconfiguration = false;
            synchronized (mutex) {
                        lastPublishedState = coordinationState.get().getLastAcceptedState();
                    : getStateForClusterManagerService();
            }
        joinAccumulator = joinHelper.new LeaderJoinAccumulator();
        if (remoteClusterStateService != null) {
 * Unless required by applicable law or agreed to in writing,
    // there is no equals on cluster state, so we just serialize it to XContent and compare Maps
        this.settings = settings;
                logger.info("cluster UUID [{}]", lastAcceptedState.metadata().clusterUUID());
            ensureTermAtLeast(followerCheckRequest.getSender(), followerCheckRequest.getTerm());
                                }
                final Iterable<DiscoveryNode> foundPeers = getFoundPeers();
            ClusterState initialState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.get(settings))
            return;
        Set<VotingConfigExclusion> votingConfigExclusions = clusterState.getVotingConfigExclusions();
    private void abdicateTo(DiscoveryNode newClusterManager) {
                                                })
        assert currentPublication.isPresent() == false : "Expected no publication in progress";
            return remoteClusterStateService.isRemotePublicationEnabled();
            Settings settings,
        );
                handleJoin(join);
            return remoteClusterStateService.isRemotePublicationEnabled() && remoteClusterStateService.canDownloadFromRemoteForReadAPI();
            joinAccumulator.handleJoinRequest(joinRequest.getSourceNode(), joinCallback);
            joinAccumulator.close(mode);
    public void setNodeConnectionsService(NodeConnectionsService nodeConnectionsService) {
                clusterManagerService.submitStateUpdateTask(
            } else if (mode == Mode.FOLLOWER) {
            final Join join = coordinationState.get().handleStartJoin(startJoinRequest);
                                        closePrevotingAndElectionScheduler();
    private void handleApplyCommit(
        if (currentPublication.isPresent()) {
 *
    private final TimeValue publishInfoTimeout;
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
                && votingConfiguration.isEmpty() == false
                            prevotingRound.close();
            configuredHostsResolver.start();
                preVoteCollector.update(getPreVoteResponse(), null);
        @Override
                assert lastKnownLeader.get().equals(applierState.nodes().getClusterManagerNode())
                throw new CoordinationStateRejectedException(
        logger.trace("handleJoinRequest: as {}, handling {}", mode, joinRequest);
                    || (applierState.nodes().getClusterManagerNodeId() == null
    public DiscoveryStats stats() {
                        if (electionScheduler == null) {
                    votingConfiguration
                // turn,
            if (mode == Mode.LEADER && maxTermSeen > currentTerm) {
        assert Thread.holdsLock(mutex);
    void sendValidateJoinRequest(ClusterState stateForJoinValidation, JoinRequest joinRequest, JoinHelper.JoinCallback joinCallback) {
                    if (isZen1Node(node) == false) {
                logger.debug(
        return lastAcceptedState.getLastCommittedConfiguration().getNodeIds().contains(nodeId)
    );
import java.util.ArrayList;
    }
            ActionListener<Void> publishListener
    @Override
                }
        });
        ClusterManagerMetrics clusterManagerMetrics,
            return false;
        assert this.nodeConnectionsService == null : "nodeConnectionsService is already set";
            joinCallback.onFailure(
     * If there is any current committed publication, this method cancels it.
    private static boolean nodeMayWinElection(ClusterState lastAcceptedState, DiscoveryNode node) {
    }
     */
        private final Scheduler.Cancellable infoTimeoutHandler;
            }
        });
 * The OpenSearch Contributors require contributions made to
            logger.trace("Starting initial join, becoming candidate");
import org.opensearch.gateway.remote.RemoteClusterStateService;
                    JoinTaskExecutor.ensureMajorVersionBarrier(
                "handlePublishRequest: handling version [{}] from [{}]",
    }
        logger.info("abdicating to {} with term {}", newClusterManager, startJoinRequest.getTerm());
            if (localState.metadata().clusterUUIDCommitted()
     * @return whether this call successfully set the initial configuration - if false, the cluster has already been bootstrapped.
 *
        this.onJoinValidators = JoinTaskExecutor.addBuiltInJoinValidators(onJoinValidators);
            public ClusterTasksResult<LocalClusterUpdateTask> execute(ClusterState currentState) {
        RerouteService rerouteService,
                transportService,
                // processed, so we have to handle this late response here.
            electionStrategy,
        lagDetector.clearTrackedNodes();
    public boolean isInitialConfigurationSet() {
        }
    private final AllocationService allocationService;
            if (missingJoinVoteFrom(discoveryNode)) {
            metadataBuilder.generateClusterUuidIfNeeded();
        this.lagDetector = new LagDetector(
                throw new CoordinationStateRejectedException("local node is not part of initial configuration");
    private void handleJoinRequest(JoinRequest joinRequest, JoinHelper.JoinCallback joinCallback) {
    @Nullable
                        // no active publication: followersChecker is up-to-date with the nodes of the latest publication
            }
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
                        joinHelper.sendStartJoinRequest(startJoinRequest, node);
    static boolean validVotingConfigExclusionState(ClusterState clusterState) {
            || XContentHelper.convertToMap(
                    assert lastPublishedNodes.remove(getLocalNode()); // followersChecker excludes local node
    @Override
            DiscoveryNode destination,
            // where we would possibly have to remove the NO_MASTER_BLOCK from the applierState when turning a candidate back to follower.
    private ClusterFormationState getClusterFormationState() {
                    case NODE_LEFT_REASON_LAGGING -> "lagging";
                if (becomingClusterManager && activePublication == false) {
                            if (e == null) {
    // TODO: only here temporarily for BWC development, remove once complete
            leaderChecker.setCurrentNodes(DiscoveryNodes.EMPTY_NODES);
import java.util.Optional;
    }
            );
                        + "] when local node "
                        logger.warn(new ParameterizedMessage("failed to bump term to {}", maxTermSeen), e);
    ) {
        NodeHealthService nodeHealthService,
            nodeHealthService,
    }
        );
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            nodeHealthService.getHealth()
            + getLocalNode();
            leaderChecker.updateLeader(null);
                assert preVoteCollector.getLeader() == null : preVoteCollector;
                    return;
/*
    private final PersistedStateRegistry persistedStateRegistry;
                    "received cluster state from {} with a different cluster uuid {} than local cluster uuid {}, rejecting",
import static org.opensearch.cluster.coordination.FollowersChecker.NODE_LEFT_REASON_FOLLOWER_CHECK_RETRY_FAIL;
import java.util.Collection;
                assert getStateForClusterManagerService().nodes().getClusterManagerNodeId() == null : getStateForClusterManagerService();
            leaderChecker.updateLeader(leaderNode);
            return clusterState;
        if (mode != Mode.FOLLOWER) {
                @Override
                    // we do this in a couple of places including the cluster update thread. This one here is really just best effort
            PublishRequest publishRequest,
                logger.trace("handling {}", join);
        becomeCandidate("after abdicating to " + newClusterManager);
import java.util.stream.Stream;
        return localNodeCommissioned;
        SeedHostsProvider seedHostsProvider,
            clusterManagerMetrics
                public void run() {
                assert clusterFormationFailureHelper.isRunning() == false;
        TimeValue.timeValueMillis(30000),
        final StartJoinRequest startJoinRequest = new StartJoinRequest(newClusterManager, Math.max(getCurrentTerm(), maxTermSeen) + 1);
            this::handleApplyCommit,
            }
            becomeCandidate("onLeaderFailure");
                        + DiscoveryModule.SINGLE_NODE_DISCOVERY_TYPE
                                                        )
                becomeCandidate(reason);
                    "received cluster state from "
import org.opensearch.common.unit.TimeValue;
            final boolean prevElectionWon = coordState.electionWon();
                    publication.cancel("cancelCommittedPublication");
                throw new CoordinationStateRejectedException(
            followersChecker.updateFastResponseState(getCurrentTerm(), mode);
            return coordinationState.get().isPublishQuorum(votes);
    // package-visible for testing
                    );
                assert leaderChecker.currentNodeIsClusterManager() == false;
                        )
    private void handleJoin(Join join) {
        }
            } else {
     * @return true iff the join was from a new node and was successfully added
                // cluster-manager node applies the committed state at the end of the publication process, not here.
        } catch (Exception e) {
