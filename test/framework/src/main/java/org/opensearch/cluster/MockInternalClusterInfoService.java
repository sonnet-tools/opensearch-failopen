    public void setNodeResourceUsageFunctionAndRefresh(Function<String, NodeResourceUsageStats> resourceUsageFunction) {
        SizeFakingClusterInfo(ClusterInfo delegate) {
    private AggregateFileCacheStats aggregateFileCacheStats;
 * specific language governing permissions and limitations
                            .map(fsInfoPath -> diskUsageFunction.apply(discoveryNode, fsInfoPath))
                nodeStats.getHttp(),
    private volatile Function<String, NodeResourceUsageStats> resourceUsageFunction;
                nodeStats.getIndexingPressureStats(),
}
import java.util.List;
        super.setUpdateFrequency(updateFrequency);
/*
 *
    }
                nodeStats.getTimestamp(),
                delegate.reservedSpace,
                delegate.shardSizes,
        }
            return new NodeStats(
    @Nullable // if no fakery should take place
                nodeStats.getSearchPipelineStats(),
        super(settings, clusterService, threadPool, client);
                            .toArray(FsInfo.Path[]::new)
/*
                return super.getShardSize(shardRouting);
import org.opensearch.cluster.routing.ShardRouting;
                this.aggregateFileCacheStats != null ? this.aggregateFileCacheStats : nodeStats.getFileCacheStats(),
    @Nullable // if no fakery should take place
            final Function<ShardRouting, Long> shardSizeFunction = MockInternalClusterInfoService.this.shardSizeFunction;
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
import java.util.stream.Collectors;
                delegate.getNodeLeastAvailableDiskUsages(),
 *
    /** This is a marker plugin used to trigger MockNode to use this mock info service. */
                nodeStats.getAdaptiveSelectionStats(),
    public void setShardSizeFunctionAndRefresh(Function<ShardRouting, Long> shardSizeFunction) {
    }
            );
 */
    @Override
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
    }
    }
                nodeStats.getNodeCacheStats(),
        refresh();
public class MockInternalClusterInfoService extends InternalClusterInfoService {
import org.opensearch.monitor.fs.FsInfo;
    }
                nodeStats.getSegmentReplicationRejectionStats(),
 */
                this.resourceUsageFunction != null
import java.util.stream.StreamSupport;
    private volatile BiFunction<DiscoveryNode, FsInfo.Path, FsInfo.Path> diskUsageFunction;
        return nodesStats.stream().map(nodeStats -> {
                    )
    }
import org.opensearch.transport.client.node.NodeClient;
                    )
            final DiscoveryNode discoveryNode = nodeStats.getNode();
                nodeStats.getAdmissionControlStats(),
import org.opensearch.common.unit.TimeValue;
import org.opensearch.cluster.service.ClusterService;
 */
                    ? new NodesResourceUsageStats(
                nodeStats.getOs(),
        }).collect(Collectors.toList());
            }
 * the Apache License, Version 2.0 (the "License"); you may
    public void setUpdateFrequency(TimeValue updateFrequency) {
import java.util.function.Function;
                        StreamSupport.stream(oldFsInfo.spliterator(), false)
 * The OpenSearch Contributors require contributions made to
                delegate.getNodeResourceUsageStats()
                nodeStats.getScriptStats(),
                nodeStats.getClusterManagerThrottlingStats(),
            super(
package org.opensearch.cluster;
import org.opensearch.node.NodeResourceUsageStats;
                nodeStats.getBreaker(),
                nodeStats.getRepositoriesStats(),
import java.util.Collections;
        refresh();
 * You may obtain a copy of the License at
                nodeStats.getTaskCancellationStats(),
 * ownership. Elasticsearch licenses this file to you under
                nodeStats.getIngestStats(),
 * license agreements. See the NOTICE file distributed with
                        oldFsInfo.getTimestamp(),
                nodeStats.getTotalEstimatedNativeBytes()
    @Override
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.node.DiscoveryNode;
                delegate.getNodeMostAvailableDiskUsages(),
                nodeStats.getNativeAllocatorStats(),
        this.resourceUsageFunction = resourceUsageFunction;
import org.opensearch.plugins.Plugin;
                    : nodeStats.getFs(),
            );
    class SizeFakingClusterInfo extends ClusterInfo {
                nodeStats.getRemoteStoreNodeStats(),
                this.diskUsageFunction != null
                discoveryNode,
                    ? new FsInfo(
                        Collections.singletonMap(discoveryNode.getId(), resourceUsageFunction.apply(discoveryNode.getId()))
    @Nullable // if no fakery should take place
            final FsInfo oldFsInfo = nodeStats.getFs();
    public ClusterInfo getClusterInfo() {
        }
                        oldFsInfo.getIoStats(),
        this.aggregateFileCacheStats = aggregateFileCacheStats;
                    : nodeStats.getResourceUsageStats(),
    private volatile Function<ShardRouting, Long> shardSizeFunction;
                nodeStats.getBlockCacheOnlyStats(),
/*
        public Long getShardSize(ShardRouting shardRouting) {
                delegate.routingToDataPath,
 * GitHub history for details.
 * this work for additional information regarding copyright
                nodeStats.getScriptCacheStats(),
 * software distributed under the License is distributed on an
import java.util.function.BiFunction;
                nodeStats.getDiscoveryStats(),
                nodeStats.getShardIndexingPressureStats(),
    }
 * Unless required by applicable law or agreed to in writing,
        final BiFunction<DiscoveryNode, FsInfo.Path, FsInfo.Path> diskUsageFunction = this.diskUsageFunction;
 * Licensed to Elasticsearch under one or more contributor
 * compatible open source license.
            if (shardSizeFunction == null) {
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
    @Nullable
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        this.shardSizeFunction = shardSizeFunction;
                nodeStats.getJvm(),
                nodeStats.getProcess(),
 * KIND, either express or implied.  See the License for the
    }
        @Override
                nodeStats.getFileCacheOnlyStats(),
    @Override
    public MockInternalClusterInfoService(Settings settings, ClusterService clusterService, ThreadPool threadPool, NodeClient client) {
    public void setDiskUsageFunctionAndRefresh(BiFunction<DiscoveryNode, FsInfo.Path, FsInfo.Path> diskUsageFunction) {
 * not use this file except in compliance with the License.
                nodeStats.getConcurrencyLimiterStats(),
    }
                nodeStats.getWeightedRoutingStats(),
import org.opensearch.common.settings.Settings;
        return new SizeFakingClusterInfo(clusterInfo);
 *     http://www.apache.org/licenses/LICENSE-2.0
                delegate.nodeFileCacheStats,
                nodeStats.getThreadPool(),
import org.opensearch.node.NodesResourceUsageStats;
            return shardSizeFunction.apply(shardRouting);
        refresh();
    List<NodeStats> adjustNodesStats(List<NodeStats> nodesStats) {
                nodeStats.getIndices(),
import org.opensearch.common.Nullable;
                nodeStats.getTransport(),
                nodeStats.getSearchBackpressureStats(),
        refresh();
import org.opensearch.threadpool.ThreadPool;
 * under the License.
        this.diskUsageFunction = diskUsageFunction;
    public static class TestPlugin extends Plugin {}
        final ClusterInfo clusterInfo = super.getClusterInfo();
    public void setAggregateFileCacheStats(AggregateFileCacheStats aggregateFileCacheStats) {
 *
