        successfulShards = in.readVInt();
    ) {  
        return indices;
    public Boolean includeGlobalState() {
    private static final String NAME = "name";  
    public SnapshotId snapshotId() {
        builder.endArray();  
                    if (token.isValue()) {
        private String state = null;
            state,  
            return successfulShards;
            return totalShards;
            userMetadata,  
        SNAPSHOT_INFO_PARSER.declareBoolean(SnapshotInfoBuilder::setIncludeGlobalState, new ParseField(INCLUDE_GLOBAL_STATE));  
            snapshotId,
    private static final class ShardStatsBuilder {
        this.shardFailures = Objects.requireNonNull(shardFailures);
}
    /**  
                userMetadata,
        builder.startArray(FAILURES);
            && Objects.equals(includeGlobalState, that.includeGlobalState)
            builder.value(dataStream);
        }
    @Nullable  
    public long endTime() {
            remoteStoreIndexShallowCopy,  
    /**  
            this.includeGlobalState = includeGlobalState;
        }
                        } else if (VERSION_ID.equals(currentFieldName)) {
    private long pinnedTimestamp;
            remoteStoreIndexShallowCopy,  
        if (includeGlobalState != null) {  
     */
        List<String> dataStreams,
        );
            uuid = name;  
 * Licensed to Elasticsearch under one or more contributor  
        out.writeMap(userMetadata);
                            }  
            shardFailures,
            SnapshotState snapshotState = state == null ? null : SnapshotState.valueOf(state);  
    }
        private void setReason(String reason) {
        }
            snapshotState(reason, shardFailures),
        Boolean remoteStoreIndexShallowCopy,
     * operations such as listing snapshots do not fail for the whole repository.
        List<SnapshotShardFailure> shardFailures = Collections.emptyList();
                                indicesArray.add(parser.text());
            this.shardStatsBuilder = shardStatsBuilder;
    }  
    private Boolean remoteStoreIndexShallowCopy;  
    @Nullable
    }
     * is only for display purposes and does not need to be parsed.
        List<String> indices,
    }
    private static final String FAILURES = "failures";
     *  
            && successfulShards == that.successfulShards
