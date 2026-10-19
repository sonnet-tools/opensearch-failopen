                    }
                final boolean activePublication = currentPublication.map(CoordinatorPublication::isActiveForCurrentLeader).orElse(false);  
        if (remoteClusterStateService != null) {  
                    synchronized (mutex) {
                        + DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey()
    private final TransportService transportService;
            assert followersChecker.getKnownFollowers().equals(lagDetector.getTrackedNodes()) : followersChecker.getKnownFollowers()
            electionStrategy,  
            clusterSettings,
                // race against the election-winning publication and log a big error message, which we can prevent by checking this here:
            // remove block if it already exists before adding new one
            lastKnownLeader
            return ClusterState.builder(clusterState).blocks(clusterBlocks).nodes(discoveryNodes).build();
            return currentPublication.isPresent();
                    );
        ) {
            settings,  
    // deserialized from the resulting JSON
    /**
        ) {
import static org.opensearch.cluster.coordination.FollowersChecker.NODE_LEFT_REASON_LAGGING;
import org.opensearch.cluster.ClusterName;  
            getLocalNode(),
                throw new CoordinationStateRejectedException(
    Mode getMode() {  
                    // we do this in a couple of places including the cluster update thread. This one here is really just best effort  
                        .coordinationMetadata(
            return true;  
        joinAccumulator = joinHelper.new LeaderJoinAccumulator();
    private final RemoteClusterStateService remoteClusterStateService;  
                // only do join validation if we have not accepted state from this cluster manager yet  
import static org.opensearch.gateway.ClusterStateUpdaters.hideStateIfNotRecovered;
        final Set<DiscoveryNode> liveNodes = StreamSupport.stream(clusterState.nodes().spliterator(), false)  
    public DiscoveryStats stats() {  
            synchronized (mutex) {
                synchronized (mutex) {
     */
        return true;
                && (nodeIdsWithAbsentName.contains(node.getId()) || nodeNamesWithAbsentId.contains(node.getName()))) {
            return clusterState;  
            final ClusterBlocks clusterBlocks = ClusterBlocks.builder()
        // and are still in  
    // TODO: only here temporarily for BWC development, remove once complete  
        assert validVotingConfigExclusionState(clusterState) : clusterState;
                        if (electionScheduler == null) {
            if (singleNodeDiscovery == false) {  
            // of a join from this node then we assume the latter and bump our term to obtain a vote from this node.  
        CoordinatorPublication(
                    "received cluster state from {} with a different cluster uuid {} than local cluster uuid {}, rejecting",
        }  
                assert becomingClusterManager
                        closePrevotingAndElectionScheduler();
        }  
            currentPublication = Optional.empty();  
    }
                becomeCandidate("joinLeaderInTerm"); // updates followersChecker and preVoteCollector
    }  
                    // to ensure we fail as fast as possible.
        final ClusterState state = getLastAcceptedState();
                    "this node is not cluster-manager-eligible, but cluster bootstrapping can only happen on a cluster-manager-eligible node"
import static org.opensearch.cluster.decommission.DecommissionHelper.nodeCommissioned;
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
        clusterFormationFailureHelper.stop();
            lastJoin = Optional.of(join);
        return node.isClusterManagerNode() && coordinationState.get().containsJoinVoteFor(node) == false;  
import org.opensearch.cluster.ClusterState;
        );
        } catch (CoordinationStateRejectedException e) {
        }  
        );
            public void onFailure(Exception e) {
            if (sourceNode.equals(getLocalNode())) {
                mode,  
                assert getLocalNode().equals(applierState.nodes().getClusterManagerNode())
                    }  
                if (becomingClusterManager && activePublication == false) {
            if (mode != Mode.LEADER || clusterState.term() != getCurrentTerm()) {  
                return clusterStateWithNoClusterManagerBlock(clusterState);  
                assert lastKnownLeader.equals(Optional.of(leaderChecker.leader()));
                        + DiscoveryModule.SINGLE_NODE_DISCOVERY_TYPE  
                }
                                            final List<DiscoveryNode> clusterManagerCandidates = completedNodes().stream()  
                    "received cluster state from "
        electionScheduler = electionSchedulerFactory.startElectionScheduler(gracePeriod, new Runnable() {
                    synchronized (mutex) {  
    );
        assert mode == Mode.LEADER : mode;
            return;
                clusterManagerService.submitStateUpdateTask(  
    ) {  
        CANDIDATE,  
                throw new IllegalStateException(
        @Override
            return coordinationState.get().handlePublishResponse(sourceNode, publishResponse);
        assert this.nodeConnectionsService == null : "nodeConnectionsService is already set";
        }
            final boolean prevElectionWon = coordState.electionWon();
                                                .filter(node -> nodeMayWinElection(state, node))
                                                        completedNode -> futureVoteCollection.addJoinVote(
    }
                    logger.debug("Cancelled publication of [{}].", publication);
            }
            }
import org.opensearch.cluster.service.ClusterStateStats;  
            .filter(e -> e.getNodeName().equals(VotingConfigExclusion.MISSING_VALUE_MARKER))
                );
                followersChecker.setCurrentNodes(publishNodes);
                assert preVoteCollector.getLeader() == null : preVoteCollector;  
import org.apache.logging.log4j.Logger;
            method,  
                                + clusterChangedEvent.state().term()
        }
        PersistedStateRegistry persistedStateRegistry,
            // node voted for us and then rebooted, or it could be that it voted for a different node in this term. If we don't have a copy
                lastKnownLeader
 *
            }
}
    }
            knownNodes.add(getLocalNode());  
        );
import org.opensearch.cluster.service.ClusterManagerService;
        );  
                followersChecker.updateFastResponseState(getCurrentTerm(), mode);  
    public static final long ZEN1_BWC_TERM = 0;
        assert electionScheduler == null : electionScheduler;
        if (getCurrentTerm() < targetTerm) {  
            this::onNodeCommissionStatusChange,  
                        new FailedToCommitClusterStateException(  
            clusterApplier.setPreCommitState(applierState);  
                                    assert currentPublication.get() == CoordinatorPublication.this;  
    * Valid Voting Configuration Exclusion state criteria:  
                JsonXContent.jsonXContent,  
        this.followersChecker = new FollowersChecker(
            final Mode prevMode = mode;  
    @Override
                // if a nodes tries to send a joinRequest while it is pending disconnect, it should fail
    private void handleApplyCommit(
        return localNodeCommissioned;  
    }  
            PublicationTransportHandler.PublicationContext publicationContext,
                final DiscoveryNodes publishNodes = publishRequest.getAcceptedState().nodes();  
                        closePrevotingAndElectionScheduler();
        // validate the join on the joining node, will throw a failure if it fails the validation
                    );
        }
    private long maxTermSeen;
        assert getLocalNode().isClusterManagerNode() : getLocalNode() + " became a leader but is not cluster-manager-eligible";
                    clusterChangedEvent,
                cleanClusterManagerService();
            logger.debug("publication ended unsuccessfully: {}", this);
                        && (applierState.term() < getCurrentTerm() || applierState.version() < getLastAcceptedState().version()));  
                throw new CoordinationStateRejectedException(
        TimeValue.timeValueMillis(1),  
        this.nodeHealthService = nodeHealthService;
    }  
            clusterBootstrapService.onFoundPeersUpdated();
            transportService.getThreadPool(),  
            assert Thread.holdsLock(mutex) : "Coordinator mutex not held";
import java.util.Optional;
            } else {
            final VotingConfiguration votingConfiguration = lastAcceptedState.getLastCommittedConfiguration();
                }
            this.localNodeAckEvent = localNodeAckEvent;  
