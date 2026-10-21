            try {
                "fewer free bytes remaining than the size of all incoming shards: "
}
        final double usedDiskThresholdHigh = 100.0 - diskThresholdSettings.getFreeDiskThresholdHigh();
 * You may obtain a copy of the License at
                // in practice the only initializing-but-not-relocating shards with a nonzero expected shard size will be ones created
                );
        }
        }
 * <code>cluster.routing.allocation.disk.watermark.low</code> is the low disk
            NAME,
                // has never been allocated if it's under the high watermark
                    node.nodeId()
 * software distributed under the License is distributed on an
 * watermark. New shards will not allocated to a node with usage higher than this,
    double freeDiskPercentageAfterShardAssigned(DiskUsageWithRelocations usage, Long shardSize) {
 *
    private final boolean enableForSingleDataNode;
        }
            && shardRouting.active() == false
            new ByteSizeValue(freeBytesAfterShard)
                if (actualPath == null) {
        final List<ShardRouting> initializingShards = node.shardsWithState(ShardRoutingState.INITIALIZING);
/*
        double getFreeDiskAsPercentage() {
                        + "[%s%%], actual free: [%s%%]",
            return allocation.decision(Decision.YES, NAME, "the cluster info is unavailable");
        final String dataPath = clusterInfo.getDataPath(shardRouting);
                    "the node is above the low watermark cluster setting [%s=%s], having less than the minimum required [%s] free "
            }
            }
        if (freeDiskPercentage < diskThresholdSettings.getFreeDiskThresholdHigh()) {
            final long sizeOfRelocatingShards = sizeOfRelocatingShards(
 * <code>cluster.routing.allocation.disk.watermark.high</code> is the high disk
                        + "never been allocated before"
            clusterInfo.getAvgTotalBytes(),
            0L,
    }
        );
import org.apache.logging.log4j.Logger;
 * 0.85 (85.0%).
            return Decision.NO;
            return 100.0 - getFreeDiskAsPercentage();
        Metadata metadata,
            usage.getTotalBytes(),
        // and take the size into account
        String getPath() {
                Strings.format1Decimals(diskThresholdSettings.getFreeDiskThresholdHigh(), "%"),
     * percentage of free disk if the shard were to be allocated to the node.
                    sourceIndexMeta,
        double getUsedDiskAsPercentage() {
            return allocation.decision(Decision.YES, NAME, "there is only a single data node present");
import static org.opensearch.cluster.routing.RoutingPool.getShardPool;
import java.util.List;
                );
                    node.nodeId(),
            );
                "the shard cannot remain on this node because the node has fewer free bytes remaining than the total size of all "
                            + "preventing allocation even though primary has never been allocated",
        final IndexMetadata indexMetadata = metadata.getIndexSafe(shard.index());
        if (usages.isEmpty()) {
                if (logger.isDebugEnabled()) {
            return allocation.decision(Decision.YES, NAME, "disk usages are unavailable");
        if (diskThresholdSettings.isEnabled() == false) {
                    actualPath = clusterInfo.getDataPath(routing.cancelRelocation());
        }
import java.util.Set;
                node.nodeId(),
                CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(),
 * ownership. Elasticsearch licenses this file to you under
        // flag that determines whether the low threshold checks below can be skipped. We use this for a primary shard that is freshly
 * @opensearch.internal
                            + "but allowing allocation because primary has never been allocated",
        long defaultValue,
            return Decision.ALWAYS;
        public String toString() {
        final ClusterInfo clusterInfo = allocation.clusterInfo();
            if (getTotalBytes() == 0L) {
        double freeDiskPercentage = usage.getFreeDiskAsPercentage();
import org.opensearch.Version;
        this.diskThresholdSettings = new DiskThresholdSettings(settings, clusterSettings);
                    CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(),
            if (skipLowThresholdChecks == false) {
                        + "never been allocated before"
            if (logger.isDebugEnabled()) {
            return allocation.decision(
            }
                        freeBytesValue,
                        freeBytesValue,
                false,
 * this work for additional information regarding copyright
                usage.getPath(),
            Decision.YES,
                diskThresholdSettings.getHighWatermarkRaw(),
                // above the high watermark, so don't allow allocating the shard
            node,
            usage,
        return diskUsageWithRelocations;
    }
                    CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(),
     */
        // subtractLeavingShards is passed as false here, because they still use disk space, and therefore we should be extra careful
        );
 * being allocated to has enough disk space.
    /**
                // Even though the primary has never been allocated, the node is
                new ByteSizeValue(freeBytes)
                diskThresholdSettings.getFreeDiskThresholdHigh(),
                if (logger.isDebugEnabled()) {
    }
                    "less than the required {} free bytes threshold ({} bytes free) on node {}, shard cannot remain",
            }
import org.opensearch.cluster.metadata.Metadata;
                        node.nodeId()
                        node.nodeId()
        SnapshotShardSizeInfo snapshotShardSizeInfo,
        }
        // Always allow allocation if the decider is disabled
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.ENABLE_FOR_SINGLE_DATA_NODE;
        if (decision != null) {
                shardRouting,
                return allocation.decision(
                        "less than the required {} free bytes threshold ({} free) on node {}, "
                freeBytesValue,
        // Account for reserved space wherever it is available
                diskThresholdSettings.getFreeBytesThresholdHigh(),
                    diskThresholdSettings.getFreeBytesThresholdHigh(),
        long totalSize = reservedSpace.getTotal();
                NAME,
            logger.trace("node [{}] has {}% free disk ({} bytes)", node.nodeId(), freeDiskPercentage, freeBytes);
                    allocation.metadata(),
                node.nodeId(),
            logger.warn(
                Decision.NO,
                    Decision.NO,
 * Both watermark settings are expressed in terms of used disk percentage, or
                        + "space, actual free: [%s]",
                    CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(),
import org.opensearch.core.common.unit.ByteSizeValue;
                    NAME,
import org.opensearch.core.index.Index;
                        targetShardSize += clusterInfo.getShardSize(shardRoutingTable.primaryShard(), 0);
        DiskUsage newUsage = new DiskUsage(
            // If there is no usage, and we have other nodes in the cluster,
import org.apache.logging.log4j.LogManager;
        }
        DiskUsageWithRelocations(DiskUsage diskUsage, long relocatingShardSize) {
    }
     * Given the DiskUsage for a node and the size of the shard, return the
                "allocating the shard to this node will bring the node above the high watermark cluster setting [%s=%s] "
        }
            }
                    usage.getFreeBytes(),
        RoutingTable routingTable
            usage = new DiskUsage(node.nodeId(), node.node().getName(), "_na_", avgTotalBytes, avgFreeBytes);
            Decision.YES,
                        node.nodeId()
                usage.getPath(),
            if (skipLowThresholdChecks == false) {
                    freeBytes,
        if (freeBytes < 0L) {
        @Override
 * It has three configurable settings, all of which can be changed dynamically:
        );
                        Strings.format1Decimals(usedDiskPercentage, "%"),
        boolean skipLowThresholdChecks = shardRouting.primary()
                Decision.NO,
     */
            logger.debug(
                    Decision.NO,
            false
    @Override
        ShardRouting shard,
        if (REMOTE_CAPABLE.equals(getNodePool(node)) && REMOTE_CAPABLE.equals(getShardPool(shardRouting, allocation))) {
        String dataPath,
            allocation.metadata(),
                }
                for (IndexShardRoutingTable shardRoutingTable : routingTable.index(mergeSourceIndex.getName())) {
                node.nodeId(),
/*
                return allocation.decision(
    public static final String NAME = "disk_threshold";
     * the node, but may not be finished transferring yet.
            new ByteSizeValue(freeBytes)
            logger.warn(
            && shard.recoverySource().getType() == RecoverySource.Type.LOCAL_SHARDS) {
        );
        );
            // use the average usage for all nodes as the usage for this node
                    freeDiskPercentage
                );
        final DiskUsageWithRelocations usage = getDiskUsage(
            diskThresholdSettings.includeRelocations()
            clusterInfo.getAvgTotalBytes(),
 * <p>
                // has never been allocated if it's under the high watermark
        // Where reserved space is unavailable (e.g. stats are out-of-sync) compute a conservative estimate for initialising shards
            allocation.clusterInfo(),
                    freeBytesValue
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.index.shard.ShardId;
                    diskThresholdSettings.getHighWatermarkRaw(),
        Metadata metadata,
        // Secondly, check that allocating the shard to this node doesn't put it above the high watermark
                logger.debug(
 */
                freeSpaceAfterShard
            );
        if (freeBytes < 0L) {
        String getNodeName() {
        if (freeBytes < diskThresholdSettings.getFreeBytesThresholdHigh().getBytes()) {
            } catch (ArithmeticException e) {
 * SPDX-License-Identifier: Apache-2.0
    private Decision earlyTerminate(RoutingAllocation allocation, final Map<String, DiskUsage> usages) {
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.cluster.ClusterInfo;
            // If the shard is a replica or is a non-empty primary, check the low threshold
        }
     */
            );
        }
                    logger.debug(
                totalSize += getExpectedShardSize(routing, 0L, clusterInfo, null, metadata, routingTable);
                    node.nodeId()
     * @param shardSize Size in bytes of the shard
                Decision.NO,
 * <p>
            clusterInfo.getAvgFreeByte(),
            return allocation.decision(
package org.opensearch.cluster.routing.allocation.decider;
     * Returns the size of all shards that are currently being relocated to
            }
 */
        }
            return allocation.decision(
        assert shardSize >= 0 : shardSize;
        long freeBytesAfterShard = freeBytes - shardSize;
        } else if (REMOTE_CAPABLE.equals(getShardPool(shardRouting, allocation))) {
                return Math.subtractExact(diskUsage.getFreeBytes(), relocatingShardSize);
                    diskThresholdSettings.getFreeBytesThresholdLow(),
        }
    }
                    );
                        Strings.format1Decimals(usedDiskThresholdLow, "%"),
                    diskThresholdSettings.getLowWatermarkRaw(),
                    }
            return Decision.ALWAYS;
     * If subtractShardsMovingAway is true then the size of shards moving away is subtracted from the total size of all shards
            && shard.active() == false
            logger.trace("getDiskUsage(subtractLeavingShards={}) returning {}", subtractLeavingShards, diskUsageWithRelocations);
            allocation.routingTable()
            freeBytesValue,
                CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(),
                // above the high watermark, so don't allow allocating the shard
            if (shard.unassigned() && shard.recoverySource().getType() == RecoverySource.Type.SNAPSHOT) {
                logger.trace("only a single data node is present, allowing allocation");
            return clusterInfo.getShardSize(shard, defaultValue);
            // the worst case
import org.opensearch.cluster.routing.RoutingTable;
            return Decision.NO;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        long freeBytes = usage.getFreeBytes();
            node,
        }
    ) {
                logger.debug(
import org.opensearch.cluster.routing.RecoverySource;
            return 100.0 * ((double) getFreeBytes() / getTotalBytes());
                    logger.debug(
    public static long sizeOfRelocatingShards(
        }
        } else {
                        freeBytesValue,
        // NB this counts all shards on the node when the ClusterInfoService retrieved the node stats, which may include shards that are
                            + "but allowing allocation because primary has never been allocated",
            "enough disk for shard on node, free: [%s], shard size: [%s], free after allocating shard: [%s]",
                    usedDiskThresholdHigh,
                    node,
        return newUsage.getFreeDiskAsPercentage();
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING;
        if (logger.isTraceEnabled()) {
        final long avgFreeBytes,
 * exact byte values for free space (like "500mb")
        // no longer initializing because their recovery failed or was cancelled.
                return allocation.decision(
                shardRouting,
        }
    private static final Logger logger = LogManager.getLogger(DiskThresholdDecider.class);
                return snapshotShardSizeInfo.getShardSize(shard, defaultValue);
        }
 * <p>
        final Decision decision = earlyTerminate(allocation, usages);
        if (usage == null) {
                );
                diskThresholdSettings.getHighWatermarkRaw(),
            );
        boolean subtractShardsMovingAway,
 * this file be licensed under the Apache-2.0 license or a
                        "less than the required {} free bytes threshold ({} bytes free) on node {}, "
                freeDiskPercentage
        boolean subtractLeavingShards
 * not use this file except in compliance with the License.
        // If this node is already above the high threshold, the shard cannot remain (get it off!)
                NAME,
                if (logger.isDebugEnabled()) {
                );
            return diskUsage.getPath();
            usage.getNodeName(),
                "the shard cannot remain on this node because it is above the high watermark cluster setting [%s=%s] "
                continue;
                }
import static org.opensearch.cluster.routing.RoutingPool.getNodePool;
        RoutingNode node,
            usages,
                    + "free space [%sB], relocating shards [%sB]",
                true,
        }
