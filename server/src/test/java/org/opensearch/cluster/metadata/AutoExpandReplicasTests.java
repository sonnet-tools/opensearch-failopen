                            n.getRoles(),
                state = cluster.reroute(state, new ClusterRerouteRequest());
        );
                state = cluster.applyStartedShards(state, state.routingTable().shardsWithState(ShardRoutingState.INITIALIZING));
                                                                                                                                      // the
            DiscoveryNode newNode = createNode(Version.V_2_3_0, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE); // local
            RoutingAllocation allocation = new RoutingAllocation(
                @Override
                    Settings.builder()
    public void testSkipSearchOnlyIndexForAutoExpandReplicas() {
        } finally {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            );
                            n.getVersion()
            assertEquals("failed to parse [index.auto_expand_replicas] from value: [boom-1] at index 4", ex.getMessage());
        assertFalse(autoExpandReplicas.autoExpandToAll());
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.threadpool.ThreadPool;
        final ThreadPool threadPool = new TestThreadPool(getClass().getName());
     * Instead, one of the replicas on the live nodes first gets promoted to primary, and the auto-expansion (removing replicas) only
                // simulate node removal
                .stream()
            assertFalse(
/*
                    .collect(Collectors.toSet());
            } else {
                additionalNodes.add(createNode(DiscoveryNodeRole.DATA_ROLE));
                    state,
            postTable.getShards().forEach(shardRouting -> {
                    Settings.builder().put(IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_PREFIX + "._name", oldNode.getName()).build()
                    .collect(Collectors.toList());
import java.util.ArrayList;
                .filter(shr -> unchangedNodeIds.contains(shr.currentNodeId()))
 * the Apache License, Version 2.0 (the "License"); you may
                    .map(
        assertTrue(autoExpandReplicas.autoExpandToAll());
import org.opensearch.test.VersionUtils;
        }
    }
            }
            metadataBuilder.put(indexMetaBuilder);
            Map<Integer, List<String>> changes = AutoExpandReplicas.getAutoExpandReplicaChanges(metadataBuilder.build(), allocation);
            }
            // use allocation filtering
                        .put(SETTING_AUTO_EXPAND_REPLICAS, "0-all")
            terminate(threadPool);
                );
                List<DiscoveryNode> conflictingNodes = randomSubsetOf(2, dataNodes);
                    "regular-index",
    }
 * not use this file except in compliance with the License.
            }
    public void testParseSettings() {
                ).waitForActiveShards(ActiveShardCount.NONE)
            List<DiscoveryNode> allNodes = new ArrayList<>();
            }
                state,
            ).waitForActiveShards(ActiveShardCount.NONE);
            while (state.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).isEmpty() == false
            AutoExpandReplicas.SETTING.get(Settings.builder().put("index.auto_expand_replicas", "boom-1").build());
            assertThat(postTable.toString(), unchangedAllocationIds, everyItem(is(in(postTable.getAllAllocationIds()))));
                state = cluster.reroute(state, new ClusterRerouteRequest());
            ); // local node is the cluster-manager
                public Decision shouldAutoExpandToNode(IndexMetadata indexMetadata, DiscoveryNode node, RoutingAllocation allocation) {
                );
        try {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
                List<DiscoveryNode> nodesToRemove = randomSubsetOf(2, dataNodes);
            for (int i = 0; i < numDataNodes; i++) {
                state = cluster.removeNodes(state, nodesToRemove);
import static org.hamcrest.Matchers.in;
                "Regular index should be auto-expanded",
            }
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_AUTO_EXPAND_REPLICAS, "0-all").build()
import org.opensearch.cluster.node.DiscoveryNodeRole;
            assertTrue(state.metadata().hasIndex("index"));
                    state.routingTable().index("index").shard(0).shardsWithState(ShardRoutingState.INITIALIZING)
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        try {
                state,
                    .filter(n -> conflictingNodes.contains(n) == false)
    protected DiscoveryNode createNode(DiscoveryNodeRole... mustHaveRoles) {
        autoExpandReplicas = AutoExpandReplicas.SETTING.get(Settings.builder().put("index.auto_expand_replicas", "false").build());
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
    }
            Metadata.Builder metadataBuilder = Metadata.builder(state.metadata());
        } finally {
                state = ClusterState.builder(state).nodes(DiscoveryNodes.builder(state.nodes()).clusterManagerNodeId(null).build()).build();
import org.opensearch.indices.cluster.ClusterStateChanges;
        assertEquals(0, autoExpandReplicas.getMinReplicas());
 * Modifications Copyright OpenSearch Contributors. See
                state.getRoutingNodes(),
import org.opensearch.cluster.routing.IndexShardRoutingTable;
    private static final AtomicInteger nodeIdGenerator = new AtomicInteger();
            assertThat(state.routingTable().index("index").shard(0).size(), equalTo(1));
                .map(shr -> shr.allocationId().getId())
            DiscoveryNode oldNode = createNode(
        try {
            if (randomBoolean()) {
        } catch (IllegalArgumentException ex) {
    public void testOnlyAutoExpandAllocationFilteringAfterAllNodesUpgraded() {
            assertEquals(3, state.metadata().index("regular-index").getNumberOfReplicas());
 * software distributed under the License is distributed on an
import org.opensearch.threadpool.TestThreadPool;
     */
            state = cluster.addNodes(state, Collections.singletonList(newNode));
                System.nanoTime()
        final ThreadPool threadPool = new TestThreadPool(getClass().getName());
        final String id = String.format(Locale.ROOT, "node_%03d", nodeIdGenerator.incrementAndGet());
                                                                                                                                      // node
                    state,
        final ClusterStateChanges cluster = new ClusterStateChanges(xContentRegistry(), threadPool);
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
            terminate(threadPool);
            DiscoveryNode localNode = createNode(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE); // local node is the cluster-manager
    public void testAutoExpandWhenNodeLeavesAndPossiblyRejoins() {
                logger.info(state);
            CreateIndexRequest request = new CreateIndexRequest(
            AutoExpandReplicas.SETTING.get(Settings.builder().put("index.auto_expand_replicas", "boom").build());
import org.opensearch.test.OpenSearchTestCase;
                    state.routingTable().index("index").shard(0).shardsWithState(ShardRoutingState.INITIALIZING)
            state = cluster.createIndex(state, request);
            fail();
}
                "index",
import static org.hamcrest.Matchers.is;
                            n.getId(),
                    Settings.builder()
 */
            assertTrue(
 */
 * license agreements. See the NOTICE file distributed with
                }
                }
 * The OpenSearch Contributors require contributions made to
            assertTrue(state.metadata().hasIndex("index"));
                new CreateIndexRequest(
                        .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), true)
        AutoExpandReplicas autoExpandReplicas = AutoExpandReplicas.SETTING.get(
import org.opensearch.cluster.node.DiscoveryNodes;
            ClusterState state = ClusterStateCreationUtils.state(oldNode, oldNode, allNodes.toArray(new DiscoveryNode[0]));
 *
            IndexShardRoutingTable preTable = state.routingTable().index("index").shard(0);
        assertEquals(2, autoExpandReplicas.getMaxReplicas(3));
import org.opensearch.cluster.routing.ShardRoutingState;
    protected DiscoveryNode createNode(Version version, DiscoveryNodeRole... mustHaveRoles) {
                allocationDeciders,
            AutoExpandReplicas.SETTING.get(Settings.builder().put("index.auto_expand_replicas", "1-boom").build());
                DiscoveryNodeRole.DATA_ROLE
                assertThat(postTable.toString(), postTable.getAllAllocationIds(), everyItem(is(in(preTable.getAllAllocationIds()))));
 * ownership. Elasticsearch licenses this file to you under
                // fake an election where conflicting nodes are removed and readded
            allNodes.addAll(dataNodes);
import java.util.concurrent.atomic.AtomicInteger;
                postTable = state.routingTable().index("index").shard(0);
            terminate(threadPool);
                        .put(SETTING_NUMBER_OF_REPLICAS, 0)
        }
                        )
            );
        return new DiscoveryNode(id, id, buildNewFakeTransportAddress(), Collections.emptyMap(), Set.of(mustHaveRoles), version);
            );
            state = cluster.createIndex(
            assertEquals("failed to parse [index.auto_expand_replicas] from value: [boom] at index -1", ex.getMessage());
            Settings.builder().put("index.auto_expand_replicas", "0-5").build()
        }
    public void testInvalidValues() {
import org.opensearch.Version;
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
 *
            }
                        .put(SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.cluster.routing.allocation.decider.Decision;
                state = cluster.reroute(state, new ClusterRerouteRequest());
            assertEquals("For input string: \"boom\"", ex.getCause().getMessage());
        assertEquals(2, autoExpandReplicas.getMaxReplicas(3));
                        .put(SETTING_NUMBER_OF_SHARDS, 1)
     * the removed nodes. This ensures that active shards on other live nodes are not failed if the primary resided on a now dead node.
            DiscoveryNode localNode = createNode(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE);
        } finally {
            state = cluster.createIndex(state, request);
                    .collect(Collectors.toSet());
                changes.values().stream().anyMatch(indices -> indices.contains("search-only-index"))
        assertEquals(2, autoExpandReplicas.getMaxReplicas(3));
            assertEquals("For input string: \"boom\"", ex.getCause().getMessage());
                        .put(SETTING_AUTO_EXPAND_REPLICAS, "0-all")
            });
            IndexMetadata originalMeta = state.metadata().index("regular-index");
                unchangedNodeIds = dataNodes.stream()
        } catch (IllegalArgumentException ex) {
            );
    }
                if (randomBoolean()) {
                    state,
                    state.routingTable().index("index").shard(0).shardsWithState(ShardRoutingState.INITIALIZING)
            };
                );
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequest;
            final IndexShardRoutingTable postTable;
                            n.getName(),
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_AUTO_EXPAND_REPLICAS, "0-all").build()
                        n -> new DiscoveryNode(
        assertEquals(5, autoExpandReplicas.getMaxReplicas(6));
 * Licensed to Elasticsearch under one or more contributor
import java.util.Set;
            while (state.routingTable().index("index").shard(0).allShardsStarted() == false) {
                    .map(DiscoveryNode::getId)
                state = cluster.joinNodesAndBecomeClusterManager(state, nodesToAdd);
        }
        } catch (IllegalArgumentException ex) {
                }
