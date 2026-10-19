    // Mapping from pipeline ID to each pipeline's configuration.  
    public static NamedDiff<Metadata.Custom> readDiffFrom(StreamInput in) throws IOException {  
import org.opensearch.cluster.DiffableUtils;
 * The OpenSearch Contributors require contributions made to  
        @Override
        }
        if (this == o) return true;  
        return builder;
        List<PipelineConfiguration> configs = SEARCH_PIPELINE_METADATA_PARSER.parse(parser, null);
    }
            this.pipelines = DiffableUtils.readJdkMapDiff(
    }  
import org.opensearch.cluster.NamedDiff;  
    public static SearchPipelineMetadata fromXContent(XContentParser parser) throws IOException {
    private static final ParseField PIPELINES_FIELD = new ParseField("pipeline");
        for (PipelineConfiguration pipeline : pipelines.values()) {
    @Override
    }
    public EnumSet<Metadata.XContentContext> context() {  
        builder.endArray();
                in,
    }
        }
import java.util.Collections;
    @Override
    public SearchPipelineMetadata(Map<String, PipelineConfiguration> pipelines) {  
 *
 * compatible open source license.
        for (PipelineConfiguration pipeline : configs) {
            PipelineConfiguration pipeline = PipelineConfiguration.readFrom(in);
        final Diff<Map<String, PipelineConfiguration>> pipelines;  
        "search_pipeline_metadata",  
        return new SearchPipelineMetadataDiff(in);
        out.writeVInt(pipelines.size());
            pipelines.writeTo(out);  
    );
        builder.startArray(PIPELINES_FIELD.getPreferredName());  
            this.pipelines = DiffableUtils.diff(before.pipelines, after.pipelines, DiffableUtils.getStringKeySerializer());  
import java.util.EnumSet;  
package org.opensearch.search.pipeline;
    public static final String TYPE = "search_pipeline";
        for (int i = 0; i < size; i++) {
                DiffableUtils.getStringKeySerializer(),  
 * this file be licensed under the Apache-2.0 license or a
        return new SearchPipelineMetadataDiff((SearchPipelineMetadata) previousState, this);  
 * @opensearch.internal
import java.util.Map;  
            pipeline.toXContent(builder, params);
}  
    public Map<String, PipelineConfiguration> getPipelines() {  
    public boolean equals(Object o) {
        this.pipelines = Collections.unmodifiableMap(pipelines);
    @Override
        public void writeTo(StreamOutput out) throws IOException {
            return TYPE;
import java.util.List;
import org.opensearch.cluster.metadata.Metadata;
        }
        return pipelines.equals(that.pipelines);  
        int size = in.readVInt();
    static class SearchPipelineMetadataDiff implements NamedDiff<Metadata.Custom> {
import java.io.IOException;  
        return TYPE;  
        this.pipelines = Collections.unmodifiableMap(pipelines);
        }  
    public SearchPipelineMetadata(StreamInput in) throws IOException {
        public String getWriteableName() {  
import org.opensearch.core.common.io.stream.StreamInput;  
    public String getWriteableName() {
import java.util.HashMap;
 */  
        SEARCH_PIPELINE_METADATA_PARSER.declareObjectArray(List::addAll, PipelineConfiguration.getParser(), PIPELINES_FIELD);
public class SearchPipelineMetadata implements Metadata.Custom {
import org.opensearch.core.xcontent.XContentParser;
            );  
import org.opensearch.core.xcontent.XContentBuilder;  
    @Override
            pipelines.put(pipeline.getId(), pipeline);  
    }
        @Override  
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
    }  
    public void writeTo(StreamOutput out) throws IOException {  
    }
        for (PipelineConfiguration pipeline : pipelines.values()) {
    public Diff<Metadata.Custom> diff(Metadata.Custom previousState) {
 *
            pipelines.put(pipeline.getId(), pipeline);  
        return Metadata.ALL_CONTEXTS;
                PipelineConfiguration::readFrom,
    }  
        public Metadata.Custom apply(Metadata.Custom part) {
 * Represents the search pipelines that are available in the cluster  
    }  
        SearchPipelineMetadata that = (SearchPipelineMetadata) o;
        Map<String, PipelineConfiguration> pipelines = new HashMap<>();  
        ArrayList::new
    public int hashCode() {
import org.opensearch.core.xcontent.ObjectParser;
    private final Map<String, PipelineConfiguration> pipelines;
        }
    @Override
    private static final ObjectParser<List<PipelineConfiguration>, Void> SEARCH_PIPELINE_METADATA_PARSER = new ObjectParser<>(
import org.opensearch.cluster.Diff;
        }
import java.util.ArrayList;
import org.opensearch.core.ParseField;
                PipelineConfiguration::readDiffFrom
import org.opensearch.core.common.io.stream.StreamOutput;
        return pipelines.hashCode();
        public SearchPipelineMetadataDiff(SearchPipelineMetadata before, SearchPipelineMetadata after) {
        if (o == null || getClass() != o.getClass()) return false;
/**
            pipeline.writeTo(out);  
    }
        return new SearchPipelineMetadata(pipelines);
    @Override  
        }  
        return pipelines;
    }
    static {  
        @Override
    }
    @Override
        public SearchPipelineMetadataDiff(StreamInput in) throws IOException {  
        }
        }
 */  
 * SPDX-License-Identifier: Apache-2.0
            return new SearchPipelineMetadata(pipelines.apply(((SearchPipelineMetadata) part).pipelines));
/*  
        Map<String, PipelineConfiguration> pipelines = new HashMap<>(size);  
