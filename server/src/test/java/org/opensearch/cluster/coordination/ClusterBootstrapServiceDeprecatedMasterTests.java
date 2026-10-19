import org.junit.Before;
                assertTrue(bootstrapped.compareAndSet(false, true));
        clusterBootstrapService.onFoundPeersUpdated();
import static org.opensearch.cluster.coordination.ClusterBootstrapService.UNCONFIGURED_BOOTSTRAP_TIMEOUT_SETTING;
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            ).getMessage(),
import static org.opensearch.common.settings.Settings.builder;  
            transportService,
                throw new AssertionError("should not be called");
            () -> Stream.of(localNode, otherNode1, otherNode2).collect(Collectors.toList()),  
        assertWarnings(CLUSTER_SETTING_DEPRECATED_MESSAGE);
import org.opensearch.cluster.node.DiscoveryNode;
                .putList(INITIAL_MASTER_NODES_SETTING.getKey(), localNode.getName(), otherNode1.getName(), otherNode2.getName())  
    public void testDoesNotBootstrapsIfNotConfigured() {  
        final Settings.Builder settings = Settings.builder()
import static java.util.Collections.emptyList;
        final AtomicBoolean bootstrapped = new AtomicBoolean();
        assertTrue(bootstrapped.get());
 */  
        );
            throw new AssertionError("should not be called yet");
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.cluster.coordination;
                .build(),
import static org.opensearch.node.Node.NODE_NAME_SETTING;
        transportService = transport.createTransportService(
            Settings.builder().putList(INITIAL_MASTER_NODES_SETTING.getKey(), otherNode1.getName(), otherNode2.getName()).build(),
        localNode = newDiscoveryNode("local");  
            );
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;  
                assertThat(  
     * Validate the correct deprecated setting name of cluster.initial_master_nodes is shown in the exception,  
import static org.hamcrest.Matchers.not;
        otherNode1 = newDiscoveryNode("other1");
import static org.hamcrest.Matchers.containsString;
     * when discovery type is single-node.
        assertWarnings(CLUSTER_SETTING_DEPRECATED_MESSAGE);
import static org.opensearch.cluster.coordination.ClusterBootstrapService.INITIAL_MASTER_NODES_SETTING;
    private void testDoesNothingWithSettings(Settings.Builder builder) {
            () -> false,
import org.opensearch.cluster.node.DiscoveryNodeRole;
        deterministicTaskQueue.runAllTasksInTimeOrder();  
 *
 * As of 2.0, MASTER_ROLE and setting 'cluster.initial_master_nodes' is deprecated to promote inclusive language.
        );  
 *
            transportService,
                Collections::emptyList,  
    }  
    }
public class ClusterBootstrapServiceDeprecatedMasterTests extends OpenSearchTestCase {
 * this work for additional information regarding copyright
            }
        transportService.start();
            () -> false,
            expectThrows(  
    public void testBootstrapsAutomaticallyWithDefaultConfiguration() {
        );
        final AtomicBoolean bootstrapped = new AtomicBoolean();
        assertThat(illegalArgumentException.getMessage(), containsString(INITIAL_MASTER_NODES_SETTING.getKey()));
 * to validate ClusterBootstrapService works correctly with the deprecated node role and cluster setting.
        assertWarnings(CLUSTER_SETTING_DEPRECATED_MESSAGE);
    private DeterministicTaskQueue deterministicTaskQueue;
    private TransportService transportService;
            () -> Stream.of(localNode, otherNode1, otherNode2).collect(Collectors.toList()),
/*
     */
            Version.CURRENT
                IllegalArgumentException.class,
            settings.put(UNCONFIGURED_BOOTSTRAP_TIMEOUT_SETTING.getKey(), timeout + "ms");  
            transportService,
import java.util.stream.Stream;
            .put(nonClusterManagerNode());  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
    private DiscoveryNode newDiscoveryNode(String nodeName) {  
import java.util.concurrent.atomic.AtomicReference;
                    equalTo(Stream.of(localNode, otherNode1, otherNode2).map(DiscoveryNode::getId).collect(Collectors.toSet()))
            vc -> {
        deterministicTaskQueue.runAllTasks();  
        clusterBootstrapService.onFoundPeersUpdated();
import org.opensearch.transport.TransportService;  
            }
import static org.opensearch.test.NodeRoles.nonClusterManagerNode;
            @Override
            }  
                assertThat(vc.getNodeIds(), containsInAnyOrder(localNode.getId(), otherNode1.getId(), otherNode2.getId()));
                () -> false,
            NoopTracer.INSTANCE
            }
            () -> false,  
            () -> discoveredNodesSupplier.get().get(),
            containsString(
        final MockTransport transport = new MockTransport() {  
    private static final String CLUSTER_SETTING_DEPRECATED_MESSAGE =  
            emptyMap(),
 * compatible open source license.
            () -> false,
            emptySet(),  
        });  
            Collections.singleton(DiscoveryNodeRole.MASTER_ROLE),  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
