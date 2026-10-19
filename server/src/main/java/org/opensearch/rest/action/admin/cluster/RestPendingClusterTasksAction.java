        return singletonList(new Route(GET, "/_cluster/pending_tasks"));
import org.opensearch.action.admin.cluster.tasks.PendingClusterTasksRequest;
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
        PendingClusterTasksRequest pendingClusterTasksRequest = new PendingClusterTasksRequest();
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.logging.DeprecationLogger;
 * license agreements. See the NOTICE file distributed with
    }  
 * @opensearch.api
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 */  
 * not use this file except in compliance with the License.
public class RestPendingClusterTasksAction extends BaseRestHandler {
import java.io.IOException;
    public List<Route> routes() {  
        parseDeprecatedMasterTimeoutParameter(pendingClusterTasksRequest, request, deprecationLogger, getName());  
 */  
 *
        return "pending_cluster_tasks_action";  
import org.opensearch.transport.client.node.NodeClient;  
        return channel -> client.admin().cluster().pendingClusterTasks(pendingClusterTasksRequest, new RestToXContentListener<>(channel));
 * The OpenSearch Contributors require contributions made to  
    public String getName() {
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.rest.RestRequest;
 *
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestPendingClusterTasksAction.class);  
/*
            request.paramAsTime("cluster_manager_timeout", pendingClusterTasksRequest.clusterManagerNodeTimeout())
 * You may obtain a copy of the License at  
import org.opensearch.rest.BaseRestHandler;  
import static org.opensearch.rest.RestRequest.Method.GET;  
 */  
 * compatible open source license.
 */
}
 * Modifications Copyright OpenSearch Contributors. See
    @Override
/*  
    }
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
import static java.util.Collections.singletonList;
 *
    @Override
 * Transport action to get pending cluster tasks  
import java.util.List;  
package org.opensearch.rest.action.admin.cluster;
        pendingClusterTasksRequest.clusterManagerNodeTimeout(  
/**
 *  
import org.opensearch.rest.action.RestToXContentListener;
/*  
 * this work for additional information regarding copyright
        pendingClusterTasksRequest.local(request.paramAsBoolean("local", pendingClusterTasksRequest.local()));
 * specific language governing permissions and limitations
