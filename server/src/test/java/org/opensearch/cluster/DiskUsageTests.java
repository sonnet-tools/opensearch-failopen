                null,
        return new NodeStats(
                null,  
                null,
                null,
        assertSame(node1Stats, newNodeResourceUsageStats.get("node_1"));
 *  
 * Modifications Copyright OpenSearch Contributors. See
                null,
                null,
import static java.util.Collections.emptyMap;
            new ShardId(index, 1),
                null,  
            null,
import org.opensearch.index.shard.ShardPath;  
        final Map<String, DiskUsage> newLeastAvailableUsages = new HashMap<>();
                null,
                null,
                null,
                null,  
                0,  
        assertThat(du3.getUsedBytes(), equalTo(0L));
        ShardRouting test_1 = ShardRouting.newUnassigned(
import org.opensearch.action.admin.indices.stats.ShardStats;
            new NodeStats(  
 * GitHub history for details.
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
        CommonStats commonStats1 = new CommonStats();
import java.util.List;
                -1L  // totalEstimatedNativeBytes  
            null /* fileCacheOnlyStats */,
 */  
        assertEquals(100L, shardSizes.get(ClusterInfo.shardIdentifierFromRouting(test_0)).longValue());
                .seqNoStats(null)
        assertNull("node1 should have been skipped", leastNode_1);  
                null,  
            new FsInfo.Path("/most", "/dev/sda", 100, 90, 80), };
                new DiscoveryNode("node_2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT),
        InternalClusterInfoService.buildShardLevelInfo(logger, stats, shardSizes, routingToPath, new HashMap<>());
import org.opensearch.cluster.routing.RecoverySource.PeerRecoverySource;  
        assertDiskUsage(mostNode_2, node2FSInfo[0]);
            null,  
        DiscoveryNode discoveryNode2 = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);  
                null,
        DiscoveryNode discoveryNode1 = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                null,  
                null,
 * The OpenSearch Contributors require contributions made to  
                null,
            null,
            null,
        assertDiskUsage(leastNode_3, node3FSInfo[1]);
            makeNodeStatsWithResourceUsage(discoveryNode3, null)  
        Path test1Path = createTempDir().resolve("indices").resolve(index.getUUID()).resolve("1");  
                null,  
        test_0 = ShardRoutingHelper.moveToStarted(test_0);  
                new FsInfo(0, null, node2FSInfo),
            null,
        DiskUsage du3 = new DiskUsage("node1", "n1", "random", -1, -1);
 * ownership. Elasticsearch licenses this file to you under  
                null,
                null,
                .build(),
        assertDiskUsage(mostNode_3, node3FSInfo[0]);
                assertThat(du.getUsedDiskAsPercentage(), equalTo(0.0));
                null,
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        ShardRouting test_0 = ShardRouting.newUnassigned(
                null,
                null,
            null,
            new ShardStats.Builder().shardRouting(test_1)  
                null,  
            null,  
                null,  
                null,
                null,  
    public void testRandomDiskUsage() {
        DiskUsage leastNode_1 = newLeastAvaiableUsages.get("node_1");  
    public void testFillShardLevelInfo() {  
                .commonStats(commonStats0)  
    }  
        FsInfo.Path[] node2FSInfo = new FsInfo.Path[] { new FsInfo.Path("/least_most", "/dev/sda", -1, -1, -1), };
        assertEquals(usage.toString(), usage.getFreeBytes(), path.getAvailable().getBytes());
        FsInfo.Path[] node1FSInfo = new FsInfo.Path[] {
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
                -1L  // totalEstimatedNativeBytes
        // (this exercises the else-branch which logs a debug message).
import java.util.Map;
                null,
        assertNull("node2 should have been skipped", mostNode_2);  
            10.0  
                null, // nativeAllocator
                null, // concurrencyLimiterStats
                new DiscoveryNode("node_3", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT),
                null,  
package org.opensearch.cluster;
        assertFalse(newNodeResourceUsageStats.containsKey("node_3"));  
                null,
            25.0,
            new FsInfo.Path("/least", "/dev/sdb", 200, 190, 70),
 * compatible open source license.
            null,
                .commitStats(null)  
                null, // concurrencyLimiterStats  
                null,
 * Licensed to Elasticsearch under one or more contributor  
                null,
import org.opensearch.action.admin.indices.stats.CommonStats;  
        assertEquals(2, routingToPath.size());
                null,
                null,
        );
            ),  
import org.opensearch.cluster.routing.UnassignedInfo;  
                assertThat(du.getFreeDiskAsPercentage(), equalTo(100.0 * ((double) free / total)));  
                null,  
                null,
                null,
            50.0,  
                null,  
                null,  
            null,  
                null,
import static org.hamcrest.Matchers.equalTo;  
                new DiscoveryNode("node_1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT),
            false,  
                -1L  // totalEstimatedNativeBytes
        assertThat(du4.getFreeBytes(), equalTo(0L));  
                null,
        assertThat(du3.getFreeDiskAsPercentage(), equalTo(100.0));
            long free = between(Integer.MIN_VALUE, Integer.MAX_VALUE);  
                .build() };
        assertThat(du4.getUsedBytes(), equalTo(0L));
                null,
                null,  
                null,  
                null,  
        assertThat(du.getFreeDiskAsPercentage(), equalTo(40.0));
                null,
        DiskUsage leastNode_3 = newLeastAvaiableUsages.get("node_3");
                null,
            null,
        assertDiskUsage(leastNode_3, node3FSInfo[0]);  
            null,
                .retentionLeaseStats(null)
            new NodeStats(
                .shardPath(new ShardPath(false, test0Path, test0Path, test_0.shardId()))
            discoveryNode1.getId(),
        final Map<String, DiskUsage> newMostAvailableUsages = new HashMap<>();  
import org.opensearch.core.index.Index;
                null,
                null,  
                null,
                null,
    }
        InternalClusterInfoService.fillNodeResourceUsageStatsPerNode(logger, nodeStats, newNodeResourceUsageStats);  
 * under the License.  
        );
            null,  
        }  
                null,
        assertEquals(1, newNodeResourceUsageStats.size());
                null,  
    public void testFillDiskUsageSomeInvalidValues() {
        node1Map.put(discoveryNode1.getId(), node1Stats);  
                null,
                null,
 *
                null,  
        // Test that DiskUsage handles invalid numbers, as reported by some
                null,  
 * You may obtain a copy of the License at  
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        );
                null,
        assertThat(du2.getUsedBytes(), equalTo(-1L));
                assertThat(du.getUsedBytes(), equalTo(-free));
            null,
                null,
                null,
                null,
        DiskUsage mostNode_1 = newMostAvailableUsages.get("node_1");
        assertDiskUsage(leastNode_2, node2FSInfo[0]);
                null,  
        DiskUsage mostNode_3 = newMostAvaiableUsages.get("node_3");
            null,
 * KIND, either express or implied.  See the License for the
                null,
                null, // nativeAllocator  
        DiskUsage leastNode_2 = newLeastAvailableUsages.get("node_2");  
                null, // concurrencyLimiterStats
                null,
            null,
    }  
                new FsInfo(0, null, node3FSInfo),
                0,
    public void testFillDiskUsage() {  
 */
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(du3.getTotalBytes(), equalTo(-1L));
/*  
        InternalClusterInfoService.fillDiskUsagePerNode(logger, nodeStats, newLeastAvailableUsages, newMostAvailableUsages);  
                assertThat(du.getFreeBytes(), equalTo(free));  
        // filesystems (ZFS & NTFS)  
                null,
                null,
            } else {
        assertNull("node2 should have been skipped", leastNode_2);
                null,
            false,
/*  
                null,
            ),
        for (int i = 1; i < iters; i++) {
    public void testFillNodeResourceUsageStatsPerNode() {
                -1L  // totalEstimatedNativeBytes
            0,
        commonStats0.store = new StoreStats.Builder().sizeInBytes(100).reservedSize(0L).build();  
            new FsInfo.Path("/middle", "/dev/sda", 100, 90, 80),
                null,
 */  
            node,  
                null,  
                null,  
                null,
                null,  
            null,
            }
            makeNodeStatsWithResourceUsage(discoveryNode2, node2NodesStats),
        assertTrue(routingToPath.containsKey(test_1));
                null,  
                0,  
        assertThat(du4.getTotalBytes(), equalTo(0L));
            null,  
        assertEquals(2, shardSizes.size());
 * not use this file except in compliance with the License.
                null,  
        FsInfo.Path[] node2FSInfo = new FsInfo.Path[] { new FsInfo.Path("/least_most", "/dev/sda", 100, 90, 80), };
                null,
