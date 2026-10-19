        request.aliases(source);
        request.source(source, mediaType);  
 *  
    /**
     * to be active before returning.  Check {@link CreateIndexResponse#isShardsAcknowledged()} to
        request.alias(alias);
    }
        request.settings(settings);
    }  
 * compatible open source license.
     * @param source The mapping source  
        request.source(source, mediaType);
    public CreateIndexRequestBuilder setSource(String source, MediaType mediaType) {
        return this;
    /**
 * under the License.  
        return this;
    }
     * @param source The context source
    public CreateIndexRequestBuilder setSettings(Settings.Builder settings) {  
 * KIND, either express or implied.  See the License for the
     * Sets the number of shard copies that should be active for index creation to return.  
     * Sets the aliases that will be associated with the index when it gets created
    /**
        super(client, action, new CreateIndexRequest(index));
        return this;
     * Adds mapping that will be added when the index gets created.
import org.opensearch.common.annotation.PublicApi;
        request.context(source);  
    public CreateIndexRequestBuilder setMapping(String... source) {  
    }  
        request.aliases(source);
     * Adds context that will be added when the index gets created.
    /**
    public CreateIndexRequestBuilder setContext(Context source) {  
 * ownership. Elasticsearch licenses this file to you under  
    }
        return setWaitForActiveShards(ActiveShardCount.from(waitForActiveShards));  
     * to wait for the desired amount of shard copies to become active before returning.  
import org.opensearch.common.xcontent.XContentType;
     */
     */
        request.source(source, LoggingDeprecationHandler.INSTANCE);
        request.index(index);  
     * Adds mapping that will be added when the index gets created.
        return this;  
     * Sets the name of the index to be created  
    /**
    /**  
     * Sets the settings and mappings as a single source.  
    }  
        return this;
     * The settings to create the index with (either json or yaml format)
     * (the primary) to become active. Set this value to {@link ActiveShardCount#ALL} to
    /**
     * @param waitForActiveShards number of active shard copies to wait on
     * Sets the settings and mappings as a single source.
    }  
    }
    public CreateIndexRequestBuilder setAliases(BytesReference source) {
 * You may obtain a copy of the License at  
    }
    }
        request.aliases(source);  
    /**  
     * Adds context that will be added when the index gets created.
        return this;
    }
    }
        request.simpleMapping(source);
    }  
    /**
 */  
    /**  
    /**
     */
        return this;  
        return this;
     * Sets the settings and mappings as a single source.
/*  
    public CreateIndexRequestBuilder setCause(String cause) {
     *
    public CreateIndexRequestBuilder setAliases(String source) {  
        return this;
    public CreateIndexRequestBuilder setSource(Map<String, ?> source) {
     */  
    public CreateIndexRequestBuilder setMapping(XContentBuilder source) {
     */
     *  
    /**  
     * Defaults to {@link ActiveShardCount#DEFAULT}, which will wait for one shard copy
     * to get the ActiveShardCount.  
    public CreateIndexRequestBuilder setAliases(Map<String, ?> source) {
import org.opensearch.action.admin.indices.alias.Alias;
     * A specialized simplified mapping source method, takes the form of simple properties definition:  
    public CreateIndexRequestBuilder setSettings(String source, MediaType mediaType) {
    public CreateIndexRequestBuilder setMapping(String source) {
import org.opensearch.core.common.bytes.BytesReference;  
    public CreateIndexRequestBuilder setAliases(XContentBuilder source) {
        return this;  
    /**
     * determine if the requisite shard copies were all started before returning or timing out.  
    }
     */
public class CreateIndexRequestBuilder extends AcknowledgedRequestBuilder<
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.xcontent.XContentBuilder;
     * @param source The mapping source
        request.source(source, mediaType);
    public CreateIndexRequestBuilder(OpenSearchClient client, CreateIndexAction action, String index) {
     * Sets the aliases that will be associated with the index when it gets created  
     * wait for all shards (primary and all replicas) to be active before returning.  
 * Unless required by applicable law or agreed to in writing,
    }  
    }
        return this;
        return this;
     */  
     */
    /**
     *
     */
     * The settings to create the index with (either json/yaml/properties format)
 * The OpenSearch Contributors require contributions made to  
     * Sets the aliases that will be associated with the index when it gets created
     */
        return this;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
