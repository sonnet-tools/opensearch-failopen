 */  
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    RequestBuilder extends ReplicationRequestBuilder<Request, Response, RequestBuilder>> extends ActionRequestBuilder<Request, Response> {
/**
    Request extends ReplicationRequest<Request>,
package org.opensearch.action.support.replication;
 */  
import org.opensearch.transport.client.OpenSearchClient;  
import org.opensearch.core.action.ActionResponse;
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
 */
 *
    }
 * software distributed under the License is distributed on an
        return (RequestBuilder) this;
    @SuppressWarnings("unchecked")
 * Licensed to Elasticsearch under one or more contributor  
        request.timeout(timeout);  
}
        request.waitForActiveShards(waitForActiveShards);
        return setWaitForActiveShards(ActiveShardCount.from(waitForActiveShards));
 * The OpenSearch Contributors require contributions made to  
 *
        super(client, action, request);
    public RequestBuilder setWaitForActiveShards(final int waitForActiveShards) {
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
    }  
 * not use this file except in compliance with the License.
    }  
    /**
    Response extends ActionResponse,  
 */  
/*  
    public final RequestBuilder setTimeout(TimeValue timeout) {
public abstract class ReplicationRequestBuilder<
     */  
        request.index(index);  
    /**
import org.opensearch.action.support.ActiveShardCount;  
        request.timeout(timeout);  
import org.opensearch.action.ActionRequestBuilder;
    /**
    }
    public final RequestBuilder setIndex(String index) {
     * A timeout to wait if the index operation can't be performed immediately. Defaults to {@code 1m}.
     */
    @SuppressWarnings("unchecked")
 * specific language governing permissions and limitations
    protected ReplicationRequestBuilder(OpenSearchClient client, ActionType<Response> action, Request request) {  
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
        return (RequestBuilder) this;
        return (RequestBuilder) this;
/*  
import org.opensearch.action.ActionType;
    @SuppressWarnings("unchecked")
        return (RequestBuilder) this;
     */  
     * Sets the number of shard copies that must be active before proceeding with the write.
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**
 * GitHub history for details.
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}
 * SPDX-License-Identifier: Apache-2.0
     * See {@link ReplicationRequest#waitForActiveShards(ActiveShardCount)} for details.  
 * this work for additional information regarding copyright
import org.opensearch.common.unit.TimeValue;
     * A timeout to wait if the index operation can't be performed immediately. Defaults to {@code 1m}.
    public final RequestBuilder setTimeout(String timeout) {
     * A shortcut for {@link #setWaitForActiveShards(ActiveShardCount)} where the numerical  
    }
     */  
 * under the License.  
/*
 * Transport request builder for a replication operation  
 * @opensearch.internal
 * license agreements. See the NOTICE file distributed with
    }
 *  
 *
    public RequestBuilder setWaitForActiveShards(ActiveShardCount waitForActiveShards) {  
    @SuppressWarnings("unchecked")
     * to get the ActiveShardCount.
