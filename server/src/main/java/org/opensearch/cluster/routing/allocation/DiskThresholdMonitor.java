        }
                    } else if (nodesOverHighThresholdAndRelocating.add(diskUsage.getNodeId())) {
        final Set<String> nodes = usages.keySet();
 * KIND, either express or implied.  See the License for the
     * can log when such nodes are no longer over the high threshold.
                        );
 *
import java.util.Set;
                            fileCacheThresholdSettings.describeIndexThreshold(),
        assert checkFinished;
     * Determines which indices should have their read blocks released based on the auto-release setting
                if (wasUnderLowThreshold) {
                            diskUsage,
        this.fileCacheEvaluator = new FileCacheEvaluator(fileCacheThresholdSettings);
                    nodes.size()
    }
        Map<String, DiskUsage> usages,
        // Clean up nodes that have been removed from the cluster
    private Set<String> resolveIndicesToReleaseReadBlock(ClusterState state, Set<String> indicesToBlockRead) {
    }
                for (ShardRouting routing : routingNode) {
    /**
 * ownership. Elasticsearch licenses this file to you under
            .execute(ActionListener.map(wrappedListener, r -> null));
            }
                    if (routingNode != null) { // might be temporarily null if the ClusterInfoService and the ClusterService are out of step
    private final FileCacheEvaluator fileCacheEvaluator;
                            diskUsage.getFreeBytes() - relocatingShardsSize
            updateIndicesReadBlock(indicesToReleaseReadBlock, listener, false);
                    indicesToMarkIneligibleForAutoRelease.add(indexName);
    private final LongSupplier currentTimeMillisSupplier;
import java.util.List;
                        fileCacheThresholdSettings.describeSearchThreshold(),
            .indices()
        this.rerouteService = rerouteService;
                Math.max(0L, usage.getFreeBytes() - reservedSpace)
    protected void updateIndicesReadBlock(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readBlock) {
        }, e -> {
            listener.onResponse(r);
/**
import org.apache.logging.log4j.Logger;
                assert (wasUnderLowThreshold && wasOverHighThreshold) == false;
                        diskThresholdSettings.describeLowThreshold()
        Client client,
                nodesOverHighThreshold.add(node);
        // (by default ".*") to protect system indices from getting stuck in read-only state
import org.opensearch.core.common.Strings;
import org.opensearch.cluster.metadata.IndexMetadata;
    private void markNodesMissingUsageIneligibleForRelease(
        if (indicesToMarkReadOnly.isEmpty() == false) {
                            diskUsage,
                        nodesOverHighThreshold.remove(node);
                usage.getTotalBytes(),
        client.admin()
                        usage
        RerouteService rerouteService,
        );
import org.opensearch.cluster.routing.ShardRouting;
    private final AtomicBoolean checkInProgress = new AtomicBoolean();
                        diskThresholdSettings.getRerouteInterval()
                            diskUsage.getNodeId(),
    }
            logger.debug("setting index create block failed", e);
        cleanUpRemovedNodes(nodes, nodesOverHighThresholdAndRelocating);
    }
import java.util.stream.Collectors;
import org.opensearch.cluster.ClusterInfo;
            final boolean isWarmNode = REMOTE_CAPABLE.equals(getNodePool(routingNode));
import org.opensearch.common.Priority;
                        );
                    } else {
import static org.opensearch.cluster.routing.RoutingPool.REMOTE_CAPABLE;
                        usage
            nodeDiskEvaluator.setNodeType(isWarmNode);
        this.currentTimeMillisSupplier = currentTimeMillisSupplier;
                }
                        usage,
        LongSupplier currentTimeMillisSupplier,
            listener.onResponse(null);
    }
        if (indicesToAutoRelease.isEmpty() == false) {
            if (usages.containsKey(routingNode.nodeId()) == false) {
    private static void cleanUpRemovedNodes(Set<String> nodesToKeep, Set<String> nodesToCleanUp) {
        handleClusterCreateIndexBlocks(state, nodes, listener);
    }
    }
            final RoutingNode routingNode = routingNodes.node(node);
                nodesOverLowThreshold.add(node);
                );
                        );
                    "Removing index create block on cluster as all nodes are no longer breaching high disk watermark. "
import org.opensearch.cluster.block.ClusterBlockLevel;
                } else if (wasOverHighThreshold) {
                            diskUsage.getNodeName(),
 * Unless required by applicable law or agreed to in writing,
import java.util.function.LongSupplier;
    protected void updateIndicesReadOnly(Set<String> indicesToUpdate, ActionListener<Void> listener, boolean readOnly) {
        )
import org.opensearch.cluster.metadata.Metadata;
        client.admin()
                }
import org.opensearch.transport.client.Client;
        String explanation = "";
        lastRunTimeMillis.getAndUpdate(l -> Math.max(l, currentTimeMillisSupplier.getAsLong()));
import java.util.Spliterators;
import org.opensearch.cluster.DiskUsage;
                            diskThresholdSettings.getRerouteInterval()
                            diskThresholdSettings.describeLowThreshold(),
        }
        } else {
                    String indexName = routing.index().getName();
import org.opensearch.common.settings.Settings;
            .filter(index -> indicesToBlockRead.contains(index) == false)
                            diskThresholdSettings.describeHighThreshold(),
import org.opensearch.cluster.routing.allocation.decider.DiskThresholdDecider;
                        String indexName = routing.index().getName();
            }
                        usageIncludingRelocations = diskUsage;
            setLastRunTimeMillis();
            );
import java.util.stream.StreamSupport;
import java.util.function.Supplier;
                AggregateFileCacheStats aggregateFileCacheStats = info.getNodeFileCacheStats().getOrDefault(usage.getNodeId(), null);
            return;
                    + "Number of nodes above high watermark: {}.",
                        );
                        "low disk watermark [{}] exceeded on {}, replicas will not be assigned to this node",
                    }
        } else if (state.getBlocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id())
        logger.trace("marking indices as read-only: [{}]", indicesToMarkReadOnly);
        final long currentTimeMillis = currentTimeMillisSupplier.getAsLong();
                    for (ShardRouting routing : routingNode) {
            .map(Map.Entry::getKey)
            return Set.of();
            } else {
        if (usages == null) {
        });
                        String indexName = routing.index().getName();
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        RoutingNodes routingNodes,
 *
     * The IDs of the nodes that were over the high threshold in the last check (and maybe over another threshold too). Tracked so that we
        this.diskThresholdSettings = new DiskThresholdSettings(settings, clusterSettings);
            logger.debug(new ParameterizedMessage("setting indices [{}] read block failed", readBlock), e);
 * @opensearch.internal
                logger.debug("reroute failed", e);
                            -relocatingShardsSize
        logger.trace("Applying read block on indices: [{}]", indicesToApplyReadBlock);
                            "high disk watermark [{}] exceeded on {}, shards will be relocated away from this node; "
            logger.trace("no auto-release required");
                    && fileCacheEvaluator.isNodeExceedingIndexingThreshold(aggregateFileCacheStats)) {
                nodesOverHighThresholdAndRelocating.remove(node);
        ClusterState state,
                        for (ShardRouting routing : routingNode) {
                    final long relocatingShardsSize;
                    diskThresholdSettings.describeFloodStageThreshold(),
public class DiskThresholdMonitor {
                if (routingNode != null) { // might be temporarily null if the ClusterInfoService and the ClusterService are out of step
            // Only for Dedicated Warm Nodes
        }
            logger.trace("skipping monitor as no disk usage information is available");
        // When auto-release is disabled, still release indices matching exclude patterns
                    final DiskUsage usageIncludingRelocations;
                    logger.debug(
        ActionListener<Void> wrappedListener = ActionListener.wrap(r -> {
            if (nodeDiskEvaluator.isNodeExceedingFloodStageWatermark(usage)) {
        Set<String> indicesToMarkIneligibleForAutoRelease
            setIndexCreateBlock(listener, true);
            listener.onFailure(e);
            if (nodeDiskEvaluator.isNodeExceedingHighWatermark(usage)) {
                    }
                if (nodesOverLowThreshold.contains(node)) {
    private void checkFinished() {
        RoutingNodes routingNodes = state.getRoutingNodes();
                            diskThresholdSettings.describeHighThreshold(),
            reroutedClusterState.metadata(),
                        indicesToMarkReadOnly.add(indexName);
        if ((state.getBlocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()) == false)
            DiskUsage usage = entry.getValue();
                    logger.info(
                setLastRunTimeMillis();
            .setSettings(readOnlySettings)
                        nodesOverHighThresholdAndRelocating.remove(diskUsage.getNodeId());
            logger.debug("rerouting shards: [{}]", explanation);
                        logger.warn(
            listener.onResponse(null);
        }
        final boolean checkFinished = checkInProgress.compareAndSet(true, false);
        final Set<String> indicesToReleaseReadBlock = resolveIndicesToReleaseReadBlock(state, indicesToBlockRead);
                            diskThresholdSettings.describeHighThreshold(),
                    );
            listener.onResponse(r);
            ? Settings.builder().put(Metadata.SETTING_CREATE_INDEX_BLOCK_SETTING.getKey(), Boolean.TRUE.toString()).build()
            logger.debug(new ParameterizedMessage("setting indices [{}] read-only failed", readOnly), e);
        this.client = client;
    }
            checkFinished();
            }
    private final NodeDiskEvaluator nodeDiskEvaluator;
                usage.getNodeId(),
                    explanation = "high disk watermark exceeded on one or more nodes";
 * compatible open source license.
        if (checkInProgress.compareAndSet(false, true) == false) {
                    boolean isNodeWarm = REMOTE_CAPABLE.equals(getNodePool(routingNode));
                    // The node has previously been over the low watermark, but is no longer, so it may be possible to allocate more
                }
        Set<String> indicesNotToAutoRelease = new HashSet<>();
            if (nodeDiskEvaluator.isNodeExceedingHighWatermark(usageWithReservedSpace)) {
            } else if (nodeDiskEvaluator.isNodeExceedingLowWatermark(usage)) {
            return;
            : Settings.builder().putNull(IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE).build();
    private void handleReadOnlyBlocks(
                        + "Number of nodes above high watermark: {}. Total numbers of nodes: {}.",
                        logger.debug(
        return DiskThresholdDecider.sizeOfRelocatingShards(
        Supplier<Double> dataToFileCacheSizeRatioSupplier
        }
     * and exclude patterns configuration.
            ? Settings.builder().put(IndexMetadata.SETTING_BLOCKS_READ, Boolean.TRUE.toString()).build()
            .prepareUpdateSettings(indicesToUpdate.toArray(Strings.EMPTY_ARRAY))
            .execute(ActionListener.map(wrappedListener, r -> null));
                    nodeDiskEvaluator.setNodeType(isNodeWarm);
                nodesOverHighThresholdAndRelocating.remove(node);
    private final DiskThresholdSettings diskThresholdSettings;
                        nodesOverLowThreshold.remove(node);
                for (DiskUsage diskUsage : usagesOverHighThreshold) {
                );
 *
        }
        final Map<String, DiskUsage> usages = info.getNodeLeastAvailableDiskUsages();
                listener.onResponse(null);
                                + "currently relocating away shards totalling [{}] bytes",
            } else {
            .map(Map.Entry::getKey)
    ) {
        ActionListener<Void> wrappedListener = ActionListener.wrap(r -> {
            reroutedClusterState.routingTable()
                    logger.warn(
}
                nodesOverHighThreshold.size()
                            "{} has gone below a disk threshold, but an automatic reroute has occurred "
     * under the high threshold again. Tracked so that we can log when such nodes are no longer in this state.
                    );
                            -relocatingShardsSize
            .collect(Collectors.toSet());
        Set<String> indicesNotToAutoRelease,
            .cluster()
            listener.onResponse(null);
                    }
        }
                } else {
        Supplier<ClusterState> clusterStateSupplier,
    private final RerouteService rerouteService;
    private final FileCacheThresholdSettings fileCacheThresholdSettings;
        ClusterSettings clusterSettings,
                        "high disk watermark [{}] no longer exceeded on {}, but low disk watermark [{}] is still exceeded",
 */
            }, e -> {
/*
                        logger.info(
                        explanation = "one or more nodes has gone under the high or low watermark";
            listener.onFailure(e);
            && !nodes.isEmpty()
        final Set<String> indicesToAutoRelease = StreamSupport.stream(
            rerouteService.reroute("disk threshold monitor", Priority.HIGH, ActionListener.wrap(reroutedClusterState -> {
import org.opensearch.common.util.set.Sets;
            .execute(ActionListener.map(wrappedListener, r -> null));
            Spliterators.spliterator(state.routingTable().indicesRouting().entrySet(), 0),
                        );
                            String indexName = routing.index().getName();
 * SPDX-License-Identifier: Apache-2.0
        final List<DiskUsage> usagesOverHighThreshold = new ArrayList<>();
            .setPersistentSettings(indexCreateBlockSetting)
        if (reroute) {
    private static final Logger logger = LogManager.getLogger(DiskThresholdMonitor.class);
    }
            .filter(index -> state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_BLOCK))
        }, e -> {
    }
            }
    private void handleReadBlocks(ClusterState state, Set<String> indicesToBlockRead, ActionListener<Void> listener) {
            logger.warn(
                }
        for (RoutingNode routingNode : routingNodes) {
 * not use this file except in compliance with the License.
    public void onNewInfo(ClusterInfo info) {
import java.util.ArrayList;
                    reroute = true;
                                + "disk watermark when these relocations are complete",
     */
            .collect(Collectors.toSet());
                            indicesToMarkReadOnly.add(indexName);
            listener.onResponse(null);
    ) {
    /**
            listener.onResponse(r);
            final String node = entry.getKey();
                            "high disk watermark [{}] exceeded on {}, shards will be relocated away from this node; "
            routingNode,
        }, e -> {
                    usagesOverHighThreshold.add(usage);
    private final Set<String> nodesOverHighThreshold = Sets.newConcurrentHashSet();
            .collect(Collectors.toSet());
                listener.onFailure(e);
    /**
        logger.trace("checkFinished");
                        indicesToMarkReadOnly.add(indexName);
     * can log when such nodes are no longer over the low threshold.
                        node,
    }
            }
            setLastRunTimeMillis();
                logger.warn(
    private void handleClusterCreateIndexBlocks(ClusterState state, Set<String> nodes, ActionListener<Void> listener) {
                    logger.info(
package org.opensearch.cluster.routing.allocation;
        final Set<String> indicesToBlockRead = new HashSet<>();
                    if (lastRunTimeMillis.get() <= currentTimeMillis - diskThresholdSettings.getRerouteInterval().millis()) {
        if (indicesToReleaseReadBlock.isEmpty() == false) {
                        indicesNotToAutoRelease.add(indexName);
import org.opensearch.cluster.routing.RoutingNode;
    private final Set<String> nodesOverHighThresholdAndRelocating = Sets.newConcurrentHashSet();
     */
 * reroute if it does. Also responsible for logging about nodes that have
                                + "currently relocating away shards totalling [{}] bytes; the node is expected to continue to exceed "
            .indices()
                    } else {
     */
    // exposed for tests to override
 * software distributed under the License is distributed on an
        cleanUpRemovedNodes(nodes, nodesOverLowThreshold);
        }
    }
        final Set<String> indicesToApplyReadBlock = indicesToBlockRead.stream()
        markNodesMissingUsageIneligibleForRelease(routingNodes, usages, indicesNotToAutoRelease);
 */
            listener.onFailure(e);
    ) {
                nodesToCleanUp.remove(node);
                .collect(Collectors.toSet());
        this.nodeDiskEvaluator = new NodeDiskEvaluator(diskThresholdSettings, dataToFileCacheSizeRatioSupplier);
        Settings readOnlySettings = readOnly
        // all ClusterInfo updates are processed and never ignored
 * passed the disk watermarks
            updateIndicesReadOnly(indicesToMarkReadOnly, listener, true);
            .filter(index -> Regex.simpleMatch(excludePatterns, index))
        client.admin()
            }
                nodesOverLowThreshold.add(node);
            final DiskUsage usageWithReservedSpace = new DiskUsage(
            && nodesOverHighThreshold.size() < nodes.size()) {
        } else {
                continue;
            setLastRunTimeMillis();
import org.opensearch.core.action.ActionListener;
import static org.opensearch.cluster.routing.RoutingPool.getNodePool;
                    final RoutingNode routingNode = reroutedClusterState.getRoutingNodes().node(diskUsage.getNodeId());
import org.opensearch.cluster.routing.RoutingNodes;
 *     http://www.apache.org/licenses/LICENSE-2.0
        final ActionListener<Void> wrappedListener = ActionListener.wrap(r -> {
                final boolean wasOverHighThreshold = nodesOverHighThreshold.remove(node);
                            diskUsage.getTotalBytes(),
    private final Client client;
                setIndexCreateBlock(listener, false);
            if (nodesToKeep.contains(node) == false) {
import org.opensearch.action.support.GroupedActionListener;
            info,
        logger.trace("processing new cluster info");
                            usage
            if (isWarmNode) {
                nodesOverHighThreshold.add(node);
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
                        indicesNotToAutoRelease.add(indexName);
                logger.warn(
            }
        for (final Map.Entry<String, DiskUsage> entry : usages.entrySet()) {
        if (diskThresholdSettings.isIndexReadBlockAutoReleaseEnabled()) {
    }
                        logger.info(
        final ClusterState state = clusterStateSupplier.get();
                            "index file cache threshold [{}] exceeded on {}, indices on this node are marked read only.",
                listener.onResponse(null);
        final ActionListener<Void> listener = new GroupedActionListener<>(ActionListener.wrap(this::checkFinished), 6);
 * The OpenSearch Contributors require contributions made to
import org.opensearch.common.regex.Regex;
 * this work for additional information regarding copyright
                    // will log about this node when the reroute completes
 * Modifications Copyright OpenSearch Contributors. See
 */
                                + "the high disk watermark when these relocations are complete",
        // If all the nodes are breaching high disk watermark, we apply index create block to avoid red clusters.
        this.fileCacheThresholdSettings = new FileCacheThresholdSettings(settings, clusterSettings);
        handleReadOnlyBlocks(state, indicesToMarkReadOnly, indicesNotToAutoRelease, listener);
            .filter(index -> !state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_BLOCK))
                                + "currently relocating away shards totalling [{}] bytes; the node is expected to be below the high "
                setLastRunTimeMillis();
                            indicesNotToAutoRelease.add(indexName);
import org.apache.logging.log4j.message.ParameterizedMessage;
                        }
import org.opensearch.cluster.ClusterState;
        indicesToMarkReadOnly.removeIf(index -> state.getBlocks().indexBlocked(ClusterBlockLevel.WRITE, index));
                        relocatingShardsSize = sizeOfRelocatingShards(routingNode, diskUsage, info, reroutedClusterState);
        Set<String> indicesToMarkReadOnly,
                    }
                if (lastRunTimeMillis.get() <= currentTimeMillis - diskThresholdSettings.getRerouteInterval().millis()) {
        // set read-only block but don't block on the response
            .prepareUpdateSettings()
 * under the License.
        }
            : Settings.builder().putNull(Metadata.SETTING_CREATE_INDEX_BLOCK_SETTING.getKey()).build();
                            usage
            setLastRunTimeMillis();
                final boolean wasUnderLowThreshold = nodesOverLowThreshold.add(node);
            : Settings.builder().putNull(IndexMetadata.SETTING_BLOCKS_READ).build();
                            diskUsage.getPath(),
 */
        });
                    if (nodeDiskEvaluator.isNodeExceedingHighWatermark(usageIncludingRelocations)) {
            updateIndicesReadOnly(indicesToAutoRelease, listener, false);
                    for (ShardRouting routing : routingNode) {
                        usageIncludingRelocations = new DiskUsage(
                    }
                if (routingNode != null) { // might be temporarily null if the ClusterInfoService and the ClusterService are out of step
 * You may obtain a copy of the License at
            setLastRunTimeMillis();
        // TODO find a better way to limit concurrent updates (and potential associated reroutes) while allowing tests to ensure that
    private void setLastRunTimeMillis() {
                    );
        handleReadBlocks(state, indicesToBlockRead, listener);
        // set read block but don't block on the response
 * this file be licensed under the Apache-2.0 license or a
import java.util.HashSet;
            logger.trace("no reroute required");
        for (String node : nodesToCleanUp) {
                            "high disk watermark [{}] exceeded on {}, shards will be relocated away from this node; "
                        "high disk watermark exceeded on {} but an automatic reroute has occurred " + "in the last [{}], skipping reroute",
                        diskThresholdSettings.describeLowThreshold(),
        final Set<String> indicesToMarkReadOnly = new HashSet<>();
        } else {
            setLastRunTimeMillis();
/*
/*
        if (indicesToApplyReadBlock.isEmpty() == false) {
    private final Set<String> nodesOverLowThreshold = Sets.newConcurrentHashSet();
    }
            updateIndicesReadBlock(indicesToApplyReadBlock, listener, true);
                    // if we reroute now.
        }
import org.opensearch.cluster.routing.RerouteService;
            }));
    private final Supplier<ClusterState> clusterStateSupplier;
                } else if (aggregateFileCacheStats != null
            listener.onResponse(null);
            ? Settings.builder().put(IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE, Boolean.TRUE.toString()).build()
        } else {
            true,
        }
                .filter(index -> state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_BLOCK))
    public DiskThresholdMonitor(
                        diskThresholdSettings.describeHighThreshold(),
        cleanUpRemovedNodes(nodes, nodesOverHighThreshold);
                        logger.warn(
                    } else {
        Settings settings,
                                + "in the last [{}], skipping reroute",
                    }
        final Settings indexCreateBlockSetting = indexCreateBlock
                    usage
                    nodesOverHighThreshold.size(),
            && diskThresholdSettings.isCreateIndexBlockAutoReleaseEnabled()
                            "low disk watermark [{}] no longer exceeded on {}",
 * GitHub history for details.
 * Listens for a node to go over the high watermark and kicks off an empty
                        reroute = true;
            }
            final long reservedSpace = info.getReservedSpace(usage.getNodeId(), usage.getPath()).getTotal();
        });
        if (excludePatterns.isEmpty()) {
        boolean reroute = false;
                nodesOverHighThresholdAndRelocating.remove(node);
     * The IDs of the nodes that were over the high threshold in the last check, but which are relocating shards that will bring them
                        );
            logger.info("skipping monitor as a check is already in progress");
                    );
 *
                            node,
                .filter(index -> indicesToBlockRead.contains(index) == false)
        return StreamSupport.stream(Spliterators.spliterator(state.routingTable().indicesRouting().entrySet(), 0), false)
     * The IDs of the nodes that were over the low threshold in the last check (and maybe over another threshold too). Tracked so that we
        }
                if (aggregateFileCacheStats != null && fileCacheEvaluator.isNodeExceedingSearchThreshold(aggregateFileCacheStats)) {
                        indicesToBlockRead.add(indexName);
import java.util.concurrent.atomic.AtomicLong;
                    for (ShardRouting routing : routingNode) {
                            -relocatingShardsSize
    long sizeOfRelocatingShards(RoutingNode routingNode, DiskUsage diskUsage, ClusterInfo info, ClusterState reroutedClusterState) {
import org.opensearch.common.settings.ClusterSettings;
                            diskUsage,
                continue;
            );
        this.clusterStateSupplier = clusterStateSupplier;
                        indicesNotToAutoRelease.add(indexName);
 * specific language governing permissions and limitations
                    // shards
 * the Apache License, Version 2.0 (the "License"); you may
            .setSettings(readBlockSettings)
import org.apache.logging.log4j.LogManager;
                        relocatingShardsSize = 0L;
                "Putting index create block on cluster as all nodes are breaching high disk watermark. "
            .prepareUpdateSettings(indicesToUpdate.toArray(Strings.EMPTY_ARRAY))
                }
            logger.trace("no auto-release required");
        Settings readBlockSettings = readBlock
import java.util.concurrent.atomic.AtomicBoolean;
                usage.getPath(),
        List<String> excludePatterns = diskThresholdSettings.getIndexReadBlockAutoReleaseExcludePatterns();
    private final AtomicLong lastRunTimeMillis = new AtomicLong(Long.MIN_VALUE);
            if (routingNode == null) {
    /**
                        logger.debug(
import java.util.Map;
            .filter(index -> state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK))
                        );
            return StreamSupport.stream(Spliterators.spliterator(state.routingTable().indicesRouting().entrySet(), 0), false)
                .map(Map.Entry::getKey)
            && nodesOverHighThreshold.size() == nodes.size()) {
            diskUsage.getPath(),
                    "flood stage disk watermark [{}] exceeded on {}, all indices on this node will be marked read-only",
 * Licensed to Elasticsearch under one or more contributor
                }
 * license agreements. See the NOTICE file distributed with
        ActionListener<Void> listener
                        "search file cache threshold [{}] exceeded on {}, read block applied on indices on this node",
                    }
            .filter(index -> indicesNotToAutoRelease.contains(index) == false)
            false
                        String indexName = routing.index().getName();
                usage.getNodeName(),
    protected void setIndexCreateBlock(final ActionListener<Void> listener, boolean indexCreateBlock) {
     */
        } else {
