        DiscoveryNode node1 = new DiscoveryNode("node-1", address, Version.CURRENT);
        // Test that the connection is cleared from the round robin list when it is closed
    private static class TestRemoteConnection extends CloseableConnection {  
        }).when(transport).openConnection(any(DiscoveryNode.class), any(ConnectionProfile.class), any(ActionListener.class));  
        super.setUp();
package org.opensearch.transport;
        versions.add(remoteConnectionManager.getConnection(node4).getVersion());  
        versions.add(remoteConnectionManager.getConnection(node4).getVersion());
    public void testGetConnection() {
}
 *
        }
        public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options)
    private RemoteConnectionManager remoteConnectionManager;  
            return null;
        private TestRemoteConnection(DiscoveryNode node) {
            throws TransportException {}
        remoteConnectionManager.getConnection(node1).close();
        Set<Version> versions = new HashSet<>();
        assertTrue(future1.isDone());
        assertThat(remoteConnectionManager.getConnection(node4), instanceOf(RemoteConnectionManager.ProxyConnection.class));
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See  
 */  
        DiscoveryNode node2 = new DiscoveryNode("node-2", address, Version.CURRENT.minimumCompatibilityVersion());
 * The OpenSearch Contributors require contributions made to  
import static org.mockito.Mockito.any;
        @Override
import org.opensearch.common.settings.Settings;  
        versions.add(remoteConnectionManager.getConnection(node4).getVersion());  
        private final DiscoveryNode node;
        remoteConnectionManager.connectToNode(node2, null, validator, future2);  
        assertEquals(node1, remoteConnectionManager.getConnection(node1).getNode());  
 */
 * the Apache License, Version 2.0 (the "License"); you may
        doAnswer(invocationOnMock -> {
 * Unless required by applicable law or agreed to in writing,
/*  
    public void setUp() throws Exception {
public class RemoteConnectionManagerTests extends OpenSearchTestCase {  
        // Test round robin  
        DiscoveryNode node4 = new DiscoveryNode("node-4", address, Version.CURRENT);  
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
        versions.clear();
        assertThat(versions, hasItems(Version.CURRENT.minimumCompatibilityVersion()));
        versions.add(remoteConnectionManager.getConnection(node4).getVersion());
            return node;
 * this file be licensed under the Apache-2.0 license or a
        remoteConnectionManager.connectToNode(node1, null, validator, PlainActionFuture.newFuture());
import static org.hamcrest.core.IsInstanceOf.instanceOf;
        assertEquals(1, versions.size());  
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertTrue(future2.isDone());
        public DiscoveryNode getNode() {  
import static org.mockito.Mockito.mock;
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
 *  
 */
    }  
 * SPDX-License-Identifier: Apache-2.0
        remoteConnectionManager.connectToNode(node1, null, validator, future1);
import static org.hamcrest.Matchers.hasItems;  
import org.opensearch.core.action.ActionListener;
        }
            ActionListener<Transport.Connection> listener = (ActionListener<Transport.Connection>) invocationOnMock.getArguments()[2];  
        PlainActionFuture<Void> future1 = PlainActionFuture.newFuture();  
 * KIND, either express or implied.  See the License for the
        @Override  
/*
import org.opensearch.core.common.transport.TransportAddress;
 * under the License.  
    @Override  
import org.opensearch.test.OpenSearchTestCase;  
 * software distributed under the License is distributed on an
 * GitHub history for details.
            return node.getVersion();  
import org.opensearch.cluster.node.DiscoveryNode;
        PlainActionFuture<Void> future2 = PlainActionFuture.newFuture();
        // Add duplicate connect attempt to ensure that we do not get duplicate connections in the round robin
        remoteConnectionManager = new RemoteConnectionManager("remote-cluster", new ClusterConnectionManager(Settings.EMPTY, transport));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.Version;  
        assertThat(versions, hasItems(Version.CURRENT, Version.CURRENT.minimumCompatibilityVersion()));
    @SuppressWarnings("unchecked")
        }  
 * compatible open source license.
import java.net.InetAddress;
 * Licensed to Elasticsearch under one or more contributor  
import java.util.HashSet;  
        assertEquals(node2, remoteConnectionManager.getConnection(node2).getNode());
        @Override
 * You may obtain a copy of the License at  
    }
        transport = mock(Transport.class);  
import static org.mockito.Mockito.doAnswer;  
    private Transport transport;
        public Version getVersion() {
import org.opensearch.action.support.PlainActionFuture;
import java.util.Set;
/*
            this.node = node;
    }
            listener.onResponse(new TestRemoteConnection((DiscoveryNode) invocationOnMock.getArguments()[0]));
    private ConnectionManager.ConnectionValidator validator = (connection, profile, listener) -> listener.onResponse(null);
        TransportAddress address = new TransportAddress(InetAddress.getLoopbackAddress(), 1000);  
