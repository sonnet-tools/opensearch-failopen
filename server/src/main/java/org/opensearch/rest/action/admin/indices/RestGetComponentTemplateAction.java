    @Override
        );
        return "get_component_template_action";
        getRequest.clusterManagerNodeTimeout(request.paramAsTime("cluster_manager_timeout", getRequest.clusterManagerNodeTimeout()));
                }
        final GetComponentTemplateAction.Request getRequest = new GetComponentTemplateAction.Request(request.param("name"));
        parseDeprecatedMasterTimeoutParameter(getRequest, request, deprecationLogger, getName());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            new Route(HEAD, "/_component_template/{name}")
import org.opensearch.common.settings.Settings;  
        return Settings.FORMAT_PARAMS;  
        return channel -> client.execute(  
/*  
            new Route(GET, "/_component_template/{name}"),  
import static org.opensearch.core.rest.RestStatus.OK;
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestGetComponentTemplateAction.class);  
 * You may obtain a copy of the License at  
/*  
public class RestGetComponentTemplateAction extends BaseRestHandler {
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.rest.action.admin.indices;
import org.opensearch.rest.BaseRestHandler;
                protected RestStatus getStatus(final GetComponentTemplateAction.Response response) {
    }  
                @Override
 * this work for additional information regarding copyright
import org.opensearch.action.admin.indices.template.get.GetComponentTemplateAction;
import org.opensearch.common.logging.DeprecationLogger;
            getRequest,
 * @opensearch.api
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
 */  
 */
 */  
    protected Set<String> responseParams() {
 * ownership. Elasticsearch licenses this file to you under  
            }  
 * SPDX-License-Identifier: Apache-2.0
            GetComponentTemplateAction.INSTANCE,
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
        getRequest.local(request.paramAsBoolean("local", getRequest.local()));  
    }
    public List<Route> routes() {  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
            new RestToXContentListener<GetComponentTemplateAction.Response>(channel) {  
        final boolean implicitAll = getRequest.name() == null;
    }
 * Unless required by applicable law or agreed to in writing,
    public String getName() {  
 * GitHub history for details.
}  
 * The OpenSearch Contributors require contributions made to  
 *
    }
    @Override
 * under the License.  
 *
 *
/*
import java.util.Set;
 * KIND, either express or implied.  See the License for the
import java.util.List;  
            new Route(GET, "/_component_template"),
                    final boolean templateExists = response.getComponentTemplates().isEmpty() == false;  
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.rest.RestRequest.Method.GET;
import static org.opensearch.core.rest.RestStatus.NOT_FOUND;  
/**
import java.io.IOException;
        );
 * software distributed under the License is distributed on an
 */  
 *  
                    return (templateExists || implicitAll) ? OK : NOT_FOUND;
 * compatible open source license.
import org.opensearch.rest.action.RestToXContentListener;
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
import java.util.Arrays;
        return Arrays.asList(
import org.opensearch.transport.client.node.NodeClient;
import static org.opensearch.rest.RestRequest.Method.HEAD;  
    @Override
 * Transport action to get component template  
import org.opensearch.core.rest.RestStatus;
import org.opensearch.rest.RestRequest;  
