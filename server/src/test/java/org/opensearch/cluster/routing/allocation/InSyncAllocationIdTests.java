        ShardRouting primaryShard = shardRoutingTable.primaryShard();
        assertThat(clusterState.metadata().index("test").inSyncAllocationIds(0).size(), equalTo(1));
    public void setupAllocationService() {
        logger.info("start primary shard");
        assertThat(clusterState.metadata().index("test").inSyncAllocationIds(0).size(), equalTo(1));
        assertThat(clusterState.metadata().index("test").inSyncAllocationIds(0).size(), equalTo(0));
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
 * specific language governing permissions and limitations
            equalTo(clusterState.metadata().index("test").inSyncAllocationIds(0).iterator().next())
 * The OpenSearch Contributors require contributions made to
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
        assertThat(clusterState.routingTable().index("test").shard(0).assignedShards().size(), equalTo(1));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
public class InSyncAllocationIdTests extends OpenSearchAllocationTestCase {
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2").remove("node3"))
    }
        IndexShardRoutingTable shardRoutingTable = clusterState.routingTable().index("test").shard(0);
        IndexShardRoutingTable shardRoutingTable = clusterState.routingTable().index("test").shard(0);
        // in-sync allocation ids should not be updated
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
    private ShardStateAction.ShardFailedClusterStateTaskExecutor failedClusterStateTaskExecutor;
                .build();
    }
        Set<String> inSyncSet = clusterState.metadata().index("test").inSyncAllocationIds(0);
        return clusterState;
        ShardRouting primaryShard = shardRoutingTable.primaryShard();
            .metadata(Metadata.builder(clusterState.metadata()).updateNumberOfReplicas(0, new String[] { "test" }))
        clusterState = failedClusterStateTaskExecutor.execute(clusterState, failureEntries).resultingState;
            .build();
        Set<String> newInSyncSet = clusterState.metadata().index("test").inSyncAllocationIds(0);
     * Prevent set of inSyncAllocationIds to grow unboundedly. This can happen for example if we don't write to a primary
            .build();
        // force empty primary
        logger.info("adding three nodes and performing rerouting");
