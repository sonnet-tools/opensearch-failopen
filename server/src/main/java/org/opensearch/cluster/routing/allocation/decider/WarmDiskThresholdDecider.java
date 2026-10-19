            return allocation.decision(Decision.YES, NAME, "File Cache Stat is unavailable");
 * not use this file except in compliance with the License.
        // Fail open if there are no disk usages available
import static org.opensearch.cluster.routing.RoutingPool.getShardPool;
            if (logger.isTraceEnabled()) {
                Decision.NO,
        var leavingRemoteShardSize = 0L;  
        // Allow allocation regardless if only a single data node is available  
        return allocation.decision(  
        return null;
            logger.warn(  
 * data ratio and total file cache size).  
 * Both watermark settings are expressed in terms of used disk percentage, or
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.unit.ByteSizeValue;  
 * <code>cluster.routing.allocation.disk.watermark.high</code> is the high disk
                CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(),
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING;
    private long calculateCurrentNodeLeavingRemoteShardSize(RoutingNode node, RoutingAllocation allocation) {
                logger.trace("unable to get file cache stats for node [{}], allowing allocation", node.nodeId());  
            return allocation.decision(Decision.YES, NAME, "the warm disk threshold decider is disabled");  
            return Decision.ALWAYS;
 *  
 * software distributed under the License is distributed on an
        }  
            usage.getPath(),  
            "enough available remote addressable space for shard on node, free: [%s], shard size: [%s], free after allocating shard: [%s]",  
            return allocation.decision(  
        final long shardSize = DiskThresholdDecider.getExpectedShardSize(  
            freeSpaceInByteSize,
    @Override
            if (logger.isTraceEnabled()) {
        );
 * enable or disable this decider. It defaults to true (enabled).  
 * <p>
import org.opensearch.cluster.routing.ShardRoutingState;
            return decision;
import org.opensearch.cluster.DiskUsage;
                freeSpaceLowThresholdInByteSize,  
        }
            return decision;
        final ByteSizeValue freeSpaceAfterAllocationInByteSize = new ByteSizeValue(usageAfterShardAssigned.getFreeBytes());
 * being allocated to has enough remote addressable space (calculated using remote
        }
        );
 * Modifications Copyright OpenSearch Contributors. See
        if (diskThresholdSettings.isWarmThresholdEnabled() == false) {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * node to pass this watermark, it will not be allowed. It defaults to
    public WarmDiskThresholdDecider(Settings settings, ClusterSettings clusterSettings) {  
        }
 * ownership. Elasticsearch licenses this file to you under  
                node.nodeId()
            usage.getNodeId(),
 */
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
        );
        final ClusterInfo clusterInfo = allocation.clusterInfo();  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        }
            allocation.routingTable()  
            }
            allocation.metadata(),
            );
        Map<String, DiskUsage> usages = clusterInfo.getNodeMostAvailableDiskUsages();
 * under the License.  
                "allocating the shard to this node will bring the node above the low watermark cluster setting [%s] "  
    }
 * license agreements. See the NOTICE file distributed with
            allocation.snapshotShardSizeInfo(),
 * watermark. New shards will not be allocated to a node with remote shard size higher than this
import static org.opensearch.cluster.routing.RoutingPool.getNodePool;  
import org.opensearch.cluster.routing.allocation.DiskThresholdEvaluator;  
 * this work for additional information regarding copyright
        final ByteSizeValue freeSpaceInByteSize = new ByteSizeValue(usage.getFreeBytes());
                freeSpaceHighThresholdInByteSize,  
import org.opensearch.common.settings.ClusterSettings;
                shardRouting,  
    public static final String NAME = "warm_disk_threshold";
            Math.max(0, usage.getFreeBytes() - shardSize)
