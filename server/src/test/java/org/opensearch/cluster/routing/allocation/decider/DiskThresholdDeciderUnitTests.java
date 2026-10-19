 *     http://www.apache.org/licenses/LICENSE-2.0
        DiskThresholdDecider decider = new DiskThresholdDecider(Settings.EMPTY, nss);
            equalTo(991L)  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        test_0 = ShardRoutingHelper.relocate(test_0, "node2");
        assertEquals(10L, getExpectedShardSize(test_0, 0L, allocation));  
        ClusterSettings nss = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            IndexMetadata.builder("test")  
        );
        test_3 = ShardRoutingHelper.initialize(test_3, "node1");
        routingTableBuilder.addAsNew(metadata.index("test"));  
            new ShardId(index, 2),
        test_2 = ShardRoutingHelper.initialize(test_2, "node1");
            System.nanoTime()
 * the Apache License, Version 2.0 (the "License"); you may
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
 * The OpenSearch Contributors require contributions made to  
            Map.of(),  
        ShardRouting target2 = ShardRouting.newUnassigned(
        assertEquals(90L, sizeOfRelocatingShards(allocation, node, true, "/dev/null"));
            equalTo(50.0)
            buildNewFakeTransportAddress(),
            leastAvailableUsages,  
        DiscoveryNode node_1 = new DiscoveryNode(  
        // way bigger than available space  
            randomBoolean(),
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        DiskThresholdDecider decider = new DiskThresholdDecider(Settings.EMPTY, nss);  
    public void testDiskUsageWithRelocations() {
        logger.info("--> adding two nodes");  
            ((Decision.Single) decision).getExplanation(),
            ((Decision.Single) decision).getExplanation(),
            new HashSet<>(DiscoveryNodeRole.BUILT_IN_ROLES),  
        ShardRouting test_1 = ShardRouting.newUnassigned(  
            buildNewFakeTransportAddress(),
        DiskThresholdDecider decider = new DiskThresholdDecider(Settings.EMPTY, nss);
            LocalShardsRecoverySource.INSTANCE,
                .settings(settings(Version.CURRENT).put("index.uuid", "1234"))
        final int freeBytes = randomIntBetween(20, 100);
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(node_0).add(node_1)).build();  
        shardSizes.put("[test][0][p]", 10L);
public class DiskThresholdDeciderUnitTests extends OpenSearchAllocationTestCase {
        final Map<ShardRouting, String> shardRoutingMap = new HashMap<>();  
            "node_1",
import org.opensearch.cluster.routing.RoutingTable;
        );
            Collections.emptyMap(),  
        allocationService.reroute(clusterState, "foo");
        shardSizes.put("[test][0][p]", shardSize);
            new HashSet<>(DiscoveryNodeRole.BUILT_IN_ROLES),  
            true,
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
        decision = decider.canAllocate(test_0, new RoutingNode("node_1", node_1), allocation);  
import java.util.HashSet;  
            allocation.snapshotShardSizeInfo(),
        assertThat(
        decision = decider.canRemain(test_1, new RoutingNode("node_1", node_1), allocation);
        test_1 = ShardRoutingHelper.initialize(test_1, "node2");  
            Map.of(),
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
        ShardRouting target = ShardRouting.newUnassigned(
            true,
        );
            Map.of(),
            .build();  
        );  
        shardSizes.put("[test][1][r]", 100L);
                        .put(IndexMetadata.INDEX_RESIZE_SOURCE_NAME_KEY, "test")  
        test_0 = ShardRoutingHelper.initialize(test_0, "node1");  
                )
 */
        );
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")  
            test_0,
            "node_0",
            containsString("this shard is not allocated on the most utilized disk and can remain")  
        final Map<String, DiskUsage> mostAvailableUsage = new HashMap<>();
        assertEquals(100L, sizeOfRelocatingShards(allocation, node, false, "/dev/null"));  
                "the node is above the high watermark cluster "
            mostAvailableUsage,
                .getFreeDiskAsPercentage(),  
        ShardRouting test_0 = ShardRouting.newUnassigned(  
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            new ShardId(new Index("target2", "9101112"), 1),
                    + "[cluster.routing.allocation.disk.watermark.high=90%] "
 * Unless required by applicable law or agreed to in writing,
        ShardRouting test_2 = ShardRouting.newUnassigned(  
                .numberOfReplicas(1)
        AllocationService allocationService = createAllocationService();
 * GitHub history for details.
/*
        assertEquals(500L, getExpectedShardSize(test_2, 0L, allocation));
        final IndexMetadata indexMetadata = metadata.index("test");
        metaBuilder.put(  
            .build();
        clusterState = allocationService.reroute(clusterState, "foo");
        assertThat(
            Collections.emptyMap(),
            buildNewFakeTransportAddress(),  
            LocalShardsRecoverySource.INSTANCE,
                .getFreeBytes(),
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
            EmptyStoreRecoverySource.INSTANCE,
            assertEquals(100L, sizeOfRelocatingShards(allocation, node, false, "/dev/null"));
import org.opensearch.cluster.node.DiscoveryNode;  
            .build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final Map<String, Long> shardSizes = new HashMap<>();
        Metadata metadata = Metadata.builder()
        return DiskThresholdDecider.sizeOfRelocatingShards(
                .getFreeDiskAsPercentage(),
            equalTo(Long.MAX_VALUE - 10)
        assertThat(  
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")  
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("n", "n", "/dev/null", Long.MAX_VALUE, Long.MAX_VALUE), 10)  
            ((Decision.Single) decision).getExplanation(),
            true,
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("n", "n", "/dev/null", 1000L, 1000L), 0).getFreeBytes(),
                    + freeBytes
        try {  
/*  
            EmptyStoreRecoverySource.INSTANCE,  
        test_0 = ShardRoutingHelper.moveToStarted(test_0);  
            new ShardId(index, 1),
 * this work for additional information regarding copyright
        DiscoveryNode node_0 = new DiscoveryNode(  
                    + "setting [cluster.routing.allocation.disk.watermark.high=90%], using more disk space than the maximum allowed [90.0%]"  
            fail("not allocated on this node");
            EmptyStoreRecoverySource.INSTANCE,
        );
        ShardRouting test_0 = ShardRouting.newUnassigned(
            test_1.getTargetRelocatingShard(),
import org.opensearch.cluster.node.DiscoveryNodes;
                        .put(IndexMetadata.INDEX_RESIZE_SOURCE_UUID_KEY, "1234")
                        .put(IndexMetadata.INDEX_RESIZE_SOURCE_UUID_KEY, "1234")
        Decision decision = decider.canRemain(test_0, new RoutingNode("node_0", node_0), allocation);
 * ownership. Elasticsearch licenses this file to you under  
            .metadata(metadata)
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")  
        );
            LocalShardsRecoverySource.INSTANCE,  
        );
            new ShardId(indexMetadata.getIndex(), 0),
import org.opensearch.cluster.routing.RecoverySource.PeerRecoverySource;
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("n", "n", "/dev/null", 1000L, 500L), 0)
import static org.hamcrest.Matchers.equalTo;  
        shardSizes.put("[test][2][p]", 500L);  
        ClusterInfo clusterInfo = new ClusterInfo(  
            new HashSet<>(DiscoveryNodeRole.BUILT_IN_ROLES),
        final Index index = new Index("test", "1234");
        // check that the DiskThresholdDecider still works even if the source index has been deleted
    public void testSizeShrinkIndex() {
            0  
 * compatible open source license.
        test_1 = ShardRoutingHelper.moveToStarted(test_1);  
        // actual test -- after all that bloat :)  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
import org.opensearch.cluster.routing.ShardRouting;
                    + "the required [10.0%] free disk on node, actual free: [9.0%]"  
        assertThat(
            PeerRecoverySource.INSTANCE,
            shardSizes,  
            .build();
            defaultSize,  
        // Intentionally not in the shardRoutingMap. We want to test what happens when we don't know where it is.  
        if (other_0.primary()) {  
                .numberOfShards(3)  
                    settings(Version.CURRENT).put("index.uuid", "5678")
        assertEquals(42L, getExpectedShardSize(target2, 42L, allocationWithMissingSourceIndex));  
        assertEquals(1110L, getExpectedShardSize(target, 0L, allocation));
            shardRouting,
        routingTableBuilder.addAsNew(metadata.index("target"));
                    + "b], estimated shard size: ["
import org.opensearch.cluster.DiskUsage;
            Version.CURRENT
import org.opensearch.cluster.routing.ShardRoutingState;
        RoutingAllocation allocationWithMissingSourceIndex = new RoutingAllocation(  
            allocation.clusterInfo(),
            new ShardId(index, 2),
        } else {  
        other_0 = ShardRoutingHelper.moveToStarted(other_0);
            containsString(  
        Metadata.Builder metaBuilder = Metadata.builder();
            Map.of(),
        metaBuilder.put(  
        test_0 = ShardRoutingHelper.initialize(test_0, "node1");
        ShardRouting test_1 = ShardRouting.newUnassigned(  
        // actual test -- after all that bloat :)  
        final ClusterInfo clusterInfo = new ClusterInfo(
            Map.of()
        shardSizes.put("[other][0][p]", 10000L);  
    }  
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
            new HashSet<>(DiscoveryNodeRole.BUILT_IN_ROLES),
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(node_0).add(node_1)).build();
            test_0,
            IndexMetadata.builder("other")
        );
            clusterState,  
            true,
            allocation.routingTable()
            false,
        ClusterState clusterStateWithMissingSourceIndex = ClusterState.builder(clusterState)  
                .settings(
package org.opensearch.cluster.routing.allocation.decider;
        routingTableBuilder.addAsNew(metadata.index("target2"));
        final Map<String, Long> shardSizes = new HashMap<>();  
                    + "and cause it to have less than the minimum required [0b] of free space "
        test_3 = ShardRoutingHelper.initialize(test_3, "node1");
                .numberOfReplicas(0)
        );
        ShardRouting test_2 = ShardRouting.newUnassigned(
 *
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
        assertThat(  
        );
        routingTableBuilder.addAsNew(metadata.index("test"));
        RoutingAllocation allocation = new RoutingAllocation(null, null, clusterState, info, null, 0);
            new AllocationDeciders(Collections.singleton(decider)),  
import org.opensearch.cluster.routing.RoutingNode;  
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")  
        );
            false,  
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("n", "n", "/dev/null", 1000L, 1000L), 9).getFreeBytes(),
        );
        assertThat(
            fail("not allocated on this node");
        );
        test_1 = ShardRoutingHelper.relocate(test_1, "node1");
        final Map<String, DiskUsage> leastAvailableUsages = new HashMap<>();
            .build();
        assertEquals(500L, getExpectedShardSize(test_3, 0L, allocation));  
            test_1.getTargetRelocatingShard(),  
        test_0 = ShardRoutingHelper.moveToStarted(test_0);
        leastAvailableUsages.put("node_0", new DiskUsage("node_0", "node_0", "_na_", 100, 0)); // all full
                        .put(IndexMetadata.INDEX_RESIZE_SOURCE_NAME_KEY, "test")
            Map.of(),
            Collections.emptyMap(),  
            )
            PeerRecoverySource.INSTANCE,  
        RoutingTable routingTable = RoutingTable.builder().addAsNew(indexMetadata).build();
}
 * KIND, either express or implied.  See the License for the
        Metadata metadata = Metadata.builder()
            containsString("there is enough disk on this node for the shard to remain, free: [10b]")  
            System.nanoTime()  
        assertEquals(100L, getExpectedShardSize(test_1, 0L, allocation));
            null,
 * this file be licensed under the Apache-2.0 license or a
    }
                .numberOfShards(4)
            "node1",  
            "node_0",  
            new ShardId(new Index("target2", "9101112"), 0),
        assertEquals(42L, getExpectedShardSize(target, 42L, allocationWithMissingSourceIndex));
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
            containsString(
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
        );
        assertEquals("can stay since we don't have information about this shard", Decision.Type.YES, decision.type());  
        leastAvailableUsages.put("node_1", new DiskUsage("node_1", "node_1", "/node1/least", 100, 9)); // 91% used  
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("n", "n", "/dev/null", 1000L, 500L), 100)
                    + "above the high watermark cluster setting [cluster.routing.allocation.disk.watermark.high=90%] and there is less than "
        );
import org.opensearch.cluster.ClusterInfo;
            .build();
        }
                .numberOfShards(1)  
                "the shard cannot remain on this node because it is "
        } catch (IllegalArgumentException ex) {  
import java.util.Collections;
        mostAvailableUsage.put("node_1", new DiskUsage("node_1", "node_1", "_na_", 100, randomIntBetween(0, 10)));
            PeerRecoverySource.INSTANCE,
        final long shardSize = randomIntBetween(110, 1000);
        assertEquals(10L, getExpectedShardSize(test_0, 0L, allocation));  
            clusterState.getRoutingNodes(),
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
            true,
        );
            allocationService,
        Metadata metadata = metaBuilder.build();
            allocation.metadata(),  
        );
        allocation.debugDecision(true);
    }  
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("n", "n", "/dev/null", 1000L, 500L), 100)  
            allocation.routingTable()
        );
            clusterState,
            Version.CURRENT
 * SPDX-License-Identifier: Apache-2.0
        }  
            EmptyStoreRecoverySource.INSTANCE,  
        );
        );
        final ClusterInfo clusterInfo = new ClusterInfo(  
        metaBuilder.put(  
        final Map<String, DiskUsage> leastAvailableUsages = new HashMap<>();  
            new AllocationDeciders(Collections.singleton(decider)),
            assertEquals(10090L, sizeOfRelocatingShards(allocation, node, true, "/dev/null"));
    public void testCanAllocateUsesMaxAvailableSpace() {
        allocation.debugDecision(true);
        DiscoveryNode node_0 = new DiscoveryNode(
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
import org.opensearch.cluster.ClusterName;  
        );
                .settings(settings(Version.CURRENT).put("index.uuid", "1234"))
        other_0 = ShardRoutingHelper.initialize(other_0, "node2");  
            dataPath,
import static java.util.Collections.emptyMap;  
            Map.of()  
        test_0 = ShardRoutingHelper.moveToStarted(test_0);
            true,  
        );  
import org.opensearch.cluster.routing.UnassignedInfo;
        assertEquals(110L, getExpectedShardSize(target2, 0L, allocation));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
            clusterState.getRoutingNodes(),
        }
            clusterState.getRoutingNodes(),
        );
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();  
            new ShardId(index, 1),
                .getFreeBytes(),
            new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT),
import org.opensearch.cluster.routing.RecoverySource.EmptyStoreRecoverySource;  
            equalTo(40.0)
            allocation.clusterInfo(),
        );  
            equalTo(0.0)
            IndexMetadata.builder("target")  
            LocalShardsRecoverySource.INSTANCE,  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(node_0).add(node_1)).build();
        assertEquals(mostAvailableUsage.toString(), Decision.Type.NO, decision.type());
            .build();  
            new ShardId(index, 3),  
        assertEquals("can stay since allocated on a different path with enough space", Decision.Type.YES, decision.type());
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
            .metadata(metadata)
        DiscoveryNode node_1 = new DiscoveryNode(
        test_1 = ShardRoutingHelper.moveToStarted(test_1);
        assertThat(
import org.opensearch.cluster.routing.allocation.AllocationService;  
            new ShardId(indexMetadata.getIndex(), 1),  
                .numberOfReplicas(0)  
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("n", "n", "/dev/null", Long.MAX_VALUE, Long.MAX_VALUE), -10)
        ShardRouting test_3 = ShardRouting.newUnassigned(
        routingTableBuilder.addAsNew(metadata.index("other"));  
        );  
            PeerRecoverySource.INSTANCE,
        } catch (IllegalArgumentException ex) {  
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
            new AllocationDeciders(Collections.singleton(decider)),
            Map.of(),  
            new ShardId(indexMetadata.getIndex(), 2),
            LocalShardsRecoverySource.INSTANCE,
            clusterInfo,
            info,
        assertEquals(mostAvailableUsage.toString(), Decision.Type.YES, decision.type());
            containsString(
            clusterState.getRoutingTable().index("test").shardsWithState(ShardRoutingState.UNASSIGNED)  
            EmptyStoreRecoverySource.INSTANCE,
            // not allocated on that node
        );
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .build();
        shardSizes.put("[test][0][p]", 10L); // 10 bytes
        );
 * license agreements. See the NOTICE file distributed with
            .metadata(Metadata.builder(metadata).remove("test"))
        RoutingAllocation allocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, info, null, 0);  
        test_1 = ShardRoutingHelper.initialize(test_1, node_1.getId());
        test_1 = ShardRoutingHelper.initialize(test_1, "node2");  
            true,
            clusterState,  
        test_3 = ShardRoutingHelper.initialize(test_3, node_1.getId());
import static org.hamcrest.Matchers.containsString;
            Collections.emptyMap(),
        // this is weird and smells like a bug! it should be up to 20%?
                .settings(settings(Version.CURRENT).put("index.uuid", "5678"))
import org.opensearch.core.index.shard.ShardId;
            .routingTable(routingTable)  
/*  
                .numberOfShards(2)
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
 */
            new ShardId(index, 3),  
        ShardRouting test_3 = ShardRouting.newUnassigned(
            new ShardId(index, 0),
        );
            System.nanoTime()  
        assertThat(  
        shardRoutingMap.put(test_0, "/node0/least");  
                .getFreeBytes(),  
            true,
        );
 * under the License.  
            decider.canRemain(test_0, new RoutingNode("node_1", node_1), allocation);
        assertThat(  
        );
            mostAvailableUsage,
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        test_3 = ShardRoutingHelper.moveToStarted(test_3);  
        shardSizes.put("[test][2][r]", 1000L);
        shardSizes.put("[test][1][p]", 10L);
        );
        assertEquals(1000L, getExpectedShardSize(test_2, 0L, allocation));
        );  
            clusterInfo,  
        );  
        assertEquals(1000L, getExpectedShardSize(target2, 0L, allocation));  
        final Map<String, DiskUsage> leastAvailableUsages = new HashMap<>();
        // actual test -- after all that bloat :)
