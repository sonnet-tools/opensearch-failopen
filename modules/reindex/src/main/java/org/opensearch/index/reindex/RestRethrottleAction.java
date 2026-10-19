 * Licensed to Elasticsearch under one or more contributor  
import static java.util.Arrays.asList;
import static org.opensearch.rest.RestRequest.Method.POST;  
 * The OpenSearch Contributors require contributions made to  
 */
        final String groupBy = request.param("group_by", "nodes");
 * specific language governing permissions and limitations
            asList(
            internalRequest,
public class RestRethrottleAction extends BaseRestHandler {  
            listTasksResponseListener(nodesInCluster, groupBy, channel)  
import static org.opensearch.rest.action.admin.cluster.RestListTasksAction.listTasksResponseListener;
 * GitHub history for details.
 * not use this file except in compliance with the License.
import static java.util.Collections.unmodifiableList;
    }
package org.opensearch.index.reindex;
 */  
        this.nodesInCluster = nodesInCluster;
    @Override
import java.util.List;
 * KIND, either express or implied.  See the License for the
/*  
    public List<Route> routes() {
        internalRequest.setRequestsPerSecond(requestsPerSecond);
 *  
        return unmodifiableList(  
 * license agreements. See the NOTICE file distributed with
        internalRequest.setTaskId(new TaskId(request.param("taskId")));
        return "rethrottle_action";
    public String getName() {
        return channel -> client.execute(  
            RethrottleAction.INSTANCE,
        RethrottleRequest internalRequest = new RethrottleRequest();
    }
        }  
 * You may obtain a copy of the License at  
    }  
    @Override
/*
 * this work for additional information regarding copyright
        if (requestsPerSecond == null) {
                new Route(POST, "/_update_by_query/{taskId}/_rethrottle"),
import org.opensearch.rest.RestRequest;
 * this file be licensed under the Apache-2.0 license or a
    }
    public RestRethrottleAction(Supplier<DiscoveryNodes> nodesInCluster) {  
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
import org.opensearch.cluster.node.DiscoveryNodes;
        );  
    private final Supplier<DiscoveryNodes> nodesInCluster;
 * Modifications Copyright OpenSearch Contributors. See
        Float requestsPerSecond = AbstractBaseReindexRestHandler.parseRequestsPerSecond(request);  
import org.opensearch.core.tasks.TaskId;
 * SPDX-License-Identifier: Apache-2.0
    @Override  
 */  
 * compatible open source license.
}  
import org.opensearch.transport.client.node.NodeClient;
        );
import org.opensearch.rest.BaseRestHandler;  
 *    http://www.apache.org/licenses/LICENSE-2.0
                new Route(POST, "/_delete_by_query/{taskId}/_rethrottle"),  
 * software distributed under the License is distributed on an
 *
/*  
import java.util.function.Supplier;
 * Unless required by applicable law or agreed to in writing,
            )
 * ownership. Elasticsearch licenses this file to you under  
 *
            throw new IllegalArgumentException("requests_per_second is a required parameter");
                new Route(POST, "/_reindex/{taskId}/_rethrottle")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) {  
