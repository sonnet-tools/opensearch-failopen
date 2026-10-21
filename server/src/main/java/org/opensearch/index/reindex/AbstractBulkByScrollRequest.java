    public AbstractBulkByScrollRequest(StreamInput in) throws IOException {
    protected abstract Self self();
        super.writeTo(out);
     * Should this task store its result?
        out.writeBoolean(refresh);
    protected void searchToString(StringBuilder b) {
    public Self setAbortOnVersionConflict(boolean abortOnVersionConflict) {
        return shouldStoreResult;
 *
        this.slices = slices;
            .setSlices(1);
     */
    private int maxRetries = 11;
     * Call refresh on the indexes we've written to after the request ends?
    }
    public Self setTimeout(String timeout) {
    public static final int DEFAULT_SCROLL_SIZE = 1000;
            b.append("[all indices]");
     */
    }
     */
        return slices;
     * make sure that it contains any time that we might wait.
 * Modifications Copyright OpenSearch Contributors. See
    }
    /**
        this.activeShardCount = activeShardCount;
     * documents.
        searchRequest.scroll(new Scroll(keepAlive));
        this.maxRetries = maxRetries;
     */
     * Timeout to wait for the shards on to be available for each bulk request?
        out.writeVInt(maxDocs);
    /**
    public TimeValue getScrollTime() {
     */
    public Self setScroll(TimeValue keepAlive) {
        }
     * to get the ActiveShardCount.
     * Timeout to wait for the shards on to be available for each bulk request?
     */
        return e;
                "[requests_per_second] must be greater than 0. Use Float.POSITIVE_INFINITY to disable throttling."
 * this work for additional information regarding copyright
                return;
import org.opensearch.search.builder.SearchSourceBuilder;
            .setRefresh(refresh)
    }
     * The number of slices this task should be divided into. Defaults to 1 meaning the task isn't sliced into subtasks.
    /**
 * this file be licensed under the Apache-2.0 license or a
        if (slices < 0) {
    public Self setTimeout(TimeValue timeout) {
    public ActiveShardCount getWaitForActiveShards() {
        return self();
     */
    }
    private static final int DEFAULT_SLICES = 1;
        }
    /**
    @Override
        // Set the defaults which differ from SearchRequest's defaults.
 * ownership. Elasticsearch licenses this file to you under
     */
    public TimeValue getRetryBackoffInitialTime() {
    }
    public String getDescription() {
            throw new IllegalArgumentException("[max_docs] should be >= [slices]");
     * Maximum number of processed documents. Defaults to -1 meaning process all
     */
            searchRequest.source(new SearchSourceBuilder());
        requestsPerSecond = in.readFloat();
        out.writeFloat(requestsPerSecond);
        out.writeVInt(slices);
        return refresh;
    }
 * GitHub history for details.
                setAbortOnVersionConflict(true);
                return;
     */
 * license agreements. See the NOTICE file distributed with
    public TimeValue getTimeout() {
        return self();
        return getMaxDocs();
 * Base class for requesting bulk by scrolls
     */
    @Override
 * compatible open source license.
    }
        return setWaitForActiveShards(ActiveShardCount.from(waitForActiveShards));
/*
     * Setup a clone of this request with the information needed to process a slice of it.
        }
    @Override
        if (maxDocs < 0) {
        }
    public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
     * @deprecated please use setMaxDocs(int) instead.
     */
    }