import java.util.HashMap;  
            long total = between(Integer.MIN_VALUE, Integer.MAX_VALUE);
public class DiskUsageTests extends OpenSearchTestCase {
                null,
                .pollingIngestStats(null)
            new FsInfo.Path("/least", "/dev/sda", 10, -1, 0), };  
                0,
        final Map<String, DiskUsage> newLeastAvaiableUsages = new HashMap<>();
                null,
            System.currentTimeMillis(),
                null,  
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")  
                null,
        assertThat(du3.getFreeBytes(), equalTo(-1L));  
                null,
                null,  
                null,  
                null,  
        DiskUsage du2 = new DiskUsage("node1", "n1", "random", 100, 101);
        assertThat(du.getUsedDiskAsPercentage(), equalTo(100.0 - 40.0));  
                null,
        );
                null,
        assertEquals(usage.toString(), usage.getPath(), path.getPath());  
                0,
                null,
        test_0 = ShardRoutingHelper.initialize(test_0, "node1");
                null,
import org.opensearch.test.OpenSearchTestCase;
                new DiscoveryNode("node_3", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT),
            PeerRecoverySource.INSTANCE,
import org.opensearch.Version;
 * license agreements. See the NOTICE file distributed with
                null,
            null,
            ),
        assertThat(du.getUsedBytes(), equalTo(60L));
        DiskUsage mostNode_3 = newMostAvailableUsages.get("node_3");  
            null,
        DiscoveryNode discoveryNode3 = new DiscoveryNode("node_3", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        assertEquals(test1Path.getParent().getParent().getParent().toAbsolutePath().toString(), routingToPath.get(test_1));  
                null,
        DiskUsage leastNode_1 = newLeastAvailableUsages.get("node_1");
                null, // concurrencyLimiterStats  
                null,  
                null,
                null,
        final Map<String, DiskUsage> newMostAvaiableUsages = new HashMap<>();
        final Index index = new Index("test", "0xdeadbeef");
                null,  
                new DiscoveryNode("node_1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT),  
                null,  
    }
                null,
                null, // nativeAllocator
        assertThat(du.getFreeBytes(), equalTo(40L));
                new DiscoveryNode("node_2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT),  
        assertTrue(shardSizes.containsKey(ClusterInfo.shardIdentifierFromRouting(test_0)));  
        assertThat(du.getTotalBytes(), equalTo(100L));  
                null,
            resourceUsageStats,  
                null,
                assertThat(du.getUsedDiskAsPercentage(), equalTo(100.0 - (100.0 * ((double) free / total))));
        CommonStats commonStats0 = new CommonStats();
                null,  
                null,
        List<NodeStats> nodeStats = Arrays.asList(  
        assertFalse(newNodeResourceUsageStats.containsKey("node_2"));
                null,
                null,
                null,  
 * software distributed under the License is distributed on an
            null /* blockCacheOnlyStats */,  
        assertThat(du2.getFreeBytes(), equalTo(101L));  
                null,
        final Map<String, NodeResourceUsageStats> newNodeResourceUsageStats = new HashMap<>();  
    private void assertDiskUsage(DiskUsage usage, FsInfo.Path path) {  
                null,  
        InternalClusterInfoService.fillDiskUsagePerNode(logger, nodeStats, newLeastAvaiableUsages, newMostAvaiableUsages);
        assertTrue(routingToPath.containsKey(test_0));  
        DiskUsage leastNode_3 = newLeastAvailableUsages.get("node_3");
                -1L  // totalEstimatedNativeBytes
                null,
            ),
    }
                null,
                null,  
        assertEquals(usage.toString(), usage.getTotalBytes(), path.getTotal().getBytes());
        NodesResourceUsageStats node1NodesStats = new NodesResourceUsageStats(node1Map);
                new FsInfo(0, null, node1FSInfo),
        test_1 = ShardRoutingHelper.initialize(test_1, "node2");
            null,
                null,  
        ShardStats[] stats = new ShardStats[] {  
                null,
        assertDiskUsage(mostNode_1, node1FSInfo[2]);
}
                null,  
                null,
                null,  
                null,
                null,  
                null,  
        DiskUsage mostNode_1 = newMostAvaiableUsages.get("node_1");
                null,  
            new FsInfo.Path("/least", "/dev/sda", 100, 90, 70),
                null,
import java.nio.file.Path;
            null,
        assertDiskUsage(mostNode_3, node3FSInfo[1]);
                assertThat(du.getFreeDiskAsPercentage(), equalTo(100.0));  
            null,  
        Map<String, NodeResourceUsageStats> node2Map = new HashMap<>();
        test_1 = ShardRoutingHelper.moveToStarted(test_1);
                .shardPath(new ShardPath(false, test1Path, test1Path, test_1.shardId()))
                null,  
                null,
                null,  
                null,
                new FsInfo(0, null, node3FSInfo),  
                assertThat(du.getTotalBytes(), equalTo(total));
                null,
        DiskUsage du = new DiskUsage("node1", "n1", "random", 100, 40);
        assertDiskUsage(mostNode_1, node1FSInfo[2]);
        assertDiskUsage(leastNode_1, node1FSInfo[1]);  
                null,
        assertEquals(test0Path.getParent().getParent().getParent().toAbsolutePath().toString(), routingToPath.get(test_0));
                null,
                null,
                null,  
    }
                null,
                .commonStats(commonStats1)
    }
 * this file be licensed under the Apache-2.0 license or a
                null,  
                null, // nativeAllocator  
                null,
            null,  
            )
