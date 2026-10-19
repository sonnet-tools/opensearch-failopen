    @Override
        "Assigning [master_node] to parameter [metric] is deprecated and will be removed in 3.0. To support inclusive language, please use [cluster_manager_node] instead.";
    public List<Route> routes() {
    @Override
 * The OpenSearch Contributors require contributions made to  
        }  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.ToXContent;
            clusterStateRequest.blocks(metrics.contains(ClusterState.Metric.BLOCKS));
import org.opensearch.cluster.metadata.Metadata;
    // It's used to log deprecation when request parameter 'metric' contains 'master_node', or request parameter 'master_timeout' is used.
        responseParams.addAll(Settings.FORMAT_PARAMS);  
 * this work for additional information regarding copyright
/*  
        );
                new Route(GET, "/_cluster/state/{metric}"),
            @Override
            clusterStateRequest.waitForMetadataVersion(request.paramAsLong("wait_for_metadata_version", 0));
             * there is no distinction in Java api between routing_table and routing_nodes, it's the same info set over the wire, one single  
        return false;
    public String getName() {
 *
import org.opensearch.rest.BytesRestResponse;
            // Because "_all" value will add all Metric into metrics set, for prevent deprecation message shown in that case,  
import java.util.Collections;
        clusterStateRequest.clusterManagerNodeTimeout(  
        responseParams.add("metric");
        RESPONSE_PARAMS = Collections.unmodifiableSet(responseParams);
            // add the check of validating metrics set doesn't contain all enum elements.
    }
    }  
                    builder.field(Fields.WAIT_FOR_TIMED_OUT, response.isWaitForTimedOut());
            if (!metrics.equals(EnumSet.allOf(ClusterState.Metric.class)) && metrics.contains(ClusterState.Metric.MASTER_NODE)) {
    private static final Set<String> RESPONSE_PARAMS;
        }
        static final String WAIT_FOR_TIMED_OUT = "wait_for_timed_out";  
import org.opensearch.action.support.IndicesOptions;  
                builder.startObject();  
 * compatible open source license.
            EnumSet<ClusterState.Metric> metrics = ClusterState.Metric.parseString(request.param("metric"), true);
                );
        this.settingsFilter = settingsFilter;
import org.opensearch.rest.action.RestBuilderListener;
import java.util.EnumSet;
        final Set<String> responseParams = new HashSet<>();
import org.opensearch.rest.BaseRestHandler;
                new Route(GET, "/_cluster/state"),
            public RestResponse buildResponse(ClusterStateResponse response, XContentBuilder builder) throws Exception {
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
    }
                return new BytesRestResponse(RestStatus.OK, builder);
    protected Set<String> responseParams() {
    public boolean allowSystemIndexAccessByDefault() {  
            clusterStateRequest.metadata(metrics.contains(ClusterState.Metric.METADATA));  
public class RestClusterStateAction extends BaseRestHandler {
            asList(  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.api  
 * Transport action to get cluster state
                metrics.contains(ClusterState.Metric.ROUTING_TABLE) || metrics.contains(ClusterState.Metric.ROUTING_NODES)
        final ClusterStateRequest clusterStateRequest = Requests.clusterStateRequest();  
                    || metrics.contains(ClusterState.Metric.CLUSTER_MANAGER_NODE)  
    }
/**  
import java.util.Set;
            request.paramAsTime("cluster_manager_timeout", clusterStateRequest.clusterManagerNodeTimeout())
                    singletonMap(Metadata.CONTEXT_MODE_PARAM, Metadata.CONTEXT_MODE_API),  
 *  
                response.getState().toXContent(builder, params);  
            }
    static final class Fields {
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.rest.RestRequest.Method.GET;
            clusterStateRequest.routingTable(  
                    || metrics.contains(ClusterState.Metric.MASTER_NODE)
            // do not ask for what we do not need.
import org.opensearch.rest.RestRequest;  
 */  
    private static final String DEPRECATED_MESSAGE_MASTER_NODE =
 *
            }  
 *
        if (!isAllIndicesOnly) {
/*
import org.opensearch.core.common.Strings;  
        return channel -> client.admin().cluster().state(clusterStateRequest, new RestBuilderListener<ClusterStateResponse>(channel) {  
import org.opensearch.common.settings.Settings;
    private final SettingsFilter settingsFilter;
                new Route(GET, "/_cluster/state/{metric}/{indices}")  
    public RestClusterStateAction(SettingsFilter settingsFilter) {  
        boolean isAllIndicesOnly = indices.length == 1 && "_all".equals(indices[0]);
import org.opensearch.core.rest.RestStatus;
 * specific language governing permissions and limitations
import java.io.IOException;  
 */
 * software distributed under the License is distributed on an
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
                ToXContent.Params params = new ToXContent.DelegatingMapParams(
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestClusterStateAction.class);  
import java.util.List;
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            );
                metrics.contains(ClusterState.Metric.NODES)
 * Modifications Copyright OpenSearch Contributors. See
    @Override  
        if (request.hasParam("metric")) {  
    }
                deprecationLogger.deprecate("cluster_state_metric_parameter_master_node_value", DEPRECATED_MESSAGE_MASTER_NODE);  
             */
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.rest.RestResponse;
import static java.util.Collections.unmodifiableList;  
import org.opensearch.common.logging.DeprecationLogger;  
        );
        if (request.hasParam("wait_for_metadata_version")) {
        final String[] indices = Strings.splitStringByCommaToArray(request.param("indices", "_all"));  
            );
        clusterStateRequest.waitForTimeout(request.paramAsTime("wait_for_timeout", ClusterStateRequest.DEFAULT_WAIT_FOR_NODE_TIMEOUT));
            /*
import org.opensearch.transport.client.Requests;  
import org.opensearch.core.xcontent.XContentBuilder;  
        return RESPONSE_PARAMS;  
    static {  
    // TODO: Remove the DeprecationLogger after removing MASTER_ROLE.
        });
                    request
                }  
import static java.util.Arrays.asList;
            clusterStateRequest.customs(metrics.contains(ClusterState.Metric.CUSTOMS));
        parseDeprecatedMasterTimeoutParameter(clusterStateRequest, request, deprecationLogger, getName());  
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.rest.action.admin.cluster;
import org.opensearch.common.settings.SettingsFilter;
import org.opensearch.cluster.ClusterState;
            clusterStateRequest.indices(indices);  
                builder.field(Fields.CLUSTER_NAME, response.getClusterName().value());
 * You may obtain a copy of the License at  
 */
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
    @Override
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
             * flag to ask for it
        clusterStateRequest.local(request.paramAsBoolean("local", clusterStateRequest.local()));
        static final String CLUSTER_NAME = "cluster_name";
        clusterStateRequest.indicesOptions(IndicesOptions.fromRequest(request, clusterStateRequest.indicesOptions()));
import static java.util.Collections.singletonMap;
    }  
 * the Apache License, Version 2.0 (the "License"); you may
        return unmodifiableList(
    }
    public boolean canTripCircuitBreaker() {
/*  
    }
                builder.endObject();
        }  
            // TODO: Remove the DeprecationLogger after removing MASTER_ROLE.
 * this file be licensed under the Apache-2.0 license or a
    @Override
}
            clusterStateRequest.nodes(  
        return true;
 */  
        return "cluster_state_action";  
        settingsFilter.addFilterSettingParams(request);
 * not use this file except in compliance with the License.
            )
 * GitHub history for details.
import java.util.HashSet;  
                if (clusterStateRequest.waitForMetadataVersion() != null) {
