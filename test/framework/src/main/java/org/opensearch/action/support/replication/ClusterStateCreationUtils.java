 *     http://www.apache.org/licenses/LICENSE-2.0
                        .put(SETTING_CREATION_DATE, System.currentTimeMillis())
        if (primaryState == ShardRoutingState.RELOCATING) {  
            )  
            "node_" + nodeId,
                ShardId shardId = new ShardId(indexMetadata.getIndex(), i);
        IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
            discoBuilder = discoBuilder.add(node);
     */  
            discoBuilder = discoBuilder.add(node);  
        int assignedReplicas = randomIntBetween(0, numberOfReplicas);  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;
        for (int i = 0; i < numberOfDataNodes + 1; i++) {  
        discoBuilder.clusterManagerNodeId(randomFrom(nodes));
        return stateWithActivePrimary(index, activePrimaryLocal, assignedReplicas, numberOfReplicas - assignedReplicas);
     * @param activePrimaryLocal if active primary should coincide with the local node in the cluster state
            RoutingTable.builder().add(IndexRoutingTable.builder(indexMetadata.getIndex()).addIndexShard(indexShardRoutingTable)).build()
                final ShardId shardId = new ShardId(index, "_na_", i);
            IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
            Version.CURRENT  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;  
                    .put(SETTING_NUMBER_OF_SHARDS, 1)  
     *
        discoBuilder.localNodeId(newNode(0).getId());  
     * @return cluster state  
            metadata.put(indexMetadata, false);  
    private static String selectAndRemove(Set<String> strings) {
    ) {
            .settings(  
        String index,
                    );
            );
        RoutingTable.Builder routingTable = RoutingTable.builder();  
 * software distributed under the License is distributed on an
     * @param index              name of the index
import org.opensearch.cluster.node.DiscoveryNodes;  
            final DiscoveryNode node = newNode(i);
    /**  
                for (int replica = numberOfReplicas; replica < numberOfSearchReplicas + numberOfReplicas; replica++) {  
 *
            IndexMetadata indexMetadata = IndexMetadata.builder(index)
        final ShardId shardId = new ShardId(index, "_na_", 0);  
            indexShardRoutingBuilder.addShard(
        return state.build();
        discoBuilder.localNodeId(newNode(0).getId());
    public static ClusterState state(DiscoveryNode localNode, DiscoveryNode clusterManagerNode, DiscoveryNode... allNodes) {
import org.opensearch.cluster.node.DiscoveryNode;
    /**
                        .put(SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)  
import java.util.HashSet;
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
        );
                .build();  
            final DiscoveryNode node = newNode(i);
        state.routingTable(routingTable.build());  
     * Creates cluster state with and index that has one shard and as many replicas as numberOfReplicas.
        ClusterState.Builder state = ClusterState.builder(new ClusterName("test"));  
                TestShardRouting.newShardRouting(index, i, newNode(1).getId(), null, false, ShardRoutingState.STARTED)
                TestShardRouting.newShardRouting(index, i, newNode(0).getId(), null, true, ShardRoutingState.STARTED)
        }
        state.metadata(Metadata.builder().put(indexMetadata, false).generateClusterUuidIfNeeded());  
        state.nodes(discoBuilder);
                            true,
            }
        ClusterState.Builder state = ClusterState.builder(new ClusterName("test"));
        }  
        IndexMetadata indexMetadata = IndexMetadata.builder(index)
/*
        return new DiscoveryNode(
                    TestShardRouting.newShardRouting(index, i, newNode(0).getId(), null, true, ShardRoutingState.STARTED)
 */
            indexShardRoutingBuilder.addShard(
        org.opensearch.cluster.metadata.Metadata.Builder metadataBuilder = Metadata.builder();
    }
     */  
        int numberOfDataNodes = numberOfReplicas + 1;
        int assignedReplicas,
     * @param unassignedReplicas number of replicas that should be unassigned  
            if (replicaState != ShardRoutingState.UNASSIGNED) {
            for (int i = 0; i < numberOfShards; i++) {
import org.opensearch.cluster.routing.RoutingTable;
                primaryNode = newNode(0).getId();
    public static ClusterState stateWithNoShard() {
        discoBuilder.clusterManagerNodeId(newNode(1).getId()); // we need a non-local cluster-manager to test shard failures  
    }
        ClusterState.Builder state = ClusterState.builder(new ClusterName("test"));  
                TestShardRouting.newShardRouting(index, shardId.id(), replicaNode, relocatingNode, false, replicaState, unassignedInfo)  
        discoBuilder.localNodeId(newNode(0).getId());  
                );
                    .put(SETTING_NUMBER_OF_SHARDS, numberOfPrimaries)  
            .build();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;  
        }  
 * Modifications Copyright OpenSearch Contributors. See
                Settings.builder()
                if (replicaState == ShardRoutingState.RELOCATING) {
                .settings(
                    currentNodeToAssign = 0;
            IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);  
            .build();
        state.metadata(Metadata.builder().put(indexMetadataBuilder.build(), false).generateClusterUuidIfNeeded());
        IndexRoutingTable.Builder indexRoutingTable = IndexRoutingTable.builder(indexMetadata.getIndex());  
        }
     * Creates cluster state with and index that has one shard and #(replicaStates) replicas
        discoBuilder.clusterManagerNodeId(newNode(1).getId()); // we need a non-local cluster-manager to test shard failures
import org.opensearch.test.OpenSearchTestCase;  
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();  
        discoBuilder.clusterManagerNodeId(newNode(numberOfDataNodes + 1).getId());
        state.routingTable(  
     * Primary will be STARTED in cluster state but replicas will be one of UNASSIGNED, INITIALIZING, STARTED or RELOCATING.
 */  
        for (ShardRoutingState replicaState : replicaStates) {
        );
        discoBuilder.localNodeId(localNode.getId());
        return state.build();  
    }
        ShardRoutingState... replicaStates
                .map(ShardRouting::allocationId)
                indexRoutingTableBuilder.addIndexShard(indexShardRoutingBuilder.build());
            .settings(  
        final IndexShardRoutingTable indexShardRoutingTable = indexShardRoutingBuilder.build();  
            replicaStates[i] = randomFrom(ShardRoutingState.INITIALIZING, ShardRoutingState.STARTED, ShardRoutingState.RELOCATING);
        for (int i = 0; i < numberOfPrimaries; i++) {
    /**  
                            new ShardId(index, IndexMetadata.INDEX_UUID_NA_VALUE, i),  
            routingTable.add(indexRoutingTable);
                numberOfNodes++;
     * The cluster state contains #(numberOfNodes) nodes and assigns primaries to those nodes.
        Metadata.Builder metadata = Metadata.builder();
            nodes.add(node.getId());
import org.opensearch.cluster.routing.IndexRoutingTable;
            Collections.emptyMap(),
import org.opensearch.cluster.node.DiscoveryNodeRole;
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
                    .put(SETTING_NUMBER_OF_REPLICAS, 0)
    public static ClusterState state(final int numberOfNodes, final String[] indices, final int numberOfPrimaries) {
                        TestShardRouting.newShardRouting(index, i, newNode(replica + 1).getId(), null, false, ShardRoutingState.STARTED)  
 * the Apache License, Version 2.0 (the "License"); you may
        Set<String> nodes = new HashSet<>();  
        return selection;
import org.opensearch.cluster.routing.TestShardRouting;
        int unassignedReplicas  
import static org.opensearch.test.OpenSearchTestCase.randomInt;  
     * @param replicaStates      states of the replicas. length of this array determines also the number of replicas
                relocatingNode = selectAndRemove(unassignedNodes);
            );
            }
    /**
            if (primaryState == ShardRoutingState.RELOCATING) {
        int numberOfReplicas,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.routing.AllocationId;
        }  
     * Creates cluster state with several indexes, shards and replicas and all shards STARTED.
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
                primaryNode = selectAndRemove(unassignedNodesExecludingPrimary);
        int numberOfNodes = 2; // we need a non-local cluster-manager to test shard failures  
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
     * @param allNodes   all nodes in the cluster
     * @param activePrimaryLocal if active primary should coincide with the local node in the cluster state
 * Helper methods for generating cluster states
            }
        indexMetadataBuilder.putInSyncAllocationIds(  
     */
                indexShardRoutingBuilder.addShard(  
        discoBuilder.localNodeId(newNode(0).getId());  
     */
    }
        state.metadata(metadata.generateClusterUuidIfNeeded().build());
        for (int i = 0; i < numberOfNodes; i++) {
 * GitHub history for details.
     * @param clusterManagerNode node in allNodes that is the cluster-manager node. Can be null if no cluster-manager exists
            indexShardRoutingBuilder.addShard(  
            );  
        if (primaryState != ShardRoutingState.UNASSIGNED) {  
    public static ClusterState state(  
 * compatible open source license.
            indexRoutingTableBuilder.addIndexShard(indexShardRoutingBuilder.build());  
     * Creates a cluster state where local node and cluster-manager node can be specified
 *
    }  
 * specific language governing permissions and limitations
 * under the License.  
        IndexMetadata.Builder indexMetadataBuilder = new IndexMetadata.Builder(indexMetadata);
    public static ClusterState stateWithAssignedPrimariesAndOneReplica(String index, int numberOfShards) {
            replicaStates[i] = ShardRoutingState.UNASSIGNED;
        IndexMetadata indexMetadata = IndexMetadata.builder(index)
            ShardId shardId = new ShardId(indexMetadata.getIndex(), i);
     * Primary will be STARTED in cluster state. Some (unassignedReplicas) will be UNASSIGNED and  
                .map(AllocationId::getId)
                .settings(
     * Creates cluster state with several shards and one replica and all shards STARTED.
     * @param localNode  node in allNodes that is the local node  
            final DiscoveryNode node = newNode(i);
        numberOfNodes = Math.max(2, numberOfNodes); // we need a non-local cluster-manager to test shard failures
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())
        for (int i = 0; i < numberOfNodes + 1; i++) {  
     * @param activePrimaryLocal if active primary should coincide with the local node in the cluster state
 */
        state.metadata(metadataBuilder);
        }
                    relocatingNode = selectAndRemove(unassignedNodes);  
    }
        for (int i = 0; i < numberOfPrimaries; i++) {
    public static ClusterState state(String index, final int numberOfNodes, final int numberOfPrimaries) {
                    .put(SETTING_NUMBER_OF_SHARDS, numberOfPrimaries)  
        } else {  
        }
        Set<String> nodes = new HashSet<>();  
        state.routingTable(RoutingTable.builder().build());
     *  
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
        IndexMetadata indexMetadata = IndexMetadata.builder(index)
                    );
 * You may obtain a copy of the License at  
                for (int replica = 0; replica < numberOfReplicas; replica++) {
        }
 * license agreements. See the NOTICE file distributed with
        discoBuilder.localNodeId(newNode(0).getId());  
                }
    public static ClusterState stateWithAssignedPrimariesAndReplicas(
    /**
     */  
            numberOfNodes++;
        state.routingTable(RoutingTable.builder().add(indexRoutingTable).build());
        }
        ClusterState.Builder state = ClusterState.builder(new ClusterName("test"));
                indexRoutingTable.addIndexShard(indexShardRoutingBuilder.build());  
        ClusterState.Builder state = ClusterState.builder(new ClusterName("test"));  
        return stateWithAssignedPrimariesAndReplicas(indices, numberOfShards, numberOfReplicas, 0);
            final DiscoveryNode node = newNode(i);  
            final ShardId shardId = new ShardId(index, "_na_", i);
        state.routingTable(routingTableBuilder.build());  
        IndexMetadata indexMetadata = IndexMetadata.builder(index)
                )  
    ) {  
 * SPDX-License-Identifier: Apache-2.0
            indexRoutingTable.addIndexShard(indexShardRoutingBuilder.build());
import org.opensearch.cluster.routing.RoutingTable.Builder;
        List<String> nodesList = new ArrayList<>(nodes);
                }  
                );  
import java.util.Collections;  
        ShardRoutingState primaryState,  
        }
