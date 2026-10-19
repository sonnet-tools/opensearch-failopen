            public boolean mustAck(DiscoveryNode discoveryNode) {
        }
                return false;
                latch.countDown();
                return ClusterState.builder(currentState).build();
        assertThat(pendingClusterTasks.get(1).isExecuting(), equalTo(false));
import org.opensearch.common.Nullable;
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class);
            public TimeValue ackTimeout() {
            protected Void newResponse(boolean acknowledged) {
        });
            }
        assertThat(response.pendingTasks().size(), greaterThanOrEqualTo(10));
            @Override
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class);
                } catch (InterruptedException e) {
                ackTimeout.set(true);
                return null;
        final CountDownLatch block1 = new CountDownLatch(1);
        clusterService.submitStateUpdateTask("test", new AckedClusterStateUpdateTask<Void>(null, null) {
 *
    public void testAckedUpdateTaskNoAckExpected() throws Exception {
        String node_0 = internalCluster().startNode();
                ackTimeout.set(true);
        final CountDownLatch invoked3 = new CountDownLatch(1);
            public TimeValue timeout() {
                    invoked2.countDown();
            @Override
            @Override
            @Override
            hasSize(greaterThanOrEqualTo(5))
        assertThat(response.pendingTasks().get(0).getTimeInExecutionInMillis(), greaterThan(0L));
            }
            public void onFailure(String source, Exception e) {
        invoked1.await();
 * Licensed to Elasticsearch under one or more contributor
        final AtomicBoolean allNodesAcked = new AtomicBoolean(false);
                public ClusterState execute(ClusterState currentState) {
            @Override
        });
            public boolean mustAck(DiscoveryNode discoveryNode) {
        final CountDownLatch latch = new CountDownLatch(1);
            }
                processedLatch.countDown();
            }
        final AtomicBoolean onFailure = new AtomicBoolean(false);
                @Override
        invoked2.await();
                return TimeValue.timeValueSeconds(10);
            }
                    fail();
    public void testPendingUpdateTask() throws Exception {
        });
            }
        });
            @Override
        final CountDownLatch invoked1 = new CountDownLatch(1);
            @Override
                return TimeValue.timeValueSeconds(10);
            public boolean mustAck(DiscoveryNode discoveryNode) {
            public void onAckTimeout() {
            clusterService.submitStateUpdateTask(Integer.toString(i), new ClusterStateUpdateTask() {
import static org.hamcrest.Matchers.equalTo;
                return ClusterState.builder(currentState).build();
                public void onFailure(String source, Exception e) {
        assertThat(response.pendingTasks().get(1).getTimeInExecutionInMillis(), equalTo(0L));
                latch.countDown();
        final CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.common.SuppressForbidden;
    }
            public ClusterState execute(ClusterState currentState) {
        for (int i = 2; i <= 10; i++) {
 * software distributed under the License is distributed on an
        assertThat(ackTimeout.get(), equalTo(false));
    public void testAckedUpdateTask() throws Exception {
 * GitHub history for details.
        }
        assertThat(processedLatch.await(1, TimeUnit.SECONDS), equalTo(true));
            }
        assertThat(executed.get(), equalTo(true));
                processedLatch.countDown();
            }
                latch.countDown();
        });
 * this file be licensed under the Apache-2.0 license or a
 */
                    block2.await();
            }
 * under the License.
                logger.error(() -> new ParameterizedMessage("failed to execute callback in test {}", source), e);
import java.util.concurrent.CountDownLatch;
        assertThat(pendingClusterTasks.get(0).getTimeInExecutionInMillis(), greaterThan(0L));
        assertThat(allNodesAcked.get(), equalTo(true));
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.Matchers.greaterThan;
                @Override
        final AtomicBoolean ackTimeout = new AtomicBoolean(false);
            @Override
            public ClusterState execute(ClusterState currentState) throws Exception {
 * ownership. Elasticsearch licenses this file to you under
            public ClusterState execute(ClusterState currentState) {
            clusterService.submitStateUpdateTask(Integer.toString(i), new ClusterStateUpdateTask() {
        Set<String> controlSources = new HashSet<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
            }
 * KIND, either express or implied.  See the License for the
            }
        assertThat(executed.get(), equalTo(true));
                @Override
            @Override
        final AtomicBoolean executed = new AtomicBoolean(false);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                latch.countDown();
        final AtomicBoolean allNodesAcked = new AtomicBoolean(false);
                return false;
            @Override
import static org.hamcrest.Matchers.hasSize;
                    return currentState;
                    fail();
            @Override
                allNodesAcked.set(true);
        assertThat(response.pendingTasks().get(0).getSource().string(), equalTo("1"));
            @Override
        assertThat(latch.await(1, TimeUnit.SECONDS), equalTo(true));
            @Override
            }
            @Override
        }
        assertThat(allNodesAcked.get(), equalTo(true));
            public TimeValue ackTimeout() {
                executed.set(true);
        assertThat(pendingClusterTasks.size(), greaterThanOrEqualTo(10));
            }
        assertThat(processedLatch.await(1, TimeUnit.SECONDS), equalTo(true));
        assertThat(latch.await(1, TimeUnit.SECONDS), equalTo(true));
        ensureGreen();
    }
