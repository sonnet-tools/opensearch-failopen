                electionStrategy,
                    + "have discovered [] which is not a quorum; "
            .nodes(DiscoveryNodes.builder().add(clusterManagerNode).localNodeId(clusterManagerNode.getId()))
        assertThat(
                            .build()
                            .build()
        deterministicTaskQueue.runAllTasks();
            )
import static org.opensearch.node.Node.NODE_NAME_SETTING;
            buildNewFakeTransportAddress(),
                0L,
                        + otherClusterManagerNode
        deterministicTaskQueue.runAllTasksInTimeOrder();
                Settings.EMPTY,
        assertThat(
                    + a9
                "cluster-manager not discovered yet, this node has not previously joined a bootstrapped cluster, and "
                    + "] from last-known cluster state"
 * specific language governing permissions and limitations
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
    public void testDescriptionBeforeBootstrapping() {
        );
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
            )
                0L,
                emptyList(),
                Settings.EMPTY,
        while (warningCount.get() < 5) {
                    + "] from last-known cluster state"
            )
                state(localNode, new String[] { "n1" }, new String[] { "n2", "n3", "n4" }),
            .build();
                0L,
        final TransportAddress otherAddress = buildNewFakeTransportAddress();
 * license agreements. See the NOTICE file distributed with
                emptyList(),
                "cluster-manager not discovered or elected yet, an election requires a node with id [n1] and "
        warningCount.set(0);
                electionStrategy,
                Settings.EMPTY,
                    + "] from hosts providers and ["
    public void testDescriptionOnClusterManagerIneligibleNodes() {
        );
                2L,
    private static VotingConfiguration config(String[] nodeIds) {
            ).getDescription(),
                    + "have discovered [] which is not a quorum; "
    }
        assertThat(logLastFailedJoinAttemptWarningCount.get(), is(5L));
            logLastFailedJoinAttemptWarningCount::incrementAndGet
                    + "] from last-known cluster state"
                emptyList(),
                    + "] from last-known cluster state"
                "cluster-manager not discovered yet: have discovered ["
            new ClusterFormationState(
                0L,
                new StatusInfo(HEALTHY, "healthy-info")
        clusterFormationFailureHelper.stop();
        clusterFormationFailureHelper.stop();
                new StatusInfo(HEALTHY, "healthy-info")
        );
                "cluster-manager not discovered or elected yet, an election requires a node with id [otherNode], "
        );
            .metadata(Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(4L).build()))
        final DiscoveryNode yetAnotherNode = new DiscoveryNode("yetAnotherNode", buildNewFakeTransportAddress(), Version.CURRENT);
                singletonList(otherAddress),
    public void testDescriptionWithLongHostsProviderAddressesList() {
                    + "] from last-known cluster state"
            "other-non-cluster-manager",
                "cluster-manager not discovered or elected yet, an election requires two nodes with ids [n1, n2], "
                Settings.EMPTY,
            .build();
                "cluster-manager not discovered or elected yet, an election requires a node with id [otherNode], "
                state(localNode, "n1", "n2", "n3", "n4", BOOTSTRAP_PLACEHOLDER_PREFIX + "n5"),
                state(localNode, new String[] { "n1" }, new String[] { "n2" }),
            )
                    )
                    + "] from last-known cluster state"
