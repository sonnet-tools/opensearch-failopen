        }
/*
    private CommonStats primary = null;
        int totalShards,
            return primary;  
            for (ShardStats ss : shards) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
            }
            builder.endObject();
                    builder.startObject(Fields.SHARDS);  
        getTotal().toXContent(builder, params);
        }  
        total = stats;
            for (IndexStats indexStats : getIndices().values()) {  
                builder.startObject(indexStats.getIndex());
    protected void addCustomXContentFields(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
     * @opensearch.internal  
    @Override  
        if (this.shardStatsMap == null) {  
                k -> new IndexStatsBuilder(k, index.getUUID())
        return getIndices().get(index);
import java.io.IOException;
            this.shardStatsMap = unmodifiableMap(shardStatsMap);
    }  
}  
        builder.startObject("_all");
        super(totalShards, successfulShards, failedShards, shardFailures);
/**
            .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().build()));
import org.opensearch.common.annotation.PublicApi;
            stats.add(shard.getStats());
            }  
                    for (IndexShardStats indexShardStats : indexStats) {
    }  
        CommonStats stats = new CommonStats();
                indexStats.getPrimaries().toXContent(builder, params);
        }
        for (ShardStats shard : shards) {
    private ShardStats[] shards;  
            builder.startObject(Fields.INDICES);
                    builder.endObject();
        }
    private CommonStats total = null;  
        return stats;  
    }
 * KIND, either express or implied.  See the License for the
        return Strings.toString(MediaTypeRegistry.JSON, this, true, false);  
import java.util.stream.Collectors;  
                            shardStats.toXContent(builder, params);
 *  
 *
 * GitHub history for details.
            IndexStatsBuilder indexStatsBuilder = indexToIndexStatsBuilder.computeIfAbsent(
    private Map<ShardRouting, ShardStats> shardStatsMap;
            || "indices".equalsIgnoreCase(level)
        return indicesStats;  
                shardStatsMap.put(ss.getShardRouting(), ss);  
        final Map<String, IndexStatsBuilder> indexToIndexStatsBuilder = new HashMap<>();
                index.getName(),  
            || "shards".equalsIgnoreCase(level);
    public String toString() {
 *  
        for (ShardStats shard : shards) {  
import org.opensearch.core.common.Strings;  
        builder.endObject();
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super.writeTo(out);
    public void writeTo(StreamOutput out) throws IOException {
 * You may obtain a copy of the License at  
    public IndicesStatsResponse(StreamInput in) throws IOException {
import java.util.Collections;
 * specific language governing permissions and limitations
@PublicApi(since = "1.0.0")  
 * this work for additional information regarding copyright
 * Transport response for retrieving indices stats
                builder.startObject("total");
            );
                        builder.endArray();
        }
        if (!isLevelValid) {  
 */  
 * @opensearch.api
 */
    public static IndicesStatsResponse getEmptyResponse() {  
    }
    public Map<ShardRouting, ShardStats> asMap() {
import java.util.Map;
        getPrimaries().toXContent(builder, params);
import org.opensearch.action.support.broadcast.BroadcastResponse;
 */  
 * the Apache License, Version 2.0 (the "License"); you may
            Index index = shard.getShardRouting().index();
        builder.startObject("primaries");  
 * ownership. Elasticsearch licenses this file to you under  
        super(in);
            return total;
    }
    }  
    @Override
                        }
    public IndexStats getIndex(String index) {  
 * SPDX-License-Identifier: Apache-2.0
    }
                        for (ShardStats shardStats : indexShardStats) {  
        if (total != null) {  
        for (ShardStats shard : shards) {  
        }
        this.shards = shards;
 */
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
        return shards[position];  
                            builder.startObject();
        }  
        final String level = params.param("level", "indices");
    }
import java.util.HashMap;  
/*  
        }  
                stats.add(shard.getStats());
import org.opensearch.action.admin.indices.stats.IndexStats.IndexStatsBuilder;
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
 *     http://www.apache.org/licenses/LICENSE-2.0
                builder.endObject();  
    static final class Fields {
        shards = in.readArray(ShardStats::new, (size) -> new ShardStats[size]);  
package org.opensearch.action.admin.indices.stats;
                }
                builder.startObject("primaries");  
 * under the License.  
            }
        if (primary != null) {
    }
     *
        builder.endObject();  
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.core.index.Index;  
        out.writeArray(shards);  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.routing.ShardRouting;  
        return this.shards;
    }
    private Map<String, IndexStats> indicesStats;
        builder.endObject();
        builder.startObject("total");
        if ("indices".equalsIgnoreCase(level) || "shards".equalsIgnoreCase(level)) {
        static final String INDICES = "indices";  
        primary = stats;
 * Unless required by applicable law or agreed to in writing,
            return indicesStats;
    public ShardStats getAt(int position) {
    public Map<String, IndexStats> getIndices() {  
                            builder.endObject();  
 * not use this file except in compliance with the License.
    public IndicesStatsResponse(  
    public CommonStats getTotal() {
    }
        final boolean isLevelValid = "cluster".equalsIgnoreCase(level)  
        CommonStats stats = new CommonStats();  
 *
        return stats;
    }
import static java.util.Collections.unmodifiableMap;
    ) {  
                builder.field("uuid", indexStats.getUuid());
        List<DefaultShardOperationFailedException> shardFailures
        indicesStats = indexToIndexStatsBuilder.entrySet()  
                builder.endObject();
import java.util.List;
public class IndicesStatsResponse extends BroadcastResponse {
            .stream()
        int failedShards,
    }
        int successfulShards,  
                indexStats.getTotal().toXContent(builder, params);
     * Fields for parsing and toXContent
    /**  
            Map<ShardRouting, ShardStats> shardStatsMap = new HashMap<>();
                        builder.startArray(Integer.toString(indexShardStats.getShardId().id()));
            throw new IllegalArgumentException("level parameter must be one of [cluster] or [indices] or [shards] but was [" + level + "]");
    public CommonStats getPrimaries() {
        ShardStats[] shards,
        static final String SHARDS = "shards";
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
            if (shard.getShardRouting().primary()) {
        if (indicesStats != null) {
 * license agreements. See the NOTICE file distributed with
                builder.endObject();  
        return this.shardStatsMap;
                    }  
                if ("shards".equalsIgnoreCase(level)) {
            indexStatsBuilder.add(shard);  
import org.opensearch.core.common.io.stream.StreamOutput;
 * compatible open source license.
import org.opensearch.core.xcontent.XContentBuilder;
        return new IndicesStatsResponse(new ShardStats[0], 0, 0, 0, Collections.emptyList());
    public ShardStats[] getShards() {
        }  
     */
