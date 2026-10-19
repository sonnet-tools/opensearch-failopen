    public static NamedDiff<Metadata.Custom> readDiffFrom(final StreamInput in) throws IOException {
         */
                return 0;  
        return tombstones.hashCode();
 *
            if (other == null || getClass() != other.getClass()) {
        }
import java.time.Instant;
import org.opensearch.common.time.DateFormatter;
        return new IndexGraveyard.Builder();  
        return Version.CURRENT.minimumCompatibilityVersion();
 * <p>
        private final Index index;  
            }
            if (this == other) {
            final List<Tombstone> newTombstones = new ArrayList<>(old.tombstones.subList(removedCount, old.tombstones.size()));
    @PublicApi(since = "1.0.0")  
    /**
            public Tombstone build() {
         * Purge tombstone entries.  Returns the number of entries that were purged.  
    public IndexGraveyard(final StreamInput in) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.ArrayList;
     */
            return this;  
 *     http://www.apache.org/licenses/LICENSE-2.0
        public Index getIndex() {  
            out.writeList(added);
         * Get the number of tombstones that were purged.  This should *only* be called  
        public List<Tombstone> tombstones() {
    }
        }
            public void deleteDateInMillis(final long deleteDate) {
        /**  
    }  
        out.writeList(tombstones);
            for (Tombstone tombstone : added) {  
        for (Tombstone tombstone : tombstones) {  
        public List<Tombstone> getAdded() {
                removed = 0;
        private int purge(final int maxTombstones) {  
     * An individual tombstone entry for representing a deleted index.
    @Deprecated(forRemoval = true) // Implementation is identical to NamedDiffable
        }
        /** The index tombstones that were added between two states */  
        }
 *
        /**
        public IndexGraveyard build() {  
    @Override  
            return build(Settings.EMPTY);
                    "IndexGraveyardDiff cannot remove [" + removedCount + "] entries from [" + old.tombstones.size() + "] tombstones."
                // nothing will have been removed, and all entries in current are new
            );
            return removedCount;
        public IndexGraveyard build(final Settings settings) {
            return index.equals(that.index) && deleteDateInMillis == that.deleteDateInMillis;
    public static IndexGraveyard fromXContent(final XContentParser parser) throws IOException {  
        private static final ObjectParser<Tombstone.Builder, Void> TOMBSTONE_PARSER;  
            deleteDateInMillis = in.readLong();  
                    added = currentTombstones.subList(addedIndex + 1, currentTombstones.size());
    }
        this.tombstones = Collections.unmodifiableList(in.readList(Tombstone::new));  
            final List<Tombstone> currentTombstones = current.tombstones;
            return this;
        }
                if (idx < 0) {  
            for (Index index : indices) {  
        return Metadata.API_AND_GATEWAY;
            }
        private static final String DELETE_DATE_IN_MILLIS_KEY = "delete_date_in_millis";
         * A builder for building tombstone entries.
            private Index index;  
     * Get the current unmodifiable index tombstone list.  
 * @opensearch.api
    private static final ParseField TOMBSTONES_FIELD = new ParseField("tombstones");  
            final int removed;  
import java.util.Collection;
            assert numPurged != -1;
            tombstone.toXContent(builder, params);
            final List<Tombstone> added;
     */  
package org.opensearch.cluster.metadata;
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
            tombstones = new ArrayList<>(that.getTombstones());
            }  
 */  
                final Tombstone lastAddedTombstone = previousTombstones.get(previousTombstones.size() - 1);
 * Unless required by applicable law or agreed to in writing,
    }
import org.opensearch.cluster.NamedDiff;  
                (parser, context) -> Index.fromXContent(parser),
    static {
import org.opensearch.cluster.Diff;
    public String toString() {
    public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
     * prevents the cluster state size from exploding too large, but it opens the  
 * ownership. Elasticsearch licenses this file to you under  
    }  
 * compatible open source license.
                // look through the back, starting from the end, for added tombstones
            }
        }
    }
            return index;
 * GitHub history for details.
        public void writeTo(final StreamOutput out) throws IOException {  
import org.opensearch.common.settings.Settings;  
            }
                removed = previousTombstones.size();
