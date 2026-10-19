            this.repositoryStateId = repositoryStateId;
        public Map<String, Object> userMetadata() {
         * started.
        }
                }  
        long repositoryStateId,
            snapshot,  
            out.writeLong(startTime);  
                repositoryStateId,  
                    return WAITING;
import org.opensearch.core.xcontent.ToXContent;  
            if (!indices.equals(entry.indices)) return false;  
         * If the given shard assignments show all shard snapshots in a completed state then the returned instance will be of state
    private static final String REPOSITORY_STATE_ID = "repository_state_id";
        for (final ShardSnapshotStatus status : shards) {  
            Snapshot snapshot,
            return result;
        }
            long startTime,
            return dataStreams;  
            this(
                    startTime,
            }
    }
                partial,
            for (final Map.Entry<ShardId, ShardSnapshotStatus> shard : entry.shards().entrySet()) {
 * SPDX-License-Identifier: Apache-2.0
                startTime,
                    return INIT;
            final Map<ShardId, ShardSnapshotStatus> shards,  
        return builder.append("]").toString();  
                shards,
            boolean remoteStoreIndexShallowCopyV2
         * @return new snapshot entry
                shards,  
        public Version version() {  
         * Same as {@link #withShardStates} but does not check if the snapshot completed and thus is only to be used when starting new
 * the Apache License, Version 2.0 (the "License"); you may
                    remoteStoreIndexShallowCopy
 * GitHub history for details.
                remoteStoreIndexShallowCopyV2
            return EMPTY;  
                remoteStoreIndexShallowCopy,  
        private final boolean completed;
                && Objects.equals(generation, status.generation)
            partial = in.readBoolean();
            state = State.fromValue(in.readByte());
            this(
    private static final String UUID = "uuid";
                dataStreams,
                out.writeByte(State.SUCCESS.value());
                shards,
            boolean completed = true;  
        INIT((byte) 0, false),
                repositoryStateId,
            return withStartedShards(shards);
            String failure,
            Entry entry = (Entry) o;
            true,  
                remoteStoreIndexShallowCopy,
        public boolean isFragment() {  
            List<IndexId> indices,
                userMetadata,
                    : "Completed state must imply all shards completed but saw state [" + state + "] and shards " + shards;  
        }
            List<String> dataStreams,  
        public ShardState state() {
            {
            Version version,  
        }  
import org.opensearch.repositories.RepositoryShardId;
                snapshot,
                remoteStoreIndexShallowCopy = false;
            }
        private final boolean failed;
        }  
                userMetadata,
                partial,  
        return new SnapshotsInProgress(Collections.unmodifiableList(entries));
        List<String> dataStreams,  
import org.opensearch.common.Nullable;  
            if (clones.equals(((Entry) o).clones) == false) return false;
            builder.array(DATA_STREAMS, dataStreams.toArray(new String[0]));
                case 3:  
                    return STARTED;  
        @Override  
         * it's moved to state {@link State#ABORTED}.  
        }
        private final long repositoryStateId;  
        SnapshotId source,
                shards,
        public Map<ShardId, ShardSnapshotStatus> shards() {
                userMetadata,  
 */  
            Collections.emptyMap(),  
        }  
        public boolean equals(Object o) {  
                shardsBuilder.put(shardEntry.getKey(), status);  
            return false;
            out.writeBoolean(partial);
         * Shard snapshot is waiting for the primary to snapshot to become available.
                Map.of(),  
        @Override
        }
            State.STARTED,
        }
                    includeGlobalState,
         */  
                repositoryStateId,
     * @param startTime start time  
    public static NamedDiff<Custom> readDiffFrom(StreamInput in) throws IOException {
            result = 31 * result + version.hashCode();
        SnapshotId source,  
        assert assertConsistentEntries(entries);
            this(
        }  
        private final Snapshot snapshot;
        Snapshot snapshot,
        }  
            if (remoteStoreIndexShallowCopyV2 != entry.remoteStoreIndexShallowCopyV2) return false;  
            userMetadata = in.readMap();
            this.includeGlobalState = includeGlobalState;
            this.completed = completed;
        private final byte value;
                    repositoryStateId,
            {
        private final ShardState state;
            if (repositoryStateId != entry.repositoryStateId) return false;
        @Override
        public boolean partial() {  
import org.opensearch.core.common.Strings;  
                out.writeBoolean(remoteStoreIndexShallowCopyV2);
            this(nodeId, state, null, generation);  
            return true;  
/*  
            dataStreams,  
                    ShardSnapshotStatus status = shardEntry.getValue();
                case 6:  
                assert (state.completed() && shardsCompleted) || (state.completed() == false && shardsCompleted == false)
        STARTED((byte) 1, false),
    }
                    indices,
    public static SnapshotsInProgress of(List<Entry> entries) {
                remoteStoreIndexShallowCopyV2 = in.readBoolean();
            SnapshotId source,
            final Set<String> indexNames = indices.stream().map(IndexId::getName).collect(Collectors.toSet());
     */
        }
        for (Entry entry : entries) {  
            startTime,
        }
            Map.of(),  
    private static final String INDICES = "indices";  
                remoteStoreIndexShallowCopy,  
    }
            startTime,
                    userMetadata,
            if (remoteStoreIndexShallowCopy != entry.remoteStoreIndexShallowCopy) return false;
import org.opensearch.common.annotation.PublicApi;
                return new Entry(  
        public static final ShardSnapshotStatus MISSING = new SnapshotsInProgress.ShardSnapshotStatus(
            Map.of(),
        }
        public boolean isActive() {
            if (source == null || clones.isEmpty() == false) {
            State state,  
            result = 31 * result + indices.hashCode();
        boolean remoteStoreIndexShallowCopy,  
                partial,  
 * under the License.  
                + "] must be higher than current generation ["  
            snapshot,
        PARTIAL((byte) 5, false);  
            switch (value) {
            );
            repositoryStateId,  
            out.writeVersion(version);
         */
        /**
                    );  
            if (completed(shards.values())) {
    ) {  
            this.reason = reason;  
            result = 31 * result + (includeGlobalState ? 1 : 0);
        // visible for testing, use #startedEntry and copy constructors in production code  
            return source != null;
import org.opensearch.snapshots.InFlightShardSnapshotStates;
            return version;
            out.writeBoolean(includeGlobalState);  
import org.opensearch.snapshots.Snapshot;  
            List<IndexId> indices,
            indices,  
                null,  
                case 2:
            snapshot,
     * @param version repository metadata version to write
     * Entry in the collection.
                    return SUCCESS;
            version,
        public static final ShardSnapshotStatus UNASSIGNED_QUEUED = new SnapshotsInProgress.ShardSnapshotStatus(  
        }  
                assert source == null || s.getValue().nodeId == null  
            out.writeLong(repositoryStateId);
        FAILED((byte) 3, true),
            out.writeMap(userMetadata);
            repositoryStateId = in.readLong();  
        private boolean assertConsistent() {
import java.util.stream.Collectors;  
                + newRepoGen
            this.indices = indices;
                dataStreams,  
        }
            if (version.equals(entry.version) == false) return false;
            boolean includeGlobalState,
         */  
     * @opensearch.internal
            return new Entry(  
    }
    }
        Map<String, Object> userMetadata,
            @Nullable SnapshotId source,
            return nodeId;
        for (Entry entry : entries) {
        /**
            this.startTime = startTime;  
 * software distributed under the License is distributed on an
            if (value.state().failed()) {
     * Creates the initial {@link Entry} when starting a snapshot, if no shard-level snapshot work is to be done the resulting entry
            this.shards = Collections.unmodifiableMap(shards);
        }
import org.opensearch.core.xcontent.MediaTypeRegistry;
            long startTime,
     * @opensearch.api  
                remoteStoreIndexShallowCopy  
            includeGlobalState = in.readBoolean();  
            if (updatedClones.equals(clones)) {  
        ABORTED((byte) 4, false, true),
                source,
                }
 * Modifications Copyright OpenSearch Contributors. See
                + repositoryStateId
 * Unless required by applicable law or agreed to in writing,
                + indexNames
        StringBuilder builder = new StringBuilder("SnapshotsInProgress[");
        ) {  
            if (includeGlobalState != entry.includeGlobalState) return false;  
                source,
        return Version.CURRENT.minimumCompatibilityVersion();
        boolean partial,
            includeGlobalState,
                entry.userMetadata,  
    public static final SnapshotsInProgress EMPTY = new SnapshotsInProgress(Collections.emptyList());  
            for (final Map.Entry<ShardId, ShardSnapshotStatus> shardEntry : shards.entrySet()) {
        QUEUED((byte) 7, false, false);
        /**
                    dataStreams,  
            version,
            List<String> dataStreams,  
            String failure,
            this.snapshot = snapshot;
    }
            repositoryStateId,
        }
        );  
    /**  
        );
        public String failure() {
        /**  
                case 4:
                    State.SUCCESS,
        }
        private Entry(  
            final Map<String, Object> userMetadata,
            if (in.getVersion().onOrAfter(Version.V_2_9_0)) {
            } else {  
         * Shard snapshot status for shards that could not be snapshotted because their index was deleted from before the shard snapshot
            shards,
public class SnapshotsInProgress extends AbstractNamedDiffable<Custom> implements Custom {
        @Nullable
                    return MISSING;
    }  
            if (startTime != entry.startTime) return false;
    public void writeTo(StreamOutput out) throws IOException {
            out.writeOptionalWriteable(source);
        long startTime,
        public Entry(  
        if (this == o) return true;
            remoteStoreIndexShallowCopy  
            final Map<ShardId, ShardSnapshotStatus> shardsBuilder = new HashMap<>();
    private static final String START_TIME_MILLIS = "start_time_millis";
        }
        long startTime,
 */
     * Creates the initial snapshot clone entry
        return new SnapshotsInProgress.Entry(
 * You may obtain a copy of the License at  
            if ((out.getVersion().before(Version.V_2_14_0)) && state == State.PARTIAL) {
            builder.humanReadableField(START_TIME_MILLIS, START_TIME, new TimeValue(startTime));
            }
            final Set<String> indexNamesInShards = new HashSet<>();  
    /**
            List<IndexId> indices,
    /**  
            }
import org.opensearch.common.unit.TimeValue;
            this.state = state;
                if (shard.getValue().isActive()) {  
            // while updating entry with clone jobs  
            this.value = value;
                indices,
                default:
 * compatible open source license.
    }
            result = 31 * result + (source == null ? 0 : source.hashCode());  
        public ShardSnapshotStatus(@Nullable String nodeId, ShardState state, String reason, @Nullable String generation) {  
        final Map<ShardId, ShardSnapshotStatus> shards,  
         */  
                }
            this.remoteStoreIndexShallowCopy = remoteStoreIndexShallowCopy;
     * Checks if all shards in the list have completed  
            }  
        private final List<IndexId> indices;  
        return new SnapshotsInProgress.Entry(
            entry.toXContent(builder, params);
            assert updated.state().completed() == false && completed(updated.shards().values()) == false  
            }
            return new Entry(  
                failure,
                entry.partial,
        @Nullable  
            }
                    return SUCCESS;
                startTime,  
    public static boolean completed(final Collection<ShardSnapshotStatus> shards) {
            Map<String, Object> userMetadata,
            return new Entry(  
                case 0:  
            switch (value) {
     */
                    index.toXContent(builder, params);  
        );
        WAITING((byte) 6, false, false),
        );  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                indices,
         */
    @Override  
import org.opensearch.core.common.io.stream.StreamOutput;
        }
            startTime,
            result = 31 * result + (generation != null ? generation.hashCode() : 0);
    @Override
            String failure
    public boolean equals(Object o) {
        @Override  
                failure,
        private static boolean assertShardsConsistent(
            builder.field(PARTIAL, partial);
            final Map<ShardId, ShardSnapshotStatus> shards,  
            long startTime,
                includeGlobalState,
        private final String reason;
                state,
                    return ABORTED;  
            List<IndexId> indices,  
            this.state = state;  
            startTime,  
    ) {
    private static final String NODE = "node";
                version,  
                state,  
                entry.startTime,
    @Override  
    }  
        }
            this.version = version;
                + " differ from expected indices "  
        }  
            return new ShardSnapshotStatus(nodeId, state, reason, generation);
            ShardState.MISSING,  
        @Override
                        : "Found duplicate shard assignments in " + entries;
        for (Entry entry : entries) {
                version,
                indices,
                this.clones = Map.of();  
            if (curr.equals(snapshot)) {
            long repositoryStateId,  
            this.generation = generation;
        @Override  
        public byte value() {
                partial,
            if (this == o) return true;
        this.entries = in.readList(SnapshotsInProgress.Entry::new);  
 * ownership. Elasticsearch licenses this file to you under  
    public static final String TYPE = "snapshots";
            boolean remoteStoreIndexShallowCopyV2
                    + clones
        }
                includeGlobalState,
        }  
        /**
                remoteStoreIndexShallowCopy = in.readBoolean();
        }
        private final String generation;
    @Override
        public int hashCode() {
        @Override
        }
                    ShardId shardId = shardEntry.getKey();  
        }
                // Setting to SUCCESS for partial snapshots in older versions to maintain backward compatibility  
                startTime,
        public Entry withStartedShards(final Map<ShardId, ShardSnapshotStatus> shards) {
 * Meta data about snapshots that are currently executing  
            if (source != null && state.completed()) {
            remoteStoreIndexShallowCopyV2
 *
                    return QUEUED;  
            if (this == o) return true;  
        public SnapshotId source() {
         * If the instance had no in-progress shard snapshots assigned to data nodes it's moved to state {@link State#SUCCESS}, otherwise
        @Override
            return state == ShardState.INIT || state == ShardState.ABORTED || state == ShardState.WAITING;
            "missing index",
            State state,
        public static State fromValue(byte value) {
        public Snapshot snapshot() {
                repositoryStateId,
            }
            out.writeOptionalString(reason);
            false,
            indices,  
                dataStreams,  
            boolean includeGlobalState,  
                    throw new IllegalArgumentException("No shard snapshot state for value [" + value + "]");
        public Entry withRemoteStoreIndexShallowCopy(final boolean remoteStoreIndexShallowCopy) {
     * Status of shard snapshots.  
        public long startTime() {
            return true;  
            snapshot.writeTo(out);
            return Strings.toString(MediaTypeRegistry.JSON, this);  
        }
    }  
package org.opensearch.cluster;
                startTime,
        public int hashCode() {
            final Map<ShardId, ShardSnapshotStatus> shards,  
                shards,  
            return completed;
                indexNamesInShards.add(s.getKey().getIndexName());
    }
            remoteStoreIndexShallowCopyV2,
                includeGlobalState,
            false// initialising to false, will be updated in startCloning method of SnapshotsService while updating entry with
            out.writeMap(clones, (o, v) -> v.writeTo(o), (o, v) -> v.writeTo(o));
        return readDiffFrom(Custom.class, TYPE, in);
    private static final String STATE = "state";
            builder.startObject();
        @Nullable
        Map<String, Object> userMetadata,
     * The shard state.  
        public String nodeId() {
    @Override  
                includeGlobalState,
            final Map<ShardId, ShardSnapshotStatus> shards,  
        /**
                source,
            null,
        private final State state;
         * What version of metadata to use for the snapshot in the repository
/*  
        ) {
        public List<IndexId> indices() {
            failure = in.readOptionalString();
            result = 31 * result + shards.hashCode();
                        builder.field(STATE, status.state());  
            return indices;
                shards,  
                repositoryStateId,
            boolean allQueued = true;
        /**  
                snapshot,  
    private static final String START_TIME = "start_time";  
                assert clones == null || clones.isEmpty() : "Provided [" + clones + "] but no source";
            State state,  
            InFlightShardSnapshotStates.forRepo(repoName, entries);
                + "]";
import java.util.HashMap;  
 *     http://www.apache.org/licenses/LICENSE-2.0
     * will be in state {@link State#SUCCESS} right away otherwise it will be in state {@link State#STARTED}.
        }
        this.entries = entries;  
            snapshot = new Snapshot(in);
                return UNASSIGNED_QUEUED;  
        private final byte value;
            return updated;
        long startTime,  
                        nodeId == null ? ShardState.FAILED : ShardState.ABORTED,  
                state,
    /**
        public ShardSnapshotStatus(String nodeId, String generation) {
            assert source == null || indexNames.isEmpty() == false : "No empty snapshot clones allowed";  
        }  
         */
                    + "]";
        ShardState(byte value, boolean completed, boolean failed) {
                dataStreams,  
                Map.of(),  
            Map<String, Object> userMetadata,  
        boolean remoteStoreIndexShallowCopy  
            if (source == null) {
        private final boolean partial;
                + indexNamesInShards
        }
            builder.endArray();  
                entry.snapshot,
        }  
            Collections.emptyList(),
            result = 31 * result + (nodeId != null ? nodeId.hashCode() : 0);  
        private final Map<ShardId, ShardSnapshotStatus> shards;
            builder.field(REPOSITORY_STATE_ID, repositoryStateId);
import java.util.HashSet;
            }
        public boolean failed() {
                repositoryStateId,  
        List<IndexId> indices,
    public String getWriteableName() {
        private final boolean remoteStoreIndexShallowCopy;
                failure,
        ) {  
            String nodeId = in.readOptionalString();
         */
            builder.endObject();
        @Override
                state,
                newRepoGen,
            assert source != null || indexNames.equals(indexNamesInShards) : "Indices in shards "
    private static final String INCLUDE_GLOBAL_STATE = "include_global_state";  
            Snapshot snapshot,
        return true;
        }
            return remoteStoreIndexShallowCopyV2;
                repositoryStateId,  
            List<String> dataStreams,
                indices,  
                default:  
        public Entry(
            long repositoryStateId,
                    assert assignedShardsByRepo.computeIfAbsent(entry.repository(), k -> new HashSet<>()).add(shard.getKey())
import org.opensearch.core.common.io.stream.StreamInput;
        @Override
            return Objects.equals(nodeId, status.nodeId)  
        }
        }
                    + "] but state was ["
        private final Map<RepositoryShardId, ShardSnapshotStatus> clones;
                case 2:
                snapshot,
        @Nullable
                includeGlobalState,  
            indices,
        }  
        List<String> dataStreams,  
 * specific language governing permissions and limitations
            }
            if (status.state().completed == false) {
            State state,
        private final List<String> dataStreams;
         */  
        public String toString() {
                case 5:
            shards.entrySet().forEach(s -> {
                snapshot,
            if (out.getVersion().onOrAfter(Version.V_2_9_0)) {  
            includeGlobalState,
            dataStreams,
        long repositoryStateId,
                source,
    }  
        }
import org.opensearch.core.xcontent.XContentBuilder;
            if (o == null || getClass() != o.getClass()) return false;
        FAILED((byte) 3, true, true),
    private final List<Entry> entries;  
            remoteStoreIndexShallowCopyV2// initialising to false, will be updated in startCloning method of SnapshotsService
            return "ShardSnapshotStatus[state=" + state + ", nodeId=" + nodeId + ", reason=" + reason + ", generation=" + generation + "]";
            this.dataStreams = dataStreams;
        }  
        private final boolean completed;  
import org.opensearch.cluster.ClusterState.Custom;
        boolean includeGlobalState,  
import org.opensearch.core.common.io.stream.Writeable;  
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
        SUCCESS((byte) 2, true, false),  
        }  
    public static Entry startedEntry(
        @Nullable  
        INIT((byte) 0, false, false),
            } else {
            long repositoryStateId,
     * @opensearch.internal
     *
            List<IndexId> indices,
                shards,
        @Override  
            long repositoryStateId,
    public enum State {  
            userMetadata,
        public static ShardSnapshotStatus readFrom(StreamInput in) throws IOException {  
        if (entries.isEmpty()) {
            this(
            builder.field(REPOSITORY, snapshot.getRepository());  
            shards = in.readMap(ShardId::new, ShardSnapshotStatus::readFrom);
        }  
            boolean remoteStoreIndexShallowCopy
            Version version,  
            version,  
    }  
    ) {  
                entry.dataStreams,
            return this.snapshot;
            final Snapshot curr = entry.snapshot();
            if (!snapshot.equals(entry.snapshot)) return false;
                    shards,  
     */  
        ) {  
            return source;  
 * this work for additional information regarding copyright
        }  
                    }
            null
                startTime,
            @Nullable final Map<RepositoryShardId, ShardSnapshotStatus> clones,
        public Entry(
                null,
    private static final String PARTIAL = "partial";
    private static boolean hasFailures(final Map<RepositoryShardId, ShardSnapshotStatus> clones) {
        }
            // If the state is failed we have to have a reason for this failure  
            null,
        List<IndexId> indices,
                out.writeByte(state.value());  
            if (!shards.equals(entry.shards)) return false;
                completed(updatedClones.values()) ? (hasFailures(updatedClones) ? State.FAILED : State.SUCCESS) : state,
        /**
    public static Entry startClone(
    }  
            final SnapshotsInProgress.Entry updated = new Entry(  
                failure,
        public ShardSnapshotStatus(@Nullable String nodeId, ShardState state, @Nullable String generation) {
            result = 31 * result + (remoteStoreIndexShallowCopy ? 1 : 0);
        Snapshot snapshot,
            return userMetadata;  
        }
        }  
        public List<String> dataStreams() {
    }
            return builder;  
            String failure,
     * @param repositoryStateId repository state id that this clone is based on
        boolean remoteStoreIndexShallowCopyV2
            );  
                failure,
        public long repositoryStateId() {
                state,
            }  
            this.source = source;  
        Snapshot snapshot,  
 * not use this file except in compliance with the License.
                builder.append(",");  
                failure,
            boolean partial,  
        ) {
         */  
            builder.startArray(INDICES);  
            indices = in.readList(IndexId::new);  
        }  
import org.opensearch.snapshots.SnapshotId;
     *  
 *
            shards,  
     *
        }
                    builder.startObject();
 */  
                        nodeId,
import java.util.Set;
        private final long startTime;
        public Entry fail(final Map<ShardId, ShardSnapshotStatus> shards, State state, String failure) {
                        status.generation()
    public String toString() {
                );
            null  
            out.writeOptionalString(failure);  
                userMetadata,
                this.clones = Collections.unmodifiableMap(clones);
            );  
 * Licensed to Elasticsearch under one or more contributor  
     * @opensearch.internal
                startTime,
         */
        }  
         * shard snapshots on data nodes for a running snapshot.  
        out.writeList(entries);
        ABORTED((byte) 4, false),
            return repositoryStateId;
                userMetadata,
                assert hasFailures(clones) == false || state == State.FAILED : "Failed shard clones in ["  
            return failure;  
        /**
                && Objects.equals(reason, status.reason)
         * the same way {@link #shards} tracks the status of each shard snapshot operation in non-clone entries.  
            completed(shards.values()) ? State.SUCCESS : State.STARTED,  
            final Map<RepositoryShardId, ShardSnapshotStatus> clones  
        public Entry withRepoGen(long newRepoGen) {  
                for (final Map.Entry<ShardId, ShardSnapshotStatus> shardEntry : shards.entrySet()) {
        }
            repositoryStateId,
    private static final String SHARDS = "shards";
                    final String nodeId = status.nodeId();  
                        builder.field(SHARD, shardId.getId());
            true,  
        public void writeTo(StreamOutput out) throws IOException {  
    private static final String SHARD = "shard";
        }  
            source,
                + "]";
            }  
    public Entry snapshot(final Snapshot snapshot) {
        }  
    public static class Entry implements Writeable, ToXContent, RepositoryOperation {  
                clones,
            partial,
         */
        public String toString() {
                    status = new ShardSnapshotStatus(
                return true;  
        if (o == null || getClass() != o.getClass()) return false;  
            builder.append(entries.get(i).snapshot().getSnapshotId().getName());
                snapshot,
                completed &= status.state().completed();
        boolean includeGlobalState,  
    /**
         * {@code null} since no abort is needed and the snapshot can simply be removed from the cluster state outright.
            Entry entry,
        public Entry abort() {
                    partial,  
         * data node or to {@link ShardState#FAILED} if not assigned to any data node.
                startTime,
            Map.of(),  
            if (Objects.equals(source, ((Entry) o).source) == false) return false;  
        }  
            builder.endArray();  
        private final boolean remoteStoreIndexShallowCopyV2;  
        return false;
        private final Map<String, Object> userMetadata;
            List<IndexId> indices,
        }
                dataStreams,  
        @Nullable
        @Nullable  
            int result = state.hashCode();  
         * Create a new instance that has its shard assignments replaced by the given shard assignment map.  
        List<IndexId> indices,
        Snapshot snapshot,
        Version version
            return state;
            );
                indices,
                version,
        }
            Collections.emptyMap(),  
            );
            result = 31 * result + (partial ? 1 : 0);  
                ShardSnapshotStatus status = shardEntry.getValue();  
        return this.entries;
                remoteStoreIndexShallowCopyV2 = false;  
        Version version,
         *  
     * @param indices  indices to clone
                updatedClones,
            null,
                version,  
        // see #useShardGenerations
            return reason;
            State state,
            }
            assert this.remoteStoreIndexShallowCopyV2  
                partial,  
                remoteStoreIndexShallowCopyV2
                case 5:
import org.opensearch.Version;
                remoteStoreIndexShallowCopy,  
            return new Entry(  
                remoteStoreIndexShallowCopy,
        long startTime,
                    version,  
            null,
     */  
            null,
    public List<Entry> entries() {
            }  
            startTime = in.readLong();
     * @param shards list of shard statuses
        public String reason() {
        /**
        for (int i = 0; i < entries.size(); i++) {  
            return includeGlobalState;  
            return clones;
        @Override  
                    {  
            this(nodeId, ShardState.INIT, generation);
            boolean includeGlobalState,
import org.opensearch.repositories.IndexId;
        private final String nodeId;
 *
                        builder.field(NODE, status.nodeId());
    public static Entry startClone(
        );
            boolean partial,  
            result = 31 * result + Long.hashCode(startTime);  
/*
        }
                remoteStoreIndexShallowCopy
            if (state != entry.state) return false;  
    }
        private final Version version;
            boolean remoteStoreIndexShallowCopy  
    private SnapshotsInProgress(List<Entry> entries) {
            return remoteStoreIndexShallowCopy;
        }
        }
                partial,  
            result = 31 * result + clones.hashCode();
                indices,
import java.util.List;
        public Map<RepositoryShardId, ShardSnapshotStatus> clones() {
 */  
            builder.field(INCLUDE_GLOBAL_STATE, includeGlobalState());  
            }
            long repositoryStateId,
        boolean remoteStoreIndexShallowCopyV2
     */
            completed(shards.values()) ? State.SUCCESS : State.STARTED,
import org.opensearch.core.index.shard.ShardId;
            this.completed = completed;  
        public boolean completed() {  
                allQueued &= status.state() == ShardState.QUEUED;
            remoteStoreIndexShallowCopy,
        return new SnapshotsInProgress.Entry(  
            out.writeOptionalString(nodeId);
                entry.remoteStoreIndexShallowCopy
                includeGlobalState,  
                    return ABORTED;  
                return true;
            ShardState.QUEUED,
        long repositoryStateId,
            });
        return entries.hashCode();  
    }
    public enum ShardState {
            Map<String, Object> userMetadata,
     * @param snapshot snapshot to clone into  
            source = in.readOptionalWriteable(SnapshotId::new);
        final Map<String, Set<ShardId>> assignedShardsByRepo = new HashMap<>();  
            final boolean shardsCompleted = completed(shards.values()) && completed(clones.values());
            boolean partial,
import java.util.Map;  
                includeGlobalState,
                || assertShardsConsistent(this.source, this.state, this.indices, this.shards, this.clones);
                remoteStoreIndexShallowCopy,  
        Version version,
            }
            partial,  
        /**
     *
            if ((state == State.INIT || state == State.ABORTED) && shards.isEmpty()) {
         * @param shards new shard snapshot states
            return snapshot.getRepository();
            result = 31 * result + (remoteStoreIndexShallowCopyV2 ? 1 : 0);  
            repositoryStateId,  
import org.opensearch.repositories.RepositoryOperation;  
         */
        public Entry withClones(final Map<RepositoryShardId, ShardSnapshotStatus> updatedClones) {
            out.writeMap(shards, (o, v) -> v.writeTo(o), (o, v) -> v.writeTo(o));
        }
    private static final String INDEX = "index";  
        return null;  
            result = 31 * result + (reason != null ? reason.hashCode() : 0);
            }
         * ({@link ShardState#INIT} or {@link ShardState#ABORTED}) or about to write to it in state {@link ShardState#WAITING}.
        public boolean equals(Object o) {
            );
            this.failure = failure;  
            clones = in.readMap(RepositoryShardId::new, ShardSnapshotStatus::readFrom);  
                if (status.state().completed() == false) {
            return true;
            false,
         * In the special case where this instance has not yet made any progress on any shard this method just returns
        }
            Map.of(),
        return true;
            // make sure in-flight-shard-states can be built cleanly for the entries without tripping assertions
 * KIND, either express or implied.  See the License for the
                dataStreams,
                    builder.endObject();  
                partial,
            return startTime;
    public static Entry startedEntry(
            long startTime,
                    : "Shard snapshot must not be assigned to data node when copying from snapshot [" + source + "]";
            Version version,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        @Nullable
                failure,
            State.STARTED,
                + state  
            return this.generation;
            version = in.readVersion();  
            if (out.getVersion().onOrAfter(Version.V_2_18_0)) {  
            if (state == ShardState.QUEUED) {
            State state,
import java.util.Collection;
    /**  
     *
    /**
            return fail(shardsBuilder, completed ? State.SUCCESS : State.ABORTED, ABORTED_FAILURE_TEXT);
            }
            this.userMetadata = userMetadata;
    private static boolean assertConsistentEntries(List<Entry> entries) {
        public boolean isClone() {  
     * @return snapshot clone entry  
            Snapshot snapshot,
        public String repository() {  
     * @return true if all shards have completed (either successfully or failed), false otherwise  
        SUCCESS((byte) 2, true),  
/**
                state,
            } else {
        }  
    }
        }  
                indices,  
            this.value = value;
                false
            builder.field(SNAPSHOT, snapshot.getSnapshotId().getName());
        @Nullable
 * @opensearch.internal
         * Create a new instance by aborting this instance. Moving all in-progress shards to {@link ShardState#ABORTED} if assigned to a  
     *
                    return FAILED;
            );
        private final String failure;
            version,
                version,  
                case 4:
            if (partial != entry.partial) return false;
        }
            false,
    public Version getMinimalSupportedVersion() {  
                shards,  
            assert newRepoGen > repositoryStateId : "Updated repository generation ["
            );
         * {@link State#SUCCESS}, otherwise the state remains unchanged.
            dataStreams = in.readStringList();
        );
                    + state  
                indices,  
            final ShardState state = ShardState.fromValue(in.readByte());
        MISSING((byte) 5, true, true),  
         * Checks if this shard snapshot is actively executing.  
                userMetadata,
                    return INIT;  
                        "aborted by snapshot deletion",
    @Override
            }
        public boolean includeGlobalState() {
import java.io.IOException;  
                dataStreams,  
            }
            out.writeStringCollection(dataStreams);  
                        builder.field(INDEX, shardId.getIndex());
 * license agreements. See the NOTICE file distributed with
        State(byte value, boolean completed) {  
    public static final String ABORTED_FAILURE_TEXT = "Snapshot was aborted by deletion";
        public boolean remoteStoreIndexShallowCopy() {  
                for (IndexId index : indices) {
                partial,  
                return entry;  
        @Nullable
        }
                remoteStoreIndexShallowCopyV2
                clones,
            final Map<ShardId, ShardSnapshotStatus> shards,
         * A shard is defined as actively executing if it either is in a state that may write to the repository
            boolean includeGlobalState,
            return value;  
            builder.startArray(SHARDS);  
                case 7:
                && state == status.state;  
 * The OpenSearch Contributors require contributions made to  
import java.util.Collections;
            if (o == null || getClass() != o.getClass()) return false;
                userMetadata,
        public Entry withShardStates(final Map<ShardId, ShardSnapshotStatus> shards) {
        List<IndexId> indices,
                    return FAILED;
    public SnapshotsInProgress(StreamInput in) throws IOException {
                null,
        }
        return builder;
            out.writeOptionalString(generation);  
        for (final ShardSnapshotStatus value : clones.values()) {  
                out.writeBoolean(remoteStoreIndexShallowCopy);
        return new SnapshotsInProgress.Entry(
            out.writeList(indices);
         * Source snapshot if this is a clone operation or {@code null} if this is a snapshot.
            if (in.getVersion().onOrAfter(Version.V_2_18_0)) {  
                remoteStoreIndexShallowCopyV2
            // Check state consistency for normal snapshots and started clone operations  
 * this file be licensed under the Apache-2.0 license or a
                snapshot,
         * Map of {@link RepositoryShardId} to {@link ShardSnapshotStatus} tracking the state of each shard clone operation in this entry
        builder.endArray();
            boolean partial,  
            result = 31 * result + snapshot.hashCode();
                indices,
    }  
        public boolean remoteStoreIndexShallowCopyV2() {
                version,  
            Collections.emptyList(),
            assert assertConsistent();
                state,
                version,  
            final String reason = in.readOptionalString();
            if (allQueued) {
            return result;  
                remoteStoreIndexShallowCopyV2
    }
        final Map<ShardId, ShardSnapshotStatus> shards,  
        return entries.equals(((SnapshotsInProgress) o).entries);
        }  
        private final boolean includeGlobalState;  
                    snapshot,
    public int hashCode() {
                 // clone jobs  
                case 3:  
                version,
    private static final String SNAPSHOT = "snapshot";
    public static class ShardSnapshotStatus implements Writeable {
            assert (state != ShardState.INIT && state != ShardState.WAITING) || nodeId != null : "Null node id for state [" + state + "]";
                clones,
import java.util.Objects;
    ) {
                version,
                case 1:
                state,
                dataStreams,
            indices,
        builder.startArray(SNAPSHOTS);  
         * Map of {@link ShardId} to {@link ShardSnapshotStatus} tracking the state of each shard snapshot operation.  
     */  
         * @return aborted snapshot entry or {@code null} if entry can be removed from the cluster state directly
        }
        }
                includeGlobalState,
            snapshot,
    }
        long repositoryStateId,  
    private static final String SNAPSHOTS = "snapshots";  
        public boolean completed() {
            userMetadata,
        public String generation() {  
        public void writeTo(StreamOutput out) throws IOException {
     * State of the snapshots.
        for (String repoName : assignedShardsByRepo.keySet()) {  
        boolean partial,
    @PublicApi(since = "1.0.0")
            }
            builder.field(STATE, state);
    }  
                repositoryStateId,
            Snapshot snapshot,
        return TYPE;
            if (i + 1 < entries.size()) {
                startTime,
                failure,
            this.remoteStoreIndexShallowCopyV2 = remoteStoreIndexShallowCopyV2;
                entry.includeGlobalState,  
            }
        ) {
            boolean remoteStoreIndexShallowCopy,
         * Shard snapshot is waiting for another shard snapshot for the same shard and to the same repository to finish.  
            ShardSnapshotStatus status = (ShardSnapshotStatus) o;
        public static ShardState fromValue(byte value) {  
            builder.field(UUID, snapshot.getSnapshotId().getUUID());
            final Map<ShardId, ShardSnapshotStatus> shards,
            result = 31 * result + Long.hashCode(repositoryStateId);
                return false;
            }  
            return failed;  
    }  
 *  
                return null;  
        /**  
            List<String> dataStreams,  
                    throw new IllegalArgumentException("No snapshot state for value [" + value + "]");
         *  
            int result = state != null ? state.hashCode() : 0;
            boolean remoteStoreIndexShallowCopy,  
        public Entry(  
         * Shard snapshot status for shards that are waiting for another operation to finish before they can be assigned to a node.
            return partial;
                return this;
        }  
            );  
                : "Only running snapshots allowed but saw [" + updated + "]";
            return this.shards;  
                case 0:
    }
        public State state() {  
            source,
                snapshot,
    @Override  
    private static final String REPOSITORY = "repository";
            Version version,
                    return PARTIAL;
            out.writeByte(state.value);
            this.failed = failed;
     * @param source   snapshot to clone from
        private final SnapshotId source;
            final String generation = in.readOptionalString();  
                    failure,
            return completed;
                snapshot,
            Version version,
        private Entry(StreamInput in) throws IOException {
            } else {
                shards,  
                + " for state ["
     */
            this.nodeId = nodeId;
            return state;  
            null,  
        Version version,
    private static final String DATA_STREAMS = "data_streams";
                }
}  
                userMetadata,  
            this.partial = partial;  
            assert state.failed() == false || reason != null;
