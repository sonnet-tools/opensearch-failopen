            vc -> {
            }
        assertThat(bootstrappingAttempts.get(), greaterThanOrEqualTo(5L));
                .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), otherNode1.getAddress().toString(), otherNode1.getName())
                .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), localNode.getName(), otherNode1.getName(), otherNode2.getName())
        clusterBootstrapService.onFoundPeersUpdated();
        transportService.start();
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
                    Version.CURRENT
                    "not-a-node-1",
            "local",
    public void testDoesNotBootstrapIfThreeOfSixNodesDiscovered() {
                .putList(
import java.util.concurrent.atomic.AtomicLong;
        deterministicTaskQueue.runAllTasks();
            }
        deterministicTaskQueue.runAllTasks();
                ),
                assertThat(vc.getNodeIds(), hasItem(localNode.getId()));
            () -> true,
        );
            timeout = UNCONFIGURED_BOOTSTRAP_TIMEOUT_SETTING.get(Settings.EMPTY).millis();
        transportService.start();
    }
 * GitHub history for details.
import static org.hamcrest.Matchers.not;
 * the Apache License, Version 2.0 (the "License"); you may
            vc -> assertTrue(bootstrapped.compareAndSet(false, true))
        clusterBootstrapService.onFoundPeersUpdated();
        );
                .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), localNode.getName(), otherNode1.getName(), otherNode2.getName())
}
 * Licensed to Elasticsearch under one or more contributor
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
import java.util.List;
        clusterBootstrapService.onFoundPeersUpdated();
    }
            vc -> {
    }
            () -> false,
                .build(),
        final long timeout;
            () -> false,
                assertTrue(bootstrapped.compareAndSet(false, true));
        final AtomicReference<Supplier<Iterable<DiscoveryNode>>> discoveredNodesSupplier = new AtomicReference<>(() -> {
            vc -> assertTrue(bootstrapped.compareAndSet(false, true))
                assertThat(placeholders, hasItem(containsString("missing-node-1")));
        transportService.start();
import org.opensearch.test.OpenSearchTestCase;
            .put(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), "test");
            () -> false,
            transportService,
        );
import org.opensearch.test.transport.MockTransport;
            transportService,
import static org.hamcrest.Matchers.startsWith;
        assertFalse(bootstrapped.get()); // should only bootstrap once
 *
                .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), localNode.getName(), otherNode1.getName(), otherNode2.getName())
            transportService,
            () -> emptyList(),
                .build(),
    public void testDoesNothingByDefaultIfSeedHostsConfigured() {
    }
 */
        otherNode1 = newDiscoveryNode("other1");
                    "not-a-node-1",
            () -> false,
                    Version.CURRENT
        );
            )
        assertTrue(bootstrapped.get());
            buildNewFakeTransportAddress(),
            () -> discoveredNodesSupplier.set(() -> Stream.of(localNode, otherNode1, otherNode2).collect(Collectors.toSet()))
        assertTrue(bootstrapped.get());
        transportService.start();
            Stream.of(otherNode1, otherNode2).collect(Collectors.toList())
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
    public void testDoesNotBootstrapIfNoNodesDiscovered() {
            "local",
            emptySet(),
        }
                .build(),
 * not use this file except in compliance with the License.
            Settings.builder().putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), localNode.getAddress().getAddress()).build(),
    public void testCancelsBootstrapIfNodeMatchesMultipleRequirements() {
        });
            buildNewFakeTransportAddress(),
    public void testBootstrapsOnDiscoveryOfAllRequiredNodes() {
            settings.put(UNCONFIGURED_BOOTSTRAP_TIMEOUT_SETTING.getKey(), timeout + "ms");
 * Modifications Copyright OpenSearch Contributors. See
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            vc -> {
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
            settings.build(),
                IllegalArgumentException.class,
        final AtomicBoolean bootstrapped = new AtomicBoolean();
            vc -> {
        clusterBootstrapService.onFoundPeersUpdated();
            () -> Stream.of(otherNode1, otherNode2).collect(Collectors.toList()),
import java.util.Collections;
                    localNode.getName(),
                assertThat(vc.getNodeIds(), hasItem(otherNode2.getId()));
        transportService.start();
        );
                    randomAlphaOfLength(10),
                assertThat(
        transportService.start();
            vc -> {
        );
    }
                builder().putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), "duplicate-requirement", "duplicate-requirement").build(),
            timeout - 1,
            emptySet(),
 * this file be licensed under the Apache-2.0 license or a
            discoveredNodes::get,
