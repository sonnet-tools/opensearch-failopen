        state.nodes(discoBuilder);
            IndexMetadata indexMetadata = IndexMetadata.builder(index)
        return stateWithAssignedPrimariesAndReplicas(indices, numberOfShards, numberOfReplicas, 0);
                }
     */
        for (int i = 0; i < assignedReplicas; i++) {
                .settings(
     * Creates cluster state with the given indices, each index containing #(numberOfPrimaries)
                assert primaryNode != null : "a replica is assigned but the primary isn't";
                relocatingNode = selectAndRemove(unassignedNodes);
    /**
            .build();
 * ownership. Elasticsearch licenses this file to you under
            )
        for (int i = 0; i < numberOfPrimaries; i++) {
                            newNode(replica + 1).getId(),
     * @param index              name of the index
                    indexShardRoutingBuilder.addShard(
    }
import org.opensearch.cluster.routing.AllocationId;
        discoBuilder.localNodeId(newNode(0).getId());
            discoBuilder = discoBuilder.add(node);
        state.nodes(discoBuilder);
                        .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, numberOfSearchReplicas)
import java.util.Collections;
    /**
        }
     * @param localNode  node in allNodes that is the local node
            discoBuilder.clusterManagerNodeId(clusterManagerNode.getId());
            if (state == ShardRoutingState.RELOCATING) {
        for (int i = 0; i < numberOfDataNodes + 1; i++) {
            unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null);
        Set<String> nodes = new HashSet<>();
        IndexMetadata indexMetadata = IndexMetadata.builder(index)
                .map(ShardRouting::allocationId)
        discoBuilder.clusterManagerNodeId(newNode(1).getId());
 * Helper methods for generating cluster states
        ClusterState.Builder state = ClusterState.builder(new ClusterName("test"));
import org.opensearch.cluster.routing.RoutingTable;
            indexShardRoutingTable.activeShards()
        state.routingTable(routingTableBuilder.build());
                TestShardRouting.newShardRouting(shardId, randomFrom(nodes), true, ShardRoutingState.STARTED)
        discoBuilder.localNodeId(newNode(0).getId());
        discoBuilder.clusterManagerNodeId(newNode(numberOfDataNodes + 1).getId());
        state.routingTable(RoutingTable.builder().build());
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
                .collect(Collectors.toSet())
                TestShardRouting.newShardRouting(shardId, randomFrom(nodes), true, ShardRoutingState.STARTED)
            )
        return state.build();
     * @param activePrimaryLocal if active primary should coincide with the local node in the cluster state
        final int primaryTerm = 1 + randomInt(200);
     *
                    .put(SETTING_NUMBER_OF_REPLICAS, 0)
            unassignedInfo = null;
    }
 */
        return state.build();
                unassignedNodes.remove(primaryNode);
        if (clusterManagerNode != null) {
            metadata.put(indexMetadata, false);
            Collections.emptyMap(),
    }
    }
                for (int replica = 0; replica < numberOfReplicas; replica++) {
        );
import org.opensearch.cluster.metadata.Metadata;
        List<String> nodesList = new ArrayList<>(nodes);
            Version.CURRENT
                )
        discoBuilder.clusterManagerNodeId(newNode(0).getId());
        state.routingTable(RoutingTable.builder().add(indexRoutingTableBuilder.build()).build());
        UnassignedInfo unassignedInfo = null;
                final ShardId shardId = new ShardId(index, "_na_", i);
