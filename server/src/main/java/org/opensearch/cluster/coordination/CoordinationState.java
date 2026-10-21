    }
            );
        if (applyCommit.getVersion() != getLastAcceptedVersion()) {
    private long lastPublishedVersion;
        }
 */
     * @return A PublishRequest to publish the given cluster state
            logger.debug(
        }
            throw new CoordinationStateRejectedException("ignored join as term has not been incremented yet after reboot");
                getCurrentTerm(),
            }
 * software distributed under the License is distributed on an
         * After a successful call to this method, {@link #getLastAcceptedState()} should return the last cluster state that was set,
                lastPublishedVersion,
                "handleClientValue: ignored request due to version mismatch "
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRemoteStoreClusterStateEnabled;
         */
        default Metadata.Builder commitVotingConfiguration(ClusterState lastAcceptedState) {
        assert getLastCommittedConfiguration().isEmpty() : getLastCommittedConfiguration();
        private final Set<Join> joins;
        public String toString() {
    // used for tests
     */
/*
    /**
        if (lastAcceptedConfiguration.isEmpty() == false) {
    public long getLastPublishedVersion() {
     * @param publishRequest The publish request received.
                if (metadataBuilder == null) {
            throw new CoordinationStateRejectedException(
        assert publishVotes.isEmpty() || electionWon();
    }
         * After a successful call to this method, {@link #getLastAcceptedState()} should return the last cluster state that was set.
            sourceNode
        assert initialState.version() == getLastAcceptedVersion() : initialState + " should have version " + getLastAcceptedVersion();
        public int hashCode() {
            getLastAcceptedTerm(),
        assert lastPublishedVersion == 0 : lastPublishedVersion;
            getCurrentTerm(),
     */
            VoteCollection that = (VoteCollection) o;
            );
                "handleCommit: ignored commit request due to term mismatch "
                "handleClientValue: ignored request due to term mismatch "
            electionWon,
        this.electionWon = false;
            );
        this.isRemoteStateEnabled = isRemoteStoreClusterStateEnabled(settings);
        DiscoveryNode localNode,
    public PublishResponse handlePublishRequest(PublishRequest publishRequest) {
                }
        @Override
    private static final Logger logger = LogManager.getLogger(CoordinationState.class);
         * Returns the stats for the persistence layer for {@link CoordinationState}.
                    + " of join higher than current last accepted version "
     * @return An optional ApplyCommitRequest which, if present, may be broadcast to all peers, indicating that this publication
            );
            final ClusterState lastAcceptedState = getLastAcceptedState();
                clusterState.version()
                "incoming last accepted term "
/*
     * @param join The Join received.
 * <a href="https://github.com/elastic/elasticsearch-formal-models/blob/master/ZenWithTerms/tla/ZenWithTerms.tla">formal model</a>
            && persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).getLastAcceptedManifest() != null;
                .setLastAcceptedManifest(((RemoteStatePublishRequest) publishRequest).getAcceptedManifest());
        }
                getLastAcceptedVersion(),
            logger.debug("handleJoin: ignored join due to term mismatch (expected: [{}], actual: [{}])", getCurrentTerm(), join.getTerm());
 */
            "locaNode= " + localNode + ", join=" + join + ", joinVotes=" + joinVotes;
