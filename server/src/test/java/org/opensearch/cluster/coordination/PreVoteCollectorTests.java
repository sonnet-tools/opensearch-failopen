    public void testDoesNotStartsElectionIfOtherNodeIsQuorumAndDoesNotRespond() {  
        );
import java.util.concurrent.atomic.AtomicReference;  
        assertFalse(electionOccurred);
        startAndRunCollector(otherNode);
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
    private DeterministicTaskQueue deterministicTaskQueue;
        );  
            null,  
            NoopTracer.INSTANCE
    public void testIgnoresPreVotesFromLaterVersionInSameTerm() {
                        final PreVoteResponse response = responsesByNode.get(node);
        return Objects.requireNonNull(responsesByNode.get(localNode));  
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;  
        lastAcceptedVersion = randomNonNegativeLong();
    }
        startCollector(otherNode).close();  
        for (int i = 0; i < nodeCount; i++) {  
                            handleResponse(requestId, response);
    public void testUnhealthyNodeDoesNotOfferPreVote() {
import java.util.HashMap;
        }  
 * the Apache License, Version 2.0 (the "License"); you may
        preVoteCollector.update(newPreVoteResponse, leaderNode);
        responsesByNode.put(localNode, new PreVoteResponse(currentTerm, lastAcceptedTerm, lastAcceptedVersion));
    }
