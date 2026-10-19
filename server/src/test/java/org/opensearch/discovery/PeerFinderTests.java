        peerFinder.activate(lastAcceptedNodes);  
import org.opensearch.transport.TransportException;
            runAllRunnableTasks();
        runAllRunnableTasks();  
import static org.opensearch.discovery.PeerFinder.REQUEST_PEERS_ACTION_NAME;  
    }  
            boundTransportAddress -> localNode,  
            Version.CURRENT  
        while (deterministicTaskQueue.getCurrentTimeMillis() < successTime) {
                }  
        peerFinder.activate(lastAcceptedNodes);  
        providedAddresses.add(otherNode.getAddress());  
        final HashSet<DiscoveryNode> actualNodesSet = new HashSet<>(actualNodesList);
            deterministicTaskQueue.scheduleAt(connectResultTime, new Runnable() {
        assertThat(actualNodesSet, equalTo(expectedNodes));
 *  
            new StubbableConnectionManager(new ClusterConnectionManager(Settings.EMPTY, testTransport)),  
    private MockTransportAddressConnector transportAddressConnector;  
    }
        ConnectionManager innerConnectionManager = new ClusterConnectionManager(settings, capturingTransport);
                            final DiscoveryNode discoveryNode = addressAndNode.getValue();  
            deterministicTaskQueue.advanceTime();
        assertThat(peersResponse2.getKnownPeers(), contains(sourceNode));  
            final boolean isConnected = connectedNodes.contains(discoveryNode);
            return new PeersResponse(Optional.empty(), singletonList(sourceNode), randomNonNegativeLong());
 * this file be licensed under the Apache-2.0 license or a
        peerFinder.activate(lastAcceptedNodes);
        providedAddresses.add(otherNode.getAddress());
                    return "PeerFinderTests#resolveConfiguredHosts";  
        runAllRunnableTasks(); // MockTransportAddressConnector verifies no multiple connection attempts  
        firstConnectionListener.get().onFailure(new IOException("simulated timeout / failure of first connection attempt"));
        assertFoundPeers(otherNode);  
        // Assert that the second connection survived the stale failure exception
        respondToRequests(node -> {
            "node-from-hosts-list",
        peerFinder.activate(lastAcceptedNodes);
    }
    public void testAddsReachableClusterManagerFromResponse() {
        assertNotNull(secondConnectionListener.get());
        updateLastAcceptedNodes(b -> b.add(otherNode));
        peerFinder.activate(lastAcceptedNodes);  
            .collect(Collectors.toList());
        // Succeed the second connection callback
                        firstConnectionListener.set(listener);
            final long connectResultTime = deterministicTaskQueue.getCurrentTimeMillis() + (slowAddresses.contains(transportAddress)  
            assert holdsLock() == false : "PeerFinder lock held in error";
        assertFoundPeers(sourceNode, otherKnownNode);  
        transportAddressConnector.addReachableNode(otherNode);
        deterministicTaskQueue.advanceTime();
        );  
        // A stale failure callback must not remove the more recent Peer state from peersByAddress.
        transportAddressConnector.addReachableNode(otherKnownNode);  
        peerFinder.activate(lastAcceptedNodes);
            assertFoundPeers();
 */  
            buildNewFakeTransportAddress(),  
            localNode,  
        );
        providedAddresses.add(otherNode.getAddress());
        final DiscoveryNode discoveredNode = newDiscoveryNode("discovered-node");  
        providedAddresses.add(otherNode.getAddress());  
    public void testDoesNotMakeMultipleConcurrentConnectionAttemptsToOneAddress() {
        // peer discovery will be delayed now  
 * Licensed to Elasticsearch under one or more contributor  
    }
            Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), "node").build(),
        runAllRunnableTasks();  
                @Override
import java.util.Arrays;  
        runAllRunnableTasks();
 * You may obtain a copy of the License at  
        runAllRunnableTasks();
        connectedNodes.remove(otherNode);  
    }  
        Set<DiscoveryNode> intersection = new HashSet<>(actualNodesSet);  
        assertThat(foundPeers, contains(otherNode));  
import org.opensearch.common.settings.Settings;
        }
        final DiscoveryNode sourceNode = newDiscoveryNode("request-source");
    }  
            assert isConnected != isDisconnected : discoveryNode + ": isConnected=" + isConnected + ", isDisconnected=" + isDisconnected;
        localNode = newDiscoveryNode("local-node");  
    private TestPeerFinder peerFinder;
                }
        peerFinder.activate(lastAcceptedNodes);
                                disconnectedNodes.remove(discoveryNode);
 */  
                        return;
