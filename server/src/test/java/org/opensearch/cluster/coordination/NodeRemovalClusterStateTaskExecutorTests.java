 * Modifications Copyright OpenSearch Contributors. See
        final DiscoveryNodes.Builder builder = DiscoveryNodes.builder();
import static org.mockito.Mockito.verify;
 * software distributed under the License is distributed on an
 * GitHub history for details.
        final NodeRemovalClusterStateTaskExecutor executor = new NodeRemovalClusterStateTaskExecutor(null, logger);
package org.opensearch.cluster.coordination;
 * Unless required by applicable law or agreed to in writing,
            }
        final DiscoveryNodes.Builder builder = DiscoveryNodes.builder();  
import org.opensearch.cluster.node.DiscoveryNode;
 */
    public void testRemovingNonExistentNodes() throws Exception {
        final DiscoveryNodes.Builder removeBuilder = DiscoveryNodes.builder();
 * this work for additional information regarding copyright
        }
 * KIND, either express or implied.  See the License for the
            clusterState,
import org.opensearch.test.OpenSearchTestCase;
import java.util.concurrent.atomic.AtomicReference;  
        boolean first = true;
 */  
/*  
 *
        final NodeRemovalClusterStateTaskExecutor executor = new NodeRemovalClusterStateTaskExecutor(allocationService, logger) {
            .map(node -> new NodeRemovalClusterStateTaskExecutor.Task(node, randomBoolean() ? "left" : "failed"))  
        }
    }
        }
import org.opensearch.cluster.ClusterName;
/*  
            im -> im.getArguments()[0]
 * You may obtain a copy of the License at  
    }  
        }
        final AtomicReference<ClusterState> remainingNodesClusterState = new AtomicReference<>();
            assertNull(result.resultingState.nodes().get(task.node().getId()));  
        for (int i = 0; i < nodes; i++) {  
        );  
import org.opensearch.cluster.routing.allocation.AllocationService;
            tasks  
        // to ensure that there is at least one removal
            }
        final ClusterState clusterState = ClusterState.builder(new ClusterName("test")).nodes(builder).build();
    private DiscoveryNode node(final int id) {
        for (final NodeRemovalClusterStateTaskExecutor.Task task : tasks) {
        for (int i = 0; i < nodes; i++) {
import java.util.List;
        final AllocationService allocationService = mock(AllocationService.class);
        final int nodes = randomIntBetween(2, 16);
 * under the License.  
import static org.mockito.Mockito.when;  
        );
            tasks
        return new DiscoveryNode(Integer.toString(id), buildNewFakeTransportAddress(), Version.CURRENT);
/*
            @Override  
        final List<NodeRemovalClusterStateTaskExecutor.Task> tasks = StreamSupport.stream(removeBuilder.build().spliterator(), false)
            .collect(Collectors.toList());
public class NodeRemovalClusterStateTaskExecutorTests extends OpenSearchTestCase {
import static org.hamcrest.CoreMatchers.equalTo;
import org.opensearch.cluster.ClusterStateTaskExecutor;
            first = false;  
 * compatible open source license.
        when(allocationService.disassociateDeadNodes(any(ClusterState.class), eq(true), any(String.class))).thenAnswer(  
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
        final List<NodeRemovalClusterStateTaskExecutor.Task> tasks = new ArrayList<>();  
            final DiscoveryNode node = node(i);
        verify(allocationService).disassociateDeadNodes(eq(remainingNodesClusterState.get()), eq(true), any(String.class));  
    }
 */  
        for (int i = nodes; i < nodes + randomIntBetween(1, 16); i++) {
import org.opensearch.cluster.node.DiscoveryNodes;  
                tasks.add(new NodeRemovalClusterStateTaskExecutor.Task(node, randomBoolean() ? "left" : "failed"));
import org.opensearch.cluster.ClusterState;  
 * The OpenSearch Contributors require contributions made to  
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;  
import java.util.ArrayList;
import java.util.stream.Collectors;
 * license agreements. See the NOTICE file distributed with
import static org.mockito.Mockito.mock;
                return remainingNodesClusterState.get();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            builder.add(node(i));  
}
        final ClusterStateTaskExecutor.ClusterTasksResult<NodeRemovalClusterStateTaskExecutor.Task> result = executor.execute(
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
        final ClusterStateTaskExecutor.ClusterTasksResult<NodeRemovalClusterStateTaskExecutor.Task> result = executor.execute(  
        final ClusterState clusterState = ClusterState.builder(new ClusterName("test")).nodes(builder).build();
            builder.add(node);
                remainingNodesClusterState.set(super.remainingNodesClusterState(currentState, remainingNodesBuilder));
 * this file be licensed under the Apache-2.0 license or a
        );
        };
            protected ClusterState remainingNodesClusterState(ClusterState currentState, DiscoveryNodes.Builder remainingNodesBuilder) {
import java.util.stream.StreamSupport;
 *     http://www.apache.org/licenses/LICENSE-2.0
        final int nodes = randomIntBetween(2, 16);
            if (first || randomBoolean()) {  
    public void testRerouteAfterRemovingNodes() throws Exception {
import org.opensearch.Version;
 *
            clusterState,
 *  
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(result.resultingState, equalTo(clusterState));
            removeBuilder.add(node(i));  
