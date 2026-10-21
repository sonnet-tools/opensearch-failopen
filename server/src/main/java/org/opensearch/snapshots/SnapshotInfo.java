    public int successfulShards() {
     * Returns snapshot failure reason; {@code null} if the snapshot succeeded.
                        } else if (TOTAL_SHARDS.equals(currentFieldName)) {
                            indices = Collections.unmodifiableList(indicesArray);
        }
        private long pinnedTimestamp = 0L;
                snapshotId,
    }
            builder.field(REMOTE_STORE_INDEX_SHALLOW_COPY, remoteStoreIndexShallowCopy);
        return remoteStoreIndexShallowCopy;
        builder.startObject();
        builder.field(START_TIME, startTime);
    /**
                            // It was probably created by newer version - ignoring
        List<String> dataStreams,
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
import java.time.ZoneOffset;
                indices = Collections.emptyList();
        private void setShardStatsBuilder(ShardStatsBuilder shardStatsBuilder) {
        SnapshotId snapshotId,
        }
        List<String> dataStreams,
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
        }
            logger.debug("Encountered unsupported snapshot version_id [{}]; reporting version as unknown", versionId);
    }
                                dataStreams.add(parser.text());
            this.reason = reason;
        out.writeVInt(successfulShards);
    private static final String SHARDS = "shards";
    public int totalShards() {
        return builder;
     * Number of failed shards; a value of {@code 0} will be returned if there were no
        }
    private final List<String> indices;
            builder.field(START_TIME_IN_MILLIS, startTime);
        builder.endArray();
        }
        SnapshotState state,
            );
                totalShards,
        this.endTime = endTime;
            out.writeBoolean(false);
        }
        }
            builder.endObject();
            return totalShards;
            && state == that.state
            Version.CURRENT,
import java.util.Objects;
    public void writeTo(final StreamOutput out) throws IOException {
            snapshotId,
     *
 * You may obtain a copy of the License at
    private final int totalShards;
    }
                            while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
            + ", shardFailures="
        successfulShards = in.readVInt();
            + totalShards
        }
            Version.CURRENT,
        private void setVersion(int version) {
            builder.field(VERSION_ID, version.id);
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
        builder.field(STATE, state);
                        } else if (UUID.equals(currentFieldName)) {
    /**
    /**
    }
     */
        long startTime,
    }
            0
    private Boolean includeGlobalState;
            for (SnapshotShardFailure shardFailure : shardFailures) {
            indices,
        private void setTotalShards(int totalShards) {
        if (reason == null) {
            startTime,
        out.writeVLong(startTime);
        Map<String, Object> userMetadata,
            this.state = state;
        for (String dataStream : dataStreams) {
        private void setState(String state) {
                shardFailures = new ArrayList<>();
        private void setSnapshotName(String snapshotName) {
            this.endTime = endTime;
            + ", totalShards="
            && Objects.equals(reason, that.reason)
     */
        builder.startArray(INDICES);
        return dataStreams;
     * @return snapshot state
/*
            if (this.version == -1) {
            builder.startArray(FAILURES);
     * @return snapshot start time
            out.writeOptionalBoolean(remoteStoreIndexShallowCopy);
        );
            this.snapshotName = snapshotName;
    private final long endTime;
        }
            snapshotId,
        private String snapshotName = null;
                        } else if (END_TIME.equals(currentFieldName)) {
        this.remoteStoreIndexShallowCopy = remoteStoreIndexShallowCopy;
        Boolean remoteStoreIndexShallowCopy,
            totalShards,
     * is only for display purposes and does not need to be parsed.
     * Returns shard failures; an empty list will be returned if there were no shard
    /**
    public SnapshotInfo(
        long startTime,
    }
            state,
                    } else if (token == XContentParser.Token.START_ARRAY) {
    public SnapshotInfo basic() {
                        } else if (REMOTE_STORE_INDEX_SHALLOW_COPY.equals(currentFieldName)) {
            includeGlobalState,
        for (String dataStream : dataStreams) {
            + version
    private static final String SUCCESSFUL = "successful";
                            uuid = parser.text();
    private static final String TOTAL_SHARDS = "total_shards";
        }
        Version version,
                shardFailures,
     */
        }
    }
            this.userMetadata = userMetadata;
    public List<String> dataStreams() {
            }
            out.writeVersion(version);
        if (CONTEXT_MODE_SNAPSHOT.equals(params.param(CONTEXT_MODE_PARAM))) {
    SnapshotInfo(
    private static final String USER_METADATA = "metadata";
     * Constructs snapshot information from stream input
        long pinnedTimestamp
    private static final String STATE = "state";
            indices,
        indices = Collections.unmodifiableList(in.readStringList());
                            remoteStoreIndexShallowCopy = parser.booleanValue();
        if (pinnedTimestamp != 0) {
 * software distributed under the License is distributed on an
    }
            + "snapshotId="
            this.shardFailures = shardFailures;
        this(
import org.opensearch.Version;
        SNAPSHOT_INFO_PARSER.declareObject(SnapshotInfoBuilder::setShardStatsBuilder, SHARD_STATS_PARSER, new ParseField(SHARDS));
        builder.field(SUCCESSFUL_SHARDS, successfulShards);
        private String snapshotUUID = null;
    @Nullable
            successfulShards,
    public String toString() {
        } else {
            SnapshotId snapshotId = new SnapshotId(snapshotName, snapshotUUID);
        Boolean includeGlobalState,
        if (parser.currentToken() == null) { // fresh parser? move to the first token
        return state;
    );
            && Objects.equals(remoteStoreIndexShallowCopy, that.remoteStoreIndexShallowCopy)
     * @return version of opensearch that the snapshot was created with
        ShardStatsBuilder.class.getName(),
    private static SnapshotState snapshotState(final String reason, final List<SnapshotShardFailure> shardFailures) {
            builder.field(REASON, reason);
        long endTime,
        if (in.getVersion().onOrAfter(Version.V_2_9_0)) {
        List<String> dataStreams = Collections.emptyList();
     * Returns time when snapshot started; a value of {@code 0L} will be returned if
        }
    private static final String SUCCESSFUL_SHARDS = "successful_shards";
            && Objects.equals(pinnedTimestamp, that.pinnedTimestamp);
            Collections.emptyList(),
            + reason
                            // It was probably created by newer version - ignoring
            + includeGlobalState
        int getTotalShards() {
        } else {
            builder.field(REASON, reason);
                        if (DATA_STREAMS.equals(currentFieldName)) {
 * the Apache License, Version 2.0 (the "License"); you may
    private final SnapshotId snapshotId;
            builder.value(index);
            builder.field(END_TIME_IN_MILLIS, endTime);
            return successfulShards;
                throw e;
                            ArrayList<SnapshotShardFailure> shardFailureArrayList = new ArrayList<>();
        this.reason = reason;
    @Nullable
    private final int successfulShards;
            builder.field(VERSION, version.toString());
        .thenComparing(SnapshotInfo::snapshotId);
        SnapshotInfoBuilder.class.getName(),
            return RestStatus.OK;
import org.opensearch.core.xcontent.XContentParserUtils;
    }
        String reason,
import org.opensearch.common.annotation.PublicApi;
 * Modifications Copyright OpenSearch Contributors. See
        long endTime,
        private List<SnapshotShardFailure> shardFailures = null;
        this(
    /**
        SHARD_STATS_PARSER.declareInt(ShardStatsBuilder::setTotalShards, new ParseField(TOTAL));
            version,
        } catch (Version.UnsupportedVersionException e) {
                        } else if (FAILURES.equals(currentFieldName)) {
            && totalShards == that.totalShards
            builder.field(PINNED_TIMESTAMP, pinnedTimestamp);
        int totalShards,
 * Licensed to Elasticsearch under one or more contributor
        this.snapshotId = Objects.requireNonNull(snapshotId);
    /**
    private long pinnedTimestamp;
 * Information about a snapshot
        }
 */
        builder.endObject();
    public SnapshotInfo(SnapshotId snapshotId, List<String> indices, List<String> dataStreams, SnapshotState state, Version version) {
                }
import java.util.List;
 * license agreements. See the NOTICE file distributed with
        private void setIncludeGlobalState(Boolean includeGlobalState) {
        SnapshotInfo that = (SnapshotInfo) o;
        }
            out.writeVLong(pinnedTimestamp);
        return version;
            entry.remoteStoreIndexShallowCopy(),
            && successfulShards == that.successfulShards
                        }
        // write snapshot info to repository snapshot blob format
        long startTime = 0;
            0,
            entry.snapshot().getSnapshotId(),
            SnapshotInfoBuilder::setShardFailures,
    public Version version() {
    /**
            + successfulShards
                            }
            reason,
                version = resolveSnapshotVersion(this.version);
        if (out.getVersion().onOrAfter(Version.V_2_9_0)) {
        if (verbose || totalShards != 0) {
     * failures, or if {@link #state()} returns {@code null}.
    }
     * @return custom metadata
        this.userMetadata = userMetadata;
        private void setSnapshotUUID(String snapshotUUID) {
 * specific language governing permissions and limitations
        List<String> indices,
     * @return number of shards
        }
            dataStreams,
    }
            pinnedTimestamp
    private final Map<String, Object> userMetadata;
                        } else if (INCLUDE_GLOBAL_STATE.equals(currentFieldName)) {
        private Map<String, Object> userMetadata = null;
            0,
            builder.field(SUCCESSFUL, successfulShards);
    }
    /**
        Map<String, Object> userMetadata = null;
        SNAPSHOT_INFO_PARSER.declareInt(SnapshotInfoBuilder::setVersion, new ParseField(VERSION_ID));
        List<String> indices,
                            endTime = parser.longValue();
        reason = in.readOptionalString();
     */
    public List<String> indices() {
        builder.startObject(SNAPSHOT);
@PublicApi(since = "1.0.0")
 * ownership. Elasticsearch licenses this file to you under
            entry.includeGlobalState(),
    );
    }
        );
                startTime,
import java.util.ArrayList;
        SNAPSHOT_INFO_PARSER.declareString(SnapshotInfoBuilder::setSnapshotUUID, new ParseField(UUID));
            + ", reason='"
import org.opensearch.repositories.IndexId;
            return RestStatus.INTERNAL_SERVER_ERROR;
    ) {
        int totalShards,
    private static final String TOTAL = "total";
        return reason;
            builder.field(TOTAL, totalShards);
        Boolean includeGlobalState,
        builder.startArray(DATA_STREAMS);
        this.includeGlobalState = includeGlobalState;
        }
            return null;
            shardFailures,
                        if (USER_METADATA.equals(currentFieldName)) {
            + ", startTime="
            reason,
     * compares the two snapshots by their snapshot ids.
        this(snapshotId, indices, dataStreams, state, null, version, 0L, 0L, 0, 0, Collections.emptyList(), null, null, null, 0);
        this.pinnedTimestamp = pinnedTimestamp;
        long pinnedTimestamp = 0;
     * Builds snapshot information
        return RestStatus.status(successfulShards, totalShards, shardFailures.toArray(new ShardOperationFailedException[0]));
            null,
            remoteStoreIndexShallowCopy,
            return Version.fromId(versionId);
        includeGlobalState = in.readOptionalBoolean();
        out.writeOptionalBoolean(includeGlobalState);
import java.util.Comparator;
    }
        SNAPSHOT_INFO_PARSER.declareString(SnapshotInfoBuilder::setSnapshotName, new ParseField(SNAPSHOT));
        snapshotId.writeTo(out);
        return totalShards - successfulShards;
        return includeGlobalState;
                version = Version.CURRENT;
     * @return list of data streams that were included in this snapshot.
     *
     * handle x-content written with the external version as external x-content
public final class SnapshotInfo implements Comparable<SnapshotInfo>, ToXContent, Writeable {
}
            shardFailure.toXContent(builder, params);
    private static final String START_TIME = "start_time";
            + state
            }
import org.opensearch.core.common.io.stream.StreamOutput;
        builder.field(VERSION_ID, version.id);
        private long endTime = 0L;
 * SPDX-License-Identifier: Apache-2.0
        private long startTime = 0L;
     *
        int successfulShards = 0;
     */
            && Objects.equals(shardFailures, that.shardFailures)
    private static final String REMOTE_STORE_INDEX_SHALLOW_COPY = "remote_store_index_shallow_copy";
import org.opensearch.common.unit.TimeValue;
            pinnedTimestamp
        if (version != null) {
                    if (token.isValue()) {
     * Returns indices that were included in this snapshot.
     */
        Boolean includeGlobalState = null;
    public RestStatus status() {
        List<SnapshotShardFailure> shardFailures,
            builder.endArray();
     * Returns snapshot state; {@code null} if the state is unknown.
    @Nullable
            shardFailures,
    static {
     * @return number of successful shards
    public static final class SnapshotInfoBuilder {
/*
     */
import org.opensearch.core.action.ShardOperationFailedException;
            this.remoteStoreIndexShallowCopy = remoteStoreIndexShallowCopy;
        );
    private static final String FAILED = "failed";
            totalShards - shardFailures.size(),
        if (includeGlobalState != null) {
 * KIND, either express or implied.  See the License for the
        out.writeMap(userMetadata);
        }
    private static final String INDICES = "indices";
     *
        Map<String, Object> userMetadata,
    }
                            parser.skipChildren();
        if (verbose || startTime != 0) {
        }
        private void setDataStreams(List<String> dataStreams) {
        }
            0L,
    private final SnapshotState state;
     */
     */
            builder.startObject(SHARDS);
            builder.value(dataStream);
        }
        List<SnapshotShardFailure> shardFailures,
        out.writeStringCollection(indices);
     */
            totalShards,
        state = in.readBoolean() ? SnapshotState.fromValue(in.readByte()) : null;
    public long getPinnedTimestamp() {
     * @opensearch.internal
            snapshotId,
        }
        this(snapshotId, indices, dataStreams, state, null, null, 0L, 0L, 0, 0, Collections.emptyList(), null, null, null, 0);
        }
        if (this == o) return true;
        long endTime,
    private static final Logger logger = LogManager.getLogger(SnapshotInfo.class);
     * Returns snapshot REST status
        List<String> dataStreams,
            remoteStoreIndexShallowCopy,
            + ", endTime="
            + ", successfulShards="
/**
        if (reason != null) {
        private Boolean remoteStoreIndexShallowCopy = null;
        if (shardFailures.size() == 0) {
            + ", state="
        builder.field(UUID, snapshotId.getUUID());
    }
        if (remoteStoreIndexShallowCopy != null) {
        snapshotId = new SnapshotId(in);
                        } else if (INDICES.equals(currentFieldName)) {
    }
    public SnapshotId snapshotId() {
    @Override
    public String reason() {
        SnapshotState state = SnapshotState.IN_PROGRESS;
        this.successfulShards = successfulShards;
        String name = null;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    currentFieldName = parser.currentName();
        List<SnapshotShardFailure> shardFailures = Collections.emptyList();
 */
    }
        // write snapshot info for the API and any other situations
        return Objects.hash(
        this.shardFailures = Objects.requireNonNull(shardFailures);
        return startTime == that.startTime
        private List<String> indices = null;
            reason,
        return snapshotId;
     */
            + ", indices="
            remoteStoreIndexShallowCopy,
        String reason,
            builder.field(USER_METADATA, userMetadata);
        }
        SNAPSHOT_INFO_PARSER.declareObject(SnapshotInfoBuilder::setUserMetadata, (p, c) -> p.map(), new ParseField(USER_METADATA));
            version,
    private static final String FAILURES = "failures";
            userMetadata,
            return new SnapshotInfo(
                            }
        private ShardStatsBuilder shardStatsBuilder = null;
            new SnapshotId(name, uuid),
        SnapshotId snapshotId,
        if (o == null || getClass() != o.getClass()) return false;
            pinnedTimestamp = in.readVLong();
 */
        }
     *
            builder.field(INCLUDE_GLOBAL_STATE, includeGlobalState);
    }
            endTime,
        );
    public boolean equals(Object o) {
    /**
            this.dataStreams = dataStreams;
        } else {
    private final Version version;
    private static final String END_TIME_IN_MILLIS = "end_time_in_millis";
    @Nullable
        SNAPSHOT_INFO_PARSER.declareLong(SnapshotInfoBuilder::setPinnedTimestamp, new ParseField(PINNED_TIMESTAMP));
        }
        XContentParser.Token token;
        if (version != null) {
        }
            entry.startTime(),
    }
            + shardFailures
        Map<String, Object> userMetadata,
    }
        true,
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
            startTime,
    @Nullable
        }
    @Nullable
            && Objects.equals(userMetadata, that.userMetadata)
            builder.value(index);
            endTime,
import java.util.stream.Collectors;
        }
    @Nullable
        Boolean includeGlobalState,
            includeGlobalState,
        startTime = in.readVLong();
            }
            builder.humanReadableField(DURATION_IN_MILLIS, DURATION, new TimeValue(Math.max(0L, endTime - startTime)));
 * under the License.
                remoteStoreIndexShallowCopy,
    private static Version resolveSnapshotVersion(int versionId) {
    }
            }
    public SnapshotInfo(final StreamInput in) throws IOException {
     *
                            shardFailures = Collections.unmodifiableList(shardFailureArrayList);
    private final List<String> dataStreams;
            snapshotState(reason, shardFailures),
                pinnedTimestamp
                return SnapshotState.SUCCESS;
        }
     *
    @Nullable
        }
 */
            && Objects.equals(version, that.version)
        return "SnapshotInfo{"
                    }
            builder.field(FAILED, failedShards());
    /**
            SnapshotInfoBuilder::setRemoteStoreIndexShallowCopy,
        ShardStatsBuilder::new
        List<String> indices = Collections.emptyList();
        private void setPinnedTimestamp(long pinnedTimestamp) {
                shardFailure.toXContent(builder, params);
    /**
        dataStreams = in.readStringList();
                        }
        builder.endArray();
        }
        return builder;
        if (pinnedTimestamp != 0) {
            return SnapshotState.FAILED;
     *
            reason,
    public SnapshotInfo(
            if (indices == null) {
            this.successfulShards = successfulShards;
        true,
        }
            }
            remoteStoreIndexShallowCopy,
                        } else if (PINNED_TIMESTAMP.equals(currentFieldName)) {
     * {@code 0} will be returned if {@link #state()} returns {@code null}.
            if (shardFailures == null) {
        this.dataStreams = Collections.unmodifiableList(Objects.requireNonNull(dataStreams));
    public static final String CONTEXT_MODE_PARAM = "context_mode";
            + ", pinnedTimestamp="
    private final String reason;
        long startTime,
     * returning {@code null} for unsupported (e.g. legacy Elasticsearch) versions so that read-only
            + snapshotId
        SnapshotInfoBuilder::new
        }
            + endTime
                            while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
            if (FeatureFlags.isEnabled(FeatureFlags.SNAPSHOT_STRICT_VERSION_PARSING_SETTING)) {
    public Boolean includeGlobalState() {
     *
        Boolean remoteStoreIndexShallowCopy,
        private void setReason(String reason) {
        out.writeList(shardFailures);
            + '}';
        return startTime;
        );
     * snapshot is still running or if {@link #state()} returns {@code null}.
        private void setUserMetadata(Map<String, Object> userMetadata) {
        return shardFailures;
    private static final String SNAPSHOT = "snapshot";
    }
    public static final ObjectParser<SnapshotInfoBuilder, Void> SNAPSHOT_INFO_PARSER = new ObjectParser<>(
            this.indices = indices;
            + ", isRemoteStoreInteropEnabled="
                return SnapshotState.PARTIAL;
                snapshotState,
                            includeGlobalState = parser.booleanValue();
            + pinnedTimestamp
    }
                        } else if (VERSION_ID.equals(currentFieldName)) {
        if (parser.currentToken() == XContentParser.Token.START_OBJECT) {  // on a start object move to next token
     * {@link #state()} returns {@code null}.
        }
        if (reason != null) {
            totalShards - shardFailures.size(),
        int successfulShards,
        return new SnapshotInfo(snapshotId, indices, Collections.emptyList(), state);
        SNAPSHOT_INFO_PARSER.declareObjectArray(
    }
    @Override
import org.opensearch.common.Nullable;
        builder.field(SNAPSHOT, snapshotId.getName());
     * Returns time when snapshot ended; a value of {@code 0L} will be returned if the
        return totalShards;
                version,
        return userMetadata;
        int getSuccessfulShards() {
                        if (NAME.equals(currentFieldName)) {
        version = in.readBoolean() ? in.readVersion() : null;
        }
        private void setEndTime(long endTime) {
    /**
            includeGlobalState,
import org.opensearch.cluster.SnapshotsInProgress;
    public Map<String, Object> userMetadata() {
        return pinnedTimestamp;
        }
    private static final Comparator<SnapshotInfo> COMPARATOR = Comparator.comparing(SnapshotInfo::startTime)
            builder.field(END_TIME, DATE_TIME_FORMATTER.format(Instant.ofEpochMilli(endTime).atZone(ZoneOffset.UTC)));
     */
        String reason = null;
        );
        }
    private static final String VERSION_ID = "version_id";
        String currentFieldName = parser.currentName();
    ) {
        return indices;
            && Objects.equals(snapshotId, that.snapshotId)
    public SnapshotState state() {
        builder.endArray();
     * @return list of indices
        SNAPSHOT_INFO_PARSER.declareString(SnapshotInfoBuilder::setReason, new ParseField(REASON));
    public SnapshotInfo(SnapshotsInProgress.Entry entry) {
        out.writeStringCollection(dataStreams);
            // the old format where there wasn't a UUID
            builder.field(START_TIME, DATE_TIME_FORMATTER.format(Instant.ofEpochMilli(startTime).atZone(ZoneOffset.UTC)));
        return COMPARATOR.compare(this, o);
            uuid = name;
            totalShards,
        }
            + ", includeGlobalState="
 *
        SHARD_STATS_PARSER.declareInt(ShardStatsBuilder::setSuccessfulShards, new ParseField(SUCCESSFUL));
        private String state = null;
    }
                        } else {
    public int failedShards() {
    private static final String END_TIME = "end_time";
 * Unless required by applicable law or agreed to in writing,
     * @return snapshot id
        List<SnapshotShardFailure> shardFailures,
    private static final ObjectParser<ShardStatsBuilder, Void> SHARD_STATS_PARSER = new ObjectParser<>(
import java.time.Instant;
        builder.startArray(INDICES);
    @Nullable
        SNAPSHOT_INFO_PARSER.declareBoolean(SnapshotInfoBuilder::setIncludeGlobalState, new ParseField(INCLUDE_GLOBAL_STATE));
        SNAPSHOT_INFO_PARSER.declareStringArray(SnapshotInfoBuilder::setIndices, new ParseField(INDICES));
     * @return shard failures
            this.version = version;
            }
            + remoteStoreIndexShallowCopy
        this.totalShards = totalShards;
        try {
            includeGlobalState,
    }
        Version version = Version.CURRENT;
        this.version = version;
        int totalShards,
        long endTime = 0;
            this.shardStatsBuilder = shardStatsBuilder;
            parser.nextToken();
        builder.field(NAME, snapshotId.getName());
 * @opensearch.api
    private XContentBuilder toXContentInternal(final XContentBuilder builder, final ToXContent.Params params) throws IOException {
            new ParseField(REMOTE_STORE_INDEX_SHALLOW_COPY)
            final Version version;
            return toXContentInternal(builder, params);
            && endTime == that.endTime
                    token = parser.nextToken();
            entry.indices().stream().map(IndexId::getName).collect(Collectors.toList()),
            int successfulShards = shardStatsBuilder == null ? 0 : shardStatsBuilder.getSuccessfulShards();
        }
            out.writeBoolean(true);
        }
            entry.userMetadata(),
        }
import org.opensearch.core.common.io.stream.Writeable;
                indices,
            + startTime
     * failed shards, or if {@link #state()} returns {@code null}.
            this.totalShards = totalShards;
            SnapshotState.IN_PROGRESS,
        out.writeOptionalString(reason);
            if (shardFailures.isEmpty()) {
                    } else if (token == XContentParser.Token.START_OBJECT) {
        return endTime;
     * @return snapshot failure reason
        Boolean remoteStoreIndexShallowCopy
        return successfulShards;
        userMetadata = in.readMap();
    }
 * not use this file except in compliance with the License.
                if (token == XContentParser.Token.FIELD_NAME) {
                reason,
        );
        if (remoteStoreIndexShallowCopy != null) {
                            while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
                userMetadata,
        }
                            state = SnapshotState.valueOf(parser.text());
            int totalShards = shardStatsBuilder == null ? 0 : shardStatsBuilder.getTotalShards();
     * be returned if {@link #state()} returns {@code null}.
        }
    private static final String NAME = "name";
        endTime = in.readVLong();
        final boolean verbose = params.paramAsBoolean("verbose", GetSnapshotsRequest.DEFAULT_VERBOSE_MODE);
                        } else if (START_TIME.equals(currentFieldName)) {
        }
        if (verbose || !shardFailures.isEmpty()) {
        private void setIndices(List<String> indices) {
            + '\''
                        } else {
            Version.CURRENT,
            remoteStoreIndexShallowCopy = in.readOptionalBoolean();
    private static final String UUID = "uuid";
     * Resolves the {@link Version} a snapshot was created with from its stored {@code version_id},
    @Override
            }
        }
import org.opensearch.core.xcontent.ToXContent;
        private Boolean includeGlobalState = null;
        private String reason = null;
            this.pinnedTimestamp = pinnedTimestamp;
 *
                                indicesArray.add(parser.text());
                            userMetadata = parser.map();
    }
    @Nullable
        SNAPSHOT_INFO_PARSER.declareString(SnapshotInfoBuilder::setState, new ParseField(STATE));
        String reason,
    private static final String REASON = "reason";
    public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
     * @return snapshot end time
            new ParseField(FAILURES)
     * return {@code null} if {@link #state()} returns {@code null} or {@link SnapshotState#INCOMPATIBLE}.
 * The OpenSearch Contributors require contributions made to
        for (String index : indices) {
            builder.value(dataStream);
            pinnedTimestamp
import org.opensearch.core.ParseField;
            this.startTime = startTime;
    private static final String DURATION = "duration";
import org.opensearch.common.util.FeatureFlags;
        List<String> indices,
            SnapshotShardFailure.SNAPSHOT_SHARD_FAILURE_PARSER,
        totalShards = in.readVInt();
        if (state == SnapshotState.FAILED) {
            shardFailures,
                            parser.skipChildren();
        if (includeGlobalState != null) {
        this(
            out.writeBoolean(false);
    }
     * This method creates a SnapshotInfo from internal x-content.  It does not
     * Returns total number of shards that were snapshotted; a value of {@code 0} will
package org.opensearch.snapshots;
            shardFailures,
                            }
        if (verbose || state != null) {
    @Nullable
                            ArrayList<String> indicesArray = new ArrayList<>();
        if (verbose || endTime != 0) {
    ) {
            this.snapshotUUID = snapshotUUID;
    }
        private void setSuccessfulShards(int successfulShards) {
import org.apache.logging.log4j.LogManager;
    public static SnapshotInfo fromXContentInternal(final XContentParser parser) throws IOException {
        }
            endTime,
    public static final String CONTEXT_MODE_SNAPSHOT = "SNAPSHOT";
 *
     */
        }
        if (state != null) {
     *
            dataStreams,
    }
     */
    public Boolean isRemoteStoreIndexShallowCopyEnabled() {
    @Override
import org.opensearch.core.rest.RestStatus;
    public long endTime() {
    public int compareTo(final SnapshotInfo o) {
        }
            0L
    }
            entry.dataStreams(),
        SNAPSHOT_INFO_PARSER.declareLong(SnapshotInfoBuilder::setStartTime, new ParseField(START_TIME_IN_MILLIS));
    /**
     *
import org.opensearch.common.time.DateFormatter;
     */
                        }
        int totalShards = 0;
        String uuid = null;
     * Returns snapshot id
            if (dataStreams == null) {
        Boolean remoteStoreIndexShallowCopy = null;
            state,
        }
     */
 *
 * this work for additional information regarding copyright
        builder.startArray(DATA_STREAMS);
            + indices
            builder.field(INCLUDE_GLOBAL_STATE, includeGlobalState);
        builder.endArray();
            snapshotState(reason, shardFailures),
            out.writeByte(state.value());
        }
        if (in.getVersion().onOrAfter(Version.V_2_17_0)) {
                dataStreams = Collections.emptyList();
 * this file be licensed under the Apache-2.0 license or a
        SNAPSHOT_INFO_PARSER.declareBoolean(
    private static final String INCLUDE_GLOBAL_STATE = "include_global_state";
            out.writeBoolean(true);
     * Gets a new {@link SnapshotInfo} instance from the given {@link SnapshotInfo} with
 * compatible open source license.
     * Returns the version of opensearch that the snapshot was created with.  Will only
        builder.field(UUID, snapshotId.getUUID());
        this.startTime = startTime;
        }
    @Override
     * operations such as listing snapshots do not fail for the whole repository.
     * @return number of failed shards
                        } else if (STATE.equals(currentFieldName)) {
                        } else if (REASON.equals(currentFieldName)) {
                            successfulShards = parser.intValue();
            builder.field(STATE, state);
     * Compares two snapshots by their start time; if the start times are the same, then
import org.opensearch.core.xcontent.XContentParser;
                dataStreams,
        private void setRemoteStoreIndexShallowCopy(Boolean remoteStoreIndexShallowCopy) {
        private void setStartTime(long startTime) {
        if (SNAPSHOT.equals(currentFieldName)) {
    }
import java.io.IOException;
            this.includeGlobalState = includeGlobalState;
            successfulShards,
            dataStreams,
        shardFailures = Collections.unmodifiableList(in.readList(SnapshotShardFailure::new));
            && Objects.equals(indices, that.indices)
            builder.field(REMOTE_STORE_INDEX_SHALLOW_COPY, remoteStoreIndexShallowCopy);
            userMetadata,
    private static final String START_TIME_IN_MILLIS = "start_time_in_millis";
                includeGlobalState,
        if (uuid == null) {
    /**
    private Boolean remoteStoreIndexShallowCopy;
import org.opensearch.core.xcontent.ObjectParser;
                            name = parser.text();
    private static final String DURATION_IN_MILLIS = "duration_in_millis";
            }
     *
            startTime,
                                shardFailureArrayList.add(SnapshotShardFailure.fromXContent(parser));
    /**
        out.writeVInt(totalShards);
            builder.field(PINNED_TIMESTAMP, pinnedTimestamp);
import org.opensearch.core.common.io.stream.StreamInput;
                endTime,
        }
                successfulShards,
        SNAPSHOT_INFO_PARSER.declareStringArray(SnapshotInfoBuilder::setDataStreams, new ParseField(DATA_STREAMS));
        builder.field(TOTAL_SHARDS, totalShards);
        SNAPSHOT_INFO_PARSER.declareLong(SnapshotInfoBuilder::setEndTime, new ParseField(END_TIME_IN_MILLIS));
        private void setShardFailures(List<SnapshotShardFailure> shardFailures) {
    }
        private List<String> dataStreams = null;
    private final List<SnapshotShardFailure> shardFailures;
            } else {
    @Nullable
     */
        public SnapshotInfo build() {
        this.indices = Collections.unmodifiableList(Objects.requireNonNull(indices));
        if (userMetadata != null) {
     * Returns total number of shards that were successfully snapshotted; a value of
import java.util.Map;
            userMetadata,
        long pinnedTimestamp
        private int version = -1;
     * Returns the custom metadata that was attached to this snapshot at creation time.
            SnapshotState snapshotState = state == null ? null : SnapshotState.valueOf(state);
    /**
     */
     */
    }
        builder.field(END_TIME, endTime);
    public List<SnapshotShardFailure> shardFailures() {
import org.apache.logging.log4j.Logger;
                            pinnedTimestamp = parser.longValue();
            } else {
        out.writeVLong(endTime);
        for (SnapshotShardFailure shardFailure : shardFailures) {
        private int totalShards;
            startTime,
        builder.field(USER_METADATA, userMetadata);
                            totalShards = parser.intValue();
    public int hashCode() {
            totalShards,
        builder.endArray();
        private int successfulShards;
    }
     * all information stripped out except the snapshot id, state, and indices.
import org.opensearch.core.xcontent.XContentBuilder;
                            version = resolveSnapshotVersion(parser.intValue());
    public long startTime() {
            + ", version="
    private final long startTime;
        }
 * GitHub history for details.
import java.util.Collections;
                            reason = parser.text();
            dataStreams,
        assert version != null : "version must always be known when writing a snapshot metadata blob";
    public SnapshotInfo(SnapshotId snapshotId, List<String> indices, List<String> dataStreams, SnapshotState state) {
            indices,
        }
        }
        builder.endObject();
/*
    /**
            endTime,
            userMetadata,
     */
    private static final String VERSION = "version";
    private static final DateFormatter DATE_TIME_FORMATTER = DateFormatter.forPattern("strict_date_optional_time");
            parser.nextToken();
        this.state = state;
        builder.startArray(FAILURES);
    private static final String DATA_STREAMS = "data_streams";
                        } else if (SUCCESSFUL_SHARDS.equals(currentFieldName)) {
    private static final class ShardStatsBuilder {
            && Objects.equals(includeGlobalState, that.includeGlobalState)
    }
            && Objects.equals(dataStreams, that.dataStreams)
                            startTime = parser.longValue();
        return new SnapshotInfo(
            indices,
    /**
    @Override
                            dataStreams = new ArrayList<>();
    private static final String PINNED_TIMESTAMP = "pinned_timestamp";
        SnapshotId snapshotId,
    /**
        for (String index : indices) {
