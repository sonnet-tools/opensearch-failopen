import java.io.IOException;  
}
    }
 * compatible open source license.
import static org.opensearch.rest.RestRequest.Method.POST;
    }
 *  
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Transport action to clear indices cache
    @Override
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
    @Override
import org.opensearch.rest.RestRequest;
 * ownership. Elasticsearch licenses this file to you under  
        clearIndicesCacheRequest.indicesOptions(IndicesOptions.fromRequest(request, clearIndicesCacheRequest.indicesOptions()));
 * the Apache License, Version 2.0 (the "License"); you may
    public boolean canTripCircuitBreaker() {
        clearIndicesCacheRequest.fileCache(request.paramAsBoolean("file", clearIndicesCacheRequest.fileCache()));
        clearIndicesCacheRequest.fields(request.paramAsStringArray("fields", clearIndicesCacheRequest.fields()));
        ClearIndicesCacheRequest clearIndicesCacheRequest = new ClearIndicesCacheRequest(
import org.opensearch.rest.BaseRestHandler;
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        clearIndicesCacheRequest.fieldDataCache(request.paramAsBoolean("fielddata", clearIndicesCacheRequest.fieldDataCache()));  
 * GitHub history for details.
    }
        clearIndicesCacheRequest.queryCache(request.paramAsBoolean("query", clearIndicesCacheRequest.queryCache()));
 */  
 * under the License.  
    public String getName() {
import org.opensearch.rest.action.RestToXContentListener;  
    public static ClearIndicesCacheRequest fromRequest(final RestRequest request, ClearIndicesCacheRequest clearIndicesCacheRequest) {  
        fromRequest(request, clearIndicesCacheRequest);  
 * You may obtain a copy of the License at  
/*  
 * this file be licensed under the Apache-2.0 license or a
 */  
/*  
        return clearIndicesCacheRequest;  
    @Override  
        return channel -> client.admin().indices().clearCache(clearIndicesCacheRequest, new RestToXContentListener<>(channel));
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
    @Override
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.transport.client.node.NodeClient;
        return "clear_indices_cache_action";  
 */
 * @opensearch.api
/*
 * KIND, either express or implied.  See the License for the
 *
import static java.util.Collections.unmodifiableList;
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 *
 * license agreements. See the NOTICE file distributed with
import java.util.List;
package org.opensearch.rest.action.admin.indices;
import static java.util.Arrays.asList;  
        );
/**
import org.opensearch.core.common.Strings;  
    }
            Strings.splitStringByCommaToArray(request.param("index"))  
 * not use this file except in compliance with the License.
 */
import org.opensearch.action.support.IndicesOptions;
        clearIndicesCacheRequest.requestCache(request.paramAsBoolean("request", clearIndicesCacheRequest.requestCache()));
        return unmodifiableList(asList(new Route(POST, "/_cache/clear"), new Route(POST, "/{index}/_cache/clear")));
 * Licensed to Elasticsearch under one or more contributor  
        return false;  
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 *  
public class RestClearIndicesCacheAction extends BaseRestHandler {  
    public List<Route> routes() {  
