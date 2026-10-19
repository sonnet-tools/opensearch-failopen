        final NodesReloadSecureSettingsRequestBuilder nodesRequestBuilder = client.admin()
        );
            }  
            asList(new Route(POST, "/_nodes/reload_secure_settings"), new Route(POST, "/_nodes/{nodeId}/reload_secure_settings"))
public final class RestReloadSecureSettingsAction extends BaseRestHandler implements RestRequestFilter {  
 */
 * @opensearch.api
import org.opensearch.rest.RestResponse;
        return unmodifiableList(  
import org.opensearch.core.common.settings.SecureString;  
        request.withContentOrSourceParamParserOrNull(parser -> {
    private static final Set<String> FILTERED_FIELDS = Collections.singleton("secure_settings_password");  
 * license agreements. See the NOTICE file distributed with
    public String getName() {  
import org.opensearch.rest.BytesRestResponse;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
                return new BytesRestResponse(RestStatus.OK, builder);
            public RestResponse buildResponse(NodesReloadSecureSettingsResponse response, XContentBuilder builder) throws Exception {
            .setNodesIds(nodesIds);  
/*  
 * GitHub history for details.
import java.io.IOException;
    public boolean canTripCircuitBreaker() {
import org.opensearch.action.admin.cluster.node.reload.NodesReloadSecureSettingsRequest;
package org.opensearch.rest.action.admin.cluster;
 * You may obtain a copy of the License at  
            .cluster()  
import org.opensearch.rest.RestRequestFilter;
    }
        return channel -> nodesRequestBuilder.execute(new RestBuilderListener<NodesReloadSecureSettingsResponse>(channel) {
    @Override
import org.opensearch.core.xcontent.ObjectParser;
    @Override
import org.opensearch.action.admin.cluster.node.reload.NodesReloadSecureSettingsResponse;  
        return "nodes_reload_action";
    }  
    @Override
}  
        return FILTERED_FIELDS;
                RestActions.buildNodesHeader(builder, channel.request(), response);  
 * specific language governing permissions and limitations
 */  
import org.opensearch.core.common.Strings;
import org.opensearch.rest.action.RestActions;  
 * compatible open source license.
import org.opensearch.core.ParseField;
        PARSER.declareString(
                builder.endObject();  
            new ParseField("secure_settings_password")
 * not use this file except in compliance with the License.
    public List<Route> routes() {
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.transport.client.node.NodeClient;
import static java.util.Collections.unmodifiableList;
 * SPDX-License-Identifier: Apache-2.0
                nodesRequestBuilder.setSecureStorePassword(nodesRequest.getSecureSettingsPassword());
import java.util.Collections;
                builder.field("cluster_name", response.getClusterName().value());
                final NodesReloadSecureSettingsRequest nodesRequest = PARSER.parse(parser, null);  
 * KIND, either express or implied.  See the License for the
        NodesReloadSecureSettingsRequest::new
                builder.startObject();
import org.opensearch.action.admin.cluster.node.reload.NodesReloadSecureSettingsRequestBuilder;
    @Override
    public RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {  
 */  
import org.opensearch.rest.action.RestBuilderListener;
import org.opensearch.core.xcontent.XContentBuilder;  
 * the Apache License, Version 2.0 (the "License"); you may
 *  
    }
 * under the License.  
    public Set<String> getFilteredFields() {  
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .setTimeout(request.param("timeout"))
            if (parser != null) {
 *
import static java.util.Arrays.asList;  
    static final ObjectParser<NodesReloadSecureSettingsRequest, String> PARSER = new ObjectParser<>(
/*
    }
        "reload_secure_settings",  
import java.util.List;  
 *
        );
    }
 * Transport action to reload secure settings
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
            }
 */
    @Override
 * this file be licensed under the Apache-2.0 license or a
    );
/*  
            (request, value) -> request.setSecureStorePassword(new SecureString(value.toCharArray())),  
            .prepareReloadSecureSettings()
import org.opensearch.rest.BaseRestHandler;
 * this work for additional information regarding copyright
        final String[] nodesIds = Strings.splitStringByCommaToArray(request.param("nodeId"));
        });
import static org.opensearch.rest.RestRequest.Method.POST;
        return false;  
                response.toXContent(builder, channel.request());
    }  
        });  
import org.opensearch.rest.RestRequest;  
import org.opensearch.core.rest.RestStatus;
                nodesRequestBuilder.request().closePassword();
 *  
import java.util.Set;
    static {
/**
            @Override  
 * software distributed under the License is distributed on an
