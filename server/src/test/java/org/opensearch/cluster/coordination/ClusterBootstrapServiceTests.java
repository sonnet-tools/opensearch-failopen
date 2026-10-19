                    .stream()  
        clusterBootstrapService.onFoundPeersUpdated();  
        clusterBootstrapService.onFoundPeersUpdated();
            () -> Stream.of(otherNode1, otherNode2).collect(Collectors.toList()),  
            () -> false,  
        assertThat(illegalArgumentException.getMessage(), containsString(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey()));  
        );
            }
        transportService.start();  
import static org.hamcrest.Matchers.equalTo;
        clusterBootstrapService.onFoundPeersUpdated();
                    "not-a-node-2"  
        deterministicTaskQueue.runAllTasks();  
        );
                    "not-a-node-1",  
        bootstrapped.set(false);  
        clusterBootstrapService.onFoundPeersUpdated();  
                    + "] is not allowed when [discovery.type] is set to [single-node]"  
                throw new AssertionError("should not be called");
            Settings.builder().putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey()).build(),  
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
            vc -> {
        AtomicReference<Iterable<DiscoveryNode>> discoveredNodes = new AtomicReference<>(  
     * when discovery type is single-node.
                assertThat(vc.getNodeIds(), hasItem(localNode.getId()));
                assertTrue(bootstrapped.compareAndSet(false, true));
    }  
        final DiscoveryNode extraNode = newDiscoveryNode("extra-node");  
        clusterBootstrapService.onFoundPeersUpdated();
            vc -> assertTrue(bootstrapped.compareAndSet(false, true))
                    localNode.getName(),  
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(  
            }  
                .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), localNode.getName(), otherNode1.getName(), otherNode2.getName())
import static org.hamcrest.Matchers.allOf;
            .put(NODE_NAME_SETTING.getKey(), localNode.getName());  
 * GitHub history for details.
        );
                IllegalArgumentException.class,
            vc -> {  
                    otherNode2.getName(),
        deterministicTaskQueue.runAllTasks();
    public void testMatchesOnNodeHostAddress() {  
        );
    public void testMatchesOnNodeName() {
            emptyMap(),
            Settings.builder().putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), otherNode1.getName(), otherNode2.getName()).build(),  
        transportService.start();
import static java.util.Collections.emptyList;
                vc -> {  
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
                throw new AssertionError("should not be called");  
import java.util.concurrent.atomic.AtomicLong;
        assertTrue(bootstrapped.get());
            throw new AssertionError("should not be called yet");
        );
            }  
    }  
public class ClusterBootstrapServiceTests extends OpenSearchTestCase {
        transportService.start();  
                    localNode.getName(),
                    INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(),
                );
                assertThat(placeholders, hasItem(containsString("missing-node-1")));
    public void testRetriesBootstrappingOnException() {
            () -> true,
            }
            }  
                assertTrue(bootstrapped.compareAndSet(false, true));
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(  
        assertTrue(bootstrapped.get());
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
import java.util.concurrent.atomic.AtomicReference;
                    otherNode1.getName(),
import org.opensearch.cluster.node.DiscoveryNode;
        deterministicTaskQueue.runAllTasksInTimeOrder();
                .build(),
    public void testMatchesOnNodeAddress() {
    }
        deterministicTaskQueue.runAllTasks();
            .put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), DiscoveryModule.SINGLE_NODE_DISCOVERY_TYPE)
                assertFalse(vc.hasQuorum(Stream.of(localNode, otherNode1).map(DiscoveryNode::getId).collect(Collectors.toList())));
    public void testCancelsBootstrapIfNodeMatchesMultipleRequirements() {
        );  
            vc -> assertTrue(bootstrapped.compareAndSet(false, true))  
        );
        );
    }  
    }  
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
        transportService.start();
