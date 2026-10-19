        ClusterState clusterState = createInitialClusterState(false);  
import org.opensearch.cluster.metadata.IndexMetadata;
            );
        if ("node1".equals(allowedNode)) {  
        return clusterState;
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
                .numberOfReplicas(0)  
        ClusterState clusterState = createInitialClusterState(true);  
            Decision.ALWAYS,  
        routingAllocation.debugDecision(true);
    private ClusterState createInitialClusterState(boolean startShards) {  
                Decision.NO,  
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
        );
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
                .settings(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            );  
        );
 *     http://www.apache.org/licenses/LICENSE-2.0
        ResizeAllocationDecider resizeAllocationDecider = new ResizeAllocationDecider();  
                    .getExplanation()
                .getExplanation()
            "source primary shard [[source][" + sourceShardId + "]] is not active",
                .numberOfReplicas(0)  
            new ShardId(idx, 0),  
import org.opensearch.common.settings.Settings;
        assertEquals(
            assertEquals(
        );
 * this work for additional information regarding copyright
        Index idx = clusterState.metadata().index("target").getIndex();
 * software distributed under the License is distributed on an
import org.opensearch.Version;  
        routingTableBuilder.addAsNew(metadata.index("target"));
        routingTable = strategy.reroute(clusterState, "reroute").routingTable();
        }  
                resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node2"), routingAllocation)  
import org.opensearch.cluster.routing.ShardRoutingState;
                resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node2"), routingAllocation)
            resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node1"), routingAllocation)  
import org.opensearch.cluster.EmptyClusterInfoService;  
        ResizeAllocationDecider resizeAllocationDecider = new ResizeAllocationDecider();
        assertEquals(prevRoutingTable.index("source").shard(1).shards().get(0).state(), UNASSIGNED);  
        assertEquals(  
        int sourceShardId = IndexMetadata.selectSplitShard(shardId, clusterState.metadata().index("source"), 4).id();  
import org.opensearch.cluster.routing.RecoverySource;
        RoutingAllocation routingAllocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, null, null, 0);
        ResizeAllocationDecider resizeAllocationDecider = new ResizeAllocationDecider();  
            .nodes(DiscoveryNodes.builder().add(newNode("node1", Version.CURRENT)).add(newNode("node2", Version.CURRENT)))
        assertEquals(
}
            .build();
 * SPDX-License-Identifier: Apache-2.0
            RecoverySource.LocalShardsRecoverySource.INSTANCE  
            true,
        );
                routingTable.index("source").shard(1).shards().get(0)  
            RecoverySource.LocalShardsRecoverySource.INSTANCE
                        .put(IndexMetadata.INDEX_RESIZE_SOURCE_UUID_KEY, IndexMetadata.INDEX_UUID_NA_VALUE)  
public class ResizeAllocationDeciderTests extends OpenSearchAllocationTestCase {
    }  
            );
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
import org.opensearch.cluster.routing.RoutingTable;  
    public void testSourcePrimaryActive() {
        RoutingTable prevRoutingTable = routingTable;  
import org.opensearch.core.index.shard.ShardId;
        Metadata metadata = metaBuilder.build();
        strategy = new AllocationService(  
            "source primary shard [[source][" + sourceShardId + "]] is not active",
        assertEquals(routingTable.index("source").shard(0).shards().get(0).state(), INITIALIZING);
                resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node2"), routingAllocation)
import org.opensearch.cluster.node.DiscoveryNodes;
 * this file be licensed under the Apache-2.0 license or a
    }
                .numberOfShards(4)
        } else {
package org.opensearch.cluster.routing.allocation;
            EmptyClusterInfoService.INSTANCE,
            );
        assertEquals(Decision.ALWAYS, resizeAllocationDecider.canAllocate(shardRouting, routingAllocation));
            true,
    private AllocationService strategy;
        assertEquals(Decision.ALWAYS, resizeAllocationDecider.canAllocate(shardRouting, routingAllocation));  
