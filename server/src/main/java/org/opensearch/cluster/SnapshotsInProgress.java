                snapshot,
                builder.append(",");
        }
                entry.startTime,
                indexNamesInShards.add(s.getKey().getIndexName());
                + " for state ["
            List<String> dataStreams,
 */
        @Nullable
            if (source == null || clones.isEmpty() == false) {
            return repositoryStateId;
                includeGlobalState,
        @Override
        }
         * If the given shard assignments show all shard snapshots in a completed state then the returned instance will be of state
        private final boolean failed;
    /**
            assert newRepoGen > repositoryStateId : "Updated repository generation ["
        }
            return new ShardSnapshotStatus(nodeId, state, reason, generation);
                    failure,
            if (out.getVersion().onOrAfter(Version.V_2_18_0)) {
        private final State state;
        }
                snapshot,
            for (final Map.Entry<ShardId, ShardSnapshotStatus> shardEntry : shards.entrySet()) {
            out.writeVersion(version);
    }
            Version version,
            result = 31 * result + snapshot.hashCode();
                    return WAITING;
            builder.endArray();
            result = 31 * result + (includeGlobalState ? 1 : 0);
            long repositoryStateId,
                state,
            remoteStoreIndexShallowCopyV2
                    ShardId shardId = shardEntry.getKey();
        public boolean equals(Object o) {
         * Checks if this shard snapshot is actively executing.
            long startTime,
            this.completed = completed;
                        builder.field(SHARD, shardId.getId());
                default:
        public Entry withRemoteStoreIndexShallowCopy(final boolean remoteStoreIndexShallowCopy) {
    @Override
                startTime,
        private boolean assertConsistent() {
                    assert assignedShardsByRepo.computeIfAbsent(entry.repository(), k -> new HashSet<>()).add(shard.getKey())
 * SPDX-License-Identifier: Apache-2.0
            builder.field(UUID, snapshot.getSnapshotId().getUUID());
import org.opensearch.snapshots.SnapshotId;
         */
            boolean remoteStoreIndexShallowCopyV2
                snapshot,
         * the same way {@link #shards} tracks the status of each shard snapshot operation in non-clone entries.
     * @param repositoryStateId repository state id that this clone is based on
            }
            );
            return userMetadata;
    private static final String DATA_STREAMS = "data_streams";
 */
        List<IndexId> indices,
        boolean partial,
                indices,
