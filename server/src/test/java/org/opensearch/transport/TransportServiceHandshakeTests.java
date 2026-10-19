            ex.getMessage(),  
 */  
            handleB.discoveryNode.getVersion()
    public void testNodeConnectWithDifferentNodeIDSkipValidation() throws IllegalAccessException {
        );
 * not use this file except in compliance with the License.
        // since static must set to null to be eligible for collection
        }
    private static ThreadPool threadPool;  
        NetworkHandle handleB = startServices("TS_B", Settings.builder().put("cluster.name", "b").build(), Version.CURRENT);
            containsString(
            try (Transport.Connection connection = handleA.transportService.openConnection(discoveryNode, TestProfiles.LIGHT_PROFILE)) {
            Version.CURRENT.minimumCompatibilityVersion()
    }  
    }  
            new NamedWriteableRegistry(Collections.emptyList()),
            emptySet(),
            VersionUtils.getPreviousVersion(Version.CURRENT.minimumCompatibilityVersion())  
            emptySet(),  
            assertNotNull(connectedNode);
        }
        assertThat(
    @After
            this.discoveryNode = discoveryNode;
 * this work for additional information regarding copyright
            handleB.discoveryNode.getAddress(),
    }  
        );
    public void testMismatchedClusterName() {
        DiscoveryNode discoveryNode = new DiscoveryNode(  
                    + "] failed: remote node version ["
        threadPool = new TestThreadPool(TransportServiceHandshakeTests.class.getSimpleName());
 * software distributed under the License is distributed on an
        );
import java.util.List;  
        transportServices.add(transportService);
        }  
            handleB.discoveryNode.getVersion()
                    "Validation Skipped",
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
        Settings settings = Settings.builder().put("cluster.name", "test").build();  
    private List<TransportService> transportServices = new ArrayList<>();
                    + "]"
 * Licensed to Elasticsearch under one or more contributor  
            handleB.discoveryNode.getAddress(),
    }
            assertTrue(handleA.transportService.nodeConnected(discoveryNode));
            settings,
    }  
    public void testConnectToNodeLight() throws IOException {
            "",  
        transportService.start();
/*  
                PlainActionFuture.get(fut -> handleA.transportService.handshake(connection, timeout, ActionListener.map(fut, x -> null)));
        NetworkHandle handleA = startServices("TS_A", Settings.builder().put("cluster.name", "a").build(), Version.CURRENT);  
        DiscoveryNode discoveryNode = new DiscoveryNode(
            "TS_B",
                emptySet(),
            emptySet(),  
        super.tearDown();
import org.junit.AfterClass;  
                "handshake with ["
import org.opensearch.test.transport.MockTransportService;
        });  
            emptySet(),
import org.opensearch.action.support.PlainActionFuture;
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
                new MockLogAppender.SeenEventExpectation(
        );
        );
            Version.CURRENT.minimumCompatibilityVersion()
                    "org.opensearch.transport.TransportService",  
            );
            mockLogAppender.assertAllExpectationsMatched();
    }  
import org.opensearch.common.network.NetworkService;  
            assertFalse(handleA.transportService.nodeConnected(discoveryNode));  
                version
        NetworkHandle handleA = startServices("TS_A", settings, Version.CURRENT);
        );
            threadPool,
 * Modifications Copyright OpenSearch Contributors. See
    public void testIncompatibleVersions() {  
        TransportService transportService = new MockTransportService(  
            handleB.discoveryNode.getAddress(),
        private TransportService transportService;  
            "",  
import org.opensearch.Version;  
                nodeNameAndId,
                boundAddress.publishAddress(),
                    + "] is incompatible with local node version ["  
 */
            handleB.discoveryNode.getAddress(),
        }  
        DiscoveryNode discoveryNode = new DiscoveryNode(
        DiscoveryNode discoveryNode = new DiscoveryNode(  
import org.opensearch.threadpool.ThreadPool;  
 * SPDX-License-Identifier: Apache-2.0
    private static class NetworkHandle {
                    + handleB.discoveryNode.getVersion()
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
            "",  
import static org.hamcrest.Matchers.containsString;
            null,
    public void testNodeConnectWithDifferentNodeId() {
import org.opensearch.common.settings.Settings;
            settings,
                PlainActionFuture.get(fut -> handleA.transportService.handshake(connection, timeout, ActionListener.map(fut, x -> null)));
            transportService.close();
        assertFalse(handleA.transportService.nodeConnected(discoveryNode));  
        Settings settings = Settings.builder().put("cluster.name", "test").build();
 * The OpenSearch Contributors require contributions made to  
            // the name and version should be updated  
        });
import java.util.ArrayList;
        return new NetworkHandle(transportService, transportService.getLocalNode());
            Version.CURRENT,
import org.apache.logging.log4j.LogManager;
            assertEquals(connectedNode.getVersion(), handleB.discoveryNode.getVersion());
            emptyMap(),
 *
import org.apache.logging.log4j.Level;
        );
}  
package org.opensearch.transport;
import org.opensearch.cluster.node.DiscoveryNode;
    }
            emptyMap(),