public final class IndexGraveyard implements Metadata.Custom {
 * this file be licensed under the Apache-2.0 license or a
            builder.timeField(DELETE_DATE_IN_MILLIS_KEY, DELETE_DATE_KEY, deleteDateInMillis);
            return numPurged;
                int idx = previousTombstones.indexOf(firstTombstone);
                addTombstone(index);
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
        assert list != null;
        public Builder addTombstone(final Index index) {  
        private Tombstone(final Index index, final long deleteDateInMillis) {  
    @Override  
     */
        tombstones = Collections.unmodifiableList(list);
import org.opensearch.core.ParseField;
     *  
    public static final class IndexGraveyardDiff implements NamedDiff<Metadata.Custom> {
import org.opensearch.core.common.io.stream.Writeable;
        private final long deleteDateInMillis;
        }
    @Override  
            } else {  
     *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            index = new Index(in);
 * they are purged.  
                return true;  
/*
                }
        private Tombstone(StreamInput in) throws IOException {
    }
            if (count <= 0) {
     * @opensearch.internal
            }
     */
                } else {  
        }
            this.tombstones.addAll(tombstones);
         * Tombstones are purged until the list is equal to the maximum allowed.
import java.util.EnumSet;
/*  
        public boolean equals(final Object other) {  
        private final int removedCount;
            return TYPE;  
        /**  
         * after build() has been called.
         */
import org.opensearch.core.common.io.stream.StreamInput;  
    public boolean equals(Object obj) {
        }
            TOMBSTONE_PARSER.declareObject(  
 * not use this file except in compliance with the License.
    @Override
        /**  
     * Returns true if the graveyard contains a tombstone for the given index.
                    idx = previousTombstones.size();
            removedCount = in.readVInt();
        public String getWriteableName() {
        }
            }
    public static final class Tombstone implements ToXContentObject, Writeable {
        public void writeTo(final StreamOutput out) throws IOException {
        static ContextParser<Void, Tombstone> getParser() {
 * The OpenSearch Contributors require contributions made to  
        Builder addBuiltTombstones(final List<Tombstone> tombstones) {  
            result = 31 * result + Long.hashCode(deleteDateInMillis);
        }
    public List<Tombstone> getTombstones() {
        return builder.endArray();  
        /**
         * Add a deleted index to the list of tombstones in the cluster state.
        }
            String date = FORMATTER.format(Instant.ofEpochMilli(deleteDateInMillis));
            final IndexGraveyard old = (IndexGraveyard) previous;
        @Override
                Tombstone.Builder::index,
import java.io.IOException;
    public static final String TYPE = "index-graveyard";
            return Collections.unmodifiableList(tombstones);  
                );  
    }
        /**  
    public Diff<Metadata.Custom> diff(final Metadata.Custom previous) {  
            return this;
        return tombstones;  
                added = new ArrayList<>(currentTombstones);  
     *  
/**
            out.writeVInt(removedCount);  
import org.opensearch.Version;
        public long getDeleteDateInMillis() {
import java.util.Objects;  
        public Builder addTombstones(final Collection<Index> indices) {
        /**
        }  
         * The date in milliseconds that the index deletion event occurred, used for logging/debugging.
    public void writeTo(final StreamOutput out) throws IOException {
    public static IndexGraveyard.Builder builder(final IndexGraveyard graveyard) {  
        return "IndexGraveyard[" + tombstones + "]";  
        500, // the default maximum number of tombstones
        return new IndexGraveyard.Builder(graveyard);
            return new IndexGraveyard(tombstones);
    public String getWriteableName() {
        @Override
 * deleted in the cluster.  Because cluster states are processed asynchronously by  
 */
        }
        }
                final Tombstone firstTombstone = currentTombstones.get(0);
import org.opensearch.core.xcontent.ToXContentObject;  
                }
        public IndexGraveyard apply(final Metadata.Custom previous) {
    public Version getMinimalSupportedVersion() {  
            this.removedCount = removed;  
    }
        }  
                // look from the front for the removed tombstones  
        }
            Tombstone that = (Tombstone) other;
        @Override
     * @opensearch.api
        "cluster.indices.tombstones.size",  
         * Tombstones are purged if the number of tombstones in the list
                    // which means all tombstones from the previous list have been deleted.
        GRAVEYARD_PARSER = new ObjectParser<>("index_graveyard", ArrayList::new);  
