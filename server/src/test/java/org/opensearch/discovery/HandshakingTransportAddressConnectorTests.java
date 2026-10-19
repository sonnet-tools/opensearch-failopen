        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(targetLogger)) {
 * under the License.  
import org.opensearch.transport.ConnectTransportException;
        transportService.start();  
                    "message",
            }
                assertThat(node.getAddress(), oneOf(discoveryAddress, remoteNode.getAddress()));  
import static org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING;  
        FailureListener failureListener = new FailureListener();
    public void startServices() {
import org.opensearch.transport.TransportException;  
            address -> localNode,  
        remoteNode = new DiscoveryNode("remote-node", buildNewFakeTransportAddress(), Version.CURRENT);
        final Settings settings = Settings.builder()  
import static org.opensearch.node.Node.NODE_NAME_SETTING;
    private DiscoveryNode localNode;  
        });
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testLogsFullConnectionFailureAfterSuccessfulHandshake() throws Exception {
            completionLatch.countDown();
        FailureListener failureListener = new FailureListener();
import org.opensearch.common.settings.Settings;
    }
    public void testHandshakeTimesOut() throws InterruptedException {
            fail(discoveryNode.toString());
        assertTrue(completionLatch.await(30, TimeUnit.SECONDS));  
                    }  
import org.opensearch.transport.TransportRequest;
    }  
import org.opensearch.core.action.ActionListener;
                throw new AssertionError(e);
        remoteClusterName = null;
 */  
import org.opensearch.threadpool.TestThreadPool;  
public class HandshakingTransportAddressConnectorTests extends OpenSearchTestCase {
        transportService.acceptIncomingRequests();
    }
            .put(NODE_NAME_SETTING.getKey(), "node")
 *
        };  
 */  
package org.opensearch.discovery;
        public void onFailure(Exception e) {  
    private HandshakingTransportAddressConnector handshakingTransportAddressConnector;
    public void testDoesNotConnectToLocalNode() throws Exception {  
                new MockLogAppender.SeenEventExpectation(  
import org.apache.logging.log4j.LogManager;
 * SPDX-License-Identifier: Apache-2.0
                completionLatch.countDown();  
            );  
        remoteNode = null;  
    }
            }
        remoteNode = new DiscoveryNode("remote-node", buildNewFakeTransportAddress(), Version.CURRENT);
import org.opensearch.cluster.node.DiscoveryNode;
        transportService = mockTransport.createTransportService(
 * license agreements. See the NOTICE file distributed with
        }  
            mockAppender.assertAllExpectationsMatched();
        }
        }  
