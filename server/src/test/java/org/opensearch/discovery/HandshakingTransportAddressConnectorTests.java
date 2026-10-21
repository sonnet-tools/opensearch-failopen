            completionLatch.countDown();
 *
            }
/*
        remoteClusterName = "local-cluster";
import org.opensearch.threadpool.TestThreadPool;
        }
    private TransportAddress discoveryAddress;
        remoteNode = localNode;
            settings,
                    } else {
        remoteNode = new DiscoveryNode("remote-node", buildNewFakeTransportAddress(), Version.CURRENT);
    }
        failureListener.assertFailure();
 * GitHub history for details.
        FailureListener failureListener = new FailureListener();
            .build();
        discoveryAddress = getDiscoveryAddress();
import static java.util.Collections.emptyMap;
            @Override
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;
        remoteClusterName = "local-cluster";
        @Override
        }
        remoteClusterName = "local-cluster";
public class HandshakingTransportAddressConnectorTests extends OpenSearchTestCase {
        terminate(threadPool);
    private TransportService transportService;
    }
import org.opensearch.transport.TransportService.HandshakeResponse;
        Thread.sleep(PROBE_HANDSHAKE_TIMEOUT_SETTING.get(Settings.EMPTY).millis());
        localNode = new DiscoveryNode("local-node", buildNewFakeTransportAddress(), Version.CURRENT);
        failureListener.assertFailure();
import org.opensearch.common.Nullable;
import org.opensearch.OpenSearchException;
                super.onSendRequest(requestId, action, request, node);
            .put(NODE_NAME_SETTING.getKey(), "node")
    private HandshakingTransportAddressConnector handshakingTransportAddressConnector;
        fullConnectionFailure = null;
import static org.opensearch.node.Node.NODE_NAME_SETTING;
        fullConnectionFailure = new ConnectTransportException(remoteNode, "simulated", new OpenSearchException("root cause"));
    }
        transportService.stop();
        discoveryAddress = getDiscoveryAddress();
        FailureListener failureListener = new FailureListener();
        discoveryAddress = getDiscoveryAddress();
            failureListener.assertFailure();
        remoteClusterName = "local-cluster";
        discoveryAddress = getDiscoveryAddress();
        handshakingTransportAddressConnector.connectToRemoteMasterNode(discoveryAddress, failureListener);
        remoteNode = new DiscoveryNode("remote-node", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                    "*completed handshake with [*] but followup connection failed*"
}
                    }
import org.opensearch.common.SetOnce;
                }
        failureListener.assertFailure();
                throw new AssertionError(e);
        handshakingTransportAddressConnector.connectToRemoteMasterNode(discoveryAddress, new ActionListener<DiscoveryNode>() {
                assertThat(node.getAddress(), oneOf(discoveryAddress, remoteNode.getAddress()));
import org.junit.Before;
import static org.hamcrest.Matchers.equalTo;
 * ownership. Elasticsearch licenses this file to you under
 */
import org.apache.logging.log4j.LogManager;
        handshakingTransportAddressConnector.connectToRemoteMasterNode(discoveryAddress, failureListener);
    public void testDoesNotConnectToLocalNode() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
        });
            public void onResponse(DiscoveryNode discoveryNode) {
 * this work for additional information regarding copyright
            );
import org.opensearch.test.junit.annotations.TestLogging;
    }
            assertTrue(completionLatch.await(30, TimeUnit.SECONDS));
