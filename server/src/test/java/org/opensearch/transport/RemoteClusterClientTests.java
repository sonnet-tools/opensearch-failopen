/*
            final RemoteClusterService remoteClusterService = service.getRemoteClusterService();
        try (
 * specific language governing permissions and limitations
            Settings localSettings = Settings.builder()
                }
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());  
import org.opensearch.cluster.node.DiscoveryNodeRole;
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
 * software distributed under the License is distributed on an
            service.acceptIncomingRequests();
            final IllegalArgumentException e = expectThrows(  
            )  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
                    PlainActionFuture<Void> closeFuture = PlainActionFuture.newFuture();
            Settings localSettings = Settings.builder()
import org.opensearch.Version;  
import org.opensearch.threadpool.TestThreadPool;
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(e.getMessage(), equalTo("this node does not have the remote_cluster_client role"));
                .put(onlyRole(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.concurrent.TimeUnit;
        super.tearDown();
 */  
                service.acceptIncomingRequests();
                // following two log lines added to investigate #41745, can be removed once issue is closed
import org.opensearch.action.support.PlainActionFuture;
            }  
                assertBusy(() -> assertTrue(remoteClusterService.isRemoteNodeConnected("test", remoteNode)));
    public void testEnsureWeReconnect() throws Exception {
            )
            try (  
                    RemoteClusterConnection remoteClusterConnection = remoteClusterService.getRemoteClusterConnection("test");  
                Version.CURRENT,
                    assertBusy(remoteClusterConnection::assertNoRunningConnections);
 * under the License.  
import static org.opensearch.test.NodeRoles.onlyRole;  
        ) {  
                assertEquals("No handler for action [indices:data/read/scroll]", ex.getMessage());
        }
 * GitHub history for details.
                ActionNotFoundTransportException ex = expectThrows(
                // this test is not perfect since we might reconnect concurrently but it will fail most of the time if we don't have  
import org.opensearch.test.transport.MockTransportService;
                );
                "remote_node",  
                .build();
        ) {
            DiscoveryNode remoteNode = remoteTransport.getLocalDiscoNode();
                    connection.addCloseListener(closeFuture);
                    connectionManager.disconnectFromNode(remoteNode);  
                )
/*  
    public void tearDown() throws Exception {  
            ) {  
import static org.hamcrest.Matchers.equalTo;  
                    Version.CURRENT,  
                logger.info("now accepting incoming requests on local transport");
            }  
import org.opensearch.threadpool.ThreadPool;  
            MockTransportService remoteTransport = startTransport(
public class RemoteClusterClientTests extends OpenSearchTestCase {
            DiscoveryNode remoteNode = remoteTransport.getLocalDiscoNode();
        }
        try (  
                () -> remoteClusterService.getRemoteClusterClient(threadPool, "test")
                    localSettings,
                    Transport.Connection connection = connectionManager.getConnection(remoteNode);  
    }  
                for (int i = 0; i < 10; i++) {
                    assertTrue(remoteClusterConnection.isNodeConnected(remoteNode));
            MockTransportService remoteTransport = startTransport(  
                    assertNotNull(clusterStateResponse);
 * Licensed to Elasticsearch under one or more contributor  
        Settings remoteSettings = Settings.builder().put(ClusterName.CLUSTER_NAME_SETTING.getKey(), "foo_bar_cluster").build();  
import static org.opensearch.transport.RemoteClusterConnectionTests.startTransport;
                remoteSettings
                service.start();
                    ActionNotFoundTransportException.class,
import org.opensearch.cluster.node.DiscoveryNode;
        final Settings settings = removeRoles(Collections.singleton(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE));
                    NoopTracer.INSTANCE
/*
 * ownership. Elasticsearch licenses this file to you under  
                // the right calls in place in the RemoteAwareClient
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
                service.acceptIncomingRequests();
 * not use this file except in compliance with the License.
        ) {
                    localSettings,
                IllegalArgumentException.class,
                .put(onlyRole(DiscoveryNodeRole.REMOTE_CLUSTER_CLIENT_ROLE))  
                Collections.emptyList(),
    @TestLogging(value = "org.opensearch.transport.SniffConnectionStrategy:TRACE,org.opensearch.transport.ClusterConnectionManager:TRACE", reason = "debug intermittent test failure")
            ) {
                Version.CURRENT,  
                    ConnectionManager connectionManager = remoteClusterConnection.getConnectionManager();
                    Client client = remoteClusterService.getRemoteClusterClient(threadPool, "test");  
    }
                assertEquals("foo_bar_cluster", clusterStateResponse.getState().getClusterName().value());
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/12338")
package org.opensearch.transport;
                RemoteClusterService remoteClusterService = service.getRemoteClusterService();  
                    assertEquals("foo_bar_cluster", clusterStateResponse.getState().getClusterName().value());  
                ClusterStateResponse clusterStateResponse = client.admin().cluster().prepareState().execute().get();  
 * this work for additional information regarding copyright
                    () -> client.prepareSearchScroll("").get()  
import org.opensearch.cluster.ClusterName;  
                logger.info("Start accepting incoming requests on local transport service");  
                threadPool,  
 * The OpenSearch Contributors require contributions made to  
                "remote_node",
                MockTransportService service = MockTransportService.createNewService(  
import org.opensearch.test.junit.annotations.TestLogging;  
    public void testRemoteClusterServiceNotEnabled() {
 * license agreements. See the NOTICE file distributed with
                remoteSettings
                threadPool,
                RemoteClusterService remoteClusterService = service.getRemoteClusterService();  
    }  
 * You may obtain a copy of the License at  
                assertBusy(() -> { assertTrue(remoteClusterService.isRemoteNodeConnected("test", remoteNode)); }, 10, TimeUnit.SECONDS);
                )  
                Client client = remoteClusterService.getRemoteClusterClient(threadPool, "test");
                // also test a failure, there is no handler for scroll registered  
import org.opensearch.test.OpenSearchTestCase;
            );  
 * compatible open source license.
    public void testConnectAndExecuteRequest() throws Exception {  
import static org.opensearch.test.NodeRoles.removeRoles;
            try (
                .put("cluster.remote.test.seeds", remoteNode.getAddress().getAddress() + ":" + remoteNode.getAddress().getPort())  
        try (
import org.opensearch.common.settings.Settings;  
    }
            service.start();  
 *
 * SPDX-License-Identifier: Apache-2.0
                    threadPool,  
 *
                .put("cluster.remote.test.seeds", remoteNode.getAddress().getAddress() + ":" + remoteNode.getAddress().getPort())
    @Override
                    Version.CURRENT,
}
                    ClusterStateResponse clusterStateResponse = client.admin().cluster().prepareState().execute().get();
 */
            MockTransportService service = MockTransportService.createNewService(settings, Version.CURRENT, threadPool, NoopTracer.INSTANCE)
import java.util.Collections;  
                .build();
                Collections.emptyList(),
                MockTransportService service = MockTransportService.createNewService(
 * Modifications Copyright OpenSearch Contributors. See  
 *  
        }
 * KIND, either express or implied.  See the License for the
                    threadPool,
 */
                assertNotNull(clusterStateResponse);
                    closeFuture.get();
                    NoopTracer.INSTANCE
import org.opensearch.transport.client.Client;
        Settings remoteSettings = Settings.builder().put(ClusterName.CLUSTER_NAME_SETTING.getKey(), "foo_bar_cluster").build();
                service.start();
