    public void update(final PreVoteResponse preVoteResponse, @Nullable final DiscoveryNode leader) {
/*
                return;
 * compatible open source license.
 * specific language governing permissions and limitations
                logger.debug("{} is closed, ignoring {} from {}", this, response, sender);
    // only for testing
import org.opensearch.monitor.NodeHealthService;
     * Start a new pre-voting round.
                    }
            false,
import static org.opensearch.common.util.concurrent.ConcurrentCollections.newConcurrentMap;
            Names.GENERIC,
                            logger.debug(new ParameterizedMessage("{} failed", this), exp);
        }
import org.opensearch.cluster.ClusterState;
        transportService.registerRequestHandler(
                + '}';
        PreVotingRound(final ClusterState clusterState, final long currentTerm) {
                )
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                            return new PreVoteResponse(in);
                        localNode,
                + ", electionStarted="
    // Tuple for simple atomic updates. null until the first call to `update()`.
        return "PreVoteCollector{" + "state=" + state + '}';
    }
        @Override
import org.opensearch.cluster.coordination.CoordinationState.VoteCollection;
package org.opensearch.cluster.coordination;
        }
        }
                        }
/**
    }
import java.io.IOException;
 * @opensearch.internal
                        @Override
    ) {
    public String toString() {
                voteCollection
        final ElectionStrategy electionStrategy,
     */
        }
                        @Override
            startElection.run();
    private final LongConsumer updateMaxTermSeen;
    PreVoteResponse getPreVoteResponse() {
            // This is a _rare_ case where our leader has detected a failure and stepped down, but we are still a follower. It's possible
        preVotingRound.start(broadcastNodes);
    PreVoteCollector(
 * license agreements. See the NOTICE file distributed with
                clusterState.nodes().getLocalNode(),
    }
            String message = "rejecting " + request + " on unhealthy node: [" + statusInfo.getInfo() + "]";
    private static final Logger logger = LogManager.getLogger(PreVoteCollector.class);
            PreVoteRequest::new,
        public String toString() {
                localPreVoteResponse.getLastAcceptedTerm(),
        }
            preVotesReceived.put(sender, response);
    }
                localPreVoteResponse.getLastAcceptedVersion(),
