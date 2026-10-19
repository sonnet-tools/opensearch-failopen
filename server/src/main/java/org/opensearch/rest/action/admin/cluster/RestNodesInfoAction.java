public class RestNodesInfoAction extends BaseRestHandler {  
            } else {
            metrics.retainAll(ALLOWED_METRICS);
    }
 *  
import java.util.Set;
                new Route(GET, "/_nodes/{nodeId}/{metrics}"),
import static java.util.Collections.unmodifiableList;
import org.opensearch.transport.client.node.NodeClient;  
        }  
            nodesInfoRequest.all();  
        }  
/*
                // this endpoint is used for metrics, not for node IDs, like /_nodes/fs
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
        // special case like /_nodes/os (in this case os are metrics and not the nodeId)
 * KIND, either express or implied.  See the License for the
    public List<Route> routes() {
        final NodesInfoRequest nodesInfoRequest = prepareRequest(request);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
            metrics = Strings.tokenizeByCommaToSet(request.param("metrics", "_all"));
import org.opensearch.rest.action.RestActions.NodesResponseRestListener;
    @Override
        String[] nodeIds;
            // disregard unknown metrics  
    public String getName() {  
                nodeIds = new String[] { "_all" };  
 * this file be licensed under the Apache-2.0 license or a
        nodesInfoRequest.timeout(request.param("timeout"));
        Set<String> metrics;
 *
                metrics = metricsOrNodeIds;
 * specific language governing permissions and limitations
        settingsFilter.addFilterSettingParams(request);
                // added this endpoint to be aligned with stats
    public RestNodesInfoAction(SettingsFilter settingsFilter) {
import static java.util.Arrays.asList;  
            asList(  
/**
        // still, /_nodes/_local (or any other node id) should work and be treated as usual
        return Settings.FORMAT_PARAMS;  
 * under the License.  
import org.opensearch.rest.RestRequest;
            nodesInfoRequest.clear();
    @Override
        );
 */  
 * @opensearch.api
                new Route(GET, "/_nodes/{nodeId}"),  
 * license agreements. See the NOTICE file distributed with
    }  
        nodesInfoRequest.timeout(request.param("timeout"));  
    @Override  
 * software distributed under the License is distributed on an
    @Override
 */  
import org.opensearch.common.settings.Settings;
import java.io.IOException;
 * compatible open source license.
import java.util.List;  
 * not use this file except in compliance with the License.
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
 * Transport action to get node info
        // this means one must differentiate between allowed metrics and arbitrary node ids in the same place  
        this.settingsFilter = settingsFilter;  
        if (metrics.size() == 1 && metrics.contains("_all")) {
        return "nodes_info_action";
    }
        // shortcut, don't do checks if only all is specified
            )
    static NodesInfoRequest prepareRequest(final RestRequest request) {  
                new Route(GET, "/_nodes/{nodeId}/info/{metrics}")  
            if (isMetricsOnly) {
        final NodesInfoRequest nodesInfoRequest = new NodesInfoRequest(nodeIds);
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
import org.opensearch.rest.BaseRestHandler;  
    static final Set<String> ALLOWED_METRICS = NodesInfoRequest.Metric.allMetrics();
    @Override  
import org.opensearch.core.common.Strings;
        return unmodifiableList(
                metrics = Sets.newHashSet("_all");
/*  
 * this work for additional information regarding copyright
import org.opensearch.common.util.set.Sets;
        if (request.hasParam("nodeId") && !request.hasParam("metrics")) {
}
 */
    private final SettingsFilter settingsFilter;  
            Set<String> metricsOrNodeIds = Strings.tokenizeByCommaToSet(nodeId);  
            String nodeId = request.param("nodeId", "_all");
        return nodesInfoRequest;
 * You may obtain a copy of the License at  
 */
            nodeIds = Strings.tokenizeToStringArray(request.param("nodeId", "_all"), ",");
        } else {  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.settings.SettingsFilter;  
/*  
 *
        return false;
 *  
            }
                new Route(GET, "/_nodes"),
        } else {
 * Licensed to Elasticsearch under one or more contributor  
    }  
import static org.opensearch.rest.RestRequest.Method.GET;
    }
    public boolean canTripCircuitBreaker() {
        return channel -> client.admin().cluster().nodesInfo(nodesInfoRequest, new NodesResponseRestListener<>(channel));  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 * GitHub history for details.
            nodesInfoRequest.addMetrics(metrics.stream().toArray(String[]::new));
            boolean isMetricsOnly = ALLOWED_METRICS.containsAll(metricsOrNodeIds);
 * the Apache License, Version 2.0 (the "License"); you may
                nodeIds = Strings.tokenizeToStringArray(nodeId, ",");  
    protected Set<String> responseParams() {
package org.opensearch.rest.action.admin.cluster;
 * Unless required by applicable law or agreed to in writing,
    }
