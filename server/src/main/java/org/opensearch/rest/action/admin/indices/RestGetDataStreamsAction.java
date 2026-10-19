 *  
 */
/*
 * Unless required by applicable law or agreed to in writing,
    @Override
 * this file be licensed under the Apache-2.0 license or a
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
 */  
import java.util.List;
package org.opensearch.rest.action.admin.indices;
 *  
 * Modifications Copyright OpenSearch Contributors. See  
 * Transport action to get data streams
}
 *
 * software distributed under the License is distributed on an
 * @opensearch.api
    }
import org.opensearch.transport.client.node.NodeClient;
        return List.of(new Route(RestRequest.Method.GET, "/_data_stream"), new Route(RestRequest.Method.GET, "/_data_stream/{name}"));  
 * SPDX-License-Identifier: Apache-2.0
        return "get_data_streams_action";
        );
    @Override
import org.opensearch.core.common.Strings;
 * KIND, either express or implied.  See the License for the
 *
        GetDataStreamAction.Request getDataStreamsRequest = new GetDataStreamAction.Request(
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.rest.action.RestToXContentListener;
 * this work for additional information regarding copyright
/*
    }  
    @Override  
/**
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class RestGetDataStreamsAction extends BaseRestHandler {  
/*  
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.admin.indices.datastream.GetDataStreamAction;  
 * The OpenSearch Contributors require contributions made to  
 *         http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.rest.RestRequest;  
 * compatible open source license.
 * under the License.  
 * You may obtain a copy of the License at  
        return channel -> client.admin().indices().getDataStreams(getDataStreamsRequest, new RestToXContentListener<>(channel));
 */
    }
import java.io.IOException;
    public List<Route> routes() {
    public String getName() {  
import org.opensearch.rest.BaseRestHandler;
 * specific language governing permissions and limitations
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
            Strings.splitStringByCommaToArray(request.param("name"))  
