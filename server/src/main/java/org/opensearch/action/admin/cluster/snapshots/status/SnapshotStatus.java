        return Strings.toString(MediaTypeRegistry.JSON, this, true, false);  
            } else {  
        return shardsStats;
                for (SnapshotIndexStatus index : indices) {  
            && Objects.equals(includeGlobalState, that.includeGlobalState);  
 * The OpenSearch Contributors require contributions made to  
    }
                indicesStatus = new HashMap<>(indices.size());
    private static final String UUID = "uuid";  
import java.util.Objects;
        if (this == o) return true;  
 *
        snapshot.writeTo(out);
     */  
 * not use this file except in compliance with the License.
        builder.startObject(INDICES);
import org.opensearch.core.common.Strings;  
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                shards = emptyList();
    }
import static java.util.Collections.emptyList;
    @Override
    static {
                    indicesStatus.put(index.getIndex(), index);
            SnapshotStats::fromXContent,
    /**  
 * Unless required by applicable law or agreed to in writing,
            SnapshotsInProgress.State state = SnapshotsInProgress.State.valueOf(rawState);  
        result = 31 * result + (shardsStats != null ? shardsStats.hashCode() : 0);
    }
     */
    }
/*  
        PARSER.declareBoolean(optionalConstructorArg(), new ParseField(INCLUDE_GLOBAL_STATE));
    public String toString() {
        this.state = state;
        }
                if (shard.getIndex().equals(index)) {
import java.util.Set;  
import java.io.IOException;
import org.opensearch.common.Nullable;  
        this.shards = Objects.requireNonNull(shards);  
    public Map<String, SnapshotIndexStatus> getIndices() {
import org.opensearch.core.common.io.stream.Writeable;  
            constructorArg(),  
    ) {  
            indices.add(shard.getIndex());
        (Object[] parsedObjects) -> {
            // BWC: only update timestamps when we did not get a start time from an old node
import org.opensearch.core.common.io.stream.StreamInput;
        builder.field(SnapshotShardsStats.Fields.SHARDS_STATS, shardsStats, params);  
        State state,
                shards = new ArrayList<>();
        builder.field(SnapshotStats.Fields.STATS, stats, params);
            for (SnapshotIndexShardStatus shard : this.shards) {  
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        List<SnapshotIndexShardStatus> shards,
            ObjectParser.ValueType.OBJECT  
        return state;  
 * KIND, either express or implied.  See the License for the
    private final State state;  
            return this.indicesStatus;  
import org.opensearch.cluster.SnapshotsInProgress;
        }
        );
    }
        final long startTime = in.readLong();  
    @Override
        assert time >= 0 : "time must be >= 0 but received [" + time + "]";  
            }
    }
    @Nullable
        Map<String, SnapshotIndexStatus> indicesStatus,
 * Licensed to Elasticsearch under one or more contributor  
     * Returns snapshot
}
package org.opensearch.action.admin.cluster.snapshots.status;
/*
            indicesStatus.put(index, new SnapshotIndexStatus(index, shards));
        return builder;
    public static SnapshotStatus fromXContent(XContentParser parser) throws IOException {  
    private final List<SnapshotIndexShardStatus> shards;
    private SnapshotShardsStats shardsStats;  
import org.opensearch.common.annotation.PublicApi;
        this.indicesStatus = unmodifiableMap(indicesStatus);
import org.opensearch.core.common.io.stream.StreamOutput;
        Snapshot snapshot,  
 * the Apache License, Version 2.0 (the "License"); you may
            return new SnapshotStatus(snapshot, state, shards, indicesStatus, shardsStats, stats, includeGlobalState);
import java.util.HashSet;
        this.stats = stats;  
    private static final String INCLUDE_GLOBAL_STATE = "include_global_state";  
        updateShardStats(startTime, time);
        return snapshot;
import java.util.ArrayList;
    }
public class SnapshotStatus implements ToXContentObject, Writeable {
        result = 31 * result + (stats != null ? stats.hashCode() : 0);  
        PARSER.declareString(constructorArg(), new ParseField(SNAPSHOT));  
        List<SnapshotIndexShardStatus> shards,
import static java.util.Collections.unmodifiableMap;
                }  
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * license agreements. See the NOTICE file distributed with
        builder.field(STATE, state.name());
        this.shardsStats = shardsStats;
     */  
        long time
