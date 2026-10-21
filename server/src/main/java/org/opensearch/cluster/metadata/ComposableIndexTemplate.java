        a -> new ComposableIndexTemplate(
        return context;
    }
        @Override
        }
        out.writeOptionalStringCollection(this.componentTemplates);
        }
        out.writeStringCollection(this.indexPatterns);
import org.opensearch.cluster.metadata.DataStream.TimestampField;
 *
 * You may obtain a copy of the License at
        List<String> indexPatterns,
 * not use this file except in compliance with the License.
        @Nullable Map<String, Object> metadata,
    }
        }
    }
    public String toString() {
        out.writeOptionalVLong(this.priority);
        }
    private final DataStreamTemplate dataStreamTemplate;
            return false;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.cluster.Diff;
        public int hashCode() {
        if (componentTemplates == null) {
        this.metadata = in.readMap();
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), Context.PARSER, CONTEXT);
 * Modifications Copyright OpenSearch Contributors. See
                )
 * index.
import java.io.IOException;
        public static DataStreamTemplate fromXContent(XContentParser parser) {
    @SuppressWarnings("unchecked")
        } else {
        }
        return dataStreamTemplate;
        this.componentTemplates = componentTemplates;
    private final Long priority;
            return Collections.emptyList();
    public List<String> indexPatterns() {
    }
     * @opensearch.api
        if (in.getVersion().onOrAfter(Version.V_2_16_0)) {
        }
public class ComposableIndexTemplate extends AbstractDiffable<ComposableIndexTemplate> implements ToXContentObject {
        PARSER.declareLong(ConstructingObjectParser.optionalConstructorArg(), VERSION);
            this(DataStreamFieldMapper.Defaults.TIMESTAMP_FIELD);
    public Long version() {
import org.opensearch.core.xcontent.XContentBuilder;
            (List<String>) a[2],
    private static final ParseField COMPOSED_OF = new ParseField("composed_of");
        this.indexPatterns = indexPatterns;
        return componentTemplates;
    public Template template() {
 *
        }
 * An index template is comprised of a set of index patterns, an optional template, and a list of
            return timestampField == null ? DataStreamFieldMapper.Defaults.TIMESTAMP_FIELD : timestampField;
    );
        }
            return Objects.equals(timestampField, that.timestampField);
        @Nullable DataStreamTemplate dataStreamTemplate
 * Unless required by applicable law or agreed to in writing,
    private static final ParseField INDEX_PATTERNS = new ParseField("index_patterns");
    static Diff<ComposableIndexTemplate> readITV2DiffFrom(StreamInput in) throws IOException {
            this.context = in.readOptionalWriteable(Context::new);
        return PARSER.parse(parser, null);
        @Nullable Template template,
    public ComposableIndexTemplate(
            this.timestampField = in.readOptionalWriteable(TimestampField::new);
 * SPDX-License-Identifier: Apache-2.0
    @Nullable
        @Nullable List<String> componentTemplates,
            return builder.startObject().field(TIMESTAMP_FIELD_FIELD.getPreferredName(), getTimestampField()).endObject();
    @Nullable
        private final TimestampField timestampField;
import org.opensearch.core.ParseField;
            builder.field(COMPOSED_OF.getPreferredName(), this.componentTemplates);
package org.opensearch.cluster.metadata;
        @Override
 */
        );
        return AbstractDiffable.readDiffFrom(ComposableIndexTemplate::new, in);
        );
            builder.field(TEMPLATE.getPreferredName(), this.template);
        } else {
        public Map<String, Object> getDataStreamMappingSnippet() {
    private static final ParseField VERSION = new ParseField("version");
        public void writeTo(StreamOutput out) throws IOException {
            && Objects.equals(this.componentTemplates, other.componentTemplates)
     *
 * this work for additional information regarding copyright
    }
 * Licensed to Elasticsearch under one or more contributor
        public DataStreamTemplate(TimestampField timestampField) {
        }
        return priority;
        }
        this.template = template;
    public long priorityOrZero() {
 *
/*
            (Context) a[7]
        @Nullable List<String> componentTemplates,
 * software distributed under the License is distributed on an
        PARSER.declareLong(ConstructingObjectParser.optionalConstructorArg(), PRIORITY);
        if (this.version != null) {
    }
            args -> new DataStreamTemplate((TimestampField) args[0])
        if (this.template == null) {
    }
            );
    public Long priority() {
            builder.field(DATA_STREAM.getPreferredName(), dataStreamTemplate);
    private static final ParseField METADATA = new ParseField("_meta");
            return singletonMap(
    public Map<String, Object> metadata() {
        private static final ParseField TIMESTAMP_FIELD_FIELD = new ParseField("timestamp_field");
        "index_template",
        @Nullable DataStreamTemplate dataStreamTemplate,
    public int hashCode() {
 * compatible open source license.
 */
        PARSER.declareStringArray(ConstructingObjectParser.optionalConstructorArg(), COMPOSED_OF);
            (Template) a[1],
    public static final ConstructingObjectParser<ComposableIndexTemplate, Void> PARSER = new ConstructingObjectParser<>(
 * license agreements. See the NOTICE file distributed with
        @Nullable Map<String, Object> metadata
        List<String> indexPatterns,
    @Override
        @Nullable Long version,
 */
            this.context
    @Nullable
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), (p, c) -> p.map(), METADATA);
        @Nullable Long priority,
            this.template = new Template(in);
        }
        if (this.template != null) {
        public TimestampField getTimestampField() {
        this.priority = priority;
        if (obj == null) {
        }
        }
    private static final ParseField PRIORITY = new ParseField("priority");
                singletonMap(
        @Override
 * The OpenSearch Contributors require contributions made to
            && Objects.equals(this.dataStreamTemplate, other.dataStreamTemplate)
        return template;
        public DataStreamTemplate(StreamInput in) throws IOException {
    ) {
        builder.endObject();
        out.writeOptionalWriteable(dataStreamTemplate);
@PublicApi(since = "1.0.0")
        }
import java.util.Objects;
            out.writeOptionalWriteable(timestampField);
            this.template = null;
        }
 *
        if (this.componentTemplates != null) {
        }
        }
    static {
            this.template,
            out.writeBoolean(false);
    }
        this(indexPatterns, template, componentTemplates, priority, version, metadata, dataStreamTemplate, null);
            out.writeOptionalWriteable(context);
 * KIND, either express or implied.  See the License for the
