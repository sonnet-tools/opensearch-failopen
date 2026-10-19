 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
            request.paramAsTime("cluster_manager_timeout", getRepositoriesRequest.clusterManagerNodeTimeout())
    @Override
    @Override
import java.io.IOException;
    public String getName() {  
 */
import org.opensearch.core.common.Strings;
import org.opensearch.common.settings.Settings;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected Set<String> responseParams() {
/*  
        settingsFilter.addFilterSettingParams(request);  
 *
package org.opensearch.rest.action.admin.cluster;
import org.opensearch.common.logging.DeprecationLogger;
import org.opensearch.rest.action.RestToXContentListener;
import org.opensearch.transport.client.node.NodeClient;  
 * software distributed under the License is distributed on an
 */  
    }
    private final SettingsFilter settingsFilter;
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
        return "get_repositories_action";
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static java.util.Collections.unmodifiableList;
 *  
import org.opensearch.common.settings.SettingsFilter;
        );  
    }
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
import static org.opensearch.rest.RestRequest.Method.GET;
/*
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 *
        parseDeprecatedMasterTimeoutParameter(getRepositoriesRequest, request, deprecationLogger, getName());
 * Returns repository information  
public class RestGetRepositoriesAction extends BaseRestHandler {
 * @opensearch.api
    @Override  
        getRepositoriesRequest.clusterManagerNodeTimeout(
 * specific language governing permissions and limitations
        return channel -> client.admin().cluster().getRepositories(getRepositoriesRequest, new RestToXContentListener<>(channel));
        this.settingsFilter = settingsFilter;
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
import org.opensearch.rest.BaseRestHandler;  
 * Unless required by applicable law or agreed to in writing,
        GetRepositoriesRequest getRepositoriesRequest = getRepositoryRequest(repositories);  
 *
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
import static java.util.Arrays.asList;  
 */  
    public List<Route> routes() {
 * SPDX-License-Identifier: Apache-2.0
        getRepositoriesRequest.local(request.paramAsBoolean("local", getRepositoriesRequest.local()));
import java.util.List;  
 * the Apache License, Version 2.0 (the "License"); you may
        return Settings.FORMAT_PARAMS;  
 * not use this file except in compliance with the License.
        return unmodifiableList(asList(new Route(GET, "/_snapshot"), new Route(GET, "/_snapshot/{repository}")));  
/**
    }
 */  
        final String[] repositories = request.paramAsStringArray("repository", Strings.EMPTY_ARRAY);
    public RestGetRepositoriesAction(SettingsFilter settingsFilter) {
import static org.opensearch.transport.client.Requests.getRepositoryRequest;  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestGetRepositoriesAction.class);  
import org.opensearch.rest.RestRequest;
    }
 * GitHub history for details.
}  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Set;
    }  
    @Override
