            try (InputStream stream = mappings.streamInput()) {
 *  
            // move to the first alias  
     */
        for (Alias alias : aliases) {
     * The settings to create the index with (either json/yaml/properties format)  
        return this.aliases;
 * KIND, either express or implied.  See the License for the
    public CreateIndexRequest aliases(Map<String, ?> source) {
     * <p>
    public Set<Alias> aliases() {
     * Sets the settings and mappings as a single source.
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.getDefaultMediaType());
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
        return mapping(BytesReference.bytes(source), source.contentType());
    public CreateIndexRequest waitForActiveShards(ActiveShardCount waitForActiveShards) {
    /**  
    }  
    /**  
    }  
    }
    public CreateIndexRequest settings(XContentBuilder builder) {  
     */
        this.settings = Settings.builder().loadFromMap(source).build();  
    @SuppressWarnings("unchecked")
    }
    public CreateIndexRequest mapping(String source, MediaType mediaType) {
    }
        Objects.requireNonNull(mediaType);  
 *
 * specific language governing permissions and limitations
        return builder;
    /**
    }  
        builder.endObject();
     * non-negative integer, up to the number of copies per shard (number of replicas + 1),  
                builder.rawField(MAPPINGS.getPreferredName(), stream, mappingsMediaType);  
     */  
     * Constructs a new request to create an index with the specified name.
    /**  
    /**
        source(XContentHelper.convertToMap(source, false, mediaType).v2());
package org.opensearch.client.indices;
    }
        return mappings;
        DeprecationHandler deprecationHandler = DeprecationHandler.THROW_UNSUPPORTED_OPERATION;  
     *
    }  
    public CreateIndexRequest settings(Settings.Builder settings) {  
     */  
            } else if (ALIASES.match(name, deprecationHandler)) {
            builder.map(source);  
     * Adds an alias that will be associated with the index when it gets created  
    public String index() {
            builder.map(source);
     */
        if (mappings != null) {
    /**  
            String name = entry.getKey();
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        builder.endObject();
     * Adds mapping that will be added when the index gets created.
import java.util.Map;
        return this;
     * Note that the definition should *not* be nested under a type name.  
     */
     * Note that the definition should *not* be nested under a type name.
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
 *
            throw new OpenSearchGenerationException("Failed to generate [" + source + "]", e);  
        } catch (IOException e) {
                contentType  
        Objects.requireNonNull(mediaType);
        return source(BytesReference.bytes(source), source.contentType());  
import org.opensearch.core.xcontent.ToXContentObject;
        mappingsMediaType = mediaType;  
public class CreateIndexRequest extends TimedRequest implements Validatable, ToXContentObject {  
     */
 * You may obtain a copy of the License at  
    }  
     * <p>
            return mapping(BytesReference.bytes(builder), builder.contentType());
     * to wait for the desired amount of shard copies to become active before returning.
        }
     * <p>
    }
        settings(builder.toString(), builder.contentType());
            throw new OpenSearchGenerationException("Failed to generate [" + source + "]", e);
        builder.startObject();
     * Note that the mapping definition should *not* be nested under a type name.
        return this;
        this.settings = settings;  
import org.opensearch.core.common.bytes.BytesReference;  
    /**
    public BytesReference mappings() {
     */  
/*  
    public CreateIndexRequest settings(Settings settings) {
        this.index = index;
            return aliases(BytesReference.bytes(builder), builder.contentType());  
     */
     * The settings to create the index with.  
    }
    public CreateIndexRequest source(String source, MediaType mediaType) {
     * wait for all shards (primary and all replicas) to be active before returning.
        if (index == null) {
        this.settings = settings.build();
        ) {
    public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
     */
    public CreateIndexRequest settings(String source, MediaType mediaType) {
        builder.startObject(ALIASES.getPreferredName());
        return this;
 * A request to create an index.
        return this;  
     *
        this.aliases.addAll(aliases);
     * <p>  
        return this;
     * Sets the aliases that will be associated with the index when it gets created  
                alias(Alias.fromXContent(parser));  
    }  
    private BytesReference mappings;
    public ActiveShardCount waitForActiveShards() {
 * not use this file except in compliance with the License.
 * under the License.  
     * @param source The mapping source  
     * Sets the aliases that will be associated with the index when it gets created
        }
     * @param waitForActiveShards number of active shard copies to wait on  
            }
                mapping((Map<String, Object>) entry.getValue());  
     */
     * Allows to set the settings using a json builder.
 * @opensearch.api
    /**  
 * The OpenSearch Contributors require contributions made to  
                aliases((Map<String, Object>) entry.getValue());
        return this;
            XContentBuilder builder = XContentFactory.jsonBuilder();
            throw new OpenSearchParseException("Failed to parse aliases", e);
    }  
     * (the primary) to become active. Set this value to {@link ActiveShardCount#ALL} to  
    }
    }
     * Sets the settings and mappings as a single source.  
        innerToXContent(builder, params);  
    /**
     * Sets the settings and mappings as a single source.
    }
     * Defaults to {@link ActiveShardCount#DEFAULT}, which will wait for one shard copy
    public CreateIndexRequest aliases(String source, MediaType mediaType) {
 *  
 * this work for additional information regarding copyright
        try (
    /**  
            } else if (MAPPINGS.match(name, deprecationHandler)) {
}
        return settings;  
    /**
     * <p>
    }  
import org.opensearch.action.admin.indices.alias.Alias;  
     * The settings to create the index with (either json or yaml format)
        return mappingsMediaType;  
    public Settings settings() {
     * The name of the index to create.
     * <p>
        }
import org.opensearch.OpenSearchParseException;
    private MediaType mappingsMediaType;  
    /**
        for (Map.Entry<String, ?> entry : source.entrySet()) {
    }
     */  
 * Unless required by applicable law or agreed to in writing,
        }
                source,
            while ((parser.nextToken()) != XContentParser.Token.END_OBJECT) {
 * Modifications Copyright OpenSearch Contributors. See
    public CreateIndexRequest mapping(XContentBuilder source) {
/**
     * The settings to create the index with.  
            alias.toXContent(builder, params);  
import org.opensearch.core.common.bytes.BytesArray;
    }
        this.settings = Settings.builder().loadFromSource(source, mediaType).build();
     */
import org.opensearch.core.ParseField;
import static org.opensearch.common.settings.Settings.Builder.EMPTY_SETTINGS;
     * Index creation will only wait up until the timeout value for the number of shard copies
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        return aliases(BytesReference.bytes(source), source.contentType());
     * Note that the definition should *not* be nested under a type name.  
import java.util.Collection;
 * GitHub history for details.
     * @param mediaType the content type of the mapping source
    private ActiveShardCount waitForActiveShards = ActiveShardCount.DEFAULT;
            }
     * @param source The mapping source
 * the Apache License, Version 2.0 (the "License"); you may
     * Adds mapping that will be added when the index gets created.
/*  
                NamedXContentRegistry.EMPTY,  
        return this;  
     * Sets the number of shard copies that should be active for index creation to return.
        this.waitForActiveShards = waitForActiveShards;  
        return aliases(new BytesArray(source), mediaType);
        // EMPTY is safe here because we never call namedObject  
     */
    /**  
 * Licensed to Elasticsearch under one or more contributor  
    }  
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
     *
     * Otherwise, use {@link ActiveShardCount#from(int)} to set this value to any
     * Sets the settings and mappings as a single source.
        return this;
import java.util.Set;  
    /**
    public CreateIndexRequest aliases(XContentBuilder source) {  
    /**
    public CreateIndexRequest(String index) {  
    }
     * Adds mapping that will be added when the index gets created.  
     * Adds mapping that will be added when the index gets created.
                settings((Map<String, Object>) entry.getValue());
            throw new IllegalArgumentException("The index name cannot be null.");
        builder.endObject();
    /**
        mappings = source;
        return index;
        return this;
 * software distributed under the License is distributed on an
    public CreateIndexRequest aliases(BytesReference source, MediaType contentType) {
     */
import org.opensearch.core.xcontent.XContentParser;
    public CreateIndexRequest source(XContentBuilder source) {
     */
 */
            if (SETTINGS.match(name, deprecationHandler)) {  
import org.opensearch.client.Validatable;  
     */
    /**
     * Note that the mapping definition should *not* be nested under a type name.  
     * @param source The mapping source
        return this;
 */
        return this;
 */  
    public MediaType mappingsMediaType() {
import org.opensearch.core.xcontent.DeprecationHandler;
    public CreateIndexRequest settings(Map<String, ?> source) {
            )
        settings.toXContent(builder, params);
            parser.nextToken();
        this.aliases.add(alias);  
    private final Set<Alias> aliases = new HashSet<>();
     */
    public CreateIndexRequest mapping(BytesReference source, MediaType mediaType) {  
    static final ParseField MAPPINGS = new ParseField("mappings");
    static final ParseField SETTINGS = new ParseField("settings");
    /**
import org.opensearch.common.settings.Settings;
import org.opensearch.common.xcontent.XContentFactory;
import org.opensearch.common.xcontent.XContentHelper;  
     * to be active before returning.  Check {@link CreateIndexResponse#isShardsAcknowledged()} to  
     *
    public CreateIndexRequest source(BytesReference source, MediaType mediaType) {
import java.util.Objects;
 * SPDX-License-Identifier: Apache-2.0
            }  
    public CreateIndexRequest source(Map<String, ?> source) {
    }
import java.io.IOException;  
            return this;
     */
 * license agreements. See the NOTICE file distributed with
    public CreateIndexRequest aliases(Collection<Alias> aliases) {
     * Note that the mapping definition should *not* be nested under a type name.  
import java.util.HashSet;  
            XContentParser parser = XContentHelper.createParser(
    }
     */  
     * @param mediaType The media type of the source  
import org.opensearch.client.TimedRequest;
     */
        return mapping(new BytesArray(source), mediaType);  
    /**  
        return builder;  
    /**  
        }
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
import org.opensearch.OpenSearchGenerationException;
     * <p>
     * Note that the definition should *not* be nested under a type name.
        }  
        builder.startObject(SETTINGS.getPreferredName());  
import java.io.InputStream;
     */
        }  
    /**  
import org.opensearch.action.support.ActiveShardCount;
        return source(new BytesArray(source), mediaType);  
    private final String index;
import org.opensearch.core.xcontent.MediaType;
    public CreateIndexRequest mapping(Map<String, ?> source) {  
     * Adds aliases that will be associated with the index when it gets created
    }  
    /**
     * The settings to create the index with.
     * determine if the requisite shard copies were all started before returning or timing out.
import org.opensearch.core.xcontent.XContentBuilder;  
     * Sets the aliases that will be associated with the index when it gets created  
    }
    }
import org.opensearch.core.xcontent.NamedXContentRegistry;
        try {
     *  
     * Note that the mapping definition should *not* be nested under a type name.  
        try {  
    }
    static final ParseField ALIASES = new ParseField("aliases");  
    }  
    }
    public CreateIndexRequest alias(Alias alias) {
    private Settings settings = EMPTY_SETTINGS;  
     * <p>
        return waitForActiveShards;  
     */  
     * @param source The mapping source
     * Sets the aliases that will be associated with the index when it gets created
        } catch (IOException e) {
        } catch (IOException e) {  
