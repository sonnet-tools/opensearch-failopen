        public Metadata.Custom apply(Metadata.Custom part) {
        return PARSER.parse(parser, null);
import org.opensearch.core.common.io.stream.StreamOutput;
        return new DataStreamMetadata.DataStreamMetadataDiff((DataStreamMetadata) before, this);
        return TYPE;
        @Override
            while (p.nextToken() != XContentParser.Token.END_OBJECT) {
    @Override
    @Override
    public static DataStreamMetadata fromXContent(XContentParser parser) throws IOException {  
            return new DataStreamMetadata(dataStreams);
        a -> new DataStreamMetadata((Map<String, DataStream>) a[0])
        }  
    }
    @Override
            this.dataStreamDiff = DiffableUtils.diff(before.dataStreams, after.dataStreams, DiffableUtils.getStringKeySerializer());  
     * @opensearch.internal
            return TYPE;  
            );  
            dataStreamDiff.writeTo(out);
                dataStreams.put(name, DataStream.fromXContent(p));
        private final Map<String, DataStream> dataStreams = new HashMap<>();
    static class DataStreamMetadataDiff implements NamedDiff<Metadata.Custom> {
    @Override  
        builder.startObject(DATA_STREAM.getPreferredName());  
import org.opensearch.cluster.DiffableUtils;
    public Diff<Metadata.Custom> diff(Metadata.Custom before) {
            return dataStreams;  
 */
    public static final String TYPE = "data_stream";
 * license agreements. See the NOTICE file distributed with
    public static class Builder {  
        this.dataStreams = in.readMap(StreamInput::readString, DataStream::new);
    public boolean equals(Object obj) {  
    }  
    );  
                DataStream::readDiffFrom
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
        PARSER.declareObject(ConstructingObjectParser.constructorArg(), (p, c) -> {  
/**
        public Builder putDataStream(DataStream dataStream) {
    }
        return builder;
        }  
        DataStreamMetadataDiff(StreamInput in) throws IOException {  
}  
            dataStreams.put(dataStream.getName(), dataStream);
 *
        return Objects.hash(this.dataStreams);
import org.opensearch.core.ParseField;
    }  
import org.opensearch.core.common.io.stream.StreamInput;  
            }
import java.util.Map;
        @Override
    }
 * Licensed to Elasticsearch under one or more contributor  
    /**
import org.opensearch.core.xcontent.MediaTypeRegistry;  
 * You may obtain a copy of the License at  
 * GitHub history for details.
import org.opensearch.core.xcontent.XContentBuilder;
    public DataStreamMetadata(StreamInput in) throws IOException {
 * Custom {@link Metadata} implementation for storing a map of {@link DataStream}s and their names.
 * software distributed under the License is distributed on an
        return new Builder();  
    public int hashCode() {
 * this work for additional information regarding copyright
    public String getWriteableName() {  
        return this.dataStreams;  
        public String getWriteableName() {
                DataStream::new,
    }
    @Override
 * Unless required by applicable law or agreed to in writing,
            this.dataStreamDiff = DiffableUtils.readJdkMapDiff(
public class DataStreamMetadata implements Metadata.Custom {  
        public void writeTo(StreamOutput out) throws IOException {  
    }  
        DataStreamMetadata other = (DataStreamMetadata) obj;
 */  
    }  
    @Override  
import java.util.HashMap;  
    }  
    private static final ParseField DATA_STREAM = new ParseField("data_stream");  
        TYPE,  
 * not use this file except in compliance with the License.
        }  
    static {
 *  
    public void writeTo(StreamOutput out) throws IOException {
        }
import org.opensearch.core.xcontent.ConstructingObjectParser;
    }
    public static NamedDiff<Metadata.Custom> readDiffFrom(StreamInput in) throws IOException {
 * @opensearch.internal
     */  
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
        final Diff<Map<String, DataStream>> dataStreamDiff;  
    }
 * KIND, either express or implied.  See the License for the
    public Map<String, DataStream> dataStreams() {
        @Override  
/*  
        public DataStreamMetadata build() {  
     * @opensearch.internal
            return false;
     * A diff between data stream metadata.  
     *  
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
    @Override
 * The OpenSearch Contributors require contributions made to  
        this.dataStreams = dataStreams;
        builder.endObject();
 * compatible open source license.
     * Builder of data stream metadata.
            builder.field(dataStream.getKey(), dataStream.getValue());
    @SuppressWarnings("unchecked")
            return this;  
    private static final ConstructingObjectParser<DataStreamMetadata, Void> PARSER = new ConstructingObjectParser<>(
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
        if (obj == null) {
        }
        return Strings.toString(MediaTypeRegistry.JSON, this);
        if (obj.getClass() != getClass()) {
import org.opensearch.core.xcontent.XContentParser;
        }
    }
                DiffableUtils.getStringKeySerializer(),  
        out.writeMap(this.dataStreams, StreamOutput::writeString, (stream, val) -> val.writeTo(stream));  
import java.util.EnumSet;
        return Objects.equals(this.dataStreams, other.dataStreams);
        }  
    }  
import org.opensearch.core.common.Strings;
            return false;
import org.opensearch.cluster.Diff;
    /**
     */
    public static Builder builder() {
     *
                in,
        }
        false,
        }, DATA_STREAM);
                String name = p.currentName();  
    public String toString() {  
    private final Map<String, DataStream> dataStreams;
import org.opensearch.cluster.NamedDiff;  
 *     http://www.apache.org/licenses/LICENSE-2.0
            Map<String, DataStream> dataStreams = new HashMap<>();
        return new DataStreamMetadata.DataStreamMetadataDiff(in);  
    }  
        DataStreamMetadataDiff(DataStreamMetadata before, DataStreamMetadata after) {
import java.util.Objects;
 */
 * SPDX-License-Identifier: Apache-2.0
 *  
 */  
 *
    public EnumSet<Metadata.XContentContext> context() {
package org.opensearch.cluster.metadata;
 * specific language governing permissions and limitations
        return Metadata.ALL_CONTEXTS;
        }
        for (Map.Entry<String, DataStream> dataStream : dataStreams.entrySet()) {
            return new DataStreamMetadata(dataStreamDiff.apply(((DataStreamMetadata) part).dataStreams));
    public DataStreamMetadata(Map<String, DataStream> dataStreams) {  
/*  
    @Override  
    }
        }