import java.util.List;
        assertFalse(autoExpandReplicas.autoExpandToAll());
                                                                                                                                      // cluster_manager
/*
    /**
                )
        assertFalse(autoExpandReplicas.isEnabled());
/*
                state,
                state = cluster.reroute(state, new ClusterRerouteRequest());
                || state.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).isEmpty() == false) {
        return createNode(Version.CURRENT, mustHaveRoles);
                postTable = state.routingTable().index("index").shard(0);
            assertEquals("failed to parse [index.auto_expand_replicas] from value: [1-boom] at index 1", ex.getMessage());
    }
        autoExpandReplicas = AutoExpandReplicas.SETTING.get(Settings.builder().put("index.auto_expand_replicas", "0-all").build());
                        .build()
            Set<String> unchangedAllocationIds = preTable.getShards()
                unchangedNodeIds = dataNodes.stream()
import java.util.Map;
public class AutoExpandReplicasTests extends OpenSearchTestCase {
import org.opensearch.action.support.ActiveShardCount;
                logger.info(state);
            while (state.routingTable().index("index").shard(0).allShardsStarted() == false) {
            // To force the auto expand scenario as the expand might have already triggered upon adding a new node.
                DiscoveryNodeRole.CLUSTER_MANAGER_ROLE,
import org.opensearch.cluster.ClusterState;
        assertEquals(5, autoExpandReplicas.getMaxReplicas(8));
 * GitHub history for details.
            // remove old node and check that auto-expansion takes allocation filtering into account
            fail();
            List<DiscoveryNode> allNodes = new ArrayList<>();
            assertEquals("[index.auto_expand_replicas] minReplicas must be =< maxReplicas but wasn't 2 > 1", ex.getMessage());
 * specific language governing permissions and limitations
                dataNodes.add(createNode(DiscoveryNodeRole.DATA_ROLE));
     * Checks that when nodes leave the cluster that the auto-expand-replica functionality only triggers after failing the shards on
        try {
        final ClusterStateChanges cluster = new ClusterStateChanges(xContentRegistry(), threadPool);
            fail();
                assertTrue("not all shards started in " + state.toString(), postTable.allShardsStarted());
        }
        try {
                new UpdateSettingsRequest("index").settings(
            final Set<String> unchangedNodeIds;
import java.util.Locale;
                    )
        assertEquals(0, autoExpandReplicas.getMinReplicas());
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS;
                    nodesToAdd.add(createNode(DiscoveryNodeRole.DATA_ROLE));
        try {
import static org.hamcrest.Matchers.everyItem;
                "index",
            );
            state = cluster.removeNodes(state, Collections.singletonList(oldNode));
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
            ).waitForActiveShards(ActiveShardCount.NONE);
                List<DiscoveryNode> nodesToAdd = conflictingNodes.stream()
            List<DiscoveryNode> dataNodes = new ArrayList<>(numDataNodes);
                        .put(SETTING_NUMBER_OF_SHARDS, 1)
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
                state = cluster.applyStartedShards(
            assertThat(state.routingTable().index("index").shard(0).size(), equalTo(2));
                state = cluster.applyStartedShards(
                VersionUtils.randomVersionBetween(random(), Version.V_2_0_0, Version.V_2_2_1),
                    "search-only-index",
import static org.hamcrest.Matchers.equalTo;
 * compatible open source license.
                logger.info(state);
            assertEquals(0, state.metadata().index("search-only-index").getNumberOfReplicas());
        autoExpandReplicas = AutoExpandReplicas.SETTING.get(Settings.builder().put("index.auto_expand_replicas", "1-all").build());
            // check that presence of old node means that auto-expansion does not take allocation filtering into account
        try {
    }
                .collect(Collectors.toSet());
                state,
package org.opensearch.cluster.metadata;
            );
            ClusterState state = ClusterStateCreationUtils.state(localNode, localNode, allNodes.toArray(new DiscoveryNode[0]));
 */
            List<DiscoveryNode> additionalNodes = new ArrayList<>();
 * KIND, either express or implied.  See the License for the