import org.opensearch.core.rest.RestStatus;  
     * snapshot is still running or if {@link #state()} returns {@code null}.  
     * @return version of opensearch that the snapshot was created with
     */
import org.apache.logging.log4j.Logger;
        return successfulShards;
        this.remoteStoreIndexShallowCopy = remoteStoreIndexShallowCopy;
    private static final String STATE = "state";  
    private Boolean includeGlobalState;  
    /**
            entry.dataStreams(),
    }
        if (verbose || state != null) {
        }  
/*
            totalShards - shardFailures.size(),
                dataStreams,  
            totalShards,  
            builder.value(index);  
import org.opensearch.core.common.io.stream.Writeable;
     * Returns the custom metadata that was attached to this snapshot at creation time.
                            ArrayList<String> indicesArray = new ArrayList<>();
        private int version = -1;
            Version.CURRENT,
                        }
    private static SnapshotState snapshotState(final String reason, final List<SnapshotShardFailure> shardFailures) {  
            this.snapshotUUID = snapshotUUID;  
            && endTime == that.endTime  
            indices,
                            startTime = parser.longValue();  
                    }  
            builder.value(dataStream);
        if (reason == null) {
        builder.endArray();
    @Override
     * return {@code null} if {@link #state()} returns {@code null} or {@link SnapshotState#INCOMPATIBLE}.  
            + ", startTime="  
                startTime,
    }
     * @return snapshot failure reason
            includeGlobalState,
        private String snapshotName = null;
        List<String> indices,
        private List<String> dataStreams = null;
    /**
            && Objects.equals(pinnedTimestamp, that.pinnedTimestamp);
            entry.indices().stream().map(IndexId::getName).collect(Collectors.toList()),
        );
            null,
    }  
            builder.field(STATE, state);
    private static final String TOTAL_SHARDS = "total_shards";
            entry.remoteStoreIndexShallowCopy(),
        Boolean includeGlobalState,  
            snapshotState(reason, shardFailures),
        return remoteStoreIndexShallowCopy;
        return totalShards;  
            + reason
                        } else if (STATE.equals(currentFieldName)) {
            && Objects.equals(shardFailures, that.shardFailures)
    }
        indices = Collections.unmodifiableList(in.readStringList());
                    token = parser.nextToken();
            builder.field(VERSION_ID, version.id);
            snapshotId,
    public int compareTo(final SnapshotInfo o) {
    private static final DateFormatter DATE_TIME_FORMATTER = DateFormatter.forPattern("strict_date_optional_time");
    /**
            builder.humanReadableField(DURATION_IN_MILLIS, DURATION, new TimeValue(Math.max(0L, endTime - startTime)));
import java.util.Collections;  
                        } else if (REMOTE_STORE_INDEX_SHALLOW_COPY.equals(currentFieldName)) {
 * this work for additional information regarding copyright
                remoteStoreIndexShallowCopy,
        }  
import org.opensearch.core.ParseField;
        private void setSuccessfulShards(int successfulShards) {
            }  
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
        private void setDataStreams(List<String> dataStreams) {  
            includeGlobalState,
        return new SnapshotInfo(snapshotId, indices, Collections.emptyList(), state);  
                        } else if (PINNED_TIMESTAMP.equals(currentFieldName)) {
     */
        builder.field(STATE, state);
     * Returns snapshot state; {@code null} if the state is unknown.
            builder.field(INCLUDE_GLOBAL_STATE, includeGlobalState);
        startTime = in.readVLong();
        out.writeVLong(startTime);
            }
        if (reason != null) {  
            new ParseField(REMOTE_STORE_INDEX_SHALLOW_COPY)
        long endTime,  
        long startTime,  
    /**
 * KIND, either express or implied.  See the License for the
            this.userMetadata = userMetadata;  
     */
            logger.debug("Encountered unsupported snapshot version_id [{}]; reporting version as unknown", versionId);  
    public String reason() {
     * @return snapshot end time
 * Unless required by applicable law or agreed to in writing,
            && Objects.equals(dataStreams, that.dataStreams)
            this.dataStreams = dataStreams;
            pinnedTimestamp
        }  
        this.includeGlobalState = includeGlobalState;  
            startTime,
        );  
    private static final String DURATION = "duration";  
                snapshotState,
        SNAPSHOT_INFO_PARSER.declareString(SnapshotInfoBuilder::setReason, new ParseField(REASON));  
        private void setUserMetadata(Map<String, Object> userMetadata) {
            builder.field(TOTAL, totalShards);
        userMetadata = in.readMap();  
        return reason;
        if (state != null) {
        private long endTime = 0L;  
        builder.endObject();  
        }  
        private void setStartTime(long startTime) {
        }
        SNAPSHOT_INFO_PARSER.declareObject(SnapshotInfoBuilder::setShardStatsBuilder, SHARD_STATS_PARSER, new ParseField(SHARDS));
    }
    public List<String> indices() {
public final class SnapshotInfo implements Comparable<SnapshotInfo>, ToXContent, Writeable {
    public static final String CONTEXT_MODE_PARAM = "context_mode";
            this.version = version;
        }  
            int successfulShards = shardStatsBuilder == null ? 0 : shardStatsBuilder.getSuccessfulShards();  
            + snapshotId
        builder.endObject();
     * @return list of data streams that were included in this snapshot.  
     * Builds snapshot information  
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;  
            0,
        String reason = null;  
            builder.field(REMOTE_STORE_INDEX_SHALLOW_COPY, remoteStoreIndexShallowCopy);  
            userMetadata,
            final Version version;
            out.writeBoolean(true);
        Version version = Version.CURRENT;
            endTime,
        int totalShards = 0;
        builder.field(SNAPSHOT, snapshotId.getName());
        // write snapshot info for the API and any other situations  
            reason,  
        private Map<String, Object> userMetadata = null;  
            builder.startArray(FAILURES);
            }
    /**
            && state == that.state
    private static final String VERSION = "version";
     *
    SnapshotInfo(
            if (this.version == -1) {
            }  
            if (shardFailures == null) {
        }
        private void setSnapshotName(String snapshotName) {
        if (remoteStoreIndexShallowCopy != null) {
            this.pinnedTimestamp = pinnedTimestamp;  
    /**
            }
            dataStreams,
        SNAPSHOT_INFO_PARSER.declareInt(SnapshotInfoBuilder::setVersion, new ParseField(VERSION_ID));
            this.remoteStoreIndexShallowCopy = remoteStoreIndexShallowCopy;
            pinnedTimestamp = in.readVLong();  
        );  
        int totalShards,
        builder.startArray(INDICES);
 *  
        if (o == null || getClass() != o.getClass()) return false;  
            version,  
            0,  
import org.opensearch.repositories.IndexId;  
            new ParseField(FAILURES)
                            includeGlobalState = parser.booleanValue();
import java.util.ArrayList;
        long startTime,
    @Override  
            + pinnedTimestamp
     */  
     * {@code 0} will be returned if {@link #state()} returns {@code null}.  
        private void setRemoteStoreIndexShallowCopy(Boolean remoteStoreIndexShallowCopy) {
    private static final String END_TIME_IN_MILLIS = "end_time_in_millis";
        }  
        }  
                totalShards,  
 * software distributed under the License is distributed on an
    @Override  
                        if (NAME.equals(currentFieldName)) {  
            }
            + ", endTime="
    @Nullable  
    private final int totalShards;
                            parser.skipChildren();  
        return userMetadata;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     *  
     * @return number of shards  
    }
        SnapshotInfo that = (SnapshotInfo) o;
            dataStreams,  
     * Returns snapshot failure reason; {@code null} if the snapshot succeeded.
            + includeGlobalState  
        }
     * Compares two snapshots by their start time; if the start times are the same, then
        } catch (Version.UnsupportedVersionException e) {
        SNAPSHOT_INFO_PARSER.declareObjectArray(
        for (String dataStream : dataStreams) {
        }
            builder.value(index);
        private void setIncludeGlobalState(Boolean includeGlobalState) {
            includeGlobalState,
                includeGlobalState,  
    private final int successfulShards;  
    private final long endTime;
                    } else if (token == XContentParser.Token.START_ARRAY) {
            this.totalShards = totalShards;
            successfulShards,  
    public List<String> dataStreams() {
            }  
import java.util.List;
            Collections.emptyList(),
        return Objects.hash(
 * @opensearch.api
                        }
 */
    private final List<SnapshotShardFailure> shardFailures;  
     */  
            builder.endArray();  
        SnapshotId snapshotId,  
        SNAPSHOT_INFO_PARSER.declareString(SnapshotInfoBuilder::setState, new ParseField(STATE));
import java.util.stream.Collectors;
        }
import org.opensearch.core.common.io.stream.StreamInput;  
    );  
        builder.startObject();
                        } else if (END_TIME.equals(currentFieldName)) {
     *  
        return version;  
     * handle x-content written with the external version as external x-content
     */
                            shardFailures = Collections.unmodifiableList(shardFailureArrayList);  
                    } else if (token == XContentParser.Token.START_OBJECT) {
        }
        ShardStatsBuilder::new
    public Boolean isRemoteStoreIndexShallowCopyEnabled() {
            + endTime  
        List<SnapshotShardFailure> shardFailures,
        }
            + ", successfulShards="  
        }
    private static final String SUCCESSFUL = "successful";  
        }
    @Override
 * this file be licensed under the Apache-2.0 license or a
        return pinnedTimestamp;  
        out.writeStringCollection(indices);  
                dataStreams = Collections.emptyList();  
                version = Version.CURRENT;  
        private String reason = null;
 * ownership. Elasticsearch licenses this file to you under  
    }
            indices,  
            this.endTime = endTime;  
        return builder;
            indices,
    public int totalShards() {
            + '}';  
            parser.nextToken();
        builder.startArray(INDICES);  
     *
import org.opensearch.core.xcontent.ToXContent;
        }
            endTime,  
        Map<String, Object> userMetadata = null;
 * SPDX-License-Identifier: Apache-2.0
        return state;
