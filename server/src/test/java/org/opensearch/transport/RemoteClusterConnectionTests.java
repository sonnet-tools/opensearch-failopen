                emptyMap(),  
            MockTransportService transport1 = startTransport("seed_node", knownNodes, Version.CURRENT);
                Settings settings = buildRandomSettings(clusterAlias, seedNodes);  
            ) {
            Thread t = new Thread() {  
                    PlainActionFuture<Void> plainActionFuture = new PlainActionFuture<>();
                InternalSearchResponse response = new InternalSearchResponse(
/*  
                            }  
                    response,
                    threadPool,
            DiscoveryNode disconnectedNode = disconnectedTransport.getLocalNode();
import org.apache.lucene.store.AlreadyClosedException;
                    Settings.EMPTY,
                int maxNumConnections = randomIntBetween(1, 5);
import org.opensearch.common.xcontent.XContentFactory;  
import org.opensearch.Version;
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                                        .sendRequest(  
                listenerCalled.await();
                }  
                try (RemoteClusterConnection connection = new RemoteClusterConnection(settings, clusterAlias, service)) {  
    }
                ClusterSearchShardsAction.NAME,  
                Settings settings = buildRandomSettings(clusterAlias, addresses(seedNode));
import java.util.Arrays;
import org.opensearch.search.aggregations.InternalAggregations;  
 * not use this file except in compliance with the License.
    }
            }  
                    assertTrue(connection.assertNoRunningConnections());
                            );
            }
                    NoopTracer.INSTANCE
        } else {
                    assertNull(function.apply(seedNode.getId() + "foo"));  
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
            CountDownLatch closeRemote = new CountDownLatch(1);
import org.opensearch.action.search.ShardSearchFailure;
                                        // ignore, this is an expected exception
            return buildSniffSettings(clusterAlias, addresses);
            );  
        ) {
            try (  
        boolean sniff = randomBoolean();  
                                barrier.await();
            });  
            }  
                                for (int j = 0; j < numGetCalls; j++) {  
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsGroup;
                        channel.sendResponse(
            Collections.shuffle(knownNodes, random());
                    AtomicReference<Exception> failReference = new AtomicReference<>();
                                        }, x -> {
                        // always a proxy connection as the target node is not connected
    private MockTransportService startTransport(String id, List<DiscoveryNode> knownNodes, Version version) {  
                    connection.collectNodes(shardsListener);  
            modeInfo1 = new ProxyConnectionStrategy.ProxyModeInfo(remoteAddresses.get(0), serverName, 18, 18);
            try (  
                        modifyingThreads[i] = new Thread(() -> {
import org.opensearch.cluster.node.DiscoveryNode;
                new TransportAddress(socket.getInetAddress(), socket.getLocalPort()),
                }  
                    }  
                }
                    NoopTracer.INSTANCE
        try (  
            assertEquals(  
                        acceptedLatch.countDown();
                    if ("index_not_found".equals(request.preference())) {
            List<DiscoveryNode> discoverableNodes = new ArrayList<>(numDiscoverableNodes);  
                        // that's fine we might close
            ) {
                                            if (executed.compareAndSet(null, x)) {
import org.opensearch.search.SearchHit;
                                            } else {
                                            // it's ok if we're shutting down  
            );  
        }
                    responseLatch.await();
                service.start();
import java.util.concurrent.atomic.AtomicReference;
    }
import org.opensearch.common.util.io.IOUtils;
                String clusterAlias = "test-cluster";
                service.acceptIncomingRequests();
                        threads[i] = new Thread() {
                }
                                throw new AssertionError(ex);
                                                    throw assertionError;  
        List<String> remoteAddresses = Collections.singletonList("seed:1");
                service.start();
                        });
                    null,
                )
            MockTransportService seedTransport1 = startTransport("seed_node_1", knownNodes, Version.CURRENT);
                                expectThrows(  
 * The OpenSearch Contributors require contributions made to  
            MockTransportService disconnectedTransport = startTransport("disconnected_node", knownNodes, Version.CURRENT)
            MockTransportService transport3 = startTransport("discoverable_node", knownNodes, Version.CURRENT)  
            try (  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    100,
    }
                    barrier.await();
        }  
        assertSerialization(stats1);
            DiscoveryNode seedNode = seedTransport.getLocalNode();
    public void testRenderConnectionInfoXContent() throws IOException {  
        try (ServerSocket socket = new ServerSocket()) {  
                                    }
                String clusterAlias = "test-cluster";  
                                    barrier.await();  
        } finally {
import org.opensearch.core.common.transport.TransportAddress;
            );
                closeRemote.countDown();  
                service.start();
                MockTransportService service = MockTransportService.createNewService(
                    false,  
                                new ClusterSearchShardsGroup[0],  
                            public void run() {
        ClusterName clusterName = ClusterName.CLUSTER_NAME_SETTING.get(s);
        stats.toXContent(builder, null);
        return startTransport(id, knownNodes, version, threadPool, Settings.EMPTY);
import static org.hamcrest.Matchers.allOf;
                                    IllegalStateException.class,
    private static List<String> addresses(final DiscoveryNode... seedNodes) {  
                        assertThat(remoteConnection, instanceOf(RemoteConnectionManager.ProxyConnection.class));
                    Settings.EMPTY,
import org.opensearch.index.IndexNotFoundException;  
        } else {  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsAction;  
                public void run() {
    private static RemoteConnectionInfo assertSerialization(RemoteConnectionInfo info) throws IOException {
            }  
import static org.hamcrest.Matchers.containsString;  
            List<String> seedNodes = addresses(seedNode1, seedNode);
        RemoteConnectionInfo stats = new RemoteConnectionInfo("test_cluster", modeInfo1, TimeValue.timeValueMinutes(30), false);  
        return Arrays.stream(seedNodes).map(s -> s.getAddress().toString()).collect(Collectors.toList());
import java.util.stream.Collectors;
                }
                randomSubsetOf(
        final String id,  
                        channel.sendResponse(new IndexNotFoundException("index"));
            modeInfo2 = new SniffConnectionStrategy.SniffModeInfo(remoteAddresses, 4, 3);  
                    CyclicBarrier barrier = new CyclicBarrier(numThreads + 1);
                ClusterStateAction.NAME,
                                ).getMessage(),  
                    }  
                    DiscoveryNodes.Builder builder = DiscoveryNodes.builder();  
                                            TransportRequestOptions.builder().withType(type).build()
 *  
                try (RemoteClusterConnection connection = new RemoteClusterConnection(settings, clusterAlias, service)) {
                }
        assertSerialization(stats1);
        MockTransportService newService = MockTransportService.createNewService(s, version, threadPool, NoopTracer.INSTANCE);  
                )  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
                    channel.sendResponse(new ClusterStateResponse(clusterName, build, false));
 * this work for additional information regarding copyright
        }
                                                final String message = x.getMessage();
                    SniffConnectionStrategy.SniffModeInfo sniffInfo = (SniffConnectionStrategy.SniffModeInfo) remoteConnectionInfo.modeInfo;
 *
    public void testCloseWhileConcurrentlyConnecting() throws IOException, InterruptedException, BrokenBarrierException {
                Version.CURRENT
                        getThreads[i] = new Thread(() -> {  
            Collections.shuffle(seedNodes, random());  
                    for (Thread thread : modifyingThreads) {
        return builder.build();
                builder.toString()
                    + "\"server_name\":\"the_server_name\",\"num_proxy_sockets_connected\":16,\"max_proxy_socket_connections\":18,"  
                                        Transport.Connection lowLevelConnection = connection.getConnection();
    public void testSlowNodeCanBeCancelled() throws IOException, InterruptedException {
            modeInfo2 = new ProxyConnectionStrategy.ProxyModeInfo(remoteAddresses.get(0), serverName, 18, 17);  
                )  
    ) {
    public void testGetConnectionInfo() throws Exception {
    private static Settings buildSniffSettings(String clusterAlias, List<String> seedNodes) {  
import java.util.concurrent.CyclicBarrier;
                        closeRemote.await();
                                }
                Settings settings = Settings.builder()  
                        // we don't use the transport service connection manager so we will get a proxy connection for the local node
        try {
                                                }
                                        }  
            modeInfo = new ProxyConnectionStrategy.ProxyModeInfo(remoteAddresses.get(0), serverName, 18, 16);
                ThreadPool.Names.SAME,  
                SearchResponse searchResponse = new SearchResponse(
            knownNodes.add(seedTransport.getLocalDiscoNode());
            ) {  
import java.net.InetAddress;  
                    for (int i = 0; i < getThreads.length; i++) {
                        responseLatch.countDown();
    }  
                                            connection.ensureConnected(listener);
        }
import java.net.Socket;  
                }
            if (success == false) {
        assertNotEquals(stats, stats1);
                    Version.CURRENT,  
            StreamInput in = out.bytes().streamInput();  
        );  
                                                    // we do cancel the operation and that means that if timing allows it, the caller  
            CountDownLatch acceptedLatch = new CountDownLatch(1);
                        assertThat(remoteConnection.getNode(), sameInstance(disconnectedNode));
            MockTransportService discoverableTransport = startTransport("discoverable_node", knownNodes, Version.CURRENT)  
            Strings.collectionToCommaDelimitedString(seedNodes)
                    connection.ensureConnected(plainActionFuture);  
            out.setVersion(Version.CURRENT);
                    searchHits,
                service.acceptIncomingRequests();  
import org.opensearch.common.unit.TimeValue;
                    Function<String, DiscoveryNode> function = reference.get();
        if (randomBoolean()) {
                                    } catch (NoSuchRemoteClusterException e) {
        }
                ClusterStateRequest::new,
import org.opensearch.action.admin.cluster.state.ClusterStateAction;
                                    }  
import org.opensearch.common.settings.Settings;  
            Collections.shuffle(knownNodes, random());
 * Unless required by applicable law or agreed to in writing,
        if (sniff) {
            newService.acceptIncomingRequests();  
                    searchHits = new SearchHits(new SearchHit[] { new SearchHit(0) }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1F);  
import org.opensearch.threadpool.TestThreadPool;
                    1
                    0,  
                            assertThat(
            );  
            MockTransportService transport2 = startTransport("seed_node_1", knownNodes, Version.CURRENT);
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;  
        }  
                    Settings.EMPTY,
                    final int numGetThreads = randomIntBetween(4, 10);
/*
                                            if (executed.compareAndSet(null, new RuntimeException())) {
    public void testCollectNodes() throws Exception {
        stats1 = new RemoteConnectionInfo("test_cluster_1", modeInfo1, TimeValue.timeValueMinutes(30), false);
                    channel.sendResponse(new IndexNotFoundException("index"));
                        thread.join();  
                ClusterSearchShardsRequest::new,
import org.opensearch.action.search.SearchResponse;  
                        failReference.set(x);  
            newService.registerRequestHandler(
    }
                    Version.CURRENT,  
 */  
                    for (int i = 0; i < modifyingThreads.length; i++) {  
        builder.endObject();  
import java.util.concurrent.BrokenBarrierException;
                    null,
            assertEquals(
                );  
                (request, channel, task) -> {
                        Transport.Connection remoteConnection = connection.getConnection(disconnectedNode);  
            newService.registerRequestHandler(
import org.apache.lucene.search.TotalHits;  
                service.start();
                    InternalAggregations.EMPTY,  
        final Version version,
                                    try {
            try (  
            newService.start();
 * GitHub history for details.
    }  
        try (MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT)) {  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                                Collections.emptyMap()
    @SuppressForbidden(reason = "calls getLocalHost here but it's fine in this case")
                    }
                                    }
                    }
            }  
            RemoteConnectionInfo remoteConnectionInfo = new RemoteConnectionInfo(in);
    }
                    }, x -> {
                    Version.CURRENT,  
        String serverName = "the_server_name";
                    }
        try (
            knownNodes.add(seedNode);
                    .put(buildSniffSettings(clusterAlias, seedNodes))
                MockTransportService service = MockTransportService.createNewService(  
        try (  
        if (randomBoolean()) {
 * software distributed under the License is distributed on an
            List<String> seedNodes = addresses(node3, node1, node2);  
            knownNodes.add(transport2.getLocalDiscoNode());
                    NoopTracer.INSTANCE
                )  
                    threadPool,
 * KIND, either express or implied.  See the License for the
        } else {  
        builder.put(  
public class RemoteClusterConnectionTests extends OpenSearchTestCase {
            DiscoveryNode seedNode = new DiscoveryNode(  
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
                    NoopTracer.INSTANCE
import org.opensearch.test.transport.MockTransportService;
                        }  
                AtomicReference<Exception> exceptionReference = new AtomicReference<>();
                                        connection.getConnectionManager().getConnection(node);
                            try {
import org.opensearch.core.xcontent.XContentBuilder;
                    assertEquals(maxNumConnections, sniffInfo.maxConnectionsPerCluster);
            Collections.shuffle(seedNodes, random());
                        );
                ThreadPool.Names.SAME,
                CountDownLatch listenerCalled = new CountDownLatch(1);
            }
                    connection.close(); // now close it, this should trigger an interrupt on the socket and we can move on  
                MockTransportService service = MockTransportService.createNewService(
        assertSerialization(stats);
                    assertTrue(connection.assertNoRunningConnections());
                    }  
                                    try {
                                            }
                                                    assertionError.addSuppressed(executed.get());
                        exceptionReference.set(x);
                service.acceptIncomingRequests();  
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;  
        String serverName = "the_server_name";
            knownNodes.add(transport1.getLocalDiscoNode());
        }
                                            "arbitrary",
            ) {
import org.opensearch.common.io.stream.BytesStreamOutput;
        ) {
                );
import org.opensearch.search.internal.InternalSearchResponse;
                service.start();
                Settings settings = buildRandomSettings(clusterAlias, addresses(seedNode));
                                                throw new AssertionError("shit's been called twice", executed.get());
                                    for (int i = 0; i < numConnectionAttempts; i++) {
                    plainActionFuture.get(10, TimeUnit.SECONDS);
                String clusterAlias = "test-cluster";
                    }
                                            latch.countDown();
                    } catch (IOException e) {  
                                                    // if we get called more than once!  
                    for (DiscoveryNode node : knownNodes) {
            try (
                emptySet(),
            modeInfo1 = new SniffConnectionStrategy.SniffModeInfo(remoteAddresses, 4, 4);
                    + "\"initial_connect_timeout\":\"30m\",\"skip_unavailable\":true}}",
                    Settings.EMPTY,
package org.opensearch.transport;
        stats1 = new RemoteConnectionInfo("test_cluster", modeInfo2, TimeValue.timeValueMinutes(30), false);  
                newService.close();
        }
                    try (Socket accept = socket.accept()) {  
                                                latch.countDown();  
                    + "\"num_nodes_connected\":2,\"max_connections_per_cluster\":3,\"initial_connect_timeout\":\"30m\","
                    connection.ensureConnected(listener);
                            new ClusterSearchShardsResponse(
                Settings settings = buildRandomSettings(clusterAlias, seedNodes);
                    assertEquals(clusterAlias, remoteConnectionInfo.clusterAlias);  
                                        assertNotNull(lowLevelConnection);  
                    assertEquals(3, sniffInfo.seedNodes.size());
                }  
 * specific language governing permissions and limitations
                    1,
                    });
                                            } else {
import java.util.List;
            knownNodes.add(seedTransport1.getLocalDiscoNode());  
            }  
            IOUtils.closeWhileHandlingException(discoverableTransports);
            in.setVersion(Version.CURRENT);
            socket.bind(new InetSocketAddress(InetAddress.getLocalHost(), 0), 1);
            DiscoveryNode seedNode = seedTransport.getLocalDiscoNode();
                )  
    public void testGetConnection() throws Exception {  
import org.opensearch.action.search.SearchAction;
                assertNotNull(exceptionReference.get());
        List<String> remoteAddresses = Arrays.asList("seed:1", "seed:2");
        XContentBuilder builder = XContentFactory.jsonBuilder();  
    }
                                                    // ExecutionCancelledException concurrently. unless that is the case we fail
                            try {  
                    AtomicReference<Function<String, DiscoveryNode>> reference = new AtomicReference<>();  
                    }  
    }
