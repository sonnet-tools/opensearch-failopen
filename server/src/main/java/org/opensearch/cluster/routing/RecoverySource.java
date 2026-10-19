    public static RecoverySource readFrom(StreamInput in) throws IOException {
        }
        public String sourceRemoteStoreRepository() {
            return "remote store recovery [" + restoreUUID + "]";
        }
         *
            IndexId indexId,
        }
            if (in.getVersion().onOrAfter(Version.V_2_7_0)) {
        IN_PLACE_SPLIT_SHARD
        @Override
            index = new IndexId(in);
        }
        }
        private final boolean isSearchableSnapshot;
        public static final String FORCED_ALLOCATION_ID = "_forced_allocation_";
            builder.field("repository", snapshot.getRepository())
        private PeerRecoverySource() {}
                return true;
                pinnedTimestamp = 0L;
 * the Apache License, Version 2.0 (the "License"); you may
     * @opensearch.api
        public int hashCode() {
            return restoreUUID;
            return Type.EMPTY_STORE;
        return getType().hashCode();
 * You may obtain a copy of the License at
        }
 *
                throw new IllegalArgumentException("unknown recovery type: " + type.name());
            return restoreUUID;
        }
            case PEER:
/*
     */
            this.snapshot = Objects.requireNonNull(snapshot);
            this.version = Objects.requireNonNull(version);
    public static final class EmptyStoreRecoverySource extends RecoverySource {
            restoreUUID = in.readString();
                && sourceRemoteStoreRepository != null
        /**
            case EMPTY_STORE:
 *
        addAdditionalFields(builder, params);
     * @opensearch.api
        public String restoreUUID() {
                0L
        @Override
            this.version = Objects.requireNonNull(version);
                return false;
        private final String sourceRemoteTranslogRepository;
            case REMOTE_STORE:
        @Override
        @Override
     */
        }
            );
            } else {
            long pinnedTimestamp
     */
            index.writeTo(out);
import org.opensearch.core.common.io.stream.StreamOutput;
     *
     */
        // https://github.com/opensearch-project/OpenSearch/issues/8795
                && version.equals(that.version)
            if (this == o) {
            return "local shards recovery";
     * Recovery from an existing on-disk store
        protected void writeAdditionalFields(StreamOutput out) throws IOException {
            this.isSearchableSnapshot = isSearchableSnapshot;
        public String toString() {
    @PublicApi(since = "1.0.0")
                sourceRemoteStoreRepository,
    }
            return sourceRemoteTranslogRepository;
        }
                return true;
import org.opensearch.core.xcontent.ToXContent;
        }
        private final IndexId index;
        public void addAdditionalFields(XContentBuilder builder, Params params) throws IOException {
        }
        }
        REMOTE_STORE,
            return snapshot;
        }
    public boolean expectEmptyRetentionLeases() {
        public String toString() {
     * Type of recovery.
        @Override
        }
            return Objects.hash(restoreUUID, index, version);
 * SPDX-License-Identifier: Apache-2.0
         * was created by an older version cluster-manager in a mixed version cluster.
        }
 */
        public IndexId index() {
        public Type getType() {
         * Gets the {@link IndexId} of the recovery source. May contain {@link IndexMetadata#INDEX_UUID_NA_VALUE} as the index uuid if it
     * Recovery from a fresh copy
        EXISTING_STORE,
 * under the License.
            version = in.readVersion();
                restoreUUID,
     *
                remoteStoreIndexShallowCopy = false;
            }
     *
            return index;
        }
        }
    public static final class ExistingStoreRecoverySource extends RecoverySource {
        @Override
        EMPTY_STORE,
    }
        public Version version() {
    }
                out.writeOptionalString(sourceRemoteStoreRepository);
     *
        }
        public String toString() {
        }
    }
    /**
     * to be overridden by subclasses
        public SnapshotRecoverySource(String restoreUUID, Snapshot snapshot, Version version, IndexId indexId) {
        return true;
         * Special allocation id that shard has during initialization on allocate_stale_primary
            SnapshotRecoverySource that = (SnapshotRecoverySource) o;
            this.restoreUUID = restoreUUID;
                ? sourceRemoteStoreRepository.equals(that.sourceRemoteStoreRepository)
        switch (type) {
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under
                return ExistingStoreRecoverySource.read(in);
        }
            if (this == o) {
        @Override
        RecoverySource that = (RecoverySource) o;
            if (out.getVersion().onOrAfter(Version.V_2_7_0)) {
        }
        private InPlaceSplitShardRecoverySource() {}
@PublicApi(since = "1.0.0")
            return "new shard recovery";
 */
    /**
    public static class RemoteStoreRecoverySource extends RecoverySource {
            case IN_PLACE_SPLIT_SHARD:
        }
     */
            @Nullable String sourceRemoteTranslogRepository,
            out.writeBoolean(bootstrapNewHistoryUUID);
                return InPlaceSplitShardRecoverySource.INSTANCE;
                .field("restoreUUID", restoreUUID)
            boolean isSearchableSnapshot,
        public Type getType() {
        }
        }
        public static final PeerRecoverySource INSTANCE = new PeerRecoverySource();
            );
     * @opensearch.internal
        }
        public Type getType() {
        }
    }
        // TODO: This override should be removed/be updated to return "true",
     * @opensearch.internal
        @Override
