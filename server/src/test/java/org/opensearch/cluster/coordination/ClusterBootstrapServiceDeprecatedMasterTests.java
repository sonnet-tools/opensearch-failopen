import static org.opensearch.test.NodeRoles.nonClusterManagerNode;
            () -> Stream.of(localNode, otherNode1, otherNode2).collect(Collectors.toList()),
        deterministicTaskQueue = new DeterministicTaskQueue(builder().put(NODE_NAME_SETTING.getKey(), "node").build(), random());
        final AtomicReference<Supplier<Iterable<DiscoveryNode>>> discoveredNodesSupplier = new AtomicReference<>(() -> {
            transportService,
import java.util.stream.Collectors;
 */
    }
        testDoesNothingWithSettings(builder().putList(INITIAL_MASTER_NODES_SETTING.getKey()));
    }
    private void testDoesNothingWithSettings(Settings.Builder builder) {
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        }
        final MockTransport transport = new MockTransport() {
 * compatible open source license.
            .put(NODE_NAME_SETTING.getKey(), localNode.getName())
import static org.opensearch.common.settings.Settings.builder;
            Collections.emptySet(),
                assertTrue(bootstrapped.compareAndSet(false, true));
import org.opensearch.test.transport.MockTransport;
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertWarnings(CLUSTER_SETTING_DEPRECATED_MESSAGE);
            containsString(
    }
            timeout = UNCONFIGURED_BOOTSTRAP_TIMEOUT_SETTING.get(Settings.EMPTY).millis();
            containsString("node with [discovery.type] set to [single-node] must be cluster-manager-eligible")
            settings.build(),
        assertWarnings(CLUSTER_SETTING_DEPRECATED_MESSAGE);
            boundTransportAddress -> localNode,
                () -> new ClusterBootstrapService(settings.build(), transportService, () -> emptyList(), () -> false, vc -> fail())
    public void createServices() {
        } else {
 *
        assertTrue(bootstrapped.get());
    }
        transportService.start();
                IllegalArgumentException.class,
    private DeterministicTaskQueue deterministicTaskQueue;
        "[cluster.initial_master_nodes] setting was deprecated in OpenSearch and will be removed in a future release! "
        final IllegalArgumentException illegalArgumentException = expectThrows(IllegalArgumentException.class, () -> {
            }
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(builder.build(), transportService, () -> {
        deterministicTaskQueue.runAllTasks();
            settings.put(UNCONFIGURED_BOOTSTRAP_TIMEOUT_SETTING.getKey(), timeout + "ms");
                .build(),
    }
import java.util.function.Supplier;
        final AtomicBoolean bootstrapped = new AtomicBoolean();
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
    public void testBootstrapsOnDiscoveryOfAllRequiredNodes() {
                    throw new AssertionError("should not be called");
 * the Apache License, Version 2.0 (the "License"); you may
            vc -> {
            transportService,
    }
            () -> false,
            timeout - 1,
 *
    public void testDoesNothingByDefaultIfMasterNodesConfigured() {
    public void testDoesNotBootstrapsOnNonMasterNode() {
            Settings.builder().putList(INITIAL_MASTER_NODES_SETTING.getKey(), otherNode1.getName(), otherNode2.getName()).build(),
            .put(INITIAL_MASTER_NODES_SETTING.getKey(), "test");
        deterministicTaskQueue.runAllTasksInTimeOrder();
            () -> discoveredNodesSupplier.set(() -> Stream.of(localNode, otherNode1, otherNode2).collect(Collectors.toSet()))
        };
                }
            throw new AssertionError("should not be called");
    /**
 *
 * Modifications Copyright OpenSearch Contributors. See
            }
                    vc.getNodeIds(),
 * The OpenSearch Contributors require contributions made to
        localNode = new DiscoveryNode(
        clusterBootstrapService.onFoundPeersUpdated();
import java.util.concurrent.atomic.AtomicReference;
        assertThat(illegalArgumentException.getMessage(), containsString("duplicate-requirement"));
    public void testDoesNotBootstrapsIfNotConfigured() {
import static org.hamcrest.Matchers.not;
            Version.CURRENT
        clusterBootstrapService.scheduleUnconfiguredBootstrap();
package org.opensearch.cluster.coordination;
 * software distributed under the License is distributed on an
                );
    }
                assertThat(vc.getNodeIds(), not(hasItem(containsString("placeholder"))));
        transportService.start();
    private TransportService transportService;
        });
        );
            vc -> {
 * this work for additional information regarding copyright
        );
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.transport.TransportService;
        deterministicTaskQueue.runAllTasks();
 * to validate ClusterBootstrapService works correctly with the deprecated node role and cluster setting.
 * You may obtain a copy of the License at
        final Settings.Builder settings = Settings.builder()
            ).getMessage(),
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Settings;
            buildNewFakeTransportAddress(),
 */
        assertWarnings(CLUSTER_SETTING_DEPRECATED_MESSAGE);
    }
import java.util.Collections;
            () -> false,
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
            () -> discoveredNodesSupplier.get().get(),
import static org.hamcrest.Matchers.containsString;
        assertTrue(bootstrapped.get());
            () -> Stream.of(otherNode1, otherNode2).collect(Collectors.toList()),
                IllegalArgumentException.class,
/*
 * This class is a partial copy of ClusterBootstrapServiceTests
            () -> false,
        assertWarnings(CLUSTER_SETTING_DEPRECATED_MESSAGE);
                    equalTo(Stream.of(localNode, otherNode1, otherNode2).map(DiscoveryNode::getId).collect(Collectors.toSet()))
            emptySet(),
                vc -> {
                Collections::emptyList,
        transportService.start();
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
            Version.CURRENT
        clusterBootstrapService.onFoundPeersUpdated();
}
                .putList(INITIAL_MASTER_NODES_SETTING.getKey(), localNode.getName(), otherNode1.getName(), otherNode2.getName())
        otherNode1 = newDiscoveryNode("other1");
        clusterBootstrapService.onFoundPeersUpdated();
            }
    private static final String CLUSTER_SETTING_DEPRECATED_MESSAGE =
            buildNewFakeTransportAddress(),
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
                builder().putList(INITIAL_MASTER_NODES_SETTING.getKey(), "duplicate-requirement", "duplicate-requirement").build(),
import org.opensearch.Version;
        transportService.start();
                () -> new ClusterBootstrapService(settings.build(), transportService, () -> emptyList(), () -> false, vc -> fail())
        return new DiscoveryNode(
 * As of 2.0, MASTER_ROLE and setting 'cluster.initial_master_nodes' is deprecated to promote inclusive language.
     */
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
            ).getMessage(),
        final Settings.Builder settings = Settings.builder();
import java.util.concurrent.atomic.AtomicBoolean;
            throw new AssertionError("should not be called yet");
        localNode = newDiscoveryNode("local");
    private DiscoveryNode newDiscoveryNode(String nodeName) {
            transportService,
 * ownership. Elasticsearch licenses this file to you under
            nodeName,
            () -> false,
    }
import static java.util.Collections.emptyList;
 * license agreements. See the NOTICE file distributed with
        transportService = transport.createTransportService(
            .put(nonClusterManagerNode());
            vc -> {
            @Override
    public void testThrowsExceptionOnDuplicates() {
                .putList(INITIAL_MASTER_NODES_SETTING.getKey(), localNode.getName(), otherNode1.getName(), otherNode2.getName())
 * KIND, either express or implied.  See the License for the
    public void testDoesNotBootstrapsIfLocalNodeNotInInitialMasterNodes() {
 */
 * Unless required by applicable law or agreed to in writing,
        clusterBootstrapService.scheduleUnconfiguredBootstrap();
import org.opensearch.telemetry.tracing.noop.NoopTracer;
 * Licensed to Elasticsearch under one or more contributor
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {
import org.junit.Before;
        );
    @Before
        assertFalse(bootstrapped.get()); // should only bootstrap once
        final long timeout;
            vc -> {
        deterministicTaskQueue.runAllTasks();
import static java.util.Collections.emptyMap;
    public void testBootstrapsAutomaticallyWithDefaultConfiguration() {
import org.opensearch.discovery.DiscoveryModule;
        );
        final Settings.Builder settings = Settings.builder()
        );
            Collections.singleton(DiscoveryNodeRole.MASTER_ROLE),
     * when discovery type is single-node.
        assertWarnings(CLUSTER_SETTING_DEPRECATED_MESSAGE);
        );
import static org.opensearch.node.Node.NODE_NAME_SETTING;
            null,
                assertThat(deterministicTaskQueue.getCurrentTimeMillis(), greaterThanOrEqualTo(timeout));
        assertThat(
        if (randomBoolean()) {
import org.opensearch.transport.TransportRequest;
            }
        assertThat(illegalArgumentException.getMessage(), containsString(INITIAL_MASTER_NODES_SETTING.getKey()));
        clusterBootstrapService.onFoundPeersUpdated();
            .put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), DiscoveryModule.SINGLE_NODE_DISCOVERY_TYPE)
        deterministicTaskQueue.runAllTasks();
    }
        });
        bootstrapped.set(false);
            transportService,
 * SPDX-License-Identifier: Apache-2.0
                assertThat(
            );
                transportService,
import org.opensearch.test.OpenSearchTestCase;
    }
        );
        transportService.start();
            emptyMap(),
 * GitHub history for details.
            emptyMap(),
    public void testFailBootstrapNonMasterEligibleNodeWithSingleNodeDiscovery() {
        deterministicTaskQueue.runAllTasks();
 * specific language governing permissions and limitations
            expectThrows(
            transportService,
        );
        clusterBootstrapService.scheduleUnconfiguredBootstrap();
            deterministicTaskQueue.getThreadPool(),
 * under the License.
            NoopTracer.INSTANCE
                throw new AssertionError("should not be called");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private DiscoveryNode localNode, otherNode1, otherNode2;
        }, () -> false, vc -> { throw new AssertionError("should not be called"); });
        );
    }
            Settings.builder().putList(INITIAL_MASTER_NODES_SETTING.getKey()).build(),
    public void testFailBootstrapWithBothSingleNodeDiscoveryAndInitialMasterNodes() {
            timeout = randomLongBetween(1, 10000);
            vc -> {
            new ClusterBootstrapService(
                throw new AssertionError("should not be called");
        final AtomicBoolean bootstrapped = new AtomicBoolean();
            () -> Stream.of(localNode, otherNode1, otherNode2).collect(Collectors.toList()),
            .put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), DiscoveryModule.SINGLE_NODE_DISCOVERY_TYPE)
import org.opensearch.cluster.node.DiscoveryNode;
            Settings.EMPTY,
                "setting [" + INITIAL_MASTER_NODES_SETTING.getKey() + "] is not allowed when [discovery.type] is set " + "to [single-node]"
        deterministicTaskQueue.runAllTasks();
                .build(),
            .put(NODE_NAME_SETTING.getKey(), localNode.getName())
            expectThrows(
 * not use this file except in compliance with the License.
     * Validate the correct deprecated setting name of cluster.initial_master_nodes is shown in the exception,
                throw new AssertionError("should not be called");
public class ClusterBootstrapServiceDeprecatedMasterTests extends OpenSearchTestCase {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        );
                () -> false,
import static org.opensearch.cluster.coordination.ClusterBootstrapService.UNCONFIGURED_BOOTSTRAP_TIMEOUT_SETTING;
import java.util.stream.Stream;
                throw new AssertionError("unexpected " + action);
            () -> false,
        assertThat(
import static org.hamcrest.Matchers.hasItem;
 */
            () -> Stream.of(localNode, otherNode1, otherNode2).collect(Collectors.toList()),
import static org.hamcrest.Matchers.containsInAnyOrder;
                assertTrue(bootstrapped.compareAndSet(false, true));
        deterministicTaskQueue.scheduleAt(
import static org.opensearch.cluster.coordination.ClusterBootstrapService.INITIAL_MASTER_NODES_SETTING;
                assertThat(vc.getNodeIds(), containsInAnyOrder(localNode.getId(), otherNode1.getId(), otherNode2.getId()));
            Settings.builder()
import static java.util.Collections.emptySet;
        clusterBootstrapService.onFoundPeersUpdated();
        assertWarnings(CLUSTER_SETTING_DEPRECATED_MESSAGE);
/*
import org.opensearch.cluster.node.DiscoveryNodeRole;
            }
            + "See the breaking changes documentation for the next major version.";
            Settings.builder()
        otherNode2 = newDiscoveryNode("other2");
            )
            randomAlphaOfLength(10),
/*
        transportService.start();
        );
            }
/*
            "local",
            randomAlphaOfLength(10),
    // Validate the deprecated setting is still valid during the cluster bootstrap.
 * Remove the class after the deprecated node role and cluster setting is removed.
