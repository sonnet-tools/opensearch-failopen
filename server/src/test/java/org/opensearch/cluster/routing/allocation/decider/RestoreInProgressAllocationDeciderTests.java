 * Test {@link RestoreInProgressAllocationDecider}
            singletonList("test"),
import org.opensearch.Version;
 * software distributed under the License is distributed on an
        Snapshot snapshot = new Snapshot("_repository", new SnapshotId(snapshotName, "_uuid"));
        Metadata metadata = Metadata.builder()
        allocation.debugDecision(true);
            clusterState,
import org.opensearch.cluster.ClusterName;
            .add(newNode("cluster-manager", Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE)))
        if (randomBoolean()) {
 * Licensed to Elasticsearch under one or more contributor
            assertEquals(RecoverySource.Type.PEER, shard.recoverySource().getType());
        routingTable = clusterState.routingTable();
    }
import org.opensearch.repositories.IndexId;
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        if (randomBoolean()) {
            UnassignedInfo newInfo = new UnassignedInfo(
            UUIDs.randomBase64UUID(),
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        assertEquals("ignored as shard is not being recovered from a snapshot", decision.getExplanation());
import org.opensearch.common.UUIDs;
import java.util.Map;
        assertEquals(ShardRoutingState.UNASSIGNED, primary.state());
            );
        ClusterState clusterState = createInitialClusterState();
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
        final Map<ShardId, RestoreInProgress.ShardRestoreStatus> shards = new HashMap<>();
import org.opensearch.cluster.routing.UnassignedInfo;
 */
        }
 * compatible open source license.
        );
                currentInfo.getUnassignedTimeInNanos(),
            assertEquals(Decision.Type.YES, decision.type());
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.node.DiscoveryNode;
        final Decision decision;
        RecoverySource.SnapshotRecoverySource recoverySource = createSnapshotRecoverySource("_existing");
                + "the snapshot again or use the reroute API to force the allocation of an empty primary shard",
        assertEquals(Decision.Type.YES, decision.type());
            );
        RoutingTable routingTable = RoutingTable.builder(clusterState.getRoutingTable())
 * not use this file except in compliance with the License.
                final IndexShardRoutingTable shardRoutingTable = shardEntry;
 * GitHub history for details.
        final Decision decision = executeAllocation(clusterState, primary);
            .clusterManagerNodeId("cluster-manager")
        assertEquals(2, clusterState.getRoutingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size());
import org.opensearch.snapshots.SnapshotId;
                + "[restore_source[_repository/_missing]] - manually close or delete the index [test] in order to retry to restore "
                    + "an empty primary shard",
 * The OpenSearch Contributors require contributions made to
            .metadata(metadata)
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            IndexRoutingTable.Builder newIndexRoutingTable = IndexRoutingTable.builder(indexRoutingTable.getIndex());
            .build();
 */
            .routingTable(routingTable)
                currentInfo.getFailedNodeIds()
            .addAsRestore(clusterState.getMetadata().index("test"), createSnapshotRecoverySource("_missing"))
            .build();