import org.opensearch.core.tasks.TaskId;
import org.opensearch.common.unit.TimeValue;
        return activeShardCount;
    public static final int SIZE_ALL_MATCHES = MAX_DOCS_ALL_MATCHES;
            .setWaitForActiveShards(activeShardCount)
        if (maxDocs != MAX_DOCS_ALL_MATCHES) {
            // Sub requests don't have workers
     * Initial delay after a rejection before retrying a bulk request. With the default maxRetries the total backoff for retrying rejections
     */
 * The OpenSearch Contributors require contributions made to
        slices = in.readVInt();
     */
     * documents.
    /**
     */
        activeShardCount.writeTo(out);
    /**
    public boolean getShouldStoreResult() {
            throw new IllegalArgumentException("[max_docs] parameter cannot be negative, found [" + maxDocs + "]");
     * The throttle for this request in sub-requests per second. {@link Float#POSITIVE_INFINITY} means set no throttle and that is the
    }
            e = addValidationError("retries cannot be negative", e);
        return self();
        maxRetries = in.readVInt();
        return request;
        request.setAbortOnVersionConflict(abortOnVersionConflict)
        }
    }
/*
     * Set scroll timeout for {@link SearchRequest}
     * Call refresh on the indexes we've written to after the request ends?
    public boolean isRefresh() {
    }
     * @param setDefaults should this request set the defaults on the search request? Usually set to true but leave it false to support
        }
            e = addValidationError(
     */
            .setRequestsPerSecond(requestsPerSecond / totalSlices)
    }
    @Override
    /**
    /**
        if (searchRequest.source().from() != -1) {
 * software distributed under the License is distributed on an
        return searchRequest.scroll().keepAlive();
            // maxDocs is split between workers. This means the maxDocs might round
        maxDocs = in.readVInt();
        if (setDefaults) {
        }
    /**
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;
    /**
     */
     * Build a new request for a slice of the parent request.
     * documents.
import org.opensearch.action.search.SearchRequest;
package org.opensearch.index.reindex;
                e
        abortOnVersionConflict = in.readBoolean();
        return self();
 * KIND, either express or implied.  See the License for the
            throw new IllegalArgumentException(
    }
    /**
    public static final int MAX_DOCS_ALL_MATCHES = -1;
        this.timeout = TimeValue.parseTimeValue(timeout, this.timeout, getClass().getSimpleName() + ".timeout");
    /**
        }
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
    /**
     */
    /**
    }
    }
     * `this` cast to Self. Used for building fluent methods without cast
        this.searchRequest = searchRequest;
        if (maxDocs < slices) {
        this.retryBackoffInitialTime = retryBackoffInitialTime;
        out.writeTimeValue(timeout);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public static final String AUTO_SLICES_VALUE = "auto";
     * Append a short description of the search request to a StringBuilder. Used
 * not use this file except in compliance with the License.
        return new BulkByScrollTask(id, type, action, getDescription(), parentTaskId, headers);
                throw new IllegalArgumentException("conflicts may only be \"proceed\" or \"abort\" but was [" + conflicts + "]");
        return self();
     */
    private boolean abortOnVersionConflict = true;
    }
import static org.opensearch.action.ValidateActions.addValidationError;
    }
     *
    private int slices = DEFAULT_SLICES;
            e = addValidationError("stored_fields is not supported in this context", e);
            // Parent task will store result
    /**
        }
    public int getSlices() {
     */
    }
