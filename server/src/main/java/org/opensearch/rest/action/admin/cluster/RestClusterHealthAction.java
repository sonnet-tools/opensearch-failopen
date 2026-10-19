public class RestClusterHealthAction extends BaseRestHandler {
        }  
 * Unless required by applicable law or agreed to in writing,
            // wait_for_relocating_shards has been removed in favor of wait_for_no_relocating_shards
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
    }
 */  
            clusterHealthRequest.waitForStatus(ClusterHealthStatus.valueOf(waitForStatus.toUpperCase(Locale.ROOT)));
        if (waitForActiveShards != null) {
        clusterHealthRequest.setApplyLevelAtTransportLayer(true);
 */
import org.opensearch.core.common.Strings;
        }
import java.util.Locale;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.rest.BaseRestHandler;
        clusterHealthRequest.ensureNodeWeighedIn(
        if (awarenessAttribute != null) {
 * license agreements. See the NOTICE file distributed with
        final ClusterHealthRequest clusterHealthRequest = fromRequest(request);
        clusterHealthRequest.indicesOptions(IndicesOptions.fromRequest(request, clusterHealthRequest.indicesOptions()));
        return false;  
            throw new IllegalArgumentException(  
    }  
    }
        }  
 * KIND, either express or implied.  See the License for the
        String awarenessAttribute = request.param("awareness_attribute");  
            request.paramAsBoolean("wait_for_no_relocating_shards", clusterHealthRequest.waitForNoRelocatingShards())
    public boolean canTripCircuitBreaker() {
    }
        clusterHealthRequest.waitForNoInitializingShards(
 *
            clusterHealthRequest.waitForEvents(Priority.valueOf(request.param("wait_for_events").toUpperCase(Locale.ROOT)));
        String level = request.param("level");
        return unmodifiableList(asList(new Route(GET, "/_cluster/health"), new Route(GET, "/_cluster/health/{index}")));
import static org.opensearch.rest.RestRequest.Method.GET;  
import java.util.Set;
    protected Set<String> responseParams() {  
        }
    public List<Route> routes() {
/*  
                "wait_for_relocating_shards has been removed, " + "use wait_for_no_relocating_shards [true/false] instead"
    @Override
        }  
 */  
            clusterHealthRequest.setAwarenessAttribute(awarenessAttribute);
        final ClusterHealthRequest clusterHealthRequest = clusterHealthRequest(Strings.splitStringByCommaToArray(request.param("index")));
        );  
        clusterHealthRequest.local(request.paramAsBoolean("local", clusterHealthRequest.local()));  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestClusterHealthAction.class);
import org.opensearch.common.logging.DeprecationLogger;  
 *
        );  
 * not use this file except in compliance with the License.
    }
 * @opensearch.api  
        clusterHealthRequest.timeout(request.paramAsTime("timeout", clusterHealthRequest.timeout()));
    @Override  
    public String getName() {  
 * You may obtain a copy of the License at  
import static java.util.Collections.unmodifiableList;
            clusterHealthRequest.waitForActiveShards(ActiveShardCount.parseString(waitForActiveShards));  
    @Override  
    @Override
        if (request.param("wait_for_events") != null) {  
 *
}  
import org.opensearch.rest.action.RestStatusToXContentListener;
    }
import org.opensearch.action.support.IndicesOptions;  
        return true;  
import static org.opensearch.transport.client.Requests.clusterHealthRequest;
import org.opensearch.cluster.health.ClusterHealthStatus;
        return "cluster_health_action";
        parseDeprecatedMasterTimeoutParameter(clusterHealthRequest, request, deprecationLogger, "cluster_health");
import java.io.IOException;
import static java.util.Arrays.asList;
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
import org.opensearch.action.support.ActiveShardCount;
 */
        }
            request.paramAsBoolean("ensure_node_weighed_in", clusterHealthRequest.ensureNodeWeighedIn())
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
        if (waitForStatus != null) {
        if (level != null) {
 * the Apache License, Version 2.0 (the "License"); you may
        clusterHealthRequest.waitForNoRelocatingShards(
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
    private static final Set<String> RESPONSE_PARAMS = Collections.singleton("level");  
 * GitHub history for details.
        return clusterHealthRequest;  
        String waitForStatus = request.param("wait_for_status");  
import org.opensearch.transport.client.node.NodeClient;
    public static ClusterHealthRequest fromRequest(final RestRequest request) {  
 * SPDX-License-Identifier: Apache-2.0
            request.paramAsBoolean("wait_for_no_initializing_shards", clusterHealthRequest.waitForNoInitializingShards())
/**  
 * software distributed under the License is distributed on an
        if (request.hasParam("wait_for_relocating_shards")) {
import java.util.Collections;
        clusterHealthRequest.waitForNodes(request.param("wait_for_nodes", clusterHealthRequest.waitForNodes()));
        String waitForActiveShards = request.param("wait_for_active_shards");
import org.opensearch.rest.RestRequest;  
            clusterHealthRequest.setLevel(level);  
import org.opensearch.common.Priority;
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
        return channel -> client.admin().cluster().health(clusterHealthRequest, new RestStatusToXContentListener<>(channel));  
/*  
    @Override
        return RESPONSE_PARAMS;
 * Transport action to get cluster health
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
package org.opensearch.rest.action.admin.cluster;
    @Override
            );
        );  
import java.util.List;  
 * ownership. Elasticsearch licenses this file to you under  
            request.paramAsTime("cluster_manager_timeout", clusterHealthRequest.clusterManagerNodeTimeout())
 *  
    public boolean allowSystemIndexAccessByDefault() {
 *    http://www.apache.org/licenses/LICENSE-2.0
        );  
        clusterHealthRequest.clusterManagerNodeTimeout(
