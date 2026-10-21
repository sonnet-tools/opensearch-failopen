                    Settings.EMPTY,
                        seedNodes(seedNode),
            DiscoveryNode node = new DiscoveryNode("id", address, Collections.singletonMap("gateway", "true"), allRoles, Version.CURRENT);
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
                        seedNodes(seedNode),
        {
        }
        DiscoveryNode node = new DiscoveryNode("id", address, Collections.emptyMap(), roles, version);
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
            DiscoveryNode coordOnly = new DiscoveryNode("id", address, Collections.emptyMap(), Collections.emptySet(), Version.CURRENT);
                    try (
            knownNodes.add(discoverableNode);
            return newService;
                }
                MockTransportService localService = MockTransportService.createNewService(
                        .build();
            ) {
                                    + "]"
                        3,
        ) {
                        PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
                    assertTrue(strategy.assertNoRunningConnections());
            knownNodes.add(discoverableNode);
                ThreadPool.Names.SAME,
                    assertTrue(strategy.assertNoRunningConnections());
            );
                    assertTrue(connectionManager.nodeConnected(unaddressableSeedNode));
                            localService,
            try (
                    )
 * this work for additional information regarding copyright
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
                dedicatedClusterManagerRoles,
                    NoopTracer.INSTANCE
        Set<DiscoveryNodeRole> allRoles = DiscoveryNodeRole.BUILT_IN_ROLES;
                    assertTrue(multipleResolveLatch.await(30L, TimeUnit.SECONDS));
 * GitHub history for details.
            knownNodes.add(incompatibleSeedNode);
        TransportAddress address = new TransportAddress(TransportAddress.META_ADDRESS, 0);
                    assertEquals(2, connectionManager.size());
    }
                    assertFalse(strategy.shouldRebuildConnection(noChange));
        final Settings s = Settings.builder()
                    SniffConnectionStrategy strategy = new SniffConnectionStrategy(
                MockTransportService localService = MockTransportService.createNewService(
                }
            Collections.shuffle(knownNodes, random());
                    )
                            seedNodes(wrongSeedNode, correctSeedNode),
 * Unless required by applicable law or agreed to in writing,
}
            knownNodes.add(discoverableNode);
                            Settings.EMPTY,
    }
    private static List<String> seedNodes(final DiscoveryNode... seedNodes) {
            unresponsive1.start();
        }
    }
                    Version.CURRENT,
                localService.start();
                    strategy.connect(connectFuture);
        assertThat(nodePredicate.test(node), equalTo(Version.CURRENT.isCompatible(version)));
                Collections.emptyMap(),
                    ) {
                multipleResolveLatch.countDown();
 * SPDX-License-Identifier: Apache-2.0
                    Settings proxyChanged = Settings.builder()
 * Licensed to Elasticsearch under one or more contributor
        }
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
                        Settings noChangeSetting = Settings.builder()
                        strategy.connect(connectFuture);
            }
                    assertTrue(strategy.assertNoRunningConnections());
                    PlainActionFuture<Void> ensureConnectFuture = PlainActionFuture.newFuture();
                    )
                        PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
                        )
        {
                    connectFuture.actionGet();
import java.util.stream.Collectors;
                    assertTrue(connectionManager.nodeConnected(seedNode));
    public void testDiscoverWithSingleIncompatibleSeedNode() {
            try (
        {
            DiscoveryNode noAttrNode = new DiscoveryNode("id", address, Collections.emptyMap(), roles, Version.CURRENT);
            MockTransportService otherSeed = startTransport("other_seed", knownNodes, Version.CURRENT, otherSettings);
    @Override
                        RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
                )
import static org.hamcrest.CoreMatchers.containsString;
import org.opensearch.test.VersionUtils;
            MockTransportService discoverableTransport = startTransport("discoverable_node", knownNodes, Version.CURRENT)
            );
        {
                    } else {
                    threadPool,
                            remoteConnectionManager,
        Settings wrongClusterSettings = Settings.builder().put("cluster.name", "wrong-cluster").build();
            );
            DiscoveryNode seedNode = seedTransport.getLocalNode();
    }
                    Settings.EMPTY,
                            null,
        try (
                        null,
    }
                    NoopTracer.INSTANCE
import org.opensearch.cluster.ClusterName;
                        )
                        null
        service.validate(settings, true);
            ) {
        TransportAddress address = new TransportAddress(TransportAddress.META_ADDRESS, 0);
                        localService,
import org.opensearch.common.settings.AbstractScopedSettings;
import java.util.Arrays;
 * compatible open source license.
                    assertTrue(strategy.shouldRebuildConnection(seedsChanged));
 *
        ) {
            assertEquals(expected, iae.getMessage());
                        clusterAlias,
        super.tearDown();
        try (
                        clusterAlias,
                        null,
                try (
            DiscoveryNode dedicatedIngest = new DiscoveryNode(
                Collections.singletonMap("gateway", "false"),
            Collections.shuffle(knownNodes, random());
                            3,
            Collections.shuffle(knownNodes, random());
                    assertTrue(connectionManager.nodeConnected(discoverableNode));
            MockTransportService wrongClusterTransport = startTransport(
                        discoverableNodeAddress.set(node.getAddress());
                        n -> true,
                        .build();
                            clusterAlias,
        Predicate<DiscoveryNode> nodePredicate = SniffConnectionStrategy.getNodePredicate(settings);
                            localService,
                localService.acceptIncomingRequests();
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
        try (
            MockTransportService unresponsive2 = MockTransportService.createNewService(
                    }
    }
                Collections.singletonMap("gateway", "false"),
            knownNodes.add(discoverableNode);
        Predicate<DiscoveryNode> nodePredicate = SniffConnectionStrategy.getNodePredicate(settings);
                "id",
    }
                    // discovered node and ensure the other discovered node is eventually connected
            assertFalse(nodePredicate.test(node));
 * KIND, either express or implied.  See the License for the
        try (
                        n -> true,
                Version.CURRENT
            knownNodes.add(seedNode);
                        null,
    public void testExpectedClusterNameValidationScenarios() {
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
                    connectFuture.actionGet();
                    Settings.EMPTY,
 *
import org.opensearch.test.transport.MockTransportService;
                wrongClusterSettings
                            Settings.EMPTY,
                address,
            DiscoveryNode otherSeedNode = otherSeed.getLocalNode();
                    strategy.connect(connectFuture);
                address,
            assertFalse(nodePredicate.test(nonGatewayNode));
                            clusterAlias,
        final String id,
                        remoteConnectionManager,
    private final Settings settings = Settings.builder().put(modeKey, "sniff").build();
            knownNodes.add(discoverableNode);
                        discoverableTransport2.close();
        ) {
                        Settings.EMPTY,
                        strategy.connect(connectFuture);
                        localService,
        }
    public void testConnectFailsIfNoConnectionsOpened() {
        Version version = VersionUtils.randomVersion(random());
                + "\"cluster.remote.cluster_name.mode\" [required=SNIFF, configured=PROXY]";
            MockTransportService discoverableTransport2 = startTransport("discoverable_node", knownNodes, Version.CURRENT)
            knownNodes.add(seedNode);
                localService.acceptIncomingRequests();
        List<DiscoveryNode> correctKnownNodes = new CopyOnWriteArrayList<>();
                localService.start();
                // Predicate excludes seed node as a possible connection
                            seedNodes(wrongSeedNode),
            newService.start();
                    Version.CURRENT,
                        seedNodes(seedNode),
                "id",
        for (Tuple<Setting.AffixSetting<?>, String> restrictedSetting : restrictedSettings) {
                    assertBusy(strategy::assertNoRunningConnections);
            Collections.shuffle(knownNodes, random());
                    );
        {
                MockTransportService localService = MockTransportService.createNewService(
                            .build();
                    connectFuture.actionGet();
                address,
            knownNodes.add(seedNode);
        Version incompatibleVersion = Version.CURRENT.minimumCompatibilityVersion().minimumCompatibilityVersion();
                ) {
                    SniffConnectionStrategy strategy = new SniffConnectionStrategy(
        }
            MockTransportService discoverableTransport = startTransport("discoverable_node", knownNodes, Version.CURRENT)
                            Settings.EMPTY,
                )
            correctKnownNodes.add(discoverableNode);
                    assertEquals(proxyAddress, discoverableNodeAddress.get());
            MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT);
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
                localService.start();
                        .put(seedSetting.getKey(), Strings.arrayToCommaDelimitedString(seedNodes(seedNode).toArray()))
            DiscoveryNode discoverableNode = discoverableTransport.getLocalNode();
            assertTrue(SniffConnectionStrategy.getNodePredicate(Settings.EMPTY).test(nonGatewayNode));
                        Settings.EMPTY,
                localService.start();
            MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT);
                    assertTrue(connectionManager.nodeConnected(seedNode));
                            null,
                    ) {
                        remoteConnectionManager,
    public void testSniffStrategyWillConnectToMaxAllowedNodesAndOpenNewConnectionsOnDisconnect() throws Exception {
                Collections.emptyMap(),
                    Settings.EMPTY,
            MockTransportService closedTransport = startTransport("discoverable_node", knownNodes, Version.CURRENT)
            MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT);
                            null,
                        localService,
                dedicatedClusterManagerRoles,
                MockTransportService localService = MockTransportService.createNewService(
                        strategy.connect(connectFuture);
            ) {
            MockTransportService discoverableTransport = startTransport("discoverable_node", knownNodes, Version.CURRENT)
import org.opensearch.common.collect.Tuple;
            DiscoveryNode discoverableNode = unresponsive2.getLocalNode();
                            localService,
                            )
                        clusterAlias,
                    IllegalStateException ise = expectThrows(IllegalStateException.class, newConnect::actionGet);
                    threadPool,
                    connectFuture.actionGet();
                }
                            localService,
                try (
                            .put(seedSetting.getKey(), correctSeedNode.getAddress().toString())
                    SniffConnectionStrategy strategy = new SniffConnectionStrategy(
                        clusterAlias,
            MockTransportService discoverableTransport = startTransport("discoverable_node", correctKnownNodes, Version.CURRENT)
                            clusterAlias,
                        assertBusy(() -> assertTrue(connectionManager.nodeConnected(discoverableNode1)));
                    Setting<?> numConnections = SniffConnectionStrategy.REMOTE_NODE_CONNECTIONS.getConcreteSettingForNamespace(
                    ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
                        3,
                        null,
                    assertTrue(strategy.assertNoRunningConnections());
                try (
                        assertTrue(connectionManager.nodeConnected(discoverableNode1));
                accessibleNode.getHostAddress(),
                roles,
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
        }
                threadPool,
    public void testGetNodePredicatesCombination() {
                    ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
            try (
                        null
                roles,
                // Test 1: Connection fails when only wrong cluster seed is available
                        listener.onFailure(new ConnectTransportException(node, "general failure"));
            Collections.shuffle(otherKnownNodes, random());
            assertFalse(nodePredicate.test(dedicatedClusterManager));
            ) {
                        .put(numConnections.getKey(), 4)
                "id",
                            .getConcreteSettingForNamespace("cluster-alias");
                    )
            assertFalse(nodePredicate.test(node));
                new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE)),
            DiscoveryNode nonGatewayNode = new DiscoveryNode(
            DiscoveryNode node = new DiscoveryNode(
            knownNodes.add(discoverableNode);
                        );
            DiscoveryNode dedicatedData = new DiscoveryNode(
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
            );
    public void testMultipleCallsToConnectEnsuresConnection() {
                        clusterAlias,
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
                            startsWith("handshake with [{cluster-alias#"),
            assertTrue(nodePredicate.test(dedicatedIngest));
                        SniffConnectionStrategy strategy = new SniffConnectionStrategy(
            DiscoveryNode wrongSeedNode = wrongClusterTransport.getLocalNode();
            ) {
                )
                localService.acceptIncomingRequests();
                    threadPool,
                    Version.CURRENT,
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
                newService.close();
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
                {
        ) {
            );
        }
import java.util.HashSet;
                        "cluster-alias"
        {
            .put(ClusterName.CLUSTER_NAME_SETTING.getKey(), clusterAlias)
                    NoopTracer.INSTANCE
    public void testFilterNodesWithNodePredicate() {
            DiscoveryNode discoverableNode1 = discoverableTransport1.getLocalNode();
        ) {
            DiscoveryNode seedNode = seedTransport.getLocalNode();
            try (
        {
            DiscoveryNode gatewayNode = new DiscoveryNode(
    }
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                        localService,
                    }
    ) {
            MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT);
                            "initial-expected-cluster"
                        discoverableTransport1.close();
                    seed.close();
                            n -> true,
        try (
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
                    Settings.EMPTY,
                    Settings.EMPTY,
            DiscoveryNode node = new DiscoveryNode(
                            n -> true,
                new HashSet<>(Arrays.asList(DiscoveryNodeRole.DATA_ROLE)),
            }
                try (
                try (
                AtomicReference<TransportAddress> discoverableNodeAddress = new AtomicReference<>();
                }
                        null
                unresponsive1.getLocalNode().getAddress(),
            try (
                Version.CURRENT,
                "id",
                    assertTrue(connectionManager.nodeConnected(seedNode));
                        localService,
            MockTransportService discoverableTransport = startTransport("discoverable_node", knownNodes, Version.CURRENT)
        MockTransportService newService = MockTransportService.createNewService(s, version, threadPool, NoopTracer.INSTANCE);
                Collections.emptyMap(),
                            remoteConnectionManager,
            knownNodes.add(seedNode);
        TransportAddress address = new TransportAddress(TransportAddress.META_ADDRESS, 0);
                    strategy.connect(connectFuture);
                    Settings seedsChanged = Settings.builder()
                        seedNodes(seedNode),
                    assertFalse(connectionManager.nodeConnected(discoverableNode));
                        Setting<?> seedSetting = SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS.getConcreteSettingForNamespace(
                        clusterAlias,
                    assertFalse(connectionManager.nodeConnected(discoverableNode));
                    Settings.EMPTY,
                // Test 3: Connection succeeds when expected cluster name matches
                        Settings.EMPTY,
                new HashSet<>(Arrays.asList(DiscoveryNodeRole.INGEST_ROLE, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE)),
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
            DiscoveryNode all = new DiscoveryNode("id", address, Collections.emptyMap(), DiscoveryNodeRole.BUILT_IN_ROLES, Version.CURRENT);
                }
                    } else {
import org.opensearch.cluster.node.DiscoveryNodes;
    private final String modeKey = RemoteConnectionStrategy.REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterAlias).getKey();
                    Version.CURRENT,
            MockTransportService seed = startTransport("other_seed", knownNodes, Version.CURRENT);
                )
                    Settings.EMPTY,
                        localService,
                        remoteConnectionManager,
                    for (DiscoveryNode node : knownNodes) {
                        proxyAddress.toString(),
                Collections.singletonMap("gateway", "true"),
                    Settings.EMPTY,
                        SniffConnectionStrategy strategy = new SniffConnectionStrategy(
                    assertTrue(connectionManager.nodeConnected(discoverableNode));
                    Version.CURRENT,
            MockTransportService correctClusterTransport = startTransport("correct_seed", correctKnownNodes, Version.CURRENT);
            DiscoveryNode discoverableNode = discoverableTransport.getLocalNode();
                localService.acceptIncomingRequests();
        }
                + "\" cannot be used with the configured "
                        clusterAlias,
            )
        RemoteConnectionStrategy.ConnectionStrategy proxy = RemoteConnectionStrategy.ConnectionStrategy.PROXY;
                        2,
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
            try (
                address,
                    final IllegalStateException ise = expectThrows(IllegalStateException.class, connectFuture::actionGet);
            MockTransportService incompatibleSeedTransport = startTransport("discoverable_node", knownNodes, incompatibleVersion);
                            expectedClusterName
                    Version.CURRENT,
                    )
            MockTransportService discoverable = startTransport("other_discoverable", knownNodes, Version.CURRENT);
        }
                accessibleNode.getVersion()
 * license agreements. See the NOTICE file distributed with
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
    }
                    strategy.connect(connectFuture);
                        .put(seedSetting.getKey(), Strings.arrayToCommaDelimitedString(seedNodes(seedNode).toArray()))
                new HashSet<>(Arrays.asList(DiscoveryNodeRole.DATA_ROLE, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE)),
            DiscoveryNode seedNode = seedTransport.getLocalNode();
                        allOf(
            MockTransportService accessible = startTransport("seed_node", knownNodes, Version.CURRENT);
            assertTrue(nodePredicate.test(all));
                    assertTrue(connectionManager.nodeConnected(discoverableNode));
                Version.CURRENT,
                    strategy.connect(connectFuture);
                            .put(expectedNameSetting.getKey(), "initial-expected-cluster")
                MockTransportService localService = MockTransportService.createNewService(
        String clusterName = "cluster_name";
                localService.acceptIncomingRequests();
/*
            DiscoveryNode seedNode = seedTransport.getLocalNode();
/*
            MockTransportService otherDiscoverable = startTransport("other_discoverable", knownNodes, Version.CURRENT, otherSettings)
                        3,
            Settings invalid = Settings.builder().put(settings).put(concreteSetting.getKey(), restrictedSetting.v2()).build();
                    connectFuture.actionGet();
                    assertTrue(connectionManager.nodeConnected(discoverableNode));
            );
            .put(settings)
        {
                    assertFalse(connectionManager.nodeConnected(discoverableNode));
                try (
                Collections.emptyMap(),
        ) {
 *
                    assertTrue(strategy.assertNoRunningConnections());
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
            DiscoveryNode seedNode = seed.getLocalNode();
                NoopTracer.INSTANCE
            }
                    assertEquals(2, connectionManager.size());
                // Test 4: Strategy must be rebuilt when expected cluster name changes
                threadPool,
                            3,
                MockTransportService localService = MockTransportService.createNewService(
                        // Rebuild needed if expected cluster name changes
                            .put(seedSetting.getKey(), correctSeedNode.getAddress().toString())
import static org.hamcrest.CoreMatchers.startsWith;
                "id",
        final Settings settings
                NoopTracer.INSTANCE
                        seedNodes(seedNode),
                    if (node.equals(discoverableNode)) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                accessibleNode.getId(),
                    SniffConnectionStrategy strategy = new SniffConnectionStrategy(
                            .put(expectedNameSetting.getKey(), "new-expected-cluster")
                        null
                        localService,
                    )
                    SniffConnectionStrategy strategy = new SniffConnectionStrategy(
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
        try {
                ) {
                    Settings.EMPTY,
                        null
                        clusterAlias,
                    ) {
                        assertTrue(connectionManager.nodeConnected(correctSeedNode));
            MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT);
    public MockTransportService startTransport(
                        RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
    }
                    Settings connectionsChanged = Settings.builder()
                    threadPool,
        try (
import static org.hamcrest.Matchers.equalTo;
 * specific language governing permissions and limitations
                address,
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
    public void testConfiguredProxyAddressModeWillReplaceNodeAddress() {
                    channel.sendResponse(new ClusterStateResponse(clusterName, build, false));
                    Settings.EMPTY,
            try (
            ) {
                        assertFalse(connectionManager.nodeConnected(wrongSeedNode));
            DiscoveryNode ingestData = new DiscoveryNode(
        }
            MockTransportService unresponsive1 = MockTransportService.createNewService(
            );
        try (
                    strategy.connect(connectFuture);
                Version.CURRENT,
                address,
        }
                        null
                localService.acceptIncomingRequests();
                ) {
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
    private final ConnectionProfile profile = RemoteConnectionStrategy.buildConnectionProfile("cluster", settings);
                    assertTrue(connectionManager.nodeConnected(seedNode));
                localService.start();
                )
                    threadPool,
                Version.CURRENT
            DiscoveryNode accessibleNode = accessible.getLocalNode();
                    ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
                        Settings.EMPTY,
                }
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
            Supplier<DiscoveryNode> seedNodeSupplier = () -> {
 * Modifications Copyright OpenSearch Contributors. See
                    ensureConnectFuture.actionGet();
                )
                        Settings.EMPTY,
                        localService,
                localService.start();
    public void testSniffStrategyWillResolveDiscoveryNodesEachConnect() throws Exception {
                    assertTrue(connectionManager.nodeConnected(discoverableNode));
            DiscoveryNode clusterManagerIngest = new DiscoveryNode(
            assertTrue(SniffConnectionStrategy.getNodePredicate(Settings.EMPTY).test(noAttrNode));
                        remoteConnectionManager,
                        )
                ) {
 * software distributed under the License is distributed on an
        }
                    threadPool,
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                }
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
    }
                    connectFuture.actionGet();
                        null,
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
                    assertFalse(connectionManager.nodeConnected(seedNode));
                    threadPool,
                    Version.CURRENT,
            MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT);
        }
        }
 * ownership. Elasticsearch licenses this file to you under
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
            );
                    assertTrue(connectionManager.nodeConnected(seedNode));
                            expectedClusterName
            CountDownLatch multipleResolveLatch = new CountDownLatch(2);
                        assertFalse(connectionManager.nodeConnected(seedNode));
                        null
                    SniffConnectionStrategy strategy = new SniffConnectionStrategy(
                    // Assert that one of the discovered nodes is connected. After that, disconnect the connected
    }
                    )
                wrongClusterKnownNodes,
                    assertTrue(strategy.assertNoRunningConnections());
 * this file be licensed under the Apache-2.0 license or a
                Settings.EMPTY,
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
                localService.acceptIncomingRequests();
            // We start in order to get a valid address + port, but do not start accepting connections as we
                        clusterAlias,
                Collections.emptyMap(),
                            remoteConnectionManager,
                MockTransportService localService = MockTransportService.createNewService(
                    threadPool,
        }
                        .build();
                + concreteSetting.getKey()
                        3,
                localService.acceptIncomingRequests();
        Set<Setting<?>> clusterSettings = new HashSet<>();
                        .put(numConnections.getKey(), 3)
                    connectFuture.actionGet();
            .put("node.name", id)
                try (
                {
            MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT);
                        Settings.EMPTY,
                        n -> n.equals(seedNode) == false,
            DiscoveryNode dedicatedClusterManager = new DiscoveryNode(
            ) {
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        AbstractScopedSettings service = new ClusterSettings(Settings.EMPTY, clusterSettings);
            }
    }
                TransportAddress proxyAddress = accessibleNode.getAddress();
            DiscoveryNode seedNode = seedTransport.getLocalNode();
            DiscoveryNode correctSeedNode = correctClusterTransport.getLocalNode();
                        clusterAlias,
import org.opensearch.test.OpenSearchTestCase;
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
            wrongClusterKnownNodes.add(wrongSeedNode);
    public void tearDown() throws Exception {
                localService.start();
        clusterSettings.addAll(restrictedSettings.stream().map(Tuple::v1).collect(Collectors.toList()));
            String expected = "Setting \""
                        remoteConnectionManager,
        {
                        null,
                    }
        {
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
                        assertBusy(() -> assertTrue(connectionManager.nodeConnected(discoverableNode2)));
import org.opensearch.threadpool.TestThreadPool;
            );
                    assertTrue(strategy.assertNoRunningConnections());
            knownNodes.add(seedNode);
                    strategy.connect(connectFuture);
                )
                new HashSet<>(Arrays.asList(DiscoveryNodeRole.DATA_ROLE, DiscoveryNodeRole.INGEST_ROLE)),
            assertFalse(nodePredicate.test(noAttrNode));
                Collections.emptyMap(),
        {
                            n -> true,
                localService.acceptIncomingRequests();
                    // Connection to discoverable will fail due to the stubbable transport
                        n -> true,
                        // address for later assertion
                Collections.singletonMap("gateway", "true"),
        try (
import org.opensearch.common.settings.Settings;
                    assertTrue(strategy.assertNoRunningConnections());
                        null,
                    threadPool,
                        PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
        Version incompatibleVersion = Version.CURRENT.minimumCompatibilityVersion().minimumCompatibilityVersion();
import org.opensearch.action.admin.cluster.state.ClusterStateAction;
        final Version version,
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
                        n -> true,
                                    + clusterAlias
    }
import java.util.function.Predicate;
                }
                localService.start();
                    strategy.connect(connectFuture);
            assertTrue(nodePredicate.test(dataClusterManager));
                ClusterStateAction.NAME,
            Collections.shuffle(knownNodes, random());
            assertTrue(nodePredicate.test(node));
        try (
        );
                                " failed: remote cluster name [otherCluster] "
                    Setting<?> proxySetting = SniffConnectionStrategy.REMOTE_CLUSTERS_PROXY.getConcreteSettingForNamespace("cluster-alias");
import org.opensearch.common.settings.Setting;
            );
                        // No rebuild needed if expected cluster name stays the same
                        localService,
                ) {
                        localService,
                accessibleNode.getEphemeralId(),
                    expectThrows(Exception.class, connectFuture::actionGet);
                    )
                        Collections.singletonList(seedNodeSupplier),
            new Tuple<>(SniffConnectionStrategy.REMOTE_NODE_CONNECTIONS, "2")
        ClusterName clusterName = ClusterName.CLUSTER_NAME_SETTING.get(s);
            DiscoveryNode unaddressableSeedNode = new DiscoveryNode(
            unresponsive2.start();
            MockTransportService discoverableTransport = startTransport("discoverable_node", knownNodes, Version.CURRENT)
import org.opensearch.threadpool.ThreadPool;
    }
                ) {
            DiscoveryNode rejectedNode = randomBoolean() ? seedNode : discoverableNode;
                address,
                        Settings changedSetting = Settings.builder()
                            Collections.singletonList(() -> wrongSeedNode),
                Collections.singletonMap("gateway", "false"),
                    NoopTracer.INSTANCE
                        null
                            Arrays.asList(() -> wrongSeedNode, () -> correctSeedNode),
    }
                        Settings.EMPTY,
import java.util.List;
            ) {
            DiscoveryNode discoverableNode = closedTransport.getLocalNode();
                    NoopTracer.INSTANCE
    public void testClusterNameValidationPreventConnectingToDifferentClusters() throws Exception {
                        Settings.EMPTY,
                        remoteConnectionManager,
                        assertThat(e.getMessage(), containsString("does not match expected remote cluster name"));
import static org.hamcrest.Matchers.allOf;
                localService.acceptIncomingRequests();
                        builder.add(node);
        Settings settings = Settings.builder()
                        .build();
                    )
                        seedNodes(seedNode),
                    NoopTracer.INSTANCE
                });
                }
                )
            }
            knownNodes.add(seedNode);
                        seedNodes(seedNode),
        Set<DiscoveryNodeRole> dedicatedClusterManagerRoles = new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE));
                accessibleNode.getName(),
                }
                    try (
            try (
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, transport);
                "id",
            assertTrue(nodePredicate.test(coordOnly));
            ) {
            knownNodes.add(incompatibleSeedNode);
                accessibleNode.getRoles(),
                    SniffConnectionStrategy strategy = new SniffConnectionStrategy(
import org.opensearch.test.transport.StubbableTransport;
                    assertTrue(strategy.assertNoRunningConnections());
                "id",
                    // Closing connections leads to RemoteClusterConnection.ConnectHandler.collectRemoteNodes
            newService.acceptIncomingRequests();
                        SniffConnectionStrategy strategy = new SniffConnectionStrategy(
                        SniffConnectionStrategy strategy = new SniffConnectionStrategy(
                        n -> n.equals(rejectedNode) == false,
                        )
            ) {
            DiscoveryNode node = new DiscoveryNode(
                    strategy.connect(connectFuture);
                            "cluster-alias"
            .build();
            knownNodes.add(discoverableNode);
                        assertTrue(connectionManager.nodeConnected(discoverableNode2));
                    }
                        3,
                    SniffConnectionStrategy strategy = new SniffConnectionStrategy(
                    assertFalse(connectionManager.nodeConnected(otherDiscoverableNode));
                )
 */
        Settings settings = Settings.builder().put("cluster.remote.node.attr", "gateway").build();
            DiscoveryNode incompatibleSeedNode = incompatibleSeedTransport.getLocalNode();
                        n -> true,
                List<String> seedNodes = Collections.singletonList(accessibleNode.toString());
                            .build();
                    connectionManager.getConnection(seedNode).close();
                address,
                address,
                        clusterAlias,
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                        3,
                localService.acceptIncomingRequests();
import org.opensearch.cluster.node.DiscoveryNodeRole;
import java.util.concurrent.atomic.AtomicReference;
        }
                    try (
            ) {
                    NoopTracer.INSTANCE
import java.util.Set;
                Version.CURRENT
        {
                            3,
                        seedNodes(incompatibleSeedNode),
                        3,
                        assertFalse(strategy.strategyMustBeRebuilt(noChangeSetting));
    public void testSniffStrategyWillNeedToBeRebuiltIfNumOfConnectionsOrSeedsOrProxyChange() {
                    connectFuture.actionGet();
            knownNodes.add(discoverableNode);
        try (MockTransportService incompatibleSeedTransport = startTransport("seed_node", knownNodes, incompatibleVersion)) {
                try (
            MockTransportService discoverableTransport = startTransport("discoverable_node", knownNodes, Version.CURRENT)
                    assertTrue(strategy.shouldRebuildConnection(connectionsChanged));
                    DiscoveryNodes.Builder builder = DiscoveryNodes.builder();
                    } else {
public class SniffConnectionStrategyTests extends OpenSearchTestCase {
                        // Do not actually try to connect because the node will not respond. Just capture the
        clusterSettings.add(RemoteConnectionStrategy.REMOTE_CONNECTION_MODE);
                        assertTrue(connectionManager.nodeConnected(discoverableNode));
                        remoteConnectionManager,
                {
                    assertTrue(connectionManager.nodeConnected(discoverableNode));
                    assertTrue(strategy.assertNoRunningConnections());
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
            Collections.shuffle(knownNodes, random());
        {
                        remoteConnectionManager,
            try (
                        assertTrue(connectionManager.nodeConnected(discoverableNode));
                "id",
                        .put(seedSetting.getKey(), Strings.arrayToCommaDelimitedString(seedNodes(discoverableNode).toArray()))
    public void testGetNodePredicateNodeAttrs() {
                        n -> true,
                    ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
import org.opensearch.cluster.node.DiscoveryNode;
            assertFalse(nodePredicate.test(node));
        return Arrays.stream(seedNodes).map(s -> s.getAddress().toString()).collect(Collectors.toList());
                    NoopTracer.INSTANCE
                        RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
                    assertTrue(strategy.assertNoRunningConnections());
        return startTransport(id, knownNodes, version, Settings.EMPTY);
                        .put(seedSetting.getKey(), Strings.arrayToCommaDelimitedString(seedNodes(seedNode).toArray()))
                Version.CURRENT
                    NoopTracer.INSTANCE
            assertTrue(nodePredicate.test(gatewayNode));
                    assertTrue(connectionManager.nodeConnected(seedNode));
                {
import java.util.concurrent.TimeUnit;
                MockTransportService localService = MockTransportService.createNewService(
                localService.start();
    }
            .put(RemoteConnectionStrategy.REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterName).getKey(), proxy.name())
        Predicate<DiscoveryNode> nodePredicate = SniffConnectionStrategy.getNodePredicate(Settings.EMPTY);
                            clusterAlias,
        }
        }
            Collections.shuffle(knownNodes, random());
import org.opensearch.action.support.PlainActionFuture;
            }
                            null,
            DiscoveryNode discoverableNode = discoverableTransport.getLocalNode();
    public void testSniffStrategyWillConnectToAndDiscoverNodes() {
            assertTrue(SniffConnectionStrategy.getNodePredicate(Settings.EMPTY).test(gatewayNode));
            try (
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
        Predicate<DiscoveryNode> nodePredicate = SniffConnectionStrategy.getNodePredicate(Settings.EMPTY);
        }
                    SniffConnectionStrategy strategy = new SniffConnectionStrategy(
            try (
import org.opensearch.core.common.transport.TransportAddress;
                    NoopTracer.INSTANCE
                    Version.CURRENT,
        }
                "id",
    private MockTransportService startTransport(String id, List<DiscoveryNode> knownNodes, Version version) {
                "id",
            knownNodes.add(seedNode);
    }
                Version.CURRENT
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
            DiscoveryNode seedNode = seedTransport.getLocalNode();
                        assertTrue(connectionManager.nodeConnected(seedNode));
        ) {
                    if (connectionManager.nodeConnected(discoverableNode1)) {
            );
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
                    }
            Collections.shuffle(knownNodes, random());
                    NoopTracer.INSTANCE
            ) {
                    if (rejectedNode.equals(seedNode)) {
                transport.setDefaultConnectBehavior((delegate, node, profile, listener) -> {
        // Should validate successfully
            DiscoveryNode discoverableNode = discoverableTransport.getLocalNode();
        }
    private final String clusterAlias = "cluster-alias";
                    Version.CURRENT,
                // Test 2: Connection succeeds by falling back to correct seed after wrong seed fails
                    // exec again we are already connected
            MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT);
                address,
                    assertFalse(connectionManager.nodeConnected(incompatibleSeedNode));
                accessibleNode.getAttributes(),
                StubbableTransport transport = new StubbableTransport(localService.transport);
                    try (
                Version.CURRENT
                            n -> true,
        }
                    threadPool,
                        assertFalse(connectionManager.nodeConnected(wrongSeedNode));
                        )
            }
                    )
package org.opensearch.transport;
import java.util.Collections;
        List<Tuple<Setting.AffixSetting<?>, String>> restrictedSettings = Arrays.asList(
                "wrong_seed",
            new Tuple<>(SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS, "192.168.0.1:8080"),
import org.opensearch.Version;
        }
        Set<DiscoveryNodeRole> roles = DiscoveryNodeRole.BUILT_IN_ROLES;
            // will not actually connect to these transports
            DiscoveryNode discoverableNode = discoverableTransport.getLocalNode();
            newService.registerRequestHandler(
                    Version.CURRENT,
                        connectFuture.actionGet();
                accessibleNode.getHostName(),
                            Settings.EMPTY,
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
 * under the License.
                try (
                }
                    assertTrue(strategy.assertNoRunningConnections());
                    }
 * You may obtain a copy of the License at
/*
                    threadPool,
                        assertTrue(connectionManager.nodeConnected(correctSeedNode));
            DiscoveryNode seedNode = seedTransport.getLocalNode();
        try (
            }
                    SniffConnectionStrategy strategy = new SniffConnectionStrategy(
 * not use this file except in compliance with the License.
            }
                    }
            success = true;
        Settings otherSettings = Settings.builder().put("cluster.name", "otherCluster").build();
                    Settings noChange = Settings.builder()
                ) {
    public void testConnectFailsWithIncompatibleNodes() {
                        Settings.EMPTY,
                            seedNodes(correctSeedNode),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            DiscoveryNode discoverableNode2 = discoverableTransport2.getLocalNode();
                ClusterStateRequest::new,
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                ) {
                        remoteConnectionManager,
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                        Exception e = expectThrows(Exception.class, connectFuture::actionGet);
        final List<DiscoveryNode> knownNodes,
    public void testModeSettingsCannotBeUsedWhenInDifferentMode() {
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
                localService.start();
                    strategy.connect(connectFuture);
            closedTransport.close();
                Version.CURRENT
            );
            DiscoveryNode seedNode = seedTransport.getLocalNode();
                                    + "does not match expected remote cluster name ["
                        remoteConnectionManager,
        List<DiscoveryNode> wrongClusterKnownNodes = new CopyOnWriteArrayList<>();
                        3,
                            expectedClusterName
                        seedNodes,
                        null,
                MockTransportService localService = MockTransportService.createNewService(
 */
                localService.start();
                    );
 * The OpenSearch Contributors require contributions made to
                        seedNodes(seedNode, otherSeedNode),
    }
                    assertEquals("Unable to open any connections to remote cluster [cluster-alias]", ise.getMessage());
    }
                    assertFalse(connectionManager.nodeConnected(otherSeedNode));
            }
                    threadPool,
                MockTransportService localService = MockTransportService.createNewService(
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
                    Setting<?> seedSetting = SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS.getConcreteSettingForNamespace("cluster-alias");
                    assertTrue(connectionManager.nodeConnected(seedNode));
            DiscoveryNode discoverableNode = discoverableTransport.getLocalNode();
import java.util.concurrent.CountDownLatch;
                        assertFalse(connectionManager.nodeConnected(discoverableNode));
        {
 * the Apache License, Version 2.0 (the "License"); you may
                    assertTrue(connectionManager.nodeConnected(discoverableNode));
            // Use the address for the node that will not respond
            DiscoveryNode discoverableNode = discoverableTransport.getLocalNode();
                Version.CURRENT
                            3,
                    assertTrue(strategy.assertNoRunningConnections());
                    strategy.connect(newConnect);
            knownNodes.add(seedNode);
        ) {
                        remoteConnectionManager,
        }
            knownNodes.add(unaddressableSeedNode);
    }
                address,
            try (
            knownNodes.add(discoverableNode1);
            DiscoveryNode dataClusterManager = new DiscoveryNode(
                    )
                    strategy.connect(connectFuture);
                }
            );
                Settings.EMPTY,
    public void testGetNodePredicateNodeRoles() {
        }
            );
                    assertFalse(connectionManager.nodeConnected(unaddressableSeedNode));
                    ClusterState build = ClusterState.builder(clusterName).nodes(builder.build()).build();
            );
        } finally {
                        n -> true,
                    ) {
            .build();
            assertTrue(nodePredicate.test(ingestData));
                }
                        Settings.EMPTY,
                        assertTrue(strategy.strategyMustBeRebuilt(changedSetting));
            DiscoveryNode otherDiscoverableNode = otherDiscoverable.getLocalNode();
                    assertThat(
                        null,
                        n -> true,
                }
                        seedNodes(seedNode),
                localService.start();
                    assertTrue(strategy.shouldRebuildConnection(proxyChanged));
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
            }
            }
        ) {
                    PlainActionFuture<Void> newConnect = PlainActionFuture.newFuture();
            DiscoveryNode incompatibleSeedNode = incompatibleSeedTransport.getLocalNode();
                ) {
import java.util.function.Supplier;
            assertTrue(nodePredicate.test(clusterManagerIngest));
                        delegate.openConnection(node, profile, listener);
                ) {
        Settings settings = Settings.builder().put("cluster.remote.node.attr", "gateway").build();
import static org.hamcrest.Matchers.endsWith;
                        Settings.EMPTY,
                    Version.CURRENT,
            IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> service.validate(invalid, true));
                }
                    assertFalse(connectionManager.nodeConnected(incompatibleSeedNode));
        }
                        connectFuture.actionGet();
            correctKnownNodes.add(correctSeedNode);
        String expectedClusterName = clusterAlias; // Use the default cluster alias as expected name
                MockTransportService localService = MockTransportService.createNewService(
            Setting<?> concreteSetting = restrictedSetting.v1().getConcreteSettingForNamespace(clusterName);
                            endsWith(
                        .put(proxySetting.getKey(), "proxy_address:9300")
                        null
                (request, channel, task) -> {
                try (
import org.opensearch.common.settings.ClusterSettings;
                )
                            Collections.singletonList(() -> correctSeedNode),
                    connectFuture.actionGet();
                )
                        n -> true,
                    }
                            Collections.singletonList(() -> correctSeedNode),
        Set<DiscoveryNodeRole> roles = DiscoveryNodeRole.BUILT_IN_ROLES;
                dedicatedClusterManagerRoles,
                    NoopTracer.INSTANCE
                    assertFalse(connectionManager.nodeConnected(seedNode));
                        null
                new HashSet<>(Arrays.asList(DiscoveryNodeRole.INGEST_ROLE)),
        }
            };
                ) {
    public void testGetNodePredicateNodeVersion() {
                localService.acceptIncomingRequests();
import java.util.concurrent.CopyOnWriteArrayList;
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
                            remoteConnectionManager,
        boolean success = false;
import org.opensearch.core.common.Strings;
                    SniffConnectionStrategy strategy = new SniffConnectionStrategy(
                }
        List<DiscoveryNode> otherKnownNodes = new CopyOnWriteArrayList<>();
                        3,
                    Settings.EMPTY,
        }
            knownNodes.add(discoverableNode);
            if (success == false) {
        ) {
                "id",
                        3,
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
        }
                        null,
        ) {
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
 */
                        localService,
                try (
                )
            MockTransportService discoverableTransport1 = startTransport("discoverable_node", knownNodes, Version.CURRENT);
        try (
                            seedNodes(correctSeedNode),
                return seedNode;
                    assertTrue(connectionManager.nodeConnected(discoverableNode));
            knownNodes.add(discoverableNode2);
            DiscoveryNode discoverableNode = discoverable.getLocalNode();
                        ise.getMessage(),
                        assertTrue(connectionManager.nodeConnected(discoverableNode));
                        RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
                Version.CURRENT
            assertTrue(nodePredicate.test(dedicatedData));
                Version.CURRENT
                        Setting<?> expectedNameSetting = SniffConnectionStrategy.REMOTE_CLUSTER_EXPECTED_NAME
        {
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
                        null
                    Version.CURRENT,
            Collections.shuffle(knownNodes, random());
                MockTransportService localService = MockTransportService.createNewService(
                Version.CURRENT
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
                    strategy.connect(ensureConnectFuture);
        TransportAddress address = new TransportAddress(TransportAddress.META_ADDRESS, 0);
import org.opensearch.cluster.ClusterState;
            }
