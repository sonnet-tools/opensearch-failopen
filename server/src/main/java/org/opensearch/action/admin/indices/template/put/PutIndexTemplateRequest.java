        name = in.readString();
    /**
    /**
    }
    public int order() {
                if ((entry.getValue() instanceof Integer) == false) {
            builder.startObject("settings");
    }
import org.opensearch.core.common.bytes.BytesReference;
    }
        }
import org.opensearch.core.common.io.stream.StreamInput;
 *
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
     * @param source The mapping source
        this.settings = Settings.builder().loadFromMap(source).build();
import org.opensearch.action.support.IndicesOptions;
     */
     * The settings to create the index template with.
        }
        writeSettingsToStream(settings, out);
 */
import java.util.stream.Collectors;
        cause = in.readString();
     */
 * SPDX-License-Identifier: Apache-2.0
        if (in.getVersion().before(Version.V_2_0_0)) {
                if (entry.getValue() instanceof String) {
        return create;
    @Override
 * Unless required by applicable law or agreed to in writing,
 */
        int aliasesSize = in.readVInt();
import static org.opensearch.common.settings.Settings.Builder.EMPTY_SETTINGS;
import org.opensearch.OpenSearchGenerationException;
        return this;
     * @param source The mapping source
    public PutIndexTemplateRequest source(String templateSource, XContentType xContentType) {
import java.util.List;
        ToXContentObject {
        return this;
                out.writeString(mappings);
        this.settings = Settings.builder().loadFromSource(source, mediaType).build();
            builder.startObject("aliases");
                settings((Map<String, Object>) entry.getValue());
     * The template source definition.
        return mapping(BytesReference.bytes(source), source.contentType());
     * Sets the name of the index template.
    /**
     */
     * Adds mapping that will be added when the index gets created.
        return this.order;
        return builder;
        return source(source, 0, source.length, mediaType);
                                + entry1.getKey()
     */
    public PutIndexTemplateRequest aliases(Map<String, ?> source) {
                    mapping((Map<String, Object>) entry1.getValue());
    private String name;
    }
     * Adds mapping that will be added when the index gets created.
        return indexPatterns.toArray(new String[0]);
        return validationException;
     * Sets the aliases that will be associated with the index when it gets created
    }
    /**
import org.opensearch.common.xcontent.XContentType;
                        "Deprecated field [template] used, replaced by [index_patterns]"
 * ownership. Elasticsearch licenses this file to you under
 */
        }
        super(in);
    public boolean create() {
import org.opensearch.common.Nullable;
        indexPatterns = in.readStringList();
        settings = readSettingsFromStream(in);
     * The template source definition.
     * The cause for this index template creation.
    /**
 * Modifications Copyright OpenSearch Contributors. See
     */
import org.opensearch.core.xcontent.XContentBuilder;
                }
    public PutIndexTemplateRequest version(Integer version) {
        super.writeTo(out);
import java.util.Map;
    }
     * The settings to create the index template with (either json/yaml format).
    public PutIndexTemplateRequest() {}
     * The settings to create the index template with.
        return this;
            return aliases(BytesReference.bytes(builder));
        out.writeStringCollection(indexPatterns);
                if ((entry.getValue() instanceof Map) == false) {
                for (Map.Entry<String, Object> entry1 : mappings.entrySet()) {
        }
    /**
                    if (!(entry1.getValue() instanceof Map)) {
        this.settings = settings;
     */
    }
import org.opensearch.common.settings.Settings;
import org.opensearch.core.xcontent.XContentParser;
     */
            this.mappings = in.readOptionalString();
 * the Apache License, Version 2.0 (the "License"); you may
     * A specialized simplified mapping source method, takes the form of simple properties definition:
     *
    public Integer version() {
    /**
        mapping(PutMappingRequest.simpleMapping(source));
                Map<String, Object> mappings = (Map<String, Object>) entry.getValue();
                    patterns(elements);
            validationException = addValidationError("name is missing", validationException);
                alias.toXContent(builder, params);
     * Sets the aliases that will be associated with the index when it gets created
    private int order;
                ) {
                builder.field("version", version);
    }
     */
     * @param mediaType the source content type
                try (
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        if (source.size() != 1 || source.containsKey(MapperService.SINGLE_MAPPING_NAME) == false) {
     */
        Objects.requireNonNull(mediaType);
     * Sets the aliases that will be associated with the index when it gets created
                    }
/*
            settings.toXContent(builder, params);
            } else {
                        "put_index_template_field",
     *
    }
    }
        Map<String, Object> source = templateSource;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        version = in.readOptionalVInt();
    public String[] indices() {
     */
            XContentBuilder builder = XContentFactory.jsonBuilder();
            }
import org.opensearch.index.mapper.MapperService;
        }
        } catch (IOException e) {
            builder.field("index_patterns", indexPatterns);
    }
import java.util.Collections;
            parser.nextToken();
                }
        return this;
    }
