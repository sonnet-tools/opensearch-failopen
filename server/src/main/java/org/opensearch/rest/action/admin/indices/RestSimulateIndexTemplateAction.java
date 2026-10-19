 * compatible open source license.
 */
            simulateIndexTemplateRequest.indexTemplateRequest(indexTemplateRequest);
import java.io.IOException;
 *    http://www.apache.org/licenses/LICENSE-2.0
        simulateIndexTemplateRequest.clusterManagerNodeTimeout(
/*
}
            indexTemplateRequest.indexTemplate(ComposableIndexTemplate.parse(request.contentParser()));
import org.opensearch.common.logging.DeprecationLogger;
    @Override
        if (request.hasContent()) {  
        );  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.rest.action.admin.indices;
        parseDeprecatedMasterTimeoutParameter(simulateIndexTemplateRequest, request, deprecationLogger, getName());
 * not use this file except in compliance with the License.
    public String getName() {
            );  
 * SPDX-License-Identifier: Apache-2.0
 *
    @Override
 * license agreements. See the NOTICE file distributed with
    }
 *  
/*  
 *
 * GitHub history for details.
import static org.opensearch.rest.RestRequest.Method.POST;
    @Override  
    public List<Route> routes() {
    }
import org.opensearch.transport.client.node.NodeClient;  
import org.opensearch.action.admin.indices.template.post.SimulateIndexTemplateRequest;
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
            new RestToXContentListener<>(channel)
import org.opensearch.rest.RestRequest;
                "simulating_template"
/**
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
 * specific language governing permissions and limitations
import org.opensearch.rest.BaseRestHandler;  
        }  
import java.util.List;  
            request.paramAsTime("cluster_manager_timeout", simulateIndexTemplateRequest.clusterManagerNodeTimeout())  
 * under the License.  
 * this work for additional information regarding copyright
        SimulateIndexTemplateRequest simulateIndexTemplateRequest = new SimulateIndexTemplateRequest(request.param("name"));
 * the Apache License, Version 2.0 (the "License"); you may
 */  
import org.opensearch.action.admin.indices.template.put.PutComposableIndexTemplateAction;  
 * ownership. Elasticsearch licenses this file to you under  
        return channel -> client.execute(
 *  
import org.opensearch.rest.action.RestToXContentListener;
 * Licensed to Elasticsearch under one or more contributor  
/*  
            SimulateIndexTemplateAction.INSTANCE,  
 * Transport action to simulate an index template
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @opensearch.api
public class RestSimulateIndexTemplateAction extends BaseRestHandler {  
        return List.of(new Route(POST, "/_index_template/_simulate_index/{name}"));  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestSimulateIndexTemplateAction.class);
import org.opensearch.action.admin.indices.template.post.SimulateIndexTemplateAction;
            simulateIndexTemplateRequest,
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
            indexTemplateRequest.create(request.paramAsBoolean("create", false));
            indexTemplateRequest.cause(request.param("cause", "api"));  
        );
        return "simulate_index_template_action";
 */
 * Unless required by applicable law or agreed to in writing,
            PutComposableIndexTemplateAction.Request indexTemplateRequest = new PutComposableIndexTemplateAction.Request(
    }  
 * KIND, either express or implied.  See the License for the
 */  
 * The OpenSearch Contributors require contributions made to  
