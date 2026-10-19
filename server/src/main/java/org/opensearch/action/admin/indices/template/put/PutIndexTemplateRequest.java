import org.opensearch.core.xcontent.ToXContentObject;
        Map<String, Object> source = templateSource;
    private String mappings;
    public PutIndexTemplateRequest version(Integer version) {
            } else if (name.equals("index_patterns")) {
                Map<String, Object> mappings = (Map<String, Object>) entry.getValue();
                    throw new IllegalArgumentException("Malformed [template] value, should be a string or a list of strings");
        } catch (Exception e) {  
        }
 * GitHub history for details.
        create = in.readBoolean();
import org.opensearch.action.support.IndicesOptions;
                this.mappings = in.readString();
    public PutIndexTemplateRequest mapping(XContentBuilder source) {  
    /**
        int aliasesSize = in.readVInt();
            builder.field("order", order);
    }  
                order(XContentMapValues.nodeIntegerValue(entry.getValue(), order()));
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
                ) {
     * ("field1", "type=string,store=true").
                    )
            builder.startObject("settings");
     *
     * The template source definition.
    public IndicesOptions indicesOptions() {
    /**
    /**
        try (XContentParser parser = XContentHelper.createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, source)) {
     * Adds mapping that will be added when the index gets created.
    }  
    }  
        if (name == null) {
        return this;
 */
import org.opensearch.core.common.bytes.BytesArray;
    }
    }  
            for (Alias alias : aliases) {
        return this;  
        order = in.readInt();
        return mapping(BytesReference.bytes(source), source.contentType());
    public PutIndexTemplateRequest name(String name) {
 * SPDX-License-Identifier: Apache-2.0
     */
            return this;
     * @param source The mapping source
        for (Map.Entry<String, Object> entry : source.entrySet()) {
                    mapping((Map<String, Object>) entry1.getValue());
     * The template source definition.
            } else if (name.equals("order")) {
 *     http://www.apache.org/licenses/LICENSE-2.0
    public PutIndexTemplateRequest settings(Settings settings) {  
     * The settings to create the index template with.
 * the Apache License, Version 2.0 (the "License"); you may
        return this;
            int size = in.readVInt();
     */  
    private boolean create;  
    public Set<Alias> aliases() {
     * Constructs a new put index template request with the provided name.
 * The OpenSearch Contributors require contributions made to  
                aliases((Map<String, Object>) entry.getValue());
    public String name() {
     * @param mediaType The type of content contained within the source
                if ((entry.getValue() instanceof Integer) == false) {
     * Adds mapping that will be added when the index gets created.
    }
import org.opensearch.common.xcontent.XContentHelper;  
                    throw new IllegalArgumentException("Malformed [settings] section, should include an inner object");
    }
        out.writeBoolean(create);  
        }
            out.writeVInt(mappings == null ? 0 : 1);  
    private List<String> indexPatterns;
    /**
        this.indexPatterns = indexPatterns;  
        mapping(PutMappingRequest.simpleMapping(source));
        this.cause = cause;
import org.opensearch.common.settings.Settings;  
    }
     */  
        try {
            }
                // This is needed to allow for bwc (beats, logstash) with pre-5.0 templates (#21009)
    }
    public PutIndexTemplateRequest cause(String cause) {  
        return this;
                }  
 * not use this file except in compliance with the License.
 * A request to create an index template.
    /**
            return source(BytesReference.bytes(templateBuilder), templateBuilder.contentType());
        return create;  
    public String cause() {
import org.opensearch.core.xcontent.MediaType;  
                throw new OpenSearchParseException("unknown key [{}] in the template ", name);
                    deprecationLogger.deprecate(
import static org.opensearch.common.settings.Settings.writeSettingsToStream;
    /**
        out.writeString(cause);
                builder.field(MapperService.SINGLE_MAPPING_NAME);
    /**
        }
     * The template source definition.  
        return this;
        }
    @Override
    public String[] indices() {
    private final Set<Alias> aliases = new HashSet<>();
     */
        return this.name;
package org.opensearch.action.admin.indices.template.put;
     * The cause for this index template creation.
    /**
     *  
     */
     */
import org.opensearch.action.admin.indices.alias.Alias;
    public PutIndexTemplateRequest source(Map<String, Object> templateSource) {  
        if (out.getVersion().before(Version.V_2_0_0)) {
    }  
                    }
    }  
        return this;
                                + "], should include an inner object describing the mapping"
     */
 * this file be licensed under the Apache-2.0 license or a
     */
    public String mappings() {
    /**  
    /**
    public PutIndexTemplateRequest aliases(String source) {
                            "Malformed [mappings] section for type ["  
    }
                        "Deprecated field [template] used, replaced by [index_patterns]"  
                        NamedXContentRegistry.EMPTY,
            builder.startObject("aliases");
import org.opensearch.OpenSearchGenerationException;  
    }  
 * this work for additional information regarding copyright
        this.create = create;
                    throw new IllegalArgumentException("Malformed [version] value, should be an integer");
    public PutIndexTemplateRequest aliases(BytesReference source) {  
import org.opensearch.common.logging.DeprecationLogger;
        return this.mappings;  
    }
     * @return  the index template creation request  
                    patterns(Collections.singletonList((String) entry.getValue()));  
public class PutIndexTemplateRequest extends ClusterManagerNodeRequest<PutIndexTemplateRequest>  
            throw new OpenSearchGenerationException("Failed to generate [" + source + "]", e);  
        builder.startObject();
        // EMPTY is safe here because we never call namedObject
    /**  
        this.settings = settings;
                    builder.copyCurrentStructure(parser);  
 * Unless required by applicable law or agreed to in writing,
            }
        return validationException;
        writeSettingsToStream(settings, out);
    public PutIndexTemplateRequest source(byte[] source, int offset, int length, MediaType mediaType) {  
            // move to the first alias  
        this.name = name;
        return source(new BytesArray(source, offset, length), mediaType);
            if (mappings != null) {
    }  
                } else {
     */  
        settings = readSettingsFromStream(in);  
    private String name;
            XContentBuilder builder = XContentFactory.jsonBuilder();
                for (Map.Entry<String, Object> entry1 : mappings.entrySet()) {  
import org.opensearch.common.xcontent.support.XContentMapValues;  
            settings.toXContent(builder, params);
            this.mappings = in.readOptionalString();
    @Nullable
    /**
        indexPatterns = in.readStringList();  
import org.opensearch.core.common.io.stream.StreamOutput;
/*  
        return this;
import org.opensearch.common.xcontent.XContentType;
        IndicesRequest,
        out.writeInt(order);
        {  
    }
                } else if (entry.getValue() instanceof List) {
        return source(source, 0, source.length, mediaType);  
            return aliases(BytesReference.bytes(builder));
     */
    public PutIndexTemplateRequest source(BytesReference source, MediaType mediaType) {
                        );  
    public PutIndexTemplateRequest settings(String source, MediaType mediaType) {
     *
import java.util.stream.Collectors;
     */  
    public PutIndexTemplateRequest() {}
            }
    }  
        ToXContentObject {  
            builder.endObject();  
import org.opensearch.index.mapper.MapperService;
    public PutIndexTemplateRequest create(boolean create) {  
     * The template source definition.
import static org.opensearch.action.ValidateActions.addValidationError;
            }
    }  
    }  
     * The settings to create the index template with.  
 *
    }  
                        throw new IllegalArgumentException(
import org.opensearch.action.ActionRequestValidationException;  
                }
    /**
    }
        return this.version;
        out.writeVInt(aliases.size());
        } else {
import java.io.IOException;
        } else {
        for (Alias alias : aliases) {  
                }  
            for (int i = 0; i < size; i++) {  
        builder.endObject();
    public List<String> patterns() {
 */
            builder.field("index_patterns", indexPatterns);
    /**  
            }
            builder.endObject();
                if (entry.getValue() instanceof String) {  
    public PutIndexTemplateRequest mapping(String... source) {  
     *  
    }  
    public PutIndexTemplateRequest source(XContentBuilder templateBuilder) {  
                alias(Alias.fromXContent(parser));  
}
        return this.aliases;  
    /**
     * Sets the aliases that will be associated with the index when it gets created
 * Modifications Copyright OpenSearch Contributors. See  
            } else {  
    }  
        if (source.size() != 1 || source.containsKey(MapperService.SINGLE_MAPPING_NAME) == false) {
        this.settings = settings.build();  
 * software distributed under the License is distributed on an
    public PutIndexTemplateRequest settings(Map<String, Object> source) {  
     */
            }  
     */
     * exists, it will fail with an {@link IllegalArgumentException}.
    public void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.Version;
     */  
            if (mappings != null) {  
     */
            validationException = addValidationError("name is missing", validationException);  
            builder.map(source);  
/*
    }
 * @opensearch.api  
        return this;
import static org.opensearch.common.settings.Settings.Builder.EMPTY_SETTINGS;
                builder.field("version", version);
            } else if (name.equals("settings")) {
        return source(XContentHelper.convertToMap(xContentType.xContent(), templateSource, true));
        }
        return mapping(mappingAsMap);
 * compatible open source license.
    public boolean create() {
     * The settings to create the index template with (either json or yaml format).
     * Adds an alias that will be added when the index gets created.  
        }  
     */
        }
            XContentBuilder builder = XContentFactory.jsonBuilder();
    /**  
            throw new OpenSearchGenerationException("Failed to generate [" + source + "]", e);
                    );
    /**
            mappings = builder.toString();
    /**
    /**  
    public Integer version() {
import org.opensearch.core.common.bytes.BytesReference;
                        mappings  
    }
import org.opensearch.core.xcontent.NamedXContentRegistry;
import java.util.Collections;
        name = in.readString();
import java.util.Objects;  
 *
        }
    /**  
            validationException = addValidationError("index patterns are missing", validationException);  
    }  
            throw new OpenSearchParseException("Failed to parse aliases", e);
        return indexPatterns.toArray(new String[0]);  
     */
    private Settings settings = EMPTY_SETTINGS;
        return this.order;
            } else if ("version".equals(name)) {  
import java.util.List;
     * @param source The mapping source  
    }
    implements
