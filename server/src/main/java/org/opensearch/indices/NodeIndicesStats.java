                + StatsLevel.INDICES
    @Nullable  
                case SHARDS:
    }
                    stats.add(shardStats.getStats());  
                statusCounterStats.writeTo(out);
 * GitHub history for details.
    public List<IndexShardStats> getShardStats(Index index) {
        }  
            if (!statsMap.containsKey(entry.getKey())) {  
            }
                    indexShardStats.writeTo(out);  
            }
        if (in.getVersion().onOrAfter(Version.V_2_17_0)) {  
                    builder.startObject().startObject(String.valueOf(indexShardStats.getShardId().getId()));  
     * only aggregate on one level, we pick the first accepted level else we ignore if no known level is passed. Level is
            CommonStats commonStats = new CommonStats(in);  
        builder.startObject(StatsLevel.INDICES.getRestName());  
        return stats.getDocs();
}
        SearchRequestStats searchRequestStats,  
            return level.orElseThrow(() -> new IllegalArgumentException("Level provided is not supported by NodeIndicesStats"));
 * @opensearch.api
    ) {  
                entry.getValue().toXContent(builder, params);
                    + "]"
     */  
        stats.writeTo(out);  
    }
    ) {  
/*
    @Deprecated(since = "3.4.0")  
import org.opensearch.core.xcontent.ToXContentFragment;
        CommonStats oldStats,
        }  
            }
            builder.endObject();
import org.opensearch.index.warmer.WarmerStats;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    @Nullable  
        }
        }
    @Nullable
        return statsByIndex;  
            this.stats.search.setSearchRequestStats(searchRequestStats);  
            for (IndexShardStats indexShardStats : entry.getValue()) {
        }  
    }
            for (Map.Entry<Index, CommonStats> entry : statsByIndex.entrySet()) {
    }
                out.writeVInt(entry.getValue().size());
            this.stats.search.setSearchRequestStats(searchRequestStats);  
            }
                }
        }
    }
        }  
import org.opensearch.index.flush.FlushStats;
        }  
    @Nullable  
    }
    public CompletionStats getCompletion() {
        private final String restName;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (this.stats.search != null) {
     */
 * not use this file except in compliance with the License.
import java.util.List;  
                    this.statsByShard = statsByShard;  
            out.writeVInt(statsByIndex.size());  
import org.opensearch.index.search.stats.SearchStats;  
     * passed and finally return the statsByShards map if `shards` level is passed. This allows us to reduce ser/de of  
        // statusCounterStats should be a snapshot of the statusCounters at a point in time, just like all the items in  
        return stats.getRequestCache();  
    @Nullable
                    + StatsLevel.NODE.getRestName()
 * license agreements. See the NOTICE file distributed with
            assert statsByIndex != null || statsByShard != null : "Expected shard stats or index stats in response for generating ["
                entry.getKey().writeTo(out);  
import org.opensearch.core.index.Index;  
            }
            }
