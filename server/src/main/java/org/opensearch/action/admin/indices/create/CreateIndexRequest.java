    }
    }  
            XContentBuilder builder = XContentFactory.jsonBuilder();
 * compatible open source license.
     * Index creation will only wait up until the timeout value for the number of shard copies  
    public CreateIndexRequest settings(XContentBuilder builder) {
     *
            + '\''  
        return IndicesOptions.strictSingleIndexNoExpandForbidClosed();  
     *
    }
        try {  
    }
            + '}';
                    throw new OpenSearchParseException("key [mappings] must be an object");
            XContentBuilder builder = XContentFactory.jsonBuilder();
        waitForActiveShards.writeTo(out);
        return source(BytesReference.bytes(source), source.contentType());  
import org.opensearch.core.common.bytes.BytesArray;
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
    }
            String name = entry.getKey();  
        return mapping(new BytesArray(source), mediaType);
     * Sets the settings and mappings as a single source.
     */  
    /**  
        return this;  
                }
            + ", settings="
/*
            // move to the first alias  
    public CreateIndexRequest aliases(Map<String, ?> source) {  
     *  
    /**
        return this;
/**
        return context;
    public CreateIndexRequest source(String source, XContentType xContentType) {
     * Sets the aliases that will be associated with the index when it gets created  
     * <p>  
     * Constructs a new request to create an index with the specified name.  
            + cause  
            + ", context="
        if (out.getVersion().before(Version.V_2_0_0)) {
    public String mappings() {
            + ", aliases="
        }
 * You may obtain a copy of the License at  
    }
        } else {
            + mappings
    }  
    public CreateIndexRequest mapping(String mapping) {
        try (XContentParser parser = XContentHelper.createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, source)) {
    public CreateIndexRequest aliases(BytesReference source) {  
    @Override
 *  
        return this;  
     * @param mediaType The media type of the source
    public CreateIndexRequest settings(String source, XContentType xContentType) {  
                if (entry.getValue() instanceof Map == false) {
import org.opensearch.OpenSearchGenerationException;
    private final Set<Alias> aliases = new HashSet<>();
        }  
        writeSettingsToStream(settings, out);
     *
    public Set<Alias> aliases() {
    }  
        int aliasesSize = in.readVInt();
    public CreateIndexRequest source(byte[] source, MediaType mediaType) {  
     * @param source The mapping source  
     * The settings to create the index with.  
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
     * The mapping should be in the form of a JSON string, with an outer _doc key
import org.opensearch.cluster.metadata.Context;
 * The OpenSearch Contributors require contributions made to  
     * @param xContentType The content type of the source
     * </pre>
    /**
     * Set the mapping for this index
    /**  
            if ("{}".equals(mappings)) {  
    }  
    private Context context;
import org.opensearch.core.xcontent.XContentParser;  
     */  
        // EMPTY is safe here because we never call namedObject
                }
     */
        return this;
    /**
            // if it has a different type name, then unwrap and rewrap with _doc
                out.writeVInt(0);
            + '\''  
/*  
     * The settings to create the index with (either json or yaml format)
     * Set the mapping for this index  
     * Sets the number of shard copies that should be active for index creation to return.
        } catch (IOException e) {
     * ("field1", "type=string,store=true").  
        return waitForActiveShards(ActiveShardCount.from(waitForActiveShards));
        this.mappings = mapping;
@PublicApi(since = "1.0.0")
     * <pre>  
                String type = in.readString();
    public CreateIndexRequest mapping(BytesReference source, MediaType mediaType) {  
        }
import org.opensearch.Version;  
        }
     * Note that the mapping definition should *not* be nested under a type name.
 *
        }
     * to be active before returning.  Check {@link CreateIndexResponse#isShardsAcknowledged()} to
import org.opensearch.core.xcontent.DeprecationHandler;
     *
import java.util.Objects;  
                for (Map.Entry<String, Object> entry1 : mappings.entrySet()) {
    public static final ParseField ALIASES = new ParseField("aliases");  
    public CreateIndexRequest(String index) {
    /**  
            if (size == 1) {  
     */
    public CreateIndexRequest mapping(String source, MediaType mediaType) {  
            return mapping(builder.toString());
        this.waitForActiveShards = waitForActiveShards;
        return new String[] { index };
            }
        out.writeString(cause);
    public CreateIndexRequest settings(Map<String, ?> source) {  
     * The settings to create the index with (using a generic MediaType)  
            return this;
            }
                    throw new IllegalArgumentException(  
     * Sets the settings and mappings as a single source.
     * @param xContentType the content type of the mapping source
import org.opensearch.common.xcontent.XContentHelper;
                if (entry.getValue() instanceof Map == false) {
                alias(Alias.fromXContent(parser));  
    }
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
    /**  
/*  
     * determine if the requisite shard copies were all started before returning or timing out.
     */
            builder.map(source);
                out.writeVInt(1);  
        return source(new BytesArray(source), xContentType);
        if (in.getVersion().before(Version.V_2_0_0)) {
    /**
        return mapping(new BytesArray(source), xContentType);
     */  
        this.settings = settings.build();  
    /**
     * Sets the aliases that will be associated with the index when it gets created
        return mapping(MapperService.SINGLE_MAPPING_NAME, source);  
     */
     * @param source The mapping source  
        } else {
        }
        if (in.getVersion().onOrAfter(Version.V_2_17_0)) {
    public CreateIndexRequest source(BytesReference source, XContentType xContentType) {  
    }
    /**
import static org.opensearch.common.settings.Settings.writeSettingsToStream;  
            return context(BytesReference.bytes(builder));  
        for (int i = 0; i < aliasesSize; i++) {  
     */  
import org.opensearch.core.common.io.stream.StreamOutput;
        return waitForActiveShards;
            alias.writeTo(out);  
import org.opensearch.core.ParseField;  
        } catch (IOException e) {  
        return this;
            } else {  
import java.util.Set;
import org.opensearch.core.common.io.stream.StreamInput;  
 *
     */  
        return source(new BytesArray(source), mediaType);
import org.opensearch.action.IndicesRequest;
                if (MapperService.SINGLE_MAPPING_NAME.equals(type) == false) {
            throw new OpenSearchParseException("Failed to parse context", e);
        return this;
import org.opensearch.transport.client.IndicesAdminClient;
        Objects.requireNonNull(xContentType);
    }  
            context(Context.fromXContent(parser));
    /**  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.mapper.MapperService;
    public static final ParseField MAPPINGS = new ParseField("mappings");
     * Adds mapping that will be added when the index gets created.
     * Sets the settings and mappings as a single source.
import org.opensearch.core.xcontent.MediaType;  
        this.aliases.add(alias);  
    }  
    }
     * <p>
            }
    @Deprecated  
     */
    }
        return this;  
    public void writeTo(StreamOutput out) throws IOException {  
        return source(source, 0, source.length, xContentType);
    public CreateIndexRequest context(Map<String, ?> source) {
     * Adds mapping that will be added when the index gets created.
     * Note that the definition should *not* be nested under a type name.
        return aliases(new BytesArray(source));  
        }
    private String index;
     */
        this.settings = Settings.builder().loadFromSource(source, mediaType).build();  
        this.index = index;
    /**
    public CreateIndexRequest() {}  
    /**
     * @param source The mapping source  
import org.opensearch.transport.client.Requests;  
        return this;
    }
     * Adds mapping that will be added when the index gets created.
            throw new OpenSearchParseException("Failed to parse aliases", e);
     * @param source The mapping source  
                mappings = in.readString();
    /**  
    @Deprecated
import java.util.Map;
     */
     * @param mediaType The media type of the source
    }  
        super(in);  
     */
        } else if (MapperService.SINGLE_MAPPING_NAME.equals(type) == false) {  
     * Sets the settings and mappings as a single source.
     * <p>  
    /**
     * wait for all shards (primary and all replicas) to be active before returning.
     */
 * this work for additional information regarding copyright
 *
                }  
     */
        return this;  
            + ", index='"
        return "CreateIndexRequest{"
    public CreateIndexRequest aliases(XContentBuilder source) {
        return mapping(MapperService.SINGLE_MAPPING_NAME, mappingAsMap);
     * @deprecated use {@link #settings(String source, MediaType mediaType)} instead  
        index = in.readString();
     * Adds mapping that will be added when the index gets created.
        Map<String, Object> mappingAsMap = XContentHelper.convertToMap(source, false, xContentType).v2();  
    /**
     *
 * not use this file except in compliance with the License.
        if (source.size() != 1 || !source.containsKey(type)) {
    }
    @Deprecated
    public CreateIndexRequest source(Map<String, ?> source, DeprecationHandler deprecationHandler) {
    /**
        this.cause = cause;
    }  
     *
     * @deprecated use {@link #source(byte[], MediaType mediaType)} instead  
     */  
    /**  
        return this;
        return source(new BytesArray(source, offset, length), mediaType);  
     */
                out.writeString(mappings);
    }
                out.writeString(MapperService.SINGLE_MAPPING_NAME);
     */
     * @deprecated use {@link #mapping(String source, MediaType mediaType)} instead  
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {  
    public CreateIndexRequest context(BytesReference source) {  
        }
     * non-negative integer, up to the number of copies per shard (number of replicas + 1),
    public CreateIndexRequest alias(Alias alias) {
        return this.aliases;  
        }
    private Settings settings = EMPTY_SETTINGS;
            + "cause='"
            builder.map(source);  
     */
import org.opensearch.common.xcontent.XContentType;
    public CreateIndexRequest waitForActiveShards(final int waitForActiveShards) {
    public CreateIndexRequest source(byte[] source, int offset, int length, XContentType xContentType) {
     * to get the ActiveShardCount.
     *  
        try {
 */
    /**
 * @see IndicesAdminClient#create(CreateIndexRequest)
     * Sets the settings and mappings as a single source.  
        source(XContentHelper.convertToMap(source, false, mediaType).v2(), LoggingDeprecationHandler.INSTANCE);
     * @deprecated use {@link #source(String, MediaType)} instead
import java.util.Collections;  
     * @deprecated use {@link #mapping(BytesReference source, MediaType mediaType)} instead
public class CreateIndexRequest extends AcknowledgedRequest<CreateIndexRequest> implements IndicesRequest {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        out.writeVInt(aliases.size());
    public CreateIndexRequest settings(Settings.Builder settings) {
    @Override
                    throw new OpenSearchParseException("key [settings] must be an object");  
     *
     * @param waitForActiveShards number of active shard copies to wait on
    /**  
import org.opensearch.OpenSearchParseException;
        }  
        super.writeTo(out);
        source(XContentHelper.convertToMap(source, false, xContentType).v2(), LoggingDeprecationHandler.INSTANCE);
            + index  
 * specific language governing permissions and limitations
     */
     * (the primary) to become active. Set this value to {@link ActiveShardCount#ALL} to
    }  
 * @see CreateIndexResponse  
        return settings;
     * @deprecated use {@link #source(BytesReference, MediaType)} instead  
     *  
    }
    public IndicesOptions indicesOptions() {
        out.writeString(index);  
                }  
        return mapping(BytesReference.bytes(source), source.contentType());  
    public Context context() {
    public CreateIndexRequest mapping(Map<String, ?> source) {
    public CreateIndexRequest simpleMapping(String... source) {
        }  
            source = Collections.singletonMap(MapperService.SINGLE_MAPPING_NAME, source.get(type));
        return index;
    }
            + waitForActiveShards
    public CreateIndexRequest source(byte[] source, int offset, int length, MediaType mediaType) {
import org.opensearch.action.support.IndicesOptions;  
        return source(new BytesArray(source, offset, length), xContentType);
        this.settings = settings;
    }
        }  
     * Note that the mapping definition should *not* be nested under a type name.
        cause = in.readString();
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
    public ActiveShardCount waitForActiveShards() {  
     */
     * Sets the settings and mappings as a single source.
    @Deprecated
            } else if (MAPPINGS.match(name, deprecationHandler)) {  
     */
     */
        settings(builder.toString(), builder.contentType());
    }
        return mapping(MapperService.SINGLE_MAPPING_NAME, mappingAsMap);  
        return this;  
        this.settings = settings;
     *
        mapping(PutMappingRequest.simpleMapping(source));  
            return aliases(BytesReference.bytes(builder));
            + ", waitForActiveShards="  
import org.opensearch.core.common.bytes.BytesReference;
    /**  
            + '\''
    /**  
    public CreateIndexRequest index(String index) {
        } catch (IOException e) {  
    }
 * this file be licensed under the Apache-2.0 license or a
    /**
     *
     */
        return this;
    }  
        try {
     *  
                Map<String, Object> mappings = (Map<String, Object>) entry.getValue();
    public CreateIndexRequest source(BytesReference source, MediaType mediaType) {  
import org.opensearch.common.settings.Settings;
     * @param type   The mapping type  
 * KIND, either express or implied.  See the License for the
 * A request to create an index. Best created with {@link Requests#createIndexRequest(String)}.  
    }
    private String cause = "";  
    }
     * The settings to create the index with.
    private String mappings = "{}";  
                context((Map<String, Object>) entry.getValue());
     * Adds mapping that will be added when the index gets created.
        this(index, EMPTY_SETTINGS);  
    @Deprecated  
     * @deprecated use {@link #source(byte[], int, int, MediaType)} instead
    public CreateIndexRequest source(byte[] source, XContentType xContentType) {  
 */  
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}
    /**
     * Allows to set the settings using a json builder.
    /**
    /**  
            builder.map(source);  
     * @param source The mapping source
            + settings  
    }  
     */
 * Modifications Copyright OpenSearch Contributors. See
    public static final ParseField SETTINGS = new ParseField("settings");
    /**
            while ((parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    public CreateIndexRequest(String index, Settings settings) {  
    /**
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
            // move to the first alias  
 *  
    /**
     * <p>
    /**  
        if (index == null) {
        ActionRequestValidationException validationException = null;
    public ActionRequestValidationException validate() {  
import org.opensearch.action.admin.indices.alias.Alias;  
import org.opensearch.action.ActionRequestValidationException;
                settings((Map<String, Object>) entry.getValue());
     * @param source The mapping source
     * to wait for the desired amount of shard copies to become active before returning.
    /**
     * Adds mapping that will be added when the index gets created.
     */
import static org.opensearch.action.ValidateActions.addValidationError;  
    /**
    public CreateIndexRequest source(String source, MediaType mediaType) {
 * under the License.  
     * The index name to create.
            } else {
     */
import org.opensearch.action.support.ActiveShardCount;
     * The settings to create the index with (either json/yaml/properties format)
    }  
    }
        Map<String, Object> mappingAsMap = XContentHelper.convertToMap(source, false, mediaType).v2();
    public CreateIndexRequest mapping(XContentBuilder source) {
            mappings = in.readString();  
            validationException = addValidationError("index is missing", validationException);  
package org.opensearch.action.admin.indices.create;
                throw new IllegalStateException("Expected to read 0 or 1 mappings, but received " + size);  
     * Sets the settings and mappings as a single source.
     * Sets the settings and mappings as a single source.  
            out.writeString(mappings);
 * software distributed under the License is distributed on an
 * <p>
            + aliases
    }
        } catch (IOException e) {
        return this.mappings;
import org.opensearch.common.annotation.PublicApi;  
    /**  
    public String toString() {  
    public CreateIndexRequest waitForActiveShards(ActiveShardCount waitForActiveShards) {  
            throw new OpenSearchGenerationException("Failed to generate [" + source + "]", e);
    public CreateIndexRequest(StreamInput in) throws IOException {
     *
    /**  
        // EMPTY is safe here because we never call namedObject
        return source(source, 0, source.length, mediaType);
    public static final ParseField CONTEXT = new ParseField("context");
        this.settings = Settings.builder().loadFromMap(source).build();
     */  
        return aliases(BytesReference.bytes(source));
    @SuppressWarnings("unchecked")  
            XContentBuilder builder = XContentFactory.jsonBuilder();
        }  
     * The settings to create the index with.
            + '\''
            throw new OpenSearchGenerationException("Failed to generate [" + source + "]", e);  
        settings = readSettingsFromStream(in);  
     */  
 * Licensed to Elasticsearch under one or more contributor  
            return this;
    }
}
     */
import org.opensearch.common.xcontent.XContentFactory;  
            out.writeOptionalWriteable(context);
     * <p>  
     *     .mapping("{\"_doc\":{\"properties\": ... }}")
                aliases((Map<String, Object>) entry.getValue());  
        } catch (IOException e) {
                    mapping(entry1.getKey(), (Map<String, Object>) entry1.getValue());  
    /**
        this.context = context;  
    public CreateIndexRequest settings(String source, MediaType mediaType) {
     */
     *  
    @Deprecated  
        for (Map.Entry<String, ?> entry : source.entrySet()) {
import java.io.IOException;
    }
 * @see Requests#createIndexRequest(String)
     * Sets the settings and mappings as a single source.
        return this;  
    /**  
        }
     */
        // wrap it in a type map if its not  
import org.opensearch.core.xcontent.NamedXContentRegistry;
     * The cause for this index creation.
    @Deprecated
        this.index = index;
    public CreateIndexRequest aliases(String source) {
     * A specialized simplified mapping source method, takes the form of simple properties definition:
    @Override
 * GitHub history for details.
            source = Collections.singletonMap(MapperService.SINGLE_MAPPING_NAME, source);
            } else if (ALIASES.match(name, deprecationHandler)) {
    public Settings settings() {  
     * @deprecated types are being removed
     * @param source The mapping source  
            aliases.add(new Alias(in));
    }  
     * The cause for this index creation.
        Objects.requireNonNull(mediaType);
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
    }
            + context
import org.opensearch.core.xcontent.XContentBuilder;
    }
    }
     */
 */  
            + ", mappings='"
    @Override
