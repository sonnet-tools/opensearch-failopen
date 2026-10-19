        }
        }
        this.timeStampField = timeStampField;
        out.writeString(name);
    static long backingIndexCounterOrMin(String dataStreamName, String indexName) {
     * @opensearch.api
import org.opensearch.core.xcontent.ToXContentObject;
        PARSER.declareObject(ConstructingObjectParser.constructorArg(), TimestampField.PARSER, TIMESTAMP_FIELD_FIELD);
        assert indices.get(indices.size() - 1).getName().equals(getDefaultBackingIndexName(name, generation));
        int counterDash = indexName.lastIndexOf('-');
        assert newWriteIndex.getName().equals(getDefaultBackingIndexName(name, generation + 1));
        backingIndices.remove(index);
        return String.format(Locale.ROOT, BACKING_INDEX_PREFIX + "%s-%06d", dataStreamName, generation);
     */
                )
    }
    @PublicApi(since = "1.0.0")
            this.name = name;
        return indexName.substring(BACKING_INDEX_PREFIX.length(), counterDash);
 * The OpenSearch Contributors require contributions made to
    static {
import org.opensearch.core.common.io.stream.Writeable;
    public DataStream removeBackingIndex(Index index) {
    public static Diff<DataStream> readDiffFrom(StreamInput in) throws IOException {
    @Override
        List<Index> backingIndices = new ArrayList<>(indices);
     * Performs a rollover on a {@code DataStream} instance and returns a new instance containing
        return new DataStream(name, timeStampField, backingIndices, generation);
            throw new IllegalArgumentException(
 * Modifications Copyright OpenSearch Contributors. See
        }
 * specific language governing permissions and limitations
import org.opensearch.cluster.AbstractDiffable;
     * Replaces the specified backing index with a new index and returns a new {@code DataStream} instance with
import org.opensearch.core.common.io.stream.StreamOutput;
        this(in.readString(), new TimestampField(in), in.readList(Index::new), in.readVLong());
 */
            builder.field(NAME_FIELD.getPreferredName(), name);
        builder.endObject();
        }
        }
                return Long.MIN_VALUE;
            this.name = in.readString();
     * A timestamp field.
 *
            return null;
        PARSER.declareLong(ConstructingObjectParser.constructorArg(), GENERATION_FIELD);
    public static final ParseField GENERATION_FIELD = new ParseField("generation");
    /**
            return Objects.hash(name);
            && indices.equals(that.indices)
     * the modified backing indices. An {@code IllegalArgumentException} is thrown if the index to be replaced
    @Override
        }
            return Collections.singletonMap(NAME_FIELD.getPreferredName(), name);
     * Returns the generation counter of a backing index named {@code .ds-<dataStreamName>-NNNNNN}, or
        try {
    }
            );
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under
        return PARSER.parse(parser, null);
        @Override
                return null;
            return builder;
        out.writeVLong(generation);
    /**
     * never become the write index.
     * generation unchanged.
import java.util.Collections;
/**
     * @param generation generation of the data stream
    public static final ParseField TIMESTAMP_FIELD_FIELD = new ParseField("timestamp_field");
                // decode the first dimension because this should not be a multi dimension field
    private final TimestampField timeStampField;
     */
            throw new OpenSearchException("Not a timeseries Index! Field [{}] not found!", TIMESERIES_FIELDNAME);
    }
        return new DataStream(name, timeStampField, backingIndices, generation);
 */
     * @return new {@code DataStream} instance with the remaining backing indices
    /**
        return Objects.hash(name, timeStampField, indices, generation);
            PointValues points = r.getPointValues(TIMESERIES_FIELDNAME);
import java.util.ArrayList;
    private static final ConstructingObjectParser<DataStream, Void> PARSER = new ConstructingObjectParser<>(
            args -> new TimestampField((String) args[0])
        return builder;
        @Override
        }
     *
import org.opensearch.common.annotation.PublicApi;
    }
        public String getName() {
        }
     * @param existingBackingIndex the backing index to be replaced
    public static String parseDataStreamName(String indexName) {
    }
        builder.startObject();
     *
        List<Index> backingIndices = new ArrayList<>(indices);
    private final long generation;
                    name
        builder.field(GENERATION_FIELD.getPreferredName(), generation);
        }
        backingIndices.add(index);
    public static String getDefaultBackingIndexName(String dataStreamName, long generation) {
    }
     * {@link Long#MIN_VALUE} for any other name so that non-convention indices sort before convention-named ones and
        if (counterDash <= BACKING_INDEX_PREFIX.length()) {
    /**
        @SuppressWarnings("unchecked")
    }).reversed();
    public DataStream addBackingIndex(Index index) {
        this.indices = Collections.unmodifiableList(indices);
        @Override
            return null;
 */
    /**
     * Adds the given index to the data stream's backing indices and returns a new {@code DataStream} instance. Backing
            if (o == null || getClass() != o.getClass()) return false;
        }
    public static final ParseField NAME_FIELD = new ParseField("name");
    public static DataStream fromXContent(XContentParser parser) throws IOException {
        public boolean equals(Object o) {
 * compatible open source license.
import org.opensearch.core.xcontent.XContentParser;
        }
        backingIndices.add(newWriteIndex);
            } else {
     */
 * the Apache License, Version 2.0 (the "License"); you may
    public static final String BACKING_INDEX_PREFIX = ".ds-";
     */
            if (points != null) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        String counter = indexName.substring(counterDash + 1);