import org.opensearch.core.xcontent.ToXContentObject;
            String rawState = (String) parsedObjects[i++];
 *
        PARSER.declareObject(constructorArg(), SnapshotShardsStats.PARSER, new ParseField(SnapshotShardsStats.Fields.SHARDS_STATS));
            }
     * Returns list of snapshot indices
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    public int hashCode() {
        stats = new SnapshotStats(startTime, time, 0, 0, 0, 0, 0, 0);
import java.util.Map;
     */
    }
            SnapshotShardsStats shardsStats = ((SnapshotShardsStats) parsedObjects[i++]);
    private static final String REPOSITORY = "repository";
     * Returns list of snapshot shards  
            Snapshot snapshot = new Snapshot(repository, new SnapshotId(name, uuid));
            @SuppressWarnings("unchecked")
        for (SnapshotIndexShardStatus shard : shards) {  
    /**  
            Boolean includeGlobalState = (Boolean) parsedObjects[i++];
        this.includeGlobalState = includeGlobalState;
import org.opensearch.core.xcontent.XContentBuilder;
        }  
        if (this.indicesStatus != null) {
        }  
        this.state = Objects.requireNonNull(state);
            String name = (String) parsedObjects[i++];
            && Objects.equals(indicesStatus, that.indicesStatus)  
    }  
    }  
@PublicApi(since = "1.0.0")
        result = 31 * result + (indicesStatus != null ? indicesStatus.hashCode() : 0);
            && Objects.equals(stats, that.stats)
 * You may obtain a copy of the License at  
     * Can be null if this information is unknown.
        true,
        if (includeGlobalState != null) {  
    public void writeTo(StreamOutput out) throws IOException {
 * compatible open source license.
    private static final String STATE = "state";
        PARSER.declareNamedObjects(constructorArg(), SnapshotIndexStatus.PARSER, new ParseField(INDICES));  
        for (SnapshotIndexShardStatus shard : shards) {
            SnapshotStats stats = ((SnapshotStats) parsedObjects[i++]);  
import java.util.List;  
        PARSER.declareString(constructorArg(), new ParseField(REPOSITORY));
    );
import java.util.Collections;  
        Boolean includeGlobalState,  
        builder.field(UUID, snapshot.getSnapshotId().getUUID());
    private static final String INDICES = "indices";
import org.opensearch.core.xcontent.ConstructingObjectParser;
    private SnapshotStatus(
        return this.indicesStatus;
     * Returns number of files in the snapshot
        builder.endObject();  
        this.snapshot = snapshot;
        state = State.fromValue(in.readByte());  
        builder.endObject();
        final long time = in.readLong();
        result = 31 * result + (state != null ? state.hashCode() : 0);  
        return Objects.equals(snapshot, that.snapshot)
        out.writeList(shards);
 */  
            && state == that.state
 * GitHub history for details.
        Map<String, SnapshotIndexStatus> indicesStatus = new HashMap<>();  
 * SPDX-License-Identifier: Apache-2.0
        SnapshotShardsStats shardsStats,  
import org.opensearch.cluster.SnapshotsInProgress.State;
            List<SnapshotIndexShardStatus> shards;
        for (String index : indices) {
                indicesStatus = emptyMap();
        Snapshot snapshot,
        return shards;  
    }
    public State getState() {
        }
            List<SnapshotIndexStatus> indices = ((List<SnapshotIndexStatus>) parsedObjects[i]);  
        }
        if (o == null || getClass() != o.getClass()) return false;
    private SnapshotStats stats;
 * Status of a snapshot  
    SnapshotStatus(
 * Modifications Copyright OpenSearch Contributors. See
        int result = snapshot != null ? snapshot.hashCode() : 0;
        SnapshotStatus that = (SnapshotStatus) o;  
        out.writeLong(stats.getStartTime());  
 * @opensearch.api
            stats.add(shard.getStats(), startTime == 0L);  
        return result;
        SnapshotStats stats,
     */  
    private Map<String, SnapshotIndexStatus> indicesStatus;
 * this work for additional information regarding copyright
                    shards.addAll(index.getShards().values());
    }  
 *