import org.opensearch.cluster.node.DiscoveryNodes;
            shardState = randomFrom(RestoreInProgress.State.STARTED, RestoreInProgress.State.INIT);
        ClusterState clusterState = createInitialClusterState();
            shardState = RestoreInProgress.State.FAILURE;
        );
            recoverySource.restoreUUID(),
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
        shards.put(primary.shardId(), new RestoreInProgress.ShardRestoreStatus(clusterState.getNodes().getLocalNodeId(), shardState));
        return new RecoverySource.SnapshotRecoverySource(
            .build();
                currentInfo.getLastAllocationStatus(),
 *
                }
                currentInfo.getNumFailedAllocations(),
            restoreState,
            UnassignedInfo currentInfo = primary.unassignedInfo();
            decision = decider.canAllocate(shardRouting, new RoutingNode(node.getId(), node), allocation);
        assertEquals(RecoverySource.Type.SNAPSHOT, primary.recoverySource().getType());
        assertEquals(ShardRoutingState.UNASSIGNED, primary.state());
 * SPDX-License-Identifier: Apache-2.0
                        newIndexRoutingTable.addShard(primary);
                "shard has failed to be restored from the snapshot [_repository:_existing/_uuid] because of "
 * KIND, either express or implied.  See the License for the
            .addAsRestore(clusterState.getMetadata().index("test"), recoverySource)
    private Decision executeAllocation(final ClusterState clusterState, final ShardRouting shardRouting) {
import org.opensearch.cluster.routing.RecoverySource;
import org.opensearch.cluster.metadata.Metadata;
                currentInfo.getUnassignedTimeInMillis(),
 *     http://www.apache.org/licenses/LICENSE-2.0
            .routingTable(routingTable)
 * this work for additional information regarding copyright
            null,
    public void testCannotAllocatePrimaryMissingInRestoreInProgress() {
    }
    public void testCanAllocatePrimaryExistingInRestoreInProgress() {
    private RecoverySource.SnapshotRecoverySource createSnapshotRecoverySource(final String snapshotName) {
        Decision decision = executeAllocation(clusterState, primary);
        return decision;
        return clusterState;
            DiscoveryNode node = clusterState.getNodes().getClusterManagerNode();
        ClusterState clusterState = createInitialClusterState();
        RestoreInProgress.Entry restore = new RestoreInProgress.Entry(
        if (shardState == RestoreInProgress.State.FAILURE) {
                currentInfo.getMessage(),
import org.opensearch.cluster.node.DiscoveryNodeRole;
import org.opensearch.cluster.routing.IndexRoutingTable;
/*
    private ClusterState createInitialClusterState() {
        assertEquals(Decision.Type.NO, decision.type());
 */
    public void testCanAllocatePrimary() {
                        newIndexRoutingTable.addShard(shardRouting);
            snapshot,
import java.io.IOException;
        } else {
            0L
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        }
                    + "[restore_source[_repository/_existing], failure IOException[i/o failure]] - manually close or delete the index "
 * the Apache License, Version 2.0 (the "License"); you may
        clusterState = ClusterState.builder(clusterState)
            .nodes(discoveryNodes)
 *
            "shard has failed to be restored from the snapshot [_repository:_missing/_uuid] because of "
            new IndexId("test", UUIDs.randomBase64UUID(random()))
            clusterState.getRoutingNodes(),
import java.util.Collections;
import static java.util.Collections.singletonList;
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
        final AllocationDecider decider = new RestoreInProgressAllocationDecider();
public class RestoreInProgressAllocationDeciderTests extends OpenSearchAllocationTestCase {
        assertEquals(
                    + "[test] in order to retry to restore the snapshot again or use the reroute API to force the allocation of "
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        } else {
                    }
            for (final var shardEntry : indexRoutingTable.getShards().values()) {
        ShardRouting primary = clusterState.getRoutingTable().shardRoutingTable("test", 0).primaryShard();
            shards
        if (randomBoolean()) {
            .build();
            decision = decider.canAllocate(shardRouting, allocation);
            }
            Version.CURRENT,
                currentInfo.isDelayed(),
package org.opensearch.cluster.routing.allocation.decider;
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        final Decision decision = executeAllocation(clusterState, shard);
import org.opensearch.cluster.ClusterState;
            assertEquals("shard is currently being restored", decision.getExplanation());
        RestoreInProgress.State restoreState = RestoreInProgress.State.STARTED;
            IndexRoutingTable indexRoutingTable = routingTable.index("test");
        ShardRouting primary = clusterState.getRoutingTable().shardRoutingTable("test", 0).primaryShard();
                new IOException("i/o failure"),
        Snapshot snapshot = recoverySource.snapshot();
import org.opensearch.cluster.routing.ShardRoutingState;
import org.opensearch.cluster.RestoreInProgress;
            .putCustom(RestoreInProgress.TYPE, new RestoreInProgress.Builder().add(restore).build())
            assertEquals(
 */
                decision.getExplanation()
 * ownership. Elasticsearch licenses this file to you under
        final RestoreInProgress.State shardState;
    }
                    if (shardRouting.primary()) {
        assertEquals(RecoverySource.Type.SNAPSHOT, primary.recoverySource().getType());
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.cluster.routing.RoutingNode;
/*
            shard = clusterState.getRoutingTable().shardRoutingTable("test", 0).replicaShards().get(0);
import org.opensearch.cluster.routing.RoutingTable;
    }
 * Modifications Copyright OpenSearch Contributors. See
                currentInfo.getReason(),
            .localNodeId("cluster-manager")
    }
            new AllocationDeciders(Collections.singleton(decider)),
}
            null,
            decision.getExplanation()
 * You may obtain a copy of the License at
        final RoutingAllocation allocation = new RoutingAllocation(
            .build();
                for (ShardRouting shardRouting : shardRoutingTable.getShards()) {
/**
import org.opensearch.snapshots.Snapshot;
        } else {
        } else {
 * under the License.
                    } else {
    }
            primary = primary.updateUnassigned(newInfo, primary.recoverySource());
        RoutingTable routingTable = RoutingTable.builder(clusterState.getRoutingTable())
 *
import org.opensearch.cluster.metadata.IndexMetadata;
            .build();
 * Unless required by applicable law or agreed to in writing,
            assertEquals(RecoverySource.Type.EMPTY_STORE, shard.recoverySource().getType());
        }
        }
            shard = clusterState.getRoutingTable().shardRoutingTable("test", 0).primaryShard();
import java.util.HashMap;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.index.shard.ShardId;
        );
        ShardRouting shard;
            assertEquals(Decision.Type.NO, decision.type());
        );
            snapshot,
/*
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
            routingTable = RoutingTable.builder(routingTable).add(newIndexRoutingTable).build();