import org.opensearch.test.transport.CapturingTransport;
        transportAddressConnector.unreachableAddresses.add(otherNode.getAddress());  
    public void testOnlyRequestsPeersOncePerRoundButDoesRetryNextRound() {
        final DiscoveryNode otherNode = newDiscoveryNode("node-1");  
        runAllRunnableTasks();
            final boolean isDisconnected = disconnectedNodes.contains(discoveryNode);  
            REQUEST_PEERS_ACTION_NAME,
        peerFinder.handlePeersRequest(new PeersRequest(sourceNode, Collections.singletonList(otherKnownNode)));
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), Version.CURRENT);  
        transportAddressConnector.addReachableNode(otherNode);
                        listener.onFailure(new IOException("cannot connect to " + transportAddress));  
        }
        peerFinder.activate(lastAcceptedNodes);
                            if (discoveryNode.isClusterManagerNode()) {
        transportAddressConnector.addReachableNode(sourceNode);
        peerFinder.activate(lastAcceptedNodes);
            assertTrue(isNotInFlight);
                            }
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");  
    }  
            new PeersRequest(sourceNode, Collections.emptyList()),
        transportAddressConnector.addReachableNode(otherNode);
        final DiscoveryNode otherNode = newDiscoveryNode("otherNode");
        providedAddresses.add(nonClusterManagerNode.getAddress());
            Version.CURRENT
        capturingTransport = new CapturingTransport();
