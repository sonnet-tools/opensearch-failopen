            && getLastCommittedConfiguration().equals(getLastAcceptedConfiguration()) == false) {  
            // We do not check for an election won on setting the initial configuration, so it would be possible to end up in a state where
        public VoteCollection() {
        } else {
        this.localNode = localNode;
                    + join.getLastAcceptedVersion()
            }  
                "handlePublishResponse: value committed for version [{}] and term [{}]",
            throw new CoordinationStateRejectedException("election not won");
import java.util.HashMap;  
        void setCurrentTerm(long currentTerm);
                joins.add(join);
            return Optional.of(new ApplyCommitRequest(localNode, publishResponse.getTerm(), publishResponse.getVersion()));  
        assert publishVotes.isEmpty() : publishVotes;  
            result = 31 * result + joins.hashCode();  
     * May be called on receipt of a PublishRequest.
        }
        assert getCurrentTerm() == startJoinRequest.getTerm();
    public boolean containsJoinVoteFor(DiscoveryNode node) {  
        if (clusterState.term() == getLastAcceptedTerm() && clusterState.version() <= getLastAcceptedVersion()) {
            throw new CoordinationStateRejectedException(
            throw new CoordinationStateRejectedException(
         * Returns the stats for the persistence layer for {@link CoordinationState}.  
            }  
            );
         */
        // Publishing the committed state to remote store before sending apply commit to other nodes.
        default ClusterMetadataManifest getLastAcceptedManifest() {
import org.opensearch.cluster.ClusterState;
        logger.trace(  
 * GitHub history for details.
    }
                    + " of join higher than current last accepted term "  
            );  
        }
/*
        if (isPublishQuorum(publishVotes)) {
            if (this == o) return true;  
            throw new CoordinationStateRejectedException(  
            return configuration.hasQuorum(nodes.keySet());
    private VoteCollection joinVotes;  
            logger.debug(
            && persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).getLastAcceptedManifest() != null;
    /**
        if (startJoinRequest.getTerm() <= getCurrentTerm()) {  
                .getLastAcceptedState()  
            } else {  
        publishVotes.addVote(sourceNode);
        }
        }
                );
                    .build();
                }
import java.util.Collections;
        /**
import org.opensearch.cluster.metadata.Metadata;
        }
                    + lastPublishedVersion
        }
     *                     configurations.
            VoteCollection that = (VoteCollection) o;  
    }
                "incoming term " + clusterState.term() + " does not match current term " + getCurrentTerm()
        public boolean addJoinVote(Join join) {
                clusterState.term(),
        if (applyCommit.getTerm() != getCurrentTerm()) {
                );
    public void handleCommit(ApplyCommitRequest applyCommit) {  
 *  
        this.startedJoinSinceLastReboot = false;
        this.persistedStateRegistry = persistedStateRegistry;
            localNode,
        if (publishResponse.getTerm() != getCurrentTerm()) {
        boolean added = joinVotes.addJoinVote(join);
     * May be called on receipt of a Join.
                    getLastAcceptedVersion(),  
    // used for tests
     * @throws CoordinationStateRejectedException if the arguments were incompatible with the current state of this object.  
            // we have enough join votes to have won the election immediately on setting the initial configuration. It'd be quite  
                reason = "failed election";
                reason = "standing down as leader";
            persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).markLastAcceptedStateAsCommitted();
import org.opensearch.cluster.coordination.PersistedStateRegistry.PersistedStateType;
                clusterState.version()  
            logger.debug("handlePublishResponse: ignored response as election not won");
 * license agreements. See the NOTICE file distributed with
         */  
        assert electionWon() == false || startedJoinSinceLastReboot;
        );  
    public static class VoteCollection {
                || lastAcceptedState.term() == ZEN1_BWC_TERM : "received cluster state with empty cluster uuid but not Zen1 BWC term: "  
                "handleCommit: ignored commit request due to version mismatch (term {}, expected: [{}], actual: [{}])",
    public void setInitialState(ClusterState initialState) {
    }
            );
            .getLastAcceptedConfiguration();  
        PersistedStateStats getStats();  
                applyCommit.getTerm(),
            throw new CoordinationStateRejectedException(  
        long getCurrentTerm();
        return getLastAcceptedState().version();  
                    getLastAcceptedVersion(),  
     * May be called on receipt of a PublishResponse from the given sourceNode.  
            if (electionWon == false) {  
            clusterState.term()  
        PersistedStateRegistry persistedStateRegistry,
            electionWon,
            final ClusterState lastAcceptedState = getLastAcceptedState();
    /**
            throw new CoordinationStateRejectedException(
     * @return true iff this instance does not already have a join vote from the given source node for this term
        this.isRemoteStateEnabled = isRemoteStoreClusterStateEnabled(settings);
            joins = new HashSet<>();  
                reason = "bumping term";  
    }
        );
        return votes.isQuorum(getLastCommittedConfiguration()) && votes.isQuorum(lastPublishedConfiguration);  
        }  
                "incoming term " + clusterState.term() + " does not match current term " + getCurrentTerm()  
    }
            throw new CoordinationStateRejectedException("only allow reconfiguration while not already reconfiguring");
    }
 * The core class of the cluster state coordination algorithm, directly implementing the
            persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).markLastAcceptedStateAsCommitted();
        // transient state
                metadataBuilder.coordinationMetadata(coordinationMetadata);
            Metadata.Builder metadataBuilder = commitVotingConfiguration(lastAcceptedState);
import java.util.Set;
    private VoteCollection publishVotes;
    public CoordinationState(
    private static final Logger logger = LogManager.getLogger(CoordinationState.class);
        }
        private final Map<String, DiscoveryNode> nodes;
        }
                "incoming version " + publishResponse.getVersion() + " does not match current version " + lastPublishedVersion  
import org.opensearch.common.util.io.IOUtils;
     * @throws CoordinationStateRejectedException if the arguments were incompatible with the current state of this object.
    public boolean handleJoin(Join join) {
     *
        if (electionWon == false) {  
        final long lastAcceptedTerm = getLastAcceptedTerm();
 * this work for additional information regarding copyright
        this.joinVotes = new VoteCollection();  
                    + " in term "
            if (!(o instanceof VoteCollection)) return false;
        }
        persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL).setCurrentTerm(startJoinRequest.getTerm());
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;  
        persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL).setLastAcceptedState(initialState);
                    // Zen1 cluster-managers never publish a committed cluster UUID so if we logged this it'd happen on on every update.
        @Override
            assert lastAcceptedState.metadata().clusterUUID().equals(Metadata.UNKNOWN_CLUSTER_UUID) == false
    private boolean shouldCommitRemotePersistedState() {  
        }
        );
        public int hashCode() {
            );
            logger.debug("handleClientValue: only allow reconfiguration while not already reconfiguring");
         * Marks the last accepted cluster state as committed.
            assert persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE) != null : "Remote state has not been initialized";
        public boolean containsVoteFor(DiscoveryNode node) {
    }
            throw new CoordinationStateRejectedException(
        }  
            assert persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE) != null : "Remote state has not been initialized";
                "handlePublishResponse: ignored publish response due to term mismatch (expected: [{}], actual: [{}])",  
    }
                "incoming version " + applyCommit.getVersion() + " does not match current version " + getLastAcceptedVersion()
     *
            throw new CoordinationStateRejectedException(  
            getLastAcceptedConfiguration(),  
    private boolean electionWon;
 * under the License.  
            return null;
            // return null by default, this method needs to be overridden wherever required  
        }
        DiscoveryNode localNode,  
        publishVotes = new VoteCollection();
     * @throws CoordinationStateRejectedException if the arguments were incompatible with the current state of this object.  
            throw new CoordinationStateRejectedException(
        assert electionWon() == isElectionQuorum(joinVotes);
                && clusterState.nodes().getClusterManagerNode().equals(getLastAcceptedState().nodes().getClusterManagerNode()) == false) {  
            final boolean added = addVote(join.getSourceNode());  
            throw new CoordinationStateRejectedException("election not won");
                "handleCommit: ignored commit request due to term mismatch "
        // Publishing the current state to remote store before sending the cluster state to other nodes.  
        joinVotes = new VoteCollection();
                    metadataBuilder = Metadata.builder(lastAcceptedState.metadata());
                "incoming term " + startJoinRequest.getTerm() + " not greater than current term " + getCurrentTerm()
            logger.debug(  
            );
 * The OpenSearch Contributors require contributions made to  
    public Optional<ApplyCommitRequest> handlePublishResponse(DiscoveryNode sourceNode, PublishResponse publishResponse) {
        } else {
        }
        return new PublishRequest(clusterState);  
                "handlePublishResponse: ignored publish response due to version mismatch (expected: [{}], actual: [{}])",
            getCurrentTerm(),
         * Sets a new current term.
        if (join.getLastAcceptedTerm() > lastAcceptedTerm) {  
        logger.debug(  
     * @param clusterState The cluster state for which pre publish activities should happen.  
        }  
            throw new CoordinationStateRejectedException(
            "handleCommit: applying commit request for term [{}] and version [{}]",
 * ownership. Elasticsearch licenses this file to you under  
                join.getLastAcceptedVersion(),  
        }
            getLastAcceptedVersion()  
        }
        assert initialState.getLastAcceptedConfiguration().isEmpty() == false;
import java.util.Optional;  
        public boolean equals(Object o) {
        if (shouldCommitRemotePersistedState()) {
        /**
                "incoming term " + publishResponse.getTerm() + " does not match current term " + getCurrentTerm()
    public Join handleStartJoin(StartJoinRequest startJoinRequest) {
        if (lastPublishedVersion != getLastAcceptedVersion()) {
            // so instead we just reject join votes received prior to receiving the initial configuration.
    private final DiscoveryNode localNode;
            persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).setLastAcceptedState(publishRequest.getAcceptedState());
            } else {
            join.getSourceNode(),  
        if (clusterState.getLastAcceptedConfiguration().equals(getLastAcceptedConfiguration()) == false
/**  
    /**
    /**
                "handleJoin: ignored join as joiner has a better last accepted version (expected: <=[{}], actual: [{}]) in term {}",
        default void close() throws IOException {}  
        this.lastPublishedVersion = 0L;  
            }
                "incoming term " + join.getTerm() + " does not match current term " + getCurrentTerm()
            getCurrentTerm(),
            if (!nodes.equals(that.nodes)) return false;
            logger.trace(  
     * has been accepted at a quorum of peers and is therefore committed.
            logger.debug("handleJoin: ignored join due to term mismatch (expected: [{}], actual: [{}])", getCurrentTerm(), join.getTerm());  
    }
         */
 */
     * @opensearch.internal
 * KIND, either express or implied.  See the License for the
    public long getLastAcceptedTerm() {
         * Returns the last accepted {@link ClusterMetadataManifest}.  
                    clusterState.version()
        }  
    }
    }  
        return electionWon;
            int result = nodes.hashCode();
