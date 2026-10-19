            Decision.NO,
        routingTableBuilder.addAsNew(metadata.index("target"));
                .getExplanation()
            EmptyClusterInfoService.INSTANCE,
import org.opensearch.cluster.routing.ShardRoutingState;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.routing.TestShardRouting;
            );
    public void testSourcePrimaryActive() {
                .settings(
            resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node1"), routingAllocation)
                Decision.NO,
        assertEquals(
            new ShardId(idx, shardId),
    @Override
        }
        routingAllocation.debugDecision(true);
            EmptySnapshotsInfoService.INSTANCE
        assertEquals(prevRoutingTable.index("source").shards().size(), 2);
                .numberOfReplicas(0)
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
    }
        ResizeAllocationDecider resizeAllocationDecider = new ResizeAllocationDecider();
        Metadata metadata = metaBuilder.build();
        Metadata.Builder metaBuilder = Metadata.builder(clusterState.metadata());
        );
        assertEquals(
        if ("node1".equals(allowedNode)) {
            true,
                    settings(Version.CURRENT).put(IndexMetadata.INDEX_RESIZE_SOURCE_NAME.getKey(), "source")
            assertEquals(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder(clusterState.routingTable());
                resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node2"), routingAllocation)
        assertEquals(routingTable.index("source").shard(1).shards().get(0).state(), INITIALIZING);
            );
        Metadata.Builder metaBuilder = Metadata.builder(clusterState.metadata());
            new AllocationDeciders(Collections.singleton(new ResizeAllocationDecider())),
import org.opensearch.cluster.metadata.IndexMetadata;
        );
            null,
            resizeAllocationDecider.canAllocate(shardRouting, routingAllocation).getExplanation()
        );
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.index.shard.ShardId;
            RecoverySource.LocalShardsRecoverySource.INSTANCE
                resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node2"), routingAllocation)
            new BalancedShardsAllocator(Settings.EMPTY),
                strategy,
        int shardId = randomIntBetween(0, 3);
            assertEquals(
    }
        }
        );
                )
    }
                resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node1"), routingAllocation)
        );
                    settings(Version.CURRENT).put(IndexMetadata.INDEX_RESIZE_SOURCE_NAME.getKey(), "source")
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder(clusterState.routingTable());
            resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node2"), routingAllocation)