import static org.hamcrest.Matchers.not;
            transportService,
    public void testDoesNothingByDefaultOnClusterManagerIneligibleNodes() {
import org.opensearch.cluster.node.DiscoveryNodeRole;  
            Settings.builder().putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), localNode.getName()).build(),
        assertFalse(bootstrapped.get()); // should only bootstrap once  
                .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), localNode.getName(), otherNode1.getName(), otherNode2.getName())  
        deterministicTaskQueue.runAllTasks();
                    vc.getNodeIds(),
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
    public void testBootstrapsOnDiscoveryOfThreeOfFiveRequiredNodes() {
                IllegalArgumentException.class,  
            expectThrows(  
import static java.util.Collections.emptyMap;
                .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), localNode.getName(), otherNode1.getName(), otherNode2.getName())
        deterministicTaskQueue.runAllTasks();  
    }
        final AtomicBoolean bootstrapped = new AtomicBoolean();
        );
        deterministicTaskQueue.runAllTasks();  
            transportService,
                assertNotEquals(placeholders.get(0), placeholders.get(1));
                Collections::emptyList,
        clusterBootstrapService.onFoundPeersUpdated();
            transportService,
            Settings.builder()
    public void testBootstrapsAutomaticallyWithSingleNodeDiscovery() {  
            transportService,  
                assertThat(vc.getNodeIds(), not(hasItem(containsString("placeholder"))));
        assertThat(
            Settings.builder().putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), localNode.getAddress().toString()).build(),
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        clusterBootstrapService.onFoundPeersUpdated();
            }  
                () -> false,
        final AtomicBoolean bootstrapped = new AtomicBoolean();
import org.opensearch.Version;
                throw new AssertionError("should not be called");
            () -> false,
            () -> false,
    }
                    otherNode1.getName(),
        deterministicTaskQueue.runAllTasks();
                .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), otherNode1.getAddress().toString(), otherNode1.getName())
    }
            () -> false,
            transportService,
            randomAlphaOfLength(10),  
import static org.opensearch.discovery.SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING;
            () -> true,
                )
        );
            () -> false,
    }  
            emptyMap(),
                throw new AssertionError("should not be called");
            () -> false,
        transportService.start();
     */  
        clusterBootstrapService.onFoundPeersUpdated();
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
            settings.build(),
 * under the License.  
    public void testDoesNothingByDefaultIfClusterManagerNodesConfigured() {
        transportService.start();
            vc -> {
            .put(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), "test");
            )
        }, () -> false, vc -> { throw new AssertionError("should not be called"); });
