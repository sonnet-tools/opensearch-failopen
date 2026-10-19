 * You may obtain a copy of the License at  
        Map<String, String> headers
        if (discoveryNode == null) {
 * this file be licensed under the Apache-2.0 license or a
 */
     * <p>  
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**
    protected DiscoveryNode selectLeastLoadedNode(ClusterState clusterState, Predicate<DiscoveryNode> selector) {
    public Assignment getAssignment(Params params, ClusterState clusterState) {
/*  
    }
    /**  
/*  
 * under the License.  
    ) {  
    /**
        long minLoad = Long.MAX_VALUE;  
     * <p>
     */
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
     * Throws an exception if the supplied params cannot be executed on the cluster in the current state.
 */
        return minLoadedNode;
    }
    protected PersistentTasksExecutor(String taskName, String executor) {
 *
 * not use this file except in compliance with the License.
 *
     */  
import java.util.Map;
     */
    /**
/*
        for (DiscoveryNode node : clusterState.getNodes()) {  
        return "id=" + taskInProgress.getId();
     * indicate that the persistent task has finished.  
            if (selector.test(node)) {
        String type,
        }  
import org.opensearch.persistent.PersistentTasksCustomMetadata.PersistentTask;  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.persistent.PersistentTasksCustomMetadata.Assignment;
    }  
     * Finds the least loaded node that satisfies the selector criteria  
        PersistentTask<Params> taskInProgress,
        TaskId parentTaskId,  
     * Checks the current cluster state for compatibility with the params
package org.opensearch.persistent;
import org.opensearch.core.tasks.TaskId;
    public String getExecutor() {
 *
    private final String executor;
import org.opensearch.common.Nullable;  
import org.opensearch.cluster.node.DiscoveryNode;
 * Licensed to Elasticsearch under one or more contributor  
    public static final Assignment NO_NODE_FOUND = new Assignment(null, "no appropriate nodes found for the assignment");
     * The default implementation returns the least loaded data node  
     */
 * KIND, either express or implied.  See the License for the
     * NOTE: The nodeOperation has to throw an exception, trigger task.markAsCompleted() or task.completeAndNotifyIfNeeded() methods to
     */
        return taskName;
    }  
        this.executor = executor;  
                long numberOfTasks = persistentTasks.getNumberOfTasksOnNode(node.getId(), taskName);  
                if (persistentTasks == null) {
 */  
    protected AllocatedPersistentTask createTask(
 * Modifications Copyright OpenSearch Contributors. See
    protected abstract void nodeOperation(AllocatedPersistentTask task, Params params, @Nullable PersistentTaskState state);
    public String getTaskName() {  
 * compatible open source license.
    private final String taskName;
 * GitHub history for details.
import org.opensearch.cluster.ClusterState;
        DiscoveryNode minLoadedNode = null;
        PersistentTasksCustomMetadata persistentTasks = clusterState.getMetadata().custom(PersistentTasksCustomMetadata.TYPE);
    protected String getDescription(PersistentTask<Params> taskInProgress) {
                    // We don't have any task running yet, pick the first available node  
                }
        long id,  
public abstract class PersistentTasksExecutor<Params extends PersistentTaskParams> {
                    minLoad = numberOfTasks;
                }
        } else {  
        DiscoveryNode discoveryNode = selectLeastLoadedNode(clusterState, DiscoveryNode::isDataNode);  
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
    /**
 * @opensearch.internal  
        return executor;
 *  
 */  
 * These tasks are using cluster state rather than only transport service to send requests and responses.
    /**
 * this work for additional information regarding copyright
     */
     * Returns the node id where the params has to be executed,
     * This operation will be executed on the executor node.  
                if (minLoad > numberOfTasks) {
     * Returns task description that will be available via task manager
 * license agreements. See the NOTICE file distributed with
                    minLoadedNode = node;  
    }  
        return new AllocatedPersistentTask(id, type, action, getDescription(taskInProgress), parentTaskId, headers);
    /**
    }
                    return node;
}
 * An executor of tasks that can survive restart of requesting or executing node.  
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.taskName = taskName;
        String action,
    public void validate(Params params, ClusterState clusterState) {}  
            return new Assignment(discoveryNode.getId(), "");
        }
    }
 * the Apache License, Version 2.0 (the "License"); you may
            return NO_NODE_FOUND;
     * <p>
import java.util.function.Predicate;  
     * Creates a AllocatedPersistentTask for communicating with task manager  
 * Unless required by applicable law or agreed to in writing,