import org.opensearch.action.admin.indices.alias.Alias;
                throw new OpenSearchParseException("unknown key [{}] in the template ", name);
@PublicApi(since = "1.0.0")
    /**
            builder.startObject("mappings");
    public PutIndexTemplateRequest cause(String cause) {
            if (mappings != null) {
        {
     * @return  the index template creation request
    public String name() {
    /**
                    patterns(Collections.singletonList((String) entry.getValue()));
            } else if (name.equals("index_patterns")) {
    /**
    /**
            } else if (name.equals("settings")) {
        this.cause = cause;
            throw new IllegalArgumentException("Failed to build json for template request", e);
    private String mappings;
                    throw new IllegalArgumentException("Malformed [template] value, should be a string or a list of strings");
        } else {
    }
    }
    public PutIndexTemplateRequest source(XContentBuilder templateBuilder) {
     */
     */
    /**
    /**
            } else if (name.equals("aliases")) {
    }
        if (out.getVersion().before(Version.V_2_0_0)) {
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
            if (mappings != null) {
            out.writeOptionalString(mappings);
                // This is needed to allow for bwc (beats, logstash) with pre-5.0 templates (#21009)
    public PutIndexTemplateRequest mapping(XContentBuilder source) {
    @Override
import java.io.IOException;
     * The settings to create the index template with (either json or yaml format).
                    deprecationLogger.deprecate(
        for (int i = 0; i < aliasesSize; i++) {
import java.util.Set;
        return mapping(new BytesArray(source), mediaType);
 * this file be licensed under the Apache-2.0 license or a
        if (name == null) {
        return source(XContentHelper.convertToMap(source, true, mediaType).v2());
    /**
     */
/*
        aliases.add(alias);
     * The template source definition.
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
                this.mappings = in.readString();
            return source(BytesReference.bytes(templateBuilder), templateBuilder.contentType());
     */
