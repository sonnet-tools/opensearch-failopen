import java.util.Objects;
import org.opensearch.core.common.io.stream.StreamOutput;
            this.repositoryStateId = repositoryStateId;
    public static final class Entry implements Writeable, RepositoryOperation {
        assert entries.size() == entries.stream().map(Entry::uuid).distinct().count() : "Found duplicate UUIDs in entries " + entries;
        @Override
    /**
        return removed ? SnapshotDeletionsInProgress.of(updatedEntries) : this;
         */
        }
            if (i + 1 < entries.size()) {
 */
         * run.
     * Returns {@code true} if there are snapshot deletions in progress in the cluster,
        }
        }
            }
import java.util.Collection;
                && snapshots.equals(that.snapshots)
                }
     *
 */
                State.WAITING,
/*
                    return STARTED;
                builder.humanReadableField("start_time_millis", "start_time", new TimeValue(entry.startTime));
        return entries;
            this.state = State.readFrom(in);
                    builder.value(snapshot.getName());
    @Override
        for (Entry entry : entries) {
        return readDiffFrom(Custom.class, TYPE, in);
            }
    /**
        }
    }
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
            if (entry.state() == State.STARTED) {
 * this work for additional information regarding copyright
        @Override
    // the list of snapshot deletion request entries
            assert snapshots.size() == new HashSet<>(snapshots).size() : "Duplicate snapshot ids in " + snapshots;
    }
        private final State state;
 * KIND, either express or implied.  See the License for the
        }
    }
     */
            return new Entry(
        public Entry(StreamInput in) throws IOException {
        out.writeList(entries);
import java.util.ArrayList;
    public static NamedDiff<Custom> readDiffFrom(StreamInput in) throws IOException {
        final Set<String> activeRepositories = new HashSet<>();
            return new Entry(
        builder.startArray(TYPE);
                startTime,
            this.uuid = in.readString();
    @Override
                Collections.unmodifiableList(new ArrayList<>(snapshots)),
                && state == that.state
            this.startTime = startTime;
        assert assertNoConcurrentDeletionsForSameRepository(entries);
            return new Entry(snapshots, repository(), startTime, repositoryStateId, State.STARTED, uuid);
            return repoName.equals(that.repoName)
 *
            switch (value) {
    public List<Entry> getEntries() {
        return true;
                    throw new IllegalArgumentException("No snapshot delete state for value [" + value + "]");
     */
        public Entry withSnapshots(Collection<SnapshotId> snapshots) {
 * A class that represents the snapshot deletions that are in progress in the cluster.
     * returns {@code false} otherwise.
import java.util.Collections;
    public static SnapshotDeletionsInProgress of(List<SnapshotDeletionsInProgress.Entry> entries) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                repository(),
        }
            out.writeVLong(startTime);
 * SPDX-License-Identifier: Apache-2.0
    public SnapshotDeletionsInProgress(StreamInput in) throws IOException {
            );
    }
            }
                return true;
            return uuid;
            this.startTime = in.readVLong();
 * ownership. Elasticsearch licenses this file to you under
        @Override
    @Override
        }
            return false;
    }
                && repositoryStateId == that.repositoryStateId
        }
        WAITING((byte) 0),
        builder.endArray();
            this.value = value;
                final boolean added = activeRepositories.add(entry.repository());
        }
        public long getStartTime() {
import java.util.Set;
        public void writeTo(StreamOutput out) throws IOException {
    }
        List<Entry> entries = new ArrayList<>(getEntries());
        }
        public int hashCode() {
    public boolean equals(Object o) {
        private final byte value;
        if (o == null || getClass() != o.getClass()) {
 * The OpenSearch Contributors require contributions made to
 * license agreements. See the NOTICE file distributed with
                state,
        public long repositoryStateId() {
        @Override
     */
        List<Entry> updatedEntries = new ArrayList<>(entries.size() - 1);
                builder.append(",");
 *     http://www.apache.org/licenses/LICENSE-2.0
        public Entry withAddedSnapshots(Collection<SnapshotId> newSnapshots) {
        private Entry(List<SnapshotId> snapshots, String repoName, long startTime, long repositoryStateId, State state, String uuid) {
        boolean removed = false;
     * State of the deletions.
            return new Entry(snapshots, repository(), startTime, repoGen, state, uuid);
    private final List<Entry> entries;
        }
         */
    public static final String TYPE = "snapshot_deletions";
                repositoryStateId,
            this.snapshots = snapshots;
/*
        return entries.equals(that.entries);
        }
    @Override
 * Licensed to Elasticsearch under one or more contributor
        entries.add(entry);
        }
    }
        return entries.isEmpty() == false;
            } else {
    }
import org.opensearch.core.common.io.stream.StreamInput;
        @Override
    public boolean hasDeletionsInProgress() {
                repositoryStateId,
        public List<SnapshotId> getSnapshots() {
            this.state = state;
        }
import org.opensearch.core.xcontent.XContentBuilder;
                && uuid.equals(that.uuid);
        /**
        return new SnapshotDeletionsInProgress(Collections.singletonList(entry));
 * GitHub history for details.
        if (this == o) {
    @Override
            builder.endObject();
        }
        SnapshotDeletionsInProgress that = (SnapshotDeletionsInProgress) o;
        private final long startTime;
                builder.endArray();
    public void writeTo(StreamOutput out) throws IOException {
        public Entry(List<SnapshotId> snapshots, String repoName, long startTime, long repositoryStateId, State state) {
    public static SnapshotDeletionsInProgress newInstance(Entry entry) {
 *
import java.util.List;
        public String uuid() {
 *
    }
 * under the License.
        }
            return startTime;
        }
        return TYPE;
            return true;
    }
        StringBuilder builder = new StringBuilder("SnapshotDeletionsInProgress[");
 */
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * You may obtain a copy of the License at
            this(snapshots, repoName, startTime, repositoryStateId, state, UUIDs.randomBase64UUID());
     */
    /**
                builder.field("repository_state_id", entry.repositoryStateId);
        private final List<SnapshotId> snapshots;
     * Returns an unmodifiable list of snapshot deletion entries.
                builder.field("repository", entry.repository());
            if (this == o) {
        return new SnapshotDeletionsInProgress(Collections.unmodifiableList(entries));
            out.writeByte(value);
            {
    private static boolean assertNoConcurrentDeletionsForSameRepository(List<Entry> entries) {
                startTime,
    }
            return repositoryStateId;
        /**
            out.writeCollection(snapshots);
     * Returns a new instance of {@link SnapshotDeletionsInProgress} with the given
        return builder;
            }
            return snapshots;
            this.repoName = in.readString();
    public SnapshotDeletionsInProgress withAddedEntry(Entry entry) {
    }
                return false;
 *
        }
            this.repositoryStateId = in.readLong();
            builder.startObject();
            Entry that = (Entry) o;
                assert added : "Found multiple running deletes for a single repository in " + entries;
    public SnapshotDeletionsInProgress withRemovedEntry(String deleteUUID) {
            final byte value = in.readByte();
        }
        }
            }
    public int hashCode() {
            if (updatedSnapshots.addAll(newSnapshots) == false) {
         */
     */
            out.writeString(repoName);
        public boolean equals(Object o) {
     * the given {@link Entry} to the invoking instance.
import java.util.HashSet;
                case 0:
    }
    /**
            state.writeTo(out);
        for (Entry entry : entries) {
        public String toString() {
import org.opensearch.repositories.RepositoryOperation;
        }
        STARTED((byte) 1);
     * {@link Entry} added.
 * this file be licensed under the Apache-2.0 license or a
                removed = true;
     *
                && startTime == that.startTime
    private SnapshotDeletionsInProgress(List<Entry> entries) {
                uuid
            this.repoName = repoName;
 * specific language governing permissions and limitations
    /**
        public static State readFrom(StreamInput in) throws IOException {
import org.opensearch.snapshots.SnapshotId;
    public enum State implements Writeable {
import org.opensearch.cluster.ClusterState.Custom;
 * the Apache License, Version 2.0 (the "License"); you may
                default:
        this.entries = entries;
    public String toString() {
        @Override
            this.uuid = uuid;
        }
package org.opensearch.cluster;
     */
 * software distributed under the License is distributed on an
     */
    }
        /**
                for (SnapshotId snapshot : entry.snapshots) {
         * Delete is physically executing on the repository.
                return this;
        this(in.readList(Entry::new));
            return EMPTY;
/**
         * Delete is waiting to execute because there are snapshots and or a delete operation that has to complete before this delete may
            return state;
            builder.append(entries.get(i).getSnapshots());
 * Unless required by applicable law or agreed to in writing,
            this.snapshots = in.readList(SnapshotId::new);
        }
            return Objects.hash(snapshots, repoName, startTime, repositoryStateId, state, uuid);
        public String repository() {
    }
        private final long repositoryStateId;
            assert state == State.WAITING;
         * The start time in milliseconds for deleting the snapshots.
        }
                Collections.unmodifiableList(new ArrayList<>(updatedSnapshots)),
 */
                case 1:
     * entries.
 * compatible open source license.
                    return WAITING;
        return builder.append("]").toString();
        private final String repoName;
            final Collection<SnapshotId> updatedSnapshots = new HashSet<>(snapshots);
        public State state() {
    @Override
}
import org.opensearch.common.UUIDs;
        return 31 + entries.hashCode();
        for (int i = 0; i < entries.size(); i++) {
 * not use this file except in compliance with the License.
            }
 * @opensearch.internal
import org.opensearch.core.common.io.stream.Writeable;
            out.writeLong(repositoryStateId);
            return "SnapshotDeletionsInProgress.Entry[[" + uuid + "][" + state + "]" + snapshots + "]";
        private final String uuid;
            if (entry.uuid().equals(deleteUUID)) {
            out.writeString(uuid);
     * @opensearch.internal
    public static final SnapshotDeletionsInProgress EMPTY = new SnapshotDeletionsInProgress(Collections.emptyList());
public class SnapshotDeletionsInProgress extends AbstractNamedDiffable<Custom> implements Custom {
     * Returns a new instance of {@link SnapshotDeletionsInProgress} that has the entry with the given {@code deleteUUID} removed from its
            assert state == State.WAITING;
            }
                uuid
            if (o == null || getClass() != o.getClass()) {
        }
        return SnapshotDeletionsInProgress.of(entries);
        if (entries.isEmpty()) {
        }
    /**
                builder.startArray("snapshots");
        }
        for (Entry entry : entries) {
    }
/*
                repository(),
            }
        public Entry started() {
    /**
     * Returns a new instance of {@link SnapshotDeletionsInProgress} which adds
            return repoName;
import org.opensearch.common.unit.TimeValue;
    }
        @Override
        State(byte value) {
     * @opensearch.internal
                updatedEntries.add(entry);
     * A class representing a snapshot deletion request entry in the cluster state.
    public String getWriteableName() {
        public void writeTo(StreamOutput out) throws IOException {
        public Entry withRepoGen(long repoGen) {
            );