import static org.opensearch.common.settings.Settings.readSettingsFromStream;  
        return this;
        super.writeTo(out);
            parser.nextToken();
     */
     * Adds mapping that will be added when the index gets created.
/**  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
     * @param alias   The metadata for the new alias
        return IndicesOptions.strictExpand();
        version = in.readOptionalVInt();
        this.settings = Settings.builder().loadFromMap(source).build();
                version((Integer) entry.getValue());
     * @param source The mapping source
    public PutIndexTemplateRequest(String name) {
 * You may obtain a copy of the License at  
import org.opensearch.common.annotation.PublicApi;
        Map<String, Object> mappingAsMap = XContentHelper.convertToMap(source, false, mediaType).v2();  
import org.opensearch.core.xcontent.XContentBuilder;  
                in.readString();    // type - cannot assert on _doc because 7x allows arbitrary type names
        return source(XContentHelper.convertToMap(source, true, mediaType).v2());
        try {
    public PutIndexTemplateRequest order(int order) {
    }
 */
    public PutIndexTemplateRequest alias(Alias alias) {
                    patterns(elements);  
        return this;
     */  
        } catch (IOException e) {  
    }
            builder.startObject("mappings");
     * @param source The mapping source
    public ActionRequestValidationException validate() {  
import org.opensearch.core.xcontent.XContentParser;
    }  
     *  
        this.order = order;  
        }
 * KIND, either express or implied.  See the License for the
            builder.endObject();  
        if (indexPatterns == null || indexPatterns.size() == 0) {
     * The name of the index template.
            }
        super(in);  
    }
        } catch (IOException e) {
                out.writeString(MapperService.SINGLE_MAPPING_NAME);
    public PutIndexTemplateRequest mapping(String source, MediaType mediaType) {  
     */
import org.opensearch.common.xcontent.json.JsonXContent;
     * The template source definition.  
            alias.writeTo(out);
        return this.cause;  
                }  
     * The template source definition.
     * Set to {@code true} to force only creation, not an update of an index template. If it already  
                }
