    public RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        if ("password".equals(request.header("Secret"))) {
    @Override
import org.opensearch.rest.BytesRestResponse;
 * the Apache License, Version 2.0 (the "License"); you may
        } else {  
 */
        }
    public String getName() {
    }
 * this file be licensed under the Apache-2.0 license or a
    @Override
 *
import static java.util.Collections.singletonList;  
import org.opensearch.rest.RestResponse;
 * under the License.  
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
            RestResponse response = new BytesRestResponse(RestStatus.UNAUTHORIZED, "Access denied");
import org.opensearch.core.rest.RestStatus;
 * ownership. Elasticsearch licenses this file to you under  
 */  
 */
 * You may obtain a copy of the License at  
            RestResponse response = new BytesRestResponse(RestStatus.OK, "Access granted");  
 * not use this file except in compliance with the License.
import org.opensearch.rest.RestRequest;  
 * The OpenSearch Contributors require contributions made to  
        return singletonList(new Route(GET, "/_protected"));
}  
            response.addHeader("Secret", "required");
    }
 * Modifications Copyright OpenSearch Contributors. See  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.rest.BaseRestHandler;
            return channel -> channel.sendResponse(response);  
 * SPDX-License-Identifier: Apache-2.0
 *
 * GitHub history for details.
import org.opensearch.transport.client.node.NodeClient;  
package org.opensearch.http;
            response.addHeader("Secret", "granted");
 * compatible open source license.
 * this work for additional information regarding copyright
/*
public class TestResponseHeaderRestAction extends BaseRestHandler {  
 * KIND, either express or implied.  See the License for the
 *  
 * Unless required by applicable law or agreed to in writing,
        return "test_response_header_action";  
/*
 * Licensed to Elasticsearch under one or more contributor  
            return channel -> channel.sendResponse(response);
    public List<Route> routes() {  
/*  
 * license agreements. See the NOTICE file distributed with
    @Override  
import static org.opensearch.rest.RestRequest.Method.GET;
    }
import java.util.List;
