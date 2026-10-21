import org.opensearch.core.index.Index;
import java.util.Arrays;
            return statsByShard.get(index);
                    + StatsLevel.INDICES.getRestName()
    public static StatsLevel getAcceptedLevel(String[] levels) {
import org.opensearch.index.engine.SegmentsStats;
import org.opensearch.core.xcontent.ToXContentFragment;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public WarmerStats getWarmer() {
     * Passing the level information to the nodes allows us to aggregate the stats based on the level passed. This
 */
        Map<Index, List<IndexShardStats>> statsByShard,
        Map<Index, List<IndexShardStats>> statsByShard,
    public RefreshStats getRefresh() {
 * SPDX-License-Identifier: Apache-2.0
 */
        return stats.getSegments();
import org.opensearch.common.Nullable;
import org.opensearch.index.shard.DocsStats;
     * Without passing the information of the levels to the constructor, we return the Node-level aggregated stats as
                case INDICES:
 */
            throw new IllegalArgumentException(
        for (List<IndexShardStats> shardStatsList : statsByShard.values()) {
     * allows us to aggregate based on NodeLevel (default - if no level is passed) or Index level if `indices` level is
import org.opensearch.action.search.SearchRequestStats;
import org.opensearch.index.recovery.RecoveryStats;
    private void writeStatsByShards(StreamOutput out) throws IOException {
        }
     * @param levels - levels sent in the request.
    }
 * this file be licensed under the Apache-2.0 license or a
                    this.statsByShard = statsByShard;
        INDICES("indices"),
import org.opensearch.index.store.StoreStats;
    }
     * stats and return only the information that is required while returning to the client.
                }
 * license agreements. See the NOTICE file distributed with
    }
    }
        CommonStats oldStats,
    private void writeStatsByIndex(StreamOutput out) throws IOException {
        this.statusCounterStats = statusCounterStats;
 * Modifications Copyright OpenSearch Contributors. See
        } else if (StatsLevel.SHARDS.getRestName().equals(level)) {
        return null;
        return stats.getFieldData();
    public SearchStats getSearch() {
    }
 * this work for additional information regarding copyright
                    this.statsByIndex = createStatsByIndex(statsByShard);
                    + "] or ["
 * KIND, either express or implied.  See the License for the
        }
        this.stats = oldStats;
        return statusCounterStats;
import org.opensearch.common.annotation.PublicApi;
    public SegmentsStats getSegments() {
 * software distributed under the License is distributed on an
     * Passing the level information to the nodes allows us to aggregate the stats based on the level passed. This
                builder.startArray(entry.getKey().getName());
     * By default, the levels passed from the transport action will be a list of strings, since NodeIndicesStats can
        }
        return stats.getFlush();
                statusCounterStats.writeTo(out);
import org.opensearch.index.cache.query.QueryCacheStats;
        }
    public QueryCacheStats getQueryCache() {
            }
