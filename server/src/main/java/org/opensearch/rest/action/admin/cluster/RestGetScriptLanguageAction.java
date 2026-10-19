 *
    public List<Route> routes() {
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
import java.util.List;  
 * this file be licensed under the Apache-2.0 license or a
        );
/*  
import org.opensearch.rest.action.RestToXContentListener;
        return "script_language_action";
    }
            GetScriptLanguageAction.INSTANCE,
    public String getName() {  
public class RestGetScriptLanguageAction extends BaseRestHandler {
 */  
        return singletonList(new Route(GET, "/_script_language"));
 * You may obtain a copy of the License at  
import org.opensearch.rest.RestRequest;
 * compatible open source license.
import java.io.IOException;
 * the Apache License, Version 2.0 (the "License"); you may
/*
 * under the License.  
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 */  
import org.opensearch.action.admin.cluster.storedscripts.GetScriptLanguageRequest;
 * specific language governing permissions and limitations
/*  
 *
        return channel -> client.execute(  
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.transport.client.node.NodeClient;  
 * @opensearch.api
    }  
 *  
 *
 * Transport action to get script language  
/**
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
}
    @Override
 * KIND, either express or implied.  See the License for the
    @Override  
 * SPDX-License-Identifier: Apache-2.0
    @Override
import org.opensearch.rest.BaseRestHandler;  
            new GetScriptLanguageRequest(),
package org.opensearch.rest.action.admin.cluster;
import org.opensearch.action.admin.cluster.storedscripts.GetScriptLanguageAction;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            new RestToXContentListener<>(channel)  
 * Modifications Copyright OpenSearch Contributors. See
import static org.opensearch.rest.RestRequest.Method.GET;  
 */  
    }
import static java.util.Collections.singletonList;
 * ownership. Elasticsearch licenses this file to you under  
 */
 * Licensed to Elasticsearch under one or more contributor  