import org.opensearch.Version;
        @Nullable Long version,
        }
        this.dataStreamTemplate = in.readOptionalWriteable(DataStreamTemplate::new);
    }
            if (this == o) return true;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        if (priority == null) {
 * ids corresponding to component templates that should be composed in order when creating a new
    public ComposableIndexTemplate(
import org.opensearch.core.xcontent.ToXContentObject;
    private final List<String> indexPatterns;
        this.version = in.readOptionalVLong();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.core.common.io.stream.StreamInput;
            this.context = null;
        out.writeOptionalVLong(this.version);
 * under the License.
        return builder;
import org.opensearch.core.xcontent.ConstructingObjectParser;
/*
            PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), TimestampField.PARSER, TIMESTAMP_FIELD_FIELD);
    private static final ParseField TEMPLATE = new ParseField("template");
        this.version = version;
        return metadata;
    public Context context() {
    }
    private final Context context;
    }
import org.opensearch.index.mapper.DataStreamFieldMapper;
    @Nullable
        }
        public DataStreamTemplate() {
import java.util.Map;
            this.metadata,
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Nullable
        if (getClass() != obj.getClass()) {
    public void writeTo(StreamOutput out) throws IOException {
    ) {
        this.componentTemplates = in.readOptionalStringList();
    }
        return version;
        @Override
                    unmodifiableMap(Map.of("enabled", true, "timestamp_field", getTimestampField().toMap()))
        @Nullable Template template,
import org.opensearch.core.xcontent.XContentParser;
        if (out.getVersion().onOrAfter(Version.V_2_16_0)) {
        builder.field(INDEX_PATTERNS.getPreferredName(), this.indexPatterns);
                MapperService.SINGLE_MAPPING_NAME,
        this.context = context;
        if (in.readBoolean()) {
            return PARSER.apply(parser, null);
            this.version,
    @Nullable
     */
import org.opensearch.core.common.io.stream.StreamOutput;
        @Nullable Long priority,
/*
        }
            "data_stream_template",
        )
    }
import java.util.List;
    ) {
    }
        out.writeMap(this.metadata);
            (Long) a[3],
 */
            && Objects.equals(this.template, other.template)
import org.opensearch.common.Nullable;
 * this file be licensed under the Apache-2.0 license or a
    private final List<String> componentTemplates;
        return priority;
        this.indexPatterns = in.readStringList();
        return Strings.toString(MediaTypeRegistry.JSON, this);
        this.metadata = metadata;
            true,
        ComposableIndexTemplate other = (ComposableIndexTemplate) obj;
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), Template.PARSER, TEMPLATE);
    }
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), DataStreamTemplate.PARSER, DATA_STREAM);
            (DataStreamTemplate) a[6],
            this.dataStreamTemplate,
        private static final ConstructingObjectParser<DataStreamTemplate, Void> PARSER = new ConstructingObjectParser<>(
    private final Map<String, Object> metadata;
        false,
        }
        this.dataStreamTemplate = dataStreamTemplate;
            if (o == null || getClass() != o.getClass()) return false;
            this.componentTemplates,
            builder.field(METADATA.getPreferredName(), metadata);
        List<String> indexPatterns,
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    private final Template template;
 * specific language governing permissions and limitations
        this(indexPatterns, template, componentTemplates, priority, version, metadata, null, null);
    }
    @Nullable
        /**
/**
            this.priority,
    private static final ParseField DATA_STREAM = new ParseField("data_stream");
    public List<String> composedOf() {
        return indexPatterns;
            (Long) a[4],
            this.timestampField = timestampField;
            DataStreamTemplate that = (DataStreamTemplate) o;
            (List<String>) a[0],
 * GitHub history for details.
import static java.util.Collections.unmodifiableMap;
        }
        public boolean equals(Object o) {
            return Objects.hash(timestampField);
        }
        return Objects.hash(
        if (this.metadata != null) {
import org.opensearch.core.common.io.stream.Writeable;
    }
        if (this.dataStreamTemplate != null) {
    }
}
    @Override
        }
import java.util.Collections;
import org.opensearch.common.annotation.PublicApi;
            (Map<String, Object>) a[5],
    private final Long version;
        if (this.priority != null) {
        PARSER.declareStringArray(ConstructingObjectParser.constructorArg(), INDEX_PATTERNS);
            builder.field(VERSION.getPreferredName(), version);
import org.opensearch.index.mapper.MapperService;
        }
        @Nullable Context context
 * ownership. Elasticsearch licenses this file to you under
        this.priority = in.readOptionalVLong();
    public boolean equals(Object obj) {
        builder.startObject();
         * @return a mapping snippet for a backing index with `_data_stream_timestamp` meta field mapper properly configured.
    @PublicApi(since = "1.0.0")
    @Nullable
            builder.field(CONTEXT.getPreferredName(), context);
            out.writeBoolean(true);
        @Nullable List<String> componentTemplates,
        @Nullable Map<String, Object> metadata,
    private static final ParseField CONTEXT = new ParseField("context");
            this.template.writeTo(out);
    @Override
        @Nullable Template template,
        } else {
            && Objects.equals(this.version, other.version)
        static {
    }
    public ComposableIndexTemplate(StreamInput in) throws IOException {
    }
import org.opensearch.core.xcontent.MediaTypeRegistry;
            && Objects.equals(this.metadata, other.metadata)
            return 0L;
 * @opensearch.api
    @Override
            && Objects.equals(this.context, other.context);
import org.opensearch.cluster.AbstractDiffable;
    @Override
        @Nullable Long version,
        @Nullable Long priority,
    }
    /**
            return false;
                    "_data_stream_timestamp",
    public static class DataStreamTemplate implements Writeable, ToXContentObject {
            builder.field(PRIORITY.getPreferredName(), priority);
         */
            && Objects.equals(this.priority, other.priority)
        }
        return Objects.equals(this.indexPatterns, other.indexPatterns)
    public ComposableIndexTemplate(
        if (this.context != null) {
import static java.util.Collections.singletonMap;
    public static ComposableIndexTemplate parse(XContentParser parser) throws IOException {
    public DataStreamTemplate getDataStreamTemplate() {
    }
import org.opensearch.core.common.Strings;
            this.indexPatterns,
     * Template for data stream.
