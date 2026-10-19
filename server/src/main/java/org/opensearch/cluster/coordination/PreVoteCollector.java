    public static final String REQUEST_PRE_VOTE_ACTION_NAME = "internal:cluster/request_pre_vote";  
                )  
 * Modifications Copyright OpenSearch Contributors. See
        PreVotingRound preVotingRound = new PreVotingRound(clusterState, state.v2().getCurrentTerm());  
        private final AtomicBoolean isClosed = new AtomicBoolean();
package org.opensearch.cluster.coordination;
     */
            if (response.getLastAcceptedTerm() > clusterState.term()
        final TransportService transportService,  
import java.util.function.LongConsumer;  
                    new Join(
            logger.debug(message);  
            }
                        node,  
 * this file be licensed under the Apache-2.0 license or a
        @Override
            if (isClosed.get()) {  
                        @Override  
            this.clusterState = clusterState;
            final PreVoteResponse localPreVoteResponse = getPreVoteResponse();
 *  
 * Licensed to Elasticsearch under one or more contributor  
        public String toString() {
        final Runnable startElection,
            broadcastNodes.forEach(  
        NodeHealthService nodeHealthService
 * not use this file except in compliance with the License.
                        public void handleException(TransportException exp) {
                    && response.getLastAcceptedVersion() > clusterState.getVersionOrMetadataVersion())) {  
    @Override
import java.util.concurrent.atomic.AtomicBoolean;
        if (statusInfo.getStatus() == UNHEALTHY) {
            assert isNotAlreadyClosed;  
}  
            preVotesReceived.forEach(  
                return;
        final PreVoteResponse response = state.v2();
                clusterState.nodes().getLocalNode(),
 */  
        assert state != null : "received pre-vote request before fully initialised";
                        }  
    private final LongConsumer updateMaxTermSeen;
            throw new NodeHealthCheckFailureException(message);
        }  
                        }
                    }  
                        public String executor() {
    public void update(final PreVoteResponse preVoteResponse, @Nullable final DiscoveryNode leader) {
                n -> transportService.sendRequest(
        private final ClusterState clusterState;
            false,
    private final Runnable startElection;  
    }
                        preVoteResponse.getCurrentTerm(),
        if (leader == null) {
                + ", preVoteRequest="
            final boolean isNotAlreadyClosed = isClosed.compareAndSet(false, true);
        this.nodeHealthService = nodeHealthService;
import org.opensearch.transport.TransportException;
                            handlePreVoteResponse(response, n);
        throw new CoordinationStateRejectedException("rejecting " + request + " as there is already a leader");
import org.opensearch.cluster.ClusterState;
            if (electionStrategy.isElectionQuorum(  
        this.transportService = transportService;  
                clusterState.getLastAcceptedConfiguration(),  
                logger.debug("{} added {} from {}, no quorum yet", this, response, sender);  
                || (response.getLastAcceptedTerm() == clusterState.term()
    private final ElectionStrategy electionStrategy;
        }
                            return new PreVoteResponse(in);
    PreVoteCollector(
        final LongConsumer updateMaxTermSeen,
            ) == false) {
    }  
                    REQUEST_PRE_VOTE_ACTION_NAME,  
        final StatusInfo statusInfo = nodeHealthService.getHealth();  
     * @param broadcastNodes the nodes from whom to request pre-votes
     * The pre vote round.
        Tuple<DiscoveryNode, PreVoteResponse> state = this.state;  
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;
import org.opensearch.monitor.StatusInfo;  
            PreVoteRequest::new,
                    preVoteRequest,
            if (electionStarted.compareAndSet(false, true) == false) {
 * SPDX-License-Identifier: Apache-2.0
                            return Names.GENERIC;
     * Start a new pre-voting round.
        final ElectionStrategy electionStrategy,  
        private final AtomicBoolean electionStarted = new AtomicBoolean();
 */
            );
            String message = "rejecting " + request + " on unhealthy node: [" + statusInfo.getInfo() + "]";
                        @Override
import java.util.stream.StreamSupport;
        }
            return "PreVotingRound{"  
    }  
 * license agreements. See the NOTICE file distributed with
        this.updateMaxTermSeen = updateMaxTermSeen;
    private static final Logger logger = LogManager.getLogger(PreVoteCollector.class);
        return state.v2();
                (node, preVoteResponse) -> voteCollection.addJoinVote(
            // leader won't change, and also that its re-election will happen more quickly than if it had to wait for a quorum of followers  
import org.opensearch.core.common.io.stream.StreamInput;
        }
        }
                logger.debug("{} is closed, ignoring {} from {}", this, response, sender);
 * ownership. Elasticsearch licenses this file to you under  
    public String toString() {  
            logger.debug("{} added {} from {}, starting election", this, response, sender);  
 */  
                        }  
                localPreVoteResponse.getLastAcceptedTerm(),  
            REQUEST_PRE_VOTE_ACTION_NAME,
            logger.debug("{} requesting pre-votes from {}", this, broadcastNodes);
     * @param clusterState   the last-accepted cluster state
    ) {
                        public void handleResponse(PreVoteResponse response) {  
            false,  
            updateMaxTermSeen.accept(response.getCurrentTerm());
                        preVoteResponse.getLastAcceptedTerm(),  
 * @opensearch.internal  
        PreVotingRound(final ClusterState clusterState, final long currentTerm) {
                clusterState.getLastCommittedConfiguration(),
                        localNode,
                    new TransportResponseHandler<PreVoteResponse>() {
            startElection.run();
                + preVotesReceived
 * Unless required by applicable law or agreed to in writing,
    // only for testing
import java.util.Map;
        return state.v1();
                    n,
                + ", electionStarted="  
     * @return the pre-voting round, which can be closed to end the round early.  
        public void close() {
    }
    @Nullable
import org.opensearch.common.collect.Tuple;
            );
            // to also detect its failure.
    }
        this.electionStrategy = electionStrategy;  
/*
        void start(final Iterable<DiscoveryNode> broadcastNodes) {  
 *
import static org.opensearch.common.util.concurrent.ConcurrentCollections.newConcurrentMap;  
                            return "TransportResponseHandler{" + PreVoteCollector.this + ", node=" + n + '}';
        return "PreVoteCollector{" + "state=" + state + '}';
            final DiscoveryNode localNode = clusterState.nodes().getLocalNode();  
    private NodeHealthService nodeHealthService;  
     */
                        }
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
import org.opensearch.transport.TransportResponseHandler;  
                + isClosed
import org.opensearch.threadpool.ThreadPool.Names;
            (request, channel, task) -> channel.sendResponse(handlePreVoteRequest(request))  
                        @Override
        state = new Tuple<>(leader, preVoteResponse);  
import org.opensearch.common.lease.Releasable;  
    private class PreVotingRound implements Releasable {  
    // only for testing
                + electionStarted
 * the Apache License, Version 2.0 (the "License"); you may
    public Releasable start(final ClusterState clusterState, final Iterable<DiscoveryNode> broadcastNodes) {
import org.apache.logging.log4j.Logger;
                return;  
    private volatile Tuple<DiscoveryNode, PreVoteResponse> state; // DiscoveryNode component is null if there is currently no known leader.  
        return preVotingRound;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            // This is a _rare_ case where our leader has detected a failure and stepped down, but we are still a follower. It's possible  
 *     http://www.apache.org/licenses/LICENSE-2.0
     *  
            preVotesReceived.put(sender, response);
                voteCollection
import org.apache.logging.log4j.message.ParameterizedMessage;  
import org.apache.logging.log4j.LogManager;
import org.opensearch.common.Nullable;
            return response;
                + ", isClosed="
    }
                + '}';  
/*  
        final DiscoveryNode leader = state.v1();  
            assert StreamSupport.stream(broadcastNodes.spliterator(), false).noneMatch(Coordinator::isZen1Node) : broadcastNodes;
                return;
 * You may obtain a copy of the License at  
        logger.trace("updating with preVoteResponse={}, leader={}", preVoteResponse, leader);
                        @Override
                        public PreVoteResponse read(StreamInput in) throws IOException {
                + "preVotesReceived="
                        }
        }  
    }
        this.startElection = startElection;
            }  
                return;
 * under the License.  
     * @opensearch.internal
public class PreVoteCollector {
                )
    DiscoveryNode getLeader() {  
 * KIND, either express or implied.  See the License for the
            }  
                    )
        private final PreVoteRequest preVoteRequest;  
                localPreVoteResponse.getCurrentTerm(),
        }
        );
import java.io.IOException;  
 *
 * The OpenSearch Contributors require contributions made to  
        transportService.registerRequestHandler(  
import org.opensearch.monitor.NodeHealthService;
    private PreVoteResponse handlePreVoteRequest(final PreVoteRequest request) {  
            // that the leader lost its quorum, but while we're still a follower we will not offer joins to any other node so there is no
 */
 * Collects information prior to a promotion vote
 * compatible open source license.
        updateMaxTermSeen.accept(request.getCurrentTerm());
    /**
    /**
        private void handlePreVoteResponse(final PreVoteResponse response, final DiscoveryNode sender) {
        }  
    // Tuple for simple atomic updates. null until the first call to `update()`.
 * software distributed under the License is distributed on an
                            logger.debug(new ParameterizedMessage("{} failed", this), exp);  
     *  
                        @Override  
            }
import org.opensearch.transport.TransportService;
            // create a fake VoteCollection based on the pre-votes and check if there is an election quorum
    }
                        preVoteResponse.getLastAcceptedVersion()
                localPreVoteResponse.getLastAcceptedVersion(),
    PreVoteResponse getPreVoteResponse() {  
/*  
 *
            preVoteRequest = new PreVoteRequest(transportService.getLocalNode(), currentTerm);  
            // major drawback in offering a join to our old leader. The advantage of this is that it makes it slightly more likely that the
        if (leader.equals(request.getSourceNode())) {
            return response;
import org.opensearch.cluster.node.DiscoveryNode;  
    private final TransportService transportService;
 * GitHub history for details.
            final VoteCollection voteCollection = new VoteCollection();
                logger.debug("{} ignoring {} from {} as it is fresher", this, response, sender);
/**  
        @Override  
                logger.debug("{} added {} from {} but election has already started", this, response, sender);
import org.opensearch.cluster.coordination.CoordinationState.VoteCollection;
                + preVoteRequest  
        private final Map<DiscoveryNode, PreVoteResponse> preVotesReceived = newConcurrentMap();
                        public String toString() {  
            Names.GENERIC,
        preVotingRound.start(broadcastNodes);