/*
                    this.statsByIndex = createStatsByIndex(statsByShard);
        }
import org.opensearch.index.get.GetStats;
        SearchRequestStats searchRequestStats,
        for (int i = 0; i < indexEntries; i++) {
    public NodeIndicesStats(StreamInput in) throws IOException {
        Map<Index, CommonStats> statsMap = new HashMap<>();
            out.writeBoolean(statsByIndex != null);
 * ownership. Elasticsearch licenses this file to you under
        SHARDS("shards"),
    public void writeTo(StreamOutput out) throws IOException {
        StatusCounterStats statusCounterStats
import org.opensearch.index.warmer.WarmerStats;
            }
    public RequestCacheStats getRequestCache() {
    public TranslogStats getTranslog() {
    @Override
import org.opensearch.search.suggest.completion.CompletionStats;
        if (levels != null && levels.length > 0) {
            statsByShard.put(index, indexShardStats);
            this.restName = restName;
                for (ShardStats shardStats : indexShardStats.getShards()) {
    @Nullable
            || StatsLevel.INDICES.getRestName().equalsIgnoreCase(level)
    public NodeIndicesStats(
        }
 * compatible open source license.
    @Nullable
            statusCounterStats.toXContent(builder, params);
    }
    }
                    break;
    @Deprecated(since = "3.4.0")
        return stats.getTranslog();
    /**
        Map<Index, CommonStats> statsByIndex = new HashMap<>();
        }
 * Unless required by applicable law or agreed to in writing,
            builder.endObject();
                }
        this.statusCounterStats = statusCounterStats;
    }
    @Nullable
                }
/**
        }
        stats.writeTo(out);
        private final String restName;
@PublicApi(since = "1.0.0")
                statsByIndex = readStatsByIndex(in);
        return statsByIndex;
            }
        // make a total common stats from old ones and current ones
                    stats.add(shardStats.getStats());
                    + "] or ["
        builder.endObject();
        }
        return stats.getStore();
import org.opensearch.core.common.io.stream.StreamOutput;
        CommonStats oldStats,
            }
            }
        this.statsByShard = statsByShard;
    public DocsStats getDocs() {
        if (level != null) {
            for (IndexShardStats indexShardStats : shardStatsList) {
                }
/*
    @Deprecated(since = "3.4.0")
            for (int j = 0; j < indexShardListSize; j++) {
                for (ShardStats shardStats : indexShardStats.getShards()) {
                out.writeVInt(entry.getValue().size());
    public MergeStats getMerge() {
        return statsMap;
     * only aggregate on one level, we pick the first accepted level else we ignore if no known level is passed. Level is
import org.opensearch.action.admin.indices.stats.IndexShardStats;
            int indexShardListSize = in.readVInt();
     * Note - we are picking the first level as multiple levels are not supported in the previous versions.
import org.opensearch.core.common.io.stream.Writeable;
        NODE("node");
    @Nullable
        this.stats = oldStats;
    public RecoveryStats getRecoveryStats() {
                    + StatsLevel.SHARDS.getRestName()
        }
    private Map<Index, List<IndexShardStats>> readStatsByShard(StreamInput in) throws IOException {
            for (IndexShardStats indexShardStats : entry.getValue()) {
            out.writeBoolean(statusCounterStats != null);
    /**
    @Nullable
import java.util.List;
    }
    }
            for (IndexShardStats indexShardStats : shardStatsList) {
        for (List<IndexShardStats> shardStatsList : statsByShard.values()) {
 *
            }
    @Nullable
                        shardStats.toXContent(builder, params);
                for (ShardStats shardStats : indexShardStats.getShards()) {
                entry.getValue().toXContent(builder, params);
 * Licensed to Elasticsearch under one or more contributor
                    builder.startObject().startObject(String.valueOf(indexShardStats.getShardId().getId()));
            return restName;
        }
    }
        }
            // contains statsByIndex
        }
        }
        return stats.getDocs();
     * stats and return only the information that is required while returning to the client.
            || StatsLevel.SHARDS.getRestName().equalsIgnoreCase(level);
                    indexShardStats.writeTo(out);
            }
            builder.endObject();
        if (this.stats.search != null) {
            for (IndexShardStats indexShardStats : shardStatsList) {
public class NodeIndicesStats implements Writeable, ToXContentFragment {
     *
        StatsLevel level
        }
 *
                for (ShardStats shardStats : indexShardStats.getShards()) {
     */