import org.opensearch.cluster.ClusterInfo;
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {  
import org.opensearch.cluster.routing.allocation.WarmNodeDiskThresholdEvaluator;  
 * this file be licensed under the Apache-2.0 license or a
                logger.trace("cluster info unavailable for file cache threshold decider, allowing allocation.");  
 * It defaults to 0.85 (85.0%).  
    private final boolean enableForSingleDataNode;  
        if (decision != null) {
 */  
            usage.getTotalBytes(),
        this.fileCacheSettings = new FileCacheSettings(settings, clusterSettings);
 * <code>cluster.routing.allocation.disk.watermark.low</code> is the low disk
                freeSpaceInByteSize,  
                CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(),
 * compatible open source license.
 */  
        assert Version.CURRENT.major < 9 : "remove enable_for_single_data_node in 9";  
 * <p>  
                shardSizeInByteSize
            if (logger.isTraceEnabled()) {
import org.opensearch.Version;  
            allocation.clusterInfo(),  
        final ByteSizeValue shardSizeInByteSize = new ByteSizeValue(shardSize);  
            );  
            NAME,
                Decision.NO,
    }  
 * The {@link WarmDiskThresholdDecider} checks that the node a shard is potentially
 * Unless required by applicable law or agreed to in writing,
                freeSpaceInByteSize
            usage.getNodeId(),
        final DiskUsage usageAfterSubtractingLeavingShard = new DiskUsage(
        if (shardRouting.currentNodeId().equals(node.nodeId()) == false) {  
        return leavingRemoteShardSize;  
 *
            shardRouting,
            }
        var shardRoutingPool = getShardPool(shardRouting, allocation);
        ClusterInfo clusterInfo = allocation.clusterInfo();
                allocation.routingTable()
package org.opensearch.cluster.routing.allocation.decider;
        if (clusterInfo == null) {
        // Fail open if there are no file cache stats available
                freeSpaceInByteSize,
            );
                allocation.clusterInfo(),
        if (diskThresholdEvaluator.isNodeExceedingHighWatermark(usageAfterSubtractingLeavingShard)) {
 * It has three configurable settings, all of which can be changed dynamically:
    @Override
        if (enableForSingleDataNode == false && allocation.nodes().getDataNodes().size() <= 1) {
                node.nodeId(),
                    + "{} free (currently {} free, estimated shard size is {}), preventing allocation",
        Map<String, DiskUsage> usages = clusterInfo.getNodeMostAvailableDiskUsages();
        DiskUsage usage = usages.get(node.nodeId());
        if (decision != null) {
            leavingRemoteShardSize += DiskThresholdDecider.getExpectedShardSize(
                shard,  
        );  
            .filter(shard -> shard.primary() && REMOTE_CAPABLE.equals(getShardPool(shard, allocation)))  
 * exact byte values for free space (like "500mb")  
        if (nodeRoutingPool != REMOTE_CAPABLE || shardRoutingPool != REMOTE_CAPABLE) {  
        }
 *
            return allocation.decision(Decision.YES, NAME, "disk usages are unavailable");
import java.util.stream.Collectors;  
 * <code>cluster.routing.allocation.disk.warm_threshold_enabled</code> is used to
                logger.trace("unable to determine disk usages for disk-aware allocation, allowing allocation");
        var shardRoutingPool = getShardPool(shardRouting, allocation);
            }
        this.diskThresholdSettings = new DiskThresholdSettings(settings, clusterSettings);
        final long freeSpaceHighThreshold = diskThresholdEvaluator.getFreeSpaceHighThreshold(usage.getTotalBytes());  
            Decision.YES,  
                freeSpaceLowThresholdInByteSize,
}
                    + "and there is less than the required [%s] free remote addressable space on node, actual free: [%s]",
                allocation.metadata(),
    private final DiskThresholdSettings diskThresholdSettings;
            "there is enough remote addressable space on this node for the shard to remain, free: [%s]",
        final Decision decision = earlyTerminate(node, allocation, usages);  
                NAME,
import org.opensearch.common.settings.Settings;
                shardSizeInByteSize
import static org.opensearch.cluster.routing.RoutingPool.REMOTE_CAPABLE;
            shardSizeInByteSize,
            throw new IllegalArgumentException("Shard [" + shardRouting + "] is not allocated on node: [" + node.nodeId() + "]");
            logger.warn(  
 * The OpenSearch Contributors require contributions made to  
 * <p>
 */  
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.ENABLE_FOR_SINGLE_DATA_NODE;
        final AggregateFileCacheStats fileCacheStats = clusterInfo.getNodeFileCacheStats().getOrDefault(node.nodeId(), null);  
            Decision.YES,
                allocation.snapshotShardSizeInfo(),  
            .stream()
        final long leavingRemoteShardSize = calculateCurrentNodeLeavingRemoteShardSize(node, allocation);
 * <p>
 * You may obtain a copy of the License at  
        final ByteSizeValue freeSpaceHighThresholdInByteSize = new ByteSizeValue(freeSpaceHighThreshold);
            freeSpaceInByteSize  
        ClusterInfo clusterInfo = allocation.clusterInfo();
        this.diskThresholdEvaluator = new WarmNodeDiskThresholdEvaluator(diskThresholdSettings, fileCacheSettings::getRemoteDataRatio);
/*  
/**  
            usage.getTotalBytes(),
                NAME,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
                freeSpaceInByteSize,  
            0L,
        final ByteSizeValue freeSpaceLowThresholdInByteSize = new ByteSizeValue(freeSpaceLowThreshold);  
        // Fail open there is no info available
 * remain on the node. In addition, if allocating a shard to a node causes the
        for (ShardRouting shard : leavingRemoteShardsOnNode) {
        }  
/*
import java.util.Map;
 * GitHub history for details.
                0L,
/*  
            freeSpaceAfterAllocationInByteSize  
 * watermark. If a node has total remote shard size higher than this, shards are not allowed to  
                "after allocating [{}] node [{}] would have less than the required threshold of "
            Math.min(usage.getFreeBytes() + leavingRemoteShardSize, usage.getTotalBytes())  
            );  
public class WarmDiskThresholdDecider extends AllocationDecider {
                    + "and cause it to have less than the minimum required [%s] of addressable remote free space (free: [%s], estimated remote shard size: [%s])",
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
        }  
        if (fileCacheStats == null) {
            .collect(Collectors.toList());
        }
        }  
        if (diskThresholdEvaluator.isNodeExceedingLowWatermark(usageAfterShardAssigned)) {
    public Decision canRemain(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
import java.util.List;
        }  
 * 0.90 (90.0%).  
 *
import org.opensearch.index.store.remote.filecache.FileCacheSettings;
import org.opensearch.cluster.routing.ShardRouting;
 * KIND, either express or implied.  See the License for the
            return allocation.decision(  
        final long freeSpaceLowThreshold = diskThresholdEvaluator.getFreeSpaceLowThreshold(usage.getTotalBytes());
        }
    private static final Logger logger = LogManager.getLogger(WarmDiskThresholdDecider.class);  
        final List<ShardRouting> leavingRemoteShardsOnNode = node.shardsWithState(ShardRoutingState.RELOCATING)
        // RoutingNode tracks its relocating shards incrementally (see DiskThresholdDecider.sizeOfRelocatingShards), so this is
 * <p>
            usage.getNodeName(),  
import org.apache.logging.log4j.LogManager;
            return allocation.decision(Decision.YES, NAME, "there is only a single data node present");
            NAME,
        // O(relocating shards on node) rather than a scan of every shard on the node for each canRemain call.  
import org.apache.logging.log4j.Logger;
            if (logger.isTraceEnabled()) {
        if (usages.isEmpty() || usages.containsKey(node.nodeId()) == false) {  
 * specific language governing permissions and limitations
    private final DiskThresholdEvaluator diskThresholdEvaluator;
        final Decision decision = earlyTerminate(node, allocation, usages);  
        var nodeRoutingPool = getNodePool(node);
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING;  
                logger.trace("only a single data node is present, allowing allocation");  
            return Decision.ALWAYS;
                "the shard cannot remain on this node because it is above the high watermark cluster setting [%s] "  
        final ByteSizeValue freeSpaceInByteSize = new ByteSizeValue(usageAfterSubtractingLeavingShard.getFreeBytes());  
        }  
            }  
        var nodeRoutingPool = getNodePool(node);
    }
import org.opensearch.cluster.routing.RoutingNode;  
        );
        final DiskUsage usage = usages.get(node.nodeId());  
    }
        this.enableForSingleDataNode = ENABLE_FOR_SINGLE_DATA_NODE.get(settings);
            );
            return allocation.decision(Decision.YES, NAME, "the cluster info is unavailable");
        final DiskUsage usageAfterShardAssigned = new DiskUsage(  
                "less than the required {} of free remote addressable space threshold left ({} free) on node [{}], shard cannot remain",
        if (nodeRoutingPool != REMOTE_CAPABLE || shardRoutingPool != REMOTE_CAPABLE) {  
                freeSpaceHighThresholdInByteSize,
 * @opensearch.internal
 * the Apache License, Version 2.0 (the "License"); you may
            usage.getPath(),
    private final FileCacheSettings fileCacheSettings;
            usage.getNodeName(),
        return allocation.decision(
    private Decision earlyTerminate(RoutingNode node, RoutingAllocation allocation, final Map<String, DiskUsage> usages) {  
        // Always allow allocation if the decider is disabled