package org.opensearch.indices;
    @Nullable
    public TranslogStats getTranslog() {
 * Modifications Copyright OpenSearch Contributors. See
        // "node" level
 * SPDX-License-Identifier: Apache-2.0
    }
    public DocsStats getDocs() {  
        if (statusCounterStats != null) {
        return stats.getQueryCache();
    private Map<Index, List<IndexShardStats>> readStatsByShard(StreamInput in) throws IOException {  
        this.statsByShard = statsByShard;
        for (List<IndexShardStats> shardStatsList : statsByShard.values()) {  
            }
        return stats.getFlush();
import org.opensearch.core.common.io.stream.StreamInput;  
                }
        }
    public NodeIndicesStats(  
    protected Map<Index, CommonStats> statsByIndex;  
            // contains statsByIndex
 * Licensed to Elasticsearch under one or more contributor  
        return statusCounterStats;
                statsByIndex = readStatsByIndex(in);  
        }  
     * allows us to aggregate based on NodeLevel (default - if no level is passed) or Index level if `indices` level is
                    break;  
                    break;
     * passed and finally return the statsByShards map if `shards` level is passed. This allows us to reduce ser/de of  
            builder.startObject(StatsLevel.SHARDS.getRestName());
        Map<Index, CommonStats> statsMap = new HashMap<>();
                }
    public SearchStats getSearch() {  
    }  
        for (List<IndexShardStats> shardStatsList : statsByShard.values()) {  
                    + "] but was ["
    public StoreStats getStore() {
 *
    private Map<Index, CommonStats> createStatsByIndex(Map<Index, List<IndexShardStats>> statsByShard) {  
        return null;
        if (out.getVersion().onOrAfter(Version.V_3_4_0)) {
            this.stats.search.setSearchRequestStats(searchRequestStats);
import java.util.Map;
            out.writeBoolean(statsByIndex != null);  
    }  
import org.opensearch.index.shard.IndexingStats;
        if (statsByShard != null) {  
            assert statsByShard != null : "Expected shard stats in response for generating [" + StatsLevel.SHARDS + "] field";
import org.opensearch.index.engine.SegmentsStats;
                    stats.add(shardStats.getStats());  
    /**  
        if (level != null) {
    public FlushStats getFlush() {  
                indexShardStats.add(new IndexShardStats(in));
            Index index = new Index(in);
            this.stats.search.setSearchRequestStats(searchRequestStats);
    @Nullable  
        }
        for (int i = 0; i < indexEntries; i++) {
     */
    protected Map<Index, List<IndexShardStats>> statsByShard;
                }
        int entries = in.readVInt();
        return stats.getStore();
     * selected based on enum defined in {@link StatsLevel}
        Map<Index, CommonStats> statsByIndex = new HashMap<>();
    public void writeTo(StreamOutput out) throws IOException {
        Map<Index, List<IndexShardStats>> statsByShard,
        Map<Index, List<IndexShardStats>> statsByShard,  
                .findFirst();
 */
            writeStatsByShards(out);
import java.util.Optional;
     * allows us to aggregate based on NodeLevel (default - if no level is passed) or Index level if `indices` level is
        INDICES("indices"),
        // make a total common stats from old ones and current ones
        return stats.getSegments();
import org.opensearch.action.search.SearchRequestStats;  
                entry.getKey().writeTo(out);
import org.opensearch.common.Nullable;
        final String level = params.param("level", StatsLevel.NODE.getRestName());
        return stats.getSearch();
    /**  
            statsByIndex.put(index, commonStats);
import org.opensearch.index.cache.request.RequestCacheStats;
            }  
/*  
    protected CommonStats stats;
import org.opensearch.core.common.io.stream.Writeable;
            builder.startObject(StatsLevel.INDICES.getRestName());
    }  
                for (IndexShardStats indexShardStats : entry.getValue()) {
import java.util.HashMap;
            }
        }  
    @Override
import java.util.Arrays;
                statsMap.put(entry.getKey(), new CommonStats());
                builder.endArray();  
        }  
        Map<Index, List<IndexShardStats>> statsByShard,  
            return statsByShard.get(index);  
    }
import java.io.IOException;
        final boolean isLevelValid = StatsLevel.NODE.getRestName().equalsIgnoreCase(level)  
        if (statsByShard != null) {
    }
 * this work for additional information regarding copyright
import org.opensearch.index.get.GetStats;
                builder.startObject(entry.getKey().getName());
import org.opensearch.index.shard.DocsStats;
                writeStatsByIndex(out);
        return stats.getRecoveryStats();
        }
    }  
            for (IndexShardStats indexShardStats : shardStatsList) {
            if (statsByIndex != null) {
     *  
        if (this.stats.search != null) {
        for (int i = 0; i < entries; i++) {  
            || StatsLevel.SHARDS.getRestName().equalsIgnoreCase(level);
     * Passing the level information to the nodes allows us to aggregate the stats based on the level passed. This
 * this file be licensed under the Apache-2.0 license or a
        this.stats = oldStats;
    @PublicApi(since = "3.0.0")  
        public String getRestName() {  
    @Nullable  
        if (statsByIndex != null) {
    }  
public class NodeIndicesStats implements Writeable, ToXContentFragment {
            Optional<StatsLevel> level = Arrays.stream(StatsLevel.values())
    public RequestCacheStats getRequestCache() {
            Index index = new Index(in);
                case INDICES:
     * @opensearch.internal
            if (statusCounterStats != null) {
            }  
                    for (ShardStats shardStats : indexShardStats.getShards()) {
        StatusCounterStats statusCounterStats,
/**
        StatsLevel(String restName) {
import org.opensearch.core.xcontent.XContentBuilder;
                    + "] or ["
            || StatsLevel.INDICES.getRestName().equalsIgnoreCase(level)
            int indexShardListSize = in.readVInt();
                    break;
    public NodeIndicesStats(StreamInput in) throws IOException {
        stats.toXContent(builder, params);
    }
                for (ShardStats shardStats : indexShardStats.getShards()) {
    @Nullable
                entry.getValue().writeTo(out);  
    @Nullable
    public FieldDataStats getFieldData() {
/*  
 * compatible open source license.
        SearchRequestStats searchRequestStats,
            }  
 */  
    }
    public RecoveryStats getRecoveryStats() {
     * @param levels - levels sent in the request.
            }
    }
                        shardStats.toXContent(builder, params);
            return restName;
        Map<Index, List<IndexShardStats>> statsByShard = new HashMap<>();
        CommonStats oldStats,
        for (Map.Entry<Index, List<IndexShardStats>> entry : statsByShard.entrySet()) {
                case SHARDS:
    }  
        return statsMap;
        if (level != null) {  
            builder.endObject();
        }
        } else if (StatsLevel.SHARDS.getRestName().equals(level)) {  
                for (IndexShardStats indexShardStats : entry.getValue()) {
                    this.statsByIndex = createStatsByIndex(statsByShard);
     * stats and return only the information that is required while returning to the client.
 * Unless required by applicable law or agreed to in writing,
                    this.statsByShard = statsByShard;
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
            if (in.readBoolean()) {
     * Note - we are picking the first level as multiple levels are not supported in the previous versions.
        }
    @Nullable
                    + "] or ["  
        }
 *
        return stats.getGet();
 * ownership. Elasticsearch licenses this file to you under  
     * Without passing the information of the levels to the constructor, we return the Node-level aggregated stats as  
    @Nullable
    @Nullable
        if (this.stats.search != null) {
        if (!isLevelValid) {  
                    stats.add(shardStats.getStats());  
                statsByIndex = createStatsByIndex(statsByShard);
            }
import org.opensearch.Version;
     * {@link CommonStats} along with a hash-map containing Index to List of Shard Stats.
        return stats.getWarmer();  
        return stats.getRefresh();
    @Nullable
        if (in.getVersion().onOrAfter(Version.V_3_4_0)) {
        }
        // make a total common stats from old ones and current ones
            }  
import java.util.ArrayList;  
            this.restName = restName;  
        return builder;  
import org.opensearch.index.fielddata.FieldDataStats;  
            switch (level) {  
            out.writeVInt(statsByShard.size());
        return stats.getIndexing();  
        SearchRequestStats searchRequestStats,
        if (in.readBoolean()) {  
 *  
 * The OpenSearch Contributors require contributions made to  
    public NodeIndicesStats(
            if (in.readBoolean()) {
            for (IndexShardStats indexShardStats : shardStatsList) {
        for (List<IndexShardStats> shardStatsList : statsByShard.values()) {  
        }
        this.statusCounterStats = statusCounterStats;
    /**
        return statsByShard;  
    }  
        builder.endObject();
        StatusCounterStats statusCounterStats
            statsByShard.put(index, indexShardStats);
                    builder.endObject().endObject();
@PublicApi(since = "1.0.0")  
                    stats.add(shardStats.getStats());  
        return stats.getTranslog();  
    }
            for (IndexShardStats indexShardStats : shardStatsList) {
     */
        this.statsByShard = statsByShard;
    public SegmentsStats getSegments() {  
                    + StatsLevel.SHARDS.getRestName()
    @Nullable  
    public NodeIndicesStats(CommonStats oldStats, Map<Index, List<IndexShardStats>> statsByShard, SearchRequestStats searchRequestStats) {
    public RefreshStats getRefresh() {
    }
        }  
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
            out.writeBoolean(statusCounterStats != null);  
                builder.startArray(entry.getKey().getName());
        for (List<IndexShardStats> shardStatsList : statsByShard.values()) {  
        }
    /**  
                .filter(field -> field.getRestName().equals(levels[0]))  
        this.statusCounterStats = statusCounterStats;  
        }
                }
        CommonStats oldStats,
import org.opensearch.action.admin.indices.stats.StatusCounterStats;
            for (int j = 0; j < indexShardListSize; j++) {
            throw new IllegalArgumentException(
            for (Map.Entry<Index, List<IndexShardStats>> entry : statsByShard.entrySet()) {
 * under the License.  
                statusCounterStats = new StatusCounterStats(in);  
        if (this.stats.search != null) {
    private void writeStatsByIndex(StreamOutput out) throws IOException {
    @Nullable
    }
            return null;
     * Passing the level information to the nodes allows us to aggregate the stats based on the level passed. This
        // make a total common stats from old ones and current ones
import org.opensearch.index.store.StoreStats;  
        if (StatsLevel.INDICES.getRestName().equals(level)) {  
                + "] field";  
    public MergeStats getMerge() {
                    + StatsLevel.INDICES.getRestName()  
    }
        // NodeIndicesStats should be.
            }
 * KIND, either express or implied.  See the License for the
        this.stats = oldStats;
import org.opensearch.index.cache.query.QueryCacheStats;  
        int indexEntries = in.readVInt();  
    public QueryCacheStats getQueryCache() {  
import org.opensearch.common.annotation.PublicApi;
        this.stats = oldStats;
        // make a total common stats from old ones and current ones
     */
     * Without passing the information of the levels to the constructor, we return the Node-level aggregated stats as
            if (statsByIndex == null) {
    }  
    ) {  
    public enum StatsLevel {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
        return stats.getCompletion();
    public WarmerStats getWarmer() {
    @Nullable
        }  
            }
                }
        this.stats = oldStats;
 * Global information on indices stats running on a specific node.
                case INDICES:
    public StatusCounterStats getStatusCounterStats() {  
                "level parameter must be one of ["
import org.opensearch.index.merge.MergeStats;  
import org.opensearch.action.admin.indices.stats.ShardStats;
        stats = new CommonStats(in);
     * stats and return only the information that is required while returning to the client.
        out.writeBoolean(statsByShard != null);  
    }  
    /**
    public NodeIndicesStats(
        return stats.getFieldData();
            for (IndexShardStats indexShardStats : shardStatsList) {
    /**
    public IndexingStats getIndexing() {
                    statsMap.get(entry.getKey()).add(shardStats.getStats());  
 */  
        SHARDS("shards"),  
     * {@link CommonStats} along with a hash-map containing Index to List of Shard Stats and the StatusCounterStats.
    public static StatsLevel getAcceptedLevel(String[] levels) {  
    }
import org.opensearch.index.translog.TranslogStats;
        if (statsByShard == null) {  
 */
    private Map<Index, CommonStats> readStatsByIndex(StreamInput in) throws IOException {
import org.opensearch.action.admin.indices.stats.IndexShardStats;  
                for (ShardStats shardStats : indexShardStats.getShards()) {
                    break;  
    }  
            switch (level) {
     * @return Corresponding identified enum {@link StatsLevel}
            statusCounterStats.toXContent(builder, params);  
import org.opensearch.action.admin.indices.stats.CommonStats;
            }
     *  
                for (ShardStats shardStats : indexShardStats.getShards()) {
    }
        }  
import org.opensearch.search.suggest.completion.CompletionStats;  
        return stats.getMerge();  
    }
                    + level  
        }  
import org.opensearch.index.refresh.RefreshStats;
        StatsLevel level
import org.opensearch.index.recovery.RecoveryStats;
     * Fields used for parsing and toXContent
    }
    }
            for (Map.Entry<Index, CommonStats> entry : statsByIndex.entrySet()) {  
                    this.statsByIndex = createStatsByIndex(statsByShard);  
        StatsLevel level
     *  
        if (levels != null && levels.length > 0) {
        }
        }
        } else {
            statsByShard = readStatsByShard(in);
                }
    private void writeStatsByShards(StreamOutput out) throws IOException {
    protected StatusCounterStats statusCounterStats;
                for (ShardStats shardStats : indexShardStats.getShards()) {
     * By default, the levels passed from the transport action will be a list of strings, since NodeIndicesStats can  
            );
     */
 *  
    public GetStats getGet() {
            for (Map.Entry<Index, List<IndexShardStats>> entry : statsByShard.entrySet()) {  
import org.opensearch.core.common.io.stream.StreamOutput;
 * You may obtain a copy of the License at  
            List<IndexShardStats> indexShardStats = new ArrayList<>(indexShardListSize);  
            }
    }
    @Deprecated(since = "3.4.0")  
        NODE("node");
    @Override  
                for (ShardStats shardStats : indexShardStats.getShards()) {
        }  
                    }  
                builder.endObject();  
