    public void testProxyStrategyWillResolveAddressesEachConnect() throws Exception {
            Setting<?> concreteSetting = restrictedSetting.v1().getConcreteSettingForNamespace(clusterName);
            }
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
                    )
                    assertTrue(strategy.assertNoRunningConnections());
            try (
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
        try (
 * license agreements. See the NOTICE file distributed with
                        localService,
    }
 * not use this file except in compliance with the License.
                    threadPool,
        } finally {
                    useAddress1.set(false);
    }
                        localService,
        try (MockTransportService transport1 = startTransport("node1", Version.CURRENT, bindSettings)) {
                        .put(modeSetting.getKey(), "proxy")
                    Settings.EMPTY,
                        numOfConnections,
                            .filter(n -> n.getAddress().equals(address2))
    }
    }
                try (
                        numOfConnections,
                    Settings noChange = Settings.builder()
import org.opensearch.common.settings.Settings;
                        assertFalse(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address1)));
                    assertTrue(strategy.assertNoRunningConnections());
 * KIND, either express or implied.  See the License for the
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
                        long finalConnectionsToTransport2 = connectionManager.getAllConnectedNodes()
                )
        try (MockTransportService transport1 = startTransport("node1", Version.CURRENT)) {
                        .put(addressesSetting.getKey(), remoteAddress.toString())
            ) {
                )
                    threadPool,
                        null
                        assertNotEquals(0, finalConnectionsToTransport2);
                int numOfConnections = randomIntBetween(4, 8);
                localService.start();
        List<Tuple<Setting.AffixSetting<?>, String>> restrictedSettings = Arrays.asList(
 */
import org.opensearch.threadpool.ThreadPool;
        super.tearDown();
                localService.start();
                + "\" cannot be used with the configured "
                ) {
            }
                        assertTrue(strategy.assertNoRunningConnections());
                    threadPool,
                        numOfConnections,
                        address1.toString(),
        return () -> {
                        assertTrue(strategy.assertNoRunningConnections());
 * SPDX-License-Identifier: Apache-2.0
                AtomicBoolean useAddress1 = new AtomicBoolean(true);
                return address1;
                    );
        for (Tuple<Setting.AffixSetting<?>, String> restrictedSetting : restrictedSettings) {
                + "\"cluster.remote.cluster_name.mode\" [required=PROXY, configured=SNIFF]";
 * the Apache License, Version 2.0 (the "License"); you may
                    strategy.connect(connectFuture);
                    assertFalse(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address1)));
                    strategy.connect(connectFuture);
                    DiscoveryNode discoveryNode = connectionManager.getAllConnectedNodes().stream().findFirst().get();
        TransportAddress address2,
                        numOfConnections,
        boolean success = false;
                    ProxyConnectionStrategy strategy = new ProxyConnectionStrategy(
                        Settings.EMPTY,
                        "server-name"
                        "cluster-alias"
                ) {
        }
                }
            ) {
    private Supplier<TransportAddress> alternatingResolver(
import org.opensearch.test.OpenSearchTestCase;
        );
                    NoopTracer.INSTANCE
                localService.start();
                        assertFalse(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address1)));
                        null
 *    http://www.apache.org/licenses/LICENSE-2.0
                    });
                    assertTrue(multipleResolveLatch.await(30L, TimeUnit.SECONDS));
                        .filter(n -> n.getAddress().equals(address2))
            TransportAddress address1 = transport1.boundAddress().publishAddress();
                            .count();
            assertEquals(expected, iae.getMessage());
            }
                    )
 */
            ) {
            } else {
                        localService,
                    transport1.close();
        }
 * Modifications Copyright OpenSearch Contributors. See
                + concreteSetting.getKey()
            Supplier<TransportAddress> addressSupplier = () -> {
                    assertEquals("localhost", discoveryNode.getAttributes().get("server_name"));
            }
                    threadPool,
        Settings bindSettings = Settings.builder().put(TransportSettings.BIND_HOST.getKey(), "localhost").build();
                        localService,
    @Override
                try (
                    ProxyConnectionStrategy strategy = new ProxyConnectionStrategy(
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                    connectFuture.actionGet();
import org.opensearch.cluster.node.DiscoveryNode;
import java.util.stream.Collectors;
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
                        clusterAlias,
                    connectFuture.actionGet();
                        alternatingResolver(address1, address2, useAddress1),
                        localService,
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
import java.util.List;
                        assertEquals(0, connectionManager.size());
            Settings invalid = Settings.builder().put(settings).put(concreteSetting.getKey(), restrictedSetting.v2()).build();
                    assertTrue(strategy.shouldRebuildConnection(serverNameChange));
                String address = "localhost:" + address1.getPort();
                        Settings.EMPTY,
                localService.acceptIncomingRequests();
            .build();
    private final String clusterAlias = "cluster-alias";
                int numOfConnections = randomIntBetween(4, 8);
                    strategy.connect(connectFuture);
            .put(ClusterName.CLUSTER_NAME_SETTING.getKey(), clusterAlias)
            IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> service.validate(invalid, true));
        }
