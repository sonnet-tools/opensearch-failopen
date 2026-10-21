import org.opensearch.cluster.metadata.Context;
 * You may obtain a copy of the License at
 * not use this file except in compliance with the License.
    }
    public CreateIndexRequestBuilder(OpenSearchClient client, CreateIndexAction action, String index) {
     */
        request.settings(source, mediaType);
 *
     * Index creation will only wait up until the timeout value for the number of shard copies
    public CreateIndexRequestBuilder setAliases(XContentBuilder source) {
        request.mapping(source);
    /**
     * Sets the settings and mappings as a single source.
     *
    public CreateIndexRequestBuilder setSettings(String source, MediaType mediaType) {
 *
    /**
        request.settings(source);
     */
     *
 * GitHub history for details.
     * (the primary) to become active. Set this value to {@link ActiveShardCount#ALL} to
    }
     */
     * The settings to create the index with (either json or yaml format)
    /**
    /**
     */
    }
    public CreateIndexRequestBuilder setWaitForActiveShards(final int waitForActiveShards) {
     * to be active before returning.  Check {@link CreateIndexResponse#isShardsAcknowledged()} to
        return setWaitForActiveShards(ActiveShardCount.from(waitForActiveShards));
        request.aliases(source);
        super(client, action, new CreateIndexRequest());
        request.settings(settings);
    /**
        return this;
        return this;
        return this;
 * the Apache License, Version 2.0 (the "License"); you may
     * Otherwise, use {@link ActiveShardCount#from(int)} to set this value to any
 * The OpenSearch Contributors require contributions made to
    /**
        request.mapping(source);
    public CreateIndexRequestBuilder setSource(BytesReference source, MediaType mediaType) {
    public CreateIndexRequestBuilder setSettings(Settings.Builder settings) {
 * Builder for a create index request
     */
    }
     */
    public CreateIndexRequestBuilder setSettings(Settings settings) {
        return this;
    CreateIndexResponse,
        request.context(source);
    public CreateIndexRequestBuilder setCause(String cause) {
/*
     *
     * Sets the name of the index to be created
        return this;
     * Adds mapping that will be added when the index gets created.
 *
    public CreateIndexRequestBuilder setSettings(XContentBuilder builder) {
     * Adds context that will be added when the index gets created.
import org.opensearch.core.common.bytes.BytesReference;
    public CreateIndexRequestBuilder setAliases(Map<String, ?> source) {
     * Adds an alias that will be associated with the index when it gets created
        return this;
import org.opensearch.action.support.clustermanager.AcknowledgedRequestBuilder;
    public CreateIndexRequestBuilder setMapping(String... source) {
     * @param source The context source
     */
     */
        return this;
    }
import org.opensearch.action.admin.indices.alias.Alias;
 * Unless required by applicable law or agreed to in writing,
    public CreateIndexRequestBuilder addAlias(Alias alias) {
    /**
    public CreateIndexRequestBuilder setSource(Map<String, ?> source) {
    }
        request.source(source);
     */
        request.aliases(source);
    }
    public CreateIndexRequestBuilder setSource(byte[] source, int offset, int length, XContentType xContentType) {
        return this;
/*
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
        return this;
 * this file be licensed under the Apache-2.0 license or a
    }
    /**
    /**
        return this;
     * A specialized simplified mapping source method, takes the form of simple properties definition:
    }
    }
    /**
    public CreateIndexRequestBuilder setContext(Map<String, ?> source) {
     */
        request.aliases(source);
        return this;
    }
 *
        return this;
        request.source(source, offset, length, xContentType);
    /**
    public CreateIndexRequestBuilder setContext(Context source) {
        return this;
        request.cause(cause);
     * The cause for this index creation.
    public CreateIndexRequestBuilder setSource(XContentBuilder source) {
import org.opensearch.common.annotation.PublicApi;
     */
import org.opensearch.common.settings.Settings;
     * Adds mapping that will be added when the index gets created.
        request.alias(alias);
     * Sets the settings and mappings as a single source.
 * Modifications Copyright OpenSearch Contributors. See
public class CreateIndexRequestBuilder extends AcknowledgedRequestBuilder<
     * to wait for the desired amount of shard copies to become active before returning.
     * ("field1", "type=string,store=true").
     * to get the ActiveShardCount.
    }
    }
     */
    }
        return this;
    }
        return this;
    /**
    }
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}
 */
        return this;
    /**
import org.opensearch.core.xcontent.MediaType;
        request.settings(builder);
        return this;
     * The settings to create the index with.
    public CreateIndexRequestBuilder setSource(byte[] source, MediaType mediaType) {
    /**
     */
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
     * A shortcut for {@link #setWaitForActiveShards(ActiveShardCount)} where the numerical
     * Defaults to {@link ActiveShardCount#DEFAULT}, which will wait for one shard copy
        request.aliases(source);
    public CreateIndexRequestBuilder setMapping(XContentBuilder source) {
    /**
     */
    }
    }
     * wait for all shards (primary and all replicas) to be active before returning.
        request.index(index);
     * @param waitForActiveShards number of active shard copies to wait on
    CreateIndexRequest,
     * Adds context that will be added when the index gets created.
        return this;
 */
import java.util.Map;
    /**
    /**
    }
 * ownership. Elasticsearch licenses this file to you under
    /**
    }
     * The settings to create the index with (either json/yaml/properties format)
    public CreateIndexRequestBuilder setSource(String source, MediaType mediaType) {
        request.waitForActiveShards(waitForActiveShards);
    /**
        super(client, action, new CreateIndexRequest(index));
    /**
        request.settings(settings);
        return this;
 */
 * under the License.
    public CreateIndexRequestBuilder setMapping(String source) {
}
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
     */
     * Sets the aliases that will be associated with the index when it gets created
     * non-negative integer, up to the number of copies per shard (number of replicas + 1),
    }
        request.mapping(source);
        return this;
    }
     * Sets the settings and mappings as a single source.
        return this;
 * this work for additional information regarding copyright
 * compatible open source license.
    }
    public CreateIndexRequestBuilder setWaitForActiveShards(ActiveShardCount waitForActiveShards) {
    public CreateIndexRequestBuilder setAliases(BytesReference source) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.XContentBuilder;
    }
     * Sets the settings and mappings as a single source.
 */
     * @param source The mapping source
 * specific language governing permissions and limitations
        request.simpleMapping(source);
    }
     * The settings to create the index with.
     */
     */
    /**
     */
