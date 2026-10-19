        DEPRECATION_LOGGER.deprecate(
            builder.startObject("_shards");
        @Override
 * under the License.  
import org.opensearch.transport.client.node.NodeClient;
            "synced_flush",
 * KIND, either express or implied.  See the License for the
        }
            asList(  
        private void buildSyncedFlushResponse(XContentBuilder builder, FlushResponse flushResponse) throws IOException {
import java.util.List;
            // can't serialize the detail of each index as we don't have the shard count per index.  
        return channel -> client.admin().indices().flush(flushRequest, new SimulateSyncedFlushResponseListener(channel));
    public String getName() {
                new Route(POST, "/_flush/synced"),
    @Override  
import static org.opensearch.rest.RestRequest.Method.GET;  
 */  
 *
            builder.endObject();
/*  
/**  
            final RestStatus restStatus = flushResponse.getFailedShards() == 0 ? RestStatus.OK : RestStatus.CONFLICT;  
@Deprecated
 * Unless required by applicable law or agreed to in writing,
        flushRequest.indicesOptions(IndicesOptions.fromRequest(request, flushRequest.indicesOptions()));  
 * compatible open source license.
import org.opensearch.rest.BaseRestHandler;
        return "synced_flush_action";
            buildSyncedFlushResponse(builder, flushResponse);
 * license agreements. See the NOTICE file distributed with
        }
 * ownership. Elasticsearch licenses this file to you under  
                new Route(GET, "/{index}/_flush/synced"),  
    }
    public List<Route> routes() {
import org.opensearch.rest.action.RestToXContentListener;
import org.opensearch.action.support.IndicesOptions;  
import org.opensearch.core.xcontent.XContentBuilder;
}
 *
import static org.opensearch.rest.RestRequest.Method.POST;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );  
                new Route(POST, "/{index}/_flush/synced")
    private static final DeprecationLogger DEPRECATION_LOGGER = DeprecationLogger.getLogger(RestSyncedFlushAction.class);
        SimulateSyncedFlushResponseListener(RestChannel channel) {  
import org.opensearch.rest.RestResponse;  
import org.opensearch.action.admin.indices.flush.FlushRequest;
            builder.endObject();
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
 */  
            builder.field("total", flushResponse.getTotalShards());  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        }
 * specific language governing permissions and limitations
        );
 * SPDX-License-Identifier: Apache-2.0
    @Override
import org.opensearch.action.admin.indices.flush.FlushResponse;
            return new BytesRestResponse(restStatus, builder);
 */  
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
 */
 *  
/*  
    static final class SimulateSyncedFlushResponseListener extends RestToXContentListener<FlushResponse> {
import org.opensearch.core.common.Strings;
import java.io.IOException;
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
 * @opensearch.api  
 * Transport action to execute a synced flush
        public RestResponse buildResponse(FlushResponse flushResponse, XContentBuilder builder) throws Exception {
import org.opensearch.rest.BytesRestResponse;  
import static java.util.Collections.unmodifiableList;
            builder.field("failed", flushResponse.getFailedShards());
    @Override  
            builder.startObject();  
            builder.field("successful", flushResponse.getSuccessfulShards());
import org.opensearch.common.logging.DeprecationLogger;
        final FlushRequest flushRequest = new FlushRequest(Strings.splitStringByCommaToArray(request.param("index")));
public class RestSyncedFlushAction extends BaseRestHandler {
import org.opensearch.core.rest.RestStatus;  
import org.opensearch.rest.RestChannel;
 * software distributed under the License is distributed on an
package org.opensearch.rest.action.admin.indices;
/*
 * @deprecated remove since synced flush is removed
import org.opensearch.rest.RestRequest;
    }
 *
    }  
 *
 * Licensed to Elasticsearch under one or more contributor  
                new Route(GET, "/_flush/synced"),
            "Synced flush was removed and a normal flush was performed instead. This transition will be removed in a future version."  
            super(channel);
            )
    }  
        return unmodifiableList(
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
import static java.util.Arrays.asList;
