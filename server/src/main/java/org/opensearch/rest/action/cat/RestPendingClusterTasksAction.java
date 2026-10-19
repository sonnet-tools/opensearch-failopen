            t.addCell(task.getInsertOrder());
    @Override
 *  
import org.opensearch.common.logging.DeprecationLogger;
 *
    }  
        return t;
 * Licensed to Elasticsearch under one or more contributor  
    private Table buildTable(RestRequest request, PendingClusterTasksResponse tasks) {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.cluster.service.PendingClusterTask;  
                @Override  
 *  
            .cluster()
    public String getName() {
        return t;
        t.addCell("insertOrder", "alias:o;text-align:right;desc:task insertion order");  
    public List<Route> routes() {
 */  
 * @opensearch.api
                    return RestTable.buildResponse(tab, channel);  
/*  
            t.addCell(task.getPriority());  
    protected void documentation(StringBuilder sb) {  
 * this work for additional information regarding copyright
            t.endRow();
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.rest.action.RestResponseListener;
 *    http://www.apache.org/licenses/LICENSE-2.0
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestPendingClusterTasksAction.class);
/*  
            t.addCell(task.getSource());
            .pendingClusterTasks(pendingClusterTasksRequest, new RestResponseListener<PendingClusterTasksResponse>(channel) {
        t.endHeaders();
import org.opensearch.action.admin.cluster.tasks.PendingClusterTasksRequest;
        return singletonList(new Route(GET, "/_cat/pending_tasks"));  
}
 * GitHub history for details.
            t.addCell(task.getTimeInQueue());
 * _cat API action to get pending cluster tasks
package org.opensearch.rest.action.cat;
 * You may obtain a copy of the License at  
/*
 * license agreements. See the NOTICE file distributed with
            request.paramAsTime("cluster_manager_timeout", pendingClusterTasksRequest.clusterManagerNodeTimeout())
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.action.admin.cluster.tasks.PendingClusterTasksResponse;
        t.addCell("source", "alias:s;desc:task source");  
 */
            });
    @Override  
 * software distributed under the License is distributed on an
        pendingClusterTasksRequest.local(request.paramAsBoolean("local", pendingClusterTasksRequest.local()));
 * The OpenSearch Contributors require contributions made to  
        return channel -> client.admin()  
/**
import org.opensearch.common.Table;
 * specific language governing permissions and limitations
    }
            t.startRow();  
        Table t = getTableWithHeader(request);  
        PendingClusterTasksRequest pendingClusterTasksRequest = new PendingClusterTasksRequest();  
 * not use this file except in compliance with the License.
import java.util.List;
        }  
        t.startHeaders();
    public RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {
import static java.util.Collections.singletonList;
import org.opensearch.rest.RestResponse;
import static org.opensearch.rest.RestRequest.Method.GET;
import org.opensearch.transport.client.node.NodeClient;  
 *
        parseDeprecatedMasterTimeoutParameter(pendingClusterTasksRequest, request, deprecationLogger, getName());
    }  
        Table t = new Table();
                    Table tab = buildTable(request, pendingClusterTasks);
 * Unless required by applicable law or agreed to in writing,
    @Override
import org.opensearch.rest.RestRequest;  
    protected Table getTableWithHeader(final RestRequest request) {  
                public RestResponse buildResponse(PendingClusterTasksResponse pendingClusterTasks) throws Exception {
 */
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
        pendingClusterTasksRequest.clusterManagerNodeTimeout(
 * SPDX-License-Identifier: Apache-2.0
    @Override
public class RestPendingClusterTasksAction extends AbstractCatAction {  
    @Override
        for (PendingClusterTask task : tasks) {
 */  
    }
                }
        );  
        t.addCell("priority", "alias:p;desc:task priority");
 * compatible open source license.
 * under the License.  
    }  
        return "cat_pending_cluster_tasks_action";
    }  
 * ownership. Elasticsearch licenses this file to you under  
        t.addCell("timeInQueue", "alias:t;text-align:right;desc:how long task has been in queue");
        sb.append("/_cat/pending_tasks\n");
