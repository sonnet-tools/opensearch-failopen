import org.opensearch.transport.client.node.NodeClient;  
    private final Settings settings;  
    }
        final ClusterState state,
            public RestResponse buildResponse(ClusterStateResponse response, XContentBuilder builder) throws Exception {
                return new BytesRestResponse(RestStatus.OK, renderResponse(response.getState(), renderDefaults, builder, request));
 *
        return singletonList(new Route(GET, "/_cluster/settings"));  
import org.opensearch.transport.client.Requests;
    @Override
    protected Set<String> responseParams() {
import org.opensearch.rest.action.RestBuilderListener;
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
    public boolean canTripCircuitBreaker() {
        });
 *  
    @Override  
 */  
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
import java.util.List;  
/**  
import org.opensearch.cluster.ClusterState;
import org.opensearch.core.xcontent.XContentBuilder;
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestClusterGetSettingsAction.class);
    @Override  
 * @opensearch.api  
import org.opensearch.core.rest.RestStatus;  
 * compatible open source license.
            renderDefaults ? settingsFilter.filter(clusterSettings.diff(state.metadata().settings(), settings)) : Settings.EMPTY
import org.opensearch.common.settings.Settings;
        throws IOException {  
    public List<Route> routes() {
        final SettingsFilter settingsFilter,
    }
    public String getName() {
        return new ClusterGetSettingsResponse(
        final Settings settings  
 * KIND, either express or implied.  See the License for the
        final ClusterSettings clusterSettings,
import org.opensearch.rest.BaseRestHandler;  
    public RestClusterGetSettingsAction(Settings settings, ClusterSettings clusterSettings, SettingsFilter settingsFilter) {
    private final SettingsFilter settingsFilter;
    @Override
    }
 * not use this file except in compliance with the License.
 */
/*
import org.opensearch.rest.BytesRestResponse;
        this.settingsFilter = settingsFilter;
        this.settings = settings;
import org.opensearch.rest.RestRequest;
 * ownership. Elasticsearch licenses this file to you under  
 */  
    ) {
import static org.opensearch.rest.RestRequest.Method.GET;
        this.clusterSettings = clusterSettings;  
            @Override  
 * this file be licensed under the Apache-2.0 license or a
/*  
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
    static ClusterGetSettingsResponse response(
            settingsFilter.filter(state.metadata().transientSettings()),
import org.opensearch.common.logging.DeprecationLogger;
    private XContentBuilder renderResponse(ClusterState state, boolean renderDefaults, XContentBuilder builder, ToXContent.Params params)
    }
 * You may obtain a copy of the License at  
        clusterStateRequest.local(request.paramAsBoolean("local", clusterStateRequest.local()));  
        return "cluster_get_settings_action";
import java.io.IOException;
import java.util.Set;
        );  
import org.opensearch.common.settings.SettingsFilter;
 * SPDX-License-Identifier: Apache-2.0
        final boolean renderDefaults = request.paramAsBoolean("include_defaults", false);
 * this work for additional information regarding copyright
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
        parseDeprecatedMasterTimeoutParameter(clusterStateRequest, request, deprecationLogger, getName());
        final boolean renderDefaults,  
        return response(state, renderDefaults, settingsFilter, clusterSettings, settings).toXContent(builder, params);
    }
import static java.util.Collections.singletonList;  
            settingsFilter.filter(state.metadata().persistentSettings()),  
 * Transport action to get settings
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.rest.RestResponse;  
    private final ClusterSettings clusterSettings;
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;  
import org.opensearch.common.settings.ClusterSettings;  
        ClusterStateRequest clusterStateRequest = Requests.clusterStateRequest().routingTable(false).nodes(false);
 * The OpenSearch Contributors require contributions made to  
            }  
package org.opensearch.rest.action.admin.cluster;
            request.paramAsTime("cluster_manager_timeout", clusterStateRequest.clusterManagerNodeTimeout())
        clusterStateRequest.clusterManagerNodeTimeout(
 */
public class RestClusterGetSettingsAction extends BaseRestHandler {
        return false;
    @Override
 * specific language governing permissions and limitations
        );  
import org.opensearch.action.admin.cluster.settings.ClusterGetSettingsResponse;
 * GitHub history for details.
    }
 *
 *
        return Settings.FORMAT_PARAMS;  
/*  
    }  
        return channel -> client.admin().cluster().state(clusterStateRequest, new RestBuilderListener<ClusterStateResponse>(channel) {
}  
