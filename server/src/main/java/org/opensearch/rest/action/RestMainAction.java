    static BytesRestResponse convertMainResponse(MainResponse response, RestRequest request, XContentBuilder builder) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static java.util.Collections.unmodifiableList;
import java.io.IOException;  
import org.opensearch.rest.BaseRestHandler;  
            @Override
 * license agreements. See the NOTICE file distributed with
    @Override
 */  
 * GitHub history for details.
        // Default to pretty printing, but allow ?pretty=false to disable  
import org.opensearch.action.main.MainResponse;  
    }  
            public RestResponse buildResponse(MainResponse mainResponse, XContentBuilder builder) throws Exception {
 * ownership. Elasticsearch licenses this file to you under  
 *  
 * under the License.  
        return false;
    public boolean canTripCircuitBreaker() {  
package org.opensearch.rest.action;
 * Modifications Copyright OpenSearch Contributors. See
        return unmodifiableList(asList(new Route(GET, "/"), new Route(HEAD, "/")));
 *
    public List<Route> routes() {
            }
        if (request.hasParam("pretty") == false) {
 */
public class RestMainAction extends BaseRestHandler {
/*
import java.util.List;
 * You may obtain a copy of the License at  
        response.toXContent(builder, request);
                return convertMainResponse(mainResponse, request, builder);  
    }  
 * this work for additional information regarding copyright
import org.opensearch.action.main.MainRequest;
import static org.opensearch.rest.RestRequest.Method.GET;
    @Override
/*  
import static org.opensearch.rest.RestRequest.Method.HEAD;  
        return channel -> client.execute(MainAction.INSTANCE, new MainRequest(), new RestBuilderListener<MainResponse>(channel) {  
import org.opensearch.rest.RestRequest;
    }
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
import org.opensearch.rest.RestResponse;  
    }
 * @opensearch.api
import org.opensearch.transport.client.node.NodeClient;
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.main.MainAction;
/**
/*  
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.XContentBuilder;
 * software distributed under the License is distributed on an
 * Main OpenSearch Transport action  
 * The OpenSearch Contributors require contributions made to  
        });
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
    }  
 *
 */  
 * this file be licensed under the Apache-2.0 license or a
        }  
}  
    @Override  
import static java.util.Arrays.asList;  
    @Override
import org.opensearch.rest.BytesRestResponse;
    public String getName() {  
        return "main_action";
 *
 * compatible open source license.
import org.opensearch.core.rest.RestStatus;
            builder.prettyPrint().lfAtEnd();
 * not use this file except in compliance with the License.
 */  
        return new BytesRestResponse(RestStatus.OK, builder);
