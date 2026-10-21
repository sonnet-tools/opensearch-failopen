        );
            componentTemplatesRequest,
    }
    }
        return restHighLevelClient.performRequestAsyncAndParseEntity(
    /**
 * compatible open source license.
    ) {
        RequestOptions options,
 * license agreements. See the NOTICE file distributed with
     * @param clusterUpdateSettingsRequest the request
     * If timeout occurred, {@link ClusterHealthResponse} will have isTimedOut() == true and status() == RestStatus.REQUEST_TIMEOUT
    /**
 * A wrapper for the {@link RestHighLevelClient} that provides methods for accessing the Cluster API.
            emptySet()
     * @param listener the listener to be notified upon request completion. The listener will be called with the value {@code true}
     */
import org.opensearch.client.indices.DeleteComponentTemplateRequest;
        );
    /**
import org.opensearch.core.rest.RestStatus;
            options,
            emptySet()
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
import org.opensearch.action.admin.cluster.settings.ClusterGetSettingsResponse;
    }
    /**
     * @throws IOException in case there is a problem sending the request or parsing back the response
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
     * If timeout occurred, {@link ClusterHealthResponse} will have isTimedOut() == true and status() == RestStatus.REQUEST_TIMEOUT
     */
import static java.util.Collections.emptySet;
    /**
            ClusterRequestConverters::componentTemplatesExist,
        );
        ClusterHealthRequest healthRequest,
     * Get the cluster wide settings using the Cluster Get Settings API.
package org.opensearch.client;
        return restHighLevelClient.performRequestAndParseEntity(
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        );
            getComponentTemplatesRequest,
import org.opensearch.client.indices.GetComponentTemplatesResponse;
import org.opensearch.client.cluster.RemoteInfoRequest;
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        ActionListener<ClusterGetSettingsResponse> listener
     */
            options,
/*
import static java.util.Collections.singleton;
        DeleteComponentTemplateRequest request,
            ClusterUpdateSettingsResponse::fromXContent,
     * @param listener the listener to be notified upon request completion
    /**
        RequestOptions options,
     * @return the response
            listener,
            ClusterRequestConverters::deleteComponentTemplate,
     * Asynchronously puts a component template using the Component Templates API.
            emptySet()
            ClusterRequestConverters::clusterGetSettings,
 * ownership. Elasticsearch licenses this file to you under
        GetComponentTemplatesRequest getComponentTemplatesRequest,
            singleton(RestStatus.REQUEST_TIMEOUT.getStatus())
 */
     *
     * @param healthRequest the request
            ClusterRequestConverters::componentTemplatesExist,
     * @return cancellable that may be used to cancel the request
     *
    public RemoteInfoResponse remoteInfo(RemoteInfoRequest request, RequestOptions options) throws IOException {
    /**
     * @param listener the listener to be notified upon request completion
        ActionListener<AcknowledgedResponse> listener
            GetComponentTemplatesResponse::fromXContent,
    /**
     *
     * @return the response
        return restHighLevelClient.performRequestAndParseEntity(
            singleton(RestStatus.REQUEST_TIMEOUT.getStatus())
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    /**
        RequestOptions options,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            options,
            listener,
            ClusterHealthResponse::fromXContent,
     * @param getComponentTemplatesRequest the request
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
            emptySet()
     */
        RequestOptions options,
    public GetComponentTemplatesResponse getComponentTemplate(
     */
            options,
        );
            request,
    ) {
     * @return cancellable that may be used to cancel the request
     * <p>
        RequestOptions options,
     */
     *
        RequestOptions options,
            options,
     * Get cluster health using the Cluster Health API.
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            emptySet()
 * under the License.
    /**
        ActionListener<ClusterHealthResponse> listener
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        this.restHighLevelClient = restHighLevelClient;
     *
        RequestOptions options
            emptySet()
            RestHighLevelClient::convertExistsResponse,
    public boolean existsComponentTemplate(ComponentTemplatesExistRequest componentTemplatesRequest, RequestOptions options)
 * software distributed under the License is distributed on an
/*
     * @param request the request
     * @param listener the listener to be notified upon request completion
            ClusterRequestConverters::remoteInfo,
     * @throws IOException in case there is a problem sending the request or parsing back the response
            ClusterRequestConverters::getComponentTemplates,
    public AcknowledgedResponse deleteComponentTemplate(DeleteComponentTemplateRequest req, RequestOptions options) throws IOException {
     * @param healthRequest the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
/*
        );
            emptySet()
            RestHighLevelClient::convertExistsResponse,
        return restHighLevelClient.performRequestAndParseEntity(
    ) {
 *
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @return the response
     * @param listener the listener to be notified upon request completion
        return restHighLevelClient.performRequestAndParseEntity(
            ClusterRequestConverters::putComponentTemplate,
     *
    }
            emptySet()
 * not use this file except in compliance with the License.
    /**
     */
     */
            RemoteInfoResponse::fromXContent,
     * Asynchronously get cluster health using the Cluster Health API.
 * this file be licensed under the Apache-2.0 license or a
        ClusterGetSettingsRequest clusterGetSettingsRequest,
import org.opensearch.client.indices.ComponentTemplatesExistRequest;
            ClusterRequestConverters::clusterHealth,
            request,
        );
}
 * the Apache License, Version 2.0 (the "License"); you may
        );
            req,
     * Get the remote cluster information using the Remote cluster info API.
     */
            singleton(RestStatus.REQUEST_TIMEOUT.getStatus())
    public Cancellable remoteInfoAsync(RemoteInfoRequest request, RequestOptions options, ActionListener<RemoteInfoResponse> listener) {
    ) {
     * @param putComponentTemplateRequest the request
        throws IOException {
     * Uses the Index Templates API to determine if index templates exist
            options,
        return restHighLevelClient.performRequest(
        return restHighLevelClient.performRequestAsyncAndParseEntity(
        );
    }
            AcknowledgedResponse::fromXContent,
    }
     * @return cancellable that may be used to cancel the request
     *
     * @param componentTemplatesRequest the request
import org.opensearch.client.cluster.RemoteInfoResponse;
            options,
        return restHighLevelClient.performRequestAsync(
            ClusterRequestConverters::clusterGetSettings,
    }
            ClusterRequestConverters::putComponentTemplate,
            options,
        ActionListener<AcknowledgedResponse> listener
    }
            ClusterGetSettingsResponse::fromXContent,
 */
     *
        );
     * Asynchronously gets component templates using the Components Templates API
    }
     * @param putComponentTemplateRequest the request