import java.util.OptionalLong;
        final PeersResponse peersResponse2 = peerFinder.handlePeersRequest(new PeersRequest(sourceNode, Collections.emptyList()));
                            } else {
            runAllRunnableTasks();  
            assertThat(node, is(otherNode));
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
        assertFoundPeers();  
    public void testChecksUnicastHostsForChanges() {
        while (deterministicTaskQueue.getCurrentTimeMillis() < successTime) {  
import org.junit.Before;
            connectionManager,
        transportAddressConnector.addReachableNode(rebootedOtherNode);
                    assertTrue(responseReceived.compareAndSet(false, true));
        });
import static org.hamcrest.Matchers.is;
        disconnectedNodes.add(otherNode);
        peerFinder.activate(lastAcceptedNodes);
        assertFoundPeers(sourceNode);  
        providedAddresses.add(alternativeAddress);  
        assertFoundPeers(otherNode);
 * KIND, either express or implied.  See the License for the
        runAllRunnableTasks();
                public String executor() {
        while (true) {
import org.opensearch.discovery.PeerFinder.TransportAddressConnector;  
        deterministicTaskQueue.advanceTime();
        transportAddressConnector.addReachableNode(otherNode);
            buildNewFakeTransportAddress(),
            deterministicTaskQueue.advanceTime();
        transportAddressConnector.addReachableNode(sourceNode);
import org.opensearch.cluster.node.DiscoveryNodes;  
        final long term = randomNonNegativeLong();
            runAllRunnableTasks(); // MockTransportAddressConnector verifies no multiple connection attempts  
import java.util.Map;
        peerFinder.activate(lastAcceptedNodes);
            boundTransportAddress -> localNode,
        assertFoundPeers(sourceNode);  
                public void run() {  
                    }
        final long updatedTerm = randomNonNegativeLong();
        assertFoundPeers();  
        peerFinder.deactivate(clusterManagerNode);
        // Reactivate to trigger a second connection attempt to the same address, creating a new Peer state.
        runAllRunnableTasks();  
        peerFinder.activate(lastAcceptedNodes);
            deterministicTaskQueue.advanceTime();
    public void testDoesNotRequireAddressResolutionToSucceed() {
        assertFalse(peerFinder.discoveredClusterManagerTerm.isPresent());
                    }
        final HashSet<DiscoveryNode> actualNodesSet = new HashSet<>(actualNodesList);
        final long successTime = addressResolveDelay + PeerFinder.DISCOVERY_FIND_PEERS_INTERVAL_SETTING.get(Settings.EMPTY).millis();
                                return;  
    }
        );
    private DiscoveryNode newDiscoveryNode(String nodeId) {
            assertFoundPeers(otherNode);
            assertFalse(discoveredClusterManagerTerm.isPresent());
        runAllRunnableTasks();
 * license agreements. See the NOTICE file distributed with
        runAllRunnableTasks();  
        transportAddressConnector.unreachableAddresses.add(otherNode.getAddress());  
    class MockTransportAddressConnector implements TransportAddressConnector {
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
                public void run() {  
    public void testReconnectsToDisconnectedNodes() {
    public void testDoesNotReconnectToNodesOnceConnected() {  
        providedAddresses.add(otherNode.getAddress());
        peerFinder.handlePeersRequest(new PeersRequest(sourceNode, Collections.singletonList(otherKnownNode)));
        assertThat(peerFinder.discoveredClusterManagerNode, is(otherNode));
        assertTrue("no duplicates in " + actualNodesList, actualNodesSet.size() == actualNodesList.size());  
                }
                @Override
import org.opensearch.cluster.coordination.PeersResponse;
        deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
    public void testReceivesRequestsFromTransportService() {
        transportAddressConnector.addReachableNode(otherNode);
        transportAddressConnector.unreachableAddresses.clear();
                public void handleResponse(PeersResponse response) {
        connectionManager.setDefaultGetConnectionBehavior((cm, discoveryNode) -> capturingTransport.createConnection(discoveryNode));
        }  
import org.opensearch.transport.TransportResponseHandler;
                                assertTrue(inFlightConnectionAttempts.remove(transportAddress));
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");  
        assertFoundPeers(otherNode);  
        runAllRunnableTasks();
                    throw new AssertionError(transportAddress + " unknown");
    public void testDeactivationClearsPastKnowledge() {
        assertFoundPeers(otherNode);  
                                return;  
            public void run() {  
    private Iterable<DiscoveryNode> foundPeersFromNotification;  
        });  
    }
    @After
        peerFinder.activate(lastAcceptedNodes);  
        // need to wait for the connection to timeout, then for another wakeup, before discovering the peer  
        while (deterministicTaskQueue.getCurrentTimeMillis() < expectedTime) {  
            emptySet(),  
        // Use isolated TransportService to avoid handler registration conflicts
import java.util.List;
                    return "connection attempt to " + transportAddress;
    private CapturingTransport capturingTransport;  
        OptionalLong discoveredClusterManagerTerm = OptionalLong.empty();  
        updateLastAcceptedNodes(b -> b.add(otherNode));  
    }
            runAllRunnableTasks();  
        transportAddressConnector.addReachableNode(otherNode);
        runAllRunnableTasks();
            return isConnected;
 * software distributed under the License is distributed on an
        secondConnectionListener.get().onResponse(otherNode);
                    throw new AssertionError("unexpected", exp);
    }  
    private void runAllRunnableTasks() {  
        final DiscoveryNode otherNode = newDiscoveryNode("node-in-cluster-state");
        transportAddressConnector.reachableNodes.clear();  
        deterministicTaskQueue.scheduleNow(new Runnable() {
    }
        respondToRequests(node -> {
        final DiscoveryNode sourceNode = newDiscoveryNode("request-source");
        DiscoveryNodes newNodes = DiscoveryNodes.builder(lastAcceptedNodes).add(otherNode).build();  
                @Override
        runAllRunnableTasks();
        transportAddressConnector.addReachableNode(otherNode);
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");  
        peerFinder.activate(lastAcceptedNodes);  
        transportAddressConnector.addReachableNode(otherNode);
        assertFoundPeers(otherNode);
        }
        assertFoundPeers(otherNode);  
        // Simulate an asynchronous failure of the first connection attempt.  
        TestPeerFinder(Settings settings, TransportService transportService, TransportAddressConnector transportAddressConnector) {
        assertFoundPeers();  
        while (deterministicTaskQueue.getCurrentTimeMillis() < CONNECTION_TIMEOUT_MILLIS) {
                    if (firstConnectionListener.get() == null) {  
        transportAddressConnector.addReachableNode(otherNode);  
        assertFoundPeers(otherNode);
    }
        @Override
        peerFinder.activate(DiscoveryNodes.EMPTY_NODES);  
        peerFinder.activate(lastAcceptedNodes);
 * Modifications Copyright OpenSearch Contributors. See
        // need to wait for the connection to timeout, then for another wakeup, before discovering the peer
        transportAddressConnector.addReachableNode(newNode);
        if (localNodeCommissioned == false) {
            deterministicTaskQueue.advanceTime();
import java.util.Optional;  
        Iterable<DiscoveryNode> foundPeers = isolatedFinder.getFoundPeers();
        onBuilder.accept(builder);
    public void setup() {  
        connectionManager.setDefaultNodeConnectedBehavior((cm, discoveryNode) -> {
        assertFoundPeers();
            public String toString() {
        testTransportService.start();  
import java.util.concurrent.atomic.AtomicBoolean;  
                                listener.onResponse(discoveryNode);
    public void testDoesNotAddUnreachableSourceNodeFromIncomingRequests() {  
        runAllRunnableTasks();
 * compatible open source license.
        final List<DiscoveryNode> actualNodesList = StreamSupport.stream(peerFinder.getFoundPeers().spliterator(), false)
        final DiscoveryNode sourceNode = newDiscoveryNode("request-source");  
            deterministicTaskQueue.advanceTime();  
        // Deactivate PeerFinder. This clears peersByAddress, but the connection listener remains in-flight.
        assertFoundPeers();
            deterministicTaskQueue.getThreadPool(),
        // Create an isolated PeerFinder to tightly control connection attempt interleaving
    }  
        addressResolveDelay = 10000;
        assertFoundPeers();
        final DiscoveryNode otherNode = newDiscoveryNode("node-in-cluster-state");
        assertThat(peersResponse1.getTerm(), is(0L));
        final Set<TransportAddress> unreachableAddresses = new HashSet<>();  
            deterministicTaskQueue.getThreadPool(),
                public String toString() {
import org.opensearch.test.transport.StubbableConnectionManager;  
            runAllRunnableTasks();
import static org.hamcrest.Matchers.emptyArray;
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
            emptyMap(),
import java.util.Collections;
                                connectedNodes.add(discoveryNode);  
    public void testAddsReachableNodesFromIncomingRequests() {
        assertFoundPeers();
        final long expectedTime = CONNECTION_TIMEOUT_MILLIS + findPeersInterval;
        assertThat(peerFinder.discoveredClusterManagerTerm, is(OptionalLong.of(term)));
        final DiscoveryNode nonClusterManagerNode = new DiscoveryNode(  
        peerFinder.handlePeersRequest(new PeersRequest(sourceNode, emptyList()));
                }
        transportAddressConnector.unreachableAddresses.add(sourceNode.getAddress());
    }
    }
                public PeersResponse read(StreamInput in) throws IOException {
        runAllRunnableTasks();  
            emptySet(),
    public void testDoesNotAddUnreachableNodesFromClusterState() {  
    private static long CONNECTION_TIMEOUT_MILLIS = 30000;
        assertFoundPeers(otherNode);
        });
        });
        runAllRunnableTasks();
                break;
        final long timeoutAtMillis = deterministicTaskQueue.getCurrentTimeMillis() + PeerFinder.DISCOVERY_REQUEST_PEERS_TIMEOUT_SETTING.get(  
 * Unless required by applicable law or agreed to in writing,
        assertFoundPeers(otherNode);  
        transportService.start();
    private void updateLastAcceptedNodes(Consumer<DiscoveryNodes.Builder> onBuilder) {
        PeerFinder isolatedFinder = new TestPeerFinder(  
    }
        peerFinder.activate(lastAcceptedNodes);  
        assertFoundPeers(nodeToFind, otherNode);
                    assertThat(response.getKnownPeers(), empty()); // sourceNode is not yet known
        runAllRunnableTasks();
        runAllRunnableTasks();
    }
import static java.util.Collections.emptyList;
        peerFinder.setCurrentTerm(term);  
import org.opensearch.node.Node;
            assertThat(node, is(sourceNode));
    }
import java.util.function.Consumer;
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");  
            }
        assertTrue(responseReceived.get());  
            runAllRunnableTasks();
    private Set<DiscoveryNode> connectedNodes = new HashSet<>();  
                @Override
        transportAddressConnector.addReachableNode(discoveredClusterManager);  
        assertNotifiedOfAllUpdates();
        foundPeersFromNotification = emptyList();
        assertThat(capturingTransport.capturedRequests(), emptyArray());
        assertFoundPeers(otherKnownNode);
            emptySet(),
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
    private void assertFoundPeers(DiscoveryNode... expectedNodesArray) {  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            assertThat(node, is(otherNode));
        final DiscoveryNode sourceNode = newDiscoveryNode("request-source");
                }
            assertThat(capturedRequest.request, instanceOf(PeersRequest.class));
        runAllRunnableTasks();  
        final Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), "node").build();  
            @Override
                        if (addressAndNode.getKey().equals(transportAddress)) {
        runAllRunnableTasks();
        transportAddressConnector.addReachableNode(otherNode);
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
            return new PeersResponse(Optional.empty(), singletonList(nodeToFind), randomNonNegativeLong());
                    return new PeersResponse(in);  
        assertFoundPeers();
import static org.hamcrest.Matchers.contains;
        assertFoundPeers(sourceNode);  
        final AtomicReference<ActionListener<DiscoveryNode>> firstConnectionListener = new AtomicReference<>();
            new TransportAddressConnector() {  
import org.opensearch.OpenSearchException;
        final Builder builder = DiscoveryNodes.builder(lastAcceptedNodes);  
        runAllRunnableTasks();
        transportAddressConnector.addReachableNode(otherKnownNode);
        transportAddressConnector.addReachableNode(nonClusterManagerNode);  
        }
            }  
        );
        runAllRunnableTasks();
        peerFinder.activate(lastAcceptedNodes);
        runAllRunnableTasks();  
        isolatedFinder.deactivate(localNode);
        providedAddresses.add(otherNode.getAddress());  
    private void respondToRequests(Function<DiscoveryNode, PeersResponse> responseFactory) {
            return new PeersResponse(Optional.empty(), singletonList(discoveredNode), randomNonNegativeLong());
    public void testDelegatesRequestHandlingWhenInactive() {
        runAllRunnableTasks();
        }
        assertFoundPeers();
            final PeersRequest peersRequest = (PeersRequest) capturedRequest.request;  
        transportAddressConnector.addReachableNode(otherNode);
        final TransportAddress alternativeAddress = buildNewFakeTransportAddress();  
        assertThat(peersResponse1.getKnownPeers(), empty()); // sourceNode is not yet known
 *
        peerFinder.handlePeersRequest(new PeersRequest(sourceNode, Collections.singletonList(otherKnownNode)));  
    }
        }
                    if (unreachableAddresses.contains(transportAddress)) {
            "request-source",
    public void testDoesNotAddNonClusterManagerEligibleNodesFromUnicastHostsList() {
        assertThat(capturedRequests.length, is(1));  
 */
                    assertFalse(response.getClusterManagerNode().isPresent());  
        protected void onFoundPeersUpdated() {
                        }
        peerFinder.activate(lastAcceptedNodes);
        final Map<TransportAddress, DiscoveryNode> reachableNodes = new HashMap<>();
    public void testDoesNotAddUnreachableNodesFromIncomingRequests() {
        providedAddresses.add(otherNode.getAddress());  
        assertFoundPeers(otherNode);  
            deterministicTaskQueue.advanceTime();
            }
/*
        final Set<TransportAddress> inFlightConnectionAttempts = new HashSet<>();
import org.opensearch.cluster.node.DiscoveryNodes.Builder;
        transportAddressConnector.unreachableAddresses.add(otherNode.getAddress());
        );  
        peerFinder = new TestPeerFinder(settings, transportService, transportAddressConnector);
        }
import static org.hamcrest.Matchers.empty;  
                @Override
        DiscoveryNode discoveredClusterManagerNode;
        transportAddressConnector.slowAddresses.add(otherNode.getAddress());
        public void connectToRemoteMasterNode(TransportAddress transportAddress, ActionListener<DiscoveryNode> listener) {  
        }
    }  
        assertFalse(peersResponse2.getClusterManagerNode().isPresent());
        respondToRequests(node -> {
        providedAddresses.add(otherNode.getAddress());
        disconnectedNodes.add(otherNode);
        providedAddresses.clear();
            emptyMap(),  
        peerFinder.setCurrentTerm(updatedTerm);  
            testTransport,  
import org.opensearch.transport.ConnectionManager;  
    private long addressResolveDelay; // -1 means address resolution fails  
        }
        assertFoundPeers(otherNode);
    public void testRequestsPeersIncludingKnownPeersInRequest() {
        StubbableConnectionManager connectionManager = new StubbableConnectionManager(innerConnectionManager);  
        @Override  
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");  
            capturingTransport,
        transportAddressConnector.addReachableNode(otherNode);
        assertThat(peersResponse, equalTo(expectedResponse));
            super(settings, transportService, transportAddressConnector, PeerFinderTests.this::resolveConfiguredHosts);  
            assertThat(node, is(otherNode));  
 * this work for additional information regarding copyright
import static org.hamcrest.Matchers.instanceOf;  
            @Override
        );  
    }  
import java.util.function.Function;  
        assertFoundPeers();
        testTransportService.stop();  
        final long expectedTime = timeoutAtMillis + PeerFinder.DISCOVERY_FIND_PEERS_INTERVAL_SETTING.get(Settings.EMPTY).millis();
            Settings.EMPTY,
import org.opensearch.core.action.ActionListener;  
                    return Names.SAME;  
        assertFoundPeers(otherNode, discoveredClusterManager);
                                listener.onFailure(new OpenSearchException("non-cluster-manager node " + discoveryNode));
    }
        transportAddressConnector.reachableNodes.clear();
        while (deterministicTaskQueue.getCurrentTimeMillis() < timeoutAtMillis) {  
        } else {  
            final boolean isNotInFlight = inFlightConnectionAttempts.add(transportAddress);  
                : 0);
        ).millis();
        assertFoundPeers(sourceNode, otherNode);  
            null,
 * under the License.  
        connectedNodes.remove(otherNode);  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
public class PeerFinderTests extends OpenSearchTestCase {
        });
        // Start the first connection attempt
        final Stream<DiscoveryNode> notifiedNodes = StreamSupport.stream(foundPeersFromNotification.spliterator(), false);
    public void testRespondsToRequestWhenActive() {
        assertFoundPeers(otherKnownNode);
    public void testDoesNotAddReachableNonClusterManagerEligibleNodesFromIncomingRequests() {  
            deterministicTaskQueue.advanceTime();
            capturingTransport.handleResponse(capturedRequests[0].requestId, responseFactory.apply(capturedRequest.node));
        runAllRunnableTasks();
        transportAddressConnector = new MockTransportAddressConnector();
        if (addressResolveDelay >= 0) {  
        transportAddressConnector.addReachableNode(otherNode);  
            null,
            }  
        transportAddressConnector.addReachableNode(otherNode);
                }  
    }
import org.opensearch.transport.TransportService;  
    public void testDoesNotReturnDuplicateNodesWithDistinctAddresses() {
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(peerFinder.discoveredClusterManagerNode, nullValue());  
        assertFoundPeers(otherNode);
        }  
        }  
        providedAddresses.add(otherNode.getAddress());
        final Set<TransportAddress> slowAddresses = new HashSet<>();
        final DiscoveryNode newNode = new DiscoveryNode("new-node", otherNode.getAddress(), Version.CURRENT);  
        }
        deterministicTaskQueue.runAllRunnableTasks();
        providedAddresses.add(otherNode.getAddress());
import java.util.HashMap;
    public void testTimesOutAndRetriesConnectionsToBlackholedNodes() {  
                }
import org.opensearch.test.OpenSearchTestCase;  
    }
        }
        respondToRequests(node -> {  
        }  
        deterministicTaskQueue.advanceTime();  
        peerFinder.activate(lastAcceptedNodes);
        runAllRunnableTasks();
    }  
            if (capturingTransport.getCapturedRequestsAndClear().length > 0) {
    }  
        runAllRunnableTasks();
        transportAddressConnector.addReachableNode(discoveredNode);
            reachableNodes.put(node.getAddress(), node);
import org.opensearch.transport.ClusterConnectionManager;
        assertFoundPeers(sourceNode);
        deterministicTaskQueue.advanceTime();
                @Override  
            return new PeersResponse(Optional.of(otherNode), emptyList(), term);
    public void testDiscardsDisconnectedNodes() {
        disconnectedNodes.add(otherNode);  
        lastAcceptedNodes = DiscoveryNodes.builder().localNodeId(localNode.getId()).add(localNode).build();
        peerFinder.activate(lastAcceptedNodes);
    private Set<DiscoveryNode> disconnectedNodes = new HashSet<>();
        final DiscoveryNode sourceNode = new DiscoveryNode(
import static org.hamcrest.Matchers.nullValue;
        isolatedFinder.deactivate(localNode);  
        final DiscoveryNode otherNode = newDiscoveryNode("original-node");
        respondToRequests(node -> {
    }
        final PeersRequest peersRequest = (PeersRequest) capturedRequests[0].request;
        runAllRunnableTasks();  
        @Override  
        assertFoundPeers();
        assertThat(peersRequest.getKnownPeers(), contains(otherNode));
    }  
        assertNotifiedOfAllUpdates();
            new TransportResponseHandler<PeersResponse>() {  
        // Assert the initial async connection is pending
            runAllRunnableTasks();
        assertFoundPeers(otherNode);  
                    for (final Map.Entry<TransportAddress, DiscoveryNode> addressAndNode : reachableNodes.entrySet()) {
        protected void onActiveClusterManagerFound(DiscoveryNode clusterManagerNode, long term) {
        testTransportService.close();
    public void testAddsReachableNodesFromUnicastHostsListProvidedLater() {
            assert holdsLock() == false : "PeerFinder lock held in error";
        transportAddressConnector.addReachableNode(otherKnownNode);
import org.opensearch.cluster.node.DiscoveryNode;
        transportAddressConnector.addReachableNode(otherNode);
        transportAddressConnector.addReachableNode(otherNode);
    }
            assertThat(discoveredClusterManagerNode, nullValue());  
    private void assertNotifiedOfAllUpdates() {
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
                public String toString() {  
            return new PeersResponse(Optional.of(discoveredClusterManager), emptyList(), randomNonNegativeLong());  
        assertFalse(peersResponse1.getClusterManagerNode().isPresent());  
        transportAddressConnector.reachableNodes.put(alternativeAddress, otherNode);
        transportAddressConnector.addReachableNode(nodeToFind);  
    public void testAddsReachablePeersFromResponse() {
    }  
    public void deactivateAndRunRemainingTasks() {  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
        transportService.sendRequest(
        final DiscoveryNode nodeToFind = newDiscoveryNode("node-to-find");
        // Advance deterministic task queue to flush any remaining onFoundPeersUpdated() calls
        transportAddressConnector.unreachableAddresses.add(otherNode.getAddress());
import org.opensearch.core.common.io.stream.StreamInput;
    public void testDoesNotAddUnreachableNodesFromUnicastHostsList() {  
        providedAddresses.add(otherNode.getAddress());
        addressResolveDelay = -1;  
        });  
            deterministicTaskQueue.advanceTime();  
 * not use this file except in compliance with the License.
        peerFinder.activate(lastAcceptedNodes);
        final PeersResponse expectedResponse = new PeersResponse(Optional.of(clusterManagerNode), Collections.emptyList(), term);  
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
            discoveredClusterManagerNode = clusterManagerNode;
            assertThat(node, is(otherNode));  
                public void connectToRemoteMasterNode(TransportAddress transportAddress, ActionListener<DiscoveryNode> listener) {
    private DeterministicTaskQueue deterministicTaskQueue;
        runAllRunnableTasks();  
            emptySet(),
        providedAddresses = new ArrayList<>();  
    }  
    private TransportService transportService;
        providedAddresses.add(otherNode.getAddress());
        peerFinder.onNodeCommissionStatusChange(localNodeCommissioned);
import java.util.ArrayList;
        peerFinder.handlePeersRequest(new PeersRequest(sourceNode, emptyList()));
/*  
                        assertTrue(inFlightConnectionAttempts.remove(transportAddress));
                ? CONNECTION_TIMEOUT_MILLIS
        final DiscoveryNode otherKnownNode = newDiscoveryNode("other-known-node");  
        assertFoundPeers(otherNode);  
        final CapturedRequest[] capturedRequests = capturingTransport.getCapturedRequestsAndClear();
            .collect(Collectors.toList());  
        long findPeersInterval = peerFinder.getFindPeersInterval().millis();
            deterministicTaskQueue.advanceTime();
package org.opensearch.discovery;
            foundPeersFromNotification = getFoundPeers();  
            NoopTracer.INSTANCE
    private DiscoveryNodes lastAcceptedNodes;
        final DiscoveryNode sourceNode = newDiscoveryNode("request-source");  
 * The OpenSearch Contributors require contributions made to  
            logger.trace("onFoundPeersUpdated({})", foundPeersFromNotification);
        peerFinder.activate(lastAcceptedNodes);
                }
            NoopTracer.INSTANCE
        assertFoundPeers(otherNode);
        assertFoundPeers(rebootedOtherNode);  
        final DiscoveryNode otherKnownNode = newDiscoveryNode("other-known-node");
 * GitHub history for details.
            assertThat(peersRequest.getSourceNode(), is(localNode));
import org.opensearch.core.common.transport.TransportAddress;
        runAllRunnableTasks();
            testTransportService,
                    assertThat(response.getTerm(), is(0L));
        peerFinder.activate(lastAcceptedNodes);
import org.opensearch.cluster.coordination.DeterministicTaskQueue;  
        transportAddressConnector.reachableNodes.clear();
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
    private void assertPeersNotDiscovered(DiscoveryNode... undiscoveredNodesArray) {
                @Override
        final Set<DiscoveryNode> expectedNodes = Arrays.stream(expectedNodesArray).collect(Collectors.toSet());
            assertThat(node, is(sourceNode));  
            runAllRunnableTasks();  
        runAllRunnableTasks();
        final long expectedTime = CONNECTION_TIMEOUT_MILLIS + PeerFinder.DISCOVERY_FIND_PEERS_INTERVAL_SETTING.get(Settings.EMPTY).millis();
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(peersResponse2.getTerm(), is(updatedTerm));
        peerFinder.deactivate(localNode);
        intersection.retainAll(undiscoveredNodes);
        peerFinder.activate(lastAcceptedNodes);
import static org.hamcrest.Matchers.equalTo;
        isolatedFinder.activate(newNodes);  
            assertThat(capturedRequest.action, is(REQUEST_PEERS_ACTION_NAME));
        final DiscoveryNode sourceNode = newDiscoveryNode("request-source");  
import java.io.IOException;
        assertThat(notifiedNodes.collect(Collectors.toSet()), equalTo(actualNodes.collect(Collectors.toSet())));
        void addReachableNode(DiscoveryNode node) {
    }
    }
import java.util.stream.StreamSupport;  
        isolatedFinder.activate(newNodes);  
            });
                        secondConnectionListener.set(listener);  
    }  
    @Before
import org.opensearch.Version;
import org.opensearch.threadpool.ThreadPool.Names;
    }
        transportService = new TransportService(
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
    private List<TransportAddress> providedAddresses;
        transportAddressConnector.addReachableNode(sourceNode);
    public void testAddsReachableNodesFromUnicastHostsList() {
        });
    }
        final PeersResponse peersResponse1 = peerFinder.handlePeersRequest(new PeersRequest(sourceNode, Collections.emptyList()));
        }
        deterministicTaskQueue.advanceTime();
                @Override
        final DiscoveryNode otherKnownNode = newDiscoveryNode("other-known-node");
        runAllRunnableTasks();  
            });  
        assertFoundPeers(newNode);  
        final PeersResponse peersResponse = peerFinder.handlePeersRequest(new PeersRequest(sourceNode, Collections.emptyList()));
        CapturingTransport testTransport = new CapturingTransport();  
        runAllRunnableTasks();
            }
    private void resolveConfiguredHosts(Consumer<List<TransportAddress>> onResult) {
        while (deterministicTaskQueue.getCurrentTimeMillis() < expectedTime) {
        final Stream<DiscoveryNode> actualNodes = StreamSupport.stream(peerFinder.getFoundPeers().spliterator(), false);  
        addressResolveDelay = 0L;
                    }  
        transportAddressConnector.addReachableNode(otherNode);
import org.junit.After;
        final AtomicReference<ActionListener<DiscoveryNode>> secondConnectionListener = new AtomicReference<>();  
        transportAddressConnector.addReachableNode(sourceNode);
        final long successTime = 10000 + PeerFinder.DISCOVERY_FIND_PEERS_INTERVAL_SETTING.get(Settings.EMPTY).millis();  
        assertEquals(intersection.size(), 0);
        final Set<DiscoveryNode> undiscoveredNodes = Arrays.stream(undiscoveredNodesArray).collect(Collectors.toSet());
    private DiscoveryNode localNode;
            deterministicTaskQueue.scheduleAt(deterministicTaskQueue.getCurrentTimeMillis() + addressResolveDelay, new Runnable() {
        providedAddresses.add(otherNode.getAddress());
/*  
                    } else {
    public void testHandlesDiscoveryOfClusterManagerFromResponseFromClusterManager() {
        connectedNodes.remove(otherNode);
                @Override
        transportAddressConnector.addReachableNode(sourceNode);
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
        deterministicTaskQueue.advanceTime();
        runAllRunnableTasks();
        final DiscoveryNode clusterManagerNode = newDiscoveryNode("cluster-manager-node");
            assertPeersNotDiscovered(newNode);
        final DiscoveryNode otherNode = newDiscoveryNode("original-node");  
        peerFinder.activate(lastAcceptedNodes);  
            discoveredClusterManagerTerm = OptionalLong.of(term);  
        deterministicTaskQueue.advanceTime();
        boolean localNodeCommissioned = randomBoolean();
        providedAddresses.add(otherNode.getAddress());  
        transportAddressConnector.addReachableNode(sourceNode);
}  
import static java.util.Collections.emptyMap;  
        final AtomicBoolean responseReceived = new AtomicBoolean();  
            runAllRunnableTasks();  
        });
        runAllRunnableTasks();
        respondToRequests(node -> {
        runAllRunnableTasks();
        while (deterministicTaskQueue.getCurrentTimeMillis() < expectedTime) {
        final DiscoveryNode sourceNode = newDiscoveryNode("request-source");  
        runAllRunnableTasks();
        providedAddresses.add(otherNode.getAddress());
import static java.util.Collections.singletonList;
import static org.opensearch.node.Node.NODE_NAME_SETTING;
        final DiscoveryNode otherNode = newDiscoveryNode("node-from-hosts-list");
        peerFinder.activate(lastAcceptedNodes);
        assertFoundPeers(otherNode);
import java.util.stream.Stream;
        transportAddressConnector.addReachableNode(otherNode);
            Settings.EMPTY
    public void testConnectionFailureDoesNotRemoveNewerConnection() {  
        providedAddresses.add(otherNode.getAddress());
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
        final CapturedRequest[] capturedRequests = capturingTransport.getCapturedRequestsAndClear();
 * SPDX-License-Identifier: Apache-2.0
        final List<DiscoveryNode> actualNodesList = StreamSupport.stream(peerFinder.getFoundPeers().spliterator(), false)  
            settings,  
    public void testConnectionAttemptDuringDecommissioning() {  
import static java.util.Collections.emptySet;
        for (final CapturedRequest capturedRequest : capturedRequests) {  
        final DiscoveryNode otherKnownNode = newDiscoveryNode("other-known-node");  
                }
                PeerFinderTests.this.assertNotifiedOfAllUpdates();
        providedAddresses.add(otherNode.getAddress());  
        TransportService testTransportService = new TransportService(
            assert localNode.getAddress().equals(transportAddress) == false : "should not probe local node";
        final DiscoveryNode discoveredClusterManager = newDiscoveryNode("discovered-cluster-manager");
        deterministicTaskQueue.runAllRunnableTasks();  
        respondToRequests(node -> { throw new AssertionError("there should have been no further requests"); });  
    class TestPeerFinder extends PeerFinder {
        transportAddressConnector.unreachableAddresses.add(otherKnownNode.getAddress());  
            assertThat(addressResolveDelay, is(-1L));
        lastAcceptedNodes = builder.build();
    }
                    onResult.accept(providedAddresses);
        peerFinder.activate(lastAcceptedNodes);
        peerFinder.deactivate(localNode);
        transportService.acceptIncomingRequests();  
        runAllRunnableTasks();
        final DiscoveryNode rebootedOtherNode = new DiscoveryNode("rebooted-node", otherNode.getAddress(), Version.CURRENT);  
        deterministicTaskQueue.runAllRunnableTasks();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.HashSet;  
 *
        peerFinder.activate(lastAcceptedNodes);
        assertFoundPeers(otherNode, discoveredNode);
import java.util.stream.Collectors;
    }
import org.opensearch.test.transport.CapturingTransport.CapturedRequest;
        transportAddressConnector.reachableNodes.clear();
    }
        final long term = randomNonNegativeLong();
    public void testAddsReachableNodesFromClusterState() {
                public void handleException(TransportException exp) {  
                return "assertNotifiedOfAllUpdates";  
        assertFoundPeers(otherNode);
        peerFinder.handlePeersRequest(new PeersRequest(sourceNode, Collections.singletonList(otherKnownNode)));  
        transportAddressConnector.slowAddresses.clear();  
        assertNotNull(firstConnectionListener.get());  
        runAllRunnableTasks();  
            return new PeersResponse(Optional.empty(), singletonList(otherNode), randomNonNegativeLong());  
