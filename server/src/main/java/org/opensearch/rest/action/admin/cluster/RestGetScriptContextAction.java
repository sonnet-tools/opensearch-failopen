 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
            new GetScriptContextRequest(),
/*  
import org.opensearch.action.admin.cluster.storedscripts.GetScriptContextRequest;
    public String getName() {  
 * Transport action to get script context  
import static org.opensearch.rest.RestRequest.Method.GET;  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
/**
 * Unless required by applicable law or agreed to in writing,
 */
import static java.util.Collections.singletonList;
import org.opensearch.transport.client.node.NodeClient;  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.admin.cluster.storedscripts.GetScriptContextAction;
/*  
 * The OpenSearch Contributors require contributions made to  
}  
 * GitHub history for details.
        return channel -> client.execute(  
 * @opensearch.api
import java.util.List;  
    @Override
 * under the License.  
        );
 * this work for additional information regarding copyright
import org.opensearch.rest.BaseRestHandler;  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
        return "script_context_action";
 * specific language governing permissions and limitations
package org.opensearch.rest.action.admin.cluster;
    @Override
import org.opensearch.rest.RestRequest;
            new RestToXContentListener<>(channel)  
 *  
/*
public class RestGetScriptContextAction extends BaseRestHandler {
 *
    }  
 *
 * compatible open source license.
    }
import java.io.IOException;
import org.opensearch.rest.action.RestToXContentListener;
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
        return singletonList(new Route(GET, "/_script_context"));
 */  
 *
 * You may obtain a copy of the License at  
            GetScriptContextAction.INSTANCE,
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
 */  
 * not use this file except in compliance with the License.
    public List<Route> routes() {
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
