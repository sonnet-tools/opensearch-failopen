                        StreamSupport.stream(oldFsInfo.spliterator(), false)
                nodeStats.getScriptStats(),
    private AggregateFileCacheStats aggregateFileCacheStats;
            if (shardSizeFunction == null) {
    public static class TestPlugin extends Plugin {}
            return shardSizeFunction.apply(shardRouting);
import java.util.stream.Collectors;
                nodeStats.getTaskCancellationStats(),
/*  
    @Nullable  
        this.aggregateFileCacheStats = aggregateFileCacheStats;
        public Long getShardSize(ShardRouting shardRouting) {
                nodeStats.getBlockCacheOnlyStats(),  
 * KIND, either express or implied.  See the License for the
    }  
            final Function<ShardRouting, Long> shardSizeFunction = MockInternalClusterInfoService.this.shardSizeFunction;  
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
                nodeStats.getTransport(),
            super(
        return nodesStats.stream().map(nodeStats -> {
                discoveryNode,  
                return super.getShardSize(shardRouting);
import org.opensearch.cluster.service.ClusterService;  
package org.opensearch.cluster;
import org.opensearch.plugins.Plugin;
    }
        return new SizeFakingClusterInfo(clusterInfo);  
        this.shardSizeFunction = shardSizeFunction;
        SizeFakingClusterInfo(ClusterInfo delegate) {
            );
                nodeStats.getAdaptiveSelectionStats(),
import org.opensearch.cluster.node.DiscoveryNode;
                    ? new NodesResourceUsageStats(  
    public void setShardSizeFunctionAndRefresh(Function<ShardRouting, Long> shardSizeFunction) {
                delegate.nodeFileCacheStats,
    @Override  
                nodeStats.getSearchPipelineStats(),
        }
                this.diskUsageFunction != null
    }
                nodeStats.getClusterManagerThrottlingStats(),
}
 * You may obtain a copy of the License at  
                    : nodeStats.getFs(),  
        this.resourceUsageFunction = resourceUsageFunction;  
        final BiFunction<DiscoveryNode, FsInfo.Path, FsInfo.Path> diskUsageFunction = this.diskUsageFunction;
 * Modifications Copyright OpenSearch Contributors. See  
                nodeStats.getDiscoveryStats(),
                delegate.shardSizes,
import org.opensearch.cluster.routing.ShardRouting;
            final FsInfo oldFsInfo = nodeStats.getFs();  
            }  
                nodeStats.getRemoteStoreNodeStats(),
 */  
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
            final DiscoveryNode discoveryNode = nodeStats.getNode();
    }
 * Unless required by applicable law or agreed to in writing,
                            .toArray(FsInfo.Path[]::new)
import java.util.stream.StreamSupport;
                this.aggregateFileCacheStats != null ? this.aggregateFileCacheStats : nodeStats.getFileCacheStats(),
 */
        super(settings, clusterService, threadPool, client);
 *
 */
import org.opensearch.common.unit.TimeValue;  
 * software distributed under the License is distributed on an
            );
 * not use this file except in compliance with the License.
                    )
                nodeStats.getWeightedRoutingStats(),  
/*
                        oldFsInfo.getIoStats(),
    public MockInternalClusterInfoService(Settings settings, ClusterService clusterService, ThreadPool threadPool, NodeClient client) {  
import org.opensearch.node.NodeResourceUsageStats;  
    @Nullable // if no fakery should take place  
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
import org.opensearch.action.admin.cluster.node.stats.NodeStats;  
 * compatible open source license.
import org.opensearch.transport.client.node.NodeClient;
import java.util.List;
import org.opensearch.common.settings.Settings;
                nodeStats.getRepositoriesStats(),
        }  
                nodeStats.getTotalEstimatedNativeBytes()
                            .map(fsInfoPath -> diskUsageFunction.apply(discoveryNode, fsInfoPath))  
    private volatile BiFunction<DiscoveryNode, FsInfo.Path, FsInfo.Path> diskUsageFunction;
 * the Apache License, Version 2.0 (the "License"); you may
                nodeStats.getIngestStats(),  
    private volatile Function<String, NodeResourceUsageStats> resourceUsageFunction;
        refresh();
    }  
    private volatile Function<ShardRouting, Long> shardSizeFunction;
        refresh();  
    /** This is a marker plugin used to trigger MockNode to use this mock info service. */  
                nodeStats.getSearchBackpressureStats(),
    class SizeFakingClusterInfo extends ClusterInfo {  
 * GitHub history for details.
                nodeStats.getTimestamp(),
    public void setUpdateFrequency(TimeValue updateFrequency) {
public class MockInternalClusterInfoService extends InternalClusterInfoService {
 * ownership. Elasticsearch licenses this file to you under  
import java.util.function.Function;  
                delegate.getNodeResourceUsageStats()  
    public void setDiskUsageFunctionAndRefresh(BiFunction<DiscoveryNode, FsInfo.Path, FsInfo.Path> diskUsageFunction) {
                nodeStats.getOs(),  
                nodeStats.getThreadPool(),  
                nodeStats.getHttp(),
    public void setNodeResourceUsageFunctionAndRefresh(Function<String, NodeResourceUsageStats> resourceUsageFunction) {
 * SPDX-License-Identifier: Apache-2.0
    @Override  
        super.setUpdateFrequency(updateFrequency);
 *
                nodeStats.getIndexingPressureStats(),
 * specific language governing permissions and limitations
        refresh();  
                nodeStats.getBreaker(),  
import java.util.Collections;  
 * under the License.  
    }
                nodeStats.getFileCacheOnlyStats(),
                delegate.routingToDataPath,  
                nodeStats.getIndices(),
    public void setAggregateFileCacheStats(AggregateFileCacheStats aggregateFileCacheStats) {  
                        Collections.singletonMap(discoveryNode.getId(), resourceUsageFunction.apply(discoveryNode.getId()))
import org.opensearch.node.NodesResourceUsageStats;
                delegate.getNodeLeastAvailableDiskUsages(),  
    }
    @Override  
        refresh();
    public ClusterInfo getClusterInfo() {
            return new NodeStats(
 * Licensed to Elasticsearch under one or more contributor  
        final ClusterInfo clusterInfo = super.getClusterInfo();
                nodeStats.getConcurrencyLimiterStats(),  
                    : nodeStats.getResourceUsageStats(),  
        }).collect(Collectors.toList());  
                delegate.getNodeMostAvailableDiskUsages(),
                nodeStats.getAdmissionControlStats(),
import java.util.function.BiFunction;
    List<NodeStats> adjustNodesStats(List<NodeStats> nodesStats) {
 *  
import org.opensearch.monitor.fs.FsInfo;
    }
import org.opensearch.threadpool.ThreadPool;  
    @Nullable // if no fakery should take place  
 *     http://www.apache.org/licenses/LICENSE-2.0
                    )
                nodeStats.getNodeCacheStats(),  
                delegate.reservedSpace,
                this.resourceUsageFunction != null
import org.opensearch.common.Nullable;
        this.diskUsageFunction = diskUsageFunction;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                nodeStats.getScriptCacheStats(),
                        oldFsInfo.getTimestamp(),  
    @Nullable // if no fakery should take place  
                nodeStats.getProcess(),
                    ? new FsInfo(
                nodeStats.getSegmentReplicationRejectionStats(),  
    }
                nodeStats.getShardIndexingPressureStats(),  
                nodeStats.getNativeAllocatorStats(),
        @Override
/*
                nodeStats.getJvm(),