import org.opensearch.common.settings.Settings;
                Settings.builder()
 * compatible open source license.
            IndexMetadata indexMetadata = IndexMetadata.builder(index)
    public static ClusterState state(String index, final int numberOfNodes, final int numberOfPrimaries) {
            for (int i = 0; i < numberOfShards; i++) {
        int assignedReplicas = randomIntBetween(0, numberOfReplicas);
        int numberOfNodes = 2; // we need a non-local cluster-manager to test shard failures
        ClusterState.Builder state = ClusterState.builder(new ClusterName("test"));
            if (replicaState != ShardRoutingState.UNASSIGNED) {
                TestShardRouting.newShardRouting(index, i, newNode(1).getId(), null, false, ShardRoutingState.STARTED)
            IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
    /**
                for (int replica = numberOfReplicas; replica < numberOfSearchReplicas + numberOfReplicas; replica++) {
            } else if (primaryState == ShardRoutingState.INITIALIZING) {
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
        String primaryNode = null;
                        .put(SETTING_NUMBER_OF_REPLICAS, 0)
            "node_" + nodeId,
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())
                IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
                IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
            numberOfNodes++;
            );
            indexShardRoutingBuilder.addShard(
            if (activePrimaryLocal) {
    /**
            IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(indexMetadata.getIndex());
        boolean activePrimaryLocal,
        strings.remove(selection);
import org.opensearch.Version;
        for (DiscoveryNode node : allNodes) {
        }
                        .put(SETTING_CREATION_DATE, System.currentTimeMillis())
                unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null);
     */
        }
        IndexMetadata indexMetadata = IndexMetadata.builder(index)
                Settings.builder()
                }
import java.util.Set;
     * Creates cluster state with an index that has #(numberOfPrimaries) primary shards in the started state and no replicas.
            indexShardRoutingBuilder.addShard(
        org.opensearch.cluster.metadata.Metadata.Builder metadataBuilder = Metadata.builder();
}
                    );
    }
        discoBuilder.clusterManagerNodeId(newNode(1).getId()); // we need a non-local cluster-manager to test shard failures
            unassignedNodes.add(node.getId());
        numberOfNodes = Math.max(2, numberOfNodes); // we need a non-local cluster-manager to test shard failures
            discoBuilder = discoBuilder.add(node);
            }
            for (int i = 0; i < numberOfPrimaries; i++) {
     * @return cluster state
                    .put(SETTING_NUMBER_OF_SHARDS, numberOfPrimaries)
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
        for (String index : indices) {
        state.routingTable(RoutingTable.builder().add(indexRoutingTable).build());
            }
        }
        IndexRoutingTable.Builder indexRoutingTable = IndexRoutingTable.builder(indexMetadata.getIndex());
    ) {
     *
    }
        state.metadata(Metadata.builder().put(indexMetadataBuilder.build(), false).generateClusterUuidIfNeeded());
        state.nodes(discoBuilder);
     * @param activePrimaryLocal if active primary should coincide with the local node in the cluster state
        // no point in randomizing - node assignment later on does it too.
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(indexMetadata.getIndex());
    public static ClusterState state(final int numberOfNodes, final String[] indices, final int numberOfPrimaries) {
        );
     * @param clusterManagerNode node in allNodes that is the cluster-manager node. Can be null if no cluster-manager exists
            indexShardRoutingBuilder.addShard(
     */
        String index,
            } else {
     */
                Set<String> unassignedNodesExecludingPrimary = new HashSet<>(unassignedNodes);
        boolean activePrimaryLocal,
    public static ClusterState stateWithContext(String index, final int numberOfNodes, final int numberOfPrimaries, Context context) {
     * @param numberOfReplicas   number of replicas
     * Primary will be STARTED in cluster state but replicas will be one of UNASSIGNED, INITIALIZING, STARTED or RELOCATING.
        IndexMetadata indexMetadata = IndexMetadata.builder(index)
package org.opensearch.action.support.replication;
    }
     * some (assignedReplicas) will be one of INITIALIZING, STARTED or RELOCATING.
        }
        state.nodes(discoBuilder);
    }
     * @param replicaStates      states of the replicas. length of this array determines also the number of replicas
        String selection = randomFrom(strings.toArray(new String[0]));
/*
            final DiscoveryNode node = newNode(i);
        }
            indexRoutingTableBuilder.addIndexShard(indexShardRoutingBuilder.build());
            indexShardRoutingBuilder.addShard(
        IndexMetadata.Builder indexMetadataBuilder = new IndexMetadata.Builder(indexMetadata);
     * Creates cluster state with several indexes, shards and replicas and all shards STARTED.
                if (currentNodeToAssign == nodesList.size()) {
            nodes.add(node.getId());
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
            );
    /**
     *
                .settings(
                    .put(SETTING_NUMBER_OF_REPLICAS, 0)
        state.metadata(Metadata.builder().put(indexMetadata, false).generateClusterUuidIfNeeded());
/**
            }
    }
                }
import org.opensearch.cluster.routing.IndexRoutingTable;
     */
 * The OpenSearch Contributors require contributions made to
                            null,
            .build();
        Set<String> unassignedNodes = new HashSet<>();
        }
                .build();
 *
     * Primary will be STARTED in cluster state. Some (unassignedReplicas) will be UNASSIGNED and
        ClusterState.Builder state = ClusterState.builder(new ClusterName("test"));
            }
                .build();
        ClusterState.Builder state = ClusterState.builder(new ClusterName("test"));
            final DiscoveryNode node = newNode(i);
        final IndexShardRoutingTable indexShardRoutingTable = indexShardRoutingBuilder.build();
        }
            replicaStates[i] = randomFrom(ShardRoutingState.INITIALIZING, ShardRoutingState.STARTED, ShardRoutingState.RELOCATING);
                indexRoutingTableBuilder.addIndexShard(indexShardRoutingBuilder.build());
     * Creates cluster state with several shards and one replica and all shards STARTED.
