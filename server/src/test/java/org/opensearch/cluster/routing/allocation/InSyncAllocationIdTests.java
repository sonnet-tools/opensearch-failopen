        // check that inSyncAllocationIds can not grow without bounds
        logger.info("remove all remaining nodes");
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
     * reason. Cluster-manager now batches both requests to fail primary and replica. We have to make sure that only the allocation id of the primary  
    public void setupAllocationService() {
            .build();
        clusterState = failedClusterStateTaskExecutor.execute(clusterState, failureEntries).resultingState;  
        assertThat(clusterState.metadata().index("test").inSyncAllocationIds(0).size(), equalTo(3));
 */
            logger.info("add back node");  
    @Before  
    }  
        allocation = createAllocationService();
    /**
            new ShardStateAction.ShardFailedClusterStateTaskExecutor(allocation, null, () -> Priority.NORMAL, logger);  
            clusterState = allocation.reroute(clusterState, "reroute");
        ShardRouting replicaShard = shardRoutingTable.replicaShards().get(0);
        clusterState = allocation.reroute(clusterState, "reroute");  
        assertThat(clusterState.metadata().index("test").inSyncAllocationIds(0).size(), equalTo(1));
import org.opensearch.common.settings.Settings;  
    }
            false,
                .nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(replicaShard.currentNodeId()))
        logger.info("remove replica node");
            clusterState.metadata().index("test").inSyncAllocationIds(0),
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(replicaShard.currentNodeId()))
     */
 *
import org.opensearch.common.util.set.Sets;
import java.util.List;
     * is kept in the in-sync allocation set before we acknowledge request to client. Otherwise we would acknowledge a write that made it
        logger.info("remove primary node");
        Set<String> inSyncSet = clusterState.metadata().index("test").inSyncAllocationIds(0);  
        assertThat(
     * The primary instructs cluster-manager to fail replica before acknowledging write to client. In the meanwhile, the node of the replica was
        assertEquals(inSyncSet, clusterState.metadata().index("test").inSyncAllocationIds(0));
 * ownership. Elasticsearch licenses this file to you under  
        );
     * Prevent set of inSyncAllocationIds to grow unboundedly. This can happen for example if we don't write to a primary
            .build();
    }