import org.opensearch.cluster.ClusterName;
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
    public void testModeSettingsCannotBeUsedWhenInDifferentMode() {
 * Unless required by applicable law or agreed to in writing,
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
                }
import java.util.Arrays;
/*
            MockTransportService transport2 = startTransport("cluster2", Version.CURRENT, otherSettings)
        ) {
        return startTransport(id, version, Settings.EMPTY);
    public MockTransportService startTransport(final String id, final Version version, final Settings settings) {
                        remoteConnectionManager,
                        .put(socketConnections.getKey(), numOfConnections)
                        clusterAlias,
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
                        .put(modeSetting.getKey(), "proxy")
                    assertTrue(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address1)));
                MockTransportService localService = MockTransportService.createNewService(
                    assertTrue(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address1)));
                    assertTrue(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address1)));
                localService.start();
                        remoteAddress.toString(),
package org.opensearch.transport;
                    Version.CURRENT,
                    assertEquals(numOfConnections, connectionManager.size());
            try (
    ) {
                        address1.toString()
        RemoteConnectionStrategy.ConnectionStrategy sniff = RemoteConnectionStrategy.ConnectionStrategy.SNIFF;
            CountDownLatch multipleResolveLatch = new CountDownLatch(2);
                    Settings.EMPTY,
                        remoteConnectionManager,
                localService.acceptIncomingRequests();
    private MockTransportService startTransport(String id, Version version) {
 */
        service.validate(settings, true);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        localService,
                ) {
                        address1.toString()
                        numOfConnections,
    public void testConnectFailsWithIncompatibleNodes() {
                    assertBusy(() -> {
            TransportAddress address1 = transport1.boundAddress().publishAddress();
                    )
                    long initialConnectionsToTransport2 = connectionManager.getAllConnectedNodes()
 * software distributed under the License is distributed on an
            if (success == false) {
import org.opensearch.common.collect.Tuple;
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
                localService.start();
                        assertEquals(numOfConnections, connectionManager.size());
                        clusterAlias,
                    Settings.EMPTY,
                    )
                    Settings.EMPTY,
                        remoteConnectionManager,
                        .put(addressesSetting.getKey(), remoteAddress.toString())
                        null
            try (
import org.opensearch.action.support.PlainActionFuture;
                    strategy.connect(connectFuture);
            new Tuple<>(ProxyConnectionStrategy.REMOTE_SOCKET_CONNECTIONS, "3")
                    ProxyConnectionStrategy strategy = new ProxyConnectionStrategy(
            .put(settings)
                return address;
            }
                    ProxyConnectionStrategy strategy = new ProxyConnectionStrategy(
            try (
            }
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
                int numOfConnections = randomIntBetween(4, 8);
                        long finalConnectionsToTransport2 = connectionManager.getAllConnectedNodes()
                        remoteConnectionManager,
                )
                        "cluster-alias"
                        .put(addressesSetting.getKey(), remoteAddress.toString())
                        Settings.EMPTY,
    public void testClusterNameValidationPreventConnectingToDifferentClusters() throws Exception {
                multipleResolveLatch.countDown();
    public void tearDown() throws Exception {
 * specific language governing permissions and limitations
                    Settings addressesChanged = Settings.builder()
import org.opensearch.common.settings.ClusterSettings;
                    assertEquals(numOfConnections, connectionManager.size());
                        Settings.EMPTY,
                        .stream()
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
                        .build();
            newService.acceptIncomingRequests();
        Settings settings = Settings.builder()
                    assertTrue(strategy.shouldRebuildConnection(addressesChanged));
                localService.acceptIncomingRequests();
                    threadPool,
            TransportAddress address1 = transport1.boundAddress().publishAddress();
                    assertFalse(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address2)));
        }
                    Setting<?> modeSetting = RemoteConnectionStrategy.REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(
            .build();
                        address,
                int numOfConnections = randomIntBetween(4, 8);
                    assertFalse(strategy.shouldRebuildConnection(noChange));
                ) {
        AtomicBoolean useAddress1
        MockTransportService newService = MockTransportService.createNewService(s, version, threadPool, NoopTracer.INSTANCE);
                    transport1.close();
                    assertBusy(() -> {
    public void testServerNameAttributes() {
                        address1.toString(),
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
                    assertTrue(strategy.assertNoRunningConnections());
                )
        Settings otherSettings = Settings.builder().put("cluster.name", "otherCluster").build();
                        address.toString(),
                    Version.CURRENT,
                ) {
                    remoteConnectionManager.getAnyRemoteConnection().close();
 * You may obtain a copy of the License at
                        .put(socketConnections.getKey(), numOfConnections + 1)
                        numOfConnections,
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
                localService.acceptIncomingRequests();
        }
                        remoteConnectionManager,
            return newService;
                try (
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
                MockTransportService localService = MockTransportService.createNewService(
                try (
    private final String modeKey = RemoteConnectionStrategy.REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterAlias).getKey();
                        remoteConnectionManager,
                int numOfConnections = randomIntBetween(4, 8);
                        clusterAlias,
                            .stream()
                    ProxyConnectionStrategy strategy = new ProxyConnectionStrategy(
                    )
                            .filter(n -> n.getAddress().equals(address2))
 * Licensed to Elasticsearch under one or more contributor
        Set<Setting<?>> clusterSettings = new HashSet<>();
    }
 *
            ) {
import java.util.concurrent.atomic.AtomicBoolean;
        }
                            .count();
            newService.start();
    }
            try (
        }
                try (
import org.opensearch.threadpool.TestThreadPool;
                )
                    Settings.EMPTY,
 *
                    expectThrows(Exception.class, connectFuture::actionGet);
                    Version.CURRENT,
                        Settings.EMPTY,
                        // Connections not pointing to transport2 because the cluster name is different
                        Settings.EMPTY,
                    assertFalse(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address2)));
                    assertFalse(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address2)));
        AbstractScopedSettings service = new ClusterSettings(Settings.EMPTY, clusterSettings);
