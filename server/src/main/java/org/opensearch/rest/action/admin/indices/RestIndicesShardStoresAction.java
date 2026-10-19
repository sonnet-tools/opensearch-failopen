 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            });  
/*  
            Strings.splitStringByCommaToArray(request.param("index"))
import org.opensearch.action.admin.indices.shards.IndicesShardStoresAction;
 */  
    @Override
}
    public List<Route> routes() {  
        indicesShardStoresRequest.indicesOptions(IndicesOptions.fromRequest(request, indicesShardStoresRequest.indicesOptions()));
import static java.util.Collections.unmodifiableList;  
import org.opensearch.action.admin.indices.shards.IndicesShardStoresResponse;  
import java.util.List;  
import static org.opensearch.rest.RestRequest.Method.GET;
/*
 * ownership. Elasticsearch licenses this file to you under  
    public String getName() {
 * specific language governing permissions and limitations
 * @opensearch.api
                    builder.endObject();  
 * compatible open source license.
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
            .shardStores(indicesShardStoresRequest, new RestBuilderListener<IndicesShardStoresResponse>(channel) {
    @Override
                    return new BytesRestResponse(OK, builder);
import org.opensearch.action.admin.indices.shards.IndicesShardStoresRequest;
    @Override
        IndicesShardStoresRequest indicesShardStoresRequest = new IndicesShardStoresRequest(
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
                    builder.startObject();
 *  
import org.opensearch.rest.BaseRestHandler;
import org.opensearch.rest.action.RestBuilderListener;
    @Override  
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
        return true;
    }
import java.io.IOException;
        return "indices_shard_stores_action";  
import org.opensearch.transport.client.node.NodeClient;  
import org.opensearch.core.common.Strings;
                public RestResponse buildResponse(IndicesShardStoresResponse response, XContentBuilder builder) throws Exception {  
/*  
import static java.util.Arrays.asList;
        );  
 *
    }
    public boolean allowSystemIndexAccessByDefault() {
 * Licensed to Elasticsearch under one or more contributor  
                    response.toXContent(builder, request);
import org.opensearch.rest.RestResponse;
 * software distributed under the License is distributed on an
    }
 */
package org.opensearch.rest.action.admin.indices;
                @Override
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
            .indices()  
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
        return unmodifiableList(asList(new Route(GET, "/_shard_stores"), new Route(GET, "/{index}/_shard_stores")));
 * KIND, either express or implied.  See the License for the
        return channel -> client.admin()
 * Rest action for {@link IndicesShardStoresAction}
                }
        if (request.hasParam("status")) {
/**
        }  
import org.opensearch.core.xcontent.XContentBuilder;  
    }  
 */  
 * license agreements. See the NOTICE file distributed with
 *  
 *
import org.opensearch.rest.RestRequest;  
import org.opensearch.rest.BytesRestResponse;
import static org.opensearch.core.rest.RestStatus.OK;
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.support.IndicesOptions;
public class RestIndicesShardStoresAction extends BaseRestHandler {  
            indicesShardStoresRequest.shardStatuses(Strings.splitStringByCommaToArray(request.param("status")));
 */
