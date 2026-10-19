import java.util.List;
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
 *  
        return "delete_stored_script_action";
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.api
 * not use this file except in compliance with the License.
 *  
        return singletonList(new Route(DELETE, "/_scripts/{id}"));  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestDeleteStoredScriptAction.class);
 */
 * Modifications Copyright OpenSearch Contributors. See  
 * software distributed under the License is distributed on an
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
/*  
 *
/**
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
 * under the License.  
    public String getName() {
/*
 * KIND, either express or implied.  See the License for the
    }
import org.opensearch.rest.BaseRestHandler;
 * Licensed to Elasticsearch under one or more contributor  
    }  
        deleteStoredScriptRequest.timeout(request.paramAsTime("timeout", deleteStoredScriptRequest.timeout()));  
import static org.opensearch.rest.RestRequest.Method.DELETE;
}
import org.opensearch.rest.RestRequest;  
    public RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {  
 *
    @Override
 */
 * this work for additional information regarding copyright
import org.opensearch.common.logging.DeprecationLogger;
 * SPDX-License-Identifier: Apache-2.0
    }
import static java.util.Collections.singletonList;
        String id = request.param("id");
 */
        );  
    @Override
/*
        deleteStoredScriptRequest.clusterManagerNodeTimeout(
 */  
    public List<Route> routes() {
 * license agreements. See the NOTICE file distributed with
package org.opensearch.rest.action.admin.cluster;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptRequest;  
            request.paramAsTime("cluster_manager_timeout", deleteStoredScriptRequest.clusterManagerNodeTimeout())
 * Transport action to delete stored script
public class RestDeleteStoredScriptAction extends BaseRestHandler {  
        parseDeprecatedMasterTimeoutParameter(deleteStoredScriptRequest, request, deprecationLogger, getName());
        DeleteStoredScriptRequest deleteStoredScriptRequest = new DeleteStoredScriptRequest(id);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return channel -> client.admin().cluster().deleteStoredScript(deleteStoredScriptRequest, new RestToXContentListener<>(channel));  
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.rest.action.RestToXContentListener;
    @Override  
