            builder.field(COMPOSED_OF.getPreferredName(), this.componentTemplates);
import static java.util.Collections.unmodifiableMap;  
        return builder;
        builder.startObject();
    public ComposableIndexTemplate(
        @Nullable DataStreamTemplate dataStreamTemplate
    private static final ParseField TEMPLATE = new ParseField("template");  
    private static final ParseField PRIORITY = new ParseField("priority");
        @Override
        a -> new ComposableIndexTemplate(  
import java.io.IOException;
        out.writeOptionalStringCollection(this.componentTemplates);
}
    }
 */  
 * The OpenSearch Contributors require contributions made to  
        this(indexPatterns, template, componentTemplates, priority, version, metadata, null, null);
    private final Long version;
 *  
            args -> new DataStreamTemplate((TimestampField) args[0])
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;  
import org.opensearch.core.common.Strings;
            (Map<String, Object>) a[5],  
        }
    }
    private final Template template;
    private final DataStreamTemplate dataStreamTemplate;
 * under the License.  
        this.version = version;  
            && Objects.equals(this.componentTemplates, other.componentTemplates)  
    }  
 *
            out.writeBoolean(true);
        if (in.readBoolean()) {
    public static ComposableIndexTemplate parse(XContentParser parser) throws IOException {
        }
        this.version = in.readOptionalVLong();  
import org.opensearch.core.xcontent.ToXContentObject;
        out.writeOptionalVLong(this.priority);  
            builder.field(DATA_STREAM.getPreferredName(), dataStreamTemplate);
        if (this.context != null) {
    @Override
        if (this.componentTemplates != null) {
    public static class DataStreamTemplate implements Writeable, ToXContentObject {
 * Modifications Copyright OpenSearch Contributors. See
        return componentTemplates;
        }
import org.opensearch.index.mapper.MapperService;  
        if (this.dataStreamTemplate != null) {
        builder.endObject();
            builder.field(TEMPLATE.getPreferredName(), this.template);
/*  
import java.util.Map;
            builder.field(CONTEXT.getPreferredName(), context);
        @Nullable Context context  
        return AbstractDiffable.readDiffFrom(ComposableIndexTemplate::new, in);
        public TimestampField getTimestampField() {
            return Objects.hash(timestampField);
    public Template template() {  
    @SuppressWarnings("unchecked")
    }
 * An index template is comprised of a set of index patterns, an optional template, and a list of  
            this.context = null;  
        PARSER.declareStringArray(ConstructingObjectParser.optionalConstructorArg(), COMPOSED_OF);  
            this.template = new Template(in);  
            && Objects.equals(this.template, other.template)
            this.dataStreamTemplate,
 * software distributed under the License is distributed on an
        @Override
     */
            this.template,  
        return Objects.equals(this.indexPatterns, other.indexPatterns)
    }  
        }
            return Objects.equals(timestampField, that.timestampField);
    public Context context() {
        }  
            );
        if (in.getVersion().onOrAfter(Version.V_2_16_0)) {  
    public String toString() {  
 * Licensed to Elasticsearch under one or more contributor  
        }  
        if (this.template == null) {
        if (this.template != null) {
    }  
        }
        @Nullable List<String> componentTemplates,
        @Nullable Template template,  
    ) {  
 * Unless required by applicable law or agreed to in writing,
    private static final ParseField METADATA = new ParseField("_meta");
    @Override
    }
        this.priority = in.readOptionalVLong();
    private final Context context;
        } else {
    public static final ConstructingObjectParser<ComposableIndexTemplate, Void> PARSER = new ConstructingObjectParser<>(  
        }  
    }
    }
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), Template.PARSER, TEMPLATE);
    static {  
    );
    private final List<String> componentTemplates;  
        );
     *  
    private final Long priority;
        PARSER.declareLong(ConstructingObjectParser.optionalConstructorArg(), PRIORITY);
     * @opensearch.api
 *  
        }
        return PARSER.parse(parser, null);
    private final Map<String, Object> metadata;  
        PARSER.declareLong(ConstructingObjectParser.optionalConstructorArg(), VERSION);
        }
            return builder.startObject().field(TIMESTAMP_FIELD_FIELD.getPreferredName(), getTimestampField()).endObject();
    @Nullable  
 * ownership. Elasticsearch licenses this file to you under  
            this.context  
        if (out.getVersion().onOrAfter(Version.V_2_16_0)) {
        @Nullable Long priority,
    public Long priority() {
        }
        List<String> indexPatterns,
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        @Override  
 *     http://www.apache.org/licenses/LICENSE-2.0
        }  
            this(DataStreamFieldMapper.Defaults.TIMESTAMP_FIELD);  
        out.writeOptionalWriteable(dataStreamTemplate);  
        this.dataStreamTemplate = dataStreamTemplate;
        return version;
            && Objects.equals(this.dataStreamTemplate, other.dataStreamTemplate)
            return 0L;
            && Objects.equals(this.version, other.version)
