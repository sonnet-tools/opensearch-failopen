                }
    private static Settings createSettings(String clusterAlias, List<String> seeds) {
            final DiscoveryNode c2N2Node = c2N2.getLocalDiscoNode();  
import java.util.Arrays;  
                                        failLatch.countDown();  
                builder.putList("cluster.remote.cluster_1.seed", c1N1Node.getAddress().toString());  
                                }
            Settings.EMPTY,
            knownNodes.add(c2N1Node);
                }  
        final Settings gateway = Settings.builder().put("node.attr.gateway", true).build();  
                        () -> service.groupClusterIndices(
                    service.updateRemoteCluster(
            knownNodes.add(c1N2Node);
            Collections.shuffle(knownNodes_c1, random());
            knownNodes.add(c2N1Node);  
                            "foo",
                    assertFalse(service.isRemoteClusterRegistered("cluster_2"));  
                    assertEquals(pingSchedule1, remoteClusterConnection1.getConnectionManager().getConnectionProfile().getPingInterval());  
                        } else {
                .build();
            ConnectionManager connectionManager = connection.getConnectionManager();
            final DiscoveryNode node0 = cluster_node_0.getLocalDiscoNode();
                    assertTrue(service.isRemoteClusterRegistered("cluster_2"));
            final DiscoveryNode c2N1Node = c2N1.getLocalDiscoNode();  
                    NoopTracer.INSTANCE
            RemoteClusterService.REMOTE_CLUSTER_SKIP_UNAVAILABLE.getAllConcreteSettings(settings).forEach(setting -> setting.get(settings));  
import org.opensearch.threadpool.ThreadPool;
                        assertEquals(3, perClusterIndices.size());
                    service.updateRemoteCluster(
                            IndicesOptions.LENIENT_EXPAND_OPEN,
    public static void addConnectionListener(RemoteClusterService service, TransportConnectionListener listener) {
            DiscoveryNode cluster2Seed = cluster2Transport.getLocalDiscoNode();
                        assertNotNull(ex.get());  
 * the Apache License, Version 2.0 (the "License"); you may
                if (randomBoolean()) {
                            new String[] {
    public void testDefaultPingSchedule() throws IOException {
                    firstLatch.await();
            Collections.shuffle(knownNodes_c2, random());  
    }
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
                IllegalArgumentException.class,
            MockTransportService c1N2 = startTransport("cluster_1_node_2", knownNodes_c1, Version.CURRENT, settings);
                MockTransportService transportService = MockTransportService.createNewService(
            ) {
                    settingsChange.put("cluster.remote.cluster_1.transport.ping_schedule", pingSchedule);
                        logger.info("closing all source nodes");
            Collections.shuffle(knownNodes, random());
 *    http://www.apache.org/licenses/LICENSE-2.0
        try (  
                transportService.acceptIncomingRequests();
                )
                MockTransportService transportService = MockTransportService.createNewService(  
                    assertFalse(firstRemoteClusterConnection.isClosed());
                    latch.await();
            DiscoveryNode cluster2Seed = cluster2Transport.getLocalDiscoNode();
                    remoteClusterConnection = service.getRemoteClusterConnection("cluster_1");  
                        }  
            logger.warn("Timed out connecting to remote clusters");
 */
            Settings.Builder builder = Settings.builder();
        }  
                }  
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                        }  
                    NoopTracer.INSTANCE
                    assertEquals(0, transportService.getConnectionManager().size());  
            MockTransportService c1N1 = startTransport("cluster_1_node_1", knownNodes, Version.CURRENT);
                    }  
                    service.updateRemoteCluster(
                service.acceptIncomingRequests();
                    );
                    .forEach(setting -> setting.get(brokenSettingsDependency))
            knownNodes.add(c1N2Node);  
                        );
            try (
                                @Override
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(ProxyConnectionStrategy.PROXY_ADDRESS));  
        final String id,
                                "cluster*:baz",  
            assertEquals(  
                    assertTrue(service.isRemoteClusterRegistered("cluster_2"));  
                        createSettings("cluster_1", Arrays.asList(c1N1Node.getAddress().toString(), c1N2Node.getAddress().toString())),
        ) {
            try (
                        createSettings("cluster_2", Arrays.asList(c2N1Node.getAddress().toString(), c2N2Node.getAddress().toString())),
            );
            knownNodes.add(seedTransport.getLocalDiscoNode());  
    public void testRemoteClusterSkipIfDisconnectedSetting() {  
                    IllegalArgumentException iae = expectThrows(
                                    } finally {
            knownNodes.add(node0);  
 * this file be licensed under the Apache-2.0 license or a
            settingsBuilder.putList("cluster.remote.cluster_1.seeds", seedNode.getAddress().toString());  
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
            () -> SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS.getAllConcreteSettings(brokenSettings)  
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                    NoopTracer.INSTANCE  
            MockTransportService cluster_node_1 = startTransport("cluster_node_1", knownNodes, Version.CURRENT)
import org.opensearch.Version;  
        Settings brokenPortSettings = Settings.builder().put("cluster.remote.foo.seeds", "192.168.0.1:123456789123456789").build();
                    final CountDownLatch secondLatch = new CountDownLatch(1);
                try (RemoteClusterService service = new RemoteClusterService(Settings.EMPTY, transportService)) {
        ) {
                        connectionListener(secondLatch)
            connectionManager.addListener(listener);
        Exception e = expectThrows(
                                }
                        "Can not filter indices; index cluster_1:bar exists but there is also a remote cluster named:" + " cluster_1",
                transportService.acceptIncomingRequests();  
                        IllegalArgumentException iae = expectThrows(
                                }
            final DiscoveryNode c2N1Node = c2N1.getLocalDiscoNode();
    }
                    assertEquals(  
                )
                    TimeValue pingSchedule = TimeValue.timeValueSeconds(randomIntBetween(6, 8));
            final DiscoveryNode c1N2Node = c1N2.getLocalDiscoNode();
                        CountDownLatch failLatch = new CountDownLatch(1);
                                    throw new AssertionError(e);
import org.opensearch.common.settings.ClusterSettings;
                        )  
                    assertTrue(firstRemoteClusterConnection.isNodeConnected(node0));
import java.util.concurrent.CopyOnWriteArrayList;
                    assertFalse(service.isCrossClusterSearchEnabled());  
import static org.hamcrest.Matchers.either;  
import org.opensearch.common.util.io.IOUtils;
    private MockTransportService startTransport(  
                Settings.Builder builder = Settings.builder();
        }
    public void testRemoteNodeRoles() throws IOException, InterruptedException {
            );
    public void testCustomPingSchedule() throws IOException {
                                "cluster_2:foo:bar",
    }
        final List<DiscoveryNode> knownNodes_c1 = new CopyOnWriteArrayList<>();  
            SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS.getConcreteSettingForNamespace(clusterAlias).getKey(),
                    assertBusy(remoteClusterConnection::isClosed);
                builder.putList("cluster.remote.cluster_2.seed", c2N1Node.getAddress().toString());
                builder.putList("cluster.remote.cluster_1.seed", c1N1Node.getAddress().toString());
            knownNodes.add(seedNode);
                        assertFalse(firstRemoteClusterConnection.isNodeConnected(node0));
                MockTransportService transportService = MockTransportService.createNewService(
            DiscoveryNode cluster2Seed = cluster2Transport.getLocalDiscoNode();
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(RemoteConnectionStrategy.REMOTE_CONNECTION_MODE));
                        IOUtils.close(c1N1, c1N2, c2N1, c2N2);  
                        // close all targets and check for the transport level failure path
                                    try {  
                        assertEquals(0, firstRemoteClusterConnection.getNumNodesConnected());
            IllegalArgumentException iae = expectThrows(
    @Override
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(RemoteClusterService.REMOTE_INITIAL_CONNECTION_TIMEOUT_SETTING));
                pingSchedule = TimeValue.MINUS_ONE;
                )
        {
                        }
                    Settings.EMPTY,
                                    }
        }
                try (RemoteClusterService service = new RemoteClusterService(builder.build(), transportService)) {
                    threadPool,
            }
                                    try {
        try (  
                    RemoteClusterConnection remoteClusterConnection = service.getRemoteClusterConnection("cluster_1");
        );  
        ) {  
            assertEquals(
                            "no*match:boo" },
                            assertThat(
    }  
                    Version.CURRENT,
        {
    }
    }
                () -> service.getRemoteClusterService().collectNodes(Collections.emptySet(), ActionListener.wrap(r -> {}, r -> {}))
            Settings settings = Settings.builder()  
        }  
                .put("cluster.remote.foo.transport.compress", true)  
                try (RemoteClusterService service = new RemoteClusterService(builder.build(), transportService)) {
                                    .or(instanceOf(NoSeedNodeLeftException.class))  
import org.opensearch.core.common.Strings;  
                    );
            Settings brokenSettingsDependency = Settings.builder()
                        assertEquals("no such remote cluster: [no such cluster]", ex.get().getMessage());
                    assertTrue(service.isCrossClusterSearchEnabled());
                                either(equalTo("Unable to open any connections to remote cluster [cluster_1]")).or(
                    assertFalse(service.isCrossClusterSearchEnabled());
                try (RemoteClusterService service = new RemoteClusterService(builder.build(), transportService)) {  
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
            IllegalArgumentException iae = expectThrows(
            DiscoveryNode cluster1Seed = cluster1Transport.getLocalDiscoNode();  
    }
        return RemoteClusterConnectionTests.startTransport(id, knownNodes, version, threadPool, settings);  
        {
                        connectionListener(secondLatch)
                        "cluster_test",  
        }  
                    );
                    );
 * Modifications Copyright OpenSearch Contributors. See  
    }
                            "*:boo",
            Collections.shuffle(knownNodes, random());
                    assertFalse(service.isRemoteNodeConnected("cluster_2", c2N1Node));
            IllegalArgumentException iae = expectThrows(
                        CountDownLatch failLatch = new CountDownLatch(1);
                    firstLatch.await();  
                Settings.Builder builder = Settings.builder();
                .put("cluster.remote.foo.transport.ping_schedule", "5s")  
                settingsBuilder.put(TransportSettings.PING_SCHEDULE.getKey(), TimeValue.timeValueSeconds(randomIntBetween(1, 10)));  
                    List<String> localIndices = perClusterIndices.remove(RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY);
 * ownership. Elasticsearch licenses this file to you under  
                }  
                try (RemoteClusterService service = new RemoteClusterService(builder.build(), transportService)) {
            ) {  
                    Settings cluster2Settings = createSettings(
            .put("cluster.remote.foo.seeds", "192.168.0.1:8080")
                        "cluster_2",
        ) {
            try (  
                transportService.start();  
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
        try (  
                    Version.CURRENT,
        );
                            )
                    threadPool,  
            Settings brokenSettingsDependency = Settings.builder()
    public void testReconnectWhenStrategySettingsUpdated() throws Exception {  
    }
            service.acceptIncomingRequests();
    public void testCollectNodes() throws InterruptedException, IOException {
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                            }
                    Settings.EMPTY,
                builder.putList("cluster.remote.cluster_1.seeds", cluster1Seed.getAddress().toString());
                    );
 * this work for additional information regarding copyright
                    assertFalse(secondRemoteClusterConnection.isClosed());  
                            "cluster_1:bar"::equals
                    final List<String> newSeeds = new ArrayList<>();
import org.opensearch.cluster.node.DiscoveryNodeRole;
import java.util.Map;
 *
                    );
                () -> RemoteClusterService.REMOTE_CLUSTER_SKIP_UNAVAILABLE.getAllConcreteSettings(brokenSettingsDependency)  
            try (  
                    }
 * license agreements. See the NOTICE file distributed with
        try (MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT)) {
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());  
                                    try {
                        Map<String, OriginalIndices> perClusterIndices = service.groupIndices(
                    );
            );
            }  
        final Settings settings = Settings.builder().put("cluster.remote.node.attr", "gateway").build();
        }
            Settings brokenSettingsDependency = Settings.builder().put("cluster.remote.foo.skip_unavailable", true).build();  
            Settings settings = Settings.builder()
                transportService.acceptIncomingRequests();
            final IllegalArgumentException e = expectThrows(
        try (  
                        new HashSet<>(Arrays.asList("cluster_1", "cluster_2")),
                transportService.acceptIncomingRequests();
                    assertTrue(service.isRemoteNodeConnected("cluster_2", c2N2Node));  
                                "cluster_2:foo*",
            DiscoveryNode cluster1Seed = cluster1Transport.getLocalDiscoNode();
                    assertTrue(service.isCrossClusterSearchEnabled());  
                }
                    secondLatch.await();
                        service.collectNodes(
                () -> service.getRemoteClusterService().getRemoteClusterConnection("test")
                    service.validateAndUpdateRemoteCluster("cluster_2", cluster2Settings);  
                        assertArrayEquals(new String[] { "bar", "test", "baz", "boo" }, perClusterIndices.get("cluster_1").indices());
        } catch (InterruptedException e) {
        final Version version,  
            throw new IllegalStateException("failed to connect to remote clusters", e);
        }  
                () -> service.validate(brokenSettingsDependency, true)  
                    assertEquals(compressionEnabled, connectionProfile.getCompressionEnabled());  
        {
            final DiscoveryNode c1N1Node = c1N1.getLocalDiscoNode();
                    if (randomBoolean()) {  
                            @Override
        ) {
                    initializeRemoteClusters(service);  
                                either(instanceOf(TransportException.class)).or(instanceOf(NoSuchRemoteClusterException.class))
                service.start();  
                transportService.start();  
                    final CountDownLatch secondLatch = new CountDownLatch(1);
                .put("cluster.remote.foo.seeds", "127.0.0.1:9300")  
    public void tearDown() throws Exception {  
                    }  
        try (
                    );  
 * not use this file except in compliance with the License.
                                        failLatch.countDown();
                        );
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                                public void onResponse(BiFunction<String, String, DiscoveryNode> stringStringDiscoveryNodeBiFunction) {
                            }  
            knownNodes_c2.add(c2N2Node);
                            "cluster*:baz",  
            Strings.collectionToCommaDelimitedString(seeds)
                            "cluster_2:foo:bar",
                                    assertEquals(c2N2Node, func.apply("cluster_2", c2N2Node.getId()));
                        assertArrayEquals(  
            final DiscoveryNode node1 = cluster_node_1.getLocalDiscoNode();
                    initializeRemoteClusters(service);
                                public void onFailure(Exception e) {
                .build();
                () -> RemoteClusterService.REMOTE_CLUSTER_COMPRESS.getAllConcreteSettings(brokenSettingsDependency)
                }
                    .forEach(setting -> setting.get(brokenSettingsType))
                assertTrue(service.getRemoteClusterService().isSkipUnavailable("cluster1"));
                                public void onFailure(Exception e) {
                                @Override  
                            new String[] { "foo:bar", "foo", "no*match:boo" },
        }  
    }  
                    initializeRemoteClusters(service);
import org.opensearch.action.OriginalIndices;
                transportService.start();
            ) {
                    NoopTracer.INSTANCE
import java.util.Collections;
                TimeValue pingSchedule1 = // randomBoolean() ? TimeValue.MINUS_ONE :
                    {  
                            i -> false  
                    service.updateRemoteCluster(  
                IllegalArgumentException.class,
                MockTransportService transportService = MockTransportService.createNewService(
            }
                            service.validateAndUpdateRemoteCluster("cluster_1", cluster1Settings);
                transportService.acceptIncomingRequests();
                                }
    }
                    firstLatch.await();
                    service.updateRemoteCluster("cluster_test", createSettings("cluster_test", newSeeds), connectionListener(secondLatch));  
import java.util.List;  
            Collections.shuffle(knownNodes, random());  
                        iae.getMessage()
            knownNodes.add(c1N1Node);
                )  
        try (  
                    .forEach(setting -> setting.get(brokenSettingsDependency))
        final List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
            ) {
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(SniffConnectionStrategy.REMOTE_CONNECTIONS_PER_CLUSTER));  
                    assertEquals(pingSchedule, connectionProfile.getPingInterval());
        connection.updateSkipUnavailable(skipUnavailable);
        } catch (TimeoutException ex) {
                "Cannot configure setting [cluster.remote.foo.skip_unavailable] if remote cluster is not enabled.",
                final Settings.Builder builder = Settings.builder();  
 * specific language governing permissions and limitations
                            }
 * SPDX-License-Identifier: Apache-2.0
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
                                ex.get().getMessage(),  
                    RemoteClusterConnection remoteClusterConnection1 = service.getRemoteClusterConnection("cluster_1");
                        assertNotNull(ex.get());
                    service.collectNodes(
        }
                                    assertEquals(c2N1Node, func.apply("cluster_2", c2N1Node.getId()));  
                        assertArrayEquals(new String[] { "bar" }, perClusterIndices.get("cluster_1").indices());
    }
        }  
                    assertFalse(firstRemoteClusterConnection.isClosed());
                    NoopTracer.INSTANCE
