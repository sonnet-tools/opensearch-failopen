    /**
        public Entry(StreamInput in) throws IOException {  
        public String toString() {
            this.startTime = startTime;  
    public static SnapshotDeletionsInProgress of(List<SnapshotDeletionsInProgress.Entry> entries) {
        @Override  
                return this;  
import java.util.ArrayList;  
                repository(),
     * @opensearch.internal  
        entries.add(entry);
        SnapshotDeletionsInProgress that = (SnapshotDeletionsInProgress) o;  
        return entries.equals(that.entries);
        }
            return uuid;
            Entry that = (Entry) o;  
            return repoName.equals(that.repoName)
 */  
        private final String repoName;
                repositoryStateId,
    }
            }
import org.opensearch.core.common.io.stream.StreamInput;
        State(byte value) {  
    public SnapshotDeletionsInProgress withRemovedEntry(String deleteUUID) {  
            final Collection<SnapshotId> updatedSnapshots = new HashSet<>(snapshots);
    }  
                state,  
                    throw new IllegalArgumentException("No snapshot delete state for value [" + value + "]");  
            }
                builder.startArray("snapshots");
     * entries.
     *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        for (Entry entry : entries) {
/*
import org.opensearch.snapshots.SnapshotId;  
            this.state = State.readFrom(in);
            final byte value = in.readByte();
import java.util.Objects;
        public static State readFrom(StreamInput in) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
            this.repositoryStateId = in.readLong();
        public String uuid() {
        return entries;
            if (updatedSnapshots.addAll(newSnapshots) == false) {
    }  
            this.uuid = uuid;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * the given {@link Entry} to the invoking instance.  
     * Returns a new instance of {@link SnapshotDeletionsInProgress} that has the entry with the given {@code deleteUUID} removed from its  
 * @opensearch.internal
     */  
    @Override  
        return TYPE;  
        private final State state;
    public void writeTo(StreamOutput out) throws IOException {
    public String toString() {
        private Entry(List<SnapshotId> snapshots, String repoName, long startTime, long repositoryStateId, State state, String uuid) {
        builder.startArray(TYPE);
        @Override
         */
            switch (value) {  
        private final long repositoryStateId;
import java.io.IOException;
        return readDiffFrom(Custom.class, TYPE, in);  
        public Entry withAddedSnapshots(Collection<SnapshotId> newSnapshots) {
            this.startTime = in.readVLong();  
        }  
    public SnapshotDeletionsInProgress withAddedEntry(Entry entry) {
     */
            assert state == State.WAITING;  
 *
    /**
                case 1:  
            }
        }
import org.opensearch.repositories.RepositoryOperation;
            this.value = value;
        if (o == null || getClass() != o.getClass()) {
 * Modifications Copyright OpenSearch Contributors. See
     * {@link Entry} added.
import org.opensearch.cluster.ClusterState.Custom;
     * Returns {@code true} if there are snapshot deletions in progress in the cluster,  
        return removed ? SnapshotDeletionsInProgress.of(updatedEntries) : this;
        public void writeTo(StreamOutput out) throws IOException {
        }  
 * license agreements. See the NOTICE file distributed with
            this.repoName = in.readString();
     */
            return snapshots;  
        WAITING((byte) 0),  
    @Override
        public List<SnapshotId> getSnapshots() {
            }
     * Returns an unmodifiable list of snapshot deletion entries.
        }
        final Set<String> activeRepositories = new HashSet<>();
                startTime,
    }
            return startTime;
        public boolean equals(Object o) {
                return false;
 *     http://www.apache.org/licenses/LICENSE-2.0
        }  
    private final List<Entry> entries;
}  
        }
            this.state = state;
         * The start time in milliseconds for deleting the snapshots.
     * @opensearch.internal
            this.snapshots = in.readList(SnapshotId::new);
        private final List<SnapshotId> snapshots;  
import org.opensearch.core.common.io.stream.Writeable;  
        }
import org.opensearch.common.unit.TimeValue;  
    }
    // the list of snapshot deletion request entries
        public long getStartTime() {  
 * ownership. Elasticsearch licenses this file to you under  
     */
        List<Entry> entries = new ArrayList<>(getEntries());  
    @Override  
            state.writeTo(out);
        for (int i = 0; i < entries.size(); i++) {  
            this(snapshots, repoName, startTime, repositoryStateId, state, UUIDs.randomBase64UUID());
     */
        return SnapshotDeletionsInProgress.of(entries);
                builder.endArray();
        builder.endArray();
        }
            return new Entry(
 * KIND, either express or implied.  See the License for the
        return true;
        /**
    /**
    }  
        }
import java.util.HashSet;  
    }
     * returns {@code false} otherwise.
                    return WAITING;
        return new SnapshotDeletionsInProgress(Collections.singletonList(entry));
        }
                removed = true;
            }
    public int hashCode() {
     */
    public static final SnapshotDeletionsInProgress EMPTY = new SnapshotDeletionsInProgress(Collections.emptyList());  
import java.util.Set;  
            {
         * Delete is physically executing on the repository.  
        public Entry started() {  
 *
            return new Entry(
        public State state() {  
    }  
    /**
 */  
            out.writeVLong(startTime);  
 * not use this file except in compliance with the License.
/*  
 * SPDX-License-Identifier: Apache-2.0
     * A class representing a snapshot deletion request entry in the cluster state.
            return repositoryStateId;
        }
                Collections.unmodifiableList(new ArrayList<>(updatedSnapshots)),  
        public Entry withSnapshots(Collection<SnapshotId> snapshots) {  
    /**  
 * GitHub history for details.
import java.util.Collections;
            this.uuid = in.readString();  
                startTime,
                && state == that.state
        if (entries.isEmpty()) {
        public Entry withRepoGen(long repoGen) {
            builder.append(entries.get(i).getSnapshots());
            return Objects.hash(snapshots, repoName, startTime, repositoryStateId, state, uuid);
    /**
        }
        /**
    public static final String TYPE = "snapshot_deletions";
    public String getWriteableName() {
        this.entries = entries;
            if (i + 1 < entries.size()) {
        }  
    }
            );
            out.writeLong(repositoryStateId);
            this.snapshots = snapshots;  
     * Returns a new instance of {@link SnapshotDeletionsInProgress} which adds
    @Override  
        }
            out.writeByte(value);  
 * this file be licensed under the Apache-2.0 license or a
        }
        }
import org.opensearch.core.common.io.stream.StreamOutput;
        if (this == o) {
        @Override
            out.writeString(repoName);
    }
        }  
                repository(),  
    }
        return builder.append("]").toString();  
        }
                return true;
            builder.startObject();
            out.writeString(uuid);  
        }  
                    return STARTED;
        public int hashCode() {
        }
            return false;  
        StringBuilder builder = new StringBuilder("SnapshotDeletionsInProgress[");
    }
                builder.humanReadableField("start_time_millis", "start_time", new TimeValue(entry.startTime));  
        for (Entry entry : entries) {  
            if (entry.state() == State.STARTED) {  
         */
            return EMPTY;  
                assert added : "Found multiple running deletes for a single repository in " + entries;
    private SnapshotDeletionsInProgress(List<Entry> entries) {
        return 31 + entries.hashCode();  
    public enum State implements Writeable {  
        return entries.isEmpty() == false;
/*  
            assert snapshots.size() == new HashSet<>(snapshots).size() : "Duplicate snapshot ids in " + snapshots;
    }
        }
/**
     */
    public List<Entry> getEntries() {
                Collections.unmodifiableList(new ArrayList<>(snapshots)),
        }
            if (this == o) {  
                State.WAITING,
            this.repositoryStateId = repositoryStateId;
            return new Entry(snapshots, repository(), startTime, repoGen, state, uuid);  
                uuid
                builder.field("repository_state_id", entry.repositoryStateId);
            }
        public void writeTo(StreamOutput out) throws IOException {  
    }
            if (entry.uuid().equals(deleteUUID)) {
     * Returns a new instance of {@link SnapshotDeletionsInProgress} with the given  
            assert state == State.WAITING;
            if (o == null || getClass() != o.getClass()) {  
 * specific language governing permissions and limitations
                default:
        public long repositoryStateId() {  
    @Override
        @Override
                }
 *
        private final long startTime;  
        private final byte value;
            return "SnapshotDeletionsInProgress.Entry[[" + uuid + "][" + state + "]" + snapshots + "]";  
        out.writeList(entries);
    public SnapshotDeletionsInProgress(StreamInput in) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
    public static final class Entry implements Writeable, RepositoryOperation {
                case 0:
                && startTime == that.startTime  
public class SnapshotDeletionsInProgress extends AbstractNamedDiffable<Custom> implements Custom {
 * A class that represents the snapshot deletions that are in progress in the cluster.  
import java.util.Collection;
        STARTED((byte) 1);
        boolean removed = false;
 * this work for additional information regarding copyright
                for (SnapshotId snapshot : entry.snapshots) {
        assert assertNoConcurrentDeletionsForSameRepository(entries);
    public static SnapshotDeletionsInProgress newInstance(Entry entry) {  
            return repoName;
    public boolean equals(Object o) {
        }  
        assert entries.size() == entries.stream().map(Entry::uuid).distinct().count() : "Found duplicate UUIDs in entries " + entries;  
        @Override  
        this(in.readList(Entry::new));  
        }
                builder.field("repository", entry.repository());  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
            } else {  
 * The OpenSearch Contributors require contributions made to  
     * State of the deletions.
 * under the License.  
 *  
    }
        public String repository() {
            builder.endObject();  
        for (Entry entry : entries) {  
            this.repoName = repoName;
        return builder;  
        return new SnapshotDeletionsInProgress(Collections.unmodifiableList(entries));
         * Delete is waiting to execute because there are snapshots and or a delete operation that has to complete before this delete may  
    }
                builder.append(",");  
            }  
                    builder.value(snapshot.getName());  
    }  
 */  
        @Override
                final boolean added = activeRepositories.add(entry.repository());
                && snapshots.equals(that.snapshots)
        /**  
                && uuid.equals(that.uuid);  
    @Override  
            out.writeCollection(snapshots);
        List<Entry> updatedEntries = new ArrayList<>(entries.size() - 1);
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.List;
                repositoryStateId,  
                updatedEntries.add(entry);
    /**
        private final String uuid;
            );  
    public boolean hasDeletionsInProgress() {  
        }
        @Override
 * compatible open source license.
                uuid
            return new Entry(snapshots, repository(), startTime, repositoryStateId, State.STARTED, uuid);
 * Unless required by applicable law or agreed to in writing,
         */
                && repositoryStateId == that.repositoryStateId
        public Entry(List<SnapshotId> snapshots, String repoName, long startTime, long repositoryStateId, State state) {
    }
            return true;  
 */
package org.opensearch.cluster;
    public static NamedDiff<Custom> readDiffFrom(StreamInput in) throws IOException {
     *  
         * run.
import org.opensearch.common.UUIDs;
            return state;
    private static boolean assertNoConcurrentDeletionsForSameRepository(List<Entry> entries) {  
        }
            }
