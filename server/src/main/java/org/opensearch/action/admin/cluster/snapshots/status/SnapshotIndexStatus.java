    static final ObjectParser.NamedObjectParser<SnapshotIndexStatus, Void> PARSER;
}
/*  
        stats = new SnapshotStats();
        return result;
        result = 31 * result + (shardsStats != null ? shardsStats.hashCode() : 0);  
        builder.field(SnapshotStats.Fields.STATS, stats, params);  
                    }
            (Object[] parsedObjects, String index) -> {  
        ConstructingObjectParser<SnapshotIndexStatus, String> innerParser = new ConstructingObjectParser<>(  
public class SnapshotIndexStatus implements Iterable<SnapshotIndexShardStatus>, ToXContentFragment {  
                @SuppressWarnings("unchecked")
    private final Map<Integer, SnapshotIndexShardStatus> indexShards;
 * the Apache License, Version 2.0 (the "License"); you may
        shardsStats = new SnapshotShardsStats(shards);
    @Override  
 */  
        builder.endObject();  
        this.indexShards = indexShards;  
                int i = 0;
        return shardsStats;
 * specific language governing permissions and limitations
    }  
     * Returns the index name  
            "snapshot_index_status",
import static java.util.Collections.unmodifiableMap;  
        Map<Integer, SnapshotIndexShardStatus> indexShards = new HashMap<>();
        }
                SnapshotStats stats = ((SnapshotStats) parsedObjects[i++]);  
 *
        return builder;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        builder.endObject();
        return stats != null ? stats.equals(that.stats) : that.stats == null;
                    for (SnapshotIndexShardStatus shardStatus : shardStatuses) {  
    private final SnapshotShardsStats shardsStats;  
            shard.toXContent(builder, params);  
    }  
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
        String index,  
    @Override
 * @opensearch.api  
     */
 * Represents snapshot status of all shards in the index
            constructorArg(),
     * Shards stats
                    indexShards = emptyMap();  
    public SnapshotShardsStats getShardsStats() {
        }  
 * SPDX-License-Identifier: Apache-2.0
    static {
        return PARSER.parse(parser, null, parser.currentName());
 */
                if (shardStatuses == null || shardStatuses.isEmpty()) {
 * The OpenSearch Contributors require contributions made to  
    public Map<Integer, SnapshotIndexShardStatus> getShards() {  
     */
        builder.startObject(getIndex());
        this.stats = stats;
        result = 31 * result + (indexShards != null ? indexShards.hashCode() : 0);
        SnapshotShardsStats shardsStats,
    }  
                } else {
    public static SnapshotIndexStatus fromXContent(XContentParser parser) throws IOException {
    @Override
        return this.indexShards;
import org.opensearch.core.xcontent.XContentParser;
        if (indexShards != null ? !indexShards.equals(that.indexShards) : that.indexShards != null) return false;  
import org.opensearch.core.ParseField;
        static final String SHARDS = "shards";
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
     */  
 * software distributed under the License is distributed on an
     * Returns snapshot stats  
        SnapshotStats stats  
    static final class Fields {
    /**
 * under the License.  
 */  
                List<SnapshotIndexShardStatus> shardStatuses = (List<SnapshotIndexShardStatus>) parsedObjects[i];
        this.index = index;
    }
        builder.field(SnapshotShardsStats.Fields.SHARDS_STATS, shardsStats, params);
 *
import org.opensearch.core.xcontent.ToXContentFragment;
    }  
        if (this == o) return true;  
import java.io.IOException;
        this.index = index;
        for (SnapshotIndexShardStatus shard : indexShards.values()) {
    }  
import org.opensearch.core.xcontent.XContentParserUtils;
        innerParser.declareNamedObjects(constructorArg(), SnapshotIndexShardStatus.PARSER, new ParseField(Fields.SHARDS));
    }  
 * GitHub history for details.
        Map<Integer, SnapshotIndexShardStatus> indexShards,
     * Inner Fields used for creating XContent and parsing  
    /**
        builder.startObject(Fields.SHARDS);
import java.util.List;
    }
        SnapshotIndexStatus that = (SnapshotIndexStatus) o;  
    ) {
import org.opensearch.common.annotation.PublicApi;
        innerParser.declareObject(
        return stats;  
import java.util.Iterator;
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
 * You may obtain a copy of the License at  
            (p, c) -> SnapshotShardsStats.PARSER.apply(p, null),  
            new ParseField(SnapshotShardsStats.Fields.SHARDS_STATS)
    private final SnapshotStats stats;
                        indexShards.put(shardStatus.getShardId().getId(), shardStatus);
    public Iterator<SnapshotIndexShardStatus> iterator() {
    /**
     */
 *  
                    indexShards = new HashMap<>(shardStatuses.size());
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Map;  
    }
/*  
 * Licensed to Elasticsearch under one or more contributor  
@PublicApi(since = "1.0.0")
        );
    private final String index;
     *
 *
 * Unless required by applicable law or agreed to in writing,
                SnapshotShardsStats shardsStats = ((SnapshotShardsStats) parsedObjects[i++]);
        if (o == null || getClass() != o.getClass()) return false;
            indexShards.put(shard.getShardId().getId(), shard);
     * @opensearch.internal
    /**
        );  
        for (SnapshotIndexShardStatus shard : shards) {  
package org.opensearch.action.admin.cluster.snapshots.status;
    SnapshotIndexStatus(String index, Collection<SnapshotIndexShardStatus> shards) {
        result = 31 * result + (stats != null ? stats.hashCode() : 0);
import java.util.HashMap;  
    }  
 * this file be licensed under the Apache-2.0 license or a
    public SnapshotStats getStats() {
 * Modifications Copyright OpenSearch Contributors. See
        int result = index != null ? index.hashCode() : 0;
        PARSER = ((p, c, name) -> innerParser.apply(p, name));
    /**  
     * A shard id to index snapshot shard status map
                }  
import org.opensearch.core.xcontent.ObjectParser;
        return indexShards.values().iterator();
    public SnapshotIndexStatus(
    }
            }
        this.shardsStats = shardsStats;
import org.opensearch.core.xcontent.ConstructingObjectParser;  
import static java.util.Collections.emptyMap;
        if (shardsStats != null ? !shardsStats.equals(that.shardsStats) : that.shardsStats != null) return false;
    public boolean equals(Object o) {
            stats.add(shard.getStats(), true);
    @Override
/**  
    public int hashCode() {  
        if (index != null ? !index.equals(that.index) : that.index != null) return false;
import org.opensearch.core.xcontent.XContentBuilder;  
        this.indexShards = unmodifiableMap(indexShards);
                final Map<Integer, SnapshotIndexShardStatus> indexShards;
        innerParser.declareObject(constructorArg(), (p, c) -> SnapshotStats.fromXContent(p), new ParseField(SnapshotStats.Fields.STATS));  
    }
import java.util.Collection;
 * not use this file except in compliance with the License.
    }  
 * compatible open source license.
    public String getIndex() {
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.currentToken(), parser);  
 * license agreements. See the NOTICE file distributed with
            true,
                return new SnapshotIndexStatus(index, indexShards, shardsStats, stats);
        return this.index;  
 * ownership. Elasticsearch licenses this file to you under  
     */  
