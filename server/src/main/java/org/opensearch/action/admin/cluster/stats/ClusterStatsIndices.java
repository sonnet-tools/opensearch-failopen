        int maxIndexShards = -1;
                        if (indicesMetrics.contains(IndexMetric.DOCS)) {  
    }  
        }
            static final String MAX = "max";  
            return this.minIndexShards;
        /**
import java.util.Set;
                        indexShardStats = new ShardStats(entry.getValue());
    }
    private CompletionStats completion;  
         */  
        /**
         * average number of shards (primary+replicas) across the indices
        }
        /**
        }
        @Override  
        if (docs != null) {  
            static final String AVG = "avg";
        for (ClusterStatsNodeResponse r : nodeResponses) {  
                    .entrySet()) {
            builder.startObject(Fields.SHARDS);
        if (analysis != null) {  
         */  
        }  
                }
            return this.maxIndexPrimaryShards;  
                builder.startObject(Fields.INDEX);  
        }
        static final String COUNT = "count";  
        // min/max  
 *     http://www.apache.org/licenses/LICENSE-2.0
        int minIndexShards = -1;
        public int getPrimaries() {  
        return analysis;  
         * the minimum number of primary shards an index has
                    if (indicesMetrics.contains(IndexMetric.COMPLETION)) {
        AnalysisStats analysisStats
         * Inner Fields used for creating XContent and parsing
         */
 * not use this file except in compliance with the License.
            static final String INDEX = "index";
    /**  
                shards.addIndexShardCount(indexCountsCursor);  
        int indices;
    }
                minIndexPrimaryShards = Math.min(minIndexPrimaryShards, indexShardCount.primaries);
import org.opensearch.core.xcontent.XContentBuilder;
     *
        double minIndexReplication = -1;
            return this.maxIndexShards;  
        public int getMinIndexShards() {  
    }
        public double getAvgIndexPrimaryShards() {
        }  
        /**  
    private int indexCount;  
 * The OpenSearch Contributors require contributions made to  
    static final class Fields {
            shards = new ShardStats();
            if (r.getAggregatedNodeLevelStats() != null) {
            completion.toXContent(builder, params);
            static final String PRIMARIES = "primaries";  
                minIndexShards = Math.min(minIndexShards, indexShardCount.total);
import org.opensearch.index.shard.DocsStats;  
        public ShardStats() {}  
    public DocsStats getDocs() {
 *  
            analysis.toXContent(builder, params);
                maxIndexPrimaryShards = indexShardCount.primaries;
            return ((double) this.primaries) / this.indices;
     * @opensearch.api  
        }
                        segments.add(shardCommonStats.segments);
    }
            builder.field(Fields.AVG, avg);
            if (this.indices == 0) {
        public int getIndices() {
        }
            this.totalIndexReplication += indexShardCount.getReplication();  
        }
            this.primaries += indexShardCount.primaries;
                }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        public int getMaxIndexPrimaryShards() {
    ) {  
                addIntMinMax(Fields.PRIMARIES, minIndexPrimaryShards, maxIndexPrimaryShards, getAvgIndexPrimaryShards(), builder);
    public FieldDataStats getFieldData() {  
    private DocsStats docs;
            builder.field(Fields.MAX, max);
        this.store = indicesMetrics.contains(IndexMetric.STORE) ? new StoreStats() : null;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    queryCache.add(r.getAggregatedNodeLevelStats().commonStats.queryCache);
        private void addDoubleMinMax(String field, double min, double max, double avg, XContentBuilder builder) throws IOException {
        if (queryCache != null) {  
        double maxIndexReplication = -1;
        }
         * the minimum number of shards (primary+replicas) an index has
            static final String TOTAL = "total";
                addDoubleMinMax(Fields.REPLICATION, minIndexReplication, maxIndexReplication, getAvgIndexReplication(), builder);  
            builder.field(Fields.MIN, min);  
    public QueryCacheStats getQueryCache() {
                if (indicesMetrics.contains(IndexMetric.QUERY_CACHE)) {  
        /**  
 * software distributed under the License is distributed on an
    private SegmentsStats segments;
    private StoreStats store;  
         * the average number primary shards across the indices
import java.io.IOException;
            if (this.indices == 1) {
 * KIND, either express or implied.  See the License for the
            if (indices == 0) {
                    if (indexShardStats == null) {
        }  
import org.opensearch.common.annotation.PublicApi;  
        MappingStats mappingStats,
        public String toString() {
        }
    public static class ShardStats implements ToXContentFragment {  
        return queryCache;
        }
            builder.startObject(field);  
            builder.field(Fields.AVG, avg);  
        Map<String, ShardStats> countsPerIndex = new HashMap<>();
                minIndexReplication = Math.min(minIndexReplication, indexShardCount.getReplication());  
                for (org.opensearch.action.admin.indices.stats.ShardStats shardStats : r.shardsStats()) {
            docs.toXContent(builder, params);
     */
         *  
        }
            return this.indices;
        List<ClusterStatsNodeResponse> nodeResponses,  
         */
    @Override  
            return this.maxIndexReplication;
     * Inner Shard Stats
 * specific language governing permissions and limitations
        double totalIndexReplication = 0;  
     * @opensearch.internal  
            } else {  
                return 0;  
                maxIndexShards = indexShardCount.total;  
        if (completion != null) {  
    }
         */
                minIndexPrimaryShards = indexShardCount.primaries;  
        /**  
        this.completion = indicesMetrics.contains(IndexMetric.COMPLETION) ? new CompletionStats() : null;  
            } else {  
            this.indices++;  
                    }  
 * Cluster Stats per index
         * number of indices in the cluster
import org.opensearch.action.admin.indices.stats.CommonStats;
        }  
}  
                        fieldData.add(shardCommonStats.fieldData);
         */
         */  
            }
            return this.primaries;
            this.primaries = aggregatedIndexStats.primaries;
         * average replication factor across the indices. See {@link #getReplication}
        }
                        store.add(shardCommonStats.store);
         */  
 * Unless required by applicable law or agreed to in writing,
        /**
        builder.field(Fields.COUNT, indexCount);
            }  
         * returns how many *redundant* copies of the data the cluster holds - running with no replicas will return 0
            return ((double) this.total) / this.indices;
        if (shards != null) {  
import org.opensearch.index.cache.query.QueryCacheStats;  
     */
        if (fieldData != null) {  
        indexCount = countsPerIndex.size();
                    store.add(r.getAggregatedNodeLevelStats().commonStats.store);
        }
                    } else {
            if (this.indices == 0) {
            builder.field(Fields.MIN, min);
/*  
 * GitHub history for details.
         * total number of shards in the cluster  
        }  
            return this.total;  
        this.mappings = mappingStats;
                    indexShardStats.total++;  
import org.opensearch.index.store.StoreStats;
import java.util.Map;
         * the maximum number of primary shards an index has  
                if (indicesMetrics.contains(IndexMetric.DOCS)) {  
        int total;  
        public double getReplication() {
            return this.totalIndexReplication / this.indices;
            return builder;
                        queryCache.add(shardCommonStats.queryCache);
                addIntMinMax(Fields.SHARDS, minIndexShards, maxIndexShards, getAvgIndexShards(), builder);
            static final String REPLICATION = "replication";
 * SPDX-License-Identifier: Apache-2.0
                    if (indicesMetrics.contains(IndexMetric.FIELDDATA)) {
            return this.minIndexReplication;  
         * @opensearch.internal
        /**
            }
                    if (shardStats.getShardRouting().primary()) {
        this(Set.of(IndexMetric.values()), nodeResponses, mappingStats, analysisStats);  
        }  
import org.opensearch.search.suggest.completion.CompletionStats;
        }  
                    }  
    }  
                if (indicesMetrics.contains(IndexMetric.SEGMENTS)) {  
        }  
    /**  
                    if (indicesMetrics.contains(IndexMetric.QUERY_CACHE)) {
 * license agreements. See the NOTICE file distributed with
            return this.minIndexPrimaryShards;
            }
 *
        }
        private void addIntMinMax(String field, int min, int max, double avg, XContentBuilder builder) throws IOException {
         */
                    }  
            return "total [" + total + "] primaries [" + primaries + "]";  
                }
 * the Apache License, Version 2.0 (the "License"); you may
        this.analysis = analysisStats;
        /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
                    }  
        public double getAvgIndexReplication() {  
 *  
        Set<IndexMetric> indicesMetrics,
                        indexShardStats = new ShardStats();
        int primaries;
                builder.field(Fields.REPLICATION, getReplication());
                    if (indexShardStats == null) {
public class ClusterStatsIndices implements ToXContentFragment {
    public int getIndexCount() {
     * Inner Fields used for creating XContent and parsing
         * minimum replication factor across the indices. See {@link #getReplication}  
            builder.endObject();  
                    }  
                minIndexReplication = indexShardCount.getReplication();
         * total number of primary shards in the cluster
                }
        }
                if (indicesMetrics.contains(IndexMetric.STORE)) {  
                    CommonStats shardCommonStats = shardStats.getStats();
import java.util.HashMap;
        }
        this.segments = indicesMetrics.contains(IndexMetric.SEGMENTS) ? new SegmentsStats() : null;
/*  
/*
                maxIndexReplication = minIndexReplication;
 * compatible open source license.
            }
    }  
            this.total += incomingStats.total;  
                        }
            this.total += indexShardCount.total;
        return fieldData;
    }
                }
            segments.toXContent(builder, params);
 * Licensed to Elasticsearch under one or more contributor  
        return docs;
                return -1;  
         * maximum replication factor across the indices. See {@link #getReplication}
            builder.startObject(field);
        this.queryCache = indicesMetrics.contains(IndexMetric.QUERY_CACHE) ? new QueryCacheStats() : null;
    }  
        public double getMaxIndexReplication() {
    private FieldDataStats fieldData;
 */  
    public ShardStats getShards() {  
         */
                    }  
        }
                maxIndexPrimaryShards = Math.max(maxIndexPrimaryShards, indexShardCount.primaries);  
                    ShardStats indexShardStats = countsPerIndex.get(entry.getKey());  
         */
        if (segments != null) {  
                // Default response from the node
                        countsPerIndex.put(shardStats.getShardRouting().getIndexName(), indexShardStats);  
            if (primaries == 0) {
            }
 */  
        static final class Fields {  
        return completion;  
        return builder;  
         */  
        this.docs = indicesMetrics.contains(IndexMetric.DOCS) ? new DocsStats() : null;
            shards.toXContent(builder, params);
    public MappingStats getMappings() {
    }
        }
            mappings.toXContent(builder, params);
 * ownership. Elasticsearch licenses this file to you under  
        int maxIndexPrimaryShards = -1;
        if (indicesMetrics.contains(IndexMetric.SHARDS)) {  
    public SegmentsStats getSegments() {  
import java.util.List;  
 * Modifications Copyright OpenSearch Contributors. See
 */
                    if (indicesMetrics.contains(IndexMetric.STORE)) {
        }
                    ShardStats indexShardStats = countsPerIndex.get(shardStats.getShardRouting().getIndexName());  
        if (mappings != null) {  
    @PublicApi(since = "1.0.0")
         */
            for (final ShardStats indexCountsCursor : countsPerIndex.values()) {
    private QueryCacheStats queryCache;
                maxIndexShards = Math.max(maxIndexShards, indexShardCount.total);
        }
                builder.field(Fields.TOTAL, total);
     *
            store.toXContent(builder, params);
        return store;  
                builder.field(Fields.PRIMARIES, primaries);  
                    if (indicesMetrics.contains(IndexMetric.SEGMENTS)) {
import org.opensearch.index.engine.SegmentsStats;
                    }  
    public CompletionStats getCompletion() {
        return indexCount;  
            }
    private AnalysisStats analysis;
/**
                minIndexShards = indexShardCount.total;
            }
                for (Map.Entry<String, ClusterStatsNodeResponse.AggregatedIndexStats> entry : r.getAggregatedNodeLevelStats().indexStatsMap
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest.IndexMetric;
        }
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.action.admin.cluster.stats;
        return segments;
        public int getTotal() {
            return (((double) (total - primaries)) / primaries);
            builder.field(Fields.MAX, max);
            builder.endObject();  
        /**  
            fieldData.toXContent(builder, params);
                maxIndexReplication = Math.max(maxIndexReplication, indexShardCount.getReplication());
    }
        return this.shards;
            static final String MIN = "min";
                    }
    public ClusterStatsIndices(List<ClusterStatsNodeResponse> nodeResponses, MappingStats mappingStats, AnalysisStats analysisStats) {
        }
        int minIndexPrimaryShards = -1;  
         * the maximum number of shards (primary+replicas) an index has  
                if (indicesMetrics.contains(IndexMetric.COMPLETION)) {  
        }
    private ShardStats shards;
                    completion.add(r.getAggregatedNodeLevelStats().commonStats.completion);
    }
        @Override
                        indexShardStats.primaries++;
 * under the License.  
        /**
    private MappingStats mappings;  
        /**
                builder.endObject();
        if (store != null) {  
                        completion.add(shardCommonStats.completion);
                        indexShardStats.addStatsFrom(entry.getValue());
    }
@PublicApi(since = "1.0.0")  
            static final String SHARDS = "shards";
                            docs.add(shardCommonStats.docs);
        return mappings;
            this.primaries += incomingStats.primaries;
                }
 */
                return -1;
import org.opensearch.index.fielddata.FieldDataStats;
                    docs.add(r.getAggregatedNodeLevelStats().commonStats.docs);
                // first index, uninitialized.
            this.total = aggregatedIndexStats.total;  
            builder.endObject();
        }
                }
        public ShardStats(ClusterStatsNodeResponse.AggregatedIndexStats aggregatedIndexStats) {
            if (indices > 0) {  
        /**
        public int getMinIndexPrimaryShards() {  
    public ClusterStatsIndices(
    public AnalysisStats getAnalysis() {
        public int getMaxIndexShards() {
            queryCache.toXContent(builder, params);
 * @opensearch.api
         */
        public void addStatsFrom(ClusterStatsNodeResponse.AggregatedIndexStats incomingStats) {
 *
        public double getAvgIndexShards() {
                    fieldData.add(r.getAggregatedNodeLevelStats().commonStats.fieldData);
                    segments.add(r.getAggregatedNodeLevelStats().commonStats.segments);
        /**
 * this work for additional information regarding copyright
        public void addIndexShardCount(ShardStats indexShardCount) {
                        countsPerIndex.put(entry.getKey(), indexShardStats);  
        this.fieldData = indicesMetrics.contains(IndexMetric.FIELDDATA) ? new FieldDataStats() : null;
        public double getMinIndexReplication() {
                return -1;  
                if (indicesMetrics.contains(IndexMetric.FIELDDATA)) {  
    public StoreStats getStore() {
import org.opensearch.core.xcontent.ToXContentFragment;
 * You may obtain a copy of the License at  
    }
            // Aggregated response from the node
