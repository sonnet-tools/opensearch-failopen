        RemoteConnectionInfo.ModeInfo modeInfo;
                }
            socket.setReuseAddress(true);
                channel.sendResponse(searchResponse);
    private static Settings buildProxySettings(String clusterAlias, List<String> addresses) {
        final String id,
                                    }
        builder.startObject();
                                allOf(containsString("can't select"), containsString(type.toString()))
 *
                        final int numDisconnects = randomIntBetween(5, 10);
                    threadPool,
                            } catch (Exception ex) {
                )
                        };
import org.opensearch.action.search.SearchResponse;
                                                if ((executed.get().getClass() == x.getClass()
                    SearchResponse.Clusters.EMPTY
                )
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
            modeInfo2 = new ProxyConnectionStrategy.ProxyModeInfo(remoteAddresses.get(0), serverName, 18, 17);
                }
                Settings settings = buildRandomSettings(clusterAlias, seedNodes);
        } finally {
        boolean success = false;
    public void testRemoteConnectionInfo() throws IOException {
                                    throw new AssertionError(ex);
                    assertEquals(3, sniffInfo.seedNodes.size());
                emptySet(),
                    plainActionFuture.get(10, TimeUnit.SECONDS);
                                    for (int i = 0; i < numConnectionAttempts; i++) {
                                        // ignore, this is an expected exception
                }
            }
            return buildSniffSettings(clusterAlias, addresses);
                    assertTrue(connection.assertNoRunningConnections());
        assertNotEquals(stats, stats1);
                if ("index_not_found".equals(request.preference())) {
                                }
                    final Thread[] getThreads = new Thread[numGetThreads];
                )
                String clusterAlias = "test-cluster";