import java.util.HashMap;
                    {
            return fail(shardsBuilder, completed ? State.SUCCESS : State.ABORTED, ABORTED_FAILURE_TEXT);
                newRepoGen,
        public String reason() {
            Map.of(),
 * not use this file except in compliance with the License.
        return this.entries;
            List<String> dataStreams,
        }
    private SnapshotsInProgress(List<Entry> entries) {
                return this;
            return state;
    private static final String INCLUDE_GLOBAL_STATE = "include_global_state";
        }
            String failure
                assert hasFailures(clones) == false || state == State.FAILED : "Failed shard clones in ["
                version,
            this.state = state;
            this.startTime = startTime;
/*
            repositoryStateId,
            return source;
            boolean completed = true;
        List<String> dataStreams,
            false,
    @Override
            startTime,
        private static boolean assertShardsConsistent(
        public List<String> dataStreams() {
        private final Map<ShardId, ShardSnapshotStatus> shards;
            Collections.emptyMap(),
            completed(shards.values()) ? State.SUCCESS : State.STARTED,
            this.value = value;
                + newRepoGen
        private Entry(
        }
                version,
    private static final String NODE = "node";
            dataStreams,
        Snapshot snapshot,
            }
         */
/**
        long repositoryStateId,
    private static final String START_TIME = "start_time";
            return value;
                indices,
                }
        return new SnapshotsInProgress.Entry(
            );
        private final Snapshot snapshot;
    @PublicApi(since = "1.0.0")
                clones,
        }
                entry.remoteStoreIndexShallowCopy
            State.STARTED,
     */
                dataStreams,
            partial,
     */
        SUCCESS((byte) 2, true),
        State(byte value, boolean completed) {
            Collections.emptyList(),
                source,
        List<IndexId> indices,
        boolean remoteStoreIndexShallowCopyV2
                shards,
            return builder;
        public List<IndexId> indices() {
            this.nodeId = nodeId;
                dataStreams,
            final Snapshot curr = entry.snapshot();
            boolean remoteStoreIndexShallowCopy,
    ) {
            result = 31 * result + version.hashCode();
     */
        @Override
        }
        public Entry withStartedShards(final Map<ShardId, ShardSnapshotStatus> shards) {
            this.source = source;
            assert source != null || indexNames.equals(indexNamesInShards) : "Indices in shards "
            return true;
            Map.of(),
 */
import org.opensearch.repositories.RepositoryShardId;
        public Snapshot snapshot() {
                    final String nodeId = status.nodeId();
            remoteStoreIndexShallowCopyV2// initialising to false, will be updated in startCloning method of SnapshotsService
        @Nullable
    }
        // visible for testing, use #startedEntry and copy constructors in production code
            final ShardState state = ShardState.fromValue(in.readByte());
            return new Entry(
            if (remoteStoreIndexShallowCopy != entry.remoteStoreIndexShallowCopy) return false;
                failure,
        ) {
            return includeGlobalState;
            return remoteStoreIndexShallowCopyV2;
        public String generation() {
                + indexNames
    public enum State {
                    );
            if (clones.equals(((Entry) o).clones) == false) return false;
            }
                dataStreams,
                failure,
            this.version = version;
        private final String failure;
        return builder;
     * Creates the initial snapshot clone entry
                source,
        return builder.append("]").toString();
    }
public class SnapshotsInProgress extends AbstractNamedDiffable<Custom> implements Custom {
        public Map<RepositoryShardId, ShardSnapshotStatus> clones() {
        private final ShardState state;
    public String getWriteableName() {
                userMetadata,
    public static Entry startedEntry(
    }
            Map<String, Object> userMetadata,
            "missing index",
            boolean remoteStoreIndexShallowCopy
    }
                        builder.field(NODE, status.nodeId());
        public String toString() {
                failure,
        public Map<String, Object> userMetadata() {
            long repositoryStateId,
                failure,
            );
                    return QUEUED;
            this.completed = completed;
        }
        }
                && Objects.equals(reason, status.reason)
    private static final String STATE = "state";
            repositoryStateId = in.readLong();
            userMetadata = in.readMap();
    @Override
            return dataStreams;
        SnapshotId source,
        @Nullable
        public Map<ShardId, ShardSnapshotStatus> shards() {
         * Shard snapshot is waiting for another shard snapshot for the same shard and to the same repository to finish.
        ) {
            this(nodeId, ShardState.INIT, generation);
            }
                null,
                snapshot,
                remoteStoreIndexShallowCopy,
                startTime,
            null
            if (value.state().failed()) {
    private static final String INDEX = "index";
            snapshot,
         * Source snapshot if this is a clone operation or {@code null} if this is a snapshot.
            long startTime,
                remoteStoreIndexShallowCopyV2
            return snapshot.getRepository();
            return indices;
    public static class Entry implements Writeable, ToXContent, RepositoryOperation {
            State state,
            return version;
            out.writeOptionalString(nodeId);
                this.clones = Map.of();
 * this file be licensed under the Apache-2.0 license or a
        /**
        }
            );
            source = in.readOptionalWriteable(SnapshotId::new);
 *
            if (this == o) return true;
            this.userMetadata = userMetadata;
                || assertShardsConsistent(this.source, this.state, this.indices, this.shards, this.clones);
                remoteStoreIndexShallowCopyV2 = false;
                partial,
        @Override
            final Map<ShardId, ShardSnapshotStatus> shards,
            indices,
            this.partial = partial;
                false
                out.writeByte(State.SUCCESS.value());
        @Override
            out.writeMap(clones, (o, v) -> v.writeTo(o), (o, v) -> v.writeTo(o));
        Map<String, Object> userMetadata,
                    + "] but state was ["
            assert updated.state().completed() == false && completed(updated.shards().values()) == false
            if (allQueued) {
            if (updatedClones.equals(clones)) {
        /**
                    status = new ShardSnapshotStatus(
 * GitHub history for details.
            SnapshotId source,
            this.snapshot = snapshot;
                failure,
        }
                        : "Found duplicate shard assignments in " + entries;
    ) {
            }
                clones,
                dataStreams,
            State state,
        public Version version() {
        private final long repositoryStateId;
         * In the special case where this instance has not yet made any progress on any shard this method just returns
            if (remoteStoreIndexShallowCopyV2 != entry.remoteStoreIndexShallowCopyV2) return false;
        SnapshotId source,
         * it's moved to state {@link State#ABORTED}.
import org.opensearch.repositories.IndexId;
                repositoryStateId,
package org.opensearch.cluster;
            shards,
                    return INIT;
                assert (state.completed() && shardsCompleted) || (state.completed() == false && shardsCompleted == false)
            }
import org.opensearch.core.common.io.stream.StreamInput;
                + indexNamesInShards
            return withStartedShards(shards);
         * Shard snapshot status for shards that are waiting for another operation to finish before they can be assigned to a node.
                failure,
            shards,
                partial,
     */
            Version version,
                out.writeBoolean(remoteStoreIndexShallowCopy);
    /**
     */
        public String toString() {
        );
            return updated;
            completed(shards.values()) ? State.SUCCESS : State.STARTED,
                return true;
        long startTime,
                userMetadata,
     *
        long startTime,
import org.opensearch.repositories.RepositoryOperation;
            long startTime,
        /**
            version,
        this.entries = entries;
            boolean allQueued = true;
            List<IndexId> indices,
                case 1:
                case 3:
        ) {
            out.writeLong(startTime);
        );
     * Status of shard snapshots.
import org.opensearch.common.annotation.PublicApi;
        public Entry withRepoGen(long newRepoGen) {
        private final String generation;
            includeGlobalState = in.readBoolean();
            );
        );
        this.entries = in.readList(SnapshotsInProgress.Entry::new);
                startTime,
            if ((state == State.INIT || state == State.ABORTED) && shards.isEmpty()) {
                return false;
    public static final SnapshotsInProgress EMPTY = new SnapshotsInProgress(Collections.emptyList());
                remoteStoreIndexShallowCopy,
        }
        public static ShardSnapshotStatus readFrom(StreamInput in) throws IOException {
                entry.includeGlobalState,
                remoteStoreIndexShallowCopy,
        return new SnapshotsInProgress(Collections.unmodifiableList(entries));
     *
            return result;
    private static final String SNAPSHOT = "snapshot";
     * Checks if all shards in the list have completed
            this(
     *
                repositoryStateId,
                partial,
        long repositoryStateId,
                dataStreams,
        }
        }
        }
                    repositoryStateId,
            source,
            }
            out.writeMap(userMetadata);
            return Objects.equals(nodeId, status.nodeId)
            // Check state consistency for normal snapshots and started clone operations
        public Entry(
            String failure,
                case 0:
                includeGlobalState,
            Map.of(),
            final Set<String> indexNamesInShards = new HashSet<>();
            switch (value) {
/*
        public int hashCode() {
                : "Only running snapshots allowed but saw [" + updated + "]";
        public boolean remoteStoreIndexShallowCopyV2() {
            // while updating entry with clone jobs
        STARTED((byte) 1, false),
        private final byte value;
    public static SnapshotsInProgress of(List<Entry> entries) {
    private static final String SHARD = "shard";
 * Unless required by applicable law or agreed to in writing,
                shards,
                includeGlobalState,
        private final Map<RepositoryShardId, ShardSnapshotStatus> clones;
                    throw new IllegalArgumentException("No shard snapshot state for value [" + value + "]");
            if (in.getVersion().onOrAfter(Version.V_2_9_0)) {
     *
            shards = in.readMap(ShardId::new, ShardSnapshotStatus::readFrom);
    ) {
import org.opensearch.snapshots.Snapshot;
                case 5:
         */
            indices,
import java.util.stream.Collectors;
        }
            }
                version,
            final boolean shardsCompleted = completed(shards.values()) && completed(clones.values());
        StringBuilder builder = new StringBuilder("SnapshotsInProgress[");
            return state == ShardState.INIT || state == ShardState.ABORTED || state == ShardState.WAITING;
            }
        }
        }
    /**
                    index.toXContent(builder, params);
                if (shard.getValue().isActive()) {
            repositoryStateId,
            final Map<ShardId, ShardSnapshotStatus> shards,
        /**
            out.writeList(indices);
 * this work for additional information regarding copyright
            }
            builder.array(DATA_STREAMS, dataStreams.toArray(new String[0]));
            Collections.emptyList(),
                    indices,
 * KIND, either express or implied.  See the License for the
            );
        List<IndexId> indices,
        }
            boolean includeGlobalState,
        public void writeTo(StreamOutput out) throws IOException {
            return partial;
        public Entry(
        private final boolean partial;
            this.failure = failure;
            clones = in.readMap(RepositoryShardId::new, ShardSnapshotStatus::readFrom);
                null,
                state,
            shards.entrySet().forEach(s -> {
        for (Entry entry : entries) {
        QUEUED((byte) 7, false, false);
        private final byte value;
    public Entry snapshot(final Snapshot snapshot) {
            return this.shards;
/*
                startTime,
    private static boolean assertConsistentEntries(List<Entry> entries) {
        Version version,
            if (i + 1 < entries.size()) {
            final String reason = in.readOptionalString();
            Map.of(),
            Snapshot snapshot,
            }
            remoteStoreIndexShallowCopyV2,
            snapshot = new Snapshot(in);
        /**
        private final boolean includeGlobalState;
         */
                indices,
                version,
                entry.partial,
                case 2:
 * @opensearch.internal
        INIT((byte) 0, false),
     * State of the snapshots.
     * @opensearch.api
    }
     * will be in state {@link State#SUCCESS} right away otherwise it will be in state {@link State#STARTED}.
    /**
            false// initialising to false, will be updated in startCloning method of SnapshotsService while updating entry with
            assert (state != ShardState.INIT && state != ShardState.WAITING) || nodeId != null : "Null node id for state [" + state + "]";
    public List<Entry> entries() {
            false,
            if (repositoryStateId != entry.repositoryStateId) return false;
        @Nullable
            boolean remoteStoreIndexShallowCopyV2
            List<IndexId> indices,
import org.opensearch.core.common.Strings;
        return null;
                && Objects.equals(generation, status.generation)
                    return FAILED;
        }
    }
            result = 31 * result + (partial ? 1 : 0);
            this.remoteStoreIndexShallowCopyV2 = remoteStoreIndexShallowCopyV2;
            State state,
                repositoryStateId,
            ShardState.QUEUED,
        public void writeTo(StreamOutput out) throws IOException {
            return nodeId;
        );
            final SnapshotsInProgress.Entry updated = new Entry(
                case 0:
                snapshot,
            remoteStoreIndexShallowCopy
        ABORTED((byte) 4, false),
            result = 31 * result + (reason != null ? reason.hashCode() : 0);
            if (startTime != entry.startTime) return false;
                startTime,
        long startTime,
        public boolean equals(Object o) {
        return false;
                dataStreams,
            if (!shards.equals(entry.shards)) return false;
            indices,
        private final SnapshotId source;
                repositoryStateId,
 * Meta data about snapshots that are currently executing
            final Map<String, Object> userMetadata,
                    builder.endObject();
import java.util.Collection;
     * @param shards list of shard statuses
            }
            {
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
            this.failed = failed;
                        builder.field(INDEX, shardId.getIndex());
         */
            snapshot,
 * the Apache License, Version 2.0 (the "License"); you may
            long repositoryStateId,
            builder.startArray(SHARDS);
    private static final String START_TIME_MILLIS = "start_time_millis";
        long repositoryStateId,
        }
                out.writeBoolean(remoteStoreIndexShallowCopyV2);
                indices,
        ABORTED((byte) 4, false, true),
            if (o == null || getClass() != o.getClass()) return false;
         */
    public static class ShardSnapshotStatus implements Writeable {
                partial,
            includeGlobalState,
            out.writeOptionalString(reason);
        public ShardSnapshotStatus(@Nullable String nodeId, ShardState state, String reason, @Nullable String generation) {
            boolean partial,
                    snapshot,
        WAITING((byte) 6, false, false),
        }
            );
                partial,
        if (o == null || getClass() != o.getClass()) return false;
        /**
     */
    @Override
        builder.startArray(SNAPSHOTS);
                        "aborted by snapshot deletion",
                repositoryStateId,
            failure = in.readOptionalString();
                + "] must be higher than current generation ["
         */
        long repositoryStateId,
            this(
        long startTime,
        }
            includeGlobalState,
                    : "Completed state must imply all shards completed but saw state [" + state + "] and shards " + shards;
    public int hashCode() {
                    : "Shard snapshot must not be assigned to data node when copying from snapshot [" + source + "]";
            startTime,
            @Nullable SnapshotId source,
import org.opensearch.core.xcontent.MediaTypeRegistry;
            List<IndexId> indices,
                 // clone jobs
        private final boolean remoteStoreIndexShallowCopyV2;
        @Nullable
                completed &= status.state().completed();
        @Override
            });
 *
        @Nullable
}
        }
                remoteStoreIndexShallowCopyV2
        // see #useShardGenerations
            boolean partial,
    }
         * Create a new instance by aborting this instance. Moving all in-progress shards to {@link ShardState#ABORTED} if assigned to a
    @Override
    /**
            if (out.getVersion().onOrAfter(Version.V_2_9_0)) {
            null
                    version,
        }
        Map<String, Object> userMetadata,
            boolean partial,
                state,
         * @param shards new shard snapshot states
            if (source == null) {
        private final Version version;
                partial,
                + state
        for (String repoName : assignedShardsByRepo.keySet()) {
    }
    public static Entry startClone(
            State state,
        }
            final Map<ShardId, ShardSnapshotStatus> shards,
            result = 31 * result + indices.hashCode();
                    return ABORTED;
     * @param version repository metadata version to write
        public static final ShardSnapshotStatus MISSING = new SnapshotsInProgress.ShardSnapshotStatus(
            this.dataStreams = dataStreams;
        public boolean completed() {
                // Setting to SUCCESS for partial snapshots in older versions to maintain backward compatibility
            } else {
        Version version,
 * specific language governing permissions and limitations
            State.STARTED,
        }
         * Same as {@link #withShardStates} but does not check if the snapshot completed and thus is only to be used when starting new
        FAILED((byte) 3, true, true),
        }
            return new Entry(
            return "ShardSnapshotStatus[state=" + state + ", nodeId=" + nodeId + ", reason=" + reason + ", generation=" + generation + "]";
        public SnapshotId source() {
            if (state != entry.state) return false;
                return new Entry(
                + "]";
            repositoryStateId,
        @Override
import org.opensearch.cluster.ClusterState.Custom;
        SUCCESS((byte) 2, true, false),
         */
            this.value = value;
 * You may obtain a copy of the License at
                entry.userMetadata,
                case 4:
            if ((out.getVersion().before(Version.V_2_14_0)) && state == State.PARTIAL) {
        }
         *
            repositoryStateId,
     * The shard state.
     * @opensearch.internal
    /**
            Entry entry = (Entry) o;
            Map<String, Object> userMetadata,
        boolean remoteStoreIndexShallowCopyV2
         * shard snapshots on data nodes for a running snapshot.
            final Map<RepositoryShardId, ShardSnapshotStatus> clones
            out.writeMap(shards, (o, v) -> v.writeTo(o), (o, v) -> v.writeTo(o));
                + " differ from expected indices "
                    return STARTED;
import java.util.Objects;
        FAILED((byte) 3, true),
        Version version
                state,
        List<IndexId> indices,
        ShardState(byte value, boolean completed, boolean failed) {
            this.generation = generation;
        /**
        }
            null,
        MISSING((byte) 5, true, true),
            if (!indices.equals(entry.indices)) return false;
        for (int i = 0; i < entries.size(); i++) {
                return UNASSIGNED_QUEUED;
            if (source != null && state.completed()) {
    /**
            dataStreams,
            }
        List<String> dataStreams,
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            state = State.fromValue(in.readByte());
        }
                    remoteStoreIndexShallowCopy
            if (curr.equals(snapshot)) {
import org.opensearch.common.Nullable;
                entry.dataStreams,
            false,
                state,
            List<IndexId> indices,
            Collections.emptyMap(),
        Version version,
                    includeGlobalState,
                case 4:
import java.util.Collections;
            return completed;
            startTime = in.readLong();
 * license agreements. See the NOTICE file distributed with
                        builder.field(STATE, status.state());
    }
                assert source == null || s.getValue().nodeId == null
            this.remoteStoreIndexShallowCopy = remoteStoreIndexShallowCopy;
        }
 * The OpenSearch Contributors require contributions made to
    public static Entry startClone(
            if (o == null || getClass() != o.getClass()) return false;
        private final boolean completed;
            source,
        ) {
            result = 31 * result + (source == null ? 0 : source.hashCode());
            builder.field(REPOSITORY, snapshot.getRepository());
        public ShardState state() {
        ) {
            for (final Map.Entry<ShardId, ShardSnapshotStatus> shard : entry.shards().entrySet()) {
        }
            userMetadata,
            return this.generation;
            return true;
            String nodeId = in.readOptionalString();
                clones,
            Version version,
            indices = in.readList(IndexId::new);
        public long startTime() {
        }
                    return FAILED;
        }
            assert source == null || indexNames.isEmpty() == false : "No empty snapshot clones allowed";
    private static final String SNAPSHOTS = "snapshots";
        public Entry(
import org.opensearch.core.xcontent.ToXContent;
            assert this.remoteStoreIndexShallowCopyV2
                partial,
            out.writeOptionalString(generation);
        public State state() {
        public byte value() {
        );
            List<IndexId> indices,
        @Override
        }
        INIT((byte) 0, false, false),
                remoteStoreIndexShallowCopy = in.readBoolean();
            if (includeGlobalState != entry.includeGlobalState) return false;
        builder.endArray();
                dataStreams,
            Version version,
            result = 31 * result + shards.hashCode();
    public static final String ABORTED_FAILURE_TEXT = "Snapshot was aborted by deletion";
        @Override
                shards,
            null,
                indices,
    }
            return false;
            final Map<ShardId, ShardSnapshotStatus> shards,
            return failed;
                    + "]";
            builder.append(entries.get(i).snapshot().getSnapshotId().getName());
import org.opensearch.core.common.io.stream.StreamOutput;
            List<IndexId> indices,
        return true;
            State state,
        out.writeList(entries);
            final Map<ShardId, ShardSnapshotStatus> shards,
            Version version,
            result = 31 * result + (remoteStoreIndexShallowCopyV2 ? 1 : 0);
        }
                indices,
 * compatible open source license.
        private final long startTime;
            result = 31 * result + Long.hashCode(repositoryStateId);
         *
    }
            version,
            ShardSnapshotStatus status = (ShardSnapshotStatus) o;
    private static boolean hasFailures(final Map<RepositoryShardId, ShardSnapshotStatus> clones) {
                state,
                startTime,
        public String nodeId() {
                    builder.startObject();
        private final String reason;
         * Shard snapshot status for shards that could not be snapshotted because their index was deleted from before the shard snapshot
            if (state == ShardState.QUEUED) {
            {
            builder.field(REPOSITORY_STATE_ID, repositoryStateId);
            builder.endArray();
            null,
        }
        @Nullable
            null,
 *
                case 7:
         * Shard snapshot is waiting for the primary to snapshot to become available.
                + "]";
            // If the state is failed we have to have a reason for this failure
        }
        public static State fromValue(byte value) {
            true,
                shardsBuilder.put(shardEntry.getKey(), status);
 * software distributed under the License is distributed on an
                out.writeByte(state.value());
        }
        }
            List<String> dataStreams,
    }
        public boolean includeGlobalState() {
import org.opensearch.snapshots.InFlightShardSnapshotStates;
                }
     *
                    throw new IllegalArgumentException("No snapshot state for value [" + value + "]");
            return result;
            return Strings.toString(MediaTypeRegistry.JSON, this);
        final Map<ShardId, ShardSnapshotStatus> shards,
                state,
                failure,
    public boolean equals(Object o) {
            builder.field(INCLUDE_GLOBAL_STATE, includeGlobalState());
            null,
            return state;
     * Entry in the collection.
                shards,
                assert clones == null || clones.isEmpty() : "Provided [" + clones + "] but no source";
        if (entries.isEmpty()) {
                shards,
                startTime,
         * @return aborted snapshot entry or {@code null} if entry can be removed from the cluster state directly
    }
            if (in.getVersion().onOrAfter(Version.V_2_18_0)) {
         * Map of {@link ShardId} to {@link ShardSnapshotStatus} tracking the state of each shard snapshot operation.
            if (!snapshot.equals(entry.snapshot)) return false;
                snapshot,
            assert state.failed() == false || reason != null;
            builder.field(PARTIAL, partial);
                Map.of(),
            return source != null;
        private final String nodeId;
            }
            boolean remoteStoreIndexShallowCopy
                        nodeId == null ? ShardState.FAILED : ShardState.ABORTED,
                    + state
 * Modifications Copyright OpenSearch Contributors. See
            this(
            this.shards = Collections.unmodifiableMap(shards);
            boolean includeGlobalState,
        final Map<ShardId, ShardSnapshotStatus> shards,
                updatedClones,
     * @param snapshot snapshot to clone into
            }
import java.util.List;
    }
            result = 31 * result + (nodeId != null ? nodeId.hashCode() : 0);
                version,
            }
 */
        Snapshot snapshot,
        }
            boolean includeGlobalState,
                remoteStoreIndexShallowCopy,
                state,
