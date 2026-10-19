                    }  
        final Map<String, DiskUsage> usages = info.getNodeLeastAvailableDiskUsages();  
    /**  
            setLastRunTimeMillis();
                        relocatingShardsSize = sizeOfRelocatingShards(routingNode, diskUsage, info, reroutedClusterState);
                    }  
    }
                                + "currently relocating away shards totalling [{}] bytes; the node is expected to be below the high "  
            ? Settings.builder().put(IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE, Boolean.TRUE.toString()).build()
    }
            final RoutingNode routingNode = routingNodes.node(node);
 * passed the disk watermarks  
                            diskThresholdSettings.describeHighThreshold(),
import org.opensearch.cluster.DiskUsage;
            routingNode,  
                            diskUsage,  
            .cluster()
                            -relocatingShardsSize  
        this.client = client;
                .map(Map.Entry::getKey)
 * GitHub history for details.
                    indicesToMarkIneligibleForAutoRelease.add(indexName);  
            final DiskUsage usageWithReservedSpace = new DiskUsage(
            setLastRunTimeMillis();
    private void setLastRunTimeMillis() {  
                } else if (aggregateFileCacheStats != null  
import org.opensearch.common.settings.Settings;
                        nodesOverLowThreshold.remove(node);  
            : Settings.builder().putNull(IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE).build();
                            fileCacheThresholdSettings.describeIndexThreshold(),  
    public DiskThresholdMonitor(  
                    // will log about this node when the reroute completes
                setLastRunTimeMillis();
                            "index file cache threshold [{}] exceeded on {}, indices on this node are marked read only.",
import org.opensearch.common.settings.ClusterSettings;  
        handleReadOnlyBlocks(state, indicesToMarkReadOnly, indicesNotToAutoRelease, listener);
                    } else {  
        for (String node : nodesToCleanUp) {  
        lastRunTimeMillis.getAndUpdate(l -> Math.max(l, currentTimeMillisSupplier.getAsLong()));
            ? Settings.builder().put(IndexMetadata.SETTING_BLOCKS_READ, Boolean.TRUE.toString()).build()  
            .prepareUpdateSettings()
    private void markNodesMissingUsageIneligibleForRelease(  
                            node,
import static org.opensearch.cluster.routing.RoutingPool.getNodePool;
                        fileCacheThresholdSettings.describeSearchThreshold(),  
                    logger.debug(  
                    "flood stage disk watermark [{}] exceeded on {}, all indices on this node will be marked read-only",  
            .collect(Collectors.toSet());
        return DiskThresholdDecider.sizeOfRelocatingShards(
    /**  
        client.admin()
                if (wasUnderLowThreshold) {  
                logger.warn(
            }
                nodesToCleanUp.remove(node);
                    "Removing index create block on cluster as all nodes are no longer breaching high disk watermark. "  
                        logger.debug(
import org.opensearch.action.support.GroupedActionListener;
        ClusterSettings clusterSettings,  
                        logger.debug(
        }, e -> {  
import org.opensearch.cluster.routing.RoutingNode;  
                    } else if (nodesOverHighThresholdAndRelocating.add(diskUsage.getNodeId())) {  
            Spliterators.spliterator(state.routingTable().indicesRouting().entrySet(), 0),
                    // shards
 */  
                    }
        ClusterState state,
            : Settings.builder().putNull(IndexMetadata.SETTING_BLOCKS_READ).build();
                        usage
    private final AtomicLong lastRunTimeMillis = new AtomicLong(Long.MIN_VALUE);  
                }  
    private final RerouteService rerouteService;  
                for (DiskUsage diskUsage : usagesOverHighThreshold) {
        indicesToMarkReadOnly.removeIf(index -> state.getBlocks().indexBlocked(ClusterBlockLevel.WRITE, index));
                assert (wasUnderLowThreshold && wasOverHighThreshold) == false;
import org.opensearch.cluster.metadata.IndexMetadata;  
            logger.trace("no auto-release required");
            logger.trace("no reroute required");
                "Putting index create block on cluster as all nodes are breaching high disk watermark. "  
            logger.debug(new ParameterizedMessage("setting indices [{}] read block failed", readBlock), e);
        } else {  
                    }  
                    if (lastRunTimeMillis.get() <= currentTimeMillis - diskThresholdSettings.getRerouteInterval().millis()) {  
            if (usages.containsKey(routingNode.nodeId()) == false) {  
                        );
            .collect(Collectors.toSet());
     * The IDs of the nodes that were over the low threshold in the last check (and maybe over another threshold too). Tracked so that we
                    );
    ) {
import org.opensearch.common.regex.Regex;
                            diskUsage,
            listener.onFailure(e);
                for (ShardRouting routing : routingNode) {
                if (routingNode != null) { // might be temporarily null if the ClusterInfoService and the ClusterService are out of step
                    }  
                        usageIncludingRelocations = new DiskUsage(
 * Licensed to Elasticsearch under one or more contributor  
            .filter(index -> !state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_BLOCK))  
    private final FileCacheEvaluator fileCacheEvaluator;
            .filter(index -> state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK))
                                + "currently relocating away shards totalling [{}] bytes",  
                            "{} has gone below a disk threshold, but an automatic reroute has occurred "  
        }
                );
        ActionListener<Void> wrappedListener = ActionListener.wrap(r -> {  
                            diskUsage.getNodeName(),
            if (nodeDiskEvaluator.isNodeExceedingHighWatermark(usage)) {
                    nodesOverHighThreshold.size(),
                    for (ShardRouting routing : routingNode) {
            logger.debug("rerouting shards: [{}]", explanation);
                    // The node has previously been over the low watermark, but is no longer, so it may be possible to allocate more  
        }
            } else {  
        ActionListener<Void> listener
 *  
import java.util.List;
        Supplier<Double> dataToFileCacheSizeRatioSupplier
import org.opensearch.cluster.ClusterInfo;
            diskUsage.getPath(),
    private static final Logger logger = LogManager.getLogger(DiskThresholdMonitor.class);  
        if (indicesToReleaseReadBlock.isEmpty() == false) {
        );  
        logger.trace("checkFinished");
                nodesOverHighThresholdAndRelocating.remove(node);
                        diskThresholdSettings.describeLowThreshold()
                        indicesToMarkReadOnly.add(indexName);
            setLastRunTimeMillis();  
                    );
    public void onNewInfo(ClusterInfo info) {
        logger.trace("marking indices as read-only: [{}]", indicesToMarkReadOnly);  
            } else {  
            listener.onResponse(null);
            }
        Settings settings,
            setLastRunTimeMillis();  
            && nodesOverHighThreshold.size() < nodes.size()) {
        this.currentTimeMillisSupplier = currentTimeMillisSupplier;
            updateIndicesReadOnly(indicesToMarkReadOnly, listener, true);
                continue;
            return;  
            : Settings.builder().putNull(Metadata.SETTING_CREATE_INDEX_BLOCK_SETTING.getKey()).build();
                        indicesToMarkReadOnly.add(indexName);
import org.opensearch.transport.client.Client;  
import org.opensearch.cluster.ClusterState;  
                if (aggregateFileCacheStats != null && fileCacheEvaluator.isNodeExceedingSearchThreshold(aggregateFileCacheStats)) {  
            info,  
                            String indexName = routing.index().getName();  
                    );
                        logger.warn(
                        "search file cache threshold [{}] exceeded on {}, read block applied on indices on this node",
 *
    }
                        "low disk watermark [{}] exceeded on {}, replicas will not be assigned to this node",
                    for (ShardRouting routing : routingNode) {  
    private final Supplier<ClusterState> clusterStateSupplier;
import java.util.concurrent.atomic.AtomicLong;  
import java.util.Map;
        this.rerouteService = rerouteService;
import java.util.concurrent.atomic.AtomicBoolean;
            listener.onResponse(r);
        cleanUpRemovedNodes(nodes, nodesOverHighThreshold);
                        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                            "high disk watermark [{}] exceeded on {}, shards will be relocated away from this node; "
        final ActionListener<Void> listener = new GroupedActionListener<>(ActionListener.wrap(this::checkFinished), 6);
            .collect(Collectors.toSet());
                            diskUsage.getNodeId(),  
import java.util.ArrayList;
        final ActionListener<Void> wrappedListener = ActionListener.wrap(r -> {
                setLastRunTimeMillis();  
    private final Client client;  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
                usage.getPath(),
            updateIndicesReadBlock(indicesToApplyReadBlock, listener, true);
    }
                nodesOverHighThresholdAndRelocating.remove(node);  
        }  
     * can log when such nodes are no longer over the low threshold.
            listener.onResponse(null);
    private final DiskThresholdSettings diskThresholdSettings;
 *
            if (isWarmNode) {
    }
        handleReadBlocks(state, indicesToBlockRead, listener);
     * under the high threshold again. Tracked so that we can log when such nodes are no longer in this state.
    /**
        Settings readBlockSettings = readBlock
                );  
    private void checkFinished() {
            }
                        String indexName = routing.index().getName();  
        handleClusterCreateIndexBlocks(state, nodes, listener);  
                            diskUsage.getTotalBytes(),  
        }
                final boolean wasOverHighThreshold = nodesOverHighThreshold.remove(node);
        // set read-only block but don't block on the response  
    private final NodeDiskEvaluator nodeDiskEvaluator;
        });
            reroutedClusterState.routingTable()
    }
            .map(Map.Entry::getKey)  
        final Set<String> indicesToApplyReadBlock = indicesToBlockRead.stream()
        } else {  
                        logger.warn(
            .execute(ActionListener.map(wrappedListener, r -> null));
        }  
                }
                        diskThresholdSettings.describeLowThreshold(),  
        });
                        diskThresholdSettings.describeHighThreshold(),  
                        usage,
        } else if (state.getBlocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id())
        cleanUpRemovedNodes(nodes, nodesOverLowThreshold);  
                    final long relocatingShardsSize;
        // all ClusterInfo updates are processed and never ignored  
            final long reservedSpace = info.getReservedSpace(usage.getNodeId(), usage.getPath()).getTotal();
 * Unless required by applicable law or agreed to in writing,
        }
                        explanation = "one or more nodes has gone under the high or low watermark";
import org.opensearch.core.action.ActionListener;  
                }
        this.diskThresholdSettings = new DiskThresholdSettings(settings, clusterSettings);  
        }
        }, e -> {
                        logger.info(
        assert checkFinished;  
 */  
     * Determines which indices should have their read blocks released based on the auto-release setting
/*  
            .filter(index -> indicesToBlockRead.contains(index) == false)
        final ClusterState state = clusterStateSupplier.get();
        if (diskThresholdSettings.isIndexReadBlockAutoReleaseEnabled()) {  
import java.util.Set;  
        markNodesMissingUsageIneligibleForRelease(routingNodes, usages, indicesNotToAutoRelease);  
        for (RoutingNode routingNode : routingNodes) {
            updateIndicesReadBlock(indicesToReleaseReadBlock, listener, false);
            );
            listener.onResponse(null);
                    String indexName = routing.index().getName();
                            diskThresholdSettings.getRerouteInterval()  
package org.opensearch.cluster.routing.allocation;
    }
        // When auto-release is disabled, still release indices matching exclude patterns
    }  
    ) {
            .setSettings(readOnlySettings)  
        // Clean up nodes that have been removed from the cluster
import org.apache.logging.log4j.message.ParameterizedMessage;  
 * specific language governing permissions and limitations
    /**  
            .indices()  
                        indicesToBlockRead.add(indexName);  
                            usage
                        usage
import org.apache.logging.log4j.LogManager;
    }
 * reroute if it does. Also responsible for logging about nodes that have
            if (nodeDiskEvaluator.isNodeExceedingHighWatermark(usageWithReservedSpace)) {
     * The IDs of the nodes that were over the high threshold in the last check (and maybe over another threshold too). Tracked so that we
            rerouteService.reroute("disk threshold monitor", Priority.HIGH, ActionListener.wrap(reroutedClusterState -> {  
                listener.onFailure(e);
        final Set<String> indicesToAutoRelease = StreamSupport.stream(
        List<String> excludePatterns = diskThresholdSettings.getIndexReadBlockAutoReleaseExcludePatterns();
            .filter(index -> state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_BLOCK))  
                        + "Number of nodes above high watermark: {}. Total numbers of nodes: {}.",
            }
                        String indexName = routing.index().getName();
                        );
        final Set<String> nodes = usages.keySet();
                        node,
            return StreamSupport.stream(Spliterators.spliterator(state.routingTable().indicesRouting().entrySet(), 0), false)
                } else if (wasOverHighThreshold) {  
    private final Set<String> nodesOverLowThreshold = Sets.newConcurrentHashSet();
            listener.onFailure(e);  
import java.util.function.Supplier;
                usage.getNodeId(),  
        RoutingNodes routingNodes = state.getRoutingNodes();
            .setSettings(readBlockSettings)
        logger.trace("processing new cluster info");
                Math.max(0L, usage.getFreeBytes() - reservedSpace)
            listener.onResponse(r);  
        logger.trace("Applying read block on indices: [{}]", indicesToApplyReadBlock);
                if (lastRunTimeMillis.get() <= currentTimeMillis - diskThresholdSettings.getRerouteInterval().millis()) {  
 * ownership. Elasticsearch licenses this file to you under  
                }
                listener.onResponse(null);
                setIndexCreateBlock(listener, false);
        if (checkInProgress.compareAndSet(false, true) == false) {
    private Set<String> resolveIndicesToReleaseReadBlock(ClusterState state, Set<String> indicesToBlockRead) {
                        "high disk watermark exceeded on {} but an automatic reroute has occurred " + "in the last [{}], skipping reroute",
                            diskUsage.getPath(),
        });  
            logger.warn(
 * KIND, either express or implied.  See the License for the
                .collect(Collectors.toSet());
                        relocatingShardsSize = 0L;
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
            .execute(ActionListener.map(wrappedListener, r -> null));  
        final boolean checkFinished = checkInProgress.compareAndSet(true, false);
        for (final Map.Entry<String, DiskUsage> entry : usages.entrySet()) {
                    } else {
        this.fileCacheEvaluator = new FileCacheEvaluator(fileCacheThresholdSettings);
            .filter(index -> indicesNotToAutoRelease.contains(index) == false)  
                    usage
public class DiskThresholdMonitor {
                final boolean wasUnderLowThreshold = nodesOverLowThreshold.add(node);  
                if (nodesOverLowThreshold.contains(node)) {
                            "high disk watermark [{}] exceeded on {}, shards will be relocated away from this node; "
 *     http://www.apache.org/licenses/LICENSE-2.0
                        usageIncludingRelocations = diskUsage;
        // (by default ".*") to protect system indices from getting stuck in read-only state  
 * SPDX-License-Identifier: Apache-2.0
     * can log when such nodes are no longer over the high threshold.
        final Set<String> indicesToMarkReadOnly = new HashSet<>();
            if (routingNode == null) {
 */  
        Map<String, DiskUsage> usages,
        this.fileCacheThresholdSettings = new FileCacheThresholdSettings(settings, clusterSettings);
                logger.warn(
            listener.onResponse(null);  
     * and exclude patterns configuration.  
                    diskThresholdSettings.describeFloodStageThreshold(),
    private final FileCacheThresholdSettings fileCacheThresholdSettings;
            logger.trace("no auto-release required");
                        logger.info(
                        diskThresholdSettings.getRerouteInterval()  
            logger.info("skipping monitor as a check is already in progress");
                            diskUsage.getFreeBytes() - relocatingShardsSize
        if (indicesToMarkReadOnly.isEmpty() == false) {
            .indices()
    private final LongSupplier currentTimeMillisSupplier;
                    if (routingNode != null) { // might be temporarily null if the ClusterInfoService and the ClusterService are out of step  
        final long currentTimeMillis = currentTimeMillisSupplier.getAsLong();
        final Set<String> indicesToBlockRead = new HashSet<>();  
import org.opensearch.cluster.routing.allocation.decider.DiskThresholdDecider;  
        // If all the nodes are breaching high disk watermark, we apply index create block to avoid red clusters.
                    }  
            .execute(ActionListener.map(wrappedListener, r -> null));
                            usage
                        nodesOverHighThreshold.remove(node);
                                + "the high disk watermark when these relocations are complete",
                    usagesOverHighThreshold.add(usage);  
            checkFinished();  
                    final DiskUsage usageIncludingRelocations;
        // TODO find a better way to limit concurrent updates (and potential associated reroutes) while allowing tests to ensure that
        } else {  
                .filter(index -> indicesToBlockRead.contains(index) == false)  
        Set<String> indicesToMarkIneligibleForAutoRelease  
        if (indicesToApplyReadBlock.isEmpty() == false) {  
import java.util.stream.Collectors;  
        }  
        cleanUpRemovedNodes(nodes, nodesOverHighThresholdAndRelocating);
     */  
                            diskUsage,  
                    }
            DiskUsage usage = entry.getValue();  
                }  
                nodesOverLowThreshold.add(node);  
/**  
            } else if (nodeDiskEvaluator.isNodeExceedingLowWatermark(usage)) {
import org.opensearch.cluster.routing.RerouteService;
        if (excludePatterns.isEmpty()) {
            listener.onResponse(null);
                            diskThresholdSettings.describeHighThreshold(),
        Set<String> indicesToMarkReadOnly,  
                            diskThresholdSettings.describeHighThreshold(),
            reroutedClusterState.metadata(),
                }
            logger.debug(new ParameterizedMessage("setting indices [{}] read-only failed", readOnly), e);
                                + "currently relocating away shards totalling [{}] bytes; the node is expected to continue to exceed "  
                    if (nodeDiskEvaluator.isNodeExceedingHighWatermark(usageIncludingRelocations)) {
        } else {
 * You may obtain a copy of the License at  
            setLastRunTimeMillis();
                        String indexName = routing.index().getName();
            }  
                    reroute = true;
                usage.getTotalBytes(),  
                        }  
                            diskThresholdSettings.describeLowThreshold(),
        Client client,
                nodesOverHighThreshold.add(node);
                AggregateFileCacheStats aggregateFileCacheStats = info.getNodeFileCacheStats().getOrDefault(usage.getNodeId(), null);
 * not use this file except in compliance with the License.
            }
import org.opensearch.cluster.routing.ShardRouting;
    }
        client.admin()  
    }
                    logger.info(
                                + "disk watermark when these relocations are complete",
        final Settings indexCreateBlockSetting = indexCreateBlock
            listener.onResponse(r);
 * the Apache License, Version 2.0 (the "License"); you may
        if (reroute) {
        if (usages == null) {
        }, e -> {
    private final Set<String> nodesOverHighThresholdAndRelocating = Sets.newConcurrentHashSet();
 * license agreements. See the NOTICE file distributed with
        Set<String> indicesNotToAutoRelease = new HashSet<>();
            .filter(index -> Regex.simpleMatch(excludePatterns, index))
        if ((state.getBlocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()) == false)
                    explanation = "high disk watermark exceeded on one or more nodes";
        if (indicesToAutoRelease.isEmpty() == false) {
            nodeDiskEvaluator.setNodeType(isWarmNode);
                        "high disk watermark [{}] no longer exceeded on {}, but low disk watermark [{}] is still exceeded",
 * software distributed under the License is distributed on an
import org.apache.logging.log4j.Logger;
        RoutingNodes routingNodes,
                    // if we reroute now.
 * this work for additional information regarding copyright
import org.opensearch.cluster.routing.RoutingNodes;
            );  
                    );  
            .setPersistentSettings(indexCreateBlockSetting)  
            .prepareUpdateSettings(indicesToUpdate.toArray(Strings.EMPTY_ARRAY))
                nodesOverLowThreshold.add(node);
 * The OpenSearch Contributors require contributions made to  
                    nodes.size()  
    protected void updateIndicesReadBlock(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readBlock) {
            }));
            && !nodes.isEmpty()  
     * The IDs of the nodes that were over the high threshold in the last check, but which are relocating shards that will bring them
     */  
 * under the License.  
/*
            ? Settings.builder().put(Metadata.SETTING_CREATE_INDEX_BLOCK_SETTING.getKey(), Boolean.TRUE.toString()).build()  
 * Listens for a node to go over the high watermark and kicks off an empty
                            "low disk watermark [{}] no longer exceeded on {}",  
    // exposed for tests to override  
                            -relocatingShardsSize
            logger.debug("setting index create block failed", e);  
    private final AtomicBoolean checkInProgress = new AtomicBoolean();
    }  
                nodesOverHighThreshold.add(node);
                    logger.info(
    long sizeOfRelocatingShards(RoutingNode routingNode, DiskUsage diskUsage, ClusterInfo info, ClusterState reroutedClusterState) {
        )
            updateIndicesReadOnly(indicesToAutoRelease, listener, false);
                } else {
                nodesOverHighThresholdAndRelocating.remove(node);
        this.clusterStateSupplier = clusterStateSupplier;  
                                + "in the last [{}], skipping reroute",
        }  
     */  
                if (routingNode != null) { // might be temporarily null if the ClusterInfoService and the ClusterService are out of step
        }  
            return;
        } else {  
            true,
                        indicesNotToAutoRelease.add(indexName);
import org.opensearch.common.Priority;
 */
    private void handleClusterCreateIndexBlocks(ClusterState state, Set<String> nodes, ActionListener<Void> listener) {  
                        );
        // set read block but don't block on the response
            final boolean isWarmNode = REMOTE_CAPABLE.equals(getNodePool(routingNode));
        Set<String> indicesNotToAutoRelease,
                listener.onResponse(null);  
                    for (ShardRouting routing : routingNode) {
        RerouteService rerouteService,  
                nodesOverHighThreshold.size()
                    + "Number of nodes above high watermark: {}.",
                    && fileCacheEvaluator.isNodeExceedingIndexingThreshold(aggregateFileCacheStats)) {
    private final Set<String> nodesOverHighThreshold = Sets.newConcurrentHashSet();
 *
import org.opensearch.cluster.metadata.Metadata;
                        for (ShardRouting routing : routingNode) {
    private void handleReadOnlyBlocks(
        Settings readOnlySettings = readOnly  
        String explanation = "";
            false  
import java.util.function.LongSupplier;
            && diskThresholdSettings.isCreateIndexBlockAutoReleaseEnabled()  
                    boolean isNodeWarm = REMOTE_CAPABLE.equals(getNodePool(routingNode));
}  
                            -relocatingShardsSize
import java.util.stream.StreamSupport;
        boolean reroute = false;  
        }
                        );
    }
                        reroute = true;
                usage.getNodeName(),
                        indicesNotToAutoRelease.add(indexName);
import org.opensearch.cluster.block.ClusterBlockLevel;
                logger.debug("reroute failed", e);
                .filter(index -> state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_BLOCK))
                        indicesNotToAutoRelease.add(indexName);
            listener.onFailure(e);
                    nodeDiskEvaluator.setNodeType(isNodeWarm);  
    private static void cleanUpRemovedNodes(Set<String> nodesToKeep, Set<String> nodesToCleanUp) {
    protected void setIndexCreateBlock(final ActionListener<Void> listener, boolean indexCreateBlock) {
                        );
            && nodesOverHighThreshold.size() == nodes.size()) {
            }
import org.opensearch.core.common.Strings;
                continue;  
import java.util.Spliterators;
        return StreamSupport.stream(Spliterators.spliterator(state.routingTable().indicesRouting().entrySet(), 0), false)
                    logger.warn(
                            indicesNotToAutoRelease.add(indexName);
import org.opensearch.common.util.set.Sets;
     */
            if (nodeDiskEvaluator.isNodeExceedingFloodStageWatermark(usage)) {  
        ActionListener<Void> wrappedListener = ActionListener.wrap(r -> {
 * this file be licensed under the Apache-2.0 license or a
        client.admin()  
                            "high disk watermark [{}] exceeded on {}, shards will be relocated away from this node; "
            final String node = entry.getKey();
                    final RoutingNode routingNode = reroutedClusterState.getRoutingNodes().node(diskUsage.getNodeId());  
        this.nodeDiskEvaluator = new NodeDiskEvaluator(diskThresholdSettings, dataToFileCacheSizeRatioSupplier);  
            .prepareUpdateSettings(indicesToUpdate.toArray(Strings.EMPTY_ARRAY))
            setIndexCreateBlock(listener, true);
            }, e -> {
        }  
            }
                        nodesOverHighThresholdAndRelocating.remove(diskUsage.getNodeId());  
                        );  
    protected void updateIndicesReadOnly(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readOnly) {
            // Only for Dedicated Warm Nodes  
                }
    private void handleReadBlocks(ClusterState state, Set<String> indicesToBlockRead, ActionListener<Void> listener) {
    ) {  
                            indicesToMarkReadOnly.add(indexName);
            .map(Map.Entry::getKey)
        final List<DiskUsage> usagesOverHighThreshold = new ArrayList<>();
        Supplier<ClusterState> clusterStateSupplier,
import static org.opensearch.cluster.routing.RoutingPool.REMOTE_CAPABLE;  
    }
            logger.trace("skipping monitor as no disk usage information is available");
 * @opensearch.internal
            setLastRunTimeMillis();
            return Set.of();  
                    } else {  
        final Set<String> indicesToReleaseReadBlock = resolveIndicesToReleaseReadBlock(state, indicesToBlockRead);
/*  
        LongSupplier currentTimeMillisSupplier,
import java.util.HashSet;  
            if (nodesToKeep.contains(node) == false) {