import static org.opensearch.test.NodeRoles.clusterManagerOnlyNode;  
                .build();
                builder.putList("cluster.remote.cluster_1.seeds", cluster1Seed.getAddress().toString());  
                    );
                        assertEquals(
                            );
 *  
                    assertTrue(firstRemoteClusterConnection.isNodeConnected(node0));
        final Settings dedicatedClusterManager = clusterManagerOnlyNode();
                    assertFalse(service.isRemoteNodeConnected("cluster_2", c2N1Node));
                            IndicesOptions.LENIENT_EXPAND_OPEN,  
            }
                    assertTrue(service.isRemoteClusterRegistered("cluster_1"));
                    secondLatch.await();  
                    assertTrue(secondRemoteClusterConnection.isNodeConnected(node1));
                    initializeRemoteClusters(service);  
                builder.put("cluster.remote.cluster_2.transport.ping_schedule", pingSchedule2);
            MockTransportService c2N1 = startTransport("cluster_2_node_1", knownNodes, Version.CURRENT);
                            iae.getMessage()  
                }
                updateSkipUnavailable(service.getRemoteClusterService(), "cluster1", true);
                    service.updateRemoteCluster(  
        try (
                    assertTrue(service.isRemoteNodeConnected("cluster_2", c2N2Node));
    }
                        "cluster_1",  
        super.tearDown();
            ) {  
        final Settings settings
                    assertFalse(service.isRemoteClusterRegistered("foo"));
                    firstLatch.await();
        ) {
                        try {
                    assertTrue(service.isCrossClusterSearchEnabled());
            knownNodes_c1.add(c1N2Node);
                    assertSame(firstRemoteClusterConnection, service.getRemoteClusterConnection("cluster_test"));
                    TimeValue.timeValueSeconds(randomIntBetween(1, 10));  
            Settings brokenSettingsDependency = Settings.builder().put("cluster.remote.foo.skip_unavailable", randomBoolean()).build();  
                    }  
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
            IllegalArgumentException.class,
            DiscoveryNode cluster1Seed = cluster1Transport.getLocalDiscoNode();
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(SniffConnectionStrategy.REMOTE_NODE_CONNECTIONS));
                    .forEach(setting -> setting.get(brokenSettingsDependency))  
                                    } finally {
                builder.putList("cluster.remote.cluster_1.seeds", cluster1Seed.getAddress().toString());
                        IllegalArgumentException.class,
                            "Can not filter indices; index cluster_1:bar exists but there is also a remote cluster named:" + " cluster_1",
 * KIND, either express or implied.  See the License for the
                TimeValue pingSchedule2 = // randomBoolean() ? TimeValue.MINUS_ONE :
                            IndicesOptions.LENIENT_EXPAND_OPEN,
            }