import org.opensearch.Version;
                userMetadata,
                    + clones
            Snapshot snapshot,
    private static final String SHARDS = "shards";
                return entry;
            @Nullable final Map<RepositoryShardId, ShardSnapshotStatus> clones,
                repositoryStateId,
     * @return true if all shards have completed (either successfully or failed), false otherwise
            out.writeOptionalWriteable(source);
import org.opensearch.core.index.shard.ShardId;
         * If the instance had no in-progress shard snapshots assigned to data nodes it's moved to state {@link State#SUCCESS}, otherwise
                    userMetadata,
                    shards,
        );
        boolean partial,
            }
    public String toString() {
                version,
        }
            out.writeByte(state.value);
            return remoteStoreIndexShallowCopy;
        private Entry(StreamInput in) throws IOException {
    public static Entry startedEntry(
            String failure,
            result = 31 * result + (remoteStoreIndexShallowCopy ? 1 : 0);
    private static final String REPOSITORY = "repository";
            userMetadata,
            version = in.readVersion();
                }
                userMetadata,
        public boolean isFragment() {
        }
    @Override
            version,
            startTime,
            final String generation = in.readOptionalString();
                return null;
                    ShardSnapshotStatus status = shardEntry.getValue();
            Snapshot snapshot,
                includeGlobalState,
        return Version.CURRENT.minimumCompatibilityVersion();
            }
        /**
            }
            out.writeOptionalString(failure);
                shards,
                includeGlobalState,
            true,
        boolean remoteStoreIndexShallowCopy
                    startTime,
            InFlightShardSnapshotStates.forRepo(repoName, entries);
    @Override
                indices,
        }
                version,
import org.opensearch.common.unit.TimeValue;
            boolean includeGlobalState,
                    return MISSING;
            if (completed(shards.values())) {
            startTime,
    public enum ShardState {
        final Map<String, Set<ShardId>> assignedShardsByRepo = new HashMap<>();
        }
         * started.
                return true;
        if (this == o) return true;
        }
                snapshot,
         */
                && state == status.state;
            this(nodeId, state, null, generation);
                Map.of(),
        @Nullable
            remoteStoreIndexShallowCopy,
            return this.snapshot;
            return new Entry(
    public static boolean completed(final Collection<ShardSnapshotStatus> shards) {
    }
            final Map<ShardId, ShardSnapshotStatus> shards,
        private final boolean remoteStoreIndexShallowCopy;
                entry.snapshot,
                remoteStoreIndexShallowCopyV2 = in.readBoolean();
                startTime,
        }
        public ShardSnapshotStatus(String nodeId, String generation) {
        }
            );
                for (IndexId index : indices) {
        public long repositoryStateId() {
        }
        ) {
    private final List<Entry> entries;
    }
            out.writeStringCollection(dataStreams);
        }
     * @opensearch.internal
         * {@code null} since no abort is needed and the snapshot can simply be removed from the cluster state outright.
        return readDiffFrom(Custom.class, TYPE, in);
        return TYPE;
    public static NamedDiff<Custom> readDiffFrom(StreamInput in) throws IOException {
            version,
                repositoryStateId,
 *
        return new SnapshotsInProgress.Entry(
            Map<String, Object> userMetadata,
        for (Entry entry : entries) {
        @Override
                remoteStoreIndexShallowCopy,
        public String failure() {
                remoteStoreIndexShallowCopy = false;
        assert assertConsistentEntries(entries);
            out.writeLong(repositoryStateId);
                remoteStoreIndexShallowCopy
        PARTIAL((byte) 5, false);
import java.util.HashSet;
                version,
            return completed;
            out.writeBoolean(partial);
            return reason;
            entry.toXContent(builder, params);
                includeGlobalState,
            builder.startObject();
            return true;
            this.repositoryStateId = repositoryStateId;
            long repositoryStateId,
                    return SUCCESS;
            switch (value) {
            result = 31 * result + Long.hashCode(startTime);
        @Override
            snapshot,
         * @return new snapshot entry
                );
        for (Entry entry : entries) {
import java.util.Set;
        for (final ShardSnapshotStatus status : shards) {
            }
        public Entry abort() {
                    return SUCCESS;
        public boolean remoteStoreIndexShallowCopy() {
            this.reason = reason;
                indices,
        public Entry withClones(final Map<RepositoryShardId, ShardSnapshotStatus> updatedClones) {
    }
            return clones;
    private static final String REPOSITORY_STATE_ID = "repository_state_id";
        public Entry(
     *
            indices,
            return new Entry(
            partial = in.readBoolean();
        Snapshot snapshot,
        }
        }
        private final boolean completed;
            this.state = state;
            builder.endObject();
            }
                remoteStoreIndexShallowCopyV2
         * {@link State#SUCCESS}, otherwise the state remains unchanged.
        public boolean partial() {
         */
        @Override
import java.util.Map;
    public static final String TYPE = "snapshots";
        public boolean isActive() {
        Snapshot snapshot,
         */
        public static ShardState fromValue(byte value) {
            );
            State state,
            this(
            Snapshot snapshot,
        }
    private static final String PARTIAL = "partial";
    public SnapshotsInProgress(StreamInput in) throws IOException {
            builder.field(STATE, state);
        boolean remoteStoreIndexShallowCopy,
            } else {
            return failure;
    }
        return entries.equals(((SnapshotsInProgress) o).entries);
        return true;
                this.clones = Collections.unmodifiableMap(clones);
                case 6:
            return startTime;
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
            builder.startArray(INDICES);
            int result = state.hashCode();
                remoteStoreIndexShallowCopyV2
            String failure,
        }
                for (final Map.Entry<ShardId, ShardSnapshotStatus> shardEntry : shards.entrySet()) {
        for (final ShardSnapshotStatus value : clones.values()) {
            Entry entry,
            dataStreams = in.readStringList();
                completed(updatedClones.values()) ? (hasFailures(updatedClones) ? State.FAILED : State.SUCCESS) : state,
        boolean includeGlobalState,
                source,
         * Create a new instance that has its shard assignments replaced by the given shard assignment map.
            result = 31 * result + clones.hashCode();
                + repositoryStateId
                includeGlobalState,
                    dataStreams,
            if (version.equals(entry.version) == false) return false;
                        nodeId,
        /**
import java.io.IOException;
    public Version getMinimalSupportedVersion() {
            return EMPTY;
        }
    public void writeTo(StreamOutput out) throws IOException {
        public boolean completed() {
                    partial,
    ) {
                    return PARTIAL;
                case 2:
     * @param indices  indices to clone
        private final List<IndexId> indices;
        public Entry fail(final Map<ShardId, ShardSnapshotStatus> shards, State state, String failure) {
                }
        public int hashCode() {
            int result = state != null ? state.hashCode() : 0;
            } else {
        }
                    }
        @Nullable
            List<String> dataStreams,
            out.writeBoolean(includeGlobalState);
            ShardState.MISSING,
            }
            final Map<ShardId, ShardSnapshotStatus> shardsBuilder = new HashMap<>();
            long startTime,
        }
import org.opensearch.core.common.io.stream.Writeable;
         * ({@link ShardState#INIT} or {@link ShardState#ABORTED}) or about to write to it in state {@link ShardState#WAITING}.
                shards,
                userMetadata,
         * data node or to {@link ShardState#FAILED} if not assigned to any data node.
            this.indices = indices;
            }
        public ShardSnapshotStatus(@Nullable String nodeId, ShardState state, @Nullable String generation) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        public String repository() {
 * under the License.
                includeGlobalState,
                    State.SUCCESS,
        /**
    }
                default:
                source,
                snapshot,
    }
    private static final String UUID = "uuid";
            snapshot.writeTo(out);
                    return INIT;
                userMetadata,
            } else {
        public boolean failed() {
                case 3:
                dataStreams,
 * ownership. Elasticsearch licenses this file to you under
        }
        public Entry withShardStates(final Map<ShardId, ShardSnapshotStatus> shards) {
            partial,
            if (this == o) return true;
            boolean remoteStoreIndexShallowCopy,
        return new SnapshotsInProgress.Entry(
    }
        public static final ShardSnapshotStatus UNASSIGNED_QUEUED = new SnapshotsInProgress.ShardSnapshotStatus(
                shards,
                partial,
     * @param startTime start time
         * What version of metadata to use for the snapshot in the repository
            builder.humanReadableField(START_TIME_MILLIS, START_TIME, new TimeValue(startTime));
            result = 31 * result + (generation != null ? generation.hashCode() : 0);
            assert assertConsistent();
                failure,
            snapshot,
                version,
        }
    private static final String INDICES = "indices";
        private final List<String> dataStreams;
            null,
        @Nullable
 * Licensed to Elasticsearch under one or more contributor
            this.includeGlobalState = includeGlobalState;
                        status.generation()
                case 5:
            // make sure in-flight-shard-states can be built cleanly for the entries without tripping assertions
         */
                    return ABORTED;
        boolean includeGlobalState,
        return new SnapshotsInProgress.Entry(
                repositoryStateId,
            boolean partial,
                null,
     * @param source   snapshot to clone from
                shards,
            final Set<String> indexNames = indices.stream().map(IndexId::getName).collect(Collectors.toSet());
                userMetadata,
         * Map of {@link RepositoryShardId} to {@link ShardSnapshotStatus} tracking the state of each shard clone operation in this entry
            builder.field(SNAPSHOT, snapshot.getSnapshotId().getName());
            if (Objects.equals(source, ((Entry) o).source) == false) return false;
     * @opensearch.internal
            long repositoryStateId,
                allQueued &= status.state() == ShardState.QUEUED;
                remoteStoreIndexShallowCopy,
        }
        public boolean isClone() {
            if (status.state().completed == false) {
        @Override
                ShardSnapshotStatus status = shardEntry.getValue();
                userMetadata,
     * Creates the initial {@link Entry} when starting a snapshot, if no shard-level snapshot work is to be done the resulting entry
        }
     * @return snapshot clone entry
    }
            if (partial != entry.partial) return false;
     */
                if (status.state().completed() == false) {
        }
         * A shard is defined as actively executing if it either is in a state that may write to the repository
    }
        /**
        private final Map<String, Object> userMetadata;
        return entries.hashCode();
                remoteStoreIndexShallowCopyV2
                indices,
        /**
        }
                remoteStoreIndexShallowCopy
        }
import org.opensearch.core.xcontent.XContentBuilder;