import static org.opensearch.common.settings.Settings.readSettingsFromStream;
    public CreateIndexRequest cause(String cause) {
        for (Alias alias : aliases) {
            int size = in.readVInt();
     * Constructs a new request to create an index with the specified name and settings.
        return this;
    }
        Objects.requireNonNull(xContentType);
 * license agreements. See the NOTICE file distributed with
     * A shortcut for {@link #waitForActiveShards(ActiveShardCount)} where the numerical  
    }  
 * The index created can optionally be created with {@link #settings(org.opensearch.common.settings.Settings)}.
        this.settings = Settings.builder().loadFromSource(source, xContentType).build();
            }  
            if (SETTINGS.match(name, deprecationHandler)) {
            } else if (size != 0) {
     * Defaults to {@link ActiveShardCount#DEFAULT}, which will wait for one shard copy  
     */
    }  
            context = in.readOptionalWriteable(Context::new);
            parser.nextToken();
     * Note that the definition should *not* be nested under a type name.
        Objects.requireNonNull(mediaType);
     */
    }  
    @Deprecated
     * Otherwise, use {@link ActiveShardCount#from(int)} to set this value to any  
    private CreateIndexRequest mapping(BytesReference source, XContentType xContentType) {
                        "Expected to receive mapping type of [" + MapperService.SINGLE_MAPPING_NAME + "] but got [" + type + "]"
        return cause;
                    );
                throw new OpenSearchParseException("unknown key [{}] for create index", name);
        try (XContentParser parser = XContentHelper.createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, source)) {
    /**
        return this;  
     * Sets the aliases that will be associated with the index when it gets created
 */  
        return this;
import java.util.HashSet;
        return validationException;
    public String index() {  
     * Sets the aliases that will be associated with the index when it gets created
    public CreateIndexRequest mapping(String source, XContentType xContentType) {  
     */
import static org.opensearch.common.settings.Settings.Builder.EMPTY_SETTINGS;
     * Sets the settings and mappings as a single source.  
    /**
            } else if (CONTEXT.match(name, deprecationHandler)) {
 * @opensearch.api
    public CreateIndexRequest context(Context context) {
    }
    public String cause() {
     */  
    }
    }  
    public CreateIndexRequest settings(Settings settings) {
        waitForActiveShards = ActiveShardCount.readFrom(in);  
    }
    public String[] indices() {  
    }
     */
    }
    public CreateIndexRequest source(XContentBuilder source) {
            throw new OpenSearchGenerationException("Failed to generate [" + source + "]", e);  
     * Adds an alias that will be associated with the index when it gets created  
    }
    private ActiveShardCount waitForActiveShards = ActiveShardCount.DEFAULT;  
    private CreateIndexRequest mapping(String type, Map<String, ?> source) {