import java.util.Map;
            assert getLastPublishedVersion() >= getLastAcceptedVersion();
     * Pluggable persistence layer for {@link CoordinationState}.
                publishResponse.getVersion()  
            );
                    + " lower or equal to last published version "  
            .getLastAcceptedState()
        if (join.getTerm() != getCurrentTerm()) {
     *  
            }  
     * This method should be called just before sending the ApplyCommitRequest to all cluster nodes.
            getLastAcceptedVersionOrMetadataVersion()  
            logger.debug("setInitialState: rejecting since last-accepted configuration is nonempty: {}", lastAcceptedConfiguration);  
     *  
        assert publishVotes.isEmpty() || electionWon();  
        assert getLastCommittedConfiguration().isEmpty() : getLastCommittedConfiguration();
            sourceNode
     */
                );
                getCurrentTerm(),  
                "handleClientValue: ignored request due to term mismatch "
                    // Let's just
            updateRemotePersistedStateOnPublishRequest(publishRequest);
         * The value returned by {@link #getLastAcceptedState()} should not be influenced by calls to this method.  
        Settings settings  
            );
         * Returns the current term  
        }  
        assert join.targetMatches(localNode) : "handling join " + join + " for the wrong node " + localNode;  
     * @return An optional ApplyCommitRequest which, if present, may be broadcast to all peers, indicating that this publication
        return electionStrategy.isElectionQuorum(  
            }  
                getCurrentTerm(),
    ) {
 * Modifications Copyright OpenSearch Contributors. See  
                throw new CoordinationStateRejectedException(  
                getCurrentTerm(),  
        /**  
            if (metadataBuilder != null) {
                    + join.getLastAcceptedTerm()
    }  
 * SPDX-License-Identifier: Apache-2.0
                getLastAcceptedTerm(),  
    private VotingConfiguration lastPublishedConfiguration;
}
     * A collection of votes, used to calculate quorums. Optionally records the Joins as well.
                publishResponse.getTerm()
        }
                "incoming last accepted version "
                applyCommit.getTerm(),
    }
            getLastAcceptedTerm(),
    /**
                clusterState.term(),  
        default Metadata.Builder commitVotingConfiguration(ClusterState lastAcceptedState) {  
            );  
            );
 * @opensearch.internal
            logger.debug(
            nodes = new HashMap<>();
                    + "(expected: [term {} version {}], actual: [term {} version {}])",
     * @opensearch.internal  
     * May be called in order to prepare publication of the given cluster state
         */
            );
            throw new CoordinationStateRejectedException(  
            );  
        if (publishRequest instanceof RemoteStatePublishRequest) {
        persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL).markLastAcceptedStateAsCommitted();  
                applyCommit.getVersion()
            "handleJoin: added join {} from [{}] for election, electionWon={} lastAcceptedTerm={} lastAcceptedVersion={}",
     * @param join The Join received.
    private final boolean isRemoteStateEnabled;  
        }  
                    + lastAcceptedState;
 * You may obtain a copy of the License at  
