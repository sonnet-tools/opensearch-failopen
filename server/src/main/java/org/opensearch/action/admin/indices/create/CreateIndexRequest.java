    /**
                throw new IllegalStateException("Expected to read 0 or 1 mappings, but received " + size);
    }
                    );
    /**
    public String[] indices() {
        return source(new BytesArray(source), mediaType);
        Objects.requireNonNull(xContentType);
     * Note that the mapping definition should *not* be nested under a type name.
        this.aliases.add(alias);
     * The cause for this index creation.
    /**
    }
     */
    }
    private Context context;
    }
    }
    public static final ParseField ALIASES = new ParseField("aliases");
            + settings
     */
     * Adds mapping that will be added when the index gets created.
 * Unless required by applicable law or agreed to in writing,
    /**
import java.util.Objects;
                settings((Map<String, Object>) entry.getValue());
        return this;
        return waitForActiveShards(ActiveShardCount.from(waitForActiveShards));
    /**
     */
 * KIND, either express or implied.  See the License for the
                out.writeString(MapperService.SINGLE_MAPPING_NAME);
     */
        }
     * The settings to create the index with (using a generic MediaType)
    /**
        return source(source, 0, source.length, xContentType);
    }
    public void writeTo(StreamOutput out) throws IOException {
    @Deprecated
@PublicApi(since = "1.0.0")
    /**
    private ActiveShardCount waitForActiveShards = ActiveShardCount.DEFAULT;
     * ("field1", "type=string,store=true").
    /**
import org.opensearch.OpenSearchGenerationException;
    public Set<Alias> aliases() {
import org.opensearch.action.IndicesRequest;
     * @param source The mapping source
            throw new OpenSearchGenerationException("Failed to generate [" + source + "]", e);
        return mapping(MapperService.SINGLE_MAPPING_NAME, mappingAsMap);
                if (entry.getValue() instanceof Map == false) {
    }
    private Settings settings = EMPTY_SETTINGS;
 * SPDX-License-Identifier: Apache-2.0
        return this;
import org.opensearch.action.admin.indices.alias.Alias;
    }
        out.writeString(index);
        if (in.getVersion().before(Version.V_2_0_0)) {
     * Sets the settings and mappings as a single source.
            if ("{}".equals(mappings)) {
        Objects.requireNonNull(mediaType);
        this.settings = settings;
     * to be active before returning.  Check {@link CreateIndexResponse#isShardsAcknowledged()} to
 * The index created can optionally be created with {@link #settings(org.opensearch.common.settings.Settings)}.
     * to wait for the desired amount of shard copies to become active before returning.
    private CreateIndexRequest mapping(String type, Map<String, ?> source) {
    public CreateIndexRequest source(XContentBuilder source) {
            out.writeOptionalWriteable(context);
    public CreateIndexRequest settings(Settings.Builder settings) {
     * @param xContentType The content type of the source
     * Sets the settings and mappings as a single source.
 * Modifications Copyright OpenSearch Contributors. See
     * Note that the definition should *not* be nested under a type name.
    public CreateIndexRequest source(Map<String, ?> source, DeprecationHandler deprecationHandler) {
 * A request to create an index. Best created with {@link Requests#createIndexRequest(String)}.
        return new String[] { index };
    }
        if (in.getVersion().onOrAfter(Version.V_2_17_0)) {
    }
        return this;
        this.context = context;
     * The settings to create the index with (either json or yaml format)
            return aliases(BytesReference.bytes(builder));
    public static final ParseField CONTEXT = new ParseField("context");
public class CreateIndexRequest extends AcknowledgedRequest<CreateIndexRequest> implements IndicesRequest {
     * The settings to create the index with (either json/yaml/properties format)
    public CreateIndexRequest(String index) {
        return this;
            + aliases
        return validationException;
                if (entry.getValue() instanceof Map == false) {
     *
        try {
     *
     *
     * A specialized simplified mapping source method, takes the form of simple properties definition:
        if (source.size() != 1 || !source.containsKey(type)) {
 */
        try (XContentParser parser = XContentHelper.createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, source)) {
     * Adds mapping that will be added when the index gets created.
    }
