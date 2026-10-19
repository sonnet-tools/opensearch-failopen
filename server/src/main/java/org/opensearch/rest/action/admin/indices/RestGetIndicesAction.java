    @Override
import org.opensearch.rest.RestRequest;
        getIndexRequest.indices(indices);
 * this file be licensed under the Apache-2.0 license or a
 */  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestGetIndicesAction.class);  
 * The REST handler for get index and head index APIs.  
/**
     */
import org.opensearch.rest.BaseRestHandler;  
}  
        getIndexRequest.indicesOptions(IndicesOptions.fromRequest(request, getIndexRequest.indicesOptions()));
 * Licensed to Elasticsearch under one or more contributor  
    }
 * SPDX-License-Identifier: Apache-2.0
        parseDeprecatedMasterTimeoutParameter(getIndexRequest, request, deprecationLogger, getName());
        getIndexRequest.local(request.paramAsBoolean("local", getIndexRequest.local()));  
import static org.opensearch.rest.RestRequest.Method.GET;
import org.opensearch.common.logging.DeprecationLogger;  
     * preparation of the request execution in {@link BaseRestHandler#prepareRequest(RestRequest, NodeClient)}.  
import java.util.Set;
 * ownership. Elasticsearch licenses this file to you under  
    @Override
 *
        getIndexRequest.includeDefaults(request.paramAsBoolean("include_defaults", false));  
import org.opensearch.rest.action.RestToXContentListener;
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
    }
import static java.util.Arrays.asList;  
        return "get_indices_action";  
     * Parameters used for controlling the response and thus might not be consumed during
    public String getName() {
/*  
        final GetIndexRequest getIndexRequest = new GetIndexRequest();  
    @Override
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.Strings;
        return Settings.FORMAT_PARAMS;
    /**
 *
import java.util.List;  
        getIndexRequest.humanReadable(request.paramAsBoolean("human", false));
 * KIND, either express or implied.  See the License for the
import static java.util.Collections.unmodifiableList;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.admin.indices.get.GetIndexRequest;
import org.opensearch.transport.client.node.NodeClient;  
 * not use this file except in compliance with the License.
    @Override  
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
import static org.opensearch.rest.RestRequest.Method.HEAD;  
 * specific language governing permissions and limitations
        return unmodifiableList(asList(new Route(GET, "/{index}"), new Route(HEAD, "/{index}")));
 * Unless required by applicable law or agreed to in writing,
 */  
import java.io.IOException;
import org.opensearch.common.settings.Settings;
    protected Set<String> responseParams() {  
    }
/*  
 * The OpenSearch Contributors require contributions made to  
 *  
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
    public List<Route> routes() {  
 * GitHub history for details.
        return channel -> client.admin().indices().getIndex(getIndexRequest, new RestToXContentListener<>(channel));
        );  
 */
    }
 */  
public class RestGetIndicesAction extends BaseRestHandler {
 *
            request.paramAsTime("cluster_manager_timeout", getIndexRequest.clusterManagerNodeTimeout())
 * @opensearch.api
import org.opensearch.action.support.IndicesOptions;
 * Modifications Copyright OpenSearch Contributors. See
/*
        getIndexRequest.clusterManagerNodeTimeout(
 * this work for additional information regarding copyright
        String[] indices = Strings.splitStringByCommaToArray(request.param("index"));
package org.opensearch.rest.action.admin.indices;
