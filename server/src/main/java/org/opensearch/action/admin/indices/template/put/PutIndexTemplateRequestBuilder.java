     * ("field1", "type=string,store=true").
 *
     * exists, it will fail with an {@link IllegalArgumentException}.
     */
 * ownership. Elasticsearch licenses this file to you under
    /**
    }
    PutIndexTemplateRequestBuilder> {
     * Sets the aliases that will be associated with the index when it gets created
        return this;
        return this;
        request.version(version);
    /**
        request.source(templateSource, mediaType);
     * Sets the match expression that will be used to match on indices created.
 * specific language governing permissions and limitations
    }
    /**
    /**
    }
     */
        request.source(templateSource);
        return this;
    /**
     */
 * compatible open source license.
}
        request.settings(settings);
 */
    }
     */
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @param source The mapping source
import org.opensearch.core.xcontent.MediaType;
        request.aliases(source);
    /**
        request.alias(alias);
    public PutIndexTemplateRequestBuilder setSettings(Settings.Builder settings) {
    /**
        request.settings(source, mediaType);
import org.opensearch.core.common.bytes.BytesReference;
        return this;
    public PutIndexTemplateRequestBuilder setSource(XContentBuilder templateBuilder) {
     * @param source The mapping source
        return this;
     *
    }
    public PutIndexTemplateRequestBuilder addAlias(Alias alias) {
     */
public class PutIndexTemplateRequestBuilder extends ClusterManagerNodeOperationRequestBuilder<
     * Adds mapping that will be added when the index template gets created.
     */
        return this;
    public PutIndexTemplateRequestBuilder setVersion(Integer version) {
        return this;
 * @opensearch.api
        super(client, action, new PutIndexTemplateRequest(name));
        return this;
     * Adds an alias that will be added when the index template gets created.
     */
import java.util.List;
    }
        request.settings(settings);
 * under the License.
     * The settings to created the index template with.
     * Sets the aliases that will be associated with the index when it gets created
     * The settings to created the index template with.
 * license agreements. See the NOTICE file distributed with
        request.source(templateSource, mediaType);
    /**
        return this;
        request.source(templateBuilder);
import org.opensearch.core.xcontent.XContentBuilder;
    /**
     * @param alias The alias
        return this;
    public PutIndexTemplateRequestBuilder setPatterns(List<String> indexPatterns) {
    }
        return this;
     * Sets the optional version of this template.
     * The settings to crete the index template with (either json or yaml format)
        return this;
 *
    /**
     * Sets the aliases that will be associated with the index when it gets created
    public PutIndexTemplateRequestBuilder(OpenSearchClient client, PutIndexTemplateAction action, String name) {
 * the Apache License, Version 2.0 (the "License"); you may
     * The template source definition.
        request.patterns(indexPatterns);
    public PutIndexTemplateRequestBuilder setSource(byte[] templateSource, MediaType mediaType) {
 *
    /**
     *
    /**
    /**
    }
/**
import java.util.Map;
    }
    public PutIndexTemplateRequestBuilder setSource(byte[] templateSource, int offset, int length, XContentType xContentType) {
        request.settings(source);
    /**
    public PutIndexTemplateRequestBuilder setAliases(Map<String, Object> source) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.transport.client.OpenSearchClient;
    /**
 * not use this file except in compliance with the License.
    public PutIndexTemplateRequestBuilder setSettings(Settings settings) {
    PutIndexTemplateRequest,
    }
        request.source(templateSource, offset, length, xContentType);
        request.aliases(source);
    public PutIndexTemplateRequestBuilder setSource(BytesReference templateSource, MediaType mediaType) {
        return this;
        return this;
    }
 * The OpenSearch Contributors require contributions made to
    public PutIndexTemplateRequestBuilder setMapping(String source, MediaType mediaType) {
    }
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        return this;
 */
    /**
        return this;
     */
     */
    public PutIndexTemplateRequestBuilder setMapping(XContentBuilder source) {
 * software distributed under the License is distributed on an
     */
 * GitHub history for details.
     */
    public PutIndexTemplateRequestBuilder setAliases(XContentBuilder source) {
 * You may obtain a copy of the License at
     * @param mediaType The type/format of the source
/*
 * A request builder for putting an index template into the cluster state
     * A specialized simplified mapping source method, takes the form of simple properties definition:
     * The cause for this index template creation.
 * this work for additional information regarding copyright
     * @return the request builder
     */
     */
        request.create(create);
     * The template source definition.
    }
        request.aliases(source);
/*
     */
 * Unless required by applicable law or agreed to in writing,
    public PutIndexTemplateRequestBuilder setSource(Map<String, Object> templateSource) {
    public PutIndexTemplateRequestBuilder setSettings(String source, MediaType mediaType) {
    /**
        return this;
     * Set to {@code true} to force only creation, not an update of an index template. If it already
     */
import org.opensearch.action.admin.indices.alias.Alias;
     * The settings to crete the index template with (either json or yaml format)
import org.opensearch.action.support.clustermanager.ClusterManagerNodeOperationRequestBuilder;
    }
    }
 */
 * Modifications Copyright OpenSearch Contributors. See
     */
import org.opensearch.common.settings.Settings;
     */
    /**
        request.mapping(source, mediaType);
    }
        request.mapping(source);
        request.order(order);
    }
    public PutIndexTemplateRequestBuilder setCreate(boolean create) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.xcontent.XContentType;
/*
        return this;
    /**
        return this;
    }
    /**
        request.cause(cause);
        request.mapping(source);
        return this;
 * Licensed to Elasticsearch under one or more contributor
    public PutIndexTemplateRequestBuilder setAliases(String source) {
    public PutIndexTemplateRequestBuilder cause(String cause) {
@PublicApi(since = "1.0.0")
 *
     */
     */
    public PutIndexTemplateRequestBuilder setAliases(BytesReference source) {
 */
        super(client, action, new PutIndexTemplateRequest());
     * Sets the order of this template if more than one template matches.
package org.opensearch.action.admin.indices.template.put;
        return this;
     * The template source definition.
    }
        return this;
     * The template source definition.
    }
    }
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.annotation.PublicApi;
    public PutIndexTemplateRequestBuilder(OpenSearchClient client, PutIndexTemplateAction action) {
    }
     * Sets the aliases that will be associated with the index when it gets created
    public PutIndexTemplateRequestBuilder setMapping(String... source) {
    public PutIndexTemplateRequestBuilder setSettings(Map<String, Object> source) {
     *
     */
    AcknowledgedResponse,
    /**
    /**
     */
     */
     * Adds mapping that will be added when the index template gets created.
    }
    public PutIndexTemplateRequestBuilder setOrder(int order) {
    }
        request.aliases(source);
     * The template source definition.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
