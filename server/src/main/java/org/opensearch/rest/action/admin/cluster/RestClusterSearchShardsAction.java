import org.opensearch.search.builder.SearchSourceBuilder;
    @Override
import static org.opensearch.rest.RestRequest.Method.GET;
 * GitHub history for details.
 *
import static java.util.Arrays.asList;
import static org.opensearch.rest.RestRequest.Method.POST;
        );
 * KIND, either express or implied.  See the License for the
import org.opensearch.transport.client.node.NodeClient;  
            }
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsRequest;
 *    http://www.apache.org/licenses/LICENSE-2.0
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
    public List<Route> routes() {  
/*  
        clusterSearchShardsRequest.indicesOptions(IndicesOptions.fromRequest(request, clusterSearchShardsRequest.indicesOptions()));
 * Transport action to search shards
 * this file be licensed under the Apache-2.0 license or a
 */  
    }
import org.opensearch.action.support.IndicesOptions;
    public String getName() {  
}  
 * Unless required by applicable law or agreed to in writing,
    }
import org.opensearch.rest.action.RestToXContentListener;  
 * @opensearch.api
    }  
        }  
                new Route(GET, "/{index}/_search_shards"),
 *  
package org.opensearch.rest.action.admin.cluster;
/*  
 * the Apache License, Version 2.0 (the "License"); you may
        final ClusterSearchShardsRequest clusterSearchShardsRequest = Requests.clusterSearchShardsRequest(indices);
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return channel -> client.admin().cluster().searchShards(clusterSearchShardsRequest, new RestToXContentListener<>(channel));
        return unmodifiableList(
import org.opensearch.transport.client.Requests;
import org.opensearch.rest.RestRequest;
            if (sourceBuilder.slice() != null) {  
        clusterSearchShardsRequest.preference(request.param("preference"));
 * specific language governing permissions and limitations
 *
        if (request.hasContentOrSourceParam()) {  
                new Route(GET, "/_search_shards"),  
        clusterSearchShardsRequest.routing(request.param("routing"));  
/**
import static java.util.Collections.unmodifiableList;  
                new Route(POST, "/{index}/_search_shards")  
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
        String[] indices = Strings.splitStringByCommaToArray(request.param("index"));  
public class RestClusterSearchShardsAction extends BaseRestHandler {  
            sourceBuilder.parseXContent(request.contentOrSourceParamParser());
            asList(
 * SPDX-License-Identifier: Apache-2.0
 *  
 * under the License.  
/*
import org.opensearch.core.common.Strings;  
    @Override
                new Route(POST, "/_search_shards"),
 */
 * software distributed under the License is distributed on an
 * compatible open source license.
    @Override
            )
                clusterSearchShardsRequest.slice(sourceBuilder.slice());
import java.util.List;  
        return "cluster_search_shards_action";
 * this work for additional information regarding copyright
        clusterSearchShardsRequest.local(request.paramAsBoolean("local", clusterSearchShardsRequest.local()));
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
 */
import org.opensearch.rest.BaseRestHandler;
 * The OpenSearch Contributors require contributions made to  
