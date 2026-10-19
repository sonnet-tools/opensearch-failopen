            this.resultingState = resultingState;  
            return new TaskResult(failure);
            assert !isSuccess();
        }
     * Represents the result of a batched execution of cluster state update tasks
     * @opensearch.internal
        public final ClusterState resultingState;  
 *
     * Note that the tasks given are not necessarily the same as those that will be passed to {@link #execute(ClusterState, List)}.  
     * @param <T> the type of the cluster state update task
 */  
     * <p>
     * @param clusterChangedEvent the change event for this cluster state change, containing
         *
                }  
        private static final TaskResult SUCCESS = new TaskResult(null);  
         * @opensearch.api
        }
        /**  
        return ClusterManagerTaskThrottler.DEFAULT_THROTTLING_KEY;  
            return SUCCESS;  
    @PublicApi(since = "1.0.0")  
 * this file be licensed under the Apache-2.0 license or a
    /**  
            private Builder<T> result(T task, TaskResult executionResult) {  
 * Licensed to Elasticsearch under one or more contributor  
    ClusterTasksResult<T> execute(ClusterState currentState, List<T> tasks) throws Exception;
@PublicApi(since = "1.0.0")
 * You may obtain a copy of the License at  
     */  
                return new ClusterTasksResult<>(result.resultingState == null ? previousState : result.resultingState, executionResults);
 */
    /**  
                TaskResult existing = executionResults.put(task, executionResult);
         */  
                for (T task : tasks) {
    /**  
        return String.join(", ", tasks.stream().map(t -> (CharSequence) t.toString()).filter(t -> t.length() > 0)::iterator);
     *  
            this.failure = failure;
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
            private final Map<T, TaskResult> executionResults = new IdentityHashMap<>();  
 * under the License.  
        public static <T> Builder<T> builder() {
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;  
 *
        public static TaskResult failure(Exception failure) {  
import java.util.Map;  
                    failure(task, e);
     */
 * this work for additional information regarding copyright
                return this;
    default ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {  
package org.opensearch.cluster;
 *
        public final Map<T, TaskResult> executionResults;
     * Throttling key associated with the task, on which cluster manager node will do aggregation count  
                assert existing == null : task + " already has result " + existing;
 * Interface that updates the cluster state based on the task  
            ClusterTasksResult<T> build(ClusterTasksResult<T> result, ClusterState previousState) {
     * but are guaranteed to be a subset of them. This method can be called multiple times with different lists before execution.
            public Builder<T> failure(T task, Exception e) {
        public static class Builder<T> {
 * Modifications Copyright OpenSearch Contributors. See  
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
                    success(task);
    /**
                return this;  
         * Builder for cluster state task.  
     * indicates whether this executor should only run if the current node is cluster-manager
    }
        public Exception getFailure() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
            public Builder<T> success(T task) {
import java.util.IdentityHashMap;
 * GitHub history for details.
 * software distributed under the License is distributed on an
         */
    default void clusterStatePublished(ClusterChangedEvent clusterChangedEvent) {}
/*
 * The OpenSearch Contributors require contributions made to  
    /**
        // User can't configure throttling limit on it and will be bypassed while throttling on cluster manager
        public static TaskResult success() {
     *  
        }  
/*
     * should be changed.
        ClusterTasksResult(ClusterState resultingState, Map<T, TaskResult> executionResults) {
            public ClusterTasksResult<T> build(ClusterState resultingState) {  
     * and perform throttling based on configured threshold in cluster setting.
     */
            }  
        public boolean isSuccess() {
    /**
    default boolean runOnlyOnClusterManager() {  
                return result(task, TaskResult.failure(e));
     * This allows groupd task description but the submitting source.
            public Builder<T> failures(Iterable<T> tasks, Exception e) {
    }
public interface ClusterStateTaskExecutor<T> {
            return failure;
 * KIND, either express or implied.  See the License for the
        @Nullable
     */  
    }  
            }
import org.opensearch.common.annotation.PublicApi;
     * this method is not invoked if the cluster state was not updated.  
            }  
        return true;
import java.util.List;
        }
     */
        private TaskResult(Exception failure) {
import org.opensearch.common.Nullable;
    class ClusterTasksResult<T> {
            }
    }
     *                            both old and new states
 * SPDX-License-Identifier: Apache-2.0
         * @param executionResults the correspondence between tasks and their outcome  
 * license agreements. See the NOTICE file distributed with
        }  
        }
 * the Apache License, Version 2.0 (the "License"); you may
     */  
    default String describeTasks(List<T> tasks) {
 * compatible open source license.
     * Callback invoked after new cluster state is published. Note that
 *  
 * Unless required by applicable law or agreed to in writing,
 * @opensearch.api
                return new ClusterTasksResult<>(resultingState, executionResults);
                }
        }
        }  
     * <p>
 * not use this file except in compliance with the License.
            return new Builder<>();
            this.executionResults = executionResults;
     * @opensearch.api
    /**  
        private final Exception failure;
            public Builder<T> successes(Iterable<T> tasks) {  
                return result(task, TaskResult.success());  
     */
     * Builds a concise description of a list of tasks (to be used in logging etc.).
}
/**
         * @param resultingState the resulting cluster state
            }
     * Update the cluster state based on the current state and the given tasks. Return the *same instance* if no state
     * The task result.
                return this;  
 */  
    final class TaskResult {  
     *  
        // Default task is not registered with clusterService.registerClusterMangerTask,
         * Construct an execution result instance with a correspondence between the tasks and their execution result
     * Note that this method will be executed using system context.
        /**
            }
        @PublicApi(since = "1.0.0")
    }
                for (T task : tasks) {  
            return this == SUCCESS;  