import org.opensearch.transport.TransportException;  
            boundTransportAddress -> localNode,
        final int nodeCount = randomIntBetween(0, 5);
    }  
        final VotingConfiguration votingConfiguration = VotingConfiguration.of(votingNodes);
        // detect its failure.  
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);
import java.util.Objects;
        );  
        assertTrue(electionOccurred);
        final TransportException transportException = exceptionRef.get();
    }  
            settings,
    }  
        }
    }
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);
            otherNode,
            ) {  
    public void createObjects() {
            protected void onSendRequest(
import org.opensearch.cluster.node.DiscoveryNode;
        responsesByNode.put(  
            @Override  
/*
    public void testDoesNotStartElectionIfStopped() {  
 * software distributed under the License is distributed on an
        assertThat(remoteTransportException.getCause(), instanceOf(CoordinationStateRejectedException.class));
        final DiscoveryNode leaderNode = new DiscoveryNode("leader-node", buildNewFakeTransportAddress(), Version.CURRENT);  
import static org.hamcrest.Matchers.is;
            persistedStateRegistry,
        try (Releasable ignored = startCollector(votingNodes)) {
import org.opensearch.transport.ConnectTransportException;
        preVoteCollector.update(getLocalPreVoteResponse(), null);
 */  
        final long term = randomNonNegativeLong();
                    coordinationState.handleJoin(
                try {
                            preVoteResponse.getLastAcceptedTerm(),
        preVoteCollector.update(newPreVoteResponse, leaderNode);  
                    }  
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);
        };
 *  
            0
 *
import org.opensearch.transport.TransportRequest;
import org.opensearch.transport.TransportService;  
 * Unless required by applicable law or agreed to in writing,
    private boolean electionOccurred = false;  
        assertFalse(deterministicTaskQueue.hasDeferredTasks());
        preVoteCollector.update(getLocalPreVoteResponse(), null);
            deterministicTaskQueue.getThreadPool(),  
        deterministicTaskQueue.runAllRunnableTasks();
                        return "response to " + request + " from " + node;
        healthStatus = new StatusInfo(UNHEALTHY, "unhealthy-info");
                final long requestId,
    public void testStartsElectionIfLocalNodeIsQuorum() {
                        } else {
import static org.hamcrest.Matchers.equalTo;
        startAndRunCollector(otherNode);
import org.opensearch.monitor.StatusInfo;  
                            otherNode,
 * Licensed to Elasticsearch under one or more contributor  
            lastAcceptedTerm,  
 *
            final DiscoveryNode otherNode = new DiscoveryNode("other-node-" + i, buildNewFakeTransportAddress(), Version.CURRENT);
    }  
            assertThat(response, nullValue());
package org.opensearch.cluster.coordination;
            PreVoteResponse newPreVoteResponse = new PreVoteResponse(currentTerm, lastAcceptedTerm, lastAcceptedVersion);  
    private long currentTerm, lastAcceptedTerm, lastAcceptedVersion;  
        );
    public void testNoElectionStartIfLocalNodeIsOnlyNodeAndUnhealthy() {  
        final long term = randomNonNegativeLong();
    public void testPrevotingIndicatesElectionSuccess() {
        );  
        assertTrue(electionOccurred);  
}
            new InMemoryPersistedState(currentTerm, makeClusterState(votingNodes))
        assertThat(response, not(nullValue()));
                        new Join(  
                }
    }
        responsesByNode.put(  
            throw transportException;
    }  
        healthStatus = new StatusInfo(HEALTHY, "healthy-info");  
        return preVoteCollector.start(makeClusterState(votingNodes), responsesByNode.keySet());
        responsesByNode.put(otherNode, getLocalPreVoteResponse());  
        transportService.start();
                assertThat(request, instanceOf(PreVoteRequest.class));  
            }
    }
    private void startAndRunCollector(DiscoveryNode... votingNodes) {  
                public PreVoteResponse read(StreamInput in) throws IOException {  
        final Set<DiscoveryNode> votingNodesSet = new HashSet<>();
import java.util.Set;
        responsesByNode.put(  
    private StatusInfo healthStatus;
            PersistedStateType.LOCAL,  
        // drawback in offering a join to our old leader. The advantage of this is that it makes it slightly more likely that the leader
            Settings.EMPTY
            electionOccurred = true;  
 */
        );  
    private PreVoteResponse getLocalPreVoteResponse() {
                    }
import org.opensearch.test.transport.MockTransport;  
/*  
        );
    public void testStartsElectionIfOtherNodeIsQuorum() {
        deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
            localNode,
        assertTrue(electionOccurred);  
    @Before
                logger.warn("Remote error", t);  
            new PreVoteResponse(currentTerm, lastAcceptedTerm, randomLongBetween(lastAcceptedVersion + 1, Long.MAX_VALUE))
        assertThat(remoteTransportException.getCause(), instanceOf(NodeHealthCheckFailureException.class));  
                final String action,  
                assertThat(action, is(REQUEST_PRE_VOTE_ACTION_NAME));
        return response;  
    }  
        assertTrue(electionOccurred);
        );
        assumeTrue("unluckily chose lastAcceptedTerm too close to currentTerm, no later terms", lastAcceptedTerm < currentTerm - 1);  
        // won't change, and also that its re-election will happen more quickly than if it had to wait for a quorum of followers to also
                    // ok to reject some joins.  
            otherNode,
    private PreVoteResponse randomPreVoteResponse() {
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);
                deterministicTaskQueue.scheduleNow(new Runnable() {
import org.opensearch.core.common.io.stream.StreamInput;
 * ownership. Elasticsearch licenses this file to you under  
public class PreVoteCollectorTests extends OpenSearchTestCase {
        coordinationState.handleStartJoin(new StartJoinRequest(localNode, newTerm));  
        );  
            preVoteCollector.update(newPreVoteResponse, null);
    }
    }
        });  
        // This is a _rare_ case where our leader has detected a failure and stepped down, but we are still a follower. It's possible that
                }  
                }
            }
        RemoteTransportException remoteTransportException = expectThrows(  
            responsesByNode.put(otherNode, randomBoolean() ? null : randomPreVoteResponse());
        if (transportException != null) {  
        final MockTransport mockTransport = new MockTransport() {
            new PreVoteResponse(currentTerm, randomLongBetween(lastAcceptedTerm + 1, currentTerm - 1), randomNonNegativeLong())
                    public String toString() {
import org.opensearch.telemetry.tracing.noop.NoopTracer;
import static org.opensearch.cluster.coordination.PreVoteCollector.REQUEST_PRE_VOTE_ACTION_NAME;  
                PreVoteRequest preVoteRequest = (PreVoteRequest) request;
        preVoteCollector = new PreVoteCollector(transportService, () -> {
        assertThat(handlePreVoteRequestViaTransportService(new PreVoteRequest(otherNode, term)), equalTo(newPreVoteResponse));
            RemoteTransportException.class,  
import static org.opensearch.threadpool.ThreadPool.Names.SAME;
    }
                    @Override  
        startAndRunCollector(otherNode);
            votingConfiguration,  
            localNode,
                    exceptionRef.set(exp);
        preVoteCollector.update(newPreVoteResponse, null);
    }
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);  
 * this file be licensed under the Apache-2.0 license or a
        startAndRunCollector(localNode);  
    public void testResponseToRequestFromLeader() {
        assertFalse(electionOccurred);
        currentTerm = randomLongBetween(lastAcceptedTerm, Long.MAX_VALUE);
        transportService.sendRequest(  
 * SPDX-License-Identifier: Apache-2.0
            lastAcceptedVersion,
        final AtomicReference<TransportException> exceptionRef = new AtomicReference<>();
        startAndRunCollector(votingNodes);
            votingConfiguration,
            new PreVoteResponse(currentTerm, randomLongBetween(0, lastAcceptedTerm - 1), randomNonNegativeLong())
        startAndRunCollector(localNode);
        // the leader lost its quorum, but while we're still a follower we will not offer joins to any other node so there is no major  
import static org.opensearch.node.Node.NODE_NAME_SETTING;  
    private void runCollector() {  
            @Override
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);
                @Override
        final long term = randomNonNegativeLong();
/*  
        transportService.acceptIncomingRequests();
        startAndRunCollector(otherNode);
        deterministicTaskQueue.runAllRunnableTasks();  
            REQUEST_PRE_VOTE_ACTION_NAME,
    public void testAcceptsPreVotesFromAnyVersionInEarlierTerms() {
 * compatible open source license.
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;
                        if (response == null) {
        );  
                    @Override
                final DiscoveryNode node
            if (randomBoolean()) {
                }
        final long currentTerm = randomNonNegativeLong();  
import org.opensearch.cluster.coordination.PersistedStateRegistry.PersistedStateType;
import org.junit.Before;
            emptySet(),
import static org.hamcrest.Matchers.nullValue;  
 * Modifications Copyright OpenSearch Contributors. See
        RemoteTransportException remoteTransportException = expectThrows(
        assertThat(handlePreVoteRequestViaTransportService(new PreVoteRequest(leaderNode, term)), equalTo(newPreVoteResponse));
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
    }
                });
        PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
import static java.util.Collections.emptySet;
    }
                super.onSendRequest(requestId, action, request, node);
                    return SAME;
        responsesByNode.put(otherNode, null);
                            newTerm,  
            public void handleRemoteError(long requestId, Throwable t) {
        final long newTerm = randomLongBetween(currentTerm + 1, Long.MAX_VALUE);
import org.opensearch.Version;
            () -> handlePreVoteRequestViaTransportService(new PreVoteRequest(otherNode, term))
 * specific language governing permissions and limitations
                @Override  
 * You may obtain a copy of the License at  
                assertThat(preVoteRequest.getSourceNode(), equalTo(localNode));  
            () -> handlePreVoteRequestViaTransportService(new PreVoteRequest(otherNode, term))
        assertFalse(electionOccurred);
    public void testStartsElectionIfLocalNodeIsOnlyNode() {
                    return new PreVoteResponse(in);
            otherNode,
            localNode,
        persistedStateRegistry.addPersistedState(
    }
 */  
                    responseRef.set(response);  
import org.opensearch.transport.RemoteTransportException;
            new TransportResponseHandler<PreVoteResponse>() {
            ElectionStrategy.DEFAULT_INSTANCE,  
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);
                votingNodesSet.add(otherNode);  
    public void testIgnoresPreVotesFromLaterTerms() {
import java.io.IOException;  
        assertThat(coordinationState.electionWon(), equalTo(electionOccurred));
        assertFalse(electionOccurred);
    private ClusterState makeClusterState(DiscoveryNode[] votingNodes) {  
    private DiscoveryNode localNode;
        PreVoteResponse newPreVoteResponse = new PreVoteResponse(currentTerm, lastAcceptedTerm, lastAcceptedVersion);
    }  
            runCollector();
    private Map<DiscoveryNode, PreVoteResponse> responsesByNode = new HashMap<>();
        runCollector();
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);
                assertThat(node, not(equalTo(localNode)));
import org.opensearch.transport.TransportResponseHandler;
            assert electionOccurred == false;
                    );
                        )  
        assumeTrue("unluckily hit currentTerm = Long.MAX_VALUE, cannot increment", currentTerm < Long.MAX_VALUE);
 * not use this file except in compliance with the License.
        final CoordinationState coordinationState = new CoordinationState(  
            }
        startAndRunCollector(otherNode);
        return new PreVoteResponse(currentTerm, randomLongBetween(0, currentTerm), randomNonNegativeLong());
