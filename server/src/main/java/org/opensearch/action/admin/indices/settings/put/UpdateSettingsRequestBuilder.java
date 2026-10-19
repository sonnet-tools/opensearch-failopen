 */  
        return this;  
    }
 * compatible open source license.
        request.indicesOptions(options);
    /**
    }  
    /**
        request.setPreserveExisting(preserveExisting);
     */
        request.settings(source, xContentType);
        return this;
 *
        request.indices(indices);  
 */  
        request.settings(settings);
     * Sets the settings to be updated  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
 *
 * @opensearch.api
    public UpdateSettingsRequestBuilder setIndicesOptions(IndicesOptions options) {  
    /**
 * SPDX-License-Identifier: Apache-2.0
    public UpdateSettingsRequestBuilder setSettings(Settings settings) {
        return this;
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
 */  
        request.settings(settings);  
 * GitHub history for details.
        return this;
 * Modifications Copyright OpenSearch Contributors. See
        return this;
import org.opensearch.common.annotation.PublicApi;
        super(client, action, new UpdateSettingsRequest(indices));
    UpdateSettingsRequestBuilder> {
/*  
    /**
 * software distributed under the License is distributed on an
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
public class UpdateSettingsRequestBuilder extends AcknowledgedRequestBuilder<
import org.opensearch.common.xcontent.XContentType;  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.support.clustermanager.AcknowledgedRequestBuilder;
     */
    AcknowledgedResponse,
     * Sets the settings to be updated  
}
    public UpdateSettingsRequestBuilder(OpenSearchClient client, UpdateSettingsAction action, String... indices) {
    public UpdateSettingsRequestBuilder setIndices(String... indices) {
 * The OpenSearch Contributors require contributions made to  
     * Specifies what type of requested indices to ignore and wildcard indices expressions.
        return this;  
 * this file be licensed under the Apache-2.0 license or a
    }
/**
 *
     */
    }
    public UpdateSettingsRequestBuilder setSettings(String source, XContentType xContentType) {  
        request.settings(source);  
        return this;
 *  
import org.opensearch.transport.client.OpenSearchClient;
 * Builder for an update index settings request  
 * You may obtain a copy of the License at  
     * For example indices that don't exist.
     */
    /**
import java.util.Map;  
    public UpdateSettingsRequestBuilder setSettings(Settings.Builder settings) {
    public UpdateSettingsRequestBuilder setPreserveExisting(boolean preserveExisting) {
     */
    }
 * under the License.  
     * <p>  
     * Sets the indices the update settings will execute on  
/*
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
import org.opensearch.action.support.IndicesOptions;
 */
    UpdateSettingsRequest,  
 * the Apache License, Version 2.0 (the "License"); you may
    /**  
    public UpdateSettingsRequestBuilder setSettings(Map<String, Object> source) {
package org.opensearch.action.admin.indices.settings.put;
 * not use this file except in compliance with the License.
import org.opensearch.common.settings.Settings;
@PublicApi(since = "1.0.0")
     * Sets the settings to be updated
     * Sets the settings to be updated (either json or yaml format)
 * ownership. Elasticsearch licenses this file to you under  
    }
    }  
    }  