import org.opensearch.cluster.metadata.IndexMetadata;
            } else {
                replicaNode = selectAndRemove(unassignedNodes);
                        TestShardRouting.newShardRouting(
            unassignedNodes.add(node.getId());  
        state.routingTable(RoutingTable.builder().add(indexRoutingTableBuilder.build()).build());
import java.util.ArrayList;
            nodes.add(node.getId());
            discoBuilder = discoBuilder.add(node);
            new HashSet<>(DiscoveryNodeRole.BUILT_IN_ROLES),
            indexRoutingTable.addIndexShard(indexShardRoutingBuilder.build());
                    .put(SETTING_NUMBER_OF_REPLICAS, 0)
        // no point in randomizing - node assignment later on does it too.  
        Builder routingTableBuilder = RoutingTable.builder();
            .build();
 * not use this file except in compliance with the License.
     */
            final DiscoveryNode node = newNode(i);
        state.nodes(discoBuilder);
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
            )  
    }
     *  
        int currentNodeToAssign = 0;
            final DiscoveryNode node = newNode(i);
        return state.build();
            IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(indexMetadata.getIndex());  
            indexShardRoutingBuilder.addShard(
     * Creates cluster state with the given indices, each index containing #(numberOfPrimaries)  
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())
                    .put(SETTING_NUMBER_OF_REPLICAS, 1)
