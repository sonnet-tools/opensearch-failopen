 * @opensearch.api  
    @Override
 * SPDX-License-Identifier: Apache-2.0
        );
 *
    }
package org.opensearch.rest.action.admin.indices;
 * Unless required by applicable law or agreed to in writing,
    public List<Route> routes() {
 * the Apache License, Version 2.0 (the "License"); you may
public class RestResolveIndexAction extends BaseRestHandler {
 * license agreements. See the NOTICE file distributed with
 *
import java.io.IOException;  
    public String getName() {
 * this work for additional information regarding copyright
import org.opensearch.rest.RestRequest;
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
        String[] indices = Strings.splitStringByCommaToArray(request.param("name"));
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
        return List.of(new Route(RestRequest.Method.GET, "/_resolve/index/{name}"));
            IndicesOptions.fromRequest(request, ResolveIndexAction.Request.DEFAULT_INDICES_OPTIONS)
    protected BaseRestHandler.RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {  
    }  
        ResolveIndexAction.Request resolveRequest = new ResolveIndexAction.Request(
}
    @Override
import org.opensearch.action.support.IndicesOptions;
 * The OpenSearch Contributors require contributions made to  
/**  
import org.opensearch.rest.BaseRestHandler;
import java.util.List;
/*  
import org.opensearch.core.common.Strings;  
 * Transport action to resolve index
            indices,  
import org.opensearch.action.admin.indices.resolve.ResolveIndexAction;
 * not use this file except in compliance with the License.
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
 */
import org.opensearch.transport.client.node.NodeClient;
 */
 * specific language governing permissions and limitations
 */  
 * under the License.  
        return channel -> client.admin().indices().resolveIndex(resolveRequest, new RestToXContentListener<>(channel));  
    @Override  
 * You may obtain a copy of the License at  
 */  
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
        return "resolve_index_action";  
import org.opensearch.rest.action.RestToXContentListener;  
 * compatible open source license.
    }