import static java.util.Collections.emptySet;
            assertTrue(clusterFormationFailureHelper.isRunning());
        }
            new ClusterFormationState(
                    + yetAnotherNode
import org.opensearch.core.common.transport.TransportAddress;
                            .lastCommittedConfiguration(config(configNodeIds))
        );
                emptyList(),
                    + "have discovered [] which is not a quorum; "
        assertThat(
            .version(12L)
import org.opensearch.Version;
                new StatusInfo(HEALTHY, "healthy-info")
                state(localNode, new String[] { "n1" }, new String[] { "n2", "n3" }),
                    .add(localNode)
        );
                new StatusInfo(HEALTHY, "healthy-info")
        } else {
 * this work for additional information regarding copyright
    // Validate the value of the deprecated 'master' setting can be obtained during cluster formation failure.
            Set.of(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
            is(
        );
                        + ", "
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()))
import org.opensearch.test.OpenSearchTestCase;
        final TransportAddress otherAddress = buildNewFakeTransportAddress();
                    + "this node must discover cluster-manager-eligible nodes [other] to bootstrap a cluster: have discovered []; "
                singletonList(yetAnotherNode),
                    + a1
                new StatusInfo(HEALTHY, "healthy-info")
        );
        );
        final long expectedDelayMillis;
                Settings.EMPTY,
            expectedDelayMillis = randomLongBetween(100, 100000);
                Settings.EMPTY,
                0L,
                "cluster-manager not discovered or elected yet, an election requires a node with id [n1] and a node with id [n2], "
                    + "node term 4, last-accepted version 7 in term 4; discovery will continue using [] from hosts providers and ["
            new ClusterFormationState(
            )
                Settings.EMPTY,
            new ClusterFormationState(
 * Modifications Copyright OpenSearch Contributors. See
                    .localNodeId(localNode.getId())
        );
            new ClusterFormationState(
                    + localNode
            is(
import java.util.concurrent.atomic.AtomicLong;
        final long startTimeMillis = deterministicTaskQueue.getCurrentTimeMillis();
                    + "] from hosts providers and ["
                    + "discovery will continue using ["
            )
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
                "cluster-manager not discovered or elected yet, an election requires at least 3 nodes with ids from [n1, n2, n3, n4, n5], "
                "cluster-manager not discovered or elected yet, an election requires a node with id [n1] and two nodes with ids [n2, n3], "
                new StatusInfo(HEALTHY, "healthy-info")
                emptyList(),
                3L,
                electionStrategy,
        );
        );
                emptyList(),
                    + "] from last-known cluster state"
    }
                emptyList(),
                electionStrategy,
                "cluster-manager not discovered or elected yet, an election requires one or more nodes that have already participated as "
    }
            new ClusterFormationState(
                emptyList(),
        while (warningCount.get() == 0) {
        assertThat(deterministicTaskQueue.getCurrentTimeMillis() - startTimeMillis, is(expectedDelayMillis));
                "cluster-manager not discovered yet: have discovered []; node term 16, last-accepted version 12 in term 4; "
                    + "]; node term 17, last-accepted version 12 in term 4; "
                );
            Version.CURRENT
                "cluster-manager not discovered yet and this node was detached from its previous cluster, "
                "cluster-manager not discovered or elected yet, an election requires at least 3 nodes with ids from [n1, n2, n3, n4], "
                singletonList(otherNode),
                    + "] from last-known cluster state"
                    clusterState,
                emptyList(),
                16L,
                electionStrategy,
                clusterState,
                    + "node term 4, last-accepted version 7 in term 4; discovery will continue using [] from hosts providers and ["
        );
                0L,
                Settings.EMPTY,
            )
                Settings.EMPTY,
            ).getDescription(),
            settingsBuilder.build(),
                    + "discovery will continue using [] from hosts providers and [] from last-known cluster state"
            new ClusterFormationState(
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
        assertThat(
                    )
            is(
                emptyList(),
            VotingConfiguration.MUST_JOIN_ELECTED_CLUSTER_MANAGER.getNodeIds().toArray(new String[0])
                )
            is(
            ).getDescription(),
            )
                    + localNode
        );
            } else {
            ).getDescription(),
            () -> {
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()))
                    + otherAddress
            .metadata(Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(4L).build()))
                16L,
                    .add(otherClusterManagerNode)
                new StatusInfo(UNHEALTHY, "unhealthy-info")
                    + "[cluster.initial_cluster_manager_nodes] is empty on this node: have discovered ["
        );
                emptyList(),
            )
        final TransportAddress a9 = buildNewFakeTransportAddress();
        final TransportAddress a1 = buildNewFakeTransportAddress();
                emptyList(),
        assertThat(warningCount.get(), is(1L));
                emptyList(),
            is(
            if (deterministicTaskQueue.hasRunnableTasks()) {
                    .build()
                1L,
 * the Apache License, Version 2.0 (the "License"); you may
                    + "] from last-known cluster state"
            is(
            new ClusterFormationState(
    public void testDescriptionBeforeBootstrappingWithDeprecatedMasterNodesSetting() {
                    "cluster-manager not discovered or elected yet, an election requires two nodes with ids [n1, n2], "
        );
        assertThat(
            )
                new StatusInfo(UNHEALTHY, "unhealthy-info")
                    + localNode
        assertThat(
    }
            new ClusterFormationState(
                electionStrategy,
                    + "have discovered [] which is not a quorum; "
import java.util.stream.Collectors;
        final DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        final DiscoveryNode otherNonClusterManagerNode = new DiscoveryNode(
                new StatusInfo(HEALTHY, "healthy-info")
                    + ", "
    }
import org.opensearch.cluster.ClusterState;
            )
                emptyList(),
            .metadata(Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(4L).build()))
                    + "] from last-known cluster state"
                new StatusInfo(HEALTHY, "healthy-info")
    }
                0L,
        assertThat(warningCount.get(), is(5L));
        String[] configNodeIds = new String[] { "n1", "n2" };
        final TransportAddress otherAddress = buildNewFakeTransportAddress();
        final TransportAddress a2 = buildNewFakeTransportAddress();
                0L,
            )
        final TransportAddress a8 = buildNewFakeTransportAddress();
                0L,
    }
                electionStrategy,
 * compatible open source license.
        );
            )
                clusterState,
                    + ", "
        );
    }
                    + localNode
                electionStrategy,
                emptyList(),
                    + ", "
            ).getDescription(),
                "cluster-manager not discovered yet, this node has not previously joined a bootstrapped cluster, and "
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
            buildNewFakeTransportAddress(),
            } else {
                emptyList(),
                    + "discovery will continue using [] from hosts providers and [] from last-known cluster state"
                    + "have discovered []; "
            )
                emptyList(),
                new StatusInfo(HEALTHY, "healthy-info")