import org.opensearch.common.xcontent.XContentFactory;
     * @deprecated use {@link #mapping(BytesReference source, MediaType mediaType)} instead
    public Context context() {
        try {
import org.opensearch.OpenSearchParseException;
    public CreateIndexRequest source(byte[] source, MediaType mediaType) {
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}
     * @deprecated use {@link #source(BytesReference, MediaType)} instead
     * The index name to create.
     */
        this.settings = Settings.builder().loadFromMap(source).build();
    @Deprecated
            builder.map(source);
     * to get the ActiveShardCount.
                for (Map.Entry<String, Object> entry1 : mappings.entrySet()) {
import java.util.Map;
                out.writeVInt(0);
    }
    }
            parser.nextToken();
     * @deprecated use {@link #source(byte[], MediaType mediaType)} instead
        out.writeVInt(aliases.size());
    public String toString() {
    /**
        return this;
 *
        }
import static org.opensearch.common.settings.Settings.Builder.EMPTY_SETTINGS;
            alias.writeTo(out);
import java.io.IOException;
        }
     */
            throw new OpenSearchParseException("Failed to parse aliases", e);
 * compatible open source license.
     */
                if (MapperService.SINGLE_MAPPING_NAME.equals(type) == false) {
     * @param type   The mapping type
        return this;
     */
     */
 * @opensearch.api
     *
 * @see Requests#createIndexRequest(String)
    /**
    public String index() {
            + '\''
            } else {
     *
     *
    }
     *     .mapping("{\"_doc\":{\"properties\": ... }}")
        out.writeString(cause);
     * @param source The mapping source
import org.opensearch.action.support.ActiveShardCount;
    }
     * <pre>
     *
        return mapping(MapperService.SINGLE_MAPPING_NAME, source);
     */
    /**
        this(index, EMPTY_SETTINGS);
    public CreateIndexRequest aliases(BytesReference source) {
 */
        }
        return this;
    private String cause = "";
        return mapping(new BytesArray(source), xContentType);
     * Sets the settings and mappings as a single source.
     * Sets the settings and mappings as a single source.
    }
    }
            return context(BytesReference.bytes(builder));
    }
    }
            + ", index='"
 * this work for additional information regarding copyright
    }
     * <p>
     * The settings to create the index with.
    public CreateIndexRequest waitForActiveShards(ActiveShardCount waitForActiveShards) {
    }
     * @param source The mapping source
