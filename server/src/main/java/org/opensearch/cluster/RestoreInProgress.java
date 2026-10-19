        }
 *  
        return entries.equals(((RestoreInProgress) o).entries);
    @Override
    }
     * Shard restore process state
            uuid = in.readString();
 */  
            return this;  
            out.writeOptionalString(reason);
            }  
        /**
     * {@inheritDoc}
 * Unless required by applicable law or agreed to in writing,
        }  
        return readDiffFrom(Custom.class, TYPE, in);  
                    state,
    /**
        builder.endArray();
            this(nodeId, state, null);
        }
            ShardRestoreStatus shardSnapshotStatus = new ShardRestoreStatus();
         * Returns list of indices  
        builder.startArray("snapshots");
         * @param state      current state of the restore process
 * compatible open source license.
         */  
import org.opensearch.snapshots.Snapshot;
    public static class Entry {
            }  
            }  
    public String toString() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
    public boolean isEmpty() {
        }
                && shards.equals(entry.shards);  
         * Returns restore uuid
        /**
        /**
         */  
    @Deprecated(forRemoval = true) // Implementation is identical to NamedDiffable
         * Returns state code  
            }  
                builder.endObject();
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
         * Returns true if restore process completed (either successfully or with failure)  
        {  
            }  
        private final String uuid;  
        STARTED((byte) 1),
        /**
     * Builder of the restore.
         */
     *
        builder.endObject();
        }  
     *  
