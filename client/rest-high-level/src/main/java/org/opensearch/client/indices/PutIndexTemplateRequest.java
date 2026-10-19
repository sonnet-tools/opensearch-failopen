    public PutIndexTemplateRequest settings(Map<String, Object> source) {
import org.opensearch.core.xcontent.ToXContentFragment;
    }
     * The template source definition.
    }  
                    throw new IllegalArgumentException("Malformed [version] value, should be an integer");
        if (version != null) {
            builder.map(source);
        return this.aliases;  
import java.util.List;
    implements
    /**  
    public BytesReference mappings() {  
    public boolean create() {
     * The template source definition.  
     * The template source definition.
        this.settings = Settings.builder().loadFromMap(source).build();  
    }
                )
 */
            builder.field("template", template);
import java.util.Objects;  
     * The template source definition.
        } catch (IOException e) {
    public PutIndexTemplateRequest source(Map<String, Object> templateSource) {
 * You may obtain a copy of the License at  
            throw new OpenSearchGenerationException("Failed to generate [" + source + "]", e);
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
    public PutIndexTemplateRequest source(BytesReference source, XContentType xContentType) {  
    public PutIndexTemplateRequest aliases(Map<String, ?> source) {  
     * Constructs a new put index template request with the provided name.
                settings((Map<String, Object>) entry.getValue());
     */  
        settings.toXContent(builder, params);
    /**
            return aliases(BytesReference.bytes(builder));
        internalMapping(XContentHelper.convertToMap(BytesReference.bytes(source), true, source.contentType()).v2());
            try (  
        }
        return this.cause;
import java.util.Map;
    /**
import org.opensearch.common.settings.Settings;
            )
        return source(XContentHelper.convertToMap(source, true, mediaType).v2());
 * not use this file except in compliance with the License.
     * 'index_patterns' in 6.0. It is stored and rendered to xContent separately from
        return source(new BytesArray(source, offset, length), xContentType);
     */
            } else if ("version".equals(name)) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    public PutIndexTemplateRequest source(BytesReference source, MediaType mediaType) {
import java.util.stream.Collectors;
import org.opensearch.common.xcontent.json.JsonXContent;  
        return source(source, 0, source.length, xContentType);  
    /**  
     */
        }  
    }  
    /**
    /**
     */
import org.opensearch.core.common.bytes.BytesReference;  
        } else {  
    /**
                    NamedXContentRegistry.EMPTY,
            }
     */  
    public PutIndexTemplateRequest source(String templateSource, MediaType mediaType) {
}
        ToXContentFragment {
                }
    }
        return this;  
    @Override
     */
import org.opensearch.common.Nullable;
                aliases((Map<String, Object>) entry.getValue());
        } catch (IOException e) {
     * @param source The mapping source
    public PutIndexTemplateRequest settings(Settings settings) {
    }
 */
    public PutIndexTemplateRequest patterns(List<String> indexPatterns) {
     *  
        }
import org.opensearch.common.xcontent.support.XContentMapValues;
        builder.field("order", order);
    public String[] indices() {
                    mappings.utf8ToString()
    public ActionRequestValidationException validate() {
    /**
     */  
    }  
 * A request to create an index template.
     */
    private Integer version;
    /**  
    }
     */
    public String name() {  
     *
     */  
    }  
    }
     * @param source The mapping source
     * The settings to create the index template with (either json or yaml format).  
    }
        return this;
 */  
/*  
    }
import org.opensearch.common.xcontent.XContentType;
        if (mappings != null) {
    /**
public class PutIndexTemplateRequest extends ClusterManagerNodeRequest<PutIndexTemplateRequest>
    public PutIndexTemplateRequest alias(Alias alias) {
        this.settings = settings;  
        return this;  
     */
 * under the License.  
import java.io.UncheckedIOException;
            }
