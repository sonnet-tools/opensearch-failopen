 *
import org.opensearch.transport.client.node.NodeClient;
            request.paramAsTime("cluster_manager_timeout", simulateRequest.clusterManagerNodeTimeout())
 * under the License.  
    }
            indexTemplateRequest.indexTemplate(ComposableIndexTemplate.parse(request.contentParser()));  
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.cluster.metadata.ComposableIndexTemplate;  
 * specific language governing permissions and limitations
            simulateRequest.indexTemplateRequest(indexTemplateRequest);
        parseDeprecatedMasterTimeoutParameter(simulateRequest, request, deprecationLogger, getName());  
 * compatible open source license.
import org.opensearch.action.admin.indices.template.put.PutComposableIndexTemplateAction;
    @Override
public class RestSimulateTemplateAction extends BaseRestHandler {  
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
    }  
 * software distributed under the License is distributed on an
 */
import static org.opensearch.rest.RestRequest.Method.POST;
 */  
        );
import java.util.Arrays;
            PutComposableIndexTemplateAction.Request indexTemplateRequest = new PutComposableIndexTemplateAction.Request(  
 * the Apache License, Version 2.0 (the "License"); you may
        if (request.hasContent()) {
 * Modifications Copyright OpenSearch Contributors. See
        return channel -> client.execute(SimulateTemplateAction.INSTANCE, simulateRequest, new RestToXContentListener<>(channel));
package org.opensearch.rest.action.admin.indices;
 */
    public RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
    @Override
 *  
    public String getName() {  
 * The OpenSearch Contributors require contributions made to  
 */  
import org.opensearch.action.admin.indices.template.post.SimulateTemplateAction;
        SimulateTemplateAction.Request simulateRequest = new SimulateTemplateAction.Request();  
 * SPDX-License-Identifier: Apache-2.0
        return Arrays.asList(new Route(POST, "/_index_template/_simulate"), new Route(POST, "/_index_template/_simulate/{name}"));
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestSimulateTemplateAction.class);
import java.io.IOException;
import java.util.List;  
 * Transport action to simulate a template
 * KIND, either express or implied.  See the License for the
        simulateRequest.clusterManagerNodeTimeout(  
        }
 * GitHub history for details.
/*
                "simulating_template"
 * ownership. Elasticsearch licenses this file to you under  
            );
/*  
/*  
 * @opensearch.api
 * Unless required by applicable law or agreed to in writing,
    }  
 * this file be licensed under the Apache-2.0 license or a
            indexTemplateRequest.create(request.paramAsBoolean("create", false));
import org.opensearch.rest.action.RestToXContentListener;
 * not use this file except in compliance with the License.
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.logging.DeprecationLogger;
            indexTemplateRequest.cause(request.param("cause", "api"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
/**
 * license agreements. See the NOTICE file distributed with
 *  
        return "simulate_template_action";
        simulateRequest.templateName(request.param("name"));
    public List<Route> routes() {
import org.opensearch.rest.RestRequest;  
import org.opensearch.rest.BaseRestHandler;
