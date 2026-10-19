 * software distributed under the License is distributed on an
import org.opensearch.common.Nullable;  
            indexStatsMap = in.readMap(StreamInput::readString, AggregatedIndexStats::new);
 * compatible open source license.
        public int primaries = 0;  
        @Override  
                if (shardStats.getShardRouting().primary()) {
 *  
    }
    /**  
            this.commonStats.store = new StoreStats();  
 * ownership. Elasticsearch licenses this file to you under  
            this.commonStats.queryCache = new QueryCacheStats();
                }
        return this.nodeStats;
    public ClusterStatsNodeResponse(
        if (in.readBoolean()) {
    public ClusterHealthStatus clusterStatus() {
    private ClusterHealthStatus clusterStatus;
    public class AggregatedNodeLevelStats extends BaseNodeResponse {  
            this.commonStats.docs = new DocsStats();
        } else {
    /**  
            out.writeBoolean(true);  
            primaries = in.readVInt();
        if (clusterStatus == null) {  
    public ClusterStatsNodeResponse(StreamInput in) throws IOException {
import org.opensearch.search.suggest.completion.CompletionStats;
import org.opensearch.core.common.io.stream.StreamInput;
        Map<String, AggregatedIndexStats> indexStatsMap;  
 *  
 * Unless required by applicable law or agreed to in writing,
    public NodeInfo nodeInfo() {
        protected AggregatedNodeLevelStats(DiscoveryNode node, ShardStats[] indexShardsStats) {
        ShardStats[] shardsStats,
            this.commonStats.fieldData = new FieldDataStats();
        DiscoveryNode node,
        DiscoveryNode node,  
                }
import org.opensearch.core.common.io.stream.Writeable;
        } else {
                    indexShardStats.primaries++;
                    this.indexStatsMap.put(shardStats.getShardRouting().getIndexName(), indexShardStats);  
        }  
 * this work for additional information regarding copyright
import org.opensearch.action.admin.cluster.node.stats.NodeStats;  
        }
    }
                if (indexShardStats == null) {
import org.opensearch.core.common.io.stream.StreamOutput;  
        super.writeTo(out);
        return this.nodeInfo;  
                this.commonStats.store.add(shardCommonStats.store);
            this.aggregatedNodeLevelStats = in.readOptionalWriteable(AggregatedNodeLevelStats::new);  
    private final ShardStats[] shardsStats;
            this.shardsStats = in.readArray(ShardStats::new, ShardStats[]::new);
            out.writeByte(clusterStatus.value());
        super(node);
        @Override
            out.writeArray(shardsStats);
        super(in);  
        if (useAggregatedNodeLevelResponses) {
import org.opensearch.action.admin.indices.stats.CommonStats;
            }
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
        this.nodeInfo = new NodeInfo(in);
        }  
import org.opensearch.index.shard.DocsStats;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Transport action for obtaining cluster stats from node level
        NodeStats nodeStats,  
    }
            out.writeVInt(total);
            out.writeVInt(primaries);  
        this.nodeInfo = nodeInfo;
        return clusterStatus;  
 */  
    }
                this.commonStats.segments.add(shardCommonStats.segments);  
    @Nullable
    public AggregatedNodeLevelStats getAggregatedNodeLevelStats() {
        this.nodeStats = nodeStats;  
    private AggregatedNodeLevelStats aggregatedNodeLevelStats;  
        protected AggregatedNodeLevelStats(StreamInput in) throws IOException {
        boolean useAggregatedNodeLevelResponses
import org.opensearch.cluster.health.ClusterHealthStatus;
import org.opensearch.index.cache.query.QueryCacheStats;
        this.shardsStats = shardsStats;
    /**
/*
        public AggregatedIndexStats(StreamInput in) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
import org.opensearch.action.admin.indices.stats.ShardStats;
 * license agreements. See the NOTICE file distributed with
            commonStats = in.readOptionalWriteable(CommonStats::new);
        public void writeTo(StreamOutput out) throws IOException {
        CommonStats commonStats;
 * specific language governing permissions and limitations
public class ClusterStatsNodeResponse extends BaseNodeResponse {  
 *
        return aggregatedNodeLevelStats;
    public ShardStats[] shardsStats() {  
            super.writeTo(out);  
     */  
                    this.commonStats.docs.add(shardCommonStats.docs);  
 * @opensearch.internal
    }  
/**
            this.shardsStats = in.readOptionalArray(ShardStats::new, ShardStats[]::new);
        nodeStats.writeTo(out);
            total = in.readVInt();  
                indexShardStats.total++;  
            clusterStatus = ClusterHealthStatus.fromValue(in.readByte());  
 * You may obtain a copy of the License at  
        NodeStats nodeStats,
    }
        if (out.getVersion().onOrAfter(Version.V_2_16_0)) {
        ShardStats[] shardsStats
    @Override  
import org.opensearch.index.store.StoreStats;  
        nodeInfo.writeTo(out);  
    public void writeTo(StreamOutput out) throws IOException {
                out.writeOptionalWriteable(null);
        this.nodeInfo = nodeInfo;
    @PublicApi(since = "2.16.0")  
     */
     * Cluster Health Status, only populated on cluster-manager nodes.
        @Nullable ClusterHealthStatus clusterStatus,
        }
    ) {  
    }  
        this.nodeStats = new NodeStats(in);  
}  
import org.opensearch.Version;
import org.opensearch.cluster.node.DiscoveryNode;
    }  
    private final NodeStats nodeStats;  
            out.writeMap(indexStatsMap, StreamOutput::writeString, (stream, stats) -> stats.writeTo(stream));
            // Index Level Stats
                out.writeOptionalArray(shardsStats);
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
            this.indexStatsMap = new HashMap<>();