import org.opensearch.cluster.Diff;  
        public int hashCode() {  
        return Strings.toString(MediaTypeRegistry.JSON, this);
        );  
import org.opensearch.cluster.AbstractDiffable;
        if (this.priority != null) {
        List<String> indexPatterns,
    public int hashCode() {  
            (List<String>) a[0],
        private static final ConstructingObjectParser<DataStreamTemplate, Void> PARSER = new ConstructingObjectParser<>(
        if (getClass() != obj.getClass()) {  
                )  
    @Nullable
            (Template) a[1],
            this.version,  
            DataStreamTemplate that = (DataStreamTemplate) o;
        return dataStreamTemplate;
 *
    }  
        return context;
        return priority;
        public DataStreamTemplate(StreamInput in) throws IOException {
        this(indexPatterns, template, componentTemplates, priority, version, metadata, dataStreamTemplate, null);
import java.util.Objects;  
        if (this.metadata != null) {
            (List<String>) a[2],  
 * index.
package org.opensearch.cluster.metadata;
                singletonMap(  
        return template;
 * specific language governing permissions and limitations
            this.componentTemplates,
        if (priority == null) {
        @Nullable Long priority,  
        ComposableIndexTemplate other = (ComposableIndexTemplate) obj;  
        @Override  
        } else {
            builder.field(PRIORITY.getPreferredName(), priority);
            (Long) a[4],
    }  
    }
            (DataStreamTemplate) a[6],
        @Nullable Map<String, Object> metadata,
            return singletonMap(
    public boolean equals(Object obj) {
        }
            (Long) a[3],
import org.opensearch.index.mapper.DataStreamFieldMapper;
                MapperService.SINGLE_MAPPING_NAME,
            && Objects.equals(this.metadata, other.metadata)  
import org.opensearch.core.xcontent.XContentParser;
    public DataStreamTemplate getDataStreamTemplate() {  
        this.componentTemplates = in.readOptionalStringList();
        out.writeStringCollection(this.indexPatterns);
 */
        return Objects.hash(
    private static final ParseField CONTEXT = new ParseField("context");  
            return timestampField == null ? DataStreamFieldMapper.Defaults.TIMESTAMP_FIELD : timestampField;  
        }
 * ids corresponding to component templates that should be composed in order when creating a new
 * this work for additional information regarding copyright
            builder.field(METADATA.getPreferredName(), metadata);
        static {
        public boolean equals(Object o) {
    @Override
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), Context.PARSER, CONTEXT);
    }
    /**
    @Nullable
        PARSER.declareStringArray(ConstructingObjectParser.constructorArg(), INDEX_PATTERNS);
        builder.field(INDEX_PATTERNS.getPreferredName(), this.indexPatterns);  
            (Context) a[7]
        }  
        }
public class ComposableIndexTemplate extends AbstractDiffable<ComposableIndexTemplate> implements ToXContentObject {
/**
        this.priority = priority;
        public DataStreamTemplate() {
            this.timestampField = timestampField;
        this.componentTemplates = componentTemplates;
        }  
        }
            PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), TimestampField.PARSER, TIMESTAMP_FIELD_FIELD);  
import org.opensearch.core.common.io.stream.StreamOutput;
         * @return a mapping snippet for a backing index with `_data_stream_timestamp` meta field mapper properly configured.
@PublicApi(since = "1.0.0")  
        return indexPatterns;
        out.writeMap(this.metadata);
        @Nullable Long priority,
        @Nullable Long version,
    }  
        this.indexPatterns = indexPatterns;
        this.context = context;  
        public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.common.annotation.PublicApi;  
    ) {  
        return metadata;  
        @Nullable List<String> componentTemplates,
        @Nullable Map<String, Object> metadata
            out.writeOptionalWriteable(context);
    @Nullable
/*  
            this.indexPatterns,
    private static final ParseField DATA_STREAM = new ParseField("data_stream");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Template for data stream.
 */  
        @Nullable Long version,  
        @Nullable Map<String, Object> metadata,
    @Override  
        private final TimestampField timestampField;  
    }
        }  
import java.util.List;
    private static final ParseField COMPOSED_OF = new ParseField("composed_of");
    public void writeTo(StreamOutput out) throws IOException {  
        public static DataStreamTemplate fromXContent(XContentParser parser) {
        private static final ParseField TIMESTAMP_FIELD_FIELD = new ParseField("timestamp_field");  
        "index_template",
    }
            && Objects.equals(this.priority, other.priority)
        }  
 * license agreements. See the NOTICE file distributed with
    public ComposableIndexTemplate(
        @Nullable Template template,
    public Long version() {
    private static final ParseField VERSION = new ParseField("version");  
            this.timestampField = in.readOptionalWriteable(TimestampField::new);
        this.metadata = metadata;
            this.metadata,
        }  
    @Nullable  
        @Nullable List<String> componentTemplates,
                    unmodifiableMap(Map.of("enabled", true, "timestamp_field", getTimestampField().toMap()))
    static Diff<ComposableIndexTemplate> readITV2DiffFrom(StreamInput in) throws IOException {  
            return PARSER.apply(parser, null);  
 * the Apache License, Version 2.0 (the "License"); you may
         */
import org.opensearch.core.ParseField;
 * GitHub history for details.
        if (this.version != null) {
            true,
            this.template.writeTo(out);  
        }
    }
 * @opensearch.api
        )  
    public Map<String, Object> metadata() {
    }  
        }  
import org.opensearch.core.xcontent.ConstructingObjectParser;  
 * KIND, either express or implied.  See the License for the
        public Map<String, Object> getDataStreamMappingSnippet() {  
        @Nullable Template template,  
        this.template = template;  
            return false;
    public ComposableIndexTemplate(
        @Nullable Long version,  
            this.context = in.readOptionalWriteable(Context::new);
import org.opensearch.cluster.metadata.DataStream.TimestampField;
    }
            "data_stream_template",  
 * compatible open source license.
            return Collections.emptyList();  
/*
import org.opensearch.common.Nullable;
            if (this == o) return true;
        if (componentTemplates == null) {
 * You may obtain a copy of the License at  
    ) {
        false,
import org.opensearch.core.common.io.stream.StreamInput;  
        /**  
        }  
import org.opensearch.core.common.io.stream.Writeable;
        out.writeOptionalVLong(this.version);
        }  
            && Objects.equals(this.context, other.context);
import org.opensearch.core.xcontent.XContentBuilder;  
            if (o == null || getClass() != o.getClass()) return false;  
            this.template = null;
    public List<String> indexPatterns() {
            out.writeBoolean(false);  
    @Nullable
import org.opensearch.core.xcontent.MediaTypeRegistry;
            builder.field(VERSION.getPreferredName(), version);
            return false;
    private static final ParseField INDEX_PATTERNS = new ParseField("index_patterns");
    }
                    "_data_stream_timestamp",
import static java.util.Collections.singletonMap;
        return priority;  
    @Nullable
    @PublicApi(since = "1.0.0")  
        @Nullable DataStreamTemplate dataStreamTemplate,
            out.writeOptionalWriteable(timestampField);  
        public DataStreamTemplate(TimestampField timestampField) {  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        List<String> indexPatterns,  
 * SPDX-License-Identifier: Apache-2.0
        if (obj == null) {  
        this.dataStreamTemplate = in.readOptionalWriteable(DataStreamTemplate::new);
    }  
    @Override
    public long priorityOrZero() {  
        } else {
    }  
    @Nullable  
        this.indexPatterns = in.readStringList();
    public ComposableIndexTemplate(StreamInput in) throws IOException {  
import org.opensearch.Version;
            this.priority,
 */
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), DataStreamTemplate.PARSER, DATA_STREAM);
        }  
    private final List<String> indexPatterns;
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), (p, c) -> p.map(), METADATA);  
        this.metadata = in.readMap();
    public List<String> composedOf() {
 * not use this file except in compliance with the License.
