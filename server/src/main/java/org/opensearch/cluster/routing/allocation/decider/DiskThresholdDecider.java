                    Decision.YES,
     * @param usage A DiskUsage for the node to have space computed for  
                    Decision.NO,
import org.opensearch.core.common.unit.ByteSizeValue;
            // in the shrink index case we sum up the source index shards since we basically make a copy of the shard in
            }
        // subtractLeavingShards is passed as true here, since this is only for shards remaining, we will *eventually* have enough disk  
            && shard.active() == false  
            return Decision.NO;
            return allocation.decision(  
                    + "incoming shards: free space [%s], relocating shards [%s]",
        boolean subtractShardsMovingAway,
                    diskThresholdSettings.getLowWatermarkRaw(),  
     * @return Percentage of free space after the shard is assigned to the node
        }
        }  
     * If subtractShardsMovingAway is true then the size of shards moving away is subtracted from the total size of all shards
 * Licensed to Elasticsearch under one or more contributor  
                shardRouting,
                    Decision.NO,
 * software distributed under the License is distributed on an
        boolean subtractLeavingShards
     * Returns the size of all shards that are currently being relocated to
                String actualPath = clusterInfo.getDataPath(routing);
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.ENABLE_FOR_SINGLE_DATA_NODE;  
        if (freeBytes < diskThresholdSettings.getFreeBytesThresholdHigh().getBytes()) {  
        RoutingTable routingTable  
                );
        final ClusterInfo clusterInfo = allocation.clusterInfo();
 * @opensearch.internal
                // above the high watermark, so don't allow allocating the shard  
                NAME,
                sizeOfRelocatingShards
        final ClusterInfo clusterInfo = allocation.clusterInfo();
            new ByteSizeValue(freeBytesAfterShard)  
 * node to pass this watermark, it will not be allowed. It defaults to
                    logger.debug(
        shardSize = (shardSize == null) ? 0 : shardSize;
                allocation.routingTable()  
                );
        }
            );  
        // Where reserved space is unavailable (e.g. stats are out-of-sync) compute a conservative estimate for initialising shards
                    freeBytesValue
    private DiskUsageWithRelocations getDiskUsage(
        final List<ShardRouting> initializingShards = node.shardsWithState(ShardRoutingState.INITIALIZING);  
            usage.getPath(),  
            if (shard.unassigned() && shard.recoverySource().getType() == RecoverySource.Type.SNAPSHOT) {  
            return Decision.ALWAYS;  
     */  
            }
 * remain on the node. In addition, if allocating a shard to a node causes the  
                        Strings.format1Decimals(diskThresholdSettings.getFreeDiskThresholdHigh(), "%"),
                    indexMetadata.getNumberOfShards()
    }
 * It has three configurable settings, all of which can be changed dynamically:  
            }
                    );
        final Map<String, DiskUsage> usages = clusterInfo.getNodeLeastAvailableDiskUsages();  