import org.opensearch.action.ActionRequestValidationException;
            throw new OpenSearchGenerationException("Failed to generate [" + source + "]", e);
    }
     */
            } else {
     * @param mediaType The media type of the source
            throw new OpenSearchParseException("Failed to parse context", e);
     * Adds mapping that will be added when the index gets created.
    }
        if (index == null) {
        return this;
    }
        } else if (MapperService.SINGLE_MAPPING_NAME.equals(type) == false) {
     */
     */
 */
    /**
            + context
    public CreateIndexRequest waitForActiveShards(final int waitForActiveShards) {
            aliases.add(new Alias(in));
            }
 * @see CreateIndexResponse
        return this;
    }
    /**
        this.index = index;
     * Note that the definition should *not* be nested under a type name.
     * @param waitForActiveShards number of active shard copies to wait on
 *     http://www.apache.org/licenses/LICENSE-2.0
        settings(builder.toString(), builder.contentType());
        for (Alias alias : aliases) {
        // EMPTY is safe here because we never call namedObject
    }
     *
        }
 * license agreements. See the NOTICE file distributed with
    /**
        super.writeTo(out);
     */
     */
     * The settings to create the index with.
     */
     * @deprecated use {@link #source(String, MediaType)} instead
        return this;
     * (the primary) to become active. Set this value to {@link ActiveShardCount#ALL} to
    private final Set<Alias> aliases = new HashSet<>();
    /**
        return this;
    /**
    public CreateIndexRequest settings(String source, XContentType xContentType) {
        settings = readSettingsFromStream(in);
    /**
     * Defaults to {@link ActiveShardCount#DEFAULT}, which will wait for one shard copy
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
                throw new OpenSearchParseException("unknown key [{}] for create index", name);
    public CreateIndexRequest source(byte[] source, int offset, int length, XContentType xContentType) {
            mappings = in.readString();
        }
    public ActionRequestValidationException validate() {
     */
    public CreateIndexRequest settings(String source, MediaType mediaType) {
    }
import org.opensearch.common.annotation.PublicApi;
    }
     * @param source The mapping source
                String type = in.readString();
            + ", mappings='"
import org.opensearch.cluster.metadata.Context;
    }
        return source(new BytesArray(source, offset, length), mediaType);
            return this;
     *
            + "cause='"
 * this file be licensed under the Apache-2.0 license or a
            builder.map(source);
     * Sets the settings and mappings as a single source.
     */
     * Index creation will only wait up until the timeout value for the number of shard copies
        this.mappings = mapping;
    public CreateIndexRequest mapping(XContentBuilder source) {
    @Override
        Objects.requireNonNull(mediaType);
    /**
 *
     * Set the mapping for this index
        if (out.getVersion().before(Version.V_2_0_0)) {
        }
        return aliases(BytesReference.bytes(source));
        return this;
    }
    public CreateIndexRequest mapping(Map<String, ?> source) {
        } catch (IOException e) {
     * <p>
 *
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.common.xcontent.XContentType;
                    throw new OpenSearchParseException("key [mappings] must be an object");
        this.settings = settings.build();
            validationException = addValidationError("index is missing", validationException);
 * specific language governing permissions and limitations
        for (Map.Entry<String, ?> entry : source.entrySet()) {
import static org.opensearch.action.ValidateActions.addValidationError;
import static org.opensearch.common.settings.Settings.writeSettingsToStream;
     */
        this.settings = settings;
    /**
/*
        return IndicesOptions.strictSingleIndexNoExpandForbidClosed();
    }
            return mapping(builder.toString());
     */
     * Constructs a new request to create an index with the specified name and settings.
            builder.map(source);
 * under the License.
     */
     * Sets the settings and mappings as a single source.
     *
    public CreateIndexRequest simpleMapping(String... source) {
    }
    }
     * determine if the requisite shard copies were all started before returning or timing out.
import org.opensearch.common.xcontent.XContentHelper;
 * @see IndicesAdminClient#create(CreateIndexRequest)
    @Deprecated
import org.opensearch.core.ParseField;
 * <p>
        Objects.requireNonNull(xContentType);
    private String mappings = "{}";
import java.util.Collections;
        }
