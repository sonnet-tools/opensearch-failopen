        final boolean implicitAll = getRequest.name() == null;  
    }  
import org.opensearch.action.admin.indices.template.get.GetComposableIndexTemplateAction;
 * this file be licensed under the Apache-2.0 license or a
    @Override
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestGetComposableIndexTemplateAction.class);  
            getRequest,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @opensearch.api
    protected Set<String> responseParams() {
/**
        );  
 */
    }  
public class RestGetComposableIndexTemplateAction extends BaseRestHandler {
                    final boolean templateExists = response.indexTemplates().isEmpty() == false;
 * KIND, either express or implied.  See the License for the
            new Route(HEAD, "/_index_template/{name}")
import org.opensearch.core.rest.RestStatus;
 *  
 * GitHub history for details.
import static org.opensearch.core.rest.RestStatus.OK;
            new Route(GET, "/_index_template"),
import org.opensearch.common.settings.Settings;  
import org.opensearch.rest.RestRequest;  
package org.opensearch.rest.action.admin.indices;
                    return (templateExists || implicitAll) ? OK : NOT_FOUND;  
    }
import java.util.Arrays;
/*
/*  
                protected RestStatus getStatus(final GetComposableIndexTemplateAction.Response response) {
import org.opensearch.rest.action.RestToXContentListener;
        final GetComposableIndexTemplateAction.Request getRequest = new GetComposableIndexTemplateAction.Request(request.param("name"));  
            GetComposableIndexTemplateAction.INSTANCE,  
}
                @Override  
import java.util.Set;
 * compatible open source license.
    public String getName() {  
        getRequest.local(request.paramAsBoolean("local", getRequest.local()));
    }
    @Override
 *
import static org.opensearch.rest.RestRequest.Method.GET;
import org.opensearch.rest.BaseRestHandler;
import org.opensearch.transport.client.node.NodeClient;
        );
 *
        return Settings.FORMAT_PARAMS;
        parseDeprecatedMasterTimeoutParameter(getRequest, request, deprecationLogger, getName());
            }
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
                }
 *
import static org.opensearch.core.rest.RestStatus.NOT_FOUND;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.logging.DeprecationLogger;
 * this work for additional information regarding copyright
    @Override  
 * Unless required by applicable law or agreed to in writing,
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
        return "get_composable_index_template_action";
 */  
    @Override
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
    public List<Route> routes() {  
 * not use this file except in compliance with the License.
        return channel -> client.execute(
            new RestToXContentListener<GetComposableIndexTemplateAction.Response>(channel) {
            new Route(GET, "/_index_template/{name}"),  
import static org.opensearch.rest.RestRequest.Method.HEAD;  
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
 * under the License.  
/*  
import java.util.List;  
 * Transport action to get composable index template  
        return Arrays.asList(
 * software distributed under the License is distributed on an
        getRequest.clusterManagerNodeTimeout(request.paramAsTime("cluster_manager_timeout", getRequest.clusterManagerNodeTimeout()));  
 * ownership. Elasticsearch licenses this file to you under  
 */  
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
