 * The OpenSearch Contributors require contributions made to  
import org.opensearch.rest.action.RestResponseListener;
import org.opensearch.rest.RestResponse;
        table.startHeaders()
 *
        });
                    table.addCell(nodeStats.getNode().getId());
            .addCell("field", "alias:f;desc:field name")
    }  
 */  
                }  
 * Modifications Copyright OpenSearch Contributors. See
/*  
        nodesStatsRequest.indices(true);
            }
    @Override
            .endHeaders();  
            if (nodeStats.getIndices().getFieldData().getFields() != null) {
            public RestResponse buildResponse(NodesStatsResponse nodeStatses) throws Exception {
public class RestFielddataAction extends AbstractCatAction {
import org.opensearch.common.Table;
 * KIND, either express or implied.  See the License for the
        nodesStatsRequest.indices().fieldDataFields(fields == null ? new String[] { "*" } : fields);
/**
 *  
 * this work for additional information regarding copyright
        Table table = getTableWithHeader(request);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
                    table.addCell(new ByteSizeValue(cursor.getValue()));
 * SPDX-License-Identifier: Apache-2.0
 *
 * not use this file except in compliance with the License.
package org.opensearch.rest.action.cat;
        Table table = new Table();
 * @opensearch.api
            @Override
    @Override
 */  
    public List<Route> routes() {
import org.opensearch.transport.client.node.NodeClient;  
            .addCell("host", "alias:h;desc:host name")
        sb.append("/_cat/fielddata/{fields}\n");
    }  
    }
    private Table buildTable(final RestRequest request, final NodesStatsResponse nodeStatses) {
    protected RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {
import java.util.List;
        final NodesStatsRequest nodesStatsRequest = new NodesStatsRequest("data:true");  
            .addCell("size", "text-align:right;alias:s;desc:field data usage")
    @Override
 * Cat API class to display information about the size of fielddata fields per node  
 * specific language governing permissions and limitations
                for (var cursor : nodeStats.getIndices().getFieldData().getFields()) {  
    protected void documentation(StringBuilder sb) {  
        return table;
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        return channel -> client.admin().cluster().nodesStats(nodesStatsRequest, new RestResponseListener<NodesStatsResponse>(channel) {  
 * GitHub history for details.
                    table.addCell(nodeStats.getNode().getHostAddress());
 * You may obtain a copy of the License at  
            .addCell("id", "desc:node id")  
        nodesStatsRequest.clear();
        return "cat_fielddata_action";
 * under the License.  
                    table.addCell(nodeStats.getNode().getName());
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
}  
                return RestTable.buildResponse(buildTable(request, nodeStatses), channel);  
import org.opensearch.core.common.unit.ByteSizeValue;
                    table.startRow();
        sb.append("/_cat/fielddata\n");
        return table;
            .addCell("node", "alias:n;desc:node name")  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static java.util.Arrays.asList;
import org.opensearch.rest.RestRequest;  
    @Override  
    }  
 * ownership. Elasticsearch licenses this file to you under  
import static java.util.Collections.unmodifiableList;
                    table.addCell(cursor.getKey());  
            }
    protected Table getTableWithHeader(RestRequest request) {  
 * Licensed to Elasticsearch under one or more contributor  
    @Override
import static org.opensearch.rest.RestRequest.Method.GET;  
        return unmodifiableList(asList(new Route(GET, "/_cat/fielddata"), new Route(GET, "/_cat/fielddata/{fields}")));
            .addCell("ip", "desc:ip address")
                    table.endRow();
/*
 * Unless required by applicable law or agreed to in writing,
    public String getName() {  
 * the Apache License, Version 2.0 (the "License"); you may
                    table.addCell(nodeStats.getNode().getHostName());  
        for (NodeStats nodeStats : nodeStatses.getNodes()) {
 */  
        String[] fields = request.paramAsStringArray("fields", null);  
 *
 */
        }
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
    }
/*  
    }
 * software distributed under the License is distributed on an
