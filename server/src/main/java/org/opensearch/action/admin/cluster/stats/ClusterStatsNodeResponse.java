            super(in);
        this.clusterStatus = clusterStatus;
        if (in.getVersion().onOrAfter(Version.V_2_16_0)) {
import java.util.HashMap;
import org.opensearch.index.store.StoreStats;
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
                CommonStats shardCommonStats = shardStats.getStats();
    private final ShardStats[] shardsStats;
        public void writeTo(StreamOutput out) throws IOException {
 * not use this file except in compliance with the License.
/**
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
    }
import org.opensearch.common.annotation.PublicApi;
 * license agreements. See the NOTICE file distributed with
    public class AggregatedNodeLevelStats extends BaseNodeResponse {
            out.writeArray(shardsStats);
            }
 * software distributed under the License is distributed on an
        this.nodeStats = nodeStats;
            }
 *
                if (indexShardStats == null) {
     */
    }
    public static ClusterStatsNodeResponse readNodeResponse(StreamInput in) throws IOException {
    @Override
        }
        }
        return this.nodeStats;
import org.opensearch.common.Nullable;
    public AggregatedNodeLevelStats getAggregatedNodeLevelStats() {
 */
/*
        return new ClusterStatsNodeResponse(in);
                    indexShardStats = new AggregatedIndexStats();
            this.commonStats.store = new StoreStats();
            out.writeVInt(primaries);
        if (clusterStatus == null) {
import org.opensearch.core.common.io.stream.Writeable;
            out.writeBoolean(false);
 *     http://www.apache.org/licenses/LICENSE-2.0
    private final NodeInfo nodeInfo;
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.io.stream.StreamOutput;
/*
            out.writeMap(indexStatsMap, StreamOutput::writeString, (stream, stats) -> stats.writeTo(stream));
 * Transport action for obtaining cluster stats from node level
            super.writeTo(out);
        this.nodeStats = new NodeStats(in);
            this.shardsStats = in.readArray(ShardStats::new, ShardStats[]::new);
     */
        Map<String, AggregatedIndexStats> indexStatsMap;
    }
import org.opensearch.search.suggest.completion.CompletionStats;
    @PublicApi(since = "2.16.0")
    }
                this.commonStats.completion.add(shardCommonStats.completion);
            out.writeVInt(total);
 * under the License.
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.action.admin.indices.stats.ShardStats;
            clusterStatus = ClusterHealthStatus.fromValue(in.readByte());
        public AggregatedIndexStats(StreamInput in) throws IOException {
        }
 * the Apache License, Version 2.0 (the "License"); you may
     * Node level statistics used for ClusterStatsIndices for _cluster/stats call.
        if (out.getVersion().onOrAfter(Version.V_2_16_0)) {
        DiscoveryNode node,
    public NodeInfo nodeInfo() {
            // Index Level Stats
        }
import java.io.IOException;
import org.opensearch.index.cache.query.QueryCacheStats;
 *
            this.commonStats = new CommonStats();
            this.aggregatedNodeLevelStats = new AggregatedNodeLevelStats(node, shardsStats);
        return clusterStatus;
    }
        } else {
        public AggregatedIndexStats() {}
        this.nodeStats = nodeStats;
            this.commonStats.docs = new DocsStats();
import org.opensearch.index.fielddata.FieldDataStats;
 */
        NodeStats nodeStats,
            this.aggregatedNodeLevelStats = in.readOptionalWriteable(AggregatedNodeLevelStats::new);
    public void writeTo(StreamOutput out) throws IOException {
        super(node);
        boolean useAggregatedNodeLevelResponses
            this.commonStats.fieldData = new FieldDataStats();
import java.util.Map;
    }
 *
        super.writeTo(out);
                out.writeOptionalWriteable(null);
                this.commonStats.segments.add(shardCommonStats.segments);
    /**
package org.opensearch.action.admin.cluster.stats;
        if (in.readBoolean()) {
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
 * @opensearch.internal
        super(in);
    public NodeStats nodeStats() {
import org.opensearch.cluster.node.DiscoveryNode;
                AggregatedIndexStats indexShardStats = this.indexStatsMap.get(shardStats.getShardRouting().getIndexName());
                }
 * specific language governing permissions and limitations
 *
    private AggregatedNodeLevelStats aggregatedNodeLevelStats;
    ) {
    }
        protected AggregatedNodeLevelStats(StreamInput in) throws IOException {
        nodeInfo.writeTo(out);
        } else {
    public ClusterStatsNodeResponse(
     * Node level statistics used for ClusterStatsIndices for _cluster/stats call.
/*
            primaries = in.readVInt();
        public void writeTo(StreamOutput out) throws IOException {
    public ClusterStatsNodeResponse(StreamInput in) throws IOException {
        this.shardsStats = shardsStats;
        }
        }
                if (shardStats.getShardRouting().primary()) {
    }
    public ClusterStatsNodeResponse(
 * Modifications Copyright OpenSearch Contributors. See
        this.nodeInfo = nodeInfo;
 * The OpenSearch Contributors require contributions made to
                    this.indexStatsMap.put(shardStats.getShardRouting().getIndexName(), indexShardStats);
        return this.shardsStats;
 * GitHub history for details.
                out.writeOptionalArray(shardsStats);
            out.writeBoolean(true);
            this.shardsStats = in.readOptionalArray(ShardStats::new, ShardStats[]::new);
import org.opensearch.action.admin.indices.stats.CommonStats;
        NodeInfo nodeInfo,
                }
    /**
        public int primaries = 0;
     */
 */
 * You may obtain a copy of the License at
            total = in.readVInt();
        public int total = 0;
}
        this.nodeInfo = nodeInfo;
            if (aggregatedNodeLevelStats != null) {
 * Licensed to Elasticsearch under one or more contributor
        } else {
            this.commonStats.queryCache = new QueryCacheStats();
    private final NodeStats nodeStats;
        this.shardsStats = shardsStats;
            this.indexStatsMap = new HashMap<>();
 * this work for additional information regarding copyright
        nodeStats.writeTo(out);
        @Override
 */
    }