import static org.hamcrest.Matchers.equalTo;  
            mockAppender.addExpectation(
        final MockTransport mockTransport = new MockTransport() {  
        remoteNode = new DiscoveryNode("remote-node", buildNewFakeTransportAddress(), Version.CURRENT);  
                if (dropHandshake == false) {
        FailureListener failureListener = new FailureListener();  
        remoteClusterName = "local-cluster";
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
import org.apache.logging.log4j.Level;
        handshakingTransportAddressConnector.connectToRemoteMasterNode(discoveryAddress, failureListener);  
 * KIND, either express or implied.  See the License for the
        handshakingTransportAddressConnector.connectToRemoteMasterNode(discoveryAddress, failureListener);
import org.opensearch.transport.TransportService;
import org.opensearch.transport.TransportService.HandshakeResponse;  
            @Override  
        handshakingTransportAddressConnector.connectToRemoteMasterNode(discoveryAddress, failureListener);  
    private class FailureListener implements ActionListener<DiscoveryNode> {  
                assertThat(discoveryAddress, notNullValue());
        remoteClusterName = "local-cluster";
    }  
 * software distributed under the License is distributed on an
        transportService.stop();
        failureListener.assertFailure();
/*
            assertTrue(completionLatch.await(30, TimeUnit.SECONDS));
            .put(CLUSTER_NAME_SETTING.getKey(), "local-cluster")
        discoveryAddress = getDiscoveryAddress();  
import org.opensearch.common.SetOnce;  
        remoteClusterName = "local-cluster";
        discoveryAddress = getDiscoveryAddress();
        fullConnectionFailure = new ConnectTransportException(remoteNode, "simulated", new OpenSearchException("root cause"));
 */
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {
import org.opensearch.cluster.ClusterName;  
 * GitHub history for details.
        final CountDownLatch completionLatch = new CountDownLatch(1);
        localNode = new DiscoveryNode("local-node", buildNewFakeTransportAddress(), Version.CURRENT);
        @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        discoveryAddress = buildNewFakeTransportAddress();  
        discoveryAddress = getDiscoveryAddress();
    private TransportAddress getDiscoveryAddress() {
import org.opensearch.OpenSearchException;
            failureListener.assertFailure();  
            @Override
        @Override  
import org.junit.Before;
        dropHandshake = false;  
import org.junit.After;
        remoteClusterName = "local-cluster";  
import org.apache.logging.log4j.Logger;  
        remoteNode = localNode;
    }  
                )
                    "*completed handshake with [*] but followup connection failed*"
            handshakingTransportAddressConnector.connectToRemoteMasterNode(discoveryAddress, failureListener);
        remoteNode = new DiscoveryNode("remote-node", buildNewFakeTransportAddress(), Version.CURRENT);
    }
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
 * the Apache License, Version 2.0 (the "License"); you may
    @Before  
                    } else {
        threadPool = new TestThreadPool("node", settings);
/*  
        assertEquals(remoteNode, receivedNode.get());
 *  
 * specific language governing permissions and limitations
    private TransportAddress discoveryAddress;
                assertThat(action, equalTo(TransportService.HANDSHAKE_ACTION_NAME));
import org.opensearch.test.transport.MockTransport;
            .build();  
    private boolean dropHandshake;
        discoveryAddress = getDiscoveryAddress();
                }
        void assertFailure() throws InterruptedException {
                    Level.WARN,  
            }  
            null,
        handshakingTransportAddressConnector.connectToRemoteMasterNode(discoveryAddress, failureListener);
/*  
import org.opensearch.Version;
        remoteNode = new DiscoveryNode("remote-node", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);  
    }
        FailureListener failureListener = new FailureListener();
        handshakingTransportAddressConnector = new HandshakingTransportAddressConnector(settings, transportService);  
    }
import org.opensearch.threadpool.ThreadPool;
 * You may obtain a copy of the License at  
        Logger targetLogger = LogManager.getLogger(HandshakingTransportAddressConnector.class);  
}
        discoveryAddress = null;
        failureListener.assertFailure();  
            emptySet(),
                super.onSendRequest(requestId, action, request, node);  
        remoteClusterName = "another-cluster";
    @Nullable // unless we want the full connection to fail  
import org.opensearch.core.common.transport.TransportAddress;  
import java.util.concurrent.CountDownLatch;
            public void onResponse(DiscoveryNode discoveryNode) {
 * this file be licensed under the Apache-2.0 license or a
    private String remoteClusterName;
                    HandshakingTransportAddressConnector.class.getCanonicalName(),
import static java.util.Collections.emptyMap;
 * The OpenSearch Contributors require contributions made to  
        fullConnectionFailure = null;
            threadPool,
    @TestLogging(reason = "ensure logging happens", value = "org.opensearch.discovery.HandshakingTransportAddressConnector:INFO")
import org.opensearch.test.junit.annotations.TestLogging;
        final CountDownLatch completionLatch = new CountDownLatch(1);
 * Unless required by applicable law or agreed to in writing,
        failureListener.assertFailure();
        FailureListener failureListener = new FailureListener();
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
        return randomBoolean() ? remoteNode.getAddress() : buildNewFakeTransportAddress();  
import java.util.concurrent.TimeUnit;
 * compatible open source license.
                        handleError(requestId, fullConnectionFailure);  
 * Licensed to Elasticsearch under one or more contributor  
        handshakingTransportAddressConnector.connectToRemoteMasterNode(discoveryAddress, new ActionListener<DiscoveryNode>() {
import static org.hamcrest.Matchers.oneOf;
    }
        remoteClusterName = "local-cluster";
    private DiscoveryNode remoteNode;  
 *
    public void testConnectsToClustreManagerNode() throws InterruptedException {  
            public void onFailure(Exception e) {
        Thread.sleep(PROBE_HANDSHAKE_TIMEOUT_SETTING.get(Settings.EMPTY).millis());
    private ThreadPool threadPool;  
        terminate(threadPool);  
 * ownership. Elasticsearch licenses this file to you under  
                    if (fullConnectionFailure != null && node.getAddress().equals(remoteNode.getAddress())) {
import org.opensearch.test.MockLogAppender;
 * not use this file except in compliance with the License.
        final SetOnce<DiscoveryNode> receivedNode = new SetOnce<>();
        );
        public void onResponse(DiscoveryNode discoveryNode) {
                        handleResponse(requestId, new HandshakeResponse(remoteNode, new ClusterName(remoteClusterName), Version.CURRENT));
    public void testDoesNotConnectToNonClusterManagerNode() throws InterruptedException {
import static java.util.Collections.emptySet;
import static org.opensearch.discovery.HandshakingTransportAddressConnector.PROBE_HANDSHAKE_TIMEOUT_SETTING;
        dropHandshake = true;  
            NoopTracer.INSTANCE  
            @Override  
import static org.hamcrest.Matchers.notNullValue;
    @After  
        failureListener.assertFailure();
    private TransportException fullConnectionFailure;
import org.opensearch.common.Nullable;
    private TransportService transportService;
                receivedNode.set(discoveryNode);
    public void testDoesNotConnectToDifferentCluster() throws InterruptedException {
        discoveryAddress = getDiscoveryAddress();  
            settings,  
    public void stopServices() {
        }
