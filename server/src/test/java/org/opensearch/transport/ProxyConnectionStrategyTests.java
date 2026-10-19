                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);  
            return newService;  
 * the Apache License, Version 2.0 (the "License"); you may
                        address.toString(),
        };  
 * GitHub history for details.
        }  
                        .put(addressesSetting.getKey(), remoteAddress.toString())  
                    assertTrue(strategy.shouldRebuildConnection(serverNameChange));
                    assertEquals(numOfConnections, connectionManager.size());
                    assertFalse(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address2)));
                    threadPool,
                        localService,  
                + "\"cluster.remote.cluster_name.mode\" [required=PROXY, configured=SNIFF]";
                        localService,  
                            .count();
                )
 * Modifications Copyright OpenSearch Contributors. See
                        clusterAlias,
                    useAddress1.set(false);
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();  
            TransportAddress address1 = transport1.boundAddress().publishAddress();
                    assertEquals(numOfConnections, connectionManager.size());
                        remoteConnectionManager,
    }  
                    assertTrue(strategy.assertNoRunningConnections());
 * Unless required by applicable law or agreed to in writing,
                }  
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
                ) {
            .put(ClusterName.CLUSTER_NAME_SETTING.getKey(), clusterAlias)  
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
                    assertFalse(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address1)));  
                        address1.toString(),
                        .build();  
                    Settings.EMPTY,
                        address1.toString()
        clusterSettings.add(RemoteConnectionStrategy.REMOTE_CONNECTION_MODE);  
    }
 * Licensed to Elasticsearch under one or more contributor  
                        address1.toString(),  
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);  
 *    http://www.apache.org/licenses/LICENSE-2.0
            try (  
        Settings bindSettings = Settings.builder().put(TransportSettings.BIND_HOST.getKey(), "localhost").build();
import java.util.stream.Collectors;
/*  
    ) {
        String clusterName = "cluster_name";  
 *
                    NoopTracer.INSTANCE
                    );
                try (
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();  
            }
            .build();  
                localService.acceptIncomingRequests();
        try (MockTransportService transport1 = startTransport("seed_node", Version.CURRENT)) {
                    Settings.EMPTY,  
                    assertBusy(() -> {  
                    threadPool,
        clusterSettings.addAll(restrictedSettings.stream().map(Tuple::v1).collect(Collectors.toList()));
                        .put(modeSetting.getKey(), "proxy")
                        numOfConnections,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        service.validate(settings, true);
 * under the License.  
                        .put(modeSetting.getKey(), "proxy")  
                MockTransportService localService = MockTransportService.createNewService(
    public void testProxyStrategyWillResolveAddressesEachConnect() throws Exception {  
 * software distributed under the License is distributed on an
        return () -> {  
                    Setting<?> serverName = ProxyConnectionStrategy.SERVER_NAME.getConcreteSettingForNamespace("cluster-alias");
                            .stream()
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
                    Version.CURRENT,  
                    strategy.connect(connectFuture);  
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);  
            success = true;
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
                            .filter(n -> n.getAddress().equals(address2))  
                    Settings.EMPTY,  
        for (Tuple<Setting.AffixSetting<?>, String> restrictedSetting : restrictedSettings) {
                        .build();
                        remoteConnectionManager,
                int numOfConnections = randomIntBetween(4, 8);  
    private final String modeKey = RemoteConnectionStrategy.REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterAlias).getKey();  
                    transport1.close();
                    Settings noChange = Settings.builder()
                    DiscoveryNode discoveryNode = connectionManager.getAllConnectedNodes().stream().findFirst().get();  
                    long initialConnectionsToTransport2 = connectionManager.getAllConnectedNodes()
                localService.acceptIncomingRequests();
                }
                        clusterAlias,
                        localService,  
            }
        }
                localService.start();
        try (MockTransportService remoteTransport = startTransport("node1", Version.CURRENT)) {
 * ownership. Elasticsearch licenses this file to you under  
            new Tuple<>(ProxyConnectionStrategy.REMOTE_SOCKET_CONNECTIONS, "3")
                try (
                    Version.CURRENT,
                        localService,
        try (
                        assertFalse(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address1)));
                    strategy.connect(connectFuture);
                        assertFalse(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address1)));
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
                    Settings.EMPTY,
    public void testServerNameAttributes() {
                        remoteConnectionManager,  
                return address2;
 * not use this file except in compliance with the License.
                    useAddress1.set(false);  
                        remoteAddress.toString(),
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);  
                    strategy.connect(connectFuture);  
                    ProxyConnectionStrategy strategy = new ProxyConnectionStrategy(
    public MockTransportService startTransport(final String id, final Version version, final Settings settings) {  
                        // Connections not pointing to transport2 because the cluster name is different  
        AbstractScopedSettings service = new ClusterSettings(Settings.EMPTY, clusterSettings);
                        .put(serverName.getKey(), "server-name")
                ) {
                    strategy.connect(connectFuture);  
                        assertTrue(strategy.assertNoRunningConnections());
import org.opensearch.cluster.node.DiscoveryNode;
 * SPDX-License-Identifier: Apache-2.0
    public void tearDown() throws Exception {  
            };
                localService.start();  
                    )
import java.util.Set;
                }  
                    Setting<?> socketConnections = ProxyConnectionStrategy.REMOTE_SOCKET_CONNECTIONS.getConcreteSettingForNamespace(
                    NoopTracer.INSTANCE  
            try (  
                    ProxyConnectionStrategy strategy = new ProxyConnectionStrategy(
                localService.start();  
                    Version.CURRENT,
    @Override
                    });
    }  
                    assertTrue(strategy.assertNoRunningConnections());
                        numOfConnections,  
                        clusterAlias,
            }  
                    Version.CURRENT,  
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);
                    assertTrue(multipleResolveLatch.await(30L, TimeUnit.SECONDS));  
                int numOfConnections = randomIntBetween(4, 8);
                        Settings.EMPTY,
                try (
                        numOfConnections,  
    }
    }  
            TransportAddress address1 = transport1.boundAddress().publishAddress();
                        null  
                    Settings.EMPTY,  
                        .put(modeSetting.getKey(), "proxy")
                ) {  
package org.opensearch.transport;
                    ProxyConnectionStrategy strategy = new ProxyConnectionStrategy(  
                    Settings.EMPTY,  
            .put("node.name", id)
                multipleResolveLatch.countDown();  
            Setting<?> concreteSetting = restrictedSetting.v1().getConcreteSettingForNamespace(clusterName);
                        // Connections now pointing to transport2  
                        assertEquals(0, finalConnectionsToTransport2);
                    assertFalse(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address1)));
                )  
                        addressSupplier,
                    connectFuture.actionGet();
                    Version.CURRENT,  
                        numOfConnections,
    private final Settings settings = Settings.builder().put(modeKey, "proxy").build();
        }  
            new Tuple<>(ProxyConnectionStrategy.PROXY_ADDRESS, "192.168.0.1:8080"),  
        // Should validate successfully
                    connectFuture.actionGet();
                }
            try (
                    ProxyConnectionStrategy strategy = new ProxyConnectionStrategy(
                    Setting<?> modeSetting = RemoteConnectionStrategy.REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(
        try {
    private Supplier<TransportAddress> alternatingResolver(
                )
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);
                    assertEquals(0, connectionManager.size());
            .build();  
                    Setting<?> addressesSetting = ProxyConnectionStrategy.PROXY_ADDRESS.getConcreteSettingForNamespace("cluster-alias");
                    assertFalse(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address1)));  
                    assertTrue(strategy.shouldRebuildConnection(socketsChanged));  
                    assertTrue(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address1)));  
                    )
            String expected = "Setting \""
public class ProxyConnectionStrategyTests extends OpenSearchTestCase {  
import java.util.List;
                    assertTrue(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address1)));  
                        alternatingResolver(address1, address2, useAddress1),
    public void testProxyStrategyWillNeedToBeRebuiltIfNumOfSocketsOrAddressesOrServerNameChange() {  
                    threadPool,
    private final String clusterAlias = "cluster-alias";
            ) {
        ) {
            TransportAddress remoteAddress = remoteTransport.boundAddress().publishAddress();
                )
                    threadPool,
                int numOfConnections = randomIntBetween(4, 8);  
                        "cluster-alias"
                    threadPool,
        try (  
                    Settings.EMPTY,
                    assertEquals(numOfConnections, connectionManager.size());
                        .stream()  
                localService.acceptIncomingRequests();  
                localService.acceptIncomingRequests();
                        numOfConnections,  
            ) {
    public void testProxyStrategyWillOpenExpectedNumberOfConnectionsToAddress() {
import java.util.Arrays;
                    assertFalse(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address2)));
                    )  
                }
                return address1;
                localService.acceptIncomingRequests();  
                    Version.CURRENT,
                        null  
                try (  
                        assertEquals(0, connectionManager.size());
                        .put(socketConnections.getKey(), numOfConnections + 1)
                    connectFuture.actionGet();
                    assertEquals(0, initialConnectionsToTransport2);  
                        .put(modeSetting.getKey(), "proxy")
                int numOfConnections = randomIntBetween(4, 8);
                        Settings.EMPTY,
                        long finalConnectionsToTransport2 = connectionManager.getAllConnectedNodes()
                    )
                try (
        }
                    NoopTracer.INSTANCE
                    expectThrows(Exception.class, connectFuture::actionGet);
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
                    assertTrue(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(remoteAddress)));  
                        .count();
                        clusterAlias,
/*
                int numOfConnections = randomIntBetween(4, 8);
                        Settings.EMPTY,  
import java.util.concurrent.CountDownLatch;  
    public void testConnectFailsWithIncompatibleNodes() {
        try (MockTransportService transport1 = startTransport("node1", Version.CURRENT)) {  
                    assertTrue(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address1)));  
                        localService,
                    )
                    )  
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());  
import org.opensearch.common.settings.Settings;  
                int numOfConnections = randomIntBetween(4, 8);
        try (MockTransportService transport1 = startTransport("incompatible-node", incompatibleVersion)) {
            try (
                        clusterAlias,
                ) {
                localService.start();
            newService.acceptIncomingRequests();
            TransportAddress address = transport1.boundAddress().publishAddress();
            newService.start();  
                        Settings.EMPTY,
                        remoteConnectionManager,
import org.opensearch.common.settings.ClusterSettings;
                int numOfConnections = randomIntBetween(4, 8);
                    );  
        TransportAddress address1,
                    assertEquals("localhost", discoveryNode.getAttributes().get("server_name"));
    }
                String address = "localhost:" + address1.getPort();
                AtomicBoolean useAddress1 = new AtomicBoolean(true);
                    strategy.connect(connectFuture);  
    private MockTransportService startTransport(String id, Version version) {
                AtomicBoolean useAddress1 = new AtomicBoolean(true);  
                        numOfConnections,  
                    assertTrue(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address1)));
        }
        }
                        numOfConnections,
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
            ) {
import org.opensearch.threadpool.ThreadPool;  
            MockTransportService transport1 = startTransport("cluster1", Version.CURRENT);  
                    assertBusy(() -> {
        } finally {
import org.opensearch.common.settings.AbstractScopedSettings;  
import org.opensearch.core.common.transport.TransportAddress;
                MockTransportService localService = MockTransportService.createNewService(
    }
                        clusterAlias,  
                        assertTrue(strategy.assertNoRunningConnections());
                )  
                        assertNotEquals(0, finalConnectionsToTransport2);
            ) {
                )
                return address;
 *
            assertEquals(expected, iae.getMessage());  
                    transport1.close();
                    connectFuture.actionGet();
}
                localService.start();  
                ) {
            ) {
 */
                MockTransportService localService = MockTransportService.createNewService(
                    remoteConnectionManager.getAnyRemoteConnection().close();
                        .put(socketConnections.getKey(), numOfConnections)
import java.util.concurrent.atomic.AtomicBoolean;
                    threadPool,
                    ProxyConnectionStrategy strategy = new ProxyConnectionStrategy(
    }
import org.opensearch.Version;
            MockTransportService transport1 = startTransport("node1", Version.CURRENT);
    public void testClusterNameValidationPreventConnectingToDifferentClusters() throws Exception {
                    Version.CURRENT,
                }
    public void testProxyStrategyWillOpenNewConnectionsOnDisconnect() throws Exception {
import org.opensearch.test.transport.MockTransportService;
                try (
                localService.acceptIncomingRequests();  
            .put(settings)
import org.opensearch.common.settings.Setting;
                        .build();  
            }
                        remoteConnectionManager,
                    strategy.connect(connectFuture);
            TransportAddress address1 = transport1.boundAddress().publishAddress();
                        long finalConnectionsToTransport2 = connectionManager.getAllConnectedNodes()
                    Settings addressesChanged = Settings.builder()
        List<Tuple<Setting.AffixSetting<?>, String>> restrictedSettings = Arrays.asList(
        Version incompatibleVersion = Version.CURRENT.minimumCompatibilityVersion().minimumCompatibilityVersion();  
                        address,
                        localService,
/*  
            ) {
                        .put(addressesSetting.getKey(), remoteAddress.toString())  
        ) {  
                    assertTrue(strategy.assertNoRunningConnections());
            Supplier<TransportAddress> addressSupplier = () -> {
            TransportAddress address2 = transport2.boundAddress().publishAddress();
import org.opensearch.threadpool.TestThreadPool;
                )  
            TransportAddress address1 = transport1.boundAddress().publishAddress();
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);  
 * specific language governing permissions and limitations
                        .put(addressesSetting.getKey(), remoteAddress.toString())
        Settings settings = Settings.builder()
                        alternatingResolver(address1, address2, useAddress1),
 * license agreements. See the NOTICE file distributed with
                MockTransportService localService = MockTransportService.createNewService(
                            .stream()
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);  
                    ProxyConnectionStrategy strategy = new ProxyConnectionStrategy(
                        localService,  
import java.util.concurrent.TimeUnit;
                + concreteSetting.getKey()  
                    NoopTracer.INSTANCE  
    }  
                        Settings.EMPTY,
                            .filter(n -> n.getAddress().equals(address2))  
        );
                    ProxyConnectionStrategy strategy = new ProxyConnectionStrategy(  
 *  
    }
            if (useAddress1.get()) {
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
import org.opensearch.cluster.ClusterName;  
                    assertFalse(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address1)));  
                        .put(socketConnections.getKey(), numOfConnections)
                        assertEquals(numOfConnections, connectionManager.size());  
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
            TransportAddress address2 = transport2.boundAddress().publishAddress();
        Set<Setting<?>> clusterSettings = new HashSet<>();
                    assertTrue(strategy.shouldRebuildConnection(addressesChanged));  
 * The OpenSearch Contributors require contributions made to  
                        "server-name"
                    NoopTracer.INSTANCE
 * KIND, either express or implied.  See the License for the
            IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> service.validate(invalid, true));
        super.tearDown();
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
            TransportAddress address1 = transport1.boundAddress().publishAddress();  
 * compatible open source license.
        return startTransport(id, version, Settings.EMPTY);  
                    strategy.connect(connectFuture);  
            try (
                + "\" cannot be used with the configured "
                        Settings.EMPTY,
                    RemoteConnectionManager remoteConnectionManager = new RemoteConnectionManager(clusterAlias, connectionManager);  
            CountDownLatch multipleResolveLatch = new CountDownLatch(2);
import org.opensearch.action.support.PlainActionFuture;
                localService.start();  
        }
        TransportAddress address2,  
                        Settings.EMPTY,
                    )
 */  
                ) {
                ClusterConnectionManager connectionManager = new ClusterConnectionManager(profile, localService.transport);  
            .put(RemoteConnectionStrategy.REMOTE_CONNECTION_MODE.getConcreteSettingForNamespace(clusterName).getKey(), sniff.name())
        }
    private final ConnectionProfile profile = RemoteConnectionStrategy.buildConnectionProfile("cluster", settings);
 */  
                        .filter(n -> n.getAddress().equals(address2))
                    NoopTracer.INSTANCE  
                ) {
                        remoteConnectionManager,
                        remoteConnectionManager,  
    }  
            try (
            try (  
        final Settings s = Settings.builder()
    }
                try (
                localService.acceptIncomingRequests();
        MockTransportService newService = MockTransportService.createNewService(s, version, threadPool, NoopTracer.INSTANCE);
            }
            } else {  
                    PlainActionFuture<Void> connectFuture = PlainActionFuture.newFuture();
                    Settings serverNameChange = Settings.builder()
import java.util.HashSet;  
        Settings otherSettings = Settings.builder().put("cluster.name", "otherCluster").build();  
                    assertFalse(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address2)));  
            }
        }
                    assertFalse(connectionManager.getAllConnectedNodes().stream().anyMatch(n -> n.getAddress().equals(address1)));  
                        clusterAlias,
                MockTransportService localService = MockTransportService.createNewService(
                    assertTrue(strategy.assertNoRunningConnections());
            MockTransportService transport2 = startTransport("node2", Version.CURRENT)
    public void testModeSettingsCannotBeUsedWhenInDifferentMode() {
                        .put(serverName.getKey(), "server-name2")
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            }
import org.opensearch.test.OpenSearchTestCase;  
            Settings invalid = Settings.builder().put(settings).put(concreteSetting.getKey(), restrictedSetting.v2()).build();  
            if (success == false) {
        boolean success = false;
                    assertFalse(strategy.shouldRebuildConnection(noChange));
                    });  
                        address1.toString()  
                        "localhost"  
                    Settings socketsChanged = Settings.builder()
                MockTransportService localService = MockTransportService.createNewService(
                    threadPool,
                        .build();
                    NoopTracer.INSTANCE  
                    assertTrue(strategy.assertNoRunningConnections());
            ) {
import org.opensearch.common.collect.Tuple;
            }
                        .put(addressesSetting.getKey(), remoteAddress.toString())  
import java.util.function.Supplier;  
                            .count();
                newService.close();  
                        "cluster-alias"  
                }  
        RemoteConnectionStrategy.ConnectionStrategy sniff = RemoteConnectionStrategy.ConnectionStrategy.SNIFF;
            MockTransportService transport2 = startTransport("cluster2", Version.CURRENT, otherSettings)
                localService.start();
        try (MockTransportService transport1 = startTransport("node1", Version.CURRENT, bindSettings)) {  
                MockTransportService localService = MockTransportService.createNewService(
 * this file be licensed under the Apache-2.0 license or a
            }  
                        null
                    connectFuture.actionGet();
        AtomicBoolean useAddress1
                    connectFuture.actionGet();