/*
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
        for (PendingClusterTask task : pendingClusterTasks) {
 * this work for additional information regarding copyright
            protected Void newResponse(boolean acknowledged) {
                processedLatch.countDown();
        for (PendingClusterTask task : pendingClusterTasks) {
        internalCluster().startNode();
            }
                public ClusterState execute(ClusterState currentState) {
            @Override
        }
        assertBusy(() -> assertTrue("Pending tasks not empty", clusterService.getClusterManagerService().pendingTasks().isEmpty()));
        final AtomicBoolean onFailure = new AtomicBoolean(false);
            public TimeValue ackTimeout() {
            @Override
                logger.error(() -> new ParameterizedMessage("failed to execute callback in test {}", source), e);
        ensureGreen();
        internalCluster().startNode();
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
import org.opensearch.common.unit.TimeValue;
                return TimeValue.timeValueSeconds(10);
            @Override
            }
            @Override
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {}
import java.util.concurrent.TimeUnit;
                try {
        controlSources = new HashSet<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
                return ClusterState.builder(currentState).build();
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class);
            @Override
            }
        assertThat(pendingClusterTasks.get(0).isExecuting(), equalTo(true));
            @Override
            @Override
                latch.countDown();
            @Override
            controlSources.remove(task.getSource().string());
        controlSources = new HashSet<>(Arrays.asList("1", "2", "3", "4", "5"));
        assertThat(executed.get(), equalTo(true));
 *    http://www.apache.org/licenses/LICENSE-2.0
                return null;
        assertThat(allNodesAcked.get(), equalTo(true));
 * The OpenSearch Contributors require contributions made to
            }
            }
            }
            });
                return TimeValue.timeValueSeconds(10);
                latch.countDown();
        assertThat(onFailure.get(), equalTo(false));
 *
        final AtomicBoolean executed = new AtomicBoolean(false);
            }
            @Override
            }
            }
            @Override
                invoked3.countDown();
            public void onAllNodesAcked(@Nullable Exception e) {
        invoked3.await();
                    Thread.sleep(50);
            public TimeValue timeout() {
        final CountDownLatch block2 = new CountDownLatch(1);
        final AtomicBoolean ackTimeout = new AtomicBoolean(false);
        for (int i = 2; i <= 5; i++) {
        final AtomicBoolean ackTimeout = new AtomicBoolean(false);
        clusterService.submitStateUpdateTask("1", new ClusterStateUpdateTask() {
        final CountDownLatch processedLatch = new CountDownLatch(1);
            protected Void newResponse(boolean acknowledged) {
            public void onAckTimeout() {
            protected Void newResponse(boolean acknowledged) {
        pendingClusterTasks = await().until(
        // whenever we test for no tasks, we need to wait since this is a live node
        final AtomicBoolean allNodesAcked = new AtomicBoolean(false);
import org.opensearch.cluster.ClusterStateUpdateTask;
            @Override
import static org.awaitility.Awaitility.await;
        assertThat(response.pendingTasks().size(), greaterThanOrEqualTo(5));
            @Override
 * specific language governing permissions and limitations
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
    }
            }
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        controlSources = new HashSet<>(Arrays.asList("1", "2", "3", "4", "5"));
                return TimeValue.timeValueSeconds(10);
            });
        clusterService.submitStateUpdateTask("test", new AckedClusterStateUpdateTask<Void>(null, null) {
        assertThat(onFailure.get(), equalTo(false));
        assertThat(ackTimeout.get(), equalTo(false));
            public void onAckTimeout() {
                }
/*
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
            @Override
                return TimeValue.timeValueSeconds(10);
        assertThat(processedLatch.await(1, TimeUnit.SECONDS), equalTo(true));
            @Override
                }
    public void testAckedUpdateTaskSameClusterState() throws Exception {
        assertThat(executed.get(), equalTo(true));
                return TimeValue.timeValueSeconds(10);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        );
package org.opensearch.cluster.service;
            @Override
                }
            }
            }
        assertThat(allNodesAcked.get(), equalTo(false));
import java.util.List;
            public void onAllNodesAcked(@Nullable Exception e) {
                    return currentState;
            public void onAllNodesAcked(@Nullable Exception e) {
                latch.countDown();
import org.apache.logging.log4j.message.ParameterizedMessage;
                ackTimeout.set(true);
            @SuppressForbidden(reason = "Sleeping to guarantee a >0 time metric calculation")
            public void onFailure(String source, Exception e) {
        // The tasks can be re-ordered, so we need to check out-of-order
                allNodesAcked.set(true);
        clusterService.submitStateUpdateTask("test", new AckedClusterStateUpdateTask<Void>(null, null) {
                ackTimeout.set(true);
        assertThat(response.pendingTasks().get(1).isExecuting(), equalTo(false));
        });
        PendingClusterTasksResponse response = internalCluster().coordOnlyNodeClient().admin().cluster().preparePendingClusterTasks().get();
            }
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                executed.set(true);
 */
        response = internalCluster().coordOnlyNodeClient().admin().cluster().preparePendingClusterTasks().get();
        waitNoPendingTasksOnAll();