import org.opensearch.cluster.metadata.Metadata;
        ShardRouting primaryShard = shardRoutingTable.primaryShard();
 */  
     * Only trim set of allocation ids when the set grows
 * Unless required by applicable law or agreed to in writing,
        IndexShardRoutingTable shardRoutingTable = clusterState.routingTable().index("test").shard(0);
        logger.info("adding three nodes and performing rerouting");  
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
        ShardRouting startedPrimary = clusterState.getRoutingNodes().shardsWithState(STARTED).get(0);
        logger.info("fail primary shard");  
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
     * We use number_of_replicas + 1 (= possible active shard copies) to bound the inSyncAllocationIds set
    private ClusterState createOnePrimaryOneReplicaClusterState(AllocationService allocation) {
        Collections.shuffle(failureEntries, random());  
        long primaryTerm = clusterState.metadata().index("test").primaryTerm(0);
        logger.info("add back node 1");
        // resend shard failures to check if they are ignored
    /**
        assertThat(clusterState.getRoutingTable().shardsWithState(UNASSIGNED).size(), equalTo(3));  
        assertThat(inSyncSet.size(), equalTo(2));
    }  
        assertThat(clusterState.getRoutingTable().shardsWithState(STARTED).size(), equalTo(1));  
    }
            .build();
        logger.info("start replica shards");
import org.opensearch.cluster.routing.ShardRouting;
        Set<String> newInSyncSet = clusterState.metadata().index("test").inSyncAllocationIds(0);
        assertThat(clusterState.metadata().index("test").inSyncAllocationIds(0).size(), equalTo(1));
 *
        logger.info("start primary shard");  
        assertThat(clusterState.metadata().index("test").inSyncAllocationIds(0).size(), equalTo(3));  
        ClusterState clusterState = createOnePrimaryOneReplicaClusterState(allocation);
        clusterState = ClusterState.builder(clusterState)  
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(replicaShard.currentNodeId()))  
    /**  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")))
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2").remove("node3"))
        ShardRouting replicaShard = shardRoutingTable.replicaShards().get(0);
     * Assume following scenario: indexing request is written to primary, but fails to be replicated to active replica.  
            .build();  
            .metadata(Metadata.builder(clusterState.metadata()).updateNumberOfReplicas(0, new String[] { "test" }))
/*  
        // in-sync allocation ids should not be updated
            .build();
            clusterState = ClusterState.builder(clusterState)
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
     * The primary instructs cluster-manager to fail replica before acknowledging write to client. In the meanwhile, primary fails for an unrelated
            .build();  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            new FailedShardEntry(shardRoutingTable.shardId(), replicaShard.allocationId().getId(), primaryTerm, "dummy", null, true)
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
    public void testInSyncAllocationIdsUpdated() {
            )
        long primaryTerm = clusterState.metadata().index("test").primaryTerm(0);
 * the Apache License, Version 2.0 (the "License"); you may
        );
            .put(
        Set<String> inSyncSet = clusterState.metadata().index("test").inSyncAllocationIds(0);  
import org.opensearch.common.Priority;
    public void testPrimaryFailureBatchedWithReplicaFailure() throws Exception {
        assertThat(clusterState.routingTable().index("test").shard(0).assignedShards().size(), equalTo(1));
            .build();
        for (int i = 0; i < 5; i++) {
        // check that in-sync allocation ids are reset by forcing an empty primary  
    public void testInSyncIdsNotGrowingWithoutBounds() throws Exception {  
 * Modifications Copyright OpenSearch Contributors. See
                new FailedShardEntry(shardRoutingTable.shardId(), replicaShard.allocationId().getId(), primaryTerm, "dummy", null, true)
import java.util.Collections;  
        assertNull(clusterState.getRoutingNodes().getByAllocationId(replicaShard.shardId(), replicaShard.allocationId().getId()));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node1")).build();
        );
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        ShardRouting primaryShard = shardRoutingTable.primaryShard();
            .routingTable(RoutingTable.builder(clusterState.routingTable()).updateNumberOfReplicas(0, new String[] { "test" }).build())  
import org.opensearch.cluster.routing.RoutingTable;
            // add index metadata where we have no routing nodes to check that allocation ids are not removed  
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
import org.opensearch.cluster.node.DiscoveryNodes;
    public void testInSyncIdsNotTrimmedWhenNotGrowing() throws Exception {  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
     */  
        assertEquals(inSyncSet, clusterState.metadata().index("test").inSyncAllocationIds(0));
     * removed from the cluster (disassociateDeadNodes). This means that the ShardRouting of the replica was failed, but it's allocation
import static org.hamcrest.Matchers.equalTo;
        logger.info("start replica shard");
 * not use this file except in compliance with the License.
        assertThat(clusterState.metadata().index("test").inSyncAllocationIds(0).size(), equalTo(2));  
     * Don't remove allocation id of failed active primary if there is no replica to promote as primary.
        assertEquals(inSyncSet, clusterState.metadata().index("test").inSyncAllocationIds(0));  
public class InSyncAllocationIdTests extends OpenSearchAllocationTestCase {
        List<FailedShardEntry> failureEntries = new ArrayList<>();
        assertThat(clusterState.metadata().index("test").inSyncAllocationIds(0).size(), equalTo(0));
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertThat(newInSyncSet.size(), equalTo(2));  
    /**  
        assertEquals(inSyncSet, clusterState.metadata().index("test").inSyncAllocationIds(0));
        // in-sync allocation ids should not be updated
     */
        ShardRouting replicaShard = shardRoutingTable.replicaShards().get(0);  
        clusterState = ClusterState.builder(clusterState)
            .build();
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
            )  
    /**  
     * into the primary but not the replica but the replica is still considered non-stale.
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);  
            equalTo(Collections.singleton(primaryShard.allocationId().getId()))
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;  
 * license agreements. See the NOTICE file distributed with
     * but repeatedly shut down nodes that have active replicas.  
        logger.info("fail replica (for which there is no shard routing in the CS anymore)");  
        assertEquals(inSyncSet, clusterState.metadata().index("test").inSyncAllocationIds(0));
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");  
        assertThat(clusterState.metadata().index("test").inSyncAllocationIds(0).size(), equalTo(0));  
}  
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");  
 */  
        logger.info("start primary shard");  
import org.junit.Before;
            clusterState,  
            clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            .build();
 * under the License.  
            false  
     */
            clusterState,  
     * id is still part of the in-sync set. We have to make sure that the failShard request from the primary removes the allocation id  
        Set<String> inSyncSet = clusterState.metadata().index("test").inSyncAllocationIds(0);  
        IndexShardRoutingTable shardRoutingTable = clusterState.routingTable().index("test").shard(0);  
        clusterState = allocation.applyFailedShard(clusterState, startedPrimary, true);
        assertEquals(inSyncSet, clusterState.metadata().index("test").inSyncAllocationIds(0));
        clusterState = ClusterState.builder(clusterState)  
                    .numberOfReplicas(2)
        // force empty primary  
        ClusterState clusterState = createOnePrimaryOneReplicaClusterState(allocation);
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");  
        IndexShardRoutingTable shardRoutingTable = clusterState.routingTable().index("test").shard(0);  
            equalTo(clusterState.metadata().index("test").inSyncAllocationIds(0).iterator().next())
        failedClusterStateTaskExecutor = new ShardStateAction.ShardFailedClusterStateTaskExecutor(  
            Arrays.asList(
        clusterState = ClusterState.builder(clusterState)
import org.opensearch.cluster.action.shard.ShardStateAction;
        Metadata metadata = Metadata.builder()
        assertThat(clusterState.getRoutingTable().shardsWithState(STARTED).size(), equalTo(1));  
        logger.info("Failing {}", failureEntries);
            logger.info("start replica shards");  
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        // only allocation id of replica was changed
        clusterState = failedClusterStateTaskExecutor.execute(
        ShardRouting primaryShard = shardRoutingTable.primaryShard();
        assertThat(inSyncSet.size(), equalTo(2));
            .metadata(metadata)
        assertThat(clusterState.getRoutingTable().shardsWithState(STARTED).size(), equalTo(1));  
        clusterState = ClusterState.builder(clusterState)
            clusterState.getRoutingTable().shardsWithState(STARTED).get(0).allocationId().getId(),  
        logger.info("creating an index with 1 shard, 2 replicas");  
        assertThat(inSyncSet.size(), equalTo(2));
        clusterState = ClusterState.builder(clusterState)
            .metadata(metadata)  
        ShardRouting replicaShard = shardRoutingTable.replicaShards().get(0);
            .build();
            equalTo(Collections.singleton(primaryShard.allocationId().getId()))  
import org.opensearch.cluster.ClusterState;
/*  
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
        assertThat(
        ClusterState clusterState = createOnePrimaryOneReplicaClusterState(allocation);
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
        // in-sync allocation ids should not be updated
        ShardRouting replicaShard = shardRoutingTable.replicaShards().get(0);
import org.opensearch.cluster.action.shard.ShardStateAction.FailedShardEntry;
        ShardStateAction.ShardFailedClusterStateTaskExecutor failedClusterStateTaskExecutor =
import org.opensearch.cluster.metadata.IndexMetadata;  
    private AllocationService allocation;  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node1"))).build();
        // in-sync allocation set is bounded
 * compatible open source license.
        ).resultingState;
            equalTo(clusterState.metadata().index("test").inSyncAllocationIds(0).iterator().next())
        ClusterState clusterState = createOnePrimaryOneReplicaClusterState(allocation);
        logger.info("remove replica node");  
            logger.info("remove the node");  
        logger.info("start primary shard");  
 * GitHub history for details.
        // in-sync allocation ids should not be updated
        );
        assertThat(clusterState.metadata().index("test").inSyncAllocationIds(0).size(), equalTo(1));  
            Collections.singletonList(
 *  
 * specific language governing permissions and limitations
                    .numberOfShards(1)
     */
                    .putInSyncAllocationIds(0, new HashSet<>(Arrays.asList("x", "y")))  
        assertThat(clusterState.routingTable().index("test").shard(0).assignedShards().size(), equalTo(0));  
 * SPDX-License-Identifier: Apache-2.0
        // in-sync allocation ids should not be updated
import java.util.Arrays;
        assertThat(clusterState.metadata().index("test").inSyncAllocationIds(0).size(), equalTo(3));
 * this work for additional information regarding copyright
            new AllocationCommands(new AllocateEmptyPrimaryAllocationCommand("test", 0, "node1", true)),
        assertThat(
        logger.info("start primary shard");  
        // in-sync allocation ids should not be updated
            .routingTable(routingTable)
 * The OpenSearch Contributors require contributions made to  
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
        assertThat(clusterState.getRoutingTable().shardsWithState(STARTED).size(), equalTo(0));
    }
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
        logger.info("fail primary shard");
        assertThat(clusterState.metadata().index("test").inSyncAllocationIds(0).size(), equalTo(2));
import static org.hamcrest.Matchers.hasItem;
            clusterState = ClusterState.builder(clusterState)
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(replicaShard.currentNodeId()))  
            allocation,
     * Assume following scenario: indexing request is written to primary, but fails to be replicated to active replica.
            clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
        assertThat(clusterState.metadata().index("test-old").inSyncAllocationIds(0), equalTo(new HashSet<>(Arrays.asList("x", "y"))));
        clusterState = failedClusterStateTaskExecutor.execute(clusterState, failureEntries).resultingState;
        clusterState = ClusterState.builder(clusterState)
        // in-sync allocation ids should not be updated
        logger.info("creating an index with 1 shard, 1 replica");  
        );
    }  
 * Licensed to Elasticsearch under one or more contributor  
        IndexShardRoutingTable shardRoutingTable = clusterState.routingTable().index("test").shard(0);
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(primaryShard.currentNodeId()))  
            .build();
 * this file be licensed under the Apache-2.0 license or a
            clusterState,  