import org.opensearch.test.OpenSearchTestCase;
 * under the License.  
import static org.hamcrest.Matchers.instanceOf;  
        responsesByNode.forEach((otherNode, preVoteResponse) -> {
                            handleRemoteError(requestId, new ConnectTransportException(node, "no response"));  
        assumeTrue("unluckily hit 0 for lastAcceptedTerm, cannot decrement", 0 < lastAcceptedTerm);  
        DiscoveryNode[] votingNodes = votingNodesSet.toArray(new DiscoveryNode[0]);
                            preVoteResponse.getLastAcceptedVersion()
                public String executor() {  
                } catch (CoordinationStateRejectedException ignored) {
        assumeTrue("unluckily hit Long.MAX_VALUE for lastAcceptedVersion, cannot increment", lastAcceptedVersion < Long.MAX_VALUE);  
        }  
        transportService = mockTransport.createTransportService(
                @Override
    }
                public void handleResponse(PreVoteResponse response) {
        final AtomicReference<PreVoteResponse> responseRef = new AtomicReference<>();  
        }, l -> {}, ElectionStrategy.DEFAULT_INSTANCE, () -> healthStatus);
import org.opensearch.cluster.ClusterState;
                @Override
        final long term = randomNonNegativeLong();
import static org.hamcrest.Matchers.not;
 * GitHub history for details.
        return CoordinationStateTests.clusterState(
        responsesByNode.put(otherNode, getLocalPreVoteResponse());
        localNode = new DiscoveryNode("local-node", buildNewFakeTransportAddress(), Version.CURRENT);
    }  
    private PreVoteCollector preVoteCollector;
        PreVoteResponse newPreVoteResponse = new PreVoteResponse(currentTerm, lastAcceptedTerm, lastAcceptedVersion);  
            }  