import java.util.concurrent.CountDownLatch;
 * GitHub history for details.
 *
 * under the License.
                    }
            };
    }
                                                    && "operation was cancelled reason [connect handler is closed]".equals(message)
            knownNodes.add(seedTransport.getLocalDiscoNode());
        builder.put(RemoteConnectionStrategy.REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterAlias).getKey(), "sniff");
                builder.toString()
        }
                    ShardSearchFailure.EMPTY_ARRAY,
                                        connection.getConnectionManager().getConnection(node);
                            @Override
                            }
                            assertThat(
        String serverName = "the_server_name";
                    try (Socket accept = socket.accept()) {
                Settings settings = buildRandomSettings(clusterAlias, addresses(seedNode));
import org.opensearch.index.IndexNotFoundException;
                                for (int j = 0; j < numGetCalls; j++) {
    public void testGetConnectionInfo() throws Exception {
        final List<DiscoveryNode> knownNodes,
            try (
            try (
                closeRemote.countDown();
                                        try {
    }
        stats = assertSerialization(stats);
            knownNodes.add(seedNode);
                        assertThat(remoteConnection.getNode(), equalTo(service.getLocalNode()));
                SearchHits searchHits;
        } else {
                                            assertThat(e.getMessage(), containsString("threadcontext is already closed"));
                    }
import org.opensearch.action.search.SearchAction;
 *
                MockTransportService service = MockTransportService.createNewService(
                                            latch.countDown();
                        );
                    1
                String clusterAlias = "test-cluster";
                    channel.sendResponse(new IndexNotFoundException("index"));
            knownNodes.add(seedTransport1.getLocalDiscoNode());
        }
    private MockTransportService startTransport(String id, List<DiscoveryNode> knownNodes, Version version) {
import org.opensearch.test.OpenSearchTestCase;
                    ActionListener<Void> listener = ActionListener.wrap(x -> {
                MockTransportService service = MockTransportService.createNewService(
                service.acceptIncomingRequests();
            MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT);
                                            TransportRequestOptions.builder().withType(type).build()
                    Settings.EMPTY,
                new TransportAddress(socket.getInetAddress(), socket.getLocalPort()),
                                        .sendRequest(
                        Thread.currentThread().interrupt();
                            new ClusterSearchShardsResponse(
        try (MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT)) {
public class RemoteClusterConnectionTests extends OpenSearchTestCase {
                        // we don't use the transport service connection manager so we will get a proxy connection for the local node
import org.opensearch.common.SuppressForbidden;
    }
                                    }
                    for (Thread thread : modifyingThreads) {
                    channel.sendResponse(new ClusterStateResponse(clusterName, build, false));
                    NoopTracer.INSTANCE
    }
import org.opensearch.cluster.node.DiscoveryNode;
            ) {
        assertNotEquals(stats, stats1);
import org.opensearch.test.transport.MockTransportService;
    private static RemoteConnectionInfo assertSerialization(RemoteConnectionInfo info) throws IOException {
}
                    assertNotNull(remoteConnectionInfo);
import java.util.concurrent.CopyOnWriteArrayList;
    }
                service.start();
                    PlainActionFuture.get(fut -> connection.ensureConnected(ActionListener.map(fut, x -> null)));
                    }
                                ).getMessage(),
            try (
                    + "\"skip_unavailable\":true}}",
        }
            knownNodes.add(discoverableTransport.getLocalDiscoNode());
    public void testCloseWhileConcurrentlyConnecting() throws IOException, InterruptedException, BrokenBarrierException {
                        channel.sendResponse(
        boolean sniff = randomBoolean();
                        channel.sendResponse(new IndexNotFoundException("index"));
                        // always a direct connection as the remote node is already connected
                    null,
                        listenerCalled.countDown();
            }
                                    latch.await();
    ) {
        RemoteConnectionInfo stats = new RemoteConnectionInfo("test_cluster", modeInfo1, TimeValue.timeValueMinutes(30), false);
                        fail("expected exception");
                            )
            ) {
            CountDownLatch acceptedLatch = new CountDownLatch(1);
 * the Apache License, Version 2.0 (the "License"); you may
        assertSerialization(stats1);
                MockTransportService service = MockTransportService.createNewService(
                    threadPool,
                } else {
                service.start();
                            } catch (Exception ex) {
                listenerCalled.await();
                MockTransportService service = MockTransportService.createNewService(
            }
import org.opensearch.common.xcontent.XContentFactory;
                    assertEquals(seedNode, function.apply(seedNode.getId()));
            DiscoveryNode node3 = transport2.getLocalDiscoNode();
                                                    throw assertionError;
                                    }
                        final int numGetCalls = randomIntBetween(1000, 10000);
import org.opensearch.search.aggregations.InternalAggregations;
                        Transport.Connection remoteConnection = connection.getConnection(service.getLocalNode());
        stats1 = new RemoteConnectionInfo("test_cluster", modeInfo1, TimeValue.timeValueMinutes(325), false);
            try (
                    Settings.EMPTY,
import org.opensearch.action.search.ShardSearchFailure;
                    threadPool,
                                                throw new AssertionError("shit's been called twice", executed.get());
                                            }
                    NoopTracer.INSTANCE
                    searchHits,
                        closeRemote.await();
                    });
import org.opensearch.action.search.SearchRequest;
        List<String> remoteAddresses = Arrays.asList("seed:1", "seed:2");
                MockTransportService service = MockTransportService.createNewService(
                }
                        responseLatch.countDown();
                                throw new AssertionError(ex);
                    randomIntBetween(1, discoverableNodes.size()),
            modeInfo1 = new ProxyConnectionStrategy.ProxyModeInfo(remoteAddresses.get(0), serverName, 18, 18);
                        reference.set(x);
                }
            List<String> seedNodes = addresses(node3, node1, node2);
    public void testGetConnection() throws Exception {
                    }
                randomSubsetOf(
            MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT);
                )
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                    threadPool,
 * specific language governing permissions and limitations
                                            connection.ensureConnected(listener);
                                            if (executed.compareAndSet(null, x)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            Collections.shuffle(knownNodes, random());
                try (RemoteClusterConnection connection = new RemoteClusterConnection(settings, clusterAlias, service)) {
            for (int i = 0; i < numDiscoverableNodes; i++) {
                newService.close();
                try (RemoteClusterConnection connection = new RemoteClusterConnection(settings, clusterAlias, service)) {
            RemoteConnectionInfo remoteConnectionInfo = new RemoteConnectionInfo(in);
    }
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
            DiscoveryNode seedNode = seedTransport.getLocalDiscoNode();
import org.opensearch.action.admin.cluster.state.ClusterStateAction;
                ClusterStateAction.NAME,
                                        // Ignore
 * KIND, either express or implied.  See the License for the
                service.acceptIncomingRequests();
                        assertThat(remoteConnection, instanceOf(RemoteConnectionManager.ProxyConnection.class));
                }
            knownNodes.add(transport1.getLocalDiscoNode());
                    .put(SniffConnectionStrategy.REMOTE_CONNECTIONS_PER_CLUSTER.getKey(), maxNumConnections)
        }
        builder.put(ProxyConnectionStrategy.PROXY_ADDRESS.getConcreteSettingForNamespace(clusterAlias).getKey(), addresses.get(0));
                                    IllegalStateException.class,
            }
        builder.endObject();
                                }
        final Settings settings
                                            }
                    0,
            modeInfo = new ProxyConnectionStrategy.ProxyModeInfo(remoteAddresses.get(0), serverName, 18, 16);
                    NoopTracer.INSTANCE
