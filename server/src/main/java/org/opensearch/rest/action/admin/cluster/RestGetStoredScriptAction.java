import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See  
/*
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
/*  
 * Transport action to get stored script
 * software distributed under the License is distributed on an
}
    }  
import static java.util.Collections.singletonList;
/**
        parseDeprecatedMasterTimeoutParameter(getRequest, request, deprecationLogger, getName());
 */  
import org.opensearch.rest.BaseRestHandler;
    }  
 * under the License.  
        GetStoredScriptRequest getRequest = new GetStoredScriptRequest(id);
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 */
        return singletonList(new Route(GET, "/_scripts/{id}"));  
 */
        return "get_stored_scripts_action";
public class RestGetStoredScriptAction extends BaseRestHandler {  
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
        getRequest.clusterManagerNodeTimeout(request.paramAsTime("cluster_manager_timeout", getRequest.clusterManagerNodeTimeout()));  
 *
 * The OpenSearch Contributors require contributions made to  
/*
 * specific language governing permissions and limitations
import static org.opensearch.rest.RestRequest.Method.GET;
    @Override  
import org.opensearch.rest.RestRequest;  
    public RestChannelConsumer prepareRequest(final RestRequest request, NodeClient client) throws IOException {  
import org.opensearch.transport.client.node.NodeClient;
    public List<Route> routes() {
    @Override
import java.util.List;
        String id = request.param("id");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestGetStoredScriptAction.class);
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
    @Override
import org.opensearch.rest.action.RestStatusToXContentListener;
 *  
        return channel -> client.admin().cluster().getStoredScript(getRequest, new RestStatusToXContentListener<>(channel));
import org.opensearch.common.logging.DeprecationLogger;
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
 *
 * @opensearch.api
    }
 *  
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptRequest;  
    public String getName() {
package org.opensearch.rest.action.admin.cluster;
 * ownership. Elasticsearch licenses this file to you under  
