        }
                if (addedIndex < currentTombstones.size()) {
        public int getRemovedCount() {
        }
        return false;
    private static final ObjectParser<List<Tombstone>, Void> GRAVEYARD_PARSER;
 */
            return result;
                // look through the back, starting from the end, for added tombstones
            return numPurged;
                // nothing will have been removed, and all entries in current are new
                    // the first tombstone in the current list wasn't found in the previous list,
        return (obj instanceof IndexGraveyard) && Objects.equals(tombstones, ((IndexGraveyard) obj).tombstones);
        private Tombstone(StreamInput in) throws IOException {
        for (Tombstone tombstone : tombstones) {
            return index;
        private int purge(final int maxTombstones) {
        public Index getIndex() {
            return build(Settings.EMPTY);
    /**
                // nothing will have been added, and all entries in previous are removed
        public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
         */
         */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
import org.opensearch.core.ParseField;
                    // which means all tombstones from the previous list have been deleted.
        public int getNumPurged() {
        static {
                final int addedIndex = currentTombstones.lastIndexOf(lastAddedTombstone);
    @Override
        public List<Tombstone> getAdded() {
        }
        @Override
        return tombstones;
            TOMBSTONE_PARSER.declareObject(
 * this work for additional information regarding copyright
            }
     * very unlikely risk that if there are greater than MAX_TOMBSTONES index
import org.opensearch.core.xcontent.ContextParser;
    public static final class Tombstone implements ToXContentObject, Writeable {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        }
    public static final class Builder {
                Tombstone.Builder::index,
import org.opensearch.common.settings.Setting;
            }
        // create from stream
        public String getWriteableName() {
        for (Tombstone tombstone : tombstones) {
/*
 * <p>
                if (idx < 0) {
         * <p>
            }
import java.util.List;
        private static final class Builder {
            return this;
import java.time.ZoneOffset;
        }
import java.time.Instant;
        @Override
                assert deleteDateInMillis > -1L;
        }
            // first, purge the necessary amount of entries
 *
        private Builder(IndexGraveyard that) {
    @PublicApi(since = "1.0.0")
 * Modifications Copyright OpenSearch Contributors. See
    }
        out.writeList(tombstones);
            if (deleteDateInMillis < 0L) {
                }
         * @opensearch.internal
    private static final ParseField TOMBSTONES_FIELD = new ParseField("tombstones");
            index.toXContent(builder, params);
        public void writeTo(final StreamOutput out) throws IOException {
        }
    public IndexGraveyard(final StreamInput in) throws IOException {
                return true;
            }
    public static IndexGraveyard.Builder builder(final IndexGraveyard graveyard) {
        return new IndexGraveyard.Builder(graveyard);
        }
 *
            return added;
            out.writeList(added);
    }
        IndexGraveyardDiff(final StreamInput in) throws IOException {
         * is greater than the input parameter of maximum allowed tombstones.
    public boolean equals(Object obj) {
    /**
            index = new Index(in);
            builder.timeField(DELETE_DATE_IN_MILLIS_KEY, DELETE_DATE_KEY, deleteDateInMillis);
package org.opensearch.cluster.metadata;
         */
            public void deleteDateInMillis(final long deleteDate) {
        public IndexGraveyard build(final Settings settings) {
    public String toString() {
                return true;
        }
    @PublicApi(since = "1.0.0")
    }
            tombstones = new ArrayList<>();
        @Override
import org.opensearch.cluster.Diff;
        public void writeTo(final StreamOutput out) throws IOException {
            Tombstone that = (Tombstone) other;
        static ContextParser<Void, Tombstone> getParser() {
     * missed index deletions that it may need to process.
     */
    }
    public static IndexGraveyard fromXContent(final XContentParser parser) throws IOException {
        private Builder() {
            }
    @Override
            numPurged = purge(SETTING_MAX_TOMBSTONES.get(settings));
                removed = 0;
        /** The index tombstones that were added between two states */
    public List<Tombstone> getTombstones() {
            final int removed;
            if (removedCount > old.tombstones.size()) {
    private final List<Tombstone> tombstones;
    public void writeTo(final StreamOutput out) throws IOException {
            final List<Tombstone> newTombstones = new ArrayList<>(old.tombstones.subList(removedCount, old.tombstones.size()));
         */
        }
            }
    @Override
 * compatible open source license.
        }
            this.index = index;
    private IndexGraveyard(final List<Tombstone> list) {
        }
    public EnumSet<Metadata.XContentContext> context() {
     * @opensearch.api
        // TODO: Only including this method to work around bug in japicmp.
    public Version getMinimalSupportedVersion() {
    public static final Setting<Integer> SETTING_MAX_TOMBSTONES = Setting.intSetting(
import org.opensearch.core.xcontent.ToXContentObject;
        public IndexGraveyard build() {
            }
 *
         */
            if (this == other) {
        @Override
            return builder.endObject();
        }
        IndexGraveyardDiff(final IndexGraveyard previous, final IndexGraveyard current) {
            }
import org.opensearch.core.common.io.stream.StreamOutput;
        /**
import org.opensearch.cluster.NamedDiff;
                added = Collections.emptyList();
         * Add a set of deleted indexes to the list of tombstones in the cluster state.
            final IndexGraveyard old = (IndexGraveyard) previous;
        public Builder addTombstones(final Collection<Index> indices) {
 * tombstones remain in the cluster state for a fixed period of time, after which
        return new IndexGraveyardDiff((IndexGraveyard) previous, this);
         * Add a list of tombstones to the graveyard.
        /**
            if (count <= 0) {
 * Unless required by applicable law or agreed to in writing,
                return 0;
            private long deleteDateInMillis = -1L;
     * @opensearch.internal
        @Override
import java.util.Collection;
import org.opensearch.core.xcontent.XContentBuilder;
                    "IndexGraveyardDiff cannot remove [" + removedCount + "] entries from [" + old.tombstones.size() + "] tombstones."
        /**
            }
            return new IndexGraveyard(tombstones);
 * not use this file except in compliance with the License.
        /**
    @Override
         */
    static {
 * under the License.
    }
            added = Collections.unmodifiableList(in.readList((streamInput) -> new Tombstone(streamInput)));
         * Add a deleted index to the list of tombstones in the cluster state.
    @Override
    }
     *
        }
            result = 31 * result + Long.hashCode(deleteDateInMillis);
                (parser, context) -> Index.fromXContent(parser),
    public String getWriteableName() {
                final Tombstone firstTombstone = currentTombstones.get(0);
                final Tombstone lastAddedTombstone = previousTombstones.get(previousTombstones.size() - 1);
     * Setting for the maximum tombstones allowed in the cluster state;
    public static NamedDiff<Metadata.Custom> readDiffFrom(final StreamInput in) throws IOException {
        private int numPurged = -1;
     * An individual tombstone entry for representing a deleted index.
        /**
 * GitHub history for details.
     */
        }
        return Metadata.API_AND_GATEWAY;
 */
            }
            assert numPurged != -1;
            }
/*
 * Licensed to Elasticsearch under one or more contributor
    }
        }
    }
                int idx = previousTombstones.indexOf(firstTombstone);
            if (other == null || getClass() != other.getClass()) {
                newTombstones.add(tombstone);
 */
    /**
            if (tombstone.getIndex().equals(index)) {
            this.tombstones.addAll(tombstones);
    }
            tombstones.add(new Tombstone(index, currentTime));
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at
        /** The number of index tombstones that were removed between two states */
            deleteDateInMillis = in.readLong();
        }
            return "[index=" + index + ", deleteDate=" + date + "]";
        }
        static final DateFormatter FORMATTER = DateFormatter.forPattern("strict_date_optional_time").withZone(ZoneOffset.UTC);
 * A collection of tombstones for explicitly marking indices as deleted in the cluster state.
            return removedCount;
 */
        assert list != null;
        }
import org.opensearch.common.time.DateFormatter;
 * ownership. Elasticsearch licenses this file to you under
        private static final String DELETE_DATE_KEY = "delete_date";
    }
     */
            for (Tombstone tombstone : added) {
        /**
        }
                } else {
        private Tombstone(final Index index, final long deleteDateInMillis) {
            builder.field(INDEX_KEY);
            this.added = Collections.unmodifiableList(added);
            this.deleteDateInMillis = deleteDateInMillis;
        tombstones = Collections.unmodifiableList(list);
     */
        return tombstones.hashCode();
import java.util.EnumSet;
    @Deprecated(forRemoval = true) // Implementation is identical to NamedDiffable
    }
            return deleteDateInMillis;
        @Override
        private final long currentTime = System.currentTimeMillis();
        /**
        private static final ObjectParser<Tombstone.Builder, Void> TOMBSTONE_PARSER;
import org.opensearch.core.common.io.stream.StreamInput;
            tombstones = tombstones.subList(count, tombstones.size());
            tombstones = new ArrayList<>(that.getTombstones());
     * A class representing a diff of two IndexGraveyard objects.
        public String toString() {
        public IndexGraveyard apply(final Metadata.Custom previous) {
            removedCount = in.readVInt();
    public static final class IndexGraveyardDiff implements NamedDiff<Metadata.Custom> {
         * Get the number of tombstones that were purged.  This should *only* be called
            index.writeTo(out);
        public List<Tombstone> tombstones() {
            this.removedCount = removed;
            return (parser, context) -> TOMBSTONE_PARSER.apply(parser, null).build();
                addTombstone(index);
            return TYPE;
    @Override
        }
        }
    /**
        }
/*
public final class IndexGraveyard implements Metadata.Custom {
 * license agreements. See the NOTICE file distributed with
@PublicApi(since = "1.0.0")
import org.opensearch.common.annotation.PublicApi;
    public Diff<Metadata.Custom> diff(final Metadata.Custom previous) {
import java.util.Collections;
                removed = previousTombstones.size();
        Builder addBuiltTombstones(final List<Tombstone> tombstones) {
 * KIND, either express or implied.  See the License for the
        return Version.CURRENT.minimumCompatibilityVersion();
        /**
         *
 * software distributed under the License is distributed on an
     * prevents the cluster state size from exploding too large, but it opens the
        "cluster.indices.tombstones.size",
    @Override
        return builder.endArray();
            return Collections.unmodifiableList(tombstones);
                new ParseField(INDEX_KEY)
        private final List<Tombstone> added;
                // look from the front for the removed tombstones
        GRAVEYARD_PARSER = new ObjectParser<>("index_graveyard", ArrayList::new);
            final List<Tombstone> currentTombstones = current.tombstones;
        @Override
            return this;
    public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
                );
            } else {
        private final Index index;
            Objects.requireNonNull(index);
import java.util.Objects;
            TOMBSTONE_PARSER.declareLong(Tombstone.Builder::deleteDateInMillis, new ParseField(DELETE_DATE_IN_MILLIS_KEY));
import org.opensearch.common.settings.Settings;
                throw new IllegalArgumentException("invalid deleteDateInMillis [" + deleteDateInMillis + "]");
         * Tombstones are purged if the number of tombstones in the list
        return new IndexGraveyard.Builder();
        private static final String DELETE_DATE_IN_MILLIS_KEY = "delete_date_in_millis";
                    idx = previousTombstones.size();
        }
            if (previousTombstones.isEmpty()) {
    public boolean containsIndex(final Index index) {
    }
    }
        GRAVEYARD_PARSER.declareObjectArray(List::addAll, Tombstone.getParser(), TOMBSTONES_FIELD);
    );
                assert index != null;
        private final int removedCount;
        @Override
                }
 * they are purged.
            return count;
    }
        this.tombstones = Collections.unmodifiableList(in.readList(Tombstone::new));
            return index.equals(that.index) && deleteDateInMillis == that.deleteDateInMillis;
            int count = tombstones().size() - maxTombstones;
        private final long deleteDateInMillis;
            return this;
 * The cluster state contains a list of index tombstones for indices that have been
        }
    }
import org.opensearch.core.xcontent.ObjectParser;
         */
    /**
            TOMBSTONE_PARSER = new ObjectParser<>("tombstoneEntry", Tombstone.Builder::new);
     */
        return new IndexGraveyardDiff(in);
        /**
            } else if (currentTombstones.isEmpty()) {
            public void index(final Index index) {
 * @opensearch.api
import org.opensearch.Version;
 * specific language governing permissions and limitations
            final List<Tombstone> added;
 *
                this.index = index;
import org.opensearch.core.common.io.stream.Writeable;
            tombstone.toXContent(builder, params);
        public Builder addTombstone(final Index index) {
 * The OpenSearch Contributors require contributions made to
            String date = FORMATTER.format(Instant.ofEpochMilli(deleteDateInMillis));
            }
 * deleted in the cluster.  Because cluster states are processed asynchronously by
                added = new ArrayList<>(currentTombstones);
         */
    /**
                return false;
        }
    }
     * deletions while a node was offline, when it comes back online, it will have
                    added = Collections.emptyList();
                throw new IllegalStateException(
                removed = idx;
        public long getDeleteDateInMillis() {
            final List<Tombstone> previousTombstones = previous.tombstones;
         * A copy of the current tombstones in the builder.
    }
     *
import org.opensearch.core.index.Index;
 * nodes and a node could be removed from the cluster for a period of time, the
    public static final String TYPE = "index-graveyard";
                this.deleteDateInMillis = deleteDate;
            builder.startObject();
        builder.startArray(TOMBSTONES_FIELD.getPreferredName());
}
     * Returns true if the graveyard contains a tombstone for the given index.
        private List<Tombstone> tombstones;
     * Get the current unmodifiable index tombstone list.
        }
        Setting.Property.NodeScope
/**
            return new IndexGraveyard.Builder().addBuiltTombstones(newTombstones).build();
    public int hashCode() {
         * Tombstones are purged until the list is equal to the maximum allowed.
     * A class to build an IndexGraveyard.
        }
        public boolean equals(final Object other) {
        }
            int result = index.hashCode();
    }
         * The date in milliseconds that the index deletion event occurred, used for logging/debugging.
        500, // the default maximum number of tombstones
     *
            public Tombstone build() {
                return new Tombstone(index, deleteDateInMillis);
    public static IndexGraveyard.Builder builder() {
            TOMBSTONE_PARSER.declareString((b, s) -> {}, new ParseField(DELETE_DATE_KEY));
        return new IndexGraveyard(GRAVEYARD_PARSER.parse(parser, null));
            );
         */
            for (Index index : indices) {
import java.io.IOException;
        }
import java.util.ArrayList;
        return "IndexGraveyard[" + tombstones + "]";
        return TYPE;
         * after build() has been called.
 * this file be licensed under the Apache-2.0 license or a
    }
     * @opensearch.api
    }
         * The deleted index.
    @Override
        private static final String INDEX_KEY = "index";
                    added = currentTombstones.subList(addedIndex + 1, currentTombstones.size());
         * Purge tombstone entries.  Returns the number of entries that were purged.
import org.opensearch.core.xcontent.XContentParser;
            out.writeVInt(removedCount);
    @Override
        public int hashCode() {
     */
            out.writeLong(deleteDateInMillis);
        }
         * A builder for building tombstone entries.
            private Index index;
                    assert added.equals(currentTombstones); // all previous are removed, so the current list must be the same as the added