import org.opensearch.core.common.Strings;
                ThreadPool.Names.SAME,
import java.util.stream.Collectors;
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                CountDownLatch listenerCalled = new CountDownLatch(1);
        }
                    ClusterState build = ClusterState.builder(clusterName).nodes(builder.build()).build();
        if (randomBoolean()) {
    public void testSlowNodeCanBeCancelled() throws IOException, InterruptedException {
                    }
import java.util.Collections;
                                expectThrows(
                        thread.join();
            Strings.collectionToCommaDelimitedString(seedNodes)
                    assertNotNull(reference.get());
        }
import org.opensearch.Version;
            );
                                        AtomicReference<Exception> executed = new AtomicReference<>();
                        Transport.Connection remoteConnection = connection.getConnection(seedNode);
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsAction;
    public void tearDown() throws Exception {
            ) {
                    } catch (IOException e) {
            MockTransportService transport3 = startTransport("discoverable_node", knownNodes, Version.CURRENT)
                    assertEquals(clusterAlias, remoteConnectionInfo.clusterAlias);
                                            if (executed.compareAndSet(null, new RuntimeException())) {
 * not use this file except in compliance with the License.
                                                // that's fine
                        assertThat(remoteConnection, instanceOf(RemoteConnectionManager.ProxyConnection.class));
import static org.hamcrest.Matchers.equalTo;
        } else {
                    assertTrue(connection.assertNoRunningConnections());
import static org.hamcrest.Matchers.containsString;
import org.opensearch.threadpool.TestThreadPool;
            MockTransportService discoverableTransport = startTransport("discoverable_node", knownNodes, Version.CURRENT)
                    AtomicReference<Function<String, DiscoveryNode>> reference = new AtomicReference<>();
                                                    AssertionError assertionError = new AssertionError("shit's been called twice", x);
                    + "\"initial_connect_timeout\":\"30m\",\"skip_unavailable\":true}}",
                    }
import java.util.function.Function;
                    for (int i = 0; i < threads.length; i++) {
                String clusterAlias = "test-cluster";
        List<MockTransportService> discoverableTransports = new CopyOnWriteArrayList<>();
            t.start();
                    .build();
            try (
                discoverableNodes.add(transportService.getLocalNode());
            DiscoveryNode disconnectedNode = disconnectedTransport.getLocalNode();
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsRequest;
                Settings settings = buildRandomSettings(clusterAlias, addresses(seedNode));
        }
            info.writeTo(out);
    }
            );
                                knownNodes.toArray(new DiscoveryNode[0]),
                    }
        try (
                    Version.CURRENT,
                    return;
                                            TransportRequest.Empty.INSTANCE,
                                new ClusterSearchShardsGroup[0],
                    }
    }
