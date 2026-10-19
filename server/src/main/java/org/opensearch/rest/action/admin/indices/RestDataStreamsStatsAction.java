/**
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 *  
 * ownership. Elasticsearch licenses this file to you under  
        dataStreamsStatsRequest.indices(Strings.splitStringByCommaToArray(request.param("name")));  
            new Route(RestRequest.Method.GET, "/_data_stream/{name}/_stats")
    @Override
 * compatible open source license.
    public String getName() {
import org.opensearch.rest.action.RestToXContentListener;  
 * this file be licensed under the Apache-2.0 license or a
    }  
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
import org.opensearch.action.admin.indices.datastream.DataStreamsStatsAction;
import org.opensearch.rest.BaseRestHandler;
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
import java.io.IOException;  
    @Override  
        assert dataStreamsStatsRequest.indicesOptions() == IndicesOptions.strictExpandOpenAndForbidClosed() : "DataStreamStats default "  
}  
/*  
        dataStreamsStatsRequest.indicesOptions(IndicesOptions.fromRequest(request, defaultIndicesOption));
            + "indices options changed";
        return "data_stream_stats_action";  
    @Override
 */
import org.opensearch.core.common.Strings;  
    }
 * under the License.  
            new Route(RestRequest.Method.GET, "/_data_stream/_stats"),  
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
 */  
 *  
 * this work for additional information regarding copyright
        boolean forbidClosedIndices = request.paramAsBoolean("forbid_closed_indices", true);
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
public class RestDataStreamsStatsAction extends BaseRestHandler {  
import org.opensearch.action.support.IndicesOptions;
package org.opensearch.rest.action.admin.indices;
    public List<Route> routes() {
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * Transport action to get data stream stats
        DataStreamsStatsAction.Request dataStreamsStatsRequest = new DataStreamsStatsAction.Request();
 */
/*
        IndicesOptions defaultIndicesOption = forbidClosedIndices  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            ? dataStreamsStatsRequest.indicesOptions()
import java.util.Arrays;
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.api
import java.util.List;
    }
        return channel -> client.execute(DataStreamsStatsAction.INSTANCE, dataStreamsStatsRequest, new RestToXContentListener<>(channel));
import org.opensearch.rest.RestRequest;
            : IndicesOptions.strictExpandOpen();
 * not use this file except in compliance with the License.
        );
import org.opensearch.transport.client.node.NodeClient;
 * license agreements. See the NOTICE file distributed with
 *
        return Arrays.asList(
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {  
