        }  
 * GitHub history for details.
 */
 *
 * KIND, either express or implied.  See the License for the
public class RestClearVotingConfigExclusionsAction extends BaseRestHandler {
        return channel -> client.execute(ClearVotingConfigExclusionsAction.INSTANCE, req, new RestToXContentListener<>(channel));
 * @opensearch.api
 * You may obtain a copy of the License at  
import org.opensearch.rest.action.RestToXContentListener;
import java.io.IOException;
        ClearVotingConfigExclusionsRequest req = new ClearVotingConfigExclusionsRequest();  
/*  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
/*
import java.util.List;  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.rest.action.admin.cluster;
        return singletonList(new Route(DELETE, "/_cluster/voting_config_exclusions"));
    }
    }
 * compatible open source license.
import org.opensearch.action.admin.cluster.configuration.ClearVotingConfigExclusionsAction;
import static java.util.Collections.singletonList;
 * the Apache License, Version 2.0 (the "License"); you may
}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
import org.opensearch.rest.RestRequest;
 *  
 */  
 *
 * not use this file except in compliance with the License.
            req.setWaitForRemoval(request.paramAsBoolean("wait_for_removal", true));
    @Override
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
    protected RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
 * Transport action to clear voting config exclusions  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.admin.cluster.configuration.ClearVotingConfigExclusionsRequest;
 * Modifications Copyright OpenSearch Contributors. See
 */  
import static org.opensearch.rest.RestRequest.Method.DELETE;  
    }  
 * The OpenSearch Contributors require contributions made to  
    @Override  
 * this work for additional information regarding copyright
    public String getName() {  
    @Override
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
 *
import org.opensearch.transport.client.node.NodeClient;  
/**
        if (request.hasParam("wait_for_removal")) {
    public List<Route> routes() {
/*  
import org.opensearch.rest.BaseRestHandler;  
        return "clear_voting_config_exclusions_action";
