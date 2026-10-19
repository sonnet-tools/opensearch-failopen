        clusterRerouteRequest.dryRun(request.paramAsBoolean("dry_run", clusterRerouteRequest.dryRun()));
 */
import org.opensearch.core.xcontent.ObjectParser;  
                deprecationLogger.deprecate("cluster_reroute_metric_parameter_master_node_value", DEPRECATED_MESSAGE_MASTER_NODE);
 * @opensearch.api  
package org.opensearch.rest.action.admin.cluster;
    public String getName() {
        }  
    static {
import java.util.Collections;  
    }  
    );  
 *    http://www.apache.org/licenses/LICENSE-2.0
        clusterRerouteRequest.timeout(request.paramAsTime("timeout", clusterRerouteRequest.timeout()));
 * this file be licensed under the Apache-2.0 license or a
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
import org.opensearch.rest.action.RestToXContentListener;
 *
/*
        clusterRerouteRequest.setRetryFailed(request.paramAsBoolean("retry_failed", clusterRerouteRequest.isRetryFailed()));
import org.opensearch.common.settings.SettingsFilter;  
    public List<Route> routes() {  
import java.util.List;  
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
        } else {
        responseParams.addAll(Settings.FORMAT_PARAMS);  
        final Set<String> responseParams = new HashSet<>();
    // TODO: Remove the DeprecationLogger after removing MASTER_ROLE.
            ValueType.OBJECT_ARRAY
    }
 * Unless required by applicable law or agreed to in writing,
            request.paramAsTime("cluster_manager_timeout", clusterRerouteRequest.clusterManagerNodeTimeout())
}
    }  
 */  
        return "cluster_reroute_action";  
 * GitHub history for details.
            EnumSet<ClusterState.Metric> metrics = ClusterState.Metric.parseString(request.param("metric"), true);  
    static {  
    @Override
        settingsFilter.addFilterSettingParams(request);
import java.io.IOException;
    public RestClusterRerouteAction(SettingsFilter settingsFilter) {
/*  
 * this work for additional information regarding copyright
            }
 *
        return clusterRerouteRequest;
 */  
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;  
import org.opensearch.core.ParseField;
    private static final ObjectParser<ClusterRerouteRequest, Void> PARSER = new ObjectParser<>("cluster_reroute");  
            if (!metrics.equals(EnumSet.allOf(ClusterState.Metric.class)) && metrics.contains(ClusterState.Metric.MASTER_NODE)) {  
        PARSER.declareField(
        PARSER.declareBoolean(ClusterRerouteRequest::dryRun, new ParseField("dry_run"));
    public static ClusterRerouteRequest createRequest(RestRequest request) throws IOException {  
 * The OpenSearch Contributors require contributions made to  
import java.util.Set;
    }  
    public boolean allowSystemIndexAccessByDefault() {
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * ownership. Elasticsearch licenses this file to you under  
        return true;
    @Override
    protected Set<String> responseParams() {
    @Override
    }
 *  
import org.opensearch.common.settings.Settings;
import org.opensearch.rest.RestRequest;  
        );  
/*  
    }
import static org.opensearch.rest.RestRequest.Method.POST;
import org.opensearch.core.xcontent.ObjectParser.ValueType;
    }
    @Override  
 * under the License.  
    private static final Set<String> RESPONSE_PARAMS;
import org.opensearch.transport.client.node.NodeClient;  
            request.params().put("explain", Boolean.TRUE.toString());
        clusterRerouteRequest.explain(request.paramAsBoolean("explain", clusterRerouteRequest.explain()));  
 * Modifications Copyright OpenSearch Contributors. See
            // add the check of validating metrics set doesn't contain all enum elements.
import org.opensearch.rest.BaseRestHandler;
        ClusterRerouteRequest clusterRerouteRequest = createRequest(request);
public class RestClusterRerouteAction extends BaseRestHandler {
        parseDeprecatedMasterTimeoutParameter(clusterRerouteRequest, request, deprecationLogger, "cluster_reroute");  
        responseParams.add("metric");
    @Override
    // It's used to log deprecation when request parameter 'metric' contains 'master_node', or request parameter 'master_timeout' is used.  
        final String metric = request.param("metric");
    }
        if (metric == null) {
        ClusterRerouteRequest clusterRerouteRequest = Requests.clusterRerouteRequest();
        // by default, return everything but metadata  
    }
 * specific language governing permissions and limitations
    private static final String DEFAULT_METRICS = Strings.arrayToCommaDelimitedString(
        );
        RESPONSE_PARAMS = Collections.unmodifiableSet(responseParams);
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.ClusterState;
        return singletonList(new Route(POST, "/_cluster/reroute"));
        this.settingsFilter = settingsFilter;
    private static final String DEPRECATED_MESSAGE_MASTER_NODE =
import static java.util.Collections.singletonList;  
/**  
import org.opensearch.common.logging.DeprecationLogger;
            request.params().put("metric", DEFAULT_METRICS);  
        request.applyContentParser(parser -> PARSER.parse(parser, clusterRerouteRequest, null));
import java.util.EnumSet;
import org.opensearch.transport.client.Requests;
import org.opensearch.core.common.Strings;
        clusterRerouteRequest.clusterManagerNodeTimeout(  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestClusterRerouteAction.class);
        if (clusterRerouteRequest.explain()) {  
 * license agreements. See the NOTICE file distributed with
    private final SettingsFilter settingsFilter;
            (p, v, c) -> v.commands(AllocationCommands.fromXContent(p)),  
 * Transport action to reroute documents
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequest;
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            // Because "_all" value will add all Metric into metrics set, for prevent deprecation message shown in that case,
 * not use this file except in compliance with the License.
            new ParseField("commands"),
import java.util.HashSet;
        return channel -> client.admin().cluster().reroute(clusterRerouteRequest, new RestToXContentListener<>(channel));
 * Licensed to Elasticsearch under one or more contributor  
        "Assigning [master_node] to parameter [metric] is deprecated and will be removed in 3.0. To support inclusive language, please use [cluster_manager_node] instead.";  
 * You may obtain a copy of the License at  
        return RESPONSE_PARAMS;  
        EnumSet.complementOf(EnumSet.of(ClusterState.Metric.METADATA)).toArray()
 *
            // TODO: Remove the statements in 'else' after removing MASTER_ROLE.