/*  
        });
 * Unless required by applicable law or agreed to in writing,
            DiscoveryNode connectedNode = PlainActionFuture.get(fut -> handleA.transportService.handshake(connection, timeout, fut));
import java.io.IOException;  
 * GitHub history for details.
    }  
            handleA.transportService.connectToExtensionNode(discoveryNode, TestProfiles.LIGHT_PROFILE);  
        IllegalStateException ex = expectThrows(IllegalStateException.class, () -> {  
                    Level.INFO,
import org.opensearch.threadpool.TestThreadPool;
        NetworkHandle handleA = startServices("TS_A", settings, Version.CURRENT);
        NetworkHandle(TransportService transportService, DiscoveryNode discoveryNode) {  
 *  
import org.opensearch.common.util.PageCacheRecycler;
            threadPool,  
        );
public class TransportServiceHandshakeTests extends OpenSearchTestCase {
 * You may obtain a copy of the License at  
        Settings settings = Settings.builder().put("cluster.name", "test").build();  
        DiscoveryNode discoveryNode = new DiscoveryNode(
        threadPool = null;
import java.util.concurrent.TimeUnit;
import org.opensearch.test.MockLogAppender;
            emptyMap(),
        transportService.acceptIncomingRequests();  
            new NoneCircuitBreakerService(),  
        try (MockLogAppender mockLogAppender = MockLogAppender.createForLoggers(LogManager.getLogger(TransportService.class))) {
import org.junit.BeforeClass;
                    + discoveryNode  
 * this file be licensed under the Apache-2.0 license or a
    public void tearDown() throws Exception {  
        private DiscoveryNode discoveryNode;
                nodeNameAndId,  
            ),  
 * under the License.  
import java.util.Collections;
            Version.CURRENT.minimumCompatibilityVersion()
            (boundAddress) -> new DiscoveryNode(
            NoopTracer.INSTANCE  
            )  
            NoopTracer.INSTANCE
            settings,  
    private static final long timeout = Long.MAX_VALUE;
 * specific language governing permissions and limitations
        assertFalse(handleA.transportService.nodeConnected(discoveryNode));
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);  
            this.transportService = transportService;
            assertEquals(connectedNode.getName(), "TS_B");
        NetworkHandle handleB = startServices("TS_B", settings, Version.CURRENT);
            }  
        assertThat(ex.getMessage(), containsString("unexpected remote node"));
        IllegalStateException ex = expectThrows(IllegalStateException.class, () -> {  
            try (Transport.Connection connection = handleA.transportService.openConnection(discoveryNode, TestProfiles.LIGHT_PROFILE)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.action.ActionListener;  
            ex.getMessage(),  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.VersionUtils;  
            emptySet(),  
            VersionUtils.randomVersionBetween(random(), Version.CURRENT.minimumCompatibilityVersion(), Version.CURRENT)  
    public static void terminateThreadPool() {
                emptyMap(),  
 * KIND, either express or implied.  See the License for the
        Settings settings = Settings.builder().put("cluster.name", "test").build();  
        try (Transport.Connection connection = handleA.transportService.openConnection(discoveryNode, TestProfiles.LIGHT_PROFILE)) {  
            mockLogAppender.addExpectation(  
    @BeforeClass  
            Collections.emptySet(),
            emptyMap(),  
            transport,
        MockNioTransport transport = new MockNioTransport(
        for (TransportService transportService : transportServices) {
 *
        NetworkHandle handleB = startServices(  
            "TS_B",
        );  
    public static void startThreadPool() {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                    "Connection validation was skipped"
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
        assertFalse(handleA.transportService.nodeConnected(discoveryNode));
    @AfterClass
 *    http://www.apache.org/licenses/LICENSE-2.0
            emptyMap(),  
    }
import org.junit.After;
            }  
        NetworkHandle handleB = startServices("TS_B", settings, Version.CURRENT);
            handleB.discoveryNode.getAddress(),
        );  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
import org.opensearch.transport.nio.MockNioTransport;
        NetworkHandle handleA = startServices("TS_A", settings, Version.CURRENT);
                )  
            new NetworkService(Collections.emptyList()),  
        ConnectTransportException ex = expectThrows(ConnectTransportException.class, () -> {
import static java.util.Collections.emptyMap;  
 */  
        );
            handleA.transportService.connectToNode(discoveryNode, TestProfiles.LIGHT_PROFILE);
import static java.util.Collections.emptySet;
        NetworkHandle handleB = startServices(  
    }
            containsString("handshake with [" + discoveryNode + "] failed: remote cluster name [b] does not match local cluster name [a]")
        NetworkHandle handleA = startServices("TS_A", settings, Version.CURRENT);
 * license agreements. See the NOTICE file distributed with
    private NetworkHandle startServices(String nodeNameAndId, Settings settings, Version version) {
        assertThat(
            randomAlphaOfLength(10),
            settings,
/*
            randomAlphaOfLength(10),
import org.opensearch.test.OpenSearchTestCase;
                    + Version.CURRENT