import java.util.Map;
            }  
                    indexShardStats = new AggregatedIndexStats();
        }
            out.writeBoolean(false);
import java.io.IOException;  
                out.writeOptionalArray(null);
        }
 * under the License.  
        return new ClusterStatsNodeResponse(in);  
        NodeInfo nodeInfo,  
        }  
                this.commonStats.fieldData.add(shardCommonStats.fieldData);  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.engine.SegmentsStats;  
                out.writeOptionalWriteable(aggregatedNodeLevelStats);
        }
            this.commonStats.segments = new SegmentsStats();
 * The OpenSearch Contributors require contributions made to  
        this.clusterStatus = clusterStatus;
        this.nodeStats = nodeStats;  
        return this.shardsStats;
    public static ClusterStatsNodeResponse readNodeResponse(StreamInput in) throws IOException {
            this.aggregatedNodeLevelStats = new AggregatedNodeLevelStats(node, shardsStats);
        clusterStatus = null;
     */
import org.opensearch.action.support.nodes.BaseNodeResponse;  
    public static class AggregatedIndexStats implements Writeable {
                this.commonStats.queryCache.add(shardCommonStats.queryCache);
        if (in.getVersion().onOrAfter(Version.V_2_16_0)) {
            super(in);  
 */
 * GitHub history for details.
        }  
     * Node level statistics used for ClusterStatsIndices for _cluster/stats call.
import org.opensearch.common.annotation.PublicApi;
        this.shardsStats = shardsStats;
    }
    private final NodeInfo nodeInfo;
            out.writeOptionalWriteable(commonStats);
            this.commonStats.completion = new CompletionStats();  
 * Modifications Copyright OpenSearch Contributors. See
 */  
        super(node);
 * KIND, either express or implied.  See the License for the
                AggregatedIndexStats indexShardStats = this.indexStatsMap.get(shardStats.getShardRouting().getIndexName());  
            this.commonStats = new CommonStats();
 * SPDX-License-Identifier: Apache-2.0
    }
     * Node level statistics used for ClusterStatsIndices for _cluster/stats call.
        NodeInfo nodeInfo,
import org.opensearch.index.fielddata.FieldDataStats;
    public NodeStats nodeStats() {  
        }  
        @Nullable ClusterHealthStatus clusterStatus,
            if (aggregatedNodeLevelStats != null) {  
            for (org.opensearch.action.admin.indices.stats.ShardStats shardStats : indexShardsStats) {
                CommonStats shardCommonStats = shardStats.getStats();
    public ClusterStatsNodeResponse(  
    ) {  
/*  
    }
import java.util.HashMap;
        public AggregatedIndexStats() {}
        public void writeTo(StreamOutput out) throws IOException {
package org.opensearch.action.admin.cluster.stats;
        } else {
 * not use this file except in compliance with the License.
 *
            } else {  
        public int total = 0;
            super(node);  
/*  
    }
                this.commonStats.completion.add(shardCommonStats.completion);
        this.clusterStatus = clusterStatus;