import org.opensearch.cluster.node.DiscoveryNode;  
                .getNodes()
        // recover the cluster.  
                logger.debug(
     * @param initialState The initial state to use. Must have term 0, version equal to the last-accepted version, and non-empty
        assert !prevElectionWon || electionWon : // we cannot go from won to not won
                getLastAcceptedVersion(),
        return persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE) != null
     * @param publishResponse The PublishResponse received.  
            throw new CoordinationStateRejectedException("cannot start publishing next value before accepting previous one");  
    private void updateRemotePersistedStateOnPublishRequest(PublishRequest publishRequest) {  
                    clusterState.version()
import java.util.HashSet;
        public String toString() {  
        /**
                getCurrentTerm(),
            logger.debug(
                getLastAcceptedVersion(),  
     */
            getLastCommittedConfiguration(),
        }
     *  
        lastPublishedConfiguration = getLastAcceptedConfiguration();
                    + getLastAcceptedVersionOrMetadataVersion()
                setLastAcceptedState(ClusterState.builder(lastAcceptedState).metadata(metadataBuilder).build());
                getCurrentTerm()
            logger.debug(  
            startJoinRequest.getSourceNode(),  
    // transient state
            lastPublishedVersion = getLastAcceptedVersion();
 */  
                    + clusterState.version()
                    + "(expected: [term {} version {}], actual: [term {} version {}])",
    // persisted state registry
            logger.debug(  
         */
        }  
            );  
            final String reason;
 * compatible open source license.
        return joinVotes.getJoins().contains(join);  
    }  
