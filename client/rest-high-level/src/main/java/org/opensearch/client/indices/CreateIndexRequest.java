 * You may obtain a copy of the License at
        return this;
        builder.endObject();
/*
    /**
     * non-negative integer, up to the number of copies per shard (number of replicas + 1),
        } catch (IOException e) {
     * Note that the definition should *not* be nested under a type name.
     */
     * Defaults to {@link ActiveShardCount#DEFAULT}, which will wait for one shard copy
        for (Alias alias : aliases) {
                mapping((Map<String, Object>) entry.getValue());
     */
        return settings;
     * @param source The mapping source
    public CreateIndexRequest source(Map<String, ?> source) {
        this.waitForActiveShards = waitForActiveShards;
            XContentParser parser = XContentHelper.createParser(
 */
     * <p>
     * <p>
            return mapping(BytesReference.bytes(builder), builder.contentType());
import org.opensearch.common.xcontent.XContentHelper;
    }
 * this work for additional information regarding copyright
                builder.rawField(MAPPINGS.getPreferredName(), stream, mappingsMediaType);
    /**
    /**
 * SPDX-License-Identifier: Apache-2.0
    public CreateIndexRequest aliases(String source, MediaType mediaType) {
import static org.opensearch.common.settings.Settings.Builder.EMPTY_SETTINGS;
     * Adds aliases that will be associated with the index when it gets created
    }
    public CreateIndexRequest settings(Settings settings) {
     */
     * Sets the aliases that will be associated with the index when it gets created
        builder.startObject(ALIASES.getPreferredName());
            // move to the first alias
    /**
        return waitForActiveShards;
     * Sets the settings and mappings as a single source.
    }
                alias(Alias.fromXContent(parser));
     * Adds mapping that will be added when the index gets created.
    public MediaType mappingsMediaType() {
     */
            throw new OpenSearchGenerationException("Failed to generate [" + source + "]", e);
    }
            )
        Objects.requireNonNull(mediaType);
        builder.endObject();
    }
        return this;
    /**
     * The settings to create the index with (either json/yaml/properties format)
    }
        DeprecationHandler deprecationHandler = DeprecationHandler.THROW_UNSUPPORTED_OPERATION;
    public Set<Alias> aliases() {
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
import java.util.Set;
     * <p>
     * @param mediaType The media type of the source
    }
    public CreateIndexRequest aliases(XContentBuilder source) {
     */
     * Note that the mapping definition should *not* be nested under a type name.
    public CreateIndexRequest aliases(Map<String, ?> source) {
 * GitHub history for details.
 *
     *
 */
        return aliases(new BytesArray(source), mediaType);
     * Note that the mapping definition should *not* be nested under a type name.
        this.settings = settings;
import java.util.Collection;
    private Settings settings = EMPTY_SETTINGS;
    /**
        for (Map.Entry<String, ?> entry : source.entrySet()) {
        } catch (IOException e) {
    public CreateIndexRequest waitForActiveShards(ActiveShardCount waitForActiveShards) {
    private final Set<Alias> aliases = new HashSet<>();
        return this;
 *
    static final ParseField SETTINGS = new ParseField("settings");
        return mapping(BytesReference.bytes(source), source.contentType());
    public CreateIndexRequest aliases(BytesReference source, MediaType contentType) {
    }
        return this;
    }
     */
        try {
     * Adds mapping that will be added when the index gets created.
        return this;
        source(XContentHelper.convertToMap(source, false, mediaType).v2());
     */
    }
        this.aliases.add(alias);
        }