import static org.hamcrest.Matchers.instanceOf;
import org.opensearch.action.support.IndicesOptions;
import java.util.concurrent.CountDownLatch;  
    public void testRemoteClusterServiceNotEnabledGetCollectNodes() {
                    assertFalse(service.isRemoteNodeConnected("cluster_1", c1N1Node));
                .put("cluster.remote.foo.mode", "proxy")
                    Version.CURRENT,  
                    assertTrue(service.isRemoteClusterRegistered("cluster_1"));  
        final List<DiscoveryNode> knownNodes,
                IllegalArgumentException.class,
                    // Add the cluster on a different thread to test that we wait for a new cluster to
    public void testSkipUnavailable() {  
                MockTransportService transportService = MockTransportService.createNewService(  
                    threadPool,
                settingsBuilder.put(TransportSettings.PING_SCHEDULE.getKey(), pingSchedule).build();  
        }
                    assertFalse(service.isCrossClusterSearchEnabled());
            );
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();  
                                "cluster_1:bar",
        {  
                    Version.CURRENT,
                    RemoteClusterConnection remoteClusterConnection2 = service.getRemoteClusterConnection("cluster_2");
            try (
                        createSettings("cluster_1", Arrays.asList(c1N1Node.getAddress().toString(), c1N2Node.getAddress().toString())),
    }  
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);  
                        createSettings("cluster_2", Arrays.asList(c2N1Node.getAddress().toString(), c2N2Node.getAddress().toString())),  
            TimeValue pingSchedule;
                    assertFalse(service.isCrossClusterSearchEnabled());  
        }
                    assertTrue(service.isCrossClusterSearchEnabled());
            MockTransportService c1N2 = startTransport("cluster_1_node_2", knownNodes, Version.CURRENT, data);
                        assertFalse(firstRemoteClusterConnection.isNodeConnected(node1));  
                        "cluster_1",
                                    }  
                    assertTrue(service.isCrossClusterSearchEnabled());
                    Version.CURRENT,
        } catch (Exception e) {  
                    final RemoteClusterConnection firstRemoteClusterConnection = service.getRemoteClusterConnection("cluster_test");
                    assertFalse(service.isCrossClusterSearchEnabled());  
                    assertFalse(service.isCrossClusterSearchEnabled());
            try (
                    settings,  
                    );  
                    assertEquals(pingSchedule, remoteClusterConnection.getConnectionManager().getConnectionProfile().getPingInterval());
    }  
    public void testIncrementallyAddClusters() throws IOException {  
                transportService.start();
            Collections.shuffle(knownNodes, random());  
    public static void updateSkipUnavailable(RemoteClusterService service, String clusterAlias, boolean skipUnavailable) {  
                                "cluster_1:test",  
        final PlainActionFuture<Void> future = new PlainActionFuture<>();
                builder.putList("cluster.remote.cluster_2.seed", c2N1Node.getAddress().toString());
                transportService.start();
                    assertTrue(service.isRemoteNodeConnected("cluster_1", c1N2Node));
                        );
            service.start();  
                () -> RemoteClusterService.REMOTE_CLUSTER_PING_SCHEDULE.getAllConcreteSettings(brokenSettingsDependency)
            );  
                                public void onResponse(BiFunction<String, String, DiscoveryNode> stringStringDiscoveryNodeBiFunction) {
                final Settings.Builder builder = Settings.builder();  
                        i -> false  
        try (
                    {  
            DiscoveryNode cluster2Seed = cluster2Transport.getLocalDiscoNode();  
                    threadPool,
    }  
                    clusterAdded.actionGet();
            Settings settings = settingsBuilder.build();
 * software distributed under the License is distributed on an
                        assertArrayEquals(new String[] { "foo:bar", "foo*", "baz", "boo" }, perClusterIndices.get("cluster_2").indices());
                    NoopTracer.INSTANCE
                    final CountDownLatch firstLatch = new CountDownLatch(1);
                    assertFalse(service.isRemoteNodeConnected("cluster_1", c1N1Node));
        try (MockTransportService seedTransport = startTransport("cluster_1_node", knownNodes, Version.CURRENT)) {
                builder.putList("cluster.remote.cluster_test.seeds", Collections.singletonList(node0.getAddress().toString()));
                    // connect before returning.
                    Version.CURRENT,
            Collections.shuffle(knownNodes, random());
        ) {  
                    assertTrue(service.isCrossClusterSearchEnabled());
            knownNodes.add(cluster1Transport.getLocalDiscoNode());  
            MockTransportService c1N1 = startTransport("cluster_1_node_1", knownNodes_c1, Version.CURRENT, settings);
                    {  
                        assertTrue(firstRemoteClusterConnection.isClosed());
            ) {
            .build();  
                        AtomicReference<Exception> ex = new AtomicReference<>();
                    RemoteClusterConnection remoteClusterConnection = service.getRemoteClusterConnection("cluster_1");
                .put("cluster.remote.foo.transport.ping_schedule", "5s")
                    NoopTracer.INSTANCE  
        ) {
                    ConnectionProfile connectionProfile = remoteClusterConnection.getConnectionManager().getConnectionProfile();
    void initializeRemoteClusters(RemoteClusterService service) {  
                transportService.acceptIncomingRequests();
                                        ex.set(e);
            service.start();  
                    initializeRemoteClusters(service);  
                            new String[] { "foo:bar", "cluster_1:bar", "cluster_2:foo:bar", "cluster_1:test", "cluster_2:foo*", "foo" },
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(RemoteClusterService.REMOTE_CLUSTER_COMPRESS));
                )  
                    }
                    assertFalse(service.isCrossClusterSearchEnabled());
                        createSettings("cluster_1", Collections.singletonList(seedNode.getAddress().toString()))  
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);  
                        new String[] {
                }
                        assertEquals(2, perClusterIndices.size());  
            if (randomBoolean()) {
                iae.getMessage()
import org.opensearch.cluster.node.DiscoveryNode;
            MockTransportService c2N2 = startTransport("cluster_2_node_2", knownNodes, Version.CURRENT, data)
            MockTransportService c1N1 = startTransport("cluster_1_node_1", knownNodes, Version.CURRENT, dedicatedClusterManager);
                    assertEquals(2, perClusterIndices.size());
                        "cluster_2",  
                iae.getMessage()
import org.opensearch.test.OpenSearchTestCase;
                                        failLatch.countDown();  
import org.opensearch.core.action.ActionListener;
                            "foo:bar",  
                    assertEquals(2, firstRemoteClusterConnection.getNumNodesConnected());  
                IllegalArgumentException.class,  
        }  
            Collections.shuffle(knownNodes, random());
        builder.put(  
            knownNodes.add(cluster1Transport.getLocalDiscoNode());  
            final DiscoveryNode c2N2Node = c2N2.getLocalDiscoNode();  
            );
        assertEquals("failed to parse port", e.getMessage());
            Settings.Builder settingsBuilder = Settings.builder();
    public void testGroupIndices() throws IOException {  
import java.util.ArrayList;
            ) {
    public void testSettingsAreRegistered() {
            } else {
                () -> RemoteClusterService.REMOTE_CLUSTER_SKIP_UNAVAILABLE.getAllConcreteSettings(brokenSettingsType)  
                    threadPool,
    public void testGroupClusterIndices() throws IOException {
            }
            MockTransportService c2N1 = startTransport("cluster_2_node_1", knownNodes, Version.CURRENT, dedicatedClusterManager);  
                MockTransportService transportService = MockTransportService.createNewService(
                builder.put("cluster.remote.cluster_1.transport.ping_schedule", pingSchedule1);
    }
        Settings brokenSettings = Settings.builder().put("cluster.remote.foo.seeds", "192.168.0.1").build();  
            future.get(10, TimeUnit.SECONDS);
            ) {
                        Collections.singletonList(cluster1Seed.getAddress().toString())
                    threadPool,  
                        Collections.shuffle(newSeeds, random());
                    );  
                transportService.start();  
                            new ActionListener<BiFunction<String, String, DiscoveryNode>>() {
            );
                    assertEquals(Arrays.asList("foo:bar", "foo", "no*match:boo"), localIndices);
            final DiscoveryNode c1N1Node = c1N1.getLocalDiscoNode();  
                    settingsChange.put("cluster.remote.cluster_1.transport.compress", compressionEnabled);
        }  
import org.opensearch.threadpool.TestThreadPool;
                    NoopTracer.INSTANCE  
                    CountDownLatch latch = new CountDownLatch(1);  
                    assertEquals("remote clusters must not have the empty string as its key", iae.getMessage());
                builder.putList("cluster.remote.cluster_1.seed", c1N1Node.getAddress().toString());
                    service.validateAndUpdateRemoteCluster("cluster_2", cluster2SettingsDisabled);
            }  
                    assertEquals(2, secondRemoteClusterConnection.getNumNodesConnected());
                            i -> false
            try (
                            "cluster_2:foo*",
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS));
    public void testChangeSettings() throws Exception {
    }
                        new ActionListener<BiFunction<String, String, DiscoveryNode>>() {  
                                @Override
            Settings transportSettings = settingsBuilder.build();
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
 * under the License.  
            try (  
                    Settings cluster1Settings = createSettings(
                        failLatch.await();
 * The OpenSearch Contributors require contributions made to  
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
            try (
                    service.validateAndUpdateRemoteCluster("cluster_1", settingsChange.build());  
        }
                            );
                            "cluster_1:test",  
            final IllegalArgumentException e = expectThrows(
            knownNodes.add(cluster2Transport.getLocalDiscoNode());  
    private MockTransportService startTransport(String id, List<DiscoveryNode> knownNodes, Version version) {
                            }
import java.util.HashSet;
                    }).start();
                    assertFalse(service.getRemoteClusterService().isSkipUnavailable("cluster1"));
                            IllegalArgumentException.class,  
                )
                .put("cluster.remote.foo.transport.compress", false)
        {
        ) {
                MockTransportService transportService = MockTransportService.createNewService(  
            }
            builder.putList("cluster.remote.cluster1.seeds", seedTransport.getLocalDiscoNode().getAddress().toString());  
                                    }
            MockTransportService c2N1 = startTransport("cluster_2_node_1", knownNodes_c2, Version.CURRENT, settings);  
                assertFalse(service.getRemoteClusterService().isSkipUnavailable("cluster1"));  
                }
                        connectionListener(firstLatch)
        for (RemoteClusterConnection connection : service.getConnections()) {  
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);
                pingSchedule = TimeValue.timeValueSeconds(randomIntBetween(1, 10));
