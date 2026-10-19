    public String getName() {  
        );  
import java.io.IOException;
        closeIndexRequest.timeout(request.paramAsTime("timeout", closeIndexRequest.timeout()));
import org.opensearch.action.support.ActiveShardCount;
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
 */
 * not use this file except in compliance with the License.
import org.opensearch.common.logging.DeprecationLogger;
/*  
        CloseIndexRequest closeIndexRequest = new CloseIndexRequest(Strings.splitStringByCommaToArray(request.param("index")));  
 *  
        closeIndexRequest.clusterManagerNodeTimeout(
}
import org.opensearch.rest.action.RestToXContentListener;
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestCloseIndexAction.class);
        closeIndexRequest.indicesOptions(IndicesOptions.fromRequest(request, closeIndexRequest.indicesOptions()));  
/**  
 * this work for additional information regarding copyright
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
 * Transport action to close index
 * You may obtain a copy of the License at  
/*  
import org.opensearch.action.admin.indices.close.CloseIndexRequest;
import org.opensearch.rest.BaseRestHandler;  
    }
 * @opensearch.api  
        return "close_index_action";
 * specific language governing permissions and limitations
        parseDeprecatedMasterTimeoutParameter(closeIndexRequest, request, deprecationLogger, getName());
        return channel -> client.admin().indices().close(closeIndexRequest, new RestToXContentListener<>(channel));
    @Override  
import org.opensearch.transport.client.node.NodeClient;  
package org.opensearch.rest.action.admin.indices;
        if (waitForActiveShards != null) {
        String waitForActiveShards = request.param("wait_for_active_shards");
 */  
 * KIND, either express or implied.  See the License for the
        }
 * ownership. Elasticsearch licenses this file to you under  
import static java.util.Arrays.asList;
    public List<Route> routes() {
import static java.util.Collections.unmodifiableList;  
 * GitHub history for details.
 *
    @Override
 * Modifications Copyright OpenSearch Contributors. See
    }  
 * license agreements. See the NOTICE file distributed with
    @Override
 *
    }  
import static org.opensearch.rest.RestRequest.Method.POST;
import org.opensearch.rest.RestRequest;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
/*
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
public class RestCloseIndexAction extends BaseRestHandler {
 * the Apache License, Version 2.0 (the "License"); you may
 *
        return unmodifiableList(asList(new Route(POST, "/_close"), new Route(POST, "/{index}/_close")));
import org.opensearch.action.support.IndicesOptions;  
            closeIndexRequest.waitForActiveShards(ActiveShardCount.parseString(waitForActiveShards));  
 */
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
import java.util.List;  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.Strings;
 * Unless required by applicable law or agreed to in writing,
            request.paramAsTime("cluster_manager_timeout", closeIndexRequest.clusterManagerNodeTimeout())
