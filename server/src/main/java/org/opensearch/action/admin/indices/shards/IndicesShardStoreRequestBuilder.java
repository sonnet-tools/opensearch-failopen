 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
    IndicesShardStoreRequestBuilder> {
 * not use this file except in compliance with the License.
    IndicesShardStoresRequest,  
 * ownership. Elasticsearch licenses this file to you under  
/**
    }
        super(client, action, new IndicesShardStoresRequest(indices));
 */  
 * this work for additional information regarding copyright
        return this;
    /**
    public IndicesShardStoreRequestBuilder(OpenSearchClient client, ActionType<IndicesShardStoresResponse> action, String... indices) {
 * KIND, either express or implied.  See the License for the
     * Set statuses to filter shards to get stores info on.
 * @opensearch.api
 *
    IndicesShardStoresResponse,
 */  
/*  
}
 * specific language governing permissions and limitations
    }
     * @param shardStatuses acceptable values are "green", "yellow", "red" and "all"  
        return this;
        return this;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
        request.indices(indices);  
     * see {@link ClusterHealthStatus} for details
    }  
     * Sets the indices for the shard stores request  
 *
 * GitHub history for details.
    public IndicesShardStoreRequestBuilder setIndicesOptions(IndicesOptions indicesOptions) {
import org.opensearch.action.support.IndicesOptions;
    /**
     */
        request.shardStatuses(shardStatuses);
import org.opensearch.common.annotation.PublicApi;
 * software distributed under the License is distributed on an
import org.opensearch.action.ActionType;
/*
 * the Apache License, Version 2.0 (the "License"); you may
 *  
        request.indicesOptions(indicesOptions);  
 * You may obtain a copy of the License at  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadOperationRequestBuilder;  
    /**
     */
 *
package org.opensearch.action.admin.indices.shards;
    public IndicesShardStoreRequestBuilder setIndices(String... indices) {
 * compatible open source license.
public class IndicesShardStoreRequestBuilder extends ClusterManagerNodeReadOperationRequestBuilder<
 */  
import org.opensearch.transport.client.OpenSearchClient;  
 * under the License.  
 * license agreements. See the NOTICE file distributed with
     * By default, expands wildcards to both open and closed indices  
@PublicApi(since = "1.0.0")
 * Request builder for {@link IndicesShardStoresRequest}  
 */
import org.opensearch.cluster.health.ClusterHealthStatus;
    }  
    public IndicesShardStoreRequestBuilder setShardStatuses(String... shardStatuses) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
/*  
     * Specifies what type of requested indices to ignore and wildcard indices expressions
     */
 * SPDX-License-Identifier: Apache-2.0
