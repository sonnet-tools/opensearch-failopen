            segments.toXContent(builder, params);
        // min/max
                addIntMinMax(Fields.PRIMARIES, minIndexPrimaryShards, maxIndexPrimaryShards, getAvgIndexPrimaryShards(), builder);
         *
        return mappings;
        }
        int minIndexPrimaryShards = -1;
}
                minIndexPrimaryShards = Math.min(minIndexPrimaryShards, indexShardCount.primaries);
    }
                            docs.add(shardCommonStats.docs);
                if (indicesMetrics.contains(IndexMetric.COMPLETION)) {
        public double getMinIndexReplication() {
        }
                }
 *
        public int getMaxIndexShards() {
                        }
        List<ClusterStatsNodeResponse> nodeResponses,
            } else {
 * GitHub history for details.
            static final String AVG = "avg";
 *
 */
                    } else {
         * @opensearch.internal
            this.total = aggregatedIndexStats.total;
         * returns how many *redundant* copies of the data the cluster holds - running with no replicas will return 0
            // Aggregated response from the node
    public MappingStats getMappings() {
        private void addDoubleMinMax(String field, double min, double max, double avg, XContentBuilder builder) throws IOException {
        if (shards != null) {
        }
         * minimum replication factor across the indices. See {@link #getReplication}
            return this.minIndexShards;
                }
            return this.maxIndexReplication;
                maxIndexPrimaryShards = indexShardCount.primaries;
            builder.field(Fields.MIN, min);
                        segments.add(shardCommonStats.segments);
         */
         * the maximum number of primary shards an index has
        public int getMinIndexPrimaryShards() {
                }
            this.primaries += incomingStats.primaries;
     *
                        countsPerIndex.put(shardStats.getShardRouting().getIndexName(), indexShardStats);
            static final String REPLICATION = "replication";
 *
        public int getIndices() {
        MappingStats mappingStats,
            builder.startObject(Fields.SHARDS);
 * You may obtain a copy of the License at
        /**
        /**
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
        this.analysis = analysisStats;
        /**
            shards.toXContent(builder, params);
    public StoreStats getStore() {
import java.io.IOException;
                // first index, uninitialized.
            if (this.indices == 0) {
        }
                if (indicesMetrics.contains(IndexMetric.QUERY_CACHE)) {
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.store.StoreStats;
 *
     * @opensearch.api
            if (this.indices == 0) {
     * @opensearch.internal
    public ClusterStatsIndices(
            builder.startObject(field);
import org.opensearch.core.xcontent.ToXContentFragment;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        /**
    public SegmentsStats getSegments() {
        }
                    if (shardStats.getShardRouting().primary()) {
            return this.primaries;
                minIndexPrimaryShards = indexShardCount.primaries;
        /**
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * Unless required by applicable law or agreed to in writing,
            if (primaries == 0) {
         * total number of primary shards in the cluster
    private int indexCount;
            if (r.getAggregatedNodeLevelStats() != null) {
 * software distributed under the License is distributed on an
            return this.minIndexReplication;
                minIndexReplication = indexShardCount.getReplication();
        }
        this.docs = indicesMetrics.contains(IndexMetric.DOCS) ? new DocsStats() : null;
                        fieldData.add(shardCommonStats.fieldData);
    public int getIndexCount() {
        public double getReplication() {
        if (docs != null) {
         */
                    }
                    }
        /**
    }
            shards = new ShardStats();
 * under the License.
 * this file be licensed under the Apache-2.0 license or a
                addDoubleMinMax(Fields.REPLICATION, minIndexReplication, maxIndexReplication, getAvgIndexReplication(), builder);
        return queryCache;
            completion.toXContent(builder, params);
         */
        return completion;
        int minIndexShards = -1;
    }
/*
                builder.field(Fields.TOTAL, total);
        }
                    }
import java.util.Set;
        /**
        }
         */
    @PublicApi(since = "1.0.0")
@PublicApi(since = "1.0.0")
         */
    @Override
        double maxIndexReplication = -1;
        return store;
            }
            static final String MIN = "min";
                    indexShardStats.total++;
    public AnalysisStats getAnalysis() {
                    }
    private FieldDataStats fieldData;
public class ClusterStatsIndices implements ToXContentFragment {
    private QueryCacheStats queryCache;
        }
            static final String SHARDS = "shards";
    private SegmentsStats segments;
                    if (indexShardStats == null) {
        AnalysisStats analysisStats
    }
