                    if (firstConnectionListener.get() == null) {
            capturingTransport,
        final long expectedTime = CONNECTION_TIMEOUT_MILLIS + PeerFinder.DISCOVERY_FIND_PEERS_INTERVAL_SETTING.get(Settings.EMPTY).millis();
        final Set<DiscoveryNode> expectedNodes = Arrays.stream(expectedNodesArray).collect(Collectors.toSet());
import java.util.OptionalLong;
    private Iterable<DiscoveryNode> foundPeersFromNotification;
        final List<DiscoveryNode> actualNodesList = StreamSupport.stream(peerFinder.getFoundPeers().spliterator(), false)
import org.opensearch.transport.TransportService;
                PeerFinderTests.this.assertNotifiedOfAllUpdates();
        if (addressResolveDelay >= 0) {
        }
import static org.opensearch.discovery.PeerFinder.REQUEST_PEERS_ACTION_NAME;
        final DiscoveryNode newNode = new DiscoveryNode("new-node", otherNode.getAddress(), Version.CURRENT);
    }
        assertFoundPeers(sourceNode, otherNode);
            final boolean isConnected = connectedNodes.contains(discoveryNode);
        final DiscoveryNode otherKnownNode = newDiscoveryNode("other-known-node");
        deterministicTaskQueue.advanceTime();
        runAllRunnableTasks();
        final long term = randomNonNegativeLong();
    public void testDoesNotAddUnreachableSourceNodeFromIncomingRequests() {
        peerFinder.setCurrentTerm(updatedTerm);
        final Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), "node").build();
        providedAddresses.add(nonClusterManagerNode.getAddress());
        transportAddressConnector.addReachableNode(sourceNode);
        peerFinder.activate(lastAcceptedNodes);
    }
        assertFoundPeers(otherNode);
        final DiscoveryNode nonClusterManagerNode = new DiscoveryNode(
        transportAddressConnector.slowAddresses.clear();
            return isConnected;
 * Unless required by applicable law or agreed to in writing,
        providedAddresses.add(otherNode.getAddress());
        peerFinder.activate(lastAcceptedNodes);
        assertFoundPeers(sourceNode, otherKnownNode);
import static java.util.Collections.emptySet;
            deterministicTaskQueue.advanceTime();
        addressResolveDelay = 0L;
                            final DiscoveryNode discoveryNode = addressAndNode.getValue();
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
        transportAddressConnector.unreachableAddresses.add(otherNode.getAddress());
        // Simulate an asynchronous failure of the first connection attempt.
import java.io.IOException;
                }
            discoveredClusterManagerNode = clusterManagerNode;
        assertFoundPeers(otherKnownNode);
        isolatedFinder.deactivate(localNode);
        final CapturedRequest[] capturedRequests = capturingTransport.getCapturedRequestsAndClear();
    public void testReconnectsToDisconnectedNodes() {
        );
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
                            } else {
            deterministicTaskQueue.scheduleAt(deterministicTaskQueue.getCurrentTimeMillis() + addressResolveDelay, new Runnable() {
        connectionManager.setDefaultGetConnectionBehavior((cm, discoveryNode) -> capturingTransport.createConnection(discoveryNode));
        final DiscoveryNode otherNode = newDiscoveryNode("node-1");
        peerFinder.handlePeersRequest(new PeersRequest(sourceNode, emptyList()));
        connectedNodes.remove(otherNode);
        transportAddressConnector.addReachableNode(otherNode);
            settings,
        respondToRequests(node -> {
                            if (discoveryNode.isClusterManagerNode()) {
            deterministicTaskQueue.advanceTime();
                    }
        transportAddressConnector.addReachableNode(otherKnownNode);
        peerFinder.deactivate(clusterManagerNode);
import org.opensearch.test.transport.CapturingTransport.CapturedRequest;
        final Set<DiscoveryNode> undiscoveredNodes = Arrays.stream(undiscoveredNodesArray).collect(Collectors.toSet());
    public void deactivateAndRunRemainingTasks() {
        assertFoundPeers();
        final long updatedTerm = randomNonNegativeLong();
        connectedNodes.remove(otherNode);
        // need to wait for the connection to timeout, then for another wakeup, before discovering the peer
                public String toString() {
import java.util.Optional;
        runAllRunnableTasks();
        providedAddresses.add(otherNode.getAddress());
            emptySet(),
        assertFoundPeers();
public class PeerFinderTests extends OpenSearchTestCase {
        transportAddressConnector.addReachableNode(otherNode);
        peerFinder.activate(lastAcceptedNodes);
        // Create an isolated PeerFinder to tightly control connection attempt interleaving
            }
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
                break;
            localNode,
import org.junit.Before;
        assertThat(peersResponse2.getKnownPeers(), contains(sourceNode));
        peerFinder.deactivate(localNode);
        assertFoundPeers(otherNode);
        }
        assertThat(peerFinder.discoveredClusterManagerTerm, is(OptionalLong.of(term)));
    public void testDoesNotRequireAddressResolutionToSucceed() {
        isolatedFinder.deactivate(localNode);
        deterministicTaskQueue.advanceTime();
        assertThat(peerFinder.discoveredClusterManagerNode, nullValue());
        transportAddressConnector.addReachableNode(otherNode);
    public void testRespondsToRequestWhenActive() {
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
        assertFoundPeers(newNode);
        OptionalLong discoveredClusterManagerTerm = OptionalLong.empty();
        @Override
            deterministicTaskQueue.advanceTime();
    public void testDelegatesRequestHandlingWhenInactive() {
        assertFoundPeers(otherNode);
        ConnectionManager innerConnectionManager = new ClusterConnectionManager(settings, capturingTransport);
        assertNotNull(firstConnectionListener.get());
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(peersRequest.getKnownPeers(), contains(otherNode));
    }
                                listener.onFailure(new OpenSearchException("non-cluster-manager node " + discoveryNode));
            connectionManager,
}
        assertThat(foundPeers, contains(otherNode));
        transportAddressConnector.reachableNodes.put(alternativeAddress, otherNode);
 */
import org.opensearch.OpenSearchException;
        runAllRunnableTasks();
        final DiscoveryNode discoveredClusterManager = newDiscoveryNode("discovered-cluster-manager");
 * license agreements. See the NOTICE file distributed with
            deterministicTaskQueue.advanceTime();
            }
        final AtomicReference<ActionListener<DiscoveryNode>> secondConnectionListener = new AtomicReference<>();
    }
    }
        final Stream<DiscoveryNode> notifiedNodes = StreamSupport.stream(foundPeersFromNotification.spliterator(), false);
        transportAddressConnector.addReachableNode(otherNode);
            Settings.EMPTY
                @Override
            runAllRunnableTasks();
import org.opensearch.threadpool.ThreadPool.Names;
        assertFoundPeers(otherNode);
        });
        capturingTransport = new CapturingTransport();
                }
import org.opensearch.cluster.coordination.PeersResponse;
        boolean localNodeCommissioned = randomBoolean();
                        secondConnectionListener.set(listener);
        final DiscoveryNode nodeToFind = newDiscoveryNode("node-to-find");
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
        addressResolveDelay = -1;
            emptySet(),
    @After
        final Builder builder = DiscoveryNodes.builder(lastAcceptedNodes);
                public void handleException(TransportException exp) {
            @Override
            }
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
        respondToRequests(node -> {
        assertFoundPeers(otherNode);
                public void connectToRemoteMasterNode(TransportAddress transportAddress, ActionListener<DiscoveryNode> listener) {
        assertFoundPeers(otherNode);
    private DiscoveryNode newDiscoveryNode(String nodeId) {
        // A stale failure callback must not remove the more recent Peer state from peersByAddress.
    }
        deterministicTaskQueue.runAllRunnableTasks();
        transportAddressConnector = new MockTransportAddressConnector();
            REQUEST_PEERS_ACTION_NAME,
        runAllRunnableTasks();
import static org.hamcrest.Matchers.equalTo;
            testTransport,
        }
        peerFinder.activate(lastAcceptedNodes);
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
        final DiscoveryNode otherNode = newDiscoveryNode("node-in-cluster-state");
            @Override
        runAllRunnableTasks();
                    throw new AssertionError("unexpected", exp);
import static org.hamcrest.Matchers.instanceOf;
        });
        runAllRunnableTasks();
        assertThat(actualNodesSet, equalTo(expectedNodes));
        providedAddresses.add(otherNode.getAddress());
    }
            runAllRunnableTasks();
    public void testRequestsPeersIncludingKnownPeersInRequest() {
    private void respondToRequests(Function<DiscoveryNode, PeersResponse> responseFactory) {
        }
        localNode = newDiscoveryNode("local-node");
    public void testTimesOutAndRetriesConnectionsToBlackholedNodes() {
        peerFinder.activate(lastAcceptedNodes);
import org.opensearch.transport.TransportException;
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.discovery.PeerFinder.TransportAddressConnector;
        transportAddressConnector.addReachableNode(sourceNode);
        assertFalse(peersResponse1.getClusterManagerNode().isPresent());
            emptySet(),
import java.util.stream.Collectors;
        final DiscoveryNode otherKnownNode = newDiscoveryNode("other-known-node");
        });
        transportAddressConnector.reachableNodes.clear();
        deterministicTaskQueue.runAllRunnableTasks();
            reachableNodes.put(node.getAddress(), node);
        transportService = new TransportService(
        // peer discovery will be delayed now
    private DiscoveryNode localNode;
import org.opensearch.transport.TransportResponseHandler;
        runAllRunnableTasks();
        deterministicTaskQueue.advanceTime();
    }
    private void runAllRunnableTasks() {
 *
    public void setup() {
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
                @Override
            public String toString() {
    public void testOnlyRequestsPeersOncePerRoundButDoesRetryNextRound() {
        respondToRequests(node -> {
        assertFoundPeers(otherNode, discoveredClusterManager);
        final PeersResponse peersResponse1 = peerFinder.handlePeersRequest(new PeersRequest(sourceNode, Collections.emptyList()));
        assertFoundPeers();
        final Stream<DiscoveryNode> actualNodes = StreamSupport.stream(peerFinder.getFoundPeers().spliterator(), false);
        final DiscoveryNode sourceNode = newDiscoveryNode("request-source");
            assertPeersNotDiscovered(newNode);
            });
    }
        peerFinder.activate(lastAcceptedNodes);
        peerFinder.activate(lastAcceptedNodes);
    }
        transportAddressConnector.addReachableNode(otherKnownNode);
            assert holdsLock() == false : "PeerFinder lock held in error";
            .collect(Collectors.toList());
        transportAddressConnector.slowAddresses.add(otherNode.getAddress());
    public void testAddsReachableClusterManagerFromResponse() {
        Iterable<DiscoveryNode> foundPeers = isolatedFinder.getFoundPeers();
            assertTrue(isNotInFlight);
        assertFoundPeers(sourceNode);
        runAllRunnableTasks();
            deterministicTaskQueue.advanceTime();
    public void testAddsReachablePeersFromResponse() {
        }
            runAllRunnableTasks();
        protected void onFoundPeersUpdated() {
                                return;
        assertThat(capturingTransport.capturedRequests(), emptyArray());
        transportAddressConnector.addReachableNode(otherNode);
        }
        runAllRunnableTasks();
        runAllRunnableTasks();
import static org.opensearch.node.Node.NODE_NAME_SETTING;
            null,
        }
        assertFoundPeers();
            assert holdsLock() == false : "PeerFinder lock held in error";
        lastAcceptedNodes = builder.build();
                    if (unreachableAddresses.contains(transportAddress)) {
import org.junit.After;
                    return new PeersResponse(in);
import org.opensearch.cluster.node.DiscoveryNodes.Builder;
 * specific language governing permissions and limitations
        final DiscoveryNode rebootedOtherNode = new DiscoveryNode("rebooted-node", otherNode.getAddress(), Version.CURRENT);
        peerFinder.activate(lastAcceptedNodes);
        Set<DiscoveryNode> intersection = new HashSet<>(actualNodesSet);
            runAllRunnableTasks();
        providedAddresses.add(otherNode.getAddress());
        final long term = randomNonNegativeLong();
        assertNotifiedOfAllUpdates();
                    assertFalse(response.getClusterManagerNode().isPresent());
                public void run() {
            return new PeersResponse(Optional.empty(), singletonList(nodeToFind), randomNonNegativeLong());
        );
    public void testReceivesRequestsFromTransportService() {
    }
        deterministicTaskQueue.advanceTime();
        addressResolveDelay = 10000;
        providedAddresses.add(otherNode.getAddress());
        providedAddresses.add(alternativeAddress);
    }
        }
    private CapturingTransport capturingTransport;
    private DeterministicTaskQueue deterministicTaskQueue;
        while (deterministicTaskQueue.getCurrentTimeMillis() < expectedTime) {
        runAllRunnableTasks();
 * KIND, either express or implied.  See the License for the
            assert isConnected != isDisconnected : discoveryNode + ": isConnected=" + isConnected + ", isDisconnected=" + isDisconnected;
        TestPeerFinder(Settings settings, TransportService transportService, TransportAddressConnector transportAddressConnector) {
    private Set<DiscoveryNode> disconnectedNodes = new HashSet<>();
    private DiscoveryNodes lastAcceptedNodes;
            emptySet(),
        peerFinder.activate(lastAcceptedNodes);
            assertThat(capturedRequest.action, is(REQUEST_PEERS_ACTION_NAME));
        transportAddressConnector.addReachableNode(otherKnownNode);
        transportAddressConnector.unreachableAddresses.add(otherNode.getAddress());
        peerFinder.activate(lastAcceptedNodes);
        final List<DiscoveryNode> actualNodesList = StreamSupport.stream(peerFinder.getFoundPeers().spliterator(), false)
import org.opensearch.test.transport.StubbableConnectionManager;
            deterministicTaskQueue.advanceTime();
        providedAddresses.add(otherNode.getAddress());
        testTransportService.close();
        providedAddresses.add(otherNode.getAddress());
        disconnectedNodes.add(otherNode);
            emptyMap(),
        runAllRunnableTasks();
        DiscoveryNodes newNodes = DiscoveryNodes.builder(lastAcceptedNodes).add(otherNode).build();
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        assertFalse(peerFinder.discoveredClusterManagerTerm.isPresent());
        StubbableConnectionManager connectionManager = new StubbableConnectionManager(innerConnectionManager);
            }
        final Set<TransportAddress> slowAddresses = new HashSet<>();
        assertFoundPeers(otherNode);
                    return "connection attempt to " + transportAddress;
package org.opensearch.discovery;
/*
 * You may obtain a copy of the License at
import static java.util.Collections.emptyMap;
        }
    }
        assertFoundPeers();
            new TransportResponseHandler<PeersResponse>() {
            return new PeersResponse(Optional.empty(), singletonList(otherNode), randomNonNegativeLong());
        if (localNodeCommissioned == false) {
    private TransportService transportService;
    }
import java.util.Arrays;
            deterministicTaskQueue.advanceTime();
        transportAddressConnector.addReachableNode(otherNode);
        assertNotNull(secondConnectionListener.get());
        transportAddressConnector.addReachableNode(sourceNode);
        runAllRunnableTasks();
        });
        assertFoundPeers(nodeToFind, otherNode);
 * not use this file except in compliance with the License.
    }
        respondToRequests(node -> { throw new AssertionError("there should have been no further requests"); });
        secondConnectionListener.get().onResponse(otherNode);
            null,
                    return "PeerFinderTests#resolveConfiguredHosts";
        providedAddresses.clear();
            return new PeersResponse(Optional.empty(), singletonList(sourceNode), randomNonNegativeLong());
        runAllRunnableTasks();
import static org.hamcrest.Matchers.empty;
        while (deterministicTaskQueue.getCurrentTimeMillis() < expectedTime) {
        peerFinder.activate(lastAcceptedNodes);
        assertFoundPeers(otherNode, discoveredNode);
        runAllRunnableTasks();
import org.opensearch.common.settings.Settings;
            super(settings, transportService, transportAddressConnector, PeerFinderTests.this::resolveConfiguredHosts);
        CapturingTransport testTransport = new CapturingTransport();
        onBuilder.accept(builder);
    public void testChecksUnicastHostsForChanges() {
        transportAddressConnector.addReachableNode(otherNode);
    private void assertNotifiedOfAllUpdates() {
            Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), "node").build(),
        runAllRunnableTasks();
                @Override
        transportService.start();
        peerFinder.deactivate(localNode);
                public void handleResponse(PeersResponse response) {
                }
        @Override
                        firstConnectionListener.set(listener);
                                listener.onResponse(discoveryNode);
        assertFoundPeers(otherKnownNode);
            logger.trace("onFoundPeersUpdated({})", foundPeersFromNotification);
        deterministicTaskQueue.runAllRunnableTasks();
            "node-from-hosts-list",
    }
 */
    }
        final PeersResponse peersResponse = peerFinder.handlePeersRequest(new PeersRequest(sourceNode, Collections.emptyList()));
        // need to wait for the connection to timeout, then for another wakeup, before discovering the peer
    public void testHandlesDiscoveryOfClusterManagerFromResponseFromClusterManager() {
        providedAddresses.add(otherNode.getAddress());
        peerFinder.onNodeCommissionStatusChange(localNodeCommissioned);
            assertThat(addressResolveDelay, is(-1L));
        runAllRunnableTasks();
        runAllRunnableTasks();
                @Override
        transportAddressConnector.addReachableNode(sourceNode);
        runAllRunnableTasks();
        });
        final Map<TransportAddress, DiscoveryNode> reachableNodes = new HashMap<>();
            Version.CURRENT
        testTransportService.start();
                public String toString() {
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
            assertThat(node, is(sourceNode));
        final DiscoveryNode otherNode = newDiscoveryNode("original-node");
        assertThat(peersResponse, equalTo(expectedResponse));
        transportAddressConnector.addReachableNode(sourceNode);
import static org.hamcrest.Matchers.is;
        deterministicTaskQueue.advanceTime();
        transportAddressConnector.addReachableNode(nodeToFind);
import java.util.Map;
import static org.hamcrest.Matchers.emptyArray;
        transportAddressConnector.addReachableNode(otherNode);
            final PeersRequest peersRequest = (PeersRequest) capturedRequest.request;
    }
        assertNotifiedOfAllUpdates();
                    }
        assertTrue(responseReceived.get());
    }
            return new PeersResponse(Optional.of(otherNode), emptyList(), term);
        peerFinder.handlePeersRequest(new PeersRequest(sourceNode, Collections.singletonList(otherKnownNode)));
        respondToRequests(node -> {
            buildNewFakeTransportAddress(),
            assertFalse(discoveredClusterManagerTerm.isPresent());
import java.util.function.Function;
        runAllRunnableTasks();
    private void updateLastAcceptedNodes(Consumer<DiscoveryNodes.Builder> onBuilder) {
    }
        runAllRunnableTasks();
        final DiscoveryNode sourceNode = newDiscoveryNode("request-source");
        assertThat(notifiedNodes.collect(Collectors.toSet()), equalTo(actualNodes.collect(Collectors.toSet())));
        runAllRunnableTasks();
            assertThat(peersRequest.getSourceNode(), is(localNode));
            return new PeersResponse(Optional.empty(), singletonList(discoveredNode), randomNonNegativeLong());
 *
                public String executor() {
    private TestPeerFinder peerFinder;
                    assertTrue(responseReceived.compareAndSet(false, true));
        transportAddressConnector.reachableNodes.clear();
        deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
        }
        deterministicTaskQueue.advanceTime();
        providedAddresses.add(otherNode.getAddress());
        peerFinder.activate(lastAcceptedNodes);
 * ownership. Elasticsearch licenses this file to you under
        peerFinder.setCurrentTerm(term);
                    assertThat(response.getKnownPeers(), empty()); // sourceNode is not yet known
        while (deterministicTaskQueue.getCurrentTimeMillis() < successTime) {
                                disconnectedNodes.remove(discoveryNode);
        isolatedFinder.activate(newNodes);
        final HashSet<DiscoveryNode> actualNodesSet = new HashSet<>(actualNodesList);
        final PeersResponse expectedResponse = new PeersResponse(Optional.of(clusterManagerNode), Collections.emptyList(), term);
        transportAddressConnector.addReachableNode(otherNode);
    public void testDoesNotAddUnreachableNodesFromUnicastHostsList() {
        runAllRunnableTasks();
        // Start the first connection attempt
    }
                                connectedNodes.add(discoveryNode);
        final long expectedTime = CONNECTION_TIMEOUT_MILLIS + findPeersInterval;
        final AtomicBoolean responseReceived = new AtomicBoolean();
    }
 * under the License.
        assertThat(peersResponse2.getTerm(), is(updatedTerm));
        final AtomicReference<ActionListener<DiscoveryNode>> firstConnectionListener = new AtomicReference<>();
        providedAddresses.add(otherNode.getAddress());
 * Licensed to Elasticsearch under one or more contributor
        disconnectedNodes.add(otherNode);
                }
        transportAddressConnector.addReachableNode(discoveredClusterManager);
    private void resolveConfiguredHosts(Consumer<List<TransportAddress>> onResult) {
        long findPeersInterval = peerFinder.getFindPeersInterval().millis();
        updateLastAcceptedNodes(b -> b.add(otherNode));
                }
            assert localNode.getAddress().equals(transportAddress) == false : "should not probe local node";
        // Assert that the second connection survived the stale failure exception
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
        }
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
        // Reactivate to trigger a second connection attempt to the same address, creating a new Peer state.
        assertFalse(peersResponse2.getClusterManagerNode().isPresent());
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        runAllRunnableTasks();
/*
        DiscoveryNode discoveredClusterManagerNode;
                @Override
                }
            assertThat(node, is(otherNode));
        assertFoundPeers();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        runAllRunnableTasks();
        connectedNodes.remove(otherNode);
            deterministicTaskQueue.scheduleAt(connectResultTime, new Runnable() {
                ? CONNECTION_TIMEOUT_MILLIS
            testTransportService,
    public void testDoesNotMakeMultipleConcurrentConnectionAttemptsToOneAddress() {
        assertFoundPeers(otherNode);
        runAllRunnableTasks();
        void addReachableNode(DiscoveryNode node) {
 *
            deterministicTaskQueue.advanceTime();
        transportAddressConnector.reachableNodes.clear();
        peerFinder.activate(lastAcceptedNodes);
        assertFoundPeers();
import org.opensearch.core.common.transport.TransportAddress;
        while (deterministicTaskQueue.getCurrentTimeMillis() < CONNECTION_TIMEOUT_MILLIS) {
        TransportService testTransportService = new TransportService(
            emptyMap(),
    public void testDeactivationClearsPastKnowledge() {
        peerFinder.activate(lastAcceptedNodes);
        }
            runAllRunnableTasks();
        runAllRunnableTasks();
        // Advance deterministic task queue to flush any remaining onFoundPeersUpdated() calls
            NoopTracer.INSTANCE
        } else {
    }
        foundPeersFromNotification = emptyList();
    private List<TransportAddress> providedAddresses;
                            }
 * compatible open source license.
    public void testAddsReachableNodesFromIncomingRequests() {
        assertThat(peersResponse1.getKnownPeers(), empty()); // sourceNode is not yet known
        final DiscoveryNode otherKnownNode = newDiscoveryNode("other-known-node");
            assertThat(discoveredClusterManagerNode, nullValue());
            runAllRunnableTasks();
        peerFinder.activate(DiscoveryNodes.EMPTY_NODES);
import java.util.ArrayList;
    @Before
            assertThat(node, is(sourceNode));
        peerFinder.activate(lastAcceptedNodes);
    }
        deterministicTaskQueue.scheduleNow(new Runnable() {
        peerFinder.activate(lastAcceptedNodes);
            capturingTransport.handleResponse(capturedRequests[0].requestId, responseFactory.apply(capturedRequest.node));
        providedAddresses.add(otherNode.getAddress());
    }
        peerFinder.activate(lastAcceptedNodes);
    }
        providedAddresses.add(otherNode.getAddress());
import org.opensearch.test.transport.CapturingTransport;
        assertFoundPeers(otherNode);
                : 0);
    class MockTransportAddressConnector implements TransportAddressConnector {
        final DiscoveryNode sourceNode = newDiscoveryNode("request-source");
        assertEquals(intersection.size(), 0);
                @Override
    public void testDoesNotAddNonClusterManagerEligibleNodesFromUnicastHostsList() {
        assertFoundPeers(sourceNode);
        final DiscoveryNode otherNode = newDiscoveryNode("original-node");
    }
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), Version.CURRENT);
        });
            NoopTracer.INSTANCE
            new StubbableConnectionManager(new ClusterConnectionManager(Settings.EMPTY, testTransport)),
 * GitHub history for details.
        final long timeoutAtMillis = deterministicTaskQueue.getCurrentTimeMillis() + PeerFinder.DISCOVERY_REQUEST_PEERS_TIMEOUT_SETTING.get(
import static java.util.Collections.emptyList;
        while (deterministicTaskQueue.getCurrentTimeMillis() < successTime) {
                    throw new AssertionError(transportAddress + " unknown");
    }
    private MockTransportAddressConnector transportAddressConnector;
        runAllRunnableTasks();
    private long addressResolveDelay; // -1 means address resolution fails
/*
                    }
                        }
        while (deterministicTaskQueue.getCurrentTimeMillis() < expectedTime) {
        assertFoundPeers(otherNode);
        transportAddressConnector.unreachableAddresses.add(otherKnownNode.getAddress());
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        assertThat(peersResponse1.getTerm(), is(0L));
        transportAddressConnector.addReachableNode(otherNode);
        transportAddressConnector.addReachableNode(otherNode);
    private void assertPeersNotDiscovered(DiscoveryNode... undiscoveredNodesArray) {
import org.opensearch.test.OpenSearchTestCase;
                return "assertNotifiedOfAllUpdates";
                                assertTrue(inFlightConnectionAttempts.remove(transportAddress));
        assertFoundPeers(sourceNode);
    private Set<DiscoveryNode> connectedNodes = new HashSet<>();
    public void testDoesNotReconnectToNodesOnceConnected() {
        transportAddressConnector.addReachableNode(rebootedOtherNode);
            discoveredClusterManagerTerm = OptionalLong.of(term);
        assertFoundPeers(otherNode);
        transportAddressConnector.addReachableNode(otherNode);
    public void testDoesNotAddUnreachableNodesFromIncomingRequests() {
        peerFinder.handlePeersRequest(new PeersRequest(sourceNode, Collections.singletonList(otherKnownNode)));
        });
        peerFinder.activate(lastAcceptedNodes);
        final Set<TransportAddress> unreachableAddresses = new HashSet<>();
        peerFinder.activate(lastAcceptedNodes);
                        if (addressAndNode.getKey().equals(transportAddress)) {
import static org.hamcrest.Matchers.contains;
        final DiscoveryNode sourceNode = newDiscoveryNode("request-source");
            assertFoundPeers(otherNode);
            new PeersRequest(sourceNode, Collections.emptyList()),
        assertFoundPeers();
                        listener.onFailure(new IOException("cannot connect to " + transportAddress));
        );
        final DiscoveryNode clusterManagerNode = newDiscoveryNode("cluster-manager-node");
        transportAddressConnector.addReachableNode(sourceNode);
import java.util.HashMap;
        peerFinder.activate(lastAcceptedNodes);
        connectionManager.setDefaultNodeConnectedBehavior((cm, discoveryNode) -> {
    public void testConnectionAttemptDuringDecommissioning() {
        transportAddressConnector.unreachableAddresses.add(otherNode.getAddress());
        assertFoundPeers(otherNode);
        final DiscoveryNode sourceNode = newDiscoveryNode("request-source");
        runAllRunnableTasks();
        transportAddressConnector.reachableNodes.clear();
                @Override
        transportAddressConnector.addReachableNode(nonClusterManagerNode);
 * The OpenSearch Contributors require contributions made to
        transportService.sendRequest(
                }
        final Set<TransportAddress> inFlightConnectionAttempts = new HashSet<>();
        final HashSet<DiscoveryNode> actualNodesSet = new HashSet<>(actualNodesList);
        transportAddressConnector.unreachableAddresses.add(sourceNode.getAddress());
            deterministicTaskQueue.advanceTime();
            }
                                return;
    public void testConnectionFailureDoesNotRemoveNewerConnection() {
            final boolean isNotInFlight = inFlightConnectionAttempts.add(transportAddress);
            buildNewFakeTransportAddress(),
            deterministicTaskQueue.getThreadPool(),
        intersection.retainAll(undiscoveredNodes);
    private static long CONNECTION_TIMEOUT_MILLIS = 30000;
        respondToRequests(node -> {
    }
        providedAddresses.add(otherNode.getAddress());
        runAllRunnableTasks();
        updateLastAcceptedNodes(b -> b.add(otherNode));
    public void testDiscardsDisconnectedNodes() {
    }
import java.util.HashSet;
    }
 * this work for additional information regarding copyright
        // Use isolated TransportService to avoid handler registration conflicts
        providedAddresses.add(otherNode.getAddress());
            runAllRunnableTasks();
        assertFoundPeers(otherNode);
        peerFinder.handlePeersRequest(new PeersRequest(sourceNode, Collections.singletonList(otherKnownNode)));
        peerFinder.activate(lastAcceptedNodes);
        runAllRunnableTasks();
    }
        peerFinder.activate(lastAcceptedNodes);
        transportAddressConnector.unreachableAddresses.clear();
import java.util.Collections;
 * the Apache License, Version 2.0 (the "License"); you may
        }
        assertFoundPeers(rebootedOtherNode);
        );
                    } else {
    }
        peerFinder.activate(lastAcceptedNodes);
        runAllRunnableTasks();
                    onResult.accept(providedAddresses);
        transportAddressConnector.addReachableNode(otherNode);
        assertFoundPeers(sourceNode);
            runAllRunnableTasks();
            new TransportAddressConnector() {
        assertFoundPeers(otherNode);
    public void testDoesNotAddUnreachableNodesFromClusterState() {
    public void testAddsReachableNodesFromUnicastHostsList() {
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
        final PeersRequest peersRequest = (PeersRequest) capturedRequests[0].request;
        }
        assertFoundPeers(otherNode);
        runAllRunnableTasks();
        testTransportService.stop();
        peerFinder.activate(lastAcceptedNodes);
        runAllRunnableTasks();
        disconnectedNodes.add(otherNode);
        PeerFinder isolatedFinder = new TestPeerFinder(
            });
        final DiscoveryNode discoveredNode = newDiscoveryNode("discovered-node");
        transportService.acceptIncomingRequests();
        // Deactivate PeerFinder. This clears peersByAddress, but the connection listener remains in-flight.
            final long connectResultTime = deterministicTaskQueue.getCurrentTimeMillis() + (slowAddresses.contains(transportAddress)
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
            Settings.EMPTY,
            deterministicTaskQueue.getThreadPool(),
            assertThat(node, is(otherNode));
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
import static org.hamcrest.Matchers.nullValue;
        final DiscoveryNode otherNode = newDiscoveryNode("node-in-cluster-state");
import static java.util.Collections.singletonList;
 * SPDX-License-Identifier: Apache-2.0
        final long expectedTime = timeoutAtMillis + PeerFinder.DISCOVERY_FIND_PEERS_INTERVAL_SETTING.get(Settings.EMPTY).millis();
        firstConnectionListener.get().onFailure(new IOException("simulated timeout / failure of first connection attempt"));
        final DiscoveryNode sourceNode = new DiscoveryNode(
import org.opensearch.transport.ClusterConnectionManager;
        final long successTime = 10000 + PeerFinder.DISCOVERY_FIND_PEERS_INTERVAL_SETTING.get(Settings.EMPTY).millis();
        while (true) {
    }
        assertThat(peerFinder.discoveredClusterManagerNode, is(otherNode));
    }
        assertThat(capturedRequests.length, is(1));
        deterministicTaskQueue.advanceTime();
        assertFoundPeers(otherNode);
    public void testDoesNotReturnDuplicateNodesWithDistinctAddresses() {
        final DiscoveryNode sourceNode = newDiscoveryNode("request-source");
            if (capturingTransport.getCapturedRequestsAndClear().length > 0) {
        transportAddressConnector.unreachableAddresses.add(otherNode.getAddress());
        );
    public void testAddsReachableNodesFromClusterState() {
    }
        public void connectToRemoteMasterNode(TransportAddress transportAddress, ActionListener<DiscoveryNode> listener) {
import java.util.function.Consumer;
import java.util.concurrent.atomic.AtomicBoolean;
        lastAcceptedNodes = DiscoveryNodes.builder().localNodeId(localNode.getId()).add(localNode).build();
            runAllRunnableTasks(); // MockTransportAddressConnector verifies no multiple connection attempts
            boundTransportAddress -> localNode,
        final TransportAddress alternativeAddress = buildNewFakeTransportAddress();
            assertThat(node, is(otherNode));
                @Override
            "request-source",
        peerFinder.activate(lastAcceptedNodes);
    }
import org.opensearch.transport.ConnectionManager;
        assertTrue("no duplicates in " + actualNodesList, actualNodesSet.size() == actualNodesList.size());
import java.util.List;
        providedAddresses = new ArrayList<>();
                    assertThat(response.getTerm(), is(0L));
        respondToRequests(node -> {
        }
        assertFoundPeers();
        while (deterministicTaskQueue.getCurrentTimeMillis() < timeoutAtMillis) {
    }
        for (final CapturedRequest capturedRequest : capturedRequests) {
        transportAddressConnector.addReachableNode(discoveredNode);
        final CapturedRequest[] capturedRequests = capturingTransport.getCapturedRequestsAndClear();
        // Assert the initial async connection is pending
        transportAddressConnector.addReachableNode(otherNode);
            assertThat(node, is(otherNode));
        transportAddressConnector.addReachableNode(otherNode);
            foundPeersFromNotification = getFoundPeers();
 * this file be licensed under the Apache-2.0 license or a
            .collect(Collectors.toList());
        isolatedFinder.activate(newNodes);
        }
            return new PeersResponse(Optional.of(discoveredClusterManager), emptyList(), randomNonNegativeLong());
        );
        providedAddresses.add(otherNode.getAddress());
        });
        @Override
                    for (final Map.Entry<TransportAddress, DiscoveryNode> addressAndNode : reachableNodes.entrySet()) {
        transportAddressConnector.addReachableNode(otherNode);
import java.util.concurrent.atomic.AtomicReference;
            boundTransportAddress -> localNode,
        runAllRunnableTasks();
        protected void onActiveClusterManagerFound(DiscoveryNode clusterManagerNode, long term) {
    }
        peerFinder.activate(lastAcceptedNodes);
        final PeersResponse peersResponse2 = peerFinder.handlePeersRequest(new PeersRequest(sourceNode, Collections.emptyList()));
        final long successTime = addressResolveDelay + PeerFinder.DISCOVERY_FIND_PEERS_INTERVAL_SETTING.get(Settings.EMPTY).millis();
                @Override
                        assertTrue(inFlightConnectionAttempts.remove(transportAddress));
        runAllRunnableTasks(); // MockTransportAddressConnector verifies no multiple connection attempts
import org.opensearch.cluster.coordination.DeterministicTaskQueue;
    }
        assertFoundPeers();
        final DiscoveryNode otherNode = newDiscoveryNode("otherNode");
                        return;
        providedAddresses.add(otherNode.getAddress());
                    return Names.SAME;
        transportAddressConnector.addReachableNode(otherNode);
import java.util.stream.Stream;
            assertThat(capturedRequest.request, instanceOf(PeersRequest.class));
    public void testDoesNotAddReachableNonClusterManagerEligibleNodesFromIncomingRequests() {
import java.util.stream.StreamSupport;
    public void testAddsReachableNodesFromUnicastHostsListProvidedLater() {
            final boolean isDisconnected = disconnectedNodes.contains(discoveryNode);
        final DiscoveryNode otherKnownNode = newDiscoveryNode("other-known-node");
        runAllRunnableTasks();
        peerFinder.handlePeersRequest(new PeersRequest(sourceNode, emptyList()));
            assertFoundPeers();
                }
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
                }
    private void assertFoundPeers(DiscoveryNode... expectedNodesArray) {
        peerFinder.activate(lastAcceptedNodes);
import org.opensearch.Version;
                public PeersResponse read(StreamInput in) throws IOException {
        ).millis();
        runAllRunnableTasks();
            Version.CURRENT
                public void run() {
        assertFoundPeers();
        providedAddresses.add(otherNode.getAddress());
        runAllRunnableTasks();
            public void run() {
        peerFinder.activate(lastAcceptedNodes);
        transportAddressConnector.addReachableNode(newNode);
import java.util.Set;
import org.opensearch.cluster.node.DiscoveryNodes;
        // Succeed the second connection callback
import org.opensearch.cluster.node.DiscoveryNode;
        assertFoundPeers(otherNode);
        peerFinder = new TestPeerFinder(settings, transportService, transportAddressConnector);
import org.opensearch.node.Node;
import org.opensearch.core.action.ActionListener;
 */
        transportAddressConnector.addReachableNode(otherNode);
 * software distributed under the License is distributed on an
        final DiscoveryNode sourceNode = newDiscoveryNode("request-source");
        peerFinder.handlePeersRequest(new PeersRequest(sourceNode, Collections.singletonList(otherKnownNode)));
    class TestPeerFinder extends PeerFinder {
