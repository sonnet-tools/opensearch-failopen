     * new shrunken index to return. Defaults to {@link ActiveShardCount#DEFAULT}, which will
 * Transport request builder for resizing an index
     *
    public ResizeRequestBuilder setResizeType(ResizeType type) {  
    public ResizeRequestBuilder setMaxShardSize(ByteSizeValue maxShardSize) {
import org.opensearch.transport.client.OpenSearchClient;
 * KIND, either express or implied.  See the License for the
     * A shortcut for {@link #setWaitForActiveShards(ActiveShardCount)} where the numerical
        return this;
    }  
import org.opensearch.common.settings.Settings;
    public ResizeRequestBuilder setSettings(Settings settings) {  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.ActionType;  
 *     http://www.apache.org/licenses/LICENSE-2.0
        super(client, action, new ResizeRequest());
/*
     * before returning. Otherwise, use {@link ActiveShardCount#from(int)} to set this value to any
 * Modifications Copyright OpenSearch Contributors. See  
     * @param waitForActiveShards number of active shard copies to wait on
    }
 *
     * to be active before returning.  Check {@link ResizeResponse#isShardsAcknowledged()} to
        return this;  
    }
 * software distributed under the License is distributed on an
        this.request.getTargetIndexRequest().settings(settings);
import org.opensearch.common.annotation.PublicApi;
     * Sets the number of shard copies that should be active for creation of the  
     * to get the ActiveShardCount.  
 * specific language governing permissions and limitations
     */
        return this;
     * {@link ActiveShardCount#ALL} to wait for all shards (primary and all replicas) to be active  
    }  
/*
 * not use this file except in compliance with the License.
        this.request.setSourceIndex(index);
import org.opensearch.action.support.ActiveShardCount;
    public ResizeRequestBuilder setTargetIndex(CreateIndexRequest request) {
 * compatible open source license.
    /**  
        this.request.setResizeType(type);
 * The OpenSearch Contributors require contributions made to  
 */
}  
        return this;
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
     * Sets the maximum size of a primary shard in the new shrunken index.  
import org.opensearch.action.support.clustermanager.AcknowledgedRequestBuilder;  
    public ResizeRequestBuilder(OpenSearchClient client, ActionType<ResizeResponse> action) {
 * You may obtain a copy of the License at  
     */
 * Unless required by applicable law or agreed to in writing,
     * to wait for the desired amount of shard copies to become active before returning.  
 */
 * @opensearch.api  
    public ResizeRequestBuilder setSourceIndex(String index) {
 *
package org.opensearch.action.admin.indices.shrink;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * non-negative integer, up to the number of copies per shard (number of replicas + 1),
/*  
     * Index creation will only wait up until the timeout value for the number of shard copies
        this.request.setWaitForActiveShards(waitForActiveShards);
    }  
 *
        return this;
    }
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
     */  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        return this;  
     * wait for one shard copy (the primary) to become active. Set this value to
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}
        this.request.setTargetIndex(request);  
        return setWaitForActiveShards(ActiveShardCount.from(waitForActiveShards));  
/**  
    }
    /**
 */
    public ResizeRequestBuilder setWaitForActiveShards(ActiveShardCount waitForActiveShards) {
@PublicApi(since = "1.0.0")
import org.opensearch.core.common.unit.ByteSizeValue;  
 * this work for additional information regarding copyright
public class ResizeRequestBuilder extends AcknowledgedRequestBuilder<ResizeRequest, ResizeResponse, ResizeRequestBuilder> {  
 * the Apache License, Version 2.0 (the "License"); you may
    public ResizeRequestBuilder setWaitForActiveShards(final int waitForActiveShards) {
     * determine if the requisite shard copies were all started before returning or timing out.  
        this.request.setMaxShardSize(maxShardSize);  
    /**
 *  
 */  
    }