import org.opensearch.gateway.remote.ClusterMetadataManifest;  
 * Licensed to Elasticsearch under one or more contributor  
            }  
         * Sets the last accepted {@link ClusterMetadataManifest}.
            return nodes.isEmpty();  
            return Collections.unmodifiableSet(joins);
    private final ElectionStrategy electionStrategy;  
        lastPublishedVersion = clusterState.version();  
            return joins.equals(that.joins);  
        if (electionWon == false) {  
            : "last committed configuration should not change";
            );  
    /**
        if (isRemoteStateEnabled) {
        }
        logger.trace(
        // This is to ensure the remote store is the single source of truth for current state. Even if the current node
    }
        if (joinVotesHaveQuorumFor(clusterState.getLastAcceptedConfiguration()) == false) {
        return joinVotes.isQuorum(votingConfiguration);
        public Collection<DiscoveryNode> nodes() {  
            );
    public VotingConfiguration getLastAcceptedConfiguration() {
        if (joinVotes.isEmpty() == false) {
import static org.opensearch.cluster.coordination.Coordinator.ZEN1_BWC_TERM;  
 *
            } else if (startJoinRequest.getSourceNode().equals(localNode)) {
                metadataBuilder = Metadata.builder(lastAcceptedState.metadata());  
        return persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE) != null
import org.apache.logging.log4j.LogManager;  
     */
        return joinVotes.containsVoteFor(node);
                lastPublishedVersion,
 * Unless required by applicable law or agreed to in writing,
                "incoming cluster state version "
            "locaNode= " + localNode + ", join=" + join + ", joinVotes=" + joinVotes;
            Metadata.Builder metadataBuilder = null;
        assert initialState.getLastCommittedConfiguration().isEmpty() == false;
            );
        assert lastPublishedVersion == 0 : lastPublishedVersion;
        }
        return persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL).getLastAcceptedState();
    }  
            );
            applyCommit.getVersion()  
     * @param clusterState The cluster state to publish.
    }
        logger.trace(  
            persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE)  
    }
        return persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL).getCurrentTerm();  
        }
                join.getLastAcceptedTerm()
            );
        if (applyCommit.getVersion() != getLastAcceptedVersion()) {  
        logger.debug("handleStartJoin: leaving term [{}] due to {}", getCurrentTerm(), startJoinRequest);
        public Set<Join> getJoins() {
     */
        ElectionStrategy electionStrategy,
                "incoming term " + applyCommit.getTerm() + " does not match last accepted term " + getLastAcceptedTerm()  
            join,
     * @param sourceNode      The sender of the PublishResponse received.
     * @param publishRequest The publish request received.  
        startedJoinSinceLastReboot = true;
 */
    }
    public void close() throws IOException {  
        IOUtils.close(persistedStateRegistry);
        this.electionWon = false;
                logger.debug(
            if (lastAcceptedState.metadata().clusterUUID().equals(Metadata.UNKNOWN_CLUSTER_UUID) == false
        final VotingConfiguration lastAcceptedConfiguration = getLastAcceptedConfiguration();
                "incoming term " + applyCommit.getTerm() + " does not match current term " + getCurrentTerm()
        return new PublishResponse(clusterState.term(), clusterState.version());
        electionWon = false;  
                getLastAcceptedVersionOrMetadataVersion(),
            logger.debug(
        if (clusterState.term() != getCurrentTerm()) {
package org.opensearch.cluster.coordination;
                    "handling publish request in compatibility mode despite version mismatch (expected: >[{}], actual: [{}])",
            if (lastAcceptedState.getLastAcceptedConfiguration().equals(lastAcceptedState.getLastCommittedConfiguration()) == false) {
     *  
        @Override  
        if (isRemoteStateEnabled) {  
        if (electionWon && prevElectionWon == false) {  
        lastPublishedConfiguration = clusterState.getLastAcceptedConfiguration();
    }
    /**  
     * @throws CoordinationStateRejectedException if the arguments were incompatible with the current state of this object.  
            throw new CoordinationStateRejectedException(
import java.io.Closeable;
                "handlePublishRequest: ignored publish request due to term mismatch (expected: [{}], actual: [{}])",
        assert initialState.term() == 0 : initialState + " should have term 0";
            persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).setLastAcceptedManifest(null);
            lastAcceptedTerm,
        assert getLastCommittedConfiguration().equals(getLastAcceptedConfiguration());
        default void setLastAcceptedManifest(ClusterMetadataManifest manifest) {}
        void setLastAcceptedState(ClusterState clusterState);  
     * @param startJoinRequest The startJoinRequest, specifying the node requesting the join.
            return sourceNode.isClusterManagerNode() && nodes.put(sourceNode.getId(), sourceNode) == null;
     */
                if (metadataBuilder == null) {
    /**  
     * @return A PublishRequest to publish the given cluster state
    }
     *
        return new Join(
import java.io.IOException;  
        persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL).setLastAcceptedState(clusterState);
            && publishRequest.getAcceptedState().getNodes().isLocalNodeElectedClusterManager() == false;  
        /**
        );
     */  
            throw new CoordinationStateRejectedException("ignored join as term has not been incremented yet after reboot");
            logger.debug("handleStartJoin: discarding {}: {}", joinVotes, reason);
        logger.trace("handleClientValue: processing request for version [{}] and term [{}]", lastPublishedVersion, getCurrentTerm());
            return "VoteCollection{votes=" + nodes.keySet() + ", joins=" + joins + "}";
        @Override
                "handleCommit: ignored commit request due to term mismatch "  
        }
    /**  
         * marked as committed.
                startJoinRequest,  
            );
            if (added) {
            // if we receive a commit from a Zen1 cluster-manager that has not recovered its state yet,  
        if (applyCommit.getTerm() != getLastAcceptedTerm()) {
        electionWon = isElectionQuorum(joinVotes);  
    }  
            );  
         * @return The last accepted {@link ClusterMetadataManifest}, or null if no manifest
                getLastAcceptedVersion(),
                lastPublishedVersion,
        /**  
         */
    public void handlePreCommit() {
        assert getLastAcceptedTerm() == 0 : getLastAcceptedTerm();  
                && lastAcceptedState.metadata().clusterUUIDCommitted() == false) {  
        if (startedJoinSinceLastReboot == false) {  
    private long lastPublishedVersion;  
         * After a successful call to this method, {@link #getLastAcceptedState()} should return the last cluster state that was set,
 * specific language governing permissions and limitations
        assert lastPublishedConfiguration.isEmpty() : lastPublishedConfiguration;  
                    + lastAcceptedTerm
        return getLastAcceptedState().getVersionOrMetadataVersion();
         * Sets a new last accepted cluster state.
     */
            getLastAcceptedTerm(),  
        if (clusterState.term() != getCurrentTerm()) {  
        }
            logger.debug("handleClientValue: ignored request as election not won");
    }
    }  
    }
         * After a successful call to this method, {@link #getCurrentTerm()} should return the last term that was set.
        if (join.getLastAcceptedTerm() == lastAcceptedTerm && join.getLastAcceptedVersion() > getLastAcceptedVersionOrMetadataVersion()) {
public class CoordinationState {  
                    // not log it at all in a 6.8/7.x rolling upgrade.  
                .setLastAcceptedManifest(((RemoteStatePublishRequest) publishRequest).getAcceptedManifest());
            throw new CoordinationStateRejectedException("rejecting join since this node has not received its initial configuration yet");
            );
            && persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).getLastAcceptedState() != null  
        if (electionWon()) {  
     * May be safely called at any time to move this instance to a new term.
            );  
                applyCommit.getVersion()  
        }  
        public boolean addVote(DiscoveryNode sourceNode) {
    }
            return nodes.containsKey(node.getId());
     * @return A PublishResponse which can be sent back to the sender of the PublishRequest.
        // goes down after sending the cluster state to other nodes, we should be able to read the remote state and
    public long getLastPublishedVersion() {  
            // complicated to restore all the appropriate invariants when setting the initial configuration (it's not just electionWon)
                    .lastCommittedConfiguration(lastAcceptedState.getLastAcceptedConfiguration())
            // We will end up here if PublishRequest was sent not using Remote Store even with remote persisted state on this node  
        );
                publishResponse.getTerm()  
    private boolean shouldUpdateRemotePersistedState(PublishRequest publishRequest) {
     */
     */
    public boolean electionWon() {
        if (clusterState.version() <= lastPublishedVersion) {  
        assert electionWon == false;
     */  
    boolean containsJoin(Join join) {
        default void markLastAcceptedStateAsCommitted() {  
    private long getLastAcceptedVersionOrMetadataVersion() {  
    private boolean startedJoinSinceLastReboot;
                    + lastAcceptedTerm  
        assert getLastAcceptedState() == clusterState;  
        }
        public boolean isQuorum(VotingConfiguration configuration) {  
        publishVotes = new VoteCollection();
        );
                clusterState.term()
                metadataBuilder.clusterUUIDCommitted(true);
 * <a href="https://github.com/elastic/elasticsearch-formal-models/blob/master/ZenWithTerms/tla/ZenWithTerms.tla">formal model</a>
    }  
    }
            if (clusterState.term() == ZEN1_BWC_TERM
                    + "(expected: [term {} version >{}], actual: [term {} version {}])",
         * Returns the last accepted cluster state
                .isLocalNodeElectedClusterManager() == false
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
        return Optional.empty();  
     * @throws CoordinationStateRejectedException if the arguments were incompatible with the current state of this object.
                "incoming last accepted term "
    public void invariant() {  
        this.electionStrategy = electionStrategy;  
        this.lastPublishedConfiguration = persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL)
         * The value returned by {@link #getCurrentTerm()} should not be influenced by calls to this method.
    public long getCurrentTerm() {
                "handleStartJoin: ignoring [{}] as term provided is not greater than current term [{}]",
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRemoteStoreClusterStateEnabled;
            logger.debug(  
            localNode,
    public void handlePrePublish(ClusterState clusterState) {
     *  
                clusterState.version()
     * @throws CoordinationStateRejectedException if the arguments were incompatible with the current state of this object.  
            clusterState.version(),
                "initial state already set: last-accepted configuration now " + lastAcceptedConfiguration
            publishResponse.getTerm(),
            "handlePublishRequest: accepting publish request for version [{}] and term [{}]",
            return metadataBuilder;  
 * software distributed under the License is distributed on an
import java.util.Collection;
        if (publishResponse.getVersion() != lastPublishedVersion) {
 */
            logger.debug(
    public boolean joinVotesHaveQuorumFor(VotingConfiguration votingConfiguration) {  
         */
    public PublishResponse handlePublishRequest(PublishRequest publishRequest) {
        }  
            "handlePublishResponse: accepted publish response for version [{}] and term [{}] from [{}]",
    public ClusterState getLastAcceptedState() {  
                    + " of join higher than current last accepted version "  
        }
            return result;
            logger.debug(
        /**
            joinVotes
        this.publishVotes = new VoteCollection();
            persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).setLastAcceptedState(null);
        if (getLastAcceptedConfiguration().isEmpty()) {
                lastAcceptedTerm
            applyCommit.getTerm(),
        assert getLastAcceptedTerm() <= getCurrentTerm();
                }  
        public boolean isEmpty() {
        private final Set<Join> joins;
        }
         * After a successful call to this method, {@link #getLastAcceptedState()} should return the last cluster state that was set.  
/*
            && persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL)
        ClusterState getLastAcceptedState();
        }  
                "handleClientValue: ignored request due to version mismatch "
        final ClusterState clusterState = publishRequest.getAcceptedState();
                lastPublishedVersion,
            );
    public VotingConfiguration getLastCommittedConfiguration() {
        }  
        }  
         * @return PersistedStateStats
     * @param applyCommit The ApplyCommitRequest received.  
        if (lastAcceptedConfiguration.isEmpty() == false) {
        return getLastAcceptedState().getLastCommittedConfiguration();
         */  
        assert initialState.version() == getLastAcceptedVersion() : initialState + " should have version " + getLastAcceptedVersion();  
     * This method should be called just before sending the PublishRequest to all cluster nodes.
        return lastPublishedVersion;
                final CoordinationMetadata coordinationMetadata = CoordinationMetadata.builder(lastAcceptedState.coordinationMetadata())  
            return added;
            publishResponse.getVersion(),  
            );
            // the cluster uuid might not been known yet.
        lastPublishedVersion = 0;  
         *         has been accepted yet.  
        if (shouldUpdateRemotePersistedState(publishRequest)) {  
                getLastAcceptedTerm(),
 *  
                "handleJoin: ignored join as joiner has a better last accepted term (expected: <=[{}], actual: [{}])",
            throw new CoordinationStateRejectedException(  
        assert clusterState.getLastCommittedConfiguration().equals(getLastCommittedConfiguration())  
                    + "(expected: [term {} version >{}], actual: [term {} version {}])",  
     *
import org.apache.logging.log4j.Logger;
        }  
            logger.debug("handleClientValue: cannot start publishing next value before accepting previous one");
 * this file be licensed under the Apache-2.0 license or a
                    logger.info("cluster UUID set to [{}]", lastAcceptedState.metadata().clusterUUID());
            );  
            assert getLastPublishedVersion() == 0L;  
            throw new CoordinationStateRejectedException("only allow reconfiguration if joinVotes have quorum for new config");  
 *
        }
                    "handlePublishRequest: ignored publish request due to version mismatch (expected: >[{}], actual: [{}])",
    public PublishRequest handleClientValue(ClusterState clusterState) {
        }  
 * the Apache License, Version 2.0 (the "License"); you may
        }
                lastAcceptedTerm,  
        boolean prevElectionWon = electionWon;
     * May be called on receipt of an ApplyCommitRequest. Updates the committed configuration accordingly.
    public boolean isElectionQuorum(VoteCollection joinVotes) {
            );
            throw new CoordinationStateRejectedException(
        // persisted state registry
     * @throws CoordinationStateRejectedException if the arguments were incompatible with the current state of this object.  
 * not use this file except in compliance with the License.
        }
    public long getLastAcceptedVersion() {
import org.opensearch.common.settings.Settings;
         *
            logger.debug("handleJoin: ignored join as term was not incremented yet after reboot");
        return added;
            logger.debug("handleClientValue: only allow reconfiguration if joinVotes have quorum for new config");
        return getLastAcceptedState().getLastAcceptedConfiguration();  
        /**
     */
     * Used to bootstrap a cluster by injecting the initial state and configuration.
    public boolean isPublishQuorum(VoteCollection votes) {
        return getLastAcceptedState().term();
    /**
/*  
     * @return A Join that should be sent to the target node of the join.
            handlePreCommit();
            logger.debug("handleJoin: rejecting join since this node has not received its initial configuration yet");  
        assert joinVotes.isEmpty() : joinVotes;
        }  
            getLastAcceptedVersion(),
                getLastAcceptedTerm(),  
                publishResponse.getVersion(),
    /**
    }
            logger.debug("handleJoin: election won in term [{}] with {}", getCurrentTerm(), joinVotes);
    private final PersistedStateRegistry persistedStateRegistry;  
                applyCommit.getVersion()
        }
    }
            return Collections.unmodifiableCollection(nodes.values());
                if (lastAcceptedState.term() != ZEN1_BWC_TERM) {  
            logger.debug(
         * with the last committed configuration now corresponding to the last accepted configuration, and the cluster uuid, if set,  
            persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE).setLastAcceptedState(clusterState);  
                    "incoming version " + clusterState.version() + " lower or equal to current version " + getLastAcceptedVersion()
    public interface PersistedState extends Closeable {  
    }