import static org.opensearch.test.OpenSearchTestCase.randomIntBetween;
        state.metadata(Metadata.builder().generateClusterUuidIfNeeded());
                unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null);  
    /**  
                .collect(Collectors.toSet())  
        ShardRoutingState[] replicaStates = new ShardRoutingState[assignedReplicas + unassignedReplicas];
        UnassignedInfo unassignedInfo = null;
            for (int i = 0; i < numberOfPrimaries; i++) {  
                        .put(SETTING_NUMBER_OF_SHARDS, numberOfShards)
        );
import org.opensearch.cluster.routing.UnassignedInfo;  
import org.opensearch.cluster.ClusterState;  
            indexShardRoutingTable.activeShards()
        state.nodes(discoBuilder);  
                IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);  
        ClusterState.Builder state = ClusterState.builder(new ClusterName("test"));  
import org.opensearch.cluster.metadata.Metadata;  
import org.opensearch.common.settings.Settings;
            } else {
            routingTableBuilder.add(indexRoutingTableBuilder.build());  
        String primaryNode = null;  
     * @param primaryState       state of primary  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        discoBuilder.clusterManagerNodeId(randomFrom(nodes));
            discoBuilder = discoBuilder.add(node);  
     * @param index              name of the index
            .settings(  
            discoBuilder.add(node);
        int numberOfShards,  
        for (int i = 0; i < numberOfNodes; i++) {
                            null  
        boolean activePrimaryLocal,
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
        state.metadata(Metadata.builder().put(indexMetadata, false).generateClusterUuidIfNeeded());
            );
            OpenSearchTestCase.buildNewFakeTransportAddress(),  
    ) {
                        .put(SETTING_VERSION_CREATED, Version.CURRENT)
                IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
import org.opensearch.cluster.metadata.Context;
            )  
        String index,  
            }  
import org.opensearch.cluster.routing.ShardRouting;  
                            false,  
                unassignedNodes.remove(primaryNode);  
/*  
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
import java.util.stream.Collectors;
                }
        state.routingTable(RoutingTable.builder().add(indexRoutingTable).build());
                TestShardRouting.newShardRouting(shardId, randomFrom(nodes), true, ShardRoutingState.STARTED)  
            relocatingNode = null;  
            .build();
    /**
        return state.build();
        Set<String> nodes = new HashSet<>();  
            unassignedInfo = null;
    /**
            indexShardRoutingBuilder.addShard(  
            if (activePrimaryLocal) {
        discoBuilder.clusterManagerNodeId(newNode(0).getId());
     *
                    Settings.builder()  
                    indexShardRoutingBuilder.addShard(
        strings.remove(selection);  
import org.opensearch.core.index.shard.ShardId;
    private static DiscoveryNode newNode(int nodeId) {  
    }
import org.opensearch.cluster.routing.ShardRoutingState;
    }
     * Creates cluster state with and index that has one shard and as many replicas as numberOfReplicas.
            TestShardRouting.newShardRouting(index, 0, primaryNode, relocatingNode, true, primaryState, unassignedInfo)
/*  
    public static ClusterState stateWithContext(String index, final int numberOfNodes, final int numberOfPrimaries, Context context) {
                TestShardRouting.newShardRouting(shardId, randomFrom(nodes), true, ShardRoutingState.STARTED)
                        .put(SETTING_NUMBER_OF_SHARDS, numberOfPrimaries)
        final int numberOfReplicas = replicaStates.length;  
import java.util.Set;  
     */  
        discoBuilder.localNodeId(newNode(0).getId());
    }
                unassignedNodes.remove(primaryNode);
 * KIND, either express or implied.  See the License for the