import org.opensearch.cluster.ClusterState;
                || lastAcceptedState.term() == ZEN1_BWC_TERM : "received cluster state with empty cluster uuid but not Zen1 BWC term: "
            );
                "handlePublishResponse: ignored publish response due to version mismatch (expected: [{}], actual: [{}])",
        joinVotes = new VoteCollection();
            .getLastAcceptedConfiguration();
    private final PersistedStateRegistry persistedStateRegistry;
            throw new CoordinationStateRejectedException(
        assert getCurrentTerm() == startJoinRequest.getTerm();
         */
        /**
        @Override
     * @param initialState The initial state to use. Must have term 0, version equal to the last-accepted version, and non-empty
import org.opensearch.cluster.metadata.Metadata;
            throw new CoordinationStateRejectedException(
        if (join.getLastAcceptedTerm() > lastAcceptedTerm) {
                publishResponse.getVersion(),
            return Collections.unmodifiableCollection(nodes.values());
                reason = "bumping term";
            // if we receive a commit from a Zen1 cluster-manager that has not recovered its state yet,
            Metadata.Builder metadataBuilder = commitVotingConfiguration(lastAcceptedState);
            return metadataBuilder;
        logger.trace(
            getLastAcceptedTerm(),
                "incoming term " + clusterState.term() + " does not match current term " + getCurrentTerm()
                "incoming term " + applyCommit.getTerm() + " does not match last accepted term " + getLastAcceptedTerm()
        return new Join(
        default void setLastAcceptedManifest(ClusterMetadataManifest manifest) {}
            clusterState.term()
            );
                    metadataBuilder = Metadata.builder(lastAcceptedState.metadata());
                    .lastCommittedConfiguration(lastAcceptedState.getLastAcceptedConfiguration())
                .getLastAcceptedState()
            logger.debug("handlePublishResponse: ignored response as election not won");
                "incoming term " + applyCommit.getTerm() + " does not match current term " + getCurrentTerm()
        // Publishing the current state to remote store before sending the cluster state to other nodes.
        assert getLastCommittedConfiguration().equals(getLastAcceptedConfiguration());
            result = 31 * result + joins.hashCode();
    // persisted state registry
                lastPublishedVersion,
                "incoming term " + join.getTerm() + " does not match current term " + getCurrentTerm()
    /**
         * After a successful call to this method, {@link #getCurrentTerm()} should return the last term that was set.
    private final ElectionStrategy electionStrategy;
     *
        }
            throw new CoordinationStateRejectedException(
    }
        } else {
    private boolean shouldCommitRemotePersistedState() {
        }
                "handlePublishRequest: ignored publish request due to term mismatch (expected: [{}], actual: [{}])",
            lastPublishedVersion = getLastAcceptedVersion();
        }
            } else if (startJoinRequest.getSourceNode().equals(localNode)) {
    }
    }
                "incoming cluster state version "
        persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL).markLastAcceptedStateAsCommitted();
}
            throw new CoordinationStateRejectedException(
            throw new CoordinationStateRejectedException(
        }
    public PublishRequest handleClientValue(ClusterState clusterState) {
    public static class VoteCollection {
            publishResponse.getVersion(),
    /**
            : "last committed configuration should not change";
import org.opensearch.common.settings.Settings;
        }
            return sourceNode.isClusterManagerNode() && nodes.put(sourceNode.getId(), sourceNode) == null;
        logger.debug("handleStartJoin: leaving term [{}] due to {}", getCurrentTerm(), startJoinRequest);
        if (electionWon && prevElectionWon == false) {
     * @param startJoinRequest The startJoinRequest, specifying the node requesting the join.
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
        if (join.getTerm() != getCurrentTerm()) {
        }
            getLastAcceptedConfiguration(),
        }
                "incoming last accepted version "
    }
                reason = "standing down as leader";
            }
            if (lastAcceptedState.metadata().clusterUUID().equals(Metadata.UNKNOWN_CLUSTER_UUID) == false
        // Publishing the committed state to remote store before sending apply commit to other nodes.
         * Marks the last accepted cluster state as committed.
        /**
            logger.debug(
            if (!nodes.equals(that.nodes)) return false;
                publishResponse.getVersion()
                applyCommit.getVersion()
            nodes = new HashMap<>();
        public boolean addJoinVote(Join join) {
        return electionWon;
    }
                final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder(lastAcceptedState.coordinationMetadata())
import org.apache.logging.log4j.Logger;
        public boolean containsVoteFor(DiscoveryNode node) {
        }
        }
            assert getLastPublishedVersion() >= getLastAcceptedVersion();
            // We do not check for an election won on setting the initial configuration, so it would be possible to end up in a state where
                publishResponse.getTerm()
        return getLastAcceptedState().version();
        // This is to ensure the remote store is the single source of truth for current state. Even if the current node
    ) {
        }
     */
        }
 * KIND, either express or implied.  See the License for the
        assert lastPublishedConfiguration.isEmpty() : lastPublishedConfiguration;
        public Set<Join> getJoins() {
        public boolean equals(Object o) {
            );
        lastPublishedVersion = 0;
            );
            );
    private VotingConfiguration lastPublishedConfiguration;
    public void handleCommit(ApplyCommitRequest applyCommit) {
     * May be safely called at any time to move this instance to a new term.
        }
    public long getLastAcceptedTerm() {
    public CoordinationState(
            throw new CoordinationStateRejectedException(
        assert publishVotes.isEmpty() : publishVotes;
            persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).setLastAcceptedManifest(null);
        assert getLastAcceptedTerm() == 0 : getLastAcceptedTerm();
        logger.trace(
                getLastAcceptedVersion(),
                "initial state already set: last-accepted configuration now " + lastAcceptedConfiguration
                getCurrentTerm(),
            if (clusterState.term() == ZEN1_BWC_TERM
    private final DiscoveryNode localNode;
        if (shouldUpdateRemotePersistedState(publishRequest)) {
                    + lastPublishedVersion
                setLastAcceptedState(ClusterState.builder(lastAcceptedState).metadata(metadataBuilder).build());
                }
        } else {
     * @throws CoordinationStateRejectedException if the arguments were incompatible with the current state of this object.
            "handlePublishResponse: accepted publish response for version [{}] and term [{}] from [{}]",
        }
            logger.debug("handleClientValue: only allow reconfiguration while not already reconfiguring");
            logger.debug(
        assert initialState.term() == 0 : initialState + " should have term 0";
        if (clusterState.term() == getLastAcceptedTerm() && clusterState.version() <= getLastAcceptedVersion()) {
     *
        /**
    public void handlePreCommit() {
    public boolean containsJoinVoteFor(DiscoveryNode node) {
        return joinVotes.isQuorum(votingConfiguration);
        }
            lastAcceptedTerm,
            return Collections.unmodifiableSet(joins);
                clusterState.term(),
                    + " in term "
            }
                metadataBuilder.coordinationMetadata(coordinationMetadata);
         */
        return votes.isQuorum(getLastCommittedConfiguration()) && votes.isQuorum(lastPublishedConfiguration);
        );
            throw new CoordinationStateRejectedException("rejecting join since this node has not received its initial configuration yet");
        if (clusterState.getLastAcceptedConfiguration().equals(getLastAcceptedConfiguration()) == false
     * May be called on receipt of a PublishRequest.
            if (electionWon == false) {
        assert !prevElectionWon || electionWon : // we cannot go from won to not won
     * @return A PublishResponse which can be sent back to the sender of the PublishRequest.
        assert initialState.getLastCommittedConfiguration().isEmpty() == false;
        return persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL).getLastAcceptedState();
        this.lastPublishedVersion = 0L;
     * @throws CoordinationStateRejectedException if the arguments were incompatible with the current state of this object.
    private boolean shouldUpdateRemotePersistedState(PublishRequest publishRequest) {
    private void updateRemotePersistedStateOnPublishRequest(PublishRequest publishRequest) {
            }
     * @throws CoordinationStateRejectedException if the arguments were incompatible with the current state of this object.
        this.persistedStateRegistry = persistedStateRegistry;
    }
    }
            throw new CoordinationStateRejectedException("cannot start publishing next value before accepting previous one");
            logger.debug("handleJoin: rejecting join since this node has not received its initial configuration yet");
                publishResponse.getTerm()
            throw new CoordinationStateRejectedException(
         * @return The last accepted {@link ClusterMetadataManifest}, or null if no manifest
                "incoming version " + publishResponse.getVersion() + " does not match current version " + lastPublishedVersion
            // so instead we just reject join votes received prior to receiving the initial configuration.
        void setCurrentTerm(long currentTerm);
        }
            join,
     */
                startJoinRequest,
                .isLocalNodeElectedClusterManager() == false
     */
        lastPublishedConfiguration = clusterState.getLastAcceptedConfiguration();
            );
    }
                if (lastAcceptedState.term() != ZEN1_BWC_TERM) {
                    // Zen1 cluster-managers never publish a committed cluster UUID so if we logged this it'd happen on on every update.
     */
     * A collection of votes, used to calculate quorums. Optionally records the Joins as well.
            }
import java.util.Collection;
        void setLastAcceptedState(ClusterState clusterState);
 *
     *
        }
        assert join.targetMatches(localNode) : "handling join " + join + " for the wrong node " + localNode;
        // persisted state registry
            joins = new HashSet<>();
            return result;
            updateRemotePersistedStateOnPublishRequest(publishRequest);
 * this work for additional information regarding copyright
        publishVotes = new VoteCollection();
                join.getLastAcceptedTerm()
         * Returns the current term
 */
            );
        if (applyCommit.getTerm() != getCurrentTerm()) {
import org.opensearch.gateway.remote.ClusterMetadataManifest;
        if (isPublishQuorum(publishVotes)) {
        Settings settings
import org.opensearch.cluster.coordination.PersistedStateRegistry.PersistedStateType;
import org.opensearch.cluster.node.DiscoveryNode;
         * @return PersistedStateStats
     */
    private boolean startedJoinSinceLastReboot;
 * Modifications Copyright OpenSearch Contributors. See
            if (lastAcceptedState.getLastAcceptedConfiguration().equals(lastAcceptedState.getLastCommittedConfiguration()) == false) {
        assert clusterState.getLastCommittedConfiguration().equals(getLastCommittedConfiguration())
            logger.debug("handleJoin: election won in term [{}] with {}", getCurrentTerm(), joinVotes);
            persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).markLastAcceptedStateAsCommitted();
     *
        }
 * You may obtain a copy of the License at
         */
    private VoteCollection publishVotes;
                "handlePublishResponse: value committed for version [{}] and term [{}]",
        assert electionWon == false;
        if (startJoinRequest.getTerm() <= getCurrentTerm()) {
            getLastAcceptedVersion()
    }
                    + "(expected: [term {} version {}], actual: [term {} version {}])",
                && clusterState.nodes().getClusterManagerNode().equals(getLastAcceptedState().nodes().getClusterManagerNode()) == false) {
 * Unless required by applicable law or agreed to in writing,
        }
                logger.debug(
         * with the last committed configuration now corresponding to the last accepted configuration, and the cluster uuid, if set,
 * under the License.
    private final boolean isRemoteStateEnabled;
            );
                getLastAcceptedVersionOrMetadataVersion(),
        this.lastPublishedConfiguration = persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL)
        if (clusterState.term() != getCurrentTerm()) {
        if (publishResponse.getVersion() != lastPublishedVersion) {
        }
    private boolean electionWon;
        );
 *
                applyCommit.getVersion()
                    + clusterState.version()
        default void close() throws IOException {}
        publishVotes.addVote(sourceNode);
        return new PublishResponse(clusterState.term(), clusterState.version());
        }
            // We will end up here if PublishRequest was sent not using Remote Store even with remote persisted state on this node
        // goes down after sending the cluster state to other nodes, we should be able to read the remote state and
            final String reason;
        }
        this.electionStrategy = electionStrategy;
            throw new CoordinationStateRejectedException(
                    logger.info("cluster UUID set to [{}]", lastAcceptedState.metadata().clusterUUID());
                joins.add(join);
            logger.debug("handleClientValue: only allow reconfiguration if joinVotes have quorum for new config");
            handlePreCommit();
    }
        PersistedStateStats getStats();
        }
    }
        if (clusterState.version() <= lastPublishedVersion) {
            logger.debug(
     * Pluggable persistence layer for {@link CoordinationState}.
            );
            join.getSourceNode(),
    public ClusterState getLastAcceptedState() {
            applyCommit.getTerm(),
     * May be called on receipt of an ApplyCommitRequest. Updates the committed configuration accordingly.
 *
            } else {
        if (lastPublishedVersion != getLastAcceptedVersion()) {
            throw new CoordinationStateRejectedException("only allow reconfiguration while not already reconfiguring");
                getLastAcceptedVersion(),
     * @param publishResponse The PublishResponse received.
                    + "(expected: [term {} version >{}], actual: [term {} version {}])",
        boolean added = joinVotes.addJoinVote(join);
                "handlePublishResponse: ignored publish response due to term mismatch (expected: [{}], actual: [{}])",
        }
                clusterState.version()
        assert getLastAcceptedState() == clusterState;
import java.util.Map;
         */
                    "handling publish request in compatibility mode despite version mismatch (expected: >[{}], actual: [{}])",
    }
    }
            final boolean added = addVote(join.getSourceNode());
        if (shouldCommitRemotePersistedState()) {
            throw new CoordinationStateRejectedException(
        this.startedJoinSinceLastReboot = false;
         * marked as committed.
            assert getLastPublishedVersion() == 0L;
        if (electionWon == false) {
        }
        return persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL).getCurrentTerm();
         * Returns the last accepted cluster state
import java.io.IOException;
     *
                    + lastAcceptedTerm
            logger.debug(
     * This method should be called just before sending the ApplyCommitRequest to all cluster nodes.
        return getLastAcceptedState().getLastAcceptedConfiguration();
                );
            logger.debug(
            .getLastAcceptedState()
            );
        long getCurrentTerm();
        }
    private long getLastAcceptedVersionOrMetadataVersion() {
 * SPDX-License-Identifier: Apache-2.0
     *
         */
        logger.trace(
            );
        );
    }
        if (publishResponse.getTerm() != getCurrentTerm()) {
            // complicated to restore all the appropriate invariants when setting the initial configuration (it's not just electionWon)
        assert getLastAcceptedTerm() <= getCurrentTerm();
    }
        if (publishRequest instanceof RemoteStatePublishRequest) {
            getLastCommittedConfiguration(),
        return persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE) != null
     */
 * not use this file except in compliance with the License.
     * @throws CoordinationStateRejectedException if the arguments were incompatible with the current state of this object.
            logger.debug(
            );
        persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL).setLastAcceptedState(clusterState);
    }
     * This method should be called just before sending the PublishRequest to all cluster nodes.
                lastAcceptedTerm
        return joinVotes.containsVoteFor(node);
        }
     * @param sourceNode      The sender of the PublishResponse received.
            logger.debug("setInitialState: rejecting since last-accepted configuration is nonempty: {}", lastAcceptedConfiguration);
     * @return true iff this instance does not already have a join vote from the given source node for this term
            logger.debug(
                "handleJoin: ignored join as joiner has a better last accepted term (expected: <=[{}], actual: [{}])",
    /**
        return new PublishRequest(clusterState);
        public boolean isEmpty() {
        }
            && persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL)
            joinVotes
                    getLastAcceptedVersion(),
    public void invariant() {
                getCurrentTerm(),
            throw new CoordinationStateRejectedException(
        IOUtils.close(persistedStateRegistry);
                logger.debug(
        lastPublishedVersion = clusterState.version();
        }
                    // Let's just
            return "VoteCollection{votes=" + nodes.keySet() + ", joins=" + joins + "}";
                    .build();
    }
    }
                .getNodes()
                );
        }
                    clusterState.version()
        if (clusterState.term() != getCurrentTerm()) {
        electionWon = isElectionQuorum(joinVotes);
import java.io.Closeable;
                && lastAcceptedState.metadata().clusterUUIDCommitted() == false) {
         *
            );
                );
    }
 * The core class of the cluster state coordination algorithm, directly implementing the
                    getLastAcceptedVersion(),
            throw new CoordinationStateRejectedException("election not won");
        if (join.getLastAcceptedTerm() == lastAcceptedTerm && join.getLastAcceptedVersion() > getLastAcceptedVersionOrMetadataVersion()) {
        return getLastAcceptedState().getVersionOrMetadataVersion();
            throw new CoordinationStateRejectedException(
        }
            logger.debug(
            throw new CoordinationStateRejectedException(
            persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).markLastAcceptedStateAsCommitted();
        public VoteCollection() {
        final ClusterState clusterState = publishRequest.getAcceptedState();
import java.util.HashMap;
            throw new CoordinationStateRejectedException("election not won");
        @Override
            logger.debug("handleClientValue: cannot start publishing next value before accepting previous one");
        assert electionWon() == false || startedJoinSinceLastReboot;
import static org.opensearch.cluster.coordination.Coordinator.ZEN1_BWC_TERM;
    /**
import java.util.Collections;
            clusterState.version(),
            logger.debug(
                "handleStartJoin: ignoring [{}] as term provided is not greater than current term [{}]",
        if (electionWon == false) {
    }
     * @param clusterState The cluster state to publish.
        }
import java.util.Optional;
     *
    }
     * @throws CoordinationStateRejectedException if the arguments were incompatible with the current state of this object.
        }
    public boolean isPublishQuorum(VoteCollection votes) {
                clusterState.term()
        default void markLastAcceptedStateAsCommitted() {
    boolean containsJoin(Join join) {
        if (isRemoteStateEnabled) {
    public boolean electionWon() {
            localNode,
        persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL).setCurrentTerm(startJoinRequest.getTerm());
            persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).setLastAcceptedState(null);
        final long lastAcceptedTerm = getLastAcceptedTerm();
            } else {
/*
 * ownership. Elasticsearch licenses this file to you under
    private VoteCollection joinVotes;
            logger.debug("handleStartJoin: discarding {}: {}", joinVotes, reason);
        this.joinVotes = new VoteCollection();
                    + getLastAcceptedVersionOrMetadataVersion()
 *     http://www.apache.org/licenses/LICENSE-2.0
        return electionStrategy.isElectionQuorum(
     *
                metadataBuilder.clusterUUIDCommitted(true);
     * May be called on receipt of a PublishResponse from the given sourceNode.
        electionWon = false;
            && getLastCommittedConfiguration().equals(getLastAcceptedConfiguration()) == false) {
        lastPublishedConfiguration = getLastAcceptedConfiguration();
 * specific language governing permissions and limitations
            "handlePublishRequest: accepting publish request for version [{}] and term [{}]",
            logger.trace(
            "handleJoin: added join {} from [{}] for election, electionWon={} lastAcceptedTerm={} lastAcceptedVersion={}",
import org.apache.logging.log4j.LogManager;
                getLastAcceptedTerm(),
            assert persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE) != null : "Remote state has not been initialized";
        }
                lastAcceptedTerm,
        final VotingConfiguration lastAcceptedConfiguration = getLastAcceptedConfiguration();
        startedJoinSinceLastReboot = true;
        public boolean addVote(DiscoveryNode sourceNode) {
            int result = nodes.hashCode();
    public interface PersistedState extends Closeable {
     * @opensearch.internal
            getCurrentTerm(),
 * compatible open source license.
        if (startedJoinSinceLastReboot == false) {
     */
    public long getCurrentTerm() {
import java.util.Set;
        boolean prevElectionWon = electionWon;
    public void setInitialState(ClusterState initialState) {
            localNode,
     *                     configurations.
        }
                    "handlePublishRequest: ignored publish request due to version mismatch (expected: >[{}], actual: [{}])",
            // return null by default, this method needs to be overridden wherever required
            "handleCommit: applying commit request for term [{}] and version [{}]",
 * license agreements. See the NOTICE file distributed with
    public boolean isElectionQuorum(VoteCollection joinVotes) {
     * @throws CoordinationStateRejectedException if the arguments were incompatible with the current state of this object.
            );
    public VotingConfiguration getLastCommittedConfiguration() {
    public Optional<ApplyCommitRequest> handlePublishResponse(DiscoveryNode sourceNode, PublishResponse publishResponse) {
                metadataBuilder = Metadata.builder(lastAcceptedState.metadata());
                "handleJoin: ignored join as joiner has a better last accepted version (expected: <=[{}], actual: [{}]) in term {}",
        this.publishVotes = new VoteCollection();
            return null;
                join.getLastAcceptedVersion(),
                throw new CoordinationStateRejectedException(
        /**
            publishResponse.getTerm(),
     *
    }
                applyCommit.getVersion()
     * @return A Join that should be sent to the target node of the join.
        /**
                "handleCommit: ignored commit request due to term mismatch "
     * @param applyCommit The ApplyCommitRequest received.
 * this file be licensed under the Apache-2.0 license or a
                "incoming term " + publishResponse.getTerm() + " does not match current term " + getCurrentTerm()
            if (!(o instanceof VoteCollection)) return false;
/**
        return joinVotes.getJoins().contains(join);
         * The value returned by {@link #getLastAcceptedState()} should not be influenced by calls to this method.
            applyCommit.getVersion()
            // the cluster uuid might not been known yet.
            );
    /**
            persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).setLastAcceptedState(clusterState);
            if (metadataBuilder != null) {
            );
        if (applyCommit.getTerm() != getLastAcceptedTerm()) {
            );
            persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE)
        }
        // recover the cluster.
        assert initialState.getLastAcceptedConfiguration().isEmpty() == false;
            );
    public boolean handleJoin(Join join) {
            logger.debug("handleClientValue: ignored request as election not won");
        public boolean isQuorum(VotingConfiguration configuration) {
        public Collection<DiscoveryNode> nodes() {
        assert joinVotes.isEmpty() : joinVotes;
         * Sets a new current term.
     * @param clusterState The cluster state for which pre publish activities should happen.
                    clusterState.version()
        persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL).setLastAcceptedState(initialState);
         */
        );
                getCurrentTerm(),
            return added;
            && publishRequest.getAcceptedState().getNodes().isLocalNodeElectedClusterManager() == false;
        if (isRemoteStateEnabled) {
            if (this == o) return true;
        assert electionWon() == isElectionQuorum(joinVotes);
    }
                getLastAcceptedTerm(),
import java.util.HashSet;
    }
                "incoming term " + startJoinRequest.getTerm() + " not greater than current term " + getCurrentTerm()
                    // not log it at all in a 6.8/7.x rolling upgrade.
        return Optional.empty();
        this.localNode = localNode;
    public long getLastAcceptedVersion() {
                applyCommit.getTerm(),
        return added;
                    "incoming version " + clusterState.version() + " lower or equal to current version " + getLastAcceptedVersion()
        );
     * @opensearch.internal
    }
     * @throws CoordinationStateRejectedException if the arguments were incompatible with the current state of this object.
    public void close() throws IOException {
    // transient state
 *
     */
            return Optional.of(new ApplyCommitRequest(localNode, publishResponse.getTerm(), publishResponse.getVersion()));
        }
                "handleCommit: ignored commit request due to version mismatch (term {}, expected: [{}], actual: [{}])",
        if (getLastAcceptedConfiguration().isEmpty()) {
                    + " of join higher than current last accepted term "
         * Returns the last accepted {@link ClusterMetadataManifest}.
        if (joinVotesHaveQuorumFor(clusterState.getLastAcceptedConfiguration()) == false) {
     * May be called on receipt of a Join.
                    + lastAcceptedState;
 * The OpenSearch Contributors require contributions made to
        return getLastAcceptedState().term();
        }
 */
        return persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE) != null
                clusterState.term(),
         * Sets a new last accepted cluster state.
            throw new CoordinationStateRejectedException("only allow reconfiguration if joinVotes have quorum for new config");
        );
            return nodes.isEmpty();
    }
    /**
import org.opensearch.common.util.io.IOUtils;
        }
     * May be called in order to prepare publication of the given cluster state
    public void handlePrePublish(ClusterState clusterState) {
            assert persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE) != null : "Remote state has not been initialized";
                    + lastAcceptedTerm
    }
        publishVotes = new VoteCollection();
            logger.debug("handleJoin: ignored join as term was not incremented yet after reboot");
            );
                "incoming term " + clusterState.term() + " does not match current term " + getCurrentTerm()
            getLastAcceptedVersion(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        /**
        PersistedStateRegistry persistedStateRegistry,
        }
    }
            persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).setLastAcceptedState(publishRequest.getAcceptedState());
            assert lastAcceptedState.metadata().clusterUUID().equals(Metadata.UNKNOWN_CLUSTER_UUID) == false
                getCurrentTerm()
        }
            Metadata.Builder metadataBuilder = null;
            return configuration.hasQuorum(nodes.keySet());
            logger.debug(
        /**
            // we have enough join votes to have won the election immediately on setting the initial configuration. It'd be quite
        private final Map<String, DiscoveryNode> nodes;
            return nodes.containsKey(node.getId());
                "incoming version " + applyCommit.getVersion() + " does not match current version " + getLastAcceptedVersion()
                    + "(expected: [term {} version {}], actual: [term {} version {}])",
    /**
 * the Apache License, Version 2.0 (the "License"); you may
        return lastPublishedVersion;
        /**
        ElectionStrategy electionStrategy,
                    + " lower or equal to last published version "
    }
        }
            startJoinRequest.getSourceNode(),
                lastPublishedVersion,
                getLastAcceptedTerm(),
        return getLastAcceptedState().getLastCommittedConfiguration();
        // transient state
            && persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).getLastAcceptedState() != null
            );
                applyCommit.getTerm(),
 * Licensed to Elasticsearch under one or more contributor
    public Join handleStartJoin(StartJoinRequest startJoinRequest) {
         */
        if (electionWon()) {
 * @opensearch.internal
    /**
            }
 * GitHub history for details.
                    + "(expected: [term {} version >{}], actual: [term {} version {}])",
            return joins.equals(that.joins);
        logger.trace("handleClientValue: processing request for version [{}] and term [{}]", lastPublishedVersion, getCurrentTerm());
                reason = "failed election";
            );
    /**
         *         has been accepted yet.
        default ClusterMetadataManifest getLastAcceptedManifest() {
                    + join.getLastAcceptedVersion()
         * The value returned by {@link #getCurrentTerm()} should not be influenced by calls to this method.
     * has been accepted at a quorum of peers and is therefore committed.
    public boolean joinVotesHaveQuorumFor(VotingConfiguration votingConfiguration) {
         * Sets the last accepted {@link ClusterMetadataManifest}.
            getLastAcceptedVersionOrMetadataVersion()
    public VotingConfiguration getLastAcceptedConfiguration() {
            if (added) {
    /**
     */
        logger.debug(
public class CoordinationState {
        ClusterState getLastAcceptedState();
        if (joinVotes.isEmpty() == false) {
     * Used to bootstrap a cluster by injecting the initial state and configuration.
package org.opensearch.cluster.coordination;
                    + join.getLastAcceptedTerm()
