    }  
import org.opensearch.cluster.Diff;  
    public String getId() {
    static {
    }  
        return readDiffFrom(PipelineConfiguration::readFrom, in);
            this.config = config;  
            out.writeEnum((XContentType) mediaType);
 * ownership. Elasticsearch licenses this file to you under  
        return new PipelineConfiguration(
    @Override
        }
    // pkg-private for tests
    }
 * KIND, either express or implied.  See the License for the
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    @Override
        return (parser, context) -> PARSER.apply(parser, null).build();
    public Map<String, Object> getConfigAsMap() {
        return Strings.toString(MediaTypeRegistry.JSON, this);  
 * GitHub history for details.
import org.opensearch.common.xcontent.XContentHelper;
        }  
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
        }  
        private BytesReference config;
import java.io.IOException;
 */  
    public String toString() {
        this.config = Objects.requireNonNull(config);  
/*
 * this work for additional information regarding copyright
import org.opensearch.core.common.io.stream.StreamOutput;
    BytesReference getConfig() {  
 * under the License.  
    }
import org.opensearch.core.xcontent.ContextParser;  
        }
        builder.startObject();  
        private String id;  
        this.id = Objects.requireNonNull(id);
            this.mediaType = mediaType;
 * software distributed under the License is distributed on an
        this.mediaType = Objects.requireNonNull(mediaType);
package org.opensearch.ingest;
    }
    // pkg-private for tests  
import java.util.Map;
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        builder.endObject();  
        builder.field("id", id);
        void setConfig(BytesReference config, MediaType mediaType) {
    public static PipelineConfiguration readFrom(StreamInput in) throws IOException {
    public PipelineConfiguration(String id, BytesReference config, MediaType mediaType) {
        PipelineConfiguration build() {
    }
    public boolean equals(Object o) {  
    }  
            mediaType.writeTo(out);
        return id;
    public static Diff<PipelineConfiguration> readDiffFrom(StreamInput in) throws IOException {  
        result = 31 * result + getConfigAsMap().hashCode();
 */
    private final MediaType mediaType;
        return mediaType;
 * license agreements. See the NOTICE file distributed with
            return new PipelineConfiguration(id, config, mediaType);
    private static final ObjectParser<Builder, Void> PARSER = new ObjectParser<>("pipeline_config", true, Builder::new);
 * compatible open source license.
 * @opensearch.api
        if (out.getVersion().onOrAfter(Version.V_2_10_0)) {
 * Encapsulates a pipeline's id and configuration as a blob  
/**
 */  
import java.util.Objects;  
import org.opensearch.core.xcontent.ObjectParser;  
    // and the way the map of maps config is read requires a deep copy (it removes instead of gets entries to check for unused options)
        }, new ParseField("config"), ObjectParser.ValueType.OBJECT);
import org.opensearch.common.annotation.PublicApi;
    }
import org.opensearch.core.xcontent.ToXContentObject;
        return XContentHelper.convertToMap(config, true, mediaType).v2();  
        } else {  
 *
 * You may obtain a copy of the License at  
    @Override
    private static class Builder {
import org.opensearch.core.xcontent.MediaType;
    }
 * The OpenSearch Contributors require contributions made to  
    public static ContextParser<Void, PipelineConfiguration> getParser() {  
            builder.setConfig(BytesReference.bytes(contentBuilder), contentBuilder.contentType());
            this.id = id;
    @Override  
 * Modifications Copyright OpenSearch Contributors. See
 *
                throw new IllegalArgumentException("PipelineConfiguration does not support media type [" + mediaType.getClass() + "]");
@PublicApi(since = "1.0.0")
import org.opensearch.common.xcontent.XContentType;  
            in.readString(),  
public final class PipelineConfiguration extends AbstractDiffable<PipelineConfiguration> implements ToXContentObject {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
        PipelineConfiguration that = (PipelineConfiguration) o;
        PARSER.declareField((parser, builder, aVoid) -> {
    // Store config as bytes reference, because the config is only used when the pipeline store reads the cluster state
 * the Apache License, Version 2.0 (the "License"); you may
        if (!id.equals(that.id)) return false;  
        );  
 *
    private final BytesReference config;
    public int hashCode() {  
        if (o == null || getClass() != o.getClass()) return false;
    }
        out.writeBytesReference(config);  
/*  
            }
    }
 * not use this file except in compliance with the License.
        builder.field("config", getConfigAsMap());
import org.opensearch.core.common.bytes.BytesReference;  
import org.opensearch.cluster.AbstractDiffable;
        PARSER.declareString(Builder::setId, new ParseField("id"));  
            in.getVersion().onOrAfter(Version.V_2_10_0) ? in.readMediaType() : in.readEnum(XContentType.class)
/*  
 *  
        out.writeString(id);
import org.opensearch.core.ParseField;
        if (this == o) return true;
    private final String id;  
        return builder;
            if (mediaType instanceof XContentType == false) {  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.xcontent.XContentBuilder;
        void setId(String id) {
 * SPDX-License-Identifier: Apache-2.0
    MediaType getMediaType() {
    // also the get pipeline api just directly returns this to the caller  
    public void writeTo(StreamOutput out) throws IOException {
    }  
            contentBuilder.generator().copyCurrentStructure(parser);  
            XContentBuilder contentBuilder = XContentBuilder.builder(parser.contentType().xContent());
 * specific language governing permissions and limitations
        return getConfigAsMap().equals(that.getConfigAsMap());
import org.opensearch.Version;
        return config;
}
    }
 */  
        int result = id.hashCode();
import org.opensearch.core.common.Strings;
            in.readBytesReference(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return result;  
        private MediaType mediaType;
