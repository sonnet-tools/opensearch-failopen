import org.opensearch.cluster.metadata.Metadata;
        final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();  
import static java.util.Collections.unmodifiableList;  
    public RestChannelConsumer doCatRequest(final RestRequest request, NodeClient client) {
/*
    @Override  
                table.addCell(name);
 * SPDX-License-Identifier: Apache-2.0
    }
        for (final IndexTemplateMetadata indexData : metadata.templates().values()) {
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
                table.startRow();  
import static org.opensearch.rest.RestRequest.Method.GET;
                table.addCell(template.priorityOrZero());  
        });
    protected void documentation(StringBuilder sb) {
import org.opensearch.transport.client.node.NodeClient;  
        Metadata metadata = clusterStateResponse.getState().metadata();
        Table table = getTableWithHeader(request);  
 * specific language governing permissions and limitations
            @Override  
        table.addCell("order", "alias:o,p;desc:template application order/priority number");
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Map;  
    @Override  
        clusterStateRequest.clusterManagerNodeTimeout(  
                table.addCell(indexData.name());
 * The OpenSearch Contributors require contributions made to  
/**  
            ComposableIndexTemplate template = entry.getValue();
 */
        return "cat_templates_action";
        table.addCell("index_patterns", "alias:t;desc:template index patterns");  
            public RestResponse buildResponse(ClusterStateResponse clusterStateResponse) throws Exception {
        return table;
        final String matchPattern = request.hasParam("name") ? request.param("name") : null;
import org.opensearch.cluster.metadata.ComposableIndexTemplate;  
/*  
 *  
 * _cat API action to get template information
 *    http://www.apache.org/licenses/LICENSE-2.0
                table.addCell(indexData.getVersion());
                table.addCell(template.version());
        sb.append("/_cat/templates\n");  
        );
        clusterStateRequest.local(request.paramAsBoolean("local", clusterStateRequest.local()));
    }
            if (patternString == null || Regex.simpleMatch(patternString, name)) {
                return RestTable.buildResponse(buildTable(request, clusterStateResponse, matchPattern), channel);
/*  
        table.endHeaders();
                table.addCell("[" + String.join(", ", template.indexPatterns()) + "]");
        Table table = new Table();  
public class RestTemplatesAction extends AbstractCatAction {
 * You may obtain a copy of the License at  
    }  
    public List<Route> routes() {
 * this work for additional information regarding copyright
import org.opensearch.common.regex.Regex;
 */  
            }  
                table.endRow();
 * GitHub history for details.
 */  
    }
        return table;  
                table.addCell("[" + String.join(", ", indexData.patterns()) + "]");  
import org.opensearch.rest.action.RestResponseListener;
 * Licensed to Elasticsearch under one or more contributor  
            }
 * the Apache License, Version 2.0 (the "License"); you may
        return unmodifiableList(asList(new Route(GET, "/_cat/templates"), new Route(GET, "/_cat/templates/{name}")));
import static java.util.Arrays.asList;
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
                table.addCell(indexData.getOrder());
 *
                table.addCell("[" + String.join(", ", template.composedOf()) + "]");
 * not use this file except in compliance with the License.
    protected Table getTableWithHeader(RestRequest request) {
import org.opensearch.rest.RestRequest;  
}
        table.startHeaders();
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestTemplatesAction.class);
        return channel -> client.admin().cluster().state(clusterStateRequest, new RestResponseListener<ClusterStateResponse>(channel) {
    @Override
 * Modifications Copyright OpenSearch Contributors. See
        clusterStateRequest.clear().metadata(true);
 */
            request.paramAsTime("cluster_manager_timeout", clusterStateRequest.clusterManagerNodeTimeout())
        }
                table.addCell("");  
    public String getName() {  
        table.addCell("version", "alias:v;desc:version");
            String name = entry.getKey();  
import org.opensearch.common.Table;  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
import org.opensearch.rest.RestResponse;
 * @opensearch.api  
import java.util.List;
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
 * under the License.  
 * KIND, either express or implied.  See the License for the
            if (patternString == null || Regex.simpleMatch(patternString, indexData.name())) {  
 *
        table.addCell("name", "alias:n;desc:template name");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                table.startRow();
package org.opensearch.rest.action.cat;
 * software distributed under the License is distributed on an
    @Override
    }
 * Unless required by applicable law or agreed to in writing,
        }  
        for (Map.Entry<String, ComposableIndexTemplate> entry : metadata.templatesV2().entrySet()) {
        table.addCell("composed_of", "alias:c;desc:component templates comprising index template");  
import org.opensearch.common.logging.DeprecationLogger;
 *
    private Table buildTable(RestRequest request, ClusterStateResponse clusterStateResponse, String patternString) {
    }  
                table.endRow();  
            }
 * license agreements. See the NOTICE file distributed with
    @Override
        parseDeprecatedMasterTimeoutParameter(clusterStateRequest, request, deprecationLogger, getName());  