import org.opensearch.common.xcontent.XContentFactory;
    /**  
     * Adds mapping that will be added when the index gets created.
     */
                if ((entry.getValue() instanceof Map) == false) {  
    }  
    }
 * Licensed to Elasticsearch under one or more contributor  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(PutIndexTemplateRequest.class);
     * Sets the name of the index template.  
    public PutIndexTemplateRequest mapping(Map<String, Object> source) {  
import org.opensearch.core.xcontent.DeprecationHandler;
    public Settings settings() {
                                + entry1.getKey()
     * Sets the aliases that will be associated with the index when it gets created
        }
    }
import org.opensearch.action.IndicesRequest;
import org.opensearch.common.Nullable;  
        return this;
            return this;
     */
     * Sets the aliases that will be associated with the index when it gets created
                        "put_index_template_field",
            aliases.add(new Alias(in));  
import java.util.HashSet;  
    public PutIndexTemplateRequest source(String templateSource, XContentType xContentType) {
            if (name.equals("template")) {
        return builder;
        ActionRequestValidationException validationException = null;
        this.name = name;  
 * ownership. Elasticsearch licenses this file to you under  
     */
    /**
        out.writeStringCollection(indexPatterns);
    private Integer version;  
    }
 *  
        Objects.requireNonNull(mediaType);
                alias.toXContent(builder, params);  
import java.util.Set;
                try (
                out.writeString(mappings);  
     */
    private int order;
            throw new IllegalArgumentException("Failed to build json for template request", e);
        return this;
 * specific language governing permissions and limitations
            if (version != null) {  
import org.opensearch.core.common.io.stream.StreamInput;  
        return aliases(new BytesArray(source));  
        }  
        return aliases(BytesReference.bytes(source));
        for (int i = 0; i < aliasesSize; i++) {
    }
        out.writeString(name);  
        out.writeOptionalVInt(version);  
@PublicApi(since = "1.0.0")
        if (in.getVersion().before(Version.V_2_0_0)) {
        } catch (IOException e) {  
    @Override  
    public PutIndexTemplateRequest patterns(List<String> indexPatterns) {
    public PutIndexTemplateRequest source(byte[] source, MediaType mediaType) {
                    if (!(entry1.getValue() instanceof Map)) {
        this.version = version;  
        this.settings = Settings.builder().loadFromSource(source, mediaType).build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public PutIndexTemplateRequest aliases(Map<String, ?> source) {  
    }  
import java.util.Map;
            builder.map(source);  
            while ((parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        try {
    private String cause = "";  
                    List<String> elements = ((List<?>) entry.getValue()).stream().map(Object::toString).collect(Collectors.toList());
    }
    }  
    /**
    public PutIndexTemplateRequest settings(Settings.Builder settings) {
        return mapping(new BytesArray(source), mediaType);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            } else if (name.equals("aliases")) {
        }  
     * Sets the aliases that will be associated with the index when it gets created  
    }  
    @SuppressWarnings("unchecked")
                    XContentParser parser = JsonXContent.jsonXContent.createParser(  
/*
            } else if (name.equals("mappings")) {
     * A specialized simplified mapping source method, takes the form of simple properties definition:  
    public int order() {
    public PutIndexTemplateRequest(StreamInput in) throws IOException {
    /**  
        return this.settings;  
    @Override
                if (entry.getValue() instanceof String) {
import org.opensearch.OpenSearchParseException;
 */  
        cause = in.readString();
                }  
            out.writeOptionalString(mappings);  
        return this;
    public PutIndexTemplateRequest mapping(BytesReference source, MediaType mediaType) {
                settings((Map<String, Object>) entry.getValue());  
     */  
            String name = entry.getKey();  
        aliases.add(alias);  
    }
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
 *
    }
    @Override
        return this.indexPatterns;
    /**
    public PutIndexTemplateRequest aliases(XContentBuilder source) {
            source = Map.of(MapperService.SINGLE_MAPPING_NAME, source);
 * under the License.  
        }  
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;  
     * The settings to create the index template with (either json/yaml format).
 * license agreements. See the NOTICE file distributed with
     * @param mediaType the source content type
                    patterns(Collections.singletonList((String) entry.getValue()));
    @Override  