public class ProxyConnectionStrategyTests extends OpenSearchTestCase {
            MockTransportService transport2 = startTransport("node2", Version.CURRENT)
                    connectFuture.actionGet();
        final Settings s = Settings.builder()
                return address2;
                        clusterAlias,
            success = true;
                    assertTrue(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(remoteAddress)));
import java.util.function.Supplier;
                    Version.CURRENT,
                }
                    });
            TransportAddress address2 = transport2.boundAddress().publishAddress();
            TransportAddress address1 = transport1.boundAddress().publishAddress();
                        // Connections now pointing to transport2
                MockTransportService localService = MockTransportService.createNewService(
        TransportAddress address1,
            };
                }
            ) {
                    Settings.EMPTY,
                        .build();
                    NoopTracer.INSTANCE
                localService.start();
        String clusterName = "cluster_name";
            if (useAddress1.get()) {
                    assertFalse(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address1)));
        try (MockTransportService remoteTransport = startTransport("node1", Version.CURRENT)) {
            try (
                        .build();
}
                    Version.CURRENT,
                MockTransportService localService = MockTransportService.createNewService(
                localService.acceptIncomingRequests();
    private final ConnectionProfile profile = RemoteConnectionStrategy.buildConnectionProfile("cluster", settings);
                )
            new Tuple<>(ProxyConnectionStrategy.PROXY_ADDRESS, "192.168.0.1:8080"),
 *
                        remoteConnectionManager,
                try (
                    Settings.EMPTY,
                        numOfConnections,
                        "localhost"
                    );
        try (MockTransportService transport1 = startTransport("seed_node", Version.CURRENT)) {
            }
                    Version.CURRENT,
                        .put(modeSetting.getKey(), "proxy")
                        clusterAlias,
                    assertEquals(numOfConnections, connectionManager.size());
                            .stream()
                        .put(modeSetting.getKey(), "proxy")
                        .put(addressesSetting.getKey(), remoteAddress.toString())
    }
                    )
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
                        clusterAlias,
    }
