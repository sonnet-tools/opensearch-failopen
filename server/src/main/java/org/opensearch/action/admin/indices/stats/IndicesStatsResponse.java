 * under the License.
                }
        return new IndicesStatsResponse(new ShardStats[0], 0, 0, 0, Collections.emptyList());
        for (ShardStats shard : shards) {
            for (IndexStats indexStats : getIndices().values()) {
        }
    @Override
 * this work for additional information regarding copyright
/*
            }
        int totalShards,
 * The OpenSearch Contributors require contributions made to
 * Transport response for retrieving indices stats
 * this file be licensed under the Apache-2.0 license or a
        return stats;
        getTotal().toXContent(builder, params);
    public IndicesStatsResponse(
 * ownership. Elasticsearch licenses this file to you under
    static final class Fields {
        super.writeTo(out);
    }
 */
            || "indices".equalsIgnoreCase(level)
            builder.startObject(Fields.INDICES);
                            builder.endObject();
        return getIndices().get(index);
        List<DefaultShardOperationFailedException> shardFailures
import java.util.stream.Collectors;
    public static IndicesStatsResponse getEmptyResponse() {
    }
        for (ShardStats shard : shards) {
 *
        if (primary != null) {
    }
        return this.shardStatsMap;
import static java.util.Collections.unmodifiableMap;
            if (shard.getShardRouting().primary()) {
                builder.endObject();
    public ShardStats[] getShards() {
                builder.startObject("total");
package org.opensearch.action.admin.indices.stats;
        for (ShardStats shard : shards) {
            for (ShardStats ss : shards) {
            IndexStatsBuilder indexStatsBuilder = indexToIndexStatsBuilder.computeIfAbsent(
                k -> new IndexStatsBuilder(k, index.getUUID())
 * not use this file except in compliance with the License.
            .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().build()));
 * SPDX-License-Identifier: Apache-2.0
            || "shards".equalsIgnoreCase(level);
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 */
 * Unless required by applicable law or agreed to in writing,
        if ("indices".equalsIgnoreCase(level) || "shards".equalsIgnoreCase(level)) {
    }
                        builder.endArray();
 *
        return Strings.toString(MediaTypeRegistry.JSON, this, true, false);
            .stream()
                    for (IndexShardStats indexShardStats : indexStats) {
    private Map<String, IndexStats> indicesStats;
        primary = stats;
        this.shards = shards;
        }
                builder.startObject("primaries");
            stats.add(shard.getStats());
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at
        total = stats;
    public ShardStats getAt(int position) {
    }
            throw new IllegalArgumentException("level parameter must be one of [cluster] or [indices] or [shards] but was [" + level + "]");
        final String level = params.param("level", "indices");
        if (indicesStats != null) {
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
        indicesStats = indexToIndexStatsBuilder.entrySet()
    @Override
    }
        return shards[position];
import org.opensearch.core.index.Index;
    /**
                builder.startObject(indexStats.getIndex());
    private ShardStats[] shards;
/*
/**
     */
        static final String INDICES = "indices";
     * Fields for parsing and toXContent
        builder.startObject("primaries");
    }
        }
    }
 * specific language governing permissions and limitations
            indexStatsBuilder.add(shard);
        super(in);
    }
        shards = in.readArray(ShardStats::new, (size) -> new ShardStats[size]);
import org.opensearch.action.admin.indices.stats.IndexStats.IndexStatsBuilder;
        }
        out.writeArray(shards);
                    builder.startObject(Fields.SHARDS);
        }
import java.util.HashMap;
     * @opensearch.internal
        }
            Index index = shard.getShardRouting().index();
                if ("shards".equalsIgnoreCase(level)) {
        builder.endObject();
    public CommonStats getTotal() {
 * compatible open source license.
        }
/*
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                indexStats.getTotal().toXContent(builder, params);
    }
        if (this.shardStatsMap == null) {
                            builder.startObject();
import java.util.Map;
@PublicApi(since = "1.0.0")
                builder.field("uuid", indexStats.getUuid());
    ) {
        return indicesStats;
 * @opensearch.api
    protected void addCustomXContentFields(XContentBuilder builder, Params params) throws IOException {
                    builder.endObject();
        CommonStats stats = new CommonStats();
 * the Apache License, Version 2.0 (the "License"); you may
                index.getName(),
import org.opensearch.action.support.broadcast.BroadcastResponse;
                shardStatsMap.put(ss.getShardRouting(), ss);
        final Map<String, IndexStatsBuilder> indexToIndexStatsBuilder = new HashMap<>();
    public Map<ShardRouting, ShardStats> asMap() {
import org.opensearch.core.common.io.stream.StreamOutput;
 */
    @Override
import org.opensearch.common.annotation.PublicApi;
    public String toString() {
        }
    }
            );
            return primary;
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.Collections;
                        for (ShardStats shardStats : indexShardStats) {
import java.io.IOException;
        }
                builder.endObject();
        builder.startObject("total");
        super(totalShards, successfulShards, failedShards, shardFailures);
                        }
            }
                builder.endObject();
        builder.startObject("_all");
        builder.endObject();
 * license agreements. See the NOTICE file distributed with
    }
        if (total != null) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public CommonStats getPrimaries() {
 *     http://www.apache.org/licenses/LICENSE-2.0
        int successfulShards,
 *
            }
                indexStats.getPrimaries().toXContent(builder, params);
                        builder.startArray(Integer.toString(indexShardStats.getShardId().id()));
        CommonStats stats = new CommonStats();
        ShardStats[] shards,
                stats.add(shard.getStats());
    }
 */
    }
        static final String SHARDS = "shards";
        getPrimaries().toXContent(builder, params);
import org.opensearch.core.common.Strings;
        return this.shards;
    public IndexStats getIndex(String index) {
        if (!isLevelValid) {
        int failedShards,
import java.util.List;
import org.opensearch.cluster.routing.ShardRouting;
            this.shardStatsMap = unmodifiableMap(shardStatsMap);
            return indicesStats;
public class IndicesStatsResponse extends BroadcastResponse {
 * Licensed to Elasticsearch under one or more contributor
    private CommonStats total = null;
 * Modifications Copyright OpenSearch Contributors. See
                    }
    public Map<String, IndexStats> getIndices() {
    public IndicesStatsResponse(StreamInput in) throws IOException {
            return total;
        final boolean isLevelValid = "cluster".equalsIgnoreCase(level)
    private CommonStats primary = null;
        builder.endObject();
}
            builder.endObject();
    public void writeTo(StreamOutput out) throws IOException {
    private Map<ShardRouting, ShardStats> shardStatsMap;
import org.opensearch.core.xcontent.XContentBuilder;
                            shardStats.toXContent(builder, params);
     *
            Map<ShardRouting, ShardStats> shardStatsMap = new HashMap<>();
        return stats;
