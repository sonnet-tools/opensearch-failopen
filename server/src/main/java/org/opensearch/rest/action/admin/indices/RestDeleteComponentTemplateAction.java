 * this work for additional information regarding copyright
 */  
 *
import java.util.Collections;  
 * Transport action to delete component template  
import org.opensearch.rest.action.RestToXContentListener;
 */  
    @Override
import org.opensearch.transport.client.node.NodeClient;  
 * under the License.  
        DeleteComponentTemplateAction.Request deleteReq = new DeleteComponentTemplateAction.Request(request.param("name"));  
import org.opensearch.rest.BaseRestHandler;  
 *
    @Override
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
        return "delete_component_template_action";  
 */
public class RestDeleteComponentTemplateAction extends BaseRestHandler {
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
        return Collections.singletonList(new Route(DELETE, "/_component_template/{name}"));
 * not use this file except in compliance with the License.
    }
 * GitHub history for details.
import org.opensearch.action.admin.indices.template.delete.DeleteComponentTemplateAction;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.logging.DeprecationLogger;
    public String getName() {
/**
/*  
package org.opensearch.rest.action.admin.indices;
 * license agreements. See the NOTICE file distributed with
import java.util.List;
}  
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.api
 * KIND, either express or implied.  See the License for the
 *  
        return channel -> client.execute(DeleteComponentTemplateAction.INSTANCE, deleteReq, new RestToXContentListener<>(channel));
 * The OpenSearch Contributors require contributions made to  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
    }
 *
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestDeleteComponentTemplateAction.class);  
        deleteReq.clusterManagerNodeTimeout(request.paramAsTime("cluster_manager_timeout", deleteReq.clusterManagerNodeTimeout()));
    public List<Route> routes() {  
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.rest.RestRequest.Method.DELETE;  
    }
        parseDeprecatedMasterTimeoutParameter(deleteReq, request, deprecationLogger, getName());
/*
import org.opensearch.rest.RestRequest;
 * software distributed under the License is distributed on an
    @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