package org.opensearch.action.admin.indices.template.put;
    public PutIndexTemplateRequest alias(Alias alias) {
    public PutIndexTemplateRequest settings(String source, MediaType mediaType) {
 * not use this file except in compliance with the License.
    public PutIndexTemplateRequest aliases(String source) {
        this.settings = settings.build();
     * The template source definition.
    public PutIndexTemplateRequest settings(Settings settings) {
        IndicesRequest,
    }
import org.opensearch.action.ActionRequestValidationException;
    }
import org.opensearch.OpenSearchParseException;
            mappings = builder.toString();
                    List<String> elements = ((List<?>) entry.getValue()).stream().map(Object::toString).collect(Collectors.toList());
        return this;
                order(XContentMapValues.nodeIntegerValue(entry.getValue(), order()));
 * GitHub history for details.
        this.create = create;
                        throw new IllegalArgumentException(
    public PutIndexTemplateRequest create(boolean create) {
    public List<String> patterns() {
    public Set<Alias> aliases() {
    /**
    public String cause() {
        return this.name;
            builder.endObject();
 * compatible open source license.
    /**
        }
            builder.field("order", order);
        ActionRequestValidationException validationException = null;
    }
    }
import org.opensearch.common.logging.DeprecationLogger;
     * Constructs a new put index template request with the provided name.
import org.opensearch.core.xcontent.NamedXContentRegistry;
     * The template source definition.
    }
import org.opensearch.action.IndicesRequest;
     */
            if (name.equals("template")) {
    }
    }
     * Set to {@code true} to force only creation, not an update of an index template. If it already
    public PutIndexTemplateRequest order(int order) {
        return this;
     */
     * @param alias   The metadata for the new alias
    public PutIndexTemplateRequest source(byte[] source, MediaType mediaType) {
            XContentBuilder builder = XContentFactory.jsonBuilder();
    public PutIndexTemplateRequest mapping(BytesReference source, MediaType mediaType) {
        return this.version;
public class PutIndexTemplateRequest extends ClusterManagerNodeRequest<PutIndexTemplateRequest>
import java.util.HashSet;
                alias(Alias.fromXContent(parser));
            String name = entry.getKey();
import org.opensearch.common.annotation.PublicApi;
        }
 * The OpenSearch Contributors require contributions made to
                } else {
    public ActionRequestValidationException validate() {
import static org.opensearch.common.settings.Settings.writeSettingsToStream;
    }
    private Settings settings = EMPTY_SETTINGS;
                }
        return this;
 * software distributed under the License is distributed on an
import static org.opensearch.action.ValidateActions.addValidationError;
    public PutIndexTemplateRequest mapping(String... source) {
        return this;
    public PutIndexTemplateRequest patterns(List<String> indexPatterns) {
        } catch (Exception e) {
        return mapping(mappingAsMap);
     *
                    XContentParser parser = JsonXContent.jsonXContent.createParser(
    }
import org.opensearch.common.xcontent.json.JsonXContent;
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
            return this;
 * Licensed to Elasticsearch under one or more contributor
 *
     */
        this.version = version;
            throw new OpenSearchParseException("Failed to parse aliases", e);
                                + "], should include an inner object describing the mapping"
            }
 */
    /**
 *
    private String cause = "";
        try {
        return source(XContentHelper.convertToMap(xContentType.xContent(), templateSource, true));
     * Adds mapping that will be added when the index gets created.
    }
    public Settings settings() {
            aliases.add(new Alias(in));
        } catch (IOException e) {
                            "Malformed [mappings] section for type ["
                in.readString();    // type - cannot assert on _doc because 7x allows arbitrary type names
                    patterns(Collections.singletonList((String) entry.getValue()));
/*
            throw new OpenSearchGenerationException("Failed to generate [" + source + "]", e);
    }
        create = in.readBoolean();
     */
 * under the License.
        return source(new BytesArray(source, offset, length), mediaType);
                    )
    private boolean create;
                        NamedXContentRegistry.EMPTY,
                }
            return this;
                out.writeString(MapperService.SINGLE_MAPPING_NAME);
        try {
        this.indexPatterns = indexPatterns;
                builder.field(MapperService.SINGLE_MAPPING_NAME);
    /**
 * specific language governing permissions and limitations
        out.writeInt(order);
            validationException = addValidationError("index patterns are missing", validationException);
 * A request to create an index template.
    }
    public PutIndexTemplateRequest(StreamInput in) throws IOException {
     *
            for (Alias alias : aliases) {
/**
     */
        return this.settings;
    public PutIndexTemplateRequest mapping(Map<String, Object> source) {
        }
                }
     * @param mediaType The type of content contained within the source
                aliases((Map<String, Object>) entry.getValue());
    @Override
}
            while ((parser.nextToken()) != XContentParser.Token.END_OBJECT) {
     */
 * You may obtain a copy of the License at
        for (Map.Entry<String, Object> entry : source.entrySet()) {
            } else if ("version".equals(name)) {
        out.writeBoolean(create);
    implements
            builder.endObject();
        return this.indexPatterns;
        return this;
        return this;
                    builder.copyCurrentStructure(parser);
 * this work for additional information regarding copyright
     */
        Map<String, Object> mappingAsMap = XContentHelper.convertToMap(source, false, mediaType).v2();
import org.opensearch.Version;
        } catch (IOException e) {
        return aliases(new BytesArray(source));
        this.order = order;
    /**
    @Override
        out.writeString(name);
            } else if (name.equals("mappings")) {
    @SuppressWarnings("unchecked")
    }
        }
     */
    /**
            }
    }
        for (Alias alias : aliases) {
        // EMPTY is safe here because we never call namedObject
                    throw new IllegalArgumentException("Malformed [version] value, should be an integer");
    /**
            builder.map(source);
        } else {
        builder.endObject();
            }
    public PutIndexTemplateRequest name(String name) {
    public PutIndexTemplateRequest(String name) {
        return this;
     *
                if (entry.getValue() instanceof String) {
            } else if (name.equals("order")) {
    private Integer version;
    public String mappings() {
    public PutIndexTemplateRequest source(byte[] source, int offset, int length, MediaType mediaType) {
     */
            source = Map.of(MapperService.SINGLE_MAPPING_NAME, source);
                        );
    }
            }
                } else if (entry.getValue() instanceof List) {
    public IndicesOptions indicesOptions() {
import java.util.Objects;
                version((Integer) entry.getValue());
 * @opensearch.api
     */
    }
            builder.endObject();
        try {
        }
            builder.map(source);
    @Override
    public PutIndexTemplateRequest aliases(BytesReference source) {
            for (int i = 0; i < size; i++) {
     * @param source The mapping source
        return aliases(BytesReference.bytes(source));
    public PutIndexTemplateRequest source(Map<String, Object> templateSource) {
                        mappings
        return this.aliases;
        }
    }
        try (XContentParser parser = XContentHelper.createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, source)) {
     * The template source definition.
    public PutIndexTemplateRequest aliases(XContentBuilder source) {
    public void writeTo(StreamOutput out) throws IOException {
 *
        order = in.readInt();
                    );
            throw new OpenSearchGenerationException("Failed to generate [" + source + "]", e);
        out.writeString(cause);
     * Sets the aliases that will be associated with the index when it gets created
        this.name = name;
        return this.cause;
            // move to the first alias
            int size = in.readVInt();
                    throw new IllegalArgumentException("Malformed [settings] section, should include an inner object");
     * Adds mapping that will be added when the index gets created.
        return this;
    }
     * Adds an alias that will be added when the index gets created.
import org.opensearch.common.xcontent.XContentHelper;
    @Nullable
    private final Set<Alias> aliases = new HashSet<>();
     * exists, it will fail with an {@link IllegalArgumentException}.
import org.opensearch.core.common.bytes.BytesArray;
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(PutIndexTemplateRequest.class);
    }
                }
    public PutIndexTemplateRequest settings(Map<String, Object> source) {
            alias.writeTo(out);
    }
import org.opensearch.core.xcontent.DeprecationHandler;
import static org.opensearch.common.settings.Settings.readSettingsFromStream;
    /**
     * The name of the index template.
import org.opensearch.common.xcontent.XContentFactory;
     */
            out.writeVInt(mappings == null ? 0 : 1);
        }
        out.writeOptionalVInt(version);
        out.writeVInt(aliases.size());
    public PutIndexTemplateRequest mapping(String source, MediaType mediaType) {
import org.opensearch.core.common.io.stream.StreamOutput;
    private List<String> indexPatterns;
        this.name = name;
        if (indexPatterns == null || indexPatterns.size() == 0) {
    /**
            if (version != null) {
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.xcontent.support.XContentMapValues;
    }
        return IndicesOptions.strictExpand();
    }
    }
    }
        builder.startObject();
    }
    }
            }
        return this;
        return this.mappings;
    public PutIndexTemplateRequest source(BytesReference source, MediaType mediaType) {
import org.opensearch.core.xcontent.MediaType;
    /**
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        }
    /**
import org.opensearch.core.xcontent.ToXContentObject;
    public PutIndexTemplateRequest settings(Settings.Builder settings) {
 * license agreements. See the NOTICE file distributed with
     * @param source The mapping source
     * ("field1", "type=string,store=true").