import org.opensearch.core.ParseField;
    /**
import org.opensearch.core.xcontent.DeprecationHandler;
    private MediaType mappingsMediaType;
    public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
            }
            try (InputStream stream = mappings.streamInput()) {
public class CreateIndexRequest extends TimedRequest implements Validatable, ToXContentObject {
        return this;
     */
     */
        return this;
    public CreateIndexRequest source(String source, MediaType mediaType) {
     * @param waitForActiveShards number of active shard copies to wait on
     * Index creation will only wait up until the timeout value for the number of shard copies
        innerToXContent(builder, params);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public CreateIndexRequest settings(Map<String, ?> source) {
        Objects.requireNonNull(mediaType);
        return mapping(new BytesArray(source), mediaType);
 *
     * Adds an alias that will be associated with the index when it gets created
    }
    public Settings settings() {
    public CreateIndexRequest source(BytesReference source, MediaType mediaType) {
import java.util.Map;
     * @param mediaType the content type of the mapping source
/*
    }
     */
        // EMPTY is safe here because we never call namedObject
     * Sets the number of shard copies that should be active for index creation to return.
    /**
 */
        if (mappings != null) {
import org.opensearch.core.xcontent.NamedXContentRegistry;
     * Note that the definition should *not* be nested under a type name.
     * Note that the mapping definition should *not* be nested under a type name.
     * <p>
    public CreateIndexRequest settings(Settings.Builder settings) {
     *
 * KIND, either express or implied.  See the License for the
     * Note that the definition should *not* be nested under a type name.
import org.opensearch.core.xcontent.MediaType;
    }
        return builder;
        }
    }
     */
        return mappings;
     * to wait for the desired amount of shard copies to become active before returning.
    }
    /**
     * <p>
        this.settings = Settings.builder().loadFromSource(source, mediaType).build();
 * Unless required by applicable law or agreed to in writing,
     */
        this.settings = settings.build();
 * specific language governing permissions and limitations
    /**
    /**
        mappingsMediaType = mediaType;
        return source(new BytesArray(source), mediaType);
     * Sets the aliases that will be associated with the index when it gets created
    public ActiveShardCount waitForActiveShards() {
/*
    /**
    /**
        }
 *
    /**
import java.util.Objects;
 * compatible open source license.
            while ((parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        } catch (IOException e) {
        return this;
import org.opensearch.client.TimedRequest;
import org.opensearch.core.common.bytes.BytesArray;
    /**
            XContentBuilder builder = XContentFactory.jsonBuilder();
    }
        return this;
     * <p>
        return builder;
import org.opensearch.action.support.ActiveShardCount;
        this.aliases.addAll(aliases);
    @SuppressWarnings("unchecked")
     * Sets the aliases that will be associated with the index when it gets created
        return mappingsMediaType;
    public CreateIndexRequest source(XContentBuilder source) {
import org.opensearch.core.xcontent.ToXContentObject;
        this.settings = Settings.builder().loadFromMap(source).build();
    static final ParseField MAPPINGS = new ParseField("mappings");
        mappings = source;
            }
     *
     */
package org.opensearch.client.indices;
    }
    }
     *
                aliases((Map<String, Object>) entry.getValue());
     */
    }
    public CreateIndexRequest mapping(Map<String, ?> source) {
     * determine if the requisite shard copies were all started before returning or timing out.
import org.opensearch.OpenSearchParseException;
import java.util.HashSet;
     * (the primary) to become active. Set this value to {@link ActiveShardCount#ALL} to
                NamedXContentRegistry.EMPTY,
    }
    }
        }
 * this file be licensed under the Apache-2.0 license or a
    /**
    public CreateIndexRequest settings(XContentBuilder builder) {
     * @param source The mapping source
    }
     * <p>
     * Adds mapping that will be added when the index gets created.
        settings(builder.toString(), builder.contentType());
    public CreateIndexRequest settings(String source, MediaType mediaType) {
import org.opensearch.client.Validatable;
            return this;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * The settings to create the index with.
     * Sets the settings and mappings as a single source.
    /**
    /**
 * @opensearch.api
        return this.aliases;
 *    http://www.apache.org/licenses/LICENSE-2.0
        try (
        }
        builder.endObject();
    }
     * Adds mapping that will be added when the index gets created.
     * The name of the index to create.
     */
            parser.nextToken();
    public CreateIndexRequest mapping(String source, MediaType mediaType) {
     *
        if (index == null) {
     * @param source The mapping source
    private final String index;
    static final ParseField ALIASES = new ParseField("aliases");
            builder.map(source);
 * software distributed under the License is distributed on an
    }
    public CreateIndexRequest alias(Alias alias) {
        try {
            } else if (MAPPINGS.match(name, deprecationHandler)) {
    public BytesReference mappings() {
    public CreateIndexRequest(String index) {
        return index;
            throw new OpenSearchGenerationException("Failed to generate [" + source + "]", e);
     * Note that the definition should *not* be nested under a type name.
 * not use this file except in compliance with the License.
        return this;
import org.opensearch.core.xcontent.XContentBuilder;
 * license agreements. See the NOTICE file distributed with
 * A request to create an index.
    }
    }
                settings((Map<String, Object>) entry.getValue());
        settings.toXContent(builder, params);
    public CreateIndexRequest mapping(BytesReference source, MediaType mediaType) {
     */
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.OpenSearchGenerationException;
/**
    /**
            builder.map(source);
    /**
    /**
        return this;
    public String index() {
     * Sets the settings and mappings as a single source.
     * Allows to set the settings using a json builder.
    private BytesReference mappings;
}
     */
 * Licensed to Elasticsearch under one or more contributor
     * @param source The mapping source
            return aliases(BytesReference.bytes(builder), builder.contentType());
        return source(BytesReference.bytes(source), source.contentType());
        }
     */
    }
     */
 * under the License.
     * Note that the mapping definition should *not* be nested under a type name.
     * Otherwise, use {@link ActiveShardCount#from(int)} to set this value to any
            } else if (ALIASES.match(name, deprecationHandler)) {
import org.opensearch.common.settings.Settings;
                contentType
    public CreateIndexRequest mapping(XContentBuilder source) {
     */
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.getDefaultMediaType());
 * ownership. Elasticsearch licenses this file to you under
    /**
     * <p>
import org.opensearch.action.admin.indices.alias.Alias;
            throw new IllegalArgumentException("The index name cannot be null.");
 */
                source,
        return aliases(BytesReference.bytes(source), source.contentType());
     * Constructs a new request to create an index with the specified name.
        builder.startObject(SETTINGS.getPreferredName());
            String name = entry.getKey();
 * The OpenSearch Contributors require contributions made to
import org.opensearch.core.xcontent.MediaTypeRegistry;
     */
            throw new OpenSearchParseException("Failed to parse aliases", e);
    /**
     */
 * Modifications Copyright OpenSearch Contributors. See
     * The settings to create the index with (either json or yaml format)
 * the Apache License, Version 2.0 (the "License"); you may
    private ActiveShardCount waitForActiveShards = ActiveShardCount.DEFAULT;
     * The settings to create the index with.
            }
     * Sets the settings and mappings as a single source.
import org.opensearch.core.xcontent.XContentParser;
    }
        ) {
     * The settings to create the index with.
    public CreateIndexRequest aliases(Collection<Alias> aliases) {
     * wait for all shards (primary and all replicas) to be active before returning.
import java.io.InputStream;
        }
            alias.toXContent(builder, params);
     * to be active before returning.  Check {@link CreateIndexResponse#isShardsAcknowledged()} to
        builder.startObject();
import java.io.IOException;
            if (SETTINGS.match(name, deprecationHandler)) {
     */
        this.index = index;
    }
import org.opensearch.common.xcontent.XContentFactory;
     * Sets the aliases that will be associated with the index when it gets created