import org.opensearch.core.common.io.stream.StreamInput;
            this.commonStats.segments = new SegmentsStats();
                this.commonStats.queryCache.add(shardCommonStats.queryCache);
        ShardStats[] shardsStats,
import org.opensearch.index.shard.DocsStats;
            indexStatsMap = in.readMap(StreamInput::readString, AggregatedIndexStats::new);
        }
            super(node);
    }
    public ClusterHealthStatus clusterStatus() {
        NodeStats nodeStats,
            out.writeOptionalWriteable(commonStats);
                this.commonStats.store.add(shardCommonStats.store);
        NodeInfo nodeInfo,
    ) {
import org.opensearch.Version;
            commonStats = in.readOptionalWriteable(CommonStats::new);
    }
        if (useAggregatedNodeLevelResponses) {
                this.commonStats.fieldData.add(shardCommonStats.fieldData);
            out.writeByte(clusterStatus.value());
        CommonStats commonStats;
        return aggregatedNodeLevelStats;
        @Nullable ClusterHealthStatus clusterStatus,
        super(node);
    private ClusterHealthStatus clusterStatus;
 * compatible open source license.
        @Nullable ClusterHealthStatus clusterStatus,
     * Cluster Health Status, only populated on cluster-manager nodes.
            } else {
    @Nullable
import org.opensearch.cluster.health.ClusterHealthStatus;
                    this.commonStats.docs.add(shardCommonStats.docs);
        @Override
    public ShardStats[] shardsStats() {
                out.writeOptionalArray(null);
        this.clusterStatus = clusterStatus;
        return this.nodeInfo;
                out.writeOptionalWriteable(aggregatedNodeLevelStats);
    /**
            for (org.opensearch.action.admin.indices.stats.ShardStats shardStats : indexShardsStats) {
        ShardStats[] shardsStats
        protected AggregatedNodeLevelStats(DiscoveryNode node, ShardStats[] indexShardsStats) {
        this.nodeInfo = new NodeInfo(in);
        }
    public static class AggregatedIndexStats implements Writeable {
            this.commonStats.completion = new CompletionStats();
import org.opensearch.action.support.nodes.BaseNodeResponse;
        DiscoveryNode node,
import org.opensearch.index.engine.SegmentsStats;
public class ClusterStatsNodeResponse extends BaseNodeResponse {
        }
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under
                    indexShardStats.primaries++;
                indexShardStats.total++;
        clusterStatus = null;
    }