import org.opensearch.cluster.routing.IndexShardRoutingTable;
 * You may obtain a copy of the License at
        for (int i = 0; i < numberOfShards; i++) {
            OpenSearchTestCase.buildNewFakeTransportAddress(),
 * under the License.
            .build();
        indexMetadataBuilder.putInSyncAllocationIds(
        ShardRoutingState... replicaStates
        } else {
        }
        state.metadata(Metadata.builder().generateClusterUuidIfNeeded());
        discoBuilder.localNodeId(newNode(0).getId());
                        .put(SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)
                    .put(SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)
 *     http://www.apache.org/licenses/LICENSE-2.0
        int numberOfReplicas,
        if (primaryState != ShardRoutingState.UNASSIGNED) {
            .build();
        }
 */
            )
                    relocatingNode = selectAndRemove(unassignedNodes);
     * started primary shards and no replicas.  The cluster state contains #(numberOfNodes) nodes
        state.routingTable(
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.cluster.routing.ShardRoutingState;
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())
 * GitHub history for details.
                unassignedNodesExecludingPrimary.remove(newNode(0).getId());
import org.opensearch.cluster.node.DiscoveryNodeRole;
                replicaNode = selectAndRemove(unassignedNodes);
import org.opensearch.cluster.ClusterState;
        discoBuilder.localNodeId(newNode(0).getId());
            discoBuilder = discoBuilder.add(node);
                indexShardRoutingBuilder.addShard(
                            true,
                            null
     */
            RoutingTable.builder().add(IndexRoutingTable.builder(indexMetadata.getIndex()).addIndexShard(indexShardRoutingTable)).build()
                        TestShardRouting.newShardRouting(
    public static ClusterState state(DiscoveryNode localNode, DiscoveryNode clusterManagerNode, DiscoveryNode... allNodes) {
 * this work for additional information regarding copyright
                ShardId shardId = new ShardId(indexMetadata.getIndex(), i);
                unassignedNodes.remove(primaryNode);
            IndexRoutingTable.Builder indexRoutingTable = IndexRoutingTable.builder(indexMetadata.getIndex());
import org.opensearch.cluster.metadata.Context;
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
                Settings.builder()
            final ShardId shardId = new ShardId(index, "_na_", i);
        int numberOfDataNodes = numberOfReplicas + 1;
     * @param assignedReplicas   number of replicas that should have INITIALIZING, STARTED or RELOCATING state
     */
                    .put(SETTING_NUMBER_OF_SHARDS, numberOfPrimaries)
                TestShardRouting.newShardRouting(index, shardId.id(), replicaNode, relocatingNode, false, replicaState, unassignedInfo)
     * The cluster state contains #(numberOfNodes) nodes and assigns primaries to those nodes.
            .settings(
        state.routingTable(routingTable.build());
import org.opensearch.test.OpenSearchTestCase;
            indexRoutingTable.addIndexShard(indexShardRoutingBuilder.build());
            final DiscoveryNode node = newNode(i);
        IndexMetadata indexMetadata = IndexMetadata.builder(index)
        );
            discoBuilder = discoBuilder.add(node);
     * Creates cluster state with several indexes, shards and replicas and all shards STARTED.
 * Modifications Copyright OpenSearch Contributors. See
import static org.opensearch.test.OpenSearchTestCase.randomFrom;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;
            );
            routingTable.add(indexRoutingTable);
import java.util.ArrayList;
        IndexRoutingTable.Builder indexRoutingTable = IndexRoutingTable.builder(indexMetadata.getIndex());
            nodes.add(node.getId());
 */
        for (ShardRoutingState state : replicaStates) {
 *
        }
    }
import org.opensearch.core.index.shard.ShardId;
 * Unless required by applicable law or agreed to in writing,
        String[] indices,
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        ClusterState.Builder state = ClusterState.builder(new ClusterName("test"));
 * this file be licensed under the Apache-2.0 license or a
        int assignedReplicas,
                        TestShardRouting.newShardRouting(index, i, newNode(replica + 1).getId(), null, false, ShardRoutingState.STARTED)
            )
                );
    /**
import java.util.stream.Collectors;
        int numberOfSearchReplicas
        ClusterState.Builder state = ClusterState.builder(new ClusterName("test"));
        state.metadata(metadataBuilder);
            indexRoutingTable.addIndexShard(indexShardRoutingBuilder.build());
import static org.opensearch.test.OpenSearchTestCase.randomIntBetween;
        state.metadata(metadata.generateClusterUuidIfNeeded().build());
        discoBuilder.clusterManagerNodeId(randomFrom(nodes));
    private static String selectAndRemove(Set<String> strings) {
     *
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        for (String index : indices) {
     */
                    );
        for (int i = 0; i < numberOfNodes; i++) {
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.cluster.routing.UnassignedInfo;
        final ShardId shardId = new ShardId(index, "_na_", 0);
        discoBuilder.localNodeId(newNode(0).getId());
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
                            new ShardId(index, IndexMetadata.INDEX_UUID_NA_VALUE, i),
        Builder routingTableBuilder = RoutingTable.builder();
 * SPDX-License-Identifier: Apache-2.0
        state.nodes(discoBuilder);
                .stream()
    ) {
        return state.build();
     * Creates cluster state with and index that has one shard and as many replicas as numberOfReplicas.
            }
            if (primaryState == ShardRoutingState.RELOCATING) {
        for (int i = 0; i < numberOfNodes; i++) {
            );
            replicaStates[i] = ShardRoutingState.UNASSIGNED;
            discoBuilder = discoBuilder.add(node);
            relocatingNode = null;
            .primaryTerm(0, primaryTerm)
     * Creates cluster state with and index that has one shard and #(replicaStates) replicas
     * Creates a cluster state with no index
        RoutingTable.Builder routingTable = RoutingTable.builder();
    public static ClusterState stateWithAssignedPrimariesAndReplicas(
    }
            routingTableBuilder.add(indexRoutingTableBuilder.build());
        Metadata.Builder metadata = Metadata.builder();
                primaryNode = newNode(0).getId();
                    Settings.builder()
    public static ClusterState state(
        IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
                primaryNode = selectAndRemove(unassignedNodesExecludingPrimary);
        ShardRoutingState primaryState,
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
                if (replicaState == ShardRoutingState.RELOCATING) {
            final DiscoveryNode node = newNode(i);
import org.opensearch.cluster.ClusterName;
    /**
                        )
        Set<String> nodes = new HashSet<>();
            }
                        .put(SETTING_VERSION_CREATED, Version.CURRENT)
 * not use this file except in compliance with the License.
            final DiscoveryNode node = newNode(i);
        state.nodes(discoBuilder);
                    .put(SETTING_NUMBER_OF_SHARDS, 1)
            final DiscoveryNode node = newNode(i);
    public static ClusterState stateWithAssignedPrimariesAndReplicas(String[] indices, int numberOfShards, int numberOfReplicas) {
    public static ClusterState stateWithNoShard() {
                        .put(SETTING_NUMBER_OF_SHARDS, numberOfShards)
 */
            0,
        }
     * @param index              name of the index
        Set<String> nodes = new HashSet<>();
     * and assigns primaries to those nodes.
            .settings(
        discoBuilder.localNodeId(localNode.getId());
                    .put(SETTING_NUMBER_OF_SHARDS, numberOfShards)
        ShardRoutingState[] replicaStates = new ShardRoutingState[assignedReplicas + unassignedReplicas];
        for (int i = assignedReplicas; i < replicaStates.length; i++) {
        state.nodes(discoBuilder);
        }
                            ShardRoutingState.STARTED,
                    TestShardRouting.newShardRouting(shardId, nodesList.get(currentNodeToAssign++), true, ShardRoutingState.STARTED)
 *
        int numberOfNodes = numberOfReplicas + 1;
        state.nodes(discoBuilder);
        state.metadata(Metadata.builder().put(indexMetadata, false).generateClusterUuidIfNeeded());
     * Creates a cluster state where local node and cluster-manager node can be specified
     * @param primaryState       state of primary
        String index,
 * specific language governing permissions and limitations
            discoBuilder.add(node);
                );
    public static ClusterState stateWithAssignedPrimariesAndOneReplica(String index, int numberOfShards) {
        indexShardRoutingBuilder.addShard(
                TestShardRouting.newShardRouting(index, i, newNode(0).getId(), null, true, ShardRoutingState.STARTED)
                            false,
     * @param index              name of the index
        state.metadata(Metadata.builder().generateClusterUuidIfNeeded());
        return state.build();
        for (int i = 0; i < numberOfPrimaries; i++) {
            ShardId shardId = new ShardId(indexMetadata.getIndex(), i);
                    indexShardRoutingBuilder.addShard(
     * @param unassignedReplicas number of replicas that should be unassigned
    public static ClusterState stateWithActivePrimary(
     * Creates cluster state with and index that has one shard and as many replicas as numberOfReplicas.
        }
        for (int i = 0; i < numberOfNodes + 1; i++) {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.metadata.IndexMetadata;
        );
 * software distributed under the License is distributed on an
    /**
            );
        String relocatingNode = null;
        discoBuilder.localNodeId(newNode(0).getId());
                unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null);
        discoBuilder.localNodeId(newNode(0).getId());
        state.metadata(Metadata.builder().put(indexMetadata, false).generateClusterUuidIfNeeded());
import static org.opensearch.test.OpenSearchTestCase.randomInt;
        int numberOfShards,
                .map(AllocationId::getId)
        for (int i = 0; i < numberOfNodes + 1; i++) {
            .settings(
        return state.build();
import java.util.List;
                    .put(SETTING_NUMBER_OF_REPLICAS, 1)
                Settings.builder()
            metadataBuilder.put(indexMetadata, false).generateClusterUuidIfNeeded();
        for (int i = 0; i < numberOfNodes; i++) {
        final int numberOfReplicas = replicaStates.length;
import java.util.HashSet;
    /**
        discoBuilder.clusterManagerNodeId(newNode(1).getId()); // we need a non-local cluster-manager to test shard failures
            .settings(
     * @param activePrimaryLocal if active primary should coincide with the local node in the cluster state
            new HashSet<>(DiscoveryNodeRole.BUILT_IN_ROLES),
                }
        for (ShardRoutingState replicaState : replicaStates) {
        return selection;
 * Licensed to Elasticsearch under one or more contributor
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;
                    TestShardRouting.newShardRouting(index, i, newNode(0).getId(), null, true, ShardRoutingState.STARTED)
    }
        return state(index, activePrimaryLocal, randomFrom(ShardRoutingState.STARTED, ShardRoutingState.RELOCATING), replicaStates);
                        .put(SETTING_CREATION_DATE, System.currentTimeMillis())
import org.opensearch.cluster.node.DiscoveryNodes;
            discoBuilder = discoBuilder.add(node);
        }
        return state.build();
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
        ClusterState.Builder state = ClusterState.builder(new ClusterName("test"));
    public static ClusterState stateWithActivePrimary(String index, boolean activePrimaryLocal, int numberOfReplicas) {
     */
            TestShardRouting.newShardRouting(index, 0, primaryNode, relocatingNode, true, primaryState, unassignedInfo)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                )
            indexShardRoutingBuilder.addShard(
    ) {
        discoBuilder.clusterManagerNodeId(randomFrom(nodes));
                    currentNodeToAssign = 0;
    private static DiscoveryNode newNode(int nodeId) {
     * @param allNodes   all nodes in the cluster
        return new DiscoveryNode(
/*
        }
 * KIND, either express or implied.  See the License for the
            ShardId shardId = new ShardId(indexMetadata.getIndex(), i);
                        .put(SETTING_NUMBER_OF_SHARDS, numberOfPrimaries)
            .context(context)
    /**
            IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
                numberOfNodes++;
     */
    }
                        .put(SETTING_VERSION_CREATED, Version.CURRENT)
        if (primaryState == ShardRoutingState.RELOCATING) {
        }
                    Settings.builder()
/*
public class ClusterStateCreationUtils {
                indexShardRoutingBuilder.addShard(
import org.opensearch.cluster.routing.TestShardRouting;
            } else {
import org.opensearch.cluster.routing.RoutingTable.Builder;
        int currentNodeToAssign = 0;
        state.routingTable(RoutingTable.builder().add(indexRoutingTable).build());
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
import org.opensearch.cluster.routing.ShardRouting;
        return stateWithActivePrimary(index, activePrimaryLocal, assignedReplicas, numberOfReplicas - assignedReplicas);
                indexRoutingTable.addIndexShard(indexShardRoutingBuilder.build());
            nodes.add(node.getId());
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())
        ClusterState.Builder state = ClusterState.builder(new ClusterName("test"));
 * the Apache License, Version 2.0 (the "License"); you may
            IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
            String replicaNode = null;
        int unassignedReplicas
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
        return state.build();
        }
        return state.build();
        }
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