import org.opensearch.cluster.Diff;
import org.opensearch.core.xcontent.ConstructingObjectParser;
/*
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.index.Index;
     * the generation and makes it the new write index; adding a lower-counter or non-convention index leaves the
import org.apache.lucene.index.PointValues;
     * the remaining backing indices.
        public static final ConstructingObjectParser<TimestampField, Void> PARSER = new ConstructingObjectParser<>(
        this.generation = generation;
        DataStream that = (DataStream) o;
                String.format(
        }
    }
            if (Character.isDigit(counter.charAt(i)) == false) {
     * Generates the name of the index that conforms to the default naming convention for backing indices
import org.opensearch.core.ParseField;
        return generation;
    }
     * @param index the backing index to remove
    }
/*
            builder.startObject();
     * indices are ordered oldest-to-newest so the write index remains last: convention-named indices
        PARSER.declareObjectArray(ConstructingObjectParser.constructorArg(), (p, c) -> Index.fromXContent(p), INDICES_FIELD);
        assert backingIndices.size() == indices.size() - 1;
        List<Index> backingIndices = new ArrayList<>(indices);
        args -> new DataStream((String) args[0], (TimestampField) args[1], (List<Index>) args[2], (Long) args[3])
    public void writeTo(StreamOutput out) throws IOException {
        public TimestampField(String name) {
     *
        public void writeTo(StreamOutput out) throws IOException {
import java.util.Locale;
    public String getName() {
     */
package org.opensearch.cluster.metadata;
    public DataStream rollover(Index newWriteIndex) {
    private final String name;
        }
     * is not a backing index for this data stream or if it is the {@code DataStream}'s write index.
            if (this == o) return true;
        return new DataStream(name, timeStampField, backingIndices, newGeneration);
                    Locale.ROOT,
        );
    }
        builder.field(INDICES_FIELD.getPreferredName(), indices);
    }
    /**
    public boolean equals(Object o) {
    public static final class TimestampField implements Writeable, ToXContentObject {
                    "cannot replace backing index [%s] of data stream [%s] because " + "it is the write index",
     *                      backing indices on data streams. See {@link #getDefaultBackingIndexName}.
     *
                // segment does not have a timestamp field, just return the minimum value
        return indices;
    public DataStream(String name, TimestampField timeStampField, List<Index> indices, long generation) {
import java.util.Map;
 *
        public Map<String, Object> toMap() {
     *
                // could be a multipoint (probably not) but get the maximum time value anyway
 *
        }
    public static final Comparator<LeafReader> TIMESERIES_LEAF_SORTER = Comparator.comparingLong((LeafReader r) -> {
        return name;
        public TimestampField(StreamInput in) throws IOException {
            builder.endObject();
     * (a numeric counter suffix), returns the {@code <dataStream>} portion; otherwise returns {@code null}.
     * If {@code indexName} follows the data stream backing-index naming convention {@code .ds-<dataStream>-NNNNNN}
        return Long.parseLong(indexName.substring(indexName.lastIndexOf('-') + 1));
    @Override
     * @param newWriteIndex the new write backing index. Must conform to the naming convention for
        return name.equals(that.name)
    }
    public DataStream(String name, TimestampField timeStampField, List<Index> indices) {
            && generation == that.generation;
     * @param dataStreamName name of the data stream
    @SuppressWarnings("unchecked")
        return new DataStream(name, timeStampField, backingIndices, generation + 1);
        if (indexName.startsWith(BACKING_INDEX_PREFIX) == false) {
        if (counter.isEmpty()) {
import org.opensearch.core.xcontent.XContentBuilder;
        int backingIndexPosition = backingIndices.indexOf(existingBackingIndex);
import org.apache.lucene.index.LeafReader;
     * existing index.
            && timeStampField.equals(that.timeStampField)
    }
        for (int i = 0; i < counter.length(); i++) {
        if (backingIndexPosition == -1) {
    }
        assert indices.size() > 0;
    }
 */
 * SPDX-License-Identifier: Apache-2.0