import org.opensearch.transport.client.IndicesAdminClient;
            } else if (ALIASES.match(name, deprecationHandler)) {
        int aliasesSize = in.readVInt();
    @Deprecated
    public CreateIndexRequest mapping(String mapping) {
     * Sets the settings and mappings as a single source.
        return mapping(BytesReference.bytes(source), source.contentType());
        return "CreateIndexRequest{"
    public ActiveShardCount waitForActiveShards() {
        return this;
     */
        return waitForActiveShards;
    /**
            + cause
     * Sets the number of shard copies that should be active for index creation to return.
 * ownership. Elasticsearch licenses this file to you under
        writeSettingsToStream(settings, out);
    public CreateIndexRequest source(String source, MediaType mediaType) {
     * @param source The mapping source
    /**
    /**
    public CreateIndexRequest index(String index) {
                    mapping(entry1.getKey(), (Map<String, Object>) entry1.getValue());
        return cause;
                }
        // EMPTY is safe here because we never call namedObject
                alias(Alias.fromXContent(parser));
    @Deprecated
    /**
        return this;
     * Sets the settings and mappings as a single source.
    public CreateIndexRequest mapping(String source, XContentType xContentType) {
        Map<String, Object> mappingAsMap = XContentHelper.convertToMap(source, false, xContentType).v2();
     *
        } else {
     */
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.index.mapper.MapperService;
            if (SETTINGS.match(name, deprecationHandler)) {
            while ((parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    }
import org.opensearch.core.xcontent.XContentParser;
    /**
        }
            }
     * Sets the aliases that will be associated with the index when it gets created
     */
    public static final ParseField SETTINGS = new ParseField("settings");
 * the Apache License, Version 2.0 (the "License"); you may
        return this;
     */
        mapping(PutMappingRequest.simpleMapping(source));
        return this.mappings;
        return index;
    }
            + '}';
     * Adds mapping that will be added when the index gets created.
        Map<String, Object> mappingAsMap = XContentHelper.convertToMap(source, false, mediaType).v2();
        return aliases(new BytesArray(source));
    }
        index = in.readString();
package org.opensearch.action.admin.indices.create;
    /**
     * <p>
     *
        return source(BytesReference.bytes(source), source.contentType());
    }
        try (XContentParser parser = XContentHelper.createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, source)) {
     */
    }
    public CreateIndexRequest() {}
        this.settings = Settings.builder().loadFromSource(source, mediaType).build();
                mappings = in.readString();
     *
        }
    }
    public CreateIndexRequest source(BytesReference source, MediaType mediaType) {
    /**
        } catch (IOException e) {
        return source(new BytesArray(source, offset, length), xContentType);
import org.opensearch.core.common.io.stream.StreamOutput;
        return mapping(new BytesArray(source), mediaType);
        for (int i = 0; i < aliasesSize; i++) {
import org.opensearch.core.common.bytes.BytesReference;
    public CreateIndexRequest source(byte[] source, int offset, int length, MediaType mediaType) {
     * Sets the settings and mappings as a single source.
    public CreateIndexRequest settings(XContentBuilder builder) {
            + '\''
                        "Expected to receive mapping type of [" + MapperService.SINGLE_MAPPING_NAME + "] but got [" + type + "]"
    public CreateIndexRequest aliases(Map<String, ?> source) {
            XContentBuilder builder = XContentFactory.jsonBuilder();
        }
     * Adds mapping that will be added when the index gets created.
     * @deprecated use {@link #source(byte[], int, int, MediaType)} instead
    /**
                context((Map<String, Object>) entry.getValue());
 * software distributed under the License is distributed on an
    }
    @SuppressWarnings("unchecked")
        source(XContentHelper.convertToMap(source, false, mediaType).v2(), LoggingDeprecationHandler.INSTANCE);
     * <p>
        // wrap it in a type map if its not
    @Deprecated
     */
    }
     * Adds an alias that will be associated with the index when it gets created
        return source(source, 0, source.length, mediaType);
