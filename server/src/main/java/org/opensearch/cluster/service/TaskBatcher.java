            });
            this.batchingKey = batchingKey;
        @Override
        } catch (Exception e) {  
            throw e;
            processTasksBySource.computeIfAbsent(task.source, s -> new ArrayList<>()).add(task);  
                                + duplicateTask.source
 * Unless required by applicable law or agreed to in writing,
                : "tasks submitted in a batch should share the same batching key: " + tasks;
            LinkedHashSet<BatchedTask> pending = tasksPerBatchingKey.remove(updateTask.batchingKey);
                return "[" + source + "[" + taskDescription + "]]";
            });
                taskBatcherListener.onBeginProcessing(toExecute);  
import org.opensearch.common.Nullable;
 * Licensed to Elasticsearch under one or more contributor  
            // While removing task, need to remove task first from taskMap and then remove identity from identityMap.
        this.taskBatcherListener = taskBatcherListener;
            return tasks.isEmpty() ? entry.getKey() : entry.getKey() + "[" + tasks + "]";
                }
/**
    final Map<Object, Map<Object, BatchedTask>> taskIdentityPerBatchingKey = new ConcurrentHashMap<>();
                toRemoveIdentities.add(task.getTask());
         */  
                }
            final List<BatchedTask> toExecute = new ArrayList<>();
            // While removing task, need to remove task first from taskMap and then remove identity from identityMap.  
 * Tasks that share the same batching key are batched (see {@link BatchedTask#batchingKey})
    protected abstract void run(Object batchingKey, List<? extends BatchedTask> tasks, Function<Boolean, String> taskSummaryGenerator);  
     * All tasks have the same batching key.
 * not use this file except in compliance with the License.
        if (toRemove.isEmpty() == false) {
    }
        protected BatchedTask(Priority priority, String source, Object batchingKey, Object task) {  
 * this work for additional information regarding copyright
        } else {
/*  
        if (updateTask.processed.get() == false) {  
    public void submitTasks(List<? extends BatchedTask> tasks, @Nullable TimeValue timeout) throws OpenSearchRejectedExecutionException {
    protected abstract void onTimeout(List<? extends BatchedTask> tasks, TimeValue timeout);
                        throw new IllegalStateException(
        if (timeout != null) {
        this.logger = logger;  
 */
 * this file be licensed under the Apache-2.0 license or a
        public abstract String describeTasks(List<? extends BatchedTask> tasks);  
                            .limit(Math.min(1000, toExecute.size()))  
            // Changing this order might lead to duplicate tasks in queue.
import java.util.Map;
            : "tasks submitted in a batch should be of same class: " + tasks;
 * compatible open source license.
        }
                logger.debug("task [{}] timed out after [{}]", task.source, timeout);
                Function<Boolean, String> taskSummaryGenerator = (longSummaryRequired) -> {  
                };
                    // check that there won't be two tasks with the same identity for the same batching key
                    }
 * The OpenSearch Contributors require contributions made to  
                return existingIdentities;
                                + duplicateTask.describeTasks(Collections.singletonList(duplicateTask))  
     * Action to be implemented by the specific batching implementation  
import java.util.List;
 * software distributed under the License is distributed on an
/*
                        BatchedTask duplicateTask = newIdentities.get(newIdentity);  
            onTimeout(toRemove, timeout);
            BatchedTask firstTask = toRemove.get(0);
import java.util.stream.Collectors;  
    }
        }  
            // For insert: First insert identity in taskIdentity map with dup check and then insert task in taskMap.
 * specific language governing permissions and limitations
 *  
            } else {
            // For remove: First remove task from taskMap and then remove identity from taskIdentity map.
                    return getSummary(updateTask, toExecute);
                return "[" + source + "]";  
    void runIfNotProcessed(BatchedTask updateTask) {  
    final Map<Object, LinkedHashSet<BatchedTask>> tasksPerBatchingKey = new ConcurrentHashMap<>();
            }  
import org.opensearch.common.unit.TimeValue;
 * @opensearch.internal  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.concurrent.ConcurrentHashMap;  
                .collect(Collectors.toMap(BatchedTask::getTask, Function.identity(), (a, b) -> {
            if (toExecute.isEmpty() == false) {
        }
import java.util.LinkedHashSet;  
        }  
            // We are inserting identity first and removing at last to ensure no duplicate tasks are enqueued.  
package org.opensearch.cluster.service;
            + " and sample tasks: "
            }
                existingTasks.addAll(updatedTasks);  
        }
        for (BatchedTask task : tasks) {  
import java.util.IdentityHashMap;
            : "tasks submitted in a batch should share the same batching key: " + tasks;
                }  
        if (tasks.isEmpty()) {  
    /**
            LinkedHashSet<BatchedTask> newTasks = new LinkedHashSet<>(tasks);
        return "Tasks batched with key: "  
            tasksPerBatchingKey.computeIfPresent(batchingKey, (tasksKey, existingTasks) -> {
        return processTasksBySource.entrySet().stream().map(entry -> {
            String tasks = updateTask.describeTasks(entry.getValue());  
 *
import org.apache.logging.log4j.Logger;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
 * You may obtain a copy of the License at  
                for (BatchedTask task : pending) {
        /**
    private String buildShortSummary(final Object batchingKey, final int taskCount, final String sampleTasks) {
                for (Object newIdentity : newIdentities.keySet()) {  
        protected final Object task;
            + batchingKey.toString().split("\\$")[0]
            if (pending != null) {  
                        logger.trace("skipping {}, already processed", task);  
/*  
 * GitHub history for details.
        taskBatcherListener.onBeginSubmit(tasks);  
            this.task = task;  
            return;
        }
                    throw new IllegalStateException("cannot add duplicate task: " + a);  
            taskIdentityPerBatchingKey.remove(updateTask.batchingKey);
        for (final BatchedTask task : toExecute) {
                        final List<BatchedTask> sampleTasks = toExecute.stream()
            + taskCount  
 *     http://www.apache.org/licenses/LICENSE-2.0
        final ArrayList<Object> toRemoveIdentities = new ArrayList<>();
        final ArrayList<BatchedTask> toRemove = new ArrayList<>();
                toRemoveIdentities.stream().forEach(existingIdentities::remove);
     */  
    private final TaskBatcherListener taskBatcherListener;  
                    if (longSummaryRequired == null || !longSummaryRequired) {
            // since we have checked for dup tasks in above map, we can add all new task in map.
 * under the License.  
            }  
    private final PrioritizedOpenSearchThreadPoolExecutor threadExecutor;
    // package visible for tests  
     * Action to be implemented by the specific batching implementation.
import org.opensearch.common.util.concurrent.PrioritizedOpenSearchThreadPoolExecutor;
            tasksPerBatchingKey.merge(firstTask.batchingKey, newTasks, (existingTasks, updatedTasks) -> {
            // Changing this order might lead to duplicate task during submission.
                existingIdentities.putAll(newIdentities);
     * Implementors of TaskBatcher can subclass this to add a payload to the task.
import java.util.Collections;  
     * Represents a runnable task that supports batching.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                existingTasks.removeAll(toRemove);  
            taskIdentityPerBatchingKey.computeIfPresent(batchingKey, (tasksKey, existingIdentities) -> {  
        public void run() {
import java.util.concurrent.atomic.AtomicBoolean;
            if (taskDescription.isEmpty()) {
                                + "] with source ["
    }
    private String getSummary(final BatchedTask updateTask, final List<BatchedTask> toExecute) {  
                        toExecute.add(task);
                    if (existingIdentities.containsKey(newIdentity)) {
         * whether the task has been processed already
            if (task.processed.getAndSet(true) == false) {
    public TaskBatcher(Logger logger, PrioritizedOpenSearchThreadPoolExecutor threadExecutor, TaskBatcherListener taskBatcherListener) {
    }  
        final Map<String, List<BatchedTask>> processTasksBySource = new HashMap<>();
        try {
            Object batchingKey = firstTask.batchingKey;  
        protected final Object batchingKey;  
            threadExecutor.execute(firstTask);
        }).reduce((s1, s2) -> s1 + ", " + s2).orElse("");
                    }  
import java.util.HashMap;
    }
        public String toString() {  
         * the object that is used as batching key
                        logger.trace("will process {}", task);  
    private final Logger logger;
    protected abstract class BatchedTask extends SourcePrioritizedRunnable {  
 */
                }  
    /**
     */
import org.opensearch.common.Priority;  
                    }
            threadExecutor.execute(firstTask, timeout, () -> onTimeoutInternal(tasks, timeout));  
                if (existingTasks.isEmpty()) {
                if (existingIdentities.isEmpty()) {
        @Override  
        }  
            assert tasks.stream().allMatch(t -> t.batchingKey == batchingKey)
 */  
                            .collect(Collectors.toList());
            String taskDescription = describeTasks(Collections.singletonList(this));
        }  
 *
    }  
}  
public abstract class TaskBatcher {
     */
                return existingTasks;
                        );
        /**
            // convert to an identity map to check for dups based on task identity  
                    return null;
            });  
        }
        protected final AtomicBoolean processed = new AtomicBoolean();
        this.threadExecutor = threadExecutor;
import java.util.ArrayList;
                    if (task.processed.getAndSet(true) == false) {
                            "task ["
            + sampleTasks;
 */  
        assert tasks.stream().allMatch(t -> t.batchingKey == firstTask.batchingKey)
         */  
     * All tasks have the given batching key.
 * ownership. Elasticsearch licenses this file to you under  
        }  
                    } else {
            return task;  
                        return buildShortSummary(updateTask.batchingKey, toExecute.size(), getSummary(updateTask, sampleTasks));
        }  
            // Changing this order might lead to duplicate task during submission.  
 * SPDX-License-Identifier: Apache-2.0
            final Map<Object, BatchedTask> tasksIdentity = tasks.stream()
            // Need to maintain below order in which task identity map and task map are updated.  
            });  
    }  
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
            }
        assert tasks.stream().allMatch(t -> t.getTask().getClass() == firstTask.getTask().getClass())  
         * the task object that is wrapped
        // to give other tasks with different batching key a chance to execute.
import java.util.function.Function;
                return existingIdentities;
            taskBatcherListener.onSubmitFailure(tasks);
            super(priority, source);
            + ", count:"
                run(updateTask.batchingKey, toExecute, taskSummaryGenerator);
         */
                toRemove.add(task);  
        // if this task is already processed, it shouldn't execute other tasks with same batching key that arrived later,
            runIfNotProcessed(this);
 *
            taskBatcherListener.onTimeout(toRemove);
        final BatchedTask firstTask = tasks.get(0);  
 * license agreements. See the NOTICE file distributed with
                    return null;  
    void onTimeoutInternal(List<? extends BatchedTask> tasks, TimeValue timeout) {  
    /**  
                }, IdentityHashMap::new));
                                + "] is already queued"  
        /**  
        public Object getTask() {
            taskIdentityPerBatchingKey.merge(firstTask.batchingKey, tasksIdentity, (existingIdentities, newIdentities) -> {
 * Batching support for {@link PrioritizedOpenSearchThreadPoolExecutor}  
                return existingTasks;
