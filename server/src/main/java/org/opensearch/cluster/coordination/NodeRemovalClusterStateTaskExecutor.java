    private final Logger logger;
 */  
        boolean removed = false;
        this.logger = logger;
 */
 * software distributed under the License is distributed on an
    ) {
        private final DiscoveryNode node;
    }
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        logger.error(() -> new ParameterizedMessage("unexpected failure during [{}]", source), e);
 * GitHub history for details.
        ClusterState remainingNodesClusterState
        return resultBuilder.build(allocationService.disassociateDeadNodes(ptasksDisassociatedState, true, describeTasks(tasks)));
        }
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.cluster.coordination;
    // rejoin or reroute is needed
    public static class Task {  
import org.apache.logging.log4j.message.ParameterizedMessage;
            this.node = node;  
 * this file be licensed under the Apache-2.0 license or a
 *
        for (final Task task : tasks) {  
    // visible for testing
 * not use this file except in compliance with the License.
    }
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.routing.allocation.AllocationService;
 * Modifications Copyright OpenSearch Contributors. See  
        }
 *  
    public void onNoLongerClusterManager(String source) {  
import java.util.List;
    // hook is used in testing to ensure that correct cluster state is used to test whether a  
        ClusterStateTaskExecutor<NodeRemovalClusterStateTaskExecutor.Task>,
 * specific language governing permissions and limitations
        this.allocationService = allocationService;
 * You may obtain a copy of the License at  
    @Override
        return ClusterState.builder(currentState).nodes(remainingNodesBuilder).build();  
        return getTaskClusterTasksResult(currentState, tasks, remainingNodesClusterState);
        final ClusterTasksResult.Builder<Task> resultBuilder = ClusterTasksResult.<Task>builder().successes(tasks);
            return reason;  
        @Override  
        }  
        public DiscoveryNode node() {
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Override  
/*
    protected ClusterTasksResult<Task> getTaskClusterTasksResult(
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
        logger.debug("no longer cluster-manager while processing node removal [{}]", source);
 * KIND, either express or implied.  See the License for the
            // no nodes to remove, keep the current cluster state
    }  
        public String reason() {
        List<Task> tasks,  
 * license agreements. See the NOTICE file distributed with
                logger.debug("node [{}] does not exist in cluster state, ignoring", task);
            return node;
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
            }  
            return node + " reason: " + reason;
    implements  
/*  
        final ClusterState remainingNodesClusterState = remainingNodesClusterState(currentState, remainingNodesBuilder);
        public String toString() {
    public NodeRemovalClusterStateTaskExecutor(final AllocationService allocationService, final Logger logger) {  
     */
 * @opensearch.internal  
        final DiscoveryNodes.Builder remainingNodesBuilder = DiscoveryNodes.builder(currentState.nodes());
        if (!removed) {  
}
    }
import org.opensearch.cluster.node.DiscoveryNode;
            } else {
                removed = true;  
import org.opensearch.cluster.ClusterStateTaskExecutor;  
     * @opensearch.internal
        ClusterStateTaskListener {
public class NodeRemovalClusterStateTaskExecutor
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
    public void onFailure(final String source, final Exception e) {
        ClusterState currentState,
 * The OpenSearch Contributors require contributions made to  
    public ClusterTasksResult<Task> execute(final ClusterState currentState, final List<Task> tasks) throws Exception {  
 * Update cluster state when node is removed from the cluster
            this.reason = reason;
    }  
    private final AllocationService allocationService;
        ClusterState ptasksDisassociatedState = PersistentTasksCustomMetadata.disassociateDeadNodes(remainingNodesClusterState);  
 *
 */
/**  
/*
    /**
        public Task(final DiscoveryNode node, final String reason) {
                remainingNodesBuilder.remove(task.node());
     *  
     * Task for the executor.
            return ClusterTasksResult.<Task>builder().successes(tasks).build(currentState);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.ClusterStateTaskListener;
 * under the License.  
import org.opensearch.persistent.PersistentTasksCustomMetadata;
import org.opensearch.cluster.node.DiscoveryNodes;  
 *
    protected ClusterState remainingNodesClusterState(final ClusterState currentState, DiscoveryNodes.Builder remainingNodesBuilder) {
        private final String reason;  
        }
            if (currentState.nodes().nodeExists(task.node())) {
import org.apache.logging.log4j.Logger;  
 */
    }
        }  
        }  
