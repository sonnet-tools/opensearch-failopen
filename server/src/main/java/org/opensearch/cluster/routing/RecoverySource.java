        }
    public boolean equals(Object o) {
    public void addAdditionalFields(XContentBuilder builder, ToXContent.Params params) throws IOException {
            if (o == null || getClass() != o.getClass()) {
        @Override
        public Version version() {  
     */
        public int hashCode() {
    public enum Type {
        }
        public static final ExistingStoreRecoverySource INSTANCE = new ExistingStoreRecoverySource(false);  
            IndexId indexId,  
                : that.sourceRemoteTranslogRepository == null && pinnedTimestamp == that.pinnedTimestamp;
        public RemoteStoreRecoverySource(String restoreUUID, Version version, IndexId indexId) {
        private LocalShardsRecoverySource() {}
                return InPlaceSplitShardRecoverySource.INSTANCE;
     * @opensearch.experimental
     * peer recovery from a primary shard  
        public static final LocalShardsRecoverySource INSTANCE = new LocalShardsRecoverySource();  
            return Objects.hash(
        public String sourceRemoteStoreRepository() {
import org.opensearch.core.xcontent.ToXContentObject;  
        public Type getType() {
        protected void writeAdditionalFields(StreamOutput out) throws IOException {
        @Override
        protected void writeAdditionalFields(StreamOutput out) throws IOException {
    }
            @Nullable String sourceRemoteStoreRepository,
        }
        private static ExistingStoreRecoverySource read(StreamInput in) throws IOException {  
        }
                sourceRemoteTranslogRepository = in.readOptionalString();
        }
        }
        public Type getType() {
    }  
    public boolean expectEmptyRetentionLeases() {
                isSearchableSnapshot = false;  
        }
     *
    @Override
    public static RecoverySource readFrom(StreamInput in) throws IOException {
            return index;  
        }  
        switch (type) {
            return bootstrapNewHistoryUUID;
 * - {@link EmptyStoreRecoverySource} recovery from an empty store
        }
        public Type getType() {  
    }
    /**  
                null,
         */
                .field("restoreUUID", restoreUUID)  
 * - {@link LocalShardsRecoverySource} recovery from other shards of another index on the same node  
 * Represents the recovery source of a shard. Available recovery types are:  
        private final String sourceRemoteStoreRepository;
            restoreUUID = in.readString();
     *  
        @Override  
            );  
        public static final String NO_API_RESTORE_UUID = "_no_api_";  
            builder.field("repository", snapshot.getRepository())
        public IndexId index() {
        public Version version() {  
     * @opensearch.internal
        }  
        private InPlaceSplitShardRecoverySource() {}
        }  
        @Override  
 * You may obtain a copy of the License at  
        }
            return in.readBoolean() ? FORCE_STALE_PRIMARY_INSTANCE : INSTANCE;
                restoreUUID,  
            return bootstrapNewHistoryUUID;
        @Override
            this(restoreUUID, snapshot, version, indexId, false, false, null);
     * recovery from a snapshot
        protected void writeAdditionalFields(StreamOutput out) throws IOException {
        public Type getType() {  
        public Type getType() {
        }  
     */
        @Override
            index = new IndexId(in);
    }  
            Snapshot snapshot,
            return "local shards recovery";
            case REMOTE_STORE:
 * Unless required by applicable law or agreed to in writing,
            if (this == o) {
            return "remote store recovery [" + restoreUUID + "]";
     * @opensearch.internal  
    @PublicApi(since = "1.0.0")  
            boolean remoteStoreIndexShallowCopy,
        private PeerRecoverySource() {}
     * Recovery from a fresh copy
         *
        }
        @Override
        REMOTE_STORE,
            return version;
            this.version = Objects.requireNonNull(version);
        }
    @Override
                version,
         *
        }  
            return "new shard recovery";  
        public boolean expectEmptyRetentionLeases() {  
         * @return IndexId  
        /**
         * Gets the {@link IndexId} of the recovery source. May contain {@link IndexMetadata#INDEX_UUID_NA_VALUE} as the index uuid if it  
        }
                throw new IllegalArgumentException("unknown recovery type: " + type.name());
            return remoteStoreIndexShallowCopy;
         * Special allocation id that shard has during initialization on allocate_stale_primary
        public boolean expectEmptyRetentionLeases() {  
                out.writeBoolean(remoteStoreIndexShallowCopy);
    }
        }
                pinnedTimestamp
import org.opensearch.common.annotation.PublicApi;
            index = new IndexId(in);
        }
            version = in.readVersion();  
        }
    /**
        @Override
                snapshot,
     * @opensearch.internal
            return Type.LOCAL_SHARDS;  
            snapshot.writeTo(out);  
                return true;
    public boolean shouldBootstrapNewHistoryUUID() {
 * not use this file except in compliance with the License.
     */
            if (out.getVersion().onOrAfter(Version.V_2_7_0)) {  
                remoteStoreIndexShallowCopy = in.readBoolean();  
    }
 *
        }  
     * @opensearch.api
        addAdditionalFields(builder, params);  
    public static final class EmptyStoreRecoverySource extends RecoverySource {
     *
                && version.equals(that.version)
    public final void writeTo(StreamOutput out) throws IOException {
            this.sourceRemoteTranslogRepository = sourceRemoteTranslogRepository;  
import org.opensearch.core.common.io.stream.Writeable;
                return EmptyStoreRecoverySource.INSTANCE;  
        private final Version version;
                return new SnapshotRecoverySource(in);  
     */
            return "snapshot recovery [" + restoreUUID + "] from " + snapshot;  
    /**
        }  
        }
                .field("sourceRemoteTranslogRepository", sourceRemoteTranslogRepository);
            case EXISTING_STORE:
        SNAPSHOT,
        }  
@PublicApi(since = "1.0.0")
 */
    }
                out.writeOptionalString(sourceRemoteStoreRepository);
            Version version,
            SnapshotRecoverySource that = (SnapshotRecoverySource) o;  
 * - {@link ExistingStoreRecoverySource} recovery from an existing store  
                .field("snapshot", snapshot.getSnapshotId().getName())  
            return restoreUUID;
     * to be overridden by subclasses
import org.opensearch.core.xcontent.ToXContent;
        @Override
        builder.field("type", getType());
/*  
            return index;  
    public abstract Type getType();
        }
                return true;  
        @Override  
            }
            builder.field("version", version.toString()).field("index", index.getName()).field("restoreUUID", restoreUUID);  
 * under the License.  
        /**
        }
        @Override
        private final IndexId index;
    }  
            return "existing store recovery; bootstrap_history_uuid=" + bootstrapNewHistoryUUID;
        private final Version version;
                .field("version", version.toString())
        IN_PLACE_SPLIT_SHARD
        @Override
                sourceRemoteStoreRepository,  
            this.sourceRemoteStoreRepository = sourceRemoteStoreRepository;
 * license agreements. See the NOTICE file distributed with
         * @return IndexId  
     * Recovery from an existing on-disk store
import org.opensearch.common.Nullable;  
    }
         * was created by an older version cluster-manager in a mixed version cluster.
            } else {
                return PeerRecoverySource.INSTANCE;
    /**
        private final String sourceRemoteTranslogRepository;  
        }
        private final String restoreUUID;  
            out.writeString(restoreUUID);  
        RemoteStoreRecoverySource(StreamInput in) throws IOException {
/**
                sourceRemoteTranslogRepository,
            if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
        @Override  
    @Override  
                return false;
/*
        builder.startObject();
            index.writeTo(out);
        // TODO: This override should be removed/be updated to return "true",
            return "peer recovery";
     *  
                && isSearchableSnapshot == that.isSearchableSnapshot
 * KIND, either express or implied.  See the License for the
                return new RemoteStoreRecoverySource(in);  
        public String toString() {
        // i.e. we expect no retention leases, once the following issue is fixed:  
        }
            }
        private final Snapshot snapshot;  
        public String toString() {
    @PublicApi(since = "1.0.0")  
            return restoreUUID.equals(that.restoreUUID)
    }
        private final String restoreUUID;
            out.writeVersion(version);
        public static final PeerRecoverySource INSTANCE = new PeerRecoverySource();  
        }  
            long pinnedTimestamp  
 */  
        public IndexId index() {
        public void addAdditionalFields(XContentBuilder builder, ToXContent.Params params) throws IOException {
    }
                && snapshot.equals(that.snapshot)
            return false;
        }  
        SnapshotRecoverySource(StreamInput in) throws IOException {
    /**
     * to be overridden by subclasses
            this.index = Objects.requireNonNull(indexId);
                0L
                return LocalShardsRecoverySource.INSTANCE;
                sourceRemoteTranslogRepository = null;
        @Override
        }
        }
 * - {@link PeerRecoverySource} recovery from a primary on another node
import org.opensearch.core.xcontent.XContentBuilder;
     *  
        }  
                && sourceRemoteStoreRepository != null
     */  
        public boolean expectEmptyRetentionLeases() {  
 * Modifications Copyright OpenSearch Contributors. See
            }
        }
            case LOCAL_SHARDS:
        public void addAdditionalFields(XContentBuilder builder, ToXContent.Params params) throws IOException {
    public static final class ExistingStoreRecoverySource extends RecoverySource {  
            }  
                isSearchableSnapshot,
        public String toString() {
 */  
        return builder.endObject();
            return snapshot;
                return false;  
                pinnedTimestamp = in.readLong();
        private final long pinnedTimestamp;
            }  
                remoteStoreIndexShallowCopy,
     *  
            return Type.PEER;  
                : that.sourceRemoteStoreRepository == null && sourceRemoteTranslogRepository != null  
 * - {@link SnapshotRecoverySource} recovery from a snapshot
     */  
            } else {  
    @Override  
            boolean remoteStoreIndexShallowCopy,  
        public static final String FORCED_ALLOCATION_ID = "_forced_allocation_";
        }
            this.snapshot = Objects.requireNonNull(snapshot);  
            case IN_PLACE_SPLIT_SHARD:  
    public static class RemoteStoreRecoverySource extends RecoverySource {
            if (in.getVersion().onOrAfter(Version.V_2_7_0)) {  
            return Type.SNAPSHOT;  
            }
                return ExistingStoreRecoverySource.read(in);
            restoreUUID = in.readString();
        public String toString() {
        public String restoreUUID() {
                remoteStoreIndexShallowCopy = false;  
            default:
    /**
        EMPTY_STORE,
            @Nullable String sourceRemoteTranslogRepository,
                sourceRemoteStoreRepository = null;
                remoteStoreIndexShallowCopy,
     */  
            this.restoreUUID = restoreUUID;
package org.opensearch.cluster.routing;
    public static class PeerRecoverySource extends RecoverySource {
 * <p>
            out.writeVersion(version);
            return false;  
                .field("remoteStoreIndexShallowCopy", remoteStoreIndexShallowCopy)
        @Override
}
import org.opensearch.snapshots.Snapshot;  
        }
            out.writeString(restoreUUID);
        @Override
            this.restoreUUID = restoreUUID;
        }
        @Override  
        public boolean equals(Object o) {  
        if (this == o) return true;
                indexId,  
        @Override  
        @Override
        @Override  
            snapshot = new Snapshot(in);  
        public void addAdditionalFields(XContentBuilder builder, Params params) throws IOException {
            boolean isSearchableSnapshot,
     * recovery from other shards on same node (shrink index action)  
        }
 */
            this.version = Objects.requireNonNull(version);  
import org.opensearch.Version;
            String restoreUUID,
 * The OpenSearch Contributors require contributions made to  
    @PublicApi(since = "1.0.0")  
import org.opensearch.cluster.metadata.IndexMetadata;
        public long pinnedTimestamp() {
        }  
        ) {
                out.writeOptionalString(sourceRemoteTranslogRepository);
            return restoreUUID.equals(that.restoreUUID) && index.equals(that.index) && version.equals(that.version);  
        public String restoreUUID() {  
 * specific language governing permissions and limitations
        @Override  
            case EMPTY_STORE:
     * @opensearch.api
        PEER,
            if (this == o) {
 * Licensed to Elasticsearch under one or more contributor  
     *  
            return version;
    protected void writeAdditionalFields(StreamOutput out) throws IOException {  
            return sourceRemoteStoreRepository;  
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
                .field("index", index.getName())
        private final boolean remoteStoreIndexShallowCopy;
            RemoteStoreRecoverySource that = (RemoteStoreRecoverySource) o;
        public boolean isSearchableSnapshot() {
        }
        }
        public Type getType() {
        }
        public boolean shouldBootstrapNewHistoryUUID() {  
        @Override
        ) {
        public static final InPlaceSplitShardRecoverySource INSTANCE = new InPlaceSplitShardRecoverySource();
        private ExistingStoreRecoverySource(boolean bootstrapNewHistoryUUID) {
        }
         */  
         * was created by an older version cluster-manager in a mixed version cluster.
 * software distributed under the License is distributed on an
     */
     *
        public String toString() {  
            );  
            this.pinnedTimestamp = pinnedTimestamp;
            this(
import org.opensearch.core.common.io.stream.StreamOutput;  
            return Type.EXISTING_STORE;  
            return pinnedTimestamp;  
        return getType() == that.getType();
            return sourceRemoteTranslogRepository;
        return true;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }  
        public Type getType() {
                .field("isSearchableSnapshot", isSearchableSnapshot)
            version = in.readVersion();
 * compatible open source license.
            case PEER:  
     */
 *
            }
    /**  
            boolean isSearchableSnapshot,
     * @opensearch.api
    public static class SnapshotRecoverySource extends RecoverySource {
                    ? sourceRemoteTranslogRepository.equals(that.sourceRemoteTranslogRepository)
        @Override
        public String toString() {
        public Snapshot snapshot() {
         */
            return Type.EMPTY_STORE;
            out.writeBoolean(bootstrapNewHistoryUUID);
            if (in.getVersion().onOrAfter(Version.V_2_9_0)) {
            return restoreUUID;
        public boolean remoteStoreIndexShallowCopy() {
            }  
        public SnapshotRecoverySource(String restoreUUID, Snapshot snapshot, Version version, IndexId indexId) {
        if (o == null || getClass() != o.getClass()) return false;  
        }
        RecoverySource that = (RecoverySource) o;
 * SPDX-License-Identifier: Apache-2.0
                ? sourceRemoteStoreRepository.equals(that.sourceRemoteStoreRepository)
 *  
import org.opensearch.core.common.io.stream.StreamInput;
                restoreUUID,  
 * GitHub history for details.
            this.index = Objects.requireNonNull(indexId);
        @Override
        }
        EXISTING_STORE,  
     * @opensearch.internal
        public int hashCode() {
import java.io.IOException;
        }  
            @Nullable String sourceRemoteStoreRepository  
            String restoreUUID,  
import java.util.Objects;  
    }  
                version,  
                isSearchableSnapshot,
     * Recovery from remote store
            return Objects.hash(restoreUUID, index, version);
            return isSearchableSnapshot;
            if (in.getVersion().onOrAfter(Version.V_2_17_0)) {  
            return "in-place shard split";
                index,
        LOCAL_SHARDS,  
        @Override
        private final boolean bootstrapNewHistoryUUID;  
            Snapshot snapshot,
    }
    }
            Version version,  
    public final XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {  
        public static final EmptyStoreRecoverySource INSTANCE = new EmptyStoreRecoverySource();  
                sourceRemoteStoreRepository = in.readOptionalString();
 * - {@link InPlaceSplitShardRecoverySource} recovery of child shards from a source shard on the same node
        public SnapshotRecoverySource(  
 * ownership. Elasticsearch licenses this file to you under  
            index.writeTo(out);
            this.remoteStoreIndexShallowCopy = remoteStoreIndexShallowCopy;
            if (o == null || getClass() != o.getClass()) {
    }
     */
                snapshot,
        writeAdditionalFields(out);  
            IndexId indexId,
                out.writeBoolean(isSearchableSnapshot);
                isSearchableSnapshot = in.readBoolean();
                pinnedTimestamp = 0L;
 * @opensearch.api  
     * Type of recovery.
                out.writeLong(pinnedTimestamp);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        /**
        @Override
            case SNAPSHOT:
    public static class InPlaceSplitShardRecoverySource extends RecoverySource {  
            return Type.IN_PLACE_SPLIT_SHARD;
        public SnapshotRecoverySource(
            return Type.REMOTE_STORE;
            return false;
        Type type = Type.values()[in.readByte()];  
        @Override  
        }
        @Override  
        return false;
        public String toString() {
        private final boolean isSearchableSnapshot;  
            builder.field("bootstrap_new_history_uuid", bootstrapNewHistoryUUID);  
        public boolean equals(Object o) {
    public static class LocalShardsRecoverySource extends RecoverySource {
        out.writeByte((byte) getType().ordinal());
    /**
        // https://github.com/opensearch-project/OpenSearch/issues/8795
        }  
            }
import org.opensearch.repositories.IndexId;
         * Gets the {@link IndexId} of the recovery source. May contain {@link IndexMetadata#INDEX_UUID_NA_VALUE} as the index uuid if it  
        public boolean expectEmptyRetentionLeases() {
        @Override  
 * this file be licensed under the Apache-2.0 license or a
public abstract class RecoverySource implements Writeable, ToXContentObject {  
        return getType().hashCode();  
    }  
        }
                && index.equals(that.index)  
    /**
/*  
            this.bootstrapNewHistoryUUID = bootstrapNewHistoryUUID;  
            if (out.getVersion().onOrAfter(Version.V_2_9_0)) {  
                && remoteStoreIndexShallowCopy == that.remoteStoreIndexShallowCopy  
    /**
                sourceRemoteStoreRepository,  
                .field("sourceRemoteStoreRepository", sourceRemoteStoreRepository)  
     * Recovery of child shards from a source shard on the same node during in-place shard split.
        public String sourceRemoteTranslogRepository() {  
            this.isSearchableSnapshot = isSearchableSnapshot;  
            } else {
        }
 *
    public int hashCode() {
        private final IndexId index;
        public static final ExistingStoreRecoverySource FORCE_STALE_PRIMARY_INSTANCE = new ExistingStoreRecoverySource(true);
    }  