import org.opensearch.index.search.stats.SearchStats;
    /**
            }
import org.opensearch.Version;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        } else {
        if (in.readBoolean()) {
        return stats.getIndexing();
            for (Map.Entry<Index, List<IndexShardStats>> entry : statsByShard.entrySet()) {
     * @return Corresponding identified enum {@link StatsLevel}
        }
        if (!isLevelValid) {
    public CompletionStats getCompletion() {
import org.opensearch.index.translog.TranslogStats;
import org.opensearch.index.fielddata.FieldDataStats;
                    stats.add(shardStats.getStats());
            switch (level) {
            if (statsByIndex != null) {
    /**
            if (in.readBoolean()) {
        // "node" level
        if (statsByIndex != null) {
import org.opensearch.core.xcontent.XContentBuilder;
    }
import org.opensearch.action.admin.indices.stats.StatusCounterStats;
                    + level
     * @opensearch.internal
import org.opensearch.index.merge.MergeStats;
 * You may obtain a copy of the License at
                case SHARDS:
                    for (ShardStats shardStats : indexShardStats.getShards()) {
        return builder;
            out.writeVInt(statsByShard.size());
     */
            }
     * Without passing the information of the levels to the constructor, we return the Node-level aggregated stats as
    @Nullable
                    + "]"
    }
 * @opensearch.api
        if (statsByShard != null) {
    private Map<Index, CommonStats> createStatsByIndex(Map<Index, List<IndexShardStats>> statsByShard) {
    @Nullable
     * selected based on enum defined in {@link StatsLevel}
        return stats.getCompletion();
    }
            for (IndexShardStats indexShardStats : shardStatsList) {
                statsMap.put(entry.getKey(), new CommonStats());
            }
        if (level != null) {
                statusCounterStats = new StatusCounterStats(in);
 * specific language governing permissions and limitations
        int indexEntries = in.readVInt();
                }
    public FieldDataStats getFieldData() {
    }
                    builder.endObject().endObject();
            this.stats.search.setSearchRequestStats(searchRequestStats);
        CommonStats oldStats,
                "level parameter must be one of ["
        for (int i = 0; i < entries; i++) {
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
        SearchRequestStats searchRequestStats,
import java.io.IOException;
            writeStatsByShards(out);
        return stats.getQueryCache();
        SearchRequestStats searchRequestStats,
                    stats.add(shardStats.getStats());
        }
    public NodeIndicesStats(CommonStats oldStats, Map<Index, List<IndexShardStats>> statsByShard, SearchRequestStats searchRequestStats) {
    }
            statsByIndex.put(index, commonStats);
     * allows us to aggregate based on NodeLevel (default - if no level is passed) or Index level if `indices` level is
            if (statusCounterStats != null) {
     * passed and finally return the statsByShards map if `shards` level is passed. This allows us to reduce ser/de of
    }
            Index index = new Index(in);
     */
 * under the License.
        this.statsByShard = statsByShard;
    /**
            );
    }
        for (List<IndexShardStats> shardStatsList : statsByShard.values()) {
        Map<Index, List<IndexShardStats>> statsByShard = new HashMap<>();
    }
        if (this.stats.search != null) {
                indexShardStats.add(new IndexShardStats(in));
        }
        public String getRestName() {
        if (statsByShard != null) {
            Index index = new Index(in);
import org.opensearch.index.flush.FlushStats;
     *
        return stats.getWarmer();
        }
                for (ShardStats shardStats : indexShardStats.getShards()) {
                builder.endObject();
            }
        }
        StatsLevel level
                entry.getKey().writeTo(out);
    }
import org.opensearch.action.admin.indices.stats.CommonStats;
    ) {
     * {@link CommonStats} along with a hash-map containing Index to List of Shard Stats and the StatusCounterStats.
            builder.startObject(StatsLevel.SHARDS.getRestName());
                    break;
            }
                .findFirst();
        return stats.getRequestCache();
        return stats.getRefresh();
    @Nullable
        if (statsByShard == null) {
    public IndexingStats getIndexing() {
            List<IndexShardStats> indexShardStats = new ArrayList<>(indexShardListSize);
    }
        if (StatsLevel.INDICES.getRestName().equals(level)) {
                    }
            return null;
 *    http://www.apache.org/licenses/LICENSE-2.0
                    this.statsByShard = statsByShard;
    }
            switch (level) {
        if (statusCounterStats != null) {
            this.stats.search.setSearchRequestStats(searchRequestStats);
                entry.getKey().writeTo(out);
    }
                statsByIndex = createStatsByIndex(statsByShard);
}
        final boolean isLevelValid = StatsLevel.NODE.getRestName().equalsIgnoreCase(level)
 * GitHub history for details.
    public List<IndexShardStats> getShardStats(Index index) {
        }
    @PublicApi(since = "3.0.0")
import java.util.HashMap;
        return stats.getMerge();
        // statusCounterStats should be a snapshot of the statusCounters at a point in time, just like all the items in
    @Nullable
    }
        this.stats = oldStats;
    protected Map<Index, List<IndexShardStats>> statsByShard;
                for (IndexShardStats indexShardStats : entry.getValue()) {
        }
        return stats.getRecoveryStats();
 * the Apache License, Version 2.0 (the "License"); you may
                .filter(field -> field.getRestName().equals(levels[0]))
                    break;
            if (in.readBoolean()) {
    public GetStats getGet() {
     */
 *
            for (Map.Entry<Index, List<IndexShardStats>> entry : statsByShard.entrySet()) {
 * not use this file except in compliance with the License.
        Map<Index, List<IndexShardStats>> statsByShard,
 * Global information on indices stats running on a specific node.
    @Nullable
import java.util.ArrayList;
    public StoreStats getStore() {
    public StatusCounterStats getStatusCounterStats() {
                writeStatsByIndex(out);
    @Nullable
    @Nullable
        return stats.getSearch();
     */
    protected Map<Index, CommonStats> statsByIndex;
    public enum StatsLevel {
        }
        builder.startObject(StatsLevel.INDICES.getRestName());
        return statsByShard;
        if (in.getVersion().onOrAfter(Version.V_2_17_0)) {
            }
            statsByShard = readStatsByShard(in);
            CommonStats commonStats = new CommonStats(in);
                    + "] but was ["
        }
    protected CommonStats stats;
    @Nullable
    }
        StatusCounterStats statusCounterStats,
        // NodeIndicesStats should be.
/*
                case SHARDS:
    }
 * The OpenSearch Contributors require contributions made to
            }
            }
    }
        if (this.stats.search != null) {
        for (Map.Entry<Index, List<IndexShardStats>> entry : statsByShard.entrySet()) {
    }
                }
        // make a total common stats from old ones and current ones
        }
            out.writeVInt(statsByIndex.size());
        // make a total common stats from old ones and current ones
        }
 *
     * Fields used for parsing and toXContent
            }
     *
        // make a total common stats from old ones and current ones
                case INDICES:
            if (statsByIndex == null) {
        if (in.getVersion().onOrAfter(Version.V_3_4_0)) {
                builder.endArray();
            return level.orElseThrow(() -> new IllegalArgumentException("Level provided is not supported by NodeIndicesStats"));
        this.stats = oldStats;
                    statsMap.get(entry.getKey()).add(shardStats.getStats());
            this.stats.search.setSearchRequestStats(searchRequestStats);
    }
            }
            if (!statsMap.containsKey(entry.getKey())) {
    @Override
    @Nullable
        }
    }
        final String level = params.param("level", StatsLevel.NODE.getRestName());
            assert statsByIndex != null || statsByShard != null : "Expected shard stats or index stats in response for generating ["
        if (out.getVersion().onOrAfter(Version.V_3_4_0)) {
                    break;
    ) {
        out.writeBoolean(statsByShard != null);
import org.opensearch.index.refresh.RefreshStats;
    public NodeIndicesStats(
    private Map<Index, CommonStats> readStatsByIndex(StreamInput in) throws IOException {
            builder.startObject(StatsLevel.INDICES.getRestName());
            for (Map.Entry<Index, CommonStats> entry : statsByIndex.entrySet()) {
 */
                    + StatsLevel.NODE.getRestName()
    protected StatusCounterStats statusCounterStats;
    }
            Optional<StatsLevel> level = Arrays.stream(StatsLevel.values())
import java.util.Optional;
     * {@link CommonStats} along with a hash-map containing Index to List of Shard Stats.
    @Nullable
        int entries = in.readVInt();
                for (IndexShardStats indexShardStats : entry.getValue()) {
    /**
                entry.getValue().writeTo(out);
package org.opensearch.indices;
        }
import java.util.Map;
    @Nullable
                + "] field";
        stats.toXContent(builder, params);
                builder.startObject(entry.getKey().getName());
        if (this.stats.search != null) {
            }
import org.opensearch.core.common.io.stream.StreamInput;
    public NodeIndicesStats(
                    stats.add(shardStats.getStats());
            this.stats.search.setSearchRequestStats(searchRequestStats);
        stats = new CommonStats(in);
import org.opensearch.action.admin.indices.stats.ShardStats;
    ) {
                }
     */
        StatsLevel(String restName) {
            assert statsByShard != null : "Expected shard stats in response for generating [" + StatsLevel.SHARDS + "] field";
import org.opensearch.index.shard.IndexingStats;
    }
            for (Map.Entry<Index, CommonStats> entry : statsByIndex.entrySet()) {
        return stats.getGet();
        for (List<IndexShardStats> shardStatsList : statsByShard.values()) {
    public FlushStats getFlush() {
     * passed and finally return the statsByShards map if `shards` level is passed. This allows us to reduce ser/de of
                + StatsLevel.INDICES
import org.opensearch.index.cache.request.RequestCacheStats;