public class DiskThresholdDecider extends AllocationDecider {  
            true
                "fewer free bytes remaining than the size of all incoming shards: "  
                if (logger.isDebugEnabled()) {  
                diskThresholdSettings.getFreeBytesThresholdHigh(),
                    allocation.routingTable()
                    allocation.clusterInfo(),
        long defaultValue,
        for (ShardRouting routing : initializingShards) {
        final double freeDiskPercentage = usage.getFreeDiskAsPercentage();  
 *  
        assert shardSize >= 0 : shardSize;
            return allocation.decision(
                        freeBytesValue,  
                sizeOfRelocatingShards
                    NAME,
                    logger.debug(
            return 100.0 - getFreeDiskAsPercentage();  
 *
    }
            0L,
                freeSpaceAfterShard
                logger.debug(
                        + "never been allocated before"
                    usage.getTotalBytes(),  
                true,
        final DiskUsageWithRelocations diskUsageWithRelocations = new DiskUsageWithRelocations(
import org.opensearch.cluster.metadata.Metadata;
     */
        this.enableForSingleDataNode = ENABLE_FOR_SINGLE_DATA_NODE.get(settings);  
                );  
                // has never been allocated if it's under the high watermark  
        assert freeBytesAfterShard >= 0 : freeBytesAfterShard;
                usedDiskThresholdHigh,  
                logger.debug(
            if (skipLowThresholdChecks == false) {  
 * watermark. If a node has usage higher than this, shards are not allowed to
        if (diskThresholdSettings.isEnabled() == false) {  
        }
            usage = new DiskUsage(node.nodeId(), node.node().getName(), "_na_", avgTotalBytes, avgFreeBytes);
            }
                sizeOfRelocatingShards  
                );  
import org.opensearch.cluster.metadata.IndexMetadata;  
                    diskThresholdSettings.getFreeBytesThresholdHigh(),
        // Account for reserved space wherever it is available
        final long shardSize = getExpectedShardSize(
        );
                allocation.routingTable()  
                allocation.metadata(),
 */  
                return Long.MAX_VALUE;
                diskThresholdSettings.getFreeDiskThresholdHigh(),  
            if (logger.isTraceEnabled()) {  
     * percentage of free disk if the shard were to be allocated to the node.
            return allocation.decision(
import static org.opensearch.cluster.routing.RoutingPool.REMOTE_CAPABLE;
import org.opensearch.cluster.routing.IndexShardRoutingTable;
import org.opensearch.cluster.routing.RecoverySource;  
                Decision.NO,
                : 0  
        }
        }  
    ) {  
                    + "and cause it to have less than the minimum required [%s] of free space (free: [%s], estimated shard size: [%s])",  
        // checks for percentage comparisons
                freeBytesValue,
        ByteSizeValue freeBytesValue = new ByteSizeValue(freeBytes);
                diskThresholdSettings.getHighWatermarkRaw(),
                    + "usage {} on node {} including {} bytes of relocations, shard cannot remain",
            }
import org.opensearch.cluster.routing.ShardRoutingState;
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
                CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(),
                Strings.format1Decimals(diskThresholdSettings.getFreeDiskThresholdHigh(), "%"),
            return allocation.decision(Decision.YES, NAME, "there is only a single data node present");  
 * not use this file except in compliance with the License.
                if (logger.isDebugEnabled()) {
                // Even though the primary has never been allocated, the node is
            return diskUsage.getPath();  
    }
            }
                NAME,  
                    diskThresholdSettings.getFreeBytesThresholdHigh(),
                "after allocating [{}] node [{}] would have more than the allowed "
                    "the node is above the high watermark cluster setting [%s=%s], having less than the minimum required [%s] free "
                    );  
        return totalSize;  
                node.nodeId(),  
            allocation,  
                    node.nodeId(),
        if (subtractShardsMovingAway) {
                // Allow the shard to be allocated because it is primary that
                return Math.subtractExact(diskUsage.getFreeBytes(), relocatingShardSize);
            long targetShardSize = 0;
            return Decision.NO;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
                // Allow the shard to be allocated because it is primary that
            }
                    shard.id(),  
            node,  
            // free space
                diskThresholdSettings.getHighWatermarkRaw(),
                NAME,
 * being allocated to has enough disk space.
        String getPath() {
        final Decision decision = earlyTerminate(allocation, usages);  
        // Fail open if there are no disk usages available  
 * ownership. Elasticsearch licenses this file to you under  
     * @param shardSize Size in bytes of the shard
        }  
    ) {
            }  
        // Allow allocation regardless if only a single data node is available
                node,
    }
                Decision.NO,  
                    + "and there is less than the required [%s%%] free disk on node, actual free: [%s%%]",  
 * license agreements. See the NOTICE file distributed with
                new ByteSizeValue(shardSize)
        }  
 * although this watermark may be passed by allocating a shard. It defaults to
                return 100.0;  