/*
                    final CountDownLatch firstLatch = new CountDownLatch(1);
                                    assertEquals(c1N1Node, func.apply("cluster_1", c1N1Node.getId()));
                    secondLatch.await();
                                        ex.set(e);  
            final DiscoveryNode c1N2Node = c1N2.getLocalDiscoNode();
                try (RemoteClusterService service = new RemoteClusterService(settings, transportService)) {  
        );  
            if (randomBoolean()) {
                                new String[] { "foo:bar", "cluster_1:bar", "cluster_2:foo:bar", "cluster_1:test", "cluster_2:foo*", "foo" },  
                                    latch.countDown();  
                        connectionListener(firstLatch)  
                            perClusterIndices.get(RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY).indices()
                        "cluster_2",
        final Settings settings = removeRoles(Collections.singleton(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE));
                    assertTrue(service.isRemoteClusterRegistered("cluster_1"));  
                    builder.build(),  
                                        fail("should not be called");  
import java.util.concurrent.TimeoutException;
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
                    Version.CURRENT,
            RemoteClusterService.REMOTE_CLUSTER_COMPRESS.getAllConcreteSettings(settings).forEach(setting -> setting.get(settings));
                MockTransportService transportService = MockTransportService.createNewService(
                            new String[] { "cluster_1:bar", "cluster_2:foo*" },  
                        newSeeds.add(node0.getAddress().toString());
                        "cluster_1",  
                MockTransportService transportService = MockTransportService.createNewService(
                                try {  
            }
                                } finally {
                    assertTrue(service.isRemoteClusterRegistered("cluster_1"));
                    settings,
import org.opensearch.test.transport.MockTransportService;  
            knownNodes.add(cluster2Transport.getLocalDiscoNode());  
                    assertTrue(service.isRemoteClusterRegistered("cluster_1"));
            IllegalArgumentException.class,  
                    IllegalArgumentException iae = expectThrows(  
                        );  
        return ActionListener.wrap(x -> latch.countDown(), x -> fail());
                    {
                MockTransportService transportService = MockTransportService.createNewService(
        expectThrows(
            MockTransportService service = MockTransportService.createNewService(settings, Version.CURRENT, threadPool, NoopTracer.INSTANCE)
                    initializeRemoteClusters(service);
                    final CountDownLatch firstLatch = new CountDownLatch(1);
            service.acceptIncomingRequests();
                    assertEquals(0, transportService.getConnectionManager().size());
            try (
                        IllegalArgumentException.class,
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();  
                transportService.start();
                final Settings.Builder builder = Settings.builder();
                        failLatch.await();
        return builder.build();
                try (RemoteClusterService service = new RemoteClusterService(builder.build(), transportService)) {
                            assertThat(  
        service.initializeRemoteClusters(future);
                Settings.Builder builder = Settings.builder();
            }  
                                "cluster_1:bar"::equals
            RemoteClusterService.REMOTE_CLUSTER_PING_SCHEDULE.getAllConcreteSettings(settings).forEach(setting -> setting.get(settings));
                            public void onResponse(BiFunction<String, String, DiscoveryNode> func) {
                        Map<String, OriginalIndices> perClusterIndices = service.groupIndices(  
                try (RemoteClusterService service = new RemoteClusterService(settings, transportService)) {
        ) {
                    assertEquals(pingSchedule2, remoteClusterConnection2.getConnectionManager().getConnectionProfile().getPingInterval());
                builder.putList("cluster.remote.cluster_2.seed", c2N1Node.getAddress().toString());
        }
        );
                                ex.get(),
            assertThat(e.getMessage(), equalTo("this node does not have the remote_cluster_client role"));  
                .put("cluster.remote.foo.skip_unavailable", true)
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)  
                    assertTrue(firstRemoteClusterConnection.isNodeConnected(node1));  
                        createSettings("cluster_2", Arrays.asList(c2N1Node.getAddress().toString(), c2N2Node.getAddress().toString())),
                    Version.CURRENT,
/*
                )
        {
                    service.updateRemoteCluster(
                                } finally {
            new HashSet<>(Arrays.asList(SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS, RemoteClusterService.REMOTE_CLUSTER_SKIP_UNAVAILABLE))  
            knownNodes.add(node1);
                    assertTrue(service.isRemoteClusterRegistered("cluster_1"));  
        }
import org.opensearch.common.settings.Settings;
public class RemoteClusterServiceTests extends OpenSearchTestCase {
                }
                try (RemoteClusterService service = new RemoteClusterService(settings, transportService)) {  
        try (MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT)) {
    }
        final List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();  
                            clusterAdded.onResponse(null);  
import static org.hamcrest.Matchers.equalTo;
                        connectionListener(firstLatch)
                        connectionListener(firstLatch)
                .put("cluster.remote.foo.proxy_address", "127.0.0.1:9300")
                        Collections.singletonList(cluster2Seed.getAddress().toString())
                            new ActionListener<BiFunction<String, String, DiscoveryNode>>() {  
            MockTransportService c2N2 = startTransport("cluster_2_node_2", knownNodes_c2, Version.CURRENT, settings)
        // simple validation
                    final CountDownLatch secondLatch = new CountDownLatch(1);
            DiscoveryNode cluster1Seed = cluster1Transport.getLocalDiscoNode();
            DiscoveryNode seedNode = seedTransport.getLocalDiscoNode();
        try {  
            assertEquals(
            MockTransportService c1N2 = startTransport("cluster_1_node_2", knownNodes, Version.CURRENT, gateway);  
            );
        Settings settings = Settings.builder()  
                    threadPool,
                    assertFalse(service.isCrossClusterSearchEnabled());  
 * GitHub history for details.
        return startTransport(id, knownNodes, version, Settings.EMPTY);  
                builder.putList("cluster.remote.cluster_2.seeds", cluster2Seed.getAddress().toString());
                    {
                )
                                    } finally {
                                service.getRemoteClusterNames(),
                .forEach(setting -> setting.get(brokenSettings))
            Settings settings = Settings.builder()  
        try (
                    TimeValue.timeValueSeconds(randomIntBetween(1, 10));  
                    NoopTracer.INSTANCE
                    NoopTracer.INSTANCE  
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);
                    Settings.Builder settingsChange = Settings.builder();  
                        assertArrayEquals(new String[] { "foo*" }, perClusterIndices.get("cluster_2").indices());
            Collections.shuffle(knownNodes, random());
        try (
                transportService.start();
                    assertTrue(firstRemoteClusterConnection.isNodeConnected(node1));
                    settingsChange.putList("cluster.remote.cluster_1.seeds", cluster1Seed.getAddress().toString());
            Settings brokenSettingsType = Settings.builder().put("cluster.remote.foo.skip_unavailable", "broken").build();  
            );  
                    Settings.EMPTY,  
                    Settings.EMPTY,
            );
                    Version.CURRENT,  
                transportService.start();
                                "foo:bar",  
        }  
                    assertTrue(service.isRemoteNodeConnected("cluster_1", c1N2Node));  
            knownNodes.add(c2N2Node);
                    assertFalse(service.isCrossClusterSearchEnabled());
                        "cluster_2",  
                        if (ex.get() instanceof IllegalStateException) {
                    });  
                        "cluster_1",
                    threadPool,  
                    assertBusy(() -> {
                    newSeeds.add(node1.getAddress().toString());
                    final RemoteClusterConnection secondRemoteClusterConnection = service.getRemoteClusterConnection("cluster_test");
                    assertEquals(2, firstRemoteClusterConnection.getNumNodesConnected());
                                }
        }
            }
 */
                    }  
                    assertTrue(service.isRemoteClusterRegistered("cluster_2"));  
                    assertTrue(service.isCrossClusterSearchEnabled());  
            Thread.currentThread().interrupt();  
                    initializeRemoteClusters(service);
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(RemoteClusterService.REMOTE_NODE_ATTRIBUTE));
            final DiscoveryNode c1N1Node = c1N1.getLocalDiscoNode();  
        final Settings data = nonClusterManagerNode();
                    Settings cluster2SettingsDisabled = createSettings("cluster_2", Collections.emptyList());
            final DiscoveryNode c2N1Node = c2N1.getLocalDiscoNode();
                    assertTrue(service.isRemoteClusterRegistered("cluster_2"));  
    }
                builder.putList("cluster.remote.cluster_1.seeds", cluster1Seed.getAddress().toString());  
}
                    );
                        );  
                try (RemoteClusterService service = new RemoteClusterService(settings, transportService)) {  
                        );  
        AbstractScopedSettings service = new ClusterSettings(
                iae.getMessage()  
                Settings.Builder builder = Settings.builder();
            DiscoveryNode seedNode = seedTransport.getLocalDiscoNode();  
                    final CountDownLatch secondLatch = new CountDownLatch(1);  
                    );  
                "Cannot configure setting [cluster.remote.foo.transport.ping_schedule] if remote cluster is not enabled.",  
    public void testRemoteClusterSeedSetting() {
                            "cluster_1:bar",
            }
                    assertFalse(service.isRemoteClusterRegistered("foo"));
                        logger.info("all source nodes are closed");
        final Settings settings = Settings.EMPTY;
                builder.putList("cluster.remote.cluster_2.seeds", cluster2Seed.getAddress().toString());  
                .put("cluster.remote.foo.proxy_address", "127.0.0.1:9300")  
            Collections.shuffle(knownNodes, random());
                    assertFalse(service.isCrossClusterSearchEnabled());
            knownNodes.add(c2N2Node);
    }
                IllegalArgumentException.class,
 * Licensed to Elasticsearch under one or more contributor  
            knownNodes_c2.add(c2N1Node);  
                    {
                            public void onFailure(Exception e) {
            try (
 * Unless required by applicable law or agreed to in writing,
                                "*:boo",
                    );
                transportService.acceptIncomingRequests();  
                                    latch.countDown();  
                                }
                        createSettings("cluster_test", Collections.singletonList(node0.getAddress().toString())),
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
                    assertTrue(service.isCrossClusterSearchEnabled());  
                            @Override
            final DiscoveryNode c1N2Node = c1N2.getLocalDiscoNode();
import java.io.IOException;
                    NoopTracer.INSTANCE  
                builder.putList("cluster.remote.cluster_1.seeds", cluster1Seed.getAddress().toString());
            assertThat(e.getMessage(), equalTo("this node does not have the remote_cluster_client role"));  
                )  
 *
    }
        }  
