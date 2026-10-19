 */
 * GitHub history for details.
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.rest.RestRequest;
 *
    public List<Route> routes() {  
import java.util.List;
        return channel -> client.execute(RemoteInfoAction.INSTANCE, new RemoteInfoRequest(), new RestToXContentListener<>(channel));
/*  
    @Override
import org.opensearch.rest.action.RestToXContentListener;
    }  
import org.opensearch.action.admin.cluster.remote.RemoteInfoRequest;
    @Override
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
 *  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.rest.action.admin.cluster;
 * @opensearch.api
    }
 */
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
    public String getName() {
public final class RestRemoteClusterInfoAction extends BaseRestHandler {  
 * ownership. Elasticsearch licenses this file to you under  
 * Transport action to get remote cluster information
import org.opensearch.rest.BaseRestHandler;  
/*  
    }
        return "remote_cluster_info_action";  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) {
 * license agreements. See the NOTICE file distributed with
        return singletonList(new Route(GET, "/_remote/info"));
 * not use this file except in compliance with the License.
 *  
 * KIND, either express or implied.  See the License for the
 */  
}  
import org.opensearch.transport.client.node.NodeClient;  
 * specific language governing permissions and limitations
        return false;
    @Override
import static org.opensearch.rest.RestRequest.Method.GET;
 * compatible open source license.
import static java.util.Collections.singletonList;
 * Licensed to Elasticsearch under one or more contributor  
 *
 * Modifications Copyright OpenSearch Contributors. See
/*
    public boolean canTripCircuitBreaker() {  
import org.opensearch.action.admin.cluster.remote.RemoteInfoAction;
/**
 */  