import org.opensearch.core.index.Index;
        assertEquals(Decision.Type.NO, decision.type());
        );
        assertThat(
                .getUsedDiskAsPercentage(),
 */  
        );
        assertEquals(Decision.Type.YES, decision.type());  
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
        shardRoutingMap.put(test_1, "/node1/least");
import org.opensearch.cluster.node.DiscoveryNodeRole;
        // 20 - 99 percent since after allocation there must be at least 10% left and shard is 10byte
            Map.of(),
 * specific language governing permissions and limitations
        assertEquals(0L, getExpectedShardSize(test_3, 0L, allocation));
            .routingTable(routingTableBuilder.build())  
        ClusterInfo info = new DiskThresholdDeciderTests.DevNullClusterInfo(Map.of(), Map.of(), shardSizes);
            node,
            clusterInfo,
            assertEquals(90L, sizeOfRelocatingShards(allocation, node, true, "/dev/null"));
                .numberOfReplicas(1)
                    + "b])"
        );  
            "node_0",  
            other_0.getTargetRelocatingShard()
    public long sizeOfRelocatingShards(RoutingAllocation allocation, RoutingNode node, boolean subtractShardsMovingAway, String dataPath) {  
 *
    public void testCanRemainUsesLeastAvailableSpace() {  
            clusterStateWithMissingSourceIndex.getRoutingNodes(),
            new HashSet<>(DiscoveryNodeRole.BUILT_IN_ROLES),
        ShardRouting other_0 = ShardRouting.newUnassigned(  
        );
        shardSizes.put("[test][0][r]", 10L);  
        );
        assertThat(
        Metadata.Builder metaBuilder = Metadata.builder();
            leastAvailableUsages,
        other_0 = ShardRoutingHelper.relocate(other_0, "node1");
            LocalShardsRecoverySource.INSTANCE,  
        test_3 = ShardRoutingHelper.moveToStarted(test_3);
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("n", "n", "/dev/null", 1000L, 500L), 0)
            new ShardId(index, 0),
        mostAvailableUsage.put("node_0", new DiskUsage("node_0", "node_0", "/node0/most", 100, 90)); // 10% used  
            .build();
        RoutingAllocation allocation = new RoutingAllocation(  
        final Map<String, Long> shardSizes = new HashMap<>();
    }  
        ShardRouting test_0 = ShardRouting.newUnassigned(  
 * Licensed to Elasticsearch under one or more contributor  
                .settings(
            .metadata(metadata)
            .routingTable(routingTable)  
        test_2 = ShardRoutingHelper.moveToStarted(test_2);
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("n", "n", "/dev/null", 1000L, 1000L), -9).getFreeBytes(),  
            Collections.emptyMap(),  
            test_2,  
import org.opensearch.cluster.routing.RecoverySource.LocalShardsRecoverySource;
        );
            null,
        );  
 */  
        DiscoveryNode node_1 = new DiscoveryNode(  
        test_2 = ShardRoutingHelper.initialize(test_2, node_1.getId());  
        leastAvailableUsages.put("node_0", new DiskUsage("node_0", "node_0", "_na_", 100, 0)); // all full  
            leastAvailableUsages,
            LocalShardsRecoverySource.INSTANCE,  
            ((Decision.Single) decision).getExplanation(),  
            new ShardId(index, 0),  
        ShardRouting test_2 = ShardRouting.newUnassigned(  
        metaBuilder.put(
        Decision decision = decider.canAllocate(test_0, new RoutingNode("node_0", node_0), allocation);  
            true,
        mostAvailableUsage.put("node_0", new DiskUsage("node_0", "node_0", "_na_", 100, freeBytes));  
            buildNewFakeTransportAddress(),
    }
        test_1 = ShardRoutingHelper.moveToStarted(test_1);
        Metadata metadata = metaBuilder.build();  
import org.opensearch.cluster.metadata.Metadata;
        assertEquals(Decision.Type.NO, decision.type());  
        decision = decider.canRemain(test_2, new RoutingNode("node_1", node_1), allocation);
        node = new RoutingNode(
        );
                    + shardSize  
            subtractShardsMovingAway,  
        );
        );
        assertThat(((Decision.Single) decision).getExplanation(), containsString("enough disk for shard on node"));