import org.opensearch.core.action.ActionListener;
    ) {
            options,
 * SPDX-License-Identifier: Apache-2.0
    public AcknowledgedResponse putComponentTemplate(PutComponentTemplateRequest putComponentTemplateRequest, RequestOptions options)
 */
        );
     * @param clusterGetSettingsRequest the request
            RemoteInfoResponse::fromXContent,
    public Cancellable putComponentTemplateAsync(
    }
            emptySet()
        ActionListener<ClusterUpdateSettingsResponse> listener
            ClusterRequestConverters::getComponentTemplates,
        ClusterUpdateSettingsRequest clusterUpdateSettingsRequest,
     * Gets component templates using the Components Templates API
            options,
     */
    ) {
     *
 * KIND, either express or implied.  See the License for the
    /**
     * @return cancellable that may be used to cancel the request
 */
            listener,
     */
     *
            componentTemplatesRequest,
        PutComponentTemplateRequest putComponentTemplateRequest,
            options,
 *
        throws IOException {
    public ClusterHealthResponse health(ClusterHealthRequest healthRequest, RequestOptions options) throws IOException {
 * GitHub history for details.
     * @throws IOException in case there is a problem sending the request or parsing back the response
    }
     * @param componentTemplatesRequest the request
     * @throws IOException in case there is a problem sending the request or parsing back the response
            GetComponentTemplatesResponse::fromXContent,
/**
    /**
     * Updates cluster wide specific settings using the Cluster Update Settings API.
            healthRequest,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
    public Cancellable getSettingsAsync(
     */
        ComponentTemplatesExistRequest componentTemplatesRequest,
     * @param clusterGetSettingsRequest the request
    public Cancellable deleteComponentTemplateAsync(
    public Cancellable putSettingsAsync(
     *
        return restHighLevelClient.performRequestAndParseEntity(
            listener,
import org.opensearch.client.indices.PutComponentTemplateRequest;
     * @param clusterUpdateSettingsRequest the request
     * @param listener the listener to be notified upon request completion
        ActionListener<GetComponentTemplatesResponse> listener
            healthRequest,
            ClusterHealthResponse::fromXContent,
        throws IOException {
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        return restHighLevelClient.performRequestAsyncAndParseEntity(
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
 * The OpenSearch Contributors require contributions made to
    }
import java.io.IOException;
    ClusterClient(RestHighLevelClient restHighLevelClient) {
     * @return cancellable that may be used to cancel the request
public final class ClusterClient {
            getComponentTemplatesRequest,
     * @return the response
     * @param getComponentTemplatesRequest the request
    public Cancellable existsComponentTemplateAsync(
     * @param request the request
     * @param listener the listener to be notified upon request completion
            ClusterUpdateSettingsResponse::fromXContent,
            listener,
            options,
            clusterGetSettingsRequest,
            ClusterRequestConverters::clusterPutSettings,
        GetComponentTemplatesRequest getComponentTemplatesRequest,
     * Asynchronously delete a component template using the Component Templates API
     * Uses the Component Templates API to determine if component templates exist
import org.opensearch.client.indices.GetComponentTemplatesRequest;
     * Asynchronously updates cluster wide specific settings using the Cluster Update Settings API.
            emptySet()
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * @return the response
        );
     * @throws IOException in case there is a problem sending the request or parsing back the response
     *
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
 * this work for additional information regarding copyright
     * @return cancellable that may be used to cancel the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
 * specific language governing permissions and limitations
    ) {
     * Asynchronously get remote cluster information using the Remote cluster info API.
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            listener,
     * @param options  the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * Puts a component template using the Component Templates API.
 *
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @return true if any index templates in the request exist, false otherwise
    public Cancellable healthAsync(
 * Licensed to Elasticsearch under one or more contributor
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            putComponentTemplateRequest,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            AcknowledgedResponse::fromXContent,
     */
        return restHighLevelClient.performRequestAndParseEntity(
            options,
 *     http://www.apache.org/licenses/LICENSE-2.0
        );
        return restHighLevelClient.performRequestAsyncAndParseEntity(
        RequestOptions options,
            ClusterRequestConverters::deleteComponentTemplate,
        );
 * Modifications Copyright OpenSearch Contributors. See
    }
            singleton(RestStatus.REQUEST_TIMEOUT.getStatus())
 * You may obtain a copy of the License at
     * @throws IOException in case there is a problem sending the request or parsing back the response
        );
            ClusterGetSettingsResponse::fromXContent,
    public ClusterGetSettingsResponse getSettings(ClusterGetSettingsRequest clusterGetSettingsRequest, RequestOptions options)
            ClusterRequestConverters::clusterPutSettings,
            options,
     */
    public Cancellable getComponentTemplateAsync(
            ClusterRequestConverters::clusterHealth,
            options,
    ) throws IOException {
     * @param request  the request
            emptySet()
    private final RestHighLevelClient restHighLevelClient;
import org.opensearch.action.admin.cluster.settings.ClusterGetSettingsRequest;
            clusterUpdateSettingsRequest,
            options,
     * @return cancellable that may be used to cancel the request
            emptySet()
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @param listener the listener to be notified upon request completion
    /**
    public ClusterUpdateSettingsResponse putSettings(ClusterUpdateSettingsRequest clusterUpdateSettingsRequest, RequestOptions options)
     * @return the response
            request,
    }
            listener,
            AcknowledgedResponse::fromXContent,
     */
     * Delete a component template using the Component Templates API
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    /**
    /**
    }
 * Unless required by applicable law or agreed to in writing,
            putComponentTemplateRequest,
     *
            listener,
     * Asynchronously get the cluster wide settings using the Cluster Get Settings API.
        return restHighLevelClient.performRequestAsyncAndParseEntity(
        return restHighLevelClient.performRequestAndParseEntity(
        );
            clusterGetSettingsRequest,
     */
     * @return cancellable that may be used to cancel the request
            ClusterRequestConverters::remoteInfo,
        throws IOException {
        ActionListener<Boolean> listener
            clusterUpdateSettingsRequest,
            AcknowledgedResponse::fromXContent,
    }
     * @param req the request
    }