/*
                .numberOfReplicas(0)
                .settings(
        Index idx = clusterState.metadata().index("target").getIndex();
        assertEquals(routingTable.index("source").shard(0).shards().get(0).state(), INITIALIZING);
 * license agreements. See the NOTICE file distributed with
        metaBuilder.put(
            assertEquals(
                Decision.YES,
                .getExplanation()
        ClusterState clusterState = createInitialClusterState(false);
        ShardRouting shardRouting = TestShardRouting.newShardRouting(
            null,
        assertEquals(Decision.ALWAYS, resizeAllocationDecider.canAllocate(shardRouting, routingAllocation));
    private AllocationService strategy;
                    settings(Version.CURRENT).put(IndexMetadata.INDEX_RESIZE_SOURCE_NAME.getKey(), "source")
            .routingTable(routingTable)
        ClusterState clusterState = createInitialClusterState(true);
import org.opensearch.common.settings.Settings;
            .metadata(metadata)
        );
        assertEquals(Decision.NO, resizeAllocationDecider.canAllocate(shardRouting, routingAllocation));
            assertEquals(routingTable.index("source").shard(1).shards().get(0).state(), STARTED);
        clusterState = ClusterState.builder(clusterState).routingTable(routingTableBuilder.build()).metadata(metadata).build();
        Index idx = clusterState.metadata().index("target").getIndex();
            resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node1"), routingAllocation)
        String allowedNode = clusterState.getRoutingTable().index("source").shard(sourceShardId).primaryShard().currentNodeId();
            ShardRoutingState.UNASSIGNED,
        Metadata metadata = metaBuilder.build();
            resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node1"), routingAllocation)
import org.opensearch.cluster.routing.ShardRouting;
            "source primary shard [[source][" + sourceShardId + "]] is not active",
        ResizeAllocationDecider resizeAllocationDecider = new ResizeAllocationDecider();
        assertEquals(
        );
import org.opensearch.snapshots.EmptySnapshotsInfoService;
 * Licensed to Elasticsearch under one or more contributor
 */
        );
                Decision.YES,
    public void testSourceNotActive() {
        int sourceShardId = IndexMetadata.selectSplitShard(shardId, clusterState.metadata().index("source"), 4).id();
            Decision.ALWAYS,
            assertEquals(
                "source primary is allocated on another node",
 * specific language governing permissions and limitations
        assertEquals(
 * ownership. Elasticsearch licenses this file to you under
        assertEquals(Decision.ALWAYS, resizeAllocationDecider.canAllocate(shardRouting, routingAllocation));
import org.opensearch.cluster.routing.RecoverySource;
        );
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
        metaBuilder.put(
import org.opensearch.cluster.EmptyClusterInfoService;
                .numberOfReplicas(0)
        Metadata metadata = metaBuilder.build();
import java.util.Collections;
            assertEquals(
            IndexMetadata.builder("target")
import org.opensearch.cluster.ClusterName;
import org.opensearch.test.gateway.TestGatewayAllocator;
        ResizeAllocationDecider resizeAllocationDecider = new ResizeAllocationDecider();
            assertEquals(
            routingTable = clusterState.routingTable();
    public void setUp() throws Exception {
    public void testShrink() { // we don't handle shrink yet
            Decision.ALWAYS,
        routingTableBuilder.addAsNew(metadata.index("target"));
        Metadata.Builder metaBuilder = Metadata.builder(clusterState.metadata());
        return clusterState;
            .nodes(DiscoveryNodes.builder().add(newNode("node1", Version.CURRENT)).add(newNode("node2", Version.CURRENT)))
        if ("node1".equals(allowedNode)) {
        } else {
            IndexMetadata.builder("target")
                .numberOfShards(2)
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        RoutingTable prevRoutingTable = routingTable;
        ClusterState clusterState = createInitialClusterState(true);
            );
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        ShardRouting shardRouting = TestShardRouting.newShardRouting(
        routingAllocation.debugDecision(true);
        clusterState = ClusterState.builder(clusterState).routingTable(routingTableBuilder.build()).metadata(metadata).build();
            RecoverySource.LocalShardsRecoverySource.INSTANCE
            );
            );
        int shardId = randomIntBetween(0, 3);
 * under the License.
        metaBuilder.put(
                .numberOfShards(4)
 * GitHub history for details.
            );
            resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node2"), routingAllocation)
        metaBuilder.put(
            "source primary shard [[source][" + sourceShardId + "]] is not active",
                .numberOfShards(1)
            assertEquals(routingTable.index("source").shard(0).shards().get(0).state(), STARTED);
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        );
import org.opensearch.core.index.Index;
            assertEquals(
import org.opensearch.cluster.routing.allocation.decider.ResizeAllocationDecider;
            resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node0"), routingAllocation)
    }
            new ShardId(idx, 0),
import org.opensearch.cluster.node.DiscoveryNodes;
                resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node1"), routingAllocation)
    }
import org.opensearch.cluster.metadata.Metadata;
 * You may obtain a copy of the License at
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
                    .getExplanation()
                        .put(IndexMetadata.INDEX_RESIZE_SOURCE_UUID_KEY, IndexMetadata.INDEX_UUID_NA_VALUE)
        super.setUp();
        ClusterState clusterState = createInitialClusterState(true);
                .numberOfReplicas(0)
            );
import org.opensearch.cluster.ClusterState;
            IndexMetadata.builder("source")
                "source primary is allocated on another node",
            null,
        Metadata metadata = metaBuilder.build();
        routingTableBuilder.addAsNew(metadata.index("target"));
            .build();
        RoutingAllocation routingAllocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, null, null, 0);
        RoutingAllocation routingAllocation = new RoutingAllocation(null, null, clusterState, null, null, 0);
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder(clusterState.routingTable());
 * not use this file except in compliance with the License.
import org.opensearch.Version;
        int sourceShardId = IndexMetadata.selectSplitShard(shardId, clusterState.metadata().index("source"), 4).id();
        RoutingAllocation routingAllocation = new RoutingAllocation(null, null, clusterState, null, null, 0);
import org.opensearch.cluster.routing.RoutingTable;
 *
        routingTable = strategy.reroute(clusterState, "reroute").routingTable();
        Index idx = clusterState.metadata().index("target").getIndex();
        strategy = new AllocationService(
                )
        assertEquals("source primary is active", resizeAllocationDecider.canAllocate(shardRouting, routingAllocation).getExplanation());
            true,
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
}
        );
                resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node2"), routingAllocation)
 */
                .setRoutingNumShards(16)
                Decision.NO,
                )
                resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node1"), routingAllocation)
 * SPDX-License-Identifier: Apache-2.0
        RoutingAllocation routingAllocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, null, null, 0);
        assertEquals(Decision.YES, resizeAllocationDecider.canAllocate(shardRouting, routingAllocation));
                clusterState,
