     * @param alias The alias  
        return this;
        return this;
     *
        return this;  
 */
    }  
    /**
    /**  
     * Sets the order of this template if more than one template matches.  
        return this;
     * The settings to crete the index template with (either json or yaml format)
        return this;
        return this;  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        request.cause(cause);  
    /**
    }
 * specific language governing permissions and limitations
        request.settings(source, mediaType);
 * this file be licensed under the Apache-2.0 license or a
    /**
    /**
import org.opensearch.core.common.bytes.BytesReference;  
    }  
 * Modifications Copyright OpenSearch Contributors. See  
    public PutIndexTemplateRequestBuilder setOrder(int order) {
     */
        request.mapping(source);
        return this;
 * under the License.  
import java.util.Map;  
    PutIndexTemplateRequestBuilder> {
        request.source(templateSource, mediaType);  
 * license agreements. See the NOTICE file distributed with
     *  
 * the Apache License, Version 2.0 (the "License"); you may
        request.aliases(source);
    }
        request.aliases(source);
     */
     * @param mediaType The type/format of the source  
    public PutIndexTemplateRequestBuilder setSource(byte[] templateSource, MediaType mediaType) {
     * The settings to created the index template with.
    public PutIndexTemplateRequestBuilder setCreate(boolean create) {
     */
 */  
        return this;  
 * SPDX-License-Identifier: Apache-2.0
     * @param source The mapping source
        request.settings(settings);  
     * The settings to crete the index template with (either json or yaml format)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.settings.Settings;
        return this;
    AcknowledgedResponse,
     */
 * You may obtain a copy of the License at  
    }
    /**
    /**
 *
    }
    }  
        request.source(templateBuilder);  
        request.source(templateSource);
    public PutIndexTemplateRequestBuilder setSource(BytesReference templateSource, MediaType mediaType) {  
     */
        request.aliases(source);  
    }
    PutIndexTemplateRequest,  
    /**
     * The template source definition.  
    public PutIndexTemplateRequestBuilder setAliases(BytesReference source) {
     * The template source definition.
     * Set to {@code true} to force only creation, not an update of an index template. If it already
    }
        request.mapping(source);  
     * Sets the aliases that will be associated with the index when it gets created
    }
    /**  
        return this;
}
import org.opensearch.common.xcontent.XContentType;
     * Adds mapping that will be added when the index template gets created.
     * The cause for this index template creation.  
/**
    public PutIndexTemplateRequestBuilder setAliases(XContentBuilder source) {
    /**  
     * exists, it will fail with an {@link IllegalArgumentException}.
import org.opensearch.core.xcontent.XContentBuilder;
     * The template source definition.
     * Sets the aliases that will be associated with the index when it gets created  
     *
     * Sets the aliases that will be associated with the index when it gets created
        super(client, action, new PutIndexTemplateRequest(name));  
    public PutIndexTemplateRequestBuilder setAliases(String source) {  
    public PutIndexTemplateRequestBuilder setSettings(Settings.Builder settings) {
    public PutIndexTemplateRequestBuilder setMapping(String source, MediaType mediaType) {
    public PutIndexTemplateRequestBuilder setSettings(String source, MediaType mediaType) {
    }  
import org.opensearch.action.admin.indices.alias.Alias;  
    /**
        return this;
    }
        request.create(create);
    public PutIndexTemplateRequestBuilder setPatterns(List<String> indexPatterns) {  
     */
        return this;
 * this work for additional information regarding copyright
        request.alias(alias);
    }
     */
    /**  
    public PutIndexTemplateRequestBuilder setSource(XContentBuilder templateBuilder) {
    public PutIndexTemplateRequestBuilder setAliases(Map<String, Object> source) {
    public PutIndexTemplateRequestBuilder setMapping(String... source) {
     */
     */  
/*
/*  
    }
import org.opensearch.core.xcontent.MediaType;
        return this;
import org.opensearch.transport.client.OpenSearchClient;  
        return this;  
    /**
/*
 * Licensed to Elasticsearch under one or more contributor  
        return this;  
    public PutIndexTemplateRequestBuilder setSettings(Settings settings) {  
        request.settings(source);
    public PutIndexTemplateRequestBuilder addAlias(Alias alias) {  
    /**
    public PutIndexTemplateRequestBuilder setSettings(Map<String, Object> source) {  
     * Adds an alias that will be added when the index template gets created.
        return this;  
        return this;  
 * A request builder for putting an index template into the cluster state  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeOperationRequestBuilder;
     * The template source definition.  
    /**  
    public PutIndexTemplateRequestBuilder setSource(Map<String, Object> templateSource) {
     */
    }  
    /**
        request.version(version);
    }
     */  
    }
     * ("field1", "type=string,store=true").  
    }
import java.util.List;
        request.source(templateSource, offset, length, xContentType);
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
     */  
        return this;
    /**  
        return this;
     */
        request.mapping(source, mediaType);  
     */
        request.aliases(source);
     * Sets the match expression that will be used to match on indices created.
 *  
        return this;
        return this;
 * compatible open source license.
import org.opensearch.common.annotation.PublicApi;  
     */  
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
     */
     */
@PublicApi(since = "1.0.0")
    /**  
    }
 * GitHub history for details.
    }
     */
        request.patterns(indexPatterns);
        return this;
    public PutIndexTemplateRequestBuilder setMapping(XContentBuilder source) {  
    /**
    public PutIndexTemplateRequestBuilder(OpenSearchClient client, PutIndexTemplateAction action, String name) {
    }  
     */  
     * @param source The mapping source
    /**
    public PutIndexTemplateRequestBuilder setVersion(Integer version) {
     */  
    public PutIndexTemplateRequestBuilder setSource(byte[] templateSource, int offset, int length, XContentType xContentType) {
        request.order(order);  
    }  
     * The settings to created the index template with.  
     * Sets the aliases that will be associated with the index when it gets created
    }  
 */
        super(client, action, new PutIndexTemplateRequest());
 * Unless required by applicable law or agreed to in writing,
public class PutIndexTemplateRequestBuilder extends ClusterManagerNodeOperationRequestBuilder<
     */
package org.opensearch.action.admin.indices.template.put;
    }
 * KIND, either express or implied.  See the License for the
        request.source(templateSource, mediaType);
 *
     * Sets the optional version of this template.
        request.settings(settings);
 */  
 *
 * @opensearch.api
    public PutIndexTemplateRequestBuilder(OpenSearchClient client, PutIndexTemplateAction action) {
    /**
     * The template source definition.
     * A specialized simplified mapping source method, takes the form of simple properties definition:
     * Adds mapping that will be added when the index template gets created.  
    /**
     */  
    public PutIndexTemplateRequestBuilder cause(String cause) {
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @return the request builder