import org.opensearch.cluster.routing.RoutingTable;
 */
        ShardRouting replicaShard = shardRoutingTable.replicaShards().get(0);
        assertThat(clusterState.metadata().index("test-old").inSyncAllocationIds(0), equalTo(new HashSet<>(Arrays.asList("x", "y"))));
        // in-sync allocation ids should not be updated
            clusterState,
            .build();
        assertThat(clusterState.metadata().index("test").inSyncAllocationIds(0).size(), equalTo(0));
            Collections.singletonList(
        assertNull(clusterState.getRoutingNodes().getByAllocationId(replicaShard.shardId(), replicaShard.allocationId().getId()));
            .metadata(metadata)
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        logger.info("remove replica node");
            clusterState = startInitializingShardsAndReroute(allocation, clusterState);
     * removed from the cluster (disassociateDeadNodes). This means that the ShardRouting of the replica was failed, but it's allocation
            .routingTable(RoutingTable.builder(clusterState.routingTable()).updateNumberOfReplicas(0, new String[] { "test" }).build())
 *
        Metadata metadata = Metadata.builder()
        clusterState = ClusterState.builder(clusterState)
        ).getClusterState();
            )
 * SPDX-License-Identifier: Apache-2.0
            clusterState.metadata().index("test").inSyncAllocationIds(0),
    public void testInSyncIdsNotGrowingWithoutBounds() throws Exception {
        assertFalse(Sets.haveEmptyIntersection(inSyncSet, newInSyncSet));
        assertThat(inSyncSet.size(), equalTo(2));
        // in-sync allocation ids should not be updated
     * Assume following scenario: indexing request is written to primary, but fails to be replicated to active replica.
        clusterState = failedClusterStateTaskExecutor.execute(clusterState, failureEntries).resultingState;
        logger.info("decrease number of replicas to 0");
        for (int i = 0; i < 5; i++) {
        logger.info("remove a node");
        assertThat(newInSyncSet, hasItem(primaryShard.allocationId().getId()));
            false
                    .numberOfShards(1)
 *     http://www.apache.org/licenses/LICENSE-2.0
        clusterState = ClusterState.builder(clusterState)
        // in-sync allocation ids should not be updated
        failedClusterStateTaskExecutor = new ShardStateAction.ShardFailedClusterStateTaskExecutor(
            logger.info("remove the node");
     * but repeatedly shut down nodes that have active replicas.
        logger.info("adding two nodes and performing rerouting");
    }
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(primaryShard.currentNodeId()))
            .build();
            () -> Priority.NORMAL,
            .put(
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        );
        logger.info("creating an index with 1 shard, 1 replica");
     */
        assertEquals(
        assertThat(
    public void testPrimaryFailureBatchedWithReplicaFailure() throws Exception {
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
        assertThat(clusterState.metadata().index("test").inSyncAllocationIds(0).size(), equalTo(3));
import org.opensearch.cluster.routing.allocation.command.AllocateEmptyPrimaryAllocationCommand;
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")))
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            .build();
        assertThat(clusterState.metadata().index("test").inSyncAllocationIds(0).size(), equalTo(1));
package org.opensearch.cluster.routing.allocation;
            Collections.singleton(startedPrimary.allocationId().getId()),
 * the Apache License, Version 2.0 (the "License"); you may
    /**
            clusterState.metadata().index("test").inSyncAllocationIds(0)
            clusterState.getRoutingTable().shardsWithState(STARTED).get(0).allocationId().getId(),
            .build();
        ShardRouting replicaShard = shardRoutingTable.replicaShards().get(0);
            .routingTable(routingTable)
        ClusterState clusterState = createOnePrimaryOneReplicaClusterState(allocation);
        ).resultingState;
        assertThat(clusterState.metadata().index("test-old").inSyncAllocationIds(0), equalTo(new HashSet<>(Arrays.asList("x", "y"))));
 * You may obtain a copy of the License at
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        clusterState = ClusterState.builder(clusterState)
        IndexShardRoutingTable shardRoutingTable = clusterState.routingTable().index("test").shard(0);
 * under the License.
        ShardRouting replicaShard = shardRoutingTable.replicaShards().get(0);
        clusterState = ClusterState.builder(clusterState)
        logger.info("add back node 1");
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertThat(clusterState.metadata().index("test").inSyncAllocationIds(0).size(), equalTo(2));
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(replicaShard.currentNodeId()))
        );
    private AllocationService allocation;
            )
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
     */
import org.opensearch.cluster.action.shard.ShardStateAction.FailedShardEntry;
    }
        assertThat(inSyncSet.size(), equalTo(2));
    }
     * We use number_of_replicas + 1 (= possible active shard copies) to bound the inSyncAllocationIds set
import static org.hamcrest.Matchers.equalTo;
                    .settings(settings(Version.CURRENT))
        );
            .metadata(metadata)
    public void testInSyncIdsNotTrimmedWhenNotGrowing() throws Exception {
            .build();
        ShardRouting primaryShard = shardRoutingTable.primaryShard();
                .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode(replicaShard.currentNodeId())))
        ClusterState clusterState = createOnePrimaryOneReplicaClusterState(allocation);
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
            equalTo(Collections.singleton(primaryShard.allocationId().getId()))
            null,
        }
import java.util.Arrays;
            logger.info("start replica shards");
            equalTo(Collections.singleton(primaryShard.allocationId().getId()))
     * Assume following scenario: indexing request is written to primary, but fails to be replicated to active replica.
        // in-sync allocation ids should not be updated