public abstract class RecoverySource implements Writeable, ToXContentObject {
        writeAdditionalFields(out);
                out.writeLong(pinnedTimestamp);
            return Type.LOCAL_SHARDS;
        public Type getType() {
    @PublicApi(since = "1.0.0")
        builder.field("type", getType());
                sourceRemoteStoreRepository = in.readOptionalString();
        @Override
            this(restoreUUID, snapshot, version, indexId, false, false, null);
     * to be overridden by subclasses
        public Type getType() {
            return false;
 * specific language governing permissions and limitations
            return sourceRemoteStoreRepository;
    /**
import java.util.Objects;
 * Modifications Copyright OpenSearch Contributors. See
        public SnapshotRecoverySource(
            return "in-place shard split";
    public int hashCode() {
        }
        public long pinnedTimestamp() {
    public final void writeTo(StreamOutput out) throws IOException {
        public void addAdditionalFields(XContentBuilder builder, ToXContent.Params params) throws IOException {
        }
                .field("isSearchableSnapshot", isSearchableSnapshot)
    }
        private ExistingStoreRecoverySource(boolean bootstrapNewHistoryUUID) {
            version = in.readVersion();
     * recovery from other shards on same node (shrink index action)
import org.opensearch.Version;
    /**
            if (in.getVersion().onOrAfter(Version.V_2_17_0)) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
     *
        Type type = Type.values()[in.readByte()];
            } else {
        protected void writeAdditionalFields(StreamOutput out) throws IOException {
    }
            return isSearchableSnapshot;
package org.opensearch.cluster.routing;
                return LocalShardsRecoverySource.INSTANCE;
    protected void writeAdditionalFields(StreamOutput out) throws IOException {
            }
     * recovery from a snapshot
        }
         * was created by an older version cluster-manager in a mixed version cluster.
    public boolean equals(Object o) {
        @Override
                return EmptyStoreRecoverySource.INSTANCE;
                .field("sourceRemoteStoreRepository", sourceRemoteStoreRepository)
        }
        if (this == o) return true;
        public int hashCode() {
            Version version,
    public static class LocalShardsRecoverySource extends RecoverySource {
                .field("sourceRemoteTranslogRepository", sourceRemoteTranslogRepository);
        private final IndexId index;
            String restoreUUID,
        public Snapshot snapshot() {
        out.writeByte((byte) getType().ordinal());
    public static class SnapshotRecoverySource extends RecoverySource {
                sourceRemoteStoreRepository,
        }
            this(
        }
import org.opensearch.cluster.metadata.IndexMetadata;
            return "snapshot recovery [" + restoreUUID + "] from " + snapshot;
        public IndexId index() {
        public static final EmptyStoreRecoverySource INSTANCE = new EmptyStoreRecoverySource();
 * this file be licensed under the Apache-2.0 license or a
            String restoreUUID,
        @Override
        @Override
 * not use this file except in compliance with the License.
                && isSearchableSnapshot == that.isSearchableSnapshot
            if (in.getVersion().onOrAfter(Version.V_2_9_0)) {
    }
     *
                : that.sourceRemoteTranslogRepository == null && pinnedTimestamp == that.pinnedTimestamp;
    /**
        public RemoteStoreRecoverySource(String restoreUUID, Version version, IndexId indexId) {
                sourceRemoteStoreRepository = null;
                    ? sourceRemoteTranslogRepository.equals(that.sourceRemoteTranslogRepository)
            if (o == null || getClass() != o.getClass()) {
     */
    }
            return "existing store recovery; bootstrap_history_uuid=" + bootstrapNewHistoryUUID;
                pinnedTimestamp
            this.remoteStoreIndexShallowCopy = remoteStoreIndexShallowCopy;
            IndexId indexId,
        public void addAdditionalFields(XContentBuilder builder, ToXContent.Params params) throws IOException {
            return index;
        public String restoreUUID() {
                isSearchableSnapshot,
 */
                && remoteStoreIndexShallowCopy == that.remoteStoreIndexShallowCopy
 * this work for additional information regarding copyright
            return restoreUUID.equals(that.restoreUUID) && index.equals(that.index) && version.equals(that.version);
            return Type.EXISTING_STORE;
            return restoreUUID.equals(that.restoreUUID)
            return Type.REMOTE_STORE;
                sourceRemoteTranslogRepository,
        @Override
    /**
        @Override
    }
        @Override
    }
            index.writeTo(out);
        SnapshotRecoverySource(StreamInput in) throws IOException {
                remoteStoreIndexShallowCopy = in.readBoolean();
        }
        }
import org.opensearch.common.annotation.PublicApi;
            }
            return pinnedTimestamp;
            return false;
     *
        }
    @PublicApi(since = "1.0.0")
        SNAPSHOT,
                return new RemoteStoreRecoverySource(in);
        return false;
        private final long pinnedTimestamp;
                remoteStoreIndexShallowCopy,
                out.writeOptionalString(sourceRemoteTranslogRepository);
        builder.startObject();
    public static class InPlaceSplitShardRecoverySource extends RecoverySource {
        private final Version version;
/*
        private final String sourceRemoteStoreRepository;
            out.writeVersion(version);
import org.opensearch.common.Nullable;
            } else {
        public Type getType() {
        }
     * Recovery from remote store
 * - {@link EmptyStoreRecoverySource} recovery from an empty store
            this.index = Objects.requireNonNull(indexId);
 *
            boolean remoteStoreIndexShallowCopy,
                out.writeBoolean(isSearchableSnapshot);
                isSearchableSnapshot,
import org.opensearch.core.xcontent.XContentBuilder;
            default:
        }
            Snapshot snapshot,
        @Override
     * @opensearch.internal
     */
            Version version,
        public Version version() {
    public final XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
    }
        }
        protected void writeAdditionalFields(StreamOutput out) throws IOException {
        public static final LocalShardsRecoverySource INSTANCE = new LocalShardsRecoverySource();
            builder.field("version", version.toString()).field("index", index.getName()).field("restoreUUID", restoreUUID);
 * - {@link InPlaceSplitShardRecoverySource} recovery of child shards from a source shard on the same node
            index = new IndexId(in);
}
import java.io.IOException;
        private static ExistingStoreRecoverySource read(StreamInput in) throws IOException {
    @Override
        }
 * software distributed under the License is distributed on an
        @Override
        public boolean expectEmptyRetentionLeases() {
            case LOCAL_SHARDS:
        public String toString() {
            return Type.IN_PLACE_SPLIT_SHARD;
    @Override
            Snapshot snapshot,
    /**
        LOCAL_SHARDS,
            this.pinnedTimestamp = pinnedTimestamp;
        }
        public boolean equals(Object o) {
            builder.field("bootstrap_new_history_uuid", bootstrapNewHistoryUUID);
         */
        }
                return new SnapshotRecoverySource(in);
                .field("snapshot", snapshot.getSnapshotId().getName())
            return in.readBoolean() ? FORCE_STALE_PRIMARY_INSTANCE : INSTANCE;
        public SnapshotRecoverySource(
 * - {@link SnapshotRecoverySource} recovery from a snapshot
    public enum Type {
 * @opensearch.api
        @Override
        }
            boolean remoteStoreIndexShallowCopy,
                isSearchableSnapshot = in.readBoolean();
            this.restoreUUID = restoreUUID;
        private final String restoreUUID;
     */
    public void addAdditionalFields(XContentBuilder builder, ToXContent.Params params) throws IOException {
    @Override
            this.index = Objects.requireNonNull(indexId);
        public boolean equals(Object o) {
/**
        return getType() == that.getType();
        public Type getType() {
         * Gets the {@link IndexId} of the recovery source. May contain {@link IndexMetadata#INDEX_UUID_NA_VALUE} as the index uuid if it
        @Override
                remoteStoreIndexShallowCopy,
        private final boolean remoteStoreIndexShallowCopy;
 * <p>
    /**
    /**
        // i.e. we expect no retention leases, once the following issue is fixed:
                version,
                && snapshot.equals(that.snapshot)
        PEER,
        ) {
                .field("version", version.toString())
    /**
import org.opensearch.repositories.IndexId;
        public boolean isSearchableSnapshot() {
        public boolean shouldBootstrapNewHistoryUUID() {
         */
 * - {@link ExistingStoreRecoverySource} recovery from an existing store
            out.writeVersion(version);
            }
        }
        public boolean expectEmptyRetentionLeases() {
        @Override
 */
     * peer recovery from a primary shard
                .field("remoteStoreIndexShallowCopy", remoteStoreIndexShallowCopy)
 * The OpenSearch Contributors require contributions made to
            if (o == null || getClass() != o.getClass()) {
        }
     * @opensearch.internal
 * Licensed to Elasticsearch under one or more contributor
                return false;
     *
    }
        }
            }
            if (out.getVersion().onOrAfter(Version.V_2_9_0)) {
            return version;
                index,
        @Override
        private final Version version;
            }
        if (o == null || getClass() != o.getClass()) return false;
 * Represents the recovery source of a shard. Available recovery types are:
            this.bootstrapNewHistoryUUID = bootstrapNewHistoryUUID;
         */
        private final Snapshot snapshot;
        private final String restoreUUID;
    }
        public static final ExistingStoreRecoverySource FORCE_STALE_PRIMARY_INSTANCE = new ExistingStoreRecoverySource(true);
                isSearchableSnapshot = false;
            @Nullable String sourceRemoteStoreRepository,
        @Override
            restoreUUID = in.readString();
                && index.equals(that.index)
        @Override
            return false;
                sourceRemoteTranslogRepository = null;
            this.sourceRemoteStoreRepository = sourceRemoteStoreRepository;
    }
        RemoteStoreRecoverySource(StreamInput in) throws IOException {
 * GitHub history for details.
                sourceRemoteTranslogRepository = in.readOptionalString();
            @Nullable String sourceRemoteStoreRepository
    @Override
            if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
 * - {@link PeerRecoverySource} recovery from a primary on another node
        @Override
         * @return IndexId
                version,
            out.writeString(restoreUUID);
            return Type.SNAPSHOT;
        @Override
            return version;
        return builder.endObject();
                snapshot,
                pinnedTimestamp = in.readLong();
            case EXISTING_STORE:
            snapshot = new Snapshot(in);
import org.opensearch.snapshots.Snapshot;
        public static final ExistingStoreRecoverySource INSTANCE = new ExistingStoreRecoverySource(false);
        public boolean expectEmptyRetentionLeases() {
            }
import org.opensearch.core.xcontent.ToXContentObject;
    public static class PeerRecoverySource extends RecoverySource {
        public String toString() {
        public boolean expectEmptyRetentionLeases() {
            return bootstrapNewHistoryUUID;
            boolean isSearchableSnapshot,
 * - {@link LocalShardsRecoverySource} recovery from other shards of another index on the same node
     * @opensearch.experimental
        @Override
import org.opensearch.core.common.io.stream.Writeable;
            }
                null,
            return "peer recovery";
         *
        public boolean remoteStoreIndexShallowCopy() {
            RemoteStoreRecoverySource that = (RemoteStoreRecoverySource) o;
            return Type.PEER;
/*
        public String sourceRemoteTranslogRepository() {
        }
    }
                snapshot,
            out.writeString(restoreUUID);
        /**
 * KIND, either express or implied.  See the License for the
                restoreUUID,
        /**
    }
        ) {
     */
            return Objects.hash(
                : that.sourceRemoteStoreRepository == null && sourceRemoteTranslogRepository != null
                out.writeBoolean(remoteStoreIndexShallowCopy);
     * @opensearch.api
    public boolean shouldBootstrapNewHistoryUUID() {
import org.opensearch.core.common.io.stream.StreamInput;
        private final boolean bootstrapNewHistoryUUID;
        @Override
        public static final String NO_API_RESTORE_UUID = "_no_api_";
        public static final InPlaceSplitShardRecoverySource INSTANCE = new InPlaceSplitShardRecoverySource();
            return bootstrapNewHistoryUUID;
 * Unless required by applicable law or agreed to in writing,
            this.sourceRemoteTranslogRepository = sourceRemoteTranslogRepository;
        @Override
        public String toString() {
        @Override
        }
        }
            return remoteStoreIndexShallowCopy;
                return PeerRecoverySource.INSTANCE;
            }
                .field("index", index.getName())
    public abstract Type getType();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * compatible open source license.
         * @return IndexId
 *
            case SNAPSHOT:
        public String toString() {
                indexId,
     */
        private LocalShardsRecoverySource() {}
        }
            snapshot.writeTo(out);
            }
     * Recovery of child shards from a source shard on the same node during in-place shard split.
