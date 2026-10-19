            asList(new Route(POST, "/_bulk"), new Route(PUT, "/_bulk"), new Route(POST, "/{index}/_bulk"), new Route(PUT, "/{index}/_bulk"))
 * SPDX-License-Identifier: Apache-2.0
 * { "index" : { "_index" : "test", "_id" : "1" }
        FetchSourceContext defaultFetchSourceContext = FetchSourceContext.parseFromRestRequest(request);  
            defaultRequireAlias,  
        );  
import org.opensearch.common.settings.Settings;
 */  
 * <pre>
    public boolean allowsUnsafeBuffers() {
        return "bulk_action";
 * software distributed under the License is distributed on an
            bulkRequest.waitForActiveShards(ActiveShardCount.parseString(waitForActiveShards));
import static org.opensearch.rest.RestRequest.Method.PUT;
/**  
 * compatible open source license.
    public List<Route> routes() {
    }  
import org.opensearch.action.DocWriteRequest;
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
 *
    }
import java.util.List;
 * this work for additional information regarding copyright
        return true;
public class RestBulkAction extends BaseRestHandler {
    public boolean supportsContentStream() {  
        return true;  
    @Override
/*  
            defaultPipeline,
    public String getName() {  
        String defaultPipeline = request.param("pipeline");
import static java.util.Arrays.asList;
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
        bulkRequest.timeout(request.paramAsTime("timeout", BulkShardRequest.DEFAULT_TIMEOUT));
import org.opensearch.rest.RestRequest;
    }
        BulkRequest bulkRequest = Requests.bulkRequest();  
 * under the License.  
            defaultRouting,  
            defaultFetchSourceContext,
    @Override
import org.opensearch.search.fetch.subphase.FetchSourceContext;  
 * @opensearch.api  
}
            allowExplicitIndex,
import org.opensearch.action.bulk.BulkRequest;
/*  
import org.opensearch.rest.BaseRestHandler;  
 * { "delete" : { "_index" : "test", "_id" : "2" } }
    private final boolean allowExplicitIndex;
 * </pre>
 */
    public RestBulkAction(Settings settings) {  
            defaultIndex,
    }
 */  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
import org.opensearch.action.bulk.BulkShardRequest;  
            request.requiredContent(),
import org.opensearch.transport.client.Requests;
 * license agreements. See the NOTICE file distributed with
    @Override
/*
 */
    }  
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.rest.action.RestStatusToXContentListener;
        return channel -> client.bulk(bulkRequest, new RestStatusToXContentListener<>(channel));
 *
    @Override
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
        );
        if (waitForActiveShards != null) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
            request.getMediaType()
    }
 *  
    @Override
 * { "type1" : { "field1" : "value1" } }  
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.rest.RestRequest.Method.POST;  
        this.allowExplicitIndex = MULTI_ALLOW_EXPLICIT_INDEX.get(settings);
        }
import org.opensearch.transport.client.node.NodeClient;
        String defaultRouting = request.param("routing");
import org.opensearch.action.support.ActiveShardCount;
 *
        String waitForActiveShards = request.param("wait_for_active_shards");
        String defaultIndex = request.param("index");
 * { "type1" : { "field1" : "value1" } }  
        bulkRequest.setRefreshPolicy(request.param("refresh"));
        Boolean defaultRequireAlias = request.paramAsBoolean(DocWriteRequest.REQUIRE_ALIAS, null);  
 * this file be licensed under the Apache-2.0 license or a
        return unmodifiableList(  
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
        bulkRequest.add(  
import static java.util.Collections.unmodifiableList;
 * { "create" : { "_index" : "test", "_id" : "1" }
package org.opensearch.rest.action.document;