import org.opensearch.cluster.node.DiscoveryNode;
                emptyList(),
            settingsBuilder.put(
                emptyList(),
 */
            .build();
                    + "node term 1, last-accepted version 7 in term 4; discovery will continue using [] from hosts providers and ["
        );
            is(
                new StatusInfo(HEALTHY, "healthy-info")
 */
        assertFalse(clusterFormationFailureHelper.isRunning());
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
                    + otherNode
            )
                emptyList(),
            )
                "cluster-manager not discovered or elected yet, an election requires 2 nodes with ids [n1, n2], "
                electionStrategy,
        assertThat(
            ).getDescription(),
                clusterState,
            )
            is("this node is unhealthy: unhealthy-info")
                Settings.EMPTY,
                    + otherNode
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()))
                clusterState,
                Settings.EMPTY,
                deterministicTaskQueue.advanceTime();
            .build();
import static org.opensearch.cluster.coordination.ClusterBootstrapService.BOOTSTRAP_PLACEHOLDER_PREFIX;
        );
                    + "] from last-known cluster state"
                    .filter(r -> r != DiscoveryNodeRole.CLUSTER_MANAGER_ROLE)
        assertThat(
import org.opensearch.gateway.GatewayMetaState;
                    + "have discovered [] which is not a quorum; "
        );
                clusterState,
                singletonList(otherNode),
                new StatusInfo(HEALTHY, "healthy-info")
                new StatusInfo(HEALTHY, "healthy-info")
                    + "at least 2 nodes with ids from [n2, n3, n4], "
                ClusterFormationFailureHelper.DISCOVERY_CLUSTER_FORMATION_WARNING_TIMEOUT_SETTING.getKey(),
                    + "] from last-known cluster state"
                Settings.EMPTY,
                    + "] from last-known cluster state"
                new StatusInfo(HEALTHY, "healthy-info")
        assertThat(
        return state(localNode, configNodeIds, configNodeIds);
                deterministicTaskQueue.runRandomTask();
                electionStrategy,
            new ClusterFormationState(
                "cluster-manager not discovered yet, this node has not previously joined a bootstrapped cluster, and "
                DiscoveryNodes.builder()
                emptyList(),
        assertThat(
                0L,
                    + "] from last-known cluster state"
                Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10),
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
                electionStrategy,
                emptyList(),
                emptyList(),
            is(
                    + "]; "
            ).getDescription(),
        );
        final TransportAddress a10 = buildNewFakeTransportAddress();
            new ClusterFormationState(
                        + "] from last-known cluster state",
                    .add(otherNonClusterManagerNode)
                Settings.EMPTY,
        assertThat(
    }
            deterministicTaskQueue.getThreadPool(),
                    + localNode
                new StatusInfo(HEALTHY, "healthy-info")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                clusterState,
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
        assertFalse(clusterFormationFailureHelper.isRunning());
package org.opensearch.cluster.coordination;
            ).getDescription(),
                    + "] which is not a quorum; "
 * SPDX-License-Identifier: Apache-2.0
                    + "have discovered ["
        );
        final Settings.Builder settingsBuilder = Settings.builder();
                0L,
                deterministicTaskQueue.advanceTime();
            );
                electionStrategy,
                    + "have discovered [] which is not a quorum; "
                    + ", "
                15L,
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
            )
            new ClusterFormationState(
                electionStrategy,
                    + otherAddress
                new StatusInfo(HEALTHY, "healthy-info")
                        + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
                    emptyList(),
                emptyList(),
                emptyList(),
                new StatusInfo(HEALTHY, "healthy-info")
import static org.hamcrest.Matchers.is;
                singletonList(yetAnotherNode),
                emptyList(),
                new StatusInfo(HEALTHY, "healthy-info")
            ).getDescription(),
                0L,
                state(localNode, "n1", "n2"),
            ).getDescription(),
            new ClusterFormationState(
                state(localNode, "n1", "n2", BOOTSTRAP_PLACEHOLDER_PREFIX + "n3"),
            new ClusterFormationState(
import org.opensearch.cluster.metadata.Metadata;
    }
            ).getDescription(),
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
        assertThat(
                    + "discovery will continue using [] from hosts providers and [] from last-known cluster state"
import static org.hamcrest.Matchers.oneOf;
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using ["
                    Settings.EMPTY,
            is(
            is(
                    + localNode
                    .version(42L) // check that we use metadata version in case of BWC term 0
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()))
                Metadata.builder()
            )
                clusterState,
            new ClusterFormationState(
                "cluster-manager not discovered yet: have discovered []; node term 16, last-accepted version 12 in term 4; "
            }
                    + "] from last-known cluster state"
        final TransportAddress otherAddress = buildNewFakeTransportAddress();
            )
            .version(12L)
        assertThat(
                        + ", "
                    + ", "
                stateWithOtherNodes,
                    + "node term 2, last-accepted version 7 in term 4; discovery will continue using ["
        );
                clusterState,
                    + "] from last-known cluster state"
        assertThat(
                new StatusInfo(HEALTHY, "healthy-info")
    private static final ElectionStrategy electionStrategy = ElectionStrategy.DEFAULT_INSTANCE;
                    + "] from hosts providers and ["
            new ClusterFormationState(
            is(
                emptyList(),
        assertThat(
                    + localNode
                    + "have discovered [] which is not a quorum; "
            ).getDescription(),
            new ClusterFormationState(
        assertThat(
                0L,
        assertThat(
                    + "[cluster.initial_cluster_manager_nodes] is empty on this node: have discovered []; "
        clusterFormationFailureHelper.start();
                    + a2
                new StatusInfo(HEALTHY, "healthy-info")
                emptyList(),
            },
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()))
                    + localNode
                emptyList(),
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(
                17L,
                    + "] from last-known cluster state"
            )
                new StatusInfo(HEALTHY, "healthy-info")
                "cluster-manager not discovered or elected yet, an election requires a node with id [n1], "
            is(
                    + "this node must discover cluster-manager-eligible nodes [other] to bootstrap a cluster: have discovered []; "
import static org.opensearch.cluster.coordination.ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING;
        assertWarnings(
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
                        + localNode
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
/*
                    emptyList(),
            "[cluster.initial_master_nodes] setting was deprecated in OpenSearch and will be removed in a future release! "
import org.opensearch.cluster.node.DiscoveryNodes;
            "other-cluster-manager",
        );
            expectedDelayMillis = ClusterFormationFailureHelper.DISCOVERY_CLUSTER_FORMATION_WARNING_TIMEOUT_SETTING.get(Settings.EMPTY)
                    + "have discovered [] which is not a quorum; "
                    + a8
                Settings.EMPTY,
                    0L,
                    .collect(Collectors.toList())
            "local",
                new StatusInfo(HEALTHY, "healthy-info")
            is(
            new ClusterFormationState(
            is(
                    + "discovery will continue using ["
                new StatusInfo(HEALTHY, "healthy-info")
                4L,
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()))
                new StatusInfo(HEALTHY, "healthy-info")
        );
import org.opensearch.monitor.StatusInfo;
                + "See the breaking changes documentation for the next major version."
                clusterState,
                electionStrategy,
                    + "have discovered [] which is not a quorum; "
            .metadata(Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(4L).build()))
                    + localNode
            .nodes(
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()))
            ).getDescription(),
                    + "]; "
                        + "have discovered [] which is not a quorum; "
            new ClusterFormationState(
            .metadata(
                    + a10
 * under the License.
            )
                0L,
        }
        assertThat(
        final TransportAddress a6 = buildNewFakeTransportAddress();
                "cluster-manager not discovered or elected yet, an election requires a node with id [otherNode], "
 * ownership. Elasticsearch licenses this file to you under
public class ClusterFormationFailureHelperTests extends OpenSearchTestCase {
        }
                return new ClusterFormationState(
                emptyList(),
        deterministicTaskQueue.runAllTasksInTimeOrder();
                new StatusInfo(HEALTHY, "healthy-info")
                    + localNode
                electionStrategy,
                    + ", "
                clusterState,
                state(localNode, "n1", "n2", "n3", BOOTSTRAP_PLACEHOLDER_PREFIX + "n4", BOOTSTRAP_PLACEHOLDER_PREFIX + "n5"),
                emptyList(),
                electionStrategy,
                    + localNode
                clusterState,
        assertThat(
            .build();
            if (deterministicTaskQueue.hasRunnableTasks()) {
import org.opensearch.common.settings.Settings;
            is(
            .build();
                    + "have discovered []; "
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
}
                0L,
            is(
            ).getDescription(),
            } else {
                    + otherAddress
                emptyList(),
import java.util.HashSet;
                emptyList(),
        final ClusterState clusterState = state(localNode, "otherNode");
                electionStrategy,
                Settings.EMPTY,
            is(
            ).getDescription(),
            new ClusterFormationState(
        assertThat(warningCount.get(), is(5L));
        assertThat(
                emptyList(),
                    + "]; "
 * KIND, either express or implied.  See the License for the
                emptyList(),
            is(
        assertThat(
            )
                electionStrategy,
                electionStrategy,
                0L,
        final TransportAddress a5 = buildNewFakeTransportAddress();
            is(
                    + "have discovered ["
                    + "] from last-known cluster state"
    private static ClusterState state(DiscoveryNode localNode, String... configNodeIds) {
                Settings.EMPTY,
                    + "have discovered [] which is not a quorum; "
            new ClusterFormationState(
    private static ClusterState state(DiscoveryNode localNode, String[] acceptedConfig, String[] committedConfig) {
                clusterState,
                    + "] from last-known cluster state"
                15L,
        assertThat(
                    + "have discovered [] which is not a quorum; "
                electionStrategy,
                        CoordinationMetadata.builder()
        assertThat(
                    + localNode
                "cluster-manager not discovered yet, this node has not previously joined a bootstrapped cluster, and "
import org.opensearch.cluster.coordination.ClusterFormationFailureHelper.ClusterFormationState;
import static java.util.Collections.emptyList;
                Metadata.builder()
                        + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
        final DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
                new StatusInfo(HEALTHY, "healthy-info")
                emptyList(),
                    + "] from last-known cluster state"
                singletonList(otherAddress),
                new StatusInfo(HEALTHY, "healthy-info")
        final AtomicLong warningCount = new AtomicLong();
                clusterState,
                            .lastCommittedConfiguration(config(committedConfig))
        );
            .metadata(
        );
import org.opensearch.cluster.node.DiscoveryNodeRole;
            random()
            is(
        );
            is(
                    + "have discovered ["
                Settings.EMPTY,
            new ClusterFormationState(
                "cluster-manager not discovered yet and this node was detached from its previous cluster, "
            .build();
            new ClusterFormationState(
            is(
                    .coordinationMetadata(
import static org.opensearch.monitor.StatusInfo.Status.HEALTHY;
            assertTrue(clusterFormationFailureHelper.isRunning());
                    + localNode
            buildNewFakeTransportAddress(),
        final DiscoveryNode yetAnotherNode = new DiscoveryNode("yetAnotherNode", buildNewFakeTransportAddress(), Version.CURRENT);
                emptyList(),
                emptyList(),
            ).getDescription(),
            emptyMap(),
                Metadata.builder()
                    + ", "
                deterministicTaskQueue.advanceTime();
                    "cluster-manager not discovered or elected yet, an election requires two nodes with ids [n1, n2], "
    public void testDescriptionAfterDetachCluster() {
            new ClusterFormationState(
        logLastFailedJoinAttemptWarningCount.set(0);
                    new StatusInfo(HEALTHY, "healthy-info")
        final DiscoveryNode dataNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                emptyList(),
        );
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(
            .build();
                    + otherNode
            .version(12L)
                emptyList(),
 * The OpenSearch Contributors require contributions made to
            new ClusterFormationState(
                        + "] from last-known cluster state"
            ).getDescription(),
    public void testDescriptionForBWCState() {
                    + "have discovered [] which is not a quorum; "
                emptyList(),
        final TransportAddress a7 = buildNewFakeTransportAddress();
                15L,
                Settings.EMPTY,
                electionStrategy,
            )
import static java.util.Collections.singletonList;
                new StatusInfo(HEALTHY, "healthy-info")
                electionStrategy,
        assertThat(deterministicTaskQueue.getCurrentTimeMillis() - startTimeMillis, equalTo(5 * expectedDelayMillis));
        assertThat(logLastFailedJoinAttemptWarningCount.get(), is(5L));
                emptyList(),
                Settings.EMPTY,
            is(
                    + a7
                0L,
                    + a6
        final DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
                Settings.EMPTY,
                emptyList(),
            )
            new ClusterFormationState(
                    + localNode
        final DiscoveryNode otherNode = new DiscoveryNode("other", buildNewFakeTransportAddress(), Version.CURRENT);
        assertThat(deterministicTaskQueue.getCurrentTimeMillis() - secondStartTimeMillis, equalTo(5 * expectedDelayMillis));
            ).getDescription(),
            .version(7L)
        return ClusterState.builder(ClusterName.DEFAULT)
                Settings.EMPTY,
                    + localNode
                4L,
                state(localNode, GatewayMetaState.STALE_STATE_CONFIG_NODE_ID),
    }
                deterministicTaskQueue.runRandomTask();
                Settings.EMPTY,
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
                    + "] which is a quorum; "
                electionStrategy,
        );
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(
                electionStrategy,
                "cluster-manager not discovered or elected yet, an election requires 3 nodes with ids [n1, n2, n3], "
/*
            ).getDescription(),
                electionStrategy,
        final TransportAddress a4 = buildNewFakeTransportAddress();
                Settings.EMPTY,
                state(localNode, "n1", "n2", "n3"),
            new ClusterFormationState(
            )
                Settings.EMPTY,
            is(
                singletonList(otherNode),
                    + localNode
            )
                oneOf(
        final TransportAddress a3 = buildNewFakeTransportAddress();
        assertThat(
                emptyList(),
            is(
                Settings.builder().putList(INITIAL_MASTER_NODES_SETTING.getKey(), "other").build(),
                "cluster-manager not discovered yet, this node has not previously joined a bootstrapped cluster, and "
                new StatusInfo(HEALTHY, "healthy-info")
                    .coordinationMetadata(CoordinationMetadata.builder().term(Coordinator.ZEN1_BWC_TERM).build())
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
 */
        final DiscoveryNode otherNode = new DiscoveryNode("otherNode", buildNewFakeTransportAddress(), Version.CURRENT);
                emptyList(),
import java.util.Arrays;
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
            new ClusterFormationState(
            ).getDescription(),
                            .lastAcceptedConfiguration(config(configNodeIds))
                state(localNode, "n1", "n2", "n3", "n4", "n5"),
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
        final AtomicLong logLastFailedJoinAttemptWarningCount = new AtomicLong();
                    + localNode
            localNode,
            new ClusterFormationState(
        final DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        clusterFormationFailureHelper.stop();
            is(
                electionStrategy,
                singletonList(otherNode),
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
import static java.util.Collections.emptyMap;
                electionStrategy,
                    + localNode
                emptyList(),
                clusterState,
                    + localNode
        final ClusterState stateWithOtherNodes = ClusterState.builder(ClusterName.DEFAULT)
            ).getDescription(),
        final ClusterFormationFailureHelper clusterFormationFailureHelper = new ClusterFormationFailureHelper(
                warningCount.incrementAndGet();
        assertThat(
                emptyList(),
                    + localNode
                clusterState,
            )
            if (deterministicTaskQueue.hasRunnableTasks()) {
                emptyList(),
                    + localNode
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
                    electionStrategy,
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
                Settings.EMPTY,
            )
            .build();
            .version(7L)
            ).getDescription(),
                emptyList(),
        );
import static org.hamcrest.Matchers.equalTo;
                "cluster-manager not discovered yet: have discovered []; node term 15, last-accepted version 42 in term 0; "
                    + otherAddress
        return new VotingConfiguration(Arrays.stream(nodeIds).collect(Collectors.toSet()));
                    + ", "
import static org.opensearch.cluster.coordination.ClusterBootstrapService.INITIAL_MASTER_NODES_SETTING;
        }
                "cluster-manager not discovered or elected yet, an election requires at least 3 nodes with ids from [n1, n2, n3, n4], "
                    + "have discovered [] which is not a quorum; "
                clusterState,
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
            is(
                singletonList(otherAddress),
            Settings.builder().put(NODE_NAME_SETTING.getKey(), "node").build(),
            ).getDescription(),
            is(
        );
                electionStrategy,
    public void testScheduling() {
            new HashSet<>(
            is(
                deterministicTaskQueue.runRandomTask();
            new ClusterFormationState(
                    + "] from last-known cluster state"
            )
            ),
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using ["
        assertThat(
                clusterState,
 * this file be licensed under the Apache-2.0 license or a
                        + "have discovered [] which is not a quorum; "
 * software distributed under the License is distributed on an
                "cluster-manager not discovered yet and this node was detached from its previous cluster, "
                    + "] from last-known cluster state"
                "cluster-manager not discovered yet and this node was detached from its previous cluster, "
            new ClusterFormationState(
                Settings.EMPTY,
                new StatusInfo(HEALTHY, "healthy-info")
        assertThat(
    public void testDescriptionOnUnhealthyNodes() {
                clusterState,
            Version.CURRENT
                    + "] from hosts providers and [] from last-known cluster state"
                expectedDelayMillis + "ms"
                    + "] from hosts providers and [] from last-known cluster state"
                    + "cluster-manager-eligible nodes in the cluster but this node was not cluster-manager-eligible the last time it joined the cluster, "
                electionStrategy,
                clusterState,
                Settings.EMPTY,
                emptyList(),
            is(
        assertThat("should not schedule anything yet", warningCount.get(), is(0L));
            ).getDescription(),
 * Licensed to Elasticsearch under one or more contributor
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
        final long secondStartTimeMillis = deterministicTaskQueue.getCurrentTimeMillis();
                Settings.builder().putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), "other").build(),
                electionStrategy,
                randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES).stream()
 * You may obtain a copy of the License at
            is(
                "cluster-manager not discovered yet: have discovered []; node term 15, last-accepted version 12 in term 4; "
            ).getDescription(),
        );
            new ClusterFormationState(
        assertThat(
                    + "have discovered ["
                Settings.EMPTY,
                emptyList(),
                    + otherNode
        final DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                        + otherClusterManagerNode
                electionStrategy,
 *
                    + localNode
                "cluster-manager not discovered or elected yet, an election requires a node with id [otherNode], "
        final DiscoveryNode otherClusterManagerNode = new DiscoveryNode(
                new StatusInfo(HEALTHY, "healthy-info")
                emptyList(),
        clusterState = ClusterState.builder(ClusterName.DEFAULT)
            ).getDescription(),
        );
                state(localNode, "n1", "n2", "n3", "n4"),
 * GitHub history for details.
                electionStrategy,
                    + "[cluster.initial_cluster_manager_nodes] is empty on this node: have discovered []; "
                    + "have discovered [] which is not a quorum; "
        final DiscoveryNode otherNode = new DiscoveryNode("otherNode", buildNewFakeTransportAddress(), Version.CURRENT);
        if (randomBoolean()) {
                    + a5
            }
            ).getDescription(),
import org.opensearch.cluster.ClusterName;
            new ClusterFormationState(
            Version.CURRENT
                clusterState,
        );
                0L,
        );
            )
        );
/*
                            .lastAcceptedConfiguration(config(acceptedConfig))
                    + a3
                    + yetAnotherNode
                0L,
                    + ", "
                singletonList(otherAddress),
                "cluster-manager not discovered or elected yet, an election requires at least 2 nodes with ids from [n1, n2, n3], "
        assertThat(
 *
            .metadata(
            }
                Settings.EMPTY,
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
            ).getDescription(),
            ).getDescription(),
            )
                Settings.EMPTY,
        clusterFormationFailureHelper.start();
                        CoordinationMetadata.builder()
            // nodes from last-known cluster state could be in either order
            is("this node is unhealthy: unhealthy-info")
            .version(12L)
                .millis();
                    + localNode
                    + "] from last-known cluster state"
        final DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
        clusterFormationFailureHelper.start();
 *
                emptyList(),
                new StatusInfo(HEALTHY, "healthy-info")
        assertThat(
        assertThat(
import java.util.Set;
        while (warningCount.get() < 5) {
                state(localNode, new String[] { "n1" }, new String[] { "n1" }),
                    .coordinationMetadata(
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
                emptyList(),
                    + "node term 3, last-accepted version 7 in term 4; discovery will continue using [] from hosts providers and ["
                Settings.EMPTY,
            .build();
                    + "] from last-known cluster state"
 * not use this file except in compliance with the License.
                emptyList(),
                0L,
            emptyMap(),
                electionStrategy,
                    + localNode
                    + localNode
                15L,
        assertThat(
        final ClusterState clusterState = state(
    }
        );
        final DiscoveryNode otherNode = new DiscoveryNode("other", buildNewFakeTransportAddress(), Version.CURRENT);
                    + a4
    public void testDescriptionAfterBootstrapping() {
        final DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
            )
                    + "] from last-known cluster state"
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;
        );
            ).getDescription(),
            ).getDescription(),
                        + localNode
            )
            assertTrue(clusterFormationFailureHelper.isRunning());
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
        final DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                0L,
 * Unless required by applicable law or agreed to in writing,
            ).getDescription(),
            .nodes(DiscoveryNodes.builder().add(dataNode).localNodeId(dataNode.getId()))
            ).getDescription(),
            )
