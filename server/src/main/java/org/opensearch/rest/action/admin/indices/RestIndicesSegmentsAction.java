public class RestIndicesSegmentsAction extends BaseRestHandler {  
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
import org.opensearch.core.common.Strings;  
package org.opensearch.rest.action.admin.indices;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.transport.client.node.NodeClient;
        return unmodifiableList(asList(new Route(GET, "/_segments"), new Route(GET, "/{index}/_segments")));
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
    }
/**
 */
        IndicesSegmentsRequest indicesSegmentsRequest = new IndicesSegmentsRequest(
    }
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequest;
import org.opensearch.rest.BaseRestHandler;
 *  
import java.io.IOException;  
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
 */
 * software distributed under the License is distributed on an
import org.opensearch.action.support.IndicesOptions;
    @Override
 * @opensearch.api
import static org.opensearch.rest.RestRequest.Method.GET;
 * under the License.  
 * license agreements. See the NOTICE file distributed with
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
}  
import org.opensearch.rest.action.RestToXContentListener;  
 */  
 * Transport action to get segment information
        return "indices_segments_action";  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
        return channel -> client.admin().indices().segments(indicesSegmentsRequest, new RestToXContentListener<>(channel));
 *
import java.util.List;
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.rest.RestRequest;
/*  
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
/*  
        indicesSegmentsRequest.indicesOptions(IndicesOptions.fromRequest(request, indicesSegmentsRequest.indicesOptions()));  
    @Override
import static java.util.Arrays.asList;  
 * compatible open source license.
/*
 * Unless required by applicable law or agreed to in writing,
    @Override  
        );
    }
 *  
        indicesSegmentsRequest.verbose(request.paramAsBoolean("verbose", false));
 * KIND, either express or implied.  See the License for the
    public String getName() {
 * this file be licensed under the Apache-2.0 license or a
import static java.util.Collections.unmodifiableList;
            Strings.splitStringByCommaToArray(request.param("index"))  
    public List<Route> routes() {  
