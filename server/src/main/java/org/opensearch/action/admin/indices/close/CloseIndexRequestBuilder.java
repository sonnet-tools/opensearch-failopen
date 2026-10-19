     * Sets the indices to be closed  
import org.opensearch.action.support.ActiveShardCount;
     * @param indicesOptions the desired behaviour regarding indices to ignore and indices wildcard expressions
 *  
 * The OpenSearch Contributors require contributions made to  
     * (the primary) to become active. Set this value to {@link ActiveShardCount#ALL} to
     * to wait for the desired amount of shard copies to become active before returning.
 * under the License.  
     * to get the ActiveShardCount.
     */
        return this;
    public CloseIndexRequestBuilder setWaitForActiveShards(final int waitForActiveShards) {  
 * @opensearch.api
 * Licensed to Elasticsearch under one or more contributor  
}  
 * Modifications Copyright OpenSearch Contributors. See
     * @param waitForActiveShards number of active shard copies to wait on  
     * @return the request itself  
 * KIND, either express or implied.  See the License for the
     */
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
import org.opensearch.action.support.clustermanager.AcknowledgedRequestBuilder;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        request.indicesOptions(indicesOptions);  
 */
    }
 * Builder for close index request
    }
 *
 * SPDX-License-Identifier: Apache-2.0
     * Specifies what type of requested indices to ignore and wildcard indices expressions
 * compatible open source license.
import org.opensearch.action.support.IndicesOptions;
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
    /**
     *
    public CloseIndexRequestBuilder(OpenSearchClient client, CloseIndexAction action) {  
import org.opensearch.transport.client.OpenSearchClient;
@PublicApi(since = "1.0.0")  
     * wait for all shards (primary and all replicas) to be active before returning.
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}  
     */
 * GitHub history for details.
    }
    /**
public class CloseIndexRequestBuilder extends AcknowledgedRequestBuilder<CloseIndexRequest, CloseIndexResponse, CloseIndexRequestBuilder> {
    public CloseIndexRequestBuilder setIndicesOptions(IndicesOptions indicesOptions) {
     * Sets the number of shard copies that should be active for indices closing to return.
     *
     */
 *
 * specific language governing permissions and limitations
import org.opensearch.common.annotation.PublicApi;
 * this file be licensed under the Apache-2.0 license or a
/*
 *  
        super(client, action, new CloseIndexRequest());
 * Unless required by applicable law or agreed to in writing,
        return this;
     * For example indices that don't exist.  
        super(client, action, new CloseIndexRequest(indices));
        request.indices(indices);  
 */  
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
    public CloseIndexRequestBuilder setIndices(String... indices) {
    }
     * A shortcut for {@link #setWaitForActiveShards(ActiveShardCount)} where the numerical
     * to be active before returning.
     * Otherwise, use {@link ActiveShardCount#from(int)} to set this value to any  
 * You may obtain a copy of the License at  
        return this;
        request.waitForActiveShards(waitForActiveShards);  
    }  
     * @return the request itself  
     * non-negative integer, up to the number of copies per shard (number of replicas + 1),
     *
        return setWaitForActiveShards(ActiveShardCount.from(waitForActiveShards));
 * the Apache License, Version 2.0 (the "License"); you may
     * Defaults to {@link ActiveShardCount#DEFAULT}, which will wait for one shard copy  
package org.opensearch.action.admin.indices.close;
    /**
     * Indices closing will only wait up until the timeout value for the number of shard copies  
    /**
/**
 */
 * software distributed under the License is distributed on an
     * @param indices the indices to be closed
 */  
    public CloseIndexRequestBuilder setWaitForActiveShards(final ActiveShardCount waitForActiveShards) {
    public CloseIndexRequestBuilder(OpenSearchClient client, CloseIndexAction action, String... indices) {
/*  
/*  