/*
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        assertTrue(controlSources.isEmpty());
                allNodesAcked.set(true);
                onFailure.set(true);
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
 * SPDX-License-Identifier: Apache-2.0
        // there might be other tasks in this node, make sure to only take the ones we add into account in this test
                return null;
                @Override
            public void onAllNodesAcked(@Nullable Exception e) {
        final ClusterService clusterService = internalCluster().getInstance(ClusterService.class, node_0);
        final AtomicBoolean onFailure = new AtomicBoolean(false);
                return currentState;
            controlSources.remove(task.getSource().string());
import org.opensearch.cluster.AckedClusterStateUpdateTask;
            @Override
            }
    }
    public void testAckedUpdateTaskTimeoutZero() throws Exception {
        assertThat(pendingClusterTasks.get(0).getSource().string(), equalTo("1"));
                executed.set(true);
        for (PendingClusterTask task : response) {
            }
            }
                assertThat(task.getTimeInQueueInMillis(), greaterThan(0L));
            }
            }
        final CountDownLatch latch = new CountDownLatch(1);
                }
                }
        }
                onFailure.set(true);
            public ClusterState execute(ClusterState currentState) throws Exception {
        assertThat(response.pendingTasks().get(0).isExecuting(), equalTo(true));
        ensureGreen();
import org.opensearch.cluster.ClusterState;
                try {
                onFailure.set(true);
            public TimeValue timeout() {
                invoked3.countDown();
            }
            @Override
                }
        final AtomicBoolean executed = new AtomicBoolean(false);
                executed.set(true);
                fail();
    }
        final CountDownLatch processedLatch = new CountDownLatch(1);
 */
            }
            }
        for (PendingClusterTask task : response) {
 * Modifications Copyright OpenSearch Contributors. See
        final AtomicBoolean allNodesAcked = new AtomicBoolean(false);
        assertTrue(controlSources.isEmpty());
        assertThat(latch.await(1, TimeUnit.SECONDS), equalTo(true));
        assertThat(ackTimeout.get(), equalTo(false));
            public TimeValue timeout() {
        clusterService.submitStateUpdateTask("test", new AckedClusterStateUpdateTask<Void>(null, null) {
                latch.countDown();
                return true;
import java.util.HashSet;
        internalCluster().startCoordinatingOnlyNode(Settings.EMPTY);
            public ClusterState execute(ClusterState currentState) throws Exception {
            public TimeValue ackTimeout() {
        List<PendingClusterTask> pendingClusterTasks = clusterService.getClusterManagerService().pendingTasks();
        clusterService.submitStateUpdateTask("1", new ClusterStateUpdateTask() {
 * the Apache License, Version 2.0 (the "License"); you may
            if (controlSources.remove(task.getSource().string())) {
public class ClusterServiceIT extends OpenSearchIntegTestCase {
 *
                return currentState;
                } catch (InterruptedException e) {
                latch.countDown();
 * not use this file except in compliance with the License.
            }
                fail();
                logger.error(() -> new ParameterizedMessage("failed to execute callback in test {}", source), e);
        block2.countDown();
        assertTrue(controlSources.isEmpty());
        assertThat(pendingClusterTasks.get(1).getTimeInExecutionInMillis(), equalTo(0L));
        final CountDownLatch latch = new CountDownLatch(1);
        assertThat(onFailure.get(), equalTo(false));
 * Unless required by applicable law or agreed to in writing,
        internalCluster().startNode();
import org.opensearch.test.OpenSearchIntegTestCase;
        assertThat(latch.await(1, TimeUnit.SECONDS), equalTo(true));
}
            controlSources.remove(task.getSource().string());
        internalCluster().startNode();
import java.util.Arrays;
        block1.countDown();
                    invoked1.countDown();
                }
                latch.countDown();
import org.opensearch.cluster.node.DiscoveryNode;
            @Override
            @Override
                @Override
        assertThat(ackTimeout.get(), equalTo(true));
                public void onFailure(String source, Exception e) {
            }
                return TimeValue.timeValueSeconds(0);
                invoked1.countDown();
            public void onFailure(String source, Exception e) {
            }
            @Override
 * You may obtain a copy of the License at
                latch.countDown();
        assertTrue(controlSources.isEmpty());
                allNodesAcked.set(true);
            @Override
import org.opensearch.common.settings.Settings;
                return null;
                    block1.await();
import org.opensearch.action.admin.cluster.tasks.PendingClusterTasksResponse;
                    fail();
            }
            () -> clusterService.getClusterManagerService().pendingTasks(),
        final AtomicBoolean ackTimeout = new AtomicBoolean(false);
        final AtomicBoolean executed = new AtomicBoolean(false);
            public void onFailure(String source, Exception e) {
                logger.error(() -> new ParameterizedMessage("failed to execute callback in test {}", source), e);
            public ClusterState execute(ClusterState currentState) throws Exception {
            @Override
                latch.countDown();
        }
        assertThat(onFailure.get(), equalTo(false));
                    fail();
        final CountDownLatch processedLatch = new CountDownLatch(1);
            @Override
            @Override
            public void onAckTimeout() {
        final CountDownLatch invoked2 = new CountDownLatch(9);
            public void onFailure(String source, Exception e) {
            }
                return currentState;
 * compatible open source license.
                onFailure.set(true);
        final AtomicBoolean onFailure = new AtomicBoolean(false);
            public void onFailure(String source, Exception e) {
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class);
            @Override
        ensureGreen();
