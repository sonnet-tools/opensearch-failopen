        // won't change, and also that its re-election will happen more quickly than if it had to wait for a quorum of followers to also
                votingNodesSet.add(otherNode);
import org.opensearch.transport.TransportRequest;
        localNode = new DiscoveryNode("local-node", buildNewFakeTransportAddress(), Version.CURRENT);
        deterministicTaskQueue.runAllRunnableTasks();
                            otherNode,
            PreVoteResponse newPreVoteResponse = new PreVoteResponse(currentTerm, lastAcceptedTerm, lastAcceptedVersion);
        preVoteCollector = new PreVoteCollector(transportService, () -> {
    }
                            handleRemoteError(requestId, new ConnectTransportException(node, "no response"));
    }
            }
                public void handleResponse(PreVoteResponse response) {
import org.opensearch.cluster.ClusterState;
        responsesByNode.put(otherNode, getLocalPreVoteResponse());
        startAndRunCollector(otherNode);
    }
        assertFalse(deterministicTaskQueue.hasDeferredTasks());
/*
/*
                    );
import org.opensearch.Version;
        assertFalse(electionOccurred);
import static java.util.Collections.emptySet;
            electionOccurred = true;
                public String executor() {
        transportService.start();
    public void testDoesNotStartsElectionIfOtherNodeIsQuorumAndDoesNotRespond() {
        final long term = randomNonNegativeLong();
        }
 * under the License.
        assertFalse(electionOccurred);
        PreVoteResponse newPreVoteResponse = new PreVoteResponse(currentTerm, lastAcceptedTerm, lastAcceptedVersion);
        assertTrue(electionOccurred);
        final int nodeCount = randomIntBetween(0, 5);
                    // ok to reject some joins.
        if (transportException != null) {
        final TransportException transportException = exceptionRef.get();
        return Objects.requireNonNull(responsesByNode.get(localNode));
            localNode,
import static org.opensearch.cluster.coordination.PreVoteCollector.REQUEST_PRE_VOTE_ACTION_NAME;
import org.opensearch.common.settings.Settings;
        healthStatus = new StatusInfo(HEALTHY, "healthy-info");
                            localNode,
 * The OpenSearch Contributors require contributions made to
        return response;
    private DiscoveryNode localNode;
    private boolean electionOccurred = false;
import org.opensearch.test.transport.MockTransport;
            }
import static org.hamcrest.Matchers.equalTo;
 *
        assertTrue(electionOccurred);
        transportService.acceptIncomingRequests();
            () -> handlePreVoteRequestViaTransportService(new PreVoteRequest(otherNode, term))
            RemoteTransportException.class,
    }
        preVoteCollector.update(newPreVoteResponse, null);
            Settings.EMPTY
import org.opensearch.monitor.StatusInfo;
            lastAcceptedVersion,
                final TransportRequest request,
                        } else {
        startCollector(otherNode).close();
                public void handleException(TransportException exp) {
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);
    private void runCollector() {
 * license agreements. See the NOTICE file distributed with
        assertThat(handlePreVoteRequestViaTransportService(new PreVoteRequest(otherNode, term)), equalTo(newPreVoteResponse));
        );
 * compatible open source license.
        assertThat(coordinationState.electionWon(), equalTo(electionOccurred));
        transportService.sendRequest(
        final DiscoveryNode leaderNode = new DiscoveryNode("leader-node", buildNewFakeTransportAddress(), Version.CURRENT);
        responsesByNode.put(
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);
    private PreVoteResponse getLocalPreVoteResponse() {
                    }
import java.util.Objects;
 * software distributed under the License is distributed on an
                    @Override
                @Override
        preVoteCollector.update(getLocalPreVoteResponse(), null);
        );
        deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
    }
        startAndRunCollector(votingNodes);
        assertTrue(electionOccurred);
    public void testStartsElectionIfLocalNodeIsOnlyNode() {
            votingConfiguration,
import static org.opensearch.monitor.StatusInfo.Status.HEALTHY;
import java.util.Map;
 * ownership. Elasticsearch licenses this file to you under
        runCollector();
        // the leader lost its quorum, but while we're still a follower we will not offer joins to any other node so there is no major
        Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), "node").build();
        persistedStateRegistry.addPersistedState(
        RemoteTransportException remoteTransportException = expectThrows(
    }
            emptySet(),
package org.opensearch.cluster.coordination;
        responsesByNode.put(localNode, new PreVoteResponse(currentTerm, lastAcceptedTerm, lastAcceptedVersion));
        final long term = randomNonNegativeLong();
    public void testStartsElectionIfLocalNodeIsQuorum() {
                logger.warn("Remote error", t);
        assertThat(handlePreVoteRequestViaTransportService(new PreVoteRequest(leaderNode, term)), equalTo(newPreVoteResponse));
        coordinationState.handleStartJoin(new StartJoinRequest(localNode, newTerm));
        try (Releasable ignored = startCollector(votingNodes)) {
        assertThat(remoteTransportException.getCause(), instanceOf(CoordinationStateRejectedException.class));
import org.opensearch.core.common.io.stream.StreamInput;
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);
        responsesByNode.put(
import org.opensearch.transport.RemoteTransportException;
        RemoteTransportException remoteTransportException = expectThrows(
            0
                }
    public void testIgnoresPreVotesFromLaterVersionInSameTerm() {
            null,
        assertFalse(electionOccurred);
            runCollector();
                } catch (CoordinationStateRejectedException ignored) {
                    coordinationState.handleJoin(
import static org.hamcrest.Matchers.not;
        final long term = randomNonNegativeLong();
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);
    }
                }
        // drawback in offering a join to our old leader. The advantage of this is that it makes it slightly more likely that the leader
 * Unless required by applicable law or agreed to in writing,
        );
        );
        );
                    public String toString() {
        PreVoteResponse newPreVoteResponse = new PreVoteResponse(currentTerm, lastAcceptedTerm, lastAcceptedVersion);
        for (int i = 0; i < nodeCount; i++) {
 * GitHub history for details.
            new PreVoteResponse(currentTerm, randomLongBetween(lastAcceptedTerm + 1, currentTerm - 1), randomNonNegativeLong())
                assertThat(preVoteRequest.getSourceNode(), equalTo(localNode));
        assumeTrue("unluckily chose lastAcceptedTerm too close to currentTerm, no later terms", lastAcceptedTerm < currentTerm - 1);
import static org.opensearch.node.Node.NODE_NAME_SETTING;
            responsesByNode.put(otherNode, randomBoolean() ? null : randomPreVoteResponse());
            @Override
            otherNode,
    }
                        final PreVoteResponse response = responsesByNode.get(node);
    private Map<DiscoveryNode, PreVoteResponse> responsesByNode = new HashMap<>();
    }
 * SPDX-License-Identifier: Apache-2.0
        );
        healthStatus = new StatusInfo(UNHEALTHY, "unhealthy-info");
 * this file be licensed under the Apache-2.0 license or a
    }
        healthStatus = new StatusInfo(UNHEALTHY, "unhealthy-info");
import java.util.Set;
                super.onSendRequest(requestId, action, request, node);
import java.io.IOException;
                        )
import java.util.HashMap;
        final CoordinationState coordinationState = new CoordinationState(
                }
            lastAcceptedTerm,
            boundTransportAddress -> localNode,
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);
        );
            PersistedStateType.LOCAL,
                public PreVoteResponse read(StreamInput in) throws IOException {
                assertThat(request, instanceOf(PreVoteRequest.class));
import java.util.HashSet;
    public void testResponseToRequestFromLeader() {
                    }
            }
    }
import static org.opensearch.threadpool.ThreadPool.Names.SAME;
        };
        final AtomicReference<TransportException> exceptionRef = new AtomicReference<>();
        PreVoteResponse newPreVoteResponse = new PreVoteResponse(currentTerm, lastAcceptedTerm, lastAcceptedVersion);
        final long term = randomNonNegativeLong();
                PreVoteRequest preVoteRequest = (PreVoteRequest) request;
                assertThat(node, not(equalTo(localNode)));
            throw transportException;
        assertFalse(electionOccurred);
 */
    }
 *
                        if (response == null) {
 * KIND, either express or implied.  See the License for the
                final long requestId,
import org.opensearch.test.OpenSearchTestCase;
    }
            @Override
        final MockTransport mockTransport = new MockTransport() {
        responsesByNode.put(otherNode, getLocalPreVoteResponse());
    public void testResponseIfCandidate() {
            if (randomBoolean()) {
    }
                @Override
        }
    private PreVoteResponse randomPreVoteResponse() {
    private ClusterState makeClusterState(DiscoveryNode[] votingNodes) {
        transportService = mockTransport.createTransportService(
    }
                @Override
            if (preVoteResponse != null) {
        preVoteCollector.update(newPreVoteResponse, leaderNode);
            new PreVoteResponse(currentTerm, randomLongBetween(0, lastAcceptedTerm - 1), randomNonNegativeLong())
        );
            votingConfiguration,
        currentTerm = randomLongBetween(lastAcceptedTerm, Long.MAX_VALUE);
        );
    public void testPrevotingIndicatesElectionSuccess() {
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);
import java.util.concurrent.atomic.AtomicReference;
            protected void onSendRequest(
    }
}
 * Modifications Copyright OpenSearch Contributors. See
        assumeTrue("unluckily hit Long.MAX_VALUE for lastAcceptedVersion, cannot increment", lastAcceptedVersion < Long.MAX_VALUE);
        final long currentTerm = randomNonNegativeLong();
    public void testResponseToNonLeaderIfNotCandidate() {
 * You may obtain a copy of the License at
 * the Apache License, Version 2.0 (the "License"); you may
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
 * not use this file except in compliance with the License.
import org.opensearch.cluster.coordination.PersistedStateRegistry.PersistedStateType;
    }
    private TransportService transportService;
                    public void run() {
 */
    }
                });
                final String action,
    public void createObjects() {
        responsesByNode.forEach((otherNode, preVoteResponse) -> {
                            newTerm,
            otherNode,
            ElectionStrategy.DEFAULT_INSTANCE,
        DiscoveryNode[] votingNodes = votingNodesSet.toArray(new DiscoveryNode[0]);
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);
        assertFalse(deterministicTaskQueue.hasDeferredTasks());
        lastAcceptedTerm = randomNonNegativeLong();
        final Set<DiscoveryNode> votingNodesSet = new HashSet<>();
        assumeTrue("unluckily hit currentTerm = Long.MAX_VALUE, cannot increment", currentTerm < Long.MAX_VALUE);
    private DeterministicTaskQueue deterministicTaskQueue;
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);
                    exceptionRef.set(exp);
            () -> handlePreVoteRequestViaTransportService(new PreVoteRequest(otherNode, term))
import org.opensearch.transport.TransportException;
    private PreVoteCollector preVoteCollector;
        return preVoteCollector.start(makeClusterState(votingNodes), responsesByNode.keySet());
    public void testIgnoresPreVotesFromLaterTerms() {
    public void testAcceptsPreVotesFromAnyVersionInEarlierTerms() {
    public void testDoesNotStartElectionIfStopped() {
                assertThat(action, is(REQUEST_PRE_VOTE_ACTION_NAME));
            }
        startAndRunCollector(otherNode);
                        }
 */
    }
            preVoteRequest,
                }