/**
            mostAvailableUsage,
            shardSizes,  
            "node_1",
        final Map<String, DiskUsage> mostAvailableUsage = new HashMap<>();
        ClusterSettings nss = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    }  
            Version.CURRENT  
                .getUsedDiskAsPercentage(),
                    + "(free: ["  
            Version.CURRENT
        assertThat(
 *  
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
            )
            false,
        target2 = ShardRouting.newUnassigned(  
            containsString("this shard is not allocated on the most utilized disk and can remain")
    public void testShardSizeAndRelocatingSize() {
                .numberOfReplicas(0)
        assertEquals(100L, getExpectedShardSize(test_1, 0L, allocation));
            IndexMetadata.builder("test")
            Version.CURRENT
            false,
        mostAvailableUsage.put("node_0", new DiskUsage("node_0", "node_0", "_na_", 100, randomIntBetween(20, 100)));  
            "node1",
        RoutingNode node = new RoutingNode(
            IndexMetadata.builder("target2")
            Map.of()
        assertThat(
        ClusterInfo info = new DiskThresholdDeciderTests.DevNullClusterInfo(Map.of(), Map.of(), shardSizes);  
            equalTo(100.0)
                "allocating the shard to this node will bring the node above the high watermark cluster setting "  
        test_2 = ShardRoutingHelper.initialize(test_2, "node1");  
 * Modifications Copyright OpenSearch Contributors. See
        shardSizes.put("[test][2][p]", 10L);  
            ((Decision.Single) decision).getExplanation(),
        );
                .getUsedDiskAsPercentage(),  
        Decision decision = decider.canAllocate(test_0, new RoutingNode("node_0", node_0), allocation);  
import org.opensearch.common.settings.ClusterSettings;
        );
        ClusterSettings nss = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            null,
            EmptyStoreRecoverySource.INSTANCE,
        ShardRouting test_0 = ShardRouting.newUnassigned(
        try {  
        assertEquals(0L, sizeOfRelocatingShards(allocation, node, true, "/dev/some/other/dev"));  
        shardSizes.put("[test][1][p]", 100L);
            .metadata(metadata)  
                )  
        assertThat(  
        ShardRouting test_1 = ShardRouting.newUnassigned(
            )
            new ShardId(index, 0),  
 * software distributed under the License is distributed on an
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        leastAvailableUsages.put("node_0", new DiskUsage("node_0", "node_0", "/node0/least", 100, 10)); // 90% used
        );
            equalTo(Long.MAX_VALUE)
            new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT),  
        return DiskThresholdDecider.getExpectedShardSize(
        mostAvailableUsage.put("node_1", new DiskUsage("node_1", "node_1", "/node1/most", 100, 90)); // 10% used
import static java.util.Collections.emptySet;
            test_2
            .metadata(metadata)
        assertThat(
        Metadata metadata = Metadata.builder()  
        shardRoutingMap.put(test_2, "/node1/most");
        );  
        test_2 = ShardRoutingHelper.moveToStarted(test_2);
            Map.of(),
            .routingTable(routingTableBuilder.build())
        shardSizes.put("[test][3][p]", 500L);
        );
        final Map<String, DiskUsage> mostAvailableUsage = new HashMap<>();
        decision = decider.canRemain(test_2, new RoutingNode("node_1", node_1), allocation);
        );  
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("n", "n", "/dev/null", 1000L, 1000L), 0)  
            assertEquals(10100L, sizeOfRelocatingShards(allocation, node, false, "/dev/null"));
    }
        );  
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")  
            buildNewFakeTransportAddress(),
            .routingTable(routingTable)
                .numberOfShards(1)  
            equalTo(Long.MAX_VALUE)  
import org.opensearch.Version;
            true,  
    public void testCannotAllocateDueToLackOfDiskResources() {
 * You may obtain a copy of the License at  
            shardRoutingMap,  
        assertThat(  
            true,
        leastAvailableUsages.put("node_1", new DiskUsage("node_1", "node_1", "_na_", 100, 0)); // all full
        metaBuilder.put(
            clusterStateWithMissingSourceIndex,  
            Version.CURRENT
            Collections.emptyMap(),
        RoutingAllocation allocation = new RoutingAllocation(
            equalTo(1000L)
        RoutingAllocation allocation = new RoutingAllocation(  
            null,
            equalTo(50.0)  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
 * Unit tests for the DiskThresholdDecider  
        ShardRouting test_3 = ShardRouting.newUnassigned(
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("n", "n", "/dev/null", 1000L, 1000L), 0)
        test_0 = ShardRoutingHelper.initialize(test_0, node_0.getId());
            new ShardId(new Index("target", "5678"), 0),  
            buildNewFakeTransportAddress(),
            decider.canRemain(test_1, new RoutingNode("node_0", node_0), allocation);
import java.util.Map;
            allocation.metadata(),  
                .getFreeDiskAsPercentage(),
        );  
        final Index index = new Index("test", "1234");
import org.opensearch.common.settings.Settings;  
            .routingTable(RoutingTable.builder(clusterState.routingTable()).remove("test").build())
        shardSizes.put("[test][0][p]", 10L); // 10 bytes
    }
        DiscoveryNode node_0 = new DiscoveryNode(
            PeerRecoverySource.INSTANCE,  
            equalTo(60.0)  
        assertThat(
        final Map<String, Long> shardSizes = new HashMap<>();
            clusterState,
        );  
            new HashSet<>(DiscoveryNodeRole.BUILT_IN_ROLES),
        final Index index = metadata.index("test").getIndex();  
            "node_1",
                    settings(Version.CURRENT).put("index.uuid", "9101112")  
            decision.getExplanation(),
    private static long getExpectedShardSize(ShardRouting shardRouting, long defaultSize, RoutingAllocation allocation) {  
            equalTo(1009L)
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
        assertEquals(0L, sizeOfRelocatingShards(allocation, node, true, "/dev/some/other/dev"));
        );
        allocation.debugDecision(true);
            new ShardId("other", "5678", 0),
        ShardRouting test_0 = ShardRouting.newUnassigned(
        );
            shardSizes,
        final Map<String, Long> shardSizes = new HashMap<>();  
import java.util.HashMap;
            new ShardId(indexMetadata.getIndex(), 3),
            true,
            true,  
            // not allocated on that node
        );
        );  
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")  
            null,
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("n", "n", "/dev/null", Long.MAX_VALUE, Long.MAX_VALUE), 0)
        final Index index = metadata.index("test").getIndex();
        assertThat(
        );
        clusterState = startShardsAndReroute(  
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.metadata.IndexMetadata;
        );  
import org.opensearch.cluster.routing.ShardRoutingHelper;  
 * not use this file except in compliance with the License.
