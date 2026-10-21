         * Constructs new state
            );
         */
import java.util.Iterator;
 * not use this file except in compliance with the License.
    }
            out.writeString(entry.uuid);
    }
                case 3:
         *
         * Returns state corresponding to state code
            }
 * this file be licensed under the Apache-2.0 license or a
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
     */
import org.opensearch.core.xcontent.XContentBuilder;
    }
 * under the License.
    private RestoreInProgress(final Map<String, Entry> entries) {
                case 0:
         * @param nodeId node id
         * Returns state code
         * @return state
        /**
         */
            return state;
         * @param value stat code
        State(byte value) {
 */
         */
}
    @Override
        FAILURE((byte) 3);
        /**
    /**
        private final List<String> indices;
        private final byte value;
         *
        }
            }
         */
     * @param builder XContent builder
         *
        }
 * Unless required by applicable law or agreed to in writing,
        }
            entries.put(entry.uuid, entry);
         *
        public int hashCode() {
         */
         * @return map of shard id to shard restore status
         * Restore failed
    @PublicApi(since = "1.0.0")
            return uuid;
    public Entry get(String restoreUUID) {
         * @param snapshot   snapshot
                    return FAILURE;
 * You may obtain a copy of the License at
        /**
        }
        }
            this.reason = reason;
    public static final String BWC_UUID = new UUID(0, 0).toString();
                return false;
        /**
         *
                    uuid,
         */
public class RestoreInProgress extends AbstractNamedDiffable<Custom> implements Custom, Iterable<RestoreInProgress.Entry> {
    }
        return Version.CURRENT.minimumCompatibilityVersion();
                this.shards = Map.of();
            ShardRestoreStatus shardSnapshotStatus = new ShardRestoreStatus();
import org.opensearch.core.common.io.stream.Writeable;
            final String uuid;
        public ShardRestoreStatus(String nodeId, State state) {
    public String toString() {
import org.opensearch.common.annotation.PublicApi;
        builder.endArray();
            out.writeOptionalString(reason);
        return builder.toString();
         */
    public boolean isEmpty() {
            return uuid.equals(entry.uuid)
        public Snapshot snapshot() {
        builder.setCharAt(builder.length() - 1, ']');
     */
        /**
        /**
         * @param state  restore state
    public RestoreInProgress(StreamInput in) throws IOException {
         * @return node id
     * Shard restore process state
        @Override
        /**
                default:
            this.indices = Objects.requireNonNull(indices);
    }
     */
     *
        }
 *
        return entries.isEmpty();
                && state == entry.state
import org.opensearch.cluster.ClusterState.Custom;
            nodeId = in.readOptionalString();
                builder.endObject();
     * {@inheritDoc}
        public ShardRestoreStatus(String nodeId, State state, String reason) {
         * @return restore status
            }
    @Override
 * license agreements. See the NOTICE file distributed with
        return entries.equals(((RestoreInProgress) o).entries);
    public String getWriteableName() {
        }
        /**
                case 1:
        public Entry(String uuid, Snapshot snapshot, State state, List<String> indices, final Map<ShardId, ShardRestoreStatus> shards) {
import java.util.HashMap;
         *
            if (shards == null) {
                builder.startObject();
         * Constructs a new shard restore status in with specified state on the given node with specified failure reason
            }
         * @param out stream input
        }
     * Builder of the restore.
        public Map<ShardId, ShardRestoreStatus> shards() {
            return indices;
        {
                new Entry(
     */
            return this.shards;
            this(nodeId, State.INIT);
 * GitHub history for details.
        }
            toXContent(entry, builder);
            this.snapshot = Objects.requireNonNull(snapshot);
            return shardSnapshotStatus;
        builder.startArray("snapshots");
            switch (value) {
        public ShardRestoreStatus(String nodeId) {
         */
         */
        return readDiffFrom(Custom.class, TYPE, in);
         */
            out.writeOptionalString(nodeId);
import java.util.Objects;
     */
 * the Apache License, Version 2.0 (the "License"); you may
        return TYPE;
        }
        INIT((byte) 0),
     * Represents status of a restored shard
         * @param state      current state of the restore process
                    builder.field("index", shardId.getIndex());
        public static State fromValue(byte value) {
        @Override
        private State state;
    @Override
 * KIND, either express or implied.  See the License for the
/*
            this(nodeId, state, null);
        }
         */
         * Returns node id of the node where shared is getting restored
        STARTED((byte) 1),
        /**
        }
        @Override
         * @return restore uuid
     * @param entry   restore operation metadata
     * Fallback UUID used for restore operations that were started before v6.6 and don't have a uuid in the cluster state.
        private final Map<String, Entry> entries = new HashMap<>();
            return this;
    }
            return this == SUCCESS || this == FAILURE;
/*
     * Restore metadata
         * @param shards     map of shards being restored to their current restore status
         * Returns current restore state
        /**
         * @param reason failure reason
         *
import java.util.Map;
                builder.value(index);
            this.state = Objects.requireNonNull(state);
        public Builder() {}
        }
            if (this == o) {
        }
     *
                    in.readMap(ShardId::new, ShardRestoreStatus::readShardRestoreStatus)
                    return SUCCESS;
    @Deprecated(forRemoval = true) // Implementation is identical to NamedDiffable
        public void readFrom(StreamInput in) throws IOException {
    public boolean equals(Object o) {
            entriesBuilder.put(
        public Builder add(Entry entry) {
         * Constructs a new shard restore status in with specified state on the given node
     */
        for (final Entry entry : entries.values()) {
         * @param in stream input
     * @opensearch.api
         *
        public int hashCode() {
        public State state() {
        }
    }
        public byte value() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public static class ShardRestoreStatus implements Writeable {
    public static final class Builder {
            state = State.fromValue(in.readByte());
            reason = in.readOptionalString();
    }
         * @return true if restore process completed
        /**
                && snapshot.equals(entry.snapshot)
         * @param uuid       uuid of the restore
        public String reason() {
         *
        /**
import org.opensearch.core.common.io.stream.StreamOutput;
            return entries.isEmpty() ? EMPTY : new RestoreInProgress(entries);
 *
            for (String index : entry.indices()) {
            return state;
        if (o == null || getClass() != o.getClass()) return false;
                    snapshot,
    @Override
         */
        /**
        }
 * Modifications Copyright OpenSearch Contributors. See
     * @param entries map of currently running restore processes keyed by their restore uuid
    }
    public static class Entry {
    public enum State {
 * compatible open source license.
        for (final Entry entry : entries.values()) {
        }
        final Map<String, Entry> entriesBuilder = new HashMap<>(count);
    public int hashCode() {
         */
        }
            return Objects.hash(state, nodeId, reason);
            Entry entry = (Entry) o;
 * @opensearch.api
         * Constructs a new shard restore status in initializing state on the given node
            }
                    throw new IllegalArgumentException("No snapshot state for value [" + value + "]");
import java.util.Collections;
    }
    @Override
         *
        /**
        public RestoreInProgress build() {
        @Override
         * @param value state code
            return state == status.state && Objects.equals(nodeId, status.nodeId) && Objects.equals(reason, status.reason);
    @Override
            return Objects.hash(uuid, snapshot, state, indices, shards);
        builder.startObject();
         *
        builder.field("snapshot", entry.snapshot().getSnapshotId().getName());
        builder.endObject();
        /**
                    return INIT;
    /**
        /**
        /**
                return false;
        builder.endArray();
        return entries.get(restoreUUID);
        /**
         * Writes restore status to stream output
        /**
 *
import org.opensearch.core.xcontent.ToXContent;
        public State state() {
         *
        this.entries = Collections.unmodifiableMap(entries);
import org.opensearch.core.common.io.stream.StreamInput;
         * Reads restore status from stream input
                    builder.field("state", status.state());
    public static final RestoreInProgress EMPTY = new RestoreInProgress(Map.of());
     * @opensearch.api
         *
        private String nodeId;
     */
 * this work for additional information regarding copyright
                && shards.equals(entry.shards);
        /**
            shardSnapshotStatus.readFrom(in);
        }
            uuid = in.readString();
/*
        return entries.hashCode();
        return builder;
        public void writeTo(StreamOutput out) throws IOException {
     *
         * @return list of indices
         * Returns restore uuid
@PublicApi(since = "1.0.0")
         * @return state code
        builder.field("repository", entry.snapshot().getRepository());
                }
         * @param nodeId node id
        public String nodeId() {
 */
            State state = State.fromValue(in.readByte());
 * ownership. Elasticsearch licenses this file to you under
    }
    }
        private final String uuid;
            this.state = state;
         */
                )
                this.shards = Collections.unmodifiableMap(shards);
 * specific language governing permissions and limitations
        public boolean completed() {
        }
    /**
         * @return current state
         */
            if (o == null || getClass() != o.getClass()) {
    }
         * Creates new restore metadata
 * software distributed under the License is distributed on an
            if (o == null || getClass() != o.getClass()) {
/**
    }
            return reason;
         * Started state
        builder.field("state", entry.state());
        }
        private ShardRestoreStatus() {}
    /**
         * Returns current state
         *
        public List<String> indices() {
         */
         * Returns failure reason
                return true;
import java.io.IOException;
         *
            return nodeId;
        public Builder(RestoreInProgress restoreInProgress) {
         */
         * @return snapshot
        /**
        this.entries = Collections.unmodifiableMap(entriesBuilder);
import java.util.List;
     * Constructs new restore metadata
        entries.forEach((s, entry) -> builder.append("{").append(s).append("}{").append(entry.snapshot).append("},"));
        }
            out.writeByte(state.value);
         * Restore finished successfully
                    state,
            List<String> indexBuilder = in.readStringList();
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**
 */
import java.util.UUID;
     * Serializes single restore operation
            entries.putAll(restoreInProgress.entries);
            return value;
            entry.snapshot().writeTo(out);
        private final Map<ShardId, ShardRestoreStatus> shards;
        @Override
import org.opensearch.Version;
            }
         *
        // TODO: Only including this method to work around bug in japicmp.
                uuid,
         *
         * Initializing state
                ShardId shardId = shardEntry.getKey();
     *
                    Collections.unmodifiableList(indexBuilder),
import org.opensearch.core.index.shard.ShardId;
                ShardRestoreStatus status = shardEntry.getValue();
    public Version getMinimalSupportedVersion() {
            } else {
 * Meta data about restore processes that are currently executing
         */
    /**
         * @param state  restore state
            out.writeMap(entry.shards, (o, shardId) -> shardId.writeTo(o), (o, status) -> status.writeTo(o));
            out.writeByte(entry.state().value());
                && indices.equals(entry.indices)
            out.writeStringCollection(entry.indices);
        StringBuilder builder = new StringBuilder("RestoreInProgress[");
 */
        }
        public String uuid() {
            this.uuid = Objects.requireNonNull(uuid);
            this.nodeId = nodeId;
     * @opensearch.api
    public void toXContent(Entry entry, XContentBuilder builder) throws IOException {
         * @return restore state
         */
 * Licensed to Elasticsearch under one or more contributor
                case 2:
        }
                    builder.field("shard", shardId.getId());
     *
    public void writeTo(StreamOutput out) throws IOException {
    }
    public static final String TYPE = "restore";
    public static NamedDiff<Custom> readDiffFrom(StreamInput in) throws IOException {
    }
                return true;
        /**
        }
            return this.snapshot;
         */
         * @param nodeId node id
         * @param indices    list of indices being restored
            }
        out.writeVInt(entries.size());
 * The OpenSearch Contributors require contributions made to
         */
 *
        int count = in.readVInt();
        }
                    return STARTED;
            Snapshot snapshot = new Snapshot(in);
        private final State state;
    private final Map<String, Entry> entries;
            if (this == o) {
        public boolean equals(Object o) {
     * @opensearch.internal
        /**
            this.value = value;
        }
         */
        }
         * @param in stream input
        }
    /**
    @Override
         * Returns list of indices
package org.opensearch.cluster;
    }
    @PublicApi(since = "1.0.0")
        builder.startArray("shards");
            for (final Map.Entry<ShardId, ShardRestoreStatus> shardEntry : entry.shards.entrySet()) {
        for (int i = 0; i < count; i++) {
        }
        SUCCESS((byte) 2),
        public static ShardRestoreStatus readShardRestoreStatus(StreamInput in) throws IOException {
         * Reads restore status from stream input
            }
        private String reason;
        builder.startArray("indices");
         *
    @Override
    /**
    }
        return entries.values().iterator();
         */
        private final Snapshot snapshot;
    public Iterator<Entry> iterator() {
import org.opensearch.snapshots.Snapshot;
        public boolean equals(Object o) {
         * Returns true if restore process completed (either successfully or with failure)
         * Returns list of shards that being restore and their status
        }
        builder.endArray();
     *
         * Returns snapshot
        {
         * @return failure reason
 * SPDX-License-Identifier: Apache-2.0
    @PublicApi(since = "1.0.0")
                {
            ShardRestoreStatus status = (ShardRestoreStatus) o;
        if (this == o) return true;
     */
