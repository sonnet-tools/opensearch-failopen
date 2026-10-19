 *  
        return priority;
    @Override
 * specific language governing permissions and limitations
    implements  
/*  
/**
    public abstract void onFailure(String source, Exception e);  
        return ""; // one of task, source is enough  
    public final void clusterStatePublished(ClusterChangedEvent clusterChangedEvent) {  
    }
    @Override
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.api
    @Override  
    public ClusterStateUpdateTask(Priority priority) {
        this(Priority.NORMAL);
        ClusterStateTaskConfig,
    /**  
    }  
     */  
        // with a batching executor as it will always be executed within the system context.
 * You may obtain a copy of the License at  
        ClusterStateTaskListener {  
        return null;
    }  
        return ClusterTasksResult.<ClusterStateUpdateTask>builder().successes(tasks).build(result);
 *
import org.opensearch.common.annotation.PublicApi;  
    }
 * Licensed to Elasticsearch under one or more contributor  
 */  
/*  
     */
    /**  
        ClusterStateTaskExecutor<ClusterStateUpdateTask>,
     * Update the cluster state based on the current state. Return the *same instance* if no state
    @Override
    @Nullable  
 * Unless required by applicable law or agreed to in writing,
        ClusterState result = execute(currentState);  
public abstract class ClusterStateUpdateTask
 * GitHub history for details.
     * should be changed.
        return true;
/*
    public String describeTasks(List<ClusterStateUpdateTask> tasks) {
 * compatible open source license.
import org.opensearch.common.Priority;
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
 *
 * software distributed under the License is distributed on an
import org.opensearch.common.Nullable;
 * A task that can update the cluster state.  
import java.util.List;  
    private final Priority priority;
 * not use this file except in compliance with the License.
    }
    public Priority priority() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
     */
     * If the cluster state update task wasn't processed by the provided timeout, call  
    @Override
    /**
    }
 * The OpenSearch Contributors require contributions made to  
    public final ClusterTasksResult<ClusterStateUpdateTask> execute(ClusterState currentState, List<ClusterStateUpdateTask> tasks)
 * SPDX-License-Identifier: Apache-2.0
@PublicApi(since = "1.0.0")
 * the Apache License, Version 2.0 (the "License"); you may
        this.priority = priority;  
        throws Exception {
    public TimeValue timeout() {
    /**
package org.opensearch.cluster;
        // final, empty implementation here as this method should only be defined in combination
}  
     * {@link ClusterStateTaskListener#onFailure(String, Exception)}. May return null to indicate no timeout is needed (default).
 *
    public final boolean runOnlyOnClusterManager() {  
 * this file be licensed under the Apache-2.0 license or a
    }  
 * this work for additional information regarding copyright
     * For local requests, use {@link LocalClusterUpdateTask} instead.  
 */  
import org.opensearch.common.unit.TimeValue;
    }
     */
     * Marked as final as cluster state update tasks should only run on cluster-manager.
    public ClusterStateUpdateTask() {
 */  
 * license agreements. See the NOTICE file distributed with
 * under the License.  
 *     http://www.apache.org/licenses/LICENSE-2.0
    public abstract ClusterState execute(ClusterState currentState) throws Exception;
     * A callback called when execute fails.
