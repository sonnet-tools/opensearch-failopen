 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
}
 * not use this file except in compliance with the License.
        return channel -> client.admin().indices().createDataStream(putDataStreamRequest, new RestToXContentListener<>(channel));  
import org.opensearch.action.admin.indices.datastream.CreateDataStreamAction;  
 * @opensearch.api
import org.opensearch.rest.action.RestToXContentListener;  
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See  
 * Unless required by applicable law or agreed to in writing,
    }
 */  
 * compatible open source license.
    public List<Route> routes() {
/*  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
import java.util.List;
public class RestCreateDataStreamAction extends BaseRestHandler {  
import java.util.Collections;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
/**
import java.io.IOException;  
import org.opensearch.rest.BaseRestHandler;
    @Override
    @Override
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
 * Transport action to create a data stream
 *  
 * under the License.  
/*
/*
 * ownership. Elasticsearch licenses this file to you under  
 *
    public String getName() {  
 *
 * KIND, either express or implied.  See the License for the
 *  
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
 */
 *         http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.transport.client.node.NodeClient;
 * this file be licensed under the Apache-2.0 license or a
        return Collections.singletonList(new Route(RestRequest.Method.PUT, "/_data_stream/{name}"));  
        CreateDataStreamAction.Request putDataStreamRequest = new CreateDataStreamAction.Request(request.param("name"));
 * GitHub history for details.
 */
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.rest.action.admin.indices;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.rest.RestRequest;
        return "create_data_stream_action";
 */