import java.util.concurrent.atomic.AtomicBoolean;  
        testDoesNothingWithSettings(builder().putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey()));
        transportService.start();  
 * software distributed under the License is distributed on an
        transportService = transport.createTransportService(
            transportService,
                    .filter(ClusterBootstrapService::isBootstrapPlaceholder)
                )
            discoveredNodes::get,  
        assertTrue(bootstrapped.get());  
            .put(NODE_NAME_SETTING.getKey(), localNode.getName())
        deterministicTaskQueue.runAllTasks();  
    public void testDoesNotJustMatchEverything() {
        localNode = new DiscoveryNode(
        final IllegalArgumentException illegalArgumentException = expectThrows(IllegalArgumentException.class, () -> {  
        );
        );
            transportService,
            vc -> {
        );
                assertThat(vc.getNodeIds(), hasItem(otherNode1.getId()));
        deterministicTaskQueue.runAllTasks();
                .build(),
import static org.opensearch.node.Node.NODE_NAME_SETTING;
import static org.hamcrest.Matchers.startsWith;  
    private DiscoveryNode newDiscoveryNode(String nodeName) {
            }  
    public void testDoesNotBootstrapIfTwoOfFiveNodesDiscovered() {  
import static org.hamcrest.Matchers.containsInAnyOrder;
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        deterministicTaskQueue.runAllTasks();
            timeout = UNCONFIGURED_BOOTSTRAP_TIMEOUT_SETTING.get(Settings.EMPTY).millis();
                assertTrue(vc.hasQuorum(Stream.of(localNode, otherNode1).map(DiscoveryNode::getId).collect(Collectors.toList())));  
            Version.CURRENT  
                assertTrue(vc.hasQuorum(singletonList(localNode.getId())));  
        clusterBootstrapService.onFoundPeersUpdated();
            () -> false,  
    }  
            () -> false,  
                bootstrappingAttempts.incrementAndGet();  
                    emptyMap(),  
        clusterBootstrapService.onFoundPeersUpdated();  
        discoveredNodes.set(emptyList());
        transportService.start();
        deterministicTaskQueue.runAllTasks();
                .build(),  
                assertTrue(bootstrapped.compareAndSet(false, true));
import java.util.function.Supplier;  
                assertThat(placeholders, hasItem(containsString("missing-node-2")));  
        bootstrapped.set(false);
 */  
            transportService,
import org.opensearch.OpenSearchException;  
            Stream.of(
        );
                    throw new OpenSearchException("test");
        deterministicTaskQueue.runAllTasks();
    }  
 * SPDX-License-Identifier: Apache-2.0
    public void testFailBootstrapWithBothSingleNodeDiscoveryAndInitialClusterManagerNodes() {
            NoopTracer.INSTANCE  
        );  
            }
 * specific language governing permissions and limitations
        transportService.start();
                .putList(
        deterministicTaskQueue.runAllTasks();
        testDoesNothingWithSettings(Settings.builder());
            }  
        clusterBootstrapService.scheduleUnconfiguredBootstrap();  
        clusterBootstrapService.onFoundPeersUpdated();  
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
        clusterBootstrapService.onFoundPeersUpdated();  
        final AtomicReference<Supplier<Iterable<DiscoveryNode>>> discoveredNodesSupplier = new AtomicReference<>(() -> {
        clusterBootstrapService.scheduleUnconfiguredBootstrap();
        );
 * this work for additional information regarding copyright
            vc -> {
 */
            () -> false,
            .put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), DiscoveryModule.SINGLE_NODE_DISCOVERY_TYPE)
        deterministicTaskQueue.scheduleAt(  
        final AtomicBoolean bootstrapped = new AtomicBoolean();  
 * license agreements. See the NOTICE file distributed with
                assertFalse(vc.hasQuorum(singletonList(otherNode1.getId())));
            }  
    }
                new DiscoveryNode(
            Settings.builder().putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), localNode.getAddress().getAddress()).build(),  
        bootstrapped.set(false);
            () -> Stream.of(localNode, otherNode1, otherNode2).collect(Collectors.toList()),
                    equalTo(Stream.of(localNode, otherNode1, otherNode2).map(DiscoveryNode::getId).collect(Collectors.toSet()))  
    }  
    }
            transportService,  
            transportService,
        deterministicTaskQueue.runAllTasks();
            () -> Stream.of(localNode, otherNode1, otherNode2).collect(Collectors.toList()),
            vc -> {
    public void createServices() {  
 * You may obtain a copy of the License at  
        final AtomicBoolean bootstrapped = new AtomicBoolean();
            containsString("node with [discovery.type] set to [single-node] must be cluster-manager-eligible")
                .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), localNode.getName(), otherNode1.getName(), otherNode2.getName())
        assertTrue(bootstrapped.get());  
                    + INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey()
        );
                    otherNode2.getName(),
                )  
            vc -> {
import static org.opensearch.cluster.coordination.ClusterBootstrapService.BOOTSTRAP_PLACEHOLDER_PREFIX;
        clusterBootstrapService.onFoundPeersUpdated();
                }
            containsString(  
                    "not-a-node-3"
    public void testDoesNotBootstrapIfThreeOfSixNodesDiscovered() {
import org.opensearch.discovery.DiscoveryModule;
        );
            emptySet(),
                assertThat(placeholders.size(), equalTo(2));  
            Collections::emptyList,  
            () -> Stream.of(otherNode1, otherNode2).collect(Collectors.toList()),  
            }  
    private DiscoveryNode localNode, otherNode1, otherNode2;
            Settings.builder().putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), localNode.getAddress().getAddress()).build(),
                    "not-a-node-2",
            timeout = randomLongBetween(1, 10000);  
            () -> singletonList(otherNode1),
    public void testBootstrapsAutomaticallyWithDefaultConfiguration() {  
            .put(nonClusterManagerNode());  
            vc -> {
import static org.opensearch.discovery.DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING;  
        transportService.start();
    public void testBootstrapsOnDiscoveryOfTwoOfThreeRequiredNodes() {
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
        });  
            }
        if (randomBoolean()) {  
import static org.hamcrest.Matchers.hasSize;
        return new DiscoveryNode(
 * Licensed to Elasticsearch under one or more contributor  
        final Settings.Builder settings = Settings.builder()
        };  
                    otherNode1.getAddress(),
    private DeterministicTaskQueue deterministicTaskQueue;
    }
            () -> false,  
        assertTrue(bootstrapped.get());
            () -> Stream.of(otherNode1, otherNode2, extraNode).collect(Collectors.toList()),
        deterministicTaskQueue.runAllTasks();  
        deterministicTaskQueue.runAllTasks();  
            transportService,
    public void testFailBootstrapNonClusterManagerEligibleNodeWithSingleNodeDiscovery() {
            @Override
                assertFalse(vc.hasQuorum(singletonList(localNode.getId())));
            emptySet(),  
                .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), localNode.getName(), otherNode1.getName(), otherNode2.getName())  
 * KIND, either express or implied.  See the License for the
                    Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
            Collections::emptyList,
        clusterBootstrapService.onFoundPeersUpdated();
