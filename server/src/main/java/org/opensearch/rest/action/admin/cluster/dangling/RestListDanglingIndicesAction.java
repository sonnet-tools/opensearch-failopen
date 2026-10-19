        return singletonList(new Route(GET, "/_dangling"));  
 * this file be licensed under the Apache-2.0 license or a
 *  
import org.opensearch.rest.RestRequest;  
/**
    @Override
 * under the License.  
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesRequest;
 * compatible open source license.
 *  
 * Modifications Copyright OpenSearch Contributors. See
            .listDanglingIndices(danglingIndicesRequest, new RestActions.NodesResponseRestListener<>(channel));
import org.opensearch.rest.action.RestActions;
import java.io.IOException;
public class RestListDanglingIndicesAction extends BaseRestHandler {  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.transport.client.node.NodeClient;
 * Transport action to list dangling index
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
import static org.opensearch.rest.RestRequest.Method.GET;
 * KIND, either express or implied.  See the License for the
package org.opensearch.rest.action.admin.cluster.dangling;
 * specific language governing permissions and limitations
        return "list_dangling_indices";
 * SPDX-License-Identifier: Apache-2.0
    public BaseRestHandler.RestChannelConsumer prepareRequest(final RestRequest request, NodeClient client) throws IOException {  
 */  
        final ListDanglingIndicesRequest danglingIndicesRequest = new ListDanglingIndicesRequest();
    }
            .cluster()  
import static java.util.Collections.singletonList;
        return channel -> client.admin()
 */
    public String getName() {
 *
    }
}  
 * @opensearch.api
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 *
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
    @Override  
 */
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
/*
 * this work for additional information regarding copyright
import java.util.List;
 * Unless required by applicable law or agreed to in writing,
    public List<Route> routes() {
/*  
import org.opensearch.rest.BaseRestHandler;
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