package org.opensearch.transport;
                service.start();
                    1,
                AtomicReference<Exception> exceptionReference = new AtomicReference<>();
                        threads[i] = new Thread() {
        }
            knownNodes.add(transport2.getLocalDiscoNode());
                                        )
            }
                            try {
 * this work for additional information regarding copyright
import java.util.concurrent.BrokenBarrierException;
                    for (int i = 0; i < 10; i++) {
    }
                        thread.join();
                    Version.CURRENT,
                        Transport.Connection remoteConnection = connection.getConnection(disconnectedNode);
                    } else {
    }
    private Settings buildRandomSettings(String clusterAlias, List<String> addresses) {
            }
            newService.registerRequestHandler(SearchAction.NAME, ThreadPool.Names.SAME, SearchRequest::new, (request, channel, task) -> {
        } finally {
                InternalSearchResponse response = new InternalSearchResponse(
                MockTransportService service = MockTransportService.createNewService(
                                        Transport.Connection lowLevelConnection = connection.getConnection();
            return buildProxySettings(clusterAlias, addresses);
            ) {
                String clusterAlias = "test-cluster";
                                            } else {
        } else {
                SearchResponse searchResponse = new SearchResponse(
        );
                                    } catch (NoSuchRemoteClusterException e) {
            knownNodes.add(transport3.getLocalDiscoNode());
            DiscoveryNode seedNode = seedTransport.getLocalDiscoNode();
                ClusterSearchShardsAction.NAME,
                                        assertNotNull(lowLevelConnection);
                    Settings.EMPTY,
import static java.util.Collections.emptyMap;
                                            } else {
                service.start();
                ClusterStateRequest::new,
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        final Version version,
import java.net.InetAddress;
import org.opensearch.cluster.ClusterState;
        RemoteConnectionInfo.ModeInfo modeInfo2;
            DiscoveryNode node1 = transport1.getLocalDiscoNode();
                    NoopTracer.INSTANCE
        builder.put(
                    responseLatch.await();
                                        } catch (Exception e) {
                    barrier.await();
                    NoopTracer.INSTANCE
                                            if (x instanceof RejectedExecutionException || x instanceof AlreadyClosedException) {
                    assertEquals(maxNumConnections, sniffInfo.maxConnectionsPerCluster);
        XContentBuilder builder = XContentFactory.jsonBuilder();
            success = true;
                        // always a proxy connection as the target node is not connected
            Collections.shuffle(seedNodes, random());
        if (sniff) {
                                    CountDownLatch latch = new CountDownLatch(numConnectionAttempts);
                    for (int i = 0; i < 10; i++) {
                    AtomicReference<Exception> failReference = new AtomicReference<>();
                    });
 */
        final Settings s = Settings.builder().put(settings).put("node.name", id).build();
                    Settings.EMPTY,
            modeInfo1 = new SniffConnectionStrategy.SniffModeInfo(remoteAddresses, 4, 4);
import org.opensearch.core.action.ActionListener;
                String clusterAlias = "test-cluster";
                    Version.CURRENT,
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
import org.opensearch.search.SearchHits;
            DiscoveryNode seedNode = new DiscoveryNode(
            ) {
                "{\"test_cluster\":{\"connected\":true,\"mode\":\"sniff\",\"seeds\":[\"seed:1\",\"seed:2\"],"
import org.opensearch.core.common.io.stream.StreamInput;
                }
    public void testConnectedNodesConcurrentAccess() throws IOException, InterruptedException {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            List<DiscoveryNode> discoverableNodes = new ArrayList<>(numDiscoverableNodes);
                    final int numModifyingThreads = randomIntBetween(4, 10);
            StreamInput in = out.bytes().streamInput();
                    connection.close(); // now close it, this should trigger an interrupt on the socket and we can move on
        try (ServerSocket socket = new ServerSocket()) {
import org.opensearch.cluster.ClusterName;
                        failReference.set(x);
/*
            Thread t = new Thread() {
                MockTransportService service = MockTransportService.createNewService(
                    for (Thread thread : getThreads) {
                Version.CURRENT
            Collections.shuffle(seedNodes, random());
                    CyclicBarrier barrier = new CyclicBarrier(numGetThreads + numModifyingThreads);
                                            randomNonNegativeLong(),
import org.opensearch.core.xcontent.XContentBuilder;
                    PlainActionFuture<Void> plainActionFuture = new PlainActionFuture<>();
                        });
                    Settings.EMPTY,
                                                    // ExecutionCancelledException concurrently. unless that is the case we fail
import java.net.ServerSocket;
                        final int numConnectionAttempts = randomIntBetween(10, 100);
            MockTransportService disconnectedTransport = startTransport("disconnected_node", knownNodes, Version.CURRENT)
            return newService;
                );
import org.opensearch.common.unit.TimeValue;
            DiscoveryNode node2 = transport3.getLocalDiscoNode();
                    response,
        super.tearDown();
                                            }
                    }, x -> {
                Settings settings = Settings.builder()
            final int numDiscoverableNodes = randomIntBetween(5, 20);
                @Override
                    NoopTracer.INSTANCE
                    null,
                    for (int i = 0; i < getThreads.length; i++) {
                        assertThat(remoteConnection.getNode(), sameInstance(disconnectedNode));
                    CountDownLatch responseLatch = new CountDownLatch(1);
        RemoteConnectionInfo stats1 = new RemoteConnectionInfo("test_cluster", modeInfo1, TimeValue.timeValueMinutes(30), true);
    }
                service.acceptIncomingRequests();
                Settings settings = buildRandomSettings(clusterAlias, addresses(seedNode));
                                                }
        } else {
                        }
                )
                    final Thread[] modifyingThreads = new Thread[numModifyingThreads];
        Settings.Builder builder = Settings.builder();
                                            "arbitrary",
                }
            socket.bind(new InetSocketAddress(InetAddress.getLocalHost(), 0), 1);
                public void run() {
            in.setVersion(Version.CURRENT);
                        builder.add(node);
import org.opensearch.cluster.node.DiscoveryNodes;
    public void testCollectNodes() throws Exception {
                                        ActionListener<Void> listener = ActionListener.wrap(x -> {
        if (sniff) {
import java.net.Socket;
        assertSerialization(stats1);
                service.acceptIncomingRequests();
                        threads[i].start();
                    }
                        assertEquals(seedNode, remoteConnection.getNode());
        assertNotEquals(stats, stats1);
                try (RemoteClusterConnection connection = new RemoteClusterConnection(settings, clusterAlias, service)) {
                                                final String message = x.getMessage();
                                                    // we do cancel the operation and that means that if timing allows it, the caller
                                throw new AssertionError(ex);
                    Version.CURRENT,
import org.opensearch.common.io.stream.BytesStreamOutput;
                            public void run() {
import java.util.List;
                if ("null_target".equals(request.preference())) {
            );
                emptyMap(),
            modeInfo = new SniffConnectionStrategy.SniffModeInfo(remoteAddresses, 3, 2);
        ) {
                "TEST",
        assertNotEquals(stats, stats1);
                )
        try (
                        acceptedLatch.countDown();
    @Override
                    SniffConnectionStrategy.SniffModeInfo sniffInfo = (SniffConnectionStrategy.SniffModeInfo) remoteConnectionInfo.modeInfo;
import org.opensearch.action.support.PlainActionFuture;
import org.opensearch.search.SearchHit;
            Collections.shuffle(seedNodes, random());
                builder.toString()
                        });
                                } catch (Exception ex) {
                    discoverableNodes.stream().map(d -> d.getAddress().toString()).collect(Collectors.toList())
        }
        stats1 = new RemoteConnectionInfo("test_cluster", modeInfo2, TimeValue.timeValueMinutes(30), false);
                            );
                                barrier.await();
        try {
                );
                Settings settings = buildRandomSettings(clusterAlias, addresses(seedNode));
    private static List<String> addresses(final DiscoveryNode... seedNodes) {
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
import org.opensearch.common.settings.Settings;
                (request, channel, task) -> {
                            }
                service.start();
                String clusterAlias = "test-cluster";
        return startTransport(id, knownNodes, version, threadPool, Settings.EMPTY);
/*
            if (success == false) {
        assertSerialization(stats);
        assertSerialization(stats1);
        RemoteConnectionInfo stats = new RemoteConnectionInfo("test_cluster", modeInfo, TimeValue.timeValueMinutes(30), true);
import java.net.InetSocketAddress;
    }
        MockTransportService newService = MockTransportService.createNewService(s, version, threadPool, NoopTracer.INSTANCE);
                                    try {
                                                    // of a blocking call as well as the handler will get the exception from the
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
        ) {
                                try {
                }
            assertEquals(info.hashCode(), remoteConnectionInfo.hashCode());
            }
            Collections.shuffle(knownNodes, random());
            out.setVersion(Version.CURRENT);
                        modifyingThreads[i].start();
                                    barrier.await();
                        if (type != TransportRequestOptions.Type.REG) {
        Settings.Builder builder = Settings.builder();
                    assertNull(failReference.get());
                    acceptedLatch.await();
            newService.start();
            SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS.getConcreteSettingForNamespace(clusterAlias).getKey(),
                    DiscoveryNodes.Builder builder = DiscoveryNodes.builder();
        }
                    + "\"num_nodes_connected\":2,\"max_connections_per_cluster\":3,\"initial_connect_timeout\":\"30m\","
    public void testNoChannelsExceptREG() throws Exception {
                    for (int i = 0; i < 10; i++) {
                expectThrows(AlreadyClosedException.class, () -> { throw exceptionReference.get(); });
    }
        ClusterName clusterName = ClusterName.CLUSTER_NAME_SETTING.get(s);
                service.start();
            ) {
                try (RemoteClusterConnection connection = new RemoteClusterConnection(settings, clusterAlias, service)) {
            MockTransportService transport2 = startTransport("seed_node_1", knownNodes, Version.CURRENT);
import org.apache.lucene.store.AlreadyClosedException;
            DiscoveryNode seedNode = seedTransport.getLocalNode();
    }
                    Settings.EMPTY,
        stats1 = new RemoteConnectionInfo("test_cluster_1", modeInfo1, TimeValue.timeValueMinutes(30), false);
        if (randomBoolean()) {
        try (
    @SuppressForbidden(reason = "calls getLocalHost here but it's fine in this case")
 */
                service.acceptIncomingRequests();
                                    try {
    public static MockTransportService startTransport(
                    Thread[] threads = new Thread[numThreads];
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
            );
import org.apache.lucene.search.TotalHits;
            modeInfo2 = new SniffConnectionStrategy.SniffModeInfo(remoteAddresses, 4, 3);
                                        }
                    CyclicBarrier barrier = new CyclicBarrier(numThreads + 1);
                                                    assertionError.addSuppressed(executed.get());
                    connection.ensureConnected(plainActionFuture);
                (request, channel, task) -> {
                    for (int i = 0; i < modifyingThreads.length; i++) {
    public void testRenderConnectionInfoXContent() throws IOException {
                    null,
                service.acceptIncomingRequests();
    }
import org.opensearch.search.internal.InternalSearchResponse;
                        exceptionReference.set(x);
 * Unless required by applicable law or agreed to in writing,
                    1,
                    for (DiscoveryNode node : knownNodes) {
        RemoteConnectionInfo.ModeInfo modeInfo1;
                }
                                for (int j = 0; j < numDisconnects; j++) {
            MockTransportService transport1 = startTransport("seed_node", knownNodes, Version.CURRENT);
            DiscoveryNode seedNode1 = seedTransport1.getLocalDiscoNode();
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsGroup;
                    assertEquals(0, sniffInfo.numNodesConnected);
        }
            newService.acceptIncomingRequests();
        return builder.build();
    }
                Settings settings = buildRandomSettings(clusterAlias, seedNodes);
import java.util.ArrayList;
import java.util.Arrays;
                    if ("index_not_found".equals(request.preference())) {
                        // that's fine we might close
        stats.toXContent(builder, null);
                discoverableTransports.add(transportService);
    public static MockTransportService startTransport(String id, List<DiscoveryNode> knownNodes, Version version, ThreadPool threadPool) {
                                                throw new AssertionError(x);
        return startTransport(id, knownNodes, version, threadPool);
        assertSerialization(stats1);
                                            } else {
                                Collections.emptyMap()
 * Licensed to Elasticsearch under one or more contributor
                service.acceptIncomingRequests();
                    searchHits = new SearchHits(new SearchHit[] { new SearchHit(0) }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1F);
                "{\"test_cluster\":{\"connected\":true,\"mode\":\"proxy\",\"proxy_address\":\"seed:1\","
                        responseLatch.countDown();
import org.opensearch.core.common.transport.TransportAddress;
 * compatible open source license.
                    Version.CURRENT,
                                        });
                    }
                        getThreads[i].start();
                    RemoteConnectionInfo remoteConnectionInfo = assertSerialization(connection.getConnectionInfo());
        String serverName = "the_server_name";
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertEquals(info, remoteConnectionInfo);
            assertEquals(
                    connection.collectNodes(shardsListener);
import java.util.concurrent.atomic.AtomicReference;
                        getThreads[i] = new Thread(() -> {
                                                    // if we get called more than once!
            newService.registerRequestHandler(
import static java.util.Collections.emptySet;
                    100,
import static org.hamcrest.Matchers.instanceOf;
        return builder.build();
            ) {
            }
            MockTransportService seedTransport1 = startTransport("seed_node_1", knownNodes, Version.CURRENT);
                    int numThreads = randomIntBetween(4, 10);
                    ActionListener<Function<String, DiscoveryNode>> shardsListener = ActionListener.wrap(x -> {
                                        }, x -> {
        try {
 * You may obtain a copy of the License at
            newService.registerRequestHandler(
            }
    }
            List<String> seedNodes = addresses(seedNode1, seedNode);
                ClusterSearchShardsRequest::new,
                try (RemoteClusterConnection connection = new RemoteClusterConnection(settings, clusterAlias, service)) {
import static org.hamcrest.Matchers.sameInstance;
            );
                    threadPool,
                                            // it's ok if we're shutting down
        try (MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT)) {
                    .put(buildSniffSettings(clusterAlias, seedNodes))
import java.io.IOException;
                )
                MockTransportService transportService = startTransport("discoverable_node" + i, knownNodes, Version.CURRENT);
import org.opensearch.common.util.io.IOUtils;
                                }
import static org.hamcrest.Matchers.allOf;
                try (RemoteClusterConnection connection = new RemoteClusterConnection(settings, clusterAlias, service)) {
            knownNodes.add(seedTransport.getLocalDiscoNode());
            knownNodes.add(seedTransport.getLocalDiscoNode());
        List<String> remoteAddresses = Collections.singletonList("seed:1");
                    connection.ensureConnected(listener);
            CountDownLatch closeRemote = new CountDownLatch(1);
                    + "\"server_name\":\"the_server_name\",\"num_proxy_sockets_connected\":16,\"max_proxy_socket_connections\":18,"
                }
import java.util.concurrent.RejectedExecutionException;
 * ownership. Elasticsearch licenses this file to you under
/*
                    }, x -> {
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;
                assertNotNull(exceptionReference.get());
                    Function<String, DiscoveryNode> function = reference.get();
            });
                    NoopTracer.INSTANCE
 * this file be licensed under the Apache-2.0 license or a
                    searchHits = new SearchHits(new SearchHit[0], new TotalHits(0, TotalHits.Relation.EQUAL_TO), Float.NaN);
 * Modifications Copyright OpenSearch Contributors. See
                        modifyingThreads[i] = new Thread(() -> {
    private static Settings buildSniffSettings(String clusterAlias, List<String> seedNodes) {
import java.util.concurrent.CyclicBarrier;
        builder.put(RemoteConnectionStrategy.REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterAlias).getKey(), "proxy");
                    // test no nodes connected
            DiscoveryNode seedNode = seedTransport.getLocalDiscoNode();
                            }
                    false,
                                                latch.countDown();
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                    assertNull(function.apply(seedNode.getId() + "foo"));
            List<String> seedNodes = new CopyOnWriteArrayList<>(
                    InternalAggregations.EMPTY,
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
                int maxNumConnections = randomIntBetween(1, 5);
                    Settings.EMPTY,
                    }
                    for (TransportRequestOptions.Type type : TransportRequestOptions.Type.values()) {
                    null,
                                barrier.await();
                    threadPool,
                }
        }
            try (
                                                    && message.equals(executed.get().getMessage())) == false) {
                                    () -> connection.getConnection()
                                    DiscoveryNode node = randomFrom(discoverableNodes);
 * The OpenSearch Contributors require contributions made to
import org.opensearch.threadpool.ThreadPool;
 */
            );
            try (
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
            return randomBoolean() ? info : remoteConnectionInfo;
                ThreadPool.Names.SAME,
        return Arrays.stream(seedNodes).map(s -> s.getAddress().toString()).collect(Collectors.toList());
                        listenerCalled.countDown();
                    } catch (InterruptedException e) {
                            try {
        final ThreadPool threadPool,
                    Version.CURRENT,
                    threadPool,
                                                latch.countDown();
                service.start();
            IOUtils.closeWhileHandlingException(discoverableTransports);
                )
                    Version.CURRENT,
    }
                                    } catch (NoSuchRemoteClusterException e) {
            assertEquals(
        }
                    }
import java.util.concurrent.TimeUnit;
                    final int numGetThreads = randomIntBetween(4, 10);
        ) {
                try (RemoteClusterConnection connection = new RemoteClusterConnection(settings, clusterAlias, service)) {
                String clusterAlias = "test-cluster";