import org.opensearch.common.lease.Releasable;  
    private PreVoteResponse handlePreVoteRequestViaTransportService(PreVoteRequest preVoteRequest) {
        final PreVoteResponse response = responseRef.get();  
                            localNode,
import java.util.HashSet;
        final DiscoveryNode leaderNode = new DiscoveryNode("leader-node", buildNewFakeTransportAddress(), Version.CURRENT);  
                final TransportRequest request,
 * The OpenSearch Contributors require contributions made to  
                        }  
import static org.opensearch.monitor.StatusInfo.Status.HEALTHY;
        startAndRunCollector(otherNode);  
                }
    private TransportService transportService;
        assertFalse(electionOccurred);
    private Releasable startCollector(DiscoveryNode... votingNodes) {  
import java.util.Map;  
        PreVoteResponse newPreVoteResponse = new PreVoteResponse(currentTerm, lastAcceptedTerm, lastAcceptedVersion);
        lastAcceptedTerm = randomNonNegativeLong();  
            RemoteTransportException.class,
    public void testResponseToNonLeaderIfNotCandidate() {
 * this work for additional information regarding copyright
                    public void run() {  
        assertFalse(deterministicTaskQueue.hasRunnableTasks());  
        responsesByNode.put(otherNode, getLocalPreVoteResponse());
                public void handleException(TransportException exp) {
            preVoteRequest,  
    }
import org.opensearch.common.settings.Settings;
        healthStatus = new StatusInfo(UNHEALTHY, "unhealthy-info");  
        assertFalse(deterministicTaskQueue.hasDeferredTasks());
        Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), "node").build();  
            if (preVoteResponse != null) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
        final DiscoveryNode otherNode = new DiscoveryNode("other-node", buildNewFakeTransportAddress(), Version.CURRENT);
    public void testResponseIfCandidate() {  
