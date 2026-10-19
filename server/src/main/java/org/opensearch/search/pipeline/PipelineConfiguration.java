import org.opensearch.cluster.Diff;  
import org.opensearch.common.annotation.PublicApi;
        return XContentHelper.convertToMap(config, true, mediaType).v2();
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        }
        return result;
    }
    private final BytesReference config;  
    }
            this.config = config;
        return (parser, context) -> PARSER.apply(parser, null).build();  
import org.opensearch.core.xcontent.ToXContentObject;
    }  
    public PipelineConfiguration(String id, BytesReference config, MediaType mediaType) {  
        private MediaType mediaType;
            }
        int result = id.hashCode();  
            in.getVersion().onOrAfter(Version.V_2_10_0) ? in.readMediaType() : in.readEnum(XContentType.class)
/**
import org.opensearch.Version;
 * See if we can refactor into a common class. I suspect not, just because this one will hold
        if (!id.equals(that.id)) return false;
 * SPDX-License-Identifier: Apache-2.0
        private String id;
    // pkg-private for tests
            in.readBytesReference(),  
            if (mediaType instanceof XContentType == false) {
        }
    public void writeTo(StreamOutput out) throws IOException {  
 *  
        PipelineConfiguration.Builder::new
        PipelineConfiguration that = (PipelineConfiguration) o;  
            return new PipelineConfiguration(id, config, mediaType);
 */  
            mediaType.writeTo(out);
import org.opensearch.core.common.io.stream.StreamOutput;
    public static Diff<PipelineConfiguration> readDiffFrom(StreamInput in) throws IOException {
        builder.field("config", getConfigAsMap());
        }
    public static PipelineConfiguration readFrom(StreamInput in) throws IOException {  
 * The OpenSearch Contributors require contributions made to  
    }  
import org.opensearch.common.xcontent.XContentType;  
    }  
 * this file be licensed under the Apache-2.0 license or a
        } else {
        }
        void setConfig(BytesReference config, MediaType mediaType) {
        builder.endObject();
        true,
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.xcontent.MediaTypeRegistry;
/*  
import org.opensearch.core.common.Strings;
            this.id = id;
    static {
 * TODO: Copied verbatim from {@link org.opensearch.ingest.PipelineConfiguration}.  
    }
 * @opensearch.api
                throw new IllegalArgumentException("PipelineConfiguration does not support media type [" + mediaType.getClass() + "]");  
    BytesReference getConfig() {
        this.mediaType = Objects.requireNonNull(mediaType);  
    }
        return Strings.toString(MediaTypeRegistry.JSON, this);
    private final MediaType mediaType;
        "pipeline_config",  
        this.id = Objects.requireNonNull(id);
        builder.startObject();
        return builder;  
 * <p>
    MediaType getMediaType() {  
            in.readString(),
        return config;  
    }
        PARSER.declareString(PipelineConfiguration.Builder::setId, new ParseField("id"));
    @Override
    @Override  
    public static ContextParser<Void, PipelineConfiguration> getParser() {
    }
 * compatible open source license.
package org.opensearch.search.pipeline;
            builder.setConfig(BytesReference.bytes(contentBuilder), contentBuilder.contentType());  
    public boolean equals(Object o) {
import org.opensearch.core.common.bytes.BytesReference;  
    public Map<String, Object> getConfigAsMap() {
}
            this.mediaType = mediaType;  
        out.writeBytesReference(config);
    public String toString() {
import org.opensearch.core.xcontent.ContextParser;  
import org.opensearch.core.xcontent.ObjectParser;  
        );
    }  
        return getConfigAsMap().equals(that.getConfigAsMap());  
        out.writeString(id);
import org.opensearch.common.xcontent.XContentHelper;
import org.opensearch.core.xcontent.MediaType;
        this.config = Objects.requireNonNull(config);
    private static class Builder {  
    // Store config as bytes reference, because the config is only used when the pipeline store reads the cluster state  
@PublicApi(since = "2.7.0")  
    @Override
    @Override
            out.writeEnum((XContentType) mediaType);  
        return id;
        builder.field("id", id);  
        result = 31 * result + getConfigAsMap().hashCode();
import org.opensearch.core.ParseField;
import java.util.Map;
        PARSER.declareField((parser, builder, aVoid) -> {  
    // and the way the map of maps config is read requires a deep copy (it removes instead of gets entries to check for unused options)
        if (o == null || getClass() != o.getClass()) return false;
        void setId(String id) {  
        if (this == o) return true;  
    }  
        private BytesReference config;  
            contentBuilder.generator().copyCurrentStructure(parser);
    public int hashCode() {
        }, new ParseField("config"), ObjectParser.ValueType.OBJECT);
public class PipelineConfiguration extends AbstractDiffable<PipelineConfiguration> implements ToXContentObject {
 *
    }
    public String getId() {  
            XContentBuilder contentBuilder = XContentBuilder.builder(parser.contentType().xContent());
    private final String id;
    // pkg-private for tests
        PipelineConfiguration build() {  
    @Override  
        if (out.getVersion().onOrAfter(Version.V_2_10_0)) {  
    private static final ObjectParser<Builder, Void> PARSER = new ObjectParser<>(
        return readDiffFrom(PipelineConfiguration::readFrom, in);  
import org.opensearch.cluster.AbstractDiffable;
        return mediaType;
import org.opensearch.core.common.io.stream.StreamInput;
        return new PipelineConfiguration(
    }  
    }
    // also the get pipeline api just directly returns this to the caller
    );  
    }
import java.util.Objects;  
 */
import java.io.IOException;
