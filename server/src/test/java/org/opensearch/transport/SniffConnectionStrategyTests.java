        ) {
                {
    }  
                    DiscoveryNodes.Builder builder = DiscoveryNodes.builder();
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
                    )
    public void testConnectFailsIfNoConnectionsOpened() {  
                        SniffConnectionStrategy strategy = new SniffConnectionStrategy(
                    Setting<?> numConnections = SniffConnectionStrategy.REMOTE_NODE_CONNECTIONS.getConcreteSettingForNamespace(
import java.util.function.Predicate;
                        Settings.EMPTY,  
                        RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
                        localService,  
                        assertTrue(connectionManager.nodeConnected(discoverableNode));  
            DiscoveryNode incompatibleSeedNode = incompatibleSeedTransport.getLocalNode();  
import java.util.Arrays;
                {
    public void testGetNodePredicatesCombination() {
                        clusterAlias,
            )
                        3,  
                    NoopTracer.INSTANCE
                            seedNodes(wrongSeedNode),
                        SniffConnectionStrategy strategy = new SniffConnectionStrategy(  
        {
    public void testSniffStrategyWillNeedToBeRebuiltIfNumOfConnectionsOrSeedsOrProxyChange() {
            Collections.shuffle(knownNodes, random());  
                        Exception e = expectThrows(Exception.class, connectFuture::actionGet);  
        List<DiscoveryNode> wrongClusterKnownNodes = new CopyOnWriteArrayList<>();  
        {
        Settings otherSettings = Settings.builder().put("cluster.name", "otherCluster").build();
import org.opensearch.common.settings.ClusterSettings;
                        null
                        assertTrue(connectionManager.nodeConnected(seedNode));  
        MockTransportService newService = MockTransportService.createNewService(s, version, threadPool, NoopTracer.INSTANCE);
                            clusterAlias,  
                    PlainActionFuture<Void> ensureConnectFuture = PlainActionFuture.newFuture();
        {
                unresponsive1.getLocalNode().getAddress(),
                        Settings.EMPTY,  
            newService.start();
                        null
            String expected = "Setting \""  
                    assertFalse(strategy.shouldRebuildConnection(noChange));
                MockTransportService localService = MockTransportService.createNewService(
                        Settings.EMPTY,
        }  
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);  
                    SniffConnectionStrategy strategy = new SniffConnectionStrategy(
                    strategy.connect(connectFuture);
                    Version.CURRENT,  
        Set<DiscoveryNodeRole> dedicatedClusterManagerRoles = new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE));  
                }
        TransportAddress address = new TransportAddress(TransportAddress.META_ADDRESS, 0);  
    @Override
        try (  
                    NoopTracer.INSTANCE
            DiscoveryNode discoverableNode = unresponsive2.getLocalNode();
                localService.acceptIncomingRequests();
                        null,
                        null
        {
                        3,
                        .put(seedSetting.getKey(), Strings.arrayToCommaDelimitedString(seedNodes(seedNode).toArray()))
            knownNodes.add(seedNode);  
 * license agreements. See the NOTICE file distributed with
        String expectedClusterName = clusterAlias; // Use the default cluster alias as expected name  
                Settings.EMPTY,  
                    SniffConnectionStrategy strategy = new SniffConnectionStrategy(
            DiscoveryNode gatewayNode = new DiscoveryNode(  
            assertTrue(nodePredicate.test(gatewayNode));
                    strategy.connect(connectFuture);  
            DiscoveryNode discoverableNode = discoverableTransport.getLocalNode();
                }  
                    NoopTracer.INSTANCE
        }  
            Collections.shuffle(knownNodes, random());  
                    strategy.connect(connectFuture);  
                        PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
public class SniffConnectionStrategyTests extends OpenSearchTestCase {  
            newService.acceptIncomingRequests();
            MockTransportService discoverableTransport2 = startTransport("discoverable_node", knownNodes, Version.CURRENT)
                        n -> true,
import org.opensearch.core.common.Strings;
                StubbableTransport transport = new StubbableTransport(localService.transport);
            assertFalse(nodePredicate.test(node));
                    Version.CURRENT,
                    Settings.EMPTY,  
import org.opensearch.test.transport.StubbableTransport;
        }
                )
import org.opensearch.Version;
            DiscoveryNode discoverableNode2 = discoverableTransport2.getLocalNode();
                Collections.emptyMap(),  
                    threadPool,  
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
import java.util.concurrent.atomic.AtomicReference;
/*  
        clusterSettings.add(RemoteConnectionStrategy.REMOTE_CONNECTION_MODE);
    }
                address,  
    }  
                            n -> true,  
        try (
                )
                            seedNodes(correctSeedNode),
import org.opensearch.cluster.ClusterName;  
                        seedNodes(seedNode),
                            remoteConnectionManager,  
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
                        // No rebuild needed if expected cluster name stays the same
                        seedNodes(seedNode),
                        remoteConnectionManager,  
                    )  
                }
                    );
                        localService,
                            null,
                    )
            }  
        ) {
        AbstractScopedSettings service = new ClusterSettings(Settings.EMPTY, clusterSettings);  
                )  
            DiscoveryNode nonGatewayNode = new DiscoveryNode(
                Settings.EMPTY,  
    public void testDiscoverWithSingleIncompatibleSeedNode() {  
                        null  
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
            );
                ) {  
 * under the License.  
                localService.acceptIncomingRequests();
        {  
                }
import org.opensearch.test.OpenSearchTestCase;
import static org.hamcrest.CoreMatchers.startsWith;
import org.opensearch.common.collect.Tuple;
                    // Closing connections leads to RemoteClusterConnection.ConnectHandler.collectRemoteNodes
            DiscoveryNode discoverableNode = discoverableTransport.getLocalNode();
            MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT);
import org.opensearch.threadpool.TestThreadPool;
        try (  
            MockTransportService closedTransport = startTransport("discoverable_node", knownNodes, Version.CURRENT)
        }  
                accessibleNode.getHostAddress(),
    }
            DiscoveryNode discoverableNode = discoverableTransport.getLocalNode();  
                Version.CURRENT,  
                    connectionManager.getConnection(seedNode).close();
            knownNodes.add(discoverableNode);
                // Test 4: Strategy must be rebuilt when expected cluster name changes
                    assertTrue(strategy.assertNoRunningConnections());
            try (
        final Version version,  
                                    + "does not match expected remote cluster name ["
            }
                        localService,
                    assertThat(
                "id",
    private final Settings settings = Settings.builder().put(modeKey, "sniff").build();
                        "cluster-alias"  
            MockTransportService correctClusterTransport = startTransport("correct_seed", correctKnownNodes, Version.CURRENT);  
                try (  
                        null
            try (
                transport.setDefaultConnectBehavior((delegate, node, profile, listener) -> {
 * Unless required by applicable law or agreed to in writing,
                localService.start();
                "id",  
                        assertTrue(connectionManager.nodeConnected(discoverableNode2));  
                            clusterAlias,
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
                dedicatedClusterManagerRoles,
            Settings invalid = Settings.builder().put(settings).put(concreteSetting.getKey(), restrictedSetting.v2()).build();
        ) {
                    }
        Settings settings = Settings.builder().put("cluster.remote.node.attr", "gateway").build();
                    ) {
                            endsWith(  
    public MockTransportService startTransport(  
            knownNodes.add(seedNode);
    public void testMultipleCallsToConnectEnsuresConnection() {
                    assertFalse(connectionManager.nodeConnected(discoverableNode));
            knownNodes.add(unaddressableSeedNode);
        final String id,
                        Settings.EMPTY,
                localService.start();  
                        PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();  
                "id",  
                    assertFalse(connectionManager.nodeConnected(discoverableNode));  
                        .build();  
            Collections.shuffle(otherKnownNodes, random());
                    connectFuture.actionGet();  
            MockTransportService discoverableTransport = startTransport("discoverable_node", knownNodes, Version.CURRENT)
                            localService,
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
                Collections.emptyMap(),
    }
                        3,
                    }
        RemoteConnectionStrategy.ConnectionStrategy proxy = RemoteConnectionStrategy.ConnectionStrategy.PROXY;
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
                wrongClusterKnownNodes,
    public void testSniffStrategyWillResolveDiscoveryNodesEachConnect() throws Exception {  
                    threadPool,
                    NoopTracer.INSTANCE
            MockTransportService discoverableTransport = startTransport("discoverable_node", knownNodes, Version.CURRENT)
                threadPool,
                }
                            .getConcreteSettingForNamespace("cluster-alias");
                accessibleNode.getName(),  
    }
                    assertTrue(connectionManager.nodeConnected(discoverableNode));
                    assertTrue(connectionManager.nodeConnected(discoverableNode));  
                localService.acceptIncomingRequests();
                        assertTrue(connectionManager.nodeConnected(discoverableNode));
            DiscoveryNode dedicatedClusterManager = new DiscoveryNode(  
                            "cluster-alias"
            MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT);  
    public void testGetNodePredicateNodeVersion() {
            }
                    threadPool,  
                        Settings.EMPTY,
                        strategy.connect(connectFuture);
                }  
                    assertTrue(strategy.assertNoRunningConnections());
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
                        assertFalse(connectionManager.nodeConnected(wrongSeedNode));
        }
                new HashSet<>(Arrays.asList(DiscoveryNodeRole.DATA_ROLE)),
                    Version.CURRENT,
                    Setting<?> seedSetting = SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS.getConcreteSettingForNamespace("cluster-alias");  
                Version.CURRENT  
            Collections.shuffle(knownNodes, random());
        }
                    assertTrue(strategy.assertNoRunningConnections());
import static org.hamcrest.Matchers.equalTo;
            DiscoveryNode dedicatedIngest = new DiscoveryNode(
                address,  
            DiscoveryNode dataClusterManager = new DiscoveryNode(
                    try (  
            ) {
                    connectFuture.actionGet();
        ) {
                Version.CURRENT,
                    ) {  
                localService.start();
                ) {
        try (
                    assertEquals("Unable to open any connections to remote cluster [cluster-alias]", ise.getMessage());
                    Settings.EMPTY,
                    final IllegalStateException ise = expectThrows(IllegalStateException.class, connectFuture::actionGet);
            knownNodes.add(discoverableNode);
                    Settings.EMPTY,  
                }
                    }  
                    SniffConnectionStrategy strategy = new SniffConnectionStrategy(
        try (
                    assertTrue(strategy.shouldRebuildConnection(seedsChanged));
            MockTransportService discoverableTransport = startTransport("discoverable_node", correctKnownNodes, Version.CURRENT)
                Collections.singletonMap("gateway", "false"),
            try (
                new HashSet<>(Arrays.asList(DiscoveryNodeRole.DATA_ROLE, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE)),  
    }  
                MockTransportService localService = MockTransportService.createNewService(
            DiscoveryNode seedNode = seedTransport.getLocalNode();  
                        .build();
                    assertTrue(strategy.assertNoRunningConnections());
                        discoverableTransport1.close();  
 * the Apache License, Version 2.0 (the "License"); you may
    private final ConnectionProfile profile = RemoteConnectionStrategy.buildConnectionProfile("cluster", settings);
                    assertFalse(connectionManager.nodeConnected(unaddressableSeedNode));
                        3,
                        assertFalse(connectionManager.nodeConnected(seedNode));  
                        assertTrue(connectionManager.nodeConnected(discoverableNode1));
                NoopTracer.INSTANCE  
            DiscoveryNode all = new DiscoveryNode("id", address, Collections.emptyMap(), DiscoveryNodeRole.BUILT_IN_ROLES, Version.CURRENT);
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
                    SniffConnectionStrategy strategy = new SniffConnectionStrategy(  
                + "\"cluster.remote.cluster_name.mode\" [required=SNIFF, configured=PROXY]";  
            assertTrue(nodePredicate.test(coordOnly));  
                        n -> true,  
    public void testExpectedClusterNameValidationScenarios() {
                localService.start();
            }
                            localService,
            DiscoveryNode node = new DiscoveryNode(
                "id",
            MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT);
                    assertTrue(connectionManager.nodeConnected(seedNode));
                // Predicate excludes seed node as a possible connection
            assertTrue(nodePredicate.test(ingestData));
                    } else {
            );
            );
            ) {  
            );  
                try (  
        ) {
                    } else {
 *
        super.tearDown();
                        )
        }  
            DiscoveryNode seedNode = seedTransport.getLocalNode();  
        boolean success = false;  
                        clusterAlias,  
                    if (connectionManager.nodeConnected(discoverableNode1)) {
                    threadPool,  
                    }  
                        strategy.connect(connectFuture);
            ) {
                        .put(numConnections.getKey(), 4)
 * GitHub history for details.
        TransportAddress address = new TransportAddress(TransportAddress.META_ADDRESS, 0);
                        n -> true,  
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
                            3,  
                    Version.CURRENT,
            DiscoveryNode discoverableNode = discoverable.getLocalNode();
                ClusterStateAction.NAME,
                        PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();  
                localService.acceptIncomingRequests();
                        SniffConnectionStrategy strategy = new SniffConnectionStrategy(
            Supplier<DiscoveryNode> seedNodeSupplier = () -> {
        }
                    assertFalse(connectionManager.nodeConnected(otherSeedNode));
                        connectFuture.actionGet();  
                        null
                            3,
                    connectFuture.actionGet();  
                    Version.CURRENT,  
                TransportAddress proxyAddress = accessibleNode.getAddress();
                            3,
                    assertTrue(strategy.assertNoRunningConnections());
                    // exec again we are already connected  
                    assertEquals(proxyAddress, discoverableNodeAddress.get());
/*  
import static org.hamcrest.Matchers.endsWith;  
                }
                    SniffConnectionStrategy strategy = new SniffConnectionStrategy(
            }
                try (
                dedicatedClusterManagerRoles,
            );  
                )  
                        .put(seedSetting.getKey(), Strings.arrayToCommaDelimitedString(seedNodes(discoverableNode).toArray()))  
        Predicate<DiscoveryNode> nodePredicate = SniffConnectionStrategy.getNodePredicate(Settings.EMPTY);
                            .build();  
            DiscoveryNode discoverableNode = closedTransport.getLocalNode();
            .put(RemoteConnectionStrategy.REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterName).getKey(), proxy.name())  
                Collections.singletonMap("gateway", "true"),  
        List<DiscoveryNode> otherKnownNodes = new CopyOnWriteArrayList<>();
                    assertTrue(connectionManager.nodeConnected(discoverableNode));
                    NoopTracer.INSTANCE
                        seedNodes(incompatibleSeedNode),
        }  
import org.opensearch.cluster.node.DiscoveryNodeRole;  
                Collections.singletonMap("gateway", "true"),  
import org.opensearch.common.settings.AbstractScopedSettings;  
                        3,
                        // Do not actually try to connect because the node will not respond. Just capture the  
                                    + clusterAlias  
import org.opensearch.action.support.PlainActionFuture;
                "id",
                localService.acceptIncomingRequests();  
                            null,  
            knownNodes.add(incompatibleSeedNode);  
            Collections.shuffle(knownNodes, random());
                "wrong_seed",
            MockTransportService discoverableTransport1 = startTransport("discoverable_node", knownNodes, Version.CURRENT);  
                    )
                    }
            .put("node.name", id)  
                    strategy.connect(ensureConnectFuture);
                        .put(numConnections.getKey(), 3)
            unresponsive1.start();
import java.util.stream.Collectors;
                }
                            expectedClusterName  
            MockTransportService otherSeed = startTransport("other_seed", knownNodes, Version.CURRENT, otherSettings);  
            try (
        {  
                Version.CURRENT
                    connectFuture.actionGet();
            knownNodes.add(incompatibleSeedNode);
                ) {
                        3,
                        // address for later assertion
            new Tuple<>(SniffConnectionStrategy.REMOTE_NODE_CONNECTIONS, "2")
        }
                        builder.add(node);
    }
                (request, channel, task) -> {
                            remoteConnectionManager,  
                    assertTrue(connectionManager.nodeConnected(discoverableNode));  
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
                }
                Version.CURRENT  
                        seedNodes(seedNode),
                    SniffConnectionStrategy strategy = new SniffConnectionStrategy(
            MockTransportService incompatibleSeedTransport = startTransport("discoverable_node", knownNodes, incompatibleVersion);
                MockTransportService localService = MockTransportService.createNewService(
                    threadPool,
        }
                try (
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                        remoteConnectionManager,
        }  
            knownNodes.add(seedNode);
            DiscoveryNode wrongSeedNode = wrongClusterTransport.getLocalNode();  
        }  
            DiscoveryNode seedNode = seedTransport.getLocalNode();
                            expectedClusterName  
                    NoopTracer.INSTANCE  
            assertTrue(nodePredicate.test(dedicatedIngest));
                    assertTrue(strategy.assertNoRunningConnections());
                    threadPool,
        try {
            }  
                "id",
            );  
                "id",  
                        3,
            DiscoveryNode discoverableNode = discoverableTransport.getLocalNode();
                MockTransportService localService = MockTransportService.createNewService(
            }
    private static List<String> seedNodes(final DiscoveryNode... seedNodes) {
                        remoteConnectionManager,
                        null  
                    ClusterState build = ClusterState.builder(clusterName).nodes(builder.build()).build();  
                        null,  
                dedicatedClusterManagerRoles,  
            );
                        RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
            knownNodes.add(discoverableNode1);
            );
                        seedNodes(seedNode),
        clusterSettings.addAll(restrictedSettings.stream().map(Tuple::v1).collect(Collectors.toList()));
            assertFalse(nodePredicate.test(nonGatewayNode));
                    assertTrue(connectionManager.nodeConnected(seedNode));
            }
                Version.CURRENT,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        clusterAlias,  
    public void testConnectFailsWithIncompatibleNodes() {
            wrongClusterKnownNodes.add(wrongSeedNode);  
import java.util.List;
                localService.acceptIncomingRequests();  
                Version.CURRENT
        ) {  
                    }
 *
            Collections.shuffle(knownNodes, random());
                List<String> seedNodes = Collections.singletonList(accessibleNode.toString());  
                localService.start();
                    assertTrue(connectionManager.nodeConnected(seedNode));  
                            .put(seedSetting.getKey(), correctSeedNode.getAddress().toString())
                Version.CURRENT
                        seedNodes(seedNode),  
                    SniffConnectionStrategy strategy = new SniffConnectionStrategy(
                            clusterAlias,
                localService.start();
            knownNodes.add(discoverableNode);
            };
                        null,  
            Collections.shuffle(knownNodes, random());  
            }
import org.opensearch.cluster.node.DiscoveryNode;
                    assertTrue(connectionManager.nodeConnected(discoverableNode));  
                        3,  
                    strategy.connect(connectFuture);
                        localService,
                accessibleNode.getId(),
                    Settings.EMPTY,
            MockTransportService otherDiscoverable = startTransport("other_discoverable", knownNodes, Version.CURRENT, otherSettings)
                        n -> true,
                    assertTrue(strategy.shouldRebuildConnection(connectionsChanged));  
                Version.CURRENT  
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                        clusterAlias,  
                        null
                ClusterStateRequest::new,  
                        connectFuture.actionGet();
                    Version.CURRENT,  
            Collections.shuffle(knownNodes, random());  
import org.opensearch.cluster.ClusterState;
        }
            assertTrue(SniffConnectionStrategy.getNodePredicate(Settings.EMPTY).test(gatewayNode));
            try (  
            ) {
                MockTransportService localService = MockTransportService.createNewService(
                address,
                Version.CURRENT
            ) {  
        Predicate<DiscoveryNode> nodePredicate = SniffConnectionStrategy.getNodePredicate(settings);
                        Settings.EMPTY,
                try (  
import org.opensearch.test.VersionUtils;
                ) {  
            assertFalse(nodePredicate.test(node));  
                        .build();
                localService.start();  
            DiscoveryNode seedNode = seedTransport.getLocalNode();
            assertFalse(nodePredicate.test(node));
        }
            }
            knownNodes.add(discoverableNode2);
 * not use this file except in compliance with the License.
                address,
                        Setting<?> expectedNameSetting = SniffConnectionStrategy.REMOTE_CLUSTER_EXPECTED_NAME
                Collections.emptyMap(),
                        discoverableNodeAddress.set(node.getAddress());
                    connectFuture.actionGet();  
                MockTransportService localService = MockTransportService.createNewService(  
                ThreadPool.Names.SAME,
                        n -> true,
                        null
                // Test 2: Connection succeeds by falling back to correct seed after wrong seed fails  
                Version.CURRENT
        {  
            DiscoveryNode coordOnly = new DiscoveryNode("id", address, Collections.emptyMap(), Collections.emptySet(), Version.CURRENT);
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
                    assertTrue(connectionManager.nodeConnected(seedNode));  
        {
        {  
                )
            ) {  
                MockTransportService localService = MockTransportService.createNewService(  
                    assertTrue(strategy.assertNoRunningConnections());  
        Predicate<DiscoveryNode> nodePredicate = SniffConnectionStrategy.getNodePredicate(Settings.EMPTY);
        }
                            null,  
                        clusterAlias,
                        localService,
                        Settings.EMPTY,
                        remoteConnectionManager,
                try (  
    }  
                            Collections.singletonList(() -> correctSeedNode),  
                    assertTrue(strategy.assertNoRunningConnections());
                    strategy.connect(connectFuture);
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);  
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
                "id",
            knownNodes.add(discoverableNode);
        return Arrays.stream(seedNodes).map(s -> s.getAddress().toString()).collect(Collectors.toList());  
                new HashSet<>(Arrays.asList(DiscoveryNodeRole.DATA_ROLE, DiscoveryNodeRole.INGEST_ROLE)),
                }
                            null,
                    connectFuture.actionGet();
                    assertTrue(multipleResolveLatch.await(30L, TimeUnit.SECONDS));
            knownNodes.add(discoverableNode);  
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());  
                "id",
                        localService,
                            Settings.EMPTY,
        Settings wrongClusterSettings = Settings.builder().put("cluster.name", "wrong-cluster").build();
            ) {
        Version incompatibleVersion = Version.CURRENT.minimumCompatibilityVersion().minimumCompatibilityVersion();
        }
            knownNodes.add(seedNode);  
    ) {
                    Settings.EMPTY,
                        null,  
import java.util.Set;  
            );
            DiscoveryNode correctSeedNode = correctClusterTransport.getLocalNode();
                address,
                roles,
                MockTransportService localService = MockTransportService.createNewService(
                            .build();
                    assertTrue(connectionManager.nodeConnected(seedNode));
                        null
        try (
                    assertEquals(2, connectionManager.size());
 * SPDX-License-Identifier: Apache-2.0
            return newService;
                            startsWith("handshake with [{cluster-alias#"),
                    threadPool,
                MockTransportService localService = MockTransportService.createNewService(  
                localService.acceptIncomingRequests();
                        )  
                    NoopTracer.INSTANCE  
                    strategy.connect(connectFuture);  
                        // Rebuild needed if expected cluster name changes
    }
            DiscoveryNode otherDiscoverableNode = otherDiscoverable.getLocalNode();  
                MockTransportService localService = MockTransportService.createNewService(
            );  
                    assertTrue(connectionManager.nodeConnected(seedNode));
            try (  
                    threadPool,
        final Settings s = Settings.builder()
        Settings settings = Settings.builder()
                        assertBusy(() -> assertTrue(connectionManager.nodeConnected(discoverableNode1)));
            knownNodes.add(seedNode);
        final List<DiscoveryNode> knownNodes,
                            remoteConnectionManager,
                    } else {
 *  
            DiscoveryNode dedicatedData = new DiscoveryNode(  
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
            new Tuple<>(SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS, "192.168.0.1:8080"),
    private final String clusterAlias = "cluster-alias";
import org.opensearch.common.settings.Settings;  
            Collections.shuffle(knownNodes, random());
                    assertFalse(connectionManager.nodeConnected(incompatibleSeedNode));  
    public void testGetNodePredicateNodeAttrs() {
                Collections.emptyMap(),
                        seedNodes(seedNode, otherSeedNode),
            .put(ClusterName.CLUSTER_NAME_SETTING.getKey(), clusterAlias)
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();  
                address,
 *    http://www.apache.org/licenses/LICENSE-2.0
                }
                    Version.CURRENT,  
/*
        }
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();  
                // Test 1: Connection fails when only wrong cluster seed is available  
                }  
            assertTrue(nodePredicate.test(dedicatedData));
            MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT);  
                        clusterAlias,
                    Version.CURRENT,
                            .put(expectedNameSetting.getKey(), "initial-expected-cluster")
                accessibleNode.getEphemeralId(),
        Version version = VersionUtils.randomVersion(random());
                try (
                            n -> true,  
                    if (node.equals(discoverableNode)) {
 * ownership. Elasticsearch licenses this file to you under  
                    strategy.connect(connectFuture);
            assertFalse(nodePredicate.test(noAttrNode));  
                            .put(seedSetting.getKey(), correctSeedNode.getAddress().toString())  
        assertThat(nodePredicate.test(node), equalTo(Version.CURRENT.isCompatible(version)));
                    ) {
            knownNodes.add(discoverableNode);
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);  
                Collections.singletonMap("gateway", "false"),
        }
                        3,
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
import org.opensearch.cluster.node.DiscoveryNodes;
                localService.acceptIncomingRequests();  
                    )  
                    try (
                        assertBusy(() -> assertTrue(connectionManager.nodeConnected(discoverableNode2)));
                }  
        try (  
 */
                    assertTrue(connectionManager.nodeConnected(seedNode));  
                Version.CURRENT
                        assertTrue(connectionManager.nodeConnected(discoverableNode));  
            unresponsive2.start();  
                MockTransportService localService = MockTransportService.createNewService(
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, transport);
                    Settings proxyChanged = Settings.builder()  
                    IllegalStateException ise = expectThrows(IllegalStateException.class, newConnect::actionGet);
                    )  
        Version incompatibleVersion = Version.CURRENT.minimumCompatibilityVersion().minimumCompatibilityVersion();
            DiscoveryNode discoverableNode = discoverableTransport.getLocalNode();
                    strategy.connect(connectFuture);
        ) {
            );
                        n -> n.equals(rejectedNode) == false,
    }  
                        assertTrue(connectionManager.nodeConnected(correctSeedNode));
                    NoopTracer.INSTANCE
                        n -> true,
            DiscoveryNode seedNode = seedTransport.getLocalNode();
                    Settings seedsChanged = Settings.builder()
    }
                ) {  
                try (
                    threadPool,  
            }  
                )  
            Setting<?> concreteSetting = restrictedSetting.v1().getConcreteSettingForNamespace(clusterName);  
            assertTrue(nodePredicate.test(clusterManagerIngest));  
        {
import java.util.concurrent.CopyOnWriteArrayList;
                            Settings.EMPTY,
                    assertTrue(strategy.assertNoRunningConnections());
                        localService,  
    public void testConfiguredProxyAddressModeWillReplaceNodeAddress() {
                        ise.getMessage(),  
                    Version.CURRENT,
                        localService,
                    Setting<?> proxySetting = SniffConnectionStrategy.REMOTE_CLUSTERS_PROXY.getConcreteSettingForNamespace("cluster-alias");
                try (
        }
                        n -> true,  
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                        2,
                    strategy.connect(newConnect);  
            assertTrue(SniffConnectionStrategy.getNodePredicate(Settings.EMPTY).test(noAttrNode));
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
                    )
                ) {
                wrongClusterSettings
                localService.start();
                        Settings.EMPTY,
                    Settings noChange = Settings.builder()  
                            "initial-expected-cluster"
import org.opensearch.action.admin.cluster.state.ClusterStateAction;
            try (
                    // Assert that one of the discovered nodes is connected. After that, disconnect the connected
    private MockTransportService startTransport(String id, List<DiscoveryNode> knownNodes, Version version) {
            MockTransportService discoverable = startTransport("other_discoverable", knownNodes, Version.CURRENT);
            ) {
            DiscoveryNode ingestData = new DiscoveryNode(
            MockTransportService discoverableTransport = startTransport("discoverable_node", knownNodes, Version.CURRENT)  
                                    + "]"
            try (  
                Version.CURRENT
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
                    threadPool,
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;  
                        allOf(
                        SniffConnectionStrategy strategy = new SniffConnectionStrategy(  
                    assertFalse(connectionManager.nodeConnected(discoverableNode));  
                        remoteConnectionManager,
            knownNodes.add(seedNode);
                        null,  
            DiscoveryNode clusterManagerIngest = new DiscoveryNode(
                    assertTrue(connectionManager.nodeConnected(unaddressableSeedNode));
import java.util.concurrent.CountDownLatch;
                    assertFalse(connectionManager.nodeConnected(seedNode));  
        ClusterName clusterName = ClusterName.CLUSTER_NAME_SETTING.get(s);  
                    )  
                        seedNodes,
        {  
            CountDownLatch multipleResolveLatch = new CountDownLatch(2);  
        try (MockTransportService incompatibleSeedTransport = startTransport("seed_node", knownNodes, incompatibleVersion)) {
                        null,
                            3,  
                + concreteSetting.getKey()
        }
                    assertBusy(strategy::assertNoRunningConnections);  
            assertEquals(expected, iae.getMessage());
                        3,
 * compatible open source license.
                    connectFuture.actionGet();  
        {
    }
        TransportAddress address = new TransportAddress(TransportAddress.META_ADDRESS, 0);
                    assertTrue(strategy.assertNoRunningConnections());
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                        assertTrue(connectionManager.nodeConnected(correctSeedNode));
                    );
            MockTransportService seed = startTransport("other_seed", knownNodes, Version.CURRENT);
                        Settings.EMPTY,
                    assertTrue(strategy.assertNoRunningConnections());  
            try (  
                ) {
 * KIND, either express or implied.  See the License for the
                NoopTracer.INSTANCE  
                ) {
            assertTrue(nodePredicate.test(all));
            );
import java.util.HashSet;
            MockTransportService unresponsive1 = MockTransportService.createNewService(
                    Settings connectionsChanged = Settings.builder()
                    connectFuture.actionGet();
                    SniffConnectionStrategy strategy = new SniffConnectionStrategy(
            assertTrue(nodePredicate.test(node));
 * this file be licensed under the Apache-2.0 license or a
                Collections.singletonMap("gateway", "false"),
                ) {
        Set<DiscoveryNodeRole> roles = DiscoveryNodeRole.BUILT_IN_ROLES;  
            MockTransportService wrongClusterTransport = startTransport(  
            try (
            try (
import org.opensearch.common.settings.Setting;
                        clusterAlias,  
                MockTransportService localService = MockTransportService.createNewService(  
                )  
                            remoteConnectionManager,
            Collections.shuffle(knownNodes, random());
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
        ) {
        service.validate(settings, true);  
        }  
        }
                localService.acceptIncomingRequests();  
        for (Tuple<Setting.AffixSetting<?>, String> restrictedSetting : restrictedSettings) {
                    strategy.connect(connectFuture);
            assertTrue(nodePredicate.test(dataClusterManager));  
    public void tearDown() throws Exception {  
                    PlainActionFuture<Void> newConnect = PlainActionFuture.newFuture();
                address,  
                localService.acceptIncomingRequests();
package org.opensearch.transport;
        ) {  
                            localService,
                    connectFuture.actionGet();
            ) {
        );  
                        Settings.EMPTY,  
 */  
            assertTrue(SniffConnectionStrategy.getNodePredicate(Settings.EMPTY).test(nonGatewayNode));  
 */  
                {
                });
                    ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
            DiscoveryNode otherSeedNode = otherSeed.getLocalNode();
    }
                    SniffConnectionStrategy strategy = new SniffConnectionStrategy(
            .put(settings)
                    Settings.EMPTY,  
        List<Tuple<Setting.AffixSetting<?>, String>> restrictedSettings = Arrays.asList(  
            knownNodes.add(discoverableNode);  
    private final String modeKey = RemoteConnectionStrategy.REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterAlias).getKey();  
            success = true;  
                localService.start();
                "id",
                        n -> true,  
                roles,
import java.util.concurrent.TimeUnit;  
                        null,  
                        null  
                        .build();  
            closedTransport.close();  
                    Settings.EMPTY,
                )  
                    Settings.EMPTY,
                        null,
            if (success == false) {  
                try (  
 * software distributed under the License is distributed on an
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
                    strategy.connect(connectFuture);  
            MockTransportService discoverableTransport = startTransport("discoverable_node", knownNodes, Version.CURRENT)  
            knownNodes.add(discoverableNode);
            DiscoveryNode noAttrNode = new DiscoveryNode("id", address, Collections.emptyMap(), roles, Version.CURRENT);
    public void testSniffStrategyWillConnectToMaxAllowedNodesAndOpenNewConnectionsOnDisconnect() throws Exception {
        // Should validate successfully
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
            DiscoveryNode seedNode = seedTransport.getLocalNode();  
            assertFalse(nodePredicate.test(dedicatedClusterManager));
                localService.acceptIncomingRequests();  
 * Modifications Copyright OpenSearch Contributors. See
                Version.CURRENT  
            DiscoveryNode seedNode = seed.getLocalNode();  
                accessibleNode.getHostName(),  
        Set<DiscoveryNodeRole> allRoles = DiscoveryNodeRole.BUILT_IN_ROLES;
        String clusterName = "cluster_name";
            );
                    ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);  
                        listener.onFailure(new ConnectTransportException(node, "general failure"));  
import static org.hamcrest.CoreMatchers.containsString;  
                threadPool,
                ) {
                )
            MockTransportService accessible = startTransport("seed_node", knownNodes, Version.CURRENT);
}
        Set<DiscoveryNodeRole> roles = DiscoveryNodeRole.BUILT_IN_ROLES;  
                Collections.emptyMap(),  
        Settings settings = Settings.builder().put("cluster.remote.node.attr", "gateway").build();
            DiscoveryNode accessibleNode = accessible.getLocalNode();
                )
            DiscoveryNode node = new DiscoveryNode("id", address, Collections.singletonMap("gateway", "true"), allRoles, Version.CURRENT);  
 * The OpenSearch Contributors require contributions made to  
    public void testGetNodePredicateNodeRoles() {  
                    Settings.EMPTY,
                        )
                            )
                        delegate.openConnection(node, profile, listener);
                return seedNode;  
                localService.start();
            try (  
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                    ) {  
    public void testFilterNodesWithNodePredicate() {
                            n -> true,
            MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT);
                        assertFalse(connectionManager.nodeConnected(discoverableNode));
                Collections.emptyMap(),
            knownNodes.add(seedNode);  
                    threadPool,
                        assertFalse(connectionManager.nodeConnected(wrongSeedNode));
                        n -> true,  
                        Settings noChangeSetting = Settings.builder()
                    try (  
                newService.close();
import java.util.function.Supplier;  
                    assertTrue(connectionManager.nodeConnected(discoverableNode));
                        null,
                        remoteConnectionManager,
                    assertTrue(strategy.assertNoRunningConnections());
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
                        remoteConnectionManager,
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
                        localService,  
            ) {  
            correctKnownNodes.add(discoverableNode);
                        remoteConnectionManager,  
                        RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
        try (  
                        Settings.EMPTY,
                    }  
            DiscoveryNode discoverableNode = discoverableTransport.getLocalNode();
            }
                    }
            );  
            MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT);
            DiscoveryNode discoverableNode = discoverableTransport.getLocalNode();
import java.util.Collections;  
    }
            DiscoveryNode discoverableNode1 = discoverableTransport1.getLocalNode();
 * Licensed to Elasticsearch under one or more contributor  
                        Settings changedSetting = Settings.builder()  
            MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT);  
                    // Connection to discoverable will fail due to the stubbable transport
                address,
                )
            DiscoveryNode incompatibleSeedNode = incompatibleSeedTransport.getLocalNode();  
        {
        try (
                        assertFalse(strategy.strategyMustBeRebuilt(noChangeSetting));  
            // We start in order to get a valid address + port, but do not start accepting connections as we  
            DiscoveryNode unaddressableSeedNode = new DiscoveryNode(
            }
            newService.registerRequestHandler(  
 * You may obtain a copy of the License at  
                }
                accessibleNode.getRoles(),
        DiscoveryNode node = new DiscoveryNode("id", address, Collections.emptyMap(), roles, version);  
                        seedNodes(seedNode),  
                    assertFalse(connectionManager.nodeConnected(otherDiscoverableNode));  
                        Setting<?> seedSetting = SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS.getConcreteSettingForNamespace(
            DiscoveryNode seedNode = seedTransport.getLocalNode();
                            Arrays.asList(() -> wrongSeedNode, () -> correctSeedNode),
                    ensureConnectFuture.actionGet();  
    public void testModeSettingsCannotBeUsedWhenInDifferentMode() {
                    ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);  
                        localService,
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
        }  
                    )  
                    Version.CURRENT,  
                accessibleNode.getVersion()
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
                    assertTrue(strategy.shouldRebuildConnection(proxyChanged));
                    threadPool,
                localService.acceptIncomingRequests();
                    assertEquals(2, connectionManager.size());
            DiscoveryNode node = new DiscoveryNode(
                    assertFalse(connectionManager.nodeConnected(seedNode));  
import org.opensearch.core.common.transport.TransportAddress;
    }  
                        Collections.singletonList(seedNodeSupplier),
                    Settings.EMPTY,
                        strategy.connect(connectFuture);
            MockTransportService discoverableTransport = startTransport("discoverable_node", knownNodes, Version.CURRENT)
                        discoverableTransport2.close();
import static org.hamcrest.Matchers.allOf;
                                " failed: remote cluster name [otherCluster] "
                            Collections.singletonList(() -> wrongSeedNode),
            MockTransportService discoverableTransport = startTransport("discoverable_node", knownNodes, Version.CURRENT)
                    Settings.EMPTY,
    public void testClusterNameValidationPreventConnectingToDifferentClusters() throws Exception {  
                    NoopTracer.INSTANCE
                    for (DiscoveryNode node : knownNodes) {  
                    expectThrows(Exception.class, connectFuture::actionGet);
                            n -> true,
                        seedNodes(seedNode),
                    Version.CURRENT,
                    channel.sendResponse(new ClusterStateResponse(clusterName, build, false));
                        localService,
                        remoteConnectionManager,
                        RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
        TransportAddress address = new TransportAddress(TransportAddress.META_ADDRESS, 0);
                    assertFalse(connectionManager.nodeConnected(incompatibleSeedNode));
            MockTransportService seedTransport = startTransport("seed_node", knownNodes, Version.CURRENT);
                    // discovered node and ensure the other discovered node is eventually connected  
                    Version.CURRENT,
            correctKnownNodes.add(correctSeedNode);
                address,
                new HashSet<>(Arrays.asList(DiscoveryNodeRole.INGEST_ROLE, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE)),  
                    ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
                        );  
        ) {
                        )
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);  
            .build();
                // Test 3: Connection succeeds when expected cluster name matches
            DiscoveryNode node = new DiscoveryNode(  
        try (  
                    assertTrue(connectionManager.nodeConnected(discoverableNode));
            knownNodes.add(seedNode);
                multipleResolveLatch.countDown();
        try (
                            .put(expectedNameSetting.getKey(), "new-expected-cluster")
                    SniffConnectionStrategy strategy = new SniffConnectionStrategy(  
                new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE)),
 * this work for additional information regarding copyright
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();  
        }
    }
                            Settings.EMPTY,
                            Settings.EMPTY,
            ) {
                        assertThat(e.getMessage(), containsString("does not match expected remote cluster name"));
                        null,
        {
                            localService,
                    assertTrue(connectionManager.nodeConnected(discoverableNode));  
    }  
                        .put(seedSetting.getKey(), Strings.arrayToCommaDelimitedString(seedNodes(seedNode).toArray()))
                            expectedClusterName
                    )
                        seedNodes(seedNode),  
        Predicate<DiscoveryNode> nodePredicate = SniffConnectionStrategy.getNodePredicate(settings);
                    Settings.EMPTY,
                    NoopTracer.INSTANCE
    public void testSniffStrategyWillConnectToAndDiscoverNodes() {  
                + "\" cannot be used with the configured "
                    if (rejectedNode.equals(seedNode)) {
                AtomicReference<TransportAddress> discoverableNodeAddress = new AtomicReference<>();  
                        clusterAlias,
                    SniffConnectionStrategy strategy = new SniffConnectionStrategy(
                "id",
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();  
        }  
                    strategy.connect(connectFuture);
    }  
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);  
                address,  
                        clusterAlias,  
                localService.start();
                        .put(proxySetting.getKey(), "proxy_address:9300")
                            seedNodes(wrongSeedNode, correctSeedNode),
                        remoteConnectionManager,
                    seed.close();
                        assertTrue(strategy.strategyMustBeRebuilt(changedSetting));
                        )
            // Use the address for the node that will not respond
    }
                }  
            );  
            .build();
                address,
                    NoopTracer.INSTANCE  
                {
                    assertTrue(strategy.assertNoRunningConnections());
            MockTransportService unresponsive2 = MockTransportService.createNewService(
        ) {
                        proxyAddress.toString(),  
            DiscoveryNode seedNode = seedTransport.getLocalNode();  
                ) {
                            seedNodes(correctSeedNode),
                    try (
            IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> service.validate(invalid, true));
        }
                    )
            knownNodes.add(discoverableNode);  
            DiscoveryNode rejectedNode = randomBoolean() ? seedNode : discoverableNode;
                )
                        n -> n.equals(seedNode) == false,  
                new HashSet<>(Arrays.asList(DiscoveryNodeRole.INGEST_ROLE)),
                accessibleNode.getAttributes(),  
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
        return startTransport(id, knownNodes, version, Settings.EMPTY);  
                            clusterAlias,  
                        clusterAlias,  
                            Collections.singletonList(() -> correctSeedNode),  
        }  
        {
                try (  
            ) {
        final Settings settings
                        .put(seedSetting.getKey(), Strings.arrayToCommaDelimitedString(seedNodes(seedNode).toArray()))  
                localService.start();  
        Set<Setting<?>> clusterSettings = new HashSet<>();  
 * specific language governing permissions and limitations
                    NoopTracer.INSTANCE
    }
                        remoteConnectionManager,
        List<DiscoveryNode> correctKnownNodes = new CopyOnWriteArrayList<>();
import org.opensearch.test.transport.MockTransportService;  
import org.opensearch.threadpool.ThreadPool;  
        }
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();  
            // will not actually connect to these transports
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();  
                        clusterAlias,
        } finally {