/*  
            }
                    "the node is above the low watermark, but less than the high watermark, and this primary shard has "
        // no longer initializing because their recovery failed or was cancelled.  
            return clusterInfo.getShardSize(shard, defaultValue);  
            && shardRouting.recoverySource().getType() == RecoverySource.Type.EMPTY_STORE;
                );  
            "there is enough disk on this node for the shard to remain, free: [%s]",
            if (actualPath == null || actualPath.equals(dataPath)) {  
            return allocation.decision(
                for (IndexShardRoutingTable shardRoutingTable : routingTable.index(mergeSourceIndex.getName())) {
import org.opensearch.core.index.Index;
                    if (shardIds.contains(shardRoutingTable.shardId())) {
                "allocating the shard to this node will bring the node above the high watermark cluster setting [%s=%s] "
        // allocated and empty.
                freeBytesValue,
    }
            );
        SnapshotShardSizeInfo snapshotShardSizeInfo,  
 * SPDX-License-Identifier: Apache-2.0
        final Map<String, DiskUsage> usages,
        }
                final Set<ShardId> shardIds = IndexMetadata.selectRecoverFromShards(
            logger.trace("getDiskUsage(subtractLeavingShards={}) returning {}", subtractLeavingShards, diskUsageWithRelocations);  
        return diskUsageWithRelocations;  
            logger.warn(
        String dataPath,  
                return allocation.decision(  
            final IndexMetadata sourceIndexMeta = metadata.index(mergeSourceIndex);  
                        node.nodeId()
            } else {  
            );
        }
                shardRouting,  
    public DiskThresholdDecider(Settings settings, ClusterSettings clusterSettings) {  
            try {
            );
            usages,
                    freeDiskPercentage
 */
                )
                sizeOfRelocatingShards
            for (ShardRouting routing : node.shardsWithState(ShardRoutingState.RELOCATING)) {  
        // If this node is already above the high threshold, the shard cannot remain (get it off!)
                }  
 * KIND, either express or implied.  See the License for the
                        + "never been allocated before"
    private Decision earlyTerminate(RoutingAllocation allocation, final Map<String, DiskUsage> usages) {
    private final DiskThresholdSettings diskThresholdSettings;  
                    + "{} free (currently {} free, estimated shard size is {}), preventing allocation",
                freeDiskPercentage
                return allocation.decision(
                    subtractLeavingShards,  
            logger.debug(
        final double usedDiskThresholdHigh = 100.0 - diskThresholdSettings.getFreeDiskThresholdHigh();  
                CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(),
 * 0.85 (85.0%).
                Decision.NO,
        RoutingNode node,
                }
        if (usage == null) {
    }
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING;
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING;
                        node.nodeId()  
                        node.nodeId()
                    freeBytes,
                "the shard cannot remain on this node because it is above the high watermark cluster setting [%s=%s] "
                node,
 */
                    CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(),
                    logger.debug(
 *     http://www.apache.org/licenses/LICENSE-2.0
                    node.nodeId()
                        freeBytesValue,  
    /**  
            );
            );
        @Override
        // checks for exact byte comparisons
        }
                usage,
                }
            clusterInfo.getAvgTotalBytes(),  
import org.opensearch.snapshots.SnapshotShardSizeInfo;
                    "the node is above the low watermark, but less than the high watermark, and this primary shard has "  
        // Fail open there is no info available  
/**
        }
                }  
            false
            usage.getNodeId(),
            return Decision.ALWAYS;  
import java.util.List;  
 * <code>cluster.routing.allocation.disk.watermark.high</code> is the high disk
                    }
        }  
                if (logger.isDebugEnabled()) {
        long totalSize = reservedSpace.getTotal();
            node,
            );  
                Strings.format1Decimals(freeSpaceAfterShard, "%")  
    /**
        ClusterInfo clusterInfo,
                    CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(),
                CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(),
                if (logger.isDebugEnabled()) {
                ? sizeOfRelocatingShards(
                    allocation.metadata(),  
                    );
            } else {
        }  
                        "less than the required {} free bytes threshold ({} free) on node {}, "  
        double freeSpaceAfterShard = freeDiskPercentageAfterShardAssigned(usage, shardSize);
                if (logger.isDebugEnabled()) {  
                return snapshotShardSizeInfo.getShardSize(shard, defaultValue);
            return diskUsage.getNodeId();
        if (freeDiskPercentage < diskThresholdSettings.getFreeDiskThresholdLow()) {  
        ShardRouting shard,  
                node.nodeId(),  
            return allocation.decision(  
        // Secondly, check that allocating the shard to this node doesn't put it above the high watermark
        DiskUsageWithRelocations(DiskUsage diskUsage, long relocatingShardSize) {  
    @Override  
                "after allocating [{}] node [{}] would have less than the required threshold of "  
                    NAME,
        }
        // flag that determines whether the low threshold checks below can be skipped. We use this for a primary shard that is freshly
                    NAME,  
 * <code>cluster.routing.allocation.disk.threshold_enabled</code> is used to
            return targetShardSize == 0 ? defaultValue : targetShardSize;
                // above the high watermark, so don't allow allocating the shard
            return "DiskUsageWithRelocations{" + "diskUsage=" + diskUsage + ", relocatingShardSize=" + relocatingShardSize + '}';
                return allocation.decision(  
        if (freeSpaceAfterShard < diskThresholdSettings.getFreeDiskThresholdHigh()) {
        }
import java.util.Map;
                        node.nodeId()  
 * <p>
import static org.opensearch.cluster.routing.RoutingPool.getNodePool;
            }
}
                    "less than the required {} free bytes threshold ({} bytes free) on node {}, shard cannot remain",  
                    "less than the required {}% free disk threshold ({}% free) on node {}, shard cannot remain",
                return allocation.decision(
            }
     * Given the DiskUsage for a node and the size of the shard, return the
                        + "space, actual free: [%s]",
        }
                        Strings.format1Decimals(freeDiskPercentage, "%"),
        return allocation.decision(  
import org.opensearch.cluster.routing.RoutingNode;
        }  
        Metadata metadata,
        return null;
        ClusterInfo clusterInfo,
 * The {@link DiskThresholdDecider} checks that the node a shard is potentially  
            throw new IllegalArgumentException("Shard [" + shardRouting + "] is not allocated on node: [" + node.nodeId() + "]");
                    );
                        Strings.format1Decimals(usedDiskPercentage, "%"),
        return newUsage.getFreeDiskAsPercentage();
                        Strings.format1Decimals(usedDiskThresholdLow, "%"),  
            NAME,
            this.diskUsage = diskUsage;
        ClusterInfo clusterInfo = allocation.clusterInfo();
        double getUsedDiskAsPercentage() {
            this.relocatingShardSize = relocatingShardSize;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.settings.ClusterSettings;
 * specific language governing permissions and limitations
    }
import org.opensearch.core.index.shard.ShardId;  
        String getNodeId() {  
        // Cache the used disk percentage for displaying disk percentages consistent with documentation
        }  
            if (skipLowThresholdChecks == false) {
        final DiskUsageWithRelocations usage = getDiskUsage(
            final long sizeOfRelocatingShards = sizeOfRelocatingShards(  
                if (actualPath == null) {
            && shardRouting.active() == false
    public Decision canRemain(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
    double freeDiskPercentageAfterShardAssigned(DiskUsageWithRelocations usage, Long shardSize) {
 * enable or disable this decider. It defaults to true (enabled).
/*  
                    CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(),  
                return allocation.decision(  
        final double usedDiskThresholdLow = 100.0 - diskThresholdSettings.getFreeDiskThresholdLow();
        double usedDiskPercentage = usage.getUsedDiskAsPercentage();  
            );
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
        assert Version.CURRENT.major < 9 : "remove enable_for_single_data_node in 9";
 * <p>  
            Decision.YES,
                    "the node is above the low watermark cluster setting [%s=%s], using more disk space than the maximum allowed "
            new ByteSizeValue(shardSize),
     * <p>  
            logger.warn(  
                totalSize += getExpectedShardSize(routing, 0L, clusterInfo, null, metadata, routingTable);
            // If the shard is a replica or is a non-empty primary, check the low threshold
        if (freeBytesAfterShard < diskThresholdSettings.getFreeBytesThresholdHigh().getBytes()) {
                diskThresholdSettings.getFreeBytesThresholdHigh(),  
import org.opensearch.cluster.ClusterInfo;
    @Override
import org.opensearch.cluster.routing.ShardRouting;  
            if (logger.isDebugEnabled()) {
        long getTotalBytes() {
        }
                    logger.debug(
                            + "but allowing allocation because primary has never been allocated",  
                    totalSize -= getExpectedShardSize(routing, 0L, clusterInfo, null, metadata, routingTable);
        }
                        + "[%s%%], actual free: [%s%%]",  
            clusterInfo.getAvgTotalBytes(),
        );
        // NB this counts all shards on the node when the ClusterInfoService retrieved the node stats, which may include shards that are
                continue;  
            );
            // use the average usage for all nodes as the usage for this node  
            return diskUsage.getNodeName();
            );
 * Both watermark settings are expressed in terms of used disk percentage, or
            );
     * to estimate the shards size.  
        String getNodeName() {
        return allocation.decision(
                    diskThresholdSettings.getFreeBytesThresholdLow(),
        long getFreeBytes() {  
                allocation.clusterInfo(),
        DiskUsage usage = usages.get(node.nodeId());  
            diskThresholdSettings.includeRelocations()  
                return allocation.decision(
            return allocation.decision(Decision.YES, NAME, "the disk threshold decider is disabled");
                    freeBytesValue  
        if (decision != null) {
                    "the node is above the high watermark cluster setting [%s=%s], using more disk space than the maximum allowed "  
                        "less than the required {} free bytes threshold ({} free) on node {}, "  
    /**  
        // For this case WarmDiskThresholdDecider Decider will take decision
                );
                        targetShardSize += clusterInfo.getShardSize(shardRoutingTable.primaryShard(), 0);  
 * You may obtain a copy of the License at  
 *  
                }
                    freeDiskPercentage,
        final ClusterInfo.ReservedSpace reservedSpace = clusterInfo.getReservedSpace(node.nodeId(), dataPath);  
        );  
                    NAME,
                    logger.debug(
 * compatible open source license.
        if (indexMetadata.getResizeSourceIndex() != null
        if (freeDiskPercentage < diskThresholdSettings.getFreeDiskThresholdHigh()) {
                        + "[%s%%], actual free: [%s%%]",
     */
        if (freeBytes < 0L) {
 * this file be licensed under the Apache-2.0 license or a
                );  
        }  
                );  
            clusterInfo.getAvgFreeByte(),
            return decision;  
     * Returns the expected shard size for the given shard or the default value provided if not enough information are available
                NAME,
        } else if (REMOTE_CAPABLE.equals(getShardPool(shardRouting, allocation))) {
    public static final String NAME = "disk_threshold";
     * the node, but may not be finished transferring yet.
                "the shard cannot remain on this node because it is above the high watermark cluster setting [%s=%s] "  
        private final DiskUsage diskUsage;  
    public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
                if (dataPath.equals(actualPath)) {  
        if (usages.isEmpty()) {
    public static long sizeOfRelocatingShards(  
        if (logger.isTraceEnabled()) {
                    diskThresholdSettings.getHighWatermarkRaw(),
import org.apache.logging.log4j.Logger;
                        node.nodeId()
            return allocation.decision(Decision.YES, NAME, "this shard is not allocated on the most utilized disk and can remain");  
                        diskThresholdSettings.getFreeBytesThresholdLow(),
        if (enableForSingleDataNode == false && allocation.nodes().getDataNodes().size() <= 1) {
    private final boolean enableForSingleDataNode;
            if (sourceIndexMeta != null) {
                // has never been allocated if it's under the high watermark
                    diskThresholdSettings.getLowWatermarkRaw(),
        boolean skipLowThresholdChecks = shardRouting.primary()  
 * this work for additional information regarding copyright
                usage,
                    actualPath = clusterInfo.getDataPath(routing.cancelRelocation());
        // and take the size into account  
        final long avgFreeBytes,
                false,
        if (shardRouting.currentNodeId().equals(node.nodeId()) == false) {  
            && shard.recoverySource().getType() == RecoverySource.Type.LOCAL_SHARDS) {
            );
                diskThresholdSettings.getHighWatermarkRaw(),  
        RoutingNode node,
        }
                "fewer free bytes remaining than the size of all incoming shards: "  
        } else {
        if (decision != null) {
        );
                Decision.NO,
 * <code>cluster.routing.allocation.disk.watermark.low</code> is the low disk
        long freeBytes = usage.getFreeBytes();
            if (logger.isDebugEnabled()) {
        if (freeBytes < 0L) {
                            + "but allowing allocation because primary has never been allocated",
        final Decision decision = earlyTerminate(allocation, usages);
            }  
                    usage.getFreeDiskAsPercentage()
                    logger.debug(
 * GitHub history for details.
        double freeDiskPercentage = usage.getFreeDiskAsPercentage();
        final long freeBytes = usage.getFreeBytes();
                    NAME,
        if (clusterInfo == null) {
        }
 * <p>  
                NAME,
            // the worst case  
                    Decision.YES,
 */  
                    + "and there is less than the required [%s] free space on node, actual free: [%s]",
            }
            logger.trace("node [{}] has {}% used disk", node.nodeId(), usedDiskPercentage);
    public static long getExpectedShardSize(
            return diskUsage.getTotalBytes();  
import org.opensearch.common.settings.Settings;
                "the shard cannot remain on this node because the node has fewer free bytes remaining than the total size of all "  
            final String actualPath = clusterInfo.getDataPath(routing);  
import static org.opensearch.cluster.routing.RoutingPool.getShardPool;  
                        diskThresholdSettings.getFreeBytesThresholdLow(),
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
        if (freeBytes < diskThresholdSettings.getFreeBytesThresholdLow().getBytes()) {
                    + "{} free disk threshold ({} free), preventing allocation",
            usages,
                        diskThresholdSettings.getFreeBytesThresholdHigh(),
 *
            clusterInfo.getAvgFreeByte(),  
        final DiskUsageWithRelocations usage = getDiskUsage(
                    + "usage {} on node {} including {} bytes of relocations, preventing allocation",
                freeBytes + sizeOfRelocatingShards,  
            return allocation.decision(Decision.YES, NAME, "the cluster info is unavailable");  
 * <p>  
                        "more than the allowed {} used disk threshold ({} used) on node [{}], "
                usage.getPath(),  
                allocation.clusterInfo(),
                    diskThresholdSettings.getFreeDiskThresholdHigh(),  
        }
        if (dataPath == null || usage.getPath().equals(dataPath) == false) {
                        "less than the required {} free bytes threshold ({} free) on node {}, preventing allocation",  
            usage,
        DiskUsage newUsage = new DiskUsage(  
        Metadata metadata,
                    "unable to determine disk usage for {}, defaulting to average across nodes [{} total] [{} free] [{}% free]",
        final long avgTotalBytes,  
                    );
                        "more than the allowed {} used disk threshold ({} used) on node [{}], preventing allocation",
                    "the node is above the low watermark cluster setting [%s=%s], having less than the minimum required [%s] free "  
            if (logger.isTraceEnabled()) {  
            freeBytesValue,
                );
        RoutingTable routingTable
                    NAME,  
            return allocation.decision(Decision.YES, NAME, "disk usages are unavailable");
                    Decision.NO,  
    static class DiskUsageWithRelocations {
            final long sizeOfRelocatingShards = sizeOfRelocatingShards(  
                logger.trace("cluster info unavailable for disk threshold decider, allowing allocation.");
            allocation.metadata(),
                    CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(),
        } else if (REMOTE_CAPABLE.equals(getShardPool(shardRouting, allocation))) {
    }
                );  
            if (logger.isDebugEnabled()) {  
                    node.nodeId()  
        );  
        }  
                logger.debug(  
        );  
 * The OpenSearch Contributors require contributions made to  
        if (logger.isTraceEnabled()) {  
                    usedDiskThresholdHigh,
            logger.trace("node [{}] has {}% free disk ({} bytes)", node.nodeId(), freeDiskPercentage, freeBytes);  
                        + "space, actual free: [%s]",
/*
        RoutingAllocation allocation,  
                diskThresholdSettings.getHighWatermarkRaw(),
                // in practice the only initializing-but-not-relocating shards with a nonzero expected shard size will be ones created  
                // any additional space and can be ignored here
            } else if (freeDiskPercentage > diskThresholdSettings.getFreeDiskThresholdHigh()) {  
                }
                    Decision.NO,
        // Always allow allocation if the decider is disabled
            usage.getFreeBytes() - shardSize
            allocation.routingTable()
package org.opensearch.cluster.routing.allocation.decider;
                        freeBytesValue,
        }  
        double getFreeDiskAsPercentage() {
            new ByteSizeValue(freeBytes)  
        // subtractLeavingShards is passed as false here, because they still use disk space, and therefore we should be extra careful
                // Even though the primary has never been allocated, the node is
 * exact byte values for free space (like "500mb")
            final Index mergeSourceIndex = indexMetadata.getResizeSourceIndex();
                usage.getPath(),  
                allocation.metadata(),
        long freeBytesAfterShard = freeBytes - shardSize;  
 * the Apache License, Version 2.0 (the "License"); you may
        }  
import org.opensearch.cluster.DiskUsage;
            if (logger.isTraceEnabled()) {
        // First, check that the node currently over the low watermark  
        }
                "the node has fewer free bytes remaining than the total size of all incoming shards: "
            }
            // if we don't yet know the actual path of the incoming shard then conservatively assume it's going to the path with the least
                }
                new ByteSizeValue(freeBytes)
            return decision;
    }
                    usage.getPath(),
                            + "preventing allocation even though primary has never been allocated",  
                diskThresholdSettings.getFreeBytesThresholdHigh(),
            NAME,
        }  
                        "less than the required {} free bytes threshold ({} bytes free) on node {}, "
            allocation.snapshotShardSizeInfo(),  
        Map<String, DiskUsage> usages = clusterInfo.getNodeMostAvailableDiskUsages();
                NAME,
        }
                }
            // If there is no usage, and we have other nodes in the cluster,
            return allocation.decision(
            usage.getNodeName(),
            allocation.clusterInfo(),
            usage.getTotalBytes(),
                    // we might know the path of this shard from before when it was relocating  
                    sourceIndexMeta,
        if (REMOTE_CAPABLE.equals(getNodePool(node)) && REMOTE_CAPABLE.equals(getShardPool(shardRouting, allocation))) {
            "enough disk for shard on node, free: [%s], shard size: [%s], free after allocating shard: [%s]",  
                        node.nodeId()  
            if (getTotalBytes() == 0L) {
        // since shards are moving away. No new shards will be incoming since in canAllocate we pass false for this check.
        this.diskThresholdSettings = new DiskThresholdSettings(settings, clusterSettings);
        if (logger.isTraceEnabled()) {
                    usedDiskThresholdLow,  
import org.opensearch.core.common.Strings;  
                    + "free space [%sB], relocating shards [%sB]",
                if (logger.isDebugEnabled()) {  
import org.opensearch.cluster.routing.RoutingTable;
import java.util.Set;
                CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(),
                "allocating the shard to this node will bring the node above the high watermark cluster setting [%s=%s] "
            shardRouting,  
        );
        if (REMOTE_CAPABLE.equals(getNodePool(node)) && REMOTE_CAPABLE.equals(getShardPool(shardRouting, allocation))) {
                node.nodeId(),
                logger.trace("only a single data node is present, allowing allocation");
                        Strings.format1Decimals(usedDiskPercentage, "%"),
            }
                    diskThresholdSettings.getHighWatermarkRaw(),  
            Decision.YES,  
            logger.debug(
 * watermark. New shards will not allocated to a node with usage higher than this,  
    private static final Logger logger = LogManager.getLogger(DiskThresholdDecider.class);
    ) {
            return 100.0 * ((double) getFreeBytes() / getTotalBytes());
                        Strings.format1Decimals(usedDiskThresholdLow, "%"),
            } else if (freeBytes > diskThresholdSettings.getFreeBytesThresholdHigh().getBytes()) {
        }
                            + "preventing allocation even though primary has never been allocated",
                    + "and cause it to use more disk space than the maximum allowed [%s%%] (free space after shard added: [%s%%])",  
                freeBytes + sizeOfRelocatingShards,
                new ByteSizeValue(shardSize)  
import org.opensearch.Version;  
        // For this case WarmDiskThresholdDecider Decider will take decision
                Decision.NO,  
        final IndexMetadata indexMetadata = metadata.getIndexSafe(shard.index());
            if (routing.relocatingNodeId() == null || reservedSpace.containsShardId(routing.shardId())) {
        private final long relocatingShardSize;
                    );
                logger.trace("unable to determine disk usages for disk-aware allocation, allowing allocation");  
                    node,
 * 0.90 (90.0%).
                    freeDiskPercentage
        }
 * <p>
import org.apache.logging.log4j.LogManager;
                }
                Decision.NO,  
        final String dataPath = clusterInfo.getDataPath(shardRouting);
                    usage.getFreeBytes(),
            } catch (ArithmeticException e) {  
            allocation,
                node.nodeId(),  
        public String toString() {  
                // by a resize (shrink/split/clone) operation which we expect to happen using hard links, so they shouldn't be taking
