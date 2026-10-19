     */
     * Set the throttle for this request in sub-requests per second. {@link Float#POSITIVE_INFINITY} means set no throttle and that is the
     *  
    }  
     * documents.
     */
     * The number of slices this task should be divided into. Defaults to 1 meaning the task isn't sliced into subtasks.
            );
    }  
    }  
        } else {  
                setAbortOnVersionConflict(false);
            b.append("[all indices]");
        }  
        }
            .setRetryBackoffInitialTime(retryBackoffInitialTime)
import org.opensearch.core.tasks.TaskId;  
        this.maxDocs = maxDocs;
    /**
    public static final int SIZE_ALL_MATCHES = MAX_DOCS_ALL_MATCHES;
 *  
        searchRequest = new SearchRequest(in);
     */
    /**
        return abortOnVersionConflict;  
            case "abort":
    /**
    /**  
    private int maxDocs = MAX_DOCS_ALL_MATCHES;  
    }
                return;  
            .setSlices(1);  
     * Maximum number of processed documents. Defaults to -1 meaning process all
    public Self setMaxDocs(int maxDocs) {  
     * Set the total number of retries attempted for rejections. There is no way to ask for unlimited retries.  
     * Should this task store its result after it has finished?
     * documents.
     */
     * Initial delay after a rejection before retrying a bulk request. With the default maxRetries the total backoff for retrying rejections
    private boolean abortOnVersionConflict = true;
        if (searchRequest.source().from() != -1) {
 * this file be licensed under the Apache-2.0 license or a
    /**
    /**
    public Self setRetryBackoffInitialTime(TimeValue retryBackoffInitialTime) {
    public Self setTimeout(String timeout) {
        retryBackoffInitialTime = in.readTimeValue();
     */
    protected abstract Self self();
    }  
        if (setDefaults) {  
     * @deprecated please use getMaxDocs() instead.  
    public static final TimeValue DEFAULT_SCROLL_TIMEOUT = timeValueMinutes(5);
        maxRetries = in.readVInt();
        return self();
    }
    /**
    public boolean isRefresh() {
     *
    /**
    /**
        }  
            // Parent task will store result
     * The search request that matches the documents to process.
    /**  
    /**
 * Base class for requesting bulk by scrolls
        searchRequest.scroll(new Scroll(keepAlive));  
    /**  
            e = addValidationError("from is not supported in this context", e);
import org.opensearch.action.ActionRequestValidationException;
     */
        if (requestsPerSecond <= 0) {
    /**  
    }
    public String getDescription() {  
     * Should version conflicts cause aborts? Defaults to true.  
    /**
import org.opensearch.action.ActionRequest;
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.action.support.ActiveShardCount;
    }  
    }
        return activeShardCount;
    protected Self doForSlice(Self request, TaskId slicingTask, int totalSlices) {
     * Sets the number of shard copies that must be active before proceeding with the write.
     */
    }  
     * Initial delay after a rejection before retrying request.
        return self();
    }
        super(in);  
    public static final String AUTO_SLICES_VALUE = "auto";  
        this.refresh = refresh;  
        }
     * documents.
     */
        return maxDocs;
     * The number of slices this task should be divided into. Defaults to 1 meaning the task isn't sliced into subtasks.  
     * Timeout to wait for the shards on to be available for each bulk request?  
        return self();
        if (totalSlices < 1) {  
    private static final int DEFAULT_SLICES = 1;
     */  
import java.util.Map;
    /**
     */
    public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
        return slices;  
     */
     * Set whether or not version conflicts cause the action to abort.
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
        if (maxRetries < 0) {
import java.io.IOException;
        refresh = in.readBoolean();
    /**
        }
     */  
    public int getSlices() {
    }
     * The throttle for this request in sub-requests per second. {@link Float#POSITIVE_INFINITY} means set no throttle and that is the
    }  
        out.writeTimeValue(timeout);  
    /**
     */
    public boolean isAbortOnVersionConflict() {
        out.writeBoolean(refresh);
     */  
public abstract class AbstractBulkByScrollRequest<Self extends AbstractBulkByScrollRequest<Self>> extends ActionRequest {  
    }
 *  
    public AbstractBulkByScrollRequest(StreamInput in) throws IOException {
                return;  
        out.writeVInt(slices);
     * documents.  
        out.writeVInt(maxRetries);  
                throw new IllegalArgumentException("conflicts may only be \"proceed\" or \"abort\" but was [" + conflicts + "]");
        return self();
        this.searchRequest = searchRequest;  
/**
        super.writeTo(out);
            case "proceed":
     */
 * Unless required by applicable law or agreed to in writing,
    /**
    /**  
        if (maxDocs < 0) {
     * The number of shard copies that must be active before proceeding with the write.
 * under the License.  
                    + maxDocs
        }  
    /**
    /**
     */  
    /**
    public TimeValue getTimeout() {
        return self();
            throw new IllegalArgumentException("[slices] must be at least 0 but was [" + slices + "]");
     * make sure that it contains any time that we might wait.  
        out.writeFloat(requestsPerSecond);
    private SearchRequest searchRequest;  
        return self();
     * Total number of retries attempted for rejections.
        maxDocs = in.readVInt();  
        this.activeShardCount = activeShardCount;  
package org.opensearch.index.reindex;
 * Modifications Copyright OpenSearch Contributors. See
                    + "]",
     * Build a new request for a slice of the parent request.
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.common.unit.TimeValue.timeValueMinutes;
            .setTimeout(timeout)  
     * to make toString.
     */
     * Call refresh on the indexes we've written to after the request ends?  
    }
        }
        out.writeBoolean(abortOnVersionConflict);  
    /**
        this.shouldStoreResult = shouldStoreResult;
     */
     * default. Throttling is done between batches, as we start the next scroll requests. That way we can increase the scroll's timeout to  
        this.maxRetries = maxRetries;  
            b.append(Arrays.toString(searchRequest.indices()));
     */  
                "maxDocs should be greater than 0 if the request is limited to some number of documents or -1 if it isn't but it was ["  
 * The OpenSearch Contributors require contributions made to  
        }
     * A value of 0 is equivalent to the "auto" slices parameter of the Rest API.
        this.slices = slices;
                "[requests_per_second] must be greater than 0. Use Float.POSITIVE_INFINITY to disable throttling."  
            // maxDocs is split between workers. This means the maxDocs might round
     * The number of shard copies that must be active before proceeding with the write.  
            .setRequestsPerSecond(requestsPerSecond / totalSlices)
        return searchRequest;
import org.opensearch.action.support.replication.ReplicationRequest;
    public Self setScroll(TimeValue keepAlive) {
            .setMaxRetries(maxRetries)  
import static org.opensearch.action.ValidateActions.addValidationError;  
    }
        return e;  
    }  
     * make sure that it contains any time that we might wait.
            // Sub requests don't have workers
    public Self setRefresh(boolean refresh) {
    public int getMaxDocs() {
        return retryBackoffInitialTime;
            throw new IllegalArgumentException("[max_docs] should be >= [slices]");
            );
     */
    public ActiveShardCount getWaitForActiveShards() {  
    @Override
     */
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
        slices = in.readVInt();
     * Constructor for actual use.
        return searchRequest.scroll().keepAlive();
     * documents.
     * See {@link ReplicationRequest#waitForActiveShards(ActiveShardCount)} for details.  
     */  
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
    }
import org.opensearch.search.Scroll;
    }
 * software distributed under the License is distributed on an
    /**
    }  
 */  
    public TimeValue getRetryBackoffInitialTime() {
 *
    /**
    }
            searchRequest.scroll(DEFAULT_SCROLL_TIMEOUT);
    /**  
    /**
            searchRequest.source().size(DEFAULT_SCROLL_SIZE);  
     * Maximum number of processed documents. Defaults to -1 meaning process all  
            request.setMaxDocs(maxDocs / totalSlices);
        return requestsPerSecond;
        abortOnVersionConflict = in.readBoolean();
     * Whether or not version conflicts cause the action to abort.  
        if (slices < 0) {
     */  
     */
     * Timeout to wait for the shards on to be available for each bulk request?
 * not use this file except in compliance with the License.
        return new BulkByScrollTask(id, type, action, getDescription(), parentTaskId, headers);
            .setShouldStoreResult(false)
        return self();
    /**  
        activeShardCount.writeTo(out);
 * license agreements. See the NOTICE file distributed with
    }  
 * @opensearch.internal
    public Self setRequestsPerSecond(float requestsPerSecond) {  
    public AbstractBulkByScrollRequest(SearchRequest searchRequest, boolean setDefaults) {
    public static final int DEFAULT_SCROLL_SIZE = 1000;  
    /**  
        out.writeVInt(maxDocs);
     * The number of slices this task should be divided into. Defaults to 1 meaning the task isn't sliced into subtasks.  
        return setMaxDocs(size);  
    /**
 */  
/*
        out.writeTimeValue(retryBackoffInitialTime);
    @Deprecated
            searchRequest.source(new SearchSourceBuilder());
        }
        if (maxDocs < slices) {
        this.timeout = TimeValue.parseTimeValue(timeout, this.timeout, getClass().getSimpleName() + ".timeout");
     * make sure that it contains any time that we might wait.
    public TimeValue getScrollTime() {
     */
    private ActiveShardCount activeShardCount = ActiveShardCount.DEFAULT;
     * Total number of retries attempted for rejections. There is no way to ask for unlimited retries.
    public Self setSize(int size) {
    /**  
    }
     */  
    public ActionRequestValidationException validate() {
    private boolean refresh = false;
 *
            e = addValidationError("retries cannot be negative", e);
    public Self setSlices(int slices) {  
        }  
        if (false == (maxDocs == -1 || maxDocs > 0)) {
     */
     * Timeout to wait for the shards on to be available for each bulk request?
 * Licensed to Elasticsearch under one or more contributor  
    public Self setAbortOnVersionConflict(boolean abortOnVersionConflict) {  
     * @deprecated please use setMaxDocs(int) instead.
    public void writeTo(StreamOutput out) throws IOException {  
    }  
import org.opensearch.core.common.io.stream.StreamOutput;
     * Setup a clone of this request with the information needed to process a slice of it.  
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}  
    @Deprecated  
    /**
        this.requestsPerSecond = requestsPerSecond;  
                e  
     * Maximum number of processed documents. Defaults to -1 meaning process all
 */
            e = addValidationError("can't specify both manual and automatic slicing at the same time", e);
    public Self setShouldStoreResult(boolean shouldStoreResult) {
     * default. Throttling is done between batches, as we start the next scroll requests. That way we can increase the scroll's timeout to  
        this.timeout = timeout;  
     * Append a short description of the search request to a StringBuilder. Used  
     * A shortcut for {@link #setWaitForActiveShards(ActiveShardCount)} where the numerical
     */
     * Sets abortOnVersionConflict based on REST-friendly names.  
        return request;  
    /**  
    @Override
 */
    protected void searchToString(StringBuilder b) {  
     *        request slicing  
    }  
        return this.toString();
     * @param searchRequest the search request to execute to get the documents to process
     * The search to be executed.
 * specific language governing permissions and limitations
            // down!  
        }
        }  
        }  
            // Split requests per second between all slices  
    public abstract Self forSlice(TaskId slicingTask, SearchRequest slice, int totalSlices);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return self();
}  
    public int getMaxRetries() {
 * ownership. Elasticsearch licenses this file to you under  
        if (searchRequest.source().storedFields() != null) {
     * Should this task store its result?
    public static final int MAX_DOCS_ALL_MATCHES = -1;
     */
        return getMaxDocs();
 * GitHub history for details.
    private int slices = DEFAULT_SLICES;  
        this.retryBackoffInitialTime = retryBackoffInitialTime;  
    }
        return self();  
            throw new IllegalArgumentException("[max_docs] parameter cannot be negative, found [" + maxDocs + "]");
     */  
 * compatible open source license.
     * The throttle for this request in sub-requests per second. {@link Float#POSITIVE_INFINITY} means set no throttle and that is the
    private float requestsPerSecond = Float.POSITIVE_INFINITY;
    public Self setWaitForActiveShards(ActiveShardCount activeShardCount) {
     * Set the initial delay after a rejection before retrying request.  
        return shouldStoreResult;
    private int maxRetries = 11;
        return self();  
        if (maxDocs != MAX_DOCS_ALL_MATCHES) {
import java.util.Arrays;  
     * Set scroll timeout for {@link SearchRequest}  
    /**
    /**
    /**
    @Deprecated
            default:
     * warnings.  
     * Get scroll timeout
import org.opensearch.action.search.SearchRequest;  
     * `this` cast to Self. Used for building fluent methods without cast
    public static final int AUTO_SLICES = 0;
        ActionRequestValidationException e = searchRequest.validate();  
        return maxRetries;
        return refresh;
    public int getSize() {  
     * is about one minute per bulk request. Once the entire bulk request is successful the retry counter resets.  
        this.abortOnVersionConflict = abortOnVersionConflict;
    /**  
     */
            .setWaitForActiveShards(activeShardCount)
     */
 * the Apache License, Version 2.0 (the "License"); you may
    public Self setTimeout(TimeValue timeout) {
import org.opensearch.common.unit.TimeValue;  
    public void setConflicts(String conflicts) {
            e = addValidationError("stored_fields is not supported in this context", e);
    }
        switch (conflicts) {  
    @Override  
    }
    public SearchRequest getSearchRequest() {  
    }
     * to get the ActiveShardCount.
        // Set the parent task so this task is cancelled if we cancel the parent  
     */
    }
        return setWaitForActiveShards(ActiveShardCount.from(waitForActiveShards));
            throw new IllegalArgumentException("Number of total slices must be at least 1 but was [" + totalSlices + "]");
        if (searchRequest.indices() != null && searchRequest.indices().length != 0) {
    /**
    private TimeValue retryBackoffInitialTime = timeValueMillis(500);
     * default. Throttling is done between batches, as we start the next scroll requests. That way we can increase the scroll's timeout to
import org.opensearch.search.builder.SearchSourceBuilder;
 * KIND, either express or implied.  See the License for the
    }
    /**
            throw new IllegalArgumentException(
    }
    /**
/*  
        return self();
import org.opensearch.tasks.Task;  
            .setRefresh(refresh)
     */  
     * Maximum number of processed documents. Defaults to -1 meaning process all
    public Self setWaitForActiveShards(final int waitForActiveShards) {  
     */  
    /**
        timeout = in.readTimeValue();
     * @deprecated please use MAX_DOCS_ALL_MATCHES instead.
        request.setAbortOnVersionConflict(abortOnVersionConflict)
     * Call refresh on the indexes we've written to after the request ends?
     */
    }
    private boolean shouldStoreResult;
     * Call refresh on the indexes we've written to after the request ends?
    }  
        searchRequest.writeTo(out);
     */  
    public float getRequestsPerSecond() {  
    /**
            e = addValidationError(
        return self();
    public boolean getShouldStoreResult() {
     * Maximum number of processed documents. Defaults to -1 meaning process all  
     * Timeout to wait for the shards on to be available for each bulk request?
        return timeout;
     */
    @Override
     */
        // Set the defaults which differ from SearchRequest's defaults.
    private TimeValue timeout = ReplicationRequest.DEFAULT_TIMEOUT;  
/*  
     */
        // TODO It'd be nice not to refresh on every slice. Instead we should refresh after the sub requests finish.
    }
    /**
    public Self setMaxRetries(int maxRetries) {
     * @param setDefaults should this request set the defaults on the search request? Usually set to true but leave it false to support
                setAbortOnVersionConflict(true);
        if (searchRequest.source().slice() != null && slices != DEFAULT_SLICES) {  
    @Override  
        request.setParentTask(slicingTask);
    }
        activeShardCount = ActiveShardCount.readFrom(in);  
        }  
     */
        requestsPerSecond = in.readFloat();  
    /**
     */