/*  
                transportService.acceptIncomingRequests();
import org.opensearch.common.unit.TimeValue;  
                    assertTrue(service.isCrossClusterSearchEnabled());  
        {
                    assertEquals(Arrays.asList("bar", "test", "baz", "boo"), perClusterIndices.get("cluster_1"));  
                Settings.Builder builder = Settings.builder();
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();  
                final Settings.Builder builder = Settings.builder();  
                IllegalArgumentException.class,  
                    assertEquals(Arrays.asList("foo:bar", "foo*", "baz", "boo"), perClusterIndices.get("cluster_2"));
                        service.collectNodes(  
                    transportSettings,  
                    Map<String, List<String>> perClusterIndices = service.groupClusterIndices(  
                    service.validateAndUpdateRemoteCluster(
                    initializeRemoteClusters(service);
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(RemoteClusterService.REMOTE_CLUSTER_SKIP_UNAVAILABLE));  
                            new HashSet<>(Arrays.asList("cluster_1", "cluster_2")),
                )
                        Map<String, OriginalIndices> perClusterIndices = service.groupIndices(
                                try {  
                        AtomicReference<Exception> ex = new AtomicReference<>();  
                )
import java.util.concurrent.atomic.AtomicReference;  
                    Settings.EMPTY,  
                    PlainActionFuture<Void> clusterAdded = PlainActionFuture.newFuture();  
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(ProxyConnectionStrategy.REMOTE_SOCKET_CONNECTIONS));
        SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS.getAllConcreteSettings(settings).forEach(setting -> setting.get(settings));
                transportService.acceptIncomingRequests();  
            MockTransportService service = MockTransportService.createNewService(settings, Version.CURRENT, threadPool, NoopTracer.INSTANCE)
                .put("cluster.remote.foo.seeds", "127.0.0.1:9300")
                        service.getRemoteClusterNames(),
                                )  
                        "cluster_1",
                    assertFalse(service.isCrossClusterSearchEnabled());
 */  
            knownNodes_c1.add(c1N1Node);
        }  
                    assertTrue(service.isCrossClusterSearchEnabled());  
                .build();  
    }  
                    threadPool,
                        connectionListener(secondLatch)  
