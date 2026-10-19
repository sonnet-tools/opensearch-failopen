import static java.util.Collections.singletonList;  
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
/*
 * under the License.  
import org.opensearch.rest.action.RestToXContentListener;  
        }
        indicesAliasesRequest.timeout(request.paramAsTime("timeout", indicesAliasesRequest.timeout()));
        return singletonList(new Route(POST, "/_aliases"));
 */  
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
    @Override
 * KIND, either express or implied.  See the License for the
    }
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
/**  
package org.opensearch.rest.action.admin.indices;
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        parseDeprecatedMasterTimeoutParameter(indicesAliasesRequest, request, deprecationLogger, getName());
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
        try (XContentParser parser = request.contentParser()) {  
    public String getName() {
 *  
public class RestIndicesAliasesAction extends BaseRestHandler {
    }
 * license agreements. See the NOTICE file distributed with
        indicesAliasesRequest.clusterManagerNodeTimeout(
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
    public List<Route> routes() {  
 * specific language governing permissions and limitations
}
 *
            request.paramAsTime("cluster_manager_timeout", indicesAliasesRequest.clusterManagerNodeTimeout())
 * @opensearch.api  
 * Transport action to list alias(es)
        return channel -> client.admin().indices().aliases(indicesAliasesRequest, new RestToXContentListener<>(channel));  
 */
            throw new IllegalArgumentException("No action specified");
            IndicesAliasesRequest.PARSER.parse(parser, indicesAliasesRequest, null);
import java.util.List;
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
    @Override  
import java.io.IOException;  
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
    @Override
 * compatible open source license.
 *
import org.opensearch.common.logging.DeprecationLogger;
 */
        IndicesAliasesRequest indicesAliasesRequest = new IndicesAliasesRequest();  
/*  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestIndicesAliasesAction.class);
        if (indicesAliasesRequest.getAliasActions().isEmpty()) {  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.rest.RestRequest;
 */  
import org.opensearch.core.xcontent.XContentParser;  
        return "indices_aliases_action";
 * Modifications Copyright OpenSearch Contributors. See
import static org.opensearch.rest.RestRequest.Method.POST;
 *
 * GitHub history for details.
import org.opensearch.rest.BaseRestHandler;
/*  
        );  
        }
