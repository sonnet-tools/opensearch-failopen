import static org.opensearch.rest.RestRequest.Method.PUT;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 * this file be licensed under the Apache-2.0 license or a
    }  
 */
        return "put_component_template_action";
 * Modifications Copyright OpenSearch Contributors. See
        return channel -> client.execute(PutComponentTemplateAction.INSTANCE, putRequest, new RestToXContentListener<>(channel));  
import org.opensearch.cluster.metadata.ComponentTemplate;
    @Override  
package org.opensearch.rest.action.admin.indices;
 * not use this file except in compliance with the License.
 * GitHub history for details.
}
 * license agreements. See the NOTICE file distributed with
/*  
import java.util.List;
import org.opensearch.rest.action.RestToXContentListener;  
 */
import java.util.Arrays;
    @Override
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
 *  
 * Unless required by applicable law or agreed to in writing,
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
 */  
 * @opensearch.api
    @Override
import static org.opensearch.rest.RestRequest.Method.POST;
/**
import org.opensearch.rest.RestRequest;
 * You may obtain a copy of the License at  
        return Arrays.asList(new Route(POST, "/_component_template/{name}"), new Route(PUT, "/_component_template/{name}"));  
        putRequest.clusterManagerNodeTimeout(request.paramAsTime("cluster_manager_timeout", putRequest.clusterManagerNodeTimeout()));  
        PutComponentTemplateAction.Request putRequest = new PutComponentTemplateAction.Request(request.param("name"));
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.rest.BaseRestHandler;
        putRequest.componentTemplate(ComponentTemplate.parse(request.contentParser()));
 *
        putRequest.create(request.paramAsBoolean("create", false));
    }
    public List<Route> routes() {
import org.opensearch.action.admin.indices.template.put.PutComponentTemplateAction;
/*
public class RestPutComponentTemplateAction extends BaseRestHandler {  
 * compatible open source license.
 * Transport action to put component template
 * under the License.  
import org.opensearch.transport.client.node.NodeClient;
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestPutComponentTemplateAction.class);
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.logging.DeprecationLogger;  
import java.io.IOException;  
    }
    public String getName() {
 *  
 * software distributed under the License is distributed on an
 */  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
        parseDeprecatedMasterTimeoutParameter(putRequest, request, deprecationLogger, getName());
 * this work for additional information regarding copyright
        putRequest.cause(request.param("cause", "api"));  
 *
 * Licensed to Elasticsearch under one or more contributor  
