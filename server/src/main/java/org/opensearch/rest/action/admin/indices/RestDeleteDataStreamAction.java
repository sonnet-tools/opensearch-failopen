 * You may obtain a copy of the License at  
 *
 */
 * not use this file except in compliance with the License.
/*
    }
package org.opensearch.rest.action.admin.indices;
/*
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
    public String getName() {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.rest.action.RestToXContentListener;
    @Override
import java.io.IOException;
 * GitHub history for details.
        return Collections.singletonList(new Route(RestRequest.Method.DELETE, "/_data_stream/{name}"));
 * Licensed to Elasticsearch under one or more contributor  
    @Override  
    }
    @Override
 * ownership. Elasticsearch licenses this file to you under  
/*  
/**
            Strings.splitStringByCommaToArray(request.param("name"))
 * this file be licensed under the Apache-2.0 license or a
    public List<Route> routes() {  
        return channel -> client.admin().indices().deleteDataStream(deleteDataStreamRequest, new RestToXContentListener<>(channel));  
 * KIND, either express or implied.  See the License for the
 */  
public class RestDeleteDataStreamAction extends BaseRestHandler {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
import org.opensearch.rest.RestRequest;  
 * Unless required by applicable law or agreed to in writing,
 *         http://www.apache.org/licenses/LICENSE-2.0
 *  
import org.opensearch.core.common.Strings;
import org.opensearch.action.admin.indices.datastream.DeleteDataStreamAction;  
        );
        DeleteDataStreamAction.Request deleteDataStreamRequest = new DeleteDataStreamAction.Request(  
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
import org.opensearch.transport.client.node.NodeClient;
}
 *
 * under the License.  
 * compatible open source license.
 */
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
import java.util.Collections;
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See  
import java.util.List;  
        return "delete_data_stream_action";
    }  
import org.opensearch.rest.BaseRestHandler;
 * Transport action to delete data stream  
 */  
 * @opensearch.api
