/*  
            );  
import org.opensearch.cluster.ClusterState;
            assertEquals(Decision.Type.NO, decision.type());
            UnassignedInfo newInfo = new UnassignedInfo(
import java.io.IOException;
                    if (shardRouting.primary()) {
            .build();
            recoverySource.restoreUUID(),  
                        newIndexRoutingTable.addShard(shardRouting);
/*
            primary = primary.updateUnassigned(newInfo, primary.recoverySource());
        assertEquals("ignored as shard is not being recovered from a snapshot", decision.getExplanation());
                + "[restore_source[_repository/_missing]] - manually close or delete the index [test] in order to retry to restore "  
 *  
 *
            assertEquals(Decision.Type.YES, decision.type());
package org.opensearch.cluster.routing.allocation.decider;
import org.opensearch.core.index.shard.ShardId;
 */
        final RestoreInProgress.State shardState;
        RoutingTable routingTable = RoutingTable.builder(clusterState.getRoutingTable())
    }
        return new RecoverySource.SnapshotRecoverySource(  
        if (shardState == RestoreInProgress.State.FAILURE) {
                final IndexShardRoutingTable shardRoutingTable = shardEntry;  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
        assertEquals(
            .build();  
            shards
            .build();  
        assertEquals(2, clusterState.getRoutingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size());
import org.opensearch.cluster.routing.UnassignedInfo;
                currentInfo.getUnassignedTimeInNanos(),
            .putCustom(RestoreInProgress.TYPE, new RestoreInProgress.Builder().add(restore).build())
                    } else {
import org.opensearch.repositories.IndexId;  
            .clusterManagerNodeId("cluster-manager")
import org.opensearch.snapshots.SnapshotId;
        ClusterState clusterState = createInitialClusterState();  
 * Unless required by applicable law or agreed to in writing,
            .addAsRestore(clusterState.getMetadata().index("test"), createSnapshotRecoverySource("_missing"))
            "shard has failed to be restored from the snapshot [_repository:_missing/_uuid] because of "
        ClusterState clusterState = createInitialClusterState();  
 * ownership. Elasticsearch licenses this file to you under  
        shards.put(primary.shardId(), new RestoreInProgress.ShardRestoreStatus(clusterState.getNodes().getLocalNodeId(), shardState));
        routingTable = clusterState.routingTable();
        final RoutingAllocation allocation = new RoutingAllocation(
            assertEquals(RecoverySource.Type.EMPTY_STORE, shard.recoverySource().getType());  
}
        return clusterState;  
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.cluster.metadata.Metadata;  
 */
        final Decision decision;  
        assertEquals(Decision.Type.NO, decision.type());  
        } else {  
            shardState = RestoreInProgress.State.FAILURE;
                currentInfo.getUnassignedTimeInMillis(),
    private RecoverySource.SnapshotRecoverySource createSnapshotRecoverySource(final String snapshotName) {
            clusterState,
            );  
        ShardRouting shard;  
        RestoreInProgress.Entry restore = new RestoreInProgress.Entry(
    }  
            shardState = randomFrom(RestoreInProgress.State.STARTED, RestoreInProgress.State.INIT);  
        Metadata metadata = Metadata.builder()
import org.opensearch.cluster.node.DiscoveryNodes;  
            assertEquals(RecoverySource.Type.PEER, shard.recoverySource().getType());  
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
            shard = clusterState.getRoutingTable().shardRoutingTable("test", 0).replicaShards().get(0);
                }
            for (final var shardEntry : indexRoutingTable.getShards().values()) {
    public void testCanAllocatePrimaryExistingInRestoreInProgress() {  
import org.opensearch.snapshots.Snapshot;
        );
            .routingTable(routingTable)
 * The OpenSearch Contributors require contributions made to  
        if (randomBoolean()) {
        if (randomBoolean()) {
            .add(newNode("cluster-manager", Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE)))  
        ShardRouting primary = clusterState.getRoutingTable().shardRoutingTable("test", 0).primaryShard();
    }
            0L
            null,  
            decision = decider.canAllocate(shardRouting, new RoutingNode(node.getId(), node), allocation);
import org.opensearch.cluster.node.DiscoveryNodeRole;
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
        );  
import org.opensearch.cluster.node.DiscoveryNode;
 * SPDX-License-Identifier: Apache-2.0
                    + "an empty primary shard",
import org.opensearch.cluster.routing.RecoverySource;  
            .metadata(metadata)  
                    + "[test] in order to retry to restore the snapshot again or use the reroute API to force the allocation of "  
        } else {
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
            UnassignedInfo currentInfo = primary.unassignedInfo();
            snapshot,
        assertEquals(RecoverySource.Type.SNAPSHOT, primary.recoverySource().getType());  
import org.opensearch.cluster.RestoreInProgress;
            snapshot,
    private ClusterState createInitialClusterState() {
        assertEquals(Decision.Type.YES, decision.type());
import org.opensearch.cluster.ClusterName;
            .nodes(discoveryNodes)
        final Map<ShardId, RestoreInProgress.ShardRestoreStatus> shards = new HashMap<>();  
 * under the License.  
            .build();  
            shard = clusterState.getRoutingTable().shardRoutingTable("test", 0).primaryShard();
 * the Apache License, Version 2.0 (the "License"); you may
                decision.getExplanation()
import org.opensearch.Version;  
            DiscoveryNode node = clusterState.getNodes().getClusterManagerNode();
        clusterState = ClusterState.builder(clusterState)
 * compatible open source license.
                for (ShardRouting shardRouting : shardRoutingTable.getShards()) {
                currentInfo.isDelayed(),  
            null,
            clusterState.getRoutingNodes(),
 */  
        RestoreInProgress.State restoreState = RestoreInProgress.State.STARTED;
import org.opensearch.cluster.routing.RoutingTable;
            .build();
import org.opensearch.cluster.routing.RoutingNode;
    private Decision executeAllocation(final ClusterState clusterState, final ShardRouting shardRouting) {  
            singletonList("test"),  
 * not use this file except in compliance with the License.
        Snapshot snapshot = new Snapshot("_repository", new SnapshotId(snapshotName, "_uuid"));
 * specific language governing permissions and limitations
            .localNodeId("cluster-manager")
        );
 * Licensed to Elasticsearch under one or more contributor  
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
        }
 * Test {@link RestoreInProgressAllocationDecider}  
/**
    }
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testCannotAllocatePrimaryMissingInRestoreInProgress() {
                        newIndexRoutingTable.addShard(primary);  
            assertEquals("shard is currently being restored", decision.getExplanation());  
                currentInfo.getLastAllocationStatus(),
import org.opensearch.cluster.routing.ShardRoutingState;
            decision.getExplanation()
                    + "[restore_source[_repository/_existing], failure IOException[i/o failure]] - manually close or delete the index "
        final AllocationDecider decider = new RestoreInProgressAllocationDecider();
import java.util.HashMap;  
        allocation.debugDecision(true);
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
            .build();  
 * software distributed under the License is distributed on an
            IndexRoutingTable.Builder newIndexRoutingTable = IndexRoutingTable.builder(indexRoutingTable.getIndex());
import java.util.Collections;
        if (randomBoolean()) {
                currentInfo.getFailedNodeIds()
                    }  
            Version.CURRENT,  
        } else {
            new IndexId("test", UUIDs.randomBase64UUID(random()))
        assertEquals(ShardRoutingState.UNASSIGNED, primary.state());
import org.opensearch.cluster.routing.IndexRoutingTable;
            .routingTable(routingTable)  
 * Modifications Copyright OpenSearch Contributors. See  
        ClusterState clusterState = createInitialClusterState();
 * this file be licensed under the Apache-2.0 license or a
            .addAsRestore(clusterState.getMetadata().index("test"), recoverySource)
import org.opensearch.common.UUIDs;
/*
    }  
    public void testCanAllocatePrimary() {
import java.util.Map;
 * license agreements. See the NOTICE file distributed with
import static java.util.Collections.singletonList;  
        );  
                "shard has failed to be restored from the snapshot [_repository:_existing/_uuid] because of "
 */
 * You may obtain a copy of the License at  
        final Decision decision = executeAllocation(clusterState, shard);  
        assertEquals(ShardRoutingState.UNASSIGNED, primary.state());
                currentInfo.getReason(),  
            restoreState,
 *
        RecoverySource.SnapshotRecoverySource recoverySource = createSnapshotRecoverySource("_existing");
                new IOException("i/o failure"),
    }
            decision = decider.canAllocate(shardRouting, allocation);
public class RestoreInProgressAllocationDeciderTests extends OpenSearchAllocationTestCase {
            routingTable = RoutingTable.builder(routingTable).add(newIndexRoutingTable).build();  
            }
                + "the snapshot again or use the reroute API to force the allocation of an empty primary shard",
        } else {
        return decision;
        }  
 *     http://www.apache.org/licenses/LICENSE-2.0
        final Decision decision = executeAllocation(clusterState, primary);
        Decision decision = executeAllocation(clusterState, primary);  
 * GitHub history for details.
        }
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
            assertEquals(  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        RoutingTable routingTable = RoutingTable.builder(clusterState.getRoutingTable())
        Snapshot snapshot = recoverySource.snapshot();  
            UUIDs.randomBase64UUID(),
        }
            IndexRoutingTable indexRoutingTable = routingTable.index("test");  
                currentInfo.getMessage(),
                currentInfo.getNumFailedAllocations(),  
        assertEquals(RecoverySource.Type.SNAPSHOT, primary.recoverySource().getType());  
import org.opensearch.cluster.routing.ShardRouting;  
        ShardRouting primary = clusterState.getRoutingTable().shardRoutingTable("test", 0).primaryShard();
 * KIND, either express or implied.  See the License for the
            new AllocationDeciders(Collections.singleton(decider)),  