import java.util.function.BiFunction;
 * compatible open source license.
                    initializeRemoteClusters(service);
                    service.updateRemoteCluster(
            ) {
                IllegalArgumentException.class,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.opensearch.test.NodeRoles.removeRoles;
                            service.getRemoteClusterNames(),  
                    );
    }
    public void testRemoteNodeAttribute() throws IOException, InterruptedException {  
    private ActionListener<Void> connectionListener(final CountDownLatch latch) {  
import static org.opensearch.test.NodeRoles.nonClusterManagerNode;
            IllegalArgumentException iae = expectThrows(
            assertEquals(
                    initializeRemoteClusters(service);
                    Version.CURRENT,
                                        failLatch.countDown();
                            new HashSet<>(Arrays.asList("cluster_1", "cluster_2", "no such cluster")),
                    Version.CURRENT,  
                            clusterAdded.onFailure(e);
        final List<DiscoveryNode> knownNodes_c2 = new CopyOnWriteArrayList<>();
                .build();
 * You may obtain a copy of the License at  
            final DiscoveryNode c2N2Node = c2N2.getLocalDiscoNode();
                    final CountDownLatch firstLatch = new CountDownLatch(1);
                    assertNotNull(localIndices);  
    public void testRemoteClusterServiceNotEnabledGetRemoteClusterConnection() {
                                "foo",
        final Settings settings = Settings.EMPTY;
                    }  
                                    try {  
import org.opensearch.action.support.PlainActionFuture;  
                    assertFalse(service.isCrossClusterSearchEnabled());  
                            Strings.EMPTY_ARRAY,
                }
package org.opensearch.transport;
                    threadPool,
                "Cannot configure setting [cluster.remote.foo.transport.compress] if remote cluster is not enabled.",
                    assertTrue(service.isCrossClusterSearchEnabled());
                MockTransportService service = MockTransportService.createNewService(
                                    equalTo("Unable to open any connections to remote cluster [cluster_2]")
                    secondLatch.await();
        Settings.Builder builder = Settings.builder();
                    settings,
        final Settings settings = removeRoles(Collections.singleton(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE));
import java.util.concurrent.TimeUnit;
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            );
                    settings,
                    updateSkipUnavailable(service.getRemoteClusterService(), "cluster1", false);  
        RemoteClusterConnection connection = service.getRemoteClusterConnection(clusterAlias);
                                    } finally {
                                    assertEquals(c1N2Node, func.apply("cluster_1", c1N2Node.getId()));
        }
                    assertTrue(service.isRemoteClusterRegistered("cluster_2"));
                    new Thread(() -> {  
                        createSettings("cluster_1", Arrays.asList(c1N1Node.getAddress().toString(), c1N2Node.getAddress().toString())),  
            }
                            () -> service.groupClusterIndices(
            MockTransportService c2N2 = startTransport("cluster_2_node_2", knownNodes, Version.CURRENT, gateway)
                        );  
            ) {
                        () -> service.validateAndUpdateRemoteCluster(RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY, Settings.EMPTY)  
                                @Override  
                builder.putList("cluster.remote.cluster_2.seeds", cluster2Seed.getAddress().toString());  
    ) {
                    boolean compressionEnabled = true;  
            knownNodes.add(c1N1Node);
                        assertArrayEquals(Strings.EMPTY_ARRAY, perClusterIndices.get(RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY).indices());
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(RemoteClusterService.REMOTE_CLUSTER_PING_SCHEDULE));  
                                    }  
                "Cannot configure setting [cluster.remote.foo.skip_unavailable] if remote cluster is not enabled.",  
                    threadPool,
                    assertTrue(secondRemoteClusterConnection.isNodeConnected(node0));  
                        assertEquals(1, perClusterIndices.size());
            DiscoveryNode cluster1Seed = cluster1Transport.getLocalDiscoNode();  
        }
                .forEach(setting -> setting.get(brokenPortSettings))
                .put("cluster.remote.foo.proxy_address", "127.0.0.1:9300")
                        assertTrue(ex.get() instanceof NoSuchRemoteClusterException);  
                                "no*match:boo" },
            MockTransportService cluster_node_0 = startTransport("cluster_node_0", knownNodes, Version.CURRENT);  
                    assertTrue(service.isRemoteClusterRegistered("cluster_1"));
            .put("cluster.remote.bar.seeds", "[::1]:9090")
                                        fail("should not be called");
            Settings.Builder settingsBuilder = Settings.builder();
                transportService.start();  
            ) {  
            () -> SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS.getAllConcreteSettings(brokenSettings)
                            i -> false
            IllegalArgumentException iae = expectThrows(  
                iae.getMessage()
import org.opensearch.common.settings.AbstractScopedSettings;  
                builder.putList("cluster.remote.cluster_2.seeds", cluster2Seed.getAddress().toString());
                        } catch (Exception e) {
                    assertTrue(service.isRemoteClusterRegistered("cluster_1"));
                        );
                transportService.acceptIncomingRequests();
