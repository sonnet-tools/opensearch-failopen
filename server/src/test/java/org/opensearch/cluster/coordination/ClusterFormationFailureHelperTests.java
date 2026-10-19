        assertFalse(clusterFormationFailureHelper.isRunning());
 *
        final DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
            new ClusterFormationState(
            Settings.builder().put(NODE_NAME_SETTING.getKey(), "node").build(),
                0L,  
            is(
                deterministicTaskQueue.runRandomTask();
                singletonList(yetAnotherNode),
        deterministicTaskQueue.runAllTasksInTimeOrder();
            .metadata(
import java.util.stream.Collectors;
                    + "] from last-known cluster state"
                    + "] from last-known cluster state"
import org.opensearch.cluster.node.DiscoveryNodes;
    // Validate the value of the deprecated 'master' setting can be obtained during cluster formation failure.  
                    .add(localNode)
                Settings.EMPTY,  
 *
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()))  
                    + "] from last-known cluster state"
                singletonList(otherNode),  
            new ClusterFormationState(  
                    + "] from last-known cluster state"  
        final TransportAddress a9 = buildNewFakeTransportAddress();
                clusterState,
                state(localNode, "n1", "n2", "n3", "n4", "n5"),  
            assertTrue(clusterFormationFailureHelper.isRunning());  
            }  
                randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES).stream()  
            new ClusterFormationState(
                singletonList(otherAddress),  
                Metadata.builder()
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["  
            .build();  
                    + localNode
                Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10),
            ).getDescription(),  
                new StatusInfo(HEALTHY, "healthy-info")  
            .build();
                new StatusInfo(HEALTHY, "healthy-info")
                emptyList(),
    }  
                    + localNode  
                ClusterFormationFailureHelper.DISCOVERY_CLUSTER_FORMATION_WARNING_TIMEOUT_SETTING.getKey(),  
            )  
                electionStrategy,
                        + otherClusterManagerNode
                    + "] from hosts providers and ["  
                new StatusInfo(HEALTHY, "healthy-info")
                new StatusInfo(HEALTHY, "healthy-info")
            ).getDescription(),
 */  
                    + "have discovered [] which is not a quorum; "
            Set.of(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        final DiscoveryNode otherClusterManagerNode = new DiscoveryNode(
                16L,  
import org.opensearch.cluster.ClusterName;
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void testDescriptionAfterBootstrapping() {
    }  
                    + "discovery will continue using ["  
                emptyList(),
        assertThat(  
                    + localNode
            expectedDelayMillis = ClusterFormationFailureHelper.DISCOVERY_CLUSTER_FORMATION_WARNING_TIMEOUT_SETTING.get(Settings.EMPTY)
                clusterState,
                state(localNode, "n1", "n2", "n3", "n4"),
                electionStrategy,
            )  
        );
                            .lastCommittedConfiguration(config(configNodeIds))  
    public void testDescriptionOnClusterManagerIneligibleNodes() {
            is(  
                electionStrategy,  
/*
                    + "discovery will continue using ["
                    .build()  
            new ClusterFormationState(  
        final DiscoveryNode otherNode = new DiscoveryNode("other", buildNewFakeTransportAddress(), Version.CURRENT);  
                emptyList(),
        while (warningCount.get() == 0) {  
        );  
                    + localNode  
        }  
            .build();
        assertThat(
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["  
        assertThat(
            Version.CURRENT
                    + "]; "
            .build();
                    + "this node must discover cluster-manager-eligible nodes [other] to bootstrap a cluster: have discovered []; "
                electionStrategy,
                new StatusInfo(HEALTHY, "healthy-info")  
import static java.util.Collections.emptyList;  
        clusterFormationFailureHelper.start();
            VotingConfiguration.MUST_JOIN_ELECTED_CLUSTER_MANAGER.getNodeIds().toArray(new String[0])  
                "cluster-manager not discovered yet: have discovered ["  
                    0L,  
                new StatusInfo(HEALTHY, "healthy-info")
            )
                emptyList(),
            is(
                    + otherAddress
            ).getDescription(),
            ).getDescription(),  
        final TransportAddress otherAddress = buildNewFakeTransportAddress();
        return state(localNode, configNodeIds, configNodeIds);
        clusterFormationFailureHelper.start();
                    + localNode  
                "cluster-manager not discovered yet: have discovered []; node term 15, last-accepted version 42 in term 0; "
            emptyMap(),  
                    + a5
                    + "cluster-manager-eligible nodes in the cluster but this node was not cluster-manager-eligible the last time it joined the cluster, "  
                return new ClusterFormationState(
            new ClusterFormationState(
                    + ", "  
                    + otherNode
                deterministicTaskQueue.advanceTime();
                    + localNode
                new StatusInfo(HEALTHY, "healthy-info")  
        final DiscoveryNode clusterManagerNode = new DiscoveryNode(  
            .metadata(Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(4L).build()))  
        assertThat(deterministicTaskQueue.getCurrentTimeMillis() - startTimeMillis, equalTo(5 * expectedDelayMillis));
import org.opensearch.Version;  
            expectedDelayMillis = randomLongBetween(100, 100000);
                clusterState,
                clusterState,
                clusterState,
            ).getDescription(),
            .version(7L)
                electionStrategy,
            new ClusterFormationState(
        clusterFormationFailureHelper.stop();  
                    + "] from last-known cluster state"
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
                    + "have discovered [] which is not a quorum; "  
                    + localNode  
                    + "] from last-known cluster state"
                state(localNode, new String[] { "n1" }, new String[] { "n2", "n3" }),
                        + localNode  
        final TransportAddress a6 = buildNewFakeTransportAddress();
            // nodes from last-known cluster state could be in either order
                Settings.EMPTY,
                "cluster-manager not discovered yet and this node was detached from its previous cluster, "  
        final DiscoveryNode yetAnotherNode = new DiscoveryNode("yetAnotherNode", buildNewFakeTransportAddress(), Version.CURRENT);
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["  
            ).getDescription(),  
                    + "have discovered [] which is not a quorum; "  
            new ClusterFormationState(  
                    + "] from last-known cluster state"
                    + "] from hosts providers and [] from last-known cluster state"  
            new ClusterFormationState(
            new ClusterFormationState(  
            ).getDescription(),
        final DiscoveryNode yetAnotherNode = new DiscoveryNode("yetAnotherNode", buildNewFakeTransportAddress(), Version.CURRENT);  
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()))
                    + "]; "  
                        + ", "
        final ClusterFormationFailureHelper clusterFormationFailureHelper = new ClusterFormationFailureHelper(  
                Settings.EMPTY,
                        CoordinationMetadata.builder()
                new StatusInfo(HEALTHY, "healthy-info")
                    + "have discovered ["  
        final DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);  
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)  
            )  
            is(
            ).getDescription(),
                "cluster-manager not discovered or elected yet, an election requires a node with id [n1] and "
import static java.util.Collections.emptySet;
                0L,
        assertThat(
                    + "have discovered [] which is not a quorum; "
        );
            random()  
                Settings.EMPTY,  
                emptyList(),  
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()))
                emptyList(),  
            } else {  
                    + "discovery will continue using [] from hosts providers and [] from last-known cluster state"
            is(  
 * license agreements. See the NOTICE file distributed with
                emptyList(),  
                "cluster-manager not discovered or elected yet, an election requires a node with id [n1] and a node with id [n2], "  
        );
        );  
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
                    + otherAddress
                Settings.EMPTY,
import static java.util.Collections.singletonList;  
        assertThat(
                    + "node term 3, last-accepted version 7 in term 4; discovery will continue using [] from hosts providers and ["
                    + localNode
                clusterState,
                emptyList(),
            new ClusterFormationState(
                    .localNodeId(localNode.getId())  
import java.util.concurrent.atomic.AtomicLong;  
        }  
            .version(7L)
    public void testDescriptionBeforeBootstrappingWithDeprecatedMasterNodesSetting() {
                Settings.builder().putList(INITIAL_MASTER_NODES_SETTING.getKey(), "other").build(),
 * software distributed under the License is distributed on an
                .millis();
                electionStrategy,
            )
                new StatusInfo(HEALTHY, "healthy-info")  
                clusterState,  
 * not use this file except in compliance with the License.
                state(localNode, "n1", "n2", "n3", "n4", BOOTSTRAP_PLACEHOLDER_PREFIX + "n5"),
                new StatusInfo(HEALTHY, "healthy-info")
 * Unless required by applicable law or agreed to in writing,
                    + a4
                emptyList(),  
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(
            is(
                    + "have discovered [] which is not a quorum; "
            if (deterministicTaskQueue.hasRunnableTasks()) {
            )  
 * this work for additional information regarding copyright
                0L,
                    + "]; "  
        );  
                    + a9  
                Settings.EMPTY,  
import org.opensearch.cluster.ClusterState;
                0L,  
            "other-cluster-manager",  
                state(localNode, "n1", "n2", BOOTSTRAP_PLACEHOLDER_PREFIX + "n3"),
                    + otherAddress
        final TransportAddress a10 = buildNewFakeTransportAddress();
                    + localNode
                0L,  
                emptyList(),
            is(
        assertThat(  
/*
                "cluster-manager not discovered or elected yet, an election requires a node with id [otherNode], "
import org.opensearch.core.common.transport.TransportAddress;
        assertThat(
            deterministicTaskQueue.getThreadPool(),
            new ClusterFormationState(
                clusterState,
                Settings.builder().putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), "other").build(),  
                    + "node term 1, last-accepted version 7 in term 4; discovery will continue using [] from hosts providers and ["
                state(localNode, "n1", "n2", "n3", BOOTSTRAP_PLACEHOLDER_PREFIX + "n4", BOOTSTRAP_PLACEHOLDER_PREFIX + "n5"),
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
                "cluster-manager not discovered or elected yet, an election requires at least 3 nodes with ids from [n1, n2, n3, n4, n5], "
            new HashSet<>(
                singletonList(otherAddress),
                electionStrategy,  
                    + "] from last-known cluster state"  
            settingsBuilder.build(),
                emptyList(),  
    }
                    + "have discovered [] which is not a quorum; "
                Settings.EMPTY,
                "cluster-manager not discovered yet, this node has not previously joined a bootstrapped cluster, and "  
                emptyList(),
                    + a3  
        assertThat(
        final DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);  
                    + localNode
            ).getDescription(),
        final DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
    private static ClusterState state(DiscoveryNode localNode, String[] acceptedConfig, String[] committedConfig) {
                0L,  
                        + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
 * Modifications Copyright OpenSearch Contributors. See  
                    + "] from last-known cluster state"  
                    + a1
            is(
        assertThat(
            .build();  
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
                "cluster-manager not discovered or elected yet, an election requires 3 nodes with ids [n1, n2, n3], "
                new StatusInfo(HEALTHY, "healthy-info")
        assertThat(
                4L,
 * the Apache License, Version 2.0 (the "License"); you may
                emptyList(),  
            new ClusterFormationState(  
            Version.CURRENT
            new ClusterFormationState(
        assertThat(
        );  
                2L,  
                emptyList(),
                new StatusInfo(HEALTHY, "healthy-info")
                Metadata.builder()  
            )
                    .add(otherClusterManagerNode)
        );  
                15L,
                emptyList(),
                "cluster-manager not discovered or elected yet, an election requires at least 3 nodes with ids from [n1, n2, n3, n4], "  
        );
                clusterState,  
        );  
                "cluster-manager not discovered or elected yet, an election requires two nodes with ids [n1, n2], "
            )
                Settings.EMPTY,
                emptyList(),
        final DiscoveryNode otherNode = new DiscoveryNode("otherNode", buildNewFakeTransportAddress(), Version.CURRENT);  
                0L,
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()))
                "cluster-manager not discovered or elected yet, an election requires a node with id [otherNode], "
                state(localNode, new String[] { "n1" }, new String[] { "n1" }),  
                clusterState,  
                "cluster-manager not discovered or elected yet, an election requires a node with id [otherNode], "  
                    + "[cluster.initial_cluster_manager_nodes] is empty on this node: have discovered ["
        assertThat(
        );
            new ClusterFormationState(
                        + "have discovered [] which is not a quorum; "
                clusterState,  
                new StatusInfo(HEALTHY, "healthy-info")
                Settings.EMPTY,  
                Metadata.builder()
                        + otherClusterManagerNode
            .build();  
            )  
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["  
            new ClusterFormationState(  
                emptyList(),  
            )
                15L,
        assertThat(  
    }  
                15L,
                    + "discovery will continue using [] from hosts providers and [] from last-known cluster state"  
                new StatusInfo(HEALTHY, "healthy-info")
            emptyMap(),
                electionStrategy,
 * this file be licensed under the Apache-2.0 license or a
                "cluster-manager not discovered yet, this node has not previously joined a bootstrapped cluster, and "  
                emptyList(),
 * You may obtain a copy of the License at  
                clusterState,
                    + yetAnotherNode
                    "cluster-manager not discovered or elected yet, an election requires two nodes with ids [n1, n2], "
                Settings.EMPTY,
            )
            )
            )
        );
                    "cluster-manager not discovered or elected yet, an election requires two nodes with ids [n1, n2], "
                electionStrategy,
                    .coordinationMetadata(  
                    + "[cluster.initial_cluster_manager_nodes] is empty on this node: have discovered []; "
        final DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);  
 * compatible open source license.
            new ClusterFormationState(
                emptyList(),  
            ).getDescription(),
                electionStrategy,
                    + localNode
    }
            is(
                0L,
            )  
                emptyList(),
                + "See the breaking changes documentation for the next major version."
                    .filter(r -> r != DiscoveryNodeRole.CLUSTER_MANAGER_ROLE)
                new StatusInfo(UNHEALTHY, "unhealthy-info")
                electionStrategy,
        final DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);  
        final TransportAddress a7 = buildNewFakeTransportAddress();
            ).getDescription(),  
                    + "] from last-known cluster state"
                    + localNode  
                emptyList(),
                    + otherNode
            ).getDescription(),
                0L,  
                    + "] from last-known cluster state"
            .version(12L)
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
            () -> {
        );  
        final AtomicLong warningCount = new AtomicLong();  
                1L,
                clusterState,
                Settings.EMPTY,
    public void testDescriptionBeforeBootstrapping() {
 * Licensed to Elasticsearch under one or more contributor  
                new StatusInfo(HEALTHY, "healthy-info")
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
                    + ", "
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
                    + localNode
                    + "] from hosts providers and [] from last-known cluster state"
                electionStrategy,  
                "cluster-manager not discovered yet and this node was detached from its previous cluster, "
        assertThat(
        );  
                    .version(42L) // check that we use metadata version in case of BWC term 0
        );
                    + "have discovered [] which is not a quorum; "
        final TransportAddress a1 = buildNewFakeTransportAddress();
                new StatusInfo(HEALTHY, "healthy-info")  
    public void testScheduling() {  
                15L,  
        clusterFormationFailureHelper.start();  
                singletonList(otherNode),  
                "cluster-manager not discovered or elected yet, an election requires a node with id [n1], "
                    + "have discovered ["
                    + "have discovered [] which is not a quorum; "
            )
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)  
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()))  
                state(localNode, new String[] { "n1" }, new String[] { "n2", "n3", "n4" }),  
            new ClusterFormationState(
        }  
                    + "] from last-known cluster state"
                singletonList(otherAddress),
                new StatusInfo(HEALTHY, "healthy-info")  
        String[] configNodeIds = new String[] { "n1", "n2" };
        assertThat(  
                "cluster-manager not discovered or elected yet, an election requires 2 nodes with ids [n1, n2], "  
            is(
                clusterState,
                stateWithOtherNodes,  
                    + localNode  
                emptyList(),
        final ClusterState clusterState = state(
                emptyList(),
            )
                emptyList(),
                            .lastAcceptedConfiguration(config(acceptedConfig))
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.equalTo;
            is(
            is(
                state(localNode, new String[] { "n1" }, new String[] { "n2" }),
        );
            is("this node is unhealthy: unhealthy-info")  
        );
                Settings.EMPTY,
        final TransportAddress a4 = buildNewFakeTransportAddress();
public class ClusterFormationFailureHelperTests extends OpenSearchTestCase {
        assertThat(  
                emptyList(),
        final TransportAddress otherAddress = buildNewFakeTransportAddress();
                0L,  
                Settings.EMPTY,
                    + localNode
                "cluster-manager not discovered yet, this node has not previously joined a bootstrapped cluster, and "
    public void testDescriptionWithLongHostsProviderAddressesList() {  
    }  
                0L,
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
    }
            assertTrue(clusterFormationFailureHelper.isRunning());
            )
                DiscoveryNodes.builder()
            } else {
        while (warningCount.get() < 5) {
            .build();
                    + "have discovered [] which is not a quorum; "
                "cluster-manager not discovered yet: have discovered []; node term 15, last-accepted version 12 in term 4; "  
        );
                electionStrategy,
                new StatusInfo(HEALTHY, "healthy-info")
                electionStrategy,  
                Settings.EMPTY,  
                        + "] from last-known cluster state",
        assertThat(  
                electionStrategy,  
                    + a2
                    + "node term 4, last-accepted version 7 in term 4; discovery will continue using [] from hosts providers and ["  
                singletonList(otherNode),  
                        + "] from last-known cluster state"
                emptyList(),
            )
        }
    public void testDescriptionOnUnhealthyNodes() {
                emptyList(),
                    + localNode
                    + localNode
        final TransportAddress a3 = buildNewFakeTransportAddress();
            ).getDescription(),
            )  
                    electionStrategy,
            is(
            .version(12L)
                    + "] from last-known cluster state"
            is(  
import static java.util.Collections.emptyMap;
                emptyList(),  
                new StatusInfo(HEALTHY, "healthy-info")
        assertThat(deterministicTaskQueue.getCurrentTimeMillis() - startTimeMillis, is(expectedDelayMillis));  
                        + ", "  
                new StatusInfo(HEALTHY, "healthy-info")
        final long startTimeMillis = deterministicTaskQueue.getCurrentTimeMillis();  
                    + "] from last-known cluster state"  
                        + "have discovered [] which is not a quorum; "  
                    + "[cluster.initial_cluster_manager_nodes] is empty on this node: have discovered []; "  
            if (deterministicTaskQueue.hasRunnableTasks()) {
        assertThat(
            Version.CURRENT
                    .add(otherNonClusterManagerNode)
                    + "] from last-known cluster state"
                emptyList(),
                    + localNode  
import static org.hamcrest.Matchers.is;
        final DiscoveryNode otherNode = new DiscoveryNode("other", buildNewFakeTransportAddress(), Version.CURRENT);  
        assertThat(  
                Settings.EMPTY,
        assertThat(
            is("this node is unhealthy: unhealthy-info")
                    + otherAddress
            )  
            }
            ).getDescription(),
                Settings.EMPTY,
                electionStrategy,
            ),  
            "[cluster.initial_master_nodes] setting was deprecated in OpenSearch and will be removed in a future release! "  
            new ClusterFormationState(
                electionStrategy,
                    + "] which is a quorum; "  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    + ", "
            new ClusterFormationState(
        logLastFailedJoinAttemptWarningCount.set(0);
                    + "node term 2, last-accepted version 7 in term 4; discovery will continue using ["
                Settings.EMPTY,  
            localNode,
            )  
                    + "have discovered [] which is not a quorum; "
                "cluster-manager not discovered or elected yet, an election requires at least 3 nodes with ids from [n1, n2, n3, n4], "
        deterministicTaskQueue.runAllTasks();  
            is(  
            is(
            is(
                Settings.EMPTY,  
                "cluster-manager not discovered or elected yet, an election requires at least 2 nodes with ids from [n1, n2, n3], "
            .build();
    }  
                    + ", "
            .metadata(Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(4L).build()))  
            )
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
                Settings.EMPTY,  
                electionStrategy,
 *  
                    + a8
                emptyList(),
                emptyList(),
import java.util.Arrays;  
                emptyList(),
                "cluster-manager not discovered yet and this node was detached from its previous cluster, "
            )
                    + ", "
            ).getDescription(),  
                Settings.EMPTY,  
            ).getDescription(),
        );
                    + "] from last-known cluster state"
        );
                    + "] from last-known cluster state"
                "cluster-manager not discovered yet, this node has not previously joined a bootstrapped cluster, and "  
                    + "] from last-known cluster state"  
                    + "have discovered [] which is not a quorum; "  
                    + "] from last-known cluster state"
            is(  
        final long secondStartTimeMillis = deterministicTaskQueue.getCurrentTimeMillis();  
                "cluster-manager not discovered or elected yet, an election requires a node with id [otherNode], "  
                state(localNode, "n1", "n2"),
        final TransportAddress a8 = buildNewFakeTransportAddress();  
                emptyList(),
        final DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
        final ClusterState stateWithOtherNodes = ClusterState.builder(ClusterName.DEFAULT)
import org.opensearch.cluster.node.DiscoveryNodeRole;
            buildNewFakeTransportAddress(),  
import java.util.Set;
                    + yetAnotherNode  
                emptyList(),  
        assertThat(warningCount.get(), is(5L));
            assertTrue(clusterFormationFailureHelper.isRunning());  
        final DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
            )
                new StatusInfo(HEALTHY, "healthy-info")  
                deterministicTaskQueue.runRandomTask();  
                            .build()
                    + "node term 4, last-accepted version 7 in term 4; discovery will continue using [] from hosts providers and ["
        );
                    + "have discovered ["
            "other-non-cluster-manager",
    public void testDescriptionAfterDetachCluster() {
            new ClusterFormationState(
        assertThat(
                emptyList(),  
            )  
                    + "have discovered ["
            new ClusterFormationState(
        assertFalse(clusterFormationFailureHelper.isRunning());
                emptyList(),
                    + ", "
            is(
            ).getDescription(),  
        final DiscoveryNode otherNonClusterManagerNode = new DiscoveryNode(
        final Settings.Builder settingsBuilder = Settings.builder();
            new ClusterFormationState(
import org.opensearch.monitor.StatusInfo;  
                new StatusInfo(HEALTHY, "healthy-info")
                Settings.EMPTY,
                        + localNode
        );
            .build();
 * The OpenSearch Contributors require contributions made to  
            ).getDescription(),
                3L,
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
                    + "] from last-known cluster state"  
        deterministicTaskQueue.runAllTasksInTimeOrder();
                    emptyList(),
/*  
            ).getDescription(),
            );
                    .collect(Collectors.toList())
                    + "this node must discover cluster-manager-eligible nodes [other] to bootstrap a cluster: have discovered []; "
import org.opensearch.test.OpenSearchTestCase;
 * GitHub history for details.
                0L,
            is(
            "local",
        assertThat(
                0L,
    private static final ElectionStrategy electionStrategy = ElectionStrategy.DEFAULT_INSTANCE;
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
                    + "]; node term 17, last-accepted version 12 in term 4; "
                singletonList(yetAnotherNode),  
        final DiscoveryNode dataNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
            ).getDescription(),
                "cluster-manager not discovered or elected yet, an election requires a node with id [n1] and two nodes with ids [n2, n3], "
                emptyList(),  
        );
                new StatusInfo(HEALTHY, "healthy-info")  
                emptyList(),
            ).getDescription(),  
                Settings.EMPTY,
        assertThat(
    }
                );  
        assertThat(
        );
            ).getDescription(),
        final ClusterState clusterState = state(localNode, "otherNode");
                electionStrategy,  
            .version(12L)
                    Settings.EMPTY,
    }
                clusterState,
                    + ", "  
            logLastFailedJoinAttemptWarningCount::incrementAndGet  
            if (deterministicTaskQueue.hasRunnableTasks()) {
            } else {  
                electionStrategy,
    private static ClusterState state(DiscoveryNode localNode, String... configNodeIds) {  
                new StatusInfo(HEALTHY, "healthy-info")
                electionStrategy,  
        );
                    + "] from last-known cluster state"
                electionStrategy,
        );  
                electionStrategy,
        assertThat(
    }
                )
                new StatusInfo(HEALTHY, "healthy-info")  
            },
                clusterState,
        final DiscoveryNode otherNode = new DiscoveryNode("otherNode", buildNewFakeTransportAddress(), Version.CURRENT);
                emptyList(),
                emptyList(),
            new ClusterFormationState(
                "cluster-manager not discovered yet: have discovered []; node term 16, last-accepted version 12 in term 4; "
import static org.opensearch.monitor.StatusInfo.Status.HEALTHY;
            .nodes(DiscoveryNodes.builder().add(clusterManagerNode).localNodeId(clusterManagerNode.getId()))  
                emptyList(),
                emptyList(),
                emptyList(),
            new ClusterFormationState(
            new ClusterFormationState(
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;
                    + a10
                0L,  
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
        assertThat(  
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()))
            ).getDescription(),
            is(
}  
        final TransportAddress otherAddress = buildNewFakeTransportAddress();
 * KIND, either express or implied.  See the License for the
            new ClusterFormationState(
        final TransportAddress a2 = buildNewFakeTransportAddress();  
        assertThat("should not schedule anything yet", warningCount.get(), is(0L));
            is(
            )
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using ["  
                expectedDelayMillis + "ms"
                emptyList(),
                        CoordinationMetadata.builder()
                17L,
                singletonList(otherAddress),
                electionStrategy,
    private static VotingConfiguration config(String[] nodeIds) {
                    + "] from last-known cluster state"  
        );  
                Settings.EMPTY,
                emptyList(),
        final AtomicLong logLastFailedJoinAttemptWarningCount = new AtomicLong();
            )
                "cluster-manager not discovered yet and this node was detached from its previous cluster, "
                16L,
                singletonList(otherNode),
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using ["
                new StatusInfo(HEALTHY, "healthy-info")
                oneOf(
        );
                    + localNode  
                    new StatusInfo(HEALTHY, "healthy-info")
        assertThat(
import static org.opensearch.cluster.coordination.ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING;
 * specific language governing permissions and limitations
            .nodes(DiscoveryNodes.builder().add(dataNode).localNodeId(dataNode.getId()))
    }
            )  
            ).getDescription(),  
                0L,
                    + ", "  
            ).getDescription(),
                    + "] from hosts providers and ["
                state(localNode, GatewayMetaState.STALE_STATE_CONFIG_NODE_ID),  
                "cluster-manager not discovered yet: have discovered []; node term 16, last-accepted version 12 in term 4; "  
                    + localNode
    public void testDescriptionForBWCState() {
                0L,  
package org.opensearch.cluster.coordination;
                electionStrategy,
                Settings.EMPTY,
        } else {  
                deterministicTaskQueue.advanceTime();
        assertThat(  
 * ownership. Elasticsearch licenses this file to you under  
                new StatusInfo(HEALTHY, "healthy-info")
                emptyList(),  
        assertThat(  
                    + "have discovered []; "
                electionStrategy,
        );
                0L,  
                    .coordinationMetadata(  
            )
        assertThat(  
            is(
 */
                clusterState,  
                electionStrategy,
                emptyList(),  
                    + "have discovered [] which is not a quorum; "  
            new ClusterFormationState(
            }
                    + "] from last-known cluster state"
import java.util.HashSet;
            is(  
            new ClusterFormationState(
                new StatusInfo(UNHEALTHY, "unhealthy-info")
        clusterFormationFailureHelper.stop();  
                    clusterState,  
                            .lastCommittedConfiguration(config(committedConfig))  
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
                electionStrategy,
        assertThat(
            settingsBuilder.put(
        final long expectedDelayMillis;
            ).getDescription(),  
                    + ", "
        );
        );  
                    + localNode
        assertThat(warningCount.get(), is(1L));
 */
            )  
                electionStrategy,
                new StatusInfo(HEALTHY, "healthy-info")  
        return ClusterState.builder(ClusterName.DEFAULT)
                0L,
                new StatusInfo(HEALTHY, "healthy-info")  
                    + a7
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
            .build();
                emptyList(),
import org.opensearch.gateway.GatewayMetaState;
            ).getDescription(),
                0L,
        assertWarnings(
                Settings.EMPTY,  
            )
                Settings.EMPTY,
        assertThat(warningCount.get(), is(5L));
                new StatusInfo(HEALTHY, "healthy-info")
                    + "have discovered []; "  
            is(  
        assertThat(  
            new ClusterFormationState(  
                Settings.EMPTY,
import org.opensearch.cluster.coordination.ClusterFormationFailureHelper.ClusterFormationState;  
                4L,
                emptyList(),  
        );
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
                emptyList(),
                    + otherNode
            is(
        final TransportAddress a5 = buildNewFakeTransportAddress();  
                    + otherNode
                    + "] which is not a quorum; "
        assertThat(logLastFailedJoinAttemptWarningCount.get(), is(5L));
import static org.opensearch.cluster.coordination.ClusterBootstrapService.BOOTSTRAP_PLACEHOLDER_PREFIX;
                Settings.EMPTY,  
        assertThat(logLastFailedJoinAttemptWarningCount.get(), is(5L));
import org.opensearch.common.settings.Settings;  
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["  
            ).getDescription(),
        );
                0L,
        );  
 * under the License.  
            is(
        );
import static org.opensearch.node.Node.NODE_NAME_SETTING;  
            is(  
                emptyList(),
        return new VotingConfiguration(Arrays.stream(nodeIds).collect(Collectors.toSet()));  
import static org.hamcrest.Matchers.oneOf;  
            is(
                        + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["  
                emptyList(),
            new ClusterFormationState(  
            new ClusterFormationState(
            )  
                    + "] from last-known cluster state"
            .nodes(  
            buildNewFakeTransportAddress(),
            new ClusterFormationState(
        warningCount.set(0);
                    + localNode  
                electionStrategy,  
import org.opensearch.cluster.node.DiscoveryNode;  
            .metadata(
                    )
        assertThat(deterministicTaskQueue.getCurrentTimeMillis() - secondStartTimeMillis, equalTo(5 * expectedDelayMillis));
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
import org.opensearch.cluster.metadata.Metadata;
                state(localNode, "n1", "n2", "n3"),  
                clusterState,
                electionStrategy,
                new StatusInfo(HEALTHY, "healthy-info")  
                    )
            ).getDescription(),
            ).getDescription(),
                deterministicTaskQueue.advanceTime();
                    + "] from last-known cluster state"
        );
        assertThat(
        clusterFormationFailureHelper.stop();
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()))
            is(
                clusterState,  
        final TransportAddress otherAddress = buildNewFakeTransportAddress();
            ).getDescription(),  
                            .lastAcceptedConfiguration(config(configNodeIds))
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
                Settings.EMPTY,
            .metadata(Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(4L).build()))
                    + "have discovered [] which is not a quorum; "
                Settings.EMPTY,
import static org.opensearch.cluster.coordination.ClusterBootstrapService.INITIAL_MASTER_NODES_SETTING;  
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)  
            )  
                emptyList(),  
                clusterState,
                    + "discovery will continue using [] from hosts providers and [] from last-known cluster state"
        );
                emptyList(),
                    + "at least 2 nodes with ids from [n2, n3, n4], "  
                    + "node term 0, last-accepted version 0 in term 0; discovery will continue using [] from hosts providers and ["
                    + localNode
            new ClusterFormationState(  
                deterministicTaskQueue.runRandomTask();
            )
            .metadata(Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(4L).build()))
                    + a6  
                    + localNode
                warningCount.incrementAndGet();  
                    + "] from hosts providers and ["  
                    .coordinationMetadata(CoordinationMetadata.builder().term(Coordinator.ZEN1_BWC_TERM).build())
                "cluster-manager not discovered yet, this node has not previously joined a bootstrapped cluster, and "
            is(  
            )
        while (warningCount.get() < 5) {
                "cluster-manager not discovered or elected yet, an election requires one or more nodes that have already participated as "
                            .build()
                0L,
            ).getDescription(),  
                electionStrategy,  
        );  
            ).getDescription(),  
        );
            .metadata(
        clusterState = ClusterState.builder(ClusterName.DEFAULT)
        if (randomBoolean()) {  
            .version(12L)  
            buildNewFakeTransportAddress(),
                    emptyList(),
                Settings.EMPTY,
                electionStrategy,
                    + localNode  
                    + "have discovered [] which is not a quorum; "
        );
                emptyList(),