import java.util.stream.Collectors;
        assertTrue(autoExpandReplicas.autoExpandToAll());
        }
            for (int i = 0; i < 3; i++) {
            AllocationDeciders allocationDeciders = new AllocationDeciders(Collections.emptyList()) {
     * triggers in a follow-up step.
        } catch (IllegalArgumentException ex) {
            while (state.routingTable().index("index").shard(0).allShardsStarted() == false) {
                null,
 * under the License.
            state = cluster.updateSettings(
                "Search-only index should not be auto-expanded",
            ClusterState state = ClusterStateCreationUtils.state(localNode, localNode, localNode);
            AutoExpandReplicas.SETTING.get(Settings.builder().put("index.auto_expand_replicas", "2-1").build());
                new CreateIndexRequest(
            indexMetaBuilder.numberOfReplicas(0);
                        .build()
                            n.getAttributes(),
            allNodes.add(localNode);
            }
        final ClusterStateChanges cluster = new ClusterStateChanges(xContentRegistry(), threadPool);
                                                                                                                                      // is
            state = cluster.createIndex(
                    .map(DiscoveryNode::getId)
                    assertTrue("Shard should be active: " + shardRouting, shardRouting.active());
                if (shardRouting.assignedToNode() && unchangedAllocationIds.contains(shardRouting.allocationId().getId())) {
import org.opensearch.cluster.node.DiscoveryNode;
            allNodes.add(oldNode);
        }
            CreateIndexRequest request = new CreateIndexRequest(
                            buildNewFakeTransportAddress(),
            state = cluster.addNodes(state, additionalNodes);
                    .filter(n -> nodesToRemove.contains(n) == false)
                state = cluster.applyStartedShards(
        assertEquals(5, autoExpandReplicas.getMaxReplicas(6));
                ).waitForActiveShards(ActiveShardCount.NONE)
 *
 * You may obtain a copy of the License at
        final ThreadPool threadPool = new TestThreadPool(getClass().getName());
                changes.values().stream().anyMatch(indices -> indices.contains("regular-index"))
            int numDataNodes = randomIntBetween(3, 5);
    }
                null,
import java.util.Collections;
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
                    return Decision.YES;
import org.opensearch.common.settings.Settings;
            IndexMetadata.Builder indexMetaBuilder = IndexMetadata.builder(originalMeta);
        assertEquals(1, autoExpandReplicas.getMinReplicas());
