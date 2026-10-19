 * this work for additional information regarding copyright
                assert t.failure != null : "exception shouldn't be null if value is null";
        this.slices = slices;
            this.failure = failure;
    }  
        final Exception failure;
        results = new AtomicArray<>(slices);  
        }  
        Exception exception = null;
            }
        final BulkByScrollResponse response;
    }
/**
 * this file be licensed under the Apache-2.0 license or a
import java.util.ArrayList;
 *  
     * Get the combined statuses of slice subtasks, merged with the given list of statuses  
    private void recordSliceCompletionAndRespondIfAllDone(ActionListener<BulkByScrollResponse> listener) {  
     */  
        results.setOnce(sliceId, new Result(sliceId, response));  
    public int runningSliceSubTasks() {  
 * Tracks the state of sliced subtasks and provides unified status information for a sliced BulkByScrollRequest.  
 * not use this file except in compliance with the License.
    }  
         * were fairly sure they had a while left to go. */
 * You may obtain a copy of the License at  
    /**
    private static final class Result {
import java.util.List;  
 */  
    }
            listener.onFailure(exception);
            } else {
                } else {
     * The number of sliced subtasks that are still running
                responses.add(t.response);
                sliceStatuses.set(t.sliceId, new BulkByScrollTask.StatusOrException(t.response.getStatus()));
    /**
    private final BulkByScrollTask task;  
        return slices;
     * Holds the responses of slice workers as they come in
    /**
        this.task = task;
import org.opensearch.core.action.ActionListener;
 *
 */
        if (exception == null) {
        recordSliceCompletionAndRespondIfAllDone(listener);  
 *
    /**  
        /* If the request isn't finished we could automatically rethrottle the sub-requests here but we would only want to do that if we
    public BulkByScrollTask.Status getStatus(List<BulkByScrollTask.StatusOrException> statuses) {
/*  
        results.setOnce(sliceId, new Result(sliceId, e));
        for (Result t : results.asList()) {  
        addResultsToList(statuses);
     */
            this.response = response;
        final int sliceId;  
        return getStatus(Arrays.asList(new BulkByScrollTask.StatusOrException[results.length()]));  
            listener.onResponse(new BulkByScrollResponse(responses, task.getReasonCancelled()));
 */  
    private void addResultsToList(List<BulkByScrollTask.StatusOrException> sliceStatuses) {
     */
    public BulkByScrollTask.Status getStatus() {
 * GitHub history for details.
     */  
 *
        return runningSubtasks.get();
    }
import static java.util.Collections.unmodifiableList;  
                    exception = t.failure;
        private Result(int sliceId, Exception failure) {  
     */
}  
            return;
        if (runningSubtasks.decrementAndGet() != 0) {
        }
            throw new IllegalArgumentException("Given number of statuses does not match amount of expected results");
    private final int slices;
            this.sliceId = sliceId;
     * Record a failure from a slice and respond to the listener if the request is finished.
        for (Result t : results.asList()) {
     * Record a response from a slice and respond to the listener if the request is finished.  
    /**  
 * the Apache License, Version 2.0 (the "License"); you may
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        runningSubtasks = new AtomicInteger(slices);
package org.opensearch.index.reindex;
     */  
/*
     */
        private Result(int sliceId, BulkByScrollResponse response) {  
    public void onSliceResponse(ActionListener<BulkByScrollResponse> listener, int sliceId, BulkByScrollResponse response) {
    public int getSlices() {
                if (exception == null) {  
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Get the combined statuses of sliced subtasks  
                }
 * specific language governing permissions and limitations
        }
 * software distributed under the License is distributed on an
import java.util.concurrent.atomic.AtomicInteger;
    /**
        } else {  
    }
        }
    public LeaderBulkByScrollTaskState(BulkByScrollTask task, int slices) {  
        // TODO cancel when a slice fails?  
    public void onSliceFailure(ActionListener<BulkByScrollResponse> listener, int sliceId, Exception e) {  
 * The OpenSearch Contributors require contributions made to  
            if (t.response == null) {
            if (t.response != null) {  
        }  
    }  
        recordSliceCompletionAndRespondIfAllDone(listener);
            } else {
 * ownership. Elasticsearch licenses this file to you under  
 */  
    /**  
    private final AtomicArray<Result> results;  
    }
        return new BulkByScrollTask.Status(unmodifiableList(statuses), task.getReasonCancelled());
        }  
     * How many subtasks are still running
    }  
        // We only have access to the statuses of requests that have finished so we return them  
     * Returns the number of slices this BulkByScrollRequest will use
import org.opensearch.common.util.concurrent.AtomicArray;
     */
     */
 * Modifications Copyright OpenSearch Contributors. See
    }
                sliceStatuses.set(t.sliceId, new BulkByScrollTask.StatusOrException(t.failure));  
 * under the License.  
public class LeaderBulkByScrollTaskState {
 * license agreements. See the NOTICE file distributed with
            this.sliceId = sliceId;
            response = null;  
            }
 * @opensearch.internal
/*  
     * Result  
     *
import java.util.Arrays;
        if (statuses.size() != results.length()) {
                    exception.addSuppressed(t.failure);  
            failure = null;  
                assert t.failure == null : "exception should be null if response is not null";  
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
     * @opensearch.internal
    private final AtomicInteger runningSubtasks;
        }
 * Unless required by applicable law or agreed to in writing,
        List<BulkByScrollResponse> responses = new ArrayList<>(results.length());
 * SPDX-License-Identifier: Apache-2.0
