 */
    private final SetOnce<CancelledInfo> cancelledInfo = new SetOnce<>();
    public Long getCancellationStartTime() {
 */  
        CancelledInfo info = cancelledInfo.get();  
        TimeValue cancelAfterTimeInterval
    public CancellableTask(long id, String type, String action, String description, TaskId parentTaskId, Map<String, String> headers) {
    }
        this.cancelAfterTimeInterval = cancelAfterTimeInterval;
        CancelledInfo info = cancelledInfo.get();  
 * this file be licensed under the Apache-2.0 license or a
         */
import org.opensearch.core.tasks.TaskId;
 * ownership. Elasticsearch licenses this file to you under  
 *  
     */
 * under the License.  
import java.util.Map;  
        TaskId parentTaskId,
public abstract class CancellableTask extends Task {  
 * You may obtain a copy of the License at  
    public String getReasonCancelled() {
        this(id, type, action, description, parentTaskId, headers, NO_TIMEOUT);  
        Long cancellationStartTimeNanos;
        }
    private static class CancelledInfo {
 * A task that can be canceled
        return true;
     * The reason the task was cancelled or null if it hasn't been cancelled.
    public void cancel(String reason) {
    /**  
    /**
 * specific language governing permissions and limitations
    protected void onCancelled() {}  
        String description,
    }
 * Licensed to Elasticsearch under one or more contributor  
        return (info != null) ? info.cancellationStartTime : null;
        long id,
     * requested this task left the cluster.
        public CancelledInfo(String reason) {
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
        /**
    @Nullable
    public TimeValue getCancellationTimeout() {
    }
    /**
    }  
/**
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**  
    }
     */
        CancelledInfo info = cancelledInfo.get();  
 * Unless required by applicable law or agreed to in writing,
        Long cancellationStartTime;
 */  
     */  
        Map<String, String> headers,  
     */  
    public abstract boolean shouldCancelChildrenOnCancellation();  
    }  
     * Returns true if this task should be automatically cancelled if the coordinating node that  
 * GitHub history for details.
/*  
import org.opensearch.common.unit.TimeValue;  
import org.opensearch.common.SetOnce;
        if (cancelledInfo.trySet(new CancelledInfo(reason))) {  
        /**
/*  
        return cancelAfterTimeInterval;  
        return cancelledInfo.get() != null;  
 */
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.tasks;
         * The time this task was cancelled as a relative time ({@link System#nanoTime()} style).  
    @Nullable
    public CancellableTask(  
    }
        return (info != null) ? info.reason : null;
    public boolean isCancelled() {
        String reason;  
         */  
     */
 *
    @Nullable
            onCancelled();
 * compatible open source license.
     * Returns true if this task can potentially have children that need to be cancelled when it parent is cancelled.
     * Called after the task is cancelled so that it can take any actions that it has to take.
        assert reason != null;
 * license agreements. See the NOTICE file distributed with
            this.cancellationStartTimeNanos = System.nanoTime();
        String action,  
 *  
        return (info != null) ? info.cancellationStartTimeNanos : null;
    public Long getCancellationStartTimeNanos() {
 * @opensearch.internal
    private final TimeValue cancelAfterTimeInterval;  
            this.reason = reason;
            this.cancellationStartTime = System.currentTimeMillis();  
         * The time this task was cancelled as a wall clock time since epoch ({@link System#currentTimeMillis()} style).
 *
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.search.SearchService.NO_TIMEOUT;
     * This method is called by the task manager when this task is cancelled.
 * software distributed under the License is distributed on an
        super(id, type, action, description, parentTaskId, headers);  
        String type,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
    /**
}  
    }
    }
    ) {
 * The OpenSearch Contributors require contributions made to  
    }
    public boolean cancelOnParentLeaving() {  
import org.opensearch.common.Nullable;
 * Modifications Copyright OpenSearch Contributors. See
/*
