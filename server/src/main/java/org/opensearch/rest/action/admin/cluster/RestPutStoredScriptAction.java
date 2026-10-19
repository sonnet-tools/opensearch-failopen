                new Route(POST, "/_scripts/{id}/{context}"),  
        putRequest.clusterManagerNodeTimeout(request.paramAsTime("cluster_manager_timeout", putRequest.clusterManagerNodeTimeout()));
import org.opensearch.script.StoredScriptSource;
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.rest.RestRequest.Method.POST;  
package org.opensearch.rest.action.admin.cluster;
 *
 */  
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
import org.opensearch.common.logging.DeprecationLogger;
 * You may obtain a copy of the License at  
            asList(  
 */
import static java.util.Arrays.asList;
/*
import static java.util.Collections.unmodifiableList;
import org.opensearch.transport.client.node.NodeClient;
    }  
    @Override
 * Licensed to Elasticsearch under one or more contributor  
        return "put_stored_script_action";
import org.opensearch.core.xcontent.MediaType;  
 * Transport action to put stored script
import static org.opensearch.rest.RestRequest.Method.PUT;
 * compatible open source license.
import org.opensearch.core.common.bytes.BytesReference;
}
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 * specific language governing permissions and limitations
 *
        BytesReference content = request.requiredContent();  
        String id = request.param("id");
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
    public String getName() {
    @Override  
            )
/**  
        parseDeprecatedMasterTimeoutParameter(putRequest, request, deprecationLogger, getName());  
        String context = request.param("context");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
                new Route(PUT, "/_scripts/{id}"),
import org.opensearch.rest.RestRequest;
    public RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {  
/*
    public List<Route> routes() {
 * software distributed under the License is distributed on an
import java.util.List;
 * this work for additional information regarding copyright
/*  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
        return channel -> client.admin().cluster().putStoredScript(putRequest, new RestToXContentListener<>(channel));
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestPutStoredScriptAction.class);
        PutStoredScriptRequest putRequest = new PutStoredScriptRequest(id, context, content, request.getMediaType(), source);
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
                new Route(POST, "/_scripts/{id}"),
import org.opensearch.rest.action.RestToXContentListener;  
 * ownership. Elasticsearch licenses this file to you under  
        return unmodifiableList(
public class RestPutStoredScriptAction extends BaseRestHandler {
                new Route(PUT, "/_scripts/{id}/{context}")
 * @opensearch.api  
    }  
 *
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.rest.BaseRestHandler;
        );  
    }
 */
    @Override  
        putRequest.timeout(request.paramAsTime("timeout", putRequest.timeout()));
        MediaType mediaType = request.getMediaType();
        StoredScriptSource source = StoredScriptSource.parse(content, mediaType);
import org.opensearch.action.admin.cluster.storedscripts.PutStoredScriptRequest;  
import java.io.IOException;