/**
            final Index mergeSourceIndex = indexMetadata.getResizeSourceIndex();
        final DiskUsageWithRelocations usage = getDiskUsage(
    static class DiskUsageWithRelocations {
            }
                }
import static org.opensearch.cluster.routing.RoutingPool.REMOTE_CAPABLE;
                    Decision.NO,
        // For this case WarmDiskThresholdDecider Decider will take decision
 * <p>
            this.diskUsage = diskUsage;
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
            }
                : 0
                    Decision.YES,
                new ByteSizeValue(shardSize)
            allocation.snapshotShardSizeInfo(),
            }
        // Fail open if there are no disk usages available
        ClusterInfo clusterInfo,
 * <code>cluster.routing.allocation.disk.threshold_enabled</code> is used to
        if (freeBytes < diskThresholdSettings.getFreeBytesThresholdLow().getBytes()) {
    }
        final Map<String, DiskUsage> usages,
                node,
        return allocation.decision(
                    );
                "the shard cannot remain on this node because it is above the high watermark cluster setting [%s=%s] "
    public DiskThresholdDecider(Settings settings, ClusterSettings clusterSettings) {
        RoutingAllocation allocation,
     * Returns the expected shard size for the given shard or the default value provided if not enough information are available
            if (logger.isDebugEnabled()) {
                if (logger.isDebugEnabled()) {
                Decision.NO,
                freeBytes + sizeOfRelocatingShards,
        return null;
                        Strings.format1Decimals(usedDiskPercentage, "%"),
    ) {
            if (sourceIndexMeta != null) {
                    allocation.clusterInfo(),
        // since shards are moving away. No new shards will be incoming since in canAllocate we pass false for this check.
        final ClusterInfo clusterInfo = allocation.clusterInfo();
                        + "space, actual free: [%s]",
            }
        }
            final long sizeOfRelocatingShards = sizeOfRelocatingShards(
                        "more than the allowed {} used disk threshold ({} used) on node [{}], "
            return diskUsage.getNodeId();
        ByteSizeValue freeBytesValue = new ByteSizeValue(freeBytes);
        double usedDiskPercentage = usage.getUsedDiskAsPercentage();
        final Map<String, DiskUsage> usages = clusterInfo.getNodeLeastAvailableDiskUsages();
        }
                allocation.clusterInfo(),
                "after allocating [{}] node [{}] would have less than the required threshold of "
            );
        }
            if (logger.isDebugEnabled()) {
        double freeSpaceAfterShard = freeDiskPercentageAfterShardAssigned(usage, shardSize);
                if (logger.isDebugEnabled()) {
                if (dataPath.equals(actualPath)) {
                Decision.NO,
        private final long relocatingShardSize;
                "the node has fewer free bytes remaining than the total size of all incoming shards: "
            );
 *
            shardRouting,
                usedDiskThresholdHigh,
                    "less than the required {}% free disk threshold ({}% free) on node {}, shard cannot remain",
        final double usedDiskThresholdLow = 100.0 - diskThresholdSettings.getFreeDiskThresholdLow();
                "allocating the shard to this node will bring the node above the high watermark cluster setting [%s=%s] "
            for (ShardRouting routing : node.shardsWithState(ShardRoutingState.RELOCATING)) {
        if (indexMetadata.getResizeSourceIndex() != null
                logger.trace("cluster info unavailable for disk threshold decider, allowing allocation.");
 *
                    diskThresholdSettings.getFreeDiskThresholdHigh(),
        // checks for percentage comparisons
                    + "and there is less than the required [%s%%] free disk on node, actual free: [%s%%]",
                node.nodeId(),
            return targetShardSize == 0 ? defaultValue : targetShardSize;
                NAME,
        return allocation.decision(
        }
                    NAME,
                    + "usage {} on node {} including {} bytes of relocations, preventing allocation",
            return diskUsage.getNodeName();
            new ByteSizeValue(shardSize),
 * Licensed to Elasticsearch under one or more contributor
 * compatible open source license.
                        "less than the required {} free bytes threshold ({} free) on node {}, "
                }
                    shard.id(),
                    + "and there is less than the required [%s] free space on node, actual free: [%s]",
            if (actualPath == null || actualPath.equals(dataPath)) {
                logger.trace("unable to determine disk usages for disk-aware allocation, allowing allocation");
            }
        assert freeBytesAfterShard >= 0 : freeBytesAfterShard;
            }
            } else if (freeDiskPercentage > diskThresholdSettings.getFreeDiskThresholdHigh()) {
     * to estimate the shards size.
import java.util.Map;
 * although this watermark may be passed by allocating a shard. It defaults to
    ) {
                NAME,
            usage.getPath(),
    public Decision canRemain(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
            final IndexMetadata sourceIndexMeta = metadata.index(mergeSourceIndex);
            usages,
import org.opensearch.common.settings.ClusterSettings;
 * <p>
                node,
        }
                }
                return 100.0;
                    indexMetadata.getNumberOfShards()
        private final DiskUsage diskUsage;
        );
                diskThresholdSettings.getHighWatermarkRaw(),
            allocation,
            );
        }
            usage.getNodeId(),
                }
                        node.nodeId()
                    );
            && shardRouting.recoverySource().getType() == RecoverySource.Type.EMPTY_STORE;
            } else {
                }
import org.opensearch.cluster.metadata.IndexMetadata;
            return decision;
                logger.debug(
                if (logger.isDebugEnabled()) {
 * under the License.
        }
        final ClusterInfo.ReservedSpace reservedSpace = clusterInfo.getReservedSpace(node.nodeId(), dataPath);
                        Strings.format1Decimals(freeDiskPercentage, "%"),
            }
 * Modifications Copyright OpenSearch Contributors. See
        if (clusterInfo == null) {
                allocation.clusterInfo(),
        // Allow allocation regardless if only a single data node is available
                diskThresholdSettings.getFreeBytesThresholdHigh(),
            long targetShardSize = 0;
                    diskThresholdSettings.getLowWatermarkRaw(),
                    );
            // free space
/*
                        diskThresholdSettings.getFreeBytesThresholdLow(),
                );
 * GitHub history for details.
                    + "incoming shards: free space [%s], relocating shards [%s]",
import org.opensearch.cluster.DiskUsage;
        if (decision != null) {
 * enable or disable this decider. It defaults to true (enabled).
            return allocation.decision(
        // allocated and empty.
        RoutingTable routingTable
                allocation.metadata(),
                NAME,
import org.opensearch.core.common.Strings;
        return totalSize;
                    + "and cause it to have less than the minimum required [%s] of free space (free: [%s], estimated shard size: [%s])",
                return allocation.decision(
                new ByteSizeValue(shardSize)
            );
                final Set<ShardId> shardIds = IndexMetadata.selectRecoverFromShards(
        long getFreeBytes() {
        }
            }
                    Decision.NO,
            return diskUsage.getTotalBytes();
                    logger.debug(
        if (freeDiskPercentage < diskThresholdSettings.getFreeDiskThresholdLow()) {
        // checks for exact byte comparisons
        }
        if (freeBytesAfterShard < diskThresholdSettings.getFreeBytesThresholdHigh().getBytes()) {
                        Strings.format1Decimals(diskThresholdSettings.getFreeDiskThresholdHigh(), "%"),
    /**
                    NAME,
        if (shardRouting.currentNodeId().equals(node.nodeId()) == false) {
        RoutingNode node,
        if (logger.isTraceEnabled()) {
                "after allocating [{}] node [{}] would have more than the allowed "
public class DiskThresholdDecider extends AllocationDecider {
                    logger.debug(
        shardSize = (shardSize == null) ? 0 : shardSize;
                    freeBytesValue
                sizeOfRelocatingShards
            } else if (freeBytes > diskThresholdSettings.getFreeBytesThresholdHigh().getBytes()) {
                return allocation.decision(
                    "the node is above the low watermark, but less than the high watermark, and this primary shard has "
    }
            clusterInfo.getAvgFreeByte(),
                return Long.MAX_VALUE;
                String actualPath = clusterInfo.getDataPath(routing);
                    "the node is above the low watermark cluster setting [%s=%s], using more disk space than the maximum allowed "
                    Decision.YES,
            "there is enough disk on this node for the shard to remain, free: [%s]",
        // subtractLeavingShards is passed as true here, since this is only for shards remaining, we will *eventually* have enough disk
                // any additional space and can be ignored here
        ClusterInfo clusterInfo,
        }
                CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(),
                // Allow the shard to be allocated because it is primary that
    }
 * node to pass this watermark, it will not be allowed. It defaults to
                    "the node is above the high watermark cluster setting [%s=%s], having less than the minimum required [%s] free "
            if (logger.isTraceEnabled()) {
        this.enableForSingleDataNode = ENABLE_FOR_SINGLE_DATA_NODE.get(settings);
 * specific language governing permissions and limitations
            logger.debug(
 * remain on the node. In addition, if allocating a shard to a node causes the
 * watermark. If a node has usage higher than this, shards are not allowed to
                        "more than the allowed {} used disk threshold ({} used) on node [{}], preventing allocation",
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING;
            final String actualPath = clusterInfo.getDataPath(routing);
                sizeOfRelocatingShards
                    freeDiskPercentage,
                    diskThresholdSettings.getHighWatermarkRaw(),
            );
                    subtractLeavingShards,
            // if we don't yet know the actual path of the incoming shard then conservatively assume it's going to the path with the least
            return "DiskUsageWithRelocations{" + "diskUsage=" + diskUsage + ", relocatingShardSize=" + relocatingShardSize + '}';
                    + "{} free disk threshold ({} free), preventing allocation",
            this.relocatingShardSize = relocatingShardSize;
                    logger.debug(
                return allocation.decision(
 * the Apache License, Version 2.0 (the "License"); you may
                    "the node is above the low watermark, but less than the high watermark, and this primary shard has "
                    freeDiskPercentage
        long getTotalBytes() {
            if (logger.isTraceEnabled()) {
            return allocation.decision(
 * KIND, either express or implied.  See the License for the
                usage,
        final long shardSize = getExpectedShardSize(
                NAME,
                usage,
        }
                    NAME,
        String getNodeId() {
    private DiskUsageWithRelocations getDiskUsage(
        final DiskUsageWithRelocations diskUsageWithRelocations = new DiskUsageWithRelocations(
                    usedDiskThresholdLow,
    private final DiskThresholdSettings diskThresholdSettings;
                    + "{} free (currently {} free, estimated shard size is {}), preventing allocation",
        final double freeDiskPercentage = usage.getFreeDiskAsPercentage();
            usage.getFreeBytes() - shardSize
        Map<String, DiskUsage> usages = clusterInfo.getNodeMostAvailableDiskUsages();
        if (enableForSingleDataNode == false && allocation.nodes().getDataNodes().size() <= 1) {
        assert Version.CURRENT.major < 9 : "remove enable_for_single_data_node in 9";
                    allocation.routingTable()
                    CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(),
                freeBytes + sizeOfRelocatingShards,
        }
                sizeOfRelocatingShards
        final Decision decision = earlyTerminate(allocation, usages);
                    if (shardIds.contains(shardRoutingTable.shardId())) {
            } else {
                    logger.debug(
                    totalSize -= getExpectedShardSize(routing, 0L, clusterInfo, null, metadata, routingTable);
    }
                freeBytesValue,
                        node.nodeId()
        if (freeSpaceAfterShard < diskThresholdSettings.getFreeDiskThresholdHigh()) {
            return allocation.decision(Decision.YES, NAME, "this shard is not allocated on the most utilized disk and can remain");
                    // we might know the path of this shard from before when it was relocating
 * The OpenSearch Contributors require contributions made to
        // First, check that the node currently over the low watermark
 *
        }
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                "fewer free bytes remaining than the size of all incoming shards: "
        // Cache the used disk percentage for displaying disk percentages consistent with documentation
        final long avgTotalBytes,
                diskThresholdSettings.getFreeBytesThresholdHigh(),
                // by a resize (shrink/split/clone) operation which we expect to happen using hard links, so they shouldn't be taking
            if (routing.relocatingNodeId() == null || reservedSpace.containsShardId(routing.shardId())) {
                    NAME,
            allocation,
                    );
                        Strings.format1Decimals(usedDiskThresholdLow, "%"),
            return allocation.decision(Decision.YES, NAME, "the disk threshold decider is disabled");
                );
                ? sizeOfRelocatingShards(
                        + "[%s%%], actual free: [%s%%]",
                CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(),
            if (logger.isTraceEnabled()) {
                // Even though the primary has never been allocated, the node is
                allocation.routingTable()
        }
                    NAME,
            true
                    usage.getFreeDiskAsPercentage()
        if (REMOTE_CAPABLE.equals(getNodePool(node)) && REMOTE_CAPABLE.equals(getShardPool(shardRouting, allocation))) {
                allocation.routingTable()
 */
                    );
        if (subtractShardsMovingAway) {
 */
import org.opensearch.snapshots.SnapshotShardSizeInfo;
        }
        // Fail open there is no info available
                // Allow the shard to be allocated because it is primary that
            throw new IllegalArgumentException("Shard [" + shardRouting + "] is not allocated on node: [" + node.nodeId() + "]");
                );
            );
        // For this case WarmDiskThresholdDecider Decider will take decision
    /**
        }
                        node.nodeId()
     * <p>
    @Override
                Strings.format1Decimals(freeSpaceAfterShard, "%")
                            + "preventing allocation even though primary has never been allocated",
            NAME,
            logger.trace("node [{}] has {}% used disk", node.nodeId(), usedDiskPercentage);
        } else if (REMOTE_CAPABLE.equals(getShardPool(shardRouting, allocation))) {
                );
                )
        );
            );
            return allocation.decision(
     * @param usage A DiskUsage for the node to have space computed for
                        "less than the required {} free bytes threshold ({} free) on node {}, preventing allocation",
                }
        for (ShardRouting routing : initializingShards) {
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
                );
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
                    "unable to determine disk usage for {}, defaulting to average across nodes [{} total] [{} free] [{}% free]",
     * @return Percentage of free space after the shard is assigned to the node
        if (logger.isTraceEnabled()) {
                sizeOfRelocatingShards
 * The {@link DiskThresholdDecider} checks that the node a shard is potentially
                Decision.NO,
                        diskThresholdSettings.getFreeBytesThresholdLow(),
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
        final long freeBytes = usage.getFreeBytes();
            return decision;
        if (dataPath == null || usage.getPath().equals(dataPath) == false) {
                    + "and cause it to use more disk space than the maximum allowed [%s%%] (free space after shard added: [%s%%])",
import org.opensearch.cluster.routing.ShardRoutingState;
            // in the shrink index case we sum up the source index shards since we basically make a copy of the shard in
                    usage.getPath(),
import org.opensearch.cluster.routing.RoutingNode;
 * 0.90 (90.0%).
                allocation.metadata(),
                        diskThresholdSettings.getFreeBytesThresholdHigh(),
            );
    public static long getExpectedShardSize(
                    + "usage {} on node {} including {} bytes of relocations, shard cannot remain",
        }
                diskThresholdSettings.getHighWatermarkRaw(),
        DiskUsage usage = usages.get(node.nodeId());
 * license agreements. See the NOTICE file distributed with
            }
                }
                    diskThresholdSettings.getFreeBytesThresholdHigh(),
                    "the node is above the high watermark cluster setting [%s=%s], using more disk space than the maximum allowed "
                    usage.getTotalBytes(),
        ClusterInfo clusterInfo = allocation.clusterInfo();
