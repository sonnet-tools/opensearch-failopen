package org.opensearch.persistent;
                                logger.warn(
/*
    }
    public void updatePersistentTaskState(
        return state.get() == State.COMPLETED;  
 *
     *  
        final State prevState = state.getAndSet(State.COMPLETED);
    ) {
        long allocationId
        completeAndNotifyIfNeeded(null);
    private volatile TaskManager taskManager;
    private volatile String persistentTaskId;
                        getPersistentTaskId(),
    private volatile @Nullable Exception failure;  
        PENDING_CANCEL, // the task is cancelled on master, cancelling it locally
 */
import org.opensearch.common.unit.TimeValue;
                                        "notification for task [{}] with id [{}] failed",  
    }
    // because in case of persistent task the parent task isn't a task in the task manager, but in cluster state.
}
 * Unless required by applicable law or agreed to in writing,
        } else {
        super(id, type, action, description, parentTask, headers);  
    public void markAsCompleted() {
    public void markAsFailed(Exception e) {
    private static final Logger logger = LogManager.getLogger(AllocatedPersistentTask.class);
    public String getPersistentTaskId() {
 * The OpenSearch Contributors require contributions made to  
    public AllocatedPersistentTask(
    @Override
    boolean markAsCancelled() {  
                                logger.trace("notification for task [{}] with id [{}] was successful", getAction(), getPersistentTaskId());
    }
    ) {
        return persistentTaskId;  
    }  
    }
     * @param timeout a timeout for waiting  
    public Status getStatus() {
    }
import org.apache.logging.log4j.Logger;
    private void completeAndNotifyIfNeeded(@Nullable Exception failure) {
                            }  
 *
import java.util.concurrent.atomic.AtomicReference;  
                                    ),  
     * This doesn't affect the status of this allocated task.
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
    }  
import org.apache.logging.log4j.LogManager;  
    private volatile PersistentTasksService persistentTasksService;
     */
                    );
                        }
     * Waits for a given persistent task to comply with a given predicate, then call back the listener accordingly.  
    @Override  
        PersistentTasksService persistentTasksService,
 *
        final PersistentTaskState state,
 */
        this.persistentTasksService = persistentTasksService;  
        COMPLETED     // the task is done running and trying to notify caller  
    }
 * @opensearch.internal  
                taskManager.unregister(this);
                }  
    // a fake parent node id "cluster" in the cluster state  
        return new PersistentTasksNodeService.Status(state.get());
 */  
 * You may obtain a copy of the License at  
        persistentTasksService.sendUpdateStateRequest(persistentTaskId, allocationId, state, listener);
        String description,
                            public void onResponse(PersistentTasksCustomMetadata.PersistentTask<?> persistentTask) {
    public boolean shouldCancelChildrenOnCancellation() {
        Map<String, String> headers
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
        this.allocationId = allocationId;  
        STARTED,  // the task is currently running
        String type,  
import org.opensearch.tasks.CancellableTask;
public class AllocatedPersistentTask extends CancellableTask {
                            public void onFailure(Exception e) {  
                            @Override  
/*  
        TaskId parentTask,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
    // In case of persistent tasks we always need to return: `false`  
/**  
        this.persistentTaskId = persistentTaskId;
import org.apache.logging.log4j.message.ParameterizedMessage;
    }
/*
                                );
 * this work for additional information regarding copyright
    /**
 * software distributed under the License is distributed on an
        TaskManager taskManager,
        }
                            @Override
import org.opensearch.core.tasks.TaskId;
 * Modifications Copyright OpenSearch Contributors. See  
 * the Apache License, Version 2.0 (the "License"); you may
                                        getAction(),
    protected final boolean isCompleted() {
        if (CancelTasksRequest.DEFAULT_REASON.equals(getReasonCancelled())) {  
        final ActionListener<PersistentTasksCustomMetadata.PersistentTask<?>> listener  
 */
        long id,
    public enum State {  
     * @param listener the callback listener
                        failure,
 * not use this file except in compliance with the License.
     */  
 *  
 * Licensed to Elasticsearch under one or more contributor  
    /**
    }
            completeAndNotifyIfNeeded(e);  
import org.opensearch.core.action.ActionListener;  
 * specific language governing permissions and limitations
                                        getPersistentTaskId()
                            }  
 * SPDX-License-Identifier: Apache-2.0
    /**
    public Exception getFailure() {  
    // This instructs the task manager not to try to kill this persistent task when the task manager cannot find
        persistentTasksService.waitForPersistentTaskCondition(persistentTaskId, predicate, timeout, listener);
 * Represents a executor node operation that corresponds to a persistent task
    protected void init(  
            if (failure != null) {  
        return allocationId;
        final Predicate<PersistentTasksCustomMetadata.PersistentTask<?>> predicate,
                                    () -> new ParameterizedMessage(
        String action,
    public long getAllocationId() {
                        getAllocationId(),  
                logger.warn(() -> new ParameterizedMessage("task {} failed with an exception", getPersistentTaskId()), failure);
     * @opensearch.internal
     *
import java.util.Map;
    private volatile long allocationId;
 * GitHub history for details.
        return true;  
 * ownership. Elasticsearch licenses this file to you under  
    }
    }
            }
        final @Nullable TimeValue timeout,
     */
        return state.compareAndSet(State.STARTED, State.PENDING_CANCEL);
     * @param predicate the persistent task predicate to evaluate
                this.failure = failure;
    }  
        return false;  
        } else {
     * Updates the persistent state for the corresponding persistent task.  
            } finally {
    public void waitForPersistentTask(  
import org.opensearch.tasks.TaskManager;  
            try {  
        this.state = new AtomicReference<>(State.STARTED);
                    logger.trace("sending notification for completed task [{}] with id [{}]", getAction(), getPersistentTaskId());  
 * license agreements. See the NOTICE file distributed with
            }  
        this.taskManager = taskManager;
    ) {
        String persistentTaskId,  
     * The state of the task.
 * this file be licensed under the Apache-2.0 license or a
                        new ActionListener<PersistentTasksCustomMetadata.PersistentTask<?>>() {
                if (prevState == State.STARTED) {
     * <p>
                                    e
            completeAndNotifyIfNeeded(null);
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;  
            logger.warn("attempt to complete task [{}] with id [{}] in the [{}] state", getAction(), getPersistentTaskId(), prevState);
        if (prevState == State.COMPLETED) {  
import org.opensearch.common.Nullable;
                    persistentTasksService.sendCompletionRequest(
        return failure;
import java.util.function.Predicate;
    public final boolean cancelOnParentLeaving() {
    @Override
        final PersistentTasksService.WaitForPersistentTaskListener<?> listener  
        }
    }
    private final AtomicReference<State> state;
    ) {