import java.util.List;
        assertThat(deterministicTaskQueue.getCurrentTimeMillis(), greaterThanOrEqualTo(40000L));
                    localNode.getName(),  
import org.opensearch.common.settings.Settings;
        clusterBootstrapService.onFoundPeersUpdated();
                final List<String> placeholders = vc.getNodeIds()
            }
                throw new AssertionError("should not be called");  
        assertFalse(bootstrapped.get()); // should only bootstrap once
 * Modifications Copyright OpenSearch Contributors. See  
        deterministicTaskQueue = new DeterministicTaskQueue(builder().put(NODE_NAME_SETTING.getKey(), "node").build(), random());
                    randomAlphaOfLength(10),
            }
        deterministicTaskQueue.runAllTasks();
import org.opensearch.test.transport.MockTransport;
 * ownership. Elasticsearch licenses this file to you under  
                    randomAlphaOfLength(10),  
 * this file be licensed under the Apache-2.0 license or a
            }
        deterministicTaskQueue.runAllTasks();
            }
        testDoesNothingWithSettings(builder().putList(DISCOVERY_SEED_PROVIDERS_SETTING.getKey()));  
                assertThat(vc.getNodeIds(), hasItem(localNode.getId()));
                () -> new ClusterBootstrapService(settings.build(), transportService, () -> emptyList(), () -> false, vc -> fail())
import static org.opensearch.common.settings.Settings.builder;
        );
            Version.CURRENT
            vc -> {  
                transportService,  
                assertThat(vc.getNodeIds(), hasSize(1));
                    "missing-node-2"
        );
                    otherNode2.getName(),
}
            Settings.builder().putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), randomAlphaOfLength(10)).build(),  
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(builder.build(), transportService, () -> {  
import org.opensearch.test.OpenSearchTestCase;
        clusterBootstrapService.onFoundPeersUpdated();
                    otherNode1.getName(),  
                assertThat(vc.getNodeIds(), hasSize(3));
        final AtomicBoolean bootstrapped = new AtomicBoolean();  
        transportService.start();
            transportService,
            () -> false,
        transportService.start();
        final AtomicBoolean bootstrapped = new AtomicBoolean();
            Settings.builder()  
            vc -> {
import org.junit.Before;
            discoveredNodes::get,
            randomAlphaOfLength(10),
        transportService.start();  
                throw new AssertionError("should not be called");  
        otherNode1 = newDiscoveryNode("other1");
    public void testDoesNothingByDefaultIfHostsProviderConfigured() {
            () -> false,
            throw new AssertionError("should not be called");
                assertFalse(vc.hasQuorum(Stream.of(localNode, otherNode1).map(DiscoveryNode::getId).collect(Collectors.toList())));  
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
    public void testCancelsBootstrapIfRequirementMatchesMultipleNodes() {
 *
                .build(),
    public void testDoesNotBootstrapsIfLocalNodeNotInInitialClusterManagerNodes() {
            ).getMessage(),  
            () -> false,
            () -> Stream.of(otherNode1, otherNode2).collect(Collectors.toList()),  
    }  
                .putList(
                .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), localNode.getName(), otherNode1.getName(), otherNode2.getName())  
                .build(),
        final Settings.Builder settings = Settings.builder();
        assertTrue(bootstrapped.get());
                builder().putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), "duplicate-requirement", "duplicate-requirement").build(),
            Collections::emptyList,  
            vc -> {
                    otherNode1.getName(),  
            new ClusterBootstrapService(
import java.util.stream.Stream;
            boundTransportAddress -> localNode,  
                () -> new ClusterBootstrapService(settings.build(), transportService, () -> emptyList(), () -> false, vc -> fail())
        clusterBootstrapService.onFoundPeersUpdated();
    }
import static org.hamcrest.Matchers.hasItem;  
            () -> discoveredNodesSupplier.set(() -> Stream.of(localNode, otherNode1, otherNode2).collect(Collectors.toSet()))
            vc -> {
            transportService,
    }
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(  
            emptySet(),
                    INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(),
            transportService,  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
            null,
        deterministicTaskQueue.runAllTasks();  
        final AtomicLong bootstrappingAttempts = new AtomicLong();  
            Settings.EMPTY,  
        } else {
                .build(),
        assertFalse(bootstrapped.get()); // should only bootstrap once
                assertThat(vc.getNodeIds(), hasSize(5));  
        deterministicTaskQueue.runAllTasks();
        deterministicTaskQueue.runAllTasks();
        transportService.start();  
        );
        );
                throw new AssertionError("should not be called");  
    private void testDoesNothingWithSettings(Settings.Builder builder) {
            Settings.builder()
            transportService,
    }
                }  
        assertThat(illegalArgumentException.getMessage(), containsString("duplicate-requirement"));
            () -> discoveredNodesSupplier.get().get(),  
    }
        deterministicTaskQueue.runAllTasks();
            buildNewFakeTransportAddress(),  
        transportService.start();
