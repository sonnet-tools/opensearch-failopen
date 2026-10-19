 * specific language governing permissions and limitations
package org.opensearch.rest.action.admin.indices;
 */  
import java.util.Collections;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
import org.opensearch.transport.client.node.NodeClient;  
 * You may obtain a copy of the License at  
    public String getName() {
 * this work for additional information regarding copyright
/*  
 */  
 * under the License.  
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
import org.opensearch.common.logging.DeprecationLogger;
        DeleteComposableIndexTemplateAction.Request deleteReq = new DeleteComposableIndexTemplateAction.Request(request.param("name"));  
 */  
public class RestDeleteComposableIndexTemplateAction extends BaseRestHandler {
/*
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestDeleteComposableIndexTemplateAction.class);  
import org.opensearch.rest.RestRequest;
    }
import java.io.IOException;
        return channel -> client.execute(DeleteComposableIndexTemplateAction.INSTANCE, deleteReq, new RestToXContentListener<>(channel));
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
 *
import static org.opensearch.rest.RestRequest.Method.DELETE;  
        deleteReq.clusterManagerNodeTimeout(request.paramAsTime("cluster_manager_timeout", deleteReq.clusterManagerNodeTimeout()));
        return Collections.singletonList(new Route(DELETE, "/_index_template/{name}"));
    }
    public List<Route> routes() {  
    @Override
        return "delete_composable_index_template_action";  
/**
 * Transport action to delete composable index template  
import org.opensearch.rest.BaseRestHandler;  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.List;
 * @opensearch.api
import org.opensearch.rest.action.RestToXContentListener;
    @Override
import org.opensearch.action.admin.indices.template.delete.DeleteComposableIndexTemplateAction;
 * not use this file except in compliance with the License.
 *  
 *
}  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
 */
        parseDeprecatedMasterTimeoutParameter(deleteReq, request, deprecationLogger, getName());
    }
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 *
