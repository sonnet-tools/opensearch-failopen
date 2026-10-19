 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.rest.action.admin.indices;
            )
            asList(
 * compatible open source license.
import org.opensearch.rest.BaseRestHandler;  
            }  
import static org.opensearch.rest.RestRequest.Method.GET;
    public List<Route> routes() {  
}  
import org.opensearch.transport.client.node.NodeClient;  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.action.support.IndicesOptions;  
 */
 * specific language governing permissions and limitations
        RefreshRequest refreshRequest = new RefreshRequest(Strings.splitStringByCommaToArray(request.param("index")));  
        });
 * software distributed under the License is distributed on an
import org.opensearch.rest.RestRequest;
        refreshRequest.indicesOptions(IndicesOptions.fromRequest(request, refreshRequest.indicesOptions()));
 *  
 * this file be licensed under the Apache-2.0 license or a
 *  
 * GitHub history for details.
    }
import static org.opensearch.rest.RestRequest.Method.POST;
 *
 * KIND, either express or implied.  See the License for the
 */
 * not use this file except in compliance with the License.
    @Override
 * Transport action to refresh
 * license agreements. See the NOTICE file distributed with
    }
 * the Apache License, Version 2.0 (the "License"); you may
                new Route(POST, "/{index}/_refresh")  
                new Route(GET, "/_refresh"),  
            protected RestStatus getStatus(RefreshResponse response) {
 * Modifications Copyright OpenSearch Contributors. See
                new Route(POST, "/_refresh"),
 *    http://www.apache.org/licenses/LICENSE-2.0
import static java.util.Arrays.asList;
        return "refresh_action";
 * Unless required by applicable law or agreed to in writing,
        return unmodifiableList(
import static java.util.Collections.unmodifiableList;  
    }  
/*  
 *
import java.io.IOException;
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
 */  
 * under the License.  
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
/*  
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.api
    public String getName() {  
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
 * You may obtain a copy of the License at  
            @Override  
public class RestRefreshAction extends BaseRestHandler {  
        return channel -> client.admin().indices().refresh(refreshRequest, new RestToXContentListener<RefreshResponse>(channel) {
/**
    @Override
import java.util.List;  
import org.opensearch.core.common.Strings;
    @Override
 */  
import org.opensearch.rest.action.RestToXContentListener;
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                return response.getStatus();
                new Route(GET, "/{index}/_refresh"),
        );
import org.opensearch.core.rest.RestStatus;
