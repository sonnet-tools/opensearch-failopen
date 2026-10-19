     * If {@code indexName} follows the data stream backing-index naming convention {@code .ds-<dataStream>-NNNNNN}
import org.opensearch.core.xcontent.ConstructingObjectParser;  
        public String getName() {
 * Modifications Copyright OpenSearch Contributors. See  
    public void writeTo(StreamOutput out) throws IOException {  
        out.writeString(name);
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
     * never become the write index.
        return Long.parseLong(indexName.substring(indexName.lastIndexOf('-') + 1));
import java.util.Locale;
            return Collections.singletonMap(NAME_FIELD.getPreferredName(), name);
     */
        return String.format(Locale.ROOT, BACKING_INDEX_PREFIX + "%s-%06d", dataStreamName, generation);  
 * SPDX-License-Identifier: Apache-2.0
        return new DataStream(name, timeStampField, backingIndices, generation);  
        List<Index> backingIndices = new ArrayList<>(indices);  
 * under the License.  
        assert backingIndices.size() == indices.size() - 1;
        PARSER.declareObjectArray(ConstructingObjectParser.constructorArg(), (p, c) -> Index.fromXContent(p), INDICES_FIELD);  
    public static String getDefaultBackingIndexName(String dataStreamName, long generation) {
    @Override
        long newGeneration = Math.max(generation, backingIndexCounterOrMin(name, index.getName()));  
            return null;  
            if (this == o) return true;
        return builder;
import org.opensearch.core.common.io.stream.StreamInput;
    }  
    public static final ParseField NAME_FIELD = new ParseField("name");
        }  
    /**
            "timestamp_field",
     * @param index the backing index to remove
     * generation unchanged.  
        for (int i = 0; i < counter.length(); i++) {
        if (this == o) return true;  
     * Replaces the specified backing index with a new index and returns a new {@code DataStream} instance with
        this(name, timeStampField, indices, indices.size());  
            return name;
 * @opensearch.api
    public static final ParseField TIMESTAMP_FIELD_FIELD = new ParseField("timestamp_field");
    public static DataStream fromXContent(XContentParser parser) throws IOException {
        }  
        static {  
        return readDiffFrom(DataStream::new, in);
     * Performs a rollover on a {@code DataStream} instance and returns a new instance containing
    public static final Comparator<LeafReader> TIMESERIES_LEAF_SORTER = Comparator.comparingLong((LeafReader r) -> {  
     */  
    }
    static long backingIndexCounterOrMin(String dataStreamName, String indexName) {  
        List<Index> backingIndices = new ArrayList<>(indices);  
            args -> new TimestampField((String) args[0])  
                    Locale.ROOT,
        builder.field(INDICES_FIELD.getPreferredName(), indices);
                String.format(  
import org.opensearch.core.xcontent.XContentBuilder;
     * Removes the specified backing index and returns a new {@code DataStream} instance with
    public boolean equals(Object o) {
 * The OpenSearch Contributors require contributions made to  
                return null;
     * the remaining backing indices.  
            );
    private final List<Index> indices;
            if (Character.isDigit(counter.charAt(i)) == false) {  
     * indices are ordered oldest-to-newest so the write index remains last: convention-named indices
import org.opensearch.core.xcontent.ToXContentObject;
    @SuppressWarnings("unchecked")  
            TimestampField that = (TimestampField) o;  
        }
    }
     *
    }
            builder.endObject();
        if (counterDash <= BACKING_INDEX_PREFIX.length()) {
        PARSER.declareObject(ConstructingObjectParser.constructorArg(), TimestampField.PARSER, TIMESTAMP_FIELD_FIELD);
        static ParseField NAME_FIELD = new ParseField("name");
 * GitHub history for details.
     *
     */
        builder.endObject();  
        }
    }
     * @param dataStreamName name of the data stream
     * @opensearch.api
        }
        backingIndices.remove(index);
            return builder;  
        public void writeTo(StreamOutput out) throws IOException {  
            return name.equals(that.name);
    /**  
                    existingBackingIndex.getName(),  
        if (dataStreamName.equals(parseDataStreamName(indexName)) == false) {
        public TimestampField(String name) {  
    public DataStream removeBackingIndex(Index index) {
            if (points != null) {  
        backingIndices.set(backingIndexPosition, newBackingIndex);
            throw new OpenSearchException("Not a timeseries Index! Field [{}] not found!", TIMESERIES_FIELDNAME);
                return Long.MIN_VALUE;
                // could be a multipoint (probably not) but get the maximum time value anyway
            throw new IllegalArgumentException(
            }  
            );  
        int counterDash = indexName.lastIndexOf('-');  
    @Override
     *
        @Override
import org.opensearch.cluster.AbstractDiffable;
        }
        if (indexName.startsWith(BACKING_INDEX_PREFIX) == false) {  
        return name.equals(that.name)  
        }  
        this(in.readString(), new TimestampField(in), in.readList(Index::new), in.readVLong());
import org.apache.lucene.index.LeafReader;
    /**
     * {@link Long#MIN_VALUE} for any other name so that non-convention indices sort before convention-named ones and  
 * ownership. Elasticsearch licenses this file to you under  
     */
 * You may obtain a copy of the License at  
     *
    }
    }  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        private final String name;
    public List<Index> getIndices() {
     * @return new {@code DataStream} instance with the index added  
 *
    }
        public boolean equals(Object o) {  
        public Map<String, Object> toMap() {  
    }
     * Generates the name of the index that conforms to the default naming convention for backing indices
    }  
        List<Index> backingIndices = new ArrayList<>(indices);
            return Long.MIN_VALUE;
    public DataStream(StreamInput in) throws IOException {  
    private static final ConstructingObjectParser<DataStream, Void> PARSER = new ConstructingObjectParser<>(
import org.opensearch.core.common.io.stream.StreamOutput;  
                String.format(Locale.ROOT, "index [%s] is not part of data stream [%s] ", existingBackingIndex.getName(), name)
    public static String parseDataStreamName(String indexName) {
    /**  
    static {  
        builder.field(TIMESTAMP_FIELD_FIELD.getPreferredName(), timeStampField);  
        String counter = indexName.substring(counterDash + 1);
                // decode the first dimension because this should not be a multi dimension field  
    }
/**
     * A timestamp field.  
 *
            PARSER.declareString(ConstructingObjectParser.constructorArg(), NAME_FIELD);
        return timeStampField;
        timeStampField.writeTo(out);
     *                      backing indices on data streams. See {@link #getDefaultBackingIndexName}.  
        return new DataStream(name, timeStampField, backingIndices, generation + 1);
    public static final String TIMESERIES_FIELDNAME = "@timestamp";
     * ({@code .ds-<name>-NNNNNN}) order by their counter, and non-convention names sort first. The generation is derived  
    }
                return LongPoint.decodeDimension(sortValue, 0);
            }
    public String getName() {  
        out.writeList(indices);  
 * license agreements. See the NOTICE file distributed with
     */
        }
     * (a numeric counter suffix), returns the {@code <dataStream>} portion; otherwise returns {@code null}.  
        }  
     * @return new {@code DataStream} instance with backing indices that contain replacement index instead of the specified
 */  
        this.indices = Collections.unmodifiableList(indices);
/*
}  
     * @param newWriteIndex the new write backing index. Must conform to the naming convention for
    }
 * compatible open source license.
import org.opensearch.common.annotation.PublicApi;  
        if (generation == (backingIndexPosition + 1)) {
     * the modified backing indices. An {@code IllegalArgumentException} is thrown if the index to be replaced  
    public DataStream(String name, TimestampField timeStampField, List<Index> indices, long generation) {
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Collections;
        }
                // segment does not have a timestamp field, just return the minimum value
    }
        args -> new DataStream((String) args[0], (TimestampField) args[1], (List<Index>) args[2], (Long) args[3])  
        assert newWriteIndex.getName().equals(getDefaultBackingIndexName(name, generation + 1));
 * this work for additional information regarding copyright
        );
            && generation == that.generation;  
        }
import org.opensearch.core.common.io.stream.Writeable;
     * on data streams given the specified data stream name and generation.
        return name;
     * @return new {@code DataStream} instance with the remaining backing indices  
        @SuppressWarnings("unchecked")  
     * @return backing index name  
     * existing index.  
    /**
            PointValues points = r.getPointValues(TIMESERIES_FIELDNAME);
        }  
            this.name = in.readString();
    @Override  
        @Override
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
        @Override
            return null;
 * not use this file except in compliance with the License.
import org.opensearch.OpenSearchException;  
        return PARSER.parse(parser, null);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.document.LongPoint;  
     *  
        builder.field(GENERATION_FIELD.getPreferredName(), generation);
        builder.field(NAME_FIELD.getPreferredName(), name);
        @Override
import java.util.Map;
 */  
     * @return new {@code DataStream} instance with the rollover operation applied
    @Override
        assert indices.get(indices.size() - 1).getName().equals(getDefaultBackingIndexName(name, generation));
import org.opensearch.core.index.Index;
    }
    }
        }  
        } catch (IOException e) {
    public long getGeneration() {  
        return indices;  
     * Returns the generation counter of a backing index named {@code .ds-<dataStreamName>-NNNNNN}, or
    public static final ParseField INDICES_FIELD = new ParseField("indices");  
    public DataStream rollover(Index newWriteIndex) {  
 */
import org.opensearch.core.xcontent.XContentParser;  
        backingIndices.add(newWriteIndex);  
        }
 *
            this.name = name;
        backingIndices.sort(Comparator.comparingLong(i -> backingIndexCounterOrMin(name, i.getName())));
import org.opensearch.core.ParseField;
        if (counter.isEmpty()) {
        return new DataStream(name, timeStampField, backingIndices, newGeneration);
     * @param existingBackingIndex the backing index to be replaced  
    }).reversed();
        public int hashCode() {
    public static final class TimestampField implements Writeable, ToXContentObject {
            out.writeString(name);
public final class DataStream extends AbstractDiffable<DataStream> implements ToXContentObject {
    }  
     */
 * software distributed under the License is distributed on an
        return generation;
    /**
    );
            && timeStampField.equals(that.timeStampField)
     *
            if (o == null || getClass() != o.getClass()) return false;
        this.name = name;  
        PARSER.declareString(ConstructingObjectParser.constructorArg(), NAME_FIELD);
 * Unless required by applicable law or agreed to in writing,
        this.timeStampField = timeStampField;
            builder.field(NAME_FIELD.getPreferredName(), name);
            builder.startObject();  
        PARSER.declareLong(ConstructingObjectParser.constructorArg(), GENERATION_FIELD);
        List<Index> backingIndices = new ArrayList<>(indices);  
 */
    public DataStream(String name, TimestampField timeStampField, List<Index> indices) {
        out.writeVLong(generation);
        backingIndices.add(index);
    public static final String BACKING_INDEX_PREFIX = ".ds-";
 * this file be licensed under the Apache-2.0 license or a
        if (backingIndexPosition == -1) {
    }
import java.util.Comparator;
    }
    public DataStream addBackingIndex(Index index) {
     */
     * the generation and makes it the new write index; adding a lower-counter or non-convention index leaves the
    public static final ParseField GENERATION_FIELD = new ParseField("generation");
        this.generation = generation;  
    public int hashCode() {
    public TimestampField getTimeStampField() {
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.cluster.metadata;
            throw new IllegalArgumentException(  
import org.apache.lucene.index.PointValues;
        return Objects.hash(name, timeStampField, indices, generation);
    }
            && indices.equals(that.indices)
    @PublicApi(since = "1.0.0")
     * @param newBackingIndex      the new index that will be part of the {@code DataStream}
    public static Diff<DataStream> readDiffFrom(StreamInput in) throws IOException {
                )
     * is not a backing index for this data stream or if it is the {@code DataStream}'s write index.
        builder.startObject();
        return indexName.substring(BACKING_INDEX_PREFIX.length(), counterDash);
        return new DataStream(name, timeStampField, backingIndices, generation);  
            return Objects.hash(name);  
    }  
    /**
/*
    }
    private final long generation;  
import java.util.ArrayList;  
/*  
        public static final ConstructingObjectParser<TimestampField, Void> PARSER = new ConstructingObjectParser<>(
        public TimestampField(StreamInput in) throws IOException {
import java.io.IOException;
    public DataStream replaceBackingIndex(Index existingBackingIndex, Index newBackingIndex) {
     * as the highest backing-index counter, so adding an index whose counter exceeds the current generation advances
        }
     * @param generation generation of the data stream
    /**
 *  
import java.util.Objects;  
     */
        assert indices.size() > 0;
                // it's a bug in the date field if it is
        int backingIndexPosition = backingIndices.indexOf(existingBackingIndex);
            return null;
     * @param index the backing index to add
                    "cannot replace backing index [%s] of data stream [%s] because " + "it is the write index",
import org.opensearch.cluster.Diff;
        if (o == null || getClass() != o.getClass()) return false;
    private final TimestampField timeStampField;
import java.util.List;  
        DataStream that = (DataStream) o;
                byte[] sortValue = points.getMaxPackedValue();
 * Primary DataStream class  
     * the updated list of backing indices and incremented generation.  
        "data_stream",
        try {
        }  
@PublicApi(since = "1.0.0")
     * Adds the given index to the data stream's backing indices and returns a new {@code DataStream} instance. Backing
    private final String name;  
            } else {  
                    name
