import static org.opensearch.rest.RestRequest.Method.PUT;
        return channel -> client.execute(PutComposableIndexTemplateAction.INSTANCE, putRequest, new RestToXContentListener<>(channel));  
 */
import org.opensearch.action.admin.indices.template.put.PutComposableIndexTemplateAction;
    @Override
import org.opensearch.transport.client.node.NodeClient;
        putRequest.indexTemplate(ComposableIndexTemplate.parse(request.contentParser()));
        parseDeprecatedMasterTimeoutParameter(putRequest, request, deprecationLogger, getName());
    }
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
    @Override
        return "put_composable_index_template_action";
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
 * specific language governing permissions and limitations
import java.util.List;
 * KIND, either express or implied.  See the License for the
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
 */  
 * SPDX-License-Identifier: Apache-2.0
/**
        putRequest.create(request.paramAsBoolean("create", false));
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
/*  
 *  
 * Licensed to Elasticsearch under one or more contributor  
/*
 */  
    }  
package org.opensearch.rest.action.admin.indices;
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestPutComposableIndexTemplateAction.class);
 * this work for additional information regarding copyright
 * @opensearch.api
 * Unless required by applicable law or agreed to in writing,
    }
 *
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.rest.RestRequest.Method.POST;
import java.io.IOException;  
        PutComposableIndexTemplateAction.Request putRequest = new PutComposableIndexTemplateAction.Request(request.param("name"));
import org.opensearch.rest.action.RestToXContentListener;  
    public List<Route> routes() {
 * GitHub history for details.
import org.opensearch.rest.BaseRestHandler;
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
}
 */
 * Transport action to put composable index templates
 * the Apache License, Version 2.0 (the "License"); you may
public class RestPutComposableIndexTemplateAction extends BaseRestHandler {  
/*  
    public String getName() {
import org.opensearch.common.logging.DeprecationLogger;  
        putRequest.cause(request.param("cause", "api"));  
 *  
        return Arrays.asList(new Route(POST, "/_index_template/{name}"), new Route(PUT, "/_index_template/{name}"));  
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Arrays;
import org.opensearch.rest.RestRequest;
        putRequest.clusterManagerNodeTimeout(request.paramAsTime("cluster_manager_timeout", putRequest.clusterManagerNodeTimeout()));  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
 *
