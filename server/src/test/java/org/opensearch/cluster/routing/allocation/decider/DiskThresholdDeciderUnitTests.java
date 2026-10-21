            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
        test_0 = ShardRoutingHelper.initialize(test_0, "node1");
import org.opensearch.cluster.metadata.Metadata;
        );
        );
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            EmptyStoreRecoverySource.INSTANCE,
    }
        Metadata metadata = metaBuilder.build();
            equalTo(0.0)
        assertThat(
        );
            clusterStateWithMissingSourceIndex.getRoutingNodes(),
                .numberOfReplicas(1)
        );
 * SPDX-License-Identifier: Apache-2.0
                    + freeBytes
        test_2 = ShardRoutingHelper.initialize(test_2, "node1");
 * compatible open source license.
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            .build();
        RoutingAllocation allocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, info, null, 0);
            .metadata(metadata)
import org.opensearch.cluster.routing.RecoverySource.LocalShardsRecoverySource;
        assertEquals(100L, sizeOfRelocatingShards(allocation, node, false, "/dev/null"));
/*
        assertEquals(mostAvailableUsage.toString(), Decision.Type.YES, decision.type());
            .routingTable(routingTable)
        RoutingAllocation allocation = new RoutingAllocation(
        allocation.debugDecision(true);
            Version.CURRENT
            new HashSet<>(DiscoveryNodeRole.BUILT_IN_ROLES),
            .build();
import java.util.HashSet;
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
                    + "b], estimated shard size: ["
            System.nanoTime()
            allocation.metadata(),
            new ShardId(indexMetadata.getIndex(), 3),
            new ShardId("other", "5678", 0),
            containsString(
        shardSizes.put("[test][1][r]", 100L);
            Version.CURRENT
        assertThat(
            Version.CURRENT
        } else {
        routingTableBuilder.addAsNew(metadata.index("target2"));
        );
            equalTo(50.0)
        other_0 = ShardRoutingHelper.relocate(other_0, "node1");
        decision = decider.canAllocate(test_0, new RoutingNode("node_1", node_1), allocation);
                    + shardSize
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        final int freeBytes = randomIntBetween(20, 100);
        decision = decider.canRemain(test_2, new RoutingNode("node_1", node_1), allocation);
            allocation.metadata(),
            true,
        decision = decider.canRemain(test_1, new RoutingNode("node_1", node_1), allocation);
import org.opensearch.cluster.routing.RecoverySource.EmptyStoreRecoverySource;
        ClusterInfo info = new DiskThresholdDeciderTests.DevNullClusterInfo(Map.of(), Map.of(), shardSizes);
            containsString("this shard is not allocated on the most utilized disk and can remain")
        DiscoveryNode node_1 = new DiscoveryNode(
        final ClusterInfo clusterInfo = new ClusterInfo(
        final Index index = new Index("test", "1234");
 * under the License.
        );
        shardSizes.put("[test][0][p]", 10L);
        );
                .getUsedDiskAsPercentage(),
            "node1",
        shardSizes.put("[test][1][p]", 10L);
            new HashSet<>(DiscoveryNodeRole.BUILT_IN_ROLES),
        final Index index = new Index("test", "1234");
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(node_0).add(node_1)).build();
            allocation.routingTable()
        );
        } catch (IllegalArgumentException ex) {
            clusterStateWithMissingSourceIndex,
        );
                .getFreeBytes(),
            shardRoutingMap,
        ShardRouting test_0 = ShardRouting.newUnassigned(
import org.opensearch.cluster.ClusterName;
        ClusterState clusterStateWithMissingSourceIndex = ClusterState.builder(clusterState)
        routingTableBuilder.addAsNew(metadata.index("test"));
            Map.of()
            equalTo(60.0)
import org.opensearch.common.settings.ClusterSettings;
            clusterInfo,
        assertThat(
import org.opensearch.cluster.metadata.IndexMetadata;
            containsString(
import org.opensearch.common.settings.Settings;
 * this work for additional information regarding copyright
            Map.of(),
        assertEquals(Decision.Type.NO, decision.type());
        leastAvailableUsages.put("node_1", new DiskUsage("node_1", "node_1", "/node1/least", 100, 9)); // 91% used
        );
        metaBuilder.put(
            new HashSet<>(DiscoveryNodeRole.BUILT_IN_ROLES),
                .settings(
            decision.getExplanation(),
            LocalShardsRecoverySource.INSTANCE,
        );
            .build();
        test_1 = ShardRoutingHelper.moveToStarted(test_1);
 *
        allocation.debugDecision(true);
            test_1.getTargetRelocatingShard(),
 *
        Metadata.Builder metaBuilder = Metadata.builder();
        RoutingTable routingTable = RoutingTable.builder().addAsNew(indexMetadata).build();
import org.opensearch.cluster.node.DiscoveryNodes;
/**
            Collections.emptyMap(),
        DiscoveryNode node_0 = new DiscoveryNode(
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(node_0).add(node_1)).build();
        shardRoutingMap.put(test_2, "/node1/most");
import org.opensearch.cluster.routing.UnassignedInfo;
                    + "setting [cluster.routing.allocation.disk.watermark.high=90%], using more disk space than the maximum allowed [90.0%]"
        test_1 = ShardRoutingHelper.moveToStarted(test_1);
            .build();
            fail("not allocated on this node");
            clusterState,
                .numberOfShards(2)
        assertEquals(10L, getExpectedShardSize(test_0, 0L, allocation));
        );
        RoutingAllocation allocation = new RoutingAllocation(
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        );
            new ShardId(new Index("target", "5678"), 0),
            "node_1",
        test_1 = ShardRoutingHelper.initialize(test_1, "node2");
    public void testSizeShrinkIndex() {
                    + "and cause it to have less than the minimum required [0b] of free space "
            shardSizes,
            new HashSet<>(DiscoveryNodeRole.BUILT_IN_ROLES),
        test_3 = ShardRoutingHelper.moveToStarted(test_3);
import org.opensearch.cluster.routing.RoutingTable;
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
import org.opensearch.cluster.routing.ShardRouting;
        assertEquals(0L, sizeOfRelocatingShards(allocation, node, true, "/dev/some/other/dev"));
        assertThat(
            LocalShardsRecoverySource.INSTANCE,
    }
public class DiskThresholdDeciderUnitTests extends OpenSearchAllocationTestCase {
            .routingTable(routingTable)
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("n", "n", "/dev/null", 1000L, 1000L), 0).getFreeBytes(),
        ShardRouting other_0 = ShardRouting.newUnassigned(
        );
        );
    public long sizeOfRelocatingShards(RoutingAllocation allocation, RoutingNode node, boolean subtractShardsMovingAway, String dataPath) {
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(node_0).add(node_1)).build();
            new ShardId(indexMetadata.getIndex(), 1),
        DiscoveryNode node_1 = new DiscoveryNode(
        assertThat(
import java.util.Map;
        mostAvailableUsage.put("node_1", new DiskUsage("node_1", "node_1", "_na_", 100, randomIntBetween(0, 10)));
import org.opensearch.cluster.DiskUsage;
import java.util.HashMap;
        assertEquals("can stay since we don't have information about this shard", Decision.Type.YES, decision.type());
        try {
        final Map<String, DiskUsage> leastAvailableUsages = new HashMap<>();
        assertThat(
        RoutingNode node = new RoutingNode(
        // 20 - 99 percent since after allocation there must be at least 10% left and shard is 10byte
        DiscoveryNode node_1 = new DiscoveryNode(
            allocationService,
            .metadata(Metadata.builder(metadata).remove("test"))
        );
            "node_0",
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("n", "n", "/dev/null", 1000L, 500L), 0)
        test_1 = ShardRoutingHelper.initialize(test_1, "node2");
        assertEquals(1000L, getExpectedShardSize(test_2, 0L, allocation));
            true,
            new ShardId(index, 0),
        ShardRouting test_3 = ShardRouting.newUnassigned(
            new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT),
        if (other_0.primary()) {
        logger.info("--> adding two nodes");
            new ShardId(new Index("target2", "9101112"), 0),
 */
        Metadata metadata = Metadata.builder()
            true,
                    settings(Version.CURRENT).put("index.uuid", "9101112")
        allocationService.reroute(clusterState, "foo");
            equalTo(Long.MAX_VALUE)
        );
        shardSizes.put("[test][1][p]", 100L);
        test_3 = ShardRoutingHelper.initialize(test_3, "node1");
            true,
                        .put(IndexMetadata.INDEX_RESIZE_SOURCE_NAME_KEY, "test")
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("n", "n", "/dev/null", Long.MAX_VALUE, Long.MAX_VALUE), 0)
            )
        );
            clusterState.getRoutingNodes(),
            decider.canRemain(test_0, new RoutingNode("node_1", node_1), allocation);
            new ShardId(index, 0),
                .numberOfReplicas(0)
            true,
            "node_1",
        mostAvailableUsage.put("node_1", new DiskUsage("node_1", "node_1", "/node1/most", 100, 90)); // 10% used
        // actual test -- after all that bloat :)
        );
            clusterState.getRoutingNodes(),
 * Modifications Copyright OpenSearch Contributors. See
            .build();
        ShardRouting test_3 = ShardRouting.newUnassigned(
        assertEquals(42L, getExpectedShardSize(target2, 42L, allocationWithMissingSourceIndex));
 */
        shardSizes.put("[test][0][r]", 10L);
            Collections.emptyMap(),
        test_0 = ShardRoutingHelper.initialize(test_0, "node1");
            clusterState.getRoutingNodes(),
            LocalShardsRecoverySource.INSTANCE,
        shardSizes.put("[test][2][p]", 10L);
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        // actual test -- after all that bloat :)
        );
        decision = decider.canRemain(test_2, new RoutingNode("node_1", node_1), allocation);
    }
            null,
                .getFreeDiskAsPercentage(),
 *     http://www.apache.org/licenses/LICENSE-2.0
        ShardRouting test_2 = ShardRouting.newUnassigned(
            System.nanoTime()
        node = new RoutingNode(
            clusterInfo,
        shardSizes.put("[test][3][p]", 500L);
        routingTableBuilder.addAsNew(metadata.index("target"));
        assertEquals(42L, getExpectedShardSize(target, 42L, allocationWithMissingSourceIndex));
            clusterState.getRoutingTable().index("test").shardsWithState(ShardRoutingState.UNASSIGNED)
            // not allocated on that node
            0
        ShardRouting test_0 = ShardRouting.newUnassigned(
        );
import org.opensearch.core.index.Index;
            clusterState,
            .build();
            new ShardId(index, 3),
        assertEquals(Decision.Type.YES, decision.type());
        assertEquals(110L, getExpectedShardSize(target2, 0L, allocation));
                .getUsedDiskAsPercentage(),
        test_2 = ShardRoutingHelper.moveToStarted(test_2);
                .numberOfShards(4)
        );
            randomBoolean(),
                .numberOfReplicas(0)
            null,
            shardSizes,
        );
        assertEquals(10L, getExpectedShardSize(test_0, 0L, allocation));
        ShardRouting test_0 = ShardRouting.newUnassigned(
        Metadata metadata = Metadata.builder()
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("n", "n", "/dev/null", Long.MAX_VALUE, Long.MAX_VALUE), 10)
            false,
            .routingTable(routingTableBuilder.build())
            .routingTable(routingTable)
        clusterState = startShardsAndReroute(
        );
                .numberOfReplicas(1)
            shardSizes,
        test_1 = ShardRoutingHelper.relocate(test_1, "node1");
                .settings(settings(Version.CURRENT).put("index.uuid", "1234"))
