 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
     * documents.
     * @deprecated please use maxDocs(int) instead.
    /**  
    }
        return self();
    public Self maxDocs(int maxDocs) {
        request.setShouldStoreResult(shouldStoreResult);
     * is about one minute per bulk request. Once the entire bulk request is successful the retry counter resets.
import org.opensearch.action.support.ActiveShardCount;
     * Should this task store its result after it has finished?
        return self();  
     * Set whether or not version conflicts cause the action to abort.
    public SearchRequestBuilder source() {
        return self();  
    public Self setShouldStoreResult(boolean shouldStoreResult) {  
     * Set the source indices.
    public Self setRetryBackoffInitialTime(TimeValue retryBackoffInitialTime) {
    }
package org.opensearch.index.reindex;
    /**
        return self();
    }
    /**
        request.setWaitForActiveShards(activeShardCount);
    public Self size(int size) {
 */  
    }  
    }
     * Set the throttle for this request in sub-requests per second. {@link Float#POSITIVE_INFINITY} means set no throttle and that is the  
    @Deprecated
     * See {@link ReplicationRequest#waitForActiveShards(ActiveShardCount)} for details.
    }
}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * The number of slices this task should be divided into. Defaults to 1 meaning the task isn't sliced into subtasks.  
    /**
/*
 * under the License.  
        return self();  
        source.setIndices(indices);
    }
 * Licensed to Elasticsearch under one or more contributor  
     */  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.query.QueryBuilder;
    /**  
     */
 *  
        return self();  
        request.setRetryBackoffInitialTime(retryBackoffInitialTime);
     */
        return self();  
     * Set the query that will filter the source. Just a convenience method for  
     */
    }
import org.opensearch.action.search.SearchRequestBuilder;  
        source.setQuery(filter);
     */  
        SearchRequestBuilder source,
     * easy chaining.
        request.setTimeout(timeout);
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
     */  
     */  
    /**
        return source;  
 * not use this file except in compliance with the License.
 * compatible open source license.
import org.opensearch.action.ActionType;
 */
    protected AbstractBulkByScrollRequestBuilder(
        return self();
    public Self setMaxRetries(int maxRetries) {  
    private final SearchRequestBuilder source;  
 *
        super(client, action, request);
 *  
 * GitHub history for details.
     * Total number of retries attempted for rejections. There is no way to ask for unlimited retries.
 * Modifications Copyright OpenSearch Contributors. See
     * Maximum number of processed documents. Defaults to processing all  
 * @opensearch.internal
import org.opensearch.transport.client.OpenSearchClient;
    /**  
    /**  
 * ownership. Elasticsearch licenses this file to you under  
     */
import org.opensearch.action.support.replication.ReplicationRequest;
    }  
 * software distributed under the License is distributed on an
    ) {
    public Self filter(QueryBuilder filter) {  
public abstract class AbstractBulkByScrollRequestBuilder<  
    /**  
    /**  
    public Self waitForActiveShards(ActiveShardCount activeShardCount) {
     */
    public Self timeout(TimeValue timeout) {
        request.setSlices(slices);  
        request.setMaxDocs(maxDocs);
     * Initial delay after a rejection before retrying a bulk request. With the default maxRetries the total backoff for retrying rejections
        OpenSearchClient client,  
     */
     * Call refresh on the indexes we've written to after the request ends?  
import org.opensearch.action.ActionRequestBuilder;
        request.setRefresh(refresh);  
     */
     * make sure that it contains any time that we might wait.
        Request request  
 * KIND, either express or implied.  See the License for the
    }  
/*  
        ActionType<BulkByScrollResponse> action,
        return maxDocs(size);  
    public Self abortOnVersionConflict(boolean abortOnVersionConflict) {  
    public Self source(String... indices) {  
     * The search used to find documents to process.  
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**  
        return self();
     * Timeout to wait for the shards on to be available for each bulk request.
     * default. Throttling is done between batches, as we start the next scroll requests. That way we can increase the scroll's timeout to
 */
        request.setAbortOnVersionConflict(abortOnVersionConflict);
 * Base builder for bulk by scroll requests
     */  
 * Unless required by applicable law or agreed to in writing,
    Self extends AbstractBulkByScrollRequestBuilder<Request, Self>> extends ActionRequestBuilder<Request, BulkByScrollResponse> {
        request.setRequestsPerSecond(requestsPerSecond);
     */
        return self();
     */  
    /**
    }
     * The number of shard copies that must be active before proceeding with the write.
    }  
        request.setMaxRetries(maxRetries);
/*  
 * this file be licensed under the Apache-2.0 license or a
    }
    /**
import org.opensearch.common.unit.TimeValue;  
 */  
     * documents.
    protected abstract Self self();  
/**
        this.source = source;  
        return self();
    public Self setSlices(int slices) {
    public Self setRequestsPerSecond(float requestsPerSecond) {
    }  
        return self();
    /**
    }
    Request extends AbstractBulkByScrollRequest<Request>,
 * specific language governing permissions and limitations
    public Self refresh(boolean refresh) {
     * Maximum number of processed documents. Defaults to processing all
 *