import org.opensearch.cluster.routing.allocation.decider.ResizeAllocationDecider;
                .settings(
        assertEquals(
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;  
        Metadata metadata = metaBuilder.build();  
        int sourceShardId = IndexMetadata.selectSplitShard(shardId, clusterState.metadata().index("source"), 4).id();  
        );
        );
                    .getExplanation()  
            .metadata(metadata)  
        );
        Index idx = clusterState.metadata().index("target").getIndex();
                        .put(IndexMetadata.INDEX_RESIZE_SOURCE_UUID_KEY, IndexMetadata.INDEX_UUID_NA_VALUE)  
        );  
        metaBuilder.put(
            assertEquals(routingTable.index("source").shards().size(), 2);  
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
import org.opensearch.cluster.routing.allocation.decider.Decision;  
                "source primary is allocated on another node",  
        );  
            new TestGatewayAllocator(),
                .getExplanation()
        assertEquals(
        );
 *
import java.util.Collections;
import org.opensearch.snapshots.EmptySnapshotsInfoService;
 *
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder(clusterState.routingTable());  
    }  
            null,
 */  
    }  
                strategy,  
 * not use this file except in compliance with the License.
        assertEquals(routingTable.index("source").shard(1).shards().get(0).state(), INITIALIZING);
        Metadata.Builder metaBuilder = Metadata.builder(clusterState.metadata());
            assertEquals(
            null,  
        } else {  
        Metadata.Builder metaBuilder = Metadata.builder(clusterState.metadata());
        );
 * compatible open source license.
            assertEquals(routingTable.index("source").shard(0).shards().get(0).state(), STARTED);
            IndexMetadata.builder("target")  
 * KIND, either express or implied.  See the License for the
            Decision.ALWAYS,  
 * license agreements. See the NOTICE file distributed with
        metaBuilder.put(
                        .put(IndexMetadata.INDEX_RESIZE_SOURCE_UUID_KEY, IndexMetadata.INDEX_UUID_NA_VALUE)  
            new BalancedShardsAllocator(Settings.EMPTY),  
        clusterState = ClusterState.builder(clusterState).routingTable(routingTableBuilder.build()).metadata(metadata).build();  
        assertEquals("source primary is active", resizeAllocationDecider.canAllocate(shardRouting, routingAllocation).getExplanation());  
import org.opensearch.core.index.Index;  
                resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node2"), routingAllocation)
        }
        assertEquals(Decision.YES, resizeAllocationDecider.canAllocate(shardRouting, routingAllocation));
        int shardId = randomIntBetween(0, 3);
 * Unless required by applicable law or agreed to in writing,
                Decision.YES,  
            EmptySnapshotsInfoService.INSTANCE
        routingAllocation.debugDecision(true);  
                    settings(Version.CURRENT).put(IndexMetadata.INDEX_RESIZE_SOURCE_NAME.getKey(), "source")
            assertEquals(
            .build();
 * The OpenSearch Contributors require contributions made to  
            assertEquals(
            assertEquals(
            clusterState = startShardsAndReroute(
        assertEquals(
        clusterState = ClusterState.builder(clusterState)  
        Index idx = clusterState.metadata().index("target").getIndex();
        );
            Decision.ALWAYS,
import org.opensearch.cluster.routing.ShardRouting;
        RoutingTable routingTable = routingTableBuilder.build();
                "source primary is allocated on this node",
                    settings(Version.CURRENT).put(IndexMetadata.INDEX_RESIZE_SOURCE_NAME.getKey(), "source")
        Metadata metadata = metaBuilder.build();
            IndexMetadata.builder("source")  
        ResizeAllocationDecider resizeAllocationDecider = new ResizeAllocationDecider();  
        ClusterState clusterState = createInitialClusterState(true);  
        ShardRouting shardRouting = TestShardRouting.newShardRouting("non-resize", 0, null, true, ShardRoutingState.UNASSIGNED);  
                resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node1"), routingAllocation)
    public void setUp() throws Exception {
            RecoverySource.LocalShardsRecoverySource.INSTANCE  
            assertEquals(
                    .getExplanation()
                .numberOfShards(1)
        routingTableBuilder.addAsNew(metadata.index("target"));
            routingTable = clusterState.routingTable();
    public void testSourceNotActive() {
/*
                )
            );
            assertEquals(  
    public void testShrink() { // we don't handle shrink yet
            );  
        assertEquals(prevRoutingTable.index("source").shards().size(), 2);
    public void testNonResizeRouting() {
                    settings(Version.CURRENT).put(IndexMetadata.INDEX_RESIZE_SOURCE_NAME.getKey(), "source")
        );
        assertEquals(
        routingTableBuilder.addAsNew(metadata.index("source"));
            null,  
                "source primary is allocated on this node",
        assertEquals(prevRoutingTable.index("source").shard(0).shards().get(0).state(), UNASSIGNED);
        Metadata metadata = metaBuilder.build();
        clusterState = ClusterState.builder(clusterState).routingTable(routingTableBuilder.build()).metadata(metadata).build();  
            new AllocationDeciders(Collections.singleton(new ResizeAllocationDecider())),
            resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node1"), routingAllocation)
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.cluster.metadata.Metadata;  
                .numberOfShards(4)
                resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node1"), routingAllocation)  
            resizeAllocationDecider.canAllocate(shardRouting, routingAllocation).getExplanation()  
        int shardId = randomIntBetween(0, 3);
                resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node1"), routingAllocation)
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        }  
                clusterState,
        metaBuilder.put(
            assertEquals(
 *  
 */
        assertEquals(routingTable.index("source").shards().size(), 2);
            ShardRoutingState.UNASSIGNED,
                )
        assertEquals(Decision.NO, resizeAllocationDecider.canAllocate(shardRouting, routingAllocation));
 * GitHub history for details.
            );
            resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node0"), routingAllocation)
                "source primary is allocated on another node",  
            "source primary shard [[source][" + sourceShardId + "]] is not active",  
 * the Apache License, Version 2.0 (the "License"); you may
        super.setUp();
                resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node1"), routingAllocation)  
            ShardRoutingState.UNASSIGNED,  
        ShardRouting shardRouting = TestShardRouting.newShardRouting(
        String allowedNode = clusterState.getRoutingTable().index("source").shard(sourceShardId).primaryShard().currentNodeId();
            );
            Decision.NO,
        RoutingAllocation routingAllocation = new RoutingAllocation(null, null, clusterState, null, null, 0);
 * Modifications Copyright OpenSearch Contributors. See  
        Metadata.Builder metaBuilder = Metadata.builder();
            .routingTable(routingTable)
        RoutingAllocation routingAllocation = new RoutingAllocation(null, null, clusterState, null, null, 0);
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder(clusterState.routingTable());  
        );  
        if (startShards) {
                .numberOfShards(2)
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        ClusterState clusterState = createInitialClusterState(true);  
        clusterState = ClusterState.builder(clusterState).routingTable(routingTableBuilder.build()).metadata(metadata).build();  
            IndexMetadata.builder("target")  
            resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node2"), routingAllocation)  
 * You may obtain a copy of the License at  
 * under the License.  
 */
            new ShardId(idx, shardId),
                .settings(
        );
 * Licensed to Elasticsearch under one or more contributor  
            new ShardId(idx, shardId),
                .settings(settings(Version.CURRENT))
                .numberOfReplicas(0)  
import org.opensearch.test.gateway.TestGatewayAllocator;  
import org.opensearch.cluster.ClusterName;
            resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node1"), routingAllocation)  
            Decision.NO,
                )
                Decision.NO,
        routingTableBuilder.addAsNew(metadata.index("target"));
        );
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder(clusterState.routingTable());  
                routingTable.index("source").shard(0).shards().get(0),
                .numberOfReplicas(0)  
        assertEquals(
            ShardRoutingState.UNASSIGNED,
            resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node2"), routingAllocation)
        RoutingAllocation routingAllocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, null, null, 0);
    }  
 * specific language governing permissions and limitations
/*  
import org.opensearch.cluster.ClusterState;
        if ("node1".equals(allowedNode)) {
                Decision.YES,
        metaBuilder.put(
    @Override  
        ShardRouting shardRouting = TestShardRouting.newShardRouting(
            true,
            );
/*
        ShardRouting shardRouting = TestShardRouting.newShardRouting(
import org.opensearch.cluster.routing.TestShardRouting;  
                .setRoutingNumShards(16)
        Metadata.Builder metaBuilder = Metadata.builder(clusterState.metadata());
                    .getExplanation()
            resizeAllocationDecider.canAllocate(shardRouting, clusterState.getRoutingNodes().node("node1"), routingAllocation)
            IndexMetadata.builder("target")  
            assertEquals(routingTable.index("source").shard(1).shards().get(0).state(), STARTED);