import org.opensearch.cluster.SnapshotsInProgress;
        out.writeVInt(successfulShards);
    @Nullable  
            }
                            // It was probably created by newer version - ignoring
    }  
    private static final String PINNED_TIMESTAMP = "pinned_timestamp";
        }
            SnapshotInfoBuilder::setRemoteStoreIndexShallowCopy,
            + ", state="
        );  
            this.shardFailures = shardFailures;
import java.time.ZoneOffset;
        this.snapshotId = Objects.requireNonNull(snapshotId);
        String name = null;
     */  
    public static final String CONTEXT_MODE_SNAPSHOT = "SNAPSHOT";  
        private List<SnapshotShardFailure> shardFailures = null;
 * Information about a snapshot
     */  
 * The OpenSearch Contributors require contributions made to  
            } else {
            if (dataStreams == null) {
        SHARD_STATS_PARSER.declareInt(ShardStatsBuilder::setTotalShards, new ParseField(TOTAL));
        private void setSnapshotUUID(String snapshotUUID) {
        }
        }
import org.opensearch.core.xcontent.XContentParserUtils;
                            totalShards = parser.intValue();
        for (String index : indices) {
            shardFailures,
        }
 */  
    public SnapshotInfo(SnapshotsInProgress.Entry entry) {
            0L
            shardFailure.toXContent(builder, params);
        if (in.getVersion().onOrAfter(Version.V_2_9_0)) {
     */  
        }
        }  
        try {  
                        if (USER_METADATA.equals(currentFieldName)) {  
            builder.field(VERSION, version.toString());  
            + ", pinnedTimestamp="
                            name = parser.text();
 * the Apache License, Version 2.0 (the "License"); you may
        SNAPSHOT_INFO_PARSER.declareLong(SnapshotInfoBuilder::setStartTime, new ParseField(START_TIME_IN_MILLIS));  
            && Objects.equals(snapshotId, that.snapshotId)  
        // write snapshot info to repository snapshot blob format  
            builder.field(PINNED_TIMESTAMP, pinnedTimestamp);  
                            parser.skipChildren();
            + remoteStoreIndexShallowCopy  
    }
            return new SnapshotInfo(  
                }
        totalShards = in.readVInt();
     * @return shard failures
    private final Map<String, Object> userMetadata;
            snapshotId,
    public int hashCode() {
        }  
    public int failedShards() {  
            pinnedTimestamp
import java.io.IOException;
        long pinnedTimestamp = 0;
        builder.endArray();
        String reason,
     * @return number of successful shards
            + version
            pinnedTimestamp
    }
 */
        SnapshotState state = SnapshotState.IN_PROGRESS;
        builder.endArray();  
    private static final String VERSION_ID = "version_id";
        List<String> indices = Collections.emptyList();
        out.writeVInt(totalShards);
    private final Version version;
     * Returns snapshot id
        int getSuccessfulShards() {  
        private Boolean remoteStoreIndexShallowCopy = null;
     * @return number of failed shards
 * GitHub history for details.
    }  
            builder.field(FAILED, failedShards());
        this.successfulShards = successfulShards;
        SHARD_STATS_PARSER.declareInt(ShardStatsBuilder::setSuccessfulShards, new ParseField(SUCCESSFUL));  
            shardFailures,  
        SNAPSHOT_INFO_PARSER.declareBoolean(  
            builder.field(REMOTE_STORE_INDEX_SHALLOW_COPY, remoteStoreIndexShallowCopy);
        }  
    }  
    /**  
            + startTime
    static {
            Version.CURRENT,
    private XContentBuilder toXContentInternal(final XContentBuilder builder, final ToXContent.Params params) throws IOException {
        this.endTime = endTime;
        }
        List<SnapshotShardFailure> shardFailures,
        this.reason = reason;
        if (parser.currentToken() == XContentParser.Token.START_OBJECT) {  // on a start object move to next token  
        builder.endArray();
@PublicApi(since = "1.0.0")  
     *  
        long startTime = 0;  
    private static final String REMOTE_STORE_INDEX_SHALLOW_COPY = "remote_store_index_shallow_copy";
            remoteStoreIndexShallowCopy,  
            out.writeByte(state.value());  
    public long startTime() {  
        SNAPSHOT_INFO_PARSER.declareString(SnapshotInfoBuilder::setSnapshotName, new ParseField(SNAPSHOT));  
            this.startTime = startTime;
    }
        this(
                snapshotId,
    private static final String DATA_STREAMS = "data_streams";
    private static final String USER_METADATA = "metadata";  
            builder.startObject(SHARDS);  
     */  
            return Version.fromId(versionId);
     *
    private static Version resolveSnapshotVersion(int versionId) {
            builder.field(START_TIME, DATE_TIME_FORMATTER.format(Instant.ofEpochMilli(startTime).atZone(ZoneOffset.UTC)));
     * @return snapshot state  
            remoteStoreIndexShallowCopy,
    );  
        }
                if (token == XContentParser.Token.FIELD_NAME) {
    }
            + "snapshotId="  
            remoteStoreIndexShallowCopy = in.readOptionalBoolean();  
        return "SnapshotInfo{"
            this.reason = reason;
        List<String> dataStreams,  
        out.writeOptionalString(reason);
        }  
        out.writeList(shardFailures);  
            out.writeOptionalBoolean(remoteStoreIndexShallowCopy);
        }  
        private void setPinnedTimestamp(long pinnedTimestamp) {
    public long getPinnedTimestamp() {
    /**  
        SNAPSHOT_INFO_PARSER.declareString(SnapshotInfoBuilder::setSnapshotUUID, new ParseField(UUID));
        List<String> dataStreams,
        private void setShardFailures(List<SnapshotShardFailure> shardFailures) {  
        if (CONTEXT_MODE_SNAPSHOT.equals(params.param(CONTEXT_MODE_PARAM))) {
        } else {
        assert version != null : "version must always be known when writing a snapshot metadata blob";
                            // It was probably created by newer version - ignoring  
        return totalShards - successfulShards;
        public SnapshotInfo build() {
            builder.field(INCLUDE_GLOBAL_STATE, includeGlobalState);
     * Resolves the {@link Version} a snapshot was created with from its stored {@code version_id},  
                                shardFailureArrayList.add(SnapshotShardFailure.fromXContent(parser));
            return toXContentInternal(builder, params);
    public SnapshotInfo(SnapshotId snapshotId, List<String> indices, List<String> dataStreams, SnapshotState state, Version version) {  
import org.opensearch.common.annotation.PublicApi;  
            && totalShards == that.totalShards
        if (version != null) {
    }  
            SnapshotId snapshotId = new SnapshotId(snapshotName, snapshotUUID);
                            version = resolveSnapshotVersion(parser.intValue());
        builder.startArray(DATA_STREAMS);
        List<String> indices,
        }
            totalShards,
     *
                        }  
            } else {
            this.indices = indices;  
     * all information stripped out except the snapshot id, state, and indices.  
            out.writeBoolean(false);
        if (shardFailures.size() == 0) {
     * be returned if {@link #state()} returns {@code null}.
            version,
        if (uuid == null) {
            SnapshotShardFailure.SNAPSHOT_SHARD_FAILURE_PARSER,
        );  
        final boolean verbose = params.paramAsBoolean("verbose", GetSnapshotsRequest.DEFAULT_VERBOSE_MODE);
    private final List<String> indices;
        return snapshotId;  
     */
                            while (parser.nextToken() != XContentParser.Token.END_ARRAY) {  
                            ArrayList<SnapshotShardFailure> shardFailureArrayList = new ArrayList<>();
import org.opensearch.core.xcontent.XContentParser;
        }  
        if (this == o) return true;
        ShardStatsBuilder.class.getName(),  
        return includeGlobalState;  
    public List<SnapshotShardFailure> shardFailures() {  
            userMetadata,
    /**  
    /**  
            out.writeBoolean(true);
    private static final String END_TIME = "end_time";
        private Boolean includeGlobalState = null;
/**
        this.totalShards = totalShards;  
            entry.snapshot().getSnapshotId(),  
        SnapshotId snapshotId,
        SnapshotInfoBuilder.class.getName(),  
    public int successfulShards() {
                            }
    @Nullable
    private static final String INDICES = "indices";
            return RestStatus.INTERNAL_SERVER_ERROR;
    private static final Comparator<SnapshotInfo> COMPARATOR = Comparator.comparing(SnapshotInfo::startTime)
        for (SnapshotShardFailure shardFailure : shardFailures) {  
        );
            return RestStatus.OK;
                            state = SnapshotState.valueOf(parser.text());
     * Returns shard failures; an empty list will be returned if there were no shard
            + ", shardFailures="  
                return SnapshotState.PARTIAL;
    @Nullable  
        snapshotId.writeTo(out);
            startTime,
                return SnapshotState.SUCCESS;  
        private void setTotalShards(int totalShards) {  
                            }
    ) {  
     * @opensearch.internal
            + indices
            builder.endObject();
            userMetadata,
                indices,
        SnapshotId snapshotId,  
 * compatible open source license.
        this(
     */
        return COMPARATOR.compare(this, o);  
        this.pinnedTimestamp = pinnedTimestamp;  
     * failures, or if {@link #state()} returns {@code null}.
    }  
        if (pinnedTimestamp != 0) {
import org.opensearch.common.Nullable;
import org.opensearch.core.xcontent.XContentBuilder;  
        }
    public static final ObjectParser<SnapshotInfoBuilder, Void> SNAPSHOT_INFO_PARSER = new ObjectParser<>(
        }  
                            reason = parser.text();
            state,  
    public static SnapshotInfo fromXContentInternal(final XContentParser parser) throws IOException {
 *  
        }  
            dataStreams,
        builder.field(USER_METADATA, userMetadata);  
                                dataStreams.add(parser.text());
                reason,
            endTime,
        includeGlobalState = in.readOptionalBoolean();
        }
                        } else if (REASON.equals(currentFieldName)) {  
            + '\''  
        if (reason != null) {
                            userMetadata = parser.map();
        version = in.readBoolean() ? in.readVersion() : null;
            out.writeVLong(pinnedTimestamp);
        private long pinnedTimestamp = 0L;
        private ShardStatsBuilder shardStatsBuilder = null;
 * You may obtain a copy of the License at  
import org.opensearch.core.action.ShardOperationFailedException;
    @Override  
                            while (parser.nextToken() != XContentParser.Token.END_ARRAY) {  
        true,
        private void setShardStatsBuilder(ShardStatsBuilder shardStatsBuilder) {  
            indices,  
     */  
        long pinnedTimestamp
        long pinnedTimestamp
        dataStreams = in.readStringList();
     *
     *
     *
     */  
 * Modifications Copyright OpenSearch Contributors. See  
                pinnedTimestamp  
        builder.field(END_TIME, endTime);
            if (indices == null) {
            for (SnapshotShardFailure shardFailure : shardFailures) {  
        private long startTime = 0L;
            SnapshotState.IN_PROGRESS,  
        endTime = in.readVLong();  
        }  
                            remoteStoreIndexShallowCopy = parser.booleanValue();  
                            endTime = parser.longValue();
                        if (DATA_STREAMS.equals(currentFieldName)) {
        }
                        } else if (INDICES.equals(currentFieldName)) {
        return shardFailures;
        private void setIndices(List<String> indices) {
        state = in.readBoolean() ? SnapshotState.fromValue(in.readByte()) : null;  
    public boolean equals(Object o) {
 * specific language governing permissions and limitations
        Map<String, Object> userMetadata,  
import org.opensearch.common.time.DateFormatter;
        this(snapshotId, indices, dataStreams, state, null, version, 0L, 0L, 0, 0, Collections.emptyList(), null, null, null, 0);
        }  
    /**  
            entry.startTime(),  
    }
     * Returns total number of shards that were successfully snapshotted; a value of
        return new SnapshotInfo(
            reason,
                endTime,
 * license agreements. See the NOTICE file distributed with
     */
    private static final String SUCCESSFUL_SHARDS = "successful_shards";
    private static final String UUID = "uuid";  
        Boolean includeGlobalState,
    private static final String SNAPSHOT = "snapshot";
        }
        }
        Map<String, Object> userMetadata,
    /**
    /**  
        }
        out.writeVLong(endTime);  
            out.writeVersion(version);  
        }
        builder.field(VERSION_ID, version.id);  
        SNAPSHOT_INFO_PARSER.declareStringArray(SnapshotInfoBuilder::setIndices, new ParseField(INDICES));
            this.snapshotName = snapshotName;
        Boolean includeGlobalState,
            0
                        } else if (TOTAL_SHARDS.equals(currentFieldName)) {  
            + totalShards
    public SnapshotState state() {  
import org.apache.logging.log4j.LogManager;  
        Version version,
        int totalShards,
        }  
    private static final String START_TIME_IN_MILLIS = "start_time_in_millis";  
        List<SnapshotShardFailure> shardFailures,
        if (remoteStoreIndexShallowCopy != null) {
            && Objects.equals(remoteStoreIndexShallowCopy, that.remoteStoreIndexShallowCopy)  
        String reason,
            startTime,  
    }
            && Objects.equals(reason, that.reason)
        builder.field(START_TIME, startTime);
                            indices = Collections.unmodifiableList(indicesArray);  
    }
        String currentFieldName = parser.currentName();
     * Returns snapshot REST status
            + ", indices="
/*
        this.dataStreams = Collections.unmodifiableList(Objects.requireNonNull(dataStreams));  
     * @return list of indices
            builder.field(PINNED_TIMESTAMP, pinnedTimestamp);
        shardFailures = Collections.unmodifiableList(in.readList(SnapshotShardFailure::new));  
                throw e;
        Map<String, Object> userMetadata,  
            builder.field(REASON, reason);
 */
        out.writeOptionalBoolean(includeGlobalState);
     * compares the two snapshots by their snapshot ids.
        for (String dataStream : dataStreams) {  
    private final List<String> dataStreams;
        SNAPSHOT_INFO_PARSER.declareLong(SnapshotInfoBuilder::setPinnedTimestamp, new ParseField(PINNED_TIMESTAMP));
                shardFailure.toXContent(builder, params);
    private final SnapshotState state;  
            // the old format where there wasn't a UUID
                        } else if (START_TIME.equals(currentFieldName)) {
        builder.field(TOTAL_SHARDS, totalShards);  
            builder.field(END_TIME, DATE_TIME_FORMATTER.format(Instant.ofEpochMilli(endTime).atZone(ZoneOffset.UTC)));  
            + state  
    }  
import org.opensearch.common.unit.TimeValue;
 * under the License.  
        if (state == SnapshotState.FAILED) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        return startTime == that.startTime
                shardFailures = new ArrayList<>();  
        }  
    public void writeTo(final StreamOutput out) throws IOException {
        this.startTime = startTime;
        builder.field(SUCCESSFUL_SHARDS, successfulShards);
    }  
    public SnapshotInfo(
            + ", version="
                        } else {
    /**  
        if (verbose || totalShards != 0) {
            + ", isRemoteStoreInteropEnabled="
                indices = Collections.emptyList();
        int successfulShards,  
        out.writeStringCollection(dataStreams);  
            if (shardFailures.isEmpty()) {
            + ", includeGlobalState="
                        } else {
    }
        private void setVersion(int version) {  
    private static final String DURATION_IN_MILLIS = "duration_in_millis";
    public RestStatus status() {  
    }
     * Constructs snapshot information from stream input
            );
     * Number of failed shards; a value of {@code 0} will be returned if there were no
        }
                        } else if (SUCCESSFUL_SHARDS.equals(currentFieldName)) {
     * Returns time when snapshot ended; a value of {@code 0L} will be returned if the
     * failed shards, or if {@link #state()} returns {@code null}.
    public SnapshotInfo basic() {
            && Objects.equals(version, that.version)  
        snapshotId = new SnapshotId(in);
            Version.CURRENT,
        Boolean remoteStoreIndexShallowCopy,
    ) {  
                            successfulShards = parser.intValue();  
                            uuid = parser.text();  
        return RestStatus.status(successfulShards, totalShards, shardFailures.toArray(new ShardOperationFailedException[0]));
        if (verbose || startTime != 0) {
        this(
    private static final String SHARDS = "shards";  
            out.writeBoolean(false);
import org.opensearch.core.common.io.stream.StreamOutput;
        } else {
        int totalShards,  
    }
    private static final String REASON = "reason";
     */
        this.userMetadata = userMetadata;
            totalShards,
        SnapshotInfoBuilder::new
            return null;
    public static final class SnapshotInfoBuilder {
        return endTime;
    }
        if (userMetadata != null) {
        private int successfulShards;
    private final String reason;  
    }
    /**
            int totalShards = shardStatsBuilder == null ? 0 : shardStatsBuilder.getTotalShards();
    }  
            builder.field(START_TIME_IN_MILLIS, startTime);  
        true,
        } else {
        SNAPSHOT_INFO_PARSER.declareLong(SnapshotInfoBuilder::setEndTime, new ParseField(END_TIME_IN_MILLIS));
            builder.field(REASON, reason);
     */  
        SnapshotState state,  
        }  
        long startTime,  
                successfulShards,
     * {@link #state()} returns {@code null}.
            successfulShards,
        Boolean includeGlobalState = null;
        Boolean remoteStoreIndexShallowCopy = null;  
        }  
    public String toString() {
    @Nullable
    private static final String FAILED = "failed";
package org.opensearch.snapshots;
    private static final String INCLUDE_GLOBAL_STATE = "include_global_state";  
    public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
     * Returns time when snapshot started; a value of {@code 0L} will be returned if
    private static final ObjectParser<ShardStatsBuilder, Void> SHARD_STATS_PARSER = new ObjectParser<>(
    @Nullable
    @Nullable
            reason,
 *
            includeGlobalState,
        }
                            while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
                    currentFieldName = parser.currentName();  
        }
        return builder;
            + ", reason='"
     * Returns total number of shards that were snapshotted; a value of {@code 0} will  
        SNAPSHOT_INFO_PARSER.declareStringArray(SnapshotInfoBuilder::setDataStreams, new ParseField(DATA_STREAMS));
    private static final String TOTAL = "total";
        SNAPSHOT_INFO_PARSER.declareObject(SnapshotInfoBuilder::setUserMetadata, (p, c) -> p.map(), new ParseField(USER_METADATA));
import java.util.Map;  
    /**
        List<String> dataStreams = Collections.emptyList();
     * @return custom metadata
            totalShards - shardFailures.size(),
                version,  
            builder.field(SUCCESSFUL, successfulShards);  
                        } else if (INCLUDE_GLOBAL_STATE.equals(currentFieldName)) {  
     * Returns the version of opensearch that the snapshot was created with.  Will only
    }
        builder.startObject(SNAPSHOT);
            startTime,
        Boolean remoteStoreIndexShallowCopy
     * This method creates a SnapshotInfo from internal x-content.  It does not  
        reason = in.readOptionalString();
    public Map<String, Object> userMetadata() {
            dataStreams,
     */
     * Gets a new {@link SnapshotInfo} instance from the given {@link SnapshotInfo} with
    public SnapshotInfo(SnapshotId snapshotId, List<String> indices, List<String> dataStreams, SnapshotState state) {
    private final long startTime;  
                            pinnedTimestamp = parser.longValue();
            + ", totalShards="
        return dataStreams;  
            && Objects.equals(userMetadata, that.userMetadata)
        for (String index : indices) {
     * @return snapshot start time
    }
            + successfulShards
    @Nullable
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
     *
            endTime,  
            0L,
        if (out.getVersion().onOrAfter(Version.V_2_9_0)) {
        String reason,
    /**
        if (SNAPSHOT.equals(currentFieldName)) {  
            reason,  
import org.opensearch.Version;
            + shardFailures
    }  
            if (FeatureFlags.isEnabled(FeatureFlags.SNAPSHOT_STRICT_VERSION_PARSING_SETTING)) {  
        builder.startArray(DATA_STREAMS);  
    public Version version() {
            return SnapshotState.FAILED;
    private static final Logger logger = LogManager.getLogger(SnapshotInfo.class);  
        private String snapshotUUID = null;  
            this.state = state;
                        } else if (UUID.equals(currentFieldName)) {
            shardFailures,  
            builder.field(USER_METADATA, userMetadata);
    private final SnapshotId snapshotId;  
     */
    /**
        long endTime = 0;
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    @Nullable
     * @return snapshot id  
        int getTotalShards() {
                shardFailures,
            entry.userMetadata(),  
            builder.field(END_TIME_IN_MILLIS, endTime);
        XContentParser.Token token;  
            totalShards,
        builder.field(UUID, snapshotId.getUUID());  
     * returning {@code null} for unsupported (e.g. legacy Elasticsearch) versions so that read-only
        private void setState(String state) {  
            SnapshotInfoBuilder::setShardFailures,  
        this.state = state;
    }  
    }
    }
        long endTime,
        int successfulShards = 0;  
        if (verbose || !shardFailures.isEmpty()) {
    private static final String START_TIME = "start_time";
        this.indices = Collections.unmodifiableList(Objects.requireNonNull(indices));
        }  
import java.time.Instant;  
        long endTime,
        if (verbose || endTime != 0) {
                version = resolveSnapshotVersion(this.version);
                        } else if (FAILURES.equals(currentFieldName)) {
        return startTime;
        if (in.getVersion().onOrAfter(Version.V_2_17_0)) {
import org.opensearch.common.util.FeatureFlags;  
        private int totalShards;  
        }  
        private void setEndTime(long endTime) {
            parser.nextToken();
/*  
        .thenComparing(SnapshotInfo::snapshotId);  
            entry.includeGlobalState(),
import java.util.Objects;
        private List<String> indices = null;  
        builder.field(NAME, snapshotId.getName());  
import org.opensearch.core.xcontent.ObjectParser;
        this(snapshotId, indices, dataStreams, state, null, null, 0L, 0L, 0, 0, Collections.emptyList(), null, null, null, 0);  
        if (parser.currentToken() == null) { // fresh parser? move to the first token  
    public SnapshotInfo(  
    }
        }  
        if (includeGlobalState != null) {
            this.successfulShards = successfulShards;  
        builder.field(UUID, snapshotId.getUUID());
            && Objects.equals(indices, that.indices)  
                            dataStreams = new ArrayList<>();  
        if (pinnedTimestamp != 0) {
        this.version = version;  
        if (version != null) {
        String uuid = null;  
            new SnapshotId(name, uuid),  
import java.util.Comparator;
     * Returns indices that were included in this snapshot.  
 * not use this file except in compliance with the License.
    @Override
    public SnapshotInfo(final StreamInput in) throws IOException {  
    @Nullable
 *