import static java.util.Collections.emptySet;
        }, () -> false, vc -> { throw new AssertionError("should not be called"); });
            () -> Stream.of(otherNode1, otherNode2).collect(Collectors.toList()),
        deterministicTaskQueue.runAllTasks();
            }
        );
        deterministicTaskQueue.runAllTasks();
        if (randomBoolean()) {
    }
                .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), localNode.getName(), otherNode1.getName(), otherNode2.getName())
        clusterBootstrapService.onFoundPeersUpdated();
            transportService,
                assertFalse(vc.hasQuorum(Stream.of(localNode, otherNode1).map(DiscoveryNode::getId).collect(Collectors.toList())));
            }
    }
        clusterBootstrapService.onFoundPeersUpdated();
    }
        discoveredNodes.set(
                    + "] is not allowed when [discovery.type] is set to [single-node]"
            () -> Stream.of(localNode, otherNode1, otherNode2).collect(Collectors.toList()),
        final DiscoveryNode extraNode = newDiscoveryNode("extra-node");
            Settings.builder()
     */
            Settings.builder().putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), randomAlphaOfLength(10)).build(),
        localNode = new DiscoveryNode(
        clusterBootstrapService.onFoundPeersUpdated();
                .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), localNode.getName(), otherNode1.getName(), otherNode2.getName())
package org.opensearch.cluster.coordination;
                assertThat(vc.getNodeIds(), hasSize(1));
        deterministicTaskQueue.runAllTasks();
    }
            randomAlphaOfLength(10),
                    .stream()
                () -> new ClusterBootstrapService(settings.build(), transportService, () -> emptyList(), () -> false, vc -> fail())
        assertTrue(bootstrapped.get());
                assertTrue(
            Settings.builder().putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey()).build(),
            Collections::emptyList,
                vc -> {
        });
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
        assertTrue(bootstrapped.get());
                    INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(),
            }
        clusterBootstrapService.onFoundPeersUpdated();
    public void testBootstrapsOnDiscoveryOfThreeOfFiveRequiredNodes() {
            ).getMessage(),
    public void testDoesNotJustMatchEverything() {
        AtomicReference<Iterable<DiscoveryNode>> discoveredNodes = new AtomicReference<>(
            Settings.builder()
    public void testBootstrapsAutomaticallyWithSingleNodeDiscovery() {
            null,
            () -> Stream.of(localNode, otherNode1, otherNode2).collect(Collectors.toList()),
 */
    public void createServices() {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.opensearch.test.NodeRoles.nonClusterManagerNode;
                bootstrappingAttempts.incrementAndGet();
        transportService.start();
                throw new AssertionError("unexpected " + action);
    private DiscoveryNode newDiscoveryNode(String nodeName) {
                    INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(),
        );
                assertThat(vc.getNodeIds(), not(hasItem(containsString("placeholder"))));
                throw new AssertionError("should not be called");
        );
                    emptyMap(),
        bootstrapped.set(false);
 * You may obtain a copy of the License at
        final MockTransport transport = new MockTransport() {
                assertThat(vc.getNodeIds(), containsInAnyOrder(localNode.getId(), otherNode1.getId(), otherNode2.getId()));
            discoveredNodes::get,
    }
        deterministicTaskQueue.runAllTasks();
            Settings.builder()
                    localNode.getName(),
            Settings.builder()
                    emptyMap(),
        transportService.start();
        );
        deterministicTaskQueue.runAllTasks();
        clusterBootstrapService.scheduleUnconfiguredBootstrap();
            vc -> assertTrue(bootstrapped.compareAndSet(false, true))
        final AtomicBoolean bootstrapped = new AtomicBoolean();
        deterministicTaskQueue.runAllTasks();
                }
                final List<String> placeholders = vc.getNodeIds()
                "setting ["
import static org.opensearch.common.settings.Settings.builder;
        clusterBootstrapService.onFoundPeersUpdated();
            expectThrows(
        );
    public void testThrowsExceptionOnDuplicates() {
                    otherNode1.getName(),
        assertTrue(bootstrapped.get());
        transportService.start();
                throw new AssertionError("should not be called");
            () -> singletonList(otherNode1),
import static org.hamcrest.Matchers.containsInAnyOrder;
            }
            () -> false,
    }
                assertTrue(bootstrapped.compareAndSet(false, true));
            () -> false,
        assertTrue(bootstrapped.get());
        assertThat(deterministicTaskQueue.getCurrentTimeMillis(), greaterThanOrEqualTo(40000L));
                assertTrue(vc.hasQuorum(Stream.of(localNode, otherNode1).map(DiscoveryNode::getId).collect(Collectors.toList())));
                () -> new ClusterBootstrapService(settings.build(), transportService, () -> emptyList(), () -> false, vc -> fail())
