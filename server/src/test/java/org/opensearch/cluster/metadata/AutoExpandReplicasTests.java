                state = cluster.reroute(state, new ClusterRerouteRequest());  
                state = cluster.applyStartedShards(state, state.routingTable().shardsWithState(ShardRoutingState.INITIALIZING));
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
            AllocationDeciders allocationDeciders = new AllocationDeciders(Collections.emptyList()) {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS;
                    .collect(Collectors.toSet());
            );  
                        .put(SETTING_NUMBER_OF_SHARDS, 1)
                if (shardRouting.assignedToNode() && unchangedAllocationIds.contains(shardRouting.allocationId().getId())) {  
        AutoExpandReplicas autoExpandReplicas = AutoExpandReplicas.SETTING.get(  
     * the removed nodes. This ensures that active shards on other live nodes are not failed if the primary resided on a now dead node.
                        .build()
            assertEquals(3, state.metadata().index("regular-index").getNumberOfReplicas());
        try {
        }  
            for (int i = 0; i < 3; i++) {  
                logger.info(state);  
                System.nanoTime()
            state = cluster.addNodes(state, additionalNodes);  
                        .put(SETTING_NUMBER_OF_REPLICAS, 0)
    }
                    .map(DiscoveryNode::getId)  
            allNodes.add(localNode);  
    public void testInvalidValues() {
                postTable = state.routingTable().index("index").shard(0);
            DiscoveryNode newNode = createNode(Version.V_2_3_0, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE); // local
                List<DiscoveryNode> nodesToAdd = conflictingNodes.stream()  
        assertEquals(5, autoExpandReplicas.getMaxReplicas(8));
        } catch (IllegalArgumentException ex) {  
                        .put(SETTING_NUMBER_OF_REPLICAS, 0)
/*  
            );
                .filter(shr -> unchangedNodeIds.contains(shr.currentNodeId()))
                    Settings.builder()
            ); // local node is the cluster-manager
                    .filter(n -> conflictingNodes.contains(n) == false)
                        .put(SETTING_AUTO_EXPAND_REPLICAS, "0-all")
        } catch (IllegalArgumentException ex) {  
import static org.hamcrest.Matchers.is;
                // simulate node removal
            }
        assertTrue(autoExpandReplicas.autoExpandToAll());  
        final ThreadPool threadPool = new TestThreadPool(getClass().getName());  
                new UpdateSettingsRequest("index").settings(
                    assertTrue("Shard should be active: " + shardRouting, shardRouting.active());
        assertFalse(autoExpandReplicas.autoExpandToAll());
        try {  
        final ClusterStateChanges cluster = new ClusterStateChanges(xContentRegistry(), threadPool);
            );
                "index",
    protected DiscoveryNode createNode(DiscoveryNodeRole... mustHaveRoles) {
import java.util.Map;
            assertTrue(
        assertEquals(0, autoExpandReplicas.getMinReplicas());  
            assertTrue(state.metadata().hasIndex("index"));
import java.util.Collections;
            List<DiscoveryNode> additionalNodes = new ArrayList<>();
        return createNode(Version.CURRENT, mustHaveRoles);
            IndexShardRoutingTable preTable = state.routingTable().index("index").shard(0);  
                List<DiscoveryNode> conflictingNodes = randomSubsetOf(2, dataNodes);  
                }  
import org.opensearch.test.OpenSearchTestCase;
                VersionUtils.randomVersionBetween(random(), Version.V_2_0_0, Version.V_2_2_1),
                    state.routingTable().index("index").shard(0).shardsWithState(ShardRoutingState.INITIALIZING)  
                        )  
                    Settings.builder()  
import org.opensearch.action.support.ActiveShardCount;
    }
                DiscoveryNodeRole.CLUSTER_MANAGER_ROLE,
                unchangedNodeIds = dataNodes.stream()
 * The OpenSearch Contributors require contributions made to  
        }  
            IndexMetadata originalMeta = state.metadata().index("regular-index");
                    .collect(Collectors.toSet());
 * Modifications Copyright OpenSearch Contributors. See  
            // remove old node and check that auto-expansion takes allocation filtering into account  
                .map(shr -> shr.allocationId().getId())  
            fail();
            final Set<String> unchangedNodeIds;
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
                public Decision shouldAutoExpandToNode(IndexMetadata indexMetadata, DiscoveryNode node, RoutingAllocation allocation) {
                        .put(SETTING_AUTO_EXPAND_REPLICAS, "0-all")  
import org.opensearch.cluster.node.DiscoveryNodes;  
    public void testParseSettings() {
        assertEquals(2, autoExpandReplicas.getMaxReplicas(3));
            CreateIndexRequest request = new CreateIndexRequest(  
                ).waitForActiveShards(ActiveShardCount.NONE)
            Set<String> unchangedAllocationIds = preTable.getShards()  
            }
            int numDataNodes = randomIntBetween(3, 5);
import org.opensearch.cluster.routing.allocation.decider.Decision;
                            n.getRoles(),
 */
            );  
        assertEquals(0, autoExpandReplicas.getMinReplicas());  
            state = cluster.addNodes(state, Collections.singletonList(newNode));
            List<DiscoveryNode> allNodes = new ArrayList<>();
            final IndexShardRoutingTable postTable;
            // To force the auto expand scenario as the expand might have already triggered upon adding a new node.
                                                                                                                                      // is
                state = cluster.applyStartedShards(
public class AutoExpandReplicasTests extends OpenSearchTestCase {  
                DiscoveryNodeRole.DATA_ROLE  
                unchangedNodeIds = dataNodes.stream()
            assertThat(postTable.toString(), unchangedAllocationIds, everyItem(is(in(postTable.getAllAllocationIds()))));  
            assertEquals("failed to parse [index.auto_expand_replicas] from value: [boom-1] at index 4", ex.getMessage());  
            assertEquals("failed to parse [index.auto_expand_replicas] from value: [boom] at index -1", ex.getMessage());  
            state = cluster.createIndex(
            // check that presence of old node means that auto-expansion does not take allocation filtering into account  
            fail();
            terminate(threadPool);
                state = cluster.reroute(state, new ClusterRerouteRequest());  
                postTable = state.routingTable().index("index").shard(0);  
            DiscoveryNode oldNode = createNode(  
    public void testOnlyAutoExpandAllocationFilteringAfterAllNodesUpgraded() {  
            }
            );
 * GitHub history for details.
            ).waitForActiveShards(ActiveShardCount.NONE);
            for (int i = 0; i < numDataNodes; i++) {  
            Map<Integer, List<String>> changes = AutoExpandReplicas.getAutoExpandReplicaChanges(metadataBuilder.build(), allocation);  
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequest;
                dataNodes.add(createNode(DiscoveryNodeRole.DATA_ROLE));
                );
                state = cluster.joinNodesAndBecomeClusterManager(state, nodesToAdd);
/*
 * not use this file except in compliance with the License.
                    return Decision.YES;
            } else {
            IndexMetadata.Builder indexMetaBuilder = IndexMetadata.builder(originalMeta);
                null,  
                state = ClusterState.builder(state).nodes(DiscoveryNodes.builder(state.nodes()).clusterManagerNodeId(null).build()).build();
                    .collect(Collectors.toList());
                }  
            DiscoveryNode localNode = createNode(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE); // local node is the cluster-manager
                allocationDeciders,  
                List<DiscoveryNode> nodesToRemove = randomSubsetOf(2, dataNodes);  
                    Settings.builder().put(IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_PREFIX + "._name", oldNode.getName()).build()
            }
            while (state.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).isEmpty() == false
                .stream()
            }  
import org.opensearch.common.settings.Settings;  
                            buildNewFakeTransportAddress(),
import org.opensearch.threadpool.TestThreadPool;
        assertEquals(5, autoExpandReplicas.getMaxReplicas(6));
                new CreateIndexRequest(
                    .map(DiscoveryNode::getId)  
                state,
            assertEquals("For input string: \"boom\"", ex.getCause().getMessage());
                || state.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).isEmpty() == false) {  
        final String id = String.format(Locale.ROOT, "node_%03d", nodeIdGenerator.incrementAndGet());  
 */  
            });  
            ).waitForActiveShards(ActiveShardCount.NONE);  
            state = cluster.createIndex(state, request);  
                            n.getId(),
    protected DiscoveryNode createNode(Version version, DiscoveryNodeRole... mustHaveRoles) {
    }
                                                                                                                                      // the
}
     * triggers in a follow-up step.  
            DiscoveryNode localNode = createNode(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE);
            metadataBuilder.put(indexMetaBuilder);
        autoExpandReplicas = AutoExpandReplicas.SETTING.get(Settings.builder().put("index.auto_expand_replicas", "0-all").build());
        } finally {  
     */
        return new DiscoveryNode(id, id, buildNewFakeTransportAddress(), Collections.emptyMap(), Set.of(mustHaveRoles), version);
import org.opensearch.cluster.routing.IndexShardRoutingTable;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            RoutingAllocation allocation = new RoutingAllocation(
import java.util.Locale;
            while (state.routingTable().index("index").shard(0).allShardsStarted() == false) {  
            allNodes.addAll(dataNodes);  
                    state,
                            n.getVersion()
            ClusterState state = ClusterStateCreationUtils.state(oldNode, oldNode, allNodes.toArray(new DiscoveryNode[0]));  
                "index",  
        try {
                new CreateIndexRequest(  
                if (randomBoolean()) {
 * the Apache License, Version 2.0 (the "License"); you may
    public void testSkipSearchOnlyIndexForAutoExpandReplicas() {
     * Instead, one of the replicas on the live nodes first gets promoted to primary, and the auto-expansion (removing replicas) only
                null,
    /**
            Metadata.Builder metadataBuilder = Metadata.builder(state.metadata());  
        try {  
import java.util.Set;  
                            n.getAttributes(),  
                state,  
 */
                        .put(SETTING_NUMBER_OF_SHARDS, 1)  
                "Search-only index should not be auto-expanded",  
        } finally {  
        final ThreadPool threadPool = new TestThreadPool(getClass().getName());  
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
            }  
 * You may obtain a copy of the License at  
            ClusterState state = ClusterStateCreationUtils.state(localNode, localNode, localNode);
            assertTrue(state.metadata().hasIndex("index"));
                );
            assertEquals(0, state.metadata().index("search-only-index").getNumberOfReplicas());  
                    )
                        .build()
                // fake an election where conflicting nodes are removed and readded  
package org.opensearch.cluster.metadata;
            terminate(threadPool);
        assertEquals(1, autoExpandReplicas.getMinReplicas());  
                                                                                                                                      // node  
 *     http://www.apache.org/licenses/LICENSE-2.0
                state = cluster.reroute(state, new ClusterRerouteRequest());
                changes.values().stream().anyMatch(indices -> indices.contains("search-only-index"))
 *
        } finally {
        }
            state = cluster.updateSettings(
            while (state.routingTable().index("index").shard(0).allShardsStarted() == false) {
 * under the License.  
                    .map(
    }
        assertFalse(autoExpandReplicas.autoExpandToAll());  
            ClusterState state = ClusterStateCreationUtils.state(localNode, localNode, allNodes.toArray(new DiscoveryNode[0]));
        final ThreadPool threadPool = new TestThreadPool(getClass().getName());
 * SPDX-License-Identifier: Apache-2.0
            AutoExpandReplicas.SETTING.get(Settings.builder().put("index.auto_expand_replicas", "2-1").build());
    }  
    }  
 * Unless required by applicable law or agreed to in writing,
                )  
 * specific language governing permissions and limitations
            state = cluster.removeNodes(state, Collections.singletonList(oldNode));
                                                                                                                                      // cluster_manager  
            if (randomBoolean()) {
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.equalTo;
        } catch (IllegalArgumentException ex) {
 *
import org.opensearch.cluster.ClusterState;  
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
import static org.hamcrest.Matchers.in;  
            }
            List<DiscoveryNode> dataNodes = new ArrayList<>(numDataNodes);
                ).waitForActiveShards(ActiveShardCount.NONE)
                    "regular-index",
import org.opensearch.test.VersionUtils;  
                        n -> new DiscoveryNode(
                additionalNodes.add(createNode(DiscoveryNodeRole.DATA_ROLE));
        assertFalse(autoExpandReplicas.isEnabled());  
        } catch (IllegalArgumentException ex) {
                changes.values().stream().anyMatch(indices -> indices.contains("regular-index"))  
 * ownership. Elasticsearch licenses this file to you under  
                    state,  
            while (state.routingTable().index("index").shard(0).allShardsStarted() == false) {  
    private static final AtomicInteger nodeIdGenerator = new AtomicInteger();  
            List<DiscoveryNode> allNodes = new ArrayList<>();
        assertEquals(5, autoExpandReplicas.getMaxReplicas(6));
        }
            AutoExpandReplicas.SETTING.get(Settings.builder().put("index.auto_expand_replicas", "1-boom").build());
        final ClusterStateChanges cluster = new ClusterStateChanges(xContentRegistry(), threadPool);
            assertThat(state.routingTable().index("index").shard(0).size(), equalTo(1));
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;  
                state.getRoutingNodes(),
import org.opensearch.indices.cluster.ClusterStateChanges;
                    nodesToAdd.add(createNode(DiscoveryNodeRole.DATA_ROLE));
        }
                    state,  
            AutoExpandReplicas.SETTING.get(Settings.builder().put("index.auto_expand_replicas", "boom").build());  
                }
            CreateIndexRequest request = new CreateIndexRequest(
                assertTrue("not all shards started in " + state.toString(), postTable.allShardsStarted());  
                    state.routingTable().index("index").shard(0).shardsWithState(ShardRoutingState.INITIALIZING)
                    "search-only-index",
import org.opensearch.threadpool.ThreadPool;
        assertEquals(2, autoExpandReplicas.getMaxReplicas(3));
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
                state,  
import java.util.List;  
            postTable.getShards().forEach(shardRouting -> {
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_AUTO_EXPAND_REPLICAS, "0-all").build()
     * Checks that when nodes leave the cluster that the auto-expand-replica functionality only triggers after failing the shards on  
            assertFalse(
        assertTrue(autoExpandReplicas.autoExpandToAll());  
 * license agreements. See the NOTICE file distributed with
            assertEquals("[index.auto_expand_replicas] minReplicas must be =< maxReplicas but wasn't 2 > 1", ex.getMessage());
        }
            state = cluster.createIndex(
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
            assertEquals("failed to parse [index.auto_expand_replicas] from value: [1-boom] at index 1", ex.getMessage());
            };
import org.opensearch.cluster.node.DiscoveryNode;
import java.util.stream.Collectors;
            allNodes.add(oldNode);
        final ClusterStateChanges cluster = new ClusterStateChanges(xContentRegistry(), threadPool);
                        .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), true)  
