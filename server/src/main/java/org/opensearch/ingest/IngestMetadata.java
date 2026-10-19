import org.opensearch.core.common.io.stream.StreamInput;  
 * license agreements. See the NOTICE file distributed with
/**
    public void writeTo(StreamOutput out) throws IOException {  
        return builder;
 *
    }
    // IngestMetadata is registered as custom metadata.  
    @Override
import java.util.ArrayList;
        if (o == null || getClass() != o.getClass()) return false;
        IngestMetadataDiff(IngestMetadata before, IngestMetadata after) {
    }
import org.opensearch.cluster.metadata.Metadata;
    }  
import java.util.Map;  
 * specific language governing permissions and limitations
 * compatible open source license.
    public static NamedDiff<Metadata.Custom> readDiffFrom(StreamInput in) throws IOException {  
    @Override  
    }
    public Diff<Metadata.Custom> diff(Metadata.Custom before) {
import org.opensearch.core.xcontent.XContentParser;
import java.io.IOException;  
        INGEST_METADATA_PARSER.declareObjectArray(List::addAll, PipelineConfiguration.getParser(), PIPELINES_FIELD);
            this.pipelines = DiffableUtils.diff(before.pipelines, after.pipelines, DiffableUtils.getStringKeySerializer());  
 *
            pipelines = DiffableUtils.readJdkMapDiff(
    static class IngestMetadataDiff implements NamedDiff<Metadata.Custom> {
        }  
import org.opensearch.core.ParseField;
        builder.endArray();
        Map<String, PipelineConfiguration> pipelines = new HashMap<>();
    @Override
        for (PipelineConfiguration pipeline : pipelines.values()) {
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        IngestMetadataDiff(StreamInput in) throws IOException {  
            pipeline.toXContent(builder, params);
import org.opensearch.core.xcontent.ObjectParser;
        return new IngestMetadataDiff(in);
public final class IngestMetadata implements Metadata.Custom {
            pipelines.put(pipeline.getId(), pipeline);
    @Override
        return new IngestMetadata(pipelines);
            return new IngestMetadata(pipelines.apply(((IngestMetadata) part).pipelines));
 * Licensed to Elasticsearch under one or more contributor  
        return pipelines.hashCode();
        IngestMetadata that = (IngestMetadata) o;  
 * this file be licensed under the Apache-2.0 license or a
    }
        @Override
        return pipelines.equals(that.pipelines);
import org.opensearch.core.common.io.stream.StreamOutput;
        for (PipelineConfiguration pipeline : pipelines.values()) {
        if (this == o) return true;  
        List<PipelineConfiguration> configs = INGEST_METADATA_PARSER.parse(parser, null);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        public void writeTo(StreamOutput out) throws IOException {  
    @Override
 * Modifications Copyright OpenSearch Contributors. See
        }
            pipeline.writeTo(out);  
    }
    @Override
        out.writeVInt(pipelines.size());
        Map<String, PipelineConfiguration> pipelines = new HashMap<>(size);  
    public EnumSet<Metadata.XContentContext> context() {  
        @Override  
        @Override
 * under the License.  
            PipelineConfiguration pipeline = PipelineConfiguration.readFrom(in);
 * SPDX-License-Identifier: Apache-2.0
    @Override
        }
        }
            pipelines.writeTo(out);
/*
    }
            pipelines.put(pipeline.getId(), pipeline);  
 * @opensearch.internal
    }  
        }
        return TYPE;  
        public String getWriteableName() {
    );
 * the Apache License, Version 2.0 (the "License"); you may
                PipelineConfiguration::readDiffFrom
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
    public IngestMetadata(Map<String, PipelineConfiguration> pipelines) {  
import java.util.HashMap;
    }  
 * Holds the ingest pipelines that are available in the cluster  
    public int hashCode() {
 * not use this file except in compliance with the License.
        this.pipelines = Collections.unmodifiableMap(pipelines);
                PipelineConfiguration::readFrom,
    }
    public boolean equals(Object o) {
/*  
    public static IngestMetadata fromXContent(XContentParser parser) throws IOException {
 *
 * KIND, either express or implied.  See the License for the
        return pipelines;
    private static final ParseField PIPELINES_FIELD = new ParseField("pipeline");
        final Diff<Map<String, PipelineConfiguration>> pipelines;  
import org.opensearch.cluster.Diff;
            );  
 *  
    public Map<String, PipelineConfiguration> getPipelines() {  
    }
        }
import java.util.EnumSet;  
    // We can't use Pipeline class directly in cluster state, because we don't have the processor factories around when
        public Metadata.Custom apply(Metadata.Custom part) {
    }
        }
        "ingest_metadata",  
 */  
        ArrayList::new
        builder.startArray(PIPELINES_FIELD.getPreferredName());  
        this.pipelines = Collections.unmodifiableMap(pipelines);
 * GitHub history for details.
    private static final ObjectParser<List<PipelineConfiguration>, Void> INGEST_METADATA_PARSER = new ObjectParser<>(
import org.opensearch.core.xcontent.XContentBuilder;  
import org.opensearch.cluster.NamedDiff;  
    public String getWriteableName() {
 * You may obtain a copy of the License at  
 */
                DiffableUtils.getStringKeySerializer(),  
        }  
        return Metadata.ALL_CONTEXTS;
    static {
    public static final String TYPE = "ingest";  
 */  
        int size = in.readVInt();
import java.util.Collections;
 * Unless required by applicable law or agreed to in writing,
        }  
}
            return TYPE;  
    }
 */  
                in,
        for (PipelineConfiguration pipeline : configs) {
package org.opensearch.ingest;
import org.opensearch.cluster.DiffableUtils;
    private final Map<String, PipelineConfiguration> pipelines;
    public IngestMetadata(StreamInput in) throws IOException {
        return new IngestMetadataDiff((IngestMetadata) before, this);  
 * software distributed under the License is distributed on an
        for (int i = 0; i < size; i++) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
    }  
 * this work for additional information regarding copyright
