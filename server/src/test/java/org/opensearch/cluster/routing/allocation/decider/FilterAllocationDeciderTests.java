import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
            IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_SETTING,
import org.opensearch.cluster.routing.allocation.decider.Decision.Type;
        assertEquals(routingTable.index("idx").shard(0).primaryShard().state(), INITIALIZING);
            assertEquals("initial allocation of the index is only allowed on nodes [_id:\"node2\"]", decision.getExplanation());
        routingTable = state.routingTable();
    ) {
    public void testInvalidIPFilter() {
        metadata.put(sourceIndex, false);
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
            IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING,
            Type.NO,
        // now bring back node1 and see it's assigned
        RoutingAllocation allocation = new RoutingAllocation(allocationDeciders, state.getRoutingNodes(), state, null, null, 0);
    }
            Arrays.asList(
        final Type type2,
        // we don't consider filter allocation decider for replica of existing indices
                Settings.builder().put(Settings.EMPTY),
            .put(MIGRATION_DIRECTION_SETTING.getKey(), RemoteStoreNodeService.Direction.REMOTE_STORE)
        state = service.disassociateDeadNodes(
        final String explanation1,
    public void testFilterInitialRecovery() {
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            ClusterState.builder(state).nodes(DiscoveryNodes.builder(state.nodes()).remove("node1")).build(),
            indexScopedSettings.updateDynamicSettings(
        final IndexMetadata indexMetadata = indexMetadataBuilder.build();
        Decision.Single decision = (Decision.Single) filterAllocationDecider.canAllocate(
            RecoverySource.PeerRecoverySource.INSTANCE,
        state = service.reroute(state, "try allocate again");
    public void testFilterUpdateRemovePartial() {
        assertEquals(decision.toString(), type2, decision.type());
        );
        state = startShardsAndReroute(service, state, routingTable.index("idx").shard(0).replicaShardsWithState(INITIALIZING));
                .build(),
            EmptyClusterInfoService.INSTANCE,
                .build(),
        String wildcardIP = randomFrom("192.168.*", "192.*.1.1");
            IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING,
        AllocationDeciders allocationDeciders = new AllocationDeciders(
            new BalancedShardsAllocator(Settings.EMPTY),
        assertEquals("node passes include/exclude/require filters", decision.getExplanation());
                .put("cluster.routing.allocation.exclude._tier", "data_cold")
        IndexScopedSettings indexScopedSettings = new IndexScopedSettings(Settings.EMPTY, IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);
 */
        filterSettingsUpdateHelper(
        assertNull(routingTable.index("idx").shard(0).shards().get(0).currentNodeId());
        final Settings initialSettings,
            routingTable.index("idx").shard(0).primaryShard(),
        final IndexMetadata sourceIndex;
        );
        // put a fake closed source index
    public void testWildcardIPFilter() {
import org.opensearch.common.settings.ClusterSettings;
            .settings(settings(Version.CURRENT))
        IndexMetadata.builder("test")
        );
        assertEquals(routingTable.index("idx").shard(0).replicaShards().get(0).state(), INITIALIZING);
            IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING,
    }
        routingTable = state.routingTable();
    private void filterSettingsUpdateHelper(
            .metadata(metadata)
            allocation
        state = service.reroute(ClusterState.builder(state).nodes(DiscoveryNodes.builder(state.nodes()).add(node1)).build(), "test");
                .put("index.routing.allocation.exclude._tier", "data_cold")
        Setting<String> filterSetting = randomFrom(
                .put("cluster.routing.allocation.include._tier", "data_cold")
        RoutingTable routingTable = routingTableBuilder.build();
            Settings.builder()
 * under the License.
                new ReplicaAfterPrimaryActiveAllocationDecider()
        filterSettingsUpdateHelper(
package org.opensearch.cluster.routing.allocation.decider;
            assertEquals(
        String ipKey = randomFrom("_ip", "_host_ip", "_publish_ip");
        assertEquals(decision.toString(), type1, decision.type());
        );
        return service.reroute(clusterState, "reroute");
                filterAllocationDecider,
        Decision.Single decision = (Decision.Single) filterAllocationDecider.canAllocate(
            allocation
        assertEquals(routingTable.index("idx").shard(0).shards().get(0).currentNodeId(), "node2");
            sr,
        indexSettings.put(INDEX_RESIZE_SOURCE_UUID.getKey(), sourceIndex.getIndexUUID());
            .build();
            state.getRoutingNodes().node("node2"),
        decision = (Decision.Single) filterAllocationDecider.canAllocate(
        RoutingAllocation allocation = new RoutingAllocation(allocationDeciders, state.getRoutingNodes(), state, null, null, 0);
    }
            routingTable.index("idx").shard(0).shards().get(0),
            .numberOfReplicas(1);
    }
        state = startShardsAndReroute(service, state, routingTable.index("idx").shard(0).shardsWithState(INITIALIZING));
        indexSettings.put(INDEX_RESIZE_SOURCE_NAME.getKey(), sourceIndex.getIndex().getName());
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.snapshots.EmptySnapshotsInfoService;
        assertEquals(decision.toString(), Type.NO, decision.type());
 * The OpenSearch Contributors require contributions made to
                "initial allocation of the shrunken index is only allowed on nodes [_id:\"node2\"] that "
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        return createInitialClusterState(service, indexSettings, Settings.EMPTY);
            .build();
            allocationDeciders,
        );
            IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_SETTING,
/*
            routingTable.index("idx").shard(0).shards().get(0),
        assertEquals(Type.YES, decision.type());
        assertEquals(Type.NO, decision.type());
import org.opensearch.common.settings.IndexScopedSettings;
                new ReplicaAfterPrimaryActiveAllocationDecider()
            .build();
                .put("cluster.routing.allocation.require.flag", "")
            EmptySnapshotsInfoService.INSTANCE
            .routingTable(routingTable)
        assertEquals("node passes include/exclude/require filters", decision.getExplanation());
            .numberOfShards(1)
            )
import org.opensearch.cluster.ClusterState;
        AllocationService service = new AllocationService(
            IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_SETTING,
        assertEquals(routingTable.index("idx").shard(0).primaryShard().state(), INITIALIZING);
            new BalancedShardsAllocator(Settings.EMPTY),
public class FilterAllocationDeciderTests extends OpenSearchAllocationTestCase {
import java.util.Arrays;
        // now remove the node of the other copy and fail the current
            "test"
                .put("index.routing.allocation.include._tier", "data_cold")
        assertEquals(routingTable.index("idx").shard(0).shards().get(0).state(), INITIALIZING);
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "")
        DiscoveryNode node1 = state.nodes().resolveNode("node1");
        AllocationDeciders allocationDeciders = new AllocationDeciders(
 * You may obtain a copy of the License at
    static ClusterState createInitialClusterState(AllocationService service, Settings idxSettings, Settings clusterSettings) {
                .put("cluster.routing.allocation.require.zone", "zone1")
                .build(),
            allocation
            routingTable.index("idx").shard(0).shards().get(0),
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
        assertEquals("node passes include/exclude/require filters", decision.getExplanation());
            "node does not match cluster setting [cluster.routing.allocation.require] filters [zone:\"zone1\",attr:\"attr1\"]"
            Settings.builder()
            Settings.builder().put("cluster.routing.allocation.require.zone", "zone1").build(),
                new ReplicaAfterPrimaryActiveAllocationDecider()
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .settings(indexSettings)
            Settings.builder().put(Settings.EMPTY),
        assertEquals(decision.toString(), Type.YES, decision.type());
        final Settings updatedSettings,
            )
        );
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            new TestGatewayAllocator(),
        FilterAllocationDecider filterAllocationDecider = new FilterAllocationDecider(initialSettings, clusterSettings);
        RoutingTable routingTable = state.routingTable();
        routingTable = state.routingTable();
 *
 * GitHub history for details.
        allocation = new RoutingAllocation(allocationDeciders, state.getRoutingNodes(), state, null, null, 0);
    public void testTierFilterIgnored() {
            service,
        sr = ShardRouting.newUnassigned(
 *     http://www.apache.org/licenses/LICENSE-2.0
                .put("cluster.routing.allocation.require.zone", "zone1")
        );
        Setting<String> filterSetting = randomFrom(
            allocationDeciders,
            routingTable.index("sourceIndex").shard(0).shardId(),
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_RESIZE_SOURCE_UUID;
            state.getRoutingNodes().node("node2"),
import org.opensearch.cluster.EmptyClusterInfoService;
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
            allocation
            Arrays.asList(
                .build(),
                .put("cluster.routing.allocation.require._tier_preference", "hot")
                new ReplicaAfterPrimaryActiveAllocationDecider()
                .put("cluster.routing.allocation.require.attr", "")
        state = ClusterState.builder(state).routingTable(routingTable).build();
        Metadata.Builder metadata = Metadata.builder();
        AllocationService service = new AllocationService(
                decision.getExplanation()
import org.opensearch.cluster.routing.allocation.AllocationService;
        ClusterSettings clusterSettings = new ClusterSettings(initialSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            Arrays.asList(
        filterSettingsUpdateHelper(
        allocation.debugDecision(true);
    }
 * software distributed under the License is distributed on an
        );
        AllocationDeciders allocationDeciders = new AllocationDeciders(
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            Settings.builder().put(filterSetting.getKey() + ipKey, wildcardIP).build(),
import org.opensearch.cluster.routing.UnassignedInfo;
            routingTable.index("idx").shard(0).shards().get(0),
            Type.YES,
        final String explanation2
        );
        decision = (Decision.Single) filterAllocationDecider.canAllocate(
            Settings.builder()
 * compatible open source license.
    }
            .settings(settings(Version.CURRENT).putNull(filterSetting.getKey() + "name"))
        );
                .put("cluster.routing.allocation.require.attr", "attr1")
        );
            "node does not match cluster setting [cluster.routing.allocation.require] filters [zone:\"zone1\"]"
            IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_SETTING
        );
        // we can initially only allocate on node2
            new BalancedShardsAllocator(Settings.EMPTY),
            state.getRoutingNodes().node("node2"),
        assertEquals(routingTable.index("idx").shard(0).primaryShard().currentNodeId(), "node2");
            Settings.builder()
        );
        allocation.debugDecision(true);
        RoutingTable routingTable = state.routingTable();
    public void testNull() {
            service,
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        routingTableBuilder.addAsNew(indexMetadata);
        final Settings.Builder indexSettings = settings(Version.CURRENT).put(idxSettings);
import org.opensearch.cluster.node.DiscoveryNode;
        routingTableBuilder.addAsFromCloseToOpen(sourceIndex);
        AllocationDeciders allocationDeciders = new AllocationDeciders(
        assertEquals("invalid IP address [" + invalidIP + "] for [" + filterSetting.getKey() + ipKey + "]", e.getMessage());
        sourceIndex = IndexMetadata.builder("sourceIndex")
            .numberOfReplicas(0)
        }
        RoutingTable routingTable = state.routingTable();
        decision = (Decision.Single) filterAllocationDecider.canAllocate(
            "node does not match cluster setting [cluster.routing.allocation.require] filters [flag:\"flag1\",zone:\"zone1\"]",
 */
            allocation
        );
        );
            state.getRoutingNodes().node("node2"),
        assertEquals(decision.toString(), Type.YES, decision.type());
 * SPDX-License-Identifier: Apache-2.0
        RoutingAllocation allocation = new RoutingAllocation(allocationDeciders, state.getRoutingNodes(), state, null, null, 0);
                .put("index.routing.allocation.include._tier_preference", "data_cold")
        decision = (Decision.Single) filterAllocationDecider.canAllocate(sr, state.getRoutingNodes().node("node2"), allocation);
            .numberOfShards(2)
        );
        assertEquals(explanation1, decision.getExplanation());
            state.getRoutingNodes().node("node2"),
            IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_SETTING
        indexScopedSettings.updateDynamicSettings(
        RoutingTable routingTable = state.routingTable();
        );
                new SameShardAllocationDecider(Settings.EMPTY, clusterSettings),
            Arrays.asList(
            Settings.builder(),
import org.opensearch.common.settings.Setting;
                .build()
                new SameShardAllocationDecider(Settings.EMPTY, clusterSettings),
        // first create another copy
import org.opensearch.cluster.node.DiscoveryNodes;
            state.getRoutingNodes().node("node2"),
        ClusterState state = createInitialClusterState(service, Settings.EMPTY, Settings.EMPTY);
        });
        ClusterState state = createInitialClusterState(service, Settings.EMPTY, Settings.EMPTY);
                filterAllocationDecider,
            Type.NO,
            )
 *
        allocation.debugDecision(true);
            Type.NO,
        ClusterState state = createInitialClusterState(
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
        );
    public void testFilterUpdateAddNew() {
            allocation
        decision = (Decision.Single) filterAllocationDecider.canAllocate(
                Settings.builder().put(filterSetting.getKey() + ipKey, invalidIP).build(),
            new TestGatewayAllocator(),
        state = service.applyFailedShard(state, routingTable.index("idx").shard(0).primaryShard(), randomBoolean());
        );
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
import org.opensearch.cluster.metadata.IndexMetadata;
        AllocationService service = new AllocationService(
/*
        allocation.debugDecision(true);
            new BalancedShardsAllocator(Settings.EMPTY),
import org.opensearch.cluster.metadata.Metadata;
            EmptySnapshotsInfoService.INSTANCE
            )
            routingTable.index("idx").shard(0).primaryShard(),
        assertEquals(routingTable.index("idx").shard(0).primaryShard().currentNodeId(), "node1");
            routingTable.index("sourceIndex").shard(0).shardId(),
            allocation
    }
    }
        assertEquals(explanation2, decision.getExplanation());
        assertEquals("node passes include/exclude/require filters", decision.getExplanation());
 * ownership. Elasticsearch licenses this file to you under
        assertEquals(routingTable.index("idx").shard(0).replicaShards().get(0).currentNodeId(), "node1");
                .put("cluster.routing.allocation.require.zone", "")
        final IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder("idx")
/*
            "node passes include/exclude/require filters"
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
            Type.NO,
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.routing.ShardRouting;
                .put("index.routing.allocation.require._tier", "data_cold")
        );
 * this file be licensed under the Apache-2.0 license or a
    }
                .build(),
            EmptyClusterInfoService.INSTANCE,
        ShardRouting primaryShard = routingTable.index("idx").shard(0).primaryShard();
        Decision.Single decision = (Decision.Single) filterAllocationDecider.canAllocate(
            EmptyClusterInfoService.INSTANCE,
            Type.NO,
        routingTable = state.routingTable();
        clusterState = ClusterState.builder(clusterState)
            Settings.builder()
            routingTable.index("idx").shard(0).shards().get(0),
            allocation
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_RESIZE_SOURCE_NAME;
        decision = (Decision.Single) filterAllocationDecider.canAllocate(
    private ClusterState createInitialClusterState(AllocationService service, Settings indexSettings) {
 * specific language governing permissions and limitations
            IndexScopedSettings indexScopedSettings = new IndexScopedSettings(Settings.EMPTY, IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);
 * Licensed to Elasticsearch under one or more contributor
            false,
        assertEquals(Type.YES, decision.type());
                .put("cluster.routing.allocation.require.flag", "flag1")
        FilterAllocationDecider filterAllocationDecider = new FilterAllocationDecider(Settings.EMPTY, clusterSettings);
            .build();
            );
        );
        ShardRouting sr = ShardRouting.newUnassigned(
        Setting<String> filterSetting = randomFrom(
import java.util.Collections;
            state.getRoutingNodes().node("node1"),
    }
        String ipKey = randomFrom("_ip", "_host_ip", "_publish_ip");
                filterAllocationDecider,
        ClusterState state = createInitialClusterState(
        // ok now we are started and can be allocated anywhere!! lets see...
        Settings initialSettings = Settings.builder()
                "test ip validation"
        RoutingAllocation allocation = new RoutingAllocation(allocationDeciders, state.getRoutingNodes(), state, null, null, 0);
        );
        assertEquals(routingTable.index("idx").shard(0).replicaShards().get(0).state(), STARTED);
    }
        FilterAllocationDecider filterAllocationDecider = new FilterAllocationDecider(initialSettings, clusterSettings);
            EmptySnapshotsInfoService.INSTANCE
 * license agreements. See the NOTICE file distributed with
            .numberOfReplicas(0)
            EmptySnapshotsInfoService.INSTANCE
            .build();
            .putInSyncAllocationIds(1, Collections.singleton("aid1"))
        );
            state.getRoutingNodes().node("node1"),
            Settings.builder()
        if (primaryShard.recoverySource().getType() == RecoverySource.Type.LOCAL_SHARDS) {
 */
import org.opensearch.cluster.routing.RecoverySource;
            allocationDeciders,
        );
        assertEquals(Type.YES, decision.type());
            "node does not match cluster setting [cluster.routing.allocation.require] filters [attr:\"attr1\"]",
}
        // For mixed mode remote store direction cluster's existing indices replica creation ,
        assertEquals(Type.YES, decision.type());
                filterAllocationDecider,
            new UnassignedInfo(UnassignedInfo.Reason.NODE_LEFT, "")
            Settings.builder().put("cluster.routing.allocation.require.attr", "attr1").build(),
            .numberOfShards(2)
            false,
            "test ip validation"
        metadata.put(indexMetadata, false);
            new TestGatewayAllocator(),
        allocation.debugDecision(true);
        );
        clusterSettings.applySettings(updatedSettings);
import org.opensearch.test.gateway.TestGatewayAllocator;
        // after failing the shard we are unassigned since the node is denylisted and we can't initialize on the other node
            IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_SETTING
        assertEquals(routingTable.index("idx").shard(0).replicaShards().get(0).currentNodeId(), "node1");
                new SameShardAllocationDecider(Settings.EMPTY, clusterSettings),
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        );
 * Modifications Copyright OpenSearch Contributors. See
            allocation
                    + "hold a copy of every shard in the index",
 * KIND, either express or implied.  See the License for the
        final Type type1,
 *
        allocation.debugDecision(true);
        );
        FilterAllocationDecider filterAllocationDecider = new FilterAllocationDecider(Settings.EMPTY, clusterSettings);
    public void testFilterUpdateRemoveAll() {
        } else {
        assertEquals(routingTable.index("idx").shard(0).shards().get(0).state(), UNASSIGNED);
import org.opensearch.node.remotestore.RemoteStoreNodeService;
                .put("cluster.routing.allocation.require._tier", "data_cold")
        assertEquals("node passes include/exclude/require filters", decision.getExplanation());
            );
            true,
            allocationDeciders,
            RecoverySource.PeerRecoverySource.INSTANCE,
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newSearchNode("node2")))
        String invalidIP = randomFrom("192..168.1.1", "192.300.1.1");
        metadata.persistentSettings(clusterSettings);
            Settings.builder().put("index.routing.allocation.initial_recovery._id", "node2").build()
                Settings.builder(),
            routingTable.index("idx").shard(0).shards().get(0),
        Decision.Single decision = (Decision.Single) filterAllocationDecider.canAllocate(
import org.opensearch.Version;
            "node does not match cluster setting [cluster.routing.allocation.require] filters [zone:\"zone1\",attr:\"attr1\"]",
            state.getRoutingNodes().node("node1"),
        );
                new SameShardAllocationDecider(Settings.EMPTY, clusterSettings),
    public void testMixedModeRemoteStoreAllocation() {
import org.opensearch.cluster.routing.RoutingTable;
        routingTable = service.applyFailedShard(state, routingTable.index("idx").shard(0).shards().get(0), randomBoolean()).routingTable();
            .putInSyncAllocationIds(0, Collections.singleton("aid0"))
        allocation = new RoutingAllocation(allocationDeciders, state.getRoutingNodes(), state, null, null, 0);
        );
            new TestGatewayAllocator(),
            EmptyClusterInfoService.INSTANCE,
            .put("cluster.routing.allocation.exclude._id", "node2")
        AllocationService service = new AllocationService(
    }
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.MIXED)
 * not use this file except in compliance with the License.
