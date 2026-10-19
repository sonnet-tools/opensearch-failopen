                        logger.info("closing all source nodes");
        }
                    Version.CURRENT,
    private static Settings createSettings(String clusterAlias, List<String> seeds) {
import java.io.IOException;
    void initializeRemoteClusters(RemoteClusterService service) {
                    threadPool,
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                        assertEquals(1, perClusterIndices.size());
            if (randomBoolean()) {
                                        ex.set(e);
                    CountDownLatch latch = new CountDownLatch(1);
            knownNodes.add(c2N1Node);
                    assertTrue(service.isCrossClusterSearchEnabled());
        {
                    NoopTracer.INSTANCE
                transportService.acceptIncomingRequests();
            () -> SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS.getAllConcreteSettings(brokenSettings)
            DiscoveryNode cluster2Seed = cluster2Transport.getLocalDiscoNode();
        try (MockTransportService seedTransport = startTransport("cluster_1_node", knownNodes, Version.CURRENT)) {
                transportService.start();
 * You may obtain a copy of the License at
                pingSchedule = TimeValue.timeValueSeconds(randomIntBetween(1, 10));
            Settings settings = Settings.builder()
                    assertEquals(2, perClusterIndices.size());
                    assertTrue(firstRemoteClusterConnection.isNodeConnected(node1));
 *    http://www.apache.org/licenses/LICENSE-2.0
                    assertTrue(service.isCrossClusterSearchEnabled());
        ) {
                builder.putList("cluster.remote.cluster_1.seeds", cluster1Seed.getAddress().toString());
            final DiscoveryNode c1N1Node = c1N1.getLocalDiscoNode();
                                    latch.countDown();
                    assertEquals(pingSchedule2, remoteClusterConnection2.getConnectionManager().getConnectionProfile().getPingInterval());
                        createSettings("cluster_2", Arrays.asList(c2N1Node.getAddress().toString(), c2N2Node.getAddress().toString())),
            try (
 *
                                "*:boo",
        final Settings data = nonClusterManagerNode();
            assertThat(e.getMessage(), equalTo("this node does not have the remote_cluster_client role"));
            assertEquals(
                IllegalArgumentException.class,
                .put("cluster.remote.foo.proxy_address", "127.0.0.1:9300")
                    initializeRemoteClusters(service);
                    assertFalse(service.isRemoteNodeConnected("cluster_1", c1N1Node));
            );
            MockTransportService c1N1 = startTransport("cluster_1_node_1", knownNodes_c1, Version.CURRENT, settings);
        );
            SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS.getConcreteSettingForNamespace(clusterAlias).getKey(),
                    NoopTracer.INSTANCE
            RemoteClusterService.REMOTE_CLUSTER_COMPRESS.getAllConcreteSettings(settings).forEach(setting -> setting.get(settings));
                            service.getRemoteClusterNames(),
                    service.updateRemoteCluster("cluster_test", createSettings("cluster_test", newSeeds), connectionListener(secondLatch));
                    assertEquals(pingSchedule, remoteClusterConnection.getConnectionManager().getConnectionProfile().getPingInterval());
                            new ActionListener<BiFunction<String, String, DiscoveryNode>>() {
            MockTransportService cluster_node_1 = startTransport("cluster_node_1", knownNodes, Version.CURRENT)
                transportService.acceptIncomingRequests();
                        createSettings("cluster_2", Arrays.asList(c2N1Node.getAddress().toString(), c2N2Node.getAddress().toString())),
                        }
                transportService.start();
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(RemoteClusterService.REMOTE_CLUSTER_SKIP_UNAVAILABLE));
            Collections.shuffle(knownNodes, random());
                .forEach(setting -> setting.get(brokenSettings))
            final DiscoveryNode node0 = cluster_node_0.getLocalDiscoNode();
                        service.collectNodes(
                            new String[] { "foo:bar", "foo", "no*match:boo" },
                                either(equalTo("Unable to open any connections to remote cluster [cluster_1]")).or(
                        "cluster_2",
                iae.getMessage()
    }
        return startTransport(id, knownNodes, version, Settings.EMPTY);
        }
import org.opensearch.test.OpenSearchTestCase;
            try (
    }
            knownNodes_c1.add(c1N2Node);
                        Collections.shuffle(newSeeds, random());
        } catch (TimeoutException ex) {
                    assertFalse(service.isCrossClusterSearchEnabled());
import org.opensearch.core.common.Strings;
            }
                    );
                                    assertEquals(c2N1Node, func.apply("cluster_2", c2N1Node.getId()));
                    assertBusy(() -> {
            connectionManager.addListener(listener);
                Settings.Builder builder = Settings.builder();
 * under the License.
                    Settings.EMPTY,
                    if (randomBoolean()) {
        final PlainActionFuture<Void> future = new PlainActionFuture<>();
                                )
            DiscoveryNode cluster1Seed = cluster1Transport.getLocalDiscoNode();
                    assertEquals(2, secondRemoteClusterConnection.getNumNodesConnected());
                            }
            Settings.Builder settingsBuilder = Settings.builder();
            final DiscoveryNode c2N1Node = c2N1.getLocalDiscoNode();
                    assertFalse(service.isCrossClusterSearchEnabled());
                    assertTrue(service.isRemoteClusterRegistered("cluster_1"));
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                    assertTrue(service.isRemoteNodeConnected("cluster_2", c2N2Node));
        try {
                    assertEquals(compressionEnabled, connectionProfile.getCompressionEnabled());
    ) {
                    assertEquals(2, firstRemoteClusterConnection.getNumNodesConnected());
            );
        final Settings gateway = Settings.builder().put("node.attr.gateway", true).build();
                                    try {
        final List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                                "cluster_2:foo*",
                            IllegalArgumentException.class,
                            "cluster_1:bar",
                    .forEach(setting -> setting.get(brokenSettingsDependency))
                            i -> false
        }
            Settings brokenSettingsType = Settings.builder().put("cluster.remote.foo.skip_unavailable", "broken").build();
                                        failLatch.countDown();
                )
                        } else {
    private ActionListener<Void> connectionListener(final CountDownLatch latch) {
            if (randomBoolean()) {
            );
 * software distributed under the License is distributed on an
            final DiscoveryNode c2N1Node = c2N1.getLocalDiscoNode();
                        } catch (Exception e) {
                            iae.getMessage()
                            IndicesOptions.LENIENT_EXPAND_OPEN,
                try (RemoteClusterService service = new RemoteClusterService(settings, transportService)) {
                    firstLatch.await();
                .put("cluster.remote.foo.seeds", "127.0.0.1:9300")
            knownNodes_c2.add(c2N2Node);
                assertTrue(service.getRemoteClusterService().isSkipUnavailable("cluster1"));
        builder.put(
            ) {
    }
            knownNodes_c2.add(c2N1Node);
                    assertTrue(service.isCrossClusterSearchEnabled());
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
                                    } finally {
                builder.putList("cluster.remote.cluster_1.seeds", cluster1Seed.getAddress().toString());
                                        fail("should not be called");
                            clusterAdded.onResponse(null);
                            @Override
            knownNodes.add(seedNode);
                try (RemoteClusterService service = new RemoteClusterService(builder.build(), transportService)) {
                    {
                        AtomicReference<Exception> ex = new AtomicReference<>();
 * specific language governing permissions and limitations
    }
                    Version.CURRENT,
                    Version.CURRENT,
                                    equalTo("Unable to open any connections to remote cluster [cluster_2]")
                    service.validateAndUpdateRemoteCluster("cluster_2", cluster2SettingsDisabled);
        ) {
                    );
            final DiscoveryNode c2N2Node = c2N2.getLocalDiscoNode();
    }
            knownNodes.add(c2N2Node);
                    initializeRemoteClusters(service);
                transportService.acceptIncomingRequests();
                            "*:boo",
                        try {
            }
                            () -> service.groupClusterIndices(
            );
                    TimeValue.timeValueSeconds(randomIntBetween(1, 10));
    }
                        service.collectNodes(
                    assertTrue(service.isCrossClusterSearchEnabled());
        {
                    assertTrue(service.isCrossClusterSearchEnabled());
                        assertFalse(firstRemoteClusterConnection.isNodeConnected(node0));
                    assertFalse(service.isCrossClusterSearchEnabled());
            Collections.shuffle(knownNodes_c2, random());
            final DiscoveryNode c1N1Node = c1N1.getLocalDiscoNode();
                    settingsChange.put("cluster.remote.cluster_1.transport.compress", compressionEnabled);
                                }
            DiscoveryNode seedNode = seedTransport.getLocalDiscoNode();
                        connectionListener(secondLatch)
                pingSchedule = TimeValue.MINUS_ONE;
                .put("cluster.remote.foo.proxy_address", "127.0.0.1:9300")
                MockTransportService transportService = MockTransportService.createNewService(
                                }
                                public void onResponse(BiFunction<String, String, DiscoveryNode> stringStringDiscoveryNodeBiFunction) {
                "Cannot configure setting [cluster.remote.foo.transport.compress] if remote cluster is not enabled.",
                    assertFalse(service.isRemoteClusterRegistered("cluster_2"));
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                transportService.acceptIncomingRequests();
                settingsBuilder.put(TransportSettings.PING_SCHEDULE.getKey(), TimeValue.timeValueSeconds(randomIntBetween(1, 10)));
        }
            final DiscoveryNode c1N2Node = c1N2.getLocalDiscoNode();
                    }
            TimeValue pingSchedule;
            IllegalArgumentException iae = expectThrows(
                "Cannot configure setting [cluster.remote.foo.skip_unavailable] if remote cluster is not enabled.",
                transportService.start();
 *
        );
                        "cluster_1",
                    final CountDownLatch firstLatch = new CountDownLatch(1);
                builder.putList("cluster.remote.cluster_1.seeds", cluster1Seed.getAddress().toString());
                .put("cluster.remote.foo.mode", "proxy")
    }
 * SPDX-License-Identifier: Apache-2.0
        {
            DiscoveryNode cluster2Seed = cluster2Transport.getLocalDiscoNode();
                                    .or(instanceOf(NoSeedNodeLeftException.class))
            RemoteClusterService.REMOTE_CLUSTER_SKIP_UNAVAILABLE.getAllConcreteSettings(settings).forEach(setting -> setting.get(settings));
            future.get(10, TimeUnit.SECONDS);
                Settings.Builder builder = Settings.builder();
                            i -> false
                                ex.get().getMessage(),
        final String id,
                    assertFalse(service.isCrossClusterSearchEnabled());
                    {
            final DiscoveryNode c1N2Node = c1N2.getLocalDiscoNode();
            ) {
                    initializeRemoteClusters(service);
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
            try (
                    NoopTracer.INSTANCE
        AbstractScopedSettings service = new ClusterSettings(
                IllegalArgumentException.class,
                )
                                        failLatch.countDown();
    }
import org.opensearch.threadpool.ThreadPool;
                    settingsChange.put("cluster.remote.cluster_1.transport.ping_schedule", pingSchedule);
                        );
            Settings transportSettings = settingsBuilder.build();
                        connectionListener(secondLatch)
                    Version.CURRENT,
                .put("cluster.remote.foo.transport.compress", true)
                        connectionListener(firstLatch)
                    secondLatch.await();
                transportService.acceptIncomingRequests();
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS));
                IllegalArgumentException.class,
        }
                            new ActionListener<BiFunction<String, String, DiscoveryNode>>() {
        try (MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT)) {
                final Settings.Builder builder = Settings.builder();
                    initializeRemoteClusters(service);
                    RemoteClusterConnection remoteClusterConnection = service.getRemoteClusterConnection("cluster_1");
                        new HashSet<>(Arrays.asList("cluster_1", "cluster_2")),
        final List<DiscoveryNode> knownNodes_c2 = new CopyOnWriteArrayList<>();
                        connectionListener(firstLatch)
import static org.opensearch.test.NodeRoles.clusterManagerOnlyNode;
                            perClusterIndices.get(RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY).indices()
                                    assertEquals(c1N2Node, func.apply("cluster_1", c1N2Node.getId()));
            Settings brokenSettingsDependency = Settings.builder()
            );
                    TimeValue.timeValueSeconds(randomIntBetween(1, 10));
                    assertTrue(service.isRemoteClusterRegistered("cluster_1"));