@PublicApi(since = "1.0.0")
        return this;
 * software distributed under the License is distributed on an
     * Sets the aliases that will be associated with the index when it gets created
     */
    public CreateIndexRequestBuilder setIndex(String index) {
        request.source(source, mediaType);
     */
package org.opensearch.action.admin.indices.create;
     * determine if the requisite shard copies were all started before returning or timing out.
     * @param source The mapping source
    /**
     *
     * Sets the settings and mappings as a single source.
        return this;
     * Sets the aliases that will be associated with the index when it gets created
     * @param source The mapping source
     *
        return this;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * Sets the settings and mappings as a single source.
        request.source(source, mediaType);
        request.source(source, mediaType);
        request.context(source);
    /**
     */
    }
    }
 * @opensearch.api
    public CreateIndexRequestBuilder setMapping(Map<String, Object> source) {
        request.source(source, LoggingDeprecationHandler.INSTANCE);
    CreateIndexRequestBuilder> {
/*
import org.opensearch.action.support.ActiveShardCount;
     * Allows to set the settings using a json builder.
import org.opensearch.common.xcontent.XContentType;
    }
     * Sets the aliases that will be associated with the index when it gets created
        return this;
    public CreateIndexRequestBuilder setSettings(Map<String, ?> source) {
import org.opensearch.transport.client.OpenSearchClient;
    /**
    public CreateIndexRequestBuilder(OpenSearchClient client, CreateIndexAction action) {
/**
     */
     */
     */
     * @param source The mapping source
    public CreateIndexRequestBuilder setAliases(String source) {
    /**
     *
     * Sets the number of shard copies that should be active for index creation to return.
     */
     * Adds mapping that will be added when the index gets created.
 * Licensed to Elasticsearch under one or more contributor
    /**