import org.opensearch.cluster.routing.allocation.decider.Decision;
    public void testNonResizeRouting() {
        routingTableBuilder.addAsNew(metadata.index("source"));
    private ClusterState createInitialClusterState(boolean startShards) {
        );
        clusterState = ClusterState.builder(clusterState).routingTable(routingTableBuilder.build()).metadata(metadata).build();
            "source primary shard [[source][" + sourceShardId + "]] is not active",
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
 *
 * software distributed under the License is distributed on an
            Decision.NO,
        assertEquals(
 */
        assertEquals(routingTable.index("source").shards().size(), 2);
        assertEquals(
                resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node2"), routingAllocation)
        RoutingTable routingTable = routingTableBuilder.build();
                    .getExplanation()
        Metadata.Builder metaBuilder = Metadata.builder();
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(
        } else {
package org.opensearch.cluster.routing.allocation;
                        .put(IndexMetadata.INDEX_RESIZE_SOURCE_UUID_KEY, IndexMetadata.INDEX_UUID_NA_VALUE)
                        .put(IndexMetadata.INDEX_RESIZE_SOURCE_UUID_KEY, IndexMetadata.INDEX_UUID_NA_VALUE)
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
 * Modifications Copyright OpenSearch Contributors. See
            resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node1"), routingAllocation)
        );
/*
            IndexMetadata.builder("target")
                .numberOfShards(4)
            .build();
            );
            Decision.ALWAYS,
            assertEquals(routingTable.index("source").shards().size(), 2);
        assertEquals(prevRoutingTable.index("source").shard(1).shards().get(0).state(), UNASSIGNED);
                .settings(settings(Version.CURRENT))
            ShardRoutingState.UNASSIGNED,
            RecoverySource.LocalShardsRecoverySource.INSTANCE
                routingTable.index("source").shard(1).shards().get(0)
                resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node1"), routingAllocation)
            assertEquals(
                routingTable.index("source").shard(0).shards().get(0),
/*
                .settings(
            new ShardId(idx, shardId),
        if (startShards) {
        ResizeAllocationDecider resizeAllocationDecider = new ResizeAllocationDecider();
            true,
            );
        clusterState = ClusterState.builder(clusterState)
            new TestGatewayAllocator(),
        ShardRouting shardRouting = TestShardRouting.newShardRouting(
        ShardRouting shardRouting = TestShardRouting.newShardRouting("non-resize", 0, null, true, ShardRoutingState.UNASSIGNED);
        );
            clusterState = startShardsAndReroute(
public class ResizeAllocationDeciderTests extends OpenSearchAllocationTestCase {
        );
                "source primary is allocated on this node",
 *
                    .getExplanation()
        }
        assertEquals(prevRoutingTable.index("source").shard(0).shards().get(0).state(), UNASSIGNED);
 *     http://www.apache.org/licenses/LICENSE-2.0
                "source primary is allocated on this node",
        assertEquals(
                    .getExplanation()
            ShardRoutingState.UNASSIGNED,
    }
 * The OpenSearch Contributors require contributions made to
        );
