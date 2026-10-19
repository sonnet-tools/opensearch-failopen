        ShardRouting sr = ShardRouting.newUnassigned(
            allocation  
import org.opensearch.cluster.metadata.Metadata;
        assertEquals(routingTable.index("idx").shard(0).primaryShard().state(), INITIALIZING);
        decision = (Decision.Single) filterAllocationDecider.canAllocate(
        assertEquals(explanation1, decision.getExplanation());  
                .put("index.routing.allocation.exclude._tier", "data_cold")  
        routingTableBuilder.addAsNew(indexMetadata);
        RoutingAllocation allocation = new RoutingAllocation(allocationDeciders, state.getRoutingNodes(), state, null, null, 0);
            new BalancedShardsAllocator(Settings.EMPTY),
/*
        );
import org.opensearch.test.gateway.TestGatewayAllocator;
                .put("cluster.routing.allocation.require.flag", "flag1")
            routingTable.index("sourceIndex").shard(0).shardId(),  
        ClusterState state = createInitialClusterState(service, Settings.EMPTY, Settings.EMPTY);  
            state.getRoutingNodes().node("node2"),  
            .numberOfShards(2)
        FilterAllocationDecider filterAllocationDecider = new FilterAllocationDecider(initialSettings, clusterSettings);
        final Type type1,
 * this file be licensed under the Apache-2.0 license or a
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        );
        DiscoveryNode node1 = state.nodes().resolveNode("node1");
        );  
    public void testTierFilterIgnored() {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
        assertEquals(Type.YES, decision.type());
            .metadata(metadata)
                "test ip validation"
        assertEquals(decision.toString(), Type.YES, decision.type());  
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
        assertEquals(routingTable.index("idx").shard(0).replicaShards().get(0).state(), INITIALIZING);  
                .build()  
        state = startShardsAndReroute(service, state, routingTable.index("idx").shard(0).replicaShardsWithState(INITIALIZING));
    }
        routingTableBuilder.addAsFromCloseToOpen(sourceIndex);  
                decision.getExplanation()
import org.opensearch.Version;  
        RoutingTable routingTable = state.routingTable();
        RoutingTable routingTable = routingTableBuilder.build();  
            indexScopedSettings.updateDynamicSettings(  
        );
        );  
            .numberOfShards(2)  
        sr = ShardRouting.newUnassigned(
        final Settings.Builder indexSettings = settings(Version.CURRENT).put(idxSettings);
                new ReplicaAfterPrimaryActiveAllocationDecider()
            .put(MIGRATION_DIRECTION_SETTING.getKey(), RemoteStoreNodeService.Direction.REMOTE_STORE)  
            EmptyClusterInfoService.INSTANCE,  
        final IndexMetadata indexMetadata = indexMetadataBuilder.build();  
                new SameShardAllocationDecider(Settings.EMPTY, clusterSettings),
        FilterAllocationDecider filterAllocationDecider = new FilterAllocationDecider(Settings.EMPTY, clusterSettings);  
            service,
                "initial allocation of the shrunken index is only allowed on nodes [_id:\"node2\"] that "  
        final IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder("idx")
 *
            Arrays.asList(
    }  
        assertEquals("node passes include/exclude/require filters", decision.getExplanation());
        // we can initially only allocate on node2  
/*  
        // now bring back node1 and see it's assigned
            routingTable.index("idx").shard(0).shards().get(0),
            allocationDeciders,  
        allocation.debugDecision(true);
 * Modifications Copyright OpenSearch Contributors. See  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newSearchNode("node2")))  
            Settings.builder()
            .routingTable(routingTable)  
        // after failing the shard we are unassigned since the node is denylisted and we can't initialize on the other node
            allocationDeciders,  
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;  
import org.opensearch.cluster.routing.RecoverySource;
        );
            .numberOfShards(1)
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
    public void testFilterUpdateAddNew() {  
        assertEquals(routingTable.index("idx").shard(0).shards().get(0).state(), INITIALIZING);
import org.opensearch.node.remotestore.RemoteStoreNodeService;
            "node does not match cluster setting [cluster.routing.allocation.require] filters [zone:\"zone1\",attr:\"attr1\"]"
                .put("cluster.routing.allocation.require.attr", "")
        );
 * You may obtain a copy of the License at  
        );  
        );
            .settings(settings(Version.CURRENT).putNull(filterSetting.getKey() + "name"))  
            Arrays.asList(
            allocation
            routingTable.index("idx").shard(0).shards().get(0),
            routingTable.index("idx").shard(0).shards().get(0),  
        assertEquals("node passes include/exclude/require filters", decision.getExplanation());
            IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_SETTING,  
                .build(),  
        assertEquals("node passes include/exclude/require filters", decision.getExplanation());  
        state = ClusterState.builder(state).routingTable(routingTable).build();
        String ipKey = randomFrom("_ip", "_host_ip", "_publish_ip");  
 * this work for additional information regarding copyright
        allocation.debugDecision(true);
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
            EmptyClusterInfoService.INSTANCE,  
            allocation
    }
            Settings.builder()  
import java.util.Collections;
            Settings.builder()
            Arrays.asList(
            .numberOfReplicas(1);
        // For mixed mode remote store direction cluster's existing indices replica creation ,  
 *
        );
            new UnassignedInfo(UnassignedInfo.Reason.NODE_LEFT, "")
        );  
 * under the License.  
    static ClusterState createInitialClusterState(AllocationService service, Settings idxSettings, Settings clusterSettings) {
            Settings.builder().put("index.routing.allocation.initial_recovery._id", "node2").build()
        metadata.persistentSettings(clusterSettings);  
            Settings.builder()
        );
            Type.NO,  
        RoutingAllocation allocation = new RoutingAllocation(allocationDeciders, state.getRoutingNodes(), state, null, null, 0);  
import org.opensearch.cluster.routing.ShardRouting;
        if (primaryShard.recoverySource().getType() == RecoverySource.Type.LOCAL_SHARDS) {
        allocation = new RoutingAllocation(allocationDeciders, state.getRoutingNodes(), state, null, null, 0);
            "test"  
    }  
            new TestGatewayAllocator(),
            Type.NO,
                new ReplicaAfterPrimaryActiveAllocationDecider()
                .build(),
    }
        } else {
            IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING,
        );  
            .build();
        AllocationDeciders allocationDeciders = new AllocationDeciders(
        assertEquals(routingTable.index("idx").shard(0).shards().get(0).currentNodeId(), "node2");
    private void filterSettingsUpdateHelper(
        metadata.put(sourceIndex, false);
        );
 *  
            routingTable.index("idx").shard(0).shards().get(0),
        assertEquals(routingTable.index("idx").shard(0).primaryShard().state(), INITIALIZING);
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;  
    public void testInvalidIPFilter() {
    public void testFilterInitialRecovery() {
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_RESIZE_SOURCE_NAME;  
        final Type type2,
            IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_SETTING
        );
    public void testNull() {
            routingTable.index("idx").shard(0).primaryShard(),
            Settings.builder().put("cluster.routing.allocation.require.attr", "attr1").build(),
                .put("cluster.routing.allocation.require._tier_preference", "hot")  
import org.opensearch.cluster.ClusterState;
            state.getRoutingNodes().node("node2"),
                new SameShardAllocationDecider(Settings.EMPTY, clusterSettings),
/*
            routingTable.index("sourceIndex").shard(0).shardId(),
        String ipKey = randomFrom("_ip", "_host_ip", "_publish_ip");
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
            false,
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertEquals(decision.toString(), Type.YES, decision.type());  
            sr,
        routingTable = state.routingTable();  
            .build();
        );
        );
        Decision.Single decision = (Decision.Single) filterAllocationDecider.canAllocate(  
        assertEquals(routingTable.index("idx").shard(0).replicaShards().get(0).currentNodeId(), "node1");
            new TestGatewayAllocator(),
            )  
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
            "node does not match cluster setting [cluster.routing.allocation.require] filters [flag:\"flag1\",zone:\"zone1\"]",
import org.opensearch.cluster.metadata.IndexMetadata;
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.settings.Setting;  
                .build(),  
        allocation.debugDecision(true);
        allocation.debugDecision(true);  
        assertEquals(decision.toString(), type1, decision.type());
        // first create another copy
            true,
        clusterState = ClusterState.builder(clusterState)
 */
        AllocationService service = new AllocationService(
        assertEquals(routingTable.index("idx").shard(0).replicaShards().get(0).state(), STARTED);
        final IndexMetadata sourceIndex;
        state = service.reroute(state, "try allocate again");
 * software distributed under the License is distributed on an
            allocation  
    }
            IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING,  
        decision = (Decision.Single) filterAllocationDecider.canAllocate(
    }  
        decision = (Decision.Single) filterAllocationDecider.canAllocate(sr, state.getRoutingNodes().node("node2"), allocation);
            EmptySnapshotsInfoService.INSTANCE
 * KIND, either express or implied.  See the License for the
            new TestGatewayAllocator(),  
                new SameShardAllocationDecider(Settings.EMPTY, clusterSettings),
        AllocationDeciders allocationDeciders = new AllocationDeciders(  
            allocation
            IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING,
            .numberOfReplicas(0)
        assertEquals(routingTable.index("idx").shard(0).primaryShard().currentNodeId(), "node1");
        AllocationService service = new AllocationService(
            IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_SETTING,  
            .putInSyncAllocationIds(1, Collections.singleton("aid1"))  
        Decision.Single decision = (Decision.Single) filterAllocationDecider.canAllocate(
            routingTable.index("idx").shard(0).shards().get(0),
            EmptyClusterInfoService.INSTANCE,  
            Arrays.asList(
            IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_SETTING
        routingTable = state.routingTable();  
            );
import org.opensearch.cluster.routing.allocation.decider.Decision.Type;  
        indexScopedSettings.updateDynamicSettings(  
        // now remove the node of the other copy and fail the current
import org.opensearch.common.settings.ClusterSettings;
        assertEquals(Type.YES, decision.type());
        String wildcardIP = randomFrom("192.168.*", "192.*.1.1");
        );
        decision = (Decision.Single) filterAllocationDecider.canAllocate(  
                .put("cluster.routing.allocation.require.attr", "attr1")
        String invalidIP = randomFrom("192..168.1.1", "192.300.1.1");  
import java.util.Arrays;  
        assertEquals(Type.YES, decision.type());
        // put a fake closed source index  
                filterAllocationDecider,
            )  
            RecoverySource.PeerRecoverySource.INSTANCE,
        final String explanation2
            "node passes include/exclude/require filters"
        Settings initialSettings = Settings.builder()  
        final String explanation1,
import org.opensearch.cluster.routing.UnassignedInfo;
            EmptySnapshotsInfoService.INSTANCE
}
            service,
        ShardRouting primaryShard = routingTable.index("idx").shard(0).primaryShard();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.settings.Settings;
 * GitHub history for details.
                .put("cluster.routing.allocation.exclude._tier", "data_cold")
        decision = (Decision.Single) filterAllocationDecider.canAllocate(  
        );  
        routingTable = state.routingTable();
        filterSettingsUpdateHelper(
            routingTable.index("idx").shard(0).primaryShard(),  
        AllocationDeciders allocationDeciders = new AllocationDeciders(
            .settings(indexSettings)  
    ) {  
        assertEquals(Type.NO, decision.type());  
            Settings.builder()  
            IndexScopedSettings indexScopedSettings = new IndexScopedSettings(Settings.EMPTY, IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);
        Decision.Single decision = (Decision.Single) filterAllocationDecider.canAllocate(
        routingTable = state.routingTable();  
 * Licensed to Elasticsearch under one or more contributor  
            );  
            )
        ClusterState state = createInitialClusterState(  
        decision = (Decision.Single) filterAllocationDecider.canAllocate(
        indexSettings.put(INDEX_RESIZE_SOURCE_NAME.getKey(), sourceIndex.getIndex().getName());
            new BalancedShardsAllocator(Settings.EMPTY),
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.MIXED)
    }
            EmptySnapshotsInfoService.INSTANCE
                .put("cluster.routing.allocation.require.zone", "zone1")
 * The OpenSearch Contributors require contributions made to  
            Type.NO,
 * ownership. Elasticsearch licenses this file to you under  
            state.getRoutingNodes().node("node1"),
        ClusterState state = createInitialClusterState(service, Settings.EMPTY, Settings.EMPTY);
        assertEquals(decision.toString(), type2, decision.type());
        filterSettingsUpdateHelper(
    }
    private ClusterState createInitialClusterState(AllocationService service, Settings indexSettings) {  
            allocationDeciders,  
            Type.NO,
        FilterAllocationDecider filterAllocationDecider = new FilterAllocationDecider(initialSettings, clusterSettings);  
        sourceIndex = IndexMetadata.builder("sourceIndex")
            ClusterState.builder(state).nodes(DiscoveryNodes.builder(state.nodes()).remove("node1")).build(),
import org.opensearch.cluster.EmptyClusterInfoService;
        RoutingTable routingTable = state.routingTable();  
    public void testFilterUpdateRemovePartial() {
        state = startShardsAndReroute(service, state, routingTable.index("idx").shard(0).shardsWithState(INITIALIZING));
        FilterAllocationDecider filterAllocationDecider = new FilterAllocationDecider(Settings.EMPTY, clusterSettings);  
            false,  
                .put("index.routing.allocation.include._tier_preference", "data_cold")
        RoutingAllocation allocation = new RoutingAllocation(allocationDeciders, state.getRoutingNodes(), state, null, null, 0);
        return service.reroute(clusterState, "reroute");
        RoutingTable routingTable = state.routingTable();
            RecoverySource.PeerRecoverySource.INSTANCE,
        Setting<String> filterSetting = randomFrom(
        });  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            Settings.builder().put(Settings.EMPTY),
            Type.NO,  
        state = service.reroute(ClusterState.builder(state).nodes(DiscoveryNodes.builder(state.nodes()).add(node1)).build(), "test");
        // we don't consider filter allocation decider for replica of existing indices
        );
            allocation
            .build();
                filterAllocationDecider,  
    }  
        assertEquals("node passes include/exclude/require filters", decision.getExplanation());
        );
                new ReplicaAfterPrimaryActiveAllocationDecider()
                filterAllocationDecider,  
        clusterSettings.applySettings(updatedSettings);
public class FilterAllocationDeciderTests extends OpenSearchAllocationTestCase {
            "test ip validation"
        allocation = new RoutingAllocation(allocationDeciders, state.getRoutingNodes(), state, null, null, 0);
 * SPDX-License-Identifier: Apache-2.0
            allocation
                .put("cluster.routing.allocation.require._tier", "data_cold")  
            Settings.builder()
        RoutingAllocation allocation = new RoutingAllocation(allocationDeciders, state.getRoutingNodes(), state, null, null, 0);  
        assertEquals(routingTable.index("idx").shard(0).replicaShards().get(0).currentNodeId(), "node1");
                .put("index.routing.allocation.require._tier", "data_cold")  
            .settings(settings(Version.CURRENT))
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "")  
            "node does not match cluster setting [cluster.routing.allocation.require] filters [zone:\"zone1\"]"  
            EmptySnapshotsInfoService.INSTANCE  
            new TestGatewayAllocator(),
        Setting<String> filterSetting = randomFrom(
            .putInSyncAllocationIds(0, Collections.singleton("aid0"))
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
            Settings.builder().put("cluster.routing.allocation.require.zone", "zone1").build(),
                .put("index.routing.allocation.include._tier", "data_cold")
    public void testMixedModeRemoteStoreAllocation() {
        assertEquals(decision.toString(), Type.NO, decision.type());  
                .build(),
            assertEquals(
        final Settings initialSettings,  
            state.getRoutingNodes().node("node2"),
        );
        indexSettings.put(INDEX_RESIZE_SOURCE_UUID.getKey(), sourceIndex.getIndexUUID());  
            allocation
        IndexScopedSettings indexScopedSettings = new IndexScopedSettings(Settings.EMPTY, IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);
package org.opensearch.cluster.routing.allocation.decider;
                Settings.builder().put(Settings.EMPTY),
            IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_SETTING
        IndexMetadata.builder("test")
        allocation.debugDecision(true);
        );
            .put("cluster.routing.allocation.exclude._id", "node2")
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_RESIZE_SOURCE_UUID;
                new SameShardAllocationDecider(Settings.EMPTY, clusterSettings),  
        assertNull(routingTable.index("idx").shard(0).shards().get(0).currentNodeId());  
        final Settings updatedSettings,  
        );  
            state.getRoutingNodes().node("node2"),
    public void testFilterUpdateRemoveAll() {
        // ok now we are started and can be allocated anywhere!! lets see...
                Settings.builder(),  
        assertEquals(routingTable.index("idx").shard(0).primaryShard().currentNodeId(), "node2");
 * Unless required by applicable law or agreed to in writing,
                filterAllocationDecider,  
            state.getRoutingNodes().node("node2"),
                Settings.builder().put(filterSetting.getKey() + ipKey, invalidIP).build(),
                new ReplicaAfterPrimaryActiveAllocationDecider()
        state = service.applyFailedShard(state, routingTable.index("idx").shard(0).primaryShard(), randomBoolean());
                .put("cluster.routing.allocation.include._tier", "data_cold")
        assertEquals(explanation2, decision.getExplanation());  
import org.opensearch.snapshots.EmptySnapshotsInfoService;  
            routingTable.index("idx").shard(0).shards().get(0),
    public void testWildcardIPFilter() {  
            .numberOfReplicas(0)
        Decision.Single decision = (Decision.Single) filterAllocationDecider.canAllocate(
 * license agreements. See the NOTICE file distributed with
        return createInitialClusterState(service, indexSettings, Settings.EMPTY);
        AllocationDeciders allocationDeciders = new AllocationDeciders(
        Setting<String> filterSetting = randomFrom(
                .put("cluster.routing.allocation.require.flag", "")
        Metadata.Builder metadata = Metadata.builder();
            Type.YES,
        allocation.debugDecision(true);  
            EmptyClusterInfoService.INSTANCE,
        state = service.disassociateDeadNodes(  
                    + "hold a copy of every shard in the index",
            assertEquals("initial allocation of the index is only allowed on nodes [_id:\"node2\"]", decision.getExplanation());
                .build(),
        );
            state.getRoutingNodes().node("node2"),  
import org.opensearch.cluster.routing.RoutingTable;  
 */  
                .put("cluster.routing.allocation.require.zone", "")
        AllocationService service = new AllocationService(
    }
        assertEquals("invalid IP address [" + invalidIP + "] for [" + filterSetting.getKey() + ipKey + "]", e.getMessage());
            Settings.builder(),  
            allocation  
        }  
        ClusterState state = createInitialClusterState(  
        RoutingTable routingTable = state.routingTable();
                .put("cluster.routing.allocation.require.zone", "zone1")  
        );
        );
            Settings.builder().put(filterSetting.getKey() + ipKey, wildcardIP).build(),
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertEquals("node passes include/exclude/require filters", decision.getExplanation());
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
 */
            .build();  
import org.opensearch.common.settings.IndexScopedSettings;
 * compatible open source license.
        AllocationService service = new AllocationService(
            allocationDeciders,
            "node does not match cluster setting [cluster.routing.allocation.require] filters [zone:\"zone1\",attr:\"attr1\"]",  
        routingTable = service.applyFailedShard(state, routingTable.index("idx").shard(0).shards().get(0), randomBoolean()).routingTable();  
            IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_SETTING,
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
        assertEquals(routingTable.index("idx").shard(0).shards().get(0).state(), UNASSIGNED);
import org.opensearch.cluster.node.DiscoveryNodes;
            "node does not match cluster setting [cluster.routing.allocation.require] filters [attr:\"attr1\"]",
import org.opensearch.cluster.node.DiscoveryNode;  
            new BalancedShardsAllocator(Settings.EMPTY),
        filterSettingsUpdateHelper(  
 * specific language governing permissions and limitations
        metadata.put(indexMetadata, false);
        assertEquals(Type.YES, decision.type());  
        ClusterSettings clusterSettings = new ClusterSettings(initialSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            new BalancedShardsAllocator(Settings.EMPTY),
            )  
import org.opensearch.cluster.routing.allocation.AllocationService;  
    }
        );
            .build();
            state.getRoutingNodes().node("node1"),  
            state.getRoutingNodes().node("node1"),  
        );  