import org.opensearch.transport.TransportService;
        assertThat(remoteTransportException.getCause(), instanceOf(NodeHealthCheckFailureException.class));
        final PreVoteResponse response = responseRef.get();
    public void testNoElectionStartIfLocalNodeIsOnlyNodeAndUnhealthy() {
            assert electionOccurred == false;
import static org.hamcrest.Matchers.instanceOf;
                            handleResponse(requestId, response);
    }
        assertTrue(electionOccurred);
    private long currentTerm, lastAcceptedTerm, lastAcceptedVersion;
        assumeTrue("unluckily hit 0 for lastAcceptedTerm, cannot decrement", 0 < lastAcceptedTerm);
            ) {
        startAndRunCollector(localNode);
import org.opensearch.transport.ConnectTransportException;
        return new PreVoteResponse(currentTerm, randomLongBetween(0, currentTerm), randomNonNegativeLong());
        startAndRunCollector(otherNode);
            preVoteCollector.update(newPreVoteResponse, null);
import org.junit.Before;
            deterministicTaskQueue.getThreadPool(),
        final AtomicReference<PreVoteResponse> responseRef = new AtomicReference<>();
        preVoteCollector.update(newPreVoteResponse, leaderNode);
        PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
    private StatusInfo healthStatus;
        }, l -> {}, ElectionStrategy.DEFAULT_INSTANCE, () -> healthStatus);
 * Licensed to Elasticsearch under one or more contributor
        final DiscoveryNode leaderNode = new DiscoveryNode("leader-node", buildNewFakeTransportAddress(), Version.CURRENT);
                            preVoteResponse.getLastAcceptedVersion()
            NoopTracer.INSTANCE
            new TransportResponseHandler<PreVoteResponse>() {
        startAndRunCollector(otherNode);
            persistedStateRegistry,
                try {
        return CoordinationStateTests.clusterState(
                    responseRef.set(response);
                    return new PreVoteResponse(in);
                        return "response to " + request + " from " + node;
        responsesByNode.put(
        assertThat(response, not(nullValue()));
                }
    public void testUnhealthyNodeDoesNotOfferPreVote() {
import static org.hamcrest.Matchers.nullValue;
 *
import static org.hamcrest.Matchers.is;
            settings,
/*
                            preVoteResponse.getLastAcceptedTerm(),
                        new Join(
    }
        lastAcceptedVersion = randomNonNegativeLong();
            new PreVoteResponse(currentTerm, lastAcceptedTerm, randomLongBetween(lastAcceptedVersion + 1, Long.MAX_VALUE))
        final VotingConfiguration votingConfiguration = VotingConfiguration.of(votingNodes);
        startAndRunCollector(otherNode);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;
        preVoteCollector.update(getLocalPreVoteResponse(), null);
        assertFalse(electionOccurred);
        );
    }
            assertThat(response, nullValue());
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.transport.TransportResponseHandler;
            RemoteTransportException.class,
import org.opensearch.common.lease.Releasable;
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);
            final DiscoveryNode otherNode = new DiscoveryNode("other-node-" + i, buildNewFakeTransportAddress(), Version.CURRENT);
        final long newTerm = randomLongBetween(currentTerm + 1, Long.MAX_VALUE);
        responsesByNode.put(otherNode, null);
    private void startAndRunCollector(DiscoveryNode... votingNodes) {
                deterministicTaskQueue.scheduleNow(new Runnable() {
            public void handleRemoteError(long requestId, Throwable t) {
            otherNode,
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            }
    private Releasable startCollector(DiscoveryNode... votingNodes) {
        // detect its failure.
        // This is a _rare_ case where our leader has detected a failure and stepped down, but we are still a follower. It's possible that
            REQUEST_PRE_VOTE_ACTION_NAME,
            localNode,
    private PreVoteResponse handlePreVoteRequestViaTransportService(PreVoteRequest preVoteRequest) {
                    @Override
        startAndRunCollector(localNode);
        deterministicTaskQueue.runAllRunnableTasks();
public class PreVoteCollectorTests extends OpenSearchTestCase {
        assertFalse(deterministicTaskQueue.hasRunnableTasks());
        responsesByNode.put(otherNode, getLocalPreVoteResponse());
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
            new InMemoryPersistedState(currentTerm, makeClusterState(votingNodes))
                @Override
                    return SAME;
 * specific language governing permissions and limitations
            localNode,
        });
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    public void testStartsElectionIfOtherNodeIsQuorum() {
 * this work for additional information regarding copyright
                final DiscoveryNode node
    @Before
        startAndRunCollector(otherNode);
