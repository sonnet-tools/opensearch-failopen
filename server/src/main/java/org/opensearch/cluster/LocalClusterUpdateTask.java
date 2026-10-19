 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
    }
        ClusterStateTaskListener {  
 * ownership. Elasticsearch licenses this file to you under  
 *
/*
    public abstract ClusterTasksResult<LocalClusterUpdateTask> execute(ClusterState currentState) throws Exception;  
 */  
package org.opensearch.cluster;
 * The OpenSearch Contributors require contributions made to  
    implements  
    }
    public final ClusterTasksResult<LocalClusterUpdateTask> execute(ClusterState currentState, List<LocalClusterUpdateTask> tasks)  
        return null;  
        this(Priority.NORMAL);
    public LocalClusterUpdateTask() {
import org.opensearch.common.Nullable;  
    public Priority priority() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
    @Nullable
 * Used to apply state updates on nodes that are not necessarily cluster-manager
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.priority = priority;  
/*
 * You may obtain a copy of the License at  
        ClusterTasksResult<LocalClusterUpdateTask> result = execute(currentState);  
 * compatible open source license.
 */
    @Override  
    @Override
    public String describeTasks(List<LocalClusterUpdateTask> tasks) {  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
import org.opensearch.common.unit.TimeValue;
    public final boolean runOnlyOnClusterManager() {  
        return new ClusterTasksResult<>(null, null);
 * Unless required by applicable law or agreed to in writing,
     * no changes were made to the cluster state. Useful to execute a runnable on the cluster state applier thread
 */
/**  
    /**
    private final Priority priority;
    public TimeValue timeout() {
        return ClusterTasksResult.<LocalClusterUpdateTask>builder().successes(tasks).build(result, currentState);
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See  
    public LocalClusterUpdateTask(Priority priority) {
    public static ClusterTasksResult<LocalClusterUpdateTask> unchanged() {
        ClusterStateTaskConfig,
    }
    @Override
        return ""; // one of task, source is enough
import org.opensearch.common.Priority;
        return false;
 */
    }  
public abstract class LocalClusterUpdateTask
    }  
}  
 * specific language governing permissions and limitations
        throws Exception {
 * Licensed to Elasticsearch under one or more contributor  
import java.util.List;
 * GitHub history for details.
        ClusterStateTaskExecutor<LocalClusterUpdateTask>,
 * KIND, either express or implied.  See the License for the
        return priority;
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
        assert tasks.size() == 1 && tasks.get(0) == this : "expected one-element task list containing current object but was " + tasks;
 * this work for additional information regarding copyright
    }
 *
    }
 * license agreements. See the NOTICE file distributed with
 *
     */  
 * @opensearch.internal  
 *  