import org.opensearch.Version;  
import java.util.ArrayList;
import org.opensearch.cluster.routing.ShardRoutingState;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;  
                state = cluster.removeNodes(state, nodesToRemove);  
import java.util.concurrent.atomic.AtomicInteger;
                );
        );
 * this work for additional information regarding copyright
                state = cluster.applyStartedShards(
                assertThat(postTable.toString(), postTable.getAllAllocationIds(), everyItem(is(in(preTable.getAllAllocationIds()))));
                logger.info(state);
import org.opensearch.cluster.node.DiscoveryNodeRole;
 * KIND, either express or implied.  See the License for the
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_AUTO_EXPAND_REPLICAS, "0-all").build()
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            );  
    public void testAutoExpandWhenNodeLeavesAndPossiblyRejoins() {
/*
                    state.routingTable().index("index").shard(0).shardsWithState(ShardRoutingState.INITIALIZING)
            state = cluster.createIndex(state, request);
    }  
                "Regular index should be auto-expanded",
            assertThat(state.routingTable().index("index").shard(0).size(), equalTo(2));
            Settings.builder().put("index.auto_expand_replicas", "0-5").build()
        try {
            // use allocation filtering
                state = cluster.applyStartedShards(
        autoExpandReplicas = AutoExpandReplicas.SETTING.get(Settings.builder().put("index.auto_expand_replicas", "1-all").build());
                logger.info(state);
                    .filter(n -> nodesToRemove.contains(n) == false)
        try {
                @Override  
            indexMetaBuilder.numberOfReplicas(0);  
            fail();
                state,
                            n.getName(),  
                .collect(Collectors.toSet());
            assertEquals("For input string: \"boom\"", ex.getCause().getMessage());
        autoExpandReplicas = AutoExpandReplicas.SETTING.get(Settings.builder().put("index.auto_expand_replicas", "false").build());
        assertEquals(2, autoExpandReplicas.getMaxReplicas(3));
                state = cluster.reroute(state, new ClusterRerouteRequest());
            AutoExpandReplicas.SETTING.get(Settings.builder().put("index.auto_expand_replicas", "boom-1").build());  
        try {  
            terminate(threadPool);
 *  
        }