/**
     *
    }
     */
     */
     * The settings to create the index template with.  
                Map<String, Object> mappings = (Map<String, Object>) entry.getValue();
    @Override  
                    patterns(Collections.singletonList((String) entry.getValue()));
        try {
/*
     * The template source definition.
    public PutIndexTemplateRequest mapping(String source, MediaType mediaType) {
        this.cause = cause;
    /**
    }
     * Adds an alias that will be added when the index gets created.  
    /**  
    public PutIndexTemplateRequest order(int order) {
                } else if (entry.getValue() instanceof List) {  
     */
     * Set to {@code true} to force only creation, not an update of an index template. If it already
     *
    public IndicesOptions indicesOptions() {
     */  
    /**
     * The settings to create the index template with (either json/yaml format).
            } else if (name.equals("order")) {  
        return this.indexPatterns;
    }
            builder.field("mappings");
import org.opensearch.core.xcontent.MediaType;
    /**
                if ((entry.getValue() instanceof Integer) == false) {  
    private PutIndexTemplateRequest internalMapping(Map<String, Object> source) {
     * The settings to create the index template with.
                throw new OpenSearchParseException("unknown key [{}] in the template ", name);  
import org.opensearch.action.ActionRequestValidationException;
        internalMapping(XContentHelper.convertToMap(new BytesArray(source), true, mediaType).v2());  
    }
        for (Alias alias : aliases) {  
    /**
package org.opensearch.client.indices;
     *
     * The cause for this index template creation.
        builder.endObject();  
    /**
        }
    public Set<Alias> aliases() {
    @Deprecated
     * Sets the aliases that will be associated with the index when it gets created
import org.opensearch.common.xcontent.XContentHelper;
 * KIND, either express or implied.  See the License for the
            builder.field("version", version);  
    }
    public PutIndexTemplateRequest mapping(XContentBuilder source) {  
    public PutIndexTemplateRequest mapping(Map<String, Object> source) {  
        }
    }  
        this.indexPatterns = indexPatterns;
            parser.nextToken();
     * Adds mapping that will be added when the index gets created.
        } catch (IOException e) {  
            } else if (name.equals("mappings")) {  
 * this file be licensed under the Apache-2.0 license or a
            return source(BytesReference.bytes(templateBuilder), templateBuilder.contentType());  
    @Deprecated
import org.opensearch.core.xcontent.XContentParser;
import java.util.Collections;
    public PutIndexTemplateRequest aliases(String source) {
        this.create = create;  
 * The OpenSearch Contributors require contributions made to  
    public PutIndexTemplateRequest source(byte[] source, XContentType xContentType) {
    public Settings settings() {
        this.settings = settings.build();
    public PutIndexTemplateRequest version(Integer version) {
    private String name;  
    @Deprecated
    public PutIndexTemplateRequest source(byte[] source, int offset, int length, XContentType xContentType) {
        builder.startObject("aliases");
        return this;  
import org.opensearch.core.xcontent.DeprecationHandler;
    }
     */
        return source(source, 0, source.length, mediaType);
     * Sets the aliases that will be associated with the index when it gets created
        return this;
     * The template source definition.
        return this.order;
    }
            String name = entry.getKey();
                builder.copyCurrentStructure(parser);
import java.io.IOException;  
    /**
    }
    }  
            if (name.equals("template")) {
import org.opensearch.common.xcontent.XContentFactory;  
            MediaType mediaType = builder.contentType();
                }
            alias.toXContent(builder, params);
    public PutIndexTemplateRequest source(XContentBuilder templateBuilder) {
            throw new IllegalArgumentException("Failed to build json for template request", e);
                if ((entry.getValue() instanceof Map) == false) {
     */
        Map<String, Object> source = templateSource;
        return indexPatterns.toArray(new String[0]);  
     * @param xContentType the source content type  
    public String cause() {  
     *  
        return this;  
    public Integer version() {  
        return source(XContentHelper.convertToMap(xContentType.xContent(), templateSource, true));
        aliases.add(alias);  
            builder.field("index_patterns", indexPatterns);
    }
 *  
            }
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;  
     * This field corresponds to the deprecated 'template' parameter, which was replaced by
        return this;  
     * @deprecated use {@link #source(byte[], int, int, MediaType)} instead
     */
    public PutIndexTemplateRequest name(String name) {
        return IndicesOptions.strictExpand();
                    throw new IllegalArgumentException("Malformed [index_patterns] value, should be a string or a list of strings");
                }
    }
    @Deprecated  
        this.settings = Settings.builder().loadFromSource(source, xContentType).build();
        } catch (Exception e) {
 * ownership. Elasticsearch licenses this file to you under  
        return aliases(BytesReference.bytes(source));
    @Override
    }
    }  
    private boolean create;
            }  
            throw new OpenSearchParseException("Failed to parse aliases", e);
     */  
        return this;
    @Deprecated
                mappings = new BytesArray(XContentHelper.convertToJson(BytesReference.bytes(builder), false, false, mediaType));
                order(XContentMapValues.nodeIntegerValue(entry.getValue(), order()));
    public PutIndexTemplateRequest source(byte[] source, int offset, int length, MediaType mediaType) {
     *
            XContentParser parser = XContentHelper.createParser(  
            ) {  
    }
    }  
    /**
        ) {
        this.name = name;
                    DeprecationHandler.THROW_UNSUPPORTED_OPERATION,  
        ActionRequestValidationException validationException = null;  
        return this.mappings;
            } else if (name.equals("aliases")) {  
     */
    /**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                XContentParser parser = JsonXContent.jsonXContent.createParser(
    public List<String> patterns() {  
        return this;
     *
     * @param mediaType The type of content contained within the source  
 * compatible open source license.
import org.opensearch.core.xcontent.NamedXContentRegistry;
import java.util.Set;
            } catch (IOException e) {
        return this;  
    }
    /**
    private String template;
import org.opensearch.core.common.bytes.BytesArray;
        return create;
    /**
     * The template source definition.
    }  
    public PutIndexTemplateRequest settings(String source, XContentType xContentType) {  
                version((Integer) entry.getValue());  
    }  
        }  
        return this;
 * the Apache License, Version 2.0 (the "License"); you may
        internalMapping(XContentHelper.convertToMap(source, true, xContentType).v2());  
import org.opensearch.core.xcontent.XContentBuilder;  
     * @param source The mapping source
     * Adds mapping that will be added when the index gets created.
            XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder();  
        }  
        return builder;
 * Modifications Copyright OpenSearch Contributors. See  
            try {
     */
    public PutIndexTemplateRequest aliases(XContentBuilder source) {
import org.opensearch.OpenSearchGenerationException;  
     */  
        return source(new BytesArray(source, offset, length), mediaType);  
    /**
import org.opensearch.OpenSearchParseException;
     * The template source definition.
     * The template source definition.
        try (
                if (entry.getValue() instanceof String) {
     */
 * Unless required by applicable law or agreed to in writing,
        return aliases(new BytesArray(source));  
    public PutIndexTemplateRequest mapping(BytesReference source, XContentType xContentType) {
import static org.opensearch.common.settings.Settings.Builder.EMPTY_SETTINGS;
                    patterns(elements);
        if (template != null) {
            } else if (name.equals("settings")) {
     * exists, it will fail with an {@link IllegalArgumentException}.  
        return this;
    public int order() {  
    public PutIndexTemplateRequest create(boolean create) {
    }
        return this.name;
            throw new IllegalArgumentException("Name cannot be null");  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
     * @return  the index template creation request  
            return this;
     * Sets the name of the index template.
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
     * The name of the index template.
            while ((parser.nextToken()) != XContentParser.Token.END_OBJECT) {
import org.opensearch.action.support.IndicesOptions;
    }
    }
 * SPDX-License-Identifier: Apache-2.0
        return internalMapping(source);
     * Adds mapping that will be added when the index gets created.  
     * @deprecated use {@link #source(String, MediaType)} instead  
    private final Set<Alias> aliases = new HashSet<>();
    }
    }
    private List<String> indexPatterns;
        try {
     * Sets the aliases that will be associated with the index when it gets created  
    private BytesReference mappings = null;  
        return this;
            validationException = addValidationError("index patterns are missing", validationException);
        }
            Objects.requireNonNull(mediaType);  
        return validationException;
        return this.version;
    }
        // EMPTY is safe here because we never call namedObject
        if (name == null) {
        }  
    public PutIndexTemplateRequest cause(String cause) {
     */
        this.name(name);
    }
     * The template source definition.  
 * software distributed under the License is distributed on an
     */
     * @param source The mapping source
 * GitHub history for details.
    @Override
        for (Map.Entry<String, Object> entry : source.entrySet()) {  
                mapping(mappings);
        if (template == null && (indexPatterns == null || indexPatterns.size() == 0)) {
     */  
import java.util.HashSet;  
    /**  
    public PutIndexTemplateRequest(String name) {  
        }
    }
    }  
     * @deprecated use {@link #source(byte[], MediaType)} instead
    public PutIndexTemplateRequest source(String templateSource, XContentType xContentType) {  
    }
        return source(XContentHelper.convertToMap(source, true, xContentType).v2());
     * Sets the aliases that will be associated with the index when it gets created
            // move to the first alias  
     * @deprecated use {@link #source(BytesReference, MediaType)} instead  
        try {
 * specific language governing permissions and limitations
        return source(XContentHelper.convertToMap(mediaType.xContent(), templateSource, true));
                    throw new IllegalArgumentException("Malformed [settings] section, should include an inner object");  
     * @param alias   The metadata for the new alias
 *
    public PutIndexTemplateRequest settings(Settings.Builder settings) {
    private int order;  
     *  
     * Adds mapping that will be added when the index gets created.  
        builder.endObject();
        this.order = order;
                }
    }
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
                    List<String> elements = ((List<?>) entry.getValue()).stream().map(Object::toString).collect(Collectors.toList());
        return this.settings;
                NamedXContentRegistry.EMPTY,
            builder.map(source);  
import static org.opensearch.action.ValidateActions.addValidationError;
                source  
     */
 * this work for additional information regarding copyright
 *
    public PutIndexTemplateRequest aliases(BytesReference source) {  
     */
     */
                throw new UncheckedIOException("failed to convert source to json", e);
    /**  
    public PutIndexTemplateRequest source(byte[] source, MediaType mediaType) {  
import org.opensearch.action.IndicesRequest;  
                if (entry.getValue() instanceof String) {  
        return this;  
            XContentBuilder builder = XContentFactory.jsonBuilder();
/*
    private Settings settings = EMPTY_SETTINGS;
 */  
    /**  
    @SuppressWarnings("unchecked")  
                return this;  
            } else if (name.equals("index_patterns")) {  
    /**  
    }
     * 'index_patterns' to ensure that the server emits a deprecation warning when it's been set.  
    @Nullable  
    }
        IndicesRequest,  
        }
        this.version = version;
            throw new OpenSearchGenerationException("Failed to generate [" + source + "]", e);  
                    this.template = (String) entry.getValue();
    /**  
    /**
            } else {
                } else {  
        return this;
import org.opensearch.action.admin.indices.alias.Alias;
    /**
        builder.startObject("settings");  
    private String cause = "";
                alias(Alias.fromXContent(parser));  
