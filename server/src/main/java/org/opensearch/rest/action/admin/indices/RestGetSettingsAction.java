    }  
public class RestGetSettingsAction extends BaseRestHandler {
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestGetSettingsAction.class);  
    @Override
 *
        return unmodifiableList(
        );  
 * compatible open source license.
            asList(
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
 * specific language governing permissions and limitations
    }
        getSettingsRequest.local(request.paramAsBoolean("local", getSettingsRequest.local()));
        return channel -> client.admin().indices().getSettings(getSettingsRequest, new RestToXContentListener<>(channel));  
            .humanReadable(request.hasParam("human"))
        );
/*  
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
import java.util.List;
                new Route(GET, "/_settings"),  
 *    http://www.apache.org/licenses/LICENSE-2.0
import static java.util.Collections.unmodifiableList;
 * software distributed under the License is distributed on an
    @Override
    @Override  
import org.opensearch.rest.BaseRestHandler;
 */
 * this file be licensed under the Apache-2.0 license or a
                new Route(GET, "/{index}/_settings"),
 * not use this file except in compliance with the License.
 *
        // This is required so the "flat_settings" parameter counts as consumed  
 * this work for additional information regarding copyright
/*  
            .names(names);  
        request.paramAsBoolean("flat_settings", false);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.support.IndicesOptions;
import static java.util.Arrays.asList;
 */  
        return "get_settings_action";
            )
        getSettingsRequest.clusterManagerNodeTimeout(
            request.paramAsTime("cluster_manager_timeout", getSettingsRequest.clusterManagerNodeTimeout())  
 * GitHub history for details.
 * You may obtain a copy of the License at  
/*
        final String[] names = request.paramAsStringArrayOrEmptyIfAll("name");
            .indicesOptions(IndicesOptions.fromRequest(request, IndicesOptions.strictExpandOpen()))  
}
 *  
import org.opensearch.core.common.Strings;
                new Route(GET, "/{index}/_settings/{name}"),  
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;
 * Modifications Copyright OpenSearch Contributors. See
 */  
        final boolean renderDefaults = request.paramAsBoolean("include_defaults", false);
 * Transport action to get settings  
import org.opensearch.rest.RestRequest;  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                new Route(GET, "/{index}/_setting/{name}")
 */  
 * under the License.  
import static org.opensearch.rest.RestRequest.Method.GET;  
 * the Apache License, Version 2.0 (the "License"); you may
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
package org.opensearch.rest.action.admin.indices;
/**
import org.opensearch.common.logging.DeprecationLogger;  
                new Route(GET, "/_settings/{name}"),
import org.opensearch.transport.client.node.NodeClient;
        parseDeprecatedMasterTimeoutParameter(getSettingsRequest, request, deprecationLogger, getName());
import org.opensearch.rest.action.RestToXContentListener;
    }
        GetSettingsRequest getSettingsRequest = new GetSettingsRequest().indices(Strings.splitStringByCommaToArray(request.param("index")))
    public List<Route> routes() {  
 * @opensearch.api
    public String getName() {
            .includeDefaults(renderDefaults)
 *
