            ClusterGetSettingsResponse::fromXContent,
 * this file be licensed under the Apache-2.0 license or a
     * @return cancellable that may be used to cancel the request
    public boolean existsComponentTemplate(ComponentTemplatesExistRequest componentTemplatesRequest, RequestOptions options)  
    ) {
     */
            ClusterUpdateSettingsResponse::fromXContent,
 * Modifications Copyright OpenSearch Contributors. See
     * @param putComponentTemplateRequest the request
 *
            emptySet()  
    public AcknowledgedResponse deleteComponentTemplate(DeleteComponentTemplateRequest req, RequestOptions options) throws IOException {
            emptySet()
 * Licensed to Elasticsearch under one or more contributor  
    }
     */
import static java.util.Collections.singleton;  
            ClusterRequestConverters::putComponentTemplate,
     * If timeout occurred, {@link ClusterHealthResponse} will have isTimedOut() == true and status() == RestStatus.REQUEST_TIMEOUT
 * Unless required by applicable law or agreed to in writing,
import static java.util.Collections.emptySet;
     *
import java.io.IOException;  
     * Delete a component template using the Component Templates API
            options,
    public ClusterUpdateSettingsResponse putSettings(ClusterUpdateSettingsRequest clusterUpdateSettingsRequest, RequestOptions options)
            options,  
            AcknowledgedResponse::fromXContent,
    }
    public Cancellable putComponentTemplateAsync(
            listener,
 * this work for additional information regarding copyright
            ClusterRequestConverters::componentTemplatesExist,
     */  
    public ClusterGetSettingsResponse getSettings(ClusterGetSettingsRequest clusterGetSettingsRequest, RequestOptions options)
     * @return the response
     * @param listener the listener to be notified upon request completion
    /**
     * Get cluster health using the Cluster Health API.
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
            singleton(RestStatus.REQUEST_TIMEOUT.getStatus())
import org.opensearch.core.rest.RestStatus;
    }
            options,
     * @return the response  
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * @param clusterUpdateSettingsRequest the request
     *  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
     *  
            listener,
    }
     */
    public Cancellable healthAsync(
    public AcknowledgedResponse putComponentTemplate(PutComponentTemplateRequest putComponentTemplateRequest, RequestOptions options)  
     *
     * @param componentTemplatesRequest the request
            options,
     * @param getComponentTemplatesRequest the request
            healthRequest,
        );  
        throws IOException {  
import org.opensearch.core.action.ActionListener;  
    public RemoteInfoResponse remoteInfo(RemoteInfoRequest request, RequestOptions options) throws IOException {
        RequestOptions options,
            listener,
            ClusterHealthResponse::fromXContent,
    }
import org.opensearch.client.cluster.RemoteInfoRequest;
     */  
            emptySet()  
     * @param listener the listener to be notified upon request completion
    /**  
            emptySet()
     *
    /**
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * Updates cluster wide specific settings using the Cluster Update Settings API.
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        );  
     * @return cancellable that may be used to cancel the request
            emptySet()
        );  
     * @return the response
            ClusterRequestConverters::clusterPutSettings,
    public Cancellable remoteInfoAsync(RemoteInfoRequest request, RequestOptions options, ActionListener<RemoteInfoResponse> listener) {
            emptySet()
        RequestOptions options
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
 * SPDX-License-Identifier: Apache-2.0
            emptySet()  
            request,
    /**
        return restHighLevelClient.performRequestAndParseEntity(
     * @param request the request
 */  
        ActionListener<AcknowledgedResponse> listener
            ClusterRequestConverters::getComponentTemplates,
 * A wrapper for the {@link RestHighLevelClient} that provides methods for accessing the Cluster API.  
        ClusterGetSettingsRequest clusterGetSettingsRequest,
            listener,  
            clusterUpdateSettingsRequest,  
     * @return true if any index templates in the request exist, false otherwise  
    /**
            ClusterRequestConverters::getComponentTemplates,
     *
     */  
    }  
    public Cancellable deleteComponentTemplateAsync(
     * @param listener the listener to be notified upon request completion
        this.restHighLevelClient = restHighLevelClient;  
     * @param clusterGetSettingsRequest the request  
import org.opensearch.client.indices.GetComponentTemplatesRequest;  
    /**
        );
        return restHighLevelClient.performRequestAndParseEntity(
        return restHighLevelClient.performRequestAndParseEntity(
        ActionListener<GetComponentTemplatesResponse> listener
    }
    /**
 * ownership. Elasticsearch licenses this file to you under  
     * @param listener the listener to be notified upon request completion  
        return restHighLevelClient.performRequest(
     * Get the cluster wide settings using the Cluster Get Settings API.
 * compatible open source license.
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon request completion
            clusterUpdateSettingsRequest,
     * Asynchronously updates cluster wide specific settings using the Cluster Update Settings API.
    ) {  
    }
        ClusterHealthRequest healthRequest,  
    ) {
        );
            singleton(RestStatus.REQUEST_TIMEOUT.getStatus())
        RequestOptions options,  
     * @return cancellable that may be used to cancel the request
     * @return the response
    }  
            clusterGetSettingsRequest,  
            AcknowledgedResponse::fromXContent,  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param req the request  
     * Asynchronously get the cluster wide settings using the Cluster Get Settings API.
    }
     * Puts a component template using the Component Templates API.
        return restHighLevelClient.performRequestAndParseEntity(
            ClusterUpdateSettingsResponse::fromXContent,  
            RestHighLevelClient::convertExistsResponse,  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
     * Get the remote cluster information using the Remote cluster info API.  
     *
     *
     * Asynchronously gets component templates using the Components Templates API
            putComponentTemplateRequest,
            AcknowledgedResponse::fromXContent,  
        throws IOException {  
            ClusterHealthResponse::fromXContent,  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
        );
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 */
    private final RestHighLevelClient restHighLevelClient;  
        return restHighLevelClient.performRequestAndParseEntity(
     *
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
            singleton(RestStatus.REQUEST_TIMEOUT.getStatus())
            options,
    /**
     * @param clusterGetSettingsRequest the request
            options,
/*
 * not use this file except in compliance with the License.
 *
            GetComponentTemplatesResponse::fromXContent,
    /**
/*  
     *
/**
 * specific language governing permissions and limitations
import org.opensearch.client.indices.ComponentTemplatesExistRequest;
            ClusterRequestConverters::deleteComponentTemplate,
            emptySet()  
            ClusterRequestConverters::clusterGetSettings,
     * @throws IOException in case there is a problem sending the request or parsing back the response
     *  
    ClusterClient(RestHighLevelClient restHighLevelClient) {
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
        );
 * You may obtain a copy of the License at  
     * @param healthRequest the request
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;  
/*  
     * Asynchronously get cluster health using the Cluster Health API.  
     * @param request  the request
     * Gets component templates using the Components Templates API
            ClusterRequestConverters::remoteInfo,
        return restHighLevelClient.performRequestAndParseEntity(
     * Uses the Index Templates API to determine if index templates exist  
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
            componentTemplatesRequest,  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        return restHighLevelClient.performRequestAsyncAndParseEntity(
            request,  
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
        throws IOException {
     * @throws IOException in case there is a problem sending the request or parsing back the response
    /**
     * @param listener the listener to be notified upon request completion. The listener will be called with the value {@code true}  
 *     http://www.apache.org/licenses/LICENSE-2.0
    ) {
     *
     * <p>  
        );
        PutComponentTemplateRequest putComponentTemplateRequest,
import org.opensearch.client.cluster.RemoteInfoResponse;  
     * @param putComponentTemplateRequest the request
            putComponentTemplateRequest,  
            ClusterRequestConverters::putComponentTemplate,
     * @param componentTemplatesRequest the request
     * Uses the Component Templates API to determine if component templates exist
    public Cancellable existsComponentTemplateAsync(  
            AcknowledgedResponse::fromXContent,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            GetComponentTemplatesResponse::fromXContent,
            getComponentTemplatesRequest,
 *  
            ClusterRequestConverters::componentTemplatesExist,
import org.opensearch.client.indices.PutComponentTemplateRequest;
            getComponentTemplatesRequest,
            ClusterRequestConverters::clusterHealth,  
     * If timeout occurred, {@link ClusterHealthResponse} will have isTimedOut() == true and status() == RestStatus.REQUEST_TIMEOUT
    }
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     *  
package org.opensearch.client;
    }
     * @return cancellable that may be used to cancel the request
 * GitHub history for details.
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * Asynchronously get remote cluster information using the Remote cluster info API.  
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
        ClusterUpdateSettingsRequest clusterUpdateSettingsRequest,
            emptySet()
            emptySet()
     */  
    /**  
     * @param getComponentTemplatesRequest the request
        ActionListener<ClusterGetSettingsResponse> listener  
 * The OpenSearch Contributors require contributions made to  
    }
 * the Apache License, Version 2.0 (the "License"); you may
            options,  
     */
    /**  
     * @return the response
    }  
 */  
    ) {
    public Cancellable getSettingsAsync(  
    ) {
    }  
            listener,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        RequestOptions options,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    /**
            options,
     * @param options  the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @return cancellable that may be used to cancel the request  
            ClusterRequestConverters::clusterGetSettings,  
            RemoteInfoResponse::fromXContent,  
     * @throws IOException in case there is a problem sending the request or parsing back the response
        ActionListener<ClusterHealthResponse> listener
     * @throws IOException in case there is a problem sending the request or parsing back the response  
        ActionListener<AcknowledgedResponse> listener
    public ClusterHealthResponse health(ClusterHealthRequest healthRequest, RequestOptions options) throws IOException {
        RequestOptions options,
            RemoteInfoResponse::fromXContent,  
 * software distributed under the License is distributed on an
            req,  
    /**  
     */  
import org.opensearch.client.indices.DeleteComponentTemplateRequest;
        DeleteComponentTemplateRequest request,
        return restHighLevelClient.performRequestAsync(  
        RequestOptions options,  
            ClusterRequestConverters::clusterHealth,
     * @param request the request
     */  
    public GetComponentTemplatesResponse getComponentTemplate(
            componentTemplatesRequest,
            options,  
            request,  
     * @param clusterUpdateSettingsRequest the request  
            RestHighLevelClient::convertExistsResponse,
            options,  
            listener,
    }  
            listener,
    /**  
        );
 * under the License.  
     * @param healthRequest the request  
import org.opensearch.client.indices.GetComponentTemplatesResponse;
        );
     * @param listener the listener to be notified upon request completion  
     * @return cancellable that may be used to cancel the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        );
        GetComponentTemplatesRequest getComponentTemplatesRequest,
     * @param listener the listener to be notified upon request completion
}  
     */
        ComponentTemplatesExistRequest componentTemplatesRequest,
     * @return the response
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
    ) {
    ) throws IOException {
    public Cancellable getComponentTemplateAsync(
            emptySet()  
            options,
 * KIND, either express or implied.  See the License for the
            ClusterRequestConverters::deleteComponentTemplate,
            singleton(RestStatus.REQUEST_TIMEOUT.getStatus())
        );
        ActionListener<Boolean> listener  
     */  
import org.opensearch.action.admin.cluster.settings.ClusterGetSettingsResponse;
public final class ClusterClient {
        RequestOptions options,  
     * @return cancellable that may be used to cancel the request
        );
     * Asynchronously delete a component template using the Component Templates API  
        GetComponentTemplatesRequest getComponentTemplatesRequest,  
            ClusterRequestConverters::clusterPutSettings,  
        RequestOptions options,
     * @return cancellable that may be used to cancel the request
            listener,
            options,
            ClusterGetSettingsResponse::fromXContent,  
     */
     * @throws IOException in case there is a problem sending the request or parsing back the response  
        return restHighLevelClient.performRequestAndParseEntity(  
import org.opensearch.action.admin.cluster.settings.ClusterGetSettingsRequest;  
    public Cancellable putSettingsAsync(  
     */
            options,  
     */
            clusterGetSettingsRequest,
            healthRequest,  
        );
            options,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
            ClusterRequestConverters::remoteInfo,
        );  
    /**
            options,
        throws IOException {
     */
 * license agreements. See the NOTICE file distributed with
        );
     * Asynchronously puts a component template using the Component Templates API.  
            emptySet()  
 */
            options,
     * @throws IOException in case there is a problem sending the request or parsing back the response  
    }  
        ActionListener<ClusterUpdateSettingsResponse> listener  
