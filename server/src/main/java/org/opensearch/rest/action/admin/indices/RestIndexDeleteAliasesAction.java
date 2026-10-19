 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.api
    public String getName() {
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;  
/*
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.rest.BaseRestHandler;
 *  
    }
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
 *
        );
    public List<Route> routes() {
 * Transport action to delete index aliases
public class RestIndexDeleteAliasesAction extends BaseRestHandler {  
 * license agreements. See the NOTICE file distributed with
        indicesAliasesRequest.clusterManagerNodeTimeout(  
}
 *  
        parseDeprecatedMasterTimeoutParameter(indicesAliasesRequest, request, deprecationLogger, getName());  
        return unmodifiableList(asList(new Route(DELETE, "/{index}/_alias/{name}"), new Route(DELETE, "/{index}/_aliases/{name}")));  
import org.opensearch.common.logging.DeprecationLogger;
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
import org.opensearch.transport.client.node.NodeClient;
    }  
 * You may obtain a copy of the License at  
        final String[] aliases = Strings.splitStringByCommaToArray(request.param("name"));
        return "index_delete_aliases_action";
package org.opensearch.rest.action.admin.indices;
/**
import static org.opensearch.rest.RestRequest.Method.DELETE;
    @Override
 * this file be licensed under the Apache-2.0 license or a
    @Override  
        IndicesAliasesRequest indicesAliasesRequest = new IndicesAliasesRequest();  
 * specific language governing permissions and limitations
/*  
 * GitHub history for details.
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
 * under the License.  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestIndexPutAliasAction.class);
 */
 */  
 */
        indicesAliasesRequest.addAliasAction(AliasActions.remove().indices(indices).aliases(aliases));
    }  
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See  
import static java.util.Collections.unmodifiableList;
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
    @Override
 */
import org.opensearch.rest.action.RestToXContentListener;  
import java.io.IOException;  
import org.opensearch.rest.RestRequest;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
import static java.util.Arrays.asList;  
            request.paramAsTime("cluster_manager_timeout", indicesAliasesRequest.clusterManagerNodeTimeout())
 * compatible open source license.
import org.opensearch.core.common.Strings;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        indicesAliasesRequest.timeout(request.paramAsTime("timeout", indicesAliasesRequest.timeout()));
        final String[] indices = Strings.splitStringByCommaToArray(request.param("index"));
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
        return channel -> client.admin().indices().aliases(indicesAliasesRequest, new RestToXContentListener<>(channel));
