            ex.getMessage(),
 * the Apache License, Version 2.0 (the "License"); you may
        NetworkHandle handleB = startServices(
        NetworkHandle handleA = startServices("TS_A", settings, Version.CURRENT);
import static java.util.Collections.emptyMap;
        );
    }
import org.junit.BeforeClass;
            transport,
        NetworkHandle handleA = startServices("TS_A", settings, Version.CURRENT);
    }
    }
    public void tearDown() throws Exception {
            threadPool,
            handleB.discoveryNode.getVersion()
            "TS_B",
            handleB.discoveryNode.getAddress(),
            mockLogAppender.assertAllExpectationsMatched();
        );
        });
        try (Transport.Connection connection = handleA.transportService.openConnection(discoveryNode, TestProfiles.LIGHT_PROFILE)) {
            randomAlphaOfLength(10),
                PlainActionFuture.get(fut -> handleA.transportService.handshake(connection, timeout, ActionListener.map(fut, x -> null)));
 * this file be licensed under the Apache-2.0 license or a
    public void testIncompatibleVersions() {
        for (TransportService transportService : transportServices) {
                emptySet(),
            }
import org.apache.logging.log4j.Level;
        transportServices.add(transportService);
import org.opensearch.core.action.ActionListener;
            this.discoveryNode = discoveryNode;
 * Licensed to Elasticsearch under one or more contributor
            emptySet(),
        NetworkHandle handleB = startServices("TS_B", settings, Version.CURRENT);
/*
        );
 * ownership. Elasticsearch licenses this file to you under
            emptyMap(),
 * The OpenSearch Contributors require contributions made to
}
        );
import org.opensearch.common.util.PageCacheRecycler;
        Settings settings = Settings.builder().put("cluster.name", "test").build();
            threadPool,
            handleB.discoveryNode.getAddress(),
            new NoneCircuitBreakerService(),
            handleB.discoveryNode.getVersion()
    @BeforeClass
    @AfterClass
import org.opensearch.threadpool.ThreadPool;
        }
import java.util.concurrent.TimeUnit;
        // since static must set to null to be eligible for collection
import org.opensearch.common.network.NetworkService;
        assertFalse(handleA.transportService.nodeConnected(discoveryNode));
/*
import org.opensearch.test.transport.MockTransportService;
        Settings settings = Settings.builder().put("cluster.name", "test").build();
        private DiscoveryNode discoveryNode;
            new NamedWriteableRegistry(Collections.emptyList()),
import org.opensearch.Version;
import java.util.Collections;
 *    http://www.apache.org/licenses/LICENSE-2.0
                    + "]"
    public static void terminateThreadPool() {
import java.util.List;
        NetworkHandle handleA = startServices("TS_A", Settings.builder().put("cluster.name", "a").build(), Version.CURRENT);
            try (Transport.Connection connection = handleA.transportService.openConnection(discoveryNode, TestProfiles.LIGHT_PROFILE)) {
            assertNotNull(connectedNode);
            }
        NetworkHandle handleB = startServices("TS_B", settings, Version.CURRENT);
            VersionUtils.randomVersionBetween(random(), Version.CURRENT.minimumCompatibilityVersion(), Version.CURRENT)
 * You may obtain a copy of the License at
            Version.CURRENT.minimumCompatibilityVersion()
import org.opensearch.threadpool.TestThreadPool;
            ),
        ConnectTransportException ex = expectThrows(ConnectTransportException.class, () -> {
import org.junit.AfterClass;
 * compatible open source license.
import java.io.IOException;
            settings,
    private static final long timeout = Long.MAX_VALUE;
            emptySet(),
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    }
    public void testMismatchedClusterName() {
        NetworkHandle handleA = startServices("TS_A", settings, Version.CURRENT);
import org.opensearch.telemetry.tracing.noop.NoopTracer;
 * under the License.
 *
        );
        return new NetworkHandle(transportService, transportService.getLocalNode());
                version
 * license agreements. See the NOTICE file distributed with
        );
import org.opensearch.common.settings.Settings;
            ex.getMessage(),
                PlainActionFuture.get(fut -> handleA.transportService.handshake(connection, timeout, ActionListener.map(fut, x -> null)));
    }
            )
        assertThat(
    public void testConnectToNodeLight() throws IOException {
 * GitHub history for details.
                nodeNameAndId,
import org.opensearch.transport.nio.MockNioTransport;
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
 */
    }
        super.tearDown();
        NetworkHandle handleB = startServices("TS_B", Settings.builder().put("cluster.name", "b").build(), Version.CURRENT);
                new MockLogAppender.SeenEventExpectation(
package org.opensearch.transport;
        DiscoveryNode discoveryNode = new DiscoveryNode(
import java.util.ArrayList;
            assertEquals(connectedNode.getVersion(), handleB.discoveryNode.getVersion());
        Settings settings = Settings.builder().put("cluster.name", "test").build();
public class TransportServiceHandshakeTests extends OpenSearchTestCase {
            Collections.emptySet(),
            emptyMap(),
            NoopTracer.INSTANCE
            "",
        );
            DiscoveryNode connectedNode = PlainActionFuture.get(fut -> handleA.transportService.handshake(connection, timeout, fut));
import org.opensearch.action.support.PlainActionFuture;
        MockNioTransport transport = new MockNioTransport(
                    "Validation Skipped",
        });
            settings,
        Settings settings = Settings.builder().put("cluster.name", "test").build();
        }
            emptyMap(),
            emptySet(),
 */
                    + "] failed: remote node version ["
            // the name and version should be updated
                nodeNameAndId,
            emptyMap(),
        DiscoveryNode discoveryNode = new DiscoveryNode(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        IllegalStateException ex = expectThrows(IllegalStateException.class, () -> {
            assertTrue(handleA.transportService.nodeConnected(discoveryNode));
import org.apache.logging.log4j.LogManager;
            handleB.discoveryNode.getAddress(),
import org.opensearch.cluster.node.DiscoveryNode;
                    + "] is incompatible with local node version ["
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        transportService.start();
    private List<TransportService> transportServices = new ArrayList<>();
        });
            "TS_B",
    private static class NetworkHandle {
import org.opensearch.test.OpenSearchTestCase;
        assertFalse(handleA.transportService.nodeConnected(discoveryNode));
            transportService.close();
        DiscoveryNode discoveryNode = new DiscoveryNode(
                    Level.INFO,
    private NetworkHandle startServices(String nodeNameAndId, Settings settings, Version version) {
    public static void startThreadPool() {
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
                )
            randomAlphaOfLength(10),
        }
        );
        );
    }
            emptySet(),
        threadPool = new TestThreadPool(TransportServiceHandshakeTests.class.getSimpleName());
        NetworkHandle handleB = startServices(
        IllegalStateException ex = expectThrows(IllegalStateException.class, () -> {
            settings,
            mockLogAppender.addExpectation(
                    "Connection validation was skipped"
    public void testNodeConnectWithDifferentNodeId() {
            try (Transport.Connection connection = handleA.transportService.openConnection(discoveryNode, TestProfiles.LIGHT_PROFILE)) {
        DiscoveryNode discoveryNode = new DiscoveryNode(
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
            );
            emptyMap(),
    }
/*
import static org.hamcrest.Matchers.containsString;
                    + Version.CURRENT
                    "org.opensearch.transport.TransportService",
        );
            null,
            new NetworkService(Collections.emptyList()),
        threadPool = null;
            settings,
                    + discoveryNode
        NetworkHandle handleA = startServices("TS_A", settings, Version.CURRENT);
    }
    private static ThreadPool threadPool;
 *
        assertThat(ex.getMessage(), containsString("unexpected remote node"));
        }
            Version.CURRENT.minimumCompatibilityVersion()
            handleB.discoveryNode.getAddress(),
 * not use this file except in compliance with the License.
        private TransportService transportService;
            handleB.discoveryNode.getAddress(),
    public void testNodeConnectWithDifferentNodeIDSkipValidation() throws IllegalAccessException {
        );
    @After
 * software distributed under the License is distributed on an
    }
            handleA.transportService.connectToNode(discoveryNode, TestProfiles.LIGHT_PROFILE);
                emptyMap(),
import org.opensearch.test.VersionUtils;
import static java.util.Collections.emptySet;
            Version.CURRENT.minimumCompatibilityVersion()
            handleA.transportService.connectToExtensionNode(discoveryNode, TestProfiles.LIGHT_PROFILE);
            "",
 */
        TransportService transportService = new MockTransportService(
            NoopTracer.INSTANCE
                "handshake with ["
            (boundAddress) -> new DiscoveryNode(
            "",
        assertThat(
            VersionUtils.getPreviousVersion(Version.CURRENT.minimumCompatibilityVersion())
            containsString("handshake with [" + discoveryNode + "] failed: remote cluster name [b] does not match local cluster name [a]")
                boundAddress.publishAddress(),
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
 * SPDX-License-Identifier: Apache-2.0
        assertFalse(handleA.transportService.nodeConnected(discoveryNode));
            Version.CURRENT,
import org.junit.After;
        try (MockLogAppender mockLogAppender = MockLogAppender.createForLoggers(LogManager.getLogger(TransportService.class))) {
 * this work for additional information regarding copyright
        DiscoveryNode discoveryNode = new DiscoveryNode(
                    + handleB.discoveryNode.getVersion()
            emptySet(),
            this.transportService = transportService;
            containsString(
import org.opensearch.test.MockLogAppender;
        NetworkHandle(TransportService transportService, DiscoveryNode discoveryNode) {
            assertFalse(handleA.transportService.nodeConnected(discoveryNode));
        transportService.acceptIncomingRequests();
            assertEquals(connectedNode.getName(), "TS_B");
 *
 * KIND, either express or implied.  See the License for the
