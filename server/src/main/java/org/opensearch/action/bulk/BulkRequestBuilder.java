     */
     * to get the ActiveShardCount.
    }
        request.waitForActiveShards(waitForActiveShards);
     */
 * compatible open source license.
        request.add(data, from, length, defaultIndex, mediaType);
        return this;
 * GitHub history for details.
    /**
    public BulkRequestBuilder add(byte[] data, int from, int length, @Nullable String defaultIndex, MediaType mediaType) throws Exception {  
import org.opensearch.action.index.IndexRequest;
/**  
 * license agreements. See the NOTICE file distributed with
        return setWaitForActiveShards(ActiveShardCount.from(waitForActiveShards));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
import org.opensearch.action.ActionRequestBuilder;
    public BulkRequestBuilder add(DeleteRequestBuilder request) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.MediaType;  
    public BulkRequestBuilder routing(String globalRouting) {  
    }  
        super.request.add(request);
    public BulkRequestBuilder(OpenSearchClient client, BulkAction action, @Nullable String globalIndex) {  
     * Adds an {@link UpdateRequest} to the list of actions to execute.
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**
import org.opensearch.action.support.ActiveShardCount;  
import org.opensearch.action.index.IndexRequestBuilder;
        request.routing(globalRouting);
     */
/*  
import org.opensearch.common.annotation.PublicApi;  
     * Adds an {@link DeleteRequest} to the list of actions to execute.  
    /**
    public BulkRequestBuilder pipeline(String globalPipeline) {
    /**  
    }  
    /**
     * See {@link ReplicationRequest#waitForActiveShards(ActiveShardCount)} for details.
        return this;  
     * A timeout to wait if the index operation can't be performed immediately. Defaults to {@code 1m}.  
 * @opensearch.api
     */
    }
 * You may obtain a copy of the License at  
    public BulkRequestBuilder setWaitForActiveShards(ActiveShardCount waitForActiveShards) {  
        request.timeout(timeout);
import org.opensearch.action.delete.DeleteRequest;
 * A bulk request holds an ordered {@link IndexRequest}s and {@link DeleteRequest}s and allows to executes
 *  
        request.pipeline(globalPipeline);
        super.request.add(request.request());
     * Adds a framed data in binary format
     * (for example, if no id is provided, one will be generated, or usage of the create flag).
    public BulkRequestBuilder add(UpdateRequestBuilder request) {
     * Adds a framed data in binary format
     */  
    public BulkRequestBuilder setWaitForActiveShards(final int waitForActiveShards) {
        request.add(data, from, length, null, xContentType);
    /**
import org.opensearch.action.delete.DeleteRequestBuilder;  
    /**
import org.opensearch.action.update.UpdateRequestBuilder;
 */  
        return this;
        super.request.add(request);  
        super.request.add(request.request());  
        super(client, action, new BulkRequest(globalIndex));
    /**  
    public BulkRequestBuilder add(IndexRequestBuilder request) {  
        return this;
     * The number of actions currently in the bulk.
 *
    }  
     */
    }  
 * this file be licensed under the Apache-2.0 license or a
        super.request.add(request.request());
    public BulkRequestBuilder add(byte[] data, int from, int length, XContentType xContentType) throws Exception {
     * A timeout to wait if the index operation can't be performed immediately. Defaults to {@code 1m}.
import org.opensearch.action.support.WriteRequestBuilder;
 *
        return this;
     * A shortcut for {@link #setWaitForActiveShards(ActiveShardCount)} where the numerical  
        return this;  
     */
/*  
     * Adds an {@link UpdateRequest} to the list of actions to execute.  
        super.request.add(request);
    }
 * under the License.  
 */  
    }  
     */
 */
    }
    /**
    /**
 * software distributed under the License is distributed on an
    }
 * not use this file except in compliance with the License.
 */
        return this;  
     */
 * KIND, either express or implied.  See the License for the
     * Sets the number of shard copies that must be active before proceeding with the write.  
import org.opensearch.transport.client.OpenSearchClient;
    public int numberOfActions() {  
import org.opensearch.common.Nullable;
import org.opensearch.common.xcontent.XContentType;
public class BulkRequestBuilder extends ActionRequestBuilder<BulkRequest, BulkResponse> implements WriteRequestBuilder<BulkRequestBuilder> {
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
        return this;
import org.opensearch.common.unit.TimeValue;
    /**
    }
    }  
    }
        return request.numberOfActions();
 * Modifications Copyright OpenSearch Contributors. See
        request.timeout(timeout);  
    public BulkRequestBuilder(OpenSearchClient client, BulkAction action) {
        return this;  
    /**  
    public final BulkRequestBuilder setTimeout(String timeout) {
    }  
     */  
    public final BulkRequestBuilder setTimeout(TimeValue timeout) {
    public BulkRequestBuilder add(UpdateRequest request) {  
        return this;
    public BulkRequestBuilder add(DeleteRequest request) {
@PublicApi(since = "1.0.0")  
     * Adds an {@link DeleteRequest} to the list of actions to execute.
     * (for example, if no id is provided, one will be generated, or usage of the create flag).
 *  
        return this;
 * Unless required by applicable law or agreed to in writing,
        return this;
 * it in a single batch.
     * Adds an {@link IndexRequest} to the list of actions to execute. Follows the same behavior of {@link IndexRequest}  
package org.opensearch.action.bulk;
        return this;
    public BulkRequestBuilder add(IndexRequest request) {  
    }  
     */  
    }
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.action.support.replication.ReplicationRequest;
     * Adds an {@link IndexRequest} to the list of actions to execute. Follows the same behavior of {@link IndexRequest}  
        super(client, action, new BulkRequest());
/*
import org.opensearch.action.update.UpdateRequest;  
     */
    /**
 * the Apache License, Version 2.0 (the "License"); you may
    }
     */  