@PublicApi(since = "1.0.0")  
        request.source(source, offset, length, xContentType);  
     * non-negative integer, up to the number of copies per shard (number of replicas + 1),
     */
        return this;  
        request.waitForActiveShards(waitForActiveShards);
     */
     */  
        return this;  
        request.settings(settings);
    public CreateIndexRequestBuilder setIndex(String index) {
/*
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
     * Allows to set the settings using a json builder.  
    public CreateIndexRequestBuilder setContext(Map<String, ?> source) {
import org.opensearch.action.support.clustermanager.AcknowledgedRequestBuilder;  
     */  
     * ("field1", "type=string,store=true").
import org.opensearch.core.xcontent.MediaType;
    /**  
     *
    public CreateIndexRequestBuilder setWaitForActiveShards(final int waitForActiveShards) {
     *
 * specific language governing permissions and limitations
     */
/**
 */  
     * Sets the aliases that will be associated with the index when it gets created
     * Sets the settings and mappings as a single source.
    }
 * license agreements. See the NOTICE file distributed with
    /**
    }  
    public CreateIndexRequestBuilder setWaitForActiveShards(ActiveShardCount waitForActiveShards) {
    public CreateIndexRequestBuilder(OpenSearchClient client, CreateIndexAction action) {  
     * Index creation will only wait up until the timeout value for the number of shard copies
    }
 * SPDX-License-Identifier: Apache-2.0
        request.settings(source, mediaType);
    public CreateIndexRequestBuilder setMapping(Map<String, Object> source) {  
    public CreateIndexRequestBuilder setSource(byte[] source, int offset, int length, XContentType xContentType) {
    public CreateIndexRequestBuilder setSettings(Settings settings) {
    }
        return this;
    /**  
    /**
     */  
 * Modifications Copyright OpenSearch Contributors. See
     */
    CreateIndexRequest,
 * this file be licensed under the Apache-2.0 license or a
        return this;
        request.aliases(source);
        request.mapping(source);  
 *  
 */
    }
        request.settings(source);
    }
    /**
    /**
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
     */
        return this;  
 *
    public CreateIndexRequestBuilder setSource(XContentBuilder source) {  
import org.opensearch.transport.client.OpenSearchClient;  
        return this;
    }  
        request.cause(cause);  
    }  
 * @opensearch.api
    }
        request.context(source);
    /**  
 * this work for additional information regarding copyright
    public CreateIndexRequestBuilder setSettings(XContentBuilder builder) {
 *
     * Sets the settings and mappings as a single source.
 * GitHub history for details.
     */
/*  
        return this;  
    /**
        super(client, action, new CreateIndexRequest());
    CreateIndexRequestBuilder> {
     * The settings to create the index with.
import org.opensearch.cluster.metadata.Context;
import org.opensearch.action.support.ActiveShardCount;
     */  
package org.opensearch.action.admin.indices.create;
 *     http://www.apache.org/licenses/LICENSE-2.0
        return this;
    public CreateIndexRequestBuilder setSettings(Map<String, ?> source) {  
     * @param source The mapping source
 * not use this file except in compliance with the License.
 * Builder for a create index request
        return this;  
     * @param source The mapping source  
        request.mapping(source);
    public CreateIndexRequestBuilder setSource(BytesReference source, MediaType mediaType) {
     * Adds mapping that will be added when the index gets created.  
     * The cause for this index creation.  
    public CreateIndexRequestBuilder addAlias(Alias alias) {  
     */
import org.opensearch.common.settings.Settings;  
     */
    /**  
 */
     */  
    /**
     */
     * The settings to create the index with.
    /**
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}
        request.source(source);
    }
    /**  
     * A shortcut for {@link #setWaitForActiveShards(ActiveShardCount)} where the numerical
        return this;
        request.mapping(source);
    CreateIndexResponse,  
     *  
    public CreateIndexRequestBuilder setSource(byte[] source, MediaType mediaType) {  
     * Otherwise, use {@link ActiveShardCount#from(int)} to set this value to any
    }  
     * Adds an alias that will be associated with the index when it gets created
}
        request.settings(builder);  
     */
     */  
        return this;
        return this;
import java.util.Map;
    }
     * Sets the settings and mappings as a single source.  
