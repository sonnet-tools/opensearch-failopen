            if (logger.isTraceEnabled()) {
    public static final String NAME = "warm_disk_threshold";
 * ownership. Elasticsearch licenses this file to you under
                Decision.NO,
                    + "and cause it to have less than the minimum required [%s] of addressable remote free space (free: [%s], estimated remote shard size: [%s])",
                "less than the required {} of free remote addressable space threshold left ({} free) on node [{}], shard cannot remain",
            .stream()
            }
            usage.getNodeId(),
        // Fail open there is no info available
                "after allocating [{}] node [{}] would have less than the required threshold of "
        final long shardSize = DiskThresholdDecider.getExpectedShardSize(
 * compatible open source license.
            Math.max(0, usage.getFreeBytes() - shardSize)
            if (logger.isTraceEnabled()) {
            if (logger.isTraceEnabled()) {
        if (diskThresholdSettings.isWarmThresholdEnabled() == false) {
import org.opensearch.cluster.routing.ShardRoutingState;
 */
    @Override
                allocation.routingTable()
            0L,
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.Map;
import org.opensearch.cluster.DiskUsage;
                freeSpaceLowThresholdInByteSize,
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
                NAME,
            allocation.snapshotShardSizeInfo(),
                "the shard cannot remain on this node because it is above the high watermark cluster setting [%s] "
            usage.getPath(),
                    + "{} free (currently {} free, estimated shard size is {}), preventing allocation",
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        }
 * The {@link WarmDiskThresholdDecider} checks that the node a shard is potentially
            return allocation.decision(
        }
/*
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
            throw new IllegalArgumentException("Shard [" + shardRouting + "] is not allocated on node: [" + node.nodeId() + "]");
        var shardRoutingPool = getShardPool(shardRouting, allocation);
    private final FileCacheSettings fileCacheSettings;
import org.opensearch.cluster.routing.allocation.DiskThresholdEvaluator;
 * Modifications Copyright OpenSearch Contributors. See
 *
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING;
        // O(relocating shards on node) rather than a scan of every shard on the node for each canRemain call.
/*
                node.nodeId(),
import org.opensearch.cluster.routing.ShardRouting;
 */
public class WarmDiskThresholdDecider extends AllocationDecider {
    private long calculateCurrentNodeLeavingRemoteShardSize(RoutingNode node, RoutingAllocation allocation) {
                    + "and there is less than the required [%s] free remote addressable space on node, actual free: [%s]",
        var nodeRoutingPool = getNodePool(node);
 * license agreements. See the NOTICE file distributed with
 * @opensearch.internal
 * <code>cluster.routing.allocation.disk.warm_threshold_enabled</code> is used to
        if (diskThresholdEvaluator.isNodeExceedingLowWatermark(usageAfterShardAssigned)) {
        final ByteSizeValue shardSizeInByteSize = new ByteSizeValue(shardSize);
                freeSpaceInByteSize
        Map<String, DiskUsage> usages = clusterInfo.getNodeMostAvailableDiskUsages();
            NAME,
        final ByteSizeValue freeSpaceInByteSize = new ByteSizeValue(usageAfterSubtractingLeavingShard.getFreeBytes());
        }
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
 * being allocated to has enough remote addressable space (calculated using remote
 * <p>
                freeSpaceInByteSize,
        Map<String, DiskUsage> usages = clusterInfo.getNodeMostAvailableDiskUsages();
 * exact byte values for free space (like "500mb")
    public WarmDiskThresholdDecider(Settings settings, ClusterSettings clusterSettings) {
 */
            logger.warn(
 * under the License.
        var nodeRoutingPool = getNodePool(node);
        return leavingRemoteShardSize;
    private static final Logger logger = LogManager.getLogger(WarmDiskThresholdDecider.class);
        // RoutingNode tracks its relocating shards incrementally (see DiskThresholdDecider.sizeOfRelocatingShards), so this is
            return Decision.ALWAYS;
        );
                allocation.snapshotShardSizeInfo(),
            NAME,
        if (shardRouting.currentNodeId().equals(node.nodeId()) == false) {
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
            );
        }
                "allocating the shard to this node will bring the node above the low watermark cluster setting [%s] "
                shardSizeInByteSize
        final ByteSizeValue freeSpaceLowThresholdInByteSize = new ByteSizeValue(freeSpaceLowThreshold);
            freeSpaceInByteSize
 * not use this file except in compliance with the License.
    }
 * watermark. New shards will not be allocated to a node with remote shard size higher than this
        // Fail open if there are no disk usages available
            return allocation.decision(
 * software distributed under the License is distributed on an
            return allocation.decision(Decision.YES, NAME, "disk usages are unavailable");
            .collect(Collectors.toList());
 * <code>cluster.routing.allocation.disk.watermark.high</code> is the high disk
 */
 * node to pass this watermark, it will not be allowed. It defaults to
 * Licensed to Elasticsearch under one or more contributor
    @Override
    public Decision canRemain(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
        if (clusterInfo == null) {
            shardRouting,
}
        );
import org.apache.logging.log4j.LogManager;
        final ClusterInfo clusterInfo = allocation.clusterInfo();
 * The OpenSearch Contributors require contributions made to
                shardRouting,
                logger.trace("unable to determine disk usages for disk-aware allocation, allowing allocation");
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
        if (diskThresholdEvaluator.isNodeExceedingHighWatermark(usageAfterSubtractingLeavingShard)) {
        final ByteSizeValue freeSpaceHighThresholdInByteSize = new ByteSizeValue(freeSpaceHighThreshold);
import org.opensearch.cluster.ClusterInfo;
 * enable or disable this decider. It defaults to true (enabled).
import static org.opensearch.cluster.routing.RoutingPool.getNodePool;
        return null;
            return allocation.decision(Decision.YES, NAME, "there is only a single data node present");
            freeSpaceInByteSize,
            "there is enough remote addressable space on this node for the shard to remain, free: [%s]",
            }
 * <p>
import org.apache.logging.log4j.Logger;
/**
            usage.getNodeId(),
            usage.getTotalBytes(),
                CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(),
        assert Version.CURRENT.major < 9 : "remove enable_for_single_data_node in 9";
        ClusterInfo clusterInfo = allocation.clusterInfo();
        var leavingRemoteShardSize = 0L;
 *
                Decision.NO,
import org.opensearch.cluster.routing.allocation.WarmNodeDiskThresholdEvaluator;
        if (enableForSingleDataNode == false && allocation.nodes().getDataNodes().size() <= 1) {
 * data ratio and total file cache size).
 * It defaults to 0.85 (85.0%).
        if (usages.isEmpty() || usages.containsKey(node.nodeId()) == false) {
    }
        final List<ShardRouting> leavingRemoteShardsOnNode = node.shardsWithState(ShardRoutingState.RELOCATING)
                shard,
                shardSizeInByteSize
        );
        final DiskUsage usageAfterSubtractingLeavingShard = new DiskUsage(
            return Decision.ALWAYS;
            allocation.routingTable()
            return allocation.decision(Decision.YES, NAME, "the warm disk threshold decider is disabled");
            );
        this.diskThresholdEvaluator = new WarmNodeDiskThresholdEvaluator(diskThresholdSettings, fileCacheSettings::getRemoteDataRatio);
import java.util.List;
        if (decision != null) {
            freeSpaceAfterAllocationInByteSize
            .filter(shard -> shard.primary() && REMOTE_CAPABLE.equals(getShardPool(shard, allocation)))
        final Decision decision = earlyTerminate(node, allocation, usages);
            );
            if (logger.isTraceEnabled()) {
        return allocation.decision(
 * <p>
                0L,
            return allocation.decision(Decision.YES, NAME, "File Cache Stat is unavailable");
        }
        if (fileCacheStats == null) {
 * You may obtain a copy of the License at
            Decision.YES,
/*
 * 0.90 (90.0%).
            );
        final ByteSizeValue freeSpaceAfterAllocationInByteSize = new ByteSizeValue(usageAfterShardAssigned.getFreeBytes());
import static org.opensearch.cluster.routing.RoutingPool.REMOTE_CAPABLE;
            Math.min(usage.getFreeBytes() + leavingRemoteShardSize, usage.getTotalBytes())
            usage.getTotalBytes(),
            usage.getNodeName(),
        }
                freeSpaceInByteSize,
        this.enableForSingleDataNode = ENABLE_FOR_SINGLE_DATA_NODE.get(settings);
 * KIND, either express or implied.  See the License for the
        if (nodeRoutingPool != REMOTE_CAPABLE || shardRoutingPool != REMOTE_CAPABLE) {
        }
        final DiskUsage usageAfterShardAssigned = new DiskUsage(
 * <code>cluster.routing.allocation.disk.watermark.low</code> is the low disk
 * Both watermark settings are expressed in terms of used disk percentage, or
            return decision;
 * watermark. If a node has total remote shard size higher than this, shards are not allowed to
                freeSpaceHighThresholdInByteSize,
        final long freeSpaceLowThreshold = diskThresholdEvaluator.getFreeSpaceLowThreshold(usage.getTotalBytes());
        }
    private Decision earlyTerminate(RoutingNode node, RoutingAllocation allocation, final Map<String, DiskUsage> usages) {
        this.diskThresholdSettings = new DiskThresholdSettings(settings, clusterSettings);
        // Allow allocation regardless if only a single data node is available
 * <p>
 * It has three configurable settings, all of which can be changed dynamically:
        this.fileCacheSettings = new FileCacheSettings(settings, clusterSettings);
        ClusterInfo clusterInfo = allocation.clusterInfo();
    private final boolean enableForSingleDataNode;
            }
        return allocation.decision(
import java.util.stream.Collectors;
    }
        );
        DiskUsage usage = usages.get(node.nodeId());
    private final DiskThresholdSettings diskThresholdSettings;
    }
        for (ShardRouting shard : leavingRemoteShardsOnNode) {
 * <p>
        final ByteSizeValue freeSpaceInByteSize = new ByteSizeValue(usage.getFreeBytes());
            allocation.metadata(),
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING;
        final long freeSpaceHighThreshold = diskThresholdEvaluator.getFreeSpaceHighThreshold(usage.getTotalBytes());
                logger.trace("only a single data node is present, allowing allocation");
            "enough available remote addressable space for shard on node, free: [%s], shard size: [%s], free after allocating shard: [%s]",
        final long leavingRemoteShardSize = calculateCurrentNodeLeavingRemoteShardSize(node, allocation);
            usage.getNodeName(),
            }
 * this file be licensed under the Apache-2.0 license or a
        var shardRoutingPool = getShardPool(shardRouting, allocation);
        final Decision decision = earlyTerminate(node, allocation, usages);
    }
        }
import org.opensearch.Version;
        final AggregateFileCacheStats fileCacheStats = clusterInfo.getNodeFileCacheStats().getOrDefault(node.nodeId(), null);
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.ENABLE_FOR_SINGLE_DATA_NODE;
        }
 *
            allocation.clusterInfo(),
                freeSpaceInByteSize,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            return decision;
        final DiskUsage usage = usages.get(node.nodeId());
                NAME,
        // Always allow allocation if the decider is disabled
            usage.getPath(),
package org.opensearch.cluster.routing.allocation.decider;
            return allocation.decision(Decision.YES, NAME, "the cluster info is unavailable");
        );
 *
                node.nodeId()
 * GitHub history for details.
                logger.trace("cluster info unavailable for file cache threshold decider, allowing allocation.");
                allocation.metadata(),
                CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(),
            );
                logger.trace("unable to get file cache stats for node [{}], allowing allocation", node.nodeId());
        // Fail open if there are no file cache stats available
        if (nodeRoutingPool != REMOTE_CAPABLE || shardRoutingPool != REMOTE_CAPABLE) {
        }
            Decision.YES,
import org.opensearch.cluster.routing.RoutingNode;
    private final DiskThresholdEvaluator diskThresholdEvaluator;
            shardSizeInByteSize,
import org.opensearch.common.settings.Settings;
import static org.opensearch.cluster.routing.RoutingPool.getShardPool;
import org.opensearch.common.settings.ClusterSettings;
 * remain on the node. In addition, if allocating a shard to a node causes the
        if (decision != null) {
import org.opensearch.index.store.remote.filecache.FileCacheSettings;
                freeSpaceLowThresholdInByteSize,
                freeSpaceHighThresholdInByteSize,
        }
 * the Apache License, Version 2.0 (the "License"); you may
            leavingRemoteShardSize += DiskThresholdDecider.getExpectedShardSize(
import org.opensearch.core.common.unit.ByteSizeValue;
                allocation.clusterInfo(),
        }
            logger.warn(