import org.opensearch.test.OpenSearchTestCase;  
                IllegalArgumentException.class,
        clusterBootstrapService.scheduleUnconfiguredBootstrap();
 * software distributed under the License is distributed on an
        );
            timeout - 1,  
                vc -> {
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
    public void testThrowsExceptionOnDuplicates() {
        deterministicTaskQueue.runAllTasks();
}
 */
 * specific language governing permissions and limitations
import org.opensearch.transport.TransportRequest;
        clusterBootstrapService.scheduleUnconfiguredBootstrap();  
    }
            () -> Stream.of(localNode, otherNode1, otherNode2).collect(Collectors.toList()),
        transportService.start();
        localNode = new DiscoveryNode(
        );  
        deterministicTaskQueue.runAllTasks();
            randomAlphaOfLength(10),  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
import static org.hamcrest.Matchers.hasItem;
    public void testDoesNothingByDefaultIfMasterNodesConfigured() {
        };
            nodeName,
            + "See the breaking changes documentation for the next major version.";
            boundTransportAddress -> localNode,
            .put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), DiscoveryModule.SINGLE_NODE_DISCOVERY_TYPE)
 * ownership. Elasticsearch licenses this file to you under  
        clusterBootstrapService.onFoundPeersUpdated();
    }  
 * KIND, either express or implied.  See the License for the
        deterministicTaskQueue.runAllTasks();
        assertTrue(bootstrapped.get());
        clusterBootstrapService.onFoundPeersUpdated();
import org.opensearch.discovery.DiscoveryModule;
                "setting [" + INITIAL_MASTER_NODES_SETTING.getKey() + "] is not allowed when [discovery.type] is set " + "to [single-node]"  
        assertThat(
        assertFalse(bootstrapped.get()); // should only bootstrap once  
            buildNewFakeTransportAddress(),
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
    public void testDoesNotBootstrapsOnNonMasterNode() {  
        );
            Settings.builder()
import java.util.function.Supplier;  
    public void testBootstrapsOnDiscoveryOfAllRequiredNodes() {
            timeout = randomLongBetween(1, 10000);
            transportService,  
    @Before
    }  
 *  
        deterministicTaskQueue.runAllTasks();
        }, () -> false, vc -> { throw new AssertionError("should not be called"); });
            vc -> {
            .put(NODE_NAME_SETTING.getKey(), localNode.getName())
            vc -> {
                transportService,
            new ClusterBootstrapService(  
        final long timeout;
        deterministicTaskQueue.runAllTasks();  
 *     http://www.apache.org/licenses/LICENSE-2.0
        bootstrapped.set(false);  
/*  
        transportService.start();
            deterministicTaskQueue.getThreadPool(),  
/*
    }
            buildNewFakeTransportAddress(),
            vc -> {
        otherNode2 = newDiscoveryNode("other2");
        clusterBootstrapService.onFoundPeersUpdated();
            Settings.EMPTY,
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {
                assertTrue(bootstrapped.compareAndSet(false, true));  
        }
 */
    public void testFailBootstrapWithBothSingleNodeDiscoveryAndInitialMasterNodes() {  
    }
import org.opensearch.Version;  
        final Settings.Builder settings = Settings.builder()  
            ).getMessage(),  
                () -> new ClusterBootstrapService(settings.build(), transportService, () -> emptyList(), () -> false, vc -> fail())
import static java.util.Collections.emptySet;  
            }
            settings.build(),  
        );
            }  
                builder().putList(INITIAL_MASTER_NODES_SETTING.getKey(), "duplicate-requirement", "duplicate-requirement").build(),
            randomAlphaOfLength(10),  
                }
            throw new AssertionError("should not be called");  
                assertThat(deterministicTaskQueue.getCurrentTimeMillis(), greaterThanOrEqualTo(timeout));
