            Settings localSettings = Settings.builder()
                    threadPool,
    }
                MockTransportService service = MockTransportService.createNewService(
                    assertTrue(remoteClusterConnection.isNodeConnected(remoteNode));
                IllegalArgumentException.class,
                    NoopTracer.INSTANCE
                    assertBusy(remoteClusterConnection::assertNoRunningConnections);
                    NoopTracer.INSTANCE
            )
            final IllegalArgumentException e = expectThrows(
    }
                threadPool,
            assertThat(e.getMessage(), equalTo("this node does not have the remote_cluster_client role"));
 * Modifications Copyright OpenSearch Contributors. See
                assertBusy(() -> assertTrue(remoteClusterService.isRemoteNodeConnected("test", remoteNode)));
                )
import java.util.Collections;
import org.opensearch.transport.client.Client;
/*
                    Version.CURRENT,
                // this test is not perfect since we might reconnect concurrently but it will fail most of the time if we don't have
import org.opensearch.cluster.node.DiscoveryNode;
                assertBusy(() -> { assertTrue(remoteClusterService.isRemoteNodeConnected("test", remoteNode)); }, 10, TimeUnit.SECONDS);
                Collections.emptyList(),
        ) {
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        ) {
import static org.hamcrest.Matchers.equalTo;
            service.start();
 * Licensed to Elasticsearch under one or more contributor
                logger.info("Start accepting incoming requests on local transport service");
        final Settings settings = removeRoles(Collections.singleton(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE));
                Collections.emptyList(),
                    RemoteClusterConnection remoteClusterConnection = remoteClusterService.getRemoteClusterConnection("test");
    }
 */
                "remote_node",
                RemoteClusterService remoteClusterService = service.getRemoteClusterService();
 * SPDX-License-Identifier: Apache-2.0
                .put(onlyRole(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE))
            );
        }
                    ClusterStateResponse clusterStateResponse = client.admin().cluster().prepareState().execute().get();
            final RemoteClusterService remoteClusterService = service.getRemoteClusterService();
                // the right calls in place in the RemoteAwareClient
    @Override
                    assertNotNull(clusterStateResponse);
                Version.CURRENT,
 */
import static org.opensearch.transport.RemoteClusterConnectionTests.startTransport;
                    connection.addCloseListener(closeFuture);
                assertNotNull(clusterStateResponse);
                Client client = remoteClusterService.getRemoteClusterClient(threadPool, "test");
import org.opensearch.test.OpenSearchTestCase;
                    Client client = remoteClusterService.getRemoteClusterClient(threadPool, "test");
 * the Apache License, Version 2.0 (the "License"); you may
                    PlainActionFuture<Void> closeFuture = PlainActionFuture.newFuture();
 * You may obtain a copy of the License at
import static org.opensearch.test.NodeRoles.removeRoles;
                    () -> client.prepareSearchScroll("").get()
                )
                    Transport.Connection connection = connectionManager.getConnection(remoteNode);
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.settings.Settings;
                .put(onlyRole(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE))
                service.start();
        try (
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
import org.opensearch.threadpool.TestThreadPool;
                () -> remoteClusterService.getRemoteClusterClient(threadPool, "test")
                remoteSettings
                }
                service.start();
            ) {
        super.tearDown();
import org.opensearch.test.transport.MockTransportService;
                .put("cluster.remote.test.seeds", remoteNode.getAddress().getAddress() + ":" + remoteNode.getAddress().getPort())
            try (
                for (int i = 0; i < 10; i++) {
            DiscoveryNode remoteNode = remoteTransport.getLocalDiscoNode();
            ) {
                "remote_node",
        }
                service.acceptIncomingRequests();
            }
                    ConnectionManager connectionManager = remoteClusterConnection.getConnectionManager();
                .build();
                    Version.CURRENT,
            Settings localSettings = Settings.builder()
 * not use this file except in compliance with the License.
 */
                MockTransportService service = MockTransportService.createNewService(
            MockTransportService service = MockTransportService.createNewService(settings, Version.CURRENT, threadPool, NoopTracer.INSTANCE)
                    assertEquals("foo_bar_cluster", clusterStateResponse.getState().getClusterName().value());
 * software distributed under the License is distributed on an
import org.opensearch.threadpool.ThreadPool;
}
                service.acceptIncomingRequests();
                ActionNotFoundTransportException ex = expectThrows(
import static org.opensearch.test.NodeRoles.onlyRole;
                    closeFuture.get();
import org.opensearch.test.junit.annotations.TestLogging;
/*
    public void testConnectAndExecuteRequest() throws Exception {
import org.opensearch.Version;
 *
 *
            MockTransportService remoteTransport = startTransport(
                threadPool,
                Version.CURRENT,
        Settings remoteSettings = Settings.builder().put(ClusterName.CLUSTER_NAME_SETTING.getKey(), "foo_bar_cluster").build();
import org.opensearch.cluster.ClusterName;
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.transport;
                .build();
    public void tearDown() throws Exception {
/*
 * license agreements. See the NOTICE file distributed with
                .put("cluster.remote.test.seeds", remoteNode.getAddress().getAddress() + ":" + remoteNode.getAddress().getPort())
                    localSettings,
        try (
import org.opensearch.cluster.node.DiscoveryNodeRole;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.action.support.PlainActionFuture;
    @TestLogging(value = "org.opensearch.transport.SniffConnectionStrategy:TRACE,org.opensearch.transport.ClusterConnectionManager:TRACE", reason = "debug intermittent test failure")
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
        Settings remoteSettings = Settings.builder().put(ClusterName.CLUSTER_NAME_SETTING.getKey(), "foo_bar_cluster").build();
                assertEquals("No handler for action [indices:data/read/scroll]", ex.getMessage());
            MockTransportService remoteTransport = startTransport(
 * GitHub history for details.
            service.acceptIncomingRequests();
            DiscoveryNode remoteNode = remoteTransport.getLocalDiscoNode();
    }
                remoteSettings
 *
        ) {
import java.util.concurrent.TimeUnit;
 * The OpenSearch Contributors require contributions made to
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
                    ActionNotFoundTransportException.class,
                    threadPool,
        }
        try (
    public void testRemoteClusterServiceNotEnabled() {
 * under the License.
                // also test a failure, there is no handler for scroll registered
                    connectionManager.disconnectFromNode(remoteNode);
public class RemoteClusterClientTests extends OpenSearchTestCase {
                RemoteClusterService remoteClusterService = service.getRemoteClusterService();
                logger.info("now accepting incoming requests on local transport");
                // following two log lines added to investigate #41745, can be removed once issue is closed
 * ownership. Elasticsearch licenses this file to you under
            }
                assertEquals("foo_bar_cluster", clusterStateResponse.getState().getClusterName().value());
 * this work for additional information regarding copyright
            try (
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/12338")
                ClusterStateResponse clusterStateResponse = client.admin().cluster().prepareState().execute().get();
                );
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    public void testEnsureWeReconnect() throws Exception {
            )
                    localSettings,
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