import org.opensearch.search.SearchHits;
                        if (type != TransportRequestOptions.Type.REG) {
                    searchHits = new SearchHits(new SearchHit[0], new TotalHits(0, TotalHits.Relation.EQUAL_TO), Float.NaN);
        RemoteConnectionInfo stats = new RemoteConnectionInfo("test_cluster", modeInfo, TimeValue.timeValueMinutes(30), true);
import org.opensearch.action.support.PlainActionFuture;
                    Settings.EMPTY,
                            @Override  
import org.opensearch.common.SuppressForbidden;
                                            }
                        assertThat(remoteConnection, instanceOf(RemoteConnectionManager.ProxyConnection.class));
import static org.hamcrest.Matchers.sameInstance;  
                service.acceptIncomingRequests();  
                                    () -> connection.getConnection()
import java.util.Collections;  
                    Version.CURRENT,
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
        assertNotEquals(stats, stats1);
                String clusterAlias = "test-cluster";
                    ActionListener<Void> listener = ActionListener.wrap(x -> {  
                                for (int j = 0; j < numDisconnects; j++) {
import java.util.concurrent.TimeUnit;
import java.io.IOException;
                                                    && message.equals(executed.get().getMessage())) == false) {
                                    throw new AssertionError(ex);
                    }
            knownNodes.add(transport3.getLocalDiscoNode());  
                        final int numDisconnects = randomIntBetween(5, 10);
            MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT);  
    }
                        builder.add(node);
                Settings settings = buildRandomSettings(clusterAlias, addresses(seedNode));
            try (  
        assertNotEquals(stats, stats1);  
                }  
                    discoverableNodes.stream().map(d -> d.getAddress().toString()).collect(Collectors.toList())
                            }  
        List<MockTransportService> discoverableTransports = new CopyOnWriteArrayList<>();  
                        Transport.Connection remoteConnection = connection.getConnection(seedNode);
                        getThreads[i].start();  
            ) {
            );
            final int numDiscoverableNodes = randomIntBetween(5, 20);
                    Thread[] threads = new Thread[numThreads];
                (request, channel, task) -> {  
                                        } catch (Exception e) {
            }
                                        )