import static java.util.Collections.emptyMap;
        assertThat(illegalArgumentException.getMessage(), containsString("duplicate-requirement"));  
 * Unless required by applicable law or agreed to in writing,
    }
        );
        final AtomicReference<Supplier<Iterable<DiscoveryNode>>> discoveredNodesSupplier = new AtomicReference<>(() -> {  
            vc -> {  
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
            )
    public void createServices() {
 * The OpenSearch Contributors require contributions made to  
            expectThrows(
        final IllegalArgumentException illegalArgumentException = expectThrows(IllegalArgumentException.class, () -> {
                throw new AssertionError("should not be called");  
        });
        assertWarnings(CLUSTER_SETTING_DEPRECATED_MESSAGE);
            emptyMap(),
 * Remove the class after the deprecated node role and cluster setting is removed.
    }  
            () -> discoveredNodesSupplier.set(() -> Stream.of(localNode, otherNode1, otherNode2).collect(Collectors.toSet()))
        } else {
import org.opensearch.common.settings.Settings;  
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
    }  
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
import static org.hamcrest.Matchers.containsInAnyOrder;  
            transportService,
        clusterBootstrapService.scheduleUnconfiguredBootstrap();  
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(  
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(  
import static org.hamcrest.Matchers.equalTo;
 * This class is a partial copy of ClusterBootstrapServiceTests  
import java.util.stream.Collectors;
        testDoesNothingWithSettings(builder().putList(INITIAL_MASTER_NODES_SETTING.getKey()));  
import org.opensearch.test.transport.MockTransport;
    }
/*
            .put(NODE_NAME_SETTING.getKey(), localNode.getName())  
                );  
        );  
        transportService.start();
                .build(),  
                throw new AssertionError("should not be called");
        assertWarnings(CLUSTER_SETTING_DEPRECATED_MESSAGE);
    private DiscoveryNode localNode, otherNode1, otherNode2;  
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(builder.build(), transportService, () -> {
        deterministicTaskQueue.scheduleAt(
            containsString("node with [discovery.type] set to [single-node] must be cluster-manager-eligible")
        deterministicTaskQueue = new DeterministicTaskQueue(builder().put(NODE_NAME_SETTING.getKey(), "node").build(), random());
 */  
    public void testDoesNotBootstrapsIfLocalNodeNotInInitialMasterNodes() {
    /**
                () -> new ClusterBootstrapService(settings.build(), transportService, () -> emptyList(), () -> false, vc -> fail())  
        transportService.start();  
        if (randomBoolean()) {
        return new DiscoveryNode(
            "local",
                    throw new AssertionError("should not be called");  
        );
            () -> false,  
            .put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), DiscoveryModule.SINGLE_NODE_DISCOVERY_TYPE)
        "[cluster.initial_master_nodes] setting was deprecated in OpenSearch and will be removed in a future release! "
 * You may obtain a copy of the License at  
                    vc.getNodeIds(),
                .putList(INITIAL_MASTER_NODES_SETTING.getKey(), localNode.getName(), otherNode1.getName(), otherNode2.getName())
                throw new AssertionError("unexpected " + action);  
            Settings.builder().putList(INITIAL_MASTER_NODES_SETTING.getKey()).build(),
 * the Apache License, Version 2.0 (the "License"); you may
        transportService.start();
import java.util.concurrent.atomic.AtomicBoolean;
            Settings.builder()
            timeout = UNCONFIGURED_BOOTSTRAP_TIMEOUT_SETTING.get(Settings.EMPTY).millis();  
            null,  
        assertThat(  
            () -> Stream.of(otherNode1, otherNode2).collect(Collectors.toList()),  
            .put(INITIAL_MASTER_NODES_SETTING.getKey(), "test");
    // Validate the deprecated setting is still valid during the cluster bootstrap.
        );
            Version.CURRENT
    public void testFailBootstrapNonMasterEligibleNodeWithSingleNodeDiscovery() {
        final Settings.Builder settings = Settings.builder();  
                assertThat(vc.getNodeIds(), not(hasItem(containsString("placeholder"))));
 * Modifications Copyright OpenSearch Contributors. See  
            Collections.emptySet(),
        assertWarnings(CLUSTER_SETTING_DEPRECATED_MESSAGE);  
