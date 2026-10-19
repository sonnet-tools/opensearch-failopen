    @Override
import org.opensearch.rest.RestRequest;
    }
 * this work for additional information regarding copyright
public class RestCatAction extends BaseRestHandler {  
 * not use this file except in compliance with the License.
    private static final String CAT = "=^.^=";
 * under the License.  
import org.opensearch.rest.BytesRestResponse;  
    }
 * The OpenSearch Contributors require contributions made to  
    }  
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
 */
 * compatible open source license.
package org.opensearch.rest.action.cat;
import java.util.List;
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
        return singletonList(new Route(GET, "/_cat"));
        StringBuilder sb = new StringBuilder();
    private final String HELP;
    @Override  
        HELP = sb.toString();  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
    @Override
/**
 *  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.transport.client.node.NodeClient;
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
        }
 * Unless required by applicable law or agreed to in writing,
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        sb.append(CAT_NL);
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.rest.RestRequest.Method.GET;
    public RestCatAction(List<AbstractCatAction> catActions) {  
import org.opensearch.core.rest.RestStatus;
 * specific language governing permissions and limitations
        for (AbstractCatAction catAction : catActions) {  
 * software distributed under the License is distributed on an
        return "cat_action";
 * @opensearch.api
import org.opensearch.rest.BaseRestHandler;
 */  
        return channel -> channel.sendResponse(new BytesRestResponse(RestStatus.OK, HELP));  
 * Modifications Copyright OpenSearch Contributors. See
    private static final String CAT_NL = CAT + "\n";  
/*
    public List<Route> routes() {
 * GitHub history for details.
 * Base _cat API endpoint
import java.io.IOException;
            catAction.documentation(sb);
}  
 *
 * KIND, either express or implied.  See the License for the
 *  
import static java.util.Collections.singletonList;
/*  
 *
 * You may obtain a copy of the License at  
    public String getName() {  
/*  
 */  