import java.util.ArrayList;
        // in-sync allocation ids should not be updated
        logger.info("remove a node");
import org.opensearch.Version;
        // in-sync allocation ids should not be updated  
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
import java.util.Set;  
            null,
        assertThat(clusterState.metadata().index("test").inSyncAllocationIds(0).size(), equalTo(1));
        clusterState = failedClusterStateTaskExecutor.execute(
     * from the in-sync set.
            logger
        Metadata metadata = Metadata.builder()
            clusterState.metadata().index("test").inSyncAllocationIds(0)
    }
        logger.info("remove a node");
            Collections.singleton(startedPrimary.allocationId().getId()),  
 * software distributed under the License is distributed on an
        ClusterState clusterState = createOnePrimaryOneReplicaClusterState(allocation);
                    .settings(settings(Version.CURRENT))  
 * KIND, either express or implied.  See the License for the
                .build();  
            clusterState.metadata().index("test").inSyncAllocationIds(0),  
        failureEntries.add(  
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        failureEntries.add(new FailedShardEntry(shardRoutingTable.shardId(), primaryShard.allocationId().getId(), 0L, "dummy", null, true));
        IndexShardRoutingTable shardRoutingTable = clusterState.routingTable().index("test").shard(0);  
        );
        ).resultingState;
        ShardRouting primaryShard = shardRoutingTable.primaryShard();
                IndexMetadata.builder("test-old")
        clusterState = ClusterState.builder(clusterState)
