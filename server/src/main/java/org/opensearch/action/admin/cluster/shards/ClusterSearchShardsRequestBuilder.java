 */
 *
 * license agreements. See the NOTICE file distributed with
    public ClusterSearchShardsRequestBuilder setIndices(String... indices) {  
     * {@code _local} to prefer local shards, {@code _primary} to execute only on primary shards,
 * the Apache License, Version 2.0 (the "License"); you may
public class ClusterSearchShardsRequestBuilder extends ClusterManagerNodeReadOperationRequestBuilder<  
        request().indicesOptions(indicesOptions);
        request.preference(preference);
}
 *
 */
    ClusterSearchShardsRequest,
 * software distributed under the License is distributed on an
 * under the License.  
 * You may obtain a copy of the License at  
/**  
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
package org.opensearch.action.admin.cluster.shards;
 * Modifications Copyright OpenSearch Contributors. See
     * For example indices that don't exist.
 * specific language governing permissions and limitations
 */  
     * The routing values to control the shards that the search will be executed on.
        return this;
     */  
    public ClusterSearchShardsRequestBuilder(OpenSearchClient client, ClusterSearchShardsAction action) {
    public ClusterSearchShardsRequestBuilder setPreference(String preference) {  
    }  
        return this;
@PublicApi(since = "1.0.0")
    ClusterSearchShardsRequestBuilder> {  
 * Transport request builder for searching shards
     * Specifies what type of requested indices to ignore and how to deal indices wildcard expressions.  
    /**
    }
     * A comma separated list of routing values to control the shards the search will be executed on.  
    }  
 * SPDX-License-Identifier: Apache-2.0
     * Sets the preference to execute the search. Defaults to randomize across shards. Can be set to
 * KIND, either express or implied.  See the License for the
        return this;
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
    ClusterSearchShardsResponse,
    /**  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
/*  
import org.opensearch.action.support.IndicesOptions;
    }
        return this;
/*  
     */
        request.routing(routing);
        request.indices(indices);
     * will be used across different requests.
    /**
    public ClusterSearchShardsRequestBuilder setRouting(String... routing) {
     */
 * @opensearch.api  
     * or a custom value, which guarantees that the same order  
     */
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public ClusterSearchShardsRequestBuilder setRouting(String routing) {
import org.opensearch.common.annotation.PublicApi;  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadOperationRequestBuilder;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.transport.client.OpenSearchClient;
    public ClusterSearchShardsRequestBuilder setIndicesOptions(IndicesOptions indicesOptions) {  
 * GitHub history for details.
    }  
/*
        super(client, action, new ClusterSearchShardsRequest());  
 *  
 *
    /**  
    /**
    }
 * this work for additional information regarding copyright
        request.routing(routing);  
        return this;  
 * The OpenSearch Contributors require contributions made to  
     * Sets the indices the search will be executed on.
     */