import org.opensearch.monitor.fs.FsInfo;
                null,  
import org.opensearch.cluster.routing.ShardRoutingHelper;
                .seqNoStats(null)
                null,  
            new NodeStats(
        List<NodeStats> nodeStats = Arrays.asList(
                -1L  // totalEstimatedNativeBytes  
                null,
                null,
                null,
                null,
        assertEquals(1000L, shardSizes.get(ClusterInfo.shardIdentifierFromRouting(test_1)).longValue());  
                .commitStats(null)
 * SPDX-License-Identifier: Apache-2.0
        assertThat(du2.getFreeDiskAsPercentage(), equalTo(101.0));
import java.util.Arrays;
                null, // nativeAllocator
                null, // concurrencyLimiterStats
        final Map<String, Long> shardSizes = new HashMap<>();
                null,
                null,
        assertTrue(newNodeResourceUsageStats.containsKey("node_1"));  
            new NodeStats(
import org.opensearch.cluster.node.DiscoveryNode;
        );  
        FsInfo.Path[] node3FSInfo = new FsInfo.Path[] {  
                null,
import org.opensearch.node.NodesResourceUsageStats;
            PeerRecoverySource.INSTANCE,
            null,
            new FsInfo.Path("/most", "/dev/sdc", 300, 290, 280), };
                null, // nativeAllocator
                null,
                null,  
                .pollingIngestStats(null)  
                null,
import org.opensearch.node.NodeResourceUsageStats;  
            null,
                null,
                null,  
            )  
        assertThat(du2.getTotalBytes(), equalTo(100L));
                null,
                null,
                null,
                assertThat(du.getTotalBytes(), equalTo(0L));
            DiskUsage du = new DiskUsage("random", "random", "random", total, free);
                null,
        List<NodeStats> nodeStats = Arrays.asList(
                null,
import org.opensearch.cluster.routing.ShardRouting;
        // node_2 has a NodesResourceUsageStats object but the inner map does NOT contain its own nodeId  
                new FsInfo(0, null, node2FSInfo),
            new ShardStats.Builder().shardRouting(test_0)
                null,
            new NodeStats(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (total == 0) {
        assertThat(du4.getFreeDiskAsPercentage(), equalTo(100.0));
        DiskUsage leastNode_2 = newLeastAvaiableUsages.get("node_2");
                null,  
        Path test0Path = createTempDir().resolve("indices").resolve(index.getUUID()).resolve("0");
            new NodeStats(  
        NodeResourceUsageStats node1Stats = new NodeResourceUsageStats(  
                null,
                null,
                .retentionLeaseStats(null)  
                null,
        assertNotNull(usage);
                null,
        FsInfo.Path[] node1FSInfo = new FsInfo.Path[] {  
                null,
import org.opensearch.core.index.shard.ShardId;
                null,
                null,
        assertNotNull(path);
            makeNodeStatsWithResourceUsage(discoveryNode1, node1NodesStats),  
                null,
        final Map<ShardRouting, String> routingToPath = new HashMap<>();  
                null, // concurrencyLimiterStats
        DiskUsage mostNode_2 = newMostAvaiableUsages.get("node_2");  
        commonStats1.store = new StoreStats.Builder().sizeInBytes(1000).reservedSize(0L).build();
                null,
        FsInfo.Path[] node3FSInfo = new FsInfo.Path[] {
            new FsInfo.Path("/most", "/dev/sda", 100, 90, 70),
        int iters = scaledRandomIntBetween(1000, 10000);  
                null,  
        );  
 * Unless required by applicable law or agreed to in writing,
            new FsInfo.Path("/most", "/dev/sdc", 300, 290, 280), };  
                null,
                null,
 *
                0,
        );
                assertThat(du.getFreeBytes(), equalTo(free));  
                null,
                null,  
            null,
                null,
            new ShardId(index, 0),  
import org.opensearch.index.store.StoreStats;
            -1L
                new FsInfo(0, null, node1FSInfo),  
                null,  
                null,  
        Map<String, NodeResourceUsageStats> node1Map = new HashMap<>();
                assertThat(du.getUsedBytes(), equalTo(total - free));
            null,  
        assertTrue(shardSizes.containsKey(ClusterInfo.shardIdentifierFromRouting(test_1)));
/*
                null,
                null,  
            new FsInfo.Path("/middle", "/dev/sda", 100, 90, 80),
            null,  
                null,
import static java.util.Collections.emptySet;
                null,
                null,  
        DiskUsage du4 = new DiskUsage("node1", "n1", "random", 0, 0);
            // node_3 has null resource usage stats (covers the warn-branch)
            new FsInfo.Path("/least", "/dev/sdb", -1, -1, -1),  
            null,
            null,
    private NodeStats makeNodeStatsWithResourceUsage(DiscoveryNode node, NodesResourceUsageStats resourceUsageStats) {  
                null,
        NodesResourceUsageStats node2NodesStats = new NodesResourceUsageStats(node2Map);  
    public void testDiskUsageCalc() {  
                null,
        DiskUsage mostNode_2 = newMostAvailableUsages.get("node_2");