import org.opensearch.common.util.io.IOUtils;
                        new ActionListener<BiFunction<String, String, DiscoveryNode>>() {
                    final CountDownLatch secondLatch = new CountDownLatch(1);
            knownNodes.add(node0);
                        assertNotNull(ex.get());
                            "foo:bar",
                                    try {
                        Map<String, OriginalIndices> perClusterIndices = service.groupIndices(
                    assertTrue(firstRemoteClusterConnection.isNodeConnected(node0));
            assertEquals(
                    }
                    }
 */
                try (RemoteClusterService service = new RemoteClusterService(builder.build(), transportService)) {
                MockTransportService transportService = MockTransportService.createNewService(
            Settings settings = Settings.builder()
                    settings,
        }
            Settings brokenSettingsDependency = Settings.builder().put("cluster.remote.foo.skip_unavailable", randomBoolean()).build();
                        assertArrayEquals(new String[] { "bar" }, perClusterIndices.get("cluster_1").indices());
        ) {
                    final RemoteClusterConnection secondRemoteClusterConnection = service.getRemoteClusterConnection("cluster_test");
                    final CountDownLatch secondLatch = new CountDownLatch(1);
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(RemoteConnectionStrategy.REMOTE_CONNECTION_MODE));
        ) {
                        assertFalse(firstRemoteClusterConnection.isNodeConnected(node1));
                    PlainActionFuture<Void> clusterAdded = PlainActionFuture.newFuture();
                    final CountDownLatch secondLatch = new CountDownLatch(1);
                    Settings cluster1Settings = createSettings(
    public void testChangeSettings() throws Exception {
            final DiscoveryNode c1N2Node = c1N2.getLocalDiscoNode();
            try (
        }
        Settings brokenPortSettings = Settings.builder().put("cluster.remote.foo.seeds", "192.168.0.1:123456789123456789").build();
                    Map<String, List<String>> perClusterIndices = service.groupClusterIndices(
                IllegalArgumentException.class,
                    RemoteClusterConnection remoteClusterConnection2 = service.getRemoteClusterConnection("cluster_2");
    }
                builder.putList("cluster.remote.cluster_2.seed", c2N1Node.getAddress().toString());
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);
            ) {
 * compatible open source license.
                transportService.start();
                    assertFalse(firstRemoteClusterConnection.isClosed());
            MockTransportService c1N1 = startTransport("cluster_1_node_1", knownNodes, Version.CURRENT, dedicatedClusterManager);
    }
    public void testCollectNodes() throws InterruptedException, IOException {
                                "foo",
            );
                    service.validateAndUpdateRemoteCluster("cluster_2", cluster2Settings);
            final DiscoveryNode c2N2Node = c2N2.getLocalDiscoNode();
                    final CountDownLatch secondLatch = new CountDownLatch(1);
                                    }
                transportService.start();
        {
        }
                    secondLatch.await();
import org.opensearch.common.settings.AbstractScopedSettings;
                    }
                    transportSettings,
                        IllegalArgumentException.class,
                service.start();
                MockTransportService transportService = MockTransportService.createNewService(
import org.opensearch.common.settings.ClusterSettings;
                        AtomicReference<Exception> ex = new AtomicReference<>();
        ) {
import org.opensearch.core.action.ActionListener;
                transportService.acceptIncomingRequests();
import org.opensearch.action.OriginalIndices;
            Collections.shuffle(knownNodes, random());
                try (RemoteClusterService service = new RemoteClusterService(settings, transportService)) {
                        new String[] {
                    service.updateRemoteCluster(
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
            }
                            "foo",
        return builder.build();
                    assertEquals(Arrays.asList("foo:bar", "foo*", "baz", "boo"), perClusterIndices.get("cluster_2"));
                    );
            final DiscoveryNode c2N2Node = c2N2.getLocalDiscoNode();
                transportService.acceptIncomingRequests();
            final IllegalArgumentException e = expectThrows(
                            );
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
            Collections.shuffle(knownNodes, random());
            throw new IllegalStateException("failed to connect to remote clusters", e);
    public void testRemoteNodeRoles() throws IOException, InterruptedException {
                    );
                .put("cluster.remote.foo.transport.ping_schedule", "5s")
                IllegalArgumentException.class,
    public void testSettingsAreRegistered() {
        final Settings settings = Settings.EMPTY;
                    assertTrue(service.isRemoteClusterRegistered("cluster_2"));
                            "no*match:boo" },
                builder.putList("cluster.remote.cluster_2.seeds", cluster2Seed.getAddress().toString());
                builder.putList("cluster.remote.cluster_test.seeds", Collections.singletonList(node0.getAddress().toString()));
                MockTransportService transportService = MockTransportService.createNewService(
                            )
                    assertFalse(service.isCrossClusterSearchEnabled());
                assertFalse(service.getRemoteClusterService().isSkipUnavailable("cluster1"));
                        createSettings("cluster_2", Arrays.asList(c2N1Node.getAddress().toString(), c2N2Node.getAddress().toString())),
                    assertTrue(service.isRemoteClusterRegistered("cluster_2"));
import static org.opensearch.test.NodeRoles.nonClusterManagerNode;
            IllegalArgumentException iae = expectThrows(
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
                    IllegalArgumentException iae = expectThrows(
                    ConnectionProfile connectionProfile = remoteClusterConnection.getConnectionManager().getConnectionProfile();
 *
                        connectionListener(secondLatch)
                        assertArrayEquals(new String[] { "foo*" }, perClusterIndices.get("cluster_2").indices());
                            assertThat(
                    service.updateRemoteCluster(
            }
            final IllegalArgumentException e = expectThrows(
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
            ) {
                MockTransportService transportService = MockTransportService.createNewService(
            MockTransportService c1N2 = startTransport("cluster_1_node_2", knownNodes, Version.CURRENT, data);
                        assertEquals(0, firstRemoteClusterConnection.getNumNodesConnected());
                TimeValue pingSchedule1 = // randomBoolean() ? TimeValue.MINUS_ONE :
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(RemoteClusterService.REMOTE_CLUSTER_COMPRESS));
                    assertFalse(service.isRemoteNodeConnected("cluster_2", c2N1Node));
                        IOUtils.close(c1N1, c1N2, c2N1, c2N2);
                MockTransportService transportService = MockTransportService.createNewService(
import java.util.Arrays;
                        )
                        "cluster_1",
                    IllegalArgumentException iae = expectThrows(
            MockTransportService service = MockTransportService.createNewService(settings, Version.CURRENT, threadPool, NoopTracer.INSTANCE)
                        service.getRemoteClusterNames(),
            }
                            @Override
                MockTransportService transportService = MockTransportService.createNewService(
                            public void onFailure(Exception e) {
        super.tearDown();
                    );
                .put("cluster.remote.foo.transport.compress", false)
                iae.getMessage()
                                public void onFailure(Exception e) {
                        "cluster_2",
            MockTransportService c2N1 = startTransport("cluster_2_node_1", knownNodes, Version.CURRENT, dedicatedClusterManager);
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
                        Collections.singletonList(cluster1Seed.getAddress().toString())
        {
            Collections.shuffle(knownNodes, random());
                    assertTrue(service.isRemoteClusterRegistered("cluster_1"));
                    RemoteClusterConnection remoteClusterConnection1 = service.getRemoteClusterConnection("cluster_1");
                                "cluster_2:foo:bar",
                    {
                        assertNotNull(ex.get());
        }
 * The OpenSearch Contributors require contributions made to
                    .forEach(setting -> setting.get(brokenSettingsType))
                            "cluster*:baz",
            MockTransportService c2N2 = startTransport("cluster_2_node_2", knownNodes, Version.CURRENT, data)
                    NoopTracer.INSTANCE
        ) {
                    assertFalse(service.isRemoteNodeConnected("cluster_2", c2N1Node));
                        assertArrayEquals(
                            }
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                                    }
    public static void addConnectionListener(RemoteClusterService service, TransportConnectionListener listener) {
                                service.getRemoteClusterNames(),
                    assertSame(firstRemoteClusterConnection, service.getRemoteClusterConnection("cluster_test"));
        for (RemoteClusterConnection connection : service.getConnections()) {
                                        failLatch.countDown();
                    final RemoteClusterConnection firstRemoteClusterConnection = service.getRemoteClusterConnection("cluster_test");
        }
            IllegalArgumentException iae = expectThrows(
            Strings.collectionToCommaDelimitedString(seeds)
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);
            knownNodes.add(c1N1Node);
                builder.put("cluster.remote.cluster_2.transport.ping_schedule", pingSchedule2);
                }
                        Collections.singletonList(cluster2Seed.getAddress().toString())
            MockTransportService c1N1 = startTransport("cluster_1_node_1", knownNodes, Version.CURRENT);
            Thread.currentThread().interrupt();
                    threadPool,
                    NoopTracer.INSTANCE
                )
                try (RemoteClusterService service = new RemoteClusterService(settings, transportService)) {
            final DiscoveryNode node1 = cluster_node_1.getLocalDiscoNode();
import java.util.concurrent.CountDownLatch;
            MockTransportService c1N2 = startTransport("cluster_1_node_2", knownNodes, Version.CURRENT, gateway);
                        connectionListener(firstLatch)
                    Settings.EMPTY,
                    settingsChange.putList("cluster.remote.cluster_1.seeds", cluster1Seed.getAddress().toString());
                    );
            Collections.shuffle(knownNodes, random());
                    service.updateRemoteCluster(
            );
                                new String[] { "foo:bar", "cluster_1:bar", "cluster_2:foo:bar", "cluster_1:test", "cluster_2:foo*", "foo" },
                                "cluster_1:bar",
                .put("cluster.remote.foo.seeds", "127.0.0.1:9300")
        }
                TimeValue pingSchedule2 = // randomBoolean() ? TimeValue.MINUS_ONE :
                builder.putList("cluster.remote.cluster_2.seeds", cluster2Seed.getAddress().toString());
                    service.updateRemoteCluster(
 * ownership. Elasticsearch licenses this file to you under
                    // Add the cluster on a different thread to test that we wait for a new cluster to
                    assertTrue(service.isCrossClusterSearchEnabled());
            Settings settings = Settings.builder()
    @Override
                    {
            Settings brokenSettingsDependency = Settings.builder().put("cluster.remote.foo.skip_unavailable", true).build();
                    Version.CURRENT,
                                public void onFailure(Exception e) {
                        assertEquals(2, perClusterIndices.size());
                    Settings.Builder settingsChange = Settings.builder();
            );
import java.util.List;
import java.util.concurrent.TimeUnit;
                        failLatch.await();
                    Version.CURRENT,
                .build();
                .forEach(setting -> setting.get(brokenPortSettings))
 * license agreements. See the NOTICE file distributed with
            logger.warn("Timed out connecting to remote clusters");
        return ActionListener.wrap(x -> latch.countDown(), x -> fail());
                Settings.Builder builder = Settings.builder();
            ) {
import org.opensearch.cluster.node.DiscoveryNode;
                    initializeRemoteClusters(service);
        final Settings settings = Settings.builder().put("cluster.remote.node.attr", "gateway").build();
            Collections.shuffle(knownNodes_c1, random());
                    initializeRemoteClusters(service);
                                "cluster_1:test",
                    NoopTracer.INSTANCE
            service.acceptIncomingRequests();
                    assertTrue(secondRemoteClusterConnection.isNodeConnected(node1));
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(SniffConnectionStrategy.REMOTE_CONNECTIONS_PER_CLUSTER));
 * GitHub history for details.
            try (
                    });
        );
            MockTransportService c1N2 = startTransport("cluster_1_node_2", knownNodes_c1, Version.CURRENT, settings);
                }
                    assertFalse(firstRemoteClusterConnection.isClosed());
import java.util.concurrent.TimeoutException;
    public static void updateSkipUnavailable(RemoteClusterService service, String clusterAlias, boolean skipUnavailable) {
                builder.putList("cluster.remote.cluster_1.seed", c1N1Node.getAddress().toString());
                    assertFalse(service.isCrossClusterSearchEnabled());
            ) {
                                }
                                } finally {
                    assertTrue(service.isCrossClusterSearchEnabled());
            .put("cluster.remote.foo.seeds", "192.168.0.1:8080")
                            "cluster_1:test",
                            }
        try (
        Settings settings = Settings.builder()
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(RemoteClusterService.REMOTE_INITIAL_CONNECTION_TIMEOUT_SETTING));
    public void testRemoteClusterSeedSetting() {
            final DiscoveryNode c1N1Node = c1N1.getLocalDiscoNode();
import org.opensearch.cluster.node.DiscoveryNodeRole;
    }
        try (
                try (RemoteClusterService service = new RemoteClusterService(builder.build(), transportService)) {
        SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS.getAllConcreteSettings(settings).forEach(setting -> setting.get(settings));
                        IllegalArgumentException.class,
    }
                    threadPool,
                    new Thread(() -> {
                            service.validateAndUpdateRemoteCluster("cluster_1", cluster1Settings);
                            clusterAdded.onFailure(e);
                                } finally {
                    latch.await();
                    service.validateAndUpdateRemoteCluster("cluster_1", settingsChange.build());
        }
                        );
                try (RemoteClusterService service = new RemoteClusterService(Settings.EMPTY, transportService)) {
        }
                    settings,
        try (
        final Settings settings = removeRoles(Collections.singleton(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE));
            service.start();
                    assertTrue(firstRemoteClusterConnection.isNodeConnected(node0));
        try (
        ) {
                    threadPool,
                                @Override
                        assertArrayEquals(new String[] { "foo:bar", "foo*", "baz", "boo" }, perClusterIndices.get("cluster_2").indices());
                builder.putList("cluster.remote.cluster_1.seeds", cluster1Seed.getAddress().toString());
 */
                                    } finally {
                    assertTrue(service.isRemoteClusterRegistered("cluster_2"));
        final Settings settings = removeRoles(Collections.singleton(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE));
        expectThrows(
                        () -> service.validateAndUpdateRemoteCluster(RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY, Settings.EMPTY)
                    .forEach(setting -> setting.get(brokenSettingsDependency))
    private MockTransportService startTransport(String id, List<DiscoveryNode> knownNodes, Version version) {
            IllegalArgumentException iae = expectThrows(
                                @Override
                    threadPool,
                    assertFalse(service.isRemoteClusterRegistered("foo"));
            () -> SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS.getAllConcreteSettings(brokenSettings)
                builder.putList("cluster.remote.cluster_1.seeds", cluster1Seed.getAddress().toString());
                    secondLatch.await();
                    }
                    clusterAdded.actionGet();
    }
            Collections.shuffle(knownNodes, random());
/*
                    boolean compressionEnabled = true;
import java.util.Map;
        ) {
        }
                    assertFalse(service.isRemoteClusterRegistered("foo"));
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
    }
                try (RemoteClusterService service = new RemoteClusterService(builder.build(), transportService)) {
            Collections.shuffle(knownNodes, random());
                                "cluster_1:bar"::equals
                    TimeValue pingSchedule = TimeValue.timeValueSeconds(randomIntBetween(6, 8));
                iae.getMessage()
                    .forEach(setting -> setting.get(brokenSettingsDependency))
                builder.put("cluster.remote.cluster_1.transport.ping_schedule", pingSchedule1);
                builder.putList("cluster.remote.cluster_2.seeds", cluster2Seed.getAddress().toString());
        try (
            MockTransportService c2N2 = startTransport("cluster_2_node_2", knownNodes_c2, Version.CURRENT, settings)
                    Version.CURRENT,
                    Settings.EMPTY,
    }
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(ProxyConnectionStrategy.PROXY_ADDRESS));
                        assertArrayEquals(new String[] { "bar", "test", "baz", "boo" }, perClusterIndices.get("cluster_1").indices());
    public void testRemoteClusterServiceNotEnabledGetCollectNodes() {
            ) {
                                    } finally {
                transportService.start();
                        "cluster_2",
            }
                    threadPool,
            MockTransportService c2N1 = startTransport("cluster_2_node_1", knownNodes, Version.CURRENT);
                    NoopTracer.INSTANCE
                                "cluster*:baz",
                        "cluster_1",
        final Settings settings = Settings.EMPTY;
                final Settings.Builder builder = Settings.builder();
                    service.updateRemoteCluster(
            RemoteClusterService.REMOTE_CLUSTER_PING_SCHEDULE.getAllConcreteSettings(settings).forEach(setting -> setting.get(settings));
                builder.putList("cluster.remote.cluster_1.seed", c1N1Node.getAddress().toString());
                    assertFalse(service.isCrossClusterSearchEnabled());
    }
                    threadPool,
            service.acceptIncomingRequests();
                )
                    assertFalse(service.isCrossClusterSearchEnabled());
                    assertEquals(2, firstRemoteClusterConnection.getNumNodesConnected());
                () -> service.getRemoteClusterService().collectNodes(Collections.emptySet(), ActionListener.wrap(r -> {}, r -> {}))
                    {
                Settings.Builder builder = Settings.builder();
            IllegalArgumentException iae = expectThrows(
        // simple validation
        final List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
public class RemoteClusterServiceTests extends OpenSearchTestCase {
                }
                    settings,
                try (RemoteClusterService service = new RemoteClusterService(builder.build(), transportService)) {
                    newSeeds.add(node1.getAddress().toString());
                    assertTrue(service.isRemoteClusterRegistered("cluster_1"));
                )
                                    try {
            MockTransportService c2N2 = startTransport("cluster_2_node_2", knownNodes, Version.CURRENT, gateway)
                                public void onResponse(BiFunction<String, String, DiscoveryNode> stringStringDiscoveryNodeBiFunction) {
            Settings brokenSettingsDependency = Settings.builder()
                    threadPool,
                        "cluster_1",
                    Version.CURRENT,
                    assertTrue(service.isCrossClusterSearchEnabled());
                    assertEquals(Arrays.asList("foo:bar", "foo", "no*match:boo"), localIndices);
            ) {
import org.opensearch.Version;
 * this work for additional information regarding copyright
    }
                () -> RemoteClusterService.REMOTE_CLUSTER_SKIP_UNAVAILABLE.getAllConcreteSettings(brokenSettingsDependency)
        connection.updateSkipUnavailable(skipUnavailable);
    public void testRemoteClusterSkipIfDisconnectedSetting() {
        try (
        }
            MockTransportService c2N1 = startTransport("cluster_2_node_1", knownNodes_c2, Version.CURRENT, settings);
import static org.hamcrest.Matchers.either;
            new HashSet<>(Arrays.asList(SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS, RemoteClusterService.REMOTE_CLUSTER_SKIP_UNAVAILABLE))
                        );
import org.opensearch.action.support.IndicesOptions;
            }
                    // connect before returning.
        service.initializeRemoteClusters(future);
                    assertTrue(firstRemoteClusterConnection.isNodeConnected(node1));
            try (
                                        ex.set(e);
 * not use this file except in compliance with the License.
                    assertTrue(secondRemoteClusterConnection.isNodeConnected(node0));
 * this file be licensed under the Apache-2.0 license or a
                settingsBuilder.put(TransportSettings.PING_SCHEDULE.getKey(), pingSchedule).build();
                            new HashSet<>(Arrays.asList("cluster_1", "cluster_2", "no such cluster")),
                    service.updateRemoteCluster(
                        if (ex.get() instanceof IllegalStateException) {
            try (
            ) {
                        // close all targets and check for the transport level failure path
                            "cluster_2:foo*",
        }
            DiscoveryNode seedNode = seedTransport.getLocalDiscoNode();
                .put("cluster.remote.foo.proxy_address", "127.0.0.1:9300")
            DiscoveryNode cluster1Seed = cluster1Transport.getLocalDiscoNode();
                            assertThat(
                        "cluster_1",
                    assertTrue(service.isRemoteClusterRegistered("cluster_2"));
                    assertFalse(service.isCrossClusterSearchEnabled());
            try (
            knownNodes.add(c1N2Node);
                final Settings.Builder builder = Settings.builder();
            builder.putList("cluster.remote.cluster1.seeds", seedTransport.getLocalDiscoNode().getAddress().toString());
                MockTransportService transportService = MockTransportService.createNewService(
                    {
                        i -> false
                        Map<String, OriginalIndices> perClusterIndices = service.groupIndices(
                    assertEquals(Arrays.asList("bar", "test", "baz", "boo"), perClusterIndices.get("cluster_1"));
                    assertTrue(service.isCrossClusterSearchEnabled());
                    final List<String> newSeeds = new ArrayList<>();
                () -> service.getRemoteClusterService().getRemoteClusterConnection("test")
            }
        assertEquals("failed to parse port", e.getMessage());
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
            knownNodes.add(c1N1Node);
                            IndicesOptions.LENIENT_EXPAND_OPEN,
                    NoopTracer.INSTANCE
                    Settings cluster2SettingsDisabled = createSettings("cluster_2", Collections.emptyList());
    public void testIncrementallyAddClusters() throws IOException {
                MockTransportService service = MockTransportService.createNewService(
        }
        );
            }
            knownNodes.add(seedTransport.getLocalDiscoNode());
                        CountDownLatch failLatch = new CountDownLatch(1);
                    final CountDownLatch firstLatch = new CountDownLatch(1);
                    assertEquals(
                    assertTrue(service.isRemoteClusterRegistered("cluster_1"));
                .put("cluster.remote.foo.transport.ping_schedule", "5s")
                }
            IllegalArgumentException.class,
 * Modifications Copyright OpenSearch Contributors. See
            assertEquals(
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
            try (
                        }
                transportService.acceptIncomingRequests();
                                try {
import static org.hamcrest.Matchers.equalTo;
                        );
            .put("cluster.remote.bar.seeds", "[::1]:9090")
                    RemoteClusterConnection remoteClusterConnection = service.getRemoteClusterConnection("cluster_1");
                        );
                            new HashSet<>(Arrays.asList("cluster_1", "cluster_2")),
            final DiscoveryNode c2N1Node = c2N1.getLocalDiscoNode();
                    remoteClusterConnection = service.getRemoteClusterConnection("cluster_1");
        }
                }
                    updateSkipUnavailable(service.getRemoteClusterService(), "cluster1", false);
/*
import static org.opensearch.test.NodeRoles.removeRoles;
                )
                            "Can not filter indices; index cluster_1:bar exists but there is also a remote cluster named:" + " cluster_1",
            .build();
                        logger.info("all source nodes are closed");
            ) {
    }
            );
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;
                    Settings.EMPTY,
        Settings.Builder builder = Settings.builder();
                )
    }
/*
                .build();
                        () -> service.groupClusterIndices(
}
                .build();
            }
                                either(instanceOf(TransportException.class)).or(instanceOf(NoSuchRemoteClusterException.class))
                                    assertEquals(c2N2Node, func.apply("cluster_2", c2N2Node.getId()));
                    }
                                "foo:bar",
                    );
                        assertArrayEquals(Strings.EMPTY_ARRAY, perClusterIndices.get(RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY).indices());
                    assertFalse(service.isCrossClusterSearchEnabled());
                        connectionListener(firstLatch)
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                        assertEquals("no such remote cluster: [no such cluster]", ex.get().getMessage());
            DiscoveryNode cluster1Seed = cluster1Transport.getLocalDiscoNode();
                transportService.start();
                    Settings cluster2Settings = createSettings(
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
package org.opensearch.transport;
                    );
                    Version.CURRENT,
            }
                }
                    NoopTracer.INSTANCE
    }
                builder.putList("cluster.remote.cluster_2.seed", c2N1Node.getAddress().toString());
                    assertTrue(service.isCrossClusterSearchEnabled());
        final List<DiscoveryNode> knownNodes_c1 = new CopyOnWriteArrayList<>();
                                try {
                                }
                    );
                    service.validateAndUpdateRemoteCluster(
            MockTransportService service = MockTransportService.createNewService(settings, Version.CURRENT, threadPool, NoopTracer.INSTANCE)
                        "Can not filter indices; index cluster_1:bar exists but there is also a remote cluster named:" + " cluster_1",
        {
                () -> RemoteClusterService.REMOTE_CLUSTER_COMPRESS.getAllConcreteSettings(brokenSettingsDependency)
                                ex.get(),
import org.opensearch.action.support.PlainActionFuture;
                    assertFalse(service.isRemoteNodeConnected("cluster_1", c1N1Node));
import java.util.ArrayList;
                                    }
                                    }
                transportService.start();
        return RemoteClusterConnectionTests.startTransport(id, knownNodes, version, threadPool, settings);
                    initializeRemoteClusters(service);
    public void testCustomPingSchedule() throws IOException {
                    threadPool,
                )
                "Cannot configure setting [cluster.remote.foo.transport.ping_schedule] if remote cluster is not enabled.",
                    Version.CURRENT,
                .put("cluster.remote.foo.skip_unavailable", true)
                )
                            new String[] {
                    assertEquals(pingSchedule, connectionProfile.getPingInterval());
                    initializeRemoteClusters(service);
                builder.putList("cluster.remote.cluster_2.seeds", cluster2Seed.getAddress().toString());
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(RemoteClusterService.REMOTE_CLUSTER_PING_SCHEDULE));
                IllegalArgumentException.class,
            DiscoveryNode cluster2Seed = cluster2Transport.getLocalDiscoNode();
                }
                    assertNotNull(localIndices);
                                    throw new AssertionError(e);
            Settings.Builder builder = Settings.builder();
            knownNodes.add(c2N2Node);
                        failLatch.await();
                    NoopTracer.INSTANCE
import org.opensearch.common.settings.Settings;
                        );
import java.util.concurrent.atomic.AtomicReference;
                    settings,
import java.util.function.BiFunction;
    }
        ) {
            assertThat(e.getMessage(), equalTo("this node does not have the remote_cluster_client role"));
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(RemoteClusterService.REMOTE_NODE_ATTRIBUTE));
        }
                if (randomBoolean()) {
                .build();
        try (MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT)) {
                        );
                updateSkipUnavailable(service.getRemoteClusterService(), "cluster1", true);
                        assertEquals(
            knownNodes.add(c2N1Node);
                                    } finally {
                }
                    Settings.EMPTY,
        final Settings dedicatedClusterManager = clusterManagerOnlyNode();
                transportService.start();
                        createSettings("cluster_1", Arrays.asList(c1N1Node.getAddress().toString(), c1N2Node.getAddress().toString())),
            Collections.shuffle(knownNodes, random());
                        createSettings("cluster_1", Arrays.asList(c1N1Node.getAddress().toString(), c1N2Node.getAddress().toString())),
 * KIND, either express or implied.  See the License for the
                        "cluster_test",
                            Strings.EMPTY_ARRAY,
                }
                MockTransportService transportService = MockTransportService.createNewService(
import java.util.HashSet;
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(SniffConnectionStrategy.REMOTE_NODE_CONNECTIONS));
        final Version version,
                        CountDownLatch failLatch = new CountDownLatch(1);
            );
                transportService.start();
    public void testGroupClusterIndices() throws IOException {
                        newSeeds.add(node0.getAddress().toString());
            );
                builder.putList("cluster.remote.cluster_1.seed", c1N1Node.getAddress().toString());
            ) {
                        assertEquals(3, perClusterIndices.size());
        }
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
            try (
                    );
    public void testSkipUnavailable() {
                transportService.acceptIncomingRequests();
                                        failLatch.countDown();
                )
    public void testRemoteClusterServiceNotEnabledGetRemoteClusterConnection() {
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);
        final Settings settings
            knownNodes_c1.add(c1N1Node);
                }
            ConnectionManager connectionManager = connection.getConnectionManager();
                    firstLatch.await();
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
    }
                    firstLatch.await();
                    assertTrue(service.isRemoteNodeConnected("cluster_1", c1N2Node));
            }
                            );
                    final CountDownLatch firstLatch = new CountDownLatch(1);
                        IllegalArgumentException iae = expectThrows(
                () -> service.validate(brokenSettingsDependency, true)
            Settings.Builder settingsBuilder = Settings.builder();
            try (
                    );
            Settings settings = settingsBuilder.build();
                    );
        try (
                        createSettings("cluster_test", Collections.singletonList(node0.getAddress().toString())),
                iae.getMessage()
                    initializeRemoteClusters(service);
                        Map<String, OriginalIndices> perClusterIndices = service.groupIndices(
                        assertTrue(ex.get() instanceof NoSuchRemoteClusterException);
                    firstLatch.await();
                    initializeRemoteClusters(service);
 * Unless required by applicable law or agreed to in writing,
        } catch (InterruptedException e) {
                        createSettings("cluster_1", Arrays.asList(c1N1Node.getAddress().toString(), c1N2Node.getAddress().toString())),
                    );
                            IndicesOptions.LENIENT_EXPAND_OPEN,
                        "cluster_2",
                    assertEquals("remote clusters must not have the empty string as its key", iae.getMessage());
            service.start();
 * the Apache License, Version 2.0 (the "License"); you may
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
                () -> RemoteClusterService.REMOTE_CLUSTER_SKIP_UNAVAILABLE.getAllConcreteSettings(brokenSettingsType)
                .build();
                    threadPool,
                }
                            "cluster_2:foo:bar",
    public void testRemoteNodeAttribute() throws IOException, InterruptedException {
                    assertTrue(service.isRemoteClusterRegistered("cluster_1"));
                try (RemoteClusterService service = new RemoteClusterService(settings, transportService)) {
        {
    }
                        assertTrue(firstRemoteClusterConnection.isClosed());
        Settings brokenSettings = Settings.builder().put("cluster.remote.foo.seeds", "192.168.0.1").build();
 */
import org.opensearch.test.transport.MockTransportService;
                    List<String> localIndices = perClusterIndices.remove(RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY);
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);
    public void testDefaultPingSchedule() throws IOException {
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(ProxyConnectionStrategy.REMOTE_SOCKET_CONNECTIONS));
                    );
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                    assertEquals(pingSchedule1, remoteClusterConnection1.getConnectionManager().getConnectionProfile().getPingInterval());
                service.acceptIncomingRequests();
                    NoopTracer.INSTANCE
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
            MockTransportService cluster_node_0 = startTransport("cluster_node_0", knownNodes, Version.CURRENT);
                "Cannot configure setting [cluster.remote.foo.skip_unavailable] if remote cluster is not enabled.",
                    assertBusy(remoteClusterConnection::isClosed);
                            "cluster_1:bar"::equals
                        iae.getMessage()
                                }
                            i -> false
                    assertTrue(service.isCrossClusterSearchEnabled());
                Settings.Builder builder = Settings.builder();
                final Settings.Builder builder = Settings.builder();
                                    assertEquals(c1N1Node, func.apply("cluster_1", c1N1Node.getId()));
        RemoteClusterConnection connection = service.getRemoteClusterConnection(clusterAlias);
                () -> RemoteClusterService.REMOTE_CLUSTER_PING_SCHEDULE.getAllConcreteSettings(brokenSettingsDependency)
                                }
                    }
        }
                            new String[] { "cluster_1:bar", "cluster_2:foo*" },
            knownNodes.add(c1N2Node);
                    service.collectNodes(
import static org.hamcrest.Matchers.instanceOf;
            DiscoveryNode cluster1Seed = cluster1Transport.getLocalDiscoNode();
                builder.putList("cluster.remote.cluster_2.seed", c2N1Node.getAddress().toString());
                IllegalArgumentException.class,
                    assertEquals(0, transportService.getConnectionManager().size());
            }
                                @Override
        ) {
                    assertTrue(service.isRemoteClusterRegistered("cluster_1"));
        try (
                                @Override
                    assertTrue(service.isRemoteClusterRegistered("cluster_2"));
                                        fail("should not be called");
import org.opensearch.common.unit.TimeValue;
    public void tearDown() throws Exception {
            } else {
                            new String[] { "foo:bar", "cluster_1:bar", "cluster_2:foo:bar", "cluster_1:test", "cluster_2:foo*", "foo" },
                    builder.build(),
                            public void onResponse(BiFunction<String, String, DiscoveryNode> func) {
        {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
    public void testReconnectWhenStrategySettingsUpdated() throws Exception {
                    assertTrue(service.isRemoteNodeConnected("cluster_1", c1N2Node));
    }
                    assertTrue(service.isRemoteClusterRegistered("cluster_1"));
                    assertFalse(service.isCrossClusterSearchEnabled());
                                    try {
                    assertTrue(service.isRemoteNodeConnected("cluster_2", c2N2Node));
                        );
                    threadPool,
                    assertFalse(service.getRemoteClusterService().isSkipUnavailable("cluster1"));
                                    latch.countDown();
                    secondLatch.await();
                )
            DiscoveryNode cluster1Seed = cluster1Transport.getLocalDiscoNode();
        }
    public void testGroupIndices() throws IOException {
        try (
            settingsBuilder.putList("cluster.remote.cluster_1.seeds", seedNode.getAddress().toString());
                MockTransportService transportService = MockTransportService.createNewService(
            DiscoveryNode cluster2Seed = cluster2Transport.getLocalDiscoNode();
        Exception e = expectThrows(
                                "no*match:boo" },
 * Licensed to Elasticsearch under one or more contributor
                transportService.acceptIncomingRequests();
        try (
            assertEquals(
                    assertFalse(service.isCrossClusterSearchEnabled());
                    service.updateRemoteCluster(
                    final CountDownLatch firstLatch = new CountDownLatch(1);
            IllegalArgumentException.class,
        } catch (Exception e) {
                    Version.CURRENT,
            knownNodes.add(node1);
                    assertFalse(secondRemoteClusterConnection.isClosed());
        final List<DiscoveryNode> knownNodes,
                        createSettings("cluster_1", Collections.singletonList(seedNode.getAddress().toString()))
                        }
                    assertEquals(0, transportService.getConnectionManager().size());
import org.opensearch.threadpool.TestThreadPool;
                    }).start();
        }
                            }
                    );
            Settings.EMPTY,
    private MockTransportService startTransport(