import java.util.HashMap;
        }
            return ((double) this.primaries) / this.indices;
            docs.toXContent(builder, params);
                addIntMinMax(Fields.SHARDS, minIndexShards, maxIndexShards, getAvgIndexShards(), builder);
        }
            if (indices == 0) {
        this.store = indicesMetrics.contains(IndexMetric.STORE) ? new StoreStats() : null;
        public double getAvgIndexReplication() {
            this.primaries += indexShardCount.primaries;
    static final class Fields {
        static final class Fields {
import org.opensearch.index.fielddata.FieldDataStats;
        }
            this.primaries = aggregatedIndexStats.primaries;
            return (((double) (total - primaries)) / primaries);
    }
import org.opensearch.search.suggest.completion.CompletionStats;
            }
 * Cluster Stats per index
            builder.endObject();
                        if (indicesMetrics.contains(IndexMetric.DOCS)) {
        double minIndexReplication = -1;
/**
                return -1;
                    if (indicesMetrics.contains(IndexMetric.COMPLETION)) {
                        countsPerIndex.put(entry.getKey(), indexShardStats);
     */
    private AnalysisStats analysis;
        }
 * The OpenSearch Contributors require contributions made to
        public int getTotal() {
    public FieldDataStats getFieldData() {
        if (queryCache != null) {
                        indexShardStats.primaries++;
        }
            for (final ShardStats indexCountsCursor : countsPerIndex.values()) {
        int indices;
import java.util.List;
            mappings.toXContent(builder, params);
        }
         */
                    fieldData.add(r.getAggregatedNodeLevelStats().commonStats.fieldData);
    }
    }
    }
    private ShardStats shards;
                for (Map.Entry<String, ClusterStatsNodeResponse.AggregatedIndexStats> entry : r.getAggregatedNodeLevelStats().indexStatsMap
        if (indicesMetrics.contains(IndexMetric.SHARDS)) {
            return this.maxIndexPrimaryShards;
        /**
         */
         */
                builder.startObject(Fields.INDEX);
        if (analysis != null) {
        for (ClusterStatsNodeResponse r : nodeResponses) {
         * Inner Fields used for creating XContent and parsing
            }
                }
         * the minimum number of shards (primary+replicas) an index has
                builder.endObject();
 *     http://www.apache.org/licenses/LICENSE-2.0
    public ClusterStatsIndices(List<ClusterStatsNodeResponse> nodeResponses, MappingStats mappingStats, AnalysisStats analysisStats) {
        }
         * total number of shards in the cluster
                minIndexReplication = Math.min(minIndexReplication, indexShardCount.getReplication());
    public ShardStats getShards() {
        if (segments != null) {
        /**
    /**
                    queryCache.add(r.getAggregatedNodeLevelStats().commonStats.queryCache);
        this.fieldData = indicesMetrics.contains(IndexMetric.FIELDDATA) ? new FieldDataStats() : null;
                }
 * @opensearch.api
                    ShardStats indexShardStats = countsPerIndex.get(entry.getKey());
                maxIndexReplication = minIndexReplication;
import org.opensearch.index.cache.query.QueryCacheStats;
                        queryCache.add(shardCommonStats.queryCache);
        /**
        if (mappings != null) {
    private StoreStats store;
                builder.field(Fields.REPLICATION, getReplication());
        }
        }
                        indexShardStats = new ShardStats(entry.getValue());
/*
                    if (indicesMetrics.contains(IndexMetric.FIELDDATA)) {
                for (org.opensearch.action.admin.indices.stats.ShardStats shardStats : r.shardsStats()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * this work for additional information regarding copyright
        indexCount = countsPerIndex.size();
            return builder;
                    if (indicesMetrics.contains(IndexMetric.SEGMENTS)) {
 */
                    if (indexShardStats == null) {
    public CompletionStats getCompletion() {
        private void addIntMinMax(String field, int min, int max, double avg, XContentBuilder builder) throws IOException {
import org.opensearch.common.annotation.PublicApi;
    public DocsStats getDocs() {
        return docs;
                    .entrySet()) {
import org.opensearch.core.xcontent.XContentBuilder;
        /**
                    }
    private DocsStats docs;
            this.indices++;
                    }
            builder.field(Fields.MIN, min);
        public int getPrimaries() {
import org.opensearch.index.shard.DocsStats;
            }
        this.completion = indicesMetrics.contains(IndexMetric.COMPLETION) ? new CompletionStats() : null;
         */
         * number of indices in the cluster
            static final String PRIMARIES = "primaries";
        if (fieldData != null) {
     *
         * the maximum number of shards (primary+replicas) an index has
            if (indices > 0) {
                    }
         */
        return segments;
                shards.addIndexShardCount(indexCountsCursor);
         */
 * ownership. Elasticsearch licenses this file to you under
            static final String MAX = "max";
         */
         */
            builder.startObject(field);
        }
        int total;
                    completion.add(r.getAggregatedNodeLevelStats().commonStats.completion);
        /**
            this.total += indexShardCount.total;
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest.IndexMetric;
                    docs.add(r.getAggregatedNodeLevelStats().commonStats.docs);
        public void addStatsFrom(ClusterStatsNodeResponse.AggregatedIndexStats incomingStats) {
        public void addIndexShardCount(ShardStats indexShardCount) {
 * specific language governing permissions and limitations
                return 0;
 * not use this file except in compliance with the License.
         * average replication factor across the indices. See {@link #getReplication}
            return this.totalIndexReplication / this.indices;
                        indexShardStats = new ShardStats();
        }
                        indexShardStats.addStatsFrom(entry.getValue());
            static final String TOTAL = "total";
    }
        }
        }
        }
        public double getAvgIndexShards() {
/*
        double totalIndexReplication = 0;
    /**
         */
         * average number of shards (primary+replicas) across the indices
                }
        if (completion != null) {
            return this.maxIndexShards;
        this.queryCache = indicesMetrics.contains(IndexMetric.QUERY_CACHE) ? new QueryCacheStats() : null;
        static final String COUNT = "count";
        @Override
     */
                        completion.add(shardCommonStats.completion);
            builder.field(Fields.MAX, max);
        public ShardStats() {}
        }
import org.opensearch.action.admin.indices.stats.CommonStats;
        public int getMaxIndexPrimaryShards() {
                return -1;
                minIndexShards = indexShardCount.total;
                maxIndexShards = indexShardCount.total;
import org.opensearch.index.engine.SegmentsStats;
            }
        Set<IndexMetric> indicesMetrics,
                if (indicesMetrics.contains(IndexMetric.STORE)) {
            builder.endObject();
        }
            builder.endObject();
 * SPDX-License-Identifier: Apache-2.0
            return "total [" + total + "] primaries [" + primaries + "]";
        /**
            builder.field(Fields.MAX, max);
        return this.shards;
            analysis.toXContent(builder, params);
    public QueryCacheStats getQueryCache() {
    ) {
    }
    }
        int primaries;
        }
        return indexCount;
    }
        }
                }
            return ((double) this.total) / this.indices;
                        store.add(shardCommonStats.store);
                if (indicesMetrics.contains(IndexMetric.SEGMENTS)) {
            this.total += incomingStats.total;
    }
            if (this.indices == 1) {
package org.opensearch.action.admin.cluster.stats;
            }
            builder.field(Fields.AVG, avg);
                }
    private MappingStats mappings;
        }
            static final String INDEX = "index";
                maxIndexPrimaryShards = Math.max(maxIndexPrimaryShards, indexShardCount.primaries);
        @Override
        return analysis;
        public double getMaxIndexReplication() {
            return this.indices;
        return builder;
            builder.field(Fields.AVG, avg);
import java.util.Map;
            queryCache.toXContent(builder, params);
                maxIndexShards = Math.max(maxIndexShards, indexShardCount.total);
     * Inner Shard Stats
            } else {
        this.segments = indicesMetrics.contains(IndexMetric.SEGMENTS) ? new SegmentsStats() : null;
        int maxIndexPrimaryShards = -1;
                    if (indicesMetrics.contains(IndexMetric.QUERY_CACHE)) {
                minIndexShards = Math.min(minIndexShards, indexShardCount.total);
                    segments.add(r.getAggregatedNodeLevelStats().commonStats.segments);
     * Inner Fields used for creating XContent and parsing
        this.mappings = mappingStats;
                    if (indicesMetrics.contains(IndexMetric.STORE)) {
        /**
 * compatible open source license.
        }
 */
            }
        return fieldData;
                if (indicesMetrics.contains(IndexMetric.DOCS)) {
        public String toString() {
    }
        Map<String, ShardStats> countsPerIndex = new HashMap<>();
            store.toXContent(builder, params);
        public double getAvgIndexPrimaryShards() {
        }
    }
    public static class ShardStats implements ToXContentFragment {
                builder.field(Fields.PRIMARIES, primaries);
            return this.minIndexPrimaryShards;
                    ShardStats indexShardStats = countsPerIndex.get(shardStats.getShardRouting().getIndexName());
                maxIndexReplication = Math.max(maxIndexReplication, indexShardCount.getReplication());
        builder.field(Fields.COUNT, indexCount);
                    store.add(r.getAggregatedNodeLevelStats().commonStats.store);
    private CompletionStats completion;
                if (indicesMetrics.contains(IndexMetric.FIELDDATA)) {
         * the average number primary shards across the indices
        public ShardStats(ClusterStatsNodeResponse.AggregatedIndexStats aggregatedIndexStats) {
        }
        }
                // Default response from the node
            return this.total;
            }
        if (store != null) {
            this.totalIndexReplication += indexShardCount.getReplication();
                return -1;
         * maximum replication factor across the indices. See {@link #getReplication}
                    CommonStats shardCommonStats = shardStats.getStats();
        this(Set.of(IndexMetric.values()), nodeResponses, mappingStats, analysisStats);
 * Modifications Copyright OpenSearch Contributors. See
        int maxIndexShards = -1;
            fieldData.toXContent(builder, params);
                    }
         * the minimum number of primary shards an index has
 */
        public int getMinIndexShards() {
 * Licensed to Elasticsearch under one or more contributor
