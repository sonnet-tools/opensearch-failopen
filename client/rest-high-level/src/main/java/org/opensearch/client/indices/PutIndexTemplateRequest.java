            while ((parser.nextToken()) != XContentParser.Token.END_OBJECT) {
     */
    private BytesReference mappings = null;
    public PutIndexTemplateRequest source(byte[] source, MediaType mediaType) {
    }
                return this;
    }
    }
            builder.field("version", version);
     */
    public PutIndexTemplateRequest settings(Map<String, Object> source) {
    @Override
     */
    /**
    public PutIndexTemplateRequest source(String templateSource, MediaType mediaType) {
/*
                version((Integer) entry.getValue());
    }
    public PutIndexTemplateRequest name(String name) {
        return this;
     *
    /**
            )
 * Unless required by applicable law or agreed to in writing,
    /**
    public PutIndexTemplateRequest source(BytesReference source, MediaType mediaType) {
 * KIND, either express or implied.  See the License for the
     */
    /**
    /**
    }
import org.opensearch.action.admin.indices.alias.Alias;
    }
    @Deprecated
import org.opensearch.common.xcontent.XContentFactory;
     */
        try (
import org.opensearch.core.xcontent.DeprecationHandler;
import static org.opensearch.common.settings.Settings.Builder.EMPTY_SETTINGS;
import java.util.Set;
     * The template source definition.
        return this;
        try {
            builder.field("index_patterns", indexPatterns);
    private PutIndexTemplateRequest internalMapping(Map<String, Object> source) {
    /**
        return this.name;
     *
 * compatible open source license.
    public PutIndexTemplateRequest aliases(Map<String, ?> source) {
        if (name == null) {
    /**
    @Deprecated
    public PutIndexTemplateRequest cause(String cause) {
    public PutIndexTemplateRequest source(String templateSource, XContentType xContentType) {
     * The template source definition.
        ActionRequestValidationException validationException = null;
        return validationException;
            builder.map(source);
import static org.opensearch.action.ValidateActions.addValidationError;
     * Sets the aliases that will be associated with the index when it gets created
        ) {
            } else if (name.equals("order")) {
     * Sets the name of the index template.
 *
        return source(XContentHelper.convertToMap(mediaType.xContent(), templateSource, true));
    /**
 * You may obtain a copy of the License at
/*
    }
        if (version != null) {
import org.opensearch.core.xcontent.MediaType;
    private String template;
    }
            MediaType mediaType = builder.contentType();
            builder.map(source);
 * this work for additional information regarding copyright
import org.opensearch.common.xcontent.XContentHelper;
import org.opensearch.core.xcontent.XContentParser;
    /**
     * The template source definition.
        } else {
    }
        return IndicesOptions.strictExpand();
                }
 */
     *
import org.opensearch.core.xcontent.MediaTypeRegistry;
    private String name;
    /**
            throw new OpenSearchGenerationException("Failed to generate [" + source + "]", e);
        return builder;
        return this.indexPatterns;
import org.opensearch.core.xcontent.XContentBuilder;
        return source(XContentHelper.convertToMap(source, true, mediaType).v2());
    public String name() {
    }
        this.settings = settings.build();
    }
    @Deprecated
        Map<String, Object> source = templateSource;
     */
                if ((entry.getValue() instanceof Integer) == false) {
    private String cause = "";
    }
    public PutIndexTemplateRequest settings(String source, XContentType xContentType) {
        }
    }
    }
    public PutIndexTemplateRequest aliases(String source) {
    public IndicesOptions indicesOptions() {
     * Adds an alias that will be added when the index gets created.
        }
            } else if (name.equals("mappings")) {
            alias.toXContent(builder, params);
        return this.cause;
     */
    /**
        if (template != null) {
     * 'index_patterns' to ensure that the server emits a deprecation warning when it's been set.
        builder.endObject();
        return aliases(new BytesArray(source));
    public boolean create() {
        this.name = name;
import java.io.IOException;
    /**
 * Modifications Copyright OpenSearch Contributors. See
        }
                NamedXContentRegistry.EMPTY,
                    DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
     * Constructs a new put index template request with the provided name.
                throw new UncheckedIOException("failed to convert source to json", e);
                } else {
    /**
     *
 *
     * Set to {@code true} to force only creation, not an update of an index template. If it already
import java.io.UncheckedIOException;
    }
     * Adds mapping that will be added when the index gets created.
     * 'index_patterns' in 6.0. It is stored and rendered to xContent separately from
                    patterns(Collections.singletonList((String) entry.getValue()));
    /**
    }
        return this;
            return this;
        try {
            }
     *
    public PutIndexTemplateRequest source(byte[] source, int offset, int length, XContentType xContentType) {
import java.util.stream.Collectors;
    public PutIndexTemplateRequest order(int order) {
        builder.endObject();
     */
    @Override
 * The OpenSearch Contributors require contributions made to
            }
/**
     */
     * @return  the index template creation request
            return source(BytesReference.bytes(templateBuilder), templateBuilder.contentType());
        return this;
 */
    public String cause() {
                aliases((Map<String, Object>) entry.getValue());
        }
    public BytesReference mappings() {
package org.opensearch.client.indices;
                order(XContentMapValues.nodeIntegerValue(entry.getValue(), order()));
        builder.field("order", order);
 * Licensed to Elasticsearch under one or more contributor
 */
                mapping(mappings);
        this.settings = Settings.builder().loadFromSource(source, xContentType).build();
        builder.startObject("settings");
        return source(XContentHelper.convertToMap(xContentType.xContent(), templateSource, true));
     */
            String name = entry.getKey();
     * The template source definition.
        return this.aliases;
            } catch (IOException e) {
        return this;
            parser.nextToken();
    /**
    public PutIndexTemplateRequest source(Map<String, Object> templateSource) {
            } else if ("version".equals(name)) {
        aliases.add(alias);
     * @param alias   The metadata for the new alias
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
    public PutIndexTemplateRequest mapping(Map<String, Object> source) {
        return this;
    /**
     */
     * @param mediaType The type of content contained within the source
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.xcontent.ToXContentFragment;
    /**
            } else {
    public PutIndexTemplateRequest source(byte[] source, int offset, int length, MediaType mediaType) {
     */
 * software distributed under the License is distributed on an
                XContentParser parser = JsonXContent.jsonXContent.createParser(
                source
    public PutIndexTemplateRequest mapping(String source, MediaType mediaType) {
     */
                throw new OpenSearchParseException("unknown key [{}] in the template ", name);
    public List<String> patterns() {
     */
    public PutIndexTemplateRequest version(Integer version) {
import org.opensearch.core.xcontent.NamedXContentRegistry;
    public PutIndexTemplateRequest source(XContentBuilder templateBuilder) {
     */
            } else if (name.equals("index_patterns")) {
        }
        return source(new BytesArray(source, offset, length), mediaType);
    /**
import org.opensearch.core.common.bytes.BytesReference;
        return this;
        try {
    /**
import java.util.Map;
        } catch (Exception e) {
                    mappings.utf8ToString()
        }
 * A request to create an index template.
    }
import java.util.Collections;
 *    http://www.apache.org/licenses/LICENSE-2.0
     * The template source definition.
 *
            validationException = addValidationError("index patterns are missing", validationException);
    @Deprecated
            builder.field("mappings");
 * under the License.
     *
                if ((entry.getValue() instanceof Map) == false) {
    public PutIndexTemplateRequest settings(Settings settings) {
     * Adds mapping that will be added when the index gets created.
    public ActionRequestValidationException validate() {
            throw new OpenSearchGenerationException("Failed to generate [" + source + "]", e);
        }
     * The template source definition.
     * The template source definition.
    private List<String> indexPatterns;
import java.util.HashSet;
    }
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
    }
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
     * Sets the aliases that will be associated with the index when it gets created
     * The settings to create the index template with (either json or yaml format).
                if (entry.getValue() instanceof String) {
    public PutIndexTemplateRequest create(boolean create) {
    }
                alias(Alias.fromXContent(parser));
    }
        // EMPTY is safe here because we never call namedObject
                )
    private final Set<Alias> aliases = new HashSet<>();
        this.settings = Settings.builder().loadFromMap(source).build();
    public PutIndexTemplateRequest source(BytesReference source, XContentType xContentType) {
 */
        internalMapping(XContentHelper.convertToMap(source, true, xContentType).v2());
    public PutIndexTemplateRequest aliases(BytesReference source) {
        if (template == null && (indexPatterns == null || indexPatterns.size() == 0)) {
     * The template source definition.
import java.util.List;
        } catch (IOException e) {
    }
        return this.settings;
                mappings = new BytesArray(XContentHelper.convertToJson(BytesReference.bytes(builder), false, false, mediaType));
        return this;
     * The settings to create the index template with (either json/yaml format).
 * this file be licensed under the Apache-2.0 license or a
            } else if (name.equals("aliases")) {
    public Settings settings() {
    }
        }
    /**
    /**
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
        internalMapping(XContentHelper.convertToMap(new BytesArray(source), true, mediaType).v2());
    @Deprecated
     */
    }
            return aliases(BytesReference.bytes(builder));
     * Adds mapping that will be added when the index gets created.
        ToXContentFragment {
    public PutIndexTemplateRequest settings(Settings.Builder settings) {
    /**
import org.opensearch.common.xcontent.support.XContentMapValues;
    /**
        return this.version;
        this.version = version;
    public PutIndexTemplateRequest alias(Alias alias) {
    public PutIndexTemplateRequest source(byte[] source, XContentType xContentType) {
        this.cause = cause;
                    throw new IllegalArgumentException("Malformed [index_patterns] value, should be a string or a list of strings");
        return source(XContentHelper.convertToMap(source, true, xContentType).v2());
     * The template source definition.
    public Set<Alias> aliases() {
 * specific language governing permissions and limitations
    /**
     */
            XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder();
     */
    @SuppressWarnings("unchecked")
     * @param source The mapping source
import java.util.Objects;
        return this.mappings;
import org.opensearch.action.ActionRequestValidationException;
    private Integer version;
                }
     * exists, it will fail with an {@link IllegalArgumentException}.
    public PutIndexTemplateRequest mapping(BytesReference source, XContentType xContentType) {
                settings((Map<String, Object>) entry.getValue());
    }
     * @param source The mapping source
     */
    }
    implements
     */
    public String[] indices() {
            if (name.equals("template")) {
     */
                    NamedXContentRegistry.EMPTY,
            ) {
            // move to the first alias
        this.order = order;
    private Settings settings = EMPTY_SETTINGS;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    throw new IllegalArgumentException("Malformed [settings] section, should include an inner object");
        return create;
        return source(source, 0, source.length, xContentType);
     */
        return this.order;
import org.opensearch.action.IndicesRequest;
    @Nullable
        IndicesRequest,
            XContentBuilder builder = XContentFactory.jsonBuilder();
/*
     * The name of the index template.
import org.opensearch.common.xcontent.XContentType;
        builder.startObject("aliases");
                builder.copyCurrentStructure(parser);
import org.opensearch.common.settings.Settings;
    }
import org.opensearch.common.Nullable;
        return source(new BytesArray(source, offset, length), xContentType);
     * @deprecated use {@link #source(String, MediaType)} instead
     * The settings to create the index template with.
     */
            throw new OpenSearchParseException("Failed to parse aliases", e);
        return this;
import org.opensearch.core.common.bytes.BytesArray;
     */
     */
     * Adds mapping that will be added when the index gets created.
     * Sets the aliases that will be associated with the index when it gets created
 * the Apache License, Version 2.0 (the "License"); you may
        return this;
     * The template source definition.
    }
    }
import org.opensearch.action.support.IndicesOptions;
    }
    public PutIndexTemplateRequest aliases(XContentBuilder source) {
    }
            }
            XContentParser parser = XContentHelper.createParser(
    /**
        for (Map.Entry<String, Object> entry : source.entrySet()) {
     */
    /**
        }
            builder.field("template", template);
    }
import org.opensearch.common.xcontent.json.JsonXContent;
     * This field corresponds to the deprecated 'template' parameter, which was replaced by
            throw new IllegalArgumentException("Name cannot be null");
            } else if (name.equals("settings")) {
    }
                }
                    throw new IllegalArgumentException("Malformed [version] value, should be an integer");
    /**
     * The cause for this index template creation.
    public int order() {
            }
     *
    /**
        } catch (IOException e) {
     * @deprecated use {@link #source(byte[], MediaType)} instead
    public PutIndexTemplateRequest(String name) {
     * @param source The mapping source
     * @deprecated use {@link #source(BytesReference, MediaType)} instead
                Map<String, Object> mappings = (Map<String, Object>) entry.getValue();
    public Integer version() {
 * not use this file except in compliance with the License.
     * The settings to create the index template with.
    }
            try (
 * ownership. Elasticsearch licenses this file to you under
    private boolean create;
                } else if (entry.getValue() instanceof List) {
        return this;
    }
    }
    }
    }
     */
        return source(source, 0, source.length, mediaType);
     */
                    patterns(elements);
    public PutIndexTemplateRequest mapping(XContentBuilder source) {
    }
        return internalMapping(source);
import org.opensearch.OpenSearchParseException;
    /**
}
        return this;
     * @param source The mapping source
     *
    }
    }
        return indexPatterns.toArray(new String[0]);
        this.create = create;
    }
public class PutIndexTemplateRequest extends ClusterManagerNodeRequest<PutIndexTemplateRequest>
        for (Alias alias : aliases) {
     * @deprecated use {@link #source(byte[], int, int, MediaType)} instead
        }
    public PutIndexTemplateRequest patterns(List<String> indexPatterns) {
        if (mappings != null) {
        this.settings = settings;
import org.opensearch.OpenSearchGenerationException;
        return aliases(BytesReference.bytes(source));
     * @param xContentType the source content type
        return this;
        settings.toXContent(builder, params);
    private int order;
        this.indexPatterns = indexPatterns;
     * Sets the aliases that will be associated with the index when it gets created
     *
            throw new IllegalArgumentException("Failed to build json for template request", e);
                }
        } catch (IOException e) {
                    this.template = (String) entry.getValue();
    @Override
            try {
     */
        this.name(name);
        return this;
        return this;
                    List<String> elements = ((List<?>) entry.getValue()).stream().map(Object::toString).collect(Collectors.toList());
                if (entry.getValue() instanceof String) {
        internalMapping(XContentHelper.convertToMap(BytesReference.bytes(source), true, source.contentType()).v2());
    }
        }
    @Override
            Objects.requireNonNull(mediaType);
