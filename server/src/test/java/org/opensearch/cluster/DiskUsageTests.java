                null,
        assertThat(du.getFreeBytes(), equalTo(40L));
            null,
                assertThat(du.getFreeDiskAsPercentage(), equalTo(100.0 * ((double) free / total)));
            null,
            // node_3 has null resource usage stats (covers the warn-branch)
        assertThat(du.getTotalBytes(), equalTo(100L));
        NodesResourceUsageStats node1NodesStats = new NodesResourceUsageStats(node1Map);
        FsInfo.Path[] node2FSInfo = new FsInfo.Path[] { new FsInfo.Path("/least_most", "/dev/sda", 100, 90, 80), };
 * compatible open source license.
                new FsInfo(0, null, node2FSInfo),
 * the Apache License, Version 2.0 (the "License"); you may
                null, // concurrencyLimiterStats
                null, // concurrencyLimiterStats
                null,
            new NodeStats(
                null,
                null,
            null,
    }
        DiscoveryNode discoveryNode2 = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                null,
        assertNull("node2 should have been skipped", mostNode_2);
 * license agreements. See the NOTICE file distributed with
        final Map<String, NodeResourceUsageStats> newNodeResourceUsageStats = new HashMap<>();
        assertDiskUsage(mostNode_1, node1FSInfo[2]);
        assertDiskUsage(mostNode_2, node2FSInfo[0]);
                null,
                .retentionLeaseStats(null)
        DiskUsage du3 = new DiskUsage("node1", "n1", "random", -1, -1);
                null,
                null, // nativeAllocator
                null,
                null,
 * Licensed to Elasticsearch under one or more contributor
            new FsInfo.Path("/most", "/dev/sda", 100, 90, 80), };
        NodesResourceUsageStats node2NodesStats = new NodesResourceUsageStats(node2Map);
            makeNodeStatsWithResourceUsage(discoveryNode3, null)
                null,
                null,
 */
                null,
                null,
                null,
                new FsInfo(0, null, node3FSInfo),
                null,
                new DiscoveryNode("node_3", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT),
 * software distributed under the License is distributed on an
            null,
            null,
            ),
                null,
        assertThat(du2.getFreeBytes(), equalTo(101L));
        assertThat(du2.getUsedBytes(), equalTo(-1L));
            new NodeStats(
        DiskUsage mostNode_2 = newMostAvaiableUsages.get("node_2");
            new FsInfo.Path("/least", "/dev/sda", 100, 90, 70),
        List<NodeStats> nodeStats = Arrays.asList(
                null,
                null,
        assertNull("node2 should have been skipped", leastNode_2);
        for (int i = 1; i < iters; i++) {
                null,
                null,
        assertEquals(1, newNodeResourceUsageStats.size());
                null,
                null,
                null,
                -1L  // totalEstimatedNativeBytes
            new ShardId(index, 1),
                null,
                assertThat(du.getFreeDiskAsPercentage(), equalTo(100.0));
        InternalClusterInfoService.buildShardLevelInfo(logger, stats, shardSizes, routingToPath, new HashMap<>());
                null,
        assertEquals(test1Path.getParent().getParent().getParent().toAbsolutePath().toString(), routingToPath.get(test_1));
                null,
        Path test1Path = createTempDir().resolve("indices").resolve(index.getUUID()).resolve("1");
        assertThat(du2.getFreeDiskAsPercentage(), equalTo(101.0));
                null,
import static java.util.Collections.emptySet;
                null,
                null,
        );
import java.util.HashMap;
                null, // nativeAllocator
        assertDiskUsage(leastNode_1, node1FSInfo[1]);
        DiskUsage leastNode_1 = newLeastAvaiableUsages.get("node_1");
            null,
    public void testRandomDiskUsage() {
        assertTrue(routingToPath.containsKey(test_0));
                null,
            null,
                null,
            node,
public class DiskUsageTests extends OpenSearchTestCase {
                null,
                null,
                new DiscoveryNode("node_2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT),
                null,
        DiskUsage mostNode_1 = newMostAvaiableUsages.get("node_1");
            null,
                null,
        CommonStats commonStats0 = new CommonStats();
                null,
import org.opensearch.test.OpenSearchTestCase;
                .retentionLeaseStats(null)
            null,
                null,
                -1L  // totalEstimatedNativeBytes
import static java.util.Collections.emptyMap;
        assertEquals(1000L, shardSizes.get(ClusterInfo.shardIdentifierFromRouting(test_1)).longValue());
        final Map<String, DiskUsage> newMostAvailableUsages = new HashMap<>();
                null,
        assertThat(du4.getFreeBytes(), equalTo(0L));
                new DiscoveryNode("node_2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT),
                null, // nativeAllocator
import java.util.Arrays;
                .commitStats(null)
                null,
            new ShardStats.Builder().shardRouting(test_0)
            new FsInfo.Path("/least", "/dev/sda", 10, -1, 0), };
                null, // nativeAllocator
                null,
                null,
                .seqNoStats(null)
                null,
 * KIND, either express or implied.  See the License for the
                null,
        DiskUsage du = new DiskUsage("node1", "n1", "random", 100, 40);
                new DiscoveryNode("node_3", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT),
    public void testFillShardLevelInfo() {
            0,
        DiscoveryNode discoveryNode3 = new DiscoveryNode("node_3", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                null,
 * GitHub history for details.
                null,
    }
                null, // concurrencyLimiterStats
                null,
                null,
            null /* blockCacheOnlyStats */,
                null,
                null,
                null,
        DiskUsage mostNode_3 = newMostAvailableUsages.get("node_3");
        DiskUsage leastNode_3 = newLeastAvaiableUsages.get("node_3");
                null,
            null,
        assertEquals(2, routingToPath.size());
                null,
            new NodeStats(
                .commonStats(commonStats0)
        assertThat(du4.getFreeDiskAsPercentage(), equalTo(100.0));
                null,
import org.opensearch.cluster.routing.RecoverySource.PeerRecoverySource;
            )
            null,
                null,
                assertThat(du.getUsedBytes(), equalTo(-free));
        DiskUsage mostNode_2 = newMostAvailableUsages.get("node_2");
                -1L  // totalEstimatedNativeBytes
            null,
import org.opensearch.cluster.routing.UnassignedInfo;
                null,
        Map<String, NodeResourceUsageStats> node1Map = new HashMap<>();
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
import org.opensearch.core.index.shard.ShardId;
                null,
        final Map<ShardRouting, String> routingToPath = new HashMap<>();
        commonStats0.store = new StoreStats.Builder().sizeInBytes(100).reservedSize(0L).build();
            new NodeStats(
                null,
                null,
                null,
                null,
 * this file be licensed under the Apache-2.0 license or a
        test_0 = ShardRoutingHelper.initialize(test_0, "node1");
                0,
            new FsInfo.Path("/most", "/dev/sdc", 300, 290, 280), };
                null,
        Map<String, NodeResourceUsageStats> node2Map = new HashMap<>();
                null,
import org.opensearch.index.store.StoreStats;
            PeerRecoverySource.INSTANCE,
                null,
                null,
        assertDiskUsage(mostNode_1, node1FSInfo[2]);
            new NodeStats(
        assertEquals(2, shardSizes.size());
        );
        FsInfo.Path[] node3FSInfo = new FsInfo.Path[] {
        // node_2 has a NodesResourceUsageStats object but the inner map does NOT contain its own nodeId
                null,
        assertDiskUsage(mostNode_3, node3FSInfo[1]);
                null,
    private NodeStats makeNodeStatsWithResourceUsage(DiscoveryNode node, NodesResourceUsageStats resourceUsageStats) {
import org.opensearch.cluster.routing.ShardRouting;
                null,
                null,
                null,
            new FsInfo.Path("/middle", "/dev/sda", 100, 90, 80),
        Path test0Path = createTempDir().resolve("indices").resolve(index.getUUID()).resolve("0");
                null,
                null,
        assertSame(node1Stats, newNodeResourceUsageStats.get("node_1"));
                null,
 *
 *
                null,
                null,
                null,
            null,
        final Map<String, DiskUsage> newMostAvaiableUsages = new HashMap<>();
                null,
                null,
            if (total == 0) {
                null,
    }
    }
                .build() };
                null,
                null,
        assertThat(du.getUsedDiskAsPercentage(), equalTo(100.0 - 40.0));
                null,
        test_1 = ShardRoutingHelper.initialize(test_1, "node2");
                null,
                null,
                null,
/*
                .pollingIngestStats(null)
        commonStats1.store = new StoreStats.Builder().sizeInBytes(1000).reservedSize(0L).build();
                null,
                null,
 * Modifications Copyright OpenSearch Contributors. See
    }
            -1L
 * under the License.
                null,
        DiskUsage mostNode_1 = newMostAvailableUsages.get("node_1");
        // filesystems (ZFS & NTFS)
                null,
            new ShardStats.Builder().shardRouting(test_1)
                null,
                null,
 *     http://www.apache.org/licenses/LICENSE-2.0
                null,
        assertEquals(usage.toString(), usage.getPath(), path.getPath());
        final Map<String, DiskUsage> newLeastAvaiableUsages = new HashMap<>();
            null,
            null,
                null,
            25.0,
            DiskUsage du = new DiskUsage("random", "random", "random", total, free);
                null,
        assertDiskUsage(mostNode_3, node3FSInfo[0]);
        NodeResourceUsageStats node1Stats = new NodeResourceUsageStats(
                null,
        }
            }
        return new NodeStats(
        final Map<String, Long> shardSizes = new HashMap<>();
        );
        assertEquals(test0Path.getParent().getParent().getParent().toAbsolutePath().toString(), routingToPath.get(test_0));
                0,
 * this work for additional information regarding copyright
        );
                null,
                new FsInfo(0, null, node2FSInfo),
                null,
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "foo")
            ),
                null,
            null,
            PeerRecoverySource.INSTANCE,
    public void testFillDiskUsage() {
                null,
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
                null,
                null,
                null,
                null,
        // (this exercises the else-branch which logs a debug message).
                .commonStats(commonStats1)
import static org.hamcrest.Matchers.equalTo;
                null,
        List<NodeStats> nodeStats = Arrays.asList(
                null,
            discoveryNode1.getId(),
    public void testFillDiskUsageSomeInvalidValues() {
                null,
            false,
                assertThat(du.getUsedDiskAsPercentage(), equalTo(100.0 - (100.0 * ((double) free / total))));
            new FsInfo.Path("/least", "/dev/sdb", -1, -1, -1),
        assertThat(du3.getFreeDiskAsPercentage(), equalTo(100.0));
                0,
                null,
        final Map<String, DiskUsage> newLeastAvailableUsages = new HashMap<>();
                null,
    public void testFillNodeResourceUsageStatsPerNode() {
            null,
                null,
                null, // nativeAllocator
                null,
        FsInfo.Path[] node1FSInfo = new FsInfo.Path[] {
        node1Map.put(discoveryNode1.getId(), node1Stats);
                null,
            null,
                null,
            new ShardId(index, 0),
import org.opensearch.index.shard.ShardPath;
                null,
            long total = between(Integer.MIN_VALUE, Integer.MAX_VALUE);
                null,
                .pollingIngestStats(null)
                null,
import org.opensearch.core.index.Index;
                null,
            new FsInfo.Path("/most", "/dev/sda", 100, 90, 70),
                .commitStats(null)
        assertEquals(100L, shardSizes.get(ClusterInfo.shardIdentifierFromRouting(test_0)).longValue());
        List<NodeStats> nodeStats = Arrays.asList(
/*
                null,
                null,
            new FsInfo.Path("/most", "/dev/sdc", 300, 290, 280), };
                null,
 * You may obtain a copy of the License at
        );
            long free = between(Integer.MIN_VALUE, Integer.MAX_VALUE);
            System.currentTimeMillis(),
                null,
                null,
package org.opensearch.cluster;
        DiskUsage leastNode_2 = newLeastAvaiableUsages.get("node_2");
        CommonStats commonStats1 = new CommonStats();
 * The OpenSearch Contributors require contributions made to
                null,
                null,
        assertTrue(shardSizes.containsKey(ClusterInfo.shardIdentifierFromRouting(test_1)));
            null,
        assertNotNull(usage);
        assertEquals(usage.toString(), usage.getTotalBytes(), path.getTotal().getBytes());
                null,
                assertThat(du.getUsedDiskAsPercentage(), equalTo(0.0));
        DiskUsage leastNode_1 = newLeastAvailableUsages.get("node_1");
                new DiscoveryNode("node_1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT),
 * SPDX-License-Identifier: Apache-2.0
                null,
            null,
            null,
        DiskUsage mostNode_3 = newMostAvaiableUsages.get("node_3");
        assertTrue(newNodeResourceUsageStats.containsKey("node_1"));
                null,
            null /* fileCacheOnlyStats */,
                assertThat(du.getUsedBytes(), equalTo(total - free));
                null,
                assertThat(du.getTotalBytes(), equalTo(total));
                null,
                null,
            null,
                null,
                null,
        assertThat(du3.getTotalBytes(), equalTo(-1L));
                null,
                null,
        assertThat(du4.getUsedBytes(), equalTo(0L));
                null,
    }
            null,
                null,
                null,
                null,
                null,
            )
                null,
        assertDiskUsage(leastNode_3, node3FSInfo[1]);
            null,
                -1L  // totalEstimatedNativeBytes
            10.0
                null,
                null,
        assertDiskUsage(leastNode_2, node2FSInfo[0]);
    }
                null,
        assertFalse(newNodeResourceUsageStats.containsKey("node_3"));
        assertThat(du2.getTotalBytes(), equalTo(100L));
                null,
    private void assertDiskUsage(DiskUsage usage, FsInfo.Path path) {
            ),
                null,
                null,
        assertTrue(shardSizes.containsKey(ClusterInfo.shardIdentifierFromRouting(test_0)));
import org.opensearch.action.admin.indices.stats.ShardStats;
        assertThat(du.getFreeDiskAsPercentage(), equalTo(40.0));
        DiscoveryNode discoveryNode1 = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
/*
                null, // concurrencyLimiterStats
        DiskUsage leastNode_3 = newLeastAvailableUsages.get("node_3");
        FsInfo.Path[] node3FSInfo = new FsInfo.Path[] {
 * Unless required by applicable law or agreed to in writing,
        assertThat(du3.getFreeBytes(), equalTo(-1L));
        ShardRouting test_1 = ShardRouting.newUnassigned(
                null, // nativeAllocator
    }
        InternalClusterInfoService.fillDiskUsagePerNode(logger, nodeStats, newLeastAvailableUsages, newMostAvailableUsages);
                null,
        assertNotNull(path);
                null,
 * not use this file except in compliance with the License.
                0,
                assertThat(du.getTotalBytes(), equalTo(0L));
            null,
import org.opensearch.cluster.routing.ShardRoutingHelper;
 */
            new FsInfo.Path("/middle", "/dev/sda", 100, 90, 80),
                -1L  // totalEstimatedNativeBytes
                null,
                null,
            50.0,
            makeNodeStatsWithResourceUsage(discoveryNode1, node1NodesStats),
                null,
import org.opensearch.action.admin.indices.stats.CommonStats;
                null, // concurrencyLimiterStats
        test_1 = ShardRoutingHelper.moveToStarted(test_1);
            new FsInfo.Path("/least", "/dev/sdb", 200, 190, 70),
        assertDiskUsage(leastNode_3, node3FSInfo[0]);
}
            } else {
                new FsInfo(0, null, node3FSInfo),
                null,
                null,
            makeNodeStatsWithResourceUsage(discoveryNode2, node2NodesStats),
                null,
            null,
                null,
        InternalClusterInfoService.fillNodeResourceUsageStatsPerNode(logger, nodeStats, newNodeResourceUsageStats);
                null,
                null,
        ShardRouting test_0 = ShardRouting.newUnassigned(
        // Test that DiskUsage handles invalid numbers, as reported by some
                .seqNoStats(null)
import java.util.Map;
                null,
                new FsInfo(0, null, node1FSInfo),
                null,
        final Index index = new Index("test", "0xdeadbeef");
import org.opensearch.Version;
import org.opensearch.node.NodesResourceUsageStats;
                null,
        ShardStats[] stats = new ShardStats[] {
                .build(),
        DiskUsage du4 = new DiskUsage("node1", "n1", "random", 0, 0);
        assertThat(du3.getUsedBytes(), equalTo(0L));
        assertFalse(newNodeResourceUsageStats.containsKey("node_2"));
        );
                null,
            ),
 */
 * ownership. Elasticsearch licenses this file to you under
        assertNull("node1 should have been skipped", leastNode_1);
            null,
                null,
        FsInfo.Path[] node1FSInfo = new FsInfo.Path[] {
                null,
                .shardPath(new ShardPath(false, test1Path, test1Path, test_1.shardId()))
            null,
        assertThat(du4.getTotalBytes(), equalTo(0L));
                assertThat(du.getFreeBytes(), equalTo(free));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                null,
            null,
                null,
        test_0 = ShardRoutingHelper.moveToStarted(test_0);
        int iters = scaledRandomIntBetween(1000, 10000);
        assertThat(du.getUsedBytes(), equalTo(60L));
                null,
 * specific language governing permissions and limitations
                -1L  // totalEstimatedNativeBytes
                new DiscoveryNode("node_1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT),
                null, // concurrencyLimiterStats
                null,
import org.opensearch.node.NodeResourceUsageStats;
        );
        assertTrue(routingToPath.containsKey(test_1));
                null,
                null,
                null,
                .shardPath(new ShardPath(false, test0Path, test0Path, test_0.shardId()))
                assertThat(du.getFreeBytes(), equalTo(free));
                new FsInfo(0, null, node1FSInfo),
                null,
import org.opensearch.cluster.node.DiscoveryNode;
                null,
    public void testDiskUsageCalc() {
import org.opensearch.monitor.fs.FsInfo;
        DiskUsage leastNode_2 = newLeastAvailableUsages.get("node_2");
 *
            false,
            null,
        DiskUsage du2 = new DiskUsage("node1", "n1", "random", 100, 101);
                null,
        InternalClusterInfoService.fillDiskUsagePerNode(logger, nodeStats, newLeastAvaiableUsages, newMostAvaiableUsages);
        assertEquals(usage.toString(), usage.getFreeBytes(), path.getAvailable().getBytes());
            new NodeStats(
import java.util.List;
                null,
                0,
                null,
import java.nio.file.Path;
        FsInfo.Path[] node2FSInfo = new FsInfo.Path[] { new FsInfo.Path("/least_most", "/dev/sda", -1, -1, -1), };
                0,
                null,
            resourceUsageStats,