import org.opensearch.core.common.io.stream.StreamOutput;
        public static State fromValue(byte value) {
         */  
import java.util.Objects;  
import org.opensearch.core.xcontent.ToXContent;
        public void writeTo(StreamOutput out) throws IOException {
         *
            }  
        /**
         */  
        public String reason() {
         *
            return Objects.hash(uuid, snapshot, state, indices, shards);
            }
    }  
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {  
         */  
         * @param in stream input  
        builder.field("snapshot", entry.snapshot().getSnapshotId().getName());
         *
        public RestoreInProgress build() {  
         * Returns snapshot  
            this.state = Objects.requireNonNull(state);
 * not use this file except in compliance with the License.
        public State state() {
        /**  
                    builder.field("index", shardId.getIndex());
         */
         *
            } else {  
            final String uuid;
     */
     * @param entry   restore operation metadata  
 *
            return uuid;
         *
            if (this == o) {
        return TYPE;
        private final Map<String, Entry> entries = new HashMap<>();
 * specific language governing permissions and limitations
         */
         * Started state  
        private ShardRestoreStatus() {}
        this.entries = Collections.unmodifiableMap(entriesBuilder);
        public State state() {
        private final Map<ShardId, ShardRestoreStatus> shards;  
 * Meta data about restore processes that are currently executing
                    return STARTED;
package org.opensearch.cluster;
                case 3:
        @Override
                    builder.field("shard", shardId.getId());
         * @return failure reason  
            this.state = state;
    public static NamedDiff<Custom> readDiffFrom(StreamInput in) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
            if (o == null || getClass() != o.getClass()) {
        FAILURE((byte) 3);
     */
        builder.field("repository", entry.snapshot().getRepository());  
/*
    }  
         * @return state  
        this.entries = Collections.unmodifiableMap(entries);
        public boolean completed() {
         * @return state code
public class RestoreInProgress extends AbstractNamedDiffable<Custom> implements Custom, Iterable<RestoreInProgress.Entry> {  
         * Returns node id of the node where shared is getting restored
            return state;  
                case 1:  
        INIT((byte) 0),
        /**  
        builder.startArray("shards");  
        builder.startArray("indices");
            shardSnapshotStatus.readFrom(in);
 */
            return this == SUCCESS || this == FAILURE;
                case 2:
         * @return current state  
        if (o == null || getClass() != o.getClass()) return false;
        public ShardRestoreStatus(String nodeId, State state, String reason) {  
     * Represents status of a restored shard
     * @opensearch.internal
            State state = State.fromValue(in.readByte());
            return nodeId;  
        }
        @Override  
 * Modifications Copyright OpenSearch Contributors. See
        for (final Entry entry : entries.values()) {
     */  
                uuid,
        }  
    /**
         */
         */  
/*  
    public void toXContent(Entry entry, XContentBuilder builder) throws IOException {  
        }  
         * @param shards     map of shards being restored to their current restore status
     */
        public byte value() {
     */
            return state;
                )
         */  
        public Builder add(Entry entry) {
         * @param indices    list of indices being restored  
         * @return snapshot
            out.writeByte(entry.state().value());
            reason = in.readOptionalString();
        for (final Entry entry : entries.values()) {
        public int hashCode() {
         * Returns list of shards that being restore and their status  
         * @param snapshot   snapshot
            return state == status.state && Objects.equals(nodeId, status.nodeId) && Objects.equals(reason, status.reason);  
        }
        public static ShardRestoreStatus readShardRestoreStatus(StreamInput in) throws IOException {  
            out.writeString(entry.uuid);  
            toXContent(entry, builder);  
        private final byte value;  
        {
        private final Snapshot snapshot;
         *
/*  
         */
        }  
}
    @Override
        /**
    }  
            return this.shards;
        }
                ShardId shardId = shardEntry.getKey();  
        return entries.get(restoreUUID);
            this.nodeId = nodeId;
         * Creates new restore metadata
    /**  
        /**
     */
        // TODO: Only including this method to work around bug in japicmp.
    }
            out.writeOptionalString(nodeId);  
        entries.forEach((s, entry) -> builder.append("{").append(s).append("}{").append(entry.snapshot).append("},"));
        /**
         * Initializing state
         *
            this.reason = reason;  
    private RestoreInProgress(final Map<String, Entry> entries) {  
         * Returns current state
        }  
     * @param builder XContent builder
                    builder.field("state", status.state());  
         * Restore finished successfully
        public boolean equals(Object o) {  
        return Version.CURRENT.minimumCompatibilityVersion();
         */
    public static final String BWC_UUID = new UUID(0, 0).toString();
         * @param state  restore state  
        builder.endArray();
        /**
import java.util.Collections;
import java.io.IOException;  
            this.uuid = Objects.requireNonNull(uuid);  
 *     http://www.apache.org/licenses/LICENSE-2.0
    public Iterator<Entry> iterator() {  
    }  
        builder.endArray();  
import java.util.HashMap;
    public Version getMinimalSupportedVersion() {  
 */  
 * KIND, either express or implied.  See the License for the
    @Override
        public int hashCode() {
import java.util.Map;
         */  
import org.opensearch.cluster.ClusterState.Custom;
                    return SUCCESS;  
        return builder;  
     * Constructs new restore metadata
        if (this == o) return true;  
        }
        public Entry(String uuid, Snapshot snapshot, State state, List<String> indices, final Map<ShardId, ShardRestoreStatus> shards) {  
    public static final RestoreInProgress EMPTY = new RestoreInProgress(Map.of());  
        }
        public Map<ShardId, ShardRestoreStatus> shards() {
         * @return restore uuid
     * @param entries map of currently running restore processes keyed by their restore uuid
            return indices;
        public List<String> indices() {
         *  
        }  
         * @param uuid       uuid of the restore  
        int count = in.readVInt();
import org.opensearch.core.index.shard.ShardId;
        }  
 * under the License.  
                case 0:
    public void writeTo(StreamOutput out) throws IOException {  
            switch (value) {  
        /**
        return entries.values().iterator();
         *
        /**  
        /**  
                this.shards = Collections.unmodifiableMap(shards);
        }
    @PublicApi(since = "1.0.0")
    }  
    @Override
 */
         * Returns failure reason
 * ownership. Elasticsearch licenses this file to you under  
                }
            this.snapshot = Objects.requireNonNull(snapshot);
         * @param nodeId node id
    public RestoreInProgress(StreamInput in) throws IOException {  
    }
        }
        builder.field("state", entry.state());
            return reason;  
         * @param nodeId node id
        public Builder(RestoreInProgress restoreInProgress) {  
         * @param out stream input
            if (this == o) {
        @Override  
         */  
         *
            entry.snapshot().writeTo(out);
        }  
        /**  
         * @param state  restore state
 * The OpenSearch Contributors require contributions made to  
        @Override
        public boolean equals(Object o) {  
            entries.put(entry.uuid, entry);
         *
    }
                new Entry(
        }
import org.opensearch.Version;
        return entries.hashCode();
        final Map<String, Entry> entriesBuilder = new HashMap<>(count);
     * @opensearch.api
         * @param value stat code
            entriesBuilder.put(  
    /**  
            );  
    @Override
    }  
                && state == entry.state
 * license agreements. See the NOTICE file distributed with
    public static final String TYPE = "restore";
                    snapshot,
import java.util.UUID;
                builder.startObject();
         * @return list of indices
    public static final class Builder {  
        private final List<String> indices;
import java.util.Iterator;  
 *
         *
            return entries.isEmpty() ? EMPTY : new RestoreInProgress(entries);
     */
    /**  
         * Restore failed
         */  
            out.writeMap(entry.shards, (o, shardId) -> shardId.writeTo(o), (o, status) -> status.writeTo(o));
                && snapshot.equals(entry.snapshot)  
    }
    /**
         */  
            }
 * software distributed under the License is distributed on an
            entries.putAll(restoreInProgress.entries);
         * @param reason failure reason
 * Licensed to Elasticsearch under one or more contributor  
            ShardRestoreStatus status = (ShardRestoreStatus) o;
    public enum State {  
@PublicApi(since = "1.0.0")
        SUCCESS((byte) 2),  
        builder.startObject();
    }
        }  
         */
         *
         * Constructs a new shard restore status in with specified state on the given node
     * Serializes single restore operation
         * @param value state code
        public Snapshot snapshot() {
         *
 * this work for additional information regarding copyright
     * @opensearch.api  
                return true;
 * this file be licensed under the Apache-2.0 license or a
        /**  
        }
         *
         */
            return this.snapshot;
        return builder.toString();  
            if (o == null || getClass() != o.getClass()) {
         * @return map of shard id to shard restore status
        private final State state;
                {  
            this.value = value;
        public ShardRestoreStatus(String nodeId, State state) {
        /**
        }  
         */  
         * Reads restore status from stream input
            if (shards == null) {
            for (final Map.Entry<ShardId, ShardRestoreStatus> shardEntry : entry.shards.entrySet()) {
                return false;
     *
        }
        }
         * Returns state corresponding to state code  
        private String nodeId;
         * Constructs a new shard restore status in initializing state on the given node
        private State state;
                && indices.equals(entry.indices)
         * @return node id  
        State(byte value) {
                    uuid,  
    }
    }
     */
    }
         * @param nodeId node id
import org.opensearch.common.annotation.PublicApi;  
        /**
            nodeId = in.readOptionalString();  
        builder.setCharAt(builder.length() - 1, ']');
                    return INIT;
    }
    public String getWriteableName() {
                    throw new IllegalArgumentException("No snapshot state for value [" + value + "]");
            List<String> indexBuilder = in.readStringList();
         * @return restore state
        public String nodeId() {
        public String uuid() {
                    in.readMap(ShardId::new, ShardRestoreStatus::readShardRestoreStatus)
import org.opensearch.core.common.io.stream.StreamInput;
                return false;
    @Override
        }
        out.writeVInt(entries.size());
            Snapshot snapshot = new Snapshot(in);  
        private String reason;  
         */
            out.writeByte(state.value);
    @Override  
            this.indices = Objects.requireNonNull(indices);  
        }  
            for (String index : entry.indices()) {
            return shardSnapshotStatus;  
                default:  
                builder.value(index);
        /**  
        public Builder() {}
 * @opensearch.api  
         * Constructs a new shard restore status in with specified state on the given node with specified failure reason  
            return Objects.hash(state, nodeId, reason);
         */
     *  
         *
    @PublicApi(since = "1.0.0")
         * @return restore status
        }
    @PublicApi(since = "1.0.0")
import org.opensearch.core.common.io.stream.Writeable;  
            return value;
                ShardRestoreStatus status = shardEntry.getValue();
import java.util.List;
            this(nodeId, State.INIT);
    private final Map<String, Entry> entries;
        }  
        /**
         * @return true if restore process completed
         * @param in stream input  
         * Writes restore status to stream output  
                    return FAILURE;
         */
        StringBuilder builder = new StringBuilder("RestoreInProgress[");  
         * Reads restore status from stream input
            return uuid.equals(entry.uuid)
                return true;
     * Restore metadata  
    public int hashCode() {  
    /**
                this.shards = Map.of();
 *
 * You may obtain a copy of the License at  
        /**
                    Collections.unmodifiableList(indexBuilder),  
            out.writeStringCollection(entry.indices);  
     * Fallback UUID used for restore operations that were started before v6.6 and don't have a uuid in the cluster state.  
         * Constructs new state  
     *
    @Override
            Entry entry = (Entry) o;
    }
        /**  
import org.opensearch.core.xcontent.XContentBuilder;  
    public boolean equals(Object o) {
     * @opensearch.api  
         *
        }
/**  
        /**
        return entries.isEmpty();
         *  
         * Returns current restore state  
     *
        for (int i = 0; i < count; i++) {  
        public void readFrom(StreamInput in) throws IOException {
 * GitHub history for details.
        public ShardRestoreStatus(String nodeId) {  
    public Entry get(String restoreUUID) {  
        }  
    /**  
            state = State.fromValue(in.readByte());
    public static class ShardRestoreStatus implements Writeable {  
