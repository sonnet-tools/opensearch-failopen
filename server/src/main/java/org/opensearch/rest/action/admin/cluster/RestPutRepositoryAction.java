        return "put_repository_action";
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
            request.paramAsTime("cluster_manager_timeout", putRepositoryRequest.clusterManagerNodeTimeout())  
 *  
        return unmodifiableList(asList(new Route(POST, "/_snapshot/{repository}"), new Route(PUT, "/_snapshot/{repository}")));
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
        }  
    }
import org.opensearch.transport.client.node.NodeClient;
import static java.util.Arrays.asList;  
 * GitHub history for details.
        PutRepositoryRequest putRepositoryRequest = putRepositoryRequest(request.param("repository"));  
/**  
public class RestPutRepositoryAction extends BaseRestHandler {
        putRepositoryRequest.timeout(request.paramAsTime("timeout", putRepositoryRequest.timeout()));  
    public String getName() {  
 *
 * SPDX-License-Identifier: Apache-2.0
 */
 * @opensearch.api  
 * You may obtain a copy of the License at  
        parseDeprecatedMasterTimeoutParameter(putRepositoryRequest, request, deprecationLogger, getName());
        );
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.rest.BaseRestHandler;
        return channel -> client.admin().cluster().putRepository(putRepositoryRequest, new RestToXContentListener<>(channel));
 * Licensed to Elasticsearch under one or more contributor  
import static org.opensearch.rest.RestRequest.Method.PUT;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
    }
/*
import org.opensearch.rest.action.RestToXContentListener;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 */
import java.util.List;
}  
 */  
            putRepositoryRequest.source(parser.mapOrdered());
 *
 * not use this file except in compliance with the License.
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestPutRepositoryAction.class);
import org.opensearch.common.logging.DeprecationLogger;
    @Override
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;
/*  
package org.opensearch.rest.action.admin.cluster;
        try (XContentParser parser = request.contentParser()) {
 * Registers repositories
    }  
        putRepositoryRequest.clusterManagerNodeTimeout(
import org.opensearch.core.xcontent.XContentParser;  
import static org.opensearch.rest.RestRequest.Method.POST;
 * under the License.  
 */  
        putRepositoryRequest.verify(request.paramAsBoolean("verify", true));
import static org.opensearch.transport.client.Requests.putRepositoryRequest;
import java.io.IOException;  
/*  
    @Override  
    public List<Route> routes() {
 *
import static java.util.Collections.unmodifiableList;
import org.opensearch.rest.RestRequest;
    @Override
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