import java.util.Map;
 */
        @Override
            if (electionStarted.compareAndSet(false, true) == false) {
            if (response.getLastAcceptedTerm() > clusterState.term()
        final LongConsumer updateMaxTermSeen,
                localPreVoteResponse.getCurrentTerm(),
 * Collects information prior to a promotion vote
    private volatile Tuple<DiscoveryNode, PreVoteResponse> state; // DiscoveryNode component is null if there is currently no known leader.
 */
                        public PreVoteResponse read(StreamInput in) throws IOException {
     * @opensearch.internal
        private final AtomicBoolean isClosed = new AtomicBoolean();
public class PreVoteCollector {
import org.opensearch.cluster.node.DiscoveryNode;
        assert state != null : "received pre-vote request before fully initialised";
        }
                    )
        private void handlePreVoteResponse(final PreVoteResponse response, final DiscoveryNode sender) {
import org.apache.logging.log4j.LogManager;
import org.opensearch.common.collect.Tuple;
     *
     * The pre vote round.
        private final ClusterState clusterState;
            // to also detect its failure.
            assert StreamSupport.stream(broadcastNodes.spliterator(), false).noneMatch(Coordinator::isZen1Node) : broadcastNodes;
    private final Runnable startElection;
import org.opensearch.common.Nullable;
     */
     * @param broadcastNodes the nodes from whom to request pre-votes
import org.apache.logging.log4j.message.ParameterizedMessage;
            // that the leader lost its quorum, but while we're still a follower we will not offer joins to any other node so there is no
     *
                )
            return response;
        this.startElection = startElection;
        private final AtomicBoolean electionStarted = new AtomicBoolean();
        throw new CoordinationStateRejectedException("rejecting " + request + " as there is already a leader");
            preVotesReceived.forEach(
    }
                        }
    }
        this.nodeHealthService = nodeHealthService;
                        preVoteResponse.getCurrentTerm(),
            final boolean isNotAlreadyClosed = isClosed.compareAndSet(false, true);
    public Releasable start(final ClusterState clusterState, final Iterable<DiscoveryNode> broadcastNodes) {
            // create a fake VoteCollection based on the pre-votes and check if there is an election quorum
        return state.v2();
            return "PreVotingRound{"
 *     http://www.apache.org/licenses/LICENSE-2.0
            false,
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;
                    preVoteRequest,
 * The OpenSearch Contributors require contributions made to
        return preVotingRound;
                        @Override
                return;
                            handlePreVoteResponse(response, n);
            );
                (node, preVoteResponse) -> voteCollection.addJoinVote(
        if (leader == null) {
/*
import java.util.concurrent.atomic.AtomicBoolean;
 * SPDX-License-Identifier: Apache-2.0
                logger.debug("{} added {} from {} but election has already started", this, response, sender);
        final TransportService transportService,
        this.updateMaxTermSeen = updateMaxTermSeen;
                + electionStarted
                        public String executor() {
 *
            }
    DiscoveryNode getLeader() {
        PreVotingRound preVotingRound = new PreVotingRound(clusterState, state.v2().getCurrentTerm());
        state = new Tuple<>(leader, preVoteResponse);
                logger.debug("{} added {} from {}, no quorum yet", this, response, sender);
            preVoteRequest = new PreVoteRequest(transportService.getLocalNode(), currentTerm);
import org.apache.logging.log4j.Logger;
    @Override
                    n,
                clusterState.getLastCommittedConfiguration(),
import java.util.function.LongConsumer;
    private final TransportService transportService;
            broadcastNodes.forEach(
 *
                || (response.getLastAcceptedTerm() == clusterState.term()
            final PreVoteResponse localPreVoteResponse = getPreVoteResponse();
            if (electionStrategy.isElectionQuorum(
                clusterState.getLastAcceptedConfiguration(),
 * not use this file except in compliance with the License.
 *
                    new Join(
        final StatusInfo statusInfo = nodeHealthService.getHealth();
import org.opensearch.monitor.StatusInfo;
        private final PreVoteRequest preVoteRequest;
     * @return the pre-voting round, which can be closed to end the round early.
import org.opensearch.threadpool.ThreadPool.Names;
        if (statusInfo.getStatus() == UNHEALTHY) {
            final DiscoveryNode localNode = clusterState.nodes().getLocalNode();
    @Nullable
                        }
        if (leader.equals(request.getSourceNode())) {
                            return "TransportResponseHandler{" + PreVoteCollector.this + ", node=" + n + '}';
    // only for testing
import org.opensearch.core.common.io.stream.StreamInput;
 * software distributed under the License is distributed on an
    /**
    private NodeHealthService nodeHealthService;
            this.clusterState = clusterState;
    /**
        public void close() {
 * GitHub history for details.
import java.util.stream.StreamSupport;
        }
            updateMaxTermSeen.accept(response.getCurrentTerm());
                    && response.getLastAcceptedVersion() > clusterState.getVersionOrMetadataVersion())) {
 * this work for additional information regarding copyright
    }
            if (isClosed.get()) {
            logger.debug(message);
                + ", preVoteRequest="
            // leader won't change, and also that its re-election will happen more quickly than if it had to wait for a quorum of followers
            ) == false) {
                        node,
/*
        void start(final Iterable<DiscoveryNode> broadcastNodes) {
                + ", isClosed="
                        public void handleResponse(PreVoteResponse response) {
                            return Names.GENERIC;
                        @Override
            // major drawback in offering a join to our old leader. The advantage of this is that it makes it slightly more likely that the
        final DiscoveryNode leader = state.v1();
import org.opensearch.common.lease.Releasable;
 */
    private PreVoteResponse handlePreVoteRequest(final PreVoteRequest request) {
                + preVotesReceived
            throw new NodeHealthCheckFailureException(message);
            REQUEST_PRE_VOTE_ACTION_NAME,
 */
                return;
                    new TransportResponseHandler<PreVoteResponse>() {
}
        final PreVoteResponse response = state.v2();
        updateMaxTermSeen.accept(request.getCurrentTerm());
                        }
                        }
        return state.v1();
    }
            final VoteCollection voteCollection = new VoteCollection();
     * @param clusterState   the last-accepted cluster state
    private class PreVotingRound implements Releasable {
                    REQUEST_PRE_VOTE_ACTION_NAME,
 * You may obtain a copy of the License at
        );
            logger.debug("{} added {} from {}, starting election", this, response, sender);
                + "preVotesReceived="
 * ownership. Elasticsearch licenses this file to you under
        this.electionStrategy = electionStrategy;
                n -> transportService.sendRequest(
            }
        private final Map<DiscoveryNode, PreVoteResponse> preVotesReceived = newConcurrentMap();
        NodeHealthService nodeHealthService
 * Licensed to Elasticsearch under one or more contributor
                        preVoteResponse.getLastAcceptedTerm(),
            }
            );
                logger.debug("{} ignoring {} from {} as it is fresher", this, response, sender);
        }
        this.transportService = transportService;
                        public String toString() {
 * under the License.
            (request, channel, task) -> channel.sendResponse(handlePreVoteRequest(request))
            assert isNotAlreadyClosed;
    public static final String REQUEST_PRE_VOTE_ACTION_NAME = "internal:cluster/request_pre_vote";
            logger.debug("{} requesting pre-votes from {}", this, broadcastNodes);
import org.opensearch.transport.TransportException;
        final Runnable startElection,
            return response;
                        @Override
import org.opensearch.transport.TransportService;
                + preVoteRequest
 * KIND, either express or implied.  See the License for the
    private final ElectionStrategy electionStrategy;
                + isClosed
        logger.trace("updating with preVoteResponse={}, leader={}", preVoteResponse, leader);
 * the Apache License, Version 2.0 (the "License"); you may
                        preVoteResponse.getLastAcceptedVersion()
 *
                        public void handleException(TransportException exp) {
                return;
            }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.transport.TransportResponseHandler;
        Tuple<DiscoveryNode, PreVoteResponse> state = this.state;
 * Modifications Copyright OpenSearch Contributors. See