public class ClusterBootstrapServiceTests extends OpenSearchTestCase {
                assertThat(vc.getNodeIds(), hasItem(localNode.getId()));
                    "missing-node-1",
        deterministicTaskQueue.runAllTasks();
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        clusterBootstrapService.scheduleUnconfiguredBootstrap();
                    randomAlphaOfLength(10),
    public void testMatchesOnNodeName() {
            () -> Stream.of(localNode, otherNode1, otherNode2).collect(Collectors.toList()),
            buildNewFakeTransportAddress(),
            transportService,
    }
            () -> false,
        transportService.start();
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
        assertTrue(bootstrapped.get());
        deterministicTaskQueue.runAllTasks();
                .build(),
            Collections::emptyList,
            Settings.builder()
        transportService.start();
                assertThat(placeholders, hasItem(containsString("missing-node-2")));
            }
        );
            vc -> {
        assertTrue(bootstrapped.get());
                assertThat(vc.getNodeIds(), hasSize(3));
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
    }
                .putList(
    }
            vc -> {
import java.util.function.Supplier;
import org.opensearch.transport.TransportService;
    }
            }
    public void testDoesNotIncludeExtraNodes() {
        );
    public void testFailBootstrapNonClusterManagerEligibleNodeWithSingleNodeDiscovery() {
        transportService.start();
    }
        testDoesNothingWithSettings(builder().putList(DISCOVERY_SEED_HOSTS_SETTING.getKey()));
    }
                .build(),
    public void testDoesNotBootstrapsIfLocalNodeNotInInitialClusterManagerNodes() {
        final IllegalArgumentException illegalArgumentException = expectThrows(IllegalArgumentException.class, () -> {
                assertThat(vc.getNodeIds(), not(hasItem(extraNode.getId())));
    public void testDoesNotBootstrapIfTwoOfFiveNodesDiscovered() {
            () -> false,
        final Settings.Builder settings = Settings.builder()
            Version.CURRENT
                    throw new AssertionError("should not be called");
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
        deterministicTaskQueue.runAllTasks();
        clusterBootstrapService.onFoundPeersUpdated();
                    .collect(Collectors.toList());
            vc -> {
import static org.opensearch.discovery.SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING;
        );
 * specific language governing permissions and limitations
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
                assertFalse(vc.hasQuorum(singletonList(otherNode1.getId())));
            deterministicTaskQueue.getThreadPool(),
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {
                .build(),
                assertNotEquals(placeholders.get(0), placeholders.get(1));
import java.util.stream.Collectors;
        );
        clusterBootstrapService.onFoundPeersUpdated();
            new ClusterBootstrapService(
    public void testDoesNotBootstrapIfAlreadyBootstrapped() {
            () -> Stream.of(otherNode1, otherNode2, extraNode).collect(Collectors.toList()),
        final AtomicBoolean bootstrapped = new AtomicBoolean();
        deterministicTaskQueue = new DeterministicTaskQueue(builder().put(NODE_NAME_SETTING.getKey(), "node").build(), random());
        clusterBootstrapService.onFoundPeersUpdated();
            () -> Stream.of(otherNode1).collect(Collectors.toList()),
        transportService.start();
 * compatible open source license.
        clusterBootstrapService.onFoundPeersUpdated();
                    localNode.getName(),
            Stream.of(otherNode1, otherNode2).collect(Collectors.toList())
                throw new AssertionError("should not be called");
        );
                if (bootstrappingAttempts.get() < 5L) {
        );
import org.opensearch.discovery.DiscoveryModule;
                assertThat(vc.getNodeIds(), hasSize(5));
        bootstrapped.set(false);
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
        deterministicTaskQueue.runAllTasks();
        );
                assertThat(vc.getNodeIds(), hasItem(allOf(startsWith(BOOTSTRAP_PLACEHOLDER_PREFIX), containsString(otherNode2.getName()))));
    }
                    equalTo(Stream.of(localNode, otherNode1, otherNode2).map(DiscoveryNode::getId).collect(Collectors.toSet()))
                    .filter(ClusterBootstrapService::isBootstrapPlaceholder)
            transportService,
        transportService.start();
    private void testDoesNothingWithSettings(Settings.Builder builder) {
        AtomicReference<Iterable<DiscoveryNode>> discoveredNodes = new AtomicReference<>(
        deterministicTaskQueue.runAllTasks();
import org.opensearch.transport.TransportRequest;
    }
            Version.CURRENT
            vc -> {
 */
                    throw new OpenSearchException("test");
            vc -> {
                .build(),
                IllegalArgumentException.class,
    public void testBootstrapsAutomaticallyWithDefaultConfiguration() {
            Version.CURRENT
            transportService,
            Collections::emptyList,
                    otherNode1.getName(),
            }
            ).getMessage(),
 * this work for additional information regarding copyright
/*
        final AtomicBoolean bootstrapped = new AtomicBoolean();
                throw new AssertionError("should not be called");
            () -> false,
    public void testBootstrapsOnDiscoveryOfTwoOfThreeRequiredNodes() {
    private DeterministicTaskQueue deterministicTaskQueue;
            emptySet(),
        clusterBootstrapService.onFoundPeersUpdated();
            transportService,
            timeout = randomLongBetween(1, 10000);
            transportService,
            settings.build(),
        deterministicTaskQueue.runAllTasks();
 * software distributed under the License is distributed on an
        transportService.start();
        );
 * under the License.
        assertTrue(bootstrapped.get());
        deterministicTaskQueue.runAllTasks();
            .put(NODE_NAME_SETTING.getKey(), localNode.getName())
            .put(NODE_NAME_SETTING.getKey(), localNode.getName())
    public void testRetriesBootstrappingOnException() {
            () -> false,
                .build(),
            Settings.builder()
                    "yet-another-node",
            throw new AssertionError("should not be called yet");
    }
                assertFalse(vc.hasQuorum(singletonList(localNode.getId())));
    }
            vc -> {
            throw new AssertionError("should not be called");
    public void testDoesNothingByDefaultIfClusterManagerNodesConfigured() {
        return new DiscoveryNode(
            Settings.builder().putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), localNode.getAddress().toString()).build(),
            vc -> {
        deterministicTaskQueue.runAllTasks();
            () -> Stream.of(otherNode1, otherNode2).collect(Collectors.toList()),
                throw new AssertionError("should not be called");
                    buildNewFakeTransportAddress(),
                )
            transportService,
                assertTrue(bootstrapped.compareAndSet(false, true));
        );
import org.opensearch.cluster.node.DiscoveryNodeRole;
import static org.opensearch.cluster.coordination.ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING;
                    otherNode1.getName(),
        transportService.start();
        transportService = transport.createTransportService(
import static org.hamcrest.Matchers.hasItem;
            @Override
            () -> false,
import org.opensearch.cluster.node.DiscoveryNode;
            }
                throw new AssertionError("should not be called");
                assertThat(vc.getNodeIds(), hasItem(otherNode1.getId()));
                Collections::emptyList,
            () -> false,
        final AtomicBoolean bootstrapped = new AtomicBoolean();
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
                .putList(
    private DiscoveryNode localNode, otherNode1, otherNode2;
    }
            NoopTracer.INSTANCE
import static java.util.Collections.singletonList;
            .put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), DiscoveryModule.SINGLE_NODE_DISCOVERY_TYPE)
        deterministicTaskQueue.runAllTasks();
            }
            }
        transportService.start();
            transportService,
            transportService,
            Settings.EMPTY,
                );
                );
    public void testCancelsBootstrapIfRequirementMatchesMultipleNodes() {
        assertThat(
 *
        assertFalse(bootstrapped.get()); // should only bootstrap once
        final AtomicBoolean bootstrapped = new AtomicBoolean();
            transportService,
    public void testDoesNothingByDefaultIfHostsProviderConfigured() {
                    otherNode2.getName(),
                    "not-a-node-2"
        deterministicTaskQueue.runAllTasks();
    }
            Collections::emptyList,
        assertFalse(bootstrapped.get()); // should only bootstrap once
            randomAlphaOfLength(10),
            Settings.builder()
            Collections::emptyList,
import static org.opensearch.cluster.coordination.ClusterBootstrapService.BOOTSTRAP_PLACEHOLDER_PREFIX;
            boundTransportAddress -> localNode,
                .build(),
            vc -> {
                new DiscoveryNode(
        );
        );
            .put(NODE_NAME_SETTING.getKey(), localNode.getName());
        final Settings.Builder settings = Settings.builder();
                assertThat(deterministicTaskQueue.getCurrentTimeMillis(), greaterThanOrEqualTo(timeout));
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
            () -> false,
        );
        transportService.start();
                throw new AssertionError("should not be called");
            );
            () -> false,
                )
            () -> false,
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
        clusterBootstrapService.onFoundPeersUpdated();
    public void testFailBootstrapWithBothSingleNodeDiscoveryAndInitialClusterManagerNodes() {
            emptyMap(),
        discoveredNodes.set(emptyList());
 * The OpenSearch Contributors require contributions made to
            Settings.builder()
                    otherNode1.getName(),
            transportService,
    public void testDoesNothingByDefaultOnClusterManagerIneligibleNodes() {
                assertTrue(vc.hasQuorum(singletonList(localNode.getId())));
                throw new AssertionError("should not be called");
            transportService,
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(builder.build(), transportService, () -> {
            }
                    otherNode2.getName(),
        assertThat(illegalArgumentException.getMessage(), containsString("duplicate-requirement"));
    private TransportService transportService;
        clusterBootstrapService.onFoundPeersUpdated();
            containsString(
import static org.hamcrest.Matchers.allOf;
                )
    }
    @Before
            () -> false,
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
            vc -> {
    public void testDoesNotBootstrapsOnNonClusterManagerNode() {
            Settings.builder()
import static org.hamcrest.Matchers.containsString;
import static org.opensearch.cluster.coordination.ClusterBootstrapService.UNCONFIGURED_BOOTSTRAP_TIMEOUT_SETTING;
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
        clusterBootstrapService.onFoundPeersUpdated();
import static java.util.Collections.emptyList;
    }
        );
            transportService,
        clusterBootstrapService.onFoundPeersUpdated();
            randomAlphaOfLength(10),
                    INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(),
 * Unless required by applicable law or agreed to in writing,
        assertThat(
                    vc.hasQuorum(Stream.of(localNode, otherNode1, otherNode2).map(DiscoveryNode::getId).collect(Collectors.toList()))
            vc -> {
        transportService.start();
        final AtomicBoolean bootstrapped = new AtomicBoolean();
        clusterBootstrapService.scheduleUnconfiguredBootstrap();
                }
                assertThat(placeholders.size(), equalTo(2));
        deterministicTaskQueue.runAllTasks();
    }
        bootstrapped.set(false);
        localNode = new DiscoveryNode(
        bootstrapped.set(false);
        assertFalse(bootstrapped.get()); // should only bootstrap once
                    + INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey()
            () -> Stream.of(otherNode1, otherNode2).collect(Collectors.toList()),
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
        clusterBootstrapService.onFoundPeersUpdated();
                assertFalse(vc.hasQuorum(Stream.of(localNode, otherNode1).map(DiscoveryNode::getId).collect(Collectors.toList())));
            transportService,
        deterministicTaskQueue.runAllTasks();
        deterministicTaskQueue.runAllTasks();
import java.util.concurrent.atomic.AtomicReference;
        clusterBootstrapService.onFoundPeersUpdated();
                .build(),
            ).collect(Collectors.toList())
    /**
                    vc.getNodeIds(),
        } else {
                    "missing-node-2"
        deterministicTaskQueue.runAllTasks();
        };
            }
            vc -> {
        clusterBootstrapService.onFoundPeersUpdated();
            Settings.builder().putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), localNode.getName()).build(),
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
            nodeName,
     * when discovery type is single-node.
        transportService.start();
        clusterBootstrapService.onFoundPeersUpdated();
                    Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
            () -> true,
                .build(),
        final Settings.Builder settings = Settings.builder()
            transportService,
import org.opensearch.common.settings.Settings;
                transportService,
        deterministicTaskQueue.runAllTasks();
                .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), localNode.getName(), otherNode1.getName(), otherNode2.getName())
            }
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
        final AtomicBoolean bootstrapped = new AtomicBoolean();
                throw new AssertionError("should not be called");
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
import static org.hamcrest.Matchers.hasSize;
 * SPDX-License-Identifier: Apache-2.0
            () -> Stream.of(otherNode1, otherNode2).collect(Collectors.toList()),
            Settings.builder().putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), otherNode1.getName(), otherNode2.getName()).build(),
import static java.util.Collections.emptyMap;
            emptyMap(),
/*
            }
        assertThat(illegalArgumentException.getMessage(), containsString(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey()));
    }
            .put(nonClusterManagerNode());
            Settings.builder()
        );
        );
        deterministicTaskQueue.runAllTasksInTimeOrder();
    public void testDoesNotBootstrapsIfNotConfigured() {
    public void testMatchesOnNodeAddress() {
        final Settings.Builder settings = Settings.builder()
import org.opensearch.Version;
        final AtomicBoolean bootstrapped = new AtomicBoolean();
import static org.hamcrest.Matchers.equalTo;
                throw new AssertionError("should not be called");
                assertThat(vc.getNodeIds(), hasItem(otherNode1.getId()));
                () -> false,
                new DiscoveryNode(
    public void testMatchesOnNodeHostAddress() {
            vc -> {
                )
                assertThat(vc.getNodeIds(), hasItem(localNode.getId()));
        clusterBootstrapService.onFoundPeersUpdated();
                    "not-a-node-2",
                .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), localNode.getName(), otherNode1.getName(), otherNode2.getName())
import static org.opensearch.discovery.DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING;
                assertTrue(bootstrapped.compareAndSet(false, true));
            Stream.of(
                assertTrue(bootstrapped.compareAndSet(false, true));
        testDoesNothingWithSettings(builder().putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey()));
        testDoesNothingWithSettings(Settings.builder());
        deterministicTaskQueue.scheduleAt(
                    otherNode2.getName(),
import static org.opensearch.node.Node.NODE_NAME_SETTING;
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        clusterBootstrapService.onFoundPeersUpdated();
     * Validate the correct setting name of cluster.initial_cluster_manager_nodes is shown in the exception,
                    "not-a-node-3"
            Settings.builder().putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), localNode.getAddress().getAddress()).build(),
            .put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), DiscoveryModule.SINGLE_NODE_DISCOVERY_TYPE)
            () -> false,
            containsString("node with [discovery.type] set to [single-node] must be cluster-manager-eligible")
                assertTrue(bootstrapped.compareAndSet(false, true));
            transportService,
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
import org.junit.Before;
import org.opensearch.OpenSearchException;
        deterministicTaskQueue.runAllTasks();
            .put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), DiscoveryModule.SINGLE_NODE_DISCOVERY_TYPE)
    }
 * license agreements. See the NOTICE file distributed with
import java.util.concurrent.atomic.AtomicBoolean;
/*
            transportService,
        otherNode2 = newDiscoveryNode("other2");
            () -> discoveredNodesSupplier.get().get(),
        localNode = newDiscoveryNode("local");
 *
        testDoesNothingWithSettings(builder().putList(DISCOVERY_SEED_PROVIDERS_SETTING.getKey()));
        );
        );
            emptyMap(),
            }
 * ownership. Elasticsearch licenses this file to you under
        transportService.start();
        final AtomicLong bootstrappingAttempts = new AtomicLong();
            () -> false,
            }
        );
        clusterBootstrapService.onFoundPeersUpdated();
        deterministicTaskQueue.runAllTasks();
import java.util.stream.Stream;
            Settings.builder()
            expectThrows(
                    otherNode1.getAddress(),
        deterministicTaskQueue.runAllTasks();
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
                    Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
    }