package org.opensearch.cluster.routing.allocation.decider;
        test_1 = ShardRoutingHelper.initialize(test_1, node_1.getId());
            null,
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
        );
        }
}
        assertThat(
            allocation.clusterInfo(),
            shardRouting,
        test_2 = ShardRoutingHelper.initialize(test_2, "node1");
            containsString("this shard is not allocated on the most utilized disk and can remain")
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
            defaultSize,
        assertThat(((Decision.Single) decision).getExplanation(), containsString("enough disk for shard on node"));
            Version.CURRENT
            IndexMetadata.builder("test")
import org.opensearch.cluster.routing.ShardRoutingHelper;
        leastAvailableUsages.put("node_0", new DiskUsage("node_0", "node_0", "_na_", 100, 0)); // all full
        final IndexMetadata indexMetadata = metadata.index("test");
        assertEquals(100L, getExpectedShardSize(test_1, 0L, allocation));
            clusterState,
        ShardRouting test_3 = ShardRouting.newUnassigned(
        DiskThresholdDecider decider = new DiskThresholdDecider(Settings.EMPTY, nss);
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("n", "n", "/dev/null", 1000L, 500L), 0)
                .settings(
        ClusterInfo clusterInfo = new ClusterInfo(
            new ShardId(index, 1),
        Metadata metadata = Metadata.builder()
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
import org.opensearch.cluster.routing.allocation.AllocationService;
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.cluster.ClusterState;
        );
        mostAvailableUsage.put("node_0", new DiskUsage("node_0", "node_0", "_na_", 100, freeBytes));
import org.opensearch.cluster.ClusterInfo;
            new ShardId(index, 2),
        shardSizes.put("[test][2][p]", 500L);
        final Map<String, DiskUsage> mostAvailableUsage = new HashMap<>();
        );
            ((Decision.Single) decision).getExplanation(),
        final long shardSize = randomIntBetween(110, 1000);
        ClusterSettings nss = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
        );
            assertEquals(100L, sizeOfRelocatingShards(allocation, node, false, "/dev/null"));
            true,
            buildNewFakeTransportAddress(),
        );