import java.util.Set;
            }
                        .put(serverName.getKey(), "server-name2")
                    Version.CURRENT,
                    NoopTracer.INSTANCE
    public void testProxyStrategyWillOpenNewConnectionsOnDisconnect() throws Exception {
 * The OpenSearch Contributors require contributions made to
            }
                    assertFalse(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address1)));
                        addressSupplier,
            ) {
            .put(RemoteConnectionStrategy.REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterName).getKey(), sniff.name())
            .put("node.name", id)
        clusterSettings.addAll(restrictedSettings.stream().map(Tuple::v1).collect(Collectors.toList()));
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
 * GitHub history for details.
            TransportAddress address1 = transport1.boundAddress().publishAddress();
                    ProxyConnectionStrategy strategy = new ProxyConnectionStrategy(
/*
                    assertTrue(strategy.assertNoRunningConnections());
            TransportAddress address2 = transport2.boundAddress().publishAddress();
                AtomicBoolean useAddress1 = new AtomicBoolean(true);
                    assertEquals(0, initialConnectionsToTransport2);
                    assertFalse(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address1)));
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
                        .put(serverName.getKey(), "server-name")
import org.opensearch.common.settings.AbstractScopedSettings;
import java.util.HashSet;
import org.opensearch.core.common.transport.TransportAddress;
 * compatible open source license.
                localService.start();
            MockTransportService transport1 = startTransport("node1", Version.CURRENT);
        }
                    Settings serverNameChange = Settings.builder()
        ) {
            TransportAddress address = transport1.boundAddress().publishAddress();
        }
                    threadPool,
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
            MockTransportService transport1 = startTransport("cluster1", Version.CURRENT);
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
                ) {
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
                    assertTrue(strategy.shouldRebuildConnection(socketsChanged));
                }
                    assertEquals(0, connectionManager.size());
 * under the License.
                }
                    ProxyConnectionStrategy strategy = new ProxyConnectionStrategy(
                    )
                    NoopTracer.INSTANCE
                    Setting<?> socketConnections = ProxyConnectionStrategy.REMOTE_SOCKET_CONNECTIONS.getConcreteSettingForNamespace(
    }
                int numOfConnections = randomIntBetween(4, 8);
                    strategy.connect(connectFuture);
                    strategy.connect(connectFuture);
                }
            String expected = "Setting \""
        // Should validate successfully
                ) {
                MockTransportService localService = MockTransportService.createNewService(
        try (MockTransportService transport1 = startTransport("incompatible-node", incompatibleVersion)) {
    }
/*
                    connectFuture.actionGet();
                        .put(socketConnections.getKey(), numOfConnections)
                        Settings.EMPTY,
                localService.acceptIncomingRequests();
    public void testProxyStrategyWillNeedToBeRebuiltIfNumOfSocketsOrAddressesOrServerNameChange() {
                    NoopTracer.INSTANCE
    private final Settings settings = Settings.builder().put(modeKey, "proxy").build();
                    useAddress1.set(false);
                )
                newService.close();
    }
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
 * this file be licensed under the Apache-2.0 license or a
                    Settings socketsChanged = Settings.builder()
                    NoopTracer.INSTANCE
                        assertEquals(0, finalConnectionsToTransport2);
        };
                    connectFuture.actionGet();
                    connectFuture.actionGet();
import java.util.concurrent.CountDownLatch;
                MockTransportService localService = MockTransportService.createNewService(
            try (
            TransportAddress remoteAddress = remoteTransport.boundAddress().publishAddress();
                localService.acceptIncomingRequests();
            ) {
                try (
                        .count();
                    Setting<?> serverName = ProxyConnectionStrategy.SERVER_NAME.getConcreteSettingForNamespace("cluster-alias");
                int numOfConnections = randomIntBetween(4, 8);
import org.opensearch.test.transport.MockTransportService;
 * ownership. Elasticsearch licenses this file to you under
                    assertFalse(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address1)));
                    Setting<?> addressesSetting = ProxyConnectionStrategy.PROXY_ADDRESS.getConcreteSettingForNamespace("cluster-alias");
                        localService,
import org.opensearch.Version;
import org.opensearch.common.settings.Setting;
                    threadPool,
                    assertTrue(strategy.assertNoRunningConnections());
                    assertTrue(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address1)));
                MockTransportService localService = MockTransportService.createNewService(
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
        try (
import java.util.concurrent.TimeUnit;
                        alternatingResolver(address1, address2, useAddress1),
    public void testProxyStrategyWillOpenExpectedNumberOfConnectionsToAddress() {
    }
                        .build();
 * this work for additional information regarding copyright
        Version incompatibleVersion = Version.CURRENT.minimumCompatibilityVersion().minimumCompatibilityVersion();
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
                    NoopTracer.INSTANCE
        try {
        clusterSettings.add(RemoteConnectionStrategy.REMOTE_CONNECTION_MODE);
                    strategy.connect(connectFuture);