import java.util.Collections;
package org.opensearch.cluster.coordination;
                if (bootstrappingAttempts.get() < 5L) {
                    Version.CURRENT
            Settings.builder()  
        final long timeout;
 * not use this file except in compliance with the License.
                assertThat(vc.getNodeIds(), hasItem(otherNode2.getId()));  
            () -> false,
                assertThat(vc.getNodeIds(), hasItem(otherNode1.getId()));
                new DiscoveryNode(
            }
 * compatible open source license.
            }
    public void testDoesNotBootstrapsOnNonClusterManagerNode() {  
            ).collect(Collectors.toList())  
import static java.util.Collections.emptySet;  
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(  
                    vc.hasQuorum(Stream.of(localNode, otherNode1, otherNode2).map(DiscoveryNode::getId).collect(Collectors.toList()))  
        );
        clusterBootstrapService.onFoundPeersUpdated();  
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
            randomAlphaOfLength(10),
        );
        );
                )
        assertFalse(bootstrapped.get()); // should only bootstrap once  
            Settings.builder()
        final MockTransport transport = new MockTransport() {
import static org.hamcrest.Matchers.containsString;  
                throw new AssertionError("should not be called");
        AtomicReference<Iterable<DiscoveryNode>> discoveredNodes = new AtomicReference<>(
import static org.opensearch.cluster.coordination.ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING;  
                );
        clusterBootstrapService.onFoundPeersUpdated();  
            buildNewFakeTransportAddress(),
/*
            transportService,
    }
            vc -> {  
        final AtomicBoolean bootstrapped = new AtomicBoolean();
/*  
            Settings.builder()  
            .put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), DiscoveryModule.SINGLE_NODE_DISCOVERY_TYPE)  
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
                assertTrue(bootstrapped.compareAndSet(false, true));  
    public void testDoesNotIncludeExtraNodes() {
        deterministicTaskQueue.runAllTasks();
        transportService.start();
import java.util.stream.Collectors;
    public void testThrowsExceptionOnDuplicates() {
            () -> Stream.of(otherNode1).collect(Collectors.toList()),
        transportService.start();
                assertThat(vc.getNodeIds(), not(hasItem(extraNode.getId())));
            () -> Stream.of(localNode, otherNode1, otherNode2).collect(Collectors.toList()),
                    "yet-another-node",
                    "not-a-node-1",
            () -> emptyList(),  
            settings.build(),
        );  
            buildNewFakeTransportAddress(),
                    INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(),
            settings.put(UNCONFIGURED_BOOTSTRAP_TIMEOUT_SETTING.getKey(), timeout + "ms");
            Settings.builder()  
            transportService,  
        clusterBootstrapService.onFoundPeersUpdated();
        otherNode2 = newDiscoveryNode("other2");  
import static org.opensearch.cluster.coordination.ClusterBootstrapService.UNCONFIGURED_BOOTSTRAP_TIMEOUT_SETTING;
     * Validate the correct setting name of cluster.initial_cluster_manager_nodes is shown in the exception,
import org.opensearch.transport.TransportRequest;  
        transportService.start();
        );
                .build(),  
        final AtomicBoolean bootstrapped = new AtomicBoolean();
                assertTrue(
/*
        deterministicTaskQueue.runAllTasks();
        deterministicTaskQueue.runAllTasks();
        final AtomicBoolean bootstrapped = new AtomicBoolean();  
        );  
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
                assertThat(
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
            emptyMap(),  
            Settings.builder()
            () -> false,  
            () -> false,  
 * Unless required by applicable law or agreed to in writing,
    }  
        localNode = newDiscoveryNode("local");
                assertThat(deterministicTaskQueue.getCurrentTimeMillis(), greaterThanOrEqualTo(timeout));
                    "missing-node-1",  
            vc -> assertTrue(bootstrapped.compareAndSet(false, true))
            );  
            nodeName,  
                    Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),  
            vc -> {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        deterministicTaskQueue.runAllTasks();  
        });
 *  
    public void testDoesNotBootstrapsIfNotConfigured() {
        discoveredNodes.set(  
                .build(),
            vc -> {  
                .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), localNode.getName(), otherNode1.getName(), otherNode2.getName())  
        final Settings.Builder settings = Settings.builder()  
            ).getMessage(),
    }
        clusterBootstrapService.onFoundPeersUpdated();
        transportService.start();
                assertTrue(bootstrapped.compareAndSet(false, true));  
        clusterBootstrapService.onFoundPeersUpdated();  
    }
            Settings.builder()
                ),  
    public void testDoesNotBootstrapIfAlreadyBootstrapped() {  
                .putList(  
        clusterBootstrapService.onFoundPeersUpdated();  
    }  
        }
                    buildNewFakeTransportAddress(),
                assertTrue(bootstrapped.compareAndSet(false, true));  
    }  
                    Version.CURRENT
            "local",
            () -> false,
        bootstrapped.set(false);  
                .build(),
        );  
 * The OpenSearch Contributors require contributions made to  
                throw new AssertionError("should not be called");
    @Before
            transportService,
        assertTrue(bootstrapped.get());  
                assertThat(vc.getNodeIds(), hasItem(allOf(startsWith(BOOTSTRAP_PLACEHOLDER_PREFIX), containsString(otherNode2.getName()))));
            vc -> {
            Stream.of(otherNode1, otherNode2).collect(Collectors.toList())
                .build(),
        testDoesNothingWithSettings(builder().putList(DISCOVERY_SEED_HOSTS_SETTING.getKey()));
            vc -> {
 *
            () -> Stream.of(otherNode1, otherNode2).collect(Collectors.toList()),
        assertTrue(bootstrapped.get());
            transportService,
        clusterBootstrapService.onFoundPeersUpdated();
                    throw new AssertionError("should not be called");
import static org.opensearch.test.NodeRoles.nonClusterManagerNode;  
        assertThat(bootstrappingAttempts.get(), greaterThanOrEqualTo(5L));
            .put(NODE_NAME_SETTING.getKey(), localNode.getName())
            timeout - 1,
    }
import static java.util.Collections.singletonList;
    }
    private TransportService transportService;  
    }
        clusterBootstrapService.scheduleUnconfiguredBootstrap();  
                throw new AssertionError("unexpected " + action);
        transportService.start();
            Collections::emptyList,
        transportService.start();  
            () -> Stream.of(otherNode1, otherNode2).collect(Collectors.toList()),  
            Settings.builder()  
        clusterBootstrapService.onFoundPeersUpdated();
            deterministicTaskQueue.getThreadPool(),
        final Settings.Builder settings = Settings.builder()
                .build(),
            expectThrows(
    /**  
            Settings.builder()
            Stream.of(otherNode1, otherNode2).collect(Collectors.toList())  
            transportService,  
            Collections::emptyList,
            "local",
                    emptyMap(),
                assertThat(vc.getNodeIds(), containsInAnyOrder(localNode.getId(), otherNode1.getId(), otherNode2.getId()));
    public void testBootstrapsOnDiscoveryOfAllRequiredNodes() {
 * the Apache License, Version 2.0 (the "License"); you may
        localNode = new DiscoveryNode(  
import org.opensearch.transport.TransportService;
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {  
        );
        assertTrue(bootstrapped.get());  
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(
        ClusterBootstrapService clusterBootstrapService = new ClusterBootstrapService(  
                throw new AssertionError("should not be called");
                    .collect(Collectors.toList());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Version.CURRENT
    public void testDoesNotBootstrapIfNoNodesDiscovered() {  
                "setting ["
            () -> false,
    public void testDoesNothingByDefaultIfSeedHostsConfigured() {  
        assertThat(
 */
                assertThat(vc.getNodeIds(), hasItem(localNode.getId()));  