import static org.hamcrest.Matchers.equalTo;
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
 * not use this file except in compliance with the License.
        assertEquals(90L, sizeOfRelocatingShards(allocation, node, true, "/dev/null"));
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
                    + "[cluster.routing.allocation.disk.watermark.high=90%] "
        Decision decision = decider.canAllocate(test_0, new RoutingNode("node_0", node_0), allocation);
        test_3 = ShardRoutingHelper.moveToStarted(test_3);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        );
            buildNewFakeTransportAddress(),
        return DiskThresholdDecider.sizeOfRelocatingShards(
            .metadata(metadata)
        );
        );
            LocalShardsRecoverySource.INSTANCE,
        test_0 = ShardRoutingHelper.moveToStarted(test_0);
            clusterInfo,
        metaBuilder.put(
            EmptyStoreRecoverySource.INSTANCE,
            .routingTable(RoutingTable.builder(clusterState.routingTable()).remove("test").build())
 *
 * software distributed under the License is distributed on an
import static java.util.Collections.emptyMap;
        Decision decision = decider.canRemain(test_0, new RoutingNode("node_0", node_0), allocation);
            Map.of(),
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
            ((Decision.Single) decision).getExplanation(),
        test_2 = ShardRoutingHelper.moveToStarted(test_2);
            buildNewFakeTransportAddress(),
        assertThat(
            PeerRecoverySource.INSTANCE,
                    + "b])"
    }
            .metadata(metadata)
            EmptyStoreRecoverySource.INSTANCE,
    public void testCanAllocateUsesMaxAvailableSpace() {
            Map.of(),
        RoutingAllocation allocationWithMissingSourceIndex = new RoutingAllocation(
        assertThat(
            "node1",
                )
            ((Decision.Single) decision).getExplanation(),
            equalTo(991L)
        );
            equalTo(100.0)
            ((Decision.Single) decision).getExplanation(),
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("n", "n", "/dev/null", 1000L, 500L), 100)
            fail("not allocated on this node");
        // Intentionally not in the shardRoutingMap. We want to test what happens when we don't know where it is.
        clusterState = allocationService.reroute(clusterState, "foo");
import org.opensearch.cluster.node.DiscoveryNode;
    }
            buildNewFakeTransportAddress(),
 * The OpenSearch Contributors require contributions made to
        } catch (IllegalArgumentException ex) {
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
        ShardRouting test_1 = ShardRouting.newUnassigned(
            new ShardId(indexMetadata.getIndex(), 0),
        leastAvailableUsages.put("node_1", new DiskUsage("node_1", "node_1", "_na_", 100, 0)); // all full
        final Map<String, Long> shardSizes = new HashMap<>();
            test_1.getTargetRelocatingShard(),
import org.opensearch.cluster.node.DiscoveryNodeRole;
            // not allocated on that node
        // check that the DiskThresholdDecider still works even if the source index has been deleted
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
/*
            leastAvailableUsages,
                        .put(IndexMetadata.INDEX_RESIZE_SOURCE_NAME_KEY, "test")
        assertThat(
        );
            Version.CURRENT
            new ShardId(index, 3),
        // way bigger than available space
        );
            )
            false,
        test_3 = ShardRoutingHelper.initialize(test_3, "node1");
                        .put(IndexMetadata.INDEX_RESIZE_SOURCE_UUID_KEY, "1234")
            new ShardId(indexMetadata.getIndex(), 2),
        mostAvailableUsage.put("node_0", new DiskUsage("node_0", "node_0", "_na_", 100, randomIntBetween(20, 100)));
        assertEquals(100L, getExpectedShardSize(test_1, 0L, allocation));
                    + "above the high watermark cluster setting [cluster.routing.allocation.disk.watermark.high=90%] and there is less than "
            equalTo(50.0)
            true,
import org.opensearch.Version;
        metaBuilder.put(
        DiscoveryNode node_0 = new DiscoveryNode(
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("n", "n", "/dev/null", 1000L, 1000L), 9).getFreeBytes(),
            IndexMetadata.builder("other")
                    + "the required [10.0%] free disk on node, actual free: [9.0%]"
        allocation.debugDecision(true);
            EmptyStoreRecoverySource.INSTANCE,
        shardRoutingMap.put(test_1, "/node1/least");
        );
    public void testCanRemainUsesLeastAvailableSpace() {
import static java.util.Collections.emptySet;
            assertEquals(10090L, sizeOfRelocatingShards(allocation, node, true, "/dev/null"));
            EmptyStoreRecoverySource.INSTANCE,
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
                )
                "the shard cannot remain on this node because it is "
import org.opensearch.core.index.shard.ShardId;
        // actual test -- after all that bloat :)
        );
        test_0 = ShardRoutingHelper.moveToStarted(test_0);
            new AllocationDeciders(Collections.singleton(decider)),
            decider.canRemain(test_1, new RoutingNode("node_0", node_0), allocation);
        shardSizes.put("[test][0][p]", 10L); // 10 bytes
        final Map<String, DiskUsage> leastAvailableUsages = new HashMap<>();
        assertEquals(Decision.Type.NO, decision.type());
        metaBuilder.put(
        final Map<String, Long> shardSizes = new HashMap<>();
            PeerRecoverySource.INSTANCE,
            new ShardId(index, 0),
 * KIND, either express or implied.  See the License for the
            leastAvailableUsages,
        );
            assertEquals(90L, sizeOfRelocatingShards(allocation, node, true, "/dev/null"));
        );
            .metadata(metadata)
            true,
        );
        );
            clusterState,
            test_2
            Collections.emptyMap(),
        shardSizes.put("[other][0][p]", 10000L);
        );
            Map.of()
            equalTo(1000L)
            "node_0",
                .numberOfShards(1)
        test_1 = ShardRoutingHelper.moveToStarted(test_1);
 * the Apache License, Version 2.0 (the "License"); you may
        other_0 = ShardRoutingHelper.moveToStarted(other_0);
 * specific language governing permissions and limitations
        );
        ShardRouting test_1 = ShardRouting.newUnassigned(
        assertEquals(500L, getExpectedShardSize(test_3, 0L, allocation));
            containsString(
        assertThat(
        ClusterInfo info = new DiskThresholdDeciderTests.DevNullClusterInfo(Map.of(), Map.of(), shardSizes);
            true,
                .getFreeDiskAsPercentage(),
        assertThat(
import java.util.Collections;
 * license agreements. See the NOTICE file distributed with
            .metadata(metadata)
        );
            true,
            mostAvailableUsage,
        );
            other_0.getTargetRelocatingShard()
        target2 = ShardRouting.newUnassigned(
            allocation.snapshotShardSizeInfo(),
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            Map.of()
            Collections.emptyMap(),
 * You may obtain a copy of the License at
    public void testCannotAllocateDueToLackOfDiskResources() {
            ((Decision.Single) decision).getExplanation(),
            Map.of(),
            mostAvailableUsage,
        test_0 = ShardRoutingHelper.moveToStarted(test_0);
        shardSizes.put("[test][2][r]", 1000L);
        routingTableBuilder.addAsNew(metadata.index("test"));
        DiscoveryNode node_0 = new DiscoveryNode(
    public void testDiskUsageWithRelocations() {
        }
        assertEquals(500L, getExpectedShardSize(test_2, 0L, allocation));
        ClusterSettings nss = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            equalTo(Long.MAX_VALUE - 10)
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("n", "n", "/dev/null", 1000L, 500L), 100)
        assertThat(
        assertThat(
            Version.CURRENT
            null,
            true,
            info,
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
        final Map<String, Long> shardSizes = new HashMap<>();
        );
            buildNewFakeTransportAddress(),
        test_3 = ShardRoutingHelper.initialize(test_3, node_1.getId());
        );
        AllocationService allocationService = createAllocationService();
                "allocating the shard to this node will bring the node above the high watermark cluster setting "
                        .put(IndexMetadata.INDEX_RESIZE_SOURCE_UUID_KEY, "1234")
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("n", "n", "/dev/null", 1000L, 1000L), 0)
                "the node is above the high watermark cluster "
        }
            mostAvailableUsage,
        RoutingAllocation allocation = new RoutingAllocation(null, null, clusterState, info, null, 0);
 * Unit tests for the DiskThresholdDecider
            new AllocationDeciders(Collections.singleton(decider)),
        assertEquals(0L, sizeOfRelocatingShards(allocation, node, true, "/dev/some/other/dev"));
                .numberOfShards(1)
        DiskThresholdDecider decider = new DiskThresholdDecider(Settings.EMPTY, nss);
            IndexMetadata.builder("target2")
        ShardRouting target2 = ShardRouting.newUnassigned(
            EmptyStoreRecoverySource.INSTANCE,
            .build();
        leastAvailableUsages.put("node_0", new DiskUsage("node_0", "node_0", "_na_", 100, 0)); // all full
        test_2 = ShardRoutingHelper.initialize(test_2, node_1.getId());
 */
            PeerRecoverySource.INSTANCE,
        ShardRouting test_0 = ShardRouting.newUnassigned(
            new ShardId(index, 1),
        );
                .getUsedDiskAsPercentage(),
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
            allocation.routingTable()
        );
        ShardRouting test_1 = ShardRouting.newUnassigned(
            buildNewFakeTransportAddress(),
        DiskThresholdDecider decider = new DiskThresholdDecider(Settings.EMPTY, nss);
 * ownership. Elasticsearch licenses this file to you under
        routingTableBuilder.addAsNew(metadata.index("other"));
        final Map<String, DiskUsage> mostAvailableUsage = new HashMap<>();
            assertEquals(10100L, sizeOfRelocatingShards(allocation, node, false, "/dev/null"));
            null,
        ShardRouting test_2 = ShardRouting.newUnassigned(
    }
                .numberOfShards(3)
        final Map<String, Long> shardSizes = new HashMap<>();
        final Map<String, DiskUsage> leastAvailableUsages = new HashMap<>();
 * Unless required by applicable law or agreed to in writing,
            .routingTable(routingTableBuilder.build())
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
            "node_1",
    }
        ShardRouting test_2 = ShardRouting.newUnassigned(
            IndexMetadata.builder("target")
        );
            containsString("there is enough disk on this node for the shard to remain, free: [10b]")
            Collections.emptyMap(),
        ShardRouting test_0 = ShardRouting.newUnassigned(
            Map.of(),
            PeerRecoverySource.INSTANCE,
            Map.of(),
        // this is weird and smells like a bug! it should be up to 20%?
        );
        final ClusterInfo clusterInfo = new ClusterInfo(
        ShardRouting target = ShardRouting.newUnassigned(
        );
        metaBuilder.put(
            allocation.clusterInfo(),
            IndexMetadata.builder("test")
    public void testShardSizeAndRelocatingSize() {
            node,
                    settings(Version.CURRENT).put("index.uuid", "5678")
            true,
            Collections.emptyMap(),
                .numberOfReplicas(0)
            .build();
            System.nanoTime()
            new ShardId(index, 2),
        final Map<String, Long> shardSizes = new HashMap<>();
            Map.of(),
        return DiskThresholdDecider.getExpectedShardSize(
        assertThat(
                .getFreeBytes(),
        assertThat(
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertEquals("can stay since allocated on a different path with enough space", Decision.Type.YES, decision.type());
            new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT),
        );
            test_0,
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
import static org.hamcrest.Matchers.containsString;
        final Index index = metadata.index("test").getIndex();
        mostAvailableUsage.put("node_0", new DiskUsage("node_0", "node_0", "/node0/most", 100, 90)); // 10% used
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
        );
        leastAvailableUsages.put("node_0", new DiskUsage("node_0", "node_0", "/node0/least", 100, 10)); // 90% used
                .getFreeBytes(),
            LocalShardsRecoverySource.INSTANCE,
            equalTo(Long.MAX_VALUE)
            "node_0",
        shardSizes.put("[test][0][p]", 10L); // 10 bytes
        );
        ClusterSettings nss = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        shardSizes.put("[test][0][p]", shardSize);
            leastAvailableUsages,
        assertEquals(0L, getExpectedShardSize(test_3, 0L, allocation));
            new AllocationDeciders(Collections.singleton(decider)),
            equalTo(1009L)
            LocalShardsRecoverySource.INSTANCE,
        final Map<String, DiskUsage> mostAvailableUsage = new HashMap<>();
        test_0 = ShardRoutingHelper.relocate(test_0, "node2");
        test_0 = ShardRoutingHelper.initialize(test_0, node_0.getId());
import org.opensearch.cluster.routing.RecoverySource.PeerRecoverySource;
        Metadata.Builder metaBuilder = Metadata.builder();
        assertEquals(1110L, getExpectedShardSize(target, 0L, allocation));
            LocalShardsRecoverySource.INSTANCE,
        Decision decision = decider.canAllocate(test_0, new RoutingNode("node_0", node_0), allocation);
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
        other_0 = ShardRoutingHelper.initialize(other_0, "node2");
            false,
            subtractShardsMovingAway,
 */
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("n", "n", "/dev/null", Long.MAX_VALUE, Long.MAX_VALUE), -10)
            equalTo(40.0)
    }
    private static long getExpectedShardSize(ShardRouting shardRouting, long defaultSize, RoutingAllocation allocation) {
            Map.of(),
import org.opensearch.cluster.routing.RoutingNode;
        );
            dataPath,
            new HashSet<>(DiscoveryNodeRole.BUILT_IN_ROLES),
            PeerRecoverySource.INSTANCE,
            .build();
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("n", "n", "/dev/null", 1000L, 1000L), -9).getFreeBytes(),
            test_2,
        final Map<ShardRouting, String> shardRoutingMap = new HashMap<>();
 * this file be licensed under the Apache-2.0 license or a
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        shardRoutingMap.put(test_0, "/node0/least");
/*
        assertThat(
            false,
            test_0,
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        assertEquals(mostAvailableUsage.toString(), Decision.Type.NO, decision.type());
        final Index index = metadata.index("test").getIndex();
        RoutingAllocation allocation = new RoutingAllocation(
        );
                .settings(settings(Version.CURRENT).put("index.uuid", "5678"))
                .getFreeDiskAsPercentage(),
import org.opensearch.cluster.routing.ShardRoutingState;
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("n", "n", "/dev/null", 1000L, 1000L), 0)
        try {
        );
            new ShardId(index, 0),
            true,
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
        assertEquals(1000L, getExpectedShardSize(target2, 0L, allocation));
            new HashSet<>(DiscoveryNodeRole.BUILT_IN_ROLES),
                .settings(settings(Version.CURRENT).put("index.uuid", "1234"))
 * GitHub history for details.
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        );
                    + "(free: ["
        assertThat(
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
            )
        Metadata metadata = metaBuilder.build();
            new ShardId(new Index("target2", "9101112"), 1),