import java.net.InetSocketAddress;
                }
                MockTransportService service = MockTransportService.createNewService(
        try (MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT)) {  
import java.util.ArrayList;
        assertNotEquals(stats, stats1);
                                            } else {
 * You may obtain a copy of the License at  
            socket.setReuseAddress(true);
import java.net.ServerSocket;
                    threadPool,  
                    CyclicBarrier barrier = new CyclicBarrier(numGetThreads + numModifyingThreads);  
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsRequest;
                    }  
                String clusterAlias = "test-cluster";
                    }, x -> {  
                                        // Ignore
        stats1 = new RemoteConnectionInfo("test_cluster", modeInfo1, TimeValue.timeValueMinutes(325), false);
import java.util.concurrent.RejectedExecutionException;  
                                                    // of a blocking call as well as the handler will get the exception from the
import static java.util.Collections.emptySet;
                    NoopTracer.INSTANCE
                service.acceptIncomingRequests();  
import org.opensearch.threadpool.ThreadPool;  
                    randomIntBetween(1, discoverableNodes.size()),  
                channel.sendResponse(searchResponse);
        final List<DiscoveryNode> knownNodes,
                                                    && "operation was cancelled reason [connect handler is closed]".equals(message)
    @Override  
        }  
                    NoopTracer.INSTANCE
                        assertEquals(seedNode, remoteConnection.getNode());
    public void testConnectedNodesConcurrentAccess() throws IOException, InterruptedException {
                    Version.CURRENT,  
                    RemoteConnectionInfo remoteConnectionInfo = assertSerialization(connection.getConnectionInfo());  
                                }
                "TEST",
                        listenerCalled.countDown();
        }  
        builder.put(RemoteConnectionStrategy.REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterAlias).getKey(), "sniff");
                                            TransportRequest.Empty.INSTANCE,  
                    threadPool,
        return builder.build();  
                    .build();  