/*  
                assert index != null;  
                this.index = index;
            // first, purge the necessary amount of entries
         * is greater than the input parameter of maximum allowed tombstones.  
    }
    }
        private final long currentTime = System.currentTimeMillis();
            return new IndexGraveyard.Builder().addBuiltTombstones(newTombstones).build();  
         * The deleted index.
            }  
                return false;
            }
    /**
            tombstones = tombstones.subList(count, tombstones.size());
        GRAVEYARD_PARSER.declareObjectArray(List::addAll, Tombstone.getParser(), TOMBSTONES_FIELD);
import org.opensearch.core.xcontent.XContentParser;
    public static final class Builder {
    }
    }  
    }
        private static final String DELETE_DATE_KEY = "delete_date";
    }
        }  
        public String toString() {
import java.util.Collections;  
        IndexGraveyardDiff(final IndexGraveyard previous, final IndexGraveyard current) {
    @Override
import org.opensearch.core.index.Index;  
 * The cluster state contains a list of index tombstones for indices that have been
        }  
         * <p>
                throw new IllegalArgumentException("invalid deleteDateInMillis [" + deleteDateInMillis + "]");  
import org.opensearch.common.annotation.PublicApi;
                this.deleteDateInMillis = deleteDate;
    @Override
         */  
        public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
            return (parser, context) -> TOMBSTONE_PARSER.apply(parser, null).build();  
        @Override  
 * nodes and a node could be removed from the cluster for a period of time, the
        }  
            if (removedCount > old.tombstones.size()) {  
        private static final class Builder {
            this.deleteDateInMillis = deleteDateInMillis;  
     */
        }
        }  
        private int numPurged = -1;  
                    added = Collections.emptyList();
            TOMBSTONE_PARSER = new ObjectParser<>("tombstoneEntry", Tombstone.Builder::new);
                return new Tombstone(index, deleteDateInMillis);
         *
        // create from stream  
         */
}
            tombstones.add(new Tombstone(index, currentTime));
    }  
     * very unlikely risk that if there are greater than MAX_TOMBSTONES index
            builder.startObject();
                added = Collections.emptyList();
        private Builder() {  
            int result = index.hashCode();
         */
         */
    @PublicApi(since = "1.0.0")  
import java.util.List;
        }
            added = Collections.unmodifiableList(in.readList((streamInput) -> new Tombstone(streamInput)));
         * Add a list of tombstones to the graveyard.
                removed = idx;  
        /**
            }  
 * KIND, either express or implied.  See the License for the
    public int hashCode() {
     * deletions while a node was offline, when it comes back online, it will have
    /**
            return "[index=" + index + ", deleteDate=" + date + "]";  
            Objects.requireNonNull(index);
import java.time.ZoneOffset;  
import org.opensearch.core.common.io.stream.StreamOutput;
                    // the first tombstone in the current list wasn't found in the previous list,
         */
        static {
     * @opensearch.api
        }  
    public EnumSet<Metadata.XContentContext> context() {  
        private Builder(IndexGraveyard that) {
            final List<Tombstone> previousTombstones = previous.tombstones;  
            }
        return false;  
    @Override  
 * software distributed under the License is distributed on an
            return deleteDateInMillis;
            } else if (currentTombstones.isEmpty()) {
                if (addedIndex < currentTombstones.size()) {
        builder.startArray(TOMBSTONES_FIELD.getPreferredName());
    private final List<Tombstone> tombstones;
    private IndexGraveyard(final List<Tombstone> list) {  
        public int hashCode() {  
    }
            private long deleteDateInMillis = -1L;
        }
            if (previousTombstones.isEmpty()) {
            this.index = index;
        return new IndexGraveyardDiff(in);
    /**
        Setting.Property.NodeScope
 * this work for additional information regarding copyright
 * A collection of tombstones for explicitly marking indices as deleted in the cluster state.  
    public static final Setting<Integer> SETTING_MAX_TOMBSTONES = Setting.intSetting(
            public void index(final Index index) {  
        }
            int count = tombstones().size() - maxTombstones;
        @Override
        }  
    }
         */
import org.opensearch.core.xcontent.XContentBuilder;
            tombstones = new ArrayList<>();
            return builder.endObject();  
         * @opensearch.internal  
            index.toXContent(builder, params);
        /** The number of index tombstones that were removed between two states */
        return new IndexGraveyard(GRAVEYARD_PARSER.parse(parser, null));
    /**
        public int getRemovedCount() {  
            }  
            return result;  
    private static final ObjectParser<List<Tombstone>, Void> GRAVEYARD_PARSER;
    public boolean containsIndex(final Index index) {  
        @Override  
        public int getNumPurged() {  
            TOMBSTONE_PARSER.declareString((b, s) -> {}, new ParseField(DELETE_DATE_KEY));  
         * Add a set of deleted indexes to the list of tombstones in the cluster state.  
        for (Tombstone tombstone : tombstones) {
        return (obj instanceof IndexGraveyard) && Objects.equals(tombstones, ((IndexGraveyard) obj).tombstones);  
         */
        }
 * under the License.  
 */  
            numPurged = purge(SETTING_MAX_TOMBSTONES.get(settings));  
 */  
        return new IndexGraveyardDiff((IndexGraveyard) previous, this);
        // TODO: Only including this method to work around bug in japicmp.
                return true;
    /**  
        @Override  
     * Setting for the maximum tombstones allowed in the cluster state;
 * tombstones remain in the cluster state for a fixed period of time, after which
     * missed index deletions that it may need to process.  
                newTombstones.add(tombstone);
        }
 * Licensed to Elasticsearch under one or more contributor  
    }  
         * A copy of the current tombstones in the builder.  
    }  
                new ParseField(INDEX_KEY)  
 * You may obtain a copy of the License at  
    @Override
        IndexGraveyardDiff(final StreamInput in) throws IOException {  
     * A class to build an IndexGraveyard.
        return TYPE;
            return count;  
        }
 *  
            out.writeLong(deleteDateInMillis);
        /**
    }  
@PublicApi(since = "1.0.0")
        private List<Tombstone> tombstones;
            return added;
            if (deleteDateInMillis < 0L) {
     */
            index.writeTo(out);
import org.opensearch.common.settings.Setting;
            builder.field(INDEX_KEY);  
                throw new IllegalStateException(
    public static IndexGraveyard.Builder builder() {
            this.added = Collections.unmodifiableList(added);
 *
     * A class representing a diff of two IndexGraveyard objects.  
        @Override  
                    assert added.equals(currentTombstones); // all previous are removed, so the current list must be the same as the added  
            if (tombstone.getIndex().equals(index)) {
    @Override
        private static final String INDEX_KEY = "index";  
        private final List<Tombstone> added;  
    );  
                // nothing will have been added, and all entries in previous are removed  
import org.opensearch.core.xcontent.ContextParser;
            TOMBSTONE_PARSER.declareLong(Tombstone.Builder::deleteDateInMillis, new ParseField(DELETE_DATE_IN_MILLIS_KEY));
                assert deleteDateInMillis > -1L;
import org.opensearch.core.xcontent.ObjectParser;
        static final DateFormatter FORMATTER = DateFormatter.forPattern("strict_date_optional_time").withZone(ZoneOffset.UTC);  
                final int addedIndex = currentTombstones.lastIndexOf(lastAddedTombstone);  
        }  