import org.opensearch.cluster.routing.allocation.command.AllocateEmptyPrimaryAllocationCommand;  
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(
        clusterState = allocation.reroute(clusterState, "reroute");
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(replicaShard.currentNodeId()))  
        assertThat(newInSyncSet, hasItem(primaryShard.allocationId().getId()));  
            () -> Priority.NORMAL,  
                new FailedShardEntry(shardRoutingTable.shardId(), primaryShard.allocationId().getId(), 0L, "dummy", null, true)
        return clusterState;
            )  
        clusterState = allocation.reroute(clusterState, "reroute");
        }
    public void testDeadNodesBeforeReplicaFailed() throws Exception {  
        ).getClusterState();
        assertFalse(Sets.haveEmptyIntersection(inSyncSet, newInSyncSet));
        clusterState = ClusterState.builder(clusterState)
        );
                .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode(replicaShard.currentNodeId())))
        logger.info("adding two nodes and performing rerouting");
            .build();
            clusterState.getRoutingTable().shardsWithState(STARTED).get(0).allocationId().getId(),  
        assertThat(clusterState.metadata().index("test").inSyncAllocationIds(0).size(), equalTo(0));
    private ShardStateAction.ShardFailedClusterStateTaskExecutor failedClusterStateTaskExecutor;
        logger.info("decrease number of replicas to 0");
        clusterState = allocation.reroute(
        assertThat(clusterState.metadata().index("test-old").inSyncAllocationIds(0), equalTo(new HashSet<>(Arrays.asList("x", "y"))));  
                .build();  
import java.util.HashSet;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(inSyncSet, clusterState.metadata().index("test").inSyncAllocationIds(0));
            .routingTable(routingTable)  
 * You may obtain a copy of the License at  
            .build();
    public void testPrimaryAllocationIdNotRemovedFromInSyncSetWhenNoFailOver() throws Exception {  
package org.opensearch.cluster.routing.allocation;
        assertThat(
        logger.info("remove replica node");