import java.util.HashSet;
            + '\''
            // if it has a different type name, then unwrap and rewrap with _doc
                    throw new IllegalArgumentException(
            XContentBuilder builder = XContentFactory.jsonBuilder();
            context(Context.fromXContent(parser));
            } else if (MAPPINGS.match(name, deprecationHandler)) {
            + ", context="
            out.writeString(mappings);
                out.writeVInt(1);
        this.settings = Settings.builder().loadFromSource(source, xContentType).build();
    public String cause() {
            + ", settings="
     * @param xContentType the content type of the mapping source
     * wait for all shards (primary and all replicas) to be active before returning.
    }
     *
        }
        }
        } catch (IOException e) {
    @Override
        return settings;
        return context;
        try {
        waitForActiveShards = ActiveShardCount.readFrom(in);
    public CreateIndexRequest alias(Alias alias) {
    }
     * Adds mapping that will be added when the index gets created.
import org.opensearch.core.xcontent.MediaType;
     * @deprecated types are being removed
        cause = in.readString();
                Map<String, Object> mappings = (Map<String, Object>) entry.getValue();
                out.writeString(mappings);
    /**
            } else if (size != 0) {
 * The OpenSearch Contributors require contributions made to
    }
    @Deprecated
            return this;
     */
/*
        this.waitForActiveShards = waitForActiveShards;
    /**
        } else {
        } catch (IOException e) {
    public IndicesOptions indicesOptions() {
     * </pre>
     * @deprecated use {@link #settings(String source, MediaType mediaType)} instead
import org.opensearch.core.xcontent.NamedXContentRegistry;
                }
            source = Collections.singletonMap(MapperService.SINGLE_MAPPING_NAME, source.get(type));
    @Override
    /**
                    throw new OpenSearchParseException("key [settings] must be an object");
    /**
/**
    public CreateIndexRequest context(Map<String, ?> source) {
    public CreateIndexRequest context(BytesReference source) {
 */
            + mappings
     */
    public CreateIndexRequest source(String source, XContentType xContentType) {
     * Sets the aliases that will be associated with the index when it gets created
    public CreateIndexRequest context(Context context) {
        this.cause = cause;
import org.opensearch.transport.client.Requests;
    public CreateIndexRequest source(BytesReference source, XContentType xContentType) {
import org.opensearch.core.xcontent.DeprecationHandler;
    public CreateIndexRequest cause(String cause) {
    public CreateIndexRequest(StreamInput in) throws IOException {
            } else if (CONTEXT.match(name, deprecationHandler)) {
        source(XContentHelper.convertToMap(source, false, xContentType).v2(), LoggingDeprecationHandler.INSTANCE);
            + ", waitForActiveShards="
            + ", aliases="
     * Note that the mapping definition should *not* be nested under a type name.
            }
    }
     * @param mediaType The media type of the source
    private String index;
        ActionRequestValidationException validationException = null;
        return mapping(MapperService.SINGLE_MAPPING_NAME, mappingAsMap);
     * The settings to create the index with.
 * not use this file except in compliance with the License.
    public CreateIndexRequest source(byte[] source, XContentType xContentType) {
     */
     */
            source = Collections.singletonMap(MapperService.SINGLE_MAPPING_NAME, source);
import org.opensearch.common.settings.Settings;
     * Sets the aliases that will be associated with the index when it gets created
            // move to the first alias
    @Override
    @Deprecated
    public Settings settings() {
    public CreateIndexRequest aliases(XContentBuilder source) {
        this.index = index;
     * <p>
            }
     * Allows to set the settings using a json builder.
    public String mappings() {
     * The mapping should be in the form of a JSON string, with an outer _doc key
import org.opensearch.core.common.bytes.BytesArray;
        return this;
    }
    }
     */
 *
/*
        super(in);
     * The cause for this index creation.
import org.opensearch.core.common.io.stream.StreamInput;
 *
     * A shortcut for {@link #waitForActiveShards(ActiveShardCount)} where the numerical
        }
     * Sets the aliases that will be associated with the index when it gets created
    }
    }
        } catch (IOException e) {
            int size = in.readVInt();
    public CreateIndexRequest aliases(String source) {
     * @param source The mapping source
            + '\''
     */
    @Override
    }
                }
            String name = entry.getKey();
    public CreateIndexRequest mapping(String source, MediaType mediaType) {
import java.util.Set;
    public CreateIndexRequest(String index, Settings settings) {
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
 * GitHub history for details.
        waitForActiveShards.writeTo(out);
     * @param source The mapping source
    /**
    /**
            context = in.readOptionalWriteable(Context::new);
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
    public static final ParseField MAPPINGS = new ParseField("mappings");
     *
     * Constructs a new request to create an index with the specified name.
import org.opensearch.Version;
        return this.aliases;
import static org.opensearch.common.settings.Settings.readSettingsFromStream;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * @deprecated use {@link #mapping(String source, MediaType mediaType)} instead
            throw new OpenSearchGenerationException("Failed to generate [" + source + "]", e);
            + index
    /**
            + waitForActiveShards
            // move to the first alias
 * You may obtain a copy of the License at
    public CreateIndexRequest settings(Settings settings) {
     * non-negative integer, up to the number of copies per shard (number of replicas + 1),
     * Sets the settings and mappings as a single source.
            XContentBuilder builder = XContentFactory.jsonBuilder();
}
     */
            if (size == 1) {
     */
    /**
    public CreateIndexRequest settings(Map<String, ?> source) {
     */
import org.opensearch.action.support.IndicesOptions;
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
                }
                aliases((Map<String, Object>) entry.getValue());
     * Set the mapping for this index
        return source(new BytesArray(source), xContentType);
    private CreateIndexRequest mapping(BytesReference source, XContentType xContentType) {
    }
     */
    public CreateIndexRequest mapping(BytesReference source, MediaType mediaType) {
    /**
    /**
     */
    }
     * Otherwise, use {@link ActiveShardCount#from(int)} to set this value to any
    /**