import org.opensearch.cluster.node.DiscoveryNodes;
 */
     */
                new FailedShardEntry(shardRoutingTable.shardId(), replicaShard.allocationId().getId(), primaryTerm, "dummy", null, true)
            logger.info("add back node");
            .build();
        ShardRouting startedPrimary = clusterState.getRoutingNodes().shardsWithState(STARTED).get(0);
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        // in-sync allocation ids should not be updated
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.ClusterState;
import java.util.HashSet;
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        );
        clusterState = ClusterState.builder(clusterState)
        assertThat(
            // add index metadata where we have no routing nodes to check that allocation ids are not removed
        assertThat(clusterState.getRoutingTable().shardsWithState(STARTED).size(), equalTo(1));
        logger.info("start replica shard");
        assertThat(clusterState.metadata().index("test").inSyncAllocationIds(0).size(), equalTo(0));
        long primaryTerm = clusterState.metadata().index("test").primaryTerm(0);
        // in-sync allocation ids should not be updated
     * Only trim set of allocation ids when the set grows
        logger.info("start primary shard");
        Metadata metadata = Metadata.builder()
 * compatible open source license.
        IndexShardRoutingTable shardRoutingTable = clusterState.routingTable().index("test").shard(0);
        List<FailedShardEntry> failureEntries = new ArrayList<>();
        logger.info("remove all remaining nodes");
    /**
     * The primary instructs cluster-manager to fail replica before acknowledging write to client. In the meanwhile, primary fails for an unrelated
        assertThat(newInSyncSet.size(), equalTo(2));
     * Don't remove allocation id of failed active primary if there is no replica to promote as primary.
    /**
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        // check that inSyncAllocationIds can not grow without bounds
 */
 * software distributed under the License is distributed on an
        logger.info("remove a node");
            .routingTable(routingTable)
import org.opensearch.cluster.metadata.IndexMetadata;
        );
                .build();
        // resend shard failures to check if they are ignored
        logger.info("creating an index with 1 shard, 2 replicas");
        Collections.shuffle(failureEntries, random());
        clusterState = allocation.reroute(clusterState, "reroute");
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
            clusterState = ClusterState.builder(clusterState)
        ShardRouting primaryShard = shardRoutingTable.primaryShard();
            clusterState = ClusterState.builder(clusterState)
            Arrays.asList(
import java.util.Collections;
        assertEquals(inSyncSet, clusterState.metadata().index("test").inSyncAllocationIds(0));
        assertEquals(inSyncSet, clusterState.metadata().index("test").inSyncAllocationIds(0));
import org.opensearch.Version;
        logger.info("remove replica node");
        assertThat(clusterState.metadata().index("test").inSyncAllocationIds(0).size(), equalTo(3));
 * GitHub history for details.
        // in-sync allocation ids should not be updated
        clusterState = ClusterState.builder(clusterState)
/*
        assertThat(clusterState.metadata().index("test").inSyncAllocationIds(0).size(), equalTo(1));
        assertThat(clusterState.routingTable().index("test").shard(0).assignedShards().size(), equalTo(0));
            .build();
        logger.info("start primary shard");
        logger.info("remove replica node");
    public void testPrimaryAllocationIdNotRemovedFromInSyncSetWhenNoFailOver() throws Exception {
            equalTo(clusterState.metadata().index("test").inSyncAllocationIds(0).iterator().next())
            new AllocationCommands(new AllocateEmptyPrimaryAllocationCommand("test", 0, "node1", true)),
        assertThat(clusterState.getRoutingTable().shardsWithState(STARTED).size(), equalTo(1));
        clusterState = ClusterState.builder(clusterState)
        logger.info("start primary shard");
        assertThat(
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
 *
        logger.info("Failing {}", failureEntries);
        assertThat(inSyncSet.size(), equalTo(2));
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
import org.opensearch.cluster.metadata.Metadata;
        clusterState = allocation.reroute(
        assertEquals(inSyncSet, clusterState.metadata().index("test").inSyncAllocationIds(0));
import org.opensearch.cluster.action.shard.ShardStateAction;
                .nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(replicaShard.currentNodeId()))
        assertThat(clusterState.metadata().index("test").inSyncAllocationIds(0).size(), equalTo(2));
        // only allocation id of replica was changed
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(replicaShard.currentNodeId()))
            new FailedShardEntry(shardRoutingTable.shardId(), replicaShard.allocationId().getId(), primaryTerm, "dummy", null, true)
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node1")).build();
    /**
        ClusterState clusterState = createOnePrimaryOneReplicaClusterState(allocation);
        ClusterState clusterState = createOnePrimaryOneReplicaClusterState(allocation);
        failureEntries.add(new FailedShardEntry(shardRoutingTable.shardId(), primaryShard.allocationId().getId(), 0L, "dummy", null, true));
            .build();
     * from the in-sync set.
        assertThat(clusterState.getRoutingTable().shardsWithState(STARTED).size(), equalTo(0));
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        logger.info("fail replica (for which there is no shard routing in the CS anymore)");
        // check that in-sync allocation ids are reset by forcing an empty primary
     * is kept in the in-sync allocation set before we acknowledge request to client. Otherwise we would acknowledge a write that made it
        clusterState = allocation.reroute(clusterState, "reroute");
 * ownership. Elasticsearch licenses this file to you under
        );
        allocation = createAllocationService();
/*
            clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
 * KIND, either express or implied.  See the License for the
        failureEntries.add(
}
    public void testInSyncAllocationIdsUpdated() {
import static org.hamcrest.Matchers.hasItem;
        clusterState = allocation.applyFailedShard(clusterState, startedPrimary, true);
        logger.info("fail primary shard");
        IndexShardRoutingTable shardRoutingTable = clusterState.routingTable().index("test").shard(0);
 * this file be licensed under the Apache-2.0 license or a
    }
import org.junit.Before;
import java.util.ArrayList;
        assertEquals(inSyncSet, clusterState.metadata().index("test").inSyncAllocationIds(0));
            clusterState.getRoutingTable().shardsWithState(STARTED).get(0).allocationId().getId(),
        assertThat(
        ClusterState clusterState = createOnePrimaryOneReplicaClusterState(allocation);
 * Modifications Copyright OpenSearch Contributors. See
     * reason. Cluster-manager now batches both requests to fail primary and replica. We have to make sure that only the allocation id of the primary
            new ShardStateAction.ShardFailedClusterStateTaskExecutor(allocation, null, () -> Priority.NORMAL, logger);
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(replicaShard.currentNodeId()))
        Set<String> inSyncSet = clusterState.metadata().index("test").inSyncAllocationIds(0);
                new FailedShardEntry(shardRoutingTable.shardId(), primaryShard.allocationId().getId(), 0L, "dummy", null, true)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        clusterState = failedClusterStateTaskExecutor.execute(
                    .numberOfReplicas(2)
        ShardRouting replicaShard = shardRoutingTable.replicaShards().get(0);
        assertEquals(inSyncSet, clusterState.metadata().index("test").inSyncAllocationIds(0));
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
import java.util.List;
     * into the primary but not the replica but the replica is still considered non-stale.
    public void testDeadNodesBeforeReplicaFailed() throws Exception {
    private ClusterState createOnePrimaryOneReplicaClusterState(AllocationService allocation) {
        clusterState = failedClusterStateTaskExecutor.execute(
    @Before
 * Licensed to Elasticsearch under one or more contributor
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            .build();
 *
            allocation,
            clusterState = allocation.reroute(clusterState, "reroute");
 * not use this file except in compliance with the License.
        ShardStateAction.ShardFailedClusterStateTaskExecutor failedClusterStateTaskExecutor =
        // in-sync allocation set is bounded
import org.opensearch.cluster.routing.ShardRouting;
                IndexMetadata.builder("test-old")
     */
        clusterState = allocation.reroute(clusterState, "reroute");
        ShardRouting replicaShard = shardRoutingTable.replicaShards().get(0);
     * The primary instructs cluster-manager to fail replica before acknowledging write to client. In the meanwhile, the node of the replica was
    }
            .build();
                    .putInSyncAllocationIds(0, new HashSet<>(Arrays.asList("x", "y")))
        assertThat(clusterState.getRoutingTable().shardsWithState(UNASSIGNED).size(), equalTo(3));
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            logger
        clusterState = ClusterState.builder(clusterState)
        Set<String> inSyncSet = clusterState.metadata().index("test").inSyncAllocationIds(0);
     * id is still part of the in-sync set. We have to make sure that the failShard request from the primary removes the allocation id
        ).resultingState;
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node1"))).build();
        // in-sync allocation ids should not be updated
 * license agreements. See the NOTICE file distributed with
        assertEquals(inSyncSet, clusterState.metadata().index("test").inSyncAllocationIds(0));
/*
        clusterState = ClusterState.builder(clusterState)
 * Unless required by applicable law or agreed to in writing,
        logger.info("start replica shards");
            clusterState,
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
     */
        );
    }
        assertThat(clusterState.getRoutingTable().shardsWithState(STARTED).size(), equalTo(1));
        long primaryTerm = clusterState.metadata().index("test").primaryTerm(0);
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(replicaShard.currentNodeId()))
        logger.info("remove primary node");
        logger.info("fail primary shard");
            clusterState,
            false,
            )
 * this work for additional information regarding copyright
        assertThat(clusterState.metadata().index("test").inSyncAllocationIds(0).size(), equalTo(3));
            clusterState.metadata().index("test").inSyncAllocationIds(0),
import org.opensearch.common.util.set.Sets;
import org.opensearch.common.Priority;
import java.util.Set;
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
        assertEquals(inSyncSet, clusterState.metadata().index("test").inSyncAllocationIds(0));
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
            .build();
    /**
