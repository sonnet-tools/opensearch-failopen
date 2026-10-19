    @Override
    public List<Route> routes() {
/**
 *  
    }  
/*  
        getRepositoriesRequest.local(request.paramAsBoolean("local", getRepositoriesRequest.local()));  
        return table;  
            .getRepositories(getRepositoriesRequest, new RestResponseListener<GetRepositoriesResponse>(channel) {
        return "cat_repositories_action";  
        for (RepositoryMetadata repositoryMetadata : getRepositoriesResponse.repositories()) {  
 * Unless required by applicable law or agreed to in writing,
        parseDeprecatedMasterTimeoutParameter(getRepositoriesRequest, request, deprecationLogger, getName());
import org.opensearch.common.logging.DeprecationLogger;
    @Override  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestRepositoriesAction.class);
 * specific language governing permissions and limitations
                public RestResponse buildResponse(GetRepositoriesResponse getRepositoriesResponse) throws Exception {
 * The OpenSearch Contributors require contributions made to  
            .addCell("type", "alias:t,type;text-align:right;desc:repository type")  
        GetRepositoriesRequest getRepositoriesRequest = new GetRepositoriesRequest();
import org.opensearch.common.Table;
    }
            table.addCell(repositoryMetadata.type());
import org.opensearch.transport.client.node.NodeClient;  
 *
package org.opensearch.rest.action.cat;
import static java.util.Collections.singletonList;
}
/*  
    }
import org.opensearch.rest.RestRequest;  
    @Override
    }
            .endHeaders();
            request.paramAsTime("cluster_manager_timeout", getRepositoriesRequest.clusterManagerNodeTimeout())
    }
 * GitHub history for details.
import org.opensearch.rest.action.RestResponseListener;
 *
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.opensearch.rest.RestRequest.Method.GET;
 * Modifications Copyright OpenSearch Contributors. See
    private Table buildTable(RestRequest req, GetRepositoriesResponse getRepositoriesResponse) {
        );  
 * under the License.  
                }  
public class RestRepositoriesAction extends AbstractCatAction {  
 *  
import org.opensearch.cluster.metadata.RepositoryMetadata;  
 */  
                    return RestTable.buildResponse(buildTable(request, getRepositoriesResponse), channel);
 */
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
            table.addCell(repositoryMetadata.name());  
 * @opensearch.api
 */  
 * KIND, either express or implied.  See the License for the
 */
        getRepositoriesRequest.clusterManagerNodeTimeout(
import java.util.List;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            .cluster()
            table.startRow();
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
    public RestChannelConsumer doCatRequest(RestRequest request, NodeClient client) {
    protected Table getTableWithHeader(RestRequest request) {  
 * this file be licensed under the Apache-2.0 license or a
    public String getName() {
        return new Table().startHeaders()
 * license agreements. See the NOTICE file distributed with
        return channel -> client.admin()  
 * Licensed to Elasticsearch under one or more contributor  
        }
    protected void documentation(StringBuilder sb) {
    @Override  
        Table table = getTableWithHeader(req);
 * compatible open source license.
            .addCell("id", "alias:id,repoId;desc:unique repository id")
        sb.append("/_cat/repositories\n");
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
            table.endRow();  
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
import org.opensearch.rest.RestResponse;
 * software distributed under the License is distributed on an
                @Override  
 * Cat API class to display information about snapshot repositories
            });
 * ownership. Elasticsearch licenses this file to you under  
        return singletonList(new Route(GET, "/_cat/repositories"));  
 * SPDX-License-Identifier: Apache-2.0