import java.util.Objects;
            "timestamp_field",
                byte[] sortValue = points.getMaxPackedValue();
        builder.field(NAME_FIELD.getPreferredName(), name);
            out.writeString(name);
     */
        backingIndices.set(backingIndexPosition, newBackingIndex);
     * on data streams given the specified data stream name and generation.
    public TimestampField getTimeStampField() {
        List<Index> backingIndices = new ArrayList<>(indices);
    }
            return Long.MIN_VALUE;
 * this work for additional information regarding copyright
    /**
            }
        }
    }
        @Override
 * Licensed to Elasticsearch under one or more contributor
 * @opensearch.api
            return null;
     * as the highest backing-index counter, so adding an index whose counter exceeds the current generation advances
     * @return new {@code DataStream} instance with the rollover operation applied
        if (generation == (backingIndexPosition + 1)) {
            return name.equals(that.name);
        timeStampField.writeTo(out);
        }
        if (this == o) return true;
        public int hashCode() {
 *     http://www.apache.org/licenses/LICENSE-2.0
            return name;
    public long getGeneration() {
    public DataStream replaceBackingIndex(Index existingBackingIndex, Index newBackingIndex) {
        }
     * @return new {@code DataStream} instance with backing indices that contain replacement index instead of the specified
 * You may obtain a copy of the License at
import org.apache.lucene.document.LongPoint;
    private final List<Index> indices;
     * @return backing index name
    }
public final class DataStream extends AbstractDiffable<DataStream> implements ToXContentObject {
            throw new IllegalArgumentException(
            );
        static ParseField NAME_FIELD = new ParseField("name");
 * KIND, either express or implied.  See the License for the
import java.util.Comparator;
    public List<Index> getIndices() {
import org.opensearch.core.common.io.stream.StreamInput;
                    existingBackingIndex.getName(),
            }
        long newGeneration = Math.max(generation, backingIndexCounterOrMin(name, index.getName()));
    @Override
     * Removes the specified backing index and returns a new {@code DataStream} instance with
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                String.format(Locale.ROOT, "index [%s] is not part of data stream [%s] ", existingBackingIndex.getName(), name)
        return timeStampField;
    public DataStream(StreamInput in) throws IOException {
 * under the License.
@PublicApi(since = "1.0.0")
    );
import java.util.List;
    /**
        } catch (IOException e) {
    public static final ParseField INDICES_FIELD = new ParseField("indices");
/*
        return readDiffFrom(DataStream::new, in);
 * Unless required by applicable law or agreed to in writing,
        "data_stream",
        out.writeList(indices);
 * software distributed under the License is distributed on an
     *
 * license agreements. See the NOTICE file distributed with
 *
    public static final String TIMESERIES_FIELDNAME = "@timestamp";
        builder.field(TIMESTAMP_FIELD_FIELD.getPreferredName(), timeStampField);
    }
     */
import java.io.IOException;
        static {
     * @param index the backing index to add
        backingIndices.sort(Comparator.comparingLong(i -> backingIndexCounterOrMin(name, i.getName())));
     * the updated list of backing indices and incremented generation.
     * ({@code .ds-<name>-NNNNNN}) order by their counter, and non-convention names sort first. The generation is derived
}
        this.name = name;
        if (dataStreamName.equals(parseDataStreamName(indexName)) == false) {
     * @return new {@code DataStream} instance with the index added
    }
        this(name, timeStampField, indices, indices.size());
    public int hashCode() {
        PARSER.declareString(ConstructingObjectParser.constructorArg(), NAME_FIELD);
        if (o == null || getClass() != o.getClass()) return false;
     */
            TimestampField that = (TimestampField) o;
 * GitHub history for details.
 * Primary DataStream class
    }
                // it's a bug in the date field if it is
     * @param newBackingIndex      the new index that will be part of the {@code DataStream}
                return LongPoint.decodeDimension(sortValue, 0);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        private final String name;
            PARSER.declareString(ConstructingObjectParser.constructorArg(), NAME_FIELD);
import org.opensearch.OpenSearchException;