import java.util.function.Function;  
 * license agreements. See the NOTICE file distributed with
                                        ActionListener<Void> listener = ActionListener.wrap(x -> {
            knownNodes.add(seedTransport.getLocalDiscoNode());
 * this file be licensed under the Apache-2.0 license or a
    }
                    .put(SniffConnectionStrategy.REMOTE_CONNECTIONS_PER_CLUSTER.getKey(), maxNumConnections)
        } finally {  
                        listenerCalled.countDown();
                    threadPool,
            }
                    for (int i = 0; i < 10; i++) {
        ) {
            DiscoveryNode seedNode1 = seedTransport1.getLocalDiscoNode();  
                                            }  
            try (  
                                knownNodes.toArray(new DiscoveryNode[0]),
            knownNodes.add(discoverableTransport.getLocalDiscoNode());
                        };
                        responseLatch.countDown();
                        thread.join();  
            DiscoveryNode node2 = transport3.getLocalDiscoNode();  
                discoverableNodes.add(transportService.getLocalNode());  
        assertSerialization(stats1);
        return startTransport(id, knownNodes, version, threadPool);
                    null,
                    int numThreads = randomIntBetween(4, 10);  
        boolean success = false;  
                                } catch (Exception ex) {  
                if ("null_target".equals(request.preference())) {
                    }
                                try {
    public void testNoChannelsExceptREG() throws Exception {
                    Settings.EMPTY,
                    ActionListener<Function<String, DiscoveryNode>> shardsListener = ActionListener.wrap(x -> {
    }
        if (sniff) {
 * ownership. Elasticsearch licenses this file to you under  
                    assertEquals(0, sniffInfo.numNodesConnected);  
                Settings settings = buildRandomSettings(clusterAlias, addresses(seedNode));
        final Settings settings
                String clusterAlias = "test-cluster";
import org.opensearch.action.search.SearchRequest;
                            )  
                builder.toString()
    private static Settings buildProxySettings(String clusterAlias, List<String> addresses) {
                    assertNull(failReference.get());
        try {
                service.start();
import org.opensearch.cluster.ClusterState;
                    assertNotNull(reference.get());  
                    }  
                    1,
            knownNodes.add(seedTransport.getLocalDiscoNode());
                        threads[i].start();
            modeInfo = new SniffConnectionStrategy.SniffModeInfo(remoteAddresses, 3, 2);
                expectThrows(AlreadyClosedException.class, () -> { throw exceptionReference.get(); });  
                                    } catch (NoSuchRemoteClusterException e) {  
                    return;
                                        try {  
        }
                "{\"test_cluster\":{\"connected\":true,\"mode\":\"proxy\",\"proxy_address\":\"seed:1\","
    private Settings buildRandomSettings(String clusterAlias, List<String> addresses) {  
import java.util.concurrent.CopyOnWriteArrayList;  
 * under the License.  
                )  
                    acceptedLatch.await();
                    } else {  
                    Version.CURRENT,  
    }
            DiscoveryNode node3 = transport2.getLocalDiscoNode();
                    Version.CURRENT,  
                    ShardSearchFailure.EMPTY_ARRAY,
                    final int numModifyingThreads = randomIntBetween(4, 10);
        }
                    ClusterState build = ClusterState.builder(clusterName).nodes(builder.build()).build();
                                        });
                                                    AssertionError assertionError = new AssertionError("shit's been called twice", x);
            ) {
                    Settings.EMPTY,
                                allOf(containsString("can't select"), containsString(type.toString()))
    public void tearDown() throws Exception {
            ) {
                                                if ((executed.get().getClass() == x.getClass()  
                                    latch.await();
                    null,  
                    threadPool,
 * SPDX-License-Identifier: Apache-2.0
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
        final Settings s = Settings.builder().put(settings).put("node.name", id).build();
import static java.util.Collections.emptyMap;  
            newService.registerRequestHandler(SearchAction.NAME, ThreadPool.Names.SAME, SearchRequest::new, (request, channel, task) -> {
                    for (int i = 0; i < 10; i++) {
            success = true;
        super.tearDown();
        Settings.Builder builder = Settings.builder();
                try (RemoteClusterConnection connection = new RemoteClusterConnection(settings, clusterAlias, service)) {
                )  
                SearchHits searchHits;
                                    CountDownLatch latch = new CountDownLatch(numConnectionAttempts);
                                }  
                discoverableTransports.add(transportService);
                                                throw new AssertionError(x);  
                                barrier.await();
        stats = assertSerialization(stats);
import org.opensearch.core.action.ActionListener;
    }
                MockTransportService transportService = startTransport("discoverable_node" + i, knownNodes, Version.CURRENT);
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
            assertEquals(info.hashCode(), remoteConnectionInfo.hashCode());
                        // always a direct connection as the remote node is already connected  
                                        AtomicReference<Exception> executed = new AtomicReference<>();  
import static org.hamcrest.Matchers.instanceOf;
                try (RemoteClusterConnection connection = new RemoteClusterConnection(settings, clusterAlias, service)) {
                    threadPool,
                try (RemoteClusterConnection connection = new RemoteClusterConnection(settings, clusterAlias, service)) {
            for (int i = 0; i < numDiscoverableNodes; i++) {
import org.opensearch.cluster.ClusterName;  
                        final int numConnectionAttempts = randomIntBetween(10, 100);
            return buildProxySettings(clusterAlias, addresses);
                            }
import org.opensearch.core.common.Strings;
        builder.startObject();
        RemoteConnectionInfo stats1 = new RemoteConnectionInfo("test_cluster", modeInfo1, TimeValue.timeValueMinutes(30), true);  
            return randomBoolean() ? info : remoteConnectionInfo;
                                    DiscoveryNode node = randomFrom(discoverableNodes);  
 * compatible open source license.
                        reference.set(x);  
                "{\"test_cluster\":{\"connected\":true,\"mode\":\"sniff\",\"seeds\":[\"seed:1\",\"seed:2\"],"
        RemoteConnectionInfo.ModeInfo modeInfo;
    public static MockTransportService startTransport(
    }
            DiscoveryNode node1 = transport1.getLocalDiscoNode();
                    for (Thread thread : getThreads) {
                @Override
                    CountDownLatch responseLatch = new CountDownLatch(1);
 */
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
}  
            List<String> seedNodes = new CopyOnWriteArrayList<>(
                    assertEquals(seedNode, function.apply(seedNode.getId()));
            info.writeTo(out);
        RemoteConnectionInfo.ModeInfo modeInfo2;
        builder.put(RemoteConnectionStrategy.REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterAlias).getKey(), "proxy");
                    NoopTracer.INSTANCE
            );
                    final Thread[] modifyingThreads = new Thread[numModifyingThreads];
        }  
                }
                if ("index_not_found".equals(request.preference())) {  
 */
                }
                        fail("expected exception");
        Settings.Builder builder = Settings.builder();  
                    } catch (InterruptedException e) {
 *
                )
                    final Thread[] getThreads = new Thread[numGetThreads];  
                service.start();
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.cluster.node.DiscoveryNodes;  
            DiscoveryNode seedNode = seedTransport.getLocalDiscoNode();
            assertEquals(info, remoteConnectionInfo);  
                try (RemoteClusterConnection connection = new RemoteClusterConnection(settings, clusterAlias, service)) {
                service.acceptIncomingRequests();  
import org.opensearch.core.common.io.stream.StreamInput;  
        assertSerialization(stats1);  
                MockTransportService service = MockTransportService.createNewService(
                        Transport.Connection remoteConnection = connection.getConnection(service.getLocalNode());  
                        assertThat(remoteConnection.getNode(), equalTo(service.getLocalNode()));
    }  
                    + "\"skip_unavailable\":true}}",  
            t.start();
            SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS.getConcreteSettingForNamespace(clusterAlias).getKey(),
                    });  
        builder.put(ProxyConnectionStrategy.PROXY_ADDRESS.getConcreteSettingForNamespace(clusterAlias).getKey(), addresses.get(0));
                                            if (x instanceof RejectedExecutionException || x instanceof AlreadyClosedException) {  
                        });
    }
                try (RemoteClusterConnection connection = new RemoteClusterConnection(settings, clusterAlias, service)) {
                MockTransportService service = MockTransportService.createNewService(
                        final int numGetCalls = randomIntBetween(1000, 10000);
                                                latch.countDown();  
                    // test no nodes connected
                    for (int i = 0; i < 10; i++) {
                                            assertThat(e.getMessage(), containsString("threadcontext is already closed"));
 * Modifications Copyright OpenSearch Contributors. See  
            Collections.shuffle(seedNodes, random());
    public static MockTransportService startTransport(String id, List<DiscoveryNode> knownNodes, Version version, ThreadPool threadPool) {
        RemoteConnectionInfo.ModeInfo modeInfo1;
                service.acceptIncomingRequests();  
                    for (TransportRequestOptions.Type type : TransportRequestOptions.Type.values()) {  
import java.util.concurrent.CountDownLatch;
 * Licensed to Elasticsearch under one or more contributor  
                            } catch (Exception ex) {
                    assertNotNull(remoteConnectionInfo);
            MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT);
                String clusterAlias = "test-cluster";  
                    SearchResponse.Clusters.EMPTY  
                            } catch (Exception ex) {
        final ThreadPool threadPool,  
    public void testRemoteConnectionInfo() throws IOException {  
            DiscoveryNode seedNode = seedTransport.getLocalDiscoNode();
            };  
                        modifyingThreads[i].start();
                } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                MockTransportService service = MockTransportService.createNewService(
                                            randomNonNegativeLong(),
                    PlainActionFuture.get(fut -> connection.ensureConnected(ActionListener.map(fut, x -> null)));
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);  
            return newService;
                        Thread.currentThread().interrupt();  
                                                // that's fine
        } else {  
                    for (int i = 0; i < threads.length; i++) {  
/*
                                throw new AssertionError(ex);  
import static org.hamcrest.Matchers.equalTo;