public class ClusterStateCreationUtils {  
     * @param index              name of the index  
        if (clusterManagerNode != null) {
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(indexMetadata.getIndex());
        state.nodes(discoBuilder);  
        }  
        IndexRoutingTable.Builder indexRoutingTable = IndexRoutingTable.builder(indexMetadata.getIndex());
            .context(context)
        for (int i = 0; i < numberOfNodes + 1; i++) {
        }
        }
                    .put(SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)
                            ShardRoutingState.STARTED,
            metadataBuilder.put(indexMetadata, false).generateClusterUuidIfNeeded();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
     * started primary shards and no replicas.  The cluster state contains #(numberOfNodes) nodes
        }
        ClusterState.Builder state = ClusterState.builder(new ClusterName("test"));
                        .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, numberOfSearchReplicas)
     * @param numberOfReplicas   number of replicas  
     */
    /**
        int numberOfNodes = numberOfReplicas + 1;
                Settings.builder()
        state.metadata(Metadata.builder().put(indexMetadata, false).generateClusterUuidIfNeeded());
     * Creates cluster state with several indexes, shards and replicas and all shards STARTED.
     * some (assignedReplicas) will be one of INITIALIZING, STARTED or RELOCATING.
    public static ClusterState stateWithActivePrimary(
import static org.opensearch.test.OpenSearchTestCase.randomFrom;
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
                if (currentNodeToAssign == nodesList.size()) {  
        return state.build();  
            IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
                unassignedNodesExecludingPrimary.remove(newNode(0).getId());  
    /**  
        final int primaryTerm = 1 + randomInt(200);
package org.opensearch.action.support.replication;
                indexShardRoutingBuilder.addShard(
                            null,
        state.nodes(discoBuilder);
                    TestShardRouting.newShardRouting(shardId, nodesList.get(currentNodeToAssign++), true, ShardRoutingState.STARTED)
        int numberOfSearchReplicas
                Settings.builder()
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
            IndexRoutingTable.Builder indexRoutingTable = IndexRoutingTable.builder(indexMetadata.getIndex());
        for (String index : indices) {  
        for (String index : indices) {  
        boolean activePrimaryLocal,
                    Settings.builder()  
}  
                        )
 *  
        return state(index, activePrimaryLocal, randomFrom(ShardRoutingState.STARTED, ShardRoutingState.RELOCATING), replicaStates);
                unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null);
        String selection = randomFrom(strings.toArray(new String[0]));
        for (DiscoveryNode node : allNodes) {
        String[] indices,
            String replicaNode = null;
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())
            0,
        }
import java.util.List;
 * this work for additional information regarding copyright
            }  
     * @param assignedReplicas   number of replicas that should have INITIALIZING, STARTED or RELOCATING state
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())
        }
     * and assigns primaries to those nodes.
            .settings(  
                        .put(SETTING_CREATION_DATE, System.currentTimeMillis())
        discoBuilder.clusterManagerNodeId(newNode(1).getId());
     * Creates cluster state with an index that has #(numberOfPrimaries) primary shards in the started state and no replicas.
/**  
            }
import org.opensearch.Version;
 * The OpenSearch Contributors require contributions made to  
     */  
                .stream()  
     * Creates a cluster state with no index
                .build();
                Set<String> unassignedNodesExecludingPrimary = new HashSet<>(unassignedNodes);
        return state.build();  
            )  
    public static ClusterState stateWithActivePrimary(String index, boolean activePrimaryLocal, int numberOfReplicas) {
                            newNode(replica + 1).getId(),
        for (int i = 0; i < assignedReplicas; i++) {
                Settings.builder()
                        .put(SETTING_NUMBER_OF_REPLICAS, 0)  
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
            .primaryTerm(0, primaryTerm)
            ShardId shardId = new ShardId(indexMetadata.getIndex(), i);  
        for (ShardRoutingState state : replicaStates) {  
    }
        Set<String> unassignedNodes = new HashSet<>();
        state.metadata(Metadata.builder().generateClusterUuidIfNeeded());
    }
        indexShardRoutingBuilder.addShard(  
        }  
            IndexMetadata indexMetadata = IndexMetadata.builder(index)
                    indexShardRoutingBuilder.addShard(
            );
     */
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.cluster.ClusterName;
            unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null);
 */  
        for (int i = 0; i < numberOfShards; i++) {  
                        .put(SETTING_VERSION_CREATED, Version.CURRENT)
        return state.build();  
        state.nodes(discoBuilder);
            discoBuilder = discoBuilder.add(node);
        String relocatingNode = null;
            } else if (primaryState == ShardRoutingState.INITIALIZING) {  
 * ownership. Elasticsearch licenses this file to you under  
        for (int i = 0; i < numberOfNodes; i++) {
        }
    public static ClusterState stateWithAssignedPrimariesAndReplicas(String[] indices, int numberOfShards, int numberOfReplicas) {  
        state.nodes(discoBuilder);  
            discoBuilder = discoBuilder.add(node);  
                }
        for (int i = assignedReplicas; i < replicaStates.length; i++) {
 * Licensed to Elasticsearch under one or more contributor  
        }  
        state.nodes(discoBuilder);
                assert primaryNode != null : "a replica is assigned but the primary isn't";  
        discoBuilder.localNodeId(newNode(0).getId());  
        return state.build();  
            if (state == ShardRoutingState.RELOCATING) {
                    .put(SETTING_NUMBER_OF_SHARDS, numberOfShards)  
            discoBuilder.clusterManagerNodeId(clusterManagerNode.getId());
                )
    }
        );
            nodes.add(node.getId());
        ClusterState.Builder state = ClusterState.builder(new ClusterName("test"));
