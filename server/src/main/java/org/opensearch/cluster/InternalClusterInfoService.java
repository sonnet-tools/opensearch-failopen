                        nodeId,
        clusterSettings.addSettingsUpdateConsumer(INTERNAL_CLUSTER_INFO_UPDATE_INTERVAL_SETTING, this::setUpdateFrequency);
    private class RefreshAndRescheduleRunnable extends RefreshRunnable {
        this.indicesStatsSummary = IndicesStatsSummary.EMPTY;
import org.apache.logging.log4j.LogManager;
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        @Override
        if (enabled == false) {
                }
                    }
                        )
            if (storeStats == null) {
                } else {
        // Clean up info for any removed nodes
import java.util.concurrent.TimeUnit;
        this.enabled = enabled;
                reservedSpaceBuilders.forEach((nodeAndPath, builder) -> rsrvdSpace.put(nodeAndPath, builder.build()));
                super.doRun();
                        }
    private final List<Consumer<ClusterInfo>> listeners = new CopyOnWriteArrayList<>();
    private volatile Map<String, DiskUsage> leastAvailableSpaceUsages;
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
        final Map<String, DiskUsage> newMostAvailableUsages
                } else {
     */
            this.shardSizes = shardSizes;
                        new DiskUsage(
            indicesStatsSummary.reservedSpace,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Setting;
        return new ClusterInfo(
     *
                        .filter(nodeStats -> nodeStats.getNode().isWarmNode())
        });
                    leastAvailableUsagesBuilder,
                );
                }
                logger.trace("refreshing cluster info [{}]", reason);
                executeRefresh(event.state(), "data node added");
            }
                if (e instanceof ReceiveTimeoutTransportException) {
            }
                if (nodeResourceUsageStats.containsKey(removedNode.getId())) {
            }
 * the Apache License, Version 2.0 (the "License"); you may
        final IndicesStatsRequest indicesStatsRequest = new IndicesStatsRequest();
        listeners.add(clusterInfoConsumer);
            public void onResponse(IndicesStatsResponse indicesStatsResponse) {
import org.apache.logging.log4j.Logger;
                    adjustNodesStats(nodesStatsResponse.getNodes()).stream()
 * ClusterInfoUpdateJob if a node has been added.
        this.leastAvailableSpaceUsages = Map.of();
        final Map<ShardRouting, String> newShardRoutingToDataPath,
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
    /**
            }
                        if (logger.isTraceEnabled()) {
                        mostAvailablePath = info;
     */
    }
    }
                NodesResourceUsageStats nodesResourceUsageStats = null;
            }
    );
            public void onFailure(Exception e) {
        }
    }
 */
                            mostAvailablePath.getTotal().getBytes()
        ClusterInfo clusterInfo = getClusterInfo();
            final RefreshAndRescheduleRunnable newRunnable = new RefreshAndRescheduleRunnable();
                    indicesStatsSummary = IndicesStatsSummary.EMPTY;
 * Licensed to Elasticsearch under one or more contributor
        List<NodeStats> nodeStatsArray,
                    if (leastAvailablePath == null) {
            return;
 * GitHub history for details.
            } else {
        public void onRejection(Exception e) {
        protected void doRun() {
                    } else {
    private void setEnabled(boolean enabled) {
import org.opensearch.index.store.StoreStats;
    @Override
            final Map<String, Long> shardSizes,
    public void clusterChanged(ClusterChangedEvent event) {
     * @opensearch.internal
        client.admin().indices().stats(indicesStatsRequest, new LatchedActionListener<>(listener, latch));
            this.reservedSpace = reservedSpace;
        @Override
                );
        final Map<String, Long> shardSizes;
        if (clusterState.nodes().getDataNodes().size() > 1) {
            @Override
            Thread.currentThread().interrupt(); // restore interrupt status
            }
        IndicesStatsSummary(
import java.util.concurrent.CopyOnWriteArrayList;
                final Map<ShardRouting, String> dataPathByShardRoutingBuilder = new HashMap<>();
 * routinely updated on a timer. The timer can be dynamically changed by
                            logger.trace("Failed to execute IndicesStatsAction for ClusterInfoUpdateJob", e);
            if (enabled) {
    public final ClusterInfo refresh() {
                if (e instanceof ReceiveTimeoutTransportException) {
                        assert mostAvailablePath == null;
     * Retrieve the latest nodes stats, calling the listener when complete
}
                logger.trace("Removing node from cluster info: {}", removedNode.getId());
        final CountDownLatch indicesLatch = updateIndicesStats(new ActionListener<>() {
                    logger.debug("No resource usage stats available for node: {}", nodeStats.getNode().getName());
        Property.Dynamic,
                    } else if (mostAvailablePath.getAvailable().getBytes() < info.getAvailable().getBytes()) {
import org.opensearch.action.LatchedActionListener;
    protected CountDownLatch updateNodeStats(final ActionListener<NodesStatsResponse> listener) {
                } else {
    // null if this node is not currently the cluster-manager
                final Map<String, DiskUsage> leastAvailableUsagesBuilder = new HashMap<>();
                Map<String, NodeResourceUsageStats> nodeResourceUsageStatsMap = nodesResourceUsageStats.getNodeIdToResourceUsageStatsMap();
            if (indicesLatch.await(fetchTimeout.getMillis(), TimeUnit.MILLISECONDS) == false) {
        this.updateFrequency = INTERNAL_CLUSTER_INFO_UPDATE_INTERVAL_SETTING.get(settings);
    }
        Logger logger,
 */
     * Retrieve the latest indices stats, calling the listener when complete
    public static final Setting<TimeValue> INTERNAL_CLUSTER_INFO_TIMEOUT_SETTING = Setting.positiveTimeSetting(
        }
import java.util.Map;
                    );
    }
 * Listens for changes in the number of data nodes and immediately submits a
 * @opensearch.internal
import org.opensearch.common.settings.Setting.Property;
    private static final String REFRESH_EXECUTOR = ThreadPool.Names.MANAGEMENT;
                } else {
        this.nodeFileCacheStats = Map.of();
        logger.trace("refreshing cluster info");
        this.enabled = DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.get(settings);
        protected void doRun() {
        if (event.localNodeClusterManager() && refreshAndRescheduleRunnable.get() == null) {
import java.util.stream.Collectors;
import java.util.concurrent.CountDownLatch;
     * Runs {@link InternalClusterInfoService#refresh()}, logging failures/rejections appropriately.
            this::setEnabled
    public void addListener(Consumer<ClusterInfo> clusterInfoConsumer) {
                }
    private static class IndicesStatsSummary {
    public InternalClusterInfoService(Settings settings, ClusterService clusterService, ThreadPool threadPool, Client client) {
    static void fillNodeResourceUsageStatsPerNode(
    protected CountDownLatch updateIndicesStats(final ActionListener<IndicesStatsResponse> listener) {
import org.opensearch.node.NodesResourceUsageStats;
    private volatile Map<String, NodeResourceUsageStats> nodeResourceUsageStats;
                    if (e instanceof ClusterBlockException) {
import org.opensearch.cluster.service.ClusterService;
 *     http://www.apache.org/licenses/LICENSE-2.0
public class InternalClusterInfoService implements ClusterInfoService, ClusterStateListener {
            }
        this.nodeResourceUsageStats = Map.of();
    @Override
            } else {
        }
                    Map<String, NodeResourceUsageStats> newNodeResourceUsageStats = new HashMap<>(nodeResourceUsageStats);
            }
        public void onFailure(Exception e) {
                    }
                            logger.trace("Failed to execute NodeStatsAction for ClusterInfoUpdateJob", e);
            this.reason = reason;
            if (nodeStats.getResourceUsageStats() == null) {
import org.opensearch.cluster.routing.ShardRouting;
        for (DiscoveryNode addedNode : event.nodesDelta().addedNodes()) {
    private void executeRefresh(ClusterState clusterState, String reason) {
            }
     */
                FsInfo.Path mostAvailablePath = null;
                String nodeId = nodeStats.getNode().getId();
 * specific language governing permissions and limitations
/*
    private volatile TimeValue updateFrequency;
    static void fillDiskUsagePerNode(
                            leastAvailablePath.getAvailable().getBytes()
                    mostAvailableSpaceUsages = Map.of();
                    nodeResourceUsageStats = Map.of();
    public ClusterInfo getClusterInfo() {
            }
        client.admin().cluster().nodesStats(nodesStatsRequest, new LatchedActionListener<>(listener, latch));
                fillNodeResourceUsageStatsPerNode(logger, adjustNodesStats(nodesStatsResponse.getNodes()), nodeResourceUsageStatsBuilder);
                            nodeId,
            nodeResourceUsageStats
     * @return a latch that can be used to wait for the indices stats to complete if desired
 * <p>
        ShardStats[] stats,
        try {
    }
    }
                listener.accept(clusterInfo);
            final Map<ClusterInfo.NodeAndPath, ClusterInfo.ReservedSpace> reservedSpace
 * this work for additional information regarding copyright
        @Override
package org.opensearch.cluster;
import java.util.List;
    ) {
                            nodeId,
import org.opensearch.common.settings.ClusterSettings;
                logger.trace("cluster-manager changed, scheduled refresh job is stale");
        }
                    if (logger.isTraceEnabled()) {
                    new ClusterInfo.NodeAndPath(shardRouting.currentNodeId(), s.getDataPath()),
    }
            leastAvailableSpaceUsages,
        TimeValue.timeValueSeconds(15),
        for (NodeStats nodeStats : nodeStatsArray) {
        final Map<String, NodeResourceUsageStats> newNodeResourceUsageStats
                            mostAvailablePath.getTotal().getBytes(),
            refreshAndRescheduleRunnable.set(null);
                }
                if (leastAvailableSpaceUsages.containsKey(removedNode.getId())) {
        indicesStatsRequest.clear();
 * Modifications Copyright OpenSearch Contributors. See
    /**
            nodeFileCacheStats,
                );
                        logger.warn("Failed to execute NodeStatsAction for ClusterInfoUpdateJob", e);
        }
                }
    }
 */
            @Override
            final StoreStats storeStats = s.getStats().getStore();
                final Map<ClusterInfo.NodeAndPath, ClusterInfo.ReservedSpace.Builder> reservedSpaceBuilders = new HashMap<>();
                refresh();
                    if (logger.isTraceEnabled()) {
        }
        indicesStatsRequest.indicesOptions(IndicesOptions.STRICT_EXPAND_OPEN_CLOSED_HIDDEN);
     * Indices statistics summary.
                        logger.trace(
            public void onFailure(Exception e) {
                }
 * Unless required by applicable law or agreed to in writing,
                        leastAvailablePath = info;
                    // we empty the usages list, to be safe - we don't know what's going on.
 * The OpenSearch Contributors require contributions made to
                    Map<String, DiskUsage> newMinUsages = new HashMap<>(mostAvailableSpaceUsages);
/*
            }
            if (nodeLatch.await(fetchTimeout.getMillis(), TimeUnit.MILLISECONDS) == false) {
        final CountDownLatch latch = new CountDownLatch(1);
     */
            if (reserved != StoreStats.UNKNOWN_RESERVED_BYTES) {
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        nodesStatsRequest.timeout(fetchTimeout);
            public void onResponse(NodesStatsResponse nodesStatsResponse) {
                logger.warn("Failed to update shard information for ClusterInfoUpdateJob within {} timeout", fetchTimeout);
        }
import org.opensearch.transport.ReceiveTimeoutTransportException;
     */
                break;
    );
    ) {
 * InternalClusterInfoService provides the ClusterInfoService interface,
        ) {
                    newNodeResourceUsageStats.put(nodeId, nodeResourceUsageStatsMap.get(nodeId));
    /**
            if (this == refreshAndRescheduleRunnable.get()) {
        TimeValue.timeValueSeconds(30),
     * @return a latch that can be used to wait for the nodes stats to complete if desired
                        }
                logger.warn("Unable to retrieve node Resource Usage stats for {}", nodeStats.getNode().getName());
import java.util.HashMap;
            }
                } else {
                        if (logger.isTraceEnabled()) {
                    } else if (leastAvailablePath.getAvailable().getBytes() > info.getAvailable().getBytes()) {
                        logger.trace(
        return nodeStats;
                            nodeId,
                indicesStatsSummary = new IndicesStatsSummary(shardSizeByIdentifierBuilder, dataPathByShardRoutingBuilder, rsrvdSpace);
                            nodeName,
        try {
import org.opensearch.common.util.concurrent.AbstractRunnable;
/**
                final Map<String, NodeResourceUsageStats> nodeResourceUsageStatsBuilder = new HashMap<>();
        }
                    logger.error("NodeStatsAction timed out for ClusterInfoUpdateJob", e);
            @Override
            }
                    } else {
                    }
                logger.trace("notifying [{}] of new cluster info", listener);
                        leastAvailablePath.getAvailable()
                    nodeResourceUsageStats = Collections.unmodifiableMap(newNodeResourceUsageStats);
    private volatile IndicesStatsSummary indicesStatsSummary;
 *
import org.apache.logging.log4j.message.ParameterizedMessage;
                }
/*
                final Map<ClusterInfo.NodeAndPath, ClusterInfo.ReservedSpace> rsrvdSpace = new HashMap<>();
                if (mostAvailablePath.getTotal().getBytes() < 0) {
                    logger.error("IndicesStatsAction timed out for ClusterInfoUpdateJob", e);
                    newMostAvailableUsages.put(
        this.client = client;
            indicesStatsSummary.shardRoutingToDataPath,
    }
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        clusterSettings.addSettingsUpdateConsumer(INTERNAL_CLUSTER_INFO_TIMEOUT_SETTING, this::setFetchTimeout);
    private volatile Map<String, AggregateFileCacheStats> nodeFileCacheStats;
                        nodeId,
        assert anyListeners : "expected to notify at least one listener";
                    logger.trace(
import org.opensearch.common.unit.TimeValue;
                    }
        } else if (event.localNodeClusterManager() == false) {
            }
        TimeValue.timeValueSeconds(10),
        nodesStatsRequest.addMetric(NodesStatsRequest.Metric.FILE_CACHE_STATS.metricName());
            indicesStatsSummary.shardSizes,
            newShardRoutingToDataPath.put(shardRouting, s.getDataPath());
        final Map<ClusterInfo.NodeAndPath, ClusterInfo.ReservedSpace> reservedSpace;
                        new DiskUsage(
    /**
                nodesResourceUsageStats = nodeStats.getResourceUsageStats();
 * setting the <code>cluster.info.update.interval</code> setting (defaulting
 * shard sizes across the cluster.
                logger.trace("skipping cluster info refresh [{}] since it is disabled", reason);
    private final Client client;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        return latch;
            try {
                    if (e instanceof ClusterBlockException) {
    }
                    Map<String, DiskUsage> newMaxUsages = new HashMap<>(leastAvailableSpaceUsages);
                        "node: [{}], most available: total disk: {},"
        final Map<ShardRouting, String> shardRoutingToDataPath;
                            "node: [{}] least available path has less than 0 total bytes of disk [{}], skipping",
    }
        Property.NodeScope
            DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING,
                        logger.warn("Failed to execute IndicesStatsAction for ClusterInfoUpdateJob", e);
import org.opensearch.cluster.node.DiscoveryNode;
            }
        final CountDownLatch nodeLatch = updateNodeStats(new ActionListener<NodesStatsResponse>() {
        }
 * under the License.
import org.opensearch.node.NodeResourceUsageStats;
                    mostAvailableUsagesBuilder
                    newLeastAvailableUsages.put(
        return latch;
                            nodeName,
            } catch (Exception e) {
            anyListeners = true;
        return clusterInfo;
                    t -> new ClusterInfo.ReservedSpace.Builder()
                String nodeName = nodeStats.getNode().getName();
        }
        } catch (InterruptedException e) {
                            nodeId,
 *
 * software distributed under the License is distributed on an
    }
                            mostAvailablePath.getAvailable().getBytes()
     */
        @Override
                        mostAvailablePath = leastAvailablePath = info;
            logger.trace("elected as cluster-manager, scheduling cluster info update tasks");
     * Runs {@link InternalClusterInfoService#refresh()}, logging failures/rejections appropriately, and reschedules itself on completion.
                leastAvailableSpaceUsages = Collections.unmodifiableMap(leastAvailableUsagesBuilder);
        } catch (InterruptedException e) {
                            + " available disk: {} / least available: total disk: {}, available disk: {}",
                        );
 * You may obtain a copy of the License at
            executeRefresh(event.state(), "became cluster-manager");
                    );
                final Map<String, Long> shardSizeByIdentifierBuilder = new HashMap<>();
     * @opensearch.internal
        );
        Logger logger,
 * SPDX-License-Identifier: Apache-2.0
            refreshAndRescheduleRunnable.set(newRunnable);
        for (ShardStats s : stats) {
                continue;
        this.mostAvailableSpaceUsages = Map.of();
            } else {
        );
        Logger logger,
                for (FsInfo.Path info : nodeStats.getFs()) {
        final NodesStatsRequest nodesStatsRequest = new NodesStatsRequest("data:true");
        nodesStatsRequest.addMetric(NodesStatsRequest.Metric.RESOURCE_USAGE_STATS.metricName());
            threadPool.scheduleUnlessShuttingDown(updateFrequency, REFRESH_EXECUTOR, newRunnable);
    }
    }
            threadPool.executor(REFRESH_EXECUTOR).execute(new RefreshRunnable(reason));
            final String shardIdentifier = ClusterInfo.shardIdentifierFromRouting(shardRouting);
import org.opensearch.action.support.IndicesOptions;
                logger.warn("Unable to retrieve node FS stats for {}", nodeStats.getNode().getName());
        }
import org.opensearch.monitor.fs.FsInfo;
    private class RefreshRunnable extends AbstractRunnable {
    // allow tests to adjust the node stats on receipt
                    leastAvailableSpaceUsages = Collections.unmodifiableMap(newMaxUsages);
                    // we empty the usages list, to be safe - we don't know what's going on.
            shardSizes.put(shardIdentifier, size);
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
        this.fetchTimeout = fetchTimeout;
        }
                nodeFileCacheStats = Collections.unmodifiableMap(
                final ShardStats[] stats = indicesStatsResponse.getShards();
                    }
        }
import org.opensearch.cluster.block.ClusterBlockException;
        final Map<String, DiskUsage> newLeastAvailableUsages,
import org.opensearch.action.admin.indices.stats.ShardStats;
    private final AtomicReference<RefreshAndRescheduleRunnable> refreshAndRescheduleRunnable = new AtomicReference<>();
     *
 *
import java.util.function.Consumer;
    }
        final Map<String, Long> shardSizes,
                            leastAvailablePath.getTotal().getBytes(),
        Property.Dynamic,
                        mostAvailablePath.getAvailable(),
                mostAvailableSpaceUsages = Collections.unmodifiableMap(mostAvailableUsagesBuilder);
import org.apache.logging.log4j.Level;
     * @opensearch.internal
    }
import java.util.Collections;
            }
            logger.trace("refreshing cluster info in background [{}]", reason);
                        leastAvailablePath.getTotal(),
            final long size = storeStats.sizeInBytes();
        "cluster.info.update.interval",
        this.updateFrequency = updateFrequency;
                nodeResourceUsageStats = Collections.unmodifiableMap(nodeResourceUsageStatsBuilder);
                    newNodeResourceUsageStats.remove(removedNode.getId());
     * Refreshes the ClusterInfo in a blocking fashion
                final ClusterInfo.ReservedSpace.Builder reservedSpaceBuilder = reservedSpaceByShard.computeIfAbsent(
            super("scheduled");
                FsInfo.Path leastAvailablePath = null;
        for (final Consumer<ClusterInfo> listener : listeners) {
        @Override
        static final IndicesStatsSummary EMPTY = new IndicesStatsSummary(Map.of(), Map.of(), Map.of());
 * to 30 seconds). The InternalClusterInfoService only runs on the cluster-manager node.
            if (removedNode.isDataNode()) {
                    leastAvailableSpaceUsages = Map.of();
    public static final Setting<TimeValue> INTERNAL_CLUSTER_INFO_UPDATE_INTERVAL_SETTING = Setting.timeSetting(
    private volatile boolean enabled;
                        .collect(Collectors.toMap(nodeStats -> nodeStats.getNode().getId(), NodeStats::getFileCacheStats))
                            mostAvailablePath.getPath(),
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
            if (this == refreshAndRescheduleRunnable.get()) {
                threadPool.scheduleUnlessShuttingDown(updateFrequency, REFRESH_EXECUTOR, this);
    @Override
    /**
            Thread.currentThread().interrupt(); // restore interrupt status
import org.opensearch.common.settings.Settings;
            logger.warn(new ParameterizedMessage("refreshing cluster info failed [{}]", reason), e);
                    );
        RefreshRunnable(String reason) {
 * not use this file except in compliance with the License.
        final Map<ClusterInfo.NodeAndPath, ClusterInfo.ReservedSpace.Builder> reservedSpaceByShard
        nodesStatsRequest.clear();
        final CountDownLatch latch = new CountDownLatch(1);
        }
                if (mostAvailableSpaceUsages.containsKey(removedNode.getId())) {
                    newMaxUsages.remove(removedNode.getId());
import org.opensearch.core.action.ActionListener;
                    logger,
 * compatible open source license.
        indicesStatsRequest.store(true);
        for (NodeStats nodeStats : nodeStatsArray) {
        }
                logger.trace("scheduling next cluster info refresh in [{}]", updateFrequency);
            final boolean shutDown = e instanceof OpenSearchRejectedExecutionException osre && osre.isExecutorShutdown();
            if (addedNode.isDataNode()) {
            } else {
        nodesStatsRequest.addMetric(NodesStatsRequest.Metric.FS.metricName());
                logger.info(new ParameterizedMessage("failed to notify [{}] of new cluster info", listener), e);
        }
                        mostAvailablePath.getTotal(),
        }
 */
            if (nodeStats.getFs() == null) {
        for (DiscoveryNode removedNode : event.nodesDelta().removedNodes()) {
    private volatile TimeValue fetchTimeout;
        final IndicesStatsSummary indicesStatsSummary = this.indicesStatsSummary; // single volatile read
            final ShardRouting shardRouting = s.getShardRouting();
                        );
                String nodeId = nodeStats.getNode().getId();
                            "node: [{}] most available path has less than 0 total bytes of disk [{}], skipping",
 * license agreements. See the NOTICE file distributed with
                }
import java.util.concurrent.atomic.AtomicReference;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
            logger.trace("shard: {} size: {} reserved: {}", shardIdentifier, size, reserved);
                final Map<String, DiskUsage> mostAvailableUsagesBuilder = new HashMap<>();
 * KIND, either express or implied.  See the License for the
                }
        List<NodeStats> nodeStatsArray,
                }
        this.fetchTimeout = INTERNAL_CLUSTER_INFO_TIMEOUT_SETTING.get(settings);
                logger.warn("Failed to update node information for ClusterInfoUpdateJob within {} timeout", fetchTimeout);
                if (leastAvailablePath.getTotal().getBytes() < 0) {
                reservedSpaceBuilder.add(shardRouting.shardId(), reserved);
 * ownership. Elasticsearch licenses this file to you under
    /**
        // Refresh if a data node was added
     *
    static void buildShardLevelInfo(
import org.opensearch.threadpool.ThreadPool;
            this.shardRoutingToDataPath = shardRoutingToDataPath;
        Property.NodeScope
                    mostAvailableSpaceUsages = Collections.unmodifiableMap(newMinUsages);
            final Map<ShardRouting, String> shardRoutingToDataPath,
import org.opensearch.transport.client.Client;
                    newMinUsages.remove(removedNode.getId());
 * Every time the timer runs, gathers information about the disk usage, resource usage(jvm,cpu,i/o stats) and
        RefreshAndRescheduleRunnable() {
    void setUpdateFrequency(TimeValue updateFrequency) {
        }
        }
        });
            logger.log(shutDown ? Level.DEBUG : Level.WARN, "refreshing cluster info rejected [{}]", reason, e);
                            leastAvailablePath.getTotal().getBytes()
            return;
    private void setFetchTimeout(TimeValue fetchTimeout) {
        ClusterSettings clusterSettings = clusterService.getClusterSettings();
                            leastAvailablePath.getPath(),
        boolean anyListeners = false;
                        )
                        nodeId,
        private final String reason;
            mostAvailableSpaceUsages,
    ) {
    private static final Logger logger = LogManager.getLogger(InternalClusterInfoService.class);
    private final ThreadPool threadPool;
                buildShardLevelInfo(logger, stats, shardSizeByIdentifierBuilder, dataPathByShardRoutingBuilder, reservedSpaceBuilders);
                fillDiskUsagePerNode(
        "cluster.info.update.timeout",
                if (nodeResourceUsageStatsMap != null && nodeResourceUsageStatsMap.containsKey(nodeId)) {
 *
        public void onAfter() {
        clusterSettings.addSettingsUpdateConsumer(
    List<NodeStats> adjustNodesStats(List<NodeStats> nodeStats) {
            @Override
                if (logger.isTraceEnabled()) {
            final long reserved = storeStats.getReservedSize().getBytes();
        this.threadPool = threadPool;
                    adjustNodesStats(nodesStatsResponse.getNodes()),
    private volatile Map<String, DiskUsage> mostAvailableSpaceUsages;