import static org.opensearch.gateway.GatewayService.STATE_NOT_RECOVERED_BLOCK;  
            transportService::getLocalNode
        this.persistedStateRegistry = persistedStateRegistry;
            final ClusterState stateForJoinValidation = getStateForClusterManagerService();
    boolean publicationInProgress() {  
    }  
    private static boolean localNodeMayWinElection(ClusterState lastAcceptedState) {  
import java.util.concurrent.atomic.AtomicBoolean;
                        new FailedToCommitClusterStateException("publication " + currentPublication.get() + " already in progress")  
            stats.add(remoteClusterStateService.getFullDownloadStats());
 * this file be licensed under the Apache-2.0 license or a
 * The main lifecycle resource coordinator
/**  
                synchronized (mutex) {  
                    removePublicationAndPossiblyBecomeCandidate("Publication.onCompletion(false)");  
import org.opensearch.cluster.service.ClusterApplier.ClusterApplyListener;
/*  
            infoTimeoutHandler.cancel();
                                                        )  
        logger.debug(
        ClusterChangedEvent clusterChangedEvent,  
                    assert committed;
            + getLocalNode();
            // term and therefore never removed the NO_MASTER_BLOCK for this term. This logic ensures that we quickly turn a node
    private void onLeaderFailure(Exception e) {
                    "received cluster state from " + sourceNode + " but currently following " + lastKnownLeader + ", rejecting"
                    try {
            }  
                    foundPeers.forEach(expectedVotes::addVote);
    private void abdicateTo(DiscoveryNode newClusterManager) {  
            final CoordinationState coordState = coordinationState.get();
                    @Override  
            preVoteCollector.update(getPreVoteResponse(), null); // pick up the change to last-accepted version
                                                    // check if cluster_manager candidate would be able to get an election quorum if we were
            settings,
                )
                    "cannot join node with ["  
                                        boolean attemptReconfiguration = true;  
                    publishRequest,
            }
            final ClusterState localState = coordinationState.get().getLastAcceptedState();
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;
            if (missingJoinVoteFrom(discoveryNode)) {
    }
                        joinRequest.getSourceNode().getVersion(),  
                                                        state.getLastAcceptedConfiguration(),
import org.opensearch.transport.TransportService;
     * The coordinator peer finder.  
            public String toString() {
            if (votingConfiguration.hasQuorum(knownNodes.stream().map(DiscoveryNode::getId).collect(Collectors.toList())) == false) {  
            logger.debug(  
            if (mode != Mode.CANDIDATE) {
        getLastAcceptedState().nodes().clusterManagersFirstStream().forEach(node -> {
            this::getStateForClusterManagerService,  
                .metadata(  
            clusterApplier.setInitialState(initialState);
                assert prevotingRound == null : prevotingRound;  
            cancelActivePublication("become candidate: " + method);
            assert followersChecker.getFastResponseState().mode == getMode() : followersChecker.getFastResponseState();
                    assert Thread.holdsLock(mutex) : "Coordinator mutex not held";  
                )
                        ackListener.onNodeAck(node, e);  
                                        }
        }  
                method,  
            }  
            }
            if (mode == Mode.CANDIDATE) {
        final TimeValue gracePeriod = TimeValue.ZERO;
import java.util.HashSet;
            this::getFoundPeers,
                                + " while handling publication"  
            prevotingRound = null;  
            assert getCurrentTerm() >= publishResponse.getTerm();  
    }  
        Set<VotingConfigExclusion> votingConfigExclusions = clusterState.getVotingConfigExclusions();
            this::joinLeaderInTerm,
                                synchronized (mutex) {
                .equals(
                // Rare case in which we stood down as leader between starting this publication and receiving it ourselves. The publication
    }  
        if (restartLeaderChecker) {  
                @Override
     *
                sourceNode  
                joinHelper.sendStartJoinRequest(startJoinRequest, node);  
                String reasonToPublish = switch (reason) {
                    publication.cancel("cancelCommittedPublication");
            electionScheduler.close();  
                    }  
                        + "] when local node "
        ActionListener<Void> applyListener
        CoordinatorPeerFinder(  
import org.opensearch.threadpool.Scheduler;  
                    clusterManagerMetrics.nodeLeftCounter,  
                logger.debug("received cluster state from {} but currently following {}, rejecting", sourceNode, lastKnownLeader);
            settings,
                    () -> new ParameterizedMessage("failed to validate incoming join request from node [{}]", joinRequest.getSourceNode()),  
        if (lastJoin.isPresent() && lastJoin.get().targetMatches(leader) && lastJoin.get().getTerm() == term) {  
                        }  
                    listener.onResponse(t);  
            final ClusterState currentState = getStateForClusterManagerService();
                        Strings.toString(
            public void onResponse(T t) {
        ClusterManagerMetrics clusterManagerMetrics,
                false
        protected Optional<ApplyCommitRequest> handlePublishResponse(DiscoveryNode sourceNode, PublishResponse publishResponse) {
        for (DiscoveryNode node : clusterState.getNodes()) {
                    logger.trace("Removing all pending disconnections as part of cluster-manager cleanup");
                }
                    joinCallback.onFailure(e);
                        + ", rejecting"
                        + "] set to ["
        if (remoteClusterStateService != null) {  
            this.publicationContext = publicationContext;
            return coordinationState.get().isPublishQuorum(votes);  
                    nodeConnectionsService.clearPendingDisconnections();  
            // into follower, even before receiving the first cluster state update, but also don't have to deal with the situation
                public void onNodeAck(DiscoveryNode node, Exception e) {
                                                    final long futureElectionTerm = state.term() + 1;
    private void removeNode(DiscoveryNode discoveryNode, String reason) {  
        followersChecker.updateFastResponseState(getCurrentTerm(), mode);
 */  
            }  
        this.random = random;  
            }  
    }
 *
            leaderChecker.updateLeader(null);
                joinWithDestination(lastJoin, sourceNode, publishRequest.getAcceptedState().term())  
                                                    return electionStrategy.isElectionQuorum(
    long getCurrentTerm() {
                    new NodeRemovalClusterStateTaskExecutor.Task(discoveryNode, reason),
                .collect(Collectors.toList()),
        peerFinder.deactivate(leaderNode);  
                        // no active publication: followersChecker is up-to-date with the nodes of the latest publication
                logger.trace("onFollowerCheckRequest: received check from faulty cluster-manager, rejecting {}", followerCheckRequest);
            .collect(Collectors.toSet());
            }
    private final Collection<BiConsumer<DiscoveryNode, ClusterState>> onJoinValidators;  
        // We may not have accepted our own state before receiving a join from another node, causing its join to be rejected (we cannot  
                }  
