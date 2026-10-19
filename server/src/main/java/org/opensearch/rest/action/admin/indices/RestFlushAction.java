 * compatible open source license.
import static java.util.Arrays.asList;  
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
 */  
        flushRequest.force(request.paramAsBoolean("force", flushRequest.force()));  
    }  
public class RestFlushAction extends BaseRestHandler {
                new Route(POST, "/{index}/_flush")
import org.opensearch.core.common.Strings;  
 */  
 * not use this file except in compliance with the License.
import java.util.List;
 * specific language governing permissions and limitations
 *
        return "flush_action";
    }
}
        flushRequest.waitIfOngoing(request.paramAsBoolean("wait_if_ongoing", flushRequest.waitIfOngoing()));
import org.opensearch.action.admin.indices.flush.FlushRequest;
import static org.opensearch.rest.RestRequest.Method.POST;  
 * license agreements. See the NOTICE file distributed with
            asList(  
 *    http://www.apache.org/licenses/LICENSE-2.0
            )
        );  
                new Route(GET, "/{index}/_flush"),  
        return channel -> client.admin().indices().flush(flushRequest, new RestToXContentListener<>(channel));
 * You may obtain a copy of the License at  
 */
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
    @Override
import static java.util.Collections.unmodifiableList;
 * this file be licensed under the Apache-2.0 license or a
/**
        flushRequest.indicesOptions(IndicesOptions.fromRequest(request, flushRequest.indicesOptions()));
import org.opensearch.rest.BaseRestHandler;
 * @opensearch.api
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                new Route(GET, "/_flush"),
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
    public String getName() {
package org.opensearch.rest.action.admin.indices;
 * under the License.  
        return unmodifiableList(
import org.opensearch.rest.RestRequest;
 * The OpenSearch Contributors require contributions made to  
        FlushRequest flushRequest = new FlushRequest(Strings.splitStringByCommaToArray(request.param("index")));
 * Unless required by applicable law or agreed to in writing,
/*
import org.opensearch.action.support.IndicesOptions;
import org.opensearch.transport.client.node.NodeClient;
/*  
 *
 * KIND, either express or implied.  See the License for the
/*  
    @Override  
 * Modifications Copyright OpenSearch Contributors. See
 *
import java.io.IOException;  
 * Transport action to flush  
                new Route(POST, "/_flush"),
    public List<Route> routes() {
 *  
import org.opensearch.rest.action.RestToXContentListener;  
 * Licensed to Elasticsearch under one or more contributor  
    @Override  
 */  
import static org.opensearch.rest.RestRequest.Method.GET;
    }  
