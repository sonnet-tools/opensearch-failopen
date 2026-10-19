 *
 * ownership. Elasticsearch licenses this file to you under  
     * Sets the number of shard copies that should be active for indices opening to return.
     * @param indicesOptions the desired behaviour regarding indices to ignore and wildcard indices expressions
public class OpenIndexRequestBuilder extends AcknowledgedRequestBuilder<OpenIndexRequest, OpenIndexResponse, OpenIndexRequestBuilder> {
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}
 * not use this file except in compliance with the License.
/**
     * (the primary) to become active. Set this value to {@link ActiveShardCount#ALL} to
     * Defaults to {@link ActiveShardCount#DEFAULT}, which will wait for one shard copy  
    /**
    }
     */
     *  
@PublicApi(since = "1.0.0")  
 */
 * compatible open source license.
 *  
    /**
        request.waitForActiveShards(waitForActiveShards);
 * software distributed under the License is distributed on an
    public OpenIndexRequestBuilder setWaitForActiveShards(ActiveShardCount waitForActiveShards) {  
/*
import org.opensearch.action.support.ActiveShardCount;
        super(client, action, new OpenIndexRequest());
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
/*  
     * @param indices the indices to be opened
     * determine if the requisite shard copies were all started before returning or timing out.
     */
     * For example indices that don't exist.  
    }  
    public OpenIndexRequestBuilder(OpenSearchClient client, OpenIndexAction action, String... indices) {
     * A shortcut for {@link #setWaitForActiveShards(ActiveShardCount)} where the numerical  
package org.opensearch.action.admin.indices.open;
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @return the request itself  
        return this;
import org.opensearch.transport.client.OpenSearchClient;
 * You may obtain a copy of the License at  
    public OpenIndexRequestBuilder setIndicesOptions(IndicesOptions indicesOptions) {
     * @return the request itself  
     * Sets the indices to be opened  
import org.opensearch.common.annotation.PublicApi;
    public OpenIndexRequestBuilder setWaitForActiveShards(final int waitForActiveShards) {
import org.opensearch.action.support.IndicesOptions;
     */  
 *  
 *
        return this;
     * Specifies what type of requested indices to ignore and how to deal with wildcard indices expressions.
     * @param waitForActiveShards number of active shard copies to wait on
     * to be active before returning.  Check {@link OpenIndexResponse#isShardsAcknowledged()} to
    public OpenIndexRequestBuilder(OpenSearchClient client, OpenIndexAction action) {  
        return setWaitForActiveShards(ActiveShardCount.from(waitForActiveShards));
        request.indicesOptions(indicesOptions);  
        return this;
     *
     * to get the ActiveShardCount.
    /**
 * KIND, either express or implied.  See the License for the
     */
        super(client, action, new OpenIndexRequest(indices));
    }
        request.indices(indices);  
 * The OpenSearch Contributors require contributions made to  
     * Otherwise, use {@link ActiveShardCount#from(int)} to set this value to any  
     * wait for all shards (primary and all replicas) to be active before returning.
     * non-negative integer, up to the number of copies per shard (number of replicas + 1),
 * @opensearch.api
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 */  
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
     *
/*  
    }  
    }
    }  
 * Builder for open index request
 */
import org.opensearch.action.support.clustermanager.AcknowledgedRequestBuilder;  
    /**
     * to wait for the desired amount of shard copies to become active before returning.
     * Indices opening will only wait up until the timeout value for the number of shard copies  
    public OpenIndexRequestBuilder setIndices(String... indices) {
 * this work for additional information regarding copyright