import java.util.HashMap;
 */  
        this.snapshot = Objects.requireNonNull(snapshot);
            int i = 0;  
        includeGlobalState = in.readOptionalBoolean();
     * Returns snapshot state  
            indexStatus.toXContent(builder, params);
    @Override
import static java.util.Collections.emptyMap;  
        long startTime,
            String repository = (String) parsedObjects[i++];
    }
    public SnapshotStats getStats() {  
        builder.field(REPOSITORY, snapshot.getRepository());  
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**
            && Objects.equals(shardsStats, that.shardsStats)
    private final Boolean includeGlobalState;
        for (SnapshotIndexStatus indexStatus : getIndices().values()) {  
        Boolean includeGlobalState
    private final Snapshot snapshot;
        return PARSER.parse(parser, null);
        out.writeByte(state.value());  
        "snapshot_status",  
        snapshot = new Snapshot(in);
 */  
            builder.field(INCLUDE_GLOBAL_STATE, includeGlobalState);
import org.opensearch.core.xcontent.ObjectParser;  
    private void updateShardStats(long startTime, long time) {
import org.opensearch.snapshots.Snapshot;
    /**
            Map<String, SnapshotIndexStatus> indicesStatus;
                }  
    }
        }
        updateShardStats(startTime, time);
            new ParseField(SnapshotStats.Fields.STATS),
import org.opensearch.core.xcontent.XContentParser;  
import org.opensearch.snapshots.SnapshotId;
        out.writeOptionalBoolean(includeGlobalState);
import org.opensearch.core.ParseField;
        return stats;
 * software distributed under the License is distributed on an
        out.writeLong(stats.getTime());
    @Override  
    public Boolean includeGlobalState() {
        return includeGlobalState;
 */
 *  
        PARSER.declareString(constructorArg(), new ParseField(STATE));  
    public Snapshot getSnapshot() {
    public List<SnapshotIndexShardStatus> getShards() {
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
    /**
        State state,  
    public SnapshotShardsStats getShardsStats() {  
    SnapshotStatus(StreamInput in) throws IOException {
    static final ConstructingObjectParser<SnapshotStatus, Void> PARSER = new ConstructingObjectParser<>(
            if (indices == null || indices.isEmpty()) {  
        shards = Collections.unmodifiableList(in.readList(SnapshotIndexShardStatus::new));
    }  
 * ownership. Elasticsearch licenses this file to you under  
            List<SnapshotIndexShardStatus> shards = new ArrayList<>();
    }  
    }
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;  
    @Override  
        this.shards = shards;  
        this.includeGlobalState = includeGlobalState;
        PARSER.declareField(
        shardsStats = new SnapshotShardsStats(shards);
/*  
        builder.field(SNAPSHOT, snapshot.getSnapshotId().getName());
        this.indicesStatus = indicesStatus;
        builder.startObject();
    ) {  
        Set<String> indices = new HashSet<>();
        PARSER.declareString(constructorArg(), new ParseField(UUID));
     */
    /**
    private static final String SNAPSHOT = "snapshot";
            String uuid = (String) parsedObjects[i++];  
        result = 31 * result + (includeGlobalState != null ? includeGlobalState.hashCode() : 0);
     * Returns true if global state is included in the snapshot, false otherwise.
    public boolean equals(Object o) {
        shardsStats = new SnapshotShardsStats(shards);  
/**
                    shards.add(shard);