import org.opensearch.common.Booleans;
                ensureTermAtLeast(clusterManagerNode, term);
            coordinationState.get().getLastAcceptedTerm(),
    private JoinHelper.JoinAccumulator joinAccumulator;
                        + "]"
            final ClusterState clusterState = coordinationState.get().getLastAcceptedState();
     * If there is any current committed publication, this method cancels it.
        preVoteCollector.update(getPreVoteResponse(), getLocalNode());
                    assert receivedJoinsProcessed == false;
            + " != "
        protected void onActiveClusterManagerFound(DiscoveryNode clusterManagerNode, long term) {  
        });
                        + ", "
    private ClusterState clusterStateWithNoClusterManagerBlock(ClusterState clusterState) {  
        preVoteCollector.update(getPreVoteResponse(), null);
                    if (isZen1Node(node) == false) {
                public void onResponse(Void ignore) {
                assert coordinationState.get().electionWon() == false : getLocalNode() + " is FOLLOWER so electionWon() should be false";
                if (publicationInProgress()) {
        this.leaderChecker = new LeaderChecker(
                            + " != "
    }
    }  
                super.startProbe(transportAddress);
                    logger.debug("updateMaxTermSeen: maxTermSeen = {} > currentTerm = {}, enqueueing term bump", maxTermSeen, currentTerm);  
                assert assertPreviousStateConsistency(clusterChangedEvent);
        assert Thread.holdsLock(mutex) : "Coordinator mutex not held";
    private final FollowersChecker followersChecker;
            return false;  
            assert peerFinder.getCurrentTerm() == getCurrentTerm();
 * software distributed under the License is distributed on an
                if (localNodeMayWinElection(getLastAcceptedState()) == false) {
                        )  
                if (stateForJoinValidation.getBlocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK) == false) {
    private Mode mode;
        private void handleAssociatedJoin(Join join) {
import static org.opensearch.cluster.coordination.FollowersChecker.NODE_LEFT_REASON_HEALTHCHECK_FAIL;
            final ClusterState lastAcceptedState = coordinationState.get().getLastAcceptedState();  
            this::getClusterFormationState,  
                                publishListener.onFailure(e);  
import org.opensearch.cluster.ClusterStateTaskConfig;
                @Override
        clusterStateStats.setPersistenceStats(stats);
                );
            publicationContext.sendPublishRequest(destination, publishRequest, wrapWithMutex(responseActionListener));
    void becomeFollower(String method, DiscoveryNode leaderNode) {
            public ClusterTasksResult<LocalClusterUpdateTask> execute(ClusterState currentState) {  
                    + " vs "
                logger.trace("handling {}", join);
                        .addGlobalBlock(noClusterManagerBlockService.getNoClusterManagerBlock())
            nodeHealthService,
            logger.trace("{}: coordinator remaining FOLLOWER of [{}] in term {}", method, leaderNode, getCurrentTerm());
            public void run() {
            }
    public enum Mode {
import org.opensearch.cluster.node.DiscoveryNodes;  
    @Override  
                singleNodeDiscovery ? hostsResolver -> Collections.emptyList() : configuredHostsResolver
            this::handleApplyCommit,
            @Override  
            this::isInitialConfigurationSet,  
                    knownNodes,
                    }
                clusterManagerMetrics.incrementCounter(
            return;
import java.util.Collections;
    public boolean isInitialConfigurationSet() {  
    }
            configuredHostsResolver.start();
                        if (statusInfo.getStatus() == UNHEALTHY) {  
import org.opensearch.cluster.metadata.Metadata;
                logger.trace("onFollowerCheckRequest: responding successfully to {}", followerCheckRequest);
            Stream.concat(clusterManagerIneligibleNodeIdsInVotingConfig, excludedNodeIds).collect(Collectors.toSet()),
                    case NODE_LEFT_REASON_LAGGING -> "lagging";  
                } else {
    }  
    boolean missingJoinVoteFrom(DiscoveryNode node) {
            }
                .build();
    protected void doStart() {
                                cancelTimeoutHandlers();
                final boolean establishedAsClusterManager = mode == Mode.LEADER && getLastAcceptedState().term() == getCurrentTerm();  
                }
        return Booleans.isTrue(discoveryNode.getAttributes().getOrDefault("zen1", "false"));
                publishRequest.getAcceptedState().getVersion(),
        logger.trace("handleJoinRequest: as {}, handling {}", mode, joinRequest);
            transportService,
                logger.warn(
            final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder(currentState.coordinationMetadata())  
        return false;
                            clusterChangedEvent.source(),
                                    currentPublication = Optional.empty();
            assert Thread.holdsLock(mutex) : "Coordinator mutex not held";  
        }  
            .getLocalNode()  
        }
                if (isNewJoinFromClusterManagerEligibleNode && establishedAsClusterManager && publicationInProgress() == false) {
    }
        becomeCandidate("after abdicating to " + newClusterManager);  
            }
            if (applyCommitRequest.getSourceNode().equals(getLocalNode())) {  
 * under the License.  
            clusterManagerService,
                    "cannot start with ["  
                }
                joinCallback.onFailure(new IllegalStateException("failure when sending a validation request to node", e));  
        }  
                    + clusterState;
     */  
        }
                lagDetector.setTrackedNodes(publishNodes);  
                    } catch (Exception e) {  
    private final ClusterManagerService clusterManagerService;  
        );
    private boolean assertPreviousStateConsistency(ClusterChangedEvent event) {  
                        startElection();
            final DiscoveryNode sourceNode = publishRequest.getAcceptedState().nodes().getClusterManagerNode();
import org.opensearch.core.action.ActionListener;  
            // speculatively calculates the next cluster state update
    protected void doStop() {  
            // The preVoteCollector is only active while we are candidate, but it does not call this method with synchronisation, so we have
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                                                .filter(node -> {  
                settings,
                public void onFailure(String source, Exception e) {
                                                .collect(Collectors.toList());  
    private void updateMaxTermSeen(final long term) {
        ClusterManagerService clusterManagerService,
        assert Thread.holdsLock(mutex);
            } else if (mode == Mode.FOLLOWER) {  
                    1.0,
            );  
                }
import java.util.function.BiConsumer;
        }  
                    return;
    synchronized void onNodeCommissionStatusChange(boolean localNodeCommissioned) {  
package org.opensearch.cluster.coordination;
                    "onFollowerCheckRequest: received check from faulty cluster-manager, rejecting " + followerCheckRequest
                public String toString() {
    }
    // exposed for tests
    private void handleJoinRequest(JoinRequest joinRequest, JoinHelper.JoinCallback joinCallback) {
        boolean isActiveForCurrentLeader() {  
            transportService.getThreadPool(),
            settings,
        this.nodeRemovalExecutor = new NodeRemovalClusterStateTaskExecutor(allocationService, logger);
                    : getStateForClusterManagerService();
        assert mode == Mode.CANDIDATE : "expected candidate but was " + mode;
                );
                        + knownNodes
                                localNodeAckEvent.onFailure(e);
            );
                    votingConfiguration
        assert Thread.holdsLock(mutex) == false;
                throw new CoordinationStateRejectedException(
                    final boolean foundQuorum = coordinationState.get().isElectionQuorum(expectedVotes);
            transportService,  
                    return "scheduled timeout for " + CoordinatorPublication.this;
            if (prevMode == Mode.LEADER) {
    private final Supplier<CoordinationState.PersistedState> persistedStateSupplier;
                return false;
        } else {
            assert Thread.holdsLock(mutex) : "Coordinator mutex not held";  
                && Optional.of(sourceNode).equals(lastKnownLeader) == false) {  
            logger.debug(new ParameterizedMessage("failed to add {} - ignoring", join), e);
            if (mode != Mode.CANDIDATE) {  
                    ackListener,
                + lagDetector.getTrackedNodes();  
            this::updateMaxTermSeen,
    public void publish(
            return remoteClusterStateService.isRemotePublicationEnabled() && remoteClusterStateService.canDownloadFromRemoteForReadAPI();
            remoteClusterStateService  
        synchronized (mutex) {
        private final PublishRequest publishRequest;
        // safely accept a join whose last-accepted term/version is ahead of ours), so store them up and process them at the end.
        this.allocationService = allocationService;
            } else {
                };
            }
        synchronized (mutex) {
        @Override
            mode,
                    );
    }
                        final StatusInfo statusInfo = nodeHealthService.getHealth();
        assert Thread.holdsLock(mutex) : "Coordinator mutex not held";  
import org.opensearch.core.common.Strings;
    }
                // is already failed so there is no point in proceeding.
                try {
        synchronized (mutex) {  
                        CoordinatorPublication.this.toString(),
            getCurrentTerm(),
            )  
                                }  
                processJoinRequest(joinRequest, joinCallback);  
     * @param votingConfiguration The nodes that should form the initial configuration.
    /*
        peerFinder.onNodeCommissionStatusChange(localNodeCommissioned);
            TransportService transportService,
    void onFollowerCheckRequest(FollowerCheckRequest followerCheckRequest) {
    // visible for testing  
        final CoordinationState coordinationState = this.coordinationState.get();  
            this.publishListener = publishListener;
                }
    }
    private final PreVoteCollector preVoteCollector;
        }
        if (currentPublication.isPresent()) {  
                        }
                                    // trigger term bump if new term was found during publication  
                    }  
        final boolean restartLeaderChecker = (mode == Mode.FOLLOWER && Optional.of(leaderNode).equals(lastKnownLeader)) == false;
        return getStateForClusterManagerService().getLastAcceptedConfiguration().isEmpty() == false;
     *
                        final ClusterState lastAcceptedState = coordinationState.get().getLastAcceptedState();
        return new ActionListener<T>() {
        }
import org.opensearch.cluster.NodeConnectionsService;
                        cancel("timed out after " + publishTimeout);
 * The OpenSearch Contributors require contributions made to  
                    || coordinationState.get()  
import org.opensearch.threadpool.ThreadPool.Names;
        this.peerFinder = new CoordinatorPeerFinder(
                // marking pending disconnects before publish
        private boolean receivedJoinsProcessed;  
                    default -> reason;  
                        lastPublishedState = currentPublication.get().publishedState();  
            new HandshakingTransportAddressConnector(settings, transportService),
        return new DiscoveryStats(new PendingClusterStateStats(0, 0, 0), publicationHandler.stats(), clusterStateStats);
                        // active publication in progress: followersChecker is up-to-date with nodes that we're actively publishing to
     * @param onJoinValidators A collection of join validators to restrict which nodes may join the cluster.
        clusterManagerService.submitStateUpdateTask("clean-up after stepping down as cluster-manager", new LocalClusterUpdateTask() {
                }  
                            CoordinationMetadata.builder(clusterState.coordinationMetadata()).lastAcceptedConfiguration(newConfig).build()  
            .filter(coordinationState.get()::containsJoinVoteFor)
        return Optional.empty();
            ActionListener<PublishWithJoinResponse> responseActionListener  
                assert followersChecker.getKnownFollowers().isEmpty();  
        synchronized (mutex) {
                        false
                    reconfigurationTaskScheduled.set(false);
                    } else {
        private final PublicationTransportHandler.PublicationContext publicationContext;  
        }
        protected void onJoin(Join join) {
                assert preVoteCollector.getLeader() == getLocalNode() : preVoteCollector;  
import org.opensearch.cluster.LocalClusterUpdateTask;
        return new PreVoteResponse(  
                && localState.metadata().clusterUUID().equals(publishRequest.getAcceptedState().metadata().clusterUUID()) == false) {
                    ackListener.onNodeAck(getLocalNode(), exception); // other nodes have acked, but not the cluster manager.
    private final ClusterManagerMetrics clusterManagerMetrics;
                        }  
                public void run() {
                assert prevotingRound == null : prevotingRound;
                // turn,  
            joinCallback.onFailure(
                getDiscoveredNodes().forEach(node -> {  
import org.opensearch.cluster.service.ClusterApplier;  
    @Override
                    }  
        synchronized (mutex) {
                            }
                }  
        this.remoteStoreNodeService = remoteStoreNodeService;
            // The remote node did not include a join vote in its publish response. We do not persist joins, so it could be that the remote
    // package-visible for testing
                assert coordinationState.get().electionWon();
                throw new CoordinationStateRejectedException(  
                            lagDetector.setAppliedVersion(node, publishRequest.getAcceptedState().version());
            }
            if (votingConfiguration.getNodeIds().contains(getLocalNode().getId()) == false) {  
        lastKnownLeader = Optional.of(leaderNode);
                assert lastKnownLeader.get().equals(applierState.nodes().getClusterManagerNode())
                "{}: coordinator becoming FOLLOWER of [{}] in term {} (was {}, lastKnownLeader was [{}])",
    private final SetOnce<CoordinationState> coordinationState = new SetOnce<>(); // initialized on start-up (see doStart)
import java.util.List;  
import static org.opensearch.cluster.coordination.NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID;  
    // Package-private for testing
                .build();  
import org.opensearch.discovery.HandshakingTransportAddressConnector;  
        clusterBootstrapService.scheduleUnconfiguredBootstrap();
     * @param nodeName The name of the node, used to name the {@link java.util.concurrent.ExecutorService} of the {@link SeedHostsResolver}.
                final StartJoinRequest startJoinRequest = new StartJoinRequest(getLocalNode(), Math.max(getCurrentTerm(), maxTermSeen) + 1);
        ArrayList<PersistedStateStats> stats = new ArrayList<>();
        this.publishInfoTimeout = PUBLISH_INFO_TIMEOUT_SETTING.get(settings);
        ClusterSettings clusterSettings,
                            + coordinationState.get().getLastCommittedConfiguration();
                                            scheduleReconfigurationIfNeeded();
                .blocks(
            // is synchronized on AbstractLifecycleComponent#lifestyle, as is the doStart() method that creates the CoordinationState, so  
                logger.trace("onFollowerCheckRequest: current term is [{}], rejecting {}", getCurrentTerm(), followerCheckRequest);  
                    publicationContext,
            assert clusterState.blocks().hasGlobalBlockWithId(NO_CLUSTER_MANAGER_BLOCK_ID) == false  
                return unchanged();
        }
        ClusterApplier clusterApplier,
            Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
    boolean cancelCommittedPublication() {
                            } else {
                        )  
    }  
            if (join.getTerm() == getCurrentTerm() && missingJoinVoteFrom(join.getSourceNode())) {  
    }
            return clusterState;
            logger.debug(() -> new ParameterizedMessage("[{}] publishing failed", clusterChangedEvent.source()), e);
                );  
        }
    private void startElectionScheduler() {  
                .lastCommittedConfiguration(votingConfiguration)
            if (isZen1Node(node) == false) {
        synchronized (mutex) {
                        .addGlobalBlock(STATE_NOT_RECOVERED_BLOCK)
        this.publicationHandler = new PublicationTransportHandler(
    static boolean validVotingConfigExclusionState(ClusterState clusterState) {
    private void cancelActivePublication(String reason) {
                public void onCommit(TimeValue commitTime) {
            }
                @Override
    boolean isElectionSchedulerRunning() {  
    ) {
    }
            }  
                        return improveConfiguration(currentState);  
    private Join joinLeaderInTerm(StartJoinRequest startJoinRequest) {  
                        joinHelper.sendStartJoinRequest(startJoinRequest, node);
                            "node is no longer cluster-manager for term "
                                                        node,  
        this.clusterApplier = clusterApplier;
            if (stateForJoinValidation.nodes().isLocalNodeElectedClusterManager()) {  
                    || (applierState.nodes().getClusterManagerNodeId() == null
            }
     * @return whether this call successfully set the initial configuration - if false, the cluster has already been bootstrapped.  
                assert lastKnownLeader.isPresent();
            }  
            electionStrategy,  
 * this work for additional information regarding copyright
            }
                assert joinAccumulator instanceof JoinHelper.LeaderJoinAccumulator;
            joinAccumulator.close(mode);  
                    return;  
                    new ListenableFuture<>(),  
            .filter(e -> e.getNodeId().equals(VotingConfigExclusion.MISSING_VALUE_MARKER))
            if (sourceNode.equals(getLocalNode()) && mode != Mode.LEADER) {  
            }  
    public void setNodeConnectionsService(NodeConnectionsService nodeConnectionsService) {  
    }  
        this.persistedStateSupplier = persistedStateSupplier;  
                logger.debug("starting election with {}", startJoinRequest);
                                        if (localNodeMayWinElection(state) == false) {
                logger.debug("initialized PublicationContext using class: {}", publicationContext.getClass().toString());  
            this::startElection,
        logger.info("abdicating to {} with term {}", newClusterManager, startJoinRequest.getTerm());  
    }
    // package private for tests
            peerFinder.setCurrentTerm(getCurrentTerm());
                if (mode == Mode.CANDIDATE) {  
        if (electionScheduler != null) {
                        () -> new ParameterizedMessage(  
 * compatible open source license.
        protected void onMissingJoin(DiscoveryNode discoveryNode) {
    private void scheduleReconfigurationIfNeeded() {
                    assert lastPublishedNodes.remove(getLocalNode()); // followersChecker excludes local node
            @Override
                    logger.warn(
                                        closePrevotingAndElectionScheduler();
                        + getLocalNode()
        NodeHealthService nodeHealthService,
                    return true;  
                }
            getCurrentTerm(),
    private final ClusterSettings clusterSettings;  
        this.singleNodeDiscovery = DiscoveryModule.isSingleNodeDiscovery(settings);  
            localNodeAckEvent.addListener(new ActionListener<Void>() {  
            rerouteService,
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.discovery.SeedHostsResolver;  
                                localNodeAckEvent.onResponse(null);  
                        MediaTypeRegistry.JSON,
                );
                    // even before executing the join task to fail fast
 */
            if (prevElectionWon == false && coordState.electionWon()) {
                publishResponse,
            this::onFollowerCheckRequest,
            Settings settings,
                assert getLocalNode().equals(clusterState.getNodes().get(getLocalNode().getId())) : getLocalNode()  
    // the timeout for the publication of each value
        return false;  
                    scheduleReconfigurationIfNeeded();
                transportAddressConnector,  
            logger.trace("handleApplyCommit: applying commit {}", applyCommitRequest);
                            logger.debug("skip prevoting as local node is decommissioned");  
    }
                    final Set<DiscoveryNode> lastPublishedNodes = new HashSet<>();
                                                })
    // package-visible for testing
                    return;
    private final Settings settings;
            );
        }
                logger.info("cluster UUID [{}]", lastAcceptedState.metadata().clusterUUID());
    /**
                } catch (Exception e) {
                    this.isRemotePublicationEnabled(),  
    }  
            Stream.concat(Stream.of(getLocalNode()), StreamSupport.stream(peerFinder.getFoundPeers().spliterator(), false))  
                throw new CoordinationStateRejectedException("local node is not part of initial configuration");
                    // This set only needs to be maintained on active cluster-manager  
                becomeCandidate(reason);
    private final NoClusterManagerBlockService noClusterManagerBlockService;
import org.opensearch.cluster.ClusterStateUpdateTask;  
        }
                                                    );
                "handlePublishRequest: handling version [{}] from [{}]",
                    clusterApplier.onNewClusterState(
        AllocationService allocationService,
                        + localState.metadata().clusterUUID()  
                );
        }
     */
                    reconfigurationTaskScheduled.set(false);  
                // Bump our term. However if there is a publication in flight then doing so would cancel the publication, so don't do that  
            .map(DiscoveryNode::getId);
            @Override  
            startElectionScheduler();
    private void startElection() {  
        final Stream<String> clusterManagerIneligibleNodeIdsInVotingConfig = StreamSupport.stream(clusterState.nodes().spliterator(), false)
    private PreVoteResponse getPreVoteResponse() {
                // a late response may arrive after the state has been locally applied, meaning that receivedJoins has already been
                throw new CoordinationStateRejectedException(  
            updateLastSeen.accept(coordinationState.get().getLastAcceptedState());
    }
            nodeHealthService,
            )  
        @Override
                assert currentPublication.map(Publication::isCommitted).orElse(true);
        final StartJoinRequest startJoinRequest = new StartJoinRequest(newClusterManager, Math.max(getCurrentTerm(), maxTermSeen) + 1);
                public String toString() {  
                                        if (attemptReconfiguration) {  
                            startElectionScheduler();
                clusterApplier.onNewClusterState(applyCommitRequest.toString(), () -> applierState, new ClusterApplyListener() {
            getCurrentTerm(),
            || XContentHelper.convertToMap(
                        + votingConfiguration  
                    assert followersChecker.getKnownFollowers().isEmpty() : followersChecker.getKnownFollowers();
            final DiscoveryNodes discoveryNodes = new DiscoveryNodes.Builder(clusterState.nodes()).clusterManagerNodeId(null).build();  
            PublishRequest publishRequest,  
        synchronized (mutex) {  
        }
                + getLastAcceptedState().coordinationMetadata();  
import org.opensearch.node.remotestore.RemoteStoreNodeService;
import org.opensearch.discovery.Discovery;  
        protected void sendApplyCommit(  
        // explicitly move node to candidate state so that the next cluster state update task yields an onNoLongerMaster event
        return nodeMayWinElection(lastAcceptedState, localNode);  
                        applyListener.onFailure(e);
            transportService,
                                cancelTimeoutHandlers();
            }
    private final JoinHelper joinHelper;
        assert mode != Mode.LEADER : "do not switch to follower from leader (should be candidate first)";
            }  
                            return;
            }, publishInfoTimeout, Names.GENERIC);
                && persistedStateRegistry.getPersistedState(stateType).getStats() != null) {
                                            }
import org.apache.logging.log4j.message.ParameterizedMessage;  
            }, OpenSearchExecutors.newDirectExecutorService(), transportService.getThreadPool().getThreadContext());
        Set<String> nodeNamesWithAbsentId = votingConfigExclusions.stream()  
                    nodeRemovalExecutor
            // This looks like a race that might leak an unclosed CoordinationState if it's created while execution is here, but this method
        };
    private static final Logger logger = LogManager.getLogger(Coordinator.class);  
        }
        protected void onFoundPeersUpdated() {  
                final CoordinatorPublication publication = new CoordinatorPublication(  
        return electionScheduler != null;
                preVoteCollector.update(getPreVoteResponse(), getLocalNode());
import org.opensearch.cluster.coordination.CoordinationState.VoteCollection;
                                ackListener.onNodeAck(getLocalNode(), e);
        assert Thread.holdsLock(mutex) : "Coordinator mutex not held";  
            ApplyCommitRequest applyCommit,
    private final ElectionSchedulerFactory electionSchedulerFactory;
            leaderChecker.updateLeader(leaderNode);
import java.util.function.Supplier;
        clusterManagerService.setClusterStateSupplier(this::getStateForClusterManagerService);  
                                                    final VoteCollection futureVoteCollection = new VoteCollection();
                    logger.trace("skip election as local node may not win it: {}", getLastAcceptedState().coordinationMetadata());  
                    } else {
                            public void onSuccess(String source) {
                becomeLeader("handleJoinRequest");
import java.util.stream.Collectors;
            "{}: coordinator becoming CANDIDATE in term {} (was {}, lastKnownLeader was [{}])",
            final long currentTerm = getCurrentTerm();
                assert preVoteCollector.getLeader().equals(lastKnownLeader.get()) : preVoteCollector;
     */  
        return transportService.getLocalNode();
            clusterState.getLastAcceptedConfiguration()  
                if (mode != Mode.LEADER || getCurrentTerm() != clusterChangedEvent.state().term()) {  
                    sourceNode,
            });  
            }
            }
            ensureTermAtLeast(sourceNode, publishRequest.getAcceptedState().term());
                }  
        }
                        )
        if (mode == Mode.FOLLOWER && Optional.of(leaderNode).equals(lastKnownLeader)) {
            this::removeNode,  
            // it's all ok.
        synchronized (mutex) {  
        this.noClusterManagerBlockService = new NoClusterManagerBlockService(settings, clusterSettings);
        }
        assert event.previousState() == coordinationState.get().getLastAcceptedState()
                    JoinTaskExecutor.ensureMajorVersionBarrier(
            }
                .build();
        return applierState;  
    private void closeElectionScheduler() {
                    }  
                        + "initial configuration [knownNodes={}, {}]",  
                                                        state.version(),  
                && votingConfiguration.isEmpty() == false  
        }
    private void cleanClusterManagerService() {  
    class CoordinatorPublication extends Publication {  
            synchronized (mutex) {
            } else {
                logger.debug("onMissingJoin: no join vote from {}, bumping term to exceed {}", discoveryNode, term);  
            @Override  
import org.opensearch.cluster.node.DiscoveryNode;
                    // but publication has not started yet  
                        ensureTermAtLeast(getLocalNode(), maxTermSeen);
        }
        // handling of start join messages on the local node will be dispatched to the generic thread-pool  
                    assert Thread.holdsLock(mutex) : "Coordinator mutex not held";
            );
                assert getStateForClusterManagerService().nodes().getClusterManagerNodeId() == null : getStateForClusterManagerService();  
    }
            if (currentPublication.isPresent()) {
            coordinationState.get().handleCommit(applyCommitRequest);  
    @Nullable
     */
                        stateForJoinValidation.getNodes().getMinNodeVersion()
            assert preVoteCollector.getPreVoteResponse().equals(getPreVoteResponse()) : preVoteCollector + " vs " + getPreVoteResponse();
            if (mode == Mode.LEADER) {
                        + DiscoveryModule.SINGLE_NODE_DISCOVERY_TYPE  
        this.remoteClusterStateService = remoteClusterStateService;
        if (clusterState.nodes().getClusterManagerNodeId() != null) {
            if (coordinationState.get().electionWon()) {
        configuredHostsResolver = new SeedHostsResolver(nodeName, settings, transportService, seedHostsProvider);  
     */  
            assert localNodeMayWinElection(getLastAcceptedState()) : "initial state does not allow local node to win election: "
                    final ClusterState lastPublishedState;  
    }  
                        JsonXContent.jsonXContent,  
        );  
                    persistedStateRegistry
import org.opensearch.cluster.ClusterManagerMetrics;
        this.localNodeCommissioned = true;  
                                                            new Join(completedNode, node, futureElectionTerm, state.term(), state.version())
            peerFinder.setCurrentTerm(getCurrentTerm());
        return new ClusterFormationState(
            joinHelper::logLastFailedJoinAttempt
import static org.opensearch.cluster.ClusterManagerMetrics.FOLLOWER_NODE_ID_TAG;  
                    if (foundQuorum) {  
                        clusterStateWithNoClusterManagerBlock(coordinationState.get().getLastAcceptedState())
    // package-visible for testing
            super(  
        );
                                }  
            updateMaxTermSeen(joinRequest.getTerm());
 * You may obtain a copy of the License at  
        joinHelper.sendValidateJoinRequest(joinRequest.getSourceNode(), stateForJoinValidation, new ActionListener<Empty>() {
        }
        Collection<BiConsumer<DiscoveryNode, ClusterState>> onJoinValidators,  
            if (lastAcceptedState.metadata().clusterUUIDCommitted()) {
                coordinationState.get().handleJoin(join); // this might fail and bubble up the exception
            super(publishRequest, new ClusterStatePublisher.AckListener() {  
    private void processJoinRequest(JoinRequest joinRequest, JoinHelper.JoinCallback joinCallback) {
                // processed, so we have to handle this late response here.  
                                    lagDetector.startLagDetector(publishRequest.getAcceptedState().version());
            .collect(Collectors.toSet());
        protected boolean isPublishQuorum(VoteCollection votes) {
        }
        @Override
                clusterApplier.onNewClusterState("becoming candidate: " + method, () -> applierState, (source, e) -> {});
     * @opensearch.internal  
        private final List<Join> receivedJoins = new ArrayList<>();
        }
        @Override
            coordinationState.get().setInitialState(ClusterState.builder(currentState).metadata(metadataBuilder).build());
            if (getLocalNode().isClusterManagerNode() == false) {
                new IllegalStateException(
        );
        this.electionStrategy = electionStrategy;
                logger.trace("onFollowerCheckRequest: rejoining cluster-manager, responding successfully to {}", followerCheckRequest);  
            ClusterStatePublisher.AckListener ackListener,  
            }  
            n -> removeNode(n, "lagging"),
        @Override
    final Object mutex = new Object(); // package-private to allow tests to call methods that assert that the mutex is held  
            }  
                        Tags.create().addTag(FOLLOWER_NODE_ID_TAG, discoveryNode.getId()).addTag(REASON_TAG, reasonToPublish)  
    }
            if (isActiveForCurrentLeader()) {
    private final LagDetector lagDetector;
     */  
            logger.debug("joinLeaderInTerm: for [{}] with term {}", startJoinRequest.getSourceNode(), startJoinRequest.getTerm());
        }  
            if (persistedStateRegistry.getPersistedState(stateType) != null
            metadataBuilder.generateClusterUuidIfNeeded();
/*
            }
                synchronized (mutex) {
            }
        ClusterStateStats clusterStateStats = clusterManagerService.getClusterStateStats();
/*
                        if (localNodeMayWinElection(lastAcceptedState) == false) {  
            nodeHealthService,
                    cancelTimeoutHandlers();
                assert peerFinderLeader.equals(lastKnownLeader) : peerFinderLeader;
     * @opensearch.internal
                assert clusterFormationFailureHelper.isRunning();
    public boolean canDownloadFullStateFromRemote() {  
                n -> n.isClusterManagerNode() == false  
                @Override
        this.joinHelper = new JoinHelper(
        private void removePublicationAndPossiblyBecomeCandidate(String reason) {
        }
                            "[{}] failed publication as node is no longer cluster-manager for term {}",  
    }
                final CoordinatorPublication publication = currentPublication.get();
    }
            applierState = mode == Mode.CANDIDATE ? clusterStateWithNoClusterManagerBlock(committedState) : committedState;
        @Override
        this.clusterSettings = clusterSettings;  
                            logger.trace("skip prevoting as local node may not win election: {}", lastAcceptedState.coordinationMetadata());
        mode = Mode.LEADER;  
            final ClusterState committedState = hideStateIfNotRecovered(coordinationState.get().getLastAcceptedState());
    /**
            this::onLeaderFailure,  
                            }
            return mode == Mode.LEADER && publishRequest.getAcceptedState().term() == getCurrentTerm();
            this::setInitialConfiguration
                        applyListener.onResponse(null);
            applierState = initialState;  
        );  
        final DiscoveryNode localNode = lastAcceptedState.nodes().getLocalNode();
                getCurrentTerm(),
                assert lastKnownLeader.isPresent() && (lastKnownLeader.get().equals(getLocalNode()) == false);
    private final ClusterFormationFailureHelper clusterFormationFailureHelper;  
    private final AllocationService allocationService;
        String nodeName,
                assert lastKnownLeader.isPresent() && lastKnownLeader.get().equals(getLocalNode());  
    public Coordinator(
            coordinationState.set(new CoordinationState(getLocalNode(), persistedStateRegistry, electionStrategy, settings));  
        synchronized (mutex) {
     */
                @Override  
import org.opensearch.gateway.remote.RemoteClusterStateService;
                currentPublication = Optional.of(publication);
import org.opensearch.common.xcontent.XContentHelper;
                            clusterChangedEvent.source()
     * more than once, as long as the argument to each call is the same.  
import java.io.IOException;
                            @Override
                                        final ClusterState state = getLastAcceptedState(); // committed state
            if (publishRequest.getAcceptedState().term() > localState.term()) {
        this.reconfigurator = new Reconfigurator(settings, clusterSettings);
                joinHelper.sendJoinRequest(clusterManagerNode, getCurrentTerm(), joinWithDestination(lastJoin, clusterManagerNode, term));  
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;  
        TimeValue.timeValueMillis(10000),
        @Nullable // if using single-node discovery
        }  
    private Releasable electionScheduler;
    // there is no equals on cluster state, so we just serialize it to XContent and compare Maps
            this.infoTimeoutHandler = transportService.getThreadPool().schedule(new Runnable() {
            } else {  
            assert (applierState.nodes().getClusterManagerNodeId() == null) == applierState.blocks()
        return onJoinValidators;  
            peerFinder.activate(coordinationState.get().getLastAcceptedState().nodes());  
            settings,  
            return ClusterState.builder(clusterState)
                logger.debug("skip setting initial configuration as local node is not part of initial configuration");
            joinAccumulator = new JoinHelper.FollowerJoinAccumulator();
    }
    private final LeaderChecker leaderChecker;  
import org.opensearch.cluster.block.ClusterBlocks;  
        }
        assert currentPublication.isPresent() == false : "Expected no publication in progress";
                logger.debug("initial configuration already set, ignoring {}", votingConfiguration);
                                            if (clusterManagerCandidates.isEmpty() == false) {
            return coordinationState.get().getLastAcceptedState();  
                final PublicationTransportHandler.PublicationContext publicationContext = publicationHandler.newPublicationContext(
        if (mode != Mode.FOLLOWER) {
                final boolean becomingClusterManager = getStateForClusterManagerService().term() != getCurrentTerm();  
            }
    public boolean setInitialConfiguration(final VotingConfiguration votingConfiguration) {
        }  
                                                        futureElectionTerm,
                    publishRequest.getAcceptedState().metadata().clusterUUID(),  
                        becomeCandidate("updateMaxTermSeen");
        }  
                    receivedJoins.forEach(CoordinatorPublication.this::handleAssociatedJoin);  
                }
        this.clusterBootstrapService = new ClusterBootstrapService(
            if (localState.metadata().clusterUUIDCommitted()
            assert lagDetector.getTrackedNodes().contains(getLocalNode()) == false : lagDetector.getTrackedNodes();  
    }
    private Optional<CoordinatorPublication> currentPublication = Optional.empty();  
            liveNodes,  
                logger.debug("skip setting initial configuration as local node is not a cluster-manager-eligible node");  
    @Override
        }  
                    )
     * Sets the initial configuration to the given {@link VotingConfiguration}. This method is safe to call
    private static boolean nodeMayWinElection(ClusterState lastAcceptedState, DiscoveryNode node) {  
                // cluster-manager node applies the committed state at the end of the publication process, not here.
        this.settings = settings;
                    || (applierState.nodes().getClusterManagerNodeId() == null && applierState.term() < getCurrentTerm());
import org.opensearch.core.common.transport.TransportAddress;  
                    if (mode == Mode.CANDIDATE) {  
                        + DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey()
                if (currentState.nodes().isLocalNodeElectedClusterManager() == false) {
import java.util.ArrayList;
            logger.debug(
                                                attemptReconfiguration = false;  
            clusterManagerMetrics
import org.opensearch.core.xcontent.MediaTypeRegistry;
            method,
    private Releasable prevotingRound;
    PublishWithJoinResponse handlePublishRequest(PublishRequest publishRequest) {  
                    nodeRemovalExecutor,
import org.opensearch.telemetry.metrics.tags.Tags;
            optionalJoin.ifPresent(this::handleJoin);
        "cluster.publish.timeout",  
                            .collect(Collectors.toList());  
import java.util.stream.StreamSupport;
import java.util.stream.Stream;  
                throw new CoordinationStateRejectedException("no longer leading this publication's term: " + publishRequest);  
            }  
 * Modifications Copyright OpenSearch Contributors. See  
                    // we are checking source node commission status here to reject any join request coming from a decommissioned node  
                @Override
        assert newClusterManager.isClusterManagerNode() : "should only abdicate to cluster-manager-eligible node but was "  
    @Override
            if (mode == Mode.LEADER) {
        final VotingConfiguration newConfig = reconfigurator.reconfigure(
    public static final Setting<TimeValue> PUBLISH_INFO_TIMEOUT_SETTING = Setting.timeSetting(  
    public ClusterState getLastAcceptedState() {
            || lastAcceptedState.getVotingConfigExclusions().stream().noneMatch(vce -> vce.getNodeId().equals(nodeId));
 * KIND, either express or implied.  See the License for the
                        }
        final String nodeId = node.getId();
            ActionListener<Empty> responseActionListener  
            settings,  
                }
        );  
                            clusterStateWithNoClusterManagerBlock(coordinationState.get().getLastAcceptedState())  
            ensureTermAtLeast(getLocalNode(), join.getTerm()).ifPresent(this::handleJoin);
                    }
 *    http://www.apache.org/licenses/LICENSE-2.0
     *  
        );  
                final boolean isNewJoinFromClusterManagerEligibleNode = handleJoinIgnoringExceptions(join);  
        this.publishTimeout = publishTimeout;
            DiscoveryNode destination,
    private final TimeValue publishInfoTimeout;
        this.lastJoin = Optional.empty();  
                assert mode == Mode.CANDIDATE;
    }
        });
        @Override  
import org.opensearch.common.unit.TimeValue;
            ListenableFuture<Void> localNodeAckEvent,
        }  
        // the voting config. We could exclude all the cluster-manager-ineligible nodes here, but there could be quite a few of them and
        }
                .blocks(clusterState.blocks())  
        synchronized (mutex) {
                } else {
        RemoteClusterStateService remoteClusterStateService
        private final Scheduler.Cancellable infoTimeoutHandler;
                    @Override
            assert currentPublication.get() == this;
            if (timeoutHandler != null) {
        Consumer<ClusterState> updateLastSeen,  
        Setting.Property.NodeScope,  
import org.opensearch.common.settings.Settings;  
    private Optional<Join> ensureTermAtLeast(DiscoveryNode sourceNode, long targetTerm) {
            this::handlePublishRequest,
            }
                        if (e == null) {
                );  
        }  
            .filter(discoveryNode -> isZen1Node(discoveryNode) == false)  
                    "node-left",
            public void onFailure(Exception e) {
                    case NODE_LEFT_REASON_HEALTHCHECK_FAIL -> "health.check.fail";
                        final List<DiscoveryNode> discoveredNodes = getDiscoveredNodes().stream()
 * ownership. Elasticsearch licenses this file to you under  
    }
    private Optional<Join> lastJoin;
        cancelActivePublication("become follower: " + method);  
        }
        preVoteCollector.update(getPreVoteResponse(), leaderNode);
            // check if node has not already switched modes (by bumping term)  
     * @return true if publication was cancelled, false if there is no current committed publication.  
     * @return true iff the join was from a new node and was successfully added
                    publishListener.onFailure(exception);
    private <T> ActionListener<T> wrapWithMutex(ActionListener<T> listener) {
    private class CoordinatorPeerFinder extends PeerFinder {
    }
            joinAccumulator.close(mode);  
    protected void doClose() throws IOException {
    @Override
                }
    private volatile boolean localNodeCommissioned;  
                        + " than local cluster uuid "
            synchronized (mutex) {
        this.transportService = transportService;
 * not use this file except in compliance with the License.
                @Override  
    private final boolean singleNodeDiscovery;
                handleAssociatedJoin(join);
    }  
                            return;
        transportService.connectToNode(joinRequest.getSourceNode(), ActionListener.wrap(ignore -> {
        }
                }
        joinAccumulator.close(mode);
import org.apache.logging.log4j.Level;  
            clusterSettings,
            if (mode == Mode.LEADER && maxTermSeen > currentTerm) {
        // that makes
                    public void onFailure(String source, Exception e) {
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;
    }  
                }  
        nodes.add(getLocalNode());
            );
    private static Optional<Join> joinWithDestination(Optional<Join> lastJoin, DiscoveryNode leader, long term) {
    private volatile ClusterState applierState; // the state that should be exposed to the cluster state applier
                        + " with a different cluster uuid "  
            lagDetector.clearTrackedNodes();
 */
    private final ClusterApplier clusterApplier;
        ) {
            peerFinder.getFoundPeers().forEach(knownNodes::add);
                    && (clusterState.getLastAcceptedConfiguration().getNodeIds().contains(n.getId())
            publicationContext.sendApplyCommit(destination, applyCommit, wrapWithMutex(responseActionListener));
        followersChecker.updateFastResponseState(getCurrentTerm(), mode);
                // ignore
            mode = Mode.CANDIDATE;
                                                .filter(DiscoveryNode::isClusterManagerNode)
            this::handleJoinRequest,
        SeedHostsProvider seedHostsProvider,
            return mode;
        Setting.Property.Dynamic
        synchronized (mutex) {
                    );  
    }
     * This method is used exclusively by tests.
                assert prevotingRound == null || electionScheduler != null;
        @Override
            || lastAcceptedState.getLastAcceptedConfiguration().getNodeIds().contains(nodeId)  
import org.opensearch.monitor.StatusInfo;  
                timeoutHandler.cancel();  
        try {
    }
            transportService,
        Setting.Property.NodeScope
            // check if node has accepted a state in this term already. If not, this node has never committed a cluster state in this  
            final PublishResponse publishResponse = coordinationState.get().handlePublishRequest(publishRequest);
            }
        this.clusterFormationFailureHelper = new ClusterFormationFailureHelper(
        return true;  
        if (newConfig.equals(clusterState.getLastAcceptedConfiguration()) == false) {  
                        synchronized (mutex) {
                        + "] discovery"
        assert Thread.holdsLock(mutex) : "Coordinator mutex not held";
                    } else {
        }  
    private final SeedHostsResolver configuredHostsResolver;
    }
                applyListener.onResponse(null);
    /**
        synchronized (mutex) {
                .hasGlobalBlockWithId(NO_CLUSTER_MANAGER_BLOCK_ID);  
                            .getLastAcceptedConfiguration()  
            followersChecker.updateFastResponseState(getCurrentTerm(), mode);
                return false;
        configuredHostsResolver.stop();
    private final RemoteStoreNodeService remoteStoreNodeService;
                ) : Strings.toString(MediaTypeRegistry.JSON, event.previousState())
                throw new CoordinationStateRejectedException(  
                        lastPublishedState = coordinationState.get().getLastAcceptedState();  
            .map(VotingConfigExclusion::getNodeName)
        });
                        + sourceNode
        private final ClusterStatePublisher.AckListener ackListener;
                                                    completedNodes().forEach(  
                leaderChecker.setCurrentNodes(publishNodes);
            if (applierState.nodes().getClusterManagerNodeId() != null) {
                    localState.metadata().clusterUUID()
    }
                                        // if necessary, abdicate to another node or improve the voting configuration
        }
            settings,
                        + " does not have quorum in voting configuration "  
            .nodes()
                        }
    private void setPublishTimeout(TimeValue publishTimeout) {  
        this.preVoteCollector = new PreVoteCollector(
    }
                        logger.warn(new ParameterizedMessage("failed to bump term to {}", maxTermSeen), e);
        ClusterStatePublisher.AckListener ackListener
                sendValidateJoinRequest(stateForJoinValidation, joinRequest, joinCallback);
                                                        state.term(),
                    );
                    "skip setting initial configuration as not enough nodes discovered to form a quorum in the "
        this.clusterManagerService = clusterManagerService;  
        assert Thread.holdsLock(mutex) : "Coordinator mutex not held";
    private final ClusterBootstrapService clusterBootstrapService;
                    public void onSuccess(String source) {  
                logger.trace("failed to clean-up after stepping down as cluster-manager", e);
                );  
            @Override  
 * license agreements. See the NOTICE file distributed with
            leaderChecker.setCurrentNodes(DiscoveryNodes.EMPTY_NODES);  
                if (currentPublication.isPresent()) {  
        Random random,
    public Collection<BiConsumer<DiscoveryNode, ClusterState>> getOnJoinValidators() {
            allocationService,
        } catch (Exception e) {
                assert peerFinderLeader.isPresent() == false : peerFinderLeader;
                        + " != "  
import org.opensearch.cluster.coordination.JoinHelper.InitialJoinAccumulator;  
        ApplyCommitRequest applyCommitRequest,
                        }  
                // If we have already won the election then the actual join does not matter for election purposes, so swallow any exception
        private final ActionListener<Void> publishListener;
                            .filter(n -> isZen1Node(n) == false)
                coordinationState.get().handlePrePublish(clusterState);
        this.onJoinValidators = JoinTaskExecutor.addBuiltInJoinValidators(onJoinValidators);
                            MediaTypeRegistry.JSON,
            stats.add(remoteClusterStateService.getDiffDownloadStats());
                    final VoteCollection expectedVotes = new VoteCollection();
        if (coordinationState != null) {
            return remoteClusterStateService.isRemotePublicationEnabled();
    }  
            .filter(DiscoveryNode::isClusterManagerNode)
                                                    // a vote in that next election and has the latest state.  
    private final PublicationTransportHandler publicationHandler;
    private final NodeRemovalClusterStateTaskExecutor nodeRemovalExecutor;  
import org.opensearch.common.lease.Releasable;
                    case NODE_LEFT_REASON_DISCONNECTED -> "disconnected";
     * @opensearch.internal
            }
                    Optional.ofNullable(
                        + "] set to ["
            becomeCandidate("onLeaderFailure");
        });
    }  
    public void invariant() {
    private final PersistedStateRegistry persistedStateRegistry;
                );
    * 2. Every voting config exclusion with a name of _absent_ should not match any nodes currently in the cluster by ID
            if (receivedJoinsProcessed) {
    void becomeCandidate(String method) {
        this.lagDetector = new LagDetector(  
        peerFinder.deactivate(getLocalNode());
                                synchronized (mutex) {
    }  
        this.electionSchedulerFactory = new ElectionSchedulerFactory(settings, random, transportService.getThreadPool());
     * The coordinator publication.
            clusterFormationFailureHelper.start();
        }, joinCallback::onFailure));
        }
    // package-visible for testing
        }  
            return Optional.of(joinLeaderInTerm(new StartJoinRequest(sourceNode, targetTerm)));
        final Stream<String> excludedNodeIds = clusterState.getVotingConfigExclusions().stream().map(VotingConfigExclusion::getNodeId);
import java.util.function.Consumer;  
            clusterManagerMetrics
            clusterManagerService.submitStateUpdateTask("reconfigure", new ClusterStateUpdateTask(Priority.URGENT) {
import org.opensearch.common.settings.Setting;
        TransportService transportService,
            final Join join = coordinationState.get().handleStartJoin(startJoinRequest);  
                .lastAcceptedConfiguration(votingConfiguration)
    }
    }
    }
                @Override  
                        if (prevotingRound != null) {
        lagDetector.clearTrackedNodes();  
            // to check our mode again here.  
            ensureTermAtLeast(followerCheckRequest.getSender(), followerCheckRequest.getTerm());  
                        + votingConfiguration
        synchronized (mutex) {  
import org.opensearch.common.xcontent.json.JsonXContent;
                assert joinAccumulator instanceof JoinHelper.FollowerJoinAccumulator;  
    // package-visible for testing
            }  
    private ClusterFormationState getClusterFormationState() {
                    )  
        Stream.of(PersistedStateRegistry.PersistedStateType.values()).forEach(stateType -> {  
        Settings settings,  
            transportService,  
                publication.start(followersChecker.getFaultyNodes());
                && getCurrentTerm() == ZEN1_BWC_TERM
        assert leaderNode.isClusterManagerNode() : leaderNode + " became a leader but is not cluster-manager-eligible";
        assert localNode != null;
                final ClusterState clusterState = clusterChangedEvent.state();
                        logIncompleteNodes(Level.INFO);  
    public boolean isRemotePublicationEnabled() {
    /**  
                .addGlobalBlock(noClusterManagerBlockService.getNoClusterManagerBlock())
        synchronized (mutex) {
            if (node.isClusterManagerNode()  
        closeElectionScheduler();  
    }  
                }
            assert followersChecker.getFastResponseState().term == getCurrentTerm() : followersChecker.getFastResponseState();  
        }  
        FOLLOWER
                    ClusterBlocks.builder()  
        }
            // expose last accepted cluster state as base state upon which the cluster_manager service  
                assert leaderChecker.currentNodeIsClusterManager() == false;
            followersChecker.clearCurrentNodes();  
            logger.trace("scheduling reconfiguration");  
            clusterSettings,  
                            clusterChangedEvent.state().term()
                if (publication.isCommitted()) {  
                applierState = clusterStateWithNoClusterManagerBlock(applierState);  
        private void cancelTimeoutHandlers() {
            "{}: coordinator becoming LEADER in term {} (was {}, lastKnownLeader was [{}])",
                );
            }  
                                    logger.debug("publication ended successfully: {}", CoordinatorPublication.this);
            .collect(Collectors.toSet());  
            .filter(
            public void onFailure(String source, Exception e) {  
            this.ackListener = ackListener;
        assert mode == Mode.LEADER : "expected to be leader on abdication but was " + mode;
                                                        futureVoteCollection  
        ) {
                .build();  
            prevotingRound.close();
        });
    void becomeLeader(String method) {
            if (isInitialConfigurationSet()) {  
import java.util.Random;
    @Nullable
    public Iterable<DiscoveryNode> getFoundPeers() {
        RemoteStoreNodeService remoteStoreNodeService,  
    private final ElectionStrategy electionStrategy;
                nodeConnectionsService.setPendingDisconnections(new HashSet<>(clusterChangedEvent.nodesDelta().removedNodes()));  
        lastKnownLeader = Optional.of(getLocalNode());
    }
import org.opensearch.cluster.routing.RerouteService;
        this.lastKnownLeader = Optional.empty();
                    receivedJoinsProcessed = true;
            return lastJoin;
            // automatically generate a UID for the metadata if we need to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                )  
            settings,  
        protected void startProbe(TransportAddress transportAddress) {
        ElectionStrategy electionStrategy,  
                }
                && votingConfiguration.hasQuorum(Collections.singleton(getLocalNode().getId())) == false) {
                transportService,
                onJoinValidators.forEach(a -> a.accept(getLocalNode(), publishRequest.getAcceptedState()));
    }  
                                    }  
                    lastPublishedState.nodes().forEach(lastPublishedNodes::add);  
            }  
            if (getCurrentTerm() != followerCheckRequest.getTerm()) {
            this.timeoutHandler = singleNodeDiscovery ? null : transportService.getThreadPool().schedule(new Runnable() {  
                }
            }  
                    logger.debug(
    private List<DiscoveryNode> getDiscoveredNodes() {  
        return Optional.empty();  
                logger.warn(  
                                    logIncompleteNodes(Level.WARN);
            public void onResponse(Empty empty) {
            } else if (mode == Mode.FOLLOWER) {  
            // checks if this publication can still influence the mode of the current publication
                + " vs "
    }
                            logger.debug("skip prevoting as local node is unhealthy: [{}]", statusInfo.getInfo());
            }
                                                    );
        this.clusterManagerMetrics = clusterManagerMetrics;
            logger.trace("Starting initial join, becoming candidate");
    private Optional<DiscoveryNode> lastKnownLeader;  
                }
                    "onFollowerCheckRequest: current term is [" + getCurrentTerm() + "], rejecting " + followerCheckRequest
                assert becomingClusterManager || getStateForClusterManagerService().nodes().getClusterManagerNodeId() != null
        );  
        synchronized (mutex) {  
            @Override
                                        }
                                    removePublicationAndPossiblyBecomeCandidate("clusterApplier#onNewClusterState");
                        ),
            }
                    XContentHelper.convertToMap(
                    if (activePublication) {
                        // acknowledge it  
            getCurrentTerm(),  
                );
                            if (e == null) {
                receivedJoins.add(join);  
        closePrevoting();
            return coordinationState.get().getCurrentTerm();
            final List<DiscoveryNode> knownNodes = new ArrayList<>();
            coordinationState.get().getLastAcceptedState().getVersionOrMetadataVersion()  
                    allocationService.cleanCaches();
                });
    }
    }  
        );
import org.opensearch.common.util.concurrent.ListenableFuture;
        }
    private TimeValue publishTimeout;  
            nodeHealthService
                                publishListener.onResponse(null);  
    public static final Setting<TimeValue> PUBLISH_TIMEOUT_SETTING = Setting.timeSetting(
        // exclude any nodes whose ID is in the voting config exclusions list ...  
            synchronized (mutex) {
            }
        followersChecker.clearCurrentNodes();
        RerouteService rerouteService,
        clusterSettings.addSettingsUpdateConsumer(PUBLISH_TIMEOUT_SETTING, this::setPublishTimeout);  
            if (publishRequest.getAcceptedState().term() == ZEN1_BWC_TERM  
import org.opensearch.discovery.PeerFinder;
                        || clusterState.getLastCommittedConfiguration().getNodeIds().contains(n.getId()))
            remoteStoreNodeService,
        }  
            @Override
                assert currentPublication.map(Publication::isCommitted).orElse(true);
                    JoinTaskExecutor.ensureNodeCommissioned(joinRequest.getSourceNode(), stateForJoinValidation.metadata());
            assert Thread.holdsLock(mutex) : "Coordinator mutex not held";  
                    + Strings.toString(  
import org.opensearch.discovery.SeedHostsProvider;
                    || activePublication
            namedWriteableRegistry
 */
                    return "scheduled timeout for reporting on " + CoordinatorPublication.this;  
    public boolean localNodeCommissioned() {
            if (getLastAcceptedState().term() < getCurrentTerm()) {
            }, publishTimeout, Names.GENERIC);  
                final PublishRequest publishRequest = coordinationState.get().handleClientValue(clusterState);
                @Override
            maxTermSeen = Math.max(maxTermSeen, term);  
import org.opensearch.cluster.coordination.FollowersChecker.FollowerCheckRequest;
            joinAccumulator.handleJoinRequest(joinRequest.getSourceNode(), joinCallback);
                : "NO_MASTER_BLOCK should only be added by Coordinator";
                                ackListener.onNodeAck(getLocalNode(), null);
            leaderChecker.setCurrentNodes(DiscoveryNodes.EMPTY_NODES);
        assert mode == Mode.LEADER : "should still be leader after sending abdication messages " + mode;
                // update early
            transportService,  
public class Coordinator extends AbstractLifecycleComponent implements Discovery {
                    // acking and cluster state application for local node is handled specially
        // ... and also automatically exclude the node IDs of cluster-manager-ineligible nodes that were previously cluster-manager-eligible
                            "[{}] failed publication as already publication in progress",
    ClusterState getStateForClusterManagerService() {
        synchronized (mutex) {
            configuredHostsResolver
    }
                assert followersChecker.getKnownFollowers().isEmpty();  
                        // if either the localNodeCommissioned flag or the last accepted state thinks it should skip pre voting, we will
        TimeValue.timeValueMillis(30000),
                preVoteCollector.update(getPreVoteResponse(), null);
                        + "[knownNodes="  
            TransportAddressConnector transportAddressConnector,  
                @Override
                    case NODE_LEFT_REASON_FOLLOWER_CHECK_RETRY_FAIL -> "follower.check.fail";
                handleJoin(join);
                    synchronized (mutex) {
    }
                    publishListener.onFailure(
                // If we haven't completely finished becoming cluster-manager then there's already a publication scheduled which will, in
                    if (node.equals(getLocalNode())) {  
    @Nullable  
        final List<DiscoveryNode> nodes = new ArrayList<>();
 *
                    Metadata.builder(clusterState.metadata())
    /**  
        this.localNodeCommissioned = localNodeCommissioned;
    private final Random random;  
            ConfiguredHostsResolver configuredHostsResolver
                    // cluster state update task to become cluster-manager is submitted to ClusterManagerService,
                final Iterable<DiscoveryNode> foundPeers = getFoundPeers();
                            || localNodeCommissioned == false) {
        return peerFinder.getFoundPeers();  
            ActionListener<Void> publishListener
            .map(VotingConfigExclusion::getNodeId)  
        protected void sendPublishRequest(  
        protected void onCompletion(boolean committed) {  
import org.opensearch.cluster.routing.allocation.AllocationService;
import org.opensearch.common.SetOnce;
                final long term = publishRequest.getAcceptedState().term();
import java.util.Collection;  
import org.opensearch.discovery.DiscoveryStats;
                assert leaderChecker.leader() == null : leaderChecker.leader();  
        this.nodeConnectionsService = nodeConnectionsService;
        synchronized (mutex) {
            }  
            namedWriteableRegistry,  
import org.opensearch.common.settings.ClusterSettings;
            electionScheduler = null;
 * GitHub history for details.
        private final ListenableFuture<Void> localNodeAckEvent;  
    }  
                public void run() {
                becomeFollower("handlePublishRequest", sourceNode); // also updates preVoteCollector
                    + " should be in published "
                });
    ClusterState improveConfiguration(ClusterState clusterState) {
            PublishRequest publishRequest,
                assert applierState.nodes().getClusterManagerNodeId() == null;
            } else {
    /**  
                assert getStateForClusterManagerService().nodes().getClusterManagerNodeId() == null : getStateForClusterManagerService();  
    private final NodeHealthService nodeHealthService;
            this::getCurrentTerm,
                        + publishRequest.getAcceptedState().metadata().clusterUUID()
import org.opensearch.common.Nullable;
            transportService,
            }
        final Optional<Join> optionalJoin = joinRequest.getOptionalJoin();  
                }
        closePrevoting();
    }
                    );  
 * @opensearch.internal  
    public ClusterState getApplierState() {
                    processJoinRequest(joinRequest, joinCallback);  
        synchronized (mutex) {
                    }
 * specific language governing permissions and limitations
    }
    }
                assert peerFinderLeader.equals(lastKnownLeader) : peerFinderLeader;
    public static boolean isZen1Node(DiscoveryNode discoveryNode) {
            } else if (joinHelper.isJoinPending()) {
            becomeCandidate("startInitialJoin");  
        return lastAcceptedState.getLastCommittedConfiguration().getNodeIds().contains(nodeId)
        // the logging much harder to follow.  
import org.opensearch.monitor.NodeHealthService;
    private final Reconfigurator reconfigurator;  
            getStateForClusterManagerService(),
    }
                }  
            metadataBuilder.coordinationMetadata(coordinationMetadata);
        closePrevoting();
                        prevotingRound = preVoteCollector.start(lastAcceptedState, discoveredNodes);
    void sendValidateJoinRequest(ClusterState stateForJoinValidation, JoinRequest joinRequest, JoinHelper.JoinCallback joinCallback) {  
            mode,
        return nodes;
            + newClusterManager;
                            return;
            currentPublication.get().cancel(reason);
import static org.opensearch.cluster.coordination.FollowersChecker.NODE_LEFT_REASON_DISCONNECTED;
        }  
                    assert lastPublishedNodes.equals(followersChecker.getKnownFollowers()) : lastPublishedNodes
            assert Thread.holdsLock(mutex) : "Coordinator mutex not held";
            return false;  
            this.publishRequest = publishRequest;
                logger.debug(
        TimeValue.timeValueMillis(1),
        if (getLocalNode().isClusterManagerNode() == false) {  
        synchronized (mutex) {
        @Override  
                                    if (mode == Mode.LEADER) {  
            }  
                onJoinValidators.forEach(a -> a.accept(joinRequest.getSourceNode(), stateForJoinValidation));
                assert leaderChecker.leader() == null : leaderChecker.leader();
                coordinationState.close();  
        if (prevotingRound != null) {
                        )
            }
    }
    );
        Set<String> nodeIdsWithAbsentName = votingConfigExclusions.stream()
        logger.debug(  
        this.publishTimeout = PUBLISH_TIMEOUT_SETTING.get(settings);
                // the cluster-manager service checks if the local node is the cluster-manager node in order to fail execution of the state
                assert clusterFormationFailureHelper.isRunning() == false;  
        assert getLocalNode().isClusterManagerNode() : getLocalNode() + " received a join but is not cluster-manager-eligible";  
        ActionListener<Void> publishListener,
                            public void onFailure(String source, Exception e) {  
                assert clusterFormationFailureHelper.isRunning() == false;
import static org.opensearch.cluster.coordination.FollowersChecker.NODE_LEFT_REASON_FOLLOWER_CHECK_RETRY_FAIL;  
     *
                .nodes(DiscoveryNodes.builder().add(getLocalNode()).localNodeId(getLocalNode().getId()))
        }
                return "scheduling of new prevoting round";  
                assert leaderChecker.currentNodeIsClusterManager() == false;
                            @Override  
    // the timeout before emitting an info log about a slow-running publication
        try {
                    expectedVotes.addVote(Coordinator.this.getLocalNode());  
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;  
        if (remoteClusterStateService != null) {
            // where we would possibly have to remove the NO_MASTER_BLOCK from the applierState when turning a candidate back to follower.  
            final Optional<DiscoveryNode> peerFinderLeader = peerFinder.getLeader();
    private void handleJoin(Join join) {  
                    listener.onFailure(e);
    @Override
            lastKnownLeader  
                            prevotingRound.close();
    }  
                    }  
                    "not enough nodes discovered to form a quorum in the initial configuration "
        }  
                            }  
     * The mode of the coordinator.
        if (mode != Mode.CANDIDATE) {
        return clusterState;
                );  
        if (improveConfiguration(state) != state && reconfigurationTaskScheduled.compareAndSet(false, true)) {
        private final Scheduler.ScheduledCancellable timeoutHandler;  
                        () -> new ParameterizedMessage(
                    ClusterStateTaskConfig.build(Priority.IMMEDIATE),  
                }
            peerFinder.getLastResolvedAddresses(),
                        }  
        assert publishRequest.getAcceptedState().nodes().getLocalNode().equals(getLocalNode()) : publishRequest.getAcceptedState()
                                    updateMaxTermSeen(getCurrentTerm());
                    logger.debug("reconfiguration failed", e);
        Supplier<CoordinationState.PersistedState> persistedStateSupplier,  
            publishListener.onFailure(new FailedToCommitClusterStateException("publishing failed", e));  
                leaderNode,
            assert Thread.holdsLock(mutex) : "Coordinator mutex not held";
    private final PeerFinder peerFinder;
                Strings.toString(MediaTypeRegistry.JSON, event.previousState()),
                    }
import org.opensearch.cluster.coordination.ClusterFormationFailureHelper.ClusterFormationState;
import org.opensearch.core.transport.TransportResponse.Empty;
            assert coordinationState.get().joinVotesHaveQuorumFor(newConfig);
    * 1. Every voting config exclusion with an ID of _absent_ should not match any nodes currently in the cluster by name
            logger.info("setting initial configuration to {}", votingConfiguration);
import org.apache.logging.log4j.LogManager;
                && mode == Mode.FOLLOWER
            @Override
            return new PublishWithJoinResponse(
                    final FailedToCommitClusterStateException exception = new FailedToCommitClusterStateException("publication failed", e);  
        peerFinder.getFoundPeers().forEach(nodes::add);  
        NamedWriteableRegistry namedWriteableRegistry,  
        LEADER,
    private void closePrevoting() {  
            ClusterState initialState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.get(settings))
            } else {
                    publishListener
        "cluster.publish.info_timeout",
                    ackListener.onCommit(commitTime);  
                updateMaxTermSeen(term + 1);
            return join;  
        }
        assert leaderChecker.leader() == null : leaderChecker.leader();
        } else {  
import org.opensearch.common.Priority;  
                        () -> applierState,  
                becomeFollower("onFollowerCheckRequest", followerCheckRequest.getSender());
                        logger.debug("updateMaxTermSeen: maxTermSeen = {} > currentTerm = {}, bumping term", maxTermSeen, currentTerm);  
        }
        }  
                    e
import org.opensearch.discovery.DiscoveryModule;
import static org.opensearch.cluster.ClusterManagerMetrics.REASON_TAG;
                        + followersChecker.getKnownFollowers();
                stats.add(persistedStateRegistry.getPersistedState(stateType).getStats());  
                        }  
                );
            }  
                    assert false : "[" + currentPublication.get() + "] in progress, cannot start new publication";
            } else {
            joinAccumulator = joinHelper.new CandidateJoinAccumulator();
    ) {  
        }
            if (singleNodeDiscovery
                        new ClusterApplyListener() {
    }
    private boolean handleJoinIgnoringExceptions(Join join) {
                assert joinAccumulator instanceof JoinHelper.CandidateJoinAccumulator;  
                        if (nodeCommissioned(lastAcceptedState.nodes().getLocalNode(), lastAcceptedState.metadata()) == false
                        .getLastAcceptedConfiguration()
    DiscoveryNode getLocalNode() {
        assert Thread.holdsLock(mutex) : "Coordinator mutex not held";  
        this.joinAccumulator = new InitialJoinAccumulator();
                    publishListener.onFailure(
 * Unless required by applicable law or agreed to in writing,
            DiscoveryNode destination,
    private AtomicBoolean reconfigurationTaskScheduled = new AtomicBoolean();  
                // since we check whether a term bump is needed at the end of the publication too.
                public void onFailure(Exception e) {
                        .equals(coordinationState.get().getLastCommittedConfiguration()) : coordinationState.get()
        );
        assert Thread.holdsLock(mutex) : "Coordinator mutex not held";  
                public ClusterState execute(ClusterState currentState) {  
 * SPDX-License-Identifier: Apache-2.0
    private NodeConnectionsService nodeConnectionsService;
                );  
                                                        state.getLastCommittedConfiguration(),
            }  
    }
        if (singleNodeDiscovery && joinRequest.getSourceNode().equals(getLocalNode()) == false) {  
            nodeHealthService.getHealth()
        clusterFormationFailureHelper.stop();  
    public void startInitialJoin() {  
            this.onJoinValidators,  
import org.opensearch.cluster.ClusterChangedEvent;
                                                    // to abdicate to it. Assume that every node that completed the publication can provide
import java.util.Set;  
 * the Apache License, Version 2.0 (the "License"); you may
            return coordinationState.get().handleJoin(join);  
                    // This is cleaned up to avoid stale entries which would block future reconnections
            mode = Mode.FOLLOWER;
                logger.info(new ParameterizedMessage("cluster-manager node [{}] failed, restarting discovery", lastKnownLeader.get()), e);  
    private void closePrevotingAndElectionScheduler() {
        }
                                                abdicateTo(clusterManagerCandidates.get(random.nextInt(clusterManagerCandidates.size())));
 *  
            }, transportService.getThreadPool()::relativeTimeInMillis);  
        synchronized (mutex) {  
            } else {  
                // schedule a reconfiguration if needed. It's benign to schedule a reconfiguration anyway, but it might fail if it wins the
                    );