import org.opensearch.action.support.replication.ReplicationRequest;
/**
import org.opensearch.action.ActionRequest;
    }
    public Self setSize(int size) {
 * specific language governing permissions and limitations
    /**
    public Self setRequestsPerSecond(float requestsPerSecond) {
                    + maxDocs
    public float getRequestsPerSecond() {
    private boolean refresh = false;
        this.shouldStoreResult = shouldStoreResult;
    public void writeTo(StreamOutput out) throws IOException {
        return maxDocs;
import org.opensearch.action.ActionRequestValidationException;
public abstract class AbstractBulkByScrollRequest<Self extends AbstractBulkByScrollRequest<Self>> extends ActionRequest {
        if (searchRequest.source().slice() != null && slices != DEFAULT_SLICES) {
    }
     * @deprecated please use MAX_DOCS_ALL_MATCHES instead.
     * documents.
     */
    }
    }
    }
     * Set the initial delay after a rejection before retrying request.
     */
    /**
import java.util.Map;
 *
    protected Self doForSlice(Self request, TaskId slicingTask, int totalSlices) {
    }
    /**
 */
        return setMaxDocs(size);
     * Total number of retries attempted for rejections. There is no way to ask for unlimited retries.
    }
    /**
            case "proceed":
    }
 */
    }
    /**
     * A shortcut for {@link #setWaitForActiveShards(ActiveShardCount)} where the numerical
        activeShardCount = ActiveShardCount.readFrom(in);
        if (maxRetries < 0) {
     * The search request that matches the documents to process.
    /**
     */
    public void setConflicts(String conflicts) {
    private boolean shouldStoreResult;
     * Timeout to wait for the shards on to be available for each bulk request?
    public Self setMaxRetries(int maxRetries) {
        return abortOnVersionConflict;
    public Self setRefresh(boolean refresh) {
    public int getMaxDocs() {
     * Set whether or not version conflicts cause the action to abort.
    /**
     * A value of 0 is equivalent to the "auto" slices parameter of the Rest API.
        return self();
     */
        out.writeTimeValue(retryBackoffInitialTime);
    @Deprecated
     * Set the total number of retries attempted for rejections. There is no way to ask for unlimited retries.
            // down!
     */
    @Deprecated
 * You may obtain a copy of the License at
    }
        out.writeBoolean(abortOnVersionConflict);
        this.timeout = timeout;
 * Unless required by applicable law or agreed to in writing,
        if (searchRequest.source().storedFields() != null) {
     * to make toString.
        return requestsPerSecond;
            default:
        return self();
    }
    /**
    }
import java.io.IOException;
     * Sets the number of shard copies that must be active before proceeding with the write.
    /**
    public int getSize() {
     * Timeout to wait for the shards on to be available for each bulk request?
        } else {
 * under the License.
/*
        // Set the parent task so this task is cancelled if we cancel the parent
     * Maximum number of processed documents. Defaults to -1 meaning process all
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Maximum number of processed documents. Defaults to -1 meaning process all
     */
        return self();
            searchRequest.scroll(DEFAULT_SCROLL_TIMEOUT);
     * The throttle for this request in sub-requests per second. {@link Float#POSITIVE_INFINITY} means set no throttle and that is the
        this.abortOnVersionConflict = abortOnVersionConflict;
import java.util.Arrays;
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}
     */
        super(in);
    private TimeValue timeout = ReplicationRequest.DEFAULT_TIMEOUT;
     * make sure that it contains any time that we might wait.
}
 * SPDX-License-Identifier: Apache-2.0
     * Constructor for actual use.
     * The number of shard copies that must be active before proceeding with the write.
            searchRequest.source().size(DEFAULT_SCROLL_SIZE);
    private TimeValue retryBackoffInitialTime = timeValueMillis(500);
    private int maxDocs = MAX_DOCS_ALL_MATCHES;
        // TODO It'd be nice not to refresh on every slice. Instead we should refresh after the sub requests finish.
            );
     * warnings.
    /**
        timeout = in.readTimeValue();
        }
    /**
    /**
    public abstract Self forSlice(TaskId slicingTask, SearchRequest slice, int totalSlices);
     */
 * the Apache License, Version 2.0 (the "License"); you may
        switch (conflicts) {
import org.opensearch.core.common.io.stream.StreamInput;
     *        request slicing
     */
    public static final TimeValue DEFAULT_SCROLL_TIMEOUT = timeValueMinutes(5);
    /**
    /**
import static org.opensearch.common.unit.TimeValue.timeValueMinutes;
     * default. Throttling is done between batches, as we start the next scroll requests. That way we can increase the scroll's timeout to
    /**
            e = addValidationError("from is not supported in this context", e);
                "maxDocs should be greater than 0 if the request is limited to some number of documents or -1 if it isn't but it was ["
        if (searchRequest.indices() != null && searchRequest.indices().length != 0) {
import org.opensearch.tasks.Task;
     */
    /**
     */
        return self();
            .setMaxRetries(maxRetries)
     */
    /**
        request.setParentTask(slicingTask);
     */
    public ActionRequestValidationException validate() {
import org.opensearch.search.Scroll;
        refresh = in.readBoolean();
     * The number of slices this task should be divided into. Defaults to 1 meaning the task isn't sliced into subtasks.
     * make sure that it contains any time that we might wait.
        }
     * The search to be executed.
 * Licensed to Elasticsearch under one or more contributor
        return self();
     * Sets abortOnVersionConflict based on REST-friendly names.
import org.opensearch.action.support.ActiveShardCount;
            case "abort":
    private ActiveShardCount activeShardCount = ActiveShardCount.DEFAULT;
        return self();
        this.requestsPerSecond = requestsPerSecond;
    /**
    public Self setShouldStoreResult(boolean shouldStoreResult) {
            throw new IllegalArgumentException("[slices] must be at least 0 but was [" + slices + "]");
     */
    /**
            // Split requests per second between all slices
    /**
     * @param searchRequest the search request to execute to get the documents to process
        searchRequest = new SearchRequest(in);
        return self();
    /**
     * @deprecated please use getMaxDocs() instead.
     */
    public SearchRequest getSearchRequest() {
     * Maximum number of processed documents. Defaults to -1 meaning process all
     * Get scroll timeout
     *
     * See {@link ReplicationRequest#waitForActiveShards(ActiveShardCount)} for details.
        searchRequest.writeTo(out);
        ActionRequestValidationException e = searchRequest.validate();
    }
     */
            e = addValidationError("can't specify both manual and automatic slicing at the same time", e);
    public Self setSlices(int slices) {
            .setRetryBackoffInitialTime(retryBackoffInitialTime)
     * default. Throttling is done between batches, as we start the next scroll requests. That way we can increase the scroll's timeout to
 *
        }
     * Initial delay after a rejection before retrying request.
            throw new IllegalArgumentException("Number of total slices must be at least 1 but was [" + totalSlices + "]");
     * Set the throttle for this request in sub-requests per second. {@link Float#POSITIVE_INFINITY} means set no throttle and that is the
     * documents.
        return searchRequest;
     */
     * The number of shard copies that must be active before proceeding with the write.
        this.refresh = refresh;
    @Deprecated
     */
     * default. Throttling is done between batches, as we start the next scroll requests. That way we can increase the scroll's timeout to
    public Self setMaxDocs(int maxDocs) {
     * The number of slices this task should be divided into. Defaults to 1 meaning the task isn't sliced into subtasks.
    public AbstractBulkByScrollRequest(SearchRequest searchRequest, boolean setDefaults) {
    /**
 *
     * Maximum number of processed documents. Defaults to -1 meaning process all
    public Self setWaitForActiveShards(final int waitForActiveShards) {
    private SearchRequest searchRequest;
     */
        return maxRetries;
        if (false == (maxDocs == -1 || maxDocs > 0)) {
            b.append(Arrays.toString(searchRequest.indices()));
     * Should version conflicts cause aborts? Defaults to true.
     */
        return timeout;
    private float requestsPerSecond = Float.POSITIVE_INFINITY;
    public static final int AUTO_SLICES = 0;
    /**
            .setShouldStoreResult(false)
    public int getMaxRetries() {
            );
    }
    /**
        }
     */
     * Whether or not version conflicts cause the action to abort.
 */
    }
    /**
 */
        return this.toString();
    public Self setRetryBackoffInitialTime(TimeValue retryBackoffInitialTime) {
 * @opensearch.internal
        return retryBackoffInitialTime;
        this.maxDocs = maxDocs;
    }
        if (requestsPerSecond <= 0) {
     * is about one minute per bulk request. Once the entire bulk request is successful the retry counter resets.
    /**
     * Should this task store its result after it has finished?
        retryBackoffInitialTime = in.readTimeValue();
    public boolean isAbortOnVersionConflict() {
     * Call refresh on the indexes we've written to after the request ends?
        }
     */
     * Total number of retries attempted for rejections.
    }
            request.setMaxDocs(maxDocs / totalSlices);
        out.writeVInt(maxRetries);
                setAbortOnVersionConflict(false);
        if (totalSlices < 1) {
    public Self setWaitForActiveShards(ActiveShardCount activeShardCount) {
    /**
    /**
                    + "]",
    /**
     */
            .setTimeout(timeout)