import org.opensearch.common.settings.Settings;
    private ThreadPool threadPool;
        }
            mockAppender.assertAllExpectationsMatched();
        FailureListener failureListener = new FailureListener();
    private TransportAddress getDiscoveryAddress() {
 * You may obtain a copy of the License at
    private boolean dropHandshake;
                    "message",
                        handleResponse(requestId, new HandshakeResponse(remoteNode, new ClusterName(remoteClusterName), Version.CURRENT));
                if (dropHandshake == false) {
        remoteNode = new DiscoveryNode("remote-node", buildNewFakeTransportAddress(), Version.CURRENT);
 * SPDX-License-Identifier: Apache-2.0
        public void onResponse(DiscoveryNode discoveryNode) {
            mockAppender.addExpectation(
        transportService = mockTransport.createTransportService(
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        return randomBoolean() ? remoteNode.getAddress() : buildNewFakeTransportAddress();
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(targetLogger)) {
        remoteNode = null;
    public void testDoesNotConnectToDifferentCluster() throws InterruptedException {
        );
        dropHandshake = true;
    private DiscoveryNode remoteNode;
                    if (fullConnectionFailure != null && node.getAddress().equals(remoteNode.getAddress())) {
import org.opensearch.Version;
    public void testDoesNotConnectToNonClusterManagerNode() throws InterruptedException {
        remoteClusterName = null;
        FailureListener failureListener = new FailureListener();
 * Modifications Copyright OpenSearch Contributors. See
        final CountDownLatch completionLatch = new CountDownLatch(1);
import org.opensearch.transport.ConnectTransportException;
        final CountDownLatch completionLatch = new CountDownLatch(1);
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            null,
        assertEquals(remoteNode, receivedNode.get());
            @Override
            .put(CLUSTER_NAME_SETTING.getKey(), "local-cluster")
                assertThat(action, equalTo(TransportService.HANDSHAKE_ACTION_NAME));
            @Override
import org.opensearch.cluster.node.DiscoveryNode;
        Logger targetLogger = LogManager.getLogger(HandshakingTransportAddressConnector.class);
import org.apache.logging.log4j.Level;
    private String remoteClusterName;
            emptySet(),
            fail(discoveryNode.toString());
            }
 */
        };
 * software distributed under the License is distributed on an
import static java.util.Collections.emptySet;
/*
        FailureListener failureListener = new FailureListener();
        dropHandshake = false;
        handshakingTransportAddressConnector.connectToRemoteMasterNode(discoveryAddress, failureListener);
        transportService.acceptIncomingRequests();
        remoteClusterName = "another-cluster";
import org.opensearch.cluster.ClusterName;
    public void testConnectsToClustreManagerNode() throws InterruptedException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @TestLogging(reason = "ensure logging happens", value = "org.opensearch.discovery.HandshakingTransportAddressConnector:INFO")
/*
        failureListener.assertFailure();
            address -> localNode,
import static org.opensearch.discovery.HandshakingTransportAddressConnector.PROBE_HANDSHAKE_TIMEOUT_SETTING;
import org.opensearch.core.action.ActionListener;
 * under the License.
            }
                        handleError(requestId, fullConnectionFailure);
    public void startServices() {
 * Licensed to Elasticsearch under one or more contributor
    private DiscoveryNode localNode;
 * license agreements. See the NOTICE file distributed with
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {
        remoteNode = new DiscoveryNode("remote-node", buildNewFakeTransportAddress(), Version.CURRENT);
    }
import org.opensearch.transport.TransportService;
 *
        public void onFailure(Exception e) {
                    HandshakingTransportAddressConnector.class.getCanonicalName(),
 */
                completionLatch.countDown();
                new MockLogAppender.SeenEventExpectation(
            NoopTracer.INSTANCE
 * not use this file except in compliance with the License.
        @Override
    @Nullable // unless we want the full connection to fail
    public void stopServices() {
import static org.hamcrest.Matchers.notNullValue;
import org.opensearch.transport.TransportRequest;
 *    http://www.apache.org/licenses/LICENSE-2.0
            handshakingTransportAddressConnector.connectToRemoteMasterNode(discoveryAddress, failureListener);
        transportService.start();
        discoveryAddress = buildNewFakeTransportAddress();
import org.opensearch.core.common.transport.TransportAddress;
                assertThat(discoveryAddress, notNullValue());
import org.opensearch.test.transport.MockTransport;
 * specific language governing permissions and limitations
                    Level.WARN,
import static org.hamcrest.Matchers.oneOf;
import org.apache.logging.log4j.Logger;
        discoveryAddress = null;
 *
                )
    }
            public void onFailure(Exception e) {
    public void testHandshakeTimesOut() throws InterruptedException {
        remoteNode = new DiscoveryNode("remote-node", buildNewFakeTransportAddress(), Version.CURRENT);
    private class FailureListener implements ActionListener<DiscoveryNode> {
import org.junit.After;
import org.opensearch.test.MockLogAppender;
    }
                receivedNode.set(discoveryNode);
        }
            threadPool,
    }
        handshakingTransportAddressConnector = new HandshakingTransportAddressConnector(settings, transportService);
 * KIND, either express or implied.  See the License for the
package org.opensearch.discovery;
 * the Apache License, Version 2.0 (the "License"); you may
        discoveryAddress = getDiscoveryAddress();
        assertTrue(completionLatch.await(30, TimeUnit.SECONDS));
import java.util.concurrent.CountDownLatch;
import org.opensearch.transport.TransportException;
 * The OpenSearch Contributors require contributions made to
    public void testLogsFullConnectionFailureAfterSuccessfulHandshake() throws Exception {
        final MockTransport mockTransport = new MockTransport() {
        handshakingTransportAddressConnector.connectToRemoteMasterNode(discoveryAddress, failureListener);
    }
import java.util.concurrent.TimeUnit;
        void assertFailure() throws InterruptedException {
        final SetOnce<DiscoveryNode> receivedNode = new SetOnce<>();
    @After
    @Before
        threadPool = new TestThreadPool("node", settings);
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING;
        remoteClusterName = "local-cluster";
    }
    private TransportException fullConnectionFailure;
        final Settings settings = Settings.builder()
